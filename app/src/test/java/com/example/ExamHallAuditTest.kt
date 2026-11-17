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
    "Option ",
    "නොවන විකල්පය "
  )
  private val deriveFallbackPrefixes = listOf(
    "O/L විභාග සංශෝධන ඇගයීමේදී ",
    "ජාතික විභාග පෙරහුරු ප්‍රශ්නාවලියේ ",
    "පාසල් වාර පරීක්ෂණ සඳහා ",
    "විෂය නිර්දේශ සාරාංශ ඇගයීමේදී "
  )

  @Test
  fun auditAll15SubjectsAcross90Papers5400Questions() {
    val subjects = MockExamDataBank.AVAILABLE_SUBJECTS
    assertTrue("Must audit all 15 O/L subjects", subjects.size == 15)
    val grades = listOf("10", "11")
    val terms = listOf(1, 2, 3)

    val failures = ArrayList<String>()
    println("=== LIVE EXAM HALL 90-PAPER / 5,400-QUESTION AUDIT (ALL 15 SUBJECTS) ===")
    for (subject in subjects) {
      var worstIntraRaw = 60
      var worstIntraCore = 60
      var minUniqueCoreAcross30 = 1800
      var minUniqueCoreAcross90 = 5400
      var maxDuplicatePapers = 0
      var placeholderHits = 0
      var deriveFallbackHits = 0
      var minTopicsInAnyPaper = Int.MAX_VALUE
      var totalTopicsIn90 = 0
      var sampleIssue = ""

      for (grade in grades) {
        val coreSetAcrossAll90 = HashSet<String>(6000)
        val paperSigsAcrossAll90 = HashSet<String>(90)
        val topicsAcrossAll90 = HashSet<String>(300)

        for (term in terms) {
          val papers = MockExamDataBank.getPapersForTermAndSubject(grade, term, subject)
          if (papers.size != 30) {
            failures.add("$subject G$grade T$term: expected 30 papers, got ${papers.size}")
          }

          val coreSetInTerm = HashSet<String>(2000)
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
            for (ct in coreTexts) {
              if (!coreSetAcrossAll90.add(ct) && sampleIssue.isEmpty()) {
                sampleIssue = "CROSS-TERM/PAPER DUP G$grade T$term P${paper.paperNumber}: $ct"
              }
            }
            coreSetInTerm.addAll(coreTexts)

            val paperTopics = paper.questions.map { it.topicName }.distinct()
            if (paperTopics.size < minTopicsInAnyPaper) {
              minTopicsInAnyPaper = paperTopics.size
            }
            topicsAcrossAll90.addAll(paperTopics)

            val sig = coreTexts.sorted().joinToString("||")
            if (!paperSigsAcrossAll90.add(sig)) {
              dupPapersInTerm++
            }

            for (q in paper.questions) {
              val stem = q.questionText.trim()
              if (deriveFallbackPrefixes.any { stem.startsWith(it) }) {
                deriveFallbackHits++
                if (sampleIssue.isEmpty()) {
                  sampleIssue = "DERIVE_FALLBACK G$grade T$term P${paper.paperNumber} Q${q.id}: $stem"
                }
              }
              val reason = when {
                stem.isBlank() -> "BLANK_STEM"
                q.explanation.isBlank() -> "BLANK_EXP"
                q.correctOption !in 1..4 -> "BAD_CORRECT(${q.correctOption})"
                q.options.size != 4 -> "BAD_OPT_SIZE(${q.options.size})"
                q.options.any { it.isBlank() } -> "BLANK_OPT"
                q.options.distinct().size != 4 -> "DUP_OPTS"
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

        if (coreSetAcrossAll90.size < minUniqueCoreAcross90) {
          minUniqueCoreAcross90 = coreSetAcrossAll90.size
        }
        if (topicsAcrossAll90.size > totalTopicsIn90) {
          totalTopicsIn90 = topicsAcrossAll90.size
        }
      }

      println(
        "SUBJECT: %-30s | intra=%2d/60 | perTerm=%4d/1800 | across90=%4d/5400 | minTopics=%2d | totalTopics=%3d | dupPapers=%d | placeholders=%d | fallbacks=%d | issue=%s"
          .format(
            subject,
            worstIntraCore,
            minUniqueCoreAcross30,
            minUniqueCoreAcross90,
            minTopicsInAnyPaper,
            totalTopicsIn90,
            maxDuplicatePapers,
            placeholderHits,
            deriveFallbackHits,
            sampleIssue.take(100)
          )
      )

      if (worstIntraRaw != 60) failures.add("$subject worstIntraRaw=$worstIntraRaw ($sampleIssue)")
      if (worstIntraCore != 60) failures.add("$subject worstIntraCore=$worstIntraCore ($sampleIssue)")
      if (minUniqueCoreAcross30 != 1800) failures.add("$subject minUniqueCoreAcross30=$minUniqueCoreAcross30")
      if (minUniqueCoreAcross90 != 5400) failures.add("$subject minUniqueCoreAcross90=$minUniqueCoreAcross90 ($sampleIssue)")
      if (maxDuplicatePapers != 0) failures.add("$subject maxDuplicatePapers=$maxDuplicatePapers")
      if (placeholderHits != 0) failures.add("$subject placeholderHits=$placeholderHits ($sampleIssue)")
      if (deriveFallbackHits != 0) failures.add("$subject deriveFallbackHits=$deriveFallbackHits ($sampleIssue)")
      if (minTopicsInAnyPaper < 10) failures.add("$subject minTopicsInAnyPaper=$minTopicsInAnyPaper (must be >= 10)")
    }

    assertTrue("Audit failures:\n" + failures.joinToString("\n"), failures.isEmpty())
  }

  @Test
  fun testTargetedSubjectsUniquenessAndPurity() {
    val targeted = listOf("භූගෝල විද්‍යාව", "පුරවැසි අධ්‍යාපනය", "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය", "ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය")
    for (subject in targeted) {
      for (grade in listOf("10", "11")) {
        val allStems = HashSet<String>(5400)
        for (term in 1..3) {
          val papers = MockExamDataBank.getPapersForTermAndSubject(grade, term, subject)
          assertTrue("Expected 30 papers for $subject G$grade T$term", papers.size == 30)
          for (paper in papers) {
            assertTrue("Expected 60 questions for $subject G$grade T$term P${paper.paperNumber}", paper.questions.size == 60)
            for (q in paper.questions) {
              val stem = extractCoreStem(q.questionText)
              assertTrue("Duplicate question stem in $subject G$grade T$term P${paper.paperNumber}: $stem", allStems.add(stem))
              assertTrue("Valid correct option in $subject", q.correctOption in 1..4)
              assertTrue("Non-blank options in $subject", q.options.size == 4 && q.options.all { it.isNotBlank() })
            }
          }
        }
        assertTrue("$subject G$grade must have 5400 unique questions, got ${allStems.size}", allStems.size == 5400)
      }
    }
  }

  @Test
  fun testAnswerDistributionBalancedAll15Subjects() {
    for (subject in MockExamDataBank.AVAILABLE_SUBJECTS) {
      val counts = IntArray(4)
      for (term in 1..3) {
        val paper = MockExamDataBank.getPapersForTermAndSubject("11", term, subject).first()
        for (q in paper.questions) {
          assertTrue("Valid correctOption in $subject", q.correctOption in 1..4)
          counts[q.correctOption - 1]++
        }
      }
      for (slot in 0..3) {
        assertTrue(
          "$subject answer slot ${slot + 1} should be well-balanced across terms: counts=${counts.toList()}",
          counts[slot] >= 20
        )
      }
    }
  }

  @Test
  fun testAgriculturePurityAndNoScienceLeakage() {
    val poolSize = AgriMockPoolHelper.getPoolSize()
    println("AGRI POOL SIZE AFTER DEDUP & FILTER: $poolSize")
    assertTrue("Agri pool must have >= 5400 pure Grade 10/11 syllabus specs, got $poolSize", poolSize >= 5400)

    val scienceDenyTerms = listOf(
      "Polar molecule", "විද්‍යුත් ධ්‍රැවීය", "සහසංයුජ", "පරමාණුක ක්‍රමාංකය",
      "ඕම් නියමය", "නිව්ටන් නියම", "HTML", "SQL", "ලෝක යුද්ධය"
    )
    val metaTipDenyTerms = listOf(
      "අත් අකුරු සහ ඉදිරිපත් කිරීම", "ශරීර සෞඛ්‍යය සහ විභාග මනෝභාවය",
      "ප්‍රශ්න පත්‍රය ලැබුණු පසු", "විභාග උපදෙස", "අසම්පූර්ණ ප්‍රශ්න නොතැබීම",
      "ගුරු උපදෙස් පිළිපැදීම", "රචනා ප්‍රශ්න ලිවීමේ කලාව"
    )

    for (grade in listOf("10", "11")) {
      val seenStems = HashSet<String>(5400)
      var minTopics = Int.MAX_VALUE
      for (term in 1..3) {
        val papers = MockExamDataBank.getPapersForTermAndSubject(grade, term, "කෘෂි විද්‍යාව")
        assertTrue("G$grade T$term must have 30 papers", papers.size == 30)
        for (paper in papers) {
          val topics = paper.questions.map { it.topicName }.distinct()
          if (topics.size < minTopics) minTopics = topics.size
          for (q in paper.questions) {
            val stem = extractCoreStem(q.questionText)
            assertTrue("Duplicate core stem in G$grade T$term P${paper.paperNumber} Q${q.id}: $stem", seenStems.add(stem))
            val combined = "${q.questionText} | ${q.options.joinToString(" | ")} | ${q.explanation}"
            for (deny in scienceDenyTerms) {
              assertTrue("Off-subject Science/other term '$deny' leaked into Agri G$grade T$term P${paper.paperNumber} Q${q.id}: $stem", !combined.contains(deny, ignoreCase = true))
            }
            for (tip in metaTipDenyTerms) {
              assertTrue("Meta-exam tip '$tip' leaked into Agri G$grade T$term P${paper.paperNumber} Q${q.id}: $stem", !combined.contains(tip))
            }
          }
        }
      }
      assertTrue("Agri G$grade must have 5400 unique questions across 90 papers, got ${seenStems.size}", seenStems.size == 5400)
      assertTrue("Agri G$grade minTopics per paper should be >= 15, got $minTopics", minTopics >= 15)
      println("AGRI G$grade PURITY OK | unique=${seenStems.size}/5400 | minTopics=$minTopics")
    }

    // Explicitly verify the exact screenshot slot: Grade 11 Term 1 Paper 29 Q4
    val p29q4 = MockExamDataBank.getPapersForTermAndSubject("11", 1, "කෘෂි විද්‍යාව")[28].questions[3]
    println("AGRI G11 T1 P29 Q4: [${p29q4.topicName}] ${p29q4.questionText} -> opts=${p29q4.options} (ans=${p29q4.correctOption})")
    assertTrue("G11 T1 P29 Q4 must not contain Science Polar molecule text", !p29q4.questionText.contains("ධ්‍රැවීය"))
  }
}
