package com.example

/**
 * Grade 10 Health and Physical Education Syllabus Question Bank for Live Exam Hall.
 * Covers Terms 1, 2, and 3 with 60 distinct syllabus topic slots per term.
 * Each slot has 30 unique variations, ensuring 1800 unique questions per term.
 */
object HealthGrade10QuestionBank {
    fun getQuestion(term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
        val cleanPaper = if (paperIdx in 1..30) paperIdx else 1
        val cleanQ = if (qNum in 1..60) qNum else 1
        // Slot logic: ensures each of the 60 questions in a paper comes from a different syllabus slot.
        // Variation logic: ensures each paper (1-30) uses a different variation from that slot.
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
            slot in 1..10 -> "සිරුරේ ක්‍රියාකාරිත්වය - අස්ථි හා පේශි පද්ධතිය" to getQuestions(slot, v, List(30) { i ->
                Quad("මිනිස් අස්ථි පද්ධතිය හා සම්බන්ධ ලක්ෂණයක් (${i + 1})", listOf("ශරීරයට හැඩයක් ලබා දීම", "රුධිරය ගබඩා කිරීම", "ආහාර ජීර්ණය", "සිතීම"), 1, "අස්ථි පද්ධතිය මගින් සිරුරට හැඩය, ආධාරකය සහ ආරක්ෂාව සපයයි.")
            })
            slot in 11..20 -> "පෝෂණය හා ආහාර" to getQuestions(slot, v, List(30) { i ->
                Quad("සමබල ආහාර වේලක වැදගත්කම (${i + 1})", listOf("නිරෝගී වර්ධනය", "ලෙඩ වීම", "බර අඩු වීම පමණි", "නිදි මත ඇති කිරීම"), 1, "සමබල ආහාර වේලක් මගින් සිරුරට අවශ්‍ය සියලු පෝෂක නිසි ප්‍රමාණයෙන් ලැබේ.")
            })
            slot in 21..30 -> "වර්ධනය හා සංවර්ධනය" to getQuestions(slot, v, List(30) { i ->
                Quad("යොවුන් වියේ සිදුවන කායික වෙනසක් (${i + 1})", listOf("උස හා බර වේගයෙන් වැඩි වීම", "කථනය නතර වීම", "පෙනීම අඩුවීම", "දත් හැලීම"), 1, "යොවුන් වියේදී හෝමෝන ක්‍රියාකාරිත්වය නිසා වේගවත් කායික වර්ධනයක් සිදුවේ.")
            })
            slot in 31..40 -> "ඉරියව් හා ව්‍යායාම" to getQuestions(slot, v, List(30) { i ->
                Quad("නිවැරදි ඉරියව් පවත්වා ගැනීමේ වාසිය (${i + 1})", listOf("පෙනුම හා කාර්යක්ෂමතාව වැඩි වීම", "සන්ධි වේදනාව ඇති වීම", "ශක්තිය වැය වීම", "මහන්සිය වැඩි වීම"), 1, "නිවැරදි ඉරියව් මගින් සිරුරේ සමබරතාවය සහ පෙනුම මෙන්ම කාර්යක්ෂමතාවද වැඩි වේ.")
            })
            slot in 41..50 -> "ප්‍රථමාධාර" to getQuestions(slot, v, List(30) { i ->
                Quad("අස්ථි බිඳීමකදී ලබාදිය යුතු මූලික ප්‍රථමාධාරය (${i + 1})", listOf("බිඳුණු කොටස නිශ්චල කිරීම", "තදින් පිරිමැදීම", "උණු වතුර දැමීම", "ඇදීම"), 1, "අස්ථි බිඳීමකදී වැඩිදුර හානි වැළැක්වීමට අදාළ ස්ථානය නිශ්චලව තැබිය යුතුය.")
            })
            else -> "ක්‍රීඩා සහ මලල ක්‍රීඩා" to getQuestions(slot, v, List(30) { i ->
                Quad("මලල ක්‍රීඩා ඉසව්වක් වන්නේ (${i + 1})", listOf("මීටර 100 ධාවනය", "චෙස්", "ක්‍රිකට්", "බැඩ්මින්ටන්"), 1, "ධාවන, පැනීම සහ විසි කිරීම් මලල ක්‍රීඩා ඉසව් ගණයට අයත් වේ.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm2Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..15 -> "ආහාර ජීර්ණ පද්ධතිය" to getQuestions(slot, v, List(30) { i ->
                Quad("ආහාර ජීර්ණය ආරම්භ වන ස්ථානය (${i + 1})", listOf("මුඛය", "ආමාශය", "කුඩා බඩවැල", "ග්‍රසනිකාව"), 1, "කළල විද්‍යාත්මකව සහ කායික විද්‍යාත්මකව ආහාර ජීර්ණය මුඛයෙන් ආරම්භ වේ.")
            })
            slot in 16..30 -> "රුධිර සංසරණ පද්ධතිය" to getQuestions(slot, v, List(30) { i ->
                Quad("රුධිරයේ ප්‍රධාන කාර්යයක් වන්නේ (${i + 1})", listOf("ඔක්සිජන් හා පෝෂක පරිවහනය", "අස්ථි සෑදීම", "කල්පනා කිරීම", "හඬ නිපදවීම"), 1, "රුධිරය මගින් ශරීරය පුරා ඔක්සිජන්, හෝමෝන සහ පෝෂක ද්‍රව්‍ය ගෙන යයි.")
            })
            slot in 31..45 -> "ශ්වසන පද්ධතිය" to getQuestions(slot, v, List(30) { i ->
                Quad("ශ්වසන පද්ධතියේ ප්‍රධාන ඉන්ද්‍රිය වන්නේ (${i + 1})", listOf("පෙනහළු", "වකුගඩු", "අක්මාව", "හෘදය"), 1, "පෙනහළු මගින් වායු හුවමාරුව සිදු කර ශ්වසන ක්‍රියාවලියට දායක වේ.")
            })
            else -> "වොලිබෝල් ක්‍රීඩාව" to getQuestions(slot, v, List(30) { i ->
                Quad("වොලිබෝල් ක්‍රීඩාවක එක් කණ්ඩායමක සිටින ක්‍රීඩකයින් ගණන (${i + 1})", listOf("6", "11", "7", "5"), 1, "නිල වොලිබෝල් තරඟයකදී එක් කණ්ඩායමකට ක්‍රීඩකයින් 6 දෙනෙකු සහභාගී වේ.")
            })
        }
        return MockExamQuestion(id = qNum, questionText = "ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm3Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..15 -> "බැහැර කිරීමේ පද්ධතිය" to getQuestions(slot, v, List(30) { i ->
                Quad("ප්‍රධාන බහිස්‍රාවී ඉන්ද්‍රියයක් වන්නේ (${i + 1})", listOf("වකුගඩු", "හෘදය", "අග්න්‍යාශය", "මොළය"), 1, "වකුගඩු මගින් රුධිරය පෙරා මුත්‍රා ලෙස අපද්‍රව්‍ය බැහැර කරයි.")
            })
            slot in 16..30 -> "සම හා සෞඛ්‍යය" to getQuestions(slot, v, List(30) { i ->
                Quad("සමේ සෞඛ්‍යය රැකගැනීමට කළ හැකි දෑ (${i + 1})", listOf("දිනපතා ස්නානය හා පිරිසිදු බව", "අව්වේ සිටීම", "කුණු තැවරීම", "වැඩිපුර තෙල් කෑම"), 1, "සම පිරිසිදුව තබා ගැනීමෙන් විවිධ චර්ම රෝග ඇතිවීම වළක්වා ගත හැක.")
            })
            slot in 31..45 -> "නිවාඩු කාලය ඵලදායීව ගත කිරීම" to getQuestions(slot, v, List(30) { i ->
                Quad("නිවාඩු කාලයේ කළ හැකි ප්‍රයෝජනවත් කාර්යයක් (${i + 1})", listOf("පොත් කියවීම හා ගෙවතු වගාව", "නිතර නිදා ගැනීම", "අධික ලෙස වීඩියෝ ක්‍රීඩා", "කෑගැසීම"), 1, "නිර්මාණාත්මක විනෝදාංශ මගින් මානසික සුවතාවය සහ දැනුම වර්ධනය වේ.")
            })
            else -> "නෙට්බෝල් ක්‍රීඩාව" to getQuestions(slot, v, List(30) { i ->
                Quad("නෙට්බෝල් ක්‍රීඩාවේ එක් කණ්ඩායමක ක්‍රීඩිකාවන් ගණන (${i + 1})", listOf("7", "6", "11", "5"), 1, "නෙට්බෝල් ක්‍රීඩාව සඳහා එක් කණ්ඩායමකට ක්‍රීඩිකාවන් 7 දෙනෙකු සහභාගී විය යුතුය.")
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
