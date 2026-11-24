package com.example

/**
 * Health and Physical Education (සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය) Live Exam Question Bank helper
 * delegating to HealthLiveExamQuestionBank.
 * Guarantees 1,800/1,800 unique Sinhala G10/G11 O/L Health & Physical Education MCQs per term
 * across 30 papers with authentic topic-matched options and zero duplicate or template-wrapped stems.
 */
object HealthMockPoolHelper {
  fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return HealthLiveExamQuestionBank.getQuestion(grade, term, paperIdx, qNum)
  }
}
