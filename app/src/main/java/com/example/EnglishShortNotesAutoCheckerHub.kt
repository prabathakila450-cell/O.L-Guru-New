package com.example

import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import java.util.Locale

enum class EnglishGradeLevel(val label: String, val badgeColor: Color) {
  ALL("සියලු ශ්‍රේණි (10, 11)", Color(0xFF1E293B)),
  GRADE_11("11 ශ්‍රේණිය (O/L)", Color(0xFF047857)),
  GRADE_10("10 ශ්‍රේණිය", Color(0xFF1D4ED8))
}

enum class EnglishSkillCategory(
  val displayName: String,
  val iconEmoji: String,
  val primaryColor: Color,
  val bgLightColor: Color
) {
  ALL("සියලු මාතෘකා", "📚", Color(0xFF1E3A8A), Color(0xFFEFF6FF)),
  TENSES("Tenses & Verb Forms", "⏳", Color(0xFF0284C7), Color(0xFFF0F9FF)),
  PASSIVE_VOICE("Active & Passive Voice", "🔄", Color(0xFF059669), Color(0xFFF0FDF4)),
  REPORTED_SPEECH("Direct & Indirect Speech", "💬", Color(0xFFD97706), Color(0xFFFFFBEB)),
  CONDITIONALS("If Clauses & Conditionals", "🔀", Color(0xFF7C3AED), Color(0xFFFAF5FF)),
  PREPOSITIONS("Prepositions & Phrasal Verbs", "📍", Color(0xFFDB2777), Color(0xFFFDF2F8)),
  CONJUNCTIONS("Conjunctions & Connectors", "🔗", Color(0xFF4F46E5), Color(0xFFEEF2FF)),
  RELATIVE_CLAUSES("Relative Clauses (who/which/that)", "👥", Color(0xFF0D9488), Color(0xFFF0FDFA)),
  QUESTION_TAGS("Question Tags & Inversions", "❓", Color(0xFFEA580C), Color(0xFFFFF7ED)),
  VOCABULARY("Vocabulary, Idioms & Collocations", "📖", Color(0xFF2563EB), Color(0xFFEFF6FF)),
  ERROR_CORRECTION("Sentence Structure & Errors", "✍️", Color(0xFFB91C1C), Color(0xFFFEF2F2)),
  MODALS("Modal Auxiliaries", "🛡️", Color(0xFF0891B2), Color(0xFFECFEFF))
}

data class EnglishGrammarRuleSummary(
  val title: String,
  val category: EnglishSkillCategory,
  val formula: String,
  val explanationSinhala: String,
  val examples: List<String>,
  val commonMistake: String
)

data class EnglishShortNoteQuestionItem(
  val id: String,
  val number: Int,
  val gradeLevel: EnglishGradeLevel,
  val category: EnglishSkillCategory,
  val topicTitle: String,
  val questionPrompt: String,
  val questionSinhalaGuidance: String,
  val options: List<String>,
  val correctOptionIndex: Int,
  val explanationSinhala: String,
  val grammarRuleOrFormula: String,
  val examTip: String
)

object EnglishShortNotesRepository {
  // 50 Comprehensive Grammar Rules with Sinhala Explanations & Bilingual Sentences
  val grammarRulesList: List<EnglishGrammarRuleSummary>
    get() = EnglishGrammar50DataBank.rulesList50

  // 30 Quiz Parts (20 Questions each = 600 Total Questions)
  fun getQuizPart(partNum: Int): List<EnglishShortNoteQuestionItem> =
    EnglishQuiz30PartsDataBank.getQuizPart(partNum)

  // 20 Timed Exam Simulation Parts (15 Questions each = 300 Total Questions)
  fun getExamPart(partNum: Int): List<EnglishShortNoteQuestionItem> =
    EnglishExam20PartsDataBank.getExamPart(partNum)

  val allQuestions: List<EnglishShortNoteQuestionItem> by lazy {
    EnglishQuiz30PartsDataBank.getAllQuizQuestions() + EnglishExam20PartsDataBank.getAllExamQuestions()
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnglishShortNotesAutoCheckerScreen(
  onBack: () -> Unit,
  onOpenPdfDriveViewer: (pdfUrl: String, title: String) -> Unit
) {
  val context = LocalContext.current

  var selectedGradeFilter by remember { mutableStateOf(EnglishGradeLevel.ALL) }
  var selectedSkillCategory by remember { mutableStateOf(EnglishSkillCategory.ALL) }
  var searchQuery by remember { mutableStateOf("") }
  var currentTabMode by remember { mutableIntStateOf(0) } // 0: Questions, 1: Grammar Rules, 2: Timed Exam, 3: Bookmarks

  // 30 Quiz Parts (20 questions each)
  var selectedQuizPart by remember { mutableIntStateOf(1) } // 1..30
  // Full screen mode flag for children's distraction-free testing
  var isFullScreenPractice by remember { mutableStateOf(false) }

  // 20 Exam Parts (15 questions each)
  var selectedExamPart by remember { mutableIntStateOf(1) } // 1..20

  val userAnswers = remember { mutableStateMapOf<String, Int>() }
  val bookmarkedQuestionIds = remember { mutableStateListOf<String>() }

  var ttsInstance by remember { mutableStateOf<TextToSpeech?>(null) }

  DisposableEffect(Unit) {
    var tts: TextToSpeech? = null
    tts = TextToSpeech(context) { status ->
      if (status == TextToSpeech.SUCCESS) {
        tts?.language = Locale.ENGLISH
      }
    }
    ttsInstance = tts
    onDispose {
      tts?.stop()
      tts?.shutdown()
    }
  }

  fun speakEnglish(text: String) {
    ttsInstance?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "eng_tts_${System.currentTimeMillis()}")
  }

  // Current questions for the selected Quiz Part (20 questions)
  val currentPartQuestions = remember(selectedQuizPart) {
    EnglishShortNotesRepository.getQuizPart(selectedQuizPart)
  }

  // Filtered questions based on search & grade
  val displayedQuestions = remember(selectedQuizPart, selectedGradeFilter, selectedSkillCategory, searchQuery, currentTabMode, bookmarkedQuestionIds.size) {
    val baseList = if (currentTabMode == 3) {
      EnglishShortNotesRepository.allQuestions.filter { bookmarkedQuestionIds.contains(it.id) }
    } else {
      currentPartQuestions
    }

    baseList.filter { q ->
      val matchesGrade = (selectedGradeFilter == EnglishGradeLevel.ALL) || (q.gradeLevel == selectedGradeFilter)
      val matchesCategory = (selectedSkillCategory == EnglishSkillCategory.ALL) || (q.category == selectedSkillCategory)
      val matchesSearch = searchQuery.isBlank() ||
        q.questionPrompt.contains(searchQuery, ignoreCase = true) ||
        q.topicTitle.contains(searchQuery, ignoreCase = true) ||
        q.questionSinhalaGuidance.contains(searchQuery, ignoreCase = true)

      matchesGrade && matchesCategory && matchesSearch
    }
  }

  val totalAnswered = userAnswers.size
  val correctCount = userAnswers.count { (qId, selectedIdx) ->
    val question = EnglishShortNotesRepository.allQuestions.firstOrNull { it.id == qId }
    question?.correctOptionIndex == selectedIdx
  }
  val accuracyPercent = if (totalAnswered > 0) (correctCount * 100 / totalAnswered) else 0

  Scaffold(
    contentWindowInsets = WindowInsets(0, 0, 0, 0),
    topBar = {
      // Slim Top Bar
      Surface(
        color = Color(0xFF0F172A),
        modifier = Modifier.fillMaxWidth()
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 8.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onBack, modifier = Modifier.size(34.dp)) {
              Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
              )
            }
            Spacer(modifier = Modifier.width(6.dp))
            Column {
              Text(
                text = "ඉංග්‍රීසි සටහන් ඔටෝ චෙක්",
                fontSize = 14.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Text(
                text = "10 & 11 ශ්‍රේණි • කොටස් 30 • විභාග 20 • සටහන් 50",
                fontSize = 10.sp,
                color = Color(0xFF94A3B8)
              )
            }
          }

          // PDF Shortcut
          Surface(
            onClick = {
              onOpenPdfDriveViewer(
                "https://drive.google.com/file/d/1gqP4w7v3-example/view?usp=sharing",
                "G.C.E. O/L English Master Revision Notes"
              )
            },
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFFE11D48),
            modifier = Modifier.height(28.dp)
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 8.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Icon(Icons.Default.PictureAsPdf, contentDescription = null, tint = Color.White, modifier = Modifier.size(13.dp))
              Spacer(modifier = Modifier.width(4.dp))
              Text("PDF", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
          }
        }
      }
    }
  ) { paddingValues ->
    val scrollState = rememberScrollState()
    // Center container with maximum width restriction (Compact Sub-Section Width)
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
        .background(Color(0xFFF8FAFC)),
      contentAlignment = Alignment.TopCenter
    ) {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .verticalScroll(scrollState)
          .fillMaxWidth()
          .widthIn(max = 350.dp)
          .padding(bottom = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        // 4 Category Tabs
        val tabs = listOf(
          "🎯 ප්‍රශ්නාවලිය (30)",
          "📖 සටහන් (50)",
          "⚡ විභාග (20)",
          "⭐ තරු (${bookmarkedQuestionIds.size})"
        )

        ScrollableTabRow(
          selectedTabIndex = currentTabMode,
          containerColor = Color(0xFF1E293B),
          contentColor = Color.White,
          edgePadding = 6.dp,
          indicator = { tabPositions ->
            TabRowDefaults.SecondaryIndicator(
              Modifier.tabIndicatorOffset(tabPositions[currentTabMode]),
              color = Color(0xFF38BDF8),
              height = 3.dp
            )
          },
          modifier = Modifier.fillMaxWidth()
        ) {
          tabs.forEachIndexed { index, title ->
            Tab(
              selected = currentTabMode == index,
              onClick = { currentTabMode = index },
              text = {
                Text(
                  text = title,
                  fontSize = 11.5.sp,
                  fontWeight = if (currentTabMode == index) FontWeight.Bold else FontWeight.Normal,
                  color = if (currentTabMode == index) Color(0xFF38BDF8) else Color(0xFF94A3B8)
                )
              }
            )
          }
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (currentTabMode == 0 || currentTabMode == 3) {
          // Progress & Stats Banner
          Surface(
            color = Color.White,
            shadowElevation = 1.dp,
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Column {
                Text(
                  text = "ඔබගේ ප්‍රගතිය (Score Progress)",
                  fontSize = 10.5.sp,
                  fontWeight = FontWeight.SemiBold,
                  color = Color(0xFF64748B)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text(
                    text = "$correctCount / $totalAnswered නිවැරදියි",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (accuracyPercent >= 75) Color(0xFF059669) else if (accuracyPercent >= 50) Color(0xFFD97706) else Color(0xFFDC2626)
                  )
                  Spacer(modifier = Modifier.width(6.dp))
                  Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = Color(0xFFE2E8F0)
                  ) {
                    Text(
                      text = "$accuracyPercent%",
                      fontSize = 9.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF334155),
                      modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
                    )
                  }
                }
              }

              // Full Screen Practice Trigger Button
              Button(
                onClick = { isFullScreenPractice = true },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                modifier = Modifier.height(34.dp)
              ) {
                Icon(Icons.Default.Fullscreen, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("ෆුල් ස්ක්‍රීන්", fontSize = 11.sp, fontWeight = FontWeight.Bold)
              }
            }
          }

          if (currentTabMode == 0) {
            // Part Selector: 30 Parts (20 Questions each)
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF1F5F9))
                .padding(vertical = 6.dp)
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = "🎯 ප්‍රශ්නාවලී කොටස තෝරන්න (1-30):",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF1E293B)
                )
                Text(
                  text = "කොටස $selectedQuizPart / 30 (ප්‍රශ්න 20)",
                  fontSize = 10.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF0284C7)
                )
              }

              Spacer(modifier = Modifier.height(4.dp))

              LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
              ) {
                items(30) { pIdx ->
                  val partNum = pIdx + 1
                  val isSelected = selectedQuizPart == partNum

                  Surface(
                    onClick = { selectedQuizPart = partNum },
                    shape = RoundedCornerShape(8.dp),
                    color = if (isSelected) Color(0xFF0284C7) else Color.White,
                    border = BorderStroke(1.dp, if (isSelected) Color(0xFF0284C7) else Color(0xFFCBD5E1)),
                    shadowElevation = if (isSelected) 2.dp else 0.dp
                  ) {
                    Text(
                      text = "කොටස $partNum",
                      fontSize = 10.5.sp,
                      fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                      color = if (isSelected) Color.White else Color(0xFF334155),
                      modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                    )
                  }
                }
              }
            }
          }

          // Grade Filter Chips (10, 11)
          LazyRow(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 10.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
          ) {
            items(EnglishGradeLevel.values()) { grade ->
              val isSelected = selectedGradeFilter == grade
              FilterChip(
                selected = isSelected,
                onClick = { selectedGradeFilter = grade },
                label = {
                  Text(
                    text = grade.label,
                    fontSize = 10.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                  )
                },
                colors = FilterChipDefaults.filterChipColors(
                  selectedContainerColor = grade.badgeColor,
                  selectedLabelColor = Color.White
                )
              )
            }
          }

          // Search Bar
          OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("ප්‍රශ්න හෝ ව්‍යාකරණ මාතෘකා සොයන්න...", fontSize = 11.5.sp) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.size(16.dp)) },
            trailingIcon = {
              if (searchQuery.isNotEmpty()) {
                IconButton(onClick = { searchQuery = "" }) {
                  Icon(Icons.Default.Close, contentDescription = null, modifier = Modifier.size(14.dp))
                }
              }
            },
            singleLine = true,
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
              focusedContainerColor = Color.White,
              unfocusedContainerColor = Color.White
            ),
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 10.dp, vertical = 4.dp)
              .height(46.dp)
          )

          // Questions List
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            displayedQuestions.forEach { item ->
              EnglishQuestionCard(
                item = item,
                selectedIndex = userAnswers[item.id],
                isBookmarked = bookmarkedQuestionIds.contains(item.id),
                onSelectOption = { userAnswers[item.id] = it },
                onToggleBookmark = {
                  if (bookmarkedQuestionIds.contains(item.id)) {
                    bookmarkedQuestionIds.remove(item.id)
                  } else {
                    bookmarkedQuestionIds.add(item.id)
                  }
                },
                onSpeak = { text -> speakEnglish(text) }
              )
            }
          }
        } else if (currentTabMode == 1) {
          // 50 GRAMMAR RULES TAB
          Column(modifier = Modifier.fillMaxWidth()) {
            Surface(
              color = Color.White,
              shadowElevation = 1.dp,
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Text(
                  text = "📖 ව්‍යාකරණ කෙටි සටහන් 50 (O/L Syllabus)",
                  fontSize = 12.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF0F172A)
                )
                Surface(
                  shape = RoundedCornerShape(4.dp),
                  color = Color(0xFFE0E7FF)
                ) {
                  Text(
                    text = "සටහන් 50",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4338CA),
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                  )
                }
              }
            }

            // Category Chips for 50 Rules
            LazyRow(
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 6.dp),
              horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
              items(EnglishSkillCategory.values()) { cat ->
                val isSelected = selectedSkillCategory == cat
                Surface(
                  onClick = { selectedSkillCategory = cat },
                  shape = RoundedCornerShape(16.dp),
                  color = if (isSelected) cat.primaryColor else Color.White,
                  border = BorderStroke(1.dp, if (isSelected) cat.primaryColor else Color(0xFFCBD5E1))
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(cat.iconEmoji, fontSize = 11.sp)
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(
                      text = cat.displayName,
                      fontSize = 10.sp,
                      fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                      color = if (isSelected) Color.White else Color(0xFF334155)
                    )
                  }
                }
              }
            }

            val rulesList = remember(selectedSkillCategory) {
              if (selectedSkillCategory == EnglishSkillCategory.ALL) {
                EnglishShortNotesRepository.grammarRulesList
              } else {
                EnglishShortNotesRepository.grammarRulesList.filter { it.category == selectedSkillCategory }
              }
            }

            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
              verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
              rulesList.forEachIndexed { idx, rule ->
                Card(
                  shape = RoundedCornerShape(12.dp),
                  colors = CardDefaults.cardColors(containerColor = Color.White),
                  border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Column(modifier = Modifier.padding(12.dp)) {
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.SpaceBetween,
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                          shape = CircleShape,
                          color = rule.category.primaryColor
                        ) {
                          Text(
                            text = "#${idx + 1}",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                          )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                          text = rule.title,
                          fontSize = 13.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFF0F172A)
                        )
                      }

                      IconButton(
                        onClick = { speakEnglish(rule.title + ". " + rule.formula) },
                        modifier = Modifier.size(26.dp)
                      ) {
                        Icon(Icons.Default.VolumeUp, contentDescription = null, tint = Color(0xFF0284C7), modifier = Modifier.size(16.dp))
                      }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    // Formula Banner
                    Surface(
                      shape = RoundedCornerShape(6.dp),
                      color = Color(0xFF0F172A),
                      modifier = Modifier.fillMaxWidth()
                    ) {
                      Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                      ) {
                        Text("⚡ Formula:", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                          text = rule.formula,
                          fontSize = 10.5.sp,
                          fontFamily = FontFamily.Monospace,
                          fontWeight = FontWeight.SemiBold,
                          color = Color(0xFFF1F5F9)
                        )
                      }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                      text = rule.explanationSinhala,
                      fontSize = 11.5.sp,
                      color = Color(0xFF334155),
                      lineHeight = 16.sp
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                      text = "නිදසුන් වාක්‍ය (Examples):",
                      fontSize = 10.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF059669)
                    )

                    rule.examples.forEach { eg ->
                      Row(
                        modifier = Modifier
                          .fillMaxWidth()
                          .padding(vertical = 1.5.dp),
                        verticalAlignment = Alignment.Top
                      ) {
                        Text("• ", color = Color(0xFF059669), fontWeight = FontWeight.Bold, fontSize = 11.sp)
                        Text(
                          text = eg,
                          fontSize = 11.sp,
                          color = Color(0xFF1E293B),
                          lineHeight = 15.sp
                        )
                      }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Surface(
                      shape = RoundedCornerShape(6.dp),
                      color = Color(0xFFFEF2F2),
                      border = BorderStroke(1.dp, Color(0xFFFECACA)),
                      modifier = Modifier.fillMaxWidth()
                    ) {
                      Row(modifier = Modifier.padding(6.dp), verticalAlignment = Alignment.CenterVertically) {
                        Text("⚠️", fontSize = 11.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                          text = rule.commonMistake,
                          fontSize = 10.sp,
                          color = Color(0xFF991B1B)
                        )
                      }
                    }
                  }
                }
              }
            }
          }
        } else if (currentTabMode == 2) {
          // TIMED EXAM SIMULATION (20 PARTS, 15 QUESTIONS EACH)
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 10.dp)
          ) {
            // Exam Part Selector Row
            Surface(
              color = Color.White,
              shape = RoundedCornerShape(10.dp),
              shadowElevation = 1.dp,
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
            ) {
              Column(modifier = Modifier.padding(10.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(
                    text = "⚡ විභාග කොටස් 20 (ප්‍රශ්න 15 බැගින්):",
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A)
                  )
                  Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = Color(0xFFFEF3C7)
                  ) {
                    Text(
                      text = "කොටස $selectedExamPart",
                      fontSize = 10.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFFB45309),
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                  }
                }

                Spacer(modifier = Modifier.height(6.dp))

                LazyRow(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                  items(20) { eIdx ->
                    val partNum = eIdx + 1
                    val isSelected = selectedExamPart == partNum

                    Surface(
                      onClick = { selectedExamPart = partNum },
                      shape = RoundedCornerShape(6.dp),
                      color = if (isSelected) Color(0xFF059669) else Color(0xFFF1F5F9),
                      border = BorderStroke(1.dp, if (isSelected) Color(0xFF059669) else Color(0xFFCBD5E1))
                    ) {
                      Text(
                        text = "Exam $partNum",
                        fontSize = 10.5.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = if (isSelected) Color.White else Color(0xFF334155),
                        modifier = Modifier.padding(horizontal = 9.dp, vertical = 5.dp)
                      )
                    }
                  }
                }
              }
            }

            val examPartQuestions = remember(selectedExamPart) {
              EnglishShortNotesRepository.getExamPart(selectedExamPart)
            }

            TimedEnglishExamHall(
              partNumber = selectedExamPart,
              questions = examPartQuestions,
              onFinish = { score, total ->
                Toast.makeText(context, "විභාගය අවසන් විය! ලකුණු: $score / $total", Toast.LENGTH_LONG).show()
              },
              onSpeak = { text -> speakEnglish(text) }
            )
          }
        }
      }
    }
  }

  // Full Screen Practice Dialog for students
  if (isFullScreenPractice) {
    FullScreenEnglishPracticeDialog(
      partNumber = selectedQuizPart,
      questions = currentPartQuestions,
      userAnswers = userAnswers,
      onSelectAnswer = { qId, optIdx -> userAnswers[qId] = optIdx },
      onSpeak = { speakEnglish(it) },
      onDismiss = { isFullScreenPractice = false }
    )
  }
}

@Composable
fun EnglishQuestionCard(
  item: EnglishShortNoteQuestionItem,
  selectedIndex: Int?,
  isBookmarked: Boolean,
  onSelectOption: (Int) -> Unit,
  onToggleBookmark: () -> Unit,
  onSpeak: (String) -> Unit
) {
  val isAnswered = selectedIndex != null
  val isCorrect = selectedIndex == item.correctOptionIndex

  Card(
    shape = RoundedCornerShape(12.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    border = BorderStroke(
      width = if (isAnswered) 1.5.dp else 1.dp,
      color = if (!isAnswered) Color(0xFFE2E8F0) else if (isCorrect) Color(0xFF10B981) else Color(0xFFEF4444)
    ),
    modifier = Modifier
      .fillMaxWidth()
      .testTag("eng_question_card_${item.number}")
  ) {
    Column(modifier = Modifier.padding(12.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Surface(
            shape = CircleShape,
            color = item.category.primaryColor
          ) {
            Text(
              text = "Q${item.number}",
              fontSize = 10.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White,
              modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
            )
          }

          Spacer(modifier = Modifier.width(6.dp))

          Surface(
            shape = RoundedCornerShape(4.dp),
            color = item.gradeLevel.badgeColor.copy(alpha = 0.15f)
          ) {
            Text(
              text = item.gradeLevel.label,
              fontSize = 9.sp,
              fontWeight = FontWeight.Bold,
              color = item.gradeLevel.badgeColor,
              modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
            )
          }
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
          IconButton(
            onClick = { onSpeak(item.questionPrompt) },
            modifier = Modifier.size(26.dp)
          ) {
            Icon(
              imageVector = Icons.Default.VolumeUp,
              contentDescription = "Read Aloud",
              tint = Color(0xFF0284C7),
              modifier = Modifier.size(16.dp)
            )
          }

          IconButton(
            onClick = onToggleBookmark,
            modifier = Modifier.size(26.dp)
          ) {
            Icon(
              imageVector = if (isBookmarked) Icons.Default.Star else Icons.Default.StarBorder,
              contentDescription = "Bookmark",
              tint = if (isBookmarked) Color(0xFFF59E0B) else Color(0xFF94A3B8),
              modifier = Modifier.size(18.dp)
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(4.dp))

      Text(
        text = item.topicTitle,
        fontSize = 10.5.sp,
        fontWeight = FontWeight.SemiBold,
        color = item.category.primaryColor
      )

      Spacer(modifier = Modifier.height(4.dp))

      // Question Prompt
      Text(
        text = item.questionPrompt,
        fontSize = 13.5.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF0F172A),
        lineHeight = 19.sp
      )

      Spacer(modifier = Modifier.height(4.dp))

      // Sinhala Guidance
      Text(
        text = "💡 ${item.questionSinhalaGuidance}",
        fontSize = 10.5.sp,
        color = Color(0xFF475569)
      )

      Spacer(modifier = Modifier.height(8.dp))

      // Multiple Choice Options
      Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
        item.options.forEachIndexed { optIdx, optText ->
          val isThisSelected = selectedIndex == optIdx
          val isThisCorrect = optIdx == item.correctOptionIndex

          val optionBg = when {
            !isAnswered -> Color(0xFFF8FAFC)
            isThisCorrect -> Color(0xFFECFDF5)
            isThisSelected && !isCorrect -> Color(0xFFFEF2F2)
            else -> Color(0xFFF8FAFC)
          }

          val optionBorder = when {
            !isAnswered -> if (isThisSelected) Color(0xFF0284C7) else Color(0xFFCBD5E1)
            isThisCorrect -> Color(0xFF10B981)
            isThisSelected && !isCorrect -> Color(0xFFEF4444)
            else -> Color(0xFFE2E8F0)
          }

          Surface(
            onClick = { onSelectOption(optIdx) },
            shape = RoundedCornerShape(8.dp),
            color = optionBg,
            border = BorderStroke(1.dp, optionBorder),
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 10.dp, vertical = 7.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = "${('A' + optIdx)}. ",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = if (isThisCorrect && isAnswered) Color(0xFF059669) else Color(0xFF475569)
              )
              Text(
                text = optText,
                fontSize = 12.sp,
                color = if (isThisCorrect && isAnswered) Color(0xFF065F46) else Color(0xFF1E293B),
                fontWeight = if (isThisSelected) FontWeight.Bold else FontWeight.Normal,
                modifier = Modifier.weight(1f)
              )

              if (isAnswered) {
                if (isThisCorrect) {
                  Text("✅", fontSize = 11.sp)
                } else if (isThisSelected) {
                  Text("❌", fontSize = 11.sp)
                }
              }
            }
          }
        }
      }

      // Auto-Check Feedback Card
      AnimatedVisibility(
        visible = isAnswered,
        enter = fadeIn() + expandVertically()
      ) {
        Column(modifier = Modifier.padding(top = 8.dp)) {
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = if (isCorrect) Color(0xFFECFDF5) else Color(0xFFFEF2F2),
            border = BorderStroke(1.dp, if (isCorrect) Color(0xFFA7F3D0) else Color(0xFFFECACA)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(10.dp)) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                  text = if (isCorrect) "🎉 නිවැරදියි! (Excellent!)" else "⚠️ වැරදියි! (Check Explanation)",
                  fontSize = 11.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = if (isCorrect) Color(0xFF065F46) else Color(0xFF991B1B)
                )
              }

              Spacer(modifier = Modifier.height(4.dp))

              Text(
                text = item.explanationSinhala,
                fontSize = 11.sp,
                color = Color(0xFF334155),
                lineHeight = 16.sp
              )

              if (item.grammarRuleOrFormula.isNotBlank()) {
                Spacer(modifier = Modifier.height(4.dp))
                Surface(
                  shape = RoundedCornerShape(4.dp),
                  color = Color(0xFF0F172A),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Text(
                    text = "📐 ${item.grammarRuleOrFormula}",
                    fontSize = 10.sp,
                    fontFamily = FontFamily.Monospace,
                    color = Color(0xFF38BDF8),
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                  )
                }
              }

              if (item.examTip.isNotBlank()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = "💡 Exam Tip: ${item.examTip}",
                  fontSize = 10.sp,
                  fontWeight = FontWeight.SemiBold,
                  color = Color(0xFFB45309)
                )
              }
            }
          }
        }
      }
    }
  }
}

/**
 * Full Screen Dedicated Practice Dialog for students (ප්‍රශ්න කරද්දි ෆුල් ස්ක්‍රීන්).
 */
@Composable
fun FullScreenEnglishPracticeDialog(
  partNumber: Int,
  questions: List<EnglishShortNoteQuestionItem>,
  userAnswers: MutableMap<String, Int>,
  onSelectAnswer: (String, Int) -> Unit,
  onSpeak: (String) -> Unit,
  onDismiss: () -> Unit
) {
  var currentIndex by remember { mutableIntStateOf(0) }
  val currentQ = questions.getOrNull(currentIndex)

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false)
  ) {
    Surface(
      modifier = Modifier.fillMaxSize(),
      color = Color(0xFF0F172A)
    ) {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(horizontal = 14.dp, vertical = 12.dp)
      ) {
        // Top Full Screen Header
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(
              shape = CircleShape,
              color = Color(0xFF0284C7)
            ) {
              Text(
                text = "කොටස $partNumber",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
              )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "ප්‍රශ්න ${currentIndex + 1} / ${questions.size}",
              fontSize = 14.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
          }

          Button(
            onClick = onDismiss,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF334155)),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
            modifier = Modifier.height(32.dp)
          ) {
            Icon(Icons.Default.Close, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text("පිටවීම", fontSize = 11.sp, color = Color.White)
          }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Progress Bar
        LinearProgressIndicator(
          progress = { if (questions.isNotEmpty()) (currentIndex + 1).toFloat() / questions.size else 0f },
          modifier = Modifier
            .fillMaxWidth()
            .height(6.dp)
            .clip(RoundedCornerShape(3.dp)),
          color = Color(0xFF38BDF8),
          trackColor = Color(0xFF1E293B)
        )

        Spacer(modifier = Modifier.height(10.dp))

        if (currentQ != null) {
          val selectedIdx = userAnswers[currentQ.id]
          val isAnswered = selectedIdx != null
          val isCorrect = selectedIdx == currentQ.correctOptionIndex

          LazyColumn(
            modifier = Modifier
              .weight(1f)
              .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            item {
              // Question White Card
              Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(14.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(
                      text = currentQ.topicTitle,
                      fontSize = 11.sp,
                      fontWeight = FontWeight.SemiBold,
                      color = currentQ.category.primaryColor
                    )

                    IconButton(
                      onClick = { onSpeak(currentQ.questionPrompt) },
                      modifier = Modifier.size(28.dp)
                    ) {
                      Icon(Icons.Default.VolumeUp, contentDescription = null, tint = Color(0xFF0284C7))
                    }
                  }

                  Spacer(modifier = Modifier.height(6.dp))

                  Text(
                    text = currentQ.questionPrompt,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A),
                    lineHeight = 22.sp
                  )

                  Spacer(modifier = Modifier.height(4.dp))

                  Text(
                    text = "💡 ${currentQ.questionSinhalaGuidance}",
                    fontSize = 11.5.sp,
                    color = Color(0xFF475569)
                  )

                  Spacer(modifier = Modifier.height(12.dp))

                  // Options
                  currentQ.options.forEachIndexed { optIdx, optText ->
                    val isThisSelected = selectedIdx == optIdx
                    val isThisCorrect = optIdx == currentQ.correctOptionIndex

                    val optBg = when {
                      !isAnswered -> Color(0xFFF8FAFC)
                      isThisCorrect -> Color(0xFFECFDF5)
                      isThisSelected && !isCorrect -> Color(0xFFFEF2F2)
                      else -> Color(0xFFF8FAFC)
                    }

                    val optBorder = when {
                      !isAnswered -> if (isThisSelected) Color(0xFF0284C7) else Color(0xFFCBD5E1)
                      isThisCorrect -> Color(0xFF10B981)
                      isThisSelected && !isCorrect -> Color(0xFFEF4444)
                      else -> Color(0xFFE2E8F0)
                    }

                    Surface(
                      onClick = { onSelectAnswer(currentQ.id, optIdx) },
                      shape = RoundedCornerShape(10.dp),
                      color = optBg,
                      border = BorderStroke(1.2.dp, optBorder),
                      modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp)
                    ) {
                      Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                      ) {
                        Text(
                          text = "${('A' + optIdx)}. ",
                          fontSize = 12.sp,
                          fontWeight = FontWeight.Bold,
                          color = if (isThisCorrect && isAnswered) Color(0xFF059669) else Color(0xFF475569)
                        )
                        Text(
                          text = optText,
                          fontSize = 13.sp,
                          color = if (isThisCorrect && isAnswered) Color(0xFF065F46) else Color(0xFF1E293B),
                          fontWeight = if (isThisSelected) FontWeight.Bold else FontWeight.Normal,
                          modifier = Modifier.weight(1f)
                        )
                        if (isAnswered) {
                          if (isThisCorrect) Text("✅", fontSize = 13.sp)
                          else if (isThisSelected) Text("❌", fontSize = 13.sp)
                        }
                      }
                    }
                  }

                  // Auto-Check Explanation in Full Screen
                  if (isAnswered) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Surface(
                      shape = RoundedCornerShape(10.dp),
                      color = if (isCorrect) Color(0xFFECFDF5) else Color(0xFFFEF2F2),
                      border = BorderStroke(1.dp, if (isCorrect) Color(0xFFA7F3D0) else Color(0xFFFECACA)),
                      modifier = Modifier.fillMaxWidth()
                    ) {
                      Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                          text = if (isCorrect) "🎉 නිවැරදියි! (Correct!)" else "⚠️ වැරදියි! නිවැරදි පිළිතුර විමසන්න:",
                          fontSize = 12.5.sp,
                          fontWeight = FontWeight.Bold,
                          color = if (isCorrect) Color(0xFF065F46) else Color(0xFF991B1B)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                          text = currentQ.explanationSinhala,
                          fontSize = 12.sp,
                          color = Color(0xFF334155),
                          lineHeight = 17.sp
                        )
                        if (currentQ.grammarRuleOrFormula.isNotBlank()) {
                          Spacer(modifier = Modifier.height(6.dp))
                          Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFF0F172A),
                            modifier = Modifier.fillMaxWidth()
                          ) {
                            Text(
                              text = "📐 ${currentQ.grammarRuleOrFormula}",
                              fontSize = 11.sp,
                              fontFamily = FontFamily.Monospace,
                              color = Color(0xFF38BDF8),
                              modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
                            )
                          }
                        }
                        if (currentQ.examTip.isNotBlank()) {
                          Spacer(modifier = Modifier.height(4.dp))
                          Text(
                            text = "💡 Exam Tip: ${currentQ.examTip}",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFB45309)
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

        // Bottom Navigation Controls
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Button(
            onClick = { if (currentIndex > 0) currentIndex-- },
            enabled = currentIndex > 0,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF334155)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.height(40.dp)
          ) {
            Icon(Icons.Default.ArrowBack, contentDescription = null, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text("පෙර ප්‍රශ්නය", fontSize = 11.5.sp)
          }

          if (currentIndex < questions.size - 1) {
            Button(
              onClick = { currentIndex++ },
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
              shape = RoundedCornerShape(8.dp),
              modifier = Modifier.height(40.dp)
            ) {
              Text("මීළඟ ප්‍රශ්නය", fontSize = 11.5.sp)
              Spacer(modifier = Modifier.width(4.dp))
              Icon(Icons.Default.ArrowForward, contentDescription = null, modifier = Modifier.size(16.dp))
            }
          } else {
            Button(
              onClick = onDismiss,
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
              shape = RoundedCornerShape(8.dp),
              modifier = Modifier.height(40.dp)
            ) {
              Text("අවසන් කරන්න", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
            }
          }
        }
      }
    }
  }
}

/**
 * Timed English Exam Hall supporting 20 Distinct Simulation Parts (15 Questions Each)
 */
@Composable
fun TimedEnglishExamHall(
  partNumber: Int,
  questions: List<EnglishShortNoteQuestionItem>,
  onFinish: (score: Int, total: Int) -> Unit,
  onSpeak: (String) -> Unit
) {
  var currentIndex by remember(partNumber) { mutableIntStateOf(0) }
  val answers = remember(partNumber) { mutableStateMapOf<Int, Int>() }
  var isSubmitted by remember(partNumber) { mutableStateOf(false) }

  val totalQuestions = questions.size
  val currentQuestion = questions.getOrNull(currentIndex)

  val score = answers.count { (qIdx, selectedOpt) ->
    questions.getOrNull(qIdx)?.correctOptionIndex == selectedOpt
  }

  if (isSubmitted) {
    Card(
      shape = RoundedCornerShape(14.dp),
      colors = CardDefaults.cardColors(containerColor = Color.White),
      modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 10.dp)
    ) {
      Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text("🏆", fontSize = 42.sp)
        Spacer(modifier = Modifier.height(6.dp))
        Text(
          text = "විභාග ප්‍රතිඵල වාර්තාව - කොටස $partNumber",
          fontSize = 15.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFF0F172A)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = "ලකුණු: $score / $totalQuestions (${if (totalQuestions > 0) score * 100 / totalQuestions else 0}%)",
          fontSize = 18.sp,
          fontWeight = FontWeight.ExtraBold,
          color = if (score >= totalQuestions * 0.75) Color(0xFF10B981) else Color(0xFF0284C7)
        )

        Spacer(modifier = Modifier.height(14.dp))

        Button(
          onClick = {
            answers.clear()
            currentIndex = 0
            isSubmitted = false
          },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
          shape = RoundedCornerShape(8.dp)
        ) {
          Text("නැවත විභාගය කරන්න (Retake Part $partNumber)", fontSize = 12.sp)
        }
      }
    }
  } else if (currentQuestion != null) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = "කොටස $partNumber • ප්‍රශ්න ${currentIndex + 1} / $totalQuestions",
          fontWeight = FontWeight.Bold,
          fontSize = 12.5.sp,
          color = Color(0xFF0F172A)
        )

        LinearProgressIndicator(
          progress = { (currentIndex + 1).toFloat() / totalQuestions },
          modifier = Modifier
            .width(100.dp)
            .height(7.dp)
            .clip(RoundedCornerShape(4.dp)),
          color = Color(0xFF059669)
        )
      }

      Spacer(modifier = Modifier.height(8.dp))

      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Surface(
              shape = RoundedCornerShape(4.dp),
              color = currentQuestion.gradeLevel.badgeColor
            ) {
              Text(
                text = currentQuestion.gradeLevel.label,
                fontSize = 8.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
              )
            }

            IconButton(
              onClick = { onSpeak(currentQuestion.questionPrompt) },
              modifier = Modifier.size(24.dp)
            ) {
              Icon(Icons.Default.VolumeUp, contentDescription = "Audio", tint = Color(0xFF0284C7), modifier = Modifier.size(16.dp))
            }
          }

          Spacer(modifier = Modifier.height(6.dp))

          Text(
            text = currentQuestion.questionPrompt,
            fontSize = 13.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0F172A),
            lineHeight = 19.sp
          )

          Spacer(modifier = Modifier.height(4.dp))

          Text(
            text = "💡 ${currentQuestion.questionSinhalaGuidance}",
            fontSize = 10.5.sp,
            color = Color(0xFF64748B)
          )

          Spacer(modifier = Modifier.height(8.dp))

          currentQuestion.options.forEachIndexed { optIdx, optText ->
            val isSelected = answers[currentIndex] == optIdx
            Surface(
              onClick = { answers[currentIndex] = optIdx },
              shape = RoundedCornerShape(8.dp),
              color = if (isSelected) Color(0xFFE0F2FE) else Color(0xFFF8FAFC),
              border = BorderStroke(1.dp, if (isSelected) Color(0xFF0284C7) else Color(0xFFCBD5E1)),
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 3.dp)
            ) {
              Text(
                text = optText,
                fontSize = 11.5.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                color = if (isSelected) Color(0xFF0369A1) else Color(0xFF1E293B),
                modifier = Modifier.padding(10.dp)
              )
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(12.dp))

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Button(
          onClick = { if (currentIndex > 0) currentIndex-- },
          enabled = currentIndex > 0,
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF64748B)),
          shape = RoundedCornerShape(8.dp),
          modifier = Modifier.height(36.dp)
        ) {
          Text("පෙර ප්‍රශ්නය", fontSize = 11.sp)
        }

        if (currentIndex < totalQuestions - 1) {
          Button(
            onClick = { currentIndex++ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.height(36.dp)
          ) {
            Text("මීළඟ ප්‍රශ්නය", fontSize = 11.sp)
          }
        } else {
          Button(
            onClick = {
              isSubmitted = true
              onFinish(score, totalQuestions)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.height(36.dp)
          ) {
            Text("විභාගය අවසන් කරන්න", fontSize = 11.sp)
          }
        }
      }
    }
  }
}
