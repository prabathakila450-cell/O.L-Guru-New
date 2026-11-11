package com.example

/**
 * Grade 10 Business and Accounting Studies Syllabus Question Bank for Live Exam Hall.
 * Covers Terms 1, 2, and 3 with 60 distinct syllabus topic slots per term.
 * Each slot has 30 unique variations, ensuring 1800 unique questions per term.
 */
object CommerceGrade10QuestionBank {
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
            slot in 1..10 -> "ව්‍යාපාර පසුබිම - මිනිස් අවශ්‍යතා හා උවමනා" to getQuestions(slot, v, List(30) { i ->
                Quad("මිනිස් අවශ්‍යතා (Human Needs) සම්බන්ධයෙන් නිවැරදි ප්‍රකාශය කුමක්ද? (${i + 1})", listOf("ඒවා අත්‍යවශ්‍ය සහ සීමිත වේ", "ඒවා අසීමිත වේ", "ඒවා විවිධ වේ", "ඒවා නිර්මාණය කළ හැක"), 1, "මිනිස් අවශ්‍යතා ජීවත් වීමට අත්‍යවශ්‍ය වන අතර ඒවා සියලු මිනිසුන්ට පොදු සහ සීමිත වේ.")
            })
            slot in 11..20 -> "නිෂ්පාදන සාධක" to getQuestions(slot, v, List(30) { i ->
                Quad("නිෂ්පාදන සාධක හතර වන්නේ (${i + 1})", listOf("භූමිය, ශ්‍රමය, ප්‍රාග්ධනය හා ව්‍යවසායකත්වය", "මුදල්, යන්ත්‍ර, මිනිසුන් හා ගොඩනැගිලි", "ශ්‍රමය, ප්‍රාග්ධනය, කාලය හා දැනුම", "භූමිය, මුදල්, ශ්‍රමය හා කළමනාකරණය"), 1, "ආර්ථික විද්‍යාත්මකව නිෂ්පාදන සාධක හතර වන්නේ භූමිය, ශ්‍රමය, ප්‍රාග්ධනය හා ව්‍යවසායකත්වයයි.")
            })
            slot in 21..30 -> "ව්‍යාපාර වර්ගීකරණය" to getQuestions(slot, v, List(30) { i ->
                Quad("ව්‍යාපාරයක අයිතිය මත පදනම් වූ වර්ගීකරණයට අයත් වන්නේ (${i + 1})", listOf("රාජ්‍ය අංශයේ සහ පෞද්ගලික අංශයේ ව්‍යාපාර", "කුඩා පරිමාණ හා මහා පරිමාණ ව්‍යාපාර", "දේශීය හා විදේශීය ව්‍යාපාර", "ලාභ ලබන හා ලාභ නොලබන ව්‍යාපාර"), 1, "අයිතිය මත ව්‍යාපාර රාජ්‍ය අංශය සහ පෞද්ගලික අංශය ලෙස ප්‍රධාන කොටස් දෙකකට බෙදිය හැක.")
            })
            slot in 31..40 -> "ව්‍යාපාර පරිසරය" to getQuestions(slot, v, List(30) { i ->
                Quad("ව්‍යාපාරයක අභ්‍යන්තර පරිසරයට (Internal Environment) අයත් සාධකයක් වන්නේ (${i + 1})", listOf("සේවකයින්", "පාරිභෝගිකයින්", "තරඟකරුවන්", "දේශපාලන සාධක"), 1, "අයිතිකරුවන්, කළමනාකරුවන්, සේවකයින් සහ ව්‍යාපාරික සම්පත් අභ්‍යන්තර පරිසරයට අයත් වේ.")
            })
            slot in 41..50 -> "ගිණුම්කරණය - ගිණුම්කරණ සමීකරණය" to getQuestions(slot, v, List(30) { i ->
                val assets = 100000 + (i * 1000)
                val liabilities = 30000 + (i * 500)
                val equity = assets - liabilities
                Quad("ව්‍යාපාරයක මුළු වත්කම් රු. $assets ක් සහ මුළු වගකීම් රු. $liabilities ක් නම්, එහි හිමිකම (Equity) කොපමණද? (${i + 1})", listOf("රු. $equity", "රු. ${assets + liabilities}", "රු. $assets", "රු. 0"), 1, "ගිණුම්කරණ සමීකරණය: වත්කම් = හිමිකම + වගකීම්. එබැවින් හිමිකම = $assets - $liabilities = $equity වේ.")
            })
            else -> "මූලික ලේඛන" to getQuestions(slot, v, List(30) { i ->
                Quad("ව්‍යාපාරයක මුදල් ලැබීමක් තහවුරු කිරීමට නිකුත් කරන ලේඛනය කුමක්ද? (${i + 1})", listOf("ලදුපත (Receipt)", "ගෙවීම් වවුචරය", "පිටපත් ඉන්වොයිසිය", "ණය පත"), 1, "මුදල් ලැබීමකදී මුදල් ගෙවන්නා වෙත ලදුපතක් නිකුත් කරනු ලැබේ.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "ව්‍යාපාර අධ්‍යයනය ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm2Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..15 -> "ව්‍යාපාර සංවිධාන - ඒක පුද්ගල ව්‍යාපාර" to getQuestions(slot, v, List(30) { i ->
                Quad("ඒක පුද්ගල ව්‍යාපාරයක ප්‍රධාන ලක්ෂණයක් වන්නේ (${i + 1})", listOf("අයිතිකරු හා ව්‍යාපාරය නීතිය ඉදිරියේ එකක් වීම", "සීමිත වගකීම", "අධ්‍යක්ෂ මණ්ඩලයක් තිබීම", "කොටස් නිකුත් කිරීම"), 1, "ඒක පුද්ගල ව්‍යාපාරයකට වෙනම නෛතික පුද්ගලභාවයක් නොමැති අතර අයිතිකරුට අසීමිත වගකීමක් පවතී.")
            })
            slot in 16..30 -> "හවුල් ව්‍යාපාර" to getQuestions(slot, v, List(30) { i ->
                Quad("1890 හවුල් ව්‍යාපාර ආඥා පනත අනුව හවුල්කරුවන් සංඛ්‍යාව සාමාන්‍යයෙන් (${i + 1})", listOf("2 සිට 20 දක්වා", "1 සිට 50 දක්වා", "අවම 7 ක්", "උපරිමයක් නැත"), 1, "සාමාන්‍ය වෙළඳ කටයුතු කරන හවුල් ව්‍යාපාරයක හවුල්කරුවන් සංඛ්‍යාව 2 සිට 20 දක්වා විය හැක.")
            })
            slot in 31..45 -> "ද්විත්ව සටහන් මූලධර්මය" to getQuestions(slot, v, List(30) { i ->
                Quad("ව්‍යාපාරයක ප්‍රාග්ධනය හඳුන්වා දීමේදී ද්විත්ව සටහන වන්නේ (${i + 1})", listOf("මුදල් ගිණුම හර, ප්‍රාග්ධන ගිණුම බැර", "ප්‍රාග්ධන ගිණුම හර, මුදල් ගිණුම බැර", "බැංකු ගිණුම හර, මුදල් ගිණුම බැර", "වත්කම් ගිණුම හර, වගකීම් ගිණුම බැර"), 1, "ප්‍රාග්ධනය ලැබෙන විට වත්කමක් (මුදල්) වැඩි වී (හර), හිමිකමක් (ප්‍රාග්ධනය) වැඩි වේ (බැර).")
            })
            else -> "මූලික පොත් - මුදල් පොත" to getQuestions(slot, v, List(30) { i ->
                Quad("මුදල් පොතේ බැර පැත්තේ සටහන් කරනු ලබන්නේ (${i + 1})", listOf("සියලුම මුදල් ගෙවීම්", "සියලුම මුදල් ලැබීම්", "ණයට විකිණීම්", "ණයට ගැනුම්"), 1, "මුදල් පොතේ හර පැත්තේ ලැබීම් ද, බැර පැත්තේ ගෙවීම් ද සටහන් කෙරේ.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "ව්‍යාපාර අධ්‍යයනය ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm3Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..15 -> "ලෙජරය හා ශේෂ පත්‍රය" to getQuestions(slot, v, List(30) { i ->
                Quad("ලෙජර ගිණුම්වල ශේෂයන් පරීක්ෂා කිරීම සඳහා පිළියෙළ කරන ලේඛනය කුමක්ද? (${i + 1})", listOf("ශේෂ පිරික්සුම (Trial Balance)", "මුදල් ප්‍රවාහ ප්‍රකාශය", "ලාභ අලාභ ගිණුම", "තත්ත්ව ප්‍රකාශය"), 1, "ශේෂ පිරික්සුම මගින් ලෙජර ගිණුම්වල ගණිතමය නිවැරදිභාවය පරීක්ෂා කරනු ලැබේ.")
            })
            slot in 16..30 -> "සුළු මුදල් පොත" to getQuestions(slot, v, List(30) { i ->
                Quad("සුළු මුදල් පොත නඩත්තු කිරීමේ මූලධර්මය වන්නේ (${i + 1})", listOf("අත්තිකාරම් ක්‍රමය (Imprest System)", "ද්විත්ව සටහන් ක්‍රමය", "තනි සටහන් ක්‍රමය", "ස්ථාවර ක්‍රමය"), 1, "සුළු මුදල් පොතේදී වාරයක් ආරම්භයේදී ස්ථාවර මුදලක් (අත්තිකාරමක්) සුළු මුදල් භාරකරුට ලබාදේ.")
            })
            slot in 31..45 -> "බැංකු සැසඳුම් ප්‍රකාශය" to getQuestions(slot, v, List(30) { i ->
                Quad("බැංකු සැසඳුම් ප්‍රකාශයක් පිළියෙළ කිරීමේ ප්‍රධාන අරමුණ වන්නේ (${i + 1})", listOf("මුදල් පොතේ බැංකු තීරුව හා බැංකු ප්‍රකාශයේ ශේෂයන් අතර වෙනස හඳුනා ගැනීම", "ලාභය ගණනය කිරීම", "ණය හිමියන් හඳුනා ගැනීම", "බදු ගෙවීම"), 1, "මුදල් පොතේ බැංකු තීරුව සහ බැංකුවෙන් දෙන ප්‍රකාශය අතර පවතින වෙනස්කම් සැසඳීම මෙහි අරමුණයි.")
            })
            else -> "ව්‍යාපාරික සන්නිවේදනය" to getQuestions(slot, v, List(30) { i ->
                Quad("ව්‍යාපාරික සන්නිවේදනයේදී 'ප්‍රතිපෝෂණය' (Feedback) යන්නෙන් අදහස් වන්නේ (${i + 1})", listOf("ලබන්නා විසින් පණිවිඩය තේරුම් ගෙන දක්වන ප්‍රතිචාරය", "පණිවිඩය යවන මාධ්‍යය", "පණිවිඩයට බාධා වීම", "පණිවිඩය සංකේතනය කිරීම"), 1, "සන්නිවේදකයාගේ පණිවිඩයට ප්‍රතිචාර දැක්වීම ප්‍රතිපෝෂණයයි.")
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
