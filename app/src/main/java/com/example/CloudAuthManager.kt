package com.example

import android.content.Context
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

object CloudAuthManager {
    private const val TAG = "CloudAuthManager"
    private const val COLLECTION_USERS = "users"
    private var isSettingsConfigured = false

    private fun getFirestore(context: Context): FirebaseFirestore {
        val db = FirebaseFirestore.getInstance(context.getString(R.string.firestore_database_id))
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
        return db
    }

    private fun buildDocId(usernameOrPhone: String): String {
        return usernameOrPhone.trim().lowercase().replace("+", "").replace(" ", "")
    }

    suspend fun syncUserToCloud(context: Context, user: UserAccount) {
        try {
            val db = getFirestore(context)
            val docId = buildDocId(user.usernameOrPhone)
            if (docId.isBlank()) return

            db.collection(COLLECTION_USERS).document(docId).set(user).await()
            Log.d(TAG, "User synced to cloud: $docId (isApproved=${user.isApproved})")
        } catch (e: Exception) {
            Log.e(TAG, "Error syncing user to cloud", e)
        }
    }

    /**
     * Only uploads the user record if the document does not already exist in Firestore.
     * Prevents stale local state (e.g. isApproved = false) from overwriting an Admin's cloud approval.
     */
    suspend fun syncUserIfMissing(context: Context, user: UserAccount) {
        try {
            val db = getFirestore(context)
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

    suspend fun deleteUserFromCloud(context: Context, usernameOrPhone: String) {
        try {
            val db = getFirestore(context)
            val docId = buildDocId(usernameOrPhone)
            if (docId.isBlank()) return

            db.collection(COLLECTION_USERS).document(docId).delete().await()
            Log.d(TAG, "User deleted from cloud: $docId")
        } catch (e: Exception) {
            Log.e(TAG, "Error deleting user from cloud", e)
        }
    }

    fun observeAllUsers(context: Context): Flow<List<UserAccount>> = callbackFlow {
        val db = getFirestore(context)
        val listener = db.collection(COLLECTION_USERS)
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    Log.e(TAG, "Error observing users", error)
                    return@addSnapshotListener
                }
                val users = snapshot?.documents?.mapNotNull { doc ->
                    val parsed = doc.toObject(UserAccount::class.java) ?: return@mapNotNull null
                    val rawApproved = doc.getBoolean("isApproved") ?: doc.getBoolean("approved") ?: parsed.isApproved
                    parsed.copy(isApproved = rawApproved)
                } ?: emptyList()
                trySend(users)
            }
        awaitClose { listener.remove() }
    }

    suspend fun updateUserApproval(context: Context, usernameOrPhone: String, isApproved: Boolean, timestamp: Long?) {
        try {
            val db = getFirestore(context)
            val docId = buildDocId(usernameOrPhone)
            if (docId.isBlank()) return
            db.collection(COLLECTION_USERS).document(docId).update(
                mapOf(
                    "isApproved" to isApproved,
                    "paymentStatus" to if (isApproved) "Approved" else "Pending Approval",
                    "approvalTimestamp" to timestamp
                )
            ).await()
            Log.d(TAG, "User approval updated in cloud: $docId")
        } catch (e: Exception) {
            Log.e(TAG, "Error updating user approval in cloud", e)
        }
    }
}
