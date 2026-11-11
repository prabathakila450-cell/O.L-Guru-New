package com.example

import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.text.selection.DisableSelection

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.filled.Share
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
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

enum class SinhalaReaderTheme(
  val labelSinhala: String,
  val backgroundColor: Color,
  val contentColor: Color,
  val cardBackground: Color,
  val accentColor: Color,
  val quoteBackground: Color
) {
  LIGHT("දිවා මාදිලිය", Color(0xFFF8FAFC), Color(0xFF0F172A), Color.White, Color(0xFFDC2626), Color(0xFFFEF2F2)),
  SEPIA("පොත් පිටු (Sepia)", Color(0xFFFAF5EF), Color(0xFF3E2723), Color(0xFFFFFDF9), Color(0xFFB91C1C), Color(0xFFFBE9E7)),
  DARK("රාත්‍රී මාදිලිය", Color(0xFF090D16), Color(0xFFF1F5F9), Color(0xFF131B2E), Color(0xFFEF4444), Color(0xFF1E293B)),
  BLUE_SHIELD("ඇස් ආරක්ෂණ (Eye-Care)", Color(0xFF0F172A), Color(0xFFE2E8F0), Color(0xFF1E293B), Color(0xFFF43F5E), Color(0xFF334155))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SinhalaShortNotesPdfReaderDialog(
  initialPage: Int = 1,
  onDismiss: () -> Unit
) {
  var currentPageNumber by remember { mutableIntStateOf(initialPage.coerceIn(1, 30)) }
  var readerTheme by remember { mutableStateOf(SinhalaReaderTheme.LIGHT) }
  var fontSizeMultiplier by remember { mutableFloatStateOf(1.0f) }
  var showJumpDialog by remember { mutableStateOf(false) }
  var showThemeDialog by remember { mutableStateOf(false) }
  var isSearchMode by remember { mutableStateOf(false) }
  var searchQuery by remember { mutableStateOf("") }
  var selectedUnitFilter by remember { mutableIntStateOf(0) } // 0 = all
  val bookmarks = remember { mutableStateListOf<Int>() }

  val context = LocalContext.current
  val clipboardManager = LocalClipboardManager.current
  var showCopiedToast by remember { mutableStateOf(false) }

  val currentPage = remember(currentPageNumber) {
    SinhalaVicharaDharaPdfBookletRepository.getPage(currentPageNumber)
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
          .testTag("sinhala_short_notes_pdf_reader_dialog"),
        color = readerTheme.backgroundColor
      ) {
      Column(modifier = Modifier.fillMaxSize()) {

        // Top Main Header Bar
        Surface(
          color = Color(0xFF991B1B), // Deep Maroon Red
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
                    text = "10/11 සිංහල සාහිත්‍යය • විචාර ධාරා",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                  Text(
                    text = "ඒකක 7 ට අදාළ විචාර 23 සම්පූර්ණ PDF සංග්‍රහය",
                    color = Color(0xFFFECACA),
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
                placeholder = { Text("විචාර, කවි, පාඩම් මාතෘකා සොයන්න...", fontSize = 12.sp, color = Color.White.copy(alpha = 0.7f)) },
                colors = OutlinedTextFieldDefaults.colors(
                  focusedBorderColor = Color(0xFFFECACA),
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

        // 🔴 MANDATORY RULE: PROMINENT RED PAGE NAVIGATION BAR AT THE VERY TOP
        Surface(
          color = Color(0xFFDC2626), // Clear Bold Red
          shadowElevation = 4.dp,
          modifier = Modifier
            .fillMaxWidth()
            .testTag("sinhala_reader_top_page_nav")
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
                disabledContainerColor = Color(0xFF991B1B).copy(alpha = 0.5f),
                disabledContentColor = Color.White.copy(alpha = 0.4f)
              ),
              contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
              modifier = Modifier.testTag("sinhala_reader_prev_btn")
            ) {
              Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Prev",
                modifier = Modifier.size(15.dp)
              )
              Spacer(modifier = Modifier.width(3.dp))
              Text("පෙර", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
            }

            // Center Page Info & Quick Jump trigger
            Surface(
              onClick = { showJumpDialog = true },
              shape = RoundedCornerShape(8.dp),
              color = Color(0xFF991B1B),
              border = BorderStroke(1.dp, Color(0xFFFECACA)),
              modifier = Modifier.testTag("sinhala_reader_page_indicator")
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = "පිටුව $currentPageNumber / 30",
                  color = Color.White,
                  fontSize = 12.sp,
                  fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                  imageVector = Icons.Default.UnfoldMore,
                  contentDescription = "Jump",
                  tint = Color(0xFFFECACA),
                  modifier = Modifier.size(14.dp)
                )
              }
            }

            // 🔴 NEXT PAGE BUTTON (Highlight in bright white & bold red)
            Button(
              onClick = { if (currentPageNumber < 30) currentPageNumber++ },
              enabled = currentPageNumber < 30,
              shape = RoundedCornerShape(8.dp),
              colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color(0xFFB91C1C),
                disabledContainerColor = Color.White.copy(alpha = 0.3f),
                disabledContentColor = Color.White.copy(alpha = 0.5f)
              ),
              contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
              elevation = ButtonDefaults.buttonElevation(defaultElevation = 3.dp),
              modifier = Modifier.testTag("sinhala_reader_next_btn")
            ) {
              Text(
                text = "ඊළඟ පිටුව",
                fontSize = 12.sp,
                fontWeight = FontWeight.Black,
                color = if (currentPageNumber < 30) Color(0xFFB91C1C) else Color.White.copy(alpha = 0.5f)
              )
              Spacer(modifier = Modifier.width(4.dp))
              Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Next",
                tint = if (currentPageNumber < 30) Color(0xFFB91C1C) else Color.White.copy(alpha = 0.5f),
                modifier = Modifier.size(16.dp)
              )
            }
          }
        }

        // Unit Filter Tabs (Quick navigation across 7 syllabus lessons)
        Surface(
          color = readerTheme.cardBackground,
          shadowElevation = 2.dp,
          modifier = Modifier.fillMaxWidth()
        ) {
          LazyRow(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 8.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            item {
              FilterChip(
                selected = selectedUnitFilter == 0,
                onClick = { selectedUnitFilter = 0 },
                label = { Text("සියල්ල (30)", fontSize = 10.5.sp) },
                colors = FilterChipDefaults.filterChipColors(
                  selectedContainerColor = Color(0xFFDC2626),
                  selectedLabelColor = Color.White
                )
              )
            }

            items(SinhalaVicharaDharaPdfBookletRepository.units) { unit ->
              FilterChip(
                selected = selectedUnitFilter == unit.unitNumber,
                onClick = {
                  selectedUnitFilter = unit.unitNumber
                  currentPageNumber = unit.pageRange.first
                },
                label = {
                  Text(
                    text = "${unit.titleSinhala.take(12)}... (${unit.pageRange.first}-${unit.pageRange.last})",
                    fontSize = 10.sp
                  )
                },
                colors = FilterChipDefaults.filterChipColors(
                  selectedContainerColor = Color(0xFFDC2626),
                  selectedLabelColor = Color.White
                )
              )
            }
          }
        }

        // Search Results List (if actively searching)
        if (isSearchMode && searchQuery.isNotBlank()) {
          val searchResults = remember(searchQuery) {
            SinhalaVicharaDharaPdfBookletRepository.searchPages(searchQuery)
          }

          LazyColumn(
            modifier = Modifier
              .fillMaxSize()
              .background(readerTheme.backgroundColor)
              .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            item {
              Text(
                text = "සෙවුම් ප්‍රතිඵල (${searchResults.size})",
                color = readerTheme.contentColor,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
              )
            }

            items(searchResults) { page ->
              Card(
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = readerTheme.cardBackground),
                border = BorderStroke(1.dp, readerTheme.accentColor.copy(alpha = 0.3f)),
                modifier = Modifier
                  .fillMaxWidth()
                  .clickable {
                    currentPageNumber = page.pageNumber
                    isSearchMode = false
                  }
              ) {
                Column(modifier = Modifier.padding(10.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                  ) {
                    Text(
                      text = "පිටුව ${page.pageNumber}: ${page.unitTitle}",
                      color = readerTheme.accentColor,
                      fontWeight = FontWeight.Bold,
                      fontSize = 11.5.sp
                    )
                    if (page.marks > 0) {
                      Text(
                        text = "ලකුණු ${page.marks}",
                        color = Color.White,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                          .background(Color(0xFFDC2626), RoundedCornerShape(4.dp))
                          .padding(horizontal = 4.dp, vertical = 2.dp)
                      )
                    }
                  }
                  Spacer(modifier = Modifier.height(3.dp))
                  Text(
                    text = page.essayQuestion,
                    color = readerTheme.contentColor,
                    fontSize = 11.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                  )
                }
              }
            }
          }
        } else {
          // Normal Page Content View
          LazyColumn(
            modifier = Modifier
              .fillMaxSize()
              .background(readerTheme.backgroundColor)
              .padding(horizontal = 14.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            currentPage?.let { page ->

              // Page Title & Header Banner
              item {
                Card(
                  shape = RoundedCornerShape(10.dp),
                  colors = CardDefaults.cardColors(containerColor = readerTheme.cardBackground),
                  border = BorderStroke(1.2.dp, Color(0xFFDC2626).copy(alpha = 0.4f)),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Column(modifier = Modifier.padding(12.dp)) {
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.SpaceBetween,
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Surface(
                        color = Color(0xFFDC2626),
                        shape = RoundedCornerShape(6.dp)
                      ) {
                        Text(
                          text = if (page.essayNumber > 0) "විචාර අංක 0${page.essayNumber}" else "මඟපෙන්වීම",
                          color = Color.White,
                          fontSize = (10.5 * fontSizeMultiplier).sp,
                          fontWeight = FontWeight.ExtraBold,
                          modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                      }

                      Text(
                        text = page.authorOrSource,
                        color = readerTheme.contentColor.copy(alpha = 0.7f),
                        fontSize = (10.0 * fontSizeMultiplier).sp,
                        fontWeight = FontWeight.Medium
                      )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                      text = page.essayQuestion,
                      color = readerTheme.contentColor,
                      fontSize = (13.5 * fontSizeMultiplier).sp,
                      fontWeight = FontWeight.Bold,
                      lineHeight = (19.0 * fontSizeMultiplier).sp
                    )

                    if (page.marks > 0) {
                      Spacer(modifier = Modifier.height(4.dp))
                      Text(
                        text = "සම්පූර්ණ ලකුණු: ${page.marks} • ආදර්ශ විචාර පිළිතුර",
                        color = Color(0xFFDC2626),
                        fontSize = (10.5 * fontSizeMultiplier).sp,
                        fontWeight = FontWeight.SemiBold
                      )
                    }
                  }
                }
              }

              // Quotes / Verses Section (if present)
              if (page.quotesAndVerses.isNotEmpty()) {
                item {
                  Card(
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = readerTheme.quoteBackground),
                    border = BorderStroke(1.dp, Color(0xFFFCA5A5)),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                      Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("📖", fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                          text = "උපුටා දැක්විය යුතු ප්‍රධාන පද්‍ය / ගද්‍ය පාඨ:",
                          color = Color(0xFF991B1B),
                          fontWeight = FontWeight.Bold,
                          fontSize = (12.0 * fontSizeMultiplier).sp
                        )
                      }
                      Spacer(modifier = Modifier.height(6.dp))
                      page.quotesAndVerses.forEach { quote ->
                        Surface(
                          color = readerTheme.cardBackground,
                          shape = RoundedCornerShape(6.dp),
                          border = BorderStroke(1.dp, Color(0xFFFECACA)),
                          modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                        ) {
                          Text(
                            text = quote,
                            color = Color(0xFF7F1D1D),
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = (12.0 * fontSizeMultiplier).sp,
                            lineHeight = (18.0 * fontSizeMultiplier).sp,
                            modifier = Modifier.padding(8.dp)
                          )
                        }
                      }
                    }
                  }
                }
              }

              // Model Answer Paragraphs
              item {
                Card(
                  shape = RoundedCornerShape(10.dp),
                  colors = CardDefaults.cardColors(containerColor = readerTheme.cardBackground),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.SpaceBetween,
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Text(
                        text = "සම්පූර්ණ ආදර්ශ විචාරය (Model Answer):",
                        color = readerTheme.accentColor,
                        fontWeight = FontWeight.Bold,
                        fontSize = (12.5 * fontSizeMultiplier).sp
                      )

                      IconButton(
                        onClick = {
                          if (AppSecurityManager.canCopyContent(context)) {
                            val allText = page.modelAnswerParagraphs.joinToString("\n\n")
                            clipboardManager.setText(AnnotatedString(allText))
                            showCopiedToast = true
                          } else {
                            Toast.makeText(context, "ආරක්ෂක නීති අනුව සටහන් පිටපත් කිරීම (Copy) අවහිර කර ඇත (Admin Only).", Toast.LENGTH_SHORT).show()
                          }
                        },
                        modifier = Modifier.size(30.dp)
                      ) {
                        Icon(
                          imageVector = Icons.Default.Share,
                          contentDescription = "Copy text",
                          tint = readerTheme.accentColor,
                          modifier = Modifier.size(16.dp)
                        )
                      }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    page.modelAnswerParagraphs.forEachIndexed { idx, paragraph ->
                      Text(
                        text = paragraph,
                        color = readerTheme.contentColor,
                        fontSize = (13.0 * fontSizeMultiplier).sp,
                        lineHeight = (20.0 * fontSizeMultiplier).sp,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(bottom = 10.dp)
                      )
                    }
                  }
                }
              }

              // Key Evaluation Points / Marking Scheme
              if (page.keyEvaluationPoints.isNotEmpty()) {
                item {
                  Card(
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = readerTheme.cardBackground),
                    border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.5f)),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                      Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("🎯", fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                          text = "ලකුණු ලබාදීමේ ප්‍රධාන නිර්ණායක (Marking Key Points):",
                          color = Color(0xFF047857),
                          fontWeight = FontWeight.Bold,
                          fontSize = (12.0 * fontSizeMultiplier).sp
                        )
                      }
                      Spacer(modifier = Modifier.height(6.dp))
                      page.keyEvaluationPoints.forEach { point ->
                        Row(
                          modifier = Modifier.padding(vertical = 3.dp),
                          verticalAlignment = Alignment.Top
                        ) {
                          Text(
                            text = "• ",
                            color = Color(0xFF059669),
                            fontWeight = FontWeight.Bold,
                            fontSize = (13.0 * fontSizeMultiplier).sp
                          )
                          Text(
                            text = point,
                            color = readerTheme.contentColor,
                            fontSize = (11.5 * fontSizeMultiplier).sp,
                            lineHeight = (17.0 * fontSizeMultiplier).sp
                          )
                        }
                      }
                    }
                  }
                }
              }

              // End of Page Notice & Big Red "Next Page" Button
              item {
                Box(
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                  contentAlignment = Alignment.Center
                ) {
                  Text(
                    text = "— පිටුව $currentPageNumber අවසන් —",
                    color = readerTheme.contentColor.copy(alpha = 0.5f),
                    fontSize = 11.sp
                  )
                }
              }

              if (currentPageNumber < 30) {
                item {
                  Button(
                    onClick = { currentPageNumber++ },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(bottom = 16.dp)
                  ) {
                    Text(
                      text = "ඊළඟ පිටුවට යන්න (පිටුව ${currentPageNumber + 1} / 30) →",
                      fontSize = 12.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color.White
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

  // Quick Jump Dialog
  if (showJumpDialog) {
    Dialog(
      onDismissRequest = { showJumpDialog = false },
      properties = DialogProperties(securePolicy = AppSecurityManager.getSecureFlagPolicy())
    ) {
      Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFF0F172A),
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp)
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Text(
            text = "පිටුව තෝරන්න (1 - 30)",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
          )
          Spacer(modifier = Modifier.height(10.dp))

          LazyColumn(
            modifier = Modifier.height(280.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
          ) {
            items(SinhalaVicharaDharaPdfBookletRepository.pages) { pg ->
              val isSelected = pg.pageNumber == currentPageNumber
              Surface(
                onClick = {
                  currentPageNumber = pg.pageNumber
                  showJumpDialog = false
                },
                shape = RoundedCornerShape(8.dp),
                color = if (isSelected) Color(0xFFDC2626) else Color(0xFF1E293B),
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.SpaceBetween
                ) {
                  Column(modifier = Modifier.weight(1f)) {
                    Text(
                      text = "පිටුව ${pg.pageNumber}: ${pg.unitTitle}",
                      color = Color.White,
                      fontWeight = FontWeight.Bold,
                      fontSize = 11.5.sp
                    )
                    Text(
                      text = pg.essayQuestion,
                      color = Color.White.copy(alpha = 0.7f),
                      fontSize = 10.sp,
                      maxLines = 1,
                      overflow = TextOverflow.Ellipsis
                    )
                  }
                  if (isSelected) {
                    Icon(
                      imageVector = Icons.Default.Check,
                      contentDescription = "Selected",
                      tint = Color.White,
                      modifier = Modifier.size(16.dp)
                    )
                  }
                }
              }
            }
          }

          Spacer(modifier = Modifier.height(12.dp))
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
          ) {
            TextButton(onClick = { showJumpDialog = false }) {
              Text("වසන්න", color = Color(0xFFF87171))
            }
          }
        }
      }
    }
  }

  // Theme Picker Dialog
  if (showThemeDialog) {
    Dialog(onDismissRequest = { showThemeDialog = false }) {
      Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFF0F172A),
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp)
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Text(
            text = "කියවනය මාදිලිය තෝරන්න",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
          )
          Spacer(modifier = Modifier.height(10.dp))

          SinhalaReaderTheme.values().forEach { theme ->
            Surface(
              onClick = {
                readerTheme = theme
                showThemeDialog = false
              },
              shape = RoundedCornerShape(8.dp),
              color = if (readerTheme == theme) Color(0xFFDC2626) else Color(0xFF1E293B),
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
            ) {
              Row(
                modifier = Modifier.padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Text(theme.labelSinhala, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Box(
                  modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(theme.backgroundColor)
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(10.dp))
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
          ) {
            TextButton(onClick = { showThemeDialog = false }) {
              Text("වසන්න", color = Color(0xFFF87171))
            }
          }
        }
      }
    }
  }
}
