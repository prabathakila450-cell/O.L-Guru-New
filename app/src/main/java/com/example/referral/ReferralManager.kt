package com.example.referral

import android.content.Context
import android.provider.Settings
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.util.Calendar

object ReferralManager {
    private const val COLLECTION = "referrals"

    private fun getDeviceId(context: Context): String {
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID) ?: "default_device"
    }
    
    suspend fun getProgress(context: Context): Double {
        return try {
            val userId = getDeviceId(context)
            val db = FirebaseFirestore.getInstance()
            val doc = db.collection(COLLECTION).document(userId).get().await()
            
            if (!doc.exists()) return 0.0
            
            val lastReset = doc.getLong("lastResetMonth") ?: 0L
            val currentMonth = Calendar.getInstance().get(Calendar.MONTH).toLong()
            
            if (lastReset != currentMonth) {
                db.collection(COLLECTION).document(userId).set(
                    mapOf("progress" to 0.0, "lastResetMonth" to currentMonth)
                ).await()
                return 0.0
            }
            
            doc.getDouble("progress") ?: 0.0
        } catch (e: Exception) {
            0.0 // Fallback if offline or Firestore not configured
        }
    }

    suspend fun addShare(context: Context, isGroup: Boolean) {
        try {
            val userId = getDeviceId(context)
            val db = FirebaseFirestore.getInstance()
            val docRef = db.collection(COLLECTION).document(userId)
            
            val increment = if (isGroup) 7.5 else 1.25
            
            db.runTransaction { transaction ->
                val snapshot = transaction.get(docRef)
                val currentProgress = if (snapshot.exists()) snapshot.getDouble("progress") ?: 0.0 else 0.0
                if (!snapshot.exists()) {
                    transaction.set(docRef, mapOf("progress" to increment, "lastResetMonth" to Calendar.getInstance().get(Calendar.MONTH).toLong()))
                } else {
                    transaction.update(docRef, "progress", currentProgress + increment)
                }
            }.await()
        } catch (e: Exception) {
            // Handle offline gracefully
        }
    }
}
