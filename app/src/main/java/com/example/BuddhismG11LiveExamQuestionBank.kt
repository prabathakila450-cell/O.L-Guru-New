package com.example

import com.example.ExamQuestionHelper.QSpec

/**
 * Curated Grade 11 Buddhism Live Exam Hall Question Bank Coordinator.
 *
 * Combines 10 distinct Buddhism O/L syllabus domain banks (~1,900+ strictly unique MCQs
 * with authentic Sinhala options and verified correct answers):
 *  0. බුද්ධ චරිතය හා ශ්‍රාවක චරිත
 *  1. මූලික බෞද්ධ දර්ශනය (චතුරාර්ය සත්‍යය, ආර්ය අෂ්ටාංගික මාර්ගය, ත්‍රිලක්ෂණය)
 *  2. කර්මය, පුනර්භවය හා චිත්ත සංවර්ධනය
 *  3. සූත්‍ර ධර්ම හා පාලි ගාථා (ව්‍යග්ඝපජ්ජ, සිඟාලෝවාද, වසල, පරාභව, මහාමංගල)
 *  4. බෞද්ධ සදාචාරය, ගිහි විනය හා සමාජ දර්ශනය
 *  5. බෞද්ධ ආර්ථික දර්ශනය හා පරිසර සංරක්ෂණය
 *  6. ත්‍රිපිටකය හා ධර්ම සංගායනා ඉතිහාසය
 *  7. ශ්‍රී ලංකාවේ බුදුසසුනේ ඉතිහාසය හා පුනර්ජීවනය
 *  8. බෞද්ධ සංස්කෘතිය, වත්පිළිවෙත්, කලාව හා සිද්ධස්ථාන
 *  9. බෞද්ධ සාහිත්‍යය, ජාතක කතා හා නූතන අභියෝග
 *
 * Within every 60-question paper (across all 30 papers per term, Terms 1..3):
 *  - Each paper covers all 10 Buddhism domains evenly (6 questions per domain).
 *  - Every question across all 30 papers in a term (1,800 questions) is strictly unique
 *    with zero duplicates or repetitive syllabus unit prefixes.
 */
internal object BuddhismG11LiveExamQuestionBank {

  private val domainTopics = listOf(
    "බුද්ධ චරිතය හා ශ්‍රාවක චරිත",
    "මූලික බෞද්ධ දර්ශනය",
    "කර්මය, පුනර්භවය හා චිත්ත සංවර්ධනය",
    "සූත්‍ර ධර්ම හා පාලි ගාථා",
    "බෞද්ධ සදාචාරය, ගිහි විනය හා සමාජ දර්ශනය",
    "බෞද්ධ ආර්ථික දර්ශනය හා පරිසර සංරක්ෂණය",
    "ත්‍රිපිටකය හා ධර්ම සංගායනා ඉතිහාසය",
    "ශ්‍රී ලංකාවේ බුදුසසුනේ ඉතිහාසය හා පුනර්ජීවනය",
    "බෞද්ධ සංස්කෘතිය, වත්පිළිවෙත්, කලාව හා සිද්ධස්ථාන",
    "බෞද්ධ සාහිත්‍යය, ජාතක කතා හා නූතන අභියෝග"
  )

  private val domains: List<List<QSpec>> by lazy {
    val rawDomains = listOf(
      BuddhismG11LiveExamLifeBank.questions() + BuddhismG11LiveExamDisciplesBank.questions(),
      BuddhismG11LiveExamPhilosophyBank.questions() + BuddhismG11LiveExamPhilosophyBank2.questions(),
      BuddhismG11LiveExamKarmaBank.questions() + BuddhismG11LiveExamMeditationBank.questions(),
      BuddhismG11LiveExamSuttaBank1.questions() + BuddhismG11LiveExamSuttaBank2.questions(),
      BuddhismG11LiveExamEthicsBank1.questions() + BuddhismG11LiveExamEthicsBank2.questions(),
      BuddhismG11LiveExamEconomyBank1.questions() + BuddhismG11LiveExamEconomyBank2.questions(),
      BuddhismG11LiveExamTripitakaBank1.questions() + BuddhismG11LiveExamTripitakaBank2.questions(),
      BuddhismG11LiveExamSriLankaBank1.questions() + BuddhismG11LiveExamSriLankaBank2.questions(),
      BuddhismG11LiveExamCultureBank1.questions() + BuddhismG11LiveExamCultureBank2.questions(),
      BuddhismG11LiveExamLitBank1.questions() + BuddhismG11LiveExamLitBank2.questions()
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

  internal fun domainTopic(idx: Int): String = domainTopics[idx.coerceIn(0, domainTopics.lastIndex)]

  fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    val tIdx = term.coerceIn(1, 3) - 1
    val pIdx = paperIdx.coerceIn(1, 30) - 1
    val qIdx = qNum.coerceIn(1, 60) - 1

    // Visits 0..59 bijectively as qIdx runs 0..59 for any fixed (tIdx, pIdx).
    val slot = (qIdx + pIdx * 7 + tIdx * 3) % 60
    val domainIdx = slot % 10
    val subSlot = slot / 10 // 0..5
    val inTermDomainSlot = pIdx * 6 + subSlot // 0..179 strictly unique per (paper, qNum)

    val bucket = domains[domainIdx]
    val n = bucket.size
    val stride = coprimeStride(n, tIdx + domainIdx + 3)
    val offset = (tIdx * 37 + domainIdx * 19) % n
    val idx = (offset + inTermDomainSlot * stride) % n

    val spec = bucket[idx]
    val seed = term * 10_000 + paperIdx * 100 + qNum
    return ExamQuestionHelper.fromSpec(
      id = qNum,
      spec = spec,
      seed = seed
    )
  }
}
