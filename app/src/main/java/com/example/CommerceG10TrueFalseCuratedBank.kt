package com.example

object CommerceG10TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return CommerceG10TrueFalseBankPart1.getQuestions(grade) +
           CommerceG10TrueFalseBankPart2.getQuestions(grade) +
           CommerceG10TrueFalseBankPart3.getQuestions(grade) +
           CommerceG10TrueFalseBankPart4.getQuestions(grade)
  }
}
