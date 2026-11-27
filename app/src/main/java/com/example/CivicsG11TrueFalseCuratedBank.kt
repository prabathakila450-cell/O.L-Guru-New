package com.example

object CivicsG11TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return CivicsG11TrueFalseBankPart1.getQuestions(grade) +
           CivicsG11TrueFalseBankPart2.getQuestions(grade) +
           CivicsG11TrueFalseBankPart3.getQuestions(grade) +
           CivicsG11TrueFalseBankPart4.getQuestions(grade)
  }
}
