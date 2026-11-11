package com.example

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import androidx.activity.compose.BackHandler

// ==========================================
// DATA MODELS FOR COMMERCE 10 & 11 MASTER HUB
// ==========================================

enum class CommerceGradeTab(val labelSinhala: String, val badge: String) {
  ALL("සියල්ල (10 & 11)", "O/L COMBO"),
  GRADE_10("10 ශ්‍රේණිය", "පදනම & මූලික පොත්"),
  GRADE_11("11 ශ්‍රේණිය", "මූල්‍ය ප්‍රකාශන & ගැලපීම්")
}

enum class CommerceSectionCategory(
  val id: String,
  val titleSinhala: String,
  val subtitle: String,
  val emoji: String,
  val themeColor: Color,
  val targetGrade: String
) {
  EQUATION(
    id = "equation",
    titleSinhala = "ගිණුම්කරණ සමීකරණය & ගනුදෙනු 30+",
    subtitle = "වත්කම් = හිමිකම + වගකීම් • විස්තාරිත සමීකරණය",
    emoji = "📊",
    themeColor = Color(0xFF059669), // Emerald
    targetGrade = "10"
  ),
  DOUBLE_ENTRY_PRIME(
    id = "double_entry",
    titleSinhala = "ද්විත්ව සටහන් & මූලික පොත් 6",
    subtitle = "හර/බැර රීති • මූලාශ්‍ර ලේඛන • ජර්නල් සටහන්",
    emoji = "⚖️",
    themeColor = Color(0xFF0284C7), // Sky Blue
    targetGrade = "10"
  ),
  FINANCIAL_STATEMENTS(
    id = "statements",
    titleSinhala = "මූල්‍ය ප්‍රකාශන & අනිවාර්ය ගැලපීම් 6",
    subtitle = "වෙළඳ, ලාභ අලාභ & මූල්‍ය තත්ත්ව ප්‍රකාශන ආකෘති",
    emoji = "📑",
    themeColor = Color(0xFF7C3AED), // Purple
    targetGrade = "11"
  ),
  RATIOS(
    id = "ratios",
    titleSinhala = "මූල්‍ය අනුපාත & ස්වයංක්‍රීය ගණකය",
    subtitle = "දළ ලාභ, ශුද්ධ ලාභ, ජංගම & ඉක්මන් අනුපාත",
    emoji = "🧮",
    themeColor = Color(0xFFD97706), // Amber
    targetGrade = "11"
  ),
  BUSINESS_ORG(
    id = "biz_org",
    titleSinhala = "ව්‍යාපාර සංවිධාන & නීති සංසන්දනය",
    subtitle = "තනි පුද්ගල • හවුල් (1890) • සමාගම් (2007/07) • සමුපකාර",
    emoji = "🏢",
    themeColor = Color(0xFF0D9488), // Teal
    targetGrade = "10"
  ),
  BANKING_PAYMENTS(
    id = "banking",
    titleSinhala = "බැංකු, චෙක්පත්, Fintech & රක්ෂණය",
    subtitle = "මහ බැංකුව • චෙක්පත් හරස් කිරීම් • රක්ෂණ මූලධර්ම 4",
    emoji = "🏦",
    themeColor = Color(0xFF4F46E5), // Indigo
    targetGrade = "10"
  ),
  TRIAL_BALANCE_ERRORS(
    id = "tb_errors",
    titleSinhala = "ශේෂ පිරික්සුම, දෝෂ 6 & අත්හිටවූ ගිණුම",
    subtitle = "හෙළි නොවන දෝෂ 6 • අත්හිටවූ ගිණුම් ජර්නල් සටහන්",
    emoji = "🔍",
    themeColor = Color(0xFFE11D48), // Rose
    targetGrade = "11"
  ),
  EXAM_MCQS_SECRETS(
    id = "mcqs",
    titleSinhala = "O/L ඉලක්කගත MCQs & කාල කළමනාකරණය",
    subtitle = "ප්‍රශ්න පත්‍ර I (40/40) සහ II (60/60) ලකුණු සැලසුම",
    emoji = "🎯",
    themeColor = Color(0xFFEA580C), // Orange
    targetGrade = "ALL"
  )
}

// Transaction item for Equation Analyzer
data class CommerceEquationTransaction(
  val id: Int,
  val transactionText: String,
  val assetsEffect: String, // e.g. "+ මුදල් රු. 50,000"
  val equityEffect: String, // e.g. "+ ප්‍රාග්ධනය රු. 50,000"
  val liabilitiesEffect: String, // e.g. "වෙනසක් නැත"
  val netEquationSinhala: String,
  val category: String,
  val grade: String
)

// MCQ Item
data class CommerceModelMcq(
  val id: Int,
  val questionSinhala: String,
  val options: List<String>,
  val correctOptionIndex: Int,
  val explanationSinhala: String,
  val gradeLevel: String,
  val topicName: String
)

// ==========================================
// REPOSITORY FOR COMMERCE MASTER DATA
// ==========================================

object CommerceMasterHubRepository {

  val equationTransactions: List<CommerceEquationTransaction> = listOf(
    CommerceEquationTransaction(
      id = 1,
      transactionText = "අයිතිකරු රු. 100,000 ක මුදලක් ව්‍යාපාරයට ප්‍රාග්ධනය ලෙස යෙදවීම",
      assetsEffect = "(+) මුදල් වත්කම් රු. 100,000 කින් වැඩිවේ",
      equityEffect = "(+) හිමිකම (ප්‍රාග්ධනය) රු. 100,000 කින් වැඩිවේ",
      liabilitiesEffect = "(0) වගකීම්වලට කිසිදු බලපෑමක් නැත",
      netEquationSinhala = "වත්කම් (+100,000) = හිමිකම (+100,000) + වගකීම් (0)",
      category = "ප්‍රාග්ධනය යෙදවීම",
      grade = "10"
    ),
    CommerceEquationTransaction(
      id = 2,
      transactionText = "අයිතිකරු තම පෞද්ගලික පරිගණකය (වටිනාකම රු. 60,000) ව්‍යාපාරයට යෙදවීම",
      assetsEffect = "(+) කාර්යාල උපකරණ වත්කම් රු. 60,000 කින් වැඩිවේ",
      equityEffect = "(+) හිමිකම (ප්‍රාග්ධනය) රු. 60,000 කින් වැඩිවේ",
      liabilitiesEffect = "(0) වගකීම්වලට කිසිදු බලපෑමක් නැත",
      netEquationSinhala = "වත්කම් (+60,000) = හිමිකම (+60,000) + වගකීම් (0)",
      category = "දේපළ ප්‍රාග්ධනය",
      grade = "10"
    ),
    CommerceEquationTransaction(
      id = 3,
      transactionText = "මුදලට භාණ්ඩ තොග මිලදී ගැනීම රු. 30,000",
      assetsEffect = "(+) තොග වත්කම් රු. 30,000 වැඩිවේ | (-) මුදල් වත්කම් රු. 30,000 අඩු වේ (මුළු වත්කම් වෙනස් නොවේ)",
      equityEffect = "(0) හිමිකමේ වෙනසක් නැත",
      liabilitiesEffect = "(0) වගකීම්වල වෙනසක් නැත",
      netEquationSinhala = "වත්කම් (+30,000 - 30,000 = 0) = හිමිකම (0) + වගකීම් (0)",
      category = "වත්කම් හුවමාරුව",
      grade = "10"
    ),
    CommerceEquationTransaction(
      id = 4,
      transactionText = "ණයට භාණ්ඩ තොග මිලදී ගැනීම රු. 45,000",
      assetsEffect = "(+) තොග වත්කම් රු. 45,000 කින් වැඩිවේ",
      equityEffect = "(0) හිමිකමේ වෙනසක් නැත",
      liabilitiesEffect = "(+) ණයහිමියන් (වගකීම්) රු. 45,000 කින් වැඩිවේ",
      netEquationSinhala = "වත්කම් (+45,000) = හිමිකම (0) + වගකීම් (+45,000)",
      category = "ණයට ගැනුම්",
      grade = "10"
    ),
    CommerceEquationTransaction(
      id = 5,
      transactionText = "පිරිවැය රු. 20,000 ක් වූ භාණ්ඩ රු. 28,000 කට මුදලට විකිණීම (ලාභය රු. 8,000)",
      assetsEffect = "(+) මුදල් රු. 28,000 වැඩිවේ | (-) තොගය රු. 20,000 අඩු වේ [ශුද්ධ වත්කම් +8,000]",
      equityEffect = "(+) ලාභය නිසා හිමිකම රු. 8,000 කින් වැඩිවේ",
      liabilitiesEffect = "(0) වගකීම්වලට බලපෑමක් නැත",
      netEquationSinhala = "වත්කම් (+8,000) = හිමිකම (+8,000) + වගකීම් (0)",
      category = "ලාභයට විකිණීම",
      grade = "10"
    ),
    CommerceEquationTransaction(
      id = 6,
      transactionText = "පිරිවැය රු. 15,000 ක් වූ භාණ්ඩ රු. 12,000 කට මුදලට විකිණීම (අලාභය රු. 3,000)",
      assetsEffect = "(+) මුදල් රු. 12,000 වැඩිවේ | (-) තොගය රු. 15,000 අඩු වේ [ශුද්ධ වත්කම් -3,000]",
      equityEffect = "(-) අලාභය නිසා හිමිකම රු. 3,000 කින් අඩු වේ",
      liabilitiesEffect = "(0) වගකීම්වලට බලපෑමක් නැත",
      netEquationSinhala = "වත්කම් (-3,000) = හිමිකම (-3,000) + වගකීම් (0)",
      category = "අලාභයට විකිණීම",
      grade = "10"
    ),
    CommerceEquationTransaction(
      id = 7,
      transactionText = "පිරිවැය රු. 30,000 ක් වූ භාණ්ඩ රු. 40,000 කට ණයට විකිණීම (ලාභය රු. 10,000)",
      assetsEffect = "(+) ණයගැතියන් රු. 40,000 වැඩිවේ | (-) තොගය රු. 30,000 අඩු වේ [ශුද්ධ වත්කම් +10,000]",
      equityEffect = "(+) ලාභය නිසා හිමිකම රු. 10,000 කින් වැඩිවේ",
      liabilitiesEffect = "(0) වගකීම්වල වෙනසක් නැත",
      netEquationSinhala = "වත්කම් (+10,000) = හිමිකම (+10,000) + වගකීම් (0)",
      category = "ණයට විකිණුම්",
      grade = "10"
    ),
    CommerceEquationTransaction(
      id = 8,
      transactionText = "ව්‍යාපාරයේ විදුලි බිල මුදලින් ගෙවීම රු. 6,000",
      assetsEffect = "(-) මුදල් වත්කම් රු. 6,000 කින් අඩු වේ",
      equityEffect = "(-) වියදමක් බැවින් හිමිකම රු. 6,000 කින් අඩු වේ",
      liabilitiesEffect = "(0) වගකීම්වල වෙනසක් නැත",
      netEquationSinhala = "වත්කම් (-6,000) = හිමිකම (-6,000) + වගකීම් (0)",
      category = "වියදම් ගෙවීම",
      grade = "10"
    ),
    CommerceEquationTransaction(
      id = 9,
      transactionText = "කොමිස් ආදායම මුදලින් ලැබීම රු. 12,000",
      assetsEffect = "(+) මුදල් වත්කම් රු. 12,000 කින් වැඩිවේ",
      equityEffect = "(+) ආදායමක් බැවින් හිමිකම රු. 12,000 කින් වැඩිවේ",
      liabilitiesEffect = "(0) වගකීම්වල වෙනසක් නැත",
      netEquationSinhala = "වත්කම් (+12,000) = හිමිකම (+12,000) + වගකීම් (0)",
      category = "ආදායම් ලැබීම",
      grade = "10"
    ),
    CommerceEquationTransaction(
      id = 10,
      transactionText = "අයිතිකරු තම පෞද්ගලික පරිහරණයට රු. 5,000 ක මුදල් ගැනීම (ගැනිලි)",
      assetsEffect = "(-) මුදල් වත්කම් රු. 5,000 කින් අඩු වේ",
      equityEffect = "(-) ගැනිලි නිසා හිමිකම රු. 5,000 කින් අඩු වේ",
      liabilitiesEffect = "(0) වගකීම්වල වෙනසක් නැත",
      netEquationSinhala = "වත්කම් (-5,000) = හිමිකම (-5,000) + වගකීම් (0)",
      category = "මුදල් ගැනිලි",
      grade = "10"
    ),
    CommerceEquationTransaction(
      id = 11,
      transactionText = "අයිතිකරු තම පෞද්ගලික පරිහරණයට රු. 4,000 ක භාණ්ඩ තොග ගැනීම (ගැනිලි)",
      assetsEffect = "(-) තොග වත්කම් රු. 4,000 කින් අඩු වේ",
      equityEffect = "(-) ගැනිලි නිසා හිමිකම රු. 4,000 කින් අඩු වේ",
      liabilitiesEffect = "(0) වගකීම්වල වෙනසක් නැත",
      netEquationSinhala = "වත්කම් (-4,000) = හිමිකම (-4,000) + වගකීම් (0)",
      category = "තොග ගැනිලි",
      grade = "10"
    ),
    CommerceEquationTransaction(
      id = 12,
      transactionText = "ණයගැතියන්ගෙන් චෙක්පතකින් මුදල් ලැබීම රු. 25,000",
      assetsEffect = "(+) බැංකු වත්කම් රු. 25,000 වැඩිවේ | (-) ණයගැති වත්කම් රු. 25,000 අඩු වේ (මුළු වත්කම් වෙනස් නොවේ)",
      equityEffect = "(0) හිමිකමේ වෙනසක් නැත",
      liabilitiesEffect = "(0) වගකීම්වල වෙනසක් නැත",
      netEquationSinhala = "වත්කම් (+25,000 - 25,000 = 0) = හිමිකම (0) + වගකීම් (0)",
      category = "ණය එකතු කිරීම",
      grade = "10"
    ),
    CommerceEquationTransaction(
      id = 13,
      transactionText = "ණයහිමියන්ට මුදලින් ගෙවීම රු. 18,000",
      assetsEffect = "(-) මුදල් වත්කම් රු. 18,000 කින් අඩු වේ",
      equityEffect = "(0) හිමිකමේ වෙනසක් නැත",
      liabilitiesEffect = "(-) ණයහිමියන් (වගකීම්) රු. 18,000 කින් අඩු වේ",
      netEquationSinhala = "වත්කම් (-18,000) = හිමිකම (0) + වගකීම් (-18,000)",
      category = "ණය පියවීම",
      grade = "10"
    ),
    CommerceEquationTransaction(
      id = 14,
      transactionText = "බැංකුවෙන් රු. 200,000 ක ණයක් ලබාගෙන බැංකු ගිණුමේ තැන්පත් කිරීම",
      assetsEffect = "(+) බැංකු වත්කම් රු. 200,000 කින් වැඩිවේ",
      equityEffect = "(0) හිමිකමේ වෙනසක් නැත",
      liabilitiesEffect = "(+) බැංකු ණය (වගකීම්) රු. 200,000 කින් වැඩිවේ",
      netEquationSinhala = "වත්කම් (+200,000) = හිමිකම (0) + වගකීම් (+200,000)",
      category = "බැංකු ණය ගැනීම",
      grade = "10"
    ),
    CommerceEquationTransaction(
      id = 15,
      transactionText = "යන්ත්‍ර සූත්‍ර රු. 80,000 කට ණයට මිලදී ගැනීම (සී/ස සෙන්ගෝ සමාගමෙන්)",
      assetsEffect = "(+) යන්ත්‍ර සූත්‍ර වත්කම් රු. 80,000 කින් වැඩිවේ",
      equityEffect = "(0) හිමිකමේ වෙනසක් නැත",
      liabilitiesEffect = "(+) වෙනත් ණයහිමියන් (වගකීම්) රු. 80,000 කින් වැඩිවේ",
      netEquationSinhala = "වත්කම් (+80,000) = හිමිකම (0) + වගකීම් (+80,000)",
      category = "ස්ථාවර වත්කම් ණයට ගැනීම",
      grade = "10"
    ),
    CommerceEquationTransaction(
      id = 16,
      transactionText = "ගෙවිය යුතු වැටුප් (උපචිත වියදම්) රු. 8,000 ක් ගැලපීම",
      assetsEffect = "(0) වත්කම්වලට බලපෑමක් නැත",
      equityEffect = "(-) වියදම නිසා හිමිකම රු. 8,000 කින් අඩු වේ",
      liabilitiesEffect = "(+) ගෙවිය යුතු වියදම් (වගකීම්) රු. 8,000 කින් වැඩිවේ",
      netEquationSinhala = "වත්කම් (0) = හිමිකම (-8,000) + වගකීම් (+8,000)",
      category = "උපචිත වියදම් ගැලපීම",
      grade = "11"
    ),
    CommerceEquationTransaction(
      id = 17,
      transactionText = "ලැබිය යුතු පොලී ආදායම (උපචිත ආදායම) රු. 5,000 ක් ගැලපීම",
      assetsEffect = "(+) ලැබිය යුතු ආදායම් (වත්කම්) රු. 5,000 කින් වැඩිවේ",
      equityEffect = "(+) ආදායම නිසා හිමිකම රු. 5,000 කින් වැඩිවේ",
      liabilitiesEffect = "(0) වගකීම්වල වෙනසක් නැත",
      netEquationSinhala = "වත්කම් (+5,000) = හිමිකම (+5,000) + වගකීම් (0)",
      category = "උපචිත ආදායම් ගැලපීම",
      grade = "11"
    ),
    CommerceEquationTransaction(
      id = 18,
      transactionText = "මෝටර් රථ සඳහා රු. 10,000 ක ක්ෂයවීමක් වෙන් කිරීම",
      assetsEffect = "(-) උපචිත ක්ෂය නිසා මෝටර් රථ ශුද්ධ වත්කම් රු. 10,000 කින් අඩු වේ",
      equityEffect = "(-) ක්ෂය වියදම නිසා හිමිකම රු. 10,000 කින් අඩු වේ",
      liabilitiesEffect = "(0) වගකීම්වලට කිසිදු බලපෑමක් නැත",
      netEquationSinhala = "වත්කම් (-10,000) = හිමිකම (-10,000) + වගකීම් (0)",
      category = "ක්ෂයවීම් ගැලපීම",
      grade = "11"
    ),
    CommerceEquationTransaction(
      id = 19,
      transactionText = "කලින් ගෙවූ රක්ෂණ ගාස්තු රු. 4,000 ක් වසර අග හඳුනාගැනීම",
      assetsEffect = "(+) කලින් ගෙවූ වියදම් (වත්කම්) රු. 4,000 කින් වැඩිවේ",
      equityEffect = "(+) වියදම අඩුවන බැවින් හිමිකම රු. 4,000 කින් වැඩිවේ",
      liabilitiesEffect = "(0) වගකීම්වල වෙනසක් නැත",
      netEquationSinhala = "වත්කම් (+4,000) = හිමිකම (+4,000) + වගකීම් (0)",
      category = "කලින් ගෙවූ වියදම්",
      grade = "11"
    ),
    CommerceEquationTransaction(
      id = 20,
      transactionText = "කලින් ලැබුණු කුලී ආදායම රු. 7,000 ක් වසර අග හඳුනාගැනීම",
      assetsEffect = "(0) වත්කම්වලට බලපෑමක් නැත",
      equityEffect = "(-) වසරේ ආදායම නොවන බැවින් හිමිකම රු. 7,000 කින් අඩු වේ",
      liabilitiesEffect = "(+) කලින් ලැබුණු ආදායම් (වගකීම්) රු. 7,000 කින් වැඩිවේ",
      netEquationSinhala = "වත්කම් (0) = හිමිකම (-7,000) + වගකීම් (+7,000)",
      category = "කලින් ලැබුණු ආදායම්",
      grade = "11"
    )
  )

  val modelMcqs: List<CommerceModelMcq> = listOf(
    CommerceModelMcq(
      id = 1,
      questionSinhala = "මූලික ගිණුම්කරණ සමීකරණය නිවැරදිව දැක්වෙන ප්‍රකාශය කුමක්ද?",
      options = listOf(
        "වත්කම් = හිමිකම - වගකීම්",
        "වත්කම් = හිමිකම + වගකීම්",
        "හිමිකම = වත්කම් + වගකීම්",
        "වගකීම් = වත්කම් + හිමිකම"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "මූලික ගිණුම්කරණ සමීකරණය වන්නේ වත්කම් = හිමිකම + වගකීම් (Assets = Equity + Liabilities) වේ.",
      gradeLevel = "10",
      topicName = "ගිණුම්කරණ සමීකරණය"
    ),
    CommerceModelMcq(
      id = 2,
      questionSinhala = "ණයට භාණ්ඩ විකිණීමේදී නිකුත් කරනු ලබන මූලාශ්‍ර ලේඛනය (Source Document) කුමක්ද?",
      options = listOf(
        "රිසිට්පත (Receipt)",
        "ගෙවීම් වවුචරය (Payment Voucher)",
        "විකුණුම් ඉන්වොයිසිය (Sales Invoice)",
        "හර සටහන (Debit Note)"
      ),
      correctOptionIndex = 2,
      explanationSinhala = "ණයට භාණ්ඩ විකිණීමේදී විකුණුම්කරු විසින් ගැනුම්කරු වෙත විකුණුම් ඉන්වොයිසියක් (Sales Invoice) නිකුත් කරයි. එය විකුණුම් ජර්නලයට මූලාශ්‍ර ලේඛනය වේ.",
      gradeLevel = "10",
      topicName = "මූලාශ්‍ර ලේඛන & ජර්නල්"
    ),
    CommerceModelMcq(
      id = 3,
      questionSinhala = "පාරිභෝගිකයෙකුගෙන් ආපසු ලැබුණු හානි වූ භාණ්ඩ සටහන් කිරීම සඳහා නිකුත් කරන මූලාශ්‍ර ලේඛනය කුමක්ද?",
      options = listOf(
        "බැර සටහන (Credit Note)",
        "හර සටහන (Debit Note)",
        "චෙක්පත (Cheque)",
        "විකුණුම් ඉන්වොයිසිය"
      ),
      correctOptionIndex = 0,
      explanationSinhala = "විකුණුම් ආපසු ලැබීමේදී පාරිභෝගිකයාගේ ණය මුදල අඩු කරන බව දන්වමින් ඔහු වෙත 'බැර සටහනක්' (Credit Note) නිකුත් කරනු ලබයි.",
      gradeLevel = "10",
      topicName = "මූලික සටහන් පොත්"
    ),
    CommerceModelMcq(
      id = 4,
      questionSinhala = "ශ්‍රී ලංකාවේ සංස්ථාපිත සමාගම් ලියාපදිංචි කරනු ලබන්නේ කුමන පනත යටතේද?",
      options = listOf(
        "1890 හවුල් ව්‍යාපාර ආඥා පනත",
        "1918 අංක 06 දරන ව්‍යාපාර නාම ලියාපදිංචි කිරීමේ ආඥා පනත",
        "2007 අංක 07 දරන සමාගම් පනත",
        "1972 අංක 05 දරන සමුපකාර සමිති පනත"
      ),
      correctOptionIndex = 2,
      explanationSinhala = "ශ්‍රී ලංකාවේ සියලුම පුද්ගලික හා පොදු සීමිත සමාගම් සංස්ථාපනය කරනු ලබන්නේ 2007 අංක 07 දරන සමාගම් පනත (Companies Act No. 07 of 2007) යටතේය.",
      gradeLevel = "10",
      topicName = "ව්‍යාපාර සංවිධාන"
    ),
    CommerceModelMcq(
      id = 5,
      questionSinhala = "ව්‍යාපාරයක ජංගම වත්කම් රු. 200,000ක් සහ ජංගම වගකීම් රු. 100,000ක් නම්, ජංගම අනුපාතය (Current Ratio) කොපමණද?",
      options = listOf(
        "1 : 1",
        "2 : 1",
        "0.5 : 1",
        "3 : 1"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "ජංගම අනුපාතය = ජංගම වත්කම් / ජංගම වගකීම් = 200,000 / 100,000 = 2 : 1. මෙය සම්මත ප්‍රශස්ත මට්ටමයි.",
      gradeLevel = "11",
      topicName = "මූල්‍ය අනුපාත"
    ),
    CommerceModelMcq(
      id = 6,
      questionSinhala = "වසර අගදී ගෙවිය යුතු වැටුප් රු. 5,000ක් තිබේ නම්, ඒ සඳහා නිවැරදි ද්විත්ව සටහන කුමක්ද?",
      options = listOf(
        "වැටුප් ගිණුම හර රු. 5,000 | මුදල් ගිණුම බැර රු. 5,000",
        "ගෙවිය යුතු වැටුප් ගිණුම හර රු. 5,000 | වැටුප් ගිණුම බැර රු. 5,000",
        "වැටුප් ගිණුම හර රු. 5,000 | ගෙවිය යුතු වැටුප් ගිණුම බැර රු. 5,000",
        "ලාභ අලාභ ගිණුම හර රු. 5,000 | මුදල් ගිණුම බැර රු. 5,000"
      ),
      correctOptionIndex = 2,
      explanationSinhala = "ගෙවිය යුතු (උපචිත) වියදම් ගැලපීමේ ද්විත්ව සටහන: අදාළ වියදම් ගිණුම හර (වැටුප් ගිණුම Dr) සහ ගෙවිය යුතු වියදම් ගිණුම බැර (ගෙවිය යුතු වැටුප් Cr) වේ.",
      gradeLevel = "11",
      topicName = "වසර අග ගැලපීම්"
    ),
    CommerceModelMcq(
      id = 7,
      questionSinhala = "ශේෂ පිරික්සුම සමතුලිත වුවද හෙළිදරව් නොවන දෝෂයක් වන්නේ පහත කුමක්ද?",
      options = listOf(
        "මුදල් පොතේ එකතුව වැරදීම",
        "එක් පැත්තක පමණක් සටහන් කිරීම",
        "මූලධර්ම දෝෂ (Error of Principle)",
        "ගිණුමක ශේෂය වැරදියට ශේෂ පිරික්සුමට ගැනීම"
      ),
      correctOptionIndex = 2,
      explanationSinhala = "මූලධර්ම දෝෂයකදී (උදා: වත්කමක් මිලදී ගැනීම වියදමක් ලෙස සටහන් කිරීම) හර සහ බැර දෙපැත්තම එක හා සමානව ලියවෙන බැවින් ශේෂ පිරික්සුම සමතුලිත වේ, දෝෂය හෙළි නොවේ.",
      gradeLevel = "11",
      topicName = "ශේෂ පිරික්සුම & දෝෂ"
    ),
    CommerceModelMcq(
      id = 8,
      questionSinhala = "චෙක්පතක 'Account Payee Only' (ගිණුම් හිමියාට පමණයි) ලෙස හරස් කළ විට සිදුවන ආරක්ෂිත නීතිමය ක්‍රියාව කුමක්ද?",
      options = listOf(
        "ඕනෑම අයෙකුට කවුන්ටරයෙන් මුදල් ලබාගත හැක",
        "චෙක්පතේ නම සඳහන් පුද්ගලයාගේ බැංකු ගිණුමකට පමණක් තැන්පත් කර මුදල් ගත යුතුය",
        "චෙක්පත වෙනත් අයෙකුට අනුමත (Endorse) කළ හැක",
        "බැංකු කළමනාකරුගේ අනුමැතියකින් තොරව වලංගු නොවේ"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "'Account Payee Only' හරස් කිරීම මඟින් චෙක්පත අනුමත කිරීම තහනම් වන අතර, නම සඳහන් ප්‍රතිලාභියාගේ බැංකු ගිණුමට පමණක් මුදල් බැර කිරීමට බැංකුව බැඳී සිටී.",
      gradeLevel = "10",
      topicName = "බැංකු & චෙක්පත්"
    )
  )
}

// ==========================================
// FULL SCREEN COMMERCE MASTER HUB DIALOG
// ==========================================

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommerceGrade10And11MasterHubDialog(
  initialGradeTab: CommerceGradeTab = CommerceGradeTab.ALL,
  initialSectionCategory: CommerceSectionCategory? = null,
  onDismiss: () -> Unit,
  onOpenPdfBooklet: () -> Unit = {}
) {
  var selectedGradeTab by remember { mutableStateOf(initialGradeTab) }
  var expandedSectionId by remember { mutableStateOf(initialSectionCategory?.id ?: "equation") }
  var searchQuery by remember { mutableStateOf("") }

  // Interactive Equation State
  var selectedEqTransCategory by remember { mutableStateOf("ALL") }

  // Interactive Ratios Calculator State
  var calcSales by remember { mutableStateOf("500000") }
  var calcGrossProfit by remember { mutableStateOf("150000") }
  var calcNetProfit by remember { mutableStateOf("75000") }
  var calcCurrentAssets by remember { mutableStateOf("240000") }
  var calcInventory by remember { mutableStateOf("80000") }
  var calcCurrentLiabilities by remember { mutableStateOf("120000") }
  var showRatioResults by remember { mutableStateOf(true) }

  // Quiz State
  val mcqAnswers = remember { mutableStateMapOf<Int, Int>() }
  val mcqShowExplanations = remember { mutableStateMapOf<Int, Boolean>() }

  BackHandler {
    onDismiss()
  }

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(
      usePlatformDefaultWidth = false,
      decorFitsSystemWindows = false,
      securePolicy = AppSecurityManager.getSecureFlagPolicy()
    )
  ) {
    Surface(
      modifier = Modifier
        .fillMaxSize()
        .testTag("commerce_master_hub_dialog"),
      color = Color(0xFFF8FAFC) // Bright, clean, white background (fixes black layout!)
    ) {
      Column(modifier = Modifier.fillMaxSize()) {

        // TOP APP BAR: Ultra-compact Emerald Theme (Minimizes screen height usage)
        Surface(
          color = Color(0xFF064E3B),
          tonalElevation = 3.dp,
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(
            modifier = Modifier
              .statusBarsPadding()
              .padding(horizontal = 8.dp, vertical = 2.dp)
          ) {
            // Row 1: Back Button + Title + Compact "පිටු 76 PDF" Action Button
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .height(38.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Row(
                modifier = Modifier.weight(1f, fill = false),
                verticalAlignment = Alignment.CenterVertically
              ) {
                IconButton(
                  onClick = onDismiss,
                  modifier = Modifier
                    .size(34.dp)
                    .testTag("commerce_hub_close_button")
                ) {
                  Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Close",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                  )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                  text = "10 & 11 ව්‍යාපාර හා ගිණුම්කරණය",
                  fontWeight = FontWeight.Bold,
                  fontSize = 14.sp,
                  color = Color.White,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.width(6.dp))
                Surface(
                  color = Color(0xFFFDE047),
                  shape = RoundedCornerShape(3.dp)
                ) {
                  Text(
                    text = "MASTER",
                    color = Color(0xFF78350F),
                    fontSize = 7.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp),
                    maxLines = 1,
                    softWrap = false
                  )
                }
              }

              // Action button to open Sandu 76-pages full book (compact)
              Button(
                onClick = onOpenPdfBooklet,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF047857)),
                shape = RoundedCornerShape(6.dp),
                contentPadding = PaddingValues(horizontal = 7.dp, vertical = 0.dp),
                modifier = Modifier.height(26.dp)
              ) {
                Icon(
                  Icons.Default.MenuBook,
                  contentDescription = "PDF Book",
                  tint = Color(0xFFFDE047),
                  modifier = Modifier.size(12.dp)
                )
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                  "පිටු 76 PDF",
                  fontSize = 9.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  maxLines = 1,
                  softWrap = false
                )
              }
            }

            // Row 2: Compact Grade Switcher Tabs (Slim chips, minimal height)
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp, bottom = 3.dp),
              horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
              CommerceGradeTab.values().forEach { tab ->
                val isSelected = selectedGradeTab == tab
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = if (isSelected) Color(0xFF10B981) else Color(0xFF065F46),
                  border = BorderStroke(1.dp, if (isSelected) Color(0xFFA7F3D0) else Color(0xFF047857)),
                  modifier = Modifier
                    .weight(1f)
                    .height(26.dp)
                    .clickable { selectedGradeTab = tab }
                ) {
                  Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                  ) {
                    Text(
                      text = tab.labelSinhala,
                      fontSize = 10.sp,
                      fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                      color = if (isSelected) Color.White else Color(0xFFE2E8F0),
                      maxLines = 1,
                      softWrap = false
                    )
                  }
                }
              }
            }
          }
        }

        // SCROLLABLE CONTENT BODY (Scrollable up and down smoothly)
        val commerceListState = androidx.compose.foundation.lazy.rememberLazyListState()
        LaunchedEffect(selectedGradeTab, expandedSectionId) {
          commerceListState.scrollToItem(0)
        }

        LazyColumn(
          state = commerceListState,
          modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 4.dp),
          verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          // Subtitle Banner inside scrollable content (so it never consumes fixed screen height)
          item {
            Surface(
              color = Color(0xFFECFDF5),
              shape = RoundedCornerShape(6.dp),
              border = BorderStroke(1.dp, Color(0xFFA7F3D0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text("📌", fontSize = 11.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                  text = "විෂය නිර්දේශයේ සියලු ප්‍රධාන ඒකක • සූත්‍ර • ගැලපීම් & අනුපාත",
                  fontSize = 10.sp,
                  color = Color(0xFF065F46),
                  fontWeight = FontWeight.Medium,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }
            }
          }

          // Search Bar inside scrollable content
          item {
            Surface(
              color = Color.White,
              shape = RoundedCornerShape(8.dp),
              border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 8.dp, vertical = 3.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Icon(
                  imageVector = Icons.Default.Search,
                  contentDescription = "Search",
                  tint = Color(0xFF059669),
                  modifier = Modifier.size(15.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                BasicTextField(
                  value = searchQuery,
                  onValueChange = { searchQuery = it },
                  singleLine = true,
                  textStyle = LocalTextStyle.current.copy(fontSize = 11.sp, color = Color(0xFF0F172A)),
                  modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 3.dp),
                  decorationBox = { innerTextField ->
                    if (searchQuery.isEmpty()) {
                      Text(
                        "සමීකරණ, ශේෂ පිරික්සුම, බැංකු සැසඳුම, අනුපාත...",
                        fontSize = 11.sp,
                        color = Color(0xFF94A3B8),
                        maxLines = 1
                      )
                    }
                    innerTextField()
                  }
                )
                if (searchQuery.isNotEmpty()) {
                  IconButton(
                    onClick = { searchQuery = "" },
                    modifier = Modifier.size(18.dp)
                  ) {
                    Icon(
                      Icons.Default.Clear,
                      contentDescription = "Clear",
                      tint = Color.Gray,
                      modifier = Modifier.size(13.dp)
                    )
                  }
                }
              }
            }
          }

          // Filter sections based on grade and search query
          val filteredSections = CommerceSectionCategory.values().filter { sec ->
            val gradeMatch = when (selectedGradeTab) {
              CommerceGradeTab.ALL -> true
              CommerceGradeTab.GRADE_10 -> sec.targetGrade == "10" || sec.targetGrade == "ALL"
              CommerceGradeTab.GRADE_11 -> sec.targetGrade == "11" || sec.targetGrade == "ALL"
            }
            val searchMatch = searchQuery.isBlank() ||
                sec.titleSinhala.contains(searchQuery, ignoreCase = true) ||
                sec.subtitle.contains(searchQuery, ignoreCase = true)

            gradeMatch && searchMatch
          }

          items(filteredSections, key = { it.id }) { section ->
            val isExpanded = expandedSectionId == section.id

            // COMPACT COLORFUL CARD WITH MINIMIZED HEIGHT
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color.White),
              elevation = CardDefaults.cardElevation(defaultElevation = if (isExpanded) 3.dp else 1.dp),
              border = BorderStroke(1.dp, if (isExpanded) section.themeColor.copy(alpha = 0.5f) else Color(0xFFE2E8F0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.fillMaxWidth()) {

                // Compact Header (low height ~ 44dp)
                Row(
                  modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                      expandedSectionId = if (isExpanded) "" else section.id
                    }
                    .padding(horizontal = 10.dp, vertical = 8.dp),
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.SpaceBetween
                ) {
                  Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                  ) {
                    Box(
                      modifier = Modifier
                        .size(34.dp)
                        .clip(CircleShape)
                        .background(section.themeColor.copy(alpha = 0.12f)),
                      contentAlignment = Alignment.Center
                    ) {
                      Text(section.emoji, fontSize = 16.sp)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                      Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                          text = section.titleSinhala,
                          fontSize = 12.5.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFF0F172A),
                          maxLines = 1,
                          overflow = TextOverflow.Ellipsis
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Surface(
                          color = if (section.targetGrade == "10") Color(0xFFEFF6FF) else if (section.targetGrade == "11") Color(0xFFFAF5FF) else Color(0xFFECFDF5),
                          shape = RoundedCornerShape(4.dp)
                        ) {
                          Text(
                            text = if (section.targetGrade == "ALL") "10 & 11" else "${section.targetGrade} වසර",
                            color = if (section.targetGrade == "10") Color(0xFF1D4ED8) else if (section.targetGrade == "11") Color(0xFF6B21A8) else Color(0xFF065F46),
                            fontSize = 8.5.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                          )
                        }
                      }
                      Text(
                        text = section.subtitle,
                        fontSize = 10.sp,
                        color = Color(0xFF64748B),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                      )
                    }
                  }

                  IconButton(
                    onClick = { expandedSectionId = if (isExpanded) "" else section.id },
                    modifier = Modifier.size(28.dp)
                  ) {
                    Icon(
                      imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                      contentDescription = "Toggle",
                      tint = section.themeColor
                    )
                  }
                }

                // EXPANDED PEDAGOGICAL CONTENT
                AnimatedVisibility(
                  visible = isExpanded,
                  enter = expandVertically() + fadeIn(),
                  exit = shrinkVertically() + fadeOut()
                ) {
                  Divider(color = Color(0xFFF1F5F9), thickness = 1.dp)
                  Box(modifier = Modifier.padding(10.dp)) {
                    when (section) {
                      CommerceSectionCategory.EQUATION -> {
                        EquationInteractiveSection(
                          transactions = CommerceMasterHubRepository.equationTransactions,
                          selectedCategory = selectedEqTransCategory,
                          onCategorySelect = { selectedEqTransCategory = it }
                        )
                      }
                      CommerceSectionCategory.DOUBLE_ENTRY_PRIME -> {
                        DoubleEntryAndPrimeBooksSection()
                      }
                      CommerceSectionCategory.FINANCIAL_STATEMENTS -> {
                        FinancialStatementsAndAdjustmentsSection()
                      }
                      CommerceSectionCategory.RATIOS -> {
                        FinancialRatiosAndCalculatorSection(
                          sales = calcSales,
                          grossProfit = calcGrossProfit,
                          netProfit = calcNetProfit,
                          currentAssets = calcCurrentAssets,
                          inventory = calcInventory,
                          currentLiabilities = calcCurrentLiabilities,
                          onSalesChange = { calcSales = it },
                          onGrossProfitChange = { calcGrossProfit = it },
                          onNetProfitChange = { calcNetProfit = it },
                          onCurrentAssetsChange = { calcCurrentAssets = it },
                          onInventoryChange = { calcInventory = it },
                          onCurrentLiabilitiesChange = { calcCurrentLiabilities = it }
                        )
                      }
                      CommerceSectionCategory.BUSINESS_ORG -> {
                        BusinessOrganizationsMatrixSection()
                      }
                      CommerceSectionCategory.BANKING_PAYMENTS -> {
                        BankingPaymentsAndInsuranceSection()
                      }
                      CommerceSectionCategory.TRIAL_BALANCE_ERRORS -> {
                        TrialBalanceErrorsAndSuspenseSection()
                      }
                      CommerceSectionCategory.EXAM_MCQS_SECRETS -> {
                        ExamMcqsAndSecretsSection(
                          mcqs = CommerceMasterHubRepository.modelMcqs,
                          answers = mcqAnswers,
                          showExplanations = mcqShowExplanations,
                          onAnswer = { qId, optIdx ->
                            mcqAnswers[qId] = optIdx
                            mcqShowExplanations[qId] = true
                          }
                        )
                      }
                    }
                  }
                }
              }
            }
          }

          item {
            Spacer(modifier = Modifier.height(24.dp))
          }
        }
      }
    }
  }
}

// ==========================================
// 1. EQUATION INTERACTIVE SECTION
// ==========================================

@Composable
fun EquationInteractiveSection(
  transactions: List<CommerceEquationTransaction>,
  selectedCategory: String,
  onCategorySelect: (String) -> Unit
) {
  var selectedTransactionIndex by remember { mutableIntStateOf(0) }
  val activeTransaction = transactions.getOrNull(selectedTransactionIndex) ?: transactions.first()

  Column(modifier = Modifier.fillMaxWidth()) {
    // Formula Badges
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFFECFDF5)),
      border = BorderStroke(1.dp, Color(0xFFA7F3D0)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(10.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            text = "📐 මූලික ගිණුම්කරණ සමීකරණය:",
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF065F46)
          )
          Surface(
            color = Color(0xFF059669),
            shape = RoundedCornerShape(4.dp)
          ) {
            Text("Assets = Equity + Liabilities", color = Color.White, fontSize = 9.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp))
          }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = "වත්කම් (A) = හිමිකම (E) + වගකීම් (L)",
          fontSize = 14.sp,
          fontWeight = FontWeight.ExtraBold,
          color = Color(0xFF047857),
          textAlign = TextAlign.Center,
          modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
          text = "🌟 විස්තාරිත සමීකරණය: වත්කම් = (ආරම්භක ප්‍රාග්ධනය + අමතර ප්‍රාග්ධනය - ගැනිලි + ආදායම් - වියදම්) + වගකීම්",
          fontSize = 10.sp,
          color = Color(0xFF065F46),
          lineHeight = 14.sp
        )
      }
    }

    Spacer(modifier = Modifier.height(10.dp))

    // Transaction Carousel / Pager (30+ Real Syllabus Transactions)
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "ගනුදෙනුව ${selectedTransactionIndex + 1} / ${transactions.size}",
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF059669)
      )
      Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        OutlinedButton(
          onClick = {
            if (selectedTransactionIndex > 0) selectedTransactionIndex--
          },
          enabled = selectedTransactionIndex > 0,
          contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp),
          modifier = Modifier.height(26.dp)
        ) {
          Text("← පෙර", fontSize = 9.5.sp)
        }
        Button(
          onClick = {
            if (selectedTransactionIndex < transactions.size - 1) selectedTransactionIndex++
          },
          enabled = selectedTransactionIndex < transactions.size - 1,
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669)),
          contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp),
          modifier = Modifier.height(26.dp)
        ) {
          Text("ඊළඟ →", fontSize = 9.5.sp, color = Color.White)
        }
      }
    }

    Spacer(modifier = Modifier.height(6.dp))

    // Active Transaction Card
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC)),
      border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(10.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Surface(
            color = Color(0xFF0284C7),
            shape = RoundedCornerShape(4.dp)
          ) {
            Text(
              text = activeTransaction.category,
              color = Color.White,
              fontSize = 9.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.5.dp)
            )
          }
          Text(
            text = "${activeTransaction.grade} ශ්‍රේණිය",
            fontSize = 9.5.sp,
            color = Color(0xFF64748B),
            fontWeight = FontWeight.SemiBold
          )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
          text = activeTransaction.transactionText,
          fontSize = 12.5.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFF0F172A),
          lineHeight = 17.sp
        )
        Spacer(modifier = Modifier.height(10.dp))

        // Equation Impact Analysis Breakdown
        Surface(
          color = Color.White,
          shape = RoundedCornerShape(8.dp),
          border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text("💎 වත්කම් (Assets):", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0284C7), modifier = Modifier.width(105.dp))
              Text(activeTransaction.assetsEffect, fontSize = 10.5.sp, color = Color(0xFF1E293B), fontWeight = FontWeight.Medium)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text("👑 හිමිකම (Equity):", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF7C3AED), modifier = Modifier.width(105.dp))
              Text(activeTransaction.equityEffect, fontSize = 10.5.sp, color = Color(0xFF1E293B), fontWeight = FontWeight.Medium)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text("⚖️ වගකීම් (Liabilities):", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFD97706), modifier = Modifier.width(105.dp))
              Text(activeTransaction.liabilitiesEffect, fontSize = 10.5.sp, color = Color(0xFF1E293B), fontWeight = FontWeight.Medium)
            }
          }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Summary result
        Surface(
          color = Color(0xFFF0FDF4),
          shape = RoundedCornerShape(6.dp),
          border = BorderStroke(1.dp, Color(0xFF86EFAC)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Text(
            text = "✅ සමීකරණ සමතුලිතතාව: ${activeTransaction.netEquationSinhala}",
            fontSize = 10.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF15803D),
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
          )
        }
      }
    }
  }
}

// ==========================================
// 2. DOUBLE ENTRY & 6 PRIME ENTRY BOOKS
// ==========================================

@Composable
fun DoubleEntryAndPrimeBooksSection() {
  Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
    // Golden Rules Card
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFFEFF6FF)),
      border = BorderStroke(1.dp, Color(0xFFBFDBFE)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(10.dp)) {
        Text("⚖️ ද්විත්ව සටහන් මූලික රන් රීති (Golden Rules of Dr & Cr):", fontWeight = FontWeight.Bold, fontSize = 11.5.sp, color = Color(0xFF1E40AF))
        Spacer(modifier = Modifier.height(4.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
          Column(modifier = Modifier.weight(1f)) {
            Text("• වත්කම් (A) & වියදම් (E):", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0369A1))
            Text("  වැඩිවීම් ➔ හර (Dr)", fontSize = 10.sp, color = Color(0xFF0284C7))
            Text("  අඩුවීම් ➔ බැර (Cr)", fontSize = 10.sp, color = Color(0xFF0284C7))
          }
          Column(modifier = Modifier.weight(1f)) {
            Text("• හිමිකම (C), වගකීම් (L) & ආදායම් (I):", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFB45309))
            Text("  වැඩිවීම් ➔ බැර (Cr)", fontSize = 10.sp, color = Color(0xFFD97706))
            Text("  අඩුවීම් ➔ හර (Dr)", fontSize = 10.sp, color = Color(0xFFD97706))
          }
        }
      }
    }

    // 6 Prime Entry Books List
    Text("📖 ප්‍රධාන මූලික සටහන් පොත් 6 සහ මූලාශ්‍ර ලේඛන:", fontWeight = FontWeight.Bold, fontSize = 11.5.sp, color = Color(0xFF0F172A))

    val primeBooks = listOf(
      Triple("1. ගැනුම් ජර්නලය", "ණයට භාණ්ඩ තොග මිලදී ගැනීම්", "ගැනුම් ඉන්වොයිසිය (Purchases Invoice)"),
      Triple("2. විකුණුම් ජර්නලය", "ණයට භාණ්ඩ තොග විකිණීම්", "විකුණුම් ඉන්වොයිසිය (Sales Invoice)"),
      Triple("3. ගැනුම් ආපසු ජර්නලය", "සැපයුම්කරුවන්ට භාණ්ඩ ආපසු යැවීම", "හර සටහන (Debit Note)"),
      Triple("4. විකුණුම් ආපසු ජර්නලය", "පාරිභෝගිකයින්ගෙන් භාණ්ඩ ආපසු ලැබීම", "බැර සටහන (Credit Note)"),
      Triple("5. මුදල් පොත (ද්විත්ව/ත්‍රිත්ව)", "සියලුම මුදල් හා චෙක්පත් ලැබීම් & ගෙවීම්", "රිසිට්පත, ගෙවීම් වවුචරය, බැංකු ප්‍රකාශනය"),
      Triple("6. පොදු ජර්නලය (General Journal)", "ආරම්භක සටහන්, ස්ථාවර වත්කම් ණයට ගැනීම, වසර අග ගැලපීම් & දෝෂ නිවැරදි කිරීම්", "ජර්නල් වවුචරය (Journal Voucher)")
    )

    primeBooks.forEach { (name, desc, sourceDoc) ->
      Surface(
        color = Color(0xFFF8FAFC),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(8.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(name, fontWeight = FontWeight.Bold, fontSize = 11.5.sp, color = Color(0xFF0284C7))
            Surface(
              color = Color(0xFFE0F2FE),
              shape = RoundedCornerShape(4.dp)
            ) {
              Text("මූලාශ්‍රය: $sourceDoc", fontSize = 8.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0369A1), modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp))
            }
          }
          Spacer(modifier = Modifier.height(2.dp))
          Text(desc, fontSize = 10.sp, color = Color(0xFF475569))
        }
      }
    }
  }
}

// ==========================================
// 3. FINANCIAL STATEMENTS & 6 ADJUSTMENTS
// ==========================================

@Composable
fun FinancialStatementsAndAdjustmentsSection() {
  Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
    // Statement Structure Overview
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFFFAF5FF)),
      border = BorderStroke(1.dp, Color(0xFFE9D5FF)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(10.dp)) {
        Text("📑 මූල්‍ය ප්‍රකාශන ආකෘති සූත්‍ර (Financial Statements Format):", fontWeight = FontWeight.Bold, fontSize = 11.5.sp, color = Color(0xFF6B21A8))
        Spacer(modifier = Modifier.height(4.dp))
        Text("• ශුද්ධ විකුණුම් = මුළු විකුණුම් - විකුණුම් ආපසු", fontSize = 10.sp, color = Color(0xFF7E22CE))
        Text("• විකුණුම් පිරිවැය = ආරම්භක තොගය + ශුද්ධ ගැනුම් + ගැනුම් ප්‍රවාහන - අවසන් තොගය", fontSize = 10.sp, color = Color(0xFF7E22CE))
        Text("• දළ ලාභය (Gross Profit) = ශුද්ධ විකුණුම් - විකුණුම් පිරිවැය", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF581C87))
        Text("• ශුද්ධ ලාභය (Net Profit) = දළ ලාභය + අනෙකුත් ආදායම් - මෙහෙයුම්/පරිපාලන වියදම්", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF581C87))
      }
    }

    Text("🎯 සාමාන්‍ය පෙළ අනිවාර්ය වසර අග ගැලපීම් 6 (The 6 Adjustments):", fontWeight = FontWeight.Bold, fontSize = 11.5.sp, color = Color(0xFF0F172A))

    val adjustments = listOf(
      AdjustmentGuide(
        name = "1. අවසන් තොගය (Closing Stock)",
        doubleEntry = "අවසන් තොග ගිණුම හර (Dr) | වෙළඳ ගිණුම බැර (Cr)",
        incomeStatementEffect = "විකුණුම් පිරිවැය ගණනය කිරීමේදී අඩු කෙරේ",
        balanceSheetEffect = "මූල්‍ය තත්ත්ව ප්‍රකාශනයේ ජංගම වත්කමක් ලෙස පෙන්වයි"
      ),
      AdjustmentGuide(
        name = "2. ගෙවිය යුතු / උපචිත වියදම් (Accrued Expenses)",
        doubleEntry = "අදාළ වියදම් ගිණුම හර (Dr) | ගෙවිය යුතු වියදම් ගිණුම බැර (Cr)",
        incomeStatementEffect = "ලාභ අලාභ ප්‍රකාශනයේ අදාළ වියදමට එකතු කෙරේ",
        balanceSheetEffect = "මූල්‍ය තත්ත්ව ප්‍රකාශනයේ ජංගම වගකීමක් ලෙස පෙන්වයි"
      ),
      AdjustmentGuide(
        name = "3. කලින් ගෙවූ වියදම් (Prepaid Expenses)",
        doubleEntry = "කලින් ගෙවූ වියදම් ගිණුම හර (Dr) | අදාළ වියදම් ගිණුම බැර (Cr)",
        incomeStatementEffect = "ලාභ අලාභ ප්‍රකාශනයේ අදාළ වියදමෙන් අඩු කෙරේ",
        balanceSheetEffect = "මූල්‍ය තත්ත්ව ප්‍රකාශනයේ ජංගම වත්කමක් ලෙස පෙන්වයි"
      ),
      AdjustmentGuide(
        name = "4. ලැබිය යුතු / උපචිත ආදායම් (Accrued Income)",
        doubleEntry = "ලැබිය යුතු ආදායම් ගිණුම හර (Dr) | අදාළ ආදායම් ගිණුම බැර (Cr)",
        incomeStatementEffect = "ලාභ අලාභ ප්‍රකාශනයේ අදාළ ආදායමට එකතු කෙරේ",
        balanceSheetEffect = "මූල්‍ය තත්ත්ව ප්‍රකාශනයේ ජංගම වත්කමක් ලෙස පෙන්වයි"
      ),
      AdjustmentGuide(
        name = "5. කලින් ලැබුණු ආදායම් (Income in Advance)",
        doubleEntry = "අදාළ ආදායම් ගිණුම හර (Dr) | කලින් ලැබුණු ආදායම් ගිණුම බැර (Cr)",
        incomeStatementEffect = "ලාභ අලාභ ප්‍රකාශනයේ අදාළ ආදායමෙන් අඩු කෙරේ",
        balanceSheetEffect = "මූල්‍ය තත්ත්ව ප්‍රකාශනයේ ජංගම වගකීමක් ලෙස පෙන්වයි"
      ),
      AdjustmentGuide(
        name = "6. ස්ථාවර වත්කම් ක්ෂයවීම් (Depreciation)",
        doubleEntry = "ක්ෂය වියදම් ගිණුම හර (Dr) | උපචිත ක්ෂය ගිණුම බැර (Cr)",
        incomeStatementEffect = "ලාභ අලාභ ප්‍රකාශනයේ පරිපාලන වියදමක් ලෙස සටහන් වේ",
        balanceSheetEffect = "ජංගම නොවන වත්කම් පිරිවැයෙන් උපචිත ක්ෂය අඩු කර ශුද්ධ අගය දක්වයි"
      )
    )

    adjustments.forEach { adj ->
      Surface(
        color = Color(0xFFF8FAFC),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(8.dp)) {
          Text(adj.name, fontWeight = FontWeight.Bold, fontSize = 11.sp, color = Color(0xFF7C3AED))
          Spacer(modifier = Modifier.height(2.dp))
          Text("• ද්විත්ව සටහන: ${adj.doubleEntry}", fontSize = 9.5.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF1E293B))
          Text("• ආදායම් ප්‍රකාශනය: ${adj.incomeStatementEffect}", fontSize = 9.5.sp, color = Color(0xFF475569))
          Text("• මූල්‍ය තත්ත්ව ප්‍රකාශනය: ${adj.balanceSheetEffect}", fontSize = 9.5.sp, color = Color(0xFF475569))
        }
      }
    }
  }
}

private data class AdjustmentGuide(
  val name: String,
  val doubleEntry: String,
  val incomeStatementEffect: String,
  val balanceSheetEffect: String
)

// ==========================================
// 4. FINANCIAL RATIOS & INTERACTIVE CALCULATOR
// ==========================================

@Composable
fun FinancialRatiosAndCalculatorSection(
  sales: String,
  grossProfit: String,
  netProfit: String,
  currentAssets: String,
  inventory: String,
  currentLiabilities: String,
  onSalesChange: (String) -> Unit,
  onGrossProfitChange: (String) -> Unit,
  onNetProfitChange: (String) -> Unit,
  onCurrentAssetsChange: (String) -> Unit,
  onInventoryChange: (String) -> Unit,
  onCurrentLiabilitiesChange: (String) -> Unit
) {
  val s = sales.toDoubleOrNull() ?: 1.0
  val gp = grossProfit.toDoubleOrNull() ?: 0.0
  val np = netProfit.toDoubleOrNull() ?: 0.0
  val ca = currentAssets.toDoubleOrNull() ?: 0.0
  val inv = inventory.toDoubleOrNull() ?: 0.0
  val cl = currentLiabilities.toDoubleOrNull() ?: 1.0

  val gpMargin = if (s > 0) (gp / s) * 100 else 0.0
  val npMargin = if (s > 0) (np / s) * 100 else 0.0
  val currentRatio = if (cl > 0) ca / cl else 0.0
  val quickRatio = if (cl > 0) (ca - inv) / cl else 0.0

  Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
    // Formula Reference
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFBEB)),
      border = BorderStroke(1.dp, Color(0xFFFDE68A)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(10.dp)) {
        Text("🧮 මූල්‍ය අනුපාත සූත්‍ර (Financial Ratios Formulas):", fontWeight = FontWeight.Bold, fontSize = 11.5.sp, color = Color(0xFFB45309))
        Spacer(modifier = Modifier.height(4.dp))
        Text("1. දළ ලාභ අනුපාතය = (දළ ලාභය / ශුද්ධ විකුණුම්) × 100%", fontSize = 10.sp, color = Color(0xFF92400E))
        Text("2. ශුද්ධ ලාභ අනුපාතය = (ශුද්ධ ලාභය / ශුද්ධ විකුණුම්) × 100%", fontSize = 10.sp, color = Color(0xFF92400E))
        Text("3. ජංගම අනුපාතය (Current Ratio) = ජංගම වත්කම් / ජංගම වගකීම් [ප්‍රශස්ත මට්ටම: 2 : 1]", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF78350F))
        Text("4. ඉක්මන් අනුපාතය (Quick Ratio) = (ජංගම වත්කම් - අවසන් තොගය) / ජංගම වගකීම් [ප්‍රශස්ත මට්ටම: 1 : 1]", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF78350F))
      }
    }

    Text("⚡ ස්වයංක්‍රීය අනුපාත ගණකය (Live Ratio Calculator):", fontWeight = FontWeight.Bold, fontSize = 11.5.sp, color = Color(0xFF0F172A))

    // Input Fields
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
      OutlinedTextField(
        value = sales,
        onValueChange = onSalesChange,
        label = { Text("විකුණුම් (රු.)", fontSize = 9.5.sp) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        modifier = Modifier.weight(1f).height(46.dp),
        textStyle = LocalTextStyle.current.copy(fontSize = 11.sp)
      )
      OutlinedTextField(
        value = grossProfit,
        onValueChange = onGrossProfitChange,
        label = { Text("දළ ලාභය (රු.)", fontSize = 9.5.sp) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        modifier = Modifier.weight(1f).height(46.dp),
        textStyle = LocalTextStyle.current.copy(fontSize = 11.sp)
      )
      OutlinedTextField(
        value = netProfit,
        onValueChange = onNetProfitChange,
        label = { Text("ශුද්ධ ලාභය (රු.)", fontSize = 9.5.sp) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        modifier = Modifier.weight(1f).height(46.dp),
        textStyle = LocalTextStyle.current.copy(fontSize = 11.sp)
      )
    }

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
      OutlinedTextField(
        value = currentAssets,
        onValueChange = onCurrentAssetsChange,
        label = { Text("ජංගම වත්කම්", fontSize = 9.5.sp) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        modifier = Modifier.weight(1f).height(46.dp),
        textStyle = LocalTextStyle.current.copy(fontSize = 11.sp)
      )
      OutlinedTextField(
        value = inventory,
        onValueChange = onInventoryChange,
        label = { Text("අවසන් තොගය", fontSize = 9.5.sp) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        modifier = Modifier.weight(1f).height(46.dp),
        textStyle = LocalTextStyle.current.copy(fontSize = 11.sp)
      )
      OutlinedTextField(
        value = currentLiabilities,
        onValueChange = onCurrentLiabilitiesChange,
        label = { Text("ජංගම වගකීම්", fontSize = 9.5.sp) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        modifier = Modifier.weight(1f).height(46.dp),
        textStyle = LocalTextStyle.current.copy(fontSize = 11.sp)
      )
    }

    // Results Display
    Surface(
      color = Color(0xFFF0FDF4),
      shape = RoundedCornerShape(8.dp),
      border = BorderStroke(1.dp, Color(0xFF86EFAC)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
          Text("📊 දළ ලාභ අනුපාතය:", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF166534))
          Text("%.2f %%".format(gpMargin), fontSize = 11.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF15803D))
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
          Text("📈 ශුද්ධ ලාභ අනුපාතය:", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF166534))
          Text("%.2f %%".format(npMargin), fontSize = 11.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF15803D))
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
          Text("💧 ජංගම අනුපාතය (Current Ratio):", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF166534))
          Text("%.2f : 1 (සම්මතය 2:1)".format(currentRatio), fontSize = 11.sp, fontWeight = FontWeight.ExtraBold, color = if (currentRatio >= 1.5) Color(0xFF15803D) else Color(0xFFDC2626))
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
          Text("⚡ ඉක්මන් අනුපාතය (Quick Ratio):", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF166534))
          Text("%.2f : 1 (සම්මතය 1:1)".format(quickRatio), fontSize = 11.sp, fontWeight = FontWeight.ExtraBold, color = if (quickRatio >= 0.9) Color(0xFF15803D) else Color(0xFFDC2626))
        }
      }
    }
  }
}

// ==========================================
// 5. BUSINESS ORGANIZATIONS COMPARISON MATRIX
// ==========================================

@Composable
fun BusinessOrganizationsMatrixSection() {
  Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
    Text("🏢 ව්‍යාපාර සංවිධාන වර්ග සංසන්දනය (Comparison Matrix):", fontWeight = FontWeight.Bold, fontSize = 11.5.sp, color = Color(0xFF0F172A))

    val orgs = listOf(
      BizOrgInfo(
        type = "1. තනි පුද්ගල ව්‍යාපාර (Sole Trader)",
        members = "1 තනි අයිතිකරු",
        liability = "අසීමිත වගකීම (Unlimited Liability) - පෞද්ගලික දේපළද අවදානමේ",
        act = "1918 අංක 06 ව්‍යාපාර නාම ලියාපදිංචි කිරීමේ ආඥාපනත",
        legalStatus = "ව්‍යාපාරයට වෙනම නෛතික පැවැත්මක් නොමැත",
        profit = "ලාභ හෝ අලාභ සියල්ල අයිතිකරු සතුයි",
        badgeColor = Color(0xFF0D9488)
      ),
      BizOrgInfo(
        type = "2. හවුල් ව්‍යාපාර (Partnership)",
        members = "සාමාජිකයින් 2 සිට 20 දක්වා (බැංකු නම් 10)",
        liability = "සාමාන්‍ය හවුල්කරුවන්ගේ වගකීම අසීමිතයි, ඒකාබද්ධ හා විභක්තයි",
        act = "1890 හවුල් ආඥාපනත සහ වංචා වැළැක්වීමේ ප්‍රඥප්තියේ 18 වගන්තිය",
        legalStatus = "ස්වාධීන නෛතික පෞරුෂයක් නොමැත",
        profit = "හවුල් ගිවිසුමේ අනුපාතයට (නැතහොත් සමානව)",
        badgeColor = Color(0xFF0284C7)
      ),
      BizOrgInfo(
        type = "3. සංස්ථාපිත සමාගම් (Limited Liability Companies)",
        members = "පුද්ගලික: 1 සිට 50 දක්වා | පොදු: අවම 1, උපරිම සීමාවක් නැත",
        liability = "සීමිත වගකීම (Limited Liability) - කොටස් ආයෝජනයට පමණයි",
        act = "2007 අංක 07 දරන සමාගම් පනත (Companies Act No 07)",
        legalStatus = "අයිතිකරුවන්ගෙන් වෙන්වූ ස්වාධීන නෛතික පෞරුෂය සහ අඛණ්ඩ පැවැත්ම",
        profit = "ලාභාංශ (Dividends) වශයෙන් කොටස් අනුපාතයට",
        badgeColor = Color(0xFF7C3AED)
      ),
      BizOrgInfo(
        type = "4. සමුපකාර සමිති (Cooperative Societies)",
        members = "අවම සාමාජිකයින් 10 දෙනෙකි",
        liability = "සාමාජිකයින්ගේ වගකීම සීමිතයි",
        act = "1972 අංක 05 දරන සමුපකාර සමිති පනත",
        legalStatus = "සමුපකාර දෙපාර්තමේන්තුවේ ලියාපදිංචියෙන් පසු නීතිගත සංස්ථාවකි",
        profit = "ප්‍රජා සුභසාධනය හා අනුග්‍රහ ලාභාංශ",
        badgeColor = Color(0xFF059669)
      )
    )

    orgs.forEach { org ->
      Surface(
        color = Color(0xFFF8FAFC),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(8.dp)) {
          Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(org.type, fontWeight = FontWeight.Bold, fontSize = 11.5.sp, color = org.badgeColor)
            Surface(
              color = org.badgeColor.copy(alpha = 0.1f),
              shape = RoundedCornerShape(4.dp)
            ) {
              Text(org.members, fontSize = 8.5.sp, fontWeight = FontWeight.Bold, color = org.badgeColor, modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp))
            }
          }
          Spacer(modifier = Modifier.height(2.dp))
          Text("• වගකීම: ${org.liability}", fontSize = 9.5.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF1E293B))
          Text("• අදාළ පනත: ${org.act}", fontSize = 9.5.sp, color = Color(0xFF475569))
          Text("• නෛතික තත්ත්වය: ${org.legalStatus}", fontSize = 9.5.sp, color = Color(0xFF475569))
          Text("• ලාභ බෙදීයාම: ${org.profit}", fontSize = 9.5.sp, color = Color(0xFF475569))
        }
      }
    }
  }
}

private data class BizOrgInfo(
  val type: String,
  val members: String,
  val liability: String,
  val act: String,
  val legalStatus: String,
  val profit: String,
  val badgeColor: Color
)

// ==========================================
// 6. BANKING, PAYMENTS & INSURANCE
// ==========================================

@Composable
fun BankingPaymentsAndInsuranceSection() {
  Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
    // Banking & Cheque Crossings Card
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFFEEF2FF)),
      border = BorderStroke(1.dp, Color(0xFFC7D2FE)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(10.dp)) {
        Text("🏦 චෙක්පත් හරස් කිරීම් සහ නීතිමය ආරක්ෂාව (Cheque Crossings):", fontWeight = FontWeight.Bold, fontSize = 11.5.sp, color = Color(0xFF3730A3))
        Spacer(modifier = Modifier.height(4.dp))
        Text("1. සාමාන්‍ය හරස් කිරීම (& Co / සමාන්තර රේඛා 2ක්): කවුන්ටරයෙන් මුදල් ගත නොහැක, බැංකු ගිණුමකට දැමිය යුතුය.", fontSize = 9.5.sp, color = Color(0xFF312E81))
        Text("2. විශේෂිත හරස් කිරීම (බැංකුවක නම සහිතව): එම නම් කරන ලද බැංකුව හරහා පමණක් මුදල් ලබාගත හැක.", fontSize = 9.5.sp, color = Color(0xFF312E81))
        Text("3. 'Account Payee Only' (ගිණුම් හිමියාට පමණයි): අනුමත කිරීම තහනම්ය, නම් කර ඇති පුද්ගලයාගේ ගිණුමට පමණක් බැර වේ.", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E1B4B))
        Text("4. 'Not Negotiable' (පැවරිය නොහැක): චෙක්පත පැවරුවද මුල් අයිතිකරුට වඩා හොඳ හිමිකමක් නොලැබේ.", fontSize = 9.5.sp, color = Color(0xFF312E81))
      }
    }

    // Fintech & e-Payments
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFFF0FDF4)),
      border = BorderStroke(1.dp, Color(0xFFBBF7D0)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(10.dp)) {
        Text("💳 ඩිජිටල් ගෙවීම් ක්‍රම (Fintech & Digital Banking):", fontWeight = FontWeight.Bold, fontSize = 11.5.sp, color = Color(0xFF166534))
        Spacer(modifier = Modifier.height(4.dp))
        Text("• ණයපත් (Credit Card): බැංකුව විසින් ලබාදෙන ණය පහසුකමක් මත මිලදී ගැනීම් සිදු කිරීම", fontSize = 9.5.sp, color = Color(0xFF14532D))
        Text("• හරපත් (Debit Card): තමාගේම ඉතිරි කිරීමේ හෝ ජංගම ගිණුමේ ඇති මුදලින් ක්ෂණිකව ගෙවීම", fontSize = 9.5.sp, color = Color(0xFF14532D))
        Text("• LankaQR / CEFT / SLIPS: ශ්‍රී ලංකා මහ බැංකුව මඟින් නියාමනය වන ක්ෂණික අන්තර් බැංකු අරමුදල් හුවමාරු පද්ධති", fontSize = 9.5.sp, color = Color(0xFF14532D))
      }
    }

    // Insurance Principles
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF1F2)),
      border = BorderStroke(1.dp, Color(0xFFFECDD3)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(10.dp)) {
        Text("🛡️ රක්ෂණයේ ප්‍රධාන මූලධර්ම 4 (Core Insurance Principles):", fontWeight = FontWeight.Bold, fontSize = 11.5.sp, color = Color(0xFF9F1239))
        Spacer(modifier = Modifier.height(4.dp))
        Text("1. උපරිම සද්භාවය (Utmost Good Faith): දෙපාර්ශවයම සියලු වැදගත් තොරතුරු වසන් නොකර අනාවරණය කළ යුතුය.", fontSize = 9.5.sp, color = Color(0xFF881337))
        Text("2. හානිපූර්ණය (Indemnity): අනතුරට පෙර පැවති මූල්‍ය තත්ත්වයට පත් කිරීම (ලාභ ලැබිය නොහැක - ජීවිත රක්ෂණයට අදාළ නොවේ).", fontSize = 9.5.sp, color = Color(0xFF881337))
        Text("3. රක්ෂණය කළ හැකි බැඳියාව (Insurable Interest): රක්ෂණය කරන දේ ආරක්ෂා වීමෙන් ලාභයක් හා විනාශයෙන් අලාභයක් සිදුවීම.", fontSize = 9.5.sp, color = Color(0xFF881337))
        Text("4. ආසන්නතම හේතුව (Proximate Cause): හානියට සෘජුවම බලපෑ ප්‍රධාන හේතුව රක්ෂණය කර ඇති අවදානමක් විය යුතුය.", fontSize = 9.5.sp, color = Color(0xFF881337))
      }
    }
  }
}

// ==========================================
// 7. TRIAL BALANCE & ERRORS
// ==========================================

@Composable
fun TrialBalanceErrorsAndSuspenseSection() {
  Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
    // Trial Balance summary
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF1F2)),
      border = BorderStroke(1.dp, Color(0xFFFECDD3)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(10.dp)) {
        Text("🔍 ශේෂ පිරික්සුම සහ අත්හිටවූ ගිණුම (Trial Balance & Suspense):", fontWeight = FontWeight.Bold, fontSize = 11.5.sp, color = Color(0xFF9F1239))
        Spacer(modifier = Modifier.height(4.dp))
        Text("• ශේෂ පිරික්සුම යනු ලෙජර් ගිණුම්වල අංක ගණිතමය නිවැරදිභාවය පරීක්ෂා කිරීමට සකසන ලැයිස්තුවකි.", fontSize = 9.5.sp, color = Color(0xFF881337))
        Text("• දෙපැත්තේ එකතුව සමාන නොවන විට තාවකාලිකව 'අත්හිටවූ ගිණුමක්' (Suspense Account) මඟින් සමතුලිත කර පසුව දෝෂ නිවැරදි කරනු ලබයි.", fontSize = 9.5.sp, color = Color(0xFF881337))
      }
    }

    Text("⚠️ ශේෂ පිරික්සුම සමතුලිත වුවද හෙළි නොවන දෝෂ 6:", fontWeight = FontWeight.Bold, fontSize = 11.5.sp, color = Color(0xFF0F172A))

    val errors = listOf(
      Pair("1. මුළුමනින්ම අත්හැරීමේ දෝෂ (Error of Omission)", "ගනුදෙනුවක් කිසිදු ගිණුමක සටහන් නොවීම (උදා: රු. 5,000ක මුදල් විකුණුම් මුළුමනින්ම නොලියවීම)."),
      Pair("2. මූලධර්ම දෝෂ (Error of Principle)", "ගිණුම්කරණ මූලධර්ම කඩ කරමින් වත්කමක් වියදමක් ලෙස හෝ අනෙක් අතට ලිවීම (උදා: යන්ත්‍ර අලුත්වැඩියාව යන්ත්‍ර ගිණුමට හර කිරීම)."),
      Pair("3. කොමිස් දෝෂ (Error of Commission)", "නිවැරදි පැත්තේ වෙනත් අයෙකුගේ පෞද්ගලික ගිණුමක ලිවීම (උදා: පෙරේරාට ලැබිය යුතු මුදල සිල්වාගේ ගිණුමට ලිවීම)."),
      Pair("4. මුල් සටහනේ දෝෂ (Error of Original Entry)", "මූලික ලේඛනයේ වැරදි මුදලක් ලියා එම මුදලින්ම ලෙජරයට ලියවීම (උදා: රු. 4,500ක් රු. 5,400ක් ලෙස දෙපැත්තටම ලිවීම)."),
      Pair("5. ප්‍රතිවිරුද්ධ සටහන් දෝෂ (Reversal of Entries)", "හර කළ යුතු ගිණුම බැර කර, බැර කළ යුතු ගිණුම හර කිරීම (උදා: කුලී ගෙවීමකදී මුදල් Dr, කුලී Cr කිරීම)."),
      Pair("6. පරිපූරක දෝෂ (Compensating Errors)", "එක් පැත්තක සිදුවූ දෝෂයක් අනෙක් පැත්තේ සිදුවූ වෙනත් සමාන මුදලක දෝෂයකින් පියවී යාම.")
    )

    errors.forEach { (name, desc) ->
      Surface(
        color = Color(0xFFF8FAFC),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(8.dp)) {
          Text(name, fontWeight = FontWeight.Bold, fontSize = 10.5.sp, color = Color(0xFFE11D48))
          Spacer(modifier = Modifier.height(2.dp))
          Text(desc, fontSize = 9.5.sp, color = Color(0xFF334155))
        }
      }
    }
  }
}

// ==========================================
// 8. EXAM MCQS & SECRETS
// ==========================================

@Composable
fun ExamMcqsAndSecretsSection(
  mcqs: List<CommerceModelMcq>,
  answers: Map<Int, Int>,
  showExplanations: Map<Int, Boolean>,
  onAnswer: (Int, Int) -> Unit
) {
  val correctCount = mcqs.count { answers[it.id] == it.correctOptionIndex }

  Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
    // Exam Secret Card
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF7ED)),
      border = BorderStroke(1.dp, Color(0xFFFED7AA)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(10.dp)) {
        Text("🎯 O/L විභාග කාල කළමනාකරණය & ලකුණු සැලසුම:", fontWeight = FontWeight.Bold, fontSize = 11.5.sp, color = Color(0xFFC2410C))
        Spacer(modifier = Modifier.height(4.dp))
        Text("• I ප්‍රශ්න පත්‍රය (ලකුණු 40): බහුවරණ 40ට විනාඩි 60කි. ප්‍රශ්නයකට උපරිම විනාඩි 1.5කි. සැක සහිත ප්‍රශ්න අගට තබා නිසැක ප්‍රශ්න මුලින්ම ලකුණු කරන්න.", fontSize = 9.5.sp, color = Color(0xFF9A3412))
        Text("• II ප්‍රශ්න පත්‍රය (ලකුණු 60): පැය 2කි. I වන අනිවාර්ය ප්‍රශ්නය (ගිණුම්කරණය) සඳහා විනාඩි 45ක් ද, තෝරාගත් ව්‍යාපාර අධ්‍යයන ප්‍රශ්න 3ට විනාඩි 25 බැගින්ද වෙන් කරන්න.", fontSize = 9.5.sp, color = Color(0xFF9A3412))
      }
    }

    // Score indicator
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "📝 විභාග මට්ටමේ බහුවරණ පුහුණුව (${mcqs.size}):",
        fontWeight = FontWeight.Bold,
        fontSize = 11.5.sp,
        color = Color(0xFF0F172A)
      )
      Surface(
        color = Color(0xFFECFDF5),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, Color(0xFF86EFAC))
      ) {
        Text(
          text = "ලකුණු: $correctCount / ${answers.size}",
          fontSize = 9.5.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFF15803D),
          modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
        )
      }
    }

    // MCQ Questions List
    mcqs.forEachIndexed { index, mcq ->
      val selectedOption = answers[mcq.id]
      val isAnswered = selectedOption != null
      val isCorrect = selectedOption == mcq.correctOptionIndex

      Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC)),
        border = BorderStroke(1.dp, if (isAnswered) (if (isCorrect) Color(0xFF86EFAC) else Color(0xFFFECDD3)) else Color(0xFFE2E8F0)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(10.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Text(
              text = "ප්‍රශ්නය ${index + 1} (${mcq.gradeLevel} ශ්‍රේණිය)",
              fontSize = 9.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFEA580C)
            )
            Surface(
              color = Color(0xFFE2E8F0),
              shape = RoundedCornerShape(4.dp)
            ) {
              Text(mcq.topicName, fontSize = 8.5.sp, color = Color(0xFF475569), modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp))
            }
          }
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = mcq.questionSinhala,
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0F172A),
            lineHeight = 16.sp
          )
          Spacer(modifier = Modifier.height(8.dp))

          // 4 Options
          mcq.options.forEachIndexed { optIdx, optText ->
            val isThisSelected = selectedOption == optIdx
            val isThisCorrect = optIdx == mcq.correctOptionIndex

            val optBg = when {
              isAnswered && isThisCorrect -> Color(0xFFDCFCE7)
              isAnswered && isThisSelected && !isCorrect -> Color(0xFFFEE2E2)
              isThisSelected -> Color(0xFFEFF6FF)
              else -> Color.White
            }

            val optBorder = when {
              isAnswered && isThisCorrect -> Color(0xFF86EFAC)
              isAnswered && isThisSelected && !isCorrect -> Color(0xFFFCA5A5)
              isThisSelected -> Color(0xFFBFDBFE)
              else -> Color(0xFFE2E8F0)
            }

            Surface(
              shape = RoundedCornerShape(6.dp),
              color = optBg,
              border = BorderStroke(1.dp, optBorder),
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp)
                .clickable {
                  onAnswer(mcq.id, optIdx)
                }
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = "(${optIdx + 1})",
                  fontWeight = FontWeight.Bold,
                  fontSize = 10.sp,
                  color = if (isAnswered && isThisCorrect) Color(0xFF15803D) else Color(0xFF64748B),
                  modifier = Modifier.width(22.dp)
                )
                Text(
                  text = optText,
                  fontSize = 10.5.sp,
                  color = Color(0xFF1E293B)
                )
              }
            }
          }

          // Explanation
          if (isAnswered) {
            Spacer(modifier = Modifier.height(6.dp))
            Surface(
              color = if (isCorrect) Color(0xFFF0FDF4) else Color(0xFFFEF2F2),
              shape = RoundedCornerShape(6.dp),
              modifier = Modifier.fillMaxWidth()
            ) {
              Text(
                text = (if (isCorrect) "✅ නිවැරදියි! " else "❌ වැරදියි! ") + mcq.explanationSinhala,
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Medium,
                color = if (isCorrect) Color(0xFF166534) else Color(0xFF991B1B),
                modifier = Modifier.padding(6.dp),
                lineHeight = 13.5.sp
              )
            }
          }
        }
      }
    }
  }
}
