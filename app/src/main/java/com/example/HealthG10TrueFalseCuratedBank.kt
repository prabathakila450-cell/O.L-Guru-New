package com.example

object HealthG10TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return HealthG10TrueFalseBankPart1.getQuestions(grade) +
           HealthG10TrueFalseBankPart2.getQuestions(grade) +
           HealthG10TrueFalseBankPart3.getQuestions(grade) +
           HealthG10TrueFalseBankPart4.getQuestions(grade)
  }
}
