package com.example

object MathsG11TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return MathsG11TrueFalseBankPart1.getQuestions(grade) +
           MathsG11TrueFalseBankPart2.getQuestions(grade) +
           MathsG11TrueFalseBankPart3.getQuestions(grade) +
           MathsG11TrueFalseBankPart4.getQuestions(grade)
  }
}
