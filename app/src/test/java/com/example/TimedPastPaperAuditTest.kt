package com.example

import org.junit.Assert.assertTrue
import org.junit.Test

class TimedPastPaperAuditTest {

  private val allSubjects = listOf(
    "විද්‍යාව (Science)",
    "ගණිතය (Mathematics)",
    "ඉතිහාසය (History)",
    "සිංහල (Sinhala)",
    "ඉංග්‍රීසි (English)",
    "බුද්ධ ධර්මය (Buddhism)",
    "තොරතුරු තාක්ෂණය (ICT)",
    "ව්‍යාපාර හා ගිණුම්කරණය (Commerce)",
    "පුරවැසි අධ්‍යාපනය (Civics)",
    "භූගෝල විද්‍යාව (Geography)",
    "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය (Health)",
    "කෘෂි විද්‍යාව (Agriculture)",
    "චිත්‍ර කලාව (Art)",
    "සංගීතය (Music)",
    "නර්තනය (Dancing)"
  )

  private val allYears = listOf("2024", "2023", "2022", "2021", "2020", "2019", "2018")

  private fun extractCoreStem(raw: String): String {
    var s = raw.trim()
    s = s.replace(Regex("^\\[[^\\]]*\\]\\s*"), "")
    return s.trim()
  }

  private fun containsUnexpectedIndicScript(text: String): Boolean {
    for (ch in text) {
      val code = ch.code
      // Flag non-Sinhala South Asian scripts (Devanagari, Bengali, Gujarati, Tamil, Telugu, Kannada, Malayalam)
      val isOtherIndic = (code in 0x0900..0x0D7F) && (code !in 0x0D80..0x0DFF)
      if (isOtherIndic) return true
    }
    return false
  }

  private val placeholderRegex = Regex("(?i)(Option\\s+[A-D]|පිළිතුර\\s+[1-4]|නොවන විකල්පය)")

  @Test
  fun auditTimedPastPapersAllSubjectsAndYears() {
    val failures = ArrayList<String>()
    println("=== TIMED PAST PAPER SIMULATOR AUDIT (15 SUBJECTS x 7 YEARS = 6,300 QUESTIONS) ===")

    for (subject in allSubjects) {
      val isEnglish = subject.contains("ඉංග්‍රීසි")
      val crossYearCores = HashSet<String>(420)
      val subjectIssues = ArrayList<String>()
      var subjectImbalanceCount = 0
      var subjectPlaceholderCount = 0
      var subjectDupCount = 0
      var subjectConsecutiveTopicCount = 0
      var subjectCorruptScriptCount = 0
      var subjectSlotStarvedCount = 0
      var subjectBadCorrectIdxCount = 0

      for (year in allYears) {
        val qs = TimedPastPaperYearProvider.getYearSpecificQuestions(subject, year)
        if (qs.size != 60) {
          subjectIssues.add("$year: expected 60 Qs, got ${qs.size}")
        }
        val intraCores = HashSet<String>(60)
        val slotCounts = IntArray(4)
        var lastTopic = ""

        for (q in qs) {
          val core = extractCoreStem(q.questionText)
          if (core.isBlank()) {
            subjectIssues.add("$year Q${q.id}: Blank questionText")
          }
          if (!intraCores.add(core.lowercase())) {
            subjectDupCount++
            if (subjectIssues.size < 20) subjectIssues.add("$year Q${q.id}: Intra-year DUP stem '$core'")
          } else if (!crossYearCores.add(core.lowercase())) {
            subjectDupCount++
            if (subjectIssues.size < 20) subjectIssues.add("$year Q${q.id}: Cross-year DUP stem '$core'")
          }

          if (q.topicCategory.isNotBlank() && q.topicCategory == lastTopic) {
            subjectConsecutiveTopicCount++
          }
          lastTopic = q.topicCategory

          if (q.explanationSinhala.isBlank()) {
            subjectIssues.add("$year Q${q.id}: Blank explanation")
          }
          if (q.correctOptionIndex !in 0..3) {
            subjectBadCorrectIdxCount++
            if (subjectIssues.size < 20) subjectIssues.add("$year Q${q.id}: Bad correctOptionIndex=${q.correctOptionIndex}")
          } else {
            slotCounts[q.correctOptionIndex]++
          }

          val opts = q.options
          if (opts.size != 4) {
            subjectIssues.add("$year Q${q.id}: Options size=${opts.size}")
            continue
          }
          if (opts.any { it.isBlank() }) {
            subjectIssues.add("$year Q${q.id}: Blank option")
          }
          if (opts.distinct().size != 4) {
            subjectIssues.add("$year Q${q.id}: Duplicate options: $opts")
          }
          for (opt in opts) {
            if (placeholderRegex.containsMatchIn(opt)) {
              subjectPlaceholderCount++
              if (subjectIssues.size < 20) subjectIssues.add("$year Q${q.id}: Placeholder option '$opt'")
            }
            if (opt.matches(Regex("^[1-4][.)]\\s+[^0-9].*")) || opt.matches(Regex("^\\([1-4]\\)\\s*[^0-9].*"))) {
              subjectPlaceholderCount++
              if (subjectIssues.size < 20) subjectIssues.add("$year Q${q.id}: Number prefix in option '$opt'")
            }
            if (opt.contains(": ") && !opt.contains(" : ")) {
              subjectPlaceholderCount++
              if (subjectIssues.size < 20) subjectIssues.add("$year Q${q.id}: Colon in option '$opt'")
            }
            if (containsUnexpectedIndicScript(opt)) {
              subjectCorruptScriptCount++
              if (subjectIssues.size < 20) subjectIssues.add("$year Q${q.id}: Corrupt script in option '$opt'")
            }
          }
          if (containsUnexpectedIndicScript(core) || containsUnexpectedIndicScript(q.explanationSinhala)) {
            subjectCorruptScriptCount++
            if (subjectIssues.size < 20) subjectIssues.add("$year Q${q.id}: Corrupt script in stem/exp")
          }
          if (isEnglish) {
            val hasSinhala = core.any { it.code in 0x0D80..0x0DFF } || opts.any { o -> o.any { it.code in 0x0D80..0x0DFF } }
            if (hasSinhala) {
              subjectIssues.add("$year Q${q.id}: Sinhala char in English stem/options")
            }
          }

          val lens = opts.map { it.length }
          val minL = lens.minOrNull() ?: 1
          val maxL = lens.maxOrNull() ?: 1
          val ratio = maxL.toDouble() / minL.coerceAtLeast(1)
          if (maxL >= 35 && ratio >= 3.0) {
            subjectImbalanceCount++
            if (subjectIssues.size < 20) {
              subjectIssues.add("$year Q${q.id}: Option len imbalance (max=$maxL, min=$minL, r=%.1f): %s".format(ratio, opts))
            }
          }
        }

        for (s in 0..3) {
          if (slotCounts[s] < 6) {
            subjectSlotStarvedCount++
            if (subjectIssues.size < 20) {
              subjectIssues.add("$year: Slot $s starved (${slotCounts.toList()})")
            }
          }
        }
      }

      println(
        "%-36s | unique=%3d/420 | dup=%3d | badIdx=%3d | starved=%2d | placeholder=%3d | imbal=%3d | script=%2d | seqTopic=%3d"
          .format(
            subject, crossYearCores.size, subjectDupCount, subjectBadCorrectIdxCount,
            subjectSlotStarvedCount, subjectPlaceholderCount, subjectImbalanceCount,
            subjectCorruptScriptCount, subjectConsecutiveTopicCount
          )
      )
      if (subjectIssues.isNotEmpty()) {
        subjectIssues.take(5).forEach { println("   -> $it") }
      }
      if (crossYearCores.size != 420 || subjectDupCount > 0 || subjectBadCorrectIdxCount > 0 ||
        subjectSlotStarvedCount > 0 || subjectPlaceholderCount > 0 || subjectImbalanceCount > 0 ||
        subjectCorruptScriptCount > 0 || subjectIssues.isNotEmpty()
      ) {
        failures.add("$subject: unique=${crossYearCores.size}/420 dup=$subjectDupCount badIdx=$subjectBadCorrectIdxCount starved=$subjectSlotStarvedCount placeholder=$subjectPlaceholderCount imbal=$subjectImbalanceCount script=$subjectCorruptScriptCount sample=${subjectIssues.firstOrNull()}")
      }
    }

    assertTrue("Timed Past Paper Audit failures (${failures.size}):\n" + failures.joinToString("\n"), failures.isEmpty())
  }
}
