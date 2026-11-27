package com.example

object ScienceG11TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return ScienceG11TrueFalseBankPart1.getQuestions(grade) +
           ScienceG11TrueFalseBankPart2.getQuestions(grade) +
           ScienceG11TrueFalseBankPart3.getQuestions(grade) +
           ScienceG11TrueFalseBankPart4.getQuestions(grade)
  }
}
