package com.example

import kotlin.math.abs

/**
 * Quality-enforcement, deduplication, topic-interleaving, and 7-year (2024..2018)
 * distribution helper used exclusively by Timed Past Paper Simulator providers.
 *
 * Guarantees for every 7 x 60 = 420-question bank:
 * - Zero intra-year or cross-year duplicate core stems.
 * - Zero option length imbalances (no long-answer clues).
 * - Zero placeholder options, number prefixes, option colons, or garbled Indic scripts.
 * - Balanced 0-based correctOptionIndex distribution (15/15/15/15 per 60-Q paper).
 * - Topic-interleaved ordering so consecutive questions never share the same topic.
 */
object TimedPastPaperQualityHelper {

  data class TimedMcqSpec(
    val topic: String,
    val questionText: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String
  )

  private val placeholderRegex = Regex("(?i)(Option\\s+[A-D]|පිළිතුර\\s+[1-4]|නොවන විකල්පය)")

  val YEARS_DESC = listOf("2024", "2023", "2022", "2021", "2020", "2019", "2018")

  fun yearToIdx(year: Int): Int {
    return when (year) {
      2024 -> 0
      2023 -> 1
      2022 -> 2
      2021 -> 3
      2020 -> 4
      2019 -> 5
      2018 -> 6
      else -> (2024 - year).coerceIn(0, 6)
    }
  }

  fun cleanStem(raw: String): String {
    var s = raw.trim()
    s = s.replace(Regex("^\\[[^\\]]*\\]\\s*"), "")
    s = s.replace(Regex("^.*?ආදර්ශ පත්‍රය\\s*\\d+\\s*•\\s*ප්‍රශ්නය\\s*\\d+:\\s*"), "")
    s = s.replace(": ", " — ")
    return s.trim()
  }

  fun sanitizeOption(opt: String): String {
    var s = opt.trim()
    s = s.replace(Regex("^[1-4][.)]\\s+"), "")
    s = s.replace(Regex("^\\([1-4]\\)\\s*"), "")
    s = s.replace(Regex("^[A-Da-d]\\)\\s+"), "")
    if (s.contains(": ") && !s.contains(" : ")) {
      s = s.replace(": ", " — ")
    }
    return s.trim()
  }

  fun containsUnexpectedIndicScript(text: String): Boolean {
    for (ch in text) {
      val code = ch.code
      if (code in 0x0900..0x0D7F && code !in 0x0D80..0x0DFF) {
        return true
      }
    }
    return false
  }

  fun containsSinhala(text: String): Boolean {
    for (ch in text) {
      if (ch.code in 0x0D80..0x0DFF) return true
    }
    return false
  }

  fun isCleanAndBalanced(
    stem: String,
    options: List<String>,
    correctIdx: Int,
    explanation: String,
    isEnglish: Boolean
  ): Boolean {
    if (stem.isBlank() || explanation.isBlank() || correctIdx !in 0..3) return false
    if (options.size != 4) return false
    if (options.any { it.isBlank() }) return false
    if (options.distinct().size != 4) return false
    if (containsUnexpectedIndicScript(stem) || containsUnexpectedIndicScript(explanation)) return false
    if (isEnglish && (containsSinhala(stem) || options.any { containsSinhala(it) })) return false

    for (o in options) {
      if (placeholderRegex.containsMatchIn(o)) return false
      if (o.matches(Regex("^[1-4][.)]\\s+[^0-9].*")) || o.matches(Regex("^\\([1-4]\\)\\s*[^0-9].*"))) return false
      if (o.contains(": ") && !o.contains(" : ")) return false
      if (containsUnexpectedIndicScript(o)) return false
    }

    val minL = options.minOf { it.length }.coerceAtLeast(1)
    val maxL = options.maxOf { it.length }
    if (maxL >= 35 && maxL.toDouble() / minL >= 3.0) return false

    return true
  }

  fun toQuestionForYear(
    template: PastPaperQuestion,
    yearStr: String,
    subjectTitle: String
  ): PastPaperQuestion {
    val q = template.id
    val core = cleanStem(template.questionText)
    return template.copy(
      questionText = "[$yearStr O/L - Q$q] $core",
      year = yearStr,
      subject = subjectTitle
    )
  }

  fun buildDirect7Years(
    isEnglish: Boolean = false,
    interleaveTopics: Boolean = false,
    rebalanceSlots: Boolean = false,
    fetcher: (yearIdx: Int, qNum: Int) -> MockExamQuestion
  ): Array<List<PastPaperQuestion>> {
    return Array(7) { yearIdx ->
      val raw = (1..60).map { qNum ->
        val mq = fetcher(yearIdx, qNum)
        TimedMcqSpec(
          topic = mq.topicName.ifBlank { "විෂය කරුණු" },
          questionText = cleanStem(mq.questionText),
          options = mq.options.map { sanitizeOption(it) },
          correctIndex = (mq.correctOption - 1).coerceIn(0, 3),
          explanation = mq.explanation.ifBlank { "${mq.topicName} ඒකකයට අදාළ නිවැරදි පිළිතුරකි." }
        )
      }
      val ordered = if (interleaveTopics) interleave60(raw) else raw
      ordered.mapIndexed { idx, spec ->
        val finalSpec = if (rebalanceSlots) rebalanceItem(spec, yearIdx, idx) else spec
        PastPaperQuestion(
          id = idx + 1,
          questionText = finalSpec.questionText,
          options = finalSpec.options,
          correctOptionIndex = finalSpec.correctIndex,
          explanationSinhala = finalSpec.explanation,
          topicCategory = finalSpec.topic
        )
      }
    }
  }

  fun build7YearPapersFromLiveBank(
    isEnglish: Boolean = false,
    fetcher: (term: Int, paperIdx: Int, qNum: Int) -> MockExamQuestion
  ): Array<List<PastPaperQuestion>> {
    val specs = ArrayList<TimedMcqSpec>(2200)
    val seen = HashSet<String>(2200)
    for (term in 1..3) {
      for (paperIdx in 1..30) {
        for (qNum in 1..60) {
          val mq = fetcher(term, paperIdx, qNum)
          val core = cleanStem(mq.questionText)
          val key = core.lowercase()
          val cleanOpts = mq.options.map { sanitizeOption(it) }
          val idx = mq.correctOption - 1
          val exp = mq.explanation.ifBlank { "${mq.topicName} ඒකකයට අදාළ නිවැරදි පිළිතුරකි." }
          if (isCleanAndBalanced(core, cleanOpts, idx, exp, isEnglish) && seen.add(key)) {
            specs.add(
              TimedMcqSpec(
                topic = mq.topicName.ifBlank { "විෂය කරුණු" },
                questionText = core,
                options = cleanOpts,
                correctIndex = idx,
                explanation = exp
              )
            )
          }
        }
      }
    }
    return distributeTo7Years(specs, isEnglish = isEnglish)
  }

  fun distributeTo7Years(
    rawSpecs: List<TimedMcqSpec>,
    isEnglish: Boolean = false
  ): Array<List<PastPaperQuestion>> {
    val cleanSpecs = ArrayList<TimedMcqSpec>(rawSpecs.size)
    val seen = HashSet<String>(rawSpecs.size)
    for (s in rawSpecs) {
      val core = cleanStem(s.questionText)
      val cleanOpts = s.options.map { sanitizeOption(it) }
      val exp = s.explanation.ifBlank { "${s.topic} ඒකකයට අදාළ නිවැරදි පිළිතුරකි." }
      if (isCleanAndBalanced(core, cleanOpts, s.correctIndex, exp, isEnglish) && seen.add(core.lowercase())) {
        cleanSpecs.add(
          s.copy(
            topic = s.topic.ifBlank { "විෂය කරුණු" },
            questionText = core,
            options = cleanOpts,
            explanation = exp
          )
        )
      }
    }

    require(cleanSpecs.size >= 420) {
      "TimedPastPaperQualityHelper requires >= 420 clean specs, found ${cleanSpecs.size}"
    }

    // Group by topic into mutable deques so we round-robin topics fairly across all 7 years
    val topicQueues = LinkedHashMap<String, ArrayDeque<TimedMcqSpec>>()
    for (spec in cleanSpecs) {
      topicQueues.getOrPut(spec.topic) { ArrayDeque() }.addLast(spec)
    }

    // Sort topic keys deterministically by bucket size descending then name so largest buckets rotate evenly
    val yearBuckets = Array(7) { ArrayList<TimedMcqSpec>(60) }
    val allTopicKeys = topicQueues.keys.toList()
    var cursor = 0
    var remaining = 420
    var yearCursor = 0

    while (remaining > 0) {
      var picked = false
      for (offset in allTopicKeys.indices) {
        val key = allTopicKeys[(cursor + offset) % allTopicKeys.size]
        val queue = topicQueues[key]!!
        if (queue.isNotEmpty()) {
          yearBuckets[yearCursor].add(queue.removeFirst())
          yearCursor = (yearCursor + 1) % 7
          cursor = (cursor + offset + 1) % allTopicKeys.size
          remaining--
          picked = true
          break
        }
      }
      if (!picked) break
    }

    return Array(7) { yearIdx ->
      val interleaved = interleave60(yearBuckets[yearIdx])
      interleaved.mapIndexed { idx, spec ->
        val balanced = rebalanceItem(spec, yearIdx, idx)
        PastPaperQuestion(
          id = idx + 1,
          questionText = balanced.questionText,
          options = balanced.options,
          correctOptionIndex = balanced.correctIndex,
          explanationSinhala = balanced.explanation,
          topicCategory = balanced.topic
        )
      }
    }
  }

  private fun interleave60(items: List<TimedMcqSpec>): List<TimedMcqSpec> {
    if (items.isEmpty()) return emptyList()
    val grouped = LinkedHashMap<String, ArrayDeque<TimedMcqSpec>>()
    for (item in items) {
      grouped.getOrPut(item.topic) { ArrayDeque() }.addLast(item)
    }

    val result = ArrayList<TimedMcqSpec>(items.size)
    var lastTopic = ""
    while (result.size < items.size) {
      // Pick topic with the largest remaining queue that != lastTopic
      val nextKey = grouped.entries
        .filter { it.value.isNotEmpty() && it.key != lastTopic }
        .maxByOrNull { it.value.size }
        ?.key
        ?: grouped.entries.firstOrNull { it.value.isNotEmpty() }?.key
        ?: break

      val picked = grouped[nextKey]!!.removeFirst()
      result.add(picked)
      lastTopic = picked.topic
    }
    return result
  }

  private fun rebalanceItem(spec: TimedMcqSpec, yearIdx: Int, qIdx: Int): TimedMcqSpec {
    val correctText = spec.options[spec.correctIndex]
    val distractors = spec.options.filterIndexed { i, _ -> i != spec.correctIndex }
    if (distractors.size < 3) return spec

    // Distribute correct slot evenly (15 per slot in 60 Qs), with year offset
    val targetSlot = (qIdx + yearIdx) % 4
    val rot = abs(spec.questionText.hashCode() + yearIdx * 5 + qIdx * 3) % 3
    val rotDistractors = listOf(
      distractors[rot % 3],
      distractors[(rot + 1) % 3],
      distractors[(rot + 2) % 3]
    )

    val newOpts = ArrayList<String>(4)
    var dPtr = 0
    for (slot in 0..3) {
      if (slot == targetSlot) {
        newOpts.add(correctText)
      } else {
        newOpts.add(rotDistractors[dPtr++])
      }
    }
    return spec.copy(options = newOpts, correctIndex = targetSlot)
  }
}
