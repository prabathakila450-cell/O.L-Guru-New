package com.example

object MathsG10TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return MathsG10TrueFalseBankPart1.getQuestions(grade) +
           MathsG10TrueFalseBankPart2.getQuestions(grade) +
           MathsG10TrueFalseBankPart3.getQuestions(grade) +
           MathsG10TrueFalseBankPart4.getQuestions(grade)
  }
}
