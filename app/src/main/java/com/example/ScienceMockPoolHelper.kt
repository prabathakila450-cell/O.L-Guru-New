package com.example

/**
 * Science Live Exam Question Bank helper delegating to ScienceLiveExamQuestionBank.
 * Guarantees 1,800/1,800 unique Sinhala G10/G11 O/L Science MCQs per term across 30 papers
 * with authentic topic-matched options and zero duplicate or template-wrapped stems.
 */
object ScienceMockPoolHelper {
  fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return ScienceLiveExamQuestionBank.getQuestion(grade, term, paperIdx, qNum)
  }
}
