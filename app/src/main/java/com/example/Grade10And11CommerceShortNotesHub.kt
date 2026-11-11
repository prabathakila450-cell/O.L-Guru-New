package com.example

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

enum class CommerceGradeFilter(val labelSinhala: String) {
  ALL("සියල්ල (10 & 11)"),
  GRADE_10("10 ශ්‍රේණිය"),
  GRADE_11("11 ශ්‍රේණිය")
}

enum class CommerceCategoryFilter(val labelSinhala: String, val iconEmoji: String) {
  ALL("සියලු පාඩම් (27)", "📚"),
  BIZ_ENV("ව්‍යාපාර පරිසරය", "🌍"),
  BIZ_ORG("ව්‍යාපාර සංවිධාන", "🏢"),
  ACCOUNTING_CORE("ගිණුම්කරණය & ද්විත්ව සටහන්", "⚖️"),
  PRIME_BOOKS("මූලික සටහන් පොත්", "📖"),
  TRADE_BANKING("වෙළඳාම & බැංකු", "🏦"),
  MANAGEMENT("කළමනාකරණය", "👔"),
  FINANCIAL_REPORTS("මූල්‍ය ප්‍රකාශන & ආයෝජන", "📊")
}

data class CommerceChapterSummary(
  val chapterNumber: Int,
  val title: String,
  val gradeLevel: String,
  val category: CommerceCategoryFilter,
  val pageRange: IntRange,
  val rootConcept: String,
  val highlights: List<String>,
  val legalAct: String? = null,
  val hasTable: Boolean = false
)

object CommerceChapterRepository {
  val chapters: List<CommerceChapterSummary> = listOf(
    CommerceChapterSummary(
      chapterNumber = 1,
      title = "ව්‍යාපාරය සහ එහි සංවර්ධනය",
      gradeLevel = "10",
      category = CommerceCategoryFilter.BIZ_ENV,
      pageRange = 1..3,
      rootConcept = "මිනිස් අවශ්‍යතා, උවමනා, නිෂ්පාදන සාධක (භූමිය, ශ්‍රමය, ප්‍රාග්ධනය, ව්‍යවසායකත්වය)",
      highlights = listOf(
        "අවශ්‍යතා (ආහාර, ඇඳුම්, නිවාස, සෞඛ්‍ය, අධ්‍යාපනය) අසීමිත නොවේ, පොදුය",
        "උවමනා විවිධාකාරය, වෙනස් වේ, සීමාරහිතය",
        "නිෂ්පාදන සාධක සහ ඒවායේ ප්‍රතිලාභ: භූමිය - බද්ද, ශ්‍රමය - වැටුප්, ප්‍රාග්ධනය - පොලිය, ව්‍යවසායකත්වය - ලාභය"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 2,
      title = "සේවා සැපයීමේ ව්‍යාපාර & ඇල්මැති පාර්ශව",
      gradeLevel = "10",
      category = CommerceCategoryFilter.BIZ_ENV,
      pageRange = 4..5,
      rootConcept = "සේවාවල ලක්ෂණ (අස්පර්ශනීය, විනාශවනසුලු, වෙන්කළ නොහැකි) සහ ඇල්මැති පාර්ශව",
      highlights = listOf(
        "සේවාවල ලක්ෂණ: අස්පර්ශනීය බව, විනාශවනසුලු බව, විවිධත්වය, අයිතිය පැවරිය නොහැකි බව",
        "අභ්‍යන්තර ඇල්මැති පාර්ශව: අයිතිකරුවන්, කළමනාකරුවන්, සේවකයින්",
        "බාහිර ඇල්මැති පාර්ශව: ගනුදෙනුකරුවන්, සැපයුම්කරුවන්, මූල්‍ය ආයතන, රජය, මහජනතාව"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 3,
      title = "ව්‍යාපාර පරිසරය සහ SWOT විශ්ලේෂණය",
      gradeLevel = "10",
      category = CommerceCategoryFilter.BIZ_ENV,
      pageRange = 6..8,
      rootConcept = "අභ්‍යන්තර පරිසරය (ශක්තීන්, දුර්වලතා) සහ බාහිර පරිසරය (අවස්ථා, තර්ජන)",
      highlights = listOf(
        "අභ්‍යන්තර පරිසරය: පාලනය කළ හැකි සාධක (ශක්තීන් - Strengths, දුර්වලතා - Weaknesses)",
        "බාහිර පරිසරය: පාලනය කළ නොහැකි සාධක (අවස්ථා - Opportunities, තර්ජන - Threats)",
        "SWOT විශ්ලේෂණය මඟින් උපායමාර්ගික තීරණ ගැනීම"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 4,
      title = "බාහිර පරිසර සාධක (PEST)",
      gradeLevel = "10",
      category = CommerceCategoryFilter.BIZ_ENV,
      pageRange = 9..13,
      rootConcept = "දේශපාලන, ආර්ථික, සමාජීය, තාක්ෂණික, නීතිමය සහ ස්වභාවික පරිසර සාධක",
      highlights = listOf(
        "දේශපාලන & නීතිමය: බදු ප්‍රතිපත්ති, පාරිභෝගික ආරක්ෂණ නීති, දේශපාලන ස්ථාවරත්වය",
        "ආර්ථික පරිසරය: පොලී අනුපාත, උද්ධමනය, විනිමය අනුපාත, පුද්ගල ආදායම් මට්ටම",
        "තාක්ෂණික පරිසරය: ඊ-වාණිජ්‍යය, ස්වයංක්‍රීයකරණය, කෘත්‍රිම බුද්ධිය සහ ඩිජිටල් ගෙවීම්"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 5,
      title = "ගෝලීයකරණය සහ ව්‍යාපාරික බලපෑම්",
      gradeLevel = "10",
      category = CommerceCategoryFilter.BIZ_ENV,
      pageRange = 14..14,
      rootConcept = "මුළු ලෝකයම එක් ගම්මානයක් බවට පත්වීම සහ ජාත්‍යන්තර වෙළඳ බාධක ලිහිල් වීම",
      highlights = listOf(
        "වාසි: පුළුල් වෙළඳපල, නවීන තාක්ෂණය, විදේශ ආයෝජන (FDI), රැකියා උත්පාදනය",
        "අවාසි: දේශීය සුළු පරිමාණ ව්‍යාපාර බිඳවැටීම, සංස්කෘතික පරිහානිය, මොළය ගලායාම"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 6,
      title = "ව්‍යාපාර සංවිධාන (ඒක පුද්ගල, හවුල්, සමාගම්, සමුපකාර)",
      gradeLevel = "10",
      category = CommerceCategoryFilter.BIZ_ORG,
      pageRange = 15..28,
      rootConcept = "හිමිකාරිත්වය අනුව වර්ගීකරණය: අසීමිත වගකීම සහ සීමිත වගකීම, නෛතික පෞරුෂය",
      highlights = listOf(
        "ඒක පුද්ගල: තනි අයිතිකරු, අසීමිත වගකීම, ලියාපදිංචිය 1918 අංක 06 ආඥාපනත",
        "හවුල්: සාමාජිකයින් 2-20, අසීමිත වගකීම, 1890 හවුල් ආඥාපනත සහ වැළැක්වීමේ ප්‍රඥප්තිය",
        "සමාගම්: 2007 අංක 07 සමාගම් පනත, කොටස්කරුවන්ගේ වගකීම ආයෝජනයට සීමිතයි, ස්වාධීන නෛතික පැවැත්ම"
      ),
      legalAct = "2007 අංක 07 සමාගම් පනත & 1890 හවුල් ආඥාපනත",
      hasTable = true
    ),
    CommerceChapterSummary(
      chapterNumber = 7,
      title = "ව්‍යාපාර සංවිධාන ක්‍රමයක් තෝරාගැනීම",
      gradeLevel = "10",
      category = CommerceCategoryFilter.BIZ_ORG,
      pageRange = 29..31,
      rootConcept = "ප්‍රාග්ධන අවශ්‍යතාවය, අවදානම් ප්‍රමාණය, පාලන නම්‍යශීලී බව සහ ව්‍යාපාරයේ ස්වභාවය",
      highlights = listOf(
        "සැලකිලිමත් විය යුතු සාධක: අවශ්‍ය ප්‍රාග්ධනය, නීතිමය රෙගුලාසි, හිමිකරුගේ වගකීම, රහස්‍යභාවය",
        "කුඩා පරිමාණයට ඒක පුද්ගල සුදුසු වන අතර මහා පරිමාණයට සංස්ථාපිත සමාගම් වඩාත් යෝග්‍ය වේ"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 8,
      title = "ගිණුම්කරණය සහ ගිණුම්කරණ සමීකරණය",
      gradeLevel = "10 & 11",
      category = CommerceCategoryFilter.ACCOUNTING_CORE,
      pageRange = 32..32,
      rootConcept = "වත්කම් = හිමිකම + වගකීම් (Assets = Owner's Equity + Liabilities)",
      highlights = listOf(
        "වත්කම් (A): ව්‍යාපාරය සතු අනාගත ආර්ථික ප්‍රතිලාභ ගෙනදෙන සම්පත්",
        "හිමිකම (OE): ව්‍යාපාරයේ වත්කම් කෙරෙහි අයිතිකරුට ඇති අයිතිවාසිකම",
        "වගකීම් (L): බාහිර පාර්ශවයන්ට ගෙවීමට ඇති බැඳීම් (ණයහිමියන්, බැංකු ණය)"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 9,
      title = "ව්‍යාපාරික ගනුදෙනු, වත්කම්, වගකීම් සහ හිමිකම්",
      gradeLevel = "10 & 11",
      category = CommerceCategoryFilter.ACCOUNTING_CORE,
      pageRange = 33..34,
      rootConcept = "මුදල් හා ණය ගනුදෙනු, ආදායම්, වියදම් සහ ගැනිලි මඟින් හිමිකමට සිදුවන බලපෑම්",
      highlights = listOf(
        "හිමිකම වැඩි කරන සාධක: අමතර ප්‍රාග්ධනය, උපයන ආදායම්",
        "හිමිකම අඩු කරන සාධක: ගැනිලි (Drawings), මෙහෙයුම් වියදම්",
        "ගනුදෙනුවක් නිසා සමීකරණයේ සමතුලිතතාවය කිසිවිටෙකත් බිඳ නොවැටේ"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 10,
      title = "ගිණුම, ද්විත්ව සටහන් න්‍යාය සහ ලෙජරය",
      gradeLevel = "10 & 11",
      category = CommerceCategoryFilter.ACCOUNTING_CORE,
      pageRange = 35..36,
      rootConcept = "සෑම ගනුදෙනුවකටම සමාන හර (Debit) හා බැර (Credit) අගයන් දෙකක් පැවතීම",
      highlights = listOf(
        "වත්කම් හා වියදම්: වැඩිවීම -> හර (Dr) | අඩුවීම -> බැර (Cr)",
        "හිමිකම, වගකීම් හා ආදායම්: වැඩිවීම -> බැර (Cr) | අඩුවීම -> හර (Dr)",
        "T ගිණුම් ආකෘතිය සහ ප්‍රධාන ලෙජරය (General Ledger)"
      ),
      hasTable = true
    ),
    CommerceChapterSummary(
      chapterNumber = 11,
      title = "මූලික සටහන් පොත් සහ මූලාශ්‍ර ලේඛන",
      gradeLevel = "10 & 11",
      category = CommerceCategoryFilter.PRIME_BOOKS,
      pageRange = 37..38,
      rootConcept = "ගනුදෙනුව මුලින්ම සටහන් කරන පොත් (Books of Prime Entry) සහ ආධාරක ලේඛන",
      highlights = listOf(
        "ගැනුම් ජර්නලය -> සැපයුම්කරුගේ ඉන්වොයිසිය (Purchases Invoice)",
        "විකුණුම් ජර්නලය -> ගැනුම්කරුට නිකුත් කළ ඉන්වොයිස් පිටපත (Sales Invoice)",
        "ගැනුම් ආපසු -> හර සටහන (Debit Note) | විකුණුම් ආපසු -> බැර සටහන (Credit Note)",
        "මුදල් පොත -> රිසිට්පත්, චෙක්පත් ප්‍රතිපත් සහ ගෙවුම් වවුචර්"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 12,
      title = "මුදල් පොත සහ වට්ටම් (වෙළඳ හා මුදල් වට්ටම්)",
      gradeLevel = "10 & 11",
      category = CommerceCategoryFilter.PRIME_BOOKS,
      pageRange = 39..40,
      rootConcept = "ද්වි තීරු සහ ත්‍රි තීරු මුදල් පොත (මුදල්, බැංකු, වට්ටම් තීරු)",
      highlights = listOf(
        "වෙළඳ වට්ටම: ඉන්වොයිස් මිලෙන් අඩු කර ශුද්ධ අගය සටහන් කරයි (ගිණුම් පොත්වල වෙනම නොපෙනේ)",
        "මුදල් වට්ටම: ඉක්මනින් ණය පියවීම දිරිගැන්වීමට දෙන වට්ටම (දුන් වට්ටම් Dr, ලැබුණු වට්ටම් Cr)",
        "සම්මුඛ සටහන් (Contra Entries): මුදල් බැංකුවේ තැන්පත් කිරීම සහ ව්‍යාපාර අවශ්‍යතාවයට බැංකුවෙන් මුදල් ගැනීම"
      ),
      hasTable = true
    ),
    CommerceChapterSummary(
      chapterNumber = 13,
      title = "සුළු මුදල් පොත, අග්‍රිමය සහ ප්‍රතිපූරණය",
      gradeLevel = "10 & 11",
      category = CommerceCategoryFilter.PRIME_BOOKS,
      pageRange = 41..42,
      rootConcept = "සුළු වියදම් සඳහා වෙන්කළ ස්ථාවර අග්‍රිමය ක්‍රමය (Imprest System)",
      highlights = listOf(
        "අග්‍රිමය (Imprest Amount): කාලපරිච්ඡේදය ආරම්භයේ ප්‍රධාන මුදල් අයකැමි විසින් ලබාදෙන ස්ථාවර මුදල",
        "ප්‍රතිපූරණය (Reimbursement): වියදම් කළ මුදලට සමාන මුදලක් නැවත ලබාදී අග්‍රිමය යථා තත්ත්වයට පත් කිරීම",
        "විශ්ලේෂණ තීරු: තැපැල්, ගමන් වියදම්, ලිපිද්‍රව්‍ය, තේ පැන්, විවිධ වියදම්"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 14,
      title = "බැංකු ප්‍රකාශනය සහ බැංකු සැසඳුම් ප්‍රකාශනය",
      gradeLevel = "10 & 11",
      category = CommerceCategoryFilter.PRIME_BOOKS,
      pageRange = 42..44,
      rootConcept = "මුදල් පොතේ බැංකු තීරුවේ ශේෂය සහ බැංකු ප්‍රකාශනයේ ශේෂය අතර වෙනස්කම් සැසඳීම",
      highlights = listOf(
        "වෙනස්කම් වලට හේතු: ඉදිරිපත් නොකළ චෙක්පත්, තැන්පත් කළ නමුදු බැර නොවූ චෙක්පත්, සෘජු ලැබීම් (Direct Credits), බැංකු ගාස්තු",
        "පළමුව මුදල් පොත යාවත්කාලීන කිරීම -> දෙවනුව බැංකු සැසඳුම් ප්‍රකාශනය පිළියෙළ කිරීම"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 15,
      title = "පොදු ජර්නලය, ගැලපුම් සහ පරිගණක ගිණුම්කරණය",
      gradeLevel = "10 & 11",
      category = CommerceCategoryFilter.PRIME_BOOKS,
      pageRange = 44..45,
      rootConcept = "විශේෂ ජර්නලවල ඇතුළත් නොවන ගනුදෙනු සටහන් කිරීම සහ නවීන මෘදුකාංග",
      highlights = listOf(
        "පොදු ජර්නලයේ සටහන්: ව්‍යාපාර ආරම්භක සටහන්, ස්ථාවර වත්කම් ණයට ගැනීම/විකිණීම, වැරදි නිවැරදි කිරීම්",
        "පරිගණකගත ගිණුම්කරණ මෘදුකාංග: QuickBooks, Tally, Sage, Excel පැතුරුම්පත්"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 16,
      title = "ශේෂ පිරික්සුම, ගිණුම්කරණ වැරදි සහ අවිනිශ්චිත ගිණුම",
      gradeLevel = "10 & 11",
      category = CommerceCategoryFilter.PRIME_BOOKS,
      pageRange = 46..47,
      rootConcept = "ලෙජර ගිණුම්වල ගණිතමය නිවැරදිභාවය පරීක්ෂා කිරීම සහ ශේෂ පිරික්සුමට හසු නොවන වැරදි",
      highlights = listOf(
        "ශේෂ පිරික්සුමට හසු නොවන වැරදි 6: සම්පූර්ණයෙන් මඟහැරීමේ වැරදි, ප්‍රතිපක්ෂ වැරදි, මූලධර්ම වැරදි, මුල් සටහනේ වැරදි, පූරක වැරදි, ආදේශන වැරදි",
        "අවිනිශ්චිත ගිණුම (Suspense Account): එකතුව නොගැලපෙන විට තාවකාලිකව විෂමතාවය රඳවා තබන ගිණුම"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 17,
      title = "වෙළඳාම (දේශීය, විදේශීය, සිල්ලර සහ තොග)",
      gradeLevel = "10",
      category = CommerceCategoryFilter.TRADE_BANKING,
      pageRange = 48..50,
      rootConcept = "භාණ්ඩ හා සේවා හුවමාරු කිරීම, බෙදාහැරීමේ මාර්ග සහ අන්තර්ජාතික වෙළඳාම",
      highlights = listOf(
        "දේශීය වෙළඳාම: තොග වෙළඳාම සහ සිල්ලර වෙළඳාම",
        "විදේශ වෙළඳාම: ආනයන (Imports), අපනයන (Exports) සහ ප්‍රතිඅපනයන (Entrepot Trade)",
        "නූතන සිල්ලර ප්‍රවණතා: සුපිරි වෙළඳසැල්, ඊ-වාණිජ්‍යය (E-Commerce), ස්වයංක්‍රීය විකුණුම් යන්ත්‍ර (Vending Machines)"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 18,
      title = "වාණිජ බැංකු, තැන්පතු, චෙක්පත්, කාඩ්පත් සහ ඊ-මුදල්",
      gradeLevel = "10",
      category = CommerceCategoryFilter.TRADE_BANKING,
      pageRange = 51..56,
      rootConcept = "මූල්‍ය අතරමැදිකරණය, තැන්පතු වර්ග, චෙක්පත් රේඛනය සහ ඩිජිටල් බැංකුකරණය",
      highlights = listOf(
        "තැන්පතු: ඉතිරි කිරීමේ, ජංගම (චෙක්පත් පොත් හිමි), ස්ථාවර තැන්පතු",
        "චෙක්පත් රේඛනය: සාමාන්‍ය රේඛනය (& Co.) සහ විශේෂ රේඛනය (ගිණුම්ලාභියාට පමණයි - A/C Payee Only)",
        "ඊ-බැංකුකරණය: ATM, ඩෙබිට් කාඩ්පත්, ක්‍රෙඩිට් කාඩ්පත්, අන්තර්ජාල බැංකුකරණය, LankaQR"
      ),
      legalAct = "1988 අංක 30 දරන බැංකු පනත"
    ),
    CommerceChapterSummary(
      chapterNumber = 19,
      title = "රක්ෂණය (අවදානම්, මූලධර්ම සහ රක්ෂණ වර්ග)",
      gradeLevel = "10",
      category = CommerceCategoryFilter.TRADE_BANKING,
      pageRange = 56..57,
      rootConcept = "අවදානම හුවමාරු කරගැනීම, ජීවිත හා සාමාන්‍ය රක්ෂණය, රක්ෂණ මූලධර්ම 5",
      highlights = listOf(
        "මූලධර්ම 5: උපරිම විශ්වාසය, රක්ෂණය කළ හැකි උනන්දුව, හානිපූරණය, අනුප්‍රාප්තිය, දායකත්වය",
        "ජීවිත රක්ෂණය: හානිපූරණය කළ නොහැක (අගය කළ නොහැකි බැවින්), ආයෝජනයක් සහ ආරක්ෂාවකි",
        "සාමාන්‍ය රක්ෂණය: ගිනි, මෝටර් රථ, සමුද්‍ර සහ සොරකම් රක්ෂණ"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 20,
      title = "සන්නිවේදනය (ක්‍රියාවලිය, මූලිකාංග සහ මාධ්‍ය)",
      gradeLevel = "10",
      category = CommerceCategoryFilter.TRADE_BANKING,
      pageRange = 58..59,
      rootConcept = "පණිවිඩයක් සම්ප්‍රේෂණය කිරීම සහ ප්‍රතිචාර ලබාගැනීම (සන්නිවේදන චක්‍රය)",
      highlights = listOf(
        "සංරචක: ප්‍රේෂකයා -> කේතනය -> මාධ්‍යය -> විකේතනය -> ප්‍රතිග්‍රාහකයා -> ප්‍රතිපෝෂණය (Feedback)",
        "බාධා: භෞතික බාධා, මනෝවිද්‍යාත්මක බාධා, භාෂා බාධා, පරිසර ඝෝෂාව",
        "මාධ්‍ය: ලිඛිත, වාචික, දෘශ්‍ය සහ ඉලෙක්ට්‍රොනික සන්නිවේදනය (E-mail, Video Call)"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 21,
      title = "ප්‍රවාහනය (මූලිකාංග, මාර්ග, දුම්රිය සහ ගුවන්)",
      gradeLevel = "10",
      category = CommerceCategoryFilter.TRADE_BANKING,
      pageRange = 60..61,
      rootConcept = "ස්ථාන උපයෝගීතාවය නිර්මාණය කිරීම සහ භාණ්ඩ හා මගීන් ප්‍රවාහනය",
      highlights = listOf(
        "ප්‍රවාහන මූලිකාංග 4: මාර්ගය, බලය, පර්යන්තය, වාහනය",
        "මාර්ග ප්‍රවාහනය: ගෙයින් ගෙට සේවාව (Door-to-door), නම්‍යශීලී බව",
        "දුම්රිය හා සමුද්‍ර: විශාල බර භාණ්ඩ සඳහා අඩු පිරිවැය | ගුවන්: වේගවත්, වටිනා භාණ්ඩ සඳහා සුදුසුයි"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 22,
      title = "කළමනාකරණය (සැලසුම්, සංවිධාන, මෙහෙයවීම, පාලනය)",
      gradeLevel = "11",
      category = CommerceCategoryFilter.MANAGEMENT,
      pageRange = 62..62,
      rootConcept = "කාර්යක්ෂමව හා ඵලදායීව අරමුණු ඉටුකර ගැනීම සඳහා සම්පත් මෙහෙයවීම",
      highlights = listOf(
        "කාර්යයන් 4 (POLC): Planning (සැලසුම්කරණය), Organizing (සංවිධානකරණය), Leading (මෙහෙයවීම), Controlling (පාලනය)",
        "කළමනාකරණ මට්ටම්: ඉහළ මට්ටම (උපායමාර්ගික), මධ්‍යම මට්ටම (උපක්‍රමික), පහළ මට්ටම (මෙහෙයුම්)",
        "නායකත්ව ශෛලීන්: ඒකාධිපති (Autocratic), ප්‍රජාතන්ත්‍රවාදී (Democratic), නිර්බාධක (Laissez-faire)"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 23,
      title = "අලෙවිකරණය සහ අලෙවි මිශ්‍රය (4Ps)",
      gradeLevel = "11",
      category = CommerceCategoryFilter.MANAGEMENT,
      pageRange = 63..64,
      rootConcept = "පාරිභෝගික තෘප්තිය උපරිම කරමින් ලාභ ඉපැයීමේ සමස්ත ක්‍රියාවලිය",
      highlights = listOf(
        "අලෙවි මිශ්‍රය 4Ps: Product (භාණ්ඩය), Price (මිල), Place (ස්ථානය/බෙදාහැරීම), Promotion (ප්‍රවර්ධනය)",
        "භාණ්ඩ ආයු චක්‍රය (PLC): හඳුන්වාදීම, වර්ධනය, පරිණතභාවය, පරිහානිය",
        "ප්‍රවර්ධන මිශ්‍රය: දැන්වීම්කරණය, විකුණුම් ප්‍රවර්ධනය, පෞද්ගලික විකිණීම, මහජන සම්බන්ධතා"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 24,
      title = "මූල්‍ය ප්‍රකාශන, ගැලපුම්, උපචිත, බොල් ණය සහ ක්ෂයවීම්",
      gradeLevel = "11",
      category = CommerceCategoryFilter.FINANCIAL_REPORTS,
      pageRange = 65..67,
      rootConcept = "ලාභ අලාභ ප්‍රකාශනය සහ මූල්‍ය තත්ත්ව ප්‍රකාශනය පිළියෙළ කිරීම",
      highlights = listOf(
        "දළ ලාභය = ශුද්ධ විකුණුම් - විකුණුම් පිරිවැය | විකුණුම් පිරිවැය = ආරම්භක තොගය + ශුද්ධ ගැනුම් - අවසන් තොගය",
        "ශුද්ධ ලාභය = දළ ලාභය + අනෙකුත් මෙහෙයුම් ආදායම් - මෙහෙයුම් වියදම්",
        "ගැලපුම්: උපචිත වියදම් (+වියදම් / +වගකීම්), පෙරගෙවුම් වියදම් (-වියදම් / +වත්කම්), බොල් ණය (වියදම් / -ණයගැතියන්)",
        "ස්ථාවර වත්කම් ක්ෂයවීම: සරල රේඛීය ක්‍රමය (Straight-line) සහ ක්‍රමයෙන් අඩුවන ශේෂ ක්‍රමය"
      ),
      hasTable = true
    ),
    CommerceChapterSummary(
      chapterNumber = 25,
      title = "ලාභ අරමුණු කර නොගත් සංවිධාන (සමිති, සමාජ, ක්‍රීඩා සමාජ)",
      gradeLevel = "11",
      category = CommerceCategoryFilter.FINANCIAL_REPORTS,
      pageRange = 68..69,
      rootConcept = "සාමාජික සුබසාධනය සඳහා ක්‍රියාත්මක වන සංවිධානවල ගිණුම්කරණය",
      highlights = listOf(
        "ලැබීම් හා ගෙවීම් ගිණුම: මුදල් පොතට සමානය, ප්‍රාග්ධන හා ආදායම් ලැබීම් සියල්ල ඇතුළත් වේ",
        "ආදායම් හා වියදම් ගිණුම: ලාභ අලාභ ගිණුමට සමානය, අදාළ වර්ෂයේ ආදායම් හා වියදම් පමණක් සටහන් වේ (අතිරික්තය හෝ ඌනතාවය ගණනය කරයි)",
        "සමුච්චිත අරමුදල (Accumulated Fund): වත්කම් - වගකීම්"
      )
    ),
    CommerceChapterSummary(
      chapterNumber = 26,
      title = "නිෂ්පාදන පිරිවැය, මූලිකාංග සහ පැතුරුම්පත් (Excel)",
      gradeLevel = "11",
      category = CommerceCategoryFilter.FINANCIAL_REPORTS,
      pageRange = 70..72,
      rootConcept = "නිෂ්පාදනය කළ භාණ්ඩවල පිරිවැය ගණනය කිරීම සහ MS Excel භාවිතය",
      highlights = listOf(
        "ප්‍රාථමික පිරිවැය = සෘජු ද්‍රව්‍ය + සෘජු ශ්‍රමය + සෘජු වෙනත් වියදම්",
        "නිෂ්පාදන පිරිවැය = ප්‍රාථමික පිරිවැය + කර්මාන්තශාලා පොදු කාර්ය පිරිවැය + ආරම්භක නිමනොවූ තොග - අවසන් නිමනොවූ තොග",
        "MS Excel සූත්‍ර: =SUM(A1:A10), =AVERAGE(B1:B10), =IF(C1>=50, \"Pass\", \"Fail\")"
      ),
      hasTable = true
    ),
    CommerceChapterSummary(
      chapterNumber = 27,
      title = "ආයෝජනය, කොටස් වෙළඳපොළ, සුරැකුම්පත් (බිල්පත්, බැඳුම්කර, SEC)",
      gradeLevel = "11",
      category = CommerceCategoryFilter.FINANCIAL_REPORTS,
      pageRange = 72..76,
      rootConcept = "කොළඹ කොටස් වෙළඳපොළ (CSE), සුරැකුම්පත් හා විනිමය කොමිෂන් සභාව (SEC) සහ මූල්‍ය උපකරණ",
      highlights = listOf(
        "කොටස් වර්ග: සාමාන්‍ය කොටස් (ඡන්ද අයිතිය, විචල්‍ය ලාභාංශ) සහ වරණීය කොටස් (ස්ථාවර ලාභාංශ, ප්‍රමුඛතාවය)",
        "ණයකර (Debentures): ණය සුරැකුම්පත්, ස්ථාවර පොලියක් හිමිවේ, සමාගම ඈවර කිරීමේදී මුලින්ම ගෙවිය යුතුය",
        "රාජ්‍ය සුරැකුම්පත්: භාණ්ඩාගාර බිල්පත් (වසර 1ට අඩු, වට්ටම් මිලට), භාණ්ඩාගාර බැඳුම්කර (දිගුකාලීන, කූපන් පොලිය)"
      ),
      legalAct = "1987 අංක 36 සුරැකුම්පත් හා විනිමය කොමිෂන් සභා පනත",
      hasTable = true
    )
  )

  fun getFilteredChapters(
    grade: CommerceGradeFilter,
    category: CommerceCategoryFilter,
    query: String
  ): List<CommerceChapterSummary> {
    return chapters.filter { item ->
      val matchesGrade = when (grade) {
        CommerceGradeFilter.ALL -> true
        CommerceGradeFilter.GRADE_10 -> item.gradeLevel.contains("10")
        CommerceGradeFilter.GRADE_11 -> item.gradeLevel.contains("11")
      }
      val matchesCategory = when (category) {
        CommerceCategoryFilter.ALL -> true
        else -> item.category == category
      }
      val matchesQuery = if (query.isBlank()) true else {
        val q = query.trim().lowercase()
        item.title.lowercase().contains(q) ||
          item.rootConcept.lowercase().contains(q) ||
          item.chapterNumber.toString() == q ||
          item.highlights.any { it.lowercase().contains(q) } ||
          item.legalAct?.lowercase()?.contains(q) == true
      }
      matchesGrade && matchesCategory && matchesQuery
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Grade10And11CommerceShortNotesHubScreen(
  onBack: () -> Unit,
  onOpenPdfModal: ((url: String, title: String) -> Unit)? = null
) {
  var selectedGrade by remember { mutableStateOf(CommerceGradeFilter.ALL) }
  var selectedCategory by remember { mutableStateOf(CommerceCategoryFilter.ALL) }
  var searchQuery by remember { mutableStateOf("") }
  var selectedChapterDetail by remember { mutableStateOf<CommerceChapterSummary?>(null) }
  var showEquationCalculator by remember { mutableStateOf(false) }
  var showDoubleEntryPracticeModal by remember { mutableStateOf(false) }
  var showCommerceFullBookReader by remember { mutableStateOf(false) }
  var showCommerceMasterHubDialog by remember { mutableStateOf(false) }
  var initialBookPage by remember { mutableIntStateOf(1) }

  val filteredChapters = remember(selectedGrade, selectedCategory, searchQuery) {
    CommerceChapterRepository.getFilteredChapters(selectedGrade, selectedCategory, searchQuery)
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = "10 & 11 ව්‍යාපාර හා ගිණුම්කරණය",
              fontWeight = FontWeight.Bold,
              fontSize = 16.sp,
              color = Color.White
            )
            Text(
              text = "Sandu Theory පාඩම් 27 කෙටි සටහන් & ද්විත්ව සටහන්",
              fontSize = 11.sp,
              color = Color(0xFF6EE7B7)
            )
          }
        },
        navigationIcon = {
          IconButton(
            onClick = onBack,
            modifier = Modifier.testTag("commerce_short_notes_back_button")
          ) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = "Back",
              tint = Color.White
            )
          }
        },
        actions = {
          // Sandu 76-Pages PDF Book Reader
          IconButton(
            onClick = {
              initialBookPage = 1
              showCommerceFullBookReader = true
            },
            modifier = Modifier.testTag("commerce_sandu_pdf_reader_button")
          ) {
            Icon(
              imageVector = Icons.Default.MenuBook,
              contentDescription = "Sandu Theory 76-Pages PDF Book",
              tint = Color(0xFFFDE047)
            )
          }
          // 🌟 10 & 11 Commerce Master Hub Dialog Button
          IconButton(
            onClick = { showCommerceMasterHubDialog = true },
            modifier = Modifier.testTag("commerce_master_hub_top_button")
          ) {
            Icon(
              imageVector = Icons.Default.AutoAwesome,
              contentDescription = "Commerce 10 & 11 Master Hub",
              tint = Color(0xFFFDE047)
            )
          }
          // Accounting Equation & Double Entry Practice tool
          IconButton(
            onClick = { showEquationCalculator = true },
            modifier = Modifier.testTag("commerce_calc_button")
          ) {
            Icon(
              imageVector = Icons.Default.Calculate,
              contentDescription = "Accounting Equation Calculator",
              tint = Color(0xFF34D399)
            )
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF064E3B))
      )
    }
  ) { innerPadding ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
        .background(Color(0xFFF8FAFC)),
      contentPadding = PaddingValues(12.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      // 1. Hero Banner: Sandu Commerce Theory 76 Pages Book
      item(key = "commerce_sandu_hero_card") {
        Card(
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF064E3B)),
          elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text("📊", fontSize = 22.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                  Text(
                    text = "Sandu Commerce Theory",
                    color = Color.White,
                    fontWeight = FontWeight.Black,
                    fontSize = 16.sp
                  )
                  Text(
                    text = "10 සහ 11 ශ්‍රේණි ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය",
                    color = Color(0xFFD1FAE5),
                    fontSize = 11.sp
                  )
                }
              }
              Surface(
                color = Color(0xFFFDE047),
                shape = RoundedCornerShape(6.dp)
              ) {
                Text(
                  text = "පිටු 76 ක ග්‍රන්ථය",
                  color = Color(0xFF78350F),
                  fontWeight = FontWeight.ExtraBold,
                  fontSize = 10.sp,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(
              text = "සියලු පාඩම් 27 හි Mindmap සටහන්, නීති රීති & පනත්, සංසන්දනාත්මක වගු, ගිණුම්කරණ සමීකරණ සහ ද්විත්ව සටහන් හර/බැර න්‍යායන් එක්තැන් කළ පූර්ණ කෙටි සටහන් ග්‍රන්ථය.",
              color = Color(0xFFA7F3D0),
              fontSize = 11.5.sp,
              lineHeight = 17.sp
            )

            Spacer(modifier = Modifier.height(12.dp))
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              Button(
                onClick = {
                  initialBookPage = 1
                  showCommerceFullBookReader = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                  .weight(1f)
                  .testTag("commerce_open_full_reader_btn"),
                contentPadding = PaddingValues(vertical = 10.dp)
              ) {
                Icon(Icons.Default.MenuBook, contentDescription = "Reader", modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text("පිටු 76ම කියවන්න (PDF)", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }

              Button(
                onClick = { showDoubleEntryPracticeModal = true },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                  .weight(1f)
                  .testTag("commerce_open_double_entry_btn"),
                contentPadding = PaddingValues(vertical = 10.dp)
              ) {
                Icon(Icons.Default.SyncAlt, contentDescription = "Practice", modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text("ද්විත්ව සටහන් කාණ්ඩ 200", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }
            }
          }
        }
      }

      // 1.5. Interactive Master Hub Launcher Card
      item(key = "commerce_master_hub_card") {
        Card(
          shape = RoundedCornerShape(14.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF022C22)),
          border = BorderStroke(1.2.dp, Color(0xFF10B981)),
          modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .clickable { showCommerceMasterHubDialog = true }
            .testTag("commerce_master_hub_launcher_banner")
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
              Box(
                modifier = Modifier
                  .size(42.dp)
                  .clip(CircleShape)
                  .background(Color(0xFF065F46)),
                contentAlignment = Alignment.Center
              ) {
                Text("📊", fontSize = 20.sp)
              }
              Spacer(modifier = Modifier.width(10.dp))
              Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text(
                    text = "10 & 11 කොමස් Master Hub",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                  )
                  Spacer(modifier = Modifier.width(6.dp))
                  Surface(
                    color = Color(0xFF10B981),
                    shape = RoundedCornerShape(4.dp)
                  ) {
                    Text(
                      text = "FULL SCREEN",
                      color = Color.White,
                      fontSize = 8.sp,
                      fontWeight = FontWeight.ExtraBold,
                      modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                    )
                  }
                }
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                  text = "සමීකරණ 30+ • ද්විත්ව සටහන් • මූල්‍ය ප්‍රකාශන • අනුපාත • O/L MCQs",
                  fontSize = 10.sp,
                  color = Color(0xFFA7F3D0)
                )
              }
            }
            Icon(
              imageVector = Icons.Default.OpenInFull,
              contentDescription = "Open Full Screen",
              tint = Color(0xFFFDE047),
              modifier = Modifier.size(20.dp)
            )
          }
        }
      }

      // 2. Search Field
      item(key = "commerce_search_bar") {
        OutlinedTextField(
          value = searchQuery,
          onValueChange = { searchQuery = it },
          placeholder = { Text("පාඩමේ නම, අංකය හෝ සංකල්පය සොයන්න...", fontSize = 12.sp) },
          leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF059669)) },
          trailingIcon = {
            if (searchQuery.isNotEmpty()) {
              IconButton(onClick = { searchQuery = "" }) {
                Icon(Icons.Default.Close, contentDescription = "Clear", modifier = Modifier.size(18.dp))
              }
            }
          },
          singleLine = true,
          shape = RoundedCornerShape(12.dp),
          colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF059669),
            unfocusedBorderColor = Color(0xFFCBD5E1),
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
          ),
          modifier = Modifier
            .fillMaxWidth()
            .testTag("commerce_search_input")
        )
      }

      // 3. Grade Filter Tabs (All, 10, 11)
      item(key = "commerce_grade_filter") {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          CommerceGradeFilter.values().forEach { gFilter ->
            val isSelected = selectedGrade == gFilter
            FilterChip(
              selected = isSelected,
              onClick = { selectedGrade = gFilter },
              label = {
                Text(
                  text = gFilter.labelSinhala,
                  fontSize = 11.5.sp,
                  fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                )
              },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = Color(0xFF059669),
                selectedLabelColor = Color.White,
                containerColor = Color.White,
                labelColor = Color(0xFF334155)
              ),
              border = FilterChipDefaults.filterChipBorder(
                enabled = true,
                selected = isSelected,
                borderColor = if (isSelected) Color(0xFF059669) else Color(0xFFCBD5E1)
              ),
              modifier = Modifier.weight(1f)
            )
          }
        }
      }

      // 4. Categories Horizontal Scrolling Filter
      item(key = "commerce_category_filter") {
        LazyRow(
          horizontalArrangement = Arrangement.spacedBy(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          items(CommerceCategoryFilter.values()) { cat ->
            val isSelected = selectedCategory == cat
            Surface(
              onClick = { selectedCategory = cat },
              shape = RoundedCornerShape(8.dp),
              color = if (isSelected) Color(0xFF047857) else Color.White,
              border = BorderStroke(1.dp, if (isSelected) Color(0xFF047857) else Color(0xFFE2E8F0)),
              modifier = Modifier.padding(vertical = 2.dp)
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(cat.iconEmoji, fontSize = 12.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                  text = cat.labelSinhala,
                  fontSize = 11.sp,
                  fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                  color = if (isSelected) Color.White else Color(0xFF1E293B)
                )
              }
            }
          }
        }
      }

      // 5. Section Header with count
      item(key = "commerce_results_header") {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            text = "විෂය නිර්දේශ පාඩම් (${filteredChapters.size} ක්)",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0F172A)
          )
          Text(
            text = "පාඩම තෝරා විස්තර බලන්න",
            fontSize = 10.5.sp,
            color = Color(0xFF64748B)
          )
        }
      }

      // 6. Chapter Cards List
      items(filteredChapters, key = { it.chapterNumber }) { chapter ->
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color.White),
          border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
          elevation = CardDefaults.cardElevation(defaultElevation = 1.5.dp),
          modifier = Modifier
            .fillMaxWidth()
            .clickable { selectedChapterDetail = chapter }
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.Top
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
              ) {
                Surface(
                  color = Color(0xFF059669),
                  shape = CircleShape,
                  modifier = Modifier.size(26.dp)
                ) {
                  Box(contentAlignment = Alignment.Center) {
                    Text(
                      text = "${chapter.chapterNumber}",
                      color = Color.White,
                      fontWeight = FontWeight.Bold,
                      fontSize = 11.sp
                    )
                  }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                  Text(
                    text = chapter.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = Color(0xFF0F172A)
                  )
                  Text(
                    text = "${chapter.gradeLevel} ශ්‍රේණිය • ${chapter.category.labelSinhala}",
                    fontSize = 10.sp,
                    color = Color(0xFF059669)
                  )
                }
              }

              Surface(
                color = Color(0xFFF1F5F9),
                shape = RoundedCornerShape(6.dp),
                border = BorderStroke(1.dp, Color(0xFFCBD5E1))
              ) {
                Text(
                  text = "පිටු ${chapter.pageRange.first}-${chapter.pageRange.last}",
                  fontSize = 9.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF475569),
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "💡 මූලික සංකල්පය: ${chapter.rootConcept}",
              fontSize = 11.5.sp,
              color = Color(0xFF334155),
              lineHeight = 16.sp
            )

            if (chapter.legalAct != null) {
              Spacer(modifier = Modifier.height(6.dp))
              Surface(
                color = Color(0xFFFAF5FF),
                shape = RoundedCornerShape(4.dp),
                border = BorderStroke(1.dp, Color(0xFFE9D5FF))
              ) {
                Text(
                  text = "⚖️ නීතිමය පනත: ${chapter.legalAct}",
                  fontSize = 10.sp,
                  fontWeight = FontWeight.SemiBold,
                  color = Color(0xFF7E22CE),
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.End,
              verticalAlignment = Alignment.CenterVertically
            ) {
              OutlinedButton(
                onClick = { selectedChapterDetail = chapter },
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color(0xFF059669)),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF059669)),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
              ) {
                Text("විස්තර බලන්න", fontSize = 11.sp, fontWeight = FontWeight.Bold)
              }

              Spacer(modifier = Modifier.width(6.dp))

              Button(
                onClick = {
                  initialBookPage = chapter.pageRange.first
                  showCommerceFullBookReader = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
              ) {
                Icon(Icons.Default.MenuBook, contentDescription = "Read", modifier = Modifier.size(14.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("PDF බලන්න (පිටුව ${chapter.pageRange.first})", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }
            }
          }
        }
      }
    }
  }

  // 1. Chapter Detail Modal Dialog
  selectedChapterDetail?.let { chapter ->
    AlertDialog(
      onDismissRequest = { selectedChapterDetail = null },
      title = {
        Column {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(
              color = Color(0xFF059669),
              shape = CircleShape,
              modifier = Modifier.size(24.dp)
            ) {
              Box(contentAlignment = Alignment.Center) {
                Text(
                  text = "${chapter.chapterNumber}",
                  color = Color.White,
                  fontWeight = FontWeight.Bold,
                  fontSize = 11.sp
                )
              }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = chapter.title,
              fontWeight = FontWeight.Bold,
              fontSize = 14.sp
            )
          }
          Text(
            text = "${chapter.gradeLevel} ශ්‍රේණිය • Sandu Theory පිටු ${chapter.pageRange.first} සිට ${chapter.pageRange.last} දක්වා",
            fontSize = 10.5.sp,
            color = Color(0xFF059669)
          )
        }
      },
      text = {
        LazyColumn(
          modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 400.dp),
          verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          item {
            Surface(
              color = Color(0xFFF0FDF4),
              shape = RoundedCornerShape(8.dp),
              border = BorderStroke(1.dp, Color(0xFFBBF7D0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(10.dp)) {
                Text(
                  text = "🎯 මූලික සංකල්පය:",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF166534)
                )
                Text(
                  text = chapter.rootConcept,
                  fontSize = 11.5.sp,
                  color = Color(0xFF14532D),
                  lineHeight = 16.sp
                )
              }
            }
          }

          item {
            Text(
              text = "📌 ප්‍රධාන විභාග කරුණු සාරාංශය:",
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF0F172A)
            )
          }

          items(chapter.highlights) { h ->
            Row(
              modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.Top
            ) {
              Text("•", fontWeight = FontWeight.Bold, color = Color(0xFF059669), modifier = Modifier.padding(end = 6.dp))
              Text(
                text = h,
                fontSize = 11.5.sp,
                lineHeight = 16.sp,
                color = Color(0xFF334155)
              )
            }
          }

          if (chapter.legalAct != null) {
            item {
              Surface(
                color = Color(0xFFFAF5FF),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color(0xFFE9D5FF)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(10.dp)) {
                  Text(
                    text = "⚖️ අදාළ වන ප්‍රඥප්ති / පනත්:",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF7E22CE)
                  )
                  Text(
                    text = chapter.legalAct,
                    fontSize = 11.sp,
                    color = Color(0xFF581C87)
                  )
                }
              }
            }
          }
        }
      },
      confirmButton = {
        Button(
          onClick = {
            initialBookPage = chapter.pageRange.first
            selectedChapterDetail = null
            showCommerceFullBookReader = true
          },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669))
        ) {
          Icon(Icons.Default.MenuBook, contentDescription = "Read", modifier = Modifier.size(14.dp))
          Spacer(modifier = Modifier.width(4.dp))
          Text("පිටු 76 ග්‍රන්ථයේ කියවන්න", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
      },
      dismissButton = {
        TextButton(onClick = { selectedChapterDetail = null }) {
          Text("වසන්න")
        }
      }
    )
  }

  // 2. Accounting Equation Interactive Calculator Modal
  if (showEquationCalculator) {
    AccountingEquationCalculatorDialog(
      onDismiss = { showEquationCalculator = false }
    )
  }

  // 3. Double Entry 200 Batches Practice Modal
  if (showDoubleEntryPracticeModal) {
    DoubleEntryBatchesPracticeDialog(
      onDismiss = { showDoubleEntryPracticeModal = false }
    )
  }

  // 4. Sandu Commerce Theory 76-Pages PDF Book Reader
  if (showCommerceFullBookReader) {
    SanduCommerceTheoryReaderDialog(
      initialPage = initialBookPage,
      onDismiss = { showCommerceFullBookReader = false },
      onOpenDrivePdf = onOpenPdfModal
    )
  }

  // 🌟 Commerce Grade 10 & 11 Master Hub Full Screen Dialog
  if (showCommerceMasterHubDialog) {
    CommerceGrade10And11MasterHubDialog(
      initialGradeTab = when (selectedGrade) {
        CommerceGradeFilter.GRADE_10 -> CommerceGradeTab.GRADE_10
        CommerceGradeFilter.GRADE_11 -> CommerceGradeTab.GRADE_11
        else -> CommerceGradeTab.ALL
      },
      onDismiss = { showCommerceMasterHubDialog = false },
      onOpenPdfBooklet = {
        showCommerceMasterHubDialog = false
        initialBookPage = 1
        showCommerceFullBookReader = true
      }
    )
  }
}

/**
 * Interactive Accounting Equation Calculator: A = OE + L (වත්කම් = හිමිකම + වගකීම්)
 */
@Composable
fun AccountingEquationCalculatorDialog(onDismiss: () -> Unit) {
  var assetsInput by remember { mutableStateOf("100000") }
  var equityInput by remember { mutableStateOf("70000") }
  var liabilitiesInput by remember { mutableStateOf("30000") }
  var solveFor by remember { mutableStateOf("ASSETS") } // ASSETS, EQUITY, LIABILITIES

  val aVal = assetsInput.toDoubleOrNull() ?: 0.0
  val oeVal = equityInput.toDoubleOrNull() ?: 0.0
  val lVal = liabilitiesInput.toDoubleOrNull() ?: 0.0

  val resultText = when (solveFor) {
    "ASSETS" -> "වත්කම් (A) = හිමිකම (රු. $oeVal) + වගකීම් (රු. $lVal) = රු. ${oeVal + lVal}"
    "EQUITY" -> "හිමිකම (OE) = වත්කම් (රු. $aVal) - වගකීම් (රු. $lVal) = රු. ${aVal - lVal}"
    else -> "වගකීම් (L) = වත්කම් (රු. $aVal) - හිමිකම (රු. $oeVal) = රු. ${aVal - oeVal}"
  }

  val isBalanced = (aVal == (oeVal + lVal))

  AlertDialog(
    onDismissRequest = onDismiss,
    title = {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text("⚖️", fontSize = 18.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Text("ගිණුම්කරණ සමීකරණ ගණකය", fontWeight = FontWeight.Bold, fontSize = 14.sp)
      }
    },
    text = {
      Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        Surface(
          color = Color(0xFFECFDF5),
          shape = RoundedCornerShape(8.dp),
          border = BorderStroke(1.dp, Color(0xFFA7F3D0)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Text(
            text = "වත්කම් (Assets) = හිමිකම (Owner's Equity) + වගකීම් (Liabilities)",
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF065F46),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
          )
        }

        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
          listOf("ASSETS" to "A ගණනය", "EQUITY" to "OE ගණනය", "LIABILITIES" to "L ගණනය").forEach { (key, label) ->
            FilterChip(
              selected = solveFor == key,
              onClick = { solveFor = key },
              label = { Text(label, fontSize = 10.sp) },
              modifier = Modifier.weight(1f)
            )
          }
        }

        if (solveFor != "ASSETS") {
          OutlinedTextField(
            value = assetsInput,
            onValueChange = { assetsInput = it },
            label = { Text("වත්කම් (A)", fontSize = 11.sp) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
          )
        }

        if (solveFor != "EQUITY") {
          OutlinedTextField(
            value = equityInput,
            onValueChange = { equityInput = it },
            label = { Text("හිමිකම (OE)", fontSize = 11.sp) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
          )
        }

        if (solveFor != "LIABILITIES") {
          OutlinedTextField(
            value = liabilitiesInput,
            onValueChange = { liabilitiesInput = it },
            label = { Text("වගකීම් (L)", fontSize = 11.sp) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
          )
        }

        Surface(
          color = Color(0xFF064E3B),
          shape = RoundedCornerShape(8.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(10.dp)) {
            Text(
              text = "ප්‍රතිඵලය:",
              fontSize = 10.5.sp,
              color = Color(0xFFD1FAE5)
            )
            Text(
              text = resultText,
              fontWeight = FontWeight.Bold,
              fontSize = 12.sp,
              color = Color.White
            )
          }
        }
      }
    },
    confirmButton = {
      Button(onClick = onDismiss, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669))) {
        Text("හරි")
      }
    }
  )
}

/**
 * Double Entry 200 Batches Practice Dialog
 */
@Composable
fun DoubleEntryBatchesPracticeDialog(onDismiss: () -> Unit) {
  var selectedBatchNumber by remember { mutableIntStateOf(1) }
  val batchInfo = remember(selectedBatchNumber) {
    CommerceDoubleEntryRepository.getBatch(selectedBatchNumber)
  }
  val batchChallenges = batchInfo.challenges
  var selectedChallengeIndex by remember { mutableIntStateOf(0) }
  var showSolution by remember { mutableStateOf(false) }

  val challenge = batchChallenges.getOrNull(selectedChallengeIndex)

  Dialog(onDismissRequest = onDismiss) {
    Surface(
      shape = RoundedCornerShape(16.dp),
      color = Color.White,
      modifier = Modifier
        .fillMaxWidth()
        .heightIn(max = 580.dp)
    ) {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(14.dp),
        verticalArrangement = Arrangement.SpaceBetween
      ) {
        Column {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Column(modifier = Modifier.weight(1f)) {
              Text(
                text = "ද්විත්ව සටහන් පුහුණුව (200 Batches)",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color(0xFF0F172A)
              )
              Text(
                text = CommerceDoubleEntryRepository.getBatchTitle(selectedBatchNumber),
                fontSize = 10.5.sp,
                color = Color(0xFF059669),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
              )
            }
            IconButton(onClick = onDismiss) {
              Icon(Icons.Default.Close, contentDescription = "Close")
            }
          }

          Spacer(modifier = Modifier.height(6.dp))

          // Batch Navigator Slider / Row
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Button(
              onClick = {
                if (selectedBatchNumber > 1) {
                  selectedBatchNumber--
                  selectedChallengeIndex = 0
                  showSolution = false
                }
              },
              enabled = selectedBatchNumber > 1,
              contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp)
            ) {
              Text("පෙර කාණ්ඩය", fontSize = 10.sp)
            }

            Text(
              text = "කාණ්ඩය $selectedBatchNumber / 200",
              fontWeight = FontWeight.Bold,
              fontSize = 12.sp,
              color = Color(0xFF0F172A)
            )

            Button(
              onClick = {
                if (selectedBatchNumber < 200) {
                  selectedBatchNumber++
                  selectedChallengeIndex = 0
                  showSolution = false
                }
              },
              enabled = selectedBatchNumber < 200,
              contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp)
            ) {
              Text("ඊළඟ කාණ්ඩය", fontSize = 10.sp)
            }
          }

          Spacer(modifier = Modifier.height(10.dp))

          // Challenge Item Card
          if (challenge != null) {
            Card(
              shape = RoundedCornerShape(10.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC)),
              border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween
                ) {
                  Text(
                    text = "ගනුදෙනුව ${selectedChallengeIndex + 1} / 10",
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    color = Color(0xFF0284C7)
                  )
                  Text(
                    text = batchInfo.category,
                    fontSize = 10.sp,
                    color = Color(0xFF64748B)
                  )
                }

                Spacer(modifier = Modifier.height(6.dp))
                Text(
                  text = challenge.transaction,
                  fontWeight = FontWeight.SemiBold,
                  fontSize = 13.sp,
                  color = Color(0xFF0F172A),
                  lineHeight = 18.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                if (showSolution) {
                  Surface(
                    color = Color(0xFFECFDF5),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color(0xFF6EE7B7)),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                      Text(
                        text = "✅ නිවැරදි ද්විත්ව සටහන:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.5.sp,
                        color = Color(0xFF065F46)
                      )
                      Spacer(modifier = Modifier.height(4.dp))
                      Text(
                        text = "• හර (Dr): ${challenge.debitAccount}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Color(0xFF047857)
                      )
                      Text(
                        text = "• බැර (Cr): ${challenge.creditAccount}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Color(0xFFB45309)
                      )
                      Spacer(modifier = Modifier.height(4.dp))
                      Text(
                        text = "💡 පැහැදිලි කිරීම: ${challenge.explanation}",
                        fontSize = 10.5.sp,
                        color = Color(0xFF334155),
                        lineHeight = 15.sp
                      )
                    }
                  }
                } else {
                  Button(
                    onClick = { showSolution = true },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669)),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Text("විසඳුම & ද්විත්ව සටහන පෙන්වන්න", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
                  }
                }
              }
            }
          }
        }

        // Bottom Challenge Pager Buttons
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          TextButton(
            onClick = {
              if (selectedChallengeIndex > 0) {
                selectedChallengeIndex--
                showSolution = false
              }
            },
            enabled = selectedChallengeIndex > 0
          ) {
            Text("← පෙර ගනුදෙනුව")
          }

          Text(
            text = "ප්‍රශ්න ${selectedChallengeIndex + 1} / 10",
            fontSize = 11.sp,
            color = Color(0xFF64748B)
          )

          TextButton(
            onClick = {
              if (selectedChallengeIndex < 9) {
                selectedChallengeIndex++
                showSolution = false
              }
            },
            enabled = selectedChallengeIndex < 9
          ) {
            Text("ඊළඟ ගනුදෙනුව →")
          }
        }
      }
    }
  }
}
