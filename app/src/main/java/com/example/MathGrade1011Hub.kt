package com.example

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
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
import kotlin.math.sqrt
import kotlinx.coroutines.launch

/**
 * 100% ACCURATE O/L MATHEMATICS MASTER HUB FOR GRADES 10 & 11
 * Divided strictly by Grade 10 and Grade 11:
 * 1. ප්‍රමේය සහ ජ්‍යාමිතික සාධන (Theorems, Proofs & Constructions)
 * 2. වීජ ගණිතය, වර්ගජ ප්‍රස්ථාර & සමීකරණ (Algebra, Equations & Graphs)
 * 3. ත්‍රිකෝණමිතිය, මිනුම් & දිගංශය (Trigonometry, Mensuration & Bearing)
 * 4. මූල්‍ය ගණිතය, වාරික ණය & බදු (Financial Math, Loans & Taxes)
 * 5. සංඛ්‍යානය & සම්භාවිතා රුක් සටහන් (Statistics & Probability Tree Diagrams)
 * 6. Rapid-Fire O/L Maths Challenge (MCQs & Step-by-Step Solutions)
 */

enum class MathHubGradeFilter(val gradeStr: String, val title: String) {
  GRADE_10("10", "10 ශ්‍රේණිය (Grade 10)"),
  GRADE_11("11", "11 ශ්‍රේණිය (Grade 11)")
}

enum class MathHubModuleType(val title: String, val icon: String, val badgeColor: Color) {
  GEOMETRY("ජ්‍යාමිතිය & ප්‍රමේය", "📐", Color(0xFF0284C7)),
  ALGEBRA("වීජ ගණිතය & ප්‍රස්ථාර", "📈", Color(0xFFD97706)),
  TRIGONOMETRY("ත්‍රිකෝණමිතිය & මිනුම්", "📐", Color(0xFF059669)),
  FINANCIAL("මූල්‍ය ගණිතය & බදු", "💰", Color(0xFFE11D48)),
  STATISTICS("සංඛ්‍යානය & සම්භාවිතාව", "📊", Color(0xFF7C3AED)),
  CONSTRUCTIONS("ජ්‍යාමිතික නිර්මාණ", "📏", Color(0xFF0D9488)),
  LOGARITHMS("ලඝුගණක & අංකනය", "🧮", Color(0xFFD97706)),
  SETS_VENN("කුලක & වෙන් රූප", "⭕", Color(0xFF7C3AED)),
  PROGRESSIONS("ශ්‍රේඪි (AP & GP)", "🔢", Color(0xFFDB2777)),
  MATRICES_INEQ("න්‍යාස & අසමානතා", "🔲", Color(0xFF6366F1)),
  VELOCITY_GRAPHS("ප්‍රවේග-කාල ප්‍රස්ථාර", "🚗", Color(0xFF0284C7)),
  EXAM_TIPS("Marking & රහස්", "💡", Color(0xFFCA8A04)),
  RAPID_MCQ("Rapid-Fire O/L ගැටලු", "🎯", Color(0xFF2563EB)),
  GRAPH_PLOTTER("ප්‍රස්ථාර අඳින මෙවලම", "📊", Color(0xFF0284C7)),
  AI_MATH_SOLVER("AI ගණිත විසදුම්කාරකය", "🤖", Color(0xFF7C3AED)),
  FLASH_TRAINER("ප්‍රමේය & සූත්‍ර පුහුණුව", "⚡", Color(0xFFCA8A04)),
  PAST_PAPER_SIM("විභාග ප්‍රශ්න පත්‍ර සිමියුලේටරය", "⏱️", Color(0xFFE11D48)),
  FORMULA_THEOREM_SEARCH("සූත්‍ර සහ ප්‍රමේය සෙවීම", "🔍", Color(0xFF6B7280)),
  SOLVER("සමීකරණ විසඳුම්කරු", "🧮", Color(0xFF2563EB)),
  GRAPH_EXPLORER("ප්‍රස්ථාර ගවේෂකය", "📉", Color(0xFFD97706)),
  MARKING_SECRETS("විභාග උපදෙස් (Marking)", "📝", Color(0xFF7C3AED))
}

// -------------------------------------------------------------
// 1. GEOMETRY THEOREM MODELS
// -------------------------------------------------------------
data class MathTheoremItem(
  val id: String,
  val grade: String,
  val title: String,
  val theoremNumber: String,
  val statement: String, // ප්‍රකාශය
  val givenData: String, // දත්තය
  val construction: String, // නිර්මාණය
  val proofSteps: List<String>, // සාධනය පියවර
  val converseStatement: String, // විලෝමය
  val examTip: String,
  val exampleProblem: String,
  val exampleSolution: String
)

// -------------------------------------------------------------
// 2. ALGEBRA & GRAPHS MODELS
// -------------------------------------------------------------
data class MathAlgebraItem(
  val id: String,
  val grade: String,
  val topic: String,
  val formula: String,
  val conceptSummary: String,
  val steps: List<String>,
  val sampleQuestion: String,
  val workedSolution: List<String>,
  val finalResult: String,
  val commonPitfalls: String
)

// -------------------------------------------------------------
// 3. TRIGONOMETRY & MENSURATION MODELS
// -------------------------------------------------------------
data class MathTrigItem(
  val id: String,
  val grade: String,
  val title: String,
  val subCategory: String, // "ත්‍රිකෝණමිතිය", "පරිමාව", "දිගංශය", "චාප දිග"
  val formula: String,
  val formulaExplanation: String,
  val questionText: String,
  val stepByStepWorking: List<String>,
  val finalAnswer: String,
  val practicalApplication: String
)

// -------------------------------------------------------------
// 4. FINANCIAL MATH MODELS
// -------------------------------------------------------------
data class MathFinancialItem(
  val id: String,
  val grade: String,
  val title: String,
  val category: String, // "හීනවන ශේෂ ණය", "වැල් පොලිය", "වරිපනම් බදු", "සුළු පොලිය"
  val formula: String,
  val rulesSummary: String,
  val problemText: String,
  val calculationSteps: List<String>,
  val answer: String,
  val examAdvice: String
)

// -------------------------------------------------------------
// 5. STATISTICS & PROBABILITY MODELS
// -------------------------------------------------------------
data class MathStatItem(
  val id: String,
  val grade: String,
  val title: String,
  val method: String,
  val formula: String,
  val keyPoints: List<String>,
  val workedExampleQuestion: String,
  val solutionSteps: List<String>,
  val finalValue: String
)

// -------------------------------------------------------------
// 6. RAPID-FIRE MCQ & SHORT PROBLEMS
// -------------------------------------------------------------
data class MathRapidProblem(
  val id: String,
  val grade: String,
  val unitName: String,
  val question: String,
  val options: List<String>,
  val correctIndex: Int,
  val stepByStepExplanation: String
)

// =============================================================
// REPOSITORY: 100% ACCURATE O/L SYLLABUS MATHEMATICS DATA
// =============================================================
object MathGrade1011SyllabusRepository {

  // 1. GEOMETRY THEOREMS (16 O/L Theorems for Grade 10 & 11)
  val geometryTheorems: List<MathTheoremItem> = MathTheoremsData.items

  // 2. ALGEBRA & QUADRATIC GRAPHS (10 Comprehensive Topics for Grade 10 & 11)
  val algebraItems: List<MathAlgebraItem> = MathAlgebraData.items

  // 3. FINANCIAL MATHEMATICS (7 Comprehensive Topics for Grade 10 & 11)
  val financialMathItems: List<MathFinancialItem> = MathFinancialData.items

  // 4. TRIGONOMETRY & MENSURATION (Grade 10 & 11)
  val trigAndMensurationItems: List<MathTrigItem> = (
    MathStatsTrigMensurationData.trigonometryItems.map { itm ->
      MathTrigItem(
        id = itm.id,
        grade = if (itm.grade.contains("11")) "11" else "10",
        title = itm.title,
        subCategory = itm.category,
        formula = itm.formulaOrRule,
        formulaExplanation = itm.keyConcept,
        questionText = itm.workedExample,
        stepByStepWorking = itm.stepByStepGuide,
        finalAnswer = itm.examTips,
        practicalApplication = itm.keyConcept
      )
    } + MathStatsTrigMensurationData.mensurationItems.map { itm ->
      MathTrigItem(
        id = itm.id,
        grade = if (itm.grade.contains("11")) "11" else "10",
        title = itm.title,
        subCategory = itm.category,
        formula = itm.formulaOrRule,
        formulaExplanation = itm.keyConcept,
        questionText = itm.workedExample,
        stepByStepWorking = itm.stepByStepGuide,
        finalAnswer = itm.examTips,
        practicalApplication = itm.keyConcept
      )
    }
  )

  // 5. STATISTICS & PROBABILITY (Grade 10 & 11)
  val statAndProbItems: List<MathStatItem> = (
    MathStatsTrigMensurationData.statisticsItems.map { itm ->
      MathStatItem(
        id = itm.id,
        grade = if (itm.grade.contains("11")) "11" else "10",
        title = itm.title,
        method = itm.category,
        formula = itm.formulaOrRule,
        keyPoints = itm.stepByStepGuide,
        workedExampleQuestion = itm.workedExample,
        solutionSteps = itm.stepByStepGuide,
        finalValue = itm.examTips
      )
    } + MathStatsTrigMensurationData.probabilityItems.map { itm ->
      MathStatItem(
        id = itm.id,
        grade = if (itm.grade.contains("11")) "11" else "10",
        title = itm.title,
        method = itm.category,
        formula = itm.formulaOrRule,
        keyPoints = itm.stepByStepGuide,
        workedExampleQuestion = itm.workedExample,
        solutionSteps = itm.stepByStepGuide,
        finalValue = itm.examTips
      )
    }
  )

  // 6. RAPID-FIRE MCQs (24 High-Yield O/L Standard Questions)
  val rapidProblems: List<MathRapidProblem> = MathMcqChallengeData.mcqQuestions.map { mcq ->
    MathRapidProblem(
      id = mcq.id,
      grade = if (mcq.grade.contains("11")) "11" else "10",
      unitName = mcq.topic,
      question = mcq.question,
      options = mcq.options,
      correctIndex = mcq.correctIndex,
      stepByStepExplanation = mcq.explanation
    )
  }
}

// =============================================================
// COMPACT & EXPANDABLE CARD VIEWS FOR MATHEMATICS SUBJECT PAGE
// =============================================================

// Define MathPlaceholderFeatureSection for the new modules
@Composable
fun MathPlaceholderFeatureSection(title: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFF0F172A))
            .padding(16.dp)
    ) {
        Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = description, fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "මෙම අංගය තවමත් සංවර්ධනය වෙමින් පවතී.", fontSize = 12.sp, color = Color(0xFF38BDF8))
    }
}

@Composable
fun MathGrade10And11MasterHub(
  currentGrade: String = "10"
) {
  var selectedGrade by remember {
    mutableStateOf(if (currentGrade == "11") MathHubGradeFilter.GRADE_11 else MathHubGradeFilter.GRADE_10)
  }
  var selectedModule by remember { mutableStateOf<MathHubModuleType?>(null) }
  var isFullScreenOpen by remember { mutableStateOf(false) }

  // Main Container with dark vibrant math aesthetics
  Card(
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
    border = BorderStroke(1.2.dp, Color(0xFF38BDF8).copy(alpha = 0.5f)),
    modifier = Modifier
      .fillMaxWidth()
      .testTag("math_grade_10_11_master_hub")
  ) {
    Column(modifier = Modifier.padding(12.dp)) {
      // Header Row with Full Screen Action
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier.weight(1f, fill = false)
        ) {
          Text("📐", fontSize = 18.sp)
          Spacer(modifier = Modifier.width(6.dp))
          Column {
            Text(
              text = "10 & 11 ගණිතය විෂය නිර්දේශ Master Hub",
              color = Color.White,
              fontSize = 13.sp,
              fontWeight = FontWeight.Bold,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
            Text(
              text = "ප්‍රමේය සාධන • ප්‍රස්ථාර • ත්‍රිකෝණමිතිය • වාරික ණය • MCQs",
              color = Color(0xFFBAE6FD),
              fontSize = 9.sp,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
          }
        }

        Spacer(modifier = Modifier.width(6.dp))

        // Fullscreen Toggle Button
        IconButton(
          onClick = { isFullScreenOpen = true },
          modifier = Modifier
            .size(32.dp)
            .background(Color(0xFF0284C7), RoundedCornerShape(8.dp))
            .testTag("math_hub_fullscreen_btn")
        ) {
          Icon(
            Icons.Default.Fullscreen,
            contentDescription = "පූර්ණ තිරය",
            tint = Color.White,
            modifier = Modifier.size(18.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      // Grade Toggle Pills: 10 ශ්‍රේණිය vs 11 ශ්‍රේණිය
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .clip(RoundedCornerShape(8.dp))
          .background(Color(0xFF1E293B))
          .padding(3.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
      ) {
        MathHubGradeFilter.values().forEach { g ->
          val isSelected = selectedGrade == g
          Surface(
            onClick = { selectedGrade = g },
            shape = RoundedCornerShape(6.dp),
            color = if (isSelected) Color(0xFF0284C7) else Color.Transparent,
            modifier = Modifier.weight(1f)
          ) {
            Row(
              modifier = Modifier.padding(vertical = 5.dp),
              horizontalArrangement = Arrangement.Center,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = if (g == MathHubGradeFilter.GRADE_10) "📘 10 ශ්‍රේණිය (Grade 10)" else "📙 11 ශ්‍රේණිය (Grade 11)",
                fontSize = 11.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = if (isSelected) Color.White else Color(0xFF94A3B8)
              )
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      // Compact Module Selector Strip
      LazyRow(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.fillMaxWidth()
      ) {
        items(MathHubModuleType.values()) { mod ->
          val isSelected = selectedModule == mod
          Surface(
            onClick = {
              selectedModule = if (isSelected) null else mod
            },
            shape = RoundedCornerShape(8.dp),
            color = if (isSelected) mod.badgeColor else Color(0xFF1E293B),
            border = BorderStroke(1.dp, if (isSelected) Color.White else Color(0xFF334155))
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
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

      // Active Content Section
      val activeGradeStr = selectedGrade.gradeStr
      when (selectedModule) {
        MathHubModuleType.GEOMETRY -> {
          val items = remember(activeGradeStr) {
            MathGrade1011SyllabusRepository.geometryTheorems.filter { it.grade == activeGradeStr }
          }
          MathGeometrySubSection(items = items, grade = activeGradeStr, onOpenFullscreen = { isFullScreenOpen = true })
        }
        MathHubModuleType.ALGEBRA -> {
          val items = remember(activeGradeStr) {
            MathGrade1011SyllabusRepository.algebraItems.filter { it.grade == activeGradeStr }
          }
          MathAlgebraSubSection(items = items, grade = activeGradeStr, onOpenFullscreen = { isFullScreenOpen = true })
        }
        MathHubModuleType.TRIGONOMETRY -> {
          val items = remember(activeGradeStr) {
            MathGrade1011SyllabusRepository.trigAndMensurationItems.filter { it.grade == activeGradeStr }
          }
          MathTrigSubSection(items = items, grade = activeGradeStr, onOpenFullscreen = { isFullScreenOpen = true })
        }
        MathHubModuleType.FINANCIAL -> {
          val items = remember(activeGradeStr) {
            MathGrade1011SyllabusRepository.financialMathItems.filter { it.grade == activeGradeStr }
          }
          MathFinancialSubSection(items = items, grade = activeGradeStr, onOpenFullscreen = { isFullScreenOpen = true })
        }
        MathHubModuleType.STATISTICS -> {
          val items = remember(activeGradeStr) {
            MathGrade1011SyllabusRepository.statAndProbItems.filter { it.grade == activeGradeStr }
          }
          MathStatSubSection(items = items, grade = activeGradeStr, onOpenFullscreen = { isFullScreenOpen = true })
        }
        MathHubModuleType.SOLVER -> {
          MathSolverSubSection(onClose = { selectedModule = null })
        }
        MathHubModuleType.GRAPH_EXPLORER -> {
          MathGraphExplorerSubSection(onClose = { selectedModule = null })
        }
        MathHubModuleType.MARKING_SECRETS -> {
          MathMarkingSecretsSubSection(onClose = { selectedModule = null })
        }
        MathHubModuleType.FORMULA_THEOREM_SEARCH -> {
          MathFormulaSearchSubSection(grade = activeGradeStr, onOpenFullscreen = { isFullScreenOpen = true })
        }
        MathHubModuleType.CONSTRUCTIONS -> {
          val items = remember(activeGradeStr) {
            MathAdvancedSyllabusRepository.constructionsList.filter { it.grade == activeGradeStr }
          }
          MathConstructionsSubSection(items = items, grade = activeGradeStr, onOpenFullscreen = { isFullScreenOpen = true })
        }
        MathHubModuleType.LOGARITHMS -> {
          val items = remember(activeGradeStr) {
            MathAdvancedSyllabusRepository.logarithmsList.filter { it.grade == activeGradeStr }
          }
          MathLogarithmsSubSection(items = items, grade = activeGradeStr, onOpenFullscreen = { isFullScreenOpen = true })
        }
        MathHubModuleType.SETS_VENN -> {
          val items = remember(activeGradeStr) {
            MathAdvancedSyllabusRepository.vennDiagramsList.filter { it.grade == activeGradeStr }
          }
          MathVennSubSection(items = items, grade = activeGradeStr, onOpenFullscreen = { isFullScreenOpen = true })
        }
        MathHubModuleType.PROGRESSIONS -> {
          val items = remember(activeGradeStr) {
            MathAdvancedSyllabusRepository.progressionsList.filter { it.grade == activeGradeStr }
          }
          MathProgressionsSubSection(items = items, grade = activeGradeStr, onOpenFullscreen = { isFullScreenOpen = true })
        }
        MathHubModuleType.MATRICES_INEQ -> {
          val items = remember(activeGradeStr) {
            MathAdvancedSyllabusRepository.matricesAndIneqList.filter { it.grade == activeGradeStr }
          }
          MathMatricesIneqSubSection(items = items, grade = activeGradeStr, onOpenFullscreen = { isFullScreenOpen = true })
        }
        MathHubModuleType.VELOCITY_GRAPHS -> {
          val items = remember(activeGradeStr) {
            MathAdvancedSyllabusRepository.velocityGraphsList.filter { it.grade == activeGradeStr }
          }
          MathVelocitySubSection(items = items, grade = activeGradeStr, onOpenFullscreen = { isFullScreenOpen = true })
        }
        MathHubModuleType.EXAM_TIPS -> {
          MathExamSecretsSubSection(items = MathAdvancedSyllabusRepository.examSecretsList, onOpenFullscreen = { isFullScreenOpen = true })
        }
        MathHubModuleType.RAPID_MCQ -> {
          val items = remember(activeGradeStr) {
            MathGrade1011SyllabusRepository.rapidProblems.filter { it.grade == activeGradeStr }
          }
          MathRapidProblemSubSection(items = items, grade = activeGradeStr, onOpenFullscreen = { isFullScreenOpen = true })
        }
        MathHubModuleType.GRAPH_PLOTTER -> {
          MathPlaceholderFeatureSection(title = "ප්‍රස්ථාර අඳින මෙවලම", description = "ප්‍රස්ථාර අඳින්න සහ විශ්ලේෂණය කරන්න.")
        }
        MathHubModuleType.AI_MATH_SOLVER -> {
          MathPlaceholderFeatureSection(title = "AI ගණිත විසදුම්කාරකය", description = "ගැටලු පියවරෙන් පියවර විසඳන්න.")
        }
        MathHubModuleType.FLASH_TRAINER -> {
          MathPlaceholderFeatureSection(title = "ප්‍රමේය & සූත්‍ර පුහුණුව", description = "ප්‍රමේය සහ සූත්‍ර වේගයෙන් පුහුණු වන්න.")
        }
        MathHubModuleType.PAST_PAPER_SIM -> {
          MathPlaceholderFeatureSection(title = "විභාග ප්‍රශ්න පත්‍ර සිමියුලේටරය", description = "කාලරාමු අනුව විභාග ප්‍රශ්න පත්‍ර පුහුණු වන්න.")
        }
        null -> {
          // Default Overview Row with Quick Feature Buttons
          MathQuickOverviewRow(
            grade = activeGradeStr,
            onSelectModule = { selectedModule = it },
            onOpenFullScreen = { isFullScreenOpen = true }
          )
        }
      }
    }
  }


  // Full Screen Interactive Dialog
  if (isFullScreenOpen) {
    MathFullScreenModal(
      initialGrade = selectedGrade,
      onDismiss = { isFullScreenOpen = false }
    )
  }
}

// -------------------------------------------------------------
// COMPACT QUICK OVERVIEW ROW (MINIMAL HEIGHT ON MAIN SCREEN)
// -------------------------------------------------------------

@Composable
private fun MathQuickOverviewRow(
  grade: String,
  onSelectModule: (MathHubModuleType) -> Unit,
  onOpenFullScreen: () -> Unit
) {
  Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      MathFeatureQuickButton(
        icon = "📐",
        title = "ප්‍රමේය සාධන",
        subtitle = "$grade ශ්‍රේණිය ජ්‍යාමිතිය",
        color = Color(0xFF0284C7),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.GEOMETRY) }
      )
      MathFeatureQuickButton(
        icon = "📈",
        title = "වර්ගජ ප්‍රස්ථාර",
        subtitle = "හැරවුම් ලක්ෂ්‍ය & විසඳුම්",
        color = Color(0xFFD97706),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.ALGEBRA) }
      )
    }

    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      MathFeatureQuickButton(
        icon = "💰",
        title = "වාරික ණය & පොලී",
        subtitle = "හීනවන ශේෂ සූත්‍ර",
        color = Color(0xFFE11D48),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.FINANCIAL) }
      )
      MathFeatureQuickButton(
        icon = "📊",
        title = "සංඛ්‍යානය & රුක්",
        subtitle = "උපකල්පිත මධ්‍යන්‍ය",
        color = Color(0xFF7C3AED),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.STATISTICS) }
      )
      MathFeatureQuickButton(
        icon = "🎯",
        title = "MCQs",
        subtitle = "Rapid O/L",
        color = Color(0xFF2563EB),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.RAPID_MCQ) }
      )
    }

    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      MathFeatureQuickButton(
        icon = "📏",
        title = "නිර්මාණ",
        subtitle = "කෝණ & වෘත්ත",
        color = Color(0xFF0D9488),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.CONSTRUCTIONS) }
      )
      MathFeatureQuickButton(
        icon = "🧮",
        title = "ලඝුගණක",
        subtitle = "වගු & අංකනය",
        color = Color(0xFFF59E0B),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.LOGARITHMS) }
      )
      MathFeatureQuickButton(
        icon = "⭕",
        title = "කුලක/ශ්‍රේඪි",
        subtitle = "වෙන් රූප & AP/GP",
        color = Color(0xFF7C3AED),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.SETS_VENN) }
      )
      MathFeatureQuickButton(
        icon = "💡",
        title = "Marking",
        subtitle = "රහස් & වැරදි 20",
        color = Color(0xFFCA8A04),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.EXAM_TIPS) }
      )
    }

    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      MathFeatureQuickButton(
        icon = "📊",
        title = "ප්‍රස්ථාර",
        subtitle = "අඳින මෙවලම",
        color = Color(0xFF0284C7),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.GRAPH_PLOTTER) }
      )
      MathFeatureQuickButton(
        icon = "🤖",
        title = "AI විසදුම්",
        subtitle = "පියවරෙන් පියවර",
        color = Color(0xFF7C3AED),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.AI_MATH_SOLVER) }
      )
      MathFeatureQuickButton(
        icon = "⚡",
        title = "පුහුණුව",
        subtitle = "සූත්‍ර/ප්‍රමේය",
        color = Color(0xFFCA8A04),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.FLASH_TRAINER) }
      )
      MathFeatureQuickButton(
        icon = "⏱️",
        title = "විභාග සිම්",
        subtitle = "කාලරාමු අනුව",
        color = Color(0xFFE11D48),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.PAST_PAPER_SIM) }
      )
    }
    Row(
      modifier = Modifier.fillMaxWidth().padding(top = 6.dp),
      horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      MathFeatureQuickButton(
        icon = "🔍",
        title = "සෙවීම",
        subtitle = "සූත්‍ර/ප්‍රමේය",
        color = Color(0xFF6B7280),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.FORMULA_THEOREM_SEARCH) }
      )
      Spacer(modifier = Modifier.weight(1f))
      Spacer(modifier = Modifier.weight(1f))
      Spacer(modifier = Modifier.weight(1f))
    }

    // Interactive Quick Solvers Mini-Bar
    Surface(
      shape = RoundedCornerShape(8.dp),
      color = Color(0xFF1E293B),
      border = BorderStroke(1.dp, Color(0xFF334155)),
      modifier = Modifier
        .fillMaxWidth()
        .clickable { onOpenFullScreen() }
    ) {
      Row(
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Text("⚡", fontSize = 12.sp)
          Spacer(modifier = Modifier.width(6.dp))
          Text(
            text = "පියවරෙන් පියවර විසඳුම් & සූත්‍ර ගණක (Full-Screen Solver)",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF38BDF8)
          )
        }
        Text(
          text = "විවෘත කරන්න ➔",
          fontSize = 9.sp,
          color = Color.White,
          fontWeight = FontWeight.SemiBold
        )
      }
    }
  }
}

@Composable
private fun MathFeatureQuickButton(
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
    color = color.copy(alpha = 0.2f),
    border = BorderStroke(1.dp, color.copy(alpha = 0.5f)),
    modifier = modifier
  ) {
    Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text(icon, fontSize = 11.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = title,
          fontSize = 10.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )
      }
      Text(
        text = subtitle,
        fontSize = 8.sp,
        color = Color(0xFFBAE6FD),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
      )
    }
  }
}

// -------------------------------------------------------------
// REUSABLE SUB-SECTION SCROLL CONTROLS & HEADER
// -------------------------------------------------------------

@Composable
fun MathSubSectionScrollControls(
  title: String,
  itemCountText: String,
  scrollState: androidx.compose.foundation.ScrollState,
  coroutineScope: kotlinx.coroutines.CoroutineScope,
  accentColor: Color,
  onOpenFullscreen: () -> Unit
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(8.dp))
      .background(Color(0xFF0F172A))
      .padding(horizontal = 8.dp, vertical = 5.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Text(
        text = "↕ අභ්‍යන්තරව scroll කරන්න",
        fontSize = 9.sp,
        color = Color(0xFF94A3B8)
      )
      Spacer(modifier = Modifier.width(6.dp))
      Surface(
        shape = RoundedCornerShape(4.dp),
        color = accentColor.copy(alpha = 0.2f),
        border = BorderStroke(1.dp, accentColor)
      ) {
        Text(
          text = itemCountText,
          fontSize = 8.5.sp,
          fontWeight = FontWeight.Bold,
          color = accentColor,
          modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
        )
      }
    }

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
      // Scroll to Top
      Surface(
        onClick = {
          coroutineScope.launch {
            scrollState.animateScrollTo(0)
          }
        },
        shape = CircleShape,
        color = Color(0xFF1E293B),
        border = BorderStroke(1.dp, Color(0xFF475569))
      ) {
        Row(
          modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("⬆️", fontSize = 9.sp)
          Spacer(modifier = Modifier.width(2.dp))
          Text("ඉහළට", fontSize = 8.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
      }

      // Scroll to Bottom
      Surface(
        onClick = {
          coroutineScope.launch {
            scrollState.animateScrollTo(scrollState.maxValue)
          }
        },
        shape = CircleShape,
        color = Color(0xFF1E293B),
        border = BorderStroke(1.dp, Color(0xFF475569))
      ) {
        Row(
          modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("⬇️", fontSize = 9.sp)
          Spacer(modifier = Modifier.width(2.dp))
          Text("පහළට", fontSize = 8.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
      }

      // Fullscreen Expansion
      Surface(
        onClick = onOpenFullscreen,
        shape = RoundedCornerShape(6.dp),
        color = accentColor
      ) {
        Row(
          modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("⛶", fontSize = 9.sp, color = Color.White)
          Spacer(modifier = Modifier.width(2.dp))
          Text("විශාල කර", fontSize = 8.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
      }
    }
  }
}

// -------------------------------------------------------------
// 1. GEOMETRY THEOREMS DETAILS SUB-SECTION (WITH INTERNAL SCROLL)
// -------------------------------------------------------------

@Composable
fun MathGeometrySubSection(
  items: List<MathTheoremItem>,
  grade: String,
  onOpenFullscreen: () -> Unit = {}
) {
  var searchQuery by remember { mutableStateOf("") }
  val scrollState = rememberScrollState()
  val coroutineScope = rememberCoroutineScope()

  val filteredItems = remember(items, searchQuery) {
    if (searchQuery.isBlank()) items
    else items.filter {
      it.title.contains(searchQuery, ignoreCase = true) ||
      it.theoremNumber.contains(searchQuery, ignoreCase = true) ||
      it.statement.contains(searchQuery, ignoreCase = true) ||
      it.examTip.contains(searchQuery, ignoreCase = true)
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF032541))
      .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "📐 $grade ශ්‍රේණිය - ජ්‍යාමිතික ප්‍රමේයයන් & සාධන",
        fontSize = 11.5.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF7DD3FC)
      )
      Text(
        text = "${filteredItems.size}/${items.size} ප්‍රමේය",
        fontSize = 9.sp,
        color = Color(0xFF38BDF8)
      )
    }

    // Search Box
    OutlinedTextField(
      value = searchQuery,
      onValueChange = { searchQuery = it },
      modifier = Modifier
        .fillMaxWidth()
        .height(46.dp),
      placeholder = { Text("ප්‍රමේය නම හෝ අංකය සොයන්න...", fontSize = 10.sp, color = Color(0xFF94A3B8)) },
      singleLine = true,
      textStyle = androidx.compose.ui.text.TextStyle(fontSize = 10.5.sp, color = Color.White),
      shape = RoundedCornerShape(8.dp),
      colors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Color(0xFF38BDF8),
        unfocusedBorderColor = Color(0xFF0369A1),
        focusedContainerColor = Color(0xFF082F49),
        unfocusedContainerColor = Color(0xFF082F49)
      ),
      leadingIcon = {
        Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF38BDF8), modifier = Modifier.size(16.dp))
      },
      trailingIcon = {
        if (searchQuery.isNotBlank()) {
          IconButton(onClick = { searchQuery = "" }, modifier = Modifier.size(16.dp)) {
            Icon(Icons.Default.Clear, contentDescription = "Clear", tint = Color.White, modifier = Modifier.size(14.dp))
          }
        }
      }
    )

    // Scroll Control Bar
    MathSubSectionScrollControls(
      title = "ජ්‍යාමිතිය",
      itemCountText = "${filteredItems.size} සම්පූර්ණ අයිතම",
      scrollState = scrollState,
      coroutineScope = coroutineScope,
      accentColor = Color(0xFF0284C7),
      onOpenFullscreen = onOpenFullscreen
    )

    // SubSection Content Container
    Column(
      modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      if (filteredItems.isEmpty()) {
        Text("සෙවුමට ගැළපෙන ප්‍රමේය නොමැත.", color = Color(0xFF94A3B8), fontSize = 10.sp, modifier = Modifier.padding(8.dp))
      }

      filteredItems.forEach { item ->
        var isExpanded by remember { mutableStateOf(false) }
        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFF082F49),
          border = BorderStroke(1.dp, if (isExpanded) Color(0xFF38BDF8) else Color(0xFF0284C7)),
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
                text = item.title,
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
                  text = item.theoremNumber,
                  fontSize = 8.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(3.dp))
            Text(
              text = "ප්‍රකාශය: ${item.statement}",
              fontSize = 9.5.sp,
              color = Color(0xFFE0F2FE)
            )

            if (isExpanded) {
              Spacer(modifier = Modifier.height(6.dp))
              if (item.givenData.isNotBlank()) {
                Text("දත්තය: ${item.givenData}", fontSize = 9.sp, color = Color(0xFFBAE6FD))
              }
              if (item.construction.isNotBlank()) {
                Text("නිර්මාණය: ${item.construction}", fontSize = 9.sp, color = Color(0xFFFDE047))
              }
              Spacer(modifier = Modifier.height(4.dp))
              Text("සාධනය පියවර & හේතු:", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
              item.proofSteps.forEach { step ->
                Text("• $step", fontSize = 8.5.sp, color = Color.White)
              }
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "ආදර්ශ ගැටලුව: ${item.exampleProblem}",
                fontSize = 8.5.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFFED7AA)
              )
              Text(
                text = "විසඳුම: ${item.exampleSolution}",
                fontSize = 8.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4ADE80)
              )
              Spacer(modifier = Modifier.height(2.dp))
              Text("💡 විභාග ඉඟිය: ${item.examTip}", fontSize = 8.sp, color = Color(0xFFBAE6FD))
            } else {
              Text(
                text = "සාධන පියවර & ආදර්ශ ගැටලු බැලීමට ක්ලික් කරන්න ▾",
                fontSize = 8.sp,
                color = Color(0xFF38BDF8).copy(alpha = 0.8f)
              )
            }
          }
        }
      }
    }
  }
}

// -------------------------------------------------------------
// 2. ALGEBRA & GRAPHS SUB-SECTION (WITH INTERNAL SCROLL)
// -------------------------------------------------------------

@Composable
fun MathAlgebraSubSection(
  items: List<MathAlgebraItem>,
  grade: String,
  onOpenFullscreen: () -> Unit = {}
) {
  var searchQuery by remember { mutableStateOf("") }
  val scrollState = rememberScrollState()
  val coroutineScope = rememberCoroutineScope()

  val filteredItems = remember(items, searchQuery) {
    if (searchQuery.isBlank()) items
    else items.filter {
      it.topic.contains(searchQuery, ignoreCase = true) ||
      it.formula.contains(searchQuery, ignoreCase = true) ||
      it.conceptSummary.contains(searchQuery, ignoreCase = true) ||
      it.sampleQuestion.contains(searchQuery, ignoreCase = true)
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF2E1065))
      .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "📈 $grade ශ්‍රේණිය - වීජ ගණිතය, වර්ගජ & ප්‍රස්ථාර",
        fontSize = 11.5.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFDDD6FE)
      )
      Text(
        text = "${filteredItems.size}/${items.size} මාතෘකා",
        fontSize = 9.sp,
        color = Color(0xFFC084FC)
      )
    }

    // Search Box
    OutlinedTextField(
      value = searchQuery,
      onValueChange = { searchQuery = it },
      modifier = Modifier
        .fillMaxWidth()
        .height(46.dp),
      placeholder = { Text("වීජ ගණිත මාතෘකාව හෝ සූත්‍රය සොයන්න...", fontSize = 10.sp, color = Color(0xFF94A3B8)) },
      singleLine = true,
      textStyle = androidx.compose.ui.text.TextStyle(fontSize = 10.5.sp, color = Color.White),
      shape = RoundedCornerShape(8.dp),
      colors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Color(0xFFC084FC),
        unfocusedBorderColor = Color(0xFF7E22CE),
        focusedContainerColor = Color(0xFF3B0764),
        unfocusedContainerColor = Color(0xFF3B0764)
      ),
      leadingIcon = {
        Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFFC084FC), modifier = Modifier.size(16.dp))
      },
      trailingIcon = {
        if (searchQuery.isNotBlank()) {
          IconButton(onClick = { searchQuery = "" }, modifier = Modifier.size(16.dp)) {
            Icon(Icons.Default.Clear, contentDescription = "Clear", tint = Color.White, modifier = Modifier.size(14.dp))
          }
        }
      }
    )

    // Scroll Control Bar
    MathSubSectionScrollControls(
      title = "වීජ ගණිතය",
      itemCountText = "${filteredItems.size} සම්පූර්ණ අයිතම",
      scrollState = scrollState,
      coroutineScope = coroutineScope,
      accentColor = Color(0xFFA855F7),
      onOpenFullscreen = onOpenFullscreen
    )

    // SubSection Content Container
    Column(
      modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      if (filteredItems.isEmpty()) {
        Text("සෙවුමට ගැළපෙන වීජ ගණිත අයිතම නොමැත.", color = Color(0xFF94A3B8), fontSize = 10.sp, modifier = Modifier.padding(8.dp))
      }

      filteredItems.forEach { item ->
        var isExpanded by remember { mutableStateOf(false) }
        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFF3B0764),
          border = BorderStroke(1.dp, if (isExpanded) Color(0xFFC084FC) else Color(0xFF9333EA)),
          modifier = Modifier
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded }
        ) {
          Column(modifier = Modifier.padding(8.dp)) {
            Text(
              text = item.topic,
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
              text = "සූත්‍රය / ප්‍රකාශනය: ${item.formula}",
              fontSize = 10.sp,
              fontFamily = FontFamily.Monospace,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFFDE047)
            )

            if (isExpanded) {
              Spacer(modifier = Modifier.height(6.dp))
              Text("මූලධර්මය: ${item.conceptSummary}", fontSize = 9.sp, color = Color(0xFFF3E8FF))
              Spacer(modifier = Modifier.height(4.dp))
              Text("පියවරෙන් පියවර විසඳීම:", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFFA855F7))
              item.steps.forEach { step ->
                Text("➔ $step", fontSize = 8.5.sp, color = Color.White)
              }
              Spacer(modifier = Modifier.height(4.dp))
              Text("ගැටලුව: ${item.sampleQuestion}", fontSize = 8.5.sp, color = Color(0xFFFBBF24))
              item.workedSolution.forEach { sol ->
                Text(sol, fontSize = 8.5.sp, color = Color(0xFFE9D5FF))
              }
              Text(
                text = "පිළිතුර: ${item.finalResult}",
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4ADE80)
              )
              Spacer(modifier = Modifier.height(2.dp))
              Text("⚠️ නිතර සිදුවන වැරදි: ${item.commonPitfalls}", fontSize = 8.sp, color = Color(0xFFFCA5A5))
            } else {
              Text(
                text = "පියවර, විසඳූ ගැටලු & වැරදි වැළකීමේ ක්‍රම බැලීමට ක්ලික් කරන්න ▾",
                fontSize = 8.sp,
                color = Color(0xFFC084FC).copy(alpha = 0.8f)
              )
            }
          }
        }
      }
    }
  }
}

// -------------------------------------------------------------
// 3. TRIGONOMETRY & MENSURATION SUB-SECTION (WITH INTERNAL SCROLL)
// -------------------------------------------------------------

@Composable
fun MathTrigSubSection(
  items: List<MathTrigItem>,
  grade: String,
  onOpenFullscreen: () -> Unit = {}
) {
  var searchQuery by remember { mutableStateOf("") }
  val scrollState = rememberScrollState()
  val coroutineScope = rememberCoroutineScope()

  val filteredItems = remember(items, searchQuery) {
    if (searchQuery.isBlank()) items
    else items.filter {
      it.title.contains(searchQuery, ignoreCase = true) ||
      it.subCategory.contains(searchQuery, ignoreCase = true) ||
      it.formula.contains(searchQuery, ignoreCase = true) ||
      it.practicalApplication.contains(searchQuery, ignoreCase = true)
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF064E3B))
      .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "📐 $grade ශ්‍රේණිය - ත්‍රිකෝණමිතිය, මිනුම් & පරිමාව",
        fontSize = 11.5.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF6EE7B7)
      )
      Text(
        text = "${filteredItems.size}/${items.size} මාතෘකා",
        fontSize = 9.sp,
        color = Color(0xFF34D399)
      )
    }

    // Search Box
    OutlinedTextField(
      value = searchQuery,
      onValueChange = { searchQuery = it },
      modifier = Modifier
        .fillMaxWidth()
        .height(46.dp),
      placeholder = { Text("සූත්‍රය හෝ මාතෘකාව සොයන්න...", fontSize = 10.sp, color = Color(0xFF94A3B8)) },
      singleLine = true,
      textStyle = androidx.compose.ui.text.TextStyle(fontSize = 10.5.sp, color = Color.White),
      shape = RoundedCornerShape(8.dp),
      colors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Color(0xFF34D399),
        unfocusedBorderColor = Color(0xFF059669),
        focusedContainerColor = Color(0xFF047857),
        unfocusedContainerColor = Color(0xFF047857)
      ),
      leadingIcon = {
        Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF34D399), modifier = Modifier.size(16.dp))
      },
      trailingIcon = {
        if (searchQuery.isNotBlank()) {
          IconButton(onClick = { searchQuery = "" }, modifier = Modifier.size(16.dp)) {
            Icon(Icons.Default.Clear, contentDescription = "Clear", tint = Color.White, modifier = Modifier.size(14.dp))
          }
        }
      }
    )

    // Scroll Control Bar
    MathSubSectionScrollControls(
      title = "ත්‍රිකෝණමිතිය",
      itemCountText = "${filteredItems.size} සම්පූර්ණ අයිතම",
      scrollState = scrollState,
      coroutineScope = coroutineScope,
      accentColor = Color(0xFF10B981),
      onOpenFullscreen = onOpenFullscreen
    )

    // SubSection Content Container
    Column(
      modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      if (filteredItems.isEmpty()) {
        Text("සෙවුමට ගැළපෙන ත්‍රිකෝණමිතික අයිතම නොමැත.", color = Color(0xFF94A3B8), fontSize = 10.sp, modifier = Modifier.padding(8.dp))
      }

      filteredItems.forEach { item ->
        var isExpanded by remember { mutableStateOf(false) }
        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFF047857),
          border = BorderStroke(1.dp, if (isExpanded) Color(0xFF34D399) else Color(0xFF10B981)),
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
                text = item.title,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.weight(1f)
              )
              Surface(
                shape = RoundedCornerShape(4.dp),
                color = Color(0xFF059669)
              ) {
                Text(
                  text = item.subCategory,
                  fontSize = 8.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(3.dp))
            Text(
              text = "සූත්‍රය: ${item.formula}",
              fontSize = 10.sp,
              fontFamily = FontFamily.Monospace,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFFDE047)
            )

            if (isExpanded) {
              Spacer(modifier = Modifier.height(6.dp))
              Text("සූත්‍ර විවරණය: ${item.formulaExplanation}", fontSize = 9.sp, color = Color(0xFFA7F3D0))
              Spacer(modifier = Modifier.height(4.dp))
              Text("ගැටලුව: ${item.questionText}", fontSize = 8.5.sp, color = Color(0xFFFDE68A))
              item.stepByStepWorking.forEach { step ->
                Text("• $step", fontSize = 8.5.sp, color = Color.White)
              }
              Text(
                text = "පිළිතුර: ${item.finalAnswer}",
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4ADE80)
              )
              Spacer(modifier = Modifier.height(2.dp))
              Text("භාවිතය: ${item.practicalApplication}", fontSize = 8.sp, color = Color(0xFFD1FAE5))
            } else {
              Text(
                text = "පියවරෙන් පියවර විසඳුම සහ ප්‍රායෝගික භාවිතය බැලීමට ක්ලික් කරන්න ▾",
                fontSize = 8.sp,
                color = Color(0xFF6EE7B7).copy(alpha = 0.8f)
              )
            }
          }
        }
      }
    }
  }
}

// -------------------------------------------------------------
// 4. FINANCIAL MATH SUB-SECTION (WITH INTERNAL SCROLL)
// -------------------------------------------------------------

@Composable
fun MathFinancialSubSection(
  items: List<MathFinancialItem>,
  grade: String,
  onOpenFullscreen: () -> Unit = {}
) {
  var searchQuery by remember { mutableStateOf("") }
  val scrollState = rememberScrollState()
  val coroutineScope = rememberCoroutineScope()

  val filteredItems = remember(items, searchQuery) {
    if (searchQuery.isBlank()) items
    else items.filter {
      it.title.contains(searchQuery, ignoreCase = true) ||
      it.category.contains(searchQuery, ignoreCase = true) ||
      it.formula.contains(searchQuery, ignoreCase = true) ||
      it.problemText.contains(searchQuery, ignoreCase = true)
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF4C0519))
      .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "💰 $grade ශ්‍රේණිය - මූල්‍ය ගණිතය, වාරික ණය සහ බදු",
        fontSize = 11.5.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFFDA4AF)
      )
      Text(
        text = "${filteredItems.size}/${items.size} මාතෘකා",
        fontSize = 9.sp,
        color = Color(0xFFFB7185)
      )
    }

    // Search Box
    OutlinedTextField(
      value = searchQuery,
      onValueChange = { searchQuery = it },
      modifier = Modifier
        .fillMaxWidth()
        .height(46.dp),
      placeholder = { Text("මූල්‍ය මාතෘකාව හෝ බදු වර්ගය සොයන්න...", fontSize = 10.sp, color = Color(0xFF94A3B8)) },
      singleLine = true,
      textStyle = androidx.compose.ui.text.TextStyle(fontSize = 10.5.sp, color = Color.White),
      shape = RoundedCornerShape(8.dp),
      colors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Color(0xFFFB7185),
        unfocusedBorderColor = Color(0xFFBE123C),
        focusedContainerColor = Color(0xFF881337),
        unfocusedContainerColor = Color(0xFF881337)
      ),
      leadingIcon = {
        Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFFFB7185), modifier = Modifier.size(16.dp))
      },
      trailingIcon = {
        if (searchQuery.isNotBlank()) {
          IconButton(onClick = { searchQuery = "" }, modifier = Modifier.size(16.dp)) {
            Icon(Icons.Default.Clear, contentDescription = "Clear", tint = Color.White, modifier = Modifier.size(14.dp))
          }
        }
      }
    )

    // Scroll Control Bar
    MathSubSectionScrollControls(
      title = "මූල්‍ය ගණිතය",
      itemCountText = "${filteredItems.size} සම්පූර්ණ අයිතම",
      scrollState = scrollState,
      coroutineScope = coroutineScope,
      accentColor = Color(0xFFBE123C),
      onOpenFullscreen = onOpenFullscreen
    )

    // SubSection Content Container
    Column(
      modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      if (filteredItems.isEmpty()) {
        Text("සෙවුමට ගැළපෙන මූල්‍ය අයිතම නොමැත.", color = Color(0xFF94A3B8), fontSize = 10.sp, modifier = Modifier.padding(8.dp))
      }

      filteredItems.forEach { item ->
        var isExpanded by remember { mutableStateOf(false) }
        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFF881337),
          border = BorderStroke(1.dp, if (isExpanded) Color(0xFFFB7185) else Color(0xFFBE123C)),
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
                text = item.title,
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
                  text = item.category,
                  fontSize = 8.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(3.dp))
            Text(
              text = "සූත්‍රය: ${item.formula}",
              fontSize = 9.5.sp,
              fontFamily = FontFamily.Monospace,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFFDE047)
            )

            if (isExpanded) {
              Spacer(modifier = Modifier.height(6.dp))
              Text("නීති & ක්‍රමවේදය: ${item.rulesSummary}", fontSize = 9.sp, color = Color(0xFFFEE2E2))
              Spacer(modifier = Modifier.height(4.dp))
              Text("ගැටලුව: ${item.problemText}", fontSize = 8.5.sp, color = Color(0xFFFED7AA))
              item.calculationSteps.forEach { step ->
                Text("➔ $step", fontSize = 8.5.sp, color = Color.White)
              }
              Text(
                text = item.answer,
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4ADE80)
              )
              Spacer(modifier = Modifier.height(2.dp))
              Text("💡 විභාග උපදෙස: ${item.examAdvice}", fontSize = 8.sp, color = Color(0xFFFFD1D1))
            } else {
              Text(
                text = "ගණනය කිරීමේ පියවර සහ ලකුණු ලබාගන්නා ආකාරය බැලීමට ක්ලික් කරන්න ▾",
                fontSize = 8.sp,
                color = Color(0xFFFDA4AF).copy(alpha = 0.8f)
              )
            }
          }
        }
      }
    }
  }
}

// -------------------------------------------------------------
// 5. STATISTICS & PROBABILITY SUB-SECTION (WITH INTERNAL SCROLL)
// -------------------------------------------------------------

@Composable
fun MathStatSubSection(
  items: List<MathStatItem>,
  grade: String,
  onOpenFullscreen: () -> Unit = {}
) {
  var searchQuery by remember { mutableStateOf("") }
  val scrollState = rememberScrollState()
  val coroutineScope = rememberCoroutineScope()

  val filteredItems = remember(items, searchQuery) {
    if (searchQuery.isBlank()) items
    else items.filter {
      it.title.contains(searchQuery, ignoreCase = true) ||
      it.formula.contains(searchQuery, ignoreCase = true) ||
      it.workedExampleQuestion.contains(searchQuery, ignoreCase = true)
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF1E1B4B))
      .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "📊 $grade ශ්‍රේණිය - සංඛ්‍යානය & සම්භාවිතා රුක් සටහන්",
        fontSize = 11.5.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFC7D2FE)
      )
      Text(
        text = "${filteredItems.size}/${items.size} මාතෘකා",
        fontSize = 9.sp,
        color = Color(0xFF818CF8)
      )
    }

    // Search Box
    OutlinedTextField(
      value = searchQuery,
      onValueChange = { searchQuery = it },
      modifier = Modifier
        .fillMaxWidth()
        .height(46.dp),
      placeholder = { Text("සංඛ්‍යානය හෝ සම්භාවිතාව සොයන්න...", fontSize = 10.sp, color = Color(0xFF94A3B8)) },
      singleLine = true,
      textStyle = androidx.compose.ui.text.TextStyle(fontSize = 10.5.sp, color = Color.White),
      shape = RoundedCornerShape(8.dp),
      colors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Color(0xFF818CF8),
        unfocusedBorderColor = Color(0xFF4F46E5),
        focusedContainerColor = Color(0xFF312E81),
        unfocusedContainerColor = Color(0xFF312E81)
      ),
      leadingIcon = {
        Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF818CF8), modifier = Modifier.size(16.dp))
      },
      trailingIcon = {
        if (searchQuery.isNotBlank()) {
          IconButton(onClick = { searchQuery = "" }, modifier = Modifier.size(16.dp)) {
            Icon(Icons.Default.Clear, contentDescription = "Clear", tint = Color.White, modifier = Modifier.size(14.dp))
          }
        }
      }
    )

    // Scroll Control Bar
    MathSubSectionScrollControls(
      title = "සංඛ්‍යානය",
      itemCountText = "${filteredItems.size} සම්පූර්ණ අයිතම",
      scrollState = scrollState,
      coroutineScope = coroutineScope,
      accentColor = Color(0xFF4F46E5),
      onOpenFullscreen = onOpenFullscreen
    )

    // SubSection Content Container
    Column(
      modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      if (filteredItems.isEmpty()) {
        Text("සෙවුමට ගැළපෙන සංඛ්‍යාන අයිතම නොමැත.", color = Color(0xFF94A3B8), fontSize = 10.sp, modifier = Modifier.padding(8.dp))
      }

      filteredItems.forEach { item ->
        var isExpanded by remember { mutableStateOf(false) }
        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFF312E81),
          border = BorderStroke(1.dp, if (isExpanded) Color(0xFF818CF8) else Color(0xFF4F46E5)),
          modifier = Modifier
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded }
        ) {
          Column(modifier = Modifier.padding(8.dp)) {
            Text(
              text = item.title,
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
              text = "සූත්‍රය: ${item.formula}",
              fontSize = 9.5.sp,
              fontFamily = FontFamily.Monospace,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFFDE047)
            )

            if (isExpanded) {
              Spacer(modifier = Modifier.height(6.dp))
              item.keyPoints.forEach { pt ->
                Text("• $pt", fontSize = 8.5.sp, color = Color(0xFFE0E7FF))
              }
              Spacer(modifier = Modifier.height(4.dp))
              Text("ගැටලුව: ${item.workedExampleQuestion}", fontSize = 8.5.sp, color = Color(0xFFFEF08A))
              item.solutionSteps.forEach { step ->
                Text("➔ $step", fontSize = 8.5.sp, color = Color.White)
              }
              Text(
                text = "අවසන් අගය: ${item.finalValue}",
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4ADE80)
              )
            } else {
              Text(
                text = "සවිස්තර පියවර සහ රුක් සටහන් නීති බැලීමට ක්ලික් කරන්න ▾",
                fontSize = 8.sp,
                color = Color(0xFFA5B4FC).copy(alpha = 0.8f)
              )
            }
          }
        }
      }
    }
  }
}
// -------------------------------------------------------------
// 6. FORMULA & THEOREM SEARCH SUB-SECTION
// -------------------------------------------------------------

@Composable
fun MathFormulaSearchSubSection(
  grade: String,
  onOpenFullscreen: () -> Unit = {}
) {
  var searchQuery by remember { mutableStateOf("") }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF1E293B))
      .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Text(
      text = "🔍 $grade ශ්‍රේණිය - සූත්‍ර සහ ප්‍රමේය සෙවීම",
      fontSize = 11.5.sp,
      fontWeight = FontWeight.Bold,
      color = Color.White
    )

    OutlinedTextField(
      value = searchQuery,
      onValueChange = { searchQuery = it },
      modifier = Modifier.fillMaxWidth().height(46.dp),
      placeholder = { Text("ප්‍රමේය හෝ සූත්‍රයක් සොයන්න...", fontSize = 10.sp, color = Color(0xFF94A3B8)) },
      singleLine = true,
      textStyle = androidx.compose.ui.text.TextStyle(fontSize = 10.5.sp, color = Color.White),
      shape = RoundedCornerShape(8.dp),
      colors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Color(0xFF38BDF8),
        unfocusedBorderColor = Color(0xFF475569),
        focusedContainerColor = Color(0xFF0F172A),
        unfocusedContainerColor = Color(0xFF0F172A)
      )
    )

    Text(
      text = "මෙම කොටසේ සියලුම ප්‍රමේයයන් සහ සූත්‍ර ඉක්මනින් සෙවිය හැක. (තවම දත්ත අන්තර්ගත නොවේ, දත්ත එක් කිරීමට කටයුතු කරමින් පවතී)",
      fontSize = 9.sp,
      color = Color(0xFF94A3B8),
      modifier = Modifier.padding(8.dp)
    )
  }
}

// -------------------------------------------------------------
// 7. MATRICES & INEQUALITIES SUB-SECTION (WITH INTERNAL SCROLL)
// -------------------------------------------------------------

@Composable
fun MathMatricesIneqSubSection(
  items: List<MathMatrixAndInequalityItem>,
  grade: String,
  onOpenFullscreen: () -> Unit = {}
) {
  var searchQuery by remember { mutableStateOf("") }
  val scrollState = rememberScrollState()
  val coroutineScope = rememberCoroutineScope()

  val filteredItems = remember(items, searchQuery) {
    if (searchQuery.isBlank()) items
    else items.filter {
      it.category.contains(searchQuery, ignoreCase = true) ||
      it.conceptOrRules.contains(searchQuery, ignoreCase = true) ||
      it.sampleOperation.contains(searchQuery, ignoreCase = true)
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF1E1B4B))
      .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "🔲 $grade ශ්‍රේණිය - න්‍යාස සහ සරල අසමානතා",
        fontSize = 11.5.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFA5B4FC)
      )
      Text(
        text = "${filteredItems.size}/${items.size} මාතෘකා",
        fontSize = 9.sp,
        color = Color(0xFF818CF8)
      )
    }

    // Search Box
    OutlinedTextField(
      value = searchQuery,
      onValueChange = { searchQuery = it },
      modifier = Modifier
        .fillMaxWidth()
        .height(46.dp),
      placeholder = { Text("න්‍යාස හෝ අසමානතා සොයන්න...", fontSize = 10.sp, color = Color(0xFF94A3B8)) },
      singleLine = true,
      textStyle = androidx.compose.ui.text.TextStyle(fontSize = 10.5.sp, color = Color.White),
      shape = RoundedCornerShape(8.dp),
      colors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Color(0xFF818CF8),
        unfocusedBorderColor = Color(0xFF6366F1),
        focusedContainerColor = Color(0xFF312E81),
        unfocusedContainerColor = Color(0xFF312E81)
      ),
      leadingIcon = {
        Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF818CF8), modifier = Modifier.size(16.dp))
      },
      trailingIcon = {
        if (searchQuery.isNotBlank()) {
          IconButton(onClick = { searchQuery = "" }, modifier = Modifier.size(16.dp)) {
            Icon(Icons.Default.Clear, contentDescription = "Clear", tint = Color.White, modifier = Modifier.size(14.dp))
          }
        }
      }
    )

    // Scroll Control Bar
    MathSubSectionScrollControls(
      title = "න්‍යාස සහ අසමානතා",
      itemCountText = "${filteredItems.size} සම්පූර්ණ අයිතම",
      scrollState = scrollState,
      coroutineScope = coroutineScope,
      accentColor = Color(0xFF6366F1),
      onOpenFullscreen = onOpenFullscreen
    )

    // SubSection Content Container
    Column(
      modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      if (filteredItems.isEmpty()) {
        Text("සෙවුමට ගැළපෙන න්‍යාස අයිතම නොමැත.", color = Color(0xFF94A3B8), fontSize = 10.sp, modifier = Modifier.padding(8.dp))
      }

      filteredItems.forEach { itm ->
        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFF312E81),
          border = BorderStroke(1.dp, Color(0xFF6366F1)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(8.dp)) {
            Text(itm.category, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Spacer(modifier = Modifier.height(2.dp))
            Text(itm.conceptOrRules, fontSize = 9.sp, color = Color(0xFFC7D2FE))
            Spacer(modifier = Modifier.height(4.dp))
            Text("ක්‍රියාවලිය: ${itm.sampleOperation}", fontSize = 9.sp, fontFamily = FontFamily.Monospace, color = Color(0xFFFDE047))
            itm.solutionSteps.forEach { s -> Text("• $s", fontSize = 8.5.sp, color = Color.White) }
            Spacer(modifier = Modifier.height(3.dp))
            Text("නිගමනය: ${itm.conclusion}", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
          }
        }
      }
    }
  }
}

// -------------------------------------------------------------
// 7. RAPID-FIRE MCQ SUB-SECTION (WITH INTERNAL SCROLL)
// -------------------------------------------------------------

@Composable
fun MathRapidProblemSubSection(
  items: List<MathRapidProblem>,
  grade: String,
  onOpenFullscreen: () -> Unit = {}
) {
  var currentIndex by remember(grade) { mutableStateOf(0) }
  var selectedOption by remember(currentIndex, grade) { mutableStateOf<Int?>(null) }
  var isSubmitted by remember(currentIndex, grade) { mutableStateOf(false) }
  val scrollState = rememberScrollState()
  val coroutineScope = rememberCoroutineScope()

  if (items.isEmpty()) {
    Text(
      text = "මෙම ශ්‍රේණිය සඳහා ගැටලු ඉක්මනින් එක්වේ.",
      color = Color.White,
      fontSize = 11.sp,
      modifier = Modifier.padding(8.dp)
    )
    return
  }

  val safeIndex = currentIndex.coerceIn(0, items.size - 1)
  val currentItem = items[safeIndex]

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF172554))
      .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(6.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "🎯 $grade ගණිතය - O/L Speed MCQs ප්‍රශ්නාවලිය",
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF93C5FD)
      )
      Text(
        text = "${safeIndex + 1}/${items.size}",
        fontSize = 9.5.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF60A5FA)
      )
    }

    // Scroll Control Bar
    MathSubSectionScrollControls(
      title = "MCQs",
      itemCountText = "${safeIndex + 1}/${items.size} ප්‍රශ්න",
      scrollState = scrollState,
      coroutineScope = coroutineScope,
      accentColor = Color(0xFF2563EB),
      onOpenFullscreen = onOpenFullscreen
    )

    // Question Jump Strip
    LazyRow(
      horizontalArrangement = Arrangement.spacedBy(4.dp),
      modifier = Modifier.fillMaxWidth()
    ) {
      items(items.size) { idx ->
        val isCur = idx == safeIndex
        Surface(
          onClick = {
            currentIndex = idx
            selectedOption = null
            isSubmitted = false
          },
          shape = CircleShape,
          color = if (isCur) Color(0xFF38BDF8) else Color(0xFF1E3A8A),
          border = BorderStroke(1.dp, if (isCur) Color.White else Color(0xFF1D4ED8))
        ) {
          Text(
            text = "${idx + 1}",
            fontSize = 8.5.sp,
            fontWeight = FontWeight.Bold,
            color = if (isCur) Color(0xFF0F172A) else Color.White,
            modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.dp)
          )
        }
      }
    }

    // SubSection Content Container
    Column(
      modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      Text(
        text = "ඒකකය: ${currentItem.unitName}",
        fontSize = 8.5.sp,
        color = Color(0xFFBFDBFE)
      )

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
          isChosen -> Color(0xFF2563EB)
          else -> Color(0xFF1E3A8A)
        }

        Surface(
          onClick = {
            if (!isSubmitted) selectedOption = optIndex
          },
          shape = RoundedCornerShape(6.dp),
          color = optionBg,
          border = BorderStroke(1.dp, if (isChosen) Color.White else Color(0xFF1D4ED8)),
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

      if (!isSubmitted) {
        Button(
          onClick = {
            if (selectedOption != null) isSubmitted = true
          },
          enabled = selectedOption != null,
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB)),
          shape = RoundedCornerShape(6.dp),
          modifier = Modifier.align(Alignment.End),
          contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
        ) {
          Text("පිළිතුර තහවුරු කරන්න", fontSize = 10.sp, fontWeight = FontWeight.Bold)
        }
      } else {
        Surface(
          shape = RoundedCornerShape(6.dp),
          color = Color(0xFF0F172A),
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
              text = "පියවරෙන් පියවර විවරණය: ${currentItem.stepByStepExplanation}",
              fontSize = 9.sp,
              color = Color(0xFFBAE6FD)
            )
          }
        }

        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          if (safeIndex > 0) {
            OutlinedButton(
              onClick = {
                currentIndex = safeIndex - 1
                selectedOption = null
                isSubmitted = false
              },
              shape = RoundedCornerShape(6.dp),
              contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
            ) {
              Text("◀ පෙර ගැටලුව", fontSize = 9.5.sp, color = Color.White)
            }
          } else {
            Spacer(modifier = Modifier.width(1.dp))
          }

          if (safeIndex < items.size - 1) {
            Button(
              onClick = {
                currentIndex = safeIndex + 1
                selectedOption = null
                isSubmitted = false
              },
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3B82F6)),
              shape = RoundedCornerShape(6.dp),
              contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
            ) {
              Text("මීළඟ ගැටලුව ➔", fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
          }
        }
      }
    }
  }
}

// =============================================================
// FULL-SCREEN IMMERSIVE & SCROLLABLE MATHEMATICS SUITE
// =============================================================

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MathFullScreenModal(
  initialGrade: MathHubGradeFilter = MathHubGradeFilter.GRADE_10,
  onDismiss: () -> Unit
) {
  var currentGrade by remember { mutableStateOf(initialGrade) }
  var selectedTab by remember { mutableStateOf(0) }
  var searchQuery by remember { mutableStateOf("") }

  // Interactive Solvers State
  var quadA by remember { mutableStateOf("1") }
  var quadB by remember { mutableStateOf("-5") }
  var quadC by remember { mutableStateOf("6") }
  var quadResult by remember { mutableStateOf<String?>(null) }

  var loanAmount by remember { mutableStateOf("24000") }
  var loanRate by remember { mutableStateOf("12") }
  var loanMonths by remember { mutableStateOf("12") }
  var loanResult by remember { mutableStateOf<String?>(null) }

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false)
  ) {
    Scaffold(
      topBar = {
        TopAppBar(
          title = {
            Column {
              Text(
                text = "10 & 11 ගණිතය පූර්ණ නිර්දේශය (Full-Screen)",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Text(
                text = "සියලු ප්‍රමේයයන් • සූත්‍ර • පියවරෙන් පියවර විසඳුම් ගණක",
                fontSize = 10.sp,
                color = Color(0xFFBAE6FD)
              )
            }
          },
          navigationIcon = {
            IconButton(onClick = onDismiss) {
              Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White)
            }
          },
          colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF0F172A)
          )
        )
      },
      containerColor = Color(0xFF020617)
    ) { padding ->
      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
          .padding(padding)
          .padding(horizontal = 14.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        // Grade Selector Pill Bar
        item {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(10.dp))
              .background(Color(0xFF1E293B))
              .padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            MathHubGradeFilter.values().forEach { g ->
              val isSelected = currentGrade == g
              Surface(
                onClick = { currentGrade = g },
                shape = RoundedCornerShape(8.dp),
                color = if (isSelected) Color(0xFF0284C7) else Color.Transparent,
                modifier = Modifier.weight(1f)
              ) {
                Box(
                  modifier = Modifier.padding(vertical = 8.dp),
                  contentAlignment = Alignment.Center
                ) {
                  Text(
                    text = if (g == MathHubGradeFilter.GRADE_10) "📘 10 ශ්‍රේණිය (Grade 10)" else "📙 11 ශ්‍රේණිය (O/L Grade 11)",
                    fontSize = 12.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                    color = if (isSelected) Color.White else Color(0xFF94A3B8)
                  )
                }
              }
            }
          }
        }

        // Section Tabs Row
        item {
          val tabs = listOf("ජ්‍යාමිතිය", "වීජ ගණිතය", "මිනුම්", "මූල්‍ය", "සංඛ්‍යානය", "නිර්මාණ", "ලඝුගණක", "කුලක", "ශ්‍රේඪි", "ප්‍රස්ථාර/න්‍යාස", "Marking රහස්", "⚡ ගණක යන්ත්‍ර")
          LazyRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            items(tabs.size) { idx ->
              val isSel = selectedTab == idx
              Surface(
                onClick = { selectedTab = idx },
                shape = RoundedCornerShape(8.dp),
                color = if (isSel) Color(0xFF38BDF8) else Color(0xFF1E293B),
                border = BorderStroke(1.dp, if (isSel) Color.White else Color(0xFF334155))
              ) {
                Text(
                  text = tabs[idx],
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = if (isSel) Color(0xFF0F172A) else Color.White,
                  modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                )
              }
            }
          }
        }

        val activeGrade = currentGrade.gradeStr

        when (selectedTab) {
          0 -> {
            // GEOMETRY THEOREMS IN FULL DETAIL
            item {
              Text(
                text = "📐 $activeGrade ශ්‍රේණිය ජ්‍යාමිතික ප්‍රමේයයන් සහ සම්පූර්ණ සාධන",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF38BDF8)
              )
            }
            val theorems = MathGrade1011SyllabusRepository.geometryTheorems.filter { it.grade == activeGrade }
            items(theorems) { thm ->
              Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
                border = BorderStroke(1.dp, Color(0xFF0284C7).copy(alpha = 0.6f)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(thm.title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFF0284C7)) {
                      Text(thm.theoremNumber, fontSize = 9.sp, color = Color.White, modifier = Modifier.padding(4.dp, 2.dp))
                    }
                  }
                  Spacer(modifier = Modifier.height(6.dp))
                  Text("ප්‍රකාශය: ${thm.statement}", fontSize = 11.sp, color = Color(0xFFBAE6FD), fontWeight = FontWeight.SemiBold)
                  Spacer(modifier = Modifier.height(4.dp))
                  if (thm.givenData.isNotBlank()) {
                    Text("දත්තය: ${thm.givenData}", fontSize = 10.sp, color = Color(0xFFE2E8F0))
                  }
                  if (thm.construction.isNotBlank()) {
                    Text("නිර්මාණය: ${thm.construction}", fontSize = 10.sp, color = Color(0xFFFDE047))
                  }
                  Spacer(modifier = Modifier.height(6.dp))
                  Text("සාධනය පියවර:", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                  thm.proofSteps.forEach { step ->
                    Text("• $step", fontSize = 10.sp, color = Color.White)
                  }
                  Spacer(modifier = Modifier.height(6.dp))
                  Surface(shape = RoundedCornerShape(6.dp), color = Color(0xFF1E293B), modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(8.dp)) {
                      Text("ආදර්ශ ගැටලුව: ${thm.exampleProblem}", fontSize = 10.sp, color = Color(0xFFFED7AA))
                      Text("විසඳුම: ${thm.exampleSolution}", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
                    }
                  }
                }
              }
            }
          }

          1 -> {
            // ALGEBRA
            item {
              Text(
                text = "📈 $activeGrade ශ්‍රේණිය වීජ ගණිතය & වර්ගජ ශ්‍රිත ප්‍රස්ථාර",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF59E0B)
              )
            }
            val algItems = MathGrade1011SyllabusRepository.algebraItems.filter { it.grade == activeGrade }
            items(algItems) { alg ->
              Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1B4B)),
                border = BorderStroke(1.dp, Color(0xFF6366F1).copy(alpha = 0.6f)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Text(alg.topic, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                  Spacer(modifier = Modifier.height(4.dp))
                  Text("සූත්‍රය: ${alg.formula}", fontSize = 11.sp, fontFamily = FontFamily.Monospace, color = Color(0xFFFDE047))
                  Spacer(modifier = Modifier.height(6.dp))
                  Text(alg.conceptSummary, fontSize = 10.sp, color = Color(0xFFC7D2FE))
                  Spacer(modifier = Modifier.height(6.dp))
                  Text("පියවරෙන් පියවර විසඳීම:", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF818CF8))
                  alg.steps.forEach { s -> Text("➔ $s", fontSize = 10.sp, color = Color.White) }
                  Spacer(modifier = Modifier.height(6.dp))
                  Surface(shape = RoundedCornerShape(6.dp), color = Color(0xFF312E81), modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(8.dp)) {
                      Text("ගැටලුව: ${alg.sampleQuestion}", fontSize = 10.sp, color = Color(0xFFFDE68A))
                      alg.workedSolution.forEach { ws -> Text(ws, fontSize = 9.5.sp, color = Color.White) }
                      Text("අවසාන පිළිතුර: ${alg.finalResult}", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
                    }
                  }
                }
              }
            }
          }

          2 -> {
            // TRIGONOMETRY & MENSURATION
            item {
              Text(
                text = "📐 $activeGrade ශ්‍රේණිය ත්‍රිකෝණමිතිය, මිනුම් සහ දිගංශය",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF10B981)
              )
            }
            val trigs = MathGrade1011SyllabusRepository.trigAndMensurationItems.filter { it.grade == activeGrade }
            items(trigs) { trg ->
              Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF064E3B)),
                border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.6f)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Text(trg.title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                  Spacer(modifier = Modifier.height(4.dp))
                  Text("සූත්‍රය: ${trg.formula}", fontSize = 11.sp, fontFamily = FontFamily.Monospace, color = Color(0xFFFDE047))
                  Spacer(modifier = Modifier.height(6.dp))
                  Text(trg.formulaExplanation, fontSize = 10.sp, color = Color(0xFFA7F3D0))
                  Spacer(modifier = Modifier.height(6.dp))
                  Surface(shape = RoundedCornerShape(6.dp), color = Color(0xFF047857), modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(8.dp)) {
                      Text("ගැටලුව: ${trg.questionText}", fontSize = 10.sp, color = Color(0xFFFDE68A))
                      trg.stepByStepWorking.forEach { step -> Text("• $step", fontSize = 9.5.sp, color = Color.White) }
                      Text("පිළිතුර: ${trg.finalAnswer}", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
                    }
                  }
                }
              }
            }
          }

          3 -> {
            // FINANCIAL MATH
            item {
              Text(
                text = "💰 $activeGrade ශ්‍රේණිය මූල්‍ය ගණිතය සහ බදු ගණනය",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF43F5E)
              )
            }
            val fins = MathGrade1011SyllabusRepository.financialMathItems.filter { it.grade == activeGrade }
            items(fins) { fin ->
              Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF4C0519)),
                border = BorderStroke(1.dp, Color(0xFFE11D48).copy(alpha = 0.6f)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Text(fin.title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                  Spacer(modifier = Modifier.height(4.dp))
                  Text("සූත්‍රය: ${fin.formula}", fontSize = 10.5.sp, fontFamily = FontFamily.Monospace, color = Color(0xFFFDE047))
                  Spacer(modifier = Modifier.height(6.dp))
                  Text("නීති: ${fin.rulesSummary}", fontSize = 10.sp, color = Color(0xFFFECDD3))
                  Spacer(modifier = Modifier.height(6.dp))
                  Surface(shape = RoundedCornerShape(6.dp), color = Color(0xFF881337), modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(8.dp)) {
                      Text("ගැටලුව: ${fin.problemText}", fontSize = 10.sp, color = Color(0xFFFDE68A))
                      fin.calculationSteps.forEach { step -> Text("➔ $step", fontSize = 9.5.sp, color = Color.White) }
                      Text(fin.answer, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
                    }
                  }
                }
              }
            }
          }

          4 -> {
            // STATISTICS
            item {
              Text(
                text = "📊 $activeGrade ශ්‍රේණිය සංඛ්‍යානය සහ සම්භාවිතාව",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFA855F7)
              )
            }
            val stats = MathGrade1011SyllabusRepository.statAndProbItems.filter { it.grade == activeGrade }
            items(stats) { st ->
              Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1B4B)),
                border = BorderStroke(1.dp, Color(0xFF7C3AED).copy(alpha = 0.6f)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Text(st.title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                  Spacer(modifier = Modifier.height(4.dp))
                  Text("සූත්‍රය: ${st.formula}", fontSize = 10.5.sp, fontFamily = FontFamily.Monospace, color = Color(0xFFFDE047))
                  Spacer(modifier = Modifier.height(6.dp))
                  st.keyPoints.forEach { pt -> Text("• $pt", fontSize = 9.5.sp, color = Color(0xFFE0E7FF)) }
                  Spacer(modifier = Modifier.height(6.dp))
                  Surface(shape = RoundedCornerShape(6.dp), color = Color(0xFF312E81), modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(8.dp)) {
                      Text("ගැටලුව: ${st.workedExampleQuestion}", fontSize = 10.sp, color = Color(0xFFFDE68A))
                      st.solutionSteps.forEach { step -> Text("➔ $step", fontSize = 9.5.sp, color = Color.White) }
                      Text("ප්‍රතිඵලය: ${st.finalValue}", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
                    }
                  }
                }
              }
            }
          }

          5 -> {
            // CONSTRUCTIONS
            item {
              val items = MathAdvancedSyllabusRepository.constructionsList.filter { it.grade == activeGrade }
              MathConstructionsSubSection(items = items, grade = activeGrade)
            }
          }

          6 -> {
            // LOGARITHMS
            item {
              val items = MathAdvancedSyllabusRepository.logarithmsList.filter { it.grade == activeGrade }
              MathLogarithmsSubSection(items = items, grade = activeGrade)
            }
          }

          7 -> {
            // SETS & VENN DIAGRAMS
            item {
              val items = MathAdvancedSyllabusRepository.vennDiagramsList.filter { it.grade == activeGrade }
              MathVennSubSection(items = items, grade = activeGrade)
            }
          }

          8 -> {
            // PROGRESSIONS (AP & GP)
            item {
              val items = MathAdvancedSyllabusRepository.progressionsList.filter { it.grade == activeGrade }
              MathProgressionsSubSection(items = items, grade = activeGrade)
            }
          }

          9 -> {
            // VELOCITY-TIME GRAPHS & MATRICES
            item {
              val vels = MathAdvancedSyllabusRepository.velocityGraphsList.filter { it.grade == activeGrade }
              MathVelocitySubSection(items = vels, grade = activeGrade)
            }
            item {
              val mats = MathAdvancedSyllabusRepository.matricesAndIneqList.filter { it.grade == activeGrade }
              Column(
                modifier = Modifier
                  .fillMaxWidth()
                  .clip(RoundedCornerShape(8.dp))
                  .background(Color(0xFF1E1B4B))
                  .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
              ) {
                Text(
                  text = "🔲 $activeGrade ශ්‍රේණිය - න්‍යාස සහ අසමානතා සවිස්තරාත්මක සටහන්",
                  fontSize = 11.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFFA5B4FC)
                )
                mats.forEach { itm ->
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF312E81),
                    border = BorderStroke(1.dp, Color(0xFF6366F1)),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                      Text(itm.category, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                      Spacer(modifier = Modifier.height(2.dp))
                      Text(itm.conceptOrRules, fontSize = 9.sp, color = Color(0xFFC7D2FE))
                      Spacer(modifier = Modifier.height(4.dp))
                      Text("ක්‍රියාවලිය: ${itm.sampleOperation}", fontSize = 9.sp, fontFamily = FontFamily.Monospace, color = Color(0xFFFDE047))
                      itm.solutionSteps.forEach { s -> Text("• $s", fontSize = 8.5.sp, color = Color.White) }
                      Spacer(modifier = Modifier.height(3.dp))
                      Text("නිගමනය: ${itm.conclusion}", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
                    }
                  }
                }
              }
            }
          }

          10 -> {
            // O/L MARKING SCHEME & COMMON MISTAKES
            item {
              MathExamSecretsSubSection(items = MathAdvancedSyllabusRepository.examSecretsList)
            }
          }

          11 -> {
            // INTERACTIVE SOLVERS (QUADRATIC & FINANCIAL)
            item {
              Text(
                text = "⚡ අන්තර්ක්‍රියාකාරී ගණිත විසඳුම් ගණකය (Step-by-Step Solvers)",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF38BDF8)
              )
            }

            // 1. Quadratic Equation Solver Card
            item {
              Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
                border = BorderStroke(1.dp, Color(0xFF0284C7)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Text(
                    text = "1. වර්ගජ සමීකරණ විසඳුම් ගණකය (ax² + bx + c = 0)",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                  )
                  Spacer(modifier = Modifier.height(8.dp))
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                  ) {
                    OutlinedTextField(
                      value = quadA,
                      onValueChange = { quadA = it },
                      label = { Text("a", color = Color(0xFF94A3B8), fontSize = 10.sp) },
                      modifier = Modifier.weight(1f),
                      textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 12.sp),
                      singleLine = true
                    )
                    OutlinedTextField(
                      value = quadB,
                      onValueChange = { quadB = it },
                      label = { Text("b", color = Color(0xFF94A3B8), fontSize = 10.sp) },
                      modifier = Modifier.weight(1f),
                      textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 12.sp),
                      singleLine = true
                    )
                    OutlinedTextField(
                      value = quadC,
                      onValueChange = { quadC = it },
                      label = { Text("c", color = Color(0xFF94A3B8), fontSize = 10.sp) },
                      modifier = Modifier.weight(1f),
                      textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 12.sp),
                      singleLine = true
                    )
                  }
                  Spacer(modifier = Modifier.height(8.dp))
                  Button(
                    onClick = {
                      val a = quadA.toDoubleOrNull() ?: 1.0
                      val b = quadB.toDoubleOrNull() ?: 0.0
                      val c = quadC.toDoubleOrNull() ?: 0.0
                      val disc = b * b - 4 * a * c
                      quadResult = if (disc < 0) {
                        "විවේචකය b² - 4ac = $disc < 0 බැවින් තාත්වික මූල නොපවතී."
                      } else {
                        val root1 = (-b + sqrt(disc)) / (2 * a)
                        val root2 = (-b - sqrt(disc)) / (2 * a)
                        "විවේචකය (b² - 4ac) = $disc\n√($disc) = %.2f\nx₁ = %.2f\nx₂ = %.2f".format(sqrt(disc), root1, root2)
                      }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Text("විසඳන්න (Calculate Step-by-Step)", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                  }

                  quadResult?.let { res ->
                    Spacer(modifier = Modifier.height(8.dp))
                    Surface(
                      color = Color(0xFF1E293B),
                      shape = RoundedCornerShape(6.dp),
                      modifier = Modifier.fillMaxWidth()
                    ) {
                      Text(
                        text = res,
                        fontSize = 11.sp,
                        fontFamily = FontFamily.Monospace,
                        color = Color(0xFF4ADE80),
                        modifier = Modifier.padding(8.dp)
                      )
                    }
                  }
                }
              }
            }

            // 2. Reducing Balance Loan Calculator Card
            item {
              Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1B4B)),
                border = BorderStroke(1.dp, Color(0xFF6366F1)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Text(
                    text = "2. හීනවන ශේෂ වාරික ණය ගණකය (Installment Loan)",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                  )
                  Spacer(modifier = Modifier.height(8.dp))
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                  ) {
                    OutlinedTextField(
                      value = loanAmount,
                      onValueChange = { loanAmount = it },
                      label = { Text("ණය මුදල", color = Color(0xFF94A3B8), fontSize = 10.sp) },
                      modifier = Modifier.weight(1.2f),
                      textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 12.sp),
                      singleLine = true
                    )
                    OutlinedTextField(
                      value = loanRate,
                      onValueChange = { loanRate = it },
                      label = { Text("පොලිය %", color = Color(0xFF94A3B8), fontSize = 10.sp) },
                      modifier = Modifier.weight(0.9f),
                      textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 12.sp),
                      singleLine = true
                    )
                    OutlinedTextField(
                      value = loanMonths,
                      onValueChange = { loanMonths = it },
                      label = { Text("මාස ගණන", color = Color(0xFF94A3B8), fontSize = 10.sp) },
                      modifier = Modifier.weight(0.9f),
                      textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 12.sp),
                      singleLine = true
                    )
                  }
                  Spacer(modifier = Modifier.height(8.dp))
                  Button(
                    onClick = {
                      val p = loanAmount.toDoubleOrNull() ?: 24000.0
                      val r = loanRate.toDoubleOrNull() ?: 12.0
                      val n = loanMonths.toIntOrNull() ?: 12
                      val monthlyCapital = p / n
                      val monthUnits = (n * (n + 1)) / 2
                      val unitInterest = monthlyCapital * (r / 100.0) * (1.0 / 12.0)
                      val totalInterest = monthUnits * unitInterest
                      val totalPayment = p + totalInterest
                      val monthlyInstallment = totalPayment / n
                      loanResult = "මාස ඒකක ගණන = $monthUnits\nමාසික ණය පියවීම = රු. %.2f\nමුළු පොලිය = රු. %.2f\nගෙවිය යුතු මුළු මුදල = රු. %.2f\nමාසික වාරිකය = රු. %.2f".format(
                        monthlyCapital, totalInterest, totalPayment, monthlyInstallment
                      )
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Text("වාරිකය ගණනය කරන්න (Calculate)", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                  }

                  loanResult?.let { lRes ->
                    Spacer(modifier = Modifier.height(8.dp))
                    Surface(
                      color = Color(0xFF0F172A),
                      shape = RoundedCornerShape(6.dp),
                      modifier = Modifier.fillMaxWidth()
                    ) {
                      Text(
                        text = lRes,
                        fontSize = 11.sp,
                        fontFamily = FontFamily.Monospace,
                        color = Color(0xFF38BDF8),
                        modifier = Modifier.padding(8.dp)
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

@Composable
private fun MathSolverSubSection(onClose: () -> Unit) {
  Column(modifier = Modifier.padding(8.dp).fillMaxWidth().background(Color(0xFF0F172A), RoundedCornerShape(8.dp)).padding(8.dp)) {
    Text("සමීකරණ විසඳුම්කරු", color = Color.White, fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(4.dp))
    Text("සමීකරණය ඇතුළත් කරන්න: ax² + bx + c = 0", color = Color(0xFF94A3B8), fontSize = 12.sp)
    Button(onClick = onClose, modifier = Modifier.padding(top = 8.dp)) { Text("වසන්න") }
  }
}

@Composable
private fun MathGraphExplorerSubSection(onClose: () -> Unit) {
  Column(modifier = Modifier.padding(8.dp).fillMaxWidth().background(Color(0xFF0F172A), RoundedCornerShape(8.dp)).padding(8.dp)) {
    Text("ප්‍රස්ථාර ගවේෂකය", color = Color.White, fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(4.dp))
    Text("වර්ගජ ප්‍රස්ථාරයක හැඩය (a > 0 / a < 0) ගවේෂණය කරන්න.", color = Color(0xFF94A3B8), fontSize = 12.sp)
    Button(onClick = onClose, modifier = Modifier.padding(top = 8.dp)) { Text("වසන්න") }
  }
}

@Composable
private fun MathMarkingSecretsSubSection(onClose: () -> Unit) {
  Column(modifier = Modifier.padding(8.dp).fillMaxWidth().background(Color(0xFF0F172A), RoundedCornerShape(8.dp)).padding(8.dp)) {
    Text("විභාග උපදෙස් (Marking Secrets)", color = Color.White, fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(4.dp))
    Text("1. සෑම පියවරකටම ලකුණු ලැබේ.\n2. ඒකක අමතක නොකරන්න.\n3. අවසාන පිළිතුර තනි අගයකට ගොනු කරන්න.", color = Color(0xFF94A3B8), fontSize = 12.sp)
    Button(onClick = onClose, modifier = Modifier.padding(top = 8.dp)) { Text("වසන්න") }
  }
}

