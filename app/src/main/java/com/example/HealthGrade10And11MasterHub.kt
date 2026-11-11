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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import kotlin.math.ceil
import kotlin.math.log2
import kotlin.math.pow

/**
 * 🌟 100% ACCURATE GRADE 10 & 11 HEALTH & PHYSICAL EDUCATION MASTER HUB
 * Includes:
 * 1. Complete 12 Curriculum Lessons with Core Rules, Summaries, and Exam Tips
 * 2. O/L I MCQ Bank with Detailed Explanations
 * 3. O/L II Structured & Essay Questions with Official Marking Schemes
 * 4. Interactive Live BMI Calculator & Tournament Match/Byes Calculator
 * 5. Sports Injuries & RICE First Aid Action Guides
 * 6. WHO 10 Core Life Skills & Mental Health Management
 */
@Composable
fun HealthGrade10And11MasterHubDialog(
  initialGradeTab: HealthGradeTab = HealthGradeTab.ALL,
  initialSectionCategory: HealthSectionCategory? = null,
  onDismiss: () -> Unit
) {
  var selectedGradeTab by remember { mutableStateOf(initialGradeTab) }
  var selectedCategory by remember { mutableStateOf<HealthSectionCategory?>(initialSectionCategory) }
  var searchQuery by remember { mutableStateOf("") }

  // State for MCQ interactive test
  val userSelectedOptions = remember { mutableStateMapOf<Int, Int>() }

  // Expanded items state
  var expandedLessonId by remember { mutableStateOf<String?>(null) }
  var expandedEssayId by remember { mutableStateOf<String?>(null) }
  var expandedFirstAidId by remember { mutableStateOf<String?>(null) }

  // Reset expanded items when category or grade tab changes
  LaunchedEffect(selectedCategory, selectedGradeTab) {
    expandedLessonId = null
    expandedEssayId = null
    expandedFirstAidId = null
  }

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
        .testTag("health_master_hub_dialog"),
      color = Color(0xFF1E0A12)
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
                  colors = listOf(Color(0xFFBE123C), Color(0xFF9F1239))
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
                modifier = Modifier.testTag("health_hub_back_btn")
              ) {
                Icon(
                  imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                  contentDescription = "Back",
                  tint = Color.White
                )
              }
              Spacer(modifier = Modifier.width(4.dp))
              Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text("🏃‍♂️", fontSize = 18.sp)
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය Master Hub",
                    color = Color.White,
                    fontSize = 16.5.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                }
                Text(
                  text = "10 & 11 ශ්‍රේණි • විෂය නිර්දේශය • MCQs • රචනා • BMI • RICE • තරග සූත්‍ර",
                  color = Color(0xFFFFE4E6),
                  fontSize = 10.5.sp,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }
              Surface(
                color = Color(0xFFF43F5E),
                shape = RoundedCornerShape(12.dp)
              ) {
                Text(
                  text = "O/L A+",
                  color = Color.White,
                  fontSize = 11.sp,
                  fontWeight = FontWeight.ExtraBold,
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                )
              }
            }
          }
        }

        // GRADE FILTER ROW
        item(key = "grade_filter_row") {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .background(Color(0xFF3B0B1D))
              .padding(horizontal = 12.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            HealthGradeTab.values().forEach { tab ->
              val isSelected = selectedGradeTab == tab
              FilterChip(
                selected = isSelected,
                onClick = { selectedGradeTab = tab },
                label = {
                  Text(
                    text = tab.labelSinhala,
                    fontSize = 11.5.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                  )
                },
                colors = FilterChipDefaults.filterChipColors(
                  selectedContainerColor = Color(0xFFE11D48),
                  selectedLabelColor = Color.White,
                  containerColor = Color(0xFF4C0519),
                  labelColor = Color(0xFFFECDD3)
                ),
                border = BorderStroke(
                  width = 1.dp,
                  color = if (isSelected) Color(0xFFFB7185) else Color(0xFF881337)
                ),
                modifier = Modifier.weight(1f)
              )
            }
          }
        }

        // SEARCH BAR
        item(key = "search_bar") {
          OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("පාඩම, ප්‍රශ්නය, රෝගය හෝ ප්‍රථමාධාර සොයන්න...", fontSize = 12.sp, color = Color(0xFFFDA4AF).copy(alpha = 0.7f)) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color(0xFFFB7185)) },
            trailingIcon = {
              if (searchQuery.isNotEmpty()) {
                IconButton(onClick = { searchQuery = "" }) {
                  Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color(0xFFFDA4AF))
                }
              }
            },
            singleLine = true,
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
              focusedBorderColor = Color(0xFFFB7185),
              unfocusedBorderColor = Color(0xFF881337),
              focusedTextColor = Color.White,
              unfocusedTextColor = Color.White,
              focusedContainerColor = Color(0xFF2C0A16),
              unfocusedContainerColor = Color(0xFF2C0A16)
            ),
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 12.dp, vertical = 6.dp)
              .testTag("health_search_input")
          )
        }

        // CATEGORY NAV STRIP (WHEN A CATEGORY IS SELECTED)
        if (selectedCategory != null) {
          item(key = "category_nav_strip") {
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1E050E))
                .padding(horizontal = 8.dp, vertical = 6.dp),
              verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Surface(
                  onClick = { selectedCategory = null },
                  shape = RoundedCornerShape(8.dp),
                  color = Color(0xFFE11D48),
                  border = BorderStroke(1.dp, Color(0xFFFB7185))
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text("◀ සියලු අනු කොටස් 10 බලන්න", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                  }
                }

                Text(
                  text = "${selectedCategory?.emoji} ${selectedCategory?.shortTitleSinhala}",
                  color = Color(0xFFFDA4AF),
                  fontSize = 11.5.sp,
                  fontWeight = FontWeight.Bold
                )
              }

              // Horizontal Category Navigator Strip (Scrolls horizontally, saving vertical height!)
              androidx.compose.foundation.lazy.LazyRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                items(HealthSectionCategory.values()) { cat ->
                  val isSelected = selectedCategory == cat
                  Surface(
                    onClick = { selectedCategory = cat },
                    shape = RoundedCornerShape(8.dp),
                    color = if (isSelected) cat.themeColor else Color(0xFF3B0B1D).copy(alpha = 0.7f),
                    border = BorderStroke(
                      width = 1.dp,
                      color = if (isSelected) Color.White else Color(0xFF881337)
                    )
                  ) {
                    Row(
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Text(cat.emoji, fontSize = 12.sp)
                      Spacer(modifier = Modifier.width(4.dp))
                      Text(
                        text = cat.shortTitleSinhala,
                        fontSize = 10.5.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = if (isSelected) Color.White else Color(0xFFFFE4E6)
                      )
                    }
                  }
                }
              }
            }
          }
        }

        // MAIN CONTENT AREA
        item(key = "main_content_area") {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .background(Color(0xFF14030A))
          ) {
            if (selectedCategory == null) {
              HealthMasterOverviewGrid(
                selectedGradeTab = selectedGradeTab,
                searchQuery = searchQuery,
                onSelectCategory = { cat -> selectedCategory = cat }
              )
            } else {
              when (selectedCategory) {
                HealthSectionCategory.LESSONS -> {
                  HealthLessonsSection(
                    gradeTab = selectedGradeTab,
                    searchQuery = searchQuery,
                    expandedLessonId = expandedLessonId,
                    onToggleExpand = { id ->
                      expandedLessonId = if (expandedLessonId == id) null else id
                    }
                  )
                }
                HealthSectionCategory.MCQ_BANK -> {
                  HealthMcqSection(
                    gradeTab = selectedGradeTab,
                    searchQuery = searchQuery,
                    userSelectedOptions = userSelectedOptions,
                    onSelectOption = { qId, optIdx ->
                      userSelectedOptions[qId] = optIdx
                    },
                    onResetQuiz = {
                      userSelectedOptions.clear()
                    }
                  )
                }
                HealthSectionCategory.STRUCTURED_ESSAY -> {
                  HealthStructuredEssaySection(
                    gradeTab = selectedGradeTab,
                    searchQuery = searchQuery,
                    expandedEssayId = expandedEssayId,
                    onToggleExpand = { id ->
                      expandedEssayId = if (expandedEssayId == id) null else id
                    }
                  )
                }
                HealthSectionCategory.CALCULATORS -> {
                  HealthCalculatorsSection()
                }
                HealthSectionCategory.FIRST_AID -> {
                  HealthFirstAidSection(
                    searchQuery = searchQuery,
                    expandedFirstAidId = expandedFirstAidId,
                    onToggleExpand = { id ->
                      expandedFirstAidId = if (expandedFirstAidId == id) null else id
                    }
                  )
                }
                HealthSectionCategory.LIFE_SKILLS -> {
                  HealthLifeSkillsSection(searchQuery = searchQuery)
                }
                HealthSectionCategory.SHORT_NOTES -> {
                  HealthShortNotesSection(gradeTab = selectedGradeTab, searchQuery = searchQuery)
                }
                HealthSectionCategory.SPORTS_RULES -> {
                  HealthSportsRulesSection(searchQuery = searchQuery)
                }
                HealthSectionCategory.PRACTICAL_EXAMS -> {
                  HealthPracticalExamsSection(searchQuery = searchQuery)
                }
                HealthSectionCategory.AYURVEDA_WELLNESS -> {
                  HealthAyurvedaSection(searchQuery = searchQuery)
                }
                null -> {}
              }
            }
          }
        }
      }
    }
  }
}

// ============================================================================
// 1. LESSONS SECTION
// ============================================================================
@Composable
private fun HealthLessonsSection(
  gradeTab: HealthGradeTab,
  searchQuery: String,
  expandedLessonId: String?,
  onToggleExpand: (String) -> Unit
) {
  val filteredLessons = remember(gradeTab, searchQuery) {
    HealthMasterDataProvider.allLessons.filter { lesson ->
      val matchesGrade = when (gradeTab) {
        HealthGradeTab.ALL -> true
        HealthGradeTab.GRADE_10 -> lesson.grade == "10"
        HealthGradeTab.GRADE_11 -> lesson.grade == "11"
      }
      val matchesSearch = searchQuery.isBlank() ||
          lesson.titleSinhala.contains(searchQuery, ignoreCase = true) ||
          lesson.titleEnglish.contains(searchQuery, ignoreCase = true) ||
          lesson.keyConcepts.any { it.contains(searchQuery, ignoreCase = true) } ||
          lesson.fullSummary.contains(searchQuery, ignoreCase = true)
      matchesGrade && matchesSearch
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(12.dp),
    verticalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFF881337).copy(alpha = 0.35f)),
      border = BorderStroke(1.dp, Color(0xFFE11D48))
    ) {
      Row(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text("🥗", fontSize = 20.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "O/L සෞඛ්‍ය විෂය නිර්දේශයේ සම්පූර්ණ ඒකක ${filteredLessons.size} ක සාරාංශ, මූලධර්ම සහ විභාග ඉඟි පහතින් අධ්‍යයනය කරන්න.",
          fontSize = 11.5.sp,
          color = Color(0xFFFFE4E6),
          lineHeight = 16.sp
        )
      }
    }

    filteredLessons.forEach { lesson ->
      val isExpanded = expandedLessonId == lesson.id
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2C0A16).copy(alpha = 0.8f)),
        border = BorderStroke(1.dp, if (isExpanded) Color(0xFFFB7185) else Color(0xFF5C0E24)),
        modifier = Modifier
          .fillMaxWidth()
          .clickable { onToggleExpand(lesson.id) }
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Surface(
              color = if (lesson.grade == "10") Color(0xFFE11D48) else Color(0xFF2563EB),
              shape = RoundedCornerShape(6.dp)
            ) {
              Text(
                text = "${lesson.grade} ශ්‍රේණිය • ඒකකය 0${lesson.unitNumber}",
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
              imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
              contentDescription = null,
              tint = Color(0xFFFB7185)
            )
          }

          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = lesson.titleSinhala,
            fontSize = 14.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
          Text(
            text = lesson.titleEnglish,
            fontSize = 11.sp,
            color = Color(0xFFFDA4AF).copy(alpha = 0.8f)
          )

          Spacer(modifier = Modifier.height(8.dp))
          Surface(
            color = Color(0xFF1E050E),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(0.8.dp, Color(0xFF881337))
          ) {
            Row(
              modifier = Modifier.padding(8.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text("💡", fontSize = 14.sp)
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = lesson.corePrinciples,
                fontSize = 11.sp,
                color = Color(0xFFFFD1DC),
                lineHeight = 15.sp
              )
            }
          }

          AnimatedVisibility(
            visible = isExpanded,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
          ) {
            Column(modifier = Modifier.padding(top = 10.dp)) {
              HorizontalDivider(color = Color(0xFF4C0519), thickness = 0.8.dp)
              Spacer(modifier = Modifier.height(8.dp))

              Text(
                text = "📌 ප්‍රධාන විෂය සංකල්ප (Key Concepts):",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFDE047)
              )
              Spacer(modifier = Modifier.height(4.dp))
              lesson.keyConcepts.forEach { concept ->
                Row(modifier = Modifier.padding(vertical = 2.dp)) {
                  Text("•", color = Color(0xFFFB7185), fontWeight = FontWeight.Bold, fontSize = 13.sp)
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(text = concept, fontSize = 11.5.sp, color = Color.White, lineHeight = 16.sp)
                }
              }

              Spacer(modifier = Modifier.height(8.dp))
              Text(
                text = "📖 සවිස්තරාත්මක පාඩම් සාරාංශය:",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF67E8F9)
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = lesson.fullSummary,
                fontSize = 11.5.sp,
                color = Color(0xFFF1F5F9),
                lineHeight = 17.sp
              )

              Spacer(modifier = Modifier.height(8.dp))
              Surface(
                color = Color(0xFF431407),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color(0xFFEA580C))
              ) {
                Row(
                  modifier = Modifier.padding(8.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text("🎯", fontSize = 14.sp)
                  Spacer(modifier = Modifier.width(6.dp))
                  Column {
                    Text(
                      text = "O/L විභාග රහස් & ඉඟි:",
                      fontSize = 10.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFFFED7AA)
                    )
                    Text(
                      text = lesson.examTips,
                      fontSize = 11.sp,
                      color = Color.White,
                      lineHeight = 15.sp
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
}

// ============================================================================
// 2. MCQ SECTION (INTERACTIVE WITH EXPLANATIONS)
// ============================================================================
@Composable
private fun HealthMcqSection(
  gradeTab: HealthGradeTab,
  searchQuery: String,
  userSelectedOptions: Map<Int, Int>,
  onSelectOption: (Int, Int) -> Unit,
  onResetQuiz: () -> Unit
) {
  val filteredMcqs = remember(gradeTab, searchQuery) {
    HealthMasterDataProvider.mcqQuestions.filter { q ->
      val matchesGrade = when (gradeTab) {
        HealthGradeTab.ALL -> true
        HealthGradeTab.GRADE_10 -> q.grade == "10"
        HealthGradeTab.GRADE_11 -> q.grade == "11"
      }
      val matchesSearch = searchQuery.isBlank() ||
          q.questionText.contains(searchQuery, ignoreCase = true) ||
          q.unitName.contains(searchQuery, ignoreCase = true) ||
          q.explanation.contains(searchQuery, ignoreCase = true)
      matchesGrade && matchesSearch
    }
  }

  val totalAnswered = userSelectedOptions.keys.count { id -> filteredMcqs.any { it.id == id } }
  val totalCorrect = userSelectedOptions.entries.count { (id, opt) ->
    filteredMcqs.firstOrNull { it.id == id }?.correctOptionIndex == opt
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(12.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF31101E)),
        border = BorderStroke(1.dp, Color(0xFFBE123C))
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Column {
              Text(
                text = "🎯 O/L I පත්‍රය - බහුවරණ පුහුණුව",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Text(
                text = "පිළිතුරු දුන් ගණන: $totalAnswered / ${filteredMcqs.size} | නිවැරදි: $totalCorrect",
                fontSize = 11.5.sp,
                color = Color(0xFFFDA4AF)
              )
            }
            Button(
              onClick = onResetQuiz,
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE11D48)),
              contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
              modifier = Modifier.height(30.dp)
            ) {
              Text("නැවත මුල සිට", fontSize = 10.sp, color = Color.White)
            }
          }
        }
      }
    }

    filteredMcqs.forEachIndexed { index, q ->
      val selectedOption = userSelectedOptions[q.id]
      val hasAnswered = selectedOption != null

      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF240713)),
        border = BorderStroke(
          1.dp,
          when {
            !hasAnswered -> Color(0xFF4C0519)
            selectedOption == q.correctOptionIndex -> Color(0xFF22C55E)
            else -> Color(0xFFEF4444)
          }
        ),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Surface(
              color = Color(0xFFBE123C),
              shape = RoundedCornerShape(4.dp)
            ) {
              Text(
                text = "ප්‍රශ්න ${index + 1} (${q.grade} ශ්‍රේණිය - ${q.unitName})",
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
          }

          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = q.questionText,
            fontSize = 13.5.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            lineHeight = 18.sp
          )

          Spacer(modifier = Modifier.height(10.dp))
          q.options.forEachIndexed { optIndex, optionText ->
            val isThisSelected = selectedOption == optIndex
            val isCorrect = q.correctOptionIndex == optIndex

            val backgroundColor = when {
              !hasAnswered -> Color(0xFF380C1E)
              isCorrect -> Color(0xFF14532D)
              isThisSelected -> Color(0xFF7F1D1D)
              else -> Color(0xFF380C1E).copy(alpha = 0.5f)
            }

            val borderColor = when {
              !hasAnswered -> Color(0xFF5C0E24)
              isCorrect -> Color(0xFF4ADE80)
              isThisSelected -> Color(0xFFF87171)
              else -> Color(0xFF4C0519)
            }

            Surface(
              shape = RoundedCornerShape(8.dp),
              color = backgroundColor,
              border = BorderStroke(1.dp, borderColor),
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 3.dp)
                .clickable { onSelectOption(q.id, optIndex) }
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = optionText,
                  fontSize = 11.5.sp,
                  color = if (hasAnswered && isCorrect) Color(0xFF86EFAC) else Color.White,
                  modifier = Modifier.weight(1f),
                  lineHeight = 16.sp
                )
                if (hasAnswered) {
                  if (isCorrect) {
                    Text("✓ නිවැරදියි", color = Color(0xFF4ADE80), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                  } else if (isThisSelected) {
                    Text("✗ වැරදියි", color = Color(0xFFF87171), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                  }
                }
              }
            }
          }

          if (hasAnswered) {
            Spacer(modifier = Modifier.height(8.dp))
            Surface(
              color = Color(0xFF064E3B).copy(alpha = 0.6f),
              shape = RoundedCornerShape(8.dp),
              border = BorderStroke(1.dp, Color(0xFF10B981))
            ) {
              Column(modifier = Modifier.padding(8.dp)) {
                Text(
                  text = "💡 නිවැරදි කරුණු පැහැදිලි කිරීම (විවරණය):",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF6EE7B7)
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                  text = q.explanation,
                  fontSize = 11.sp,
                  color = Color.White,
                  lineHeight = 15.sp
                )
              }
            }
          }
        }
      }
    }
  }

// ============================================================================
// 3. STRUCTURED ESSAY SECTION (WITH MARKING SCHEMES)
// ============================================================================
@Composable
private fun HealthStructuredEssaySection(
  gradeTab: HealthGradeTab,
  searchQuery: String,
  expandedEssayId: String?,
  onToggleExpand: (String) -> Unit
) {
  val filteredEssays = remember(gradeTab, searchQuery) {
    HealthMasterDataProvider.structuredEssays.filter { essay ->
      val matchesGrade = when (gradeTab) {
        HealthGradeTab.ALL -> true
        HealthGradeTab.GRADE_10 -> essay.grade == "10"
        HealthGradeTab.GRADE_11 -> essay.grade == "11"
      }
      val matchesSearch = searchQuery.isBlank() ||
          essay.title.contains(searchQuery, ignoreCase = true) ||
          essay.unitName.contains(searchQuery, ignoreCase = true) ||
          essay.scenarioText.contains(searchQuery, ignoreCase = true)
      matchesGrade && matchesSearch
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(12.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFF0F766E).copy(alpha = 0.35f)),
      border = BorderStroke(1.dp, Color(0xFF14B8A6))
    ) {
      Row(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text("📝", fontSize = 20.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "O/L II පත්‍රයේ සම්මත ලකුණු 15 ප්‍රශ්න ආකෘතිය සහ නිල ලකුණු ලබාදීමේ පටිපාටිය (Marking Schemes) පහතින් බලන්න.",
          fontSize = 11.5.sp,
          color = Color(0xFFCCFBF1),
          lineHeight = 16.sp
        )
      }
    }

    filteredEssays.forEach { essay ->
      val isExpanded = expandedEssayId == essay.id
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2C0A16)),
        border = BorderStroke(1.dp, if (isExpanded) Color(0xFF2DD4BF) else Color(0xFF4C0519)),
        modifier = Modifier
          .fillMaxWidth()
          .clickable { onToggleExpand(essay.id) }
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Surface(
              color = Color(0xFF0D9488),
              shape = RoundedCornerShape(6.dp)
            ) {
              Text(
                text = "${essay.grade} ශ්‍රේණිය • ${essay.unitName}",
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
            Spacer(modifier = Modifier.weight(1f))
            Surface(
              color = Color(0xFF1E050E),
              shape = RoundedCornerShape(4.dp)
            ) {
              Text(
                text = "ලකුණු 15",
                color = Color(0xFF5EEAD4),
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
              imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
              contentDescription = null,
              tint = Color(0xFF2DD4BF)
            )
          }

          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = essay.title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = essay.scenarioText,
            fontSize = 11.5.sp,
            color = Color(0xFFE2E8F0),
            lineHeight = 16.sp
          )

          AnimatedVisibility(
            visible = isExpanded,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
          ) {
            Column(modifier = Modifier.padding(top = 10.dp)) {
              HorizontalDivider(color = Color(0xFF4C0519), thickness = 0.8.dp)
              Spacer(modifier = Modifier.height(8.dp))

              essay.subQuestions.forEach { sub ->
                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = Color(0xFF1A050E),
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                ) {
                  Column(modifier = Modifier.padding(10.dp)) {
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                      Text(
                        text = "${sub.numberText} ${sub.question}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFF1F5F9),
                        modifier = Modifier.weight(1f),
                        lineHeight = 16.sp
                      )
                      Surface(
                        color = Color(0xFF0284C7),
                        shape = RoundedCornerShape(4.dp)
                      ) {
                        Text(
                          text = "ලකුණු ${sub.marks}",
                          color = Color.White,
                          fontSize = 9.5.sp,
                          fontWeight = FontWeight.Bold,
                          modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                        )
                      }
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                      text = "🎯 ලකුණු දීමේ පටිපාටිය (Marking Scheme):",
                      fontSize = 10.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF34D399)
                    )
                    sub.markingSchemePoints.forEach { pt ->
                      Row(modifier = Modifier.padding(vertical = 1.5.dp)) {
                        Text("•", color = Color(0xFF10B981), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = pt, fontSize = 11.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)
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

// ============================================================================
// 4. INTERACTIVE CALCULATORS SECTION (BMI & TOURNAMENT FORMULAS)
// ============================================================================
@Composable
private fun HealthCalculatorsSection() {
  var weightInput by remember { mutableStateOf("50") }
  var heightCmInput by remember { mutableStateOf("155") }

  var tournamentTeamsInput by remember { mutableStateOf("11") }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(12.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    // 1. BMI CALCULATOR CARD
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2C0A16)),
        border = BorderStroke(1.2.dp, Color(0xFFE11D48)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text("⚖️", fontSize = 20.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Column {
              Text(
                text = "ශරීර ස්කන්ධ දර්ශක ගණකය (Live BMI Calculator)",
                fontSize = 14.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Text(
                text = "සූත්‍රය: BMI = බර (kg) / [උස (m) × උස (m)]",
                fontSize = 11.sp,
                color = Color(0xFFFDA4AF)
              )
            }
          }

          Spacer(modifier = Modifier.height(12.dp))
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            OutlinedTextField(
              value = weightInput,
              onValueChange = { weightInput = it },
              label = { Text("බර (kg)", color = Color(0xFFFDA4AF), fontSize = 11.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              singleLine = true,
              shape = RoundedCornerShape(8.dp),
              colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFB7185),
                unfocusedBorderColor = Color(0xFF881337),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
              ),
              modifier = Modifier.weight(1f)
            )

            OutlinedTextField(
              value = heightCmInput,
              onValueChange = { heightCmInput = it },
              label = { Text("උස (cm)", color = Color(0xFFFDA4AF), fontSize = 11.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              singleLine = true,
              shape = RoundedCornerShape(8.dp),
              colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFB7185),
                unfocusedBorderColor = Color(0xFF881337),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
              ),
              modifier = Modifier.weight(1f)
            )
          }

          val weight = weightInput.toDoubleOrNull() ?: 0.0
          val heightCm = heightCmInput.toDoubleOrNull() ?: 0.0
          val heightM = heightCm / 100.0

          val bmiValue = if (heightM > 0 && weight > 0) {
            weight / (heightM * heightM)
          } else 0.0

          val (bmiCategory, categoryColor, adviceText) = when {
            bmiValue <= 0 -> Triple("අගයන් ඇතුළත් කරන්න", Color.Gray, "කරුණාකර නිවැරදි උස හා බර ඇතුළත් කරන්න.")
            bmiValue < 18.5 -> Triple("අඩු බර (Underweight)", Color(0xFF38BDF8), "ප්‍රෝටීන හා පෝෂ්‍ය පදාර්ථ බහුල සමබල ආහාර වේලක් ලබාගන්න.")
            bmiValue <= 24.9 -> Triple("නිරෝගී / ප්‍රශස්ත බර (Normal)", Color(0xFF4ADE80), "ඉතා යහපත්ය! දිනපතා ව්‍යායාම හා සමබල ආහාරය අඛණ්ඩව පවත්වා ගන්න.")
            bmiValue <= 29.9 -> Triple("අධිබර (Overweight)", Color(0xFFFBBF24), "සීනි, තෙල් ආහාර අඩු කර දිනපතා අවම විනාඩි 45ක් ක්‍රියාශීලී ව්‍යායාම කරන්න.")
            else -> Triple("ස්ථුලතාව (Obese)", Color(0xFFF87171), "වහාම වෛද්‍ය උපදෙස් ලබාගෙන බර පාලන ආහාර හා ව්‍යායාම සැලැස්මකට යොමුවන්න.")
          }

          Spacer(modifier = Modifier.height(12.dp))
          Surface(
            shape = RoundedCornerShape(10.dp),
            color = Color(0xFF1E050E),
            border = BorderStroke(1.dp, categoryColor.copy(alpha = 0.6f)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(12.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = "ඔබගේ BMI අගය: ${String.format("%.1f", bmiValue)} kg/m²",
                  fontSize = 14.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )
                Surface(
                  color = categoryColor.copy(alpha = 0.2f),
                  border = BorderStroke(1.dp, categoryColor),
                  shape = RoundedCornerShape(6.dp)
                ) {
                  Text(
                    text = bmiCategory,
                    color = categoryColor,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                  )
                }
              }

              Spacer(modifier = Modifier.height(6.dp))
              Text(
                text = "📌 සෞඛ්‍ය උපදෙස: $adviceText",
                fontSize = 11.sp,
                color = Color(0xFFFFD1DC),
                lineHeight = 15.sp
              )
            }
          }
      }
    }

    // 2. TOURNAMENTS FIXTURE CALCULATOR CARD
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1C1917)),
        border = BorderStroke(1.2.dp, Color(0xFFD97706)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text("🏆", fontSize = 20.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Column {
              Text(
                text = "ක්‍රීඩා තරගාවලි සූත්‍ර ගණකය (Tournament Calculator)",
                fontSize = 14.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Text(
                text = "Knockout තරග, Byes (වරප්‍රසාද) සහ League තරග ගණනය",
                fontSize = 11.sp,
                color = Color(0xFFFDE68A)
              )
            }
          }

          Spacer(modifier = Modifier.height(12.dp))
          OutlinedTextField(
            value = tournamentTeamsInput,
            onValueChange = { tournamentTeamsInput = it },
            label = { Text("කණ්ඩායම් සංඛ්‍යාව (N)", color = Color(0xFFFDE68A), fontSize = 11.sp) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
              focusedBorderColor = Color(0xFFF59E0B),
              unfocusedBorderColor = Color(0xFF78350F),
              focusedTextColor = Color.White,
              unfocusedTextColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
          )

          val teams = tournamentTeamsInput.toIntOrNull() ?: 0

          val knockoutMatches = if (teams > 1) teams - 1 else 0

          // Calculate Byes: 2^n - N where 2^n >= N
          val nextPowerOf2 = if (teams > 0) {
            val power = ceil(log2(teams.toDouble())).toInt()
            2.0.pow(power.toDouble()).toInt()
          } else 0
          val byesCount = if (teams > 0) nextPowerOf2 - teams else 0
          val roundsCount = if (teams > 0) ceil(log2(teams.toDouble())).toInt() else 0

          val leagueMatches = if (teams > 1) (teams * (teams - 1)) / 2 else 0

          Spacer(modifier = Modifier.height(12.dp))
          Surface(
            shape = RoundedCornerShape(10.dp),
            color = Color(0xFF292524),
            border = BorderStroke(1.dp, Color(0xFFF59E0B)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(12.dp)) {
              Text(
                text = "⚡ පිළිමලුන් පිටුදැකීමේ ක්‍රමය (Knockout System):",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFBBF24)
              )
              Text(
                text = "• මුළු තරග ගණන = N - 1 = $teams - 1 = $knockoutMatches තරග",
                fontSize = 11.5.sp,
                color = Color.White
              )
              Text(
                text = "• Byes (වරප්‍රසාද) = 2ⁿ - N = $nextPowerOf2 - $teams = $byesCount Byes",
                fontSize = 11.5.sp,
                color = Color(0xFF86EFAC),
                fontWeight = FontWeight.SemiBold
              )
              Text(
                text = "• මුළු වට සංඛ්‍යාව (Rounds) = $roundsCount වට",
                fontSize = 11.sp,
                color = Color(0xFFE2E8F0)
              )

              Spacer(modifier = Modifier.height(8.dp))
              HorizontalDivider(color = Color(0xFF44403C), thickness = 0.8.dp)
              Spacer(modifier = Modifier.height(8.dp))

              Text(
                text = "⚽ ලීග් ක්‍රමය (League / Round-Robin System):",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF38BDF8)
              )
              Text(
                text = "• මුළු තරග ගණන = N(N - 1) / 2 = ($teams × ${teams - 1}) / 2 = $leagueMatches තරග",
                fontSize = 11.5.sp,
                color = Color.White
              )
            }
          }
        }
      }
    }
  }

// ============================================================================
// 5. FIRST AID SECTION
// ============================================================================
@Composable
private fun HealthFirstAidSection(
  searchQuery: String,
  expandedFirstAidId: String?,
  onToggleExpand: (String) -> Unit
) {
  val guides = remember(searchQuery) {
    HealthMasterDataProvider.firstAidGuides.filter { item ->
      searchQuery.isBlank() ||
          item.title.contains(searchQuery, ignoreCase = true) ||
          item.injuryType.contains(searchQuery, ignoreCase = true) ||
          item.immediateSteps.any { it.contains(searchQuery, ignoreCase = true) }
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(12.dp),
    verticalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFF7F1D1D).copy(alpha = 0.4f)),
      border = BorderStroke(1.dp, Color(0xFFEF4444))
    ) {
      Row(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text("🩹", fontSize = 20.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "ක්‍රීඩා පිටියේ සහ එදිනෙදා ජීවිතයේ සිදුවන හදිසි අනතුරුවලදී අනුගමනය කළ යුතු විද්‍යාත්මක ප්‍රථමාධාර මාර්ගෝපදේශය.",
          fontSize = 11.5.sp,
          color = Color(0xFFFECACA),
          lineHeight = 16.sp
        )
      }
    }

    guides.forEach { guide ->
      val isExpanded = expandedFirstAidId == guide.id

      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2C0A16)),
        border = BorderStroke(1.dp, if (isExpanded) Color(0xFFF87171) else Color(0xFF4C0519)),
        modifier = Modifier
          .fillMaxWidth()
          .clickable { onToggleExpand(guide.id) }
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Surface(
              color = Color(0xFFDC2626),
              shape = RoundedCornerShape(4.dp)
            ) {
              Text(
                text = guide.injuryType,
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
              imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
              contentDescription = null,
              tint = Color(0xFFF87171)
            )
          }

          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = guide.title,
            fontSize = 13.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )

          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = "⚠️ ප්‍රධාන රෝග ලක්ෂණ:",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFDE047)
          )
          guide.symptoms.forEach { sym ->
            Row(modifier = Modifier.padding(vertical = 1.dp)) {
              Text("•", color = Color(0xFFFBBF24), fontSize = 11.sp)
              Spacer(modifier = Modifier.width(5.dp))
              Text(text = sym, fontSize = 11.sp, color = Color(0xFFE2E8F0))
            }
          }

          AnimatedVisibility(
            visible = isExpanded,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
          ) {
            Column(modifier = Modifier.padding(top = 10.dp)) {
              HorizontalDivider(color = Color(0xFF4C0519), thickness = 0.8.dp)
              Spacer(modifier = Modifier.height(8.dp))

              Text(
                text = "✅ ක්ෂණික ප්‍රථමාධාර පියවර:",
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4ADE80)
              )
              guide.immediateSteps.forEach { step ->
                Row(modifier = Modifier.padding(vertical = 2.dp)) {
                  Text("✓", color = Color(0xFF22C55E), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(text = step, fontSize = 11.sp, color = Color.White, lineHeight = 15.sp)
                }
              }

              Spacer(modifier = Modifier.height(8.dp))
              Surface(
                color = Color(0xFF7F1D1D).copy(alpha = 0.3f),
                shape = RoundedCornerShape(6.dp),
                border = BorderStroke(0.8.dp, Color(0xFFEF4444))
              ) {
                Row(
                  modifier = Modifier.padding(6.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text("🚫", fontSize = 12.sp)
                  Spacer(modifier = Modifier.width(5.dp))
                  Text(
                    text = guide.warningNote,
                    fontSize = 10.5.sp,
                    color = Color(0xFFFCA5A5),
                    lineHeight = 14.sp
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

// ============================================================================
// 6. LIFE SKILLS SECTION
// ============================================================================
@Composable
private fun HealthLifeSkillsSection(searchQuery: String) {
  val skills = remember(searchQuery) {
    HealthMasterDataProvider.lifeSkills.filter { s ->
      searchQuery.isBlank() ||
          s.skillNameSinhala.contains(searchQuery, ignoreCase = true) ||
          s.skillNameEnglish.contains(searchQuery, ignoreCase = true) ||
          s.description.contains(searchQuery, ignoreCase = true) ||
          s.practicalApplication.contains(searchQuery, ignoreCase = true)
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(12.dp),
    verticalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFF581C87).copy(alpha = 0.35f)),
      border = BorderStroke(1.dp, Color(0xFF9333EA))
    ) {
      Row(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text("🧠", fontSize = 20.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "ලෝක සෞඛ්‍ය සංවිධානය (WHO) හඳුන්වා දුන් ජීවන කුසලතා 10 සහ එදිනෙදා ජීවිතයේදී ඒවා ප්‍රායෝගිකව යොදාගන්නා ආකාරය.",
          fontSize = 11.5.sp,
          color = Color(0xFFE9D5FF),
          lineHeight = 16.sp
        )
      }
    }

    skills.forEach { s ->
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E102E)),
        border = BorderStroke(1.dp, Color(0xFF4C1D95)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Surface(
              color = Color(0xFF7C3AED),
              shape = RoundedCornerShape(4.dp)
            ) {
              Text(
                text = s.category,
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "${s.skillNameSinhala} (${s.skillNameEnglish})",
              fontSize = 13.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
          }

          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = s.description,
            fontSize = 11.5.sp,
            color = Color(0xFFE2E8F0),
            lineHeight = 16.sp
          )

          Spacer(modifier = Modifier.height(8.dp))
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFF2E1065),
            border = BorderStroke(0.8.dp, Color(0xFF6D28D9)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(
              modifier = Modifier.padding(8.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text("🌟", fontSize = 13.sp)
              Spacer(modifier = Modifier.width(6.dp))
              Column {
                Text(
                  text = "ප්‍රායෝගික ජීවිතයට භාවිතය:",
                  fontSize = 10.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFFD8B4FE)
                )
                Text(
                  text = s.practicalApplication,
                  fontSize = 11.sp,
                  color = Color.White,
                  lineHeight = 15.sp
                )
              }
            }
          }
        }
      }
    }
  }
}

// ============================================================================
// 7. SHORT NOTES & FLASHCARDS SECTION
// ============================================================================
@Composable
private fun HealthShortNotesSection(gradeTab: HealthGradeTab, searchQuery: String) {
  val filteredNotes = remember(gradeTab, searchQuery) {
    HealthMasterDataProvider.shortNoteCards.filter { note ->
      val matchesGrade = when (gradeTab) {
        HealthGradeTab.ALL -> true
        HealthGradeTab.GRADE_10 -> note.grade == "10"
        HealthGradeTab.GRADE_11 -> note.grade == "11"
      }
      val matchesSearch = searchQuery.isBlank() ||
          note.topic.contains(searchQuery, ignoreCase = true) ||
          note.questionPrompt.contains(searchQuery, ignoreCase = true) ||
          note.answerText.contains(searchQuery, ignoreCase = true) ||
          note.keyFact.contains(searchQuery, ignoreCase = true)
      matchesGrade && matchesSearch
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(12.dp),
    verticalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFF78350F).copy(alpha = 0.35f)),
      border = BorderStroke(1.dp, Color(0xFFF59E0B))
    ) {
      Row(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text("⚡", fontSize = 20.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "O/L විභාගයේදී අනිවාර්යයෙන්ම පරීක්ෂා කරන ප්‍රධාන විෂය කරුණු සහ ක්ෂණික මතක පද පහතින් අධ්‍යයනය කරන්න.",
          fontSize = 11.5.sp,
          color = Color(0xFFFEF3C7),
          lineHeight = 16.sp
        )
      }
    }

    filteredNotes.forEach { note ->
      var isRevealed by remember { mutableStateOf(false) }

      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2C1802)),
        border = BorderStroke(1.dp, if (isRevealed) Color(0xFFF59E0B) else Color(0xFF78350F)),
        modifier = Modifier
          .fillMaxWidth()
          .clickable { isRevealed = !isRevealed }
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
                text = "${note.grade} ශ්‍රේණිය • ${note.topic}",
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
            Text(
              text = if (isRevealed) "💡 සඟවන්න" else "👉 පිළිතුර බලන්න",
              color = Color(0xFFFBBF24),
              fontSize = 10.5.sp,
              fontWeight = FontWeight.Bold
            )
          }

          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = "❓ ${note.questionPrompt}",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            lineHeight = 17.sp
          )

          if (isRevealed) {
            Spacer(modifier = Modifier.height(8.dp))
            Surface(
              shape = RoundedCornerShape(8.dp),
              color = Color(0xFF451A03),
              border = BorderStroke(1.dp, Color(0xFFF59E0B)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(10.dp)) {
                Text(
                  text = "✅ පිළිතුර: ${note.answerText}",
                  fontSize = 11.5.sp,
                  color = Color(0xFFFEF3C7),
                  fontWeight = FontWeight.SemiBold,
                  lineHeight = 16.sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                  text = "📌 අනිවාර්ය විභාග කරුණ: ${note.keyFact}",
                  fontSize = 11.sp,
                  color = Color(0xFF4ADE80),
                  fontWeight = FontWeight.Bold
                )
              }
            }
          }
        }
      }
    }
  }
}

// ============================================================================
// 8. SPORTS RULES SECTION
// ============================================================================
@Composable
private fun HealthSportsRulesSection(searchQuery: String) {
  val rules = remember(searchQuery) {
    HealthMasterDataProvider.sportsRules.filter { s ->
      searchQuery.isBlank() ||
          s.sportName.contains(searchQuery, ignoreCase = true) ||
          s.keyRules.any { it.contains(searchQuery, ignoreCase = true) } ||
          s.foulsAndViolations.any { it.contains(searchQuery, ignoreCase = true) }
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(12.dp),
    verticalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFF14532D).copy(alpha = 0.35f)),
      border = BorderStroke(1.dp, Color(0xFF22C55E))
    ) {
      Row(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text("🏆", fontSize = 20.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "ශ්‍රී ලංකා ජාතික සහ පාසල් මට්ටමේ නිල ක්‍රීඩා නීතිරීති, පිටි මිනුම් සහ දඬුවම් පිළිබඳ සම්පූර්ණ විස්තරය.",
          fontSize = 11.5.sp,
          color = Color(0xFFDCFCE7),
          lineHeight = 16.sp
        )
      }
    }

    rules.forEach { item ->
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF052E16)),
        border = BorderStroke(1.dp, Color(0xFF15803D)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text(item.iconEmoji, fontSize = 20.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Column {
              Text(
                text = item.sportName,
                fontSize = 14.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Text(
                text = "📏 ${item.courtDimensions}",
                fontSize = 10.5.sp,
                color = Color(0xFF86EFAC)
              )
            }
          }

          Spacer(modifier = Modifier.height(8.dp))
          Surface(
            color = Color(0xFF14532D),
            shape = RoundedCornerShape(6.dp)
          ) {
            Text(
              text = "👥 සාමාජිකයින්: ${item.teamMembers}",
              fontSize = 10.5.sp,
              color = Color.White,
              fontWeight = FontWeight.SemiBold,
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
            )
          }

          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = "📌 ප්‍රධාන නීතිරීති (Key Rules):",
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFDE047)
          )
          item.keyRules.forEach { r ->
            Row(modifier = Modifier.padding(vertical = 1.5.dp)) {
              Text("•", color = Color(0xFF22C55E), fontSize = 11.sp, fontWeight = FontWeight.Bold)
              Spacer(modifier = Modifier.width(5.dp))
              Text(text = r, fontSize = 11.sp, color = Color.White, lineHeight = 15.sp)
            }
          }

          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = "⚠️ වැරදි සහ දඬුවම් (Fouls & Violations):",
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFF87171)
          )
          item.foulsAndViolations.forEach { f ->
            Row(modifier = Modifier.padding(vertical = 1.5.dp)) {
              Text("x", color = Color(0xFFEF4444), fontSize = 11.sp, fontWeight = FontWeight.Bold)
              Spacer(modifier = Modifier.width(5.dp))
              Text(text = f, fontSize = 11.sp, color = Color(0xFFFFD1DC), lineHeight = 15.sp)
            }
          }

          Spacer(modifier = Modifier.height(8.dp))
          Surface(
            color = Color(0xFF166534),
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Text(
              text = "🎯 විභාග ඉඟිය: ${item.examTip}",
              fontSize = 10.5.sp,
              color = Color(0xFFBBF7D0),
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(8.dp)
            )
          }
        }
      }
    }
  }
}

// ============================================================================
// 9. PRACTICAL EXAMS SECTION
// ============================================================================
@Composable
private fun HealthPracticalExamsSection(searchQuery: String) {
  val practicals = remember(searchQuery) {
    HealthMasterDataProvider.practicalExams.filter { p ->
      searchQuery.isBlank() ||
          p.testName.contains(searchQuery, ignoreCase = true) ||
          p.componentTested.contains(searchQuery, ignoreCase = true) ||
          p.procedureSteps.any { it.contains(searchQuery, ignoreCase = true) }
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(12.dp),
    verticalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFF0369A1).copy(alpha = 0.35f)),
      border = BorderStroke(1.dp, Color(0xFF0284C7))
    ) {
      Row(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text("📋", fontSize = 20.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "O/L සෞඛ්‍ය හා ශාරීරික අධ්‍යාපන ප්‍රායෝගික පරීක්ෂණ, Harvard Step Test, YOYO Test සහ මිනුම් පටිපාටි.",
          fontSize = 11.5.sp,
          color = Color(0xFFE0F2FE),
          lineHeight = 16.sp
        )
      }
    }

    practicals.forEach { prac ->
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0C4A6E)),
        border = BorderStroke(1.dp, Color(0xFF0369A1)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Text(
            text = prac.testName,
            fontSize = 14.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
          Spacer(modifier = Modifier.height(4.dp))
          Surface(
            color = Color(0xFF0284C7),
            shape = RoundedCornerShape(4.dp)
          ) {
            Text(
              text = "මැනෙන සංරචකය: ${prac.componentTested}",
              color = Color.White,
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }

          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = "🛠️ අවශ්‍ය උපකරණ: ${prac.equipmentNeeded}",
            fontSize = 11.sp,
            color = Color(0xFFBAE6FD)
          )

          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = "📝 පරීක්ෂණ පියවර (Procedure):",
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFDE047)
          )
          prac.procedureSteps.forEach { step ->
            Row(modifier = Modifier.padding(vertical = 1.5.dp)) {
              Text("•", color = Color(0xFF38BDF8), fontSize = 11.sp, fontWeight = FontWeight.Bold)
              Spacer(modifier = Modifier.width(5.dp))
              Text(text = step, fontSize = 11.sp, color = Color.White, lineHeight = 15.sp)
            }
          }

          Spacer(modifier = Modifier.height(8.dp))
          Surface(
            color = Color(0xFF075985),
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(8.dp)) {
              Text(
                text = "🧮 ලකුණු/දර්ශක සූත්‍රය: ${prac.scoringFormula}",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF7DD3FC)
              )
              Spacer(modifier = Modifier.height(2.dp))
              Text(
                text = "📊 මට්ටම් ප්‍රමිතිය: ${prac.gradeStandards}",
                fontSize = 10.5.sp,
                color = Color.White
              )
            }
          }
        }
      }
    }
  }
}

// ============================================================================
// 10. AYURVEDA & WELLNESS SECTION
// ============================================================================
@Composable
private fun HealthAyurvedaSection(searchQuery: String) {
  val cards = remember(searchQuery) {
    HealthMasterDataProvider.ayurvedaCards.filter { a ->
      searchQuery.isBlank() ||
          a.plantOrConceptName.contains(searchQuery, ignoreCase = true) ||
          a.category.contains(searchQuery, ignoreCase = true) ||
          a.healthBenefits.any { it.contains(searchQuery, ignoreCase = true) }
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(12.dp),
    verticalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFF065F46).copy(alpha = 0.35f)),
      border = BorderStroke(1.dp, Color(0xFF10B981))
    ) {
      Row(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text("🌿", fontSize = 20.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "ශ්‍රී ලංකාවේ දේශීය හෙළ වෙදකම, ආයුර්වේද ත්‍රිදෝෂ න්‍යාය, ඔසු පැළෑටි සහ දේශීය සෞඛ්‍යාරක්ෂිත ආහාර පුරුදු.",
          fontSize = 11.5.sp,
          color = Color(0xFFD1FAE5),
          lineHeight = 16.sp
        )
      }
    }

    cards.forEach { item ->
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF022C22)),
        border = BorderStroke(1.dp, Color(0xFF047857)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = item.plantOrConceptName,
              fontSize = 14.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Surface(
              color = Color(0xFF059669),
              shape = RoundedCornerShape(4.dp)
            ) {
              Text(
                text = item.category,
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
          }

          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = "💡 ඖෂධීය අගය: ${item.medicinalValue}",
            fontSize = 11.5.sp,
            color = Color(0xFFA7F3D0),
            lineHeight = 16.sp
          )

          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "🌱 භාවිත වන කොටස: ${item.usedPart}",
            fontSize = 11.sp,
            color = Color(0xFF6EE7B7)
          )

          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = "✨ සෞඛ්‍යමය වාසි (Health Benefits):",
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFDE047)
          )
          item.healthBenefits.forEach { b ->
            Row(modifier = Modifier.padding(vertical = 1.5.dp)) {
              Text("•", color = Color(0xFF34D399), fontSize = 11.sp, fontWeight = FontWeight.Bold)
              Spacer(modifier = Modifier.width(5.dp))
              Text(text = b, fontSize = 11.sp, color = Color.White, lineHeight = 15.sp)
            }
          }

          Spacer(modifier = Modifier.height(8.dp))
          Surface(
            color = Color(0xFF064E3B),
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Text(
              text = "🎯 විභාග ඉඟිය: ${item.examTip}",
              fontSize = 10.5.sp,
              color = Color(0xFF6EE7B7),
              fontWeight = FontWeight.Bold,
            )
          }
        }
      }
    }
  }
}

// ============================================================================
// HEALTH MASTER OVERVIEW GRID VIEW (ALL 10 SUB-SECTIONS COLLECTION)
// ============================================================================
@Composable
private fun HealthMasterOverviewGrid(
  selectedGradeTab: HealthGradeTab,
  searchQuery: String,
  onSelectCategory: (HealthSectionCategory) -> Unit
) {
  val categories = remember(searchQuery) {
    HealthSectionCategory.values().filter { cat ->
      searchQuery.isBlank() ||
          cat.titleSinhala.contains(searchQuery, ignoreCase = true) ||
          cat.subtitle.contains(searchQuery, ignoreCase = true)
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 12.dp, vertical = 10.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    // Header Hero Banner matching Science Master Hub (image_975c63c8.png)
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF3B0B1D)),
        border = BorderStroke(1.5.dp, Color(0xFFE11D48)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
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
                shape = CircleShape,
                color = Color(0xFFE11D48).copy(alpha = 0.25f),
                modifier = Modifier.size(40.dp)
              ) {
                Box(contentAlignment = Alignment.Center) {
                  Text("🏃‍♂️", fontSize = 22.sp)
                }
              }
              Spacer(modifier = Modifier.width(10.dp))
              Column {
                Text(
                  text = "10 & 11 සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය",
                  fontSize = 15.sp,
                  fontWeight = FontWeight.ExtraBold,
                  color = Color.White
                )
                Text(
                  text = "Health & Physical Education • Master Hub",
                  fontSize = 11.sp,
                  color = Color(0xFFFDA4AF)
                )
              }
            }

            Surface(
              shape = RoundedCornerShape(20.dp),
              color = Color(0xFF10B981)
            ) {
              Text(
                text = "100% ආවරණය",
                color = Color.White,
                fontSize = 10.5.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
              )
            }
          }

          Spacer(modifier = Modifier.height(10.dp))
          HorizontalDivider(color = Color(0xFF881337).copy(alpha = 0.6f), thickness = 1.dp)
          Spacer(modifier = Modifier.height(8.dp))

          Text(
            text = "පාඩම් • MCQs • රචනා • BMI ගණක • RICE ප්‍රථමාධාර • WHO ජීවන කුසලතා • ක්‍රීඩා නීති • ප්‍රායෝගික • හෙළ වෙද",
            fontSize = 11.sp,
            color = Color(0xFFFFE4E6),
            lineHeight = 15.sp
          )
        }
      }
    }

    // Grid of all 10 sub-section categories (2 columns of cards side-by-side going down)
    categories.chunked(2).forEach { rowItems ->
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        rowItems.forEach { cat ->
          Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF2C0A16)),
            border = BorderStroke(1.2.dp, cat.themeColor.copy(alpha = 0.85f)),
            modifier = Modifier
              .weight(1f)
              .clickable { onSelectCategory(cat) }
              .testTag("health_overview_card_${cat.id}")
          ) {
            Column(
              modifier = Modifier.padding(12.dp),
              verticalArrangement = Arrangement.SpaceBetween
            ) {
              // Top row: Emoji Icon & Badge
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Surface(
                  shape = CircleShape,
                  color = cat.themeColor.copy(alpha = 0.25f),
                  modifier = Modifier.size(38.dp)
                ) {
                  Box(contentAlignment = Alignment.Center) {
                    Text(cat.emoji, fontSize = 20.sp)
                  }
                }
                Surface(
                  color = cat.themeColor,
                  shape = RoundedCornerShape(6.dp)
                ) {
                  Text(
                    text = when (cat) {
                      HealthSectionCategory.LESSONS -> "10 & 11 ඒකක"
                      HealthSectionCategory.MCQ_BANK -> "O/L I MCQ"
                      HealthSectionCategory.STRUCTURED_ESSAY -> "O/L II රචනා"
                      HealthSectionCategory.CALCULATORS -> "සූත්‍ර & ගණනය"
                      HealthSectionCategory.FIRST_AID -> "RICE පියවර"
                      HealthSectionCategory.LIFE_SKILLS -> "WHO 10"
                      HealthSectionCategory.SHORT_NOTES -> "කරුණු 200"
                      HealthSectionCategory.SPORTS_RULES -> "නීතිරීති 15"
                      HealthSectionCategory.PRACTICAL_EXAMS -> "Fitness Test"
                      HealthSectionCategory.AYURVEDA_WELLNESS -> "හෙළ ඔසු පැළ"
                    },
                    color = Color.White,
                    fontSize = 9.5.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.5.dp)
                  )
                }
              }

              Spacer(modifier = Modifier.height(10.dp))
              Text(
                text = cat.titleSinhala,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 17.sp
              )
              Spacer(modifier = Modifier.height(3.dp))
              Text(
                text = cat.subtitle,
                fontSize = 10.5.sp,
                color = Color(0xFFFDA4AF),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 14.sp
              )

              Spacer(modifier = Modifier.height(12.dp))
              Surface(
                color = cat.themeColor.copy(alpha = 0.18f),
                border = BorderStroke(0.8.dp, cat.themeColor.copy(alpha = 0.8f)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(
                    text = "අන්තර්ගතය බලන්න",
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                  )
                  Text("➔", fontSize = 11.sp, color = cat.themeColor, fontWeight = FontWeight.Bold)
                }
              }
            }
          }
        }
        if (rowItems.size < 2) {
          Spacer(modifier = Modifier.weight(1f))
        }
      }
    }
  }

