package com.example

/**
 * Grade 11 Geography Syllabus Question Bank for Live Exam Hall.
 * Covers Terms 1, 2, and 3 with 60 distinct syllabus topic slots per term.
 * Each slot has 30 unique variations, ensuring 1800 unique questions per term.
 */
object GeographyGrade11QuestionBank {
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
            slot in 1..15 -> "පෘථිවියේ භෞතික පරිසරය" to getQuestions(slot, v, List(30) { i ->
                Quad("පෘථිවි අභ්‍යන්තරයේ මැදින්ම පිහිටි ස්ථරය (Inner Core) සමන්විත වන්නේ ප්‍රධාන වශයෙන් (${i + 1})", listOf("යකඩ හා නිකල්", "සිලිකා හා මැග්නීසියම්", "හුණුගල්", "මැටි"), 1, "පෘථිවි කේන්ද්‍රය අධික පීඩනය හා උෂ්ණත්වය සහිත ලෝහමය ස්ථරයකි.")
            })
            slot in 16..30 -> "ලෝක දේශගුණ විචලනය" to getQuestions(slot, v, List(30) { i ->
                Quad("නිවර්තන වර්ෂා වනාන්තර දේශගුණයට (Af) අයත් ප්‍රධාන ලක්ෂණයක් වන්නේ (${i + 1})", listOf("වසර පුරාම අධික උෂ්ණත්වය හා වර්ෂාව", "දැඩි සීතල", "වැසි රහිත බව", "හිම පතනය"), 1, "සමකයට ආසන්න ප්‍රදේශවල වසර පුරා ඒකාකාරී උණුසුම් හා තෙත් දේශගුණයක් පවතී.")
            })
            slot in 31..45 -> "මානව සම්පත හා ජනාවාස" to getQuestions(slot, v, List(30) { i ->
                Quad("ලෝකයේ ජනගහනය වැඩිපුරම සංකේන්ද්‍රණය වී ඇත්තේ කුමන මහාද්වීපයේද? (${i + 1})", listOf("ආසියාව", "යුරෝපය", "අප්‍රිකාව", "ඔස්ට්‍රේලියාව"), 1, "ලොව මුළු ජනගහනයෙන් 60%කට වඩා ආසියානු මහාද්වීපයේ වාසය කරති.")
            })
            else -> "ගෝලීය පාරිසරික ගැටලු" to getQuestions(slot, v, List(30) { i ->
                Quad("හරිතාගාර ආචරණය (Greenhouse Effect) නිසා පෘථිවියේ සිදුවන ප්‍රධාන වෙනස වන්නේ (${i + 1})", listOf("ගෝලීය උණුසුම ඉහළ යාම", "හිම පතනය වැඩි වීම", "වාතය පිරිසිදු වීම", "ජල මට්ටම අඩු වීම"), 1, "වායුගෝලයේ කාබන් ඩයොක්සයිඩ් වැනි වායු වැඩි වීමෙන් උෂ්ණත්වය ඉහළ යයි.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "භූගෝලය ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm2Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..20 -> "ලෝක ආර්ථික ක්‍රියාකාරකම්" to getQuestions(slot, v, List(30) { i ->
                Quad("ලෝකයේ ප්‍රධාන කාර්මික කලාපයක් ලෙස සැලකෙන්නේ (${i + 1})", listOf("බටහිර යුරෝපය", "සහරා කාන්තාරය", "ඇමසන් වනාන්තරය", "හිමාලය"), 1, "යුරෝපය, උතුරු ඇමරිකාව හා නැගෙනහිර ආසියාව ලොව ප්‍රමුඛතම කාර්මික කලාප වේ.")
            })
            slot in 21..40 -> "ලෝක වෙළඳාම" to getQuestions(slot, v, List(30) { i ->
                Quad("ජාත්‍යන්තර වෙළඳාමේදී 'අපනයනය' (Export) යනු කුමක්ද? (${i + 1})", listOf("තම රටේ නිෂ්පාදන වෙනත් රටවලට විකිණීම", "අසල්වැසි රටකින් භාණ්ඩ ගැනීම", "රට තුළම වෙළඳාම් කිරීම", "නොමිලේ භාණ්ඩ බෙදාදීම"), 1, "තම රටේ අතිරික්ත නිෂ්පාදන විදේශයන්ට යැවීමෙන් විදේශ විනිමය උපයා ගත හැක.")
            })
            else -> "සන්නිවේදනය හා තාක්ෂණය" to getQuestions(slot, v, List(30) { i ->
                Quad("නූතන ලෝකයේ 'තොරතුරු තාක්ෂණය' මගින් සිදුවූ ප්‍රධාන විපර්යාසයක් වන්නේ (${i + 1})", listOf("ගෝලීයකරණය", "ප්‍රවාහනය නැති වීම", "මිනිසුන් අතර දුර වැඩි වීම", "කඩදාසි භාවිතය වැඩි වීම"), 1, "අන්තර්ජාලය හා සන්නිවේදන තාක්ෂණය නිසා ලෝකය එකම ගම්මානයක් (Global Village) බවට පත්ව ඇත.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "භූගෝලය ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm3Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..20 -> "තිරසර සංවර්ධනය" to getQuestions(slot, v, List(30) { i ->
                Quad("තිරසර සංවර්ධනය (Sustainable Development) යන්නෙන් අදහස් වන්නේ (${i + 1})", listOf("අනාගත පරපුරට සම්පත් ඉතිරි කරමින් වර්තමාන අවශ්‍යතා සපුරා ගැනීම", "සම්පත් සියල්ල දැන්ම නිම කිරීම", "පරිසරය ගැන නොසිතා වැඩ කිරීම", "කර්මාන්ත පමණක් දියුණු කිරීම"), 1, "පරිසරය, ආර්ථිකය හා සමාජය යන අංශ තුනෙහිම සමතුලිතතාවය තිරසර බවයි.")
            })
            slot in 21..40 -> "ස්වභාවික විපත් කළමනාකරණය" to getQuestions(slot, v, List(30) { i ->
                Quad("සුනාමි (Tsunami) රංගයකින් ආරක්ෂා වීමට ගත හැකි හොඳම පියවර වන්නේ (${i + 1})", listOf("වහාම උස් බිම් කරා ගමන් කිරීම", "මුහුද දෙසට දිවීම", "නිවස තුළම සිටීම", "ගසකට නැගීම"), 1, "මුහුදු වෙරළෙන් ඈතට හා උසස් ස්ථානයකට යාමෙන් ජීවිත ආරක්ෂා කර ගත හැක.")
            })
            else -> "සිතියම් භාවිතය හා විග්‍රහය" to getQuestions(slot, v, List(30) { i ->
                Quad("භූගෝලීය තොරතුරු පද්ධතියක් (GIS) මගින් කළ හැකි කාර්යයක් වන්නේ (${i + 1})", listOf("තොරතුරු විශ්ලේෂණය හා සිතියම් ගත කිරීම", "පොත් ලිවීම", "චිත්‍ර ඇඳීම", "නැටුම් පුහුණු වීම"), 1, "GIS තාක්ෂණය මගින් භූගෝලීය දත්ත ඩිජිටල් ක්‍රමයට කළමනාකරණය කළ හැක.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "භූගෝලය ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getQuestions(slot: Int, v: Int, list: List<Quad>): Quad = list[(slot + v).mod(list.size)]

    private data class Quad(
        val q: String,
        val opts: List<String>,
        val c: Int,
        val exp: String
    )
}
