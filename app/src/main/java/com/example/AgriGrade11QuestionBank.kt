package com.example

/**
 * Grade 11 Agriculture Science Question Bank for Live Exam Hall.
 */
object AgriGrade11QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return AgriMockPoolHelper.getQuestion("11", term, paperIdx, qNum)
  }
}
