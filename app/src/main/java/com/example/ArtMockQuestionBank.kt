package com.example

/**
 * Sri Lankan G.C.E. O/L Art (චිත්‍ර කලාව) Question Bank for Live Exam Hall (Grades 10 & 11).
 *
 * Delegates directly to [ArtLiveExamQuestionBank] which provides 1,800+ curated, strictly
 * unique Sinhala MCQs across all 10 official G.C.E. O/L Art syllabus domains with zero
 * repetition within any 60-question paper or across all 30 papers per term.
 */
object ArtMockQuestionBank {

    fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
        return ArtLiveExamQuestionBank.getQuestion(grade, term, paperIdx, qNum)
    }
}
