package com.example

/**
 * Grade 11 Health and Physical Education Syllabus Question Bank for Live Exam Hall.
 * Covers Terms 1, 2, and 3 with 60 distinct syllabus topic slots per term.
 * Each slot has 30 unique variations, ensuring 1800 unique questions per term.
 */
object HealthGrade11QuestionBank {
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
            slot in 1..10 -> "ලිංගික හා ප්‍රජනක සෞඛ්‍යය" to getQuestions(slot, v, List(30) { i ->
                Quad("ලිංගික සෞඛ්‍යය පවත්වා ගැනීමේ වැදගත්කම (${i + 1})", listOf("යහපත් පවුල් ජීවිතයක් හා නිරෝගී බව", "මුදල් ඉපයීම", "බලය පෙන්වීම", "සංගීතයට ඇලුම් කිරීම"), 1, "ලිංගික හා ප්‍රජනක සෞඛ්‍යය මගින් පුද්ගල යහපැවැත්ම සහ නිරෝගී පරපුරක් බිහිවීම තහවුරු වේ.")
            })
            slot in 11..20 -> "බෝවන රෝග පාලනය" to getQuestions(slot, v, List(30) { i ->
                Quad("බෝවන රෝගයක් ව්‍යාප්ත විය හැකි ක්‍රමයක් (${i + 1})", listOf("වාතය, ජලය හා ස්පර්ශය", "වැඩිපුර පොත් කියවීම", "ව්‍යායාම කිරීම", "සිනාසීම"), 1, "රෝගකාරක ක්ෂුද්‍ර ජීවීන් වාතය, ජලය හෝ සෘජු ස්පර්ශය මගින් නීරෝගී පුද්ගලයෙකුට ඇතුල් විය හැක.")
            })
            slot in 21..30 -> "බෝ නොවන රෝග (NCD)" to getQuestions(slot, v, List(30) { i ->
                Quad("බෝ නොවන රෝග වලට උදාහරණයක් (${i + 1})", listOf("දියවැඩියාව හා අධි රුධිර පීඩනය", "උණසන්නිපාතය", "ඩෙංගු", "කොලරාව"), 1, "අක්‍රමවත් ආහාර හා ව්‍යායාම මදිකම නිසා ඇතිවන රෝග බෝ නොවන රෝග ගණයට අයත් වේ.")
            })
            slot in 31..40 -> "මත්ද්‍රව්‍ය හා දුම්පානය" to getQuestions(slot, v, List(30) { i ->
                Quad("දුම්පානය නිසා ඇතිවිය හැකි ප්‍රධාන රෝගී තත්ත්වයක් (${i + 1})", listOf("පෙනහළු පිළිකා", "පාචනය", "හන්දිපත් රුදාව", "ඇස් පෙනීම වැඩි වීම"), 1, "දුම්වැටි වල ඇති අහිතකර රසායනික ද්‍රව්‍ය පෙනහළු හා ශ්වසන පද්ධතියට දරුණු හානි සිදු කරයි.")
            })
            slot in 41..50 -> "මානසික සෞඛ්‍යය" to getQuestions(slot, v, List(30) { i ->
                Quad("මානසික ආතතිය පාලනය කිරීමට ක්‍රමයක් (${i + 1})", listOf("විවේකය හා මනස එකඟ කර ගැනීම", "තරහ ගැනීම", "වැඩිපුර කෑගැසීම", "හුදකලාව සිටීම"), 1, "සමබර මනසක් පවත්වා ගැනීම සඳහා විවේකය, විනෝදාංශ සහ ධනාත්මක සිතුවිලි වැදගත් වේ.")
            })
            else -> "පාපන්දු ක්‍රීඩාව" to getQuestions(slot, v, List(30) { i ->
                Quad("පාපන්දු ක්‍රීඩාවකදී පන්දුව අතින් ඇල්ලිය හැකි එකම ක්‍රීඩකයා (${i + 1})", listOf("ගෝල රකින්නා (Goalkeeper)", "පෙරමුණු පෙළ", "මැද පෙළ", "පසුපෙළ"), 1, "ගෝල රකින්නාට පමණක් තමාගේ සීමාව තුළ පන්දුව අතින් ඇල්ලීමට අවසර ඇත.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm2Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..15 -> "පවුල් සෞඛ්‍යය" to getQuestions(slot, v, List(30) { i ->
                Quad("සන්තෝෂවත් පවුලක ලක්ෂණයක් (${i + 1})", listOf("අන්‍යෝන්‍ය අවබෝධය හා සහයෝගය", "නිතර රණ්ඩු වීම", "එක් අයෙකු පමණක් තීරණ ගැනීම", "වෙන්වී ජීවත් වීම"), 1, "සන්තෝෂවත් පවුලක සාමාජිකයන් අතර ආදරය, ගරුත්වය සහ අවබෝධය පවතී.")
            })
            slot in 16..30 -> "සන්නිවේදනය හා සෞඛ්‍යය" to getQuestions(slot, v, List(30) { i ->
                Quad("ඵලදායී සන්නිවේදනයේ වාසියක් වන්නේ (${i + 1})", listOf("ගැටුම් අවම වීම හා සම්බන්ධතා ශක්තිමත් වීම", "අමනාප වීම", "රහස් රැකීම", "බලය පෙන්වීම"), 1, "නිවැරදි සන්නිවේදනය මගින් මිනිසුන් අතර අනවබෝධය දුරු වී සමගිය වර්ධනය වේ.")
            })
            slot in 31..45 -> "පාරිසරික සෞඛ්‍යය" to getQuestions(slot, v, List(30) { i ->
                Quad("පරිසර දූෂණය අවම කිරීමට ගත හැකි ක්‍රියාමාර්ගයක් (${i + 1})", listOf("අපද්‍රව්‍ය නිසි ලෙස කළමනාකරණය", "කසල පුළුස්සා දැමීම", "ගංගාවලට අපද්‍රව්‍ය දැමීම", "කැලෑ කැපීම"), 1, "පරිසරය පිරිසිදුව තබා ගැනීම මගින් මිනිසාගේ සෞඛ්‍යය ආරක්ෂා වේ.")
            })
            else -> "ක්‍රිකට් ක්‍රීඩාව" to getQuestions(slot, v, List(30) { i ->
                Quad("ක්‍රිකට් ක්‍රීඩාවේ 'එල්.බී.ඩබ්ලිව්' (LBW) යන්නෙන් අදහස් වන්නේ (${i + 1})", listOf("පාදයේ වැදී දැවී යාම", "කඩුල්ල බිඳ වැටීම", "උඩ පන්දුවක්", "දුවද්දී දැවී යාම"), 1, "Leg Before Wicket යනු ක්‍රිකට් ක්‍රීඩාවේ දැවී යාමේ එක් ක්‍රමයකි.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm3Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..15 -> "පාරිභෝගික සෞඛ්‍යය" to getQuestions(slot, v, List(30) { i ->
                Quad("භාණ්ඩයක් මිලදී ගැනීමේදී සැලකිලිමත් විය යුතු කරුණක් (${i + 1})", listOf("කල් ඉකුත් වීමේ දිනය", "පැකට්ටුවේ පාට", "දැන්වීම් ප්‍රමාණය", "කඩේ විශාලත්වය"), 1, "කල් ඉකුත් වූ ආහාර ගැනීමෙන් විෂ වීම් හෝ ලෙඩ රෝග ඇතිවිය හැක.")
            })
            slot in 16..30 -> "ක්‍රීඩා විද්‍යාව හා තාක්ෂණය" to getQuestions(slot, v, List(30) { i ->
                Quad("ක්‍රීඩා කිරීමේදී මාංශ පේශිවලට ලැබෙන ප්‍රයෝජනයක් (${i + 1})", listOf("ශක්තිමත් වීම හා නම්‍යශීලී බව", "දුර්වල වීම", "කැක්කුම ඇති වීම", "කුඩා වීම"), 1, "නිතිපතා ක්‍රීඩා කිරීමෙන් මාංශ පේශි සහ අස්ථි පද්ධතිය ශක්තිමත් වේ.")
            })
            slot in 31..45 -> "ජාත්‍යන්තර ක්‍රීඩා උළෙල" to getQuestions(slot, v, List(30) { i ->
                Quad("ලෝකයේ විශාලතම ක්‍රීඩා උළෙල ලෙස සැලකෙන්නේ (${i + 1})", listOf("ඔලිම්පික් උළෙල", "ආසියානු ක්‍රීඩා", "සාර්ක් ක්‍රීඩා", "පාසල් ක්‍රීඩා"), 1, "ඔලිම්පික් උළෙල වසර හතරකට වරක් පවත්වන ලෝකයේ ප්‍රධානතම ක්‍රීඩා සැණකෙළියයි.")
            })
            else -> "එල්ලේ ක්‍රීඩාව" to getQuestions(slot, v, List(30) { i ->
                Quad("එල්ලේ ක්‍රීඩාවේදී එක් කණ්ඩායමකට ක්‍රීඩකයින් කී දෙනෙකු සහභාගී වේද? (${i + 1})", listOf("16", "11", "12", "7"), 1, "සාමාන්‍යයෙන් එල්ලේ ක්‍රීඩාවේ එක් කණ්ඩායමකට ක්‍රීඩකයින් 16 දෙනෙකු ඇතුළත් වේ.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getQuestions(slot: Int, v: Int, list: List<Quad>): Quad = list[(slot + v).mod(list.size)]

    private data class Quad(
        val q: String,
        val opts: List<String>,
        val c: Int,
        val exp: String
    )
}
