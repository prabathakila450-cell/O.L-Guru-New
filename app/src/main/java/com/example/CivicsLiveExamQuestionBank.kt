package com.example

import com.example.ExamQuestionHelper.QSpec

/**
 * Curated Citizenship Education (පුරවැසි අධ්‍යාපනය) Live Exam Hall Question Bank Coordinator.
 *
 * Combines 10 distinct G.C.E. O/L (Grades 10–11) Citizenship Education syllabus domain banks
 * (1,965 strictly unique MCQs in Sinhala with concise topic-matched options and verified answers):
 *  0. ප්‍රජාතන්ත්‍රවාදය, පුරවැසිභාවය හා ආණ්ඩු ක්‍රම
 *  1. ශ්‍රී ලංකාවේ ආණ්ඩුක්‍රම ව්‍යවස්ථා පරිණාමය
 *  2. ව්‍යවස්ථාදායකය, විධායකය හා අධිකරණ ව්‍යුහය
 *  3. මැතිවරණ ක්‍රම, ඡන්ද බලය හා දේශපාලන පක්ෂ
 *  4. මානව හිමිකම්, මූලික අයිතිවාසිකම් හා පුරවැසි යුතුකම්
 *  5. විමධ්‍යගත පාලනය, පළාත් සභා හා පළාත් පාලන ආයතන
 *  6. යහපාලනය, නීතියේ ආධිපත්‍යය, RTI හා ගැටුම් නිරාකරණය
 *  7. ආර්ථික ක්‍රම, සුබසාධනය, බහුසංස්කෘතික සමාජය හා තිරසාර සංවර්ධනය
 *  8. ජනමාධ්‍ය, මහජන මතය, වැඩ ලෝකය හා සිවිල් සමාජය
 *  9. විදේශ ප්‍රතිපත්තිය, ජාත්‍යන්තර සංවිධාන හා මානුෂීය නීතිය
 *
 * Within every 60-question paper (across all 30 papers per term, Terms 1..3, Grades 10 & 11):
 *  - Each paper covers all 10 Civics domains evenly (6 questions per domain) with zero
 *    consecutive identical topics.
 *  - Every question across all 30 papers in a term (1,800 questions) is strictly unique
 *    with zero duplicates or repetitive templates.
 */
internal object CivicsLiveExamQuestionBank {

  private val domainTopics = listOf(
    "ප්‍රජාතන්ත්‍රවාදය, පුරවැසිභාවය හා ආණ්ඩු ක්‍රම",
    "ශ්‍රී ලංකාවේ ආණ්ඩුක්‍රම ව්‍යවස්ථා පරිණාමය",
    "ව්‍යවස්ථාදායකය, විධායකය හා අධිකරණ ව්‍යුහය",
    "මැතිවරණ ක්‍රම, ඡන්ද බලය හා දේශපාලන පක්ෂ",
    "මානව හිමිකම්, මූලික අයිතිවාසිකම් හා පුරවැසි යුතුකම්",
    "විමධ්‍යගත පාලනය, පළාත් සභා හා පළාත් පාලන ආයතන",
    "යහපාලනය, නීතියේ ආධිපත්‍යය, RTI හා ගැටුම් නිරාකරණය",
    "ආර්ථික ක්‍රම, සුබසාධනය, බහුසංස්කෘතික සමාජය හා තිරසාර සංවර්ධනය",
    "ජනමාධ්‍ය, මහජන මතය, වැඩ ලෝකය හා සිවිල් සමාජය",
    "විදේශ ප්‍රතිපත්තිය, ජාත්‍යන්තර සංවිධාන හා මානුෂීය නීතිය"
  )

  private val domains: List<List<QSpec>> by lazy {
    val rawDomains = listOf(
      CivicsLiveExamDemocracyBank1.questions() + CivicsLiveExamDemocracyBank2.questions(),
      CivicsLiveExamConstHistBank1.questions() + CivicsLiveExamConstHistBank2.questions(),
      CivicsLiveExamStateOrgBank1.questions() + CivicsLiveExamStateOrgBank2.questions(),
      CivicsLiveExamElectionsBank1.questions() + CivicsLiveExamElectionsBank2.questions(),
      CivicsLiveExamRightsBank1.questions() + CivicsLiveExamRightsBank2.questions(),
      CivicsLiveExamLocalGovBank1.questions() + CivicsLiveExamLocalGovBank2.questions(),
      CivicsLiveExamGovernanceBank1.questions() + CivicsLiveExamGovernanceBank2.questions(),
      CivicsLiveExamEconomyDevBank1.questions() + CivicsLiveExamEconomyDevBank2.questions(),
      CivicsLiveExamMediaCivilBank1.questions() + CivicsLiveExamMediaCivilBank2.questions(),
      CivicsLiveExamGlobalBank1.questions() + CivicsLiveExamGlobalBank2.questions()
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
