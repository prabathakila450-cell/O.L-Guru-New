package com.example

/**
 * Grade 10 Agriculture Science Question Bank for Live Exam Hall.
 */
object AgriGrade10QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return AgriMockPoolHelper.getQuestion("10", term, paperIdx, qNum)
  }
}
