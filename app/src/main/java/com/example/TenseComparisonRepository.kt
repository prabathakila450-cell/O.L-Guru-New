package com.example

object TenseComparisonRepository {
  private val categoriesList: List<TenseComparisonCategory> by lazy {
    TenseDataPart1.getCategoriesPart1() +
      TenseDataPart2.getCategoriesPart2() +
      TenseDataPart3.getCategoriesPart3() +
      TenseDataPart4.getCategoriesPart4() +
      TenseDataPart5.getCategoriesPart5() +
      TenseDataPart6.getCategoriesPart6() +
      TenseDataPart7.getCategoriesPart7()
  }

  fun getAllCategories(): List<TenseComparisonCategory> {
    return categoriesList
  }

  fun getCategoryById(id: Int): TenseComparisonCategory? {
    return categoriesList.find { it.id == id }
  }

  fun getTotalCategoriesCount(): Int {
    return categoriesList.size
  }

  fun getTotalSentencesCount(): Int {
    return categoriesList.sumOf { it.sentences.size }
  }

  fun searchSentences(query: String): List<Pair<TenseComparisonCategory, TenseSentenceItem>> {
    val q = query.trim().lowercase()
    if (q.isEmpty()) return emptyList()

    val results = mutableListOf<Pair<TenseComparisonCategory, TenseSentenceItem>>()
    for (cat in categoriesList) {
      for (s in cat.sentences) {
        if (s.baseActionSinhala.lowercase().contains(q) ||
          s.pastEnglish.lowercase().contains(q) ||
          s.pastSinhala.lowercase().contains(q) ||
          s.presentEnglish.lowercase().contains(q) ||
          s.presentSinhala.lowercase().contains(q) ||
          s.futureEnglish.lowercase().contains(q) ||
          s.futureSinhala.lowercase().contains(q) ||
          s.verbTransformation.lowercase().contains(q)
        ) {
          results.add(Pair(cat, s))
        }
      }
    }
    return results
  }
}
