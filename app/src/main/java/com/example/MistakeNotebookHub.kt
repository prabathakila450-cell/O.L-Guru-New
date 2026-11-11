package com.example

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MistakeNotebookScreen(
  grade: String,
  onBack: () -> Unit,
  initialSubjectFilter: String = "ALL",
  initialTopicFilter: String = "",
  onOpenNotesForSubject: (String) -> Unit = {},
  onOpenMockExam: () -> Unit = {}
) {
  val context = LocalContext.current
  var allMistakes by remember { mutableStateOf(MistakeNotebookRepository.getAllMistakes(context)) }
  var summary by remember { mutableStateOf(MistakeNotebookRepository.getSummary(context)) }

  var selectedGradeFilter by remember(grade) {
    mutableStateOf(if (grade.contains("10")) "10" else "11")
  }
  var selectedSubjectFilter by remember(initialSubjectFilter) {
    mutableStateOf(if (initialSubjectFilter.isNotBlank()) initialSubjectFilter else "ALL")
  }
  var topicFilterQuery by remember(initialTopicFilter) {
    mutableStateOf(initialTopicFilter)
  }
  var activeTab by remember { mutableStateOf(0) } // 0: Pending, 1: Mastered

  fun refreshData() {
    allMistakes = MistakeNotebookRepository.getAllMistakes(context)
    summary = MistakeNotebookRepository.getSummary(context)
  }

  val availableSubjects = remember(allMistakes, selectedSubjectFilter) {
    val list = (listOf("ALL" to "සියලු විෂයන්") + allMistakes.map { it.subject }.distinct().map { it to it }).toMutableList()
    if (selectedSubjectFilter != "ALL" && list.none { it.first == selectedSubjectFilter }) {
      list.add(selectedSubjectFilter to selectedSubjectFilter)
    }
    list
  }

  val targetedInfo = remember(selectedSubjectFilter, topicFilterQuery) {
    TargetedWeakTopicRepository.getTopicInfo(selectedSubjectFilter, topicFilterQuery)
  }

  val filteredMistakes = remember(allMistakes, selectedGradeFilter, selectedSubjectFilter, topicFilterQuery, activeTab) {
    allMistakes.filter { item ->
      val matchesGrade = selectedGradeFilter == "ALL" || item.grade.contains(selectedGradeFilter)
      val matchesSubject = selectedSubjectFilter == "ALL" || item.subject == selectedSubjectFilter
      val matchesTopic = topicFilterQuery.isBlank() ||
          item.topic.contains(topicFilterQuery, ignoreCase = true) ||
          item.questionText.contains(topicFilterQuery, ignoreCase = true) ||
          item.subject.contains(topicFilterQuery, ignoreCase = true)
      val matchesTab = if (activeTab == 0) !item.isMastered else item.isMastered
      matchesGrade && matchesSubject && matchesTopic && matchesTab
    }
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = "⚠️ වැරදුණු ප්‍රශ්න එකතුව",
              fontWeight = FontWeight.Bold,
              fontSize = 16.sp,
              color = Color(0xFF0F172A)
            )
            Text(
              text = "Mistake Notebook & Targeted Revision Bank",
              fontSize = 11.sp,
              color = Color(0xFF64748B)
            )
          }
        },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color(0xFF0F172A))
          }
        },
        actions = {
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFFFEF2F2),
            border = BorderStroke(1.dp, Color(0xFFFECACA)),
            modifier = Modifier.padding(end = 12.dp)
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
              Text(
                text = "${summary.pending} Pending",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFDC2626)
              )
            }
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
      )
    }
  ) { padding ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(padding)
        .background(Color(0xFFF8FAFC))
        .padding(horizontal = 16.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
      contentPadding = PaddingValues(top = 12.dp, bottom = 32.dp)
    ) {
      // 1. KPI Summary Banner
      item {
        Card(
          shape = RoundedCornerShape(18.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
          elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                  modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFEF4444).copy(alpha = 0.2f)),
                  contentAlignment = Alignment.Center
                ) {
                  Text("🎯", fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                  Text(
                    text = "ඉලක්කගත පුනරීක්ෂණ පද්ධතිය",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                  )
                  Text(
                    text = "වරදවාගත් සංකල්ප නැවත පුහුණු වී Master කරන්න",
                    fontSize = 10.5.sp,
                    color = Color(0xFF94A3B8)
                  )
                }
              }

              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF22C55E)
              ) {
                Text(
                  text = "${(summary.masteryRate * 100).toInt()}% ප්‍රගුණයි",
                  fontSize = 10.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(14.dp))

            LinearProgressIndicator(
              progress = { summary.masteryRate },
              modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .clip(RoundedCornerShape(3.dp)),
              color = Color(0xFF22C55E),
              trackColor = Color(0xFF334155)
            )

            Spacer(modifier = Modifier.height(14.dp))

            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              MistakeStatBox(title = "මුළු වැරදීම්", value = "${summary.total}", color = Color.White)
              MistakeStatBox(title = "පුහුණු වීමට", value = "${summary.pending}", color = Color(0xFFF87171))
              MistakeStatBox(title = "ප්‍රගුණ කළ (Mastered)", value = "${summary.mastered}", color = Color(0xFF4ADE80))
            }
          }
        }
      }

      // 2. Grade & Subject Filter Chips
      item {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
          // Grade Filter Row
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            listOf("ALL" to "සියලු ශ්‍රේණි", "11" to "11 ශ්‍රේණිය (O/L)", "10" to "10 ශ්‍රේණිය").forEach { (gKey, gLabel) ->
              val isSel = selectedGradeFilter == gKey
              Surface(
                onClick = { selectedGradeFilter = gKey },
                shape = RoundedCornerShape(10.dp),
                color = if (isSel) Color(0xFF1E293B) else Color.White,
                border = BorderStroke(1.dp, if (isSel) Color(0xFF1E293B) else Color(0xFFE2E8F0)),
                modifier = Modifier.weight(1f)
              ) {
                Text(
                  text = gLabel,
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = if (isSel) Color.White else Color(0xFF475569),
                  modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth(),
                  textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
              }
            }
          }

          // Subject Horizontal Pills
          LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            items(availableSubjects) { (sKey, sLabel) ->
              val isSel = selectedSubjectFilter == sKey
              FilterChip(
                selected = isSel,
                onClick = { selectedSubjectFilter = sKey },
                label = { Text(sLabel, fontSize = 11.sp, fontWeight = if (isSel) FontWeight.Bold else FontWeight.Normal) },
                colors = FilterChipDefaults.filterChipColors(
                  selectedContainerColor = Color(0xFF2563EB),
                  selectedLabelColor = Color.White
                )
              )
            }
          }
        }
      }

      // 3. Active Target Filter Banner (100% Relevance)
      if (topicFilterQuery.isNotBlank() || selectedSubjectFilter != "ALL") {
        item {
          Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFEFF6FF)),
            border = BorderStroke(1.dp, Color(0xFF93C5FD)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(
              modifier = Modifier.padding(12.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                Icon(Icons.Default.FilterList, contentDescription = null, tint = Color(0xFF2563EB), modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                  Text(
                    text = "🎯 ඉලක්කගත දුර්වල මාතෘකා පුහුණුව:",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E3A8A)
                  )
                  Text(
                    text = "${if (topicFilterQuery.isNotBlank()) "\"$topicFilterQuery\"" else ""} (${if (selectedSubjectFilter != "ALL") selectedSubjectFilter else "සියලු විෂයන්"})",
                    fontSize = 12.sp,
                    color = Color(0xFF0F172A),
                    fontWeight = FontWeight.SemiBold
                  )
                }
              }
              TextButton(
                onClick = {
                  topicFilterQuery = ""
                  selectedSubjectFilter = "ALL"
                }
              ) {
                Text("සියල්ල (Reset)", fontSize = 11.sp, color = Color(0xFF2563EB), fontWeight = FontWeight.Bold)
              }
            }
          }
        }
      }

      // 4. Tab Switcher: Pending vs Mastered
      item {
        TabRow(
          selectedTabIndex = activeTab,
          containerColor = Color.White,
          contentColor = Color(0xFF2563EB),
          modifier = Modifier.clip(RoundedCornerShape(12.dp))
        ) {
          Tab(
            selected = activeTab == 0,
            onClick = { activeTab = 0 },
            text = {
              Text(
                text = "🎯 පුහුණු වීමට ඇති (${summary.pending})",
                fontWeight = if (activeTab == 0) FontWeight.Bold else FontWeight.Normal,
                fontSize = 12.sp
              )
            }
          )
          Tab(
            selected = activeTab == 1,
            onClick = { activeTab = 1 },
            text = {
              Text(
                text = "🏆 ප්‍රගුණ කළ (${summary.mastered})",
                fontWeight = if (activeTab == 1) FontWeight.Bold else FontWeight.Normal,
                fontSize = 12.sp
              )
            }
          )
        }
      }

      // 5. Questions List
      if (filteredMistakes.isEmpty()) {
        if (topicFilterQuery.isNotBlank() && targetedInfo.targetedQuestions.isNotEmpty()) {
          item {
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFFFEF2F2)),
              border = BorderStroke(1.dp, Color(0xFFFECACA)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text("🎯", fontSize = 16.sp)
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = "දුර්වල මාතෘකා ඉලක්කගත අභ්‍යාස ප්‍රශ්න (${targetedInfo.topicName})",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF991B1B)
                  )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = "මෙම මාතෘකාව ආශ්‍රිතව නිතර වරදින විභාග මට්ටමේ ප්‍රශ්න මෙහිදී විසඳා Mistake Bank එකට සුරකින්න:",
                  fontSize = 11.sp,
                  color = Color(0xFF7F1D1D)
                )
              }
            }
          }

          items(targetedInfo.targetedQuestions, key = { it.id }) { q ->
            TargetedPracticeQuestionCard(
              q = q,
              subject = targetedInfo.subjectName,
              topic = targetedInfo.topicName,
              onSaveToMistakeBank = { userWrongIdx ->
                val item = MistakeItem(
                  id = "targeted_${q.id}",
                  subject = targetedInfo.subjectName,
                  topic = targetedInfo.topicName,
                  grade = if (selectedGradeFilter.contains("10")) "10" else "11",
                  questionText = q.question,
                  options = q.options,
                  correctOptionIndex = q.correctOptionIndex,
                  explanation = q.explanation,
                  userWrongAnswerIndex = userWrongIdx,
                  isMastered = false
                )
                MistakeNotebookRepository.addMistake(context, item)
                refreshData()
                Toast.makeText(context, "ප්‍රශ්නය Mistake Bank වෙත සාර්ථකව එක් විය!", Toast.LENGTH_SHORT).show()
              }
            )
          }
        } else {
          item {
            Card(
              shape = RoundedCornerShape(16.dp),
              colors = CardDefaults.cardColors(containerColor = Color.White),
              border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally
              ) {
                Text(if (activeTab == 0) "🎉" else "📚", fontSize = 40.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                  text = if (activeTab == 0)
                    "ඉලක්කගත වැරදුණු ප්‍රශ්න කිසිවක් නොමැත!"
                  else
                    "තවමත් ප්‍රගුණ කළ ප්‍රශ්න නොමැත.",
                  fontWeight = FontWeight.Bold,
                  fontSize = 14.sp,
                  color = Color(0xFF0F172A)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                  text = if (activeTab == 0)
                    "ඔබ මෙම විෂය හෝ ශ්‍රේණිය සඳහා සියලු වැරදි ප්‍රගුණ කර ඇත. Mock Exams හා Quizzes වලදී වරදින ප්‍රශ්න ස්වයංක්‍රීයව මෙහි තැන්පත් වේ."
                  else
                    "ප්‍රශ්නයක් නිවැරදිව විසඳූ පසු 'ප්‍රගුණ කළා' බොත්තම ඔබන්න.",
                  fontSize = 11.5.sp,
                  color = Color(0xFF64748B),
                  textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                  lineHeight = 16.sp
                )
                Spacer(modifier = Modifier.height(14.dp))
                Button(
                  onClick = onOpenMockExam,
                  shape = RoundedCornerShape(8.dp),
                  colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB))
                ) {
                  Icon(Icons.Default.PlayArrow, contentDescription = "Mock Exam", modifier = Modifier.size(16.dp))
                  Spacer(modifier = Modifier.width(6.dp))
                  Text("Mock Exam පරීක්ෂණයක් අරඹන්න", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
              }
            }
          }
        }
      } else {
        items(filteredMistakes, key = { it.id }) { item ->
          MistakeInteractiveCard(
            item = item,
            onToggleMastered = {
              MistakeNotebookRepository.markAsMastered(context, item.id, !item.isMastered)
              refreshData()
            },
            onDelete = {
              MistakeNotebookRepository.deleteMistake(context, item.id)
              refreshData()
            },
            onReviewNotes = { onOpenNotesForSubject(item.subject) },
            onResolvedCorrectly = {
              MistakeNotebookRepository.deleteMistake(context, item.id)
              refreshData()
            }
          )
        }
      }
    }
  }
}

@Composable
fun MistakeStatBox(title: String, value: String, color: Color) {
  Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Text(text = value, fontSize = 16.sp, fontWeight = FontWeight.Black, color = color)
    Text(text = title, fontSize = 10.sp, color = Color(0xFF94A3B8))
  }
}

@Composable
fun MistakeInteractiveCard(
  item: MistakeItem,
  onToggleMastered: () -> Unit,
  onDelete: () -> Unit,
  onReviewNotes: () -> Unit,
  onResolvedCorrectly: () -> Unit = onDelete
) {
  val context = LocalContext.current
  var selectedOption by remember { mutableStateOf<Int?>(null) }
  var showExplanation by remember { mutableStateOf(false) }
  var isResolvedCorrectly by remember { mutableStateOf(false) }

  LaunchedEffect(isResolvedCorrectly) {
    if (isResolvedCorrectly) {
      delay(1200L)
      onResolvedCorrectly()
      Toast.makeText(context, "✅ ප්‍රශ්නය නිවැරදි කර වරදවාගත් ප්‍රශ්න වලින් ඉවත් කරන ලදී!", Toast.LENGTH_SHORT).show()
    }
  }

  val subjectColor = when (item.subject) {
    "විද්‍යාව" -> Color(0xFF16A34A)
    "ගණිතය" -> Color(0xFF2563EB)
    "ඉතිහාසය" -> Color(0xFF9333EA)
    "ඉංග්‍රීසි" -> Color(0xFFD97706)
    "තොරතුරු තාක්ෂණය (ICT)" -> Color(0xFF0D9488)
    else -> Color(0xFF475569)
  }

  Card(
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    border = BorderStroke(1.dp, if (item.isMastered) Color(0xFFBBF7D0) else Color(0xFFE2E8F0)),
    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
    modifier = Modifier
      .fillMaxWidth()
      .animateContentSize()
  ) {
    Column(modifier = Modifier.padding(16.dp)) {
      // Tags & Header
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Surface(
            shape = RoundedCornerShape(6.dp),
            color = subjectColor.copy(alpha = 0.12f)
          ) {
            Text(
              text = item.subject,
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              color = subjectColor,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(6.dp))
          Surface(
            shape = RoundedCornerShape(6.dp),
            color = Color(0xFFF1F5F9)
          ) {
            Text(
              text = "${item.grade} ශ්‍රේණිය",
              fontSize = 10.sp,
              fontWeight = FontWeight.Medium,
              color = Color(0xFF475569),
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
          if (item.isMastered) {
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFFDCFCE7)
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              ) {
                Text("✅ Mastered", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF15803D))
              }
            }
          } else {
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFFFEF2F2)
            ) {
              Text(
                text = "⚠️ Revision",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFDC2626),
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
          }

          IconButton(
            onClick = onDelete,
            modifier = Modifier.size(24.dp)
          ) {
            Icon(Icons.Default.DeleteOutline, contentDescription = "Delete", tint = Color(0xFF94A3B8), modifier = Modifier.size(16.dp))
          }
        }
      }

      if (item.topic.isNotBlank()) {
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = "🎯 ඒකකය: ${item.topic}",
          fontSize = 10.5.sp,
          color = Color(0xFF64748B),
          fontWeight = FontWeight.Medium
        )
      }

      Spacer(modifier = Modifier.height(8.dp))

      // Question Text
      Text(
        text = item.questionText,
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF0F172A),
        lineHeight = 18.sp
      )

      Spacer(modifier = Modifier.height(10.dp))

      // Options
      Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        item.options.forEachIndexed { idx, opt ->
          val isCorrect = idx == item.correctOptionIndex
          val isUserSelected = selectedOption == idx
          val isPriorWrong = item.userWrongAnswerIndex == idx

          val (bgColor, borderColor, textColor) = when {
            selectedOption == null -> {
              if (isPriorWrong) {
                Triple(Color(0xFFFEF2F2), Color(0xFFFCA5A5), Color(0xFF991B1B))
              } else {
                Triple(Color(0xFFF8FAFC), Color(0xFFE2E8F0), Color(0xFF334155))
              }
            }
            isUserSelected && isCorrect -> {
              Triple(Color(0xFFDCFCE7), Color(0xFF86EFAC), Color(0xFF166534))
            }
            isUserSelected && !isCorrect -> {
              Triple(Color(0xFFFEE2E2), Color(0xFFFCA5A5), Color(0xFF991B1B))
            }
            isCorrect && showExplanation -> {
              Triple(Color(0xFFDCFCE7), Color(0xFF86EFAC), Color(0xFF166534))
            }
            else -> {
              Triple(Color(0xFFF8FAFC), Color(0xFFE2E8F0), Color(0xFF334155))
            }
          }

          Surface(
            onClick = {
              if (!isResolvedCorrectly) {
                selectedOption = idx
                showExplanation = true
                if (idx == item.correctOptionIndex) {
                  isResolvedCorrectly = true
                }
              }
            },
            shape = RoundedCornerShape(8.dp),
            color = bgColor,
            border = BorderStroke(1.dp, borderColor),
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Box(
                modifier = Modifier
                  .size(20.dp)
                  .clip(CircleShape)
                  .background(if (isUserSelected && isCorrect) Color(0xFF16A34A) else if (isUserSelected && !isCorrect) Color(0xFFDC2626) else Color(0xFFE2E8F0)),
                contentAlignment = Alignment.Center
              ) {
                Text(
                  text = "${idx + 1}",
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = if (isUserSelected) Color.White else Color(0xFF475569)
                )
              }
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = opt,
                fontSize = 11.5.sp,
                color = textColor,
                fontWeight = if (isUserSelected || (showExplanation && isCorrect)) FontWeight.Bold else FontWeight.Normal,
                modifier = Modifier.weight(1f)
              )
              if (isUserSelected && isCorrect) {
                Text("✓ නිවැරදියි", fontSize = 10.sp, color = Color(0xFF16A34A), fontWeight = FontWeight.Bold)
              } else if (isPriorWrong && selectedOption == null) {
                Text("⚠️ පෙර වරද", fontSize = 9.sp, color = Color(0xFFDC2626), fontWeight = FontWeight.Bold)
              }
            }
          }
        }
      }

      // Success Banner when corrected
      AnimatedVisibility(visible = isResolvedCorrectly) {
        Card(
          shape = RoundedCornerShape(10.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFFDCFCE7)),
          border = BorderStroke(1.dp, Color(0xFF86EFAC)),
          modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
        ) {
          Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text("🎉", fontSize = 20.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
              Text(
                text = "විශිෂ්ටයි! ඔබ ප්‍රශ්නය නිවැරදි කළා!",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF166534)
              )
              Text(
                text = "මෙම ප්‍රශ්නය වරදවාගත් ප්‍රශ්න ලැයිස්තුවෙන් ඉවත් වේ...",
                fontSize = 10.5.sp,
                color = Color(0xFF15803D)
              )
            }
            Spacer(modifier = Modifier.width(6.dp))
            Button(
              onClick = {
                onResolvedCorrectly()
                Toast.makeText(context, "✅ ප්‍රශ්නය සාර්ථකව ඉවත් විය!", Toast.LENGTH_SHORT).show()
              },
              shape = RoundedCornerShape(6.dp),
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF16A34A)),
              contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
              modifier = Modifier.height(28.dp)
            ) {
              Text("දැන්ම ඉවත් කරන්න", fontSize = 9.5.sp, fontWeight = FontWeight.Bold)
            }
          }
        }
      }

      // Explanation Section
      AnimatedVisibility(visible = showExplanation) {
        Column(modifier = Modifier.padding(top = 10.dp)) {
          Card(
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFEFF6FF)),
            border = BorderStroke(1.dp, Color(0xFFBFDBFE)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(10.dp)) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Lightbulb, contentDescription = "Tip", tint = Color(0xFF2563EB), modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("විවරණය සහ නිවැරදි නීතිය:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E40AF))
              }
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = item.explanation,
                fontSize = 11.sp,
                color = Color(0xFF1E3A8A),
                lineHeight = 15.sp
              )
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      // Bottom Action Buttons
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        OutlinedButton(
          onClick = { showExplanation = !showExplanation },
          shape = RoundedCornerShape(8.dp),
          contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
          modifier = Modifier.height(32.dp)
        ) {
          Text(if (showExplanation) "විවරණය සඟවන්න" else "💡 විවරණය බලන්න", fontSize = 10.sp)
        }

        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
          TextButton(
            onClick = onReviewNotes,
            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 4.dp),
            modifier = Modifier.height(32.dp)
          ) {
            Text("📖 සටහන්", fontSize = 10.sp, color = Color(0xFF2563EB))
          }

          Button(
            onClick = {
              onResolvedCorrectly()
              Toast.makeText(context, "✅ ප්‍රශ්නය නිවැරදි කර ඉවත් කරන ලදී!", Toast.LENGTH_SHORT).show()
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
              containerColor = Color(0xFF16A34A)
            ),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
            modifier = Modifier.height(32.dp)
          ) {
            Icon(Icons.Default.CheckCircle, contentDescription = null, modifier = Modifier.size(13.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text(
              text = "නිවැරදියි (ඉවත් කරන්න)",
              fontSize = 10.5.sp,
              fontWeight = FontWeight.Bold
            )
          }
        }
      }
    }
  }
}

@Composable
fun TargetedPracticeQuestionCard(
  q: TargetedPracticeQuestion,
  subject: String,
  topic: String,
  onSaveToMistakeBank: (userWrongIndex: Int) -> Unit
) {
  var selectedOption by remember { mutableStateOf<Int?>(null) }
  var isSubmitted by remember { mutableStateOf(false) }

  Card(
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
    modifier = Modifier.fillMaxWidth()
  ) {
    Column(modifier = Modifier.padding(14.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Surface(
          shape = RoundedCornerShape(6.dp),
          color = Color(0xFFEFF6FF)
        ) {
          Text(
            text = "$subject • $topic",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1D4ED8),
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
          )
        }
        Surface(
          shape = RoundedCornerShape(6.dp),
          color = Color(0xFFFEF2F2)
        ) {
          Text(
            text = "ඉලක්කගත පුහුණු අභ්‍යාසය",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFDC2626),
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      Text(
        text = q.question,
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF0F172A),
        lineHeight = 18.sp
      )

      Spacer(modifier = Modifier.height(10.dp))

      q.options.forEachIndexed { idx, opt ->
        val isChosen = selectedOption == idx
        val isCorrect = idx == q.correctOptionIndex
        val bgColor = when {
          !isSubmitted && isChosen -> Color(0xFFDBEAFE)
          isSubmitted && isCorrect -> Color(0xFFDCFCE7)
          isSubmitted && isChosen && !isCorrect -> Color(0xFFFEE2E2)
          else -> Color(0xFFF8FAFC)
        }
        val borderColor = when {
          !isSubmitted && isChosen -> Color(0xFF2563EB)
          isSubmitted && isCorrect -> Color(0xFF22C55E)
          isSubmitted && isChosen && !isCorrect -> Color(0xFFEF4444)
          else -> Color(0xFFCBD5E1)
        }

        Surface(
          shape = RoundedCornerShape(8.dp),
          color = bgColor,
          border = BorderStroke(1.dp, borderColor),
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable(enabled = !isSubmitted) {
              selectedOption = idx
            }
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "${('A' + idx)}. ",
              fontWeight = FontWeight.Bold,
              fontSize = 12.sp,
              color = if (isChosen) Color(0xFF1E3A8A) else Color(0xFF64748B)
            )
            Text(
              text = opt,
              fontSize = 12.sp,
              color = Color(0xFF1E293B),
              modifier = Modifier.weight(1f)
            )
            if (isSubmitted) {
              if (isCorrect) {
                Text("✓ නිවැරදියි", fontSize = 11.sp, color = Color(0xFF16A34A), fontWeight = FontWeight.Bold)
              } else if (isChosen) {
                Text("✗ වැරදියි", fontSize = 11.sp, color = Color(0xFFDC2626), fontWeight = FontWeight.Bold)
              }
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      if (!isSubmitted) {
        Button(
          onClick = {
            if (selectedOption != null) {
              isSubmitted = true
            }
          },
          enabled = selectedOption != null,
          shape = RoundedCornerShape(8.dp),
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Text("පිළිතුර පරීක්ෂා කරන්න", fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
      } else {
        // Explanation Card
        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFFF1F5F9),
          border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(10.dp)) {
            Text(
              text = "💡 විවරණය හා නිවැරදි කිරීම:",
              fontSize = 11.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF0F172A)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = q.explanation,
              fontSize = 11.sp,
              color = Color(0xFF334155),
              lineHeight = 15.sp
            )
          }
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (selectedOption != q.correctOptionIndex) {
          Button(
            onClick = {
              onSaveToMistakeBank(selectedOption ?: -1)
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Icon(Icons.Default.Warning, contentDescription = null, modifier = Modifier.size(14.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text("⚠️ Mistake Bank එකට සුරකින්න", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
          }
        }
      }
    }
  }
}

