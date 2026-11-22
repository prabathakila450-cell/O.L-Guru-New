package com.example

/**
 * Grade 11 Citizenship Education Question Bank for Live Exam Hall.
 * Uses CivicsLiveExamQuestionBank for 1,800/1,800 unique, placeholder-free Sinhala O/L MCQs per term.
 */
object CivicsGrade11QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return CivicsLiveExamQuestionBank.getQuestion("11", term, paperIdx, qNum)
  }
}
