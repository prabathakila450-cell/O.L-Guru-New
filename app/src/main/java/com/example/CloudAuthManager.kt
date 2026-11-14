package com.example

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.util.Base64
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.Source
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull
import java.io.ByteArrayOutputStream
import java.io.IOException
import kotlin.coroutines.resume

object CloudAuthManager {
    private const val TAG = "CloudAuthManager"
    private const val COLLECTION_USERS = "users"
    private const val COLLECTION_TRIAL_DEVICES = "trial_devices"
    private var isSettingsConfigured = false

    fun hasProperInternet(context: Context): Boolean {
        return try {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
                ?: return false
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val network = cm.activeNetwork ?: return false
                val caps = cm.getNetworkCapabilities(network) ?: return false
                caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                    caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
            } else {
                @Suppress("DEPRECATION")
                cm.activeNetworkInfo?.isConnected == true
            }
        } catch (_: Throwable) {
            false
        }
    }

    private suspend fun awaitNetworkReturn(context: Context, maxWaitMs: Long = 1500L) {
        if (hasProperInternet(context)) return
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
            if (cm == null) {
                delay(maxWaitMs)
                return
            }
            var registeredCallback: ConnectivityManager.NetworkCallback? = null
            try {
                withTimeoutOrNull(maxWaitMs) {
                    suspendCancellableCoroutine<Unit> { cont ->
                        val callback = object : ConnectivityManager.NetworkCallback() {
                            override fun onCapabilitiesChanged(network: Network, caps: NetworkCapabilities) {
                                if (caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                                    caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED) &&
                                    cont.isActive
                                ) {
                                    cont.resume(Unit)
                                }
                            }

                            override fun onAvailable(network: Network) {
                                if (hasProperInternet(context) && cont.isActive) {
                                    cont.resume(Unit)
                                }
                            }
                        }
                        registeredCallback = callback
                        try {
                            cm.registerDefaultNetworkCallback(callback)
                        } catch (_: Throwable) {
                            if (cont.isActive) cont.resume(Unit)
                        }
                    }
                }
            } finally {
                registeredCallback?.let { cb ->
                    try {
                        cm.unregisterNetworkCallback(cb)
                    } catch (_: Throwable) {}
                }
            }
            if (!hasProperInternet(context)) {
                delay(400L)
            }
        } else {
            delay(maxWaitMs)
        }
    }

    fun isTransientNetworkError(error: Throwable?): Boolean {
        if (error == null) return false
        if (error is TimeoutCancellationException || error is FirebaseNetworkException || error is IOException) {
            return true
        }
        if (error is FirebaseFirestoreException) {
            return when (error.code) {
                FirebaseFirestoreException.Code.UNAVAILABLE,
                FirebaseFirestoreException.Code.DEADLINE_EXCEEDED,
                FirebaseFirestoreException.Code.UNKNOWN,
                FirebaseFirestoreException.Code.ABORTED,
                FirebaseFirestoreException.Code.RESOURCE_EXHAUSTED,
                FirebaseFirestoreException.Code.INTERNAL -> true
                else -> false
            }
        }
        val msg = (error.message ?: "").lowercase()
        return msg.contains("network") ||
            msg.contains("offline") ||
            msg.contains("unavailable") ||
            msg.contains("timeout") ||
            msg.contains("timed out") ||
            msg.contains("resolve") ||
            msg.contains("connection") ||
            msg.contains("client is offline")
    }

    suspend fun <T> awaitProperInternetAndRun(
        context: Context,
        onStatusUpdate: (waitingForInternet: Boolean, statusMessage: String) -> Unit,
        block: suspend () -> Result<T>
    ): Result<T> {
        while (currentCoroutineContext().isActive) {
            if (!hasProperInternet(context)) {
                onStatusUpdate(
                    true,
                    "අන්තර්ජාල සබඳතාව අවශ්‍යයි! නියමිත මට්ටමේ අන්තර්ජාල සබඳතාවක් ලැබෙන තෙක් කැරකෙමින් රැඳී සිටී... (සිග්නල් ලැබුණු වහාම 100%ක් නිවැරදිවම යැවෙනු ඇත)"
                )
                awaitNetworkReturn(context, 1500L)
                continue
            }

            onStatusUpdate(
                false,
                "Cloud Server සමඟ සම්බන්ධ වී 100% තහවුරු කරමින්..."
            )
            val result = try {
                block()
            } catch (ce: CancellationException) {
                throw ce
            } catch (t: Throwable) {
                Result.failure(t)
            }

            if (result.isSuccess) {
                return result
            }

            val err = result.exceptionOrNull()
            if (err is CancellationException) throw err

            if (!hasProperInternet(context) || isTransientNetworkError(err)) {
                onStatusUpdate(
                    true,
                    "අන්තර්ජාල සබඳතාව ප්‍රමාණවත් නොවේ (දුර්වල සිග්නල්)! නියමිත මට්ටමේ අන්තර්ජාල සබඳතාවක් ලැබෙන තෙක් කැරකෙමින් රැඳී සිටී..."
                )
                awaitNetworkReturn(context, 1800L)
            } else {
                return result
            }
        }
        return Result.failure(CancellationException("Cancelled"))
    }

    private fun getFirestore(context: Context): FirebaseFirestore? {
        return try {
            if (FirebaseApp.getApps(context).isEmpty()) {
                FirebaseApp.initializeApp(context)
            }
            if (FirebaseApp.getApps(context).isEmpty()) {
                Log.w(TAG, "FirebaseApp is not initialized (missing google-services.json); cloud sync skipped.")
                return null
            }
            val dbId = context.getString(R.string.firestore_database_id)
            val db = FirebaseFirestore.getInstance(dbId)
            if (!isSettingsConfigured) {
                try {
                    val settings = FirebaseFirestoreSettings.Builder()
                        .setPersistenceEnabled(true)
                        .build()
                    db.firestoreSettings = settings
                    isSettingsConfigured = true
                } catch (e: Exception) {
                    // Settings can only be set before any other operations on the instance, or if already set
                    Log.d(TAG, "Firestore settings already configured or set: ${e.localizedMessage}")
                    isSettingsConfigured = true
                }
            }
            db
        } catch (e: Throwable) {
            Log.w(TAG, "Firestore unavailable on this build: ${e.localizedMessage}")
            null
        }
    }

    fun isCloudAvailable(context: Context): Boolean {
        return getFirestore(context) != null
    }

    fun normalizePhoneKey(usernameOrPhone: String): String {
        val raw = usernameOrPhone.trim().lowercase().replace("+", "").replace(" ", "").replace("-", "")
        return if (raw.startsWith("94") && raw.length == 11) {
            "0" + raw.substring(2)
        } else {
            raw
        }
    }

    private fun buildDocId(usernameOrPhone: String): String {
        return normalizePhoneKey(usernameOrPhone)
    }

    private fun parseUserDocument(doc: com.google.firebase.firestore.DocumentSnapshot): UserAccount? {
        val parsed = doc.toObject(UserAccount::class.java) ?: return null
        val rawApproved = doc.getBoolean("isApproved") ?: doc.getBoolean("approved") ?: parsed.isApproved
        return parsed.copy(isApproved = rawApproved)
    }

    suspend fun syncUserToCloud(context: Context, user: UserAccount): Result<Unit> {
        return try {
            val db = getFirestore(context)
                ?: return Result.failure(IllegalStateException("Firebase Cloud සැකසුම් (google-services.json) මෙම APK ගොනුවේ නොමැත."))
            val docId = buildDocId(user.usernameOrPhone)
            if (docId.isBlank()) {
                return Result.failure(IllegalArgumentException("දුරකථන අංකය හිස්ය."))
            }

            db.collection(COLLECTION_USERS).document(docId).set(user).await()
            Log.d(TAG, "User synced to cloud: $docId (isApproved=${user.isApproved})")
            Result.success(Unit)
        } catch (e: Exception) {
            Log.e(TAG, "Error syncing user to cloud", e)
            Result.failure(e)
        }
    }

    suspend fun syncUserToCloudVerified(context: Context, user: UserAccount): Result<Unit> {
        return try {
            if (!hasProperInternet(context)) {
                return Result.failure(IOException("No validated internet connection"))
            }
            val db = getFirestore(context)
                ?: return Result.failure(IllegalStateException("Firebase Cloud සැකසුම් (google-services.json) මෙම APK ගොනුවේ නොමැත."))
            val docId = buildDocId(user.usernameOrPhone)
            if (docId.isBlank()) {
                return Result.failure(IllegalArgumentException("දුරකථන අංකය හිස්ය."))
            }
            val docRef = db.collection(COLLECTION_USERS).document(docId)
            withTimeout(15_000L) {
                docRef.set(user).await()
            }
            val verifySnap = withTimeout(10_000L) {
                docRef.get(Source.SERVER).await()
            }
            if (!verifySnap.exists()) {
                return Result.failure(IOException("Cloud server verification failed; retrying"))
            }
            val remoteApproved = verifySnap.getBoolean("isApproved") ?: verifySnap.getBoolean("approved")
            if (remoteApproved != null && remoteApproved != user.isApproved) {
                return Result.failure(IOException("Cloud state mismatch; retrying"))
            }
            Log.d(TAG, "User verified on Cloud Server: $docId (isApproved=${user.isApproved})")
            Result.success(Unit)
        } catch (ce: CancellationException) {
            throw ce
        } catch (e: Exception) {
            Log.e(TAG, "Error verifying user sync on cloud server", e)
            Result.failure(e)
        }
    }

    /**
     * Only uploads the user record if the document does not already exist in Firestore.
     * Prevents stale local state (e.g. isApproved = false) from overwriting an Admin's cloud approval.
     */
    suspend fun syncUserIfMissing(context: Context, user: UserAccount) {
        try {
            val db = getFirestore(context) ?: return
            val docId = buildDocId(user.usernameOrPhone)
            if (docId.isBlank()) return

            val docRef = db.collection(COLLECTION_USERS).document(docId)
            val snapshot = docRef.get().await()
            if (!snapshot.exists()) {
                docRef.set(user).await()
                Log.d(TAG, "Missing user uploaded to cloud: $docId")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error checking/syncing missing user to cloud", e)
        }
    }

    suspend fun fetchUserFromCloud(context: Context, usernameOrPhone: String): Result<UserAccount?> {
        return try {
            val db = getFirestore(context)
                ?: return Result.failure(IllegalStateException("Firebase Cloud සැකසුම් (google-services.json) මෙම APK ගොනුවේ නොමැත."))
            val docId = buildDocId(usernameOrPhone)
            if (docId.isBlank()) return Result.success(null)

            val docRef = db.collection(COLLECTION_USERS).document(docId)
            val snapshot = try {
                docRef.get(Source.SERVER).await()
            } catch (_: Exception) {
                docRef.get().await()
            }
            if (snapshot.exists()) {
                Result.success(parseUserDocument(snapshot))
            } else {
                // Fallback check for legacy non-normalized 94-prefixed document ID
                val legacyId = usernameOrPhone.trim().lowercase().replace("+", "").replace(" ", "")
                if (legacyId.isNotBlank() && legacyId != docId) {
                    val legacySnap = try {
                        db.collection(COLLECTION_USERS).document(legacyId).get(Source.SERVER).await()
                    } catch (_: Exception) {
                        db.collection(COLLECTION_USERS).document(legacyId).get().await()
                    }
                    if (legacySnap.exists()) {
                        return Result.success(parseUserDocument(legacySnap))
                    }
                }
                Result.success(null)
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching user from cloud", e)
            Result.failure(e)
        }
    }

    suspend fun fetchUserFromCloudStrict(context: Context, usernameOrPhone: String): Result<UserAccount?> {
        return try {
            if (!hasProperInternet(context)) {
                return Result.failure(IOException("No validated internet connection"))
            }
            val db = getFirestore(context)
                ?: return Result.failure(IllegalStateException("Firebase Cloud සැකසුම් (google-services.json) මෙම APK ගොනුවේ නොමැත."))
            val docId = buildDocId(usernameOrPhone)
            if (docId.isBlank()) return Result.success(null)

            val docRef = db.collection(COLLECTION_USERS).document(docId)
            val snapshot = withTimeout(12_000L) { docRef.get(Source.SERVER).await() }
            if (snapshot.exists()) {
                Result.success(parseUserDocument(snapshot))
            } else {
                val legacyId = usernameOrPhone.trim().lowercase().replace("+", "").replace(" ", "")
                if (legacyId.isNotBlank() && legacyId != docId) {
                    val legacySnap = withTimeout(10_000L) {
                        db.collection(COLLECTION_USERS).document(legacyId).get(Source.SERVER).await()
                    }
                    if (legacySnap.exists()) {
                        return Result.success(parseUserDocument(legacySnap))
                    }
                }
                Result.success(null)
            }
        } catch (ce: CancellationException) {
            throw ce
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching user strictly from cloud server", e)
            Result.failure(e)
        }
    }

    suspend fun fetchAllUsersFromCloud(context: Context): Result<List<UserAccount>> {
        return try {
            val db = getFirestore(context)
                ?: return Result.failure(IllegalStateException("Firebase Cloud සැකසුම් (google-services.json) මෙම APK ගොනුවේ නොමැත."))
            val snapshot = try {
                db.collection(COLLECTION_USERS).get(Source.SERVER).await()
            } catch (_: Exception) {
                db.collection(COLLECTION_USERS).get().await()
            }
            val users = snapshot.documents.mapNotNull { parseUserDocument(it) }
            Result.success(users)
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching all users from cloud", e)
            Result.failure(e)
        }
    }

    suspend fun fetchAllUsersFromCloudStrict(context: Context): Result<List<UserAccount>> {
        return try {
            if (!hasProperInternet(context)) {
                return Result.failure(IOException("No validated internet connection"))
            }
            val db = getFirestore(context)
                ?: return Result.failure(IllegalStateException("Firebase Cloud සැකසුම් (google-services.json) මෙම APK ගොනුවේ නොමැත."))
            val snapshot = withTimeout(15_000L) {
                db.collection(COLLECTION_USERS).get(Source.SERVER).await()
            }
            val users = snapshot.documents.mapNotNull { parseUserDocument(it) }
            Result.success(users)
        } catch (ce: CancellationException) {
            throw ce
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching all users strictly from cloud server", e)
            Result.failure(e)
        }
    }

    suspend fun deleteUserFromCloud(context: Context, usernameOrPhone: String): Result<Unit> {
        return try {
            val db = getFirestore(context)
                ?: return Result.failure(IllegalStateException("Firebase Cloud unavailable"))
            val docId = buildDocId(usernameOrPhone)
            if (docId.isBlank()) return Result.success(Unit)

            db.collection(COLLECTION_USERS).document(docId).delete().await()
            val legacyId = usernameOrPhone.trim().lowercase().replace("+", "").replace(" ", "")
            if (legacyId.isNotBlank() && legacyId != docId) {
                try {
                    db.collection(COLLECTION_USERS).document(legacyId).delete().await()
                } catch (_: Exception) {}
            }
            Log.d(TAG, "User deleted from cloud: $docId")
            Result.success(Unit)
        } catch (e: Exception) {
            Log.e(TAG, "Error deleting user from cloud", e)
            Result.failure(e)
        }
    }

    suspend fun deleteUserFromCloudVerified(context: Context, usernameOrPhone: String): Result<Unit> {
        return try {
            if (!hasProperInternet(context)) {
                return Result.failure(IOException("No validated internet connection"))
            }
            val db = getFirestore(context)
                ?: return Result.failure(IllegalStateException("Firebase Cloud unavailable"))
            val docId = buildDocId(usernameOrPhone)
            if (docId.isBlank()) return Result.success(Unit)

            val docRef = db.collection(COLLECTION_USERS).document(docId)
            withTimeout(15_000L) { docRef.delete().await() }
            val legacyId = usernameOrPhone.trim().lowercase().replace("+", "").replace(" ", "")
            if (legacyId.isNotBlank() && legacyId != docId) {
                try {
                    withTimeout(10_000L) { db.collection(COLLECTION_USERS).document(legacyId).delete().await() }
                } catch (_: Exception) {}
            }
            val checkSnap = withTimeout(10_000L) { docRef.get(Source.SERVER).await() }
            if (checkSnap.exists()) {
                return Result.failure(IOException("Cloud delete verification failed"))
            }
            Log.d(TAG, "User verified deleted from cloud server: $docId")
            Result.success(Unit)
        } catch (ce: CancellationException) {
            throw ce
        } catch (e: Exception) {
            Log.e(TAG, "Error verifying user deletion from cloud", e)
            Result.failure(e)
        }
    }

    fun observeAllUsers(context: Context): Flow<List<UserAccount>> = callbackFlow {
        var listener: ListenerRegistration? = null
        try {
            val db = getFirestore(context)
            if (db == null) {
                close()
            } else {
                listener = db.collection(COLLECTION_USERS)
                    .addSnapshotListener { snapshot, error ->
                        if (error != null) {
                            Log.e(TAG, "Error observing users", error)
                            close(error)
                            return@addSnapshotListener
                        }
                        val users = snapshot?.documents?.mapNotNull { doc ->
                            parseUserDocument(doc)
                        } ?: emptyList()
                        trySend(users)
                    }
            }
        } catch (e: Throwable) {
            Log.e(TAG, "Failed to attach Firestore user observer", e)
            close(e)
        }
        awaitClose { listener?.remove() }
    }

    suspend fun updateUserApproval(context: Context, usernameOrPhone: String, isApproved: Boolean, timestamp: Long?): Result<Unit> {
        return try {
            val db = getFirestore(context)
                ?: return Result.failure(IllegalStateException("Firebase Cloud unavailable"))
            val docId = buildDocId(usernameOrPhone)
            if (docId.isBlank()) return Result.failure(IllegalArgumentException("Blank user key"))
            db.collection(COLLECTION_USERS).document(docId).update(
                mapOf(
                    "isApproved" to isApproved,
                    "paymentStatus" to if (isApproved) "Approved" else "Pending Approval",
                    "approvalTimestamp" to timestamp
                )
            ).await()
            Log.d(TAG, "User approval updated in cloud: $docId")
            Result.success(Unit)
        } catch (e: Exception) {
            Log.e(TAG, "Error updating user approval in cloud", e)
            Result.failure(e)
        }
    }

    /**
     * Synchronizes device 24h trial & approval-request state with Cloud Firestore (`trial_devices/{deviceId}`).
     * Ensures uninstalling & reinstalling the app cannot grant a fresh 24-hour trial on the same physical phone.
     */
    suspend fun syncDeviceTrialWithCloud(
        context: Context,
        markApprovalRequested: Boolean = false
    ): Result<PersistentTrialSecurityManager.CloudTrialSnapshot> {
        return try {
            if (markApprovalRequested) {
                PersistentTrialSecurityManager.markApprovalRequested(context)
            }
            val localSnapshot = PersistentTrialSecurityManager.exportDeviceTrialSnapshot(context)
            val db = getFirestore(context)
                ?: return Result.success(localSnapshot)
            val docRef = db.collection(COLLECTION_TRIAL_DEVICES).document(localSnapshot.deviceId)
            val snap = try {
                withTimeout(10_000L) { docRef.get(Source.SERVER).await() }
            } catch (_: Exception) {
                try {
                    docRef.get().await()
                } catch (_: Exception) {
                    null
                }
            }
            val cloudFirstInstall = snap?.getLong("firstInstallTime")
            val cloudExpired = snap?.getBoolean("isPermanentlyExpired") ?: false
            val cloudRequested = snap?.getBoolean("hasRequestedApproval") ?: false
            val cloudMaxSeen = snap?.getLong("maxSeenTime")

            val merged = PersistentTrialSecurityManager.applyCloudTrialRecord(
                context = context,
                cloudFirstInstallTime = cloudFirstInstall,
                cloudPermanentlyExpired = cloudExpired,
                cloudHasRequestedApproval = cloudRequested || markApprovalRequested,
                cloudMaxSeenTime = cloudMaxSeen
            )

            val shouldWriteCloud = snap == null ||
                !snap.exists() ||
                cloudFirstInstall == null ||
                merged.firstInstallTime < cloudFirstInstall ||
                (merged.isPermanentlyExpired && !cloudExpired) ||
                (merged.hasRequestedApproval && !cloudRequested) ||
                (merged.maxSeenTime - (cloudMaxSeen ?: 0L)) > 60_000L

            if (shouldWriteCloud) {
                val payload = hashMapOf<String, Any>(
                    "deviceId" to merged.deviceId,
                    "firstInstallTime" to merged.firstInstallTime,
                    "isPermanentlyExpired" to merged.isPermanentlyExpired,
                    "hasRequestedApproval" to merged.hasRequestedApproval,
                    "maxSeenTime" to merged.maxSeenTime,
                    "updatedAt" to System.currentTimeMillis()
                )
                withTimeout(10_000L) { docRef.set(payload).await() }
            }
            Result.success(merged)
        } catch (ce: CancellationException) {
            throw ce
        } catch (e: Exception) {
            Log.w(TAG, "Device trial cloud sync skipped/deferred: ${e.localizedMessage}")
            Result.failure(e)
        }
    }

    /**
     * Compresses a user-selected bank slip image into a lightweight Base64 data URI
     * so Admin devices can view the receipt directly via Cloud Firestore without needing Storage bucket rules.
     */
    suspend fun encodeSlipImageToDataUri(context: Context, uri: Uri): String? = withContext(Dispatchers.IO) {
        try {
            val boundsOptions = BitmapFactory.Options().apply { inJustDecodeBounds = true }
            context.contentResolver.openInputStream(uri)?.use { stream ->
                BitmapFactory.decodeStream(stream, null, boundsOptions)
            }
            if (boundsOptions.outWidth <= 0 || boundsOptions.outHeight <= 0) return@withContext null

            val maxDim = 640
            var sampleSize = 1
            while ((boundsOptions.outWidth / sampleSize) > maxDim * 2 || (boundsOptions.outHeight / sampleSize) > maxDim * 2) {
                sampleSize *= 2
            }

            val decodeOptions = BitmapFactory.Options().apply { inSampleSize = sampleSize }
            val decoded = context.contentResolver.openInputStream(uri)?.use { stream ->
                BitmapFactory.decodeStream(stream, null, decodeOptions)
            } ?: return@withContext null

            val scale = minOf(maxDim.toFloat() / decoded.width, maxDim.toFloat() / decoded.height, 1f)
            val scaled = if (scale < 1f) {
                Bitmap.createScaledBitmap(
                    decoded,
                    (decoded.width * scale).toInt().coerceAtLeast(1),
                    (decoded.height * scale).toInt().coerceAtLeast(1),
                    true
                ).also { if (it !== decoded) decoded.recycle() }
            } else {
                decoded
            }

            var quality = 65
            var bytes: ByteArray
            do {
                val out = ByteArrayOutputStream()
                scaled.compress(Bitmap.CompressFormat.JPEG, quality, out)
                bytes = out.toByteArray()
                quality -= 15
            } while (bytes.size > 160_000 && quality >= 25)

            scaled.recycle()
            if (bytes.size > 260_000) {
                null
            } else {
                "data:image/jpeg;base64," + Base64.encodeToString(bytes, Base64.NO_WRAP)
            }
        } catch (e: Throwable) {
            Log.w(TAG, "Failed to encode slip image for cloud transfer: ${e.localizedMessage}")
            null
        }
    }
}
