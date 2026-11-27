package com.example

object SinhalaG11TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return SinhalaG11TrueFalseBankPart1.getQuestions(grade) +
           SinhalaG11TrueFalseBankPart2.getQuestions(grade) +
           SinhalaG11TrueFalseBankPart3.getQuestions(grade) +
           SinhalaG11TrueFalseBankPart4.getQuestions(grade)
  }
}
