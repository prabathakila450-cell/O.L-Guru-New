package com.example

object SubjectMasterBuddhism20x20 {
  fun getCategories(): List<SubjectMasterCategory> {
    return SubjectMasterBuddhismPart1.getCategories() +
           SubjectMasterBuddhismPart2.getCategories() +
           SubjectMasterBuddhismPart3.getCategories() +
           SubjectMasterBuddhismPart4.getCategories()
  }
}
