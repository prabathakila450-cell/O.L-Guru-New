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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PassiveVoiceMasterScreen(
  onBack: () -> Unit
) {
  val categories = remember { PassiveVoiceMasterRepository.getCategories() }
  var selectedCategoryId by remember { mutableIntStateOf(1) }
  var searchQuery by remember { mutableStateOf("") }
  var showTheoryGuide by remember { mutableStateOf(true) }

  val currentCategory = categories.find { it.id == selectedCategoryId } ?: categories.first()

  val filteredItems = remember(currentCategory, searchQuery) {
    if (searchQuery.isBlank()) {
      currentCategory.items
    } else {
      val q = searchQuery.trim().lowercase()
      currentCategory.items.filter {
        it.active.lowercase().contains(q) ||
        it.passive.lowercase().contains(q) ||
        it.sinhalaMeaning.lowercase().contains(q)
      }
    }
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = "🔄 Passive Voice Master (වාක්‍ය 500)",
              fontSize = 15.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Text(
              text = "Active සිට Passive වෙත මාරු කිරීමේ නීති සහ වාක්‍ය 500ක්",
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
      // 1. THEORY GUIDE CARD
      item {
        Card(
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.5f))
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
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text("📚", fontSize = 18.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                  text = "Passive Voice හැඳින්වීම සහ රීති (Rules)",
                  fontSize = 13.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )
              }
              IconButton(onClick = { showTheoryGuide = !showTheoryGuide }) {
                Icon(
                  imageVector = if (showTheoryGuide) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                  contentDescription = "Toggle",
                  tint = Color(0xFF38BDF8)
                )
              }
            }

            if (showTheoryGuide) {
              HorizontalDivider(color = Color(0xFF334155))
              Text(
                text = "1. Active Voice (කර්තෘකාරක): වාක්‍යයක මුලින්ම කර්තෘවරයා (Subject) ක්‍රියාව සිදු කරන අයුරු දැක්වේ.\n   උදා: I write a letter. (මම ලියුමක් ලියමි)\n\n2. Passive Voice (कर्मකාරක / කර්මප්‍රධාන): ක්‍රියාව ලබන වස්තුව (Object) වාක්‍යයේ මුලට ගෙන ලියනු ලැබේ.\n   උදා: A letter is written by me. (මගින් ලියුමක් ලියනු ලැබේ)\n\nප්‍රධාන පියවර:\n• Object එක Subject එකක් ලෙස ඉදිරියට ගැනීම.\n• කාලයට (Tense) අදාළව Be ක්‍රියාපදයක් (am/is/are/was/were/will be/has been) යෙදීම.\n• ප්‍රධාන ක්‍රියාපදයේ 3 වන අවස්ථාව (V3) භාවිත කිරීම.\n• by මඟින් මුල් කර්තෘ අවසානයට දැමීම.",
                fontSize = 11.5.sp,
                color = Color(0xFFCBD5E1),
                lineHeight = 18.sp
              )
            }
          }
        }
      }

      // 2. SEARCH BAR
      item {
        OutlinedTextField(
          value = searchQuery,
          onValueChange = { searchQuery = it },
          placeholder = { Text("වාක්‍යයක් හෝ සිංහල අර්ථයක් සොයන්න...", fontSize = 12.sp, color = Color(0xFF94A3B8)) },
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

      // 3. CATEGORY SELECTION CHips (10 Categories)
      item {
        androidx.compose.foundation.lazy.LazyRow(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          items(categories) { cat ->
            val isSelected = cat.id == selectedCategoryId
            Surface(
              onClick = { selectedCategoryId = cat.id },
              shape = RoundedCornerShape(10.dp),
              color = if (isSelected) Color(0xFF0284C7) else Color(0xFF1E293B),
              border = BorderStroke(1.dp, if (isSelected) Color(0xFF38BDF8) else Color(0xFF334155))
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 7.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(cat.icon, fontSize = 12.sp)
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                  text = cat.titleSinhala.substringBefore(" ("),
                  fontSize = 11.sp,
                  fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                  color = Color.White
                )
              }
            }
          }
        }
      }

      // Category Header info
      item {
        Surface(
          shape = RoundedCornerShape(10.dp),
          color = Color(0xFF1E293B).copy(alpha = 0.7f),
          border = BorderStroke(1.dp, Color(0xFF334155)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(10.dp)) {
            Text(
              text = currentCategory.titleSinhala,
              fontSize = 12.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF34D399)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
              text = currentCategory.description,
              fontSize = 11.sp,
              color = Color(0xFF94A3B8)
            )
          }
        }
      }

      // 4. SENTENCE ITEMS LIST (50 sentences per category)
      items(filteredItems) { item ->
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFF334155)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Surface(
                shape = RoundedCornerShape(6.dp),
                color = Color(0xFF0F172A),
                border = BorderStroke(1.dp, Color(0xFF334155))
              ) {
                Text(
                  text = "Rule: ${item.tenseOrRule}",
                  fontSize = 9.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF38BDF8),
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }
              Text(
                text = item.id.uppercase(),
                fontSize = 9.sp,
                color = Color(0xFF64748B)
              )
            }

            // Active Sentence
            Row(verticalAlignment = Alignment.Top) {
              Text("🔹 Active: ", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF94A3B8))
              Text(item.active, fontSize = 12.5.sp, fontWeight = FontWeight.Medium, color = Color.White)
            }

            // Passive Sentence
            Row(verticalAlignment = Alignment.Top) {
              Text("🔸 Passive: ", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF34D399))
              Text(item.passive, fontSize = 12.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF34D399))
            }

            // Sinhala Meaning
            Row(verticalAlignment = Alignment.Top) {
              Text("💡 අර්ථය: ", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFBBF24))
              Text(item.sinhalaMeaning, fontSize = 11.5.sp, color = Color(0xFFFEF3C7))
            }
          }
        }
      }
    }
  }
}
