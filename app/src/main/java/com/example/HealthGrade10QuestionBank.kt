package com.example

/**
 * Grade 10 Health & Physical Education Question Bank for Live Exam Hall.
 * Uses HealthLiveExamQuestionBank for 1,800/1,800 unique, placeholder-free Sinhala O/L MCQs per term.
 */
object HealthGrade10QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return HealthLiveExamQuestionBank.getQuestion("10", term, paperIdx, qNum)
  }
}
