package com.example

import com.example.ExamQuestionHelper.QSpec

/**
 * Curated Dancing (නර්තනය) Live Exam Hall Question Bank Coordinator.
 *
 * Combines 10 distinct G.C.E. O/L (Grades 10–11) Dancing syllabus domain banks
 * (1,890+ strictly unique MCQs in Sinhala with concise topic-matched options and verified answers):
 *  0. නර්තනයේ මූලාරම්භය, ඓතිහාසික විකාශනය හා සම්ප්‍රදායන්
 *  1. උඩරට නර්තන සම්ප්‍රදාය, වෙස් ඇඳුම හා මූලික සරඹ
 *  2. උඩරට දහඅට වන්නම්, ශාස්ත්‍රීය කවි හා තාල විග්‍රහය
 *  3. පහතරට නර්තන සම්ප්‍රදාය හා වෙස්මුහුණු කලාව
 *  4. සබරගමු නර්තන සම්ප්‍රදාය හා ජන නැටුම්
 *  5. දේශීය ශාන්තිකර්ම හා යාතුකර්ම
 *  6. පංචතූර්ය නාද වර්ගීකරණය හා නර්තන වාද්‍ය භාණ්ඩ
 *  7. නාට්‍ය ශාස්ත්‍රය, චතුර්විධ අභිනය හා නව රසය
 *  8. හස්ත මුද්‍රා විද්‍යාව හා භාරතීය/විදේශීය සම්භාව්‍ය නර්තන
 *  9. නර්තනයේ රිද්මය, තාල ශාස්ත්‍රය, නව නිර්මාණ හා වෘත්තීය අගය
 *
 * Within every 60-question paper (across all 30 papers per term, Terms 1..3, Grades 10 & 11):
 *  - Each paper covers all 10 Dancing syllabus domains evenly (6 questions per domain)
 *    with zero consecutive identical topics.
 *  - Every question across all 30 papers in a term (1,800 questions) is strictly unique
 *    with zero duplicates or repetitive templates.
 */
internal object DancingLiveExamQuestionBank {

  private val domainTopics = listOf(
    "නර්තනයේ මූලාරම්භය, ඓතිහාසික විකාශනය හා සම්ප්‍රදායන්",
    "උඩරට නර්තන සම්ප්‍රදාය, වෙස් ඇඳුම හා මූලික සරඹ",
    "උඩරට දහඅට වන්නම්, ශාස්ත්‍රීය කවි හා තාල විග්‍රහය",
    "පහතරට නර්තන සම්ප්‍රදාය හා වෙස්මුහුණු කලාව",
    "සබරගමු නර්තන සම්ප්‍රදාය හා ජන නැටුම්",
    "දේශීය ශාන්තිකර්ම හා යාතුකර්ම",
    "පංචතූර්ය නාද වර්ගීකරණය හා නර්තන වාද්‍ය භාණ්ඩ",
    "නාට්‍ය ශාස්ත්‍රය, චතුර්විධ අභිනය හා නව රසය",
    "හස්ත මුද්‍රා විද්‍යාව හා භාරතීය/විදේශීය සම්භාව්‍ය නර්තන",
    "නර්තනයේ රිද්මය, තාල ශාස්ත්‍රය, නව නිර්මාණ හා වෘත්තීය අගය"
  )

  private val domains: List<List<QSpec>> by lazy {
    val rawDomains = listOf(
      DancingLiveExamOriginTradBank1.questions() + DancingLiveExamOriginTradBank2.questions(),
      DancingLiveExamKandyanCoreBank1.questions() + DancingLiveExamKandyanCoreBank2.questions(),
      DancingLiveExamVannamBank1.questions() + DancingLiveExamVannamBank2.questions(),
      DancingLiveExamLowCountryMasksBank1.questions() + DancingLiveExamLowCountryMasksBank2.questions(),
      DancingLiveExamSabaragamuwaFolkBank1.questions() + DancingLiveExamSabaragamuwaFolkBank2.questions(),
      DancingLiveExamShanthikarmaBank1.questions() + DancingLiveExamShanthikarmaBank2.questions(),
      DancingLiveExamInstrumentsBank1.questions() + DancingLiveExamInstrumentsBank2.questions(),
      DancingLiveExamAbhinayaRasaBank1.questions() + DancingLiveExamAbhinayaRasaBank2.questions(),
      DancingLiveExamMudraClassicalBank1.questions() + DancingLiveExamMudraClassicalBank2.questions(),
      DancingLiveExamRhythmCreativeBank1.questions() + DancingLiveExamRhythmCreativeBank2.questions()
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
