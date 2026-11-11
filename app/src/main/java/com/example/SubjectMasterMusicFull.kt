package com.example

import androidx.compose.ui.graphics.Color

object SubjectMasterMusicFull {
  fun getCategories(): List<SubjectMasterCategory> {
    return SubjectMasterMusicPart1.getCategories() + SubjectMasterMusicPart2.getCategories()
  }
}
