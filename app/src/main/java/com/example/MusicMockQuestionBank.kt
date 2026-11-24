package com.example

/**
 * Sri Lankan G.C.E. O/L Music (සංගීතය) Question Bank for Live Exam Hall (Grades 10 & 11).
 *
 * Delegates directly to [MusicLiveExamQuestionBank] which provides 1,900+ curated, strictly
 * unique Sinhala MCQs across all 10 official G.C.E. O/L Oriental Music syllabus domains with zero
 * repetition within any 60-question paper or across all 30 papers per term.
 */
object MusicMockQuestionBank {

  fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return MusicLiveExamQuestionBank.getQuestion(grade, term, paperIdx, qNum)
  }
}
