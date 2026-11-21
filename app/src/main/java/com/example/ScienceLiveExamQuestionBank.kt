package com.example

import com.example.ExamQuestionHelper.QSpec

/**
 * Curated Science Live Exam Hall Question Bank Coordinator.
 *
 * Combines 10 distinct G.C.E. O/L Science syllabus domain banks (~1,890+ strictly unique
 * MCQs in Sinhala with concise topic-matched options and verified answers):
 *  0. ජීවයේ රසායනික පදනම, සෛලය හා වර්ගීකරණය
 *  1. ශාක ක්‍රියාකාරීත්වය, ප්‍රභාසංස්ලේෂණය හා පරිවහනය
 *  2. මානව දේහ ක්‍රියාවලි හා සෞඛ්‍යය
 *  3. ප්‍රවේණිය, ක්ෂුද්‍රජීවීන් හා පරිසර විද්‍යාව
 *  4. පරමාණුක ව්‍යුහය, ආවර්තිතා වගුව, බන්ධන හා ද්‍රාවණ
 *  5. මවුලය, රසායනික ප්‍රතික්‍රියා, අම්ල-භෂ්ම හා විද්‍යුත් රසායනය
 *  6. ලෝහ විද්‍යාව, හයිඩ්‍රොකාබන, බහුඅවයවික හා කාර්මික රසායනය
 *  7. යාන්ත්‍ර විද්‍යාව: මිනුම්, චලිතය, බලය, ශක්තිය හා ද්‍රවස්ථිතිය
 *  8. තරංග, ධ්වනිය, ප්‍රකාශ විද්‍යාව හා තාපය
 *  9. විද්‍යුතය, ගෘහස්ථ පරිපථ, චුම්භකත්වය හා ඉලෙක්ට්‍රොනික විද්‍යාව
 *
 * Within every 60-question paper (across all 30 papers per term, Terms 1..3, Grades 10 & 11):
 *  - Each paper covers all 10 Science domains evenly (6 questions per domain) with zero
 *    consecutive identical topics.
 *  - Every question across all 30 papers in a term (1,800 questions) is strictly unique
 *    with zero duplicates or repetitive templates.
 */
internal object ScienceLiveExamQuestionBank {

  private val domainTopics = listOf(
    "ජීවයේ රසායනික පදනම, සෛලය හා වර්ගීකරණය",
    "ශාක ක්‍රියාකාරීත්වය, ප්‍රභාසංස්ලේෂණය හා පරිවහනය",
    "මානව දේහ ක්‍රියාවලි හා සෞඛ්‍යය",
    "ප්‍රවේණිය, ක්ෂුද්‍රජීවීන් හා පරිසර විද්‍යාව",
    "පරමාණුක ව්‍යුහය, ආවර්තිතා වගුව, බන්ධන හා ද්‍රාවණ",
    "මවුලය, රසායනික ප්‍රතික්‍රියා, අම්ල-භෂ්ම හා විද්‍යුත් රසායනය",
    "ලෝහ විද්‍යාව, හයිඩ්‍රොකාබන, බහුඅවයවික හා කාර්මික රසායනය",
    "යාන්ත්‍ර විද්‍යාව: මිනුම්, චලිතය, බලය, ශක්තිය හා ද්‍රවස්ථිතිය",
    "තරංග, ධ්වනිය, ප්‍රකාශ විද්‍යාව හා තාපය",
    "විද්‍යුතය, ගෘහස්ථ පරිපථ, චුම්භකත්වය හා ඉලෙක්ට්‍රොනික විද්‍යාව"
  )

  private val domains: List<List<QSpec>> by lazy {
    val rawDomains = listOf(
      ScienceLiveExamBioCellsBank1.questions() + ScienceLiveExamBioCellsBank2.questions(),
      ScienceLiveExamBotanyBank1.questions() + ScienceLiveExamBotanyBank2.questions(),
      ScienceLiveExamHumanBioBank1.questions() + ScienceLiveExamHumanBioBank2.questions(),
      ScienceLiveExamGeneticsEcoBank1.questions() + ScienceLiveExamGeneticsEcoBank2.questions(),
      ScienceLiveExamChemAtomBank1.questions() + ScienceLiveExamChemAtomBank2.questions(),
      ScienceLiveExamChemReactBank1.questions() + ScienceLiveExamChemReactBank2.questions(),
      ScienceLiveExamChemOrgBank1.questions() + ScienceLiveExamChemOrgBank2.questions(),
      ScienceLiveExamPhysicsMechBank1.questions() + ScienceLiveExamPhysicsMechBank2.questions(),
      ScienceLiveExamPhysicsWaveBank1.questions() + ScienceLiveExamPhysicsWaveBank2.questions(),
      ScienceLiveExamPhysicsElecBank1.questions() + ScienceLiveExamPhysicsElecBank2.questions()
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
