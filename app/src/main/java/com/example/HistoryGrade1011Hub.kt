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
 * 🌟 100% ACCURATE GRADE 10 & 11 HISTORY MASTER HUB
 * Strictly adheres to the Sri Lankan G.C.E. O/L History Syllabus.
 * Designed with the exact same architecture as Sinhala Master Hub:
 * - Compact, low-height collapsible sub-sections (no text squishing or wrapping bugs)
 * - Full-screen dialog with BackHandler & system bars
 * - 2-Column Quick Overview Grid
 * - Inline module content preview with instant search
 * - Grade 10 & 11 toggles
 * - 20 Categories x 20 Facts (400 Facts Bank) + Special Syllabus Modules
 */
@Composable
fun HistoryGrade10And11MasterHub(
  currentGrade: String = "10",
  modifier: Modifier = Modifier
) {
  var activeGrade by remember { mutableStateOf(if (currentGrade.contains("11")) "11" else "10") }
  var selectedCategoryIndex by remember { mutableIntStateOf(-1) }
  var showFullScreenModal by remember { mutableStateOf(false) }

  val categories = remember { SubjectMasterHistory20x20.getCategories() }
  val filteredCategories = remember(activeGrade) {
    if (activeGrade == "10") {
      categories.filter { it.categoryNumber <= 10 }
    } else {
      categories.filter { it.categoryNumber > 10 }
    }
  }

  LaunchedEffect(activeGrade) {
    selectedCategoryIndex = -1
  }

  // Main Card Container with rich gradients to match Master Hub standard
  Card(
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1B4B)), // Deep Indigo
    border = BorderStroke(1.2.dp, Color(0xFFD97706).copy(alpha = 0.6f)), // Amber / Gold
    modifier = modifier
      .fillMaxWidth()
      .testTag("history_grade_10_11_master_hub")
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
              .background(Brush.linearGradient(listOf(Color(0xFFD97706), Color(0xFFB45309)))),
            contentAlignment = Alignment.Center
          ) {
            Text("🏛️", fontSize = 16.sp)
          }
          Spacer(modifier = Modifier.width(8.dp))
          Column {
            Text(
              text = "ඉතිහාසය විෂය නිර්දේශ Master Hub",
              color = Color.White,
              fontSize = 13.sp,
              fontWeight = FontWeight.Bold
            )
            Text(
              text = "රාජධානි • වාරි ශිෂ්ටාචාරය • මූලාශ්‍ර • කරුණු 400",
              color = Color(0xFFFDE68A),
              fontSize = 9.5.sp
            )
          }
        }

        Surface(
          color = Color(0xFFD97706),
          shape = RoundedCornerShape(6.dp)
        ) {
          Text(
            text = "100% ආවරණය",
            color = Color.White,
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
            color = if (isSelected) Color(0xFFD97706) else Color.Transparent,
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
                color = if (isSelected) Color.White else Color(0xFF94A3B8)
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
        itemsIndexed(filteredCategories) { _, cat ->
          val originalIndex = categories.indexOf(cat)
          val isSelected = selectedCategoryIndex == originalIndex
          Surface(
            onClick = {
              selectedCategoryIndex = if (isSelected) -1 else originalIndex
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
        HistoryQuickOverviewGrid(
          categories = filteredCategories,
          onSelectModule = { cat -> 
            selectedCategoryIndex = categories.indexOf(cat)
          }
        )
      } else {
        HistoryInlineModuleContent(
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
    HistoryGrade10And11MasterHubDialog(
      initialGrade = activeGrade,
      initialCategoryIndex = selectedCategoryIndex,
      categories = categories,
      onDismiss = { showFullScreenModal = false }
    )
  }
}

@Composable
fun HistoryInlineModuleContent(
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
          HistoryFactCompactCard(point, category.color)
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
fun HistoryFactCompactCard(point: SubjectFactPoint, themeColor: Color) {
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
 * 🌟 FULL SCREEN DEDICATED DIALOG FOR HISTORY 10 & 11 SYLLABUS MASTER HUB
 * Strictly mirrors SinhalaGrade10And11MasterHubDialog layout and aesthetics.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryGrade10And11MasterHubDialog(
  initialGrade: String,
  initialCategoryIndex: Int = -1,
  initialModuleIndex: Int = 0,
  categories: List<SubjectMasterCategory>,
  onDismiss: () -> Unit
) {
  var activeGrade by remember { mutableStateOf(if (initialGrade.contains("11")) "11" else "10") }
  var selectedCategoryIndex by remember { mutableIntStateOf(initialCategoryIndex) }
  var hubMode by remember { mutableIntStateOf(if (initialCategoryIndex != -1) 0 else 1) } // 0 = 20 Categories (Fact Bank), 1 = Specialized Modules
  var selectedModuleTab by remember { mutableIntStateOf(initialModuleIndex.coerceIn(0, HistoryModuleType.values().size - 1)) }
  var searchQuery by remember { mutableStateOf("") }

  val allModules = remember { HistoryModuleType.values() }

  val filteredCategories = remember(activeGrade) {
    if (activeGrade == "10") {
      categories.filter { it.categoryNumber <= 10 }
    } else if (activeGrade == "11") {
      categories.filter { it.categoryNumber > 10 }
    } else {
      categories
    }
  }

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
        .testTag("history_10_11_fullscreen_dialog"),
      color = Color(0xFF0F172A)
    ) {
      Box(modifier = Modifier.fillMaxSize()) {
        if (selectedCategoryIndex != -1) {
          val catNum = categories.getOrNull(selectedCategoryIndex)?.categoryNumber ?: 1
          SubjectMaster20CategoriesDetailView(
            subjectName = "ඉතිහාසය",
            categories = categories,
            selectedCategoryNumber = catNum,
            onSelectCategory = { num ->
              if (num == 0) {
                selectedCategoryIndex = -1
              } else {
                val cat = categories.find { it.categoryNumber == num }
                if (cat != null) {
                  selectedCategoryIndex = categories.indexOf(cat)
                }
              }
            },
            modifier = Modifier.fillMaxSize()
          )
        } else {
          LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 60.dp)
          ) {
            // 1. TOP APP BAR
            item(key = "history_top_app_bar") {
              Box(
                modifier = Modifier
                  .fillMaxWidth()
                  .background(
                    Brush.verticalGradient(
                      colors = listOf(Color(0xFFD97706), Color(0xFFB45309))
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
                      onClick = {
                        if (selectedCategoryIndex != -1) selectedCategoryIndex = -1 else onDismiss()
                      },
                      modifier = Modifier
                        .size(36.dp)
                        .background(Color.White.copy(alpha = 0.2f), CircleShape)
                    ) {
                      Icon(
                        imageVector = if (selectedCategoryIndex == -1) Icons.Default.Close else Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                      )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                      Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                          text = if (selectedCategoryIndex == -1) "🏛️ 10 & 11 ඉතිහාසය Master Hub" else categories.getOrNull(selectedCategoryIndex)?.titleSinhala ?: "ඉතිහාසය",
                          color = Color.White,
                          fontSize = 15.sp,
                          fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Surface(
                          color = Color(0xFFFEF08A),
                          shape = RoundedCornerShape(4.dp)
                        ) {
                          Text(
                            text = "100% SYLLABUS",
                            color = Color(0xFF78350F),
                            fontSize = 8.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.5.dp)
                          )
                        }
                      }
                      Text(
                        text = "රාජධානි • වාරිමාර්ග • මූලාශ්‍ර • අරගල • ආණ්ඩුක්‍රම • O/L සිතියම්",
                        color = Color(0xFFFDE68A),
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

            // 2. GRADE FILTER TOGGLE
            item(key = "history_grade_toggle") {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 12.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
              ) {
                listOf("10 & 11", "10", "11").forEach { gLabel ->
                  val isSelected = when (gLabel) {
                    "10 & 11" -> activeGrade == "10 & 11"
                    "10" -> activeGrade == "10"
                    else -> activeGrade == "11"
                  }
                  FilterChip(
                    selected = isSelected,
                    onClick = { activeGrade = if (gLabel == "10 & 11") "10 & 11" else gLabel },
                    label = {
                      Text(
                        text = if (gLabel == "10 & 11") "සියල්ල (10 & 11)" else "$gLabel ශ්‍රේණිය",
                        fontSize = 11.5.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                      )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                      selectedContainerColor = Color(0xFFD97706),
                      selectedLabelColor = Color.White,
                      containerColor = Color(0xFF1E293B),
                      labelColor = Color(0xFFFDE68A)
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                      enabled = true,
                      selected = isSelected,
                      borderColor = Color(0xFFF59E0B),
                      selectedBorderColor = Color(0xFFFDE68A)
                    ),
                    modifier = Modifier.weight(1f)
                  )
                }
              }
            }

            // 3. SEARCH BAR
            item(key = "history_search_bar") {
              OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("රජුගේ නම, රාජධානිය, වැව, ගිවිසුම, අරගලය සොයන්න...", fontSize = 11.sp, color = Color(0xFF94A3B8)) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color(0xFFFDE68A)) },
                trailingIcon = {
                  if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { searchQuery = "" }) {
                      Icon(Icons.Default.Clear, contentDescription = "Clear", tint = Color.White)
                    }
                  }
                },
                singleLine = true,
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                  focusedContainerColor = Color(0xFF1E293B),
                  unfocusedContainerColor = Color(0xFF1E293B),
                  focusedBorderColor = Color(0xFFF59E0B),
                  unfocusedBorderColor = Color(0xFF334155),
                  focusedTextColor = Color.White,
                  unfocusedTextColor = Color.White
                ),
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 12.dp, vertical = 4.dp)
              )
            }

            // 4. MAIN HUB MODE SELECTOR (📚 400 Facts Bank vs 🏛️ 12 Specialized Modules)
            item(key = "history_hub_mode_selector") {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 12.dp, vertical = 6.dp)
                  .clip(RoundedCornerShape(10.dp))
                  .background(Color(0xFF1E293B))
                  .padding(3.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
              ) {
                Surface(
                  onClick = {
                    hubMode = 0
                  },
                  shape = RoundedCornerShape(8.dp),
                  color = if (hubMode == 0) Color(0xFFD97706) else Color.Transparent,
                  modifier = Modifier.weight(1f)
                ) {
                  Text(
                    text = "📚 කරුණු 400 බැංකුව (කාණ්ඩ 20)",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (hubMode == 0) Color.White else Color(0xFFCBD5E1),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 7.dp)
                  )
                }

                Surface(
                  onClick = {
                    hubMode = 1
                    selectedCategoryIndex = -1
                  },
                  shape = RoundedCornerShape(8.dp),
                  color = if (hubMode == 1) Color(0xFF4F46E5) else Color.Transparent,
                  modifier = Modifier.weight(1f)
                ) {
                  Text(
                    text = "🏛️ විෂය ඒකක (12 Sub-Sections)",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (hubMode == 1) Color.White else Color(0xFFCBD5E1),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 7.dp)
                  )
                }
              }
            }

            // 5. CONTENT AREA: DISPLAY DEPENDING ON hubMode
            if (hubMode == 0) {
              // MODE 0: 20 CATEGORIES QUICK OVERVIEW GRID (Showing all 20 categories: 1. මූලාශ්‍ර, 2. මුල් යුගය, 3. අනුරාධපුරය...)
              item(key = "history_20_categories_overview_grid") {
            Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)) {
              Surface(
                color = Color(0xFFD97706).copy(alpha = 0.2f),
                border = BorderStroke(1.dp, Color(0xFFD97706)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(bottom = 8.dp)
              ) {
                Row(
                  modifier = Modifier.padding(8.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text("📚", fontSize = 18.sp)
                  Spacer(modifier = Modifier.width(8.dp))
                  Column {
                    Text(
                      text = "ඉතිහාසය කරුණු 400 බැංකුව (කාණ්ඩ 20 x කරුණු 20)",
                      color = Color.White,
                      fontSize = 12.sp,
                      fontWeight = FontWeight.Bold
                    )
                    Text(
                      text = "ඕනෑම කාණ්ඩයක් මත ක්ලික් කර එහි සියලුම කරුණු 20 අධ්‍යයනය කරන්න.",
                      color = Color(0xFFFDE68A),
                      fontSize = 10.sp
                    )
                  }
                }
              }

              HistoryQuickOverviewGrid(
                categories = filteredCategories,
                onSelectModule = { cat ->
                  selectedCategoryIndex = categories.indexOf(cat)
                }
              )
            }
          }
        } else {
          // MODE 1: 12 SPECIALIZED MODULES GRID (4 ITEMS PER ROW GOING DOWNWARDS)
          item(key = "history_categories_4_per_row_grid") {
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 6.dp),
              verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
              val primaryModules = listOf(
                HistoryModuleType.KINGDOMS_RULERS,
                HistoryModuleType.IRRIGATION_CIVILIZATION,
                HistoryModuleType.HISTORICAL_SOURCES,
                HistoryModuleType.FOREIGN_RULE_STRUGGLES,
                HistoryModuleType.CONSTITUTIONS,
                HistoryModuleType.MAP_LOCATIONS,
                HistoryModuleType.ART_SCULPTURE,
                HistoryModuleType.HISTORICAL_TREATIES,
                HistoryModuleType.NATIONAL_REVIVAL,
                HistoryModuleType.RENAISSANCE,
                HistoryModuleType.REVOLUTIONS_WORLD_WARS,
                HistoryModuleType.EXAM_SECRETS
              )

              val categoryChunks = primaryModules.chunked(4)
              categoryChunks.forEach { rowCategories ->
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                  rowCategories.forEach { module ->
                    val indexInEnum = allModules.indexOf(module)
                    val isSelected = selectedModuleTab == indexInEnum

                    Surface(
                      onClick = {
                        selectedModuleTab = indexInEnum
                        selectedCategoryIndex = -1
                      },
                      shape = RoundedCornerShape(8.dp),
                      color = if (isSelected) module.color else Color(0xFF1E293B),
                      border = BorderStroke(
                        width = if (isSelected) 2.dp else 1.dp,
                        color = if (isSelected) Color(0xFFFDE68A) else Color(0xFF334155)
                      ),
                      modifier = Modifier
                        .weight(1f)
                        .height(58.dp)
                    ) {
                      Column(
                        modifier = Modifier
                          .fillMaxSize()
                          .padding(2.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                      ) {
                        Text(
                          text = module.icon,
                          fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                          text = module.title,
                          fontSize = 8.5.sp,
                          fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Medium,
                          color = if (isSelected) Color.White else Color(0xFFCBD5E1),
                          textAlign = TextAlign.Center,
                          maxLines = 2,
                          lineHeight = 10.sp,
                          overflow = TextOverflow.Ellipsis
                        )
                      }
                    }
                  }

                  if (rowCategories.size < 4) {
                    repeat(4 - rowCategories.size) {
                      Spacer(modifier = Modifier.weight(1f))
                    }
                  }
                }
              }
            }
          }

          // SELECTED MODULE BANNER HEADER
          item(key = "history_selected_module_header") {
            val currentModule = allModules.getOrElse(selectedModuleTab) { HistoryModuleType.KINGDOMS_RULERS }
            Surface(
              color = currentModule.color.copy(alpha = 0.25f),
              border = BorderStroke(1.dp, currentModule.color),
              shape = RoundedCornerShape(10.dp),
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = currentModule.icon,
                  fontSize = 24.sp
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                  Text(
                    text = "අනු කොටස: ${currentModule.title}",
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                  )
                  Text(
                    text = "ශ්‍රී ලංකා හා ලෝක ඉතිහාසය O/L විෂය නිර්දේශ සාරාංශය",
                    color = Color(0xFFFDE68A),
                    fontSize = 10.5.sp
                  )
                }
              }
            }
          }

          // MODULE CONTENT RENDERING WITH FALLBACK FILTER
          val currentModule = allModules.getOrElse(selectedModuleTab) { HistoryModuleType.KINGDOMS_RULERS }
          when (currentModule) {
            HistoryModuleType.KINGDOMS_RULERS -> {
              val items = filterHistoryModuleList(
                allItems = HistoryAdvancedSyllabusRepository.rulersList,
                activeGrade = activeGrade,
                searchQuery = searchQuery,
                getGrade = { it.grade },
                matchesSearch = { item, q -> item.rulerName.contains(q, true) || item.kingdom.contains(q, true) || item.epithet.contains(q, true) }
              )
              items(items, key = { it.id }) { ruler ->
                HistoryRulerCard(ruler)
              }
            }

            HistoryModuleType.IRRIGATION_CIVILIZATION -> {
              val items = filterHistoryModuleList(
                allItems = HistoryAdvancedSyllabusRepository.irrigationList,
                activeGrade = activeGrade,
                searchQuery = searchQuery,
                getGrade = { it.grade },
                matchesSearch = { item, q -> item.name.contains(q, true) || item.builtBy.contains(q, true) || item.technologyComponent.contains(q, true) }
              )
              items(items, key = { it.id }) { irrigation ->
                HistoryIrrigationCard(irrigation)
              }
            }

            HistoryModuleType.HISTORICAL_SOURCES -> {
              val items = filterHistoryModuleList(
                allItems = HistoryAdvancedSyllabusRepository.sourcesList,
                activeGrade = activeGrade,
                searchQuery = searchQuery,
                getGrade = { it.grade },
                matchesSearch = { item, q -> item.sourceName.contains(q, true) || item.category.contains(q, true) || item.authorOrOrigin.contains(q, true) }
              )
              items(items, key = { it.id }) { source ->
                HistorySourceCard(source)
              }
            }

            HistoryModuleType.FOREIGN_RULE_STRUGGLES -> {
              val items = filterHistoryModuleList(
                allItems = HistoryAdvancedSyllabusRepository.colonialUprisingsList,
                activeGrade = activeGrade,
                searchQuery = searchQuery,
                getGrade = { it.grade },
                matchesSearch = { item, q -> item.title.contains(q, true) || item.leaders.any { l -> l.contains(q, true) } }
              )
              items(items, key = { it.id }) { uprising ->
                HistoryUprisingCard(uprising)
              }
            }

            HistoryModuleType.CONSTITUTIONS -> {
              val items = filterHistoryModuleList(
                allItems = HistoryAdvancedSyllabusRepository.constitutionsList,
                activeGrade = activeGrade,
                searchQuery = searchQuery,
                getGrade = { it.grade },
                matchesSearch = { item, q -> item.name.contains(q, true) || item.year.contains(q) || item.governorOrCommission.contains(q, true) }
              )
              items(items, key = { it.id }) { constitution ->
                HistoryConstitutionCard(constitution)
              }
            }

            HistoryModuleType.MAP_LOCATIONS -> {
              val items = filterHistoryModuleList(
                allItems = HistoryAdvancedSyllabusRepository.mapLocationsList,
                activeGrade = activeGrade,
                searchQuery = searchQuery,
                getGrade = { it.grade },
                matchesSearch = { item, q -> item.locationName.contains(q, true) || item.provinceOrDistrict.contains(q, true) || item.category.contains(q, true) }
              )
              items(items, key = { it.id }) { location ->
                HistoryMapLocationCard(location)
              }
            }

            HistoryModuleType.WORLD_HISTORY, HistoryModuleType.REVOLUTIONS_WORLD_WARS -> {
              val items = filterHistoryModuleList(
                allItems = HistoryAdvancedSyllabusRepository.worldHistoryList,
                activeGrade = activeGrade,
                searchQuery = searchQuery,
                getGrade = { it.grade },
                matchesSearch = { item, q -> item.eventTitle.contains(q, true) || item.region.contains(q, true) }
              )
              items(items, key = { it.id }) { worldEvent ->
                HistoryWorldEventCard(worldEvent)
              }
            }

            HistoryModuleType.ART_SCULPTURE -> {
              val items = filterHistoryModuleList(
                allItems = HistoryExpandedRepository.artSculpturesList,
                activeGrade = activeGrade,
                searchQuery = searchQuery,
                getGrade = { it.grade },
                matchesSearch = { item, q -> item.title.contains(q, true) || item.category.contains(q, true) }
              )
              item { HistoryArtSculptureSection(items) }
            }

            HistoryModuleType.HISTORICAL_TREATIES -> {
              val items = filterHistoryModuleList(
                allItems = HistoryExpandedRepository.treatiesList,
                activeGrade = activeGrade,
                searchQuery = searchQuery,
                getGrade = { it.grade },
                matchesSearch = { item, q -> item.treatyName.contains(q, true) || item.signatoryParties.contains(q, true) }
              )
              item { HistoryTreatiesSection(items) }
            }

            HistoryModuleType.RENAISSANCE -> {
              val items = filterHistoryModuleList(
                allItems = HistoryExpandedRepository.worldErasList,
                activeGrade = activeGrade,
                searchQuery = searchQuery,
                getGrade = { it.grade },
                matchesSearch = { item, q -> item.eraTitle.contains(q, true) }
              )
              item { HistoryWorldErasSection(items) }
            }

            HistoryModuleType.EXAM_SECRETS, HistoryModuleType.ESSAY_GUIDE, HistoryModuleType.ESSAY_TEMPLATES -> {
              val items = filterHistoryModuleList(
                allItems = HistoryAdvancedSyllabusRepository.examTipsList,
                activeGrade = activeGrade,
                searchQuery = searchQuery,
                getGrade = { it.grade },
                matchesSearch = { item, q -> item.questionTopic.contains(q, true) }
              )
              items(items, key = { it.id }) { tip ->
                HistoryExamTipCard(tip)
              }
            }

            HistoryModuleType.RAPID_MCQS -> {
              val items = filterHistoryModuleList(
                allItems = HistoryAdvancedSyllabusRepository.rapidMcqsList,
                activeGrade = activeGrade,
                searchQuery = searchQuery,
                getGrade = { it.grade },
                matchesSearch = { item, q -> item.question.contains(q, true) }
              )
              items(items, key = { it.id }) { mcq ->
                HistoryRapidMcqCard(mcq)
              }
            }

            HistoryModuleType.CASCADE_TANKS -> {
              val items = filterHistoryModuleList(
                allItems = HistoryExpandedRepository.cascadeTanksList,
                activeGrade = activeGrade,
                searchQuery = searchQuery,
                getGrade = { it.grade },
                matchesSearch = { item, q -> item.componentName.contains(q, true) || item.mainFunction.contains(q, true) }
              )
              item { HistoryCascadeTanksSection(items) }
            }

            HistoryModuleType.NATIONAL_REVIVAL -> {
              val items = filterHistoryModuleList(
                allItems = HistoryExpandedRepository.revivalList,
                activeGrade = activeGrade,
                searchQuery = searchQuery,
                getGrade = { it.grade },
                matchesSearch = { item, q -> item.leaderOrMovement.contains(q, true) }
              )
              item { HistoryRevivalSection(items) }
            }

            HistoryModuleType.TIMELINE_CHALLENGE, HistoryModuleType.TIMELINE -> {
              val items = filterHistoryModuleList(
                allItems = HistoryExpandedRepository.timelineChallengesList,
                activeGrade = activeGrade,
                searchQuery = searchQuery,
                getGrade = { it.grade },
                matchesSearch = { item, q -> item.challengeTitle.contains(q, true) }
              )
              item { HistoryTimelineChallengeSection(items) }
            }

            HistoryModuleType.ARTIFACT_IDENTIFIER, HistoryModuleType.VISUAL_GALLERY -> {
              val items = filterHistoryModuleList(
                allItems = HistoryExpandedRepository.artifactsList,
                activeGrade = activeGrade,
                searchQuery = searchQuery,
                getGrade = { it.grade },
                matchesSearch = { item, q -> item.artifactName.contains(q, true) || item.location.contains(q, true) }
              )
              item { HistoryArtifactSection(items) }
            }

            else -> {
              val items = filterHistoryModuleList(
                allItems = HistoryAdvancedSyllabusRepository.rulersList,
                activeGrade = activeGrade,
                searchQuery = searchQuery,
                getGrade = { it.grade },
                matchesSearch = { item, q -> item.rulerName.contains(q, true) }
              )
              items(items, key = { it.id }) { ruler ->
                HistoryRulerCard(ruler)
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

private fun <T> filterHistoryModuleList(
  allItems: List<T>,
  activeGrade: String,
  searchQuery: String,
  getGrade: (T) -> String,
  matchesSearch: (T, String) -> Boolean
): List<T> {
  val searchFiltered = if (searchQuery.isBlank()) {
    allItems
  } else {
    allItems.filter { matchesSearch(it, searchQuery) }
  }

  val gradeFiltered = searchFiltered.filter { item ->
    val g = getGrade(item)
    activeGrade == "10 & 11" || g.isEmpty() || g == "10 & 11" || g == activeGrade || g.contains(activeGrade)
  }

  return if (gradeFiltered.isNotEmpty()) gradeFiltered else searchFiltered
}

/**
 * Backward compatibility wrapper for HistoryFullScreenModal
 */
@Composable
fun HistoryFullScreenModal(
  initialGrade: String,
  initialTab: Int = 0,
  onDismiss: () -> Unit
) {
  HistoryGrade10And11MasterHubDialog(
    initialGrade = initialGrade,
    initialCategoryIndex = -1,
    initialModuleIndex = initialTab,
    categories = SubjectMasterHistory20x20.getCategories(),
    onDismiss = onDismiss
  )
}

@Composable
fun HistoryQuickOverviewGrid(
  categories: List<SubjectMasterCategory>,
  onSelectModule: (SubjectMasterCategory) -> Unit
) {
  Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
    // 2-column layout to match Sinhala Master Hub
    for (i in categories.indices step 2) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        HistoryFeatureButton(
          category = categories[i],
          modifier = Modifier.weight(1f),
          onClick = { onSelectModule(categories[i]) }
        )
        if (i + 1 < categories.size) {
          HistoryFeatureButton(
            category = categories[i + 1],
            modifier = Modifier.weight(1f),
            onClick = { onSelectModule(categories[i + 1]) }
          )
        } else {
          HistoryFeatureButton(
            category = null,
            customTitle = "AI උපදේශක",
            customIcon = "🤖",
            customSubtitle = "ඉතිහාසය AI සහාය",
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
fun HistoryFeatureButton(
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
        color = Color(0xFFFDE68A),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
      )
    }
  }
}

// -------------------------------------------------------------
// COMPACT COLLAPSIBLE CARD COMPONENTS (SINHALA DESIGN SYSTEM)
// Minimal default height (~40dp), non-squishable category pills,
// smooth expand/collapse animations, and clean bullet structures.
// -------------------------------------------------------------

@Composable
fun HistoryRulerCard(ruler: HistoryRulerItem) {
  var expanded by remember { mutableStateOf(false) }

  Card(
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
    border = BorderStroke(1.dp, Color(0xFF334155)),
    modifier = Modifier
      .fillMaxWidth()
      .animateContentSize(animationSpec = tween(200))
  ) {
    Column(modifier = Modifier.padding(10.dp)) {
      // Compact Header with minimal height (~40dp) - Badge first, non-squishable!
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
            color = Color(0xFFD97706).copy(alpha = 0.25f),
            shape = RoundedCornerShape(6.dp)
          ) {
            Text(
              text = ruler.kingdom,
              color = Color(0xFFFBBF24),
              fontSize = 9.5.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = ruler.rulerName,
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
        // Quick summary line when collapsed (matching Sinhala format)
        Text(
          text = "${ruler.epithet} • කාලය: ${ruler.period}",
          color = Color(0xFF94A3B8),
          fontSize = 11.sp,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier.padding(top = 2.dp)
        )
      } else {
        // Expanded Details
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(color = Color(0xFF334155), thickness = 0.8.dp)
        Spacer(modifier = Modifier.height(8.dp))

        // Ruler Epithet & Period Banner
        Surface(
          color = Color(0xFF0F172A),
          shape = RoundedCornerShape(8.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(8.dp)) {
            Text(text = "👑 ${ruler.epithet}", color = Color(0xFFFDE68A), fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
            Text(text = "කාලය: ${ruler.period}", color = Color(0xFF94A3B8), fontSize = 10.5.sp)
          }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Political services
        Text("👑 දේශපාලන මෙහෙවර:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF67E8F9))
        ruler.politicalServices.forEach { s ->
          Row(modifier = Modifier.padding(vertical = 1.5.dp)) {
            Text("•", color = Color(0xFF38BDF8), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(6.dp))
            Text(s, fontSize = 11.sp, color = Color(0xFFE2E8F0), lineHeight = 16.sp)
          }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Economic services
        Text("🌾 ආර්ථික & වාරි සේවාවන්:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF86EFAC))
        ruler.economicServices.forEach { s ->
          Row(modifier = Modifier.padding(vertical = 1.5.dp)) {
            Text("•", color = Color(0xFF4ADE80), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(6.dp))
            Text(s, fontSize = 11.sp, color = Color(0xFFE2E8F0), lineHeight = 16.sp)
          }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Religious/Cultural services
        Text("🛕 ශාසනික & සංස්කෘතික සේවාවන්:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFCA5A5))
        ruler.religiousCulturalServices.forEach { s ->
          Row(modifier = Modifier.padding(vertical = 1.5.dp)) {
            Text("•", color = Color(0xFFF87171), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(6.dp))
            Text(s, fontSize = 11.sp, color = Color(0xFFE2E8F0), lineHeight = 16.sp)
          }
        }

        if (ruler.keyExamFacts.isNotEmpty()) {
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
              Text(ruler.keyExamFacts.joinToString(" • "), color = Color(0xFFFEF08A), fontSize = 10.5.sp)
            }
          }
        }
      }
    }
  }
}

@Composable
fun HistoryIrrigationCard(item: HistoryIrrigationItem) {
  var expanded by remember { mutableStateOf(false) }

  Card(
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
    border = BorderStroke(1.dp, Color(0xFF0284C7).copy(alpha = 0.4f)),
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
            color = Color(0xFF0284C7).copy(alpha = 0.25f),
            shape = RoundedCornerShape(6.dp)
          ) {
            Text(
              text = item.technologyComponent,
              color = Color(0xFF38BDF8),
              fontSize = 9.5.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = item.name,
            color = Color(0xFFBAE6FD),
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
          text = "නිර්මාතෘ / යුගය: ${item.builtBy}",
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

        Text("නිර්මාතෘ / යුගය: ${item.builtBy}", fontSize = 11.sp, color = Color(0xFF38BDF8), fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = "ස්වභාවය සහ ලක්ෂණ: ${item.features}",
          fontSize = 11.sp,
          color = Color(0xFFE2E8F0),
          lineHeight = 16.sp
        )

        Spacer(modifier = Modifier.height(6.dp))
        Surface(
          color = Color(0xFF082F49),
          shape = RoundedCornerShape(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(8.dp)) {
            Text("තාක්ෂණික වැදගත්කම:", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF7DD3FC))
            Text(
              text = item.syllabusImportance,
              fontSize = 10.5.sp,
              color = Color(0xFFE0F2FE),
              lineHeight = 15.sp
            )
          }
        }
      }
    }
  }
}

@Composable
fun HistorySourceCard(source: HistorySourceItem) {
  var expanded by remember { mutableStateOf(false) }

  Card(
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
    border = BorderStroke(1.dp, Color(0xFF059669).copy(alpha = 0.4f)),
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
            color = Color(0xFF059669).copy(alpha = 0.25f),
            shape = RoundedCornerShape(6.dp)
          ) {
            Text(
              text = source.category,
              color = Color(0xFF34D399),
              fontSize = 9.5.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = source.sourceName,
            color = Color(0xFFA7F3D0),
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
          text = "කර්තෘ / සම්භවය: ${source.authorOrOrigin}",
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

        Text("කර්තෘ / සම්භවය: ${source.authorOrOrigin}", fontSize = 11.sp, color = Color(0xFF6EE7B7), fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text("අන්තර්ගතය: ${source.keyContents}", fontSize = 11.sp, color = Color(0xFFE2E8F0), lineHeight = 16.sp)

        Spacer(modifier = Modifier.height(6.dp))
        Surface(
          color = Color(0xFF064E3B).copy(alpha = 0.4f),
          shape = RoundedCornerShape(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(8.dp)) {
            Text("ඓතිහාසික වටිනාකම:", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF6EE7B7))
            Text(source.historicalValue, fontSize = 10.5.sp, color = Color(0xFFD1FAE5), lineHeight = 15.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Text("💡 විභාග ආදර්ශ ප්‍රශ්නය:", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE68A))
            Text(source.examSampleQuestion, fontSize = 10.5.sp, color = Color.White, lineHeight = 15.sp)
          }
        }
      }
    }
  }
}

@Composable
fun HistoryUprisingCard(item: HistoryColonialUprisingItem) {
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
              text = item.periodOrYear,
              color = Color(0xFFFCA5A5),
              fontSize = 9.5.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = item.title,
            color = Color(0xFFFCA5A5),
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
          text = "නායකයින්: ${item.leaders.joinToString(", ")}",
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

        Text(
          text = "නායකයින්: ${item.leaders.joinToString(", ")}",
          fontSize = 11.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFFFDE68A)
        )

        Spacer(modifier = Modifier.height(6.dp))
        Text("🔥 මූලික හේතු:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFF87171))
        item.rootCauses.forEach { c ->
          Text(" • $c", fontSize = 10.5.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)
        }

        Spacer(modifier = Modifier.height(6.dp))
        Text("⚔️ ප්‍රධාන සිදුවීම්:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE68A))
        item.mainEvents.forEach { e ->
          Text(" • $e", fontSize = 10.5.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)
        }

        Spacer(modifier = Modifier.height(6.dp))
        Text("💥 ප්‍රතිඵල සහ බලපෑම:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF93C5FD))
        item.consequencesAndImpact.forEach { ci ->
          Text(" • $ci", fontSize = 10.5.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)
        }
      }
    }
  }
}

@Composable
fun HistoryConstitutionCard(item: HistoryConstitutionItem) {
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
              text = item.year,
              color = Color(0xFFC4B5FD),
              fontSize = 9.5.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = item.name,
            color = Color(0xFFDDD6FE),
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
          text = "කොමිසම: ${item.governorOrCommission} • ඡන්ද අයිතිය: ${item.votingRights}",
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

        Text("සභා ව්‍යුහය: ${item.councilStructure}", fontSize = 10.5.sp, color = Color(0xFFE2E8F0))
        Text("ඡන්ද අයිතිය: ${item.votingRights}", fontSize = 10.5.sp, color = Color(0xFFFDE68A), fontWeight = FontWeight.Medium)

        Spacer(modifier = Modifier.height(6.dp))
        Text("✅ ප්‍රධාන ප්‍රතිසංස්කරණ:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFA7F3D0))
        item.keyReforms.forEach { r ->
          Text(" • $r", fontSize = 10.5.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)
        }

        Spacer(modifier = Modifier.height(6.dp))
        Text("⚠️ දුර්වලතා සහ සීමාවන්:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFCA5A5))
        item.shortcomingsOrDrawbacks.forEach { d ->
          Text(" • $d", fontSize = 10.5.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)
        }
      }
    }
  }
}

@Composable
fun HistoryMapLocationCard(item: HistoryMapLocationItem) {
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
            color = Color(0xFF1E3A8A),
            shape = RoundedCornerShape(6.dp)
          ) {
            Text(
              text = item.category,
              color = Color(0xFFBFDBFE),
              fontSize = 9.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = item.locationName,
            color = Color(0xFF93C5FD),
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
            tint = Color(0xFF93C5FD),
            modifier = Modifier.size(18.dp)
          )
        }
      }

      if (!expanded) {
        Text(
          text = "පිහිටීම: ${item.provinceOrDistrict}",
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

        Text("පිහිටීම: ${item.provinceOrDistrict}", fontSize = 10.5.sp, color = Color(0xFF94A3B8))
        Spacer(modifier = Modifier.height(4.dp))
        Text("ඓතිහාසික වැදගත්කම: ${item.historicalSignificance}", fontSize = 10.5.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)

        Spacer(modifier = Modifier.height(6.dp))
        Surface(
          color = Color(0xFF172554),
          shape = RoundedCornerShape(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier.padding(6.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text("🗺️", fontSize = 11.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "සිතියමේ ලකුණු කරන අයුරු: ${item.mapMarkingGuide}",
              fontSize = 10.sp,
              color = Color(0xFFBAE6FD),
              lineHeight = 14.sp
            )
          }
        }
      }
    }
  }
}

@Composable
fun HistoryWorldEventCard(item: HistoryWorldEventItem) {
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
              text = item.era,
              color = Color(0xFF5EEAD4),
              fontSize = 9.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = item.eventTitle,
            color = Color(0xFF5EEAD4),
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
            tint = Color(0xFF5EEAD4),
            modifier = Modifier.size(18.dp)
          )
        }
      }

      if (!expanded) {
        Text(
          text = "කලාපය: ${item.region} • නායකයන්: ${item.pioneersOrLeaders.joinToString(", ")}",
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

        Text("ප්‍රමුඛ නායකයන් / පුරෝගාමීන්: ${item.pioneersOrLeaders.joinToString(", ")}", fontSize = 10.5.sp, color = Color(0xFFFDE68A))

        Spacer(modifier = Modifier.height(4.dp))
        Text("මූලික හේතු:", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2DD4BF))
        item.keyCauses.forEach { c ->
          Text(" • $c", fontSize = 10.sp, color = Color(0xFFE2E8F0))
        }

        Spacer(modifier = Modifier.height(4.dp))
        Text("නව නිපැයුම් / ප්‍රතිඵල:", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF93C5FD))
        item.keyInnovationsOrConsequences.forEach { i ->
          Text(" • $i", fontSize = 10.sp, color = Color(0xFFE2E8F0))
        }

        Spacer(modifier = Modifier.height(6.dp))
        Surface(
          color = Color(0xFF134E4A),
          shape = RoundedCornerShape(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Text(
            text = "ලංකාවට ඇතිවූ බලපෑම: ${item.impactOnSriLanka}",
            fontSize = 10.sp,
            color = Color(0xFFCCFBF1),
            modifier = Modifier.padding(6.dp)
          )
        }
      }
    }
  }
}

@Composable
fun HistoryExamTipCard(item: HistoryExamEssayTip) {
  var expanded by remember { mutableStateOf(false) }

  Card(
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
    border = BorderStroke(1.dp, Color(0xFFE11D48).copy(alpha = 0.4f)),
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
            color = Color(0xFF881337),
            shape = RoundedCornerShape(6.dp)
          ) {
            Text(
              text = item.partMarkAllocations,
              color = Color.White,
              fontSize = 9.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = item.questionTopic,
            fontSize = 12.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFDA4AF),
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
            tint = Color(0xFFFDA4AF),
            modifier = Modifier.size(18.dp)
          )
        }
      }

      if (!expanded) {
        Text(
          text = "රචනා ප්‍රශ්නයට Full Marks පිළිතුරු සැලසුම",
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

        Text("📝 රචනා ප්‍රශ්නයට පිළිතුරු සැලසුම (Full Marks Structure):", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE68A))
        item.structuredParagraphPlan.forEachIndexed { idx, plan ->
          Text(" ${idx + 1}. $plan", fontSize = 10.5.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)
        }

        Spacer(modifier = Modifier.height(6.dp))
        Surface(
          color = Color(0xFF4C0519),
          shape = RoundedCornerShape(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(8.dp)) {
            Text("⚠️ සිසුන් නිතර කරන වැරදි:", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFCA5A5))
            Text(item.commonMistakes, fontSize = 10.sp, color = Color(0xFFFFF1F2), lineHeight = 14.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text("🧠 මතක තබාගැනීමේ කෙටි ක්‍රමය (Mnemonic):", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE68A))
            Text(item.mnemonicOrMemoryTrick, fontSize = 10.5.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
          }
        }
      }
    }
  }
}

@Composable
fun HistoryRapidMcqCard(item: HistoryRapidMcqItem) {
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
            text = "⚡ MCQ අභ්‍යාසය",
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
fun EmptySearchResultNotice() {
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

@Composable
fun HistoryEssayGuideSubSection(grade: String) {
  val essays = remember(grade) {
    ComprehensiveStructuredEssayRepository.getQuestions(
      grade = grade,
      subject = "ඉතිහාසය"
    ).filter { it.type == "ESSAY" }
  }

  Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
    Text("රචනා ලිවීමේ සැකිලි සහ ආදර්ශ පිළිතුරු", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.White)
    Spacer(modifier = Modifier.height(8.dp))
    essays.forEach { essay ->
      Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Color(0xFF334155))
      ) {
        Column(modifier = Modifier.padding(10.dp)) {
          Text(essay.topicSinhala, fontWeight = FontWeight.Bold, color = Color(0xFFFDE68A), fontSize = 12.5.sp)
          Spacer(modifier = Modifier.height(4.dp))
          Text(essay.mainScenario, fontSize = 11.sp, color = Color(0xFFE2E8F0), lineHeight = 16.sp)
        }
      }
    }
  }
}

@Composable
private fun HistoryMapQuizSection(onClose: () -> Unit) {
  val mapSites = listOf(
    Triple("📍 අනුරාධපුරය (Anuradhapura)", "උතුරු මැද පළාත • ශ්‍රී ලංකාවේ ප්‍රථම සංවිධානාත්මක අගනුවර", "පණ්ඩුකාභය, දේවානම්පියතිස්ස, දුටුගැමුණු, වළගම්බා, වසභ, මහසෙන් රජවරුන්ගේ පාලන මධ්‍යස්ථානය. මහා විහාරය, ශ්‍රී මහා බෝධිය, රුවන්වැලිසෑය, ජය ගඟ."),
    Triple("📍 පොළොන්නරුව (Polonnaruwa)", "උතුරු මැද පළාත • මධ්‍යතන යුගයේ අගනගරය", "I වන විජයබාහු, මහා පරාක්‍රමබාහු, නිශ්ශංකමල්ල රජවරුන්ගේ පාලන තැන්න. පරාක්‍රම සමුද්‍රය, ගල් විහාරය, ආලාහණ පිරිවෙන."),
    Triple("📍 දඹදෙණිය (Dambadeniya)", "වයඹ පළාත • කුරුණෑගල දිස්ත්‍රික්කය", "III වන විජයබාහු & II වන පරාක්‍රමබාහු රජවරුන්ගේ අගනුවර. කාලිංග මාඝ ආක්‍රමණයෙන් පසු දන්තධාතුන් වහන්සේ සුරක්ෂිත කළ ස්ථානය."),
    Triple("📍 යාපහුව (Yapahuwa)", "වයඹ පළාත • මහව ආසන්නයේ", "I වන බුවනෙකබාහු රජුගේ පර්වත රාජධානිය. විශ්මිත සිංහ කැටයම් පියගැටපෙළ සහ දළදා මාලිගාව."),
    Triple("📍 කෝට්ටේ (Kotte - ජයවර්ධනපුර)", "බස්නාහිර පළාත • කොළඹ අසල", "VI වන පරාක්‍රමබාහු රජු මුළු ලංකාවම එක්සේසත් කර පාලනය කළ රාජධානිය. සංදේශ කාව්‍ය යුගයේ ස්වර්ණමය මධ්‍යස්ථානය."),
    Triple("📍 සීතාවක (Sitawaka - අවිස්සාවේල්ල)", "බස්නාහිර පළාත • කෑගල්ල/කොළඹ මායිම", "මායාදුන්නේ සහ I වන රාජසිංහ රජවරුන්ගේ පාලන පීඨය. 1562 මුල්ලේරියා සටනින් පෘතුගීසීන් පරාජය කළ යුධ මධ්‍යස්ථානය."),
    Triple("📍 මහනුවර (Kandy - සෙන්කඩගල)", "මධ්‍යම පළාත • අන්තිම සිංහල රාජධානිය", "I වන විමලධර්මසූරිය, II වන රාජසිංහ, කීර්ති ශ්‍රී රාජසිංහ, ශ්‍රී වික්‍රම රාජසිංහ. ශ්‍රී දළදා මාළිගාව සහ 1815 උඩරට ගිවිසුම."),
    Triple("📍 මාන්තොට / මහාතිත්ථ (Mantai)", "මන්නාරම දිස්ත්‍රික්කය • වයඹ/උතුරු වෙරළ", "අතීත ලංකාවේ ප්‍රධානතම ජාත්‍යන්තර සමුද්‍රීය වෙළඳ වරාය. රෝමය, පර්සියාව, චීනය සහ ඉන්දියාව සමඟ වෙළඳ සබඳතා පැවැත්වීය."),
    Triple("📍 ගෝකණ්ණ වරාය (Trincomalee)", "ත්‍රිකුණාමලය දිස්ත්‍රික්කය • නැගෙනහිර වෙරළ", "ලෝක ප්‍රකට ස්වාභාවික වරාය. මහසෙන් රජුගේ කාලයේ සිට නැගෙනහිර නාවික හා වෙළඳ හදවත විය."),
    Triple("📍 මාගම / තිස්සමහාරාමය (Magama)", "හම්බන්තොට දිස්ත්‍රික්කය • දකුණු පළාත", "රුහුණු රාජධානියේ මුල් අගනුවර. මහානාග, කාවන්තිස්ස, දුටුගැමුණු සහ සද්ධාතිස්ස කුමාරවරුන්ගේ ජන්ම භූමිය."),
    Triple("📍 මුල්ලේරියාව (Mulleriyawa)", "බස්නාහිර පළාත • කොළඹ දිස්ත්‍රික්කය", "1562 දී I වන රාජසිංහ රජු (ටිකිරි කුමාරු) පෘතුගීසි බලඇණි සහමුලින්ම පරාජය කළ ආසියානු ඉතිහාසයේ විශාලතම සටන් බිම."),
    Triple("📍 ඉබ්බන්කටුව (Ibbankatuwa)", "මාතලේ දිස්ත්‍රික්කය • දඹුල්ල අසල", "පූර්ව ඓතිහාසික මෙගලිතික (Megalithic Burial) සුසාන භූමිය. ක්‍රි.පූ. 800ට පෙර ලංකාවේ සිටි මානව ජනාවාසවල සාක්ෂි.")
  )

  Column(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
    Surface(
      shape = RoundedCornerShape(10.dp),
      color = Color(0xFF0F172A),
      border = BorderStroke(1.dp, Color(0xFF0D9488)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(12.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("📍 O/L ඉතිහාසය අනිවාර්ය සිතියම් ලකුණු කිරීම් (Map Pins)", color = Color(0xFF5EEAD4), fontWeight = FontWeight.Bold, fontSize = 13.5.sp)
          Surface(onClick = onClose, color = Color(0xFF0D9488), shape = RoundedCornerShape(6.dp)) {
            Text("ලකුණු 18 අත්කරගන්න", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
          }
        }
        Text("O/L ප්‍රශ්න පත්‍රයේ පළමු ප්‍රශ්නයට අනිවාර්යයෙන් ලැබෙන සිතියම් ස්ථාන 12ක පූර්ණ විස්තරය මෙතැනින් අධ්‍යයනය කරන්න.", color = Color(0xFF99F6E4), fontSize = 11.sp, modifier = Modifier.padding(top = 4.dp))
      }
    }

    Spacer(modifier = Modifier.height(10.dp))

    mapSites.forEach { site ->
      Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Color(0xFF0D9488).copy(alpha = 0.6f))
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Text(site.first, fontWeight = FontWeight.Bold, color = Color(0xFF5EEAD4), fontSize = 13.sp)
          Spacer(modifier = Modifier.height(2.dp))
          Text(site.second, fontSize = 10.5.sp, color = Color(0xFFFDE68A), fontWeight = FontWeight.SemiBold)
          Spacer(modifier = Modifier.height(4.dp))
          Text(site.third, fontSize = 11.sp, color = Color(0xFFE2E8F0), lineHeight = 16.sp)
        }
      }
    }
  }
}

@Composable
private fun HistoryTimelineSection(onClose: () -> Unit) {
  val timelineEvents = listOf(
    Triple("1. ප්‍රාග් & පූර්ව ඓතිහාසික යුගය", "ක්‍රි.පූ. 125,000 - ක්‍රි.පූ. 500", "• හෝමෝ සේපියන්ස් බලංගොඩැන්සිස් (බලංගොඩ මානවයා)\n• පාහියන්ගල, බටදොඹලෙන, කිතුල්ගල බෙලිලෙන ජනාවාස\n• ඉබ්බන්කටුව මෙගලිතික සුසාන භූමි (ක්‍රි.පූ. 800)"),
    Triple("2. අනුරාධපුර ආරම්භක & මුල් යුගය", "ක්‍රි.පූ. 437 - ක්‍රි.පූ. 250", "• පණ්ඩුකාභය රජු (නගර සැලසුම්, ග්‍රාම සීමා, නගර ගුප්තික)\n• දේවානම්පියතිස්ස රජු (මිහින්තලය, මහින්දාගමනය, ශ්‍රී මහා බෝධිය වැඩමවීම)\n• තිස්ස වැව සහ මුල්ම බුදුසමය ලංකාව පුරා ව්‍යාප්ත වීම"),
    Triple("3. අනුරාධපුර එක්සේසත් & ශ්‍රේෂ්ඨ යුගය", "ක්‍රි.පූ. 161 - ක්‍රි.ව. 301", "• දුටුගැමුණු රජු (එළාර පරාජය, රුවන්වැලිසෑය, මිරිසවැටිය, ලෝවාමහාපාය)\n• වළගම්බා රජු (අභයගිරිය, ත්‍රිපිටකය ගන්ථාරූඪ කිරීම)\n• වසභ රජු (තුන් අඟලකට වඩා බෑවුම ඇති ඇළ මාර්ග, ලැයිස්තුගත වැව් 11ක්, ස්තූප 12ක්)\n• මහසෙන් රජු (මහවැලි ගඟ මගින් මිණේරිය වැව තැනීම)"),
    Triple("4. පොළොන්නරු රාජධානිය", "ක්‍රි.ව. 1055 - ක්‍රි.ව. 1232", "• I වන විජයබාහු (චෝළයන් පලවාහැර රට එක්සේසත් කිරීම)\n• මහා පරාක්‍රමබාහු (පරාක්‍රම සමුද්‍රය, ආලාහණ පිරිවෙන, ගල් විහාරය, 'අහසින් වැටෙන එකදු දිය බිඳකුදු...').\n• නිශ්ශංකමල්ල රජු (හැටදාගේ, රන්කොත් වෙහෙර, නිශ්ශංක ලතා මණ්ඩපය)"),
    Triple("5. නිරිතදිග රාජධානි යුගය", "ක්‍රි.ව. 1232 - 1597", "• III වන විජයබාහු & II වන පරාක්‍රමබාහු (දඹදෙණිය)\n• I වන බුවනෙකබාහු (යාපහුව)\n• IV වන පරාක්‍රමබාහු (කුරුණෑගල - උම්මග්ග ජාතකය)\n• VI වන පරාක්‍රමබාහු (කෝට්ටේ - මුළු ලංකාවම එක්සේසත් කළ අවසන් සිංහල රජු)\n• I වන රාජසිංහ (සීතාවක - මුල්ලේරියා සටනින් පෘතුගීසීන් පරාජය කිරීම)"),
    Triple("6. මහනුවර රාජධානිය & විදේශ අරගල", "ක්‍රි.ව. 1592 - 1815", "• I වන විමලධර්මසූරිය රජු (දන්තධාතුන් වහන්සේ දෙල්ගමුවෙන් වැඩමවීම, දළදා මාළිගාව තැනීම)\n• II වන රාජසිංහ (දන්තනගර සටන & ලන්දේසීන් කැඳවීම)\n• කීර්ති ශ්‍රී රාජසිංහ (වැලිවිට සරණංකර සංඝරාජ හිමියන්ගේ නායකත්වයෙන් උපසම්පදාව නැවත පිහිටුවීම)\n• 1815 උඩරට ගිවිසුම (ශ්‍රී ලංකාව සම්පූර්ණයෙන්ම බ්‍රිතාන්‍ය යටත්විජිතයක් වීම)"),
    Triple("7. බ්‍රිතාන්‍ය යටත්විජිත යුගය & නිදහස් අරගල", "1815 - 1948", "• 1818 ඌව වෙල්ලස්ස නිදහස් අරගලය (කැප්පෙටිපොළ දිසාව)\n• 1833 කෝල්බෲක්-කැමරන් ප්‍රතිසංස්කරණ\n• 1848 මාතලේ කැරැල්ල (පුරන් අප්පු, ගොංගාලේගොඩ බණ්ඩා)\n• 1910 කෲව්-මැකලම් (උගත් ලාංකික ආසනය - පොන්නම්බලම් රාමනාදන්)\n• 1931 ඩොනමෝර් (සර්වජන ඡන්ද බලය, රාජ්‍ය මන්ත්‍රණ සභාව)\n• 1948 පෙබරවාරි 04 (නිදහස ලැබීම - ඩී. එස්. සේනානායක)")
  )

  Column(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
    Surface(
      shape = RoundedCornerShape(10.dp),
      color = Color(0xFF0F172A),
      border = BorderStroke(1.dp, Color(0xFFD97706)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(12.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("⏳ O/L ඉතිහාසය නිල කාලරේඛාව (Chronological Timeline)", color = Color(0xFFFDE68A), fontWeight = FontWeight.Bold, fontSize = 13.5.sp)
          Surface(onClick = onClose, color = Color(0xFFD97706), shape = RoundedCornerShape(6.dp)) {
            Text("පූර්ණ කාලරේඛාව", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
          }
        }
        Text("ප්‍රාග් ඓතිහාසික යුගයේ සිට 1948 නිදහස දක්වා සියලුම රාජධානි, ප්‍රධාන රජවරුන් සහ ඓතිහාසික සිදුවීම් අනුපිළිවෙල මෙතැනින් නිවැරදිව අධ්‍යයනය කරන්න.", color = Color(0xFFFEF3C7), fontSize = 11.sp, modifier = Modifier.padding(top = 4.dp))
      }
    }

    Spacer(modifier = Modifier.height(10.dp))

    timelineEvents.forEach { ev ->
      Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Color(0xFFD97706).copy(alpha = 0.6f))
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(ev.first, fontWeight = FontWeight.Bold, color = Color(0xFFFBBF24), fontSize = 13.sp, modifier = Modifier.weight(1f))
            Surface(color = Color(0xFFD97706), shape = RoundedCornerShape(4.dp)) {
              Text(ev.second, color = Color.White, fontSize = 9.5.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
            }
          }
          Spacer(modifier = Modifier.height(6.dp))
          Text(ev.third, fontSize = 11.sp, color = Color(0xFFE2E8F0), lineHeight = 16.sp)
        }
      }
    }
  }
}

@Composable
private fun HistoryVisualGallerySection(onClose: () -> Unit) {
  val visualGallery = listOf(
    Triple("🖼️ නාගරාජ මුරගල (Nagaraja Guardstone)", "අනුරාධපුර මහමෙව්නාව • රත්නප්‍රසාදය", "• අත් පහකින් යුත් නාග පෙණය\n• එක අතක පුංකලස (සමෘද්ධියේ සංකේතය)\n• අනෙක් අතේ මල් කළඹ\n• පාමුල පද්මනිධි & සංඛනිධි වාමනයන්\n• විහාර ද්වාරයේ සමෘද්ධිය සහ ආරක්ෂාව නිරූපණය කරයි."),
    Triple("🖼️ සමාධි බුද්ධ ප්‍රතිමාව (Samadhi Statue)", "අනුරාධපුර මහමෙව්නාව • ක්‍රි.ව. 4 වන සියවස", "• වීරාසන සහ ධ්‍යාන මුද්‍රාව\n• නොසැලෙන මනස සහ පරම ශාන්තිය නිරූපණය කරයි\n• ජවාහර්ලාල් නේරු තුමන් සිරගෙදර සිටියදී සිතින් මවාගෙන ශක්තිය ලැබූ අසදෘශ මූර්තිය."),
    Triple("🖼️ අවුකන බුද්ධ ප්‍රතිමාව (Avukana Statue)", "කලාවැව අසල • ධාතුසේන රජ සමය (ක්‍රි.ව. 5 වන සියවස)", "• අභය මුද්‍රාව (බිය නැති කිරීම)\n• අඩි 38.8ක උස, එකම කළු ගලින් නෙළන ලද නිර්මාණය\n• සිවුරේ රැලි ඉතා තියණුවට හා ස්වාභාවික ලෙස දක්වා ඇත."),
    Triple("🖼️ ගල් විහාරය (Gal Vihara Polonnaruwa)", "පොළොන්නරුව • මහා පරාක්‍රමබාහු රජ සමය", "• විද්‍යාධර ගුහාව, හිඳි, සිටි, සැතපෙන බුද්ධ ප්‍රතිමා 4\n• සිටි පිළිමයේ පරදුක්ඛදුක්ඛිත මුද්‍රාව (අන් අයගේ දුකේදී කම්පා වීම)\n• ලංකාවේ ගල් කැටයම් කලා ශිල්පයේ උච්චතම අවස්ථාව."),
    Triple("🖼️ සීගිරි බිතුසිතුවම් (Sigiriya Frescoes)", "සීගිරිය • කාශ්‍යප රජ සමය (ක්‍රි.ව. 5 වන සියවස)", "• ස්වාභාවික ගුරුලු, සාදම්, රන්වන් වර්ණ යොදාගත් අහස්ගැබ චිත්‍ර\n• මේඝලතා (වළාකුළු කන්‍යාවන්) සහ විජ්ජුලතා (විදුලි කෙළි) නිරූපණය වේ."),
    Triple("🖼️ සඳකඩපහණ (Moonstone)", "අනුරාධපුර & පොළොන්නරු යුග", "• අර්ධ කවයාකාර කැටයම\n• සංසාර චක්‍රය නිරූපණය කරයි (ඇතු, අශ්ව, සිංහ, ගොන් - ජරා, ව්‍යාධි, මරණ, ඉපදීම)\n• පොළොන්නරු සඳකඩපහණේ ගොනා රූපය ඉවත් කර ඇත (හින්දු ආගමික බලපෑම නිසා).")
  )

  Column(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
    Surface(
      shape = RoundedCornerShape(10.dp),
      color = Color(0xFF0F172A),
      border = BorderStroke(1.dp, Color(0xFF7C3AED)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(12.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("🖼️ O/L ඉතිහාසය පුරාවස්තු සහ මූර්ති ගැලරිය", color = Color(0xFFDDD6FE), fontWeight = FontWeight.Bold, fontSize = 13.5.sp)
          Surface(onClick = onClose, color = Color(0xFF7C3AED), shape = RoundedCornerShape(6.dp)) {
            Text("ගැලරිය", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
          }
        }
        Text("විභාග පත්‍රයේ රූප සටහන් ප්‍රශ්නවලට අනිවාර්යයෙන්ම ලැබෙන මුරගල්, සඳකඩපහණ, බුද්ධ ප්‍රතිමා සහ බිතුසිතුවම්වල පූර්ණ විවරණය.", color = Color(0xFFC4B5FD), fontSize = 11.sp, modifier = Modifier.padding(top = 4.dp))
      }
    }

    Spacer(modifier = Modifier.height(10.dp))

    visualGallery.forEach { art ->
      Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Color(0xFF7C3AED).copy(alpha = 0.6f))
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Text(art.first, fontWeight = FontWeight.Bold, color = Color(0xFFC4B5FD), fontSize = 13.sp)
          Spacer(modifier = Modifier.height(2.dp))
          Text(art.second, fontSize = 10.5.sp, color = Color(0xFFFDE68A), fontWeight = FontWeight.SemiBold)
          Spacer(modifier = Modifier.height(4.dp))
          Text(art.third, fontSize = 11.sp, color = Color(0xFFE2E8F0), lineHeight = 16.sp)
        }
      }
    }
  }
}

@Composable
private fun HistoryComparisonSection(onClose: () -> Unit) {
  val comparisons = listOf(
    Triple("⚖️ 1818 ඌව වෙල්ලස්ස අරගලය VS 1848 මාතලේ අරගලය", "අරගල සංසන්දනය", "• 1818 අරගලය: උඩරට ගිවිසුම කඩකිරීම නිසා රදලවරුන් සහ ජනතාව කළ සන්නද්ධ සටනයි (කැප්පෙටිපොළ, මඩුගල්ලේ).\n• 1848 අරගලය: බ්‍රිතාන්‍යයන් විසින් පැනවූ නව අසාධාරණ බදු 7ට එරෙහිව පොදු ජනතාව කළ සටනයි (පුරන් අප්පු, ගොංගාලේගොඩ බණ්ඩා).\n• වෙනස: 1818 වැඩවසම් නායකත්වයක් වූ අතර 1848 සාමාන්‍ය ජනතාවගේ නායකත්වයක් විය."),
    Triple("⚖️ 1833 කෝල්බෲක් VS 1931 ඩොනමෝර් VS 1947 සෝල්බරි", "ආණ්ඩුක්‍රම සංසන්දනය", "• කෝල්බෲක් (1833): රාජකාරි ක්‍රමය අහෝසි කිරීම, පළාත් 5ක් පිහිටුවීම, විධායක හා ව්‍යවස්ථාදායක කවුන්සිල.\n• ඩොනමෝර් (1931): අවුරුදු 21ට වැඩි සැමට 'සර්වජන ඡන්ද බලය' හිමිවීම, රාජ්‍ය මන්ත්‍රණ සභාව, කාරක සභා 7ක්.\n• සෝල්බරි (1947): ද්වි-මණ්ඩල පාර්ලිමේන්තුව, අගමැති ප්‍රමුඛ කැබිනට් මණ්ඩලය, 1948 පෙබරවාරි 4 ඩොමීනියන් නිදහස."),
    Triple("⚖️ අනුරාධපුර වාරි සංස්කෘතිය VS පොළොන්නරු වාරි සංස්කෘතිය", "වාරි පද්ධති සංසන්දනය", "• අනුරාධපුරය: වසභ, මහසෙන්, ධාතුසේන රජවරුන් - මහවැලි, මල්වතු, කලා ඔය ඇසුරින් වැව් තැනීම (මිණේරිය, කලා වැව, පදවිය, ජය ගඟ).\n• පොළොන්නරුව: මහා පරාක්‍රමබාහු රජු - පරාක්‍රම සමුද්‍රය (වැව් 5ක් එකතු කර), අඟමැඩිල්ල අමුණ, ඇළහැර ඇළ.")
  )

  Column(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
    Surface(
      shape = RoundedCornerShape(10.dp),
      color = Color(0xFF0F172A),
      border = BorderStroke(1.dp, Color(0xFFBE123C)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(12.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("⚖️ O/L ඉතිහාසය නිල සංසන්දන වගු (Comparison Tables)", color = Color(0xFFFECDD3), fontWeight = FontWeight.Bold, fontSize = 13.5.sp)
          Surface(onClick = onClose, color = Color(0xFFBE123C), shape = RoundedCornerShape(6.dp)) {
            Text("සංසන්දන", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
          }
        }
        Text("විභාගයේ II කොටසේ ලකුණු 15 ප්‍රශ්න සඳහා නිතර විමසන අරගල, ව්‍යවස්ථා සහ වාරි පද්ධති සංසන්දනාත්මක විශ්ලේෂණය.", color = Color(0xFFFFE4E6), fontSize = 11.sp, modifier = Modifier.padding(top = 4.dp))
      }
    }

    Spacer(modifier = Modifier.height(10.dp))

    comparisons.forEach { comp ->
      Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Color(0xFFBE123C).copy(alpha = 0.6f))
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Text(comp.first, fontWeight = FontWeight.Bold, color = Color(0xFFFB7185), fontSize = 13.sp)
          Spacer(modifier = Modifier.height(2.dp))
          Text(comp.second, fontSize = 10.5.sp, color = Color(0xFFFDE68A), fontWeight = FontWeight.SemiBold)
          Spacer(modifier = Modifier.height(4.dp))
          Text(comp.third, fontSize = 11.sp, color = Color(0xFFE2E8F0), lineHeight = 16.sp)
        }
      }
    }
  }
}

@Composable
private fun HistoryEssayTemplatesSection(onClose: () -> Unit) {
  val essayTemplates = listOf(
    Triple("📝 සැකිල්ල 1: අනුරාධපුර යුගයේ වාරි තාක්ෂණය හා කෘෂිකාර්මික දියුණුව", "ලකුණු 15 මඟපෙන්වීම", "• හැඳින්වීම: සිංහල ශිෂ්ටාචාරයේ පදනම වාරි සංස්කෘතිය බව දැක්වීම.\n• ප්‍රධාන කරුණු: බිසෝකොටුව (සොරොව් තාක්ෂණය), ජලවේගය පාලනය, මිණේරිය, කලා වැව, ජය ඇළ (සැතපුමකට අඟල් 6ක බෑවුම).\n• නිගමනය: ලෝකයේ ප්‍රථම ජල කළමනාකරණ රාජ්‍යය ශ්‍රී ලංකාව බව තහවුරු කිරීම."),
    Triple("📝 සැකිල්ල 2: 1818 සහ 1848 නිදහස් අරගලයන්හි ස්වභාවය සහ වැදගත්කම", "ලකුණු 15 මඟපෙන්වීම", "• හැඳින්වීම: බ්‍රිතාන්‍ය යටත්විජිත පාලනයට එරෙහිව ලාංකිකයන් කළ සන්නද්ධ අරගල.\n• ප්‍රධාන කරුණු: කැප්පෙටිපොළ නිලමේගේ කාර්යභාරය, පුරන් අප්පුගේ හා ගොංගාලේගොඩ බණ්ඩාගේ නායකත්වය, පැනවූ අසාධාරණ බදු.\n• නිගමනය: සන්නද්ධ සටන්වලින් පසුව දේශපාලන හා ව්‍යවස්ථාමය අරගලවලට මගපෑදීම."),
    Triple("📝 සැකිල්ල 3: 1948 නිදහස කරා ශ්‍රී ලංකාව ගමන් කළ ව්‍යවස්ථාමය මඟ", "ලකුණු 15 මඟපෙන්වීම", "• හැඳින්වීම: 1833 සිට 1948 දක්වා ආණ්ඩුක්‍රම විකාශනය.\n• ප්‍රධාන කරුණු: 1910 උගත් ලාංකික ආසනය, 1931 ඩොනමෝර් සර්වජන ඡන්ද බලය, 1947 සෝල්බරි ව්‍යවස්ථාව.\n• නිගමනය: ලේ වැගිරීමකින් තොරව සාමකාමීව නිදහස දිනාගැනීම.")
  )

  Column(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
    Surface(
      shape = RoundedCornerShape(10.dp),
      color = Color(0xFF0F172A),
      border = BorderStroke(1.dp, Color(0xFF38BDF8)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(12.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("📝 O/L ඉතිහාසය රචනා ප්‍රශ්න සැකිලි & පිළිතුරු (Essay Templates)", color = Color(0xFFBAE6FD), fontWeight = FontWeight.Bold, fontSize = 13.5.sp)
          Surface(onClick = onClose, color = Color(0xFF0284C7), shape = RoundedCornerShape(6.dp)) {
            Text("රචනා සැකිලි", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
          }
        }
        Text("විභාගයේදී ලකුණු 15 රචනා ප්‍රශ්නවලට උපරිම ලකුණු ලබාගැනීම සඳහා පිළිතුර පෙළගස්වන නිවැරදි ආකෘතිය.", color = Color(0xFFE0F2FE), fontSize = 11.sp, modifier = Modifier.padding(top = 4.dp))
      }
    }

    Spacer(modifier = Modifier.height(10.dp))

    essayTemplates.forEach { essay ->
      Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.6f))
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Text(essay.first, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8), fontSize = 13.sp)
          Spacer(modifier = Modifier.height(2.dp))
          Text(essay.second, fontSize = 10.5.sp, color = Color(0xFFFDE68A), fontWeight = FontWeight.SemiBold)
          Spacer(modifier = Modifier.height(4.dp))
          Text(essay.third, fontSize = 11.sp, color = Color(0xFFE2E8F0), lineHeight = 16.sp)
        }
      }
    }
  }
}
