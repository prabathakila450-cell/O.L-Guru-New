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
 * 🌟 100% ACCURATE GRADE 10 & 11 DANCING MASTER HUB
 * Strictly adheres to the Sri Lankan G.C.E. O/L Dancing Syllabus.
 * Designed with the exact same architecture as Sinhala, History & Buddhism Master Hubs:
 * - Compact, low-height collapsible sub-sections (no text squishing or wrapping bugs)
 * - Full-screen dialog with BackHandler & system bars
 * - 2-Column Quick Overview Grid
 * - Inline module content preview with instant search
 * - Grade 10 & 11 toggles
 * - 20 Categories x 20 Facts (400 Facts Bank) + Special Syllabus Modules
 */
@Composable
fun DancingGrade10And11MasterHub(
  currentGrade: String = "10",
  onOpenFullHub: (DancingSectionCategory?) -> Unit = {},
  modifier: Modifier = Modifier
) {
  var activeGrade by remember { mutableStateOf(if (currentGrade.contains("11")) "11" else "10") }
  var selectedCategoryIndex by remember { mutableIntStateOf(-1) }
  var showFullScreenModal by remember { mutableStateOf(false) }

  val categories = remember { SubjectMasterDancingFull.getCategories() }

  Card(
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E0A12)),
    border = BorderStroke(1.2.dp, Color(0xFFE11D48).copy(alpha = 0.6f)),
    modifier = modifier
      .fillMaxWidth()
      .testTag("dancing_grade_10_11_master_hub")
  ) {
    Column(modifier = Modifier.padding(12.dp)) {
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
              .background(Brush.linearGradient(listOf(Color(0xFFE11D48), Color(0xFF881337)))),
            contentAlignment = Alignment.Center
          ) {
            Text("💃", fontSize = 16.sp)
          }
          Spacer(modifier = Modifier.width(8.dp))
          Column {
            Text(
              text = "නර්තනය විෂය නිර්දේශ Master Hub",
              color = Color.White,
              fontSize = 13.sp,
              fontWeight = FontWeight.Bold
            )
            Text(
              text = "සම්ප්‍රදාය • වන්නම් 18 • අභිනය • කරුණු 400",
              color = Color(0xFFFECDD3),
              fontSize = 9.5.sp
            )
          }
        }

        Surface(
          color = Color(0xFFE11D48),
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
            color = if (isSelected) Color(0xFFE11D48) else Color.Transparent,
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
                modifier = Modifier.widthIn(max = 130.dp)
              )
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      // Content Display Area depending on Selected Module
      if (selectedCategoryIndex == -1) {
        DancingQuickOverviewGrid(
          categories = categories,
          onSelectModule = { selectedCategoryIndex = it },
          onOpenFullHub = { onOpenFullHub(null) }
        )
      } else {
        DancingInlineModuleContent(
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
    DancingGrade10And11MasterHubDialog(
      initialGradeTab = if (activeGrade == "11") DancingGradeTab.GRADE_11 else DancingGradeTab.GRADE_10,
      initialCategoryIndex = selectedCategoryIndex,
      categories = categories,
      onDismiss = { showFullScreenModal = false }
    )
  }
}

@Composable
fun DancingQuickOverviewGrid(
  categories: List<SubjectMasterCategory>,
  onSelectModule: (Int) -> Unit,
  onOpenFullHub: () -> Unit
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF14050C))
      .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "🎯 විෂය නිර්දේශ ප්‍රධාන කාණ්ඩ (කාණ්ඩ 20)",
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFFECDD3)
      )
      TextButton(
        onClick = onOpenFullHub,
        contentPadding = PaddingValues(4.dp)
      ) {
        Text("සියල්ල බලන්න →", fontSize = 10.sp, color = Color(0xFFFF69B4))
      }
    }

    // 2-Column Grid of 20 Categories
    val chunked = categories.chunked(2)
    chunked.forEach { rowItems ->
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        rowItems.forEach { cat ->
          val originalIndex = categories.indexOf(cat)
          Surface(
            onClick = { onSelectModule(originalIndex) },
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFF240A18),
            border = BorderStroke(0.8.dp, cat.color.copy(alpha = 0.5f)),
            modifier = Modifier
              .weight(1f)
              .height(56.dp)
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(cat.icon, fontSize = 16.sp)
              Spacer(modifier = Modifier.width(6.dp))
              Column(modifier = Modifier.weight(1f)) {
                Text(
                  text = cat.titleSinhala,
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
                Text(
                  text = "කරුණු 20 • O/L",
                  fontSize = 8.5.sp,
                  color = Color(0xFFFDA4AF)
                )
              }
            }
          }
        }
        if (rowItems.size == 1) {
          Spacer(modifier = Modifier.weight(1f))
        }
      }
    }
  }
}

@Composable
fun DancingInlineModuleContent(
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
      .background(Color(0xFF14050C))
      .padding(8.dp)
  ) {
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

    OutlinedTextField(
      value = searchQuery,
      onValueChange = { searchQuery = it },
      placeholder = { Text("නර්තන කරුණු අතර සොයන්න...", fontSize = 9.5.sp, color = Color(0xFF94A3B8)) },
      singleLine = true,
      modifier = Modifier
        .fillMaxWidth()
        .height(44.dp)
        .padding(vertical = 2.dp),
      colors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = Color.White,
        unfocusedTextColor = Color.White,
        focusedBorderColor = category.color,
        unfocusedBorderColor = Color(0xFF4C0519),
        focusedContainerColor = Color(0xFF240A18),
        unfocusedContainerColor = Color(0xFF240A18)
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
          DancingFactCompactCard(point, category.color)
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
fun DancingFactCompactCard(point: SubjectFactPoint, themeColor: Color) {
  Surface(
    shape = RoundedCornerShape(8.dp),
    color = Color(0xFF240A18),
    border = BorderStroke(0.8.dp, Color(0xFF4C0519)),
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
        Text(text = point.detail, color = Color(0xFFFDA4AF), fontSize = 9.5.sp, maxLines = 2, overflow = TextOverflow.Ellipsis)
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DancingGrade10And11MasterHubDialog(
  initialGradeTab: DancingGradeTab = DancingGradeTab.ALL,
  initialCategoryIndex: Int = -1,
  initialSectionCategory: DancingSectionCategory? = null,
  categories: List<SubjectMasterCategory> = SubjectMasterDancingFull.getCategories(),
  onDismiss: () -> Unit
) {
  val computedIndex = when {
    initialCategoryIndex >= 0 -> initialCategoryIndex
    initialSectionCategory != null -> when (initialSectionCategory) {
      DancingSectionCategory.TRADITIONS_AND_DRUMS -> 0
      DancingSectionCategory.VANNAM_18 -> 1
      DancingSectionCategory.ABHINAYA_AND_MUDRAS -> 2
      DancingSectionCategory.INSTRUMENTS_AND_COSTUMES -> 3
      DancingSectionCategory.PRACTICAL_AND_VIVA -> 4
      DancingSectionCategory.EXAM_MCQ_AND_ESSAYS -> 5
      DancingSectionCategory.LESSONS_AND_NOTES -> 6
    }
    else -> -1
  }
  var selectedCategoryNumber by remember { mutableIntStateOf(if (computedIndex >= 0) computedIndex + 1 else 0) }

  BackHandler {
    onDismiss()
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
        .testTag("dancing_10_11_fullscreen_dialog"),
      color = Color(0xFF1E0A12)
    ) {
      Column(modifier = Modifier.fillMaxSize()) {
        // ULTRA-COMPACT TOP APP BAR (Single slim row, ~44dp height)
        Surface(
          color = Color(0xFF2A0815),
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
                onClick = onDismiss,
                modifier = Modifier.size(36.dp)
              ) {
                Icon(
                  imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                  contentDescription = "Back",
                  tint = Color.White
                )
              }
              Spacer(modifier = Modifier.width(4.dp))
              Text(
                text = if (selectedCategoryNumber > 0 && selectedCategoryNumber <= categories.size) categories[selectedCategoryNumber - 1].titleSinhala else "නර්තනය විෂය නිර්දේශ Master Hub",
                color = Color.White,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
              )
            }

            Surface(
              color = Color(0xFFE11D48),
              shape = RoundedCornerShape(12.dp),
              modifier = Modifier.padding(horizontal = 4.dp)
            ) {
              Text(
                text = "💃 නර්තනය",
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.5.dp)
              )
            }
          }
        }

        // Use SubjectMaster20CategoriesDetailView
        SubjectMaster20CategoriesDetailView(
          subjectName = "නර්තනය",
          categories = categories,
          selectedCategoryNumber = selectedCategoryNumber,
          onSelectCategory = { selectedCategoryNumber = it },
          modifier = Modifier.weight(1f)
        )
      }
    }
  }
}
