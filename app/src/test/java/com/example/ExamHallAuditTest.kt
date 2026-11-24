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
  fun auditAllAvailableSubjects() {
    val subjects = MockExamDataBank.AVAILABLE_SUBJECTS
    assertTrue("Must audit all 15 available O/L subjects", subjects.size == 15)
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

      if (maxDuplicatePapers > 5) failures.add("$subject maxDuplicatePapers=$maxDuplicatePapers")
      if (placeholderHits > 50) failures.add("$subject placeholderHits=$placeholderHits ($sampleIssue)")
    }

    assertTrue("Audit failures:\n" + failures.joinToString("\n"), failures.isEmpty())
  }

  @Test
  fun testAnswerDistributionBalancedAllAvailableSubjects() {
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

  @Test
  fun testScienceOptionBalanceAndQuality() {
    val subject = "විද්‍යාව"
    val grades = listOf("10", "11")
    val terms = listOf(1, 2, 3)

    val issues = ArrayList<String>()
    var totalQuestionsAudited = 0

    for (grade in grades) {
      for (term in terms) {
        val papers = MockExamDataBank.getPapersForTermAndSubject(grade, term, subject)
        for (paper in papers) {
          for (q in paper.questions) {
            totalQuestionsAudited++
            val opts = q.options
            if (opts.size != 4) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Invalid options size ${opts.size}")
              continue
            }
            if (opts.distinct().size != 4) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Duplicate options: $opts")
            }
            for (opt in opts) {
              if (opt.isBlank()) {
                issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Blank option found")
              }
              if (opt.matches(Regex("^[1-4][.)]\\s+[^0-9].*")) || opt.matches(Regex("^\\([1-4]\\)\\s*[^0-9].*"))) {
                issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Number prefix in option: '$opt'")
              }
              if (opt.contains(": ") && !opt.contains(" : ")) {
                issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Colon in option: '$opt'")
              }
            }
            val lengths = opts.map { it.length }
            val minLen = lengths.minOrNull() ?: 1
            val maxLen = lengths.maxOrNull() ?: 1
            val ratio = maxLen.toDouble() / minLen.coerceAtLeast(1)
            if (maxLen >= 35 && ratio >= 3.0) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Option length imbalance (max=$maxLen, min=$minLen, ratio=%.1f): %s".format(ratio, opts))
            }
          }
        }
      }
    }

    println("AUDITED $totalQuestionsAudited SCIENCE QUESTIONS. Issues found: ${issues.size}")
    if (issues.isNotEmpty()) {
      println("ALL ISSUES:")
      issues.forEach { println(" - $it") }
    }
    assertTrue("Science option balance & quality issues (${issues.size}):\n" + issues.take(30).joinToString("\n"), issues.isEmpty())
  }

  @Test
  fun testEnglishOptionBalanceAndQuality() {
    val subject = "ඉංග්‍රීසි"
    val grades = listOf("10", "11")
    val terms = listOf(1, 2, 3)

    val domainSizes = EnglishLiveExamQuestionBank.domainSizes()
    assertTrue("Expected 10 English domains, got ${domainSizes.size}", domainSizes.size == 10)
    domainSizes.forEachIndexed { idx, size ->
      assertTrue("English domain $idx must have >= 180 unique questions for 30 papers/term, got $size", size >= 180)
    }

    val issues = ArrayList<String>()
    var totalQuestionsAudited = 0

    for (grade in grades) {
      for (term in terms) {
        val papers = MockExamDataBank.getPapersForTermAndSubject(grade, term, subject)
        if (papers.size != 30) {
          issues.add("G$grade T$term: expected 30 papers, got ${papers.size}")
        }
        val termStems = HashSet<String>(1800)

        for (paper in papers) {
          if (paper.questions.size != 60) {
            issues.add("G$grade T$term P${paper.paperNumber}: expected 60 questions, got ${paper.questions.size}")
          }
          val paperStems = HashSet<String>(60)
          val slotCounts = IntArray(4)

          for (q in paper.questions) {
            totalQuestionsAudited++
            val core = extractCoreStem(q.questionText)
            if (!paperStems.add(core.lowercase())) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Intra-paper duplicate stem: $core")
            }
            if (!termStems.add(core.lowercase())) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Cross-paper duplicate stem in term: $core")
            }
            if (q.explanation.isBlank()) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Blank explanation")
            }
            if (q.correctOption !in 1..4) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Invalid correctOption ${q.correctOption}")
            } else {
              slotCounts[q.correctOption - 1]++
            }
            val opts = q.options
            if (opts.size != 4) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Invalid options size ${opts.size}")
              continue
            }
            if (opts.distinct().size != 4) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Duplicate options: $opts")
            }
            for (opt in opts) {
              if (opt.isBlank()) {
                issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Blank option found")
              }
              if (opt.matches(Regex("^[1-4][.)]\\s+[^0-9].*")) || opt.matches(Regex("^\\([1-4]\\)\\s*[^0-9].*"))) {
                issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Number prefix in option: '$opt'")
              }
              if (opt.contains(": ") && !opt.contains(" : ")) {
                issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Colon in option: '$opt'")
              }
            }
            val lengths = opts.map { it.length }
            val minLen = lengths.minOrNull() ?: 1
            val maxLen = lengths.maxOrNull() ?: 1
            val ratio = maxLen.toDouble() / minLen.coerceAtLeast(1)
            if (maxLen >= 35 && ratio >= 3.0) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Option length imbalance (max=$maxLen, min=$minLen, ratio=%.1f): %s".format(ratio, opts))
            }
          }
          for (s in 0..3) {
            if (slotCounts[s] < 6) {
              issues.add("G$grade T$term P${paper.paperNumber}: Answer slot ${s + 1} starved (${slotCounts.toList()})")
            }
          }
        }
        if (termStems.size != 1800) {
          issues.add("G$grade T$term: expected 1800 unique stems across 30 papers, got ${termStems.size}")
        }
      }
    }

    println("AUDITED $totalQuestionsAudited ENGLISH QUESTIONS. Domain sizes=$domainSizes. Issues found: ${issues.size}")
    if (issues.isNotEmpty()) {
      println("ALL ENGLISH ISSUES:")
      issues.take(50).forEach { println(" - $it") }
    }
    assertTrue("English option balance & quality issues (${issues.size}):\n" + issues.take(30).joinToString("\n"), issues.isEmpty())
  }

  @Test
  fun testArtOptionBalanceAndQuality() {
    val subject = "චිත්‍ර කලාව"
    val grades = listOf("10", "11")
    val terms = listOf(1, 2, 3)

    val domainSizes = ArtLiveExamQuestionBank.domainSizes()
    assertTrue("Expected 10 Art domains, got ${domainSizes.size}", domainSizes.size == 10)
    domainSizes.forEachIndexed { idx, size ->
      assertTrue("Art domain $idx must have >= 180 unique questions for 30 papers/term, got $size", size >= 180)
    }

    val issues = ArrayList<String>()
    var totalQuestionsAudited = 0

    for (grade in grades) {
      for (term in terms) {
        val papers = MockExamDataBank.getPapersForTermAndSubject(grade, term, subject)
        if (papers.size != 30) {
          issues.add("G$grade T$term: expected 30 papers, got ${papers.size}")
        }
        val termStems = HashSet<String>(1800)

        for (paper in papers) {
          if (paper.questions.size != 60) {
            issues.add("G$grade T$term P${paper.paperNumber}: expected 60 questions, got ${paper.questions.size}")
          }
          val paperStems = HashSet<String>(60)
          val slotCounts = IntArray(4)

          for (q in paper.questions) {
            totalQuestionsAudited++
            val core = extractCoreStem(q.questionText)
            if (!paperStems.add(core.lowercase())) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Intra-paper duplicate stem: $core")
            }
            if (!termStems.add(core.lowercase())) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Cross-paper duplicate stem in term: $core")
            }
            if (q.explanation.isBlank()) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Blank explanation")
            }
            if (q.correctOption !in 1..4) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Invalid correctOption ${q.correctOption}")
            } else {
              slotCounts[q.correctOption - 1]++
            }
            val opts = q.options
            if (opts.size != 4) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Invalid options size ${opts.size}")
              continue
            }
            if (opts.distinct().size != 4) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Duplicate options: $opts")
            }
            for (opt in opts) {
              if (opt.isBlank()) {
                issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Blank option found")
              }
              if (opt.matches(Regex("^[1-4][.)]\\s+[^0-9].*")) || opt.matches(Regex("^\\([1-4]\\)\\s*[^0-9].*"))) {
                issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Number prefix in option: '$opt'")
              }
              if (opt.contains(": ") && !opt.contains(" : ")) {
                issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Colon in option: '$opt'")
              }
            }
            val lengths = opts.map { it.length }
            val minLen = lengths.minOrNull() ?: 1
            val maxLen = lengths.maxOrNull() ?: 1
            val ratio = maxLen.toDouble() / minLen.coerceAtLeast(1)
            if (maxLen >= 35 && ratio >= 3.0) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Option length imbalance (max=$maxLen, min=$minLen, ratio=%.1f): %s".format(ratio, opts))
            }
          }
          for (s in 0..3) {
            if (slotCounts[s] < 6) {
              issues.add("G$grade T$term P${paper.paperNumber}: Answer slot ${s + 1} starved (${slotCounts.toList()})")
            }
          }
        }
        if (termStems.size != 1800) {
          issues.add("G$grade T$term: expected 1800 unique stems across 30 papers, got ${termStems.size}")
        }
      }
    }

    println("AUDITED $totalQuestionsAudited ART QUESTIONS. Domain sizes=$domainSizes. Issues found: ${issues.size}")
    if (issues.isNotEmpty()) {
      println("ALL ART ISSUES:")
      issues.take(50).forEach { println(" - $it") }
    }
    assertTrue("Art option balance & quality issues (${issues.size}):\n" + issues.take(30).joinToString("\n"), issues.isEmpty())
  }

  @Test
  fun testGeographyOptionBalanceAndQuality() {
    val subject = "භූගෝල විද්‍යාව"
    val grades = listOf("10", "11")
    val terms = listOf(1, 2, 3)

    val domainSizes = GeographyLiveExamQuestionBank.domainSizes()
    assertTrue("Expected 10 Geography domains, got ${domainSizes.size}", domainSizes.size == 10)
    domainSizes.forEachIndexed { idx, size ->
      assertTrue("Geography domain $idx must have >= 180 unique questions for 30 papers/term, got $size", size >= 180)
    }

    val issues = ArrayList<String>()
    val lazySubstrings = listOf(
      "වෙනසක් නැත", "කිසිදු වෙනසක් නැත", "සිනමා තහනම්", "වැදගත් නොවේ",
      "වැදගත් නැත", "එපා වීම", "එවැන්නක් නැත", "කිසිවක් නැත", "අදාළ නොවේ",
      "පෲථිවිය", "විද්යා", "ඉහත සියල්ල වැරදිය", "පිළිතුරක් නොමැත"
    )
    var totalQuestionsAudited = 0
    val uniqueIssues = linkedSetOf<String>()

    for (grade in grades) {
      for (term in terms) {
        val papers = MockExamDataBank.getPapersForTermAndSubject(grade, term, subject)
        if (papers.size != 30) {
          issues.add("G$grade T$term: expected 30 papers, got ${papers.size}")
        }
        val termStems = HashSet<String>(1800)

        for (paper in papers) {
          if (paper.questions.size != 60) {
            issues.add("G$grade T$term P${paper.paperNumber}: expected 60 questions, got ${paper.questions.size}")
          }
          val paperStems = HashSet<String>(60)
          val slotCounts = IntArray(4)

          for (q in paper.questions) {
            totalQuestionsAudited++
            val core = extractCoreStem(q.questionText)
            if (!paperStems.add(core.lowercase())) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Intra-paper duplicate stem: $core")
            }
            if (!termStems.add(core.lowercase())) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Cross-paper duplicate stem in term: $core")
            }
            if (q.explanation.isBlank()) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Blank explanation")
            }
            if (q.correctOption !in 1..4) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Invalid correctOption ${q.correctOption}")
            } else {
              slotCounts[q.correctOption - 1]++
            }
            val opts = q.options
            if (opts.size != 4) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Invalid options size ${opts.size}")
              continue
            }
            if (opts.distinct().size != 4) {
              issues.add("G$grade T$term P${paper.paperNumber} Q${q.id}: Duplicate options: $opts")
            }

            if (lazySubstrings.any { bad -> core.contains(bad) || q.explanation.contains(bad) || opts.any { it.contains(bad) } }) {
              val msg = "[LAZY/SPELL] (${q.topicName}) $core | opts=$opts"
              if (uniqueIssues.add(core)) issues.add(msg)
            }

            for (opt in opts) {
              if (opt.isBlank()) {
                issues.add("Blank option in $core")
              }
              if (opt.matches(Regex("^[1-4][.)]\\s+[^0-9].*")) || opt.matches(Regex("^\\([1-4]\\)\\s*[^0-9].*"))) {
                if (uniqueIssues.add("prefix:$core")) issues.add("[PREFIX] $core -> '$opt'")
              }
              if (opt.contains(": ") && !opt.contains(" : ")) {
                if (uniqueIssues.add("colon:$core")) issues.add("[COLON] $core -> '$opt'")
              }
            }

            val lengths = opts.map { it.length }
            val minLen = lengths.minOrNull() ?: 1
            val maxLen = lengths.maxOrNull() ?: 1
            val ratio = maxLen.toDouble() / minLen.coerceAtLeast(1)
            val wordCounts = opts.map { it.trim().split(Regex("\\s+")).filter { w -> w.isNotBlank() }.size }
            val minWords = wordCounts.minOrNull() ?: 1
            val maxWords = wordCounts.maxOrNull() ?: 1
            if ((maxLen >= 30 && ratio >= 2.0) || (maxWords >= 8 && minWords <= 3)) {
              val msg = "[IMBAL maxL=$maxLen minL=$minLen ratio=${"%.1f".format(ratio)} words=$wordCounts] (${q.topicName}) $core | opts=$opts"
              if (uniqueIssues.add("imbal:$core")) issues.add(msg)
            }
            if (q.correctOption in 1..4) {
              val correctOpt = opts[q.correctOption - 1]
              val distractors = opts.filterIndexed { idx, _ -> idx != q.correctOption - 1 }
              val avgDistractorLen = distractors.map { it.length }.average()
              if (correctOpt.length >= 35 && correctOpt.length > avgDistractorLen * 1.45) {
                val msg = "[CORRECT_TOO_LONG cLen=${correctOpt.length} avgD=${"%.1f".format(avgDistractorLen)}] (${q.topicName}) $core | opts=$opts"
                if (uniqueIssues.add("ctoolong:$core")) issues.add(msg)
              }
            }
          }
          for (s in 0..3) {
            if (slotCounts[s] < 6) {
              issues.add("G$grade T$term P${paper.paperNumber}: Answer slot ${s + 1} starved (${slotCounts.toList()})")
            }
          }
        }
        if (termStems.size != 1800) {
          issues.add("G$grade T$term: expected 1800 unique stems across 30 papers, got ${termStems.size}")
        }
      }
    }

    println("AUDITED $totalQuestionsAudited GEOGRAPHY QUESTIONS. Domain sizes=$domainSizes. Unique issues found: ${issues.size}")
    if (issues.isNotEmpty()) {
      println("ALL UNIQUE GEOGRAPHY ISSUES (${issues.size}):")
      issues.forEach { println(" - $it") }
    }
    assertTrue("Geography option balance & quality issues (${issues.size}):\n" + issues.take(40).joinToString("\n"), issues.isEmpty())
  }

  @Test
  fun testGeographyGrade11Term1Paper2Distinctness() {
    val papers = MockExamDataBank.getPapersForTermAndSubject("11 ශ්‍රේණිය", 1, "භූගෝල විද්‍යාව")
    assertTrue("Expected 30 Geography papers", papers.size == 30)
    val paper2 = papers[1]
    assertTrue("Expected Paper 2", paper2.paperNumber == 2)
    assertTrue("Expected 60 questions in Paper 2", paper2.questions.size == 60)

    val seenStems = HashSet<String>(60)
    for (q in paper2.questions) {
      val stem = q.questionText
      assertTrue("Paper 2 Q${q.id} must not contain legacy numbered suffix or Inner Core fallback: $stem",
        !stem.contains("Inner Core") &&
        !stem.contains("ආදර්ශ පත්‍රය") &&
        !trailingParenNumRegex.containsMatchIn(stem)
      )
      assertTrue("Paper 2 Q${q.id} must have a distinct core stem: $stem",
        seenStems.add(extractCoreStem(stem).lowercase())
      )
    }
    val q3 = paper2.questions[2]
    val q4 = paper2.questions[3]
    assertTrue("Paper 2 Q3 and Q4 must be completely distinct questions",
      extractCoreStem(q3.questionText) != extractCoreStem(q4.questionText)
    )
  }
}
