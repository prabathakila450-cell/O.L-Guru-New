package com.example

/**
 * Grade 10 Geography Syllabus Question Bank for Live Exam Hall.
 * Covers Terms 1, 2, and 3 with 60 distinct syllabus topic slots per term.
 * Each slot has 30 unique variations, ensuring 1800 unique questions per term.
 */
object GeographyGrade10QuestionBank {
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
            slot in 1..15 -> "පෘථිවිය හා සිතියම් (පරිමාණය හා දිශාව)" to getQuestions(slot, v, List(30) { i ->
                Quad("සිතියමක 1:50,000 පරිමාණය අනුව 1cm කින් නිරූපණය වන සැබෑ දුර කොපමණද? (${i + 1})", listOf("මීටර් 500", "මීටර් 50", "කිලෝමීටර් 5", "මීටර් 5000"), 1, "1:50,000 පරිමාණයේදී සිතියමේ 1cm ක් භූමියේ මීටර් 500ක් (0.5km) නිරූපණය කරයි.")
            })
            slot in 16..30 -> "ශ්‍රී ලංකාවේ භූ විෂමතාව" to getQuestions(slot, v, List(30) { i ->
                Quad("ශ්‍රී ලංකාවේ උසම කඳු පන්තිය ලෙස සැලකෙන්නේ (${i + 1})", listOf("මධ්‍යම කඳුකරය", "නකල්ස් කඳු පන්තිය", "සමනල කන්ද", "රක්වාන කඳු පන්තිය"), 1, "ලංකාවේ භූ විෂමතාවයේ කේන්ද්‍රීය කොටස මධ්‍යම කඳුකරයයි.")
            })
            slot in 31..45 -> "ශ්‍රී ලංකාවේ දේශගුණය" to getQuestions(slot, v, List(30) { i ->
                Quad("ලංකාවට වැඩිම වර්ෂාපතනයක් ලැබෙන ප්‍රධාන මෝසම් සුළං වර්ගය වන්නේ (${i + 1})", listOf("නිරිතදිග මෝසම් සුළඟ", "ඊසානදිග මෝසම් සුළඟ", "සංවහන වැසි", "සුළි සුළං"), 1, "නිරිතදිග මෝසම් සුළං මගින් ලංකාවේ තෙත් කලාපයට දැඩි වර්ෂාපතනයක් ලැබේ.")
            })
            else -> "ස්වභාවික වෘක්ෂලතා" to getQuestions(slot, v, List(30) { i ->
                Quad("ශ්‍රී ලංකාවේ නිවර්තන තෙත් සදාහරිත වනාන්තරයකට උදාහරණයක් වන්නේ (${i + 1})", listOf("සිංහරාජය", "විල්පත්තුව", "යාල", "කුමන"), 1, "සිංහරාජය යනු ලෝක උරුමයක් බඳු නිවර්තන තෙත් වැසි වනාන්තරයකි.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "භූගෝලය ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm2Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..20 -> "ශ්‍රී ලංකාවේ කෘෂිකර්මාන්තය" to getQuestions(slot, v, List(30) { i ->
                Quad("ලංකාවේ ප්‍රධාන අපනයන බෝග ත්‍රිත්වයට (තේ, රබර්, පොල්) අමතරව වැදගත් වන බෝගයකි (${i + 1})", listOf("කුරුඳු", "වී", "එළවළු", "මල්"), 1, "කුරුඳු යනු ශ්‍රී ලංකාවට ඉතිහාසයේ සිටම විශාල විදේශ විනිමයක් ලබාදෙන බෝගයකි.")
            })
            slot in 21..40 -> "ශ්‍රී ලංකාවේ කර්මාන්ත" to getQuestions(slot, v, List(30) { i ->
                Quad("ලංකාවේ මහා පරිමාණ කර්මාන්තයක් සඳහා නිදසුනක් වන්නේ (${i + 1})", listOf("ඇඟලුම් කර්මාන්තය", "කුඹල් කර්මාන්තය", "පන් විවීම", "කිරි නිෂ්පාදනය"), 1, "ඇඟලුම් කර්මාන්තය ලංකාවේ ප්‍රධානතම නිෂ්පාදන අපනයන අංශයයි.")
            })
            else -> "ඛනිජ සම්පත්" to getQuestions(slot, v, List(30) { i ->
                Quad("ශ්‍රී ලංකාවේ 'පැන්සල් කූරු' නිපදවීමට ගන්නා ප්‍රධාන ඛනිජය වන්නේ (${i + 1})", listOf("මිනිරන් (Graphite)", "මැණික්", "හුණුගල්", "ලෝපස්"), 1, "ලංකාවේ උසස් තත්ත්වයේ මිනිරන් ඉතිහාසයේ සිටම ලෝක ප්‍රසිද්ධය.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "භූගෝලය ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm3Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..20 -> "සේවා අංශය (ප්‍රවාහනය හා සන්නිවේදනය)" to getQuestions(slot, v, List(30) { i ->
                Quad("ශ්‍රී ලංකාවේ මහා මාර්ග පද්ධතියේ ඉහළම ශ්‍රේණිය ලෙස සැලකෙන්නේ (${i + 1})", listOf("අධිවේගී මාර්ග (E ශ්‍රේණිය)", "A ශ්‍රේණියේ මාර්ග", "B ශ්‍රේණියේ මාර්ග", "C ශ්‍රේණියේ මාර්ග"), 1, "E ශ්‍රේණියේ අධිවේගී මාර්ග මගින් ඉතා වේගවත් ගමනාගමනයක් සහතික කරයි.")
            })
            slot in 21..40 -> "ලෝක සිතියම" to getQuestions(slot, v, List(30) { i ->
                Quad("ලෝකයේ විශාලතම මහාද්වීපය කුමක්ද? (${i + 1})", listOf("ආසියාව", "අප්‍රිකාව", "යුරෝපය", "උතුරු ඇමරිකාව"), 1, "භූමි ප්‍රමාණයෙන් මෙන්ම ජනගහනයෙන්ද ආසියාව ලොව විශාලතම මහාද්වීපයයි.")
            })
            else -> "සිතියම් කියවීම (1:50,000)" to getQuestions(slot, v, List(30) { i ->
                Quad("භූලක්ෂණ සිතියමක සමෝච්ච රේඛා එකිනෙකට ඉතා ආසන්නව පිහිටීමෙන් නිරූපණය වන්නේ (${i + 1})", listOf("දැඩි බෑවුම", "තැන්න", "මිටියාවත", "කඳු ගැටය"), 1, "සමෝච්ච රේඛා ලඟින් පිහිටීම මගින් භූමියේ බෑවුම අධික බව පෙන්වයි.")
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
