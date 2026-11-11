package com.example

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class ScienceQuestionCategory(
  val displayName: String,
  val iconEmoji: String,
  val primaryColor: Color,
  val bgLightColor: Color
) {
  ALL("සියලු ප්‍රශ්න", "📚", Color(0xFF1E3A8A), Color(0xFFEFF6FF)),
  BIOLOGY("ජීව විද්‍යාව (Biology)", "🧬", Color(0xFF15803D), Color(0xFFF0FDF4)),
  CHEMISTRY("රසායන විද්‍යාව (Chemistry)", "⚗️", Color(0xFFB45309), Color(0xFFFFFBEB)),
  PHYSICS("භෞතික විද්‍යාව (Physics)", "⚡", Color(0xFF4338CA), Color(0xFFEEF2FF)),
  EARTH_APPLIED("පෘථිවිය හා තාක්ෂණය (Applied)", "🌍", Color(0xFF0F766E), Color(0xFFF0FDFA))
}

data class Science500QuestionItem(
  val id: String,
  val number: Int,
  val category: ScienceQuestionCategory,
  val unitTitle: String,
  val question: String,
  val options: List<String>,
  val correctOptionIndex: Int,
  val explanationSinhala: String,
  val keyFormulaOrLaw: String? = null,
  val examTip: String? = null
)

object Science500Repository {

  const val pdfDriveUrl = "https://drive.google.com/file/d/1MarNrbMHz2UCxJq-bJJHjp9VxM8N2Ka-/preview"

  val allQuestions: List<Science500QuestionItem> = listOf(
    // --------------------------------------------------------------------------
    // 🧬 BIOLOGY
    // --------------------------------------------------------------------------
    Science500QuestionItem(
      id = "sci_500_q1",
      number = 1,
      category = ScienceQuestionCategory.BIOLOGY,
      unitTitle = "ජීවයේ රසායනික පදනම",
      question = "ග්ලූකෝස් ද්‍රාවණයකට බෙනඩික්ට් ද්‍රාවණය එක්කර රත් කළ විට ලැබෙන අවසාන වර්ණ විපර්යාසය කුමක්ද?",
      options = listOf(
        "1. නිල් පැහැය තද නිල් පැහැයක් බවට පත්වීම",
        "2. කොළ පැහැයේ සිට ගඩොල් රතු අවක්ෂේපයක් බවට පත්වීම",
        "3. දම් පැහැති ද්‍රාවණයක් ඇතිවීම",
        "4. තද නිල්-කළු පැහැති අවක්ෂේපයක් ඇතිවීම"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "ග්ලූකෝස් යනු ඔක්සිහාරක මොනොසැකරයිඩයකි. බෙනඩික්ට් ප්‍රතිකාරකය (නිල් පැහැති Cu²⁺ අඩංගු) සමඟ රත් කළ විට එය Cu⁺ (Cu₂O ගඩොල් රතු අවක්ෂේපය) බවට ඔක්සිහරණය වේ. වර්ණ විපර්යාස අනුපිළිවෙළ: නිල් → කොළ → කහ → තැඹිලි → ගඩොල් රතු අවක්ෂේපය.",
      keyFormulaOrLaw = "ඔක්සිහාරක සීනි + Benedict (Δ) -> Cu₂O (ගඩොල් රතු අවක්ෂේපය)",
      examTip = "සුක්‍රෝස් (මේස සීනි) සෘජුව බෙනඩික්ට් පරීක්ෂාවට ලක් කළ විට ගඩොල් රතු නොවේ (අනොක්සිහාරකයි)."
    ),
    Science500QuestionItem(
      id = "sci_500_q2",
      number = 2,
      category = ScienceQuestionCategory.BIOLOGY,
      unitTitle = "ජෛව අණු හා ප්‍රෝටීන",
      question = "ප්‍රෝටීන හඳුනාගැනීම සඳහා සිදු කරනු ලබන රසායනික පරීක්ෂාව හා එහි නිරීක්ෂණය නිවැරදිව දක්වා ඇත්තේ කුමන පිළිතුරෙහිද?",
      options = listOf(
        "1. අයඩින් පරීක්ෂාව - නිල්-කළු පැහැය",
        "2. සුඩාන් III පරීක්ෂාව - රතු පැහැ තට්ටුවක් ඇතිවීම",
        "3. බයියුරෙට් පරීක්ෂාව - දම් (රෝස-දම්) පැහැයක් ඇතිවීම",
        "4. බෙනඩික්ට් පරීක්ෂාව - ගඩොල් රතු අවක්ෂේපය"
      ),
      correctOptionIndex = 2,
      explanationSinhala = "ප්‍රෝටීනවල ඇති පෙප්ටයිඩ බන්ධන හඳුනාගැනීමට බයියුරෙට් පරීක්ෂාව (NaOH ද්‍රාවණය සහ තනුක CuSO₄ බිංදු කිහිපයක්) භාවිත වේ. පෙප්ටයිඩ බන්ධන Cu²⁺ අයන සමඟ සංකීර්ණ සෑදීම නිසා දම් පැහැයක් ඇතිවේ.",
      keyFormulaOrLaw = "පෙප්ටයිඩ බන්ධන + Biuret reagent (NaOH + CuSO₄) -> දම් පැහැය",
      examTip = "අයඩින් පිෂ්ඨයට ද, සුඩාන් III ලිපිඩවලට ද, බෙනඩික්ට් ඔක්සිහාරක සීනිවලට ද නියමිත පරීක්ෂණ වේ."
    ),
    Science500QuestionItem(
      id = "sci_500_q3",
      number = 3,
      category = ScienceQuestionCategory.BIOLOGY,
      unitTitle = "සෛලීය ව්‍යුහය හා ඉන්ද්‍රයිකා",
      question = "ශාක සෛල තුළ ප්‍රභාසංස්ලේෂණය සිදු වන ප්‍රධාන ඉන්ද්‍රයිකාව සහ සෛලීය ශ්වසනය මඟින් ATP ශක්තිය නිපදවන ඉන්ද්‍රයිකාව පිළිවෙළින් කුමක්ද?",
      options = listOf(
        "1. රයිබොසෝම සහ ලයිසොසෝම",
        "2. හරිතලවය (Chloroplast) සහ මයිටොකොන්ඩ්‍රියම (Mitochondria)",
        "3. ගොල්ගි දේහය සහ න්‍යෂ්ටිකාව",
        "4. අන්තඃප්ලාස්මීය ජාලිකාව සහ සෛල පටලය"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "ප්‍රභාසංස්ලේෂණය සඳහා හරිතප්‍රද අඩංගු හරිතලව (Chloroplasts) ක්‍රියාත්මක වේ. සෛලීය ශ්වසනයේ කෲබ්ස් චක්‍රය හා ඔක්සිකාරක පොස්පොරයිලීකරණය මඟින් ATP ශක්තිය නිපදවන 'සෛලයේ බලාගාරය' වන්නේ මයිටොකොන්ඩ්‍රියමයි.",
      keyFormulaOrLaw = "ප්‍රභාසංස්ලේෂණය -> හරිතලව | සෛලීය ශ්වසනය/ATP -> මයිටොකොන්ඩ්‍රියම",
      examTip = "ශාක සෛලවල හරිතලව මෙන්ම මයිටොකොන්ඩ්‍රියා ද දෙවර්ගයම අඩංගු බව මතක තබා ගන්න."
    ),
    Science500QuestionItem(
      id = "sci_500_q4",
      number = 4,
      category = ScienceQuestionCategory.BIOLOGY,
      unitTitle = "ප්‍රභාසංස්ලේෂණය",
      question = "ප්‍රභාසංස්ලේෂණ ක්‍රියාවලියේදී අතුරු ඵලයක් ලෙස ඔක්සිජන් (O₂) වායුව නිදහස් වන්නේ කුමන සංයෝගය ආලෝකය හමුවේ බිඳවැටීම (ප්‍රකාශ විච්ඡේදනය) මඟින්ද?",
      options = listOf(
        "1. කාබන්ඩයොක්සයිඩ් (CO₂)",
        "2. ජලය (H₂O)",
        "3. ග්ලූකෝස් (C₆H₁₂O₆)",
        "4. පිෂ්ඨය (Starch)"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "ප්‍රභාසංස්ලේෂණයේ ආලෝක ප්‍රතික්‍රියාවේදී හිරු එළිය ශක්තියෙන් ජල අණු ප්‍රකාශ විච්ඡේදනයට (2H₂O -> 4H⁺ + 4e⁻ + O₂) ලක්වේ. එමගින් නිදහස් වන ඔක්සිජන් වායුගෝලයට මුදාහැරේ.",
      keyFormulaOrLaw = "6CO₂ + 6H₂O (ආලෝකය/හරිතප්‍රද) -> C₆H₁₂O₆ + 6O₂",
      examTip = "පිටවන O₂ ලැබෙන්නේ CO₂ මඟින් නොව ජල අණුව (H₂O) බිඳවැටීමෙනි."
    ),
    Science500QuestionItem(
      id = "sci_500_q5",
      number = 5,
      category = ScienceQuestionCategory.BIOLOGY,
      unitTitle = "ප්‍රවේණිය හා මෙන්ඩල්ගේ නියම",
      question = "විෂමයුග්මක උස ශාක දෙකක් (Tt × Tt) අතර ස්වපරාගනය සිදු කළ විට ලැබෙන දෙමුහුම් පරම්පරාවේ (F₂) ප්‍රවේණිදර්ශ අනුපාතය කුමක්ද?",
      options = listOf(
        "1. 3 : 1 (උස : මිටි)",
        "2. 1 : 2 : 1 (TT : Tt : tt)",
        "3. 9 : 3 : 3 : 1",
        "4. 1 : 1 (Tt : tt)"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "Tt × Tt පැනට් චතුරස්‍රය අනුව ජනනය වන්නේ: 1 TT (සමයුග්මක උස), 2 Tt (විෂමයුග්මක උස), 1 tt (සමයුග්මක මිටි) ය. එබැවින් ප්‍රවේණිදර්ශ අනුපාතය 1:2:1 වේ. (දෘශ්‍යදර්ශ අනුපාතය 3:1 වේ).",
      keyFormulaOrLaw = "ප්‍රවේණිදර්ශය = 1 TT : 2 Tt : 1 tt (1:2:1) | දෘශ්‍යදර්ශය = 3 උස : 1 මිටි",
      examTip = "ප්‍රශ්නය අසන්නේ 'ප්‍රවේණිදර්ශ' ද 'දෘශ්‍යදර්ශ' ද යන්න පිළිබඳව නිරවුල්ව අවධානය යොමු කරන්න."
    ),
    Science500QuestionItem(
      id = "sci_500_q6",
      number = 6,
      category = ScienceQuestionCategory.BIOLOGY,
      unitTitle = "මිනිසාගේ සංසරණ පද්ධතිය",
      question = "මිනිස් හෘදයේ වම් කෝෂිකාවෙන් ආරම්භ වී ඔක්සිජනීකෘත රුධිරය මුළු සිරුර පුරා ගෙන යන ප්‍රධානතම ධමනිය කුමක්ද?",
      options = listOf(
        "1. පුප්ඵුසීය ධමනිය (Pulmonary artery)",
        "2. මහා ධමනිය (Aorta)",
        "3. උත්තර මහා ශිරාව (Superior vena cava)",
        "4. පුප්ඵුසීය ශිරාව (Pulmonary vein)"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "හෘදයේ වම් කෝෂිකාව (ඝනතම පේශි බිත්තිය සහිත) හැකිළීමේදී අධික පීඩනයක් යටතේ ඔක්සිජන් සහිත රුධිරය මුළු සිරුරටම බෙදා හරින්නේ මහා ධමනිය (Aorta) මගිනි.",
      keyFormulaOrLaw = "වම් කෝෂිකාව -> මහා ධමනිය (Aorta) -> දේහ පටක (O₂ සහිත)",
      examTip = "පුප්ඵුසීය ධමනිය ඔක්සිජනිත නොව වි-ඔක්සිජනීකෘත රුධිරය පෙණහලු වෙත ගෙනයයි."
    ),
    Science500QuestionItem(
      id = "sci_500_q7",
      number = 7,
      category = ScienceQuestionCategory.BIOLOGY,
      unitTitle = "මිනිසාගේ ඇස හා පෙනීමේ දුබලතා",
      question = "දුර පෙනීමේ දුබලතාවය (Hypermetropia / Long-sightedness) නිවැරදි කරගැනීම සඳහා භාවිත කළ යුතු උපැස් කාච වර්ගය කුමක්ද?",
      options = listOf(
        "1. අවතල කාච (Concave lenses)",
        "2. උත්තල කාච (Convex lenses)",
        "3. සිලින්ඩරාකාර කාච (Cylindrical lenses)",
        "4. ද්විකේන්ද්‍රික කාච (Bifocal lenses)"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "දුර පෙනීමේදී (Hypermetropia) ඇසෙහි කාචයේ අභිසාරී බලය අඩු වීම හෝ අක්ෂිගෝලය කෙටි වීම නිසා ආලෝක කිරණ දෘෂ්ටිවිතානයෙන් පසුපසින් නාභිගත වේ. මෙය නිවැරදි කිරීමට ආලෝක කිරණ අභිසාරී කරන උත්තල කාච (Convex lens) භාවිත කෙරේ.",
      keyFormulaOrLaw = "දුර පෙනීම -> උත්තල කාච (+) | අවිදුර පෙනීම (Myopia) -> අවතල කාච (-)",
      examTip = "අවිදුර පෙනීමේදී (ළඟ පෙනී දුර නොපෙනීම) ආලෝකය දෘෂ්ටිවිතානයට ඉදිරියෙන් නාභිගත වන බැවින් අවතල කාච භාවිත වේ."
    ),
    Science500QuestionItem(
      id = "sci_500_q8",
      number = 8,
      category = ScienceQuestionCategory.BIOLOGY,
      unitTitle = "රුධිර ඝන වීම හා රුධිර ගණ",
      question = "AB රුධිර ගණය සහිත පුද්ගලයෙකු 'සර්වත්‍ර ප්‍රතිග්‍රාහකයෙකු' (Universal Recipient) ලෙස හඳුන්වන්නේ ඇයි?",
      options = listOf(
        "1. ඔහුගේ රතු රුධිරාණුවල ප්‍රතිදේහජනක (Antigens) කිසිවක් නොමැති නිසා",
        "2. ඔහුගේ රුධිර ප්ලාස්මාවේ ප්‍රතිදේහ (Antibodies) a හෝ b නොමැති නිසා",
        "3. ඔහුගේ රුධිරයේ රුධිර පට්ටිකා වැඩි නිසා",
        "4. ඔහුගේ රුධිරයේ හිමොග්ලොබින් වැඩි නිසා"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "AB රුධිර ගණයේ රතු රුධිරාණු මත A හා B ප්‍රතිදේහජනක දෙකම ඇතත්, ප්ලාස්මාවේ anti-a හෝ anti-b ප්‍රතිදේහ නොමැත. එබැවින් වෙනත් ඕනෑම රුධිර ගණයකින් (A, B, AB, O) රුධිරය ලබාගැනීමේදී ප්‍රතිදේහ මඟින් රුධිරාණු කැටි ගැසීමක් (Agglutination) සිදු නොවේ.",
      keyFormulaOrLaw = "AB ගණය: Antigens = A, B | Antibodies = කිසිවක් නැත (සර්වත්‍ර ප්‍රතිග්‍රාහක)",
      examTip = "O රුධිර ගණයේ ප්‍රතිදේහජනක නොමැති බැවින් එය 'සර්වත්‍ර දායකයා' (Universal Donor) වේ."
    ),

    // --------------------------------------------------------------------------
    // ⚗️ CHEMISTRY
    // --------------------------------------------------------------------------
    Science500QuestionItem(
      id = "sci_500_q9",
      number = 9,
      category = ScienceQuestionCategory.CHEMISTRY,
      unitTitle = "පදාර්ථයේ ව්‍යුහය හා ආවර්තිතා වගුව",
      question = "පරමාණුවක න්‍යෂ්ටිය තුළ අඩංගු උපපරමාණුක අංශු වර්ග දෙක නිවැරදිව දක්වා ඇත්තේ කුමක්ද?",
      options = listOf(
        "1. ප්‍රෝටෝන සහ ඉලෙක්ට්‍රෝන",
        "2. ප්‍රෝටෝන සහ නියුට්‍රෝන",
        "3. නියුට්‍රෝන සහ ඉලෙක්ට්‍රෝන",
        "4. ඉලෙක්ට්‍රෝන සහ පොසිට්‍රෝන"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "පරමාණුවේ කේන්ද්‍රීය න්‍යෂ්ටිය තුළ ධන ආරෝපිත ප්‍රෝටෝන සහ ආරෝපණයක් රහිත (උදාසීන) නියුට්‍රෝන පිහිටයි. සෘණ ආරෝපිත ඉලෙක්ට්‍රෝන න්‍යෂ්ටිය වටා ශක්ති මට්ටම්වල භ්‍රමණය වේ.",
      keyFormulaOrLaw = "ස්කන්ධ ක්‍රමාංකය (A) = ප්‍රෝටෝන ගණන (Z) + නියුට්‍රෝන ගණන (N)",
      examTip = "න්‍යෂ්ටියේ ස්කන්ධය මුළු පරමාණුවේ ස්කන්ධයෙන් 99.9%කට වඩා වැඩිය."
    ),
    Science500QuestionItem(
      id = "sci_500_q10",
      number = 10,
      category = ScienceQuestionCategory.CHEMISTRY,
      unitTitle = "රසායනික බන්ධන",
      question = "මැග්නීසියම් (₁₂Mg) සහ ක්ලෝරීන් (₁₇Cl) අතර ප්‍රතික්‍රියාවේදී සෑදෙන සංයෝගයේ සූත්‍රය සහ බන්ධන වර්ගය කුමක්ද?",
      options = listOf(
        "1. MgCl - සහසංයුජ බන්ධනය",
        "2. MgCl₂ - අයනික බන්ධනය",
        "3. Mg₂Cl - අයනික බන්ධනය",
        "4. MgCl₂ - සහසංයුජ බන්ධනය"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "Mg ඉලෙක්ට්‍රෝන වින්‍යාසය 2,8,2 බැවින් ඉලෙක්ට්‍රෝන 2ක් පිටකර Mg²⁺ ධන අයනය සාදයි. Cl ඉලෙක්ට්‍රෝන වින්‍යාසය 2,8,7 බැවින් එක් ඉලෙක්ට්‍රෝනයක් ලබාගෙන Cl⁻ සාදයි. ආරෝපණ සමතුලිත වීමට Cl⁻ අයන 2ක් අවශ්‍ය බැවින් MgCl₂ අයනික සංයෝගය සෑදේ.",
      keyFormulaOrLaw = "Mg²⁺ + 2Cl⁻ -> MgCl₂ (ඉලෙක්ට්‍රෝන හුවමාරුව -> අයනික බන්ධනය)",
      examTip = "ලෝහයක් සහ අලෝහයක් අතර ඇතිවන්නේ ඉලෙක්ට්‍රෝන හුවමාරුවෙන් සෑදෙන අයනික බන්ධනයයි."
    ),
    Science500QuestionItem(
      id = "sci_500_q11",
      number = 11,
      category = ScienceQuestionCategory.CHEMISTRY,
      unitTitle = "මවුලය හා රසායනික ගණනය",
      question = "ජලය (H₂O) ග්‍රෑම් 36 ක අඩංගු ජල මවුල ප්‍රමාණය කොපමණද? (H = 1, O = 16)",
      options = listOf(
        "1. 1 mol",
        "2. 2 mol",
        "3. 0.5 mol",
        "4. 18 mol"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "H₂O මවුලික ස්කන්ධය M = (1 × 2) + 16 = 18 g/mol. මවුල ගණන n = m / M = 36 g / 18 g/mol = 2 mol වේ.",
      keyFormulaOrLaw = "n = m / M (මවුල ගණන = ස්කන්ධය / මවුලික ස්කන්ධය)",
      examTip = "සූත්‍රයේ ඒකක නිවැරදිව ආදේශ කරන්න: ග්‍රෑම් අගය මවුලික ස්කන්ධයෙන් බෙදන්න."
    ),
    Science500QuestionItem(
      id = "sci_500_q12",
      number = 12,
      category = ScienceQuestionCategory.CHEMISTRY,
      unitTitle = "අම්ල, භස්ම හා pH අගය",
      question = "25 °C උෂ්ණත්වයේදී උදාසීන ජලීය ද්‍රාවණයක pH අගය සහ ප්‍රබල අම්ලයක pH අගය පරාසය නිවැරදිව දක්වා ඇත්තේ කුමක්ද?",
      options = listOf(
        "1. උදාසීන pH = 14, අම්ල pH > 7",
        "2. උදාසීන pH = 7, අම්ල pH < 7",
        "3. උදාසීන pH = 0, අම්ල pH = 7",
        "4. උදාසීන pH = 7, අම්ල pH > 7"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "25 °C දී පිරිසිදු උදාසීන ජලයේ [H⁺] = [OH⁻] = 10⁻⁷ mol/dm³ බැවින් pH = 7 වේ. ආම්ලික ද්‍රාවණවල [H⁺] > 10⁻⁷ බැවින් pH < 7 වේ. භස්මවල pH > 7 වේ.",
      keyFormulaOrLaw = "ආම්ලික: pH < 7 | උදාසීන: pH = 7 | භාස්මික: pH > 7",
      examTip = "pH අගය අඩුවන තරමට අම්ලයේ ප්‍රබලතාවය (හයිඩ්‍රජන් අයන සාන්ද්‍රණය) වැඩිවේ."
    ),
    Science500QuestionItem(
      id = "sci_500_q13",
      number = 13,
      category = ScienceQuestionCategory.CHEMISTRY,
      unitTitle = "ලෝහ විද්‍යාව හා විද්‍යුත් රසායනය",
      question = "විද්‍යුත් විච්ඡේදනයේදී කැතෝඩය (සෘණ අග්‍රය) වෙත ඇදී යන්නේ කුමන අයනද? එහි සිදුවන ප්‍රතික්‍රියාව කුමක්ද?",
      options = listOf(
        "1. ඇනායන (සෘණ අයන) - ඔක්සිකරණය",
        "2. කැටායන (ධන අයන) - ඔක්සිහරණය (ඉලෙක්ට්‍රෝන ලබාගැනීම)",
        "3. කැටායන - ඔක්සිකරණය (ඉලෙක්ට්‍රෝන පිටකිරීම)",
        "4. උදාසීන අණු - විඝටනය"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "කැතෝඩය සෘණ ආරෝපිත බැවින් ධන ආරෝපිත කැටායන (Na⁺, Cu²⁺, H⁺ ආදිය) ඒ වෙත ඇදී යයි. කැතෝඩයේදී කැටායන ඉලෙක්ට්‍රෝන ලබාගෙන උදාසීන පරමාණු බවට පත්වේ (ඔක්සිහරණය: Reduction at Cathode).",
      keyFormulaOrLaw = "කැතෝඩය (-) -> කැටායන (+) ඇදී ඒම -> ඔක්සිහරණය (Red Cat)",
      examTip = "මතක තබා ගැනීමේ කෙටි ක්‍රමය: An Ox (Anode Oxidation) සහ Red Cat (Reduction at Cathode)."
    ),
    Science500QuestionItem(
      id = "sci_500_q14",
      number = 14,
      category = ScienceQuestionCategory.CHEMISTRY,
      unitTitle = "රසායනික ප්‍රතික්‍රියා ශීඝ්‍රතාව",
      question = "ඝන ප්‍රතික්‍රියකයක ප්‍රතික්‍රියා ශීඝ්‍රතාව වැඩි කරගැනීමට කළ හැකි වඩාත්ම ඵලදායී ක්‍රියාමාර්ගය කුමක්ද?",
      options = listOf(
        "1. ඝන ද්‍රව්‍යය විශාල කුට්ටි ලෙස භාවිත කිරීම",
        "2. ප්‍රතික්‍රියක කුඩු කර මතුපිට වර්ගඵලය වැඩිකිරීම",
        "3. පද්ධතියේ උෂ්ණත්වය අඩු කිරීම",
        "4. ප්‍රතික්‍රියකවල සාන්ද්‍රණය අඩු කිරීම"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "ඝන ප්‍රතික්‍රියකයක් කුඩු කළ විට එහි සම්පූර්ණ මතුපිට වර්ගඵලය බෙහෙවින් වැඩිවේ. එමගින් ඒකක කාලයකදී සිදුවන ඵලදායී ගැටුම් සංඛ්‍යාව වැඩි වී ප්‍රතික්‍රියා ශීඝ්‍රතාව ඉහළ යයි (ඝට්ටන වාදය අනුව).",
      keyFormulaOrLaw = "මතුපිට වර්ගඵලය ↑ ⟹ ඵලදායී ගැටුම් ↑ ⟹ ප්‍රතික්‍රියා ශීඝ්‍රතාව ↑",
      examTip = "CaCO₃ කුට්ටි වෙනුවට CaCO₃ කුඩු භාවිත කළ විට CO₂ පිටවීමේ වේගය වැඩිවීම සම්මත ප්‍රායෝගික පරීක්ෂණයකි."
    ),

    // --------------------------------------------------------------------------
    // ⚡ PHYSICS
    // --------------------------------------------------------------------------
    Science500QuestionItem(
      id = "sci_500_q15",
      number = 15,
      category = ScienceQuestionCategory.PHYSICS,
      unitTitle = "චලිතය හා නිව්ටන් නියම",
      question = "ස්කන්ධය 4 kg වූ වස්තුවක් මත 20 N බලයක් යෙදූ විට එම වස්තුවේ ඇතිවන ත්වරණය කොපමණද?",
      options = listOf(
        "1. 80 m s⁻²",
        "2. 5 m s⁻²",
        "3. 0.2 m s⁻²",
        "4. 16 m s⁻²"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "නිව්ටන්ගේ දෙවන චලිත නියමයට අනුව F = ma වේ. මෙහි F = 20 N සහ m = 4 kg බැවින්: a = F / m = 20 / 4 = 5 m s⁻².",
      keyFormulaOrLaw = "F = ma ⟹ a = F / m = 20 N / 4 kg = 5 m s⁻²",
      examTip = "සෑම විටම SI ඒකක (kg, N, m s⁻²) නිවැරදිව පරීක්ෂා කරන්න."
    ),
    Science500QuestionItem(
      id = "sci_500_q16",
      number = 16,
      category = ScienceQuestionCategory.PHYSICS,
      unitTitle = "පීඩනය හා පැස්කල් නියමය",
      question = "වර්ගඵලය 0.5 m² වූ පෘෂ්ඨයක් මත 250 N අභිලම්භ බලයක් යෙදූ විට ඇතිවන පීඩනය කොපමණද?",
      options = listOf(
        "1. 125 Pa",
        "2. 500 Pa (N m⁻²)",
        "3. 250 Pa",
        "4. 1000 Pa"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "පීඩනය P = F / A සූත්‍රයෙන් ගණනය කෙරේ. P = 250 N / 0.5 m² = 500 N m⁻² = 500 Pa.",
      keyFormulaOrLaw = "P = F / A = 250 / 0.5 = 500 Pa",
      examTip = "වර්ගඵලය cm² වලින් දුනහොත් 10⁻⁴ න් ගුණ කර m² බවට පරිවර්තනය කරගත යුතුය."
    ),
    Science500QuestionItem(
      id = "sci_500_q17",
      number = 17,
      category = ScienceQuestionCategory.PHYSICS,
      unitTitle = "කාර්යය, ශක්තිය හා ක්ෂමතාව",
      question = "ස්කන්ධය 10 kg වූ පෙට්ටියක් 2 m උසකට සිරස්ව එසවීමේදී ගුරුත්වයට එරෙහිව කරන ලද කාර්යය කොපමණද? (g = 10 m s⁻²)",
      options = listOf(
        "1. 20 J",
        "2. 200 J",
        "3. 50 J",
        "4. 500 J"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "ගුරුත්වජ විභව ශක්තිය හෙවත් ගුරුත්වයට එරෙහිව කරන ලද කාර්යය W = mgh වේ. W = 10 kg × 10 m s⁻² × 2 m = 200 J.",
      keyFormulaOrLaw = "W = mgh = 10 × 10 × 2 = 200 J",
      examTip = "කාර්යය සහ ශක්තිය මනින SI සම්මත ඒකකය ජූල් (J) වේ."
    ),
    Science500QuestionItem(
      id = "sci_500_q18",
      number = 18,
      category = ScienceQuestionCategory.PHYSICS,
      unitTitle = "ධාරා විද්‍යුතය හා ඕම් නියමය",
      question = "ප්‍රතිරෝධය 6 Ω වූ විද්‍යුත් උපකරණයක් හරහා 2 A ධාරාවක් ගලායයි නම්, එම උපකරණයේ අග්‍ර අතර විභව අන්තරය කොපමණද?",
      options = listOf(
        "1. 3 V",
        "2. 12 V",
        "3. 8 V",
        "4. 0.33 V"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "ඕම් නියමයට අනුව V = I · R වේ. මෙහි ධාරාව I = 2 A සහ ප්‍රතිරෝධය R = 6 Ω බැවින්: V = 2 A × 6 Ω = 12 V.",
      keyFormulaOrLaw = "V = IR = 2 A × 6 Ω = 12 V",
      examTip = "ඕම් නියමය වලංගු වන්නේ උෂ්ණත්වය ඇතුළු අනෙකුත් භෞතික තත්ත්ව නියතව පවතින සන්නායක සඳහා පමණි."
    ),
    Science500QuestionItem(
      id = "sci_500_q19",
      number = 19,
      category = ScienceQuestionCategory.PHYSICS,
      unitTitle = "තරංග හා ආලෝකය",
      question = "තරංගයක ප්‍රවේගය (v), සංඛ්‍යාතය (f) සහ තරංග ආයාමය (λ) අතර නිවැරදි සම්බන්ධතාවය කුමක්ද?",
      options = listOf(
        "1. v = f / λ",
        "2. v = f · λ",
        "3. f = v · λ",
        "4. λ = v · f"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "ඕනෑම තරංගයක ප්‍රවේගය යනු සංඛ්‍යාතය සහ තරංග ආයාමයේ ගුණිතයයි: v = f · λ. මෙහි v ප්‍රවේගය (m s⁻¹), f සංඛ්‍යාතය (Hz), සහ λ තරංග ආයාමය (m) වේ.",
      keyFormulaOrLaw = "v = f · λ ⟹ f = v / λ, λ = v / f",
      examTip = "තරංගයක් එක් මාධ්‍යයකින් තවත් මාධ්‍යයකට වර්තනය වීමේදී සංඛ්‍යාතය (f) වෙනස් නොවේ."
    ),
    Science500QuestionItem(
      id = "sci_500_q20",
      number = 20,
      category = ScienceQuestionCategory.PHYSICS,
      unitTitle = "ඉලෙක්ට්‍රොනික විද්‍යාව හා තාර්කික ද්වාර",
      question = "ආදාන (Inputs) A සහ B යන දෙකම '1' (HIGH) වන විට පමණක් ප්‍රතිදානය (Output) '1' වන මූලික තාර්කික ද්වාරය කුමක්ද?",
      options = listOf(
        "1. OR ද්වාරය",
        "2. AND ද්වාරය",
        "3. NOT ද්වාරය",
        "4. NOR ද්වාරය"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "AND ද්වාරයේ බූලියානු සමීකරණය Q = A · B වේ. ආදාන දෙකම 1 (සත්‍ය) වන විට පමණක් 1 · 1 = 1 වන අතර, අනෙක් සෑම අවස්ථාවකදීම ප්‍රතිදානය 0 වේ.",
      keyFormulaOrLaw = "AND Gate: Q = A · B (1 · 1 = 1, අනෙක් සියල්ල 0)",
      examTip = "OR ද්වාරයේ ආදාන වලින් එකක් හෝ 1 වුවහොත් ප්‍රතිදානය 1 වේ (Q = A + B)."
    ),
    Science500QuestionItem(
      id = "sci_500_q21",
      number = 21,
      category = ScienceQuestionCategory.PHYSICS,
      unitTitle = "විද්‍යුත් චුම්භක ප්‍රේරණය හා පරිණාමක",
      question = "ප්‍රාථමික දඟරයේ පොටවල් 500ක් ද, ද්විතීයික දඟරයේ පොටවල් 100ක් ද ඇති පරිණාමකයක ප්‍රාථමික වෝල්ටීයතාව 250 V නම්, ද්විතීයික වෝල්ටීයතාව කොපමණද?",
      options = listOf(
        "1. 1250 V",
        "2. 50 V",
        "3. 25 V",
        "4. 500 V"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "පරිණාමක සමීකරණයට අනුව Vp / Vs = Np / Ns වේ. 250 / Vs = 500 / 100 = 5 ⟹ Vs = 250 / 5 = 50 V. මෙය අවක්‍රමික (Step-down) පරිණාමකයකි.",
      keyFormulaOrLaw = "Vp / Vs = Np / Ns ⟹ Vs = Vp × (Ns / Np) = 250 × (100 / 500) = 50 V",
      examTip = "Ns < Np බැවින් මෙය වෝල්ටීයතාව අඩු කරන අවක්‍රමික පරිණාමකයකි."
    ),

    // --------------------------------------------------------------------------
    // 🌍 EARTH & APPLIED SCIENCE
    // --------------------------------------------------------------------------
    Science500QuestionItem(
      id = "sci_500_q22",
      number = 22,
      category = ScienceQuestionCategory.EARTH_APPLIED,
      unitTitle = "පෘථිවි ගෝල හා පාරිසරික විද්‍යාව",
      question = "වායුගෝලයේ ඕසෝන් වියන (O₃) ප්‍රධාන වශයෙන් පිහිටා ඇත්තේ කුමන වායුගෝලීය ස්ථරයේද? එහි ප්‍රධාන කාර්යය කුමක්ද?",
      options = listOf(
        "1. පරිවර්තී ගෝලය (Troposphere) - හරිතාගාර ආචරණය පාලනය",
        "2. අපවර්තී ගෝලය (Stratosphere) - හානිකර පාරජම්බුල (UV) කිරණ අවශෝෂණය",
        "3. මධ්‍ය ගෝලය (Mesosphere) - උල්කාපාත දහනය",
        "4. තාප ගෝලය (Thermosphere) - රේඩියෝ තරංග පරාවර්තනය"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "ඕසෝන් ස්ථරය පිහිටා ඇත්තේ අපවර්තී ගෝලයේ (Stratosphere) කිලෝමීටර 15-35 අතර කලාපයේය. එය සූර්යයාගෙන් පැමිණෙන හානිකර කෙටි තරංග ආයාම සහිත පාරජම්බුල (UV-B, UV-C) කිරණ අවශෝෂණය කර පෘථිවි ජීවීන් ආරක්ෂා කරයි.",
      keyFormulaOrLaw = "Stratosphere (අපවර්තී ගෝලය) -> O₃ ඕසෝන් වියන -> UV කිරණ අවහිර කිරීම",
      examTip = "CFC වායු මඟින් ඕසෝන් ස්ථරය ක්ෂය වන අතර එමගින් චර්ම පිළිකා හා ඇසේ සුද ඒම වැඩිවේ."
    ),
    Science500QuestionItem(
      id = "sci_500_q23",
      number = 23,
      category = ScienceQuestionCategory.EARTH_APPLIED,
      unitTitle = "ජෛව තාක්ෂණය හා තිරසාර සම්පත්",
      question = "ප්‍රතිසංයෝජිත DNA තාක්ෂණයේදී (Recombinant DNA Technology) ජාන කැපීම සඳහා සහ ජාන එකට බද්ධ කිරීම සඳහා භාවිත කරන එන්සයිම වර්ග පිළිවෙළින් කුමක්ද?",
      options = listOf(
        "1. ඇමයිලේස් සහ පෙප්සින්",
        "2. රෙස්ට්‍රික්ෂන් එන්ඩොනියුක්ලියෙස් (Restriction enzymes) සහ DNA ලයිගේස් (DNA ligase)",
        "3. DNA පොලිමරේස් සහ සෙලියුලේස්",
        "4. ලයිපේස් සහ ට්‍රිප්සින්"
      ),
      correctOptionIndex = 1,
      explanationSinhala = "ජාන ඉංජිනේරු විද්‍යාවේදී නිශ්චිත නියුක්ලියෝටයිඩ අනුක්‍රමයකින් DNA අණුව කැපීමට 'රසායනික කතුර' ලෙස රෙස්ට්‍රික්ෂන් එන්ඩොනියුක්ලියෙස් ද, කපාගත් ජාන කොටස් එකිනෙක බද්ධ කිරීමට 'රසායනික මැලියම්' ලෙස DNA ලයිගේස් එන්සයිමය ද භාවිත කෙරේ.",
      keyFormulaOrLaw = "ජාන කැපීම -> Restriction Endonuclease | ජාන බද්ධය -> DNA Ligase",
      examTip = "මිනිස් ඉන්සියුලින් නිපදවීමට ඊ. කෝලයි (E. coli) බැක්ටීරියාව තුළට ජාන ඇතුළු කරන්නේ මෙම තාක්ෂණයෙනි."
    )
  )

  fun getQuestionsByCategory(category: ScienceQuestionCategory): List<Science500QuestionItem> {
    return if (category == ScienceQuestionCategory.ALL) allQuestions
    else allQuestions.filter { it.category == category }
  }
}

// ==============================================================================
// COMPOSE AUTO-CHECKER SCREEN (11 ශ්‍රේණිය විද්‍යාව ප්‍රශ්න 500 ස්වයංක්‍රීය පරීක්ෂාව)
// ==============================================================================

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Science500QuestionsAutoCheckerScreen(
  onBack: () -> Unit,
  onOpenPdfDriveViewer: (pdfUrl: String, title: String) -> Unit
) {
  var selectedCategory by remember { mutableStateOf(ScienceQuestionCategory.ALL) }
  var searchQuery by remember { mutableStateOf("") }
  var filterOnlyMistakes by remember { mutableStateOf(false) }

  val userAnswers = remember { mutableStateMapOf<String, Int>() }
  val bookmarkedQuestions = remember { mutableStateMapOf<String, Boolean>() }

  val filteredQuestions = remember(selectedCategory, searchQuery, filterOnlyMistakes, userAnswers.toMap()) {
    var list = Science500Repository.getQuestionsByCategory(selectedCategory)
    if (searchQuery.isNotBlank()) {
      val query = searchQuery.trim().lowercase()
      list = list.filter {
        it.question.lowercase().contains(query) ||
          it.unitTitle.lowercase().contains(query) ||
          it.number.toString() == query
      }
    }
    if (filterOnlyMistakes) {
      list = list.filter { q ->
        val ans = userAnswers[q.id]
        ans != null && ans != q.correctOptionIndex
      }
    }
    list
  }

  val totalAnswered = userAnswers.size
  val correctCount = userAnswers.count { (qId, selectedIdx) ->
    val q = Science500Repository.allQuestions.firstOrNull { it.id == qId }
    q != null && q.correctOptionIndex == selectedIdx
  }
  val incorrectCount = totalAnswered - correctCount
  val accuracyPercentage = if (totalAnswered > 0) (correctCount * 100) / totalAnswered else 0

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text(
                text = "11 විද්‍යාව ප්‍රශ්න 500 Auto-Checker",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color.White
              )
              Spacer(modifier = Modifier.width(6.dp))
              Surface(
                shape = RoundedCornerShape(4.dp),
                color = Color(0xFF10B981)
              ) {
                Text(
                  text = "100% නිවැරදි",
                  fontSize = 8.5.sp,
                  fontWeight = FontWeight.ExtraBold,
                  color = Color.White,
                  modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.5.dp)
                )
              }
            }
            Text(
              text = "ස්වයංක්‍රීය පරීක්ෂාව • සවිස්තරාත්මක විවරණය • O/L Grade 11",
              fontSize = 10.sp,
              color = Color(0xFFC7D2FE)
            )
          }
        },
        navigationIcon = {
          IconButton(onClick = onBack, modifier = Modifier.testTag("sci_500_back_btn")) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = "Back",
              tint = Color.White
            )
          }
        },
        actions = {
          FilledTonalButton(
            onClick = {
              onOpenPdfDriveViewer(
                Science500Repository.pdfDriveUrl,
                "11 ශ්‍රේණිය - විද්‍යාව ප්‍රශ්න 500 විශේෂ කෙටි සටහන් සහ ප්‍රශ්නෝත්තර සංග්‍රහය (PDF)"
              )
            },
            colors = ButtonDefaults.filledTonalButtonColors(
              containerColor = Color(0xFF4338CA),
              contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
            modifier = Modifier.padding(end = 8.dp)
          ) {
            Icon(imageVector = Icons.Default.PictureAsPdf, contentDescription = "PDF", modifier = Modifier.size(15.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text("පූර්ණ PDF", fontSize = 11.sp, fontWeight = FontWeight.Bold)
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0F172A))
      )
    },
    containerColor = Color(0xFFF8FAFC)
  ) { paddingValues ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
        .padding(horizontal = 14.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      // 1. STATS BANNER
      item {
        Spacer(modifier = Modifier.height(4.dp))
        Card(
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Column {
                Text(
                  text = "📊 ඔබගේ ප්‍රගතිය (Live Auto-Scoring)",
                  fontSize = 12.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF94A3B8)
                )
                Text(
                  text = "පිළිතුරු ලබාදුන්: $totalAnswered / ${Science500Repository.allQuestions.size}",
                  fontSize = 14.sp,
                  fontWeight = FontWeight.ExtraBold,
                  color = Color.White
                )
              }

              Surface(
                color = if (accuracyPercentage >= 75) Color(0xFF10B981) else if (accuracyPercentage >= 50) Color(0xFFF59E0B) else Color(0xFF6366F1),
                shape = RoundedCornerShape(8.dp)
              ) {
                Text(
                  text = "නිරවද්‍යතාව: $accuracyPercentage%",
                  color = Color.White,
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Score Badges Row
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              Surface(
                color = Color(0xFF064E3B),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f)
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.Center
                ) {
                  Text("✅ නිවැරදි: $correctCount", color = Color(0xFF6EE7B7), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
              }

              Surface(
                color = Color(0xFF7F1D1D),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f)
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.Center
                ) {
                  Text("❌ වැරදුණු: $incorrectCount", color = Color(0xFFFCA5A5), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
              }

              if (incorrectCount > 0) {
                Surface(
                  color = if (filterOnlyMistakes) Color(0xFFEF4444) else Color(0xFF334155),
                  shape = RoundedCornerShape(8.dp),
                  onClick = { filterOnlyMistakes = !filterOnlyMistakes },
                  modifier = Modifier.weight(1.2f)
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                  ) {
                    Text(
                      text = if (filterOnlyMistakes) "සියල්ල පෙන්වන්න" else "⚠️ වැරදුණු ප්‍රශ්න",
                      color = Color.White,
                      fontSize = 10.sp,
                      fontWeight = FontWeight.Bold
                    )
                  }
                }
              }
            }
          }
        }
      }

      // 2. SEARCH & JUMP BAR
      item {
        OutlinedTextField(
          value = searchQuery,
          onValueChange = { searchQuery = it },
          placeholder = { Text("ප්‍රශ්න අංකය හෝ විෂය කරුණ සොයන්න...", fontSize = 12.sp) },
          leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF64748B)) },
          trailingIcon = {
            if (searchQuery.isNotEmpty()) {
              IconButton(onClick = { searchQuery = "" }) {
                Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color(0xFF64748B))
              }
            }
          },
          singleLine = true,
          shape = RoundedCornerShape(12.dp),
          colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF4F46E5),
            unfocusedBorderColor = Color(0xFFCBD5E1),
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
          ),
          modifier = Modifier.fillMaxWidth()
        )
      }

      // 3. CATEGORY FILTER CHIPS
      item {
        LazyRow(
          horizontalArrangement = Arrangement.spacedBy(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          items(ScienceQuestionCategory.values()) { cat ->
            val isSelected = selectedCategory == cat
            Surface(
              onClick = { selectedCategory = cat },
              shape = RoundedCornerShape(10.dp),
              color = if (isSelected) cat.primaryColor else Color.White,
              border = BorderStroke(1.dp, if (isSelected) cat.primaryColor else Color(0xFFE2E8F0)),
              shadowElevation = if (isSelected) 2.dp else 0.dp
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 7.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(cat.iconEmoji, fontSize = 12.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                  text = cat.displayName,
                  fontSize = 11.sp,
                  fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                  color = if (isSelected) Color.White else Color(0xFF334155)
                )
              }
            }
          }
        }
      }

      // 4. QUESTIONS LIST WITH INSTANT 100% AUTO-CHECKING
      if (filteredQuestions.isEmpty()) {
        item {
          Surface(
            shape = RoundedCornerShape(14.dp),
            color = Color.White,
            border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
            modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 24.dp)
          ) {
            Column(
              modifier = Modifier.padding(24.dp),
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
              Text("🔍", fontSize = 32.sp)
              Spacer(modifier = Modifier.height(8.dp))
              Text(
                text = if (filterOnlyMistakes) "ඔබට වැරදුණු ප්‍රශ්න කිසිවක් නොමැත! සියල්ල නිවැරදියි." else "ගැළපෙන ප්‍රශ්න හමු නොවීය.",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = Color(0xFF334155),
                textAlign = TextAlign.Center
              )
              if (filterOnlyMistakes) {
                Spacer(modifier = Modifier.height(8.dp))
                TextButton(onClick = { filterOnlyMistakes = false }) {
                  Text("සියලු ප්‍රශ්න වෙත ආපසු යන්න", color = Color(0xFF4F46E5), fontWeight = FontWeight.Bold)
                }
              }
            }
          }
        }
      } else {
        itemsIndexed(filteredQuestions, key = { _, item -> item.id }) { _, q ->
          val selectedOption = userAnswers[q.id]
          val isAnswered = selectedOption != null
          val isCorrect = isAnswered && selectedOption == q.correctOptionIndex
          val isBookmarked = bookmarkedQuestions[q.id] == true

          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(
              1.dp,
              when {
                !isAnswered -> Color(0xFFE2E8F0)
                isCorrect -> Color(0xFF86EFAC)
                else -> Color(0xFFFCA5A5)
              }
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            modifier = Modifier
              .fillMaxWidth()
              .testTag("sci_q_card_${q.number}")
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              // Card Header
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = q.category.primaryColor
                  ) {
                    Text(
                      text = "ප්‍රශ්නය ${q.number}",
                      color = Color.White,
                      fontSize = 10.sp,
                      fontWeight = FontWeight.ExtraBold,
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                  }
                  Spacer(modifier = Modifier.width(6.dp))
                  Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = q.category.bgLightColor
                  ) {
                    Text(
                      text = q.unitTitle,
                      color = q.category.primaryColor,
                      fontSize = 9.sp,
                      fontWeight = FontWeight.Bold,
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                  }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                  if (isAnswered) {
                    Surface(
                      shape = RoundedCornerShape(6.dp),
                      color = if (isCorrect) Color(0xFFDCFCE7) else Color(0xFFFEE2E2)
                    ) {
                      Text(
                        text = if (isCorrect) "✅ නිවැරදියි" else "❌ වැරදියි",
                        color = if (isCorrect) Color(0xFF15803D) else Color(0xFFB91C1C),
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                      )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                  }

                  IconButton(
                    onClick = {
                      bookmarkedQuestions[q.id] = !isBookmarked
                    },
                    modifier = Modifier.size(24.dp)
                  ) {
                    Icon(
                      imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                      contentDescription = "Bookmark",
                      tint = if (isBookmarked) Color(0xFFF59E0B) else Color(0xFF94A3B8),
                      modifier = Modifier.size(18.dp)
                    )
                  }
                }
              }

              Spacer(modifier = Modifier.height(10.dp))

              // Question Text
              Text(
                text = q.question,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E293B),
                lineHeight = 19.sp
              )

              Spacer(modifier = Modifier.height(12.dp))

              // Options
              Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                q.options.forEachIndexed { optIndex, optText ->
                  val isThisOptionSelected = selectedOption == optIndex
                  val isThisTheCorrectAnswer = optIndex == q.correctOptionIndex

                  val optionBgColor = when {
                    !isAnswered -> Color(0xFFF8FAFC)
                    isThisTheCorrectAnswer -> Color(0xFFDCFCE7)
                    isThisOptionSelected && !isCorrect -> Color(0xFFFEE2E2)
                    else -> Color(0xFFF8FAFC)
                  }

                  val optionBorderColor = when {
                    !isAnswered -> Color(0xFFE2E8F0)
                    isThisTheCorrectAnswer -> Color(0xFF22C55E)
                    isThisOptionSelected && !isCorrect -> Color(0xFFEF4444)
                    else -> Color(0xFFE2E8F0)
                  }

                  Surface(
                    onClick = {
                      userAnswers[q.id] = optIndex
                    },
                    shape = RoundedCornerShape(10.dp),
                    color = optionBgColor,
                    border = BorderStroke(1.dp, optionBorderColor),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Row(
                      modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 9.dp),
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Surface(
                        shape = CircleShape,
                        color = when {
                          !isAnswered -> Color(0xFFE2E8F0)
                          isThisTheCorrectAnswer -> Color(0xFF16A34A)
                          isThisOptionSelected && !isCorrect -> Color(0xFFDC2626)
                          else -> Color(0xFFE2E8F0)
                        },
                        modifier = Modifier.size(20.dp)
                      ) {
                        Box(contentAlignment = Alignment.Center) {
                          if (isAnswered && isThisTheCorrectAnswer) {
                            Icon(Icons.Default.Check, contentDescription = "Correct", tint = Color.White, modifier = Modifier.size(12.dp))
                          } else if (isAnswered && isThisOptionSelected && !isCorrect) {
                            Icon(Icons.Default.Close, contentDescription = "Incorrect", tint = Color.White, modifier = Modifier.size(12.dp))
                          } else {
                            Text(
                              text = "${optIndex + 1}",
                              fontSize = 9.sp,
                              fontWeight = FontWeight.Bold,
                              color = Color(0xFF475569)
                            )
                          }
                        }
                      }

                      Spacer(modifier = Modifier.width(8.dp))

                      Text(
                        text = optText,
                        fontSize = 12.sp,
                        fontWeight = if (isThisOptionSelected || (isAnswered && isThisTheCorrectAnswer)) FontWeight.Bold else FontWeight.Normal,
                        color = when {
                          !isAnswered -> Color(0xFF334155)
                          isThisTheCorrectAnswer -> Color(0xFF14532D)
                          isThisOptionSelected && !isCorrect -> Color(0xFF7F1D1D)
                          else -> Color(0xFF64748B)
                        },
                        lineHeight = 16.sp,
                        modifier = Modifier.weight(1f)
                      )
                    }
                  }
                }
              }

              // 5. DETAILED 100% ACCURATE EXPLANATION
              AnimatedVisibility(visible = isAnswered) {
                Column(modifier = Modifier.padding(top = 10.dp)) {
                  Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                      containerColor = if (isCorrect) Color(0xFFF0FDF4) else Color(0xFFFFFBEB)
                    ),
                    border = BorderStroke(
                      1.dp,
                      if (isCorrect) Color(0xFFBBF7D0) else Color(0xFFFDE68A)
                    ),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                      Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                          text = if (isCorrect) "💡 සවිස්තරාත්මක විද්‍යාත්මක විවරණය (100% Explanation)" else "⚠️ නිවැරදි පිළිතුර හා සවිස්තරාත්මක විවරණය",
                          fontSize = 11.5.sp,
                          fontWeight = FontWeight.Bold,
                          color = if (isCorrect) Color(0xFF15803D) else Color(0xFFB45309)
                        )
                      }

                      Spacer(modifier = Modifier.height(6.dp))

                      Text(
                        text = q.explanationSinhala,
                        fontSize = 12.sp,
                        color = Color(0xFF1E293B),
                        lineHeight = 17.sp
                      )

                      if (!q.keyFormulaOrLaw.isNullOrBlank()) {
                        Spacer(modifier = Modifier.height(6.dp))
                        Surface(
                          shape = RoundedCornerShape(6.dp),
                          color = Color.White,
                          border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
                          modifier = Modifier.fillMaxWidth()
                        ) {
                          Row(
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                          ) {
                            Text("📐 මූලික සූත්‍රය / නියමය: ", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF334155))
                            Text(q.keyFormulaOrLaw, fontSize = 10.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF4338CA))
                          }
                        }
                      }

                      if (!q.examTip.isNullOrBlank()) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                          text = "🎯 O/L විභාග ඉඟිය: ${q.examTip}",
                          fontSize = 10.sp,
                          color = Color(0xFF6B21A8),
                          fontWeight = FontWeight.SemiBold,
                          lineHeight = 14.sp
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

      item {
        Spacer(modifier = Modifier.height(24.dp))
      }
    }
  }
}
