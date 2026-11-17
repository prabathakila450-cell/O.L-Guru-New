package com.example

/**
 * Grade 10 Commerce & Accounting Question Bank for Live Exam Hall.
 */
object CommerceGrade10QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return CommerceMockPoolHelper.getQuestion("10", term, paperIdx, qNum)
  }
}
