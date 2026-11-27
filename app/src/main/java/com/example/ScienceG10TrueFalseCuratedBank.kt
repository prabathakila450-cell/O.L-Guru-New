package com.example

object ScienceG10TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return ScienceG10TrueFalseBankPart1.getQuestions(grade) +
           ScienceG10TrueFalseBankPart2.getQuestions(grade) +
           ScienceG10TrueFalseBankPart3.getQuestions(grade) +
           ScienceG10TrueFalseBankPart4.getQuestions(grade)
  }
}
