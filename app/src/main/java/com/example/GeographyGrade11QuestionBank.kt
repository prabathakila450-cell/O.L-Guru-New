package com.example

/**
 * Grade 11 Geography Question Bank for Live Exam Hall.
 */
object GeographyGrade11QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return GeographyMockPoolHelper.getQuestion("11", term, paperIdx, qNum)
  }
}
