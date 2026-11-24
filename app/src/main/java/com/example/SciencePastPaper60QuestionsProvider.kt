package com.example

/**
 * Authentic 60-Question Science Past Paper Provider (2024..2018 = 420 unique G10-11 O/L MCQs).
 */
object SciencePastPaper60QuestionsProvider {

  private val papersByYear: Array<List<PastPaperQuestion>> by lazy {
    TimedPastPaperQualityHelper.buildDirect7Years(
      isEnglish = false,
      interleaveTopics = false,
      rebalanceSlots = false
    ) { yearIdx, qNum ->
      ScienceLiveExamQuestionBank.getQuestion("11", term = 3, paperIdx = yearIdx + 1, qNum = qNum)
    }
  }

  fun buildScienceQuestion(
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
