package com.example

import androidx.activity.compose.BackHandler
import android.content.Context
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import android.speech.tts.TextToSpeech

// ==============================================================================
// 🌟 INTERACTIVE Q&A MASTER HUB (ප්‍රශ්න හා පිළිතුරු පුහුණු මධ්‍යස්ථානය)
// 1. Structured / Short-Answer Self-Evaluation (ව්‍යුහගත කෙටි පිළිතුරු)
// 2. Interactive Flashcard Q&A (Flip-Card මතක කාඩ්පත්)
// 3. Daily Mixed 10 Challenge (දිනපතා මිශ්‍ර ප්‍රශ්න 10)
// 4. Match the Following & Timeline Ordering (ගැලපීම් & කාලරේඛා)
// 5. True/False with Deep Justification (සත්‍ය/අසත්‍ය & විවරණ)
// 6. Custom Self-Quiz Maker (ශිෂ්‍යයාගේම ප්‍රශ්න එකතුව)
// ==============================================================================

enum class QaHubTab(val title: String, val icon: String, val badge: String, val color: Color) {
  SHORT_ANSWER("කෙටි පිළිතුරු", "✍️", "EVALUATE", Color(0xFF38BDF8)),
  FLASHCARDS("Flashcards", "⚡", "FLIP", Color(0xFFF59E0B)),
  DAILY_CHALLENGE("දිනපතා 10", "🎯", "DAILY", Color(0xFF10B981)),
  MATCHING("ගැලපීම් & පෙළගැස්ම", "🧩", "MATCH", Color(0xFF8B5CF6)),
  TRUE_FALSE("සත්‍ය / අසත්‍ය", "⚖️", "REASON", Color(0xFFEC4899)),
  CUSTOM_QUIZ("මගේ ප්‍රශ්න", "📝", "MAKER", Color(0xFF14B8A6))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InteractiveQaMasterHubScreen(
  onBack: () -> Unit,
  initialTab: QaHubTab = QaHubTab.SHORT_ANSWER,
  isFullScreen: Boolean = false,
  onFullScreenToggle: (Boolean) -> Unit = {}
) {
  var activeTab by remember { mutableStateOf(initialTab) }

  Scaffold(
    topBar = {
      if (!isFullScreen) {
        TopAppBar(
        title = {
          Column {
            Text(
              text = "🎯 Interactive Q&A Master Hub",
              fontSize = 15.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Text(
              text = "O/L විභාග ප්‍රශ්න හා පිළිතුරු පුහුණු විශේෂාංග 6",
              fontSize = 10.sp,
              color = Color(0xFFBAE6FD)
            )
          }
        },
        navigationIcon = {
          IconButton(
            onClick = onBack,
            modifier = Modifier.testTag("qa_hub_back_btn")
          ) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = "Back",
              tint = Color.White
            )
          }
        },
        actions = {
          IconButton(onClick = { onFullScreenToggle(true) }) {
            Icon(
              imageVector = Icons.Default.Fullscreen,
              contentDescription = "Full Screen",
              tint = Color.White
            )
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0F172A))
      )
      }
    }
  ) { padding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF0B132B))
        .padding(padding)
    ) {
      // Horizontal Tab Row
      if (!isFullScreen) {
        ScrollableTabRow(
          selectedTabIndex = activeTab.ordinal,
          containerColor = Color(0xFF111C44),
          contentColor = Color.White,
          edgePadding = 12.dp,
          divider = {}
        ) {
          QaHubTab.values().forEach { tab ->
            Tab(
              selected = activeTab == tab,
              onClick = { activeTab = tab },
              text = {
                Row(
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                  Text(tab.icon, fontSize = 14.sp)
                  Text(
                    text = tab.title,
                    fontSize = 11.5.sp,
                    fontWeight = if (activeTab == tab) FontWeight.Bold else FontWeight.Normal,
                    color = if (activeTab == tab) tab.color else Color(0xFF94A3B8)
                  )
                }
              },
              modifier = Modifier.testTag("tab_${tab.name}")
            )
          }
        }
      }

      // Tab Content Body
      Box(
        modifier = Modifier
          .fillMaxSize()
          .padding(if (isFullScreen) PaddingValues(0.dp) else PaddingValues(horizontal = 12.dp, vertical = 8.dp))
      ) {
        when (activeTab) {
          QaHubTab.SHORT_ANSWER -> ShortAnswerEvaluationSection()
          QaHubTab.FLASHCARDS -> FlashcardQaSection()
          QaHubTab.DAILY_CHALLENGE -> DailyMixedChallengeSection(isFullScreen = isFullScreen, onFullScreenToggle = onFullScreenToggle)
          QaHubTab.MATCHING -> MatchingAndOrderingSection(isFullScreen = isFullScreen, onFullScreenToggle = onFullScreenToggle)
          QaHubTab.TRUE_FALSE -> TrueFalseWithJustificationSection(isFullScreen = isFullScreen, onFullScreenToggle = onFullScreenToggle)
          QaHubTab.CUSTOM_QUIZ -> CustomQuizMakerSection()
        }
      }

      // Floating "Exit Full Screen" button (only for tabs without their own in-screen back headers)
      if (isFullScreen && activeTab != QaHubTab.TRUE_FALSE && activeTab != QaHubTab.MATCHING && activeTab != QaHubTab.DAILY_CHALLENGE) {
        Box(
          modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
          contentAlignment = Alignment.TopEnd
        ) {
          IconButton(
            onClick = { onFullScreenToggle(false) },
            modifier = Modifier
              .background(Color.Black.copy(alpha = 0.5f), CircleShape)
              .size(40.dp)
          ) {
            Icon(
              imageVector = Icons.Default.Close,
              contentDescription = "Exit Full Screen",
              tint = Color.White,
              modifier = Modifier.size(24.dp)
            )
          }
        }
      }
    }
  }
}

// ==============================================================================
// 1. ✍️ STRUCTURED / SHORT ANSWER EVALUATION (20 Distinct Sets Per Subject)
// ==============================================================================
data class ShortAnswerSubjectInfo(
  val subjectName: String,
  val subjectEnglish: String,
  val icon: String,
  val color: Color,
  val badge: String,
  val setsCountDesc: String,
  val unitsSummaryBrief: String
)

val shortAnswerSubjectsList = listOf(
  ShortAnswerSubjectInfo("විද්‍යාව", "Science", "🔬", Color(0xFF0EA5E9), "කාණ්ඩ 20", "ප්‍රශ්න 200 • මට්ටම් 2", "පටක, රසායනික බන්ධන, චලිතය..."),
  ShortAnswerSubjectInfo("ගණිතය", "Mathematics", "📐", Color(0xFFEAB308), "කාණ්ඩ 20", "ප්‍රශ්න 200 • මට්ටම් 2", "සාධක, සමීකරණ, ජ්‍යාමිතිය, කුලක..."),
  ShortAnswerSubjectInfo("ඉතිහාසය", "History", "🏛️", Color(0xFF10B981), "කාණ්ඩ 20", "ප්‍රශ්න 200 • මට්ටම් 2", "ලක්දිව රාජධානි, විදේශ සබඳතා..."),
  ShortAnswerSubjectInfo("බුද්ධ ධර්මය", "Buddhism", "🪷", Color(0xFFF97316), "කාණ්ඩ 20", "ප්‍රශ්න 200 • මට්ටම් 2", "බුද්ධ චරිතය, ත්‍රිපිටකය, සංගායනා..."),
  ShortAnswerSubjectInfo("සිංහල", "Sinhala", "📜", Color(0xFFEC4899), "කාණ්ඩ 20", "ප්‍රශ්න 200 • මට්ටම් 2", "ව්‍යාකරණ, සාහිත්‍යය, රචනා..."),
  ShortAnswerSubjectInfo("English", "English", "🇬🇧", Color(0xFF8B5CF6), "කාණ්ඩ 20", "ප්‍රශ්න 200 • මට්ටම් 2", "Grammar, Tenses, Vocabulary..."),
  ShortAnswerSubjectInfo("ICT", "ICT", "💻", Color(0xFF2563EB), "කාණ්ඩ 20", "ප්‍රශ්න 200 • මට්ටම් 2", "සංඛ්‍යා පද්ධති, මෘදුකාංග, HTML..."),
  ShortAnswerSubjectInfo("ව්‍යාපාර හා ගිණුම්කරණය", "Accounting", "📊", Color(0xFF7C3AED), "කාණ්ඩ 20", "ප්‍රශ්න 200 • මට්ටම් 2", "ගිණුම්කරණ සමීකරණ, මුල් පොත්..."),
  ShortAnswerSubjectInfo("භූගෝල විද්‍යාව", "Geography", "🌍", Color(0xFF059669), "කාණ්ඩ 20", "ප්‍රශ්න 200 • මට්ටම් 2", "පෘථිවිය, සිතියම්, කාලගුණය..."),
  ShortAnswerSubjectInfo("පුරවැසි අධ්‍යාපනය", "Civics", "⚖️", Color(0xFFDC2626), "කාණ්ඩ 20", "ප්‍රශ්න 200 • මට්ටම් 2", "ආණ්ඩුක්‍රම, මානව හිමිකම්, නීතිය..."),
  ShortAnswerSubjectInfo("සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය", "Health", "🏃", Color(0xFFEA580C), "කාණ්ඩ 20", "ප්‍රශ්න 200 • මට්ටම් 2", "පෝෂණය, ප්‍රථමාධාර, ශාරීරික යෝග්‍යතාව..."),
  ShortAnswerSubjectInfo("කෘෂි විද්‍යාව", "Agri", "🌾", Color(0xFF10B981), "කාණ්ඩ 20", "ප්‍රශ්න 200 • මට්ටම් 2", "භෝග වගාව, පාංශු පාලනය, සත්ත්ව පාලනය..."),
  ShortAnswerSubjectInfo("චිත්‍ර කලාව", "Art", "🎨", Color(0xFFF43F5E), "කාණ්ඩ 20", "ප්‍රශ්න 200 • මට්ටම් 2", "කලා ඉතිහාසය, වර්ණ සංයෝජනය, චිත්‍ර කලාව..."),
  ShortAnswerSubjectInfo("සංගීතය", "Music", "🎸", Color(0xFF8B5CF6), "කාණ්ඩ 20", "ප්‍රශ්න 200 • මට්ටම් 2", "රාග ධාරී සංගීතය, තාල ක්‍රම, ගායන ශිල්පය..."),
  ShortAnswerSubjectInfo("නර්තනය", "Dancing", "💃", Color(0xFFEC4899), "කාණ්ඩ 20", "ප්‍රශ්න 200 • මට්ටම් 2", "උඩරට හා පහතරට නර්තන, බෙර වාදනය, රංග කලාව...")
)

@Composable
fun QaSubjectMiniCard(
  category: ShortAnswerSubjectInfo,
  onClick: () -> Unit
) {
  Card(
    onClick = onClick,
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
    border = BorderStroke(1.2.dp, category.color.copy(alpha = 0.5f)),
    modifier = Modifier
      .fillMaxWidth()
      .height(130.dp)
      .testTag("qa_subject_${category.subjectName}")
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
            .background(category.color.copy(alpha = 0.2f)),
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
          text = category.setsCountDesc,
          fontSize = 8.5.sp,
          color = Color(0xFF94A3B8),
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "පුහුණුව →",
          fontSize = 9.5.sp,
          color = category.color,
          fontWeight = FontWeight.Bold
        )
      }
    }
  }
}

@Composable
fun ShortAnswerEvaluationSection() {
  val grades = listOf("10", "11")
  var selectedGrade by remember { mutableStateOf("11") }
  
  var activeSubjectName by remember { mutableStateOf<String?>(null) }
  var subjectSearchQuery by remember { mutableStateOf("") }

  // Intercept back key if a subject is active to return to selection grid
  BackHandler(enabled = activeSubjectName != null) {
    activeSubjectName = null
  }

  val setsForGrade = remember(selectedGrade, activeSubjectName) {
    if (activeSubjectName != null) {
      ShortAnswerMasterRepository.getSetsForSubject(selectedGrade, activeSubjectName!!)
    } else emptyList()
  }

  var selectedSetNumber by remember(selectedGrade, activeSubjectName) {
    mutableIntStateOf(1)
  }

  val currentSetInfo = setsForGrade.find { it.setNumber == selectedSetNumber } ?: setsForGrade.firstOrNull() ?: QuestionSetInfo(1, selectedGrade, "කාණ්ඩය 01", activeSubjectName ?: "", "📚")

  val questions = remember(selectedGrade, activeSubjectName, selectedSetNumber) {
    if (activeSubjectName != null) {
      ShortAnswerMasterRepository.getQuestions(selectedGrade, activeSubjectName!!, selectedSetNumber)
    } else emptyList()
  }

  var selectedIndex by remember(selectedGrade, activeSubjectName, selectedSetNumber) { mutableIntStateOf(0) }
  val currentQ = if (questions.isNotEmpty() && selectedIndex < questions.size) questions[selectedIndex] else questions.firstOrNull()

  var studentAnswer by remember(selectedGrade, activeSubjectName, selectedSetNumber, selectedIndex) { mutableStateOf("") }
  var isEvaluated by remember(selectedGrade, activeSubjectName, selectedSetNumber, selectedIndex) { mutableStateOf(false) }
  var evalResult by remember(selectedGrade, activeSubjectName, selectedSetNumber, selectedIndex) { mutableStateOf<EvaluationResult?>(null) }

  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(12.dp),
    contentPadding = PaddingValues(top = 4.dp, bottom = 140.dp)
  ) {
    if (activeSubjectName == null) {
      // =========================================================================
      // INITIAL SCREEN: COLORFUL SUBJECT CARDS GRID
      // =========================================================================
      item {
        Card(
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.5f))
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text("✍️", fontSize = 18.sp)
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = "ව්‍යුහගත කෙටි පිළිතුරු ස්වයං ඇගයීම",
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "O/L විභාග මට්ටමේ කෙටි ප්‍රශ්න වලට පිළිතුරු සපයා, ඔබගේ පිළිතුරෙහි නිවැරදිභාවය ක්ෂණිකව පරීක්ෂා කරගන්න. ආරම්භ කිරීමට පහතින් විෂයක් තෝරන්න.",
              fontSize = 11.5.sp,
              color = Color(0xFFCBD5E1),
              lineHeight = 16.sp
            )
          }
        }
      }

      // Subject Search Bar
      item {
        OutlinedTextField(
          value = subjectSearchQuery,
          onValueChange = { subjectSearchQuery = it },
          placeholder = { Text("විෂය සොයන්න (Search Subject)...", fontSize = 12.sp, color = Color(0xFF64748B)) },
          leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.size(18.dp), tint = Color(0xFF94A3B8)) },
          trailingIcon = {
            if (subjectSearchQuery.isNotEmpty()) {
              IconButton(onClick = { subjectSearchQuery = "" }) {
                Icon(Icons.Default.Clear, contentDescription = null, modifier = Modifier.size(16.dp), tint = Color(0xFF94A3B8))
              }
            }
          },
          singleLine = true,
          shape = RoundedCornerShape(12.dp),
          colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFF1E293B),
            unfocusedContainerColor = Color(0xFF1E293B),
            focusedBorderColor = Color(0xFF38BDF8),
            unfocusedBorderColor = Color(0xFF334155),
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White
          ),
          modifier = Modifier.fillMaxWidth()
        )
      }

      item {
        Text(
          text = "🎨 විෂය තෝරා අභ්‍යාස ආරම්භ කරන්න:",
          fontWeight = FontWeight.Bold,
          fontSize = 13.sp,
          color = Color.White,
          modifier = Modifier.padding(top = 4.dp)
        )
      }

      val filteredSubjects = if (subjectSearchQuery.isBlank()) shortAnswerSubjectsList else {
        shortAnswerSubjectsList.filter {
          it.subjectName.contains(subjectSearchQuery.trim(), ignoreCase = true) ||
          it.subjectEnglish.contains(subjectSearchQuery.trim(), ignoreCase = true)
        }
      }

      if (filteredSubjects.isEmpty()) {
        item {
          Box(modifier = Modifier.fillMaxWidth().padding(20.dp), contentAlignment = Alignment.Center) {
            Text("සොයන ලද විෂය හමු නොවීය.", color = Color(0xFF94A3B8), fontSize = 12.sp)
          }
        }
      } else {
        items(filteredSubjects.chunked(2)) { pair ->
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            pair.forEach { subjInfo ->
              Box(modifier = Modifier.weight(1f)) {
                QaSubjectMiniCard(
                  category = subjInfo,
                  onClick = {
                    activeSubjectName = subjInfo.subjectName
                    selectedSetNumber = 1
                    selectedIndex = 0
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

      // 1. Horizontal Subject Selector Bar
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
              fontSize = 11.sp,
              color = Color(0xFF94A3B8)
            )
            TextButton(
              onClick = { activeSubjectName = null },
              contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp)
            ) {
              Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, modifier = Modifier.size(13.dp), tint = Color(0xFF38BDF8))
              Spacer(modifier = Modifier.width(3.dp))
              Text("සියලු විෂයන්", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
            }
          }

          Spacer(modifier = Modifier.height(4.dp))

          LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            item {
              Surface(
                onClick = { activeSubjectName = null },
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
                  Text("සියල්ල", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                }
              }
            }

            items(shortAnswerSubjectsList) { subjInfo ->
              val isCurrent = activeSubjectName == subjInfo.subjectName
              Surface(
                onClick = { activeSubjectName = subjInfo.subjectName; selectedSetNumber = 1; selectedIndex = 0; studentAnswer = ""; isEvaluated = false },
                shape = RoundedCornerShape(12.dp),
                color = if (isCurrent) subjInfo.color else Color(0xFF0F172A),
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
                    color = if (isCurrent) Color.Black else Color(0xFFCBD5E1),
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.5.sp
                  )
                }
              }
            }
          }
        }
      }

      // 2. Grade Selection & Sets
      item {
        Card(
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFF334155))
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            // Grade Selector
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(8.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text("ශ්‍රේණිය:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
              grades.forEach { gr ->
                val isSelected = gr == selectedGrade
                Surface(
                  onClick = { selectedGrade = gr; selectedSetNumber = 1; selectedIndex = 0 },
                  shape = RoundedCornerShape(8.dp),
                  color = if (isSelected) Color(0xFF0284C7) else Color(0xFF0F172A),
                  border = BorderStroke(1.dp, if (isSelected) Color(0xFF38BDF8) else Color(0xFF334155)),
                  modifier = Modifier.weight(1f)
                ) {
                  Text(
                    text = "$gr ශ්‍රේණිය",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 8.dp)
                  )
                }
              }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Set Selector
            Text(
              text = "$selectedGrade ශ්‍රේණියේ $activeSubjectName ප්‍රශ්න කාණ්ඩය (කාණ්ඩ 20):",
              fontSize = 11.sp,
              fontWeight = FontWeight.SemiBold,
              color = Color(0xFF94A3B8)
            )
            Spacer(modifier = Modifier.height(6.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
              items(setsForGrade) { setInfo ->
                val isSetSelected = setInfo.setNumber == selectedSetNumber
                Surface(
                  onClick = { selectedSetNumber = setInfo.setNumber; selectedIndex = 0; studentAnswer = ""; isEvaluated = false },
                  shape = RoundedCornerShape(10.dp),
                  color = if (isSetSelected) Color(0xFF0369A1) else Color(0xFF0F172A),
                  border = BorderStroke(1.dp, if (isSetSelected) Color(0xFF38BDF8) else Color(0xFF334155))
                ) {
                  Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                  ) {
                    Text(setInfo.icon, fontSize = 13.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Column {
                      Text(
                        text = "කාණ්ඩය ${String.format("%02d", setInfo.setNumber)}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isSetSelected) Color.White else Color(0xFFE2E8F0)
                      )
                      Text(
                        text = setInfo.titleSinhala.substringAfter(": ", setInfo.titleSinhala),
                        fontSize = 9.sp,
                        color = if (isSetSelected) Color(0xFFBAE6FD) else Color(0xFF94A3B8),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                      )
                    }
                  }
                }
              }
            }
          }
        }
      }

      // 3. Question Index Stepper
      item {
        LazyRow(
          horizontalArrangement = Arrangement.spacedBy(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          itemsIndexed(questions) { idx, q ->
            val isQSelected = selectedIndex == idx
            Surface(
              onClick = { selectedIndex = idx; studentAnswer = ""; isEvaluated = false; evalResult = null },
              shape = RoundedCornerShape(8.dp),
              color = if (isQSelected) Color(0xFF0284C7) else Color(0xFF1E293B),
              border = BorderStroke(1.dp, if (isQSelected) Color(0xFF38BDF8) else Color(0xFF334155))
            ) {
              Text(
                text = "Q${idx + 1}",
                fontSize = 11.sp,
                fontWeight = if (isQSelected) FontWeight.Bold else FontWeight.Normal,
                color = if (isQSelected) Color.White else Color(0xFFCBD5E1),
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
              )
            }
          }
        }
      }

      // 4. Current Question & Answer Card
      if (currentQ != null) {
        item {
          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
            border = BorderStroke(1.dp, Color(0xFF334155))
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Text(
                text = currentQ.question,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                lineHeight = 22.sp
              )
              Spacer(modifier = Modifier.height(16.dp))
              OutlinedTextField(
                value = studentAnswer,
                onValueChange = { studentAnswer = it; if (isEvaluated) isEvaluated = false },
                placeholder = { Text("ඔබගේ කෙටි පිළිතුර මෙහි සටහන් කරන්න...", color = Color(0xFF64748B), fontSize = 12.sp) },
                modifier = Modifier.fillMaxWidth().heightIn(min = 100.dp),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                  focusedContainerColor = Color(0xFF1E293B),
                  unfocusedContainerColor = Color(0xFF1E293B),
                  focusedBorderColor = Color(0xFF38BDF8),
                  unfocusedBorderColor = Color(0xFF475569),
                  focusedTextColor = Color.White,
                  unfocusedTextColor = Color.White
                )
              )

              Spacer(modifier = Modifier.height(12.dp))
              Button(
                onClick = {
                  if (studentAnswer.isNotBlank()) {
                    evalResult = ShortAnswerEvaluator.evaluate(currentQ, studentAnswer)
                    isEvaluated = true
                  }
                },
                enabled = studentAnswer.isNotBlank(),
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = if (studentAnswer.isNotBlank()) Color(0xFF0284C7) else Color(0xFF94A3B8)),
                shape = RoundedCornerShape(10.dp)
              ) {
                Text("පිළිතුර ඉදිරිපත් කර ලකුණු බලන්න", fontSize = 12.sp, fontWeight = FontWeight.Bold)
              }
            }
          }
        }
      }

      // 5. Evaluation Result
      if (isEvaluated && evalResult != null && currentQ != null) {
        val result = evalResult!!
        item {
          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            border = BorderStroke(1.5.dp, if (result.scoreEarned >= currentQ.maxMarks) Color(0xFF22C55E) else Color(0xFFF59E0B))
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Text(
                text = "ඇගයීම් ප්‍රතිඵලය: ${result.scoreEarned}/${result.maxMarks}",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Spacer(modifier = Modifier.height(6.dp))
              Text(
                text = result.feedbackSinhala,
                fontSize = 12.sp,
                color = if (result.scoreEarned >= currentQ.maxMarks) Color(0xFF86EFAC) else Color(0xFFFDE68A)
              )
              Spacer(modifier = Modifier.height(10.dp))
              Text(
                text = "🌟 ආදර්ශ පිළිතුර: ${currentQ.sampleIdealAnswer}",
                fontSize = 11.5.sp,
                color = Color(0xFF38BDF8),
                lineHeight = 17.sp
              )
            }
          }
        }
      }
    }
  }
}
// ==============================================================================
// 2. ⚡ INTERACTIVE FLASHCARD Q&A (Flip-Card Spaced Repetition)
// ==============================================================================

data class QaFlashcardItem(
  val id: Int,
  val subject: String,
  val category: String,
  val frontQuestion: String,
  val backAnswer: String,
  val examTip: String,
  val formulaOrFact: String = ""
)

@Composable
fun FlashcardQaSection() {
  val grades = listOf("9", "10", "11")
  var selectedGrade by remember { mutableStateOf("11") }

  var activeSubjectName by remember { mutableStateOf<String?>(null) }
  var subjectSearchQuery by remember { mutableStateOf("") }

  // BackHandler to return to selection grid
  BackHandler(enabled = activeSubjectName != null) {
    activeSubjectName = null
  }

  val subjects = remember { ComprehensiveFlashcardRepository.availableSubjects }
  var selectedSetNumber by remember(selectedGrade, activeSubjectName) { mutableStateOf<Int?>(1) }

  val setsList = remember(selectedGrade, activeSubjectName) {
    if (activeSubjectName != null) {
      ComprehensiveFlashcardRepository.getSetsForSubject(selectedGrade, activeSubjectName!!)
    } else emptyList()
  }

  val cards = remember(selectedGrade, activeSubjectName, selectedSetNumber) {
    if (activeSubjectName != null) {
      ComprehensiveFlashcardRepository.getFlashcards(selectedGrade, activeSubjectName!!, selectedSetNumber)
    } else emptyList()
  }

  var currentIdx by remember(selectedGrade, activeSubjectName, selectedSetNumber) { mutableIntStateOf(0) }
  var isFlipped by remember(selectedGrade, activeSubjectName, selectedSetNumber, currentIdx) { mutableStateOf(false) }
  var masteredCount by remember { mutableIntStateOf(0) }
  var reviewCount by remember { mutableIntStateOf(0) }

  val activeCard = if (cards.isNotEmpty()) cards[currentIdx.coerceIn(0, cards.size - 1)] else null

  Column(
    modifier = Modifier.fillMaxSize()
  ) {
    if (activeSubjectName == null) {
      // =========================================================================
      // INITIAL SCREEN: COLORFUL SUBJECT CARDS GRID
      // =========================================================================
      LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(top = 4.dp, bottom = 100.dp)
      ) {
        item {
          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            border = BorderStroke(1.dp, Color(0xFFF59E0B).copy(alpha = 0.5f))
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text("⚡", fontSize = 18.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                  text = "Interactive Flashcard Q&A",
                  fontSize = 13.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )
              }
              Spacer(modifier = Modifier.height(8.dp))
              Text(
                text = "මතකය වර්ධනය කරගැනීමට Spaced Repetition ක්‍රමය භාවිතයෙන් සකසන ලද Flashcards 400ක්. ආරම්භ කිරීමට පහතින් විෂයක් තෝරන්න.",
                fontSize = 11.5.sp,
                color = Color(0xFFCBD5E1),
                lineHeight = 16.sp
              )
            }
          }
        }

        // Search Bar
        item {
          OutlinedTextField(
            value = subjectSearchQuery,
            onValueChange = { subjectSearchQuery = it },
            placeholder = { Text("විෂය සොයන්න...", fontSize = 12.sp, color = Color(0xFF94A3B8)) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.size(18.dp), tint = Color(0xFF94A3B8)) },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
              focusedContainerColor = Color(0xFF1E293B),
              unfocusedContainerColor = Color(0xFF1E293B),
              focusedBorderColor = Color(0xFFF59E0B),
              unfocusedBorderColor = Color(0xFF334155),
              focusedTextColor = Color.White,
              unfocusedTextColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
          )
        }

        val filtered = if (subjectSearchQuery.isBlank()) shortAnswerSubjectsList else {
          shortAnswerSubjectsList.filter {
            it.subjectName.contains(subjectSearchQuery.trim(), ignoreCase = true) ||
            it.subjectEnglish.contains(subjectSearchQuery.trim(), ignoreCase = true)
          }
        }

        items(filtered.chunked(2)) { pair ->
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            pair.forEach { subjInfo ->
              Box(modifier = Modifier.weight(1f)) {
                QaSubjectMiniCard(
                  category = subjInfo,
                  onClick = {
                    activeSubjectName = subjInfo.subjectName
                    selectedSetNumber = 1
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
      Column(
        modifier = Modifier
          .fillMaxSize()
          .verticalScroll(rememberScrollState())
          .padding(bottom = 40.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        // Horizontal Subject Selector
        Column {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text("විෂය මාරු කරන්න:", fontWeight = FontWeight.Bold, fontSize = 11.sp, color = Color(0xFF94A3B8))
            TextButton(onClick = { activeSubjectName = null }) {
              Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, modifier = Modifier.size(13.dp), tint = Color(0xFFF59E0B))
              Spacer(modifier = Modifier.width(3.dp))
              Text("සියලු විෂයන්", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFF59E0B))
            }
          }
          LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(shortAnswerSubjectsList) { subjInfo ->
              val isSel = activeSubjectName == subjInfo.subjectName
              Surface(
                onClick = { activeSubjectName = subjInfo.subjectName },
                shape = RoundedCornerShape(10.dp),
                color = if (isSel) subjInfo.color else Color(0xFF0F172A),
                border = BorderStroke(1.dp, if (isSel) subjInfo.color else Color(0xFF334155))
              ) {
                Text(
                  text = subjInfo.subjectName,
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = if (isSel) Color.Black else Color.White,
                  modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp)
                )
              }
            }
          }
        }

        Surface(
          shape = RoundedCornerShape(10.dp),
          color = Color(0xFF1E293B),
          border = BorderStroke(1.dp, Color(0xFF334155)),
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
                shape = RoundedCornerShape(8.dp),
                color = if (isSel) Color(0xFFF59E0B) else Color.Transparent,
                modifier = Modifier.weight(1f)
              ) {
                Box(
                  contentAlignment = Alignment.Center,
                  modifier = Modifier.padding(vertical = 6.dp)
                ) {
                  Text(
                    text = "$gr ශ්‍රේණිය",
                    fontSize = 11.5.sp,
                    fontWeight = if (isSel) FontWeight.Bold else FontWeight.Medium,
                    color = if (isSel) Color.Black else Color(0xFF94A3B8)
                  )
                }
              }
            }
          }
        }

    // 3. Set Filter (කාණ්ඩ 20ක් - කාණ්ඩයකට කාඩ්පත් 20 බැගින්)
    LazyRow(
      horizontalArrangement = Arrangement.spacedBy(6.dp),
      modifier = Modifier.fillMaxWidth()
    ) {
      item {
        FilterChip(
          selected = selectedSetNumber == null,
          onClick = { selectedSetNumber = null },
          label = { Text("සියලු 400", fontSize = 10.sp, fontWeight = FontWeight.Bold) },
          colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = Color(0xFF8B5CF6),
            selectedLabelColor = Color.White
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
          label = { Text("කාණ්ඩය $setIdx ($startNum-$endNum)", fontSize = 10.sp) },
          colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = Color(0xFFF59E0B),
            selectedLabelColor = Color.Black
          )
        )
      }
    }

    // Progress and stats bar
    Card(
      shape = RoundedCornerShape(12.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
      border = BorderStroke(1.dp, Color(0xFF334155))
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 12.dp, vertical = 7.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column {
          Text(
            text = "කාඩ්පත: ${if (cards.isEmpty()) 0 else currentIdx + 1} / ${cards.size}",
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFDE68A)
          )
          if (activeCard != null) {
            Text(
              text = "සමස්ත අංකය: ${activeCard.globalIndex} / 400",
              fontSize = 9.sp,
              color = Color(0xFF94A3B8)
            )
          }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
          Surface(
            shape = RoundedCornerShape(6.dp),
            color = Color(0xFF16A34A).copy(alpha = 0.25f)
          ) {
            Text(
              text = "✅ මතකයි: $masteredCount",
              fontSize = 10.sp,
              color = Color(0xFF86EFAC),
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
            )
          }

          Surface(
            shape = RoundedCornerShape(6.dp),
            color = Color(0xFFDC2626).copy(alpha = 0.25f)
          ) {
            Text(
              text = "🔄 නැවත: $reviewCount",
              fontSize = 10.sp,
              color = Color(0xFFFCA5A5),
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
            )
          }
        }
      }
    }

    if (cards.isEmpty() || activeCard == null) {
      Box(modifier = Modifier.fillMaxWidth().height(200.dp), contentAlignment = Alignment.Center) {
        Text("මෙම කාණ්ඩය සඳහා කාඩ්පත් හමු නොවීය.", color = Color(0xFF94A3B8))
      }
    } else {
      // FLIP CARD (Interactive Surface)
      Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
          containerColor = if (!isFlipped) Color(0xFF1E293B) else Color(0xFF0F172A)
        ),
        border = BorderStroke(
          1.8.dp,
          if (!isFlipped) Color(0xFFF59E0B).copy(alpha = 0.8f) else Color(0xFF10B981).copy(alpha = 0.8f)
        ),
        modifier = Modifier
          .fillMaxWidth()
          .heightIn(min = 280.dp)
          .clickable { isFlipped = !isFlipped }
          .testTag("flashcard_surface")
      ) {
        Column(
          modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
          verticalArrangement = Arrangement.SpaceBetween
        ) {
          // Top Card Meta
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFFF59E0B).copy(alpha = 0.2f)
            ) {
              Text(
                text = "${activeCard.subject} • ${activeCard.grade} ශ්‍රේණිය • කාණ්ඩය ${activeCard.setNumber}",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFCD34D),
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
              )
            }

            Surface(
              shape = RoundedCornerShape(6.dp),
              color = if (!isFlipped) Color(0xFF3B82F6).copy(alpha = 0.2f) else Color(0xFF10B981).copy(alpha = 0.2f)
            ) {
              Text(
                text = if (!isFlipped) "❓ ප්‍රශ්නය #${activeCard.cardIndexInSet}/20" else "💡 පිළිතුර & විවරණය",
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Bold,
                color = if (!isFlipped) Color(0xFF93C5FD) else Color(0xFF6EE7B7),
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
              )
            }
          }

          // Center Content (Front or Back)
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 14.dp),
            contentAlignment = Alignment.Center
          ) {
            if (!isFlipped) {
              Column(horizontalAlignment = Alignment.CenterHorizontally) {
                if (activeCard.unitCategory.isNotEmpty()) {
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF334155),
                    modifier = Modifier.padding(bottom = 10.dp)
                  ) {
                    Text(
                      text = "📖 ${activeCard.unitCategory}",
                      fontSize = 10.5.sp,
                      color = Color(0xFFCBD5E1),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                  }
                }
                Text(
                  text = activeCard.questionFront.replace(Regex("""^\[.*?\]\s*"""), ""),
                  fontSize = 15.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  textAlign = TextAlign.Center,
                  lineHeight = 23.sp
                )
                Spacer(modifier = Modifier.height(14.dp))
                Text(
                  text = "👆 පිළිතුර බැලීමට කාඩ්පත මත ඔබන්න (Tap to Flip)",
                  fontSize = 10.5.sp,
                  color = Color(0xFF94A3B8)
                )
              }
            } else {
              Column {
                Text(
                  text = "💡 නිල පිළිතුර:",
                  fontSize = 11.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF34D399)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = activeCard.answerBack,
                  fontSize = 13.5.sp,
                  color = Color.White,
                  lineHeight = 20.sp
                )

                if (activeCard.formulaOrFact.isNotBlank()) {
                  Spacer(modifier = Modifier.height(8.dp))
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF1E293B),
                    border = BorderStroke(1.dp, Color(0xFF475569))
                  ) {
                    Text(
                      text = "📐 ${activeCard.formulaOrFact}",
                      fontSize = 11.sp,
                      fontWeight = FontWeight.SemiBold,
                      color = Color(0xFFFDE047),
                      modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                  }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                  text = "🎯 විභාග ඉඟිය: ${activeCard.explanationTip}",
                  fontSize = 10.5.sp,
                  color = Color(0xFFCBD5E1),
                  lineHeight = 15.sp
                )
              }
            }
          }

          // Bottom Tap Indicator
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
          ) {
            Text(
              text = if (!isFlipped) "🔄 Flip to Reveal Answer" else "🔄 Tap to Flip Back",
              fontSize = 10.sp,
              color = Color(0xFF64748B)
            )
          }
        }
      }

      // Action Buttons: Easy vs Hard & Next
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        Button(
          onClick = {
            reviewCount++
            if (currentIdx < cards.size - 1) currentIdx++ else currentIdx = 0
            isFlipped = false
          },
          modifier = Modifier.weight(1f),
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
          shape = RoundedCornerShape(10.dp)
        ) {
          Text("🔄 නැවත අවශ්‍යයි", fontSize = 11.sp, fontWeight = FontWeight.Bold)
        }

        Button(
          onClick = {
            masteredCount++
            if (currentIdx < cards.size - 1) currentIdx++ else currentIdx = 0
            isFlipped = false
          },
          modifier = Modifier.weight(1f),
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF16A34A)),
          shape = RoundedCornerShape(10.dp)
        ) {
          Text("✅ දනිමි / මතකයි", fontSize = 11.sp, fontWeight = FontWeight.Bold)
        }
      }
    }
  }
}
}
}

// ==============================================================================
// 3. 🎯 O/L DAILY MIXED 10 CHALLENGE
// ==============================================================================

@Composable
fun DailyMixedChallengeSection(
  isFullScreen: Boolean = false,
  onFullScreenToggle: (Boolean) -> Unit = {}
) {
  val context = LocalContext.current
  val prefs = remember { context.getSharedPreferences("ol_daily_quiz_prefs", Context.MODE_PRIVATE) }

  var activeSubjectName by remember { mutableStateOf<String?>(null) }
  var subjectSearchQuery by remember { mutableStateOf("") }
  var selectedSetNumber by remember(activeSubjectName) { mutableIntStateOf(1) }

  // BackHandler to return to selection grid
  BackHandler(enabled = activeSubjectName != null) {
    activeSubjectName = null
  }

  val setsForSubject = remember(activeSubjectName) {
    if (activeSubjectName != null) {
      DailyChallengeMasterRepository.getSetsForSubject(activeSubjectName!!)
    } else emptyList()
  }

  val currentSetInfo = setsForSubject.find { it.setNumber == selectedSetNumber } 
    ?: setsForSubject.firstOrNull() 
    ?: QuestionSetInfo(1, "O/L", "කාණ්ඩය 01", activeSubjectName ?: "", "🎯")

  val questions = remember(activeSubjectName, selectedSetNumber) {
    if (activeSubjectName != null) {
      DailyChallengeMasterRepository.getQuestionsForSet(activeSubjectName!!, selectedSetNumber)
    } else emptyList()
  }

  var currentQIndex by remember(activeSubjectName, selectedSetNumber) { mutableIntStateOf(0) }
  var selectedOption by remember(activeSubjectName, selectedSetNumber, currentQIndex) { mutableStateOf<Int?>(null) }
  var userAnswers by remember(activeSubjectName, selectedSetNumber) { mutableStateOf<Map<Int, Int>>(emptyMap()) }
  var isSubmitted by remember(activeSubjectName, selectedSetNumber) { mutableStateOf(false) }
  var streak by remember { mutableIntStateOf(prefs.getInt("streak_days", 3)) }
  var highScore by remember { mutableIntStateOf(prefs.getInt("high_score", 8)) }

  if (activeSubjectName == null) {
    // =========================================================================
    // INITIAL SCREEN: COLORFUL SUBJECT CARDS GRID
    // =========================================================================
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.spacedBy(12.dp),
      contentPadding = PaddingValues(top = 4.dp, bottom = 100.dp)
    ) {
      item {
        Card(
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.5f))
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text("🎯", fontSize = 18.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                  text = "Daily Mixed 10 Challenge",
                  fontSize = 13.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )
              }
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF10B981)
              ) {
                Text(
                  text = "Streak: $streak දින 🔥",
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.Black,
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
              }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "සෑම දිනකම විෂයයන් කිහිපයකින් සැකසූ මිශ්‍ර ප්‍රශ්න 10කට පිළිතුරු දී ඔබගේ ලකුණු මට්ටම සහ ස්ට්‍රීක් අගය පවත්වා ගන්න. ආරම්භ කිරීමට විෂයක් තෝරන්න.",
              fontSize = 11.5.sp,
              color = Color(0xFFCBD5E1),
              lineHeight = 16.sp
            )
          }
        }
      }

      // Search Bar
      item {
        OutlinedTextField(
          value = subjectSearchQuery,
          onValueChange = { subjectSearchQuery = it },
          placeholder = { Text("විෂය සොයන්න...", fontSize = 12.sp, color = Color(0xFF94A3B8)) },
          leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.size(18.dp), tint = Color(0xFF94A3B8)) },
          singleLine = true,
          shape = RoundedCornerShape(12.dp),
          colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFF1E293B),
            unfocusedContainerColor = Color(0xFF1E293B),
            focusedBorderColor = Color(0xFF10B981),
            unfocusedBorderColor = Color(0xFF334155),
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White
          ),
          modifier = Modifier.fillMaxWidth()
        )
      }

      item {
        // Special "Mixed All" Card
        QaSubjectMiniCard(
          category = ShortAnswerSubjectInfo("සියලුම විෂයයන්", "Mixed Subjects", "🎯", Color(0xFF10B981), "කාණ්ඩ 20", "ප්‍රශ්න 200 • කාණ්ඩ 20", "සියලුම විෂයයන්ගෙන් සැකසූ මිශ්‍ර ප්‍රශ්න"),
          onClick = { 
            activeSubjectName = "සියලුම විෂයයන්"
            selectedSetNumber = 1
            currentQIndex = 0
            userAnswers = emptyMap()
            selectedOption = null
            isSubmitted = false
            onFullScreenToggle(true)
          }
        )
      }

      val filtered = if (subjectSearchQuery.isBlank()) shortAnswerSubjectsList else {
        shortAnswerSubjectsList.filter {
          it.subjectName.contains(subjectSearchQuery.trim(), ignoreCase = true) ||
          it.subjectEnglish.contains(subjectSearchQuery.trim(), ignoreCase = true)
        }
      }

      items(filtered.chunked(2)) { pair ->
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
          pair.forEach { subjInfo ->
            Box(modifier = Modifier.weight(1f)) {
              QaSubjectMiniCard(
                category = subjInfo,
                onClick = {
                  activeSubjectName = subjInfo.subjectName
                  selectedSetNumber = 1
                  currentQIndex = 0
                  userAnswers = emptyMap()
                  selectedOption = null
                  isSubmitted = false
                  onFullScreenToggle(true)
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
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.spacedBy(12.dp),
      contentPadding = PaddingValues(top = 4.dp, bottom = 100.dp)
    ) {
      // 1. Horizontal Subject Selector
      item {
        Column {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text("විෂය මාරු කරන්න:", fontWeight = FontWeight.Bold, fontSize = 11.sp, color = Color(0xFF94A3B8))
            TextButton(onClick = { 
              activeSubjectName = null 
              onFullScreenToggle(false)
            }) {
              Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, modifier = Modifier.size(13.dp), tint = Color(0xFF10B981))
              Spacer(modifier = Modifier.width(3.dp))
              Text("සියලු විෂයන්", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF10B981))
            }
          }
          LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            item {
              val isSel = activeSubjectName == "සියලුම විෂයයන්"
              Surface(
                onClick = { 
                  activeSubjectName = "සියලුම විෂයයන්"
                  selectedSetNumber = 1
                  currentQIndex = 0
                  userAnswers = emptyMap()
                  selectedOption = null
                  isSubmitted = false
                },
                shape = RoundedCornerShape(10.dp),
                color = if (isSel) Color(0xFF10B981) else Color(0xFF0F172A),
                border = BorderStroke(1.dp, if (isSel) Color(0xFF10B981) else Color(0xFF334155))
              ) {
                Text(
                  text = "සියල්ල",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = if (isSel) Color.Black else Color.White,
                  modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp)
                )
              }
            }
            items(shortAnswerSubjectsList) { subjInfo ->
              val isSel = activeSubjectName == subjInfo.subjectName
              Surface(
                onClick = { 
                  activeSubjectName = subjInfo.subjectName
                  selectedSetNumber = 1
                  currentQIndex = 0
                  userAnswers = emptyMap()
                  selectedOption = null
                  isSubmitted = false
                },
                shape = RoundedCornerShape(10.dp),
                color = if (isSel) subjInfo.color else Color(0xFF0F172A),
                border = BorderStroke(1.dp, if (isSel) subjInfo.color else Color(0xFF334155))
              ) {
                Text(
                  text = subjInfo.subjectName,
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = if (isSel) Color.Black else Color.White,
                  modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp)
                )
              }
            }
          }
        }
      }

      // 2. Category / Set Selector Card (20 Categories)
      item {
        Card(
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFF334155))
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = "${activeSubjectName} ප්‍රශ්න කාණ්ඩය (කාණ්ඩ 20):",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Surface(
                shape = RoundedCornerShape(6.dp),
                color = Color(0xFF10B981).copy(alpha = 0.2f)
              ) {
                Text(
                  text = "කාණ්ඩය ${String.format("%02d", selectedSetNumber)} / 20",
                  fontSize = 10.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF34D399),
                  modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Horizontally Scrollable 20 Categories Row
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
              items(setsForSubject) { setInfo ->
                val isSetSel = setInfo.setNumber == selectedSetNumber
                Surface(
                  onClick = {
                    selectedSetNumber = setInfo.setNumber
                    currentQIndex = 0
                    userAnswers = emptyMap()
                    selectedOption = null
                    isSubmitted = false
                  },
                  shape = RoundedCornerShape(10.dp),
                  color = if (isSetSel) Color(0xFF047857) else Color(0xFF0F172A),
                  border = BorderStroke(1.2.dp, if (isSetSel) Color(0xFF34D399) else Color(0xFF334155)),
                  modifier = Modifier.testTag("daily_set_${setInfo.setNumber}")
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 7.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(
                      text = setInfo.icon,
                      fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                      text = setInfo.titleSinhala,
                      fontSize = 11.sp,
                      fontWeight = if (isSetSel) FontWeight.Bold else FontWeight.Medium,
                      color = if (isSetSel) Color.White else Color(0xFFCBD5E1)
                    )
                  }
                }
              }
            }
          }
        }
      }

    if (!isSubmitted && questions.isNotEmpty()) {
      val q = questions[currentQIndex.coerceIn(0, questions.size - 1)]

      item {
        Card(
          shape = RoundedCornerShape(14.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.5f))
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text("🔥", fontSize = 18.sp)
              Spacer(modifier = Modifier.width(6.dp))
              Column {
                Text(
                  text = "${activeSubjectName ?: "සියලුම විෂයයන්"} • ${currentSetInfo.titleSinhala}",
                  fontSize = 11.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF34D399),
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
                Text(
                  text = "ඉහළම ලකුණු: $highScore/10 • කාණ්ඩය ${String.format("%02d", selectedSetNumber)}",
                  fontSize = 10.sp,
                  color = Color(0xFF94A3B8)
                )
              }
            }

            Surface(
              shape = RoundedCornerShape(8.dp),
              color = Color(0xFF10B981).copy(alpha = 0.2f)
            ) {
              Text(
                text = "ප්‍රශ්න ${currentQIndex + 1} / ${questions.size}",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6EE7B7),
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
              )
            }
          }
        }
      }

      item {
        LinearProgressIndicator(
          progress = { (currentQIndex + 1).toFloat() / questions.size.toFloat() },
          modifier = Modifier
            .fillMaxWidth()
            .height(6.dp)
            .clip(RoundedCornerShape(3.dp)),
          color = Color(0xFF10B981),
          trackColor = Color(0xFF334155)
        )
      }

      item {
        Card(
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
          border = BorderStroke(1.dp, Color(0xFF334155))
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFF0D9488).copy(alpha = 0.25f)
            ) {
              Text(
                text = q.subject,
                fontSize = 10.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2DD4BF),
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
              )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(
              text = q.question,
              fontSize = 13.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White,
              lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            q.options.forEachIndexed { optIndex, optText ->
              val isSelected = selectedOption == optIndex
              Surface(
                shape = RoundedCornerShape(10.dp),
                color = if (isSelected) Color(0xFF065F46) else Color(0xFF1E293B),
                border = BorderStroke(
                  1.dp,
                  if (isSelected) Color(0xFF34D399) else Color(0xFF475569)
                ),
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(vertical = 4.dp)
                  .clickable { selectedOption = optIndex }
              ) {
                Row(
                  modifier = Modifier.padding(12.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Surface(
                    shape = CircleShape,
                    color = if (isSelected) Color(0xFF34D399) else Color(0xFF334155),
                    modifier = Modifier.size(24.dp)
                  ) {
                    Box(contentAlignment = Alignment.Center) {
                      Text(
                        text = "${optIndex + 1}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isSelected) Color.Black else Color.White
                      )
                    }
                  }
                  Spacer(modifier = Modifier.width(10.dp))
                  Text(
                    text = optText,
                    fontSize = 12.sp,
                    color = Color.White
                  )
                }
              }
            }
          }
        }
      }

      item {
        Button(
          onClick = {
            if (selectedOption != null) {
              val updated = userAnswers.toMutableMap()
              updated[currentQIndex] = selectedOption!!
              userAnswers = updated
              selectedOption = null

              if (currentQIndex < questions.size - 1) {
                currentQIndex++
              } else {
                isSubmitted = true
                val correct = questions.indices.count { idx -> userAnswers[idx] == questions[idx].correctIndex }
                if (correct > highScore) {
                  highScore = correct
                  prefs.edit().putInt("high_score", correct).apply()
                }
                val newStreak = streak + 1
                prefs.edit().putInt("streak_days", newStreak).apply()
                streak = newStreak
              }
            }
          },
          enabled = selectedOption != null,
          modifier = Modifier
            .fillMaxWidth()
            .testTag("daily_challenge_next_btn"),
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
          shape = RoundedCornerShape(10.dp)
        ) {
          Text(
            text = if (currentQIndex < questions.size - 1) "මීළඟ ප්‍රශ්නය ➔" else "ප්‍රතිඵල බලන්න (Submit) 🏁",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
          )
        }
      }
    } else if (isSubmitted) {
      val correctCount = questions.indices.count { idx -> userAnswers[idx] == questions[idx].correctIndex }
      val percentage = if (questions.isNotEmpty()) (correctCount * 100) / questions.size else 0

      item {
        Card(
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF064E3B)),
          border = BorderStroke(1.5.dp, Color(0xFF10B981))
        ) {
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text("🎉 අභියෝගය සම්පූර්ණයි!", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "${activeSubjectName ?: "සියලුම විෂයයන්"} • ${currentSetInfo.titleSinhala}",
              fontSize = 11.5.sp,
              color = Color(0xFFA7F3D0)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "$correctCount / ${questions.size}",
              fontSize = 32.sp,
              fontWeight = FontWeight.ExtraBold,
              color = Color(0xFF34D399)
            )
            Text(
              text = "නිරවද්‍යතාවය: $percentage% • Streak: $streak Days 🔥",
              fontSize = 12.sp,
              color = Color(0xFFA7F3D0)
            )

            Spacer(modifier = Modifier.height(14.dp))
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              Button(
                onClick = {
                  isSubmitted = false
                  currentQIndex = 0
                  userAnswers = emptyMap()
                  selectedOption = null
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f)
              ) {
                Text("නැවත කරන්න (Retake)", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 11.sp)
              }

              if (selectedSetNumber < 20) {
                Button(
                  onClick = {
                    selectedSetNumber++
                    isSubmitted = false
                    currentQIndex = 0
                    userAnswers = emptyMap()
                    selectedOption = null
                  },
                  colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
                  shape = RoundedCornerShape(8.dp),
                  modifier = Modifier.weight(1f)
                ) {
                  Text("මීළඟ කාණ්ඩය (${String.format("%02d", selectedSetNumber + 1)}) ➔", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 11.sp)
                }
              }
            }
          }
        }
      }

      item {
        Text(
          text = "විවරණ සහ නිවැරදි පිළිතුරු (Detailed Solutions):",
          fontSize = 13.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White
        )
      }

      itemsIndexed(questions) { idx, q ->
        val userAns = userAnswers[idx]
        val isCorrect = userAns == q.correctIndex

        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, if (isCorrect) Color(0xFF16A34A) else Color(0xFFDC2626))
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Text(
                text = "Q${idx + 1}. ${q.subject}",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF94A3B8)
              )
              Text(
                text = if (isCorrect) "✅ නිවැරදියි (+1)" else "❌ වැරදියි (0)",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = if (isCorrect) Color(0xFF86EFAC) else Color(0xFFFCA5A5)
              )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = q.question, fontSize = 12.5.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "නිවැරදි පිළිතුර: ${q.options[q.correctIndex]}",
              fontSize = 11.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF34D399)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
              text = "විවරණය: ${q.explanation}",
              fontSize = 11.sp,
              color = Color(0xFFCBD5E1)
            )
          }
        }
      }
    }
  }
}
}

// ==============================================================================
// 4. 🧩 MATCH THE FOLLOWING & TIMELINE ORDERING
// ==============================================================================

@Composable
fun MatchingAndOrderingSection(
  isFullScreen: Boolean = false,
  onFullScreenToggle: (Boolean) -> Unit = {}
) {
  var activeSubjectName by remember { mutableStateOf<String?>(null) }
  var subTab by remember { mutableIntStateOf(0) } // 0 = Matching, 1 = Timeline
  var subjectSearchQuery by remember { mutableStateOf("") }

  // BackHandler to return to selection grid
  BackHandler(enabled = activeSubjectName != null) {
    activeSubjectName = null
  }

  if (activeSubjectName == null) {
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.spacedBy(12.dp),
      contentPadding = PaddingValues(top = 4.dp, bottom = 100.dp)
    ) {
      item {
        Card(
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFF8B5CF6).copy(alpha = 0.5f))
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text("🧩", fontSize = 18.sp)
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = "Matching & Timeline Ordering",
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "විෂය කරුණු නිවැරදිව ගලපා කාලරේඛාවන් මත පෙළගස්වන්න. ආරම්භ කිරීමට පහතින් විෂයක් තෝරන්න.",
              fontSize = 11.5.sp,
              color = Color(0xFFCBD5E1),
              lineHeight = 16.sp
            )
          }
        }
      }

      item {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          Button(
            onClick = { subTab = 0 },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(containerColor = if (subTab == 0) Color(0xFF8B5CF6) else Color(0xFF1E293B)),
            shape = RoundedCornerShape(10.dp)
          ) {
            Text("🔗 ගැලපීම්", fontSize = 11.sp, fontWeight = FontWeight.Bold)
          }
          Button(
            onClick = { subTab = 1 },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(containerColor = if (subTab == 1) Color(0xFF8B5CF6) else Color(0xFF1E293B)),
            shape = RoundedCornerShape(10.dp)
          ) {
            Text("⏳ කාලරේඛාව", fontSize = 11.sp, fontWeight = FontWeight.Bold)
          }
        }
      }

      val bankSubjects = if (subTab == 0) {
        InteractiveMatchingAndTimelineBank.matchSets.map { it.subject }.distinct()
      } else {
        InteractiveMatchingAndTimelineBank.timelineSets.map { it.subject }.distinct()
      }

      val filtered = if (subjectSearchQuery.isBlank()) bankSubjects else {
        bankSubjects.filter { it.contains(subjectSearchQuery.trim(), ignoreCase = true) }
      }

      items(filtered.chunked(2)) { pair ->
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
          pair.forEach { subjName ->
            val icon = if (subTab == 0) {
              InteractiveMatchingAndTimelineBank.matchSets.find { it.subject == subjName }?.icon ?: "🧩"
            } else {
              InteractiveMatchingAndTimelineBank.timelineSets.find { it.subject == subjName }?.icon ?: "⏳"
            }
            
            Box(modifier = Modifier.weight(1f)) {
              QaSubjectMiniCard(
                category = ShortAnswerSubjectInfo(
                  subjectName = subjName,
                  subjectEnglish = if (subTab == 0) "Matching" else "Timeline",
                  icon = icon,
                  color = Color(0xFF8B5CF6),
                  badge = if (subTab == 0) "1000 Qs" else "TIME",
                  setsCountDesc = if (subTab == 0) "කාණ්ඩ 100 • ප්‍රශ්න 1000" else "අභ්‍යාස • කාලරේඛා",
                  unitsSummaryBrief = if (subTab == 0) "100x10 කාණ්ඩ ක්‍රමය (ප්‍රශ්න 1000)" else "විෂය කරුණු නිවැරදිව පෙළගැස්වීම"
                ),
                onClick = { 
                  activeSubjectName = subjName
                  onFullScreenToggle(true)
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
    Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text("විෂය: $activeSubjectName", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color.White)
        TextButton(onClick = { 
          activeSubjectName = null 
          onFullScreenToggle(false)
        }) {
          Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, modifier = Modifier.size(13.dp), tint = Color(0xFF8B5CF6))
          Spacer(modifier = Modifier.width(3.dp))
          Text("සියලු විෂයන්", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF8B5CF6))
        }
      }

      if (subTab == 0) {
        val subjectSets = InteractiveMatchingAndTimelineBank.matchSets.filter { it.subject == activeSubjectName }
        var selectedSetIndex by remember(activeSubjectName) { mutableIntStateOf(0) }
        
        if (subjectSets.size > 1) {
          Column {
            Text(
              text = "කාණ්ඩය තෝරන්න (Select Group):",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF94A3B8),
              modifier = Modifier.padding(bottom = 6.dp)
            )
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
              itemsIndexed(subjectSets) { idx, set ->
                val isSelected = selectedSetIndex == idx
                Surface(
                  onClick = { selectedSetIndex = idx },
                  shape = RoundedCornerShape(10.dp),
                  color = if (isSelected) Color(0xFF8B5CF6) else Color(0xFF1E293B),
                  border = BorderStroke(1.dp, if (isSelected) Color.White else Color(0xFF334155)),
                  modifier = Modifier.testTag("match_group_btn_$idx")
                ) {
                  Text(
                    text = "කාණ්ඩය ${idx + 1}",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isSelected) Color.White else Color(0xFFCBD5E1),
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp)
                  )
                }
              }
            }
            Spacer(modifier = Modifier.height(8.dp))
          }
        }

        val matchSet = subjectSets.getOrNull(selectedSetIndex)
        if (matchSet != null) {
          Box(modifier = Modifier.weight(1f).fillMaxWidth()) {
            key(matchSet.title) {
              MatchingGameView(matchSet, onBack = { 
                activeSubjectName = null 
                onFullScreenToggle(false)
              })
            }
          }
        }
      } else {
        val subjectSets = InteractiveMatchingAndTimelineBank.timelineSets.filter { it.subject == activeSubjectName }
        var selectedSetIndex by remember(activeSubjectName) { mutableIntStateOf(0) }

        if (subjectSets.size > 1) {
           Column {
            Text(
              text = "කාණ්ඩය තෝරන්න (Select Group):",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF94A3B8),
              modifier = Modifier.padding(bottom = 6.dp)
            )
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
              itemsIndexed(subjectSets) { idx, set ->
                val isSelected = selectedSetIndex == idx
                Surface(
                  onClick = { selectedSetIndex = idx },
                  shape = RoundedCornerShape(10.dp),
                  color = if (isSelected) Color(0xFF8B5CF6) else Color(0xFF1E293B),
                  border = BorderStroke(1.dp, if (isSelected) Color.White else Color(0xFF334155)),
                  modifier = Modifier.testTag("timeline_group_btn_$idx")
                ) {
                  Text(
                    text = "කාණ්ඩය ${idx + 1}",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isSelected) Color.White else Color(0xFFCBD5E1),
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp)
                  )
                }
              }
            }
            Spacer(modifier = Modifier.height(8.dp))
          }
        }

        val timelineSet = subjectSets.getOrNull(selectedSetIndex)
        if (timelineSet != null) {
          Box(modifier = Modifier.weight(1f).fillMaxWidth()) {
            key(timelineSet.title) {
              TimelineOrderingView(timelineSet, onBack = { 
                activeSubjectName = null 
                onFullScreenToggle(false)
              })
            }
          }
        }
      }
    }
  }
}

@Composable
fun TrueFalseWithJustificationSection(
  isFullScreen: Boolean = false,
  onFullScreenToggle: (Boolean) -> Unit = {}
) {
  var activeSubjectName by remember { mutableStateOf<String?>("විද්‍යාව (Science)") }
  var subjectSearchQuery by remember { mutableStateOf("") }

  LaunchedEffect(Unit) {
    onFullScreenToggle(false)
  }

  // BackHandler
  BackHandler(enabled = activeSubjectName != null) {
    activeSubjectName = null
    onFullScreenToggle(false)
  }

  if (activeSubjectName == null) {
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.spacedBy(12.dp),
      contentPadding = PaddingValues(top = 4.dp, bottom = 100.dp)
    ) {
      item {
        Card(
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFFEC4899).copy(alpha = 0.5f))
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text("⚖️", fontSize = 18.sp)
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = "සත්‍ය / අසත්‍ය (Deep Justification)",
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "ප්‍රකාශනයක සත්‍ය අසත්‍යතාවය හඳුනාගෙන එයට හේතුව තේරුම් ගන්න. ආරම්භ කිරීමට විෂයක් තෝරන්න.",
              fontSize = 11.5.sp,
              color = Color(0xFFCBD5E1),
              lineHeight = 16.sp
            )
          }
        }
      }

      val filtered = if (subjectSearchQuery.isBlank()) TrueFalseSubject.values().toList() else {
        TrueFalseSubject.values().filter {
          it.displayName.contains(subjectSearchQuery.trim(), ignoreCase = true) ||
          it.id.contains(subjectSearchQuery.trim(), ignoreCase = true)
        }
      }

      items(filtered.chunked(2)) { pair ->
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
          pair.forEach { subject ->
            Box(modifier = Modifier.weight(1f)) {
              QaSubjectMiniCard(
                category = ShortAnswerSubjectInfo(
                  subjectName = subject.displayName,
                  subjectEnglish = subject.id,
                  icon = subject.iconEmoji,
                  color = subject.primaryColor,
                  badge = "TF",
                  setsCountDesc = "ප්‍රශ්න 500",
                  unitsSummaryBrief = "සත්‍ය/අසත්‍ය හා ගැඹුරු හේතු"
                ),
                onClick = { 
                  activeSubjectName = subject.displayName
                  onFullScreenToggle(true)
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
    val subject = TrueFalseSubject.values().find { it.displayName == activeSubjectName }
    if (subject != null) {
      TrueFalse500Content(
        initialSubject = subject,
        isFullScreen = isFullScreen,
        onFullScreenToggle = onFullScreenToggle,
        onBack = { 
          activeSubjectName = null 
          onFullScreenToggle(false)
        }
      )
    }
  }
}

@Composable
fun MatchingGameView(matchSet: SubjectMatchSet, onBack: () -> Unit) {
  val matchData = matchSet.items
  val shuffledRight = remember(matchSet.title) { matchData.map { it.rightCorrectText }.shuffled() }
  var selectedLeft by remember(matchSet.title) { mutableStateOf<String?>(null) }
  var studentPairs by remember(matchSet.title) { mutableStateOf<Map<String, String>>(emptyMap()) }
  var isChecked by remember(matchSet.title) { mutableStateOf(false) }

  val dims = rememberScreenDimensions()
  val isCompact = dims.isSmallWidth

  val selectedLeftIndex = if (selectedLeft != null) {
    matchData.indexOfFirst { it.leftText == selectedLeft } + 1
  } else -1

  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    contentPadding = PaddingValues(bottom = 80.dp),
    verticalArrangement = Arrangement.spacedBy(if (isCompact) 4.dp else 6.dp)
  ) {
    // Header
    item {
      Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFF8B5CF6).copy(alpha = 0.5f))
      ) {
        Column(modifier = Modifier.padding(horizontal = if (isCompact) 8.dp else 10.dp, vertical = if (isCompact) 5.dp else 7.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Column(modifier = Modifier.weight(1f)) {
              Text(
                text = "${matchSet.icon} ${matchSet.subject}",
                fontSize = if (isCompact) 9.5.sp else 10.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFA78BFA)
              )
              Text(
                text = matchSet.title,
                fontSize = if (isCompact) 11.sp else 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
            }

            OutlinedButton(
              onClick = onBack,
              shape = RoundedCornerShape(8.dp),
              border = BorderStroke(1.dp, Color(0xFF8B5CF6)),
              contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp),
              modifier = Modifier.height(26.dp)
            ) {
              Text("⬅️ වෙනත් විෂයයක්", fontSize = if (isCompact) 8.5.sp else 9.5.sp, color = Color(0xFFC4B5FD))
            }
          }
        }
      }
    }

    // Direct Two-Column Matching View (තීරු දෙකම එකවර පෙන්වන පූර්ණ මුහුණත)
    if (selectedLeft != null) {
      item {
        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFF5B21B6),
          border = BorderStroke(1.dp, Color(0xFFA78BFA)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text("🎯", fontSize = 11.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Column(modifier = Modifier.weight(1f)) {
              Text(
                text = "තෝරාගත් ප්‍රශ්න අංක $selectedLeftIndex (B තීරුවෙන් පිළිතුර මත ඔබන්න):",
                fontSize = 8.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFDDD6FE)
              )
              Text(
                text = selectedLeft!!,
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
              )
            }
            Spacer(modifier = Modifier.width(4.dp))
            Surface(
              onClick = { selectedLeft = null },
              shape = CircleShape,
              color = Color.White.copy(alpha = 0.2f),
              modifier = Modifier.size(20.dp)
            ) {
              Box(contentAlignment = Alignment.Center) {
                Text("✕", fontSize = 10.sp, color = Color.White, fontWeight = FontWeight.Bold)
              }
            }
          }
        }
      }
    } else {
      item {
        Surface(
          shape = RoundedCornerShape(6.dp),
          color = Color(0xFF1E293B),
          border = BorderStroke(0.8.dp, Color(0xFF334155)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Text(
            text = "💡 A තීරුවෙන් ප්‍රශ්නයක් තෝරා, B තීරුවෙන් ඊට ගැළපෙන පිළිතුර මත ඔබන්න.",
            fontSize = if (isCompact) 8.5.sp else 9.5.sp,
            color = Color(0xFF94A3B8),
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            textAlign = TextAlign.Center
          )
        }
      }
    }

    item {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(if (isCompact) 4.dp else 6.dp)
      ) {
        // Left Column (A තීරුව - ප්‍රශ්න 10)
        Column(
          modifier = Modifier.weight(1f),
          verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
          Surface(
            shape = RoundedCornerShape(6.dp),
            color = Color(0xFF8B5CF6).copy(alpha = 0.25f),
            modifier = Modifier.fillMaxWidth()
          ) {
            Text(
              text = "A තීරුව (ප්‍රශ්න)",
              fontSize = if (isCompact) 9.sp else 10.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFC4B5FD),
              modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp),
              textAlign = TextAlign.Center
            )
          }

          matchData.forEachIndexed { itemIdx, item ->
            val itemNum = itemIdx + 1
            val isSelected = selectedLeft == item.leftText
            val pairedWith = studentPairs[item.leftText]
            val isCorrect = pairedWith == item.rightCorrectText

            Surface(
              shape = RoundedCornerShape(7.dp),
              color = when {
                isChecked && isCorrect -> Color(0xFF065F46)
                isChecked && pairedWith != null && !isCorrect -> Color(0xFF7F1D1D)
                isSelected -> Color(0xFF6D28D9)
                pairedWith != null -> Color(0xFF1E1B4B)
                else -> Color(0xFF1E293B)
              },
              border = BorderStroke(
                if (isSelected) 1.5.dp else 1.dp,
                when {
                  isChecked && isCorrect -> Color(0xFF34D399)
                  isChecked && pairedWith != null && !isCorrect -> Color(0xFFF87171)
                  isSelected -> Color(0xFFA78BFA)
                  pairedWith != null -> Color(0xFF818CF8)
                  else -> Color(0xFF334155)
                }
              ),
              modifier = Modifier
                .fillMaxWidth()
                .clickable {
                  selectedLeft = if (selectedLeft == item.leftText) null else item.leftText
                }
                .testTag("match_left_${item.id}")
            ) {
              Column(modifier = Modifier.padding(horizontal = if (isCompact) 4.dp else 6.dp, vertical = 5.dp)) {
                Row(verticalAlignment = Alignment.Top) {
                  Text(
                    text = "$itemNum. ",
                    fontSize = if (isCompact) 8.5.sp else 9.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFA78BFA)
                  )
                  Text(
                    text = item.leftText,
                    fontSize = if (isCompact) 8.5.sp else 9.5.sp,
                    lineHeight = if (isCompact) 11.5.sp else 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                  )
                }
                if (pairedWith != null) {
                  Spacer(modifier = Modifier.height(3.dp))
                  Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = Color.Black.copy(alpha = 0.4f),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Row(
                      modifier = Modifier.padding(horizontal = 3.dp, vertical = 2.dp),
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Text(
                        text = "➔ $pairedWith",
                        fontSize = 8.sp,
                        lineHeight = 10.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        color = if (isChecked) {
                          if (isCorrect) Color(0xFF86EFAC) else Color(0xFFFCA5A5)
                        } else Color(0xFFDDD6FE),
                        modifier = Modifier.weight(1f)
                      )
                      Spacer(modifier = Modifier.width(2.dp))
                      Text(
                        text = "✕",
                        fontSize = 8.sp,
                        color = Color(0xFFFCA5A5),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {
                          val updated = studentPairs.toMutableMap()
                          updated.remove(item.leftText)
                          studentPairs = updated
                          isChecked = false
                        }
                      )
                    }
                  }
                }
              }
            }
          }
        }

        // Right Column (B තීරුව - පිළිතුරු 10)
        Column(
          modifier = Modifier.weight(1f),
          verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
          Surface(
            shape = RoundedCornerShape(6.dp),
            color = Color(0xFF38BDF8).copy(alpha = 0.25f),
            modifier = Modifier.fillMaxWidth()
          ) {
            Text(
              text = "B තීරුව (පිළිතුරු)",
              fontSize = if (isCompact) 9.sp else 10.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFBAE6FD),
              modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp),
              textAlign = TextAlign.Center
            )
          }

          shuffledRight.forEach { rightText ->
            val pairedKey = studentPairs.entries.find { it.value == rightText }?.key
            val isAlreadyPaired = pairedKey != null
            val pairedQNum = if (pairedKey != null) {
              matchData.indexOfFirst { it.leftText == pairedKey } + 1
            } else null

            Surface(
              shape = RoundedCornerShape(7.dp),
              color = when {
                selectedLeft != null && !isAlreadyPaired -> Color(0xFF1E293B)
                isAlreadyPaired -> Color(0xFF0F172A)
                else -> Color(0xFF1E293B)
              },
              border = BorderStroke(
                if (selectedLeft != null && !isAlreadyPaired) 1.5.dp else 1.dp,
                when {
                  selectedLeft != null && !isAlreadyPaired -> Color(0xFF38BDF8)
                  isAlreadyPaired -> Color(0xFF475569)
                  else -> Color(0xFF334155)
                }
              ),
              modifier = Modifier
                .fillMaxWidth()
                .clickable {
                  if (selectedLeft != null) {
                    val updated = studentPairs.toMutableMap()
                    val previousKey = updated.entries.find { it.value == rightText }?.key
                    if (previousKey != null) {
                      updated.remove(previousKey)
                    }
                    updated[selectedLeft!!] = rightText
                    studentPairs = updated
                    selectedLeft = null
                    isChecked = false
                  }
                }
            ) {
              Column(modifier = Modifier.padding(horizontal = if (isCompact) 4.dp else 6.dp, vertical = 5.dp)) {
                Text(
                  text = rightText,
                  fontSize = if (isCompact) 8.5.sp else 9.5.sp,
                  lineHeight = if (isCompact) 11.5.sp else 13.sp,
                  color = if (isAlreadyPaired) Color(0xFF94A3B8) else Color.White
                )
                if (isAlreadyPaired && pairedQNum != null) {
                  Spacer(modifier = Modifier.height(2.dp))
                  Text(
                    text = "✓ [ප්‍රශ්න $pairedQNum ට ගැළපුවා]",
                    fontSize = 7.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF34D399)
                  )
                } else if (selectedLeft != null) {
                  Spacer(modifier = Modifier.height(2.dp))
                  Text(
                    text = "තෝරන්න ➔",
                    fontSize = 7.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF38BDF8)
                  )
                }
              }
            }
          }
        }
      }
    }

    item {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        val allPaired = studentPairs.size == matchData.size
        Button(
          onClick = { isChecked = true },
          enabled = studentPairs.isNotEmpty(),
          modifier = Modifier.weight(1f).height(if (isCompact) 34.dp else 38.dp),
          colors = ButtonDefaults.buttonColors(
            containerColor = if (allPaired) Color(0xFF10B981) else Color(0xFF8B5CF6)
          ),
          shape = RoundedCornerShape(8.dp),
          contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp)
        ) {
          Text(
            text = if (allPaired) "පරීක්ෂා කරන්න (සියල්ල ගැලපුවා)" else "පරීක්ෂා කරන්න (${studentPairs.size}/${matchData.size})",
            fontSize = if (isCompact) 9.5.sp else 11.sp,
            fontWeight = FontWeight.Bold
          )
        }

        OutlinedButton(
          onClick = {
            studentPairs = emptyMap()
            selectedLeft = null
            isChecked = false
          },
          shape = RoundedCornerShape(8.dp),
          colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFCBD5E1)),
          contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
          modifier = Modifier.height(if (isCompact) 34.dp else 38.dp)
        ) {
          Text("නැවත සකසන්න", fontSize = if (isCompact) 9.5.sp else 10.5.sp)
        }
      }
    }

    if (isChecked) {
      item {
        val correctCount = matchData.count { studentPairs[it.leftText] == it.rightCorrectText }
        val isAllCorrect = correctCount == matchData.size
        Card(
          shape = RoundedCornerShape(10.dp),
          colors = CardDefaults.cardColors(
            containerColor = if (isAllCorrect) Color(0xFF064E3B) else Color(0xFF1E293B)
          ),
          border = BorderStroke(1.2.dp, if (isAllCorrect) Color(0xFF10B981) else Color(0xFF8B5CF6)),
          modifier = Modifier.fillMaxWidth().testTag("matching_result_card")
        ) {
          Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text(
              text = if (isAllCorrect) "🎉 විශිෂ්ටයි! සියලු ගැලපීම් 10 ම 100% ක් නිවැරදියි!" else "📊 ප්‍රතිඵලය: ලකුණු $correctCount / ${matchData.size} ක් නිවැරදියි",
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = if (isAllCorrect) 
                "ඔබ මෙම කාණ්ඩය සාර්ථකව අවසන් කළා! ඉහළින් වෙනත් කාණ්ඩයක් තෝරා පුහුණු වන්න."
              else 
                "කොළ පැහැයෙන් නිවැරදි ගැලපීම්ද, රතු පැහැයෙන් වැරදි ගැලපීම්ද දැක්වේ. නැවත උත්සාහ කිරීමට 'නැවත සකසන්න' ඔබන්න.",
              fontSize = 10.sp,
              color = Color(0xFFCBD5E1),
              textAlign = TextAlign.Center
            )
          }
        }
      }
    }
  }
}

@Composable
fun TimelineOrderingView(timelineSet: SubjectTimelineSet, onBack: () -> Unit) {
  var currentList by remember(timelineSet.title) { mutableStateOf(timelineSet.items.shuffled()) }
  var isChecked by remember(timelineSet.title) { mutableStateOf(false) }

  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    contentPadding = PaddingValues(bottom = 80.dp),
    verticalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFF8B5CF6).copy(alpha = 0.5f))
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "⏳ ${timelineSet.icon} ${timelineSet.subject} - ${timelineSet.title}",
              fontSize = 12.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White,
              modifier = Modifier.weight(1f)
            )

            OutlinedButton(
              onClick = onBack,
              shape = RoundedCornerShape(8.dp),
              border = BorderStroke(1.dp, Color(0xFF8B5CF6)),
              contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
            ) {
              Text("⬅️ වෙනත් විෂයයක්", fontSize = 10.sp, color = Color(0xFFC4B5FD))
            }
          }
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "ඉහළ/පහළ ඊතල (▲ / ▼) භාවිතයෙන් සිදුවීම් මුල සිට අගට නිවැරදි අනුපිළිවෙලට සකසන්න.",
            fontSize = 11.sp,
            color = Color(0xFFCBD5E1)
          )
        }
      }
    }

    itemsIndexed(currentList) { idx, item ->
      val isCorrectOrder = item.correctOrder == (idx + 1)

      Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
          containerColor = if (isChecked) {
            if (isCorrectOrder) Color(0xFF064E3B) else Color(0xFF7F1D1D)
          } else Color(0xFF0F172A)
        ),
        border = BorderStroke(
          1.dp,
          if (isChecked) {
            if (isCorrectOrder) Color(0xFF10B981) else Color(0xFFEF4444)
          } else Color(0xFF334155)
        )
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Surface(
              shape = CircleShape,
              color = Color(0xFF8B5CF6),
              modifier = Modifier.size(24.dp)
            ) {
              Box(contentAlignment = Alignment.Center) {
                Text("${idx + 1}", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column {
              Text(item.eventText, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
              if (isChecked) {
                Text("වකවානුව: ${item.eraYear}", fontSize = 10.sp, color = Color(0xFFE9D5FF))
              }
            }
          }

          Row {
            IconButton(
              onClick = {
                if (idx > 0) {
                  val list = currentList.toMutableList()
                  val temp = list[idx]
                  list[idx] = list[idx - 1]
                  list[idx - 1] = temp
                  currentList = list
                  isChecked = false
                }
              },
              enabled = idx > 0
            ) {
              Text("▲", fontSize = 14.sp, color = if (idx > 0) Color.White else Color(0xFF475569))
            }

            IconButton(
              onClick = {
                if (idx < currentList.size - 1) {
                  val list = currentList.toMutableList()
                  val temp = list[idx]
                  list[idx] = list[idx + 1]
                  list[idx + 1] = temp
                  currentList = list
                  isChecked = false
                }
              },
              enabled = idx < currentList.size - 1
            ) {
              Text("▼", fontSize = 14.sp, color = if (idx < currentList.size - 1) Color.White else Color(0xFF475569))
            }
          }
        }
      }
    }

    item {
      Button(
        onClick = { isChecked = true },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8B5CF6)),
        shape = RoundedCornerShape(8.dp)
      ) {
        Text("අනුපිළිවෙල පරීක්ෂා කරන්න (Check Timeline)", fontSize = 12.sp, fontWeight = FontWeight.Bold)
      }
    }
  }
}

// ==============================================================================
// 5. ❌/✔️ TRUE/FALSE WITH DEEP JUSTIFICATION
// ==============================================================================

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TrueFalse500Content(
  initialSubject: TrueFalseSubject,
  isFullScreen: Boolean = false,
  onFullScreenToggle: (Boolean) -> Unit = {},
  onBack: () -> Unit
) {
  val context = LocalContext.current

  // State: Grade selection (9, 10, 11)
  var selectedGrade by remember { mutableIntStateOf(11) }

  // State: Subject selection (initialized from parameter, but can be changed via chips)
  var selectedSubject by remember(initialSubject) { mutableStateOf(initialSubject) }

  // State: Batch selection (0 to 16, i.e., 17 batches of 30 questions for total 500 questions)
  var selectedBatchIndex by remember { mutableIntStateOf(0) }

  // State: Question index within current batch (0 until batch size)
  var questionIndexInBatch by remember { mutableIntStateOf(0) }

  // Filter: mistakes only
  var filterOnlyMistakes by remember { mutableStateOf(false) }

  // User answers map: Key = question.id ("tf_g11_sci_q42"), Value = chosen Boolean
  var userAnswers by remember { mutableStateOf<Map<String, Boolean>>(emptyMap()) }

  // Focus Question Mode: When true, screen is 100% full screen with all outer/inner clutter removed
  var isFocusQuestionMode by remember { mutableStateOf(false) }
  var showQuestionSheet by remember { mutableStateOf(false) }
  var showSubjectBatchDialog by remember { mutableStateOf(false) }

  LaunchedEffect(isFocusQuestionMode) {
    onFullScreenToggle(isFocusQuestionMode)
  }

  // Intercept back button when in Focus Mode
  BackHandler(enabled = isFocusQuestionMode) {
    isFocusQuestionMode = false
    onFullScreenToggle(false)
  }

  // TTS for reading statements
  var tts by remember { mutableStateOf<TextToSpeech?>(null) }
  DisposableEffect(Unit) {
    var ttsEngine: TextToSpeech? = null
    ttsEngine = TextToSpeech(context) { status ->
      if (status == TextToSpeech.SUCCESS) {
        ttsEngine?.language = Locale("si", "LK")
      }
    }
    tts = ttsEngine
    onDispose {
      ttsEngine?.stop()
      ttsEngine?.shutdown()
    }
  }

  // Load questions for selected batch
  val batchQuestions = remember(selectedGrade, selectedSubject, selectedBatchIndex) {
    TrueFalse500Repository.getQuestionsForBatch(selectedGrade, selectedSubject, selectedBatchIndex)
  }

  // Filtered list if mistakes only is on
  val displayedQuestions = remember(batchQuestions, filterOnlyMistakes, userAnswers) {
    if (!filterOnlyMistakes) {
      batchQuestions
    } else {
      batchQuestions.filter { q ->
        val answered = userAnswers[q.id]
        answered != null && answered != q.isTrue
      }
    }
  }

  // Ensure current question index is clamped
  val effectiveIndex = if (displayedQuestions.isEmpty()) 0 else questionIndexInBatch.coerceIn(0, displayedQuestions.size - 1)
  val activeQ = displayedQuestions.getOrNull(effectiveIndex)

  // Current batch stats
  val answeredInBatch = batchQuestions.count { userAnswers.containsKey(it.id) }
  val correctInBatch = batchQuestions.count { userAnswers[it.id] == it.isTrue }
  val batchRange = TrueFalse500Repository.getBatchRange(selectedBatchIndex)

  // =========================================================================
  // MODE A: FULL SCREEN FOCUS QUESTION VIEW (Distraction-Free)
  // When active: Top App Bar, Tabs, Bottom Navigation, and all inner selectors are removed!
  // =========================================================================
  if (isFocusQuestionMode && activeQ != null) {
    val userAnswer = userAnswers[activeQ.id]
    val hasAnswered = userAnswer != null
    val isCorrect = hasAnswered && userAnswer == activeQ.isTrue

    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF0B132B))
        .statusBarsPadding()
        .navigationBarsPadding()
        .padding(horizontal = 14.dp, vertical = 6.dp)
        .testTag("true_false_focus_fullscreen")
    ) {
      // 1. Sleek Top Header
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        // Back / Exit Focus button
        Surface(
          onClick = {
            isFocusQuestionMode = false
            onFullScreenToggle(false)
          },
          shape = RoundedCornerShape(10.dp),
          color = Color(0xFF1E293B),
          border = BorderStroke(1.dp, Color(0xFF334155))
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = "Back",
              tint = Color(0xFFEC4899),
              modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
              text = "කාණ්ඩ වෙත",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
          }
        }

        // Center: Title & Batch Info (Tappable for Quick Switch Dialog)
        Surface(
          onClick = { showSubjectBatchDialog = true },
          shape = RoundedCornerShape(10.dp),
          color = Color(0xFF1E293B),
          border = BorderStroke(1.dp, Color(0xFF334155))
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
              Text(
                text = "${selectedSubject.iconEmoji} ${selectedSubject.displayName}",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Text(
                text = "${selectedGrade} ශ්‍රේණිය • කාණ්ඩය #${selectedBatchIndex + 1} (${batchRange.first}-${batchRange.second})",
                fontSize = 9.sp,
                color = Color(0xFFF472B6)
              )
            }
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
              imageVector = Icons.Default.ArrowDropDown,
              contentDescription = "Switch",
              tint = Color(0xFFEC4899),
              modifier = Modifier.size(18.dp)
            )
          }
        }

        // Right Action: Question jump & progress badge
        Surface(
          onClick = { showQuestionSheet = true },
          shape = RoundedCornerShape(10.dp),
          color = Color(0xFF1E293B),
          border = BorderStroke(1.dp, Color(0xFFEC4899).copy(alpha = 0.5f))
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Icon(
              imageVector = Icons.Default.List,
              contentDescription = "Question List",
              tint = Color(0xFF38BDF8),
              modifier = Modifier.size(14.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
              text = "${effectiveIndex + 1}/${displayedQuestions.size}",
              fontSize = 11.sp,
              fontWeight = FontWeight.ExtraBold,
              color = Color.White
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(4.dp))

      // Linear progress bar across questions in batch
      LinearProgressIndicator(
        progress = { (effectiveIndex + 1).toFloat() / displayedQuestions.size.coerceAtLeast(1) },
        modifier = Modifier
          .fillMaxWidth()
          .height(3.dp)
          .clip(RoundedCornerShape(2.dp)),
        color = Color(0xFFEC4899),
        trackColor = Color(0xFF1E293B)
      )

      Spacer(modifier = Modifier.height(10.dp))

      // Central Question Content (Scrollable so explanation is always accessible without clutter)
      val focusScrollState = rememberScrollState()
      Column(
        modifier = Modifier
          .weight(1f)
          .fillMaxWidth()
          .verticalScroll(focusScrollState),
        verticalArrangement = Arrangement.spacedBy(12.dp)
      ) {
        // Question Card
        Card(
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(
            1.5.dp,
            if (!hasAnswered) Color(0xFF334155) else if (isCorrect) Color(0xFF22C55E) else Color(0xFFEF4444)
          ),
          modifier = Modifier.fillMaxWidth().testTag("focus_question_card")
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            // Unit Name & Question Number Badge (Ultra-Compact)
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Surface(
                shape = RoundedCornerShape(4.dp),
                color = selectedSubject.primaryColor.copy(alpha = 0.2f),
                modifier = Modifier.weight(1f)
              ) {
                Text(
                  text = activeQ.unitName,
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = selectedSubject.primaryColor,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }

              Spacer(modifier = Modifier.width(6.dp))

              Surface(
                shape = RoundedCornerShape(4.dp),
                color = Color(0xFF0F172A)
              ) {
                Text(
                  text = "${effectiveIndex + 1}/${displayedQuestions.size} (#${activeQ.number})",
                  fontSize = 9.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFFCBD5E1),
                  modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Statement with Voice / TTS button
            Row(
              modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.Top
            ) {
              Column(modifier = Modifier.weight(1f)) {
                Text(
                  text = "ප්‍රකාශය (Statement):",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.SemiBold,
                  color = Color(0xFF94A3B8)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                  text = "\"${activeQ.statement}\"",
                  fontSize = 15.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  lineHeight = 24.sp
                )
              }

              IconButton(
                onClick = {
                  try {
                    tts?.speak(activeQ.statement, TextToSpeech.QUEUE_FLUSH, null, "tf_tts")
                  } catch (_: Exception) {}
                },
                modifier = Modifier
                  .size(38.dp)
                  .testTag("focus_tts_play_btn")
              ) {
                Icon(
                  imageVector = Icons.Default.VolumeUp,
                  contentDescription = "Read Statement Aloud",
                  tint = Color(0xFF38BDF8),
                  modifier = Modifier.size(24.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Big, Comfortable True / False Answer Buttons
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
              // TRUE BUTTON
              Button(
                onClick = {
                  userAnswers = userAnswers + (activeQ.id to true)
                },
                modifier = Modifier
                  .weight(1f)
                  .height(54.dp)
                  .testTag("true_btn_${activeQ.id}"),
                colors = ButtonDefaults.buttonColors(
                  containerColor = if (userAnswer == true) {
                    if (activeQ.isTrue) Color(0xFF16A34A) else Color(0xFFDC2626)
                  } else Color(0xFF0F172A)
                ),
                border = BorderStroke(
                  if (userAnswer == true) 2.dp else 1.2.dp,
                  if (userAnswer == true) Color(0xFF4ADE80) else Color(0xFF475569)
                ),
                shape = RoundedCornerShape(12.dp)
              ) {
                Text(
                  text = "✔️ සත්‍ය වේ (True)",
                  fontSize = 13.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )
              }

              // FALSE BUTTON
              Button(
                onClick = {
                  userAnswers = userAnswers + (activeQ.id to false)
                },
                modifier = Modifier
                  .weight(1f)
                  .height(54.dp)
                  .testTag("false_btn_${activeQ.id}"),
                colors = ButtonDefaults.buttonColors(
                  containerColor = if (userAnswer == false) {
                    if (!activeQ.isTrue) Color(0xFF16A34A) else Color(0xFFDC2626)
                  } else Color(0xFF0F172A)
                ),
                border = BorderStroke(
                  if (userAnswer == false) 2.dp else 1.2.dp,
                  if (userAnswer == false) Color(0xFFF87171) else Color(0xFF475569)
                ),
                shape = RoundedCornerShape(12.dp)
              ) {
                Text(
                  text = "❌ අසත්‍ය වේ (False)",
                  fontSize = 13.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )
              }
            }
          }
        }

        // Justification Explanation Box (Appears after answer)
        if (hasAnswered) {
          Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(
              containerColor = if (isCorrect) Color(0xFF064E3B) else Color(0xFF450A0A)
            ),
            border = BorderStroke(
              1.5.dp,
              if (isCorrect) Color(0xFF22C55E) else Color(0xFFEF4444)
            ),
            modifier = Modifier.fillMaxWidth().testTag("justification_explanation_card")
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = if (isCorrect) "🎉 ඔබේ තීරණය 100% නිවැරදියි!" else "💡 ඔබේ තීරණය වැරදියි!",
                  fontSize = 13.sp,
                  fontWeight = FontWeight.ExtraBold,
                  color = if (isCorrect) Color(0xFF86EFAC) else Color(0xFFFCA5A5)
                )
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = if (activeQ.isTrue) Color(0xFF16A34A) else Color(0xFFDC2626)
                ) {
                  Text(
                    text = if (activeQ.isTrue) "නිවැරදි පිළිතුර: සත්‍ය වේ" else "නිවැරදි පිළිතුර: අසත්‍ය වේ",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                  )
                }
              }

              Spacer(modifier = Modifier.height(10.dp))
              Text(
                text = "🔍 විද්‍යාත්මක / න්‍යායාත්මක හේතුව (Justification):",
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFBBF24)
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = activeQ.justification,
                fontSize = 12.sp,
                color = Color(0xFFF1F5F9),
                lineHeight = 18.sp
              )

              Spacer(modifier = Modifier.height(10.dp))
              Text(
                text = "⚠️ විභාග අනතුරු ඇඟවීම / Exam Trap: ${activeQ.examTrapOrFact}",
                fontSize = 11.sp,
                color = Color(0xFFFDA4AF),
                lineHeight = 16.sp
              )
            }
          }
        }
      }

      // Bottom Navigation Buttons (Fixed bar at bottom for comfortable one-by-one flow)
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 8.dp, bottom = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        OutlinedButton(
          onClick = {
            if (effectiveIndex > 0) {
              questionIndexInBatch = effectiveIndex - 1
            }
          },
          enabled = effectiveIndex > 0,
          colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
          border = BorderStroke(1.dp, if (effectiveIndex > 0) Color(0xFF475569) else Color(0xFF1E293B)),
          shape = RoundedCornerShape(10.dp),
          modifier = Modifier
            .weight(1f)
            .height(48.dp)
            .testTag("prev_q_btn")
        ) {
          Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Previous", modifier = Modifier.size(16.dp))
          Spacer(modifier = Modifier.width(6.dp))
          Text("පෙර ප්‍රශ්නය", fontSize = 11.5.sp, fontWeight = FontWeight.SemiBold)
        }

        Button(
          onClick = {
            if (effectiveIndex < displayedQuestions.size - 1) {
              questionIndexInBatch = effectiveIndex + 1
            } else if (selectedBatchIndex < TrueFalse500Repository.TOTAL_BATCHES - 1) {
              selectedBatchIndex++
              questionIndexInBatch = 0
            }
          },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEC4899)),
          shape = RoundedCornerShape(10.dp),
          modifier = Modifier
            .weight(1f)
            .height(48.dp)
            .testTag("next_q_btn")
        ) {
          Text(
            text = if (effectiveIndex < displayedQuestions.size - 1) "මීළඟ ප්‍රශ්නය" else "ඊළඟ කාණ්ඩයට ➔",
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Bold
          )
          Spacer(modifier = Modifier.width(6.dp))
          Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Next", modifier = Modifier.size(16.dp))
        }
      }
    }
  } else {
    // =========================================================================
    // MODE B: BATCH & GRADE OVERVIEW VIEW
    // Accessible via "කාණ්ඩ වෙත" button. Allows switching subjects/batches/grades.
    // Tapping on any question immediately enters Focus Full-Screen Mode!
    // =========================================================================
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .testTag("true_false_master_section"),
      contentPadding = PaddingValues(bottom = 80.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      // 1. Grade Selector Banner (9 / 10 / 11)
      item {
        Card(
          shape = RoundedCornerShape(14.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFFEC4899).copy(alpha = 0.6f))
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onBack, modifier = Modifier.size(32.dp)) {
                  Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White, modifier = Modifier.size(18.dp))
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text("⚖️", fontSize = 18.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = "සත්‍ය / අසත්‍ය • ප්‍රශ්න 500",
                  fontSize = 13.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )
              }
              Surface(
                shape = RoundedCornerShape(6.dp),
                color = Color(0xFFEC4899).copy(alpha = 0.25f)
              ) {
                Text(
                  text = "Grade $selectedGrade",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.ExtraBold,
                  color = Color(0xFFF472B6),
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Grade Selection Buttons (9, 10, 11)
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              listOf(9, 10, 11).forEach { grade ->
                val isSelected = selectedGrade == grade
                OutlinedButton(
                  onClick = {
                    selectedGrade = grade
                    selectedBatchIndex = 0
                    questionIndexInBatch = 0
                  },
                  modifier = Modifier
                    .weight(1f)
                    .testTag("grade_btn_$grade"),
                  colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = if (isSelected) Color(0xFFEC4899) else Color(0xFF0F172A),
                    contentColor = if (isSelected) Color.White else Color(0xFFE2E8F0)
                  ),
                  border = BorderStroke(
                    1.5.dp,
                    if (isSelected) Color(0xFFF472B6) else Color(0xFF334155)
                  ),
                  shape = RoundedCornerShape(10.dp),
                  contentPadding = PaddingValues(vertical = 6.dp)
                ) {
                  Text(
                    text = "$grade ශ්‍රේණිය",
                    fontSize = 12.sp,
                    fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Medium
                  )
                }
              }
            }
          }
        }
      }

      // 2. Subject Selection Chips
      item {
        Column {
          Text(
            text = "විෂය තෝරන්න (Select Subject):",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF94A3B8),
            modifier = Modifier.padding(bottom = 6.dp)
          )
          LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 2.dp)
          ) {
            items(TrueFalseSubject.values()) { subject ->
              val isSelected = selectedSubject == subject
              Surface(
                shape = RoundedCornerShape(10.dp),
                color = if (isSelected) subject.primaryColor else Color(0xFF1E293B),
                border = BorderStroke(
                  1.dp,
                  if (isSelected) Color.White else Color(0xFF334155)
                ),
                modifier = Modifier
                  .clickable {
                    selectedSubject = subject
                    selectedBatchIndex = 0
                    questionIndexInBatch = 0
                  }
                  .testTag("subject_chip_${subject.id}")
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(subject.iconEmoji, fontSize = 14.sp)
                  Spacer(modifier = Modifier.width(5.dp))
                  Text(
                    text = subject.displayName,
                    fontSize = 11.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    color = if (isSelected) Color.White else Color(0xFFCBD5E1)
                  )
                }
              }
            }
          }
        }
      }

      // 3. Batch Selection Chips (17 Batches of 30 questions)
      item {
        Column {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "තිහේ කාණ්ඩය තෝරන්න (30 Questions Batch):",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF94A3B8)
            )
            Text(
              text = "කාණ්ඩ 17 න් #${selectedBatchIndex + 1}",
              fontSize = 10.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFF472B6)
            )
          }
          Spacer(modifier = Modifier.height(6.dp))
          LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 2.dp)
          ) {
            items(TrueFalse500Repository.TOTAL_BATCHES) { batchIdx ->
              val isSelected = selectedBatchIndex == batchIdx
              val (start, end) = TrueFalse500Repository.getBatchRange(batchIdx)
              val batchCount = (start..end).count { qNum ->
                userAnswers.containsKey("tf_g${selectedGrade}_${selectedSubject.id}_q$qNum")
              }
              val isCompleted = batchCount == (end - start + 1)

              Surface(
                shape = RoundedCornerShape(10.dp),
                color = if (isSelected) Color(0xFF831843) else Color(0xFF1E293B),
                border = BorderStroke(
                  1.5.dp,
                  if (isSelected) Color(0xFFF472B6) else if (isCompleted) Color(0xFF10B981) else Color(0xFF334155)
                ),
                modifier = Modifier
                  .clickable {
                    selectedBatchIndex = batchIdx
                    questionIndexInBatch = 0
                  }
                  .testTag("batch_chip_$batchIdx")
              ) {
                Column(
                  modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                  horizontalAlignment = Alignment.CenterHorizontally
                ) {
                  Text(
                    text = "කාණ්ඩය ${batchIdx + 1}",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isSelected) Color.White else Color(0xFFE2E8F0)
                  )
                  Text(
                    text = "ප්‍රශ්න $start - $end",
                    fontSize = 9.sp,
                    color = if (isSelected) Color(0xFFFCE7F3) else Color(0xFF94A3B8)
                  )
                  if (batchCount > 0) {
                    Text(
                      text = if (isCompleted) "සම්පූර්ණයි ✅" else "$batchCount/${end - start + 1}",
                      fontSize = 8.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = if (isCompleted) Color(0xFF4ADE80) else Color(0xFFFBBF24)
                    )
                  }
                }
              }
            }
          }
        }
      }

      // 4. Batch Progress & Enter Focus Button Card
      item {
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
          border = BorderStroke(1.dp, Color(0xFF334155))
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Column {
                Text(
                  text = "කාණ්ඩයේ ප්‍රගතිය: $answeredInBatch / ${batchQuestions.size} පිළිතුරු",
                  fontSize = 10.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )
                Text(
                  text = "ලකුණු: $correctInBatch • නිරවද්‍යතාව: ${if (answeredInBatch > 0) (correctInBatch * 100) / answeredInBatch else 0}%",
                  fontSize = 9.5.sp,
                  color = Color(0xFF38BDF8)
                )
              }

              Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                // Filter mistakes
                FilterChip(
                  selected = filterOnlyMistakes,
                  onClick = { filterOnlyMistakes = !filterOnlyMistakes },
                  label = { Text("වැරදුණු ඒවා", fontSize = 9.5.sp) },
                  colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFFEF4444),
                    selectedLabelColor = Color.White
                  ),
                  modifier = Modifier.testTag("filter_mistakes_chip")
                )

                // Reset batch
                IconButton(
                  onClick = {
                    val newAnswers = userAnswers.toMutableMap()
                    batchQuestions.forEach { newAnswers.remove(it.id) }
                    userAnswers = newAnswers
                    questionIndexInBatch = 0
                  },
                  modifier = Modifier.size(32.dp).testTag("reset_batch_btn")
                ) {
                  Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Reset Batch",
                    tint = Color(0xFF94A3B8),
                    modifier = Modifier.size(18.dp)
                  )
                }
              }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Prominent Full-Screen Focus Button
            Button(
              onClick = {
                isFocusQuestionMode = true
                onFullScreenToggle(true)
              },
              modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .testTag("start_fullscreen_focus_btn"),
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEC4899)),
              shape = RoundedCornerShape(10.dp)
            ) {
              Icon(Icons.Default.Fullscreen, contentDescription = null, modifier = Modifier.size(18.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = "🎯 සම්පූර්ණ තිරයෙන් ප්‍රශ්න විසඳන්න (Focus Mode)",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
              )
            }
          }
        }
      }

      // 5. Active Question Card in Overview (Tapping it enters focus mode!)
      if (activeQ != null) {
        val userAnswer = userAnswers[activeQ.id]
        val hasAnswered = userAnswer != null
        val isCorrect = hasAnswered && userAnswer == activeQ.isTrue

        item {
          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            border = BorderStroke(
              1.5.dp,
              if (!hasAnswered) Color(0xFF475569) else if (isCorrect) Color(0xFF22C55E) else Color(0xFFEF4444)
            ),
            modifier = Modifier
              .fillMaxWidth()
              .clickable {
                isFocusQuestionMode = true
                onFullScreenToggle(true)
              }
          ) {
            Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)) {
              // Top badges (Ultra-Compact)
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Surface(
                  shape = RoundedCornerShape(4.dp),
                  color = selectedSubject.primaryColor.copy(alpha = 0.2f),
                  modifier = Modifier.weight(1f)
                ) {
                  Text(
                    text = "${selectedSubject.displayName} • ${activeQ.unitName}",
                    fontSize = 9.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = selectedSubject.primaryColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                  )
                }

                Spacer(modifier = Modifier.width(6.dp))

                Surface(
                  shape = RoundedCornerShape(4.dp),
                  color = Color(0xFF334155)
                ) {
                  Text(
                    text = "${effectiveIndex + 1}/${displayedQuestions.size} (#${activeQ.number})",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFCBD5E1),
                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                  )
                }
              }

              Spacer(modifier = Modifier.height(12.dp))

              // Statement
              Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
              ) {
                Column(modifier = Modifier.weight(1f)) {
                  Text(
                    text = "ප්‍රකාශය (Statement):",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF94A3B8)
                  )
                  Spacer(modifier = Modifier.height(4.dp))
                  Text(
                    text = "\"${activeQ.statement}\"",
                    fontSize = 14.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    lineHeight = 22.sp
                  )
                }

                IconButton(
                  onClick = {
                    try {
                      tts?.speak(activeQ.statement, TextToSpeech.QUEUE_FLUSH, null, "tf_tts")
                    } catch (_: Exception) {}
                  },
                  modifier = Modifier
                    .padding(start = 4.dp)
                    .testTag("tts_play_btn")
                ) {
                  Icon(
                    imageVector = Icons.Default.VolumeUp,
                    contentDescription = "Read Statement Aloud",
                    tint = Color(0xFF38BDF8)
                  )
                }
              }

              Spacer(modifier = Modifier.height(16.dp))

              // True / False Buttons (tapping enters focus mode!)
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
              ) {
                Button(
                  onClick = {
                    userAnswers = userAnswers + (activeQ.id to true)
                    isFocusQuestionMode = true
                    onFullScreenToggle(true)
                  },
                  modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
                    .testTag("true_btn_${activeQ.id}"),
                  colors = ButtonDefaults.buttonColors(
                    containerColor = if (userAnswer == true) {
                      if (activeQ.isTrue) Color(0xFF16A34A) else Color(0xFFDC2626)
                    } else Color(0xFF0F172A)
                  ),
                  border = BorderStroke(
                    1.5.dp,
                    if (userAnswer == true) Color(0xFF4ADE80) else Color(0xFF475569)
                  ),
                  shape = RoundedCornerShape(10.dp)
                ) {
                  Text(
                    text = "✔️ සත්‍ය වේ (True)",
                    fontSize = 12.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                  )
                }

                Button(
                  onClick = {
                    userAnswers = userAnswers + (activeQ.id to false)
                    isFocusQuestionMode = true
                    onFullScreenToggle(true)
                  },
                  modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
                    .testTag("false_btn_${activeQ.id}"),
                  colors = ButtonDefaults.buttonColors(
                    containerColor = if (userAnswer == false) {
                      if (!activeQ.isTrue) Color(0xFF16A34A) else Color(0xFFDC2626)
                    } else Color(0xFF0F172A)
                  ),
                  border = BorderStroke(
                    1.5.dp,
                    if (userAnswer == false) Color(0xFFF87171) else Color(0xFF475569)
                  ),
                  shape = RoundedCornerShape(10.dp)
                ) {
                  Text(
                    text = "❌ අසත්‍ය වේ (False)",
                    fontSize = 12.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                  )
                }
              }
            }
          }
        }

        // Justification Box if answered
        if (hasAnswered) {
          item {
            Card(
              shape = RoundedCornerShape(14.dp),
              colors = CardDefaults.cardColors(
                containerColor = if (isCorrect) Color(0xFF064E3B) else Color(0xFF450A0A)
              ),
              border = BorderStroke(
                1.5.dp,
                if (isCorrect) Color(0xFF22C55E) else Color(0xFFEF4444)
              )
            ) {
              Column(modifier = Modifier.padding(14.dp)) {
                Text(
                  text = if (isCorrect) "🎉 ඔබේ තීරණය 100% නිවැරදියි!" else "💡 ඔබේ තීරණය වැරදියි!",
                  fontSize = 13.sp,
                  fontWeight = FontWeight.ExtraBold,
                  color = if (isCorrect) Color(0xFF86EFAC) else Color(0xFFFCA5A5)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                  text = activeQ.justification,
                  fontSize = 12.sp,
                  color = Color(0xFFF1F5F9),
                  lineHeight = 18.sp
                )
              }
            }
          }
        }

        // Navigation Controls
        item {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            OutlinedButton(
              onClick = {
                if (effectiveIndex > 0) {
                  questionIndexInBatch = effectiveIndex - 1
                }
                isFocusQuestionMode = true
                onFullScreenToggle(true)
              },
              enabled = effectiveIndex > 0,
              colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
              border = BorderStroke(1.dp, Color(0xFF475569)),
              shape = RoundedCornerShape(8.dp)
            ) {
              Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Previous", modifier = Modifier.size(16.dp))
              Spacer(modifier = Modifier.width(4.dp))
              Text("පෙර ප්‍රශ්නය", fontSize = 11.sp)
            }

            Button(
              onClick = {
                if (effectiveIndex < displayedQuestions.size - 1) {
                  questionIndexInBatch = effectiveIndex + 1
                } else if (selectedBatchIndex < TrueFalse500Repository.TOTAL_BATCHES - 1) {
                  selectedBatchIndex++
                  questionIndexInBatch = 0
                }
                isFocusQuestionMode = true
                onFullScreenToggle(true)
              },
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEC4899)),
              shape = RoundedCornerShape(8.dp)
            ) {
              Text(
                text = if (effectiveIndex < displayedQuestions.size - 1) "මීළඟ ප්‍රශ්නය" else "ඊළඟ කාණ්ඩයට ➔",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold
              )
              Spacer(modifier = Modifier.width(4.dp))
              Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Next", modifier = Modifier.size(16.dp))
            }
          }
        }

        // 8. Question Jump Grid (Tapping any enters Focus Mode!)
        item {
          Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            border = BorderStroke(1.dp, Color(0xFF334155))
          ) {
            Column(modifier = Modifier.padding(12.dp)) {
              Text(
                text = "ප්‍රශ්න ලැයිස්තුව (කාණ්ඩය #${selectedBatchIndex + 1}):",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF94A3B8)
              )
              Spacer(modifier = Modifier.height(8.dp))

              FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
              ) {
                displayedQuestions.forEachIndexed { idx, q ->
                  val ans = userAnswers[q.id]
                  val isCurrent = idx == effectiveIndex
                  val circleBg = when {
                    ans == null -> Color(0xFF0F172A)
                    ans == q.isTrue -> Color(0xFF16A34A)
                    else -> Color(0xFFDC2626)
                  }

                  Box(
                    modifier = Modifier
                      .size(32.dp)
                      .clip(CircleShape)
                      .background(circleBg)
                      .border(
                        width = if (isCurrent) 2.dp else 1.dp,
                        color = if (isCurrent) Color(0xFFEC4899) else Color(0xFF475569),
                        shape = CircleShape
                      )
                      .clickable {
                        questionIndexInBatch = idx
                        isFocusQuestionMode = true
                        onFullScreenToggle(true)
                      },
                    contentAlignment = Alignment.Center
                  ) {
                    Text(
                      text = "${idx + 1}",
                      fontSize = 10.sp,
                      fontWeight = if (isCurrent) FontWeight.ExtraBold else FontWeight.Normal,
                      color = Color.White
                    )
                  }
                }
              }
            }
          }
        }
      } else {
        // Empty state if filtering mistakes
        item {
          Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp)
          ) {
            Column(
              modifier = Modifier.padding(24.dp),
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
              Text("🎉", fontSize = 36.sp)
              Spacer(modifier = Modifier.height(8.dp))
              Text(
                text = "මෙම කාණ්ඩයේ වැරදුණු ප්‍රශ්න කිසිවක් නැත!",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "සියලු ප්‍රශ්න බැලීමට 'වැරදුණු ඒවා' ෆිල්ටරය අක්‍රිය කරන්න.",
                fontSize = 11.sp,
                color = Color(0xFF94A3B8)
              )
            }
          }
        }
      }
    }
  }

  // Question Jump Sheet Dialog in Focus Mode
  if (showQuestionSheet) {
    AlertDialog(
      onDismissRequest = { showQuestionSheet = false },
      title = {
        Text(
          text = "ප්‍රශ්න ලැයිස්තුව (කාණ්ඩය #${selectedBatchIndex + 1})",
          fontSize = 13.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White
        )
      },
      text = {
        FlowRow(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(6.dp),
          verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          displayedQuestions.forEachIndexed { idx, q ->
            val ans = userAnswers[q.id]
            val isCurrent = idx == effectiveIndex
            val circleBg = when {
              ans == null -> Color(0xFF0F172A)
              ans == q.isTrue -> Color(0xFF16A34A)
              else -> Color(0xFFDC2626)
            }

            Box(
              modifier = Modifier
                .size(34.dp)
                .clip(CircleShape)
                .background(circleBg)
                .border(
                  width = if (isCurrent) 2.dp else 1.dp,
                  color = if (isCurrent) Color(0xFFEC4899) else Color(0xFF475569),
                  shape = CircleShape
                )
                .clickable {
                  questionIndexInBatch = idx
                  showQuestionSheet = false
                },
              contentAlignment = Alignment.Center
            ) {
              Text(
                text = "${idx + 1}",
                fontSize = 10.5.sp,
                fontWeight = if (isCurrent) FontWeight.ExtraBold else FontWeight.Normal,
                color = Color.White
              )
            }
          }
        }
      },
      confirmButton = {
        TextButton(onClick = { showQuestionSheet = false }) {
          Text("වසන්න", color = Color(0xFFEC4899), fontWeight = FontWeight.Bold)
        }
      },
      containerColor = Color(0xFF1E293B)
    )
  }

  // Quick Switch Subject / Grade / Batch Dialog from within Focus Mode
  if (showSubjectBatchDialog) {
    AlertDialog(
      onDismissRequest = { showSubjectBatchDialog = false },
      title = {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Text("⚙️", fontSize = 18.sp)
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "විෂය හා කාණ්ඩය මාරු කිරීම",
            fontSize = 13.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
        }
      },
      text = {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
          verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
          // Grade Selector
          Text("ශ්‍රේණිය (Grade):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF94A3B8))
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            listOf(9, 10, 11).forEach { g ->
              val isSel = selectedGrade == g
              Button(
                onClick = {
                  selectedGrade = g
                  selectedBatchIndex = 0
                  questionIndexInBatch = 0
                },
                modifier = Modifier.weight(1f).height(38.dp),
                colors = ButtonDefaults.buttonColors(
                  containerColor = if (isSel) Color(0xFFEC4899) else Color(0xFF0F172A)
                ),
                border = BorderStroke(1.dp, if (isSel) Color(0xFFF472B6) else Color(0xFF334155)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(0.dp)
              ) {
                Text("$g ශ්‍රේණිය", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }
            }
          }

          // Subject Selector
          Text("විෂය (Subject):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF94A3B8))
          FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            TrueFalseSubject.values().forEach { s ->
              val isSel = selectedSubject == s
              Surface(
                onClick = {
                  selectedSubject = s
                  selectedBatchIndex = 0
                  questionIndexInBatch = 0
                },
                shape = RoundedCornerShape(8.dp),
                color = if (isSel) s.primaryColor else Color(0xFF0F172A),
                border = BorderStroke(1.dp, if (isSel) Color.White else Color(0xFF334155))
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(s.iconEmoji, fontSize = 13.sp)
                  Spacer(modifier = Modifier.width(4.dp))
                  Text(
                    text = s.displayName,
                    fontSize = 10.5.sp,
                    fontWeight = if (isSel) FontWeight.Bold else FontWeight.Normal,
                    color = Color.White
                  )
                }
              }
            }
          }

          // Batch Selector
          Text("කාණ්ඩය (Batch 1-17):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF94A3B8))
          LazyRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            contentPadding = PaddingValues(horizontal = 2.dp)
          ) {
            items(TrueFalse500Repository.TOTAL_BATCHES) { bIdx ->
              val isSel = selectedBatchIndex == bIdx
              val (st, en) = TrueFalse500Repository.getBatchRange(bIdx)
              Surface(
                onClick = {
                  selectedBatchIndex = bIdx
                  questionIndexInBatch = 0
                },
                shape = RoundedCornerShape(8.dp),
                color = if (isSel) Color(0xFF831843) else Color(0xFF0F172A),
                border = BorderStroke(1.dp, if (isSel) Color(0xFFF472B6) else Color(0xFF334155))
              ) {
                Column(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
                  horizontalAlignment = Alignment.CenterHorizontally
                ) {
                  Text("කාණ්ඩය ${bIdx + 1}", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color.White)
                  Text("$st-$en", fontSize = 8.5.sp, color = Color(0xFFCBD5E1))
                }
              }
            }
          }
        }
      },
      confirmButton = {
        Button(
          onClick = { showSubjectBatchDialog = false },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEC4899)),
          shape = RoundedCornerShape(8.dp)
        ) {
          Text("හරි (Done)", fontWeight = FontWeight.Bold, fontSize = 11.5.sp)
        }
      },
      containerColor = Color(0xFF1E293B)
    )
  }
}

// ==============================================================================
// 6. 📝 CUSTOM SELF-QUIZ MAKER (Student's Personal Q&A Bank)
// ==============================================================================

data class CustomStudentQuestion(
  val id: Long,
  val question: String,
  val answer: String,
  val subject: String,
  val dateAdded: String
)

@Composable
fun CustomQuizMakerSection() {
  val context = LocalContext.current
  val prefs = remember { context.getSharedPreferences("ol_custom_quizzes", Context.MODE_PRIVATE) }

  // Load saved custom questions
  fun loadQuestions(): List<CustomStudentQuestion> {
    val raw = prefs.getString("custom_q_list", null) ?: return listOf(
      CustomStudentQuestion(
        id = 1L,
        question = "රසායනික බන්ධන ප්‍රධාන වර්ග 2 මොනවාද?",
        answer = "සහසංයුජ බන්ධන සහ අයනික බන්ධන.",
        subject = "විද්‍යාව",
        dateAdded = "අද"
      ),
      CustomStudentQuestion(
        id = 2L,
        question = "ලක්දිව පළමු විදේශීය ආක්‍රමණය කළ සේන සහ ගුත්තික පැමිණියේ කොහෙන්ද?",
        answer = "දකුණු ඉන්දියාවෙන් (අශ්ව වෙළඳුන් ලෙස).",
        subject = "ඉතිහාසය",
        dateAdded = "ඊයේ"
      )
    )
    return try {
      val arr = JSONArray(raw)
      val list = mutableListOf<CustomStudentQuestion>()
      for (i in 0 until arr.length()) {
        val obj = arr.getJSONObject(i)
        list.add(
          CustomStudentQuestion(
            id = obj.getLong("id"),
            question = obj.getString("q"),
            answer = obj.getString("a"),
            subject = obj.getString("s"),
            dateAdded = obj.getString("d")
          )
        )
      }
      list
    } catch (e: Exception) {
      emptyList()
    }
  }

  fun saveQuestions(list: List<CustomStudentQuestion>) {
    val arr = JSONArray()
    list.forEach { item ->
      val obj = JSONObject()
      obj.put("id", item.id)
      obj.put("q", item.question)
      obj.put("a", item.answer)
      obj.put("s", item.subject)
      obj.put("d", item.dateAdded)
      arr.put(obj)
    }
    prefs.edit().putString("custom_q_list", arr.toString()).apply()
  }

  var questionsList by remember { mutableStateOf(loadQuestions()) }
  var isAddingNew by remember { mutableStateOf(false) }
  var newQText by remember { mutableStateOf("") }
  var newAText by remember { mutableStateOf("") }
  var newSubject by remember { mutableStateOf("විද්‍යාව") }
  var testModeIndex by remember { mutableStateOf<Int?>(null) }
  var revealAnswer by remember { mutableStateOf(false) }

  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    contentPadding = PaddingValues(bottom = 40.dp),
    verticalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    item {
      Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFF14B8A6).copy(alpha = 0.5f))
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text("📝", fontSize = 18.sp)
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = "මගේම ප්‍රශ්න බැංකුව (Self-Quiz Maker)",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
            }

            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFF14B8A6).copy(alpha = 0.25f)
            ) {
              Text(
                text = "එකතුව: ${questionsList.size}",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2DD4BF),
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
              )
            }
          }

          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = "පන්තියෙන්, ටියුෂන් වලින් හෝ පාඩම් පොතෙන් ලැබෙන විශේෂ ප්‍රශ්න මෙහි ඇතුළත් කර ස්වයං පරීක්ෂණ පවත්වන්න.",
            fontSize = 11.sp,
            color = Color(0xFF94A3B8)
          )

          Spacer(modifier = Modifier.height(10.dp))

          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            Button(
              onClick = {
                isAddingNew = !isAddingNew
                testModeIndex = null
              },
              modifier = Modifier.weight(1f),
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D9488)),
              shape = RoundedCornerShape(8.dp)
            ) {
              Text(if (!isAddingNew) "+ අලුත් ප්‍රශ්නයක්" else "වසන්න ✕", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
            }

            if (questionsList.isNotEmpty()) {
              Button(
                onClick = {
                  testModeIndex = if (testModeIndex == null) 0 else null
                  isAddingNew = false
                  revealAnswer = false
                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
                shape = RoundedCornerShape(8.dp)
              ) {
                Text(
                  text = if (testModeIndex == null) "🎯 Self-Test කරන්න" else "Test අවසන්",
                  fontSize = 11.5.sp,
                  fontWeight = FontWeight.Bold
                )
              }
            }
          }
        }
      }
    }

    // Add New Question Form
    if (isAddingNew) {
      item {
        Card(
          shape = RoundedCornerShape(14.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
          border = BorderStroke(1.dp, Color(0xFF14B8A6))
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            Text("නව ප්‍රශ්නයක් ඇතුළත් කිරීම:", fontSize = 12.5.sp, fontWeight = FontWeight.Bold, color = Color.White)

            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
              value = newQText,
              onValueChange = { newQText = it },
              placeholder = { Text("ප්‍රශ්නය ඇතුළත් කරන්න...", fontSize = 11.sp) },
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
              value = newAText,
              onValueChange = { newAText = it },
              placeholder = { Text("නිවැරදි පිළිතුර / සටහන...", fontSize = 11.sp) },
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text("විෂය:", fontSize = 11.sp, color = Color(0xFF94A3B8))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
              val subjs = listOf("විද්‍යාව", "ඉතිහාසය", "ගණිතය", "සිංහල", "බුද්ධ ධර්මය", "ICT", "වෙනත්")
              items(subjs) { s ->
                FilterChip(
                  selected = newSubject == s,
                  onClick = { newSubject = s },
                  label = { Text(s, fontSize = 10.sp) }
                )
              }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Button(
              onClick = {
                if (newQText.isNotBlank() && newAText.isNotBlank()) {
                  val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                  val newItem = CustomStudentQuestion(
                    id = System.currentTimeMillis(),
                    question = newQText.trim(),
                    answer = newAText.trim(),
                    subject = newSubject,
                    dateAdded = sdf.format(Date())
                  )
                  val updated = questionsList + newItem
                  questionsList = updated
                  saveQuestions(updated)
                  newQText = ""
                  newAText = ""
                  isAddingNew = false
                }
              },
              enabled = newQText.isNotBlank() && newAText.isNotBlank(),
              modifier = Modifier.fillMaxWidth(),
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF14B8A6)),
              shape = RoundedCornerShape(8.dp)
            ) {
              Text("සුරකින්න (Save Question)", fontWeight = FontWeight.Bold, fontSize = 11.5.sp)
            }
          }
        }
      }
    }

    // Active Self-Test Flash Mode
    if (testModeIndex != null && questionsList.isNotEmpty()) {
      val testQ = questionsList[testModeIndex!!]

      item {
        Card(
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
          border = BorderStroke(2.dp, Color(0xFF0284C7))
        ) {
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text(
              text = "🎯 Self-Test පරීක්ෂණය (${testModeIndex!! + 1} / ${questionsList.size})",
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF38BDF8)
            )

            Spacer(modifier = Modifier.height(8.dp))
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFF0284C7).copy(alpha = 0.2f)
            ) {
              Text(
                text = testQ.subject,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF7DD3FC),
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
              )
            }

            Spacer(modifier = Modifier.height(14.dp))
            Text(
              text = testQ.question,
              fontSize = 15.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White,
              textAlign = TextAlign.Center,
              lineHeight = 22.sp
            )

            Spacer(modifier = Modifier.height(14.dp))

            if (!revealAnswer) {
              Button(
                onClick = { revealAnswer = true },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
                shape = RoundedCornerShape(8.dp)
              ) {
                Text("👁️ පිළිතුර පෙන්වන්න", fontSize = 11.sp, fontWeight = FontWeight.Bold)
              }
            } else {
              Surface(
                shape = RoundedCornerShape(10.dp),
                color = Color(0xFF1E293B),
                border = BorderStroke(1.dp, Color(0xFF34D399)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Text("✅ ඔබ ලියා ඇති පිළිතුර:", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF86EFAC))
                  Spacer(modifier = Modifier.height(4.dp))
                  Text(testQ.answer, fontSize = 13.sp, color = Color.White, lineHeight = 18.sp)
                }
              }

              Spacer(modifier = Modifier.height(12.dp))
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Button(
                  onClick = {
                    if (testModeIndex!! > 0) testModeIndex = testModeIndex!! - 1
                    revealAnswer = false
                  },
                  enabled = testModeIndex!! > 0,
                  shape = RoundedCornerShape(8.dp)
                ) {
                  Text("◀ කලින්", fontSize = 10.sp)
                }

                Button(
                  onClick = {
                    if (testModeIndex!! < questionsList.size - 1) {
                      testModeIndex = testModeIndex!! + 1
                    } else {
                      testModeIndex = 0
                    }
                    revealAnswer = false
                  },
                  shape = RoundedCornerShape(8.dp),
                  colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981))
                ) {
                  Text("මීළඟ ➔", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                }
              }
            }
          }
        }
      }
    }

    // List of Saved Questions
    if (questionsList.isNotEmpty() && testModeIndex == null) {
      item {
        Text(
          text = "සුරැකි ප්‍රශ්න ලැයිස්තුව (${questionsList.size}):",
          fontSize = 12.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White
        )
      }

      items(questionsList) { q ->
        Card(
          shape = RoundedCornerShape(10.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFF334155))
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Surface(
                shape = RoundedCornerShape(4.dp),
                color = Color(0xFF14B8A6).copy(alpha = 0.2f)
              ) {
                Text(
                  text = q.subject,
                  fontSize = 9.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF2DD4BF),
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }

              IconButton(
                onClick = {
                  val updated = questionsList.filter { it.id != q.id }
                  questionsList = updated
                  saveQuestions(updated)
                },
                modifier = Modifier.size(22.dp)
              ) {
                Text("🗑️", fontSize = 12.sp)
              }
            }

            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = q.question,
              fontSize = 12.sp,
              fontWeight = FontWeight.SemiBold,
              color = Color.White
            )

            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "A: ${q.answer}",
              fontSize = 11.sp,
              color = Color(0xFFCBD5E1)
            )
          }
        }
      }
    }
  }
}
