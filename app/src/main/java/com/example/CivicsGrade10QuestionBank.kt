package com.example

/**
 * Grade 10 Civics Syllabus Question Bank for Live Exam Hall.
 * Covers Terms 1, 2, and 3 with 60 distinct syllabus topic slots per term.
 */
object CivicsGrade10QuestionBank {
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
            slot in 1..20 -> "සමාජය හා මානවයා" to getQuestions(slot, v, List(30) { i -> Quad("සමාජයේ ලක්ෂණයක් (${i+1})?", listOf("කණ්ඩායම් ජීවිතය", "හුදකලාව", "කෙටි බව", "ආයුධ"), 1, "සමාජයක පිරිස් කණ්ඩායම් ලෙස ජීවත් වෙයි.") })
            slot in 21..40 -> "පවුල" to getQuestions(slot, v, List(30) { i -> Quad("පවුලක මූලික අරමුණ (${i+1})?", listOf("ආරක්ෂාව", "මුදල්", "බලය", "සංගීතය"), 1, "පවුල සාමාජිකයන් ආරක්ෂා කරයි.") })
            else -> "ප්‍රජාතන්ත්‍රවාදය" to getQuestions(slot, v, List(30) { i -> Quad("ප්‍රජාතන්ත්‍රවාදයේ හරය (${i+1})?", listOf("ජනතා කැමැත්ත", "ආඥාදායකත්වය", "බලය", "ප්‍රචණ්ඩත්වය"), 1, "ජනතා කැමැත්ත ප්‍රජාතන්ත්‍රවාදයේ පදනමයි.") })
        }
        return MockExamQuestion(id = qNum, questionText = "ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm2Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..30 -> "නීතිය" to getQuestions(slot, v, List(30) { i -> Quad("නීතියේ වැදගත්කම (${i+1})?", listOf("සාමය රැකීම", "යුද්ධය", "බලය", "කෑම"), 1, "නීතිය සමාජයේ සාමය පවත්වයි.") })
            else -> "මානව හිමිකම්" to getQuestions(slot, v, List(30) { i -> Quad("මානව හිමිකමක් (${i+1})?", listOf("ජීවත් වීමේ අයිතිය", "ප්‍රචණ්ඩත්වය", "බලය", "දඬුවම්"), 1, "ජීවත් වීමේ අයිතිය මූලික මානව හිමිකමකි.") })
        }
        return MockExamQuestion(id = qNum, questionText = "ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)} • ප්‍රශ්නය $qNum: ${quad.q}", options = quad.opts, correctOption = quad.c, explanation = quad.exp, topicName = topic)
    }

    private fun getTerm3Question(paperIdx: Int, qNum: Int, slot: Int): MockExamQuestion {
        val v = paperIdx - 1
        val (topic, quad) = when {
            slot in 1..30 -> "ආර්ථිකය" to getQuestions(slot, v, List(30) { i -> Quad("ආර්ථික පද්ධතියක් (${i+1})?", listOf("වෙළඳාම", "ආයුධ", "යුද්ධය", "ගස"), 1, "වෙළඳාම ආර්ථිකයේ කොටසකි.") })
            else -> "පරිසරය" to getQuestions(slot, v, List(30) { i -> Quad("පරිසර සුරක්ෂිතතාව (${i+1})?", listOf("ගස් වැවීම", "කැපීම", "ඉඩම්", "ජලය"), 1, "ගස් වැවීම පරිසරයට හිතකරයි.") })
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
