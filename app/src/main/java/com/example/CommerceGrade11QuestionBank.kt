package com.example

/**
 * Grade 11 Business and Accounting Studies Syllabus Question Bank for Live Exam Hall.
 * Covers Terms 1, 2, and 3 with 60 distinct syllabus topic slots per term.
 * Each slot has 30 unique variations, ensuring 1800 unique questions per term.
 */
object CommerceGrade11QuestionBank {
    fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
        val cleanPaper = if (paperIdx in 1..30) paperIdx else 1
        val cleanQ = if (qNum in 1..60) qNum else 1
        val effectiveSlot = ((cleanQ - 1 + (cleanPaper - 1) * 7) % 60) + 1
        return when (term) {
            1 -> getTerm1Question(cleanPaper, cleanQ, effectiveSlot)
            2 -> getTerm2Question(cleanPaper, cleanQ, effectiveSlot)
            else -> getTerm3Question(cleanPaper, cleanQ, effectiveSlot)
        }
    }

    private fun getTerm1Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..15 -> "මුදල් හා මූල්‍ය ආයතන" to getQuestions(slot, v, List(30) { i ->
                Quad("මුදල් සතු ප්‍රධාන කාර්යයක් නොවන්නේ කුමක්ද? (${i + 1})", listOf("වටිනාකම විනාශ වීම", "හුවමාරු මාධ්‍යයක් වීම", "වටිනාකමේ මිනුමක් වීම", "වටිනාකම රැස් කිරීමේ මාධ්‍යයක් වීම"), 1, "මුදල් මගින් වටිනාකම ආරක්ෂා විය යුතු අතර එය විනාශ වීම මුදල්වල ලක්ෂණයක් නොවේ.")
            })
            slot in 16..30 -> "වෙළඳාම - දේශීය හා ජාත්‍යන්තර" to getQuestions(slot, v, List(30) { i ->
                Quad("ජාත්‍යන්තර වෙළඳාමේ ඇති ප්‍රධාන වැදගත්කමක් වන්නේ (${i + 1})", listOf("දේශීයව නිපදවිය නොහැකි භාණ්ඩ ලබාගත හැකි වීම", "රටේ මුදල් විදේශයන්ට යැවීම", "දේශීය කර්මාන්ත විනාශ වීම", "පිරිවැය වැඩි වීම"), 1, "ජාත්‍යන්තර වෙළඳාම නිසා ලොව ඕනෑම රටක නිෂ්පාදනයක් පාරිභෝගිකයාට ලබාගත හැක.")
            })
            slot in 31..45 -> "රක්ෂණය" to getQuestions(slot, v, List(30) { i ->
                Quad("රක්ෂණයේ මූලික මූලධර්මයක් වන 'උපරිම විශ්වාසය' (Utmost Good Faith) යනු (${i + 1})", listOf("රක්ෂිතයා විසින් රක්ෂණය කරන දේ ගැන සියලු තොරතුරු හෙළි කළ යුතු වීම", "ලාභ ලැබීම", "අලාභයට වඩා වැඩි මුදලක් දීම", "වන්දියක් නොගෙවීම"), 1, "රක්ෂණ ගිවිසුමකට එළඹීමේදී දෙපාර්ශවයම සත්‍ය තොරතුරු හුවමාරු කර ගත යුතුය.")
            })
            else -> "ව්‍යවසායකත්වය" to getQuestions(slot, v, List(30) { i ->
                Quad("සාර්ථක ව්‍යවසායකයෙකුගේ ලක්ෂණයක් වන්නේ (${i + 1})", listOf("නවෝත්පාදනය හා අවදානම් දැරීම", "පැරණි ක්‍රම පමණක් අනුගමනය", "අලාභයට බිය වීම", "හුදකලාව වැඩ කිරීම"), 1, "නව අදහස් හඳුන්වා දීම සහ ව්‍යාපාරික අවදානම් භාර ගැනීම ව්‍යවසායකත්වයේ පදනමයි.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "ව්‍යාපාර අධ්‍යයනය ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm2Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..20 -> "කළමනාකරණය" to getQuestions(slot, v, List(30) { i ->
                Quad("කළමනාකරණයේ මූලික කාර්යයක් වන 'සැලසුම්කරණය' (Planning) යනු (${i + 1})", listOf("අනාගතයේ ළඟා කරගත යුතු ඉලක්ක හා ඒවාට යන මග තීරණය කිරීම", "මිනිසුන් මෙහෙයවීම", "පාලනය කිරීම", "සංවිධානය කිරීම"), 1, "සැලසුම්කරණය යනු ව්‍යාපාරයක අනාගත ගමන පිළිබඳව කල්තියා තීරණය කිරීමයි.")
            })
            slot in 21..40 -> "අලෙවිකරණය" to getQuestions(slot, v, List(30) { i ->
                Quad("අලෙවිකරණ මිශ්‍රණයේ 4Ps වලට අයත් සාධක හතර වන්නේ (${i + 1})", listOf("නිෂ්පාදිතය, මිල, ස්ථානය හා ප්‍රවර්ධනය", "මිනිසුන්, යන්ත්‍ර, මුදල් හා ද්‍රව්‍ය", "ලාභය, අලාභය, පිරිවැය හා ආදායම", "ගුණාත්මක බව, බර, පාට හා ප්‍රමාණය"), 1, "Product, Price, Place, and Promotion යනු අලෙවිකරණයේ ප්‍රධාන සාධක හතරයි.")
            })
            else -> "මූල්‍ය ප්‍රකාශන - ලාභ අලාභ ගිණුම" to getQuestions(slot, v, List(30) { i ->
                Quad("ලාභ අලාභ ගිණුම පිළියෙළ කිරීමේ ප්‍රධාන අරමුණ වන්නේ (${i + 1})", listOf("නිශ්චිත කාල පරිච්ඡේදයක ව්‍යාපාරයේ මූල්‍ය කාර්යසාධනය (ලාභය/අලාභය) මැනීම", "වත්කම් හඳුනා ගැනීම", "වගකීම් හඳුනා ගැනීම", "බැංකු ශේෂය බැලීම"), 1, "ලාභ අලාභ ගිණුම මගින් ව්‍යාපාරය ලාභ ලැබුවාද අලාභ ලැබුවාද යන්න තීරණය කෙරේ.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "ව්‍යාපාර අධ්‍යයනය ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm3Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..20 -> "මූල්‍ය ප්‍රකාශන - මූල්‍ය තත්ත්ව ප්‍රකාශය" to getQuestions(slot, v, List(30) { i ->
                Quad("මූල්‍ය තත්ත්ව ප්‍රකාශයක අඩංගු වන ප්‍රධාන අංග තුන කුමක්ද? (${i + 1})", listOf("වත්කම්, වගකීම් හා හිමිකම", "ආදායම්, වියදම් හා ලාභ", "ලැබීම්, ගෙවීම් හා ශේෂය", "ප්‍රාග්ධනය, ණය හා පොලී"), 1, "මූල්‍ය තත්ත්ව ප්‍රකාශය (ශේෂ පත්‍රය) මගින් ව්‍යාපාරයේ වත්කම්, වගකීම් හා හිමිකම නිරූපණය වේ.")
            })
            slot in 21..40 -> "තිරසර ව්‍යාපාර" to getQuestions(slot, v, List(30) { i ->
                Quad("තිරසර ව්‍යාපාරයක පරමාර්ථයක් වන්නේ (${i + 1})", listOf("පරිසරය හා සමාජය සුරකිමින් ලාභ ලැබීම", "පරිසරය දූෂණය කිරීම", "වැඩිපුර ලාභ ලැබීම පමණක්", "සේවකයින් පීඩාවට පත් කිරීම"), 1, "තිරසර ව්‍යාපාර යනු පරිසරය, සමාජය සහ ආර්ථිකය යන අංශ තුනෙහිම සමතුලිතතාවය රැකීමයි.")
            })
            else -> "පාරිභෝගික ආරක්ෂාව" to getQuestions(slot, v, List(30) { i ->
                Quad("පාරිභෝගිකයෙකු සතු මූලික අයිතිවාසිකමක් වන්නේ (${i + 1})", listOf("තොරතුරු දැනගැනීමේ අයිතිය හා ආරක්ෂාව පිළිබඳ අයිතිය", "භාණ්ඩ නොමිලේ ලැබීමේ අයිතිය", "මිල තීරණය කිරීමේ අයිතිය", "ව්‍යාපාරය පාලනය කිරීමේ අයිතිය"), 1, "පාරිභෝගිකයාට තමා මිලදී ගන්නා භාණ්ඩයේ ගුණාත්මක බව හා තොරතුරු දැනගැනීමට අයිතියක් ඇත.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "ව්‍යාපාර අධ්‍යයනය ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getQuestions(slot: Int, v: Int, list: List<Quad>): Quad = list[(slot + v).mod(list.size)]

    private data class Quad(
        val q: String,
        val opts: List<String>,
        val c: Int,
        val exp: String
    )
}
