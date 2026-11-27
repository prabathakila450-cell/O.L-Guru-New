package com.example

object SinhalaG10TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return SinhalaG10TrueFalseBankPart1.getQuestions(grade) +
           SinhalaG10TrueFalseBankPart2.getQuestions(grade) +
           SinhalaG10TrueFalseBankPart3.getQuestions(grade) +
           SinhalaG10TrueFalseBankPart4.getQuestions(grade)
  }
}
