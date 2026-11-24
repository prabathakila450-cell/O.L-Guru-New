package com.example

/**
 * Authentic 60-Question Agriculture Past Paper Provider (2024..2018 = 420 unique Sinhala G10-11 O/L MCQs).
 */
object AgriculturePastPaper60QuestionsProvider {

  private val papersByYear: Array<List<PastPaperQuestion>> by lazy {
    TimedPastPaperQualityHelper.distributeTo7Years(
      AgriTimedPastPaperBank.buildAllSpecs(),
      isEnglish = false
    )
  }

  fun buildAgricultureQuestion(
    year: Int,
    qNum: Int,
    yearStr: String,
    subjectTitle: String
  ): PastPaperQuestion {
    val yIdx = TimedPastPaperQualityHelper.yearToIdx(year)
    val q = qNum.coerceIn(1, 60)
    return TimedPastPaperQualityHelper.toQuestionForYear(papersByYear[yIdx][q - 1], yearStr, subjectTitle)
  }
}
