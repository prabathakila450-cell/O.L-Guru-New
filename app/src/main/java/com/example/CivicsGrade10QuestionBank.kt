package com.example

/**
 * Grade 10 Civics Question Bank for Live Exam Hall.
 */
object CivicsGrade10QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return CivicsMockPoolHelper.getQuestion("10", term, paperIdx, qNum)
  }
}
