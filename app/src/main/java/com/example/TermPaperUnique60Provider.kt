package com.example

/**
 * Authentic, syllabus-aligned 60 Distinct Questions Generator for Live Exam Hall.
 * Guarantees that:
 * 1. Exactly 30 distinct question papers are provided per term per subject.
 * 2. Every question from 1 to 60 within any paper is completely unique.
 * 3. Every paper from 1 to 30 has a totally different set of questions with no identical duplicates.
 * 4. Distinct questions for Terms 1, 2, and 3 reflecting specific school syllabus progression.
 */
object TermPaperUnique60Provider {

  fun get60DistinctQuestions(
    grade: String,
    subject: String,
    term: Int,
    paperIdx: Int
  ): List<MockExamQuestion> {
    val cleanTerm = if (term in 1..3) term else 1
    val cleanPaperIdx = if (paperIdx in 1..30) paperIdx else 1
    val questions = ArrayList<MockExamQuestion>(60)
    for (qNum in 1..60) {
      questions.add(buildDistinctQuestion(grade, subject, cleanTerm, cleanPaperIdx, qNum))
    }
    return questions
  }

  private fun buildDistinctQuestion(
    grade: String,
    subject: String,
    term: Int,
    paperIdx: Int,
    qNum: Int
  ): MockExamQuestion {
    return when {
      subject.contains("කෘෂි") -> {
        BuddhismAndElectivesMockEngine.generateAgriQuestion(grade, term, paperIdx, qNum)
      }
      subject.contains("භූගෝල") -> {
        BuddhismAndElectivesMockEngine.generateGeographyQuestion(grade, term, paperIdx, qNum)
      }
      subject.contains("විද්‍යා") -> {
        ScienceMockQuestionEngine.generateQuestion(grade, term, paperIdx, qNum)
      }
      subject.contains("ගණිත") -> {
        MathMockQuestionEngine.generateQuestion(grade, term, paperIdx, qNum)
      }
      subject.contains("ඉතිහාස") -> {
        HistoryMockQuestionEngine.generateQuestion(grade, term, paperIdx, qNum)
      }
      subject.contains("සිංහල") -> {
        LanguageMockQuestionEngine.generateSinhalaQuestion(grade, term, paperIdx, qNum)
      }
      subject.contains("ඉංග්‍රීසි") -> {
        LanguageMockQuestionEngine.generateEnglishQuestion(grade, term, paperIdx, qNum)
      }
      subject.contains("බුද්ධ") -> {
        BuddhismMockQuestionEngine.generateQuestion(grade, term, paperIdx, qNum)
      }
      subject.contains("ICT") || subject.contains("තොරතුරු") -> {
        BuddhismAndElectivesMockEngine.generateIctQuestion(grade, term, paperIdx, qNum)
      }
      subject.contains("ව්‍යාපාර") || subject.contains("වාණිජ") || subject.contains("ගිණුම්") -> {
        BuddhismAndElectivesMockEngine.generateCommerceQuestion(grade, term, paperIdx, qNum)
      }
      subject.contains("පුරවැසි") -> {
        BuddhismAndElectivesMockEngine.generateCivicsQuestion(grade, term, paperIdx, qNum)
      }
      subject.contains("සෞඛ්‍ය") -> {
        BuddhismAndElectivesMockEngine.generateHealthQuestion(grade, term, paperIdx, qNum)
      }
      subject.contains("චිත්‍ර") -> {
        BuddhismAndElectivesMockEngine.generateArtQuestion(grade, term, paperIdx, qNum)
      }
      subject.contains("සංගීත") -> {
        BuddhismAndElectivesMockEngine.generateMusicQuestion(grade, term, paperIdx, qNum)
      }
      subject.contains("නර්තන") -> {
        BuddhismAndElectivesMockEngine.generateDancingQuestion(grade, term, paperIdx, qNum)
      }
      else -> {
        ScienceMockQuestionEngine.generateQuestion(grade, term, paperIdx, qNum)
      }
    }
  }
}
