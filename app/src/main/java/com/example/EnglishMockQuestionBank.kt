package com.example

/**
 * Curated G.C.E. O/L English Language Live Exam Hall Question Bank (Grades 10 & 11).
 *
 * Delegates directly to [EnglishLiveExamQuestionBank], ensuring:
 *  - Strictly O/L (G10-11) English syllabus coverage across 10 balanced domains.
 *  - 60 strictly unique questions per paper and 1,800 strictly unique questions per 30-paper term.
 *  - Topic-matched, balanced, concise 4-option MCQs without leaks or templates.
 */
object EnglishMockQuestionBank {
  fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return EnglishLiveExamQuestionBank.getQuestion(grade, term, paperIdx, qNum)
  }
}
