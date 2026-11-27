package com.example

object GeoG11TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return GeoG11TrueFalseBankPart1.getQuestions(grade) +
           GeoG11TrueFalseBankPart2.getQuestions(grade) +
           GeoG11TrueFalseBankPart3.getQuestions(grade) +
           GeoG11TrueFalseBankPart4.getQuestions(grade)
  }
}
