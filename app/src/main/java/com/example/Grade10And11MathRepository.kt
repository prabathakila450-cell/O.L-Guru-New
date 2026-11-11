package com.example

object Grade10And11MathRepository {
  val allUnits: List<MathUnitShortNote> by lazy {
    Grade10And11MathDataPart1.units + Grade10And11MathDataPart2.units
  }

  fun getUnits(
    gradeFilter: MathGradeFilter = MathGradeFilter.ALL,
    categoryFilter: MathCategory = MathCategory.ALL,
    searchQuery: String = ""
  ): List<MathUnitShortNote> {
    return allUnits.filter { unit ->
      val matchesGrade = when (gradeFilter) {
        MathGradeFilter.ALL -> true
        MathGradeFilter.GRADE_10 -> unit.gradeTag.contains("10")
        MathGradeFilter.GRADE_11 -> unit.gradeTag.contains("11")
      }

      val matchesCategory = (categoryFilter == MathCategory.ALL || unit.category == categoryFilter)

      val matchesSearch = if (searchQuery.isBlank()) true else {
        unit.titleSinhala.contains(searchQuery, ignoreCase = true) ||
          unit.unitNumber.toString() == searchQuery.trim() ||
          unit.theorySummary.contains(searchQuery, ignoreCase = true) ||
          unit.keyFormulas.any { it.contains(searchQuery, ignoreCase = true) }
      }

      matchesGrade && matchesCategory && matchesSearch
    }
  }

  fun getUnitByNumber(unitNumber: Int): MathUnitShortNote? {
    return allUnits.firstOrNull { it.unitNumber == unitNumber }
  }
}
