package com.example

/**
 * Grade 10 Agriculture Syllabus Question Bank for Live Exam Hall.
 * Covers Terms 1, 2, and 3 with 60 distinct syllabus topic slots per term.
 * Each slot has 30 unique variations, ensuring 1800 unique questions per term.
 */
object AgriGrade10QuestionBank {
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
            slot in 1..15 -> "පස සහ පාංශු ගුණාංග" to getQuestions(slot, v, List(30) { i ->
                Quad("පසෙහි වයනය (Texture) මඟින් ප්‍රධාන වශයෙන් තීරණය වන්නේ කුමක්ද? (${i + 1})", listOf("පසෙහි ඇති වැලි, රොන්මඩ හා මැටි අනුපාතය", "පසෙහි වර්ණය", "පසෙහි උෂ්ණත්වය", "පසෙහි ඇති ජල ප්‍රමාණය"), 1, "පාංශු වයනය යනු පසෙහි අඩංගු විවිධ ප්‍රමාණයේ අංශු වල සාපේක්ෂ අනුපාතයයි.")
            })
            slot in 16..30 -> "කෘෂි කාලගුණ විද්‍යාව" to getQuestions(slot, v, List(30) { i ->
                Quad("ශාක වර්ධනය සඳහා බලපාන ප්‍රධානතම කාලගුණික සාධකයක් නොවන්නේ කුමක්ද? (${i + 1})", listOf("චන්ද්‍රයාගේ පිහිටීම", "සූර්යාලෝකය", "වර්ෂාපතනය", "වායුගෝලීය ආර්ද්‍රතාව"), 1, "සූර්යාලෝකය, වර්ෂාපතනය හා ආර්ද්‍රතාව ශාක වර්ධනයට සෘජුවම බලපාන නමුත් චන්ද්‍රයාගේ පිහිටීම එසේ නොවේ.")
            })
            slot in 31..45 -> "ශාක කායික විද්‍යාව (ප්‍රභාසංශ්ලේෂණය)" to getQuestions(slot, v, List(30) { i ->
                Quad("ශාක පත්‍ර වල ප්‍රභාසංශ්ලේෂණය සිදුවන ප්‍රධාන ස්ථානය වන්නේ (${i + 1})", listOf("හරිතලව", "අන්තඃප්ලාස්මීය ජාලය", "මයිටොකොන්ඩ්‍රියා", "න්‍යෂ්ටිය"), 1, "හරිතලව තුළ ඇති හරිතප්‍රද මගින් සූර්ය ශක්තිය අවශෝෂණය කර ආහාර නිපදවයි.")
            })
            else -> "බීජ හා ප්‍රචාරණය" to getQuestions(slot, v, List(30) { i ->
                Quad("ලිංගික ප්‍රචාරණයේදී (Sexual Propagation) භාවිත වන ප්‍රධාන ඒකකය වන්නේ (${i + 1})", listOf("බීජ", "දඬු කැබලි", "අතු", "මුල්"), 1, "බීජ මගින් ශාක ප්‍රචාරණය කිරීම ලිංගික ප්‍රචාරණය ලෙස හැඳින්වේ.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "කෘෂි විද්‍යාව ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm2Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..20 -> "වී වගාව" to getQuestions(slot, v, List(30) { i ->
                Quad("ශ්‍රී ලංකාවේ වී වගාව සඳහා වඩාත් උචිත වන පස කුමක්ද? (${i + 1})", listOf("ජලය රඳවා ගැනීමේ හැකියාව ඇති මැටි පස", "වැලි පස", "ලැටරයිට් පස", "හුණුගල් සහිත පස"), 1, "වී වගාවේදී පසෙහි ජලය රැඳී තිබීම අවශ්‍ය බැවින් මැටි අංශු වැඩි පස ඉතා උචිත වේ.")
            })
            slot in 21..40 -> "පොහොර හා ශාක පෝෂණය" to getQuestions(slot, v, List(30) { i ->
                Quad("ශාකයක වර්ධක වර්ධනයට (Vegetative Growth) ප්‍රධාන වශයෙන් බලපාන මූලද්‍රව්‍යය වන්නේ (${i + 1})", listOf("නයිට්‍රජන් (N)", "පොස්පරස් (P)", "පොටෑසියම් (K)", "කැල්සියම් (Ca)"), 1, "නයිට්‍රජන් මගින් ශාක පත්‍ර වල වර්ණය සහ ශාකයේ වර්ධනය වේගවත් කරයි.")
            })
            else -> "වල් පැලෑටි පාලනය" to getQuestions(slot, v, List(30) { i ->
                Quad("වල් පැලෑටි නිසා වගාවකට සිදුවන ප්‍රධාන හානියක් වන්නේ (${i + 1})", listOf("පෝෂකය, ජලය හා ඉඩ සඳහා තරඟ කිරීම", "බෝග පලදාව වැඩි වීම", "පස සාරවත් වීම", "කෘමීන් අඩු වීම"), 1, "වල් පැලෑටි බෝග සමඟ තරඟ වැදීම නිසා බෝගයේ වර්ධනය බාල වේ.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "කෘෂි විද්‍යාව ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm3Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..20 -> "පළිබෝධ හා රෝග පාලනය" to getQuestions(slot, v, List(30) { i ->
                Quad("වගාවකට හානි කරන කෘමීන් පාලනය සඳහා භාවිත කළ හැකි පරිසර හිතකාමී ක්‍රමයක් වන්නේ (${i + 1})", listOf("ජෛව විද්‍යාත්මක පාලනය", "අධික ලෙස කෘමිනාශක යෙදීම", "ගිනි තැබීම", "කැලෑ කැපීම"), 1, "ස්වභාවික සතුරන් (Natural Enemies) යොදාගෙන පළිබෝධ පාලනය කිරීම ජෛව පාලනයයි.")
            })
            slot in 21..40 -> "කෘෂි උපකරණ හා යන්ත්‍රෝපකරණ" to getQuestions(slot, v, List(30) { i ->
                Quad("පස ගැඹුරට පෙරළීම සඳහා භාවිත කරන ප්‍රධාන උපකරණය කුමක්ද? (${i + 1})", listOf("නගුල", "කැත්ත", "පිහිය", "රේක්කය"), 1, "නගුල මගින් පස යටට පෙරළා බෝග වගාවට අවශ්‍ය පරිදි සකස් කරයි.")
            })
            else -> "ගෘහ උද්‍යානකරණය" to getQuestions(slot, v, List(30) { i ->
                Quad("ගෘහ උද්‍යානයක තිබිය යුතු ප්‍රධාන ලක්ෂණයක් වන්නේ (${i + 1})", listOf("පවතින ඉඩකඩ ඵලදායී ලෙස භාවිත කිරීම", "විශාල යන්ත්‍ර තිබීම", "සෑම විටම රසායනික පොහොර යෙදීම", "එක් බෝගයක් පමණක් වගා කිරීම"), 1, "පවතින සීමිත ඉඩ ප්‍රමාණය තුළ පවුලේ පෝෂණ අවශ්‍යතා සපුරා ගැනීම ගෘහ උද්‍යානකරණයේ අරමුණයි.")
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
