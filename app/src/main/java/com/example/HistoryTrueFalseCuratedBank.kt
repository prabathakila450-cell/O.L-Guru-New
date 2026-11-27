package com.example

object HistoryTrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return HistoryTrueFalseBankPart1.getQuestions(grade) +
           HistoryTrueFalseBankPart2.getQuestions(grade) +
           HistoryTrueFalseBankPart3.getQuestions(grade) +
           HistoryTrueFalseBankPart4.getQuestions(grade)
  }
}
