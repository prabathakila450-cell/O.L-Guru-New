package com.example

object EnglishG10TrueFalseCuratedBank {
  fun get500Questions(grade: Int): List<TrueFalseQuestionItem> {
    return EnglishG10TrueFalseBankPart1.getQuestions(grade) +
           EnglishG10TrueFalseBankPart2.getQuestions(grade) +
           EnglishG10TrueFalseBankPart3.getQuestions(grade) +
           EnglishG10TrueFalseBankPart4.getQuestions(grade)
  }
}
