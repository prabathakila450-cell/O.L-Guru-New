package com.example

object BuddhismG11TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return BuddhismG11TrueFalseBankPart1.getQuestions(grade) +
           BuddhismG11TrueFalseBankPart2.getQuestions(grade) +
           BuddhismG11TrueFalseBankPart3.getQuestions(grade) +
           BuddhismG11TrueFalseBankPart4.getQuestions(grade)
  }
}
