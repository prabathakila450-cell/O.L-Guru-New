package com.example

import com.example.ExamQuestionHelper.QSpec

/**
 * Curated Music (සංගීතය) Live Exam Hall Question Bank Coordinator.
 *
 * Combines 10 distinct G.C.E. O/L (Grades 10–11) Oriental Music syllabus domain banks
 * (1,900+ strictly unique MCQs in Sinhala with concise topic-matched options and verified answers):
 *  0. නාදය, ශ්‍රැති, ස්වර හා සප්තක පද්ධතිය
 *  1. ථාට දහය හා රාග න්‍යාය මූලධර්ම
 *  2. 10 ශ්‍රේණියේ රාග — භූපාලි, බිලාවල්, කාෆි, ඛමාජ්
 *  3. 11 ශ්‍රේණියේ රාග — යමන්, භෛරව්, අසාවරී, බාගේශ්‍රී
 *  4. තාල පද්ධතිය, මාත්‍රා, ලයකාරී හා ස්වරලිපි
 *  5. ශ්‍රී ලාංකේය ජන සංගීතය හා ජන ගී
 *  6. නූර්ති, නාඩගම් සහ සිංහල නාට්‍ය සංගීතය
 *  7. පෙරදිග, දේශීය හා ලෝක වාද්‍ය භාණ්ඩ වර්ගීකරණය
 *  8. ශ්‍රී ලාංකේය හා භාරතීය සංගීතවේදීන් හා සංගීත ඉතිහාසය
 *  9. ගායන ශිල්පය, ශ්‍රව්‍ය විද්‍යාව, ප්‍රායෝගික පරීක්ෂණ හා සෞන්දර්ය රසය
 *
 * Within every 60-question paper (across all 30 papers per term, Terms 1..3, Grades 10 & 11):
 *  - Each paper covers all 10 Music syllabus domains evenly (6 questions per domain)
 *    with zero consecutive identical topics.
 *  - Every question across all 30 papers in a term (1,800 questions) is strictly unique
 *    with zero duplicates or repetitive templates.
 */
internal object MusicLiveExamQuestionBank {

  private val domainTopics = listOf(
    "නාදය, ශ්‍රැති, ස්වර හා සප්තක පද්ධතිය",
    "ථාට දහය හා රාග න්‍යාය මූලධර්ම",
    "10 ශ්‍රේණියේ රාග — භූපාලි, බිලාවල්, කාෆි, ඛමාජ්",
    "11 ශ්‍රේණියේ රාග — යමන්, භෛරව්, අසාවරී, බාගේශ්‍රී",
    "තාල පද්ධතිය, මාත්‍රා, ලයකාරී හා ස්වරලිපි",
    "ශ්‍රී ලාංකේය ජන සංගීතය හා ජන ගී",
    "නූර්ති, නාඩගම් සහ සිංහල නාට්‍ය සංගීතය",
    "පෙරදිග, දේශීය හා ලෝක වාද්‍ය භාණ්ඩ වර්ගීකරණය",
    "ශ්‍රී ලාංකේය හා භාරතීය සංගීතවේදීන් හා සංගීත ඉතිහාසය",
    "ගායන ශිල්පය, ශ්‍රව්‍ය විද්‍යාව, ප්‍රායෝගික පරීක්ෂණ හා සෞන්දර්ය රසය"
  )

  private val domains: List<List<QSpec>> by lazy {
    val rawDomains = listOf(
      MusicLiveExamSwaraNadaBank1.questions() + MusicLiveExamSwaraNadaBank2.questions(),
      MusicLiveExamThaatTheoryBank1.questions() + MusicLiveExamThaatTheoryBank2.questions(),
      MusicLiveExamRagaG10Bank1.questions() + MusicLiveExamRagaG10Bank2.questions(),
      MusicLiveExamRagaG11Bank1.questions() + MusicLiveExamRagaG11Bank2.questions(),
      MusicLiveExamThalaLayaBank1.questions() + MusicLiveExamThalaLayaBank2.questions(),
      MusicLiveExamFolkSongsBank1.questions() + MusicLiveExamFolkSongsBank2.questions(),
      MusicLiveExamTheatreDramaBank1.questions() + MusicLiveExamTheatreDramaBank2.questions(),
      MusicLiveExamInstrumentsBank1.questions() + MusicLiveExamInstrumentsBank2.questions(),
      MusicLiveExamHistoryMusiciansBank1.questions() + MusicLiveExamHistoryMusiciansBank2.questions(),
      MusicLiveExamAppliedPracticalBank1.questions() + MusicLiveExamAppliedPracticalBank2.questions()
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
