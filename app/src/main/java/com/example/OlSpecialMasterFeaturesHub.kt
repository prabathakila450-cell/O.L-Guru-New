package com.example

import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ==============================================================================
// 🌟 O/L SPECIAL MASTER FEATURES HUB: ALL SUBJECT INTERACTIVE TOOL SUITE
// ==============================================================================

enum class SpecialFeatureSection(val id: String, val titleSinhala: String, val icon: String, val color: Color) {
  SCIENCE_DIAGRAMS("sci_diagrams", "විද්‍යාව රූප සටහන් & සූත්‍ර", "🔬", Color(0xFF0D9488)),
  ENGLISH_WRITING_VAULT("eng_vault", "ඉංග්‍රීසි Writing Vault & Verbs", "✍️", Color(0xFF0284C7)),
  HISTORY_TIMELINE_MAPS("hist_suite", "ඉතිහාසය Timeline & සිතියම්", "🏛️", Color(0xFFD97706)),
  GEOGRAPHY_TOPOMAPS("geo_suite", "භූගෝලය 1:50,000 & කලාප", "🗺️", Color(0xFF059669)),
  COMMERCE_DOUBLE_ENTRY("comm_suite", "කොමස් ද්විත්ව සටහන් & ගිණුම්", "📊", Color(0xFF7C3AED)),
  DANCING_TRADITIONS("dance_suite", "නර්තනය ත්‍රිවිධ සම්ප්‍රදාය & වන්නම්", "💃", Color(0xFFE11D48)),
  SINHALA_LITERATURE("sinhala_vault", "සිංහල සාහිත්‍යය & රසාස්වාදය", "📜", Color(0xFFE11D48)),
  BUDDHISM_DHAMMA("buddhism_vault", "බුද්ධ ධර්මය & සූත්‍ර විශ්ලේෂණ", "☸️", Color(0xFFF59E0B)),
  GEOMETRY_STRUCTURED("geometry_structured", "ජ්‍යාමිතිය ව්‍යුහගත & අනුබද්ධ (කාණ්ඩ 20 • ප්‍රශ්න 400)", "📐", Color(0xFF2563EB)),
  DAILY_5MIN_CHALLENGE("daily_challenge", "දිනපතා 5-Min O/L Challenge", "⚡", Color(0xFFF59E0B)),
  OFFICIAL_MARKING_SCHEME("marking_schemes", "O/L නිල Marking Schemes", "📋", Color(0xFF2563EB)),
  OL_ORIGINAL_PAST_PAPERS_10YEARS("ol_past_papers_10y", "සා/පෙළ වසර 10 මුල් ප්‍රශ්න පත්‍ර (I & II සජීවී)", "🏆", Color(0xFF10B981))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OlSpecialMasterFeaturesHubScreen(
  initialSection: SpecialFeatureSection? = null,
  initialCategoryNumber: Int? = null,
  onBack: () -> Unit,
  onOpenPdfModal: ((url: String, title: String) -> Unit)? = null,
  lockedSubjectName: String? = null,
  subject: String? = null
) {
  // Determine effective subject name
  val currentSubject = remember(lockedSubjectName, initialSection, subject) {
    if (lockedSubjectName != null) {
        lockedSubjectName
    } else if (subject != null) {
        subject
    } else {
        when (initialSection) {
          SpecialFeatureSection.GEOGRAPHY_TOPOMAPS -> "භූගෝල විද්‍යාව"
          SpecialFeatureSection.SCIENCE_DIAGRAMS -> "විද්‍යාව"
          SpecialFeatureSection.HISTORY_TIMELINE_MAPS -> "ඉතිහාසය"
          SpecialFeatureSection.ENGLISH_WRITING_VAULT -> "ඉංග්‍රීසි"
          SpecialFeatureSection.COMMERCE_DOUBLE_ENTRY -> "ව්‍යාපාර හා ගිණුම්කරණය"
          SpecialFeatureSection.DANCING_TRADITIONS -> "නර්තනය"
          SpecialFeatureSection.SINHALA_LITERATURE -> "සිංහල"
          SpecialFeatureSection.BUDDHISM_DHAMMA -> "බුද්ධ ධර්මය"
          SpecialFeatureSection.GEOMETRY_STRUCTURED -> "ගණිතය"
          else -> null
        }
    }
  }

  // Load subject-specific 20 Categories (each with 20 facts)
  val subjectCategories = remember(currentSubject) {
    if (currentSubject != null) {
      SubjectMasterRepository.getCategoriesForSubject(currentSubject)
    } else {
      emptyList()
    }
  }

  // selectedSubTab:
  // 0 -> Special Interactive Tool for this subject (e.g. 1:50,000 Topo Map Reading, Diagrams, etc.)
  // -1 -> All 20 Categories (400 facts)
  // 1..20 -> Category 1 to 20
  var selectedSubTab by remember { mutableStateOf(initialCategoryNumber ?: -1) }
  var isToolsFullScreen by remember { mutableStateOf(false) }

  // Fallback for general unconstrained access
  var selectedSection by remember { mutableStateOf(initialSection ?: SpecialFeatureSection.SCIENCE_DIAGRAMS) }

  val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

  // Suppress static outer top bar & tab row for views so internal LazyColumn can scroll full screen!
  val showOuterBars = !isToolsFullScreen

  Scaffold(
    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = {
      if (showOuterBars) {
        TopAppBar(
          title = {
            Column {
              if (currentSubject != null) {
                Text(
                  text = "$currentSubject - විශේෂ මෙවලම් & කරුණු සංග්‍රහය",
                  fontSize = 15.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  maxLines = 1,
                  overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )
                Text(
                  text = "සාමාන්‍ය පෙළ (10 & 11) $currentSubject නිල විෂය නිර්දේශයේ ප්‍රධාන කාණ්ඩ 20",
                  fontSize = 11.sp,
                  color = Color(0xFF34D399),
                  maxLines = 1,
                  overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )
              } else {
                Text(
                  text = "O/L විශේෂ අන්තර්ක්‍රියාකාරී මෙවලම්",
                  fontSize = 16.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )
                Text(
                  text = "විද්‍යාව • ඉංග්‍රීසි • ඉතිහාසය • භූගෝලය • කොමස් • නර්තනය",
                  fontSize = 11.sp,
                  color = Color(0xFF94A3B8)
                )
              }
            }
          },
          navigationIcon = {
            IconButton(
              onClick = onBack,
              modifier = Modifier.testTag("special_features_back_btn")
            ) {
              Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
              )
            }
          },
          colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF0F172A)
          ),
          scrollBehavior = scrollBehavior
        )
      }
    },
    containerColor = Color(0xFF0B132B)
  ) { padding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(if (!showOuterBars) PaddingValues(0.dp) else padding)
    ) {
      if (showOuterBars) {
        if (currentSubject != null && subjectCategories.isNotEmpty()) {
          // STRICT SUBJECT ISOLATION: The tab bar contains ONLY the active subject's tool & 20 categories!
          // All other subjects are completely removed.
          val activeTabIndex = when {
            selectedSubTab == 0 -> 0
            selectedSubTab == -1 -> 1
            else -> (selectedSubTab + 1).coerceIn(0, subjectCategories.size + 1)
          }

          ScrollableTabRow(
            selectedTabIndex = activeTabIndex,
            containerColor = Color(0xFF0F172A),
            contentColor = Color.White,
            edgePadding = 12.dp,
            divider = { HorizontalDivider(color = Color(0xFF334155)) }
          ) {
            // Tab 0: Interactive Feature Tool for this specific subject
            Tab(
              selected = selectedSubTab == 0,
              onClick = { selectedSubTab = 0 },
              text = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text("🌟", fontSize = 13.sp)
                  Spacer(modifier = Modifier.width(5.dp))
                  Text(
                    text = "විශේෂ මෙවලම",
                    fontSize = 11.5.sp,
                    fontWeight = if (selectedSubTab == 0) FontWeight.Bold else FontWeight.Normal,
                    color = if (selectedSubTab == 0) Color(0xFF10B981) else Color(0xFF94A3B8)
                  )
                }
              }
            )

            // Tab 1: All 20 Categories (All 400 facts)
            Tab(
              selected = selectedSubTab == -1,
              onClick = { selectedSubTab = -1 },
              text = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text("🌐", fontSize = 13.sp)
                  Spacer(modifier = Modifier.width(5.dp))
                  Text(
                    text = "සියලු කාණ්ඩ (20)",
                    fontSize = 11.5.sp,
                    fontWeight = if (selectedSubTab == -1) FontWeight.Bold else FontWeight.Normal,
                    color = if (selectedSubTab == -1) Color(0xFF38BDF8) else Color(0xFF94A3B8)
                  )
                }
              }
            )

            // Tabs 1 to 20: Each specific category for THIS subject!
            subjectCategories.forEach { cat ->
              val isSel = selectedSubTab == cat.categoryNumber
              Tab(
                selected = isSel,
                onClick = { selectedSubTab = cat.categoryNumber },
                text = {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(cat.icon, fontSize = 13.sp)
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                      text = "${cat.categoryNumber}. ${cat.titleSinhala}",
                      fontSize = 11.5.sp,
                      fontWeight = if (isSel) FontWeight.Bold else FontWeight.Normal,
                      color = if (isSel) cat.color else Color(0xFF94A3B8)
                    )
                  }
                }
              )
            }
          }
        } else {
          // General Tab Row fallback when not bound to a subject
          ScrollableTabRow(
            selectedTabIndex = SpecialFeatureSection.values().indexOf(selectedSection),
            containerColor = Color(0xFF0F172A),
            contentColor = Color.White,
            edgePadding = 12.dp,
            divider = { HorizontalDivider(color = Color(0xFF334155)) }
          ) {
            SpecialFeatureSection.values().forEach { section ->
              val isSelected = selectedSection == section
              Tab(
                selected = isSelected,
                onClick = { selectedSection = section },
                text = {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(section.icon, fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                      text = section.titleSinhala,
                      fontSize = 12.sp,
                      fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                      color = if (isSelected) section.color else Color(0xFF94A3B8)
                    )
                  }
                }
              )
            }
          }
        }
      }

      // Feature Content Body
      Box(
        modifier = Modifier
          .fillMaxSize()
          .background(Color(0xFF0B132B))
      ) {
        if (currentSubject != null && subjectCategories.isNotEmpty()) {
          when (selectedSubTab) {
            0 -> {
              // Interactive tool strictly for the active subject
              when {
                currentSubject.contains("භූගෝල") || currentSubject.contains("geography", ignoreCase = true) -> {
                  GeographyTopoMapsAndRegionsFeatureView(onOpenCategories = { selectedSubTab = 1 })
                }
                currentSubject.contains("විද්‍යාව") || currentSubject.contains("science", ignoreCase = true) -> {
                  ScienceDiagramsAndFormulaFeatureView(onOpenCategories = { selectedSubTab = -1 })
                }
                currentSubject.contains("ඉතිහාස") || currentSubject.contains("history", ignoreCase = true) -> {
                  HistoryTimelineAndMapPinningFeatureView()
                }
                currentSubject.contains("ඉංග්‍රීසි") || currentSubject.contains("english", ignoreCase = true) -> {
                  EnglishWritingVaultAndVerbsFeatureView()
                }
                currentSubject.contains("ව්‍යාපාර") || currentSubject.contains("ගිණුම්") || currentSubject.contains("commerce", ignoreCase = true) -> {
                  CommerceDoubleEntryAndAccountsFeatureView()
                }
                currentSubject.contains("නර්තන") || currentSubject.contains("dance", ignoreCase = true) -> {
                  DancingTraditionsAndVannamFeatureView()
                }
                currentSubject.contains("සිංහල") || currentSubject.contains("sinhala", ignoreCase = true) -> {
                  SinhalaLiteratureFeatureView()
                }
                currentSubject.contains("බුද්ධ") || currentSubject.contains("buddhism", ignoreCase = true) -> {
                  BuddhismDhammaFeatureView()
                }
                currentSubject.contains("ගණිත") || currentSubject.contains("math", ignoreCase = true) -> {
                  GeometryStructuredQuestionsHubScreen(onBack = { onBack() })
                }
                currentSubject.contains("පුරවැසි") || currentSubject.contains("civic", ignoreCase = true) -> {
                  CivicsEducationFeatureView(onOpenCategories = { selectedSubTab = 1 })
                }
                else -> {
                  SubjectMaster20CategoriesDetailView(
                    subjectName = currentSubject,
                    categories = subjectCategories,
                    selectedCategoryNumber = 0,
                    onSelectCategory = { selectedSubTab = it }
                  )
                }
              }
            }
            -1 -> {
              // All 20 Categories (All 400 facts) for this subject
              SubjectMaster20CategoriesDetailView(
                subjectName = currentSubject,
                categories = subjectCategories,
                selectedCategoryNumber = 0,
                onSelectCategory = { selectedSubTab = it },
                onOpenInteractiveTool = { selectedSubTab = 0 }
              )
            }
            else -> {
              // Specific category (1 to 20) with its 20 facts
              SubjectMaster20CategoriesDetailView(
                subjectName = currentSubject,
                categories = subjectCategories,
                selectedCategoryNumber = selectedSubTab,
                onSelectCategory = { selectedSubTab = it },
                onOpenInteractiveTool = { selectedSubTab = 0 }
              )
            }
          }
        } else {
          when (selectedSection) {
            SpecialFeatureSection.SCIENCE_DIAGRAMS -> ScienceDiagramsAndFormulaFeatureView()
            SpecialFeatureSection.ENGLISH_WRITING_VAULT -> EnglishWritingVaultAndVerbsFeatureView()
            SpecialFeatureSection.HISTORY_TIMELINE_MAPS -> HistoryTimelineAndMapPinningFeatureView()
            SpecialFeatureSection.GEOGRAPHY_TOPOMAPS -> GeographyTopoMapsAndRegionsFeatureView()
            SpecialFeatureSection.COMMERCE_DOUBLE_ENTRY -> CommerceDoubleEntryAndAccountsFeatureView()
            SpecialFeatureSection.DANCING_TRADITIONS -> DancingTraditionsAndVannamFeatureView()
            SpecialFeatureSection.SINHALA_LITERATURE -> SinhalaLiteratureFeatureView()
            SpecialFeatureSection.BUDDHISM_DHAMMA -> BuddhismDhammaFeatureView()
            SpecialFeatureSection.GEOMETRY_STRUCTURED -> GeometryStructuredQuestionsHubScreen(
              onBack = { selectedSection = SpecialFeatureSection.SCIENCE_DIAGRAMS }
            )
            SpecialFeatureSection.DAILY_5MIN_CHALLENGE -> Daily5MinChallengeFeatureView()
            SpecialFeatureSection.OFFICIAL_MARKING_SCHEME -> OfficialMarkingSchemesFeatureView(onOpenPdfModal)
            SpecialFeatureSection.OL_ORIGINAL_PAST_PAPERS_10YEARS -> OlTenYearOriginalPastPapersHubScreen(
              studentName = "ශිෂ්‍ය ගිණුම",
              onOpenPdfModal = onOpenPdfModal,
              onBack = { selectedSection = SpecialFeatureSection.SCIENCE_DIAGRAMS }
            )
          }
        }
      }
    }
  }
}

// ==============================================================================
// 1. SCIENCE: INTERACTIVE DIAGRAM LABELING & FORMULA BANK
// ==============================================================================

data class ScienceDiagramItem(
  val id: String,
  val titleSinhala: String,
  val category: String,
  val description: String,
  val parts: List<Pair<String, String>>, // Part Name -> Sinhala Explanation
  val examTips: String
)

data class ScienceExperimentItem(
  val id: String,
  val titleSinhala: String,
  val category: String,
  val aimAndPrinciple: String,
  val apparatusAndReagents: List<String>,
  val procedureSteps: List<String>,
  val observationAndConclusion: String,
  val examTips: String
)

@Composable
fun ScienceDiagramsAndFormulaFeatureView(
  onOpenCategories: (() -> Unit)? = null
) {
  var selectedTab by remember { mutableStateOf(0) }
  val diagrams = remember {
    listOf(
      ScienceDiagramItem(
        id = "heart",
        titleSinhala = "1. මානව හෘදයේ අභ්‍යන්තර ව්‍යුහය (Human Heart Structure)",
        category = "ජීව විද්‍යාව",
        description = "මිනිස් හෘදයේ කර්ණිකා, කෝෂිකා, මහා ධමනිය, පුප්ඵුසීය රුධිර නාල සහ කපාට ක්‍රියාකාරිත්වය.",
        parts = listOf(
          "දකුණු කර්ණිකාව (Right Atrium)" to "ශරීරයේ ඉහළ හා පහළ මහා ශිරා මගින් ඔක්සිජන් විරහිත රුධිරය ලබාගනී.",
          "දකුණු කෝෂිකාව (Right Ventricle)" to "පුප්ඵුසීය ධමනිය හරහා පෙණහලු වෙත ඔක්සිජන් විරහිත රුධිරය පොම්ප කරයි.",
          "වම් කර්ණිකාව (Left Atrium)" to "පෙණහලුවල සිට පුප්ඵුසීය ශිරා 4 මගින් ඔක්සිජනීකෘත රුධිරය ලබාගනී.",
          "වම් කෝෂිකාව (Left Ventricle)" to "ශරීරයේ සියලු අවයව වෙත මහා ධමනිය හරහා ඔක්සිජනීකෘත රුධිරය පොම්ප කරයි. (වඩාත් ඝනකම් මාංශ පේශි බිත්තියක් ඇත).",
          "අග්‍ර ත්‍රිපත්‍ර කපාටය (Tricuspid Valve)" to "දකුණු කර්ණිකාව සහ දකුණු කෝෂිකාව අතර පිහිටා රුධිරය ආපසු ගලායාම වළක්වයි.",
          "අග්‍ර ද්විපත්‍ර / මයිට්‍රල් කපාටය (Bicuspid/Mitral Valve)" to "වම් කර්ණිකාව සහ වම් කෝෂිකාව අතර පිහිටා ඇත.",
          "මහා ධමනිය (Aorta)" to "හෘදයෙන් පිටවන ප්‍රධානතම හා විශාලතම ධමනියයි. අඩසඳ කපාට සහිතයි."
        ),
        examTips = "💡 විභාග ඉඟිය: වම් කෝෂිකා බිත්තිය දකුණු කෝෂිකා බිත්තියට වඩා ඝනකම් වීමට හේතුව මුළු ශරීරය පුරාම වැඩි පීඩනයකින් රුධිරය පොම්ප කිරීමට සිදුවීමයි."
      ),
      ScienceDiagramItem(
        id = "eye",
        titleSinhala = "2. මානව අක්ෂියේ ව්‍යුහය සහ දෘෂ්ටිය (Human Eye Structure)",
        category = "ජීව විද්‍යාව",
        description = "ආලෝකය නාභිගත කිරීම, කනීනිකාව, තාරකාව, අක්ෂි කාචය සහ දෘෂ්ටිවිතානයේ ක්‍රියාකාරිත්වය.",
        parts = listOf(
          "ස්වච්ඡය (Cornea)" to "අක්ෂි ගෝලයේ ඉදිරිපස ඇති විනිවිද පෙනෙන ස්ථරයයි. ආලෝක කිරණ වර්තනය කරයි.",
          "තාරකාව (Iris)" to "අක්ෂියට ඇතුළු වන ආලෝක ප්‍රමාණය පාලනය කරන වර්ණවත් පටලයයි.",
          "කනීනිකාව (Pupil)" to "තාරකාව මධ්‍යයේ ඇති විවරයයි.",
          "ද්විඋත්තල අක්ෂි කාචය (Crystalline Lens)" to "ආලෝක කිරණ දෘෂ්ටිවිතානය මත නාභිගත කරයි.",
          "දෘෂ්ටිවිතානය (Retina)" to "දණ්ඩ සහ කේතු සෛල සහිත ආලෝක සංවේදී පටලයයි. යටිකුරු තාත්වික ප්‍රතිබිම්බයක් සෑදේ.",
          "කහ බින්දුව (Yellow Spot / Fovea)" to "වඩාත් පැහැදිලිම ප්‍රතිබිම්බය ලැබෙන, කේතු සෛල බහුල ස්ථානයයි.",
          "අන්ධ බින්දුව (Blind Spot)" to "දෘෂ්ටි ස්නායුව අක්ෂියෙන් පිටවන ස්ථානයයි. ආලෝක සංවේදී සෛල නොමැත."
        ),
        examTips = "💡 විභාග ඉඟිය: දුර දෘෂ්ටිකත්වය (Hypermetropia) නිවැරදි කිරීමට උත්තල කාචද, අවිදුර දෘෂ්ටිකත්වය (Myopia) නිවැරදි කිරීමට අවතල කාචද භාවිත කෙරේ."
      ),
      ScienceDiagramItem(
        id = "plant_cell",
        titleSinhala = "3. ශාක හා සත්ව සෛල ව්‍යුහය (Plant & Animal Cell)",
        category = "ජීව විද්‍යාව",
        description = "සෛල බිත්තිය, හරිතලව, මයිටොකොන්ඩ්‍රියා, රයිබොසෝම සහ න්‍යෂ්ටියේ විද්‍යාත්මක සැකැස්ම.",
        parts = listOf(
          "සෛල බිත්තිය (Cell Wall)" to "සෙලියුලෝස් වලින් සෑදී ඇත. ශාක සෛලයට නිශ්චිත හැඩයක් හා ශක්තියක් ලබාදේ.",
          "ප්ලාස්ම පටලය (Plasma Membrane)" to "අර්ධ පාරගම්‍ය පටලයකි. ද්‍රව්‍ය ගමනාගමනය පාලනය කරයි.",
          "හරිතලව (Chloroplast)" to "ප්‍රභාසංස්ලේෂණය සිදුකරන හරිතප්‍රද අඩංගු ඉන්ද්‍රියිකාවයි.",
          "මයිටොකොන්ඩ්‍රියාව (Mitochondria)" to "සෛලයේ බලාගාරයයි (Power house). සෛලීය ශ්වසනය මගින් ATP ශක්තිය නිපදවයි.",
          "න්‍යෂ්ටිය (Nucleus)" to "සෛලීය සියලු ක්‍රියාකාරකම් පාලනය කරන, ජානමය ද්‍රව්‍ය (DNA) සහිත ප්‍රධාන ඉන්ද්‍රියිකාවයි."
        ),
        examTips = "💡 සත්ව සෛලවල සෛල බිත්ති, විශාල මධ්‍ය රික්තක සහ හරිතලව නොපිහිටයි; සෙන්ට්‍රියෝල පිහිටයි."
      ),
      ScienceDiagramItem(
        id = "electrolysis",
        titleSinhala = "4. ජලය හා තඹ සල්ෆේට් විද්‍යුත් විච්ඡේදනය (Electrolysis)",
        category = "රසායන විද්‍යාව",
        description = "කැතෝඩය, ඇනෝඩය, අයන චලිතය සහ වායු මුදාහැරීමේ රසායනික ප්‍රතික්‍රියා.",
        parts = listOf(
          "ඇනෝඩය (Anode - ධන අග්‍රය)" to "ඉලෙක්ට්‍රෝන පිටවන අග්‍රයයි. ජල විච්ඡේදනයේදී O₂ (ඔක්සිජන්) වායුව පිටවේ.",
          "කැතෝඩය (Cathode - සෘණ අග්‍රය)" to "ඉලෙක්ට්‍රෝන ඇතුළු වන අග්‍රයයි. ජල විච්ඡේදනයේදී H₂ (හයිඩ්‍රජන්) වායුව පිටවේ.",
          "විද්‍යුත් විච්ඡේද්‍යය (Electrolyte)" to "අයන මගින් විද්‍යුතය ගෙනයන ද්‍රාවණයයි. (උදා: තනුක H₂SO₄ හෝ CuSO₄ ද්‍රාවණය)."
        ),
        examTips = "💡 ජල විච්ඡේදනයේදී කැතෝඩයේ පිටවන H₂ වායු පරිමාව ඇනෝඩයේ පිටවන O₂ පරිමාව මෙන් දෙගුණයකි (H₂ : O₂ = 2 : 1)."
      ),
      ScienceDiagramItem(
        id = "human_ear",
        titleSinhala = "5. මානව කර්ණයේ ව්‍යුහය සහ ශ්‍රවණය (Human Ear Structure)",
        category = "ජීව විද්‍යාව",
        description = "බාහිර කර්ණය, මධ්‍ය කර්ණය, අභ්‍යන්තර කර්ණය සහ ශරීර සමතුලිතතාව පවත්වාගැනීම.",
        parts = listOf(
          "කර්ණ පෙත්ත (Pinna)" to "ශබ්ද තරංග එක්රැස් කර බාහිර ශ්‍රවණ නාලය තුළට යොමු කරයි.",
          "කර්ණ පටහ පටලය (Tympanic Membrane)" to "ශබ්ද තරංග වැදීමෙන් කම්පනය වන තුනී පටලයයි.",
          "කර්ණ අස්ථිකා (Malleus, Incus, Stapes)" to "මිටිය, කිණිහිර, අඩිය යන කුඩා අස්ථි 3 මගින් කම්පන 20 ගුණයකින් පමණ විස්තාරණය කරයි.",
          "කර්ණ ශංඛය (Cochlea)" to "ශ්‍රවණ සංවේදක සෛල (කෝටි අංගය) පිහිටි ද්‍රව පිරි සර්පිලාකාර ව්‍යුහයයි.",
          "අර්ධ චක්‍රාකාර නාල (Semicircular Canals)" to "ශරීරයේ ගතික සමතුලිතතාව පවත්වාගැනීමට උපකාරී වේ.",
          "යුස්ටේකීය නාලය (Eustachian Tube)" to "කර්ණ පටහ පටලයේ දෙපස වායු පීඩනය සමාන කරයි (ග්‍රසනිකාවට විවෘත වේ)."
        ),
        examTips = "💡 ශරීරයේ කුඩාම අස්ථිය 'අඩිය' (Stapes) වන අතර එය පිහිටන්නේ මධ්‍ය කර්ණයේය."
      ),
      ScienceDiagramItem(
        id = "kidney_nephron",
        titleSinhala = "6. වෘක්කයේ සහ නෙෆ්‍රෝනයේ ව්‍යුහය (Kidney & Nephron)",
        category = "ජීව විද්‍යාව",
        description = "වෘක්ක බහිස්ස්‍රාවී පද්ධතිය, ග්ලොමරුලසය, බෝමන් ප්‍රවාරය සහ මුත්‍රා සෑදීමේ පියවර.",
        parts = listOf(
          "වෘක්ක කෝටිසය (Renal Cortex)" to "වෘක්කයේ පිටත කලාපයයි. බෝමන් ප්‍රවාර හා ග්ලොමරුලස පිහිටයි.",
          "වෘක්ක මෙඩුලාව (Renal Medulla)" to "ඇතුළත පිරමිඩාකාර ව්‍යුහ සහිත කලාපයයි. හෙන්ලේ පුඩුව පිහිටයි.",
          "ග්ලොමරුලසය (Glomerulus)" to "අභිවාහී ධමනිකාවෙන් සෑදුණු කේශනාලිකා ගුච්ඡයයි. අධිපෙරීම සිදුවේ.",
          "බෝමන් ප්‍රවාරය (Bowman's Capsule)" to "ග්ලොමරුලික පෙරනය එක්රැස් කරගන්නා බඳුනක් බඳු ව්‍යුහයයි.",
          "සමීපස්ථ සංවලිත නාලිකාව" to "ග්ලූකෝස්, ඇමයිනෝ අම්ල සහ ජලය 100% ක් නැවත අවශෝෂණය වේ.",
          "හෙන්ලේ පුඩුව (Loop of Henle)" to "ජලය හා ලවණ සමතුලිතතාව ආරක්ෂා කරයි."
        ),
        examTips = "💡 නිරෝගී පුද්ගලයෙකුගේ මුත්‍රාවල ග්ලූකෝස් අඩංගු නොවේ; මන්ද සමීපස්ථ නාලිකාවේදී සම්පූර්ණයෙන්ම යළි අවශෝෂණය වන බැවිනි."
      ),
      ScienceDiagramItem(
        id = "leaf_stomata",
        titleSinhala = "7. ශාක පත්‍රයක අභ්‍යන්තර ව්‍යුහය (Leaf Anatomy & Stomata)",
        category = "ජීව විද්‍යාව",
        description = "උච්චර්මය, පාලක සෛල, වායුරන්ධ්‍ර, ස්පොන්ජි හා කූරු පටකය සහ සනාල කලාප.",
        parts = listOf(
          "උඩු උච්චර්මය සහ කියුටිකලය" to "ජල හානිය වළක්වන ඉටිමය විනිවිද පෙනෙන ස්ථරයයි.",
          "කූරු පටකය (Palisade Mesophyll)" to "හරිතලව බහුලව පිහිටා ප්‍රභාසංස්ලේෂණය උපරිමයෙන් සිදුකරන ස්ථරයයි.",
          "ස්පොන්ජි පටකය (Spongy Mesophyll)" to "විශාල වායු අවකාශ සහිත, වායු හුවමාරුවට උපකාරී වන ස්ථරයයි.",
          "වායුරන්ධ්‍ර සහ පාලක සෛල (Guard Cells)" to "වාෂ්පෝත්ස්වේදනය සහ වායු හුවමාරුව පාලනය කරයි (පාලක සෛල වෘක්කාකාර වේ).",
          "ශෛලමය (Xylem)" to "ජලය සහ ඛණිජ ලවණ මුලේ සිට පත්‍ර වෙත ඉහළට පරිවහනය කරයි.",
          "ෆ්ලෝයමය (Phloem)" to "පත්‍රවල නිපදවන ආහාර (සුක්‍රෝස්) ශාකයේ අනෙකුත් කොටස් වෙත පරිවහනය කරයි."
        ),
        examTips = "💡 දිවා කාලයේදී පාලක සෛලවල තද බව වැඩි වී වායුරන්ධ්‍ර විවෘත වන අතර රාත්‍රියේදී ආලෝකය නොමැති විට වැසේ."
      ),
      ScienceDiagramItem(
        id = "flower_reproduction",
        titleSinhala = "8. මලක කොටස් සහ ප්‍රජනනය (Flower Anatomy & Pollination)",
        category = "ජීව විද්‍යාව",
        description = "මෘදුලෝහක, පුෂ්පෝපහාර, කලාප, ජායාංගය (ස්ත්‍රී) සහ පුමාංගය (පුරුෂ) සංසන්දනය.",
        parts = listOf(
          "පුෂ්ප මඤ්ජරිය / පුෂ්පය" to "ශාකවල ලිංගික ප්‍රජනන අවයවයයි.",
          "කලංකය (Stigma)" to "පරාග ඇලෙන සුළු මතුපිටක් සහිත ජායාංගයේ අග්‍රස්ථ කොටසයි.",
          "කීලය සහ ඩිම්බකෝෂය" to "ඩිම්බකෝෂය තුළ ඩිම්බ පිහිටන අතර සංසේචනයෙන් පසු ඩිම්බකෝෂය ගෙඩිය බවටද ඩිම්බ බීජ බවටද පත්වේ.",
          "පරාගධානය (Anther)" to "පරාග රේණු (පුරුෂ ජන්මාණු) නිපදවයි.",
          "රේණුව (Filament)" to "පරාගධානය දරා සිටින සිහින් නටුවයි."
        ),
        examTips = "💡 සුළඟින් පරාගනය වන මල්වල පරාග සැහැල්ලු හා වියළි වන අතර කෘමීන්ගෙන් පරාගනය වන මල් දීප්තිමත් පැහැයෙන් හා මධුරසයෙන් යුක්තය."
      ),
      ScienceDiagramItem(
        id = "reflex_arc",
        titleSinhala = "9. ප්‍රත්‍යාවර්ත චාපය (Reflex Arc & Nervous System)",
        category = "ජීව විද්‍යාව",
        description = "සංවේදක නියුරෝනය, සම්බන්ධක නියුරෝනය, සුෂුම්නාව සහ ප්‍රතිචාර දැක්වීම.",
        parts = listOf(
          "සංවේදක අවයවය (Receptor)" to "උත්තේජය (උදා: රස්නය හෝ කටුවක් ඇනීම) හඳුනාගනී.",
          "සංවේදක නියුරෝනය (Sensory Neuron)" to "ආවේගය සුෂුම්නාව දෙසට රැගෙන යයි.",
          "සම්බන්ධක නියුරෝනය (Interneuron)" to "සුෂුම්නාවේ පිහිටා ආවේගය විශ්ලේෂණය කර චාලක නියුරෝනයට යොමු කරයි.",
          "චාලක නියුරෝනය (Motor Neuron)" to "ආවේගය ක්‍රියාකාරක අවයවය (පේෂිය) වෙත ගෙන යයි.",
          "ක්‍රියාකාරකය (Effector)" to "පේෂිය හැකිලීම මගින් අත ක්ෂණිකව ඉවතට ගැනීම සිදුකරයි."
        ),
        examTips = "💡 ප්‍රත්‍යාවර්ත ක්‍රියා මොළයේ මැදිහත්වීමකින් තොරව සුෂුම්නාව මගින් ක්ෂණිකව පාලනය වන ස්වයංක්‍රීය ආරක්ෂක ක්‍රියාවලියකි."
      ),
      ScienceDiagramItem(
        id = "blast_furnace",
        titleSinhala = "10. යකඩ නිස්සාරණය - වාත්‍යා ඌෂ්මකය (Blast Furnace)",
        category = "රසායන විද්‍යාව",
        description = "හේමටයිට්, කෝක්, හුණුගල්, උණු කළ යකඩ හා කසල ද්‍රව්‍ය (Slag) වෙන්වීම.",
        parts = listOf(
          "අමුද්‍රව්‍ය ආදානය" to "හේමටයිට් (Fe₂O₃), කෝක් (C) සහ හුණුගල් (CaCO₃) ඉහළින් ඇතුළු කරයි.",
          "කෝක් දහනය (පහළ කලාපය)" to "C + O₂ → CO₂ (තාපදායක ප්‍රතික්‍රියාව, උෂ්ණත්වය 1900 °C පමණ වේ).",
          "කාබන් මොනොක්සයිඩ් සෑදීම" to "CO₂ + C → 2CO (ප්‍රධාන ඔක්සිහාරකය CO වේ).",
          "යකඩ ඔක්සිහරණය" to "Fe₂O₃ + 3CO → 2Fe + 3CO₂ (දියවූ යකඩ ඌෂ්මකයේ පතුලේ එක්රැස් වේ).",
          "කසල සෑදීම (Slag formation)" to "CaCO₃ → CaO + CO₂ | CaO + SiO₂ → CaSiO₃ (කසල යකඩ මත පාවේ)."
        ),
        examTips = "💡 කැල්සියම් සිලිකේට් (කසල) යකඩවලට වඩා ඝනත්වයෙන් අඩු නිසා යකඩ මත පාවෙමින් යකඩ නැවත ඔක්සිකරණය වීම වළක්වයි."
      )
    )
  }

  val experiments = remember {
    listOf(
      ScienceExperimentItem(
        id = "starch_test",
        titleSinhala = "1. ප්‍රභාසංස්ලේෂණයට ආලෝකය අත්‍යවශ්‍ය බව පෙන්වීම (Starch Test)",
        category = "ජීව විද්‍යාව",
        aimAndPrinciple = "ප්‍රභාසංස්ලේෂණයේදී පිෂ්ඨය නිපදවෙන බව සහ ඊට ආලෝකය අනිවාර්ය බව තහවුරු කිරීම.",
        apparatusAndReagents = listOf("බඳුන්ගත ශාකයක්", "කළු කඩදාසි", "එතනෝල් (මත්පැන්)", "ජල තාපකය", "අයඩින් ද්‍රාවණය", "පෙට්‍රි දීසිය"),
        procedureSteps = listOf(
          "ශාකය පැය 48ක් අඳුරේ තබා පත්‍ර පිෂ්ඨයෙන් තොර (Destarch) කරන්න.",
          "එක් පත්‍රයක කොටසක් කළු කඩදාසියකින් ආවරණය කර පැය කිහිපයක් හිරු එළියේ තබන්න.",
          "පත්‍රය නටන ජලයේ විනාඩියක් තම්බා සෛල මරා දමන්න.",
          "ජල තාපකයක් තුළ ඇති එතනෝල්වල පත්‍රය දමා රත් කර හරිතප්‍රද ඉවත් කරන්න (පත්‍රය සුදුමැලි වේ).",
          "පත්‍රය උණුසුම් ජලයෙන් සෝදා අයඩින් ද්‍රාවණය බින්දු කිහිපයක් දමන්න."
        ),
        observationAndConclusion = "ආලෝකය ලැබුණු කොටස තද නිල් පැහැයට හැරේ (පිෂ්ඨය ඇත). ආවරණය කළ කොටස ලා දුඹුරු පැහැව පවතී (පිෂ්ඨය නැත).",
        examTips = "💡 එතනෝල් දැවෙනසුළු ද්‍රවයක් බැවින් සෘජුව ගින්දරට නොඅල්වා අනිවාර්යයෙන්ම ජල තාපකයක රත් කළ යුතුය."
      ),
      ScienceExperimentItem(
        id = "bio_tests",
        titleSinhala = "2. ජෛව අණු හඳුනාගැනීමේ පරීක්ෂණ (Biomolecule Tests)",
        category = "ජීව විද්‍යාව",
        aimAndPrinciple = "ග්ලූකෝස්, පිෂ්ඨය, ප්‍රෝටීන සහ ලිපිඩ සාම්පල හඳුනාගැනීම.",
        apparatusAndReagents = listOf("බෙනඩික්ට් ද්‍රාවණය", "අයඩින් ද්‍රාවණය", "බියුරෙට් ද්‍රාවණය (NaOH + CuSO₄)", "සුඩාන් III", "පරීක්ෂණ නළ"),
        procedureSteps = listOf(
          "ඔක්සිහාරක සීනි (ග්ලූකෝස්): සාම්පලයට බෙනඩික්ට් දමා ජල තාපකයක රත් කරන්න → නිල් → කොළ → කහ → ගඩොල් රතු අවක්ෂේපය.",
          "පිෂ්ඨය: සාම්පලයට අයඩින් බින්දු 2ක් එක් කරන්න → ලා දුඹුරු පැහැය තද නිල් පැහැයට හැරේ.",
          "ප්‍රෝටීන: සාම්පලයට බියුරෙට් ද්‍රාවණය එක් කරන්න → ලා නිල් පැහැය දම්/රෝස පැහැයට හැරේ.",
          "ලිපිඩ: සාම්පලයට සුඩාන් III දමා සොලවන්න → රතු පැහැති තෙල් බිඳිති පාවෙයි (හෝ සුදු කඩදාසියක ඇතිල්ලූ විට පාරභාසක පැල්ලමක්)."
        ),
        observationAndConclusion = "වර්ණ විපර්යාස මගින් අදාළ ජෛව අණුව නිවැරදිව තහවුරු කෙරේ.",
        examTips = "💡 සුක්‍රෝස් අනොක්සිහාරක සීනි වර්ගයක් බැවින් සෘජු බෙනඩික්ට් පරීක්ෂාවට ධන ප්‍රතිචාර නොදක්වයි; තනුක අම්ලයක් සමග රත් කර උදාසීන කළ පසු පරීක්ෂා කළ යුතුය."
      ),
      ScienceExperimentItem(
        id = "gas_prep",
        titleSinhala = "3. රසායනාගාරයේදී O₂, H₂ සහ CO₂ වායු පිළියෙල කිරීම",
        category = "රසායන විද්‍යාව",
        aimAndPrinciple = "ප්‍රධාන වායූන් තුන රසායනාගාරයේදී නිපදවීම සහ හඳුනාගැනීමේ නිරීක්ෂණ.",
        apparatusAndReagents = listOf("KMnO₄ / H₂O₂ + MnO₂", "Zn + තනුක HCl", "CaCO₃ + තනුක HCl", "හුණු දියර", "දැල්වෙන හබල පෙත්ත"),
        procedureSteps = listOf(
          "ඔක්සිජන් (O₂): H₂O₂ ද්‍රාවණයට MnO₂ (උත්ප්‍රේරක) එක් කරන්න. ජලයේ පහළ විස්ථාපනයෙන් එකතු කරන්න.",
          "හයිඩ්‍රජන් (H₂): සින්ක් (Zn) කැබලිවලට තනුක HCl එක් කරන්න. වාතයේ ඉහළ විස්ථාපනයෙන් එකතු කරන්න.",
          "කාබන් ඩයොක්සයිඩ් (CO₂): හුණුගල් කැබලිවලට (CaCO₃) තනුක HCl එක් කරන්න. වාතයේ පහළ විස්ථාපනයෙන් එකතු කරන්න."
        ),
        observationAndConclusion = "O₂: පුලිඟු සහිත හබල පෙත්තක් දැල්වේ. | H₂: දැල්වෙන හබල පෙත්තක් 'පොප්' ශබ්දය නගමින් නිල් දැල්ලෙන් දැල්වේ. | CO₂: හුණු දියර කිරි පාට කරයි.",
        examTips = "💡 CO₂ වැඩිවේලාවක් හුණු දියර තුළින් යැවූ විට ද්‍රාව්‍ය කැල්සියම් බයිකාබනේට් සෑදීම නිසා කිරි පාට නැවත අවර්ණ වේ."
      ),
      ScienceExperimentItem(
        id = "reactivity_series",
        titleSinhala = "4. ලෝහවල ක්‍රියාකාරීත්ව ශ්‍රේණිය සහ ප්‍රතික්‍රියා (Activity Series)",
        category = "රසායන විද්‍යාව",
        aimAndPrinciple = "K > Na > Ca > Mg > Al > Zn > Fe > Pb > (H) > Cu > Ag > Au",
        apparatusAndReagents = listOf("Mg, Zn, Fe, Cu පටි", "තනුක HCl", "ජලය", "පරීක්ෂණ නළ"),
        procedureSteps = listOf(
          "ලෝහ සාම්පල සිසිල් ජලයට දමන්න (K, Na ක්ෂණිකව ප්‍රචණ්ඩ ලෙස ප්‍රතික්‍රියා කරයි; Ca මන්දගාමීව H₂ පිටකරයි).",
          "Mg ජල වාෂ්ප සමග රත් කළ විට දැල්වෙමින් ප්‍රතික්‍රියා කරයි (MgO + H₂).",
          "Zn, Fe, Cu තනුක HCl අම්ලයට දමන්න: Zn වේගයෙන් H₂ බුබුළු නගයි, Fe මන්දගාමීව, Cu කිසිදු ප්‍රතික්‍රියාවක් නොදක්වයි."
        ),
        observationAndConclusion = "ක්‍රියාකාරීත්ව ශ්‍රේණියේ හයිඩ්‍රජන්ට ඉහළින් ඇති ලෝහ අම්ල සමග ප්‍රතික්‍රියා කර H₂ වායුව නිදහස් කරයි; පහළින් ඇති Cu, Ag ප්‍රතික්‍රියා නොකරයි.",
        examTips = "💡 වඩා ක්‍රියාකාරී ලෝහයකට අඩු ක්‍රියාකාරී ලෝහයක් එහි ලවණ ද්‍රාවණයකින් විස්ථාපනය කළ හැක (උදා: Fe + CuSO₄ → FeSO₄ + Cu)."
      ),
      ScienceExperimentItem(
        id = "acid_base_titration",
        titleSinhala = "5. අම්ල, භෂ්ම සහ දර්ශක වර්ණ (Titration & Indicators)",
        category = "රසායන විද්‍යාව",
        aimAndPrinciple = "අම්ලයක් භෂ්මයකින් උදාසීන කිරීම සහ නිවැරදි අන්ත ලක්ෂ්‍යය හඳුනාගැනීම.",
        apparatusAndReagents = listOf("බියුරෙට්ටුව", "පිපෙට්ටුව", "කේතුක ප්ලාස්කුව", "HCl ද්‍රාවණය", "NaOH ද්‍රාවණය", "ෆීනෝල්ප්තැලීන් / මෙතිල් ඔරේන්ජ්"),
        procedureSteps = listOf(
          "පිපෙට්ටුවෙන් NaOH 25 cm³ ක් කේතුක ප්ලාස්කුවට ගෙන ෆීනෝල්ප්තැලීන් බින්දු 2ක් එක් කරන්න (රෝස පැහැ වේ).",
          "බියුරෙට්ටුවට HCl පුරවා බින්දුවෙන් බින්දුව එක් කරමින් සොලවන්න.",
          "ස්ථිරව රෝස පැහැය අවර්ණ වන නිමේෂයේදී බියුරෙට්ටු කියවීම සටහන් කරන්න (අන්ත ලක්ෂ්‍යය)."
        ),
        observationAndConclusion = "උදාසීනීකරණ ප්‍රතික්‍රියාව: HCl + NaOH → NaCl + H₂O",
        examTips = "💡 දර්ශක වර්ණ මතක තබාගන්න: ෆීනෝල්ප්තැලීන් අම්ලයේදී අවර්ණයි, භෂ්මයේදී රෝසයි. මෙතිල් ඔරේන්ජ් අම්ලයේදී රතුයි, භෂ්මයේදී කහයි."
      ),
      ScienceExperimentItem(
        id = "light_refraction",
        titleSinhala = "6. ආලෝක වර්තනය සහ පූර්ණ අභ්‍යන්තර පරාවර්තනය",
        category = "භෞතික විද්‍යාව",
        aimAndPrinciple = "ඝනත්වයෙන් අඩු මාධ්‍යයක සිට වැඩි මාධ්‍යයකට ආලෝකය ගමන් කිරීමේදී අභිලම්භය දෙසට නැමෙයි.",
        apparatusAndReagents = listOf("වීදුරු කුට්ටිය", "අර්ධ වෘත්තාකාර වීදුරු කුට්ටිය", "කිරණ පෙට්ටිය", "සුදු කඩදාසිය", "ප්‍රෝට්‍රැක්ටරය"),
        procedureSteps = listOf(
          "වීදුරු කුට්ටිය මතට ආනතව ආලෝක කිරණයක් යවා පතන කෝණය (i) සහ වර්තන කෝණය (r) මනින්න.",
          "අර්ධ වෘත්තාකාර කුට්ටියක ඝන මාධ්‍යයේ සිට විරල මාධ්‍යයට කිරණය යවමින් පතන කෝණය ක්‍රමයෙන් වැඩි කරන්න.",
          "වර්තන කෝණය 90° වන අවස්ථාවේ පතන කෝණය = 'අවධි කෝණය' (Critical Angle).",
          "පතන කෝණය අවධි කෝණයට වඩා වැඩි කළ විට ආලෝකය සම්පූර්ණයෙන්ම ආපසු ඝන මාධ්‍යයටම පරාවර්තනය වේ (පූර්ණ අභ්‍යන්තර පරාවර්තනය)."
        ),
        observationAndConclusion = "වීදුරුවල අවධි කෝණය ආසන්න වශයෙන් 42° කි. දෘශ්‍ය ප්‍රකාශ තන්තු (Optical Fibers) සහ මිරිඟුව ඇතිවීම මෙයට උදාහරණයි.",
        examTips = "💡 පූර්ණ අභ්‍යන්තර පරාවර්තනය සිදුවීමට කොන්දේසි 2කි: 1. ආලෝකය වඩා ඝන මාධ්‍යයේ සිට අඩු මාධ්‍යයට යා යුතුය. 2. පතන කෝණය අවධි කෝණයට වඩා විශාල විය යුතුය."
      ),
      ScienceExperimentItem(
        id = "cell_division",
        titleSinhala = "7. සෛල බෙදීම: අනූනනය සහ ඌනනය අදියර",
        category = "ජීව විද්‍යාව",
        aimAndPrinciple = "අනූනනය මගින් වර්ධනය හා අලුත්වැඩියාවද, ඌනනය මගින් ජන්මාණු නිපදවීමද සිදුවේ.",
        apparatusAndReagents = listOf("ළුණු මුල් අග්‍ර", "ඇසිටොකාමින් සායම්", "අන්වීක්ෂය", "වීදුරු කදාව"),
        procedureSteps = listOf(
          "පූර්ව අවස්ථාව (Prophase): වර්ණදේහ ඝන වී දර්ශනය වේ, න්‍යෂ්ටි පටලය බිඳ වැටේ.",
          "මධ්‍ය අවස්ථාව (Metaphase): වර්ණදේහ සෛලයේ සමක තලයේ පේළි ගැසේ.",
          "අනා අවස්ථාව (Anaphase): වර්ණදේහාංශ කේන්ද්‍රිකයෙන් වෙන් වී ප්‍රතිවිරුද්ධ ධ්‍රැව දෙසට ඇදී යයි.",
          "අන්ත අවස්ථාව (Telophase): ධ්‍රැවවලදී නව න්‍යෂ්ටි 2ක් සෑදී සෛල ප්ලාස්මය බෙදේ (සෛලප්ලාස්ම විභාජනය)."
        ),
        observationAndConclusion = "අනූනනයෙන් මාතෘ සෛලයට සමාන වර්ණදේහ (2n) සහිත දුහිතෘ සෛල 2ක්ද, ඌනනයෙන් වර්ණදේහ අර්ධයක් වූ (n) දුහිතෘ සෛල 4ක්ද ලැබේ.",
        examTips = "💡 ඌනනයේ ප්‍රථම පූර්ව අවස්ථාවේදී සිදුවන 'ප්‍රවේණික ප්‍රතිසංයෝජනය' (Crossing over) හේතුවෙන් ජීවීන් අතර ප්‍රවේණික විචල්‍යතා ඇතිවේ."
      ),
      ScienceExperimentItem(
        id = "genetics_cross",
        titleSinhala = "8. මෙන්ඩල්ගේ ප්‍රවේණි පරීක්ෂණ සහ පනට් කොටු",
        category = "ජීව විද්‍යාව",
        aimAndPrinciple = "මොනොහයිබ්‍රිඩ් මුහුම (Monohybrid Cross) මගින් ලක්ෂණ උරුම වීම.",
        apparatusAndReagents = listOf("පිරිසිදු උස මෑ ශාක (TT)", "පිරිසිදු මිටි මෑ ශාක (tt)", "පනට් කොටුව"),
        procedureSteps = listOf(
          "ජනක පරම්පරාව: TT (උස) × tt (මිටි)",
          "ජන්මාණු: T සහ t",
          "F1 පරම්පරාව: සියලු ශාක Tt (විෂමයුග්මක උස ශාක 100%)",
          "F1 ශාක ස්වයං පරාගනය (Tt × Tt): ජන්මාණු T, t සහ T, t",
          "F2 පරම්පරාවේ පනට් කොටුව: TT, Tt, Tt, tt"
        ),
        observationAndConclusion = "F2 රූපාදර්ශ අනුපාතය = 3 උස : 1 මිටි (3:1) | F2 ප්‍රවේණිදර්ශ අනුපාතය = 1 TT : 2 Tt : 1 tt (1:2:1).",
        examTips = "💡 ප්‍රමුඛ ලක්ෂණය පෙන්වීමට කැපිටල් අකුරද (T), නිලීන ලක්ෂණයට සිම්පල් අකුරද (t) යොදාගනී."
      ),
      ScienceExperimentItem(
        id = "electronics_circuits",
        titleSinhala = "9. ඩයෝඩ, LED සහ LDR පරිපථ පරීක්ෂණ",
        category = "භෞතික විද්‍යාව",
        aimAndPrinciple = "අර්ධ සන්නායක උපාංගවල විද්‍යුත් චර්යාව නිරීක්ෂණය කිරීම.",
        apparatusAndReagents = listOf("p-n සන්ධි ඩයෝඩය", "LED", "LDR", "වියළි කෝෂ 2ක්", "ප්‍රතිරෝධක", "ඇමීටරය"),
        procedureSteps = listOf(
          "ඩයෝඩය පෙර නැඹුරු කිරීම: p කොටස ධන අග්‍රයටත් n කොටස සෘණ අග්‍රයටත් සම්බන්ධ කරන්න → ධාරාව ගලායයි, LED දැල්වේ.",
          "ඩයෝඩය පසු නැඹුරු කිරීම: p කොටස සෘණයටත් n කොටස ධනයටත් හරවන්න → ධාරාව ගලා නොයයි, LED නොදැල්වේ (අධික ප්‍රතිරෝධයක් දක්වයි).",
          "LDR පරීක්ෂාව: ආලෝකය ඇති විට LDR ප්‍රතිරෝධය අඩු වී ධාරාව වැඩිවේ; LDR අඳුරු කළ විට ප්‍රතිරෝධය ඉතා ඉහළ වී ධාරාව බිංදුවට ආසන්න වේ."
        ),
        observationAndConclusion = "ඩයෝඩය ඒකදිශානත ධාරා සන්නයනය සිදුකරයි (සෘජුකරණය සඳහා යොදාගනී). LDR ආලෝක සංවේදකයකි.",
        examTips = "💡 AC (ප්‍රත්‍යාවර්ත) ධාරාව DC (සරල) ධාරාව බවට පත්කිරීම 'සෘජුකරණය' (Rectification) ලෙස හඳුන්වයි."
      ),
      ScienceExperimentItem(
        id = "rocks_minerals",
        titleSinhala = "10. පාෂාණ සහ ඛණිජ හඳුනාගැනීමේ පරීක්ෂණ",
        category = "පෘථිවි විද්‍යාව",
        aimAndPrinciple = "ආග්නේය, අවසාදිත හා විපරිත පාෂාණවල ලක්ෂණ හා ශ්‍රී ලංකාවේ ඛණිජ සම්පත්.",
        apparatusAndReagents = listOf("ග්‍රැනයිට්, හුණුගල්, කිරිගරුඬ සාම්පල", "තනුක HCl", "මිනිරන් (Graphite)", "ඇපටයිට්"),
        procedureSteps = listOf(
          "හුණුගල් (අවසාදිත) හෝ කිරිගරුඬ (විපරිත) මතට තනුක HCl බින්දුවක් දමන්න → CO₂ වායු බුබුළු නගිමින් පෙණ දමයි.",
          "ග්‍රැනයිට් (ආග්නේය): තද ඝන ස්ඵටිකරූපී ව්‍යුහය නිරීක්ෂණය කරන්න (ක්වාර්ට්ස්, ෆෙල්ඩ්ස්පාර්, මයිකා අඩංගුයි).",
          "මිනිරන්: කළු පැහැති, ලෝහක දීප්තියක් සහිත, අත ගැල්වූ විට ලිස්සන සුළු සන්නායක කාබන් බහුරූපයකි."
        ),
        observationAndConclusion = "භෞතික හා රසායනික ගුණ මගින් පාෂාණ හා ඛණිජ නිවැරදිව හඳුනාගත හැක.",
        examTips = "💡 එප්පාවල ඇපටයිට් නිධිය පොස්පේට් පොහොර නිෂ්පාදනයටද, පුල්මුඩේ ඛණිජ වැලි ඉල්මනයිට් හා රූටයිල් (ටයිටේනියම්) සඳහාද යොදාගනී."
      )
    )
  }

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    contentPadding = PaddingValues(top = 12.dp, bottom = 160.dp),
    verticalArrangement = Arrangement.spacedBy(14.dp)
  ) {
    // Jump to 20 Categories Banner
    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F2E22)),
        border = BorderStroke(1.2.dp, Color(0xFF10B981)),
        modifier = Modifier
          .fillMaxWidth()
          .clickable { onOpenCategories?.invoke() }
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
            Text("🧬", fontSize = 20.sp)
            Spacer(modifier = Modifier.width(10.dp))
            Column {
              Text(
                text = "විද්‍යාව කාණ්ඩ 20 කරුණු බැංකුව (400)",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Text(
                text = "ඒකක 36 ම ආවරණය වන කරුණු 20 බැගින් කාණ්ඩ 20ම බලන්න",
                fontSize = 11.sp,
                color = Color(0xFFA7F3D0)
              )
            }
          }
          Surface(
            shape = CircleShape,
            color = Color(0xFF10B981)
          ) {
            Icon(
              imageVector = Icons.Default.ArrowForward,
              contentDescription = "Go",
              tint = Color.White,
              modifier = Modifier.padding(6.dp).size(16.dp)
            )
          }
        }
      }
    }

    item {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .clip(RoundedCornerShape(10.dp))
          .background(Color(0xFF1E293B))
          .padding(4.dp)
      ) {
        Button(
          onClick = { selectedTab = 0 },
          colors = ButtonDefaults.buttonColors(
            containerColor = if (selectedTab == 0) Color(0xFF0D9488) else Color.Transparent
          ),
          shape = RoundedCornerShape(8.dp),
          modifier = Modifier.weight(1f)
        ) {
          Text("🖼️ O/L රූප සටහන් 10", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
        }
        Button(
          onClick = { selectedTab = 1 },
          colors = ButtonDefaults.buttonColors(
            containerColor = if (selectedTab == 1) Color(0xFF0D9488) else Color.Transparent
          ),
          shape = RoundedCornerShape(8.dp),
          modifier = Modifier.weight(1f)
        ) {
          Text("🔬 රසායනාගාර පරීක්ෂණ 10", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
        }
      }
    }

    if (selectedTab == 0) {
      items(diagrams) { diag ->
        Card(
          shape = RoundedCornerShape(14.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFF0D9488).copy(alpha = 0.5f)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = diag.titleSinhala,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.weight(1f)
              )
              Surface(
                color = Color(0xFF0D9488),
                shape = RoundedCornerShape(6.dp)
              ) {
                Text(
                  text = diag.category,
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = diag.description,
              fontSize = 12.sp,
              color = Color(0xFF94A3B8)
            )
            Spacer(modifier = Modifier.height(12.dp))

            Text(
              text = "📌 අත්‍යවශ්‍ය කොටස් සහ කාර්යයන් (O/L Syllabus Core):",
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF5EEAD4)
            )
            Spacer(modifier = Modifier.height(6.dp))

            diag.parts.forEachIndexed { idx, pair ->
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF0F172A),
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(vertical = 3.dp)
              ) {
                Column(modifier = Modifier.padding(10.dp)) {
                  Text(
                    text = "${idx + 1}. ${pair.first}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2DD4BF)
                  )
                  Spacer(modifier = Modifier.height(2.dp))
                  Text(
                    text = pair.second,
                    fontSize = 11.5.sp,
                    color = Color(0xFFE2E8F0)
                  )
                }
              }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Surface(
              shape = RoundedCornerShape(8.dp),
              color = Color(0xFF134E4A),
              modifier = Modifier.fillMaxWidth()
            ) {
              Text(
                text = diag.examTips,
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFCCFBF1),
                modifier = Modifier.padding(10.dp)
              )
            }
          }
        }
      }
    } else {
      items(experiments) { exp ->
        Card(
          shape = RoundedCornerShape(14.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.5f)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = exp.titleSinhala,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.weight(1f)
              )
              Surface(
                color = Color(0xFF065F46),
                shape = RoundedCornerShape(6.dp)
              ) {
                Text(
                  text = exp.category,
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF6EE7B7),
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = exp.aimAndPrinciple,
              fontSize = 12.sp,
              color = Color(0xFFCBD5E1)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
              text = "🧪 අමුද්‍රව්‍ය සහ ප්‍රතිකාරක:",
              fontSize = 11.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF5EEAD4)
            )
            Spacer(modifier = Modifier.height(4.dp))
            exp.apparatusAndReagents.forEach { app ->
              Text("• $app", fontSize = 11.sp, color = Color(0xFFE2E8F0), modifier = Modifier.padding(start = 6.dp, bottom = 2.dp))
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "📋 පියවරෙන් පියවර ක්‍රමවේදය:",
              fontSize = 11.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF5EEAD4)
            )
            Spacer(modifier = Modifier.height(4.dp))
            exp.procedureSteps.forEachIndexed { sIdx, step ->
              Text("${sIdx + 1}. $step", fontSize = 11.sp, color = Color(0xFFE2E8F0), modifier = Modifier.padding(start = 6.dp, bottom = 3.dp))
            }

            Spacer(modifier = Modifier.height(8.dp))
            Surface(
              shape = RoundedCornerShape(8.dp),
              color = Color(0xFF064E3B),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(10.dp)) {
                Text("🔍 නිරීක්ෂණය සහ නිගමනය:", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFA7F3D0))
                Spacer(modifier = Modifier.height(2.dp))
                Text(exp.observationAndConclusion, fontSize = 11.sp, color = Color.White)
              }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Surface(
              shape = RoundedCornerShape(8.dp),
              color = Color(0xFF1E3A8A).copy(alpha = 0.6f),
              modifier = Modifier.fillMaxWidth()
            ) {
              Text(
                text = exp.examTips,
                fontSize = 11.sp,
                color = Color(0xFFBAE6FD),
                modifier = Modifier.padding(10.dp)
              )
            }
          }
        }
      }
    }
  }
}

// ==============================================================================
// 2. ENGLISH: WRITING TASK VAULT & VERBS GUIDE
// ==============================================================================

data class EnglishWritingModel(
  val type: String,
  val title: String,
  val prompt: String,
  val standardFormat: String,
  val modelAnswer: String,
  val usefulPhrases: List<String>
)

@Composable
fun EnglishWritingVaultAndVerbsFeatureView() {
  var selectedTab by remember { mutableStateOf(0) }

  val writingTasks = remember {
    listOf(
      EnglishWritingModel(
        type = "Official / Formal Notice (Test 6)",
        title = "School Environment Day Tree Planting Campaign",
        prompt = "Write a notice to be put up on the school notice board about a Tree Planting Campaign organized by the Environmental Society. (40-50 words)",
        standardFormat = "Heading (NOTICE in capital) • Date • Target Group • Event Details (Date, Time, Venue, Activities) • Signatory (Secretary/President)",
        modelAnswer = """
NOTICE
Tree Planting Campaign

The Environmental Society of our school has organized a tree planting campaign to mark World Environment Day.

• Date: 15th October 2026
• Time: 8.30 a.m. onwards
• Venue: School Premises
• Chief Guest: Divisional Forest Officer

All students of Grade 10 and 11 are kindly invited to participate. Please bring saplings if possible.

Secretary,
Environmental Society.
        """.trimIndent(),
        usefulPhrases = listOf("All students are cordially invited...", "The event will commence at...", "For further details, contact...")
      ),
      EnglishWritingModel(
        type = "Formal Letter (Test 14 / Essay)",
        title = "Letter of Request to the Principal",
        prompt = "Write a letter to the Principal requesting permission to organize an Inter-School English Drama Competition. (100 words)",
        standardFormat = "Sender's Address • Date • Receiver's Title & Address • Salutation (Dear Sir/Madam) • Subject Line • Body Paragraphs • Complimentary Close (Yours faithfully) • Signature & Designation",
        modelAnswer = """
English Literary Association,
Mahanama College,
Colombo 03.
12th October 2026.

The Principal,
Mahanama College,
Colombo 03.

Dear Sir,
Requesting Permission for Inter-School Drama Competition

I am writing this on behalf of the English Literary Association to kindly request your permission to organize the Annual Inter-School Drama Competition in our school main hall on 20th November 2026 from 9.00 a.m. to 2.00 p.m.

Around eight leading schools in the province have already expressed their keen interest. We have arranged responsible teacher advisors to supervise the stage settings and discipline.

We look forward to receiving your favorable approval.

Thank you.
Yours faithfully,
Kaveen Silva (Secretary).
        """.trimIndent(),
        usefulPhrases = listOf("I am writing this on behalf of...", "We would be grateful if you could...", "We assure that strict discipline will be maintained.")
      ),
      EnglishWritingModel(
        type = "Pie Chart & Bar Graph Interpretation (Test 14)",
        title = "Description of Future Ambitions of Grade 11 Students",
        prompt = "Describe the given pie chart showing career choices of 100 Grade 11 students: Engineering (35%), Medicine (25%), IT/Software (20%), Teaching (12%), Business (8%). (100 words)",
        standardFormat = "Introduction (What the chart shows) • Main Trend / Highest percentage • Secondary categories comparison • Lowest percentage • Concluding sentence",
        modelAnswer = """
This pie chart illustrates the future career ambitions of one hundred Grade 11 students in a secondary school.

According to the chart, the highest percentage of students, which is 35%, prefer to pursue Engineering as their future career. The second most popular choice is Medicine, chosen by 25% of the students. Meanwhile, 20% of the students aspire to enter the IT and Software development sector.

In contrast, only 12% of students have selected Teaching, while the least percentage of 8% have chosen Business and Entrepreneurship.

In conclusion, it is evident that majority of students (80%) are inclined towards STEM-related professions.
        """.trimIndent(),
        usefulPhrases = listOf("This pie chart illustrates / depicts...", "The highest / maximum proportion is...", "In contrast / On the other hand...", "The least / minimum percentage is...", "It can be concluded that...")
      )
    )
  }

  val irregularVerbs = remember {
    listOf(
      listOf("arise", "arose", "arisen", "මතුවෙනවා / නැගී සිටිනවා"),
      listOf("begin", "began", "begun", "පටන් ගන්නවා"),
      listOf("blow", "blew", "blown", "හමනවා / පිඹිනවා"),
      listOf("break", "broke", "broken", "කඩනවා / බිඳෙනවා"),
      listOf("choose", "chose", "chosen", "තෝරාගන්නවා"),
      listOf("draw", "drew", "drawn", "අඳිනවා / අදිනවා"),
      listOf("drive", "drove", "driven", "පදවනවා"),
      listOf("eat", "ate", "eaten", "කනවා"),
      listOf("fall", "fell", "fallen", "වැටෙනවා"),
      listOf("fly", "flew", "flown", "පියාසර කරනවා"),
      listOf("forget", "forgot", "forgotten", "අමතක වෙනවා"),
      listOf("give", "gave", "given", "දෙනවා"),
      listOf("grow", "grew", "grown", "වර්ධනය වෙනවා / වවනවා"),
      listOf("know", "knew", "known", "දන්නවා / හඳුනනවා"),
      listOf("ride", "rode", "ridden", "පදිනවා (බයිසිකල්/අශ්ව)"),
      listOf("rise", "rose", "risen", "නැගෙනවා (හිරු/මිල)"),
      listOf("see", "saw", "seen", "දකිනවා"),
      listOf("speak", "spoke", "spoken", "කතා කරනවා"),
      listOf("swim", "swam", "swum", "පීනනවා"),
      listOf("take", "took", "taken", "ගන්නවා"),
      listOf("throw", "threw", "thrown", "විසි කරනවා"),
      listOf("write", "wrote", "written", "ලියනවා")
    )
  }

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(14.dp)
  ) {
    item {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .clip(RoundedCornerShape(10.dp))
          .background(Color(0xFF1E293B))
          .padding(4.dp)
      ) {
        Button(
          onClick = { selectedTab = 0 },
          colors = ButtonDefaults.buttonColors(
            containerColor = if (selectedTab == 0) Color(0xFF0284C7) else Color.Transparent
          ),
          shape = RoundedCornerShape(8.dp),
          modifier = Modifier.weight(1f)
        ) {
          Text("📝 O/L Writing Vault", fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
        Button(
          onClick = { selectedTab = 1 },
          colors = ButtonDefaults.buttonColors(
            containerColor = if (selectedTab == 1) Color(0xFF0284C7) else Color.Transparent
          ),
          shape = RoundedCornerShape(8.dp),
          modifier = Modifier.weight(1f)
        ) {
          Text("🔤 Irregular Verbs (${irregularVerbs.size})", fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
      }
    }

    if (selectedTab == 0) {
      items(writingTasks) { task ->
        Card(
          shape = RoundedCornerShape(14.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFF0284C7)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Surface(
              color = Color(0xFF0284C7),
              shape = RoundedCornerShape(6.dp)
            ) {
              Text(
                text = task.type,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
              )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = task.title,
              fontSize = 14.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "Question: ${task.prompt}",
              fontSize = 11.5.sp,
              color = Color(0xFFBAE6FD)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text("📐 සම්මත ආකෘතිය (Format):", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
            Text(task.standardFormat, fontSize = 11.sp, color = Color(0xFFE2E8F0))

            Spacer(modifier = Modifier.height(10.dp))
            Text("⭐ සම්පූර්ණ ලකුණු හිමිවන Model Answer:", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFACC15))
            Surface(
              shape = RoundedCornerShape(8.dp),
              color = Color(0xFF0F172A),
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
            ) {
              Text(
                text = task.modelAnswer,
                fontSize = 11.5.sp,
                color = Color(0xFFF8FAFC),
                lineHeight = 16.sp,
                modifier = Modifier.padding(12.dp)
              )
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text("💡 ප්‍රයෝජනවත් වාක්‍ය ඛණ්ඩ (Phrases):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
            task.usefulPhrases.forEach { p ->
              Text("• $p", fontSize = 11.sp, color = Color(0xFFBBF7D0))
            }
          }
        }
      }
    } else {
      item {
        Card(
          shape = RoundedCornerShape(10.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Text("Base (V1)", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8), modifier = Modifier.weight(1f))
            Text("Past (V2)", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFACC15), modifier = Modifier.weight(1f))
            Text("Past Part. (V3)", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80), modifier = Modifier.weight(1f))
            Text("සිංහල තේරුම", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFE2E8F0), modifier = Modifier.weight(1.2f))
          }
        }
      }

      items(irregularVerbs) { v ->
        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFF1E293B),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(v[0], fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8), modifier = Modifier.weight(1f))
            Text(v[1], fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFACC15), modifier = Modifier.weight(1f))
            Text(v[2], fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80), modifier = Modifier.weight(1f))
            Text(v[3], fontSize = 11.sp, color = Color(0xFFCBD5E1), modifier = Modifier.weight(1.2f))
          }
        }
      }
    }
  }
}

// ==============================================================================
// 3. HISTORY: INTERACTIVE TIMELINE & MAP PINNING PRACTICE
// ==============================================================================

data class TimelineEraItem(
  val era: String,
  val period: String,
  val keyRulers: List<String>,
  val majorAchievements: List<String>,
  val mapSites: List<String>
)

@Composable
fun HistoryTimelineAndMapPinningFeatureView() {
  val eras = remember {
    listOf(
      TimelineEraItem(
        era = "1. ප්‍රාග් ඓතිහාසික යුගය (Pre-Historic Era)",
        period = "ක්‍රි.පූ. 125,000 - ක්‍රි.පූ. 1,000",
        keyRulers = listOf("බලංගොඩ මානවයා (Homo sapiens balangodensis)"),
        majorAchievements = listOf(
          "පාහියන්ගල, බටදොඹලෙන, කිතුල්ගල බෙලිලෙන, දොරවකලෙන ආශ්‍රිත ජනාවාස.",
          "ක්ෂුද්‍ර ශිලා මෙවලම්, ජ්‍යාමිතික මෙවලම් භාවිතය.",
          "ඉබ්බන්කටුව, පොම්පරිප්පු මෙගලිතික සුසාන භූමි."
        ),
        mapSites = listOf("පාහියන්ගල", "බටදොඹලෙන", "ඉබ්බන්කටුව", "පොම්පරිප්පු")
      ),

      TimelineEraItem(
        era = "3. පොළොන්නරු යුගය (Polonnaruwa Era)",
        period = "ක්‍රි.ව. 1055 - ක්‍රි.ව. 1232",
        keyRulers = listOf("I වන විජයබාහු", "I වන පරාක්‍රමබාහු (මහා පරාක්‍රමබාහු)", "නිශ්ශංකමල්ල"),
        majorAchievements = listOf(
          "I වන විජයබාහු: චෝළ ආක්‍රමණිකයන් පලවාහැර රට එක්සේසත් කිරීම, දළදා පෙරහැර ආරම්භය.",
          "මහා පරාක්‍රමබාහු: පරාක්‍රම සමුද්‍රය, ආලාහණ පිරිවෙන, ගල් විහාරය, 'අහසින් වැටෙන එකදු දිය බිඳකුදු...'.",
          "නිශ්ශංකමල්ල: හැටදාගේ, රන්කොත් වෙහෙර, නිශ්ශංක ලතා මණ්ඩපය."
        ),
        mapSites = listOf("පොළොන්නරුව", "පරාක්‍රම සමුද්‍රය", "දඹුල්ල", "මහියංගණය")
      ),
      TimelineEraItem(
        era = "4. නිරිතදිග රාජධානි සහ මහනුවර යුගය (Kandy & Southwest)",
        period = "ක්‍රි.ව. 1232 - 1815",
        keyRulers = listOf("II පරාක්‍රමබාහු (දඹදෙණිය)", "VI පරාක්‍රමබාහු (කෝට්ටේ)", "I රාජසිංහ (සීතාවක)", "විමලධර්මසූරිය I", "ශ්‍රී වික්‍රම රාජසිංහ"),
        majorAchievements = listOf(
          "VI පරාක්‍රමබාහු රජු මුළු ලංකාවම එක්සේසත් කළ අවසන් සිංහල රජු වීම.",
          "සීතාවක රාජසිංහ රජු මුල්ලේරියා සටනින් පෘතුගීසීන් පරාජය කිරීම.",
          "1815 උඩරට ගිවිසුම මගින් ලංකාව සම්පූර්ණයෙන්ම බ්‍රිතාන්‍ය යටත් විජිතයක් වීම."
        ),
        mapSites = listOf("දඹදෙණිය", "යාපහුව", "කුරුණෑගල", "කෝට්ටේ", "සීතාවක", "මහනුවර", "මුල්ලේරියාව")
      )
    )
  }

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(14.dp)
  ) {
    item {
      Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFF78350F),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text(
            text = "🏛️ O/L ඉතිහාසය කාල රේඛාව සහ සිතියම් සලකුණු (Map Pinning)",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFEF3C7)
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "ප්‍රශ්න පත්‍රයේ ලකුණු 18ක් හිමිවන සිතියම් ලකුණු කිරීම සහ යුග අනුපිළිවෙල මෙතැනින් පහසුවෙන් මතක තබාගන්න.",
            fontSize = 11.5.sp,
            color = Color(0xFFFDE68A)
          )
        }
      }
    }

    items(eras) { era ->
      Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFFD97706)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = era.era,
              fontSize = 14.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFFBBF24),
              modifier = Modifier.weight(1f)
            )
            Surface(
              color = Color(0xFFD97706),
              shape = RoundedCornerShape(6.dp)
            ) {
              Text(
                text = era.period,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
          }
          Spacer(modifier = Modifier.height(8.dp))

          Text("👑 ප්‍රධාන පාලකයින්:", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE68A))
          Text(era.keyRulers.joinToString(", "), fontSize = 11.5.sp, color = Color(0xFFE2E8F0))

          Spacer(modifier = Modifier.height(8.dp))
          Text("📜 ප්‍රධාන ඓතිහාසික සිදුවීම් & නිර්මාණ:", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE68A))
          era.majorAchievements.forEach { ach ->
            Text("• $ach", fontSize = 11.sp, color = Color(0xFFCBD5E1), modifier = Modifier.padding(vertical = 1.dp))
          }

          Spacer(modifier = Modifier.height(8.dp))
          Text("📍 O/L විභාග සිතියමේ අනිවාර්යයෙන් සලකුණු කළ යුතු ස්ථාන:", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(top = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            era.mapSites.forEach { site ->
              Surface(
                color = Color(0xFF0F172A),
                border = BorderStroke(0.8.dp, Color(0xFF38BDF8)),
                shape = RoundedCornerShape(6.dp)
              ) {
                Text(
                  text = "📍 $site",
                  fontSize = 10.5.sp,
                  color = Color(0xFFBAE6FD),
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                )
              }
            }
          }
        }
      }
    }
  }
}

// ==============================================================================
// 4. GEOGRAPHY: 1:50,000 TOPOGRAPHICAL MAPS & WORLD REGIONS
// ==============================================================================

@Composable
fun GeographyTopoMapsAndRegionsFeatureView(
  onOpenCategories: (() -> Unit)? = null
) {
  BackHandler {
    // Navigate back to the previous screen or pop backstack
  }
  val topoFeatures = remember {
    listOf(
      Triple("සමෝච්ච රේඛා (Contour Lines)", "මුහුදු මට්ටමේ සිට සමාන උසක් ඇති ස්ථාන යා කරන රේඛා වේ.", "ළඟින් ළඟින් පිහිටි විට බෑවුම අධිකයි (කඳු බෑවුම්); ඈතින් පිහිටි විට මෘදු බෑවුම්/තැනිතලා වේ."),
      Triple("ජලාපවහන රටා (Drainage Patterns)", "අරීය රටාව (කඳු මුදුනක සිට සිව්දෙසට), අතු බෙදුණු රටාව (ගසක අතු මෙන්), දැලිස් රටාව.", "භූගෝල ප්‍රශ්න පත්‍ර I කොටසේ නිතර විමසන ප්‍රධාන කොටසකි."),
      Triple("මාර්ග සහ ප්‍රවාහනය (Transport Symbols)", "A ශ්‍රේණියේ ප්‍රධාන මාර්ග (රතු පැහැය), දුම්රිය මාර්ග (කළු පැහැති ඉරි සහිත), අඩිපාරවල් (කඩඉරි).", "ප්‍රදේශයේ සංවර්ධනය හා ප්‍රවේශ්‍යතාව හඳුනාගැනීමට උපකාරී වේ."),
      Triple("වෘක්ෂලතා සහ ඉඩම් පරිහරණය", "වනාන්තර (තද කොළ), තේ/රබර්/පොල් වගාවන් (විශේෂිත සංකේත), වී වගාව (ලා කොළ තැනිතලා).", "ජීවනෝපාය සහ ආර්ථික කටයුතු තීරණය කරයි.")
    )
  }

  val worldRegions = remember {
    listOf(
      Triple("ප්‍රධාන කඳු වැටි", "හිමාලය (ආසියාව), ඇන්ඩීස් (දකුණු ඇමෙරිකාව - දිගම), රොකී (උතුරු ඇමෙරිකාව), ඇල්ප්ස් (යුරෝපය), යුරල් (ආසියාව හා යුරෝපය මායිම).", "🏔️ ලෝක සිතියමේ ලකුණු 3ක්"),
      Triple("ප්‍රධාන ගංගා", "නයිල් (අප්‍රිකාව - දිගම), ඇමසන් (දකුණු ඇමෙරිකාව - විශාලතම), යැංසි (චීනය), මිසිසිපි (උතුරු ඇමෙරිකාව), ඩැනියුබ් (යුරෝපය).", "🌊 ලෝක සිතියමේ ලකුණු 3ක්"),
      Triple("තෘණ බිම් (Grasslands)", "ප්‍රෙයාරි (උතුරු ඇමෙරිකාව), පැම්පාස් (දකුණු ඇමෙරිකාව/ආර්ජන්ටිනාව), ස්ටෙප්ස් (යුරේසියාව), සවානා/වෙල්ඩ් (අප්‍රිකාව), ඩවුන්ස් (ඕස්ට්‍රේලියාව).", "🌾 නිතර බහුවරණ ප්‍රශ්නවලට"),
      Triple("ප්‍රධාන සමුද්‍ර සන්ධි & ඇළ මාර්ග", "සූවස් ඇළ (රතු මුහුද හා මධ්‍යධරණී මුහුද), පැනමා ඇළ (පැසිෆික් හා අත්ලාන්තික්), මලක්කා සමුද්‍ර සන්ධිය, ජිබ්‍රෝල්ටා සමුද්‍ර සන්ධිය.", "🚢 ලෝක වෙළඳ මාර්ග")
    )
  }

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(14.dp)
  ) {
    item {
      Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFF064E3B),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text(
            text = "🗺️ 1:50,000 භූ ලක්ෂණ සිතියම් සහ ලෝක භූගෝලීය කලාප",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFD1FAE5)
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "සා/පෙළ භූගෝල විද්‍යාව I පත්‍රයේ සිතියම් අභ්‍යාසයට සම්පූර්ණ ලකුණු ලබාගැනීමේ නිල විවරණය.",
            fontSize = 11.5.sp,
            color = Color(0xFFA7F3D0)
          )

          if (onOpenCategories != null) {
            Spacer(modifier = Modifier.height(10.dp))
            Button(
              onClick = onOpenCategories,
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
              shape = RoundedCornerShape(8.dp),
              contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
              modifier = Modifier.testTag("open_geo_categories_btn")
            ) {
              Text("📚 භූගෝල විද්‍යාව විෂය නිර්දේශයේ කරුණු 20 බැගින් වූ කාණ්ඩ 20 (කරුණු 400)", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
          }
        }
      }
    }

    item {
      Text(
        text = "📍 1:50,000 ශ්‍රී ලංකා භූ ලක්ෂණ සිතියම් කියවීම (Topographical Reading):",
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF34D399)
      )
    }

    items(topoFeatures) { item ->
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFF059669)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text(item.first, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF6EE7B7))
          Spacer(modifier = Modifier.height(4.dp))
          Text(item.second, fontSize = 12.sp, color = Color(0xFFE2E8F0))
          Spacer(modifier = Modifier.height(4.dp))
          Text("💡 විභාග වැදගත්කම: ${item.third}", fontSize = 11.sp, color = Color(0xFFFACC15))
        }
      }
    }

    item {
      Spacer(modifier = Modifier.height(6.dp))
      Text(
        text = "🌍 ලෝක සිතියම් අභ්‍යාසය (World Map Key Locations):",
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF38BDF8)
      )
    }

    items(worldRegions) { reg ->
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        border = BorderStroke(1.dp, Color(0xFF38BDF8)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(reg.first, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF7DD3FC))
            Text(reg.third, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFACC15))
          }
          Spacer(modifier = Modifier.height(4.dp))
          Text(reg.second, fontSize = 11.5.sp, color = Color(0xFFE2E8F0), lineHeight = 16.sp)
        }
      }
    }
  }
}

// ==============================================================================
// 5. COMMERCE & ACCOUNTING: DOUBLE ENTRY & STATEMENTS SANDBOX
// ==============================================================================

data class DoubleEntryChallenge(
  val transaction: String,
  val debitAccount: String,
  val creditAccount: String,
  val explanation: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommerceDoubleEntryAndAccountsFeatureView() {
  var currentBatchNumber by remember { mutableIntStateOf(1) }
  var searchQuery by remember { mutableStateOf("") }
  var showBatchPicker by remember { mutableStateOf(false) }

  val currentBatch = remember(currentBatchNumber) {
    CommerceDoubleEntryRepository.getBatch(currentBatchNumber)
  }

  val searchResults = remember(searchQuery) {
    if (searchQuery.isNotBlank()) {
      CommerceDoubleEntryRepository.search(searchQuery)
    } else {
      emptyList()
    }
  }

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(14.dp)
  ) {
    item {
      Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFF581C87),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "📊 ගිණුම්කරණ ද්විත්ව සටහන් සහ සමීකරණ (Accounting Sandbox)",
              fontSize = 14.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFF3E8FF),
              modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFF7C3AED)
            ) {
              Text(
                text = "කාණ්ඩ 200 (10x200)",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
              )
            }
          }
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "ගිණුම්කරණ මූලික සමීකරණය: වත්කම් = හිමිකම + වගකීම්\n(Assets = Equity + Liabilities)",
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFFE9D5FF)
          )
          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = "O/L වාණිජ්‍ය විෂය නිර්දේශයේ සියලුම ද්විත්ව සටහන් 2,000 ක් (10 බැගින් වූ කාණ්ඩ 200ක්) සම්පූර්ණ විවරණ සමඟ.",
            fontSize = 11.sp,
            color = Color(0xFFD8B4FE)
          )
        }
      }
    }

    item {
      Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        // Search bar
        OutlinedTextField(
          value = searchQuery,
          onValueChange = { searchQuery = it },
          placeholder = { Text("ගනුදෙනුව, ගිණුම (උදා: අයිරා, වට්ටම්, ගැනිලි, චෙක්පත්) සොයන්න...", fontSize = 11.5.sp, color = Color(0xFF94A3B8)) },
          leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFFA78BFA)) },
          trailingIcon = {
            if (searchQuery.isNotBlank()) {
              IconButton(onClick = { searchQuery = "" }) {
                Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color(0xFFA78BFA))
              }
            }
          },
          singleLine = true,
          shape = RoundedCornerShape(10.dp),
          colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            focusedBorderColor = Color(0xFF7C3AED),
            unfocusedBorderColor = Color(0xFF475569),
            focusedContainerColor = Color(0xFF1E293B),
            unfocusedContainerColor = Color(0xFF0F172A)
          ),
          modifier = Modifier.fillMaxWidth()
        )

        if (searchQuery.isBlank()) {
          // Batch Selector Card
          Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            border = BorderStroke(1.dp, Color(0xFF6D28D9)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(12.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Column(modifier = Modifier.weight(1f)) {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                      shape = RoundedCornerShape(6.dp),
                      color = Color(0xFF7C3AED)
                    ) {
                      Text(
                        text = "කාණ්ඩය ${currentBatch.batchNumber} / ${CommerceDoubleEntryRepository.TOTAL_BATCHES}",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                      )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                      text = "ප්‍රශ්න ${(currentBatch.batchNumber - 1) * 10 + 1} - ${currentBatch.batchNumber * 10}",
                      fontSize = 11.sp,
                      color = Color(0xFFCBD5E1),
                      fontWeight = FontWeight.Medium
                    )
                  }
                  Spacer(modifier = Modifier.height(4.dp))
                  Text(
                    text = currentBatch.title,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFE2E8F0)
                  )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                  onClick = { showBatchPicker = true },
                  colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C3AED)),
                  shape = RoundedCornerShape(8.dp),
                  contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
                ) {
                  Icon(Icons.Default.List, contentDescription = null, modifier = Modifier.size(14.dp))
                  Spacer(modifier = Modifier.width(4.dp))
                  Text("කාණ්ඩ (1-200)", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
              }

              Spacer(modifier = Modifier.height(10.dp))

              // Stepper buttons
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                OutlinedButton(
                  onClick = {
                    if (currentBatchNumber > 1) currentBatchNumber--
                  },
                  enabled = currentBatchNumber > 1,
                  shape = RoundedCornerShape(8.dp),
                  colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color(0xFFA78BFA),
                    disabledContentColor = Color(0xFF64748B)
                  ),
                  border = BorderStroke(1.dp, if (currentBatchNumber > 1) Color(0xFF7C3AED) else Color(0xFF334155)),
                  contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
                ) {
                  Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, modifier = Modifier.size(14.dp))
                  Spacer(modifier = Modifier.width(4.dp))
                  Text("පෙර", fontSize = 11.sp)
                }

                Slider(
                  value = currentBatchNumber.toFloat(),
                  onValueChange = { currentBatchNumber = it.toInt() },
                  valueRange = 1f..CommerceDoubleEntryRepository.TOTAL_BATCHES.toFloat(),
                  modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 6.dp),
                  colors = SliderDefaults.colors(
                    thumbColor = Color(0xFFA78BFA),
                    activeTrackColor = Color(0xFF7C3AED),
                    inactiveTrackColor = Color(0xFF334155)
                  )
                )

                OutlinedButton(
                  onClick = {
                    if (currentBatchNumber < CommerceDoubleEntryRepository.TOTAL_BATCHES) currentBatchNumber++
                  },
                  enabled = currentBatchNumber < CommerceDoubleEntryRepository.TOTAL_BATCHES,
                  shape = RoundedCornerShape(8.dp),
                  colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color(0xFFA78BFA),
                    disabledContentColor = Color(0xFF64748B)
                  ),
                  border = BorderStroke(1.dp, if (currentBatchNumber < CommerceDoubleEntryRepository.TOTAL_BATCHES) Color(0xFF7C3AED) else Color(0xFF334155)),
                  contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
                ) {
                  Text("ඊළඟ", fontSize = 11.sp)
                  Spacer(modifier = Modifier.width(4.dp))
                  Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, modifier = Modifier.size(14.dp))
                }
              }
            }
          }
        }
      }
    }

    item {
      if (searchQuery.isNotBlank()) {
        Text(
          text = "🔍 සෙවුම් ප්‍රතිඵල (${searchResults.size}) - \"$searchQuery\":",
          fontSize = 13.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFFA78BFA)
        )
      } else {
        Text(
          text = "⚡ O/L නිතර විමසන ද්විත්ව සටහන් පුහුණුව (කාණ්ඩය $currentBatchNumber - ප්‍රශ්න 10):",
          fontSize = 13.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFFA78BFA)
        )
      }
    }

    if (searchQuery.isNotBlank()) {
      if (searchResults.isEmpty()) {
        item {
          Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp)
          ) {
            Column(
              modifier = Modifier.padding(24.dp),
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
              Text("🔍", fontSize = 32.sp)
              Spacer(modifier = Modifier.height(8.dp))
              Text("සෙවුමට ගැළපෙන ද්විත්ව සටහන් හමු නොවීය.", color = Color.White, fontWeight = FontWeight.Bold)
              Text("වෙනත් වචනයකින් (උදා: චෙක්පත්, ණය, වට්ටම්, ආපසු) සොයන්න.", color = Color(0xFF94A3B8), fontSize = 11.sp)
            }
          }
        }
      } else {
        items(searchResults) { (bNum, c) ->
          DoubleEntryChallengeCard(c = c, batchBadge = "කාණ්ඩය $bNum")
        }
      }
    } else {
      items(currentBatch.challenges) { c ->
        DoubleEntryChallengeCard(c = c, batchBadge = null)
      }
    }
  }

  // Batch Picker Dialog
  if (showBatchPicker) {
    AlertDialog(
      onDismissRequest = { showBatchPicker = false },
      title = {
        Column {
          Text("කාණ්ඩය තෝරන්න (1 - 200)", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
          Text("O/L වාණිජ්‍ය ද්විත්ව සටහන් දහයේ කාණ්ඩ 200 (ප්‍රශ්න 2,000)", fontSize = 11.sp, color = Color(0xFFA78BFA))
        }
      },
      text = {
        Column(modifier = Modifier.fillMaxWidth().heightIn(max = 420.dp)) {
          Text("ක්ෂණික පරාසයන්:", fontSize = 11.sp, color = Color(0xFF94A3B8), fontWeight = FontWeight.Bold)
          Spacer(modifier = Modifier.height(6.dp))
          LazyRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            val ranges = listOf(
              1 to 10, 11 to 20, 21 to 30, 31 to 40, 41 to 50,
              51 to 60, 61 to 70, 71 to 80, 81 to 90, 91 to 100,
              101 to 110, 111 to 120, 121 to 130, 131 to 140, 141 to 150,
              151 to 160, 161 to 170, 171 to 180, 181 to 190, 191 to 200
            )
            items(ranges) { (start, end) ->
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = if (currentBatchNumber in start..end) Color(0xFF7C3AED) else Color(0xFF334155),
                modifier = Modifier.clickable {
                  currentBatchNumber = start
                }
              ) {
                Text(
                  text = "$start - $end",
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(12.dp))
          Text("සියලු කාණ්ඩ (1 සිට 200 දක්වා):", fontSize = 11.sp, color = Color(0xFF94A3B8), fontWeight = FontWeight.Bold)
          Spacer(modifier = Modifier.height(6.dp))

          LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            items(CommerceDoubleEntryRepository.TOTAL_BATCHES) { idx ->
              val bNum = idx + 1
              val isSelected = bNum == currentBatchNumber
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = if (isSelected) Color(0xFF7C3AED) else Color(0xFF1E293B),
                border = BorderStroke(1.dp, if (isSelected) Color(0xFFA78BFA) else Color(0xFF334155)),
                modifier = Modifier
                  .fillMaxWidth()
                  .clickable {
                    currentBatchNumber = bNum
                    showBatchPicker = false
                  }
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.SpaceBetween
                ) {
                  Column(modifier = Modifier.weight(1f)) {
                    Text(
                      text = CommerceDoubleEntryRepository.getBatchTitle(bNum),
                      fontSize = 11.sp,
                      fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                      color = Color.White
                    )
                    Text(
                      text = "ප්‍රශ්න ${(bNum - 1) * 10 + 1} - ${bNum * 10}",
                      fontSize = 9.5.sp,
                      color = if (isSelected) Color(0xFFE9D5FF) else Color(0xFF94A3B8)
                    )
                  }
                  if (isSelected) {
                    Icon(Icons.Default.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                  }
                }
              }
            }
          }
        }
      },
      confirmButton = {
        Button(
          onClick = { showBatchPicker = false },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C3AED))
        ) {
          Text("වසන්න", fontSize = 11.sp)
        }
      },
      containerColor = Color(0xFF0F172A)
    )
  }
}

@Composable
fun DoubleEntryChallengeCard(
  c: DoubleEntryChallenge,
  batchBadge: String? = null
) {
  Card(
    shape = RoundedCornerShape(12.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
    border = BorderStroke(1.dp, Color(0xFF7C3AED)),
    modifier = Modifier.fillMaxWidth()
  ) {
    Column(modifier = Modifier.padding(14.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
      ) {
        Text(
          text = c.transaction,
          fontSize = 13.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White,
          modifier = Modifier.weight(1f)
        )
        if (batchBadge != null) {
          Spacer(modifier = Modifier.width(6.dp))
          Surface(
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFF7C3AED)
          ) {
            Text(
              text = batchBadge,
              fontSize = 9.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
        }
      }
      Spacer(modifier = Modifier.height(8.dp))
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFF0F766E),
          modifier = Modifier.weight(1f)
        ) {
          Column(modifier = Modifier.padding(8.dp)) {
            Text("හර සටහන (Dr):", fontSize = 10.sp, color = Color(0xFF99F6E4), fontWeight = FontWeight.Bold)
            Text(c.debitAccount, fontSize = 11.5.sp, color = Color.White, fontWeight = FontWeight.Bold)
          }
        }
        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFF9D174D),
          modifier = Modifier.weight(1f)
        ) {
          Column(modifier = Modifier.padding(8.dp)) {
            Text("බැර සටහන (Cr):", fontSize = 10.sp, color = Color(0xFFFBCFE8), fontWeight = FontWeight.Bold)
            Text(c.creditAccount, fontSize = 11.5.sp, color = Color.White, fontWeight = FontWeight.Bold)
          }
        }
      }
      Spacer(modifier = Modifier.height(6.dp))
      Text("💡 විවරණය: ${c.explanation}", fontSize = 11.sp, color = Color(0xFFCBD5E1))
    }
  }
}

// ==============================================================================
// 6. DANCING: 3 DANCE TRADITIONS & 18 VANNAM REFERENCE
// ==============================================================================

@Composable
fun DancingTraditionsAndVannamFeatureView() {
  val traditions = remember {
    listOf(
      Triple("උඩරට නර්තන සම්ප්‍රදාය (Kandyan)", "ප්‍රධාන බෙරය: ගැටබෙරය (ගැටය සහිතයි)\nප්‍රධාන ඇඳුම: වෙස් ඇඳුම් කට්ටලය (වෙස් තට්ටුව, බඳපටිය, අවුල්හැරය, තොඩෝඩු)\nප්‍රධාන ශාන්තිකර්මය: කොහොඹා කංකාරිය\nප්‍රධාන දෙවියන්: නාථ, විෂ්ණු, කතරගම, පත්තිනි", "කලාපය: මධ්‍යම කඳුකරය"),
      Triple("පහතරට නර්තන සම්ප්‍රදාය (Ruhunu/Low Country)", "ප්‍රධාන බෙරය: යක්බෙරය / රුහුණු බෙරය / ඝෝෂක බෙරය\nප්‍රධාන ඇඳුම: දෙවොල් ඇඳුම / කඩතුරාව / මුහුණු (වෙස් මුහුණු)\nප්‍රධාන ශාන්තිකර්ම: ගම්මඩුව, දෙවොල් මඩුව, මහාසෝහොන් සමයම, සන්නි යකුම\nවිශේෂ ලක්ෂණය: වෙස් මුහුණු පැළඳීම හා නාඩගම් සම්ප්‍රදාය", "කලාපය: දකුණු සහ බස්නාහිර වෙරළබඩ"),
      Triple("සබරගමු නර්තන සම්ප්‍රදාය (Sabaragamuwa)", "ප්‍රධාන බෙරය: දවුල (කඩිප්පුව හා අතින් වාදනය කෙරේ)\nප්‍රධාන ඇඳුම: සබරගමු ඇඳුම් කට්ටලය\nප්‍රධාන ශාන්තිකර්මය: සබරගමු මහ සමන් දේවාල පෙරහැර සහ පහන් මඩුව\nප්‍රධාන දෙවියන්: සුමන සමන් දෙවියන්", "කලාපය: සබරගමු පළාත (රත්නපුරය/කෑගල්ල)")
    )
  }

  val vannams = remember {
    listOf(
      "1. ගජගා වන්නම (ඇත් රජුගේ ගමන - හස්තිරාජ ලීලාව)",
      "2. තුරඟා වන්නම (කන්ථක අශ්වයාගේ ගමන)",
      "3. මයුරා වන්නම (මොනරාගේ රංගනය)",
      "4. උකුසා වන්නම (උකුස්සා අහසේ පියාසර කරන අයුරු)",
      "5. සිංහරාජ වන්නම (කැලේ රජු සිංහයාගේ ගර්ජනාව හා ගමන)",
      "6. නෛඅඩි වන්නම (නයාගේ නැටුම)",
      "7. හනුමා වන්නම (වඳුරාගේ හැසිරීම් රටාව)",
      "8. සැවුලා වන්නම (කිකිළිය/කුකුළාගේ හැසිරීම)",
      "9. වෛරෝඩි වන්නම (වෛරෝඩි මැණිකේ බැබළීම)",
      "10. ඊරඩි වන්නම (ඊතල විදින රණශූරයාගේ විලාසය)",
      "11. ගණපති වන්නම (ගණදෙවි වන්දනාව)",
      "12. උදාර වන්නම (රජුගේ උදාරත්වය)",
      "13. මුසලඩි වන්නම (හාවාගේ චලනයන්)",
      "14. සුරපති වන්නම (දෙවියන්ගේ නායකයා පිදීම)",
      "15. කිරලා වන්නම (කිරලාගේ හඬ හා හැසිරීම)",
      "16. අසදෘශ වන්නම (නොසැසඳිය හැකි උතුම් බව)",
      "17. දහම් වන්නම (ශ්‍රී සද්ධර්මයේ ගුණය)",
      "18. මන්දිරෝඩි වන්නම (මන්දිරවල රජවරුන්ගේ විලාසය)"
    )
  }

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(14.dp)
  ) {
    item {
      Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFF831843),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text(
            text = "💃 ත්‍රිවිධ දේශීය නර්තන සම්ප්‍රදාය සහ උඩරට වන්නම් 18",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFCE7F3)
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "උඩරට, පහතරට සහ සබරගමු නර්තන සම්ප්‍රදායන්ගේ බෙර වාදන, ඇඳුම් ආයිත්තම් සහ ශාන්තිකර්ම සංසන්දනාත්මක සටහන.",
            fontSize = 11.5.sp,
            color = Color(0xFFFBCFE8)
          )
        }
      }
    }

    items(traditions) { trad ->
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFFE11D48)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(trad.first, fontSize = 13.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDA4AF))
            Text(trad.third, fontSize = 10.sp, color = Color(0xFFFACC15), fontWeight = FontWeight.Bold)
          }
          Spacer(modifier = Modifier.height(6.dp))
          Text(trad.second, fontSize = 11.5.sp, color = Color(0xFFE2E8F0), lineHeight = 17.sp)
        }
      }
    }

    item {
      Spacer(modifier = Modifier.height(6.dp))
      Text(
        text = "📜 උඩරට ප්‍රධාන වන්නම් 18 නාමාවලිය සහ අර්ථය:",
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFF472B6)
      )
    }

    items(vannams) { v ->
      Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFF0F172A),
        border = BorderStroke(0.7.dp, Color(0xFF475569)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Text(
          text = v,
          fontSize = 12.sp,
          color = Color(0xFFF1F5F9),
          modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
        )
      }
    }
  }
}

// ==============================================================================
// 7. DAILY 5-MIN CHALLENGE & EXAM COUNTDOWN SUITE
// ==============================================================================

data class QuickQuizQuestion(
  val subject: String,
  val question: String,
  val options: List<String>,
  val correctIndex: Int,
  val explanation: String
)

@Composable
fun Daily5MinChallengeFeatureView() {
  val questions = remember {
    listOf(
      QuickQuizQuestion(
        subject = "විද්‍යාව (Science)",
        question = "මිනිස් සිරුරේ ඔක්සිජනීකෘත රුධිරය මුළු ශරීරය පුරා පොම්ප කරනු ලබන්නේ කුමන හෘද කුටීරයෙන්ද?",
        options = listOf("1. දකුණු කර්ණිකාව", "2. දකුණු කෝෂිකාව", "3. වම් කර්ණිකාව", "4. වම් කෝෂිකාව"),
        correctIndex = 3,
        explanation = "වම් කෝෂිකාවෙන් මහා ධමනිය හරහා මුළු සිරුරටම ඔක්සිජනීකෘත රුධිරය පොම්ප කෙරේ."
      ),
      QuickQuizQuestion(
        subject = "ඉතිහාසය (History)",
        question = "ශ්‍රී ලංකාවේ මුල්ම වරට ත්‍රිපිටකය ග්‍රන්ථාරූඪ කරන ලද්දේ කවර රජුගේ පාලන සමයේදීද?",
        options = listOf("1. දේවානම්පියතිස්ස රජු", "2. වළගම්බා රජු", "3. දුටුගැමුණු රජු", "4. මහාසේන රජු"),
        correctIndex = 1,
        explanation = "ක්‍රි.පූ. 1 වන සියවසේදී වළගම්බා රජු දවස මාතලේ අලුවිහාරයේදී ත්‍රිපිටකය ග්‍රන්ථාරූඪ කරන ලදී."
      ),
      QuickQuizQuestion(
        subject = "ඉංග්‍රීසි (English)",
        question = "Identify the correct verb form: 'If you studied hard, you ________ the exam.'",
        options = listOf("1. will pass", "2. would pass", "3. had passed", "4. would have passed"),
        correctIndex = 1,
        explanation = "Second Conditional form: If + Past Simple (studied), would + Base Verb (would pass)."
      ),
      QuickQuizQuestion(
        subject = "භූගෝලය (Geography)",
        question = "ලොව දිගම කඳු වැටිය වන ඇන්ඩීස් කඳු වැටිය පිහිටා ඇත්තේ කුමන මහාද්වීපයේද?",
        options = listOf("1. උතුරු ඇමෙරිකාව", "2. අප්‍රිකාව", "3. දකුණු ඇමෙරිකාව", "4. යුරෝපය"),
        correctIndex = 2,
        explanation = "ඇන්ඩීස් කඳු වැටිය දකුණු ඇමෙරිකා මහාද්වීපයේ බටහිර වෙරළ දිගේ කිලෝමීටර් 7,000ක් පුරා විහිදේ."
      ),
      QuickQuizQuestion(
        subject = "කොමස් (Commerce)",
        question = "ද්විත්ව සටහන් රීතියට අනුව ව්‍යාපාරයේ වියදම් වැඩිවීමක් සටහන් කරන්නේ කෙසේද?",
        options = listOf("1. හර කිරීමෙන්", "2. බැර කිරීමෙන්", "3. එකතු කිරීමෙන්", "4. ශේෂ කිරීමෙන්"),
        correctIndex = 0,
        explanation = "වියදම් සහ වත්කම් වැඩිවීම් සැමවිටම අදාළ ගිණුමේ හර (Debit) පැත්තේ සටහන් වේ."
      )
    )
  }

  var userAnswers by remember { mutableStateOf(mutableMapOf<Int, Int>()) }
  var showResults by remember { mutableStateOf(false) }

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(14.dp)
  ) {
    item {
      Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFF78350F),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "⚡ Daily 5-Minute Challenge",
              fontSize = 15.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFFEF3C7)
            )
            Surface(
              color = Color(0xFFF59E0B),
              shape = RoundedCornerShape(6.dp)
            ) {
              Text(
                text = "🔥 Streak: 5 Days",
                fontSize = 10.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF78350F),
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
          }
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "දිනපතා O/L විෂයයන්ගෙන් මිශ්‍ර ප්‍රශ්න 5කට පිළිතුරු දී ඔබගේ විභාග සූදානම මැන ගන්න!",
            fontSize = 11.5.sp,
            color = Color(0xFFFDE68A)
          )
        }
      }
    }

    items(questions.size) { index ->
      val q = questions[index]
      val selected = userAnswers[index]

      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFF334155)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Surface(
            color = Color(0xFF0F172A),
            shape = RoundedCornerShape(6.dp)
          ) {
            Text(
              text = "ප්‍රශ්නය 0${index + 1} • ${q.subject}",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF38BDF8),
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.height(6.dp))
          Text(q.question, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
          Spacer(modifier = Modifier.height(10.dp))

          q.options.forEachIndexed { optIndex, opt ->
            val isOptSelected = selected == optIndex
            val isCorrect = q.correctIndex == optIndex

            val btnColor = when {
              showResults && isCorrect -> Color(0xFF059669)
              showResults && isOptSelected && !isCorrect -> Color(0xFFDC2626)
              isOptSelected -> Color(0xFF2563EB)
              else -> Color(0xFF0F172A)
            }

            Surface(
              shape = RoundedCornerShape(8.dp),
              color = btnColor,
              border = BorderStroke(1.dp, if (isOptSelected) Color.White else Color(0xFF475569)),
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 3.dp)
                .clickable(enabled = !showResults) {
                  val newMap = userAnswers.toMutableMap()
                  newMap[index] = optIndex
                  userAnswers = newMap
                }
            ) {
              Text(
                text = opt,
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
              )
            }
          }

          if (showResults) {
            Spacer(modifier = Modifier.height(8.dp))
            Surface(
              shape = RoundedCornerShape(8.dp),
              color = Color(0xFF064E3B),
              modifier = Modifier.fillMaxWidth()
            ) {
              Text(
                text = "💡 විවරණය: ${q.explanation}",
                fontSize = 11.sp,
                color = Color(0xFFD1FAE5),
                modifier = Modifier.padding(8.dp)
              )
            }
          }
        }
      }
    }

    item {
      if (!showResults) {
        Button(
          onClick = { showResults = true },
          enabled = userAnswers.size == questions.size,
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF59E0B)),
          shape = RoundedCornerShape(10.dp),
          modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
        ) {
          Text("ලකුණු පරීක්ෂා කරන්න (Submit 5/5)", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF78350F))
        }
      } else {
        val score = questions.indices.count { userAnswers[it] == questions[it].correctIndex }
        Surface(
          shape = RoundedCornerShape(12.dp),
          color = Color(0xFF064E3B),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text("🎉 ඔබගේ ලකුණු: $score / ${questions.size}", fontSize = 16.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
            Spacer(modifier = Modifier.height(4.dp))
            Text("දෛනික Streak එක සම්පූර්ණ විය! හෙටත් අලුත් ප්‍රශ්නාවලියක් සමඟින් පුහුණු වන්න.", fontSize = 11.5.sp, color = Color(0xFFA7F3D0))
          }
        }
      }
    }
  }
}

// ==============================================================================
// 8. OFFICIAL MARKING SCHEMES & EVALUATION CRITERIA
// ==============================================================================

@Composable
fun OfficialMarkingSchemesFeatureView(
  onOpenPdfModal: ((url: String, title: String) -> Unit)? = null
) {
  val markingSchemes = remember {
    listOf(
      Triple("විද්‍යාව (Science) Marking Scheme", "I පත්‍රය: ලකුණු 40 (බහුවරණ 40x1)\nII පත්‍රය: ලකුණු 60 (ව්‍යුහගත ප්‍රශ්න 4x3.75 + රචනා ප්‍රශ්න 3x15)\nසම්පූර්ණ ලකුණු: 100", "https://drive.google.com/file/d/1science_ol_2024_2025_official_paper/preview"),
      Triple("ඉතිහාසය (History) Marking Scheme", "I පත්‍රය: ලකුණු 40 (MCQ 40x1)\nII පත්‍රය: ලකුණු 60 (සිතියම් හා රූප සටහන් ලකුණු 20 + රචනා ප්‍රශ්න 4x10)\nසම්පූර්ණ ලකුණු: 100", "https://drive.google.com/file/d/1history_ol_2024_2025_official_paper/preview"),
      Triple("ඉංග්‍රීසි (English Language) Marking Scheme", "Paper I: 40 Marks (Test 1-8)\nPaper II: 60 Marks (Test 9-16: Reading, Writing 15 marks, Grammar)\nTotal: 100 Marks", "https://drive.google.com/file/d/1english_ol_2024_2025_official_paper/preview"),
      Triple("භූගෝල විද්‍යාව (Geography) Marking Scheme", "I පත්‍රය: ලකුණු 40 (1:50,000 සිතියම ලකුණු 20 + ලංකා/ලෝක සිතියම ලකුණු 20)\nII පත්‍රය: ලකුණු 60 (රචනා ප්‍රශ්න 5ක්)\nසම්පූර්ණ ලකුණු: 100", "https://drive.google.com/file/d/1geography_ol_2024_2025_official_paper/preview"),
      Triple("ව්‍යාපාර හා ගිණුම්කරණය (Commerce) Marking Scheme", "I පත්‍රය: ලකුණු 40 (MCQ 40x1)\nII පත්‍රය: ලකුණු 60 (අනිවාර්ය ප්‍රශ්නය ලකුණු 20 + ව්‍යාපාර ප්‍රශ්න 2x10 + ගිණුම්කරණ ප්‍රශ්න 2x10)\nසම්පූර්ණ ලකුණු: 100", "https://drive.google.com/file/d/1commerce_ol_2025_2026_official_paper/preview")
    )
  }

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(14.dp)
  ) {
    item {
      Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFF1E3A8A),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text(
            text = "📋 විභාග දෙපාර්තමේන්තු නිල ලකුණු දීමේ පටිපාටි (Marking Schemes)",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFDBEAFE)
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "ප්‍රශ්න පත්‍ර පරීක්ෂකවරුන් ලකුණු ලබා දෙන නිල මාර්ගෝපදේශ සහ ලකුණු බෙදී යන ආකාරය අධ්‍යයනය කර උපරිම ලකුණු ලබාගන්න.",
            fontSize = 11.5.sp,
            color = Color(0xFFBFDBFE)
          )
        }
      }
    }

    items(markingSchemes) { ms ->
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFF2563EB)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text(ms.first, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF60A5FA))
          Spacer(modifier = Modifier.height(6.dp))
          Text(ms.second, fontSize = 12.sp, color = Color(0xFFE2E8F0), lineHeight = 18.sp)
          Spacer(modifier = Modifier.height(10.dp))
          Button(
            onClick = { onOpenPdfModal?.invoke(ms.third, ms.first) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB)),
            shape = RoundedCornerShape(8.dp)
          ) {
            Icon(Icons.AutoMirrored.Filled.MenuBook, contentDescription = "View", modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text("ප්‍රශ්න පත්‍රය & ලකුණු විවරණය බලන්න", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
          }
        }
      }
    }
  }
}

@Composable
fun CivicsEducationFeatureView(
  onOpenCategories: (() -> Unit)? = null
) {
  val civicsPillars = remember {
    listOf(
      Triple("🏛️ ප්‍රජාතන්ත්‍රවාදය & ජනතා පරමාධිපත්‍යය", "ජනතාව විසින්, ජනතාව උදෙසා, ජනතාවගේ පාලනයයි. 1978 ව්‍යවස්ථාවේ 3 වන වගන්තිය අනුව පරමාධිපත්‍ය බලය ජනතාව කෙරෙහි පිහිටා ඇත.", "විධායකය, ව්‍යවස්ථාදායකය සහ අධිකරණය හරහා ක්‍රියාත්මක වේ."),
      Triple("⚖️ නීතියේ ආධිපත්‍යය (Rule of Law)", "නීතිය සැමට එක හා සමානව ක්‍රියාත්මක වීම, නීතියට ඉහළින් කිසිවෙකු නොසිටීම සහ ස්වාධීන අධිකරණයක පැවැත්මයි.", "A.V. ඩයිසිගේ මූලධර්ම 3: නීතියේ ආධිපත්‍යය, නීතිය ඉදිරියේ සමානාත්මතාව, ව්‍යවස්ථාමය නීති."),
      Triple("🌟 යහපාලනයේ මූලික ලක්ෂණ 8 (Good Governance)", "1. සහභාගිත්වය, 2. නීතියේ ආධිපත්‍යය, 3. විනිවිදභාවය, 4. ප්‍රතිචාරාත්මක බව, 5. එකඟතාවය, 6. සාධාරණත්වය, 7. කාර්යක්ෂමතාව, 8. වගවීම.", "රාජ්‍ය සම්පත් කළමනාකරණය හා දූෂණය පිටුදැකීමට අත්‍යවශ්‍ය වේ."),
      Triple("🗳️ සර්වජන ඡන්ද බලය & මැතිවරණ", "1931 ඩොනමෝර් ආණ්ඩුක්‍රමය මඟින් ආසියාවේ ප්‍රථම වරට ශ්‍රී ලංකාවට හිමිවිය. වයස අවුරුදු 18 සපිරි සෑම පුරවැසියෙකුටම ඡන්ද අයිතිය හිමිය.", "කේවල ක්‍රමය, සමානුපාතික නියෝජනය සහ මනාප ක්‍රමය.")
    )
  }

  val coreCivicUnits = remember {
    listOf(
      Triple("1833 කෝල්බෲක්-කැමරන්", "මුළු දිවයිනම එකම පරිපාලනයකට ගෙන ඒම, ව්‍යවස්ථාදායක හා විධායක සභා පිහිටුවීම, පළාත් 5 කට බෙදීම.", "📜 ව්‍යවස්ථා ඉතිහාසය"),
      Triple("1931 ඩොනමෝර් ආණ්ඩුක්‍රමය", "සර්වජන ඡන්ද බලය හඳුන්වා දීම, රාජ්‍ය මන්ත්‍රණ සභාව, කාරක සභා ක්‍රමය, වාර්ගික නියෝජනය අහෝසි කිරීම.", "📜 ව්‍යවස්ථා ඉතිහාසය"),
      Triple("1947 සෝල්බරි ආණ්ඩුක්‍රමය", "පාර්ලිමේන්තු ආණ්ඩුක්‍රමය, නියෝජිත මන්ත්‍රී මණ්ඩලය හා සෙනෙට් සභාව (ද්වි-මණ්ඩල), අගමැති ප්‍රමුඛ අමාත්‍ය මණ්ඩලය.", "📜 නිදහස් ලංකාව"),
      Triple("1972 පළමු ජනරජ ව්‍යවස්ථාව", "ශ්‍රී ලංකාව නිදහස් ස්වෛරී ස්වාධීන ජනරජයක් වීම, ජාතික රාජ්‍ය සභාව, නාමමාත්‍රික ජනාධිපති ධුරය, සෝල්බරි ව්‍යවස්ථාව අවසන් කිරීම.", "📜 ජනරජ යුගය"),
      Triple("1978 දෙවන ජනරජ ව්‍යවස්ථාව", "විධායක ජනාධිපති ධුරය, සමානුපාතික මැතිවරණ ක්‍රමය, මූලික අයිතිවාසිකම් අධිකරණයෙන් බලාත්මක කිරීම.", "📜 වර්තමාන ව්‍යවස්ථාව")
    )
  }

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(14.dp)
  ) {
    item {
      Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFF042F2C),
        border = BorderStroke(1.dp, Color(0xFF14B8A6)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text(
            text = "⚖️ පුරවැසි අධ්‍යාපනය (Civic Education) විශේෂ මෙවලම් & කරුණු සංග්‍රහය",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFCCFBF1)
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "සා/පෙළ 10 & 11 ශ්‍රේණි සඳහා නිල විෂය නිර්දේශයේ ප්‍රජාතන්ත්‍රවාදය, ආණ්ඩුක්‍රම විකාශනය, මානව හිමිකම් සහ යහපාලන සංකල්ප.",
            fontSize = 11.5.sp,
            color = Color(0xFF99F6E4)
          )

          if (onOpenCategories != null) {
            Spacer(modifier = Modifier.height(10.dp))
            Button(
              onClick = onOpenCategories,
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D9488)),
              shape = RoundedCornerShape(8.dp),
              contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
              modifier = Modifier.testTag("open_civics_categories_btn")
            ) {
              Text("📚 පුරවැසි අධ්‍යාපනය කරුණු 20 බැගින් වූ කාණ්ඩ 20 (කරුණු 400)", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
          }
        }
      }
    }

    item {
      Text(
        text = "🏛️ ප්‍රජාතන්ත්‍රවාදී පාලන ව්‍යුහය & මූලධර්ම (Core Civic Principles):",
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF2DD4BF)
      )
    }

    items(civicsPillars) { pillar ->
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF134E4A).copy(alpha = 0.4f)),
        border = BorderStroke(1.dp, Color(0xFF0D9488)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text(pillar.first, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF5EEAD4))
          Spacer(modifier = Modifier.height(4.dp))
          Text(pillar.second, fontSize = 12.sp, color = Color(0xFFE2E8F0))
          Spacer(modifier = Modifier.height(4.dp))
          Text("💡 විභාග වැදගත්කම: ${pillar.third}", fontSize = 11.sp, color = Color(0xFFFDE047))
        }
      }
    }

    item {
      Spacer(modifier = Modifier.height(6.dp))
      Text(
        text = "⏳ ශ්‍රී ලංකාවේ ආණ්ඩුක්‍රම ව්‍යවස්ථා විකාශනය (Constitutional Evolution):",
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF38BDF8)
      )
    }

    items(coreCivicUnits) { unit ->
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        border = BorderStroke(1.dp, Color(0xFF0284C7)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(unit.first, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
            Surface(
              shape = RoundedCornerShape(4.dp),
              color = Color(0xFF0369A1)
            ) {
              Text(
                text = unit.third,
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
          }
          Spacer(modifier = Modifier.height(4.dp))
          Text(unit.second, fontSize = 12.sp, color = Color(0xFFCBD5E1))
        }
      }
    }
  }
}
