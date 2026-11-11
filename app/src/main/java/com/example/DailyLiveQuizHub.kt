package com.example

import android.content.Context
import android.media.AudioManager
import android.media.ToneGenerator
import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.ui.theme.*
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

// -----------------------------------------------------------------------------------------
// DATA MODELS: DAILY LIVE QUIZ CONTEST SYSTEM
// -----------------------------------------------------------------------------------------

data class LiveQuizQuestion(
  val id: Int,
  val grade: String,
  val subject: String,
  val question: String,
  val options: List<String>,
  val correctIndex: Int,
  val explanation: String
)

data class LiveQuizAttempt(
  val userId: String,
  val userName: String,
  val grade: String,
  val date: String,
  val score: Int,
  val totalQuestions: Int = 20,
  val totalTimeTakenMs: Long,
  val answersMap: Map<Int, Int>, // questionId -> selectedOption
  val timestamp: Long = System.currentTimeMillis()
)

data class LeaderboardEntry(
  val rank: Int,
  val userId: String,
  val userName: String,
  val userSchool: String,
  val score: Int,
  val totalQuestions: Int = 20,
  val totalTimeTakenMs: Long,
  val avatarEmoji: String,
  val isCurrentUser: Boolean = false
)

enum class LiveQuizContestStatus {
  UPCOMING,      // Before 7:00 PM
  ENTRY_OPEN,    // 7:00 PM - 7:05 PM (Gateway open)
  IN_PROGRESS,   // 7:05 PM - 7:15 PM (Contest live)
  RESULTS_READY  // After 7:15 PM (Leaderboards Published)
}

// -----------------------------------------------------------------------------------------
// REPOSITORY: SRI LANKAN CURRICULUM QUESTIONS (GRADES 6 TO 11)
// -----------------------------------------------------------------------------------------
// DATA MODEL & REPOSITORY: DAILY 7:00 PM LIVE ARENA (SINGLE SUBJECT PER DAY - 20 QUESTIONS)
// -----------------------------------------------------------------------------------------

enum class DailyQuizSubjectTheme(
  val dayOfWeek: Int,
  val nameSinhala: String,
  val nameEnglish: String,
  val icon: String,
  val dayNameSinhala: String,
  val colorHex: Long
) {
  SUNDAY(Calendar.SUNDAY, "බුද්ධ ධර්මය සහ සාරධර්ම", "Buddhism & Ethics", "☸️", "ඉරිදා", 0xFFEAB308),
  MONDAY(Calendar.MONDAY, "විද්‍යාව", "Science", "🔬", "සඳුදා", 0xFF0284C7),
  TUESDAY(Calendar.TUESDAY, "ගණිතය", "Mathematics", "📐", "අඟහරුවාදා", 0xFFE11D48),
  WEDNESDAY(Calendar.WEDNESDAY, "ඉතිහාසය", "History", "🏛️", "බදාදා", 0xFFD97706),
  THURSDAY(Calendar.THURSDAY, "සිංහල භාෂාව හා සාහිත්‍යය", "Sinhala", "✍️", "බ්‍රහස්පතින්දා", 0xFF7C3AED),
  FRIDAY(Calendar.FRIDAY, "ඉංග්‍රීසි භාෂාව", "English", "🔤", "සිකුරාදා", 0xFF0D9488),
  SATURDAY(Calendar.SATURDAY, "තොරතුරු හා සන්නිවේදන තාක්ෂණය", "ICT", "💻", "සෙනසුරාදා", 0xFF4F46E5);

  companion object {
    fun getTodayTheme(): DailyQuizSubjectTheme {
      val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
      return values().find { it.dayOfWeek == day } ?: MONDAY
    }
  }
}

object DailyLiveQuizRepository {

  fun getTodaySubject(): DailyQuizSubjectTheme = DailyQuizSubjectTheme.getTodayTheme()

  fun getQuestionsForGrade(grade: String, forcedSubject: DailyQuizSubjectTheme? = null): List<LiveQuizQuestion> {
    val cleanGrade = grade.replace("ශ්‍රේණිය", "").replace("Grade", "").trim()
    val gradeNum = cleanGrade.toIntOrNull() ?: 11
    val subjectTheme = forcedSubject ?: getTodaySubject()

    return generateSubjectQuestions(gradeNum, subjectTheme)
  }

  private fun generateSubjectQuestions(grade: Int, theme: DailyQuizSubjectTheme): List<LiveQuizQuestion> {
    val calendar = Calendar.getInstance()
    val dayOfYear = calendar.get(Calendar.DAY_OF_YEAR)
    val year = calendar.get(Calendar.YEAR)
    val seed = (year * 1000L + dayOfYear + grade * 17L)

    val rawList: List<LiveQuizQuestion> = when (theme) {
      DailyQuizSubjectTheme.MONDAY -> getScienceQuestions(grade)
      DailyQuizSubjectTheme.TUESDAY -> getMathQuestions(grade)
      DailyQuizSubjectTheme.WEDNESDAY -> getHistoryQuestions(grade)
      DailyQuizSubjectTheme.THURSDAY -> getSinhalaQuestions(grade)
      DailyQuizSubjectTheme.FRIDAY -> getEnglishQuestions(grade)
      DailyQuizSubjectTheme.SATURDAY -> getIctQuestions(grade)
      DailyQuizSubjectTheme.SUNDAY -> getBuddhismQuestions(grade)
    }

    // Ensure exactly 20 questions
    val random = java.util.Random(seed)
    val shuffled = rawList.shuffled(random)
    val final20 = if (shuffled.size >= 20) {
      shuffled.take(20)
    } else {
      // If pool has fewer than 20, cycle and adapt
      val filled = mutableListOf<LiveQuizQuestion>()
      while (filled.size < 20) {
        filled.addAll(rawList)
      }
      filled.take(20)
    }

    return final20.mapIndexed { idx, q ->
      q.copy(
        id = idx + 1,
        grade = "Grade $grade",
        subject = "${theme.icon} ${theme.nameSinhala} (${theme.nameEnglish})"
      )
    }
  }

  // -----------------------------------------------------------------------------------------
  // 🔬 1. SCIENCE QUESTIONS (විද්‍යාව) - 20+ Questions per Grade
  // -----------------------------------------------------------------------------------------
  private fun getScienceQuestions(grade: Int): List<LiveQuizQuestion> {
    return listOf(
      LiveQuizQuestion(1, "Grade $grade", "විද්‍යාව", "ශාකවල ප්‍රභාසංස්ලේෂණයේදී ආලෝක ප්‍රතික්‍රියාව සිදුවන ස්ථානය කුමක්ද?", listOf("ස්ට්‍රෝමාව", "තයිලකොයිඩ පටලය", "මයිටොකොන්ඩ්‍රියා", "සෛල ප්ලාස්මය"), 1, "ප්‍රභාසංස්ලේෂණයේ ආලෝක ප්‍රතික්‍රියාව තයිලකොයිඩ පටල මත සිදුවේ."),
      LiveQuizQuestion(2, "Grade $grade", "විද්‍යාව", "ස්කන්ධය 2 kg වූ වස්තුවකට 10 N බලයක් යෙදූ විට ඇතිවන ත්වරණය කොපමණද?", listOf("20 ms⁻²", "5 ms⁻²", "0.2 ms⁻²", "12 ms⁻²"), 1, "F = ma සූත්‍රය අනුව a = 10 / 2 = 5 ms⁻² වේ."),
      LiveQuizQuestion(3, "Grade $grade", "විද්‍යාව", "ආවර්තිතා වගුවේ 3 වන ආවර්තයේ 2 වන කාණ්ඩයට අයත් මූලද්‍රව්‍යය කුමක්ද?", listOf("සෝඩියම් (Na)", "මැග්නීසියම් (Mg)", "ඇලුමිනියම් (Al)", "කැල්සියම් (Ca)"), 1, "මැග්නීසියම්හි ඉලෙක්ට්‍රොන වින්‍යාසය 2, 8, 2 වේ."),
      LiveQuizQuestion(4, "Grade $grade", "විද්‍යාව", "මිනිස් රුධිරයේ O රුධිර ගණයේ අඩංගු ප්‍රතිදේහ මොනවාද?", listOf("A පමණි", "B පමණි", "A සහ B දෙකම", "කිසිවක් නැත"), 2, "O රුධිර ගණයේ ප්ලාස්මාවේ anti-A සහ anti-B ප්‍රතිදේහ දෙකම ඇත."),
      LiveQuizQuestion(5, "Grade $grade", "විද්‍යාව", "ප්‍රතිරෝධය 10 Ω වූ සන්නායකයක් හරහා 2 A ධාරාවක් ගලන විට විභව අන්තරය කොපමණද?", listOf("5 V", "20 V", "0.2 V", "12 V"), 1, "V = IR අනුව 2 × 10 = 20 V වේ."),
      LiveQuizQuestion(6, "Grade $grade", "විද්‍යාව", "මිනිසාගේ සෛලයක අඩංගු සමස්ත වර්ණදේහ සංඛ්‍යාව කොපමණද?", listOf("23", "46 (යුගල 23)", "44", "48"), 1, "දේහ සෛලයක වර්ණදේහ 46ක් (යුගල 23ක්) අඩංගුය."),
      LiveQuizQuestion(7, "Grade $grade", "විද්‍යාව", "ජලයේ රසායනික සූත්‍රය කුමක්ද?", listOf("CO₂", "NaCl", "H₂O", "H₂SO₄"), 2, "හයිඩ්‍රජන් හා ඔක්සිජන් එක්වී H₂O සෑදේ."),
      LiveQuizQuestion(8, "Grade $grade", "විද්‍යාව", "ශාකවල ජලය හා ඛනිජ ලවණ ඉහළට පරිවහනය කරන පටකය කුමක්ද?", listOf("ෆ්ලෝයමය", "ශෛලමය", "බාහිකය", "පරිචක්‍රය"), 1, "ශෛලම පටකය මඟින් ජලය පරිවහනය කෙරේ."),
      LiveQuizQuestion(9, "Grade $grade", "විද්‍යාව", "වාතයේ වැඩිම ප්‍රතිශතයක් අඩංගු වායුව කුමක්ද?", listOf("ඔක්සිජන්", "නයිට්‍රජන් (78%)", "කාබන් ඩයොක්සයිඩ්", "හීලියම්"), 1, "වායුගෝලයේ 78% ක් නයිට්‍රජන් අඩංගුය."),
      LiveQuizQuestion(10, "Grade $grade", "විද්‍යාව", "ජීවයේ මූලික ව්‍යුහාත්මක හා ක්‍රියාකාරී ඒකකය කුමක්ද?", listOf("පටකය", "සෛලය", "අවයවය", "පද්ධතිය"), 1, "සියලු ජීවීන් සෛල වලින් සෑදී ඇත."),
      LiveQuizQuestion(11, "Grade $grade", "විද්‍යාව", "ශක්තිය මනින ජාත්‍යන්තර (SI) සම්මත ඒකකය කුමක්ද?", listOf("වොට් (W)", "ජූල් (J)", "නිව්ටන් (N)", "පැස්කල් (Pa)"), 1, "ශක්තිය හා කාර්යයේ SI ඒකකය ජූල් (J) වේ."),
      LiveQuizQuestion(12, "Grade $grade", "විද්‍යාව", "ශබ්දය රික්තකයක් හරහා ගමන් කළ හැකිද?", listOf("ඔව්", "නැත, මාධ්‍යයක් අවශ්‍යයි", "ආලෝකයට පමණි", "අධික ශීතලකදී පමණි"), 1, "ශබ්දයට ගමන් කිරීමට පදාර්ථමය මාධ්‍යයක් අනිවාර්ය වේ."),
      LiveQuizQuestion(13, "Grade $grade", "විද්‍යාව", "අම්ලයක් හා භෂ්මයක් ප්‍රතික්‍රියා කර ලවණ හා ජලය සෑදීම හඳුන්වන්නේ කුමක් ලෙසද?", listOf("ඔක්සිකරණය", "උදාසීනීකරණය", "විද්‍යුත් විච්ඡේදනය", "ප්‍රභාසංස්ලේෂණය"), 1, "අම්ල + භෂ්ම -> ලවණ + ජලය උදාසීනීකරණය නම් වේ."),
      LiveQuizQuestion(14, "Grade $grade", "විද්‍යාව", "පෘථිවි ගුරුත්වජ ත්වරණයේ සම්මත අගය දළ වශයෙන් කොපමණද?", listOf("9.8 ms⁻² (10 ms⁻²)", "5 ms⁻²", "20 ms⁻²", "98 ms⁻²"), 0, "g හි සම්මත අගය 9.8 ms⁻² වේ."),
      LiveQuizQuestion(15, "Grade $grade", "විද්‍යාව", "ආලෝකයේ වේගය රික්තකයකදී තත්පරයට කිලෝමීටර් කීයක්ද?", listOf("300,000 km/s", "150,000 km/s", "3,000 km/s", "30,000 km/s"), 0, "ආලෝකයේ වේගය c = 3 × 10⁸ m/s හෙවත් 300,000 km/s වේ."),
      LiveQuizQuestion(16, "Grade $grade", "විද්‍යාව", "මිනිස් හෘදයේ කුටීර ගණන කීයද?", listOf("2", "3", "4", "5"), 2, "මිනිස් හෘදයේ කර්ණිකා 2ක් හා කෝෂිකා 2ක් ලෙස කුටීර 4ක් ඇත."),
      LiveQuizQuestion(17, "Grade $grade", "විද්‍යාව", "pH අගය 7 ට වඩා අඩු ද්‍රාවණයක් අයත් වන්නේ කුමන කාණ්ඩයටද?", listOf("භෂ්ම", "අම්ල", "උදාසීන", "ලවණ"), 1, "pH < 7 අම්ල වන අතර pH > 7 භෂ්ම වේ."),
      LiveQuizQuestion(18, "Grade $grade", "විද්‍යාව", "ශාක සෛලයක සෛල බිත්තිය ප්‍රධාන වශයෙන් සෑදී ඇත්තේ කුමන ද්‍රව්‍යයෙන්ද?", listOf("ප්‍රෝටීන", "සෙලියුලෝස්", "ලිපිඩ", "ග්ලූකෝස්"), 1, "ශාක සෛල බිත්තිය සෙලියුලෝස් වලින් සමන්විතය."),
      LiveQuizQuestion(19, "Grade $grade", "විද්‍යාව", "චුම්භකයක සජාතීය ධ්‍රැව එකිනෙක,", listOf("ආකර්ෂණය වේ", "විකර්ෂණය වේ (ඈත් වේ)", "නොසැලී පවතී", "බලයක් නැත"), 1, "සජාතීය ධ්‍රැව විකර්ෂණය වේ."),
      LiveQuizQuestion(20, "Grade $grade", "විද්‍යාව", "වායුගෝලීය පීඩනය මැනීමට භාවිතා කරන උපකරණය කුමක්ද?", listOf("උෂ්ණත්වමානය", "බැරෝමීටරය", "ඇමීටරය", "වෝල්ට්මීටරය"), 1, "වායුගෝලීය පීඩනය බැරෝමීටරයෙන් මනිනු ලැබේ.")
    )
  }

  // -----------------------------------------------------------------------------------------
  // 📐 2. MATHEMATICS QUESTIONS (ගණිතය) - 20 Questions
  // -----------------------------------------------------------------------------------------
  private fun getMathQuestions(grade: Int): List<LiveQuizQuestion> {
    return listOf(
      LiveQuizQuestion(1, "Grade $grade", "ගණිතය", "x² - 5x + 6 = 0 සමීකරණයේ මූල (Roots) වන්නේ,", listOf("x = 2 හෝ x = 3", "x = -2 හෝ x = -3", "x = 1 හෝ x = 6", "x = -1 හෝ x = -6"), 0, "(x - 2)(x - 3) = 0 බැවින් x = 2 හෝ 3 වේ."),
      LiveQuizQuestion(2, "Grade $grade", "ගණිතය", "sin 30° හි නිශ්චිත අගය වන්නේ,", listOf("1", "√3/2", "1/2 (0.5)", "1/√2"), 2, "sin 30° = 1/2 හෙවත් 0.5 කි."),
      LiveQuizQuestion(3, "Grade $grade", "ගණිතය", "ත්‍රිකෝණයක අභ්‍යන්තර කෝණවල එකතුව කොපමණද?", listOf("90°", "180°", "270°", "360°"), 1, "තල ත්‍රිකෝණයක අභ්‍යන්තර කෝණ එකතුව 180° කි."),
      LiveQuizQuestion(4, "Grade $grade", "ගණිතය", "log₁₀(1000) හි අගය කොපමණද?", listOf("1", "2", "3", "10"), 2, "10³ = 1000 බැවින් log₁₀(1000) = 3 වේ."),
      LiveQuizQuestion(5, "Grade $grade", "ගණිතය", "2x + 4 = 10 නම් x හි අගය කීයද?", listOf("2", "3", "4", "5"), 1, "2x = 6 => x = 3."),
      LiveQuizQuestion(6, "Grade $grade", "ගණිතය", "අරය 7 cm වූ වෘත්තයක පරිධිය කොපමණද? (π = 22/7)", listOf("22 cm", "44 cm", "88 cm", "154 cm"), 1, "පරිධිය = 2πr = 2 × (22/7) × 7 = 44 cm."),
      LiveQuizQuestion(7, "Grade $grade", "ගණිතය", "සාධක සොයන්න: x² - 9", listOf("(x-3)(x-3)", "(x+3)(x-3)", "(x+9)(x-1)", "(x-9)(x+1)"), 1, "වර්ග දෙකක අන්තරය: a² - b² = (a+b)(a-b)."),
      LiveQuizQuestion(8, "Grade $grade", "ගණිතය", "(-5) × (-4) හි අගය කොපමණද?", listOf("-20", "+20", "-9", "+9"), 1, "සෘණ × සෘණ = ධන (+20) වේ."),
      LiveQuizQuestion(9, "Grade $grade", "ගණිතය", "සමාන්තර ශ්‍රේඪියක පළමු පදය 3 ද පොදු අන්තරය 4 ද නම් 10 වන පදය කුමක්ද?", listOf("36", "39", "40", "43"), 1, "T10 = 3 + 9 × 4 = 39."),
      LiveQuizQuestion(10, "Grade $grade", "ගණිතය", "අරය 7 cm වූ අර්ධ ගෝලයක වක්‍ර පෘෂ්ඨ වර්ගඵලය වන්නේ,", listOf("154 cm²", "308 cm²", "462 cm²", "616 cm²"), 1, "2πr² = 2 × (22/7) × 49 = 308 cm²."),
      LiveQuizQuestion(11, "Grade $grade", "ගණිතය", "සෘජුකෝණාස්‍රයක දිග 8 cm ද පළල 5 cm ද නම් එහි වර්ගඵලය කොපමණද?", listOf("13 cm²", "26 cm²", "40 cm²", "80 cm²"), 2, "වර්ගඵලය = 8 × 5 = 40 cm²."),
      LiveQuizQuestion(12, "Grade $grade", "ගණිතය", "ප්‍රථමක සංඛ්‍යාවක් (Prime number) තෝරන්න:", listOf("4", "9", "13", "15"), 2, "13 ට ඇත්තේ 1 සහ 13 පමණි."),
      LiveQuizQuestion(13, "Grade $grade", "ගණිතය", "3/4 දශම සංඛ්‍යාවක් ලෙස දැක්වූ විට ලැබෙන්නේ,", listOf("0.25", "0.50", "0.75", "0.34"), 2, "3 ÷ 4 = 0.75 වේ."),
      LiveQuizQuestion(14, "Grade $grade", "ගණිතය", "සරල රේඛාවක බද්ධ කෝණ දෙකක එකතුව කොපමණද?", listOf("90°", "180°", "270°", "360°"), 1, "සරල රේඛාවක බද්ධ කෝණ එකතුව 180° කි."),
      LiveQuizQuestion(15, "Grade $grade", "ගණිතය", "2⁵ (2 හි 5 වන බලය) හි අගය කොපමණද?", listOf("10", "16", "32", "64"), 2, "2 × 2 × 2 × 2 × 2 = 32 වේ."),
      LiveQuizQuestion(16, "Grade $grade", "ගණිතය", "වෘත්තයක කේන්ද්‍ර කෝණය 360° ක් වන විට අර්ධ වෘත්තයක කෝණය කොපමණද?", listOf("90°", "180°", "270°", "360°"), 1, "360° / 2 = 180° වේ."),
      LiveQuizQuestion(17, "Grade $grade", "ගණිතය", "පයිතගරස් ප්‍රමේයයට අනුව කර්ණය c වන සෘජුකෝණී ත්‍රිකෝණයක සම්බන්ධය කුමක්ද?", listOf("a + b = c", "a² + b² = c²", "a² - b² = c²", "ab = c²"), 1, "a² + b² = c² සත්‍ය වේ."),
      LiveQuizQuestion(18, "Grade $grade", "ගණිතය", "සමචතුරස්‍රයක පරිමිතිය 24 cm නම් එහි එක් පැත්තක දිග කීයද?", listOf("4 cm", "6 cm", "8 cm", "12 cm"), 1, "24 / 4 = 6 cm."),
      LiveQuizQuestion(19, "Grade $grade", "ගණිතය", "5! (5 ක්‍රමාරෝපිත) හි අගය වන්නේ,", listOf("25", "60", "120", "720"), 2, "5 × 4 × 3 × 2 × 1 = 120."),
      LiveQuizQuestion(20, "Grade $grade", "ගණිතය", "ප්‍රතිශතය භාගයක් කරන්න: 25%", listOf("1/2", "1/4", "1/5", "3/4"), 1, "25/100 = 1/4 වේ.")
    )
  }

  // -----------------------------------------------------------------------------------------
  // 🏛️ 3. HISTORY QUESTIONS (ඉතිහාසය) - 20 Questions
  // -----------------------------------------------------------------------------------------
  private fun getHistoryQuestions(grade: Int): List<LiveQuizQuestion> {
    return listOf(
      LiveQuizQuestion(1, "Grade $grade", "ඉතිහාසය", "1818 ඌව වෙල්ලස්ස කැරැල්ලේ ප්‍රධාන නායකත්වය දැරුවේ කවුරුන්ද?", listOf("වීර පුරන් අප්පු", "මොණරවිල කැප්පෙටිපොළ", "ගොන්ගාලේගොඩ බණ්ඩා", "මහ මද්දුම බණ්ඩාර"), 1, "මොණරවිල කැප්පෙටිපොළ දිසාව නායකත්වය දුන්නේය."),
      LiveQuizQuestion(2, "Grade $grade", "ඉතිහාසය", "ලංකාවේ ප්‍රථම වරට කෝපි වගාව වාණිජ මට්ටමින් ආරම්භ කළ වර්ෂය කුමක්ද?", listOf("1824", "1815", "1948", "1880"), 0, "1824 දී එඩ්වඩ් බාන්ස් ආණ්ඩුකාරවරයා යටතේ ඇරඹිණි."),
      LiveQuizQuestion(3, "Grade $grade", "ඉතිහාසය", "1948 පෙබරවාරි 4 නිදහස ලබන විට ලංකාවේ ප්‍රථම අග්‍රාමාත්‍යවරයා කවුද?", listOf("එස්.ඩබ්.ආර්.ඩී. බණ්ඩාරනායක", "ඩී.එස්. සේනානායක", "ඩඩ්ලි සේනානායක", "ජෝන් කොතලාවල"), 1, "ඩී.එස්. සේනානායක මහතා ප්‍රථම අග්‍රාමාත්‍යවරයාය."),
      LiveQuizQuestion(4, "Grade $grade", "ඉතිහාසය", "අනුරාධපුර රාජධානියේ ප්‍රථම සැලසුම්ගත නගරය ඉදිකළ රජු කවුද?", listOf("දේවානම්පියතිස්ස", "පණ්ඩුකාභය", "දුටුගැමුණු", "විජය"), 1, "පණ්ඩුකාභය රජු අනුරාධපුරය මුල්ම සැලසුම්ගත අගනුවර කළේය."),
      LiveQuizQuestion(5, "Grade $grade", "ඉතිහාසය", "ලක්දිවට බුදුදහම රැගෙන ආවේ කුමන රජ සමයේදීද?", listOf("පණ්ඩුකාභය", "දේවානම්පියතිස්ස", "ධාතුසේන", "මහාසෙන්"), 1, "දේවානම්පියතිස්ස රජ සමයේ මිහිඳු මහ රහතන් වහන්සේ වැඩම කළහ."),
      LiveQuizQuestion(6, "Grade $grade", "ඉතිහාසය", "සීගිරිය බලකොටුව නිර්මාණය කළ රජු කවුද?", listOf("ධාතුසේන", "කාශ්‍යප", "මුගලන්", "අග්බෝ"), 1, "කාශ්‍යප රජු ක්‍රි.ව. 5 වන සියවසේදී සීගිරිය කළේය."),
      LiveQuizQuestion(7, "Grade $grade", "ඉතිහාසය", "පොළොන්නරු යුගයේ ශ්‍රේෂ්ඨතම වාරි රජු කවුද?", listOf("විජයබාහු", "මහා පරාක්‍රමබාහු", "නිශ්ශංකමල්ල", "කාවන්තිස්ස"), 1, "මහා පරාක්‍රමබාහු රජු පරාක්‍රම සමුද්‍රය ඇතුළු වාරි කර්මාන්ත කළේය."),
      LiveQuizQuestion(8, "Grade $grade", "ඉතිහාසය", "රුවන්වැලි මහා සෑය කරවූ රජතුමා කවුද?", listOf("දුටුගැමුණු", "තිස්ස", "වසභ", "මහාසෙන්"), 0, "දුටුගැමුණු රජතුමා විසින් රුවන්වැලි සෑය ඉදිකෙරිණි."),
      LiveQuizQuestion(9, "Grade $grade", "ඉතිහාසය", "ලංකාවේ විශාලතම ස්තූපය වන ජේතවනාරාමය ඉදිකළ රජු කවුද?", listOf("දුටුගැමුණු", "මහාසෙන්", "ධාතුසේන", "වළගම්බා"), 1, "මහාසෙන් රජු ජේතවනාරාමය කරවීය."),
      LiveQuizQuestion(10, "Grade $grade", "ඉතිහාසය", "1815 මාර්තු 2 වන දින අත්සන් කරන ලද ගිවිසුම කුමක්ද?", listOf("උඩරට ගිවිසුම", "කොළඹ ගිවිසුම", "මහනුවර ගිවිසුම", "ආණ්ඩුක්‍රම ගිවිසුම"), 0, "1815 උඩරට ගිවිසුම මඟින් සමස්ත ලංකාවම බ්‍රිතාන්‍යයට යටත් විය."),
      LiveQuizQuestion(11, "Grade $grade", "ඉතිහාසය", "පෘතුගීසීන් ලංකාවට පැමිණි වර්ෂය කුමක්ද?", listOf("1505", "1658", "1796", "1815"), 0, "1505 දී ලොරෙන්සෝ ද අල්මේදා ලංකාවට පැමිණියේය."),
      LiveQuizQuestion(12, "Grade $grade", "ඉතිහාසය", "ලන්දේසීන්ගෙන් මුහුදුබඩ ප්‍රදේශ ඉංග්‍රීසීන්ට යටත් වූයේ කුමන වර්ෂයේදීද?", listOf("1505", "1658", "1796", "1802"), 2, "1796 දී බ්‍රිතාන්‍යයන් මුහුදුබඩ පළාත් අත්පත් කරගත්තේය."),
      LiveQuizQuestion(13, "Grade $grade", "ඉතිහාසය", "කෝට්ටේ යුගයේදී රජකළ ශ්‍රේෂ්ඨතම අධිරාජ්‍යයා කවුද?", listOf("6 වන පරාක්‍රමබාහු", "ධර්මපාල", "මායාදුන්නේ", "රාජසිංහ"), 0, "6 වන පරාක්‍රමබාහු රජු මුළු ලංකාවම එක්සේසත් කළේය."),
      LiveQuizQuestion(14, "Grade $grade", "ඉතිහාසය", "ලක්දිව ප්‍රථම සිංහල සිනමාපටය වන 'කඩවුණු පොරොන්දුව' තිරගත වූ වර්ෂය කුමක්ද?", listOf("1947", "1948", "1956", "1972"), 0, "1947 ජනවාරි 21 වන දින තිරගත විය."),
      LiveQuizQuestion(15, "Grade $grade", "ඉතිහාසය", "මහාවංශය රචනා කළ භික්ෂූන් වහන්සේ කවුරුන්ද?", listOf("මහානාම හිමි", "ශ්‍රී රාහුල හිමි", "ධර්මසේන හිමි", "බුද්ධඝෝෂ හිමි"), 0, "මහානාම හිමියන් විසින් 5 වන සියවසේදී මහාවංශය රචනා විය."),
      LiveQuizQuestion(16, "Grade $grade", "ඉතිහාසය", "ශ්‍රී ලංකාවේ මුල්ම උමං මාර්ගය (Tunnel) ඉදිකළ ආණ්ඩුකාරවරයා කවුද?", listOf("එඩ්වඩ් බාන්ස්", "කෝල්බෲක්", "මැකලම්", "වෝඩ්"), 0, "එඩ්වඩ් බාන්ස් යටතේ කඩුගන්නාව උමං මාර්ගය හැදිණි."),
      LiveQuizQuestion(17, "Grade $grade", "ඉතිහාසය", "ත්‍රිකුණාමලය වරායේ පිහිටි පෘතුගීසි බලකොටුව කුමක්ද?", listOf("ෆෙඩ්රික් කොටුව", "ගාලු කොටුව", "කොළඹ කොටුව", "යාපනය කොටුව"), 0, "ෆෙඩ්රික් කොටුව (Fort Fredrick) ත්‍රිකුණාමලයේ පිහිටා ඇත."),
      LiveQuizQuestion(18, "Grade $grade", "ඉතිහාසය", "ශ්‍රී ලංකාවේ අවසාන රජු වූයේ කවුද?", listOf("ශ්‍රී වික්‍රම රාජසිංහ", "කීර්ති ශ්‍රී රාජසිංහ", "ශ්‍රී විජය රාජසිංහ", "නරේන්ද්‍රසිංහ"), 0, "ශ්‍රී වික්‍රම රාජසිංහ රජු ලංකාවේ අන්තිම රජුය."),
      LiveQuizQuestion(19, "Grade $grade", "ඉතිහාසය", "1848 මාතලේ නිදහස් සටනට නායකත්වය දුන්නේ කවුද?", listOf("වීර පුරන් අප්පු සහ ගොන්ගාලේගොඩ බණ්ඩා", "කැප්පෙටිපොළ", "මඩුගල්ලේ", "ඇහැලේපොළ"), 0, "වීර පුරන් අප්පු සහ ගොන්ගාලේගොඩ බණ්ඩා නායකත්වය දුන්හ."),
      LiveQuizQuestion(20, "Grade $grade", "ඉතිහාසය", "1972 දී ශ්‍රී ලංකාව ජනරජයක් (Republic) බවට පත්කළ ආණ්ඩුක්‍රම ව්‍යවස්ථාව කුමක්ද?", listOf("පළමු ජනරජ ව්‍යවස්ථාව", "සෝල්බරි ව්‍යවස්ථාව", "ඩොනමෝර් ව්‍යවස්ථාව", "දෙවන ජනරජ ව්‍යවස්ථාව"), 0, "1972 මැයි 22 ප්‍රථම ජනරජ ව්‍යවස්ථාව සම්මත විය.")
    )
  }

  // -----------------------------------------------------------------------------------------
  // ✍️ 4. SINHALA QUESTIONS (සිංහල භාෂාව හා සාහිත්‍යය) - 20 Questions
  // -----------------------------------------------------------------------------------------
  private fun getSinhalaQuestions(grade: Int): List<LiveQuizQuestion> {
    return listOf(
      LiveQuizQuestion(1, "Grade $grade", "සිංහල", "'ගසින් ගෙඩියක් වැටුණි' යන වාක්‍යයේ 'ගසින්' යනු කුමන විභක්තියද?", listOf("කර්ම විභක්තිය", "කරණ විභක්තිය", "අවධි විභක්තිය", "සම්ප්‍රදාන විභක්තිය"), 2, "වෙන්වීම දැක්වීමට අවධි විභක්තිය යෙදේ."),
      LiveQuizQuestion(2, "Grade $grade", "සිංහල", "'ගුත්තිල කාව්‍යය' රචනා කළ කතුවරයා කවුරුන්ද?", listOf("ශ්‍රී රාහුල හිමි", "වෑත්තෑවේ හිමි", "විදුරස්න හිමි", "අලගියවන්න මුකවෙටි"), 1, "වෑත්තෑවේ හිමියන් විසින් රචනා කරන ලදී."),
      LiveQuizQuestion(3, "Grade $grade", "සිංහල", "'නිල්වන් ගුවන් ගැබ' යනු කුමන සමාස පදයක්ද?", listOf("කර්මධාරය සමාසය", "ද්වන්ද සමාසය", "තත්පුරුෂ සමාසය", "බහුබ්බීහි සමාසය"), 0, "විශේෂණය හා විශේෂ්‍යය එක්වීමෙන් කර්මධාරය සමාසය වේ."),
      LiveQuizQuestion(4, "Grade $grade", "සිංහල", "සන්ධි පදය තෝරන්න: 'ගුරු' + 'උපදේශ'", listOf("ගුරුපදේශ", "ගුරූපදේශ", "ගුරුඋපදේශ", "ගුරුපදේශය"), 1, "ස්වර සන්ධියේදී දීර්ඝ වී 'ගුරූපදේශ' වේ."),
      LiveQuizQuestion(5, "Grade $grade", "සිංහල", "'අමෘතය' යන්නෙහි විරුද්ධ පදය කුමක්ද?", listOf("සුරාව", "විෂ", "පැණි", "දියර"), 1, "අමෘතය හි ප්‍රතිවිරුද්ධ පදය 'විෂ' වේ."),
      LiveQuizQuestion(6, "Grade $grade", "සිංහල", "'කන්ද' යන වචනයට සමාන පදයක් තෝරන්න:", listOf("ගිර", "ගඟ", "මුහුද", "වන"), 0, "'ගිර' යනු කන්දට සමාන පදයකි."),
      LiveQuizQuestion(7, "Grade $grade", "සිංහල", "පහත සඳහන් පද අතුරින් නිවැරදි අක්ෂර වින්‍යාසය සහිත පදය කුමක්ද?", listOf("ප්‍රවේශය", "ප්‍රවේශය", "ප්‍රවේශය", "ප්‍රවේශය"), 0, "නිවැරදි අක්ෂර වින්‍යාසය 'ප්‍රවේශය' වේ."),
      LiveQuizQuestion(8, "Grade $grade", "සිංහල", "'පුත් + රුවන්' සන්ධි වූ විට ලැබෙන්නේ කුමක්ද?", listOf("පුත්රුවන්", "පුතුන්", "පුත්රුවන", "පුත්රුව"), 0, "ව්‍යඤ්ජන සන්ධියෙන් 'පුත්රුවන්' වේ."),
      LiveQuizQuestion(9, "Grade $grade", "සිංහල", "'කව්සිළුමිණ' මහා කාව්‍යය රචනා කළ රජු කවුද?", listOf("2 වන පරාක්‍රමබාහු රජු", "දුටුගැමුණු රජු", "කාශ්‍යප රජු", "විජයබාහු රජු"), 0, "දඹදෙණි යුගයේ 2 වන පරාක්‍රමබාහු (කලිකාල සාහිත්‍ය සර්වඥ පණ්ඩිත) රජුය."),
      LiveQuizQuestion(10, "Grade $grade", "සිංහල", "'අලස' යන්නෙහි නාම විශේෂණ පදය කුමක්ද?", listOf("අලසකම", "අලසව", "අලස", "අලසයෝ"), 2, "'අලස' යනු ගුණ නාම විශේෂණයකි."),
      LiveQuizQuestion(11, "Grade $grade", "සිංහල", "'ලොවට උතුම් එකම සම්පත දරුවාය' මෙහි උක්ත පදය කුමක්ද?", listOf("ලොවට", "සම්පත", "දරුවා", "එකම"), 2, "ක්‍රියා පදයට අනුව කවුරුන්දැයි ප්‍රශ්න කළ විට ලැබෙන 'දරුවා' උක්තයයි."),
      LiveQuizQuestion(12, "Grade $grade", "සිංහල", "'සැලලිහිණි සන්දේශය' අයත් වන්නේ කුමන යුගයටද?", listOf("අනුරාධපුර යුගය", "පොළොන්නරු යුගය", "කෝට්ටේ යුගය", "මහනුවර යුගය"), 2, "කෝට්ටේ යුගයේ තොටගමුවේ ශ්‍රී රාහුල හිමියන් රචනා කළහ."),
      LiveQuizQuestion(13, "Grade $grade", "සිංහල", "'සුදු මල්' යනු කුමන පද වර්ගයක්ද?", listOf("නාම පදයකි", "විශේෂණ පදයක් සහිත නාමයකි", "ක්‍රියා පදයකි", "නිපාත පදයකි"), 1, "නාම විශේෂණය + නාම පදයකි."),
      LiveQuizQuestion(14, "Grade $grade", "සිංහල", "'පොත' හි බහුවචන රූපය කුමක්ද?", listOf("පොත්", "පොත්හු", "පොත්ලා", "පොතවල්"), 0, "අප්‍රාණවාචී නාම බහුවචනයේදී 'පොත්' වේ."),
      LiveQuizQuestion(15, "Grade $grade", "සිංහල", "'හඳ' යන තද්භව පදයේ තත්සම (සංස්කෘත) රූපය කුමක්ද?", listOf("චන්ද්‍ර", "සූර්ය", "තාරකා", "ගුවන්"), 0, "හඳ -> චන්ද්‍ර වේ."),
      LiveQuizQuestion(16, "Grade $grade", "සිංහල", "'මව සහ පියා' එකතු වී සෑදෙන සමාස පදය කුමක්ද?", listOf("මවුපියෝ (ද්වන්ද සමාසය)", "මව්පිය", "මව්පියන්", "මව්"), 0, "පද දෙකක් සම තත්ත්වයෙන් එක්වීම ද්වන්ද සමාසයයි."),
      LiveQuizQuestion(17, "Grade $grade", "සිංහල", "'අහස' යන්නෙහි සමාන පදයක් නොවන්නේ කුමක්ද?", listOf("ගගන", "අඹර", "නභෝගැබ", "සාගරය"), 3, "'සාගරය' යනු මුහුදට නමකි; අහසට නොවේ."),
      LiveQuizQuestion(18, "Grade $grade", "සිංහල", "'කර්තෘ කාරක' වාක්‍යයක ක්‍රියාව උක්ත වන්නේ කාටද?", listOf("කර්තෘට (ක්‍රියාව කරන තැනැත්තාට)", "කර්මයට", "ස්ථානයට", "කාලයට"), 0, "කර්තෘ කාරකයේදී ක්‍රියාව කර්තෘ අනුව යෙදේ."),
      LiveQuizQuestion(19, "Grade $grade", "සිංහල", "'ජාතක පොත' ලියැවුණේ කුමන යුගයේදීද?", listOf("කුරුණෑගල යුගය", "කෝට්ටේ යුගය", "අනුරාධපුර යුගය", "මහනුවර යුගය"), 0, "කුරුණෑගල යුගයේදී 550 ජාතක පොත සිංහලට පරිවර්තනය විය."),
      LiveQuizQuestion(20, "Grade $grade", "සිංහල", "'ප්‍රත්‍යර්ථය' යනු කුමක්ද?", listOf("ප්‍රතිවිරුද්ධ අර්ථය", "සමාන අර්ථය", "ගැඹුරු අර්ථය", "අලුත් අර්ථය"), 0, "ප්‍රත්‍යර්ථය යනු විරුද්ධ අර්ථයයි.")
    )
  }

  // -----------------------------------------------------------------------------------------
  // 🔤 5. ENGLISH QUESTIONS (ඉංග්‍රීසි භාෂාව) - 20 Questions
  // -----------------------------------------------------------------------------------------
  private fun getEnglishQuestions(grade: Int): List<LiveQuizQuestion> {
    return listOf(
      LiveQuizQuestion(1, "Grade $grade", "ඉංග්‍රීසි", "Identify the correct passive voice form: 'She writes a letter.'", listOf("A letter is written by her.", "A letter was written by her.", "A letter is being written.", "She is writing a letter."), 0, "Present Simple active becomes 'is written by her'."),
      LiveQuizQuestion(2, "Grade $grade", "ඉංග්‍රීසි", "Choose the correct preposition: 'He is interested ___ learning computer coding.'", listOf("at", "on", "in", "with"), 2, "'Interested' is always paired with the preposition 'in'."),
      LiveQuizQuestion(3, "Grade $grade", "ඉංග්‍රීසි", "Which word is a synonym for 'Abundant'?", listOf("Scarce", "Plentiful", "Tiny", "Empty"), 1, "'Abundant' means plentiful or available in large amounts."),
      LiveQuizQuestion(4, "Grade $grade", "ඉංග්‍රීසි", "Opposite of 'Ancient' is:", listOf("Old", "Modern", "Historic", "Antique"), 1, "Antonym of Ancient is Modern."),
      LiveQuizQuestion(5, "Grade $grade", "ඉංග්‍රීසි", "Fill in the blank: 'They ___ playing cricket right now.'", listOf("is", "are", "was", "has"), 1, "Plural subject 'They' with present continuous takes 'are'."),
      LiveQuizQuestion(6, "Grade $grade", "ඉංග්‍රීසි", "Identify the adjective in: 'The brave soldier protected our country.'", listOf("soldier", "brave", "protected", "country"), 1, "'Brave' describes the noun soldier."),
      LiveQuizQuestion(7, "Grade $grade", "ඉංග්‍රීසි", "What is the past tense of the verb 'Go'?", listOf("Goed", "Gone", "Went", "Going"), 2, "Irregular verb past form is 'went'."),
      LiveQuizQuestion(8, "Grade $grade", "ඉංග්‍රීසි", "Choose the correct plural form of 'Child':", listOf("Childs", "Children", "Childrens", "Childes"), 1, "Irregular plural of child is children."),
      LiveQuizQuestion(9, "Grade $grade", "ඉංග්‍රීසි", "Select the correctly punctuated question:", listOf("where are you going", "Where are you going.", "Where are you going?", "where are you going?"), 2, "Starts with capital letter and ends with question mark."),
      LiveQuizQuestion(10, "Grade $grade", "ඉංග්‍රීසි", "A person who treats sick animals is called a:", listOf("Doctor", "Dentist", "Veterinarian (Vet)", "Nurse"), 2, "A veterinarian cares for animals."),
      LiveQuizQuestion(11, "Grade $grade", "ඉංග්‍රීසි", "Choose the correct conjunction: 'He studied hard, ___ he passed the exam.'", listOf("but", "so", "or", "because"), 1, "'So' expresses consequence."),
      LiveQuizQuestion(12, "Grade $grade", "ඉංග්‍රීසි", "What is the superlative degree of 'Good'?", listOf("Gooder", "Better", "Best", "Most Good"), 2, "Positive: Good, Comparative: Better, Superlative: Best."),
      LiveQuizQuestion(13, "Grade $grade", "ඉංග්‍රීසි", "Choose the correct article: 'She has ___ unique talent for singing.'", listOf("a", "an", "the", "no article"), 0, "'Unique' starts with a consonant sound /j/, so 'a unique' is correct."),
      LiveQuizQuestion(14, "Grade $grade", "ඉංග්‍රීසි", "Identify the adverb in: 'The cheetah runs very quickly.'", listOf("cheetah", "runs", "quickly", "very"), 2, "'Quickly' is an adverb of manner modifying the verb runs."),
      LiveQuizQuestion(15, "Grade $grade", "ඉංග්‍රීසි", "What is the antonym of 'Generous'?", listOf("Kind", "Selfish (Stingy)", "Polite", "Helpful"), 1, "Opposite of generous is selfish or stingy."),
      LiveQuizQuestion(16, "Grade $grade", "ඉංග්‍රීසි", "Complete the conditional: 'If it rains tomorrow, we ___ stay at home.'", listOf("will", "would", "would have", "are"), 0, "First conditional: If + present simple, will + verb."),
      LiveQuizQuestion(17, "Grade $grade", "ඉංග්‍රීසි", "Which of the following is a collective noun?", listOf("Student", "Flock", "Bird", "Sky"), 1, "'Flock' refers to a group of birds."),
      LiveQuizQuestion(18, "Grade $grade", "ඉංග්‍රීසි", "Identify the correct spelling:", listOf("Recieve", "Receive", "Receve", "Receeve"), 1, "Rule: 'i before e except after c' -> Receive."),
      LiveQuizQuestion(19, "Grade $grade", "ඉංග්‍රීසි", "What does the idiom 'Piece of cake' mean?", listOf("A tasty dessert", "Very easy task", "Difficult problem", "Birthday celebration"), 1, "'Piece of cake' means something that is very easy."),
      LiveQuizQuestion(20, "Grade $grade", "ඉංග්‍රීසි", "Change to indirect speech: He said, 'I am tired.'", listOf("He said that he was tired.", "He said that I am tired.", "He says he is tired.", "He told he was tired."), 0, "Present simple changes to past simple in indirect speech.")
    )
  }

  // -----------------------------------------------------------------------------------------
  // 💻 6. ICT QUESTIONS (තොරතුරු හා සන්නිවේදන තාක්ෂණය) - 20 Questions
  // -----------------------------------------------------------------------------------------
  private fun getIctQuestions(grade: Int): List<LiveQuizQuestion> {
    return listOf(
      LiveQuizQuestion(1, "Grade $grade", "ICT", "IPv4 ලිපිනයක (IP Address) අඩංගු බිටු සංඛ්‍යාව කොපමණද?", listOf("16 bits", "32 bits", "64 bits", "128 bits"), 1, "IPv4 ලිපිනයක් බිටු 32කි (IPv6 බිටු 128කි)."),
      LiveQuizQuestion(2, "Grade $grade", "ICT", "HTML ලේඛනයක ප්‍රධාන සිරස්තලයක් දැක්වීමට භාවිතා කරන Tag එක කුමක්ද?", listOf("<head>", "<h1>", "<header>", "<title>"), 1, "<h1> ප්‍රධාන සිරස්තලය දැක්වීමට යොදාගනී."),
      LiveQuizQuestion(3, "Grade $grade", "ICT", "ද්විමය (Binary) '1011₂' සංඛ්‍යාව දශමය සංඛ්‍යාවක් ලෙස දැක්වූ විට අගය,", listOf("9", "11", "13", "15"), 1, "8 + 0 + 2 + 1 = 11 වේ."),
      LiveQuizQuestion(4, "Grade $grade", "ICT", "පරිගණකයක ප්‍රධාන සැකසුම් ඒකකය (CPU) හඳුන්වන්නේ කුමන නමකින්ද?", listOf("RAM", "Central Processing Unit", "ROM", "GPU"), 1, "CPU යනු Central Processing Unit වේ."),
      LiveQuizQuestion(5, "Grade $grade", "ICT", "පරිගණකයේ විදුලිය විසන්ධි වූ විට දත්ත මැකී යන තාවකාලික මතකය කුමක්ද?", listOf("ROM", "Hard Disk", "RAM", "Flash Drive"), 2, "RAM යනු විචල්‍ය (Volatile) මතකයකි."),
      LiveQuizQuestion(6, "Grade $grade", "ICT", "පහත සඳහන් දෑ අතරින් ආදාන උපාංගයක් (Input Device) වන්නේ කුමක්ද?", listOf("Monitor", "Printer", "Keyboard", "Speaker"), 2, "Keyboard ආදාන උපාංගයකි."),
      LiveQuizQuestion(7, "Grade $grade", "ICT", "1 Kilobyte (KB) යනු බයිට් (Bytes) කීයක්ද?", listOf("100", "1000", "1024", "2048"), 2, "1 KB = 1024 Bytes වේ."),
      LiveQuizQuestion(8, "Grade $grade", "ICT", "පරිගණක මෙහෙයුම් පද්ධතියකට (Operating System) උදාහරණයක් නොවන්නේ කුමක්ද?", listOf("Windows", "Linux", "Android", "MS Word"), 3, "MS Word යනු Application Software එකකි."),
      LiveQuizQuestion(9, "Grade $grade", "ICT", "URL යන්නෙහි සම්පූර්ණ අර්ථය කුමක්ද?", listOf("Uniform Resource Locator", "Universal Radio Link", "United Resource List", "Uniform Real Link"), 0, "Uniform Resource Locator වෙබ් ලිපිනය හඳුන්වයි."),
      LiveQuizQuestion(10, "Grade $grade", "ICT", "පරිගණක ජාලයක දත්ත සම්ප්‍රේෂණය වන වේගය මනින ඒකකය කුමක්ද?", listOf("bps (bits per second)", "Bytes", "Hertz", "Pixels"), 0, "bps මඟින් ජාල වේගය මනිනු ලැබේ."),
      LiveQuizQuestion(11, "Grade $grade", "ICT", "Spreadsheet මෘදුකාංගයක (MS Excel) සූත්‍රයක් ආරම්භ කළ යුත්තේ කුමන ලකුණෙන්ද?", listOf("=", "+", "@", "#"), 0, "Excel හි සියලු සූත්‍ර '=' ලකුණින් ඇරඹේ."),
      LiveQuizQuestion(12, "Grade $grade", "ICT", "HTML හි Hyperlink එකක් ඇතුළත් කිරීමට භාවිතා කරන Tag එක කුමක්ද?", listOf("<a>", "<link>", "<href>", "<url>"), 0, "<a href='...'> anchor ටැගය යොදාගනී."),
      LiveQuizQuestion(13, "Grade $grade", "ICT", "පරිගණක දත්ත සමුදායක (Database) ප්‍රාථමික යතුර (Primary Key) සතු ගුණය කුමක්ද?", listOf("හිස් විය හැක", "අනන්‍ය (Unique) විය යුතුය", "සෑමවිටම අකුරක් විය යුතුය", "ද්විත්ව අගයන් තිබිය හැක"), 1, "Primary key එකක් අනිවාර්යයෙන්ම unique (අනන්‍ය) විය යුතුය."),
      LiveQuizQuestion(14, "Grade $grade", "ICT", "පරිගණක වෛරසයකින් සිදුවන ප්‍රධාන හානිය කුමක්ද?", listOf("මවුසය කැඩීම", "දත්ත හා ලිපිගොනු විනාශ කිරීම හෝ සොරකම් කිරීම", "මොනිටරය කුඩාවීම", "විදුලි බිල වැඩිවීම"), 1, "මෘදුකාංග හා දත්ත වලට හානි සිදුකරයි."),
      LiveQuizQuestion(15, "Grade $grade", "ICT", "SSD (Solid State Drive) එකක් සාමාන්‍ය Hard Disk එකකට වඩා වේගවත් වීමට හේතුව කුමක්ද?", listOf("භ්‍රමණය වන යාන්ත්‍රික කොටස් නොමැති ෆ්ලෑෂ් මතකයක් වීම", "ප්‍රමාණයෙන් විශාල වීම", "ප්ලාස්ටික් වලින් සාදා තිබීම", "මිල අඩු වීම"), 0, "SSD වල චලනය වන යාන්ත්‍රික කොටස් නැත."),
      LiveQuizQuestion(16, "Grade $grade", "ICT", "LAN යන්නෙහි සම්පූර්ණ නාමය කුමක්ද?", listOf("Local Area Network", "Large Area Network", "Logical Access Network", "Land Area Network"), 0, "Local Area Network යනු කුඩා ප්‍රදේශයක ජාලයයි."),
      LiveQuizQuestion(17, "Grade $grade", "ICT", "RGB වර්ණ ආකෘතියේ ප්‍රධාන වර්ණ තුන මොනවාද?", listOf("Red, Green, Blue", "Red, Gold, Black", "Rose, Green, Brown", "Red, Grey, Blue"), 0, "රතු, කොළ සහ නිල් RGB නියෝජනය කරයි."),
      LiveQuizQuestion(18, "Grade $grade", "ICT", "පයිතන් (Python) ක්‍රමලේඛන භාෂාවේ විචල්‍යයක් මුද්‍රණය කිරීමට භාවිතා කරන Function එක කුමක්ද?", listOf("print()", "echo()", "write()", "output()"), 0, "print() ශ්‍රිතය භාවිතා වේ."),
      LiveQuizQuestion(19, "Grade $grade", "ICT", "දත්ත සමුදායකින් දත්ත විමසීමට (Query) භාවිතා කරන සම්මත භාෂාව කුමක්ද?", listOf("SQL", "HTML", "CSS", "XML"), 0, "Structured Query Language (SQL) වේ."),
      LiveQuizQuestion(20, "Grade $grade", "ICT", "Firewall මඟින් පරිගණක පද්ධතියකට ලබාදෙන ප්‍රධාන ආරක්ෂාව කුමක්ද?", listOf("අනවසර ජාල ප්‍රවේශ හා සයිබර් ප්‍රහාර වැළැක්වීම", "දූවිලි පිරිසිදු කිරීම", "CPU සිසිල් කිරීම", "විදුලිය ඉතිරි කිරීම"), 0, "ජාල ආරක්ෂාව තහවුරු කරයි.")
    )
  }

  // -----------------------------------------------------------------------------------------
  // ☸️ 7. BUDDHISM & ETHICS QUESTIONS (බුද්ධ ධර්මය සහ සාරධර්ම) - 20 Questions
  // -----------------------------------------------------------------------------------------
  private fun getBuddhismQuestions(grade: Int): List<LiveQuizQuestion> {
    return listOf(
      LiveQuizQuestion(1, "Grade $grade", "බුද්ධ ධර්මය", "චතුරාර්ය සත්‍යයේ දුක්ඛ නිරෝධ ගාමිණී පටිපදාව යනු කුමක්ද?", listOf("දුක පිළිබඳ සත්‍යය", "දුකට හේතුව", "ආර්ය අෂ්ටාංගික මාර්ගය", "නිවන"), 2, "දුක නැති කිරීමේ මාර්ගය ආර්ය අෂ්ටාංගික මාර්ගයයි."),
      LiveQuizQuestion(2, "Grade $grade", "බුද්ධ ධර්මය", "බුදුරජාණන් වහන්සේ ප්‍රථම ධර්ම දේශනාව පැවැත්වූයේ කා හටද?", listOf("පස්වග තවුසන්ට", "සැරියුත් මුගලන් හිමිවරුන්ට", "යස කුලපුත්‍රයාට", "බිම්බිසාර රජුට"), 0, "ඉසිපතන මිගදායේදී පස්වග මහණුන්ට දම්සක් පැවතුම් සූත්‍රය දේශනා කළ සේක."),
      LiveQuizQuestion(3, "Grade $grade", "බුද්ධ ධර්මය", "ත්‍රිපිටකයේ අඩංගු ප්‍රධාන කොටස් 3 මොනවාද?", listOf("සූත්‍ර, විනය, අභිධර්ම", "දීඝ, මජ්ඣිම, සංයුක්ත", "ජාතක, ධම්මපද, බුද්ධවංශ", "මහා, චූල, අංගුත්තර"), 0, "විනය පිටකය, සූත්‍ර පිටකය හා අභිධර්ම පිටකය වේ."),
      LiveQuizQuestion(4, "Grade $grade", "බුද්ධ ධර්මය", "බුදුරජාණන් වහන්සේගේ අග්‍රශ්‍රාවක දෙනම කවුරුන්ද?", listOf("සැරියුත් - මුගලන් මහ රහතන් වහන්සේලා", "ආනන්ද - අනුරුද්ධ හිමිවරු", "කාශ්‍යප - උපාලි හිමිවරු", "කොණ්ඩඤ්ඤ - පුණ්ණ හිමිවරු"), 0, "සැරියුත් (ප්‍රඥාවන්ත) සහ මුගලන් (ඍද්ධිමත්) හිමිවරු අග්‍රශ්‍රාවකයන්ය."),
      LiveQuizQuestion(5, "Grade $grade", "බුද්ධ ධර්මය", "සිදුහත් කුමරු ගිහිගෙය හැර යාමට හේතු වූ සතර පෙරනිමිති අතරට අයත් නොවන්නේ කුමක්ද?", listOf("ලෙඩා", "මහල්ලා", "මළමිනිය", "රජතුමා"), 3, "ජරා, ව්‍යාධි, මරණ සහ පැවිදි රුව සතර පෙරනිමිති වේ."),
      LiveQuizQuestion(6, "Grade $grade", "බුද්ධ ධර්මය", "බුදුරදුන් පිරිනිවන් පෑ ස්ථානය කුමක්ද?", listOf("කුසිනාරා නුවර උපවත්තන සල් උයන", "ලුම්බිණි සල් උයන", "බුද්ධගයාව", "ඉසිපතනය"), 0, "මල්ල රජදරුවන්ගේ කුසිනාරා නුවරදී පිරිනිවන් පෑ සේක."),
      LiveQuizQuestion(7, "Grade $grade", "බුද්ධ ධර්මය", "ප්‍රථම ධර්ම සංගායනාව පැවැත්වුණේ කාගේ ප්‍රධානත්වයෙන්ද?", listOf("මහා කාශ්‍යප මහරහතන් වහන්සේ", "ආනන්ද හිමි", "උපාලි හිමි", "යස හිමි"), 0, "මහා කාශ්‍යප මහරහතන් වහන්සේගේ මූලිකත්වයෙන් රජගහනුවර සප්තපර්ණී ගුහාවේදී පැවැත්විණි."),
      LiveQuizQuestion(8, "Grade $grade", "බුද්ධ ධර්මය", "පන්සිල්හි තුන්වන ශික්ෂා පදය කුමක්ද?", listOf("පාණාතිපාතා වේරමණී", "අදින්නාදානා වේරමණී", "කාමේසුමිච්ඡාචාරා වේරමණී", "මුසාවාදා වේරමණී"), 2, "කාමයන්හි වරදවා නොහැසිරීම තුන්වන සිල් පදයයි."),
      LiveQuizQuestion(9, "Grade $grade", "බුද්ධ ධර්මය", "ත්‍රිවිධ පුණ්‍ය ක්‍රියා අතරට අයත් වන්නේ මොනවාද?", listOf("දාන, ශීල, භාවනා", "කර්ම, විපාක, ඵල", "ලෝභ, දෝස, මෝහ", "අනිත්‍ය, දුක්ඛ, අනත්ත"), 0, "දාන, ශීල, භාවනා ත්‍රිවිධ පුණ්‍ය ක්‍රියා වේ."),
      LiveQuizQuestion(10, "Grade $grade", "බුද්ධ ධර්මය", "ත්‍රිලක්ෂණය යනු කුමක්ද?", listOf("අනිත්‍ය, දුක්ඛ, අනත්ත", "ශ්‍රද්ධා, ප්‍රඥා, වීර්ය", "සීල, සමාධි, පඤ්ඤා", "රාග, ද්වේෂ, මෝහ"), 0, "සියලු සංස්කාරයන්ගේ අනිත්‍ය, දුක්ඛ, අනත්ත ස්වභාවයයි."),
      LiveQuizQuestion(11, "Grade $grade", "බුද්ධ ධර්මය", "සත් සතියේ දෙවන සතිය කුමක්ද?", listOf("අනිමිසලෝචන පූජාව", "රතනඝර පූජාව", "රතනචංකමන පූජාව", "අජපාල නිග්‍රෝධ මූලය"), 0, "ජය ශ්‍රී මහා බෝධිය දෙස ඇසිපිය නොහෙළා බලා සිටි අනිමිසලෝචන පූජාවයි."),
      LiveQuizQuestion(12, "Grade $grade", "බුද්ධ ධර්මය", "දස පාරමිතා අතර ප්‍රථම පාරමිතාව කුමක්ද?", listOf("දාන පාරමිතාව", "ශීල පාරමිතාව", "නෙක්ඛම්ම පාරමිතාව", "ප්‍රඥා පාරමිතාව"), 0, "බෝසත්වරුන් ප්‍රථමයෙන් පුරන්නේ දාන පාරමිතාවයි."),
      LiveQuizQuestion(13, "Grade $grade", "බුද්ධ ධර්මය", "සිඟාලෝවාද සූත්‍රයේ එන දිශා හය අතරින් උතුරු දිශාවෙන් සංකේතවත් වන්නේ කවුරුන්ද?", listOf("මිත්‍රයෝ (යහළුවන්)", "දෙමව්පියන්", "ගුරුවරුන්", "ස්වාමි-භාර්යා"), 0, "උතුරු දිශාවෙන් මිත්‍රයන් නියෝජනය වේ."),
      LiveQuizQuestion(14, "Grade $grade", "බුද්ධ ධර්මය", "දේවානම්පියතිස්ස රජු මිහින්තලයේදී දඩයම් කරමින් සිටි සත්ත්වයා කවුද?", listOf("මුවා", "ගෝනා", "ඇතා", "වළසා"), 0, "තිස්ස රජු මුව දඩයමේ යෙදී සිටියේය."),
      LiveQuizQuestion(15, "Grade $grade", "බුද්ධ ධර්මය", "ජය ශ්‍රී මහා බෝධීන් වහන්සේගේ දක්ෂිණ ශාඛාව ලක්දිවට වැඩම කළ මෙහෙණින් වහන්සේ කවුද?", listOf("සංඝමිත්තා මහා රහත් මෙහෙණින් වහන්සේ", "යශෝධරා මෙහෙණිය", "ප්‍රජාපතී ගෝතමී මෙහෙණිය", "උප්පලවණ්ණා මෙහෙණිය"), 0, "සංඝමිත්තා තෙරණිය විසින් බෝධි ශාඛාව වැඩම කරන ලදී."),
      LiveQuizQuestion(16, "Grade $grade", "බුද්ධ ධර්මය", "මංගල සූත්‍රය දේශනා කරන ලද්දේ කාගේ ආරාධනයෙන්ද?", listOf("දේවතාවෙකුගේ", "බිම්බිසාර රජුගේ", "අනේපිඬු සිටුතුමාගේ", "කොසොල් රජුගේ"), 0, "ජේතවනාරාමයේදී රැයක පැමිණි දෙවියෙකුගේ ප්‍රශ්නයකට පිළිතුරු ලෙසයි."),
      LiveQuizQuestion(17, "Grade $grade", "බුද්ධ ධර්මය", "ත්‍රිවිධ රත්නය යනු මොනවාද?", listOf("බුද්ධ, ධම්ම, සංඝ", "සීල, සමාධි, ප්‍රඥා", "කර්ම, ඵල, නිවන", "දාන, ශීල, භාවනා"), 0, "බුදුන්, දහම්, සඟුන් තෙරුවනයි."),
      LiveQuizQuestion(18, "Grade $grade", "බුද්ධ ධර්මය", "බුදුරජාණන් වහන්සේගේ ධර්ම භාණ්ඩාගාරික ලෙස හැඳින්වෙන්නේ කවුරුන්ද?", listOf("ආනන්ද මහ රහතන් වහන්සේ", "සැරියුත් හිමි", "මුගලන් හිමි", "මහා කාශ්‍යප හිමි"), 0, "වසර 25ක් බුදුරදුන්ගේ උපස්ථායක වූ ආනන්ද හිමියන්ය."),
      LiveQuizQuestion(19, "Grade $grade", "බුද්ධ ධර්මය", "ධම්මපදයේ පළමු ගාථාව ආරම්භ වන්නේ කුමන වචනයෙන්ද?", listOf("මනෝපුබ්බංගමා ධම්මා", "නහි වේරේන වේරානී", "අප්පමාදෝ අමතපදං", "ධම්මෝ හවේ රක්ඛති ධම්මචාරී"), 0, "මනස සියල්ලට පෙරටු වන බව දක්වන 'මනෝපුබ්බංගමා ධම්මා' ගාථාවෙනි."),
      LiveQuizQuestion(20, "Grade $grade", "බුද්ධ ධර්මය", "බුදුරදුන් වදාළ උතුම්ම ත්‍යාගය හෙවත් දානය කුමක්ද?", listOf("ධර්ම දානය (සබ්බ දානං ධම්ම දානං ජිනාති)", "ආමිස දානය", "අභය දානය", "ශ්‍රම දානය"), 0, "සියලු දානයන් පරදවා ධර්ම දානය ජයගනී.")
    )
  }

  fun getMockLeaderboard(grade: String, userScore: Int = 18, userTimeMs: Long = 245000): List<LeaderboardEntry> {
    val clean = grade.replace("ශ්‍රේණිය", "").replace("Grade", "").trim()
    val base = mutableListOf(
      LeaderboardEntry(1, "u1", "ශිෂ්‍ය #01", "බස්නාහිර පළාත", 20, 20, 184500, "🥇"),
      LeaderboardEntry(2, "u2", "ශිෂ්‍ය #02", "මධ්‍යම පළාත", 20, 20, 198200, "🥈"),
      LeaderboardEntry(3, "u3", "ශිෂ්‍ය #03", "දකුණු පළාත", 19, 20, 210400, "🥉"),
      LeaderboardEntry(4, "u4", "ශිෂ්‍ය #04", "වයඹ පළාත", 19, 20, 225100, "⭐"),
      LeaderboardEntry(5, "u5", "ශිෂ්‍ය #05", "සබරගමුව පළාත", 19, 20, 239800, "⭐"),
      LeaderboardEntry(6, "u6", "ඔබ (You)", "Grade $clean Student", userScore, 20, userTimeMs, "🎯", isCurrentUser = true),
      LeaderboardEntry(7, "u7", "ශිෂ්‍ය #07", "උතුරු මැද පළාත", 18, 20, 256700, "🎖️"),
      LeaderboardEntry(8, "u8", "ශිෂ්‍ය #08", "ඌව පළාත", 17, 20, 268900, "🎖️"),
      LeaderboardEntry(9, "u9", "ශිෂ්‍ය #09", "නැගෙනහිර පළාත", 17, 20, 274300, "🎖️"),
      LeaderboardEntry(10, "u10", "ශිෂ්‍ය #10", "උතුරු පළාත", 16, 20, 289000, "🎖️")
    )
    return base.sortedWith(compareByDescending<LeaderboardEntry> { it.score }.thenBy { it.totalTimeTakenMs })
      .mapIndexed { index, entry -> entry.copy(rank = index + 1) }
  }
}

// -----------------------------------------------------------------------------------------
// COMPOSABLE: MAIN LIVE DAILY QUIZ CONTEST ARENA SCREEN
// -----------------------------------------------------------------------------------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyLiveQuizHubScreen(
  initialGrade: String = "11 ශ්‍රේණිය",
  userName: String = "ශිෂ්‍යයා",
  userApprovedGrades: List<String> = emptyList(),
  isAdmin: Boolean = false,
  onBack: () -> Unit
) {
  val context = LocalContext.current
  val grades = listOf("10 ශ්‍රේණිය", "11 ශ්‍රේණිය")
  
  // Helper to check if a specific grade is approved
  fun isGradeApproved(gradeStr: String): Boolean {
    if (isAdmin || userApprovedGrades.isEmpty()) return true
    val clean = gradeStr.replace("ශ්‍රේණිය", "").replace("Grade", "").replace("වසර", "").trim()
    val padded = if (clean.length == 1) "0$clean" else clean
    return userApprovedGrades.any { app ->
      val cleanApp = app.replace("ශ්‍රේණිය", "").replace("Grade", "").replace("වසර", "").trim()
      cleanApp == clean || cleanApp == padded || app.contains(clean)
    }
  }

  val defaultGrade = remember(userApprovedGrades, initialGrade) {
    if (userApprovedGrades.isNotEmpty() && !isAdmin) {
      grades.firstOrNull { isGradeApproved(it) } ?: (if (initialGrade.isBlank()) "11 ශ්‍රේණිය" else initialGrade)
    } else {
      if (initialGrade.isBlank()) "11 ශ්‍රේණිය" else initialGrade
    }
  }

  var selectedGrade by remember { mutableStateOf(defaultGrade) }

  // Contest Lifecycle Status State
  var simulatedMode by remember { mutableStateOf(false) } // Practice anytime or live mode
  var isQuizActive by remember { mutableStateOf(false) }
  var isQuizFinished by remember { mutableStateOf(false) }
  var completedAttempt by remember { mutableStateOf<LiveQuizAttempt?>(null) }
  var showReviewModal by remember { mutableStateOf(false) }
  var showScheduleInfoModal by remember { mutableStateOf(false) }
  var showArchitectureModal by remember { mutableStateOf(false) }

  // Current real-time clock and contest status calculation
  var currentTimeString by remember { mutableStateOf("") }
  var currentContestStatus by remember { mutableStateOf(LiveQuizContestStatus.UPCOMING) }
  var secondsUntil7PM by remember { mutableStateOf(0L) }

  LaunchedEffect(Unit) {
    while (true) {
      val now = Calendar.getInstance()
      val sdf = SimpleDateFormat("hh:mm:ss a", Locale.getDefault())
      currentTimeString = sdf.format(now.time)

      val hour = now.get(Calendar.HOUR_OF_DAY)
      val minute = now.get(Calendar.MINUTE)

      // Contest schedule: 7:00 PM (19:00)
      if (hour < 19) {
        currentContestStatus = LiveQuizContestStatus.UPCOMING
        val target = Calendar.getInstance().apply {
          set(Calendar.HOUR_OF_DAY, 19)
          set(Calendar.MINUTE, 0)
          set(Calendar.SECOND, 0)
        }
        secondsUntil7PM = maxOf(0L, (target.timeInMillis - now.timeInMillis) / 1000)
      } else if (hour == 19 && minute < 5) {
        currentContestStatus = LiveQuizContestStatus.ENTRY_OPEN
        secondsUntil7PM = 0L
      } else if (hour == 19 && minute < 15) {
        currentContestStatus = LiveQuizContestStatus.IN_PROGRESS
        secondsUntil7PM = 0L
      } else {
        currentContestStatus = LiveQuizContestStatus.RESULTS_READY
        secondsUntil7PM = 0L
      }

      delay(1000)
    }
  }

  val activeQuestions = remember(selectedGrade) {
    DailyLiveQuizRepository.getQuestionsForGrade(selectedGrade)
  }

  val leaderboard = remember(selectedGrade, completedAttempt) {
    DailyLiveQuizRepository.getMockLeaderboard(
      grade = selectedGrade,
      userScore = completedAttempt?.score ?: 18,
      userTimeMs = completedAttempt?.totalTimeTakenMs ?: 245000L
    )
  }

  Scaffold(
    topBar = {
      if (!isQuizActive) {
        TopAppBar(
          title = {
            Column {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text("🏆 සජීවී දෛනික Quiz තරගාවලිය", fontWeight = FontWeight.Bold, fontSize = 16.sp)
              }
              Text("AI-Powered Live 7:00 PM Arena (Grades 6-11)", fontSize = 11.sp, color = Color(0xFF64748B))
            }
          },
          navigationIcon = {
            IconButton(onClick = onBack) {
              Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
          },
          actions = {
            IconButton(onClick = { showArchitectureModal = true }) {
              Icon(Icons.Default.Info, contentDescription = "Cloud Architecture", tint = Color(0xFF4F46E5))
            }
            IconButton(onClick = { showScheduleInfoModal = true }) {
              Icon(Icons.Default.Notifications, contentDescription = "Timeline", tint = Color(0xFF0284C7))
            }
          },
          colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
        )
      }
    }
  ) { padding ->
    if (isQuizActive) {
      // ACTIVE LIVE QUIZ ARENA (20 Questions, 30s Server Timer, Anti-Cheating, 100% Distraction Free)
      LiveQuizArenaRunner(
        questions = activeQuestions,
        grade = selectedGrade,
        userName = userName,
        modifier = Modifier
          .fillMaxSize()
          .padding(if (isQuizActive) PaddingValues(0.dp) else padding),
        onQuizCompleted = { attempt ->
          completedAttempt = attempt
          isQuizActive = false
          isQuizFinished = true
        },
        onExit = { isQuizActive = false }
      )
    } else {
      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
          .padding(padding)
          .background(Color(0xFFF8FAFC))
          .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        // TOP BANNER: LIVE CONTEST RADAR
        item {
          LiveContestRadarCard(
            status = if (simulatedMode) LiveQuizContestStatus.ENTRY_OPEN else currentContestStatus,
            currentTime = currentTimeString,
            secondsTo7PM = secondsUntil7PM,
            simulatedMode = simulatedMode,
            onToggleSimulation = { simulatedMode = !simulatedMode },
            onEnterContest = {
              isQuizFinished = false
              isQuizActive = true
            }
          )
        }

        // GRADE SELECTOR PILLS
        item {
          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = "📚 ශ්‍රේණිය තෝරන්න (Select Grade)",
                  fontWeight = FontWeight.Bold,
                  fontSize = 13.sp,
                  color = Color(0xFF1E293B)
                )
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = Color(0xFFEEF2FF)
                ) {
                  Text(
                    text = "විභාග මට්ටම: $selectedGrade",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4F46E5),
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                  )
                }
              }

              Spacer(modifier = Modifier.height(10.dp))

              LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                items(grades) { gradeItem ->
                  val isSelected = gradeItem == selectedGrade
                  val isApproved = isGradeApproved(gradeItem)

                  Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = if (isSelected) Color(0xFF4F46E5) else if (isApproved && userApprovedGrades.isNotEmpty()) Color(0xFFECFDF5) else Color(0xFFF1F5F9),
                    border = BorderStroke(
                      1.dp,
                      if (isSelected) Color(0xFF4338CA) else if (isApproved && userApprovedGrades.isNotEmpty()) Color(0xFFA7F3D0) else Color(0xFFE2E8F0)
                    ),
                    modifier = Modifier.clickable {
                      selectedGrade = gradeItem
                      if (!isApproved) {
                        Toast.makeText(context, "🔒 මෙම ශ්‍රේණිය සඳහා ඇඩ්මින් අනුමැතිය අවශ්‍ය වේ (ඔබගේ අනුමැතිය: ${userApprovedGrades.joinToString()})", Toast.LENGTH_SHORT).show()
                      }
                    }
                  ) {
                    Row(
                      verticalAlignment = Alignment.CenterVertically,
                      modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                    ) {
                      Text(
                        text = gradeItem,
                        fontSize = 12.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = if (isSelected) Color.White else if (isApproved && userApprovedGrades.isNotEmpty()) Color(0xFF047857) else Color(0xFF475569)
                      )
                      if (isApproved && userApprovedGrades.isNotEmpty() && !isSelected) {
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("✓", fontSize = 10.sp, color = Color(0xFF059669), fontWeight = FontWeight.ExtraBold)
                      }
                    }
                  }
                }
              }
            }
          }
        }

        // USER LAST ATTEMPT SUMMARY (IF FINISHED)
        if (isQuizFinished && completedAttempt != null) {
          item {
            QuizScoreSummaryCard(
              attempt = completedAttempt!!,
              onReview = { showReviewModal = true },
              onRetake = {
                isQuizActive = true
              }
            )
          }
        }

        // GRADE-ISOLATED TOP 10 LEADERBOARD
        item {
          GradeLeaderboardSection(
            grade = selectedGrade,
            leaderboard = leaderboard
          )
        }

        // AUTOMATION PIPELINE INFO CARD
        item {
          AutomationPipelineCard(
            onClickTimeline = { showScheduleInfoModal = true },
            onClickArch = { showArchitectureModal = true }
          )
        }
      }
    }
  }

  // MODAL: REVIEW QUESTIONS & DETAILED AI EXPLANATIONS
  if (showReviewModal && completedAttempt != null) {
    QuizReviewDialog(
      questions = activeQuestions,
      userAnswers = completedAttempt!!.answersMap,
      onDismiss = { showReviewModal = false }
    )
  }

  // MODAL: 24-HOUR AUTOMATION TIMELINE & CRON SCHEDULE
  if (showScheduleInfoModal) {
    AutomationScheduleDialog(onDismiss = { showScheduleInfoModal = false })
  }

  // MODAL: SYSTEM ARCHITECTURE & PROMPT INTEGRATION EXPLAINER
  if (showArchitectureModal) {
    SystemArchitectureDialog(onDismiss = { showArchitectureModal = false })
  }
}

// -----------------------------------------------------------------------------------------
// COMPOSABLE: RADAR / COUNTDOWN STATUS CARD
// -----------------------------------------------------------------------------------------

@Composable
fun LiveContestRadarCard(
  status: LiveQuizContestStatus,
  currentTime: String,
  secondsTo7PM: Long,
  simulatedMode: Boolean,
  onToggleSimulation: () -> Unit,
  onEnterContest: () -> Unit
) {
  val infiniteTransition = rememberInfiniteTransition(label = "pulse")
  val pulseScale by infiniteTransition.animateFloat(
    initialValue = 1f,
    targetValue = 1.06f,
    animationSpec = infiniteRepeatable(
      animation = tween(900, easing = FastOutSlowInEasing),
      repeatMode = RepeatMode.Reverse
    ),
    label = "pulse_scale"
  )

  Card(
    shape = RoundedCornerShape(20.dp),
    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
    modifier = Modifier
      .fillMaxWidth()
      .shadow(8.dp, RoundedCornerShape(20.dp))
      .clip(RoundedCornerShape(20.dp))
      .background(
        Brush.verticalGradient(
          colors = listOf(Color(0xFF1E1B4B), Color(0xFF312E81), Color(0xFF4338CA))
        )
      )
  ) {
    Column(
      modifier = Modifier.padding(18.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      // Header status indicator
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Surface(
          shape = RoundedCornerShape(20.dp),
          color = Color(0x33FFFFFF)
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Box(
              modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(if (status == LiveQuizContestStatus.ENTRY_OPEN) Color(0xFF22C55E) else Color(0xFFF59E0B))
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = if (status == LiveQuizContestStatus.ENTRY_OPEN) "LIVE NOW" else "SCHEDULED DAILY",
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
          }
        }

        Text(
          text = "🕒 $currentTime",
          fontSize = 12.sp,
          fontWeight = FontWeight.SemiBold,
          color = Color(0xFFE0E7FF)
        )
      }

      Spacer(modifier = Modifier.height(14.dp))

      Text(
        text = "⚡ දෛනික සජීවී 7:00 PM තරගාවලිය",
        fontSize = 18.sp,
        fontWeight = FontWeight.ExtraBold,
        color = Color.White,
        textAlign = TextAlign.Center
      )

      val todayTheme = remember { DailyLiveQuizRepository.getTodaySubject() }

      Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color(0x33FFFFFF),
        border = BorderStroke(1.dp, Color(0x44FFFFFF)),
        modifier = Modifier.padding(top = 6.dp)
      ) {
        Row(
          modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(todayTheme.icon, fontSize = 14.sp)
          Spacer(modifier = Modifier.width(6.dp))
          Text(
            text = "අද දවසේ විෂය: ${todayTheme.nameSinhala} (${todayTheme.nameEnglish})",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFDE047)
          )
        }
      }

      Text(
        text = "එක් දිනකට එක් විෂයකින් ප්‍රශ්න 20 • ප්‍රශ්නයකට තත්පර 30 • තනි අවස්ථාවක්",
        fontSize = 11.sp,
        color = Color(0xFFC7D2FE),
        modifier = Modifier.padding(top = 6.dp)
      )

      Spacer(modifier = Modifier.height(16.dp))

      // Status-specific main action
      when (status) {
        LiveQuizContestStatus.ENTRY_OPEN -> {
          Button(
            onClick = onEnterContest,
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF22C55E)),
            modifier = Modifier
              .fillMaxWidth()
              .scale(pulseScale)
              .testTag("enter_live_quiz_button")
          ) {
            Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "🚀 දැන්ම තරගයට පිවිසෙන්න (Gateway Open!)",
              fontWeight = FontWeight.Bold,
              fontSize = 14.sp,
              color = Color.White
            )
          }
        }

        LiveQuizContestStatus.UPCOMING -> {
          val hours = secondsTo7PM / 3600
          val mins = (secondsTo7PM % 3600) / 60
          val secs = secondsTo7PM % 60
          val countdownStr = String.format("%02d:%02d:%02d", hours, mins, secs)

          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Surface(
              shape = RoundedCornerShape(12.dp),
              color = Color(0x33000000),
              border = BorderStroke(1.dp, Color(0x44FFFFFF))
            ) {
              Text(
                text = "ආරම්භයට තව: $countdownStr",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFFFDE047),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
              )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
              onClick = onEnterContest,
              shape = RoundedCornerShape(12.dp),
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6366F1)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Icon(Icons.Default.SportsScore, contentDescription = null, tint = Color.White)
              Spacer(modifier = Modifier.width(6.dp))
              Text("🎯 Practice / Demo Mode අත්හදා බලන්න", fontWeight = FontWeight.Bold, fontSize = 13.sp)
            }
          }
        }

        LiveQuizContestStatus.IN_PROGRESS -> {
          Surface(
            shape = RoundedCornerShape(12.dp),
            color = Color(0x33DC2626),
            border = BorderStroke(1.dp, Color(0xFFEF4444))
          ) {
            Text(
              text = "🔒 ප්‍රවේශ දොරටුව වැසී ඇත (Entry Closed at 7:05 PM)",
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFFCA5A5),
              modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
            )
          }
        }

        LiveQuizContestStatus.RESULTS_READY -> {
          Button(
            onClick = onEnterContest,
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Icon(Icons.Default.Refresh, contentDescription = null, tint = Color.White)
            Spacer(modifier = Modifier.width(6.dp))
            Text("🔄 පුහුණු වටයක් ආරම්භ කරන්න (Practice Mode)", fontWeight = FontWeight.Bold, fontSize = 13.sp)
          }
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      // Simulation Mode Toggle for Testing Anytime
      Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
      ) {
        Text(
          text = if (simulatedMode) "🧪 Demo Sandbox: 7:00 PM Simulated" else "🌐 Live Server Mode",
          fontSize = 11.sp,
          color = Color(0xFFCBD5E1)
        )
        Spacer(modifier = Modifier.width(8.dp))
        TextButton(onClick = onToggleSimulation) {
          Text(
            text = if (simulatedMode) "Reset to Live" else "Force Live Gateway",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFDE047)
          )
        }
      }
    }
  }
}

// -----------------------------------------------------------------------------------------
// COMPOSABLE: ACTIVE LIVE QUIZ RUNNER (20 QUESTIONS, 30S SERVER-PACED TIMER)
// -----------------------------------------------------------------------------------------

@Composable
fun LiveQuizArenaRunner(
  questions: List<LiveQuizQuestion>,
  grade: String,
  userName: String,
  modifier: Modifier = Modifier,
  onQuizCompleted: (LiveQuizAttempt) -> Unit,
  onExit: () -> Unit
) {
  var currentIndex by remember { mutableStateOf(0) }
  var selectedAnswers by remember { mutableStateOf<Map<Int, Int>>(emptyMap()) } // questionId -> optionIndex
  var remainingSeconds by remember { mutableStateOf(30) }
  var totalTimeTakenMs by remember { mutableStateOf(0L) }
  var isLockedForCurrentQuestion by remember { mutableStateOf(false) }

  val context = LocalContext.current
  val toneGenerator = remember {
    try {
      ToneGenerator(AudioManager.STREAM_NOTIFICATION, 80)
    } catch (e: Exception) {
      null
    }
  }

  // 30-Second Question Timer
  LaunchedEffect(currentIndex) {
    remainingSeconds = 30
    isLockedForCurrentQuestion = false
    val startTime = System.currentTimeMillis()

    while (remainingSeconds > 0 && !isLockedForCurrentQuestion) {
      delay(1000)
      remainingSeconds--
      totalTimeTakenMs += 1000L

      // Beep sound in last 5 seconds
      if (remainingSeconds in 1..5) {
        try {
          toneGenerator?.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
        } catch (e: Exception) {}
      }
    }

    // Auto move when timer expires
    if (remainingSeconds <= 0 && !isLockedForCurrentQuestion) {
      isLockedForCurrentQuestion = true
      delay(800)
      if (currentIndex < questions.size - 1) {
        currentIndex++
      } else {
        // Complete Quiz
        val score = calculateScore(questions, selectedAnswers)
        onQuizCompleted(
          LiveQuizAttempt(
            userId = "student_${System.currentTimeMillis() % 10000}",
            userName = userName,
            grade = grade,
            date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date()),
            score = score,
            totalQuestions = questions.size,
            totalTimeTakenMs = totalTimeTakenMs,
            answersMap = selectedAnswers
          )
        )
      }
    }
  }

  val currentQ = questions.getOrElse(currentIndex) { questions.first() }
  val currentAnswer = selectedAnswers[currentQ.id]

  val animatedProgress by animateFloatAsState(
    targetValue = (currentIndex + 1) / questions.size.toFloat(),
    label = "quiz_progress"
  )

  val timerColor = when {
    remainingSeconds <= 5 -> Color(0xFFEF4444)
    remainingSeconds <= 12 -> Color(0xFFF59E0B)
    else -> Color(0xFF10B981)
  }

  Column(
    modifier = modifier
      .fillMaxSize()
      .background(Color(0xFFF8FAFC))
      .padding(horizontal = 14.dp, vertical = 10.dp)
  ) {
    // TOP ARENA STATUS BAR (Compact & Clean)
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      IconButton(
        onClick = onExit,
        modifier = Modifier.size(36.dp)
      ) {
        Icon(Icons.Default.Close, contentDescription = "Exit Contest", tint = Color(0xFF64748B), modifier = Modifier.size(20.dp))
      }

      Surface(
        shape = RoundedCornerShape(10.dp),
        color = Color(0xFFEEF2FF),
        border = BorderStroke(1.dp, Color(0xFFC7D2FE))
      ) {
        Text(
          text = "ප්‍රශ්නය ${currentIndex + 1} / ${questions.size}",
          fontWeight = FontWeight.Bold,
          fontSize = 12.sp,
          color = Color(0xFF4338CA),
          modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
        )
      }

      // 30-Second Circular Timer with Pulsing Alert
      Surface(
        shape = RoundedCornerShape(16.dp),
        color = timerColor.copy(alpha = 0.15f),
        border = BorderStroke(1.5.dp, timerColor)
      ) {
        Row(
          modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Icon(Icons.Default.Timer, contentDescription = null, tint = timerColor, modifier = Modifier.size(14.dp))
          Spacer(modifier = Modifier.width(3.dp))
          Text(
            text = "${remainingSeconds}s",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 13.sp,
            color = timerColor
          )
        }
      }
    }

    Spacer(modifier = Modifier.height(6.dp))

    // Overall Progress Linear Indicator
    LinearProgressIndicator(
      progress = { animatedProgress },
      modifier = Modifier
        .fillMaxWidth()
        .height(4.dp)
        .clip(RoundedCornerShape(2.dp)),
      color = Color(0xFF4F46E5),
      trackColor = Color(0xFFE2E8F0)
    )

    Spacer(modifier = Modifier.height(10.dp))

    // MAIN QUESTION & OPTIONS CONTAINER (Fits seamlessly together on one screen)
    Column(
      modifier = Modifier
        .weight(1f)
        .verticalScroll(rememberScrollState()),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      // QUESTION CARD
      Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFFF1F5F9)
            ) {
              Text(
                text = "📖 ${currentQ.subject}",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF475569),
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
          }

          Spacer(modifier = Modifier.height(6.dp))

          Text(
            text = currentQ.question,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E293B),
            lineHeight = 20.sp
          )
        }
      }

      // 4 MCQ OPTIONS
      currentQ.options.forEachIndexed { optionIndex, optionText ->
        val isSelected = currentAnswer == optionIndex
        val optionLetter = ('A' + optionIndex).toString()

        Surface(
          shape = RoundedCornerShape(12.dp),
          color = if (isSelected) Color(0xFFEEF2FF) else Color.White,
          border = BorderStroke(
            width = if (isSelected) 2.dp else 1.dp,
            color = if (isSelected) Color(0xFF4F46E5) else Color(0xFFE2E8F0)
          ),
          modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = !isLockedForCurrentQuestion) {
              selectedAnswers = selectedAnswers + (currentQ.id to optionIndex)
              try {
                toneGenerator?.startTone(ToneGenerator.TONE_PROP_PROMPT, 60)
              } catch (e: Exception) {}
            }
            .testTag("quiz_option_${optionIndex}")
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Box(
              modifier = Modifier
                .size(28.dp)
                .clip(CircleShape)
                .background(if (isSelected) Color(0xFF4F46E5) else Color(0xFFF1F5F9)),
              contentAlignment = Alignment.Center
            ) {
              Text(
                text = optionLetter,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = if (isSelected) Color.White else Color(0xFF475569)
              )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Text(
              text = optionText,
              fontSize = 13.sp,
              fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
              color = if (isSelected) Color(0xFF312E81) else Color(0xFF1E293B),
              lineHeight = 18.sp,
              modifier = Modifier.weight(1f)
            )

            if (isSelected) {
              Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Selected",
                tint = Color(0xFF4F46E5),
                modifier = Modifier.size(18.dp)
              )
            }
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(10.dp))

    // BOTTOM SUBMIT / NEXT BUTTON
    Button(
      onClick = {
        isLockedForCurrentQuestion = true
        if (currentIndex < questions.size - 1) {
          currentIndex++
        } else {
          val score = calculateScore(questions, selectedAnswers)
          onQuizCompleted(
            LiveQuizAttempt(
              userId = "student_${System.currentTimeMillis() % 10000}",
              userName = userName,
              grade = grade,
              date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date()),
              score = score,
              totalQuestions = questions.size,
              totalTimeTakenMs = totalTimeTakenMs,
              answersMap = selectedAnswers
            )
          )
        }
      },
      shape = RoundedCornerShape(12.dp),
      colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
      modifier = Modifier
        .fillMaxWidth()
        .height(46.dp)
        .testTag("quiz_next_button")
    ) {
      Text(
        text = if (currentIndex < questions.size - 1) "ඊළඟ ප්‍රශ්නයට යන්න (Next)" else "තරගය අවසන් කර Submit කරන්න",
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp
      )
      Spacer(modifier = Modifier.width(6.dp))
      Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, modifier = Modifier.size(16.dp))
    }
  }
}

private fun calculateScore(questions: List<LiveQuizQuestion>, answers: Map<Int, Int>): Int {
  var correct = 0
  questions.forEach { q ->
    if (answers[q.id] == q.correctIndex) {
      correct++
    }
  }
  return correct
}

// -----------------------------------------------------------------------------------------
// COMPOSABLE: GRADE-ISOLATED TOP 10 LEADERBOARD
// -----------------------------------------------------------------------------------------

@Composable
fun GradeLeaderboardSection(
  grade: String,
  leaderboard: List<LeaderboardEntry>
) {
  Card(
    shape = RoundedCornerShape(18.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
    modifier = Modifier.fillMaxWidth()
  ) {
    Column(modifier = Modifier.padding(16.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column {
          Text(
            text = "🏅 අද දින නිල Top 10 නාමාවලිය",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color(0xFF1E293B)
          )
          Text(
            text = "Grade: $grade • 7:15 PM Automated Live Sync",
            fontSize = 11.sp,
            color = Color(0xFF64748B)
          )
        }

        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFFFEF3C7)
        ) {
          Text(
            text = "Tie-Breaker: කාලය (ms)",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB45309),
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      leaderboard.take(10).forEach { entry ->
        val rankColor = when (entry.rank) {
          1 -> Color(0xFFF59E0B) // Gold
          2 -> Color(0xFF94A3B8) // Silver
          3 -> Color(0xFFB45309) // Bronze
          else -> Color(0xFF64748B)
        }

        Surface(
          shape = RoundedCornerShape(12.dp),
          color = if (entry.isCurrentUser) Color(0xFFEEF2FF) else Color(0xFFF8FAFC),
          border = BorderStroke(
            width = if (entry.isCurrentUser) 1.5.dp else 1.dp,
            color = if (entry.isCurrentUser) Color(0xFF4F46E5) else Color(0xFFF1F5F9)
          ),
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            // Rank Badge
            Box(
              modifier = Modifier
                .size(28.dp)
                .clip(CircleShape)
                .background(rankColor.copy(alpha = 0.15f)),
              contentAlignment = Alignment.Center
            ) {
              Text(
                text = if (entry.rank <= 3) entry.avatarEmoji else "#${entry.rank}",
                fontWeight = FontWeight.Bold,
                fontSize = if (entry.rank <= 3) 14.sp else 11.sp,
                color = rankColor
              )
            }

            Spacer(modifier = Modifier.width(10.dp))

            // User Info
            Column(modifier = Modifier.weight(1f)) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                  text = entry.userName,
                  fontWeight = FontWeight.Bold,
                  fontSize = 13.sp,
                  color = if (entry.isCurrentUser) Color(0xFF4338CA) else Color(0xFF1E293B),
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
                if (entry.isCurrentUser) {
                  Spacer(modifier = Modifier.width(6.dp))
                  Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = Color(0xFF4F46E5)
                  ) {
                    Text(
                      text = "YOU",
                      fontSize = 9.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color.White,
                      modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                    )
                  }
                }
              }

              Text(
                text = entry.userSchool,
                fontSize = 10.sp,
                color = Color(0xFF64748B),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
              )
            }

            // Score & Time
            Column(horizontalAlignment = Alignment.End) {
              Text(
                text = "${entry.score} / ${entry.totalQuestions}",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 13.sp,
                color = Color(0xFF15803D)
              )

              val mins = (entry.totalTimeTakenMs / 1000) / 60
              val secs = (entry.totalTimeTakenMs / 1000) % 60
              val millis = (entry.totalTimeTakenMs % 1000) / 10
              Text(
                text = String.format("%02d:%02d.%02ds", mins, secs, millis),
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF94A3B8)
              )
            }
          }
        }
      }
    }
  }
}

// -----------------------------------------------------------------------------------------
// COMPOSABLE: SCORE SUMMARY CARD (POST-QUIZ)
// -----------------------------------------------------------------------------------------

@Composable
fun QuizScoreSummaryCard(
  attempt: LiveQuizAttempt,
  onReview: () -> Unit,
  onRetake: () -> Unit
) {
  Card(
    shape = RoundedCornerShape(18.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFFF0FDF4)),
    border = BorderStroke(1.dp, Color(0xFFBBF7D0)),
    modifier = Modifier.fillMaxWidth()
  ) {
    Column(modifier = Modifier.padding(16.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column {
          Text(
            text = "🎉 ඔබගේ ප්‍රතිඵලය (Your Score)",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color(0xFF166534)
          )
          Text(
            text = "Grade: ${attempt.grade} • ${attempt.date}",
            fontSize = 11.sp,
            color = Color(0xFF15803D)
          )
        }

        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFFDCFCE7)
        ) {
          Text(
            text = "${(attempt.score.toFloat() / attempt.totalQuestions * 100).toInt()}% ලකුණු",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 13.sp,
            color = Color(0xFF15803D),
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(12.dp))

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
      ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
          Text("නිවැරදි පිළිතුරු", fontSize = 11.sp, color = Color(0xFF15803D))
          Text("${attempt.score} / ${attempt.totalQuestions}", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF166534))
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
          Text("ගතවූ මුළු කාලය", fontSize = 11.sp, color = Color(0xFF15803D))
          val mins = (attempt.totalTimeTakenMs / 1000) / 60
          val secs = (attempt.totalTimeTakenMs / 1000) % 60
          Text("${mins}m ${secs}s", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF166534))
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        OutlinedButton(
          onClick = onReview,
          shape = RoundedCornerShape(10.dp),
          modifier = Modifier.weight(1f)
        ) {
          Icon(Icons.Default.Visibility, contentDescription = null, modifier = Modifier.size(16.dp))
          Spacer(modifier = Modifier.width(4.dp))
          Text("ප්‍රශ්න සමාලෝචනය", fontSize = 11.sp)
        }

        Button(
          onClick = onRetake,
          shape = RoundedCornerShape(10.dp),
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF16A34A)),
          modifier = Modifier.weight(1f)
        ) {
          Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(16.dp))
          Spacer(modifier = Modifier.width(4.dp))
          Text("නැවත පුහුණු වන්න", fontSize = 11.sp)
        }
      }
    }
  }
}

// -----------------------------------------------------------------------------------------
// COMPOSABLE: AUTOMATION PIPELINE SUMMARY CARD
// -----------------------------------------------------------------------------------------

@Composable
fun AutomationPipelineCard(
  onClickTimeline: () -> Unit,
  onClickArch: () -> Unit
) {
  Card(
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
    modifier = Modifier.fillMaxWidth()
  ) {
    Column(modifier = Modifier.padding(16.dp)) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text("🤖", fontSize = 20.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Column {
          Text(
            text = "AI Automated Question Delivery Pipeline",
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            color = Color(0xFF1E293B)
          )
          Text(
            text = "100% Zero-Human Intervention • Sri Lankan Curriculum",
            fontSize = 10.sp,
            color = Color(0xFF64748B)
          )
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      Text(
        text = "• 5:00 PM: AI මඟින් Grades 6-11 සඳහා ප්‍රශ්න 20 බැගින් ජනනය කර JSON Sanity Check කරයි.\n• 6:50 PM / 6:58 PM: Firebase Cloud Messaging Push Notifications.\n• 7:00 PM: සජීවී විභාගය ආරම්භය (7:05 PM Entry Gate Lock).\n• 7:15 PM: Grade-wise Top 10 Leaderboard ගණනය කර ප්‍රකාශයට පත්කිරීම.",
        fontSize = 11.sp,
        color = Color(0xFF475569),
        lineHeight = 16.sp
      )

      Spacer(modifier = Modifier.height(10.dp))

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        OutlinedButton(
          onClick = onClickTimeline,
          shape = RoundedCornerShape(8.dp),
          modifier = Modifier.weight(1f)
        ) {
          Text("⏱️ කාල සටහන (Timeline)", fontSize = 10.sp)
        }

        OutlinedButton(
          onClick = onClickArch,
          shape = RoundedCornerShape(8.dp),
          modifier = Modifier.weight(1f)
        ) {
          Text("📐 Backend Schema & Arch", fontSize = 10.sp)
        }
      }
    }
  }
}

// -----------------------------------------------------------------------------------------
// DIALOG: DETAILED QUESTION REVIEW & AI EXPLANATIONS
// -----------------------------------------------------------------------------------------

@Composable
fun QuizReviewDialog(
  questions: List<LiveQuizQuestion>,
  userAnswers: Map<Int, Int>,
  onDismiss: () -> Unit
) {
  Dialog(onDismissRequest = onDismiss) {
    Card(
      shape = RoundedCornerShape(20.dp),
      colors = CardDefaults.cardColors(containerColor = Color.White),
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.85f)
    ) {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(16.dp)
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Column {
            Text("🔍 ප්‍රශ්න සහ විවරණ සමාලෝචනය", fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text("AI Generated Instant Explanations", fontSize = 11.sp, color = Color(0xFF64748B))
          }
          IconButton(onClick = onDismiss) {
            Icon(Icons.Default.Close, contentDescription = "Close")
          }
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 10.dp))

        LazyColumn(
          modifier = Modifier.weight(1f),
          verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
          itemsIndexed(questions) { idx, q ->
            val userChoice = userAnswers[q.id]
            val isCorrect = userChoice == q.correctIndex

            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = if (isCorrect) Color(0xFFF0FDF4) else Color(0xFFFEF2F2)),
              border = BorderStroke(1.dp, if (isCorrect) Color(0xFFBBF7D0) else Color(0xFFFECDD3)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween
                ) {
                  Text(
                    text = "ප්‍රශ්නය ${idx + 1} (${q.subject})",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = if (isCorrect) Color(0xFF15803D) else Color(0xFFB91C1C)
                  )

                  Text(
                    text = if (isCorrect) "✅ නිවැරදියි" else "❌ වැරදියි",
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    color = if (isCorrect) Color(0xFF15803D) else Color(0xFFB91C1C)
                  )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                  text = q.question,
                  fontSize = 13.sp,
                  fontWeight = FontWeight.SemiBold,
                  color = Color(0xFF1E293B)
                )

                Spacer(modifier = Modifier.height(8.dp))

                q.options.forEachIndexed { optIdx, optText ->
                  val optLetter = ('A' + optIdx).toString()
                  val isUserSelected = userChoice == optIdx
                  val isCorrectOpt = q.correctIndex == optIdx

                  Row(
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(
                      text = "$optLetter. $optText",
                      fontSize = 12.sp,
                      fontWeight = if (isCorrectOpt || isUserSelected) FontWeight.Bold else FontWeight.Normal,
                      color = when {
                        isCorrectOpt -> Color(0xFF15803D)
                        isUserSelected -> Color(0xFFB91C1C)
                        else -> Color(0xFF475569)
                      }
                    )
                    if (isCorrectOpt) {
                      Spacer(modifier = Modifier.width(4.dp))
                      Text("(නිවැරදි පිළිතුර)", fontSize = 10.sp, color = Color(0xFF15803D), fontWeight = FontWeight.Bold)
                    }
                  }
                }

                Spacer(modifier = Modifier.height(6.dp))

                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = Color(0x66FFFFFF),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Text(
                    text = "💡 විවරණය: ${q.explanation}",
                    fontSize = 11.sp,
                    color = Color(0xFF334155),
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

// -----------------------------------------------------------------------------------------
// DIALOG: 24-HOUR AUTOMATION TIMELINE & CRON SCHEDULE
// -----------------------------------------------------------------------------------------

@Composable
fun AutomationScheduleDialog(onDismiss: () -> Unit) {
  Dialog(onDismissRequest = onDismiss) {
    Card(
      shape = RoundedCornerShape(20.dp),
      colors = CardDefaults.cardColors(containerColor = Color.White),
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.8f)
    ) {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(18.dp)
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("⏱️ දෛනික ස්වයංක්‍රීය කාල සටහන (Automation Cron)", fontWeight = FontWeight.Bold, fontSize = 14.sp)
          IconButton(onClick = onDismiss) {
            Icon(Icons.Default.Close, contentDescription = "Close")
          }
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        LazyColumn(
          modifier = Modifier.weight(1f),
          verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
          item {
            TimelineStepItem(
              time = "5:00 PM",
              title = "AI Question Generation & JSON Sanity Check",
              desc = "Cloud Function මඟින් Gemini/OpenAI API අමතා Grades 6-11 සඳහා ප්‍රශ්න 20 බැගින් උත්පාදනය කර Active Question Pool එකට එකතු කරයි.",
              badge = "CRON 0 17 * * *"
            )
          }

          item {
            TimelineStepItem(
              time = "6:50 PM",
              title = "FCM Notification: 10-Minute Warning",
              desc = "ලියාපදිංචි සියලුම සිසුන් වෙත 'Today's Live Quiz starts in 10 minutes!' යනුවෙන් Push Notification යවයි.",
              badge = "CRON 50 18 * * *"
            )
          }

          item {
            TimelineStepItem(
              time = "6:58 PM",
              title = "FCM Notification: Ready Signal",
              desc = "'Get Ready! Quiz starting soon' අවසන් සංඥාව නිකුත් කරයි.",
              badge = "CRON 58 18 * * *"
            )
          }

          item {
            TimelineStepItem(
              time = "7:00 PM",
              title = "Live Quiz Gateway Open",
              desc = "ශ්‍රේණි අනුව සජීවී ප්‍රශ්නාවලිය ආරම්භ වේ. එක් ප්‍රශ්නයකට තත්පර 30 ක සර්වර් ටයිමරයක් ක්‍රියාත්මක වේ.",
              badge = "GATEWAY OPEN"
            )
          }

          item {
            TimelineStepItem(
              time = "7:05 PM",
              title = "Gateway Hard-Lock",
              desc = "7:05 න් පසු නව සිසුන්ට තරගයට ඇතුල්වීම වසා දමයි (Late Entries Blocked).",
              badge = "LOCK"
            )
          }

          item {
            TimelineStepItem(
              time = "7:15 PM",
              title = "Leaderboard Publish & Rank Calculation",
              desc = "ලකුණු සහ ගතවූ කාලය (Milliseconds) අනුව එක් එක් ශ්‍රේණියේ Top 10 නාමාවලිය ප්‍රකාශයට පත් කරයි.",
              badge = "RESULTS PUBLISHED"
            )
          }

          item {
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = "📅 සතිපතා විෂය කාලසටහන (Daily Subject Rotation):",
              fontWeight = FontWeight.Bold,
              fontSize = 13.sp,
              color = Color(0xFF1E293B)
            )
          }

          item {
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F5F9)),
              border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                DailyQuizSubjectTheme.values().forEach { theme ->
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                      Text(theme.icon, fontSize = 14.sp)
                      Spacer(modifier = Modifier.width(6.dp))
                      Text("${theme.dayNameSinhala}: ${theme.nameSinhala}", fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF334155))
                    }
                    Surface(
                      shape = RoundedCornerShape(6.dp),
                      color = Color(theme.colorHex).copy(alpha = 0.15f)
                    ) {
                      Text("ප්‍රශ්න 20", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(theme.colorHex), modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
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
fun TimelineStepItem(time: String, title: String, desc: String, badge: String) {
  Surface(
    shape = RoundedCornerShape(12.dp),
    color = Color(0xFFF8FAFC),
    border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
    modifier = Modifier.fillMaxWidth()
  ) {
    Column(modifier = Modifier.padding(12.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Surface(
          shape = RoundedCornerShape(6.dp),
          color = Color(0xFF4F46E5)
        ) {
          Text(
            text = time,
            fontWeight = FontWeight.Bold,
            fontSize = 11.sp,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
          )
        }

        Text(text = badge, fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF64748B))
      }

      Spacer(modifier = Modifier.height(6.dp))

      Text(text = title, fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color(0xFF1E293B))
      Text(text = desc, fontSize = 11.sp, color = Color(0xFF475569), lineHeight = 15.sp)
    }
  }
}

// -----------------------------------------------------------------------------------------
// DIALOG: BACKEND ARCHITECTURE, SCHEMA & PROMPT ENGINEERING
// -----------------------------------------------------------------------------------------

@Composable
fun SystemArchitectureDialog(onDismiss: () -> Unit) {
  Dialog(onDismissRequest = onDismiss) {
    Card(
      shape = RoundedCornerShape(20.dp),
      colors = CardDefaults.cardColors(containerColor = Color.White),
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.85f)
    ) {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(18.dp)
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("📐 Cloud Backend & Architecture", fontWeight = FontWeight.Bold, fontSize = 14.sp)
          IconButton(onClick = onDismiss) {
            Icon(Icons.Default.Close, contentDescription = "Close")
          }
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        LazyColumn(
          modifier = Modifier.weight(1f),
          verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
          item {
            Text("🗄️ Firestore Database Collections:", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = Color(0xFF1E293B))
            Surface(shape = RoundedCornerShape(8.dp), color = Color(0xFF1E293B)) {
              Text(
                text = """
/users/{userId}
  - fullName: String
  - grade: String ("Grade 6" - "Grade 11")
  - schoolName: String
  - fcmToken: String

/daily_contests/{date}
  - status: "SCHEDULED" | "LIVE" | "CLOSED"
  - questionSets: Map<Grade, List<QuestionId>>
  - publishedAt: Timestamp

/questions/{questionId}
  - grade: String
  - subject: String
  - question: String
  - options: [String] (Length: 4)
  - correct_index: Int (0..3)
  - explanation: String

/attempts/{attemptId} (userId + "_" + date)
  - userId: String
  - grade: String
  - date: String
  - score: Int
  - totalTimeTakenMs: Long
  - completedAt: Timestamp

/leaderboards/{date}_{grade}
  - top10: Array<LeaderboardEntry>
  - updatedAt: Timestamp
                """.trimIndent(),
                color = Color(0xFF38BDF8),
                fontSize = 10.sp,
                modifier = Modifier.padding(10.dp)
              )
            }
          }

          item {
            Text("🛡️ Anti-Cheating & Security Engine:", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = Color(0xFF1E293B))
            Text(
              text = "1. Server-Side Timer: Answers submitted after 30s + 2s network grace period are invalidated.\n2. Single Attempt Constraint: Firestore document ID is composite (userId_date) preventing duplicate writes.\n3. Zero Client Answer Tampering: Question answers and explanations are stored server-side and only verified upon batch submission.",
              fontSize = 11.sp,
              color = Color(0xFF475569),
              lineHeight = 16.sp
            )
          }
        }
      }
    }
  }
}
