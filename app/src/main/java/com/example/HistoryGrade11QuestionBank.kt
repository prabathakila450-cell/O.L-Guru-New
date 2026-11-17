package com.example

/**
 * Grade 11 History Question Bank for Live Exam Hall.
 */
object HistoryGrade11QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return HistoryMockPoolHelper.getQuestion("11", term, paperIdx, qNum)
  }
}
