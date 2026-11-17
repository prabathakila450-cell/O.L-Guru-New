package com.example

/**
 * Grade 10 Science Question Bank for Live Exam Hall.
 * Uses ScienceMockPoolHelper for 1,800/1,800 unique, placeholder-free MCQs per term.
 */
object ScienceGrade10QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return ScienceMockPoolHelper.getQuestion("10", term, paperIdx, qNum)
  }
}
