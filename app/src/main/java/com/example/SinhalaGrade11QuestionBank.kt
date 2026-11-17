package com.example

/**
 * Grade 11 Sinhala Question Bank for Live Exam Hall.
 * Delegates to SinhalaMockPoolHelper providing 1,800 strictly unique Term 1-3 MCQs.
 */
object SinhalaGrade11QuestionBank {
  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    val cleanTerm = if (term in 1..3) term else 1
    val cleanPaper = if (paperIdx in 1..30) paperIdx else 1
    val cleanQ = if (qNum in 1..60) qNum else 1
    return SinhalaMockPoolHelper.getQuestion("11", cleanTerm, cleanPaper, cleanQ)
  }
}
