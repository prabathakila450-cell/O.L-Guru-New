package com.example

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.content.ContextCompat
import com.example.ui.theme.BluePrimary
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Locale

// ==============================================================================
// FEATURE 3: AI VOICE QUIZ & ORAL EXAM SIMULATION (කටහඬින් ප්‍රශ්න ඇසීම & වාචික විභාගය)
// ==============================================================================

data class VoiceQuestionItem(
  val id: String,
  val subject: String,
  val questionSinhala: String,
  val questionEnglishPhonetic: String,
  val expectedKeywords: List<String>,
  val modelAnswer: String,
  val hint: String,
  val grade: String = "10",
  val setNumber: Int = 1,
  val questionIndexInSet: Int = 1,
  val globalIndex: Int = 1,
  val unitCategory: String = ""
)

object VoiceQuizRepository {
  fun getQuestions(grade: String = "10", subjectFilter: String = "විද්‍යාව", setNumber: Int? = 1): List<VoiceQuestionItem> {
    return ComprehensiveVoiceQuizRepository.getQuestions(grade, subjectFilter, setNumber)
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoiceQuizScreen(
  onBack: () -> Unit
) {
  val context = LocalContext.current
  val coroutineScope = rememberCoroutineScope()

  // Selection states: Grade (9, 10, 11), Subject, Set (1..10 or null for all 200)
  var selectedGrade by remember { mutableStateOf("10") }
  var selectedSubject by remember { mutableStateOf("විද්‍යාව") }
  var selectedSetNumber by remember { mutableStateOf<Int?>(1) } // 1..10 or null (all 200)

  var showSetsDialog by remember { mutableStateOf(false) }
  var showTypeAnswerDialog by remember { mutableStateOf(false) }
  var typedAnswerInput by remember { mutableStateOf("") }

  val questions = remember(selectedGrade, selectedSubject, selectedSetNumber) {
    ComprehensiveVoiceQuizRepository.getQuestions(selectedGrade, selectedSubject, selectedSetNumber)
  }

  var currentIndex by remember { mutableStateOf(0) }
  val currentQuestion = questions.getOrNull(currentIndex) ?: questions.firstOrNull() ?: VoiceQuestionItem(
    id = "vq_empty",
    subject = selectedSubject,
    questionSinhala = "ප්‍රශ්න සූදානම් වෙමින් පවතී...",
    questionEnglishPhonetic = "Loading question...",
    expectedKeywords = emptyList(),
    modelAnswer = "",
    hint = "",
    grade = selectedGrade,
    setNumber = 1,
    questionIndexInSet = 1,
    globalIndex = 1
  )

  var isSpeakingQuestion by remember { mutableStateOf(false) }
  var isListeningMic by remember { mutableStateOf(false) }
  var recordedTranscription by remember { mutableStateOf("") }
  var evaluationResult by remember { mutableStateOf<String?>(null) }
  var scoreEarned by remember { mutableStateOf<Int?>(null) }
  var isAnswerCorrect by remember { mutableStateOf<Boolean?>(null) }
  var matchedKeywordsList by remember { mutableStateOf<List<String>>(emptyList()) }
  var showModelAnswer by remember { mutableStateOf(false) }

  // TTS helper
  var tts by remember { mutableStateOf<TextToSpeech?>(null) }
  DisposableEffect(Unit) {
    var engine: TextToSpeech? = null
    engine = TextToSpeech(context) { status ->
      if (status == TextToSpeech.SUCCESS) {
        engine?.language = Locale.ENGLISH
      }
    }
    tts = engine
    onDispose {
      engine?.stop()
      engine?.shutdown()
    }
  }

  // Strict evaluation logic - ONLY evaluates what user actually provided
  fun evaluateAnswer(userSpokenOrTyped: String) {
    val cleanInput = userSpokenOrTyped.trim().lowercase()
    if (cleanInput.isBlank()) {
      recordedTranscription = ""
      scoreEarned = 0
      isAnswerCorrect = false
      matchedKeywordsList = emptyList()
      evaluationResult = "⚠️ කිසිදු පිළිතුරක් හෝ හඬක් හඳුනාගෙන නොමැත. කරුණාකර මයික්‍රෆෝනය ඔබා නැවත කතා කරන්න හෝ පිළිතුර ටයිප් කරන්න."
      return
    }

    recordedTranscription = userSpokenOrTyped.trim()

    val matched = currentQuestion.expectedKeywords.filter { keyword ->
      val cleanKeyword = keyword.trim().lowercase()
      if (cleanKeyword.length <= 2) {
        cleanInput.contains(cleanKeyword)
      } else {
        cleanInput.contains(cleanKeyword) ||
          cleanKeyword.split(" ").filter { it.length > 2 }.any { cleanInput.contains(it) }
      }
    }

    matchedKeywordsList = matched
    val totalKeywords = currentQuestion.expectedKeywords.size
    val matchRatio = if (totalKeywords > 0) matched.size.toFloat() / totalKeywords else 0f

    showModelAnswer = true

    if (matched.isEmpty()) {
      // User did not provide any of the correct expected keywords!
      scoreEarned = 0
      isAnswerCorrect = false
      evaluationResult = "❌ පිළිතුර වැරදියි (Incorrect). ඔබ ලබාදුන් පිළිතුරේ අදාළ මූල පද (Key Terms) කිසිවක් හඳුනාගැනීමට නොහැකි විය. කරුණාකර නිවැරදි ආදර්ශ පිළිතුර බලන්න."
    } else if (matchRatio >= 0.6f || matched.size >= 2 || (totalKeywords <= 2 && matched.isNotEmpty())) {
      // Good / Correct answer
      val score = (85 + (matchRatio * 15)).toInt().coerceIn(85, 100)
      scoreEarned = score
      isAnswerCorrect = true
      evaluationResult = "✅ විශිෂ්ටයි! නිවැරදි පිළිතුරකි (Correct). ප්‍රධාන මූල පද (${matched.joinToString(", ")}) ඔබ නිවැරදිව ප්‍රකාශ කළා."
    } else {
      // Partially correct
      val score = (40 + (matchRatio * 30)).toInt().coerceIn(40, 65)
      scoreEarned = score
      isAnswerCorrect = false
      evaluationResult = "⚠️ අර්ධ වශයෙන් නිවැරදියි (Partially Correct). ඔබ '${matched.joinToString(", ")}' ප්‍රකාශ කළ නමුත් තවදුරටත් මූල පද අවශ්‍ය වේ."
    }
  }

  // Native Speech Recognizer Launcher
  val speechLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.StartActivityForResult()
  ) { result ->
    isListeningMic = false
    if (result.resultCode == Activity.RESULT_OK && result.data != null) {
      val matches = result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
      val spoken = matches?.firstOrNull()?.trim() ?: ""
      if (spoken.isNotBlank()) {
        evaluateAnswer(spoken)
      } else {
        recordedTranscription = ""
        scoreEarned = 0
        isAnswerCorrect = false
        evaluationResult = "⚠️ කිසිදු ශබ්දයක් හෝ වචනයක් හඳුනා නොගති. කරුණාකර මයික්‍රෆෝනය අසලින් පැහැදිලිව කතා කරන්න."
      }
    } else {
      isListeningMic = false
      recordedTranscription = ""
      scoreEarned = 0
      isAnswerCorrect = false
      evaluationResult = "⚠️ හඬ හඳුනාගැනීම අවලංගු විය. කරුණාකර නැවත උත්සාහ කරන්න හෝ පහතින් ඇති 'පිළිතුර ටයිප් කරන්න' භාවිත කරන්න."
    }
  }

  // Permission Launcher for Microphone
  val micPermissionLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.RequestPermission()
  ) { isGranted ->
    if (isGranted) {
      val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
        putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        if (currentQuestion.subject == "English") {
          putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US")
        } else {
          putExtra(RecognizerIntent.EXTRA_LANGUAGE, "si-LK")
          putExtra(RecognizerIntent.EXTRA_SUPPORTED_LANGUAGES, arrayListOf("si-LK", "en-US"))
        }
        putExtra(RecognizerIntent.EXTRA_PROMPT, "ඔබගේ වාචික පිළිතුර පවසන්න (Speak your answer)...")
      }
      try {
        isListeningMic = true
        evaluationResult = null
        speechLauncher.launch(intent)
      } catch (e: Exception) {
        isListeningMic = false
        Toast.makeText(context, "Speech recognition is not available. Please use 'Type Answer'.", Toast.LENGTH_SHORT).show()
        showTypeAnswerDialog = true
      }
    } else {
      Toast.makeText(context, "Microphone permission is required for voice answering.", Toast.LENGTH_SHORT).show()
    }
  }

  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(Color(0xFF0F172A))
  ) {
    // Top Bar
    Surface(
      color = Color(0xFF1E293B),
      modifier = Modifier.fillMaxWidth()
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 14.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          IconButton(
            onClick = {
              tts?.stop()
              onBack()
            }
          ) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
          }
          Spacer(modifier = Modifier.width(6.dp))
          Column {
            Text(
              text = "🎙️ AI Voice Quiz & Oral Exam",
              style = MaterialTheme.typography.titleMedium,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Text(
              text = "එක් එක් ශ්‍රේණියේ විෂයන් සඳහා ප්‍රශ්න 200 (කාණ්ඩ 10)",
              fontSize = 11.sp,
              color = Color(0xFF94A3B8)
            )
          }
        }

        IconButton(
          onClick = { showSetsDialog = true }
        ) {
          Icon(Icons.Default.MenuBook, contentDescription = "Sets Overview", tint = Color(0xFF60A5FA))
        }
      }
    }

    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp),
      verticalArrangement = Arrangement.spacedBy(14.dp),
      contentPadding = PaddingValues(top = 12.dp, bottom = 32.dp)
    ) {
      // 1. Grade Selector: 9, 10, 11
      item {
        Column {
          Text(
            text = "🎓 ශ්‍රේණිය තෝරන්න (Grade)",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF94A3B8),
            modifier = Modifier.padding(bottom = 6.dp)
          )
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            ComprehensiveVoiceQuizRepository.availableGrades.forEach { gr ->
              val isSelected = selectedGrade == gr
              Surface(
                onClick = {
                  selectedGrade = gr
                  currentIndex = 0
                  evaluationResult = null
                  recordedTranscription = ""
                  scoreEarned = null
                  isAnswerCorrect = null
                  showModelAnswer = false
                },
                shape = RoundedCornerShape(10.dp),
                color = if (isSelected) Color(0xFF2563EB) else Color(0xFF1E293B),
                border = BorderStroke(1.dp, if (isSelected) Color(0xFF60A5FA) else Color(0xFF334155)),
                modifier = Modifier.weight(1f)
              ) {
                Text(
                  text = "$gr ශ්‍රේණිය",
                  fontSize = 13.sp,
                  fontWeight = FontWeight.Bold,
                  color = if (isSelected) Color.White else Color(0xFFCBD5E1),
                  textAlign = TextAlign.Center,
                  modifier = Modifier.padding(vertical = 8.dp)
                )
              }
            }
          }
        }
      }

      // 2. Subject Selector
      item {
        Column {
          Text(
            text = "📚 විෂය තෝරන්න (Subject - ප්‍රශ්න 200 බැගින්)",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF94A3B8),
            modifier = Modifier.padding(bottom = 6.dp)
          )
          LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(ComprehensiveVoiceQuizRepository.availableSubjects) { subj ->
              val isSelected = selectedSubject == subj
              Surface(
                onClick = {
                  selectedSubject = subj
                  currentIndex = 0
                  evaluationResult = null
                  recordedTranscription = ""
                  scoreEarned = null
                  isAnswerCorrect = null
                  showModelAnswer = false
                },
                shape = RoundedCornerShape(10.dp),
                color = if (isSelected) Color(0xFF2563EB) else Color(0xFF1E293B),
                border = BorderStroke(1.dp, if (isSelected) Color(0xFF60A5FA) else Color(0xFF334155))
              ) {
                Text(
                  text = subj,
                  fontSize = 12.sp,
                  fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                  color = if (isSelected) Color.White else Color(0xFFCBD5E1),
                  modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                )
              }
            }
          }
        }
      }

      // 3. Sets of 20 Selector (10 Sets of 20 = 200 Questions)
      item {
        val sets = ComprehensiveVoiceQuizRepository.getSetsForSubject(selectedGrade, selectedSubject)
        Column {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "📑 විස්සේ කාණ්ඩ 10 (Sets of 20)",
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF94A3B8)
            )
            TextButton(
              onClick = { showSetsDialog = true },
              contentPadding = PaddingValues(0.dp)
            ) {
              Text("සියලු කාණ්ඩ (Overview) ›", fontSize = 11.sp, color = Color(0xFF60A5FA))
            }
          }

          LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(sets) { setInfo ->
              val isSelected = selectedSetNumber == setInfo.setNumber
              Surface(
                onClick = {
                  selectedSetNumber = setInfo.setNumber
                  currentIndex = 0
                  evaluationResult = null
                  recordedTranscription = ""
                  scoreEarned = null
                  isAnswerCorrect = null
                  showModelAnswer = false
                },
                shape = RoundedCornerShape(10.dp),
                color = if (isSelected) Color(0xFF0284C7) else Color(0xFF1E293B),
                border = BorderStroke(1.dp, if (isSelected) Color(0xFF38BDF8) else Color(0xFF334155))
              ) {
                Text(
                  text = "කාණ්ඩය ${setInfo.setNumber} (${setInfo.startQuestionNum}-${setInfo.endQuestionNum})",
                  fontSize = 11.sp,
                  fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                  color = if (isSelected) Color.White else Color(0xFFCBD5E1),
                  modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                )
              }
            }

            // All 200 option
            item {
              val isAll = selectedSetNumber == null
              Surface(
                onClick = {
                  selectedSetNumber = null
                  currentIndex = 0
                  evaluationResult = null
                  recordedTranscription = ""
                  scoreEarned = null
                  isAnswerCorrect = null
                  showModelAnswer = false
                },
                shape = RoundedCornerShape(10.dp),
                color = if (isAll) Color(0xFF7C3AED) else Color(0xFF1E293B),
                border = BorderStroke(1.dp, if (isAll) Color(0xFFA78BFA) else Color(0xFF334155))
              ) {
                Text(
                  text = "සියලු 200ම (All)",
                  fontSize = 11.sp,
                  fontWeight = if (isAll) FontWeight.Bold else FontWeight.Medium,
                  color = if (isAll) Color.White else Color(0xFFCBD5E1),
                  modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                )
              }
            }
          }
        }
      }

      // 4. Question Card with Audio Speak
      item {
        Card(
          shape = RoundedCornerShape(22.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFF334155)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .padding(16.dp)
          ) {
            // Header Row: Subject & Set Badge + Audio Listen Button
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF2563EB)
              ) {
                Text(
                  text = if (selectedSetNumber != null) {
                    "${currentQuestion.subject} • කාණ්ඩය $selectedSetNumber • ප්‍රශ්න ${currentQuestion.questionIndexInSet}/20"
                  } else {
                    "${currentQuestion.subject} • ප්‍රශ්න ${currentQuestion.globalIndex}/200"
                  },
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
              }

              Button(
                onClick = {
                  if (isSpeakingQuestion) {
                    tts?.stop()
                    isSpeakingQuestion = false
                  } else {
                    isSpeakingQuestion = true
                    val speechText = if (currentQuestion.subject == "English") {
                      currentQuestion.questionSinhala
                    } else {
                      currentQuestion.questionEnglishPhonetic
                    }
                    tts?.speak(speechText, TextToSpeech.QUEUE_FLUSH, null, "voice_quiz_tts")
                  }
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.filledTonalButtonColors(
                  containerColor = if (isSpeakingQuestion) Color(0xFF22C55E) else Color(0xFF38BDF8).copy(alpha = 0.15f),
                  contentColor = if (isSpeakingQuestion) Color.White else Color(0xFF38BDF8)
                ),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
              ) {
                Icon(
                  imageVector = if (isSpeakingQuestion) Icons.Default.VolumeUp else Icons.Default.VolumeDown,
                  contentDescription = "Listen",
                  modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                  text = if (isSpeakingQuestion) "කියවමින්..." else "හඬින් අසන්න",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold
                )
              }
            }

            // Unit / Topic Chip
            if (currentQuestion.unitCategory.isNotBlank()) {
              Spacer(modifier = Modifier.height(10.dp))
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF0F172A),
                border = BorderStroke(1.dp, Color(0xFF0284C7).copy(alpha = 0.35f)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(
                    text = "📌 ඒකකය:",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF38BDF8)
                  )
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = currentQuestion.unitCategory,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFFE2E8F0),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                }
              }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Dedicated High-Visibility Question Box (Separate from outer card, bold & prominent)
            Surface(
              shape = RoundedCornerShape(14.dp),
              color = Color(0xFF0B132B),
              border = BorderStroke(1.5.dp, Color(0xFF38BDF8).copy(alpha = 0.5f)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(16.dp)
              ) {
                Row(
                  verticalAlignment = Alignment.CenterVertically,
                  modifier = Modifier.padding(bottom = 8.dp)
                ) {
                  Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFFF59E0B).copy(alpha = 0.2f),
                    border = BorderStroke(1.dp, Color(0xFFF59E0B).copy(alpha = 0.5f))
                  ) {
                    Text(
                      text = "❓ කෙටි ප්‍රශ්නය (Short Question)",
                      fontSize = 11.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFFFBBF24),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                  }
                }

                Text(
                  text = currentQuestion.questionSinhala,
                  fontSize = 18.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  lineHeight = 26.sp
                )
              }
            }
          }
        }
      }

      // 5. Voice & Text Response Area
      item {
        Card(
          shape = RoundedCornerShape(20.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFF334155)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(
            modifier = Modifier
              .padding(18.dp)
              .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text(
              text = if (isListeningMic) "🎙️ සවන්දෙමින් පවතී... පැහැදිලිව පිළිතුර පවසන්න" else "මයික්‍රෆෝනය ඔබා වාචිකව පිළිතුරු සපයන්න",
              fontSize = 12.sp,
              fontWeight = FontWeight.SemiBold,
              color = if (isListeningMic) Color(0xFFF87171) else Color(0xFFCBD5E1)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Microphone Button
            Box(
              modifier = Modifier
                .size(76.dp)
                .clip(CircleShape)
                .background(
                  if (isListeningMic) {
                    Brush.radialGradient(
                      colors = listOf(Color(0xFFEF4444), Color(0xFF991B1B))
                    )
                  } else {
                    Brush.radialGradient(
                      colors = listOf(Color(0xFF2563EB), Color(0xFF1D4ED8))
                    )
                  }
                )
                .clickable {
                  if (!isListeningMic) {
                    micPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                  }
                },
              contentAlignment = Alignment.Center
            ) {
              Icon(
                imageVector = if (isListeningMic) Icons.Default.Mic else Icons.Default.MicNone,
                contentDescription = "Microphone",
                tint = Color.White,
                modifier = Modifier.size(36.dp)
              )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
              text = if (isListeningMic) "සවන්දෙමින් පවතී..." else "තට්ටු කර පිළිතුර පවසන්න (Tap to Speak)",
              fontSize = 11.sp,
              color = Color(0xFF64748B)
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Alternative: Type Answer Button
            OutlinedButton(
              onClick = {
                typedAnswerInput = recordedTranscription
                showTypeAnswerDialog = true
              },
              shape = RoundedCornerShape(12.dp),
              colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF60A5FA)),
              border = BorderStroke(1.dp, Color(0xFF3B82F6))
            ) {
              Icon(Icons.Default.Keyboard, contentDescription = null, modifier = Modifier.size(16.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text("⌨️ පිළිතුර ටයිප් කරන්න (Type Answer)", fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
          }
        }
      }

      // 6. Live Strict Evaluation Card (Shows REAL accuracy, never fabricated)
      if (evaluationResult != null) {
        item {
          val isSuccess = isAnswerCorrect == true
          val isPartial = !isSuccess && (scoreEarned ?: 0) > 0
          val cardBg = if (isSuccess) Color(0xFF064E3B) else if (isPartial) Color(0xFF78350F) else Color(0xFF450A0A)
          val cardBorder = if (isSuccess) Color(0xFF059669) else if (isPartial) Color(0xFFD97706) else Color(0xFFDC2626)
          val badgeColor = if (isSuccess) Color(0xFF059669) else if (isPartial) Color(0xFFB45309) else Color(0xFFB91C1C)

          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = cardBg),
            border = BorderStroke(1.dp, cardBorder),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(16.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Icon(
                    imageVector = if (isSuccess) Icons.Default.CheckCircle else if (isPartial) Icons.Default.Info else Icons.Default.Cancel,
                    contentDescription = null,
                    tint = if (isSuccess) Color(0xFF34D399) else if (isPartial) Color(0xFFFBBF24) else Color(0xFFF87171)
                  )
                  Spacer(modifier = Modifier.width(8.dp))
                  Text(
                    text = "AI වාචික ඇගයීම (Oral Evaluation)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = Color.White
                  )
                }

                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = badgeColor
                ) {
                  Text(
                    text = "ලකුණු: ${scoreEarned ?: 0}/100",
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                  )
                }
              }

              if (recordedTranscription.isNotBlank()) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                  text = "🗣️ ඔබ ලබාදුන් පිළිතුර: \"$recordedTranscription\"",
                  fontSize = 12.sp,
                  color = if (isSuccess) Color(0xFFA7F3D0) else if (isPartial) Color(0xFFFDE68A) else Color(0xFFFECACA)
                )
              }

              Spacer(modifier = Modifier.height(6.dp))
              Text(
                text = evaluationResult ?: "",
                fontSize = 12.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium
              )

              if (!isSuccess && currentQuestion.expectedKeywords.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                  text = "🔍 අපේක්ෂිත මූල පද: ${currentQuestion.expectedKeywords.joinToString(", ")}",
                  fontSize = 11.sp,
                  color = Color(0xFFCBD5E1)
                )
              }

              Spacer(modifier = Modifier.height(12.dp))

              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
              ) {
                // Retry Button
                OutlinedButton(
                  onClick = {
                    evaluationResult = null
                    recordedTranscription = ""
                    scoreEarned = null
                    isAnswerCorrect = null
                    showModelAnswer = false
                  },
                  shape = RoundedCornerShape(8.dp),
                  colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                  border = BorderStroke(1.dp, Color(0xFF94A3B8)),
                  modifier = Modifier.weight(1f)
                ) {
                  Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(14.dp))
                  Spacer(modifier = Modifier.width(4.dp))
                  Text("නැවත උත්සාහ කරන්න", fontSize = 11.sp)
                }

                // Show Model Answer Button
                Button(
                  onClick = { showModelAnswer = !showModelAnswer },
                  shape = RoundedCornerShape(8.dp),
                  colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB)),
                  modifier = Modifier.weight(1f)
                ) {
                  Icon(
                    if (showModelAnswer) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    contentDescription = null,
                    modifier = Modifier.size(14.dp)
                  )
                  Spacer(modifier = Modifier.width(4.dp))
                  Text(if (showModelAnswer) "පිළිතුර සඟවන්න" else "ආදර්ශ පිළිතුර", fontSize = 11.sp)
                }
              }

              if (showModelAnswer) {
                Spacer(modifier = Modifier.height(10.dp))
                Surface(
                  shape = RoundedCornerShape(10.dp),
                  color = Color(0xFF0F172A).copy(alpha = 0.8f),
                  border = BorderStroke(1.dp, Color(0xFF334155)),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                      text = "📖 විභාග නිල ආදර්ශ පිළිතුර (Model Answer):",
                      fontSize = 11.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF38BDF8)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                      text = currentQuestion.modelAnswer,
                      fontSize = 12.sp,
                      color = Color(0xFFF1F5F9),
                      lineHeight = 18.sp
                    )
                  }
                }
              }
            }
          }
        }
      }

      // 7. Navigation Buttons
      item {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          OutlinedButton(
            onClick = {
              if (currentIndex > 0) {
                currentIndex--
                evaluationResult = null
                recordedTranscription = ""
                scoreEarned = null
                isAnswerCorrect = null
                showModelAnswer = false
              }
            },
            enabled = currentIndex > 0,
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF94A3B8))
          ) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text("පෙර ප්‍රශ්නය", fontSize = 11.sp)
          }

          Button(
            onClick = {
              if (currentIndex < questions.size - 1) {
                currentIndex++
                evaluationResult = null
                recordedTranscription = ""
                scoreEarned = null
                isAnswerCorrect = null
                showModelAnswer = false
              } else {
                currentIndex = 0
                evaluationResult = null
                recordedTranscription = ""
                scoreEarned = null
                isAnswerCorrect = null
                showModelAnswer = false
              }
            },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB))
          ) {
            Text(
              text = if (currentIndex < questions.size - 1) "ඊළඟ ප්‍රශ්නය" else "නැවත මුලට",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(Icons.Default.ArrowForward, contentDescription = null, modifier = Modifier.size(16.dp))
          }
        }
      }
    }
  }

  // Type Answer Dialog
  if (showTypeAnswerDialog) {
    Dialog(
      onDismissRequest = { showTypeAnswerDialog = false },
      properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
      Surface(
        modifier = Modifier
          .fillMaxWidth(0.92f)
          .wrapContentHeight(),
        shape = RoundedCornerShape(20.dp),
        color = Color(0xFF1E293B),
        border = BorderStroke(1.dp, Color(0xFF334155))
      ) {
        Column(modifier = Modifier.padding(20.dp)) {
          Text(
            text = "⌨️ පිළිතුර ටයිප් කරන්න",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
          Text(
            text = "ඔබගේ පිළිතුර ලියා 'ඇගයීම කරන්න' බොත්තම ඔබන්න. ඔබ ඇතුළත් කරන පිළිතුර පමණක් නිවැරදිව පරීක්ෂා කරනු ලැබේ.",
            fontSize = 11.sp,
            color = Color(0xFF94A3B8),
            modifier = Modifier.padding(top = 4.dp, bottom = 12.dp)
          )

          OutlinedTextField(
            value = typedAnswerInput,
            onValueChange = { typedAnswerInput = it },
            placeholder = { Text("ඔබගේ පිළිතුර මෙහි ඇතුළත් කරන්න...", color = Color(0xFF64748B), fontSize = 13.sp) },
            modifier = Modifier
              .fillMaxWidth()
              .heightIn(min = 100.dp),
            colors = OutlinedTextFieldDefaults.colors(
              focusedTextColor = Color.White,
              unfocusedTextColor = Color.White,
              focusedBorderColor = Color(0xFF38BDF8),
              unfocusedBorderColor = Color(0xFF475569)
            ),
            shape = RoundedCornerShape(12.dp)
          )

          Spacer(modifier = Modifier.height(16.dp))

          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
          ) {
            TextButton(
              onClick = { showTypeAnswerDialog = false }
            ) {
              Text("අවලංගු කරන්න", color = Color(0xFF94A3B8))
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
              onClick = {
                showTypeAnswerDialog = false
                evaluateAnswer(typedAnswerInput)
              },
              shape = RoundedCornerShape(10.dp),
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB))
            ) {
              Text("ඇගයීම කරන්න (Submit)")
            }
          }
        }
      }
    }
  }

  // 10 Sets Overview Dialog
  if (showSetsDialog) {
    val allSets = ComprehensiveVoiceQuizRepository.getSetsForSubject(selectedGrade, selectedSubject)
    Dialog(
      onDismissRequest = { showSetsDialog = false },
      properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
      Surface(
        modifier = Modifier
          .fillMaxWidth(0.92f)
          .fillMaxHeight(0.82f),
        shape = RoundedCornerShape(20.dp),
        color = Color(0xFF1E293B),
        border = BorderStroke(1.dp, Color(0xFF334155))
      ) {
        Column(modifier = Modifier.padding(20.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Column {
              Text(
                text = "📋 $selectedSubject - විස්සේ කාණ්ඩ 10",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Text(
                text = "$selectedGrade ශ්‍රේණිය • මුළු ප්‍රශ්න 200",
                fontSize = 12.sp,
                color = Color(0xFF94A3B8)
              )
            }
            IconButton(onClick = { showSetsDialog = false }) {
              Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White)
            }
          }

          Spacer(modifier = Modifier.height(12.dp))

          LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.weight(1f)
          ) {
            items(allSets) { sInfo ->
              val isSelected = selectedSetNumber == sInfo.setNumber
              Card(
                onClick = {
                  selectedSetNumber = sInfo.setNumber
                  currentIndex = 0
                  evaluationResult = null
                  recordedTranscription = ""
                  scoreEarned = null
                  isAnswerCorrect = null
                  showModelAnswer = false
                  showSetsDialog = false
                },
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                  containerColor = if (isSelected) Color(0xFF1E3A8A) else Color(0xFF0F172A)
                ),
                border = BorderStroke(1.dp, if (isSelected) Color(0xFF3B82F6) else Color(0xFF334155)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.SpaceBetween
                ) {
                  Column(modifier = Modifier.weight(1f)) {
                    Text(
                      text = sInfo.title,
                      fontSize = 13.sp,
                      fontWeight = FontWeight.Bold,
                      color = if (isSelected) Color(0xFF93C5FD) else Color.White
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                      text = sInfo.unitTheme,
                      fontSize = 11.sp,
                      color = Color(0xFF94A3B8),
                      maxLines = 1
                    )
                  }

                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = if (isSelected) Color(0xFF2563EB) else Color(0xFF1E293B)
                  ) {
                    Text(
                      text = "ප්‍රශ්න ${sInfo.totalQuestions}",
                      fontSize = 10.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color.White,
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
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

// ==============================================================================
// FEATURE 4: ඉංග්‍රීසි පන්තිය (ENGLISH CLASS - COMPREHENSIVE SUITE)
// ==============================================================================

data class EnglishVocabItem(
  val id: String,
  val word: String,
  val partOfSpeech: String,
  val sinhalaMeaning: String,
  val pronunciation: String,
  val exampleSentence: String,
  val sinhalaSentenceMeaning: String,
  var isLearned: Boolean = false
)

data class WritingTemplateItem(
  val id: String,
  val title: String,
  val type: String, // "NOTICE", "FORMAL_LETTER", "INFORMAL_LETTER", "ESSAY_TEMPLATE", "LINKING_WORDS", "GRAPH_DESCRIPTION", "SPEECH_WRITING"
  val description: String,
  val structureSteps: List<String>,
  val modelFormat: String
)

data class GrammarLessonItem(
  val id: String,
  val title: String,
  val category: String, // "TENSES", "PASSIVE_VOICE", "REPORTED_SPEECH", "PREPOSITIONS", "CONJUNCTIONS"
  val sinhalaSummary: String,
  val formula: String,
  val examples: List<Pair<String, String>>, // English to Sinhala
  val proTip: String
)

data class ClozeTestItem(
  val id: String,
  val title: String,
  val instructions: String,
  val passageWithBlanks: String,
  val wordBank: List<String>,
  val correctAnswers: List<String>,
  val explanation: String
)

data class ReadingComprehensionItem(
  val id: String,
  val title: String,
  val story: String,
  val sinhalaSummary: String,
  val questions: List<ComprehensionQuestion>
)

data class ComprehensionQuestion(
  val questionText: String,
  val options: List<String>,
  val correctOptionIndex: Int,
  val explanation: String
)

object EnglishBuilderRepository {
  fun getDailyVocab(): List<EnglishVocabItem> {
    return EnglishMassiveVocabularyData.getAllMassiveVocab()
  }

  fun getOldDailyVocab(): List<EnglishVocabItem> {
    return listOf(
      EnglishVocabItem(
        id = "voc_1",
        word = "Persevere",
        partOfSpeech = "Verb (ක්‍රියා පදය)",
        sinhalaMeaning = "නොසැලී උත්සාහය දිගටම කරගෙන යනවා",
        pronunciation = "/ˌpɜː.sɪˈvɪər/",
        exampleSentence = "If you persevere with your studies, you will achieve high grades.",
        sinhalaSentenceMeaning = "ඔබ අධ්‍යයන කටයුතුවල නොසැලී උත්සාහ කළහොත් විශිෂ්ට ප්‍රතිඵල ලබාගත හැක."
      ),
      EnglishVocabItem(
        id = "voc_2",
        word = "Sustainable",
        partOfSpeech = "Adjective (නාම විශේෂණය)",
        sinhalaMeaning = "තිරසාර / දිගුකාලීනව පවත්වාගත හැකි",
        pronunciation = "/səˈsteɪ.nə.bəl/",
        exampleSentence = "Solar energy is a clean and sustainable source of power.",
        sinhalaSentenceMeaning = "සූර්ය ශක්තිය පිරිසිදු හා තිරසාර බලශක්ති ප්‍රභවයකි."
      ),
      EnglishVocabItem(
        id = "voc_3",
        word = "Cooperation",
        partOfSpeech = "Noun (නාම පදය)",
        sinhalaMeaning = "සහයෝගීතාව / එක්ව කටයුතු කිරීම",
        pronunciation = "/kəʊˌɒp.ərˈeɪ.ʃən/",
        exampleSentence = "The project succeeded due to the close cooperation of all students.",
        sinhalaSentenceMeaning = "සියලු සිසුන්ගේ සමීප සහයෝගීතාවය නිසා ව්‍යාපෘතිය සාර්ථක විය."
      ),
      EnglishVocabItem(
        id = "voc_4",
        word = "Crucial",
        partOfSpeech = "Adjective (නාම විශේෂණය)",
        sinhalaMeaning = "ඉතා වැදගත් / තීරණාත්මක",
        pronunciation = "/ˈkruː.ʃəl/",
        exampleSentence = "Time management is crucial during the O/L examination.",
        sinhalaSentenceMeaning = "සාමාන්‍ය පෙළ විභාගයේදී කාල කළමනාකරණය අතිශයින් තීරණාත්මක වේ."
      ),
      EnglishVocabItem(
        id = "voc_5",
        word = "Innovate",
        partOfSpeech = "Verb (ක්‍රියා පදය)",
        sinhalaMeaning = "නව්‍යකරණය කරනවා / අලුත් දේ නිර්මාණය කරනවා",
        pronunciation = "/ˈɪn.ə.veɪt/",
        exampleSentence = "Scientists constantly innovate to solve modern environmental issues.",
        sinhalaSentenceMeaning = "නූතන පරිසර ගැටලු විසඳීමට විද්‍යාඥයෝ නිරතුරුවම නව්‍යකරණයේ යෙදෙති."
      ),
      EnglishVocabItem(
        id = "voc_6",
        word = "Consequence",
        partOfSpeech = "Noun (නාම පදය)",
        sinhalaMeaning = "ප්‍රතිඵලය / ආනිසංසය",
        pronunciation = "/ˈkɒn.sɪ.kwəns/",
        exampleSentence = "Global warming is a serious consequence of deforestation.",
        sinhalaSentenceMeaning = "ගෝලීය උණුසුම ඉහළ යාම වන විනාශයේ බරපතල ප්‍රතිඵලයකි."
      ),
      EnglishVocabItem(
        id = "voc_7",
        word = "Fostering",
        partOfSpeech = "Verb/Gerund (පෝෂණය කිරීම)",
        sinhalaMeaning = "දියුණු කිරීම / අනුබල දීම",
        pronunciation = "/ˈfɒs.tər.ɪŋ/",
        exampleSentence = "Schools play an essential role in fostering good moral values.",
        sinhalaSentenceMeaning = "යහපත් සාරධර්ම පෝෂණය කිරීමෙහිලා පාසල් ප්‍රමුඛ කාර්යභාරයක් ඉටු කරයි."
      ),
      EnglishVocabItem(
        id = "voc_8",
        word = "Biodiversity",
        partOfSpeech = "Noun (ජෛව විවිධත්වය)",
        sinhalaMeaning = "පරිසරයක ඇති ජීවීන්ගේ විවිධත්වය",
        pronunciation = "/ˌbaɪ.əʊ.daɪˈvɜː.sɪ.ti/",
        exampleSentence = "Sri Lanka has a rich biodiversity with numerous endemic species.",
        sinhalaSentenceMeaning = "ශ්‍රී ලංකාව බොහෝ ආවේණික විශේෂ සහිත පොහොසත් ජෛව විවිධත්වයකින් යුක්තය."
      ),
      EnglishVocabItem(
        id = "voc_9",
        word = "Punctual",
        partOfSpeech = "Adjective (නාම විශේෂණය)",
        sinhalaMeaning = "නියමිත වේලාවට වැඩ කරන / වේලාව රකින",
        pronunciation = "/ˈpʌŋktʃuəl/",
        exampleSentence = "Being punctual to school shows your commitment to education.",
        sinhalaSentenceMeaning = "පාසලට නියමිත වේලාවට පැමිණීම අධ්‍යාපනය සඳහා ඔබේ කැපවීම විදහා දක්වයි."
      ),
      EnglishVocabItem(
        id = "voc_10",
        word = "Significance",
        partOfSpeech = "Noun (නාම පදය)",
        sinhalaMeaning = "වැදගත්කම / විශේෂත්වය",
        pronunciation = "/sɪɡˈnɪfɪkəns/",
        exampleSentence = "The teacher explained the historical significance of the ancient city.",
        sinhalaSentenceMeaning = "ගුරුතුමිය එම ඓතිහාසික නගරයේ ඇති වැදගත්කම පැහැදිලි කළාය."
      ),
      EnglishVocabItem(
        id = "voc_11",
        word = "Cultivate",
        partOfSpeech = "Verb (ක්‍රියා පදය)",
        sinhalaMeaning = "වගා කරනවා / පුරුදු ඇති කරගන්නවා",
        pronunciation = "/ˈkʌltɪveɪt/",
        exampleSentence = "We must cultivate reading habits from our early childhood.",
        sinhalaSentenceMeaning = "අප කුඩා කල සිටම කියවීමේ පුරුදු ඇති කරගත යුතුය."
      ),
      EnglishVocabItem(
        id = "voc_12",
        word = "Remarkable",
        partOfSpeech = "Adjective (නාම විශේෂණය)",
        sinhalaMeaning = "විශිෂ්ට / කැපී පෙනෙන",
        pronunciation = "/rɪˈmɑːkəbəl/",
        exampleSentence = "The athlete made a remarkable achievement at the national games.",
        sinhalaSentenceMeaning = "ක්‍රීඩකයා ජාතික තරගාවලියේදී කැපී පෙනෙන ජයග්‍රහණයක් අත්පත් කරගත්තේය."
      ),
      EnglishVocabItem(
        id = "voc_13",
        word = "Diligence",
        partOfSpeech = "Noun (නාම පදය)",
        sinhalaMeaning = "උනන්දුව / කැපවීම / වීර්යය",
        pronunciation = "/ˈdɪlɪdʒəns/",
        exampleSentence = "Success in examinations comes through patience and diligence.",
        sinhalaSentenceMeaning = "විභාගවලින් ජය ගැනීම ඉවසීම සහ කැපවීම තුළින් ළඟා කරගත හැකිය."
      ),
      EnglishVocabItem(
        id = "voc_14",
        word = "Abundant",
        partOfSpeech = "Adjective (නාම විශේෂණය)",
        sinhalaMeaning = "බහුල / පිරිපුන් / ඇති තරම් පවතින",
        pronunciation = "/əˈbʌndənt/",
        exampleSentence = "The wet zone of Sri Lanka receives abundant rainfall throughout the year.",
        sinhalaSentenceMeaning = "ශ්‍රී ලංකාවේ තෙත් කලාපයට වසර පුරා බහුල වර්ෂාපතනයක් ලැබේ."
      ),
      EnglishVocabItem(
        id = "voc_15",
        word = "Contribute",
        partOfSpeech = "Verb (ක්‍රියා පදය)",
        sinhalaMeaning = "දායක වෙනවා / ආධාර කරනවා",
        pronunciation = "/kənˈtrɪbjuːt/",
        exampleSentence = "Every student can contribute to keeping the school environment clean.",
        sinhalaSentenceMeaning = "පාසල් පරිසරය පිරිසිදුව තබා ගැනීමට සෑම සිසුවෙකුටම දායක විය හැකිය."
      ),
      EnglishVocabItem(
        id = "voc_16",
        word = "Obstacle",
        partOfSpeech = "Noun (නාම පදය)",
        sinhalaMeaning = "බාධාව / අවහිරය",
        pronunciation = "/ˈɒbstəkl/",
        exampleSentence = "Determination helps us overcome every obstacle in our journey.",
        sinhalaSentenceMeaning = "අදිටන අපගේ ගමනේ ඇති සෑම බාධාවක්ම ජය ගැනීමට අපට උපකාර කරයි."
      ),
      EnglishVocabItem(
        id = "voc_17",
        word = "Indispensable",
        partOfSpeech = "Adjective (නාම විශේෂණය)",
        sinhalaMeaning = "නැතුවම බැරි / අත්‍යවශ්‍ය",
        pronunciation = "/ˌɪndɪˈspɛnsəbl/",
        exampleSentence = "Computers and the internet are indispensable tools in modern education.",
        sinhalaSentenceMeaning = "පරිගණක සහ අන්තර්ජාලය නූතන අධ්‍යාපනයේ නැතුවම බැරි මෙවලම් වේ."
      ),
      EnglishVocabItem(
        id = "voc_18",
        word = "Conserve",
        partOfSpeech = "Verb (ක්‍රියා පදය)",
        sinhalaMeaning = "සුරක්ෂිතව ආරක්ෂා කරගන්නවා",
        pronunciation = "/kənˈsɜːv/",
        exampleSentence = "It is our collective duty to conserve natural water resources.",
        sinhalaSentenceMeaning = "ස්වාභාවික ජල සම්පත් සුරක්ෂිතව රැකගැනීම අප සැමගේ සාමූහික යුතුකමයි."
      ),
      EnglishVocabItem(
        id = "voc_19",
        word = "Endeavour",
        partOfSpeech = "Noun/Verb (වෑයම / උත්සාහය)",
        sinhalaMeaning = "මහත් උත්සාහය / පරිශ්‍රමය",
        pronunciation = "/ɪnˈdɛv.ər/",
        exampleSentence = "We wish you every success in your future academic endeavours.",
        sinhalaSentenceMeaning = "ඔබගේ අනාගත අධ්‍යයන වෑයම්වලට සියලු සාර්ථකත්වය ප්‍රාර්ථනා කරමු."
      ),
      EnglishVocabItem(
        id = "voc_20",
        word = "Harmony",
        partOfSpeech = "Noun (නාම පදය)",
        sinhalaMeaning = "සමගිය / සාමය / අන්‍යෝන්‍ය එකඟතාව",
        pronunciation = "/ˈhɑːməni/",
        exampleSentence = "People of all communities should live together in peace and harmony.",
        sinhalaSentenceMeaning = "සියලු ප්‍රජාවන්ට අයත් ජනතාව සාමය හා සමගියෙන් යුතුව එක්ව ජීවත් විය යුතුය."
      ),
      EnglishVocabItem(
        id = "voc_21",
        word = "Authentic",
        partOfSpeech = "Adjective (නාම විශේෂණය)",
        sinhalaMeaning = "සත්‍ය / සැබෑ / විශ්වාසවන්ත",
        pronunciation = "/ɔːˈθɛntɪk/",
        exampleSentence = "The museum preserves authentic artifacts from the ancient era.",
        sinhalaSentenceMeaning = "කෞතුකාගාරය පැරණි යුගයේ සැබෑ පුරාවස්තු සුරක්ෂිතව තබා ගනී."
      ),
      EnglishVocabItem(
        id = "voc_22",
        word = "Implement",
        partOfSpeech = "Verb (ක්‍රියා පදය)",
        sinhalaMeaning = "ක්‍රියාත්මක කරනවා / ක්‍රියාවට නංවනවා",
        pronunciation = "/ˈɪmplɪment/",
        exampleSentence = "The principal decided to implement a new recycling program in school.",
        sinhalaSentenceMeaning = "විදුහල්පතිතුමා පාසලේ නව ප්‍රතිචක්‍රීකරණ වැඩසටහනක් ක්‍රියාත්මක කිරීමට තීරණය කළේය."
      ),
      EnglishVocabItem(
        id = "voc_23",
        word = "Profound",
        partOfSpeech = "Adjective (නාම විශේෂණය)",
        sinhalaMeaning = "ගැඹුරු / අතිශය බලවත්",
        pronunciation = "/prəˈfaʊnd/",
        exampleSentence = "Good literature has a profound impact on human thinking.",
        sinhalaSentenceMeaning = "උසස් සාහිත්‍යය මිනිස් චින්තනය කෙරෙහි ගැඹුරු බලපෑමක් ඇති කරයි."
      ),
      EnglishVocabItem(
        id = "voc_24",
        word = "Resilient",
        partOfSpeech = "Adjective (නාම විශේෂණය)",
        sinhalaMeaning = "නැවත නැගී සිටීමේ හැකියාව ඇති / ශක්තිමත්",
        pronunciation = "/rɪˈzɪliənt/",
        exampleSentence = "Sri Lankan people have always been resilient in times of natural hardships.",
        sinhalaSentenceMeaning = "ස්වාභාවික දුෂ්කරතා හමුවේ ශ්‍රී ලාංකික ජනතාව සැමවිටම ශක්තිමත්ව නැගී සිටිති."
      )
    )
  }

  fun getWritingTemplates(): List<WritingTemplateItem> {
    return EnglishExpandedContentData.getExpandedWritingTemplates()
  }

  fun getOldWritingTemplates(): List<WritingTemplateItem> {
    return listOf(
      WritingTemplateItem(
        id = "tpl_notice",
        title = "School Notice Writing Format (දැන්වීම් ආකෘතිය)",
        type = "NOTICE",
        description = "O/L ඉංග්‍රීසි ප්‍රශ්න පත්‍රයේ Notice ලිවීම සඳහා සම්මත ලකුණු 5ම ලබාගැනීමේ ආකෘතිය.",
        structureSteps = listOf(
          "1. Heading: NOTICE (Capital letters - මැදින් ලියන්න)",
          "2. Event & Purpose (සිදුවීම සහ අරමුණ)",
          "3. Date, Time & Venue (දිනය, වේලාව සහ ස්ථානය)",
          "4. Target Audience (සහභාගී විය යුත්තේ කවුද)",
          "5. Sign-off: Secretary / President, English Literary Association"
        ),
        modelFormat = """
NOTICE
ANNUAL INTER-HOUSE DEBATE COMPETITION

This is to inform all students from Grades 9 to 11 that the Annual Inter-House Debate Competition organized by the English Literary Association will be held as follows:

• Date  : 25th October 2026
• Time  : 9:00 AM onwards
• Venue : School Main Hall

Interested contestants are requested to submit their names to the respective House Master on or before 20th October.

All are welcome!

Kavindu Perera,
Secretary,
English Literary Association.
        """.trimIndent()
      ),

      WritingTemplateItem(
        id = "tpl_letter",
        title = "Formal Letter to the Principal / Officer (නිල ලිපි ආකෘතිය)",
        type = "FORMAL_LETTER",
        description = "විදුහල්පතිතුමාට හෝ නිලධාරියෙකුට ඉල්ලීමක් සිදුකරන නිල ලිපි ආකෘතිය.",
        structureSteps = listOf(
          "1. Sender's Address & Date (ඉහළ දකුණු හෝ වම් පස)",
          "2. Receiver's Designation & Address",
          "3. Salutation: 'Dear Sir / Madam,'",
          "4. Heading / Subject: 'Request for permission to...'",
          "5. Body: Paragraph 1 (Reason), Paragraph 2 (Details & Date), Paragraph 3 (Polite request)",
          "6. Formal Close: 'Yours faithfully,' + Signature + Name"
        ),
        modelFormat = """
No. 45, Temple Road,
Kandy.
15th August 2026.

The Principal,
Dharmaraja College,
Kandy.

Dear Sir,

Request for Permission to Organize an Educational Tree Planting Campaign

I am writing this letter on behalf of the Grade 11 Nature Club to kindly request permission to conduct a tree planting campaign in our school premises on World Environment Day.

We plan to hold this event on 5th June 2026 from 8:30 AM to 12:00 PM. Around 50 saplings will be planted with the participation of Grade 10 and 11 students. Our teachers-in-charge have kindly agreed to supervise the program.

Therefore, we would be extremely grateful if you could grant us permission and access to the school ground garden.

Thank you.

Yours faithfully,
Kamal Silva
President, Nature Club
        """.trimIndent()
      ),

      WritingTemplateItem(
        id = "tpl_informal_letter",
        title = "Informal Letter to a Friend (මිතුරෙකුට ලියන පෞද්ගලික ලිපිය)",
        type = "INFORMAL_LETTER",
        description = "මිතුරෙකුට පසුගිය නිවාඩුව හෝ විශේෂ උත්සවයක් ගැන ලියන ලිපි ආකෘතිය.",
        structureSteps = listOf(
          "1. Sender's Address & Date",
          "2. Friendly Greeting: 'Dear Kasun,'",
          "3. Friendly Opening: 'How are you? I hope you are doing well...'",
          "4. Main Message: Describe the event, trip, or celebration vividly.",
          "5. Friendly Closing: 'Give my regards to your parents. Hope to see you soon!'",
          "6. Sign-off: 'Your loving friend,' + First Name"
        ),
        modelFormat = """
12, Galle Road,
Matara.
10th September 2026.

Dear Kasun,

How are you doing? I hope you and your family are in good health. It has been a while since we last spoke, so I decided to write to you about our recent trip to Nuwara Eliya.

Last weekend, my family visited Nuwara Eliya. The climate was cool and refreshing. We visited Gregory Lake, where we enjoyed boating, and also toured a famous tea factory to see how Ceylon tea is manufactured. I took many photographs and cannot wait to show them to you!

How did you spend your vacation? Please write back when you find some free time. Give my warmest regards to your parents.

Your loving friend,
Nuwan
        """.trimIndent()
      ),

      WritingTemplateItem(
        id = "tpl_essay_structure",
        title = "O/L Essay 5-Paragraph Framework (රචනා ආකෘතිය)",
        type = "ESSAY_TEMPLATE",
        description = "ඕනෑම මාතෘකාවකට ලකුණු 15න් 13+ ලබාගත හැකි රචනා ගොඩනැගීමේ ආකෘතිය.",
        structureSteps = listOf(
          "Paragraph 1 (Introduction): Hook the reader + Define the topic + Thesis statement.",
          "Paragraph 2 (First Main Benefit/Point): Topic sentence + Explanation + Real-world Example.",
          "Paragraph 3 (Second Main Point/Challenge): Topic sentence + Evidence + Impact on society.",
          "Paragraph 4 (Solutions/Future Role): How students & government can help.",
          "Paragraph 5 (Conclusion): Summarize key ideas + Strong concluding thought."
        ),
        modelFormat = """
THE IMPORTANCE OF LEARNING ENGLISH AS A GLOBAL LANGUAGE

Introduction:
In today’s interconnected modern world, English plays a paramount role as the universal bridge of communication. It is not merely a school subject, but a vital life skill that opens endless doors to the future.

Body Paragraph 1 (Education & Technology):
First and foremost, the majority of the world’s scientific knowledge, digital technology, and higher educational textbooks are written in English. Learning English allows Sri Lankan students to access international universities, digital libraries, and online courses with immense ease.

Body Paragraph 2 (Career Opportunities):
Furthermore, proficiency in English significantly elevates employment prospects. Multinational corporations and leading local companies always prioritize candidates with fluent communication abilities.

Conclusion:
In conclusion, mastering English is an indispensable asset for every 21st-century youth. By dedicating daily effort to reading and speaking, every student can unlock global horizons.
        """.trimIndent()
      ),

      WritingTemplateItem(
        id = "tpl_graph_desc",
        title = "Bar Chart & Pie Chart Description (ප්‍රස්ථාර විස්තර කිරීම)",
        type = "GRAPH_DESCRIPTION",
        description = "O/L විභාගයේ Test 14 සඳහා Bar Chart හෝ Pie Chart විස්තර කිරීමේ සම්මත රීති.",
        structureSteps = listOf(
          "Sentence 1 (Intro): 'This bar chart / pie chart illustrates the information about...'",
          "Sentence 2 (Highest Point): 'According to the chart, the highest percentage of students (45%) prefer...'",
          "Sentence 3 (Lowest Point): 'Conversely, the lowest proportion is recorded in... with only 10%.'",
          "Sentence 4 (Comparison): 'Furthermore, more students chose Science than History...'",
          "Sentence 5 (Conclusion): 'Overall, it is evident that... is the most popular choice.'"
        ),
        modelFormat = """
DESCRIPTION OF A BAR CHART ON FAVOURITE SCHOOL SUBJECTS

This bar chart illustrates the favourite school subjects of Grade 11 students in a selected school.

According to the chart, the highest number of students (50%) prefer Science, making it the most popular subject. On the other hand, the least preferred subject is History, with only 10% of students voting for it. Furthermore, Mathematics and English recorded equal popularity at 20% each.

In conclusion, it is clearly evident that the majority of students show a strong enthusiasm towards studying Science.
        """.trimIndent()
      ),

      WritingTemplateItem(
        id = "tpl_speech",
        title = "School Assembly / Event Speech (කථාවක් ලිවීම)",
        type = "SPEECH",
        description = "පාසල් රැස්වීමකදී හෝ උත්සවයකදී පවත්වන කථාවක් ලිවීමේ සම්මත ආකෘතිය.",
        structureSteps = listOf(
          "1. Honorable Address: 'Respected Principal, teachers, and dear friends...'",
          "2. Announcing Topic & Greeting: 'Good morning to you all. Today, I stand before you to speak on...'",
          "3. Main Argument 1: Importance of the topic with real-life examples",
          "4. Main Argument 2: Problems, consequences and practical solutions",
          "5. Inspiring Call to Action: 'Let us join hands today to...'",
          "6. Polite Conclusion & Gratitude: 'Thank you very much for your patient listening.'"
        ),
        modelFormat = """
SPEECH ON "THE IMPORTANCE OF PRESERVING OUR ENVIRONMENT"

Respected Principal, beloved teachers, and my dear school friends,

A very pleasant good morning to you all!

Today, I stand before you with great pleasure to share a few thoughts on a timely and critical topic: "The Importance of Preserving Our Environment".

Nature is the supreme gift given to mankind. The air we breathe, the water we drink, and the soil that nourishes our crops are all blessings of Mother Nature. However, in our pursuit of modern industrialization, humans have recklessly polluted rivers, destroyed virgin rainforests, and filled our surroundings with non-biodegradable plastics.

Dear friends, global warming and climate change are no longer distant warnings; they are dangerous realities threatening our very survival. As young students, we hold the power to bring about a positive change. We can start small: plant a native tree in your home garden, say 'no' to single-use polythene bags, switch off unneeded electric lights, and keep our school compound clean.

Remember, we have not inherited this Earth from our ancestors; we have merely borrowed it from our children. Let us unite to protect our green planet before it is too late.

Thank you very much for your kind and patient attention. Have a wonderful day!
        """.trimIndent()
      ),

      WritingTemplateItem(
        id = "tpl_article",
        title = "School Magazine Article Writing (සඟරා ලිපියක්)",
        type = "ARTICLE",
        description = "පාසල් සඟරාවට හෝ පුවත්පතට ආකර්ෂණීය ලිපියක් සම්පාදනය කිරීමේ ආකෘතිය.",
        structureSteps = listOf(
          "1. Catchy Title (ආකර්ෂණීය ප්‍රධාන මාතෘකාව)",
          "2. Byline (ලියුම්කරුගේ නම - By Nuwan Perera, Grade 11-B)",
          "3. Engaging Introduction: Hook the reader with a question or fact",
          "4. Body Paragraph 1: Background & current status of the topic",
          "5. Body Paragraph 2: Positive aspects, challenges, and perspectives",
          "6. Powerful Conclusion: Summary, future outlook, and final recommendation"
        ),
        modelFormat = """
THE DIGITAL CLASSROOM: BLESSING OR DISTRACTION?
By Malsha Jayasuriya (Grade 11-A)

In this rapidly evolving 21st century, technology has permeated every sphere of human existence, and education is no exception. Traditional blackboards and heavy textbooks are swiftly making way for interactive smart screens, educational apps, and virtual learning platforms. But does this digital revolution genuinely enhance student learning, or does it merely create new distractions?

Undoubtedly, the internet has democratized knowledge. Today, an ambitious O/L student in a remote village can access world-class video lectures, online past paper archives, and interactive science simulations with just a single tap. Learning has become self-paced, colorful, and engaging.

However, excessive screen time poses significant dangers. Many youngsters fall prey to social media addiction, cyberbullying, and sleep deprivation, which negatively affect their academic concentration and mental wellbeing.

To conclude, digital technology is a wonderful servant but a dangerous master. If students cultivate digital discipline and use electronic devices strictly as educational tools under proper parental guidance, digital learning will undoubtedly pave the path to a brighter tomorrow.
        """.trimIndent()
      ),

      WritingTemplateItem(
        id = "tpl_linking_words",
        title = "High-Scoring Linking Words & Connectors (සම්බන්ධක පද)",
        type = "LINKING_WORDS",
        description = "රචනාවට සහ ලිපිවලට ඉහළ ලකුණු ගෙන දෙන පද ලැයිස්තුව.",
        structureSteps = listOf(
          "• Adding Points: Furthermore, Moreover, In addition to this, Besides",
          "• Contrasting: However, On the other hand, Nevertheless, In contrast",
          "• Giving Examples: For instance, For example, Namely, Such as",
          "• Showing Results: Consequently, As a result, Therefore, Thus",
          "• Concluding: In conclusion, To sum up, Ultimately, All in all"
        ),
        modelFormat = "ප්‍රායෝගික භාවිතය: 'Furthermore, reading books expands our imagination. However, we must choose good books carefully. Therefore, cultivating this habit from childhood is vital.'"
      )
    )
  }

  fun getGrammarLessons(): List<GrammarLessonItem> {
    return EnglishExpandedContentData.getExpandedGrammarLessons()
  }

  fun getOldGrammarLessons(): List<GrammarLessonItem> {
    return listOf(
      GrammarLessonItem(
        id = "gram_1",
        title = "Simple Present vs Present Continuous Tense",
        category = "TENSES",
        sinhalaSummary = "සාමාන්‍ය සත්‍ය, දෛනික පුරුදු (Simple Present) සහ මේ මොහොතේ සිදුවෙමින් පවතින ක්‍රියා (Present Continuous) වෙන්කර හඳුනාගැනීම.",
        formula = "Simple Present: Subject + V1 (s/es) | Present Continuous: Subject + is/am/are + V-ing",
        examples = listOf(
          "I read books every evening." to "මම හැමදාම සවස පොත් කියවමි. (පුරුද්දක් / Habitual action)",
          "She is reading a science book right now." to "ඇය මේ මොහොතේ විද්‍යා පොතක් කියවමින් සිටියි. (මේ මොහොතේ සිදුවෙමින් පවතී)",
          "The sun rises in the east." to "හිරු නැගෙනහිරින් උදා වේ. (සදාකාලික සත්‍යයක් / Universal truth)"
        ),
        proTip = "Always, usually, everyday, often ඇත්නම් Simple Present; now, at the moment, currently ඇත්නම් Continuous යොදන්න."
      ),
      GrammarLessonItem(
        id = "gram_2",
        title = "Simple Past vs Past Continuous Tense",
        category = "TENSES",
        sinhalaSummary = "අතීතයේ අවසන් වූ ක්‍රියා (Simple Past) සහ අතීතයේ යම් කාලයක් පුරා සිදුවෙමින් පැවති ක්‍රියා (Past Continuous) භාවිතය.",
        formula = "Simple Past: Subject + V2 (Past form) | Past Continuous: Subject + was/were + V-ing",
        examples = listOf(
          "We visited the National Museum yesterday." to "අපි ඊයේ ජාතික කෞතුකාගාරය නැරඹුවෙමු.",
          "While it was raining heavily, the students were waiting inside the hall." to "තදින් වසිමින් තිබියදී සිසුන් ශාලාව තුළ රැඳී සිටියහ.",
          "When the phone rang, Father was reading the newspaper." to "දුරකථනය නාද වන විට තාත්තා පුවත්පත කියවමින් සිටියේය."
        ),
        proTip = "'While' පසුපස සාමාන්‍යයෙන් Continuous tense (was/were + ing) ද, 'When' පසුපස Simple Past ද යෙදේ."
      ),
      GrammarLessonItem(
        id = "gram_3",
        title = "Present Perfect Tense vs Simple Past",
        category = "TENSES",
        sinhalaSummary = "මේ දැන් අවසන් වූ (just) හෝ වර්තමානයට බලපෑමක් ඇති අතීත ක්‍රියා (Present Perfect) සහ නිශ්චිත අතීත කාලයක් සහිත ක්‍රියා (Simple Past).",
        formula = "Present Perfect: Subject + have/has + V3 (Past Participle) | Simple Past: Subject + V2",
        examples = listOf(
          "I have already submitted my homework." to "මම දැනටමත් මගේ ගෙදර වැඩ භාර දී ඇත්තෙමි. (Present Perfect)",
          "She submitted her homework yesterday." to "ඇය ඊයේ ඇගේ ගෙදර වැඩ භාර දුන්නාය. (Simple Past)",
          "Have you ever visited Sigiriya?" to "ඔබ කවදා හෝ සීගිරිය නරඹා තිබේද?"
        ),
        proTip = "Just, already, yet, ever, never, since, for ඇති විට Present Perfect (have/has + V3) යොදන්න. Yesterday, last week, in 2020 ඇති විට Simple Past යොදන්න."
      ),
      GrammarLessonItem(
        id = "gram_4",
        title = "Active Voice to Passive Voice (කර්මකාරක වාක්‍ය)",
        category = "PASSIVE_VOICE",
        sinhalaSummary = "ක්‍රියාව කළ පුද්ගලයාට (Subject) වඩා ක්‍රියාව ලැබූ වස්තුව/අරමුණ (Object) ඉස්මතු කිරීමට Passive Voice භාවිත කරයි.",
        formula = "Object + Form of 'Be' (is/am/are/was/were/been/being) + V3 (Past Participle) + (by + Subject)",
        examples = listOf(
          "Active: Thomas Edison invented the light bulb." to "තෝමස් එඩිසන් විදුලි බුබුල නිපදවීය.",
          "Passive: The light bulb was invented by Thomas Edison." to "විදුලි බුබුල තෝමස් එඩිසන් විසින් නිපදවන ලදී.",
          "Active: They are building a new library." to "ඔවුහු නව පුස්තකාලයක් ඉදිකරමින් සිටිති.",
          "Passive: A new library is being built by them." to "නව පුස්තකාලයක් ඔවුන් විසින් ඉදිකෙරෙමින් පවතී."
        ),
        proTip = "සෑම විටම ප්‍රධාන ක්‍රියා පදයේ V3 (Past Participle) ආකෘතිය භාවිත කළ යුතුය. Continuous නම් 'being' ද, Perfect නම් 'been' ද එකතු කරන්න."
      ),
      GrammarLessonItem(
        id = "gram_5",
        title = "Direct & Indirect / Reported Speech (ප්‍රකාශන)",
        category = "REPORTED_SPEECH",
        sinhalaSummary = "කෙනෙකු පැවසූ ප්‍රකාශයක්, ප්‍රශ්නයක් හෝ නියෝගයක් වෙනත් කෙනෙකුට නැවත ප්‍රකාශ කිරීමේ සම්පූර්ණ නීති.",
        formula = "Statements: said that + Past Tense | Questions: asked if/whether + Normal word order | Commands: told/ordered + to-infinitive",
        examples = listOf(
          "Direct: Kamal said, \"I am studying hard.\"" to "කමල් පැවසුවේ: \"මම මහන්සි වී පාඩම් කරමි.\"",
          "Indirect: Kamal said that he was studying hard." to "කමල් පැවසුවේ තමන් මහන්සි වී පාඩම් කරමින් සිටින බවයි.",
          "Direct: The teacher asked, \"Do you understand the question?\"" to "ගුරුතුමිය ඇසුවාය: \"ඔබට ප්‍රශ්නය තේරුණාද?\"",
          "Indirect: The teacher asked whether I understood the question." to "ගුරුතුමිය ඇසුවේ මට ප්‍රශ්නය තේරුණේද යන්නයි."
        ),
        proTip = "Present -> Past වේ. Today -> That day, Tomorrow -> The next day / The following day, Yesterday -> The previous day බවට හැරවේ."
      ),
      GrammarLessonItem(
        id = "gram_6",
        title = "Conditional Clauses (If Types 0, 1, 2, 3)",
        category = "CONDITIONALS",
        sinhalaSummary = "කොන්දේසි සහිත වාක්‍ය වර්ග 4 (විද්‍යාත්මක සත්‍ය, විය හැකි අනාගතය, මනඃකල්පිත අවස්ථා, අතීතයේ සිදු නොවූ පසුතැවීම්).",
        formula = "Type 0: If + Present, Present | Type 1: If + Present, will + V1 | Type 2: If + Past, would + V1 | Type 3: If + had + V3, would have + V3",
        examples = listOf(
          "Type 0: If you heat water to 100°C, it boils." to "ජලය 100°C ට රත් කළහොත් එය නටයි. (විද්‍යාත්මක සත්‍යයක්)",
          "Type 1: If you study diligently, you will pass the exam." to "ඔබ කැපවීමෙන් පාඩම් කළහොත් ඔබට විභාගය සමත් විය හැකිය.",
          "Type 2: If I had wings, I would fly around the world." to "මට පියාපත් තිබුණා නම් මම මුළු ලෝකය වටා පියාසර කරන්නෙමි.",
          "Type 3: If they had invited me, I would have attended the party." to "ඔවුන් මට ආරාධනා කළා නම් මම එම සාදයට සහභාගි වනු ඇත."
        ),
        proTip = "Type 1 විභාගවල බහුලවම අසයි: If පසුපස කිසිවිටෙක 'will' නොයොදන්න! (If it rains, we will wait)."
      ),
      GrammarLessonItem(
        id = "gram_7",
        title = "Essential Prepositions (Time, Place & Direction)",
        category = "PREPOSITIONS",
        sinhalaSummary = "කාලය (Time), ස්ථානය (Place) සහ ගමන් දිශාව (Direction) දැක්වීමට නිවැරදි Preposition භාවිතය.",
        formula = "Time: At (time), On (days/dates), In (months/years/seasons) | Place: At (specific spot), On (surface), In (inside enclosed space)",
        examples = listOf(
          "We meet at 8:00 AM on Monday in the school library." to "අපි සඳුදා උදෑසන 8:00 ට පාසල් පුස්තකාලයේදී හමුවෙමු.",
          "The boat sailed under the bridge along the river." to "බෝට්ටුව පාලම යටින් ගඟ දිගේ යාත්‍රා කළේය.",
          "She jumped into the pool." to "ඇය පිහිනුම් තටාකයට පැන්නාය. (Movement towards inside = into)"
        ),
        proTip = "දිනයකට 'On' ද, නිශ්චිත වේලාවකට 'At' ද, මාස හෝ වර්ෂයකට 'In' ද භාවිත කරන්න."
      ),
      GrammarLessonItem(
        id = "gram_8",
        title = "Relative Pronouns & Clauses (Who, Which, That, Whose, Where)",
        category = "RELATIVE_CLAUSES",
        sinhalaSummary = "පුද්ගලයන්, වස්තූන්, ස්ථාන හෝ අයිතිය සම්බන්ධ කරමින් සංයුක්ත වාක්‍ය ගොඩනැගීම.",
        formula = "Who (People) | Which/That (Objects & Animals) | Whose (Possession) | Where (Places)",
        examples = listOf(
          "The boy who won the first prize is my classmate." to "පළමු ත්‍යාගය දිනාගත් පිරිමි ළමයා මගේ පන්ති මිතුරා වේ.",
          "This is the mobile phone which I bought yesterday." to "මෙය මා ඊයේ මිලදී ගත් ජංගම දුරකථනයයි.",
          "The doctor whose clinic is in town examined the patient." to "නගරයේ සායනය ඇති වෛද්‍යවරයා රෝගියා පරීක්ෂා කළේය.",
          "This is the ancient temple where the historic stone was found." to "ඓතිහාසික ගල් පුවරුව හමු වූ පැරණි විහාරය මෙයයි."
        ),
        proTip = "පුද්ගලයින් සඳහා 'who' ද, ද්‍රව්‍ය සඳහා 'which' හෝ 'that' ද, අයිතියට 'whose' ද යොදන්න."
      )
    )
  }

  fun getClozeTests(): List<ClozeTestItem> {
    return listOf(
      ClozeTestItem(
        id = "cloze_1",
        title = "O/L Test 03 Simulation - Protecting the Environment",
        instructions = "Fill in the blanks with the most suitable words given in the word bank.",
        passageWithBlanks = "Trees play a vital role in our ecosystem. They provide (1)_____ for humans and animals to breathe. Moreover, forests act as a natural (2)_____ against soil erosion. If we continue to cut down trees without (3)_____, our planet will face severe climatic (4)_____.",
        wordBank = listOf("oxygen", "protection", "planting", "changes"),
        correctAnswers = listOf("oxygen", "protection", "planting", "changes"),
        explanation = "1. oxygen (හුස්ම ගැනීමට ඔක්සිජන්), 2. protection (පස් සෝදාපාළුවෙන් ආරක්ෂාව), 3. planting (නැවත පැළ සිටුවීම), 4. changes (දේශගුණික විපර්යාස)."
      ),
      ClozeTestItem(
        id = "cloze_2",
        title = "O/L Test 06 Simulation - Prepositions Cloze",
        instructions = "Select the appropriate preposition for each blank.",
        passageWithBlanks = "Nipuna lives (1)_____ a small village near Kandy. He walks (2)_____ school every morning. Yesterday, he arrived (3)_____ 7:30 AM and placed his books (4)_____ the table.",
        wordBank = listOf("in", "to", "at", "on"),
        correctAnswers = listOf("in", "to", "at", "on"),
        explanation = "(1) in a village (ගමක), (2) to school (ගමන් දිශාව දක්වයි), (3) at 7:30 AM (නිශ්චිත වේලාව), (4) on the table (මතුපිට)."
      ),
      ClozeTestItem(
        id = "cloze_3",
        title = "O/L Test 03 Simulation - Health and Nutrition",
        instructions = "Fill in the blanks using the appropriate words from the box.",
        passageWithBlanks = "Good health is a precious gift. To maintain physical fitness, we must consume a (1)_____ diet rich in vitamins and minerals. Clean drinking water is equally (2)_____ for our digestive system. In addition, getting adequate (3)_____ allows our brain and muscles to recover and (4)_____ effectively.",
        wordBank = listOf("balanced", "essential", "sleep", "function"),
        correctAnswers = listOf("balanced", "essential", "sleep", "function"),
        explanation = "1. balanced (සමබල ආහාර වේලක්), 2. essential (අත්‍යවශ්‍ය), 3. sleep (ප්‍රමාණවත් නින්ද), 4. function (නිසි පරිදි ක්‍රියා කිරීමට)."
      ),
      ClozeTestItem(
        id = "cloze_4",
        title = "O/L Test 06 Simulation - Connectors & Conjunctions",
        instructions = "Select the most suitable connector for each blank.",
        passageWithBlanks = "Saman studied very hard for his exam. (1)_____, he scored distinction passes in all subjects. His parents were very proud of him (2)_____ he had dedicated so much time. (3)_____ he faced many hardships, he never gave up his dream. (4)_____, hard work always brings success.",
        wordBank = listOf("Therefore", "because", "Although", "Truly"),
        correctAnswers = listOf("Therefore", "because", "Although", "Truly"),
        explanation = "(1) Therefore (එබැවින් - ප්‍රතිඵලය), (2) because (හේතුව දක්වයි), (3) Although (කෙසේ වෙතත් / එසේ වුවද), (4) Truly (සැබවින්ම - නිගමනය)."
      ),
      ClozeTestItem(
        id = "cloze_5",
        title = "O/L Test 03 Simulation - Science and Technology",
        instructions = "Choose the correct words to complete the passage on modern communication.",
        passageWithBlanks = "The internet has transformed the modern world into a global (1)_____. People can now exchange information and share ideas within a matter of (2)_____. However, users must be (3)_____ regarding cyber security to protect their private (4)_____ from unauthorized access.",
        wordBank = listOf("village", "seconds", "cautious", "data"),
        correctAnswers = listOf("village", "seconds", "cautious", "data"),
        explanation = "1. village (ගෝලීය ගම්මානයක්), 2. seconds (තත්පර ගණනකින්), 3. cautious (ප්‍රවේශම් සහගත), 4. data (පෞද්ගලික දත්ත)."
      )
    )
  }

  fun getReadingPassages(): List<ReadingComprehensionItem> {
    return listOf(
      ReadingComprehensionItem(
        id = "read_1",
        title = "The Journey of the Honey Bee (මී මැස්සාගේ කාර්යභාරය)",
        story = "Honey bees are among the most hardworking insects on Earth. They fly thousands of kilometers collecting nectar from blooming flowers. In doing so, they pollinate plants, which is essential for fruit and seed production. Without bees, nearly one-third of the world's food supply would be at risk.",
        sinhalaSummary = "මී මැස්සන් මල් පැණි එකතු කරමින් ශාක පරාගණය සිදුකරන අතර, ලෝකයේ ආහාර නිෂ්පාදනයෙන් තුනෙන් එකක් ඔවුන් මත රඳා පවතී.",
        questions = listOf(
          ComprehensionQuestion(
            questionText = "What is the primary role of honey bees mentioned in the passage?",
            options = listOf("Making plastic", "Pollinating plants and producing food", "Causing soil erosion", "Sleeping during the day"),
            correctOptionIndex = 1,
            explanation = "පාඨයේ සඳහන් වන්නේ මී මැස්සන් ශාක පරාගණය කරමින් ආහාර නිෂ්පාදනයට උපකාර වන බවයි."
          ),
          ComprehensionQuestion(
            questionText = "How much of the world's food supply is dependent on bees?",
            options = listOf("100%", "Nearly one-third (1/3)", "Only 5%", "None"),
            correctOptionIndex = 1,
            explanation = "පාඨය අනුව ලෝක ආහාර සැපයුමෙන් තුනෙන් එකක් (nearly one-third) මී මැස්සන් මත රඳා පවතී."
          )
        )
      )
    )
  }
}

@Composable
fun EnglishVocabularyAndEssayScreen(
  onBack: () -> Unit,
  onOpenGoogleDrivePdfModal: ((url: String, title: String) -> Unit)? = null
) {
  val context = LocalContext.current
  val clipboardManager = LocalClipboardManager.current
  var selectedSubTab by remember { mutableStateOf(0) } // 0: All Sections, 1: PDF Notes, 2: Grammar, 3: Writing, 4: Vocab, 5: Reading & Cloze, 6: Listening
  var vocabList by remember { mutableStateOf(EnglishBuilderRepository.getDailyVocab()) }
  val templates = remember { EnglishBuilderRepository.getWritingTemplates() }
  val grammarLessons = remember { EnglishBuilderRepository.getGrammarLessons() }
  val clozeTests = remember { EnglishBuilderRepository.getClozeTests() }
  val readingPassages = remember { EnglishBuilderRepository.getReadingPassages() }

  val defaultEnglishDriveUrl = "https://drive.google.com/file/d/155eu00n0_0IdrKc0wiWDqcwkqLa08ndI/preview"
  val defaultEnglishNoteTitle = "06-11 ශ්‍රේණි ඉංග්‍රීසි පූර්ණ කෙටි සටහන් (Google Drive PDF)"

  var internalShowPdfModal by remember { mutableStateOf(false) }
  var internalPdfUrl by remember { mutableStateOf("") }
  var internalPdfTitle by remember { mutableStateOf("") }

  fun openDrivePdf(url: String = defaultEnglishDriveUrl, title: String = defaultEnglishNoteTitle) {
    if (onOpenGoogleDrivePdfModal != null) {
      onOpenGoogleDrivePdfModal(url, title)
    } else {
      internalPdfUrl = url
      internalPdfTitle = title
      internalShowPdfModal = true
    }
  }

  // TTS helper
  var tts by remember { mutableStateOf<TextToSpeech?>(null) }
  var isTtsReady by remember { mutableStateOf(false) }

  DisposableEffect(Unit) {
    var engine: TextToSpeech? = null
    engine = TextToSpeech(context) { status ->
      if (status == TextToSpeech.SUCCESS) {
        engine?.language = Locale.ENGLISH
        isTtsReady = true
      }
    }
    tts = engine
    onDispose {
      engine?.stop()
      engine?.shutdown()
    }
  }

  fun speakEnglish(text: String, speechRate: Float = 1.0f) {
    tts?.setSpeechRate(speechRate)
    tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "english_class_tts")
  }

  val vibrantGold = Color(0xFFF59E0B)

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .background(Color(0xFFF1F5F9)),
    verticalArrangement = Arrangement.spacedBy(14.dp),
    contentPadding = PaddingValues(bottom = 40.dp)
  ) {
    // Ultra-Compact Header (Scrolls with the screen)
    item(key = "compact_english_hero_header") {
      Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(0xFF0F172A),
        shadowElevation = 4.dp
      ) {
        Box(modifier = Modifier.fillMaxWidth()) {
          // Background Image
          Image(
            painter = painterResource(id = R.drawable.img_english_header_1787064736646),
            contentDescription = "English Class Header Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
              .matchParentSize()
              .clip(RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp))
          )

          // Dark Gradient Overlay for high readability
          Box(
            modifier = Modifier
              .matchParentSize()
              .background(
                Brush.verticalGradient(
                  colors = listOf(
                    Color(0xFF0F172A).copy(alpha = 0.90f),
                    Color(0xFF1E1B4B).copy(alpha = 0.94f),
                    Color(0xFF0F172A).copy(alpha = 0.98f)
                  )
                )
              )
          )

          Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                  onClick = {
                    tts?.stop()
                    onBack()
                  },
                  shape = CircleShape,
                  color = Color.White.copy(alpha = 0.18f),
                  border = BorderStroke(1.dp, Color.White.copy(alpha = 0.3f)),
                  modifier = Modifier.size(28.dp)
                ) {
                  Box(contentAlignment = Alignment.Center) {
                    Icon(
                      imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                      contentDescription = "Back",
                      tint = Color.White,
                      modifier = Modifier.size(15.dp)
                    )
                  }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                      text = "🇬🇧 ඉංග්‍රීසි පන්තිය",
                      style = MaterialTheme.typography.titleMedium,
                      fontWeight = FontWeight.ExtraBold,
                      color = Color.White,
                      fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Surface(
                      shape = RoundedCornerShape(4.dp),
                      color = vibrantGold
                    ) {
                      Text(
                        text = "06-11 ALL",
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF78350F),
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                      )
                    }
                  }
                  Text(
                    text = "English Master Hub • Notes, Grammar, Writing & Pronunciation",
                    fontSize = 9.5.sp,
                    color = Color(0xFFCBD5E1),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                }
              }
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Filter Tabs Bar (Horizontal Scrollable)
            val tabTitles = listOf(
              "🌟 සියලු අනු කොටස්",
              "📑 කෙටි සටහන් PDF",
              "📖 ව්‍යාකරණ (Grammar)",
              "✍️ රචනා හා ලිපි (Writing)",
              "📚 වචන මාලාව (Vocab)",
              "🔍 කියවීම & Cloze",
              "🎙️ සවන්දීම (Listening)"
            )

            ScrollableTabRow(
              selectedTabIndex = selectedSubTab,
              containerColor = Color.Black.copy(alpha = 0.35f),
              contentColor = Color(0xFFFBBF24),
              edgePadding = 4.dp,
              modifier = Modifier.clip(RoundedCornerShape(8.dp))
            ) {
              tabTitles.forEachIndexed { index, label ->
                Tab(
                  selected = selectedSubTab == index,
                  onClick = { selectedSubTab = index },
                  text = {
                    Text(
                      text = label,
                      fontSize = 10.sp,
                      fontWeight = if (selectedSubTab == index) FontWeight.Bold else FontWeight.Medium,
                      color = if (selectedSubTab == index) Color(0xFFFBBF24) else Color(0xFFE2E8F0)
                    )
                  }
                )
              }
            }
          }
        }
      }
    }

      // =========================================================================
      // SUB-SECTION 1: 📑 06-11 ඉංග්‍රීසි පූර්ණ කෙටි සටහන් GOOGLE DRIVE PDF HUB
      // =========================================================================
      if (selectedSubTab == 0 || selectedSubTab == 1) {
        // Section Header Banner with Background Image
        item {
          Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.5.dp, Color(0xFFF59E0B).copy(alpha = 0.6f)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Box(modifier = Modifier.fillMaxWidth()) {
              // Educational Background Image
              Image(
                painter = painterResource(id = R.drawable.img_papers_bg_1786107349533),
                contentDescription = "PDF Notes Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
              )

              // Dark Overlay
              Box(
                modifier = Modifier
                  .matchParentSize()
                  .background(
                    Brush.verticalGradient(
                      colors = listOf(
                        Color(0xFF0F172A).copy(alpha = 0.88f),
                        Color(0xFF1E293B).copy(alpha = 0.94f),
                        Color(0xFF1E1B4B).copy(alpha = 0.96f)
                      )
                    )
                  )
              )

              Column(modifier = Modifier.padding(18.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFF59E0B)
                  ) {
                    Text(
                      text = "06 - 11 ALL SYLLABUS",
                      fontSize = 10.sp,
                      fontWeight = FontWeight.ExtraBold,
                      color = Color(0xFF78350F),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }

                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF10B981).copy(alpha = 0.25f),
                    border = BorderStroke(1.dp, Color(0xFF10B981))
                  ) {
                    Text(
                      text = "🔒 Cloud PDF Secure",
                      fontSize = 10.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF34D399),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                  text = "📑 1. 06-11 ශ්‍රේණි ඉංග්‍රීසි පූර්ණ කෙටි සටහන් (PDF)",
                  fontSize = 17.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  lineHeight = 23.sp
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                  text = "O/L විභාගය හා 06-11 සියලු ශ්‍රේණිවල විෂය නිර්දේශයට අදාළ Tenses, Grammar Formulas, Active/Passive Voice, Prepositions, Letter Formats, Graphs & Essay Frameworks සාරාංශගත කෙටි සටහන් පොත.",
                  fontSize = 11.sp,
                  color = Color(0xFFCBD5E1),
                  lineHeight = 16.sp
                )

                Spacer(modifier = Modifier.height(14.dp))

                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                  Button(
                    onClick = { openDrivePdf(defaultEnglishDriveUrl, defaultEnglishNoteTitle) },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF59E0B)),
                    modifier = Modifier.weight(1.3f),
                    contentPadding = PaddingValues(vertical = 10.dp)
                  ) {
                    Icon(
                      imageVector = Icons.Default.PictureAsPdf,
                      contentDescription = "Open PDF",
                      tint = Color(0xFF78350F),
                      modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                      text = "PDF කියවන්න 🚀",
                      fontSize = 12.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF78350F)
                    )
                  }

                  OutlinedButton(
                    onClick = {
                      try {
                        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(defaultEnglishDriveUrl))
                        context.startActivity(browserIntent)
                      } catch (e: Exception) {
                        Toast.makeText(context, "Browser විවෘත කළ නොහැක", Toast.LENGTH_SHORT).show()
                      }
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                    border = BorderStroke(1.dp, Color.White.copy(alpha = 0.4f)),
                    modifier = Modifier.weight(0.9f),
                    contentPadding = PaddingValues(vertical = 10.dp)
                  ) {
                    Icon(
                      imageVector = Icons.Default.OpenInBrowser,
                      contentDescription = "Browser",
                      tint = Color.White,
                      modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Browser", fontSize = 11.sp, color = Color.White)
                  }
                }
              }
            }
          }
        }

        // Grade Breakdown Cards
        item {
          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                  shape = CircleShape,
                  color = Color(0xFFEFF6FF),
                  modifier = Modifier.size(30.dp)
                ) {
                  Box(contentAlignment = Alignment.Center) {
                    Text("🎯", fontSize = 15.sp)
                  }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                  Text(
                    text = "10 & 11 ශ්‍රේණි (O/L Focus & A Pass Strategies)",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E293B)
                  )
                  Text("Tenses, Voice, Speech, Essays & Graphs", fontSize = 10.sp, color = Color(0xFF64748B))
                }
              }
              Spacer(modifier = Modifier.height(8.dp))
              Text("• All 12 English Tenses & Active vs Passive Voice (be + V3)\n• Direct and Indirect Speech Rules\n• Conditional Clauses (If Types 0, 1, 2, 3)\n• Formal/Informal Letters, Notices, Articles & Graph Descriptions", fontSize = 11.sp, color = Color(0xFF334155), lineHeight = 16.sp)
            }
          }
        }

        item {
          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                  shape = CircleShape,
                  color = Color(0xFFFAF5FF),
                  modifier = Modifier.size(30.dp)
                ) {
                  Box(contentAlignment = Alignment.Center) {
                    Text("📘", fontSize = 15.sp)
                  }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                  Text(
                    text = "06 - 09 ශ්‍රේණි (Foundations & Intermediate)",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E293B)
                  )
                  Text("Parts of Speech, Prepositions, Conjunctions & Daily English", fontSize = 10.sp, color = Color(0xFF64748B))
                }
              }
              Spacer(modifier = Modifier.height(8.dp))
              Text("• 8 Parts of Speech & Subject-Verb Agreement Rules\n• Prepositions of Time (at, on, in) & Place (under, between)\n• Relative Pronouns (who, which, that, whose)\n• Picture Descriptions & Dialogues", fontSize = 11.sp, color = Color(0xFF334155), lineHeight = 16.sp)
            }
          }
        }
      }

      // =========================================================================
      // SUB-SECTION 2: 📖 ඉංග්‍රීසි ව්‍යාකරණ (ENGLISH GRAMMAR MASTERY)
      // =========================================================================
      if (selectedSubTab == 0 || selectedSubTab == 2) {
        // Section Header Banner with Background Image
        item {
          Spacer(modifier = Modifier.height(8.dp))
          Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.5.dp, Color(0xFF8B5CF6).copy(alpha = 0.6f)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Box(modifier = Modifier.fillMaxWidth()) {
              // Educational Background Image
              Image(
                painter = painterResource(id = R.drawable.img_grammar_card_bg_1787064790400),
                contentDescription = "Grammar Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
              )

              // Dark Overlay
              Box(
                modifier = Modifier
                  .matchParentSize()
                  .background(
                    Brush.verticalGradient(
                      colors = listOf(
                        Color(0xFF1E1B4B).copy(alpha = 0.88f),
                        Color(0xFF312E81).copy(alpha = 0.94f),
                        Color(0xFF0F172A).copy(alpha = 0.96f)
                      )
                    )
                  )
              )

              Column(modifier = Modifier.padding(18.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF8B5CF6)
                  ) {
                    Text(
                      text = "TENSES & RULES",
                      fontSize = 10.sp,
                      fontWeight = FontWeight.ExtraBold,
                      color = Color.White,
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }

                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF38BDF8).copy(alpha = 0.25f),
                    border = BorderStroke(1.dp, Color(0xFF38BDF8))
                  ) {
                    Text(
                      text = "🎧 TTS Audio Supported",
                      fontSize = 10.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF7DD3FC),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                  text = "📖 2. ඉංග්‍රීසි ව්‍යාකරණ විශේෂාංගය (Grammar Mastery)",
                  fontSize = 17.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                  text = "Tenses 12, Active/Passive Voice, Reported Speech සහ Prepositions සූත්‍ර සහ සරල සිංහල පැහැදිලි කිරීම්.",
                  fontSize = 11.sp,
                  color = Color(0xFFE2E8F0),
                  lineHeight = 16.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                  onClick = { openDrivePdf() },
                  shape = RoundedCornerShape(10.dp),
                  colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8B5CF6)),
                  modifier = Modifier.fillMaxWidth(),
                  contentPadding = PaddingValues(vertical = 10.dp)
                ) {
                  Icon(
                    imageVector = Icons.Default.PictureAsPdf,
                    contentDescription = "PDF",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                  )
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = "සම්පූර්ණ Grammar සටහන් PDF බලන්න",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                  )
                }
              }
            }
          }
        }

        // Grammar Lessons Items
        items(grammarLessons) { lesson ->
          var isExpanded by remember { mutableStateOf(false) }

          Card(
            shape = RoundedCornerShape(16.dp),
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
                Column(modifier = Modifier.weight(1f)) {
                  Text(
                    text = lesson.title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E293B)
                  )
                  Text(
                    text = lesson.sinhalaSummary,
                    fontSize = 12.sp,
                    color = Color(0xFF7E22CE),
                    fontWeight = FontWeight.Medium
                  )
                }

                IconButton(onClick = { isExpanded = !isExpanded }) {
                  Icon(
                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = "Expand",
                    tint = Color(0xFF7E22CE)
                  )
                }
              }

              Spacer(modifier = Modifier.height(8.dp))

              // Formula Box
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFFAF5FF),
                border = BorderStroke(1.dp, Color(0xFFE9D5FF)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(
                  modifier = Modifier.padding(10.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text("📐", fontSize = 16.sp)
                  Spacer(modifier = Modifier.width(8.dp))
                  Text(
                    text = lesson.formula,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    color = Color(0xFF6B21A8)
                  )
                }
              }

              if (isExpanded) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                  text = "නිදසුන් වාක්‍ය (Examples):",
                  fontSize = 12.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF334155)
                )

                lesson.examples.forEach { (eng, sin) ->
                  Row(
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Column(modifier = Modifier.weight(1f)) {
                      Text(
                        text = "• $eng",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF1E293B)
                      )
                      Text(
                        text = "  ($sin)",
                        fontSize = 11.sp,
                        color = Color(0xFF64748B)
                      )
                    }
                    IconButton(
                      onClick = { speakEnglish(eng) },
                      modifier = Modifier.size(28.dp)
                    ) {
                      Icon(
                        imageVector = Icons.Default.VolumeUp,
                        contentDescription = "Speak",
                        tint = Color(0xFF7E22CE),
                        modifier = Modifier.size(16.dp)
                      )
                    }
                  }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = Color(0xFFFFFBEB),
                  border = BorderStroke(1.dp, Color(0xFFFDE68A)),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Row(
                    modifier = Modifier.padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text("💡", fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                      text = "Pro-Tip: ${lesson.proTip}",
                      fontSize = 11.sp,
                      color = Color(0xFF92400E)
                    )
                  }
                }
              }
            }
          }
        }
      }

      // =========================================================================
      // SUB-SECTION 3: ✍️ රචනා, ලිපි හා නිවේදන (WRITING & COMPOSITION STUDIO)
      // =========================================================================
      if (selectedSubTab == 0 || selectedSubTab == 3) {
        // Section Header Banner with Background Image
        item {
          Spacer(modifier = Modifier.height(8.dp))
          Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.5.dp, Color(0xFF0284C7).copy(alpha = 0.6f)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Box(modifier = Modifier.fillMaxWidth()) {
              // Educational Background Image
              Image(
                painter = painterResource(id = R.drawable.img_writing_card_bg_1787064772136),
                contentDescription = "Writing Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
              )

              // Dark Overlay
              Box(
                modifier = Modifier
                  .matchParentSize()
                  .background(
                    Brush.verticalGradient(
                      colors = listOf(
                        Color(0xFF0C4A6E).copy(alpha = 0.88f),
                        Color(0xFF075985).copy(alpha = 0.94f),
                        Color(0xFF0F172A).copy(alpha = 0.96f)
                      )
                    )
                  )
              )

              Column(modifier = Modifier.padding(18.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF0284C7)
                  ) {
                    Text(
                      text = "ESSAYS & LETTERS",
                      fontSize = 10.sp,
                      fontWeight = FontWeight.ExtraBold,
                      color = Color.White,
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }

                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF38BDF8).copy(alpha = 0.25f),
                    border = BorderStroke(1.dp, Color(0xFF38BDF8))
                  ) {
                    Text(
                      text = "📋 Copy Formats",
                      fontSize = 10.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF7DD3FC),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                  text = "✍️ 3. රචනා, ලිපි හා නිවේදන (Writing & Composition)",
                  fontSize = 17.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                  text = "Formal/Informal Letters, Notices, Articles, Essay Frameworks සහ Graph Descriptions නිවැරදි ආකෘති.",
                  fontSize = 11.sp,
                  color = Color(0xFFE0F2FE),
                  lineHeight = 16.sp
                )
              }
            }
          }
        }

        // Writing Template Items
        items(templates) { tpl ->
          var isExpanded by remember { mutableStateOf(false) }

          Card(
            shape = RoundedCornerShape(16.dp),
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
                Column(modifier = Modifier.weight(1f)) {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                      text = tpl.title,
                      style = MaterialTheme.typography.titleMedium,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF1E293B)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Surface(
                      shape = RoundedCornerShape(6.dp),
                      color = Color(0xFFEFF6FF)
                    ) {
                      Text(
                        text = tpl.type,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2563EB),
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                      )
                    }
                  }
                  Text(
                    text = tpl.description,
                    fontSize = 11.sp,
                    color = Color(0xFF64748B)
                  )
                }

                IconButton(onClick = { isExpanded = !isExpanded }) {
                  Icon(
                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = "Expand",
                    tint = Color(0xFF2563EB)
                  )
                }
              }

              Spacer(modifier = Modifier.height(8.dp))
              Text(
                text = "📌 අනුගමනය කළ යුතු පියවර (Structure Steps):",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0F172A)
              )
              tpl.structureSteps.forEach { step ->
                Text(
                  text = "• $step",
                  fontSize = 11.sp,
                  color = Color(0xFF475569),
                  modifier = Modifier.padding(vertical = 1.dp)
                )
              }

              if (isExpanded) {
                Spacer(modifier = Modifier.height(10.dp))
                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = Color(0xFFF8FAFC),
                  border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Column(modifier = Modifier.padding(12.dp)) {
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.SpaceBetween,
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Text(
                        text = "📄 ආදර්ශ සටහන (Sample Model):",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1E293B)
                      )
                      IconButton(
                        onClick = {
                          if (AppSecurityManager.canCopyContent(context)) {
                            clipboardManager.setText(AnnotatedString(tpl.modelFormat))
                            Toast.makeText(context, "පිටපත් කරගන්නා ලදී (Copied to Clipboard)", Toast.LENGTH_SHORT).show()
                          } else {
                            Toast.makeText(context, "ආරක්ෂක නීති අනුව සටහන් පිටපත් කිරීම (Copy) අවහිර කර ඇත (Admin Only).", Toast.LENGTH_SHORT).show()
                          }
                        },
                        modifier = Modifier.size(24.dp)
                      ) {
                        Icon(
                          imageVector = Icons.Default.ContentCopy,
                          contentDescription = "Copy",
                          tint = Color(0xFF2563EB),
                          modifier = Modifier.size(16.dp)
                        )
                      }
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                      text = tpl.modelFormat,
                      fontSize = 11.sp,
                      color = Color(0xFF334155),
                      lineHeight = 16.sp
                    )
                  }
                }
              }
            }
          }
        }
      }

      // =========================================================================
      // SUB-SECTION 4: 📚 දිනපතා වචන මාලාව (DAILY VOCABULARY & IDIOMS)
      // =========================================================================
      if (selectedSubTab == 0 || selectedSubTab == 4) {
        // Section Header Banner with Background Image
        item {
          Spacer(modifier = Modifier.height(8.dp))
          Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.5.dp, Color(0xFF10B981).copy(alpha = 0.6f)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Box(modifier = Modifier.fillMaxWidth()) {
              // Educational Background Image
              Image(
                painter = painterResource(id = R.drawable.img_vocab_card_bg_1787064760289),
                contentDescription = "Vocab Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
              )

              // Dark Overlay
              Box(
                modifier = Modifier
                  .matchParentSize()
                  .background(
                    Brush.verticalGradient(
                      colors = listOf(
                        Color(0xFF064E3B).copy(alpha = 0.88f),
                        Color(0xFF065F46).copy(alpha = 0.94f),
                        Color(0xFF0F172A).copy(alpha = 0.96f)
                      )
                    )
                  )
              )

              Column(modifier = Modifier.padding(18.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF10B981)
                  ) {
                    Text(
                      text = "VOCABULARY BUILDER",
                      fontSize = 10.sp,
                      fontWeight = FontWeight.ExtraBold,
                      color = Color.White,
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }

                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF34D399).copy(alpha = 0.25f),
                    border = BorderStroke(1.dp, Color(0xFF34D399))
                  ) {
                    Text(
                      text = "🔊 Audio Pronunciation",
                      fontSize = 10.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFFA7F3D0),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                  text = "📚 4. දිනපතා වචන මාලාව හා උච්චාරණය (Daily Vocabulary)",
                  fontSize = 17.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                  text = "නව ඉංග්‍රීසි වචන, නිවැරදි උච්චාරණය, සිංහල තේරුම සහ ප්‍රායෝගික වාක්‍ය භාවිතය.",
                  fontSize = 11.sp,
                  color = Color(0xFFD1FAE5),
                  lineHeight = 16.sp
                )
              }
            }
          }
        }

        // Vocab Items
        items(vocabList) { item ->
          Card(
            shape = RoundedCornerShape(16.dp),
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
                  Text(
                    text = item.word,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E293B)
                  )
                  Spacer(modifier = Modifier.width(8.dp))
                  Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFFF1F5F9)
                  ) {
                    Text(
                      text = item.pronunciation,
                      fontSize = 11.sp,
                      fontFamily = FontFamily.Monospace,
                      color = Color(0xFF475569),
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                  }
                }

                Surface(
                  onClick = { speakEnglish("${item.word}. ${item.exampleSentence}") },
                  shape = CircleShape,
                  color = Color(0xFFEFF6FF),
                  border = BorderStroke(1.dp, Color(0xFF93C5FD))
                ) {
                  Icon(
                    imageVector = Icons.Default.VolumeUp,
                    contentDescription = "Speak",
                    tint = Color(0xFF2563EB),
                    modifier = Modifier
                      .padding(8.dp)
                      .size(20.dp)
                  )
                }
              }

              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = item.partOfSpeech,
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF0284C7)
              )

              Spacer(modifier = Modifier.height(6.dp))
              Text(
                text = "සිංහල තේරුම: ${item.sinhalaMeaning}",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF166534)
              )

              Spacer(modifier = Modifier.height(8.dp))
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFF8FAFC),
                border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(10.dp)) {
                  Text(
                    text = "📝 Example: \"${item.exampleSentence}\"",
                    fontSize = 12.sp,
                    color = Color(0xFF334155),
                    lineHeight = 16.sp
                  )
                  Spacer(modifier = Modifier.height(4.dp))
                  Text(
                    text = "(${item.sinhalaSentenceMeaning})",
                    fontSize = 11.sp,
                    color = Color(0xFF64748B)
                  )
                }
              }
            }
          }
        }
      }

      // =========================================================================
      // SUB-SECTION 5: 🔍 කියවීම & CLOZE TESTS (READING & CLOZE PRACTICE)
      // =========================================================================
      if (selectedSubTab == 0 || selectedSubTab == 5) {
        // Section Header Banner with Background Image
        item {
          Spacer(modifier = Modifier.height(8.dp))
          Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.5.dp, Color(0xFF3B82F6).copy(alpha = 0.6f)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Box(modifier = Modifier.fillMaxWidth()) {
              // Educational Background Image
              Image(
                painter = painterResource(id = R.drawable.img_subjects_bg_1786107319789),
                contentDescription = "Reading Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
              )

              // Dark Overlay
              Box(
                modifier = Modifier
                  .matchParentSize()
                  .background(
                    Brush.verticalGradient(
                      colors = listOf(
                        Color(0xFF1E3A8A).copy(alpha = 0.88f),
                        Color(0xFF1E40AF).copy(alpha = 0.94f),
                        Color(0xFF0F172A).copy(alpha = 0.96f)
                      )
                    )
                  )
              )

              Column(modifier = Modifier.padding(18.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF3B82F6)
                  ) {
                    Text(
                      text = "READING & CLOZE",
                      fontSize = 10.sp,
                      fontWeight = FontWeight.ExtraBold,
                      color = Color.White,
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }

                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF60A5FA).copy(alpha = 0.25f),
                    border = BorderStroke(1.dp, Color(0xFF60A5FA))
                  ) {
                    Text(
                      text = "🎯 Interactive Exam Tests",
                      fontSize = 10.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF93C5FD),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                  text = "🔍 5. කියවීම & Cloze Tests (Reading & Practice)",
                  fontSize = 17.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                  text = "විභාග ආකෘතියේ Cloze Tests සහ Reading Comprehension කතා කියවා තේරුම් ගැනීමේ ප්‍රශ්නාවලි.",
                  fontSize = 11.sp,
                  color = Color(0xFFDBEAFE),
                  lineHeight = 16.sp
                )
              }
            }
          }
        }

        // Cloze Tests
        items(clozeTests) { cloze ->
          var showAnswers by remember { mutableStateOf(false) }

          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(16.dp)) {
              Text(
                text = cloze.title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E293B)
              )
              Text(
                text = cloze.instructions,
                fontSize = 11.sp,
                color = Color(0xFF64748B)
              )

              Spacer(modifier = Modifier.height(10.dp))

              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFF1F5F9),
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(
                  modifier = Modifier.padding(8.dp),
                  horizontalArrangement = Arrangement.spacedBy(8.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text("වචන පෙට්ටිය:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF334155))
                  cloze.wordBank.forEach { w ->
                    Surface(
                      shape = RoundedCornerShape(6.dp),
                      color = Color.White,
                      border = BorderStroke(1.dp, Color(0xFFCBD5E1))
                    ) {
                      Text(
                        text = w,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2563EB),
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                      )
                    }
                  }
                }
              }

              Spacer(modifier = Modifier.height(10.dp))
              Text(
                text = cloze.passageWithBlanks,
                fontSize = 12.sp,
                lineHeight = 18.sp,
                color = Color(0xFF1E293B)
              )

              Spacer(modifier = Modifier.height(10.dp))

              if (showAnswers) {
                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = Color(0xFFECFDF5),
                  border = BorderStroke(1.dp, Color(0xFFA7F3D0)),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                      text = "✅ නිවැරදි පිළිතුරු: ${cloze.correctAnswers.joinToString(", ")}",
                      fontSize = 12.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF065F46)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                      text = "පැහැදිලි කිරීම: ${cloze.explanation}",
                      fontSize = 11.sp,
                      color = Color(0xFF047857)
                    )
                  }
                }
                Spacer(modifier = Modifier.height(8.dp))
              }

              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
              ) {
                Button(
                  onClick = { showAnswers = !showAnswers },
                  shape = RoundedCornerShape(8.dp),
                  colors = ButtonDefaults.buttonColors(
                    containerColor = if (showAnswers) Color(0xFFF1F5F9) else Color(0xFF10B981),
                    contentColor = if (showAnswers) Color(0xFF334155) else Color.White
                  ),
                  contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
                ) {
                  Text(
                    text = if (showAnswers) "පිළිතුරු සඟවන්න" else "පිළිතුරු පරීක්ෂා කරන්න",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                  )
                }
              }
            }
          }
        }

        // Reading Passages
        item {
          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = "📖 Reading Comprehension (කියවා තේරුම් ගැනීම)",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0F172A)
          )
        }

        items(readingPassages) { passage ->
          Card(
            shape = RoundedCornerShape(16.dp),
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
                Text(
                  text = passage.title,
                  style = MaterialTheme.typography.titleSmall,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF0F172A)
                )

                IconButton(
                  onClick = { speakEnglish(passage.story) }
                ) {
                  Icon(Icons.Default.VolumeUp, contentDescription = "Listen Story", tint = Color(0xFF2563EB))
                }
              }

              Text(
                text = passage.story,
                fontSize = 12.sp,
                lineHeight = 18.sp,
                color = Color(0xFF334155)
              )

              Spacer(modifier = Modifier.height(8.dp))
              Text(
                text = "සිංහල සාරාංශය: ${passage.sinhalaSummary}",
                fontSize = 11.sp,
                color = Color(0xFF64748B)
              )

              Spacer(modifier = Modifier.height(12.dp))
              Text(
                text = "ප්‍රශ්න හා පිළිතුරු (Questions):",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E293B)
              )

              passage.questions.forEachIndexed { qIdx, q ->
                var selectedOption by remember { mutableStateOf<Int?>(null) }

                Column(modifier = Modifier.padding(vertical = 6.dp)) {
                  Text(
                    text = "${qIdx + 1}. ${q.questionText}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF1E293B)
                  )

                  Spacer(modifier = Modifier.height(4.dp))

                  q.options.forEachIndexed { optIdx, opt ->
                    val isChosen = selectedOption == optIdx
                    val isCorrect = optIdx == q.correctOptionIndex

                    Surface(
                      onClick = { selectedOption = optIdx },
                      shape = RoundedCornerShape(8.dp),
                      color = when {
                        isChosen && isCorrect -> Color(0xFFD1FAE5)
                        isChosen && !isCorrect -> Color(0xFFFEE2E2)
                        else -> Color(0xFFF8FAFC)
                      },
                      border = BorderStroke(
                        1.dp,
                        when {
                          isChosen && isCorrect -> Color(0xFF10B981)
                          isChosen && !isCorrect -> Color(0xFFEF4444)
                          else -> Color(0xFFE2E8F0)
                        }
                      ),
                      modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 2.dp)
                    ) {
                      Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                      ) {
                        Text(
                          text = "${'A' + optIdx}. $opt",
                          fontSize = 11.sp,
                          color = Color(0xFF1E293B),
                          fontWeight = if (isChosen) FontWeight.Bold else FontWeight.Normal
                        )
                      }
                    }
                  }

                  if (selectedOption != null) {
                    Text(
                      text = if (selectedOption == q.correctOptionIndex) "✅ නිවැරදියි! ${q.explanation}" else "❌ වැරදියි. නිවැරදි පිළිතුර: ${'A' + q.correctOptionIndex}. ${q.explanation}",
                      fontSize = 10.sp,
                      color = if (selectedOption == q.correctOptionIndex) Color(0xFF047857) else Color(0xFFB91C1C),
                      modifier = Modifier.padding(top = 2.dp)
                    )
                  }
                }
              }
            }
          }
        }
      }

      // =========================================================================
      // SUB-SECTION 6: 🎙️ සවන්දීම හා කථන පුහුණුව (LISTENING & SPEAKING STUDIO)
      // =========================================================================
      if (selectedSubTab == 0 || selectedSubTab == 6) {
        // Section Header Banner with Background Image
        item {
          Spacer(modifier = Modifier.height(8.dp))
          Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.5.dp, Color(0xFFE11D48).copy(alpha = 0.6f)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Box(modifier = Modifier.fillMaxWidth()) {
              // Educational Background Image
              Image(
                painter = painterResource(id = R.drawable.img_listening_card_bg_1787064805369),
                contentDescription = "Listening Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
              )

              // Dark Overlay
              Box(
                modifier = Modifier
                  .matchParentSize()
                  .background(
                    Brush.verticalGradient(
                      colors = listOf(
                        Color(0xFF881337).copy(alpha = 0.88f),
                        Color(0xFF9F1239).copy(alpha = 0.94f),
                        Color(0xFF0F172A).copy(alpha = 0.96f)
                      )
                    )
                  )
              )

              Column(modifier = Modifier.padding(18.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFE11D48)
                  ) {
                    Text(
                      text = "LISTENING LAB",
                      fontSize = 10.sp,
                      fontWeight = FontWeight.ExtraBold,
                      color = Color.White,
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }

                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFFDA4AF).copy(alpha = 0.25f),
                    border = BorderStroke(1.dp, Color(0xFFFDA4AF))
                  ) {
                    Text(
                      text = "⚡ 1.0x Normal & 0.7x Slow",
                      fontSize = 10.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFFFFE4E6),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                  text = "🎙️ 6. සවන්දීම හා කථන පුහුණුව (Listening & Speaking)",
                  fontSize = 17.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                  text = "සාමාන්‍ය වේගයෙන් හෝ මන්දගාමීව (0.7x Slow) අසා වාක්‍ය උච්චාරණය හා සවන්දීමේ හැකියාව දියුණු කරගන්න.",
                  fontSize = 11.sp,
                  color = Color(0xFFFFE4E6),
                  lineHeight = 16.sp
                )
              }
            }
          }
        }

        val listeningSentences = listOf(
          Pair("Good morning teacher, could you please explain the homework again?", "සුබ උදෑසනක් ගුරුතුමනි, කරුණාකර ගෙදර වැඩ නැවත පැහැදිලි කළ හැකිද?"),
          Pair("Environmental pollution is one of the most critical challenges facing humanity today.", "පරිසර දූෂණය අද මානව වර්ගයා මුහුණ දෙන ප්‍රධානතම අභියෝගයකි."),
          Pair("Education empowers young students to think critically and solve complex problems.", "අධ්‍යාපනය සිසුන්ට තාර්කිකව සිතීමට හා ගැටලු විසඳීමට ශක්තිය ලබාදෙයි."),
          Pair("The Inter-house sports meet will commence at 8 o'clock tomorrow morning.", "නිවාසාන්තර ක්‍රීඩා උළෙල හෙට උදෑසන 8ට ආරම්භ වේ."),
          Pair("Practice makes perfect, so never give up on learning new languages.", "පුහුණුවෙන් පරිපූර්ණත්වය ළඟා වේ, එබැවින් නව භාෂා ඉගෙනීම කිසි විටෙකත් අත්නොහරින්න.")
        )

        items(listeningSentences) { (sentence, sinMeaning) ->
          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(16.dp)) {
              Text(
                text = sentence,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E293B),
                lineHeight = 18.sp
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "($sinMeaning)",
                fontSize = 11.sp,
                color = Color(0xFF64748B)
              )

              Spacer(modifier = Modifier.height(10.dp))

              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
              ) {
                // Normal Speed Button
                Button(
                  onClick = { speakEnglish(sentence, 1.0f) },
                  shape = RoundedCornerShape(8.dp),
                  colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB)),
                  contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                  modifier = Modifier.weight(1f)
                ) {
                  Icon(Icons.Default.VolumeUp, contentDescription = "Normal", modifier = Modifier.size(14.dp))
                  Spacer(modifier = Modifier.width(4.dp))
                  Text("🔊 Normal (1.0x)", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }

                // Slow Speed Button
                OutlinedButton(
                  onClick = { speakEnglish(sentence, 0.7f) },
                  shape = RoundedCornerShape(8.dp),
                  colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF0F172A)),
                  contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                  modifier = Modifier.weight(1f)
                ) {
                  Icon(Icons.Default.SlowMotionVideo, contentDescription = "Slow", modifier = Modifier.size(14.dp))
                  Spacer(modifier = Modifier.width(4.dp))
                  Text("🐢 Slow (0.7x)", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
              }
            }
          }
        }
      }
    }

  // Internal Google Drive In-App PDF Dialog (Fallback / Direct modal)
  if (internalShowPdfModal && internalPdfUrl.isNotBlank()) {
    Dialog(
      onDismissRequest = { internalShowPdfModal = false },
      properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
      Surface(
        modifier = Modifier
          .fillMaxSize()
          .background(Color.Black),
        color = Color(0xFF0F172A)
      ) {
        Column(modifier = Modifier.fillMaxSize()) {
          // Modal Header
          Surface(
            color = Color(0xFF1E293B),
            shadowElevation = 4.dp,
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
              ) {
                Icon(
                  imageVector = Icons.Default.PictureAsPdf,
                  contentDescription = "PDF",
                  tint = Color(0xFFF59E0B),
                  modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                  Text(
                    text = internalPdfTitle,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    maxLines = 1
                  )
                  Text(
                    text = "Google Drive Secure Preview",
                    fontSize = 10.sp,
                    color = Color(0xFF94A3B8)
                  )
                }
              }

              Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                  onClick = {
                    try {
                      val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(internalPdfUrl))
                      context.startActivity(browserIntent)
                    } catch (e: Exception) {
                      Toast.makeText(context, "Browser විවෘත කළ නොහැක", Toast.LENGTH_SHORT).show()
                    }
                  }
                ) {
                  Icon(
                    imageVector = Icons.Default.OpenInBrowser,
                    contentDescription = "Open in Browser",
                    tint = Color(0xFF38BDF8)
                  )
                }

                IconButton(onClick = { internalShowPdfModal = false }) {
                  Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = Color.White
                  )
                }
              }
            }
          }

          // Embedded Google Drive WebView
          Box(
            modifier = Modifier
              .fillMaxSize()
              .background(Color.White)
          ) {
            AndroidView(
              factory = { ctx ->
                WebView(ctx).apply {
                  settings.javaScriptEnabled = true
                  settings.domStorageEnabled = true
                  settings.loadWithOverviewMode = true
                  settings.useWideViewPort = true
                  settings.builtInZoomControls = true
                  settings.displayZoomControls = false
                  webViewClient = WebViewClient()
                  loadUrl(internalPdfUrl)
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
