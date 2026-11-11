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
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

enum class ScienceGradeFilter(val labelSinhala: String) {
  ALL("සියල්ල (10 & 11)"),
  GRADE_10("10 ශ්‍රේණිය"),
  GRADE_11("11 ශ්‍රේණිය")
}

enum class ScienceCategoryFilter(
  val displayName: String,
  val iconEmoji: String,
  val color: Color,
  val bgLightColor: Color
) {
  ALL("සියලු ඒකක (36)", "🔬", Color(0xFF0D9488), Color(0xFFF0FDFA)),
  BIOLOGY("ජීව විද්‍යාව (Biology)", "🧬", Color(0xFF15803D), Color(0xFFF0FDF4)),
  CHEMISTRY("රසායන විද්‍යාව (Chemistry)", "⚗️", Color(0xFFB45309), Color(0xFFFFFBEB)),
  PHYSICS("භෞතික විද්‍යාව (Physics)", "⚡", Color(0xFF4338CA), Color(0xFFEEF2FF)),
  EARTH_ENVIRONMENT("පෘථිවිය & පරිසරය (Earth)", "🌍", Color(0xFF0284C7), Color(0xFFF0F9FF))
}

data class ScienceUnitShortNote(
  val unitNumber: Int,
  val gradeLevel: String, // "10" or "11"
  val titleSinhala: String,
  val category: ScienceCategoryFilter,
  val pageRangeText: String,
  val rootConcepts: List<String>,
  val keyFormulasOrLaws: List<String>,
  val highlights: List<String>,
  val examTips: List<String>,
  val pdfUri: String,
  val fileName: String
)

object Grade10And11ScienceShortNotesRepository {

  const val SCIENCE_GR10_FULL_PDF = "https://drive.google.com/file/d/1vx9uXTL_pKexaA5g0IHPa47h6eKdINZl/preview"
  const val SCIENCE_GR10_COMPENDIUM_PDF = "https://drive.google.com/file/d/1N5TV_W4kL891IKIZETGHnMCE_rnRIPKm/preview"
  const val SCIENCE_GR11_FULL_PDF = "https://drive.google.com/file/d/17TcFs1wECaHB4C3LMdC8mO2YDKrtrEOI/preview"
  const val SCIENCE_GR11_COMPENDIUM_PDF = "https://drive.google.com/file/d/1b650hE61XIP8RxNWq3TpIxg8pHtTOY8m/preview"
  const val SCIENCE_500_QUESTIONS_PDF = "https://drive.google.com/file/d/1MarNrbMHz2UCxJq-bJJHjp9VxM8N2Ka-/preview"

  val units: List<ScienceUnitShortNote> = listOf(
    // -------------------------------------------------------------
    // GRADE 10 (16 Units)
    // -------------------------------------------------------------
    ScienceUnitShortNote(
      unitNumber = 1,
      gradeLevel = "10",
      titleSinhala = "ජීවයේ රසායනික පදනම (ජෛව අණු)",
      category = ScienceCategoryFilter.BIOLOGY,
      pageRangeText = "පිටු 1-12",
      rootConcepts = listOf("කාබෝහයිඩ්‍රේට", "ප්‍රෝටීන", "ලිපිඩ", "නියුක්ලික් අම්ල", "ජලය සහ ඛණිජ ලවණ"),
      keyFormulasOrLaws = listOf(
        "ග්ලූකෝස්: C₆H₁₂O₆ (මොනොසැකරයිඩයකි)",
        "සුක්‍රෝස් = ග්ලූකෝස් + ෆ්‍රක්ටෝස් (ඩයිසැකරයිඩයකි)",
        "ප්‍රෝටීනවල තැනුම් ඒකකය: ඇමයිනෝ අම්ල (පෙප්ටයිඩ බන්ධන)",
        "ලිපිඩ = ග්ලිසරෝල් + මේද අම්ල (එස්ටර බන්ධන)"
      ),
      highlights = listOf(
        "බෙනඩික්ට් පරීක්ෂාව: ඔක්සිහාරක සීනි හඳුනාගැනීමට (නිල් → කොළ → කහ → ගඩොල් රතු අවක්ෂේපය)",
        "අයඩින් පරීක්ෂාව: පිෂ්ඨය සඳහා (ලා දුඹුරු → තද නිල්)",
        "බියුරෙට් පරීක්ෂාව: ප්‍රෝටීන සඳහා (ලා නිල් → දම් පාට)",
        "සුඩාන් III පරීක්ෂාව: ලිපිඩ හඳුනාගැනීම සඳහා (රතු පැහැ තෙල් බිඳිති)"
      ),
      examTips = listOf(
        "💡 විභාගයේදී බෙනඩික්ට් පරීක්ෂාවේදී ජල තාපකයක රත් කිරීම අනිවාර්ය කරුණකි.",
        "💡 සුක්‍රෝස් යනු අනොක්සිහාරක සීනි වර්ගයක් බැවින් සෘජු බෙනඩික්ට් පරීක්ෂාවට ධන ප්‍රතිචාර නොදක්වයි."
      ),
      pdfUri = SCIENCE_GR10_FULL_PDF,
      fileName = "Grade10_Science_Unit01_BioMolecules.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 2,
      gradeLevel = "10",
      titleSinhala = "පදාර්ථයේ ව්‍යුහය (පරමාණුක ආකෘති සහ වින්‍යාසය)",
      category = ScienceCategoryFilter.CHEMISTRY,
      pageRangeText = "පිටු 13-24",
      rootConcepts = listOf("පරමාණුව", "උප පරමාණුක අංශු (ප්‍රෝටෝන, නියුට්‍රෝන, ඉලෙක්ට්‍රෝන)", "පරමාණුක ක්‍රමාංකය (Z)", "ස්කන්ධ ක්‍රමාංකය (A)", "ඉලෙක්ට්‍රොනික වින්‍යාසය"),
      keyFormulasOrLaws = listOf(
        "ස්කන්ධ ක්‍රමාංකය A = p + n",
        "නියුට්‍රෝන ගණන n = A - Z",
        "ප්‍රධාන ශක්ති මට්ටමක උපරිම ඉලෙක්ට්‍රෝන ධාරිතාව = 2n² (K=2, L=8, M=8/18)"
      ),
      highlights = listOf(
        "ප්‍රෝටෝන (p⁺) හා නියුට්‍රෝන (n⁰) න්‍යෂ්ටියේ පවතින අතර ඉලෙක්ට්‍රෝන (e⁻) කක්ෂවල ගමන් කරයි",
        "සමස්ථානික: පරමාණුක ක්‍රමාංකය (Z) සමාන නමුත් ස්කන්ධ ක්‍රමාංකය (A) වෙනස් එකම මූලද්‍රව්‍යයේ පරමාණු (උදා: ¹H, ²H, ³H සහ ¹²C, ¹⁴C)",
        "සංයුජතා ඉලෙක්ට්‍රෝන: පරමාණුවක බාහිරතම ශක්ති මට්ටමේ පවතින ඉලෙක්ට්‍රෝන සංඛ්‍යාව"
      ),
      examTips = listOf(
        "💡 පළමු මූලද්‍රව්‍ය 20 (H සිට Ca දක්වා) ඉලෙක්ට්‍රොනික වින්‍යාසයන් කටපාඩමින් මතක තබා ගන්න.",
        "💡 ස්කන්ධ ක්‍රමාංකයට ඉලෙක්ට්‍රෝන ස්කන්ධය එකතු නොකරන්නේ එහි ස්කන්ධය අතිශය කුඩා බැවිනි."
      ),
      pdfUri = SCIENCE_GR10_FULL_PDF,
      fileName = "Grade10_Science_Unit02_AtomicStructure.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 3,
      gradeLevel = "10",
      titleSinhala = "ජීවයේ ඒකකය - සෛලය",
      category = ScienceCategoryFilter.BIOLOGY,
      pageRangeText = "පිටු 25-36",
      rootConcepts = listOf("සෛල වාදය", "ශාක සෛල හා සත්ත්ව සෛල", "සෛල ඉන්ද්‍රයිකා", "ප්‍රාග්න්‍යෂ්ටික හා සුන්‍යෂ්ටික"),
      keyFormulasOrLaws = listOf(
        "ආලෝක අන්වීක්ෂීය විශාලනය = උපනෙතේ විශාලනය × අවනෙතේ විශාලනය",
        "ශාක සෛල පමණක් සතු: සෛල බිත්තිය, හරිතලව, විශාල මධ්‍ය රික්තකය"
      ),
      highlights = listOf(
        "මයිටොකොන්ඩ්‍රියාව: සෛලීය ශ්වසනය මඟින් ATP ශක්තිය ජනනය කරන ශක්ති බලාගාරයයි",
        "රයිබොසෝම: ප්‍රෝටීන් සංශ්ලේෂණය සිදු කරන ප්‍රධාන අඩවිය",
        "න්‍යෂ්ටිය: ජානමය තොරතුරු (DNA/ක්‍රෝමසෝම) ගබඩා කර සෛල ක්‍රියා පාලනය කරයි",
        "ප්ලාස්ම පටලය: අර්ධ පාරගම්‍ය පටලයකි, ද්‍රව්‍ය හුවමාරුව පාලනය කරයි"
      ),
      examTips = listOf(
        "💡 විභාගයේදී ශාක හා සත්ත්ව සෛල අතර වෙනස්කම් වගුව නිතරම අසයි.",
        "💡 ප්ලාස්ම පටලය සජීවී වන අතර සෙලියුලෝස් සෛල බිත්තිය අජීවී බව මතක තබා ගන්න."
      ),
      pdfUri = SCIENCE_GR10_FULL_PDF,
      fileName = "Grade10_Science_Unit03_CellBiology.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 4,
      gradeLevel = "10",
      titleSinhala = "ආවර්තිතා වගුව සහ මූලද්‍රව්‍ය ලක්ෂණ",
      category = ScienceCategoryFilter.CHEMISTRY,
      pageRangeText = "පිටු 37-48",
      rootConcepts = listOf("ආවර්ත (තිරස්)", "කාණ්ඩ (සිරස්)", "ලෝහ, අලෝහ, උපලෝහ", "විද්‍යුත් සෘණතාව", "පළමු අයනීකරණ ශක්තිය"),
      keyFormulasOrLaws = listOf(
        "ආවර්ත අංකය = ඉලෙක්ට්‍රෝන පවතින ශක්ති මට්ටම් ගණන",
        "කාණ්ඩ අංකය = බාහිරතම ශක්ති මට්ටමේ ඉලෙක්ට්‍රෝන (සංයුජතා ඉලෙක්ට්‍රෝන) ගණන"
      ),
      highlights = listOf(
        "I කාණ්ඩය: ක්ෂාර ලෝහ (Li, Na, K) - ජලය සමඟ වේගයෙන් ප්‍රතික්‍රියා කර H₂ පිට කරයි",
        "II කාණ්ඩය: ක්ෂාරීය පාංශු ලෝහ (Mg, Ca)",
        "VII කාණ්ඩය: හැලජන (F, Cl, Br, I)",
        "VIII කාණ්ඩය: අලස වායු (He, Ne, Ar) - අෂ්ටක වින්‍යාසය සම්පූර්ණයි, අක්‍රීයයි"
      ),
      examTips = listOf(
        "💡 ආවර්තයක වමේ සිට දකුණට යනවිට පරමාණුක අරය අඩුවේ, විද්‍යුත් සෘණතාව වැඩිවේ.",
        "💡 කාණ්ඩයක ඉහළ සිට පහළට යනවිට කක්ෂ ගණන වැඩිවන බැවින් පරමාණුක අරය වැඩිවේ."
      ),
      pdfUri = SCIENCE_GR10_FULL_PDF,
      fileName = "Grade10_Science_Unit04_PeriodicTable.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 5,
      gradeLevel = "10",
      titleSinhala = "රේඛීය චලිතය (ප්‍රවේගය, ත්වරණය සහ ප්‍රස්ථාර)",
      category = ScienceCategoryFilter.PHYSICS,
      pageRangeText = "පිටු 49-62",
      rootConcepts = listOf("විස්ථාපනය හා දුර", "ප්‍රවේගය හා වේගය", "ත්වරණය හා මන්දනය", "චලිත සමීකරණ", "ප්‍රවේග-කාල ප්‍රස්ථාර"),
      keyFormulasOrLaws = listOf(
        "ප්‍රවේගය v = s / t",
        "ත්වරණය a = (v - u) / t (ඒකකය: m s⁻²)",
        "v = u + at | s = ut + ½ at² | v² = u² + 2as | s = ((u + v) / 2) × t",
        "ප්‍රවේග-කාල ප්‍රස්ථාරයක බෑවුම = ත්වරණය",
        "ප්‍රවේග-කාල ප්‍රස්ථාරය යටතේ වර්ගඵලය = විස්ථාපනය (කළ දුර)"
      ),
      highlights = listOf(
        "අදිශ රාශි (විශාලත්වය පමණි): දුර, වේගය, කාලය, ස්කන්ධය",
        "සදිශ රාශි (විශාලත්වය සහ දිශාව): විස්ථාපනය, ප්‍රවේගය, ත්වරණය, බලය",
        "ගුරුත්වජ ත්වරණය g = 10 m s⁻² (පොළොව දෙසට වැටෙන වස්තු සඳහා a = +g, ඉහළට විසි කරන විට a = -g)"
      ),
      examTips = listOf(
        "💡 ප්‍රවේග-කාල ප්‍රස්ථාරයකින් දුර සෙවීමට ත්‍රිකෝණ, ත්‍රපීසියම හෝ සෘජුකෝණාස්‍ර වර්ගඵල සූත්‍ර නිවැරදිව භාවිත කරන්න.",
        "💡 නිශ්චලතාවයෙන් ඇරඹෙන විට u = 0 වේ. තිරිංග යොදා නතර වන විට v = 0 වේ."
      ),
      pdfUri = SCIENCE_GR10_FULL_PDF,
      fileName = "Grade10_Science_Unit05_LinearMotion.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 6,
      gradeLevel = "10",
      titleSinhala = "ජෛව ගෝලය සහ පරිසර පද්ධති",
      category = ScienceCategoryFilter.EARTH_ENVIRONMENT,
      pageRangeText = "පිටු 63-74",
      rootConcepts = listOf("පරිසර පද්ධතියක සංරචක", "ජෛව සාධක හා අජෛව සාධක", "ආහාර දාම හා ආහාර ජාල", "ශක්ති පිරමිඩ", "ජෛව භූ රසායනික චක්‍ර"),
      keyFormulasOrLaws = listOf(
        "ශක්ති ගැලීමේ 10% නියමය: එක් පෝෂී මට්ටමක සිට ඊළඟ මට්ටමට සම්ප්‍රේෂණය වන්නේ ශක්තියෙන් 10% ක් පමණි"
      ),
      highlights = listOf(
        "නිෂ්පාදකයින් (හරිත ශාක/ස්වයංපෝෂීන්) → ප්‍රාථමික පාරිභෝගිකයින් (ශාකභක්ෂක) → ද්විතීයික → තෘතීයික",
        "වියෝජකයින් (බැක්ටීරියා, දිලීර): කාබනික ද්‍රව්‍ය අකාබනික පෝෂක බවට පත් කර පසට එකතු කරයි",
        "සහජීවනය: අන්‍යෝන්‍යෝපකාරය (+,+), සහභෝජනය (+,0), පරපෝෂිතතාව (+,-)"
      ),
      examTips = listOf(
        "💡 ශක්ති පිරමිඩයක් සැමවිටම ඍජු (ඉහළට පටු වන) එකක් වන අතර එය කිසිවිටෙකත් ප්‍රතිලෝම නොවේ.",
        "💡 ආහාර දාමයක ඊතලයේ දිශාව ශක්තිය ගලායන දිශාවට (කෑම ලබන්නා දෙසට) යොමු විය යුතුය."
      ),
      pdfUri = SCIENCE_GR10_FULL_PDF,
      fileName = "Grade10_Science_Unit06_Ecosystems.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 7,
      gradeLevel = "10",
      titleSinhala = "රසායනික බන්ධන (අයනික, සහසංයුජ සහ ලෝහක)",
      category = ScienceCategoryFilter.CHEMISTRY,
      pageRangeText = "පිටu 75-88",
      rootConcepts = listOf("අෂ්ටක නීතිය", "අයනික බන්ධන (ඉලෙක්ට්‍රෝන හුවමාරුව)", "සහසංයුජ බන්ධන (ඉලෙක්ට්‍රෝන හවුලේ තැබීම)", "ලෝහක බන්ධන"),
      keyFormulasOrLaws = listOf(
        "ලෝහ + අලෝහ = අයනික බන්ධන (උදා: Na⁺ + Cl⁻ → NaCl)",
        "අලෝහ + අලෝහ = සහසංයුජ බන්ධන (උදා: H₂O, CO₂, CH₄, NH₃)"
      ),
      highlights = listOf(
        "අයනික සංයෝග ලක්ෂණ: ඉහළ ද්‍රවාංක/තාපාංක, ඝන අවස්ථාවේදී විද්‍යුතය නොපවත්වයි, විලයිත හෝ ජලීය ද්‍රාවණ විද්‍යුතය සන්නයනය කරයි",
        "සහසංයුජ සංයෝග ලක්ෂණ: අඩු ද්‍රවාංක/තාපාංක, විද්‍යුත් අසන්නායක වේ (ග්‍රැෆයිට් හැර)",
        "ලෝහක බන්ධනය: නිදහස් ඉලෙක්ට්‍රෝන මුහුදක් තුළ ධන ලෝහ අයන ඇසිරීම"
      ),
      examTips = listOf(
        "💡 ලුවිස් තිත්-කතිර සටහන් (Lewis dot-cross diagram) ඇඳීමට විභාගයේදී ලකුණු 3-4ක් ලැබේ.",
        "💡 ජලය (H₂O) හි සහසංයුජ බන්ධන 2ක් සහ බන්ධනවලට සහභාගී නොවූ එකසර ඉලෙක්ට්‍රෝන යුගල 2ක් ඇත."
      ),
      pdfUri = SCIENCE_GR10_FULL_PDF,
      fileName = "Grade10_Science_Unit07_ChemicalBonding.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 8,
      gradeLevel = "10",
      titleSinhala = "නිව්ටන් නියම සහ බලය (බල සමතුලිතතාව)",
      category = ScienceCategoryFilter.PHYSICS,
      pageRangeText = "පිටු 89-102",
      rootConcepts = listOf("නිව්ටන්ගේ 1, 2, 3 වන නියම", "ස්ථිති විද්‍යාව", "ඝර්ෂණ බලය", "ගම්‍යතාව"),
      keyFormulasOrLaws = listOf(
        "නිව්ටන් 1 වන නියමය: බාහිර අසමතුලිත බලයක් නොයෙදෙන තාක් නිශ්චල වස්තු නිශ්චලවද ඒකාකාර ප්‍රවේගයෙන් යන වස්තු ඒ ආකාරයෙන්මද පවතී",
        "නිව්ටන් 2 වන නියමය: F = m a (බලය N = ස්කන්ධය kg × ත්වරණය m s⁻²)",
        "නිව්ටන් 3 වන නියමය: සෑම ක්‍රියාවකටම විශාලත්වයෙන් සමාන දිශාවෙන් ප්‍රතිවිරුද්ධ ප්‍රතික්‍රියාවක් ඇත",
        "ගම්‍යතාව p = m × v (ඒකකය: kg m s⁻¹)"
      ),
      highlights = listOf(
        "ඝර්ෂණ බලය: ස්පර්ශ පෘෂ්ඨ අතර සාපේක්ෂ චලිතය වළක්වන බලය (සීමාකාරී ඝර්ෂණය F = μR)",
        "ක්‍රියාව සහ ප්‍රතික්‍රියාව ක්‍රියා කරන්නේ එකිනෙකට වෙනස් වස්තු දෙකක් මත බැවින් ඒවා එකිනෙක කැපී නොයයි"
      ),
      examTips = listOf(
        "💡 ස්කන්ධය ග්‍රෑම් (g) වලින් දුන් විට 1000න් බෙදා කිලෝග්‍රෑම් (kg) වලට හරවා සූත්‍රයට ආදේශ කරන්න.",
        "💡 තිරස් තලයක වස්තුවක් මත අභිලම්භ ප්‍රතික්‍රියාව R = mg වේ."
      ),
      pdfUri = SCIENCE_GR10_FULL_PDF,
      fileName = "Grade10_Science_Unit08_NewtonLawsForces.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 9,
      gradeLevel = "10",
      titleSinhala = "ශාක හා සත්ත්ව පටක",
      category = ScienceCategoryFilter.BIOLOGY,
      pageRangeText = "පිටු 103-116",
      rootConcepts = listOf("විභාජක පටක", "ස්ථිර පටක (සරල හා සංකීර්ණ)", "සත්ත්ව පටක (උපකලා, පේශි, ස්නායු, සම්බන්ධක)"),
      keyFormulasOrLaws = listOf(
        "ශාක සංකීර්ණ සනාල පටක: ශෛලමය (ජලය හා ඛණිජ ප්‍රවාහනය) සහ ප්ලෝයමය (ආහාර ප්‍රවාහනය)"
      ),
      highlights = listOf(
        "ශාක සරල පටක: මෘදුස්තර (ආහාර සංචිතය), ස්ථූලකෝණාස්තර (නම්‍යශීලී යාන්ත්‍රික ශක්තිය), දෘඪස්තර (දෘඪ යාන්ත්‍රික ශක්තිය - අජීවී)",
        "ශෛලමයේ සංඝටක: වාහිනී, වාහිනිකා, ශෛලම තන්තු, ශෛලම මෘදුස්තර",
        "ප්ලෝයමයේ සංඝටක: පෙනේර නළ, සහචර සෛල, ප්ලෝයම තන්තු, ප්ලෝයම මෘදුස්තර",
        "සත්ත්ව සම්බන්ධක පටක: රුධිරය (ද්‍රව පටකයකි), අස්ථි, කාටිලේජ"
      ),
      examTips = listOf(
        "💡 ශෛලම වාහිනී හා වාහිනිකා පරිණත වූ විට මියගිය සෛල වන අතර ලිග්නින් තැන්පත් වී ඇත.",
        "💡 පෙනේර නළ වල න්‍යෂ්ටියක් නොමැති අතර එහි ක්‍රියාකාරීත්වය පාලනය කරන්නේ සහචර සෛලයේ න්‍යෂ්ටිය මගිනි."
      ),
      pdfUri = SCIENCE_GR10_FULL_PDF,
      fileName = "Grade10_Science_Unit09_PlantAnimalTissues.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 10,
      gradeLevel = "10",
      titleSinhala = "ප්‍රභාසංස්ලේෂණය",
      category = ScienceCategoryFilter.BIOLOGY,
      pageRangeText = "පිටු 117-128",
      rootConcepts = listOf("ප්‍රභාසංස්ලේෂණ සමීකරණය", "ප්‍රභා ප්‍රතික්‍රියාව", "අඳුරු ප්‍රතික්‍රියාව", "සීමාකාරී සාධක (ආලෝකය, CO₂, උෂ්ණත්වය)"),
      keyFormulasOrLaws = listOf(
        "සමතුලිත සමීකරණය: 6CO₂ + 6H₂O  (ආලෝකය & හරිතලව) → C₆H₁₂O₆ + 6O₂"
      ),
      highlights = listOf(
        "ප්‍රභාසංස්ලේෂණයේ අතුරු ඵලය ලෙස ඔක්සිජන් (O₂) වායුව පිටවේ (ජල අණුව විච්ඡේදනය වීමෙන්)",
        "ආලෝක ප්‍රතික්‍රියාව තයිලකොයිඩ පටලයේ ග්‍රානා තුළ සිදුවේ (ජලයේ ප්‍රකාශ විච්ඡේදනය)",
        "අඳුරු ප්‍රතික්‍රියාව (කැල්වින් චක්‍රය) හරිතලව පංජරය (ස්ට්‍රෝමාව) තුළ සිදුවේ (කාබන් තිරකිරීම)"
      ),
      examTips = listOf(
        "💡 පත්‍රයක පිෂ්ඨය පරීක්ෂා කිරීමට පෙර ඇල්කොහොල් තුළ බහා ජල තාපකයක රත් කර හරිතප්‍රද ඉවත් කළ යුතුය.",
        "💡 වායුගෝලයට ඔක්සිජන් එක් කරන පෘථිවියේ ප්‍රධානම ජෛව ක්‍රියාවලිය මෙයයි."
      ),
      pdfUri = SCIENCE_GR10_FULL_PDF,
      fileName = "Grade10_Science_Unit10_Photosynthesis.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 11,
      gradeLevel = "10",
      titleSinhala = "රසායනික ප්‍රතික්‍රියා සහ ශක්ති විපර්යාස",
      category = ScienceCategoryFilter.CHEMISTRY,
      pageRangeText = "පිටු 129-142",
      rootConcepts = listOf("තාපදායක ප්‍රතික්‍රියා (ΔH < 0)", "තාපඅවශෝෂක ප්‍රතික්‍රියා (ΔH > 0)", "සංයෝජන, වියෝජන, තනි විස්ථාපන, ද්විත්ව විස්ථාපන ප්‍රතික්‍රියා"),
      keyFormulasOrLaws = listOf(
        "තාපදායක: ප්‍රතික්‍රියක → ඵල + තාපය (උෂ්ණත්වය ඉහළ යයි)",
        "තාපඅවශෝෂක: ප්‍රතික්‍රියක + තාපය → ඵල (උෂ්ණත්වය පහළ යයි)"
      ),
      highlights = listOf(
        "සක්‍රියතා ශ්‍රේණිය: K > Na > Ca > Mg > Al > Zn > Fe > Pb > (H) > Cu > Ag > Au",
        "සක්‍රියතාවයෙන් ඉහළ ලෝහයකට පහළ ලෝහයක ලවණ ද්‍රාවණයකින් එය විස්ථාපනය කළ හැක (උදා: Fe + CuSO₄ → FeSO₄ + Cu)",
        "උදාසීනීකරණ ප්‍රතික්‍රියාව: අම්ලය + භෂ්මය → ලවණය + ජලය (තාපදායකයි)"
      ),
      examTips = listOf(
        "💡 සක්‍රියතා ශ්‍රේණිය මතක තබා ගැනීමට 'කෝ නා කපු මහතා ඇවිත් සින්ක් යකඩ ඊයම් හයිඩ්‍රජන් තඹ රිදී රත්තරන්' වාක්‍යය භාවිත කරන්න.",
        "💡 රසායනික සමීකරණ ලියන විට දෙපස පරමාණු ගණන තුලනය කිරීමට අමතක නොකරන්න."
      ),
      pdfUri = SCIENCE_GR10_FULL_PDF,
      fileName = "Grade10_Science_Unit11_ChemicalReactionsEnergy.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 12,
      gradeLevel = "10",
      titleSinhala = "ඝූර්ණය සහ බල යුග්මය",
      category = ScienceCategoryFilter.PHYSICS,
      pageRangeText = "පිටු 143-154",
      rootConcepts = listOf("බලයක ඝූර්ණය", "දක්ෂිණාවර්ත හා වාමාවර්ත ඝූර්ණ", "ඝූර්ණ මූලධර්මය", "බල යුග්මය", "ලිවර් වර්ග"),
      keyFormulasOrLaws = listOf(
        "බලයක ඝූර්ණය (M) = බලය (F) × භ්‍රමණ අක්ෂයේ සිට බලයට ලම්බ දුර (d) [ඒකකය: N m]",
        "ඝූර්ණ මූලධර්මය: සමතුලිතතාවයේ පවතින පද්ධතියක සමස්ත වාමාවර්ත ඝූර්ණය = සමස්ත දක්ෂිණාවර්ත ඝූර්ණය"
      ),
      highlights = listOf(
        "බල යුග්මය: එකම සරල රේඛාවේ නොපිහිටි, විශාලත්වයෙන් සමාන, ප්‍රතිවිරුද්ධ දිශාගත සමාන්තර බල දෙකක් (උදා: සුක්කානම කරකැවීම, කරාමය කරකැවීම)",
        "පළමු පෙළ ලිවර්: ආධාරකය මැද (කතුර, අඬුව)",
        "දෙවන පෙළ ලිවර්: භාරය මැද (අත් කරත්තය, පුවක් ගිරය)",
        "තෙවන පෙළ ලිවර්: ආයාසය මැද (අඬුව, මාළු බෑමේ බිලිපිත්ත)"
      ),
      examTips = listOf(
        "💡 දුර සෙන්ටිමීටර් (cm) වලින් දුන් විට 100න් බෙදා මීටර් (m) වලට හරවා N m ඒකකයෙන් ලියන්න.",
        "💡 භ්‍රමණ අක්ෂය හරහා බලය යෙදූ විට ලම්බ දුර d = 0 වන බැවින් ඝූර්ණයක් ඇති නොවේ."
      ),
      pdfUri = SCIENCE_GR10_FULL_PDF,
      fileName = "Grade10_Science_Unit12_MomentsCouples.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 13,
      gradeLevel = "10",
      titleSinhala = "කාරක ශක්තිය සහ ක්ෂමතාව",
      category = ScienceCategoryFilter.PHYSICS,
      pageRangeText = "පිටු 155-168",
      rootConcepts = listOf("කාර්යය (Work)", "යාන්ත්‍රික ශක්තිය (විභව හා චාලක)", "ශක්ති සංස්ථිති නියමය", "ක්ෂමතාව (Power)"),
      keyFormulasOrLaws = listOf(
        "කාර්යය W = F × s (බලය N × බලයේ දිශාවට කළ විස්ථාපනය m) [ඒකකය: J (ජූල්)]",
        "ගුරුත්වාකර්ෂණ විභව ශක්තිය Ep = m g h (g = 10 m s⁻²)",
        "චාලක ශක්තිය Ek = ½ m v²",
        "ක්ෂමතාව P = W / t = E / t (ඒකකය: W (වොට්) හෝ J s⁻¹)"
      ),
      highlights = listOf(
        "ශක්ති සංස්ථිති නියමය: ශක්තිය මැවීම හෝ විනාශ කිරීම කළ නොහැක. එක් ආකාරයකින් තවත් ආකාරයකට පරිවර්තනය කළ හැක්කේය",
        "කාර්යයක් සිදුවීමට නම් බලයක් යෙදිය යුතු අතර එම බලයේ දිශාවට විස්ථාපනයක් සිදුවිය යුතුය (බලයට ලම්බකව විස්ථාපනය වුවහොත් W = 0)"
      ),
      examTips = listOf(
        "💡 1 kW = 1000 W බවත්, 1 kJ = 1000 J බවත් මතක තබා ගන්න.",
        "💡 නිදහසේ වැටෙන වස්තුවක ඉහළම ලක්ෂ්‍යයේදී Ep උපරිමයි (Ek=0), බිම වදින මොහොතේදී Ek උපරිමයි (Ep=0)."
      ),
      pdfUri = SCIENCE_GR10_FULL_PDF,
      fileName = "Grade10_Science_Unit13_WorkEnergyPower.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 14,
      gradeLevel = "10",
      titleSinhala = "පදාර්ථයේ ගුණ සහ ද්‍රාවණ",
      category = ScienceCategoryFilter.CHEMISTRY,
      pageRangeText = "පිටු 169-182",
      rootConcepts = listOf("ද්‍රාව්‍යතාව (Solubility)", "ද්‍රාවණ සාන්ද්‍රණය", "ස්කන්ධ/ස්කන්ධ (w/w%), පරිමා/පරිමා (v/v%), ස්කන්ධ/පරිමා (w/v%)", "මවුලික සාන්ද්‍රණය (mol dm⁻³)"),
      keyFormulasOrLaws = listOf(
        "මවුල ගණන n = ස්කන්ධය (m) / මවුලික ස්කන්ධය (M)",
        "සාන්ද්‍රණය c = n / V (මවුල ගණන mol / ද්‍රාවණයේ පරිමාව dm³)",
        "1 dm³ = 1000 cm³ = 1 L"
      ),
      highlights = listOf(
        "ද්‍රාව්‍යතාව: නියත උෂ්ණත්වයකදී ද්‍රාවක 100 g ක දියකළ හැකි උපරිම ද්‍රාව්‍ය ස්කන්ධයයි",
        "උෂ්ණත්වය වැඩිවන විට බොහෝ ඝන ද්‍රාව්‍යවල ද්‍රාව්‍යතාව වැඩිවන නමුත් වායුවල ද්‍රාව්‍යතාව අඩුවේ",
        "සන්තෘප්ත ද්‍රාවණය: තවදුරටත් ද්‍රාව්‍ය දිය නොවන උපරිමයට ළඟා වූ ද්‍රාවණය"
      ),
      examTips = listOf(
        "💡 පරිමාව cm³ වලින් දුන් විට 1000න් බෙදා dm³ වලට හරවා සාන්ද්‍රණ සූත්‍රයට ආදේශ කරන්න.",
        "💡 මවුලික ස්කන්ධය ගණනය කිරීමේදී එක් එක් පරමාණුවේ සාපේක්ෂ පරමාණුක ස්කන්ධ එකතු කරන්න (උදා: NaOH = 23 + 16 + 1 = 40 g mol⁻¹)."
      ),
      pdfUri = SCIENCE_GR10_FULL_PDF,
      fileName = "Grade10_Science_Unit14_MatterSolutions.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 15,
      gradeLevel = "10",
      titleSinhala = "ධාරා විද්‍යුතය සහ විදුලි පරිපථ",
      category = ScienceCategoryFilter.PHYSICS,
      pageRangeText = "පිටු 183-198",
      rootConcepts = listOf("ඕම් නියමය (Ohm's Law)", "ප්‍රතිරෝධය (R)", "ශ්‍රේණිගත සහ සමාන්තරගත ප්‍රතිරෝධක", "විද්‍යුත් ධාරාව (I)", "විභව අන්තරය (V)"),
      keyFormulasOrLaws = listOf(
        "ඕම් නියමය: V = I × R (V = වෝල්ට්, I = ඇම්පියර්, R = ඕම් Ω)",
        "ශ්‍රේණිගත සමක ප්‍රතිරෝධය: R_eq = R₁ + R₂ + R₃ ...",
        "සමාන්තරගත සමක ප්‍රතිරෝධය: 1/R_eq = 1/R₁ + 1/R₂ + 1/R₃ ...",
        "විද්‍යුත් ආරෝපණය Q = I × t (C = A × s)"
      ),
      highlights = listOf(
        "ඇමීටරය පරිපථයට ශ්‍රේණිගතව සම්බන්ධ කරයි (අභ්‍යන්තර ප්‍රතිරෝධය ඉතා අඩුය)",
        "වෝල්ට්මීටරය සංරචකයට සමාන්තරගතව සම්බන්ධ කරයි (අභ්‍යන්තර ප්‍රතිරෝධය ඉතා ඉහළය)",
        "ශ්‍රේණිගත පරිපථයක සියලු ප්‍රතිරෝධක හරහා එකම ධාරාව (I) ගලායයි",
        "සමාන්තරගත පරිපථයක එක් එක් ශාඛාව හරහා එකම විභව අන්තරය (V) පවතී"
      ),
      examTips = listOf(
        "💡 සමාන්තරගත සමාන ප්‍රතිරෝධක දෙකක සමකය R/2 වේ (උදා: 10 Ω දෙකක සමකය 5 Ω).",
        "💡 ගෘහ විදුලි රැහැනේ සියලු උපකරණ සමාන්තරගතව සම්බන්ධ කරන්නේ එකක දෝෂයක් අනෙකට බල නොපෑමට සහ උපරිම සැපයුම් වෝල්ටීයතාව ලැබීමටය."
      ),
      pdfUri = SCIENCE_GR10_FULL_PDF,
      fileName = "Grade10_Science_Unit15_CurrentElectricity.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 16,
      gradeLevel = "10",
      titleSinhala = "පෘථිවි සම්පත් සහ පාෂාණ චක්‍රය",
      category = ScienceCategoryFilter.EARTH_ENVIRONMENT,
      pageRangeText = "පිටු 199-210",
      rootConcepts = listOf("භූ ගෝලය, ජල ගෝලය, වායු ගෝලය", "පාෂාණ වර්ග (ආග්නේය, අවසාදිත, විපරිත)", "පාෂාණ කාලගුණිකරණය", "ඛණිජ හා ලෝපස්"),
      keyFormulasOrLaws = listOf(
        "ආග්නේය (මැග්මා සිසිල් වීමෙන් - ග්‍රැනයිට්, බැසෝල්ට්) → අවසාදිත (තැන්පත් වීමෙන් - වැලිගල්, හුණුගල්) → විපරිත (තාපය හා පීඩනයෙන් - කිරිගරුඬ, ග්නයිස්)"
      ),
      highlights = listOf(
        "ශ්‍රී ලංකාවේ ඛණිජ සම්පත්: මිනිරන් (Graphite), ඉල්මනයිට්, රූටයිල්, සිර්කෝන්, ඇපටයිට් (එප්පාවල), මැණික්",
        "පස සෑදීම: භෞතික, රසායනික හා ජෛව විද්‍යාත්මක කාලගුණිකරණය මගින් පාෂාණ කුඩු වී හියුමස් මිශ්‍ර වීමෙන්"
      ),
      examTips = listOf(
        "💡 පොස්පේට් පොහොර සඳහා භාවිත කරන්නේ එප්පාවල ඇපටයිට් නිධියයි.",
        "💡 පිරිසිදු කාබන් වලින් සැදුම්ලත් ස්වභාවික ඛණිජයක් ලෙස ශ්‍රී ලංකාවේ මිනිරන් ලෝක ප්‍රසිද්ධය."
      ),
      pdfUri = SCIENCE_GR10_FULL_PDF,
      fileName = "Grade10_Science_Unit16_EarthResources.pdf"
    ),

    // -------------------------------------------------------------
    // GRADE 11 (20 Units)
    // -------------------------------------------------------------
    ScienceUnitShortNote(
      unitNumber = 17,
      gradeLevel = "11",
      titleSinhala = "ජීවීන්ගේ ලක්ෂණ සහ ප්‍රවේණිය (Mendelian Genetics)",
      category = ScienceCategoryFilter.BIOLOGY,
      pageRangeText = "පිටු 1-16",
      rootConcepts = listOf("මෙන්ඩල්ගේ නීති", "ප්‍රමුඛ හා නිලීන ඇලීල", "සමයුග්මක හා විෂමයුග්මක", "ප්‍රවේණිදර්ශය හා රූපාදර්ශය", "මොනොහයිබ්‍රිඩ් මුහුම (1:2:1 & 3:1)", "ලිංග නිර්ණය"),
      keyFormulasOrLaws = listOf(
        "F2 පරම්පරාවේ රූපාදර්ශ අනුපාතය = 3:1 (ප්‍රමුඛ : නිලීන)",
        "F2 පරම්පරාවේ ප්‍රවේණිදර්ශ අනුපාතය = 1:2:1 (TT : Tt : tt)",
        "මානව වර්ණදේහ: දේහ වර්ණදේහ යුගල 22 + ලිංගික වර්ණදේහ යුගල 1 (ස්ත්‍රී: XX, පුරුෂ: XY)"
      ),
      highlights = listOf(
        "මෙන්ඩල් පරීක්ෂණ සඳහා මෑ ශාකය (Pisum sativum) තෝරාගත්තේ පහසුවෙන් පරාගනය කළ හැකි, පැහැදිලි විකල්ප ලක්ෂණ සහිත, කෙටි ආයුකාලයක් ඇති බැවිනි",
        "දරුවාගේ ලිංගය තීරණය වන්නේ පියාගෙන් ලැබෙන ශුක්‍රාණුවේ ඇති X හෝ Y වර්ණදේහය මතය (50% සම්භාවිතාව)",
        "විකෘති (Mutations): DNA අණුවක සිදුවන හදිසි ස්ථිර වෙනස්වීම්"
      ),
      examTips = listOf(
        "💡 පනට් කොටුව (Punnett Square) ඇඳීමේදී ජන්මාණු නිවැරදිව රවුම් කර වෙන් කර පෙන්වන්න.",
        "💡 අලිංගික ප්‍රජනනයෙන් ක්ලෝන (ජානමය වශයෙන් සමාන ජීවීන්) බිහිවන අතර ලිංගික ප්‍රජනනයෙන් විචල්‍යතා බිහිවේ."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit01_GeneticsInheritance.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 18,
      gradeLevel = "11",
      titleSinhala = "ප්‍රභාසංස්ලේෂණය හා ශ්වසනය (ජෛව රසායනය)",
      category = ScienceCategoryFilter.BIOLOGY,
      pageRangeText = "පිටු 17-30",
      rootConcepts = listOf("සෛලීය ශ්වසනය", "වායුගෝලීය ශ්වසනය (Aerobic)", "නිර්වායු ශ්වසනය (Anaerobic / පැසවීම)", "ATP නිෂ්පාදනය", "ශ්වසන ලබ්ධිය (RQ)"),
      keyFormulasOrLaws = listOf(
        "වායුගෝලීය ශ්වසනය: C₆H₁₂O₆ + 6O₂ → 6CO₂ + 6H₂O + 38 ATP",
        "යීස්ට් මත්පැන් පැසවීම: C₆H₁₂O₆ → 2C₂H₅OH (එතනෝල්) + 2CO₂ + 2 ATP",
        "පේශිවල ලැක්ටික් අම්ල පැසවීම: C₆H₁₂O₆ → 2 ලැක්ටික් අම්ලය + 2 ATP"
      ),
      highlights = listOf(
        "ග්ලයිකොලිසිස්: සයිටොප්ලාස්මයේදී සිදුවේ (ග්ලූකෝස් → පයිරුවේට්)",
        "ක්‍රෙබ්ස් චක්‍රය: මයිටොකොන්ඩ්‍රියා පංජරයේදී සිදුවේ",
        "ඉලෙක්ට්‍රෝන ප්‍රවාහන දාමය: මයිටොකොන්ඩ්‍රියා ක්‍රිස්ටේ පටලයේදී සිදුවේ (වැඩිම ATP ප්‍රමාණය නිපදවයි)",
        "ප්‍රභාසංස්ලේෂණය හා ශ්වසනය පෘථිවියේ කාබන්-ඔක්සිජන් තුල්‍යතාව පවත්වා ගනී"
      ),
      examTips = listOf(
        "💡 මලල ක්‍රීඩකයින් දැඩි ව්‍යායාම වලදී ඔක්සිජන් ණය තත්ත්වයට පත්වී පේශි තුළ ලැක්ටික් අම්ලය තැන්පත් වීමෙන් පේශි පෙරළීම/වේදනාව හටගනී.",
        "💡 වායුගෝලීය ශ්වසනයේදී නිර්වායු ශ්වසනයට වඩා 19 ගුණයක (38 ATP vs 2 ATP) වැඩි ශක්තියක් නිපදවයි."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit02_CellRespiration.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 19,
      gradeLevel = "11",
      titleSinhala = "පදාර්ථයේ ප්‍රමාණාත්මක විමර්ශනය (මවුලය සහ ස්ටොයිකියෝමිතිය)",
      category = ScienceCategoryFilter.CHEMISTRY,
      pageRangeText = "පිටු 31-46",
      rootConcepts = listOf("ඇවගාඩ්රෝ නියතය (L = 6.022 × 10²³)", "මවුලය (Mole)", "මවුලික ස්කන්ධය", "මවුලික පරිමාව (22.4 dm³ at STP)", "ප්‍රතික්‍රියා ස්ටොයිකියෝමිතිය"),
      keyFormulasOrLaws = listOf(
        "මවුල ගණන n = ස්කන්ධය m (g) / මවුලික ස්කන්ධය M (g mol⁻¹)",
        "අංශු ගණන N = මවුල ගණන n × ඇවගාඩ්රෝ නියතය (6.022 × 10²³)",
        "STP හිදී වායුවක පරිමාව V = n × 22.4 dm³ (22,400 cm³)",
        "සාන්ද්‍රණය c = n / V (mol dm⁻³)"
      ),
      highlights = listOf(
        "ඕනෑම ද්‍රව්‍යයක මවුල 1 ක අංශු 6.022 × 10²³ ක් (ඇවගාඩ්රෝ නියතය) අඩංගු වේ",
        "STP (සම්මත උෂ්ණත්වය 0 °C සහ පීඩනය 1 atm) හිදී ඕනෑම වායුවක මවුල 1 ක පරිමාව 22.4 dm³ වේ",
        "සමතුලිත රසායනික සමීකරණයක සංගුණක මඟින් මවුල අනුපාතය නිරූපණය කරයි"
      ),
      examTips = listOf(
        "💡 මවුලික ස්කන්ධය ගණනය කිරීමේදී නිවැරදි ඒකකය (g mol⁻¹) සඳහන් කරන්න.",
        "💡 ස්කන්ධය → මවුල → පරිමාව හෝ අංශු ගණන පියවරෙන් පියවර ගණනය කිරීමෙන් සම්පූර්ණ ලකුණු ලබාගත හැක."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit03_MoleStoichiometry.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 20,
      gradeLevel = "11",
      titleSinhala = "තරංග සහ ඒවායේ යෙදීම් (ආලෝකය සහ ධ්වනිය)",
      category = ScienceCategoryFilter.PHYSICS,
      pageRangeText = "පිටු 47-64",
      rootConcepts = listOf("යාන්ත්‍රික හා විද්‍යුත් චුම්භක තරංග", "තිරස් සහ අන්වායාම තරංග", "තරංග සමීකරණය (v = f λ)", "ආලෝකයේ වර්තනය සහ පරාවර්තනය", "පූර්ණ අභ්‍යන්තර පරාවර්තනය", "ධ්වනි තරංග"),
      keyFormulasOrLaws = listOf(
        "තරංග සමීකරණය: v = f × λ (v = ප්‍රවේගය m s⁻¹, f = සංඛ්‍යාතය Hz, λ = තරංග ආයාමය m)",
        "ස්නෙල්ගේ නියමය: sin i / sin r = නියතයකි (වර්තනාංකය n)",
        "පූර්ණ අභ්‍යන්තර පරාවර්තන කොන්දේසි: ආලෝකය ඝන මාධ්‍යයේ සිට තුනී මාධ්‍යයට යා යුතුය, පතන කෝණය i > අවධි කෝණය C විය යුතුය"
      ),
      highlights = listOf(
        "අන්වායාම තරංග: මාධ්‍යයේ අංශු කම්පනය වන්නේ තරංගය ගමන් කරන දිශාවට සමාන්තරවය (උදා: ශබ්ද තරංග - සම්පීඩන හා විරලන)",
        "තිරස් තරංග: මාධ්‍යයේ අංශු කම්පනය වන්නේ තරංගය ගමන් කරන දිශාවට ලම්බකවය (උදා: ආලෝක තරංග, ජල තරංග - ශිඛර හා නිම්න)",
        "පූර්ණ අභ්‍යන්තර පරාවර්තනයේ යෙදීම්: ප්‍රකාශ තන්තු (Optical fibers), මිරිඟුව, දියමන්ති දිලිසීම"
      ),
      examTips = listOf(
        "💡 ශබ්ද තරංග ගමන් කිරීමට මාධ්‍යයක් අවශ්‍ය වේ (රික්තයක් තුළින් ශබ්දය නොයයි). ආලෝකය රික්තය තුළින්ද (3 × 10⁸ m s⁻¹) ගමන් කරයි.",
        "💡 තරංග ආයාමය සෙන්ටිමීටර (cm) වලින් දුන් විට 100න් බෙදා මීටර් (m) කර v = f λ සමීකරණයට ආදේශ කරන්න."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit04_WavesOpticsSound.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 21,
      gradeLevel = "11",
      titleSinhala = "පදාර්ථයේ වෙනස්වීම් (රසායනික ප්‍රතික්‍රියා සීඝ්‍රතාව)",
      category = ScienceCategoryFilter.CHEMISTRY,
      pageRangeText = "පිටු 65-78",
      rootConcepts = listOf("ප්‍රතික්‍රියා සීඝ්‍රතාව", "ගැටුම් වාදය", "සීඝ්‍රතාව කෙරෙහි බලපාන සාධක (භෞතික ස්වභාවය/පෘෂ්ඨ වර්ගඵලය, සාන්ද්‍රණය, උෂ්ණත්වය, උත්ප්‍රේරක)"),
      keyFormulasOrLaws = listOf(
        "ප්‍රතික්‍රියා සීඝ්‍රතාව = (ප්‍රතික්‍රියක සාන්ද්‍රණයේ අඩුවීම හෝ ඵල සාන්ද්‍රණයේ වැඩිවීම) / ඒ සඳහා ගතවූ කාලය"
      ),
      highlights = listOf(
        "පෘෂ්ඨ වර්ගඵලය වැඩිවන විට (කුඩු කළ විට) ඵලදායී ගැටුම් සංඛ්‍යාව වැඩිවී සීඝ්‍රතාව වැඩිවේ",
        "උෂ්ණත්වය වැඩිවන විට අංශුවල චාලක ශක්තිය වැඩිවී සක්‍රියන ශක්තිය ඉක්මවා යන අංශු ගණන වැඩිවේ",
        "උත්ප්‍රේරක: ප්‍රතික්‍රියාවේ සක්‍රියන ශක්තිය අඩු කර ප්‍රතික්‍රියාව අවසානයේ රසායනිකව නොවෙනස්ව පවතී"
      ),
      examTips = listOf(
        "💡 CaCO₃ කැබලි වෙනුවට කුඩු දැමූ විට CO₂ වායුව වේගයෙන් පිටවන්නේ ඇයි දැයි විමසූ විට 'පෘෂ්ඨ වර්ගඵලය වැඩිවීමෙන් ඵලදායී ගැටුම් සීඝ්‍රතාව වැඩිවීම' යන වචන ලියන්න."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit05_ReactionRates.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 22,
      gradeLevel = "11",
      titleSinhala = "ජීවයේ අඛණ්ඩතාවය (මානව ප්‍රජනන පද්ධතිය)",
      category = ScienceCategoryFilter.BIOLOGY,
      pageRangeText = "පිටු 79-94",
      rootConcepts = listOf("පුරුෂ ප්‍රජනක පද්ධතිය", "ස්ත්‍රී ප්‍රජනක පද්ධතිය", "ආර්තව චක්‍රය සහ හෝමෝන (FSH, LH, ඊස්ට්‍රජන්, ප්‍රොජෙස්ටරෝන්)", "සංසේචනය සහ ගර්භනීභාවය", "උපත් පාලන ක්‍රම"),
      keyFormulasOrLaws = listOf(
        "සංසේචනය සිදුවන ස්ථානය: පැලෝපීය නාලය (පැණිරස නාලය / පැලෝපීය නාලයේ ඉහළ 1/3 කොටස)",
        "යුක්තානුව ගර්භාෂ බිත්තියේ තැන්පත් වීම = අධිරෝපණය"
      ),
      highlights = listOf(
        "වෘෂණ කෝෂ ශරීර කුහරයෙන් පිටත පිහිටන්නේ ශුක්‍රාණු ජනනයට දේහ උෂ්ණත්වයට වඩා 2-3 °C අඩු උෂ්ණත්වයක් අවශ්‍ය බැවිනි",
        "ඩිම්බ මෝචනය සාමාන්‍යයෙන් ආර්තව චක්‍රයේ 14 වන දිනයේදී LH හෝමෝනයේ උපරිමය නිසා සිදුවේ",
        "වැදෑමහ (Placenta): මව සහ කලලය අතර පෝෂක, O₂ සහ අපද්‍රව්‍ය හුවමාරුව සිදුකරයි (රුධිරය සෘජුව මිශ්‍ර නොවේ)"
      ),
      examTips = listOf(
        "💡 හෝමෝන ක්‍රියාකාරීත්වය (FSH, LH, Estrogen, Progesterone) පිළිබඳ ප්‍රස්ථාර විභාගයේදී නිතර අසන ප්‍රශ්නයකි.",
        "💡 ස්ථිර උපත් පාලන ක්‍රම: පුරුෂයින්ගේ වාසෙක්ටමි (Vasectomy) සහ කාන්තාවන්ගේ ලැපරොස්කොපි (LRC - නාල ගැටගැසීම)."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit06_HumanReproduction.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 23,
      gradeLevel = "11",
      titleSinhala = "තාපය සහ එහි සම්ප්‍රේෂණය (තාප ධාරිතාව)",
      category = ScienceCategoryFilter.PHYSICS,
      pageRangeText = "පිටු 95-110",
      rootConcepts = listOf("තාපය සහ උෂ්ණත්වය", "තාප සන්නයනය, සංවහනය, විකිරණය", "විශිෂ්ට තාප ධාරිතාව (c)", "විශිෂ්ට ගුප්ත තාපය (L)", "තාප සමතුලිතතාව"),
      keyFormulasOrLaws = listOf(
        "උෂ්ණත්ව වෙනස සඳහා තාපය Q = m × c × θ (m = kg, c = J kg⁻¹ °C⁻¹, θ = °C)",
        "අවස්ථා විපර්යාසය සඳහා තාපය Q = m × L (L = විලයනයේ හෝ වාෂ්පීකරණයේ විශිෂ්ට ගුප්ත තාපය J kg⁻¹)",
        "තාප හානියක් නැති විට: එක් වස්තුවක් පිටකළ තාපය = අනෙක් වස්තුව ලබාගත් තාපය"
      ),
      highlights = listOf(
        "ජලයේ ඉහළ විශිෂ්ට තාප ධාරිතාව (4200 J kg⁻¹ °C⁻¹): සිසිලනකාරකයක් ලෙස මෝටර් රථ රේඩියේටර්වල භාවිතය, මුහුදු සුළං හා ගොඩබිම් සුළං ඇතිවීම",
        "සන්නයනය: ඝන ද්‍රව්‍යවල අංශු ස්ථාන මාරු නොවී කම්පනයෙන්",
        "සංවහනය: ද්‍රව හා වායුවල අංශු ඝනත්ව වෙනස නිසා ස්ථාන මාරු වීමෙන්",
        "විකිරණය: මාධ්‍යයක් අනවශ්‍යයි, විද්‍යුත් චුම්භක තරංග ලෙස (සූර්ය තාපය පෘථිවියට ඒම)"
      ),
      examTips = listOf(
        "💡 අවස්ථා විපර්යාසයේදී (በረදු දියවීම හෝ ජලය වාෂ්ප වීම) උෂ්ණත්වය වෙනස් නොවන අතර එහිදී Q = mL සූත්‍රය යොදන්න.",
        "💡 දීප්තිමත්/සුදු පෘෂ්ඨ තාප විකිරණ හොඳින් පරාවර්තනය කරන අතර අඳුරු/කළු පෘෂ්ඨ හොඳින් අවශෝෂණය කරයි."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit07_ThermalPhysics.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 24,
      gradeLevel = "11",
      titleSinhala = "අම්ල, භෂ්ම සහ ලවණ (pH අගය)",
      category = ScienceCategoryFilter.CHEMISTRY,
      pageRangeText = "පිටු 111-124",
      rootConcepts = listOf("අම්ලවල ගුණ (H⁺ අයන)", "භෂ්මවල ගුණ (OH⁻ අයන)", "pH පරිමාණය (0-14)", "දර්ශක (ලිට්මස්, ෆීනෝල්ප්තැලීන්, මෙතිල් ඔරේන්ජ්, විශ්ව දර්ශකය)", "උදාසීනීකරණය"),
      keyFormulasOrLaws = listOf(
        "pH < 7 : ආම්ලිකයි (රතු/තැඹිලි)",
        "pH = 7 : උදාසීනයි (කොළ පැහැය - පිරිසිදු ජලය)",
        "pH > 7 : භෂ්මිකයි (නිල්/දම්)",
        "අම්ලය + ලෝහය → ලවණය + H₂ වායුව (පොප් ශබ්දය සහිතව දැල්වේ)",
        "අම්ලය + කාබනේටය → ලවණය + ජලය + CO₂ වායුව (හුණු දියර කිරි පාට වේ)"
      ),
      highlights = listOf(
        "ප්‍රබල අම්ල: HCl, HNO₃, H₂SO₄ (ජලයේදී සම්පූර්ණයෙන්ම අයනීකරණය වේ)",
        "දුබල අම්ල: CH₃COOH (ඇසිටික්), H₂CO₃",
        "ප්‍රබල භෂ්ම: NaOH, KOH | දුබල භෂ්ම: NH₄OH, Mg(OH)₂",
        "ඇන්ටාසිඩ් පෙති: ආමාශයේ අම්ල අධිකතාවයට Mg(OH)₂ (මැග්නීසියා කිරි) භාවිත කරයි"
      ),
      examTips = listOf(
        "💡 ෆීනෝල්ප්තැලීන් ආම්ලික මාධ්‍යයේදී වර්ණ රහිත වන අතර භෂ්මික මාධ්‍යයේදී රෝස පැහැ වේ.",
        "💡 ලිට්මස්: අම්ල නිල් ලිට්මස් රතු කරයි, භෂ්ම රතු ලිට්මස් නිල් කරයි."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit08_AcidsBasesSalts.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 25,
      gradeLevel = "11",
      titleSinhala = "විද්‍යුත් චුම්භකත්වය සහ ප්‍රේරණය (මෝටර හා ජනක යන්ත්‍ර)",
      category = ScienceCategoryFilter.PHYSICS,
      pageRangeText = "පිටු 125-140",
      rootConcepts = listOf("චුම්භක ක්ෂේත්‍ර", "දකුණත් ඇඟිලි නීතිය", "ෆ්ලෙමින්ගේ වමත් නීතිය (මෝටර මූලධර්මය)", "විද්‍යුත් චුම්භක ප්‍රේරණය (ෆැරඩේ නියමය)", "ෆ්ලෙමින්ගේ දකුණත් නීතිය (ඩයිනමෝ/ජනක)", "පරිණාමක (Transformers)"),
      keyFormulasOrLaws = listOf(
        "ෆ්ලෙමින්ගේ වමත් නීතිය: මාපටැඟිල්ල = බලය (චලිතය F), දබරැඟිල්ල = චුම්භක ක්ෂේත්‍රය (B), මැදැඟිල්ල = ධාරාව (I)",
        "පරිණාමක සමීකරණය: Vp / Vs = Np / Ns",
        "අපතේ යාමක් නැති විට: Vp × Ip = Vs × Is (ප්‍රාථමික ක්ෂමතාව = ද්විතීයික ක්ෂමතාව)"
      ),
      highlights = listOf(
        "DC මෝටරය: විද්‍යුත් ශක්තිය යාන්ත්‍රික ශක්තිය බවට පත් කරයි (කොමියුටේටරය ධාරාවේ දිශාව මාරු කරයි)",
        "AC ජනකය: යාන්ත්‍රික ශක්තිය විද්‍යුත් ශක්තිය බවට පත් කරයි (ස්ලිප් මුදු භාවිත වේ)",
        "උච්චායක පරිණාමකය (Step-up): Ns > Np, වෝල්ටීයතාව වැඩිකරයි, ජාතික විදුලිබල පද්ධතියේ සම්ප්‍රේෂණයට යොදාගනී",
        "අවපාතක පරිණාමකය (Step-down): Ns < Np, වෝල්ටීයතාව අඩුකරයි"
      ),
      examTips = listOf(
        "💡 විභාගයේදී ෆ්ලෙමින්ගේ වමත් නීතිය (Motor) සහ දකුණත් නීතිය (Generator) පටලවා නොගන්න.",
        "💡 පරිණාමක ක්‍රියාත්මක වන්නේ ප්‍රත්‍යාවර්ත ධාරාවෙන් (AC) පමණි, සරල ධාරාවෙන් (DC) ක්‍රියා නොකරයි."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit09_Electromagnetism.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 26,
      gradeLevel = "11",
      titleSinhala = "හයිඩ්‍රොකාබන සහ කාබනික රසායනය (බහුඅවයවික)",
      category = ScienceCategoryFilter.CHEMISTRY,
      pageRangeText = "පිටු 141-156",
      rootConcepts = listOf("ඇල්කේන (C_n H_{2n+2})", "ඇල්කීන (C_n H_{2n})", "ඇල්කයින (C_n H_{2n-2})", "ක්‍රියාකාරී කාණ්ඩ (ඇල්කොහොල්, කාබොක්සිලික්)", "බහුඅවයවීකරණය (ස්වාභාවික හා කෘතිම)"),
      keyFormulasOrLaws = listOf(
        "මීතේන්: CH₄, එතේන්: C₂H₆, ප්‍රොපේන්: C₃H₈, බියුටේන්: C₄H₁₀",
        "එතීන්: C₂H₄ (ද්විත්ව බන්ධනයක් සහිතයි - අසන්තෘප්තයි)",
        "එතනෝල්: C₂H₅OH, එතනොයික් අම්ලය: CH₃COOH"
      ),
      highlights = listOf(
        "ස්වාභාවික බහුඅවයවික: ස්වාභාවික රබර් (අයිසොප්‍රීන්), සෙලියුලෝස් (ග්ලූකෝස්), ප්‍රෝටීන් (ඇමයිනෝ අම්ල), DNA (නියුක්ලියෝටයිඩ)",
        "කෘතිම බහුඅවයවික: පොලිතීන් (එතීන්), PVC (වයිනයිල් ක්ලෝරයිඩ්), නයිලෝන්",
        "එතීන් බහුඅවයවීකරණය වී පොලිතීන් සෑදීම: n(CH₂=CH₂) → (-CH₂-CH₂-)_n"
      ),
      examTips = listOf(
        "💡 අසන්තෘප්ත හයිඩ්‍රොකාබන (ඇල්කීන) හඳුනාගැනීමට බ්‍රෝමීන් ජලය (රතු දුඹුරු පැහැය අවර්ණ වේ) භාවිත කරයි.",
        "💡 තර්මෝප්ලාස්ටික් රත් කළ විට මෘදු වන අතර තර්මෝසෙටිං ප්ලාස්ටික් රත් කළ විට දැඩි වී අඟුරු වේ."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit10_HydrocarbonsPolymers.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 27,
      gradeLevel = "11",
      titleSinhala = "ඉලෙක්ට්‍රොනික විද්‍යාව (Electronic Components & Logic Gates)",
      category = ScienceCategoryFilter.PHYSICS,
      pageRangeText = "පිටු 157-172",
      rootConcepts = listOf("අර්ධ සන්නායක (Si, Ge)", "p-n සන්ධි ඩයෝඩය", "සෘජුකරණය (අර්ධ හා පූර්ණ තරංග)", "LED සහ LDR", "ට්‍රාන්සිස්ටරය (BJT - npn)", "තාර්කික ද්වාර (AND, OR, NOT, NAND, NOR)"),
      keyFormulasOrLaws = listOf(
        "ඩයෝඩය පෙර නැඹුරු කළ විට ධාරාව ගලායයි, පසු නැඹුරු කළ විට ධාරාව අවහිර කරයි",
        "ට්‍රාන්සිස්ටරයේ ධාරා සම්බන්ධතාවය: I_E = I_B + I_C (I_C = β I_B)",
        "තාර්කික ද්වාර සත්‍යතා වගු (Truth Tables)"
      ),
      highlights = listOf(
        "LDR (ආලෝක සංවේදී ප්‍රතිරෝධකය): ආලෝකය වැටෙන විට ප්‍රතිරෝධය අඩුවේ, අඳුරේදී ප්‍රතිරෝධය ඉහළය (ස්වයංක්‍රීය වීදි පහන් පරිපථවල භාවිතය)",
        "ට්‍රාන්සිස්ටරය ස්විචයක් ලෙස සහ වර්ධකයක් ලෙස ක්‍රියා කරයි",
        "NOT ද්වාරය: ආදානය 1 නම් ප්‍රතිදානය 0, ආදානය 0 නම් ප්‍රතිදානය 1 (ප්‍රතිලෝමකය)",
        "AND ද්වාරය: සියලු ආදාන 1 වූ විට පමණක් ප්‍රතිදානය 1 වේ",
        "OR ද්වාරය: ඕනෑම එක් ආදානයක් 1 වූ විට ප්‍රතිදානය 1 වේ"
      ),
      examTips = listOf(
        "💡 සත්‍යතා වගුව (Truth Table) නිවැරදිව පිරවීමට විභාගයේදී අනිවාර්යයෙන්ම ප්‍රශ්නයක් ලැබේ.",
        "💡 LED එකක් පරිපථයකට සවිකරන විට දැවී යාම වැළැක්වීමට ඊට ශ්‍රේණිගතව ආරක්ෂක ප්‍රතිරෝධකයක් සවිකළ යුතුය."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit11_ElectronicsLogicGates.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 28,
      gradeLevel = "11",
      titleSinhala = "විද්‍යුත් රසායනය (විද්‍යුත් විච්ඡේදනය සහ කෝෂ)",
      category = ScienceCategoryFilter.CHEMISTRY,
      pageRangeText = "පිටු 173-188",
      rootConcepts = listOf("විද්‍යුත් විච්ඡේද්‍ය", "විද්‍යුත් විච්ඡේදන කෝෂ", "සරල වෝල්ටීය කෝෂය", "ඩැනියෙල් කෝෂය", "ලෝහ විද්‍යුත් ආලේපනය", "ලෝහ විඛාදනය හා වැළැක්වීම"),
      keyFormulasOrLaws = listOf(
        "ඇනෝඩය (ධන අග්‍රය): ඔක්සිකරණය (ඉලෙක්ට්‍රෝන පිටකිරීම)",
        "කැතෝඩය (ඍණ අග්‍රය): ඔක්සිහරණය (ඉලෙක්ට්‍රෝන ලබාගැනීම)",
        "විද්‍යුත් ආලේපනයේදී: ආලේප කරන වස්තුව කැතෝඩයටත් (ඍණ), ආලේප කරන ලෝහය ඇනෝඩයටත් (ධන) සම්බන්ධ කළ යුතුය"
      ),
      highlights = listOf(
        "තඹ ආලේපනය: කැතෝඩය = යකඩ හැන්ද, ඇනෝඩය = පිරිසිදු Cu තහඩුව, විද්‍යුත් විච්ඡේද්‍යය = CuSO₄ ද්‍රාවණය",
        "යකඩ මලබැඳීම සඳහා ඔක්සිජන් (O₂) සහ ජලය (H₂O) අනිවාර්යයෙන්ම අවශ්‍ය වේ",
        "මලබැඳීම වැළැක්වීම: තීන්ත ආලේපය, ගැල්වනයිස් කිරීම (Zn ආලේපය), පරිත්‍යාගශීලී ආරක්ෂණය (Mg හෝ Zn කුට්ටි සවි කිරීම)"
      ),
      examTips = listOf(
        "💡 විද්‍යුත් ආලේපනයේදී DC ධාරාව (බැටරියක්) පමණක් භාවිත කළ යුතුය (AC භාවිත කළ නොහැක).",
        "💡 ගැල්වනයිස් කරන ලද යකඩ සීරීමට ලක්වුවද Zn යකඩට වඩා සක්‍රිය බැවින් Zn පළමුව විඛාදනය වී යකඩ ආරක්ෂා කරයි."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit12_Electrochemistry.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 29,
      gradeLevel = "11",
      titleSinhala = "විකිරණශීලීතාව සහ න්‍යෂ්ටික ශක්තිය",
      category = ScienceCategoryFilter.PHYSICS,
      pageRangeText = "පිටු 189-202",
      rootConcepts = listOf("විකිරණශීලී ක්ෂයවීම", "ඇල්ෆා (α), බීටා (β), ගැමා (γ) විකිරණ", "විකිරණශීලී සමස්ථානික සහ අර්ධ ආයුකාලය", "න්‍යෂ්ටික විඛණ්ඩනය සහ විලයනය"),
      keyFormulasOrLaws = listOf(
        "ඇල්ෆා (α) අංශුව = හීලියම් න්‍යෂ්ටිය (⁴₂He, ආරෝපණය +2)",
        "බීටා (β) අංශුව = අධිවේගී ඉලෙක්ට්‍රෝනය (⁰₋₁e, ආරෝපණය -1)",
        "ගැමා (γ) කිරණ = උදාසීන විද්‍යුත් චුම්භක තරංග (ස්කන්ධයක් හෝ ආරෝපණයක් නැත)",
        "අයින්ස්ටයින් සමීකරණය: E = m c² (c = 3 × 10⁸ m s⁻¹)"
      ),
      highlights = listOf(
        "විදාරණ බලය: ගැමා (γ) > බීටා (β) > ඇල්ෆා (α)",
        "අයනීකරණ බලය: ඇල්ෆා (α) > බීටා (β) > ගැමා (γ)",
        "විකිරණශීලී සමස්ථානිකවල යෙදීම්: කාබන්-14 (ෆොසිල කාලනිර්ණය), කොබෝල්ට්-60 (පිළිකා විකිරණ ප්‍රතිකාර), අයඩින්-131 (තයිරොයිඩ් ග්‍රන්ථි පරීක්ෂාව)",
        "න්‍යෂ්ටික බලාගාරවල ශක්තිය නිපදවන්නේ යුරේනියම්-235 පාලිත න්‍යෂ්ටික විඛණ්ඩනයෙනි"
      ),
      examTips = listOf(
        "💡 ඇල්ෆා කිරණ කඩදාසියකින් නතර කළ හැක, බීටා කිරණ ඇලුමිනියම් තහඩුවකින් නතර කළ හැක, ගැමා කිරණ නතර කිරීමට ඝන ඊයම් හෝ කොන්ක්‍රීට් බිත්තියක් අවශ්‍ය වේ.",
        "💡 සූර්යයා තුළ ශක්තිය නිපදවෙන්නේ හයිඩ්‍රජන් න්‍යෂ්ටි එක්වී හීලියම් සෑදෙන න්‍යෂ්ටික විලයනයෙනි."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit13_RadioactivityNuclear.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 30,
      gradeLevel = "11",
      titleSinhala = "මානව ස්නායු පද්ධතිය සහ ඉන්ද්‍රියන් (ඇස හා කන)",
      category = ScienceCategoryFilter.BIOLOGY,
      pageRangeText = "පිටු 203-220",
      rootConcepts = listOf("මධ්‍ය ස්නායු පද්ධතිය (මොළය හා සුෂුම්නාව)", "ස්නායු සෛලය (නියුරෝනය)", "ප්‍රත්‍යාවර්ත චාපය", "ඇසේ ව්‍යුහය සහ දෘෂ්ටි දෝෂ", "කනේ ව්‍යුහය සහ ශ්‍රවණය/සමතුලිතතාව"),
      keyFormulasOrLaws = listOf(
        "ප්‍රත්‍යාවර්ත චාපය: ප්‍රතිග්‍රාහකය → සංවේදක නියුරෝනය → අන්තර්හාරක නියුරෝනය (සුෂුම්නාව) → චාලක නියුරෝනය → කාර්යකය (පේශිය)"
      ),
      highlights = listOf(
        "මහා මොළය: සිතීම, මතකය, බුද්ධිය, ස්වේච්ඡා ක්‍රියා පාලනය",
        "අනු මොළය: දේහ සමතුලිතතාවය සහ මාංශ පේශි සම්බන්ධීකරණය",
        "සුෂුම්නා ශීර්ෂකය: ශ්වසනය, හෘද ස්පන්දනය වැනි අනිච්ඡානුග ක්‍රියා",
        "කිට්ටු දෘෂ්ටිකත්වය (Myopia): ප්‍රතිබිම්බය දෘෂ්ටිවිතානයට ඉදිරියෙන් සෑදේ → අවතල කාච මගින් නිවැරදි කරයි",
        "දුර දෘෂ්ටිකත්වය (Hypermetropia): ප්‍රතිබිම්බය දෘෂ්ටිවිතානයට පිටුපසින් සෑදේ → උත්තල කාච මගින් නිවැරදි කරයි"
      ),
      examTips = listOf(
        "💡 අර්ධ චක්‍රාකාර නාල ශ්‍රවණයට සම්බන්ධ නොවන අතර හිසේ සහ දේහයේ සමතුලිතතාවය පවත්වා ගැනීමට උපකාරී වේ.",
        "💡 ප්‍රත්‍යාවර්ත ක්‍රියාවක් යනු මොළයේ මැදිහත්වීමකින් තොරව අනතුරකින් බේරීමට සුෂුම්නාව මගින් ක්ෂණිකව සිදුවන ස්වයංක්‍රීය ප්‍රතිචාරයකි."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit14_NervousSystemSensory.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 31,
      gradeLevel = "11",
      titleSinhala = "මානව අන්තරාසර්ග පද්ධතිය (හෝමෝන)",
      category = ScienceCategoryFilter.BIOLOGY,
      pageRangeText = "පිටු 221-234",
      rootConcepts = listOf("පිටියුටරි ග්‍රන්ථිය (ප්‍රධාන ග්‍රන්ථිය)", "තයිරොයිඩ් ග්‍රන්ථිය (තයිරොක්සින්)", "අග්න්‍යාශය (ඉන්සියුලින්, ග්ලුකොගන්)", "අධිවෘක්ක ග්‍රන්ථිය (ඇඩ්‍රිනලින්)", "රුධිර ග්ලූකෝස් නියාමනය"),
      keyFormulasOrLaws = listOf(
        "රුධිර ග්ලූකෝස් මට්ටම වැඩිවූ විට → ඉන්සියුලින් මගින් ග්ලූකෝස් ග්ලයිකොජන් බවට පත් කරයි",
        "රුධිර ග්ලූකෝස් මට්ටම අඩුවූ විට → ග්ලුකොගන් මගින් ග්ලයිකොජන් ග්ලූකෝස් බවට පත් කරයි",
        "සාමාන්‍ය නිරාහාර රුධිර ග්ලූකෝස් මට්ටම = 70-110 mg / 100 ml"
      ),
      highlights = listOf(
        "හෝමෝන නාල රහිත ග්‍රන්ථි මගින් සෘජුවම රුධිරයට ශ්‍රාවය කර ඉලක්ක අවයව කරා ප්‍රවාහනය වේ",
        "ඇඩ්‍රිනලින්: හදිසි අවස්ථාවලදී සටන් කිරීමට හෝ පලායාමට ශරීරය සූදානම් කරයි (හෘද ස්පන්දනය, ශ්වසන වේගය වැඩිකරයි)",
        "දියවැඩියාව (Diabetes mellitus): ඉන්සියුලින් ඌනතාව නිසා රුධිරයේ ග්ලූකෝස් මට්ටම අධික වීම",
        "ගලගණ්ඩය (Goitre): අයඩින් ඌනතාවය නිසා තයිරොක්සින් නිපදවීමට නොහැකිව තයිරොයිඩ් ග්‍රන්ථිය ඉදිමීම"
      ),
      examTips = listOf(
        "💡 ඉන්සියුලින් සහ ග්ලුකොගන් එකිනෙකට ප්‍රතිවිරුද්ධව ක්‍රියා කරමින් සමස්ථිතිය (Homeostasis) පවත්වා ගනී.",
        "💡 හෝමෝන සහ ඒවා ශ්‍රාවය කරන ග්‍රන්ථි ගැලපීම විභාග ප්‍රශ්නවල සුලභය."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit15_EndocrineHormones.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 32,
      gradeLevel = "11",
      titleSinhala = "මානව බැහැර කිරීමේ පද්ධතිය (වකුගඩු සහ මුත්‍ර නිපදවීම)",
      category = ScienceCategoryFilter.BIOLOGY,
      pageRangeText = "පිටu 235-248",
      rootConcepts = listOf("බැහැර කිරීමේ අවයව", "වකුගඩුවේ ව්‍යුහය ( බාහිකය, මජ්ජාව, ශ්‍රෝණිය)", "වෘක්කානුවේ ව්‍යුහය (නෙෆ්‍රෝනය)", "අතිපෙරීම", "වරණීය ප්‍රතිඅවශෝෂණය", "ස්‍රාවය"),
      keyFormulasOrLaws = listOf(
        "වෘක්කානුව: බෝමන් ප්‍රවාරය + ග්ලෝමරුලසය + සමීපස්ථ සවිවලිත නාලිකාව + හෙන්ලේ පුඩුව + විදුරස්ථ සවිවලිත නාලිකාව + එකතු කරන නාලය"
      ),
      highlights = listOf(
        "ප්‍රධාන නයිට්‍රජනීය බැහැර ද්‍රව්‍යය යූරියා වේ (අක්මාවේදී ඇමෝනියා යූරියා බවට පත් කරයි)",
        "අතිපෙරීම: ග්ලෝමරුලසයේ අධි රුධිර පීඩනය නිසා රුධිර සෛල හා විශාල ප්‍රෝටීන හැර අනෙක් සියල්ල බෝමන් ප්‍රවාරයට පෙරේ",
        "වරණීය ප්‍රතිඅවශෝෂණය: ග්ලූකෝස්, ඇමයිනෝ අම්ල සම්පූර්ණයෙන්මද, ජලය හා ලවණ අවශ්‍ය ප්‍රමාණයටද නැවත රුධිරයට උරාගනී",
        "නිරෝගී පුද්ගලයෙකුගේ මුත්‍රාවල ග්ලූකෝස් අඩංගු නොවේ"
      ),
      examTips = listOf(
        "💡 මුත්‍රාවල ග්ලූකෝස් අඩංගු වීම දියවැඩියා රෝගයේ ප්‍රධාන ලක්ෂණයකි.",
        "💡 ADH හෝමෝනය (පිටියුටරියෙන් ශ්‍රාවය වන) මගින් වකුගඩුවේ ජලය ප්‍රතිඅවශෝෂණය පාලනය කරයි."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit16_ExcretorySystem.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 33,
      gradeLevel = "11",
      titleSinhala = "තාක්ෂණයේ යෙදෙන ක්ෂුද්‍ර ජීව විද්‍යාව",
      category = ScienceCategoryFilter.BIOLOGY,
      pageRangeText = "පිටු 249-262",
      rootConcepts = listOf("ක්ෂුද්‍ර ජීවී කාණ්ඩ (බැක්ටීරියා, වෛරස, දිලීර, ප්‍රෝටොසෝවා)", "ආහාර කර්මාන්තය (යෝගට්, කිරි, පාන්, චීස්)", "කෘෂිකාර්මික යෙදීම්", "වෛද්‍ය යෙදීම් (ප්‍රතිජීවක, එන්නත්)", "පරිසර කළමනාකරණය"),
      keyFormulasOrLaws = listOf(
        "පෙනිසිලින්: Penicillium notatum දිලීරයෙන් නිස්සාරණය කළ ප්‍රථම ප්‍රතිජීවකය (ඇලෙක්සැන්ඩර් ෆ්ලෙමින් විසින් සොයාගන්නා ලදී)"
      ),
      highlights = listOf(
        "ලැක්ටික් අම්ල බැක්ටීරියා (Lactobacillus bulgaricus): කිරි යෝගට් සහ මුදවපු කිරි බවට පත් කරයි",
        "යීස්ට් (Saccharomyces cerevisiae): පාන් පිපීමට සහ මත්පැන් නිෂ්පාදනයට",
        "ජෛව වායුව (Biogas): මෙතනෝජනික් බැක්ටීරියා මගින් ගොම හා කාබනික අපද්‍රව්‍ය නිර්වායු ලෙස ජීර්ණය කර CH₄ (මීතේන්) නිපදවීම",
        "නයිට්‍රජන් තිරකිරීම: රයිසෝබියම් බැක්ටීරියා (බෝංචි කුලයේ මුල් ගැටිති වල)"
      ),
      examTips = listOf(
        "💡 වෛරස සජීවී සත්කාරකයෙකු තුළ පමණක් ප්‍රජනනය වන අතර ප්‍රතිජීවක (Antibiotics) මගින් වෛරස විනාශ කළ නොහැක.",
        "💡 පාස්චරීකරණය: 72 °C ට තත්පර 15ක් රත් කර ක්ෂණිකව සිසිල් කිරීමෙන් කිරි වල රෝගකාරක ක්ෂුද්‍ර ජීවීන් විනාශ කිරීම."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit17_MicrobiologyTech.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 34,
      gradeLevel = "11",
      titleSinhala = "ස්වාභාවික සම්පත් කළමනාකරණය සහ තිරසාර සංවර්ධනය",
      category = ScienceCategoryFilter.EARTH_ENVIRONMENT,
      pageRangeText = "පිටු 263-276",
      rootConcepts = listOf("පුනර්ජනනීය සහ පුනර්ජනනීය නොවන සම්පත්", "හරිතාගාර ආචරණය සහ ගෝලීය උණුසුම", "ඕසෝන් වියන ක්ෂයවීම (CFC)", "අම්ල වැසි (SO₂, NO₂)", "3R සංකල්පය (Reduce, Reuse, Recycle)"),
      keyFormulasOrLaws = listOf(
        "අම්ල වැසි: SO₂ + H₂O → H₂SO₃ | 2SO₂ + O₂ + 2H₂O → 2H₂SO₄",
        "ඕසෝන් ක්ෂයවීම: CFC විකිරණ හමුවේ Cl මුක්ත ඛණ්ඩක නිදහස් කර O₃ (ඕසෝන්) විනාශ කරයි"
      ),
      highlights = listOf(
        "ප්‍රධාන හරිතාගාර වායු: CO₂, CH₄, N₂O, ජල වාෂ්ප, CFC",
        "හරිතාගාර ආචරණය පෘථිවියේ ජීවය පැවැත්මට අවශ්‍ය වුවද මානව ක්‍රියාකාරකම් නිසා වායු සාන්ද්‍රණය වැඩිවීමෙන් අධික ගෝලීය උණුසුමක් (Global Warming) හටගනී",
        "ඕසෝන් ස්ථරය ස්ට්‍රැටෝස්ෆියරයේ පිහිටා ඇති අතර අහිතකර පාරජම්බුල (UV-B) කිරණ පෘථිවියට ඒම වළක්වයි"
      ),
      examTips = listOf(
        "💡 මොන්ට්‍රියල් ප්‍රඥප්තිය: ඕසෝන් වියන ක්ෂය කරන CFC වායු අවම කිරීමේ ජාත්‍යන්තර ගිවිසුමයි.",
        "💡 කියෝතෝ ප්‍රඥප්තිය සහ පැරිස් ගිවිසුම: හරිතාගාර වායු විමෝචනය අඩු කිරීමේ සම්මුතීන් වේ."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit18_EnvironmentSustainability.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 35,
      gradeLevel = "11",
      titleSinhala = "පාරිසරික දූෂණය සහ අපද්‍රව්‍ය කළමනාකරණය",
      category = ScienceCategoryFilter.EARTH_ENVIRONMENT,
      pageRangeText = "පිටු 277-290",
      rootConcepts = listOf("ජල දූෂණය (සුපෝෂණය - Eutrophication)", "වායු දූෂණය (ධූමිකාව - Smog)", "පස දූෂණය", "ඝන අපද්‍රව්‍ය කළමනාකරණය", "කොම්පෝස්ට්කරණය සහ සනීපාරක්ෂක බිම් පිරවුම්"),
      keyFormulasOrLaws = listOf(
        "සුපෝෂණය: පොස්පේට් සහ නයිට්‍රේට් අධික වීම → ඇල්ගී පිපීම → හිරු එළිය අවහිර වීම → ශාක මියයාම → වියෝජනය නිසා O₂ අඩුවීම (BOD වැඩිවීම) → මත්ස්‍ය මරණ"
      ),
      highlights = listOf(
        "BOD (ජෛව රසායනික ඔක්සිජන් ඉල්ලුම): ජල සාම්පලයක අපද්‍රව්‍ය දිරවීමට ක්ෂුද්‍ර ජීවීන්ට අවශ්‍ය ඔක්සිජන් ප්‍රමාණයයි. BOD අගය ඉහළ නම් ජලය දැඩි ලෙස අපවිත්‍රය",
        "ජෛව අභිවර්ධනය (Biomagnification): බැර ලෝහ (රසදිය, ඊයම්, කැඩ්මියම්) හෝ කෘමිනාශක (DDT) ආහාර දාමයේ ඉහළට යනවිට සාන්ද්‍රණය වැඩිවීම",
        "මිනමාටා රෝගය රසදිය (Hg) විසවීමෙන්ද, ඉතායි-ඉතායි රෝගය කැඩ්මියම් (Cd) විසවීමෙන්ද හටගනී"
      ),
      examTips = listOf(
        "💡 විභාගයේදී 'සුපෝෂණය සිදුවන පියවර පෙළගස්වන්න' යන ප්‍රශ්නය ඉතා ජනප්‍රියයි.",
        "💡 සනීපාරක්ෂක බිම් පිරවුම් වලදී ලීචේට් (Leachate - අපද්‍රව්‍ය කාන්දු දියර) භූගත ජලයට මිශ්‍ර වීම වැළැක්වීමට මැටි හෝ පොලිතීන් පතුලක් යොදයි."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit19_PollutionManagement.pdf"
    ),

    ScienceUnitShortNote(
      unitNumber = 36,
      gradeLevel = "11",
      titleSinhala = "තාරකා විද්‍යාව සහ අභ්‍යවකාශ ගවේෂණය",
      category = ScienceCategoryFilter.PHYSICS,
      pageRangeText = "පිටු 291-304",
      rootConcepts = listOf("සෞරග්‍රහ මණ්ඩලය", "තාරකා පරිණාමය (ප්‍රාග් තාරකාව → රතු දැවැන්තයා → සුදු වාමනයා / සුපර්නෝවා → කළු කුහරය)", "චක්‍රවාට (ක්ෂීරපථය)", "ආලෝක වර්ෂය", "චන්ද්‍රිකා සහ දුරේක්ෂ (හබල්, ජේම්ස් වෙබ්)"),
      keyFormulasOrLaws = listOf(
        "ආලෝක වර්ෂය: ආලෝකය තත්පරයකට 3 × 10⁸ m වේගයෙන් වසරක් තුළ ගමන් කරන දුර (≈ 9.46 × 10¹² km)",
        "සූර්යයාට ළඟම තාරකාව: ප්‍රොක්සිමා සෙන්චූරි (ආලෝක වර්ෂ 4.2 ක් ඈතින්)"
      ),
      highlights = listOf(
        "භූ කේන්ද්‍ර වාදය (ටොලමි) පසුව සූර්ය කේන්ද්‍ර වාදය (කොපර්නිකස්) මගින් ප්‍රතිස්ථාපනය විය",
        "භූස්ථාවර චන්ද්‍රිකා: පෘථිවි භ්‍රමණ කාලයට (පැය 24) සමාන කාලයකින් සමකයට ඉහළින් කි.මී. 36,000 ක උසකින් භ්‍රමණය වන චන්ද්‍රිකා (සන්නිවේදන කටයුතුවලට)",
        "ධ්‍රැවීය කක්ෂීය චන්ද්‍රිකා: කාලගුණ හා සම්පත් සිතියම්කරණය සඳහා භාවිත වේ"
      ),
      examTips = listOf(
        "💡 සූර්යයා මධ්‍යම ප්‍රමාණයේ තාරකාවක් වන අතර එහි අවසානය සුදු වාමනයෙකු (White dwarf) ලෙස සිදුවේ.",
        "💡 ගුරුත්වාකර්ෂණය අතිශය ප්‍රබල වීම නිසා ආලෝකයට පවා ගැලවී යා නොහැකි ආකාශ වස්තු කළු කුහර (Black holes) ලෙස හැඳින්වේ."
      ),
      pdfUri = SCIENCE_GR11_FULL_PDF,
      fileName = "Grade11_Science_Unit20_AstronomySpace.pdf"
    )
  )

  fun getUnits(grade: ScienceGradeFilter, category: ScienceCategoryFilter, query: String): List<ScienceUnitShortNote> {
    return units.filter { item ->
      val matchesGrade = when (grade) {
        ScienceGradeFilter.ALL -> true
        ScienceGradeFilter.GRADE_10 -> item.gradeLevel == "10"
        ScienceGradeFilter.GRADE_11 -> item.gradeLevel == "11"
      }
      val matchesCategory = when (category) {
        ScienceCategoryFilter.ALL -> true
        else -> item.category == category
      }
      val matchesQuery = if (query.isBlank()) true else {
        item.unitNumber.toString() == query.trim() ||
            item.titleSinhala.contains(query, ignoreCase = true) ||
            item.rootConcepts.any { it.contains(query, ignoreCase = true) } ||
            item.keyFormulasOrLaws.any { it.contains(query, ignoreCase = true) } ||
            item.highlights.any { it.contains(query, ignoreCase = true) }
      }
      matchesGrade && matchesCategory && matchesQuery
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Grade10And11ScienceShortNotesHubScreen(
  onBack: () -> Unit,
  onOpenPdfModal: ((url: String, title: String) -> Unit)? = null,
  onOpenScience500AutoCheck: (() -> Unit)? = null
) {
  var selectedGrade by remember { mutableStateOf(ScienceGradeFilter.ALL) }
  var selectedCategory by remember { mutableStateOf(ScienceCategoryFilter.ALL) }
  var searchQuery by remember { mutableStateOf("") }
  var selectedUnitDetail by remember { mutableStateOf<ScienceUnitShortNote?>(null) }
  var showQuickFormulaReference by remember { mutableStateOf(false) }

  val filteredUnits = remember(selectedGrade, selectedCategory, searchQuery) {
    Grade10And11ScienceShortNotesRepository.getUnits(selectedGrade, selectedCategory, searchQuery)
  }

  val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

  Scaffold(
    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = "10 & 11 විද්‍යාව කෙටි සටහන්",
              fontWeight = FontWeight.Bold,
              fontSize = 15.sp,
              color = Color.White
            )
            Text(
              text = "ඒකක 36 පූර්ණ කෙටි සටහන් & PDF",
              fontSize = 10.sp,
              color = Color(0xFFA7F3D0)
            )
          }
        },
        navigationIcon = {
          IconButton(
            onClick = onBack,
            modifier = Modifier.testTag("science_short_notes_back_button")
          ) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = "Back",
              tint = Color.White
            )
          }
        },
        actions = {
          // Quick Formula action
          IconButton(
            onClick = { showQuickFormulaReference = true },
            modifier = Modifier.testTag("science_quick_formulas_button")
          ) {
            Icon(
              imageVector = Icons.Default.Science,
              contentDescription = "Quick Formulas & Laws",
              tint = Color(0xFFFDE047)
            )
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = Color(0xFF064E3B)
        ),
        scrollBehavior = scrollBehavior
      )
    },
    containerColor = Color(0xFFF8FAFC)
  ) { paddingValues ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
        .testTag("science_short_notes_main_list"),
      contentPadding = PaddingValues(bottom = 28.dp),
      verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      // 1. Sleek Compact Control Panel (Grade Toggle + Search)
      item {
        Surface(
          color = Color(0xFF064E3B),
          shadowElevation = 2.dp,
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 10.dp, vertical = 6.dp)
          ) {
            // Grade Filter Tabs - Compact Segmented Row
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF022C22), RoundedCornerShape(8.dp))
                .padding(2.dp),
              horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
              ScienceGradeFilter.values().forEach { gradeFilter ->
                val isSelected = selectedGrade == gradeFilter
                Surface(
                  onClick = { selectedGrade = gradeFilter },
                  shape = RoundedCornerShape(6.dp),
                  color = if (isSelected) Color(0xFF10B981) else Color.Transparent,
                  modifier = Modifier
                    .weight(1f)
                    .testTag("science_grade_filter_${gradeFilter.name}")
                ) {
                  Text(
                    text = gradeFilter.labelSinhala,
                    color = if (isSelected) Color.White else Color(0xFF94A3B8),
                    fontSize = 11.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 5.dp)
                  )
                }
              }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Sleek Compact Search Field
            OutlinedTextField(
              value = searchQuery,
              onValueChange = { searchQuery = it },
              placeholder = {
                Text(
                  text = "ඒකක අංකය (01-36), මාතෘකාව හෝ සූත්‍රය සොයන්න...",
                  fontSize = 11.5.sp,
                  color = Color(0xFF94A3B8)
                )
              },
              leadingIcon = {
                Icon(
                  imageVector = Icons.Default.Search,
                  contentDescription = "Search",
                  tint = Color(0xFF34D399),
                  modifier = Modifier.size(16.dp)
                )
              },
              trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                  IconButton(
                    onClick = { searchQuery = "" },
                    modifier = Modifier.size(24.dp)
                  ) {
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
                focusedContainerColor = Color(0xFF022C22),
                unfocusedContainerColor = Color(0xFF022C22),
                focusedBorderColor = Color(0xFF34D399),
                unfocusedBorderColor = Color(0xFF065F46),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
              ),
              modifier = Modifier
                .fillMaxWidth()
                .height(38.dp)
                .testTag("science_notes_search_field")
            )
          }
        }
      }

      // 2. Compact Official PDF Compendium Hero Banner
      item {
        Surface(
          onClick = {
            onOpenPdfModal?.invoke(
              Grade10And11ScienceShortNotesRepository.SCIENCE_GR11_FULL_PDF,
              "11 ශ්‍රේණිය - විද්‍යාව පූර්ණ කෙටි සටහන් PDF"
            )
          },
          shape = RoundedCornerShape(10.dp),
          color = Color(0xFF064E3B),
          border = BorderStroke(1.dp, Color(0xFF10B981)),
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 2.dp)
            .testTag("science_pdf_hero_banner")
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 10.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Box(
              modifier = Modifier
                .size(30.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Color(0xFF059669)),
              contentAlignment = Alignment.Center
            ) {
              Text("🔬", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                  text = "10 & 11 විද්‍යාව නිල කෙටි සටහන් PDF",
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
                    text = "PDF Drive",
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 0.5.dp)
                  )
                }
              }
              Text(
                text = "ඒකක 36 ආවරණය වන සම්පූර්ණ කෙටි සටහන් සංග්‍රහය",
                fontSize = 9.5.sp,
                color = Color(0xFFA7F3D0),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
              )
            }
            Spacer(modifier = Modifier.width(6.dp))
            Button(
              onClick = {
                onOpenPdfModal?.invoke(
                  Grade10And11ScienceShortNotesRepository.SCIENCE_GR11_FULL_PDF,
                  "11 ශ්‍රේණිය - විද්‍යාව පූර්ණ කෙටි සටහන් PDF"
                )
              },
              shape = RoundedCornerShape(6.dp),
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
              contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
              modifier = Modifier.height(28.dp)
            ) {
              Text("කියවන්න", fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
            }
          }
        }
      }

      // 3. Compact Science 500 Questions Auto-Checker Interactive Banner
      if (onOpenScience500AutoCheck != null) {
        item {
          Surface(
            onClick = { onOpenScience500AutoCheck() },
            color = Color(0xFF0F172A),
            border = BorderStroke(1.dp, Color(0xFF38BDF8)),
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 10.dp, vertical = 2.dp)
              .testTag("science_500_quiz_banner_button"),
            shape = RoundedCornerShape(10.dp)
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Box(
                modifier = Modifier
                  .size(28.dp)
                  .clip(CircleShape)
                  .background(Color(0xFF0284C7)),
                contentAlignment = Alignment.Center
              ) {
                Text("🧬", fontSize = 14.sp)
              }
              Spacer(modifier = Modifier.width(8.dp))
              Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text(
                    text = "විද්‍යාව ප්‍රශ්න 500 Auto-Checker",
                    color = Color.White,
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.Bold
                  )
                  Spacer(modifier = Modifier.width(4.dp))
                  Surface(
                    color = Color(0xFF10B981),
                    shape = RoundedCornerShape(3.dp)
                  ) {
                    Text(
                      text = "100% CHECK",
                      color = Color.White,
                      fontSize = 7.5.sp,
                      fontWeight = FontWeight.Bold,
                      modifier = Modifier.padding(horizontal = 4.dp, vertical = 0.5.dp)
                    )
                  }
                }
                Text(
                  text = "ප්‍රශ්න 500 සඳහා එවෙලෙම පිළිතුරු • ස්වයංක්‍රීයව ලකුණු",
                  color = Color(0xFFBAE6FD),
                  fontSize = 9.5.sp,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }
              Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "Go",
                tint = Color(0xFF38BDF8),
                modifier = Modifier.size(16.dp)
              )
            }
          }
        }
      }

      // 4. Compact Category Filter Chips (Horizontal Scroll)
      item {
        LazyRow(
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
          contentPadding = PaddingValues(horizontal = 10.dp),
          horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
          items(ScienceCategoryFilter.values()) { category ->
            val isSelected = selectedCategory == category
            Surface(
              onClick = { selectedCategory = category },
              shape = RoundedCornerShape(16.dp),
              color = if (isSelected) category.color else Color.White,
              border = BorderStroke(1.dp, if (isSelected) category.color else Color(0xFFCBD5E1)),
              shadowElevation = if (isSelected) 1.5.dp else 0.5.dp,
              modifier = Modifier.testTag("science_cat_chip_${category.name}")
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(category.iconEmoji, fontSize = 11.sp)
                Spacer(modifier = Modifier.width(4.dp))
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

      // 5. Stats Counter Header
      item {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 2.dp),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            text = "සොයාගත් ඒකක: ${filteredUnits.size} / 36",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF475569)
          )
          Text(
            text = "10 & 11 ශ්‍රේණි විද්‍යාව විෂය නිර්දේශය",
            fontSize = 10.5.sp,
            color = Color(0xFF059669),
            fontWeight = FontWeight.Medium
          )
        }
      }

      // 6. Units List / Empty State
      if (filteredUnits.isEmpty()) {
        item {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .padding(32.dp),
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
            ScienceUnitCard(
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
    ScienceUnitDetailDialog(
      unit = unit,
      onDismiss = { selectedUnitDetail = null },
      onOpenPdfModal = onOpenPdfModal
    )
  }

  // Quick Formula Dialog
  if (showQuickFormulaReference) {
    ScienceQuickFormulasDialog(
      onDismiss = { showQuickFormulaReference = false }
    )
  }
}

@Composable
fun ScienceUnitCard(
  unit: ScienceUnitShortNote,
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
      .testTag("science_unit_card_${unit.unitNumber}")
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
          Surface(
            shape = RoundedCornerShape(6.dp),
            color = Color(0xFF064E3B)
          ) {
            Text(
              text = "ඒකකය ${if (unit.unitNumber < 10) "0${unit.unitNumber}" else unit.unitNumber}",
              color = Color.White,
              fontWeight = FontWeight.Bold,
              fontSize = 11.sp,
              modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
            )
          }
          Spacer(modifier = Modifier.width(6.dp))
          Surface(
            shape = RoundedCornerShape(6.dp),
            color = if (unit.gradeLevel == "10") Color(0xFF1E40AF) else Color(0xFF065F46)
          ) {
            Text(
              text = "${unit.gradeLevel} ශ්‍රේණිය",
              color = Color.White,
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
        }

        Surface(
          shape = RoundedCornerShape(6.dp),
          color = unit.category.bgLightColor
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(unit.category.iconEmoji, fontSize = 10.sp)
            Spacer(modifier = Modifier.width(3.dp))
            Text(
              text = unit.category.displayName.substringBefore(" ("),
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              color = unit.category.color
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      // Title
      Text(
        text = unit.titleSinhala,
        fontWeight = FontWeight.Bold,
        fontSize = 14.5.sp,
        color = Color(0xFF0F172A),
        lineHeight = 20.sp
      )

      Spacer(modifier = Modifier.height(6.dp))

      // Root Concepts chips
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
      ) {
        unit.rootConcepts.take(3).forEach { concept ->
          Surface(
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFFF1F5F9)
          ) {
            Text(
              text = concept,
              fontSize = 10.sp,
              color = Color(0xFF475569),
              maxLines = 1,
              overflow = TextOverflow.Ellipsis,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
        }
        if (unit.rootConcepts.size > 3) {
          Text(
            text = "+${unit.rootConcepts.size - 3}",
            fontSize = 10.sp,
            color = Color(0xFF94A3B8),
            modifier = Modifier.align(Alignment.CenterVertically)
          )
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      // Bottom Row: Formulas Count & Action Button
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Icon(
            imageVector = Icons.Default.Science,
            contentDescription = null,
            tint = Color(0xFF059669),
            modifier = Modifier.size(14.dp)
          )
          Spacer(modifier = Modifier.width(4.dp))
          Text(
            text = "${unit.keyFormulasOrLaws.size} සූත්‍ර/නීති • ${unit.pageRangeText}",
            fontSize = 11.sp,
            color = Color(0xFF64748B)
          )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
          Text(
            text = "සටහන් බලන්න",
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF059669)
          )
          Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = "Open",
            tint = Color(0xFF059669),
            modifier = Modifier.size(16.dp)
          )
        }
      }
    }
  }
}

@Composable
fun ScienceUnitDetailDialog(
  unit: ScienceUnitShortNote,
  onDismiss: () -> Unit,
  onOpenPdfModal: ((url: String, title: String) -> Unit)? = null
) {
  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false)
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth(0.95f)
        .fillMaxHeight(0.88f)
        .clip(RoundedCornerShape(20.dp))
        .background(Color.White)
    ) {
      Column(
        modifier = Modifier.fillMaxSize()
      ) {
        // Modal Header
        Surface(
          color = Color(0xFF064E3B),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(
            modifier = Modifier.padding(16.dp)
          ) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = Color(0xFF10B981)
                ) {
                  Text(
                    text = "ඒකකය ${unit.unitNumber}",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                  )
                }
                Spacer(modifier = Modifier.width(6.dp))
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = Color.White.copy(alpha = 0.2f)
                ) {
                  Text(
                    text = "${unit.gradeLevel} ශ්‍රේණිය",
                    color = Color.White,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                  )
                }
              }

              IconButton(
                onClick = onDismiss,
                modifier = Modifier.size(28.dp)
              ) {
                Icon(
                  imageVector = Icons.Default.Close,
                  contentDescription = "Close",
                  tint = Color.White
                )
              }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
              text = unit.titleSinhala,
              fontWeight = FontWeight.Bold,
              fontSize = 16.sp,
              color = Color.White
            )

            Text(
              text = "${unit.category.displayName} • ${unit.pageRangeText}",
              fontSize = 11.5.sp,
              color = Color(0xFFA7F3D0)
            )
          }
        }

        // Modal Content Body
        LazyColumn(
          modifier = Modifier
            .weight(1f)
            .padding(horizontal = 16.dp, vertical = 12.dp),
          verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
          // 1. Root Concepts Section
          item {
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFFF0FDF4)),
              border = BorderStroke(1.dp, Color(0xFFBBF7D0))
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text("🧬", fontSize = 14.sp)
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = "මූලික සංකල්ප (Core Concepts):",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.5.sp,
                    color = Color(0xFF166534)
                  )
                }
                Spacer(modifier = Modifier.height(8.dp))
                unit.rootConcepts.forEach { concept ->
                  Row(
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(vertical = 2.dp),
                    verticalAlignment = Alignment.Top
                  ) {
                    Text("•", color = Color(0xFF166534), fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                      text = concept,
                      fontSize = 12.sp,
                      color = Color(0xFF1E293B)
                    )
                  }
                }
              }
            }
          }

          // 2. Key Formulas or Laws Section
          if (unit.keyFormulasOrLaws.isNotEmpty()) {
            item {
              Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFEFF6FF)),
                border = BorderStroke(1.dp, Color(0xFFBFDBFE))
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("⚡", fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                      text = "ප්‍රධාන සූත්‍ර සහ විද්‍යාත්මක නීති (Formulas & Laws):",
                      fontWeight = FontWeight.Bold,
                      fontSize = 12.5.sp,
                      color = Color(0xFF1E40AF)
                    )
                  }
                  Spacer(modifier = Modifier.height(8.dp))
                  unit.keyFormulasOrLaws.forEach { formula ->
                    Surface(
                      shape = RoundedCornerShape(8.dp),
                      color = Color.White,
                      border = BorderStroke(1.dp, Color(0xFFDBEAFE)),
                      modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp)
                    ) {
                      Text(
                        text = formula,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        color = Color(0xFF1E3A8A),
                        modifier = Modifier.padding(8.dp)
                      )
                    }
                  }
                }
              }
            }
          }

          // 3. Highlights & Short Notes
          item {
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFBEB)),
              border = BorderStroke(1.dp, Color(0xFFFDE68A))
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text("📝", fontSize = 14.sp)
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = "කෙටි සටහන් සාරාංශය (Key Highlights):",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.5.sp,
                    color = Color(0xFF92400E)
                  )
                }
                Spacer(modifier = Modifier.height(8.dp))
                unit.highlights.forEach { highlight ->
                  Row(
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(vertical = 3.dp),
                    verticalAlignment = Alignment.Top
                  ) {
                    Text("✔️", fontSize = 11.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                      text = highlight,
                      fontSize = 12.sp,
                      color = Color(0xFF334155),
                      lineHeight = 17.sp
                    )
                  }
                }
              }
            }
          }

          // 4. Exam Tips
          if (unit.examTips.isNotEmpty()) {
            item {
              Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFAF5FF)),
                border = BorderStroke(1.dp, Color(0xFFE9D5FF))
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("💡", fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                      text = "විභාග ඉඟි සහ උපදෙස් (Exam Tips):",
                      fontWeight = FontWeight.Bold,
                      fontSize = 12.5.sp,
                      color = Color(0xFF6B21A8)
                    )
                  }
                  Spacer(modifier = Modifier.height(8.dp))
                  unit.examTips.forEach { tip ->
                    Text(
                      text = tip,
                      fontSize = 11.5.sp,
                      color = Color(0xFF581C87),
                      lineHeight = 16.sp,
                      modifier = Modifier.padding(vertical = 2.dp)
                    )
                  }
                }
              }
            }
          }
        }

        // Modal Action Buttons
        Surface(
          color = Color(0xFFF1F5F9),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            Button(
              onClick = {
                onDismiss()
                onOpenPdfModal?.invoke(unit.pdfUri, "${unit.gradeLevel} ශ්‍රේණිය - ${unit.titleSinhala} (PDF)")
              },
              shape = RoundedCornerShape(10.dp),
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669)),
              modifier = Modifier.weight(1f)
            ) {
              Icon(Icons.Default.PictureAsPdf, contentDescription = null, modifier = Modifier.size(16.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text("PDF ලේඛනය බලන්න", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }

            OutlinedButton(
              onClick = onDismiss,
              shape = RoundedCornerShape(10.dp),
              colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF475569))
            ) {
              Text("වසන්න", fontSize = 12.sp)
            }
          }
        }
      }
    }
  }
}

@Composable
fun ScienceQuickFormulasDialog(
  onDismiss: () -> Unit
) {
  val formulas = listOf(
    "ප්‍රවේගය v = s / t" to "s = දුර, t = කාලය (ඒකකය: m s⁻¹)",
    "ත්වරණය a = (v - u) / t" to "v = අවසන් ප්‍රවේගය, u = මුල් ප්‍රවේගය (ඒකකය: m s⁻²)",
    "චලිත සමීකරණ" to "v = u + at | s = ut + ½ at² | v² = u² + 2as",
    "නිව්ටන්ගේ දෙවන නියමය F = ma" to "F = බලය (N), m = ස්කන්ධය (kg), a = ත්වරණය (m s⁻²)",
    "බලයක ඝූර්ණය M = F × d" to "F = බලය, d = භ්‍රමණ අක්ෂයේ සිට බලයට ලම්බ දුර (N m)",
    "කාර්යය W = F × s" to "F = බලය, s = විස්ථාපනය (ඒකකය: J)",
    "ගුරුත්වජ විභව ශක්තිය Ep = m g h" to "m = ස්කන්ධය, g = 10 m s⁻², h = උස (J)",
    "චාලක ශක්තිය Ek = ½ m v²" to "m = ස්කන්ධය (kg), v = ප්‍රවේගය (m s⁻¹) [J]",
    "ක්ෂමතාව P = W / t" to "W = කාර්යය (J), t = කාලය (s) [ඒකකය: W (වොට්)]",
    "ඝනත්වය ρ = m / V" to "m = ස්කන්ධය (kg), V = පරිමාව (m³) [kg m⁻³]",
    "පීඩනය P = F / A = h ρ g" to "F = බලය, A = වර්ගඵලය [Pa / N m⁻²]",
    "ඕම් නියමය V = I × R" to "V = වෝල්ටීයතාව, I = ධාරාව, R = ප්‍රතිරෝධය",
    "තරංග සමීකරණය v = f × λ" to "v = ප්‍රවේගය, f = සංඛ්‍යාතය (Hz), λ = තරංග ආයාමය (m)",
    "තාප සමීකරණය Q = m c θ" to "c = විශිෂ්ට තාප ධාරිතාව (ජලයේ c = 4200 J kg⁻¹ °C⁻¹)",
    "ගුප්ත තාපය Q = m L" to "L = විශිෂ්ට ගුප්ත තාපය (J kg⁻¹)",
    "මවුල ගණන n = m / M" to "m = ස්කන්ධය (g), M = මවුලික ස්කන්ධය (g mol⁻¹)",
    "සාන්ද්‍රණය c = n / V" to "n = මවුල ගණන (mol), V = පරිමාව (dm³)"
  )

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false)
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth(0.95f)
        .fillMaxHeight(0.85f)
        .clip(RoundedCornerShape(20.dp))
        .background(Color.White)
    ) {
      Column(modifier = Modifier.fillMaxSize()) {
        Surface(
          color = Color(0xFF064E3B),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Column {
              Text(
                text = "⚡ විද්‍යාව සියලුම සූත්‍ර සහ නීති",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.White
              )
              Text(
                text = "10 & 11 ශ්‍රේණි භෞතික හා රසායන විද්‍යා සූත්‍ර සංග්‍රහය",
                fontSize = 11.sp,
                color = Color(0xFFA7F3D0)
              )
            }
            IconButton(onClick = onDismiss) {
              Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White)
            }
          }
        }

        LazyColumn(
          modifier = Modifier
            .weight(1f)
            .padding(14.dp),
          verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          items(formulas) { (formula, description) ->
            Surface(
              shape = RoundedCornerShape(10.dp),
              color = Color(0xFFF8FAFC),
              border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Text(
                  text = formula,
                  fontWeight = FontWeight.Bold,
                  fontSize = 13.5.sp,
                  color = Color(0xFF0F172A)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = description,
                  fontSize = 11.5.sp,
                  color = Color(0xFF059669)
                )
              }
            }
          }
        }

        Surface(
          color = Color(0xFFF1F5F9),
          modifier = Modifier.fillMaxWidth()
        ) {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .padding(12.dp),
            contentAlignment = Alignment.Center
          ) {
            Button(
              onClick = onDismiss,
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF064E3B)),
              shape = RoundedCornerShape(10.dp),
              modifier = Modifier.fillMaxWidth(0.5f)
            ) {
              Text("තේරුම් ගත්තා", fontSize = 12.sp)
            }
          }
        }
      }
    }
  }
}
