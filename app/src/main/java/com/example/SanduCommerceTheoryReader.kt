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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SanduCommerceTheoryReaderDialog(
  initialPage: Int = 1,
  onDismiss: () -> Unit,
  onOpenDrivePdf: ((url: String, title: String) -> Unit)? = null
) {
  var currentPageNumber by remember { mutableIntStateOf(initialPage.coerceIn(1, 76)) }
  var searchQuery by remember { mutableStateOf("") }
  var isSearchMode by remember { mutableStateOf(false) }
  var readerTheme by remember { mutableStateOf(SanduReaderMode.LIGHT) }
  var fontScale by remember { mutableFloatStateOf(1.0f) }
  var showJumpDialog by remember { mutableStateOf(false) }

  val currentPage = remember(currentPageNumber) {
    SanduCommerceTheoryBookletRepository.getPage(currentPageNumber)
  }

  val searchResults = remember(searchQuery) {
    if (searchQuery.isBlank()) emptyList()
    else SanduCommerceTheoryBookletRepository.searchPages(searchQuery)
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
        // Top App Bar
        TopAppBar(
          title = {
            Column {
              Text(
                text = "Sandu Theory • O/L කොමස් පිටු 76 ක ග්‍රන්ථය",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Text(
                text = "පිටුව $currentPageNumber / 76 • පාඩම ${currentPage?.chapterNumber ?: 1}: ${currentPage?.chapterTitleSinhala ?: ""}",
                fontSize = 10.5.sp,
                color = Color(0xFF34D399),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
              )
            }
          },
          navigationIcon = {
            IconButton(onClick = onDismiss, modifier = Modifier.testTag("sandu_commerce_reader_close")) {
              Icon(imageVector = Icons.Default.Close, contentDescription = "Close", tint = Color.White)
            }
          },
          actions = {
            // Font Scale Toggle
            IconButton(
              onClick = {
                fontScale = if (fontScale >= 1.25f) 0.9f else fontScale + 0.1f
              }
            ) {
              Text("A±", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE047))
            }

            // Theme toggle
            IconButton(
              onClick = {
                readerTheme = when (readerTheme) {
                  SanduReaderMode.LIGHT -> SanduReaderMode.SEPIA
                  SanduReaderMode.SEPIA -> SanduReaderMode.DARK
                  SanduReaderMode.DARK -> SanduReaderMode.BLUE_LIGHT_SHIELD
                  SanduReaderMode.BLUE_LIGHT_SHIELD -> SanduReaderMode.LIGHT
                }
              }
            ) {
              Text(
                text = when (readerTheme) {
                  SanduReaderMode.LIGHT -> "☀️"
                  SanduReaderMode.SEPIA -> "📜"
                  SanduReaderMode.DARK -> "🌙"
                  SanduReaderMode.BLUE_LIGHT_SHIELD -> "🛡️"
                },
                fontSize = 16.sp
              )
            }

            // Search toggle
            IconButton(onClick = { isSearchMode = !isSearchMode }) {
              Icon(imageVector = Icons.Default.Search, contentDescription = "Search", tint = Color.White)
            }

            // Jump page button
            IconButton(onClick = { showJumpDialog = true }, modifier = Modifier.testTag("sandu_commerce_reader_jump_btn")) {
              Icon(imageVector = Icons.Default.Bookmarks, contentDescription = "Jump", tint = Color(0xFF34D399))
            }
          },
          colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF064E3B))
        )

        // Search Bar (if visible)
        AnimatedVisibility(visible = isSearchMode) {
          Surface(
            color = Color(0xFF042F2E),
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 6.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("පිටු අංකය, පාඩම, හෝ සිද්ධාන්තය සොයන්න...", fontSize = 12.sp, color = Color(0xFF99F6E4)) },
                singleLine = true,
                modifier = Modifier.weight(1f),
                colors = OutlinedTextFieldDefaults.colors(
                  focusedTextColor = Color.White,
                  unfocusedTextColor = Color.White,
                  focusedContainerColor = Color(0xFF0F172A),
                  unfocusedContainerColor = Color(0xFF0F172A)
                )
              )
              Spacer(modifier = Modifier.width(6.dp))
              IconButton(onClick = {
                searchQuery = ""
                isSearchMode = false
              }) {
                Icon(imageVector = Icons.Default.Close, contentDescription = "Close", tint = Color.White)
              }
            }
          }
        }

        // 🔴 Prominent RED Page Navigation Bar at the Very Top (ඉහළින්ම රතු පැහැයෙන් පිටු මාරුව)
        Surface(
          color = Color(0xFFDC2626), // Clear Vibrant Red
          shadowElevation = 4.dp,
          modifier = Modifier
            .fillMaxWidth()
            .testTag("sandu_commerce_top_page_nav")
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
              modifier = Modifier.testTag("sandu_commerce_prev_btn")
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
              modifier = Modifier.testTag("sandu_commerce_page_indicator")
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = "පිටුව $currentPageNumber / 76",
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
              onClick = { if (currentPageNumber < 76) currentPageNumber++ },
              enabled = currentPageNumber < 76,
              shape = RoundedCornerShape(8.dp),
              colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color(0xFFB91C1C),
                disabledContainerColor = Color.White.copy(alpha = 0.3f),
                disabledContentColor = Color.White.copy(alpha = 0.5f)
              ),
              contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
              elevation = ButtonDefaults.buttonElevation(defaultElevation = 3.dp),
              modifier = Modifier.testTag("sandu_commerce_next_btn")
            ) {
              Text(
                text = "ඊළඟ පිටුව",
                fontSize = 12.sp,
                fontWeight = FontWeight.Black,
                color = if (currentPageNumber < 76) Color(0xFFB91C1C) else Color.White.copy(alpha = 0.5f)
              )
              Spacer(modifier = Modifier.width(4.dp))
              Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Next",
                tint = if (currentPageNumber < 76) Color(0xFFB91C1C) else Color.White.copy(alpha = 0.5f),
                modifier = Modifier.size(16.dp)
              )
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
                border = BorderStroke(1.dp, Color(0xFF10B981))
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
                      text = "පිටුව ${resultPage.pageNumber}: පාඩම ${resultPage.chapterNumber} (${resultPage.gradeLevel} ශ්‍රේණිය)",
                      fontWeight = FontWeight.Bold,
                      fontSize = 12.5.sp,
                      color = textPrimary
                    )
                    Text(
                      text = resultPage.chapterTitleSinhala,
                      fontSize = 11.sp,
                      color = textSecondary
                    )
                    Text(
                      text = "මූලික සංකල්පය: ${resultPage.rootConcept}",
                      fontSize = 10.sp,
                      color = Color(0xFF059669),
                      fontWeight = FontWeight.SemiBold
                    )
                  }
                  Surface(
                    color = Color(0xFF059669).copy(alpha = 0.15f),
                    shape = RoundedCornerShape(4.dp)
                  ) {
                    Text(
                      text = "පිටුව ${resultPage.pageNumber}",
                      color = Color(0xFF059669),
                      fontWeight = FontWeight.Bold,
                      fontSize = 10.sp,
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                  }
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
                      containerColor = Color(0xFF065F46)
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
                        Row(verticalAlignment = Alignment.CenterVertically) {
                          Text(
                            text = "Sandu Theory",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White,
                            fontFamily = FontFamily.Serif
                          )
                          Spacer(modifier = Modifier.width(6.dp))
                          Surface(
                            color = Color(0xFFFDE047),
                            shape = RoundedCornerShape(4.dp)
                          ) {
                            Text(
                              text = "${currentPage.gradeLevel} ශ්‍රේණිය",
                              fontSize = 9.sp,
                              fontWeight = FontWeight.Bold,
                              color = Color(0xFF78350F),
                              modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                            )
                          }
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                          text = "පාඩම ${currentPage.chapterNumber}: ${currentPage.chapterTitleSinhala}",
                          fontSize = 13.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFFD1FAE5)
                        )
                        Text(
                          text = "මූලික සංකල්පය: ${currentPage.rootConcept}",
                          fontSize = 10.5.sp,
                          color = Color(0xFFA7F3D0)
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
                          text = section.title,
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

                      section.subtitle?.let { sub ->
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                          text = sub,
                          fontSize = (11.sp * fontScale),
                          color = textSecondary,
                          fontWeight = FontWeight.Medium
                        )
                      }

                      section.definition?.let { def ->
                        Spacer(modifier = Modifier.height(6.dp))
                        Surface(
                          color = section.type.color.copy(alpha = 0.08f),
                          shape = RoundedCornerShape(6.dp),
                          border = BorderStroke(1.dp, section.type.color.copy(alpha = 0.25f)),
                          modifier = Modifier.fillMaxWidth()
                        ) {
                          Text(
                            text = "💡 නිර්වචනය: $def",
                            fontSize = (11.5.sp * fontScale),
                            fontWeight = FontWeight.SemiBold,
                            color = textPrimary,
                            modifier = Modifier.padding(8.dp)
                          )
                        }
                      }

                      if (section.bullets.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(6.dp))
                        section.bullets.forEach { bullet ->
                          Row(
                            modifier = Modifier
                              .fillMaxWidth()
                              .padding(vertical = 2.5.dp),
                            verticalAlignment = Alignment.Top
                          ) {
                            Text(
                              text = "•",
                              fontSize = (13.sp * fontScale),
                              fontWeight = FontWeight.Bold,
                              color = section.type.color,
                              modifier = Modifier.padding(end = 6.dp)
                            )
                            Text(
                              text = bullet,
                              fontSize = (12.sp * fontScale),
                              lineHeight = (18.sp * fontScale),
                              color = textPrimary
                            )
                          }
                        }
                      }

                      if (section.examples.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(6.dp))
                        Surface(
                          color = Color(0xFFF0FDF4),
                          shape = RoundedCornerShape(6.dp),
                          border = BorderStroke(1.dp, Color(0xFF86EFAC)),
                          modifier = Modifier.fillMaxWidth()
                        ) {
                          Column(modifier = Modifier.padding(8.dp)) {
                            Text(
                              text = "📌 ප්‍රායෝගික උදාහරණ:",
                              fontSize = (11.sp * fontScale),
                              fontWeight = FontWeight.Bold,
                              color = Color(0xFF166534)
                            )
                            section.examples.forEach { ex ->
                              Text(
                                text = "→ $ex",
                                fontSize = (11.sp * fontScale),
                                color = Color(0xFF14532D),
                                modifier = Modifier.padding(top = 2.dp)
                              )
                            }
                          }
                        }
                      }

                      if (section.subBoxes.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(8.dp))
                        section.subBoxes.forEach { box ->
                          Surface(
                            color = Color(0xFFF1F5F9),
                            shape = RoundedCornerShape(6.dp),
                            border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
                            modifier = Modifier
                              .fillMaxWidth()
                              .padding(vertical = 3.dp)
                          ) {
                            Column(modifier = Modifier.padding(8.dp)) {
                              Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                              ) {
                                Text(
                                  text = box.header,
                                  fontSize = (11.5.sp * fontScale),
                                  fontWeight = FontWeight.Bold,
                                  color = Color(0xFF0F172A)
                                )
                                box.tag?.let { tag ->
                                  Surface(
                                    color = Color(0xFF0284C7).copy(alpha = 0.15f),
                                    shape = RoundedCornerShape(3.dp)
                                  ) {
                                    Text(
                                      text = tag,
                                      fontSize = 8.5.sp,
                                      color = Color(0xFF0369A1),
                                      fontWeight = FontWeight.Bold,
                                      modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                    )
                                  }
                                }
                              }
                              Spacer(modifier = Modifier.height(2.dp))
                              Text(
                                text = box.body,
                                fontSize = (11.sp * fontScale),
                                lineHeight = (16.sp * fontScale),
                                color = Color(0xFF334155)
                              )
                            }
                          }
                        }
                      }
                    }
                  }
                }

                // Comparison Table (if present)
                currentPage.comparisonTable?.let { table ->
                  item {
                    Card(
                      shape = RoundedCornerShape(10.dp),
                      colors = CardDefaults.cardColors(containerColor = cardBg),
                      border = BorderStroke(1.2.dp, Color(0xFF7C3AED).copy(alpha = 0.5f)),
                      modifier = Modifier.fillMaxWidth()
                    ) {
                      Column(modifier = Modifier.padding(10.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                          Text("⚖️", fontSize = 14.sp)
                          Spacer(modifier = Modifier.width(6.dp))
                          Text(
                            text = table.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = (12.5.sp * fontScale),
                            color = Color(0xFF6D28D9)
                          )
                        }
                        Spacer(modifier = Modifier.height(8.dp))

                        // Table Header
                        Row(
                          modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFEDE9FE), RoundedCornerShape(6.dp))
                            .padding(8.dp)
                        ) {
                          Text(
                            text = table.col1Header,
                            fontWeight = FontWeight.Bold,
                            fontSize = (11.sp * fontScale),
                            color = Color(0xFF4C1D95),
                            modifier = Modifier.weight(1f)
                          )
                          Spacer(modifier = Modifier.width(6.dp))
                          Text(
                            text = table.col2Header,
                            fontWeight = FontWeight.Bold,
                            fontSize = (11.sp * fontScale),
                            color = Color(0xFF4C1D95),
                            modifier = Modifier.weight(1f)
                          )
                        }

                        // Table Rows
                        table.rows.forEachIndexed { idx, pair ->
                          Row(
                            modifier = Modifier
                              .fillMaxWidth()
                              .background(if (idx % 2 == 0) Color.Transparent else Color(0xFFF5F3FF))
                              .padding(horizontal = 8.dp, vertical = 6.dp)
                          ) {
                            Text(
                              text = pair.first,
                              fontSize = (11.sp * fontScale),
                              color = textPrimary,
                              modifier = Modifier.weight(1f)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                              text = pair.second,
                              fontSize = (11.sp * fontScale),
                              color = textPrimary,
                              modifier = Modifier.weight(1f)
                            )
                          }
                        }
                      }
                    }
                  }
                }

                // Exam Key Points (if present)
                if (currentPage.examKeyPoints.isNotEmpty()) {
                  item {
                    Card(
                      shape = RoundedCornerShape(10.dp),
                      colors = CardDefaults.cardColors(containerColor = Color(0xFFFEF2F2)),
                      border = BorderStroke(1.dp, Color(0xFFFCA5A5)),
                      modifier = Modifier.fillMaxWidth()
                    ) {
                      Column(modifier = Modifier.padding(10.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                          Text("🎯", fontSize = 14.sp)
                          Spacer(modifier = Modifier.width(6.dp))
                          Text(
                            text = "විභාග විශේෂ වැදගත් කරුණු (Exam Key Points):",
                            fontSize = (12.sp * fontScale),
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF991B1B)
                          )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        currentPage.examKeyPoints.forEach { pt ->
                          Text(
                            text = "★ $pt",
                            fontSize = (11.sp * fontScale),
                            color = Color(0xFF7F1D1D),
                            modifier = Modifier.padding(vertical = 2.dp)
                          )
                        }
                      }
                    }
                  }
                }

                // Watermark footer
                item {
                  Box(
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(vertical = 12.dp),
                    contentAlignment = Alignment.Center
                  ) {
                    Text(
                      text = "10 සහ 11 ශ්‍රේණි ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය • Sandu Theory පිටු 76 ක පූර්ණ ග්‍රන්ථය",
                      fontSize = 10.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = textSecondary,
                      textAlign = TextAlign.Center
                    )
                  }
                }

                // 🔴 Optional End of Page Next Page Button (in red)
                if (currentPageNumber < 76) {
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
                        text = "ඊළඟ පිටුවට යන්න (පිටුව ${currentPageNumber + 1} / 76) →",
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
}

  // Quick Jump Dialog
  if (showJumpDialog) {
    AlertDialog(
      onDismissRequest = { showJumpDialog = false },
      title = {
        Text("පාඩමකට හෝ පිටුවකට පනින්න", fontWeight = FontWeight.Bold, fontSize = 15.sp)
      },
      text = {
        Column(modifier = Modifier.fillMaxWidth()) {
          Text("පාඩම් 27 ලැයිස්තුවෙන් තෝරන්න:", fontSize = 12.sp, color = Color(0xFF64748B))
          Spacer(modifier = Modifier.height(8.dp))

          LazyColumn(
            modifier = Modifier
              .fillMaxWidth()
              .heightIn(max = 350.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
          ) {
            items(SanduCommerceTheoryBookletRepository.chapterPageRanges.toList()) { (chNum, pair) ->
              val (title, range) = pair
              val isSelected = currentPageNumber in range
              Surface(
                onClick = {
                  currentPageNumber = range.first
                  showJumpDialog = false
                },
                shape = RoundedCornerShape(6.dp),
                color = if (isSelected) Color(0xFFD1FAE5) else Color(0xFFF1F5F9),
                border = BorderStroke(1.dp, if (isSelected) Color(0xFF059669) else Color(0xFFCBD5E1))
              ) {
                Row(
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 6.dp),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Column(modifier = Modifier.weight(1f)) {
                    Text(
                      text = "පාඩම $chNum: $title",
                      fontSize = 11.5.sp,
                      fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                      color = if (isSelected) Color(0xFF065F46) else Color(0xFF1E293B)
                    )
                  }
                  Spacer(modifier = Modifier.width(6.dp))
                  Surface(
                    color = Color(0xFF059669).copy(alpha = 0.15f),
                    shape = RoundedCornerShape(4.dp)
                  ) {
                    Text(
                      text = "පිටු ${range.first}-${range.last}",
                      fontSize = 9.5.sp,
                      color = Color(0xFF065F46),
                      fontWeight = FontWeight.Bold,
                      modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                    )
                  }
                }
              }
            }
          }
        }
      },
      confirmButton = {
        TextButton(onClick = { showJumpDialog = false }) {
          Text("වසන්න", fontWeight = FontWeight.Bold)
        }
      }
    )
  }
}
