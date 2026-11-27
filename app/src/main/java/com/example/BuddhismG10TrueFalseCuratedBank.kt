package com.example

object BuddhismG10TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return BuddhismG10TrueFalseBankPart1.getQuestions(grade) +
           BuddhismG10TrueFalseBankPart2.getQuestions(grade) +
           BuddhismG10TrueFalseBankPart3.getQuestions(grade) +
           BuddhismG10TrueFalseBankPart4.getQuestions(grade)
  }
}
