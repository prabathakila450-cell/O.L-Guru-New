package com.example

import com.example.ExamQuestionHelper.QSpec

/**
 * Curated Geography Live Exam Hall Question Bank Coordinator.
 *
 * Combines 10 distinct Geography O/L syllabus domain banks (~1,970+ strictly unique MCQs
 * with authentic Sinhala options and verified correct answers):
 *  0. සිතියම් කියවීම, පරිමාණ හා භූගෝලීය තොරතුරු (Maps, Scales & GIS)
 *  1. පෘථිවි චලිත, අක්ෂාංශ-දේශාංශ හා වේලා කලාප (Earth Movements, Lat/Long & Time Zones)
 *  2. කාලගුණය, දේශගුණය හා ගෝලීය දේශගුණ කලාප (Weather, Climate & Climate Zones)
 *  3. භූ රූප විද්‍යාව, පාෂාණ හා භූ තැටි චලනය (Landforms, Rocks & Plate Tectonics)
 *  4. ශ්‍රී ලංකාවේ භූ විෂමතාව, ගංගා හා පරිසර පද්ධති (Sri Lanka Physical Geography & Ecosystems)
 *  5. ජනගහන භූගෝල විද්‍යාව හා ජනාවාස (Population & Settlement Geography)
 *  6. ස්වාභාවික සම්පත්, බලශක්ති හා ජල සම්පත් (Natural Resources, Energy & Water)
 *  7. ආර්ථික භූගෝල විද්‍යාව, කෘෂිකර්මය හා කර්මාන්ත (Economic Geography, Agriculture & Industry)
 *  8. ලෝක කලාපීය භූගෝල විද්‍යාව (World Regional Geography)
 *  9. පාරිසරික ගැටලු හා ආපදා කළමනාකරණය (Environmental Issues & Disaster Management)
 *
 * Within every 60-question paper (across all 30 papers per term, Terms 1..3, Grades 10 & 11):
 *  - Each paper covers all 10 Geography domains evenly (6 questions per domain) with zero
 *    consecutive identical topics.
 *  - Every question across all 30 papers in a term (1,800 questions) is strictly unique
 *    with zero duplicate or repetitive calculation templates.
 */
internal object GeographyLiveExamQuestionBank {

  private val domainTopics = listOf(
    "සිතියම් කියවීම, පරිමාණ හා භූගෝලීය තොරතුරු",
    "පෘථිවි චලිත, අක්ෂාංශ-දේශාංශ හා වේලා කලාප",
    "කාලගුණය, දේශගුණය හා ගෝලීය දේශගුණ කලාප",
    "භූ රූප විද්‍යාව, පාෂාණ හා භූ තැටි චලනය",
    "ශ්‍රී ලංකාවේ භූ විෂමතාව, ගංගා හා පරිසර පද්ධති",
    "ජනගහන භූගෝල විද්‍යාව හා ජනාවාස",
    "ස්වාභාවික සම්පත්, බලශක්ති හා ජල සම්පත්",
    "ආර්ථික භූගෝල විද්‍යාව, කෘෂිකර්මය හා කර්මාන්ත",
    "ලෝක කලාපීය භූගෝල විද්‍යාව",
    "පාරිසරික ගැටලු හා ආපදා කළමනාකරණය"
  )

  private val domains: List<List<QSpec>> by lazy {
    val rawDomains = listOf(
      GeographyLiveExamMapsBank.mapQuestions(),
      GeographyLiveExamEarthTimeBank.earthAndTimeQuestions(),
      GeographyLiveExamClimateBank.climateQuestions(),
      GeographyLiveExamLandformsBank.landformQuestions(),
      GeographyLiveExamSriLankaGeoBank.sriLankaGeoQuestions(),
      GeographyLiveExamPopulationBank.populationAndSettlementQuestions(),
      GeographyLiveExamResourcesBank.naturalResourcesQuestions(),
      GeographyLiveExamEconomicBank.economicGeographyQuestions(),
      GeographyLiveExamWorldRegionsBank.worldRegionalQuestions(),
      GeographyLiveExamDisastersBank.environmentAndDisasterQuestions()
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
