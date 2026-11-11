package com.example

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReadingComprehensionScreen(
  onBack: () -> Unit
) {
  val passages = remember { ReadingComprehensionRepository.getPassages() }
  var searchQuery by remember { mutableStateOf("") }
  val expandedPassageIds = remember { mutableStateMapOf<String, Boolean>() }
  val showMeaningIds = remember { mutableStateMapOf<String, Boolean>() }

  val filteredPassages = remember(passages, searchQuery) {
    if (searchQuery.isBlank()) {
      passages
    } else {
      val q = searchQuery.trim().lowercase()
      passages.filter {
        it.title.lowercase().contains(q) ||
        it.topicSinhala.lowercase().contains(q) ||
        it.englishPassage.lowercase().contains(q)
      }
    }
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = "📖 Reading Comprehension (ඡේද 100)",
              fontSize = 15.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Text(
              text = "කියවීමේ අවබෝධය සහ ප්‍රශ්නෝත්තර පුහුණුව",
              fontSize = 10.sp,
              color = Color(0xFFBAE6FD)
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
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0F172A))
      )
    }
  ) { padding ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF0F172A))
        .padding(padding),
      contentPadding = PaddingValues(horizontal = 12.dp, vertical = 10.dp),
      verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
      // SEARCH BAR
      item {
        OutlinedTextField(
          value = searchQuery,
          onValueChange = { searchQuery = it },
          placeholder = { Text("ඡේදයක් හෝ මාතෘකාවක් සොයන්න...", fontSize = 12.sp, color = Color(0xFF94A3B8)) },
          leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color(0xFF38BDF8)) },
          trailingIcon = {
            if (searchQuery.isNotEmpty()) {
              IconButton(onClick = { searchQuery = "" }) {
                Icon(Icons.Default.Clear, contentDescription = "Clear", tint = Color(0xFF94A3B8))
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

      // PASSAGES LIST
      items(filteredPassages) { item ->
        val isExpanded = expandedPassageIds[item.id] == true
        val showMeaning = showMeaningIds[item.id] == true

        Card(
          shape = RoundedCornerShape(14.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFF334155)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Column(modifier = Modifier.weight(1f)) {
                Text(
                  text = item.title,
                  fontSize = 13.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF38BDF8)
                )
                Text(
                  text = item.topicSinhala,
                  fontSize = 11.sp,
                  color = Color(0xFF34D399)
                )
              }
              IconButton(onClick = { expandedPassageIds[item.id] = !isExpanded }) {
                Icon(
                  imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                  contentDescription = "Expand",
                  tint = Color(0xFF38BDF8)
                )
              }
            }

            // English Passage Text
            Text(
              text = item.englishPassage,
              fontSize = 12.5.sp,
              color = Color.White,
              lineHeight = 19.sp,
              maxLines = if (isExpanded) Int.MAX_VALUE else 3,
              overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
            )

            if (showMeaning) {
              Spacer(modifier = Modifier.height(2.dp))
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF0F172A),
                border = BorderStroke(1.dp, Color(0xFF334155))
              ) {
                Text(
                  text = "සිංහල අර්ථය: ${item.sinhalaMeaning}",
                  fontSize = 11.5.sp,
                  color = Color(0xFFFEF3C7),
                  modifier = Modifier.padding(10.dp)
                )
              }
            }

            if (isExpanded) {
              HorizontalDivider(color = Color(0xFF334155))
              Text(
                text = "💡 අවබෝධතා ප්‍රශ්න (Comprehension Questions):",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFBBF24)
              )
              item.questions.forEachIndexed { qIdx, q ->
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                  Text(
                    text = "${qIdx + 1}. ${q.questionText}",
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                  )
                  Text(
                    text = "   සිංහලෙන්: ${q.sinhalaPrompt}",
                    fontSize = 11.sp,
                    color = Color(0xFF94A3B8)
                  )
                  Text(
                    text = "   පිළිතුර: ${q.answer}",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF34D399)
                  )
                }
              }
            }

            // Bottom Buttons
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.End,
              verticalAlignment = Alignment.CenterVertically
            ) {
              TextButton(onClick = { showMeaningIds[item.id] = !showMeaning }) {
                Text(
                  text = if (showMeaning) "අර්ථය සඟවන්න" else "සිංහල අර්ථය බලන්න",
                  fontSize = 11.sp,
                  color = Color(0xFF38BDF8)
                )
              }
            }
          }
        }
      }
    }
  }
}
