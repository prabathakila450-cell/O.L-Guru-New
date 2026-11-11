package com.example

object SentencePuzzleRepository {
  private val categoriesList: List<SentencePuzzleCategory> by lazy {
    SentencePuzzleDataPart1.getCategoriesPart1() +
      SentencePuzzleDataPart2.getCategoriesPart2() +
      SentencePuzzleDataPart3.getCategoriesPart3()
  }

  fun getAllCategories(): List<SentencePuzzleCategory> {
    return categoriesList
  }

  fun getCategoryById(id: Int): SentencePuzzleCategory? {
    return categoriesList.find { it.id == id }
  }

  fun getTotalPuzzlesCount(): Int {
    return categoriesList.sumOf { it.puzzles.size }
  }

  fun getAllPuzzlesFlat(): List<SentencePuzzleItem> {
    return categoriesList.flatMap { it.puzzles }
  }
}
