package com.example

object ArtG10TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return ArtG10TrueFalseBankPart1.getQuestions(grade) +
           ArtG10TrueFalseBankPart2.getQuestions(grade) +
           ArtG10TrueFalseBankPart3.getQuestions(grade) +
           ArtG10TrueFalseBankPart4.getQuestions(grade)
  }
}
