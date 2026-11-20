package com.example

import kotlin.math.abs

/**
 * Shared builder & quality-enforcer for all 15 O/L Mock Exam Question Banks.
 * - Guarantees 4 non-blank, strictly distinct options per MCQ.
 * - Deterministically distributes correctOption across 1..4 so answers are not biased to Option 1.
 * - Normalizes question stems cleanly (avoiding fake "[qNum]" prefixes and avoiding ": " collisions
 *   for TimedPastPaperYearProvider compatibility).
 * - Provides curated SubjectMaster + QuizQuestion extraction and multi-angle authentic MCQ builders.
 */
object ExamQuestionHelper {

  data class QSpec(
    val topic: String,
    val questionText: String,
    val correct: String,
    val distractors: List<String>,
    val explanation: String
  )

  private val fallbackPool = listOf(
    "ඉහත කිසිවක් නිවැරදි නොවේ",
    "දී ඇති දත්ත ප්‍රමාණවත් නොවේ",
    "ඉහත සියලුම පිළිතුරු නිවැරදි වේ",
    "විකල්ප පිළිතුරක් අදාළ නොවේ"
  )

  fun cleanStem(raw: String): String {
    var s = raw.trim()
    s = s.replace(Regex("^\\[\\d+\\]\\s*"), "")
    s = s.replace(Regex("^.*?ආදර්ශ පත්‍රය\\s*\\d+\\s*•\\s*ප්‍රශ්නය\\s*\\d+:\\s*"), "")
    s = s.replace(": ", " — ")
    return s.trim()
  }

  fun buildMcq(
    id: Int,
    topic: String,
    questionText: String,
    correct: String,
    distractors: List<String>,
    explanation: String,
    seed: Int
  ): MockExamQuestion {
    val cleanCorrect = correct.trim().ifBlank { "නිවැරදි පිළිතුර" }
    val uniqueDistractors = LinkedHashSet<String>()
    for (d in distractors) {
      val trimmed = d.trim()
      if (trimmed.isNotBlank() && trimmed != cleanCorrect) {
        uniqueDistractors.add(trimmed)
      }
      if (uniqueDistractors.size == 3) break
    }
    var fbIdx = 0
    while (uniqueDistractors.size < 3 && fbIdx < fallbackPool.size) {
      val fb = fallbackPool[fbIdx++]
      if (fb != cleanCorrect) uniqueDistractors.add(fb)
    }
    var suffix = 1
    while (uniqueDistractors.size < 3) {
      val cand = "$cleanCorrect නොවන විකල්පය $suffix"
      if (cand != cleanCorrect) uniqueDistractors.add(cand)
      suffix++
    }

    val dList = uniqueDistractors.toList().take(3)
    // Deterministic permutation of distractors + target slot 0..3
    val targetSlot = abs(seed * 7 + id * 13 + cleanCorrect.hashCode()) % 4
    val rot = abs(seed * 3 + id * 5) % 3
    val rotatedD = listOf(
      dList[rot % 3],
      dList[(rot + 1) % 3],
      dList[(rot + 2) % 3]
    )

    val options = ArrayList<String>(4)
    var dCursor = 0
    for (pos in 0..3) {
      if (pos == targetSlot) {
        options.add(cleanCorrect)
      } else {
        options.add(rotatedD[dCursor++])
      }
    }

    return MockExamQuestion(
      id = id,
      questionText = cleanStem(questionText),
      options = options,
      correctOption = targetSlot + 1,
      explanation = explanation.ifBlank { "$topic ඒකකයට අදාළ නිවැරදි විෂය කරුණකි." },
      topicName = topic.ifBlank { "විෂය කරුණු" }
    )
  }

  fun normalizeOption(opt: String): String {
    return opt.trim()
      .replace(Regex("^[1-4]\\.\\s*"), "")
      .replace(Regex("^[A-Da-d]\\)\\s*"), "")
      .trim()
  }

  fun fromSpec(id: Int, spec: QSpec, seed: Int): MockExamQuestion {
    return buildMcq(
      id = id,
      topic = spec.topic,
      questionText = spec.questionText,
      correct = normalizeOption(spec.correct),
      distractors = spec.distractors.map { normalizeOption(it) },
      explanation = spec.explanation,
      seed = seed
    )
  }

  fun fromQuizQuestion(id: Int, topic: String, q: QuizQuestion, seed: Int): MockExamQuestion {
    return fromSpec(id, quizQuestionToSpec(topic, q), seed)
  }

  fun quizQuestionToSpec(topic: String, q: QuizQuestion): QSpec {
    val opts = q.options.ifEmpty { listOf("නිවැරදි පිළිතුර", "විකල්ප B", "විකල්ප C", "විකල්ප D") }
    val safeIdx = q.correct_option_index.coerceIn(0, opts.lastIndex)
    val correct = normalizeOption(opts[safeIdx])
    val distractors = opts.filterIndexed { index, _ -> index != safeIdx }.map { normalizeOption(it) }
    return QSpec(
      topic = topic,
      questionText = cleanStem(q.question_text),
      correct = correct,
      distractors = distractors,
      explanation = q.explanation
    )
  }

  fun dedupPool(specs: List<QSpec>): List<QSpec> {
    val seen = HashSet<String>(specs.size * 2)
    val out = ArrayList<QSpec>(specs.size)
    for (s in specs) {
      val cleanQ = cleanStem(s.questionText)
      if (cleanQ.isBlank()) continue
      val key = cleanQ.lowercase()
      if (seen.add(key)) {
        out.add(s.copy(questionText = cleanQ))
      }
    }
    return out
  }

  fun selectFromMasterPool(
    pool: List<QSpec>,
    grade: String,
    term: Int,
    paperIdx: Int,
    qNum: Int
  ): MockExamQuestion {
    val gIdx = if (grade.contains("11")) 1 else 0
    val tIdx = term.coerceIn(1, 3) - 1
    val bucket = gIdx * 3 + tIdx // 0..5
    val inTermIdx = globalIndex(paperIdx, qNum) // 0..1799 exact bijection
    val offset = if (pool.size >= 1800) bucket * 300 else bucket * 60
    val idx = (inTermIdx + offset) % pool.size
    return fromSpec(
      id = qNum,
      spec = pool[idx],
      seed = (bucket * 1800) + inTermIdx + qNum
    )
  }

  /**
   * Computes bijective (slot, variant) coordinates for any paperIdx (1..30) and qNum (1..60):
   * - Within each paper, slot runs over all 0..59 syllabus slots exactly once (rotated by coprime 7).
   * - Across all 30 papers, (variant * 60 + slot) visits 0..1799 with zero overlap.
   */
  fun slotOf(paperIdx: Int, qNum: Int): Int {
    val cleanP = paperIdx.coerceIn(1, 30) - 1
    val cleanQ = qNum.coerceIn(1, 60) - 1
    return (cleanQ + cleanP * 7) % 60
  }

  fun variantOf(paperIdx: Int): Int = paperIdx.coerceIn(1, 30) - 1

  fun globalIndex(paperIdx: Int, qNum: Int): Int = variantOf(paperIdx) * 60 + slotOf(paperIdx, qNum)

  /**
   * Generates a curated pool of authentic multi-angle MCQs from SubjectMasterCategory lists
   * (400 verified SubjectFactPoints across 20 categories), guaranteeing every stem in the
   * resulting list is strictly unique and free of generic placeholders.
   */
  fun buildPoolFromSubjectMaster(
    categories: List<SubjectMasterCategory>,
    subjectLabel: String,
    seedBase: Int
  ): List<QSpec> {
    val validCats = categories.filter { !it.id.startsWith("padded_cat_") }
    val allPoints = validCats.flatMap { cat ->
      cat.points.filter {
        !it.title.contains("ප්‍රධාන කරුණ ") && !it.title.contains("වැදගත් කරුණ ")
      }.map { pt -> cat to pt }
    }
    if (allPoints.size < 4) return emptyList()

    val result = ArrayList<QSpec>(allPoints.size * 4)
    val usedStems = HashSet<String>()

    fun addIfUnique(spec: QSpec) {
      val cleaned = cleanStem(spec.questionText)
      if (usedStems.add(cleaned)) {
        result.add(spec.copy(questionText = cleaned))
      }
    }

    val n = allPoints.size

    // Angle 1: Given detail description -> identify concept title
    for (i in 0 until n) {
      val (cat, pt) = allPoints[i]
      val detailClean = pt.detail.trim()
      if (detailClean.length < 15) continue
      val d1 = allPoints[(i + 7) % n].second.title
      val d2 = allPoints[(i + 19) % n].second.title
      val d3 = allPoints[(i + 37) % n].second.title
      addIfUnique(
        QSpec(
          topic = cat.titleSinhala,
          questionText = "$subjectLabel විෂයෙහි '${cat.titleSinhala}' ඒකකය යටතේ \"$detailClean\" යනුවෙන් හැඳින්වෙන්නේ කුමක්ද?",
          correct = pt.title,
          distractors = listOf(d1, d2, d3),
          explanation = "${pt.title} — $detailClean ${pt.examHighlight}".trim()
        )
      )
    }

    // Angle 2: Given concept title -> identify accurate explanation/definition
    for (i in 0 until n) {
      val (cat, pt) = allPoints[i]
      val d1 = allPoints[(i + 11) % n].second.detail
      val d2 = allPoints[(i + 23) % n].second.detail
      val d3 = allPoints[(i + 41) % n].second.detail
      addIfUnique(
        QSpec(
          topic = cat.titleSinhala,
          questionText = "$subjectLabel විෂය නිර්දේශයේ '${cat.titleSinhala}' ඒකකයේ එන \"${pt.title}\" පිළිබඳ නිවැරදි විග්‍රහය කුමක්ද?",
          correct = pt.detail,
          distractors = listOf(d1, d2, d3),
          explanation = "${pt.title} — ${pt.detail} (${pt.examHighlight})".trim()
        )
      )
    }

    // Angle 3: Given concept & category -> identify exam highlight / core application
    for (i in 0 until n) {
      val (cat, pt) = allPoints[i]
      val hl = pt.examHighlight.trim()
      if (hl.length < 12) continue
      val d1 = allPoints[(i + 13) % n].second.examHighlight
      val d2 = allPoints[(i + 29) % n].second.examHighlight
      val d3 = allPoints[(i + 43) % n].second.examHighlight
      if (listOf(d1, d2, d3).distinct().size == 3) {
        addIfUnique(
          QSpec(
            topic = cat.titleSinhala,
            questionText = "\"${pt.title}\" (${cat.titleSinhala}) සම්බන්ධයෙන් O/L විභාගයේදී විශේෂයෙන් අවධාරණය කෙරෙන ප්‍රධාන කරුණ කුමක්ද?",
            correct = hl,
            distractors = listOf(d1, d2, d3),
            explanation = "${pt.title} — ${pt.detail} ($hl)"
          )
        )
      }
    }

    // Angle 4: Identify the exact syllabus unit/category containing the concept
    if (validCats.size >= 4) {
      val catTitles = validCats.map { it.titleSinhala }
      for (i in 0 until n) {
        val (cat, pt) = allPoints[i]
        val otherCats = catTitles.filter { it != cat.titleSinhala }
        if (otherCats.size >= 3) {
          val offset = (i + seedBase) % otherCats.size
          val d1 = otherCats[offset % otherCats.size]
          val d2 = otherCats[(offset + 1) % otherCats.size]
          val d3 = otherCats[(offset + 2) % otherCats.size]
          addIfUnique(
            QSpec(
              topic = cat.titleSinhala,
              questionText = "\"${pt.title}\" යන සංකල්පය $subjectLabel විෂය නිර්දේශයේ කුමන ප්‍රධාන ඒකකයට අයත් වේද?",
              correct = cat.titleSinhala,
              distractors = listOf(d1, d2, d3),
              explanation = "${pt.title} යනු '${cat.titleSinhala}' ඒකකයේ මූලික කරුණකි — ${pt.detail}"
            )
          )
        }
      }
    }

    return result
  }

  /**
   * Builds curated MCQs from ShortAnswerMasterRepository Grade 10 & Grade 11 (up to 400 unique Q&As per subject).
   */
  fun buildPoolFromShortAnswers(subjectKey: String): List<QSpec> {
    val allItems = ArrayList<ShortAnswerQuestion>(400)
    for (g in listOf("10", "11")) {
      for (setNum in 1..20) {
        allItems.addAll(ShortAnswerMasterRepository.getQuestions(g, subjectKey, setNum))
      }
    }
    if (allItems.size < 4) return emptyList()

    val candidates = allItems.mapNotNull { item ->
      val ans = item.sampleIdealAnswer.trim().ifBlank { item.keyPoints.joinToString(", ") }
      val q = item.question.trim()
      if (q.length < 10 || ans.length < 2) null else Triple(item, q, ans)
    }.distinctBy { it.second.lowercase() }

    val n = candidates.size
    if (n < 4) return emptyList()

    return candidates.mapIndexed { idx, (item, qText, ans) ->
      val distractors = ArrayList<String>(3)
      var step = 7
      while (distractors.size < 3 && step < n) {
        val cand = candidates[(idx + step) % n].third
        if (cand != ans && !distractors.contains(cand)) {
          distractors.add(cand)
        }
        step += 11
      }
      QSpec(
        topic = item.topic,
        questionText = qText,
        correct = ans,
        distractors = distractors,
        explanation = item.officialMarkingScheme.ifBlank { ans }
      )
    }
  }
}
