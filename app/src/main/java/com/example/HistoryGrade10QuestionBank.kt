package com.example

/**
 * Grade 10 History Question Bank for Live Exam Hall.
 */
object HistoryGrade10QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return HistoryMockPoolHelper.getQuestion("10", term, paperIdx, qNum)
  }
}
