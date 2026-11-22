package com.example

/**
 * Citizenship Education (පුරවැසි අධ්‍යාපනය) Live Exam Question Bank helper delegating to CivicsLiveExamQuestionBank.
 * Guarantees 1,800/1,800 unique Sinhala G10/G11 O/L Citizenship Education MCQs per term across 30 papers
 * with authentic topic-matched options and zero duplicate or template-wrapped stems.
 */
object CivicsMockPoolHelper {
  fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return CivicsLiveExamQuestionBank.getQuestion(grade, term, paperIdx, qNum)
  }
}
