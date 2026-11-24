package com.example

import com.example.ExamQuestionHelper.QSpec

/**
 * Curated Sinhala-medium Art (චිත්‍ර කලාව) Live Exam Hall Question Bank Coordinator
 * (G.C.E. O/L Grades 10 & 11).
 *
 * Combines 10 distinct O/L Art syllabus domain banks (>= 180 strictly unique MCQs per domain,
 * ~1,800+ unique questions per term across all 30 papers):
 *  0. Prehistoric & Indigenous Vedda Cave Art (ලෝක හා දේශීය ප්‍රාග් ඓතිහාසික කලාව)
 *  1. Anuradhapura Period Murals (අනුරාධපුර යුගයේ සිතුවම් හා සීගිරි බිතුසිතුවම්)
 *  2. Anuradhapura Period Sculptures & Carvings (අනුරාධපුර යුගයේ මූර්ති හා ශිලා කැටයම්)
 *  3. Polonnaruwa Period Art & Architecture (පොළොන්නරු යුගයේ සිතුවම්, මූර්ති හා වාස්තු කලාව)
 *  4. Kandy Period Murals, Designs & Wood Carvings (මහනුවර යුගයේ සිතුවම්, දේශීය ශෛලිය හා වාස්තු කැටයම්)
 *  5. Asian Art Heritage (පෙරදිග ආසියාතික කලාව - ඉන්දියාව, චීනය, ජපානය)
 *  6. Western Classical Art (බටහිර සම්භාව්‍ය කලාව - මිසර, ග්‍රීක, රෝම, පුනරුද, බැරොක්)
 *  7. Modern Western Art & Sri Lankan '43 Group (නූතන බටහිර කලාව හා ශ්‍රී ලංකාවේ '43 කණ්ඩායම)
 *  8. Elements of Art, Principles of Design & Color Theory (චිත්‍ර කලා මූලිකාංග, නිර්මාණ මූලධර්ම හා වර්ණ න්‍යාය)
 *  9. Perspective, Anatomy, Practical Media & Art Criticism (දෘෂ්ටිකෝණ, මානව ව්‍යුහය, ප්‍රායෝගික මාධ්‍ය හා විචාරය)
 */
internal object ArtLiveExamQuestionBank {

    private val domainTopics = listOf(
        "ලෝක හා දේශීය ප්‍රාග් ඓතිහාසික කලාව",
        "අනුරාධපුර යුගයේ සිතුවම් හා සීගිරි බිතුසිතුවම්",
        "අනුරාධපුර යුගයේ මූර්ති හා ශිලා කැටයම්",
        "පොළොන්නරු යුගයේ සිතුවම්, මූර්ති හා වාස්තු කලාව",
        "මහනුවර යුගයේ සිතුවම්, දේශීය ශෛලිය හා වාස්තු කැටයම්",
        "පෙරදිග ආසියාතික කලාව (ඉන්දියාව, චීනය, ජපානය)",
        "බටහිර සම්භාව්‍ය කලාව (මිසර, ග්‍රීක, රෝම, පුනරුද, බැරොක්)",
        "නූතන බටහිර කලාව හා ශ්‍රී ලංකාවේ '43 කණ්ඩායම",
        "චිත්‍ර කලා මූලිකාංග, නිර්මාණ මූලධර්ම හා වර්ණ න්‍යාය",
        "දෘෂ්ටිකෝණ, මානව ව්‍යුහය, ප්‍රායෝගික මාධ්‍ය හා විචාරය"
    )

    private val domains: List<List<QSpec>> by lazy {
        val rawDomains = listOf(
            ArtLiveExamPrehistoricBank1.questions() + ArtLiveExamPrehistoricBank2.questions(),
            ArtLiveExamAnuradhapuraMuralBank1.questions() + ArtLiveExamAnuradhapuraMuralBank2.questions(),
            ArtLiveExamAnuradhapuraSculptureBank1.questions() + ArtLiveExamAnuradhapuraSculptureBank2.questions() + ArtLiveExamAnuradhapuraSculptureBank3.questions(),
            ArtLiveExamPolonnaruwaBank1.questions() + ArtLiveExamPolonnaruwaBank2.questions() + ArtLiveExamPolonnaruwaBank3.questions(),
            ArtLiveExamKandyTradBank1.questions() + ArtLiveExamKandyTradBank2.questions() + ArtLiveExamKandyTradBank3.questions(),
            ArtLiveExamAsianArtBank1.questions() + ArtLiveExamAsianArtBank2.questions() + ArtLiveExamAsianArtBank3.questions(),
            ArtLiveExamWesternClassicBank1.questions() + ArtLiveExamWesternClassicBank2.questions() + ArtLiveExamWesternClassicBank3.questions() + ArtLiveExamWesternClassicBank4.questions(),
            ArtLiveExamModern43GroupBank1.questions() + ArtLiveExamModern43GroupBank2.questions() + ArtLiveExamModern43GroupBank3.questions() + ArtLiveExamModern43GroupBank4.questions(),
            ArtLiveExamTheoryColorBank1.questions() + ArtLiveExamTheoryColorBank2.questions() + ArtLiveExamTheoryColorBank3.questions() + ArtLiveExamTheoryColorBank4.questions(),
            ArtLiveExamPracticalCritBank1.questions() + ArtLiveExamPracticalCritBank2.questions() + ArtLiveExamPracticalCritBank3.questions() + ArtLiveExamPracticalCritBank4.questions()
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

    private val slotPermutations = arrayOf(
        intArrayOf(0, 1, 2, 3), intArrayOf(0, 1, 3, 2), intArrayOf(0, 2, 1, 3), intArrayOf(0, 2, 3, 1),
        intArrayOf(0, 3, 1, 2), intArrayOf(0, 3, 2, 1), intArrayOf(1, 0, 2, 3), intArrayOf(1, 0, 3, 2),
        intArrayOf(1, 2, 0, 3), intArrayOf(1, 2, 3, 0), intArrayOf(1, 3, 0, 2), intArrayOf(1, 3, 2, 0),
        intArrayOf(2, 0, 1, 3), intArrayOf(2, 0, 3, 1), intArrayOf(2, 1, 0, 3), intArrayOf(2, 1, 3, 0),
        intArrayOf(2, 3, 0, 1), intArrayOf(2, 3, 1, 0), intArrayOf(3, 0, 1, 2), intArrayOf(3, 0, 2, 1),
        intArrayOf(3, 1, 0, 2), intArrayOf(3, 1, 2, 0), intArrayOf(3, 2, 0, 1), intArrayOf(3, 2, 1, 0)
    )

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
        val group = qIdx / 4
        val perm = slotPermutations[(gIdx * 37 + tIdx * 19 + pIdx * 13 + group * 7) % slotPermutations.size]
        val desiredSlot = perm[qIdx % 4]

        val baseSeed = gIdx * 100_000 + term * 10_000 + paperIdx * 137 + qNum * 17 + slot * 29
        var seed = baseSeed
        val correctHash = spec.correct.hashCode()
        for (delta in 0..7) {
            val cand = baseSeed + delta
            if (kotlin.math.abs(cand * 7 + qNum * 13 + correctHash) % 4 == desiredSlot) {
                seed = cand
                break
            }
        }
        return ExamQuestionHelper.fromSpec(
            id = qNum,
            spec = spec,
            seed = seed
        )
    }
}
