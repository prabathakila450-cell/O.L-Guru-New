package com.example

/**
 * Authentic 60-Question Health & Physical Education Past Paper Provider (2024..2018 = 420 unique Sinhala G10-11 O/L MCQs).
 */
object HealthPastPaper60QuestionsProvider {

  private val papersByYear: Array<List<PastPaperQuestion>> by lazy {
    TimedPastPaperQualityHelper.build7YearPapersFromLiveBank(isEnglish = false) { term, paperIdx, qNum ->
      HealthLiveExamQuestionBank.getQuestion("11", term, paperIdx, qNum)
    }
  }

  fun buildHealthQuestion(year: Int, qNum: Int, yearStr: String, subjectTitle: String): PastPaperQuestion {
    val yIdx = TimedPastPaperQualityHelper.yearToIdx(year)
    val q = qNum.coerceIn(1, 60)
    return TimedPastPaperQualityHelper.toQuestionForYear(papersByYear[yIdx][q - 1], yearStr, subjectTitle)
  }
}
