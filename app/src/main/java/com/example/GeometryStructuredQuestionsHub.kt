package com.example

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ==============================================================================
// GEOMETRY STRUCTURED QUESTIONS & RIDERS HUB (ජ්‍යාමිතිය ව්‍යුහගත විසඳුම්)
// 20 Categories x 20 Questions = 400 Total O/L Structured Geometry Questions
// ==============================================================================

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeometryStructuredQuestionsHubScreen(
  onBack: () -> Unit
) {
  val allCategories = remember { GeometryRepository.getAllCategories() }
  var selectedCategoryIndex by remember { mutableIntStateOf(0) }
  var selectedQuestionIndex by remember { mutableIntStateOf(0) }
  var searchQuery by remember { mutableStateOf("") }
  var selectedGradeFilter by remember { mutableStateOf("ALL") } // "ALL", "10", "11"
  var showStrategyModal by remember { mutableStateOf(false) }

  val filteredCategories = remember(allCategories, searchQuery, selectedGradeFilter) {
    allCategories.filter { item ->
      val matchesSearch = item.titleSinhala.contains(searchQuery, ignoreCase = true) ||
          item.theoremConcept.contains(searchQuery, ignoreCase = true) ||
          item.questions.any { it.structuredQuestionText.contains(searchQuery, ignoreCase = true) || it.questionTitle.contains(searchQuery, ignoreCase = true) }
      val matchesGrade = when (selectedGradeFilter) {
        "10" -> item.gradeLevel.contains("10")
        "11" -> item.gradeLevel.contains("11")
        else -> true
      }
      matchesSearch && matchesGrade
    }
  }

  val currentCategory = filteredCategories.getOrNull(selectedCategoryIndex) ?: allCategories.first()
  val safeQuestionIndex = selectedQuestionIndex.coerceIn(0, currentCategory.questions.lastIndex)
  val currentQuestion = currentCategory.questions[safeQuestionIndex]

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = "📐 ජ්‍යාමිතිය ව්‍යුහගත ප්‍රශ්න & අනුබද්ධ විසඳුම්",
              fontWeight = FontWeight.Bold,
              fontSize = 15.sp
            )
            Text(
              text = "කාණ්ඩ 20 • O/L ප්‍රමේය ව්‍යුහගත ප්‍රශ්න සහ අනුබද්ධ සාධන",
              fontSize = 11.sp,
              color = Color(0xFF64748B)
            )
          }
        },
        navigationIcon = {
          IconButton(onClick = onBack, modifier = Modifier.testTag("geometry_back_button")) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
          }
        },
        actions = {
          IconButton(onClick = { showStrategyModal = true }, modifier = Modifier.testTag("geometry_strategy_btn")) {
            Icon(Icons.Default.Lightbulb, contentDescription = "Exam Strategy", tint = Color(0xFFD97706))
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
      )
    }
  ) { padding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(padding)
        .background(Color(0xFFF1F5F9))
    ) {
      // Search and Filter Header
      Surface(
        color = Color.White,
        shadowElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)) {
          OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("ප්‍රමේය හෝ ප්‍රශ්න සොයන්න (උදා: චක්‍රීය, ස්පර්ශක, මධ්‍ය ලක්ෂ්‍ය)...", fontSize = 12.sp) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF64748B)) },
            trailingIcon = {
              if (searchQuery.isNotBlank()) {
                IconButton(onClick = { searchQuery = "" }) {
                  Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color(0xFF94A3B8))
                }
              }
            },
            singleLine = true,
            modifier = Modifier
              .fillMaxWidth()
              .height(48.dp),
            shape = RoundedCornerShape(10.dp)
          )

          Spacer(modifier = Modifier.height(6.dp))

          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
              FilterChip(
                selected = selectedGradeFilter == "ALL",
                onClick = { selectedGradeFilter = "ALL"; selectedCategoryIndex = 0; selectedQuestionIndex = 0 },
                label = { Text("සියලු කාණ්ඩ 20", fontSize = 11.sp, fontWeight = FontWeight.Bold) }
              )
              FilterChip(
                selected = selectedGradeFilter == "10",
                onClick = { selectedGradeFilter = "10"; selectedCategoryIndex = 0; selectedQuestionIndex = 0 },
                label = { Text("10 ශ්‍රේණිය", fontSize = 11.sp) }
              )
              FilterChip(
                selected = selectedGradeFilter == "11",
                onClick = { selectedGradeFilter = "11"; selectedCategoryIndex = 0; selectedQuestionIndex = 0 },
                label = { Text("11 O/L", fontSize = 11.sp) }
              )
            }

            TextButton(
              onClick = { showStrategyModal = true },
              contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp)
            ) {
              Icon(Icons.Default.MenuBook, contentDescription = "Strategy", modifier = Modifier.size(15.dp), tint = Color(0xFF2563EB))
              Spacer(modifier = Modifier.width(3.dp))
              Text("විසඳන ක්‍රමය", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2563EB))
            }
          }
        }
      }

      // Horizontal Category Selector Chips (1 to 20)
      LazyRow(
        modifier = Modifier
          .fillMaxWidth()
          .background(Color.White)
          .padding(horizontal = 10.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        itemsIndexed(filteredCategories) { index, item ->
          val isSelected = index == selectedCategoryIndex
          Surface(
            onClick = {
              selectedCategoryIndex = index
              selectedQuestionIndex = 0
            },
            shape = RoundedCornerShape(16.dp),
            color = if (isSelected) Color(0xFF2563EB) else Color(0xFFF1F5F9),
            border = BorderStroke(1.dp, if (isSelected) Color(0xFF1D4ED8) else Color(0xFFCBD5E1)),
            modifier = Modifier.padding(vertical = 2.dp)
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = "${item.categoryId}.",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = if (isSelected) Color(0xFFFEF08A) else Color(0xFF2563EB)
              )
              Spacer(modifier = Modifier.width(4.dp))
              Text(
                text = item.shortTitle,
                fontSize = 11.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                color = if (isSelected) Color.White else Color(0xFF1E293B)
              )
            }
          }
        }
      }

      // Horizontal Question Number Selector Chips (1 to 20)
      Surface(
        color = Color(0xFFF8FAFC),
        border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(vertical = 6.dp)) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 12.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = if (currentCategory.questions.size > 1) "ප්‍රශ්න අංකය (1 - ${currentCategory.questions.size}):" else "ව්‍යුහගත ප්‍රශ්නය:",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF475569)
            )
            Text(
              text = "ප්‍රශ්නය ${currentQuestion.questionNumber} / ${currentCategory.questions.size} (කාණ්ඩය ${currentCategory.categoryId})",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF2563EB)
            )
          }

          LazyRow(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 10.dp, vertical = 3.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
          ) {
            items(currentCategory.questions.indices.toList()) { qIdx ->
              val isQSelected = qIdx == safeQuestionIndex
              Surface(
                onClick = { selectedQuestionIndex = qIdx },
                shape = RoundedCornerShape(8.dp),
                color = if (isQSelected) Color(0xFF16A34A) else Color.White,
                border = BorderStroke(1.dp, if (isQSelected) Color(0xFF15803D) else Color(0xFFCBD5E1)),
                modifier = Modifier.size(width = 36.dp, height = 30.dp)
              ) {
                Box(contentAlignment = Alignment.Center) {
                  Text(
                    text = "${qIdx + 1}",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isQSelected) Color.White else Color(0xFF334155)
                  )
                }
              }
            }
          }
        }
      }

      // Main Content: Detailed Question, Canvas Diagram, Proof Steps & Rider
      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
          .padding(horizontal = 14.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
      ) {
        // Category Header Card
        item {
          Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Surface(
                  color = Color(0xFFEFF6FF),
                  shape = RoundedCornerShape(6.dp),
                  border = BorderStroke(1.dp, Color(0xFFBFDBFE))
                ) {
                  Text(
                    text = "කාණ්ඩය ${currentCategory.categoryId} / 20",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E40AF),
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                  )
                }

                Surface(
                  color = Color(0xFFFEF3C7),
                  shape = RoundedCornerShape(6.dp)
                ) {
                  Text(
                    text = currentCategory.gradeLevel,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFB45309),
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                  )
                }
              }

              Spacer(modifier = Modifier.height(6.dp))

              Text(
                text = currentCategory.titleSinhala,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0F172A)
              )

              Spacer(modifier = Modifier.height(6.dp))

              Surface(
                color = Color(0xFFF8FAFC),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(10.dp)) {
                  Row(verticalAlignment = Alignment.Top) {
                    Text("📜", fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Column {
                      Text("ප්‍රමේය සංකල්පය:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF475569))
                      Text(currentCategory.theoremConcept, fontSize = 11.5.sp, color = Color(0xFF1E293B), lineHeight = 16.sp)
                    }
                  }
                  Spacer(modifier = Modifier.height(6.dp))
                  Row(verticalAlignment = Alignment.Top) {
                    Text("💡", fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Column {
                      Text("විසඳන මූලික ක්‍රමය:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E40AF))
                      Text(currentCategory.generalSolvingStrategy, fontSize = 11.sp, color = Color(0xFF334155), lineHeight = 15.sp)
                    }
                  }
                }
              }
            }
          }
        }

        // Geometric Visual Canvas Diagram
        item {
          GeometricDiagramCanvas(diagramType = currentCategory.diagramType)
        }

        // Structured Question Box
        item {
          Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color(0xFFE2E8F0))
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Icon(Icons.Default.Assignment, contentDescription = "Question", tint = Color(0xFF2563EB), modifier = Modifier.size(18.dp))
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = "ප්‍රශ්නය ${currentQuestion.questionNumber}: ${currentQuestion.questionTitle}",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E293B)
                  )
                }
                Surface(color = Color(0xFFEFF6FF), shape = RoundedCornerShape(4.dp)) {
                  Text("10 Marks", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1D4ED8), modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                }
              }

              Spacer(modifier = Modifier.height(10.dp))

              Text(
                text = currentQuestion.structuredQuestionText,
                fontSize = 12.5.sp,
                color = Color(0xFF1E293B),
                lineHeight = 19.sp,
                fontWeight = FontWeight.Medium
              )

              Spacer(modifier = Modifier.height(10.dp))
              HorizontalDivider(color = Color(0xFFE2E8F0))
              Spacer(modifier = Modifier.height(10.dp))

              // Given and To Prove Breakdown
              Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                  Text("📌 දත්තය (Given):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0284C7))
                  Text(currentQuestion.givenData, fontSize = 11.5.sp, color = Color(0xFF334155))
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column(modifier = Modifier.weight(1f)) {
                  Text("🎯 සාධනය කළ යුත්ත:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFDC2626))
                  Text(currentQuestion.toProve, fontSize = 11.5.sp, color = Color(0xFF334155))
                }
              }

              if (currentQuestion.construction != "අවශ්‍ය නොවේ." && currentQuestion.construction != "අවශ්‍ය නොවේ") {
                Spacer(modifier = Modifier.height(8.dp))
                Text("✏️ අවශ්‍ය නිර්මාණය (Construction):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFD97706))
                Text(currentQuestion.construction, fontSize = 11.5.sp, color = Color(0xFF475569))
              }
            }
          }
        }

        // Step-by-Step Proof Table (Statements & Reasons)
        item {
          Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color(0xFFCBD5E1))
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Icon(Icons.Default.CheckCircle, contentDescription = "Proof", tint = Color(0xFF16A34A), modifier = Modifier.size(18.dp))
                  Spacer(modifier = Modifier.width(6.dp))
                  Text("පියවරෙන් පියවර සාධනය (Proof & Reasons):", fontSize = 12.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E293B))
                }
                Surface(color = Color(0xFFDCFCE7), shape = RoundedCornerShape(6.dp)) {
                  Text("100% සම්මත", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF15803D), modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                }
              }

              Spacer(modifier = Modifier.height(10.dp))

              // Table Header
              Surface(
                color = Color(0xFFF1F5F9),
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)) {
                  Text("ප්‍රකාශය (Statement)", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF334155), modifier = Modifier.weight(1.2f))
                  Text("හේතුව / ප්‍රමේයය (Reason)", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF334155), modifier = Modifier.weight(1.4f))
                }
              }

              Spacer(modifier = Modifier.height(4.dp))

              // Steps
              currentQuestion.proofSteps.forEachIndexed { sIdx, step ->
                Surface(
                  color = if (sIdx % 2 == 0) Color.White else Color(0xFFF8FAFC),
                  shape = RoundedCornerShape(4.dp),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.Top
                  ) {
                    Text(
                      text = "${sIdx + 1}. ${step.statement}",
                      fontSize = 11.5.sp,
                      color = Color(0xFF0F172A),
                      fontWeight = FontWeight.Medium,
                      modifier = Modifier.weight(1.2f)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                      text = "(${step.reason})",
                      fontSize = 10.5.sp,
                      color = Color(0xFF0284C7),
                      modifier = Modifier.weight(1.4f)
                    )
                  }
                }
              }
            }
          }
        }

        // Sub-Parts / Rider Practice Question
        item {
          Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF0FDF4)),
            border = BorderStroke(1.dp, Color(0xFFBBF7D0))
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Extension, contentDescription = "Rider", tint = Color(0xFF16A34A), modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text("අනුබද්ධ ප්‍රශ්න සහ විසඳන ආකාරය (Rider Part):", fontSize = 12.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF14532D))
              }

              Spacer(modifier = Modifier.height(6.dp))

              Text(
                text = currentQuestion.riderExplanation,
                fontSize = 11.5.sp,
                color = Color(0xFF166534),
                lineHeight = 16.sp
              )

              Spacer(modifier = Modifier.height(10.dp))

              val rider = currentQuestion.riderQuestion
              Surface(
                color = Color.White,
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color(0xFF86EFAC)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(10.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(rider.subNumber, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF15803D))
                    Surface(color = Color(0xFFDCFCE7), shape = RoundedCornerShape(4.dp)) {
                      Text("පිළිතුර: ${rider.finalAnswer}", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF166534), modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                    }
                  }

                  Spacer(modifier = Modifier.height(4.dp))
                  Text(rider.questionText, fontSize = 11.5.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF1E293B))

                  Spacer(modifier = Modifier.height(6.dp))
                  Text("විසඳන පියවර:", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF64748B))

                  rider.solutionSteps.forEach { step ->
                    Row(modifier = Modifier.padding(vertical = 1.dp)) {
                      Text("• ", fontSize = 11.sp, color = Color(0xFF16A34A), fontWeight = FontWeight.Bold)
                      Text(step, fontSize = 10.5.sp, color = Color(0xFF334155))
                    }
                  }
                }
              }
            }
          }
        }

        // Exam Tips Banner
        item {
          Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFBEB)),
            border = BorderStroke(1.dp, Color(0xFFFDE68A))
          ) {
            Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.Top) {
              Icon(Icons.Default.TipsAndUpdates, contentDescription = "Tips", tint = Color(0xFFD97706), modifier = Modifier.size(18.dp))
              Spacer(modifier = Modifier.width(8.dp))
              Column {
                Text("විභාග ලකුණු ලබාගැනීමේ රහස (Exam Tip):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF92400E))
                Spacer(modifier = Modifier.height(2.dp))
                Text(currentQuestion.examTips, fontSize = 11.sp, color = Color(0xFF78350F), lineHeight = 15.sp)
              }
            }
          }
        }

        // Previous and Next Question Navigation Buttons
        item {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            OutlinedButton(
              onClick = {
                if (safeQuestionIndex > 0) {
                  selectedQuestionIndex = safeQuestionIndex - 1
                } else if (selectedCategoryIndex > 0) {
                  selectedCategoryIndex--
                  selectedQuestionIndex = 19
                }
              },
              enabled = safeQuestionIndex > 0 || selectedCategoryIndex > 0,
              shape = RoundedCornerShape(8.dp)
            ) {
              Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Previous", modifier = Modifier.size(16.dp))
              Spacer(modifier = Modifier.width(4.dp))
              Text("පෙර ප්‍රශ්නය", fontSize = 11.sp)
            }

            Button(
              onClick = {
                if (safeQuestionIndex < currentCategory.questions.lastIndex) {
                  selectedQuestionIndex = safeQuestionIndex + 1
                } else if (selectedCategoryIndex < filteredCategories.lastIndex) {
                  selectedCategoryIndex++
                  selectedQuestionIndex = 0
                }
              },
              enabled = safeQuestionIndex < currentCategory.questions.lastIndex || selectedCategoryIndex < filteredCategories.lastIndex,
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB)),
              shape = RoundedCornerShape(8.dp)
            ) {
              Text("ඊළඟ ප්‍රශ්නය", fontSize = 11.sp)
              Spacer(modifier = Modifier.width(4.dp))
              Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Next", modifier = Modifier.size(16.dp))
            }
          }
        }

        item {
          Spacer(modifier = Modifier.height(16.dp))
        }
      }
    }
  }

  // Strategy Modal: How to Solve Geometry Structured Questions (විසඳන පියවර 5)
  if (showStrategyModal) {
    AlertDialog(
      onDismissRequest = { showStrategyModal = false },
      title = {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Icon(Icons.Default.School, contentDescription = "Guide", tint = Color(0xFF2563EB))
          Spacer(modifier = Modifier.width(8.dp))
          Text("ජ්‍යාමිතිය ව්‍යුහගත විසඳන පියවර 5", fontWeight = FontWeight.Bold, fontSize = 15.sp)
        }
      },
      text = {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
          Text(
            text = "සාමාන්‍ය පෙළ (O/L) ගණිතය II වන පත්‍රයේ B කොටසේ ලකුණු 10ක ප්‍රධාන ප්‍රශ්නයට 10න් 10ම ලබාගැනීමේ සම්මත පියවර:",
            fontSize = 12.sp,
            color = Color(0xFF475569),
            lineHeight = 17.sp
          )
          Spacer(modifier = Modifier.height(10.dp))

          val steps = listOf(
            "1. රූප සටහන ලකුණු කිරීම" to "ප්‍රශ්නයේ ඇති දත්ත (සමාන පාද, සමාන කෝණ, ලම්බක, සමාන්තර රේඛා) රූප සටහනේ පැහැදිලිව සලකුණු කරන්න.",
            "2. දත්තය හා සාධනය කළ යුත්ත ලිවීම" to "දත්තය සහ ඔප්පු කළ යුතු දේ සංකේතාත්මකව වෙන වෙනම ලියන්න (ලකුණු 1-2 ලැබේ).",
            "3. නිර්මාණය (අවශ්‍ය නම් පමණි)" to "ලක්ෂ්‍ය යා කිරීම හෝ ලම්බක ඇඳීම අවශ්‍ය නම් තිත් ඉරිවලින් ඇඳ විස්තරය ලියන්න.",
            "4. හේතු සහිතව සාධනය (Proof & Reasons)" to "සෑම ප්‍රකාශනයකටම දකුණු පසින් වරහන් තුළ නිවැරදි ජ්‍යාමිතික ප්‍රමේයය හෝ හේතුව ලියන්න. හේතුව නැතිව ලකුණු නොලැබේ.",
            "5. අනුබද්ධ කොටස (Rider) විසඳීම" to "පළමු සාධනයේ ප්‍රතිඵලය හෝ සමරූපී අනුපාත කෙළින්ම යොදා සංඛ්‍යාත්මක අගයන් හෝ දිගවල් ගණනය කරන්න."
          )

          steps.forEach { (title, desc) ->
            Surface(
              color = Color(0xFFF8FAFC),
              shape = RoundedCornerShape(8.dp),
              border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
              modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp)
            ) {
              Column(modifier = Modifier.padding(10.dp)) {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color(0xFF1E40AF))
                Spacer(modifier = Modifier.height(2.dp))
                Text(desc, fontSize = 11.sp, color = Color(0xFF334155), lineHeight = 15.sp)
              }
            }
          }
        }
      },
      confirmButton = {
        Button(
          onClick = { showStrategyModal = false },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB))
        ) {
          Text("තේරුණා (Close)", fontSize = 12.sp)
        }
      }
    )
  }
}
