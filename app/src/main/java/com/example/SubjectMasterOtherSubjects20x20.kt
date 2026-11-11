package com.example

object SubjectMasterOtherSubjects20x20 {
  fun getIctCategories(): List<SubjectMasterCategory> {
    return SubjectMasterIctFull.getCategories() + SubjectMasterIctPart2.getCategories()
  }

  fun getDancingCategories(): List<SubjectMasterCategory> {
    return SubjectMasterDancingFull.getCategories()
  }
}

