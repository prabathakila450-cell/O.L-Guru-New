package com.example

import androidx.compose.ui.graphics.Color

object SubjectMasterHistory20x20 {
  fun getCategories(): List<SubjectMasterCategory> {
    return SubjectMasterHistoryPart1.getCategories() + SubjectMasterHistoryPart2.getCategories()
  }
}
