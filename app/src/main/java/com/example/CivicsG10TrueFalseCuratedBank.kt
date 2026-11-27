package com.example

object CivicsG10TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return CivicsG10TrueFalseBankPart1.getQuestions(grade) +
           CivicsG10TrueFalseBankPart2.getQuestions(grade) +
           CivicsG10TrueFalseBankPart3.getQuestions(grade) +
           CivicsG10TrueFalseBankPart4.getQuestions(grade)
  }
}
