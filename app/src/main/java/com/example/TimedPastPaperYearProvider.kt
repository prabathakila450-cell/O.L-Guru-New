package com.example

/**
 * Authentic, Year-by-Year Past Paper Simulator Provider.
 * Generates distinct, curriculum-accurate past paper questions tailored for each specific year (2024, 2023, 2022, 2021, 2020, 2019).
 * Guarantees that:
 * 1. Papers vary distinctly from year to year.
 * 2. Every paper contains 60 distinct questions without repetitions.
 * 3. 100% correct answers with rich explanations.
 */
object TimedPastPaperYearProvider {

  fun getYearSpecificQuestions(subject: String, year: String): List<PastPaperQuestion> {
    val yearInt = year.filter { it.isDigit() }.toIntOrNull() ?: 2024
    val normSubject = when {
      subject.contains("භූගෝල") -> "geography"
      subject.contains("විද්‍යා") && !subject.contains("භූගෝල") -> "science"
      subject.contains("ගණිත") -> "math"
      subject.contains("ඉතිහාස") -> "history"
      subject.contains("සිංහල") -> "sinhala"
      subject.contains("ඉංග්‍රීසි") -> "english"
      subject.contains("බුද්ධ") -> "buddhism"
      subject.contains("ICT") || subject.contains("තොරතුරු") -> "ict"
      subject.contains("වාණිජ") || subject.contains("ගිණුම්") -> "commerce"
      subject.contains("පුරවැසි") -> "civics"
      subject.contains("සෞඛ්‍ය") -> "health"
      subject.contains("කෘෂි") -> "agriculture"
      subject.contains("චිත්‍ර") -> "art"
      subject.contains("සංගීත") -> "music"
      subject.contains("නර්තන") -> "dancing"
      else -> "science"
    }

    val questions = mutableListOf<PastPaperQuestion>()
    for (qNum in 1..60) {
      val item = buildPastPaperItem(normSubject, yearInt, qNum, year, subject)
      questions.add(item)
    }
    return questions
  }

  private fun buildPastPaperItem(
    normSubject: String,
    year: Int,
    qNum: Int,
    yearStr: String,
    subjectTitle: String
  ): PastPaperQuestion {
    // Unique seed for this year and question number
    val seed = (year * 100) + qNum
    return when (normSubject) {
      "science" -> buildSciencePastQuestion(year, qNum, seed, yearStr, subjectTitle)
      "math" -> buildMathPastQuestion(year, qNum, seed, yearStr, subjectTitle)
      "history" -> buildHistoryPastQuestion(year, qNum, seed, yearStr, subjectTitle)
      "sinhala" -> buildSinhalaPastQuestion(year, qNum, seed, yearStr, subjectTitle)
      "english" -> buildEnglishPastQuestion(year, qNum, seed, yearStr, subjectTitle)
      "buddhism" -> buildBuddhismPastQuestion(year, qNum, seed, yearStr, subjectTitle)
      "ict" -> buildIctPastQuestion(year, qNum, seed, yearStr, subjectTitle)
      "commerce" -> buildCommercePastQuestion(year, qNum, seed, yearStr, subjectTitle)
      "civics" -> buildCivicsPastQuestion(year, qNum, seed, yearStr, subjectTitle)
      "geography" -> buildGeographyPastQuestion(year, qNum, seed, yearStr, subjectTitle)
      "health" -> buildHealthPastQuestion(year, qNum, seed, yearStr, subjectTitle)
      "agriculture" -> buildAgriculturePastQuestion(year, qNum, seed, yearStr, subjectTitle)
      "art" -> buildArtPastQuestion(year, qNum, seed, yearStr, subjectTitle)
      "music" -> buildMusicPastQuestion(year, qNum, seed, yearStr, subjectTitle)
      "dancing" -> buildDancingPastQuestion(year, qNum, seed, yearStr, subjectTitle)
      else -> buildSciencePastQuestion(year, qNum, seed, yearStr, subjectTitle)
    }
  }

  // --------------------------------------------------------------------------
  // SCIENCE PAST PAPERS (YEAR BY YEAR)
  // --------------------------------------------------------------------------
  private fun buildSciencePastQuestion(year: Int, qNum: Int, seed: Int, yearStr: String, subjectTitle: String): PastPaperQuestion {
    return SciencePastPaper60QuestionsProvider.buildScienceQuestion(year, qNum, yearStr, subjectTitle)
  }

  // --------------------------------------------------------------------------
  // MATHEMATICS PAST PAPERS (YEAR BY YEAR)
  // --------------------------------------------------------------------------
  private fun buildMathPastQuestion(year: Int, qNum: Int, seed: Int, yearStr: String, subjectTitle: String): PastPaperQuestion {
    return MathPastPaper60QuestionsProvider.buildMathQuestion(year, qNum, yearStr, subjectTitle)
  }

  // --------------------------------------------------------------------------
  // HISTORY PAST PAPERS (YEAR BY YEAR)
  // --------------------------------------------------------------------------
  private fun buildHistoryPastQuestion(year: Int, qNum: Int, seed: Int, yearStr: String, subjectTitle: String): PastPaperQuestion {
    return HistoryPastPaper60QuestionsProvider.buildHistoryQuestion(year, qNum, yearStr, subjectTitle)
  }

  // --------------------------------------------------------------------------
  // OTHER SUBJECTS (Sinhala, English, Buddhism, ICT, Commerce, Civics, Geography)
  // --------------------------------------------------------------------------
  private fun buildSinhalaPastQuestion(year: Int, qNum: Int, seed: Int, yearStr: String, subjectTitle: String): PastPaperQuestion {
    return SinhalaPastPaper60QuestionsProvider.buildSinhalaQuestion(year, qNum, yearStr, subjectTitle)
  }

  private fun buildEnglishPastQuestion(year: Int, qNum: Int, seed: Int, yearStr: String, subjectTitle: String): PastPaperQuestion {
    return EnglishPastPaper60QuestionsProvider.buildEnglishQuestion(year, qNum, yearStr, subjectTitle)
  }

  private fun buildBuddhismPastQuestion(year: Int, qNum: Int, seed: Int, yearStr: String, subjectTitle: String): PastPaperQuestion {
    return BuddhismPastPaper60QuestionsProvider.buildBuddhismQuestion(year, qNum, yearStr, subjectTitle)
  }

  private fun buildIctPastQuestion(year: Int, qNum: Int, seed: Int, yearStr: String, subjectTitle: String): PastPaperQuestion {
    return IctPastPaper60QuestionsProvider.buildIctQuestion(year, qNum, yearStr, subjectTitle)
  }

  private fun buildCommercePastQuestion(year: Int, qNum: Int, seed: Int, yearStr: String, subjectTitle: String): PastPaperQuestion {
    return CommercePastPaper60QuestionsProvider.buildCommerceQuestion(year, qNum, yearStr, subjectTitle)
  }

  private fun buildCivicsPastQuestion(year: Int, qNum: Int, seed: Int, yearStr: String, subjectTitle: String): PastPaperQuestion {
    return CivicsPastPaper60QuestionsProvider.buildCivicsQuestion(year, qNum, yearStr, subjectTitle)
  }

  private fun buildGeographyPastQuestion(year: Int, qNum: Int, seed: Int, yearStr: String, subjectTitle: String): PastPaperQuestion {
    return GeographyPastPaper60QuestionsProvider.buildGeographyQuestion(year, qNum, yearStr, subjectTitle)
  }

  private fun buildHealthPastQuestion(year: Int, qNum: Int, seed: Int, yearStr: String, subjectTitle: String): PastPaperQuestion {
    return HealthPastPaper60QuestionsProvider.buildHealthQuestion(year, qNum, yearStr, subjectTitle)
  }

  private fun buildAgriculturePastQuestion(year: Int, qNum: Int, seed: Int, yearStr: String, subjectTitle: String): PastPaperQuestion {
    return AgriculturePastPaper60QuestionsProvider.buildAgricultureQuestion(year, qNum, yearStr, subjectTitle)
  }

  private fun buildArtPastQuestion(year: Int, qNum: Int, seed: Int, yearStr: String, subjectTitle: String): PastPaperQuestion {
    return ArtPastPaper60QuestionsProvider.buildArtQuestion(year, qNum, yearStr, subjectTitle)
  }

  private fun buildMusicPastQuestion(year: Int, qNum: Int, seed: Int, yearStr: String, subjectTitle: String): PastPaperQuestion {
    return MusicPastPaper60QuestionsProvider.buildMusicQuestion(year, qNum, yearStr, subjectTitle)
  }

  private fun buildDancingPastQuestion(year: Int, qNum: Int, seed: Int, yearStr: String, subjectTitle: String): PastPaperQuestion {
    return DancingPastPaper60QuestionsProvider.buildDancingQuestion(year, qNum, yearStr, subjectTitle)
  }

  private data class Quad(
    val text: String,
    val options: List<String>,
    val correctIdx: Int,
    val explanation: String
  )
}
