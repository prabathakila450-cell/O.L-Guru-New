package com.example

import androidx.compose.animation.*
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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

enum class SanduReaderMode {
  LIGHT,
  SEPIA,
  DARK,
  BLUE_LIGHT_SHIELD
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SanduTheory100PagesReaderDialog(
  initialPage: Int = 1,
  onDismiss: () -> Unit
) {
  var currentPageNumber by remember { mutableIntStateOf(initialPage.coerceIn(1, 100)) }
  var searchQuery by remember { mutableStateOf("") }
  var isSearchMode by remember { mutableStateOf(false) }
  var isFullScreenMode by remember { mutableStateOf(false) }
  var readerTheme by remember { mutableStateOf(SanduReaderMode.LIGHT) }
  var fontScale by remember { mutableFloatStateOf(1.0f) }
  var showJumpDialog by remember { mutableStateOf(false) }

  val currentPage = remember(currentPageNumber) {
    SanduTheoryPdfBookletRepository.getPage(currentPageNumber)
  }

  val searchResults = remember(searchQuery) {
    if (searchQuery.isBlank()) emptyList()
    else SanduTheoryPdfBookletRepository.searchPages(searchQuery)
  }

  val bgColor = when (readerTheme) {
    SanduReaderMode.LIGHT -> Color(0xFFF8FAFC)
    SanduReaderMode.SEPIA -> Color(0xFFFDF6E2)
    SanduReaderMode.DARK -> Color(0xFF0F172A)
    SanduReaderMode.BLUE_LIGHT_SHIELD -> Color(0xFF131B2E)
  }

  val cardBg = when (readerTheme) {
    SanduReaderMode.LIGHT -> Color.White
    SanduReaderMode.SEPIA -> Color(0xFFFFFBEB)
    SanduReaderMode.DARK -> Color(0xFF1E293B)
    SanduReaderMode.BLUE_LIGHT_SHIELD -> Color(0xFF1E293B)
  }

  val textPrimary = when (readerTheme) {
    SanduReaderMode.LIGHT -> Color(0xFF0F172A)
    SanduReaderMode.SEPIA -> Color(0xFF451A03)
    SanduReaderMode.DARK -> Color(0xFFF1F5F9)
    SanduReaderMode.BLUE_LIGHT_SHIELD -> Color(0xFFE2E8F0)
  }

  val textSecondary = when (readerTheme) {
    SanduReaderMode.LIGHT -> Color(0xFF475569)
    SanduReaderMode.SEPIA -> Color(0xFF78350F)
    SanduReaderMode.DARK -> Color(0xFF94A3B8)
    SanduReaderMode.BLUE_LIGHT_SHIELD -> Color(0xFF94A3B8)
  }

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(
      usePlatformDefaultWidth = false,
      securePolicy = AppSecurityManager.getSecureFlagPolicy()
    )
  ) {
    androidx.compose.foundation.text.selection.DisableSelection {
      Surface(
        modifier = Modifier.fillMaxSize(),
        color = bgColor
      ) {
      Column(modifier = Modifier.fillMaxSize()) {
        // Ultra-Compact Top Bar (Hidden in Full Screen Mode)
        AnimatedVisibility(visible = !isFullScreenMode) {
          Column(modifier = Modifier.fillMaxWidth()) {
            Surface(
              color = Color(0xFF0F172A),
              modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
            ) {
              Row(
                modifier = Modifier
                  .fillMaxSize()
                  .padding(horizontal = 6.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                IconButton(onClick = onDismiss, modifier = Modifier.size(26.dp).testTag("sandu_reader_close")) {
                  Icon(imageVector = Icons.Default.Close, contentDescription = "Close", tint = Color.White, modifier = Modifier.size(16.dp))
                }

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                  text = "Sandu Theory • පිටු 100",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis,
                  modifier = Modifier.weight(1f)
                )

                // Fullscreen button
                Surface(
                  onClick = { isFullScreenMode = true },
                  shape = RoundedCornerShape(4.dp),
                  color = Color(0xFF0284C7),
                  modifier = Modifier.height(24.dp).testTag("sandu_reader_fullscreen_btn")
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text("⛶", fontSize = 10.sp, color = Color.White)
                    Spacer(modifier = Modifier.width(2.dp))
                    Text("ෆුල් ස්ක්‍රීන්", color = Color.White, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                  }
                }

                Spacer(modifier = Modifier.width(4.dp))

                // Theme toggle
                IconButton(
                  onClick = {
                    readerTheme = when (readerTheme) {
                      SanduReaderMode.LIGHT -> SanduReaderMode.SEPIA
                      SanduReaderMode.SEPIA -> SanduReaderMode.DARK
                      SanduReaderMode.DARK -> SanduReaderMode.BLUE_LIGHT_SHIELD
                      SanduReaderMode.BLUE_LIGHT_SHIELD -> SanduReaderMode.LIGHT
                    }
                  },
                  modifier = Modifier.size(24.dp)
                ) {
                  Text(
                    text = when (readerTheme) {
                      SanduReaderMode.LIGHT -> "☀️"
                      SanduReaderMode.SEPIA -> "📜"
                      SanduReaderMode.DARK -> "🌙"
                      SanduReaderMode.BLUE_LIGHT_SHIELD -> "🛡️"
                    },
                    fontSize = 13.sp
                  )
                }

                // Search toggle
                IconButton(onClick = { isSearchMode = !isSearchMode }, modifier = Modifier.size(24.dp)) {
                  Icon(imageVector = Icons.Default.Search, contentDescription = "Search", tint = Color.White, modifier = Modifier.size(15.dp))
                }

                // Jump page button
                IconButton(onClick = { showJumpDialog = true }, modifier = Modifier.size(24.dp).testTag("sandu_reader_jump_btn")) {
                  Icon(imageVector = Icons.Default.Bookmarks, contentDescription = "Jump", tint = Color(0xFFFDE047), modifier = Modifier.size(15.dp))
                }
              }
            }

            // Compact Red Page Navigation Bar
            Surface(
              color = Color(0xFFDC2626),
              shadowElevation = 2.dp,
              modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .testTag("sandu_reader_top_page_nav")
            ) {
              Row(
                modifier = Modifier
                  .fillMaxSize()
                  .padding(horizontal = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                // Previous Page Button
                FilledTonalButton(
                  onClick = { if (currentPageNumber > 1) currentPageNumber-- },
                  enabled = currentPageNumber > 1,
                  shape = RoundedCornerShape(4.dp),
                  colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = Color(0xFF7F1D1D),
                    contentColor = Color.White,
                    disabledContainerColor = Color(0xFF991B1B).copy(alpha = 0.5f),
                    disabledContentColor = Color.White.copy(alpha = 0.4f)
                  ),
                  contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                  modifier = Modifier.height(24.dp).testTag("sandu_reader_prev_btn")
                ) {
                  Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Prev",
                    modifier = Modifier.size(12.dp)
                  )
                  Spacer(modifier = Modifier.width(2.dp))
                  Text("පෙර", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                }

                // Center Page Info & Quick Jump trigger
                Surface(
                  onClick = { showJumpDialog = true },
                  shape = RoundedCornerShape(4.dp),
                  color = Color(0xFF991B1B),
                  border = BorderStroke(1.dp, Color(0xFFFECACA)),
                  modifier = Modifier.height(24.dp).testTag("sandu_reader_page_indicator")
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(
                      text = "පිටුව $currentPageNumber / 100",
                      color = Color.White,
                      fontSize = 10.5.sp,
                      fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Icon(
                      imageVector = Icons.Default.UnfoldMore,
                      contentDescription = "Jump",
                      tint = Color(0xFFFECACA),
                      modifier = Modifier.size(12.dp)
                    )
                  }
                }

                // NEXT PAGE BUTTON
                Button(
                  onClick = { if (currentPageNumber < 100) currentPageNumber++ },
                  enabled = currentPageNumber < 100,
                  shape = RoundedCornerShape(4.dp),
                  colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(0xFFB91C1C),
                    disabledContainerColor = Color.White.copy(alpha = 0.3f),
                    disabledContentColor = Color.White.copy(alpha = 0.5f)
                  ),
                  contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                  modifier = Modifier.height(24.dp).testTag("sandu_reader_next_btn")
                ) {
                  Text(
                    text = "ඊළඟ පිටුව",
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Black,
                    color = if (currentPageNumber < 100) Color(0xFFB91C1C) else Color.White.copy(alpha = 0.5f)
                  )
                  Spacer(modifier = Modifier.width(2.dp))
                  Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Next",
                    tint = if (currentPageNumber < 100) Color(0xFFB91C1C) else Color.White.copy(alpha = 0.5f),
                    modifier = Modifier.size(12.dp)
                  )
                }
              }
            }
          }
        }

        // Search Results List (when searching)
        if (isSearchMode && searchQuery.isNotBlank()) {
          LazyColumn(
            modifier = Modifier
              .weight(1f)
              .fillMaxWidth()
              .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            items(searchResults) { resultPage ->
              Surface(
                onClick = {
                  currentPageNumber = resultPage.pageNumber
                  isSearchMode = false
                  searchQuery = ""
                },
                shape = RoundedCornerShape(8.dp),
                color = cardBg,
                border = BorderStroke(1.dp, Color(0xFF38BDF8))
              ) {
                Row(
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Column(modifier = Modifier.weight(1f)) {
                    Text(
                      text = "පිටුව ${resultPage.pageNumber}: ${resultPage.unitTitleSinhala}",
                      fontWeight = FontWeight.Bold,
                      fontSize = 12.5.sp,
                      color = textPrimary
                    )
                    Text(
                      text = resultPage.pageHeader,
                      fontSize = 10.5.sp,
                      color = textSecondary
                    )
                  }
                  Text(
                    text = if (resultPage.isAnswerPage) "පිළිතුරු" else "සටහන",
                    color = if (resultPage.isAnswerPage) Color(0xFF9333EA) else Color(0xFF0284C7),
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp
                  )
                }
              }
            }
          }
        } else {
          // Page Content View
          Box(
            modifier = Modifier
              .weight(1f)
              .fillMaxWidth()
          ) {
            if (currentPage != null) {
              LazyColumn(
                modifier = Modifier
                  .fillMaxSize()
                  .padding(horizontal = 14.dp, vertical = 10.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
              ) {
                // Header decoration
                item {
                  Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                      containerColor = if (currentPage.isAnswerPage) Color(0xFF581C87) else Color(0xFF0369A1)
                    ),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Row(
                      modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                      horizontalArrangement = Arrangement.SpaceBetween,
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Column(modifier = Modifier.weight(1f)) {
                        Text(
                          text = "Sandu theory",
                          fontSize = 18.sp,
                          fontWeight = FontWeight.Black,
                          color = Color.White,
                          fontFamily = FontFamily.Serif
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                          text = currentPage.unitTitleSinhala,
                          fontSize = 13.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFFE0F2FE)
                        )
                      }
                      Surface(
                        color = Color.White.copy(alpha = 0.2f),
                        shape = RoundedCornerShape(8.dp)
                      ) {
                        Text(
                          text = "පිටුව ${currentPage.pageNumber}",
                          fontWeight = FontWeight.ExtraBold,
                          fontSize = 13.sp,
                          color = Color.White,
                          modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                      }
                    }
                  }
                }

                // Page Sections
                items(currentPage.pageSections) { section ->
                  Card(
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = cardBg),
                    border = BorderStroke(1.dp, Color(0xFFCBD5E1).copy(alpha = 0.6f)),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                      Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                      ) {
                        Text(
                          text = section.heading,
                          fontWeight = FontWeight.Bold,
                          fontSize = (13.sp * fontScale),
                          color = section.type.color
                        )
                        Surface(
                          color = section.type.color.copy(alpha = 0.12f),
                          shape = RoundedCornerShape(4.dp)
                        ) {
                          Text(
                            text = section.type.badgeText,
                            color = section.type.color,
                            fontWeight = FontWeight.Bold,
                            fontSize = 9.sp,
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                          )
                        }
                      }
                      Spacer(modifier = Modifier.height(8.dp))
                      section.items.forEach { itemText ->
                        Text(
                          text = itemText,
                          fontSize = (12.sp * fontScale),
                          lineHeight = (18.sp * fontScale),
                          color = textPrimary,
                          modifier = Modifier.padding(vertical = 3.dp)
                        )
                      }
                    }
                  }
                }

                // Watermark footer like official PDF
                item {
                  Box(
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(vertical = 8.dp),
                    contentAlignment = Alignment.Center
                  ) {
                    Text(
                      text = "ඔබට අවශ්‍ය සියලුම සිද්ධාන්ත හා Theory කොටස් Sandu Theory වෙතින්",
                      fontSize = 10.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = textSecondary,
                      textAlign = TextAlign.Center
                    )
                  }
                }

                // 🔴 Optional End of Page Next Page Button (in red)
                if (currentPageNumber < 100) {
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
                        text = "ඊළඟ පිටුවට යන්න (පිටුව ${currentPageNumber + 1} / 100) →",
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                      )
                    }
                  }
                }
              }
            }

            // Floating Controls when in Full Screen Mode
            if (isFullScreenMode) {
              // Exit Full Screen Button at Top-Right
              Surface(
                onClick = { isFullScreenMode = false },
                shape = RoundedCornerShape(16.dp),
                color = Color.Black.copy(alpha = 0.75f),
                border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.7f)),
                modifier = Modifier
                  .align(Alignment.TopEnd)
                  .padding(10.dp)
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 9.dp, vertical = 5.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Exit Fullscreen",
                    tint = Color(0xFF38BDF8),
                    modifier = Modifier.size(13.dp)
                  )
                  Spacer(modifier = Modifier.width(3.dp))
                  Text(
                    text = "සාමාන්‍ය තිරය",
                    color = Color.White,
                    fontSize = 9.5.sp,
                    fontWeight = FontWeight.Bold
                  )
                }
              }

              // Floating Bottom Page Switcher Pill
              Surface(
                shape = RoundedCornerShape(20.dp),
                color = Color(0xFF0F172A).copy(alpha = 0.9f),
                border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.5f)),
                shadowElevation = 4.dp,
                modifier = Modifier
                  .align(Alignment.BottomCenter)
                  .padding(bottom = 12.dp)
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                  IconButton(
                    onClick = { if (currentPageNumber > 1) currentPageNumber-- },
                    enabled = currentPageNumber > 1,
                    modifier = Modifier.size(28.dp)
                  ) {
                    Icon(
                      imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                      contentDescription = "Prev",
                      tint = if (currentPageNumber > 1) Color.White else Color.Gray,
                      modifier = Modifier.size(16.dp)
                    )
                  }

                  Text(
                    text = "පිටුව $currentPageNumber / 100",
                    color = Color.White,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                  )

                  IconButton(
                    onClick = { if (currentPageNumber < 100) currentPageNumber++ },
                    enabled = currentPageNumber < 100,
                    modifier = Modifier.size(28.dp)
                  ) {
                    Icon(
                      imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                      contentDescription = "Next",
                      tint = if (currentPageNumber < 100) Color(0xFF38BDF8) else Color.Gray,
                      modifier = Modifier.size(16.dp)
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
    AlertDialog(
      onDismissRequest = { showJumpDialog = false },
      properties = DialogProperties(securePolicy = AppSecurityManager.getSecureFlagPolicy()),
      title = {
        Text("පිටුවකට හෝ ඒකකයකට පනින්න", fontWeight = FontWeight.Bold, fontSize = 15.sp)
      },
      text = {
        Column(modifier = Modifier.fillMaxWidth()) {
          Text("පිටුව තෝරන්න (1 - 100):", fontSize = 12.sp, color = Color(0xFF64748B))
          Spacer(modifier = Modifier.height(8.dp))

          // Quick Section Buttons
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            Button(
              onClick = {
                currentPageNumber = 1
                showJumpDialog = false
              },
              modifier = Modifier.weight(1f),
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
              contentPadding = PaddingValues(2.dp)
            ) {
              Text("01 ආරම්භය", fontSize = 10.5.sp)
            }
            Button(
              onClick = {
                currentPageNumber = 40
                showJumpDialog = false
              },
              modifier = Modifier.weight(1f),
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF475569)),
              contentPadding = PaddingValues(2.dp)
            ) {
              Text("පිටුව 40", fontSize = 10.5.sp)
            }
            Button(
              onClick = {
                currentPageNumber = 78
                showJumpDialog = false
              },
              modifier = Modifier.weight(1f),
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C3AED)),
              contentPadding = PaddingValues(2.dp)
            ) {
              Text("78 පිළිතුරු", fontSize = 10.5.sp)
            }
          }

          Spacer(modifier = Modifier.height(12.dp))

          // Key units list
          Text("ප්‍රධාන ඒකක වෙත ක්ෂණික පිවිසුම:", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
          Spacer(modifier = Modifier.height(6.dp))

          LazyColumn(
            modifier = Modifier
              .fillMaxWidth()
              .height(200.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
          ) {
            items((1..42).toList()) { uNum ->
              val range = SanduTheoryPdfBookletRepository.unitPageMapping[uNum] ?: 1..1
              val uInfo = Grade10And11MathRepository.getUnitByNumber(uNum)
              Surface(
                onClick = {
                  currentPageNumber = range.first
                  showJumpDialog = false
                },
                shape = RoundedCornerShape(6.dp),
                color = Color(0xFFF1F5F9),
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(
                    text = "${String.format("%02d", uNum)}. ${uInfo?.titleSinhala ?: ""}",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                  )
                  Text(
                    text = "පිටු ${range.first}-${range.last}",
                    fontSize = 10.sp,
                    color = Color(0xFF0284C7),
                    fontWeight = FontWeight.Bold
                  )
                }
              }
            }
          }
        }
      },
      confirmButton = {
        TextButton(onClick = { showJumpDialog = false }) {
          Text("වසන්න")
        }
      }
    )
  }
}
