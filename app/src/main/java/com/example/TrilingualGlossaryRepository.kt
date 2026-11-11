package com.example

object TrilingualGlossaryRepository {
  val allGlossaryTerms: List<GlossaryTermItem> by lazy {
    scienceGlossary100Terms + mathsGlossary100Terms + ictGlossary100Terms + commerceGlossary100Terms + humanitiesAndOtherGlossaryTerms
  }

  fun getSubjectTerms(subject: String): List<GlossaryTermItem> {
    return when {
      subject.contains("විද්‍යාව") -> scienceGlossary100Terms
      subject.contains("ගණිතය") -> mathsGlossary100Terms
      subject.contains("ICT") || subject.contains("තොරතුරු") -> ictGlossary100Terms
      subject.contains("වාණිජ") || subject.contains("Commerce") -> commerceGlossary100Terms
      subject.contains("ඉතිහාස") -> humanitiesAndOtherGlossaryTerms.filter { it.subject == "ඉතිහාසය" }
      subject.contains("පුරවැසි") -> humanitiesAndOtherGlossaryTerms.filter { it.subject == "පුරවැසි අධ්‍යාපනය" }
      subject.contains("භූගෝල") -> humanitiesAndOtherGlossaryTerms.filter { it.subject == "භූගෝල විද්‍යාව" }
      subject.contains("බුද්ධ") || subject.contains("ආගම") -> humanitiesAndOtherGlossaryTerms.filter { it.subject == "බුද්ධ ධර්මය" }
      subject.contains("English") || subject.contains("ඉංග්‍රීසි") -> humanitiesAndOtherGlossaryTerms.filter { it.subject == "English" }
      else -> allGlossaryTerms
    }
  }

  fun getGroupNumber(item: GlossaryTermItem): Int {
    val list = getSubjectTerms(item.subject)
    val idx = list.indexOfFirst { it.id == item.id }
    return if (idx >= 0) (idx / 10) + 1 else 1
  }

  fun getItemIndexInSubject(item: GlossaryTermItem): Int {
    val list = getSubjectTerms(item.subject)
    val idx = list.indexOfFirst { it.id == item.id }
    return if (idx >= 0) idx + 1 else 1
  }
}
