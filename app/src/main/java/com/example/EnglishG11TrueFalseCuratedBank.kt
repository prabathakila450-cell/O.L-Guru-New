package com.example

object EnglishG11TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return EnglishG11TrueFalseBankPart1.getQuestions(grade) +
           EnglishG11TrueFalseBankPart2.getQuestions(grade) +
           EnglishG11TrueFalseBankPart3.getQuestions(grade) +
           EnglishG11TrueFalseBankPart4.getQuestions(grade)
  }
}
