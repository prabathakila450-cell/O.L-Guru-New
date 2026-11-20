package com.example

/**
 * High-precision History Question Engine for Live Exam Hall.
 * Delegates directly to HistoryLiveExamQuestionBank for all 30 papers across Terms 1, 2, and 3.
 */
object HistoryMockQuestionEngine {

  fun generateQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    val cleanGrade = if (grade.contains("10")) "10" else "11"
    val cleanTerm = if (term in 1..3) term else 1
    val cleanPaper = if (paperIdx in 1..30) paperIdx else 1
    val cleanQ = if (qNum in 1..60) qNum else 1

    return HistoryLiveExamQuestionBank.getQuestion(cleanGrade, cleanTerm, cleanPaper, cleanQ)
  }
}
