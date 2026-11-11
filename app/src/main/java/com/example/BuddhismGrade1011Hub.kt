package com.example

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
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

/**
 * 🌟 100% ACCURATE GRADE 10 & 11 BUDDHISM MASTER HUB
 * Strictly adheres to the Sri Lankan G.C.E. O/L Buddhism Syllabus.
 * Designed with the exact same architecture as Sinhala & History Master Hubs:
 * - Compact, low-height collapsible sub-sections (no text squishing or wrapping bugs)
 * - Full-screen dialog with BackHandler & system bars
 * - 2-Column Quick Overview Grid
 * - Inline module content preview with instant search
 * - Grade 10 & 11 toggles
 * - 20 Categories x 20 Facts (400 Facts Bank) + Special Syllabus Modules
 */
@Composable
fun BuddhismGrade10And11MasterHub(
  currentGrade: String = "10",
  modifier: Modifier = Modifier
) {
  var activeGrade by remember { mutableStateOf(if (currentGrade.contains("11")) "11" else "10") }
  var selectedCategoryIndex by remember { mutableIntStateOf(-1) }
  var showFullScreenModal by remember { mutableStateOf(false) }

  val categories = remember { SubjectMasterBuddhism20x20.getCategories() }

  // Main Card Container with rich gradients to match Master Hub standard
  Card(
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1B4B)), // Deep Indigo / Warm Saffron tone
    border = BorderStroke(1.2.dp, Color(0xFFF59E0B).copy(alpha = 0.6f)), // Amber / Saffron
    modifier = modifier
      .fillMaxWidth()
      .testTag("buddhism_grade_10_11_master_hub")
  ) {
    Column(modifier = Modifier.padding(12.dp)) {
      // Header Row
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Box(
            modifier = Modifier
              .size(32.dp)
              .clip(CircleShape)
              .background(Brush.linearGradient(listOf(Color(0xFFF59E0B), Color(0xFFD97706)))),
            contentAlignment = Alignment.Center
          ) {
            Text("☸️", fontSize = 16.sp)
          }
          Spacer(modifier = Modifier.width(8.dp))
          Column {
            Text(
              text = "බුද්ධ ධර්මය විෂය නිර්දේශ Master Hub",
              color = Color.White,
              fontSize = 13.sp,
              fontWeight = FontWeight.Bold
            )
            Text(
              text = "සූත්‍ර • ශාසන ඉතිහාසය • සිව්සස් • කරුණු 400",
              color = Color(0xFFFED7AA),
              fontSize = 9.5.sp
            )
          }
        }

        Surface(
          color = Color(0xFFF59E0B),
          shape = RoundedCornerShape(6.dp)
        ) {
          Text(
            text = "100% ආවරණය",
            color = Color.Black,
            fontSize = 8.5.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      // Grade Toggle Pills: 10 ශ්‍රේණිය vs 11 ශ්‍රේණිය
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .clip(RoundedCornerShape(10.dp))
          .background(Color(0xFF0F172A))
          .padding(3.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
      ) {
        listOf("10", "11").forEach { g ->
          val isSelected = activeGrade == g
          Surface(
            onClick = { activeGrade = g },
            shape = RoundedCornerShape(8.dp),
            color = if (isSelected) Color(0xFFF59E0B) else Color.Transparent,
            modifier = Modifier.weight(1f)
          ) {
            Row(
              modifier = Modifier.padding(vertical = 5.dp),
              horizontalArrangement = Arrangement.Center,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = if (g == "10") "📘 10 ශ්‍රේණිය" else "📙 11 ශ්‍රේණිය",
                fontSize = 11.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = if (isSelected) Color.Black else Color(0xFF94A3B8)
              )
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      // Module Selector Strip (Compact Horizontal Grid)
      LazyRow(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.fillMaxWidth()
      ) {
        itemsIndexed(categories) { index, cat ->
          val isSelected = selectedCategoryIndex == index
          Surface(
            onClick = {
              selectedCategoryIndex = if (isSelected) -1 else index
            },
            shape = RoundedCornerShape(8.dp),
            color = if (isSelected) cat.color else Color(0xFF1E293B),
            border = BorderStroke(1.dp, if (isSelected) Color.White else cat.color.copy(alpha = 0.4f))
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(cat.icon, fontSize = 11.sp)
              Spacer(modifier = Modifier.width(4.dp))
              Text(
                text = cat.titleSinhala,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.widthIn(max = 130.dp)
              )
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      // Content Display Area depending on Selected Module
      if (selectedCategoryIndex == -1) {
        BuddhismQuickOverviewGrid(
          categories = categories,
          onSelectModule = { selectedCategoryIndex = it }
        )
      } else {
        BuddhismInlineModuleContent(
          activeGrade = activeGrade,
          categories = categories,
          selectedCategoryIndex = selectedCategoryIndex,
          onClose = { selectedCategoryIndex = -1 },
          onOpenFullscreen = { showFullScreenModal = true }
        )
      }
    }
  }

  // Full Screen Modal Dialog for deep study
  if (showFullScreenModal) {
    BuddhismGrade10And11MasterHubDialog(
      initialGrade = activeGrade,
      initialCategoryIndex = selectedCategoryIndex,
      categories = categories,
      onDismiss = { showFullScreenModal = false }
    )
  }
}

@Composable
fun BuddhismInlineModuleContent(
  activeGrade: String,
  categories: List<SubjectMasterCategory>,
  selectedCategoryIndex: Int,
  onClose: () -> Unit,
  onOpenFullscreen: () -> Unit
) {
  var searchQuery by remember { mutableStateOf("") }
  val category = categories[selectedCategoryIndex]

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF0F172A))
      .padding(8.dp)
  ) {
    // Header & Control Row
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f, fill = false)) {
        Text(category.icon, fontSize = 14.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = category.titleSinhala,
          fontSize = 11.5.sp,
          fontWeight = FontWeight.Bold,
          color = category.color,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )
      }

      Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        IconButton(
          onClick = onOpenFullscreen,
          modifier = Modifier.size(26.dp)
        ) {
          Icon(Icons.Default.Fullscreen, contentDescription = "Fullscreen", tint = category.color, modifier = Modifier.size(18.dp))
        }
        IconButton(
          onClick = onClose,
          modifier = Modifier.size(26.dp)
        ) {
          Icon(Icons.Default.Close, contentDescription = "Close", tint = Color(0xFF94A3B8), modifier = Modifier.size(18.dp))
        }
      }
    }

    // Search bar
    OutlinedTextField(
      value = searchQuery,
      onValueChange = { searchQuery = it },
      placeholder = { Text("කරුණු අතර සොයන්න...", fontSize = 9.5.sp, color = Color(0xFF94A3B8)) },
      singleLine = true,
      modifier = Modifier
        .fillMaxWidth()
        .height(44.dp)
        .padding(vertical = 2.dp),
      colors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = Color.White,
        unfocusedTextColor = Color.White,
        focusedBorderColor = category.color,
        unfocusedBorderColor = Color(0xFF334155),
        focusedContainerColor = Color(0xFF1E293B),
        unfocusedContainerColor = Color(0xFF1E293B)
      ),
      trailingIcon = {
        if (searchQuery.isNotEmpty()) {
          IconButton(onClick = { searchQuery = "" }) {
            Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color.LightGray, modifier = Modifier.size(14.dp))
          }
        }
      }
    )

    Spacer(modifier = Modifier.height(6.dp))

    // Sub-section List (showing 3 compact items in inline view)
    Column(
      modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      val items = category.points.filter {
        searchQuery.isBlank() || it.title.contains(searchQuery, true) || it.detail.contains(searchQuery, true)
      }.take(3)

      if (items.isEmpty()) {
        Text("ගැළපෙන කරුණු හමු නොවීය.", color = Color(0xFF94A3B8), fontSize = 10.sp)
      } else {
        items.forEach { point ->
          BuddhismFactCompactCard(point, category.color)
        }
      }

      Button(
        onClick = onOpenFullscreen,
        colors = ButtonDefaults.buttonColors(containerColor = category.color),
        modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
        shape = RoundedCornerShape(8.dp)
      ) {
        Text("සියලු කරුණු 20 බලන්න (View All)", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color.White)
      }
    }
  }
}

@Composable
fun BuddhismFactCompactCard(point: SubjectFactPoint, themeColor: Color) {
  Surface(
    shape = RoundedCornerShape(8.dp),
    color = Color(0xFF1E293B),
    border = BorderStroke(0.8.dp, Color(0xFF334155)),
    modifier = Modifier.fillMaxWidth()
  ) {
    Row(
      modifier = Modifier.padding(8.dp),
      verticalAlignment = Alignment.Top
    ) {
      Box(
        modifier = Modifier
          .size(20.dp)
          .background(themeColor.copy(alpha = 0.2f), CircleShape),
        contentAlignment = Alignment.Center
      ) {
        Text(text = "${point.number}", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = themeColor)
      }
      Spacer(modifier = Modifier.width(8.dp))
      Column {
        Text(text = point.title, color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
        Text(text = point.detail, color = Color(0xFF94A3B8), fontSize = 9.5.sp, maxLines = 2, overflow = TextOverflow.Ellipsis)
      }
    }
  }
}

/**
 * 🌟 FULL SCREEN DEDICATED DIALOG FOR BUDDHISM 10 & 11 SYLLABUS MASTER HUB
 * Strictly mirrors Sinhala & History Grade10And11MasterHubDialog layout and aesthetics.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuddhismGrade10And11MasterHubDialog(
  initialGrade: String,
  initialCategoryIndex: Int = -1,
  initialModuleIndex: Int = 0,
  categories: List<SubjectMasterCategory>,
  onDismiss: () -> Unit
) {
  var activeGrade by remember { mutableStateOf(initialGrade) }
  var selectedCategoryIndex by remember { mutableIntStateOf(initialCategoryIndex) }
  var hubMode by remember { mutableIntStateOf(if (initialCategoryIndex != -1) 0 else 1) } // 0 = 20 Categories (Fact Bank), 1 = Specialized Modules
  var selectedModuleTab by remember { mutableIntStateOf(initialModuleIndex) }
  var searchQuery by remember { mutableStateOf("") }
  var isSearchExpanded by remember { mutableStateOf(false) }

  BackHandler {
    if (selectedCategoryIndex != -1) {
      selectedCategoryIndex = -1
    } else {
      onDismiss()
    }
  }

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(
      usePlatformDefaultWidth = false,
      decorFitsSystemWindows = false,
      securePolicy = AppSecurityManager.getSecureFlagPolicy()
    )
  ) {
    Surface(
      modifier = Modifier
        .fillMaxSize()
        .systemBarsPadding()
        .testTag("buddhism_10_11_fullscreen_dialog"),
      color = Color(0xFF0F172A) // Deep background
    ) {
      Column(modifier = Modifier.fillMaxSize()) {
        // ULTRA-COMPACT TOP APP BAR (Single slim row, ~44dp height)
        Surface(
          color = Color(0xFF1E1B4B),
          tonalElevation = 2.dp,
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .statusBarsPadding()
              .padding(horizontal = 8.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              modifier = Modifier.weight(1f)
            ) {
              IconButton(
                onClick = {
                  if (selectedCategoryIndex != -1) selectedCategoryIndex = -1 else onDismiss()
                },
                modifier = Modifier.size(36.dp)
              ) {
                Icon(
                  imageVector = if (selectedCategoryIndex == -1) Icons.Default.Close else Icons.AutoMirrored.Filled.ArrowBack,
                  contentDescription = "Back",
                  tint = Color.White
                )
              }
              Spacer(modifier = Modifier.width(4.dp))
              Text(
                text = if (selectedCategoryIndex == -1) "බුද්ධ ධර්මය විෂය නිර්දේශ Hub" else categories[selectedCategoryIndex].titleSinhala,
                color = Color.White,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
              )
            }

            // Quick Grade Switcher Pill in Top Bar
            Surface(
              onClick = { activeGrade = if (activeGrade == "10") "11" else "10" },
              shape = RoundedCornerShape(12.dp),
              color = Color(0xFFF59E0B),
              modifier = Modifier.padding(horizontal = 4.dp)
            ) {
              Text(
                text = if (activeGrade == "10") "📘 10 වසර" else "📙 11 වසර",
                color = Color.Black,
                fontSize = 10.5.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.5.dp)
              )
            }

            IconButton(
              onClick = { isSearchExpanded = !isSearchExpanded },
              modifier = Modifier.size(36.dp)
            ) {
              Icon(
                imageVector = if (isSearchExpanded) Icons.Default.Close else Icons.Default.Search,
                contentDescription = "Search",
                tint = Color(0xFFFDE68A)
              )
            }
          }
        }

        // Expandable Slim Search Bar
        AnimatedVisibility(visible = isSearchExpanded) {
          Surface(
            color = Color(0xFF1E1B4B),
            modifier = Modifier.fillMaxWidth()
          ) {
            OutlinedTextField(
              value = searchQuery,
              onValueChange = { searchQuery = it },
              placeholder = { Text("සූත්‍ර, ශාසන ඉතිහාසය, සිව්සස් හෝ ගාථා සොයන්න...", fontSize = 11.sp, color = Color(0xFF94A3B8)) },
              leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color(0xFFFDE68A), modifier = Modifier.size(18.dp)) },
              trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                  IconButton(onClick = { searchQuery = "" }) {
                    Icon(Icons.Default.Clear, contentDescription = "Clear", tint = Color.White, modifier = Modifier.size(16.dp))
                  }
                }
              },
              singleLine = true,
              colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedBorderColor = Color(0xFFF59E0B),
                unfocusedBorderColor = Color(0xFF334155),
                focusedContainerColor = Color(0xFF0F172A),
                unfocusedContainerColor = Color(0xFF0F172A)
              ),
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 4.dp)
                .height(48.dp)
            )
          }
        }

        // CONTENT SECTION - FULL HEIGHT SCROLLABLE
        Box(modifier = Modifier.fillMaxSize()) {
          if (selectedCategoryIndex != -1) {
            // Category Detail View: Full-screen scrollable 20 facts
            SubjectMaster20CategoriesDetailView(
              subjectName = "බුද්ධ ධර්මය",
              categories = categories,
              selectedCategoryNumber = categories[selectedCategoryIndex].categoryNumber,
              onSelectCategory = { num ->
                if (num == 0) selectedCategoryIndex = -1
                else {
                  val newIdx = categories.indexOfFirst { it.categoryNumber == num }
                  if (newIdx != -1) selectedCategoryIndex = newIdx
                }
              },
              modifier = Modifier.fillMaxSize()
            )
          } else {
            // Overview Mode: Entire screen scrolls together (Mode Selector + Content)
            LazyColumn(
              modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
              contentPadding = PaddingValues(top = 8.dp, bottom = 28.dp),
              verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              // Scrollable Mode Selector (400 Facts vs Advanced Modules)
              item(key = "mode_selector") {
                Row(
                  modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF0F172A))
                    .padding(2.dp),
                  horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                  Surface(
                    onClick = { hubMode = 0 },
                    shape = RoundedCornerShape(6.dp),
                    color = if (hubMode == 0) Color(0xFFF59E0B) else Color.Transparent,
                    modifier = Modifier.weight(1f)
                  ) {
                    Text(
                      text = "📚 කරුණු 400 බැංකුව (කාණ්ඩ 20)",
                      fontSize = 10.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = if (hubMode == 0) Color.Black else Color(0xFFCBD5E1),
                      textAlign = TextAlign.Center,
                      modifier = Modifier.padding(vertical = 6.dp)
                    )
                  }
                  Surface(
                    onClick = { hubMode = 1 },
                    shape = RoundedCornerShape(6.dp),
                    color = if (hubMode == 1) Color(0xFF4F46E5) else Color.Transparent,
                    modifier = Modifier.weight(1f)
                  ) {
                    Text(
                      text = "☸️ විෂය ඒකක (Advanced Modules)",
                      fontSize = 10.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = if (hubMode == 1) Color.White else Color(0xFFCBD5E1),
                      textAlign = TextAlign.Center,
                      modifier = Modifier.padding(vertical = 6.dp)
                    )
                  }
                }
              }

              if (hubMode == 0) {
                item(key = "overview_grid") {
                  BuddhismQuickOverviewGrid(
                    categories = categories,
                    onSelectModule = { selectedCategoryIndex = it }
                  )
                }
              } else {
                // Specialized Module Tabs
                item(key = "module_tabs") {
                  ScrollableTabRow(
                    selectedTabIndex = selectedModuleTab,
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFFFDE68A),
                    edgePadding = 0.dp,
                    indicator = { tabPositions ->
                      TabRowDefaults.SecondaryIndicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[selectedModuleTab]),
                        color = Color(0xFFF59E0B),
                        height = 2.5.dp
                      )
                    },
                    divider = { HorizontalDivider(color = Color(0xFF334155), thickness = 0.6.dp) }
                  ) {
                    val sections = BuddhismSectionType.values()
                    sections.forEachIndexed { index, section ->
                      Tab(
                        selected = selectedModuleTab == index,
                        onClick = { selectedModuleTab = index },
                        text = {
                          Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(section.icon, fontSize = 11.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                              text = section.titleSinhala,
                              fontSize = 10.5.sp,
                              fontWeight = if (selectedModuleTab == index) FontWeight.Bold else FontWeight.Normal,
                              color = if (selectedModuleTab == index) Color(0xFFFDE68A) else Color(0xFF94A3B8)
                            )
                          }
                        }
                      )
                    }
                  }
                }

                val currentSection = BuddhismSectionType.values()[selectedModuleTab]
              when (currentSection) {
                BuddhismSectionType.SUTTA_ANALYSIS -> {
                  val items = BuddhismMasterRepository.suttasList.filter {
                    it.grade.contains(activeGrade) && (searchQuery.isBlank() || it.title.contains(searchQuery, true) || it.suttaNamePali.contains(searchQuery, true) || it.locationAndAudience.contains(searchQuery, true))
                  }
                  if (items.isEmpty()) {
                    item { BuddhismEmptySearchResultNotice() }
                  } else {
                    items(items, key = { it.id }) { sutta ->
                      BuddhismSuttaCard(sutta)
                    }
                  }
                }

                BuddhismSectionType.SASANA_HISTORY -> {
                  val items = BuddhismMasterRepository.sasanaHistoryList.filter {
                    it.grade.contains(activeGrade) && (searchQuery.isBlank() || it.title.contains(searchQuery, true) || it.primaryLeadership.contains(searchQuery, true))
                  }
                  if (items.isEmpty()) {
                    item { BuddhismEmptySearchResultNotice() }
                  } else {
                    items(items, key = { it.id }) { event ->
                      BuddhismSasanaCard(event)
                    }
                  }
                }

                BuddhismSectionType.PHILOSOPHY -> {
                  val items = BuddhismMasterRepository.philosophyList.filter {
                    it.grade.contains(activeGrade) && (searchQuery.isBlank() || it.title.contains(searchQuery, true) || it.paliConcept.contains(searchQuery, true))
                  }
                  if (items.isEmpty()) {
                    item { BuddhismEmptySearchResultNotice() }
                  } else {
                    items(items, key = { it.id }) { phil ->
                      BuddhismPhilosophyCard(phil)
                    }
                  }
                }

                BuddhismSectionType.DISCIPLES -> {
                  val items = BuddhismMasterRepository.disciplesList.filter {
                    it.grade.contains(activeGrade) && (searchQuery.isBlank() || it.title.contains(searchQuery, true) || it.discipleName.contains(searchQuery, true))
                  }
                  if (items.isEmpty()) {
                    item { BuddhismEmptySearchResultNotice() }
                  } else {
                    items(items, key = { it.id }) { disciple ->
                      BuddhismDiscipleCard(disciple)
                    }
                  }
                }

                BuddhismSectionType.GATHAS -> {
                  val items = BuddhismMasterRepository.gathasList.filter {
                    it.grade.contains(activeGrade) && (searchQuery.isBlank() || it.gathaTitle.contains(searchQuery, true) || it.paliGathaText.contains(searchQuery, true))
                  }
                  if (items.isEmpty()) {
                    item { BuddhismEmptySearchResultNotice() }
                  } else {
                    items(items, key = { it.id }) { gatha ->
                      BuddhismGathaCard(gatha)
                    }
                  }
                }

                BuddhismSectionType.CULTURE_RITUALS -> {
                  val items = BuddhismMasterRepository.cultureList.filter {
                    it.grade.contains(activeGrade) && (searchQuery.isBlank() || it.title.contains(searchQuery, true) || it.category.contains(searchQuery, true))
                  }
                  if (items.isEmpty()) {
                    item { BuddhismEmptySearchResultNotice() }
                  } else {
                    items(items, key = { it.id }) { cult ->
                      BuddhismCultureCard(cult)
                    }
                  }
                }

                BuddhismSectionType.RAPID_MCQS -> {
                  val items = BuddhismMasterRepository.rapidMcqList.filter {
                    it.grade.contains(activeGrade) && (searchQuery.isBlank() || it.question.contains(searchQuery, true))
                  }
                  if (items.isEmpty()) {
                    item { BuddhismEmptySearchResultNotice() }
                  } else {
                    items(items, key = { it.id }) { mcq ->
                      BuddhismRapidMcqCard(mcq)
                    }
                  }
                }

                BuddhismSectionType.EXAM_SECRETS -> {
                  val items = BuddhismMasterRepository.examSecretsList.filter {
                    searchQuery.isBlank() || it.first.contains(searchQuery, true) || it.second.contains(searchQuery, true)
                  }
                  if (items.isEmpty()) {
                    item { BuddhismEmptySearchResultNotice() }
                  } else {
                    items(items, key = { it.first }) { secret ->
                      BuddhismExamSecretCard(secret.first, secret.second)
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}
}

/**
 * Backward compatibility wrapper for BuddhismFullScreenModal
 */
@Composable
fun BuddhismFullScreenModal(
  initialGrade: String,
  initialTab: Int = 0,
  onDismiss: () -> Unit
) {
  BuddhismGrade10And11MasterHubDialog(
    initialGrade = initialGrade,
    initialCategoryIndex = -1,
    initialModuleIndex = initialTab,
    categories = SubjectMasterBuddhism20x20.getCategories(),
    onDismiss = onDismiss
  )
}

@Composable
fun BuddhismQuickOverviewGrid(
  categories: List<SubjectMasterCategory>,
  onSelectModule: (Int) -> Unit
) {
  Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
    // 2-column layout to match Master Hub standard
    for (i in categories.indices step 2) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        BuddhismFeatureButton(
          category = categories[i],
          modifier = Modifier.weight(1f),
          onClick = { onSelectModule(i) }
        )
        if (i + 1 < categories.size) {
          BuddhismFeatureButton(
            category = categories[i + 1],
            modifier = Modifier.weight(1f),
            onClick = { onSelectModule(i + 1) }
          )
        } else {
          BuddhismFeatureButton(
            category = null,
            customTitle = "AI උපදේශක",
            customIcon = "🤖",
            customSubtitle = "බුද්ධ ධර්මය AI සහාය",
            customColor = Color(0xFFDB2777),
            modifier = Modifier.weight(1f),
            onClick = { }
          )
        }
      }
    }
  }
}

@Composable
fun BuddhismFeatureButton(
  category: SubjectMasterCategory?,
  customTitle: String = "",
  customIcon: String = "",
  customSubtitle: String = "",
  customColor: Color = Color.Gray,
  modifier: Modifier = Modifier,
  onClick: () -> Unit
) {
  val title = category?.titleSinhala ?: customTitle
  val icon = category?.icon ?: customIcon
  val color = category?.color ?: customColor
  val subtitle = category?.summary ?: customSubtitle

  Surface(
    onClick = onClick,
    shape = RoundedCornerShape(8.dp),
    color = color.copy(alpha = 0.25f),
    border = BorderStroke(1.dp, color.copy(alpha = 0.6f)),
    modifier = modifier
  ) {
    Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text(icon, fontSize = 12.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = title,
          fontSize = 10.5.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )
      }
      Text(
        text = subtitle,
        fontSize = 8.5.sp,
        color = Color(0xFFFED7AA),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
      )
    }
  }
}

// -------------------------------------------------------------
// COMPACT COLLAPSIBLE CARD COMPONENTS (SINHALA/HISTORY DESIGN SYSTEM)
// Minimal default height (~40dp), non-squishable category pills,
// smooth expand/collapse animations, and clean bullet structures.
// -------------------------------------------------------------

@Composable
fun BuddhismSuttaCard(item: BuddhismSuttaItem) {
  var expanded by remember { mutableStateOf(false) }

  Card(
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
    border = BorderStroke(1.dp, Color(0xFFF59E0B).copy(alpha = 0.4f)),
    modifier = Modifier
      .fillMaxWidth()
      .animateContentSize(animationSpec = tween(200))
  ) {
    Column(modifier = Modifier.padding(10.dp)) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .clickable { expanded = !expanded },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier.weight(1f, fill = false)
        ) {
          Surface(
            color = Color(0xFFF59E0B).copy(alpha = 0.25f),
            shape = RoundedCornerShape(6.dp)
          ) {
            Text(
              text = "ශ්‍රේණිය ${item.grade}",
              color = Color(0xFFFDE68A),
              fontSize = 9.5.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = item.title,
            color = Color.White,
            fontSize = 12.5.sp,
            fontWeight = FontWeight.Bold,
            maxLines = if (expanded) Int.MAX_VALUE else 1,
            overflow = TextOverflow.Ellipsis
          )
        }

        IconButton(
          onClick = { expanded = !expanded },
          modifier = Modifier.size(28.dp)
        ) {
          Icon(
            imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
            contentDescription = "Toggle",
            tint = Color(0xFF94A3B8),
            modifier = Modifier.size(18.dp)
          )
        }
      }

      if (!expanded) {
        Text(
          text = item.suttaNamePali,
          color = Color(0xFF94A3B8),
          fontSize = 11.sp,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier.padding(top = 2.dp)
        )
      } else {
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(color = Color(0xFF334155), thickness = 0.8.dp)
        Spacer(modifier = Modifier.height(8.dp))

        Surface(
          color = Color(0xFF0F172A),
          shape = RoundedCornerShape(8.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(8.dp)) {
            Text(text = "📜 ${item.suttaNamePali}", color = Color(0xFFFDE68A), fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
            Text(text = "දේශනා කළ ස්ථානය හා පිරිස: ${item.locationAndAudience}", color = Color(0xFFCBD5E1), fontSize = 10.5.sp)
          }
        }

        Spacer(modifier = Modifier.height(6.dp))
        Text("☸️ මූලික ඉගැන්වීම්:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
        item.coreTeachings.forEach { t ->
          Row(modifier = Modifier.padding(vertical = 1.5.dp)) {
            Text("•", color = Color(0xFF38BDF8), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(6.dp))
            Text(t, fontSize = 11.sp, color = Color(0xFFE2E8F0), lineHeight = 16.sp)
          }
        }

        item.subDivisions.forEach { (subTitle, points) ->
          Spacer(modifier = Modifier.height(6.dp))
          Text(subTitle, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFBBF24))
          points.forEach { p ->
            Text("  - $p", fontSize = 10.5.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)
          }
        }

        Spacer(modifier = Modifier.height(6.dp))
        Surface(
          color = Color(0xFF451A03),
          shape = RoundedCornerShape(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier.padding(6.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text("💡 O/L Tip: ", color = Color(0xFFFDE047), fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
            Text(item.examSummaryPoints.joinToString(" • "), color = Color(0xFFFEF08A), fontSize = 10.5.sp)
          }
        }
      }
    }
  }
}

@Composable
fun BuddhismSasanaCard(item: BuddhismSasanaEventItem) {
  var expanded by remember { mutableStateOf(false) }

  Card(
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
    border = BorderStroke(1.dp, Color(0xFF2563EB).copy(alpha = 0.4f)),
    modifier = Modifier
      .fillMaxWidth()
      .animateContentSize(animationSpec = tween(200))
  ) {
    Column(modifier = Modifier.padding(10.dp)) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .clickable { expanded = !expanded },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier.weight(1f, fill = false)
        ) {
          Surface(
            color = Color(0xFF2563EB).copy(alpha = 0.25f),
            shape = RoundedCornerShape(6.dp)
          ) {
            Text(
              text = "ශ්‍රේණිය ${item.grade}",
              color = Color(0xFF93C5FD),
              fontSize = 9.5.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = item.title,
            color = Color.White,
            fontSize = 12.5.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
        }

        IconButton(
          onClick = { expanded = !expanded },
          modifier = Modifier.size(28.dp)
        ) {
          Icon(
            imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
            contentDescription = "Toggle",
            tint = Color(0xFF94A3B8),
            modifier = Modifier.size(18.dp)
          )
        }
      }

      if (!expanded) {
        Text(
          text = item.eraAndRuler,
          color = Color(0xFF94A3B8),
          fontSize = 11.sp,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier.padding(top = 2.dp)
        )
      } else {
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(color = Color(0xFF334155), thickness = 0.8.dp)
        Spacer(modifier = Modifier.height(8.dp))

        Text("යුගය / අනුග්‍රාහකයා: ${item.eraAndRuler}", fontSize = 11.sp, color = Color(0xFF93C5FD), fontWeight = FontWeight.Bold)
        Text("ප්‍රධාන මඟපෙන්වීම: ${item.primaryLeadership}", fontSize = 10.5.sp, color = Color(0xFFCBD5E1))

        Spacer(modifier = Modifier.height(6.dp))
        Text("🏛️ සංගායනාවට හෝ සිදුවීමට හේතු:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFCA5A5))
        item.historicalCauses.forEach { c ->
          Text(" • $c", fontSize = 10.5.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)
        }

        Spacer(modifier = Modifier.height(6.dp))
        Text("✅ ප්‍රධාන ප්‍රතිඵල හා බලපෑම:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF86EFAC))
        item.keyOutcomesAndImpact.forEach { o ->
          Text(" • $o", fontSize = 10.5.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)
        }
      }
    }
  }
}

@Composable
fun BuddhismPhilosophyCard(item: BuddhismPhilosophyItem) {
  var expanded by remember { mutableStateOf(false) }

  Card(
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
    border = BorderStroke(1.dp, Color(0xFF0D9488).copy(alpha = 0.4f)),
    modifier = Modifier
      .fillMaxWidth()
      .animateContentSize(animationSpec = tween(200))
  ) {
    Column(modifier = Modifier.padding(10.dp)) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .clickable { expanded = !expanded },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier.weight(1f, fill = false)
        ) {
          Surface(
            color = Color(0xFF0D9488).copy(alpha = 0.25f),
            shape = RoundedCornerShape(6.dp)
          ) {
            Text(
              text = item.paliConcept,
              color = Color(0xFF5EEAD4),
              fontSize = 9.5.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = item.title,
            color = Color.White,
            fontSize = 12.5.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
        }

        IconButton(
          onClick = { expanded = !expanded },
          modifier = Modifier.size(28.dp)
        ) {
          Icon(
            imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
            contentDescription = "Toggle",
            tint = Color(0xFF94A3B8),
            modifier = Modifier.size(18.dp)
          )
        }
      }

      if (!expanded) {
        Text(
          text = item.coreDefinition,
          color = Color(0xFF94A3B8),
          fontSize = 11.sp,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier.padding(top = 2.dp)
        )
      } else {
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(color = Color(0xFF334155), thickness = 0.8.dp)
        Spacer(modifier = Modifier.height(8.dp))

        Text("මූලික අර්ථ දැක්වීම:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2DD4BF))
        Text(item.coreDefinition, fontSize = 11.sp, color = Color(0xFFE2E8F0), lineHeight = 16.sp)

        Spacer(modifier = Modifier.height(6.dp))
        item.analyticalBreakdown.forEach { (comp, desc) ->
          Text("• $comp: $desc", fontSize = 10.5.sp, color = Color(0xFFCBD5E1), lineHeight = 15.sp)
        }

        Spacer(modifier = Modifier.height(6.dp))
        Surface(
          color = Color(0xFF042F2E),
          shape = RoundedCornerShape(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Text(
            text = "ප්‍රායෝගික ඇඟවීම: ${item.practicalApplication}",
            fontSize = 10.5.sp,
            color = Color(0xFF99F6E4),
            modifier = Modifier.padding(6.dp)
          )
        }
      }
    }
  }
}

@Composable
fun BuddhismDiscipleCard(item: BuddhismDiscipleItem) {
  var expanded by remember { mutableStateOf(false) }

  Card(
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
    border = BorderStroke(1.dp, Color(0xFF7C3AED).copy(alpha = 0.4f)),
    modifier = Modifier
      .fillMaxWidth()
      .animateContentSize(animationSpec = tween(200))
  ) {
    Column(modifier = Modifier.padding(10.dp)) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .clickable { expanded = !expanded },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier.weight(1f, fill = false)
        ) {
          Surface(
            color = Color(0xFF7C3AED).copy(alpha = 0.25f),
            shape = RoundedCornerShape(6.dp)
          ) {
            Text(
              text = item.supremeTitle,
              color = Color(0xFFC4B5FD),
              fontSize = 9.5.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = item.discipleName,
            color = Color.White,
            fontSize = 12.5.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
        }

        IconButton(
          onClick = { expanded = !expanded },
          modifier = Modifier.size(28.dp)
        ) {
          Icon(
            imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
            contentDescription = "Toggle",
            tint = Color(0xFFC4B5FD),
            modifier = Modifier.size(18.dp)
          )
        }
      }

      if (!expanded) {
        Text(
          text = item.title,
          color = Color(0xFF94A3B8),
          fontSize = 11.sp,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier.padding(top = 2.dp)
        )
      } else {
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(color = Color(0xFF334155), thickness = 0.8.dp)
        Spacer(modifier = Modifier.height(8.dp))

        Text("පසුබිම: ${item.lifeBackground}", fontSize = 11.sp, color = Color(0xFFCBD5E1), lineHeight = 16.sp)

        Spacer(modifier = Modifier.height(6.dp))
        Text("✨ ආදර්ශවත් ගුණාංග:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE68A))
        item.exemplaryQualities.forEach { q ->
          Text(" • $q", fontSize = 10.5.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)
        }

        Spacer(modifier = Modifier.height(6.dp))
        Text("🌟 මතකයේ රැඳෙන සිදුවීම්:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFA7F3D0))
        item.memorableIncidents.forEach { inc ->
          Text(" • $inc", fontSize = 10.5.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)
        }
      }
    }
  }
}

@Composable
fun BuddhismGathaCard(item: BuddhismGathaItem) {
  var expanded by remember { mutableStateOf(false) }

  Card(
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
    border = BorderStroke(1.dp, Color(0xFFDC2626).copy(alpha = 0.4f)),
    modifier = Modifier
      .fillMaxWidth()
      .animateContentSize(animationSpec = tween(200))
  ) {
    Column(modifier = Modifier.padding(10.dp)) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .clickable { expanded = !expanded },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier.weight(1f, fill = false)
        ) {
          Surface(
            color = Color(0xFFDC2626).copy(alpha = 0.25f),
            shape = RoundedCornerShape(6.dp)
          ) {
            Text(
              text = item.sourceText,
              color = Color(0xFFFCA5A5),
              fontSize = 9.5.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = item.gathaTitle,
            color = Color.White,
            fontSize = 12.5.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
        }

        IconButton(
          onClick = { expanded = !expanded },
          modifier = Modifier.size(28.dp)
        ) {
          Icon(
            imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
            contentDescription = "Toggle",
            tint = Color(0xFFFCA5A5),
            modifier = Modifier.size(18.dp)
          )
        }
      }

      if (!expanded) {
        Text(
          text = item.overallMeaningSinhala,
          color = Color(0xFF94A3B8),
          fontSize = 11.sp,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier.padding(top = 2.dp)
        )
      } else {
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(color = Color(0xFF334155), thickness = 0.8.dp)
        Spacer(modifier = Modifier.height(8.dp))

        Surface(
          color = Color(0xFF450A0A),
          shape = RoundedCornerShape(8.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Text(
            text = item.paliGathaText,
            color = Color(0xFFFEE2E2),
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 17.sp,
            modifier = Modifier.padding(8.dp)
          )
        }

        Spacer(modifier = Modifier.height(6.dp))
        Text("සිංහල අර්ථය:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF34D399))
        Text(item.overallMeaningSinhala, fontSize = 11.sp, color = Color(0xFFE2E8F0), lineHeight = 16.sp)

        Spacer(modifier = Modifier.height(6.dp))
        Text("💡 විභාග අවධානය: ${item.examFocus}", fontSize = 10.5.sp, color = Color(0xFFFDE68A))
      }
    }
  }
}

@Composable
fun BuddhismCultureCard(item: BuddhismCultureItem) {
  var expanded by remember { mutableStateOf(false) }

  Card(
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
    border = BorderStroke(1.dp, Color(0xFFEA580C).copy(alpha = 0.4f)),
    modifier = Modifier
      .fillMaxWidth()
      .animateContentSize(animationSpec = tween(200))
  ) {
    Column(modifier = Modifier.padding(10.dp)) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .clickable { expanded = !expanded },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier.weight(1f, fill = false)
        ) {
          Surface(
            color = Color(0xFFEA580C).copy(alpha = 0.25f),
            shape = RoundedCornerShape(6.dp)
          ) {
            Text(
              text = item.category,
              color = Color(0xFFFB923C),
              fontSize = 9.5.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = item.title,
            color = Color.White,
            fontSize = 12.5.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
        }

        IconButton(
          onClick = { expanded = !expanded },
          modifier = Modifier.size(28.dp)
        ) {
          Icon(
            imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
            contentDescription = "Toggle",
            tint = Color(0xFFFB923C),
            modifier = Modifier.size(18.dp)
          )
        }
      }

      if (!expanded) {
        Text(
          text = item.historicalOrigin,
          color = Color(0xFF94A3B8),
          fontSize = 11.sp,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier.padding(top = 2.dp)
        )
      } else {
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(color = Color(0xFF334155), thickness = 0.8.dp)
        Spacer(modifier = Modifier.height(8.dp))

        Text("ඓතිහාසික පසුබිම: ${item.historicalOrigin}", fontSize = 11.sp, color = Color(0xFFFED7AA), lineHeight = 15.sp)

        Spacer(modifier = Modifier.height(6.dp))
        Text("🌸 චාරිත්‍රානුකූල පියවර:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDBA74))
        item.ritualSteps.forEach { step ->
          Text(" • $step", fontSize = 10.5.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)
        }

        Spacer(modifier = Modifier.height(6.dp))
        Text("✨ ආධ්‍යාත්මික හා සමාජීය ආනිසංස:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF86EFAC))
        item.spiritualBenefits.forEach { ben ->
          Text(" • $ben", fontSize = 10.5.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)
        }
      }
    }
  }
}

@Composable
fun BuddhismRapidMcqCard(item: BuddhismRapidMcq) {
  var selectedIndex by remember { mutableStateOf<Int?>(null) }
  val isAnswered = selectedIndex != null

  Card(
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
    border = BorderStroke(1.dp, Color(0xFF4F46E5).copy(alpha = 0.4f)),
    modifier = Modifier.fillMaxWidth()
  ) {
    Column(modifier = Modifier.padding(10.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Surface(
          color = Color(0xFF4F46E5).copy(alpha = 0.25f),
          shape = RoundedCornerShape(6.dp)
        ) {
          Text(
            text = item.topic,
            color = Color(0xFFA5B4FC),
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
          )
        }
        if (isAnswered) {
          val isCorrect = selectedIndex == item.correctIndex
          Text(
            text = if (isCorrect) "✓ නිවැරදියි!" else "✗ වැරදියි",
            color = if (isCorrect) Color(0xFF4ADE80) else Color(0xFFF87171),
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold
          )
        }
      }

      Spacer(modifier = Modifier.height(6.dp))

      Text(
        text = item.question,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        lineHeight = 17.sp
      )

      Spacer(modifier = Modifier.height(8.dp))

      item.options.forEachIndexed { index, option ->
        val isChosen = selectedIndex == index
        val isCorrect = index == item.correctIndex
        val bgColor = when {
          !isAnswered -> Color(0xFF0F172A)
          isCorrect -> Color(0xFF065F46)
          isChosen -> Color(0xFF991B1B)
          else -> Color(0xFF0F172A)
        }
        val borderColor = when {
          !isAnswered -> Color(0xFF334155)
          isCorrect -> Color(0xFF10B981)
          isChosen -> Color(0xFFEF4444)
          else -> Color(0xFF334155)
        }

        Surface(
          color = bgColor,
          shape = RoundedCornerShape(6.dp),
          border = BorderStroke(0.8.dp, borderColor),
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.5.dp)
            .clickable(enabled = !isAnswered) {
              selectedIndex = index
            }
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "(${index + 1})",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = if (isChosen || isCorrect) Color.White else Color(0xFF94A3B8)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = option,
              fontSize = 11.sp,
              color = Color.White,
              modifier = Modifier.weight(1f)
            )
            if (isAnswered) {
              if (isCorrect) {
                Text("✓ නිවැරදියි", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF6EE7B7))
              } else if (isChosen) {
                Text("✗ වැරදියි", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFCA5A5))
              }
            }
          }
        }
      }

      if (isAnswered) {
        Spacer(modifier = Modifier.height(6.dp))
        Surface(
          color = Color(0xFF312E81),
          shape = RoundedCornerShape(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier.padding(6.dp),
            verticalAlignment = Alignment.Top
          ) {
            Text("💡", fontSize = 11.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = item.explanation,
              fontSize = 10.5.sp,
              color = Color(0xFFE0E7FF),
              lineHeight = 15.sp
            )
          }
        }
      }
    }
  }
}

@Composable
fun BuddhismExamSecretCard(title: String, details: String) {
  Card(
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
    border = BorderStroke(1.dp, Color(0xFFE11D48).copy(alpha = 0.4f)),
    modifier = Modifier.fillMaxWidth()
  ) {
    Column(modifier = Modifier.padding(10.dp)) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text("🎯", fontSize = 14.sp)
        Spacer(modifier = Modifier.width(6.dp))
        Text(
          text = title,
          color = Color(0xFFFDA4AF),
          fontSize = 12.sp,
          fontWeight = FontWeight.Bold
        )
      }
      Spacer(modifier = Modifier.height(4.dp))
      Text(
        text = details,
        color = Color(0xFFF1F5F9),
        fontSize = 11.sp,
        lineHeight = 16.sp
      )
    }
  }
}

@Composable
fun BuddhismEmptySearchResultNotice() {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 32.dp),
    contentAlignment = Alignment.Center
  ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      Text("🔍", fontSize = 28.sp)
      Spacer(modifier = Modifier.height(6.dp))
      Text(
        text = "සොයන ලද විෂය කොටස හමු නොවීය.\nකරුණාකර වෙනත් නමක් හෝ අංකයක් යොදන්න.",
        color = Color(0xFF94A3B8),
        fontSize = 12.sp,
        textAlign = TextAlign.Center
      )
    }
  }
}
