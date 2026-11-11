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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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

/**
 * 🌟 100% ACCURATE GRADE 10 & 11 SINHALA MASTER HUB
 * Strictly adheres to the Sri Lankan G.C.E. O/L Sinhala Language & Literature Syllabus.
 * Designed with compact, low-height collapsible sub-sections, full-screen dialog,
 * smooth scrolling up and down, grade toggles, and instant search.
 */
@Composable
fun SinhalaGrade10And11MasterHub(
  currentGrade: String = "10",
  modifier: Modifier = Modifier
) {
  var activeGrade by remember { mutableStateOf(if (currentGrade.contains("11")) "11" else "10") }
  var selectedCategoryIndex by remember { mutableIntStateOf(-1) }
  var showFullScreenModal by remember { mutableStateOf(false) }
  
  val categories = remember { SubjectMasterSinhala20x20.getCategories() }

  // Main Card Container with rich gradients to match Science Hub
  Card(
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1B4B)), // Deep Indigo
    border = BorderStroke(1.2.dp, Color(0xFF6366F1).copy(alpha = 0.6f)),
    modifier = modifier
      .fillMaxWidth()
      .testTag("sinhala_grade_10_11_master_hub")
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
              .background(Brush.linearGradient(listOf(Color(0xFF6366F1), Color(0xFF8B5CF6)))),
            contentAlignment = Alignment.Center
          ) {
            Text("✍️", fontSize = 16.sp)
          }
          Spacer(modifier = Modifier.width(8.dp))
          Column {
            Text(
              text = "සිංහල විෂය නිර්දේශ Master Hub",
              color = Color.White,
              fontSize = 13.sp,
              fontWeight = FontWeight.Bold
            )
            Text(
              text = "ව්‍යාකරණ • සාහිත්‍යය • රචනා • කරුණු 400",
              color = Color(0xFFC7D2FE),
              fontSize = 9.5.sp
            )
          }
        }

        Surface(
          color = Color(0xFF6366F1),
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
            color = if (isSelected) Color(0xFF6366F1) else Color.Transparent,
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
                modifier = Modifier.widthIn(max = 120.dp)
              )
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      // Content Display Area depending on Selected Module
      if (selectedCategoryIndex == -1) {
        SinhalaQuickOverviewGrid(
          categories = categories,
          onSelectModule = { selectedCategoryIndex = it }
        )
      } else {
        SinhalaInlineModuleContent(
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
  if (showFullScreenModal && selectedCategoryIndex != -1) {
    SinhalaGrade10And11MasterHubDialog(
      initialGrade = activeGrade,
      initialCategoryIndex = selectedCategoryIndex,
      categories = categories,
      onDismiss = { showFullScreenModal = false }
    )
  }
}

@Composable
fun SinhalaInlineModuleContent(
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
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text(category.icon, fontSize = 14.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = category.titleSinhala,
          fontSize = 11.5.sp,
          fontWeight = FontWeight.Bold,
          color = category.color
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

    // Sub-section List
    Column(
      modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      val items = category.points.filter {
        searchQuery.isBlank() || it.title.contains(searchQuery, true) || it.detail.contains(searchQuery, true)
      }.take(3) // Show a few in inline view

      if (items.isEmpty()) {
        Text("ගැළපෙන කරුණු හමු නොවීය.", color = Color(0xFF94A3B8), fontSize = 10.sp)
      } else {
        items.forEach { point ->
          SinhalaFactCompactCard(point, category.color)
        }
      }

      Button(
        onClick = onOpenFullscreen,
        colors = ButtonDefaults.buttonColors(containerColor = category.color),
        modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
        shape = RoundedCornerShape(8.dp)
      ) {
        Text("සියලු කරුණු 20 බලන්න (View All)", fontSize = 10.sp, fontWeight = FontWeight.Bold)
      }
    }
  }
}

@Composable
fun SinhalaFactCompactCard(point: SubjectFactPoint, themeColor: Color) {
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
 * 🌟 FULL SCREEN DEDICATED DIALOG FOR SINHALA 10 & 11 SYLLABUS MASTER HUB
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SinhalaGrade10And11MasterHubDialog(
  initialGrade: String,
  initialCategoryIndex: Int = -1,
  categories: List<SubjectMasterCategory>,
  onDismiss: () -> Unit
) {
  var activeGrade by remember { mutableStateOf(initialGrade) }
  var selectedCategoryIndex by remember { mutableIntStateOf(initialCategoryIndex) }

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
        .testTag("sinhala_10_11_fullscreen_dialog"),
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
                text = if (selectedCategoryIndex == -1) "සිංහල විෂය නිර්දේශ Hub" else categories[selectedCategoryIndex].titleSinhala,
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
              color = Color(0xFF4F46E5),
              modifier = Modifier.padding(horizontal = 4.dp)
            ) {
              Text(
                text = if (activeGrade == "10") "📘 10 වසර" else "📙 11 වසර",
                color = Color.White,
                fontSize = 10.5.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.5.dp)
              )
            }
          }
        }

        // CONTENT SECTION - FULL HEIGHT SCROLLABLE
        Box(modifier = Modifier.fillMaxSize()) {
          if (selectedCategoryIndex == -1) {
            // Quick Overview Grid (Scrollable)
            LazyColumn(
              modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
              contentPadding = PaddingValues(top = 8.dp, bottom = 28.dp),
              verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              item {
                SinhalaQuickOverviewGrid(
                  categories = categories,
                  onSelectModule = { selectedCategoryIndex = it }
                )
              }
            }
          } else {
            // Detailed Category View (Full Screen Scrollable 20 Facts)
            SubjectMaster20CategoriesDetailView(
              subjectName = "සිංහල",
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
          }
        }
      }
    }
  }
}

@Composable
fun SinhalaQuickOverviewGrid(
  categories: List<SubjectMasterCategory>,
  onSelectModule: (Int) -> Unit
) {
  Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
    // Grid Rows (2-column layout to match Science Hub)
    for (i in categories.indices step 2) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        SinhalaFeatureButton(
          category = categories[i],
          modifier = Modifier.weight(1f),
          onClick = { onSelectModule(i) }
        )
        if (i + 1 < categories.size) {
          SinhalaFeatureButton(
            category = categories[i + 1],
            modifier = Modifier.weight(1f),
            onClick = { onSelectModule(i + 1) }
          )
        } else {
          // Decorative fillers if odd number of sections
          SinhalaFeatureButton(
            category = null,
            customTitle = "AI උපදේශක",
            customIcon = "🤖",
            customSubtitle = "සිංහල AI සහාය",
            customColor = Color(0xFFDB2777),
            modifier = Modifier.weight(1f),
            onClick = { /* AI is already in AI tab, this is just for UI consistency */ }
          )
        }
      }
    }
  }
}

@Composable
fun SinhalaFeatureButton(
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
        color = Color(0xFFC7D2FE),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
      )
    }
  }
}

// -------------------------------------------------------------
// COMPACT COLLAPSIBLE CARD COMPONENTS (MINIMAL HEIGHT BY DEFAULT)
// -------------------------------------------------------------

@Composable
fun SinhalaGrammarRuleCard(rule: SinhalaGrammarRule) {
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
      // Compact Header with minimal height (~40dp)
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
              text = rule.ruleCategory,
              color = Color(0xFF60A5FA),
              fontSize = 9.5.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = rule.ruleTitle,
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
        // Quick summary line when collapsed
        Text(
          text = rule.corePrinciple,
          color = Color(0xFF94A3B8),
          fontSize = 11.sp,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier.padding(top = 2.dp)
        )
      } else {
        // Expanded Details
        Spacer(modifier = Modifier.height(8.dp))
        Divider(color = Color(0xFF334155), thickness = 0.8.dp)
        Spacer(modifier = Modifier.height(8.dp))

        // Core Principle
        Surface(
          color = Color(0xFF0F172A),
          shape = RoundedCornerShape(8.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Text(
            text = "📌 මූලික නීතිය: ${rule.corePrinciple}",
            color = Color(0xFFBAE6FD),
            fontSize = 11.5.sp,
            lineHeight = 16.sp,
            modifier = Modifier.padding(8.dp)
          )
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Rule Points
        rule.rulePoints.forEach { point ->
          Row(modifier = Modifier.padding(vertical = 2.dp)) {
            Text("•", color = Color(0xFF38BDF8), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(6.dp))
            Text(point, color = Color(0xFFE2E8F0), fontSize = 11.5.sp, lineHeight = 16.sp)
          }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Correct Examples Chips
        Text("නිවැරදි උදාහරණ:", color = Color(0xFF34D399), fontSize = 11.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Row(
          horizontalArrangement = Arrangement.spacedBy(4.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          rule.correctExamples.take(4).forEach { ex ->
            Surface(
              color = Color(0xFF065F46).copy(alpha = 0.5f),
              shape = RoundedCornerShape(4.dp)
            ) {
              Text(
                text = "✓ $ex",
                color = Color(0xFFA7F3D0),
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
          }
        }

        if (rule.commonMistakes.isNotEmpty()) {
          Spacer(modifier = Modifier.height(8.dp))
          Text("නිතර සිදුවන වැරදි සහ නිවැරදි කිරීම්:", color = Color(0xFFF87171), fontSize = 11.sp, fontWeight = FontWeight.Bold)
          Spacer(modifier = Modifier.height(4.dp))
          rule.commonMistakes.forEach { pair ->
            Row(
              modifier = Modifier.padding(vertical = 1.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text("✗ ${pair.first}", color = Color(0xFFFCA5A5), fontSize = 10.5.sp)
              Spacer(modifier = Modifier.width(6.dp))
              Text("➔", color = Color(0xFF94A3B8), fontSize = 10.sp)
              Spacer(modifier = Modifier.width(6.dp))
              Text("✓ ${pair.second}", color = Color(0xFF86EFAC), fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
            }
          }
        }

        Spacer(modifier = Modifier.height(6.dp))
        // Exam Tip
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
            Text(rule.examTip, color = Color(0xFFFEF08A), fontSize = 10.5.sp)
          }
        }
      }
    }
  }
}

@Composable
fun SinhalaLiteratureLessonCard(lesson: SinhalaLiteratureLesson) {
  var expanded by remember { mutableStateOf(false) }

  Card(
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
    border = BorderStroke(1.dp, Color(0xFF475569)),
    modifier = Modifier
      .fillMaxWidth()
      .animateContentSize(animationSpec = tween(200))
  ) {
    Column(modifier = Modifier.padding(10.dp)) {
      // Header Bar (Compact)
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
            color = when (lesson.lessonType) {
              "පද්‍ය" -> Color(0xFFDC2626)
              "ගද්‍ය" -> Color(0xFF2563EB)
              else -> Color(0xFF7C3AED)
            }.copy(alpha = 0.25f),
            shape = RoundedCornerShape(6.dp)
          ) {
            Text(
              text = "${lesson.lessonType} • ${lesson.grade} ශ්‍රේණිය",
              color = Color.White,
              fontSize = 9.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = lesson.title,
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
          text = "${lesson.sourceBook} • ${lesson.author}",
          color = Color(0xFF94A3B8),
          fontSize = 11.sp,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier.padding(top = 2.dp)
        )
      } else {
        Spacer(modifier = Modifier.height(8.dp))
        Divider(color = Color(0xFF334155), thickness = 0.8.dp)
        Spacer(modifier = Modifier.height(8.dp))

        // Source Book, Author, Era
        Surface(
          color = Color(0xFF0F172A),
          shape = RoundedCornerShape(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(8.dp)) {
            Text("📚 කෘතිය: ${lesson.sourceBook}", color = Color(0xFFE2E8F0), fontSize = 11.sp, fontWeight = FontWeight.Bold)
            Text("✍️ කතුවරයා: ${lesson.author}", color = Color(0xFFCBD5E1), fontSize = 11.sp)
            Text("🏛️ යුගය: ${lesson.historicalEra}", color = Color(0xFF94A3B8), fontSize = 10.5.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text("🎯 ප්‍රධාන තේමාව: ${lesson.mainTheme}", color = Color(0xFF67E8F9), fontSize = 11.sp, lineHeight = 15.sp)
          }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Appreciation Points
        Text("විචාරාත්මක අගය කිරීම් (Points for Essays):", color = Color(0xFFFBBF24), fontSize = 11.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        lesson.literaryAppreciationPoints.forEach { pt ->
          Row(modifier = Modifier.padding(vertical = 2.dp)) {
            Text("▪", color = Color(0xFFF59E0B), fontSize = 11.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Text(pt, color = Color(0xFFF1F5F9), fontSize = 11.5.sp, lineHeight = 16.sp)
          }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Key Quotations
        Text("අනිවාර්ය සාහිත්‍ය උපුටන & රස විවරණය:", color = Color(0xFF34D399), fontSize = 11.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        lesson.keyQuotationsWithMeaning.forEach { pair ->
          Surface(
            color = Color(0xFF064E3B).copy(alpha = 0.4f),
            shape = RoundedCornerShape(6.dp),
            border = BorderStroke(0.6.dp, Color(0xFF059669)),
            modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 3.dp)
          ) {
            Column(modifier = Modifier.padding(8.dp)) {
              Text(pair.first, color = Color(0xFFA7F3D0), fontSize = 11.sp, fontWeight = FontWeight.Bold)
              Spacer(modifier = Modifier.height(3.dp))
              Text("➔ ${pair.second}", color = Color(0xFFD1FAE5), fontSize = 10.5.sp, lineHeight = 15.sp)
            }
          }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Essay Outline
        Surface(
          color = Color(0xFF312E81).copy(alpha = 0.35f),
          shape = RoundedCornerShape(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(8.dp)) {
            Text("📝 විභාග ආදර්ශ විචාර සැකිල්ල (10/10 Outline):", color = Color(0xFFA5B4FC), fontSize = 11.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(lesson.modelEssayOutline, color = Color(0xFFE0E7FF), fontSize = 10.5.sp, lineHeight = 15.sp)
          }
        }
      }
    }
  }
}

@Composable
fun SinhalaWritingSkillCard(item: SinhalaWritingSkillItem) {
  var expanded by remember { mutableStateOf(false) }

  Card(
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
    border = BorderStroke(1.dp, Color(0xFF0D9488).copy(alpha = 0.5f)),
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
              text = item.category,
              color = Color(0xFF2DD4BF),
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
          text = "ලකුණු දීමේ නිර්ණායක සහ ආදර්ශ පිළිතුර සහිතයි",
          color = Color(0xFF94A3B8),
          fontSize = 11.sp,
          modifier = Modifier.padding(top = 2.dp)
        )
      } else {
        Spacer(modifier = Modifier.height(8.dp))
        Divider(color = Color(0xFF334155), thickness = 0.8.dp)
        Spacer(modifier = Modifier.height(8.dp))

        // Standard Format Steps
        Text("සම්මත ආකෘතිය හා පියවර:", color = Color(0xFF2DD4BF), fontSize = 11.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        item.standardFormat.forEach { step ->
          Row(modifier = Modifier.padding(vertical = 1.5.dp)) {
            Text("✓", color = Color(0xFF14B8A6), fontSize = 11.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Text(step, color = Color(0xFFE2E8F0), fontSize = 11.sp, lineHeight = 15.sp)
          }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Marking Criteria
        Text("ලකුණු බෙදී යන ආකාරය:", color = Color(0xFFFBBF24), fontSize = 11.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        item.markingCriteriaMarks.forEach { (criterion, mark) ->
          Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 1.dp),
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Text("• $criterion", color = Color(0xFFCBD5E1), fontSize = 10.5.sp)
            Text("ලකුණු $mark", color = Color(0xFFFDE047), fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
          }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Sample Prompt & Solution
        Surface(
          color = Color(0xFF0F172A),
          shape = RoundedCornerShape(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(8.dp)) {
            Text("ආදර්ශ ප්‍රශ්නය:", color = Color(0xFF94A3B8), fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
            Text(item.samplePrompt, color = Color.White, fontSize = 11.sp, fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)
            Spacer(modifier = Modifier.height(6.dp))
            Text("ආදර්ශ නිවැරදි විසඳුම:", color = Color(0xFF34D399), fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
            Text(item.sampleSolution, color = Color(0xFFD1FAE5), fontSize = 10.5.sp, lineHeight = 15.sp)
          }
        }
      }
    }
  }
}

@Composable
fun SinhalaVocabItemCard(item: SinhalaVocabItem) {
  var expanded by remember { mutableStateOf(false) }

  Card(
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
    border = BorderStroke(1.dp, Color(0xFFEA580C).copy(alpha = 0.35f)),
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
              fontSize = 9.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = item.phrase,
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
          text = "අර්ථය: ${item.contextualMeaning}",
          color = Color(0xFFCBD5E1),
          fontSize = 11.sp,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier.padding(top = 2.dp)
        )
      } else {
        Spacer(modifier = Modifier.height(6.dp))
        Divider(color = Color(0xFF334155), thickness = 0.8.dp)
        Spacer(modifier = Modifier.height(6.dp))

        Text("සැබෑ ගම්‍යමාන අර්ථය:", color = Color(0xFFF97316), fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
        Text(item.contextualMeaning, color = Color(0xFFFFEDD5), fontSize = 11.5.sp, fontWeight = FontWeight.SemiBold)

        Spacer(modifier = Modifier.height(4.dp))
        Text("වාච්‍යාර්ථය: ${item.literalMeaning}", color = Color(0xFF94A3B8), fontSize = 10.5.sp)

        Spacer(modifier = Modifier.height(6.dp))
        Surface(
          color = Color(0xFF0F172A),
          shape = RoundedCornerShape(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Text(
            text = "උදාහරණ වාක්‍යය: \"${item.exampleSentence}\"",
            color = Color(0xFFBAE6FD),
            fontSize = 11.sp,
            modifier = Modifier.padding(6.dp)
          )
        }
      }
    }
  }
}

@Composable
fun SinhalaRapidMcqCard(mcq: SinhalaRapidMcq) {
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
            text = mcq.topic,
            color = Color(0xFFA5B4FC),
            fontSize = 9.5.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
          )
        }
        if (isAnswered) {
          val isCorrect = selectedIndex == mcq.correctIndex
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
        text = mcq.question,
        color = Color.White,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 16.sp
      )

      Spacer(modifier = Modifier.height(8.dp))

      // Options
      mcq.options.forEachIndexed { idx, opt ->
        val isThisSelected = selectedIndex == idx
        val isThisCorrect = idx == mcq.correctIndex

        val optionBg = when {
          !isAnswered -> Color(0xFF0F172A)
          isThisCorrect -> Color(0xFF065F46)
          isThisSelected -> Color(0xFF7F1D1D)
          else -> Color(0xFF0F172A)
        }

        val borderColor = when {
          !isAnswered -> Color(0xFF334155)
          isThisCorrect -> Color(0xFF10B981)
          isThisSelected -> Color(0xFFEF4444)
          else -> Color(0xFF1E293B)
        }

        Surface(
          color = optionBg,
          shape = RoundedCornerShape(6.dp),
          border = BorderStroke(0.8.dp, borderColor),
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.5.dp)
            .clickable(enabled = !isAnswered) {
              selectedIndex = idx
            }
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "(${idx + 1})",
              color = Color(0xFF94A3B8),
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = opt,
              color = Color.White,
              fontSize = 11.sp
            )
          }
        }
      }

      if (isAnswered) {
        Spacer(modifier = Modifier.height(6.dp))
        Surface(
          color = Color(0xFF1E1B4B),
          shape = RoundedCornerShape(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Text(
            text = "💡 විවරණය: ${mcq.explanation}",
            color = Color(0xFFC7D2FE),
            fontSize = 10.5.sp,
            lineHeight = 15.sp,
            modifier = Modifier.padding(6.dp)
          )
        }
      }
    }
  }
}

@Composable
fun SinhalaExamSecretCard(title: String, details: String) {
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
fun SinhalaEmptySearchResultNotice() {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .padding(32.dp),
    contentAlignment = Alignment.Center
  ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      Text("🔍", fontSize = 28.sp)
      Spacer(modifier = Modifier.height(6.dp))
      Text(
        text = "සෙවුමට ගැළපෙන අංග හමු නොවීය",
        color = Color(0xFF94A3B8),
        fontSize = 12.5.sp
      )
    }
  }
}
