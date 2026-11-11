package com.example

data class SentencePuzzleCategory(
  val id: Int,
  val titleSinhala: String,
  val titleEnglish: String,
  val icon: String = "🧩",
  val description: String,
  val puzzles: List<SentencePuzzleItem>
)
