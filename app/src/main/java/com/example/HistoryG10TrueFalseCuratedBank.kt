package com.example

object HistoryG10TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return HistoryG10TrueFalseBankPart1.getQuestions(grade) +
           HistoryG10TrueFalseBankPart2.getQuestions(grade) +
           HistoryG10TrueFalseBankPart3.getQuestions(grade) +
           HistoryG10TrueFalseBankPart4.getQuestions(grade)
  }
}
