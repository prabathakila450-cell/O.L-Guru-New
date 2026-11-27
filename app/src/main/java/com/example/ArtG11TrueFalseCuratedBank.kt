package com.example

object ArtG11TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return ArtG11TrueFalseBankPart1.getQuestions(grade) +
           ArtG11TrueFalseBankPart2.getQuestions(grade) +
           ArtG11TrueFalseBankPart3.getQuestions(grade) +
           ArtG11TrueFalseBankPart4.getQuestions(grade)
  }
}
