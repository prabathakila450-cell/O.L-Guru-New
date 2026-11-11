package com.example

import androidx.compose.ui.graphics.Color

enum class MathCategory(val displayName: String, val icon: String, val color: Color) {
  ALL("සියලු ඒකක (1-42)", "📚", Color(0xFF1E293B)),
  NUMBERS("සංඛ්‍යා හා මූලික ගණිතය", "🔢", Color(0xFF0284C7)),
  COMMERCIAL("වාණිජ ගණිතය", "💰", Color(0xFF16A34A)),
  ALGEBRA("වීජ ගණිතය & සමීකරණ", "🧮", Color(0xFF7C3AED)),
  PROGRESSIONS("ශ්‍රේඪි (සමාන්තර/ගුණෝත්තර)", "📈", Color(0xFFD97706)),
  GEOMETRY_MEASUREMENT("මිනුම් & ජ්‍යාමිතිය", "📐", Color(0xFFEA580C)),
  STATISTICS_PROBABILITY("සංඛ්‍යානය & සම්භාවිතාව", "📊", Color(0xFF0D9488))
}

enum class MathGradeFilter(val label: String) {
  ALL("සියල්ල (10 හා 11)"),
  GRADE_10("10 ශ්‍රේණිය"),
  GRADE_11("11 ශ්‍රේණිය")
}

data class MathWorkedExample(
  val question: String,
  val steps: List<String>,
  val finalAnswer: String
)

data class MathPracticeExercise(
  val questionNumber: String,
  val question: String,
  val options: List<String>? = null, // for MCQ type
  val correctAnswer: String,
  val explanation: String
)

data class MathUnitShortNote(
  val unitNumber: Int,
  val titleSinhala: String,
  val gradeTag: String,
  val category: MathCategory,
  val keyFormulas: List<String>,
  val theorySummary: String,
  val keyPoints: List<String>,
  val workedExamples: List<MathWorkedExample>,
  val practiceExercises: List<MathPracticeExercise>,
  val examTip: String
)
