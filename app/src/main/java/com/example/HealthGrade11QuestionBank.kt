package com.example

/**
 * Grade 11 Health & Physical Education Question Bank for Live Exam Hall.
 * Uses HealthLiveExamQuestionBank for 1,800/1,800 unique, placeholder-free Sinhala O/L MCQs per term.
 */
object HealthGrade11QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return HealthLiveExamQuestionBank.getQuestion("11", term, paperIdx, qNum)
  }
}
