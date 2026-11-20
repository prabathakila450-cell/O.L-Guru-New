package com.example

/**
 * High-precision Language Question Engine (Sinhala & English) for Live Exam Hall.
 * Generates 60 unique questions per paper across 30 papers and 3 terms.
 */
object LanguageMockQuestionEngine {

  fun generateSinhalaQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    val cleanGrade = if (grade.contains("10")) "10" else "11"
    val cleanTerm = if (term in 1..3) term else 1
    val cleanPaper = if (paperIdx in 1..30) paperIdx else 1
    val cleanQ = if (qNum in 1..60) qNum else 1

    return SinhalaLiveExamQuestionBank.getQuestion(cleanGrade, cleanTerm, cleanPaper, cleanQ)
  }

  fun generateEnglishQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    val cleanGrade = if (grade.contains("10")) "10" else "11"
    val cleanTerm = if (term in 1..3) term else 1
    val cleanPaper = if (paperIdx in 1..30) paperIdx else 1
    val cleanQ = if (qNum in 1..60) qNum else 1
    return EnglishMockQuestionBank.getQuestion(cleanGrade, cleanTerm, cleanPaper, cleanQ)
  }
}
