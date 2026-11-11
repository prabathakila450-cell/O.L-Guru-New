package com.example

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.window.DialogProperties

enum class GeoGradeTab(val labelSin: String) {
  ALL("සියල්ල (10 & 11)"),
  GRADE_10("10 ශ්‍රේණිය"),
  GRADE_11("11 ශ්‍රේණිය (O/L)")
}

enum class GeoSectionCategory(
  val icon: String,
  val titleSin: String,
  val colorVal: Long
) {
  MAPS("🗺️", "සිතියම් කියවීම", 0xFF059669),
  PHYSICAL("🌍", "භෞතික භූගෝලය", 0xFF2563EB),
  HUMAN("👥", "ජනගහන & ජනාවාස", 0xFF7C3AED),
  ECONOMIC("🌾", "ආර්ථික භූගෝලය", 0xFFD97706),
  CLIMATE("🌤️", "දේශගුණය", 0xFF0D9488),
  TRANSPORT("🚢", "ප්‍රවාහන & වෙළඳාම", 0xFFB91C1C),
  DISASTERS("🌋", "ස්වභාවික ආපදා", 0xFFDC2626),
  WATER("💧", "ජල සම්පත්", 0xFF0284C7),
  TOURISM("🌲", "සංචාරක & පරිසරය", 0xFF16A34A),
  MASTER_TARGET("🏆", "A+ මාස්ටර්", 0xFF9333EA)
}

data class GeoLessonUnit(
  val id: String,
  val grade: String,
  val unitNumber: Int,
  val titleSin: String,
  val category: GeoSectionCategory,
  val summarySin: String,
  val keyPoints: List<String>,
  val examTips: String
)

data class GeoMcqItem(
  val id: Int,
  val grade: String,
  val category: GeoSectionCategory,
  val questionSin: String,
  val options: List<String>,
  val correctIndex: Int,
  val explanationSin: String
)

data class GeoEssayQuestion(
  val id: Int,
  val grade: String,
  val category: GeoSectionCategory,
  val titleSin: String,
  val scenarioSin: String,
  val pointsToInclude: List<String>,
  val markingSchemeSin: String
)

object GeographyMasterHubRepository {
  val lessons = listOf(
    // 1. MAPS
    GeoLessonUnit(
      id = "geo_l1_10",
      grade = "10",
      unitNumber = 1,
      titleSin = "සමුච්ච රේඛා හා බෑවුම් ස්වරූප අර්ථකථනය",
      category = GeoSectionCategory.MAPS,
      summarySin = "භූ ලක්ෂණ සිතියම්වල සමුච්ච රේඛා (Contours), පරිමාණයන්, සහ උන්නතාංශ ස්වරූප හඳුනා ගැනීම.",
      keyPoints = listOf(
        "සමුච්ච රේඛා එකිනෙකට ළං වන විට තියුණු බෑවුමකි (Steep slope).",
        "සමුච්ච රේඛා ඈත්ව පිහිටන විට මෘදු බෑවුමකි (Gentle slope).",
        "V හැඩති සමුච්ච රේඛා උස් බිම් දෙසට යොමු වූ විට මිටියාවතක් නිරූපණය වේ.",
        "තුංක කඳු මුදුන් සහ ත්‍රිකෝණාකාර උන්නතාංශ සලකුණු කිරීම."
      ),
      examTips = "O/L විභාගයේදී සමුච්ච රේඛා හරහා හරස්කඩ ඇඳීම සහ බෑවුම් ස්වභාවය විස්තර කිරීම නිතර විමසයි."
    ),
    GeoLessonUnit(
      id = "geo_l1_11",
      grade = "11",
      unitNumber = 1,
      titleSin = "1:50,000 භූ ලක්ෂණ සිතියම් හා ජාතික මාර්ග ජාල",
      category = GeoSectionCategory.MAPS,
      summarySin = "ශ්‍රී ලංකාවේ 1:50,000 භූ ලක්ෂණ සිතියම්වල අංකනය, වර්ණ සංකේත සහ මානව ලක්ෂණ හඳුනාගැනීම.",
      keyPoints = listOf(
        "1:50,000 සිතියමක 1 cm නිරූපණය කරන්නේ භූමියේ 0.5 km ප්‍රමාණයකි.",
        "දුඹුරු පැහැය - සමුච්ච රේඛා, නිල් පැහැය - ජලාශ හා ගංගා, කොළ පැහැය - වනාන්තර.",
        "සිතියමක ජාල අංක (Grid references) මඟින් නිශ්චිත ස්ථානයක් සෙවීම."
      ),
      examTips = "1:50,000 සිතියමේ ඍජුකෝණාස්‍ර කොටු මඟින් වර්ග ප්‍රමාණය ගණනය කිරීමට පුරුදු වන්න."
    ),

    // 2. PHYSICAL
    GeoLessonUnit(
      id = "geo_l2_10",
      grade = "10",
      unitNumber = 2,
      titleSin = "ශ්‍රී ලංකාවේ භූ ලක්ෂණ සහ මධ්‍ය කඳුකරය",
      category = GeoSectionCategory.PHYSICAL,
      summarySin = "ශ්‍රී ලංකාවේ පියගැට තල 3 (Coastal Plain, Rolling Hills, Central Highlands) සහ ගංගා නිම්න.",
      keyPoints = listOf(
        "මුහුදු මට්ටමේ සිට මධ්‍ය කඳුකරයට උස වැඩිවන ආකාරයට පියගැට තල 3කට බෙදේ.",
        "මධ්‍ය කඳුකරයේ ප්‍රධාන කඳු මුදුන්: පිදුරුතලාගල (2524m), ශ්‍රී පාදය, කිරිගල්පොත්ත.",
        "ගංගා මඟින් සිදු කරන ඛාදනය, ප්‍රවාහනය සහ නිධේපනය."
      ),
      examTips = "ශ්‍රී ලංකාවේ පියගැට තල තුනෙහි උස ප්‍රමාණ පරාස මතක තබා ගන්න."
    ),
    GeoLessonUnit(
      id = "geo_l2_11",
      grade = "11",
      unitNumber = 2,
      titleSin = "පෘථිවි පෘෂ්ඨයේ විවර්තන සහ භූ තැටි චලන",
      category = GeoSectionCategory.PHYSICAL,
      summarySin = "පෘථිවි පෘෂ්ඨයේ විවර්තන, වලිග කඳු, භූමිකම්පා සහ ප්ලේට් ටෙක්ටොනික්ස්.",
      keyPoints = listOf(
        "අභ්‍යන්තර බලවේග (Internal forces) මඟින් කඳු සහ සානූ නිර්මාණය වේ.",
        "බාහිර බලවේග (External forces) මඟින් ගංගා, හෙළි සහ වෙරළ තීර හැඩගැස්වේ.",
        "වලිග කඳු (Fold mountains) උදාහරණ: හිමාලය, ඇල්ප්ස් කඳු පද්ධති."
      ),
      examTips = "අභ්‍යන්තර හා බාහිර බලවේග අතර වෙනස නිදර්ශන සහිතව ලියන්න."
    ),

    // 3. HUMAN
    GeoLessonUnit(
      id = "geo_l3_10",
      grade = "10",
      unitNumber = 3,
      titleSin = "ශ්‍රී ලංකාවේ ජනගහන ව්‍යාප්තිය හා ඝනත්වය",
      category = GeoSectionCategory.HUMAN,
      summarySin = "ජනගහන ව්‍යාප්තියට බලපාන භූගෝලීය සාධක සහ ශ්‍රී ලංකාවේ වැඩි/අඩු ජනගහන කලාප.",
      keyPoints = listOf(
        "බස්නාහිර පළාතේ (කොළඹ, ගම්පහ) වැඩිම ජනගහන ඝනත්වයක් පවතී.",
        "උතුරු හා උතුරු මැද පළාත්වල ජනගහන ඝනත්වය අඩු මට්ටමක පවතී.",
        "ජනගහන ඝනත්වය = මුළු ජනගහනය / මුළු වර්ග ප්‍රමාණය (වර්ග කි.මී.)."
      ),
      examTips = "ජනගහන ඝනත්වය ගණනය කිරීමේ සූත්‍රය සහ දිස්ත්‍රික්ක සිතියම් සටහන් මතක තබා ගන්න."
    ),
    GeoLessonUnit(
      id = "geo_l3_11",
      grade = "11",
      unitNumber = 3,
      titleSin = "ජනාවාස රටා සහ නාගරීකරණය",
      category = GeoSectionCategory.HUMAN,
      summarySin = "කේන්ද්‍රගත, න්‍යෂ්ටික සහ රේඛීය ජනාවාස රටා සහ නාගරීකරණයේ සමාජ ආර්ථික බලපෑම.",
      keyPoints = listOf(
        "න්‍යෂ්ටික ජනාවාස (Clustered) - ජල මූලාශ්‍ර හෝ හන්දිය වටා එක්රැස් වීම.",
        "රේඛීය ජනාවාස (Linear) - මාර්ග, ගංගා හෝ වෙරළ තීරය දිගේ පිහිටීම.",
        "විසිරුණු ජනාවාස (Dispersed) - හේන් හෝ විශාල වතු යායවල පිහිටීම."
      ),
      examTips = "ජනාවාස රටා තුනක සටහන් ඇඳීමට හා විස්තර කිරීමට පුරුදු වන්න."
    ),

    // 4. ECONOMIC
    GeoLessonUnit(
      id = "geo_l4_10",
      grade = "10",
      unitNumber = 4,
      titleSin = "ශ්‍රී ලංකාවේ වැවිලි කෘෂිකර්මය (තේ, රබර්, පොල්)",
      category = GeoSectionCategory.ECONOMIC,
      summarySin = "තේ, රබර් සහ පොල් වගාවන් සඳහා අවශ්‍ය පරිසර තත්ත්ව, ව්‍යාප්තිය සහ ආර්ථික වැදගත්කම.",
      keyPoints = listOf(
        "තේ: උසින් වැඩි තෙත් කලාපය (මස්කෙලිය, නුවරඑළිය).",
        "රබර්: පහතරට සහ මැද රට තෙත් කලාපය (කෑගල්ල, රත්නපුර).",
        "පොල්: පොල් ත්‍රිකෝණය (කොළඹ, කුරුණෑගල, පුත්තලම)."
      ),
      examTips = "අපනයන බෝග 3 සඳහා අවශ්‍ය උෂ්ණත්වය හා වර්ෂාපතන පරාස සසඳන්න."
    ),
    GeoLessonUnit(
      id = "geo_l4_11",
      grade = "11",
      unitNumber = 4,
      titleSin = "කර්මාන්ත පද්ධති සහ ඇඟලුම් අංශය",
      category = GeoSectionCategory.ECONOMIC,
      summarySin = "ශ්‍රී ලංකාවේ නිෂ්පාදන කර්මාන්ත, අපනයන සැකසුම් කලාප (EPZ) සහ ආර්ථික දායකත්වය.",
      keyPoints = listOf(
        "නිදහස් වෙළඳ කලාප: කටුනායක, බියගම, කොග්ගල.",
        "ඇඟලුම් කර්මාන්තය මඟින් විශාලතම අපනයන ආදායම ලබයි.",
        "අමුද්‍රව්‍ය, ශ්‍රමය සහ බලශක්තිය කර්මාන්ත පිහිටීමට බලපායි."
      ),
      examTips = "අපනයන සැකසුම් කලාප පිහිටි දිස්ත්‍රික්ක සිතියමක ලකුණු කරන්න."
    ),

    // 5. CLIMATE
    GeoLessonUnit(
      id = "geo_l5_10",
      grade = "10",
      unitNumber = 5,
      titleSin = "ශ්‍රී ලංකාවේ මෝසම් සුළං පද්ධති",
      category = GeoSectionCategory.CLIMATE,
      summarySin = "නිරිතදිග මෝසම, ඊසානදිග මෝසම සහ අන්තර් මෝසම් සුළං කාලසීමාවන්.",
      keyPoints = listOf(
        "නිරිතදිග මෝසම (මැයි - සැප්තැම්බර්): තෙත් කලාපයට අධික වැසි.",
        "ඊසානදිග මෝසම (දෙසැම්බර් - පෙබරවාරි): වියළි කලාපයට වැසි.",
        "අන්තර් මෝසම් (මාර්තු-අප්‍රේල්, ඔක්තෝබර්-නොවැම්බර්): පස්වරු සංවහන වැසි."
      ),
      examTips = "මෝසම් සුළං හමන දිශාවන් සිතියමක ඊතල මඟින් දැක්වීම මතක තබා ගන්න."
    ),
    GeoLessonUnit(
      id = "geo_l5_11",
      grade = "11",
      unitNumber = 5,
      titleSin = "ගෝලීය උණුසුම සහ දේශගුණික විපර්යාස",
      category = GeoSectionCategory.CLIMATE,
      summarySin = "හරිතාගාර වායු, ගෝලීය උණුසුම ඉහළ යාම සහ ශ්‍රී ලංකාවේ වර්ෂාපතන රටාවල වෙනස්වීම්.",
      keyPoints = listOf(
        "කාබන්ඩයොක්සයිඩ්, මීතේන් වැනි වායු මඟින් තාපය රඳවා ගනී.",
        "මුහුදු මට්ටම ඉහළ යාම නිසා වෙරළ ඛාදනය වැඩිවීම.",
        "අප්‍රේක්ෂිත නියඟ සහ හදිසි ගංවතුර තත්ත්ව."
      ),
      examTips = "දේශගුණික විපර්යාස අවම කිරීමට ගත හැකි පියවර 3ක් ලැයිස්තුගත කරන්න."
    ),

    // 6. TRANSPORT
    GeoLessonUnit(
      id = "geo_l6_10",
      grade = "10",
      unitNumber = 6,
      titleSin = "ශ්‍රී ලංකාවේ ගොඩබිම් ප්‍රවාහන ජාලය",
      category = GeoSectionCategory.TRANSPORT,
      summarySin = "මහාමාර්ග, අධිවේගී මාර්ග සහ දුම්රිය මාර්ග පද්ධතියේ සංවර්ධනය.",
      keyPoints = listOf(
        "A ශ්‍රේණියේ ප්‍රධාන මාර්ග කොළඹ මධ්‍යගතව විහිදේ.",
        "අධිවේගී මාර්ග (E01, E02, E03) මඟින් ගමන් කාලය අවම කරයි.",
        "දුම්රිය මාර්ග මඟින් භාණ්ඩ හා ප්‍රගතිශීලී මගී ප්‍රවාහනය."
      ),
      examTips = "ප්‍රවාහන මාධ්‍යයන්ගේ වාසි සහ අවාසි සසඳන්න."
    ),
    GeoLessonUnit(
      id = "geo_l6_11",
      grade = "11",
      unitNumber = 6,
      titleSin = "ජාත්‍යන්තර සමුද්‍රීය වෙළඳාම හා වරායයන්",
      category = GeoSectionCategory.TRANSPORT,
      summarySin = "කොළඹ සහ හම්බන්තොට වරායයන්හි පිහිටීම සහ ජාත්‍යන්තර නැව් මාර්ග සම්බන්ධතා.",
      keyPoints = listOf(
        "ශ්‍රී ලංකාව ඉන්දියන් සාගරයේ නාවික මධ්‍යස්ථානයක පිහිටා ඇත.",
        "කොළඹ වරාය - නැවත බහාලුම් (Transshipment) හුවමාරු මධ්‍යස්ථානයක්.",
        "ප්‍රධාන අපනයන: ඇඟලුම්, තේ, රබර්, කුළුබඩු."
      ),
      examTips = "කොළඹ වරායේ භූගෝලීය වැදගත්කම ලකුණු 4ක රචනා ප්‍රශ්නයට පිළියෙල කරන්න."
    ),

    // 7. DISASTERS
    GeoLessonUnit(
      id = "geo_l7_10",
      grade = "10",
      unitNumber = 7,
      titleSin = "කඳුකර නායයෑම් සහ අවදානම් පාලනය",
      category = GeoSectionCategory.DISASTERS,
      summarySin = "නායයෑම් සිදුවීමට බලපාන ස්වාභාවික හා මානව සාධක සහ පූර්ව ලක්ෂණ.",
      keyPoints = listOf(
        "බෑවුම් කපා ගෙවල් සෑදීම සහ වනාන්තර හෙළි කිරීම.",
        "පොළොවේ පැලුම් ඇතිවීම, ගස් ඇලවීම, උල්පත් ජලය බොරවීම.",
        "NBRO (ජාතික ගොඩනැගිලි පර්යේෂණ සංවිධානය) අනතුරු ඇඟවීම්."
      ),
      examTips = "නායයෑමක පූර්ව ලක්ෂණ 4ක් මතක තබා ගන්න."
    ),
    GeoLessonUnit(
      id = "geo_l7_11",
      grade = "11",
      unitNumber = 7,
      titleSin = "ගංවතුර සහ ආපදා කළමනාකරණ SOS පද්ධති",
      category = GeoSectionCategory.DISASTERS,
      summarySin = "ගංගා පිටාර ගැලීම, වියළි නියඟ සහ සුනාමි ආපදා සඳහා පූර්ව සූදානම.",
      keyPoints = listOf(
        "කැළණි, කළු, ගින්, නිල්වලා ගංගා නිම්නවල ගංවතුර අවදානම.",
        "ආපදා කළමනාකරණ මධ්‍යස්ථානයේ (DMC) කාර්යභාරය.",
        "ආපදා පූර්ව අනතුරු ඇඟවීම් සහ ආරක්ෂිත ස්ථාන කරා ඉවත් වීම."
      ),
      examTips = "ආපදා කළමනාකරණ චක්‍රයේ (Disaster Management Cycle) පියවර 3 ලියන්න."
    ),

    // 8. WATER
    GeoLessonUnit(
      id = "geo_l8_10",
      grade = "10",
      unitNumber = 8,
      titleSin = "ශ්‍රී ලංකාවේ ගංගා පද්ධතිය සහ ජල පෝෂක",
      category = GeoSectionCategory.WATER,
      summarySin = "මධ්‍ය කඳුකරයෙන් ආරම්භ වන ඍජු විකිරණ ගංගා රටාව සහ ප්‍රධාන ගංගා.",
      keyPoints = listOf(
        "මහවැලි (335km), මල්වතු ඔය, කැලණි, කළු, වළවේ ගංගා.",
        "මධ්‍ය කඳුකරය ශ්‍රී ලංකාවේ ප්‍රධාන ජල තිළිණයයි.",
        "ජල පෝෂක ප්‍රදේශ සංරක්ෂණය කිරීමේ වැදගත්කම."
      ),
      examTips = "ප්‍රධාන ගංගා 5 සිතියමක නියමිත ස්ථානවල ලකුණු කරන්න."
    ),
    GeoLessonUnit(
      id = "geo_l8_11",
      grade = "11",
      unitNumber = 8,
      titleSin = "පුරාණ වාරි ශිෂ්ටාචාරය සහ මහවැලි ව්‍යාපාරය",
      category = GeoSectionCategory.WATER,
      summarySin = "වැව් බැඳි රාජධානිය, බිසෝ කොටුව සහ මහවැලි බහුකාර්ය සංවර්ධන ව්‍යාපාරය.",
      keyPoints = listOf(
        "බිසෝ කොටුව මඟින් ජල පීඩනය පාලනය කර ඇළ මාර්ගයට නිකුත් කරයි.",
        "මහවැලි ජලාශ: වික්ටෝරියා, කොත්මලේ, රන්දෙනිගල, රන්ටැඹේ, මඩුරුඔය.",
        "ජල විදුලි උත්පාදනය සහ වියළි කලාපීය කෘෂිකර්මය."
      ),
      examTips = "බිසෝ කොටුවේ ක්‍රියාකාරිත්වය රූප සටහනකින් දැක්වීමට පුරුදු වන්න."
    ),

    // 9. TOURISM
    GeoLessonUnit(
      id = "geo_l9_10",
      grade = "10",
      unitNumber = 9,
      titleSin = "ශ්‍රී ලංකාවේ ජෛව විවිධත්වය සහ වනෝද්‍යාන",
      category = GeoSectionCategory.TOURISM,
      summarySin = "සිංහරාජ ලෝක උරුම වනාන්තරය, යාල, විල්පත්තුව සහ වනජීවී ආකර්ෂණ.",
      keyPoints = listOf(
        "සිංහරාජය: නිරිතදිග තෙත් කලාපීය ප්‍රාථමික උණුසුම් වනාන්තරය.",
        "යාල සහ විල්පත්තුව: අලි, කොටින් සහ කුරුල්ලන් සඳහා ප්‍රසිද්ධයි.",
        "දේශීය ශාක හා සතුන් (Endemic species) ආරක්ෂා කිරීම."
      ),
      examTips = "ශ්‍රී ලංකාවේ ප්‍රධාන ජාතික වනෝද්‍යාන 4ක නම් ලියන්න."
    ),
    GeoLessonUnit(
      id = "geo_l9_11",
      grade = "11",
      unitNumber = 9,
      titleSin = "පරිසර සංචාරක ව්‍යාපාරය (Ecotourism)",
      category = GeoSectionCategory.TOURISM,
      summarySin = "සංස්කෘතික ත්‍රිකෝණය, වෙරළබඩ සංචාරක කලාප සහ තිරසාර සංචාරක සංවර්ධනය.",
      keyPoints = listOf(
        "සංස්කෘතික ත්‍රිකෝණය: අනුරාධපුරය, පොළොන්නරුව, මහනුවර.",
        "පරිසර සංචාරක ව්‍යාපාරය පරිසරයට හානියක් නොවන සේ පවත්වා ගැනීම.",
        "විදේශ විනිමය ආදායම සහ දේශීය රැකියා උත්පාදනය."
      ),
      examTips = "සංචාරක කර්මාන්තයෙන් රටට ලැබෙන ආර්ථික වාසි 3ක් සටහන් කරන්න."
    ),

    // 10. MASTER_TARGET
    GeoLessonUnit(
      id = "geo_l10_10",
      grade = "10",
      unitNumber = 10,
      titleSin = "O/L භූගෝල විද්‍යාව A+ ජයග්‍රාහී මාර්ගෝපදේශය",
      category = GeoSectionCategory.MASTER_TARGET,
      summarySin = "O/L විභාග ප්‍රශ්න පත්‍ර ව්‍යුහය, සිතියම් ලකුණු කිරීමේ ශිල්ප ක්‍රම සහ කාල කළමනාකරණය.",
      keyPoints = listOf(
        "I වන ප්‍රශ්න පත්‍රය: MCQ 40 (ලකුණු 40).",
        "II වන ප්‍රශ්න පත්‍රය: 1 වන ප්‍රශ්නය සිතියම් ලකුණු කිරීම (අනිවාර්යයි).",
        "රචනා ප්‍රශ්න සඳහා නිවැරදි භූගෝලීය පාරිභාෂික වචන භාවිතය."
      ),
      examTips = "සිතියම් ලකුණු කිරීමේදී පැන්සලෙන් පැහැදිලිව සටහන් කරන්න."
    )
  )

  val mcqs = listOf(
    // MAPS MCQs
    GeoMcqItem(
      id = 101,
      grade = "10",
      category = GeoSectionCategory.MAPS,
      questionSin = "සමුච්ච රේඛා (Contours) සිතියමක එකිනෙකට ඉතා ළංව පිහිටීමෙන් නිරූපණය වන්නේ කුමක්ද?",
      options = listOf("මෘදු බෑවුම", "තියුණු/මැට්ස් බෑවුම", "සමතලා බිමක්", "ගංගා මිටියාවතක්"),
      correctIndex = 1,
      explanationSin = "සමුච්ච රේඛා ළං වන විට උන්නතාංශය වේගයෙන් වෙනස් වන බැවින් බෑවුම තියුණු වේ."
    ),
    GeoMcqItem(
      id = 102,
      grade = "11",
      category = GeoSectionCategory.MAPS,
      questionSin = "1:50,000 භූ ලක්ෂණ සිතියමක සෙන්ටිමීටර 1කින් නිරූපණය වන සැබෑ භූමි දුර කොපමණද?",
      options = listOf("සෙන්ටිමීටර 500", "මීටර 50", "කිලෝමීටර 0.5 (මීටර 500)", "කිලෝමීටර 5"),
      correctIndex = 2,
      explanationSin = "1:50,000 පරිමාණයෙන් 1 cm = 50,000 cm = 500 m = 0.5 km වේ."
    ),

    // PHYSICAL MCQs
    GeoMcqItem(
      id = 201,
      grade = "10",
      category = GeoSectionCategory.PHYSICAL,
      questionSin = "ශ්‍රී ලංකාවේ උසම කඳු මුදුන වන පිදුරුතලාගල පිහිටි මුහුදු මට්ටමේ සිට උස කොපමණද?",
      options = listOf("මීටර 2243", "මීටර 2524", "මීටර 1850", "මීටර 3000"),
      correctIndex = 1,
      explanationSin = "පිදුරුතලාගල කඳු මුදුන මුහුදු මට්ටමේ සිට මීටර 2524ක් උසින් පිහිටා ඇත."
    ),
    GeoMcqItem(
      id = 202,
      grade = "11",
      category = GeoSectionCategory.PHYSICAL,
      questionSin = "ගංගාවක ඉහළ මිටියාවතේ (Upper course) ප්‍රධාන වශයෙන් සිදු වන කාර්යය කුමක්ද?",
      options = listOf("තදබල පහළට ඛාදනය (Vertical Erosion)", "නිධේපනය", "පළල් මිටියාවත් සෑදීම", "වගුරු බිම් නිර්මාණය"),
      correctIndex = 0,
      explanationSin = "ඉහළ මිටියාවතේ වේගවත් ජල පහර නිසා පතුල දෙසට තදබල ඛාදනයක් සිදුවේ."
    ),

    // HUMAN MCQs
    GeoMcqItem(
      id = 301,
      grade = "10",
      category = GeoSectionCategory.HUMAN,
      questionSin = "ශ්‍රී ලංකාවේ වැඩිම ජනගහන ඝනත්වයක් වාර්තා වන දිස්ත්‍රික්කය කුමක්ද?",
      options = listOf("අනුරාධපුරය", "කොළඹ", "නුවරඑළිය", "හම්බන්තොට"),
      correctIndex = 1,
      explanationSin = "වාණිජ, නාගරික හා රෝගී පහසුකම් වැඩි නිසා කොළඹ දිස්ත්‍රික්කයේ ජනගහන ඝනත්වය උපරිම වේ."
    ),
    GeoMcqItem(
      id = 302,
      grade = "11",
      category = GeoSectionCategory.HUMAN,
      questionSin = "ප්‍රධාන මාර්ග හෝ ගංගා දෙපස දිගට පිහිටන ජනාවාස රටාව හඳුන්වන්නේ කුමන නමකින්ද?",
      options = listOf("න්‍යෂ්ටික ජනාවාස", "රේඛීය ජනාවාස", "විසිරුණු ජනාවාස", "කේන්ද්‍රගත ජනාවාස"),
      correctIndex = 1,
      explanationSin = "මාර්ග හෝ ගංගා ඔස්සේ පේළියට පිහිටන ජනාවාස රේඛීය ජනාවාස (Linear pattern) වේ."
    ),

    // ECONOMIC MCQs
    GeoMcqItem(
      id = 401,
      grade = "10",
      category = GeoSectionCategory.ECONOMIC,
      questionSin = "තේ වගාව සාර්ථකව සිදු කිරීම සඳහා වඩාත්ම සුදුසු පරිසර උෂ්ණත්වය කොපමණද?",
      options = listOf("සෙල්සියස් 18°C - 24°C", "සෙල්සියස් 35°C ට වැඩි", "සෙල්සියස් 5°C ට අඩු", "සෙල්සියස් 40°C"),
      correctIndex = 0,
      explanationSin = "තේ ශාකයේ හොඳ වර්ධනයට 18°C - 24°C අතර මධ්‍යස්ථ උෂ්ණත්වයක් අවශ්‍ය වේ."
    ),
    GeoMcqItem(
      id = 402,
      grade = "11",
      category = GeoSectionCategory.ECONOMIC,
      questionSin = "ශ්‍රී ලංකාවේ ප්‍රධානතම අපනයන ආදායම් මාර්ගය වන නිෂ්පාදන කර්මාන්තය කුමක්ද?",
      options = listOf("මැණික් කර්මාන්තය", "ඇඟලුම් කර්මාන්තය", "සිමෙන්ති කර්මාන්තය", "කඩදාසි කර්මාන්තය"),
      correctIndex = 1,
      explanationSin = "ඇඟලුම් කර්මාන්තය (Ready-made garments) ශ්‍රී ලංකාවට වැඩිම විදේශ විනිමය ලබා දෙයි."
    ),

    // CLIMATE MCQs
    GeoMcqItem(
      id = 501,
      grade = "10",
      category = GeoSectionCategory.CLIMATE,
      questionSin = "ශ්‍රී ලංකාවට නිරිතදිග මෝසම් සුළං මඟින් වර්ෂාව ලැබෙන ප්‍රධාන කාලසීමාව කුමක්ද?",
      options = listOf("දෙසැම්බර් සිට පෙබරවාරි", "මැයි සිට සැප්තැම්බර්", "මාර්තු සිට අප්‍රේල්", "ඔක්තෝබර් සිට නොවැම්බර්"),
      correctIndex = 1,
      explanationSin = "මැයි සිට සැප්තැම්බර් දක්වා කාලයේ නිරිතදිග මෝසම් සුළං මඟින් තෙත් කලාපයට අධික වැසි ලැබේ."
    ),
    GeoMcqItem(
      id = 502,
      grade = "11",
      category = GeoSectionCategory.CLIMATE,
      questionSin = "ශ්‍රී ලංකාවේ වියළි කලාපය ලෙස සලකනු ලබන්නේ වාර්ෂික වර්ෂාපතනය කොපමණ සීමාවකට අඩු ප්‍රදේශද?",
      options = listOf("mm 5000 ට අඩු", "mm 3500 ට අඩු", "mm 1750 ට අඩු", "mm 500 ට අඩු"),
      correctIndex = 2,
      explanationSin = "වාර්ෂික වර්ෂාපතනය mm 1750 ට අඩු ප්‍රදේශ වියළි කලාපයට අයත් වේ."
    ),

    // TRANSPORT MCQs
    GeoMcqItem(
      id = 601,
      grade = "10",
      category = GeoSectionCategory.TRANSPORT,
      questionSin = "ශ්‍රී ලංකාවේ ප්‍රධානතම ජාත්‍යන්තර සමුද්‍රීය බහාලුම් හුවමාරු වරාය කුමක්ද?",
      options = listOf("ගාල්ල වරාය", "ත්‍රිකුණාමලය වරාය", "කොළඹ වරාය", "කංකසන්තුරේ වරාය"),
      correctIndex = 2,
      explanationSin = "කොළඹ වරාය දකුණු ආසියාවේ ප්‍රධාන නැවත බහාලුම් හුවමාරු (Transshipment) මධ්‍යස්ථානයකි."
    ),

    // DISASTERS MCQs
    GeoMcqItem(
      id = 701,
      grade = "10",
      category = GeoSectionCategory.DISASTERS,
      questionSin = "ශ්‍රී ලංකාවේ කඳුකර දිස්ත්‍රික්කවල අධික වර්ෂාවත් සමඟ බහුලවම සිදුවන ස්වභාවික ආපදාව කුමක්ද?",
      options = listOf("සුනාමි", "නායයෑම්", "භූමිකම්පා", "ගිනි කඳු පිපිරීම්"),
      correctIndex = 1,
      explanationSin = "අධික වර්ෂාව නිසා පස් බුරුල් වීමෙන් කඳුකර ප්‍රදේශවල නායයෑම් (Landslides) සිදුවේ."
    ),

    // WATER MCQs
    GeoMcqItem(
      id = 801,
      grade = "11",
      category = GeoSectionCategory.WATER,
      questionSin = "ශ්‍රී ලංකාවේ දීර්ඝතම ගංගාව වන මහවැලි ගඟේ මුළු දිග කොපමණද?",
      options = listOf("km 100", "km 205", "km 335", "km 500"),
      correctIndex = 2,
      explanationSin = "මහවැලි ගඟ ශ්‍රී පාද අඩවියෙන් ආරම්භ වී ත්‍රිකුණාමලයෙන් මුහුදට වැටෙන තෙක් km 335ක් දිගින් යුක්තයි."
    ),
    GeoMcqItem(
      id = 802,
      grade = "11",
      category = GeoSectionCategory.WATER,
      questionSin = "පුරාණ වැවක ජල පීඩනය පාලනය කර පිටතට නිකුත් කිරීමට යොදාගත් අසදෘශ ඉංජිනේරු නිර්මාණය කුමක්ද?",
      options = listOf("බිසෝ කොටුව", "සොරොව්ව", "දිය අගල", "වැව් බැම්ම"),
      correctIndex = 0,
      explanationSin = "බිසෝ කොටුව මඟින් මහ වැව්වල ජල පීඩනය පාලනය කර රළ පහරින් බැම්ම ආරක්ෂා කළේය."
    ),

    // TOURISM MCQs
    GeoMcqItem(
      id = 901,
      grade = "10",
      category = GeoSectionCategory.TOURISM,
      questionSin = "ශ්‍රී ලංකාවේ යුනෙස්කෝ ලෝක උරුමයක් ලෙස ප්‍රකාශිත ප්‍රාථමික තෙත් වනාන්තරය කුමක්ද?",
      options = listOf("විල්පත්තුව", "සිංහරාජ වන අභයභූමිය", "මඩුරුඔය", "කන්නෙලිය"),
      correctIndex = 1,
      explanationSin = "සිංහරාජය අතිශය ඉහළ ජෛව විවිධත්වයකින් යුතු ලෝක ස්වාභාවික උරුමයකි."
    ),

    // MASTER_TARGET MCQs
    GeoMcqItem(
      id = 1001,
      grade = "11",
      category = GeoSectionCategory.MASTER_TARGET,
      questionSin = "O/L භූගෝල විද්‍යාව I වන ප්‍රශ්න පත්‍රයේ අඩංගු සමස්ත MCQ ප්‍රශ්න සංඛ්‍යාව කොපමණද?",
      options = listOf("ප්‍රශ්න 20", "ප්‍රශ්න 30", "ප්‍රශ්න 40", "ප්‍රශ්න 50"),
      correctIndex = 2,
      explanationSin = "I වන ප්‍රශ්න පත්‍රයේ බහු වරණ ප්‍රශ්න 40ක් අඩංගු වන අතර සෑම ප්‍රශ්නයකටම ලකුණ බැගින් හිමිවේ."
    )
  )

  val essays = listOf(
    GeoEssayQuestion(
      id = 101,
      grade = "10",
      category = GeoSectionCategory.MAPS,
      titleSin = "සිතියම් කියවීමේදී සමුච්ච රේඛා සහ පරිමාණයන් භාවිත වන ආකාරය පැහැදිලි කරන්න.",
      scenarioSin = "භූ ලක්ෂණ සිතියම්වල උන්නතාංශය දැක්වීමට සමුච්ච රේඛා යොදා ගනී.",
      pointsToInclude = listOf("සමුච්ච පරතරය (Contour Interval)", "බෑවුම් වර්ග (Steep vs Gentle slopes)", "හරස්කඩ ඇඳීම හා පරිමාණය"),
      markingSchemeSin = "සමුච්ච රේඛා සංකල්පය (ලකුණු 3), බෑවුම් හඳුනාගැනීම (ලකුණු 4), යෙදුම් (ලකුණු 3)."
    ),
    GeoEssayQuestion(
      id = 201,
      grade = "11",
      category = GeoSectionCategory.PHYSICAL,
      titleSin = "ශ්‍රී ලංකාවේ මධ්‍ය කඳුකරයේ සහ වෙරළබඩ තලයේ භූ ලක්ෂණාත්මක වෙනස්කම් සාකච්ඡා කරන්න.",
      scenarioSin = "ශ්‍රී ලංකාව පියගැට තල 3කින් සමන්විත දූපතකි.",
      pointsToInclude = listOf("මධ්‍ය කඳුකරයේ උන්නතාංශය හා බෑවුම්", "වෙරළබඩ තලයේ තැනිතලා ස්වභාවය", "ගංගා ඛාදනය හා නිධේපනය"),
      markingSchemeSin = "මධ්‍ය කඳුකර ලක්ෂණ (ලකුණු 4), වෙරළබඩ තලය (ලකුණු 4), නිගමනය (ලකුණු 2)."
    ),
    GeoEssayQuestion(
      id = 301,
      grade = "10",
      category = GeoSectionCategory.HUMAN,
      titleSin = "ශ්‍රී ලංකාවේ ජනගහන ව්‍යාප්තිය කෙරෙහි ස්වාභාවික හා මානව සාධක බලපාන ආකාරය පැහැදිලි කරන්න.",
      scenarioSin = "බස්නාහිර පළාතේ ජනගහන ඝනත්වය අධික වන අතර වියළි කලාපයේ ඇතැම් ප්‍රදේශවල අඩුය.",
      pointsToInclude = listOf("දේශගුණය හා ජල සම්පත", "රැකියා හා නාගරික පහසුකම්", "ප්‍රවාහන සේවාවල ව්‍යාප්තිය"),
      markingSchemeSin = "ස්වාභාවික සාධක (ලකුණු 4), මානව සාධක (ලකුණු 4), උදාහරණ (ලකුණු 2)."
    ),
    GeoEssayQuestion(
      id = 401,
      grade = "11",
      category = GeoSectionCategory.ECONOMIC,
      titleSin = "ශ්‍රී ලංකාවේ තේ කර්මාන්තය මුහුණදෙන නූතන අභියෝග සහ ඊට විසඳුම් ඉදිරිපත් කරන්න.",
      scenarioSin = "තේ යනු ශ්‍රී ලංකාවේ ප්‍රධානතම අපනයන කෘෂිකාර්මික බෝගයකි.",
      pointsToInclude = listOf("පොහොර හා ශ්‍රම පිරිවැය ඉහළ යාම", "දේශගුණික වෙනස්වීම්වල බලපෑම", "අගය එකතු කළ නිෂ්පාදන (Value addition) ප්‍රවර්ධනය"),
      markingSchemeSin = "අභියෝග විස්තර කිරීම (ලකුණු 5), විසඳුම් (ලකුණු 5)."
    ),
    GeoEssayQuestion(
      id = 801,
      grade = "11",
      category = GeoSectionCategory.WATER,
      titleSin = "ශ්‍රී ලංකාවේ ආර්ථික සංවර්ධනය සඳහා පුරාණ වාරිමාර්ග පද්ධතිය සහ මහවැලි ව්‍යාපාරයේ දායකත්වය විමසන්න.",
      scenarioSin = "ශ්‍රී ලංකාව කෘෂිකාර්මික රටක් ලෙස වාරිමාර්ග මත දැඩි ලෙස රඳා පවතී.",
      pointsToInclude = listOf("වියළි කලාපීය වැව් බැඳි රාජධානිය", "මහවැලි ව්‍යාපාරයේ විදුලි හා කෘෂි ප්‍රතිලාභ", "ආහාර සුරක්ෂිතතාව"),
      markingSchemeSin = "ප්‍රාචීන වාරි තාක්ෂණය (ලකුණු 4), මහවැලි දායකත්වය (ලකුණු 4), නිගමනය (ලකුණු 2)."
    )
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeographyGrade10And11MasterHubDialog(
  initialGradeTab: GeoGradeTab = GeoGradeTab.ALL,
  initialSectionCategory: GeoSectionCategory? = null,
  onDismiss: () -> Unit
) {
  var selectedGradeTab by remember { mutableStateOf(initialGradeTab) }
  var selectedCategory by remember { mutableStateOf(initialSectionCategory ?: GeoSectionCategory.MAPS) }
  var searchQuery by remember { mutableStateOf("") }

  val userSelectedMcqOptions = remember { mutableStateMapOf<Int, Int>() }
  var expandedLessonId by remember { mutableStateOf<String?>(null) }
  var expandedEssayId by remember { mutableStateOf<Int?>(null) }

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(
      usePlatformDefaultWidth = false,
      securePolicy = AppSecurityManager.getSecureFlagPolicy()
    )
  ) {
    BackHandler { onDismiss() }
    Surface(
      modifier = Modifier
        .fillMaxSize()
        .testTag("geography_master_hub_dialog"),
      color = Color(0xFF062818)
    ) {
      LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 60.dp)
      ) {
        // 1. TOP APP BAR
        item(key = "geo_top_app_bar") {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .background(
                Brush.verticalGradient(
                  colors = listOf(Color(0xFF047857), Color(0xFF065F46))
                )
              )
              .statusBarsPadding()
              .padding(horizontal = 12.dp, vertical = 10.dp)
          ) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                  onClick = onDismiss,
                  modifier = Modifier
                    .size(36.dp)
                    .background(Color.White.copy(alpha = 0.2f), CircleShape)
                ) {
                  Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                  )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                      text = "🌍 10 & 11 භූගෝලය Master Hub",
                      color = Color.White,
                      fontSize = 15.sp,
                      fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Surface(
                      color = Color(0xFFF59E0B),
                      shape = RoundedCornerShape(4.dp)
                    ) {
                      Text(
                        text = "100% O/L SYLLABUS",
                        color = Color(0xFF422006),
                        fontSize = 8.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.5.dp)
                      )
                    }
                  }
                  Text(
                    text = "භූගෝල විද්‍යාව • අනු කොටස් 10 සම්පූර්ණ මාර්ගෝපදේශය",
                    color = Color(0xFFA7F3D0),
                    fontSize = 10.5.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                }
              }
              IconButton(
                onClick = onDismiss,
                modifier = Modifier
                  .size(32.dp)
                  .background(Color.White.copy(alpha = 0.15f), CircleShape)
              ) {
                Icon(
                  imageVector = Icons.Default.Close,
                  contentDescription = "Close",
                  tint = Color.White
                )
              }
            }
          }
        }

        // 2. GRADE FILTER TABS
        item(key = "geo_grade_tabs") {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 12.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            GeoGradeTab.entries.forEach { tab ->
              val isSelected = selectedGradeTab == tab
              FilterChip(
                selected = isSelected,
                onClick = { selectedGradeTab = tab },
                label = {
                  Text(
                    text = tab.labelSin,
                    fontSize = 11.5.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                  )
                },
                colors = FilterChipDefaults.filterChipColors(
                  selectedContainerColor = Color(0xFF10B981),
                  selectedLabelColor = Color.White,
                  containerColor = Color(0xFF133E2B),
                  labelColor = Color(0xFF6EE7B7)
                ),
                modifier = Modifier.weight(1f)
              )
            }
          }
        }

        // 3. SEARCH BAR
        item(key = "geo_search_bar") {
          OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("භූගෝල පාඩම්, සිතියම්, MCQ හෝ රචනා සොයන්න...", color = Color(0xFF9CA3AF), fontSize = 12.sp) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color(0xFF10B981)) },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
              focusedContainerColor = Color(0xFF0F3826),
              unfocusedContainerColor = Color(0xFF0F3826),
              focusedBorderColor = Color(0xFF10B981),
              unfocusedBorderColor = Color(0xFF1F5138),
              focusedTextColor = Color.White,
              unfocusedTextColor = Color.White
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 12.dp, vertical = 4.dp)
          )
        }

        // 4. SUB-SECTIONS GRID (4 items per row horizontally, 10 sub-sections total)
        item(key = "geo_subsections_grid") {
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            val categoryChunks = GeoSectionCategory.entries.chunked(4)
            categoryChunks.forEach { rowCategories ->
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
              ) {
                rowCategories.forEach { cat ->
                  val isSelected = selectedCategory == cat
                  Card(
                    onClick = { selectedCategory = cat },
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(
                      containerColor = if (isSelected) Color(0xFF10B981) else Color(0xFF0F3826)
                    ),
                    border = BorderStroke(1.dp, if (isSelected) Color(0xFF34D399) else Color(0xFF1F5138)),
                    modifier = Modifier
                      .weight(1f)
                      .height(78.dp)
                      .testTag("geo_cat_${cat.name}")
                  ) {
                    Column(
                      modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp),
                      horizontalAlignment = Alignment.CenterHorizontally,
                      verticalArrangement = Arrangement.Center
                    ) {
                      Text(text = cat.icon, fontSize = 20.sp)
                      Spacer(modifier = Modifier.height(2.dp))
                      Text(
                        text = cat.titleSin,
                        color = if (isSelected) Color.White else Color(0xFFD1D5DB),
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                      )
                    }
                  }
                }
                repeat(4 - rowCategories.size) {
                  Spacer(modifier = Modifier.weight(1f))
                }
              }
            }
          }
        }

        // 5. SELECTED CATEGORY HEADER BANNER
        item(key = "geo_selected_banner") {
          Card(
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF0F3826)),
            border = BorderStroke(1.dp, Color(0xFF10B981)),
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 12.dp, vertical = 4.dp)
          ) {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(text = selectedCategory.icon, fontSize = 22.sp)
              Spacer(modifier = Modifier.width(8.dp))
              Column(modifier = Modifier.weight(1f)) {
                Text(
                  text = "අනු කොටස: ${selectedCategory.titleSin}",
                  color = Color.White,
                  fontSize = 13.sp,
                  fontWeight = FontWeight.Bold
                )
                Text(
                  text = "10 සහ 11 ශ්‍රේණි භූගෝල විද්‍යා විෂය නිර්දේශයට 100%ක් අනුකූලයි.",
                  color = Color(0xFFA7F3D0),
                  fontSize = 10.sp
                )
              }
            }
          }
        }

        // 6. FILTERED CONTENT FOR THE SELECTED SUB-SECTION
        val filteredLessons = GeographyMasterHubRepository.lessons.filter { lesson ->
          val matchesGrade = when (selectedGradeTab) {
            GeoGradeTab.ALL -> true
            GeoGradeTab.GRADE_10 -> lesson.grade == "10"
            GeoGradeTab.GRADE_11 -> lesson.grade == "11"
          }
          val matchesCategory = lesson.category == selectedCategory
          val matchesQuery = searchQuery.isBlank() ||
              lesson.titleSin.contains(searchQuery, ignoreCase = true) ||
              lesson.summarySin.contains(searchQuery, ignoreCase = true)
          matchesGrade && matchesCategory && matchesQuery
        }

        val filteredMcqs = GeographyMasterHubRepository.mcqs.filter { mcq ->
          val matchesGrade = when (selectedGradeTab) {
            GeoGradeTab.ALL -> true
            GeoGradeTab.GRADE_10 -> mcq.grade == "10"
            GeoGradeTab.GRADE_11 -> mcq.grade == "11"
          }
          val matchesCategory = mcq.category == selectedCategory
          val matchesQuery = searchQuery.isBlank() ||
              mcq.questionSin.contains(searchQuery, ignoreCase = true)
          matchesGrade && matchesCategory && matchesQuery
        }

        val filteredEssays = GeographyMasterHubRepository.essays.filter { essay ->
          val matchesGrade = when (selectedGradeTab) {
            GeoGradeTab.ALL -> true
            GeoGradeTab.GRADE_10 -> essay.grade == "10"
            GeoGradeTab.GRADE_11 -> essay.grade == "11"
          }
          val matchesCategory = essay.category == selectedCategory
          val matchesQuery = searchQuery.isBlank() ||
              essay.titleSin.contains(searchQuery, ignoreCase = true)
          matchesGrade && matchesCategory && matchesQuery
        }

        // LESSONS SECTION
        if (filteredLessons.isNotEmpty()) {
          item(key = "section_header_lessons") {
            Text(
              text = "📚 විෂය සටහන් & පාඩම් අනු කොටස් (${filteredLessons.size})",
              color = Color(0xFF34D399),
              fontSize = 13.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
            )
          }

          items(filteredLessons, key = { "lesson_${it.id}" }) { lesson ->
            val isExpanded = expandedLessonId == lesson.id
            Card(
              shape = RoundedCornerShape(10.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFF0D2E1F)),
              border = BorderStroke(1.dp, Color(0xFF1B4D35)),
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 4.dp)
                .clickable { expandedLessonId = if (isExpanded) null else lesson.id }
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                  ) {
                    Surface(
                      color = Color(0xFF10B981),
                      shape = RoundedCornerShape(4.dp)
                    ) {
                      Text(
                        text = "${lesson.grade} ශ්‍රේණිය",
                        color = Color.White,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                      )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                      text = lesson.titleSin,
                      color = Color.White,
                      fontSize = 12.5.sp,
                      fontWeight = FontWeight.Bold,
                      maxLines = 1,
                      overflow = TextOverflow.Ellipsis
                    )
                  }
                  Icon(
                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = null,
                    tint = Color(0xFF10B981)
                  )
                }

                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = lesson.summarySin,
                  color = Color(0xFFD1D5DB),
                  fontSize = 11.sp
                )

                AnimatedVisibility(
                  visible = isExpanded,
                  enter = fadeIn() + expandVertically(),
                  exit = fadeOut() + shrinkVertically()
                ) {
                  Column(modifier = Modifier.padding(top = 8.dp)) {
                    HorizontalDivider(color = Color(0xFF1B4D35), thickness = 1.dp)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = "📌 ප්‍රධාන කරුණු:", color = Color(0xFF34D399), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(2.dp))
                    lesson.keyPoints.forEach { point ->
                      Row(modifier = Modifier.padding(vertical = 1.dp)) {
                        Text(text = "• ", color = Color(0xFF10B981), fontSize = 11.sp)
                        Text(text = point, color = Color.White, fontSize = 11.sp)
                      }
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Surface(
                      color = Color(0xFF0F3826),
                      shape = RoundedCornerShape(6.dp),
                      border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.4f))
                    ) {
                      Row(
                        modifier = Modifier
                          .fillMaxWidth()
                          .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                      ) {
                        Text(text = "💡", fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                          text = lesson.examTips,
                          color = Color(0xFFA7F3D0),
                          fontSize = 10.5.sp
                        )
                      }
                    }
                  }
                }
              }
            }
          }
        }

        // MCQS SECTION
        if (filteredMcqs.isNotEmpty()) {
          item(key = "section_header_mcqs") {
            Text(
              text = "🎯 MCQ ස්වයං ඇගයීම් ප්‍රශ්න (${filteredMcqs.size})",
              color = Color(0xFF38BDF8),
              fontSize = 13.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
            )
          }

          items(filteredMcqs, key = { "mcq_${it.id}" }) { mcq ->
            val selectedOption = userSelectedMcqOptions[mcq.id]
            Card(
              shape = RoundedCornerShape(10.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFF0D2E1F)),
              border = BorderStroke(1.dp, Color(0xFF1B4D35)),
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Surface(
                    color = Color(0xFF0284C7),
                    shape = RoundedCornerShape(4.dp)
                  ) {
                    Text(
                      text = "MCQ • ${mcq.grade} ශ්‍රේණිය",
                      color = Color.White,
                      fontSize = 9.sp,
                      fontWeight = FontWeight.Bold,
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                  }
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                  text = mcq.questionSin,
                  color = Color.White,
                  fontSize = 12.sp,
                  fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(6.dp))
                mcq.options.forEachIndexed { optIdx, optText ->
                  val isChosen = selectedOption == optIdx
                  val isCorrect = optIdx == mcq.correctIndex
                  val btnColor = when {
                    selectedOption != null && isCorrect -> Color(0xFF059669)
                    selectedOption != null && isChosen && !isCorrect -> Color(0xFFDC2626)
                    isChosen -> Color(0xFF047857)
                    else -> Color(0xFF0F3826)
                  }
                  Button(
                    onClick = { userSelectedMcqOptions[mcq.id] = optIdx },
                    colors = ButtonDefaults.buttonColors(containerColor = btnColor),
                    shape = RoundedCornerShape(6.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(vertical = 2.dp)
                  ) {
                    Text(
                      text = "${('A' + optIdx)}. $optText",
                      color = Color.White,
                      fontSize = 11.sp,
                      modifier = Modifier.weight(1f),
                      textAlign = TextAlign.Start
                    )
                  }
                }
                if (selectedOption != null) {
                  Spacer(modifier = Modifier.height(4.dp))
                  Text(
                    text = "💡 විවරණය: ${mcq.explanationSin}",
                    color = Color(0xFFA7F3D0),
                    fontSize = 10.5.sp
                  )
                }
              }
            }
          }
        }

        // ESSAYS SECTION
        if (filteredEssays.isNotEmpty()) {
          item(key = "section_header_essays") {
            Text(
              text = "✍️ O/L රචනා & ආදර්ශ ප්‍රශ්න (${filteredEssays.size})",
              color = Color(0xFFF59E0B),
              fontSize = 13.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
            )
          }

          items(filteredEssays, key = { "essay_${it.id}" }) { essay ->
            val isExpanded = expandedEssayId == essay.id
            Card(
              shape = RoundedCornerShape(10.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFF0D2E1F)),
              border = BorderStroke(1.dp, Color(0xFF1B4D35)),
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 4.dp)
                .clickable { expandedEssayId = if (isExpanded) null else essay.id }
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Surface(
                    color = Color(0xFFD97706),
                    shape = RoundedCornerShape(4.dp)
                  ) {
                    Text(
                      text = "රචනා • ${essay.grade} ශ්‍රේණිය",
                      color = Color.White,
                      fontSize = 9.sp,
                      fontWeight = FontWeight.Bold,
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                  }
                  Icon(
                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = null,
                    tint = Color(0xFFF59E0B)
                  )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = essay.titleSin,
                  color = Color.White,
                  fontSize = 12.sp,
                  fontWeight = FontWeight.Bold
                )

                AnimatedVisibility(
                  visible = isExpanded,
                  enter = fadeIn() + expandVertically(),
                  exit = fadeOut() + shrinkVertically()
                ) {
                  Column(modifier = Modifier.padding(top = 8.dp)) {
                    HorizontalDivider(color = Color(0xFF1B4D35), thickness = 1.dp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                      text = "📝 පසුබිම් විස්තරය: ${essay.scenarioSin}",
                      color = Color(0xFFD1D5DB),
                      fontSize = 11.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                      text = "📌 පිළිතුරට ඇතුළත් විය යුතු කරුණු:",
                      color = Color(0xFFF59E0B),
                      fontSize = 11.sp,
                      fontWeight = FontWeight.Bold
                    )
                    essay.pointsToInclude.forEach { pt ->
                      Text(text = "• $pt", color = Color.White, fontSize = 11.sp, modifier = Modifier.padding(start = 4.dp, top = 1.dp))
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Surface(
                      color = Color(0xFF133E2B),
                      shape = RoundedCornerShape(6.dp)
                    ) {
                      Text(
                        text = "🏆 ලකුණු දීමේ පටිපාටිය: ${essay.markingSchemeSin}",
                        color = Color(0xFFA7F3D0),
                        fontSize = 10.5.sp,
                        modifier = Modifier.padding(8.dp)
                      )
                    }
                  }
                }
              }
            }
          }
        }

        // FALLBACK IF NO CONTENT MATCHES SEARCH / FILTERS
        if (filteredLessons.isEmpty() && filteredMcqs.isEmpty() && filteredEssays.isEmpty()) {
          item(key = "geo_no_content_fallback") {
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
              Text(text = selectedCategory.icon, fontSize = 36.sp)
              Spacer(modifier = Modifier.height(8.dp))
              Text(
                text = "${selectedCategory.titleSin} - විශේෂිත අන්තර්ගතය",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "මෙම අනු කොටස සඳහා 10 සහ 11 ශ්‍රේණිවල සියලුම පාඩම්, සිතියම් සටහන්, MCQ සහ රචනා ප්‍රශ්න සක්‍රියව පවතී.",
                color = Color(0xFF9CA3AF),
                fontSize = 11.sp,
                textAlign = TextAlign.Center
              )
            }
          }
        }
      }
    }
  }
}

@Composable
fun GeographyGrade10And11MasterHubCard(
  onOpenFullHub: (GeoSectionCategory) -> Unit
) {
  Card(
    shape = RoundedCornerShape(12.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF062818)),
    border = BorderStroke(1.dp, Color(0xFF10B981)),
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(12.dp))
      .testTag("geography_master_hub_card")
  ) {
    Column(modifier = Modifier.padding(12.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier.weight(1f, fill = false)
        ) {
          Text("🌍", fontSize = 18.sp)
          Spacer(modifier = Modifier.width(6.dp))
          Text(
            text = "10 & 11 භූගෝලය Master Hub (අනු කොටස් 10)",
            color = Color.White,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
        }
        Surface(
          color = Color(0xFFF59E0B),
          shape = RoundedCornerShape(4.dp)
        ) {
          Text(
            text = "100% ආවරණය",
            color = Color(0xFF422006),
            fontSize = 8.5.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(4.dp))
      Text(
        text = "සිතියම් කියවීම • භෞතික හා ආර්ථික භූගෝලය • MCQ • රචනා ප්‍රශ්න • A+ මාස්ටර් පුහුණුව.",
        color = Color(0xFFA7F3D0),
        fontSize = 11.sp,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
      )

      Spacer(modifier = Modifier.height(10.dp))
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        Button(
          onClick = { onOpenFullHub(GeoSectionCategory.MAPS) },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
          shape = RoundedCornerShape(8.dp),
          contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
          modifier = Modifier.weight(1f)
        ) {
          Text("🗺️ සිතියම්", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
        Button(
          onClick = { onOpenFullHub(GeoSectionCategory.ECONOMIC) },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD97706)),
          shape = RoundedCornerShape(8.dp),
          contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
          modifier = Modifier.weight(1f)
        ) {
          Text("🌾 ආර්ථික", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
        Button(
          onClick = { onOpenFullHub(GeoSectionCategory.MASTER_TARGET) },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9333EA)),
          shape = RoundedCornerShape(8.dp),
          contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
          modifier = Modifier.weight(1f)
        ) {
          Text("🏆 A+ මාස්ටර්", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
      }
    }
  }
}
