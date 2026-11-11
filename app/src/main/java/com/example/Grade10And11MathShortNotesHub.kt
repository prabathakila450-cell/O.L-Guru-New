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
fun Grade10And11MathShortNotesHubScreen(
  onBack: () -> Unit,
  onOpenPdfModal: ((url: String, title: String) -> Unit)? = null,
  onOpenQuizMaster: (() -> Unit)? = null
) {
  var selectedGrade by remember { mutableStateOf(MathGradeFilter.ALL) }
  var selectedCategory by remember { mutableStateOf(MathCategory.ALL) }
  var searchQuery by remember { mutableStateOf("") }
  var selectedUnitDetail by remember { mutableStateOf<MathUnitShortNote?>(null) }
  var showFormulaQuickCalc by remember { mutableStateOf(false) }
  var showSanduFullBookReader by remember { mutableStateOf(false) }
  var initialBookPage by remember { mutableIntStateOf(1) }

  val filteredUnits = remember(selectedGrade, selectedCategory, searchQuery) {
    Grade10And11MathRepository.getUnits(selectedGrade, selectedCategory, searchQuery)
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = "10 & 11 ශ්‍රේණි ගණිතය කෙටි සටහන්",
              fontWeight = FontWeight.Bold,
              fontSize = 17.sp,
              color = Color.White
            )
            Text(
              text = "Sandu Theory ඒකක 42 පූර්ණ සංග්‍රහය & විසඳුම්",
              fontSize = 11.sp,
              color = Color(0xFFBAE6FD)
            )
          }
        },
        navigationIcon = {
          IconButton(
            onClick = onBack,
            modifier = Modifier.testTag("math_short_notes_back_button")
          ) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = "Back",
              tint = Color.White
            )
          }
        },
        actions = {
          // Sandu 100-Pages PDF Book Reader
          IconButton(
            onClick = {
              initialBookPage = 1
              showSanduFullBookReader = true
            },
            modifier = Modifier.testTag("math_sandu_pdf_reader_button")
          ) {
            Icon(
              imageVector = Icons.Default.MenuBook,
              contentDescription = "Sandu Theory 100-Pages PDF Book",
              tint = Color(0xFFFDE047)
            )
          }
          // Quick Calculator action
          IconButton(
            onClick = { showFormulaQuickCalc = true },
            modifier = Modifier.testTag("math_quick_calc_button")
          ) {
            Icon(
              imageVector = Icons.Default.Calculate,
              contentDescription = "Quick Calculator",
              tint = Color.White
            )
          }
          // Master PDF Action
          IconButton(
            onClick = {
              onOpenPdfModal?.invoke(
                "https://drive.google.com/file/d/1V3y65z_15X6zjruQ_I11WhG4EOfDHGm-/preview",
                "10 හා 11 ශ්‍රේණි ගණිතය කෙටි සටහන් (Sandu Theory 100-Pages PDF)"
              )
            },
            modifier = Modifier.testTag("math_pdf_master_button")
          ) {
            Icon(
              imageVector = Icons.Default.PictureAsPdf,
              contentDescription = "Master PDF",
              tint = Color(0xFF38BDF8)
            )
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = Color(0xFF0F172A)
        )
      )
    },
    containerColor = Color(0xFFF8FAFC)
  ) { paddingValues ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
        .testTag("math_short_notes_main_list"),
      contentPadding = PaddingValues(bottom = 28.dp),
      verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      // 1. Sleek Compact Control Panel (Grade Toggle + Search)
      item(key = "math_control_panel") {
        Surface(
          color = Color(0xFF0F172A),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
          ) {
            // Grade Filter Row
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
              MathGradeFilter.entries.forEach { gradeFilter ->
                val isSelected = selectedGrade == gradeFilter
                FilterChip(
                  selected = isSelected,
                  onClick = { selectedGrade = gradeFilter },
                  label = {
                    Text(
                      text = gradeFilter.label,
                      fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                      fontSize = 11.sp
                    )
                  },
                  colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFF2563EB),
                    selectedLabelColor = Color.White,
                    containerColor = Color(0xFF1E293B),
                    labelColor = Color(0xFF94A3B8)
                  ),
                  border = BorderStroke(
                    width = 1.dp,
                    color = if (isSelected) Color(0xFF60A5FA) else Color(0xFF334155)
                  ),
                  modifier = Modifier
                    .weight(1f)
                    .testTag("grade_filter_${gradeFilter.name}")
                )
              }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Search Field
            OutlinedTextField(
              value = searchQuery,
              onValueChange = { searchQuery = it },
              placeholder = {
                Text(
                  text = "ඒකක අංකය (01-42), මාතෘකාව හෝ සූත්‍රය සොයන්න...",
                  fontSize = 11.5.sp,
                  color = Color(0xFF94A3B8)
                )
              },
              leadingIcon = {
                Icon(
                  imageVector = Icons.Default.Search,
                  contentDescription = "Search",
                  tint = Color(0xFF60A5FA),
                  modifier = Modifier.size(16.dp)
                )
              },
              trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                  IconButton(onClick = { searchQuery = "" }, modifier = Modifier.size(24.dp)) {
                    Icon(
                      imageVector = Icons.Default.Clear,
                      contentDescription = "Clear",
                      tint = Color(0xFF94A3B8),
                      modifier = Modifier.size(14.dp)
                    )
                  }
                }
              },
              singleLine = true,
              shape = RoundedCornerShape(8.dp),
              colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF1E293B),
                unfocusedContainerColor = Color(0xFF1E293B),
                focusedBorderColor = Color(0xFF38BDF8),
                unfocusedBorderColor = Color(0xFF334155),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
              ),
              modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .testTag("math_notes_search_field")
            )
          }
        }
      }

      // 2. Sandu Theory 100-Page PDF Hero Banner - ULTRA SLIM & COMPACT (Height minimized!)
      item(key = "sandu_pdf_hero_banner") {
        Surface(
          onClick = {
            initialBookPage = 1
            showSanduFullBookReader = true
          },
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFF1E1B4B),
          border = BorderStroke(1.dp, Color(0xFF818CF8)),
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 2.dp)
            .testTag("sandu_pdf_hero_banner")
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 10.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Box(
              modifier = Modifier
                .size(28.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Color(0xFF4F46E5)),
              contentAlignment = Alignment.Center
            ) {
              Text("📕", fontSize = 15.sp)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                  text = "Sandu Theory 100-පිටු PDF ග්‍රන්ථය",
                  fontWeight = FontWeight.Bold,
                  fontSize = 11.5.sp,
                  color = Color.White
                )
                Spacer(modifier = Modifier.width(4.dp))
                Surface(
                  color = Color(0xFFF59E0B),
                  shape = RoundedCornerShape(3.dp)
                ) {
                  Text(
                    text = "පිටු 100",
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 0.5.dp)
                  )
                }
              }
              Text(
                text = "ඒකක 01-42 සියලු සිද්ධාන්ත, ගැටලු හා පිටු 78-100 පිළිතුරු",
                fontSize = 9.5.sp,
                color = Color(0xFFC7D2FE),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
              )
            }
            Spacer(modifier = Modifier.width(6.dp))
            Button(
              onClick = {
                initialBookPage = 1
                showSanduFullBookReader = true
              },
              shape = RoundedCornerShape(6.dp),
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6366F1)),
              contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
              modifier = Modifier.height(26.dp)
            ) {
              Text("කියවන්න", fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
          }
        }
      }

      // 3. Math 4000 Questions Quiz Master Banner - ULTRA SLIM & COMPACT (Height minimized!)
      if (onOpenQuizMaster != null) {
        item(key = "math_4000_quiz_banner") {
          Surface(
            onClick = { onOpenQuizMaster() },
            color = Color(0xFF1E1B4B),
            border = BorderStroke(1.dp, Color(0xFF818CF8)),
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 10.dp, vertical = 2.dp)
              .testTag("math_4000_quiz_banner_button"),
            shape = RoundedCornerShape(8.dp)
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Box(
                modifier = Modifier
                  .size(28.dp)
                  .clip(RoundedCornerShape(6.dp))
                  .background(Color(0xFF6366F1)),
                contentAlignment = Alignment.Center
              ) {
                Text("🎯", fontSize = 15.sp)
              }
              Spacer(modifier = Modifier.width(8.dp))
              Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text(
                    text = "10 & 11 ගණිතය ප්‍රශ්න 4000 ක්විස්",
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.5.sp,
                    color = Color.White
                  )
                  Spacer(modifier = Modifier.width(4.dp))
                  Surface(
                    color = Color(0xFF10B981),
                    shape = RoundedCornerShape(3.dp)
                  ) {
                    Text(
                      text = "ප්‍රශ්න 4000",
                      fontSize = 8.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color.White,
                      modifier = Modifier.padding(horizontal = 4.dp, vertical = 0.5.dp)
                    )
                  }
                }
                Text(
                  text = "10 & 11 සඳහා කාණ්ඩ 80 බැගින් ප්‍රශ්න 25 සෙට් • 100% විවරණ",
                  fontSize = 9.5.sp,
                  color = Color(0xFFC7D2FE),
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }
              Spacer(modifier = Modifier.width(6.dp))
              Surface(
                shape = RoundedCornerShape(6.dp),
                color = Color(0xFF4F46E5)
              ) {
                Text(
                  text = "ආරම්භ කරන්න",
                  color = Color.White,
                  fontSize = 9.5.sp,
                  fontWeight = FontWeight.Bold,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                )
              }
            }
          }
        }
      }

      // 4. Categories Horizontal Scrollable Row
      item(key = "math_categories_row") {
        LazyRow(
          contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
          horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          items(MathCategory.entries) { category ->
            val isSelected = selectedCategory == category
            Surface(
              onClick = { selectedCategory = category },
              shape = RoundedCornerShape(16.dp),
              color = if (isSelected) category.color else Color.White,
              border = BorderStroke(1.dp, if (isSelected) category.color else Color(0xFFCBD5E1)),
              shadowElevation = if (isSelected) 1.5.dp else 0.5.dp,
              modifier = Modifier.testTag("cat_chip_${category.name}")
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(category.icon, fontSize = 11.sp)
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                  text = category.displayName,
                  fontSize = 11.sp,
                  fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                  color = if (isSelected) Color.White else Color(0xFF1E293B)
                )
              }
            }
          }
        }
      }

      // 5. Stats & Result Counter Header
      item(key = "math_stats_row") {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 2.dp),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            text = "සොයාගත් ඒකක: ${filteredUnits.size} / 42",
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF475569)
          )
          Text(
            text = "Sandu Theory සම්පූර්ණ විෂය නිර්දේශය",
            fontSize = 10.5.sp,
            color = Color(0xFF0284C7),
            fontWeight = FontWeight.Medium
          )
        }
      }

      // 6. Units List or Empty State
      if (filteredUnits.isEmpty()) {
        item(key = "math_empty_state") {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 40.dp, horizontal = 24.dp),
            contentAlignment = Alignment.Center
          ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
              Text("🔍", fontSize = 36.sp)
              Spacer(modifier = Modifier.height(10.dp))
              Text(
                text = "ගැලපෙන ඒකකයක් හමු නොවීය",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color(0xFF334155)
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "වෙනත් සෙවුම් පදයක් හෝ ශ්‍රේණියක් තෝරා බලන්න",
                fontSize = 11.5.sp,
                color = Color(0xFF64748B)
              )
            }
          }
        }
      } else {
        items(filteredUnits, key = { it.unitNumber }) { unit ->
          Box(modifier = Modifier.padding(horizontal = 10.dp)) {
            MathUnitCard(
              unit = unit,
              onCardClick = { selectedUnitDetail = unit }
            )
          }
        }
      }
    }
  }

  // Unit Detail Dialog / Modal
  selectedUnitDetail?.let { unit ->
    MathUnitDetailDialog(
      unit = unit,
      onDismiss = { selectedUnitDetail = null },
      onOpenPdfModal = onOpenPdfModal,
      onOpenSanduPage = { page ->
        initialBookPage = page
        showSanduFullBookReader = true
      }
    )
  }

  // Quick Formula Calculator Dialog
  if (showFormulaQuickCalc) {
    MathQuickFormulaCalculatorDialog(
      onDismiss = { showFormulaQuickCalc = false }
    )
  }

  // Sandu Theory 100-Pages Full PDF Book Reader Dialog
  if (showSanduFullBookReader) {
    SanduTheory100PagesReaderDialog(
      initialPage = initialBookPage,
      onDismiss = { showSanduFullBookReader = false }
    )
  }
}

@Composable
fun MathUnitCard(
  unit: MathUnitShortNote,
  onCardClick: () -> Unit
) {
  Card(
    onClick = onCardClick,
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    elevation = CardDefaults.cardElevation(defaultElevation = 1.5.dp),
    border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
    modifier = Modifier
      .fillMaxWidth()
      .testTag("math_unit_card_${unit.unitNumber}")
  ) {
    Column(
      modifier = Modifier.padding(14.dp)
    ) {
      // Header: Unit Number Badge + Grade Tag + Category
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          // Unit Number Badge
          Box(
            modifier = Modifier
              .size(32.dp)
              .clip(RoundedCornerShape(8.dp))
              .background(unit.category.color),
            contentAlignment = Alignment.Center
          ) {
            Text(
              text = String.format("%02d", unit.unitNumber),
              fontWeight = FontWeight.Bold,
              fontSize = 13.sp,
              color = Color.White
            )
          }
          Spacer(modifier = Modifier.width(8.dp))
          Surface(
            color = if (unit.gradeTag.contains("11")) Color(0xFFECFDF5) else Color(0xFFEFF6FF),
            shape = RoundedCornerShape(6.dp),
            border = BorderStroke(
              1.dp,
              if (unit.gradeTag.contains("11")) Color(0xFFA7F3D0) else Color(0xFFBFDBFE)
            )
          ) {
            Text(
              text = unit.gradeTag,
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              color = if (unit.gradeTag.contains("11")) Color(0xFF047857) else Color(0xFF1D4ED8),
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
        }

        // Category Tag & PDF Page Badge
        Row(verticalAlignment = Alignment.CenterVertically) {
          val pageRange = SanduTheoryPdfBookletRepository.unitPageMapping[unit.unitNumber] ?: 1..1
          Surface(
            color = Color(0xFFF1F5F9),
            shape = RoundedCornerShape(4.dp),
            border = BorderStroke(1.dp, Color(0xFFCBD5E1))
          ) {
            Text(
              text = "PDF පිටු ${pageRange.first}-${pageRange.last}",
              fontSize = 9.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF475569),
              modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.width(6.dp))
          Text(unit.category.icon, fontSize = 11.sp)
          Spacer(modifier = Modifier.width(3.dp))
          Text(
            text = unit.category.displayName,
            fontSize = 10.sp,
            color = unit.category.color,
            fontWeight = FontWeight.SemiBold
          )
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      // Title
      Text(
        text = "${String.format("%02d", unit.unitNumber)}. ${unit.titleSinhala}",
        fontWeight = FontWeight.Bold,
        fontSize = 14.5.sp,
        color = Color(0xFF0F172A)
      )

      Spacer(modifier = Modifier.height(6.dp))

      // Key Formulas Container (Highlighted Box)
      if (unit.keyFormulas.isNotEmpty()) {
        Surface(
          color = Color(0xFFF1F5F9),
          shape = RoundedCornerShape(8.dp),
          border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(8.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text("⚡", fontSize = 11.sp)
              Spacer(modifier = Modifier.width(4.dp))
              Text(
                text = "ප්‍රධාන සූත්‍ර & සිද්ධාන්ත:",
                fontSize = 10.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0369A1)
              )
            }
            Spacer(modifier = Modifier.height(3.dp))
            unit.keyFormulas.take(2).forEach { formula ->
              Text(
                text = "• $formula",
                fontSize = 11.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF0F172A)
              )
            }
          }
        }
        Spacer(modifier = Modifier.height(6.dp))
      }

      // Theory Summary snippet
      Text(
        text = unit.theorySummary,
        fontSize = 11.5.sp,
        color = Color(0xFF475569),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        lineHeight = 16.sp
      )

      Spacer(modifier = Modifier.height(10.dp))

      // Footer Row: Exercise count + Action Button
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Icon(
            imageVector = Icons.Default.Quiz,
            contentDescription = "Exercises",
            tint = Color(0xFF64748B),
            modifier = Modifier.size(14.dp)
          )
          Spacer(modifier = Modifier.width(4.dp))
          Text(
            text = "අභ්‍යාස ${unit.practiceExercises.size} ක් & පිළිතුරු",
            fontSize = 10.5.sp,
            color = Color(0xFF64748B)
          )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
          Text(
            text = "සම්පූර්ණ සටහන බලන්න",
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2563EB)
          )
          Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = null,
            tint = Color(0xFF2563EB),
            modifier = Modifier.size(16.dp)
          )
        }
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MathUnitDetailDialog(
  unit: MathUnitShortNote,
  onDismiss: () -> Unit,
  onOpenPdfModal: ((url: String, title: String) -> Unit)?,
  onOpenSanduPage: ((page: Int) -> Unit)? = null
) {
  var selectedTab by remember { mutableIntStateOf(0) } // 0: Theory, 1: Worked Examples, 2: Practice & Answers
  val unitPageRange = SanduTheoryPdfBookletRepository.unitPageMapping[unit.unitNumber] ?: 1..1

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false)
  ) {
    Surface(
      shape = RoundedCornerShape(16.dp),
      color = Color(0xFFF8FAFC),
      modifier = Modifier
        .fillMaxWidth(0.96f)
        .fillMaxHeight(0.92f)
        .testTag("math_unit_detail_dialog")
    ) {
      Scaffold(
        topBar = {
          TopAppBar(
            title = {
              Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Surface(
                    color = unit.category.color,
                    shape = RoundedCornerShape(4.dp)
                  ) {
                    Text(
                      text = String.format("%02d", unit.unitNumber),
                      color = Color.White,
                      fontSize = 11.sp,
                      fontWeight = FontWeight.Bold,
                      modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                    )
                  }
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = unit.titleSinhala,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.5.sp,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                }
                Text(
                  text = "${unit.gradeTag} | Sandu PDF පිටු ${unitPageRange.first}-${unitPageRange.last}",
                  fontSize = 10.sp,
                  color = Color(0xFF94A3B8)
                )
              }
            },
            navigationIcon = {
              IconButton(onClick = onDismiss) {
                Icon(
                  imageVector = Icons.Default.Close,
                  contentDescription = "Close",
                  tint = Color.White
                )
              }
            },
            actions = {
              // Open in Sandu 100-page book reader
              IconButton(
                onClick = {
                  onOpenSanduPage?.invoke(unitPageRange.first)
                }
              ) {
                Icon(
                  imageVector = Icons.Default.MenuBook,
                  contentDescription = "Read PDF Book",
                  tint = Color(0xFFFDE047)
                )
              }
              // Direct PDF modal
              IconButton(
                onClick = {
                  onOpenPdfModal?.invoke(
                    "https://drive.google.com/file/d/1V3y65z_15X6zjruQ_I11WhG4EOfDHGm-/preview",
                    "${unit.unitNumber}. ${unit.titleSinhala} (Sandu Theory)"
                  )
                }
              ) {
                Icon(
                  imageVector = Icons.Default.PictureAsPdf,
                  contentDescription = "PDF",
                  tint = Color(0xFF38BDF8)
                )
              }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0F172A))
          )
        }
      ) { innerPadding ->
        Column(
          modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
        ) {
          // Tabs
          TabRow(
            selectedTabIndex = selectedTab,
            containerColor = Color.White,
            contentColor = Color(0xFF2563EB)
          ) {
            Tab(
              selected = selectedTab == 0,
              onClick = { selectedTab = 0 },
              text = { Text("📖 කෙටි සටහන", fontSize = 12.sp, fontWeight = FontWeight.Bold) }
            )
            Tab(
              selected = selectedTab == 1,
              onClick = { selectedTab = 1 },
              text = { Text("🧮 ආදර්ශ ගැටලු (${unit.workedExamples.size})", fontSize = 12.sp, fontWeight = FontWeight.Bold) }
            )
            Tab(
              selected = selectedTab == 2,
              onClick = { selectedTab = 2 },
              text = { Text("✍️ අභ්‍යාස & පිළිතුරු (${unit.practiceExercises.size})", fontSize = 12.sp, fontWeight = FontWeight.Bold) }
            )
          }

          // Tab Content
          Box(modifier = Modifier.fillMaxSize()) {
            when (selectedTab) {
              0 -> MathUnitTheoryTab(unit = unit, onOpenSanduPage = onOpenSanduPage)
              1 -> MathUnitExamplesTab(unit = unit)
              2 -> MathUnitPracticeTab(unit = unit)
            }
          }
        }
      }
    }
  }
}

@Composable
fun MathUnitTheoryTab(
  unit: MathUnitShortNote,
  onOpenSanduPage: ((page: Int) -> Unit)? = null
) {
  val unitPageRange = SanduTheoryPdfBookletRepository.unitPageMapping[unit.unitNumber] ?: 1..1
  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    contentPadding = PaddingValues(14.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    // 0. Sandu Theory PDF Reference Banner
    item {
      Surface(
        onClick = { onOpenSanduPage?.invoke(unitPageRange.first) },
        shape = RoundedCornerShape(10.dp),
        color = Color(0xFFEEF2FF),
        border = BorderStroke(1.dp, Color(0xFFA5B4FC)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
            Text("📕", fontSize = 18.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Column {
              Text(
                text = "Sandu Theory නිල PDF පිටු ${unitPageRange.first} - ${unitPageRange.last}",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color(0xFF3730A3)
              )
              Text(
                text = "මුද්‍රිත පොතේ පිටු, විවරණ සහ ගැටලු කියවන්න",
                fontSize = 10.5.sp,
                color = Color(0xFF4F46E5)
              )
            }
          }
          Surface(
            color = Color(0xFF4F46E5),
            shape = RoundedCornerShape(6.dp)
          ) {
            Text(
              text = "පිටුව ${unitPageRange.first}",
              color = Color.White,
              fontWeight = FontWeight.Bold,
              fontSize = 10.5.sp,
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
          }
        }
      }
    }
    // 1. Key Formulas Box
    if (unit.keyFormulas.isNotEmpty()) {
      item {
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F9FF)),
          border = BorderStroke(1.2.dp, Color(0xFF7DD3FC)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text("⚡", fontSize = 15.sp)
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = "මූලික සූත්‍ර හා සම්බන්ධතා (Key Formulas)",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = Color(0xFF0369A1)
              )
            }
            Spacer(modifier = Modifier.height(8.dp))
            unit.keyFormulas.forEach { formula ->
              Surface(
                color = Color.White,
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color(0xFFBAE6FD)),
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(vertical = 3.dp)
              ) {
                Text(
                  text = formula,
                  fontWeight = FontWeight.SemiBold,
                  fontSize = 12.5.sp,
                  color = Color(0xFF0C4A6E),
                  modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                )
              }
            }
          }
        }
      }
    }

    // 2. Main Theory Summary Card
    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text(
            text = "පාඩමේ සිද්ධාන්ත පැහැදිලි කිරීම",
            fontWeight = FontWeight.Bold,
            fontSize = 13.5.sp,
            color = Color(0xFF0F172A)
          )
          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = unit.theorySummary,
            fontSize = 12.5.sp,
            color = Color(0xFF334155),
            lineHeight = 18.sp
          )
        }
      }
    }

    // 3. Key Points Checklist
    if (unit.keyPoints.isNotEmpty()) {
      item {
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color.White),
          border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            Text(
              text = "මතක තබාගත යුතු වැදගත් කරුණු & නිදසුන්",
              fontWeight = FontWeight.Bold,
              fontSize = 13.sp,
              color = Color(0xFF0F172A)
            )
            Spacer(modifier = Modifier.height(8.dp))
            unit.keyPoints.forEach { point ->
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(vertical = 4.dp),
                verticalAlignment = Alignment.Top
              ) {
                Text("📌", fontSize = 12.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = point,
                  fontSize = 12.sp,
                  color = Color(0xFF334155),
                  lineHeight = 17.sp
                )
              }
            }
          }
        }
      }
    }

    // 4. Exam Tip Card
    if (unit.examTip.isNotEmpty()) {
      item {
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFFFEFCE8)),
          border = BorderStroke(1.dp, Color(0xFFFDE047)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.Top
          ) {
            Text("💡", fontSize = 16.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Column {
              Text(
                text = "O/L විභාග ඉඟිය (Exam Tip)",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color(0xFF854D0E)
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = unit.examTip,
                fontSize = 11.5.sp,
                color = Color(0xFF713F12),
                lineHeight = 16.sp
              )
            }
          }
        }
      }
    }
  }
}

@Composable
fun MathUnitExamplesTab(unit: MathUnitShortNote) {
  if (unit.workedExamples.isEmpty()) {
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(24.dp),
      contentAlignment = Alignment.Center
    ) {
      Text(
        text = "මෙම ඒකකය සඳහා ආදර්ශ ගැටලු ඉදිරියේදී යාවත්කාලීන වේ.",
        fontSize = 12.sp,
        color = Color(0xFF64748B)
      )
    }
  } else {
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      contentPadding = PaddingValues(14.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      items(unit.workedExamples) { example ->
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color.White),
          border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            // Question header
            Row(verticalAlignment = Alignment.CenterVertically) {
              Surface(
                color = Color(0xFFEFF6FF),
                shape = RoundedCornerShape(6.dp),
                border = BorderStroke(1.dp, Color(0xFFBFDBFE))
              ) {
                Text(
                  text = "ආදර්ශ ගැටලුව",
                  fontSize = 10.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF1D4ED8),
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
              text = example.question,
              fontWeight = FontWeight.Bold,
              fontSize = 13.sp,
              color = Color(0xFF0F172A),
              lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Steps
            Surface(
              color = Color(0xFFF8FAFC),
              shape = RoundedCornerShape(8.dp),
              border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(10.dp)) {
                Text(
                  text = "පියවරෙන් පියවර විසඳීම:",
                  fontWeight = FontWeight.SemiBold,
                  fontSize = 11.5.sp,
                  color = Color(0xFF475569)
                )
                Spacer(modifier = Modifier.height(6.dp))
                example.steps.forEachIndexed { idx, step ->
                  Row(
                    modifier = Modifier.padding(vertical = 2.dp),
                    verticalAlignment = Alignment.Top
                  ) {
                    Text(
                      text = "${idx + 1}.",
                      fontWeight = FontWeight.Bold,
                      fontSize = 11.5.sp,
                      color = Color(0xFF2563EB)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                      text = step,
                      fontSize = 12.sp,
                      color = Color(0xFF1E293B)
                    )
                  }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Final Answer Banner
                Surface(
                  color = Color(0xFFECFDF5),
                  shape = RoundedCornerShape(6.dp),
                  border = BorderStroke(1.dp, Color(0xFFA7F3D0)),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text("✅", fontSize = 13.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                      text = "අවසාන පිළිතුර: ${example.finalAnswer}",
                      fontWeight = FontWeight.Bold,
                      fontSize = 12.sp,
                      color = Color(0xFF047857)
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

@Composable
fun MathUnitPracticeTab(unit: MathUnitShortNote) {
  if (unit.practiceExercises.isEmpty()) {
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(24.dp),
      contentAlignment = Alignment.Center
    ) {
      Text(
        text = "මෙම ඒකකය සඳහා අභ්‍යාස ඉදිරියේදී යාවත්කාලීන වේ.",
        fontSize = 12.sp,
        color = Color(0xFF64748B)
      )
    }
  } else {
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      contentPadding = PaddingValues(14.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      items(unit.practiceExercises) { exercise ->
        var showAnswer by remember { mutableStateOf(false) }

        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color.White),
          border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            // Header
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Surface(
                color = Color(0xFFFAF5FF),
                shape = RoundedCornerShape(6.dp),
                border = BorderStroke(1.dp, Color(0xFFE9D5FF))
              ) {
                Text(
                  text = "අභ්‍යාස අංක ${exercise.questionNumber}",
                  fontSize = 10.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF7E22CE),
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }
              Text(
                text = "Sandu Theory අභ්‍යාස මාලාව",
                fontSize = 10.sp,
                color = Color(0xFF94A3B8)
              )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
              text = exercise.question,
              fontWeight = FontWeight.Bold,
              fontSize = 13.sp,
              color = Color(0xFF0F172A),
              lineHeight = 18.sp
            )

            // Multiple choice options if present
            exercise.options?.let { opts ->
              Spacer(modifier = Modifier.height(8.dp))
              Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                opts.forEachIndexed { idx, opt ->
                  Surface(
                    color = Color(0xFFF8FAFC),
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Text(
                      text = "(${idx + 1}) $opt",
                      fontSize = 11.5.sp,
                      color = Color(0xFF334155),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)
                    )
                  }
                }
              }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Reveal Answer Toggle Button
            OutlinedButton(
              onClick = { showAnswer = !showAnswer },
              shape = RoundedCornerShape(8.dp),
              colors = ButtonDefaults.outlinedButtonColors(
                contentColor = if (showAnswer) Color(0xFF047857) else Color(0xFF2563EB)
              ),
              border = BorderStroke(
                1.dp,
                if (showAnswer) Color(0xFF059669) else Color(0xFF2563EB)
              ),
              modifier = Modifier.fillMaxWidth()
            ) {
              Icon(
                imageVector = if (showAnswer) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
              )
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = if (showAnswer) "පිළිතුර සඟවන්න" else "නිවැරදි පිළිතුර & විවරණය බලන්න",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
              )
            }

            // Answer Box
            AnimatedVisibility(visible = showAnswer) {
              Surface(
                color = Color(0xFFECFDF5),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color(0xFFA7F3D0)),
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(top = 8.dp)
              ) {
                Column(modifier = Modifier.padding(10.dp)) {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("🎯", fontSize = 13.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                      text = "නිල පිළිතුර: ${exercise.correctAnswer}",
                      fontWeight = FontWeight.Bold,
                      fontSize = 12.5.sp,
                      color = Color(0xFF065F46)
                    )
                  }
                  if (exercise.explanation.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                      text = "විවරණය: ${exercise.explanation}",
                      fontSize = 11.5.sp,
                      color = Color(0xFF047857),
                      lineHeight = 16.sp
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

@Composable
fun MathQuickFormulaCalculatorDialog(
  onDismiss: () -> Unit
) {
  var selectedTool by remember { mutableIntStateOf(0) } // 0: Arithmetic Progression (Tn), 1: Cylinder Volume, 2: Simple Interest

  Dialog(onDismissRequest = onDismiss) {
    Card(
      shape = RoundedCornerShape(16.dp),
      colors = CardDefaults.cardColors(containerColor = Color.White),
      modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
    ) {
      Column(modifier = Modifier.padding(16.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text("🧮", fontSize = 20.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "ගණිත සූත්‍ර ගණකය",
              fontWeight = FontWeight.Bold,
              fontSize = 15.sp,
              color = Color(0xFF0F172A)
            )
          }
          IconButton(onClick = onDismiss) {
            Icon(Icons.Default.Close, contentDescription = "Close", tint = Color(0xFF64748B))
          }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Tool Selector Tabs
        TabRow(selectedTabIndex = selectedTool) {
          Tab(
            selected = selectedTool == 0,
            onClick = { selectedTool = 0 },
            text = { Text("Tn (ශ්‍රේඪි)", fontSize = 11.sp) }
          )
          Tab(
            selected = selectedTool == 1,
            onClick = { selectedTool = 1 },
            text = { Text("πr²h (සිලින්ඩර)", fontSize = 11.sp) }
          )
          Tab(
            selected = selectedTool == 2,
            onClick = { selectedTool = 2 },
            text = { Text("I = Ptr (පොලිය)", fontSize = 11.sp) }
          )
        }

        Spacer(modifier = Modifier.height(14.dp))

        when (selectedTool) {
          0 -> ArithmeticProgressionCalculator()
          1 -> CylinderVolumeCalculator()
          2 -> SimpleInterestCalculator()
        }
      }
    }
  }
}

@Composable
fun ArithmeticProgressionCalculator() {
  var aInput by remember { mutableStateOf("2") }
  var dInput by remember { mutableStateOf("3") }
  var nInput by remember { mutableStateOf("10") }

  val result = remember(aInput, dInput, nInput) {
    val a = aInput.toDoubleOrNull() ?: 0.0
    val d = dInput.toDoubleOrNull() ?: 0.0
    val n = nInput.toDoubleOrNull() ?: 1.0
    val tn = a + (n - 1) * d
    val sn = (n / 2.0) * (2 * a + (n - 1) * d)
    Pair(tn, sn)
  }

  Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
    Text(
      text = "සූත්‍ර: Tn = a + (n - 1)d | Sn = n/2[2a + (n-1)d]",
      fontSize = 11.sp,
      fontWeight = FontWeight.Bold,
      color = Color(0xFF0369A1)
    )

    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
      OutlinedTextField(
        value = aInput,
        onValueChange = { aInput = it },
        label = { Text("මුල් පදය a", fontSize = 10.sp) },
        modifier = Modifier.weight(1f),
        singleLine = true
      )
      OutlinedTextField(
        value = dInput,
        onValueChange = { dInput = it },
        label = { Text("අන්තරය d", fontSize = 10.sp) },
        modifier = Modifier.weight(1f),
        singleLine = true
      )
      OutlinedTextField(
        value = nInput,
        onValueChange = { nInput = it },
        label = { Text("පදය n", fontSize = 10.sp) },
        modifier = Modifier.weight(1f),
        singleLine = true
      )
    }

    Surface(
      color = Color(0xFFF0FDF4),
      shape = RoundedCornerShape(8.dp),
      border = BorderStroke(1.dp, Color(0xFFBBF7D0)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(10.dp)) {
        Text(
          text = "🎯 ${nInput} වන පදය (Tn) = ${result.first}",
          fontWeight = FontWeight.Bold,
          fontSize = 13.sp,
          color = Color(0xFF15803D)
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
          text = "📊 මුල් ${nInput} පද වල එකතුව (Sn) = ${result.second}",
          fontWeight = FontWeight.SemiBold,
          fontSize = 12.sp,
          color = Color(0xFF166534)
        )
      }
    }
  }
}

@Composable
fun CylinderVolumeCalculator() {
  var rInput by remember { mutableStateOf("7") }
  var hInput by remember { mutableStateOf("10") }

  val result = remember(rInput, hInput) {
    val r = rInput.toDoubleOrNull() ?: 0.0
    val h = hInput.toDoubleOrNull() ?: 0.0
    val v = (22.0 / 7.0) * r * r * h
    val curvedArea = 2 * (22.0 / 7.0) * r * h
    val totalArea = curvedArea + 2 * (22.0 / 7.0) * r * r
    Triple(v, curvedArea, totalArea)
  }

  Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
    Text(
      text = "සූත්‍ර: V = πr²h | වක්‍ර පෘෂ්ඨය = 2πrh",
      fontSize = 11.sp,
      fontWeight = FontWeight.Bold,
      color = Color(0xFF0369A1)
    )

    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
      OutlinedTextField(
        value = rInput,
        onValueChange = { rInput = it },
        label = { Text("අරය r (cm)", fontSize = 10.sp) },
        modifier = Modifier.weight(1f),
        singleLine = true
      )
      OutlinedTextField(
        value = hInput,
        onValueChange = { hInput = it },
        label = { Text("උස h (cm)", fontSize = 10.sp) },
        modifier = Modifier.weight(1f),
        singleLine = true
      )
    }

    Surface(
      color = Color(0xFFEFF6FF),
      shape = RoundedCornerShape(8.dp),
      border = BorderStroke(1.dp, Color(0xFFBFDBFE)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(10.dp)) {
        Text(
          text = "🎯 පරිමාව V = ${String.format("%.1f", result.first)} cm³",
          fontWeight = FontWeight.Bold,
          fontSize = 13.sp,
          color = Color(0xFF1D4ED8)
        )
        Text(
          text = "📐 වක්‍ර පෘෂ්ඨ වර්ගඵලය = ${String.format("%.1f", result.second)} cm²",
          fontSize = 11.5.sp,
          color = Color(0xFF1E40AF)
        )
        Text(
          text = "📦 මුළු පෘෂ්ඨ වර්ගඵලය = ${String.format("%.1f", result.third)} cm²",
          fontSize = 11.5.sp,
          color = Color(0xFF1E40AF)
        )
      }
    }
  }
}

@Composable
fun SimpleInterestCalculator() {
  var pInput by remember { mutableStateOf("20000") }
  var rInput by remember { mutableStateOf("12") }
  var tInput by remember { mutableStateOf("3") }

  val result = remember(pInput, rInput, tInput) {
    val p = pInput.toDoubleOrNull() ?: 0.0
    val r = rInput.toDoubleOrNull() ?: 0.0
    val t = tInput.toDoubleOrNull() ?: 0.0
    val annualInterest = p * (r / 100.0)
    val totalInterest = annualInterest * t
    val totalAmount = p + totalInterest
    Triple(annualInterest, totalInterest, totalAmount)
  }

  Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
    Text(
      text = "සූත්‍ර: I = P × r × t / 100 | මුළු මුදල = P + I",
      fontSize = 11.sp,
      fontWeight = FontWeight.Bold,
      color = Color(0xFF0369A1)
    )

    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
      OutlinedTextField(
        value = pInput,
        onValueChange = { pInput = it },
        label = { Text("මුදල P (රු.)", fontSize = 10.sp) },
        modifier = Modifier.weight(1.2f),
        singleLine = true
      )
      OutlinedTextField(
        value = rInput,
        onValueChange = { rInput = it },
        label = { Text("පොලිය r%", fontSize = 10.sp) },
        modifier = Modifier.weight(0.9f),
        singleLine = true
      )
      OutlinedTextField(
        value = tInput,
        onValueChange = { tInput = it },
        label = { Text("කාලය t (අවු.)", fontSize = 10.sp) },
        modifier = Modifier.weight(0.9f),
        singleLine = true
      )
    }

    Surface(
      color = Color(0xFFFFFBEB),
      shape = RoundedCornerShape(8.dp),
      border = BorderStroke(1.dp, Color(0xFFFDE68A)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(10.dp)) {
        Text(
          text = "🎯 මුළු පොලිය (I) = රු. ${String.format("%,.0f", result.second)}",
          fontWeight = FontWeight.Bold,
          fontSize = 13.sp,
          color = Color(0xFFB45309)
        )
        Text(
          text = "📅 වසරක පොලිය = රු. ${String.format("%,.0f", result.first)}",
          fontSize = 11.5.sp,
          color = Color(0xFF92400E)
        )
        Text(
          text = "💰 නිදහස් වීමට මුළු මුදල = රු. ${String.format("%,.0f", result.third)}",
          fontWeight = FontWeight.SemiBold,
          fontSize = 12.sp,
          color = Color(0xFF78350F)
        )
      }
    }
  }
}
