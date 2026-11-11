package com.example

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class TrueFalse500QuestionBankTest {

  @Test
  fun testAll15SubjectsHave500UniqueQuestionsAndBalancedBatches() {
    val subjects = TrueFalseSubject.values()
    assertEquals(15, subjects.size)

    for (subject in subjects) {
      val questions = TrueFalse500Repository.getAllQuestions(10, subject)
      
      // 1. Total questions must be exactly 500
      assertEquals("Subject ${subject.displayName} must have 500 questions", 500, questions.size)

      // 2. All 500 statements must be 100% unique (no duplicates anywhere across batches)
      val uniqueStatements = questions.map { it.statement }.toSet()
      assertEquals("Subject ${subject.displayName} must have 500 UNIQUE statements without repetition", 500, uniqueStatements.size)

      var totalTrues = 0
      var totalFalses = 0

      // 3. Check every batch
      for (batchIdx in 0 until TrueFalse500Repository.TOTAL_BATCHES) {
        val batch = TrueFalse500Repository.getQuestionsForBatch(10, subject, batchIdx)
        val expectedSize = if (batchIdx < 16) 30 else 20
        assertEquals("Batch $batchIdx size for ${subject.displayName}", expectedSize, batch.size)

        // No duplicate statements within the batch
        val batchStatements = batch.map { it.statement }.toSet()
        assertEquals("Batch $batchIdx must have no duplicate statements", expectedSize, batchStatements.size)

        // Count True and False
        val trues = batch.count { it.isTrue }
        val falses = batch.count { !it.isTrue }
        val expectedTrues = if (batchIdx < 16) 15 else 10
        val expectedFalses = if (batchIdx < 16) 15 else 10

        assertEquals("Batch $batchIdx for ${subject.displayName} must have exactly $expectedTrues TRUE questions", expectedTrues, trues)
        assertEquals("Batch $batchIdx for ${subject.displayName} must have exactly $expectedFalses FALSE questions", expectedFalses, falses)

        totalTrues += trues
        totalFalses += falses
      }

      // 4. Total Trues and Falses across 500 questions
      assertEquals("Total Trues for ${subject.displayName} must be 250", 250, totalTrues)
      assertEquals("Total Falses for ${subject.displayName} must be 250", 250, totalFalses)
    }
  }
}
