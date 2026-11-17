package com.example

/**
 * Grade 10 Buddhism Question Bank for Live Exam Hall.
 */
object BuddhismGrade10QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return BuddhismMockPoolHelper.getQuestion("10", term, paperIdx, qNum)
  }
}
