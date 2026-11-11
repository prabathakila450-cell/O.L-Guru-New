package com.example

/**
 * 100% Complete Grade 10 & 11 Science Syllabus Extended Repository
 * Central aggregator pulling from dedicated modular repositories:
 * 1. ScienceChemistryData (Equations, Balancing, Organic, Industrial, Redox)
 * 2. SciencePhysicsData (Formulas, Step-by-Step Numerical Solvers, Unit Converters)
 * 3. SciencePracticalsData (Apparatus, Precautions, Step-by-Step Lab Guides)
 * 4. ScienceBiologyData (Anatomy, Diagrams, Labels, Functions & Exam Questions)
 * 5. ScienceMcqData (Past Paper Model Rapid-Fire MCQs with Explanations)
 */
object ScienceSyllabusFullData {
  val allChemistryItems: List<ScienceChemItem>
    get() = ScienceChemistryData.items

  val allPhysicsItems: List<SciencePhysicsItem>
    get() = SciencePhysicsData.items

  val allPracticalItems: List<SciencePracticalItem>
    get() = SciencePracticalsData.items

  val allBiologyDiagrams: List<ScienceBiologyDiagramItem>
    get() = ScienceBiologyData.items

  val allMcqItems: List<ScienceRapidMcqItem>
    get() = ScienceMcqData.items
}
