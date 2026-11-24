package com.example

import com.example.ExamQuestionHelper.QSpec

/**
 * Curated English Live Exam Hall Question Bank Coordinator (G.C.E. O/L Grades 10 & 11).
 *
 * Combines 10 distinct O/L English Language syllabus domain banks (~1,960+ strictly unique
 * MCQs with concise topic-matched options and verified answers):
 *  0. Parts of Speech, Nouns, Pronouns, Articles & Adjectives
 *  1. Tenses & Sequence of Tenses
 *  2. Subject-Verb Agreement, Modals & Question Tags
 *  3. Active & Passive Voice
 *  4. Reported Speech, Conditionals & Wishes
 *  5. Prepositions, Phrasal Verbs & Conjunctions
 *  6. Relative Clauses, Gerunds, Comparison & Error Correction
 *  7. Vocabulary: Synonyms, Antonyms, Affixes & Confusable Words
 *  8. Idioms, Proverbs, Dialogues, Notices & Reading Comprehension
 *  9. Punctuation, Formal Letters, Graphs & Essay Cohesion
 *
 * Within every 60-question paper (across all 30 papers per term, Terms 1..3, Grades 10 & 11):
 *  - Each paper covers all 10 O/L English domains evenly (6 questions per domain) with zero
 *    consecutive identical topics.
 *  - Every question across all 30 papers in a term (1,800 questions) is strictly unique
 *    with zero duplicates or repetitive templates.
 */
internal object EnglishLiveExamQuestionBank {

  private val domainTopics = listOf(
    "Parts of Speech, Nouns, Articles & Determiners",
    "Tenses & Sequence of Tenses",
    "Subject-Verb Agreement, Modals & Question Tags",
    "Active & Passive Voice",
    "Reported Speech, Conditionals & Wishes",
    "Prepositions, Phrasal Verbs & Conjunctions",
    "Relative Clauses, Gerunds, Comparison & Error Correction",
    "Vocabulary, Affixes, Word Formation & Spellings",
    "Idioms, Functional Dialogues, Notices & Comprehension",
    "Punctuation, Letters, Charts & Writing Cohesion"
  )

  private val domains: List<List<QSpec>> by lazy {
    val rawDomains = listOf(
      EnglishLiveExamPartsBank1.questions() + EnglishLiveExamPartsBank2.questions(),
      EnglishLiveExamTensesBank1.questions() + EnglishLiveExamTensesBank2.questions(),
      EnglishLiveExamAgreeModalsBank1.questions() + EnglishLiveExamAgreeModalsBank2.questions(),
      EnglishLiveExamPassiveBank1.questions() + EnglishLiveExamPassiveBank2.questions(),
      EnglishLiveExamSpeechCondBank1.questions() + EnglishLiveExamSpeechCondBank2.questions(),
      EnglishLiveExamPrepConjBank1.questions() + EnglishLiveExamPrepConjBank2.questions(),
      EnglishLiveExamClausesErrBank1.questions() + EnglishLiveExamClausesErrBank2.questions(),
      EnglishLiveExamVocabBank1.questions() + EnglishLiveExamVocabBank2.questions(),
      EnglishLiveExamReadingFuncBank1.questions() + EnglishLiveExamReadingFuncBank2.questions(),
      EnglishLiveExamWritingBank1.questions() + EnglishLiveExamWritingBank2.questions()
    )

    val globalSeen = HashSet<String>(2400)
    rawDomains.mapIndexed { domainIdx, domainList ->
      val canonicalTopic = domainTopics[domainIdx]
      val cleaned = ArrayList<QSpec>(domainList.size)
      for (spec in domainList) {
        val cleanStem = ExamQuestionHelper.cleanStem(spec.questionText)
        val cleanCorrect = ExamQuestionHelper.normalizeOption(spec.correct)
        val distinctDistractors = spec.distractors
          .map { ExamQuestionHelper.normalizeOption(it) }
          .filter { it.isNotBlank() && it != cleanCorrect }
          .distinct()

        if (cleanStem.isBlank() || cleanCorrect.isBlank() || distinctDistractors.size < 3) {
          continue
        }
        val key = cleanStem.lowercase()
        if (globalSeen.add(key)) {
          cleaned.add(
            spec.copy(
              topic = canonicalTopic,
              questionText = cleanStem,
              correct = cleanCorrect,
              distractors = distinctDistractors.take(3)
            )
          )
        }
      }
      cleaned
    }
  }

  private val strideCandidates = intArrayOf(11, 13, 17, 19, 23, 29, 31, 37, 41, 43)

  private fun gcd(a: Int, b: Int): Int {
    var x = kotlin.math.abs(a)
    var y = kotlin.math.abs(b)
    while (y != 0) {
      val t = x % y
      x = y
      y = t
    }
    return if (x == 0) 1 else x
  }

  private fun coprimeStride(n: Int, selector: Int): Int {
    if (n <= 1) return 1
    var stride = strideCandidates[selector % strideCandidates.size]
    while (gcd(stride, n) != 1 || stride % n == 0) {
      stride++
    }
    return stride
  }

  internal fun domainSizes(): List<Int> = domains.map { it.size }

  fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    val gIdx = if (grade.contains("10")) 0 else 1
    val tIdx = term.coerceIn(1, 3) - 1
    val pIdx = paperIdx.coerceIn(1, 30) - 1
    val qIdx = qNum.coerceIn(1, 60) - 1

    // Visits 0..59 bijectively as qIdx runs 0..59 for any fixed (gIdx, tIdx, pIdx).
    val slot = (qIdx + pIdx * 7 + tIdx * 3 + gIdx * 5) % 60
    val domainIdx = slot % 10
    val subSlot = slot / 10 // 0..5
    val inTermDomainSlot = pIdx * 6 + subSlot // 0..179 strictly unique per (paper, qNum)

    val bucket = domains[domainIdx]
    val n = bucket.size
    val stride = coprimeStride(n, gIdx * 3 + tIdx + domainIdx)
    val offset = ((gIdx * 3 + tIdx) * 37 + domainIdx * 19) % n
    val idx = (offset + inTermDomainSlot * stride) % n

    val spec = bucket[idx]
    val seed = gIdx * 100_000 + term * 10_000 + paperIdx * 137 + qNum * 17 + slot * 29
    return ExamQuestionHelper.fromSpec(
      id = qNum,
      spec = spec,
      seed = seed
    )
  }
}
