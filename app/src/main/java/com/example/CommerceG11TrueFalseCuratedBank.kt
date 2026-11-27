package com.example

object CommerceG11TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return CommerceG11TrueFalseBankPart1.getQuestions(grade) +
           CommerceG11TrueFalseBankPart2.getQuestions(grade) +
           CommerceG11TrueFalseBankPart3.getQuestions(grade) +
           CommerceG11TrueFalseBankPart4.getQuestions(grade)
  }
}
