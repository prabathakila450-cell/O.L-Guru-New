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
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy

/**
 * 🌟 100% ACCURATE GRADE 10 & 11 ART (චිත්‍ර කලාව) MASTER HUB
 * Strictly exclusive to Grade 10 & 11 Art Subject
 * Fully scrollable top-to-bottom across the ENTIRE screen.
 */
@Composable
fun ArtGrade10And11MasterHubDialog(
  initialGradeTab: ArtGradeTab = ArtGradeTab.ALL,
  initialSectionCategory: ArtSectionCategory? = null,
  onDismiss: () -> Unit
) {
  var selectedGradeTab by remember { mutableStateOf(initialGradeTab) }
  var selectedCategory by remember { mutableStateOf(initialSectionCategory ?: ArtSectionCategory.SRI_LANKAN_ART) }
  var searchQuery by remember { mutableStateOf("") }

  // State for MCQ interactive test
  val userSelectedOptions = remember { mutableStateMapOf<Int, Int>() }
  var mcqScore by remember { mutableIntStateOf(0) }

  // Expanded items state
  var expandedHeritageId by remember { mutableStateOf<String?>(null) }
  var expandedWorldArtId by remember { mutableStateOf<String?>(null) }
  var expandedRuleId by remember { mutableStateOf<String?>(null) }
  var expandedPracticalId by remember { mutableStateOf<String?>(null) }
  var expandedEssayId by remember { mutableStateOf<String?>(null) }
  var expandedLessonId by remember { mutableStateOf<String?>(null) }

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
        .testTag("art_master_hub_dialog"),
      color = Color(0xFF1A1208)
    ) {
      LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 60.dp)
      ) {
        // TOP APP BAR
        item(key = "top_app_bar") {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .background(
                Brush.verticalGradient(
                  colors = listOf(Color(0xFFC2410C), Color(0xFF9A3412))
                )
              )
              .statusBarsPadding()
              .padding(horizontal = 12.dp, vertical = 10.dp)
          ) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically
            ) {
              IconButton(
                onClick = onDismiss,
                modifier = Modifier
                  .size(36.dp)
                  .background(Color.White.copy(alpha = 0.2f), CircleShape)
                  .testTag("art_hub_back_btn")
              ) {
                Icon(
                  imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                  contentDescription = "Back",
                  tint = Color.White,
                  modifier = Modifier.size(20.dp)
                )
              }

              Spacer(modifier = Modifier.width(10.dp))

              Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text("🎨", fontSize = 16.sp)
                  Spacer(modifier = Modifier.width(5.dp))
                  Text(
                    text = "10 & 11 චිත්‍ර කලාව Master Hub",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                  )
                  Spacer(modifier = Modifier.width(6.dp))
                  Surface(
                    color = Color(0xFFFDE68A),
                    shape = RoundedCornerShape(4.dp)
                  ) {
                    Text(
                      text = "100% O/L SYLLABUS",
                      color = Color(0xFF78350F),
                      fontSize = 8.sp,
                      fontWeight = FontWeight.ExtraBold,
                      modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                    )
                  }
                }
                Text(
                  text = "දේශීය කලා උරුමය • ලෝක කලාව • වර්ණ න්‍යාය • දෘෂ්ටිකෝණය • MCQs • රචනා",
                  color = Color(0xFFFFEDD5),
                  fontSize = 10.sp,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }
            }
          }
        }

        // GRADE TABS SELECTOR (10 & 11)
        item(key = "grade_tabs") {
          Surface(
            color = Color(0xFF291809),
            border = BorderStroke(1.dp, Color(0xFF451A03)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 6.dp),
              horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
              ArtGradeTab.values().forEach { tab ->
                val isSelected = selectedGradeTab == tab
                Surface(
                  onClick = { selectedGradeTab = tab },
                  shape = RoundedCornerShape(8.dp),
                  color = if (isSelected) Color(0xFFEA580C) else Color(0xFF3C200B),
                  border = BorderStroke(
                    1.dp,
                    if (isSelected) Color(0xFFFB923C) else Color(0xFF552A0A)
                  ),
                  modifier = Modifier.weight(1f)
                ) {
                  Column(
                    modifier = Modifier.padding(vertical = 6.dp, horizontal = 4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                  ) {
                    Text(
                      text = tab.labelSinhala,
                      color = if (isSelected) Color.White else Color(0xFFFED7AA),
                      fontSize = 11.sp,
                      fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                    )
                    Text(
                      text = tab.badge,
                      color = if (isSelected) Color(0xFFFFEDD5) else Color(0xFFFDBA74).copy(alpha = 0.7f),
                      fontSize = 8.5.sp
                    )
                  }
                }
              }
            }
          }
        }

        // SECTION CATEGORIES HORIZONTAL SCROLL
        item(key = "section_categories") {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .background(Color(0xFF1A1208))
              .horizontalScroll(rememberScrollState())
              .padding(horizontal = 8.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            ArtSectionCategory.values().forEach { cat ->
              val isSelected = selectedCategory == cat
              Surface(
                onClick = { selectedCategory = cat },
                shape = RoundedCornerShape(10.dp),
                color = if (isSelected) cat.themeColor else Color(0xFF2E1908),
                border = BorderStroke(
                  1.2.dp,
                  if (isSelected) Color.White.copy(alpha = 0.6f) else cat.themeColor.copy(alpha = 0.4f)
                ),
                modifier = Modifier.height(34.dp)
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(cat.emoji, fontSize = 13.sp)
                  Spacer(modifier = Modifier.width(5.dp))
                  Text(
                    text = cat.titleSinhala,
                    color = if (isSelected) Color.White else Color(0xFFFED7AA),
                    fontSize = 10.5.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                  )
                }
              }
            }
          }
        }

        // SEARCH BAR
        item(key = "search_bar") {
          Surface(
            color = Color(0xFF271507),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 4.dp),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color(0xFF431407))
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFFFDBA74), modifier = Modifier.size(16.dp))
              Spacer(modifier = Modifier.width(6.dp))
              TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("සීගිරිය, ඩා වින්චි, වර්ණ න්‍යාය, දෘෂ්ටිකෝණය සොයන්න...", fontSize = 11.sp, color = Color(0xFF9A3412)) },
                colors = TextFieldDefaults.colors(
                  focusedContainerColor = Color.Transparent,
                  unfocusedContainerColor = Color.Transparent,
                  focusedIndicatorColor = Color.Transparent,
                  unfocusedIndicatorColor = Color.Transparent,
                  focusedTextColor = Color.White,
                  unfocusedTextColor = Color.White
                ),
                singleLine = true,
                modifier = Modifier.weight(1f).height(40.dp)
              )
              if (searchQuery.isNotBlank()) {
                IconButton(onClick = { searchQuery = "" }, modifier = Modifier.size(24.dp)) {
                  Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color.White, modifier = Modifier.size(14.dp))
                }
              }
            }
          }
        }

        item(key = "section_spacer") {
          Spacer(modifier = Modifier.height(4.dp))
        }

        // CONTENT SECTION ITEMS
        when (selectedCategory) {
          ArtSectionCategory.SRI_LANKAN_ART -> {
            val items = ArtMasterDataProvider.heritageItems.filter {
              val matchesGrade = when (selectedGradeTab) {
                ArtGradeTab.ALL -> true
                ArtGradeTab.GRADE_10 -> it.eraOrSchool.contains("අනුරාධපුර") || it.eraOrSchool.contains("ප්‍රාග්")
                ArtGradeTab.GRADE_11 -> it.eraOrSchool.contains("පොළොන්නරු") || it.eraOrSchool.contains("මහනුවර")
              }
              matchesGrade && (searchQuery.isBlank() ||
              it.titleSinhala.contains(searchQuery, ignoreCase = true) ||
              it.location.contains(searchQuery, ignoreCase = true) ||
              it.artisticSignificance.contains(searchQuery, ignoreCase = true))
            }
            artHeritageSection(
              items = items,
              expandedId = expandedHeritageId,
              onToggleExpand = { expandedHeritageId = if (expandedHeritageId == it) null else it }
            )
          }

          ArtSectionCategory.WORLD_ART -> {
            val items = ArtMasterDataProvider.worldArtItems.filter {
              searchQuery.isBlank() ||
              it.artistOrMonument.contains(searchQuery, ignoreCase = true) ||
              it.movementOrEra.contains(searchQuery, ignoreCase = true) ||
              it.styleAndTechnique.contains(searchQuery, ignoreCase = true)
            }
            artWorldArtSection(
              items = items,
              expandedId = expandedWorldArtId,
              onToggleExpand = { expandedWorldArtId = if (expandedWorldArtId == it) null else it }
            )
          }

          ArtSectionCategory.ELEMENTS_AND_COLOR -> {
            val rules = ArtMasterDataProvider.elementsAndRules.filter {
              searchQuery.isBlank() ||
              it.titleSinhala.contains(searchQuery, ignoreCase = true) ||
              it.category.contains(searchQuery, ignoreCase = true) ||
              it.definition.contains(searchQuery, ignoreCase = true)
            }
            artElementsAndColorSection(
              rules = rules,
              expandedId = expandedRuleId,
              onToggleExpand = { expandedRuleId = if (expandedRuleId == it) null else it }
            )
          }

          ArtSectionCategory.PRACTICAL_TECHNIQUES -> {
            val guides = ArtMasterDataProvider.practicalGuides.filter {
              searchQuery.isBlank() ||
              it.titleSinhala.contains(searchQuery, ignoreCase = true) ||
              it.topic.contains(searchQuery, ignoreCase = true)
            }
            artPracticalGuidesSection(
              guides = guides,
              expandedId = expandedPracticalId,
              onToggleExpand = { expandedPracticalId = if (expandedPracticalId == it) null else it }
            )
          }

          ArtSectionCategory.EXAM_MCQ_AND_ESSAYS -> {
            val mcqList = ArtMasterDataProvider.mcqQuestions.filter {
              val matchesGrade = when (selectedGradeTab) {
                ArtGradeTab.ALL -> true
                ArtGradeTab.GRADE_10 -> it.grade == "10"
                ArtGradeTab.GRADE_11 -> it.grade == "11"
              }
              matchesGrade && (searchQuery.isBlank() ||
              it.questionText.contains(searchQuery, ignoreCase = true) ||
              it.categoryTag.contains(searchQuery, ignoreCase = true))
            }
            val essays = ArtMasterDataProvider.modelEssays.filter {
              searchQuery.isBlank() ||
              it.questionTitle.contains(searchQuery, ignoreCase = true) ||
              it.unitName.contains(searchQuery, ignoreCase = true)
            }
            artExamsSection(
              mcqList = mcqList,
              essays = essays,
              userSelectedOptions = userSelectedOptions,
              onSelectOption = { qId, optIndex, isCorrect ->
                userSelectedOptions[qId] = optIndex
                if (isCorrect) mcqScore++
              },
              mcqScore = mcqScore,
              expandedEssayId = expandedEssayId,
              onToggleEssay = { expandedEssayId = if (expandedEssayId == it) null else it }
            )
          }

          ArtSectionCategory.LESSONS_AND_NOTES -> {
            val lessons = ArtMasterDataProvider.lessonNotes.filter {
              val matchesGrade = when (selectedGradeTab) {
                ArtGradeTab.ALL -> true
                ArtGradeTab.GRADE_10 -> it.grade == "10"
                ArtGradeTab.GRADE_11 -> it.grade == "11"
              }
              matchesGrade && (searchQuery.isBlank() ||
              it.unitTitle.contains(searchQuery, ignoreCase = true) ||
              it.summaryText.contains(searchQuery, ignoreCase = true))
            }
            artLessonsSection(
              lessons = lessons,
              expandedId = expandedLessonId,
              onToggleExpand = { expandedLessonId = if (expandedLessonId == it) null else it }
            )
          }
        }
      }
    }
  }
}

/**
 * 🌟 INLINE EMBEDDED ART MASTER HUB (INSIDE SUBJECT SCREEN)
 */
@Composable
fun ArtGrade10And11MasterHub(
  currentGrade: String = "11",
  onOpenFullHub: (ArtSectionCategory?) -> Unit
) {
  Card(
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF281308)),
    border = BorderStroke(1.2.dp, Color(0xFFEA580C)),
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(14.dp))
      .clickable { onOpenFullHub(null) }
      .testTag("art_master_hub_embedded_card")
  ) {
    Column(modifier = Modifier.padding(12.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Text("🎨", fontSize = 18.sp)
          Spacer(modifier = Modifier.width(6.dp))
          Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text(
                text = "10 & 11 චිත්‍ර කලාව Master Hub (පූර්ණ තිරයෙන්)",
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
              )
              Spacer(modifier = Modifier.width(6.dp))
              Surface(
                color = Color(0xFFEA580C),
                shape = RoundedCornerShape(4.dp)
              ) {
                Text(
                  text = "100% SYLLABUS",
                  color = Color.White,
                  fontSize = 8.sp,
                  fontWeight = FontWeight.ExtraBold,
                  modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.5.dp)
                )
              }
            }
            Text(
              text = "දේශීය කලා උරුමය • පුනරුදය • වර්ණ න්‍යාය • දෘෂ්ටිකෝණය • මානව රූප • MCQs",
              color = Color(0xFFFED7AA),
              fontSize = 10.sp
            )
          }
        }
        Surface(
          color = Color(0xFF9A3412),
          shape = CircleShape,
          border = BorderStroke(1.dp, Color(0xFFFB923C))
        ) {
          Icon(
            imageVector = Icons.Default.OpenInFull,
            contentDescription = "Open Fullscreen",
            tint = Color(0xFFFDE047),
            modifier = Modifier.padding(6.dp).size(15.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      // Shortcut Buttons Row
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        Button(
          onClick = { onOpenFullHub(ArtSectionCategory.SRI_LANKAN_ART) },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD97706)),
          shape = RoundedCornerShape(8.dp),
          contentPadding = PaddingValues(horizontal = 8.dp, vertical = 3.dp),
          modifier = Modifier.height(28.dp)
        ) {
          Text("🏛️ දේශීය උරුමය", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        Button(
          onClick = { onOpenFullHub(ArtSectionCategory.WORLD_ART) },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
          shape = RoundedCornerShape(8.dp),
          contentPadding = PaddingValues(horizontal = 8.dp, vertical = 3.dp),
          modifier = Modifier.height(28.dp)
        ) {
          Text("🌍 ලෝක කලාව", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        Button(
          onClick = { onOpenFullHub(ArtSectionCategory.ELEMENTS_AND_COLOR) },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C3AED)),
          shape = RoundedCornerShape(8.dp),
          contentPadding = PaddingValues(horizontal = 8.dp, vertical = 3.dp),
          modifier = Modifier.height(28.dp)
        ) {
          Text("🎨 වර්ණ න්‍යාය", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        Button(
          onClick = { onOpenFullHub(ArtSectionCategory.PRACTICAL_TECHNIQUES) },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669)),
          shape = RoundedCornerShape(8.dp),
          contentPadding = PaddingValues(horizontal = 8.dp, vertical = 3.dp),
          modifier = Modifier.height(28.dp)
        ) {
          Text("🖌️ ප්‍රායෝගික ශිල්ප", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        Button(
          onClick = { onOpenFullHub(ArtSectionCategory.EXAM_MCQ_AND_ESSAYS) },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
          shape = RoundedCornerShape(8.dp),
          contentPadding = PaddingValues(horizontal = 8.dp, vertical = 3.dp),
          modifier = Modifier.height(28.dp)
        ) {
          Text("🎯 O/L MCQs & රචනා", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
      }
    }
  }
}

// ============================================================================
// SUB-COMPONENTS FOR EACH CATEGORY (LAZYLISTSCOPE EXTENSIONS)
// ============================================================================

fun LazyListScope.artHeritageSection(
  items: List<ArtHeritageItem>,
  expandedId: String?,
  onToggleExpand: (String) -> Unit
) {
  items(items, key = { "heritage_${it.id}" }) { item ->
    val isExpanded = expandedId == item.id
    Card(
      shape = RoundedCornerShape(12.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFF26180B)),
      border = BorderStroke(1.dp, Color(0xFFD97706)),
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
      Column(modifier = Modifier.padding(12.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Column(modifier = Modifier.weight(1f)) {
            Text(
              text = item.titleSinhala,
              color = Color.White,
              fontSize = 13.5.sp,
              fontWeight = FontWeight.Bold
            )
            Text(
              text = "${item.eraOrSchool} • ${item.location}",
              color = Color(0xFFFDE68A),
              fontSize = 10.sp
            )
          }
          IconButton(
            onClick = { onToggleExpand(item.id) },
            modifier = Modifier.size(28.dp)
          ) {
            Icon(
              imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
              contentDescription = "Expand",
              tint = Color(0xFFFBBF24)
            )
          }
        }

        Spacer(modifier = Modifier.height(4.dp))
        Text("මාධ්‍ය & ශිල්ප ක්‍රමය: ${item.mediumAndTechnique}", fontSize = 10.sp, color = Color(0xFFFED7AA))

        AnimatedVisibility(
          visible = isExpanded,
          enter = fadeIn() + expandVertically(),
          exit = fadeOut() + shrinkVertically()
        ) {
          Column(modifier = Modifier.padding(top = 8.dp)) {
            HorizontalDivider(color = Color(0xFF78350F))
            Spacer(modifier = Modifier.height(6.dp))

            Text("📌 ප්‍රධාන කලාත්මක ලක්ෂණ:", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE047))
            item.coreCharacteristics.forEach { char ->
              Text("• $char", fontSize = 10.sp, color = Color(0xFFFEF3C7), modifier = Modifier.padding(start = 6.dp, top = 1.5.dp), lineHeight = 14.sp)
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text("🏛️ කලාත්මක වැදගත්කම: ${item.artisticSignificance}", fontSize = 10.sp, color = Color.White, lineHeight = 14.sp)

            Spacer(modifier = Modifier.height(4.dp))
            Text("👑 රාජ්‍ය අනුග්‍රහය: ${item.historicalPatronage}", fontSize = 9.5.sp, color = Color(0xFF6EE7B7))
          }
        }
      }
    }
  }
}

fun LazyListScope.artWorldArtSection(
  items: List<WorldArtItem>,
  expandedId: String?,
  onToggleExpand: (String) -> Unit
) {
  items(items, key = { "world_${it.id}" }) { item ->
    val isExpanded = expandedId == item.id
    Card(
      shape = RoundedCornerShape(12.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFF142436)),
      border = BorderStroke(1.dp, Color(0xFF0284C7)),
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
      Column(modifier = Modifier.padding(12.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Column(modifier = Modifier.weight(1f)) {
            Text(
              text = item.artistOrMonument,
              color = Color.White,
              fontSize = 13.5.sp,
              fontWeight = FontWeight.Bold
            )
            Text(
              text = "ප්‍රවණතාවය / යුගය: ${item.movementOrEra}",
              color = Color(0xFFBAE6FD),
              fontSize = 10.sp
            )
          }
          IconButton(
            onClick = { onToggleExpand(item.id) },
            modifier = Modifier.size(28.dp)
          ) {
            Icon(
              imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
              contentDescription = "Expand",
              tint = Color(0xFF38BDF8)
            )
          }
        }

        Spacer(modifier = Modifier.height(4.dp))
        Text("ප්‍රකට නිර්මාණ: ${item.famousArtworks.joinToString(", ")}", fontSize = 10.sp, color = Color(0xFFE0F2FE))

        AnimatedVisibility(
          visible = isExpanded,
          enter = fadeIn() + expandVertically(),
          exit = fadeOut() + shrinkVertically()
        ) {
          Column(modifier = Modifier.padding(top = 8.dp)) {
            HorizontalDivider(color = Color(0xFF0369A1))
            Spacer(modifier = Modifier.height(6.dp))

            Text("🎨 ශෛලිය සහ ශිල්ප ක්‍රමය: ${item.styleAndTechnique}", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE047))

            Spacer(modifier = Modifier.height(6.dp))
            Text("📌 ප්‍රධාන ලක්ෂණ:", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
            item.keyFeatures.forEach { feat ->
              Text("• $feat", fontSize = 10.sp, color = Color(0xFFE0F2FE), modifier = Modifier.padding(start = 6.dp, top = 1.5.dp), lineHeight = 14.sp)
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text("🌍 ඓතිහාසික බලපෑම: ${item.historicalImpact}", fontSize = 10.sp, color = Color(0xFF6EE7B7), lineHeight = 14.sp)
          }
        }
      }
    }
  }
}

fun LazyListScope.artElementsAndColorSection(
  rules: List<ArtElementRule>,
  expandedId: String?,
  onToggleExpand: (String) -> Unit
) {
  items(rules, key = { "rule_${it.id}" }) { rule ->
    val isExpanded = expandedId == rule.id
    Card(
      shape = RoundedCornerShape(12.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFF261238)),
      border = BorderStroke(1.dp, Color(0xFF7C3AED)),
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
      Column(modifier = Modifier.padding(12.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Column(modifier = Modifier.weight(1f)) {
            Text(
              text = rule.titleSinhala,
              color = Color.White,
              fontSize = 13.sp,
              fontWeight = FontWeight.Bold
            )
            Text(
              text = "${rule.category} • ${rule.titleEnglish}",
              color = Color(0xFFDDD6FE),
              fontSize = 10.sp
            )
          }
          IconButton(
            onClick = { onToggleExpand(rule.id) },
            modifier = Modifier.size(28.dp)
          ) {
            Icon(
              imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
              contentDescription = "Expand",
              tint = Color(0xFFA78BFA)
            )
          }
        }

        Spacer(modifier = Modifier.height(4.dp))
        Text(rule.definition, fontSize = 10.sp, color = Color(0xFFEDE9FE), lineHeight = 14.sp)

        AnimatedVisibility(visible = isExpanded) {
          Column(modifier = Modifier.padding(top = 8.dp)) {
            HorizontalDivider(color = Color(0xFF4C1D95))
            Spacer(modifier = Modifier.height(6.dp))

            Text("🎯 ප්‍රායෝගික යෙදීම් සහ වර්ගීකරණය:", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE047))
            rule.practicalApplication.forEach { app ->
              Text("• $app", fontSize = 9.5.sp, color = Color(0xFFF5F3FF), modifier = Modifier.padding(start = 6.dp, top = 2.dp), lineHeight = 14.sp)
            }

            Spacer(modifier = Modifier.height(6.dp))
            Surface(
              color = Color(0xFF1E1030),
              shape = RoundedCornerShape(6.dp),
              border = BorderStroke(1.dp, Color(0xFF7C3AED).copy(alpha = 0.5f)),
              modifier = Modifier.fillMaxWidth().padding(top = 4.dp)
            ) {
              Text(
                text = "💡 විභාග ඉඟිය: ${rule.examTip}",
                fontSize = 9.5.sp,
                color = Color(0xFFFCD34D),
                modifier = Modifier.padding(6.dp),
                lineHeight = 13.5.sp
              )
            }
          }
        }
      }
    }
  }
}

fun LazyListScope.artPracticalGuidesSection(
  guides: List<PracticalDrawingGuide>,
  expandedId: String?,
  onToggleExpand: (String) -> Unit
) {
  items(guides, key = { "guide_${it.id}" }) { guide ->
    val isExpanded = expandedId == guide.id
    Card(
      shape = RoundedCornerShape(12.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFF0F2B1F)),
      border = BorderStroke(1.dp, Color(0xFF059669)),
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
      Column(modifier = Modifier.padding(12.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Column(modifier = Modifier.weight(1f)) {
            Text(
              text = guide.titleSinhala,
              color = Color.White,
              fontSize = 13.sp,
              fontWeight = FontWeight.Bold
            )
            Text(
              text = "තේමාව: ${guide.topic}",
              color = Color(0xFFA7F3D0),
              fontSize = 10.sp
            )
          }
          IconButton(
            onClick = { onToggleExpand(guide.id) },
            modifier = Modifier.size(28.dp)
          ) {
            Icon(
              imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
              contentDescription = "Expand",
              tint = Color(0xFF34D399)
            )
          }
        }

        Spacer(modifier = Modifier.height(4.dp))
        Text("නීති & අනුපාත: ${guide.proportionsOrRules}", fontSize = 10.sp, color = Color(0xFFD1FAE5))

        AnimatedVisibility(visible = isExpanded) {
          Column(modifier = Modifier.padding(top = 8.dp)) {
            HorizontalDivider(color = Color(0xFF065F46))
            Spacer(modifier = Modifier.height(6.dp))

            Text("📐 පියවරෙන් පියවර නිර්මාණ මාර්ගෝපදේශය:", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE047))
            guide.stepByStepSteps.forEach { step ->
              Text(step, fontSize = 9.5.sp, color = Color.White, modifier = Modifier.padding(start = 6.dp, top = 2.dp), lineHeight = 14.sp)
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text("⚠️ වැළකිය යුතු පොදු වැරදි: ${guide.commonMistakes}", fontSize = 9.5.sp, color = Color(0xFFFECDD3))

            Spacer(modifier = Modifier.height(4.dp))
            Text("🖌️ භාවිතා කළ යුතු මාධ්‍ය: ${guide.materialsUsed}", fontSize = 9.sp, color = Color(0xFF6EE7B7))
          }
        }
      }
    }
  }
}

fun LazyListScope.artExamsSection(
  mcqList: List<ArtMcqQuestion>,
  essays: List<ArtModelEssay>,
  userSelectedOptions: Map<Int, Int>,
  onSelectOption: (Int, Int, Boolean) -> Unit,
  mcqScore: Int,
  expandedEssayId: String?,
  onToggleEssay: (String) -> Unit
) {
  item(key = "mcq_score_header") {
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFF3E1E0B)),
      border = BorderStroke(1.dp, Color(0xFFEA580C)),
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
      Row(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Column {
          Text("🎯 O/L චිත්‍ර කලාව MCQ පෙරහුරුව", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
          Text("පිළිතුරු ලකුණු කර විවරණ බලන්න", color = Color(0xFFFED7AA), fontSize = 9.5.sp)
        }
        Surface(
          color = Color(0xFFEA580C),
          shape = RoundedCornerShape(8.dp)
        ) {
          Text(
            text = "ලකුණු: $mcqScore / ${mcqList.size}",
            color = Color.White,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
          )
        }
      }
    }
  }

  itemsIndexed(mcqList, key = { index, mcq -> "mcq_${mcq.id}" }) { index, mcq ->
    val selectedOption = userSelectedOptions[mcq.id]
    val hasAnswered = selectedOption != null

    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFF221307)),
      border = BorderStroke(1.dp, Color(0xFF78350F)),
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
      Column(modifier = Modifier.padding(10.dp)) {
        Text(
          text = "${index + 1}. [${mcq.grade} ශ්‍රේණිය • ${mcq.categoryTag}]",
          color = Color(0xFFFDBA74),
          fontSize = 9.5.sp,
          fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(mcq.questionText, color = Color.White, fontSize = 11.5.sp, fontWeight = FontWeight.Medium, lineHeight = 15.sp)

        Spacer(modifier = Modifier.height(8.dp))

        mcq.options.forEachIndexed { optIndex, optText ->
          val isSelected = selectedOption == optIndex
          val isCorrect = optIndex == mcq.correctOptionIndex

          val optColor = when {
            !hasAnswered -> Color(0xFF331C0C)
            isSelected && isCorrect -> Color(0xFF065F46)
            isSelected && !isCorrect -> Color(0xFF7F1D1D)
            isCorrect -> Color(0xFF065F46).copy(alpha = 0.6f)
            else -> Color(0xFF331C0C)
          }

          Surface(
            onClick = {
              if (!hasAnswered) {
                onSelectOption(mcq.id, optIndex, optIndex == mcq.correctOptionIndex)
              }
            },
            shape = RoundedCornerShape(6.dp),
            color = optColor,
            border = BorderStroke(1.dp, if (isSelected) Color.White else Color(0xFF552A0A)),
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = "(${optIndex + 1})",
                color = Color(0xFFFED7AA),
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
              )
              Spacer(modifier = Modifier.width(6.dp))
              Text(optText, color = Color.White, fontSize = 10.sp, modifier = Modifier.weight(1f))
              if (hasAnswered && isCorrect) {
                Icon(Icons.Default.CheckCircle, contentDescription = "Correct", tint = Color(0xFF34D399), modifier = Modifier.size(16.dp))
              }
            }
          }
        }

        if (hasAnswered) {
          Spacer(modifier = Modifier.height(6.dp))
          Surface(
            color = Color(0xFF1A0E05),
            shape = RoundedCornerShape(6.dp),
            border = BorderStroke(1.dp, Color(0xFF451A03)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Text(
              text = "💡 විවරණය: ${mcq.explanation}",
              fontSize = 9.5.sp,
              color = Color(0xFFFDE047),
              modifier = Modifier.padding(6.dp),
              lineHeight = 13.5.sp
            )
          }
        }
      }
    }
  }

  item(key = "essay_header") {
    Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)) {
      Text("📝 O/L II පත්‍රයේ ආදර්ශ රචනා සහ ලකුණු පටිපාටි", color = Color(0xFFFDE047), fontSize = 13.sp, fontWeight = FontWeight.Bold)
    }
  }

  items(essays, key = { "essay_${it.id}" }) { essay ->
    val isExpanded = expandedEssayId == essay.id
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1528)),
      border = BorderStroke(1.dp, Color(0xFF7C3AED)),
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
      Column(modifier = Modifier.padding(10.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Column(modifier = Modifier.weight(1f)) {
            Text(essay.questionTitle, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text("ඒකකය: ${essay.unitName} • ${essay.grade} ශ්‍රේණිය", color = Color(0xFFC4B5FD), fontSize = 9.sp)
          }
          IconButton(onClick = { onToggleEssay(essay.id) }, modifier = Modifier.size(24.dp)) {
            Icon(if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore, contentDescription = null, tint = Color(0xFFA78BFA))
          }
        }

        Text(essay.scenarioOrStem, fontSize = 9.5.sp, color = Color(0xFFEDE9FE), lineHeight = 13.5.sp)

        AnimatedVisibility(visible = isExpanded) {
          Column(modifier = Modifier.padding(top = 8.dp)) {
            HorizontalDivider(color = Color(0xFF4C1D95))
            Spacer(modifier = Modifier.height(6.dp))

            essay.subQuestions.forEach { sq ->
              Text("${sq.numberText} ${sq.questionText} (ලකුණු ${sq.marks})", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE047))
              Spacer(modifier = Modifier.height(2.dp))
              sq.markingSchemePoints.forEach { pt ->
                Text("• $pt", fontSize = 9.5.sp, color = Color(0xFFDDD6FE), modifier = Modifier.padding(start = 6.dp, top = 1.dp))
              }
              Spacer(modifier = Modifier.height(6.dp))
            }
          }
        }
      }
    }
  }
}

fun LazyListScope.artLessonsSection(
  lessons: List<ArtLessonNote>,
  expandedId: String?,
  onToggleExpand: (String) -> Unit
) {
  items(lessons, key = { "lesson_${it.id}" }) { lesson ->
    val isExpanded = expandedId == lesson.id
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1528)),
      border = BorderStroke(1.dp, Color(0xFF4F46E5)),
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
      Column(modifier = Modifier.padding(10.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Column(modifier = Modifier.weight(1f)) {
            Text("${lesson.grade} ශ්‍රේණිය - ඒකකය ${lesson.unitNumber}: ${lesson.unitTitle}", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
          }
          IconButton(onClick = { onToggleExpand(lesson.id) }, modifier = Modifier.size(24.dp)) {
            Icon(if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore, contentDescription = null, tint = Color(0xFF818CF8))
          }
        }

        Text(lesson.summaryText, fontSize = 10.sp, color = Color(0xFFE0E7FF), lineHeight = 14.sp)

        AnimatedVisibility(visible = isExpanded) {
          Column(modifier = Modifier.padding(top = 6.dp)) {
            HorizontalDivider(color = Color(0xFF312E81))
            Spacer(modifier = Modifier.height(4.dp))

            Text("📌 ප්‍රධාන සංකල්ප:", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE047))
            lesson.coreConcepts.forEach { conc ->
              Text("• $conc", fontSize = 9.5.sp, color = Color(0xFFC7D2FE), modifier = Modifier.padding(start = 4.dp, top = 1.dp))
            }

            Spacer(modifier = Modifier.height(4.dp))
            Text("🎯 විභාග ඉලක්කගත කරුණු:", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF34D399))
            lesson.examFocusPoints.forEach { pt ->
              Text("• $pt", fontSize = 9.sp, color = Color(0xFFA7F3D0), modifier = Modifier.padding(start = 4.dp, top = 1.dp))
            }
          }
        }
      }
    }
  }
}
