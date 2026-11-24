package com.example

import com.example.ExamQuestionHelper.QSpec

/**
 * Curated Health and Physical Education (සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය) Live Exam Hall Question Bank Coordinator.
 *
 * Combines 10 distinct G.C.E. O/L (Grades 10–11) Health & Physical Education syllabus domain banks
 * (1,890+ strictly unique MCQs in Sinhala with concise topic-matched options and verified answers):
 *  0. පෞද්ගලික සෞඛ්‍යය, ඉරියව් හා ශරීර සංවර්ධනය
 *  1. පෝෂණය, සමබල ආහාරය හා පෝෂණ ඌනතා රෝග
 *  2. මානව දේහ පද්ධතිවල ව්‍යුහය හා ක්‍රියාකාරිත්වය
 *  3. ශාරීරික යෝග්‍යතාව, යෝග්‍යතා පරීක්ෂණ හා පුහුණු මූලධර්ම
 *  4. මලල ක්‍රීඩා ඉසව්, ශිල්පීය ක්‍රම හා නීති රීති
 *  5. කණ්ඩායම් ක්‍රීඩා, ජලජ ක්‍රීඩා හා තරගාවලි සංවිධානය
 *  6. ප්‍රථමාධාර, හදිසි අනතුරු හා ක්‍රීඩා ආබාධ කළමනාකරණය
 *  7. නව යොවුන් විය, ප්‍රජනක සෞඛ්‍යය හා ලිංගික සම්ප්‍රේෂණ ආසාදන
 *  8. මානසික සුවතාව, ජීවන නිපුණතා හා මත්ද්‍රව්‍ය නිවාරණය
 *  9. බෝවන හා බෝ නොවන රෝග, ප්‍රජා සෞඛ්‍යය හා හෙළ වෙදකම
 *
 * Within every 60-question paper (across all 30 papers per term, Terms 1..3, Grades 10 & 11):
 *  - Each paper covers all 10 Health & Physical Education domains evenly (6 questions per domain)
 *    with zero consecutive identical topics.
 *  - Every question across all 30 papers in a term (1,800 questions) is strictly unique
 *    with zero duplicates or repetitive templates.
 */
internal object HealthLiveExamQuestionBank {

  private val domainTopics = listOf(
    "පෞද්ගලික සෞඛ්‍යය, ඉරියව් හා ශරීර සංවර්ධනය",
    "පෝෂණය, සමබල ආහාරය හා පෝෂණ ඌනතා රෝග",
    "මානව දේහ පද්ධතිවල ව්‍යුහය හා ක්‍රියාකාරිත්වය",
    "ශාරීරික යෝග්‍යතාව, යෝග්‍යතා පරීක්ෂණ හා පුහුණු මූලධර්ම",
    "මලල ක්‍රීඩා ඉසව්, ශිල්පීය ක්‍රම හා නීති රීති",
    "කණ්ඩායම් ක්‍රීඩා, ජලජ ක්‍රීඩා හා තරගාවලි සංවිධානය",
    "ප්‍රථමාධාර, හදිසි අනතුරු හා ක්‍රීඩා ආබාධ කළමනාකරණය",
    "නව යොවුන් විය, ප්‍රජනක සෞඛ්‍යය හා ලිංගික සම්ප්‍රේෂණ ආසාදන",
    "මානසික සුවතාව, ජීවන නිපුණතා හා මත්ද්‍රව්‍ය නිවාරණය",
    "බෝවන හා බෝ නොවන රෝග, ප්‍රජා සෞඛ්‍යය හා හෙළ වෙදකම"
  )

  private val domains: List<List<QSpec>> by lazy {
    val rawDomains = listOf(
      HealthLiveExamPersonalHealthBank1.questions() + HealthLiveExamPersonalHealthBank2.questions(),
      HealthLiveExamNutritionBank1.questions() + HealthLiveExamNutritionBank2.questions(),
      HealthLiveExamHumanBodyBank1.questions() + HealthLiveExamHumanBodyBank2.questions(),
      HealthLiveExamFitnessBank1.questions() + HealthLiveExamFitnessBank2.questions(),
      HealthLiveExamAthleticsBank1.questions() + HealthLiveExamAthleticsBank2.questions(),
      HealthLiveExamTeamSportsBank1.questions() + HealthLiveExamTeamSportsBank2.questions(),
      HealthLiveExamFirstAidBank1.questions() + HealthLiveExamFirstAidBank2.questions(),
      HealthLiveExamReproductiveBank1.questions() + HealthLiveExamReproductiveBank2.questions(),
      HealthLiveExamMentalSkillsBank1.questions() + HealthLiveExamMentalSkillsBank2.questions(),
      HealthLiveExamDiseaseAyurvedaBank1.questions() + HealthLiveExamDiseaseAyurvedaBank2.questions()
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
