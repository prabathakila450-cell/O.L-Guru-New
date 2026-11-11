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
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.window.SecureFlagPolicy

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
  val grade: String, // "10" or "11"
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
  val questionSin: String,
  val options: List<String>,
  val correctIndex: Int,
  val explanationSin: String
)

data class GeoEssayQuestion(
  val id: Int,
  val grade: String,
  val titleSin: String,
  val scenarioSin: String,
  val pointsToInclude: List<String>,
  val markingSchemeSin: String
)

object GeographyMasterHubRepository {
  val lessons = listOf(
    GeoLessonUnit(
      id: "geo_l1",
      grade: "10",
      unitNumber: 1,
      titleSin: "සිතියම් කියවීම හා සමුච්ච රේඛා අර්ථකථනය",
      category: GeoSectionCategory.MAPS,
      summarySin: "භූ ලක්ෂණ සිතියම්වල සමුච්ච රේඛා (Contours), පරිමාණයන්, සහ උන්නතාංශ ස්වරූප හඳුනා ගැනීම.",
      keyPoints: listOf(
        "සමුච්ච රේඛා එකිනෙකට ළං වන විට බෑවුම තියුණු වේ.",
        "සමුච්ච රේඛා ඈත්ව පිහිටන විට මෘදු බෑවුමකි.",
        "තුංක කඳු මුදුන් සහ ත්‍රිකෝණාකාර උන්නතාංශ සලකුණු කිරීම."
      ),
      examTips: "විභාගයේදී සමුච්ච රේඛා හරහා හරස්කඩ ඇඳීම සහ බෑවුම් ස්වභාවය විස්තර කිරීම නිතර විමසයි."
    ),
    GeoLessonUnit(
      id: "geo_l2",
      grade: "10",
      unitNumber: 2,
      titleSin: "පෘථිවි ස්වභාවය සහ භූ ලක්ෂණ හැඩතල",
      category: GeoSectionCategory.PHYSICAL,
      summarySin: "පෘථිවි පෘෂ්ඨයේ විවිධ භූ ස්වරූප (කඳුකර, සානුව, මිටියාවත්, වෙරළ තීර) නිර්මාණය වීම.",
      keyPoints: listOf(
        "භූ තැටි චලන නිසා ඇතිවන වලිග කඳු පද්ධති.",
        "ගංගා මඟින් සිදු කරන ඛාදනය, ප්‍රවාහනය සහ නිධේපනය.",
        "ශ්‍රී ලංකාවේ මධ්‍ය කඳුකරය සහ තැනපිට බිම්."
      ),
      examTips: "ගංගාවක ඉහළ, මධ්‍ය සහ පහළ මිටියාවත්වල ලක්ෂණ පැහැදිලිව මතක තබා ගන්න."
    ),
    GeoLessonUnit(
      id: "geo_l3",
      grade: "10",
      unitNumber: 3,
      titleSin: "ජනගහන ව්‍යාප්තිය හා ජනාවාස රටා",
      category: GeoSectionCategory.HUMAN,
      summarySin: "ශ්‍රී ලංකාවේ හා ලෝකයේ ජනගහන ව්‍යාප්තියට බලපාන භූගෝලීය සාධක සහ ජනාවාස වර්ග.",
      keyPoints: listOf(
        "කේන්ද්‍රගත ජනාවාස, න්‍යෂ්ටික ජනාවාස සහ විකිරණ ජනාවාස.",
        "ජනගහන ඝනත්වය සහ ස්වාභාවික වර්ධන අනුපාතය.",
        "නාගරීකරණය සහ ග්‍රාමීය - නාගරික සංක්‍රමණය."
      ),
      examTips: "ජනගහන පිරමිඩ (Population Pyramids) විශ්ලේෂණය ප්‍රශ්න පත්‍රයේ බහුලව එයි."
    ),
    GeoLessonUnit(
      id: "geo_l4",
      grade: "10",
      unitNumber: 4,
      titleSin: "ආර්ථික භූගෝලය - කෘෂිකර්මය හා වැවිලි",
      category: GeoSectionCategory.ECONOMIC,
      summarySin: "වාණිජ කෘෂිකර්මය, ජීවනෝපාය වගා සහ ශ්‍රී ලංකාවේ ප්‍රධාන අපනයන බෝග.",
      keyPoints: listOf(
        "තේ, රබර්, පොල් සහ කුරුඳු වගාවන් සඳහා අවශ්‍ය දේශගුණික තත්ත්ව.",
        "හරිත විප්ලවය සහ නවීන කෘෂි තාක්ෂණය.",
        "ආහාර සුරක්ෂිතතාව සහ දේශගුණික සුහුරු වගා."
      ),
      examTips: "අපනයන බෝග වර්ධනය වන තෙත් කලාපීය දිස්ත්‍රික්ක සිතියමක ලකුණු කිරීමට පුරුදු වන්න."
    ),
    GeoLessonUnit(
      id: "geo_l5",
      grade: "10",
      unitNumber: 5,
      titleSin: "දේශගුණය, කාලගුණය සහ මෝසම් සුළං",
      category: GeoSectionCategory.CLIMATE,
      summarySin: "ශ්‍රී ලංකාවට බලපාන නිරිතදිග හා ඊසානදිග මෝසම් සුළං සහ අන්තර් මෝසම් කාලගුණ ලක්ෂණ.",
      keyPoints: listOf(
        "මෝසම් සුළං උත්පත්ති යාන්ත්‍රණය සහ වාර්ෂික වර්ෂාපතන ව්‍යාප්තිය.",
        "වියළි කලාපය, තෙත් කලාපය සහ අතරමැදි කලාපය.",
        "ගෝලීය උණුසුම වැඩිවීම සහ දේශගුණ විපර්යාස."
      ),
      examTips: "වර්ෂාපතන ප්‍රස්ථාර (Rainfall Graphs) අර්ථකථනය කිරීමේ ගැටලු හොඳින් ප්‍රගුණ කරන්න."
    ),
    GeoLessonUnit(
      id: "geo_l6",
      grade: "11",
      unitNumber: 6,
      titleSin: "ප්‍රවාහන, සන්නිවේදන සහ ජාත්‍යන්තර වෙළඳාම",
      category: GeoSectionCategory.TRANSPORT,
      summarySin: "මාර්ග ජාලය, දුම්රිය මාර්ග, වරායන් සහ ගුවන්තොටුපළවල ආර්ථික වැදගත්කම.",
      keyPoints: listOf(
        "කොළඹ සහ හම්බන්තොට වරායන්හි ජාත්‍යන්තර නැව් මාර්ග සම්බන්ධතා.",
        "අපනයන සැකසුම් කලාප (EPZ) සහ විදේශ විනිමය ආදායම.",
        "ඩිජිටල් සන්නිවේදනය සහ ගෝලීයකරණය."
      ),
      examTips: "ශ්‍රී ලංකාවේ ප්‍රධාන අපනයන සහ ආනයන භාණ්ඩ ලැයිස්තුගත කරන්න."
    ),
    GeoLessonUnit(
      id: "geo_l7",
      grade: "11",
      unitNumber: 7,
      titleSin: "ස්වභාවික ආපදා සහ අවදානම් කළමනාකරණය",
      category: GeoSectionCategory.DISASTERS,
      summarySin: "වියළි කාලගුණය, නියඟ, නායයෑම්, ගංවතුර සහ සුනාමි ආපදා අවම කිරීමේ ක්‍රමවේද.",
      keyPoints: listOf(
        "නායයෑම් අවදානම් කලාප (කඳුකර දිස්ත්‍රික්ක).",
        "ගංවතුර පාලනය සඳහා වැව් සහ මහ ඔය ජලාශ පද්ධති.",
        "පූර්ව අනතුරු ඇඟවීමේ පද්ධති සහ ප්‍රජා සහභාගීත්වය."
      ),
      examTips: "ආපදා කළමනාකරණ චක්‍රය (Disaster Management Cycle) සටහනකින් පෙන්වන්න."
    ),
    GeoLessonUnit(
      id: "geo_l8",
      grade: "11",
      unitNumber: 8,
      titleSin: "ජල සම්පත් සහ පුරාණ වාරිමාර්ග පද්ධතිය",
      category: GeoSectionCategory.WATER,
      summarySin: "මහවැලි ව්‍යාපාරය, වැව් බැඳි රාජධානියේ වාරි තාක්ෂණය සහ ජල කළමනාකරණය.",
      keyPoints: listOf(
        "බිසෝ කොටුව, ඇළ මාර්ග සහ ජල පෝෂක ප්‍රදේශ සංරක්ෂණය.",
        "ජල විදුලි උත්පාදනය (වික්ටෝරියා, කොත්මලේ ආදී ජලාශ).",
        "පානීය ජල සංරක්ෂණය සහ භූගත ජල මට්ටම."
      ),
      examTips: "පුරාණ වාරිමාර්ගවල ඉංජිනේරු විශිෂ්ටත්වය විභාගයේදී රචනා ප්‍රශ්න සඳහා ඉතා වැදගත් වේ."
    ),
    GeoLessonUnit(
      id: "geo_l9",
      grade: "11",
      unitNumber: 9,
      titleSin: "සංචාරක ව්‍යාපාරය සහ පරිසර සංරක්ෂණය",
      category: GeoSectionCategory.TOURISM,
      summarySin: "සංස්කෘතික ත්‍රිකෝණය, වනජීවී උද්‍යාන සහ පරිසර සංචාරක ව්‍යාපාරයේ (Ecotourism) දායකත්වය.",
      keyPoints: listOf(
        "සංචාරක ආකර්ෂණ ස්ථාන (සීගිරිය, යාල, නුවරඑළිය).",
        "ජෛව විවිධත්වය ආරක්ෂා කිරීම සහ ජාතික වනෝද්‍යාන.",
        "තිරසාර සංචාරක සංවර්ධනය."
      ),
      examTips: "සංචාරක කර්මාන්තයෙන් රටට ලැබෙන ආර්ථික වාසි සහ අභියෝග සාකච්ඡා කරන්න."
    ),
    GeoLessonUnit(
      id: "geo_l10",
      grade: "11",
      unitNumber: 10,
      titleSin: "O/L සම්පූර්ණ පුනරීක්ෂණය සහ ආදර්ශ ප්‍රශ්න",
      category: GeoSectionCategory.MASTER_TARGET,
      summarySin: "සාමාන්‍ය පෙළ භූගෝල විද්‍යාව විභාගය ජය ගැනීමට විශේෂිත බහුවරණ, සිතියම් සහ රචනා ප්‍රශ්න.",
      keyPoints: listOf(
        "පසුගිය විභාග ප්‍රශ්න පත්‍ර විශ්ලේෂණය.",
        "සිතියම් ලකුණු කිරීමේ පුහුණුව.",
        "කෙටි පිළිතුරු සහ රචනා ලිවීමේ ක්‍රමවේද."
      ),
      examTips: "A සාමාර්ථයක් සඳහා කාල කළමනාකරණය සහ නිවැරදි භූගෝලීය පාරිභාෂික වචන භාවිතය අත්‍යවශ්‍ය වේ."
    )
  )

  val mcqs = listOf(
    GeoMcqItem(
      1, "10",
      "සමුච්ච රේඛා (Contours) සිතියමක එකිනෙකට ඉතා ළංව පිහිටීමෙන් හැඟවෙන්නේ කුමක්ද?",
      listOf("මෘදු බෑවුම", "තියුණු/မတ်ස් බෑවුම", "සමතලා බිමක්", "මිටියාවතක්"),
      1,
      "සමුච්ච රේඛා ළං වන විට උන්නතාංශය වේගයෙන් වෙනස් වන බැවින් බෑවුම තියුණු වේ."
    ),
    GeoMcqItem(
      2, "10",
      "ශ්‍රී ලංකාවේ වැඩිම වාර්ෂික වර්ෂාපතනයක් ලැබෙන ප්‍රදේශය කුමක්ද?",
      listOf("අනුරාධපුරය", "හම්බන්තොට", "මස්කელია / හැටන් ප්‍රදේශය", "පුත්තලම"),
      2,
      "මධ්‍ය කඳුකරයේ බටහිර බෑවුම් ප්‍රදේශවලට නිරිතදිග මෝසමෙන් වැඩිම වර්ෂාපතනයක් ලැබේ."
    ),
    GeoMcqItem(
      3, "11",
      "ශ්‍රී ලංකාවේ ප්‍රධාන අපනයන බෝගයක් නොවන ශාකය කුමක්ද?",
      listOf("තේ", "රබර්", "පොල්", "වී"),
      3,
      "වී (භත් බෝගයක් වන අතර) දේශීය පරිභෝජනය සඳහා ප්‍රධාන වශයෙන් වගා කරයි."
    ),
    GeoMcqItem(
      4, "11",
      "පුරාණ වාරිමාර්ග පද්ධතියේ ජලය නියාමනය කිරීමට යොදාගත් අපූරු තාක්ෂණික නිර්මාණය කුමක්ද?",
      listOf("බිසෝ කොටුව", "වාන් දොරටුව", "නල ලිඳ", "පොම්පය"),
      0,
      "බිසෝ කොටුව මඟින් ජලාශයෙන් පිටවන ජල පීඩනය ස්වයංක්‍රීයව පාලනය කරනු ලැබීය."
    )
  )

  val essays = listOf(
    GeoEssayQuestion(
      1, "10",
      "සිතියම් කියවීමේදී සමුච්ච රේඛා සහ පරිමාණයන් භාවිත වන ආකාරය පැහැදිලි කරන්න.",
      "භූ ලක්ෂණ සිතියම්වල උන්නතාංශය දැක්වීමට සමුච්ච රේඛා යොදා ගනී.",
      listOf("සමුච්ච පරතරය (Contour Interval)", "බෑවුම් වර්ග (Steep vs Gentle slopes)", "හරස්කඩ ඇඳීම හා පරිමාණය"),
      "සමුච්ච රේඛා සංකල්පය (ලකුණු 3), බෑවුම් හඳුනාගැනීම (ලකුණු 4), යෙදුම් (ලකුණු 3)."
    ),
    GeoEssayQuestion(
      2, "11",
      "ශ්‍රී ලංකාවේ ආර්ථික සංවර්ධනය සඳහා පුරාණ වාරිමාර්ග පද්ධතිය සහ නවීන මහවැලි ව්‍යාපාරයේ දායකත්වය විමසන්න.",
      "ශ්‍රී ලංකාව කෘෂිකාර්මික රටක් ලෙස වාරිමාර්ග මත දැඩි ලෙස රඳා පවතී.",
      listOf("වියළි කලාපීය වැව් බැඳි රාජධානිය", "මහවැලි ව්‍යාපාරයේ විදුලි හා කෘෂි ප්‍රතිලාභ", "ආහාර සුරක්ෂිතතාව"),
      "ප්‍රාචීන වාරි තාක්ෂණය (ලකුණු 4), මහවැලි දායකත්වය (ලකුණු 4), නිගමනය (ලකුණු 2)."
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
      securePolicy = SecureFlagPolicy.Inherit
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

        // 6. CONTENT BASED ON SELECTED CATEGORY
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

        if (filteredLessons.isNotEmpty()) {
          items(filteredLessons, key = { it.id }) { lesson ->
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
                    Divider(color = Color(0xFF1B4D35), thickness = 1.dp)
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
        } else {
          item(key = "geo_fallback_content") {
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
              Text(text = "🌍", fontSize = 32.sp)
              Spacer(modifier = Modifier.height(6.dp))
              Text(
                text = "${selectedCategory.titleSin} - සම්පූර්ණ විෂය අන්තර්ගතය",
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "ශ්‍රී ලංකා O/L භූගෝල විද්‍යා විෂය නිර්දේශයේ සියලුම ප්‍රධාන සංකල්ප, සිතියම් කියවීම් සහ ආදර්ශ ප්‍රශ්න මෙහි ඇතුළත් වේ.",
                color = Color(0xFF9CA3AF),
                fontSize = 11.sp,
                textAlign = TextAlign.Center
              )
            }
          }

          items(GeographyMasterHubRepository.mcqs, key = { "mcq_${it.id}" }) { mcq ->
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
