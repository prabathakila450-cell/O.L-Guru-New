package com.example

import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.VolumeUp
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TenseComparisonScreen(
  onBack: () -> Unit,
  initialCategoryId: Int = 1
) {
  val context = LocalContext.current
  val clipboardManager = LocalClipboardManager.current

  val allCategories = remember { TenseComparisonRepository.getAllCategories() }
  var selectedCategoryId by remember { mutableIntStateOf(initialCategoryId) }
  val currentCategory = remember(selectedCategoryId) {
    TenseComparisonRepository.getCategoryById(selectedCategoryId) ?: allCategories.first()
  }

  var searchQuery by remember { mutableStateOf("") }
  var activeTenseFilter by remember { mutableStateOf("ALL") } // ALL, PAST, PRESENT, FUTURE
  var showCategorySelectorDialog by remember { mutableStateOf(false) }

  // TTS Setup
  var tts by remember { mutableStateOf<TextToSpeech?>(null) }
  var isTtsReady by remember { mutableStateOf(false) }

  DisposableEffect(Unit) {
    val engine = TextToSpeech(context) { status ->
      if (status == TextToSpeech.SUCCESS) {
        tts?.language = Locale.ENGLISH
        isTtsReady = true
      }
    }
    tts = engine
    onDispose {
      engine.stop()
      engine.shutdown()
    }
  }

  fun speak(text: String) {
    if (isTtsReady && tts != null) {
      tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "tense_speak_${System.currentTimeMillis()}")
    } else {
      Toast.makeText(context, "TTS සක්‍රීය වෙමින් පවතී...", Toast.LENGTH_SHORT).show()
    }
  }

  fun copyToClipboard(label: String, text: String) {
    clipboardManager.setText(AnnotatedString(text))
    Toast.makeText(context, "$label කොපි කරගන්නා ලදී!", Toast.LENGTH_SHORT).show()
  }

  BackHandler {
    onBack()
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = "කාල 3 වාක්‍ය සංසන්දනය",
              fontSize = 17.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Text(
              text = "අතීත • වර්තමාන • අනාගත (වාක්‍ය 30 x කාණ්ඩ 30 = 900)",
              fontSize = 11.sp,
              color = Color.White.copy(alpha = 0.85f)
            )
          }
        },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = "Back",
              tint = Color.White
            )
          }
        },
        actions = {
          IconButton(onClick = { showCategorySelectorDialog = true }) {
            Icon(
              imageVector = Icons.Default.GridView,
              contentDescription = "All Categories",
              tint = Color.White
            )
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = Color(0xFF1E3A8A)
        )
      )
    }
  ) { paddingValues ->
    // Filtered sentences list
    val filteredSentences = remember(currentCategory, searchQuery, activeTenseFilter) {
      val baseList = if (searchQuery.isBlank()) {
        currentCategory.sentences
      } else {
        val q = searchQuery.trim().lowercase()
        currentCategory.sentences.filter { s ->
          s.baseActionSinhala.lowercase().contains(q) ||
            s.pastEnglish.lowercase().contains(q) ||
            s.pastSinhala.lowercase().contains(q) ||
            s.presentEnglish.lowercase().contains(q) ||
            s.presentSinhala.lowercase().contains(q) ||
            s.futureEnglish.lowercase().contains(q) ||
            s.futureSinhala.lowercase().contains(q) ||
            s.verbTransformation.lowercase().contains(q)
        }
      }

      // Apply tense filter
      if (activeTenseFilter == "ALL") baseList else baseList
    }

    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFF8FAFC))
        .padding(paddingValues),
      contentPadding = PaddingValues(bottom = 120.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      // 1. Top Navigation / Category horizontal chips, search bar & tense filters
      item {
        Surface(
          color = Color.White,
          shadowElevation = 2.dp,
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.fillMaxWidth()) {
            // Category horizontal scroll row
            LazyRow(
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
              contentPadding = PaddingValues(horizontal = 12.dp),
              horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              items(allCategories) { cat ->
                val isSelected = cat.id == selectedCategoryId
                FilterChip(
                  selected = isSelected,
                  onClick = {
                    selectedCategoryId = cat.id
                    searchQuery = ""
                  },
                  label = {
                    Text(
                      text = "${cat.icon} ${cat.id}. ${cat.titleEnglish}",
                      fontSize = 12.sp,
                      fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                  },
                  colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFF1E3A8A),
                    selectedLabelColor = Color.White,
                    containerColor = Color(0xFFF1F5F9),
                    labelColor = Color(0xFF334155)
                  ),
                  border = FilterChipDefaults.filterChipBorder(
                    enabled = true,
                    selected = isSelected,
                    borderColor = if (isSelected) Color(0xFF1E3A8A) else Color(0xFFE2E8F0)
                  )
                )
              }
            }

            // Search bar & Tense Filter Tabs
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 6.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("වාක්‍ය හෝ ක්‍රියාව සොයන්න...", fontSize = 13.sp) },
                leadingIcon = {
                  Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color(0xFF64748B),
                    modifier = Modifier.size(18.dp)
                  )
                },
                trailingIcon = {
                  if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { searchQuery = "" }) {
                      Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Clear",
                        modifier = Modifier.size(18.dp)
                      )
                    }
                  }
                },
                modifier = Modifier
                  .weight(1f)
                  .height(48.dp),
                shape = RoundedCornerShape(24.dp),
                colors = OutlinedTextFieldDefaults.colors(
                  focusedBorderColor = Color(0xFF1E3A8A),
                  unfocusedBorderColor = Color(0xFFCBD5E1),
                  focusedContainerColor = Color(0xFFF8FAFC),
                  unfocusedContainerColor = Color(0xFFF8FAFC)
                ),
                singleLine = true
              )

              Spacer(modifier = Modifier.width(8.dp))

              IconButton(
                onClick = { showCategorySelectorDialog = true },
                modifier = Modifier
                  .size(44.dp)
                  .background(Color(0xFFEEF2FF), CircleShape)
              ) {
                Icon(
                  imageVector = Icons.Default.List,
                  contentDescription = "Category List",
                  tint = Color(0xFF1E3A8A)
                )
              }
            }

            // Tense focus filter chips
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 12.dp, vertical = 4.dp),
              horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
              val filterOptions = listOf(
                "ALL" to "සියලු කාල 3 ම (All 3)",
                "PAST" to "🟠 අතීත කාලය (Past)",
                "PRESENT" to "🟢 වර්තමාන කාලය (Present)",
                "FUTURE" to "🔵 අනාගත කාලය (Future)"
              )

              filterOptions.forEach { (key, label) ->
                val isSelected = activeTenseFilter == key
                FilterChip(
                  selected = isSelected,
                  onClick = { activeTenseFilter = key },
                  label = { Text(label, fontSize = 11.sp) },
                  colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = when (key) {
                      "PAST" -> Color(0xFFD97706)
                      "PRESENT" -> Color(0xFF059669)
                      "FUTURE" -> Color(0xFF2563EB)
                      else -> Color(0xFF475569)
                    },
                    selectedLabelColor = Color.White
                  )
                )
              }
            }
          }
        }
      }

      // 2. Category Header Card
      item {
        Box(modifier = Modifier.padding(horizontal = 12.dp)) {
          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
              containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(2.dp),
            border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = currentCategory.icon,
                  fontSize = 32.sp,
                  modifier = Modifier
                    .background(Color(0xFFEEF2FF), RoundedCornerShape(12.dp))
                    .padding(8.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                  Text(
                    text = currentCategory.titleSinhala,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A)
                  )
                  Text(
                    text = currentCategory.titleEnglish,
                    fontSize = 13.sp,
                    color = Color(0xFF475569)
                  )
                }
                Surface(
                  shape = RoundedCornerShape(12.dp),
                  color = Color(0xFFDCFCE7)
                ) {
                  Text(
                    text = "${filteredSentences.size} / ${currentCategory.sentences.size}",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF166534),
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                  )
                }
              }

              Spacer(modifier = Modifier.height(10.dp))
              Text(
                text = currentCategory.description,
                fontSize = 12.sp,
                color = Color(0xFF64748B),
                lineHeight = 17.sp
              )
            }
          }
        }
      }

      // 3. Empty Search Result Notice
      if (filteredSentences.isEmpty()) {
        item {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .padding(32.dp),
            contentAlignment = Alignment.Center
          ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
              Text("🔍", fontSize = 40.sp)
              Spacer(modifier = Modifier.height(8.dp))
              Text(
                text = "'$searchQuery' සඳහා වාක්‍ය හමු නොවීය.",
                fontSize = 14.sp,
                color = Color(0xFF64748B)
              )
              TextButton(onClick = { searchQuery = "" }) {
                Text("සෙවුම ඉවත් කරන්න")
              }
            }
          }
        }
      }

      // 4. Sentence Cards
      itemsIndexed(
        items = filteredSentences,
        key = { index, sentence -> "${currentCategory.id}_${sentence.id}_$index" }
      ) { index, sentence ->
        Box(modifier = Modifier.padding(horizontal = 12.dp)) {
          TenseComparisonCard(
            itemNumber = index + 1,
            sentence = sentence,
            activeFilter = activeTenseFilter,
            onSpeak = { speak(it) },
            onCopy = { label, text -> copyToClipboard(label, text) }
          )
        }
      }

      // 5. Bottom space & stats
      item {
        Box(modifier = Modifier.padding(horizontal = 12.dp)) {
          Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F5F9)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
              Text(
                text = "✨ සම්පූර්ණ කාණ්ඩ 30න් ${currentCategory.id} වන කාණ්ඩය",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF475569)
              )
              Text(
                text = "මුළු වාක්‍ය සංසන්දන ගණන: 900 (කාල 3 ම එකවර)",
                fontSize = 11.sp,
                color = Color(0xFF64748B)
              )
            }
          }
        }
      }
    }
  }

  // Category Selector Modal Dialog
  if (showCategorySelectorDialog) {
    AlertDialog(
      onDismissRequest = { showCategorySelectorDialog = false },
      title = {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Icon(
            imageVector = Icons.Default.Category,
            contentDescription = null,
            tint = Color(0xFF1E3A8A)
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "කාණ්ඩය තෝරන්න (කාණ්ඩ 30)",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
          )
        }
      },
      text = {
        LazyColumn(
          modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 420.dp),
          verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          items(allCategories) { cat ->
            val isCurrent = cat.id == selectedCategoryId
            Surface(
              shape = RoundedCornerShape(10.dp),
              color = if (isCurrent) Color(0xFFEEF2FF) else Color(0xFFF8FAFC),
              border = BorderStroke(
                1.dp,
                if (isCurrent) Color(0xFF3B82F6) else Color(0xFFE2E8F0)
              ),
              modifier = Modifier
                .fillMaxWidth()
                .clickable {
                  selectedCategoryId = cat.id
                  showCategorySelectorDialog = false
                  searchQuery = ""
                }
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(text = cat.icon, fontSize = 22.sp)
                Spacer(modifier = Modifier.width(10.dp))
                Column(modifier = Modifier.weight(1f)) {
                  Text(
                    text = "${cat.id}. ${cat.titleSinhala.substringAfter(":")}",
                    fontSize = 13.sp,
                    fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.SemiBold,
                    color = if (isCurrent) Color(0xFF1E3A8A) else Color(0xFF1E293B)
                  )
                  Text(
                    text = "${cat.titleEnglish} • වාක්‍ය 30",
                    fontSize = 11.sp,
                    color = Color(0xFF64748B)
                  )
                }
                if (isCurrent) {
                  Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Selected",
                    tint = Color(0xFF2563EB),
                    modifier = Modifier.size(20.dp)
                  )
                }
              }
            }
          }
        }
      },
      confirmButton = {
        TextButton(onClick = { showCategorySelectorDialog = false }) {
          Text("වසන්න")
        }
      }
    )
  }
}

@Composable
fun TenseComparisonCard(
  itemNumber: Int,
  sentence: TenseSentenceItem,
  activeFilter: String,
  onSpeak: (String) -> Unit,
  onCopy: (String, String) -> Unit
) {
  Card(
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    elevation = CardDefaults.cardElevation(2.dp),
    border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
    modifier = Modifier.fillMaxWidth()
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(14.dp)
    ) {
      // Header: Item Number, Base Action, Verb Transformation pill
      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Surface(
          shape = CircleShape,
          color = Color(0xFF1E3A8A),
          modifier = Modifier.size(26.dp)
        ) {
          Box(contentAlignment = Alignment.Center) {
            Text(
              text = "$itemNumber",
              color = Color.White,
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold
            )
          }
        }

        Spacer(modifier = Modifier.width(8.dp))

        Text(
          text = sentence.baseActionSinhala,
          fontSize = 14.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFF0F172A),
          modifier = Modifier.weight(1f)
        )

        // Verb transformation badge
        if (sentence.verbTransformation.isNotBlank()) {
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFFFEF3C7)
          ) {
            Text(
              text = sentence.verbTransformation,
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF92400E),
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(12.dp))

      // 1. PAST TENSE BLOCK (Orange/Amber)
      if (activeFilter == "ALL" || activeFilter == "PAST") {
        TenseRowBox(
          tag = "අතීත කාලය (Past Tense)",
          tagColor = Color(0xFFD97706),
          bgColor = Color(0xFFFFFBEB),
          borderColor = Color(0xFFFDE68A),
          englishSentence = sentence.pastEnglish,
          sinhalaSentence = sentence.pastSinhala,
          onSpeak = { onSpeak(sentence.pastEnglish) },
          onCopy = { onCopy("අතීත කාල වාක්‍යය", sentence.pastEnglish) }
        )
        if (activeFilter == "ALL") Spacer(modifier = Modifier.height(8.dp))
      }

      // 2. PRESENT TENSE BLOCK (Emerald/Green)
      if (activeFilter == "ALL" || activeFilter == "PRESENT") {
        TenseRowBox(
          tag = "වර්තමාන කාලය (Present Tense)",
          tagColor = Color(0xFF059669),
          bgColor = Color(0xFFF0FDF4),
          borderColor = Color(0xFFBBF7D0),
          englishSentence = sentence.presentEnglish,
          sinhalaSentence = sentence.presentSinhala,
          onSpeak = { onSpeak(sentence.presentEnglish) },
          onCopy = { onCopy("වර්තමාන කාල වාක්‍යය", sentence.presentEnglish) }
        )
        if (activeFilter == "ALL") Spacer(modifier = Modifier.height(8.dp))
      }

      // 3. FUTURE TENSE BLOCK (Indigo/Blue)
      if (activeFilter == "ALL" || activeFilter == "FUTURE") {
        TenseRowBox(
          tag = "අනාගත කාලය (Future Tense)",
          tagColor = Color(0xFF2563EB),
          bgColor = Color(0xFFEFF6FF),
          borderColor = Color(0xFFBFDBFE),
          englishSentence = sentence.futureEnglish,
          sinhalaSentence = sentence.futureSinhala,
          onSpeak = { onSpeak(sentence.futureEnglish) },
          onCopy = { onCopy("අනාගත කාල වාක්‍යය", sentence.futureEnglish) }
        )
      }
    }
  }
}

@Composable
fun TenseRowBox(
  tag: String,
  tagColor: Color,
  bgColor: Color,
  borderColor: Color,
  englishSentence: String,
  sinhalaSentence: String,
  onSpeak: () -> Unit,
  onCopy: () -> Unit
) {
  Surface(
    shape = RoundedCornerShape(10.dp),
    color = bgColor,
    border = BorderStroke(1.dp, borderColor),
    modifier = Modifier.fillMaxWidth()
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = tag,
          fontSize = 11.sp,
          fontWeight = FontWeight.Bold,
          color = tagColor,
          modifier = Modifier.weight(1f)
        )

        // Speaker Button
        IconButton(
          onClick = onSpeak,
          modifier = Modifier.size(24.dp)
        ) {
          Icon(
            imageVector = Icons.AutoMirrored.Filled.VolumeUp,
            contentDescription = "Speak",
            tint = tagColor,
            modifier = Modifier.size(16.dp)
          )
        }

        Spacer(modifier = Modifier.width(4.dp))

        // Copy Button
        IconButton(
          onClick = onCopy,
          modifier = Modifier.size(24.dp)
        ) {
          Icon(
            imageVector = Icons.Default.ContentCopy,
            contentDescription = "Copy",
            tint = Color(0xFF64748B),
            modifier = Modifier.size(14.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(4.dp))

      // English Sentence
      Text(
        text = englishSentence,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color(0xFF0F172A),
        lineHeight = 19.sp
      )

      Spacer(modifier = Modifier.height(2.dp))

      // Sinhala Translation
      Text(
        text = sinhalaSentence,
        fontSize = 12.5.sp,
        color = Color(0xFF334155),
        lineHeight = 17.sp
      )
    }
  }
}
