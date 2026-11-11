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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import kotlinx.coroutines.launch

// =============================================================
// EXPANDED DATA MODELS FOR O/L MATHEMATICS (GRADES 10 & 11)
// =============================================================

data class MathConstructionItem(
  val id: String,
  val grade: String,
  val title: String,
  val toolType: String, // "කෝණ නිර්මාණය", "අන්තර්වෘත්තය", "පරිවෘත්තය", "ස්පර්ශක"
  val requiredTools: String,
  val steps: List<String>,
  val examTips: String,
  val markingSchemeNote: String
)

data class MathLogarithmItem(
  val id: String,
  val grade: String,
  val topic: String,
  val lawOrRule: String,
  val characteristicExplanation: String,
  val workedSteps: List<String>,
  val exampleCalculation: String,
  val finalValue: String
)

data class MathVennDiagramItem(
  val id: String,
  val grade: String,
  val title: String,
  val setsCount: Int, // 2 or 3
  val formulaUsed: String,
  val regionsDescription: List<String>,
  val sampleExamProblem: String,
  val stepByStepSolution: List<String>,
  val finalAnswer: String
)

data class MathProgressionItem(
  val id: String,
  val grade: String,
  val type: String, // "සමාන්තර ශ්‍රේඪි (AP)" or "ගුණෝත්තර ශ්‍රේඪි (GP)"
  val generalTermFormula: String,
  val sumFormula: String,
  val properties: List<String>,
  val examProblem: String,
  val stepWorking: List<String>,
  val finalResult: String
)

data class MathMatrixAndInequalityItem(
  val id: String,
  val grade: String,
  val category: String, // "න්‍යාස (Matrices)" or "අසමානතා (Inequalities)"
  val conceptOrRules: String,
  val sampleOperation: String,
  val solutionSteps: List<String>,
  val conclusion: String
)

data class MathVelocityGraphItem(
  val id: String,
  val grade: String,
  val title: String,
  val graphType: String,
  val formulaUsed: String,
  val problemStatement: String,
  val solutionSteps: List<String>,
  val answersSummary: String
)

data class MathExamSecretItem(
  val id: String,
  val category: String, // "Marking Scheme", "Common Mistakes", "Time Management"
  val title: String,
  val keyPoint: String,
  val practicalAdvice: String,
  val exampleCase: String
)

// =============================================================
// 100% ACCURATE SYLLABUS REPOSITORY FOR EXPANDED MATHEMATICS
// =============================================================

object MathAdvancedSyllabusRepository {

  // 1. CONSTRUCTIONS (Grade 10 & 11)
  val constructionsList = listOf(
    MathConstructionItem(
      id = "const_10_01",
      grade = "10",
      title = "මූලික කෝණ නිර්මාණය (60°, 120°, 90°, 45°, 30°)",
      toolType = "කෝණ නිර්මාණය",
      requiredTools = "පරිමාණ රූල සහ කවකටුව පමණි (කෝණමානය තහනම්)",
      steps = listOf(
        "60° නිර්මාණය: රේඛාවේ O ලක්ෂ්‍යයෙන් ඕනෑම අරයකින් චාපයක් අඳින්න (A ලක්ෂ්‍යය කපයි). එම අරයෙන්ම A හි කවකටුව තබා පළමු චාපය කැපෙන සේ B ලකුණු කර OB යා කරන්න. AÔB = 60° වේ.",
        "120° නිර්මාණය: එම අරයෙන්ම B සිට තවත් චාපයක් කැපූ විට 120° ලැබේ.",
        "30° නිර්මාණය: 60° කෝණය කවකටුවෙන් සමච්ඡේදනය කරන්න.",
        "90° නිර්මාණය: 60° සහ 120° චාප දෙක අතර කෝණය සමච්ඡේදනය කළ විට 90° (ලම්බකය) ලැබේ.",
        "45° නිර්මාණය: 90° කෝණය සමච්ඡේදනය කිරීමෙන් 45° ලැබේ."
      ),
      examTips = "කවකටු චාප කිසිවිටෙක මකන්න එපා! නිර්මාණ චාප දැකීමෙන් පරීක්ෂකවරයා සම්පූර්ණ ලකුණු ලබාදෙයි.",
      markingSchemeNote = "කටු සටහන (Rough Sketch) නිවැරදිව ඇඳ දත්ත ලකුණු කිරීමට ලකුණු 1ක් ලැබේ."
    ),
    MathConstructionItem(
      id = "const_11_01",
      grade = "11",
      title = "ත්‍රිකෝණයක අන්තර්වෘත්තය නිර්මාණය (Incircle)",
      toolType = "අන්තර්වෘත්තය",
      requiredTools = "කවකටුව, පරිමාණ රූල",
      steps = listOf(
        "පළමුව ලබාදී ඇති මිනුම් අනුව ත්‍රිකෝණය ABC නිර්මාණය කරන්න.",
        "ත්‍රිකෝණයේ ඕනෑම කෝණ දෙකක (උදා: B සහ C) කෝණ සමච්ඡේදක අඳින්න.",
        "එම කෝණ සමච්ඡේදක ඡේදනය වන ලක්ෂ්‍යය 'I' (අන්තර්වෘත්ත කේන්ද්‍රය) ලෙස ලකුණු කරන්න.",
        "I ලක්ෂ්‍යයේ සිට BC පාදයට ලම්බකයක් ඇඳ පාදය හමුවන ලක්ෂ්‍යය D ලකුණු කරන්න (ID = අරය r වේ).",
        "I කේන්ද්‍රය සහ ID අරය ලෙස ගෙන ත්‍රිකෝණයේ පාද 3ම ස්පර්ශ වන සේ අන්තර්වෘත්තය අඳින්න."
      ),
      examTips = "අන්තර්වෘත්තයේ කේන්ද්‍රය = කෝණ සමච්ඡේදක හමුවන ලක්ෂ්‍යයයි. අරය සොයාගැනීමට අනිවාර්යයෙන්ම පාදයකට ලම්බකයක් ඇඳිය යුතුය.",
      markingSchemeNote = "කෝණ සමච්ඡේදක 2කට ලකුණු 2, ලම්බකයට ලකුණු 1, වෘත්තයට ලකුණු 2 (මුළු ලකුණු 5)."
    ),
    MathConstructionItem(
      id = "const_11_02",
      grade = "11",
      title = "ත්‍රිකෝණයක පරිවෘත්තය නිර්මාණය (Circumcircle)",
      toolType = "පරිවෘත්තය",
      requiredTools = "කවකටුව, පරිමාණ රූල",
      steps = listOf(
        "දෙන ලද දත්ත අනුව ABC ත්‍රිකෝණය නිර්මාණය කරන්න.",
        "ත්‍රිකෝණයේ ඕනෑම පාද දෙකක (උදා: AB සහ AC) ලම්බ සමච්ඡේදක අඳින්න.",
        "එම ලම්බ සමච්ඡේදක දෙක ඡේදනය වන ලක්ෂ්‍යය 'O' (පරිවෘත්ත කේන්ද්‍රය) ලෙස නම් කරන්න.",
        "OA (හෝ OB හෝ OC) අරය ලෙස ගෙන O කේන්ද්‍රය වටා ශීර්ෂ 3ම හරහා යන පරිදි පරිවෘත්තය අඳින්න."
      ),
      examTips = "පරිවෘත්ත කේන්ද්‍රය = පාදවල ලම්බ සමච්ඡේදක හමුවන ලක්ෂ්‍යය. සෘජුකෝණී ත්‍රිකෝණයක නම් පරිවෘත්ත කේන්ද්‍රය හරියටම කර්ණයේ මැද පිහිටයි.",
      markingSchemeNote = "පාද ලම්බ සමච්ඡේදක 2කට ලකුණු 2, කේන්ද්‍රය හා වෘත්තයට ලකුණු 2."
    ),
    MathConstructionItem(
      id = "const_11_03",
      grade = "11",
      title = "වෘත්තයකට ස්පර්ශක නිර්මාණය (Tangents)",
      toolType = "ස්පර්ශක",
      requiredTools = "කවකටුව, පරිමාණ රූල",
      steps = listOf(
        "වෘත්තය මත ලක්ෂ්‍යයකදී: අරය OP ඇඳ P හරහා OP ට ලම්බක රේඛාවක් නිර්මාණය කරන්න (ස්පර්ශකය අරයට ලම්බ වේ).",
        "බාහිර ලක්ෂ්‍යයක සිට: වෘත්ත කේන්ද්‍රය O සහ බාහිර ලක්ෂ්‍යය T යා කරන්න.",
        "OT රේඛා ඛණ්ඩයේ ලම්බ සමච්ඡේදකය ඇඳ එහි මධ්‍ය ලක්ෂ්‍යය M සොයන්න.",
        "M කේන්ද්‍රය සහ MO අරය ලෙස ගෙන මුල් වෘත්තය ඡේදනය වන පරිදි චාපයක් අඳින්න (A සහ B ලක්ෂ්‍ය).",
        "TA සහ TB යා කරන්න. මේවා බාහිර ලක්ෂ්‍යයේ සිට ඇඳි ස්පර්ශක යුගලයි (TA = TB වේ)."
      ),
      examTips = "බාහිර ලක්ෂ්‍යයක සිට වෘත්තයකට අඳින ස්පර්ශක ඛණ්ඩ දෙක දිගින් සමාන බව මතක තබාගන්න.",
      markingSchemeNote = "OT සමච්ඡේදනයට ලකුණු 1, චාප ලකුණු කිරීමට ලකුණු 1, ස්පර්ශක 2ට ලකුණු 2."
    )
  )

  // 2. LOGARITHMS & 4-FIGURE TABLES (Grade 10 & 11)
  val logarithmsList = listOf(
    MathLogarithmItem(
      id = "log_10_01",
      grade = "10",
      topic = "විද්‍යාත්මක අංකනය සහ මූලික ලඝුගණක නීති",
      lawOrRule = "විද්‍යාත්මක අංකනය: a × 10ⁿ (1 ≤ a < 10, n නිඛිලයකි)",
      characteristicExplanation = "සංඛ්‍යාවක ලක්ෂණය: 1 ට වැඩි සංඛ්‍යාවල පූර්ණ සංඛ්‍යා ඉලක්කම් ගණනින් 1ක් අඩු කළ විට ලක්ෂණය ලැබේ. උදා: 345.6 හි ඉලක්කම් 3ක් ඇති බැවින් ලක්ෂණය 2 කි.",
      workedSteps = listOf(
        "34500 = 3.45 × 10⁴ (ලක්ෂණය 4)",
        "0.0078 = 7.8 × 10⁻³ (ලක්ෂණය 3̄ [බාර් 3])",
        "නීතිය 1: lg (xy) = lg x + lg y",
        "නීතිය 2: lg (x / y) = lg x - lg y",
        "නීතිය 3: lg (xⁿ) = n lg x"
      ),
      exampleCalculation = "lg (1000) = lg (10³) = 3 lg 10 = 3 × 1 = 3",
      finalValue = "ලක්ෂණය + දශමාංශය = lg අගය"
    ),
    MathLogarithmItem(
      id = "log_11_01",
      grade = "11",
      topic = "ලඝුගණක වගු භාවිතයෙන් සංකීර්ණ ගණනය කිරීම් (O/L Model)",
      lawOrRule = "lg P = lg a + lg b - lg c  ➔  P = Antilog (lg P)",
      characteristicExplanation = "දශම සංඛ්‍යාවල ලක්ෂණය: දශම ලක්ෂ්‍යයට පසු පළමු ශූන්‍ය නොවන ඉලක්කම දක්වා ඇති ශූන්‍ය ගණනට 1ක් එකතු කර සෘණ ලකුණ (බාර්) යොදයි. උදා: 0.045 හි ශූන්‍ය 1ක් ඇති බැවින් ලක්ෂණය 2̄ කි.",
      workedSteps = listOf(
        "ගැටලුව: (45.3 × 3.14) / 18.5 හි අගය ලඝුගණක වගුවෙන් සොයන්න.",
        "x = (45.3 × 3.14) / 18.5 යැයි ගනිමු.",
        "lg x = lg 45.3 + lg 3.14 - lg 18.5",
        "lg 45.3 = 1.6561",
        "lg 3.14 = 0.4969",
        "එකතුව = 1.6561 + 0.4969 = 2.1530",
        "lg 18.5 = 1.2672",
        "අඩු කිරීම: 2.1530 - 1.2672 = 0.8858",
        "x = Antilog (0.8858) = 7.688 (හෝ 7.69)"
      ),
      exampleCalculation = "(45.3 × 3.14) / 18.5",
      finalValue = "7.688"
    ),
    MathLogarithmItem(
      id = "log_11_02",
      grade = "11",
      topic = "සෘණ ලක්ෂණ සහිත ලඝුගණක බෙදීම (වර්ගමූල / ඝනමූල)",
      lawOrRule = "lg (ⁿ√x) = (lg x) / n",
      characteristicExplanation = "බාර් ලක්ෂණය බෙදීමේදී එය n න් බෙදෙන සේ සකස් කළ යුතුය: උදා: 2̄.4560 / 3 නම් 3̄ + 1.4560 ලෙස ලියා 3න් බෙදයි ➔ 1̄ + 0.4853 = 1̄.4853.",
      workedSteps = listOf(
        "ගැටලුව: √(0.0576) හි අගය සොයන්න.",
        "lg (√0.0576) = 1/2 × lg (0.0576)",
        "lg (0.0576) = 2̄.7604",
        "1/2 × 2̄.7604 = (2̄ / 2) + (0.7604 / 2) = 1̄ + 0.3802 = 1̄.3802",
        "Antilog (1̄.3802) = 0.240"
      ),
      exampleCalculation = "√(0.0576)",
      finalValue = "0.24"
    )
  )

  // 3. SETS & VENN DIAGRAMS (Grade 10 & 11)
  val vennDiagramsList = listOf(
    MathVennDiagramItem(
      id = "venn_10_01",
      grade = "10",
      title = "කුලක 2ක වෙන් රූප සහ මූලික සූත්‍රය",
      setsCount = 2,
      formulaUsed = "n(A ∪ B) = n(A) + n(B) - n(A ∩ B)",
      regionsDescription = listOf(
        "A පමණක් (A only): A ∩ B'",
        "B පමණක් (B only): A' ∩ B",
        "A සහ B දෙකම (Both): A ∩ B",
        "A හෝ B දෙකෙන්ම පිටත (Neither): (A ∪ B)'"
      ),
      sampleExamProblem = "සිසුන් 40 දෙනෙකුගෙන් 25ක් ක්‍රිකට් ද, 20ක් පාපන්දු ද, 8ක් ක්‍රීඩා දෙකම ද ක්‍රීඩා කරති. (i) එක් ක්‍රීඩාවක් පමණක් කරන (ii) කිසිදු ක්‍රීඩාවක් නොකරන සිසුන් ගණන සොයන්න.",
      stepByStepSolution = listOf(
        "n(ε) = 40, n(C) = 25, n(F) = 20, n(C ∩ F) = 8",
        "ක්‍රිකට් පමණක් කරන පිරිස = 25 - 8 = 17",
        "පාපන්දු පමණක් කරන පිරිස = 20 - 8 = 12",
        "(i) එක් ක්‍රීඩාවක් පමණක් කරන පිරිස = 17 + 12 = 29",
        "n(C ∪ F) = 17 + 8 + 12 = 37",
        "(ii) කිසිදු ක්‍රීඩාවක් නොකරන පිරිස = 40 - 37 = 3"
      ),
      finalAnswer = "එක් ක්‍රීඩාවක් පමණක් = 29, කිසිදු ක්‍රීඩාවක් නැති = 3"
    ),
    MathVennDiagramItem(
      id = "venn_11_01",
      grade = "11",
      title = "කුලක 3ක වෙන් රූප සහ විභාග සමීකරණ (O/L Paper 2 Model)",
      setsCount = 3,
      formulaUsed = "n(A ∪ B ∪ C) = n(A)+n(B)+n(C) - [n(A∩B)+n(B∩C)+n(C∩A)] + n(A∩B∩C)",
      regionsDescription = listOf(
        "ප්‍රදේශය x: තුනම කරන පිරිස (A ∩ B ∩ C) - සැමවිටම පළමුව මැදින් පටන් ගන්න",
        "දෙකක් පමණක් කරන ප්‍රදේශ: (A ∩ B) - x, (B ∩ C) - x, (C ∩ A) - x",
        "එකක් පමණක් කරන ප්‍රදේශ: අදාළ කුලකයේ මුළු අගයෙන් අනෙක් 3 අඩු කිරීම"
      ),
      sampleExamProblem = "පාසලක සංගීතය (M), නාට්‍ය (D), චිත්‍ර (A) හදාරන සිසුන් 60 කි. 3ම හදාරන ගණන 4 කි. සංගීතය හා නාට්‍ය 10ක්, නාට්‍ය හා චිත්‍ර 8ක්, සංගීතය හා චිත්‍ර 7ක් ද වේ. විෂය 2ක් පමණක් හදාරන සිසුන් ගණන සොයන්න.",
      stepByStepSolution = listOf(
        "තුනම හදාරන සංඛ්‍යාව = 4",
        "සංගීතය හා නාට්‍ය පමණක් = 10 - 4 = 6",
        "නාට්‍ය හා චිත්‍ර පමණක් = 8 - 4 = 4",
        "සංගීතය හා චිත්‍ර පමණක් = 7 - 4 = 3",
        "විෂය 2ක් පමණක් හදාරන මුළු සිසුන් ගණන = 6 + 4 + 3 = 13"
      ),
      finalAnswer = "විෂය 2ක් පමණක් හදාරන සිසුන් = 13"
    )
  )

  // 4. PROGRESSIONS (AP & GP) (Grade 10 & 11)
  val progressionsList = listOf(
    MathProgressionItem(
      id = "prog_10_01",
      grade = "10",
      type = "සංඛ්‍යා රටා සහ සාධාරණ පදය (Number Patterns)",
      generalTermFormula = "Tₙ = an + b  (රේඛීය රටා සඳහා)",
      sumFormula = "ත්‍රිකෝණික සංඛ්‍යා: Tₙ = n(n + 1) / 2  |  චතුරස්‍ර සංඛ්‍යා: Tₙ = n²",
      properties = listOf(
        "පොදු අන්තරයක් පවතින රටාවල n හි සංගුණකය වන්නේ පොදු අන්තරයයි.",
        "1, 3, 6, 10, 15... යනු ත්‍රිකෝණික සංඛ්‍යා වේ.",
        "1, 4, 9, 16, 25... යනු චතුරස්‍ර සංඛ්‍යා වේ."
      ),
      examProblem = "5, 9, 13, 17, ... සංඛ්‍යා රටාවේ (i) සාධාරණ පදය (ii) 20 වන පදය සොයන්න.",
      stepWorking = listOf(
        "පොදු අන්තරය d = 9 - 5 = 4",
        "Tₙ = 4n + c  ➔  T₁ = 4(1) + c = 5  ➔  c = 1",
        "Tₙ = 4n + 1",
        "T₂₀ = 4(20) + 1 = 80 + 1 = 81"
      ),
      finalResult = "Tₙ = 4n + 1, T₂₀ = 81"
    ),
    MathProgressionItem(
      id = "prog_11_01",
      grade = "11",
      type = "සමාන්තර ශ්‍රේඪි (Arithmetic Progression - AP)",
      generalTermFormula = "Tₙ = a + (n - 1)d",
      sumFormula = "Sₙ = (n/2)[2a + (n - 1)d]  හෝ  Sₙ = (n/2)(a + l)",
      properties = listOf(
        "a = පළමු පදය, d = පොදු අන්තරය (T₂ - T₁), n = පද ගණන, l = අවසාන පදය",
        "d ධන නම් ශ්‍රේඪිය ආරෝහණය වේ; d සෘණ නම් ශ්‍රේඪිය අවරෝහණය වේ."
      ),
      examProblem = "සමාන්තර ශ්‍රේඪියක 3 වන පදය 11 ද, 7 වන පදය 23 ද වේ. (i) පළමු පදය a සහ පොදු අන්තරය d සොයන්න. (ii) මුල් පද 10 යේ එකතුව සොයන්න.",
      stepWorking = listOf(
        "T₃ = a + 2d = 11  --- (1)",
        "T₇ = a + 6d = 23  --- (2)",
        "(2) - (1): 4d = 12  ➔  d = 3",
        "d = 3 ආදේශයෙන්: a + 2(3) = 11  ➔  a + 6 = 11  ➔  a = 5",
        "S₁₀ = (10/2) [2(5) + (10 - 1)3] = 5 [10 + 27] = 5 × 37 = 185"
      ),
      finalResult = "a = 5, d = 3, S₁₀ = 185"
    ),
    MathProgressionItem(
      id = "prog_11_02",
      grade = "11",
      type = "ගුණෝත්තර ශ්‍රේඪි (Geometric Progression - GP)",
      generalTermFormula = "Tₙ = a rⁿ⁻¹",
      sumFormula = "Sₙ = a(rⁿ - 1) / (r - 1)  [r > 1 විට]  හෝ  Sₙ = a(1 - rⁿ) / (1 - r)  [r < 1 විට]",
      properties = listOf(
        "a = පළමු පදය, r = පොදු අනුපාතය (T₂ / T₁)",
        "බැක්ටීරියා ගුණනය, න්‍යෂ්ටික විඛණ්ඩනය, ජ්‍යාමිතික වර්ගඵල ආදී ක්ෂේත්‍රවල යෙදේ."
      ),
      examProblem = "2, 6, 18, 54, ... ගුණෝත්තර ශ්‍රේඪියේ 6 වන පදය සහ මුල් පද 5 හි එකතුව සොයන්න.",
      stepWorking = listOf(
        "a = 2, r = 6 / 2 = 3",
        "T₆ = a r⁵ = 2 × 3⁵ = 2 × 243 = 486",
        "S₅ = a(r⁵ - 1) / (r - 1) = 2(3⁵ - 1) / (3 - 1) = 2(243 - 1) / 2 = 242"
      ),
      finalResult = "T₆ = 486, S₅ = 242"
    )
  )

  // 5. MATRICES & INEQUALITIES (Grade 10 & 11)
  val matricesAndIneqList = listOf(
    MathMatrixAndInequalityItem(
      id = "mat_11_01",
      grade = "11",
      category = "න්‍යාස (Matrices)",
      conceptOrRules = "ගණය m × n (පේළි m, තීරු n). න්‍යාස දෙකක් එකතු/අඩු කළ හැක්කේ ගණ සමාන විට පමණි. A(m×p) සහ B(p×n) ගුණ කළ විට AB(m×n) ලැබේ.",
      sampleOperation = "[ 2  3 ] + [ 4  -1 ]  සහ  [ 2  1 ] × [ 3 ]\n[ 1  5 ]   [ 0   2 ]       [ 0  4 ]   [ 2 ]",
      solutionSteps = listOf(
        "එකතු කිරීම: [ 2+4   3+(-1) ] = [ 6  2 ]",
        "            [ 1+0   5+2    ]   [ 1  7 ]",
        "ගුණ කිරීම: පළමු පේළිය × තීරුව = 2(3) + 1(2) = 6 + 2 = 8",
        "දෙවන පේළිය × තීරුව = 0(3) + 4(2) = 0 + 8 = 8",
        "ගුණිතය = [ 8 ]\n         [ 8 ]  (ගණය 2 × 1)"
      ),
      conclusion = "න්‍යාස සමානතාව: [ x+2 ] = [ 7 ]  ➔  x + 2 = 7  ➔  x = 5"
    ),
    MathMatrixAndInequalityItem(
      id = "ineq_10_01",
      grade = "10",
      category = "අසමානතා සහ සංඛ්‍යා රේඛාව (Inequalities)",
      conceptOrRules = "අසමානතාවක් සෘණ සංඛ්‍යාවකින් ගුණ කිරීමේදී හෝ බෙදීමේදී අසමානතා ලකුණ අනිවාර්යයෙන්ම මාරු වේ (> ලකුණ < වේ).",
      sampleOperation = "විසඳන්න: 3x - 5 ≤ 7  (x නිඛිලයකි)",
      solutionSteps = listOf(
        "3x - 5 ≤ 7",
        "3x ≤ 7 + 5",
        "3x ≤ 12",
        "x ≤ 4",
        "සංඛ්‍යා රේඛාව මත: 4 මත පිරවූ (ඝන) වෘත්තයක් ඇඳ වමට ඊතලයක් අඳින්න.",
        "තෘප්ත කරන විශාලතම නිඛිලය = 4"
      ),
      conclusion = "විසඳුම් කුලකය: {..., 1, 2, 3, 4}"
    )
  )

  // 6. VELOCITY-TIME GRAPHS (Grade 10 & 11)
  val velocityGraphsList = listOf(
    MathVelocityGraphItem(
      id = "vel_11_01",
      grade = "11",
      title = "ප්‍රවේග-කාල ප්‍රස්ථාරය සහ චලිත ගැටලුව",
      graphType = "ත්‍රපීසියම් හැඩැති ප්‍රස්ථාරය (ත්වරණය ➔ ඒකාකාර ප්‍රවේගය ➔ මන්දනය)",
      formulaUsed = "අනුක්‍රමණය = ත්වරණය / මන්දනය,  ප්‍රස්ථාරය යටතේ වර්ගඵලය = ගමන් කළ මුළු දුර",
      problemStatement = "නිශ්චලතාවයෙන් ගමන් ආරම්භ කරන මෝටර් රථයක් තත්පර 10 කදී 20 m/s ඒකාකාර ප්‍රවේගයකට ත්වරණය වී, තත්පර 30 ක් එම ප්‍රවේගයෙන් ගමන් කර, තවත් තත්පර 10 කදී ඒකාකාරව මන්දනය වී නතර වේ. (i) ත්වරණය (ii) මුළු දුර (iii) සාමාන්‍ය ප්‍රවේගය සොයන්න.",
      solutionSteps = listOf(
        "(i) ත්වරණය = අනුක්‍රමණය = (20 - 0) / 10 = 2 ms⁻²",
        "(ii) මුළු කාලය = 10 + 30 + 10 = 50 s. ඒකාකාර කාලය = 30 s.",
        "ප්‍රස්ථාරය ත්‍රපීසියමකි: වර්ගඵලය = 1/2 × (සමාන්තර පාද එකතුව) × ලම්බ උස",
        "මුළු දුර = 1/2 × (50 + 30) × 20 = 1/2 × 80 × 20 = 800 m",
        "(iii) සාමාන්‍ය ප්‍රවේගය = මුළු දුර / මුළු කාලය = 800 m / 50 s = 16 ms⁻¹"
      ),
      answersSummary = "ත්වරණය = 2 ms⁻², මුළු දුර = 800 m, සාමාන්‍ය ප්‍රවේගය = 16 ms⁻¹"
    )
  )

  // 7. O/L EXAM SECRETS & TOP 20 COMMON MISTAKES
  val examSecretsList = listOf(
    MathExamSecretItem(
      id = "sec_01",
      category = "Marking Scheme",
      title = "M, A, B ලකුණු ලබාගන්නා රහස (Marking Codes)",
      keyPoint = "පියවරට ලකුණු (Method Marks): පිළිතුර වැරදුණත් නිවැරදි සූත්‍රය සහ ආදේශයට ලකුණු 70% ක් ලැබේ.",
      practicalAdvice = "කිසිදු ප්‍රශ්නයක් හිස්ව තියන්න එපා. අදාළ සූත්‍රය ලියා දත්ත ආදේශ කර තබන්න.",
      exampleCase = "වාරික ණය ගැටලුවක මාස ඒකක සූත්‍රය ලිවීමෙන් පමණක් ලකුණු 2ක් හිමිවේ!"
    ),
    MathExamSecretItem(
      id = "sec_02",
      category = "Common Mistakes",
      title = "සෘණ ලකුණු ගුණ කිරීමේ වරද (- × - = +)",
      keyPoint = "වරහන් ඉවත් කිරීමේදී පිටත ඇති සෘණ ලකුණ නිසා ඇතුළත සියලු ලකුණු මාරු වේ.",
      practicalAdvice = "-(2x - 3) ලිවීමේදී -2x + 3 ලෙස ලිවිය යුතුය. බොහෝ සිසුන් -2x - 3 ලෙස ලියා ලකුණු අහිමි කරගනී.",
      exampleCase = "2x² - 4ac හි c සෘණ නම්: -4(2)(-3) = +24 වේ."
    ),
    MathExamSecretItem(
      id = "sec_03",
      category = "Common Mistakes",
      title = "ඒකක අමතක වීම (Units Penalty)",
      keyPoint = "වර්ගඵලයට cm² හෝ m², පරිමාවට cm³ හෝ m³, පොලියට 'රු.', දිගට cm/m නොලිවීමෙන් අවසාන ලකුණ (A mark) කැපේ.",
      practicalAdvice = "ප්‍රශ්නය අවසානයේ පිළිතුර යටින් ඉරක් ඇඳ නිවැරදි ඒකකය ලියන්න.",
      exampleCase = "1540 ලෙස පමණක් නොලියා '1540 cm³' ලෙස ලියන්න."
    ),
    MathExamSecretItem(
      id = "sec_04",
      category = "Common Mistakes",
      title = "ජ්‍යාමිතියේ හේතු (Reasons) නොලිවීම",
      keyPoint = "සාධනයේ සෑම පේළියකටම වරහන් තුළ ජ්‍යාමිතික හේතුව නොලිවුවහොත් එම පියවරට ලකුණු නොලැබේ.",
      practicalAdvice = "උදා: AÔB = 90° (අර්ධ වෘත්තයේ කෝණය), AB = CD (සමාන්තරාස්‍රයක සම්මුඛ පාද).",
      exampleCase = "හේතු ලියා තිබුණහොත් සාධනය අසම්පූර්ණ වුවත් කොටස් ලකුණු ලැබේ."
    ),
    MathExamSecretItem(
      id = "sec_05",
      category = "Time Management",
      title = "විභාග ශාලාවේ පැය 3 නිවැරදිව බෙදාගැනීම",
      keyPoint = "I පත්‍රය (පැය 2): A කොටස කෙටි ප්‍රශ්න 25ට විනාඩි 50, B කොටස ප්‍රශ්න 5ට විනාඩි 60, පරීක්ෂාවට විනාඩි 10.",
      practicalAdvice = "II පත්‍රය (පැය 3): තෝරාගත යුතු ප්‍රශ්න 10 සඳහා එක් ප්‍රශ්නයකට උපරිම විනාඩි 16-17 ක් පමණක් ගන්න.",
      exampleCase = "එක් අපහසු ප්‍රශ්නයක සිර නොවී එය පසුවට තබා ලකුණු පහසු ප්‍රශ්න (ප්‍රස්ථාර, සංඛ්‍යානය, වාරික ණය) පළමුව කරන්න."
    )
  )
}

// =============================================================
// EXPANDED MODULE VIEWS & COMPONENT BUILDERS (WITH INTERNAL SCROLLING)
// =============================================================

@Composable
fun MathConstructionsSubSection(
  items: List<MathConstructionItem>,
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
      it.toolType.contains(searchQuery, ignoreCase = true) ||
      it.requiredTools.contains(searchQuery, ignoreCase = true) ||
      it.steps.any { s -> s.contains(searchQuery, ignoreCase = true) }
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF042F2E))
      .padding(8.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text("📏", fontSize = 13.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "$grade ශ්‍රේණිය - ජ්‍යාමිතික නිර්මාණ (${filteredItems.size}/${items.size})",
          fontSize = 11.5.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFF5EEAD4)
        )
      }
      IconButton(
        onClick = onOpenFullscreen,
        modifier = Modifier.size(26.dp)
      ) {
        Icon(Icons.Default.Fullscreen, contentDescription = "Fullscreen", tint = Color(0xFF5EEAD4), modifier = Modifier.size(18.dp))
      }
    }

    Spacer(modifier = Modifier.height(4.dp))

    // Search Box
    OutlinedTextField(
      value = searchQuery,
      onValueChange = { searchQuery = it },
      placeholder = { Text("නිර්මාණ වර්ගය හෝ පියවර සොයන්න...", fontSize = 9.sp, color = Color(0xFF99F6E4).copy(alpha = 0.6f)) },
      singleLine = true,
      modifier = Modifier
        .fillMaxWidth()
        .height(42.dp),
      colors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = Color.White,
        unfocusedTextColor = Color.White,
        focusedBorderColor = Color(0xFF14B8A6),
        unfocusedBorderColor = Color(0xFF0D9488).copy(alpha = 0.5f),
        focusedContainerColor = Color(0xFF134E4A),
        unfocusedContainerColor = Color(0xFF134E4A)
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

    // Scroll Control Bar
    Surface(
      shape = RoundedCornerShape(6.dp),
      color = Color(0xFF115E59),
      modifier = Modifier.fillMaxWidth()
    ) {
      Row(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Text("↕️", fontSize = 10.sp)
          Spacer(modifier = Modifier.width(4.dp))
          Text(
            text = "ඉහල පහල scroll කරන්න (${filteredItems.size}ක්)",
            fontSize = 9.sp,
            color = Color(0xFFCCFBF1)
          )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
          Surface(
            onClick = { coroutineScope.launch { scrollState.animateScrollTo(0) } },
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFF0D9488)
          ) {
            Text("⬆️ ඉහළට", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp))
          }
          Surface(
            onClick = { coroutineScope.launch { scrollState.animateScrollTo(scrollState.maxValue) } },
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFF0D9488)
          ) {
            Text("⬇️ පහළට", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp))
          }
          Surface(
            onClick = onOpenFullscreen,
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFF0F766E)
          ) {
            Text("⛶ විශාල කර", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp))
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(6.dp))

    // SubSection Content Container
    Column(
      modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      if (filteredItems.isEmpty()) {
        Box(
          modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
          contentAlignment = Alignment.Center
        ) {
          Text("ගැළපෙන ජ්‍යාමිතික නිර්මාණ හමු නොවීය.", color = Color(0xFF99F6E4), fontSize = 10.sp)
        }
      } else {
        filteredItems.forEach { item ->
          var isExpanded by remember { mutableStateOf(false) }
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFF134E4A),
            border = BorderStroke(1.dp, Color(0xFF0D9488)),
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
                Text(item.title, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFF0D9488)) {
                  Text(item.toolType, fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(4.dp, 1.dp))
                }
              }
              Spacer(modifier = Modifier.height(3.dp))
              Text("උපකරණ: ${item.requiredTools}", fontSize = 9.sp, color = Color(0xFF99F6E4))

              if (isExpanded) {
                Spacer(modifier = Modifier.height(6.dp))
                Text("නිර්මාණ පියවර:", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFCCFBF1))
                item.steps.forEachIndexed { i, s ->
                  Text("${i + 1}. $s", fontSize = 9.sp, color = Color.White)
                }
                Spacer(modifier = Modifier.height(4.dp))
                Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFF042F2E), modifier = Modifier.fillMaxWidth()) {
                  Column(modifier = Modifier.padding(6.dp)) {
                    Text("💡 විභාග උපදෙස්: ${item.examTips}", fontSize = 8.5.sp, color = Color(0xFFFEF08A))
                    Text("📝 ලකුණු බෙදීම: ${item.markingSchemeNote}", fontSize = 8.5.sp, color = Color(0xFF86EFAC))
                  }
                }
              } else {
                Text(
                  text = "සියලු පියවර & ලකුණු ලබාදෙන ආකාරය බැලීමට ක්ලික් කරන්න ▾",
                  fontSize = 8.sp,
                  color = Color(0xFF5EEAD4).copy(alpha = 0.8f)
                )
              }
            }
          }
        }
      }
    }
  }
}

@Composable
fun MathLogarithmsSubSection(
  items: List<MathLogarithmItem>,
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
      it.lawOrRule.contains(searchQuery, ignoreCase = true) ||
      it.characteristicExplanation.contains(searchQuery, ignoreCase = true)
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF451A03))
      .padding(8.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text("🧮", fontSize = 13.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "$grade ශ්‍රේණිය - ලඝුගණක & දර්ශක (${filteredItems.size}/${items.size})",
          fontSize = 11.5.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFFFDE68A)
        )
      }
      IconButton(
        onClick = onOpenFullscreen,
        modifier = Modifier.size(26.dp)
      ) {
        Icon(Icons.Default.Fullscreen, contentDescription = "Fullscreen", tint = Color(0xFFFDE68A), modifier = Modifier.size(18.dp))
      }
    }

    Spacer(modifier = Modifier.height(4.dp))

    // Search Box
    OutlinedTextField(
      value = searchQuery,
      onValueChange = { searchQuery = it },
      placeholder = { Text("ලඝු නීති හෝ මාතෘකා සොයන්න...", fontSize = 9.sp, color = Color(0xFFFDE68A).copy(alpha = 0.6f)) },
      singleLine = true,
      modifier = Modifier
        .fillMaxWidth()
        .height(42.dp),
      colors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = Color.White,
        unfocusedTextColor = Color.White,
        focusedBorderColor = Color(0xFFF59E0B),
        unfocusedBorderColor = Color(0xFFD97706).copy(alpha = 0.5f),
        focusedContainerColor = Color(0xFF78350F),
        unfocusedContainerColor = Color(0xFF78350F)
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

    // Scroll Control Bar
    Surface(
      shape = RoundedCornerShape(6.dp),
      color = Color(0xFF92400E),
      modifier = Modifier.fillMaxWidth()
    ) {
      Row(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Text("↕️", fontSize = 10.sp)
          Spacer(modifier = Modifier.width(4.dp))
          Text(
            text = "ඉහල පහල scroll කරන්න (${filteredItems.size}ක්)",
            fontSize = 9.sp,
            color = Color(0xFFFEF3C7)
          )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
          Surface(
            onClick = { coroutineScope.launch { scrollState.animateScrollTo(0) } },
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFFD97706)
          ) {
            Text("⬆️ ඉහළට", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp))
          }
          Surface(
            onClick = { coroutineScope.launch { scrollState.animateScrollTo(scrollState.maxValue) } },
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFFD97706)
          ) {
            Text("⬇️ පහළට", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp))
          }
          Surface(
            onClick = onOpenFullscreen,
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFFB45309)
          ) {
            Text("⛶ විශාල කර", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp))
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(6.dp))

    // Internal Scrollable Container
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 260.dp, max = 500.dp)
        .verticalScroll(scrollState),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      if (filteredItems.isEmpty()) {
        Box(
          modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
          contentAlignment = Alignment.Center
        ) {
          Text("ගැළපෙන ලඝුගණක පාඩම් හමු නොවීය.", color = Color(0xFFFDE68A), fontSize = 10.sp)
        }
      } else {
        filteredItems.forEach { item ->
          var isExpanded by remember { mutableStateOf(false) }
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFF78350F),
            border = BorderStroke(1.dp, Color(0xFFD97706)),
            modifier = Modifier
              .fillMaxWidth()
              .clickable { isExpanded = !isExpanded }
          ) {
            Column(modifier = Modifier.padding(8.dp)) {
              Text(item.topic, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
              Spacer(modifier = Modifier.height(2.dp))
              Text("නීතිය/සූත්‍රය: ${item.lawOrRule}", fontSize = 9.5.sp, fontFamily = FontFamily.Monospace, color = Color(0xFFFDE047))

              if (isExpanded) {
                Spacer(modifier = Modifier.height(4.dp))
                Text("ලක්ෂණය: ${item.characteristicExplanation}", fontSize = 9.sp, color = Color(0xFFFEF3C7))
                Spacer(modifier = Modifier.height(4.dp))
                Text("ගණනය කිරීමේ පියවර:", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFBBF24))
                item.workedSteps.forEach { step ->
                  Text("➔ $step", fontSize = 9.sp, color = Color.White)
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text("අවසාන අගය: ${item.finalValue}", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
              } else {
                Text(
                  text = "විසඳූ උදාහරණ සහ ලක්ෂණය බලන්න ▾",
                  fontSize = 8.sp,
                  color = Color(0xFFFDE68A).copy(alpha = 0.8f)
                )
              }
            }
          }
        }
      }
    }
  }
}

@Composable
fun MathVennSubSection(
  items: List<MathVennDiagramItem>,
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
      it.formulaUsed.contains(searchQuery, ignoreCase = true) ||
      it.sampleExamProblem.contains(searchQuery, ignoreCase = true)
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF2E1065))
      .padding(8.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text("⭕", fontSize = 13.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "$grade ශ්‍රේණිය - කුලක & වෙන් රූප (${filteredItems.size}/${items.size})",
          fontSize = 11.5.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFFDDD6FE)
        )
      }
      IconButton(
        onClick = onOpenFullscreen,
        modifier = Modifier.size(26.dp)
      ) {
        Icon(Icons.Default.Fullscreen, contentDescription = "Fullscreen", tint = Color(0xFFDDD6FE), modifier = Modifier.size(18.dp))
      }
    }

    Spacer(modifier = Modifier.height(4.dp))

    // Search Box
    OutlinedTextField(
      value = searchQuery,
      onValueChange = { searchQuery = it },
      placeholder = { Text("කුලක සූත්‍ර හෝ ප්‍රශ්න සොයන්න...", fontSize = 9.sp, color = Color(0xFFDDD6FE).copy(alpha = 0.6f)) },
      singleLine = true,
      modifier = Modifier
        .fillMaxWidth()
        .height(42.dp),
      colors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = Color.White,
        unfocusedTextColor = Color.White,
        focusedBorderColor = Color(0xFFA855F7),
        unfocusedBorderColor = Color(0xFF7C3AED).copy(alpha = 0.5f),
        focusedContainerColor = Color(0xFF4C1D95),
        unfocusedContainerColor = Color(0xFF4C1D95)
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

    // Scroll Control Bar
    Surface(
      shape = RoundedCornerShape(6.dp),
      color = Color(0xFF581C87),
      modifier = Modifier.fillMaxWidth()
    ) {
      Row(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Text("↕️", fontSize = 10.sp)
          Spacer(modifier = Modifier.width(4.dp))
          Text(
            text = "ඉහල පහල scroll කරන්න (${filteredItems.size}ක්)",
            fontSize = 9.sp,
            color = Color(0xFFF3E8FF)
          )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
          Surface(
            onClick = { coroutineScope.launch { scrollState.animateScrollTo(0) } },
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFF7C3AED)
          ) {
            Text("⬆️ ඉහළට", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp))
          }
          Surface(
            onClick = { coroutineScope.launch { scrollState.animateScrollTo(scrollState.maxValue) } },
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFF7C3AED)
          ) {
            Text("⬇️ පහළට", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp))
          }
          Surface(
            onClick = onOpenFullscreen,
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFF6B21A8)
          ) {
            Text("⛶ විශාල කර", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp))
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(6.dp))

    // Internal Scrollable Container
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 260.dp, max = 500.dp)
        .verticalScroll(scrollState),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      if (filteredItems.isEmpty()) {
        Box(
          modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
          contentAlignment = Alignment.Center
        ) {
          Text("ගැළපෙන කුලක ගැටලු හමු නොවීය.", color = Color(0xFFDDD6FE), fontSize = 10.sp)
        }
      } else {
        filteredItems.forEach { item ->
          var isExpanded by remember { mutableStateOf(false) }
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFF4C1D95),
            border = BorderStroke(1.dp, Color(0xFF8B5CF6)),
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
                Text(item.title, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFF7C3AED)) {
                  Text("කුලක ${item.setsCount}", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(4.dp, 1.dp))
                }
              }
              Spacer(modifier = Modifier.height(3.dp))
              Text("සූත්‍රය: ${item.formulaUsed}", fontSize = 9.5.sp, fontFamily = FontFamily.Monospace, color = Color(0xFFFDE047))

              if (isExpanded) {
                Spacer(modifier = Modifier.height(4.dp))
                Text("ප්‍රදේශ සෙවනැලි කිරීම:", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFFA78BFA))
                item.regionsDescription.forEach { reg -> Text("• $reg", fontSize = 8.5.sp, color = Color.White) }
                Spacer(modifier = Modifier.height(4.dp))
                Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFF1E1B4B), modifier = Modifier.fillMaxWidth()) {
                  Column(modifier = Modifier.padding(6.dp)) {
                    Text("ගැටලුව: ${item.sampleExamProblem}", fontSize = 8.5.sp, color = Color(0xFFFDE68A))
                    item.stepByStepSolution.forEach { s -> Text("➔ $s", fontSize = 8.5.sp, color = Color.White) }
                    Text("පිළිතුර: ${item.finalAnswer}", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
                  }
                }
              } else {
                Text(
                  text = "ප්‍රදේශ සෙවනැලි කිරීම සහ පියවර බලන්න ▾",
                  fontSize = 8.sp,
                  color = Color(0xFFDDD6FE).copy(alpha = 0.8f)
                )
              }
            }
          }
        }
      }
    }
  }
}

@Composable
fun MathProgressionsSubSection(
  items: List<MathProgressionItem>,
  grade: String,
  onOpenFullscreen: () -> Unit = {}
) {
  var searchQuery by remember { mutableStateOf("") }
  val scrollState = rememberScrollState()
  val coroutineScope = rememberCoroutineScope()

  val filteredItems = remember(items, searchQuery) {
    if (searchQuery.isBlank()) items
    else items.filter {
      it.type.contains(searchQuery, ignoreCase = true) ||
      it.generalTermFormula.contains(searchQuery, ignoreCase = true) ||
      it.sumFormula.contains(searchQuery, ignoreCase = true) ||
      it.examProblem.contains(searchQuery, ignoreCase = true)
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF500724))
      .padding(8.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text("🔢", fontSize = 13.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "$grade ශ්‍රේණිය - සමාන්තර & ගුණෝත්තර ශ්‍රේඪි (${filteredItems.size}/${items.size})",
          fontSize = 11.5.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFFFBCFE8)
        )
      }
      IconButton(
        onClick = onOpenFullscreen,
        modifier = Modifier.size(26.dp)
      ) {
        Icon(Icons.Default.Fullscreen, contentDescription = "Fullscreen", tint = Color(0xFFFBCFE8), modifier = Modifier.size(18.dp))
      }
    }

    Spacer(modifier = Modifier.height(4.dp))

    // Search Box
    OutlinedTextField(
      value = searchQuery,
      onValueChange = { searchQuery = it },
      placeholder = { Text("ශ්‍රේඪි වර්ගය හෝ සූත්‍ර සොයන්න...", fontSize = 9.sp, color = Color(0xFFFBCFE8).copy(alpha = 0.6f)) },
      singleLine = true,
      modifier = Modifier
        .fillMaxWidth()
        .height(42.dp),
      colors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = Color.White,
        unfocusedTextColor = Color.White,
        focusedBorderColor = Color(0xFFEC4899),
        unfocusedBorderColor = Color(0xFFDB2777).copy(alpha = 0.5f),
        focusedContainerColor = Color(0xFF831843),
        unfocusedContainerColor = Color(0xFF831843)
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

    // Scroll Control Bar
    Surface(
      shape = RoundedCornerShape(6.dp),
      color = Color(0xFF9D174D),
      modifier = Modifier.fillMaxWidth()
    ) {
      Row(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Text("↕️", fontSize = 10.sp)
          Spacer(modifier = Modifier.width(4.dp))
          Text(
            text = "ඉහල පහල scroll කරන්න (${filteredItems.size}ක්)",
            fontSize = 9.sp,
            color = Color(0xFFFCE7F3)
          )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
          Surface(
            onClick = { coroutineScope.launch { scrollState.animateScrollTo(0) } },
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFFDB2777)
          ) {
            Text("⬆️ ඉහළට", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp))
          }
          Surface(
            onClick = { coroutineScope.launch { scrollState.animateScrollTo(scrollState.maxValue) } },
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFFDB2777)
          ) {
            Text("⬇️ පහළට", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp))
          }
          Surface(
            onClick = onOpenFullscreen,
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFFBE185D)
          ) {
            Text("⛶ විශාල කර", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp))
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(6.dp))

    // Internal Scrollable Container
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 260.dp, max = 500.dp)
        .verticalScroll(scrollState),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      if (filteredItems.isEmpty()) {
        Box(
          modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
          contentAlignment = Alignment.Center
        ) {
          Text("ගැළපෙන ශ්‍රේඪි පාඩම් හමු නොවීය.", color = Color(0xFFFBCFE8), fontSize = 10.sp)
        }
      } else {
        filteredItems.forEach { item ->
          var isExpanded by remember { mutableStateOf(false) }
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFF831843),
            border = BorderStroke(1.dp, Color(0xFFDB2777)),
            modifier = Modifier
              .fillMaxWidth()
              .clickable { isExpanded = !isExpanded }
          ) {
            Column(modifier = Modifier.padding(8.dp)) {
              Text(item.type, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
              Spacer(modifier = Modifier.height(3.dp))
              Text("සාධාරණ පදය: ${item.generalTermFormula}", fontSize = 9.5.sp, fontFamily = FontFamily.Monospace, color = Color(0xFFFDE047))
              Text("ඓක්‍යය සූත්‍රය: ${item.sumFormula}", fontSize = 9.5.sp, fontFamily = FontFamily.Monospace, color = Color(0xFF93C5FD))

              if (isExpanded) {
                Spacer(modifier = Modifier.height(4.dp))
                item.properties.forEach { p -> Text("• $p", fontSize = 8.5.sp, color = Color(0xFFFCE7F3)) }
                Spacer(modifier = Modifier.height(4.dp))
                Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFF4C0519), modifier = Modifier.fillMaxWidth()) {
                  Column(modifier = Modifier.padding(6.dp)) {
                    Text("ආදර්ශ ගැටලුව: ${item.examProblem}", fontSize = 8.5.sp, color = Color(0xFFFDE68A))
                    item.stepWorking.forEach { step -> Text("➔ $step", fontSize = 8.5.sp, color = Color.White) }
                    Text("ප්‍රතිඵලය: ${item.finalResult}", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
                  }
                }
              } else {
                Text(
                  text = "ශ්‍රේඪි ගුණාංග සහ ආදර්ශ ගැටලු විසඳුම බලන්න ▾",
                  fontSize = 8.sp,
                  color = Color(0xFFFBCFE8).copy(alpha = 0.8f)
                )
              }
            }
          }
        }
      }
    }
  }
}

@Composable
fun MathVelocitySubSection(
  items: List<MathVelocityGraphItem>,
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
      it.graphType.contains(searchQuery, ignoreCase = true) ||
      it.problemStatement.contains(searchQuery, ignoreCase = true)
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF0F172A))
      .padding(8.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text("🚗", fontSize = 13.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "$grade ශ්‍රේණිය - ප්‍රවේග-කාල ප්‍රස්ථාර (${filteredItems.size}/${items.size})",
          fontSize = 11.5.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFF38BDF8)
        )
      }
      IconButton(
        onClick = onOpenFullscreen,
        modifier = Modifier.size(26.dp)
      ) {
        Icon(Icons.Default.Fullscreen, contentDescription = "Fullscreen", tint = Color(0xFF38BDF8), modifier = Modifier.size(18.dp))
      }
    }

    Spacer(modifier = Modifier.height(4.dp))

    // Scroll Control Bar
    Surface(
      shape = RoundedCornerShape(6.dp),
      color = Color(0xFF1E293B),
      modifier = Modifier.fillMaxWidth()
    ) {
      Row(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Text("↕️", fontSize = 10.sp)
          Spacer(modifier = Modifier.width(4.dp))
          Text(
            text = "ඉහල පහල scroll කරන්න (${filteredItems.size}ක්)",
            fontSize = 9.sp,
            color = Color(0xFFBAE6FD)
          )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
          Surface(
            onClick = { coroutineScope.launch { scrollState.animateScrollTo(0) } },
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFF0284C7)
          ) {
            Text("⬆️ ඉහළට", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp))
          }
          Surface(
            onClick = { coroutineScope.launch { scrollState.animateScrollTo(scrollState.maxValue) } },
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFF0284C7)
          ) {
            Text("⬇️ පහළට", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp))
          }
          Surface(
            onClick = onOpenFullscreen,
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFF0369A1)
          ) {
            Text("⛶ විශාල කර", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp))
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(6.dp))

    // Internal Scrollable Container
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 260.dp, max = 500.dp)
        .verticalScroll(scrollState),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      filteredItems.forEach { item ->
        var isExpanded by remember { mutableStateOf(false) }
        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFF1E293B),
          border = BorderStroke(1.dp, Color(0xFF0284C7)),
          modifier = Modifier
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded }
        ) {
          Column(modifier = Modifier.padding(8.dp)) {
            Text(item.title, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Spacer(modifier = Modifier.height(2.dp))
            Text(item.graphType, fontSize = 9.sp, color = Color(0xFFBAE6FD))
            Spacer(modifier = Modifier.height(2.dp))
            Text("සූත්‍ර: ${item.formulaUsed}", fontSize = 9.sp, color = Color(0xFFFDE047))

            if (isExpanded) {
              Spacer(modifier = Modifier.height(4.dp))
              Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFF0F172A), modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(6.dp)) {
                  Text("ගැටලුව: ${item.problemStatement}", fontSize = 8.5.sp, color = Color(0xFFFED7AA))
                  item.solutionSteps.forEach { s -> Text("• $s", fontSize = 8.5.sp, color = Color.White) }
                  Text("අවසාන පිළිතුරු: ${item.answersSummary}", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
                }
              }
            } else {
              Text(
                text = "ප්‍රස්ථාර ගැටලුව & පියවරෙන් පියවර විසඳුම බලන්න ▾",
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

@Composable
fun MathExamSecretsSubSection(
  items: List<MathExamSecretItem>,
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
      it.keyPoint.contains(searchQuery, ignoreCase = true)
    }
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(Color(0xFF422006))
      .padding(8.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text("💡", fontSize = 13.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "O/L Marking Scheme රහස් & වැරදි 20 (${filteredItems.size}/${items.size})",
          fontSize = 11.5.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFFFEF08A)
        )
      }
      IconButton(
        onClick = onOpenFullscreen,
        modifier = Modifier.size(26.dp)
      ) {
        Icon(Icons.Default.Fullscreen, contentDescription = "Fullscreen", tint = Color(0xFFFEF08A), modifier = Modifier.size(18.dp))
      }
    }

    Spacer(modifier = Modifier.height(4.dp))

    // Scroll Control Bar
    Surface(
      shape = RoundedCornerShape(6.dp),
      color = Color(0xFF713F12),
      modifier = Modifier.fillMaxWidth()
    ) {
      Row(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Text("↕️", fontSize = 10.sp)
          Spacer(modifier = Modifier.width(4.dp))
          Text(
            text = "ඉහල පහල scroll කරන්න (${filteredItems.size}ක්)",
            fontSize = 9.sp,
            color = Color(0xFFFEF9C3)
          )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
          Surface(
            onClick = { coroutineScope.launch { scrollState.animateScrollTo(0) } },
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFFCA8A04)
          ) {
            Text("⬆️ ඉහළට", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp))
          }
          Surface(
            onClick = { coroutineScope.launch { scrollState.animateScrollTo(scrollState.maxValue) } },
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFFCA8A04)
          ) {
            Text("⬇️ පහළට", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp))
          }
          Surface(
            onClick = onOpenFullscreen,
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFFA16207)
          ) {
            Text("⛶ විශාල කර", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp))
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(6.dp))

    // Internal Scrollable Container
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 260.dp, max = 500.dp)
        .verticalScroll(scrollState),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      filteredItems.forEach { item ->
        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFF713F12),
          border = BorderStroke(1.dp, Color(0xFFEAB308)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(8.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(item.title, fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFFCA8A04)) {
                Text(item.category, fontSize = 7.5.sp, color = Color.White, modifier = Modifier.padding(4.dp, 1.dp))
              }
            }
            Spacer(modifier = Modifier.height(3.dp))
            Text(item.keyPoint, fontSize = 9.sp, color = Color(0xFFFEF9C3))
            Spacer(modifier = Modifier.height(2.dp))
            Text("උපදෙස: ${item.practicalAdvice}", fontSize = 8.5.sp, color = Color(0xFF86EFAC))
            Text("උදාහරණය: ${item.exampleCase}", fontSize = 8.5.sp, color = Color(0xFF93C5FD))
          }
        }
      }
    }
  }
}
