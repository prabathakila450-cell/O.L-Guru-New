package com.example

/**
 * Grade 11 Buddhism Question Bank for Live Exam Hall.
 * Delegates exclusively to the curated Grade 11 Buddhism Live Exam Bank coordinator.
 */
object BuddhismGrade11QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return BuddhismG11LiveExamQuestionBank.getQuestion(term, paperIdx, qNum)
  }
}
