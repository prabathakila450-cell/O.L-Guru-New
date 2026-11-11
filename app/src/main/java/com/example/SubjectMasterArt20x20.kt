package com.example

object SubjectMasterArt20x20 {
  fun getCategories(): List<SubjectMasterCategory> {
    return SubjectMasterArtPart1.getCategories() + SubjectMasterArtPart2.getCategories()
  }
}
