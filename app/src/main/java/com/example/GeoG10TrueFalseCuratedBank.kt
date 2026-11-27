package com.example

object GeoG10TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return GeoG10TrueFalseBankPart1.getQuestions(grade) +
           GeoG10TrueFalseBankPart2.getQuestions(grade) +
           GeoG10TrueFalseBankPart3.getQuestions(grade) +
           GeoG10TrueFalseBankPart4.getQuestions(grade)
  }
}
