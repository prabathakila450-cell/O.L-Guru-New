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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy

enum class AgriGradeTab(val labelSin: String) {
  ALL("සියල්ල (10 & 11)"),
  GRADE_10("10 ශ්‍රේණිය"),
  GRADE_11("11 ශ්‍රේණිය (O/L)")
}

enum class AgriSectionCategory(
  val icon: String,
  val titleSin: String,
  val colorVal: Long
) {
  LESSONS("📚", "පාඩම් & සටහන්", 0xFF15803D),
  MCQ_BANK("🎯", "MCQ ප්‍රශ්න", 0xFF2563EB),
  STRUCTURED_ESSAY("📝", "ව්‍යූහගත & රචනා", 0xFF7C3AED),
  PRACTICAL_GUIDE("🔬", "ප්‍රායෝගික අත්පොත", 0xFF0D9488),
  SOIL_PLANT_TECH("🌱", "පස & ශාක", 0xFF059669),
  FARM_MACHINERY("🚜", "යන්ත්‍ර සූත්‍ර", 0xFFD97706),
  CROPS_LIVESTOCK("🌾", "බෝග & සත්ත්ව", 0xFFB91C1C),
  PEST_ORGANIC("🐛", "පලිබෝධ & කාබනික", 0xFF16A34A),
  AGRI_BUSINESS("📊", "කෘෂි ව්‍යාපාර", 0xFF0284C7),
  MASTER_TARGET("🏆", "A+ මාස්ටර්", 0xFFDC2626)
}

data class AgriLessonUnit(
  val id: String,
  val grade: String, // "10" or "11"
  val unitNumber: Int,
  val titleSin: String,
  val category: AgriSectionCategory,
  val summarySin: String,
  val keyPoints: List<String>,
  val examTips: String
)

data class AgriMcqItem(
  val id: Int,
  val grade: String,
  val questionSin: String,
  val options: List<String>,
  val correctIndex: Int,
  val explanationSin: String
)

data class AgriEssayQuestion(
  val id: Int,
  val grade: String,
  val titleSin: String,
  val scenarioSin: String,
  val pointsToInclude: List<String>,
  val markingSchemeSin: String
)

data class AgriPracticalExperiment(
  val id: Int,
  val titleSin: String,
  val objectiveSin: String,
  val apparatusSin: List<String>,
  val procedureSin: List<String>,
  val observationsSin: String,
  val precautionsSin: String
)

/**
 * 🌟 100% EXCLUSIVE GRADE 10 & 11 AGRICULTURE MASTER HUB
 * Displays ONLY inside Agriculture Subject ("කෘෂිකර්මය" / "කෘෂි හා ආහාර තාක්ෂණය").
 * Sub-sections grid: 4 items per row horizontally going downwards.
 * Scrollable top-to-bottom across the ENTIRE screen.
 */
@Composable
fun AgricultureGrade10And11MasterHubDialog(
  initialGradeTab: AgriGradeTab = AgriGradeTab.ALL,
  initialSectionCategory: AgriSectionCategory? = null,
  onDismiss: () -> Unit
) {
  var selectedGradeTab by remember { mutableStateOf(initialGradeTab) }
  var selectedCategory by remember { mutableStateOf(initialSectionCategory ?: AgriSectionCategory.LESSONS) }
  var searchQuery by remember { mutableStateOf("") }

  // State for interactive MCQ test
  val userSelectedMcqOptions = remember { mutableStateMapOf<Int, Int>() }

  // Expanded items state
  var expandedLessonId by remember { mutableStateOf<String?>(null) }
  var expandedEssayId by remember { mutableStateOf<Int?>(null) }
  var expandedPracticalId by remember { mutableStateOf<Int?>(null) }

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
        .testTag("agriculture_master_hub_dialog"),
      color = Color(0xFF0F1A12)
    ) {
      LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 60.dp)
      ) {
        // 1. TOP APP BAR
        item(key = "agri_top_app_bar") {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .background(
                Brush.verticalGradient(
                  colors = listOf(Color(0xFF15803D), Color(0xFF166534))
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
                      text = "🌱 10 & 11 කෘෂිකර්මය Master Hub",
                      color = Color.White,
                      fontSize = 15.sp,
                      fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Surface(
                      color = Color(0xFFEAB308),
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
                    text = "කෘෂි හා ආහාර තාක්ෂණය • අනු කොටස් 10 සම්පූර්ණ මාර්ගෝපදේශය",
                    color = Color(0xFFBBF7D0),
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
        item(key = "agri_grade_tabs") {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 12.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            AgriGradeTab.entries.forEach { tab ->
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
                  selectedContainerColor = Color(0xFF22C55E),
                  selectedLabelColor = Color.White,
                  containerColor = Color(0xFF1E2923),
                  labelColor = Color(0xFF86EFAC)
                ),
                border = FilterChipDefaults.filterChipBorder(
                  enabled = true,
                  selected = isSelected,
                  borderColor = Color(0xFF4ADE80),
                  selectedBorderColor = Color(0xFF86EFAC)
                ),
                modifier = Modifier.weight(1f)
              )
            }
          }
        }

        // 3. SEARCH BAR
        item(key = "agri_search_bar") {
          OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = {
              Text(
                "කෘෂිකර්ම පාඩම්, පස, යන්ත්‍ර, MCQs හෝ රචනා සොයන්න...",
                fontSize = 11.sp,
                color = Color(0xFF86EFAC).copy(alpha = 0.6f)
              )
            },
            leadingIcon = {
              Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color(0xFF4ADE80)
              )
            },
            trailingIcon = {
              if (searchQuery.isNotEmpty()) {
                IconButton(onClick = { searchQuery = "" }) {
                  Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "Clear",
                    tint = Color.White
                  )
                }
              }
            },
            singleLine = true,
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
              focusedContainerColor = Color(0xFF142419),
              unfocusedContainerColor = Color(0xFF142419),
              focusedBorderColor = Color(0xFF4ADE80),
              unfocusedBorderColor = Color(0xFF1E3A28),
              focusedTextColor = Color.White,
              unfocusedTextColor = Color.White
            ),
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 12.dp, vertical = 4.dp)
          )
        }

        // 4. SUB-SECTION CATEGORIES GRID (4 ITEMS HORIZONTALLY PER ROW GOING DOWNWARDS)
        item(key = "agri_categories_4_per_row_grid") {
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 8.dp, vertical = 6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            val categoryChunks = AgriSectionCategory.entries.chunked(4)
            categoryChunks.forEach { rowCategories ->
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
              ) {
                rowCategories.forEach { category ->
                  val isSelected = selectedCategory == category
                  val catColor = Color(category.colorVal)

                  Surface(
                    onClick = { selectedCategory = category },
                    shape = RoundedCornerShape(8.dp),
                    color = if (isSelected) catColor else Color(0xFF16251B),
                    border = BorderStroke(
                      width = if (isSelected) 2.dp else 1.dp,
                      color = if (isSelected) Color(0xFF86EFAC) else Color(0xFF233B2C)
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
                        text = category.icon,
                        fontSize = 16.sp
                      )
                      Spacer(modifier = Modifier.height(2.dp))
                      Text(
                        text = category.titleSin,
                        fontSize = 9.sp,
                        fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Medium,
                        color = if (isSelected) Color.White else Color(0xFFDCFCE7),
                        textAlign = TextAlign.Center,
                        maxLines = 2,
                        lineHeight = 10.sp,
                        overflow = TextOverflow.Ellipsis
                      )
                    }
                  }
                }

                // Fill missing columns in last row if not a multiple of 4
                if (rowCategories.size < 4) {
                  repeat(4 - rowCategories.size) {
                    Spacer(modifier = Modifier.weight(1f))
                  }
                }
              }
            }
          }
        }

        // 5. SELECTED CATEGORY BANNER HEADER
        item(key = "agri_selected_category_header") {
          Surface(
            color = Color(selectedCategory.colorVal).copy(alpha = 0.25f),
            border = BorderStroke(1.dp, Color(selectedCategory.colorVal)),
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
                text = selectedCategory.icon,
                fontSize = 24.sp
              )
              Spacer(modifier = Modifier.width(10.dp))
              Column {
                Text(
                  text = "අනු කොටස ${selectedCategory.ordinal + 1}: ${selectedCategory.titleSin}",
                  color = Color.White,
                  fontSize = 13.sp,
                  fontWeight = FontWeight.Bold
                )
                Text(
                  text = getCategoryDescription(selectedCategory),
                  color = Color(0xFF86EFAC),
                  fontSize = 10.5.sp
                )
              }
            }
          }
        }

        // 6. CONTENT ITEMS BASED ON SELECTED CATEGORY & SEARCH
        when (selectedCategory) {
          AgriSectionCategory.LESSONS -> {
            val lessons = getSampleAgriLessons().filter { lesson ->
              val matchesGrade = when (selectedGradeTab) {
                AgriGradeTab.GRADE_10 -> lesson.grade == "10"
                AgriGradeTab.GRADE_11 -> lesson.grade == "11"
                AgriGradeTab.ALL -> true
              }
              val matchesSearch = searchQuery.isEmpty() ||
                lesson.titleSin.contains(searchQuery, ignoreCase = true) ||
                lesson.summarySin.contains(searchQuery, ignoreCase = true)
              matchesGrade && matchesSearch
            }

            if (lessons.isEmpty()) {
              item(key = "no_lessons_found") {
                NoContentPlaceholder("සොයන ලද කෘෂිකර්ම පාඩම් හමුවූයේ නැත.")
              }
            } else {
              items(lessons, key = { "lesson_${it.id}" }) { lesson ->
                val isExpanded = expandedLessonId == lesson.id
                Card(
                  shape = RoundedCornerShape(10.dp),
                  colors = CardDefaults.cardColors(containerColor = Color(0xFF14241A)),
                  border = BorderStroke(1.dp, Color(0xFF22C55E).copy(alpha = 0.4f)),
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 4.dp)
                    .clickable {
                      expandedLessonId = if (isExpanded) null else lesson.id
                    }
                ) {
                  Column(modifier = Modifier.padding(12.dp)) {
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.SpaceBetween,
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                          color = Color(0xFF166534),
                          shape = RoundedCornerShape(4.dp)
                        ) {
                          Text(
                            text = "${lesson.grade} ශ්‍රේණිය • ඒකකය ${lesson.unitNumber}",
                            color = Color.White,
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                          )
                        }
                      }
                      Icon(
                        imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = "Expand",
                        tint = Color(0xFF4ADE80)
                      )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                      text = lesson.titleSin,
                      color = Color.White,
                      fontSize = 13.5.sp,
                      fontWeight = FontWeight.Bold
                    )

                    Text(
                      text = lesson.summarySin,
                      color = Color(0xFFBBF7D0),
                      fontSize = 11.sp,
                      modifier = Modifier.padding(top = 3.dp)
                    )

                    AnimatedVisibility(
                      visible = isExpanded,
                      enter = expandVertically() + fadeIn(),
                      exit = shrinkVertically() + fadeOut()
                    ) {
                      Column(modifier = Modifier.padding(top = 8.dp)) {
                        HorizontalDivider(color = Color(0xFF233B2C), thickness = 1.dp)
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                          text = "💡 ප්‍රධාන විභාග කරුණු:",
                          color = Color(0xFFEAB308),
                          fontSize = 11.sp,
                          fontWeight = FontWeight.Bold
                        )

                        lesson.keyPoints.forEachIndexed { idx, pt ->
                          Row(modifier = Modifier.padding(vertical = 2.dp)) {
                            Text("• ", color = Color(0xFF4ADE80), fontSize = 11.sp)
                            Text(pt, color = Color.White, fontSize = 11.sp)
                          }
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Surface(
                          color = Color(0xFF152D1D),
                          shape = RoundedCornerShape(6.dp),
                          border = BorderStroke(1.dp, Color(0xFF22C55E))
                        ) {
                          Row(
                            modifier = Modifier.padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                          ) {
                            Text("🎓 ", fontSize = 14.sp)
                            Text(
                              text = "O/L විභාග උපදෙස: ${lesson.examTips}",
                              color = Color(0xFF86EFAC),
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

          AgriSectionCategory.MCQ_BANK -> {
            val mcqs = getSampleAgriMcqs().filter { mcq ->
              val matchesGrade = when (selectedGradeTab) {
                AgriGradeTab.GRADE_10 -> mcq.grade == "10"
                AgriGradeTab.GRADE_11 -> mcq.grade == "11"
                AgriGradeTab.ALL -> true
              }
              val matchesSearch = searchQuery.isEmpty() ||
                mcq.questionSin.contains(searchQuery, ignoreCase = true)
              matchesGrade && matchesSearch
            }

            if (mcqs.isEmpty()) {
              item(key = "no_mcq_found") {
                NoContentPlaceholder("සොයන ලද MCQ ප්‍රශ්න හමුවූයේ නැත.")
              }
            } else {
              itemsIndexed(mcqs, key = { _, item -> "mcq_${item.id}" }) { idx, mcq ->
                val userChoice = userSelectedMcqOptions[mcq.id]

                Card(
                  shape = RoundedCornerShape(10.dp),
                  colors = CardDefaults.cardColors(containerColor = Color(0xFF14241A)),
                  border = BorderStroke(1.dp, Color(0xFF2563EB).copy(alpha = 0.5f)),
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 5.dp)
                ) {
                  Column(modifier = Modifier.padding(12.dp)) {
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                      Text(
                        text = "ප්‍රශ්නය ${idx + 1} (${mcq.grade} ශ්‍රේණිය O/L)",
                        color = Color(0xFF60A5FA),
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Bold
                      )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                      text = mcq.questionSin,
                      color = Color.White,
                      fontSize = 12.5.sp,
                      fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    mcq.options.forEachIndexed { optIdx, optText ->
                      val isSelected = userChoice == optIdx
                      val isCorrect = optIdx == mcq.correctIndex
                      val btnColor = when {
                        userChoice != null && isCorrect -> Color(0xFF15803D)
                        userChoice != null && isSelected && !isCorrect -> Color(0xFFB91C1C)
                        else -> Color(0xFF1C2D22)
                      }

                      Surface(
                        onClick = { userSelectedMcqOptions[mcq.id] = optIdx },
                        shape = RoundedCornerShape(6.dp),
                        color = btnColor,
                        border = BorderStroke(1.dp, if (isSelected) Color.White else Color(0xFF2D4536)),
                        modifier = Modifier
                          .fillMaxWidth()
                          .padding(vertical = 2.dp)
                      ) {
                        Row(
                          modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                          verticalAlignment = Alignment.CenterVertically
                        ) {
                          Text(
                            text = "(${optIdx + 1}) ",
                            color = Color(0xFF93C5FD),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                          )
                          Text(
                            text = optText,
                            color = Color.White,
                            fontSize = 11.sp
                          )
                        }
                      }
                    }

                    if (userChoice != null) {
                      Spacer(modifier = Modifier.height(8.dp))
                      Surface(
                        color = Color(0xFF132238),
                        shape = RoundedCornerShape(6.dp),
                        border = BorderStroke(1.dp, Color(0xFF3B82F6))
                      ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                          Text(
                            text = if (userChoice == mcq.correctIndex) "✅ නිවැරදියි!" else "❌ වැරදියි! නිවැරදි පිළිතුර: (${mcq.correctIndex + 1})",
                            color = if (userChoice == mcq.correctIndex) Color(0xFF4ADE80) else Color(0xFFFCA5A5),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                          )
                          Text(
                            text = "විවරණය: ${mcq.explanationSin}",
                            color = Color(0xFFBFDBFE),
                            fontSize = 10.5.sp,
                            modifier = Modifier.padding(top = 2.dp)
                          )
                        }
                      }
                    }
                  }
                }
              }
            }
          }

          AgriSectionCategory.STRUCTURED_ESSAY -> {
            val essays = getSampleAgriEssays().filter { essay ->
              val matchesGrade = when (selectedGradeTab) {
                AgriGradeTab.GRADE_10 -> essay.grade == "10"
                AgriGradeTab.GRADE_11 -> essay.grade == "11"
                AgriGradeTab.ALL -> true
              }
              val matchesSearch = searchQuery.isEmpty() ||
                essay.titleSin.contains(searchQuery, ignoreCase = true)
              matchesGrade && matchesSearch
            }

            if (essays.isEmpty()) {
              item(key = "no_essays_found") {
                NoContentPlaceholder("සොයන ලද ව්‍යූහගත/රචනා ප්‍රශ්න හමුවූයේ නැත.")
              }
            } else {
              items(essays, key = { "essay_${it.id}" }) { essay ->
                val isExpanded = expandedEssayId == essay.id
                Card(
                  shape = RoundedCornerShape(10.dp),
                  colors = CardDefaults.cardColors(containerColor = Color(0xFF14241A)),
                  border = BorderStroke(1.dp, Color(0xFF7C3AED).copy(alpha = 0.5f)),
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 5.dp)
                    .clickable {
                      expandedEssayId = if (isExpanded) null else essay.id
                    }
                ) {
                  Column(modifier = Modifier.padding(12.dp)) {
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.SpaceBetween,
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Surface(
                        color = Color(0xFF581C87),
                        shape = RoundedCornerShape(4.dp)
                      ) {
                        Text(
                          text = "${essay.grade} ශ්‍රේණිය O/L ව්‍යූහගත ප්‍රශ්නය",
                          color = Color.White,
                          fontSize = 9.5.sp,
                          fontWeight = FontWeight.Bold,
                          modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                      }
                      Icon(
                        imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = "Expand",
                        tint = Color(0xFFC084FC)
                      )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                      text = essay.titleSin,
                      color = Color.White,
                      fontSize = 13.sp,
                      fontWeight = FontWeight.Bold
                    )

                    Text(
                      text = essay.scenarioSin,
                      color = Color(0xFFE9D5FF),
                      fontSize = 11.sp,
                      modifier = Modifier.padding(top = 3.dp)
                    )

                    AnimatedVisibility(
                      visible = isExpanded,
                      enter = expandVertically() + fadeIn(),
                      exit = shrinkVertically() + fadeOut()
                    ) {
                      Column(modifier = Modifier.padding(top = 8.dp)) {
                        HorizontalDivider(color = Color(0xFF3B2554), thickness = 1.dp)
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                          text = "📝 පිළිතුරට ඇතුළත් විය යුතු ප්‍රධාන කරුණු:",
                          color = Color(0xFFFDE047),
                          fontSize = 11.sp,
                          fontWeight = FontWeight.Bold
                        )

                        essay.pointsToInclude.forEach { pt ->
                          Row(modifier = Modifier.padding(vertical = 2.dp)) {
                            Text("👉 ", fontSize = 10.sp)
                            Text(pt, color = Color.White, fontSize = 10.5.sp)
                          }
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Surface(
                          color = Color(0xFF2C133E),
                          shape = RoundedCornerShape(6.dp),
                          border = BorderStroke(1.dp, Color(0xFFA855F7))
                        ) {
                          Column(modifier = Modifier.padding(8.dp)) {
                            Text(
                              text = "🏆 ලකුණු පටිපාටිය (Marking Scheme Summary):",
                              color = Color(0xFFE9D5FF),
                              fontSize = 10.5.sp,
                              fontWeight = FontWeight.Bold
                            )
                            Text(
                              text = essay.markingSchemeSin,
                              color = Color.White,
                              fontSize = 10.5.sp,
                              modifier = Modifier.padding(top = 2.dp)
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

          AgriSectionCategory.PRACTICAL_GUIDE -> {
            val practicals = getSampleAgriPracticals().filter { prac ->
              searchQuery.isEmpty() || prac.titleSin.contains(searchQuery, ignoreCase = true)
            }

            if (practicals.isEmpty()) {
              item(key = "no_practicals_found") {
                NoContentPlaceholder("සොයන ලද ප්‍රායෝගික පරීක්ෂණ හමුවූයේ නැත.")
              }
            } else {
              items(practicals, key = { "prac_${it.id}" }) { prac ->
                val isExpanded = expandedPracticalId == prac.id
                Card(
                  shape = RoundedCornerShape(10.dp),
                  colors = CardDefaults.cardColors(containerColor = Color(0xFF14241A)),
                  border = BorderStroke(1.dp, Color(0xFF0D9488).copy(alpha = 0.5f)),
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 5.dp)
                    .clickable {
                      expandedPracticalId = if (isExpanded) null else prac.id
                    }
                ) {
                  Column(modifier = Modifier.padding(12.dp)) {
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.SpaceBetween,
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Surface(
                        color = Color(0xFF115E59),
                        shape = RoundedCornerShape(4.dp)
                      ) {
                        Text(
                          text = "🔬 ප්‍රායෝගික පරීක්ෂණය ${prac.id}",
                          color = Color.White,
                          fontSize = 9.5.sp,
                          fontWeight = FontWeight.Bold,
                          modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                      }
                      Icon(
                        imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = "Expand",
                        tint = Color(0xFF2DD4BF)
                      )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                      text = prac.titleSin,
                      color = Color.White,
                      fontSize = 13.sp,
                      fontWeight = FontWeight.Bold
                    )

                    Text(
                      text = "අරමුණ: ${prac.objectiveSin}",
                      color = Color(0xFF99F6E4),
                      fontSize = 11.sp,
                      modifier = Modifier.padding(top = 2.dp)
                    )

                    AnimatedVisibility(
                      visible = isExpanded,
                      enter = expandVertically() + fadeIn(),
                      exit = shrinkVertically() + fadeOut()
                    ) {
                      Column(modifier = Modifier.padding(top = 8.dp)) {
                        HorizontalDivider(color = Color(0xFF134E4A), thickness = 1.dp)
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                          text = "🧰 අවශ්‍ය ද්‍රව්‍ය හා උපකරණ:",
                          color = Color(0xFFFDE047),
                          fontSize = 11.sp,
                          fontWeight = FontWeight.Bold
                        )
                        prac.apparatusSin.forEach { app ->
                          Text("• $app", color = Color.White, fontSize = 10.5.sp)
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                          text = "⚙️ ක්‍රියාපටිපාටිය:",
                          color = Color(0xFF2DD4BF),
                          fontSize = 11.sp,
                          fontWeight = FontWeight.Bold
                        )
                        prac.procedureSin.forEachIndexed { stepIdx, step ->
                          Text("${stepIdx + 1}. $step", color = Color.White, fontSize = 10.5.sp)
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                          text = "👀 නිරීක්ෂණ & නිගමනය: ${prac.observationsSin}",
                          color = Color(0xFFCCFBF1),
                          fontSize = 10.5.sp,
                          fontWeight = FontWeight.SemiBold
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                          text = "⚠️ ආරක්ෂිත උපදෙස්: ${prac.precautionsSin}",
                          color = Color(0xFFFEF08A),
                          fontSize = 10.sp
                        )
                      }
                    }
                  }
                }
              }
            }
          }

          AgriSectionCategory.SOIL_PLANT_TECH -> {
            item(key = "soil_plant_tech_content") {
              AgriInfoSectionCard(
                title = "🌱 පස, පොහොර & ශාක පෝෂණය මාර්ගෝපදේශය",
                color = Color(0xFF059669),
                content = listOf(
                  "1. පසෙහි භෞතික ගුණ: පස් වියමන (Sand, Silt, Clay) සහ පස් ව්‍යුහය. ජල රඳවා ගැනීමේ හැකියාව වැඩිම පස් වර්ගය මැටි පසයි.",
                  "2. පසෙහි pH අගය: ශාක වර්ධනයට සුදුසුම pH අගය 6.0 - 7.0 (මඳ ආම්ලික/උදාසීන). ආම්ලික පස් සඳහා හුණු (Lime/CaCO3) ද අල්කාලීන පස් සඳහා ගන්ධක (Sulfur) ද යොදයි.",
                  "3. ප්‍රධාන ශාක පෝෂක (Macro elements): නයිට්‍රජන් (N - පත්‍ර වර්ධනයට), පොස්පරස් (P - මුල් වර්ධනයට), පොටෑසියම් (K - ඵල හටගැනීමට හා රෝග ප්‍රතිරෝධයට).",
                  "4. පොහොර භාවිතය: යූරියා (N - 46%), ත්‍රිත්ව සුපර් පොස්පේට් (TSP - 46% P2O5), මුරියේට් ඔෆ් පොටෑෂ් (MOP - 60% K2O).",
                  "5. කාබනික පොහොර: කොම්පෝස්ට්, කොළ පොහොර (සූරියකාන්ත, සෙවන, බොගන්විලියා) සහ ගොම/කුකුළු පොහොර මඟින් පසෙහි ව්‍යුහය හා ජල රඳවා ගැනීම වැඩි කරයි."
                )
              )
            }
          }

          AgriSectionCategory.FARM_MACHINERY -> {
            item(key = "farm_machinery_content") {
              AgriInfoSectionCard(
                title = "🚜 කෘෂිකාර්මික යන්ත්‍ර, උපකරණ & යාන්ත්‍රිකකරණය",
                color = Color(0xFFD97706),
                content = listOf(
                  "1. බිම් සකස් කිරීමේ උපකරණ: මෝල්ඩ්බෝඩ් නගුල (ප්‍රාථමික බිම් සැකසුම - පස යටිකුරු කිරීම), තැටි නගුල (තද පස් සඳහා), රොටවේටරය (ද්විතීයික බිම් සැකසුම - පස් කැට කුඩු කිරීම).",
                  "2. ජලසම්පාදන ක්‍රම: බිංදු ජලසම්පාදනය (Drip Irrigation - 90%+ කාර්යක්ෂමතාව, ජල නාස්තිය අවමයි), විසුරුම් ජලසම්පාදනය (Sprinkler Irrigation).",
                  "3. වල් පැළෑටි පාලන යන්ත්‍ර: අත් වල් නෙළනය (Japanese Rotary Weeder), පවර් වීඩර්.",
                  "4. අස්වැන්න නෙළීමේ යන්ත්‍ර: ඒකාබද්ධ අස්වනු නෙළන යන්ත්‍රය (Combine Harvester - ගොයම් කැපීම, කොළ කිරීම හා පෑරීම එකවර සිදු කරයි).",
                  "5. ආරක්ෂිත උපකරණ: විෂබීජ/කෘමිනාශක ඉසීමේදී මුහුණු ආවරණ, අත්වැසුම් සහ බූට් සපත්තු භාවිතය අනිවාර්ය වේ."
                )
              )
            }
          }

          AgriSectionCategory.CROPS_LIVESTOCK -> {
            item(key = "crops_livestock_content") {
              AgriInfoSectionCard(
                title = "🌾 බෝග වගාව & සත්ත්ව පාලනය (Crops & Livestock)",
                color = Color(0xFFB91C1C),
                content = listOf(
                  "1. වී වගාව: පාරම්පරික හා නව වැඩිදියුණු කළ ප්‍රභේද (Bg, Ld, At). පැළ සිටුවීම සහ සෘජු බීජ වැපිරීම.",
                  "2. එළවළු & පලතුරු වගාව: බීජ තවාන් සැකසීම, පැළ බද්ධ කිරීම (Grafting, Budding, Layering) මඟින් මව් ශාකයේ ගුණාංග 100% ආරක්ෂා වේ.",
                  "3. කිරි ගව පාලනය: දේශීය හා විදේශීය ගව ප්‍රභේද (Friesian, Jersey, Sahiwal). සයිලේජ් (Silage) හා පිදුරු මඟින් පෝෂණය සැපයීම.",
                  "4. කුකුළු පාලනය: බ්‍රොයිලර් (මස් පිණිස) සහ ලේයර් (බිත්තර පිණිස) කුකුළන්. දීප්තිමත් ආලෝකය හා නිවැරදි උෂ්ණත්ව පාලනය.",
                  "5. සාගර & ජලජීවී වගාව: තිලාපියා, කරදිය ඉස්සන් වගාව සහ විසිතුරු මසුන් ඇති කිරීම."
                )
              )
            }
          }

          AgriSectionCategory.PEST_ORGANIC -> {
            item(key = "pest_organic_content") {
              AgriInfoSectionCard(
                title = "🐛 පලිබෝධ පාලනය, කාබනික කෘෂිකර්මය & ජලජ වගාව",
                color = Color(0xFF16A34A),
                content = listOf(
                  "1. ඒකාබද්ධ පලිබෝධ කළමනාකරණය (IPM): යාන්ත්‍රික, භෞතික, ජෛව විද්‍යාත්මක හා රසායනික ක්‍රම සුයෝගීව භාවිතය.",
                  "2. ජෛව පලිබෝධ පාලනය: විලෝපිකයන් (Ladybird beetles) සහ පරපෝෂිතයන් භාවිතයෙන් පළිබෝධකයන් පාලනය.",
                  "3. කාබනික සහතිකකරණය: රසායනික පොහොර හා කෘමිනාශක භාවිතයෙන් තොරව ස්වභාවික යෙදවුම් පමණක් යොදා ගැනීම.",
                  "4. ජලජ වගාව (Hydroponics): NFT (Nutrient Film Technique) සහ Deep Flow systems මඟින් පස් රහිතව පෝෂක ද්‍රාවණ තුළ එළවළු වගාව.",
                  "5. ඇක්වාපොනික්ස් (Aquaponics): මාළු ඇතිකිරීම සහ හයිඩ්‍රොපොනික්ස් වගාව එකිනෙකට සම්බන්ධ කර ජලය හා පෝෂක ප්‍රතිචක්‍රීකරණය කිරීම."
                )
              )
            }
          }

          AgriSectionCategory.AGRI_BUSINESS -> {
            item(key = "agri_business_content") {
              AgriInfoSectionCard(
                title = "📊 කෘෂි ව්‍යාපාර, පසු අස්වනු තාක්ෂණය & ආර්ථික විද්‍යාව",
                color = Color(0xFF0284C7),
                content = listOf(
                  "1. පසු අස්වනු හානිය (Post-harvest Loss): ශ්‍රී ලංකාවේ එළවළු හා පලතුරු අස්වැන්නෙන් 30%-40% ප්‍රමාණයක් නුසුදුසු ඇසුරුම් හා ප්‍රවාහනය නිසා විනාශ වේ. ප්ලාස්ටික් කූඩ (Crates) භාවිතයෙන් හානිය අවම කළ හැක.",
                  "2. අගය එකතු කිරීම (Value Addition): පලතුරු යුෂ, ජෑම්, කෝඩියල්, වියළි එළවළු සහ පැකට් කළ කුළුබඩු මඟින් වැඩි ලාභයක් ලබා ගැනීම.",
                  "3. කෘෂි අලෙවිකරණය: ගොවියා -> තොග වෙළෙන්දා -> සිල්ලර වෙළෙන්දා -> පාරිභෝගිකයා. විශේෂිත ආර්ථික මධ්‍යස්ථාන (දඹුල්ල, මීගොඩ).",
                  "4. පිරිවැය සහ ලාභ ගණනය: ස්ථාවර පිරිවැය + විචල්‍ය පිරිවැය = මුළු පිරිවැය. ශුද්ධ ලාභය = මුළු ආදායම - මුළු පිරිවැය.",
                  "5. කෘෂිකාර්මික ණය & රක්ෂණය: වගා හානි සහ ස්වාභාවික ආපදාවලදී ගොවියා සුරක්ෂිත කිරීම."
                )
              )
            }
          }

          AgriSectionCategory.MASTER_TARGET -> {
            item(key = "master_target_content") {
              AgriInfoSectionCard(
                title = "🏆 O/L කෘෂිකර්මය A+ මාස්ටර් ඉලක්ක මාර්ගෝපදේශය",
                color = Color(0xFFDC2626),
                content = listOf(
                  "🎯 O/L ප්‍රශ්න පත්‍ර ව්‍යුහය:",
                  "• I පත්‍රය: බහුවරණ ප්‍රශ්න 40 (ලකුණු 40 - පැය 1)",
                  "• II පත්‍රය: ව්‍යූහගත ප්‍රශ්න 4 + රචනා ප්‍රශ්න 4 (ලකුණු 60 - පැය 2)",
                  "🔥 A+ ලබාගැනීමට රහස් 5:",
                  "1. පසෙහි pH, NPK සහ පොහොර ප්‍රතිශත (යූරියා 46%, TSP 46%, MOP 60%) නිවැරදිව මතක තබා ගන්න.",
                  "2. ප්‍රායෝගික පරීක්ෂණවල රූප සටහන් සහ උපකරණවල නාමකරණය පැහැදිලිව අඳින්න.",
                  "3. ව්‍යූහගත ප්‍රශ්නවලට පිළිතුරු ලිවීමේදී කෙටි, පැහැදිලි කරුණු සහ විද්‍යාත්මක පාරිභාෂිත වචන භාවිතා කරන්න.",
                  "4. පසුගිය O/L විභාග ප්‍රශ්න පත්‍ර (2015-2025) අවම වශයෙන් 3 වතාවක්වත් තනිවම කර බලන්න.",
                  "5. කෘෂි යන්ත්‍ර සූත්‍රවල නඩත්තුව සහ පසු අස්වනු අගය එකතු කිරීමේ ක්‍රම පිළිබඳ සටහන නිතර පුනරීක්ෂණය කරන්න."
                )
              )
            }
          }
        }
      }
    }
  }
}

@Composable
private fun AgriInfoSectionCard(
  title: String,
  color: Color,
  content: List<String>
) {
  Card(
    shape = RoundedCornerShape(12.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF14241A)),
    border = BorderStroke(1.2.dp, color),
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 12.dp, vertical = 6.dp)
  ) {
    Column(modifier = Modifier.padding(14.dp)) {
      Text(
        text = title,
        color = Color.White,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
      )

      Spacer(modifier = Modifier.height(10.dp))

      content.forEach { line ->
        Text(
          text = line,
          color = Color(0xFFDCFCE7),
          fontSize = 11.5.sp,
          lineHeight = 16.sp,
          modifier = Modifier.padding(vertical = 3.dp)
        )
      }
    }
  }
}

@Composable
private fun NoContentPlaceholder(message: String) {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .padding(32.dp),
    contentAlignment = Alignment.Center
  ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      Text("🌱", fontSize = 32.sp)
      Spacer(modifier = Modifier.height(8.dp))
      Text(
        text = message,
        color = Color(0xFF86EFAC),
        fontSize = 12.sp,
        textAlign = TextAlign.Center
      )
    }
  }
}

private fun getCategoryDescription(category: AgriSectionCategory): String {
  return when (category) {
    AgriSectionCategory.LESSONS -> "10 හා 11 ශ්‍රේණිවල සියලුම කෘෂිකර්ම පාඩම් වල සාරාංශය හා විභාග උපදෙස්"
    AgriSectionCategory.MCQ_BANK -> "O/L විභාගයට නිතර එන MCQs, නිවැරදි පිළිතුරු සහ විද්‍යාත්මක විවරණ"
    AgriSectionCategory.STRUCTURED_ESSAY -> "ව්‍යූහගත හා රචනා ප්‍රශ්න, ප්‍රධාන කරුණු සහ විභාග ලකුණු පටිපාටි"
    AgriSectionCategory.PRACTICAL_GUIDE -> "පාසල් කෘෂි විද්‍යාගාරයේ හා ක්ෂේත්‍රයේ ප්‍රායෝගික පරීක්ෂණ අත්පොත"
    AgriSectionCategory.SOIL_PLANT_TECH -> "පසෙහි භෞතික/රසායනික ගුණ, pH අගය, NPK හා කාබනික පොහොර"
    AgriSectionCategory.FARM_MACHINERY -> "බිම් සැකසුම් නගුල්, බිංදු ජලසම්පාදනය, යන්ත්‍ර සූත්‍ර හා ආරක්ෂාව"
    AgriSectionCategory.CROPS_LIVESTOCK -> "වී, එළවළු, පලතුරු වගාව, කිරි ගව, කුකුළු පාලනය හා ජලජීවී වගාව"
    AgriSectionCategory.PEST_ORGANIC -> "ඒකාබද්ධ පලිබෝධ පාලනය (IPM), කාබනික ගොවිතැන & හයිඩ්‍රොපොනික්ස්"
    AgriSectionCategory.AGRI_BUSINESS -> "පසු අස්වනු තාක්ෂණය, අගය එකතු කිරීම, ආර්ථික මධ්‍යස්ථාන & ලාභ ගණනය"
    AgriSectionCategory.MASTER_TARGET -> "O/L කෘෂිකර්මය විභාගයට A+ සාමාර්ථයක් ලබාගැනීමේ මාස්ටර් සැලැස්ම"
  }
}

private fun getSampleAgriLessons(): List<AgriLessonUnit> {
  return listOf(
    AgriLessonUnit(
      id = "agri_10_1",
      grade = "10",
      unitNumber = 1,
      titleSin = "ශ්‍රී ලංකාවේ කෘෂිකර්මාන්තය හා එහි අනාගත ප්‍රවණතා",
      category = AgriSectionCategory.LESSONS,
      summarySin = "දේශීය ආර්ථිකයට කෘෂිකර්මාන්තයේ දායකත්වය, දේශගුණික කලාප, සහ නූතන තාක්ෂණය.",
      keyPoints = listOf(
        "තෙත්, වියළි හා අන්තර් කලාපීය කෘෂි දේශගුණික කලාප 3.",
        "ස්මාර්ට් ගොවිතැන හා පරිගණක/සංවේදක යෙදවුම්.",
        "ආහාර සුරක්ෂිතතාව හා තිරසාර කෘෂිකර්මාන්තය."
      ),
      examTips = "දේශගුණික කලාපවල වර්ෂාපතන සීමා හා ප්‍රධාන බෝග නිතර විමසයි."
    ),
    AgriLessonUnit(
      id = "agri_10_2",
      grade = "10",
      unitNumber = 2,
      titleSin = "පසෙහි භෞතික හා රසායනික ගුණ",
      category = AgriSectionCategory.LESSONS,
      summarySin = "පස් වියමන, පස් ව්‍යුහය, පසෙහි pH අගය සහ කැටායන හුවමාරු ධාරිතාව (CEC).",
      keyPoints = listOf(
        "වැලි, රෝම සහ මැටි පස්වල ජල රඳවා ගැනීමේ වෙනස්කම්.",
        "පසෙහි pH අගය මැනීම සහ හුණු යෙදීම.",
        "පස් ඛාදනය හා පස් සංරක්ෂණ ක්‍රම (කන්ටෝර් වැටි, ගල් වැටි)."
      ),
      examTips = "පස් වියමන පිළිබඳ ත්‍රිකෝණාකාර ප්‍රස්ථාරය සහ pH වෙනස්වීම් පාඩම් කරගන්න."
    ),
    AgriLessonUnit(
      id = "agri_10_3",
      grade = "10",
      unitNumber = 3,
      titleSin = "ශාක පෝෂණය හා පොහොර යෙදීම",
      category = AgriSectionCategory.LESSONS,
      summarySin = "ප්‍රධාන, ද්විතීයික හා ක්ෂුද්‍ර ශාක පෝෂක, ඌණතා ලක්ෂණ සහ පොහොර වර්ග.",
      keyPoints = listOf(
        "N (නයිට්‍රජන්) - කොළ පැහැය හා වර්ධනය, P (පොස්පරස්) - මුල්, K (පොටෑසියම්) - ඵල.",
        "යූරියා, ත්‍රිත්ව සුපර් පොස්පේට් (TSP), මුරියේට් ඔෆ් පොටෑෂ් (MOP).",
        "කොම්පෝස්ට් සෑදීම සහ ද්‍රව කාබනික පොහොර."
      ),
      examTips = "N, P, K ඌණතා ලක්ෂණ පත්‍රවල පෙන්නුම් කරන ආකාරය O/L වලට නිතර ඇසේ."
    ),
    AgriLessonUnit(
      id = "agri_10_4",
      grade = "10",
      unitNumber = 4,
      titleSin = "කෘෂිකාර්මික යන්ත්‍ර සූත්‍ර හා උපකරණ",
      category = AgriSectionCategory.LESSONS,
      summarySin = "මෝල්ඩ්බෝඩ් නගුල, රොටවේටර්, බිංදු ජලසම්පාදන පද්ධති සහ ආරක්ෂක උපකරණ.",
      keyPoints = listOf(
        "ප්‍රාථමික සහ ද්විතීයික බිම් සැකසුම් යන්ත්‍ර සූත්‍ර.",
        "බිංදු සහ ස්ප්‍රින්ක්ලර් ජලසම්පාදන ක්‍රම.",
        "කෘමිනාශක ඉසීමේදී අනුගමනය කළ යුතු ආරක්ෂක ක්‍රම."
      ),
      examTips = "නගුල් කොටස් සහ ජලසම්පාදන ක්‍රමවල වාසි විභාගයට අසයි."
    ),
    AgriLessonUnit(
      id = "agri_10_5",
      grade = "10",
      unitNumber = 5,
      titleSin = "බෝග ප්‍රචාරණ ක්‍රම හා තවාන් කළමනාකරණය",
      category = AgriSectionCategory.LESSONS,
      summarySin = "ලිංගික හා අලිංගික ප්‍රචාරණය, බද්ධ කිරීම (Grafting) සහ තවාන් පාලනය.",
      keyPoints = listOf(
        "බීජ මඟින් සහ දඩු/අංකුර මඟින් ප්‍රචාරණය.",
        "මව් ශාකයේ ගුණ ආරක්ෂා කරමින් බද්ධ කිරීම.",
        "පැළ හැඩගැස්වීම (Hardening off)."
      ),
      examTips = "බද්ධ කිරීමේ ක්‍රම සහ තවාන් රෝග පාලනය."
    ),
    AgriLessonUnit(
      id = "agri_11_1",
      grade = "11",
      unitNumber = 1,
      titleSin = "නිරවද්‍ය කෘෂිකර්මය හා ස්මාර්ට් ගොවිතැන (Precision Agri)",
      category = AgriSectionCategory.LESSONS,
      summarySin = "GPS, ඩ්‍රෝන, IoT සංවේදක සහ ආරක්ෂිත ගෘහ තුළ නිරවද්‍ය වගාව.",
      keyPoints = listOf(
        "ජලය හා පොහොර අවශ්‍ය ප්‍රමාණයට පමණක් ලබා දීම.",
        "සංවේදක මඟින් පසෙහි තෙතමනය හා උෂ්ණත්වය නිරීක්ෂණය.",
        "හරිතාගාර තුළ දේශගුණ පාලනය."
      ),
      examTips = "නිරවද්‍ය කෘෂිකර්මයේ වාසි සහ සම්පත් නාස්තිය අවම වීම කෙටි ප්‍රශ්නවලට පැමිණේ."
    ),
    AgriLessonUnit(
      id = "agri_11_2",
      grade = "11",
      unitNumber = 2,
      titleSin = "සත්ත්ව පාලනය හා කිරි/මාංශ නිෂ්පාදනය",
      category = AgriSectionCategory.LESSONS,
      summarySin = "කිරි ගවයන්, එළුවන්, කුකුළන් පාලනය, නිවාස හා පෝෂණය.",
      keyPoints = listOf(
        "ජර්සි, ෆ්‍රීෂියන් ගවයන් සහ දේශීය ප්‍රභේද.",
        "කිරිවල පෝෂණ සංඝටක සහ පැස්ටරීකරණය.",
        "බ්‍රොයිලර් සහ ලේයර් කුකුළු පාලනය."
      ),
      examTips = "කිරි මුදවීම හා පැස්ටරීකරණ උෂ්ණත්ව සටහන් කරගන්න."
    ),
    AgriLessonUnit(
      id = "agri_11_3",
      grade = "11",
      unitNumber = 3,
      titleSin = "පලිබෝධ කළමනාකරණය හා කාබනික ගොවිතැන (IPM)",
      category = AgriSectionCategory.LESSONS,
      summarySin = "ඒකාබද්ධ පලිබෝධ පාලනය, ජෛව පාලන ක්‍රම, හයිඩ්‍රොපොනික්ස් සහ ඇක්වාපොනික්ස්.",
      keyPoints = listOf(
        "යාන්ත්‍රික, භෞතික සහ ජෛව පාලන ක්‍රම.",
        "පස් රහිත හයිඩ්‍රොපොනික්ස් වගාව.",
        "මාළු ඇතිකිරීම හා වගාව සම්බන්ධ කරන ඇක්වාපොනික්ස්."
      ),
      examTips = "IPM හි ප්‍රධාන අංග සහ හයිඩ්‍රොපොනික්ස් පෝෂක ද්‍රාවණ."
    ),
    AgriLessonUnit(
      id = "agri_11_4",
      grade = "11",
      unitNumber = 4,
      titleSin = "පසු අස්වනු තාක්ෂණය හා අගය එකතු කිරීම",
      category = AgriSectionCategory.LESSONS,
      summarySin = "අස්වනු හානි අවම කිරීම, ප්ලාස්ටික් කූඩ, ජෑම්/කෝඩියල් නිෂ්පාදන හා අලෙවිකරණය.",
      keyPoints = listOf(
        "පසු අස්වනු හානි 30-40% දක්වා අවම කරගැනීම.",
        "ප්ලාස්ටික් කූඩ සහ ශීතාගාර භාවිතය.",
        "අගය එකතු කළ නිෂ්පාදන (Value addition)."
      ),
      examTips = "පසු අස්වනු හානිවලට හේතු සහ පාලන ක්‍රම විභාග රචනා ප්‍රශ්නයකි."
    ),
    AgriLessonUnit(
      id = "agri_11_5",
      grade = "11",
      unitNumber = 5,
      titleSin = "O/L කෘෂිකර්මය විභාග මාස්ටර් මාර්ගෝපදේශය",
      category = AgriSectionCategory.LESSONS,
      summarySin = "ප්‍රශ්න පත්‍ර ව්‍යුහය, පොහොර ප්‍රතිශත මතක තබාගැනීමේ ක්‍රම සහ ප්‍රායෝගික සටහන්.",
      keyPoints = listOf(
        "యූරියා 46% N, TSP 46% P2O5, MOP 60% K2O.",
        "pH මැනීම සහ කොම්පෝස්ට් පරීක්ෂණ.",
        "රචනා ප්‍රශ්න පිළිතුරු ලියන නිවැරදි ක්‍රමවේදය."
      ),
      examTips = "පොහොර ප්‍රතිශත සහ ප්‍රායෝගික පියවර නිවැරදිව ලිවීමෙන් A+ ලබාගත හැක."
    )
  )
}

private fun getSampleAgriMcqs(): List<AgriMcqItem> {
  return listOf(
    AgriMcqItem(
      id = 1,
      grade = "10",
      questionSin = "ශාකවල පත්‍ර කහ පැහැ වී වර්ධනය අඩාල වීම ප්‍රධාන වශයෙන් කිනම් පෝෂක ඌණතාවයක් නිසා සිදු වේද?",
      options = listOf("පොස්පරස් (P)", "නයිට්‍රජන් (N)", "පොටෑසියම් (K)", "කැල්සියම් (Ca)"),
      correctIndex = 1,
      explanationSin = "නයිට්‍රජන් (N) ශාකවල ක්ලෝරොෆිල් සංස්ලේෂණයට හා පත්‍ර වර්ධනයට අත්‍යවශ්‍ය වන අතර, එහි ඌණතාවයෙන් පරණ පත්‍ර කහ පැහැ වේ."
    ),
    AgriMcqItem(
      id = 2,
      grade = "10",
      questionSin = "පසෙහි ආම්ලිකතාවය (pH අගය අඩු වීම) අඩු කර උදාසීන කිරීම සඳහා යොදනු ලබන රසායනික සංයෝගය කුමක්ද?",
      options = listOf("ගන්ධක (Sulfur)", "කැල්සියම් කාබනේට් / හුණු (Lime)", "යූරියා (Urea)", "ජිප්සම් (Gypsum)"),
      correctIndex = 1,
      explanationSin = "ආම්ලික පස් සඳහා හුණු (කැල්සියම් කාබනේට් - CaCO3) එකතු කිරීමෙන් පසෙහි pH අගය ඉහළ නැංවිය හැක."
    ),
    AgriMcqItem(
      id = 3,
      grade = "11",
      questionSin = "එළවළු හා පලතුරු අස්වනු නෙළීමෙන් පසු සිදු වන හානිය අවම කර ගැනීමට වඩාත්ම සුදුසු ඇසුරුම් ක්‍රමය කුමක්ද?",
      options = listOf("ගෝනි මලු භාවිතය", "ප්ලාස්ටික් කූඩ (Rigid Plastic Crates)", "පොලිතීන් බෑග්", "ලී පෙට්ටි"),
      correctIndex = 1,
      explanationSin = "තද ප්ලාස්ටික් කූඩ මඟින් තෙරපීමෙන් වන හානිය වළක්වා වාතාශ්‍රය ලබා දෙයි."
    ),
    AgriMcqItem(
      id = 4,
      grade = "10",
      questionSin = "යූරියා පොහොරෙහි අඩංගු නයිට්‍රජන් (N) ප්‍රතිශතය කොපමණද?",
      options = listOf("20%", "30%", "46%", "60%"),
      correctIndex = 2,
      explanationSin = "යූරියා වල 46% ක් ද, TSP වල 46% P2O5 ද, MOP වල 60% K2O ද අඩංගු වේ."
    ),
    AgriMcqItem(
      id = 5,
      grade = "11",
      questionSin = "පස් රහිතව පෝෂක ද්‍රාවණ තුළ ජලයේ එළවළු වගා කිරීම හැඳින්වෙන්නේ කුමන නමකින්ද?",
      options = listOf("හයිඩ්‍රොපොනික්ස් (Hydroponics)", "ඇක්වාපොනික්ස් (Aquaponics)", "කොම්පෝස්ට් වගාව", "මුල් මඟින් වගාව"),
      correctIndex = 0,
      explanationSin = "හයිඩ්‍රොපොනික්ස් යනු පස් රහිතව පෝෂක ද්‍රාවණ මඟින් ශාක පෝෂණය කරමින් කරන වගාවකි."
    )
  )
}

private fun getSampleAgriEssays(): List<AgriEssayQuestion> {
  return listOf(
    AgriEssayQuestion(
      id = 1,
      grade = "10",
      titleSin = "පසෙහි සාරවත්බව සහ කාබනික පොහොර භාවිතය",
      scenarioSin = "ශ්‍රී ලංකාවේ ගොවීන් රසායනික පොහොර අධිභාවිතය නිසා පසෙහි ජීවීන්ට හා ව්‍යුහයට හානි සිදුවී ඇත.",
      pointsToInclude = listOf(
        "කොම්පෝස්ට් පොහොර සෑදීමේ පියවර 5 (අමුද්‍රව්‍ය, තෙතමනය, වාතාශ්‍රය).",
        "පසෙහි ජල රඳවා ගැනීමේ හැකියාව වැඩි වීම.",
        "පස්ජීවීන්ගේ (ගැඩවිලුන්) ක්‍රියාකාරීත්වය උත්තේජනය වීම."
      ),
      markingSchemeSin = "කොම්පෝස්ට් පියවර සඳහා ලකුණු 4, පස් ව්‍යුහය සඳහා ලකුණු 3, පස්ජීවීන් සඳහා ලකුණු 3. මුළු ලකුණු 10."
    ),
    AgriEssayQuestion(
      id = 2,
      grade = "11",
      titleSin = "ආරක්ෂිත ගෘහ තුළ වගාව සහ හයිඩ්‍රොපොනික්ස් (Hydroponics)",
      scenarioSin = "දේශගුණික විපර්යාස හමුවේ තිරසාර එළවළු නිෂ්පාදනයට නූතන තාක්ෂණය යොදාගැනීම.",
      pointsToInclude = listOf(
        "පොලිටනල් / හරිතාගාරවල දේශගුණික පාලනය (උෂ්ණත්වය, ආර්ද්‍රතාව, පළිබෝධ).",
        "NFT (Nutrient Film Technique) ක්‍රමයේ ක්‍රියාකාරීත්වය.",
        "වාණිජමය වශයෙන් බෙල්පෙපර්, ස්ට්‍රෝබෙරි වගාවේ වාසි."
      ),
      markingSchemeSin = "හරිතාගාර වාසි ලකුණු 4, NFT සටහන ලකුණු 3, වාණිජ බෝග ලකුණු 3. මුළු ලකුණු 10."
    ),
    AgriEssayQuestion(
      id = 3,
      grade = "11",
      titleSin = "පසු අස්වනු තාක්ෂණය සහ අගය එකතු කිරීමේ වැදගත්කම",
      scenarioSin = "අස්වනු නෙළීමේ සිට පාරිභෝගිකයාට ළඟා වන තෙක් 30% කට වැඩි අස්වනු ප්‍රමාණයක් අපතේ යයි.",
      pointsToInclude = listOf(
        "පසු අස්වනු හානි වීමට බලපාන හේතු (නුසුදුසු ඇසුරුම්, ප්‍රවාහනය).",
        "ප්ලාස්ටික් කූඩ සහ ශීතාගාර භාවිතයේ වාසි.",
        "ජෑම්, කෝඩියල් සහ පලතුරු යුෂ සැකසීමෙන් ලැබෙන ආර්ථික ප්‍රතිලාභ."
      ),
      markingSchemeSin = "හානි හේතු ලකුණු 3, ඇසුරුම් හා ශීතාගාර ලකුණු 4, අගය එකතු කිරීම ලකුණු 3. මුළු ලකුණු 10."
    )
  )
}

private fun getSampleAgriPracticals(): List<AgriPracticalExperiment> {
  return listOf(
    AgriPracticalExperiment(
      id = 1,
      titleSin = "පස් සාම්පලයක pH අගය මැනීම",
      objectiveSin = "ක්ෂේත්‍රයෙන් ලබාගත් පස් සාම්පලයක ආම්ලික හෝ අල්කාලීන බව මැනීම.",
      apparatusSin = listOf("පස් සාම්පලය", "ආස්රැත ජලය", "බීකර", "pH කඩදාසි / pH මීටරය", "වීදුරු කූර"),
      procedureSin = listOf("පස් සාම්පලය 1:2.5 අනුපාතයට ජලය සමඟ මිශ්‍ර කරන්න.", "මිනිත්තු 15ක් හොඳින් කලතන්න.", "pH කඩදාසිය ඔබා වර්ණය සසඳන්න."),
      observationsSin = "pH අගය 6.5 නම් එය මඳ ආම්ලික/උදාසීන සාරවත් පසකි.",
      precautionsSin = "තට්ටු කර ලබාගත් ජලය පමණක් භාවිතා කරන්න, කරාම ජලය නොගන්න."
    ),
    AgriPracticalExperiment(
      id = 2,
      titleSin = "කොම්පෝස්ට් පොහොරවල පරිණතභාවය පරීක්ෂා කිරීම",
      objectiveSin = "සදන ලද කොම්පෝස්ට් වගාවට යෙදීමට සුදුසු මට්ටමේ තිබේදැයි තහවුරු කිරීම.",
      apparatusSin = listOf("කොම්පෝස්ට් සාම්පලය", "ප්ලාස්ටික් බෑගය", "බීජ (මී Extracted Seeds)", "ජලය"),
      procedureSin = listOf("කොම්පෝස්ට් තෙතමනය කර බෑගයේ දමා වසා දින 2ක් තබන්න.", "දුගඳක් හමන්නේදැයි පරීක්ෂා කරන්න.", "බීජ ප්‍රරෝහණය වන ප්‍රතිශතය මැන බලන්න."),
      observationsSin = "දුගඳක් නැතිනම් සහ බීජ 80%+ ප්‍රරෝහණය වේ නම් කොම්පෝස්ට් පරිණතය.",
      precautionsSin = "නොපරිණත කොම්පෝස්ට් යෙදීමෙන් මුල් දැවී යා හැක."
    )
  )
}

@Composable
fun AgricultureGrade10And11MasterHubCard(
  onOpenFullHub: (AgriSectionCategory?) -> Unit
) {
  Card(
    shape = RoundedCornerShape(12.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF142E1B)),
    border = BorderStroke(1.2.dp, Color(0xFF22C55E)),
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(12.dp))
      .clickable { onOpenFullHub(null) }
      .testTag("agriculture_master_hub_subject_card")
  ) {
    Column(modifier = Modifier.padding(11.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Text("🌱", fontSize = 18.sp)
          Spacer(modifier = Modifier.width(6.dp))
          Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text(
                text = "10 & 11 කෘෂිකර්මය Master Hub (පූර්ණ තිරයෙන්)",
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
              )
              Spacer(modifier = Modifier.width(6.dp))
              Surface(
                color = Color(0xFF22C55E),
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
              text = "පාඩම් 10 • MCQs • ව්‍යූහගත & රචනා • ප්‍රායෝගික අත්පොත • පස, පොහොර & යන්ත්‍ර සූත්‍ර",
              color = Color(0xFF86EFAC),
              fontSize = 10.sp,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
          }
        }
        Surface(
          color = Color(0xFF166534),
          shape = CircleShape,
          border = BorderStroke(1.dp, Color(0xFF4ADE80))
        ) {
          Icon(
            imageVector = Icons.Default.OpenInFull,
            contentDescription = "Open Fullscreen",
            tint = Color.White,
            modifier = Modifier
              .size(24.dp)
              .padding(5.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      // Action Quick Buttons Row
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
      ) {
        Button(
          onClick = { onOpenFullHub(AgriSectionCategory.LESSONS) },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF15803D)),
          shape = RoundedCornerShape(8.dp),
          contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
          modifier = Modifier.height(28.dp)
        ) {
          Text("📚 පාඩම් 10", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        Button(
          onClick = { onOpenFullHub(AgriSectionCategory.MCQ_BANK) },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB)),
          shape = RoundedCornerShape(8.dp),
          contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
          modifier = Modifier.height(28.dp)
        ) {
          Text("🎯 O/L MCQs", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        Button(
          onClick = { onOpenFullHub(AgriSectionCategory.STRUCTURED_ESSAY) },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C3AED)),
          shape = RoundedCornerShape(8.dp),
          contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
          modifier = Modifier.height(28.dp)
        ) {
          Text("📝 රචනා & Marking", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        Button(
          onClick = { onOpenFullHub(AgriSectionCategory.PRACTICAL_GUIDE) },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D9488)),
          shape = RoundedCornerShape(8.dp),
          contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
          modifier = Modifier.height(28.dp)
        ) {
          Text("🔬 ප්‍රායෝගික අත්පොත", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        Button(
          onClick = { onOpenFullHub(AgriSectionCategory.SOIL_PLANT_TECH) },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669)),
          shape = RoundedCornerShape(8.dp),
          contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
          modifier = Modifier.height(28.dp)
        ) {
          Text("🌱 පස & ශාක", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        Button(
          onClick = { onOpenFullHub(AgriSectionCategory.FARM_MACHINERY) },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD97706)),
          shape = RoundedCornerShape(8.dp),
          contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
          modifier = Modifier.height(28.dp)
        ) {
          Text("🚜 යන්ත්‍ර සූත්‍ර", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
      }
    }
  }
}
