package com.example

import com.example.ExamQuestionHelper.QSpec

/**
 * Curated Sinhala Live Exam Hall Question Bank Coordinator.
 *
 * Combines 10 distinct Sinhala O/L syllabus domain banks (~1,900+ strictly unique MCQs
 * with authentic, question-specific Sinhala options and verified correct answers):
 *  0. අක්ෂර මාලාව හා අක්ෂර වින්‍යාසය (Orthography & Alphabet)
 *  1. සම්භාව්‍ය පද්‍ය හා කාව්‍ය ශාස්ත්‍රය (Classical Poetry & Poetics)
 *  2. පද බෙදීම, ක්‍රියා පද හා උක්ත-ආඛ්‍යාත (Word Division, Verbs & Agreement)
 *  3. සම්භාව්‍ය ගද්‍ය හා ජාතක කතා (Classical Prose & Jataka Tales)
 *  4. පද සංවිධානය, ප්‍රස්ථාව පිරුළු හා රූඪි (Vocabulary, Idioms & Proverbs)
 *  5. සන්දේශ කාව්‍ය සාහිත්‍යය (Sandesha Kavya Literature)
 *  6. විභක්ති, කාරක, උපසර්ග, නිපාත හා විරාම ලකුණු (Cases, Prefixes, Particles & Punctuation)
 *  7. නූතන පද්‍ය, ගද්‍ය හා නාට්‍ය (Modern Literature & Drama)
 *  8. සන්ධි, සමාස, කෘදන්ත හා තද්ධිත (Sandhi, Samasa & Derivatives)
 *  9. ලේඛන කලාව, රචනා, නිල ලිපි හා විචාරය (Writing, Official Letters & Critique)
 *
 * Within every 60-question paper (across all 30 papers per term, Terms 1..3, Grades 10 & 11):
 *  - Each paper covers all 10 syllabus domains evenly (6 questions per domain).
 *  - Every question across all 30 papers in a term (1,800 questions) is strictly unique
 *    with zero duplicates or repetitive templates.
 */
internal object SinhalaLiveExamQuestionBank {

  private val domains: List<List<QSpec>> by lazy {
    val rawDomains = listOf(
      SinhalaLiveExamGrammarBank1.orthographyQuestions(),
      SinhalaLiveExamClassicalPoetryBank.classicalPoetryQuestions(),
      SinhalaLiveExamGrammarBank1.wordDivisionAndVerbQuestions(),
      SinhalaLiveExamProseBank.classicalProseQuestions(),
      SinhalaLiveExamVocabBank.vocabAndProverbQuestions(),
      SinhalaLiveExamSandeshaBank.sandeshaKavyaQuestions(),
      SinhalaLiveExamGrammarBank2.casesVoiceAndPunctuationQuestions(),
      SinhalaLiveExamModernLitBank.modernLiteratureQuestions(),
      SinhalaLiveExamGrammarBank2.sandhiSamasaQuestions(),
      SinhalaLiveExamWritingBank.writingAndCritiqueQuestions()
    )

    val globalSeen = HashSet<String>(2400)
    rawDomains.map { domainList ->
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
    val seed = gIdx * 100_000 + term * 10_000 + paperIdx * 100 + qNum
    return ExamQuestionHelper.fromSpec(
      id = qNum,
      spec = spec,
      seed = seed
    )
  }
}
