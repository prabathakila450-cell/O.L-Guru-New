package com.example

object MusicG11TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return MusicG11TrueFalseBankPart1.getQuestions(grade) +
           MusicG11TrueFalseBankPart2.getQuestions(grade) +
           MusicG11TrueFalseBankPart3.getQuestions(grade) +
           MusicG11TrueFalseBankPart4.getQuestions(grade)
  }
}
