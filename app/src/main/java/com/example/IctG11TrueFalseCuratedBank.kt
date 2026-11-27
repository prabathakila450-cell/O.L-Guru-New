package com.example

object IctG11TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return IctG11TrueFalseBankPart1.getQuestions(grade) +
           IctG11TrueFalseBankPart2.getQuestions(grade) +
           IctG11TrueFalseBankPart3.getQuestions(grade) +
           IctG11TrueFalseBankPart4.getQuestions(grade)
  }
}
