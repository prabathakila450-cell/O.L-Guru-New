package com.example

object ShortAnswerGrade10Data {

  val sets: List<QuestionSetInfo> =
    ShortAnswerGrade10Sets1To10.sets + ShortAnswerGrade10Sets11To20.sets

  val questions: List<ShortAnswerQuestion> =
    ShortAnswerGrade10Sets1To10.questions + ShortAnswerGrade10Sets11To20.questions

  fun getQuestionsForSet(setNumber: Int): List<ShortAnswerQuestion> {
    return questions.filter { it.setNumber == setNumber }
  }
}
