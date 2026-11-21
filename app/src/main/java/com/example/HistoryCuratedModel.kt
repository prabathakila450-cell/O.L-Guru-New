package com.example

enum class HistoryTopicDomain(val titleSinhala: String) {
  COLONIAL_SRI_LANKA("යටත්විජිත ශ්‍රී ලංකාව හා නිදහස් අරගල"),
  SOCIO_ECONOMIC_REVIVAL("සමාජ, ආර්ථික හා ආගමික පුනරුදය"),
  MODERN_CONSTITUTIONAL("නූතන ආණ්ඩුක්‍රම, නිදහස හා ලෝක ඉතිහාසය")
}

data class HistoryCuratedQuestion(
  val stem: String,
  val options: List<String>, // options[0] is correct
  val correctIndex: Int,
  val explanation: String,
  val topic: HistoryTopicDomain
) {
  fun toQSpec(): ExamQuestionHelper.QSpec {
    val correct = options.getOrElse(correctIndex) { "නිවැරදි පිළිතුර" }
    val distractors = options.filterIndexed { idx, _ -> idx != correctIndex }
    return ExamQuestionHelper.QSpec(
      topic = topic.titleSinhala,
      questionText = stem,
      correct = correct,
      distractors = distractors,
      explanation = explanation
    )
  }
}
