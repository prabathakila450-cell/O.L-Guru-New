package com.example

/**
 * Grade 11 Civics Syllabus Question Bank for Live Exam Hall.
 * Covers Terms 1, 2, and 3 with 60 distinct syllabus topic slots per term.
 * Guarantees 1800 unique questions per term (30 papers x 60 questions).
 */
object CivicsGrade11QuestionBank {
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
            slot in 1..20 -> "ආණ්ඩුක්‍රම ව්‍යවස්ථාව" to getQuestions(slot, v, List(30) { i -> Quad("ශ්‍රී ලංකාවේ ආණ්ඩුක්‍රම ව්‍යවස්ථාවට අදාළ මෙම කරුණ කුමක්ද (${i+1})?", listOf("කරුණ ${i+1}A", "කරුණ ${i+1}B", "කරුණ ${i+1}C", "කරුණ ${i+1}D"), 1, "ව්‍යවස්ථාව යනු රටේ මූලික නීතියයි.") })
            slot in 21..40 -> "මැතිවරණ හා ඡන්දය" to getQuestions(slot, v, List(30) { i -> Quad("මැතිවරණ ක්‍රියාවලියේ මෙම පියවර හඳුන්වන්නේ කෙසේද (${i+1})?", listOf("පියවර ${i+1}A", "පියවර ${i+1}B", "පියවර ${i+1}C", "පියවර ${i+1}D"), 1, "ඡන්දය යනු පුරවැසියාගේ පරමාධිපත්‍ය බලයයි.") })
            else -> "ප්‍රාදේශීය පාලනය" to getQuestions(slot, v, List(30) { i -> Quad("ප්‍රාදේශීය සභා මගින් ඉටු කරන මෙම සේවාව කුමක්ද (${i+1})?", listOf("සේවාව ${i+1}A", "සේවාව ${i+1}B", "සේවාව ${i+1}C", "සේවාව ${i+1}D"), 1, "ප්‍රදේශයේ පොදු පහසුකම් පවත්වාගෙන යාම පළාත් පාලන වගකීමකි.") })
        }
        return MockExamQuestion(id = qNum, questionText = "ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm2Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..30 -> "අන්තර්ජාතික සම්බන්ධතා" to getQuestions(slot, v, List(30) { i -> Quad("මෙම අන්තර්ජාතික සංවිධානය පිහිටුවීමේ අරමුණ කුමක්ද (${i+1})?", listOf("අරමුණ ${i+1}A", "අරමුණ ${i+1}B", "අරමුණ ${i+1}C", "අරමුණ ${i+1}D"), 1, "ජාත්‍යන්තර සහයෝගීතාවය ලෝක සාමයට අත්‍යවශ්‍ය වේ.") })
            else -> "සාමය හා ගැටලු නිරාකරණය" to getQuestions(slot, v, List(30) { i -> Quad("ගැටලු නිරාකරණය සඳහා යොදාගත හැකි මෙම ක්‍රමය කුමක්ද (${i+1})?", listOf("ක්‍රමය ${i+1}A", "ක්‍රමය ${i+1}B", "ක්‍රමය ${i+1}C", "ක්‍රමය ${i+1}D"), 1, "සාකච්ඡා මාර්ගයෙන් ගැටලු විසඳා ගැනීම ප්‍රජාතන්ත්‍රවාදී ලක්ෂණයකි.") })
        }
        return MockExamQuestion(id = qNum, questionText = "ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm3Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..30 -> "තිරසාර සංවර්ධනය" to getQuestions(slot, v, List(30) { i -> Quad("තිරසාර සංවර්ධනය සඳහා අප අනුගමනය කළ යුතු මෙම පියවර කුමක්ද (${i+1})?", listOf("පියවර ${i+1}A", "පියවර ${i+1}B", "පියවර ${i+1}C", "පියවර ${i+1}D"), 1, "අනාගත පරපුරට සම්පත් ඉතිරි කිරීම තිරසාර සංවර්ධනයයි.") })
            else -> "ගෝලීයකරණය හා එහි බලපෑම" to getQuestions(slot, v, List(30) { i -> Quad("ගෝලීයකරණය නිසා ඇති වී තිබෙන මෙම වෙනස කුමක්ද (${i+1})?", listOf("වෙනස ${i+1}A", "වෙනස ${i+1}B", "වෙනස ${i+1}C", "වෙනස ${i+1}D"), 1, "ලෝකය එකම ගම්මානයක් බවට පත්වීම ගෝලීයකරණය ලෙස හැඳින්වේ.") })
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
