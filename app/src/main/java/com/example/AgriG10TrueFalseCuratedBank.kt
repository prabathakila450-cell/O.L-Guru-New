package com.example

object AgriG10TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return AgriG10TrueFalseBankPart1.getQuestions(grade) +
           AgriG10TrueFalseBankPart2.getQuestions(grade) +
           AgriG10TrueFalseBankPart3.getQuestions(grade) +
           AgriG10TrueFalseBankPart4.getQuestions(grade)
  }
}
