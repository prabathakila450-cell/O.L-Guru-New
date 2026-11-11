package com.example

import androidx.compose.ui.graphics.Color

object SubjectMasterMaths20x20 {
  fun getCategories(): List<SubjectMasterCategory> {
    return SubjectMasterMathsPart1.getCategories() + SubjectMasterMathsPart2.getCategories()
  }
}
