package com.example

import android.content.Context
import android.content.SharedPreferences

/**
 * SharedPreferences-backed persistence store for tracking completed items
 * across:
 * 1. ගණිතය ක්විස් මාස්ටර් (Grade 10 & 11, Sets 1..80)
 * 2. සැබෑ විභාග ශාලා අනුකරණය (Subject, Grade, Term, Paper)
 * 3. Timed Past Paper Simulator (Subject & Year)
 *
 * Completion status never locks retakes — students can retake any completed item unlimited times.
 */
object CompletionTrackingStore {
  private const val PREFS_MATH = "math_quiz_master_scores"
  private const val PREFS_LIVE_EXAM = "live_mock_exam_completion"
  private const val PREFS_TIMED_PAPER = "timed_past_paper_completion"

  // -------------------------------------------------------------------------
  // 1. Math Quiz Master (Sets 1..80 for Grade 10 & 11)
  // -------------------------------------------------------------------------
  private fun mathScoreKey(grade: Int, setNum: Int): String = "score_g${grade}_s$setNum"
  private fun mathCompletedKey(grade: Int, setNum: Int): String = "completed_g${grade}_s$setNum"

  fun isMathSetCompleted(context: Context, grade: Int, setNum: Int): Boolean {
    return isMathSetCompleted(context.getSharedPreferences(PREFS_MATH, Context.MODE_PRIVATE), grade, setNum)
  }

  internal fun isMathSetCompleted(prefs: SharedPreferences, grade: Int, setNum: Int): Boolean {
    return prefs.getBoolean(mathCompletedKey(grade, setNum), false) ||
      prefs.getInt(mathScoreKey(grade, setNum), -1) >= 0
  }

  fun getMathSetBestScore(context: Context, grade: Int, setNum: Int): Int {
    return getMathSetBestScore(context.getSharedPreferences(PREFS_MATH, Context.MODE_PRIVATE), grade, setNum)
  }

  internal fun getMathSetBestScore(prefs: SharedPreferences, grade: Int, setNum: Int): Int {
    return prefs.getInt(mathScoreKey(grade, setNum), -1)
  }

  fun markMathSetCompleted(context: Context, grade: Int, setNum: Int, score: Int) {
    markMathSetCompleted(context.getSharedPreferences(PREFS_MATH, Context.MODE_PRIVATE), grade, setNum, score)
  }

  internal fun markMathSetCompleted(prefs: SharedPreferences, grade: Int, setNum: Int, score: Int) {
    val sKey = mathScoreKey(grade, setNum)
    val oldScore = prefs.getInt(sKey, -1)
    prefs.edit().apply {
      putBoolean(mathCompletedKey(grade, setNum), true)
      if (score > oldScore) {
        putInt(sKey, score)
      }
      apply()
    }
  }

  // -------------------------------------------------------------------------
  // 2. Live Mock Exam Hall Simulation (Subject, Grade, Term, Paper)
  // -------------------------------------------------------------------------
  private const val LIVE_PREFIX = "completed_"

  fun markLiveExamCompleted(context: Context, examId: String) {
    markLiveExamCompleted(context.getSharedPreferences(PREFS_LIVE_EXAM, Context.MODE_PRIVATE), examId)
  }

  internal fun markLiveExamCompleted(prefs: SharedPreferences, examId: String) {
    if (examId.isBlank()) return
    prefs.edit().putBoolean("$LIVE_PREFIX$examId", true).apply()
  }

  fun isLiveExamCompleted(context: Context, examId: String): Boolean {
    return isLiveExamCompleted(context.getSharedPreferences(PREFS_LIVE_EXAM, Context.MODE_PRIVATE), examId)
  }

  internal fun isLiveExamCompleted(prefs: SharedPreferences, examId: String): Boolean {
    if (examId.isBlank()) return false
    return prefs.getBoolean("$LIVE_PREFIX$examId", false)
  }

  fun getCompletedLiveExamIds(context: Context): Set<String> {
    return getCompletedLiveExamIds(context.getSharedPreferences(PREFS_LIVE_EXAM, Context.MODE_PRIVATE))
  }

  internal fun getCompletedLiveExamIds(prefs: SharedPreferences): Set<String> {
    val result = mutableSetOf<String>()
    prefs.all.forEach { (key, value) ->
      if (key.startsWith(LIVE_PREFIX) && value == true) {
        result.add(key.removePrefix(LIVE_PREFIX))
      }
    }
    return result
  }

  // -------------------------------------------------------------------------
  // 3. Timed Past Paper Simulator (Subject & Year)
  // -------------------------------------------------------------------------
  private const val TIMED_PREFIX = "completed_"

  fun timedPaperKey(subject: String, year: String): String = "${subject}__${year}"

  fun markTimedPaperCompleted(context: Context, subject: String, year: String) {
    markTimedPaperCompleted(context.getSharedPreferences(PREFS_TIMED_PAPER, Context.MODE_PRIVATE), subject, year)
  }

  internal fun markTimedPaperCompleted(prefs: SharedPreferences, subject: String, year: String) {
    if (subject.isBlank() || year.isBlank()) return
    prefs.edit().putBoolean("$TIMED_PREFIX${timedPaperKey(subject, year)}", true).apply()
  }

  fun isTimedPaperCompleted(context: Context, subject: String, year: String): Boolean {
    return isTimedPaperCompleted(context.getSharedPreferences(PREFS_TIMED_PAPER, Context.MODE_PRIVATE), subject, year)
  }

  internal fun isTimedPaperCompleted(prefs: SharedPreferences, subject: String, year: String): Boolean {
    if (subject.isBlank() || year.isBlank()) return false
    return prefs.getBoolean("$TIMED_PREFIX${timedPaperKey(subject, year)}", false)
  }

  fun getCompletedTimedPaperKeys(context: Context): Set<String> {
    return getCompletedTimedPaperKeys(context.getSharedPreferences(PREFS_TIMED_PAPER, Context.MODE_PRIVATE))
  }

  internal fun getCompletedTimedPaperKeys(prefs: SharedPreferences): Set<String> {
    val result = mutableSetOf<String>()
    prefs.all.forEach { (key, value) ->
      if (key.startsWith(TIMED_PREFIX) && value == true) {
        result.add(key.removePrefix(TIMED_PREFIX))
      }
    }
    return result
  }
}
