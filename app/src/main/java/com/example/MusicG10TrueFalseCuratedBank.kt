package com.example

object MusicG10TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return MusicG10TrueFalseBankPart1.getQuestions(grade) +
           MusicG10TrueFalseBankPart2.getQuestions(grade) +
           MusicG10TrueFalseBankPart3.getQuestions(grade) +
           MusicG10TrueFalseBankPart4.getQuestions(grade)
  }
}
