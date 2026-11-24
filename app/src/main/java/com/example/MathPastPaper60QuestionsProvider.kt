package com.example

/**
 * Authentic 60-Question Mathematics Past Paper Provider (2024..2018 = 420 unique Sinhala G10-11 O/L MCQs).
 * Topic-interleaved so consecutive questions never share the same Mathematics domain.
 */
object MathPastPaper60QuestionsProvider {

  private val papersByYear: Array<List<PastPaperQuestion>> by lazy {
    TimedPastPaperQualityHelper.buildDirect7Years(
      isEnglish = false,
      interleaveTopics = true,
      rebalanceSlots = true
    ) { yearIdx, qNum ->
      when (yearIdx) {
        0 -> MathGrade11QuestionBank.getQuestion(3, 1, qNum)
        1 -> MathGrade11QuestionBank.getQuestion(2, 1, qNum)
        2 -> MathGrade11QuestionBank.getQuestion(1, 1, qNum)
        3 -> MathGrade10QuestionBank.getQuestion(3, 1, qNum)
        4 -> MathGrade10QuestionBank.getQuestion(2, 1, qNum)
        5 -> MathGrade10QuestionBank.getQuestion(1, 1, qNum)
        else -> MathGrade11QuestionBank.getQuestion(3, 2, qNum)
      }
    }
  }

  fun buildMathQuestion(
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
