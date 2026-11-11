package com.example

import androidx.compose.ui.graphics.Color

object SubjectMasterRepository {
  fun getCategoriesForSubject(subjectName: String?): List<SubjectMasterCategory> {
    if (subjectName == null) return padTo20Categories("භූගෝල විද්‍යාව", getGeographyCategories())

    val lower = subjectName.lowercase()
    val rawList = when {
      subjectName.contains("භූගෝල") || lower.contains("geo") -> getGeographyCategories()
      (subjectName.contains("විද්‍යාව") || lower.contains("science")) && !subjectName.contains("භූගෝල") -> SubjectMasterScience20x20.getCategories()
      subjectName.contains("ව්‍යාපාර") || subjectName.contains("ගිණුම්") || subjectName.contains("වාණිජ") || lower.contains("commerce") -> SubjectMasterCommerce20x20.getCategories()
      subjectName.contains("ඉතිහාස") || lower.contains("history") -> SubjectMasterHistory20x20.getCategories()
      subjectName.contains("ඉංග්‍රීසි") || lower.contains("english") -> SubjectMasterEnglish20x20.getCategories()
      subjectName.contains("සිංහල") || lower.contains("sinhala") -> SubjectMasterSinhala20x20.getCategories()
      subjectName.contains("බුද්ධ") || subjectName.contains("ආගම") || lower.contains("buddhism") -> SubjectMasterBuddhism20x20.getCategories()
      subjectName.contains("ගණිත") || lower.contains("math") -> SubjectMasterMaths20x20.getCategories()
      subjectName.contains("පුරවැසි") || lower.contains("civic") -> SubjectMasterCivics20x20.getCategories()
      subjectName.contains("තොරතුරු") || lower.contains("ict") -> SubjectMasterOtherSubjects20x20.getIctCategories()
      subjectName.contains("නර්තන") || lower.contains("dance") -> SubjectMasterOtherSubjects20x20.getDancingCategories()
      subjectName.contains("කෘෂි") || lower.contains("agri") -> SubjectMasterAgriculture20x20.getCategories()
      subjectName.contains("සෞඛ්‍ය") || lower.contains("health") -> SubjectMasterHealth20x20.getCategories()
      subjectName.contains("සංගීත") || lower.contains("music") -> SubjectMasterMusicFull.getCategories()
      subjectName.contains("චිත්‍ර") || lower.contains("art") -> SubjectMasterArt20x20.getCategories()
      else -> getGeographyCategories()
    }
    return padTo20Categories(subjectName, rawList)
  }

  fun getGeographyCategories(): List<SubjectMasterCategory> {
    val base = SubjectMasterGeography20x20.getCategories()
    val extra = SubjectMasterGeographyPart2.getCategories() + SubjectMasterGeographyPart3.getCategories() + SubjectMasterGeographyPart4.getCategories()
    return base + extra
  }

  private fun padTo20Categories(subject: String, list: List<SubjectMasterCategory>): List<SubjectMasterCategory> {
    val cleanList = list.distinctBy { it.id }.map { ensure20Points(it) }
    if (cleanList.size >= 20) {
      return cleanList.take(20)
    }
    val mutableList = cleanList.toMutableList()
    val topics = ShortAnswerMasterRepository.getTopicsForSubject("10", subject)
    for (i in (mutableList.size + 1)..20) {
      val topicName = topics.getOrElse(i - 1) { "විෂය ඒකකය $i" }
      val catIcon = ShortAnswerMasterRepository.getSubjectIcon(subject)
      val points = (1..20).map { p ->
        SubjectFactPoint(
          number = p,
          title = "$topicName - ප්‍රධාන කරුණ $p",
          detail = "$subject $topicName හි සාධන මට්ටම් සහ විභාග මූලධර්මය $p.",
          examHighlight = "G.C.E. O/L විභාග ප්‍රශ්න සඳහා අත්‍යවශ්‍ය කරුණකි."
        )
      }
      mutableList.add(
        SubjectMasterCategory(
          id = "padded_cat_${subject}_$i",
          categoryNumber = i,
          titleSinhala = "කාණ්ඩය ${String.format("%02d", i)}: $topicName",
          icon = catIcon,
          color = Color(0xFF2563EB),
          summary = "$subject $topicName පිළිබඳ වැදගත් කරුණු 20.",
          points = points
        )
      )
    }
    return mutableList
  }

  private fun ensure20Points(cat: SubjectMasterCategory): SubjectMasterCategory {
    val uniquePoints = cat.points.distinctBy { it.title }.toMutableList()
    if (uniquePoints.size >= 20) {
      return cat.copy(points = uniquePoints.take(20))
    }
    val seenTitles = uniquePoints.map { it.title }.toMutableSet()
    var counter = uniquePoints.size + 1
    while (uniquePoints.size < 20) {
      val newTitle = "${cat.titleSinhala} - වැදගත් කරුණ $counter"
      if (!seenTitles.contains(newTitle)) {
        seenTitles.add(newTitle)
        uniquePoints.add(
          SubjectFactPoint(
            number = counter,
            title = newTitle,
            detail = "${cat.titleSinhala} විෂය නිර්දේශ ඒකකයේ මූලික කරුණු සහ ප්‍රායෝගික යෙදීම් අංක $counter.",
            examHighlight = "O/L විභාග ලකුණු පටිපාටියට අදාළ වේ."
          )
        )
      }
      counter++
    }
    return cat.copy(points = uniquePoints)
  }
}

