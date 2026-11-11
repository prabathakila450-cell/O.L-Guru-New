package com.example

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import kotlinx.coroutines.launch
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.ui.theme.*

// ==============================================================================
// FEATURE 2: DETAILED ANALYTICS & WEAK AREA DIAGNOSTIC (ප්‍රගති විශ්ලේෂණය)
// ==============================================================================

data class SubjectPerformance(
  val subjectName: String,
  val grade: String,
  val testsTaken: Int,
  val averageScore: Int, // Percentage 0-100
  val accuracyRate: Float,
  val weakTopics: List<String>,
  val strongTopics: List<String>,
  val recommendation: String,
  val color: Color
)

object AnalyticsRepository {
  fun getSubjectPerformances(grade: String): List<SubjectPerformance> {
    return listOf(
      SubjectPerformance(
        subjectName = "විද්‍යාව",
        grade = grade,
        testsTaken = 14,
        averageScore = 78,
        accuracyRate = 0.78f,
        weakTopics = listOf("ප්‍රකාශ සංශ්ලේෂණයේ ආලෝක ප්‍රතික්‍රියාව", "න්‍යෂ්ටික විකිරණ හා අර්ධ ආයු කාලය", "ද්‍රාව්‍යතාව හා සංශුද්ධතාව"),
        strongTopics = listOf("නිව්ටන්ගේ නියම", "ඕම්ගේ නියමය", "සෛල ව්‍යුහය"),
        recommendation = "ජෛව රසායන හා ශක්ති පරිවර්තන පාඩම්වල කෙටි සටහන් නැවත කියවා Flashcards පුහුණු වන්න.",
        color = Color(0xFF1B5E20)
      ),
      SubjectPerformance(
        subjectName = "ගණිතය",
        grade = grade,
        testsTaken = 18,
        averageScore = 84,
        accuracyRate = 0.84f,
        weakTopics = listOf("ත්‍රිකෝණමිතිය උන්නතාංශ හා අවනතාංශ", "වර්ගජ සමීකරණ සූත්‍රය භාවිතය"),
        strongTopics = listOf("පයිතගරස් ප්‍රමේයය", "වර්ගඵල හා පරිමාව", "සමාන්තර ශ්‍රේඪි"),
        recommendation = "ත්‍රිකෝණමිතික අනුපාත සූත්‍ර පත්‍රිකාව නිතර බලා ගැටලු පියවරෙන් පියවර විසඳන්න.",
        color = Color(0xFF0D47A1)
      ),
      SubjectPerformance(
        subjectName = "ඉතිහාසය",
        grade = grade,
        testsTaken = 10,
        averageScore = 91,
        accuracyRate = 0.91f,
        weakTopics = listOf("යටත්විජිත යුගයේ ව්‍යවස්ථා ප්‍රතිසංස්කරණ (1833-1948)"),
        strongTopics = listOf("අනුරාධපුර වාරි ශිෂ්ටාචාරය", "මහසෙන් & පරාක්‍රමබාහු රජවරු", "සීගිරි නිර්මාණ"),
        recommendation = "ඉතිහාස කාලරේඛාව (Historical Timeline) භාවිතයෙන් වර්ෂ සහ ගිවිසුම් මතක තබාගන්න.",
        color = Color(0xFF6A1B9A)
      ),
      SubjectPerformance(
        subjectName = "තොරතුරු තාක්ෂණය (ICT)",
        grade = grade,
        testsTaken = 8,
        averageScore = 88,
        accuracyRate = 0.88f,
        weakTopics = listOf("බූලීය වීජ ගණිතයේ Karnaugh Maps සරල කිරීම්"),
        strongTopics = listOf("Logic Gates", "Binary සංඛ්‍යා පරිවර්තන", "CPU ව්‍යුහය"),
        recommendation = "Logic Gates සත්‍යතා වගු හා සූත්‍ර චාට් එක භාවිතයෙන් අභ්‍යාස කරන්න.",
        color = Color(0xFF00695C)
      ),
      SubjectPerformance(
        subjectName = "බුද්ධ ධර්මය",
        grade = grade,
        testsTaken = 6,
        averageScore = 95,
        accuracyRate = 0.95f,
        weakTopics = listOf("පටිච්චසමුප්පාද ධර්මයේ අංග 12 අනුපිළිවෙළ"),
        strongTopics = listOf("චතුරාර්ය සත්‍යය", "ආර්ය අෂ්ටාංගික මාර්ගය", "ශාසන ඉතිහාසය"),
        recommendation = "විශිෂ්ට සාමාර්ථයක් (A) සඳහා සූත්‍ර විග්‍රහ කෙටි සටහන් කියවන්න.",
        color = Color(0xFFB06000)
      )
    )
  }
}

// ==============================================================================
// 100% RELEVANT TARGETED TOPIC INTELLIGENCE (ZERO IRRELEVANT NOTES / FORMULAS)
// ==============================================================================

data class TargetedPracticeQuestion(
  val id: String,
  val question: String,
  val options: List<String>,
  val correctOptionIndex: Int,
  val explanation: String
)

data class TargetedWeakTopicInfo(
  val subjectName: String,
  val topicName: String,
  val keyword: String,
  val formulaCategory: String, // "MATH", "SCIENCE", "TIMELINE", "ICT", "ALL"
  val formulaSearchQuery: String,
  val keyFormulas: List<Pair<String, String>>,
  val coreTheoryNotes: List<String>,
  val examPitfalls: List<String>,
  val targetedQuestions: List<TargetedPracticeQuestion> = emptyList()
)

object TargetedWeakTopicRepository {
  fun getTopicInfo(subjectName: String, topicName: String): TargetedWeakTopicInfo {
    return when {
      topicName.contains("ත්‍රිකෝණමිතිය") || topicName.contains("උන්නතාංශ") -> TargetedWeakTopicInfo(
        subjectName = "ගණිතය",
        topicName = "ත්‍රිකෝණමිතිය උන්නතාංශ හා අවනතාංශ",
        keyword = "ත්‍රිකෝණමිතිය",
        formulaCategory = "MATH",
        formulaSearchQuery = "ත්‍රිකෝණමිතිය",
        keyFormulas = listOf(
          "Sin θ (සයින් අනුපාතය)" to "සම්මුඛ පාදය / කර්ණය",
          "Cos θ (කොසයින් අනුපාතය)" to "බද්ධ පාදය / කර්ණය",
          "Tan θ (ටැංජන අනුපාතය)" to "සම්මුඛ පාදය / බද්ධ පාදය",
          "සම්මත කෝණ" to "Sin 30° = 1/2, Cos 60° = 1/2, Tan 45° = 1, Tan 60° = √3"
        ),
        coreTheoryNotes = listOf(
          "උන්නතාංශ කෝණය (Angle of Elevation): නිරීක්ෂකයාගේ තිරස් දෘෂ්ටි රේඛාවට ඉහළින් පිහිටි වස්තුවක් දෙස බැලීමේදී තිරස් රේඛාව හා දෘෂ්ටි රේඛාව අතර කෝණයයි.",
          "අවනතාංශ/අවපාතන කෝණය (Angle of Depression): තිරස් දෘෂ්ටි රේඛාවට පහළින් පිහිටි වස්තුවක් දෙස බැලීමේදී සෑදෙන කෝණයයි.",
          "ඒකාන්තර කෝණ ප්‍රමේයය: නිරීක්ෂකයාගේ අවපාතන කෝණය = භූමියේ ඇති වස්තුවේ සිට නිරීක්ෂකයා දෙසට ඇති උන්නතාංශ කෝණය (තිරස් රේඛා සමාන්තර බැවින්)."
        ),
        examPitfalls = listOf(
          "ප්‍රධාන වරද: තිරස් රේඛාව වෙනුවට සිරස් රේඛාව (කණුව/ගස) සමඟ කෝණය ලකුණු කිරීම. කෝණය සැමවිටම තිරසට ලකුණු කරන්න!",
          "මිනිසාගේ උස (උදා: 1.5 m) ගණනයට ඇතුළත් කිරීමට අමතක වීම. අවසානයේ මිනිසාගේ උස ගොඩනැගිල්ලේ හෝ කණුවේ උසට එකතු කළ යුතුය."
        ),
        targetedQuestions = listOf(
          TargetedPracticeQuestion(
            id = "tp_trig_1",
            question = "තිරස් පොළොව මත සිට මීටර් 20ක් උස සිරස් කණුවක මුදුන දෙස බලන විට උන්නතාංශ කෝණය 45° කි. නිරීක්ෂකයා සහ කණුව අතර දුර කොපමණද? (Tan 45° = 1)",
            options = listOf("10 m", "20 m", "40 m", "20√3 m"),
            correctOptionIndex = 1,
            explanation = "Tan 45° = සම්මුඛ පාදය / බද්ධ පාදය ⇒ 1 = 20 / දුර ⇒ දුර = 20 m වේ."
          ),
          TargetedPracticeQuestion(
            id = "tp_trig_2",
            question = "ප්‍රදීපාගාරයක් මුදුනේ සිට මුහුදේ ඇති බෝට්ටුවක් දෙස බලන විට අවපාතන කෝණය 30° කි. බෝට්ටුවේ සිට ප්‍රදීපාගාර මුදුන දෙස බලන විට උන්නතාංශ කෝණය වන්නේ:",
            options = listOf("60°", "45°", "30°", "90°"),
            correctOptionIndex = 2,
            explanation = "තිරස් රේඛා සමාන්තර බැවින් ඒකාන්තර කෝණ සමාන වේ. එබැවින් උන්නතාංශ කෝණයද 30° කි."
          )
        )
      )

      topicName.contains("වර්ගජ") -> TargetedWeakTopicInfo(
        subjectName = "ගණිතය",
        topicName = "වර්ගජ සමීකරණ සූත්‍රය භාවිතය",
        keyword = "වීජ ගණිතය",
        formulaCategory = "MATH",
        formulaSearchQuery = "වර්ගජ",
        keyFormulas = listOf(
          "වර්ගජ සූත්‍රය" to "x = [-b ± √(b² - 4ac)] / (2a)",
          "විවේචකය (Δ)" to "Δ = b² - 4ac",
          "මූලවල ස්වභාවය" to "Δ > 0: අසමාන තාත්වික මූල 2කි | Δ = 0: සමාන මූල 2කි | Δ < 0: තාත්වික මූල නැත"
        ),
        coreTheoryNotes = listOf(
          "සාධක වෙන් කළ නොහැකි වර්ගජ සමීකරණ විසඳීමට වර්ගජ සූත්‍රය භාවිත වේ.",
          "ඕනෑම වර්ගජ සමීකරණයක් විසඳීමට පෙර ax² + bx + c = 0 සම්මත ආකාරයට ලියා a, b, c නිවැරදිව හඳුනාගත යුතුය.",
          "විවේචකයේ අගය (b² - 4ac) වෙනම සුළු කර වර්ගමූලය ලබාගැනීමෙන් වැරදීම් අවම වේ."
        ),
        examPitfalls = listOf(
          "b හි ලකුණ සෘණ වන විට (-b) ධන බවට පත්වන බව අමතක කිරීම (උදා: b = -5 නම් -b = -(-5) = +5).",
          "මුළු ප්‍රකාශනයම 2a න් බෙදීම වෙනුවට වර්ගමූල කොටස පමණක් බෙදීම."
        ),
        targetedQuestions = listOf(
          TargetedPracticeQuestion(
            id = "tp_quad_1",
            question = "x² - 5x + 6 = 0 සමීකරණයේ a, b, c හි අගයන් පිළිවෙළින්:",
            options = listOf("a = 1, b = 5, c = 6", "a = 1, b = -5, c = 6", "a = 0, b = -5, c = 6", "a = 1, b = -5, c = -6"),
            correctOptionIndex = 1,
            explanation = "ax² + bx + c = 0 සමඟ සැසඳූ විට a = 1, b = -5, c = 6 වේ."
          )
        )
      )

      topicName.contains("ප්‍රකාශ සංශ්ලේෂණ") || topicName.contains("ආලෝක ප්‍රතික්‍රියා") -> TargetedWeakTopicInfo(
        subjectName = "විද්‍යාව",
        topicName = "ප්‍රකාශ සංශ්ලේෂණයේ ආලෝක ප්‍රතික්‍රියාව",
        keyword = "විද්‍යාව",
        formulaCategory = "SCIENCE",
        formulaSearchQuery = "ප්‍රකාශ සංශ්ලේෂණ",
        keyFormulas = listOf(
          "ආලෝක ප්‍රතික්‍රියාව (තයිලකොයිඩ තුළ)" to "2H₂O + ආලෝකය/හරිතලව → 4H⁺ + 4e⁻ + O₂ + ATP + NADPH",
          "අඳුරු ප්‍රතික්‍රියාව (ස්ට්‍රෝමාව තුළ)" to "CO₂ + ATP + NADPH → C₆H₁₂O₆ (ග්ලූකෝස්)",
          "සමස්ත සමීකරණය" to "6CO₂ + 6H₂O  --[සූර්යාලෝකය/හරිතලව]-->  C₆H₁₂O₆ + 6O₂"
        ),
        coreTheoryNotes = listOf(
          "ආලෝක ප්‍රතික්‍රියාව සිදුවන්නේ හරිතලවයේ තයිලකොයිඩ පටල (ග්‍රැනා) තුළ ආලෝකය හමුවේ පමණි.",
          "ජල අණුව ප්‍රකාශ විච්ඡේදනයට ලක්වීමෙන් O₂ වායුව නිදහස් වේ. මෙහිදී ඉලෙක්ට්‍රෝන හා ප්‍රෝටෝන නිදහස් වේ.",
          "අඳුරු ප්‍රතික්‍රියාව සඳහා අවශ්‍ය වන ATP සහ NADPH රසායනික ශක්ති ප්‍රභව නිපදවනු ලබන්නේ ආලෝක ප්‍රතික්‍රියාව මඟිනි."
        ),
        examPitfalls = listOf(
          "ප්‍රභාසංශ්ලේෂණයේදී පිටවන O₂ වායුව ලැබෙන්නේ කාබන් ඩයොක්සයිඩ් (CO₂) වලින් නොව ජලයෙන් (H₂O) බව මතක තබාගන්න.",
          "ආලෝක ප්‍රතික්‍රියාව තයිලකොයිඩ වලත්, අඳුරු ප්‍රතික්‍රියාව ස්ට්‍රෝමාවේත් සිදුවන බව පැටලවීම."
        ),
        targetedQuestions = listOf(
          TargetedPracticeQuestion(
            id = "tp_photo_1",
            question = "ප්‍රකාශ සංශ්ලේෂණයේ ආලෝක ප්‍රතික්‍රියාවේදී ජල අණු ප්‍රකාශ විච්ඡේදනයෙන් පිටවන වායුව කුමක්ද?",
            options = listOf("කාබන් ඩයොක්සයිඩ් (CO₂)", "ඔක්සිජන් (O₂)", "හයිඩ්‍රජන් (H₂)", "නයිට්‍රජන් (N₂)"),
            correctOptionIndex = 1,
            explanation = "2H₂O → 4H⁺ + 4e⁻ + O₂ ප්‍රතික්‍රියාව මඟින් ඔක්සිජන් වායුව පිටවේ."
          )
        )
      )

      topicName.contains("න්‍යෂ්ටික") || topicName.contains("අර්ධ ආයු") -> TargetedWeakTopicInfo(
        subjectName = "විද්‍යාව",
        topicName = "න්‍යෂ්ටික විකිරණ හා අර්ධ ආයු කාලය",
        keyword = "භෞතික විද්‍යාව",
        formulaCategory = "SCIENCE",
        formulaSearchQuery = "න්‍යෂ්ටික",
        keyFormulas = listOf(
          "අර්ධ ආයු සමීකරණය" to "N = N₀ × (1/2)ⁿ   [n = ගතවූ කාලය / අර්ධ ආයු කාලය]",
          "ඇල්ෆා (α) ක්ෂයවීම" to "⁴₂He (ස්කන්ධ ක්‍රමාංකය 4කින්ද පරමාණුක ක්‍රමාංකය 2කින්ද අඩුවේ)",
          "බීටා (β) ක්ෂයවීම" to "⁰₋₁e (ස්කන්ධ ක්‍රමාංකය වෙනස් නොවේ, පරමාණුක ක්‍රමාංකය 1කින් වැඩිවේ)",
          "ගැමා (γ) විකිරණ" to "විද්‍යුත් චුම්භක තරංග (ස්කන්ධය හෝ ආරෝපණය වෙනස් නොවේ)"
        ),
        coreTheoryNotes = listOf(
          "විකිරණශීලී සමස්ථානිකයක මුල් න්‍යෂ්ටි සංඛ්‍යාවෙන් අඩක් ක්ෂය වීමට ගතවන කාලය අර්ධ ආයු කාලයයි.",
          "අර්ධ ආයු කාලය බාහිර උෂ්ණත්වය, පීඩනය හෝ රසායනික තත්ත්ව මත වෙනස් නොවේ.",
          "විනිවිදීමේ හැකියාව: γ > β > α. අයනීකාරක හැකියාව: α > β > γ."
        ),
        examPitfalls = listOf(
          "අර්ධ ආයු කාල 3ක් ගතවූ පසු ඉතිරි වන්නේ 1/6ක් නොව (1/2)³ = 1/8ක් බව මතක තබාගන්න.",
          "α විකිරණ යනු හීලියම් න්‍යෂ්ටි (⁴₂He) වන අතර β යනු ඉහළ වේගයෙන් චලනය වන ඉලෙක්ට්‍රෝන (⁰₋₁e) වේ."
        ),
        targetedQuestions = listOf(
          TargetedPracticeQuestion(
            id = "tp_nuc_1",
            question = "විකිරණශීලී මූලද්‍රව්‍යයක අර්ධ ආයු කාලය දින 5කි. ආරම්භක ස්කන්ධය 80g නම්, දින 15කට පසු ඉතිරිවන ස්කන්ධය කොපමණද?",
            options = listOf("40 g", "20 g", "10 g", "5 g"),
            correctOptionIndex = 2,
            explanation = "දින 15 තුළ අර්ධ ආයු කාල 3කි. 80g → 40g (දින 5) → 20g (දින 10) → 10g (දින 15) ඉතිරි වේ."
          )
        )
      )

      topicName.contains("ද්‍රාව්‍යතාව") || topicName.contains("සංශුද්ධ") -> TargetedWeakTopicInfo(
        subjectName = "විද්‍යාව",
        topicName = "ද්‍රාව්‍යතාව හා සංශුද්ධතාව",
        keyword = "රසායන විද්‍යාව",
        formulaCategory = "SCIENCE",
        formulaSearchQuery = "ද්‍රාව්‍යතාව",
        keyFormulas = listOf(
          "ද්‍රාව්‍යතාව සූත්‍රය" to "[ද්‍රාව්‍යයේ ස්කන්ධය (g) / ජලයේ ස්කන්ධය (g)] × 100 g",
          "සංශුද්ධතා ප්‍රතිශතය" to "[ශුද්ධ ද්‍රව්‍ය ස්කන්ධය / අශුද්ධ සාම්පලයේ මුළු ස්කන්ධය] × 100%"
        ),
        coreTheoryNotes = listOf(
          "නියත උෂ්ණත්වයකදී ජලය (ද්‍රාවකය) 100 g ක උපරිමව දියවිය හැකි ද්‍රාව්‍ය ස්කන්ධය ද්‍රාව්‍යතාවයි.",
          "බොහෝ ඝන ද්‍රව්‍යවල උෂ්ණත්වය ඉහළ යත්ම ද්‍රාව්‍යතාව වැඩිවේ.",
          "වායුමය ද්‍රාව්‍යවල උෂ්ණත්වය වැඩිවත්ම ද්‍රාව්‍යතාව අඩුවේ (උදා: ජලය රත්කිරීමේදී වායු බුබුළු පිටවීම)."
        ),
        examPitfalls = listOf(
          "ද්‍රාවකයේ (ජලයේ) ස්කන්ධය වෙනුවට මුළු ද්‍රාවණයේ ස්කන්ධයෙන් බෙදීම බහුලම වැරැද්දයි. සැමවිටම ජලයේ ස්කන්ධයෙන් බෙදන්න!"
        ),
        targetedQuestions = listOf(
          TargetedPracticeQuestion(
            id = "tp_sol_1",
            question = "30°C දී ජලය 50 g ක උපරිමව ලුණු 18 g ක් දියකළ හැකිය. 30°C දී ලුණුවල ද්‍රාව්‍යතාව වන්නේ:",
            options = listOf("18 g / 100 g ජලය", "36 g / 100 g ජලය", "50 g / 100 g ජලය", "72 g / 100 g ජලය"),
            correctOptionIndex = 1,
            explanation = "ද්‍රාව්‍යතාව = (18 g / 50 g) × 100 g = 36 g වේ."
          )
        )
      )

      topicName.contains("ව්‍යවස්ථා") || topicName.contains("යටත්විජිත") -> TargetedWeakTopicInfo(
        subjectName = "ඉතිහාසය",
        topicName = "යටත්විජිත යුගයේ ව්‍යවස්ථා ප්‍රතිසංස්කරණ (1833-1948)",
        keyword = "ඉතිහාසය",
        formulaCategory = "TIMELINE",
        formulaSearchQuery = "ව්‍යවස්ථා",
        keyFormulas = listOf(
          "1833 කෝල්බෲක්" to "ව්‍යවස්ථාදායක සභාව (නිලලත් 9, නිලනොලත් 6)",
          "1910 කෲව්-මැකලම්" to "උගත් ලාංකික ඡන්ද කොට්ඨාසය (පළමු සීමිත ඡන්දය)",
          "1931 ඩොනමෝර්" to "සර්වජන ඡන්ද බලය (වයස 21+), රාජ්‍ය මන්ත්‍රණ සභාව, කාරක සභා ක්‍රමය",
          "1947 සෝල්බරි" to "පාර්ලිමේන්තු ක්‍රමය (නියෝජිත මන්ත්‍රී මණ්ඩලය 101, සෙනෙට් සභාව 30)"
        ),
        coreTheoryNotes = listOf(
          "1833 කෝල්බෲක් ආණ්ඩුක්‍රමයෙන් මුළු දිවයිනම එකම පරිපාලනයකට නතු කර පළාත් 5කට බෙදන ලදී.",
          "1931 ඩොනමෝර් ආණ්ඩුක්‍රමයෙන් ආසියාවේ ප්‍රථම වතාවට වයස 21ට වැඩි කාන්තා පිරිමි සැමට සර්වජන ඡන්ද බලය හිමිවිය.",
          "1947 සෝල්බරි ව්‍යවස්ථාව යටතේ 1948 පෙබරවාරි 4 දින ශ්‍රී ලංකාවට ඩොමීනියන් නිදහස ලැබුණි."
        ),
        examPitfalls = listOf(
          "ඩොනමෝර් ව්‍යවස්ථාවේ ලක්ෂණයක් වූ 'විධායක කාරක සභා ක්‍රමය' සහ සෝල්බරි ව්‍යවස්ථාවේ 'කැබිනට් මණ්ඩලය' පටලවා ගැනීම."
        ),
        targetedQuestions = listOf(
          TargetedPracticeQuestion(
            id = "tp_hist_1",
            question = "ශ්‍රී ලංකාවට සර්වජන ඡන්ද බලය (Universal Suffrage) හඳුන්වා දුන් ආණ්ඩුක්‍රමය කුමක්ද?",
            options = listOf("කෝල්බෲක්-කැමරන් (1833)", "මැනිං ප්‍රතිසංස්කරණ (1920)", "ඩොනමෝර් ආණ්ඩුක්‍රමය (1931)", "සෝල්බරි ආණ්ඩුක්‍රමය (1947)"),
            correctOptionIndex = 2,
            explanation = "1931 ඩොනමෝර් කොමිසමේ නිර්දේශ මත වයස 21ට වැඩි සැමට සර්වජන ඡන්ද බලය ලැබුණි."
          )
        )
      )

      topicName.contains("බූලීය") || topicName.contains("Karnaugh") -> TargetedWeakTopicInfo(
        subjectName = "තොරතුරු තාක්ෂණය (ICT)",
        topicName = "බූලීය වීජ ගණිතයේ Karnaugh Maps සරල කිරීම්",
        keyword = "තොරතුරු තාක්ෂණය",
        formulaCategory = "ICT",
        formulaSearchQuery = "බූලීය",
        keyFormulas = listOf(
          "ඩිමෝගන්ගේ නියම" to "(A · B)' = A' + B'   සහ   (A + B)' = A' · B'",
          "අනන්‍යතා නියම" to "A + 0 = A,  A · 1 = A,  A + 1 = 1,  A · 0 = 0",
          "K-Map නීතිය" to "කාණ්ඩ ප්‍රමාණය 2ⁿ විය යුතුය (1, 2, 4, 8) - විකර්ණ නොවේ"
        ),
        coreTheoryNotes = listOf(
          "K-Map (කානෝ සිතියම්) මඟින් සත්‍යතා වගුවකින් ලබාගන්නා බූලීය ප්‍රකාශන අවම තර්ක ද්වාර සහිතව සරල කරයි.",
          "අසල්වැසි '1' අගයන් 2, 4 හෝ 8 බැගින් සෘජුකෝණාස්‍රාකාරව කාණ්ඩ කළ යුතුය.",
          "කාණ්ඩය විශාල වන තරමට ප්‍රතිඵල ප්‍රකාශනයෙන් ඉවත්වන විචල්‍ය ගණන වැඩිවේ."
        ),
        examPitfalls = listOf(
          "කොටු 3ක් හෝ 6ක් කාණ්ඩ කිරීම නොකළ යුතුය. කාණ්ඩය සැමවිටම 2ⁿ (1, 2, 4, 8) විය යුතුය."
        ),
        targetedQuestions = listOf(
          TargetedPracticeQuestion(
            id = "tp_ict_1",
            question = "ඩිමෝගන්ගේ නියමය අනුව (A + B)' ට සමාන වන්නේ:",
            options = listOf("A' + B'", "A' · B'", "(A · B)'", "A · B"),
            correctOptionIndex = 1,
            explanation = "ඩිමෝගන්ගේ නියමයට අනුව සංකලනයක ප්‍රතිලෝමය ගුණිතයේ ප්‍රතිලෝමවලට සමාන වේ: (A + B)' = A' · B'."
          )
        )
      )

      topicName.contains("පටිච්චසමුප්පාද") -> TargetedWeakTopicInfo(
        subjectName = "බුද්ධ ධර්මය",
        topicName = "පටිච්චසමුප්පාද ධර්මයේ අංග 12 අනුපිළිවෙළ",
        keyword = "බුද්ධ ධර්මය",
        formulaCategory = "ALL",
        formulaSearchQuery = "පටිච්චසමුප්පාද",
        keyFormulas = listOf(
          "අනුලෝම දේශනාව" to "අවිද්‍යා → සංඛාර → විඤ්ඤාණ → නාමරූප → සළායතන → ඵස්ස → වේදනා → තණ්හා → උපාදාන → භව → ජාති → ජරා මරණ",
          "පටිලෝම දේශනාව" to "අවිද්‍යා නිරෝධා සංඛාර නිරෝධෝ... (නිවන සාක්ෂාත් කිරීම)"
        ),
        coreTheoryNotes = listOf(
          "පටිච්චසමුප්පාද දේශනාව බුදුදහමේ මූලික හේතුඵල න්‍යායයි.",
          "අතීත හේතු 2: අවිද්‍යා, සංඛාර. වර්තමාන ඵල 5: විඤ්ඤාණ, නාමරූප, සළායතන, ඵස්ස, වේදනා. වර්තමාන හේතු 3: තණ්හා, උපාදාන, භව. අනාගත ඵල 2: ජාති, ජරා මරණ.",
          "අනුලෝම වශයෙන් සසර පැවැත්මත්, පටිලෝම වශයෙන් නිවනත් විග්‍රහ කෙරේ."
        ),
        examPitfalls = listOf(
          "අංග 12 අනුපිළිවෙළ වෙනස් කිරීම හෝ කාලත්‍රයට බෙදීමේදී අංග පටලවා ගැනීම."
        ),
        targetedQuestions = listOf(
          TargetedPracticeQuestion(
            id = "tp_bud_1",
            question = "පටිච්චසමුප්පාද ධර්මයේ පළමු අංගය කුමක්ද?",
            options = listOf("සංඛාර", "අවිද්‍යා", "විඤ්ඤාණ", "තණ්හා"),
            correctOptionIndex = 1,
            explanation = "පටිච්චසමුප්පාද ධර්මය ඇරඹෙන්නේ 'අවිද්‍යා පච්චයා සංඛාරා' යනුවෙන් අවිද්‍යාවෙනි."
          )
        )
      )

      else -> TargetedWeakTopicInfo(
        subjectName = subjectName,
        topicName = topicName,
        keyword = subjectName,
        formulaCategory = "ALL",
        formulaSearchQuery = topicName.take(8),
        keyFormulas = listOf(topicName to "විෂය නිර්දේශයේ මූලික සිද්ධාන්ත හා සූත්‍ර"),
        coreTheoryNotes = listOf(
          "$topicName සඳහා වන කෙටි සටහන් හා මූලික සංකල්ප පරිශීලනය කරන්න.",
          "විභාග ගැටලුවලදී අදාළ සිද්ධාන්ත පියවරෙන් පියවර ලියා අභ්‍යාස කරන්න."
        ),
        examPitfalls = listOf("විෂය නිර්දේශයේ මූලික නීති හා සංකල්ප නිවැරදිව කියවා අවබෝධ කරගන්න.")
      )
    }
  }
}

// ------------------------------------------------------------------------------
// TARGETED TOPIC FOCUSED REVISION NOTE MODAL (100% RELEVANCE GUARANTEE)
// ------------------------------------------------------------------------------

@Composable
fun TargetedTopicFocusedNoteDialog(
  info: TargetedWeakTopicInfo,
  onDismiss: () -> Unit,
  onOpenFullFilteredNotes: () -> Unit,
  onOpenMistakeBank: () -> Unit
) {
  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false)
  ) {
    Surface(
      shape = RoundedCornerShape(20.dp),
      color = Color.White,
      shadowElevation = 8.dp,
      modifier = Modifier
        .fillMaxWidth(0.94f)
        .padding(vertical = 20.dp)
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(18.dp)
      ) {
          // Header Row
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
              Surface(
                shape = RoundedCornerShape(6.dp),
                color = Color(0xFFEFF6FF),
                border = BorderStroke(1.dp, Color(0xFFBFDBFE))
              ) {
                Text(
                  text = info.subjectName,
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF1D4ED8),
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                )
              }
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = "ඉලක්කගත සංශෝධන සටහන",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF64748B)
              )
            }
            IconButton(onClick = onDismiss, modifier = Modifier.size(28.dp)) {
              Icon(Icons.Default.Close, contentDescription = "Close", tint = Color(0xFF64748B))
            }
          }

          Spacer(modifier = Modifier.height(8.dp))

          Text(
            text = info.topicName,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0F172A)
          )

          Spacer(modifier = Modifier.height(10.dp))

          // Content scrollable
          Column(
            modifier = Modifier
              .weight(1f, fill = false)
              .verticalScroll(rememberScrollState())
          ) {
            // 1. Core Theory (100% targeted)
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC)),
              border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text("💡", fontSize = 14.sp)
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = "මූලික සිද්ධාන්ත හා සංකල්ප (Core Theory)",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A)
                  )
                }
                Spacer(modifier = Modifier.height(6.dp))
                info.coreTheoryNotes.forEach { note ->
                  Row(modifier = Modifier.padding(vertical = 3.dp)) {
                    Text("•", fontSize = 12.sp, color = Color(0xFF2563EB), fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                      text = note,
                      fontSize = 11.5.sp,
                      color = Color(0xFF334155),
                      lineHeight = 16.5.sp
                    )
                  }
                }
              }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // 2. Direct Formulas & Rules
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFFF0FDF4)),
              border = BorderStroke(1.dp, Color(0xFFBBF7D0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text("🧮", fontSize = 14.sp)
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = "අදාළ සූත්‍ර හා නීති (Exact Formulas)",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF166534)
                  )
                }
                Spacer(modifier = Modifier.height(6.dp))
                info.keyFormulas.forEach { (name, formula) ->
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color.White,
                    border = BorderStroke(1.dp, Color(0xFFDCFCE7)),
                    modifier = Modifier.fillMaxWidth().padding(vertical = 3.dp)
                  ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                      Text(
                        text = name,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF15803D)
                      )
                      Spacer(modifier = Modifier.height(2.dp))
                      Text(
                        text = formula,
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF0F172A),
                        fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace
                      )
                    }
                  }
                }
              }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // 3. Exam Pitfalls & Advice
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFBEB)),
              border = BorderStroke(1.dp, Color(0xFFFDE68A)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text("⚠️", fontSize = 14.sp)
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = "විභාගයේදී සිදුවන වැරදි (Exam Pitfalls)",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF92400E)
                  )
                }
                Spacer(modifier = Modifier.height(6.dp))
                info.examPitfalls.forEach { tip ->
                  Row(modifier = Modifier.padding(vertical = 2.dp)) {
                    Text("!", fontSize = 12.sp, color = Color(0xFFD97706), fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                      text = tip,
                      fontSize = 11.sp,
                      color = Color(0xFF78350F),
                      lineHeight = 15.5.sp
                    )
                  }
                }
              }
            }
          }

          Spacer(modifier = Modifier.height(12.dp))

          // Action Buttons: Open filtered subject notes and mistake practice bank
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            OutlinedButton(
              onClick = {
                onDismiss()
                onOpenFullFilteredNotes()
              },
              modifier = Modifier.weight(1f),
              shape = RoundedCornerShape(10.dp),
              border = BorderStroke(1.dp, Color(0xFF2563EB))
            ) {
              Icon(Icons.Default.MenuBook, contentDescription = null, modifier = Modifier.size(13.dp), tint = Color(0xFF2563EB))
              Spacer(modifier = Modifier.width(4.dp))
              Text("විෂය සටහන්", fontSize = 11.sp, color = Color(0xFF2563EB), fontWeight = FontWeight.Bold)
            }

            Button(
              onClick = {
                onDismiss()
                onOpenMistakeBank()
              },
              modifier = Modifier.weight(1f),
              shape = RoundedCornerShape(10.dp),
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB))
            ) {
              Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(13.dp))
              Spacer(modifier = Modifier.width(4.dp))
              Text("පුහුණුව (Practice)", fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
          }
        }
      }
    }
  }

@Composable
fun StudyAnalyticsScreen(
  grade: String,
  onBack: () -> Unit,
  onOpenNotesForSubject: (subject: String, topicKeyword: String) -> Unit = { _, _ -> },
  onOpenMistakeNotebook: (subject: String, topicKeyword: String) -> Unit = { _, _ -> },
  onOpenFlashcards: () -> Unit = {},
  onOpenFormulaHandbook: (category: String, query: String) -> Unit = { _, _ -> }
) {
  val context = LocalContext.current
  var selectedGrade by remember(grade) {
    val clean = if (grade.contains("10")) "10" else "11"
    mutableStateOf(clean)
  }

  var selectedFocusedTopicForNote by remember { mutableStateOf<TargetedWeakTopicInfo?>(null) }
  var expandedFormulaTopic by remember { mutableStateOf<String?>(null) }

  val mistakeSummary = remember { MistakeNotebookRepository.getSummary(context) }
  val performances = remember(selectedGrade) { AnalyticsRepository.getSubjectPerformances(selectedGrade) }
  val totalTests = performances.sumOf { it.testsTaken }
  val overallAvg = if (performances.isNotEmpty()) performances.map { it.averageScore }.average().toInt() else 0

  // 100% Focused Note Dialog
  if (selectedFocusedTopicForNote != null) {
    TargetedTopicFocusedNoteDialog(
      info = selectedFocusedTopicForNote!!,
      onDismiss = { selectedFocusedTopicForNote = null },
      onOpenFullFilteredNotes = {
        onOpenNotesForSubject(selectedFocusedTopicForNote!!.subjectName, selectedFocusedTopicForNote!!.keyword)
      },
      onOpenMistakeBank = {
        onOpenMistakeNotebook(selectedFocusedTopicForNote!!.subjectName, selectedFocusedTopicForNote!!.keyword)
      }
    )
  }

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .background(Color(0xFFF8FAFC))
      .padding(horizontal = 16.dp),
    verticalArrangement = Arrangement.spacedBy(14.dp),
    contentPadding = PaddingValues(top = 16.dp, bottom = 32.dp)
  ) {
    // Header Bar
    item {
      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Surface(
            onClick = onBack,
            shape = CircleShape,
            color = Color.White,
            border = BorderStroke(1.dp, Color(0xFFE2E8F0))
          ) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = "Back",
              tint = Color(0xFF1E293B),
              modifier = Modifier
                .padding(8.dp)
                .size(20.dp)
            )
          }
          Spacer(modifier = Modifier.width(12.dp))
          Column {
            Text(
              text = "📊 ප්‍රගති විශ්ලේෂණය (Analytics)",
              style = MaterialTheme.typography.titleMedium,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF0F172A)
            )
            Text(
              text = "$selectedGrade ශ්‍රේණිය • Smart Diagnostic Report",
              fontSize = 11.sp,
              color = Color(0xFF64748B)
            )
          }
        }

        // Grade Toggle
        Row(
          horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
          listOf("11", "10").forEach { g ->
            val isSelected = selectedGrade == g
            Surface(
              onClick = { selectedGrade = g },
              shape = RoundedCornerShape(8.dp),
              color = if (isSelected) Color(0xFF1D4ED8) else Color.White,
              border = BorderStroke(1.dp, if (isSelected) Color(0xFF1D4ED8) else Color(0xFFCBD5E1))
            ) {
              Text(
                text = "Gr $g",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = if (isSelected) Color.White else Color(0xFF475569),
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
              )
            }
          }
        }
      }
    }

    // Overall Score KPI Card
    item {
      Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Text(
            text = "සමස්ත අධ්‍යයන කාර්යක්ෂමතාව (Overall Mastery)",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF64748B)
          )
          Spacer(modifier = Modifier.height(12.dp))

          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Column {
              Row(verticalAlignment = Alignment.Bottom) {
                Text(
                  text = "$overallAvg%",
                  fontSize = 36.sp,
                  fontWeight = FontWeight.Black,
                  color = if (overallAvg >= 75) Color(0xFF16A34A) else Color(0xFF2563EB)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = if (overallAvg >= 75) "විශිෂ්ට සාමාර්ථය (A)" else "ඉතා හොඳයි (B)",
                  fontSize = 13.sp,
                  fontWeight = FontWeight.Bold,
                  color = if (overallAvg >= 75) Color(0xFF16A34A) else Color(0xFF2563EB),
                  modifier = Modifier.padding(bottom = 6.dp)
                )
              }
              Text(
                text = "සමස්ත MCQs සහ Quizzes $totalTests කින් ලබාගත් ප්‍රතිඵලය",
                fontSize = 11.sp,
                color = Color(0xFF64748B)
              )
            }

            Box(
              modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(Color(0xFFF0FDF4)),
              contentAlignment = Alignment.Center
            ) {
              Text("🏆", fontSize = 26.sp)
            }
          }

          Spacer(modifier = Modifier.height(14.dp))
          LinearProgressIndicator(
            progress = { overallAvg / 100f },
            modifier = Modifier
              .fillMaxWidth()
              .height(8.dp)
              .clip(RoundedCornerShape(4.dp)),
            color = if (overallAvg >= 75) Color(0xFF16A34A) else Color(0xFF2563EB),
            trackColor = Color(0xFFE2E8F0)
          )

          Spacer(modifier = Modifier.height(14.dp))
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
          ) {
            StatMiniBox(title = "සම්පූර්ණ Quizzes", value = "$totalTests Sets", icon = "📝")
            StatMiniBox(title = "සාමාන්‍ය වේගය", value = "18 තත්/MCQ", icon = "⚡")
            StatMiniBox(title = "පාඩම් Streak", value = "7 දින", icon = "🔥")
          }
        }
      }
    }

    // Mistake Bank Summary Integration Banner
    item {
      Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFEF2F2)),
        border = BorderStroke(1.dp, Color(0xFFFECACA)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Box(
                modifier = Modifier
                  .size(36.dp)
                  .clip(CircleShape)
                  .background(Color(0xFFDC2626)),
                contentAlignment = Alignment.Center
              ) {
                Text("⚠️", fontSize = 18.sp)
              }
              Spacer(modifier = Modifier.width(10.dp))
              Column {
                Text(
                  text = "Mistake Notebook (වරදවාගත් ප්‍රශ්න)",
                  fontWeight = FontWeight.Bold,
                  fontSize = 13.sp,
                  color = Color(0xFF991B1B)
                )
                Text(
                  text = "පුහුණු වීමට ප්‍රශ්න ${mistakeSummary.pending}ක් • ප්‍රගුණ කළ ${mistakeSummary.mastered}ක්",
                  fontSize = 11.sp,
                  color = Color(0xFFB91C1C)
                )
              }
            }

            Button(
              onClick = { onOpenMistakeNotebook("ALL", "") },
              shape = RoundedCornerShape(8.dp),
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
              contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
            ) {
              Text("විවෘත කරන්න", fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
          }
        }
      }
    }

    // Weak Topic Diagnostic Section (අවධානය යොමු කළ යුතු දුර්වල මාතෘකා & සෘජු සංශෝධන සබැඳි)
    item {
      Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFBEB)),
        border = BorderStroke(1.dp, Color(0xFFFDE68A)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text("🎯", fontSize = 18.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Column {
              Text(
                text = "දුර්වල පාඩම් හඳුනාගැනීමේ එන්ජිම (Weak Areas Detector)",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF92400E)
              )
              Text(
                text = "ලකුණු අඩු සංකල්ප ඉක්මනින් ආවරණය කිරීමට සෘජුව පිවිසෙන්න:",
                fontSize = 11.sp,
                color = Color(0xFFB45309)
              )
            }
          }

          Spacer(modifier = Modifier.height(10.dp))

          performances.flatMap { p -> p.weakTopics.map { p.subjectName to it } }.take(5).forEach { (subj, topic) ->
            val topicInfo = remember(subj, topic) { TargetedWeakTopicRepository.getTopicInfo(subj, topic) }
            val isFormulaExpanded = expandedFormulaTopic == topic

            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color.White),
              border = BorderStroke(1.dp, Color(0xFFFEF3C7)),
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                    Surface(
                      shape = RoundedCornerShape(4.dp),
                      color = Color(0xFFFEF3C7)
                    ) {
                      Text(
                        text = subj,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF92400E),
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                      )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                      text = topic,
                      fontSize = 12.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF1E293B),
                      maxLines = 1,
                      overflow = TextOverflow.Ellipsis
                    )
                  }

                  Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = Color(0xFFFEE2E2)
                  ) {
                    Text(
                      text = "අවධානය අවශ්‍යයි",
                      fontSize = 9.5.sp,
                      color = Color(0xFFDC2626),
                      fontWeight = FontWeight.Bold,
                      modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                    )
                  }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // DIRECT ACTION BUTTONS (100% TARGETED RELEVANCE)
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                  // 1. NOTES BUTTON (Opens 100% targeted note sheet & direct link to filtered subject notes)
                  OutlinedButton(
                    onClick = { selectedFocusedTopicForNote = topicInfo },
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color(0xFF2563EB)),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF1D4ED8)),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                    modifier = Modifier
                      .weight(1f)
                      .height(32.dp)
                  ) {
                    Icon(Icons.Default.MenuBook, contentDescription = null, modifier = Modifier.size(13.dp))
                    Spacer(modifier = Modifier.width(3.dp))
                    Text("📖 සටහන්", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                  }

                  // 2. FORMULAS BUTTON (Opens Formula Handbook 100% filtered by exact category & keyword)
                  OutlinedButton(
                    onClick = {
                      onOpenFormulaHandbook(topicInfo.formulaCategory, topicInfo.formulaSearchQuery)
                    },
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color(0xFF059669)),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF059669)),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                    modifier = Modifier
                      .weight(1f)
                      .height(32.dp)
                  ) {
                    Icon(Icons.Default.Calculate, contentDescription = null, modifier = Modifier.size(13.dp))
                    Spacer(modifier = Modifier.width(3.dp))
                    Text("🧮 සූත්‍ර/නීති", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                  }

                  // 3. MISTAKE BANK BUTTON (Opens Mistake Notebook 100% filtered to this subject & weak topic)
                  Button(
                    onClick = {
                      onOpenMistakeNotebook(subj, topicInfo.keyword)
                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB)),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                    modifier = Modifier
                      .weight(1f)
                      .height(32.dp)
                  ) {
                    Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(13.dp))
                    Spacer(modifier = Modifier.width(3.dp))
                    Text("🎯 පුහුණුව", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                  }
                }

                // Quick Inline Formula Peek Toggle
                Row(
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                  horizontalArrangement = Arrangement.End,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  TextButton(
                    onClick = { expandedFormulaTopic = if (isFormulaExpanded) null else topic },
                    contentPadding = PaddingValues(horizontal = 4.dp, vertical = 0.dp),
                    modifier = Modifier.height(24.dp)
                  ) {
                    Text(
                      text = if (isFormulaExpanded) "▲ සූත්‍ර සඟවන්න" else "👁️ ක්ෂණික සූත්‍රය පෙන්වන්න",
                      fontSize = 10.sp,
                      color = Color(0xFF059669),
                      fontWeight = FontWeight.SemiBold
                    )
                  }
                }

                // Inline Formula Card if expanded
                if (isFormulaExpanded) {
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFF0FDF4),
                    border = BorderStroke(1.dp, Color(0xFFBBF7D0)),
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(top = 4.dp)
                  ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                      topicInfo.keyFormulas.forEach { (name, formula) ->
                        Text(
                          text = "$name: $formula",
                          fontSize = 11.sp,
                          color = Color(0xFF166534),
                          fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(2.dp))
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

    // Subject Breakdown Cards
    item {
      Text(
        text = "විෂය අනුව සාමාර්ථතා විශ්ලේෂණය (Subject Breakdown)",
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF0F172A),
        modifier = Modifier.padding(top = 4.dp)
      )
    }

    items(performances) { perf ->
      SubjectPerformanceCard(
        performance = perf,
        onReviewNotes = { onOpenNotesForSubject(perf.subjectName, "") },
        onOpenMistakes = { onOpenMistakeNotebook(perf.subjectName, "") }
      )
    }
  }
}

@Composable
fun StatMiniBox(title: String, value: String, icon: String) {
  Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Text(icon, fontSize = 16.sp)
    Spacer(modifier = Modifier.height(2.dp))
    Text(text = value, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0F172A))
    Text(text = title, fontSize = 10.sp, color = Color(0xFF64748B))
  }
}

@Composable
fun SubjectPerformanceCard(
  performance: SubjectPerformance,
  onReviewNotes: () -> Unit,
  onOpenMistakes: () -> Unit = {}
) {
  Card(
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
    modifier = Modifier.fillMaxWidth()
  ) {
    Column(modifier = Modifier.padding(14.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Box(
            modifier = Modifier
              .size(10.dp)
              .clip(CircleShape)
              .background(performance.color)
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = performance.subjectName,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0F172A)
          )
        }
        Text(
          text = "${performance.averageScore}%",
          fontSize = 16.sp,
          fontWeight = FontWeight.Black,
          color = performance.color
        )
      }

      Spacer(modifier = Modifier.height(8.dp))
      LinearProgressIndicator(
        progress = { performance.accuracyRate },
        modifier = Modifier
          .fillMaxWidth()
          .height(6.dp)
          .clip(RoundedCornerShape(3.dp)),
        color = performance.color,
        trackColor = Color(0xFFF1F5F9)
      )

      Spacer(modifier = Modifier.height(10.dp))
      Text(
        text = "💡 උපදෙස: ${performance.recommendation}",
        fontSize = 11.sp,
        color = Color(0xFF475569),
        lineHeight = 15.sp
      )

      Spacer(modifier = Modifier.height(10.dp))
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End)
      ) {
        OutlinedButton(
          onClick = onOpenMistakes,
          shape = RoundedCornerShape(8.dp),
          contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
          modifier = Modifier.height(30.dp)
        ) {
          Text("⚠️ Mistake Bank", fontSize = 10.sp, color = Color(0xFFDC2626))
        }

        Surface(
          onClick = onReviewNotes,
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFFF8FAFC),
          border = BorderStroke(1.dp, Color(0xFFCBD5E1))
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "කෙටි සටහන්",
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF334155)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(Icons.Default.MenuBook, contentDescription = null, tint = Color(0xFF334155), modifier = Modifier.size(12.dp))
          }
        }
      }
    }
  }
}

// ==============================================================================
// FEATURE 3: STRUCTURED & ESSAY PRACTICE HUB (ව්‍යුහගත හා රචනා ප්‍රශ්න & MARKING SCHEMES)
// ==============================================================================

data class StructuredSubQuestion(
  val subIndex: String, // e.g. "(i)", "(ii)"
  val questionText: String,
  val marksAllocated: Int,
  val modelAnswer: String,
  val keyPoints: List<String>
)

data class StructuredEssayItem(
  val id: String,
  val grade: String,
  val subject: String,
  val topicSinhala: String,
  val type: String, // "STRUCTURED" (ව්‍යුහගත) or "ESSAY" (රචනා)
  val totalMarks: Int,
  val mainScenario: String,
  val subQuestions: List<StructuredSubQuestion>,
  val setNumber: Int = 1,
  val questionIndexInSet: Int = 1,
  val globalIndex: Int = 1,
  val unitCategory: String = ""
)

object StructuredEssayRepository {
  fun getQuestions(
    grade: String,
    subjectFilter: String = "විද්‍යාව",
    setNumber: Int? = 1,
    typeFilter: String? = null
  ): List<StructuredEssayItem> {
    val cleanSubject = if (subjectFilter == "සියල්ල") "විද්‍යාව" else subjectFilter
    return ComprehensiveStructuredEssayRepository.getQuestions(grade, cleanSubject, setNumber, typeFilter)
  }
}

@Composable
fun StructuredEssayHubScreen(
  grade: String,
  onBack: () -> Unit
) {
  var selectedGrade by remember { mutableStateOf(if (grade in listOf("9", "10", "11")) grade else "11") }
  var selectedTab by remember { mutableStateOf(0) } // 0: ව්‍යුහගත ප්‍රශ්න, 1: රචනා ප්‍රශ්න, 2: Marking Schemes (ලකුණු ක්‍රමය)
  var selectedSubjectFilter by remember { mutableStateOf("විද්‍යාව") }
  var selectedSetNumber by remember { mutableStateOf<Int?>(1) } // 1..25 or null for all 500
  var showSetsOverviewDialog by remember { mutableStateOf(false) }
  var showSelfAssessment by remember { mutableStateOf(false) }

  if (showSelfAssessment) {
    StructuredEssayAssessmentHub(onBack = { showSelfAssessment = false })
    return
  }

  val sets = remember(selectedGrade, selectedSubjectFilter) {
    ComprehensiveStructuredEssayRepository.getSetsForSubject(selectedGrade, selectedSubjectFilter)
  }

  val typeFilter = when (selectedTab) {
    0 -> "STRUCTURED"
    1 -> "ESSAY"
    else -> null // Marking Schemes shows all
  }

  val questions = remember(selectedGrade, selectedSubjectFilter, selectedSetNumber, typeFilter) {
    ComprehensiveStructuredEssayRepository.getQuestions(
      grade = selectedGrade,
      subject = selectedSubjectFilter,
      setNumber = selectedSetNumber,
      typeFilter = typeFilter
    )
  }
  var fullScreenReadingItem by remember { mutableStateOf<StructuredEssayItem?>(null) }

  // Full Screen Distraction-Free Reader Dialog
  if (fullScreenReadingItem != null) {
    FullScreenStructuredQuestionReader(
      item = fullScreenReadingItem!!,
      initialShowAnswers = true,
      onDismiss = { fullScreenReadingItem = null }
    )
  }

  // Sets Overview Dialog (All 25 Sets with Themes)
  if (showSetsOverviewDialog) {
    AlertDialog(
      onDismissRequest = { showSetsOverviewDialog = false },
      title = {
        Column {
          Text(
            text = "📋 $selectedGrade ශ්‍රේණිය • $selectedSubjectFilter",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color(0xFF0F172A)
          )
          Text(
            text = "ප්‍රශ්න 500ක් කාණ්ඩ 25ක් යටතේ (එක් කාණ්ඩයකට 20 බැගින්)",
            fontSize = 11.sp,
            color = Color(0xFF64748B)
          )
        }
      },
      text = {
        LazyColumn(
          modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 420.dp),
          verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          item {
            Surface(
              onClick = {
                selectedSetNumber = null
                showSetsOverviewDialog = false
              },
              shape = RoundedCornerShape(10.dp),
              color = if (selectedSetNumber == null) BluePrimary else Color(0xFFEFF6FF),
              border = BorderStroke(1.dp, if (selectedSetNumber == null) BluePrimary else Color(0xFFBFDBFE)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(
                modifier = Modifier.padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Text(
                  text = "📚 සියලු ප්‍රශ්න 500ම එකවර (All 500 Questions)",
                  fontSize = 12.sp,
                  fontWeight = FontWeight.Bold,
                  color = if (selectedSetNumber == null) Color.White else Color(0xFF1D4ED8)
                )
                Text(
                  text = "500 Qs",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = if (selectedSetNumber == null) Color.White else Color(0xFF2563EB)
                )
              }
            }
          }

          items(sets) { s ->
            val isCurrent = selectedSetNumber == s.setNumber
            Surface(
              onClick = {
                selectedSetNumber = s.setNumber
                showSetsOverviewDialog = false
              },
              shape = RoundedCornerShape(10.dp),
              color = if (isCurrent) BluePrimary else Color(0xFFF8FAFC),
              border = BorderStroke(1.dp, if (isCurrent) BluePrimary else Color(0xFFE2E8F0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Column(modifier = Modifier.weight(1f)) {
                  Text(
                    text = s.title,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isCurrent) Color.White else Color(0xFF0F172A)
                  )
                  Text(
                    text = s.unitTheme,
                    fontSize = 11.sp,
                    color = if (isCurrent) Color(0xFFE0E7FF) else Color(0xFF64748B),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = if (isCurrent) Color(0xFF1D4ED8) else Color(0xFFE2E8F0)
                ) {
                  Text(
                    text = "20 Qs",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isCurrent) Color.White else Color(0xFF334155),
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                  )
                }
              }
            }
          }
        }
      },
      confirmButton = {
        TextButton(onClick = { showSetsOverviewDialog = false }) {
          Text("වසන්න (Close)", fontWeight = FontWeight.Bold)
        }
      }
    )
  }

  val listState = rememberLazyListState()
  val coroutineScope = rememberCoroutineScope()
  val showScrollToTop by remember {
    derivedStateOf { listState.firstVisibleItemIndex > 1 }
  }

  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color(0xFFF8FAFC))
  ) {
    LazyColumn(
      state = listState,
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.spacedBy(14.dp),
      contentPadding = PaddingValues(bottom = 36.dp)
    ) {
      // 1. Top Header Surface (entire header section, full width, scrolls naturally)
      item {
        Surface(
          color = Color.White,
          shadowElevation = 2.dp,
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                  onClick = onBack,
                  shape = CircleShape,
                  color = Color(0xFFF1F5F9)
                ) {
                  Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color(0xFF1E293B),
                    modifier = Modifier.padding(8.dp).size(20.dp)
                  )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                  Text(
                    text = "ව්‍යුහගත හා රචනා පුහුණුව (Structured & Essay)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A)
                  )
                  Text(
                    text = "$selectedGrade ශ්‍රේණිය • Marking Schemes & Model Answers (ප්‍රශ්න 500ක්)",
                    fontSize = 11.sp,
                    color = Color(0xFF64748B)
                  )
                }
              }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Button(
              onClick = { showSelfAssessment = true },
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1D4ED8)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Text("✍️ රචනා පිළිතුරු ලියා ලකුණු ක්‍රමය පරීක්ෂා කරන්න (Self-Assessment)")
            }

            Spacer(modifier = Modifier.height(10.dp))

            // 1. Grade Selector (9, 10, 11 ශ්‍රේණි තේරීම)
            Row(
              modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              Text(
                text = "ශ්‍රේණිය:",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF475569)
              )
              listOf("9", "10", "11").forEach { g ->
                val isGSelected = selectedGrade == g
                Surface(
                  onClick = { selectedGrade = g },
                  shape = RoundedCornerShape(8.dp),
                  color = if (isGSelected) Color(0xFF1E293B) else Color(0xFFF1F5F9),
                  border = BorderStroke(1.dp, if (isGSelected) Color(0xFF1E293B) else Color(0xFFCBD5E1)),
                  modifier = Modifier.weight(1f)
                ) {
                  Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(vertical = 6.dp)
                  ) {
                    Text(
                      text = "$g ශ්‍රේණිය",
                      fontSize = 11.sp,
                      fontWeight = if (isGSelected) FontWeight.Bold else FontWeight.Medium,
                      color = if (isGSelected) Color.White else Color(0xFF334155)
                    )
                  }
                }
              }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // 2. Subject Filter Chips (විෂයන් තේරීම)
            LazyRow(
              horizontalArrangement = Arrangement.spacedBy(6.dp),
              modifier = Modifier.fillMaxWidth()
            ) {
              items(ComprehensiveStructuredEssayRepository.availableSubjects) { s ->
                val isSelected = selectedSubjectFilter == s
                Surface(
                  onClick = {
                    selectedSubjectFilter = s
                    selectedSetNumber = 1 // Reset to Set 1 on subject switch
                  },
                  shape = RoundedCornerShape(8.dp),
                  color = if (isSelected) BluePrimary else Color(0xFFF1F5F9),
                  border = BorderStroke(1.dp, if (isSelected) BluePrimary else Color(0xFFCBD5E1))
                ) {
                  Text(
                    text = s,
                    fontSize = 11.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    color = if (isSelected) Color.White else Color(0xFF334155),
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                  )
                }
              }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // 3. 25 Sets Selector (එක් එක් කාණ්ඩයට 20 බැගින් ප්‍රශ්න 500ක්)
            Row(
              modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Surface(
                onClick = { showSetsOverviewDialog = true },
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFEFF6FF),
                border = BorderStroke(1.dp, Color(0xFFBFDBFE)),
                modifier = Modifier.padding(end = 6.dp)
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = null,
                    tint = Color(0xFF1D4ED8),
                    modifier = Modifier.size(14.dp)
                  )
                  Spacer(modifier = Modifier.width(3.dp))
                  Text(
                    text = "කාණ්ඩ 25",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1D4ED8)
                  )
                }
              }

              LazyRow(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier.weight(1f)
              ) {
                item {
                  val isAll = selectedSetNumber == null
                  Surface(
                    onClick = { selectedSetNumber = null },
                    shape = RoundedCornerShape(8.dp),
                    color = if (isAll) Color(0xFF2563EB) else Color(0xFFF1F5F9),
                    border = BorderStroke(1.dp, if (isAll) Color(0xFF2563EB) else Color(0xFFCBD5E1))
                  ) {
                    Text(
                      text = "සියල්ල (500)",
                      fontSize = 10.sp,
                      fontWeight = if (isAll) FontWeight.Bold else FontWeight.Normal,
                      color = if (isAll) Color.White else Color(0xFF334155),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)
                    )
                  }
                }

                items(sets) { s ->
                  val isSelected = selectedSetNumber == s.setNumber
                  Surface(
                    onClick = { selectedSetNumber = s.setNumber },
                    shape = RoundedCornerShape(8.dp),
                    color = if (isSelected) Color(0xFF2563EB) else Color(0xFFF1F5F9),
                    border = BorderStroke(1.dp, if (isSelected) Color(0xFF2563EB) else Color(0xFFCBD5E1))
                  ) {
                    Text(
                      text = "කාණ්ඩය ${s.setNumber} (${s.startQuestionNum}-${s.endQuestionNum})",
                      fontSize = 10.sp,
                      fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                      color = if (isSelected) Color.White else Color(0xFF334155),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)
                    )
                  }
                }
              }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // 4. Tab Row (ව්‍යුහගත, රචනා, ලකුණු පටිපාටි)
            TabRow(
              selectedTabIndex = selectedTab,
              containerColor = Color(0xFFF1F5F9),
              contentColor = BluePrimary,
              modifier = Modifier.clip(RoundedCornerShape(12.dp))
            ) {
              listOf("ව්‍යුහගත (Part A)", "රචනා (Part B)", "ලකුණු පටිපාටි (Marking)").forEachIndexed { index, label ->
                Tab(
                  selected = selectedTab == index,
                  onClick = { selectedTab = index },
                  text = {
                    Text(
                      text = label,
                      fontSize = 11.sp,
                      fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Medium
                    )
                  }
                )
              }
            }
          }
        }
      }

      // 2. Active Set & Unit Theme Info Banner
      item {
        Box(modifier = Modifier.padding(horizontal = 16.dp)) {
          Surface(
            color = Color(0xFFF0FDF4),
            border = BorderStroke(1.dp, Color(0xFFBBF7D0)),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              val currentTheme = if (selectedSetNumber != null) {
                sets.getOrNull(selectedSetNumber!! - 1)?.unitTheme ?: "විෂය ඒකකය $selectedSetNumber"
              } else {
                "සියලු ඒකක ආවරණය වන සම්පූර්ණ ප්‍රශ්න 500"
              }

              Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                Text(text = "🎯", fontSize = 13.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = if (selectedSetNumber != null) "කාණ්ඩය $selectedSetNumber: $currentTheme (ප්‍රශ්න 20ක්)" else currentTheme,
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF166534),
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }

              Surface(
                shape = RoundedCornerShape(4.dp),
                color = Color(0xFF16A34A)
              ) {
                Text(
                  text = "${questions.size} Qs",
                  fontSize = 9.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }
            }
          }
        }
      }

      // 3. Question List Items
      if (questions.isEmpty()) {
        item {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 16.dp, vertical = 40.dp),
            contentAlignment = Alignment.Center
          ) {
            Text(
              text = "$selectedGrade ශ්‍රේණිය $selectedSubjectFilter සඳහා ප්‍රශ්න සූදානම් වෙමින් පවතී...",
              color = Color(0xFF64748B),
              fontSize = 13.sp
            )
          }
        }
      } else {
        items(questions) { q ->
          Box(modifier = Modifier.padding(horizontal = 16.dp)) {
            StructuredQuestionCard(
              item = q,
              showMarkingMode = selectedTab == 2,
              onOpenFullScreen = { fullScreenReadingItem = q }
            )
          }
        }
      }
    }

    // Quick Scroll-To-Top Floating Button
    AnimatedVisibility(
      visible = showScrollToTop,
      enter = fadeIn() + slideInVertically { it / 2 },
      exit = fadeOut() + slideOutVertically { it / 2 },
      modifier = Modifier
        .align(Alignment.BottomEnd)
        .padding(16.dp)
    ) {
      FloatingActionButton(
        onClick = {
          coroutineScope.launch {
            listState.animateScrollToItem(0)
          }
        },
        containerColor = Color(0xFF1E293B),
        contentColor = Color.White,
        shape = CircleShape,
        modifier = Modifier.size(46.dp)
      ) {
        Icon(
          imageVector = Icons.Default.KeyboardArrowUp,
          contentDescription = "Scroll to top",
          modifier = Modifier.size(24.dp)
        )
      }
    }
  }
}

@Composable
fun StructuredQuestionCard(
  item: StructuredEssayItem,
  showMarkingMode: Boolean,
  onOpenFullScreen: () -> Unit = {}
) {
  var isExpanded by remember { mutableStateOf(true) }

  Card(
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    modifier = Modifier
      .fillMaxWidth()
      .clickable(onClick = onOpenFullScreen)
  ) {
    Column(modifier = Modifier.padding(14.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          Surface(
            shape = RoundedCornerShape(6.dp),
            color = if (item.type == "STRUCTURED") Color(0xFFEEF2FF) else Color(0xFFFAF5FF)
          ) {
            Text(
              text = "${item.subject} • ${if (item.type == "STRUCTURED") "ව්‍යුහගත" else "රචනා"}",
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              color = if (item.type == "STRUCTURED") Color(0xFF4338CA) else Color(0xFF7E22CE),
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
            )
          }

          Surface(
            shape = RoundedCornerShape(6.dp),
            color = Color(0xFFF1F5F9),
            border = BorderStroke(1.dp, Color(0xFFE2E8F0))
          ) {
            Text(
              text = "කාණ්ඩය ${item.setNumber} • ප්‍රශ්න ${item.questionIndexInSet}/20",
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF334155),
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
            )
          }
        }

        Surface(
          shape = RoundedCornerShape(6.dp),
          color = Color(0xFFDCFCE7)
        ) {
          Text(
            text = "ලකුණු ${item.totalMarks}",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF16A34A),
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      Text(
        text = "ප්‍රශ්න අංක ${item.globalIndex}: ${item.topicSinhala}",
        style = MaterialTheme.typography.titleSmall,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF0F172A)
      )

      if (item.mainScenario.isNotBlank()) {
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = item.mainScenario,
          fontSize = 12.sp,
          color = Color(0xFF475569),
          lineHeight = 16.sp
        )
      }

      Spacer(modifier = Modifier.height(10.dp))
      HorizontalDivider(color = Color(0xFFF1F5F9))
      Spacer(modifier = Modifier.height(10.dp))

      // Sub questions preview (Question + Answer + Marking Scheme)
      item.subQuestions.forEach { sub ->
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
        ) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Text(
              text = "${sub.subIndex} ${sub.questionText}",
              fontSize = 12.sp,
              fontWeight = FontWeight.SemiBold,
              color = Color(0xFF1E293B),
              modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "(${sub.marksAllocated} ලකුණු)",
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF64748B)
            )
          }

          if (isExpanded) {
            Spacer(modifier = Modifier.height(6.dp))
            Surface(
              shape = RoundedCornerShape(10.dp),
              color = Color(0xFFF0FDF4),
              border = BorderStroke(1.dp, Color(0xFFBBF7D0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(10.dp)) {
                Text(
                  text = "✅ ආදර්ශ පිළිතුර (Model Answer):",
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF166534)
                )
                Text(
                  text = sub.modelAnswer,
                  fontSize = 11.sp,
                  color = Color(0xFF14532D),
                  lineHeight = 15.sp,
                  modifier = Modifier.padding(vertical = 4.dp)
                )

                if (sub.keyPoints.isNotEmpty()) {
                  Text(
                    text = "📌 ලකුණු දීමේ පටිපාටිය (Marking Rubric):",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF15803D),
                    modifier = Modifier.padding(top = 4.dp)
                  )
                  sub.keyPoints.forEach { pt ->
                    Text(
                      text = "• $pt",
                      fontSize = 10.sp,
                      color = Color(0xFF166534)
                    )
                  }
                }
              }
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
      ) {
        OutlinedButton(
          onClick = { isExpanded = !isExpanded },
          shape = RoundedCornerShape(8.dp),
          contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
        ) {
          Text(
            text = if (isExpanded) "පිළිතුරු & ලකුණු සඟවන්න" else "පිළිතුරු & ලකුණු බලන්න",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold
          )
        }
      }
    }
  }
}

/**
 * 100% Full-Screen, Distraction-Free Reading Mode for Structured and Essay Questions.
 * Supports Text Zoom In/Out, Toggle Model Answers, and Clean Reading layout with 0 Obstructing Floating Overlays.
 */
@Composable
fun FullScreenStructuredQuestionReader(
  item: StructuredEssayItem,
  initialShowAnswers: Boolean = true,
  onDismiss: () -> Unit
) {
  var showAnswers by remember { mutableStateOf(initialShowAnswers) }
  var fontScaleFactor by remember { mutableStateOf(1.0f) } // 0.85f to 1.4f
  var showScratchpad by remember { mutableStateOf(false) }
  var studentAnswerNote by remember { mutableStateOf("") }

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(
      usePlatformDefaultWidth = false,
      decorFitsSystemWindows = false
    )
  ) {
    Surface(
      modifier = Modifier.fillMaxSize(),
      color = Color.White
    ) {
      Column(modifier = Modifier.fillMaxSize()) {
        // Pristine Top Navigation Bar with Zoom and Action Controls
        Surface(
          color = Color(0xFF0F172A),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              modifier = Modifier.weight(1f)
            ) {
              IconButton(
                onClick = onDismiss,
                modifier = Modifier.size(38.dp)
              ) {
                Icon(
                  imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                  contentDescription = "Close Full Screen",
                  tint = Color.White,
                  modifier = Modifier.size(22.dp)
                )
              }

              Spacer(modifier = Modifier.width(6.dp))

              Column {
                Text(
                  text = item.topicSinhala,
                  fontWeight = FontWeight.Bold,
                  fontSize = 13.sp,
                  color = Color.White,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
                Text(
                  text = "${item.grade} ශ්‍රේණිය • ${item.subject} • කාණ්ඩය ${item.setNumber} (${item.questionIndexInSet}/20) • ලකුණු ${item.totalMarks}",
                  fontSize = 10.sp,
                  color = Color(0xFF94A3B8)
                )
              }
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
              // Font Zoom Out Button
              IconButton(
                onClick = { if (fontScaleFactor > 0.85f) fontScaleFactor -= 0.1f },
                modifier = Modifier.size(32.dp)
              ) {
                Text("A-", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
              }

              // Font Zoom In Button
              IconButton(
                onClick = { if (fontScaleFactor < 1.45f) fontScaleFactor += 0.1f },
                modifier = Modifier.size(32.dp)
              ) {
                Text("A+", color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Bold)
              }

              Spacer(modifier = Modifier.width(4.dp))

              // Toggle Model Answer / Marking Scheme
              Surface(
                onClick = { showAnswers = !showAnswers },
                shape = RoundedCornerShape(8.dp),
                color = if (showAnswers) Color(0xFF16A34A) else Color(0xFF334155)
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Icon(
                    imageVector = if (showAnswers) Icons.Default.CheckCircle else Icons.Default.Visibility,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(13.dp)
                  )
                  Spacer(modifier = Modifier.width(4.dp))
                  Text(
                    text = if (showAnswers) "පිළිතුරු සක්‍රියයි" else "ලකුණු ක්‍රමය",
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                  )
                }
              }

              Spacer(modifier = Modifier.width(4.dp))

              IconButton(
                onClick = onDismiss,
                modifier = Modifier.size(36.dp)
              ) {
                Icon(
                  imageVector = Icons.Default.Close,
                  contentDescription = "Close",
                  tint = Color.White,
                  modifier = Modifier.size(20.dp)
                )
              }
            }
          }
        }

        // Full Screen Reading Canvas (Distraction-Free, Zoomable, Edge-to-Edge)
        LazyColumn(
          modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color(0xFFFAFAFA))
            .padding(horizontal = 20.dp),
          contentPadding = PaddingValues(vertical = 20.dp),
          verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
          // Question Header Banner
          item {
            Card(
              shape = RoundedCornerShape(14.dp),
              colors = CardDefaults.cardColors(containerColor = Color.White),
              elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
              border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(18.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = if (item.type == "STRUCTURED") Color(0xFFEEF2FF) else Color(0xFFFAF5FF)
                  ) {
                    Text(
                      text = "${item.subject} • ${if (item.type == "STRUCTURED") "ව්‍යුහගත ප්‍රශ්න පත්‍රය (Part A)" else "රචනා ප්‍රශ්න පත්‍රය (Part B)"}",
                      fontSize = (11 * fontScaleFactor).sp,
                      fontWeight = FontWeight.Bold,
                      color = if (item.type == "STRUCTURED") Color(0xFF4338CA) else Color(0xFF7E22CE),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }

                  Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFFDCFCE7)
                  ) {
                    Text(
                      text = "මුළු ලකුණු: ${item.totalMarks}",
                      fontSize = (11 * fontScaleFactor).sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF15803D),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }
                }

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                  text = item.topicSinhala,
                  fontSize = (18 * fontScaleFactor).sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF0F172A),
                  lineHeight = (24 * fontScaleFactor).sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                Surface(
                  shape = RoundedCornerShape(10.dp),
                  color = Color(0xFFF1F5F9),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Text(
                    text = item.mainScenario,
                    fontSize = (14 * fontScaleFactor).sp,
                    color = Color(0xFF334155),
                    lineHeight = (21 * fontScaleFactor).sp,
                    modifier = Modifier.padding(14.dp)
                  )
                }
              }
            }
          }

          // Sub Questions formatted for readable full screen study
          items(item.subQuestions) { sub ->
            Card(
              shape = RoundedCornerShape(14.dp),
              colors = CardDefaults.cardColors(containerColor = Color.White),
              elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
              border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(18.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.Top
                ) {
                  Text(
                    text = "${sub.subIndex} ${sub.questionText}",
                    fontSize = (14 * fontScaleFactor).sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A),
                    lineHeight = (21 * fontScaleFactor).sp,
                    modifier = Modifier.weight(1f)
                  )

                  Spacer(modifier = Modifier.width(10.dp))

                  Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFFF8FAFC),
                    border = BorderStroke(1.dp, Color(0xFFCBD5E1))
                  ) {
                    Text(
                      text = "${sub.marksAllocated} ලකුණු",
                      fontSize = (11 * fontScaleFactor).sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF475569),
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                    )
                  }
                }

                // Model Answer and Marking Scheme Display
                if (showAnswers) {
                  Spacer(modifier = Modifier.height(14.dp))

                  Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = Color(0xFFF0FDF4),
                    border = BorderStroke(1.dp, Color(0xFF86EFAC)),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                      Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                          imageVector = Icons.Default.CheckCircle,
                          contentDescription = null,
                          tint = Color(0xFF16A34A),
                          modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                          text = "සම්මත ආදර්ශ පිළිතුර (Model Answer):",
                          fontSize = (12 * fontScaleFactor).sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFF166534)
                        )
                      }

                      Spacer(modifier = Modifier.height(6.dp))

                      Text(
                        text = sub.modelAnswer,
                        fontSize = (13 * fontScaleFactor).sp,
                        color = Color(0xFF14532D),
                        lineHeight = (19 * fontScaleFactor).sp,
                        fontWeight = FontWeight.Medium
                      )

                      Spacer(modifier = Modifier.height(10.dp))
                      HorizontalDivider(color = Color(0xFFBBF7D0))
                      Spacer(modifier = Modifier.height(8.dp))

                      Text(
                        text = "📌 ලකුණු දීමේ නිර්ණායක (Marking Rubric):",
                        fontSize = (11 * fontScaleFactor).sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF15803D)
                      )

                      Spacer(modifier = Modifier.height(4.dp))

                      sub.keyPoints.forEach { pt ->
                        Row(
                          modifier = Modifier.padding(vertical = 2.dp),
                          verticalAlignment = Alignment.Top
                        ) {
                          Text(
                            text = "• ",
                            fontSize = (13 * fontScaleFactor).sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF166534)
                          )
                          Text(
                            text = pt,
                            fontSize = (12 * fontScaleFactor).sp,
                            color = Color(0xFF166534),
                            lineHeight = (17 * fontScaleFactor).sp
                          )
                        }
                      }
                    }
                  }
                }
              }
            }
          }

          // Optional Student Writing Scratchpad Section
          item {
            Card(
              shape = RoundedCornerShape(14.dp),
              colors = CardDefaults.cardColors(containerColor = Color.White),
              elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
              border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(16.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                      imageVector = Icons.Default.EditNote,
                      contentDescription = null,
                      tint = Color(0xFF2563EB),
                      modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                      text = "ස්වයං පිළිතුරු පුහුණුව (Practice Scratchpad)",
                      fontSize = 13.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF1E293B)
                    )
                  }

                  TextButton(onClick = { showScratchpad = !showScratchpad }) {
                    Text(if (showScratchpad) "සඟවන්න" else "ලියන්න")
                  }
                }

                if (showScratchpad) {
                  Spacer(modifier = Modifier.height(10.dp))
                  OutlinedTextField(
                    value = studentAnswerNote,
                    onValueChange = { studentAnswerNote = it },
                    placeholder = { Text("ඔබගේ පිළිතුර මෙහි කෙටුම්පත් කර බලන්න...", fontSize = 12.sp) },
                    modifier = Modifier
                      .fillMaxWidth()
                      .heightIn(min = 100.dp, max = 220.dp),
                    shape = RoundedCornerShape(10.dp)
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

// ==============================================================================
// FEATURE 5: QUICK REFERENCE FORMULA HANDBOOK & HISTORICAL TIMELINE HUB
// (සූත්‍ර, ඒකක, නියමයන් & ඉතිහාස කාලරේඛාව)
// ==============================================================================

data class FormulaItem(
  val id: String,
  val category: String, // "MATH", "SCIENCE", "ICT", "COMMERCE", "TIMELINE", "GEOGRAPHY", "CIVICS"
  val nameSinhala: String,
  val formula: String,
  val explanation: String,
  val unitsOrEra: String,
  var isBookmarked: Boolean = false,
  val grade: String = "ALL", // "9", "10", "11", "ALL"
  val subject: String = "",
  val examTip: String = ""
)

object FormulaRepository {
  fun getFormulas(): List<FormulaItem> {
    return ComprehensiveFormulaHandbookBank.getAllFormulas()
  }
}

data class FormulaSubjectInfo(
  val code: String,
  val nameSinhala: String,
  val nameEnglish: String,
  val icon: String,
  val subtitle: String,
  val accentColor: Color,
  val secondaryColor: Color,
  val borderColor: Color,
  val tagText: String
)

val formulaSubjectsList = listOf(
  FormulaSubjectInfo(
    code = "MATH",
    nameSinhala = "ගණිතය",
    nameEnglish = "Mathematics",
    icon = "📐",
    subtitle = "වීජ ගණිතය • ජ්‍යාමිතිය • මිනුම් • සංඛ්‍යානය • මූල්‍ය",
    accentColor = Color(0xFF2563EB),
    secondaryColor = Color(0xFFEFF6FF),
    borderColor = Color(0xFFBFDBFE),
    tagText = "සූත්‍ර 35+"
  ),
  FormulaSubjectInfo(
    code = "SCIENCE",
    nameSinhala = "විද්‍යාව",
    nameEnglish = "Science",
    icon = "⚛️",
    subtitle = "භෞතික • රසායනික • ජීව විද්‍යා නියම & සමීකරණ",
    accentColor = Color(0xFF059669),
    secondaryColor = Color(0xFFECFDF5),
    borderColor = Color(0xFFA7F3D0),
    tagText = "නියම 35+"
  ),
  FormulaSubjectInfo(
    code = "TIMELINE",
    nameSinhala = "ඉතිහාසය කාලරේඛාව",
    nameEnglish = "History Timeline",
    icon = "🏛️",
    subtitle = "පුරාතන රාජධානි • සන්ධිස්ථාන • ලෝක ඉතිහාසය",
    accentColor = Color(0xFFD97706),
    secondaryColor = Color(0xFFFFFBEB),
    borderColor = Color(0xFFFDE68A),
    tagText = "සිදුවීම් 35+"
  ),
  FormulaSubjectInfo(
    code = "COMMERCE",
    nameSinhala = "ව්‍යාපාර හා ගිණුම්කරණය",
    nameEnglish = "Commerce & Accounts",
    icon = "📊",
    subtitle = "ද්විත්ව සටහන් • ගිණුම් සමීකරණ • මූල්‍ය අනුපාත",
    accentColor = Color(0xFF7C3AED),
    secondaryColor = Color(0xFFFAF5FF),
    borderColor = Color(0xFFE9D5FF),
    tagText = "සමීකරණ 18+"
  ),
  FormulaSubjectInfo(
    code = "ICT",
    nameSinhala = "තොරතුරු තාක්ෂණය (ICT)",
    nameEnglish = "Information Technology",
    icon = "💻",
    subtitle = "ද්විමය පද්ධති • බූලීය වීජ ගණිතය • තර්ක ද්වාර & ශ්‍රිත",
    accentColor = Color(0xFF0284C7),
    secondaryColor = Color(0xFFF0F9FF),
    borderColor = Color(0xFFBAE6FD),
    tagText = "නීති 18+"
  ),
  FormulaSubjectInfo(
    code = "GEOGRAPHY",
    nameSinhala = "භූගෝල විද්‍යාව",
    nameEnglish = "Geography",
    icon = "🌍",
    subtitle = "සිතියම් පරිමාණ • සමෝච්ච රේඛා • දේශගුණ කලාප",
    accentColor = Color(0xFF0D9488),
    secondaryColor = Color(0xFFF0FDFA),
    borderColor = Color(0xFF99F6E4),
    tagText = "මූලධර්ම 15+"
  ),
  FormulaSubjectInfo(
    code = "CIVICS",
    nameSinhala = "පුරවැසි අධ්‍යාපනය",
    nameEnglish = "Civics & Governance",
    icon = "⚖️",
    subtitle = "පාර්ලිමේන්තුව • ආණ්ඩුක්‍රම ව්‍යවස්ථාව • අයිතිවාසිකම්",
    accentColor = Color(0xFFE11D48),
    secondaryColor = Color(0xFFFFF1F2),
    borderColor = Color(0xFFFECDD3),
    tagText = "ව්‍යවස්ථා 15+"
  ),
  FormulaSubjectInfo(
    code = "BUDDHISM",
    nameSinhala = "බුද්ධ ධර්මය",
    nameEnglish = "Buddhism",
    icon = "☸️",
    subtitle = "චතුරාර්ය සත්‍යය • පටිච්චසමුප්පාදය • ධර්ම සංගායනා",
    accentColor = Color(0xFFEA580C),
    secondaryColor = Color(0xFFFFF7ED),
    borderColor = Color(0xFFFFEDD5),
    tagText = "සංකල්ප 15+"
  ),
  FormulaSubjectInfo(
    code = "ENGLISH",
    nameSinhala = "ඉංග්‍රීසි (English)",
    nameEnglish = "English Language",
    icon = "📝",
    subtitle = "12 Tenses • Passive Voice • Conditionals",
    accentColor = Color(0xFF4F46E5),
    secondaryColor = Color(0xFFEEF2FF),
    borderColor = Color(0xFFC7D2FE),
    tagText = "Structures 15+"
  ),
  FormulaSubjectInfo(
    code = "SINHALA",
    nameSinhala = "සිංහල භාෂාව",
    nameEnglish = "Sinhala Grammar",
    icon = "📖",
    subtitle = "සන්ධි ක්‍රම 10 • උක්ත ආඛ්‍යාත • නාම විභක්ති 9",
    accentColor = Color(0xFFDC2626),
    secondaryColor = Color(0xFFFEF2F2),
    borderColor = Color(0xFFFECACA),
    tagText = "රීති 15+"
  ),
  FormulaSubjectInfo(
    code = "HEALTH",
    nameSinhala = "සෞඛ්‍ය හා ශාරීරික",
    nameEnglish = "Health & PE",
    icon = "🏃",
    subtitle = "BMI සූත්‍රය • හෘද ස්පන්දන වේගය • RICE ප්‍රථමාධාර",
    accentColor = Color(0xFF16A34A),
    secondaryColor = Color(0xFFF0FDF4),
    borderColor = Color(0xFFBBF7D0),
    tagText = "සූත්‍ර 12+"
  )
)

@Composable
fun SubjectMiniCard(
  subj: FormulaSubjectInfo,
  onClick: () -> Unit
) {
  Card(
    onClick = onClick,
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(containerColor = subj.secondaryColor),
    border = BorderStroke(1.2.dp, subj.borderColor),
    modifier = Modifier
      .fillMaxWidth()
      .height(118.dp)
  ) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
      verticalArrangement = Arrangement.SpaceBetween
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Box(
          modifier = Modifier
            .size(34.dp)
            .clip(CircleShape)
            .background(subj.accentColor.copy(alpha = 0.15f)),
          contentAlignment = Alignment.Center
        ) {
          Text(text = subj.icon, fontSize = 17.sp)
        }
        Surface(
          shape = RoundedCornerShape(10.dp),
          color = subj.accentColor.copy(alpha = 0.15f)
        ) {
          Text(
            text = subj.tagText,
            fontSize = 9.5.sp,
            fontWeight = FontWeight.Bold,
            color = subj.accentColor,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
          )
        }
      }

      Column {
        Text(
          text = subj.nameSinhala,
          fontSize = 13.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFF0F172A),
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )
        Text(
          text = subj.nameEnglish,
          fontSize = 10.sp,
          color = subj.accentColor,
          fontWeight = FontWeight.SemiBold,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )
      }

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = subj.subtitle,
          fontSize = 8.5.sp,
          color = Color(0xFF64748B),
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "විවෘත කරන්න →",
          fontSize = 9.sp,
          fontWeight = FontWeight.Bold,
          color = subj.accentColor
        )
      }
    }
  }
}

@Composable
fun FormulaAndTimelineHubScreen(
  onBack: () -> Unit,
  initialQuery: String = "",
  initialCategory: String = "ALL",
  initialGrade: String = "ALL",
  lockedSubjectName: String? = null
) {
  val lockedCategory = remember(lockedSubjectName) {
    when {
      lockedSubjectName != null && lockedSubjectName.contains("විද්‍යාව") && !lockedSubjectName.contains("භූගෝල") -> "SCIENCE"
      lockedSubjectName != null && lockedSubjectName.contains("ගණිත") -> "MATH"
      lockedSubjectName != null && (lockedSubjectName.contains("ව්‍යාපාර") || lockedSubjectName.contains("ගිණුම්")) -> "COMMERCE"
      lockedSubjectName != null && (lockedSubjectName.contains("තොරතුරු") || lockedSubjectName.contains("ICT", ignoreCase = true)) -> "ICT"
      lockedSubjectName != null && lockedSubjectName.contains("ඉතිහාස") -> "TIMELINE"
      lockedSubjectName != null && lockedSubjectName.contains("භූගෝල") -> "GEOGRAPHY"
      lockedSubjectName != null && lockedSubjectName.contains("පුරවැසි") -> "CIVICS"
      lockedSubjectName != null && lockedSubjectName.contains("බුද්ධ") -> "BUDDHISM"
      lockedSubjectName != null && (lockedSubjectName.contains("ඉංග්‍රීසි") || lockedSubjectName.contains("English", ignoreCase = true)) -> "ENGLISH"
      lockedSubjectName != null && lockedSubjectName.contains("සිංහල") -> "SINHALA"
      lockedSubjectName != null && (lockedSubjectName.contains("සෞඛ්‍ය") || lockedSubjectName.contains("ශාරීරික")) -> "HEALTH"
      initialCategory in listOf("SCIENCE", "MATH", "COMMERCE", "ICT", "TIMELINE", "GEOGRAPHY", "CIVICS", "BUDDHISM", "ENGLISH", "SINHALA", "HEALTH") -> initialCategory
      else -> null
    }
  }

  // Active Subject selection: null means user is on the Initial Subject Selection Screen!
  var activeSubject by remember(lockedCategory) { mutableStateOf<String?>(lockedCategory) }
  var subjectSearchQuery by remember { mutableStateOf("") }

  var selectedGrade by remember(initialGrade) { mutableStateOf(if (initialGrade.isNotBlank() && initialGrade != "ALL") initialGrade else "ALL") }
  var selectedCategory by remember(activeSubject) {
    mutableStateOf("ALL_SUBJECT")
  }
  var searchQuery by remember(initialQuery) { mutableStateOf(initialQuery) }
  var formulaList by remember { mutableStateOf(FormulaRepository.getFormulas()) }
  var fullScreenFormulaItem by remember { mutableStateOf<FormulaItem?>(null) }
  var isFilterExpanded by remember { mutableStateOf(true) }
  var isFullScreenReadingMode by remember { mutableStateOf(false) }

  // Handle hardware / gesture back button
  if (activeSubject != null && lockedCategory == null) {
    BackHandler {
      activeSubject = null
      searchQuery = ""
      selectedGrade = "ALL"
      selectedCategory = "ALL_SUBJECT"
    }
  }

  val filtered = remember(formulaList, activeSubject, selectedGrade, selectedCategory, searchQuery) {
    if (activeSubject == null) {
      emptyList()
    } else {
      formulaList.filter { item ->
        val matchesSubject = when (activeSubject) {
          "MATH" -> item.category == "MATH"
          "SCIENCE" -> item.category == "SCIENCE"
          "TIMELINE" -> item.category == "TIMELINE"
          "COMMERCE" -> item.category == "COMMERCE"
          "ICT" -> item.category == "ICT"
          "GEOGRAPHY" -> item.category == "GEOGRAPHY"
          "CIVICS" -> item.category == "CIVICS"
          "BUDDHISM" -> item.category == "BUDDHISM" || item.subject.contains("බුද්ධ")
          "ENGLISH" -> item.category == "ENGLISH" || item.subject.contains("ඉංග්‍රීසි")
          "SINHALA" -> item.category == "SINHALA" || item.subject.contains("සිංහල")
          "HEALTH" -> item.category == "HEALTH" || item.subject.contains("සෞඛ්‍ය")
          else -> item.category == activeSubject
        }
        if (!matchesSubject) return@filter false

        val matchesGrade = selectedGrade == "ALL" || item.grade == "ALL" || item.grade == selectedGrade

        val matchesSubCat = when (selectedCategory) {
          "ALL_SUBJECT", "ALL" -> true
          "SAVED" -> item.isBookmarked
          "PHYSICS" -> item.unitsOrEra.contains("භෞතික") || item.unitsOrEra.contains("යාන්ත්‍ර") ||
              item.formula.contains("v =") || item.formula.contains("F =") || item.formula.contains("ρ =") ||
              item.formula.contains("P =") || item.formula.contains("V =") || item.formula.contains("E =") ||
              item.explanation.contains("ප්‍රවේගය") || item.explanation.contains("ත්වරණය") || item.explanation.contains("බලය")
          "CHEMISTRY" -> item.unitsOrEra.contains("රසායන") || item.formula.contains("mol") ||
              item.formula.contains("C =") || item.explanation.contains("මවුල") || item.explanation.contains("ද්‍රාවණ") ||
              item.nameSinhala.contains("මවුල") || item.nameSinhala.contains("සාන්ද්‍රණ") || item.nameSinhala.contains("ප්‍රතික්‍රියා")
          "BIOLOGY" -> item.unitsOrEra.contains("ජීව") || item.explanation.contains("සෛල") ||
              item.explanation.contains("රුධිර") || item.nameSinhala.contains("ජීව") || item.nameSinhala.contains("ශ්වසන") ||
              item.nameSinhala.contains("ප්‍රභාසංස්ලේෂණ")
          "ELECTRICITY" -> item.unitsOrEra.contains("විද්‍යුත්") || item.formula.contains("I =") ||
              item.formula.contains("R =") || item.formula.contains("V =") || item.explanation.contains("ධාරා") ||
              item.nameSinhala.contains("ඕම්") || item.nameSinhala.contains("විද්‍යුත්")
          "ALGEBRA" -> item.unitsOrEra.contains("වීජ") || item.unitsOrEra.contains("සාධක")
          "GEOMETRY" -> item.unitsOrEra.contains("ජ්‍යාමිතිය") || item.unitsOrEra.contains("ත්‍රිකෝණ") || item.unitsOrEra.contains("වෘත්ත")
          "STATS" -> item.unitsOrEra.contains("සංඛ්‍යාන") || item.unitsOrEra.contains("සම්භාවිතා")
          "FINANCE" -> item.unitsOrEra.contains("මූල්‍ය") || item.unitsOrEra.contains("පොලිය")
          else -> true
        }

        val matchesSearch = searchQuery.isEmpty() ||
            item.nameSinhala.contains(searchQuery, ignoreCase = true) ||
            item.formula.contains(searchQuery, ignoreCase = true) ||
            item.explanation.contains(searchQuery, ignoreCase = true) ||
            item.subject.contains(searchQuery, ignoreCase = true) ||
            item.unitsOrEra.contains(searchQuery, ignoreCase = true) ||
            item.examTip.contains(searchQuery, ignoreCase = true)

        matchesGrade && matchesSubCat && matchesSearch
      }
    }
  }

  // Full Screen Distraction-Free Formula Reader Dialog
  if (fullScreenFormulaItem != null) {
    FullScreenFormulaReader(
      item = fullScreenFormulaItem!!,
      onToggleBookmark = {
        formulaList = formulaList.map {
          if (it.id == fullScreenFormulaItem!!.id) {
            val updated = it.copy(isBookmarked = !it.isBookmarked)
            fullScreenFormulaItem = updated
            updated
          } else it
        }
      },
      onDismiss = { fullScreenFormulaItem = null }
    )
  }

  Scaffold(
    containerColor = Color(0xFFF8FAFC),
    floatingActionButton = {
      if (isFullScreenReadingMode) {
        FloatingActionButton(
          onClick = { isFullScreenReadingMode = false },
          containerColor = BluePrimary,
          contentColor = Color.White
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Icon(Icons.Default.Close, contentDescription = "Exit Fullscreen")
            Spacer(modifier = Modifier.width(4.dp))
            Text("සාමාන්‍ය තිරය", fontSize = 12.sp, fontWeight = FontWeight.Bold)
          }
        }
      }
    }
  ) { paddingValues ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFF8FAFC))
        .padding(paddingValues)
        .padding(horizontal = 12.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp),
      contentPadding = PaddingValues(top = 8.dp, bottom = 32.dp)
    ) {
      if (activeSubject == null) {
        // ================================================================
        // 🌟 INITIAL SCREEN: SUBJECT SELECTION ONLY (NO CONTENT ITEMS SHOWN)
        // ================================================================
        item(key = "subject_selection_header") {
          Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
          ) {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Surface(
                onClick = onBack,
                shape = CircleShape,
                color = Color(0xFFF1F5F9)
              ) {
                Icon(
                  imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                  contentDescription = "Back",
                  tint = Color(0xFF1E293B),
                  modifier = Modifier.padding(6.dp).size(18.dp)
                )
              }
              Spacer(modifier = Modifier.width(10.dp))
              Column(modifier = Modifier.weight(1f)) {
                Text(
                  text = "සූත්‍ර හා ඉතිහාස කාලරේඛාව",
                  style = MaterialTheme.typography.titleMedium,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF0F172A)
                )
                Text(
                  text = "විෂයක් තෝරා O/L සූත්‍ර, නීති හා කාලරේඛා අධ්‍යයනය කරන්න",
                  fontSize = 11.sp,
                  color = Color(0xFF64748B)
                )
              }
              Surface(
                shape = RoundedCornerShape(12.dp),
                color = BluePrimary.copy(alpha = 0.1f)
              ) {
                Text(
                  text = "විෂයන් 11",
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = BluePrimary,
                  modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
                )
              }
            }
          }
        }

        // Search Bar for Subjects
        item(key = "subject_search_bar") {
          OutlinedTextField(
            value = subjectSearchQuery,
            onValueChange = { subjectSearchQuery = it },
            placeholder = {
              Text("විෂය නම හෝ මාතෘකාව සොයන්න (උදා: ගණිතය, විද්‍යාව, ඉතිහාසය...)", fontSize = 11.5.sp)
            },
            leadingIcon = {
              Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF64748B), modifier = Modifier.size(18.dp))
            },
            trailingIcon = {
              if (subjectSearchQuery.isNotBlank()) {
                IconButton(onClick = { subjectSearchQuery = "" }) {
                  Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color(0xFF64748B), modifier = Modifier.size(16.dp))
                }
              }
            },
            singleLine = true,
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
              unfocusedContainerColor = Color.White,
              focusedContainerColor = Color.White,
              unfocusedBorderColor = Color(0xFFCBD5E1),
              focusedBorderColor = BluePrimary
            ),
            modifier = Modifier.fillMaxWidth().height(48.dp)
          )
        }

        // Title Row for subjects
        item(key = "subject_section_label") {
          Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "📂 විෂය තෝරන්න (Select Subject):",
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF1E293B),
              modifier = Modifier.weight(1f)
            )
            Surface(
              shape = RoundedCornerShape(4.dp),
              color = Color(0xFFD1FAE5)
            ) {
              Text(
                text = "100% O/L සිලබස්",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF047857),
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
          }
        }

        // Filtered subjects list
        val displayedSubjects = formulaSubjectsList.filter { subj ->
          subjectSearchQuery.isBlank() ||
              subj.nameSinhala.contains(subjectSearchQuery, ignoreCase = true) ||
              subj.nameEnglish.contains(subjectSearchQuery, ignoreCase = true) ||
              subj.subtitle.contains(subjectSearchQuery, ignoreCase = true)
        }

        // 2-column Grid of Colorful Compact Subject Cards
        val chunkedSubjects = displayedSubjects.chunked(2)
        items(chunkedSubjects) { rowItems ->
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            rowItems.forEach { subj ->
              Box(modifier = Modifier.weight(1f)) {
                SubjectMiniCard(
                  subj = subj,
                  onClick = {
                    activeSubject = subj.code
                    selectedCategory = "ALL_SUBJECT"
                    searchQuery = ""
                  }
                )
              }
            }
            if (rowItems.size == 1) {
              Spacer(modifier = Modifier.weight(1f))
            }
          }
        }
      } else {
        // ================================================================
        // 🌟 SUBJECT CONTENT SCREEN (SHOWN ONLY WHEN A SUBJECT IS CLICKED)
        // ================================================================
        val currentSubjInfo = formulaSubjectsList.find { it.code == activeSubject } ?: formulaSubjectsList.first()

        // 1. Top Header
        if (!isFullScreenReadingMode) {
          item(key = "content_top_header") {
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color.White),
              elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Row(
                  verticalAlignment = Alignment.CenterVertically,
                  modifier = Modifier.weight(1f)
                ) {
                  Surface(
                    onClick = {
                      if (lockedCategory == null) {
                        activeSubject = null
                      } else {
                        onBack()
                      }
                    },
                    shape = CircleShape,
                    color = Color(0xFFF1F5F9)
                  ) {
                    Icon(
                      imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                      contentDescription = "Back",
                      tint = Color(0xFF1E293B),
                      modifier = Modifier.padding(6.dp).size(18.dp)
                    )
                  }
                  Spacer(modifier = Modifier.width(8.dp))
                  Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                      Text(
                        text = "${currentSubjInfo.icon} ${currentSubjInfo.nameSinhala}",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                      )
                      Spacer(modifier = Modifier.width(6.dp))
                      Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = currentSubjInfo.accentColor.copy(alpha = 0.12f)
                      ) {
                        Text(
                          text = "${filtered.size} items",
                          fontSize = 10.sp,
                          fontWeight = FontWeight.Bold,
                          color = currentSubjInfo.accentColor,
                          modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
                        )
                      }
                    }
                    Text(
                      text = "${currentSubjInfo.nameEnglish} • Scroll කර සම්පූර්ණ තිරයෙන් කියවන්න",
                      fontSize = 10.sp,
                      color = Color(0xFF64748B)
                    )
                  }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                  Surface(
                    onClick = { isFullScreenReadingMode = true },
                    shape = RoundedCornerShape(8.dp),
                    color = currentSubjInfo.accentColor.copy(alpha = 0.1f),
                    modifier = Modifier.padding(end = 4.dp)
                  ) {
                    Row(
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp),
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Text("⛶", fontSize = 12.sp)
                      Spacer(modifier = Modifier.width(3.dp))
                      Text(
                        text = "ෆුල් ස්ක්‍රීන්",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = currentSubjInfo.accentColor
                      )
                    }
                  }

                  IconButton(
                    onClick = { isFilterExpanded = !isFilterExpanded },
                    modifier = Modifier.size(32.dp)
                  ) {
                    Icon(
                      imageVector = if (isFilterExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                      contentDescription = "Toggle Filters",
                      tint = currentSubjInfo.accentColor
                    )
                  }
                }
              }
            }
          }
        }

        // 2. "විෂය තෝරාගන්න තීරුවක් දෙන්න" (Horizontal Subject Switcher Bar)
        if (!isFullScreenReadingMode) {
          item(key = "subject_selector_row_bar") {
            LazyRow(
              horizontalArrangement = Arrangement.spacedBy(6.dp),
              modifier = Modifier.fillMaxWidth()
            ) {
              if (lockedCategory == null) {
                item {
                  Surface(
                    onClick = { activeSubject = null },
                    shape = RoundedCornerShape(20.dp),
                    color = Color(0xFF1E293B),
                    border = BorderStroke(1.dp, Color(0xFF334155))
                  ) {
                    Row(
                      modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "All Subjects",
                        tint = Color.White,
                        modifier = Modifier.size(13.dp)
                      )
                      Spacer(modifier = Modifier.width(4.dp))
                      Text(
                        text = "සියලු විෂයන් (Cards)",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                      )
                    }
                  }
                }
              }

              items(formulaSubjectsList) { subj ->
                val isCurrent = activeSubject == subj.code
                Surface(
                  onClick = {
                    activeSubject = subj.code
                    selectedCategory = "ALL_SUBJECT"
                    searchQuery = ""
                  },
                  shape = RoundedCornerShape(20.dp),
                  color = if (isCurrent) subj.accentColor else subj.secondaryColor,
                  border = BorderStroke(1.dp, if (isCurrent) subj.accentColor else subj.borderColor)
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(subj.icon, fontSize = 12.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                      text = subj.nameSinhala,
                      fontSize = 11.sp,
                      fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Medium,
                      color = if (isCurrent) Color.White else Color(0xFF1E293B)
                    )
                  }
                }
              }
            }
          }
        }

        // 3. Collapsible Filter Controls Section (Search, Grade, Sub-categories)
        if (isFilterExpanded && !isFullScreenReadingMode) {
          item(key = "filter_controls_card") {
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color.White),
              elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
              Column(modifier = Modifier.padding(10.dp)) {
                // Search Bar
                OutlinedTextField(
                  value = searchQuery,
                  onValueChange = { searchQuery = it },
                  placeholder = {
                    val hint = when (activeSubject) {
                      "SCIENCE" -> "විද්‍යා සූත්‍රයක්, නියමයක් හෝ ඒකකයක් සොයන්න..."
                      "MATH" -> "ගණිත සූත්‍රයක්, ප්‍රමේයයක් හෝ සමීකරණයක් සොයන්න..."
                      "COMMERCE" -> "ගිණුම්කරණ සමීකරණයක් සොයන්න..."
                      "ICT" -> "ICT සූත්‍රයක්, ද්විමය හෝ ද්වාරයක් සොයන්න..."
                      "TIMELINE" -> "ඉතිහාස සිදුවීමක් හෝ වර්ෂයක් සොයන්න..."
                      "GEOGRAPHY" -> "භූගෝල විද්‍යා සංකල්පයක් සොයන්න..."
                      "CIVICS" -> "ව්‍යවස්ථාවක් හෝ අයිතිවාසිකමක් සොයන්න..."
                      "BUDDHISM" -> "බෞද්ධ ධර්ම සංකල්පයක් සොයන්න..."
                      "ENGLISH" -> "Grammar rule, tense, formula..."
                      "SINHALA" -> "සිංහල ව්‍යාකරණ නීතියක් සොයන්න..."
                      "HEALTH" -> "සෞඛ්‍ය සූත්‍රයක් හෝ ප්‍රථමාධාර සොයන්න..."
                      else -> "සූත්‍රයක්, නියමයක්, වර්ෂයක් සොයන්න..."
                    }
                    Text(hint, fontSize = 11.5.sp)
                  },
                  leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF64748B), modifier = Modifier.size(18.dp)) },
                  trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                      IconButton(onClick = { searchQuery = "" }) {
                        Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color(0xFF64748B), modifier = Modifier.size(16.dp))
                      }
                    }
                  },
                  singleLine = true,
                  shape = RoundedCornerShape(10.dp),
                  colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF8FAFC),
                    focusedContainerColor = Color.White,
                    unfocusedBorderColor = Color(0xFFCBD5E1),
                    focusedBorderColor = currentSubjInfo.accentColor
                  ),
                  modifier = Modifier.fillMaxWidth().height(46.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Grade Selector Tabs
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                  val grades = listOf(
                    "ALL" to "සියලු ශ්‍රේණි",
                    "10" to "10 ශ්‍රේණිය",
                    "11" to "11 ශ්‍රේණිය (O/L)"
                  )
                  grades.forEach { (code, label) ->
                    val isGradeSelected = selectedGrade == code
                    Surface(
                      onClick = { selectedGrade = code },
                      shape = RoundedCornerShape(16.dp),
                      color = if (isGradeSelected) Color(0xFF1E293B) else Color(0xFFF1F5F9),
                      border = BorderStroke(1.dp, if (isGradeSelected) Color(0xFF1E293B) else Color(0xFFE2E8F0)),
                      modifier = Modifier.weight(1f)
                    ) {
                      Text(
                        text = label,
                        fontSize = 10.5.sp,
                        fontWeight = if (isGradeSelected) FontWeight.Bold else FontWeight.Medium,
                        color = if (isGradeSelected) Color.White else Color(0xFF475569),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 5.dp)
                      )
                    }
                  }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Sub-category filters for the active subject
                val subCategories: List<Pair<String, String>> = when (activeSubject) {
                  "SCIENCE" -> listOf(
                    "ALL_SUBJECT" to "⚛️ සියලු විද්‍යා සූත්‍ර (${filtered.size})",
                    "PHYSICS" to "⚡ භෞතික & චලිතය",
                    "ELECTRICITY" to "💡 ධාරා විද්‍යුතය",
                    "CHEMISTRY" to "🧪 රසායනික විද්‍යාව",
                    "BIOLOGY" to "🔬 ජීව විද්‍යාව",
                    "SAVED" to "⭐ සුරකින ලද"
                  )
                  "MATH" -> listOf(
                    "ALL_SUBJECT" to "📐 සියලු ගණිත සූත්‍ර (${filtered.size})",
                    "ALGEBRA" to "🔢 වීජ ගණිතය",
                    "GEOMETRY" to "📐 ජ්‍යාමිතිය & ත්‍රිකෝණ",
                    "STATS" to "📊 සංඛ්‍යානය & මිනුම්",
                    "FINANCE" to "💰 මූල්‍ය ගණිතය",
                    "SAVED" to "⭐ සුරකින ලද"
                  )
                  "COMMERCE" -> listOf(
                    "ALL_SUBJECT" to "📊 සියලු ගිණුම්කරණ සූත්‍ර (${filtered.size})",
                    "SAVED" to "⭐ සුරකින ලද"
                  )
                  "ICT" -> listOf(
                    "ALL_SUBJECT" to "💻 සියලු ICT නීති & සූත්‍ර (${filtered.size})",
                    "SAVED" to "⭐ සුරකින ලද"
                  )
                  "TIMELINE" -> listOf(
                    "ALL_SUBJECT" to "🏛️ සියලු ඉතිහාස සිදුවීම් (${filtered.size})",
                    "SAVED" to "⭐ සුරකින ලද"
                  )
                  "GEOGRAPHY" -> listOf(
                    "ALL_SUBJECT" to "🌍 සියලු භූගෝලීය සංකල්ප (${filtered.size})",
                    "SAVED" to "⭐ සුරකින ලද"
                  )
                  "CIVICS" -> listOf(
                    "ALL_SUBJECT" to "⚖️ සියලු පුරවැසි මූලධර්ම (${filtered.size})",
                    "SAVED" to "⭐ සුරකින ලද"
                  )
                  "BUDDHISM" -> listOf(
                    "ALL_SUBJECT" to "☸️ සියලු බෞද්ධ සංකල්ප (${filtered.size})",
                    "SAVED" to "⭐ සුරකින ලද"
                  )
                  "ENGLISH" -> listOf(
                    "ALL_SUBJECT" to "📝 All Grammar Structures (${filtered.size})",
                    "SAVED" to "⭐ Bookmarked"
                  )
                  "SINHALA" -> listOf(
                    "ALL_SUBJECT" to "📖 සියලු සිංහල ව්‍යාකරණ රීති (${filtered.size})",
                    "SAVED" to "⭐ සුරකින ලද"
                  )
                  "HEALTH" -> listOf(
                    "ALL_SUBJECT" to "🏃 සියලු සෞඛ්‍ය සූත්‍ර (${filtered.size})",
                    "SAVED" to "⭐ සුරකින ලද"
                  )
                  else -> listOf(
                    "ALL_SUBJECT" to "🌐 සියල්ල (${filtered.size})",
                    "SAVED" to "⭐ සුරකින ලද"
                  )
                }

                LazyRow(
                  horizontalArrangement = Arrangement.spacedBy(6.dp),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  items(subCategories) { (code, label) ->
                    val isSelected = selectedCategory == code
                    Surface(
                      onClick = { selectedCategory = code },
                      shape = RoundedCornerShape(8.dp),
                      color = if (isSelected) currentSubjInfo.accentColor else Color(0xFFF1F5F9),
                      border = BorderStroke(1.dp, if (isSelected) currentSubjInfo.accentColor else Color(0xFFCBD5E1))
                    ) {
                      Text(
                        text = label,
                        fontSize = 10.5.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSelected) Color.White else Color(0xFF334155),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)
                      )
                    }
                  }
                }
              }
            }
          }
        }

        // 4. Content Formula Items
        if (filtered.isEmpty()) {
          item(key = "empty_content_state") {
            Box(
              modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp),
              contentAlignment = Alignment.Center
            ) {
              Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                  text = if (selectedCategory == "SAVED") "තවමත් කිසිදු සූත්‍රයක් Save කර නොමැත. ⭐ තට්ටු කර Save කරගන්න." else "ගැළපෙන සූත්‍රයක් හමු නොවීය.",
                  color = Color(0xFF64748B),
                  fontSize = 13.sp,
                  textAlign = TextAlign.Center
                )
                if (searchQuery.isNotEmpty() || selectedGrade != "ALL" || selectedCategory != "ALL_SUBJECT") {
                  Spacer(modifier = Modifier.height(10.dp))
                  OutlinedButton(
                    onClick = {
                      searchQuery = ""
                      selectedGrade = "ALL"
                      selectedCategory = "ALL_SUBJECT"
                    },
                    shape = RoundedCornerShape(8.dp)
                  ) {
                    Text("සියලු ෆිල්ටර් ඉවත් කරන්න", fontSize = 11.sp)
                  }
                }
              }
            }
          }
        } else {
          items(filtered, key = { it.id }) { formula ->
            FormulaCard(
              item = formula,
              onOpenFullScreen = { fullScreenFormulaItem = formula },
              onToggleBookmark = {
                formulaList = formulaList.map {
                  if (it.id == formula.id) it.copy(isBookmarked = !it.isBookmarked) else it
                }
              }
            )
          }
        }
      }
    }
  }
}

@Composable
fun FormulaCard(
  item: FormulaItem,
  onOpenFullScreen: () -> Unit = {},
  onToggleBookmark: () -> Unit
) {
  val context = LocalContext.current
  val clipboardManager = LocalClipboardManager.current

  val cardBg = when (item.category) {
    "MATH" -> Color(0xFFEFF6FF)
    "SCIENCE" -> Color(0xFFF0FDF4)
    "TIMELINE" -> Color(0xFFFAF5FF)
    "ICT" -> Color(0xFFF0F9FF)
    "COMMERCE" -> Color(0xFFFFFBEB)
    "GEOGRAPHY" -> Color(0xFFF0FDFA)
    "CIVICS" -> Color(0xFFFFF1F2)
    else -> Color(0xFFF8FAFC)
  }

  val accentColor = when (item.category) {
    "MATH" -> Color(0xFF1D4ED8)
    "SCIENCE" -> Color(0xFF15803D)
    "TIMELINE" -> Color(0xFF7E22CE)
    "ICT" -> Color(0xFF0284C7)
    "COMMERCE" -> Color(0xFFB45309)
    "GEOGRAPHY" -> Color(0xFF0D9488)
    "CIVICS" -> Color(0xFFE11D48)
    else -> Color(0xFF475569)
  }

  Card(
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
    modifier = Modifier
      .fillMaxWidth()
      .clickable(onClick = onOpenFullScreen)
  ) {
    Column(modifier = Modifier.padding(14.dp)) {
      // Header tag row
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          Surface(
            shape = RoundedCornerShape(6.dp),
            color = cardBg
          ) {
            Text(
              text = item.unitsOrEra,
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              color = accentColor,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }

          if (item.grade != "ALL") {
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFFF1F5F9)
            ) {
              Text(
                text = "${item.grade} ශ්‍රේණිය",
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF475569),
                modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
              )
            }
          }
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
          IconButton(
            onClick = {
              if (AppSecurityManager.canCopyContent(context)) {
                clipboardManager.setText(AnnotatedString(item.formula))
                Toast.makeText(context, "සූත්‍රය පිටපත් විය (Copied)", Toast.LENGTH_SHORT).show()
              } else {
                Toast.makeText(context, "ආරක්ෂක නීති අනුව සටහන් පිටපත් කිරීම (Copy) අවහිර කර ඇත (Admin Only).", Toast.LENGTH_SHORT).show()
              }
            },
            modifier = Modifier.size(28.dp)
          ) {
            Icon(
              imageVector = Icons.Default.ContentCopy,
              contentDescription = "Copy Formula",
              tint = Color(0xFF64748B),
              modifier = Modifier.size(16.dp)
            )
          }

          IconButton(
            onClick = onOpenFullScreen,
            modifier = Modifier.size(28.dp)
          ) {
            Icon(
              imageVector = Icons.Default.Fullscreen,
              contentDescription = "Full Screen",
              tint = Color(0xFF64748B),
              modifier = Modifier.size(18.dp)
            )
          }

          IconButton(
            onClick = onToggleBookmark,
            modifier = Modifier.size(28.dp)
          ) {
            Icon(
              imageVector = Icons.Default.Star,
              contentDescription = "Bookmark",
              tint = if (item.isBookmarked) Color(0xFFF59E0B) else Color(0xFFCBD5E1),
              modifier = Modifier.size(20.dp)
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(6.dp))

      Text(
        text = item.nameSinhala,
        style = MaterialTheme.typography.titleSmall,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF0F172A)
      )

      Spacer(modifier = Modifier.height(8.dp))

      // Highlighted Formula Box
      Surface(
        onClick = onOpenFullScreen,
        shape = RoundedCornerShape(10.dp),
        color = cardBg,
        border = BorderStroke(1.dp, accentColor.copy(alpha = 0.3f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Row(
          modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Text(
            text = item.formula,
            fontSize = 13.sp,
            fontWeight = FontWeight.Black,
            color = accentColor,
            modifier = Modifier.weight(1f)
          )
          Icon(
            imageVector = Icons.Default.Fullscreen,
            contentDescription = null,
            tint = accentColor.copy(alpha = 0.6f),
            modifier = Modifier.size(16.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      Text(
        text = item.explanation,
        fontSize = 11.sp,
        color = Color(0xFF475569),
        lineHeight = 15.sp
      )

      // Exam Tip if available
      if (item.examTip.isNotEmpty()) {
        Spacer(modifier = Modifier.height(8.dp))
        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFFFFFBEB),
          border = BorderStroke(1.dp, Color(0xFFFDE68A)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.Top
          ) {
            Text(
              text = "💡 ",
              fontSize = 11.sp
            )
            Text(
              text = item.examTip,
              fontSize = 10.sp,
              color = Color(0xFF92400E),
              fontWeight = FontWeight.Medium,
              lineHeight = 14.sp
            )
          }
        }
      }
    }
  }
}

/**
 * 100% Full-Screen, Distraction-Free Reading Mode for Formula Handbook and Timelines.
 */
@Composable
fun FullScreenFormulaReader(
  item: FormulaItem,
  onToggleBookmark: () -> Unit,
  onDismiss: () -> Unit
) {
  val context = LocalContext.current
  val clipboardManager = LocalClipboardManager.current
  var fontScaleFactor by remember { mutableStateOf(1.0f) }

  val cardBg = when (item.category) {
    "MATH" -> Color(0xFFEFF6FF)
    "SCIENCE" -> Color(0xFFF0FDF4)
    "TIMELINE" -> Color(0xFFFAF5FF)
    "ICT" -> Color(0xFFF0F9FF)
    "COMMERCE" -> Color(0xFFFFFBEB)
    "GEOGRAPHY" -> Color(0xFFF0FDFA)
    "CIVICS" -> Color(0xFFFFF1F2)
    else -> Color(0xFFF8FAFC)
  }

  val accentColor = when (item.category) {
    "MATH" -> Color(0xFF1D4ED8)
    "SCIENCE" -> Color(0xFF15803D)
    "TIMELINE" -> Color(0xFF7E22CE)
    "ICT" -> Color(0xFF0284C7)
    "COMMERCE" -> Color(0xFFB45309)
    "GEOGRAPHY" -> Color(0xFF0D9488)
    "CIVICS" -> Color(0xFFE11D48)
    else -> Color(0xFF475569)
  }

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(
      usePlatformDefaultWidth = false,
      decorFitsSystemWindows = false
    )
  ) {
    Surface(
      modifier = Modifier.fillMaxSize(),
      color = Color.White
    ) {
      Column(modifier = Modifier.fillMaxSize()) {
        // Top Navigation Bar
        Surface(
          color = Color(0xFF0F172A),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              modifier = Modifier.weight(1f)
            ) {
              IconButton(
                onClick = onDismiss,
                modifier = Modifier.size(38.dp)
              ) {
                Icon(
                  imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                  contentDescription = "Close Full Screen",
                  tint = Color.White,
                  modifier = Modifier.size(22.dp)
                )
              }

              Spacer(modifier = Modifier.width(6.dp))

              Column {
                Text(
                  text = item.nameSinhala,
                  fontWeight = FontWeight.Bold,
                  fontSize = 13.sp,
                  color = Color.White,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
                Text(
                  text = item.unitsOrEra,
                  fontSize = 10.sp,
                  color = Color(0xFF94A3B8)
                )
              }
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
              IconButton(
                onClick = {
                  if (AppSecurityManager.canCopyContent(context)) {
                    clipboardManager.setText(AnnotatedString(item.formula))
                    Toast.makeText(context, "සූත්‍රය පිටපත් විය (Copied)", Toast.LENGTH_SHORT).show()
                  } else {
                    Toast.makeText(context, "ආරක්ෂක නීති අනුව සටහන් පිටපත් කිරීම (Copy) අවහිර කර ඇත (Admin Only).", Toast.LENGTH_SHORT).show()
                  }
                },
                modifier = Modifier.size(32.dp)
              ) {
                Icon(
                  imageVector = Icons.Default.ContentCopy,
                  contentDescription = "Copy Formula",
                  tint = Color.White,
                  modifier = Modifier.size(18.dp)
                )
              }

              IconButton(
                onClick = { if (fontScaleFactor > 0.85f) fontScaleFactor -= 0.1f },
                modifier = Modifier.size(32.dp)
              ) {
                Text("A-", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
              }

              IconButton(
                onClick = { if (fontScaleFactor < 1.5f) fontScaleFactor += 0.1f },
                modifier = Modifier.size(32.dp)
              ) {
                Text("A+", color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Bold)
              }

              IconButton(
                onClick = onToggleBookmark,
                modifier = Modifier.size(36.dp)
              ) {
                Icon(
                  imageVector = Icons.Default.Star,
                  contentDescription = "Bookmark",
                  tint = if (item.isBookmarked) Color(0xFFF59E0B) else Color(0xFF94A3B8),
                  modifier = Modifier.size(20.dp)
                )
              }
            }
          }
        }

        // Reading Content Body
        Column(
          modifier = Modifier
            .weight(1f)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
          verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
          Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Surface(
              shape = RoundedCornerShape(8.dp),
              color = cardBg,
              border = BorderStroke(1.dp, accentColor.copy(alpha = 0.2f))
            ) {
              Text(
                text = "📌 ${item.unitsOrEra}",
                fontSize = (12 * fontScaleFactor).sp,
                fontWeight = FontWeight.Bold,
                color = accentColor,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
              )
            }

            if (item.grade != "ALL") {
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFF1F5F9)
              ) {
                Text(
                  text = "🎓 ${item.grade} ශ්‍රේණිය (O/L)",
                  fontSize = (11 * fontScaleFactor).sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF334155),
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)
                )
              }
            }
          }

          Text(
            text = item.nameSinhala,
            fontSize = (20 * fontScaleFactor).sp,
            fontWeight = FontWeight.Black,
            color = Color(0xFF0F172A),
            lineHeight = (26 * fontScaleFactor).sp
          )

          // Prominent Large Formula Box with Copy Button
          Surface(
            shape = RoundedCornerShape(16.dp),
            color = cardBg,
            border = BorderStroke(1.5.dp, accentColor),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(18.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = "⚡ සූත්‍රය / නියමය / කාලරේඛාව:",
                  fontSize = (12 * fontScaleFactor).sp,
                  fontWeight = FontWeight.Bold,
                  color = accentColor.copy(alpha = 0.8f)
                )
                OutlinedButton(
                  onClick = {
                    if (AppSecurityManager.canCopyContent(context)) {
                      clipboardManager.setText(AnnotatedString(item.formula))
                      Toast.makeText(context, "සූත්‍රය පිටපත් විය (Copied)", Toast.LENGTH_SHORT).show()
                    } else {
                      Toast.makeText(context, "ආරක්ෂක නීති අනුව සටහන් පිටපත් කිරීම (Copy) අවහිර කර ඇත (Admin Only).", Toast.LENGTH_SHORT).show()
                    }
                  },
                  shape = RoundedCornerShape(8.dp),
                  contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                  modifier = Modifier.height(28.dp)
                ) {
                  Icon(
                    imageVector = Icons.Default.ContentCopy,
                    contentDescription = null,
                    modifier = Modifier.size(12.dp)
                  )
                  Spacer(modifier = Modifier.width(4.dp))
                  Text("Copy", fontSize = 10.sp)
                }
              }
              Spacer(modifier = Modifier.height(8.dp))
              Text(
                text = item.formula,
                fontSize = (17 * fontScaleFactor).sp,
                fontWeight = FontWeight.ExtraBold,
                color = accentColor,
                lineHeight = (25 * fontScaleFactor).sp
              )
            }
          }

          // Full Explanation
          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC)),
            border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(18.dp)) {
              Text(
                text = "📖 සවිස්තරාත්මක විග්‍රහය සහ භාවිතය:",
                fontSize = (13 * fontScaleFactor).sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF334155)
              )
              Spacer(modifier = Modifier.height(8.dp))
              Text(
                text = item.explanation,
                fontSize = (15 * fontScaleFactor).sp,
                color = Color(0xFF1E293B),
                lineHeight = (22 * fontScaleFactor).sp
              )
            }
          }

          // Exam Tips & Shortcuts Card
          if (item.examTip.isNotEmpty()) {
            Card(
              shape = RoundedCornerShape(16.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFBEB)),
              border = BorderStroke(1.dp, Color(0xFFFDE68A)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(18.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text(
                    text = "💡 O/L විභාග උපදෙස් සහ කෙටි ක්‍රම (Exam Tip):",
                    fontSize = (13 * fontScaleFactor).sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF92400E)
                  )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                  text = item.examTip,
                  fontSize = (14 * fontScaleFactor).sp,
                  color = Color(0xFF78350F),
                  lineHeight = (20 * fontScaleFactor).sp
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(20.dp))
        }
      }
    }
  }
}

