package com.example

import androidx.compose.ui.graphics.Color

object SubjectMasterSinhala20x20 {
  fun getCategories(): List<SubjectMasterCategory> {
    return SubjectMasterSinhalaPart1.getCategories() + SubjectMasterSinhalaPart2.getCategories()
  }
}
