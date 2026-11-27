package com.example

object DancingG10TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return DancingG10TrueFalseBankPart1.getQuestions(grade) +
           DancingG10TrueFalseBankPart2.getQuestions(grade) +
           DancingG10TrueFalseBankPart3.getQuestions(grade) +
           DancingG10TrueFalseBankPart4.getQuestions(grade)
  }
}
