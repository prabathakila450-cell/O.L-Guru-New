package com.example

object IctG10TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return IctG10TrueFalseBankPart1.getQuestions(grade) +
           IctG10TrueFalseBankPart2.getQuestions(grade) +
           IctG10TrueFalseBankPart3.getQuestions(grade) +
           IctG10TrueFalseBankPart4.getQuestions(grade)
  }
}
