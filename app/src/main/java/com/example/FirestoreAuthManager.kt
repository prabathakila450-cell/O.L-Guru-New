package com.example

import android.content.Context
import android.net.Uri
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source
import kotlinx.coroutines.tasks.await
import java.io.Serializable

data class FirestoreUser(
    val id: String = "",
    val fullName: String = "",
    val phoneNumber: String = "",
    val password: String = "",
    val isApproved: Boolean = false,
    val paymentStatus: String = "Pending Approval",
    val requestedGradePackage: String = "10 සහ 11 ශ්‍රේණි (Grade 10 & 11 O/L)",
    val bankSlipUrl: String? = null,
    val school: String = "",
    val requestTimestamp: Long = System.currentTimeMillis()
) : Serializable

object FirestoreAuthManager {
    private const val TAG = "FirestoreAuthManager"
    private const val COLLECTION_USERS = "users"

    fun getFirestore(context: Context): FirebaseFirestore? {
        return try {
            if (com.google.firebase.FirebaseApp.getApps(context).isEmpty()) {
                null
            } else {
                FirebaseFirestore.getInstance()
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error getting Firestore instance", e)
            null
        }
    }

    suspend fun registerOrSubmitRequest(
        context: Context,
        fullName: String,
        phoneNumber: String,
        password: String,
        bankSlipUrl: String?
    ): Result<String> {
        return try {
            val db = getFirestore(context)
                ?: return Result.failure(IllegalStateException("Firebase is not initialized."))

            val docId = phoneNumber.trim().replace("+", "").replace(" ", "")
            if (docId.isBlank()) {
                return Result.failure(IllegalArgumentException("Phone number cannot be blank."))
            }

            val docRef = db.collection(COLLECTION_USERS).document(docId)
            val snapshot = docRef.get(Source.SERVER).await()

            if (snapshot.exists()) {
                val isApproved = snapshot.getBoolean("isApproved") ?: false
                if (isApproved) {
                    return Result.success("Account already approved. Please log in.")
                } else {
                    return Result.success("Your request is already pending admin approval.")
                }
            } else {
                val newUser = FirestoreUser(
                    id = docId,
                    fullName = fullName.trim(),
                    phoneNumber = phoneNumber.trim(),
                    password = password.trim(),
                    isApproved = false,
                    paymentStatus = if (bankSlipUrl != null) "Pending Approval (With Slip)" else "Pending Approval",
                    bankSlipUrl = bankSlipUrl,
                    requestTimestamp = System.currentTimeMillis()
                )
                docRef.set(newUser).await()
                Result.success("Registration request submitted successfully (Pending).")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error in registerOrSubmitRequest", e)
            Result.failure(e)
        }
    }

    suspend fun loginOrCheckStatus(
        context: Context,
        phoneNumber: String,
        password: String
    ): Result<Pair<Boolean, String>> {
        return try {
            val db = getFirestore(context)
                ?: return Result.failure(IllegalStateException("Firebase is not initialized."))

            val docId = phoneNumber.trim().replace("+", "").replace(" ", "")
            if (docId.isBlank()) {
                return Result.failure(IllegalArgumentException("Phone number cannot be blank."))
            }

            val docRef = db.collection(COLLECTION_USERS).document(docId)
            val snapshot = docRef.get(Source.SERVER).await()

            if (snapshot.exists()) {
                val storedPassword = snapshot.getString("password") ?: ""
                val isApproved = snapshot.getBoolean("isApproved") ?: false

                if (storedPassword != password.trim()) {
                    return Result.success(Pair(false, "Incorrect password."))
                }

                if (isApproved) {
                    return Result.success(Pair(true, "Login successful."))
                } else {
                    return Result.success(Pair(false, "Your request is still pending admin approval. Please wait."))
                }
            } else {
                Result.success(Pair(false, "No registration found. The admin may have cancelled your request. Please register again."))
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error in loginOrCheckStatus", e)
            Result.failure(e)
        }
    }

    suspend fun approveUser(context: Context, userId: String): Result<Unit> {
        return try {
            val db = getFirestore(context)
                ?: return Result.failure(IllegalStateException("Firebase is not initialized."))
            db.collection(COLLECTION_USERS).document(userId)
                .update(mapOf("isApproved" to true, "paymentStatus" to "Approved"))
                .await()
            Result.success(Unit)
        } catch (e: Exception) {
            Log.e(TAG, "Error approving user", e)
            Result.failure(e)
        }
    }

    suspend fun deleteUser(context: Context, userId: String): Result<Unit> {
        return try {
            val db = getFirestore(context)
                ?: return Result.failure(IllegalStateException("Firebase is not initialized."))
            db.collection(COLLECTION_USERS).document(userId).delete().await()
            Result.success(Unit)
        } catch (e: Exception) {
            Log.e(TAG, "Error deleting user", e)
            Result.failure(e)
        }
    }
}
