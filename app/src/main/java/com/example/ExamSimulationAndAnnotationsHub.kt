package com.example

import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.ui.theme.*
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

// ==============================================================================
// 1. LIVE MOCK EXAM HALL SIMULATION WITH OMR BUBBLE SHEET (සැබෑ විභාග ශාලා අනුකරණය)
// ==============================================================================

data class MockExamQuestion(
  val id: Int,
  val questionText: String,
  val options: List<String>,
  val correctOption: Int, // 1, 2, 3, 4
  val explanation: String,
  val topicName: String
)

data class MockExamPaper(
  val id: String,
  val titleSinhala: String,
  val subject: String,
  val grade: String,
  val term: Int = 1,
  val paperNumber: Int = 1,
  val durationMinutes: Int = 60,
  val totalQuestions: Int = 60,
  val syllabusCoverageSummary: String = "",
  val questions: List<MockExamQuestion>,
  val pdfUri: String? = null
)

object MockExamRepository {
  fun getAvailableMockExams(grade: String, term: Int = 1, subject: String = "විද්‍යාව"): List<MockExamPaper> {
    return MockExamDataBank.getPapersForTermAndSubject(grade, term, subject)
  }

  fun getAvailableMockExams(grade: String): List<MockExamPaper> {
    return MockExamDataBank.getPapersForTermAndSubject(grade, 1, "විද්‍යාව")
  }
}

data class LiveExamSubjectInfo(
  val subjectName: String,
  val subjectEnglish: String,
  val icon: String,
  val color: Color,
  val badge: String,
  val papersCountDesc: String,
  val syllabusSummaryBrief: String
)

val liveExamSubjectsList = listOf(
  LiveExamSubjectInfo(
    subjectName = "විද්‍යාව",
    subjectEnglish = "Science",
    icon = "🔬",
    color = Color(0xFF0EA5E9),
    badge = "ප්‍රශ්න පත්‍ර 30",
    papersCountDesc = "වාරයකට පත්‍ර 30 • ප්‍රශ්න 60 බැගින්",
    syllabusSummaryBrief = "ජීව විද්‍යාව, රසායනික හා භෞතික විද්‍යා සංකල්ප"
  ),
  LiveExamSubjectInfo(
    subjectName = "ගණිතය",
    subjectEnglish = "Mathematics",
    icon = "📐",
    color = Color(0xFFEAB308),
    badge = "ප්‍රශ්න පත්‍ර 30",
    papersCountDesc = "වාරයකට පත්‍ර 30 • ප්‍රශ්න 60 බැගින්",
    syllabusSummaryBrief = "වීජ ගණිතය, ජ්‍යාමිතිය, ත්‍රිකෝණමිතිය, සංඛ්‍යානය"
  ),
  LiveExamSubjectInfo(
    subjectName = "ඉතිහාසය",
    subjectEnglish = "History",
    icon = "🏛️",
    color = Color(0xFF10B981),
    badge = "ප්‍රශ්න පත්‍ර 30",
    papersCountDesc = "වාරයකට පත්‍ර 30 • ප්‍රශ්න 60 බැගින්",
    syllabusSummaryBrief = "ලංකා හා ලෝක ඉතිහාසය, සිතියම් ලකුණු කිරීම්"
  ),
  LiveExamSubjectInfo(
    subjectName = "සිංහල",
    subjectEnglish = "Sinhala",
    icon = "📖",
    color = Color(0xFFEC4899),
    badge = "ප්‍රශ්න පත්‍ර 30",
    papersCountDesc = "වාරයකට පත්‍ර 30 • ප්‍රශ්න 60 බැගින්",
    syllabusSummaryBrief = "භාෂාව, ව්‍යාකරණ, සාහිත්‍යය හා රසවින්දනය"
  ),
  LiveExamSubjectInfo(
    subjectName = "ඉංග්‍රීසි",
    subjectEnglish = "English",
    icon = "🇬🇧",
    color = Color(0xFF8B5CF6),
    badge = "ප්‍රශ්න පත්‍ර 30",
    papersCountDesc = "වාරයකට පත්‍ර 30 • ප්‍රශ්න 60 බැගින්",
    syllabusSummaryBrief = "Grammar, Reading, Vocabulary & Writing Skills"
  ),
  LiveExamSubjectInfo(
    subjectName = "බුද්ධ ධර්මය",
    subjectEnglish = "Buddhism",
    icon = "☸️",
    color = Color(0xFFF97316),
    badge = "ප්‍රශ්න පත්‍ර 30",
    papersCountDesc = "වාරයකට පත්‍ර 30 • ප්‍රශ්න 60 බැගින්",
    syllabusSummaryBrief = "බුද්ධ චරිතය, ධර්ම කරුණු, ශාසන ඉතිහාසය, සමාජ දර්ශනය"
  ),
  LiveExamSubjectInfo(
    subjectName = "භූගෝල විද්‍යාව",
    subjectEnglish = "Geography",
    icon = "🌍",
    color = Color(0xFF059669),
    badge = "ප්‍රශ්න පත්‍ර 30",
    papersCountDesc = "වාරයකට පත්‍ර 30 • ප්‍රශ්න 60 බැගින්",
    syllabusSummaryBrief = "පෘථිවිය, ශ්‍රී ලංකාවේ පිහිටීම, දේශගුණය හා සම්පත්"
  ),
  LiveExamSubjectInfo(
    subjectName = "පුරවැසි අධ්‍යාපනය",
    subjectEnglish = "Civics",
    icon = "🤝",
    color = Color(0xFFDC2626),
    badge = "ප්‍රශ්න පත්‍ර 30",
    papersCountDesc = "වාරයකට පත්‍ර 30 • ප්‍රශ්න 60 බැගින්",
    syllabusSummaryBrief = "ප්‍රජාතන්ත්‍රවාදය, පාලන ව්‍යුහය හා මානව හිමිකම්"
  ),
  LiveExamSubjectInfo(
    subjectName = "තොරතුරු හා සන්නිවේදන තාක්ෂණය",
    subjectEnglish = "ICT",
    icon = "💻",
    color = Color(0xFF2563EB),
    badge = "ප්‍රශ්න පත්‍ර 30",
    papersCountDesc = "වාරයකට පත්‍ර 30 • ප්‍රශ්න 60 බැගින්",
    syllabusSummaryBrief = "සංඛ්‍යා පද්ධති, OS, මෘදුකාංග හා ක්‍රමලේඛන"
  ),
  LiveExamSubjectInfo(
    subjectName = "ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය",
    subjectEnglish = "Accounting",
    icon = "📊",
    color = Color(0xFF7C3AED),
    badge = "ප්‍රශ්න පත්‍ර 30",
    papersCountDesc = "වාරයකට පත්‍ර 30 • ප්‍රශ්න 60 බැගින්",
    syllabusSummaryBrief = "ව්‍යාපාර පසුබිම, ද්විත්ව සටහන් හා මූල්‍ය ප්‍රකාශන"
  ),
  LiveExamSubjectInfo(
    subjectName = "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය",
    subjectEnglish = "Health",
    icon = "🍎",
    color = Color(0xFFEA580C),
    badge = "ප්‍රශ්න පත්‍ර 30",
    papersCountDesc = "වාරයකට පත්‍ර 30 • ප්‍රශ්න 60 බැගින්",
    syllabusSummaryBrief = "පෝෂණය, රෝග වැළැක්වීම හා ශාරීරික යෝග්‍යතාවය"
  ),
  LiveExamSubjectInfo(
    subjectName = "කෘෂි විද්‍යාව",
    subjectEnglish = "Agri",
    icon = "🌾",
    color = Color(0xFF10B981),
    badge = "ප්‍රශ්න පත්‍ර 30",
    papersCountDesc = "වාරයකට පත්‍ර 30 • ප්‍රශ්න 60 බැගින්",
    syllabusSummaryBrief = "භෝග වගාව, පාංශු පාලනය, සත්ත්ව පාලනය"
  ),
  LiveExamSubjectInfo(
    subjectName = "චිත්‍ර කලාව",
    subjectEnglish = "Art",
    icon = "🎨",
    color = Color(0xFFF43F5E),
    badge = "ප්‍රශ්න පත්‍ර 30",
    papersCountDesc = "වාරයකට පත්‍ර 30 • ප්‍රශ්න 60 බැගින්",
    syllabusSummaryBrief = "කලා ඉතිහාසය, වර්ණ සංයෝජනය, චිත්‍ර කලාව"
  ),
  LiveExamSubjectInfo(
    subjectName = "සංගීතය",
    subjectEnglish = "Music",
    icon = "🎸",
    color = Color(0xFF8B5CF6),
    badge = "ප්‍රශ්න පත්‍ර 30",
    papersCountDesc = "වාරයකට පත්‍ර 30 • ප්‍රශ්න 60 බැගින්",
    syllabusSummaryBrief = "රාග ධාරී සංගීතය, තාල ක්‍රම, ගායන ශිල්පය"
  ),
  LiveExamSubjectInfo(
    subjectName = "නර්තනය",
    subjectEnglish = "Dancing",
    icon = "💃",
    color = Color(0xFFEC4899),
    badge = "ප්‍රශ්න පත්‍ර 30",
    papersCountDesc = "වාරයකට පත්‍ර 30 • ප්‍රශ්න 60 බැගින්",
    syllabusSummaryBrief = "උඩරට හා පහතරට නර්තන, බෙර වාදනය, රංග කලාව"
  )
)

@Composable
fun LiveExamSubjectMiniCard(
  category: LiveExamSubjectInfo,
  onClick: () -> Unit
) {
  Card(
    onClick = onClick,
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
    border = BorderStroke(1.2.dp, category.color.copy(alpha = 0.55f)),
    modifier = Modifier
      .fillMaxWidth()
      .height(132.dp)
      .testTag("live_exam_subject_${category.subjectName}")
  ) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(12.dp),
      verticalArrangement = Arrangement.SpaceBetween
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Box(
          modifier = Modifier
            .size(36.dp)
            .clip(CircleShape)
            .background(category.color.copy(alpha = 0.22f)),
          contentAlignment = Alignment.Center
        ) {
          Text(text = category.icon, fontSize = 18.sp)
        }
        Surface(
          shape = RoundedCornerShape(10.dp),
          color = category.color.copy(alpha = 0.2f)
        ) {
          Text(
            text = category.badge,
            fontSize = 9.5.sp,
            fontWeight = FontWeight.Bold,
            color = category.color,
            modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
          )
        }
      }

      Column {
        Text(
          text = category.subjectName,
          fontSize = 13.5.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )
        Text(
          text = category.subjectEnglish,
          fontSize = 10.sp,
          color = category.color,
          fontWeight = FontWeight.SemiBold,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )
      }

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = category.papersCountDesc,
          fontSize = 8.5.sp,
          color = Color(0xFF94A3B8),
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "හෝල් →",
          fontSize = 9.5.sp,
          color = category.color,
          fontWeight = FontWeight.Bold
        )
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LiveMockExamHallScreen(
  grade: String,
  onBack: () -> Unit,
  onOpenPdfModal: (url: String, title: String) -> Unit = { _, _ -> },
  onOpenMistakeNotebook: () -> Unit = {}
) {
  val availableGrades = listOf("11", "10")
  var selectedGrade by remember(grade) {
    val clean = if (grade.contains("10")) "10" else "11"
    mutableStateOf(clean)
  }

  var selectedTerm by remember { mutableStateOf(1) } // 1, 2, 3
  var activeSubject by remember { mutableStateOf<String?>(null) } // null = Show colorful mini-cards grid
  var subjectSearchQuery by remember { mutableStateOf("") }
  var searchQuery by remember { mutableStateOf("") }
  var selectedRangeFilter by remember { mutableStateOf("ALL") } // "ALL", "1-10", "11-20", "21-30"

  var selectedExam by remember { mutableStateOf<MockExamPaper?>(null) }

  // Intercept back key when inside a subject to go back to subject cards
  BackHandler(enabled = (selectedExam == null && activeSubject != null)) {
    activeSubject = null
    searchQuery = ""
    selectedRangeFilter = "ALL"
  }

  val mockExams = remember(selectedGrade, selectedTerm, activeSubject) {
    if (activeSubject != null) {
      MockExamDataBank.getPapersForTermAndSubject(selectedGrade, selectedTerm, activeSubject!!)
    } else {
      emptyList()
    }
  }

  val filteredExams = remember(mockExams, searchQuery, selectedRangeFilter) {
    mockExams.filter { exam ->
      val matchesSearch = if (searchQuery.isBlank()) true else {
        exam.paperNumber.toString() == searchQuery.trim() ||
        String.format("%02d", exam.paperNumber).contains(searchQuery.trim()) ||
        exam.titleSinhala.contains(searchQuery.trim(), ignoreCase = true) ||
        MockExamDataBank.PAPER_FOCUS_TITLES.getOrElse(exam.paperNumber - 1) { "" }.contains(searchQuery.trim(), ignoreCase = true)
      }
      val matchesRange = when (selectedRangeFilter) {
        "1-10" -> exam.paperNumber in 1..10
        "11-20" -> exam.paperNumber in 11..20
        "21-30" -> exam.paperNumber in 21..30
        else -> true
      }
      matchesSearch && matchesRange
    }
  }

  val syllabusSummary = remember(activeSubject, selectedTerm) {
    if (activeSubject != null) {
      MockExamDataBank.getSyllabusSummary(activeSubject!!, selectedTerm)
    } else ""
  }

  val displayedSubjects = remember(subjectSearchQuery) {
    if (subjectSearchQuery.isBlank()) liveExamSubjectsList else {
      liveExamSubjectsList.filter {
        it.subjectName.contains(subjectSearchQuery.trim(), ignoreCase = true) ||
        it.subjectEnglish.contains(subjectSearchQuery.trim(), ignoreCase = true)
      }
    }
  }

  if (selectedExam == null) {
    // EXAM LOBBY SCREEN
    Scaffold(
      topBar = {
        TopAppBar(
          title = {
            Column {
              if (activeSubject == null) {
                Text("⏱️ සැබෑ විභාග ශාලා අනුකරණය", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)
                Text("Live Mock Exam Hall • විෂය තෝරන්න", fontSize = 11.sp, color = Color(0xFF94A3B8))
              } else {
                Text("⏱️ $activeSubject • සජීවී විභාග ශාලාව", fontWeight = FontWeight.Bold, fontSize = 15.sp, maxLines = 1, color = Color.White)
                Text("$selectedGrade ශ්‍රේණිය • $selectedTerm වන වාරය • ප්‍රශ්න පත්‍ර 30", fontSize = 11.sp, color = Color(0xFF94A3B8))
              }
            }
          },
          navigationIcon = {
            IconButton(onClick = {
              if (activeSubject != null) {
                activeSubject = null
                searchQuery = ""
                selectedRangeFilter = "ALL"
              } else {
                onBack()
              }
            }) {
              Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
          },
          actions = {
            if (activeSubject != null) {
              TextButton(
                onClick = {
                  activeSubject = null
                  searchQuery = ""
                  selectedRangeFilter = "ALL"
                },
                modifier = Modifier.padding(end = 2.dp)
              ) {
                Icon(Icons.Default.GridView, contentDescription = null, tint = Color(0xFF38BDF8), modifier = Modifier.size(15.dp))
                Spacer(modifier = Modifier.width(3.dp))
                Text("විෂයන්", color = Color(0xFF38BDF8), fontSize = 11.sp, fontWeight = FontWeight.Bold)
              }
            }
            TextButton(
              onClick = onOpenMistakeNotebook,
              modifier = Modifier.padding(end = 4.dp)
            ) {
              Icon(Icons.Default.WarningAmber, contentDescription = "Mistakes", tint = Color(0xFFF87171), modifier = Modifier.size(16.dp))
              Spacer(modifier = Modifier.width(4.dp))
              Text("Mistake Bank", color = Color(0xFFF87171), fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
          },
          colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF0F172A),
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
          )
        )
      }
    ) { padding ->
      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
          .padding(padding)
          .background(Color(0xFF090D16))
          .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 8.dp, bottom = 120.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        if (activeSubject == null) {
          // =========================================================================
          // INITIAL SCREEN: COLORFUL COMPACT SUBJECT CARDS (අන්තර්ගතයන් සැඟවී ඇත)
          // =========================================================================

          // Ultra-Compact Hero Banner
          item {
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
              border = BorderStroke(1.dp, Color(0xFF334155)),
              elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 10.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Row(
                  verticalAlignment = Alignment.CenterVertically,
                  modifier = Modifier.weight(1f)
                ) {
                  Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFFEF4444)
                  ) {
                    Text(
                      text = "OMR LIVE",
                      color = Color.White,
                      fontSize = 9.sp,
                      fontWeight = FontWeight.Black,
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                  }
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = "$selectedGrade ශ්‍රේණිය • $selectedTerm වන වාරය (ආදර්ශ පත්‍ර 30 • ප්‍රශ්න 60)",
                    color = Color.White,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                }
                Text("🔥 LIVE", color = Color(0xFFFDE047), fontSize = 10.sp, fontWeight = FontWeight.Bold)
              }
            }
          }

          // Ultra-Compact Unified Grade & Term Filter Row
          item {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(6.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              // Grade Toggle Chip
              Surface(
                onClick = { selectedGrade = if (selectedGrade == "11") "10" else "11" },
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF1E293B),
                border = BorderStroke(1.dp, Color(0xFF38BDF8))
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(text = "ශ්‍රේණිය: ", fontSize = 10.sp, color = Color(0xFF94A3B8))
                  Text(text = "$selectedGrade ⇄", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                }
              }

              // Term Tabs (1, 2, 3)
              Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
              ) {
                listOf(
                  Pair(1, "1 වාරය"),
                  Pair(2, "2 වාරය"),
                  Pair(3, "3 වාරය")
                ).forEach { (tNum, tLabel) ->
                  val isSelected = selectedTerm == tNum
                  Surface(
                    onClick = { selectedTerm = tNum },
                    shape = RoundedCornerShape(8.dp),
                    color = if (isSelected) Color(0xFF2563EB) else Color(0xFF1E293B),
                    border = BorderStroke(1.dp, if (isSelected) Color(0xFF38BDF8) else Color(0xFF334155)),
                    modifier = Modifier.weight(1f)
                  ) {
                    Text(
                      text = tLabel,
                      color = if (isSelected) Color.White else Color(0xFFCBD5E1),
                      fontWeight = FontWeight.Bold,
                      fontSize = 10.sp,
                      textAlign = TextAlign.Center,
                      modifier = Modifier.padding(vertical = 5.dp)
                    )
                  }
                }
              }
            }
          }

          // Ultra-Compact Search Bar
          item {
            OutlinedTextField(
              value = subjectSearchQuery,
              onValueChange = { subjectSearchQuery = it },
              placeholder = { Text("විෂය සොයන්න (Search Subject)...", fontSize = 11.sp, color = Color(0xFF94A3B8)) },
              leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", modifier = Modifier.size(16.dp), tint = Color(0xFF94A3B8)) },
              trailingIcon = {
                if (subjectSearchQuery.isNotEmpty()) {
                  IconButton(
                    onClick = { subjectSearchQuery = "" },
                    modifier = Modifier.size(24.dp)
                  ) {
                    Icon(Icons.Default.Clear, contentDescription = "Clear", modifier = Modifier.size(14.dp), tint = Color(0xFF94A3B8))
                  }
                }
              },
              singleLine = true,
              shape = RoundedCornerShape(10.dp),
              colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF1E293B),
                unfocusedContainerColor = Color(0xFF1E293B),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedBorderColor = Color(0xFF38BDF8),
                unfocusedBorderColor = Color(0xFF334155)
              ),
              modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 38.dp)
            )
          }

          // Ultra-Low-Profile Section Title Bar (උස හැකිතාක් අඩු කළ බාර් එක)
          item {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 1.dp),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = "🎨 විෂය තෝරා සජීවී විභාග ශාලාවට පිවිසෙන්න:",
                fontWeight = FontWeight.Bold,
                fontSize = 11.5.sp,
                color = Color.White
              )
              Surface(
                shape = RoundedCornerShape(6.dp),
                color = Color(0xFF1E293B),
                border = BorderStroke(0.8.dp, Color(0xFF334155))
              ) {
                Text(
                  text = "විෂයන් 15",
                  color = Color(0xFF60A5FA),
                  fontWeight = FontWeight.Bold,
                  fontSize = 9.sp,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }
            }
          }

          // 2-Column Grid of Colorful Subject Cards

          if (displayedSubjects.isEmpty()) {
            item {
              Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
                border = BorderStroke(1.dp, Color(0xFF334155)),
                modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp)
              ) {
                Column(
                  modifier = Modifier.padding(20.dp).fillMaxWidth(),
                  horizontalAlignment = Alignment.CenterHorizontally
                ) {
                  Icon(Icons.Default.SearchOff, contentDescription = null, tint = Color(0xFF94A3B8), modifier = Modifier.size(32.dp))
                  Spacer(modifier = Modifier.height(6.dp))
                  Text("සොයන ලද විෂය හමු නොවීය.", fontSize = 12.sp, color = Color(0xFFCBD5E1))
                  Spacer(modifier = Modifier.height(6.dp))
                  OutlinedButton(
                    onClick = { subjectSearchQuery = "" },
                    border = BorderStroke(1.dp, Color(0xFF38BDF8))
                  ) {
                    Text("සියලු විෂයන් 15 පෙන්වන්න", fontSize = 11.sp, color = Color(0xFF38BDF8))
                  }
                }
              }
            }
          } else {
            items(displayedSubjects.chunked(2)) { pair ->
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
              ) {
                pair.forEach { subjInfo ->
                  Box(modifier = Modifier.weight(1f)) {
                    LiveExamSubjectMiniCard(
                      category = subjInfo,
                      onClick = {
                        activeSubject = subjInfo.subjectName
                        searchQuery = ""
                        selectedRangeFilter = "ALL"
                      }
                    )
                  }
                }
                if (pair.size == 1) {
                  Spacer(modifier = Modifier.weight(1f))
                }
              }
            }
          }
        } else {
          // =========================================================================
          // SUBJECT CONTENTS VIEW: SHOWN ONLY AFTER A SUBJECT IS CLICKED
          // =========================================================================

          // 1. Horizontal Subject Selector Bar (විෂය තෝරාගන්න තීරුව)
          item {
            Column {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = "විෂය මාරු කරන්න (Change Subject):",
                  fontWeight = FontWeight.Bold,
                  fontSize = 12.sp,
                  color = Color.White
                )
                TextButton(
                  onClick = {
                    activeSubject = null
                    searchQuery = ""
                    selectedRangeFilter = "ALL"
                  },
                  contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp)
                ) {
                  Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, modifier = Modifier.size(13.dp), tint = Color(0xFF38BDF8))
                  Spacer(modifier = Modifier.width(3.dp))
                  Text("සියලු විෂයන් (Cards)", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                }
              }

              Spacer(modifier = Modifier.height(4.dp))

              LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // Button to go back to all colorful cards
                item {
                  Surface(
                    onClick = {
                      activeSubject = null
                      searchQuery = ""
                      selectedRangeFilter = "ALL"
                    },
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFF1E293B),
                    border = BorderStroke(1.dp, Color(0xFF334155))
                  ) {
                    Row(
                      modifier = Modifier.padding(horizontal = 10.dp, vertical = 7.dp),
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Icon(Icons.Default.GridView, contentDescription = null, modifier = Modifier.size(14.dp), tint = Color.White)
                      Spacer(modifier = Modifier.width(4.dp))
                      Text("සියලු විෂයන්", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    }
                  }
                }

                // Chips for each subject
                items(liveExamSubjectsList) { subjInfo ->
                  val isCurrent = activeSubject == subjInfo.subjectName
                  Surface(
                    onClick = {
                      activeSubject = subjInfo.subjectName
                      searchQuery = ""
                      selectedRangeFilter = "ALL"
                    },
                    shape = RoundedCornerShape(12.dp),
                    color = if (isCurrent) subjInfo.color else Color(0xFF1E293B),
                    border = BorderStroke(1.2.dp, if (isCurrent) subjInfo.color else Color(0xFF334155))
                  ) {
                    Row(
                      modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp),
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Text(subjInfo.icon, fontSize = 13.sp)
                      Spacer(modifier = Modifier.width(6.dp))
                      Text(
                        text = subjInfo.subjectName,
                        color = if (isCurrent) Color.White else Color(0xFFCBD5E1),
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.5.sp
                      )
                    }
                  }
                }
              }
            }
          }

          // 2. Grade & Term Switcher Row
          item {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(8.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              // Grade Chip
              Surface(
                shape = RoundedCornerShape(10.dp),
                color = Color(0xFF1E293B),
                border = BorderStroke(1.dp, Color(0xFF38BDF8)),
                modifier = Modifier.weight(1.1f)
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.Center
                ) {
                  Text("ශ්‍රේණිය: ", fontSize = 10.5.sp, color = Color(0xFF94A3B8))
                  Text("$selectedGrade", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
                  Spacer(modifier = Modifier.width(6.dp))
                  TextButton(
                    onClick = { selectedGrade = if (selectedGrade == "11") "10" else "11" },
                    contentPadding = PaddingValues(0.dp)
                  ) {
                    Text("මාරු කරන්න ⇄", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                  }
                }
              }

              // Term Selector Chips
              listOf(1, 2, 3).forEach { t ->
                val isTermSelected = selectedTerm == t
                Surface(
                  onClick = { selectedTerm = t },
                  shape = RoundedCornerShape(10.dp),
                  color = Color(0xFF1E293B),
                  border = BorderStroke(1.dp, if (isTermSelected) Color(0xFF38BDF8) else Color(0xFF334155))
                ) {
                  Text(
                    text = "$t වන වාරය",
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isTermSelected) Color(0xFFFDE047) else Color(0xFFCBD5E1),
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
                  )
                }
              }
            }
          }

          // 3. Syllabus Coverage Info Card
          item {
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
              border = BorderStroke(1.dp, Color(0xFF334155)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 7.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Icon(Icons.Default.MenuBook, contentDescription = "Syllabus", tint = Color(0xFF38BDF8), modifier = Modifier.size(15.dp))
                  Spacer(modifier = Modifier.width(5.dp))
                  Text(
                    text = "🎯 $selectedTerm වන වාර විෂය නිර්දේශ ආවරණය ($activeSubject):",
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.5.sp,
                    color = Color.White
                  )
                }
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                  text = syllabusSummary,
                  fontSize = 10.5.sp,
                  color = Color(0xFFCBD5E1),
                  lineHeight = 15.sp,
                  maxLines = 2,
                  overflow = TextOverflow.Ellipsis
                )
              }
            }
          }

          // 4. Papers Header & Filters
          item {
            Column {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = "$activeSubject සජීවී ආදර්ශ ප්‍රශ්න පත්‍ර:",
                  fontWeight = FontWeight.Bold,
                  fontSize = 12.5.sp,
                  color = Color.White
                )
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = Color(0xFF1E293B),
                  border = BorderStroke(1.dp, Color(0xFF334155))
                ) {
                  Text(
                    text = "ප්‍රශ්න පත්‍ර 30 • 60Q",
                    color = Color(0xFF4ADE80),
                    fontWeight = FontWeight.Bold,
                    fontSize = 9.5.sp,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                  )
                }
              }

              Spacer(modifier = Modifier.height(4.dp))

              // Search Bar
              OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("ප්‍රශ්න පත්‍ර අංකය (1 - 30) සොයන්න...", fontSize = 11.sp) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", modifier = Modifier.size(16.dp), tint = NeutralMedium) },
                trailingIcon = {
                  if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { searchQuery = "" }, modifier = Modifier.size(24.dp)) {
                      Icon(Icons.Default.Clear, contentDescription = "Clear", modifier = Modifier.size(14.dp))
                    }
                  }
                },
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                  focusedContainerColor = Color.White,
                  unfocusedContainerColor = Color.White,
                  focusedBorderColor = BluePrimary,
                  unfocusedBorderColor = Color(0xFFCBD5E1)
                ),
                modifier = Modifier.fillMaxWidth().defaultMinSize(minHeight = 36.dp)
              )

              Spacer(modifier = Modifier.height(8.dp))

              // Range Filter Chips (All, 1-10, 11-20, 21-30)
              LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                val filterOptions = listOf(
                  "ALL" to "සියල්ල (30)",
                  "1-10" to "පත්‍ර 01 - 10",
                  "11-20" to "පත්‍ර 11 - 20",
                  "21-30" to "පත්‍ර 21 - 30"
                )
                items(filterOptions) { (key, label) ->
                  val isSelected = selectedRangeFilter == key
                  Surface(
                    onClick = { selectedRangeFilter = key },
                    shape = RoundedCornerShape(8.dp),
                    color = if (isSelected) Color(0xFF0F172A) else Color.White,
                    border = BorderStroke(1.dp, if (isSelected) Color(0xFF0F172A) else Color(0xFFCBD5E1))
                  ) {
                    Text(
                      text = label,
                      fontSize = 11.sp,
                      fontWeight = FontWeight.Bold,
                      color = if (isSelected) Color(0xFFFDE047) else NeutralDark,
                      modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                    )
                  }
                }
              }
            }
          }

          // 5. Exam Papers
          if (filteredExams.isEmpty()) {
            item {
              Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
              ) {
                Column(
                  modifier = Modifier.padding(24.dp).fillMaxWidth(),
                  horizontalAlignment = Alignment.CenterHorizontally
                ) {
                  Icon(Icons.Default.SearchOff, contentDescription = null, tint = NeutralMedium, modifier = Modifier.size(36.dp))
                  Spacer(modifier = Modifier.height(8.dp))
                  Text("සොයන ලද අංකයට හෝ නමට අදාළ ප්‍රශ්න පත්‍රයක් හමු නොවීය.", fontSize = 12.sp, color = NeutralMedium)
                  Spacer(modifier = Modifier.height(8.dp))
                  OutlinedButton(onClick = { searchQuery = ""; selectedRangeFilter = "ALL" }) {
                    Text("සියලු ප්‍රශ්න පත්‍ර 30 පෙන්වන්න", fontSize = 11.sp)
                  }
                }
              }
            }
          } else {
            items(filteredExams) { exam ->
              LiveMockExamPaperCard(
                exam = exam,
                onOpenPdf = { exam.pdfUri?.let { onOpenPdfModal(it, exam.titleSinhala) } },
                onStartExam = { selectedExam = exam }
              )
            }
          }
        }
      }
    }
  } else {
    // ACTIVE EXAM SESSION / GRADING VIEW
    ActiveMockExamSession(
      exam = selectedExam!!,
      onExit = { selectedExam = null },
      onOpenMistakeNotebook = onOpenMistakeNotebook
    )
  }
}

@Composable
fun LiveMockExamPaperCard(
  exam: MockExamPaper,
  onOpenPdf: () -> Unit,
  onStartExam: () -> Unit
) {
  var isPreviewOpen by remember { mutableStateOf(false) }
  val focusTitle = MockExamDataBank.PAPER_FOCUS_TITLES.getOrElse(exam.paperNumber - 1) { "විෂය නිර්දේශ ආදර්ශ පත්‍රය" }

  Card(
    shape = RoundedCornerShape(12.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
    modifier = Modifier.fillMaxWidth()
  ) {
    Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 7.dp)) {
      // 1. Compact Top Info Row: Paper No badge, Term, Time
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Surface(
            shape = RoundedCornerShape(6.dp),
            color = Color(0xFF0F172A)
          ) {
            Text(
              text = "ප්‍රශ්න පත්‍රය ${String.format("%02d", exam.paperNumber)} / 30",
              fontSize = 10.sp,
              fontWeight = FontWeight.Black,
              color = Color(0xFFFDE047),
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(5.dp))
          Surface(
            shape = RoundedCornerShape(6.dp),
            color = when (exam.subject) {
              "විද්‍යාව" -> Color(0xFFE8F5E9)
              "ගණිතය" -> Color(0xFFE3F2FD)
              else -> Color(0xFFF3E8FF)
            }
          ) {
            Text(
              text = "${exam.term} වාරය",
              fontSize = 9.5.sp,
              fontWeight = FontWeight.Bold,
              color = when (exam.subject) {
                "විද්‍යාව" -> Color(0xFF1B5E20)
                "ගණිතය" -> Color(0xFF0D47A1)
                else -> Color(0xFF6B21A8)
              },
              modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(4.dp))
          Text(
            text = "• 60Q OMR",
            fontSize = 9.5.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF64748B)
          )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
          Icon(Icons.Default.Timer, contentDescription = "Time", tint = Color(0xFFD97706), modifier = Modifier.size(13.dp))
          Spacer(modifier = Modifier.width(3.dp))
          Text("${exam.durationMinutes} min", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFD97706))
        }
      }

      Spacer(modifier = Modifier.height(3.dp))

      // 2. Title & Benchmark Goal
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column(modifier = Modifier.weight(1f)) {
          Text(
            text = exam.titleSinhala,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = NeutralDark,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
          Text(
            text = "ඉලක්කය: $focusTitle",
            fontSize = 9.5.sp,
            color = Color(0xFF64748B),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
        }
      }

      Spacer(modifier = Modifier.height(4.dp))

      // 3. Compact Single-line Indicators + Preview Trigger
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = "🎯 60 MCQ • ⭕ OMR Sheet • 💡 විවරණ",
          fontSize = 9.sp,
          color = Color(0xFF475569),
          fontWeight = FontWeight.SemiBold
        )
        Row(
          modifier = Modifier
            .clickable { isPreviewOpen = !isPreviewOpen }
            .padding(vertical = 2.dp, horizontal = 4.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Icon(
            if (isPreviewOpen) Icons.Default.VisibilityOff else Icons.Default.Visibility,
            contentDescription = "Preview",
            tint = Color(0xFF2563EB),
            modifier = Modifier.size(12.dp)
          )
          Spacer(modifier = Modifier.width(3.dp))
          Text(
            text = if (isPreviewOpen) "සඟවන්න" else "පෙරදසුන (3Q)",
            fontSize = 9.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2563EB)
          )
        }
      }

      // Expandable Question Preview (only when open)
      if (isPreviewOpen) {
        Spacer(modifier = Modifier.height(4.dp))
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF8FAFC), RoundedCornerShape(6.dp))
            .padding(6.dp),
          verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
          exam.questions.take(3).forEach { q ->
            Surface(
              shape = RoundedCornerShape(4.dp),
              color = Color.White,
              border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(6.dp)) {
                Text(
                  text = q.questionText,
                  fontSize = 10.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = NeutralDark,
                  lineHeight = 15.sp
                )
                Spacer(modifier = Modifier.height(2.dp))
                q.options.take(2).forEachIndexed { idx, opt ->
                  Text(
                    text = "(${idx + 1}) $opt",
                    fontSize = 9.5.sp,
                    color = Color(0xFF475569)
                  )
                }
              }
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(5.dp))

      // 4. Compact Action Buttons Row
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        if (exam.pdfUri != null) {
          OutlinedButton(
            onClick = onOpenPdf,
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp),
            modifier = Modifier
              .weight(1f)
              .defaultMinSize(minHeight = 32.dp)
          ) {
            Icon(Icons.Default.PictureAsPdf, contentDescription = "PDF", modifier = Modifier.size(14.dp))
            Spacer(modifier = Modifier.width(3.dp))
            Text("ප්‍රශ්න පත්‍රය (PDF)", fontSize = 10.sp)
          }
        }

        Button(
          onClick = onStartExam,
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB)),
          shape = RoundedCornerShape(8.dp),
          contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
          modifier = Modifier
            .weight(1.3f)
            .defaultMinSize(minHeight = 32.dp)
            .testTag("start_mock_exam_${exam.id}")
        ) {
          Icon(Icons.Default.PlayArrow, contentDescription = "Start", modifier = Modifier.size(15.dp))
          Spacer(modifier = Modifier.width(4.dp))
          Text("විභාගය අරඹන්න (60Q)", fontWeight = FontWeight.Bold, fontSize = 11.sp)
        }
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActiveMockExamSession(
  exam: MockExamPaper,
  onExit: () -> Unit,
  onOpenMistakeNotebook: () -> Unit = {}
) {
  val context = LocalContext.current
  val screenDims = rememberScreenDimensions()
  val isCompact = screenDims.isSmallWidth || screenDims.isShortHeight
  var remainingSeconds by remember { mutableStateOf(exam.durationMinutes * 60) }
  var isTimerRunning by remember { mutableStateOf(true) }
  var currentQuestionIndex by remember { mutableStateOf(0) }
  val answersMap = remember { mutableStateMapOf<Int, Int>() } // Question ID -> Selected Bubble (1..4)
  val flaggedQuestions = remember { mutableStateListOf<Int>() }
  var isExamSubmitted by remember { mutableStateOf(false) }
  var showConfirmSubmitDialog by remember { mutableStateOf(false) }
  var activeTab by remember { mutableStateOf(0) } // 0: ප්‍රශ්න විචාරය (Question View), 1: OMR Sheet Matrix
  var isFullScreenMode by remember { mutableStateOf(false) }
  var mistakesSavedToNotebook by remember { mutableStateOf(false) }

  // Auto-save wrong questions to Mistake Notebook upon exam submission
  LaunchedEffect(isExamSubmitted) {
    if (isExamSubmitted && !mistakesSavedToNotebook) {
      val wrongList = exam.questions.filter { answersMap[it.id] != it.correctOption }
      if (wrongList.isNotEmpty()) {
        val mistakeItems = wrongList.map { q ->
          MistakeItem(
            id = "exam_${exam.id}_q_${q.id}",
            subject = exam.subject,
            topic = q.topicName,
            grade = exam.grade,
            questionText = q.questionText,
            options = q.options,
            correctOptionIndex = q.correctOption - 1,
            explanation = q.explanation,
            userWrongAnswerIndex = (answersMap[q.id] ?: 0) - 1
          )
        }
        MistakeNotebookRepository.addMistakes(context, mistakeItems)
        mistakesSavedToNotebook = true
      }
    }
  }

  // Timer Effect
  LaunchedEffect(isTimerRunning, isExamSubmitted) {
    while (isTimerRunning && !isExamSubmitted && remainingSeconds > 0) {
      delay(1000L)
      remainingSeconds--
    }
    if (remainingSeconds == 0 && !isExamSubmitted) {
      isExamSubmitted = true
    }
  }

  val minutes = remainingSeconds / 60
  val seconds = remainingSeconds % 60
  val timeString = String.format("%02d:%02d", minutes, seconds)

  if (isExamSubmitted) {
    // ----------------------------------------------------
    // EXAM RESULTS & REVIEW SCREEN
    // ----------------------------------------------------
    val correctCount = exam.questions.count { answersMap[it.id] == it.correctOption }
    val totalCount = exam.questions.size
    val scorePercentage = ((correctCount.toFloat() / totalCount) * 100).toInt()
    val gradeStatus = when {
      scorePercentage >= 75 -> "A (විශිෂ්ට සාමාර්ථ්‍යයක්!)"
      scorePercentage >= 65 -> "B (ඉතා හොඳ සාමාර්ථ්‍යයක්)"
      scorePercentage >= 50 -> "C (සම්මාන සාමාර්ථ්‍යයක්)"
      scorePercentage >= 35 -> "S (සාමාන්‍ය සාමාර්ථ්‍යයක්)"
      else -> "W (නැවත උත්සාහ කරන්න)"
    }

    Scaffold(
      topBar = {
        TopAppBar(
          title = { Text("📊 විභාග ප්‍රතිඵල සහ විවරණය", fontWeight = FontWeight.Bold, fontSize = 16.sp) },
          navigationIcon = {
            IconButton(onClick = onExit) {
              Icon(Icons.Default.Close, contentDescription = "Close")
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
          .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
      ) {
        item {
          Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
              containerColor = if (scorePercentage >= 50) Color(0xFFF0FDF4) else Color(0xFFFEF2F2)
            ),
            border = BorderStroke(1.5.dp, if (scorePercentage >= 50) Color(0xFF86EFAC) else Color(0xFFFECACA)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
              Text(
                text = if (scorePercentage >= 75) "🎉 සුබ පැතුම්! විශිෂ්ට ජයග්‍රහණයක්!" else if (scorePercentage >= 50) "👏 සාර්ථකයි! දිගටම පුහුණු වන්න" else "💪 ධෛර්යයෙන් නැවත උත්සාහ කරන්න!",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = if (scorePercentage >= 50) Color(0xFF15803D) else Color(0xFFB91C1C)
              )

              Spacer(modifier = Modifier.height(10.dp))

              Text(
                text = "$scorePercentage%",
                fontSize = 44.sp,
                fontWeight = FontWeight.Black,
                color = if (scorePercentage >= 50) Color(0xFF15803D) else Color(0xFFB91C1C)
              )

              Text(
                text = "සාමාර්ථය: $gradeStatus",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = NeutralDark
              )

              Spacer(modifier = Modifier.height(10.dp))

              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
              ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                  Text("නිවැරදි පිළිතුරු", fontSize = 11.sp, color = NeutralMedium)
                  Text("✅ $correctCount / $totalCount", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color(0xFF15803D))
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                  Text("වැරදුණු පිළිතුරු", fontSize = 11.sp, color = NeutralMedium)
                  Text("❌ ${totalCount - correctCount}", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color(0xFFB91C1C))
                }
              }
            }
          }
        }

        val wrongQuestions = exam.questions.filter { answersMap[it.id] != it.correctOption }
        if (wrongQuestions.isNotEmpty()) {
          item {
            Card(
              shape = RoundedCornerShape(16.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF1F2)),
              border = BorderStroke(1.dp, Color(0xFFFECDD3)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(14.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Box(
                    modifier = Modifier
                      .size(32.dp)
                      .clip(CircleShape)
                      .background(Color(0xFFE11D48)),
                    contentAlignment = Alignment.Center
                  ) {
                    Text("⚠️", fontSize = 16.sp)
                  }
                  Spacer(modifier = Modifier.width(10.dp))
                  Column {
                    Text(
                      text = "වැරදුණු ප්‍රශ්න ${wrongQuestions.size}ක් Mistake Bank එකට සුරැකිණි",
                      fontWeight = FontWeight.Bold,
                      fontSize = 12.5.sp,
                      color = Color(0xFF9F1239)
                    )
                    Text(
                      text = "ඔබට මෙම ප්‍රශ්න පමණක් තෝරා නැවත පුහුණු විය හැක",
                      fontSize = 10.5.sp,
                      color = Color(0xFFBE123C)
                    )
                  }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                  onClick = onOpenMistakeNotebook,
                  shape = RoundedCornerShape(8.dp),
                  colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE11D48)),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Icon(Icons.Default.Refresh, contentDescription = "Revision", modifier = Modifier.size(16.dp))
                  Spacer(modifier = Modifier.width(6.dp))
                  Text("⚠️ වැරදුණු ප්‍රශ්න පමණක් නැවත පුහුණු වන්න", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
                }
              }
            }
          }
        }

        item {
          Text(
            text = "ප්‍රශ්න විවරණය සහ නිවැරදි පිළිතුරු (Marking Scheme Review):",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = NeutralDark
          )
        }

        itemsIndexed(exam.questions) { idx, q ->
          val userChoice = answersMap[q.id]
          val isCorrect = userChoice == q.correctOption

          Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, if (isCorrect) Color(0xFFBBF7D0) else Color(0xFFFECDD3)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = "ප්‍රශ්නය ${idx + 1} (${q.topicName})",
                  fontWeight = FontWeight.Bold,
                  fontSize = 12.sp,
                  color = if (isCorrect) Color(0xFF15803D) else Color(0xFFB91C1C)
                )

                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = if (isCorrect) Color(0xFFDCFCE7) else Color(0xFFFFE4E6)
                ) {
                  Text(
                    text = if (isCorrect) "නිවැරදියි (+1)" else "වැරදියි (0)",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isCorrect) Color(0xFF15803D) else Color(0xFFBE123C),
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                  )
                }
              }

              Spacer(modifier = Modifier.height(6.dp))

              Text(
                text = q.questionText,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = NeutralDark
              )

              Spacer(modifier = Modifier.height(8.dp))

              q.options.forEachIndexed { optIdx, optText ->
                val bubbleNum = optIdx + 1
                val isSelectedByUser = userChoice == bubbleNum
                val isThisCorrectAnswer = q.correctOption == bubbleNum

                val bubbleBg = when {
                  isThisCorrectAnswer -> Color(0xFFDCFCE7)
                  isSelectedByUser -> Color(0xFFFFE4E6)
                  else -> Color(0xFFF8FAFC)
                }

                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = bubbleBg,
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp)
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(
                      text = "($bubbleNum) $optText",
                      fontSize = 12.sp,
                      fontWeight = if (isThisCorrectAnswer || isSelectedByUser) FontWeight.Bold else FontWeight.Normal,
                      color = if (isThisCorrectAnswer) Color(0xFF15803D) else if (isSelectedByUser) Color(0xFFBE123C) else NeutralDark
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    if (isThisCorrectAnswer) {
                      Text("✓ නිවැරදි පිළිතුර", fontSize = 10.sp, color = Color(0xFF15803D), fontWeight = FontWeight.Bold)
                    } else if (isSelectedByUser) {
                      Text("ඔබගේ තේරීම", fontSize = 10.sp, color = Color(0xFFBE123C))
                    }
                  }
                }
              }

              Spacer(modifier = Modifier.height(8.dp))

              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFF1F5F9),
                modifier = Modifier.fillMaxWidth()
              ) {
                Text(
                  text = "💡 විවරණය: ${q.explanation}",
                  fontSize = 11.sp,
                  color = Color(0xFF334155),
                  modifier = Modifier.padding(8.dp)
                )
              }
            }
          }
        }

        item {
          Button(
            onClick = onExit,
            colors = ButtonDefaults.buttonColors(containerColor = BluePrimary),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth().height(48.dp)
          ) {
            Text("පෙරහුරු විභාග මෙනුවට ආපසු යන්න", fontWeight = FontWeight.Bold)
          }
        }
      }
    }
  } else {
    // ----------------------------------------------------
    // LIVE EXAM RUNNING SCREEN (OMR + QUESTION NAVIGATOR)
    // ----------------------------------------------------
    Scaffold(
      topBar = {
        Surface(
          color = Color(0xFF0F172A),
          shadowElevation = 3.dp
        ) {
          if (isFullScreenMode) {
            // Ultra-slim single line header in Full Screen Mode
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(horizontal = 10.dp, vertical = 4.dp),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                  text = "ප්‍රශ්නය ${currentQuestionIndex + 1}/${exam.questions.size}",
                  color = Color.White,
                  fontWeight = FontWeight.Bold,
                  fontSize = 12.sp
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = "• ලකුණු කළ: ${answersMap.size}",
                  color = Color(0xFF94A3B8),
                  fontSize = 10.sp
                )
              }

              Row(verticalAlignment = Alignment.CenterVertically) {
                val isLowTime = remainingSeconds < 300
                Text(
                  text = "⏱ $timeString",
                  color = if (isLowTime) Color(0xFFFEF08A) else Color.White,
                  fontWeight = FontWeight.Bold,
                  fontSize = 11.sp
                )
                Spacer(modifier = Modifier.width(6.dp))

                Surface(
                  onClick = { activeTab = if (activeTab == 0) 1 else 0 },
                  shape = RoundedCornerShape(4.dp),
                  color = Color(0xFF1E293B)
                ) {
                  Text(
                    text = if (activeTab == 0) "⭕ OMR" else "📝 ප්‍රශ්නය",
                    fontSize = 10.sp,
                    color = Color(0xFF38BDF8),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                  )
                }

                Spacer(modifier = Modifier.width(4.dp))

                IconButton(
                  onClick = { isFullScreenMode = false },
                  modifier = Modifier.size(28.dp)
                ) {
                  Icon(
                    imageVector = Icons.Default.FullscreenExit,
                    contentDescription = "Exit Full Screen",
                    tint = Color(0xFFF59E0B),
                    modifier = Modifier.size(20.dp)
                  )
                }
              }
            }
          } else {
            // Compact 2-row header in Standard Mode
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(horizontal = 10.dp, vertical = 6.dp)
            ) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Row(
                  verticalAlignment = Alignment.CenterVertically,
                  modifier = Modifier.weight(1f)
                ) {
                  IconButton(
                    onClick = { showConfirmSubmitDialog = true },
                    modifier = Modifier.size(28.dp)
                  ) {
                    Icon(
                      imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                      contentDescription = "Exit Exam",
                      tint = Color.White,
                      modifier = Modifier.size(18.dp)
                    )
                  }
                  Spacer(modifier = Modifier.width(4.dp))
                  Column {
                    Text(
                      text = exam.titleSinhala,
                      color = Color.White,
                      fontWeight = FontWeight.Bold,
                      fontSize = 12.sp,
                      maxLines = 1,
                      overflow = TextOverflow.Ellipsis
                    )
                    Text(
                      text = "ප්‍රශ්න ${currentQuestionIndex + 1}/${exam.questions.size} • සම්පූර්ණ කළ: ${answersMap.size}",
                      fontSize = 10.sp,
                      color = Color(0xFF94A3B8)
                    )
                  }
                }

                Spacer(modifier = Modifier.width(6.dp))

                // Timer Pill (Compact)
                val isLowTime = remainingSeconds < 300
                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = if (isLowTime) Color(0xFFDC2626) else Color(0xFF1E293B),
                  border = BorderStroke(1.dp, if (isLowTime) Color(0xFFF87171) else Color(0xFF334155))
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Icon(
                      imageVector = if (isLowTime) Icons.Default.WarningAmber else Icons.Default.HourglassBottom,
                      contentDescription = "Timer",
                      tint = if (isLowTime) Color(0xFFFEF08A) else Color.White,
                      modifier = Modifier.size(12.dp)
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(
                      text = timeString,
                      color = Color.White,
                      fontWeight = FontWeight.Bold,
                      fontSize = 12.sp
                    )
                  }
                }

                Spacer(modifier = Modifier.width(4.dp))

                // Full Screen Mode Toggle Button
                IconButton(
                  onClick = { isFullScreenMode = true },
                  modifier = Modifier.size(30.dp)
                ) {
                  Icon(
                    imageVector = Icons.Default.Fullscreen,
                    contentDescription = "Full Screen Mode",
                    tint = Color(0xFF38BDF8),
                    modifier = Modifier.size(22.dp)
                  )
                }
              }

              Spacer(modifier = Modifier.height(4.dp))

              // Compact tabs: Question View vs OMR Matrix
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(if (isCompact) 4.dp else 6.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Surface(
                  onClick = { activeTab = 0 },
                  shape = RoundedCornerShape(6.dp),
                  color = if (activeTab == 0) Color(0xFF2563EB) else Color(0xFF1E293B),
                  modifier = Modifier.weight(1f)
                ) {
                  Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(vertical = if (isCompact) 3.5.dp else 5.dp)
                  ) {
                    Text(
                      text = "📝 ප්‍රශ්නය සහ විකල්ප",
                      fontSize = if (isCompact) 9.5.sp else 11.sp,
                      fontWeight = if (activeTab == 0) FontWeight.Bold else FontWeight.Normal,
                      color = Color.White
                    )
                  }
                }

                Surface(
                  onClick = { activeTab = 1 },
                  shape = RoundedCornerShape(6.dp),
                  color = if (activeTab == 1) Color(0xFF2563EB) else Color(0xFF1E293B),
                  modifier = Modifier.weight(1f)
                ) {
                  Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(vertical = if (isCompact) 3.5.dp else 5.dp)
                  ) {
                    Text(
                      text = "⭕ OMR පත්‍රය (${answersMap.size}/${exam.questions.size})",
                      fontSize = if (isCompact) 9.5.sp else 11.sp,
                      fontWeight = if (activeTab == 1) FontWeight.Bold else FontWeight.Normal,
                      color = Color.White
                    )
                  }
                }
              }
            }
          }
        }
      },
      bottomBar = {
        Surface(
          color = Color.White,
          shadowElevation = 6.dp,
          modifier = Modifier.navigationBarsPadding()
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = if (isCompact) 6.dp else 8.dp, vertical = if (isFullScreenMode || isCompact) 3.dp else 6.dp),
            horizontalArrangement = Arrangement.spacedBy(if (isCompact) 4.dp else 6.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            OutlinedButton(
              onClick = {
                if (currentQuestionIndex > 0) currentQuestionIndex--
              },
              enabled = currentQuestionIndex > 0,
              modifier = Modifier
                .weight(1f)
                .height(if (isCompact) 32.dp else 36.dp),
              shape = RoundedCornerShape(8.dp),
              contentPadding = PaddingValues(horizontal = 4.dp, vertical = 0.dp)
            ) {
              Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier.size(if (isCompact) 12.dp else 14.dp)
              )
              Spacer(modifier = Modifier.width(2.dp))
              Text("පෙර", fontSize = if (isCompact) 9.5.sp else 11.sp, fontWeight = FontWeight.SemiBold)
            }

            Button(
              onClick = { showConfirmSubmitDialog = true },
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF16A34A)),
              shape = RoundedCornerShape(8.dp),
              modifier = Modifier
                .weight(1.3f)
                .height(if (isCompact) 32.dp else 36.dp)
                .testTag("submit_exam_button"),
              contentPadding = PaddingValues(horizontal = 4.dp, vertical = 0.dp)
            ) {
              Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Submit",
                modifier = Modifier.size(if (isCompact) 12.dp else 14.dp)
              )
              Spacer(modifier = Modifier.width(3.dp))
              Text("අවසන් කරන්න", fontWeight = FontWeight.Bold, fontSize = if (isCompact) 9.5.sp else 11.sp)
            }

            Button(
              onClick = {
                if (currentQuestionIndex < exam.questions.size - 1) currentQuestionIndex++
              },
              enabled = currentQuestionIndex < exam.questions.size - 1,
              colors = ButtonDefaults.buttonColors(containerColor = BluePrimary),
              shape = RoundedCornerShape(8.dp),
              modifier = Modifier
                .weight(1f)
                .height(if (isCompact) 32.dp else 36.dp),
              contentPadding = PaddingValues(horizontal = 4.dp, vertical = 0.dp)
            ) {
              Text("ඊළඟ", fontSize = if (isCompact) 9.5.sp else 11.sp, fontWeight = FontWeight.SemiBold)
              Spacer(modifier = Modifier.width(2.dp))
              Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                modifier = Modifier.size(if (isCompact) 12.dp else 14.dp)
              )
            }
          }
        }
      }
    ) { padding ->
      if (activeTab == 0) {
        // SINGLE QUESTION + OMR BUBBLE BAR
        val q = exam.questions[currentQuestionIndex]
        val selectedBubble = answersMap[q.id]
        val isFlagged = flaggedQuestions.contains(q.id)

        LazyColumn(
          modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .background(Color(0xFFF8FAFC)),
          contentPadding = PaddingValues(
            start = if (isCompact) 8.dp else 12.dp,
            top = 6.dp,
            end = if (isCompact) 8.dp else 12.dp,
            bottom = if (isCompact) 60.dp else 120.dp
          ),
          verticalArrangement = Arrangement.spacedBy(if (isCompact) 6.dp else 10.dp)
        ) {
          // Question Header & Flag Toggle
          item {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFE2E8F0)
              ) {
                Text(
                  text = "ප්‍රශ්නය ${currentQuestionIndex + 1} / ${exam.questions.size}",
                  fontWeight = FontWeight.Bold,
                  fontSize = if (isCompact) 9.5.sp else 11.sp,
                  color = NeutralDark,
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                )
              }

              Surface(
                onClick = {
                  if (isFlagged) flaggedQuestions.remove(q.id) else flaggedQuestions.add(q.id)
                },
                shape = RoundedCornerShape(8.dp),
                color = if (isFlagged) Color(0xFFFEF3C7) else Color.White,
                border = BorderStroke(1.dp, if (isFlagged) Color(0xFFF59E0B) else Color(0xFFCBD5E1))
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Icon(
                    imageVector = if (isFlagged) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                    contentDescription = "Review",
                    tint = if (isFlagged) Color(0xFFD97706) else NeutralMedium,
                    modifier = Modifier.size(if (isCompact) 12.dp else 14.dp)
                  )
                  Spacer(modifier = Modifier.width(3.dp))
                  Text(
                    text = if (isFlagged) "නැවත බැලීමට (Marked)" else "නැවත බැලීමට ලකුණු කරන්න",
                    fontSize = if (isCompact) 9.sp else 10.sp,
                    color = if (isFlagged) Color(0xFFD97706) else NeutralMedium
                  )
                }
              }
            }
          }

          // Question Card
          item {
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color.White),
              elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
              border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(if (isCompact) 10.dp else 14.dp)) {
                Text(
                  text = q.questionText,
                  fontWeight = FontWeight.Bold,
                  fontSize = if (isCompact) 12.sp else 14.sp,
                  color = NeutralDark,
                  lineHeight = if (isCompact) 17.sp else 21.sp
                )

                Spacer(modifier = Modifier.height(if (isCompact) 6.dp else 10.dp))

                q.options.forEachIndexed { optIdx, optText ->
                  val bubbleNum = optIdx + 1
                  val isSelected = selectedBubble == bubbleNum

                  Surface(
                    onClick = {
                      answersMap[q.id] = bubbleNum
                    },
                    shape = RoundedCornerShape(8.dp),
                    color = if (isSelected) Color(0xFFEFF6FF) else Color(0xFFF8FAFC),
                    border = BorderStroke(1.5.dp, if (isSelected) BluePrimary else Color(0xFFE2E8F0)),
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(vertical = if (isCompact) 2.dp else 3.dp)
                  ) {
                    Row(
                      modifier = Modifier.padding(
                        horizontal = if (isCompact) 8.dp else 10.dp,
                        vertical = if (isCompact) 6.dp else 10.dp
                      ),
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      // OMR Circle Bubble
                      Box(
                        modifier = Modifier
                          .size(if (isCompact) 22.dp else 26.dp)
                          .clip(CircleShape)
                          .background(if (isSelected) Color(0xFF1E293B) else Color.White)
                          .border(1.5.dp, if (isSelected) Color(0xFF1E293B) else Color(0xFF94A3B8), CircleShape),
                        contentAlignment = Alignment.Center
                      ) {
                        Text(
                          text = "$bubbleNum",
                          fontWeight = FontWeight.Black,
                          fontSize = if (isCompact) 9.5.sp else 11.sp,
                          color = if (isSelected) Color.White else Color(0xFF64748B)
                        )
                      }

                      Spacer(modifier = Modifier.width(if (isCompact) 6.dp else 10.dp))

                      Text(
                        text = optText,
                        fontSize = if (isCompact) 11.sp else 12.5.sp,
                        lineHeight = if (isCompact) 15.sp else 17.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSelected) BluePrimary else NeutralDark
                      )
                    }
                  }
                }
              }
            }
          }

          // Fast OMR Bubble Strip at the bottom
          item {
            Card(
              shape = RoundedCornerShape(10.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F5F9)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 10.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Text("OMR තිත් තැබීම:", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = NeutralDark)
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                  (1..4).forEach { bNum ->
                    val isSelected = selectedBubble == bNum
                    Box(
                      modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(if (isSelected) Color(0xFF0F172A) else Color.White)
                        .border(1.5.dp, if (isSelected) Color(0xFF0F172A) else Color(0xFF94A3B8), CircleShape)
                        .clickable { answersMap[q.id] = bNum },
                      contentAlignment = Alignment.Center
                    ) {
                      Text(
                        text = "($bNum)",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isSelected) Color.White else NeutralDark
                      )
                    }
                  }
                }
              }
            }
          }
        }
      } else {
        // FULL OMR SHEET MATRIX (All 1..20/40 questions bubble sheet)
        LazyColumn(
          modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .background(Color(0xFFF8FAFC))
            .padding(horizontal = 14.dp),
          contentPadding = PaddingValues(top = 14.dp, bottom = 140.dp),
          verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          item {
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFBEB)),
              border = BorderStroke(1.dp, Color(0xFFFDE68A)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Info, contentDescription = "Info", tint = Color(0xFFD97706), modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = "සැබෑ OMR පත්‍රයක මෙන් එක් එක් ප්‍රශ්නයට අදාළ අංකය මත ක්ලික් කර පිළිතුරු සලකුණු කරන්න.",
                  fontSize = 11.sp,
                  color = Color(0xFF92400E)
                )
              }
            }
          }

          itemsIndexed(exam.questions) { idx, q ->
            val selected = answersMap[q.id]
            val isFlagged = flaggedQuestions.contains(q.id)

            Card(
              shape = RoundedCornerShape(10.dp),
              colors = CardDefaults.cardColors(
                containerColor = if (selected != null) Color(0xFFF0FDF4) else Color.White
              ),
              border = BorderStroke(1.dp, if (selected != null) Color(0xFFBBF7D0) else Color(0xFFE2E8F0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 10.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable {
                  currentQuestionIndex = idx
                  activeTab = 0
                }) {
                  Text(
                    text = "Q${idx + 1}.",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = if (selected != null) Color(0xFF15803D) else NeutralDark
                  )
                  if (isFlagged) {
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("🚩", fontSize = 10.sp)
                  }
                }

                // 4 OMR Bubbles
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                  (1..4).forEach { bNum ->
                    val isChosen = selected == bNum
                    Box(
                      modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(if (isChosen) Color(0xFF0F172A) else Color.White)
                        .border(1.5.dp, if (isChosen) Color(0xFF0F172A) else Color(0xFFCBD5E1), CircleShape)
                        .clickable { answersMap[q.id] = bNum },
                      contentAlignment = Alignment.Center
                    ) {
                      Text(
                        text = "$bNum",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isChosen) Color.White else NeutralDark
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

  // Confirm Submit Dialog
  if (showConfirmSubmitDialog) {
    AlertDialog(
      onDismissRequest = { showConfirmSubmitDialog = false },
      title = { Text("විභාගය අවසන් කරන්නද?", fontWeight = FontWeight.Bold) },
      text = {
        Text("ඔබ ප්‍රශ්න ${exam.questions.size} න් ${answersMap.size} කට පිළිතුරු සපයා ඇත. විභාගය අවසන් කර ප්‍රතිඵල සහ ලකුණු විවරණය බැලීමට අවශ්‍යද?")
      },
      confirmButton = {
        Button(
          onClick = {
            showConfirmSubmitDialog = false
            isExamSubmitted = true
          },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF16A34A))
        ) {
          Text("ඔව්, අවසන් කරන්න")
        }
      },
      dismissButton = {
        TextButton(onClick = { showConfirmSubmitDialog = false }) {
          Text("තවදුරටත් ලියන්න")
        }
      }
    )
  }
}

// ==============================================================================
// 2. SMART PDF DIGITAL STICKY NOTES & HIGHLIGHT TOOL (සටහන් Highlight කිරීම)
// ==============================================================================

data class PdfStickyNote(
  val id: String,
  val pdfTitle: String,
  val noteText: String,
  val colorHex: Long, // Color int
  val timestamp: String,
  val tag: String
)

object PdfAnnotationManager {
  val notesList = mutableStateListOf(
    PdfStickyNote(
      id = "note_1",
      pdfTitle = "විද්‍යාව කෙටි සටහන්",
      noteText = "ආලෝක ප්‍රතික්‍රියාව සිදුවන්නේ තයිලකොයිඩ පටලයේය. අඳුරු ප්‍රතික්‍රියාව ස්ට්‍රෝමාවේය. විභාගයට අනිවාර්යයි!",
      colorHex = 0xFFFEF08A, // Yellow
      timestamp = "අද, පෙ.ව. 10:30",
      tag = "🔥 විභාග ඉලක්ක"
    ),
    PdfStickyNote(
      id = "note_2",
      pdfTitle = "ගණිතය ජ්‍යාමිතිය",
      noteText = "වෘත්තයක කේන්ද්‍රයේ සිට ජ්‍යායකට අඳින ලම්භය මගින් ජ්‍යාය සමච්ඡේද වේ. සාධනය සූදානම් කරගන්න.",
      colorHex = 0xFFBBF7D0, // Green
      timestamp = "ඊයේ, ප.ව. 4:15",
      tag = "⭐️ ප්‍රමේයය"
    )
  )

  fun addNote(pdfTitle: String, text: String, colorHex: Long, tag: String) {
    val sdf = SimpleDateFormat("MM/dd HH:mm", Locale.getDefault())
    notesList.add(
      0,
      PdfStickyNote(
        id = System.currentTimeMillis().toString(),
        pdfTitle = pdfTitle,
        noteText = text,
        colorHex = colorHex,
        timestamp = sdf.format(Date()),
        tag = tag
      )
    )
  }

  fun deleteNote(id: String) {
    notesList.removeAll { it.id == id }
  }
}

@Composable
fun SmartPdfStickyNotesOverlay(
  pdfTitle: String,
  modifier: Modifier = Modifier
) {
  var isExpanded by remember { mutableStateOf(false) }
  var newNoteText by remember { mutableStateOf("") }
  var selectedColorHex by remember { mutableStateOf(0xFFFEF08A) } // Yellow
  var selectedTag by remember { mutableStateOf("🔥 විභාග ඉලක්ක") }

  val relevantNotes = PdfAnnotationManager.notesList.filter {
    it.pdfTitle.contains(pdfTitle, ignoreCase = true) || pdfTitle.contains(it.pdfTitle, ignoreCase = true)
  }

  Box(modifier = modifier) {
    if (!isExpanded) {
      // Floating Sticky Notes Button
      Surface(
        onClick = { isExpanded = true },
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFFFEF08A),
        border = BorderStroke(1.dp, Color(0xFFFACC15)),
        shadowElevation = 6.dp,
        modifier = Modifier.padding(12.dp).testTag("pdf_sticky_notes_toggle")
      ) {
        Row(
          modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("📝", fontSize = 16.sp)
          Spacer(modifier = Modifier.width(6.dp))
          Text(
            text = "Sticky Notes (${relevantNotes.size})",
            fontWeight = FontWeight.Bold,
            fontSize = 11.sp,
            color = Color(0xFF713F12)
          )
        }
      }
    } else {
      // Expanded Notes Panel Dialog / Bottom Drawer
      Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
        modifier = Modifier
          .fillMaxWidth(0.92f)
          .heightIn(max = 420.dp)
          .padding(8.dp)
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          // Header
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text("📝", fontSize = 18.sp)
              Spacer(modifier = Modifier.width(6.dp))
              Text("මගේ සටහන් & Highlights", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = NeutralDark)
            }

            IconButton(onClick = { isExpanded = false }, modifier = Modifier.size(26.dp)) {
              Icon(Icons.Default.Close, contentDescription = "Close", tint = NeutralMedium)
            }
          }

          Spacer(modifier = Modifier.height(8.dp))

          // Color Palette Picker (Yellow, Green, Pink, Blue)
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text("වර්ණය:", fontSize = 10.sp, color = NeutralMedium)
            listOf(
              0xFFFEF08A to "කහ",
              0xFFBBF7D0 to "කොළ",
              0xFFFBCFE8 to "රෝස",
              0xFFBFDBFE to "නිල්"
            ).forEach { (cHex, _) ->
              Box(
                modifier = Modifier
                  .size(24.dp)
                  .clip(CircleShape)
                  .background(Color(cHex))
                  .border(
                    if (selectedColorHex == cHex) 2.dp else 1.dp,
                    if (selectedColorHex == cHex) Color.Black else Color.LightGray,
                    CircleShape
                  )
                  .clickable { selectedColorHex = cHex }
              )
            }

            Spacer(modifier = Modifier.weight(1f))

            // Quick Tag Chip
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFFF1F5F9)
            ) {
              Text(
                text = selectedTag,
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                color = BluePrimary,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
          }

          Spacer(modifier = Modifier.height(8.dp))

          // Add Note Field
          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
          ) {
            androidx.compose.material3.OutlinedTextField(
              value = newNoteText,
              onValueChange = { newNoteText = it },
              placeholder = { Text("වැදගත් කරුණක් මෙහි ලියා සුරකින්න...", fontSize = 11.sp) },
              modifier = Modifier.weight(1f),
              singleLine = false,
              maxLines = 2
            )
            Spacer(modifier = Modifier.width(6.dp))
            Button(
              onClick = {
                if (newNoteText.isNotBlank()) {
                  PdfAnnotationManager.addNote(pdfTitle, newNoteText.trim(), selectedColorHex, selectedTag)
                  newNoteText = ""
                }
              },
              colors = ButtonDefaults.buttonColors(containerColor = Color(selectedColorHex)),
              shape = RoundedCornerShape(8.dp),
              contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
            ) {
              Text("Save", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            }
          }

          Spacer(modifier = Modifier.height(10.dp))
          HorizontalDivider(color = Color(0xFFF1F5F9))
          Spacer(modifier = Modifier.height(6.dp))

          // Saved Notes List
          LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            if (relevantNotes.isEmpty()) {
              item {
                Text(
                  text = "තවමත් මෙම PDF එක සඳහා සටහන් එකතු කර නැත.",
                  fontSize = 11.sp,
                  color = NeutralMedium,
                  textAlign = TextAlign.Center,
                  modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp)
                )
              }
            }
            items(relevantNotes) { note ->
              Surface(
                shape = RoundedCornerShape(10.dp),
                color = Color(note.colorHex),
                border = BorderStroke(1.dp, Color(note.colorHex).copy(alpha = 0.6f)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(8.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(note.tag, fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color.Black.copy(alpha = 0.7f))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                      Text(note.timestamp, fontSize = 9.sp, color = Color.Black.copy(alpha = 0.5f))
                      Spacer(modifier = Modifier.width(4.dp))
                      Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = Color.Black.copy(alpha = 0.5f),
                        modifier = Modifier
                          .size(14.dp)
                          .clickable { PdfAnnotationManager.deleteNote(note.id) }
                      )
                    }
                  }
                  Spacer(modifier = Modifier.height(4.dp))
                  Text(note.noteText, fontSize = 11.sp, color = Color.Black, lineHeight = 15.sp)
                }
              }
            }
          }
        }
      }
    }
  }
}
