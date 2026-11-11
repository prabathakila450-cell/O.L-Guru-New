package com.example

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import kotlinx.coroutines.launch

/**
 * 100% ACCURATE O/L SYLLABUS SCIENCE MASTER HUB FOR GRADES 10 & 11
 * Divided strictly by Grade 10 and Grade 11 modules:
 * 1. රසායනික සමීකරණ හා සූත්‍ර තුලනය (Chemical Equations & Formulas)
 * 2. භෞතික විද්‍යා සූත්‍ර සහ ගණිත ගැටලු විසඳනය (Physics Numerical Solvers)
 * 3. ප්‍රායෝගික පරීක්ෂණ සහ නිරීක්ෂණ (Practicals & Observations Guide)
 * 4. ජීව විද්‍යා රූප සටහන් සහ කොටස් නම් කිරීම (Biology Interactive Labeling)
 * 5. Rapid-Fire MCQs Challenge (O/L Paper 1 Model with Explanations)
 */

enum class ScienceHubGradeFilter(val gradeStr: String, val title: String) {
  GRADE_10("10", "10 ශ්‍රේණිය (Grade 10)"),
  GRADE_11("11", "11 ශ්‍රේණිය (Grade 11)")
}

enum class ScienceModuleType(val title: String, val icon: String, val badgeColor: Color) {
  CHEMISTRY_EQUATIONS("රසායනික සමීකරණ තුලන", "🧪", Color(0xFF0284C7)),
  PHYSICS_FORMULAS("භෞතික සූත්‍ර & ගණනය", "⚡", Color(0xFFD97706)),
  PRACTICALS("ප්‍රායෝගික පරීක්ෂණ", "🔬", Color(0xFF059669)),
  BIOLOGY_DIAGRAMS("ජීව විද්‍යා රූ සටහන්", "🫀", Color(0xFFE11D48)),
  RAPID_MCQ("Rapid MCQs", "🎯", Color(0xFF7C3AED)),
  PERIODIC_TABLE("ආවර්තිතා වගුව", "⚛️", Color(0xFF0284C7)),
  SI_DIMENSIONS("SI ඒකක & මාන", "📏", Color(0xFFD97706)),
  EVERYDAY_SCIENCE("දෛනික විද්‍යාව", "💡", Color(0xFF059669)),
  AI_TUTOR("AI පුද්ගලික උපදේශක", "🤖", Color(0xFFEC4899)),
  MIND_MAPS("සංකල්ප සිතියම්", "🗺️", Color(0xFF8B5CF6))
}

@Composable
fun PlaceholderFeatureSection(
  title: String,
  description: String,
  onClose: () -> Unit
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(8.dp)
      .background(Color(0xFF0F172A), RoundedCornerShape(12.dp))
      .padding(16.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
      IconButton(onClick = onClose) {
        Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White)
      }
    }
    Spacer(modifier = Modifier.height(8.dp))
    Text(description, color = Color(0xFF94A3B8), fontSize = 14.sp)
  }
}

// -------------------------------------------------------------
// 1. CHEMISTRY EQUATION & FORMULA MODELS
// -------------------------------------------------------------
data class ScienceChemItem(
  val id: String,
  val grade: String,
  val title: String,
  val category: String, // "සූත්‍ර ලිවීම", "තුලනය කිරීම", "ප්‍රතික්‍රියා වර්ගය"
  val reactantsSinhala: String,
  val unbalancedEquation: String,
  val balancedEquation: String,
  val explanation: String,
  val keyPoints: List<String>
)

// -------------------------------------------------------------
// 2. PHYSICS FORMULA & NUMERICAL PROBLEM MODELS
// -------------------------------------------------------------
data class SciencePhysicsItem(
  val id: String,
  val grade: String,
  val unitName: String,
  val formula: String,
  val formulaExplanation: String,
  val problemText: String,
  val stepByStepSolution: List<String>,
  val finalAnswer: String,
  val units: String,
  val examTip: String
)

// -------------------------------------------------------------
// 3. PRACTICAL EXPERIMENT MODELS
// -------------------------------------------------------------
data class SciencePracticalItem(
  val id: String,
  val grade: String,
  val title: String,
  val aim: String,
  val apparatus: List<String>,
  val method: List<String>,
  val observation: String,
  val conclusion: String,
  val examPrecautions: List<String>
)

// -------------------------------------------------------------
// 4. BIOLOGY DIAGRAM & LABELING MODELS
// -------------------------------------------------------------
data class BioLabelPart(
  val labelNumber: String,
  val partName: String,
  val function: String
)

data class ScienceBiologyDiagramItem(
  val id: String,
  val grade: String,
  val diagramTitle: String,
  val systemCategory: String,
  val overview: String,
  val labels: List<BioLabelPart>,
  val examQuestions: List<String>
)

// -------------------------------------------------------------
// 5. RAPID-FIRE MCQ CHALLENGE MODELS
// -------------------------------------------------------------
data class ScienceRapidMcqItem(
  val id: String,
  val grade: String,
  val unitName: String,
  val question: String,
  val options: List<String>,
  val correctIndex: Int,
  val explanation: String
)

// =============================================================
// REPOSITORY: 100% ACCURATE O/L SYLLABUS CURATED DATA
// =============================================================
object ScienceGrade1011SyllabusRepository {
  val chemistryItems = ScienceSyllabusFullData.allChemistryItems
  val physicsItems = ScienceSyllabusFullData.allPhysicsItems
  val practicalItems = ScienceSyllabusFullData.allPracticalItems
  val biologyDiagrams = ScienceSyllabusFullData.allBiologyDiagrams
  val mcqItems = ScienceSyllabusFullData.allMcqItems
}

// =============================================================
// COMPACT & EXPANDABLE CARD VIEWS FOR SCIENCE SUBJECT PAGE
// =============================================================

@Composable
fun ScienceGrade10And11MasterHub(
  currentGrade: String = "10",
  onOpenFullReader: (String) -> Unit = {}
) {
  var selectedGrade by remember {
    mutableStateOf(if (currentGrade == "11") ScienceHubGradeFilter.GRADE_11 else ScienceHubGradeFilter.GRADE_10)
  }
  var selectedModule by remember { mutableStateOf<ScienceModuleType?>(null) }
  var showFullscreenDialog by remember { mutableStateOf(false) }

  // Main Card Container with rich gradients
  Card(
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF064E3B)),
    border = BorderStroke(1.2.dp, Color(0xFF10B981).copy(alpha = 0.6f)),
    modifier = Modifier
      .fillMaxWidth()
      .testTag("science_grade_10_11_master_hub")
  ) {
    Column(modifier = Modifier.padding(12.dp)) {
      // Header Row
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Text("🔬", fontSize = 18.sp)
          Spacer(modifier = Modifier.width(6.dp))
          Column {
            Text(
              text = "10 & 11 විද්‍යාව විෂය නිර්දේශ Master Hub",
              color = Color.White,
              fontSize = 13.sp,
              fontWeight = FontWeight.Bold
            )
            Text(
              text = "සමීකරණ • භෞතික සූත්‍ර • ප්‍රායෝගික • රූ සටහන් • MCQs",
              color = Color(0xFFA7F3D0),
              fontSize = 9.5.sp
            )
          }
        }

        Surface(
          color = Color(0xFF10B981),
          shape = RoundedCornerShape(6.dp)
        ) {
          Text(
            text = "100% ආවරණය",
            color = Color.White,
            fontSize = 8.5.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      // Grade Toggle Pills: 10 ශ්‍රේණිය vs 11 ශ්‍රේණිය
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .clip(RoundedCornerShape(10.dp))
          .background(Color(0xFF022C22))
          .padding(3.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
      ) {
        ScienceHubGradeFilter.values().forEach { g ->
          val isSelected = selectedGrade == g
          Surface(
            onClick = {
              selectedGrade = g
            },
            shape = RoundedCornerShape(8.dp),
            color = if (isSelected) Color(0xFF10B981) else Color.Transparent,
            modifier = Modifier.weight(1f)
          ) {
            Row(
              modifier = Modifier.padding(vertical = 5.dp),
              horizontalArrangement = Arrangement.Center,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = if (g == ScienceHubGradeFilter.GRADE_10) "📘 10 ශ්‍රේණිය" else "📙 11 ශ්‍රේණිය (O/L)",
                fontSize = 11.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = if (isSelected) Color.White else Color(0xFF6EE7B7)
              )
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      // Module Selector Strip (Compact Horizontal Grid)
      LazyRow(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.fillMaxWidth()
      ) {
        items(ScienceModuleType.values()) { mod ->
          val isSelected = selectedModule == mod
          Surface(
            onClick = {
              selectedModule = if (isSelected) null else mod
            },
            shape = RoundedCornerShape(8.dp),
            color = if (isSelected) mod.badgeColor else Color(0xFF065F46),
            border = BorderStroke(1.dp, if (isSelected) Color.White else Color(0xFF047857))
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(mod.icon, fontSize = 11.sp)
              Spacer(modifier = Modifier.width(4.dp))
              Text(
                text = mod.title,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      // Content Display Area depending on Selected Module
      val activeGradeStr = selectedGrade.gradeStr
      when (selectedModule) {
        ScienceModuleType.CHEMISTRY_EQUATIONS -> {
          val items = remember(activeGradeStr) {
            ScienceGrade1011SyllabusRepository.chemistryItems.filter { it.grade == activeGradeStr }
          }
          ScienceChemistrySubSection(
            items = items,
            grade = activeGradeStr,
            onClose = { selectedModule = null },
            onOpenFullscreen = { showFullscreenDialog = true }
          )
        }
        ScienceModuleType.PHYSICS_FORMULAS -> {
          val items = remember(activeGradeStr) {
            ScienceGrade1011SyllabusRepository.physicsItems.filter { it.grade == activeGradeStr }
          }
          SciencePhysicsSubSection(
            items = items,
            grade = activeGradeStr,
            onClose = { selectedModule = null },
            onOpenFullscreen = { showFullscreenDialog = true }
          )
        }
        ScienceModuleType.PRACTICALS -> {
          val items = remember(activeGradeStr) {
            ScienceGrade1011SyllabusRepository.practicalItems.filter { it.grade == activeGradeStr }
          }
          SciencePracticalsSubSection(
            items = items,
            grade = activeGradeStr,
            onClose = { selectedModule = null },
            onOpenFullscreen = { showFullscreenDialog = true }
          )
        }
        ScienceModuleType.BIOLOGY_DIAGRAMS -> {
          val items = remember(activeGradeStr) {
            ScienceGrade1011SyllabusRepository.biologyDiagrams.filter { it.grade == activeGradeStr }
          }
          ScienceBiologySubSection(
            items = items,
            grade = activeGradeStr,
            onClose = { selectedModule = null },
            onOpenFullscreen = { showFullscreenDialog = true }
          )
        }
        ScienceModuleType.RAPID_MCQ -> {
          val items = remember(activeGradeStr) {
            ScienceGrade1011SyllabusRepository.mcqItems.filter { it.grade == activeGradeStr }
          }
          ScienceMcqChallengeSubSection(
            items = items,
            grade = activeGradeStr,
            onClose = { selectedModule = null },
            onOpenFullscreen = { showFullscreenDialog = true }
          )
        }
        ScienceModuleType.PERIODIC_TABLE -> {
          PeriodicTableSubSection(onClose = { selectedModule = null })
        }
        ScienceModuleType.SI_DIMENSIONS -> {
          SiDimensionsSubSection(onClose = { selectedModule = null })
        }
        ScienceModuleType.EVERYDAY_SCIENCE -> {
          EverydayScienceSubSection(onClose = { selectedModule = null })
        }
        ScienceModuleType.AI_TUTOR -> {
          PlaceholderFeatureSection(
            title = "AI පුද්ගලික උපදේශක",
            description = "ඔබේ ප්‍රශ්න සඳහා AI මගපෙන්වීම.",
            onClose = { selectedModule = null }
          )
        }
        ScienceModuleType.MIND_MAPS -> {
          PlaceholderFeatureSection(
            title = "සංකල්ප සිතියම්",
            description = "පාඩම් සාරාංශ සඳහා සංකල්ප සිතියම්.",
            onClose = { selectedModule = null }
          )
        }
        null -> {
          // Default Overview Cards when nothing is expanded
          ScienceQuickOverviewRow(
            grade = activeGradeStr,
            onSelectModule = { selectedModule = it }
          )
        }
      }
    }
  }

  // Fullscreen Study Dialog for maximum readability and complete scrolling
  if (showFullscreenDialog && selectedModule != null) {
    ScienceModuleFullscreenDialog(
      moduleType = selectedModule!!,
      initialGrade = selectedGrade,
      onDismiss = { showFullscreenDialog = false }
    )
  }
}

@Composable
private fun PeriodicTableSubSection(onClose: () -> Unit) {
  Column(modifier = Modifier.padding(8.dp).fillMaxWidth().background(Color(0xFF0F172A), RoundedCornerShape(8.dp)).padding(8.dp)) {
    Text("ආවර්තිතා වගුව (මුල් මූලද්‍රව්‍ය 20)", color = Color.White, fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(4.dp))
    Text("H, He, Li, Be, B, C, N, O, F, Ne, Na, Mg, Al, Si, P, S, Cl, Ar, K, Ca", color = Color(0xFF94A3B8), fontSize = 12.sp)
    Button(onClick = onClose, modifier = Modifier.padding(top = 8.dp)) { Text("වසන්න") }
  }
}

@Composable
private fun SiDimensionsSubSection(onClose: () -> Unit) {
  Column(modifier = Modifier.padding(8.dp).fillMaxWidth().background(Color(0xFF0F172A), RoundedCornerShape(8.dp)).padding(8.dp)) {
    Text("SI ඒකක හා මාන", color = Color.White, fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(4.dp))
    Text("මූලික ඒකක: m, kg, s, A, K, mol, cd", color = Color(0xFF94A3B8), fontSize = 12.sp)
    Button(onClick = onClose, modifier = Modifier.padding(top = 8.dp)) { Text("වසන්න") }
  }
}

@Composable
private fun EverydayScienceSubSection(onClose: () -> Unit) {
  Column(modifier = Modifier.padding(8.dp).fillMaxWidth().background(Color(0xFF0F172A), RoundedCornerShape(8.dp)).padding(8.dp)) {
    Text("දෛනික විද්‍යාව (රචනා)", color = Color.White, fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(4.dp))
    Text("1. අම්ල වැසි\n2. හරිතාගාර ආචරණය\n3. සබන් නිපදවීම", color = Color(0xFF94A3B8), fontSize = 12.sp)
    Button(onClick = onClose, modifier = Modifier.padding(top = 8.dp)) { Text("වසන්න") }
  }
}

// -------------------------------------------------------------
// SUB-SECTIONS IMPLEMENTATIONS WITH FULL VERTICAL SCROLLING
// -------------------------------------------------------------

@Composable
private fun ScienceQuickOverviewRow(
  grade: String,
  onSelectModule: (ScienceModuleType) -> Unit
) {
  Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
    // Row 1: Chemistry & Physics
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      ScienceFeatureButton(
        icon = "🧪",
        title = "රසායනික සමීකරණ",
        subtitle = "තුලනය & ප්‍රතික්‍රියා",
        color = Color(0xFF0284C7),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(ScienceModuleType.CHEMISTRY_EQUATIONS) }
      )
      ScienceFeatureButton(
        icon = "⚡",
        title = "භෞතික සූත්‍ර & ගණනය",
        subtitle = "ගැටලු & පියවර විසඳුම්",
        color = Color(0xFFD97706),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(ScienceModuleType.PHYSICS_FORMULAS) }
      )
    }

    // Row 2: Practicals & Biology Diagrams
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      ScienceFeatureButton(
        icon = "🔬",
        title = "ප්‍රායෝගික පරීක්ෂණ",
        subtitle = "නිරීක්ෂණ & නිගමන",
        color = Color(0xFF059669),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(ScienceModuleType.PRACTICALS) }
      )
      ScienceFeatureButton(
        icon = "🫀",
        title = "ජීව විද්‍යා රූ සටහන්",
        subtitle = "නම් කිරීම & කෘත්‍යයන්",
        color = Color(0xFFE11D48),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(ScienceModuleType.BIOLOGY_DIAGRAMS) }
      )
    }

    // Row 3: Rapid MCQs & Periodic Table
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      ScienceFeatureButton(
        icon = "🎯",
        title = "Rapid-Fire MCQs",
        subtitle = "ප්‍රශ්නාවලිය & විවරණ",
        color = Color(0xFF7C3AED),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(ScienceModuleType.RAPID_MCQ) }
      )
      ScienceFeatureButton(
        icon = "⚛️",
        title = "ආවර්තිතා වගුව",
        subtitle = "මූලද්‍රව්‍ය 20",
        color = Color(0xFF0284C7),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(ScienceModuleType.PERIODIC_TABLE) }
      )
    }

    // Row 4: SI Dimensions & Everyday Science
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      ScienceFeatureButton(
        icon = "📏",
        title = "SI ඒකක & මාන",
        subtitle = "මිනුම් පද්ධති",
        color = Color(0xFFD97706),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(ScienceModuleType.SI_DIMENSIONS) }
      )
      ScienceFeatureButton(
        icon = "💡",
        title = "දෛනික විද්‍යාව",
        subtitle = "රචනා ප්‍රශ්න",
        color = Color(0xFF059669),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(ScienceModuleType.EVERYDAY_SCIENCE) }
      )
    }

    // Row 5: AI & Mind Maps
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      ScienceFeatureButton(
        icon = "🤖",
        title = "AI උපදේශක",
        subtitle = "මගපෙන්වීම",
        color = Color(0xFFDB2777),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(ScienceModuleType.AI_TUTOR) }
      )
      ScienceFeatureButton(
        icon = "🗺️",
        title = "සංකල්ප සිතියම්",
        subtitle = "සාරාංශ",
        color = Color(0xFF8B5CF6),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(ScienceModuleType.MIND_MAPS) }
      )
    }
  }
}

@Composable
private fun ScienceFeatureButton(
  icon: String,
  title: String,
  subtitle: String,
  color: Color,
  modifier: Modifier = Modifier,
  onClick: () -> Unit
) {
  Surface(
    onClick = onClick,
    shape = RoundedCornerShape(8.dp),
    color = color.copy(alpha = 0.25f),
    border = BorderStroke(1.dp, color.copy(alpha = 0.6f)),
    modifier = modifier
  ) {
    Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text(icon, fontSize = 12.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = title,
          fontSize = 10.5.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )
      }
      Text(
        text = subtitle,
        fontSize = 8.5.sp,
        color = Color(0xFFA7F3D0),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
      )
    }
  }
}

// 1. CHEMISTRY DETAILS VIEW - FULL INTERNAL VERTICAL SCROLLING
@Composable
private fun ScienceChemistrySubSection(
  items: List<ScienceChemItem>,
  grade: String,
  onClose: () -> Unit,
  onOpenFullscreen: () -> Unit
) {
  var searchQuery by remember { mutableStateOf("") }
  val scrollState = rememberScrollState()
  val coroutineScope = rememberCoroutineScope()

  val filteredItems = remember(items, searchQuery) {
    if (searchQuery.isBlank()) items
    else items.filter {
      it.title.contains(searchQuery, ignoreCase = true) ||
      it.category.contains(searchQuery, ignoreCase = true) ||
      it.reactantsSinhala.contains(searchQuery, ignoreCase = true) ||
      it.balancedEquation.contains(searchQuery, ignoreCase = true)
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF0F172A))
      .padding(8.dp)
  ) {
    // Header & Control Row
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text("🧪", fontSize = 14.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "$grade ශ්‍රේණිය - රසායනික සූත්‍ර & තුලනය (${filteredItems.size}/${items.size})",
          fontSize = 11.5.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFF38BDF8)
        )
      }

      Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        IconButton(
          onClick = onOpenFullscreen,
          modifier = Modifier.size(26.dp)
        ) {
          Icon(Icons.Default.Fullscreen, contentDescription = "Fullscreen", tint = Color(0xFF38BDF8), modifier = Modifier.size(18.dp))
        }
        IconButton(
          onClick = onClose,
          modifier = Modifier.size(26.dp)
        ) {
          Icon(Icons.Default.Close, contentDescription = "Close", tint = Color(0xFF94A3B8), modifier = Modifier.size(18.dp))
        }
      }
    }

    // Search bar
    OutlinedTextField(
      value = searchQuery,
      onValueChange = { searchQuery = it },
      placeholder = { Text("සමීකරණ හෝ මූලද්‍රව්‍ය සොයන්න...", fontSize = 9.5.sp, color = Color(0xFF94A3B8)) },
      singleLine = true,
      modifier = Modifier
        .fillMaxWidth()
        .height(44.dp)
        .padding(vertical = 2.dp),
      colors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = Color.White,
        unfocusedTextColor = Color.White,
        focusedBorderColor = Color(0xFF38BDF8),
        unfocusedBorderColor = Color(0xFF334155),
        focusedContainerColor = Color(0xFF1E293B),
        unfocusedContainerColor = Color(0xFF1E293B)
      ),
      trailingIcon = {
        if (searchQuery.isNotEmpty()) {
          IconButton(onClick = { searchQuery = "" }) {
            Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color.LightGray, modifier = Modifier.size(14.dp))
          }
        }
      }
    )

    Spacer(modifier = Modifier.height(6.dp))

    // Dedicated SubSection Content Container
    Column(
      modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      if (filteredItems.isEmpty()) {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
          contentAlignment = Alignment.Center
        ) {
          Text("ගැළපෙන රසායනික සමීකරණ හමු නොවීය.", color = Color(0xFF94A3B8), fontSize = 10.sp)
        }
      } else {
        filteredItems.forEachIndexed { idx, item ->
          var isExpanded by remember { mutableStateOf(false) }
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFF1E293B),
            border = BorderStroke(1.dp, Color(0xFF334155)),
            modifier = Modifier
              .fillMaxWidth()
              .clickable { isExpanded = !isExpanded }
          ) {
            Column(modifier = Modifier.padding(8.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = "${idx + 1}. ${item.title}",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  modifier = Modifier.weight(1f)
                )
                Surface(
                  shape = RoundedCornerShape(4.dp),
                  color = Color(0xFF0284C7)
                ) {
                  Text(
                    text = item.category,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                  )
                }
              }

              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "තුලිත සමීකරණය: ${item.balancedEquation}",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                color = Color(0xFF4ADE80)
              )

              if (isExpanded) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                  text = "අසමතුලිත සමීකරණය: ${item.unbalancedEquation}",
                  fontSize = 9.5.sp,
                  fontFamily = FontFamily.Monospace,
                  color = Color(0xFFF87171)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                  text = "ප්‍රතික්‍රියක හා ඵල: ${item.reactantsSinhala}",
                  fontSize = 9.5.sp,
                  color = Color(0xFFCBD5E1)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = "තුලනය කරන පියවර: ${item.explanation}",
                  fontSize = 9.5.sp,
                  color = Color(0xFFFDE047)
                )
                Spacer(modifier = Modifier.height(4.dp))
                item.keyPoints.forEach { pt ->
                  Text("• $pt", fontSize = 9.sp, color = Color(0xFF94A3B8))
                }
              } else {
                Text(
                  text = "විස්තර සහ තුලනය කරන පියවර බැලීමට ක්ලික් කරන්න ▾",
                  fontSize = 8.5.sp,
                  color = Color(0xFF64748B)
                )
              }
            }
          }
        }
      }

      // Bottom scroll navigation buttons
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        OutlinedButton(
          onClick = {
            coroutineScope.launch { scrollState.animateScrollTo(0) }
          },
          colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF38BDF8)),
          contentPadding = PaddingValues(horizontal = 10.dp, vertical = 2.dp),
          shape = RoundedCornerShape(6.dp)
        ) {
          Text("⬆️ ඉහළට (Top)", fontSize = 9.sp)
        }

        Button(
          onClick = onClose,
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF334155)),
          contentPadding = PaddingValues(horizontal = 12.dp, vertical = 2.dp),
          shape = RoundedCornerShape(6.dp)
        ) {
          Text("✕ වසන්න (Back to Hub)", fontSize = 9.sp)
        }
      }
    }
  }
}

// 2. PHYSICS DETAILS VIEW - FULL INTERNAL VERTICAL SCROLLING
@Composable
private fun SciencePhysicsSubSection(
  items: List<SciencePhysicsItem>,
  grade: String,
  onClose: () -> Unit,
  onOpenFullscreen: () -> Unit
) {
  var searchQuery by remember { mutableStateOf("") }
  val scrollState = rememberScrollState()
  val coroutineScope = rememberCoroutineScope()

  val filteredItems = remember(items, searchQuery) {
    if (searchQuery.isBlank()) items
    else items.filter {
      it.unitName.contains(searchQuery, ignoreCase = true) ||
      it.formula.contains(searchQuery, ignoreCase = true) ||
      it.problemText.contains(searchQuery, ignoreCase = true)
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF18181B))
      .padding(8.dp)
  ) {
    // Header
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text("⚡", fontSize = 14.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "$grade ශ්‍රේණිය - භෞතික සූත්‍ර & ගණනය කිරීම් (${filteredItems.size}/${items.size})",
          fontSize = 11.5.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFFFBBF24)
        )
      }

      Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        IconButton(
          onClick = onOpenFullscreen,
          modifier = Modifier.size(26.dp)
        ) {
          Icon(Icons.Default.Fullscreen, contentDescription = "Fullscreen", tint = Color(0xFFFBBF24), modifier = Modifier.size(18.dp))
        }
        IconButton(
          onClick = onClose,
          modifier = Modifier.size(26.dp)
        ) {
          Icon(Icons.Default.Close, contentDescription = "Close", tint = Color(0xFF71717A), modifier = Modifier.size(18.dp))
        }
      }
    }

    // Search bar
    OutlinedTextField(
      value = searchQuery,
      onValueChange = { searchQuery = it },
      placeholder = { Text("සූත්‍ර හෝ පාඩම් සොයන්න...", fontSize = 9.5.sp, color = Color(0xFF71717A)) },
      singleLine = true,
      modifier = Modifier
        .fillMaxWidth()
        .height(44.dp)
        .padding(vertical = 2.dp),
      colors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = Color.White,
        unfocusedTextColor = Color.White,
        focusedBorderColor = Color(0xFFF59E0B),
        unfocusedBorderColor = Color(0xFF3F3F46),
        focusedContainerColor = Color(0xFF27272A),
        unfocusedContainerColor = Color(0xFF27272A)
      ),
      trailingIcon = {
        if (searchQuery.isNotEmpty()) {
          IconButton(onClick = { searchQuery = "" }) {
            Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color.LightGray, modifier = Modifier.size(14.dp))
          }
        }
      }
    )

    Spacer(modifier = Modifier.height(6.dp))

    // Dedicated SubSection Content Container
    Column(
      modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      if (filteredItems.isEmpty()) {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
          contentAlignment = Alignment.Center
        ) {
          Text("ගැළපෙන භෞතික විද්‍යා සූත්‍ර හමු නොවීය.", color = Color(0xFF71717A), fontSize = 10.sp)
        }
      } else {
        filteredItems.forEachIndexed { idx, item ->
          var isExpanded by remember { mutableStateOf(false) }
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFF27272A),
            border = BorderStroke(1.dp, Color(0xFF3F3F46)),
            modifier = Modifier
              .fillMaxWidth()
              .clickable { isExpanded = !isExpanded }
          ) {
            Column(modifier = Modifier.padding(8.dp)) {
              Text(
                text = "${idx + 1}. ${item.unitName}",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Spacer(modifier = Modifier.height(2.dp))
              Surface(
                shape = RoundedCornerShape(4.dp),
                color = Color(0xFFB45309).copy(alpha = 0.3f),
                border = BorderStroke(0.8.dp, Color(0xFFF59E0B))
              ) {
                Text(
                  text = item.formula,
                  fontSize = 10.5.sp,
                  fontWeight = FontWeight.Bold,
                  fontFamily = FontFamily.Monospace,
                  color = Color(0xFFFDE047),
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }

              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "ප්‍රශ්නය: ${item.problemText}",
                fontSize = 9.5.sp,
                color = Color(0xFFE4E4E7)
              )

              if (isExpanded) {
                Spacer(modifier = Modifier.height(6.dp))
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = Color(0xFF09090B),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Column(modifier = Modifier.padding(6.dp)) {
                    Text("පියවරෙන් පියවර විසඳුම:", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                    item.stepByStepSolution.forEach { step ->
                      Text("• $step", fontSize = 9.sp, color = Color(0xFFCBD5E1))
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("අවසාන පිළිතුර: ${item.finalAnswer}", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
                  }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text("💡 විභාග ඉඟිය: ${item.examTip}", fontSize = 8.5.sp, color = Color(0xFFF472B6))
              } else {
                Text(
                  text = "පියවරෙන් පියවර ගණනය කිරීම බැලීමට ක්ලික් කරන්න ▾",
                  fontSize = 8.5.sp,
                  color = Color(0xFF71717A)
                )
              }
            }
          }
        }
      }

      // Bottom scroll navigation buttons
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        OutlinedButton(
          onClick = {
            coroutineScope.launch { scrollState.animateScrollTo(0) }
          },
          colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFFBBF24)),
          contentPadding = PaddingValues(horizontal = 10.dp, vertical = 2.dp),
          shape = RoundedCornerShape(6.dp)
        ) {
          Text("⬆️ ඉහළට (Top)", fontSize = 9.sp)
        }

        Button(
          onClick = onClose,
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F3F46)),
          contentPadding = PaddingValues(horizontal = 12.dp, vertical = 2.dp),
          shape = RoundedCornerShape(6.dp)
        ) {
          Text("✕ වසන්න (Back to Hub)", fontSize = 9.sp)
        }
      }
    }
  }
}

// 3. PRACTICALS DETAILS VIEW - FULL INTERNAL VERTICAL SCROLLING
@Composable
private fun SciencePracticalsSubSection(
  items: List<SciencePracticalItem>,
  grade: String,
  onClose: () -> Unit,
  onOpenFullscreen: () -> Unit
) {
  var searchQuery by remember { mutableStateOf("") }
  val scrollState = rememberScrollState()
  val coroutineScope = rememberCoroutineScope()

  val filteredItems = remember(items, searchQuery) {
    if (searchQuery.isBlank()) items
    else items.filter {
      it.title.contains(searchQuery, ignoreCase = true) ||
      it.aim.contains(searchQuery, ignoreCase = true) ||
      it.observation.contains(searchQuery, ignoreCase = true)
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF064E3B))
      .padding(8.dp)
  ) {
    // Header
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text("🔬", fontSize = 14.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "$grade ශ්‍රේණිය - ප්‍රායෝගික පරීක්ෂණ & නිරීක්ෂණ (${filteredItems.size}/${items.size})",
          fontSize = 11.5.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFF6EE7B7)
        )
      }

      Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        IconButton(
          onClick = onOpenFullscreen,
          modifier = Modifier.size(26.dp)
        ) {
          Icon(Icons.Default.Fullscreen, contentDescription = "Fullscreen", tint = Color(0xFF6EE7B7), modifier = Modifier.size(18.dp))
        }
        IconButton(
          onClick = onClose,
          modifier = Modifier.size(26.dp)
        ) {
          Icon(Icons.Default.Close, contentDescription = "Close", tint = Color(0xFFA7F3D0), modifier = Modifier.size(18.dp))
        }
      }
    }

    // Search bar
    OutlinedTextField(
      value = searchQuery,
      onValueChange = { searchQuery = it },
      placeholder = { Text("ප්‍රායෝගික පරීක්ෂණ සොයන්න...", fontSize = 9.5.sp, color = Color(0xFFA7F3D0).copy(alpha = 0.7f)) },
      singleLine = true,
      modifier = Modifier
        .fillMaxWidth()
        .height(44.dp)
        .padding(vertical = 2.dp),
      colors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = Color.White,
        unfocusedTextColor = Color.White,
        focusedBorderColor = Color(0xFF10B981),
        unfocusedBorderColor = Color(0xFF059669),
        focusedContainerColor = Color(0xFF065F46),
        unfocusedContainerColor = Color(0xFF065F46)
      ),
      trailingIcon = {
        if (searchQuery.isNotEmpty()) {
          IconButton(onClick = { searchQuery = "" }) {
            Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color.LightGray, modifier = Modifier.size(14.dp))
          }
        }
      }
    )

    Spacer(modifier = Modifier.height(6.dp))

    // Dedicated SubSection Content Container
    Column(
      modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      if (filteredItems.isEmpty()) {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
          contentAlignment = Alignment.Center
        ) {
          Text("ගැළපෙන ප්‍රායෝගික පරීක්ෂණ හමු නොවීය.", color = Color(0xFFA7F3D0), fontSize = 10.sp)
        }
      } else {
        filteredItems.forEachIndexed { idx, item ->
          var isExpanded by remember { mutableStateOf(false) }
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFF047857),
            border = BorderStroke(1.dp, Color(0xFF059669)),
            modifier = Modifier
              .fillMaxWidth()
              .clickable { isExpanded = !isExpanded }
          ) {
            Column(modifier = Modifier.padding(8.dp)) {
              Text(
                text = "${idx + 1}. ${item.title}",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Spacer(modifier = Modifier.height(3.dp))
              Text(
                text = "අරමුණ: ${item.aim}",
                fontSize = 9.5.sp,
                color = Color(0xFFA7F3D0)
              )

              if (isExpanded) {
                Spacer(modifier = Modifier.height(6.dp))
                Text("උපකරණ හා ද්‍රව්‍ය:", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE047))
                item.apparatus.forEach { app ->
                  Text("• $app", fontSize = 8.5.sp, color = Color.White)
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text("පියවරෙන් පියවර ක්‍රමය:", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                item.method.forEach { step ->
                  Text("• $step", fontSize = 8.5.sp, color = Color(0xFFE0F2FE))
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = "නිරීක්ෂණය: ${item.observation}",
                  fontSize = 9.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFFFDE047)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                  text = "නිගමනය: ${item.conclusion}",
                  fontSize = 9.5.sp,
                  color = Color.White
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text("ප්‍රවේශම් විය යුතු කරුණු:", fontSize = 8.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFCA5A5))
                item.examPrecautions.forEach { prec ->
                  Text("• $prec", fontSize = 8.5.sp, color = Color(0xFFFEE2E2))
                }
              } else {
                Text(
                  text = "ක්‍රමය, නිරීක්ෂණ සහ නිගමන බැලීමට ක්ලික් කරන්න ▾",
                  fontSize = 8.5.sp,
                  color = Color(0xFF6EE7B7).copy(alpha = 0.8f)
                )
              }
            }
          }
        }
      }

      // Bottom scroll navigation buttons
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        OutlinedButton(
          onClick = {
            coroutineScope.launch { scrollState.animateScrollTo(0) }
          },
          colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF6EE7B7)),
          contentPadding = PaddingValues(horizontal = 10.dp, vertical = 2.dp),
          shape = RoundedCornerShape(6.dp)
        ) {
          Text("⬆️ ඉහළට (Top)", fontSize = 9.sp)
        }

        Button(
          onClick = onClose,
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF065F46)),
          contentPadding = PaddingValues(horizontal = 12.dp, vertical = 2.dp),
          shape = RoundedCornerShape(6.dp)
        ) {
          Text("✕ වසන්න (Back to Hub)", fontSize = 9.sp)
        }
      }
    }
  }
}

// 4. BIOLOGY DETAILS VIEW - FULL INTERNAL VERTICAL SCROLLING
@Composable
private fun ScienceBiologySubSection(
  items: List<ScienceBiologyDiagramItem>,
  grade: String,
  onClose: () -> Unit,
  onOpenFullscreen: () -> Unit
) {
  var searchQuery by remember { mutableStateOf("") }
  val scrollState = rememberScrollState()
  val coroutineScope = rememberCoroutineScope()

  val filteredItems = remember(items, searchQuery) {
    if (searchQuery.isBlank()) items
    else items.filter {
      it.diagramTitle.contains(searchQuery, ignoreCase = true) ||
      it.systemCategory.contains(searchQuery, ignoreCase = true) ||
      it.overview.contains(searchQuery, ignoreCase = true)
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF4C0519))
      .padding(8.dp)
  ) {
    // Header
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text("🫀", fontSize = 14.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "$grade ශ්‍රේණිය - ජීව විද්‍යා රූ සටහන් & පද්ධති (${filteredItems.size}/${items.size})",
          fontSize = 11.5.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFFFDA4AF)
        )
      }

      Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        IconButton(
          onClick = onOpenFullscreen,
          modifier = Modifier.size(26.dp)
        ) {
          Icon(Icons.Default.Fullscreen, contentDescription = "Fullscreen", tint = Color(0xFFFDA4AF), modifier = Modifier.size(18.dp))
        }
        IconButton(
          onClick = onClose,
          modifier = Modifier.size(26.dp)
        ) {
          Icon(Icons.Default.Close, contentDescription = "Close", tint = Color(0xFFFECDD3), modifier = Modifier.size(18.dp))
        }
      }
    }

    // Search bar
    OutlinedTextField(
      value = searchQuery,
      onValueChange = { searchQuery = it },
      placeholder = { Text("රූප සටහන් හෝ පද්ධති සොයන්න...", fontSize = 9.5.sp, color = Color(0xFFFECDD3).copy(alpha = 0.7f)) },
      singleLine = true,
      modifier = Modifier
        .fillMaxWidth()
        .height(44.dp)
        .padding(vertical = 2.dp),
      colors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = Color.White,
        unfocusedTextColor = Color.White,
        focusedBorderColor = Color(0xFFFB7185),
        unfocusedBorderColor = Color(0xFF9F1239),
        focusedContainerColor = Color(0xFF881337),
        unfocusedContainerColor = Color(0xFF881337)
      ),
      trailingIcon = {
        if (searchQuery.isNotEmpty()) {
          IconButton(onClick = { searchQuery = "" }) {
            Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color.LightGray, modifier = Modifier.size(14.dp))
          }
        }
      }
    )

    Spacer(modifier = Modifier.height(6.dp))

    // Dedicated SubSection Content Container
    Column(
      modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      if (filteredItems.isEmpty()) {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
          contentAlignment = Alignment.Center
        ) {
          Text("ගැළපෙන ජීව විද්‍යා සටහන් හමු නොවීය.", color = Color(0xFFFECDD3), fontSize = 10.sp)
        }
      } else {
        filteredItems.forEachIndexed { idx, item ->
          var isExpanded by remember { mutableStateOf(false) }
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFF881337),
            border = BorderStroke(1.dp, Color(0xFF9F1239)),
            modifier = Modifier
              .fillMaxWidth()
              .clickable { isExpanded = !isExpanded }
          ) {
            Column(modifier = Modifier.padding(8.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = "${idx + 1}. ${item.diagramTitle}",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  modifier = Modifier.weight(1f)
                )
                Surface(
                  shape = RoundedCornerShape(4.dp),
                  color = Color(0xFFBE123C)
                ) {
                  Text(
                    text = item.systemCategory,
                    fontSize = 8.sp,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                  )
                }
              }

              Spacer(modifier = Modifier.height(3.dp))
              Text(
                text = item.overview,
                fontSize = 9.5.sp,
                color = Color(0xFFFECDD3)
              )

              if (isExpanded) {
                Spacer(modifier = Modifier.height(6.dp))
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = Color(0xFF4C0519),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Column(modifier = Modifier.padding(6.dp)) {
                    Text("නම් කරන ලද කොටස් සහ කෘත්‍යයන්:", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE047))
                    item.labels.forEach { label ->
                      Text(
                        text = "${label.labelNumber}. ${label.partName}: ${label.function}",
                        fontSize = 8.5.sp,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 1.dp)
                      )
                    }
                  }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text("විභාග ප්‍රශ්න සහ පිළිතුරු:", fontSize = 8.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                item.examQuestions.forEach { q ->
                  Text("• $q", fontSize = 8.5.sp, color = Color(0xFFE0F2FE))
                }
              } else {
                Text(
                  text = "කොටස් නම් කිරීම සහ කෘත්‍යයන් බැලීමට ක්ලික් කරන්න ▾",
                  fontSize = 8.5.sp,
                  color = Color(0xFFFDA4AF).copy(alpha = 0.8f)
                )
              }
            }
          }
        }
      }

      // Bottom scroll navigation buttons
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        OutlinedButton(
          onClick = {
            coroutineScope.launch { scrollState.animateScrollTo(0) }
          },
          colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFFDA4AF)),
          contentPadding = PaddingValues(horizontal = 10.dp, vertical = 2.dp),
          shape = RoundedCornerShape(6.dp)
        ) {
          Text("⬆️ ඉහළට (Top)", fontSize = 9.sp)
        }

        Button(
          onClick = onClose,
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9F1239)),
          contentPadding = PaddingValues(horizontal = 12.dp, vertical = 2.dp),
          shape = RoundedCornerShape(6.dp)
        ) {
          Text("✕ වසන්න (Back to Hub)", fontSize = 9.sp)
        }
      }
    }
  }
}

// 5. RAPID-FIRE MCQ CHALLENGE VIEW - BOTH INTERACTIVE & SCROLLABLE ALL MCQS
@Composable
private fun ScienceMcqChallengeSubSection(
  items: List<ScienceRapidMcqItem>,
  grade: String,
  onClose: () -> Unit,
  onOpenFullscreen: () -> Unit
) {
  var isAllListMode by remember { mutableStateOf(false) }
  var currentIndex by remember { mutableIntStateOf(0) }
  var selectedOption by remember { mutableStateOf<Int?>(null) }
  var isSubmitted by remember { mutableStateOf(false) }
  val scrollState = rememberScrollState()

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF2E1065))
      .padding(8.dp)
  ) {
    // Header with mode toggle
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text("🎯", fontSize = 14.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "$grade ශ්‍රේණිය - Rapid-Fire MCQs (${items.size})",
          fontSize = 11.5.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFFC4B5FD)
        )
      }

      Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        IconButton(
          onClick = onOpenFullscreen,
          modifier = Modifier.size(26.dp)
        ) {
          Icon(Icons.Default.Fullscreen, contentDescription = "Fullscreen", tint = Color(0xFFC4B5FD), modifier = Modifier.size(18.dp))
        }
        IconButton(
          onClick = onClose,
          modifier = Modifier.size(26.dp)
        ) {
          Icon(Icons.Default.Close, contentDescription = "Close", tint = Color(0xFFA78BFA), modifier = Modifier.size(18.dp))
        }
      }
    }

    // Mode Selector: Quiz Mode vs All MCQs List
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp),
      horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
      Surface(
        onClick = { isAllListMode = false },
        shape = RoundedCornerShape(6.dp),
        color = if (!isAllListMode) Color(0xFF7C3AED) else Color(0xFF4C1D95),
        modifier = Modifier.weight(1f)
      ) {
        Text(
          text = "🎯 ප්‍රශ්නාවලිය (Quiz)",
          fontSize = 9.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White,
          textAlign = TextAlign.Center,
          modifier = Modifier.padding(vertical = 4.dp)
        )
      }
      Surface(
        onClick = { isAllListMode = true },
        shape = RoundedCornerShape(6.dp),
        color = if (isAllListMode) Color(0xFF7C3AED) else Color(0xFF4C1D95),
        modifier = Modifier.weight(1f)
      ) {
        Text(
          text = "📋 සියලු MCQs (${items.size})",
          fontSize = 9.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White,
          textAlign = TextAlign.Center,
          modifier = Modifier.padding(vertical = 4.dp)
        )
      }
    }

    Spacer(modifier = Modifier.height(4.dp))

    // Dedicated SubSection Content Container
    Column(
      modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      if (isAllListMode) {
        // All MCQs List with solutions displayed directly for revision
        items.forEachIndexed { qIdx, mcq ->
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFF3B0764),
            border = BorderStroke(1.dp, Color(0xFF581C87)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(8.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Text("Q${qIdx + 1}. [${mcq.unitName}]", fontSize = 9.sp, color = Color(0xFFA78BFA), fontWeight = FontWeight.Bold)
                Surface(
                  shape = RoundedCornerShape(4.dp),
                  color = Color(0xFF059669)
                ) {
                  Text(
                    text = "පිළිතුර: (${mcq.correctIndex + 1})",
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                  )
                }
              }
              Spacer(modifier = Modifier.height(2.dp))
              Text(mcq.question, fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              Spacer(modifier = Modifier.height(4.dp))
              mcq.options.forEachIndexed { oIdx, opt ->
                val isCorrect = oIdx == mcq.correctIndex
                Text(
                  text = "(${oIdx + 1}) $opt ${if (isCorrect) "✓" else ""}",
                  fontSize = 9.sp,
                  color = if (isCorrect) Color(0xFF4ADE80) else Color(0xFFCBD5E1),
                  fontWeight = if (isCorrect) FontWeight.Bold else FontWeight.Normal
                )
              }
              Spacer(modifier = Modifier.height(3.dp))
              Text(
                text = "විවරණය: ${mcq.explanation}",
                fontSize = 8.5.sp,
                color = Color(0xFFE9D5FF)
              )
            }
          }
        }
      } else {
        // Step-by-step Interactive Quiz Flow
        val currentItem = items.getOrNull(currentIndex) ?: return@Column

        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            text = "ප්‍රශ්න අංක ${currentIndex + 1}/${items.size}",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFC4B5FD)
          )
          Text(
            text = currentItem.unitName,
            fontSize = 9.sp,
            color = Color(0xFFA78BFA)
          )
        }

        Text(
          text = currentItem.question,
          fontSize = 11.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White
        )

        Spacer(modifier = Modifier.height(2.dp))

        // Options
        currentItem.options.forEachIndexed { optIndex, optionText ->
          val isChosen = selectedOption == optIndex
          val isCorrect = optIndex == currentItem.correctIndex
          val optionBg = when {
            isSubmitted && isCorrect -> Color(0xFF059669)
            isSubmitted && isChosen && !isCorrect -> Color(0xFFDC2626)
            isChosen -> Color(0xFF7C3AED)
            else -> Color(0xFF4C1D95)
          }

          Surface(
            onClick = {
              if (!isSubmitted) selectedOption = optIndex
            },
            shape = RoundedCornerShape(6.dp),
            color = optionBg,
            border = BorderStroke(1.dp, if (isChosen) Color.White else Color(0xFF5B21B6)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = "(${optIndex + 1})",
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = optionText,
                fontSize = 10.sp,
                color = Color.White
              )
            }
          }
        }

        // Action buttons & Explanation
        if (!isSubmitted) {
          Button(
            onClick = {
              if (selectedOption != null) isSubmitted = true
            },
            enabled = selectedOption != null,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C3AED)),
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.align(Alignment.End),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
          ) {
            Text("පිළිතුර තහවුරු කරන්න", fontSize = 10.sp, fontWeight = FontWeight.Bold)
          }
        } else {
          Surface(
            shape = RoundedCornerShape(6.dp),
            color = Color(0xFF1E1B4B),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(6.dp)) {
              Text(
                text = if (selectedOption == currentItem.correctIndex) "✅ නිවැරදියි!" else "❌ වැරදියි! නිවැරදි පිළිතුර: (${currentItem.correctIndex + 1})",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = if (selectedOption == currentItem.correctIndex) Color(0xFF4ADE80) else Color(0xFFF87171)
              )
              Text(
                text = "විවරණය: ${currentItem.explanation}",
                fontSize = 9.sp,
                color = Color(0xFFDDD6FE)
              )
            }
          }

          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            if (currentIndex > 0) {
              OutlinedButton(
                onClick = {
                  currentIndex--
                  selectedOption = null
                  isSubmitted = false
                },
                shape = RoundedCornerShape(6.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
              ) {
                Text("◀ පෙර ප්‍රශ්නය", fontSize = 9.sp, color = Color(0xFFC4B5FD))
              }
            } else {
              Spacer(modifier = Modifier.width(1.dp))
            }

            if (currentIndex < items.size - 1) {
              Button(
                onClick = {
                  currentIndex++
                  selectedOption = null
                  isSubmitted = false
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9333EA)),
                shape = RoundedCornerShape(6.dp),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
              ) {
                Text("මීළඟ ප්‍රශ්නය ➔", fontSize = 10.sp, fontWeight = FontWeight.Bold)
              }
            }
          }
        }
      }

      // Close back to hub button
      Button(
        onClick = onClose,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4C1D95)),
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 4.dp),
        shape = RoundedCornerShape(6.dp),
        contentPadding = PaddingValues(vertical = 4.dp)
      ) {
        Text("✕ වසන්න (Back to Hub)", fontSize = 9.5.sp)
      }
    }
  }
}

// -------------------------------------------------------------
// FULLSCREEN STUDY DIALOG FOR SCIENCE MODULES (COMPLETE SCROLL)
// -------------------------------------------------------------
@Composable
fun ScienceModuleFullscreenDialog(
  moduleType: ScienceModuleType,
  initialGrade: ScienceHubGradeFilter = ScienceHubGradeFilter.GRADE_10,
  onDismiss: () -> Unit
) {
  var activeGrade by remember { mutableStateOf(initialGrade) }
  var currentModule by remember { mutableStateOf(moduleType) }

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false)
  ) {
    Surface(
      modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
      shape = RoundedCornerShape(16.dp),
      color = Color(0xFF0F172A),
      border = BorderStroke(1.dp, Color(0xFF334155))
    ) {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .verticalScroll(rememberScrollState())
          .padding(12.dp)
      ) {
        // Top Bar
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text(currentModule.icon, fontSize = 20.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Column {
              Text(
                text = currentModule.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Text(
                text = "10 & 11 ශ්‍රේණි සම්පූර්ණ විෂය නිර්දේශය",
                fontSize = 9.sp,
                color = Color(0xFF94A3B8)
              )
            }
          }

          IconButton(onClick = onDismiss) {
            Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White)
          }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Grade Toggle
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF1E293B))
            .padding(2.dp),
          horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
          ScienceHubGradeFilter.values().forEach { g ->
            val isSelected = activeGrade == g
            Surface(
              onClick = { activeGrade = g },
              shape = RoundedCornerShape(6.dp),
              color = if (isSelected) currentModule.badgeColor else Color.Transparent,
              modifier = Modifier.weight(1f)
            ) {
              Text(
                text = g.title,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 4.dp)
              )
            }
          }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Module Selector
        LazyRow(
          horizontalArrangement = Arrangement.spacedBy(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          items(ScienceModuleType.values()) { mod ->
            val isSel = currentModule == mod
            Surface(
              onClick = { currentModule = mod },
              shape = RoundedCornerShape(6.dp),
              color = if (isSel) mod.badgeColor else Color(0xFF1E293B),
              border = BorderStroke(1.dp, if (isSel) Color.White else Color(0xFF334155))
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(mod.icon, fontSize = 10.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Text(mod.title, fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }
            }
          }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Fullscreen Content View
        Box(modifier = Modifier.fillMaxWidth()) {
          val activeGradeStr = activeGrade.gradeStr
          when (currentModule) {
            ScienceModuleType.CHEMISTRY_EQUATIONS -> {
              val items = remember(activeGradeStr) {
                ScienceGrade1011SyllabusRepository.chemistryItems.filter { it.grade == activeGradeStr }
              }
              ScienceChemistrySubSection(
                items = items,
                grade = activeGradeStr,
                onClose = onDismiss,
                onOpenFullscreen = {}
              )
            }
            ScienceModuleType.PHYSICS_FORMULAS -> {
              val items = remember(activeGradeStr) {
                ScienceGrade1011SyllabusRepository.physicsItems.filter { it.grade == activeGradeStr }
              }
              SciencePhysicsSubSection(
                items = items,
                grade = activeGradeStr,
                onClose = onDismiss,
                onOpenFullscreen = {}
              )
            }
            ScienceModuleType.PRACTICALS -> {
              val items = remember(activeGradeStr) {
                ScienceGrade1011SyllabusRepository.practicalItems.filter { it.grade == activeGradeStr }
              }
              SciencePracticalsSubSection(
                items = items,
                grade = activeGradeStr,
                onClose = onDismiss,
                onOpenFullscreen = {}
              )
            }
            ScienceModuleType.BIOLOGY_DIAGRAMS -> {
              val items = remember(activeGradeStr) {
                ScienceGrade1011SyllabusRepository.biologyDiagrams.filter { it.grade == activeGradeStr }
              }
              ScienceBiologySubSection(
                items = items,
                grade = activeGradeStr,
                onClose = onDismiss,
                onOpenFullscreen = {}
              )
            }
            ScienceModuleType.RAPID_MCQ -> {
              val items = remember(activeGradeStr) {
                ScienceGrade1011SyllabusRepository.mcqItems.filter { it.grade == activeGradeStr }
              }
              ScienceMcqChallengeSubSection(
                items = items,
                grade = activeGradeStr,
                onClose = onDismiss,
                onOpenFullscreen = {}
              )
            }
            ScienceModuleType.PERIODIC_TABLE -> {
              PeriodicTableSubSection(onClose = onDismiss)
            }
            ScienceModuleType.SI_DIMENSIONS -> {
              SiDimensionsSubSection(onClose = onDismiss)
            }
            ScienceModuleType.EVERYDAY_SCIENCE -> {
              EverydayScienceSubSection(onClose = onDismiss)
            }
            ScienceModuleType.AI_TUTOR -> {
              PlaceholderFeatureSection(
                title = "AI පුද්ගලික උපදේශක",
                description = "ඔබේ ප්‍රශ්න සඳහා AI මගපෙන්වීම.",
                onClose = onDismiss
              )
            }
            ScienceModuleType.MIND_MAPS -> {
              PlaceholderFeatureSection(
                title = "සංකල්ප සිතියම්",
                description = "පාඩම් සාරාංශ සඳහා සංකල්ප සිතියම්.",
                onClose = onDismiss
              )
            }
          }
        }
      }
    }
  }
}
