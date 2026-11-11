package com.example

import androidx.compose.ui.graphics.Color

/**
 * Subject-specific 20-Category Fact Model.
 * Represents 20 categories per subject, each containing 20 high-yield,
 * accurate points aligned with the Sri Lankan G.C.E. O/L syllabus.
 */
data class SubjectFactPoint(
  val number: Int,
  val title: String,
  val detail: String,
  val examHighlight: String = ""
)

data class SubjectMasterCategory(
  val id: String,
  val categoryNumber: Int,
  val titleSinhala: String,
  val icon: String,
  val color: Color,
  val summary: String,
  val points: List<SubjectFactPoint>
)
