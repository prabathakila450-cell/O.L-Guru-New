package com.example

/**
 * Grade 11 Civics Question Bank for Live Exam Hall.
 */
object CivicsGrade11QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return CivicsMockPoolHelper.getQuestion("11", term, paperIdx, qNum)
  }
}
