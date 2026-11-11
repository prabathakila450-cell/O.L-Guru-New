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
 * 🌟 100% ACCURATE GRADE 10 & 11 CIVIC EDUCATION (පුරවැසි අධ්‍යාපනය) MASTER HUB
 * Includes:
 * 1. All 12 Curriculum Lessons with Core Rules, Summaries, and Exam Tips
 * 2. O/L I MCQ Bank with Detailed Explanations
 * 3. O/L II Structured & Essay Questions with Official Marking Schemes
 * 4. Constitutional Evolution Interactive Timeline (1833 to Modern Amendments)
 * 5. Practical Civic Case Studies & Decision Dilemmas
 * 6. State Structure & Judicial Hierarchy Flowcharts
 */
@Composable
fun CivicsGrade10And11MasterHubDialog(
  initialGradeTab: CivicsGradeTab = CivicsGradeTab.ALL,
  initialSectionCategory: CivicsSectionCategory? = null,
  onDismiss: () -> Unit
) {
  var selectedGradeTab by remember { mutableStateOf(initialGradeTab) }
  var selectedCategory by remember { mutableStateOf<CivicsSectionCategory?>(initialSectionCategory) }
  var searchQuery by remember { mutableStateOf("") }

  // State for MCQ interactive test
  val userSelectedOptions = remember { mutableStateMapOf<Int, Int>() }
  var mcqScore by remember { mutableIntStateOf(0) }

  // Expanded items state
  var expandedLessonId by remember { mutableStateOf<String?>(null) }
  var expandedEssayId by remember { mutableStateOf<String?>(null) }
  var expandedCaseId by remember { mutableStateOf<String?>(null) }

  LaunchedEffect(selectedGradeTab) {
    selectedCategory = null
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
        .testTag("civics_master_hub_dialog"),
      color = Color(0xFF041E18)
    ) {
      Column(modifier = Modifier.fillMaxSize()) {
        // TOP APP BAR: Ultra-compact Emerald Theme (Minimizes screen height)
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .background(
              Brush.verticalGradient(
                colors = listOf(Color(0xFF0F766E), Color(0xFF115E59))
              )
            )
            .statusBarsPadding()
            .padding(horizontal = 10.dp, vertical = 3.dp)
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .height(34.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            IconButton(
              onClick = onDismiss,
              modifier = Modifier
                .size(30.dp)
                .testTag("civics_hub_back_btn")
            ) {
              Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier.size(18.dp)
              )
            }
            Spacer(modifier = Modifier.width(4.dp))
            Column(modifier = Modifier.weight(1f)) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text("⚖️", fontSize = 14.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                  text = "පුරවැසි අධ්‍යාපනය Master Hub",
                  color = Color.White,
                  fontSize = 13.5.sp,
                  fontWeight = FontWeight.Bold,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }
              Text(
                text = "10 & 11 ශ්‍රේණි • විෂය නිර්දේශය • MCQs • රචනා",
                color = Color(0xFFCCFBF1),
                fontSize = 9.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
              )
            }
            Surface(
              color = Color(0xFF14B8A6),
              shape = RoundedCornerShape(8.dp)
            ) {
              Text(
                text = "O/L A+",
                color = Color.White,
                fontSize = 9.5.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
          }
        }

        // MAIN CONTENT AREA
        Box(
          modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color(0xFF021714))
        ) {
          if (selectedCategory == null) {
            CivicsMasterOverviewGrid(
              selectedGradeTab = selectedGradeTab,
              searchQuery = searchQuery,
              onSearchQueryChange = { searchQuery = it },
              onSelectCategory = { cat -> selectedCategory = cat },
              onSelectGrade = { selectedGradeTab = it }
            )
          } else {
            // ALL SECTIONS NOW MANAGE THEIR OWN SCROLLABLE HEADER & BACK BUTTON
            when (selectedCategory) {
              CivicsSectionCategory.LESSONS -> {
                CivicsLessonsSection(
                  gradeTab = selectedGradeTab,
                  searchQuery = searchQuery,
                  expandedLessonId = expandedLessonId,
                  onToggleExpand = { id ->
                    expandedLessonId = if (expandedLessonId == id) null else id
                  },
                  onBack = { selectedCategory = null }
                )
              }
              CivicsSectionCategory.MCQ_BANK -> {
                CivicsMcqSection(
                  gradeTab = selectedGradeTab,
                  searchQuery = searchQuery,
                  userSelectedOptions = userSelectedOptions,
                  onSelectOption = { qId, optIdx ->
                    userSelectedOptions[qId] = optIdx
                  },
                  onResetQuiz = {
                    userSelectedOptions.clear()
                  },
                  onBack = { selectedCategory = null }
                )
              }
              CivicsSectionCategory.STRUCTURED_ESSAY -> {
                CivicsStructuredEssaySection(
                  gradeTab = selectedGradeTab,
                  searchQuery = searchQuery,
                  expandedEssayId = expandedEssayId,
                  onToggleExpand = { id ->
                    expandedEssayId = if (expandedEssayId == id) null else id
                  },
                  onBack = { selectedCategory = null }
                )
              }
              CivicsSectionCategory.TIMELINE -> {
                CivicsTimelineSection(searchQuery = searchQuery, onBack = { selectedCategory = null })
              }
              CivicsSectionCategory.CASE_STUDIES -> {
                CivicsCaseStudiesSection(
                  searchQuery = searchQuery,
                  expandedCaseId = expandedCaseId,
                  onToggleExpand = { id ->
                    expandedCaseId = if (expandedCaseId == id) null else id
                  },
                  onBack = { selectedCategory = null }
                )
              }
              CivicsSectionCategory.FLOWCHARTS -> {
                CivicsFlowchartsSection(searchQuery = searchQuery, onBack = { selectedCategory = null })
              }
              CivicsSectionCategory.HUMAN_RIGHTS -> {
                CivicsHumanRightsSection(searchQuery = searchQuery, onBack = { selectedCategory = null })
              }
              CivicsSectionCategory.LOCAL_GOVT -> {
                CivicsLocalGovtSection(searchQuery = searchQuery, onBack = { selectedCategory = null })
              }
              CivicsSectionCategory.GOOD_GOVERNANCE -> {
                CivicsGoodGovernanceSection(searchQuery = searchQuery, onBack = { selectedCategory = null })
              }
              CivicsSectionCategory.GLOBAL_RELATIONS -> {
                CivicsGlobalRelationsSection(searchQuery = searchQuery, onBack = { selectedCategory = null })
              }
              null -> {}
          }
        }
      }
    }
  }
}
}

/**
 * 🛠️ SHARED SCROLLABLE HEADER FOR SUB-SECTIONS
 */
@Composable
private fun CivicsSubSectionHeader(
  category: CivicsSectionCategory,
  onBack: () -> Unit
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(Color(0xFF02201D))
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 6.dp),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Surface(
        onClick = onBack,
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFF0F766E),
        border = BorderStroke(1.dp, Color(0xFF2DD4BF))
      ) {
        Text(
          text = "◀ මෙනුවට යන්න",
          fontSize = 10.5.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White,
          modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
      }
      Text(
        text = "${category.emoji} ${category.shortTitleSinhala}",
        color = Color(0xFF5EEAD4),
        fontSize = 11.5.sp,
        fontWeight = FontWeight.Bold
      )
    }
    HorizontalDivider(color = Color(0xFF115E59), thickness = 1.dp)
  }
}

// ============================================================================
// 1. LESSONS SECTION
// ============================================================================
@Composable
private fun CivicsLessonsSection(
  gradeTab: CivicsGradeTab,
  searchQuery: String,
  expandedLessonId: String?,
  onToggleExpand: (String) -> Unit,
  onBack: () -> Unit
) {
  val filteredLessons = remember(gradeTab, searchQuery) {
    CivicsMasterDataProvider.allLessons.filter { lesson ->
      val matchesGrade = when (gradeTab) {
        CivicsGradeTab.ALL -> true
        CivicsGradeTab.GRADE_10 -> lesson.grade == "10"
        CivicsGradeTab.GRADE_11 -> lesson.grade == "11"
      }
      val matchesSearch = searchQuery.isBlank() ||
          lesson.titleSinhala.contains(searchQuery, ignoreCase = true) ||
          lesson.titleEnglish.contains(searchQuery, ignoreCase = true) ||
          lesson.keyConcepts.any { it.contains(searchQuery, ignoreCase = true) } ||
          lesson.fullSummary.contains(searchQuery, ignoreCase = true)
      matchesGrade && matchesSearch
    }
  }

  if (filteredLessons.isEmpty()) {
    Column(modifier = Modifier.fillMaxSize()) {
      CivicsSubSectionHeader(CivicsSectionCategory.LESSONS, onBack)
      EmptyResultNotice("සෙවුමට ගැළපෙන පුරවැසි පාඩම් හමු නොවීය.")
    }
    return
  }

  val listState = androidx.compose.foundation.lazy.rememberLazyListState()
  LaunchedEffect(gradeTab, searchQuery) {
    listState.scrollToItem(0)
  }

  LazyColumn(
    state = listState,
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    item {
      CivicsSubSectionHeader(CivicsSectionCategory.LESSONS, onBack)
    }

    item {
      Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F766E).copy(alpha = 0.25f)),
        border = BorderStroke(1.dp, Color(0xFF14B8A6)),
        modifier = Modifier.padding(horizontal = 12.dp)
      ) {
        Row(
          modifier = Modifier.padding(10.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("📖", fontSize = 20.sp)
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "O/L විභාගයට අදාළ සම්පූර්ණ ඒකක ${filteredLessons.size} ක විෂය කරුණු, සූත්‍රිකා සහ විභාග ඉඟි පහතින් අධ්‍යයනය කරන්න.",
            fontSize = 11.5.sp,
            color = Color(0xFFCCFBF1),
            lineHeight = 16.sp
          )
        }
      }
    }

    items(filteredLessons, key = { it.id }) { lesson ->
      Box(modifier = Modifier.padding(horizontal = 12.dp)) {
        val isExpanded = expandedLessonId == lesson.id
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF064E3B).copy(alpha = 0.45f)),
          border = BorderStroke(1.dp, if (isExpanded) Color(0xFF2DD4BF) else Color(0xFF115E59)),
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
                color = if (lesson.grade == "10") Color(0xFF0D9488) else Color(0xFF2563EB),
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
                tint = Color(0xFF2DD4BF)
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
              color = Color(0xFF5EEAD4).copy(alpha = 0.8f)
            )

            Spacer(modifier = Modifier.height(8.dp))
            // Core Principle quote
            Surface(
              color = Color(0xFF022C22),
              shape = RoundedCornerShape(8.dp),
              border = BorderStroke(0.8.dp, Color(0xFF047857))
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
                  color = Color(0xFFA7F3D0),
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
                HorizontalDivider(color = Color(0xFF115E59), thickness = 0.8.dp)
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
                    Text("•", color = Color(0xFF2DD4BF), fontWeight = FontWeight.Bold, fontSize = 13.sp)
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
                  color = Color(0xFFE2E8F0),
                  lineHeight = 17.sp
                )

                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                  color = Color(0xFF78350F).copy(alpha = 0.4f),
                  shape = RoundedCornerShape(8.dp),
                  border = BorderStroke(1.dp, Color(0xFFD97706))
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
                        color = Color(0xFFFDE68A)
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
    item { Spacer(modifier = Modifier.height(20.dp)) }
  }
}

// ============================================================================
// 2. MCQ SECTION (INTERACTIVE WITH EXPLANATIONS)
// ============================================================================
@Composable
private fun CivicsMcqSection(
  gradeTab: CivicsGradeTab,
  searchQuery: String,
  userSelectedOptions: Map<Int, Int>,
  onSelectOption: (Int, Int) -> Unit,
  onResetQuiz: () -> Unit,
  onBack: () -> Unit
) {
  val filteredMcqs = remember(gradeTab, searchQuery) {
    CivicsMasterDataProvider.mcqQuestions.filter { q ->
      val matchesGrade = when (gradeTab) {
        CivicsGradeTab.ALL -> true
        CivicsGradeTab.GRADE_10 -> q.grade == "10"
        CivicsGradeTab.GRADE_11 -> q.grade == "11"
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

  val listState = androidx.compose.foundation.lazy.rememberLazyListState()
  LaunchedEffect(gradeTab, searchQuery) {
    listState.scrollToItem(0)
  }

  LazyColumn(
    state = listState,
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    item {
      CivicsSubSectionHeader(CivicsSectionCategory.MCQ_BANK, onBack)
    }

    item {
      // Score banner
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1B4B)),
        border = BorderStroke(1.dp, Color(0xFF6366F1)),
        modifier = Modifier.padding(horizontal = 12.dp)
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
                color = Color(0xFFA5B4FC)
              )
            }
            Button(
              onClick = onResetQuiz,
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
              contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
              modifier = Modifier.height(30.dp)
            ) {
              Text("නැවත මුල සිට", fontSize = 10.sp, color = Color.White)
            }
          }
        }
      }
    }

    itemsIndexed(filteredMcqs, key = { _, item -> item.id }) { index, q ->
      Box(modifier = Modifier.padding(horizontal = 12.dp)) {
        val selectedOption = userSelectedOptions[q.id]
        val hasAnswered = selectedOption != null

        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
          border = BorderStroke(
            1.dp,
            when {
              !hasAnswered -> Color(0xFF334155)
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
                color = Color(0xFF0284C7),
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
                !hasAnswered -> Color(0xFF1E293B)
                isCorrect -> Color(0xFF14532D)
                isThisSelected -> Color(0xFF7F1D1D)
                else -> Color(0xFF1E293B).copy(alpha = 0.5f)
              }

              val borderColor = when {
                !hasAnswered -> Color(0xFF475569)
                isCorrect -> Color(0xFF4ADE80)
                isThisSelected -> Color(0xFFF87171)
                else -> Color(0xFF334155)
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

            // EXPLANATION
            if (hasAnswered) {
              Spacer(modifier = Modifier.height(8.dp))
              Surface(
                color = Color(0xFF0F2E23),
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
    item { Spacer(modifier = Modifier.height(20.dp)) }
  }
}

// ============================================================================
// 3. STRUCTURED ESSAY SECTION (WITH FULL MARKING SCHEMES)
// ============================================================================
@Composable
private fun CivicsStructuredEssaySection(
  gradeTab: CivicsGradeTab,
  searchQuery: String,
  expandedEssayId: String?,
  onToggleExpand: (String) -> Unit,
  onBack: () -> Unit
) {
  val filteredEssays = remember(gradeTab, searchQuery) {
    CivicsMasterDataProvider.structuredEssays.filter { essay ->
      val matchesGrade = when (gradeTab) {
        CivicsGradeTab.ALL -> true
        CivicsGradeTab.GRADE_10 -> essay.grade == "10"
        CivicsGradeTab.GRADE_11 -> essay.grade == "11"
      }
      val matchesSearch = searchQuery.isBlank() ||
          essay.title.contains(searchQuery, ignoreCase = true) ||
          essay.unitName.contains(searchQuery, ignoreCase = true) ||
          essay.scenarioText.contains(searchQuery, ignoreCase = true)
      matchesGrade && matchesSearch
    }
  }

  val listState = androidx.compose.foundation.lazy.rememberLazyListState()
  LaunchedEffect(gradeTab, searchQuery) {
    listState.scrollToItem(0)
  }

  LazyColumn(
    state = listState,
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    item {
      CivicsSubSectionHeader(CivicsSectionCategory.STRUCTURED_ESSAY, onBack)
    }

    item {
      Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E3A8A).copy(alpha = 0.35f)),
        border = BorderStroke(1.dp, Color(0xFF3B82F6)),
        modifier = Modifier.padding(horizontal = 12.dp)
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
            color = Color(0xFFBFDBFE),
            lineHeight = 16.sp
          )
        }
      }
    }

    items(filteredEssays, key = { it.id }) { essay ->
      Box(modifier = Modifier.padding(horizontal = 12.dp)) {
        val isExpanded = expandedEssayId == essay.id
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
          border = BorderStroke(1.dp, if (isExpanded) Color(0xFF60A5FA) else Color(0xFF1E293B)),
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
                color = Color(0xFF2563EB),
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
                color = Color(0xFF1E293B),
                shape = RoundedCornerShape(4.dp)
              ) {
                Text(
                  text = "ලකුණු 15",
                  color = Color(0xFF93C5FD),
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }
              Spacer(modifier = Modifier.width(4.dp))
              Icon(
                imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                contentDescription = null,
                tint = Color(0xFF60A5FA)
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
              color = Color(0xFF94A3B8),
              lineHeight = 16.sp
            )

            AnimatedVisibility(
              visible = isExpanded,
              enter = fadeIn() + expandVertically(),
              exit = fadeOut() + shrinkVertically()
            ) {
              Column(modifier = Modifier.padding(top = 10.dp)) {
                HorizontalDivider(color = Color(0xFF334155), thickness = 0.8.dp)
                Spacer(modifier = Modifier.height(8.dp))

                essay.subQuestions.forEach { sub ->
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF1E293B),
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
    item { Spacer(modifier = Modifier.height(20.dp)) }
  }
}

// ============================================================================
// 4. CONSTITUTIONAL TIMELINE SECTION
// ============================================================================
@Composable
private fun CivicsTimelineSection(searchQuery: String, onBack: () -> Unit) {
  val timelineItems = remember(searchQuery) {
    CivicsMasterDataProvider.constitutionalTimeline.filter { item ->
      searchQuery.isBlank() ||
          item.year.contains(searchQuery, ignoreCase = true) ||
          item.titleSinhala.contains(searchQuery, ignoreCase = true) ||
          item.description.contains(searchQuery, ignoreCase = true) ||
          item.keyFeatures.any { it.contains(searchQuery, ignoreCase = true) }
    }
  }

  val listState = androidx.compose.foundation.lazy.rememberLazyListState()
  LaunchedEffect(searchQuery) {
    listState.scrollToItem(0)
  }

  LazyColumn(
    state = listState,
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    item {
      CivicsSubSectionHeader(CivicsSectionCategory.TIMELINE, onBack)
    }

    item {
      Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF78350F).copy(alpha = 0.35f)),
        border = BorderStroke(1.dp, Color(0xFFD97706)),
        modifier = Modifier.padding(horizontal = 12.dp)
      ) {
        Row(
          modifier = Modifier.padding(10.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("⏳", fontSize = 20.sp)
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "1833 කෝල්බෲක් ප්‍රතිසංස්කරණයේ සිට 1978 සහ මෑතකාලීන ආණ්ඩුක්‍රම ව්‍යවස්ථා සංශෝධන දක්වා ඓතිහාසික හැරවුම් ලක්ෂ්‍යයන්.",
            fontSize = 11.5.sp,
            color = Color(0xFFFDE68A),
            lineHeight = 16.sp
          )
        }
      }
    }

    items(timelineItems) { item ->
      Box(modifier = Modifier.padding(horizontal = 12.dp)) {
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1C1917)),
          border = BorderStroke(1.dp, Color(0xFF78350F)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Surface(
                color = Color(0xFFD97706),
                shape = RoundedCornerShape(6.dp)
              ) {
                Text(
                  text = item.year,
                  color = Color.White,
                  fontSize = 12.sp,
                  fontWeight = FontWeight.ExtraBold,
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                )
              }
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = item.titleSinhala,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = item.description,
              fontSize = 11.5.sp,
              color = Color(0xFFE7E5E4),
              lineHeight = 16.sp
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "📌 ප්‍රධාන ප්‍රතිසංස්කරණ ලක්ෂණ:",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFFBBF24)
            )
            Spacer(modifier = Modifier.height(4.dp))
            item.keyFeatures.forEach { feat ->
              Row(modifier = Modifier.padding(vertical = 1.5.dp)) {
                Text("•", color = Color(0xFFF59E0B), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = feat, fontSize = 11.sp, color = Color.White, lineHeight = 15.sp)
              }
            }

            Spacer(modifier = Modifier.height(6.dp))
            Surface(
              color = Color(0xFF292524),
              shape = RoundedCornerShape(6.dp)
            ) {
              Row(
                modifier = Modifier.padding(6.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text("⭐", fontSize = 11.sp)
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                  text = item.significance,
                  fontSize = 10.5.sp,
                  color = Color(0xFFFDE68A),
                  lineHeight = 14.sp
                )
              }
            }
          }
        }
      }
    }
    item { Spacer(modifier = Modifier.height(20.dp)) }
  }
}

// ============================================================================
// 5. CIVIC CASE STUDIES SECTION
// ============================================================================
@Composable
private fun CivicsCaseStudiesSection(
  searchQuery: String,
  expandedCaseId: String?,
  onToggleExpand: (String) -> Unit,
  onBack: () -> Unit
) {
  val caseItems = remember(searchQuery) {
    CivicsMasterDataProvider.caseStudies.filter { caseItem ->
      searchQuery.isBlank() ||
          caseItem.title.contains(searchQuery, ignoreCase = true) ||
          caseItem.situation.contains(searchQuery, ignoreCase = true) ||
          caseItem.correctCourseOfAction.contains(searchQuery, ignoreCase = true)
    }
  }

  val listState = rememberLazyListState()
  LaunchedEffect(searchQuery) {
    listState.scrollToItem(0)
  }

  LazyColumn(
    state = listState,
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    item {
      CivicsSubSectionHeader(CivicsSectionCategory.CASE_STUDIES, onBack)
    }

    item {
      Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF581C87).copy(alpha = 0.35f)),
        border = BorderStroke(1.dp, Color(0xFF9333EA)),
        modifier = Modifier.padding(horizontal = 12.dp)
      ) {
        Row(
          modifier = Modifier.padding(10.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("⚖️", fontSize = 20.sp)
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "මූලික අයිතිවාසිකම්, RTI පනත, පළාත් පාලනය සහ ගැටුම් නිරාකරණය පිළිබඳ ප්‍රායෝගික සිද්ධි අධ්‍යයන සහ පුරවැසි ක්‍රියාමාර්ග.",
            fontSize = 11.5.sp,
            color = Color(0xFFE9D5FF),
            lineHeight = 16.sp
          )
        }
      }
    }

    items(caseItems, key = { it.id }) { caseItem ->
      Box(modifier = Modifier.padding(horizontal = 12.dp)) {
        val isExpanded = expandedCaseId == caseItem.id

        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1B4B).copy(alpha = 0.6f)),
          border = BorderStroke(1.dp, if (isExpanded) Color(0xFFA855F7) else Color(0xFF3B0764)),
          modifier = Modifier
            .fillMaxWidth()
            .clickable { onToggleExpand(caseItem.id) }
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = caseItem.title,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.weight(1f)
              )
              Icon(
                imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                contentDescription = null,
                tint = Color(0xFFA855F7)
              )
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = "📋 සිදුවීම:",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFC084FC)
            )
            Text(
              text = caseItem.situation,
              fontSize = 11.5.sp,
              color = Color(0xFFE2E8F0),
              lineHeight = 16.sp
            )

            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = "❓ ගැටලුව / විමසුම:",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFFDE047)
            )
            Text(
              text = caseItem.dilemma,
              fontSize = 11.sp,
              color = Color(0xFFFEF08A),
              lineHeight = 15.sp
            )

            AnimatedVisibility(
              visible = isExpanded,
              enter = fadeIn() + expandVertically(),
              exit = fadeOut() + shrinkVertically()
            ) {
              Column(modifier = Modifier.padding(top = 10.dp)) {
                HorizontalDivider(color = Color(0xFF4C1D95), thickness = 0.8.dp)
                Spacer(modifier = Modifier.height(8.dp))

                Surface(
                  color = Color(0xFF14532D).copy(alpha = 0.4f),
                  shape = RoundedCornerShape(8.dp),
                  border = BorderStroke(1.dp, Color(0xFF22C55E))
                ) {
                  Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                      text = "✅ නිර්දේශිත නිවැරදි පුරවැසි ක්‍රියාමාර්ගය:",
                      fontSize = 11.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF86EFAC)
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                      text = caseItem.correctCourseOfAction,
                      fontSize = 11.sp,
                      color = Color.White,
                      lineHeight = 16.sp
                    )
                  }
                }

                Spacer(modifier = Modifier.height(6.dp))
                Text(
                  text = "📜 නීතිමය පදනම / ව්‍යවස්ථාපිත නීතිය: ${caseItem.legalBasisOrRule}",
                  fontSize = 10.5.sp,
                  fontWeight = FontWeight.Medium,
                  color = Color(0xFF94A3B8)
                )
              }
            }
          }
        }
      }
    }
    item { Spacer(modifier = Modifier.height(20.dp)) }
  }
}

// ============================================================================
// 6. FLOWCHARTS SECTION
// ============================================================================
@Composable
private fun CivicsFlowchartsSection(searchQuery: String, onBack: () -> Unit) {
  val flowchartItems = remember(searchQuery) {
    CivicsMasterDataProvider.flowcharts.filter { flow ->
      searchQuery.isBlank() ||
          flow.title.contains(searchQuery, ignoreCase = true) ||
          flow.category.contains(searchQuery, ignoreCase = true) ||
          flow.hierarchyLevels.any { it.first.contains(searchQuery, ignoreCase = true) || it.second.contains(searchQuery, ignoreCase = true) }
    }
  }

  val listState = rememberLazyListState()
  LaunchedEffect(searchQuery) {
    listState.scrollToItem(0)
  }

  LazyColumn(
    state = listState,
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    item {
      CivicsSubSectionHeader(CivicsSectionCategory.FLOWCHARTS, onBack)
    }

    item {
      Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF064E3B).copy(alpha = 0.35f)),
        border = BorderStroke(1.dp, Color(0xFF059669)),
        modifier = Modifier.padding(horizontal = 12.dp)
      ) {
        Row(
          modifier = Modifier.padding(10.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("🏛️", fontSize = 20.sp)
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "රාජ්‍ය බලතල බෙදීම, අධිකරණ ධූරාවලිය, පළාත් පාලන ව්‍යුහය සහ එක්සත් ජාතීන්ගේ සංවිධානයේ ප්‍රස්ථාරික සටහන්.",
            fontSize = 11.5.sp,
            color = Color(0xFFA7F3D0),
            lineHeight = 16.sp
          )
        }
      }
    }

    items(flowchartItems, key = { it.id }) { flow ->
      Box(modifier = Modifier.padding(horizontal = 12.dp)) {
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF062E25)),
          border = BorderStroke(1.dp, Color(0xFF0D9488)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
            Surface(
              color = Color(0xFF0D9488),
              shape = RoundedCornerShape(4.dp)
            ) {
              Text(
                text = flow.category,
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = flow.title,
              fontSize = 14.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
              text = flow.description,
              fontSize = 11.sp,
              color = Color(0xFF99F6E4)
            )

            Spacer(modifier = Modifier.height(8.dp))
            flow.hierarchyLevels.forEachIndexed { idx, level ->
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF04241E),
                border = BorderStroke(0.8.dp, Color(0xFF115E59)),
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(vertical = 3.dp)
              ) {
                Row(
                  modifier = Modifier.padding(8.dp),
                  verticalAlignment = Alignment.Top
                ) {
                  Surface(
                    shape = CircleShape,
                    color = Color(0xFF0D9488),
                    modifier = Modifier.size(20.dp)
                  ) {
                    Box(contentAlignment = Alignment.Center) {
                      Text(
                        text = "${idx + 1}",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                      )
                    }
                  }
                  Spacer(modifier = Modifier.width(8.dp))
                  Column(modifier = Modifier.weight(1f)) {
                    Text(
                      text = level.first,
                      fontSize = 11.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFFFDE047)
                    )
                    Text(
                      text = level.second,
                      fontSize = 10.5.sp,
                      color = Color.White,
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
    item { Spacer(modifier = Modifier.height(20.dp)) }
  }
}

@Composable
private fun EmptyResultNotice(message: String) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .padding(32.dp),
    contentAlignment = Alignment.Center
  ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      Text("🔍", fontSize = 32.sp)
      Spacer(modifier = Modifier.height(8.dp))
      Text(
        text = message,
        color = Color(0xFF94A3B8),
        fontSize = 13.sp,
        textAlign = TextAlign.Center
      )
    }
  }
}

// ============================================================================
// 7. HUMAN RIGHTS & DECLARATIONS SECTION
// ============================================================================
@Composable
private fun CivicsHumanRightsSection(searchQuery: String, onBack: () -> Unit) {
  val items = remember(searchQuery) {
    CivicsMasterDataProvider.humanRightsItems.filter { hr ->
      searchQuery.isBlank() ||
          hr.title.contains(searchQuery, ignoreCase = true) ||
          hr.category.contains(searchQuery, ignoreCase = true) ||
          hr.description.contains(searchQuery, ignoreCase = true) ||
          hr.keyArticlesOrRights.any { it.contains(searchQuery, ignoreCase = true) }
    }
  }

  val listState = rememberLazyListState()
  LaunchedEffect(searchQuery) {
    listState.scrollToItem(0)
  }

  LazyColumn(
    state = listState,
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    item {
      CivicsSubSectionHeader(CivicsSectionCategory.HUMAN_RIGHTS, onBack)
    }

    item {
      Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E3A8A).copy(alpha = 0.35f)),
        border = BorderStroke(1.dp, Color(0xFF3B82F6)),
        modifier = Modifier.padding(horizontal = 12.dp)
      ) {
        Row(
          modifier = Modifier.padding(10.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("🤝", fontSize = 20.sp)
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "1948 UDHR ජාත්‍යන්තර මානව හිමිකම්, ළමා & කාන්තා අයිතිවාසිකම් සහ ශ්‍රී ලංකා මානව හිමිකම් කොමිෂන් සභාව.",
            fontSize = 11.5.sp,
            color = Color(0xFFBFDBFE),
            lineHeight = 16.sp
          )
        }
      }
    }

    items(items, key = { it.id }) { item ->
      Box(modifier = Modifier.padding(horizontal = 12.dp)) {
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
          border = BorderStroke(1.dp, Color(0xFF1E3A8A)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Surface(
                color = Color(0xFF2563EB),
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
              Text(
                text = item.yearOrOrigin,
                fontSize = 10.5.sp,
                color = Color(0xFF93C5FD),
                fontWeight = FontWeight.SemiBold
              )
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = item.title,
              fontSize = 14.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = item.description,
              fontSize = 11.5.sp,
              color = Color(0xFFE2E8F0),
              lineHeight = 16.sp
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "📌 ප්‍රධාන වගන්ති & අයිතිවාසිකම්:",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFFDE047)
            )
            item.keyArticlesOrRights.forEach { art ->
              Row(modifier = Modifier.padding(vertical = 1.5.dp)) {
                Text("•", color = Color(0xFF60A5FA), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = art, fontSize = 11.sp, color = Color.White, lineHeight = 15.sp)
              }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Surface(
              color = Color(0xFF1E293B),
              shape = RoundedCornerShape(6.dp),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(8.dp)) {
                Text(
                  text = "🇱🇰 ශ්‍රී ලංකාවේ ක්‍රියාත්මක වීම: ${item.sriLankanContext}",
                  fontSize = 10.5.sp,
                  color = Color(0xFF93C5FD),
                  lineHeight = 15.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = "🎯 විභාග ඉඟිය: ${item.examTip}",
                  fontSize = 10.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF34D399)
                )
              }
            }
          }
        }
      }
    }
    item { Spacer(modifier = Modifier.height(20.dp)) }
  }
}

// ============================================================================
// 8. LOCAL GOVERNMENT SECTION
// ============================================================================
@Composable
private fun CivicsLocalGovtSection(searchQuery: String, onBack: () -> Unit) {
  val items = remember(searchQuery) {
    CivicsMasterDataProvider.localGovtItems.filter { lg ->
      searchQuery.isBlank() ||
          lg.councilType.contains(searchQuery, ignoreCase = true) ||
          lg.keyFunctions.any { it.contains(searchQuery, ignoreCase = true) } ||
          lg.citizenServices.contains(searchQuery, ignoreCase = true)
    }
  }

  val listState = rememberLazyListState()
  LaunchedEffect(searchQuery) {
    listState.scrollToItem(0)
  }

  LazyColumn(
    state = listState,
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    item {
      CivicsSubSectionHeader(CivicsSectionCategory.LOCAL_GOVT, onBack)
    }

    item {
      Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF9A3412).copy(alpha = 0.35f)),
        border = BorderStroke(1.dp, Color(0xFFEA580C)),
        modifier = Modifier.padding(horizontal = 12.dp)
      ) {
        Row(
          modifier = Modifier.padding(10.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("🏢", fontSize = 20.sp)
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "මහනගර, නගර, ප්‍රාදේශීය සභා සහ 13 වන ව්‍යවස්ථා සංශෝධනයේ පළාත් සභා පාලන ව්‍යුහය, ආදායම් මාර්ග සහ සේවාවන්.",
            fontSize = 11.5.sp,
            color = Color(0xFFFFEDD5),
            lineHeight = 16.sp
          )
        }
      }
    }

    items(items, key = { it.id }) { item ->
      Box(modifier = Modifier.padding(horizontal = 12.dp)) {
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF291105)),
          border = BorderStroke(1.dp, Color(0xFF7C2D12)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
            Text(
              text = item.councilType,
              fontSize = 14.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )

            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = "👔 නායකත්වය & ව්‍යුහය: ${item.leadershipAndStructure}",
              fontSize = 11.5.sp,
              color = Color(0xFFFED7AA),
              lineHeight = 16.sp
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "🛠️ ප්‍රධාන කාර්යයන් සහ වගකීම්:",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFFDE047)
            )
            item.keyFunctions.forEach { fn ->
              Row(modifier = Modifier.padding(vertical = 1.5.dp)) {
                Text("•", color = Color(0xFFF97316), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = fn, fontSize = 11.sp, color = Color.White, lineHeight = 15.sp)
              }
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = "💰 ප්‍රධාන ආදායම් මාර්ග:",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF86EFAC)
            )
            item.revenueSources.forEach { rev ->
              Row(modifier = Modifier.padding(vertical = 1.dp)) {
                Text("✓", color = Color(0xFF22C55E), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = rev, fontSize = 10.5.sp, color = Color(0xFFDCFCE7))
              }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Surface(
              color = Color(0xFF431407),
              shape = RoundedCornerShape(6.dp),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(8.dp)) {
                Text(
                  text = "🏠 පුරවැසියන්ට ලැබෙන සේවාවන්: ${item.citizenServices}",
                  fontSize = 10.5.sp,
                  color = Color(0xFFFFEDD5),
                  lineHeight = 15.sp
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                  text = "🎯 විභාග ඉඟිය: ${item.examTip}",
                  fontSize = 10.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFFFDBA74)
                )
              }
            }
          }
        }
      }
    }
    item { Spacer(modifier = Modifier.height(20.dp)) }
  }
}

// ============================================================================
// 9. GOOD GOVERNANCE & RTI SECTION
// ============================================================================
@Composable
private fun CivicsGoodGovernanceSection(searchQuery: String, onBack: () -> Unit) {
  val items = remember(searchQuery) {
    CivicsMasterDataProvider.goodGovernanceItems.filter { gg ->
      searchQuery.isBlank() ||
          gg.conceptTitle.contains(searchQuery, ignoreCase = true) ||
          gg.keyPrinciples.any { it.contains(searchQuery, ignoreCase = true) } ||
          gg.practicalApplication.contains(searchQuery, ignoreCase = true)
    }
  }

  val listState = rememberLazyListState()
  LaunchedEffect(searchQuery) {
    listState.scrollToItem(0)
  }

  LazyColumn(
    state = listState,
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    item {
      CivicsSubSectionHeader(CivicsSectionCategory.GOOD_GOVERNANCE, onBack)
    }

    item {
      Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF065F46).copy(alpha = 0.35f)),
        border = BorderStroke(1.dp, Color(0xFF10B981)),
        modifier = Modifier.padding(horizontal = 12.dp)
      ) {
        Row(
          modifier = Modifier.padding(10.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("🛡️", fontSize = 20.sp)
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "තොරතුරු දැනගැනීමේ අයිතිවාසිකම් පනත (RTI 2016), පාරදෘශ්‍යතාව, වගවීම, COPE කාරක සභාව සහ අල්ලස් නිවාරණය.",
            fontSize = 11.5.sp,
            color = Color(0xFFD1FAE5),
            lineHeight = 16.sp
          )
        }
      }
    }

    items(items, key = { it.id }) { item ->
      Box(modifier = Modifier.padding(horizontal = 12.dp)) {
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF022C22)),
          border = BorderStroke(1.dp, Color(0xFF047857)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
            Text(
              text = item.conceptTitle,
              fontSize = 14.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )

            Spacer(modifier = Modifier.height(4.dp))
            Surface(
              color = Color(0xFF059669),
              shape = RoundedCornerShape(4.dp)
            ) {
              Text(
                text = item.legalProvisions,
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "📌 ප්‍රධාන මූලධර්ම සහ ලක්ෂණ:",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFFDE047)
            )
            item.keyPrinciples.forEach { p ->
              Row(modifier = Modifier.padding(vertical = 1.5.dp)) {
                Text("•", color = Color(0xFF34D399), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = p, fontSize = 11.sp, color = Color.White, lineHeight = 15.sp)
              }
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = "💡 ප්‍රායෝගික භාවිතය: ${item.practicalApplication}",
              fontSize = 11.sp,
              color = Color(0xFFA7F3D0),
              lineHeight = 15.sp
            )

            Spacer(modifier = Modifier.height(8.dp))
            Surface(
              color = Color(0xFF064E3B),
              shape = RoundedCornerShape(6.dp),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(8.dp)) {
                Text(
                  text = "👤 පුරවැසියාගේ කාර්යභාරය: ${item.citizenRole}",
                  fontSize = 10.5.sp,
                  color = Color(0xFFE2E8F0),
                  lineHeight = 15.sp
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                  text = "🎯 විභාග ඉඟිය: ${item.examTip}",
                  fontSize = 10.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF6EE7B7)
                )
              }
            }
          }
        }
      }
    }
    item { Spacer(modifier = Modifier.height(20.dp)) }
  }
}

// ============================================================================
// 10. GLOBAL RELATIONS SECTION
// ============================================================================
@Composable
private fun CivicsGlobalRelationsSection(searchQuery: String, onBack: () -> Unit) {
  val items = remember(searchQuery) {
    CivicsMasterDataProvider.globalRelationsItems.filter { gr ->
      searchQuery.isBlank() ||
          gr.organizationOrPolicy.contains(searchQuery, ignoreCase = true) ||
          gr.keyObjectives.any { it.contains(searchQuery, ignoreCase = true) } ||
          gr.sriLankaRoleAndBenefits.contains(searchQuery, ignoreCase = true)
    }
  }

  val listState = rememberLazyListState()
  LaunchedEffect(searchQuery) {
    listState.scrollToItem(0)
  }

  LazyColumn(
    state = listState,
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    item {
      CivicsSubSectionHeader(CivicsSectionCategory.GLOBAL_RELATIONS, onBack)
    }

    item {
      Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF581C87).copy(alpha = 0.35f)),
        border = BorderStroke(1.dp, Color(0xFF9333EA)),
        modifier = Modifier.padding(horizontal = 12.dp)
      ) {
        Row(
          modifier = Modifier.padding(10.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("🌐", fontSize = 20.sp)
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "එක්සත් ජාතීන්ගේ සංවිධානය (UN 1945), නොබැඳි විදේශ ප්‍රතිපත්තිය (NAM 1961), සාර්ක් (SAARC 1985) සහ ගෝලීය පුරවැසිභාවය.",
            fontSize = 11.5.sp,
            color = Color(0xFFE9D5FF),
            lineHeight = 16.sp
          )
        }
      }
    }

    items(items, key = { it.id }) { item ->
      Box(modifier = Modifier.padding(horizontal = 12.dp)) {
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E102E)),
          border = BorderStroke(1.dp, Color(0xFF6B21A8)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = item.organizationOrPolicy,
                fontSize = 14.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Surface(
                color = Color(0xFF7C3AED),
                shape = RoundedCornerShape(4.dp)
              ) {
                Text(
                  text = item.foundedYearAndHQ,
                  color = Color.White,
                  fontSize = 9.5.sp,
                  fontWeight = FontWeight.Bold,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "📌 ප්‍රධාන අරමුණු සහ කර්තව්‍යයන්:",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFFDE047)
            )
            item.keyObjectives.forEach { obj ->
              Row(modifier = Modifier.padding(vertical = 1.5.dp)) {
                Text("•", color = Color(0xFFA855F7), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = obj, fontSize = 11.sp, color = Color.White, lineHeight = 15.sp)
              }
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = "🇱🇰 ශ්‍රී ලංකාවේ දායකත්වය & ප්‍රතිලාභ: ${item.sriLankaRoleAndBenefits}",
              fontSize = 11.sp,
              color = Color(0xFFE9D5FF),
              lineHeight = 15.sp
            )

            Spacer(modifier = Modifier.height(8.dp))
            Surface(
              color = Color(0xFF3B0764),
              shape = RoundedCornerShape(6.dp),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(8.dp)) {
                Text(
                  text = "🌍 ගෝලීය පුරවැසිභාවය: ${item.globalCitizenshipAspects}",
                  fontSize = 10.5.sp,
                  color = Color(0xFFDDD6FE),
                  lineHeight = 15.sp
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                  text = "🎯 විභාග ඉඟිය: ${item.examTip}",
                  fontSize = 10.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFFC084FC)
                )
              }
            }
          }
        }
      }
    }
    item { Spacer(modifier = Modifier.height(20.dp)) }
  }
}

// ============================================================================
// MASTER OVERVIEW GRID VIEW (ALL 10 SUB-SECTIONS COLLECTION)
// ============================================================================
@Composable
private fun CivicsMasterOverviewGrid(
  selectedGradeTab: CivicsGradeTab,
  searchQuery: String,
  onSearchQueryChange: (String) -> Unit,
  onSelectCategory: (CivicsSectionCategory) -> Unit,
  onSelectGrade: (CivicsGradeTab) -> Unit
) {
  val listState = rememberLazyListState()
  LaunchedEffect(selectedGradeTab, searchQuery) {
    listState.scrollToItem(0)
  }
  val categories = remember(searchQuery, selectedGradeTab) {
    CivicsSectionCategory.values().filter { cat ->
      val matchesGrade = when (selectedGradeTab) {
        CivicsGradeTab.ALL -> true
        CivicsGradeTab.GRADE_10 -> cat.applicableGrade == null || cat.applicableGrade == "10"
        CivicsGradeTab.GRADE_11 -> cat.applicableGrade == null || cat.applicableGrade == "11"
      }
      val matchesSearch = searchQuery.isBlank() ||
          cat.titleSinhala.contains(searchQuery, ignoreCase = true) ||
          cat.subtitle.contains(searchQuery, ignoreCase = true)
      matchesGrade && matchesSearch
    }
  }

  LazyColumn(
    state = listState,
    modifier = Modifier
      .fillMaxSize()
      .padding(horizontal = 12.dp),
    verticalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    item { Spacer(modifier = Modifier.height(10.dp)) }

    // Header Hero Banner
    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F766E).copy(alpha = 0.35f)),
        border = BorderStroke(1.dp, Color(0xFF2DD4BF))
      ) {
        Row(
          modifier = Modifier.padding(12.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("🏛️", fontSize = 28.sp)
          Spacer(modifier = Modifier.width(10.dp))
          Column {
            Text(
              text = "10 & 11 ශ්‍රේණි පුරවැසි අධ්‍යාපනය Master Hub",
              fontSize = 15.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
              text = "පහත දැක්වෙන්නේ පුරවැසි විෂය නිර්දේශයේ සියලුම අනු කොටස් ${categories.size} හි එකතුවයි.",
              fontSize = 11.5.sp,
              color = Color(0xFFCCFBF1),
              lineHeight = 16.sp
            )
          }
        }
      }
    }

    // GRADE FILTER ROW (Now inside scroll)
    item {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .background(Color(0xFF042F2C), RoundedCornerShape(8.dp))
          .padding(all = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        CivicsGradeTab.values().forEach { tab ->
          val isSelected = selectedGradeTab == tab
          Surface(
            onClick = { onSelectGrade(tab) },
            shape = RoundedCornerShape(6.dp),
            color = if (isSelected) Color(0xFF0D9488) else Color(0xFF134E4A),
            border = BorderStroke(
              width = 1.dp,
              color = if (isSelected) Color(0xFF2DD4BF) else Color(0xFF115E59)
            ),
            modifier = Modifier
              .weight(1f)
              .height(30.dp)
          ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
              Text(
                text = tab.labelSinhala,
                fontSize = 10.5.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                color = if (isSelected) Color.White else Color(0xFF99F6E4)
              )
            }
          }
        }
      }
    }

    // SEARCH BAR (Now inside scroll)
    item {
      OutlinedTextField(
        value = searchQuery,
        onValueChange = onSearchQueryChange,
        placeholder = { Text("පාඩම, ප්‍රශ්නය හෝ ව්‍යවස්ථාව සොයන්න...", fontSize = 11.sp, color = Color(0xFF5EEAD4).copy(alpha = 0.6f)) },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color(0xFF2DD4BF), modifier = Modifier.size(15.dp)) },
        trailingIcon = {
          if (searchQuery.isNotEmpty()) {
            IconButton(onClick = { onSearchQueryChange("") }, modifier = Modifier.size(20.dp)) {
              Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color(0xFF5EEAD4), modifier = Modifier.size(13.dp))
            }
          }
        },
        singleLine = true,
        shape = RoundedCornerShape(8.dp),
        colors = OutlinedTextFieldDefaults.colors(
          focusedBorderColor = Color(0xFF2DD4BF),
          unfocusedBorderColor = Color(0xFF115E59),
          focusedTextColor = Color.White,
          unfocusedTextColor = Color.White,
          focusedContainerColor = Color(0xFF042F2C),
          unfocusedContainerColor = Color(0xFF042F2C)
        ),
        modifier = Modifier
          .fillMaxWidth()
          .height(38.dp)
          .testTag("civics_search_input_scroll")
      )
    }

    // Grid of all filtered categories
    items(categories.chunked(2)) { rowItems ->
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        rowItems.forEach { cat ->
          Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
            border = BorderStroke(1.dp, cat.themeColor.copy(alpha = 0.8f)),
            modifier = Modifier
              .weight(1f)
              .clickable { onSelectCategory(cat) }
          ) {
            Column(
              modifier = Modifier.padding(12.dp),
              verticalArrangement = Arrangement.SpaceBetween
            ) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Surface(
                  shape = CircleShape,
                  color = cat.themeColor.copy(alpha = 0.25f),
                  modifier = Modifier.size(36.dp)
                ) {
                  Box(contentAlignment = Alignment.Center) {
                    Text(cat.emoji, fontSize = 18.sp)
                  }
                }
                if (cat.applicableGrade != null) {
                  Surface(
                    color = if (cat.applicableGrade == "10") Color(0xFF0D9488) else Color(0xFF2563EB),
                    shape = RoundedCornerShape(4.dp)
                  ) {
                    Text(
                      text = "${cat.applicableGrade} වසර",
                      color = Color.White,
                      fontSize = 8.sp,
                      fontWeight = FontWeight.Bold,
                      modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                    )
                  }
                }
              }

              Spacer(modifier = Modifier.height(8.dp))
              Text(
                text = cat.titleSinhala,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
              )
              Spacer(modifier = Modifier.height(2.dp))
              Text(
                text = cat.subtitle,
                fontSize = 10.5.sp,
                color = Color(0xFF94A3B8),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 14.sp
              )

              Spacer(modifier = Modifier.height(10.dp))
              Surface(
                color = cat.themeColor.copy(alpha = 0.15f),
                border = BorderStroke(0.8.dp, cat.themeColor),
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(
                    text = "අන්තර්ගතය බලන්න",
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                  )
                  Text("➔", fontSize = 11.sp, color = cat.themeColor)
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
    item { Spacer(modifier = Modifier.height(20.dp)) }
  }
}
