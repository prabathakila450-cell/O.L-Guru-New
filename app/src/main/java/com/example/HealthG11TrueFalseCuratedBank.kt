package com.example

object HealthG11TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return HealthG11TrueFalseBankPart1.getQuestions(grade) +
           HealthG11TrueFalseBankPart2.getQuestions(grade) +
           HealthG11TrueFalseBankPart3.getQuestions(grade) +
           HealthG11TrueFalseBankPart4.getQuestions(grade)
  }
}
