package com.example

/**
 * Grade 11 Health & Physical Education Question Bank for Live Exam Hall.
 */
object HealthGrade11QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return HealthMockPoolHelper.getQuestion("11", term, paperIdx, qNum)
  }
}
