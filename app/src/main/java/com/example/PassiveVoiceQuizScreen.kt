package com.example

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PassiveVoiceQuizScreen(
  onBack: () -> Unit
) {
  val allQuizItems = remember { PassiveVoiceQuizRepository.getQuizItems() }
  var selectedType by remember { mutableStateOf("ACTIVE") } // "ACTIVE" or "PASSIVE"

  val filteredItems = remember(allQuizItems, selectedType) {
    allQuizItems.filter { it.type == selectedType }
  }

  // User answers state: Map<ItemId, SelectedOptionIndex>
  val userSelections = remember(selectedType) { mutableStateMapOf<String, Int>() }

  var correctCount by remember(selectedType) { mutableIntStateOf(0) }
  var incorrectCount by remember(selectedType) { mutableIntStateOf(0) }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = "🎯 Active/Passive Voice පුහුණුව (500)",
              fontSize = 15.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Text(
              text = "හිස්තැන් පුරවා නිවැරදි වරණය තෝරන්න (तत्క్షణ ප්‍රතිචාර)",
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
      // 1. TOP STATS & TYPE SWITCHER (Active vs Passive)
      item {
        Card(
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.5f))
        ) {
          Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF064E3B),
                border = BorderStroke(1.dp, Color(0xFF10B981))
              ) {
                Text(
                  text = "✅ නිවැරදි: $correctCount",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF34D399),
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
              }
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF451A03),
                border = BorderStroke(1.dp, Color(0xFFD97706))
              ) {
                Text(
                  text = "❌ වැරදි: $incorrectCount",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFFFBBF24),
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
              }
            }

            // Switcher Tabs
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              Button(
                onClick = { selectedType = "ACTIVE" },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                  containerColor = if (selectedType == "ACTIVE") Color(0xFF0284C7) else Color(0xFF334155)
                ),
                modifier = Modifier.weight(1f)
              ) {
                Text("🟢 Active Voice (250)", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
              }

              Button(
                onClick = { selectedType = "PASSIVE" },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                  containerColor = if (selectedType == "PASSIVE") Color(0xFF10B981) else Color(0xFF334155)
                ),
                modifier = Modifier.weight(1f)
              ) {
                Text("🔵 Passive Voice (250)", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
              }
            }
          }
        }
      }

      // 2. QUIZ ITEMS LIST
      items(filteredItems) { quiz ->
        val selectedIndex = userSelections[quiz.id]
        val isAnswered = selectedIndex != null
        val isCorrect = isAnswered && selectedIndex == quiz.correctOptionIndex

        Card(
          shape = RoundedCornerShape(14.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(
            1.5.dp,
            when {
              !isAnswered -> Color(0xFF334155)
              isCorrect -> Color(0xFF10B981)
              else -> Color(0xFFEF4444)
            }
          ),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = quiz.id.uppercase(),
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF38BDF8)
              )
              if (isAnswered) {
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = if (isCorrect) Color(0xFF064E3B) else Color(0xFF7F1D1D)
                ) {
                  Text(
                    text = if (isCorrect) "නිවැරදියි! ✓" else "වැරදියි ✗",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                  )
                }
              }
            }

            // Sinhala Prompt
            Text(
              text = quiz.sinhalaPrompt,
              fontSize = 11.5.sp,
              fontWeight = FontWeight.Medium,
              color = Color(0xFFFBBF24)
            )

            // Sentence with blank
            Text(
              text = quiz.sentenceWithBlank,
              fontSize = 14.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )

            // 4 Options Grid/Column
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
              quiz.options.forEachIndexed { optIdx, optText ->
                val isThisSelected = selectedIndex == optIdx
                val isThisCorrect = optIdx == quiz.correctOptionIndex

                val btnColor = when {
                  !isAnswered -> Color(0xFF0F172A)
                  isThisCorrect -> Color(0xFF064E3B)
                  isThisSelected && !isThisCorrect -> Color(0xFF7F1D1D)
                  else -> Color(0xFF0F172A)
                }

                val borderColor = when {
                  !isAnswered -> Color(0xFF334155)
                  isThisCorrect -> Color(0xFF10B981)
                  isThisSelected && !isThisCorrect -> Color(0xFFEF4444)
                  else -> Color(0xFF334155)
                }

                Surface(
                  onClick = {
                    if (!isAnswered) {
                      userSelections[quiz.id] = optIdx
                      if (optIdx == quiz.correctOptionIndex) {
                        correctCount++
                      } else {
                        incorrectCount++
                      }
                    }
                  },
                  shape = RoundedCornerShape(10.dp),
                  color = btnColor,
                  border = BorderStroke(1.dp, borderColor),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(
                      text = "${('A' + optIdx)}. $optText",
                      fontSize = 12.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color.White
                    )
                  }
                }
              }
            }

            // Explanation if answered incorrectly
            if (isAnswered && !isCorrect) {
              Spacer(modifier = Modifier.height(2.dp))
              Text(
                text = quiz.explanation,
                fontSize = 11.sp,
                color = Color(0xFFFCA5A5)
              )
            }
          }
        }
      }
    }
  }
}
