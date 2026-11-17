package com.example

/**
 * Grade 11 Buddhism Question Bank for Live Exam Hall.
 */
object BuddhismGrade11QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return BuddhismMockPoolHelper.getQuestion("11", term, paperIdx, qNum)
  }
}
