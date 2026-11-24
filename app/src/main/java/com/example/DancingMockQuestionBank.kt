package com.example

/**
 * Sri Lankan G.C.E. O/L Dancing (නර්තනය) Question Bank for Live Exam Hall (Grades 10 & 11).
 *
 * Delegates directly to [DancingLiveExamQuestionBank] which provides 1,890+ curated, strictly
 * unique Sinhala MCQs across all 10 official G.C.E. O/L Dancing syllabus domains with zero
 * repetition within any 60-question paper or across all 30 papers per term.
 */
object DancingMockQuestionBank {

  fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return DancingLiveExamQuestionBank.getQuestion(grade, term, paperIdx, qNum)
  }
}
