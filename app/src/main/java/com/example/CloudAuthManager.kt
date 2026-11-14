package com.example

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.Source
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream

object CloudAuthManager {
    private const val TAG = "CloudAuthManager"
    private const val COLLECTION_USERS = "users"
    private var isSettingsConfigured = false

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
