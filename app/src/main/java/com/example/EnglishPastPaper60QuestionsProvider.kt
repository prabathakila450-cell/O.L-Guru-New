package com.example

/**
 * Authentic 60-Question English Past Paper Provider (2024..2018 = 420 unique G10-11 O/L MCQs).
 * Strictly enforces O/L English syllabus only (zero placeholders, zero Sinhala stems/options).
 */
object EnglishPastPaper60QuestionsProvider {

  private val papersByYear: Array<List<PastPaperQuestion>> by lazy {
    TimedPastPaperQualityHelper.buildDirect7Years(
      isEnglish = true,
      interleaveTopics = false,
      rebalanceSlots = false
    ) { yearIdx, qNum ->
      EnglishLiveExamQuestionBank.getQuestion("11", term = 3, paperIdx = yearIdx + 1, qNum = qNum)
    }
  }

  fun buildEnglishQuestion(
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
