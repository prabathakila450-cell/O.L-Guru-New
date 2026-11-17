package com.example

/**
 * Grade 10 Health & Physical Education Question Bank for Live Exam Hall.
 */
object HealthGrade10QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return HealthMockPoolHelper.getQuestion("10", term, paperIdx, qNum)
  }
}
