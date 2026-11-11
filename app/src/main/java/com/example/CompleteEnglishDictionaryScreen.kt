package com.example

import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

/**
 * Complete Sinhala-English Comprehensive Dictionary Screen (සම්පූර්ණ ඉංග්‍රීසි-සිංහල ශබ්දකෝෂය)
 * Integrated directly inside the English Master Class feature.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompleteEnglishDictionaryScreen(
  onBack: () -> Unit
) {
  val context = LocalContext.current
  val clipboardManager = LocalClipboardManager.current

  // TTS Engine
  var tts by remember { mutableStateOf<TextToSpeech?>(null) }
  DisposableEffect(Unit) {
    val textToSpeech = TextToSpeech(context) { status ->
      if (status == TextToSpeech.SUCCESS) {
        tts?.language = Locale.US
      }
    }
    tts = textToSpeech
    onDispose {
      textToSpeech.stop()
      textToSpeech.shutdown()
    }
  }

  fun speak(text: String, rate: Float = 1.0f) {
    tts?.let {
      it.setSpeechRate(rate)
      it.speak(text, TextToSpeech.QUEUE_FLUSH, null, "DICT_${System.currentTimeMillis()}")
    }
  }

  // Search & Filter States
  var searchQuery by remember { mutableStateOf("") }
  var selectedLetter by remember { mutableStateOf("A") }
  var selectedPos by remember { mutableStateOf("ALL") }
  var showFavoritesOnly by remember { mutableStateOf(false) }
  val favoriteWords = remember { mutableStateListOf<String>() }

  val alphabetLetters = remember {
    listOf("ALL") + ('A'..'Z').map { it.toString() }
  }

  val posList = remember {
    listOf("ALL", "Noun", "Verb", "Adjective", "Adverb")
  }

  // Active word list: fast 300-word retrieval per letter or full 7,800-word bank
  val activeWords = remember(selectedLetter) {
    if (selectedLetter == "ALL") {
      EnglishCompleteDictionaryData.getFullCompleteDictionary()
    } else {
      EnglishCompleteDictionaryData.getWordsForLetter(selectedLetter[0])
    }
  }

  // Filtered List
  val filteredWords = remember(activeWords, searchQuery, selectedPos, showFavoritesOnly, favoriteWords.size) {
    activeWords.filter { item ->
      val matchesPos = if (selectedPos == "ALL") true else item.pos.contains(selectedPos, ignoreCase = true)
      val matchesFav = if (!showFavoritesOnly) true else favoriteWords.contains(item.word)
      val matchesQuery = if (searchQuery.isBlank()) true else {
        val q = searchQuery.trim().lowercase()
        item.word.lowercase().contains(q) ||
          item.sinhala.lowercase().contains(q) ||
          item.englishDef.lowercase().contains(q) ||
          item.synonyms.any { it.lowercase().contains(q) } ||
          item.example.lowercase().contains(q)
      }
      matchesPos && matchesFav && matchesQuery
    }
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = "සම්පූර්ණ ඉංග්‍රීසි-සිංහල ශබ්දකෝෂය",
              fontSize = 15.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Text(
              text = if (selectedLetter == "ALL") "Comprehensive Dictionary • 7,800+ Words (300 Words per Letter A-Z)"
                     else "අකුර '$selectedLetter' • වචන 300ක් (Letter '$selectedLetter' • 300 Words)",
              fontSize = 10.sp,
              color = Color(0xFFE0E7FF)
            )
          }
        },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(
              Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = "Back",
              tint = Color.White
            )
          }
        },
        actions = {
          IconButton(onClick = {
            showFavoritesOnly = !showFavoritesOnly
          }) {
            Icon(
              if (showFavoritesOnly) Icons.Default.Star else Icons.Default.StarBorder,
              contentDescription = "Favorites",
              tint = if (showFavoritesOnly) Color(0xFFFBBF24) else Color.White
            )
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = Color(0xFF4338CA)
        )
      )
    },
    containerColor = Color(0xFFF8FAFC)
  ) { innerPadding ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding),
      contentPadding = PaddingValues(bottom = 32.dp),
      verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
      // Top Header & Search Area
      item {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .background(
              Brush.verticalGradient(
                colors = listOf(Color(0xFF4338CA), Color(0xFF4F46E5), Color(0xFF6366F1))
              )
            )
            .padding(horizontal = 14.dp, vertical = 12.dp)
        ) {
          // Search Box
          OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
              Text(
                "ඉංග්‍රීසි හෝ සිංහලෙන් සොයන්න (Search in English/Sinhala)...",
                fontSize = 11.5.sp,
                color = Color(0xFF64748B)
              )
            },
            leadingIcon = {
              Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF4F46E5))
            },
            trailingIcon = {
              if (searchQuery.isNotBlank()) {
                IconButton(onClick = { searchQuery = "" }) {
                  Icon(Icons.Default.Clear, contentDescription = "Clear", tint = Color(0xFF64748B))
                }
              }
            },
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
              focusedBorderColor = Color.White,
              unfocusedBorderColor = Color(0xFFE2E8F0),
              focusedContainerColor = Color.White,
              unfocusedContainerColor = Color.White
            ),
            singleLine = true
          )

          Spacer(modifier = Modifier.height(10.dp))

          // Letter A-Z Selector Row
          Text(
            text = "අකාරාදී අනුපිළිවෙළ (Alphabetical Index A-Z):",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFE0E7FF)
          )
          Spacer(modifier = Modifier.height(4.dp))
          LazyRow(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            items(alphabetLetters) { letter ->
              val isSelected = selectedLetter == letter
              Surface(
                shape = RoundedCornerShape(6.dp),
                color = if (isSelected) Color(0xFFFBBF24) else Color.White.copy(alpha = 0.18f),
                modifier = Modifier.clickable {
                  selectedLetter = letter
                }
              ) {
                Text(
                  text = letter,
                  fontSize = 11.sp,
                  fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Medium,
                  color = if (isSelected) Color(0xFF0F172A) else Color.White,
                  modifier = Modifier.padding(horizontal = 9.dp, vertical = 5.dp)
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(8.dp))

          // POS Filter Row
          LazyRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            items(posList) { pos ->
              val isSelected = selectedPos == pos
              Surface(
                shape = RoundedCornerShape(16.dp),
                color = if (isSelected) Color.White else Color.White.copy(alpha = 0.12f),
                border = BorderStroke(1.dp, if (isSelected) Color.White else Color.White.copy(alpha = 0.3f)),
                modifier = Modifier.clickable {
                  selectedPos = pos
                }
              ) {
                Text(
                  text = if (pos == "ALL") "සියලු පද (All POS)" else pos,
                  fontSize = 10.sp,
                  fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                  color = if (isSelected) Color(0xFF3730A3) else Color.White,
                  modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                )
              }
            }
          }
        }
      }

      // Count Indicator & Star Filter Banner
      item {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            text = if (selectedLetter == "ALL") "ප්‍රතිඵල: ${filteredWords.size} / 7,800+ වචන"
                   else "අකුර '$selectedLetter': ${filteredWords.size} / ${activeWords.size} වචන (100% Verified)",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF475569)
          )

          if (showFavoritesOnly) {
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFFFEF3C7),
              border = BorderStroke(1.dp, Color(0xFFFCD34D)),
              modifier = Modifier.clickable { showFavoritesOnly = false }
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text("⭐ තරු සලකුණු කළ වචන (${favoriteWords.size})", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF92400E))
                Spacer(modifier = Modifier.width(4.dp))
                Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color(0xFF92400E), modifier = Modifier.size(12.dp))
              }
            }
          }
        }
      }

      // Empty State
      if (filteredWords.isEmpty()) {
        item {
          Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 14.dp, vertical = 20.dp)
          ) {
            Column(
              modifier = Modifier.padding(24.dp),
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
              Text("🔍", fontSize = 36.sp)
              Spacer(modifier = Modifier.height(8.dp))
              Text("වචන කිසිවක් හමු නොවීය", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E293B))
              Text("වෙනත් ඉංග්‍රීසි හෝ සිංහල අකුරු/වචනයක් යොදා නැවත සොයන්න.", fontSize = 11.sp, color = Color(0xFF64748B))
              Spacer(modifier = Modifier.height(12.dp))
              Button(
                onClick = {
                  searchQuery = ""
                  selectedLetter = "ALL"
                  selectedPos = "ALL"
                  showFavoritesOnly = false
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5))
              ) {
                Text("සියලු වචන පෙන්වන්න (Reset)", fontSize = 11.sp)
              }
            }
          }
        }
      }

      // Words List
      items(filteredWords, key = { it.word }) { wordItem ->
        val isFav = favoriteWords.contains(wordItem.word)
        Card(
          shape = RoundedCornerShape(14.dp),
          colors = CardDefaults.cardColors(containerColor = Color.White),
          border = BorderStroke(1.dp, if (isFav) Color(0xFFFCD34D) else Color(0xFFE0E7FF)),
          elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp)
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            // Header Row: Word, POS, Audio, Favorite, Copy
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
              ) {
                Text(
                  text = wordItem.word,
                  fontSize = 17.sp,
                  fontWeight = FontWeight.ExtraBold,
                  color = Color(0xFF312E81)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = Color(0xFFEEF2FF),
                  border = BorderStroke(0.5.dp, Color(0xFFC7D2FE))
                ) {
                  Text(
                    text = wordItem.pos,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4338CA),
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                  )
                }
              }

              Row(verticalAlignment = Alignment.CenterVertically) {
                // Speak Normal
                IconButton(
                  onClick = { speak(wordItem.word, 1.0f) },
                  modifier = Modifier.size(30.dp)
                ) {
                  Icon(Icons.Default.VolumeUp, contentDescription = "Speak Normal", tint = Color(0xFF4F46E5), modifier = Modifier.size(18.dp))
                }
                // Speak Slow
                IconButton(
                  onClick = { speak(wordItem.word, 0.7f) },
                  modifier = Modifier.size(30.dp)
                ) {
                  Icon(Icons.Default.SlowMotionVideo, contentDescription = "Speak Slow", tint = Color(0xFFD97706), modifier = Modifier.size(18.dp))
                }
                // Bookmark / Favorite
                IconButton(
                  onClick = {
                    if (isFav) {
                      favoriteWords.remove(wordItem.word)
                      Toast.makeText(context, "ඉවත් කරන ලදී", Toast.LENGTH_SHORT).show()
                    } else {
                      favoriteWords.add(wordItem.word)
                      Toast.makeText(context, "තරු සලකුණු කරන ලදී ⭐", Toast.LENGTH_SHORT).show()
                    }
                  },
                  modifier = Modifier.size(30.dp)
                ) {
                  Icon(
                    if (isFav) Icons.Default.Star else Icons.Default.StarBorder,
                    contentDescription = "Favorite",
                    tint = if (isFav) Color(0xFFF59E0B) else Color(0xFF94A3B8),
                    modifier = Modifier.size(18.dp)
                  )
                }
                // Copy to Clipboard (Admin only)
                IconButton(
                  onClick = {
                    if (AppSecurityManager.canCopyContent(context)) {
                      val clipText = "${wordItem.word} (${wordItem.pos})\nසිංහල තේරුම: ${wordItem.sinhala}\nEnglish: ${wordItem.englishDef}\nExample: \"${wordItem.example}\""
                      clipboardManager.setText(AnnotatedString(clipText))
                      Toast.makeText(context, "පිටපත් කරගන්නා ලදී (Copied)", Toast.LENGTH_SHORT).show()
                    } else {
                      Toast.makeText(context, "ආරක්ෂක නීති අනුව සටහන් පිටපත් කිරීම (Copy) අවහිර කර ඇත (Admin Only).", Toast.LENGTH_SHORT).show()
                    }
                  },
                  modifier = Modifier.size(30.dp)
                ) {
                  Icon(Icons.Default.ContentCopy, contentDescription = "Copy", tint = Color(0xFF64748B), modifier = Modifier.size(16.dp))
                }
              }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Sinhala Meaning
            Surface(
              shape = RoundedCornerShape(8.dp),
              color = Color(0xFFF0FDF4),
              border = BorderStroke(1.dp, Color(0xFFBBF7D0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = "සිංහල තේරුම: ",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF166534)
                )
                Text(
                  text = wordItem.sinhala,
                  fontSize = 12.sp,
                  fontWeight = FontWeight.ExtraBold,
                  color = Color(0xFF15803D)
                )
              }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // English Definition
            Text(
              text = "Definition: ${wordItem.englishDef}",
              fontSize = 11.sp,
              color = Color(0xFF334155),
              lineHeight = 16.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Example Sentence
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
                  Text(
                    text = "ආදර්ශ වාක්‍යය (Example):",
                    fontSize = 9.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF475569)
                  )
                  IconButton(
                    onClick = { speak(wordItem.example, 0.9f) },
                    modifier = Modifier.size(20.dp)
                  ) {
                    Icon(Icons.Default.VolumeUp, contentDescription = "Speak Example", tint = Color(0xFF64748B), modifier = Modifier.size(13.dp))
                  }
                }
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                  text = "\"${wordItem.example}\"",
                  fontSize = 11.sp,
                  fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                  color = Color(0xFF0F172A),
                  lineHeight = 16.sp
                )
              }
            }

            // Synonyms
            if (wordItem.synonyms.isNotEmpty()) {
              Spacer(modifier = Modifier.height(6.dp))
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
              ) {
                Text(
                  text = "සමාන පද: ",
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF4338CA)
                )
                Text(
                  text = wordItem.synonyms.joinToString(", "),
                  fontSize = 10.sp,
                  color = Color(0xFF4F46E5),
                  fontWeight = FontWeight.Medium
                )
              }
            }
          }
        }
      }
    }
  }
}
