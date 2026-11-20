package com.example

import org.junit.Assert.assertTrue
import org.junit.Test

class ExamHallAuditTest {

  private fun extractCoreStem(raw: String): String {
    var s = raw.trim()
    s = s.replace(Regex("^\\[\\d+\\]\\s*"), "")
    s = s.replace(Regex("^.*?ආදර්ශ පත්‍රය\\s*\\d+\\s*•\\s*ප්‍රශ්නය\\s*\\d+:\\s*"), "")
    s = s.replace(Regex("^ප්‍රශ්න අංක\\s*\\d+.*?(:|\\))\\s*"), "")
    s = s.replace(Regex("\\s*\\(\\d+\\)\\??\\s*$"), "")
    return s.trim()
  }

  private val fakeOptionPrefixes = listOf(
    "වචනය ", "සන්ධි ", "ක්‍රියා ", "සමාස ", "වාක්‍ය ", "අලංකාර ", "අංගය ", "Option ", "පිළිතුර "
  )
  private val leadingBracketRegex = Regex("^\\[\\d+\\]\\s*")
  private val trailingParenNumRegex = Regex("\\(\\d+\\)\\??$")

  @Test
  fun auditAll15Subjects() {
    val subjects = MockExamDataBank.AVAILABLE_SUBJECTS
    assertTrue("Must audit all 15 O/L subjects", subjects.size == 15)
    val grades = listOf("10", "11")
    val terms = listOf(1, 2, 3)

    val failures = ArrayList<String>()
    println("=== LIVE EXAM HALL FULL AUDIT ===")
    for (subject in subjects) {
      var worstIntraRaw = 60
      var worstIntraCore = 60
      var minUniqueCoreAcross30 = 1800
      var maxDuplicatePapers = 0
      var placeholderHits = 0
      var sampleIssue = ""

      for (grade in grades) {
        for (term in terms) {
          val papers = MockExamDataBank.getPapersForTermAndSubject(grade, term, subject)
          if (papers.size != 30) {
            failures.add("$subject G$grade T$term: expected 30 papers, got ${papers.size}")
          }

          val coreSetInTerm = mutableSetOf<String>()
          val paperSigs = mutableSetOf<String>()
          var dupPapersInTerm = 0

          for (paper in papers) {
            if (paper.questions.size != 60) {
              failures.add("$subject G$grade T$term P${paper.paperNumber}: expected 60 questions, got ${paper.questions.size}")
            }
            val rawTexts = paper.questions.map { it.questionText }
            val coreTexts = paper.questions.map { extractCoreStem(it.questionText) }
            val uniqueRaw = rawTexts.distinct().size
            val uniqueCore = coreTexts.distinct().size
            if (uniqueRaw < worstIntraRaw) worstIntraRaw = uniqueRaw
            if (uniqueCore < worstIntraCore) {
              worstIntraCore = uniqueCore
              val dup = coreTexts.groupBy { it }.filter { it.value.size > 1 }.keys.firstOrNull()
              if (dup != null && sampleIssue.isEmpty()) {
                sampleIssue = "INTRA DUP G$grade T$term P${paper.paperNumber}: $dup"
              }
            }
            coreSetInTerm.addAll(coreTexts)

            val sig = coreTexts.sorted().joinToString("||")
            if (!paperSigs.add(sig)) {
              dupPapersInTerm++
            }

            for (q in paper.questions) {
              val stem = q.questionText.trim()
              val reason = when {
                stem.isBlank() -> "BLANK_STEM"
                q.explanation.isBlank() -> "BLANK_EXP"
                q.correctOption !in 1..4 -> "BAD_CORRECT(${q.correctOption})"
                q.options.size != 4 -> "BAD_OPT_SIZE(${q.options.size})"
                q.options.any { it.isBlank() } -> "BLANK_OPT"
                q.options.distinct().size != 4 -> "DUP_OPTS"
                leadingBracketRegex.containsMatchIn(stem) -> "LEADING_BRACKET"
                trailingParenNumRegex.containsMatchIn(stem) -> "TRAILING_PAREN_NUM"
                stem.contains("ආදර්ශ පත්‍රය") -> "MODEL_PAPER_PREFIX"
                q.options.any { opt ->
                  fakeOptionPrefixes.any { pref -> opt.contains(pref) }
                } -> "FAKE_OPT"
                else -> null
              }
              if (reason != null) {
                placeholderHits++
                if (sampleIssue.isEmpty()) {
                  sampleIssue = "$reason G$grade T$term P${paper.paperNumber} Q${q.id}: $stem | opts=${q.options} | exp=${q.explanation}"
                }
              }
            }
          }

          if (coreSetInTerm.size < minUniqueCoreAcross30) {
            minUniqueCoreAcross30 = coreSetInTerm.size
          }
          if (dupPapersInTerm > maxDuplicatePapers) {
            maxDuplicatePapers = dupPapersInTerm
          }
        }
      }

      println(
        "SUBJECT: %-32s | minIntraRaw=%2d/60 | minIntraCore=%2d/60 | minCoreAcross30=%4d/1800 | maxDupPapers=%2d | placeholders=%d | issue=%s"
          .format(subject, worstIntraRaw, worstIntraCore, minUniqueCoreAcross30, maxDuplicatePapers, placeholderHits, sampleIssue.take(100))
      )

      if (worstIntraRaw != 60) failures.add("$subject worstIntraRaw=$worstIntraRaw ($sampleIssue)")
      if (worstIntraCore != 60) failures.add("$subject worstIntraCore=$worstIntraCore ($sampleIssue)")
      if (minUniqueCoreAcross30 != 1800) failures.add("$subject minUniqueCoreAcross30=$minUniqueCoreAcross30")
      if (maxDuplicatePapers != 0) failures.add("$subject maxDuplicatePapers=$maxDuplicatePapers")
      if (placeholderHits != 0) failures.add("$subject placeholderHits=$placeholderHits ($sampleIssue)")
    }

    assertTrue("Audit failures:\n" + failures.joinToString("\n"), failures.isEmpty())
  }

  @Test
  fun testAnswerDistributionBalancedAll15Subjects() {
    for (subject in MockExamDataBank.AVAILABLE_SUBJECTS) {
      val counts = IntArray(4)
      val paper = MockExamDataBank.getPapersForTermAndSubject("11", 1, subject).first()
      for (q in paper.questions) {
        assertTrue("Valid correctOption in $subject", q.correctOption in 1..4)
        counts[q.correctOption - 1]++
      }
      for (slot in 0..3) {
        assertTrue(
          "$subject answer slot ${slot + 1} should not be starved or monopolized: counts=${counts.toList()}",
          counts[slot] >= 4
        )
      }
    }
  }
}
