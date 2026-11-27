package com.example

object DancingG11TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return DancingG11TrueFalseBankPart1.getQuestions(grade) +
           DancingG11TrueFalseBankPart2.getQuestions(grade) +
           DancingG11TrueFalseBankPart3.getQuestions(grade) +
           DancingG11TrueFalseBankPart4.getQuestions(grade)
  }
}
