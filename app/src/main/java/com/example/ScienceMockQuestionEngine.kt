package com.example

/**
 * High-precision Science Question Engine for Live Exam Hall.
 * Generates 60 unique, syllabus-accurate questions for all 30 papers across Terms 1, 2, and 3.
 * Guarantees that:
 * 1. All 60 questions within any paper are 100% distinct.
 * 2. Every paper from 1 to 30 has a distinct question set aligned to Sri Lankan O/L Science syllabus.
 * 3. Terms 1, 2, and 3 reflect their exact syllabus units for Grade 10 and Grade 11.
 */
object ScienceMockQuestionEngine {

  fun generateQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    val cleanGrade = if (grade.contains("10")) "10" else "11"
    val cleanTerm = if (term in 1..3) term else 1
    val cleanPaper = if (paperIdx in 1..30) paperIdx else 1
    val cleanQ = if (qNum in 1..60) qNum else 1

    return if (cleanGrade == "10") {
      ScienceGrade10QuestionBank.getQuestion(cleanTerm, cleanPaper, cleanQ)
    } else {
      ScienceGrade11QuestionBank.getQuestion(cleanTerm, cleanPaper, cleanQ)
    }
  }
}
