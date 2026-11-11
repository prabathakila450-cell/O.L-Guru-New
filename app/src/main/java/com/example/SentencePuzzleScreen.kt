package com.example

import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.activity.compose.BackHandler
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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SentencePuzzleScreen(
  onBack: () -> Unit
) {
  val context = LocalContext.current
  val clipboardManager = LocalClipboardManager.current
  BackHandler(enabled = true) { onBack() }

  // TTS Engine
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

  fun speak(text: String) {
    if (isTtsReady && tts != null) {
      tts?.stop()
      tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "puzzle_${System.currentTimeMillis()}")
    } else {
      Toast.makeText(context, "Voice playback initializing...", Toast.LENGTH_SHORT).show()
    }
  }

  var selectedTab by remember { mutableIntStateOf(0) } // 0: Sentence Puzzles, 1: Cloze Tests

  val categories = remember { SentencePuzzleRepository.getAllCategories() }
  var selectedCategoryId by remember { mutableIntStateOf(1) }
  val currentCategory = categories.find { it.id == selectedCategoryId } ?: categories.firstOrNull() ?: SentencePuzzleCategory(1, "Basic", "මූලික", "වාක්‍ය", "🧩", emptyList())
  val clozeTests = remember { EnglishBuilderRepository.getClozeTests() }

  val revealedAnswers = remember { mutableStateMapOf<String, Boolean>() }
  var showAllAnswersInCat by remember { mutableStateOf(false) }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = "🧩 Sentence Puzzle & Cloze Tests",
              fontSize = 16.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Text(
              text = "වාක්‍ය ගොඩනැගීමේ ක්‍රීඩාව සහ ප්‍රශ්නාවලිය",
              fontSize = 11.sp,
              color = Color(0xFFFDE68A)
            )
          }
        },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = Color(0xFFB45309)
        )
      )
    }
  ) { paddingValues ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
        .background(Color(0xFFF8FAFC))
    ) {
      // Tab Row
      TabRow(
        selectedTabIndex = selectedTab,
        containerColor = Color(0xFFFFFBEB),
        contentColor = Color(0xFFB45309)
      ) {
        Tab(
          selected = selectedTab == 0,
          onClick = { selectedTab = 0 },
          text = {
            Text(
              "🧩 වාක්‍ය ගොඩනැගීම (Puzzles)",
              fontWeight = if (selectedTab == 0) FontWeight.Bold else FontWeight.Normal,
              fontSize = 12.sp
            )
          }
        )
        Tab(
          selected = selectedTab == 1,
          onClick = { selectedTab = 1 },
          text = {
            Text(
              "📝 Cloze Tests (හිස්තැන්)",
              fontWeight = if (selectedTab == 1) FontWeight.Bold else FontWeight.Normal,
              fontSize = 12.sp
            )
          }
        )
      }

      if (selectedTab == 0) {
        // Category Selector bar
        Surface(
          modifier = Modifier.fillMaxWidth(),
          color = Color.White,
          shadowElevation = 2.dp
        ) {
          Column(modifier = Modifier.padding(10.dp)) {
            Text(
              "📂 පුහුණු කාණ්ඩය තෝරන්න (කාණ්ඩ 30 න් එකක්):",
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF92400E)
            )
            Spacer(modifier = Modifier.height(6.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
              items(categories) { cat ->
                val isSelected = cat.id == selectedCategoryId
                FilterChip(
                  selected = isSelected,
                  onClick = {
                    selectedCategoryId = cat.id
                    showAllAnswersInCat = false
                  },
                  label = {
                    Text(
                      "${cat.icon} කාණ්ඩය ${cat.id}",
                      fontSize = 11.sp,
                      fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                  },
                  colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFFD97706),
                    selectedLabelColor = Color.White,
                    containerColor = Color(0xFFFFFBEB),
                    labelColor = Color(0xFF92400E)
                  ),
                  border = FilterChipDefaults.filterChipBorder(
                    enabled = true,
                    selected = isSelected,
                    borderColor = Color(0xFFFCD34D),
                    selectedBorderColor = Color(0xFFB45309)
                  )
                )
              }
            }
          }
        }

        // Puzzles List
        LazyColumn(
          modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp, vertical = 8.dp),
          verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
          // Category Header Card
          item {
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFFFEF3C7)),
              border = BorderStroke(1.5.dp, Color(0xFFF59E0B)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(14.dp)) {
                Row(
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                  Text(currentCategory.icon, fontSize = 28.sp)
                  Column(modifier = Modifier.weight(1f)) {
                    Text(
                      currentCategory.titleSinhala,
                      fontSize = 14.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF92400E)
                    )
                    Text(
                      currentCategory.titleEnglish,
                      fontSize = 12.sp,
                      fontWeight = FontWeight.SemiBold,
                      color = Color(0xFFB45309)
                    )
                  }
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                  currentCategory.description,
                  fontSize = 11.5.sp,
                  color = Color(0xFF78350F)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFFFDE68A)
                  ) {
                    Text(
                      "📝 වාක්‍ය ${currentCategory.puzzles.size} න් ${currentCategory.puzzles.size} ම මෙහි ඇත",
                      fontSize = 11.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF78350F),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }
                  Button(
                    onClick = {
                      showAllAnswersInCat = !showAllAnswersInCat
                      currentCategory.puzzles.forEach { p ->
                        revealedAnswers[p.id] = showAllAnswersInCat
                      }
                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD97706)),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                  ) {
                    Text(
                      if (showAllAnswersInCat) "සියලු පිළිතුරු සඟවන්න" else "සියලු පිළිතුරු පෙන්වන්න",
                      fontSize = 11.sp,
                      fontWeight = FontWeight.Bold
                    )
                  }
                }
              }
            }
          }

          // Puzzles
          itemsIndexed(currentCategory.puzzles) { pIdx, puzzle ->
            val isRevealed = showAllAnswersInCat || (revealedAnswers[puzzle.id] == true)
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color.White),
              border = BorderStroke(1.dp, Color(0xFFFDE68A)),
              elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(14.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(
                    "වාක්‍ය ගැටලුව ${pIdx + 1} / ${currentCategory.puzzles.size}:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF92400E)
                  )
                  Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = Color(0xFFFEF3C7)
                  ) {
                    Text(
                      "කාණ්ඩය ${currentCategory.id}",
                      fontSize = 9.5.sp,
                      color = Color(0xFFB45309),
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                  }
                }

                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  "සිංහල අර්ථය: ${puzzle.sinhalaMeaning}",
                  fontSize = 12.sp,
                  color = Color(0xFF78350F),
                  fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text("අවුල් වූ වචන (Scrambled Words):", fontSize = 10.5.sp, color = Color(0xFF64748B))

                LazyRow(
                  horizontalArrangement = Arrangement.spacedBy(6.dp),
                  modifier = Modifier.padding(vertical = 6.dp)
                ) {
                  items(puzzle.scrambledWords) { w ->
                    Surface(
                      shape = RoundedCornerShape(6.dp),
                      color = Color(0xFFFFFBEB),
                      border = BorderStroke(1.dp, Color(0xFFFCD34D))
                    ) {
                      Text(
                        w,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFB45309),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)
                      )
                    }
                  }
                }

                if (isRevealed) {
                  Spacer(modifier = Modifier.height(8.dp))
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFECFDF5),
                    border = BorderStroke(1.dp, Color(0xFFA7F3D0)),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                      Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                      ) {
                        Text(
                          "✅ නිවැරදි වාක්‍යය (Correct Sentence):",
                          fontSize = 11.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFF065F46)
                        )
                        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                          IconButton(
                            onClick = { speak(puzzle.correctSentence) },
                            modifier = Modifier.size(28.dp)
                          ) {
                            Icon(
                              Icons.Default.VolumeUp,
                              contentDescription = "Speak",
                              tint = Color(0xFF047857),
                              modifier = Modifier.size(18.dp)
                            )
                          }
                          IconButton(
                            onClick = {
                              clipboardManager.setText(AnnotatedString(puzzle.correctSentence))
                              Toast.makeText(context, "පිටපත් කරගන්නා ලදී (Copied)", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier.size(28.dp)
                          ) {
                            Icon(
                              Icons.Default.ContentCopy,
                              contentDescription = "Copy",
                              tint = Color(0xFF047857),
                              modifier = Modifier.size(16.dp)
                            )
                          }
                        }
                      }
                      Spacer(modifier = Modifier.height(2.dp))
                      Text(
                        text = puzzle.correctSentence,
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF047857)
                      )
                      if (puzzle.hint.isNotBlank()) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                          text = "💡 ඉඟිය (Hint): ${puzzle.hint}",
                          fontSize = 10.5.sp,
                          color = Color(0xFF047857).copy(alpha = 0.85f)
                        )
                      }
                    }
                  }
                } else {
                  Spacer(modifier = Modifier.height(6.dp))
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                  ) {
                    TextButton(
                      onClick = { revealedAnswers[puzzle.id] = true },
                      contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
                    ) {
                      Icon(Icons.Default.Visibility, contentDescription = null, modifier = Modifier.size(16.dp), tint = Color(0xFFD97706))
                      Spacer(modifier = Modifier.width(4.dp))
                      Text("පිළිතුර බලන්න", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFD97706))
                    }
                  }
                }
              }
            }
          }
        }
      } else {
        // Cloze Tests
        LazyColumn(
          modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
          verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
          items(clozeTests) { item ->
            var showClozeAnswer by remember { mutableStateOf(false) }
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color.White),
              border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
              elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(14.dp)) {
                Text(
                  item.title,
                  fontSize = 13.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF0F172A)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  item.passageWithBlanks,
                  fontSize = 12.sp,
                  color = Color(0xFF334155),
                  lineHeight = 18.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                  "විකල්ප වචන (Word Bank): ${item.wordBank.joinToString(", ")}",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.SemiBold,
                  color = Color(0xFF2563EB)
                )
                Spacer(modifier = Modifier.height(6.dp))
                if (showClozeAnswer) {
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFEFF6FF),
                    border = BorderStroke(1.dp, Color(0xFFBFDBFE)),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                      Text(
                        "✅ නිවැරදි පිළිතුරු: ${item.correctAnswers.joinToString(", ")}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1D4ED8)
                      )
                      if (item.explanation.isNotBlank()) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                          "💡 විවරණය: ${item.explanation}",
                          fontSize = 11.sp,
                          color = Color(0xFF1E40AF)
                        )
                      }
                    }
                  }
                } else {
                  Button(
                    onClick = { showClozeAnswer = true },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB)),
                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
                  ) {
                    Text("පිළිතුර පෙන්වන්න", fontSize = 11.sp)
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
