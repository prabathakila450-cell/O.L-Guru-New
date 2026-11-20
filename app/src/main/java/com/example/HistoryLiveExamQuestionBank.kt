package com.example

import com.example.ExamQuestionHelper.QSpec

/**
 * Curated History Live Exam Hall Question Bank Coordinator.
 *
 * Combines 10 distinct History O/L syllabus domain banks (~1,950+ strictly unique MCQs
 * with authentic Sinhala options and verified correct answers):
 *  0. ඓතිහාසික මූලාශ්‍ර හා ප්‍රාග් ඓතිහාසික යුගය
 *  1. පැරණි ජනාවාස, රාජ්‍ය පාලනය හා ආර්ථිකය
 *  2. අනුරාධපුර රාජධානිය, බුදුදහම හා කලාව
 *  3. පොළොන්නරු යුගය හා රජරට ශිෂ්ටාචාරයේ බිඳවැටීම
 *  4. දඹදෙණිය, යාපහුව, කුරුණෑගල, ගම්පොළ හා යාපනය රාජධානි
 *  5. කෝට්ටේ, සීතාවක හා මහනුවර රාජධානි
 *  6. යුරෝපීය පුනරුදය, කාර්මික විප්ලවය හා ලෝක විප්ලව
 *  7. යටත්විජිත ශ්‍රී ලංකාව, මුල් බ්‍රිතාන්‍ය පාලනය හා නිදහස් අරගල
 *  8. වැවිලි ආර්ථිකය, යටිතල පහසුකම් හා බෞද්ධ පුනරුදය
 *  9. නූතන ආණ්ඩුක්‍රම ප්‍රතිසංස්කරණ, නිදහස හා ලෝක යුද්ධ
 *
 * Within every 60-question paper (across all 30 papers per term, Terms 1..3, Grades 10 & 11):
 *  - Each paper covers all 10 History domains evenly (6 questions per domain) with zero
 *    consecutive identical topics.
 *  - Every question across all 30 papers in a term (1,800 questions) is strictly unique
 *    with zero duplicate or repetitive templates.
 */
internal object HistoryLiveExamQuestionBank {

  private val domainTopics = listOf(
    "ඓතිහාසික මූලාශ්‍ර හා ප්‍රාග් ඓතිහාසික යුගය",
    "පැරණි ජනාවාස, රාජ්‍ය පාලනය හා ආර්ථිකය",
    "අනුරාධපුර රාජධානිය, බුදුදහම හා කලාව",
    "පොළොන්නරු යුගය හා රජරට ශිෂ්ටාචාරයේ බිඳවැටීම",
    "දඹදෙණිය, යාපහුව, කුරුණෑගල, ගම්පොළ හා යාපනය රාජධානි",
    "කෝට්ටේ, සීතාවක හා මහනුවර රාජධානි",
    "යුරෝපීය පුනරුදය, කාර්මික විප්ලවය හා ලෝක විප්ලව",
    "යටත්විජිත ශ්‍රී ලංකාව, මුල් බ්‍රිතාන්‍ය පාලනය හා නිදහස් අරගල",
    "වැවිලි ආර්ථිකය, යටිතල පහසුකම් හා බෞද්ධ පුනරුදය",
    "නූතන ආණ්ඩුක්‍රම ප්‍රතිසංස්කරණ, නිදහස හා ලෝක යුද්ධ"
  )

  private val domains: List<List<QSpec>> by lazy {
    val rawDomains = listOf(
      HistoryLiveExamSourcesPrehistoryBank.sourcesAndPrehistoryQuestions(),
      HistoryLiveExamEarlySettlementBank.earlySettlementAndAdminQuestions(),
      HistoryLiveExamAnuradhapuraBank.anuradhapuraEraQuestions(),
      HistoryLiveExamPolonnaruwaBank.polonnaruwaAndRajarataFallQuestions(),
      HistoryLiveExamWetZoneKingdomsBank.wetZoneKingdomsQuestions(),
      HistoryLiveExamKotteKandyBank.kotteSitawakaKandyQuestions(),
      HistoryLiveExamWorldRevBank.renaissanceAndRevolutionsQuestions(),
      HistoryLiveExamColonialSriLankaBank.colonialSriLankaAndRebellionsQuestions().map { it.toQSpec() },
      HistoryLiveExamSocioRevivalBank.socioEconomicAndRevivalQuestions().map { it.toQSpec() },
      HistoryLiveExamModernConstBank.constitutionalModernAndWorldWarsQuestions().map { it.toQSpec() }
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
