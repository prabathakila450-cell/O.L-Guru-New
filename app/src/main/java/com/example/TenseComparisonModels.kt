package com.example

/**
 * Model representing a single sentence compared across Past, Present, and Future tenses.
 * Both English sentences and Sinhala translations are provided for all 3 tenses.
 */
data class TenseSentenceItem(
  val id: String,
  val baseActionSinhala: String,
  // Past Tense
  val pastEnglish: String,
  val pastSinhala: String,
  // Present Tense
  val presentEnglish: String,
  val presentSinhala: String,
  // Future Tense
  val futureEnglish: String,
  val futureSinhala: String,
  // Key verb change / grammar tip
  val verbTransformation: String = ""
)

/**
 * Category grouping for 3-Tense sentence comparisons.
 */
data class TenseComparisonCategory(
  val id: Int,
  val titleSinhala: String,
  val titleEnglish: String,
  val icon: String,
  val description: String,
  val sentences: List<TenseSentenceItem>
)
