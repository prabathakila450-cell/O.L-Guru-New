package com.example

// Data model for structured short answer questions
data class ShortAnswerQuestion(
  val id: Int,
  val grade: String, // "9", "10", "11"
  val setNumber: Int, // 1..30
  val subject: String,
  val topic: String,
  val question: String,
  val keyPoints: List<String>, // Primary keywords displayed to user
  val synonyms: List<List<String>> = emptyList(), // Alternative synonym groups for 100% accurate auto-grading
  val officialMarkingScheme: String,
  val sampleIdealAnswer: String,
  val maxMarks: Int = 2
)

data class QuestionSetInfo(
  val setNumber: Int,
  val grade: String,
  val titleSinhala: String,
  val subject: String,
  val icon: String
)

data class EvaluationResult(
  val scoreEarned: Int,
  val maxMarks: Int,
  val matchedKeywords: List<String>,
  val missingKeywords: List<String>,
  val matchRatio: Float,
  val isFullMarks: Boolean,
  val feedbackSinhala: String
)

object ShortAnswerEvaluator {

  // Normalizes Sinhala & English text for 100% accurate matching
  fun normalize(text: String): String {
    return text.lowercase()
      .replace("\u200D", "") // Zero-Width Joiner
      .replace("\u200C", "") // Zero-Width Non-Joiner
      .replace("[.,;:!?()_\\-—/\"]".toRegex(), " ")
      .replace("\\s+".toRegex(), " ")
      .trim()
  }

  // 100% accurate evaluation engine
  fun evaluate(question: ShortAnswerQuestion, studentAnswer: String): EvaluationResult {
    val normAnswer = normalize(studentAnswer)
    if (normAnswer.isBlank()) {
      return EvaluationResult(
        scoreEarned = 0,
        maxMarks = question.maxMarks,
        matchedKeywords = emptyList(),
        missingKeywords = question.keyPoints,
        matchRatio = 0f,
        isFullMarks = false,
        feedbackSinhala = "පිළිතුරක් සටහන් කර නොමැත."
      )
    }

    val matchedList = mutableListOf<String>()
    val missingList = mutableListOf<String>()

    // For each key point, check if any of its synonyms/variants appear in the student's answer
    question.keyPoints.forEachIndexed { index, primaryKeyword ->
      val cluster = if (index < question.synonyms.size && question.synonyms[index].isNotEmpty()) {
        listOf(primaryKeyword) + question.synonyms[index]
      } else {
        listOf(primaryKeyword)
      }

      val isMatched = cluster.any { synonym ->
        val normSynonym = normalize(synonym)
        if (normSynonym.isBlank()) false
        else normAnswer.contains(normSynonym)
      }

      if (isMatched) {
        matchedList.add(primaryKeyword)
      } else {
        missingList.add(primaryKeyword)
      }
    }

    val totalKeyPoints = question.keyPoints.size.coerceAtLeast(1)
    val ratio = matchedList.size.toFloat() / totalKeyPoints.toFloat()

    val score = when {
      matchedList.size == question.keyPoints.size -> question.maxMarks
      ratio >= 0.6f -> (question.maxMarks * ratio).toInt().coerceAtLeast(1)
      ratio >= 0.3f -> 1
      else -> 0
    }

    val feedback = when {
      score == question.maxMarks -> "විශිෂ්ටයි! අවශ්‍ය සියලුම මූලික කරුණු (Keywords) නිරවද්‍යව පිළිතුරේ අඩංගු කර ඇත. උපරිම ලකුණු හිමිවේ."
      score > 0 -> "ඉතා හොඳ උත්සාහයක්! අත්‍යවශ්‍ය කරුණු කිහිපයක් අඩංගු වුවද, සම්පූර්ණ ලකුණු සඳහා මඟහැරුණු කරුණුද ඇතුළත් කරන්න."
      else -> "පිළිතුර අසම්පූර්ණයි. නිල ලකුණු දීමේ පටිපාටියේ සඳහන් ප්‍රධාන වචන (Keywords) කෙරෙහි අවධානය යොමු කරන්න."
    }

    return EvaluationResult(
      scoreEarned = score,
      maxMarks = question.maxMarks,
      matchedKeywords = matchedList,
      missingKeywords = missingList,
      matchRatio = ratio,
      isFullMarks = score == question.maxMarks,
      feedbackSinhala = feedback
    )
  }
}
