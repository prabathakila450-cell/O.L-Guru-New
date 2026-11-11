package com.example

object SubjectMasterCivics20x20 {
  fun getCategories(): List<SubjectMasterCategory> {
    return SubjectMasterCivicsPart1.getCategories() + SubjectMasterCivicsPart2.getCategories()
  }
}
