package com.example

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FormatSize
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.UnfoldMore
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

enum class ScienceReaderTheme(
  val labelSinhala: String,
  val backgroundColor: Color,
  val contentColor: Color,
  val cardBackground: Color,
  val accentColor: Color,
  val highlightColor: Color
) {
  LIGHT("දිවා මාදිලිය", Color(0xFFF8FAFC), Color(0xFF0F172A), Color.White, Color(0xFF0284C7), Color(0xFFE0F2FE)),
  SEPIA("පොත් පිටු (Sepia)", Color(0xFFFAF5EF), Color(0xFF3E2723), Color(0xFFFFFDF9), Color(0xFFB45309), Color(0xFFFEF3C7)),
  DARK("රාත්‍රී මාදිලිය", Color(0xFF090D16), Color(0xFFF1F5F9), Color(0xFF131B2E), Color(0xFF38BDF8), Color(0xFF1E293B)),
  EMERALD("හරිත මාදිලිය", Color(0xFF064E3B), Color(0xFFECFDF5), Color(0xFF065F46), Color(0xFF34D399), Color(0xFF047857))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScienceDiagramsPdfReaderDialog(
  initialPage: Int = 1,
  onDismiss: () -> Unit
) {
  var currentPageNumber by remember { mutableIntStateOf(initialPage.coerceIn(1, 11)) }
  var readerTheme by remember { mutableStateOf(ScienceReaderTheme.LIGHT) }
  var fontSizeMultiplier by remember { mutableFloatStateOf(1.0f) }
  var showJumpDialog by remember { mutableStateOf(false) }
  var showThemeDialog by remember { mutableStateOf(false) }
  var isSearchMode by remember { mutableStateOf(false) }
  var searchQuery by remember { mutableStateOf("") }
  val bookmarks = remember { mutableStateListOf<Int>() }

  val currentPage = remember(currentPageNumber) {
    ScienceDiagramsPdfBookletRepository.getPage(currentPageNumber)
  }

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(
      usePlatformDefaultWidth = false,
      securePolicy = AppSecurityManager.getSecureFlagPolicy()
    )
  ) {
    DisableSelection {
      Surface(
        modifier = Modifier
          .fillMaxSize()
          .testTag("science_diagrams_pdf_reader_dialog"),
        color = readerTheme.backgroundColor
      ) {
      Column(modifier = Modifier.fillMaxSize()) {

        // =========================================================================================
        // 1. TOP HEADER BAR
        // =========================================================================================
        Surface(
          color = Color(0xFF0F172A), // Dark Navy Blue
          shadowElevation = 4.dp,
          modifier = Modifier.fillMaxWidth()
        ) {
          Column {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 6.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
              ) {
                IconButton(onClick = onDismiss, modifier = Modifier.size(36.dp)) {
                  Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = Color.White
                  )
                }
                Spacer(modifier = Modifier.width(6.dp))
                Column {
                  Text(
                    text = "10/11 විද්‍යාව • ප්‍රධාන රූ සටහන්",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                  Text(
                    text = "සෛලීය ව්‍යුහයන් හා ශාක පටක (පිටු 11 PDF)",
                    color = Color(0xFFBAE6FD),
                    fontSize = 10.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                }
              }

              Row(verticalAlignment = Alignment.CenterVertically) {
                // Search Toggle
                IconButton(
                  onClick = { isSearchMode = !isSearchMode },
                  modifier = Modifier.size(36.dp)
                ) {
                  Icon(
                    imageVector = if (isSearchMode) Icons.Default.Close else Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.White
                  )
                }

                // Bookmark toggle
                IconButton(
                  onClick = {
                    if (bookmarks.contains(currentPageNumber)) {
                      bookmarks.remove(currentPageNumber)
                    } else {
                      bookmarks.add(currentPageNumber)
                    }
                  },
                  modifier = Modifier.size(36.dp)
                ) {
                  Icon(
                    imageVector = if (bookmarks.contains(currentPageNumber)) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                    contentDescription = "Bookmark",
                    tint = if (bookmarks.contains(currentPageNumber)) Color(0xFFFDE047) else Color.White
                  )
                }

                // Font size modifier
                IconButton(
                  onClick = {
                    fontSizeMultiplier = when (fontSizeMultiplier) {
                      0.9f -> 1.0f
                      1.0f -> 1.15f
                      1.15f -> 1.3f
                      else -> 0.9f
                    }
                  },
                  modifier = Modifier.size(36.dp)
                ) {
                  Icon(
                    imageVector = Icons.Default.FormatSize,
                    contentDescription = "Font size",
                    tint = Color.White
                  )
                }

                // Theme picker
                IconButton(
                  onClick = { showThemeDialog = true },
                  modifier = Modifier.size(36.dp)
                ) {
                  Icon(
                    imageVector = Icons.Default.Palette,
                    contentDescription = "Theme",
                    tint = Color.White
                  )
                }
              }
            }

            // Search bar (if search is open)
            AnimatedVisibility(visible = isSearchMode) {
              OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("අවයවික, සෛල, පටක නාම සොයන්න...", fontSize = 12.sp, color = Color.White.copy(alpha = 0.7f)) },
                colors = OutlinedTextFieldDefaults.colors(
                  focusedBorderColor = Color(0xFF38BDF8),
                  unfocusedBorderColor = Color.White.copy(alpha = 0.4f),
                  focusedTextColor = Color.White,
                  unfocusedTextColor = Color.White
                ),
                singleLine = true,
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 12.dp, vertical = 6.dp)
              )
            }
          }
        }

        // =========================================================================================
        // 🔴 MANDATORY USER INSTRUCTION: PROMINENT RED PAGE NAVIGATION BAR AT THE VERY TOP
        // =========================================================================================
        Surface(
          color = Color(0xFFDC2626), // Clear Bold Red
          shadowElevation = 4.dp,
          modifier = Modifier
            .fillMaxWidth()
            .testTag("science_reader_top_page_nav")
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            // Previous Page Button
            FilledTonalButton(
              onClick = { if (currentPageNumber > 1) currentPageNumber-- },
              enabled = currentPageNumber > 1,
              shape = RoundedCornerShape(8.dp),
              colors = ButtonDefaults.filledTonalButtonColors(
                containerColor = Color(0xFF7F1D1D),
                contentColor = Color.White,
                disabledContainerColor = Color.White.copy(alpha = 0.2f),
                disabledContentColor = Color.White.copy(alpha = 0.4f)
              ),
              contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
              modifier = Modifier.height(36.dp)
            ) {
              Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Previous", modifier = Modifier.size(15.dp))
              Spacer(modifier = Modifier.width(4.dp))
              Text("පෙර පිටුව", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
            }

            // Current Page Selector (Click to Jump)
            Surface(
              onClick = { showJumpDialog = true },
              shape = RoundedCornerShape(8.dp),
              color = Color.White,
              border = BorderStroke(1.dp, Color(0xFFFCA5A5)),
              modifier = Modifier.height(36.dp)
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 12.dp)
              ) {
                Text(
                  text = "පිටුව ${currentPageNumber} / 11",
                  fontSize = 12.sp,
                  fontWeight = FontWeight.ExtraBold,
                  color = Color(0xFF991B1B)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                  imageVector = Icons.Default.UnfoldMore,
                  contentDescription = "Jump",
                  tint = Color(0xFF991B1B),
                  modifier = Modifier.size(16.dp)
                )
              }
            }

            // Next Page Button (Bold High Contrast)
            Button(
              onClick = { if (currentPageNumber < 11) currentPageNumber++ },
              enabled = currentPageNumber < 11,
              shape = RoundedCornerShape(8.dp),
              colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF7F1D1D),
                contentColor = Color.White,
                disabledContainerColor = Color.White.copy(alpha = 0.2f),
                disabledContentColor = Color.White.copy(alpha = 0.4f)
              ),
              contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
              modifier = Modifier.height(36.dp)
            ) {
              Text("ඊළඟ පිටුව", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
              Spacer(modifier = Modifier.width(4.dp))
              Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Next", modifier = Modifier.size(15.dp))
            }
          }
        }

        // =========================================================================================
        // 2. MAIN SCROLLABLE CONTENT (Full vertical scroll without obstruction)
        // =========================================================================================
        LazyColumn(
          modifier = Modifier
            .fillMaxSize()
            .weight(1f)
            .padding(horizontal = 12.dp, vertical = 8.dp),
          verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

          // Page Header Card
          item {
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = readerTheme.cardBackground),
              border = BorderStroke(1.dp, readerTheme.accentColor.copy(alpha = 0.3f)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(14.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Surface(
                    color = readerTheme.highlightColor,
                    shape = RoundedCornerShape(6.dp)
                  ) {
                    Text(
                      text = currentPage.categorySinhala,
                      color = readerTheme.accentColor,
                      fontSize = 10.sp * fontSizeMultiplier,
                      fontWeight = FontWeight.Bold,
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                  }
                  Text(
                    text = "රූ සටහන 0${currentPage.pageNumber} / 11",
                    color = Color.Gray,
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold
                  )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                  text = currentPage.titleSinhala,
                  fontSize = 18.sp * fontSizeMultiplier,
                  fontWeight = FontWeight.ExtraBold,
                  color = readerTheme.contentColor
                )

                Text(
                  text = currentPage.subtitleSinhala,
                  fontSize = 12.sp * fontSizeMultiplier,
                  color = Color.Gray,
                  fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                  text = "📚 විෂය නිර්දේශ ඒකකය: ${currentPage.syllabusUnit}",
                  fontSize = 11.sp * fontSizeMultiplier,
                  color = readerTheme.accentColor,
                  fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                  text = currentPage.overviewText,
                  fontSize = 12.5.sp * fontSizeMultiplier,
                  color = readerTheme.contentColor.copy(alpha = 0.9f),
                  lineHeight = 18.sp * fontSizeMultiplier
                )
              }
            }
          }

          // 🎨 Custom Visual Diagram Illustration Area
          item {
            Card(
              shape = RoundedCornerShape(14.dp),
              colors = CardDefaults.cardColors(containerColor = readerTheme.cardBackground),
              border = BorderStroke(1.5.dp, readerTheme.accentColor.copy(alpha = 0.4f)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(
                modifier = Modifier.padding(14.dp),
                horizontalAlignment = Alignment.CenterHorizontally
              ) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(
                    text = "🎨 රූ සටහන සහ ප්‍රධාන ලක්ෂණ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp * fontSizeMultiplier,
                    color = readerTheme.accentColor
                  )
                  Surface(
                    color = Color(0xFFDC2626),
                    shape = RoundedCornerShape(4.dp)
                  ) {
                    Text(
                      text = "HD DIAGRAM",
                      color = Color.White,
                      fontSize = 8.5.sp,
                      fontWeight = FontWeight.ExtraBold,
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                  }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Render Visual Diagram Canvas
                Box(
                  modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                      if (readerTheme == ScienceReaderTheme.DARK) Color(0xFF0F172A)
                      else if (readerTheme == ScienceReaderTheme.EMERALD) Color(0xFF064E3B)
                      else Color(0xFFF1F5F9)
                    ),
                  contentAlignment = Alignment.Center
                ) {
                  ScienceDiagramCanvas(
                    diagramType = currentPage.visualVectorType,
                    accentColor = readerTheme.accentColor
                  )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                  text = "පහත ලේබල් ලැයිස්තුව මගින් සෑම කොටසකම කාර්යය හා විභාග ලකුණු ලබාදීමේ නිර්ණායක සවිස්තරව දක්වා ඇත.",
                  fontSize = 11.sp * fontSizeMultiplier,
                  color = Color.Gray,
                  textAlign = TextAlign.Center
                )
              }
            }
          }

          // Key Characteristics Section
          item {
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = readerTheme.cardBackground),
              border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.3f)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(14.dp)) {
                Text(
                  text = "⭐ ප්‍රධාන හඳුනාගැනීමේ ලක්ෂණ:",
                  fontWeight = FontWeight.Bold,
                  fontSize = 13.sp * fontSizeMultiplier,
                  color = Color(0xFF0284C7)
                )
                Spacer(modifier = Modifier.height(8.dp))
                currentPage.keyCharacteristics.forEach { charPoint ->
                  Row(modifier = Modifier.padding(vertical = 3.dp)) {
                    Text("✔ ", color = Color(0xFF10B981), fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    Text(
                      text = charPoint,
                      fontSize = 12.sp * fontSizeMultiplier,
                      color = readerTheme.contentColor,
                      lineHeight = 17.sp * fontSizeMultiplier
                    )
                  }
                }
              }
            }
          }

          // Organelle / Parts Labels Section Header
          item {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = "📋 නම් කරන ලද කොටස් සහ කාර්යයන් (${currentPage.organelleLabels.size}):",
                fontWeight = FontWeight.Bold,
                fontSize = 13.5.sp * fontSizeMultiplier,
                color = readerTheme.contentColor
              )
              Surface(
                color = Color(0xFF0D9488).copy(alpha = 0.15f),
                shape = RoundedCornerShape(6.dp)
              ) {
                Text(
                  text = "O/L SYLLABUS",
                  color = Color(0xFF0D9488),
                  fontSize = 9.sp,
                  fontWeight = FontWeight.Bold,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }
            }
          }

          // Organelle Labels Cards List
          val filteredLabels = if (searchQuery.isBlank()) {
            currentPage.organelleLabels
          } else {
            currentPage.organelleLabels.filter {
              it.labelSinhala.contains(searchQuery, ignoreCase = true) ||
              it.labelEnglish.contains(searchQuery, ignoreCase = true) ||
              it.functionSinhala.contains(searchQuery, ignoreCase = true)
            }
          }

          items(filteredLabels) { organelle ->
            Card(
              shape = RoundedCornerShape(10.dp),
              colors = CardDefaults.cardColors(containerColor = readerTheme.cardBackground),
              border = BorderStroke(1.dp, readerTheme.accentColor.copy(alpha = 0.25f)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(
                    text = organelle.labelSinhala,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.5.sp * fontSizeMultiplier,
                    color = readerTheme.accentColor
                  )
                  Text(
                    text = organelle.labelEnglish,
                    fontSize = 11.sp * fontSizeMultiplier,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium
                  )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                  text = "කාර්යය: ${organelle.functionSinhala}",
                  fontSize = 12.sp * fontSizeMultiplier,
                  color = readerTheme.contentColor,
                  lineHeight = 17.sp * fontSizeMultiplier
                )

                Spacer(modifier = Modifier.height(4.dp))

                Surface(
                  color = readerTheme.highlightColor,
                  shape = RoundedCornerShape(6.dp)
                ) {
                  Text(
                    text = "💡 O/L සටහන: ${organelle.examHighlight}",
                    fontSize = 10.5.sp * fontSizeMultiplier,
                    color = readerTheme.accentColor,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                  )
                }
              }
            }
          }

          // Exam Tips Card
          item {
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFF064E3B)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(14.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text("💡", fontSize = 16.sp)
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = "විභාග ලකුණු ලබාගැනීමේ උපක්‍රම (O/L Exam Tips):",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp * fontSizeMultiplier,
                    color = Color(0xFFA7F3D0)
                  )
                }
                Spacer(modifier = Modifier.height(8.dp))
                currentPage.examTips.forEach { tip ->
                  Row(modifier = Modifier.padding(vertical = 3.dp)) {
                    Text("• ", color = Color(0xFF34D399), fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    Text(
                      text = tip,
                      fontSize = 11.5.sp * fontSizeMultiplier,
                      color = Color.White,
                      lineHeight = 16.sp * fontSizeMultiplier
                    )
                  }
                }
              }
            }
          }

          // Common Mistakes Card
          item {
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFF7F1D1D)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(14.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text("⚠️", fontSize = 16.sp)
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = "නිතර සිදුවන විභාග වැරදි (Avoid These Mistakes):",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp * fontSizeMultiplier,
                    color = Color(0xFFFECACA)
                  )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                  text = currentPage.commonMistakes,
                  fontSize = 11.5.sp * fontSizeMultiplier,
                  color = Color.White,
                  lineHeight = 16.sp * fontSizeMultiplier
                )
              }
            }
          }

          // Bottom Quick Navigation Strip
          item {
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = readerTheme.cardBackground),
              border = BorderStroke(1.dp, readerTheme.accentColor.copy(alpha = 0.3f)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Text(
                  text = "📑 අනෙකුත් රූ සටහන් වෙත ඉක්මනින් මාරුවන්න:",
                  fontWeight = FontWeight.Bold,
                  fontSize = 12.sp * fontSizeMultiplier,
                  color = readerTheme.contentColor
                )
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                  items(ScienceDiagramsPdfBookletRepository.pages) { pg ->
                    val isCurr = pg.pageNumber == currentPageNumber
                    FilterChip(
                      selected = isCurr,
                      onClick = { currentPageNumber = pg.pageNumber },
                      label = { Text("0${pg.pageNumber}. ${pg.titleSinhala.take(16)}...", fontSize = 10.5.sp) },
                      colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0xFFDC2626),
                        selectedLabelColor = Color.White
                      )
                    )
                  }
                }
              }
            }
          }

          item {
            Spacer(modifier = Modifier.height(30.dp))
          }
        }
      }
    }
  }
}

  // Jump to Page Dialog
  if (showJumpDialog) {
    Dialog(onDismissRequest = { showJumpDialog = false }) {
      Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp)
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "පිටුවක් තෝරන්න (1 - 11)",
              fontWeight = FontWeight.Bold,
              fontSize = 14.sp,
              color = Color.White
            )
            IconButton(onClick = { showJumpDialog = false }, modifier = Modifier.size(28.dp)) {
              Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White)
            }
          }
          Spacer(modifier = Modifier.height(10.dp))

          LazyColumn(
            modifier = Modifier.height(300.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            items(ScienceDiagramsPdfBookletRepository.pages) { pg ->
              val isSelected = pg.pageNumber == currentPageNumber
              Surface(
                onClick = {
                  currentPageNumber = pg.pageNumber
                  showJumpDialog = false
                },
                shape = RoundedCornerShape(8.dp),
                color = if (isSelected) Color(0xFFDC2626) else Color.White.copy(alpha = 0.08f),
                border = BorderStroke(1.dp, if (isSelected) Color(0xFFDC2626) else Color.White.copy(alpha = 0.15f)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(
                    text = "0${pg.pageNumber}",
                    fontWeight = FontWeight.ExtraBold,
                    color = if (isSelected) Color.White else Color(0xFF38BDF8),
                    fontSize = 13.sp
                  )
                  Spacer(modifier = Modifier.width(10.dp))
                  Column {
                    Text(
                      text = pg.titleSinhala,
                      fontWeight = FontWeight.Bold,
                      color = Color.White,
                      fontSize = 12.sp
                    )
                    Text(
                      text = pg.subtitleSinhala,
                      color = Color(0xFF94A3B8),
                      fontSize = 10.sp
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

  // Theme Picker Dialog
  if (showThemeDialog) {
    Dialog(onDismissRequest = { showThemeDialog = false }) {
      Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp)
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Text(
            text = "🎨 කියවීමේ තේමාව තෝරන්න:",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color.White
          )
          Spacer(modifier = Modifier.height(12.dp))

          ScienceReaderTheme.values().forEach { thm ->
            val isSelected = readerTheme == thm
            Surface(
              onClick = {
                readerTheme = thm
                showThemeDialog = false
              },
              shape = RoundedCornerShape(10.dp),
              color = thm.backgroundColor,
              border = BorderStroke(2.dp, if (isSelected) Color(0xFF38BDF8) else Color.Transparent),
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Text(
                  text = thm.labelSinhala,
                  color = thm.contentColor,
                  fontWeight = FontWeight.Bold,
                  fontSize = 12.5.sp
                )
                if (isSelected) {
                  Icon(Icons.Default.Check, contentDescription = "Selected", tint = Color(0xFF0284C7))
                }
              }
            }
          }
        }
      }
    }
  }
}

/**
 * 🎨 Vector Illustrations for each Science Biology Diagram
 */
@Composable
fun ScienceDiagramCanvas(
  diagramType: String,
  accentColor: Color
) {
  Canvas(modifier = Modifier.fillMaxSize()) {
    val canvasWidth = size.width
    val canvasHeight = size.height
    val centerX = canvasWidth / 2f
    val centerY = canvasHeight / 2f

    when (diagramType) {
      "animal_cell" -> drawAnimalCellDiagram(centerX, centerY, accentColor)
      "plant_cell" -> drawPlantCellDiagram(centerX, centerY, accentColor)
      "fungal_cell" -> drawFungalCellDiagram(centerX, centerY, accentColor)
      "bacterial_cell" -> drawBacterialCellDiagram(centerX, centerY, accentColor)
      "virus" -> drawVirusDiagram(centerX, centerY, accentColor)
      "protozoa_paramecium" -> drawParameciumDiagram(centerX, centerY, accentColor)
      "algae_chlamydomonas" -> drawChlamydomonasDiagram(centerX, centerY, accentColor)
      "palisade_cell" -> drawPalisadeCellDiagram(centerX, centerY, accentColor)
      "dicot_stem" -> drawDicotStemDiagram(centerX, centerY, accentColor)
      "monocot_stem" -> drawMonocotStemDiagram(centerX, centerY, accentColor)
      "dicot_root" -> drawDicotRootDiagram(centerX, centerY, accentColor)
      else -> drawGenericCellDiagram(centerX, centerY, accentColor)
    }
  }
}

private fun DrawScope.drawAnimalCellDiagram(cx: Float, cy: Float, accent: Color) {
  // Irregular animal cell membrane
  val membraneColor = Color(0xFFF472B6)
  val cytoColor = Color(0xFFFDE8E8)
  drawOval(
    color = cytoColor,
    topLeft = Offset(cx - 150f, cy - 85f),
    size = Size(300f, 170f)
  )
  drawOval(
    color = membraneColor,
    topLeft = Offset(cx - 150f, cy - 85f),
    size = Size(300f, 170f),
    style = Stroke(width = 5f)
  )

  // Nucleus in animal cell
  drawCircle(
    color = Color(0xFF818CF8),
    radius = 45f,
    center = Offset(cx - 40f, cy - 10f)
  )
  drawCircle(
    color = Color(0xFF4338CA),
    radius = 18f,
    center = Offset(cx - 40f, cy - 10f)
  )

  // Mitochondria (oval with folds)
  drawOval(
    color = Color(0xFFFB923C),
    topLeft = Offset(cx + 40f, cy - 50f),
    size = Size(55f, 30f)
  )
  drawOval(
    color = Color(0xFFFB923C),
    topLeft = Offset(cx + 30f, cy + 25f),
    size = Size(50f, 26f)
  )

  // Golgi body
  drawArc(
    color = Color(0xFFFBBF24),
    startAngle = 30f,
    sweepAngle = 120f,
    useCenter = false,
    topLeft = Offset(cx - 100f, cy + 10f),
    size = Size(40f, 40f),
    style = Stroke(width = 4f)
  )

  // Ribosomes / Lysosomes
  drawCircle(color = Color(0xFFEF4444), radius = 6f, center = Offset(cx - 80f, cy - 40f))
  drawCircle(color = Color(0xFFEF4444), radius = 6f, center = Offset(cx + 80f, cy - 10f))
  drawCircle(color = Color(0xFF10B981), radius = 4f, center = Offset(cx + 10f, cy + 45f))
  drawCircle(color = Color(0xFF10B981), radius = 4f, center = Offset(cx - 15f, cy - 60f))
}

private fun DrawScope.drawPlantCellDiagram(cx: Float, cy: Float, accent: Color) {
  // Hexagonal/Rigid plant cell wall
  drawRoundRect(
    color = Color(0xFF15803D),
    topLeft = Offset(cx - 140f, cy - 85f),
    size = Size(280f, 170f),
    cornerRadius = CornerRadius(20f, 20f),
    style = Stroke(width = 7f)
  )
  drawRoundRect(
    color = Color(0xFFDCFCE7),
    topLeft = Offset(cx - 134f, cy - 79f),
    size = Size(268f, 158f),
    cornerRadius = CornerRadius(16f, 16f)
  )

  // Large Central Vacuole
  drawOval(
    color = Color(0xFFBAE6FD),
    topLeft = Offset(cx - 70f, cy - 55f),
    size = Size(160f, 110f)
  )
  drawOval(
    color = Color(0xFF38BDF8),
    topLeft = Offset(cx - 70f, cy - 55f),
    size = Size(160f, 110f),
    style = Stroke(width = 2.5f)
  )

  // Chloroplasts (green discs)
  val chloroColor = Color(0xFF16A34A)
  drawOval(color = chloroColor, topLeft = Offset(cx - 110f, cy - 65f), size = Size(32f, 20f))
  drawOval(color = chloroColor, topLeft = Offset(cx - 115f, cy + 30f), size = Size(32f, 20f))
  drawOval(color = chloroColor, topLeft = Offset(cx + 70f, cy - 65f), size = Size(32f, 20f))
  drawOval(color = chloroColor, topLeft = Offset(cx + 65f, cy + 35f), size = Size(32f, 20f))

  // Nucleus pushed to the periphery
  drawCircle(
    color = Color(0xFF818CF8),
    radius = 28f,
    center = Offset(cx - 85f, cy - 10f)
  )
  drawCircle(
    color = Color(0xFF312E81),
    radius = 12f,
    center = Offset(cx - 85f, cy - 10f)
  )
}

private fun DrawScope.drawFungalCellDiagram(cx: Float, cy: Float, accent: Color) {
  // Fungal cell with chitin wall
  drawOval(
    color = Color(0xFFD97706),
    topLeft = Offset(cx - 135f, cy - 80f),
    size = Size(270f, 160f),
    style = Stroke(width = 6f)
  )
  drawOval(
    color = Color(0xFFFEF3C7),
    topLeft = Offset(cx - 130f, cy - 75f),
    size = Size(260f, 150f)
  )
  // Nucleus
  drawCircle(color = Color(0xFF9333EA), radius = 35f, center = Offset(cx - 20f, cy))
  drawCircle(color = Color(0xFF581C87), radius = 14f, center = Offset(cx - 20f, cy))
  // Mitochondria
  drawOval(color = Color(0xFFEF4444), topLeft = Offset(cx + 40f, cy - 40f), size = Size(40f, 24f))
  drawOval(color = Color(0xFFEF4444), topLeft = Offset(cx + 35f, cy + 20f), size = Size(40f, 24f))
}

private fun DrawScope.drawBacterialCellDiagram(cx: Float, cy: Float, accent: Color) {
  // Capsule / Pill shape
  drawRoundRect(
    color = Color(0xFF059669),
    topLeft = Offset(cx - 110f, cy - 55f),
    size = Size(220f, 110f),
    cornerRadius = CornerRadius(55f, 55f)
  )
  drawRoundRect(
    color = Color(0xFF10B981),
    topLeft = Offset(cx - 104f, cy - 49f),
    size = Size(208f, 98f),
    cornerRadius = CornerRadius(49f, 49f),
    style = Stroke(width = 4f)
  )
  // Nucleoid tangled DNA in center
  drawCircle(color = Color(0xFF818CF8), radius = 22f, center = Offset(cx - 20f, cy))
  drawCircle(color = Color(0xFF6366F1), radius = 16f, center = Offset(cx + 20f, cy))
  // Flagellum
  val path = Path().apply {
    moveTo(cx + 110f, cy)
    cubicTo(cx + 150f, cy - 30f, cx + 180f, cy + 30f, cx + 220f, cy)
  }
  drawPath(path, color = Color(0xFF047857), style = Stroke(width = 4f))
}

private fun DrawScope.drawVirusDiagram(cx: Float, cy: Float, accent: Color) {
  // 1. Bacteriophage (Left)
  // Icosahedral head
  val headPath = Path().apply {
    moveTo(cx - 80f, cy - 70f)
    lineTo(cx - 50f, cy - 50f)
    lineTo(cx - 50f, cy - 10f)
    lineTo(cx - 80f, cy + 10f)
    lineTo(cx - 110f, cy - 10f)
    lineTo(cx - 110f, cy - 50f)
    close()
  }
  drawPath(headPath, color = Color(0xFF38BDF8))
  // Sheath & tail fibers
  drawLine(Color(0xFF0284C7), Offset(cx - 80f, cy + 10f), Offset(cx - 80f, cy + 50f), strokeWidth = 6f)
  drawLine(Color(0xFF0284C7), Offset(cx - 80f, cy + 50f), Offset(cx - 110f, cy + 75f), strokeWidth = 3f)
  drawLine(Color(0xFF0284C7), Offset(cx - 80f, cy + 50f), Offset(cx - 50f, cy + 75f), strokeWidth = 3f)

  // 2. Influenza (Right)
  drawCircle(color = Color(0xFFE11D48), radius = 50f, center = Offset(cx + 70f, cy))
  drawCircle(color = Color(0xFFFDA4AF), radius = 42f, center = Offset(cx + 70f, cy))
  drawCircle(color = Color(0xFF881337), radius = 24f, center = Offset(cx + 70f, cy))
}

private fun DrawScope.drawParameciumDiagram(cx: Float, cy: Float, accent: Color) {
  // Slipper shape
  drawOval(
    color = Color(0xFF67E8F9),
    topLeft = Offset(cx - 130f, cy - 55f),
    size = Size(260f, 110f)
  )
  drawOval(
    color = Color(0xFF0891B2),
    topLeft = Offset(cx - 130f, cy - 55f),
    size = Size(260f, 110f),
    style = Stroke(width = 3f)
  )
  // Macro & micro nucleus
  drawOval(color = Color(0xFF991B1B), topLeft = Offset(cx - 20f, cy - 15f), size = Size(45f, 25f))
  drawCircle(color = Color(0xFFEF4444), radius = 7f, center = Offset(cx + 35f, cy - 10f))
  // Contractile vacuoles (star shaped)
  drawCircle(color = Color(0xFFFBBF24), radius = 16f, center = Offset(cx - 80f, cy))
  drawCircle(color = Color(0xFFFBBF24), radius = 16f, center = Offset(cx + 75f, cy))
}

private fun DrawScope.drawChlamydomonasDiagram(cx: Float, cy: Float, accent: Color) {
  // Pear shape cell
  drawOval(
    color = Color(0xFF16A34A),
    topLeft = Offset(cx - 65f, cy - 70f),
    size = Size(130f, 150f)
  )
  // Cup shaped chloroplast inside
  drawArc(
    color = Color(0xFF22C55E),
    startAngle = 0f,
    sweepAngle = 180f,
    useCenter = true,
    topLeft = Offset(cx - 55f, cy - 40f),
    size = Size(110f, 110f)
  )
  // Nucleus inside the cup depression
  drawCircle(color = Color(0xFFF59E0B), radius = 18f, center = Offset(cx, cy - 10f))
  // 2 Flagella at top apex
  val flag1 = Path().apply {
    moveTo(cx - 10f, cy - 70f)
    cubicTo(cx - 40f, cy - 110f, cx - 80f, cy - 90f, cx - 70f, cy - 120f)
  }
  val flag2 = Path().apply {
    moveTo(cx + 10f, cy - 70f)
    cubicTo(cx + 40f, cy - 110f, cx + 80f, cy - 90f, cx + 70f, cy - 120f)
  }
  drawPath(flag1, color = Color(0xFF047857), style = Stroke(width = 3.5f))
  drawPath(flag2, color = Color(0xFF047857), style = Stroke(width = 3.5f))
}

private fun DrawScope.drawPalisadeCellDiagram(cx: Float, cy: Float, accent: Color) {
  // Columnar / rectangular palisade cell
  drawRoundRect(
    color = Color(0xFF15803D),
    topLeft = Offset(cx - 60f, cy - 95f),
    size = Size(120f, 190f),
    cornerRadius = CornerRadius(10f, 10f),
    style = Stroke(width = 5f)
  )
  drawRoundRect(
    color = Color(0xFFDCFCE7),
    topLeft = Offset(cx - 56f, cy - 91f),
    size = Size(112f, 182f),
    cornerRadius = CornerRadius(8f, 8f)
  )
  // Large vacuole
  drawRoundRect(
    color = Color(0xFFBAE6FD),
    topLeft = Offset(cx - 40f, cy - 65f),
    size = Size(80f, 130f),
    cornerRadius = CornerRadius(12f, 12f)
  )
  // Numerous chloroplasts around the periphery
  val chloro = Color(0xFF16A34A)
  for (i in -80..80 step 25) {
    drawOval(color = chloro, topLeft = Offset(cx - 52f, cy + i), size = Size(14f, 18f))
    drawOval(color = chloro, topLeft = Offset(cx + 38f, cy + i), size = Size(14f, 18f))
  }
}

private fun DrawScope.drawDicotStemDiagram(cx: Float, cy: Float, accent: Color) {
  // Circular stem cross section
  drawCircle(color = Color(0xFFBBF7D0), radius = 95f, center = Offset(cx, cy))
  drawCircle(color = Color(0xFF16A34A), radius = 95f, center = Offset(cx, cy), style = Stroke(width = 4f))
  // Pith center
  drawCircle(color = Color(0xFFFEF08A), radius = 38f, center = Offset(cx, cy))

  // Ring of vascular bundles (8 bundles)
  for (angle in 0 until 360 step 45) {
    val rad = Math.toRadians(angle.toDouble())
    val bx = cx + (65f * Math.cos(rad)).toFloat()
    val by = cy + (65f * Math.sin(rad)).toFloat()
    drawCircle(color = Color(0xFF991B1B), radius = 10f, center = Offset(bx, by))
    drawCircle(color = Color(0xFF0284C7), radius = 6f, center = Offset(bx, by))
  }
}

private fun DrawScope.drawMonocotStemDiagram(cx: Float, cy: Float, accent: Color) {
  // Circular stem cross section
  drawCircle(color = Color(0xFFDCFCE7), radius = 95f, center = Offset(cx, cy))
  drawCircle(color = Color(0xFF15803D), radius = 95f, center = Offset(cx, cy), style = Stroke(width = 4f))

  // Scattered vascular bundles
  val points = listOf(
    Offset(-50f, -40f), Offset(40f, -50f), Offset(10f, -20f), Offset(-20f, 20f),
    Offset(50f, 30f), Offset(-60f, 25f), Offset(10f, 60f), Offset(-30f, -65f),
    Offset(60f, -20f), Offset(-10f, -5f), Offset(35f, 10f), Offset(-45f, 55f)
  )
  points.forEach { pt ->
    drawOval(
      color = Color(0xFF7C3AED),
      topLeft = Offset(cx + pt.x - 7f, cy + pt.y - 10f),
      size = Size(14f, 20f)
    )
    drawCircle(color = Color(0xFF38BDF8), radius = 4f, center = Offset(cx + pt.x, cy + pt.y))
  }
}

private fun DrawScope.drawDicotRootDiagram(cx: Float, cy: Float, accent: Color) {
  // Root outer cortex
  drawCircle(color = Color(0xFFD1FAE5), radius = 95f, center = Offset(cx, cy))
  drawCircle(color = Color(0xFF059669), radius = 95f, center = Offset(cx, cy), style = Stroke(width = 4f))

  // Endodermis ring
  drawCircle(color = Color(0xFF047857), radius = 40f, center = Offset(cx, cy), style = Stroke(width = 3f))

  // Star-shaped Xylem in center (4 arms)
  val starPath = Path().apply {
    moveTo(cx, cy - 32f)
    lineTo(cx + 8f, cy - 8f)
    lineTo(cx + 32f, cy)
    lineTo(cx + 8f, cy + 8f)
    lineTo(cx, cy + 32f)
    lineTo(cx - 8f, cy + 8f)
    lineTo(cx - 32f, cy)
    lineTo(cx - 8f, cy - 8f)
    close()
  }
  drawPath(starPath, color = Color(0xFFDC2626))

  // Phloem patches between xylem arms
  drawCircle(color = Color(0xFF2563EB), radius = 7f, center = Offset(cx + 18f, cy - 18f))
  drawCircle(color = Color(0xFF2563EB), radius = 7f, center = Offset(cx + 18f, cy + 18f))
  drawCircle(color = Color(0xFF2563EB), radius = 7f, center = Offset(cx - 18f, cy + 18f))
  drawCircle(color = Color(0xFF2563EB), radius = 7f, center = Offset(cx - 18f, cy - 18f))
}

private fun DrawScope.drawGenericCellDiagram(cx: Float, cy: Float, accent: Color) {
  drawCircle(color = Color(0xFFE2E8F0), radius = 80f, center = Offset(cx, cy))
  drawCircle(color = accent, radius = 80f, center = Offset(cx, cy), style = Stroke(width = 3f))
  drawCircle(color = Color(0xFF3B82F6), radius = 25f, center = Offset(cx, cy))
}
