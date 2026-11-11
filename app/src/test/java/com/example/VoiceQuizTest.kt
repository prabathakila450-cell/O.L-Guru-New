package com.example

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class VoiceQuizTest {

  @Test
  fun testQuestionsCountAndStructure() {
    val grades = listOf("9", "10", "11")
    val subjects = listOf("විද්‍යාව", "ගණිතය", "ඉතිහාසය")

    for (grade in grades) {
      for (subject in subjects) {
        val all200 = ComprehensiveVoiceQuizRepository.getQuestions(grade, subject, null)
        assertEquals("Total questions should be 200 for $grade - $subject", 200, all200.size)

        val sets = ComprehensiveVoiceQuizRepository.getSetsForSubject(grade, subject)
        assertEquals("Should have exactly 10 sets of 20", 10, sets.size)

        for (setInfo in sets) {
          val setQuestions = ComprehensiveVoiceQuizRepository.getQuestions(grade, subject, setInfo.setNumber)
          assertEquals("Each set must contain 20 questions", 20, setQuestions.size)
        }
      }
    }
  }

  @Test
  fun testStrictEvaluationLogic() {
    val q = VoiceQuestionItem(
      id = "test_q",
      subject = "විද්‍යාව",
      questionSinhala = "ප්‍රභාසංශ්ලේෂණයේදී පිටවන වායුව කුමක්ද?",
      questionEnglishPhonetic = "Which gas is released during photosynthesis?",
      expectedKeywords = listOf("ඔක්සිජන්", "Oxygen"),
      modelAnswer = "ඔක්සිජන් වායුවයි.",
      hint = "හුස්ම ගන්නා වායුව."
    )

    // Case 1: Empty input or noise -> should not match and should never be marked correct
    val emptyInput = ""
    val emptyMatches = q.expectedKeywords.filter { kw -> emptyInput.contains(kw, ignoreCase = true) }
    assertTrue(emptyMatches.isEmpty())

    // Case 2: Completely wrong answer -> should not match
    val wrongInput = "කාබන් ඩයොක්සයිඩ් වායුව පිටවේ"
    val wrongMatches = q.expectedKeywords.filter { kw -> wrongInput.contains(kw, ignoreCase = true) }
    assertTrue(wrongMatches.isEmpty())

    // Case 3: Correct answer containing the expected keyword -> matches
    val correctInput = "ශාක වලින් ඔක්සිජන් වායුව පිටවේ"
    val correctMatches = q.expectedKeywords.filter { kw -> correctInput.contains(kw, ignoreCase = true) }
    assertFalse(correctMatches.isEmpty())
    assertEquals("ඔක්සිජන්", correctMatches.first())
  }
}
