package com.example

object ShortAnswerGrade11Data {

  val sets: List<QuestionSetInfo> =
    ShortAnswerGrade11Sets1To10.sets + ShortAnswerGrade11Sets11To20.sets

  val questions: List<ShortAnswerQuestion> =
    ShortAnswerGrade11Sets1To10.questions + ShortAnswerGrade11Sets11To20.questions

  fun getQuestionsForSet(setNumber: Int): List<ShortAnswerQuestion> {
    return questions.filter { it.setNumber == setNumber }
  }
}
