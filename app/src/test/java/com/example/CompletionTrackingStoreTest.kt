package com.example

import android.content.SharedPreferences
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class CompletionTrackingStoreTest {

  private class InMemorySharedPreferences(
    private val backing: MutableMap<String, Any?> = mutableMapOf()
  ) : SharedPreferences {
    override fun getAll(): MutableMap<String, *> = HashMap(backing)
    override fun getString(key: String?, defValue: String?): String? = (backing[key] as? String) ?: defValue
    @Suppress("UNCHECKED_CAST")
    override fun getStringSet(key: String?, defValues: MutableSet<String>?): MutableSet<String>? =
      (backing[key] as? Set<String>)?.toMutableSet() ?: defValues
    override fun getInt(key: String?, defValue: Int): Int = (backing[key] as? Int) ?: defValue
    override fun getLong(key: String?, defValue: Long): Long = (backing[key] as? Long) ?: defValue
    override fun getFloat(key: String?, defValue: Float): Float = (backing[key] as? Float) ?: defValue
    override fun getBoolean(key: String?, defValue: Boolean): Boolean = (backing[key] as? Boolean) ?: defValue
    override fun contains(key: String?): Boolean = backing.containsKey(key)
    override fun edit(): SharedPreferences.Editor = InMemoryEditor(backing)
    override fun registerOnSharedPreferenceChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener?) {}
    override fun unregisterOnSharedPreferenceChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener?) {}
  }

  private class InMemoryEditor(
    private val backing: MutableMap<String, Any?>
  ) : SharedPreferences.Editor {
    private val pending = mutableMapOf<String, Any?>()
    private val removals = mutableSetOf<String>()
    private var clearAll = false

    override fun putString(key: String?, value: String?) = apply { if (key != null) pending[key] = value }
    override fun putStringSet(key: String?, values: MutableSet<String>?) = apply {
      if (key != null) pending[key] = values?.toSet()
    }
    override fun putInt(key: String?, value: Int) = apply { if (key != null) pending[key] = value }
    override fun putLong(key: String?, value: Long) = apply { if (key != null) pending[key] = value }
    override fun putFloat(key: String?, value: Float) = apply { if (key != null) pending[key] = value }
    override fun putBoolean(key: String?, value: Boolean) = apply { if (key != null) pending[key] = value }
    override fun remove(key: String?) = apply { if (key != null) removals.add(key) }
    override fun clear() = apply { clearAll = true }
    override fun commit(): Boolean { apply(); return true }
    override fun apply() {
      if (clearAll) backing.clear()
      removals.forEach { backing.remove(it) }
      pending.forEach { (k, v) -> if (v == null) backing.remove(k) else backing[k] = v }
    }
  }

  @Test
  fun mathQuizMaster_persistsCompletionAcrossReloadAndAllowsUnlimitedRetakes() {
    val backingStore = mutableMapOf<String, Any?>()
    val prefsSession1 = InMemorySharedPreferences(backingStore)

    assertFalse(CompletionTrackingStore.isMathSetCompleted(prefsSession1, grade = 10, setNum = 1))
    assertFalse(CompletionTrackingStore.isMathSetCompleted(prefsSession1, grade = 11, setNum = 80))

    // Complete Set 1 (score 0) and Set 80 (score 18)
    CompletionTrackingStore.markMathSetCompleted(prefsSession1, grade = 10, setNum = 1, score = 0)
    CompletionTrackingStore.markMathSetCompleted(prefsSession1, grade = 11, setNum = 80, score = 18)

    // Simulated restart: fresh SharedPreferences instance reading persisted backing store
    val prefsSession2 = InMemorySharedPreferences(backingStore)
    assertTrue(CompletionTrackingStore.isMathSetCompleted(prefsSession2, grade = 10, setNum = 1))
    assertEquals(0, CompletionTrackingStore.getMathSetBestScore(prefsSession2, grade = 10, setNum = 1))
    assertFalse(CompletionTrackingStore.isMathSetCompleted(prefsSession2, grade = 11, setNum = 1))
    assertTrue(CompletionTrackingStore.isMathSetCompleted(prefsSession2, grade = 11, setNum = 80))

    // Unlimited retake: higher score updates best score, lower retake keeps best score & stays completed
    CompletionTrackingStore.markMathSetCompleted(prefsSession2, grade = 10, setNum = 1, score = 20)
    assertEquals(20, CompletionTrackingStore.getMathSetBestScore(prefsSession2, grade = 10, setNum = 1))
    CompletionTrackingStore.markMathSetCompleted(prefsSession2, grade = 10, setNum = 1, score = 12)
    assertEquals(20, CompletionTrackingStore.getMathSetBestScore(prefsSession2, grade = 10, setNum = 1))
    assertTrue(CompletionTrackingStore.isMathSetCompleted(prefsSession2, grade = 10, setNum = 1))

    // Backward-compatibility: pre-existing score_g10_s5 counts as completed
    prefsSession2.edit().putInt("score_g10_s5", 15).commit()
    assertTrue(CompletionTrackingStore.isMathSetCompleted(prefsSession2, grade = 10, setNum = 5))
  }

  @Test
  fun liveExamHall_persistsPerSubjectGradeTermPaperAndRetakeSafe() {
    val backingStore = mutableMapOf<String, Any?>()
    val prefsSession1 = InMemorySharedPreferences(backingStore)

    val examId1 = "mock_විද්‍යාව_g11_t1_p1"
    val examId2 = "mock_විද්‍යාව_g11_t2_p1"
    val examId3 = "mock_ගණිතය_g10_t1_p1"

    assertFalse(CompletionTrackingStore.isLiveExamCompleted(prefsSession1, examId1))

    CompletionTrackingStore.markLiveExamCompleted(prefsSession1, examId1)

    // Simulated restart
    val prefsSession2 = InMemorySharedPreferences(backingStore)
    assertTrue(CompletionTrackingStore.isLiveExamCompleted(prefsSession2, examId1))
    assertFalse(CompletionTrackingStore.isLiveExamCompleted(prefsSession2, examId2))
    assertFalse(CompletionTrackingStore.isLiveExamCompleted(prefsSession2, examId3))

    val reloaded = CompletionTrackingStore.getCompletedLiveExamIds(prefsSession2)
    assertTrue(reloaded.contains(examId1))
    assertFalse(reloaded.contains(examId2))

    // Retaking examId1 stays completed idempotently
    CompletionTrackingStore.markLiveExamCompleted(prefsSession2, examId1)
    assertTrue(CompletionTrackingStore.isLiveExamCompleted(prefsSession2, examId1))
  }

  @Test
  fun timedPastPaperSimulator_persistsPerSubjectAndYearAndRetakeSafe() {
    val backingStore = mutableMapOf<String, Any?>()
    val prefsSession1 = InMemorySharedPreferences(backingStore)

    val science = "විද්‍යාව (Science)"
    val math = "ගණිතය (Mathematics)"

    assertFalse(CompletionTrackingStore.isTimedPaperCompleted(prefsSession1, science, "2023"))

    CompletionTrackingStore.markTimedPaperCompleted(prefsSession1, science, "2023")

    // Simulated restart
    val prefsSession2 = InMemorySharedPreferences(backingStore)
    assertTrue(CompletionTrackingStore.isTimedPaperCompleted(prefsSession2, science, "2023"))
    assertFalse(CompletionTrackingStore.isTimedPaperCompleted(prefsSession2, science, "2022"))
    assertFalse(CompletionTrackingStore.isTimedPaperCompleted(prefsSession2, math, "2023"))

    val reloaded = CompletionTrackingStore.getCompletedTimedPaperKeys(prefsSession2)
    assertTrue(reloaded.contains(CompletionTrackingStore.timedPaperKey(science, "2023")))
    assertFalse(reloaded.contains(CompletionTrackingStore.timedPaperKey(math, "2023")))

    // Retake preserves completion
    CompletionTrackingStore.markTimedPaperCompleted(prefsSession2, science, "2023")
    assertTrue(CompletionTrackingStore.isTimedPaperCompleted(prefsSession2, science, "2023"))
  }
}
