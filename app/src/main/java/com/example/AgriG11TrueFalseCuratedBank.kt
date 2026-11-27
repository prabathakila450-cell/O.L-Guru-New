package com.example

object AgriG11TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return AgriG11TrueFalseBankPart1.getQuestions(grade) +
           AgriG11TrueFalseBankPart2.getQuestions(grade) +
           AgriG11TrueFalseBankPart3.getQuestions(grade) +
           AgriG11TrueFalseBankPart4.getQuestions(grade)
  }
}
