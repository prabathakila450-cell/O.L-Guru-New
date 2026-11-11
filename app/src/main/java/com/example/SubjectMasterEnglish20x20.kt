package com.example

import androidx.compose.ui.graphics.Color

object SubjectMasterEnglish20x20 {
  fun getCategories(): List<SubjectMasterCategory> {
    return SubjectMasterEnglishPart1.getCategories() + SubjectMasterEnglishPart2.getCategories()
  }
}
