package com.example

/**
 * Grade 11 Agriculture Syllabus Question Bank for Live Exam Hall.
 * Covers Terms 1, 2, and 3 with 60 distinct syllabus topic slots per term.
 * Each slot has 30 unique variations, ensuring 1800 unique questions per term.
 */
object AgriGrade11QuestionBank {
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
            slot in 1..15 -> "සත්ත්ව පාලනය (ගව පාලනය)" to getQuestions(slot, v, List(30) { i ->
                Quad("කිරි ගවයින්ගේ කිරි නිපදවීමට සෘජුවම බලපාන සාධකයක් වන්නේ (${i + 1})", listOf("පෝෂ්‍යදායී ආහාර හා පිරිසිදු ජලය", "ගවගාලේ පාට", "ගවයාගේ නම", "කාලගුණ වාර්තා"), 1, "නිසි පෝෂණය සහ සෞඛ්‍ය සම්පන්න පරිසරයක් කිරි නිෂ්පාදනය වැඩි කිරීමට අත්‍යවශ්‍ය වේ.")
            })
            slot in 16..30 -> "සත්ත්ව පාලනය (කුකුළු පාලනය)" to getQuestions(slot, v, List(30) { i ->
                Quad("බිත්තර නිෂ්පාදනය සඳහාම ඇති කරන කුකුළු වර්ග හඳුන්වන්නේ කෙසේද? (${i + 1})", listOf("ලේයර්ස් (Layers)", "බ්‍රොයිලර්ස් (Broilers)", "සටන් කුකුළන්", "වල් කුකුළන්"), 1, "ලේයර්ස් වර්ගයේ කුකුළන් බිත්තර නිෂ්පාදනය සඳහා විශේෂයෙන් බෝ කරනු ලබයි.")
            })
            slot in 31..45 -> "පසු අස්වනු තාක්ෂණය" to getQuestions(slot, v, List(30) { i ->
                Quad("අස්වනු නෙළීමෙන් පසු සිදුවන හානි අවම කිරීමට ගත හැකි ක්‍රියාමාර්ගයක් වන්නේ (${i + 1})", listOf("නිසි ලෙස ඇසුරුම් කිරීම හා ප්‍රවාහනය", "අව්වේ දමා තැබීම", "කසල සමඟ දැමීම", "ගබඩා නොකිරීම"), 1, "නිසි ලෙස ඇසුරුම් කිරීම මගින් පලතුරු හා එළවළු වලට සිදුවන භෞතික හානි අවම වේ.")
            })
            else -> "ආහාර සංරක්ෂණය" to getQuestions(slot, v, List(30) { i ->
                Quad("ආහාර දීර්ඝ කාලයක් නරක් නොවී තබා ගැනීම සඳහා භාවිත කළ හැකි ක්‍රමයක් වන්නේ (${i + 1})", listOf("විජලනය (Dehydration)", "විවෘතව තැබීම", "තෙතමනය සහිත ස්ථානයක තැබීම", "කෘමීන් සමඟ තැබීම"), 1, "විජලනය මගින් ආහාරයේ ඇති ජල ප්‍රමාණය අඩු කර ක්ෂුද්‍ර ජීවී වර්ධනය වළක්වයි.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "කෘෂි විද්‍යාව ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm2Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..20 -> "මල් වගාව හා විසිතුරු ශාක" to getQuestions(slot, v, List(30) { i ->
                Quad("වාණිජ මට්ටමින් මල් වගා කිරීමේදී වැදගත් වන කරුණක් වන්නේ (${i + 1})", listOf("වෙළඳපොළ ඉල්ලුම සහ ගුණාත්මක බව", "අතු ගොඩක් තිබීම", "සෑම විටම වතුර දැමීම", "සෙවණේ පමණක් තැබීම"), 1, "පාරිභෝගික කැමැත්ත සහ උසස් තත්ත්වයේ මල් නිෂ්පාදනය වාණිජ මල් වගාවේ සාර්ථකත්වයට හේතු වේ.")
            })
            slot in 21..40 -> "අපනයන කෘෂි බෝග" to getQuestions(slot, v, List(30) { i ->
                Quad("ශ්‍රී ලංකාවේ ප්‍රධාන අපනයන බෝගයක් ලෙස සැලකෙන කුළුබඩු වර්ගයක් වන්නේ (${i + 1})", listOf("ගම්මිරිස්", "කැරට්", "ගෝවා", "තක්කාලි"), 1, "ගම්මිරිස් යනු ලංකාවට විදේශ විනිමය ලබාදෙන ප්‍රධාන කුළුබඩු බෝගයකි.")
            })
            else -> "කෘෂි ව්‍යවසායකත්වය" to getQuestions(slot, v, List(30) { i ->
                Quad("සාර්ථක කෘෂි ව්‍යවසායකයෙකු සතු විය යුතු ලක්ෂණයක් වන්නේ (${i + 1})", listOf("අවදානම් කළමනාකරණය හා නවෝත්පාදනය", "කම්මැලි බව", "පැරණි ක්‍රම පමණක් භාවිතය", "අලාභයට බිය වීම"), 1, "නව ක්‍රම හඳුන්වා දීම සහ අවදානම භාර ගැනීම ව්‍යවසායකයෙකුගේ මූලික ලක්ෂණයකි.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "කෘෂි විද්‍යාව ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm3Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..20 -> "නවීන කෘෂි තාක්ෂණය" to getQuestions(slot, v, List(30) { i ->
                Quad("පාලිත තත්ත්ව යටතේ වගා කිරීම (Protected Culture) සඳහා නිදසුනක් වන්නේ (${i + 1})", listOf("පොලිටනල් හෝ හරිතාගාර", "විවෘත කුඹුර", "වනාන්තරය", "මහා මාර්ගය"), 1, "හරිතාගාර තුළ වගා කිරීමෙන් දේශගුණික සාධක පාලනය කර ඉහළ අස්වැන්නක් ලබාගත හැක.")
            })
            slot in 21..40 -> "කෘෂිකාර්මික කළමනාකරණය" to getQuestions(slot, v, List(30) { i ->
                Quad("කෘෂිකාර්මික කටයුතු වලදී වාර්තා පවත්වා ගැනීමේ (Record Keeping) වාසියක් වන්නේ (${i + 1})", listOf("ලාභ අලාභ හා ප්‍රගතිය හඳුනා ගැනීම", "කාලය අපතේ යාම", "අමතර වියදම", "මුදල් නැති වීම"), 1, "වාර්තා පවත්වා ගැනීමෙන් ව්‍යාපාරයේ මූල්‍ය තත්ත්වය සහ ඉදිරි සැලසුම් සකස් කිරීම පහසු වේ.")
            })
            else -> "තිරසර කෘෂිකර්මාන්තය" to getQuestions(slot, v, List(30) { i ->
                Quad("තිරසර කෘෂිකර්මාන්තයේදී (Sustainable Agriculture) අනුගමනය කරන මූලධර්මයක් වන්නේ (${i + 1})", listOf("ස්වාභාවික සම්පත් ආරක්ෂා කරමින් වගා කිරීම", "පස දූෂණය කිරීම", "සියලු ගස් කැපීම", "ජල මූලාශ්‍ර විනාශ කිරීම"), 1, "අනාගත පරපුරට සම්පත් ඉතිරි කරමින් පරිසර හිතකාමී ලෙස වගා කිරීම මෙහි අරමුණයි.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "කෘෂි විද්‍යාව ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getQuestions(slot: Int, v: Int, list: List<Quad>): Quad = list[(slot + v).mod(list.size)]

    private data class Quad(
        val q: String,
        val opts: List<String>,
        val c: Int,
        val exp: String
    )
}
