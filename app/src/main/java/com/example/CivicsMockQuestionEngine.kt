package com.example

object CivicsMockQuestionEngine {
    fun generateQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
        return if (grade == "10") {
            CivicsGrade10QuestionBank.getQuestion(term, paperIdx, qNum)
        } else {
            CivicsGrade11QuestionBank.getQuestion(term, paperIdx, qNum)
        }
    }
}
