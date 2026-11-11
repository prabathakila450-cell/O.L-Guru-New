package com.example

import org.junit.Assert.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
  @Test
  fun testFlashcards() {
    val grades = listOf("9", "10", "11")
    val subjects = ComprehensiveFlashcardRepository.availableSubjects
    var emptyCount = 0
    for (g in grades) {
      for (sub in subjects) {
        val cards = ComprehensiveFlashcardRepository.getFlashcards(g, sub, null)
        for (c in cards) {
          if (c.questionFront.isBlank() || c.answerBack.isBlank()) {
            println("EMPTY CARD FOUND: Grade $g, Sub $sub, Set ${c.setNumber}, Index ${c.cardIndexInSet}")
            emptyCount++
          }
        }
      }
    }
    println(">>> Done checking all cards! Total empty cards: $emptyCount")
    assertEquals(0, emptyCount)
  }

  @Test
  fun testFlashcardsSetUniqueness() {
    val grades = listOf("9", "10", "11")
    val subjects = ComprehensiveFlashcardRepository.availableSubjects
    var duplicateSetCount = 0

    for (g in grades) {
      for (sub in subjects) {
        for (setNum in 1..20) {
          val cards = ComprehensiveFlashcardRepository.getFlashcards(g, sub, setNum)
          assertEquals("Each set must have 20 cards", 20, cards.size)
          val questions = cards.map { it.questionFront }
          val uniqueQuestions = questions.distinct()
          if (uniqueQuestions.size < 20) {
            duplicateSetCount++
            println("DUPLICATES IN SET: Grade $g, Sub $sub, Set $setNum -> Unique: ${uniqueQuestions.size}/20")
            val dupes = questions.groupBy { it }.filter { it.value.size > 1 }
            dupes.forEach { (q, list) ->
              println("  Duplicated question (${list.size} times): $q")
            }
          }
        }
      }
    }
    assertEquals("Number of sets with duplicate questions inside batch must be 0", 0, duplicateSetCount)
  }

  @Test
  fun testGrade10MathQuizDistinctness() {
    val allQuestions = mutableListOf<MathQuizQuestion>()
    for (set in 1..80) {
      val questions = MathQuizEngine.getSetQuestions(10, set)
      allQuestions.addAll(questions)
    }
    val duplicates = allQuestions.groupBy { it.questionText }.filter { it.value.size > 1 }
    val uniqueCount = allQuestions.map { it.questionText }.toSet().size
    val firstDup = duplicates.entries.firstOrNull()
    val msg = "Total duplicates: ${duplicates.size}. Unique: $uniqueCount/2000. Example: ${firstDup?.key} in sets ${firstDup?.value?.map { it.setNumber }}"
    assertEquals(msg, 2000, uniqueCount)
  }

  @Test
  fun testMatchingBankIntegrity() {
    val sets = InteractiveMatchingAndTimelineBank.matchSets
    assertEquals("Should have exactly 1500 sets (15 subjects x 100 sets)", 1500, sets.size)

    val subjects = sets.map { it.subject }.distinct()
    assertEquals("Should have exactly 15 subjects", 15, subjects.size)

    for (subject in subjects) {
      val subjectSets = sets.filter { it.subject == subject }
      assertEquals("Subject $subject must have exactly 100 sets", 100, subjectSets.size)

      val allItems = subjectSets.flatMap { it.items }
      assertEquals("Subject $subject must have exactly 1000 items", 1000, allItems.size)

      val uniqueQuestions = allItems.map { it.leftText }.distinct()
      assertEquals("Subject $subject must have 1000 unique questions", 1000, uniqueQuestions.size)

      val uniqueAnswers = allItems.map { it.rightCorrectText }.distinct()
      assertEquals("Subject $subject must have 1000 unique answers", 1000, uniqueAnswers.size)

      for (item in allItems) {
        assertTrue("Question cannot be blank in $subject", item.leftText.isNotBlank())
        assertTrue("Answer cannot be blank in $subject", item.rightCorrectText.isNotBlank())
      }
    }
  }

  @Test
  fun testVoiceQuizSetUniqueness() {
    val grades = listOf("9", "10", "11")
    val subjects = ComprehensiveVoiceQuizRepository.availableSubjects
    var duplicateSetCount = 0

    for (g in grades) {
      for (sub in subjects) {
        for (setNum in 1..10) {
          val questions = ComprehensiveVoiceQuizRepository.getQuestions(g, sub, setNum)
          assertEquals("Grade $g $sub Set $setNum must have 20 questions", 20, questions.size)
          val qTexts = questions.map { it.questionSinhala }
          val uniqueTexts = qTexts.distinct()
          if (uniqueTexts.size < 20) {
            duplicateSetCount++
            println("DUPLICATES IN VOICE QUIZ SET: Grade $g, Sub $sub, Set $setNum -> Unique: ${uniqueTexts.size}/20")
            val dupes = qTexts.groupBy { it }.filter { it.value.size > 1 }
            dupes.forEach { (q, list) ->
              println("  Duplicated question (${list.size} times): $q")
            }
          }
        }
      }
    }
    assertEquals("Number of Voice Quiz sets with duplicate questions inside batch must be 0", 0, duplicateSetCount)
  }

  @Test
  fun testStructuredEssaySetUniqueness() {
    val grades = listOf("9", "10", "11")
    val subjects = ComprehensiveStructuredEssayRepository.availableSubjects
    var duplicateSetCount = 0

    for (g in grades) {
      for (sub in subjects) {
        for (setNum in 1..25) {
          val questions = ComprehensiveStructuredEssayRepository.getQuestions(g, sub, setNum)
          assertEquals("Grade $g $sub Set $setNum must have 20 questions", 20, questions.size)
          val qTitles = questions.map { it.topicSinhala }
          val uniqueTitles = qTitles.distinct()
          if (uniqueTitles.size < 20) {
            duplicateSetCount++
            println("DUPLICATES IN STRUCTURED ESSAY SET: Grade $g, Sub $sub, Set $setNum -> Unique: ${uniqueTitles.size}/20")
            val dupes = qTitles.groupBy { it }.filter { it.value.size > 1 }
            dupes.forEach { (q, list) ->
              println("  Duplicated question (${list.size} times): $q")
            }
          }
        }
      }
    }
    assertEquals("Number of Structured Essay sets with duplicate question titles inside batch must be 0", 0, duplicateSetCount)
  }

  @Test
  fun testTrueFalse500SetUniqueness() {
    val grades = listOf(9, 10, 11)
    val subjects = TrueFalseSubject.values()
    var duplicateBatchCount = 0

    for (g in grades) {
      for (sub in subjects) {
        for (batchIdx in 0 until TrueFalse500Repository.TOTAL_BATCHES) {
          val questions = TrueFalse500Repository.getQuestionsForBatch(g, sub, batchIdx)
          val statements = questions.map { it.statement }
          val uniqueStatements = statements.distinct()
          if (uniqueStatements.size < questions.size) {
            duplicateBatchCount++
            println("DUPLICATES IN TRUE/FALSE BATCH: Grade $g, Sub ${sub.displayName}, Batch ${batchIdx + 1} -> Unique: ${uniqueStatements.size}/${questions.size}")
            val dupes = statements.groupBy { it }.filter { it.value.size > 1 }
            dupes.forEach { (q, list) ->
              println("  Duplicated statement (${list.size} times): $q")
            }
          }
        }
      }
    }
    assertEquals("Number of True/False batches with duplicate statements must be 0", 0, duplicateBatchCount)
  }

  @Test
  fun testSubjectMaster20x20SetUniqueness() {
    val subjects = listOf(
      "භූගෝල විද්‍යාව", "විද්‍යාව", "ව්‍යාපාර හා ගිණුම්කරණය", "ඉතිහාසය",
      "ඉංග්‍රීසි", "සිංහල", "බුද්ධ ධර්මය", "ගණිතය", "පුරවැසි අධ්‍යාපනය",
      "තොරතුරු තාක්ෂණය", "නර්තනය", "කෘෂි විද්‍යාව", "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය"
    )
    var duplicateCategoryCount = 0

    for (sub in subjects) {
      val categories = SubjectMasterRepository.getCategoriesForSubject(sub)
      assertEquals("Subject $sub must have 20 categories", 20, categories.size)
      for (cat in categories) {
        val qList = cat.points
        assertEquals("Category '${cat.titleSinhala}' in $sub must have 20 questions", 20, qList.size)
        val qTexts = qList.map { it.title }
        val uniqueQ = qTexts.distinct()
        if (uniqueQ.size < 20) {
          duplicateCategoryCount++
          println("DUPLICATES IN SUBJECT MASTER 20x20: Sub $sub, Cat '${cat.titleSinhala}' -> Unique: ${uniqueQ.size}/20")
          val dupes = qTexts.groupBy { it }.filter { it.value.size > 1 }
          dupes.forEach { (q, list) ->
            println("  Duplicated question (${list.size} times): $q")
          }
        }
      }
    }
    assertEquals("Number of Subject Master categories with duplicate questions must be 0", 0, duplicateCategoryCount)
  }

  @Test
  fun testShortAnswerSetUniqueness() {
    val grades = listOf("10", "11")
    val subjects = ShortAnswerMasterRepository.subjects
    var duplicateSetCount = 0

    for (g in grades) {
      for (sub in subjects) {
        for (setNum in 1..20) {
          val questions = ShortAnswerMasterRepository.getQuestions(g, sub, setNum)
          assertTrue("Grade $g $sub Set $setNum must have at least 10 questions", questions.size >= 10)
          val qTexts = questions.map { it.question }
          val uniqueTexts = qTexts.distinct()
          if (uniqueTexts.size < questions.size) {
            duplicateSetCount++
            println("DUPLICATES IN SHORT ANSWER SET: Grade $g, Sub $sub, Set $setNum -> Unique: ${uniqueTexts.size}/${questions.size}")
            val dupes = qTexts.groupBy { it }.filter { it.value.size > 1 }
            dupes.forEach { (q, list) ->
              println("  Duplicated question (${list.size} times): $q")
            }
          }
        }
      }
    }
    assertEquals("Number of Short Answer sets with duplicate questions must be 0", 0, duplicateSetCount)
  }

  @Test
  fun testScienceMockExamPapersUniqueness() {
    val grades = listOf("10", "11")
    val terms = listOf(1, 2, 3)
    var duplicateWithinPaperCount = 0
    var duplicateAcrossPapersCount = 0

    for (g in grades) {
      for (t in terms) {
        val paperSignatures = mutableSetOf<String>()
        val papers = MockExamDataBank.getPapersForTermAndSubject(g, t, "විද්‍යාව")
        assertEquals("Grade $g Term $t must provide exactly 30 papers", 30, papers.size)

        for (p in papers) {
          assertEquals("Grade $g Term $t Paper ${p.paperNumber} must have 60 questions", 60, p.questions.size)
          val qTexts = p.questions.map { it.questionText }
          val uniqueQ = qTexts.distinct()
          if (uniqueQ.size < 60) {
            duplicateWithinPaperCount++
            println("DUPLICATES IN PAPER: Grade $g Term $t Paper ${p.paperNumber} -> Unique: ${uniqueQ.size}/60")
            val dupes = qTexts.groupBy { it }.filter { it.value.size > 1 }
            dupes.forEach { (q, list) ->
              println("  Duplicated (${list.size} times): $q")
            }
          }

          // Signature of first 5 questions to verify distinct papers
          val sig = p.questions.take(10).joinToString("|||") { it.questionText }
          if (paperSignatures.contains(sig)) {
            duplicateAcrossPapersCount++
            println("DUPLICATE PAPER DETECTED: Grade $g Term $t Paper ${p.paperNumber} matches another paper!")
          }
          paperSignatures.add(sig)
        }
      }
    }

    assertEquals("Number of Science papers with internal duplicate questions must be 0", 0, duplicateWithinPaperCount)
    assertEquals("Number of identical duplicate papers must be 0", 0, duplicateAcrossPapersCount)
  }

  @Test
  fun testMathMockExamPapersUniqueness() {
    val grades = listOf("10", "11")
    val terms = listOf(1, 2, 3)
    var duplicateWithinPaperCount = 0
    var duplicateAcrossPapersCount = 0

    for (g in grades) {
      for (t in terms) {
        val paperSignatures = mutableSetOf<String>()
        val papers = MockExamDataBank.getPapersForTermAndSubject(g, t, "ගණිතය")
        assertEquals("Grade $g Term $t must provide exactly 30 papers", 30, papers.size)

        for (p in papers) {
          assertEquals("Grade $g Term $t Paper ${p.paperNumber} must have 60 questions", 60, p.questions.size)
          val qTexts = p.questions.map { it.questionText }
          val uniqueQ = qTexts.distinct()
          if (uniqueQ.size < 60) {
            duplicateWithinPaperCount++
            println("DUPLICATES IN MATH PAPER: Grade $g Term $t Paper ${p.paperNumber} -> Unique: ${uniqueQ.size}/60")
            val dupes = qTexts.groupBy { it }.filter { it.value.size > 1 }
            dupes.forEach { (q, list) ->
              println("  Duplicated (${list.size} times): $q")
            }
          }

          // Signature of first 10 questions to verify distinct papers
          val sig = p.questions.take(10).joinToString("|||") { it.questionText }
          if (paperSignatures.contains(sig)) {
            duplicateAcrossPapersCount++
            println("DUPLICATE MATH PAPER DETECTED: Grade $g Term $t Paper ${p.paperNumber} matches another paper!")
          }
          paperSignatures.add(sig)

          for (q in p.questions) {
            assertTrue("Math question cannot be blank", q.questionText.isNotBlank())
            assertEquals("Each question must have 4 options", 4, q.options.size)
            assertTrue("Correct option must be in 1..4", q.correctOption in 1..4)
            assertTrue("Explanation cannot be blank", q.explanation.isNotBlank())
          }
        }
      }
    }

    assertEquals("Number of Math papers with internal duplicate questions must be 0", 0, duplicateWithinPaperCount)
    assertEquals("Number of identical duplicate math papers must be 0", 0, duplicateAcrossPapersCount)
  }

  @Test
  fun testHistoryMockExamPapersUniqueness() {
    val grades = listOf("10", "11")
    val terms = listOf(1, 2, 3)
    var duplicateWithinPaperCount = 0
    var duplicateAcrossPapersCount = 0

    for (g in grades) {
      for (t in terms) {
        val paperSignatures = mutableSetOf<String>()
        val papers = MockExamDataBank.getPapersForTermAndSubject(g, t, "ඉතිහාසය")
        assertEquals("Grade $g Term $t must provide exactly 30 papers", 30, papers.size)

        for (p in papers) {
          assertEquals("Grade $g Term $t Paper ${p.paperNumber} must have 60 questions", 60, p.questions.size)
          val qTexts = p.questions.map { it.questionText }
          val uniqueQ = qTexts.distinct()
          if (uniqueQ.size < 60) {
            duplicateWithinPaperCount++
            println("DUPLICATES IN HISTORY PAPER: Grade $g Term $t Paper ${p.paperNumber} -> Unique: ${uniqueQ.size}/60")
            val dupes = qTexts.groupBy { it }.filter { it.value.size > 1 }
            dupes.forEach { (q, list) ->
              println("  Duplicated (${list.size} times): $q")
            }
          }

          // Signature of first 10 questions to verify distinct papers
          val sig = p.questions.take(10).joinToString("|||") { it.questionText }
          if (paperSignatures.contains(sig)) {
            duplicateAcrossPapersCount++
            println("DUPLICATE HISTORY PAPER DETECTED: Grade $g Term $t Paper ${p.paperNumber} matches another paper!")
          }
          paperSignatures.add(sig)

          for (q in p.questions) {
            assertTrue("History question cannot be blank", q.questionText.isNotBlank())
            assertEquals("Each question must have 4 options", 4, q.options.size)
            assertTrue("Correct option must be in 1..4", q.correctOption in 1..4)
            assertTrue("Explanation cannot be blank", q.explanation.isNotBlank())
          }
        }
      }
    }

    assertEquals("Number of History papers with internal duplicate questions must be 0", 0, duplicateWithinPaperCount)
    assertEquals("Number of identical duplicate history papers must be 0", 0, duplicateAcrossPapersCount)
  }

  @Test
  fun testBuddhismMockExamPapersUniqueness() {
    val grades = listOf("10", "11")
    val terms = listOf(1, 2, 3)
    var duplicateWithinPaperCount = 0
    var duplicateAcrossPapersCount = 0

    for (g in grades) {
      for (t in terms) {
        val paperSignatures = mutableSetOf<String>()
        val papers = MockExamDataBank.getPapersForTermAndSubject(g, t, "බුද්ධ ධර්මය")
        assertEquals("Grade $g Term $t must provide exactly 30 papers", 30, papers.size)

        for (p in papers) {
          assertEquals("Grade $g Term $t Paper ${p.paperNumber} must have 60 questions", 60, p.questions.size)
          val qTexts = p.questions.map { it.questionText }
          val uniqueQ = qTexts.distinct()
          if (uniqueQ.size < 60) {
            duplicateWithinPaperCount++
            println("DUPLICATES IN BUDDHISM PAPER: Grade $g Term $t Paper ${p.paperNumber} -> Unique: ${uniqueQ.size}/60")
            val dupes = qTexts.groupBy { it }.filter { it.value.size > 1 }
            dupes.forEach { (q, list) ->
              println("  Duplicated (${list.size} times): $q")
            }
          }

          // Signature of first 10 questions to verify distinct papers
          val sig = p.questions.take(10).joinToString("|||") { it.questionText }
          if (paperSignatures.contains(sig)) {
            duplicateAcrossPapersCount++
            println("DUPLICATE BUDDHISM PAPER DETECTED: Grade $g Term $t Paper ${p.paperNumber} matches another paper!")
          }
          paperSignatures.add(sig)

          for (q in p.questions) {
            assertTrue("Buddhism question cannot be blank", q.questionText.isNotBlank())
            assertEquals("Each question must have 4 options", 4, q.options.size)
            assertTrue("Correct option must be in 1..4", q.correctOption in 1..4)
            assertTrue("Explanation cannot be blank", q.explanation.isNotBlank())
          }
        }
      }
    }

    assertEquals("Number of Buddhism papers with internal duplicate questions must be 0", 0, duplicateWithinPaperCount)
    assertEquals("Number of identical duplicate Buddhism papers must be 0", 0, duplicateAcrossPapersCount)
  }

  @Test
  fun testSinhalaMockExamPapersUniqueness() {
    val grades = listOf("10", "11")
    val terms = listOf(1, 2, 3)
    var duplicateWithinPaperCount = 0
    var duplicateAcrossPapersCount = 0

    for (g in grades) {
      for (t in terms) {
        val paperSignatures = mutableSetOf<String>()
        val papers = MockExamDataBank.getPapersForTermAndSubject(g, t, "සිංහල")
        assertEquals("Grade $g Term $t must provide exactly 30 papers", 30, papers.size)

        for (p in papers) {
          assertEquals("Grade $g Term $t Paper ${p.paperNumber} must have 60 questions", 60, p.questions.size)
          val qTexts = p.questions.map { it.questionText }
          val uniqueQ = qTexts.distinct()
          if (uniqueQ.size < 60) {
            duplicateWithinPaperCount++
            println("DUPLICATES IN SINHALA PAPER: Grade $g Term $t Paper ${p.paperNumber} -> Unique: ${uniqueQ.size}/60")
            val dupes = qTexts.groupBy { it }.filter { it.value.size > 1 }
            dupes.forEach { (q, list) ->
              println("  Duplicated (${list.size} times): $q")
            }
          }

          // Signature of first 10 questions to verify distinct papers
          val sig = p.questions.take(10).joinToString("|||") { it.questionText }
          if (paperSignatures.contains(sig)) {
            duplicateAcrossPapersCount++
            println("DUPLICATE SINHALA PAPER DETECTED: Grade $g Term $t Paper ${p.paperNumber} matches another paper!")
          }
          paperSignatures.add(sig)

          for (q in p.questions) {
            assertTrue("Sinhala question cannot be blank", q.questionText.isNotBlank())
            assertEquals("Each question must have 4 options", 4, q.options.size)
            assertTrue("Correct option must be in 1..4", q.correctOption in 1..4)
            assertTrue("Explanation cannot be blank", q.explanation.isNotBlank())
          }
        }
      }
    }

    assertEquals("Number of Sinhala papers with internal duplicate questions must be 0", 0, duplicateWithinPaperCount)
    assertEquals("Number of identical duplicate Sinhala papers must be 0", 0, duplicateAcrossPapersCount)
  }
  @Test
  fun testCivicsMockExamPapersUniqueness() {
    val grades = listOf("10", "11")
    val terms = listOf(1, 2, 3)
    for (g in grades) {
      for (t in terms) {
        val allQuestionsInTerm = mutableSetOf<String>()
        val papers = MockExamDataBank.getPapersForTermAndSubject(g, t, "පුරවැසි අධ්‍යාපනය")
        assertEquals("Grade $g Term $t must provide exactly 30 papers", 30, papers.size)
        
        for (p in papers) {
          assertEquals("Grade $g Term $t Paper ${p.paperNumber} must have 60 questions", 60, p.questions.size)
          for (q in p.questions) {
            assertFalse("Question duplicate found in Grade $g Term $t: ${q.questionText}", allQuestionsInTerm.contains(q.questionText))
            allQuestionsInTerm.add(q.questionText)
            
            assertTrue("Civics question cannot be blank", q.questionText.isNotBlank())
            assertEquals("Each question must have 4 options", 4, q.options.size)
            assertTrue("Correct option must be in 1..4", q.correctOption in 1..4)
            assertTrue("Explanation cannot be blank", q.explanation.isNotBlank())
          }
        }
        assertEquals("Grade $g Term $t must have 1800 unique questions", 1800, allQuestionsInTerm.size)
      }
    }
  }

  @Test
  fun testHealthMockExamPapersUniqueness() {
    val grades = listOf("10", "11")
    val terms = listOf(1, 2, 3)
    for (g in grades) {
      for (t in terms) {
        val allQuestionsInTerm = mutableSetOf<String>()
        val papers = MockExamDataBank.getPapersForTermAndSubject(g, t, "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය")
        assertEquals("Grade $g Term $t must provide exactly 30 papers", 30, papers.size)
        
        for (p in papers) {
          assertEquals("Grade $g Term $t Paper ${p.paperNumber} must have 60 questions", 60, p.questions.size)
          for (q in p.questions) {
            assertFalse("Question duplicate found in Grade $g Term $t: ${q.questionText}", allQuestionsInTerm.contains(q.questionText))
            allQuestionsInTerm.add(q.questionText)
            
            assertTrue("Health question cannot be blank", q.questionText.isNotBlank())
            assertEquals("Each question must have 4 options", 4, q.options.size)
            assertTrue("Correct option must be in 1..4", q.correctOption in 1..4)
            assertTrue("Explanation cannot be blank", q.explanation.isNotBlank())
          }
        }
        assertEquals("Grade $g Term $t must have 1800 unique questions", 1800, allQuestionsInTerm.size)
      }
    }
  }

  @Test
  fun testGeographyMockExamPapersUniqueness() {
    val grades = listOf("10", "11")
    val terms = listOf(1, 2, 3)
    for (g in grades) {
      for (t in terms) {
        val allQuestionsInTerm = mutableSetOf<String>()
        val papers = MockExamDataBank.getPapersForTermAndSubject(g, t, "භූගෝල විද්‍යාව")
        assertEquals("Grade $g Term $t must provide exactly 30 papers", 30, papers.size)
        
        for (p in papers) {
          assertEquals("Grade $g Term $t Paper ${p.paperNumber} must have 60 questions", 60, p.questions.size)
          for (q in p.questions) {
            assertFalse("Question duplicate found in Grade $g Term $t: ${q.questionText}", allQuestionsInTerm.contains(q.questionText))
            allQuestionsInTerm.add(q.questionText)
            
            assertTrue("Geography question cannot be blank", q.questionText.isNotBlank())
            assertEquals("Each question must have 4 options", 4, q.options.size)
            assertTrue("Correct option must be in 1..4", q.correctOption in 1..4)
            assertTrue("Explanation cannot be blank", q.explanation.isNotBlank())
          }
        }
        assertEquals("Grade $g Term $t must have 1800 unique questions", 1800, allQuestionsInTerm.size)
      }
    }
  }

  @Test
  fun testAgriMockExamPapersUniqueness() {
    val grades = listOf("10", "11")
    val terms = listOf(1, 2, 3)
    for (g in grades) {
      for (t in terms) {
        val allQuestionsInTerm = mutableSetOf<String>()
        val papers = MockExamDataBank.getPapersForTermAndSubject(g, t, "කෘෂි විද්‍යාව")
        assertEquals("Grade $g Term $t must provide exactly 30 papers", 30, papers.size)
        
        for (p in papers) {
          assertEquals("Grade $g Term $t Paper ${p.paperNumber} must have 60 questions", 60, p.questions.size)
          for (q in p.questions) {
            assertFalse("Question duplicate found in Grade $g Term $t: ${q.questionText}", allQuestionsInTerm.contains(q.questionText))
            allQuestionsInTerm.add(q.questionText)
            
            assertTrue("Agri question cannot be blank", q.questionText.isNotBlank())
            assertEquals("Each question must have 4 options", 4, q.options.size)
            assertTrue("Correct option must be in 1..4", q.correctOption in 1..4)
            assertTrue("Explanation cannot be blank", q.explanation.isNotBlank())
          }
        }
        assertEquals("Grade $g Term $t must have 1800 unique questions", 1800, allQuestionsInTerm.size)
      }
    }
  }

  @Test
  fun testCommerceMockExamPapersUniqueness() {
    val grades = listOf("10", "11")
    val terms = listOf(1, 2, 3)
    for (g in grades) {
      for (t in terms) {
        val allQuestionsInTerm = mutableSetOf<String>()
        val papers = MockExamDataBank.getPapersForTermAndSubject(g, t, "ව්‍යාපාර හා ගිණුම්කරණය")
        assertEquals("Grade $g Term $t must provide exactly 30 papers", 30, papers.size)
        
        for (p in papers) {
          assertEquals("Grade $g Term $t Paper ${p.paperNumber} must have 60 questions", 60, p.questions.size)
          for (q in p.questions) {
            assertFalse("Question duplicate found in Grade $g Term $t: ${q.questionText}", allQuestionsInTerm.contains(q.questionText))
            allQuestionsInTerm.add(q.questionText)
            
            assertTrue("Commerce question cannot be blank", q.questionText.isNotBlank())
            assertEquals("Each question must have 4 options", 4, q.options.size)
            assertTrue("Correct option must be in 1..4", q.correctOption in 1..4)
            assertTrue("Explanation cannot be blank", q.explanation.isNotBlank())
          }
        }
        assertEquals("Grade $g Term $t must have 1800 unique questions", 1800, allQuestionsInTerm.size)
      }
    }
  }

  @Test
  fun testTimedPastPapersUniqueness() {
    val subjects = listOf(
      "විද්‍යාව (Science)", "ගණිතය (Mathematics)", "ඉතිහාසය (History)", 
      "සිංහල (Sinhala)", "ඉංග්‍රීසි (English)", "බුද්ධ ධර්මය (Buddhism)", 
      "තොරතුරු තාක්ෂණය (ICT)", "ව්‍යාපාර හා ගිණුම්කරණය (Commerce)", 
      "පුරවැසි අධ්‍යාපනය (Civics)", "භූගෝල විද්‍යාව (Geography)", 
      "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය (Health)", "කෘෂි විද්‍යාව (Agriculture)",
      "චිත්‍ර කලාව (Art)", "සංගීතය (Music)", "නර්තනය (Dancing)"
    )
    val years = listOf("2024", "2023", "2022", "2021", "2020", "2019")
    
    for (subject in subjects) {
      val allQuestionsForSubject = mutableSetOf<String>()
      for (year in years) {
        val questions = TimedPastPaperYearProvider.getYearSpecificQuestions(subject, year)
        assertEquals("Subject $subject Year $year must have 60 questions", 60, questions.size)
        
        val qTexts = questions.map { it.questionText }
        val uniqueQ = qTexts.distinct()
        
        println("Checking $subject - $year")
        assertEquals("INTERNAL DUPLICATE: Subject $subject Year $year has duplicates! Unique: ${uniqueQ.size}/60", 60, uniqueQ.size)
        
        // Across years check
        for (q in qTexts) {
          // We strip the prefix [$year O/L - Q$q] to check if the CORE question is unique
          val coreQuestion = q.substringAfter("] ")
          assertFalse("CROSS-YEAR DUPLICATE: Subject $subject Year $year has duplicate core question: $coreQuestion", allQuestionsForSubject.contains(coreQuestion))
          allQuestionsForSubject.add(coreQuestion)
        }
      }
    }
  }

  @Test
  fun testShortAnswerMasterHubAllSubjectsCategoriesAndQuestions() {
    val subjects = ShortAnswerMasterRepository.subjects
    assertEquals("Must have 15 subjects", 15, subjects.size)

    for (subject in subjects) {
      val sets = ShortAnswerMasterRepository.getSetsForSubject("10", subject)
      assertEquals("Subject $subject must have exactly 20 sets", 20, sets.size)

      val setTitles = sets.map { it.titleSinhala }
      val uniqueSetTitles = setTitles.distinct()
      assertEquals("Subject $subject must have 20 distinct set titles", 20, uniqueSetTitles.size)

      // Ensure no generic placeholder titles
      for (title in setTitles) {
        assertFalse("Subject $subject has placeholder title: $title", title.contains("විෂය නිර්දේශ ඒකකය"))
      }

      val allSubjectQuestions = mutableSetOf<String>()
      for (setNum in 1..20) {
        val questions = ShortAnswerMasterRepository.getQuestions("10", subject, setNum)
        assertEquals("Subject $subject Set $setNum must have exactly 10 questions", 10, questions.size)

        for (q in questions) {
          assertTrue("Question prompt cannot be blank in $subject Set $setNum", q.question.isNotBlank())
          assertTrue("Key points cannot be empty in $subject Set $setNum", q.keyPoints.isNotEmpty())
          assertTrue("Official marking scheme cannot be blank in $subject Set $setNum", q.officialMarkingScheme.isNotBlank())
          assertTrue("Sample ideal answer cannot be blank in $subject Set $setNum", q.sampleIdealAnswer.isNotBlank())
          assertFalse("Question must not contain template variable in $subject Set $setNum: ${q.question}", q.question.contains("\$topic"))

          assertFalse(
            "DUPLICATE QUESTION DETECTED in $subject! Set $setNum Question: '${q.question}' already exists in another set!",
            allSubjectQuestions.contains(q.question)
          )
          allSubjectQuestions.add(q.question)
        }
      }
      assertEquals("Subject $subject must have 200 completely unique questions across its 20 sets", 200, allSubjectQuestions.size)
    }
  }

  @Test
  fun testDaily10ChallengeAllSubjectsCategoriesAndQuestions() {
    val subjects = DailyChallengeMasterRepository.allSubjects
    assertEquals("Must have 16 subjects including mixed", 16, subjects.size)

    val globalAllQuestions = mutableSetOf<String>()

    for (subject in subjects) {
      val sets = DailyChallengeMasterRepository.getSetsForSubject(subject)
      assertEquals("Subject $subject must have exactly 20 sets", 20, sets.size)

      val setTitles = sets.map { it.titleSinhala }
      val uniqueSetTitles = setTitles.distinct()
      assertEquals("Subject $subject must have 20 distinct set titles", 20, uniqueSetTitles.size)

      val allSubjectQuestions = mutableSetOf<String>()
      for (setNum in 1..20) {
        val questions = DailyChallengeMasterRepository.getQuestionsForSet(subject, setNum)
        assertEquals("Subject $subject Set $setNum must have exactly 10 questions", 10, questions.size)

        for (q in questions) {
          assertTrue("Question prompt cannot be blank in $subject Set $setNum", q.question.isNotBlank())
          assertEquals("Question must have exactly 4 options in $subject Set $setNum", 4, q.options.size)
          assertEquals("Question must have 4 DISTINCT options in $subject Set $setNum: ${q.options}", 4, q.options.distinct().size)
          assertTrue("Correct index must be 0..3 in $subject Set $setNum", q.correctIndex in 0..3)
          assertTrue("Explanation cannot be blank in $subject Set $setNum", q.explanation.isNotBlank())

          // Check subject-level uniqueness
          assertFalse(
            "DUPLICATE QUESTION DETECTED in $subject! Set $setNum Question: '${q.question}' already exists!",
            allSubjectQuestions.contains(q.question)
          )
          allSubjectQuestions.add(q.question)

          // Check global uniqueness across all 16 subjects
          assertFalse(
            "GLOBAL DUPLICATE QUESTION DETECTED across subjects! Subject $subject Set $setNum Question: '${q.question}' already exists!",
            globalAllQuestions.contains(q.question)
          )
          globalAllQuestions.add(q.question)
        }
      }
      assertEquals("Subject $subject must have 200 completely unique questions across its 20 sets", 200, allSubjectQuestions.size)
    }

    assertEquals("Total unique questions across all 16 subjects (320 sets) must be exactly 3,200", 3200, globalAllQuestions.size)
  }
}

