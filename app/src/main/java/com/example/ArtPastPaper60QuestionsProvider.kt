package com.example

/**
 * Authentic 60-Question Art Past Paper Provider (2024..2018 = 420 unique Sinhala G10-11 O/L MCQs).
 */
object ArtPastPaper60QuestionsProvider {

  private val papersByYear: Array<List<PastPaperQuestion>> by lazy {
    TimedPastPaperQualityHelper.buildDirect7Years(
      isEnglish = false,
      interleaveTopics = false,
      rebalanceSlots = false
    ) { yearIdx, qNum ->
      ArtLiveExamQuestionBank.getQuestion("11", term = 3, paperIdx = yearIdx + 1, qNum = qNum)
    }
  }

  fun buildArtQuestion(
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
