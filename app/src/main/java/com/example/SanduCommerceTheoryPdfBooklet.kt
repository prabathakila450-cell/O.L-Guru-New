package com.example

import androidx.compose.ui.graphics.Color

/**
 * Sandu Theory - O/L Commerce & Accounting (ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය)
 * Grades 10 & 11 Short Notes Complete Mindmap & Theory Booklet (76 Pages)
 */
data class SanduCommercePageItem(
  val pageNumber: Int,
  val chapterNumber: Int,
  val chapterTitleSinhala: String,
  val gradeLevel: String, // "10", "11", or "10 & 11"
  val rootConcept: String,
  val pageSections: List<SanduCommerceSection>,
  val comparisonTable: SanduCommerceTable? = null,
  val examKeyPoints: List<String> = emptyList()
)

data class SanduCommerceSection(
  val title: String,
  val subtitle: String? = null,
  val type: SanduCommerceSectionType = SanduCommerceSectionType.THEORY_CARD,
  val bullets: List<String> = emptyList(),
  val definition: String? = null,
  val examples: List<String> = emptyList(),
  val subBoxes: List<SanduCommerceSubBox> = emptyList()
)

data class SanduCommerceSubBox(
  val header: String,
  val body: String,
  val tag: String? = null
)

data class SanduCommerceTable(
  val title: String,
  val col1Header: String,
  val col2Header: String,
  val rows: List<Pair<String, String>>
)

enum class SanduCommerceSectionType(val badgeText: String, val color: Color) {
  THEORY_CARD("සිද්ධාන්ත සංකල්පය", Color(0xFF00695C)),
  MINDMAP_BRANCH("ශාඛා සටහන", Color(0xFF0284C7)),
  COMPARISON("සංසන්දනය", Color(0xFF7C3AED)),
  PROCESS_STEPS("ක්‍රියා පටිපාටිය", Color(0xFFD97706)),
  LEGAL_ACTS("නීති රීති & පනත්", Color(0xFFC026D3)),
  EXAM_SUMMARY("විභාග විශේෂ සාරාංශය", Color(0xFFDC2626))
}

object SanduCommerceTheoryBookletRepository {

  val chapterPageRanges: Map<Int, Pair<String, IntRange>> = mapOf(
    1 to Pair("ව්‍යාපාරය සහ එහි සංවර්ධනය", 1..3),
    2 to Pair("සේවා සැපයීමේ ව්‍යාපාර & ඇල්මැති පාර්ශව", 4..5),
    3 to Pair("ව්‍යාපාර පරිසරය සහ SWOT විශ්ලේෂණය", 6..8),
    4 to Pair("බාහිර පරිසර සාධක (දේශපාලන, නීති, තාක්ෂණ, ආර්ථික)", 9..13),
    5 to Pair("ගෝලීයකරණය සහ ව්‍යාපාරික බලපෑම්", 14..14),
    6 to Pair("ව්‍යාපාර සංවිධාන (ඒක පුද්ගල, හවුල්, සමාගම්, සමුපකාර, පොදු)", 15..28),
    7 to Pair("ව්‍යාපාර සංවිධාන ක්‍රමයක් තෝරාගැනීම", 29..31),
    8 to Pair("ගිණුම්කරණය සහ ගිණුම්කරණ සමීකරණය", 32..32),
    9 to Pair("ව්‍යාපාරික ගනුදෙනු, වත්කම්, වගකීම් සහ හිමිකම්", 33..34),
    10 to Pair("ගිණුම, ද්විත්ව සටහන් න්‍යාය සහ ලෙජරය", 35..36),
    11 to Pair("මූලික සටහන් පොත් සහ මූලාශ්‍ර ලේඛන", 37..38),
    12 to Pair("මුදල් පොත සහ වට්ටම් (වෙළඳ හා මුදල් වට්ටම්)", 39..40),
    13 to Pair("සුළු මුදල් පොත, අග්‍රිමය සහ ප්‍රතිපූරණය", 41..42),
    14 to Pair("බැංකු ප්‍රකාශනය සහ බැංකු සැසඳුම් ප්‍රකාශනය", 42..44),
    15 to Pair("ජර්නල, ගැලපුම්, දෝෂ නිවැරදි කිරීම & පරිගණක ගිණුම්කරණය", 44..45),
    16 to Pair("ශේෂ පිරික්සුම, ගිණුම්කරණ වැරදි සහ අවිනිශ්චිත ගිණුම", 46..47),
    17 to Pair("වෙළඳාම (දේශීය, විදේශීය, සිල්ලර සහ තොග)", 48..50),
    18 to Pair("වාණිජ බැංකු, තැන්පතු, චෙක්පත්, කාඩ්පත් සහ ඊ-මුදල්", 51..56),
    19 to Pair("රක්ෂණය (අවදානම්, මූලධර්ම සහ රක්ෂණ වර්ග)", 56..57),
    20 to Pair("සන්නිවේදනය (ක්‍රියාවලිය, මූලිකාංග සහ මාධ්‍ය)", 58..59),
    21 to Pair("ප්‍රවාහනය (මූලිකාංග, මාර්ග, දුම්රිය සහ ගුවන් ප්‍රවාහනය)", 60..61),
    22 to Pair("කළමනාකරණය (සැලසුම්, සංවිධාන, මෙහෙයවීම, පාලනය)", 62..62),
    23 to Pair("අලෙවිකරණය සහ අලෙවි මිශ්‍රය (4Ps)", 63..64),
    24 to Pair("මූල්‍ය ප්‍රකාශන, ගැලපුම්, උපචිත, බොල් ණය සහ ක්ෂයවීම්", 65..67),
    25 to Pair("ලාභ අරමුණු කර නොගත් සංවිධාන (ලැබීම් ගෙවීම් & සමුච්චිත අරමුදල)", 68..69),
    26 to Pair("නිෂ්පාදන පිරිවැය, මූලිකාංග සහ පැතුරුම්පත් (Excel)", 70..72),
    27 to Pair("ආයෝජනය, කොටස් වෙළඳපොළ, සුරැකුම්පත් (බිල්පත්, බැඳුම්කර, SEC)", 72..76)
  )

  val pages: List<SanduCommercePageItem> by lazy {
    generateAll76Pages()
  }

  fun getPage(pageNumber: Int): SanduCommercePageItem? {
    return pages.getOrNull((pageNumber - 1).coerceIn(0, pages.size - 1))
  }

  fun searchPages(query: String): List<SanduCommercePageItem> {
    if (query.isBlank()) return pages
    val q = query.trim()
    val pageNum = q.toIntOrNull()
    return pages.filter { page ->
      page.pageNumber == pageNum ||
        page.rootConcept.contains(q, ignoreCase = true) ||
        page.chapterTitleSinhala.contains(q, ignoreCase = true) ||
        page.pageSections.any { sec ->
          sec.title.contains(q, ignoreCase = true) ||
            sec.definition?.contains(q, ignoreCase = true) == true ||
            sec.bullets.any { it.contains(q, ignoreCase = true) } ||
            sec.examples.any { it.contains(q, ignoreCase = true) }
        }
    }
  }

  private fun generateAll76Pages(): List<SanduCommercePageItem> {
    val list = mutableListOf<SanduCommercePageItem>()
    list.addAll(SanduCommerceTheoryPagesPart1.pages)
    list.addAll(SanduCommerceTheoryPagesPart2.pages)
    list.addAll(SanduCommerceTheoryPagesPart3.pages)
    return list.sortedBy { it.pageNumber }
  }
}
