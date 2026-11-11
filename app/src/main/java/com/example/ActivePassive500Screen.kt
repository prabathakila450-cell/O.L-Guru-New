package com.example

import androidx.activity.compose.BackHandler
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivePassive500Screen(
  onBack: () -> Unit
) {
  val context = LocalContext.current
  val clipboardManager = LocalClipboardManager.current
  BackHandler(enabled = true) { onBack() }

  val categories = remember { ActivePassive500Repository.getAllCategories() }
  var selectedCatId by remember { mutableIntStateOf(1) }
  var searchQuery by remember { mutableStateOf("") }

  val currentCategory = categories.find { it.categoryId == selectedCatId } ?: categories[0]

  val filteredItems = remember(currentCategory, searchQuery) {
    if (searchQuery.isBlank()) {
      currentCategory.items
    } else {
      val q = searchQuery.trim().lowercase()
      currentCategory.items.filter {
        it.activeSentence.lowercase().contains(q) ||
          it.passiveSentence.lowercase().contains(q) ||
          it.activeSinhala.lowercase().contains(q) ||
          it.passiveSinhala.lowercase().contains(q)
      }
    }
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text("Active & Passive 500 Practice", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text("කාණ්ඩ 20ක් යටතේ අද්විතීය වාක්‍ය 500ක් (සිංහල තේරුම් සමඟ)", fontSize = 11.sp, color = Color(0xFFE0F2FE))
          }
        },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0369A1))
      )
    }
  ) { paddingValues ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
        .background(Color(0xFFF8FAFC))
    ) {
      // Category Selector Horizontal Chips / Dropdown bar
      Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shadowElevation = 2.dp
      ) {
        Column(modifier = Modifier.padding(10.dp)) {
          Text("📚 විෂය කාණ්ඩය තෝරන්න (Select Category 1 - 20):", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0F172A))
          Spacer(modifier = Modifier.height(6.dp))
          
          androidx.compose.foundation.lazy.LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            items(categories) { cat ->
              val isSelected = cat.categoryId == selectedCatId
              FilterChip(
                selected = isSelected,
                onClick = { selectedCatId = cat.categoryId },
                label = {
                  Text(
                    text = cat.title,
                    fontSize = 11.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                  )
                },
                colors = FilterChipDefaults.filterChipColors(
                  selectedContainerColor = Color(0xFF0284C7),
                  selectedLabelColor = Color.White,
                  containerColor = Color(0xFFF1F5F9),
                  labelColor = Color(0xFF334155)
                )
              )
            }
          }

          Spacer(modifier = Modifier.height(8.dp))

          OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("සෙවුම් පදය ඇතුළත් කරන්න (Search sentences)...", fontSize = 12.sp) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF0284C7)) },
            trailingIcon = {
              if (searchQuery.isNotBlank()) {
                IconButton(onClick = { searchQuery = "" }) {
                  Icon(Icons.Default.Clear, contentDescription = "Clear", tint = Color.Gray)
                }
              }
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
              focusedBorderColor = Color(0xFF0284C7),
              unfocusedBorderColor = Color(0xFFCBD5E1)
            )
          )
        }
      }

      // Active / Passive List (Full screen vertical scrollable)
      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
          .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        item {
          Surface(
            shape = RoundedCornerShape(10.dp),
            color = Color(0xFFE0F2FE),
            border = BorderStroke(1.dp, Color(0xFFBAE6FD)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(12.dp)) {
              Text(text = currentCategory.title, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0369A1))
              Spacer(modifier = Modifier.height(2.dp))
              Text(text = currentCategory.subtitle, fontSize = 12.sp, color = Color(0xFF0284C7))
              Spacer(modifier = Modifier.height(4.dp))
              Text(text = "මෙම කාණ්ඩය යටතේ ඇති වාක්‍ය සංඛ්‍යාව: ${filteredItems.size}", fontSize = 11.sp, color = Color(0xFF334155))
            }
          }
        }

        items(filteredItems) { item ->
          Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
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
                  text = "ID: ${item.id.uppercase()}",
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF64748B)
                )
                IconButton(
                  onClick = {
                    val txt = "Active: ${item.activeSentence}\nSinhala: ${item.activeSinhala}\nPassive: ${item.passiveSentence}\nSinhala: ${item.passiveSinhala}"
                    clipboardManager.setText(AnnotatedString(txt))
                    Toast.makeText(context, "පිටපත් කරගන්න ලදී (Copied)", Toast.LENGTH_SHORT).show()
                  },
                  modifier = Modifier.size(24.dp)
                ) {
                  Icon(Icons.Default.ContentCopy, contentDescription = "Copy", tint = Color(0xFF0284C7), modifier = Modifier.size(15.dp))
                }
              }

              Spacer(modifier = Modifier.height(6.dp))

              // Active Section
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFF0FDF4),
                border = BorderStroke(1.dp, Color(0xFFBBF7D0)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(10.dp)) {
                  Text("🟢 Active Voice (කර්තෘකාරකය):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF166534))
                  Spacer(modifier = Modifier.height(2.dp))
                  Text(text = item.activeSentence, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF14532D))
                  Spacer(modifier = Modifier.height(2.dp))
                  Text(text = "සිංහල තේරුම: ${item.activeSinhala}", fontSize = 11.sp, color = Color(0xFF166534))
                }
              }

              Spacer(modifier = Modifier.height(8.dp))

              // Passive Section
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFFEF2F2),
                border = BorderStroke(1.dp, Color(0xFFFECACA)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(10.dp)) {
                  Text("🔴 Passive Voice (කර්මකාරකය):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF991B1B))
                  Spacer(modifier = Modifier.height(2.dp))
                  Text(text = item.passiveSentence, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF7F1D1D))
                  Spacer(modifier = Modifier.height(2.dp))
                  Text(text = "සිංහල තේරුම: ${item.passiveSinhala}", fontSize = 11.sp, color = Color(0xFF991B1B))
                }
              }

              Spacer(modifier = Modifier.height(6.dp))
              Text(
                text = "💡 රීතිය (Rule): ${item.ruleNote}",
                fontSize = 10.sp,
                color = Color(0xFF475569),
                fontWeight = FontWeight.Medium
              )
            }
          }
        }
      }
    }
  }
}
