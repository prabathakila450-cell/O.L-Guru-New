package com.example

/**
 * Grade 11 Commerce & Accounting Question Bank for Live Exam Hall.
 */
object CommerceGrade11QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return CommerceMockPoolHelper.getQuestion("11", term, paperIdx, qNum)
  }
}
