package com.example

import androidx.compose.ui.graphics.Color

object SubjectMasterCommerce20x20 {
  fun getCategories(): List<SubjectMasterCategory> {
    return SubjectMasterCommercePart1.getCategories() + SubjectMasterCommercePart2.getCategories()
  }
}
