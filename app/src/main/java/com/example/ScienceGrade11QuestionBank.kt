package com.example

/**
 * Grade 11 Science Question Bank for Live Exam Hall.
 * Uses ScienceLiveExamQuestionBank for 1,800/1,800 unique, placeholder-free Sinhala O/L MCQs per term.
 */
object ScienceGrade11QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return ScienceLiveExamQuestionBank.getQuestion("11", term, paperIdx, qNum)
  }
}
