package com.example

/**
 * Grade 10 Mathematics Question Bank for Live Exam Hall.
 * Delegates to MathMockPoolHelper to guarantee 100% unique questions across all 30 papers per term.
 */
object MathGrade10QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return MathMockPoolHelper.getQuestion("10", term, paperIdx, qNum)
  }
}
