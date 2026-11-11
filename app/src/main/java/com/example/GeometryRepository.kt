package com.example

// ==============================================================================
// GEOMETRY STRUCTURED QUESTIONS REPOSITORY
// Aggregates 20 Categories x 20 Questions = 400 Total O/L Structured Geometry Questions
// ==============================================================================

object GeometryRepository {
  private var cachedCategories: List<GeometryCategory>? = null

  fun getAllCategories(): List<GeometryCategory> {
    if (cachedCategories == null) {
      cachedCategories = GeometryDataPart1.getCategories() +
          GeometryDataPart2.getCategories() +
          GeometryDataPart3.getCategories() +
          GeometryDataPart4.getCategories()
    }
    return cachedCategories ?: emptyList()
  }

  fun getCategoryById(id: Int): GeometryCategory? {
    return getAllCategories().find { it.categoryId == id }
  }

  fun getTotalQuestionCount(): Int {
    return getAllCategories().sumOf { it.questions.size }
  }

  fun getLegacyCategoryItems(): List<GeometryCategoryItem> {
    return getAllCategories().map { cat ->
      val firstQ = cat.questions.firstOrNull()
      GeometryCategoryItem(
        categoryId = cat.categoryId,
        titleSinhala = cat.titleSinhala,
        theoremConcept = cat.theoremConcept,
        gradeLevel = cat.gradeLevel,
        diagramType = cat.diagramType,
        structuredQuestionText = firstQ?.structuredQuestionText ?: "",
        givenData = firstQ?.givenData ?: "",
        toProve = firstQ?.toProve ?: "",
        construction = firstQ?.construction ?: "අවශ්‍ය නොවේ.",
        proofSteps = firstQ?.proofSteps ?: emptyList(),
        riderExplanation = firstQ?.riderExplanation ?: "",
        riderQuestions = if (firstQ != null) listOf(firstQ.riderQuestion) else emptyList(),
        examTips = firstQ?.examTips ?: ""
      )
    }
  }
}
