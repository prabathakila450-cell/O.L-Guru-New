package com.example

/**
 * Grade 10 Geography Question Bank for Live Exam Hall.
 */
object GeographyGrade10QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return GeographyMockPoolHelper.getQuestion("10", term, paperIdx, qNum)
  }
}
