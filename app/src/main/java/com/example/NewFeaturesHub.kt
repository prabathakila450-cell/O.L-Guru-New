package com.example

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.ui.theme.BluePrimary
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.max

// ==============================================================================
// FEATURE 1: O/L EXAM COUNTDOWN TIMER & DAILY STUDY PLANNER (විභාග දින ගණකය සහ දෛනික කාලසටහන)
// ==============================================================================

data class StudyTaskItem(
  val id: String,
  val title: String,
  val subject: String,
  val estimatedMinutes: Int,
  val isCompleted: Boolean = false
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountdownAndPlannerScreen(
  onBack: () -> Unit,
  onOpenPdfModal: (url: String, title: String) -> Unit = { _, _ -> }
) {
  val context = LocalContext.current
  val tasks = remember {
    mutableStateListOf(
      StudyTaskItem("task_1", "විද්‍යාව 11 ශ්‍රේණිය: ජීව විද්‍යාව කෙටි සටහන් කියවීම", "විද්‍යාව", 30, true),
      StudyTaskItem("task_2", "ගණිතය: ජ්‍යාමිතිය ප්‍රමේය 5ක් පුහුණු වීම", "ගණිතය", 45, false),
      StudyTaskItem("task_3", "ඉතිහාසය: 06-11 සිතියම් 3ක් ලකුණු කිරීම", "ඉතිහාසය", 20, false),
      StudyTaskItem("task_4", "ඉංග්‍රීසි: Daily Vocabulary කාඩ්පත් 10ක් කියවීම", "English", 15, false),
      StudyTaskItem("task_5", "බුද්ධ ධර්මය: ප්‍රශ්න පත්‍රයේ කෙටි ප්‍රශ්න 20ක් ලිවීම", "බුද්ධ ධර්මය", 25, false)
    )
  }

  var newTaskText by remember { mutableStateOf("") }
  var newTaskSubject by remember { mutableStateOf("විද්‍යාව") }
  var newTaskMinutes by remember { mutableStateOf("30") }
  var showAddTaskDialog by remember { mutableStateOf(false) }

  // Countdown State
  var targetExamName by remember { mutableStateOf("2026 අ.පො.ස. සාමාන්‍ය පෙළ (O/L)") }
  // Target date for O/L (e.g. May 15, 2027)
  val examTargetCalendar = remember {
    Calendar.getInstance().apply {
      set(2027, Calendar.MAY, 15, 8, 30, 0)
    }
  }

  var timeRemainingMillis by remember {
    mutableStateOf(max(0L, examTargetCalendar.timeInMillis - System.currentTimeMillis()))
  }

  LaunchedEffect(Unit) {
    while (true) {
      timeRemainingMillis = max(0L, examTargetCalendar.timeInMillis - System.currentTimeMillis())
      delay(1000L)
    }
  }

  val totalSeconds = timeRemainingMillis / 1000
  val days = totalSeconds / (24 * 3600)
  val hours = (totalSeconds % (24 * 3600)) / 3600
  val minutes = (totalSeconds % 3600) / 60
  val seconds = totalSeconds % 60

  val completedTasksCount = tasks.count { it.isCompleted }
  val progressPercent = if (tasks.isNotEmpty()) completedTasksCount.toFloat() / tasks.size else 0f

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = "⏱️ O/L Countdown & Daily Planner",
              fontSize = 16.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Text(
              text = "විභාග දින ගණකය හා දෛනික ඉලක්ක සැලසුම",
              fontSize = 10.sp,
              color = Color(0xFFFED7AA)
            )
          }
        },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFC2410C))
      )
    },
    floatingActionButton = {
      FloatingActionButton(
        onClick = { showAddTaskDialog = true },
        containerColor = Color(0xFFC2410C),
        contentColor = Color.White,
        shape = CircleShape
      ) {
        Icon(Icons.Default.Add, contentDescription = "Add Task")
      }
    }
  ) { paddingValues ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFF8FAFC))
        .padding(paddingValues)
        .padding(horizontal = 16.dp, vertical = 12.dp),
      verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
      // 1. HERO COUNTDOWN CARD
      item {
        Card(
          shape = RoundedCornerShape(22.dp),
          colors = CardDefaults.cardColors(containerColor = Color.Transparent),
          elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .background(
                Brush.verticalGradient(
                  colors = listOf(Color(0xFF9A3412), Color(0xFFEA580C), Color(0xFFF97316))
                )
              )
              .padding(18.dp)
          ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color.White.copy(alpha = 0.2f),
                border = BorderStroke(1.dp, Color.White.copy(alpha = 0.4f))
              ) {
                Text(
                  text = "🎯 $targetExamName",
                  fontSize = 12.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                )
              }

              Spacer(modifier = Modifier.height(14.dp))

              // Timer Digits Grid
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
              ) {
                CountdownDigitBox(value = days.toString().padStart(2, '0'), label = "දින (Days)")
                CountdownDigitBox(value = hours.toString().padStart(2, '0'), label = "පැය (Hours)")
                CountdownDigitBox(value = minutes.toString().padStart(2, '0'), label = "මිනිත්තු (Mins)")
                CountdownDigitBox(value = seconds.toString().padStart(2, '0'), label = "තත්පර (Secs)")
              }

              Spacer(modifier = Modifier.height(14.dp))

              Text(
                text = "✨ \"අද කරන පුහුණුව හෙට දවසේ විශිෂ්ට සාමාර්ථයකට මග පාදයි!\"",
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFFFEDD5),
                textAlign = TextAlign.Center
              )
            }
          }
        }
      }

      // 2. DAILY PROGRESS BAR CARD
      item {
        Card(
          shape = RoundedCornerShape(18.dp),
          colors = CardDefaults.cardColors(containerColor = Color.White),
          border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
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
                Text("📈", fontSize = 18.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                  text = "දෛනික ඉලක්ක ප්‍රගතිය (Today's Progress)",
                  fontWeight = FontWeight.Bold,
                  fontSize = 13.sp,
                  color = Color(0xFF0F172A)
                )
              }
              Text(
                text = "$completedTasksCount / ${tasks.size} සම්පූර්ණයි",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0284C7)
              )
            }

            Spacer(modifier = Modifier.height(10.dp))

            LinearProgressIndicator(
              progress = { progressPercent },
              modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .clip(CircleShape),
              color = Color(0xFF10B981),
              trackColor = Color(0xFFE2E8F0)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
              text = if (completedTasksCount == tasks.size && tasks.isNotEmpty())
                "🎉 නියමයි! අද දවසේ සියලු අධ්‍යයන ඉලක්ක සාර්ථකව අවසන්!"
              else
                "ඉතිරි ඉලක්ක ${tasks.size - completedTasksCount} සම්පූර්ණ කර ලකුණු එකතු කරගන්න.",
              fontSize = 11.sp,
              color = Color(0xFF64748B)
            )
          }
        }
      }

      // 3. TASK LIST HEADER
      item {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text("📋", fontSize = 16.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "අද දවසේ කාලසටහන (Daily Study Tasks)",
              fontWeight = FontWeight.Bold,
              fontSize = 13.sp,
              color = Color(0xFF1E293B)
            )
          }
          TextButton(onClick = { showAddTaskDialog = true }) {
            Icon(Icons.Default.AddCircle, contentDescription = "Add", modifier = Modifier.size(16.dp), tint = Color(0xFFC2410C))
            Spacer(modifier = Modifier.width(4.dp))
            Text("නව ඉලක්කයක්", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFC2410C))
          }
        }
      }

      // 4. TASK ITEMS
      items(tasks) { task ->
        Card(
          shape = RoundedCornerShape(14.dp),
          colors = CardDefaults.cardColors(
            containerColor = if (task.isCompleted) Color(0xFFF0FDF4) else Color.White
          ),
          border = BorderStroke(
            1.dp,
            if (task.isCompleted) Color(0xFFBBF7D0) else Color(0xFFE2E8F0)
          ),
          elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Checkbox(
              checked = task.isCompleted,
              onCheckedChange = { isChecked ->
                val idx = tasks.indexOf(task)
                if (idx != -1) {
                  tasks[idx] = task.copy(isCompleted = isChecked)
                  if (isChecked) {
                    Toast.makeText(context, "🌟 නියමයි! +20 XP ලකුණු හිමිවිය!", Toast.LENGTH_SHORT).show()
                  }
                }
              },
              colors = CheckboxDefaults.colors(checkedColor = Color(0xFF10B981))
            )

            Spacer(modifier = Modifier.width(6.dp))

            Column(modifier = Modifier.weight(1f)) {
              Text(
                text = task.title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = if (task.isCompleted) Color(0xFF15803D) else Color(0xFF1E293B),
                textDecoration = if (task.isCompleted) TextDecoration.LineThrough else TextDecoration.None
              )
              Spacer(modifier = Modifier.height(4.dp))
              Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                  shape = RoundedCornerShape(4.dp),
                  color = Color(0xFFEFF6FF)
                ) {
                  Text(
                    text = task.subject,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1D4ED8),
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                  )
                }
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = "⏱️ ${task.estimatedMinutes} mins",
                  fontSize = 10.sp,
                  color = Color(0xFF64748B)
                )
              }
            }

            IconButton(
              onClick = { tasks.remove(task) },
              modifier = Modifier.size(28.dp)
            ) {
              Icon(Icons.Default.DeleteOutline, contentDescription = "Delete", tint = Color(0xFF94A3B8), modifier = Modifier.size(18.dp))
            }
          }
        }
      }

      item {
        Spacer(modifier = Modifier.height(40.dp))
      }
    }
  }

  // Add Task Dialog
  if (showAddTaskDialog) {
    AlertDialog(
      onDismissRequest = { showAddTaskDialog = false },
      title = {
        Text("➕ නව අධ්‍යයන ඉලක්කයක් එක් කරන්න", fontSize = 14.sp, fontWeight = FontWeight.Bold)
      },
      text = {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
          OutlinedTextField(
            value = newTaskText,
            onValueChange = { newTaskText = it },
            label = { Text("පාඩම / ඉලක්ක විස්තරය") },
            placeholder = { Text("උදා: විද්‍යාව රසායන විද්‍යාව සටහන් කියවීම") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
          )

          OutlinedTextField(
            value = newTaskSubject,
            onValueChange = { newTaskSubject = it },
            label = { Text("විෂය (Subject)") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
          )

          OutlinedTextField(
            value = newTaskMinutes,
            onValueChange = { newTaskMinutes = it },
            label = { Text("ගතවන කාලය (මිනිත්තු)") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
          )
        }
      },
      confirmButton = {
        Button(
          onClick = {
            if (newTaskText.isNotBlank()) {
              tasks.add(
                StudyTaskItem(
                  id = "task_${System.currentTimeMillis()}",
                  title = newTaskText,
                  subject = newTaskSubject.ifBlank { "අධ්‍යයනය" },
                  estimatedMinutes = newTaskMinutes.toIntOrNull() ?: 30,
                  isCompleted = false
                )
              )
              newTaskText = ""
              showAddTaskDialog = false
              Toast.makeText(context, "ඉලක්කය සාර්ථකව එක් කරන ලදී!", Toast.LENGTH_SHORT).show()
            }
          },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC2410C))
        ) {
          Text("එක් කරන්න")
        }
      },
      dismissButton = {
        TextButton(onClick = { showAddTaskDialog = false }) {
          Text("අවලංගු කරන්න")
        }
      }
    )
  }
}

@Composable
fun CountdownDigitBox(value: String, label: String) {
  Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Surface(
      shape = RoundedCornerShape(12.dp),
      color = Color.White,
      shadowElevation = 4.dp,
      modifier = Modifier.size(58.dp)
    ) {
      Box(contentAlignment = Alignment.Center) {
        Text(
          text = value,
          fontSize = 24.sp,
          fontWeight = FontWeight.ExtraBold,
          color = Color(0xFFC2410C),
          fontFamily = FontFamily.Monospace
        )
      }
    }
    Spacer(modifier = Modifier.height(4.dp))
    Text(
      text = label,
      fontSize = 9.sp,
      fontWeight = FontWeight.Bold,
      color = Color.White
    )
  }
}

// ==============================================================================
// FEATURE 2: INTERACTIVE FLASHCARDS SYSTEM (ඩිජිටල් මතක කාඩ්පත්)
// ==============================================================================

data class StudyDeckFlashcard(
  val id: String,
  val subject: String,
  val grade: String,
  val questionFront: String,
  val answerBack: String,
  val explanationTip: String,
  var isMastered: Boolean = false
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InteractiveFlashcardsScreen(
  initialGrade: String = "11",
  initialSubject: String? = null,
  onBack: () -> Unit
) {
  val grades = listOf("9", "10", "11")
  var selectedGrade by remember { mutableStateOf(if (initialGrade in grades) initialGrade else "11") }

  val subjects = remember { ComprehensiveFlashcardRepository.availableSubjects }
  var selectedSubject by remember {
    mutableStateOf(
      if (initialSubject != null && subjects.contains(initialSubject)) initialSubject else subjects.first()
    )
  }

  // Selected set: 1..15 or null (All 300)
  var selectedSetNumber by remember { mutableStateOf<Int?>(1) }
  var showSetsDialog by remember { mutableStateOf(false) }
  // High-contrast eye-safe Dark Mode (Active by default for night & day eye comfort)
  var isDarkMode by remember { mutableStateOf(true) }

  val setsList = remember(selectedGrade, selectedSubject) {
    ComprehensiveFlashcardRepository.getSetsForSubject(selectedGrade, selectedSubject)
  }

  // Load cards for the selected grade, subject, and set
  val cards = remember(selectedGrade, selectedSubject, selectedSetNumber) {
    ComprehensiveFlashcardRepository.getFlashcards(selectedGrade, selectedSubject, selectedSetNumber)
  }

  var currentIndex by remember { mutableIntStateOf(0) }
  var isFlipped by remember { mutableStateOf(false) }

  // State sets for tracking card mastery
  val masteredCardIds = remember { mutableStateListOf<String>() }
  val reviewCardIds = remember { mutableStateListOf<String>() }

  // Reset indices on filter changes
  LaunchedEffect(selectedGrade, selectedSubject, selectedSetNumber) {
    currentIndex = 0
    isFlipped = false
  }

  val currentCard = if (cards.isNotEmpty()) cards[currentIndex.coerceIn(0, cards.size - 1)] else null
  val isCurrentMastered = currentCard != null && masteredCardIds.contains(currentCard.id)
  val isCurrentNeedReview = currentCard != null && reviewCardIds.contains(currentCard.id)

  val currentSetTitle = if (selectedSetNumber != null) {
    "කාණ්ඩය $selectedSetNumber (${(selectedSetNumber!! - 1) * 20 + 1} - ${selectedSetNumber!! * 20})"
  } else {
    "සමස්ත කාඩ්පත් 400ම (කාණ්ඩ 20)"
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text("💡 මතක කාඩ්පත් (Flashcards 400)", fontSize = 15.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text(
              "$selectedGrade ශ්‍රේණිය • $selectedSubject • $currentSetTitle",
              fontSize = 10.sp,
              color = if (isDarkMode) Color(0xFF38BDF8) else Color(0xFFBBF7D0),
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
          }
        },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
          }
        },
        actions = {
          // Night / Day Toggle Button
          IconButton(
            onClick = { isDarkMode = !isDarkMode }
          ) {
            Text(
              text = if (isDarkMode) "☀️" else "🌙",
              fontSize = 17.sp
            )
          }
          // Sets Overview button
          TextButton(
            onClick = { showSetsDialog = true },
            colors = ButtonDefaults.textButtonColors(contentColor = Color.White)
          ) {
            Icon(Icons.Default.GridView, contentDescription = "Sets", modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text("කාණ්ඩ 20", fontSize = 11.sp, fontWeight = FontWeight.Bold)
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = if (isDarkMode) Color(0xFF0F172A) else Color(0xFF15803D)
        )
      )
    }
  ) { paddingValues ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(if (isDarkMode) Color(0xFF0B1120) else Color(0xFFF8FAFC))
        .padding(paddingValues)
        .verticalScroll(rememberScrollState())
        .padding(horizontal = 14.dp, vertical = 10.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      // 1. GRADE SELECTOR SEGMENTED ROW (9 / 10 / 11 ශ්‍රේණිය)
      Surface(
        shape = RoundedCornerShape(12.dp),
        color = if (isDarkMode) Color(0xFF1E293B) else Color(0xFFE2E8F0),
        border = if (isDarkMode) BorderStroke(1.dp, Color(0xFF334155)) else null,
        modifier = Modifier.fillMaxWidth()
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp),
          horizontalArrangement = Arrangement.SpaceEvenly
        ) {
          grades.forEach { gr ->
            val isSel = selectedGrade == gr
            Surface(
              onClick = { selectedGrade = gr },
              shape = RoundedCornerShape(9.dp),
              color = if (isSel) (if (isDarkMode) Color(0xFF10B981) else Color(0xFF15803D)) else Color.Transparent,
              modifier = Modifier.weight(1f)
            ) {
              Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(vertical = 7.dp)
              ) {
                Text(
                  text = "$gr ශ්‍රේණිය",
                  fontSize = 12.sp,
                  fontWeight = if (isSel) FontWeight.Bold else FontWeight.Medium,
                  color = if (isSel) Color.White else (if (isDarkMode) Color(0xFFE2E8F0) else Color(0xFF334155))
                )
              }
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      // 2. SUBJECT FILTER CHIPS (Scrollable)
      LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        items(subjects) { subj ->
          val isSel = selectedSubject == subj
          FilterChip(
            selected = isSel,
            onClick = { selectedSubject = subj },
            label = { 
              Text(
                text = subj, 
                fontSize = 11.sp, 
                fontWeight = FontWeight.Bold,
                color = if (isSel) Color.White else (if (isDarkMode) Color(0xFFF1F5F9) else Color(0xFF1E293B))
              ) 
            },
            colors = FilterChipDefaults.filterChipColors(
              selectedContainerColor = Color(0xFF0284C7),
              selectedLabelColor = Color.White,
              containerColor = if (isDarkMode) Color(0xFF1E293B) else Color.White,
              labelColor = if (isDarkMode) Color(0xFFF1F5F9) else Color(0xFF334155)
            ),
            border = FilterChipDefaults.filterChipBorder(
              enabled = true,
              selected = isSel,
              borderColor = if (isDarkMode) Color(0xFF334155) else Color(0xFFCBD5E1),
              selectedBorderColor = Color(0xFF38BDF8)
            )
          )
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      // 3. SETS SELECTOR CHIPS (කාණ්ඩ 20ක් - කාණ්ඩයකට කාඩ්පත් 20 බැගින්)
      LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        item {
          val isSel = selectedSetNumber == null
          FilterChip(
            selected = isSel,
            onClick = { selectedSetNumber = null },
            label = { 
              Text(
                "සියලු 400ම", 
                fontSize = 10.5.sp, 
                fontWeight = FontWeight.Bold,
                color = if (isSel) Color.White else (if (isDarkMode) Color(0xFFF1F5F9) else Color(0xFF334155))
              ) 
            },
            colors = FilterChipDefaults.filterChipColors(
              selectedContainerColor = Color(0xFF7C3AED),
              selectedLabelColor = Color.White,
              containerColor = if (isDarkMode) Color(0xFF1E293B) else Color.White,
              labelColor = if (isDarkMode) Color(0xFFF1F5F9) else Color(0xFF334155)
            ),
            border = FilterChipDefaults.filterChipBorder(
              enabled = true,
              selected = isSel,
              borderColor = if (isDarkMode) Color(0xFF334155) else Color(0xFFCBD5E1),
              selectedBorderColor = Color(0xFFA78BFA)
            )
          )
        }
        items((1..20).toList()) { setIdx ->
          val isSel = selectedSetNumber == setIdx
          val startNum = (setIdx - 1) * 20 + 1
          val endNum = setIdx * 20
          FilterChip(
            selected = isSel,
            onClick = { selectedSetNumber = setIdx },
            label = {
              Text(
                "කාණ්ඩය $setIdx ($startNum-$endNum)",
                fontSize = 10.sp,
                fontWeight = if (isSel) FontWeight.Bold else FontWeight.Normal,
                color = if (isSel) Color.White else (if (isDarkMode) Color(0xFFE2E8F0) else Color(0xFF334155))
              )
            },
            colors = FilterChipDefaults.filterChipColors(
              selectedContainerColor = if (isDarkMode) Color(0xFF10B981) else Color(0xFF15803D),
              selectedLabelColor = Color.White,
              containerColor = if (isDarkMode) Color(0xFF1E293B) else Color.White,
              labelColor = if (isDarkMode) Color(0xFFE2E8F0) else Color(0xFF334155)
            ),
            border = FilterChipDefaults.filterChipBorder(
              enabled = true,
              selected = isSel,
              borderColor = if (isDarkMode) Color(0xFF334155) else Color(0xFFCBD5E1),
              selectedBorderColor = Color(0xFF34D399)
            )
          )
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      // 4. PROGRESS STATS BAR
      Surface(
        shape = RoundedCornerShape(10.dp),
        color = if (isDarkMode) Color(0xFF1E293B) else Color.White,
        border = BorderStroke(1.dp, if (isDarkMode) Color(0xFF334155) else Color(0xFFE2E8F0)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Row(
          modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Column {
            Text(
              text = "කාඩ්පත: ${if (cards.isEmpty()) 0 else currentIndex + 1} / ${cards.size}",
              fontWeight = FontWeight.Bold,
              fontSize = 11.5.sp,
              color = if (isDarkMode) Color(0xFFFFFFFF) else Color(0xFF0F172A)
            )
            if (currentCard != null) {
              Text(
                text = "සමස්ත අංකය: ${currentCard.globalIndex} / 400",
                fontSize = 9.sp,
                color = if (isDarkMode) Color(0xFF94A3B8) else Color(0xFF64748B)
              )
            }
          }

          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = if (isDarkMode) Color(0xFF064E3B) else Color(0xFFDCFCE7),
              border = if (isDarkMode) BorderStroke(1.dp, Color(0xFF059669)) else null
            ) {
              Text(
                text = "✅ මතකයි: ${masteredCardIds.size}",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = if (isDarkMode) Color(0xFF34D399) else Color(0xFF15803D),
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = if (isDarkMode) Color(0xFF451A03) else Color(0xFFFEF3C7),
              border = if (isDarkMode) BorderStroke(1.dp, Color(0xFFD97706)) else null
            ) {
              Text(
                text = "🔄 නැවත: ${reviewCardIds.size}",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = if (isDarkMode) Color(0xFFFBBF24) else Color(0xFFB45309),
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      if (cards.isEmpty() || currentCard == null) {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .height(260.dp),
          contentAlignment = Alignment.Center
        ) {
          Text("මෙම කාණ්ඩය සඳහා කාඩ්පත් හමු නොවීය.", color = Color(0xFF64748B))
        }
      } else {
        // 5. INTERACTIVE 3D FLIP CARD
        Card(
          onClick = { isFlipped = !isFlipped },
          shape = RoundedCornerShape(20.dp),
          colors = CardDefaults.cardColors(
            containerColor = if (isDarkMode) {
              if (isFlipped) Color(0xFF0F172A) else Color(0xFF1E293B)
            } else {
              if (isFlipped) Color(0xFFF0FDF4) else Color.White
            }
          ),
          border = BorderStroke(
            2.dp,
            if (isFlipped) Color(0xFF38BDF8) else (if (isDarkMode) Color(0xFF10B981) else Color(0xFF22C55E))
          ),
          elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
          modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 320.dp)
            .padding(vertical = 6.dp)
        ) {
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            // Card Header: Badges & Tags
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Surface(
                shape = RoundedCornerShape(6.dp),
                color = if (isDarkMode) Color(0xFF0F172A) else (if (isFlipped) Color(0xFFDCFCE7) else Color(0xFFE0F2FE)),
                border = if (isDarkMode) BorderStroke(1.dp, Color(0xFF334155)) else null
              ) {
                Text(
                  text = "${currentCard.subject} • ${currentCard.grade} ශ්‍රේණිය • කාණ්ඩය ${currentCard.setNumber}",
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = if (isFlipped) Color(0xFF38BDF8) else (if (isDarkMode) Color(0xFF34D399) else Color(0xFF0369A1)),
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                )
              }

              Surface(
                shape = RoundedCornerShape(6.dp),
                color = if (isDarkMode) Color(0xFF0F172A) else (if (isFlipped) Color(0xFF15803D) else Color(0xFF0284C7)),
                border = if (isDarkMode) BorderStroke(1.dp, Color(0xFF334155)) else null
              ) {
                Text(
                  text = if (isFlipped) "💡 නිල පිළිතුර & විවරණය" else "❓ මතක ප්‍රශ්නය #${currentCard.cardIndexInSet}/20",
                  fontSize = 9.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                )
              }
            }

            // Card Body (Front / Back)
            Column(
              horizontalAlignment = Alignment.CenterHorizontally,
              verticalArrangement = Arrangement.spacedBy(12.dp),
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
            ) {
              if (!isFlipped) {
                // FRONT
                if (currentCard.unitCategory.isNotEmpty()) {
                  Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = if (isDarkMode) Color(0xFF0F172A) else Color(0xFFF1F5F9),
                    border = if (isDarkMode) BorderStroke(1.dp, Color(0xFF334155)) else null
                  ) {
                    Text(
                      text = "📖 ${currentCard.unitCategory}",
                      fontSize = 11.5.sp,
                      color = if (isDarkMode) Color(0xFF7DD3FC) else Color(0xFF475569),
                      fontWeight = FontWeight.Medium,
                      modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                      textAlign = TextAlign.Center
                    )
                  }
                }

                Text(
                  text = currentCard.questionFront.replace(Regex("""^\[.*?\]\s*"""), ""),
                  fontSize = 17.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = if (isDarkMode) Color(0xFFFFFFFF) else Color(0xFF0F172A),
                  textAlign = TextAlign.Center,
                  lineHeight = 26.sp,
                  modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Surface(
                  shape = RoundedCornerShape(16.dp),
                  color = if (isDarkMode) Color(0xFF064E3B) else Color(0xFFF0FDF4),
                  border = BorderStroke(1.dp, if (isDarkMode) Color(0xFF10B981) else Color(0xFFBBF7D0))
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 7.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Icon(
                      Icons.Default.TouchApp, 
                      contentDescription = null, 
                      tint = if (isDarkMode) Color(0xFF34D399) else Color(0xFF15803D), 
                      modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                      text = "පිළිතුර බැලීමට ස්පර්ශ කරන්න (Tap to Flip)",
                      fontSize = 11.sp,
                      fontWeight = FontWeight.SemiBold,
                      color = if (isDarkMode) Color(0xFF34D399) else Color(0xFF15803D)
                    )
                  }
                }
              } else {
                // BACK (Detailed Answer + Tips)
                Text(
                  text = currentCard.answerBack,
                  fontSize = 16.sp,
                  fontWeight = FontWeight.Bold,
                  color = if (isDarkMode) Color(0xFFFFFFFF) else Color(0xFF0F172A),
                  textAlign = TextAlign.Center,
                  lineHeight = 25.sp,
                  modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp)
                )

                if (currentCard.formulaOrFact.isNotEmpty()) {
                  Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFF0284C7).copy(alpha = 0.25f),
                    border = BorderStroke(1.dp, Color(0xFF38BDF8))
                  ) {
                    Text(
                      text = "⚡ ${currentCard.formulaOrFact}",
                      fontSize = 11.5.sp,
                      color = if (isDarkMode) Color(0xFFBAE6FD) else Color(0xFF0369A1),
                      fontWeight = FontWeight.Bold,
                      modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                    )
                  }
                }

                if (currentCard.explanationTip.isNotEmpty()) {
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = if (isDarkMode) Color(0xFF1E293B) else Color(0xFFFEF3C7),
                    border = BorderStroke(1.dp, if (isDarkMode) Color(0xFFD97706) else Color(0xFFF59E0B)),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Text(
                      text = "💡 ${currentCard.explanationTip}",
                      fontSize = 11.5.sp,
                      color = if (isDarkMode) Color(0xFFFEF08A) else Color(0xFF78350F),
                      modifier = Modifier.padding(10.dp),
                      textAlign = TextAlign.Center,
                      lineHeight = 17.sp
                    )
                  }
                }
              }
            }

            // Card Bottom Bar: Quick Flip Indicator
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = "කාඩ්පත් 20න් #${currentCard.cardIndexInSet}",
                fontSize = 9.5.sp,
                color = if (isDarkMode) Color(0xFF94A3B8) else Color(0xFF64748B)
              )

              Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                  Icons.Default.FlipToBack,
                  contentDescription = "Flip",
                  tint = if (isFlipped) Color(0xFF38BDF8) else (if (isDarkMode) Color(0xFF34D399) else Color(0xFF15803D)),
                  modifier = Modifier.size(15.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                  text = if (isFlipped) "ප්‍රශ්නයට පෙරළන්න" else "පිළිතුර පෙරළන්න",
                  fontSize = 10.5.sp,
                  color = if (isFlipped) Color(0xFF38BDF8) else (if (isDarkMode) Color(0xFF34D399) else Color(0xFF15803D)),
                  fontWeight = FontWeight.Bold
                )
              }
            }
          }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 6. ACTION CONTROLS & NAVIGATION
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(6.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          // Previous
          OutlinedButton(
            onClick = {
              if (currentIndex > 0) {
                currentIndex--
                isFlipped = false
              }
            },
            enabled = currentIndex > 0,
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.outlinedButtonColors(
              containerColor = if (isDarkMode) Color(0xFF1E293B) else Color.Transparent,
              contentColor = if (isDarkMode) Color(0xFFFFFFFF) else Color(0xFF1E293B)
            ),
            border = BorderStroke(1.dp, if (isDarkMode) Color(0xFF475569) else Color(0xFFCBD5E1)),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
            modifier = Modifier.weight(1f)
          ) {
            Icon(
              Icons.Default.NavigateBefore, 
              contentDescription = "Prev", 
              modifier = Modifier.size(16.dp),
              tint = if (isDarkMode) Color(0xFFFFFFFF) else Color(0xFF1E293B)
            )
            Text(
              "පෙර", 
              fontSize = 11.sp, 
              fontWeight = FontWeight.Bold,
              color = if (isDarkMode) Color(0xFFFFFFFF) else Color(0xFF1E293B)
            )
          }

          // Mastered Check Button
          Button(
            onClick = {
              if (isCurrentMastered) {
                masteredCardIds.remove(currentCard.id)
              } else {
                masteredCardIds.add(currentCard.id)
                reviewCardIds.remove(currentCard.id)
              }
              if (currentIndex < cards.size - 1) {
                currentIndex++
                isFlipped = false
              }
            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
              containerColor = if (isCurrentMastered) Color(0xFF10B981) else Color(0xFF0284C7)
            ),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
            modifier = Modifier.weight(1.3f)
          ) {
            Icon(
              if (isCurrentMastered) Icons.Default.CheckCircle else Icons.Default.Check,
              contentDescription = null,
              tint = Color.White,
              modifier = Modifier.size(15.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
              if (isCurrentMastered) "මතකයි ✓" else "මතක තබාගත්තා",
              fontSize = 10.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
          }

          // Need Review Button
          OutlinedButton(
            onClick = {
              if (isCurrentNeedReview) {
                reviewCardIds.remove(currentCard.id)
              } else {
                reviewCardIds.add(currentCard.id)
                masteredCardIds.remove(currentCard.id)
              }
              if (currentIndex < cards.size - 1) {
                currentIndex++
                isFlipped = false
              }
            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.outlinedButtonColors(
              containerColor = if (isDarkMode) Color(0xFF451A03) else Color.Transparent,
              contentColor = if (isCurrentNeedReview) Color(0xFFFBBF24) else (if (isDarkMode) Color(0xFFFEF3C7) else Color(0xFF64748B))
            ),
            border = BorderStroke(1.dp, if (isDarkMode) Color(0xFFD97706) else Color(0xFFCBD5E1)),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
            modifier = Modifier.weight(1.1f)
          ) {
            Text(
              if (isCurrentNeedReview) "නැවත 🔄" else "සැකයි 🤔",
              fontSize = 10.5.sp,
              fontWeight = FontWeight.Bold,
              color = if (isCurrentNeedReview) Color(0xFFFBBF24) else (if (isDarkMode) Color(0xFFFEF3C7) else Color(0xFF64748B))
            )
          }

          // Next
          Button(
            onClick = {
              if (currentIndex < cards.size - 1) {
                currentIndex++
                isFlipped = false
              }
            },
            enabled = currentIndex < cards.size - 1,
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
              containerColor = if (isDarkMode) Color(0xFF0284C7) else Color(0xFF1E293B)
            ),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
            modifier = Modifier.weight(1f)
          ) {
            Text("ඊළඟ", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Icon(Icons.Default.NavigateNext, contentDescription = "Next", tint = Color.White, modifier = Modifier.size(16.dp))
          }
        }

        Spacer(modifier = Modifier.height(48.dp))
      }
    }
  }

  // DIALOG: ALL 15 SETS OVERVIEW MODAL
  if (showSetsDialog) {
    AlertDialog(
      onDismissRequest = { showSetsDialog = false },
      containerColor = if (isDarkMode) Color(0xFF1E293B) else Color.White,
      title = {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Column {
            Text(
              "📚 කාණ්ඩ 20 සාරාංශය (400 Cards)", 
              fontSize = 15.sp, 
              fontWeight = FontWeight.Bold,
              color = if (isDarkMode) Color.White else Color(0xFF0F172A)
            )
            Text(
              "$selectedGrade ශ්‍රේණිය • $selectedSubject", 
              fontSize = 11.sp, 
              color = if (isDarkMode) Color(0xFF38BDF8) else Color(0xFF64748B)
            )
          }
          IconButton(onClick = { showSetsDialog = false }) {
            Icon(
              Icons.Default.Close, 
              contentDescription = "Close",
              tint = if (isDarkMode) Color(0xFFE2E8F0) else Color(0xFF64748B)
            )
          }
        }
      },
      text = {
        LazyColumn(
          modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 420.dp),
          verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          items(setsList) { setInfo ->
            val isCurrent = selectedSetNumber == setInfo.setNumber
            Surface(
              onClick = {
                selectedSetNumber = setInfo.setNumber
                showSetsDialog = false
              },
              shape = RoundedCornerShape(10.dp),
              color = if (isCurrent) {
                if (isDarkMode) Color(0xFF064E3B) else Color(0xFFDCFCE7)
              } else {
                if (isDarkMode) Color(0xFF0F172A) else Color(0xFFF8FAFC)
              },
              border = BorderStroke(
                1.dp, 
                if (isCurrent) (if (isDarkMode) Color(0xFF10B981) else Color(0xFF22C55E)) else (if (isDarkMode) Color(0xFF334155) else Color(0xFFE2E8F0))
              ),
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Column(modifier = Modifier.weight(1f)) {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                      text = setInfo.title,
                      fontSize = 12.sp,
                      fontWeight = FontWeight.Bold,
                      color = if (isCurrent) {
                        if (isDarkMode) Color(0xFF34D399) else Color(0xFF15803D)
                      } else {
                        if (isDarkMode) Color.White else Color(0xFF0F172A)
                      }
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Surface(
                      shape = RoundedCornerShape(4.dp),
                      color = Color(0xFF0284C7)
                    ) {
                      Text(
                        text = "කාඩ් 20",
                        fontSize = 8.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                      )
                    }
                  }
                  Text(
                    text = setInfo.unitTheme,
                    fontSize = 10.sp,
                    color = if (isDarkMode) Color(0xFF94A3B8) else Color(0xFF64748B),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                }
                Icon(
                  Icons.AutoMirrored.Filled.ArrowBack,
                  contentDescription = null,
                  modifier = Modifier
                    .size(16.dp)
                    .rotate(180f),
                  tint = if (isCurrent) {
                    if (isDarkMode) Color(0xFF34D399) else Color(0xFF15803D)
                  } else {
                    if (isDarkMode) Color(0xFF94A3B8) else Color(0xFFCBD5E1)
                  }
                )
              }
            }
          }
        }
      },
      confirmButton = {
        TextButton(onClick = { showSetsDialog = false }) {
          Text(
            "වසන්න", 
            fontWeight = FontWeight.Bold,
            color = if (isDarkMode) Color(0xFF38BDF8) else Color(0xFF15803D)
          )
        }
      }
    )
  }
}

// ==============================================================================
// FEATURE 3: DAILY STUDY STREAK & BADGES (දෛනික අධ්‍යයන පුරුද්ද, XP ලකුණු සහ පදක්කම්)
// ==============================================================================

data class QuestItem(
  val id: String,
  val title: String,
  val xpReward: Int,
  val isCompleted: Boolean
)

data class BadgeItem(
  val id: String,
  val titleSinhala: String,
  val iconEmoji: String,
  val description: String,
  val isUnlocked: Boolean,
  val unlockedDate: String? = null
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudyStreakAndBadgesScreen(
  onBack: () -> Unit
) {
  val context = LocalContext.current
  var currentStreakDays by remember { mutableStateOf(7) }
  var totalXp by remember { mutableStateOf(1450) }
  var studentLevel by remember { mutableStateOf(4) }

  val quests = remember {
    mutableStateListOf(
      QuestItem("q_1", "අද කෙටි සටහන් 1ක් සම්පූර්ණයෙන් කියවීම", 50, true),
      QuestItem("q_2", "Flashcards 5ක් ප්‍රගුණ කිරීම", 30, true),
      QuestItem("q_3", "ඉංග්‍රීසි කථන වාක්‍ය 2ක් සවන්දීම හා කීම", 40, true),
      QuestItem("q_4", "ප්‍රශ්න පත්‍රයක බහුවරණ ප්‍රශ්න 10ක් විසඳීම", 60, false),
      QuestItem("q_5", "මිතුරෙකු සමඟ අධ්‍යයන සටහනක් Share කිරීම", 20, false)
    )
  }

  val badges = listOf(
    BadgeItem("b_1", "🔥 දින 7ක නොනැවතුණු Streak", "🔥", "දින 7ක් අඛණ්ඩව ඇප් එක භාවිතා කර අධ්‍යයනය කිරීම.", true, "2026-08-18"),
    BadgeItem("b_2", "🧠 විද්‍යා විශාරද (Science Master)", "🔬", "විද්‍යාව කෙටි සටහන් 10ක් කියවා අවසන් කිරීම.", true, "2026-08-15"),
    BadgeItem("b_3", "📐 ගණිත සූත්‍ර ශූරයා (Math Wizard)", "📐", "ජ්‍යාමිතිය හා වීජ ගණිතය සූත්‍ර 20ක් ප්‍රගුණ කිරීම.", true, "2026-08-10"),
    BadgeItem("b_4", "🎙️ English Fluent Speaker", "🎙️", "ඉංග්‍රීසි කථන පුහුණුවෙන් 90%+ ලකුණු ලබාගැනීම.", true, "2026-08-17"),
    BadgeItem("b_5", "🏆 O/L All-Rounder (9A ඉලක්කය)", "🏆", "සියලු විෂයන්ගේ සටහන් හා ප්‍රශ්න පත්‍ර සාර්ථකව හැදෑරීම.", false, null),
    BadgeItem("b_6", "⚡ වේගවත් පිළිතුරු දෙන්නා (Speedster)", "⚡", "මිනිත්තු 15කින් ප්‍රශ්න 20කට නිවැරදිව පිළිතුරු දීම.", false, null)
  )

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text("🔥 Study Streaks & Badges", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text("දෛනික පුරුද්ද, XP ලකුණු සහ පදක්කම්", fontSize = 10.sp, color = Color(0xFFFEF08A))
          }
        },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFEA580C))
      )
    }
  ) { paddingValues ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFF8FAFC))
        .padding(paddingValues)
        .padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      // 1. STREAK HERO CARD
      item {
        Card(
          shape = RoundedCornerShape(22.dp),
          colors = CardDefaults.cardColors(containerColor = Color.Transparent),
          elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .background(
                Brush.verticalGradient(
                  colors = listOf(Color(0xFFEA580C), Color(0xFFC2410C), Color(0xFF9A3412))
                )
              )
              .padding(18.dp)
          ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
              Text("🔥", fontSize = 42.sp)
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "දින $currentStreakDays ක අඛණ්ඩ Streak එකක්!",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
              )
              Text(
                text = "ඔබ දින 7ක් අඛණ්ඩව දිනපතා පාඩම් කරමින් සිටී!",
                fontSize = 11.sp,
                color = Color(0xFFFFEDD5)
              )

              Spacer(modifier = Modifier.height(14.dp))

              // Weekday Dots
              val weekDays = listOf("සඳු", "අඟ", "බදා", "බ්‍රහ", "සිකු", "සෙන", "ඉරි")
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
              ) {
                weekDays.forEachIndexed { idx, day ->
                  Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                      modifier = Modifier
                        .size(34.dp)
                        .clip(CircleShape)
                        .background(if (idx <= 6) Color(0xFFFDE047) else Color.White.copy(alpha = 0.2f)),
                      contentAlignment = Alignment.Center
                    ) {
                      Icon(Icons.Default.Check, contentDescription = "Checked", tint = Color(0xFF9A3412), modifier = Modifier.size(18.dp))
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(day, fontSize = 9.sp, color = Color.White, fontWeight = FontWeight.Bold)
                  }
                }
              }
            }
          }
        }
      }

      // 2. LEVEL & XP STATS
      item {
        Card(
          shape = RoundedCornerShape(18.dp),
          colors = CardDefaults.cardColors(containerColor = Color.White),
          border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
          elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Box(
                modifier = Modifier
                  .size(48.dp)
                  .clip(CircleShape)
                  .background(Color(0xFFFEF3C7)),
                contentAlignment = Alignment.Center
              ) {
                Text("⭐", fontSize = 24.sp)
              }
              Spacer(modifier = Modifier.width(12.dp))
              Column {
                Text(
                  text = "Level $studentLevel: O/L Scholar",
                  fontWeight = FontWeight.ExtraBold,
                  fontSize = 14.sp,
                  color = Color(0xFF0F172A)
                )
                Text(
                  text = "$totalXp XP ලකුණු උපයා ඇත",
                  fontSize = 11.sp,
                  color = Color(0xFFD97706),
                  fontWeight = FontWeight.Bold
                )
              }
            }

            Surface(
              shape = RoundedCornerShape(8.dp),
              color = Color(0xFFFEF3C7),
              border = BorderStroke(1.dp, Color(0xFFFDE68A))
            ) {
              Text(
                text = "Next: Lvl 5 (1600 XP)",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFB45309),
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
              )
            }
          }
        }
      }

      // 3. DAILY QUESTS
      item {
        Text(
          text = "🎯 අද දවසේ Quests (XP ලකුණු ලබාගන්න)",
          fontWeight = FontWeight.Bold,
          fontSize = 13.sp,
          color = Color(0xFF1E293B)
        )
      }

      items(quests) { quest ->
        Surface(
          shape = RoundedCornerShape(12.dp),
          color = if (quest.isCompleted) Color(0xFFF0FDF4) else Color.White,
          border = BorderStroke(1.dp, if (quest.isCompleted) Color(0xFFBBF7D0) else Color(0xFFE2E8F0)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
              Icon(
                if (quest.isCompleted) Icons.Default.CheckCircle else Icons.Default.RadioButtonUnchecked,
                contentDescription = "Status",
                tint = if (quest.isCompleted) Color(0xFF16A34A) else Color(0xFF94A3B8),
                modifier = Modifier.size(20.dp)
              )
              Spacer(modifier = Modifier.width(10.dp))
              Text(
                text = quest.title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = if (quest.isCompleted) Color(0xFF15803D) else Color(0xFF1E293B)
              )
            }

            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFFFEF9C3)
            ) {
              Text(
                text = "+${quest.xpReward} XP",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF854D0E),
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
          }
        }
      }

      // 4. UNLOCKED BADGES GRID
      item {
        Spacer(modifier = Modifier.height(6.dp))
        Text(
          text = "🏆 ඔබ උපයාගත් පදක්කම් (Achievement Badges)",
          fontWeight = FontWeight.Bold,
          fontSize = 13.sp,
          color = Color(0xFF1E293B)
        )
      }

      items(badges) { badge ->
        Card(
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(
            containerColor = if (badge.isUnlocked) Color.White else Color(0xFFF1F5F9)
          ),
          border = BorderStroke(
            1.dp,
            if (badge.isUnlocked) Color(0xFFFDE68A) else Color(0xFFE2E8F0)
          ),
          elevation = CardDefaults.cardElevation(defaultElevation = if (badge.isUnlocked) 2.dp else 0.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Box(
              modifier = Modifier
                .size(46.dp)
                .clip(CircleShape)
                .background(if (badge.isUnlocked) Color(0xFFFEF3C7) else Color(0xFFE2E8F0)),
              contentAlignment = Alignment.Center
            ) {
              Text(badge.iconEmoji, fontSize = 24.sp)
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
              Text(
                text = badge.titleSinhala,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = if (badge.isUnlocked) Color(0xFF0F172A) else Color(0xFF94A3B8)
              )
              Spacer(modifier = Modifier.height(2.dp))
              Text(
                text = badge.description,
                fontSize = 10.sp,
                color = Color(0xFF64748B)
              )
              if (badge.unlockedDate != null) {
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                  text = "✓ හිමිවූ දිනය: ${badge.unlockedDate}",
                  fontSize = 9.sp,
                  color = Color(0xFF16A34A),
                  fontWeight = FontWeight.Bold
                )
              }
            }

            if (!badge.isUnlocked) {
              Icon(Icons.Default.Lock, contentDescription = "Locked", tint = Color(0xFF94A3B8), modifier = Modifier.size(18.dp))
            }
          }
        }
      }

      item {
        Spacer(modifier = Modifier.height(30.dp))
      }
    }
  }
}

// ==============================================================================
// FEATURE 4: SPOKEN ENGLISH AI VOICE RECOGNITION (උච්චාරණ පුහුණු AI Voice Mic)
// ==============================================================================

data class SpokenSentencePractice(
  val id: String,
  val englishText: String,
  val phoneticGuide: String,
  val sinhalaMeaning: String,
  val difficulty: String,
  val category: String = "General"
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpokenEnglishVoiceRecognitionScreen(
  onBack: () -> Unit
) {
  val context = LocalContext.current
  var textToSpeech by remember { mutableStateOf<TextToSpeech?>(null) }
  var isTtsReady by remember { mutableStateOf(false) }

  // TTS Setup
  DisposableEffect(Unit) {
    var tts: TextToSpeech? = null
    tts = TextToSpeech(context) { status ->
      if (status == TextToSpeech.SUCCESS) {
        tts?.language = Locale.US
        isTtsReady = true
      }
    }
    textToSpeech = tts
    onDispose {
      tts?.stop()
      tts?.shutdown()
    }
  }

  fun speak(text: String, speed: Float = 1.0f) {
    textToSpeech?.setSpeechRate(speed)
    textToSpeech?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "PRACTICE_TTS")
  }

  // Active Sub-Feature Tab: 0 = 200 Sentences, 1 = 100 Dialogues, 2 = 100 Idioms & Phrasals, 3 = 100 Quick Drills
  var activeSpokenTab by remember { mutableStateOf(0) }

  // -------------------------------------------------------------
  // TAB 0 STATE: 200 PRACTICE SENTENCES
  // -------------------------------------------------------------
  val sentences200 = remember { SpokenEnglish200DataBank.sentences }
  var sentenceSearchQuery by remember { mutableStateOf("") }
  var selectedCategory by remember { mutableStateOf("All") }
  var selectedDifficulty by remember { mutableStateOf("All") }

  val categories = remember {
    listOf("All", "Classroom", "Greetings", "Daily Life", "Academic", "Technology", "Travel", "Opinions", "Social", "Health", "Motivation")
  }

  val filteredSentences = remember(sentenceSearchQuery, selectedCategory, selectedDifficulty) {
    sentences200.filter { item ->
      val matchesSearch = sentenceSearchQuery.isBlank() ||
        item.englishText.contains(sentenceSearchQuery, ignoreCase = true) ||
        item.sinhalaMeaning.contains(sentenceSearchQuery, ignoreCase = true)
      val matchesCat = selectedCategory == "All" || item.category.equals(selectedCategory, ignoreCase = true)
      val matchesDiff = selectedDifficulty == "All" || item.difficulty.equals(selectedDifficulty, ignoreCase = true)
      matchesSearch && matchesCat && matchesDiff
    }
  }

  var selectedSentenceIndex by remember { mutableStateOf(0) }
  val currentItem = if (filteredSentences.isNotEmpty()) {
    filteredSentences[selectedSentenceIndex.coerceIn(0, filteredSentences.size - 1)]
  } else {
    sentences200[0]
  }

  var recognizedSpokenText by remember { mutableStateOf("") }
  var matchAccuracyPercentage by remember { mutableStateOf<Int?>(null) }
  var isListening by remember { mutableStateOf(false) }
  var statusMessage by remember { mutableStateOf("මයික්‍රෆෝන් බොත්තම ඔබා ඉංග්‍රීසි වාක්‍යය ශබ්ද නඟා කියවන්න.") }

  // -------------------------------------------------------------
  // TAB 1 STATE: 100 SITUATIONAL DIALOGUES
  // -------------------------------------------------------------
  val dialogues100 = remember { SpokenDialogues100DataBank.dialogues }
  var dialogueSearchQuery by remember { mutableStateOf("") }
  var selectedDialogueCategory by remember { mutableStateOf("All") }
  val dialogueCategories = remember {
    listOf("All", "School & Classroom", "Travel & Transport", "Shopping & Money", "Health & Medical", "Interview & Ambition")
  }
  val filteredDialogues = remember(dialogueSearchQuery, selectedDialogueCategory) {
    dialogues100.filter { dlg ->
      val matchesSearch = dialogueSearchQuery.isBlank() ||
        dlg.title.contains(dialogueSearchQuery, ignoreCase = true) ||
        dlg.textA.contains(dialogueSearchQuery, ignoreCase = true) ||
        dlg.textB.contains(dialogueSearchQuery, ignoreCase = true) ||
        dlg.sinhalaA.contains(dialogueSearchQuery, ignoreCase = true) ||
        dlg.sinhalaB.contains(dialogueSearchQuery, ignoreCase = true)
      val matchesCat = selectedDialogueCategory == "All" || dlg.category.equals(selectedDialogueCategory, ignoreCase = true)
      matchesSearch && matchesCat
    }
  }
  var activeDialogueIndex by remember { mutableStateOf(0) }

  // -------------------------------------------------------------
  // TAB 2 STATE: 100 IDIOMS & PHRASAL VERBS
  // -------------------------------------------------------------
  val idioms100 = remember { SpokenIdioms100DataBank.items }
  var idiomSearchQuery by remember { mutableStateOf("") }
  var selectedIdiomType by remember { mutableStateOf("All") } // "All", "Idiom", "Phrasal Verb"
  val filteredIdioms = remember(idiomSearchQuery, selectedIdiomType) {
    idioms100.filter { item ->
      val matchesSearch = idiomSearchQuery.isBlank() ||
        item.phrase.contains(idiomSearchQuery, ignoreCase = true) ||
        item.sinhalaMeaning.contains(idiomSearchQuery, ignoreCase = true) ||
        item.englishExplanation.contains(idiomSearchQuery, ignoreCase = true) ||
        item.exampleDialogue.contains(idiomSearchQuery, ignoreCase = true)
      val matchesType = selectedIdiomType == "All" || item.category.equals(selectedIdiomType, ignoreCase = true)
      matchesSearch && matchesType
    }
  }

  // -------------------------------------------------------------
  // TAB 3 STATE: 100 QUICK RESPONSE DRILLS
  // -------------------------------------------------------------
  val drills100 = remember { SpokenDrills100DataBank.drills }
  var activeDrillIndex by remember { mutableStateOf(0) }
  val drillAnswers = remember { mutableStateMapOf<String, Int>() }

  // Calculate similarity
  fun calculateAccuracy(spoken: String, expected: String): Int {
    val cleanSpoken = spoken.lowercase().replace(Regex("[^a-z0-9 ]"), "").trim().split("\\s+".toRegex())
    val cleanExpected = expected.lowercase().replace(Regex("[^a-z0-9 ]"), "").trim().split("\\s+".toRegex())
    if (cleanExpected.isEmpty() || cleanSpoken.isEmpty()) return 0
    var matches = 0
    cleanExpected.forEach { word ->
      if (cleanSpoken.contains(word)) matches++
    }
    return ((matches.toFloat() / cleanExpected.size) * 100).toInt().coerceIn(0, 100)
  }

  // Native Speech Recognizer Launcher
  val speechLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.StartActivityForResult()
  ) { result ->
    isListening = false
    if (result.resultCode == Activity.RESULT_OK && result.data != null) {
      val matches = result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
      if (!matches.isNullOrEmpty()) {
        val spoken = matches[0]
        recognizedSpokenText = spoken
        val expected = if (activeSpokenTab == 1 && filteredDialogues.isNotEmpty()) {
          filteredDialogues[activeDialogueIndex.coerceIn(0, filteredDialogues.size - 1)].textB
        } else {
          currentItem.englishText
        }
        val accuracy = calculateAccuracy(spoken, expected)
        matchAccuracyPercentage = accuracy
        statusMessage = when {
          accuracy >= 85 -> "🌟 විශිෂ්ටයි! ඉතාමත් පැහැදිලි නිවැරදි උච්චාරණයක්! (+50 XP)"
          accuracy >= 50 -> "👍 හොඳයි! නැවත උත්සාහ කර 100% ට ළඟා වන්න."
          else -> "💡 නැවත සවන්දී පැහැදිලිව නැවත කියවන්න."
        }
      }
    } else {
      statusMessage = "කටහඬ හඳුනාගැනීම අවලංගු විය. නැවත උත්සාහ කරන්න."
    }
  }

  // Permission Launcher
  val micPermissionLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.RequestPermission()
  ) { isGranted ->
    if (isGranted) {
      val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
        putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US")
        putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak in English now...")
      }
      try {
        isListening = true
        statusMessage = "🎙️ සවන්දෙමින් පවතී... වාක්‍යය ශබ්ද නඟා කියවන්න."
        speechLauncher.launch(intent)
      } catch (e: Exception) {
        isListening = false
        Toast.makeText(context, "Speech recognition is not available on this device", Toast.LENGTH_SHORT).show()
      }
    } else {
      Toast.makeText(context, "Microphone permission is required for voice practice", Toast.LENGTH_SHORT).show()
    }
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text("🎙️ Spoken English Master Suite", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.White)
              Spacer(modifier = Modifier.width(6.dp))
              Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFF38BDF8)) {
                Text(
                  text = "500+ CONTENT",
                  fontSize = 8.5.sp,
                  fontWeight = FontWeight.ExtraBold,
                  color = Color(0xFF0C4A6E),
                  modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                )
              }
            }
            Text("වාක්‍ය 200 • දෙබස් 100 • Idioms 100 • Drills 100", fontSize = 10.sp, color = Color(0xFFBAE6FD))
          }
        },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0369A1))
      )
    }
  ) { paddingValues ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFF8FAFC))
        .padding(paddingValues)
    ) {
      // MODE SELECTOR NAVIGATION TABS
      Surface(
        color = Color(0xFF075985),
        modifier = Modifier.fillMaxWidth()
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 6.dp),
          horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
          val tabs = listOf(
            "🎙️ වාක්‍ය 200",
            "💬 දෙබස් 100",
            "💡 Idioms 100",
            "⚡ Drills 100"
          )
          tabs.forEachIndexed { index, title ->
            val isSelected = activeSpokenTab == index
            Surface(
              onClick = {
                activeSpokenTab = index
                recognizedSpokenText = ""
                matchAccuracyPercentage = null
                statusMessage = "මයික්‍රෆෝන් බොත්තම ඔබා ඉංග්‍රීසි වාක්‍යය ශබ්ද නඟා කියවන්න."
              },
              shape = RoundedCornerShape(8.dp),
              color = if (isSelected) Color.White else Color.White.copy(alpha = 0.15f),
              modifier = Modifier.weight(1f)
            ) {
              Box(
                modifier = Modifier.padding(vertical = 7.dp),
                contentAlignment = Alignment.Center
              ) {
                Text(
                  text = title,
                  fontSize = 10.5.sp,
                  fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Medium,
                  color = if (isSelected) Color(0xFF0369A1) else Color.White,
                  maxLines = 1
                )
              }
            }
          }
        }
      }

      // CONTENT AREA BASED ON TAB
      when (activeSpokenTab) {
        // =========================================================================
        // TAB 0: 200 SPOKEN SENTENCES WITH REAL-TIME VOICE RECOGNITION
        // =========================================================================
        0 -> {
          LazyColumn(
            modifier = Modifier
              .fillMaxSize()
              .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
          ) {
            // Search Bar
            item {
              OutlinedTextField(
                value = sentenceSearchQuery,
                onValueChange = { sentenceSearchQuery = it },
                placeholder = { Text("වාක්‍ය 200 තුළ සොයන්න (Search in English or Sinhala)...", fontSize = 11.5.sp) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF0369A1)) },
                trailingIcon = {
                  if (sentenceSearchQuery.isNotBlank()) {
                    IconButton(onClick = { sentenceSearchQuery = "" }) {
                      Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color.Gray)
                    }
                  }
                },
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                  focusedBorderColor = Color(0xFF0369A1),
                  unfocusedBorderColor = Color(0xFFCBD5E1),
                  focusedContainerColor = Color.White,
                  unfocusedContainerColor = Color.White
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
              )
            }

            // Category Filter Chips
            item {
              Column {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text("මාතෘකාව තෝරන්න (${filteredSentences.size} / 200):", fontWeight = FontWeight.Bold, fontSize = 11.sp, color = Color(0xFF1E293B))
                  Text("Difficulty: $selectedDifficulty", fontSize = 10.sp, color = Color(0xFF0284C7), fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(4.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                  items(categories) { cat ->
                    FilterChip(
                      selected = selectedCategory == cat,
                      onClick = {
                        selectedCategory = cat
                        selectedSentenceIndex = 0
                      },
                      label = { Text(cat, fontSize = 10.sp) },
                      colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0xFF0369A1),
                        selectedLabelColor = Color.White
                      )
                    )
                  }
                }
              }
            }

            // Difficulty Quick Filter Row
            item {
              Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                listOf("All", "Beginner", "Intermediate", "Advanced").forEach { diff ->
                  Surface(
                    onClick = {
                      selectedDifficulty = diff
                      selectedSentenceIndex = 0
                    },
                    shape = RoundedCornerShape(6.dp),
                    color = if (selectedDifficulty == diff) Color(0xFF0369A1) else Color(0xFFE2E8F0)
                  ) {
                    Text(
                      text = diff,
                      fontSize = 9.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = if (selectedDifficulty == diff) Color.White else Color(0xFF475569),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                  }
                }
              }
            }

            // Navigation Bar (Previous, Counter, Next)
            item {
              Surface(
                shape = RoundedCornerShape(10.dp),
                color = Color(0xFFEFF6FF),
                border = BorderStroke(1.dp, Color(0xFFBFDBFE)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 6.dp),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  IconButton(
                    onClick = {
                      if (selectedSentenceIndex > 0) {
                        selectedSentenceIndex--
                        recognizedSpokenText = ""
                        matchAccuracyPercentage = null
                      }
                    },
                    enabled = selectedSentenceIndex > 0,
                    modifier = Modifier.size(32.dp)
                  ) {
                    Icon(Icons.Default.ArrowBackIos, contentDescription = "Prev", modifier = Modifier.size(16.dp))
                  }

                  Text(
                    text = "වාක්‍යය ${selectedSentenceIndex + 1} / ${filteredSentences.size} (${currentItem.category})",
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E3A8A)
                  )

                  IconButton(
                    onClick = {
                      if (selectedSentenceIndex < filteredSentences.size - 1) {
                        selectedSentenceIndex++
                        recognizedSpokenText = ""
                        matchAccuracyPercentage = null
                      }
                    },
                    enabled = selectedSentenceIndex < filteredSentences.size - 1,
                    modifier = Modifier.size(32.dp)
                  ) {
                    Icon(Icons.Default.ArrowForwardIos, contentDescription = "Next", modifier = Modifier.size(16.dp))
                  }
                }
              }
            }

            // CURRENT SENTENCE CARD
            item {
              Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(1.5.dp, Color(0xFFBAE6FD)),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.5.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(16.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                      Surface(shape = RoundedCornerShape(6.dp), color = Color(0xFFE0F2FE)) {
                        Text(
                          text = "🎯 ${currentItem.difficulty}",
                          fontSize = 9.5.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFF0369A1),
                          modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                      }
                      Spacer(modifier = Modifier.width(6.dp))
                      Surface(shape = RoundedCornerShape(6.dp), color = Color(0xFFFEF3C7)) {
                        Text(
                          text = "📂 ${currentItem.category}",
                          fontSize = 9.5.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFF92400E),
                          modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                      }
                    }

                    Row {
                      IconButton(
                        onClick = { speak(currentItem.englishText, 1.0f) },
                        modifier = Modifier.size(32.dp)
                      ) {
                        Icon(Icons.Default.VolumeUp, contentDescription = "Speak Normal", tint = Color(0xFF0284C7), modifier = Modifier.size(18.dp))
                      }
                      IconButton(
                        onClick = { speak(currentItem.englishText, 0.7f) },
                        modifier = Modifier.size(32.dp)
                      ) {
                        Icon(Icons.Default.SlowMotionVideo, contentDescription = "Speak Slow", tint = Color(0xFFD97706), modifier = Modifier.size(18.dp))
                      }
                    }
                  }

                  Spacer(modifier = Modifier.height(8.dp))

                  Text(
                    text = currentItem.englishText,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A),
                    lineHeight = 22.sp
                  )

                  Spacer(modifier = Modifier.height(4.dp))

                  Text(
                    text = currentItem.phoneticGuide,
                    fontSize = 11.sp,
                    fontFamily = FontFamily.Monospace,
                    color = Color(0xFF64748B)
                  )

                  Spacer(modifier = Modifier.height(8.dp))
                  HorizontalDivider(color = Color(0xFFF1F5F9))
                  Spacer(modifier = Modifier.height(8.dp))

                  Text(
                    text = "තේරුම: ${currentItem.sinhalaMeaning}",
                    fontSize = 12.sp,
                    color = Color(0xFF334155),
                    lineHeight = 18.sp
                  )
                }
              }
            }

            // MIC RECORD ACTION CARD
            item {
              Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                  containerColor = if (matchAccuracyPercentage != null && matchAccuracyPercentage!! >= 80) Color(0xFFF0FDF4) else Color(0xFFF8FAFC)
                ),
                border = BorderStroke(
                  1.dp,
                  if (matchAccuracyPercentage != null && matchAccuracyPercentage!! >= 80) Color(0xFF86EFAC) else Color(0xFFCBD5E1)
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(
                  modifier = Modifier.padding(16.dp),
                  horizontalAlignment = Alignment.CenterHorizontally
                ) {
                  Text(
                    text = "🎙️ මයික්‍රෆෝනයෙන් කථා කර Accuracy ලකුණු ලබාගන්න",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A)
                  )

                  Spacer(modifier = Modifier.height(4.dp))

                  Text(
                    text = statusMessage,
                    fontSize = 10.5.sp,
                    color = Color(0xFF475569),
                    textAlign = TextAlign.Center
                  )

                  Spacer(modifier = Modifier.height(14.dp))

                  // Big Mic Button
                  Button(
                    onClick = {
                      if (ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
                        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                          putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                          putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US")
                          putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak the sentence in English now...")
                        }
                        try {
                          isListening = true
                          statusMessage = "🎙️ සවන්දෙමින් පවතී... දැන් කියවන්න."
                          speechLauncher.launch(intent)
                        } catch (e: Exception) {
                          isListening = false
                          Toast.makeText(context, "Speech recognition unavailable", Toast.LENGTH_SHORT).show()
                        }
                      } else {
                        micPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                      }
                    },
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                      containerColor = if (isListening) Color(0xFFDC2626) else Color(0xFF0284C7)
                    ),
                    modifier = Modifier.size(64.dp)
                  ) {
                    Icon(
                      if (isListening) Icons.Default.Hearing else Icons.Default.Mic,
                      contentDescription = "Mic",
                      tint = Color.White,
                      modifier = Modifier.size(32.dp)
                    )
                  }

                  if (recognizedSpokenText.isNotBlank()) {
                    Spacer(modifier = Modifier.height(14.dp))
                    Surface(
                      shape = RoundedCornerShape(10.dp),
                      color = Color.White,
                      border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                      modifier = Modifier.fillMaxWidth()
                    ) {
                      Column(modifier = Modifier.padding(12.dp)) {
                        Text("ඔබ පැවසූ දෙය (You said):", fontSize = 10.sp, color = Color(0xFF64748B), fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                          text = "\"$recognizedSpokenText\"",
                          fontSize = 12.5.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFF0F172A)
                        )

                        if (matchAccuracyPercentage != null) {
                          Spacer(modifier = Modifier.height(8.dp))
                          Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                          ) {
                            Text("නිරවද්‍යතාවය (Accuracy):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF334155))
                            Text(
                              text = "$matchAccuracyPercentage%",
                              fontSize = 15.sp,
                              fontWeight = FontWeight.ExtraBold,
                              color = if (matchAccuracyPercentage!! >= 80) Color(0xFF16A34A) else if (matchAccuracyPercentage!! >= 50) Color(0xFFD97706) else Color(0xFFDC2626)
                            )
                          }
                          Spacer(modifier = Modifier.height(4.dp))
                          LinearProgressIndicator(
                            progress = { (matchAccuracyPercentage!! / 100f).coerceIn(0f, 1f) },
                            modifier = Modifier
                              .fillMaxWidth()
                              .height(6.dp)
                              .clip(CircleShape),
                            color = if (matchAccuracyPercentage!! >= 80) Color(0xFF16A34A) else if (matchAccuracyPercentage!! >= 50) Color(0xFFD97706) else Color(0xFFDC2626),
                            trackColor = Color(0xFFE2E8F0)
                          )
                        }
                      }
                    }
                  }
                }
              }
            }

            item {
              Spacer(modifier = Modifier.height(30.dp))
            }
          }
        }

        // =========================================================================
        // TAB 1: 100 REAL-LIFE SITUATIONAL DIALOGUES
        // =========================================================================
        1 -> {
          LazyColumn(
            modifier = Modifier
              .fillMaxSize()
              .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
          ) {
            // Search Bar
            item {
              OutlinedTextField(
                value = dialogueSearchQuery,
                onValueChange = { dialogueSearchQuery = it },
                placeholder = { Text("දෙබස් 100 තුළ සොයන්න (Search Dialogues)...", fontSize = 11.5.sp) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF0369A1)) },
                trailingIcon = {
                  if (dialogueSearchQuery.isNotBlank()) {
                    IconButton(onClick = { dialogueSearchQuery = "" }) {
                      Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color.Gray)
                    }
                  }
                },
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                  focusedBorderColor = Color(0xFF0369A1),
                  unfocusedBorderColor = Color(0xFFCBD5E1),
                  focusedContainerColor = Color.White,
                  unfocusedContainerColor = Color.White
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
              )
            }

            // Dialogue Category Filter Chips
            item {
              Column {
                Text("දෙබස් කාණ්ඩය තෝරන්න (${filteredDialogues.size} / 100):", fontWeight = FontWeight.Bold, fontSize = 11.sp, color = Color(0xFF1E293B))
                Spacer(modifier = Modifier.height(4.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                  items(dialogueCategories) { cat ->
                    FilterChip(
                      selected = selectedDialogueCategory == cat,
                      onClick = { selectedDialogueCategory = cat },
                      label = { Text(cat, fontSize = 10.sp) },
                      colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0xFF0369A1),
                        selectedLabelColor = Color.White
                      )
                    )
                  }
                }
              }
            }

            // List of Dialogues
            items(filteredDialogues.size) { idx ->
              val dlg = filteredDialogues[idx]
              Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color(0xFFBAE6FD)),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(14.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                      Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFF0284C7)) {
                        Text(
                          text = "#${idx + 1}",
                          fontSize = 9.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color.White,
                          modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                        )
                      }
                      Spacer(modifier = Modifier.width(6.dp))
                      Text(
                        text = dlg.title,
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A)
                      )
                    }

                    Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFFE0F2FE)) {
                      Text(
                        text = dlg.category,
                        fontSize = 8.5.sp,
                        color = Color(0xFF0369A1),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                      )
                    }
                  }

                  Spacer(modifier = Modifier.height(10.dp))

                  // Speaker A Bubble
                  Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = Color(0xFFF1F5F9),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                      Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                      ) {
                        Text(
                          text = "🗣️ ${dlg.speakerA}:",
                          fontSize = 11.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFF475569)
                        )
                        IconButton(
                          onClick = { speak(dlg.textA) },
                          modifier = Modifier.size(24.dp)
                        ) {
                          Icon(Icons.Default.VolumeUp, contentDescription = "Speak A", tint = Color(0xFF0284C7), modifier = Modifier.size(16.dp))
                        }
                      }
                      Text(dlg.textA, fontSize = 12.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0F172A))
                      Spacer(modifier = Modifier.height(2.dp))
                      Text(dlg.sinhalaA, fontSize = 10.5.sp, color = Color(0xFF64748B))
                    }
                  }

                  Spacer(modifier = Modifier.height(8.dp))

                  // Speaker B Bubble (with Mic practice)
                  Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = Color(0xFFE0F2FE),
                    border = BorderStroke(1.dp, Color(0xFFBAE6FD)),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                      Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                      ) {
                        Text(
                          text = "🙋‍♂️ ${dlg.speakerB} (ඔබේ වාරය - Your Turn):",
                          fontSize = 11.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFF0369A1)
                        )
                        Row {
                          IconButton(
                            onClick = { speak(dlg.textB) },
                            modifier = Modifier.size(24.dp)
                          ) {
                            Icon(Icons.Default.VolumeUp, contentDescription = "Speak B", tint = Color(0xFF0284C7), modifier = Modifier.size(16.dp))
                          }
                          Spacer(modifier = Modifier.width(4.dp))
                          IconButton(
                            onClick = {
                              activeDialogueIndex = idx
                              if (ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
                                val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                                  putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                                  putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US")
                                  putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak Speaker B's response now...")
                                }
                                try {
                                  speechLauncher.launch(intent)
                                } catch (e: Exception) {
                                  Toast.makeText(context, "Speech recognition unavailable", Toast.LENGTH_SHORT).show()
                                }
                              } else {
                                micPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                              }
                            },
                            modifier = Modifier.size(24.dp)
                          ) {
                            Icon(Icons.Default.Mic, contentDescription = "Record B", tint = Color(0xFFDC2626), modifier = Modifier.size(16.dp))
                          }
                        }
                      }
                      Text(dlg.textB, fontSize = 12.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0369A1))
                      Spacer(modifier = Modifier.height(2.dp))
                      Text(dlg.sinhalaB, fontSize = 10.5.sp, color = Color(0xFF334155))
                    }
                  }
                }
              }
            }

            item {
              Spacer(modifier = Modifier.height(30.dp))
            }
          }
        }

        // =========================================================================
        // TAB 2: 100 SPOKEN IDIOMS & PHRASAL VERBS
        // =========================================================================
        2 -> {
          LazyColumn(
            modifier = Modifier
              .fillMaxSize()
              .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
          ) {
            // Search Bar
            item {
              OutlinedTextField(
                value = idiomSearchQuery,
                onValueChange = { idiomSearchQuery = it },
                placeholder = { Text("Idioms & Phrasal Verbs 100 තුළ සොයන්න...", fontSize = 11.5.sp) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF0369A1)) },
                trailingIcon = {
                  if (idiomSearchQuery.isNotBlank()) {
                    IconButton(onClick = { idiomSearchQuery = "" }) {
                      Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color.Gray)
                    }
                  }
                },
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                  focusedBorderColor = Color(0xFF0369A1),
                  unfocusedBorderColor = Color(0xFFCBD5E1),
                  focusedContainerColor = Color.White,
                  unfocusedContainerColor = Color.White
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
              )
            }

            // Type Filter
            item {
              Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                listOf("All", "Idiom", "Phrasal Verb").forEach { type ->
                  Surface(
                    onClick = { selectedIdiomType = type },
                    shape = RoundedCornerShape(6.dp),
                    color = if (selectedIdiomType == type) Color(0xFF0369A1) else Color(0xFFE2E8F0)
                  ) {
                    Text(
                      text = type,
                      fontSize = 10.sp,
                      fontWeight = FontWeight.Bold,
                      color = if (selectedIdiomType == type) Color.White else Color(0xFF475569),
                      modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                  }
                }
              }
            }

            // Idioms List
            items(filteredIdioms.size) { idx ->
              val item = filteredIdioms[idx]
              Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(14.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                      Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = if (item.category == "Idiom") Color(0xFFF59E0B) else Color(0xFF0EA5E9)
                      ) {
                        Text(
                          text = item.category.uppercase(),
                          fontSize = 8.5.sp,
                          fontWeight = FontWeight.ExtraBold,
                          color = Color.White,
                          modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                        )
                      }
                      Spacer(modifier = Modifier.width(8.dp))
                      Text(
                        text = item.phrase,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A)
                      )
                    }

                    IconButton(
                      onClick = { speak(item.phrase) },
                      modifier = Modifier.size(28.dp)
                    ) {
                      Icon(Icons.Default.VolumeUp, contentDescription = "Speak", tint = Color(0xFF0284C7), modifier = Modifier.size(18.dp))
                    }
                  }

                  Spacer(modifier = Modifier.height(4.dp))
                  Text(
                    text = "🎯 සිංහල අර්ථය: ${item.sinhalaMeaning}",
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF15803D)
                  )

                  Text(
                    text = "Meaning: ${item.englishExplanation}",
                    fontSize = 10.5.sp,
                    color = Color(0xFF64748B)
                  )

                  Spacer(modifier = Modifier.height(8.dp))
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFF8FAFC),
                    border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                      Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                      ) {
                        Text("💬 කථන උදාහරණය (Dialogue Example):", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0284C7))
                        IconButton(
                          onClick = { speak(item.exampleDialogue) },
                          modifier = Modifier.size(20.dp)
                        ) {
                          Icon(Icons.Default.VolumeUp, contentDescription = "Audio", tint = Color(0xFF0284C7), modifier = Modifier.size(14.dp))
                        }
                      }
                      Text("\"${item.exampleDialogue}\"", fontSize = 11.5.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF1E293B))
                      Spacer(modifier = Modifier.height(2.dp))
                      Text(item.exampleSinhala, fontSize = 10.sp, color = Color(0xFF475569))
                    }
                  }
                }
              }
            }

            item {
              Spacer(modifier = Modifier.height(30.dp))
            }
          }
        }

        // =========================================================================
        // TAB 3: 100 QUICK RESPONSE DRILLS
        // =========================================================================
        3 -> {
          val currentDrill = drills100[activeDrillIndex.coerceIn(0, drills100.size - 1)]
          val userSelected = drillAnswers[currentDrill.id]
          val isAnswered = userSelected != null
          val isCorrect = userSelected == currentDrill.correctOptionIndex

          LazyColumn(
            modifier = Modifier
              .fillMaxSize()
              .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
          ) {
            // Header Stats Bar
            item {
              Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF0F172A),
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 10.dp),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Column {
                    Text(
                      text = "⚡ ක්ෂණික පිළිතුරු අභ්‍යාස 100 (Quick Drills)",
                      fontSize = 12.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color.White
                    )
                    Text(
                      text = "කෙනෙකු යමක් පැවසූ විට වඩාත් නිවැරදි ප්‍රතිචාරය තෝරන්න",
                      fontSize = 9.5.sp,
                      color = Color(0xFFBAE6FD)
                    )
                  }

                  Surface(shape = RoundedCornerShape(6.dp), color = Color(0xFF38BDF8)) {
                    Text(
                      text = "${activeDrillIndex + 1} / 100",
                      fontSize = 11.sp,
                      fontWeight = FontWeight.ExtraBold,
                      color = Color(0xFF0F172A),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }
                }
              }
            }

            // DRILL CARD
            item {
              Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(1.2.dp, Color(0xFFBAE6FD)),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(16.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Surface(shape = RoundedCornerShape(6.dp), color = Color(0xFFE0F2FE)) {
                      Text(
                        text = "🎯 අවස්ථාව: ${currentDrill.situation}",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0369A1),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                      )
                    }

                    IconButton(
                      onClick = { speak(currentDrill.prompt) },
                      modifier = Modifier.size(32.dp)
                    ) {
                      Icon(Icons.Default.VolumeUp, contentDescription = "Pronounce", tint = Color(0xFF0284C7))
                    }
                  }

                  Spacer(modifier = Modifier.height(10.dp))

                  Text("අනෙක් පුද්ගලයා පවසන්නේ:", fontSize = 10.sp, color = Color(0xFF64748B), fontWeight = FontWeight.Bold)
                  Spacer(modifier = Modifier.height(2.dp))
                  Text(
                    text = currentDrill.prompt,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A)
                  )
                  Text(
                    text = currentDrill.sinhalaPrompt,
                    fontSize = 11.5.sp,
                    color = Color(0xFF475569)
                  )

                  Spacer(modifier = Modifier.height(14.dp))
                  Text("ඔබේ වඩාත් ආචාරශීලී ප්‍රතිචාරය කුමක්ද?", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0369A1))
                  Spacer(modifier = Modifier.height(6.dp))

                  // Options
                  currentDrill.options.forEachIndexed { optIdx, optText ->
                    val isOptionSelected = userSelected == optIdx
                    val isOptionCorrect = optIdx == currentDrill.correctOptionIndex

                    Surface(
                      onClick = {
                        drillAnswers[currentDrill.id] = optIdx
                      },
                      shape = RoundedCornerShape(10.dp),
                      color = when {
                        !isAnswered -> Color(0xFFF8FAFC)
                        isOptionSelected && isOptionCorrect -> Color(0xFFDCFCE7)
                        isOptionSelected && !isOptionCorrect -> Color(0xFFFEE2E2)
                        !isOptionSelected && isOptionCorrect && isAnswered -> Color(0xFFDCFCE7)
                        else -> Color(0xFFF8FAFC)
                      },
                      border = BorderStroke(
                        1.dp,
                        when {
                          !isAnswered -> Color(0xFFE2E8F0)
                          isOptionSelected && isOptionCorrect -> Color(0xFF22C55E)
                          isOptionSelected && !isOptionCorrect -> Color(0xFFEF4444)
                          !isOptionSelected && isOptionCorrect && isAnswered -> Color(0xFF22C55E)
                          else -> Color(0xFFE2E8F0)
                        }
                      ),
                      modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                    ) {
                      Row(
                        modifier = Modifier
                          .fillMaxWidth()
                          .padding(horizontal = 10.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                      ) {
                        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                          Surface(
                            shape = CircleShape,
                            color = when {
                              !isAnswered -> Color(0xFFCBD5E1)
                              isOptionCorrect -> Color(0xFF16A34A)
                              isOptionSelected -> Color(0xFFDC2626)
                              else -> Color(0xFFCBD5E1)
                            },
                            modifier = Modifier.size(20.dp)
                          ) {
                            Box(contentAlignment = Alignment.Center) {
                              Text(
                                text = "${('A' + optIdx)}",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                              )
                            }
                          }
                          Spacer(modifier = Modifier.width(8.dp))
                          Text(
                            text = optText,
                            fontSize = 12.sp,
                            fontWeight = if (isOptionSelected || (isAnswered && isOptionCorrect)) FontWeight.Bold else FontWeight.Normal,
                            color = when {
                              !isAnswered -> Color(0xFF1E293B)
                              isOptionCorrect -> Color(0xFF15803D)
                              isOptionSelected -> Color(0xFFB91C1C)
                              else -> Color(0xFF64748B)
                            }
                          )
                        }

                        IconButton(
                          onClick = { speak(optText) },
                          modifier = Modifier.size(24.dp)
                        ) {
                          Icon(Icons.Default.VolumeUp, contentDescription = "Audio", tint = Color(0xFF0284C7), modifier = Modifier.size(16.dp))
                        }
                      }
                    }
                  }

                  // Explanation
                  if (isAnswered) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Surface(
                      shape = RoundedCornerShape(8.dp),
                      color = if (isCorrect) Color(0xFFF0FDF4) else Color(0xFFFEF2F2),
                      border = BorderStroke(1.dp, if (isCorrect) Color(0xFF86EFAC) else Color(0xFFFCA5A5)),
                      modifier = Modifier.fillMaxWidth()
                    ) {
                      Column(modifier = Modifier.padding(10.dp)) {
                        Text(
                          text = if (isCorrect) "🌟 100% නිවැරදියි!" else "💡 නිවැරදි පිළිතුර විවරණය:",
                          fontSize = 11.5.sp,
                          fontWeight = FontWeight.Bold,
                          color = if (isCorrect) Color(0xFF16A34A) else Color(0xFFDC2626)
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                          text = currentDrill.sinhalaExplanation,
                          fontSize = 10.5.sp,
                          color = Color(0xFF334155),
                          lineHeight = 15.sp
                        )
                      }
                    }
                  }
                }
              }
            }

            // Bottom Navigation Buttons (Previous / Next Drill)
            item {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Button(
                  onClick = {
                    if (activeDrillIndex > 0) activeDrillIndex--
                  },
                  enabled = activeDrillIndex > 0,
                  colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF475569)),
                  shape = RoundedCornerShape(8.dp)
                ) {
                  Text("⬅️ පෙර ප්‍රශ්නය", fontSize = 11.sp)
                }

                Button(
                  onClick = {
                    if (activeDrillIndex < drills100.size - 1) activeDrillIndex++
                  },
                  enabled = activeDrillIndex < drills100.size - 1,
                  colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
                  shape = RoundedCornerShape(8.dp)
                ) {
                  Text("ඊළඟ ප්‍රශ්නය ➡️", fontSize = 11.sp)
                }
              }
            }

            item {
              Spacer(modifier = Modifier.height(30.dp))
            }
          }
        }
      }
    }
  }
}

// ==============================================================================
// FEATURE 5: BOOKMARK & FAVORITES SCREEN (ප්‍රියතම සටහන් Bookmark කර ගැනීම)
// ==============================================================================

data class BookmarkItem(
  val id: String,
  val title: String,
  val subject: String,
  val grade: String,
  val type: String, // "NOTE", "PAPER", "FORMULA", "ESSAY"
  val pdfUri: String? = null,
  val savedDate: String = "2026-08-18"
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookmarksAndFavoritesScreen(
  onBack: () -> Unit,
  onOpenPdf: (pdfUri: String, title: String) -> Unit,
  savedBookmarks: SnapshotStateList<BookmarkItem>
) {
  val context = LocalContext.current
  var searchQuery by remember { mutableStateOf("") }
  var filterType by remember { mutableStateOf("සියල්ල") }

  val filterTypes = listOf("සියල්ල", "කෙටි සටහන්", "ප්‍රශ්න පත්‍ර", "සූත්‍ර/වගු")

  val filteredList = remember(searchQuery, filterType, savedBookmarks.size) {
    savedBookmarks.filter { item ->
      val matchesSearch = item.title.contains(searchQuery, ignoreCase = true) || item.subject.contains(searchQuery, ignoreCase = true)
      val matchesType = when (filterType) {
        "කෙටි සටහන්" -> item.type == "NOTE"
        "ප්‍රශ්න පත්‍ර" -> item.type == "PAPER"
        "සූත්‍ර/වගු" -> item.type == "FORMULA"
        else -> true
      }
      matchesSearch && matchesType
    }
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text("🔖 මගේ Bookmark & ප්‍රියතම සටහන්", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text("සුරැකි අධ්‍යයන අන්තර්ගතයන් (${savedBookmarks.size})", fontSize = 10.sp, color = Color(0xFFFDE68A))
          }
        },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF4338CA))
      )
    }
  ) { paddingValues ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFF8FAFC))
        .padding(paddingValues)
        .padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
      // SEARCH BAR
      item {
        OutlinedTextField(
          value = searchQuery,
          onValueChange = { searchQuery = it },
          placeholder = { Text("සටහන් නම හෝ විෂය සොයන්න...") },
          leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF4338CA)) },
          trailingIcon = {
            if (searchQuery.isNotEmpty()) {
              IconButton(onClick = { searchQuery = "" }) {
                Icon(Icons.Default.Close, contentDescription = "Clear")
              }
            }
          },
          shape = RoundedCornerShape(14.dp),
          singleLine = true,
          modifier = Modifier.fillMaxWidth()
        )
      }

      // TYPE FILTER CHIPS
      item {
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
          items(filterTypes) { type ->
            FilterChip(
              selected = filterType == type,
              onClick = { filterType = type },
              label = { Text(type, fontSize = 11.sp, fontWeight = FontWeight.Bold) },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = Color(0xFF4338CA),
                selectedLabelColor = Color.White
              )
            )
          }
        }
      }

      if (filteredList.isEmpty()) {
        item {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 40.dp),
            contentAlignment = Alignment.Center
          ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
              Text("📂", fontSize = 42.sp)
              Spacer(modifier = Modifier.height(10.dp))
              Text("තවමත් සටහන් Bookmark කර නොමැත.", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = Color(0xFF64748B))
              Text("කෙටි සටහන් හෝ ප්‍රශ්න පත්‍රවල ඇති 🔖 ලකුණ ඔබා මෙහි සුරකින්න.", fontSize = 11.sp, color = Color(0xFF94A3B8), textAlign = TextAlign.Center)
            }
          }
        }
      } else {
        items(filteredList) { item ->
          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                Box(
                  modifier = Modifier
                    .size(44.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                      when (item.type) {
                        "NOTE" -> Color(0xFFEFF6FF)
                        "PAPER" -> Color(0xFFFEF2F2)
                        else -> Color(0xFFF0FDF4)
                      }
                    ),
                  contentAlignment = Alignment.Center
                ) {
                  Icon(
                    imageVector = when (item.type) {
                      "NOTE" -> Icons.Default.MenuBook
                      "PAPER" -> Icons.Default.Description
                      else -> Icons.Default.Calculate
                    },
                    contentDescription = item.type,
                    tint = when (item.type) {
                      "NOTE" -> Color(0xFF2563EB)
                      "PAPER" -> Color(0xFFDC2626)
                      else -> Color(0xFF16A34A)
                    },
                    modifier = Modifier.size(24.dp)
                  )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                  Text(
                    text = item.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = Color(0xFF0F172A),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                  )
                  Spacer(modifier = Modifier.height(4.dp))
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                      shape = RoundedCornerShape(4.dp),
                      color = Color(0xFFF1F5F9)
                    ) {
                      Text(
                        text = "${item.subject} • ${item.grade} වසර",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF475569),
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                      )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                      text = "📅 ${item.savedDate}",
                      fontSize = 9.sp,
                      color = Color(0xFF94A3B8)
                    )
                  }
                }
              }

              Row(verticalAlignment = Alignment.CenterVertically) {
                if (item.pdfUri != null) {
                  Button(
                    onClick = { onOpenPdf(item.pdfUri, item.title) },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4338CA)),
                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                    modifier = Modifier.height(34.dp)
                  ) {
                    Icon(Icons.Default.PictureAsPdf, contentDescription = "Open", modifier = Modifier.size(14.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("බලන්න", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                  }
                }

                IconButton(
                  onClick = {
                    savedBookmarks.remove(item)
                    Toast.makeText(context, "Bookmark ඉවත් කරන ලදී", Toast.LENGTH_SHORT).show()
                  }
                ) {
                  Icon(Icons.Default.BookmarkRemove, contentDescription = "Remove", tint = Color(0xFFDC2626), modifier = Modifier.size(20.dp))
                }
              }
            }
          }
        }
      }

      item {
        Spacer(modifier = Modifier.height(30.dp))
      }
    }
  }
}
