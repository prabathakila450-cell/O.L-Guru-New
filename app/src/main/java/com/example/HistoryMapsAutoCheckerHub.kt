package com.example

import android.content.Context
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

// ==============================================================================
// 9, 10, 11 ශ්‍රේණි ඉතිහාසය සිතියම් - INTERACTIVE AUTO-CHECKER DATA MODELS
// ==============================================================================

data class HistoryMapPinLocation(
  val id: String,
  val pinNumber: Int, // Number displayed on map (e.g. 1, 2, 3...)
  val correctSinhalaName: String,
  val correctEnglishName: String,
  val alternativeAliases: List<String>, // Alternative acceptable names (e.g. මාන්තොට / මහාතිත්ථ / Mantai)
  val category: String, // Ancient Capital, Port, River, Reservoir, Foreign Civilization, etc.
  val gradeLevel: String, // "09", "10", "11", "09-11"
  val normalizedX: Float, // 0.0f to 1.0f on map canvas
  val normalizedY: Float, // 0.0f to 1.0f on map canvas
  val explanationSinhala: String, // Exact marking instructions and historical significance
  val markingCluesSinhala: String, // How to pinpoint accurately on Sri Lanka / World map
  val sampleExamQuestions: List<String> = emptyList()
)

data class HistoryMapExercise(
  val id: String,
  val titleSinhala: String,
  val subtitleSinhala: String,
  val mapType: HistoryMapType, // SRI_LANKA_ANCIENT, SRI_LANKA_RIVERS_TANKS, SRI_LANKA_MEDIEVAL, SRI_LANKA_PORTS, INDIA_ASIA, WORLD_CIVILIZATIONS
  val targetGrades: String, // "09, 10, 11"
  val descriptionSinhala: String,
  val pins: List<HistoryMapPinLocation>,
  val pdfPageReference: String = "පිටුව 1-4"
)

enum class HistoryMapType(val displayName: String, val iconEmoji: String) {
  SRI_LANKA_ANCIENT("අනුරාධපුර හා මුල් ඓතිහාසික යුගය", "🏛️"),
  SRI_LANKA_RIVERS_TANKS("ගංගා, ජලාශ සහ වාරිමාර්ග", "🌊"),
  SRI_LANKA_MEDIEVAL("පොළොන්නරු හා පසුකාලීන රාජධානි", "👑"),
  SRI_LANKA_PORTS("ඓතිහාසික වරායවල් සහ වෙළඳ මධ්‍යස්ථාන", "⚓"),
  INDIA_ASIA("ඉන්දියාව සහ ආසියානු ශිෂ්ටාචාර", "🐘"),
  WORLD_CIVILIZATIONS("ලෝක ඉතිහාසය සහ වෙළඳ මාර්ග", "🌍")
}

// ==============================================================================
// 100% SYLLABUS-ACCURATE HISTORY MAP EXERCISES DATASET (GRADES 9, 10, 11)
// ==============================================================================

object HistoryMapsRepository {

  val pdfDriveUrl = "https://drive.google.com/file/d/1Zb0BakP20v9DzRQokDt8gjXd-Pl8Repg/preview"

  val allExercises: List<HistoryMapExercise> = listOf(
    // -------------------------------------------------------------
    // EXERCISE 1: SRI LANKA ANCIENT ERA (අනුරාධපුර යුගය)
    // -------------------------------------------------------------
    HistoryMapExercise(
      id = "sl_ancient_kings",
      titleSinhala = "අනුරාධපුර හා මුල් ඓතිහාසික යුගය (ශ්‍රී ලංකා සිතියම)",
      subtitleSinhala = "අනුරාධපුරය, මාන්තොට, ගෝකණ්ණ, ජම්බුකෝලපට්ටන, ඌරුවෙල, දීඝවාපිය, මාගම",
      mapType = HistoryMapType.SRI_LANKA_ANCIENT,
      targetGrades = "09, 10, 11",
      descriptionSinhala = "09, 10 සහ 11 ශ්‍රේණි ඉතිහාසය විෂය නිර්දේශයේ අඩංගු අනුරාධපුර යුගයේ ප්‍රධාන නගර, වරායවල් සහ මුල් ජනාවාස සිතියමේ නිවැරදිව හඳුනාගෙන ලකුණු කරන්න.",
      pins = listOf(
        HistoryMapPinLocation(
          id = "pin_anuradhapura",
          pinNumber = 1,
          correctSinhalaName = "අනුරාධපුරය",
          correctEnglishName = "Anuradhapura",
          alternativeAliases = listOf("අනුරාධපුර", "Anuradhapura", "Anuradhapuram", "අනුරාධපුර නගරය"),
          category = "ප්‍රධාන අගනුවර",
          gradeLevel = "09-11",
          normalizedX = 0.44f,
          normalizedY = 0.32f,
          explanationSinhala = "ක්‍රි.පූ. 4 වන සියවසේ පණ්ඩුකාභය රජු විසින් අගනුවර බවට පත්කළ, ශ්‍රී ලංකාවේ ප්‍රථම සහ දීර්ඝතම ඓතිහාසික අගනගරයයි. මල්වතු ඔය නිම්නයේ පිහිටා ඇත.",
          markingCluesSinhala = "මල්වතු ඔය ගමන් මග මැද ප්‍රදේශය සහ උතුරු මැද තැන්නේ මධ්‍යය ආසන්නයේ තිත තබන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_manthota",
          pinNumber = 2,
          correctSinhalaName = "මහාතිත්ථ (මාන්තොට)",
          correctEnglishName = "Mahatittha (Mantota)",
          alternativeAliases = listOf("මාන්තොට", "මහාතිත්ථ", "Mantai", "Mahatittha", "Manthota", "Mantota", "මාතොට", "මහාතිත්ත"),
          category = "ප්‍රධාන ජාත්‍යන්තර වරාය",
          gradeLevel = "09-11",
          normalizedX = 0.28f,
          normalizedY = 0.23f,
          explanationSinhala = "අනුරාධපුර යුගයේ පැවති ප්‍රධානතම ජාත්‍යන්තර වෙළඳ වරායයි. පෙරදිග සහ අපරදිග වෙළඳ නෞකා පැමිණි මධ්‍යස්ථානයක් විය. මල්වතු ඔය මෝය අසල වයඹ වෙරළේ පිහිටා ඇත.",
          markingCluesSinhala = "මන්නාරම් බොක්ක ආසන්නයේ, මල්වතු ඔය මුහුදට වැටෙන වයඹ දිග වෙරළ තීරයේ හරියටම වෙරළ ඉම ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_gokanna",
          pinNumber = 3,
          correctSinhalaName = "ගෝකණ්ණ (ත්‍රිකුණාමලය)",
          correctEnglishName = "Gokanna (Trincomalee)",
          alternativeAliases = listOf("ගෝකණ්ණ", "ත්‍රිකුණාමලය", "Gokanna", "Trincomalee", "ගෝකණ්ණ වරාය", "ගෝකර්ණ"),
          category = "නැගෙනහිර ප්‍රධාන වරාය",
          gradeLevel = "09-11",
          normalizedX = 0.72f,
          normalizedY = 0.31f,
          explanationSinhala = "නැගෙනහිර වෙරළේ පිහිටි ප්‍රධානතම ස්වභාවික වරායයි. භද්දකච්චායනා කුමරිය පැමිණි වරාය ලෙස මහාවංශයේ සඳහන් වේ. මහවැලි ගඟ මෝය ආශ්‍රිතව පිහිටා ඇත.",
          markingCluesSinhala = "නැගෙනහිර වෙරළේ ප්‍රධාන ස්වභාවික බොක්ක සහිත ත්‍රිකුණාමල අර්ධද්වීපය අභ්‍යන්තරයේ ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_jambukolapattana",
          pinNumber = 4,
          correctSinhalaName = "ජම්බුකෝලපට්ටන (දඹකොළපටුන)",
          correctEnglishName = "Jambukolapattana",
          alternativeAliases = listOf("දඹකොළපටුන", "ජම්බුකෝලපට්ටන", "Jambukolapattana", "Dambakolapatuna", "ජම්බුකෝල පටුන"),
          category = "උතුරු ප්‍රධාන වරාය",
          gradeLevel = "09-11",
          normalizedX = 0.38f,
          normalizedY = 0.08f,
          explanationSinhala = "සංඝමිත්තා තෙරණිය ශ්‍රී මහා බෝධි අංකුරය රැගෙන ලක්දිවට වැඩම කළ උතුරු දිග ඓතිහාසික වරායයි (යාපන අර්ධද්වීපයේ උතුරු වෙරළ).",
          markingCluesSinhala = "යාපනය අර්ධද්වීපයේ ඉහළම උතුරු වෙරළ තීරයේ දඹකොළපටුන තිත තබන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_uruwela",
          pinNumber = 5,
          correctSinhalaName = "ඌරුවෙල",
          correctEnglishName = "Uruwela",
          alternativeAliases = listOf("ඌරුවෙල", "Uruwela", "ඌරුවෙල වරාය"),
          category = "පුරාණ මුතු වරාය",
          gradeLevel = "09-11",
          normalizedX = 0.27f,
          normalizedY = 0.40f,
          explanationSinhala = "කලා ඔය මුහුදට වැටෙන මෝය ආසන්නයේ පිහිටි පැරණි මුතු කිමිදුම් හා වෙළඳ මධ්‍යස්ථානයකි. විජය රජුගේ ඇමතියෙකු විසින් පිහිටුවන ලදී.",
          markingCluesSinhala = "කලා ඔය මුහුදට වැටෙන වයඹ දිග වෙරළ තීරයේ, පුත්තලම් කලපුවට උතුරින් ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_dighavapi",
          pinNumber = 6,
          correctSinhalaName = "දීඝවාපිය",
          correctEnglishName = "Dighavapi",
          alternativeAliases = listOf("දීඝවාපිය", "Dighavapi", "දීඝවාපි"),
          category = "නැගෙනහිර කෘෂිකාර්මික නගරය",
          gradeLevel = "09-11",
          normalizedX = 0.76f,
          normalizedY = 0.62f,
          explanationSinhala = "සද්ධාතිස්ස කුමරු විසින් ගොවිතැන් කටයුතු දියුණු කළ නැගෙනහිර පළාතේ ගල්ඔය නිම්නයේ පිහිටි ඓතිහාසික නගරයකි.",
          markingCluesSinhala = "නැගෙනහිර පළාතේ අම්පාර දිස්ත්‍රික්කයේ ගල්ඔය නිම්නය ආශ්‍රිතව ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_magama",
          pinNumber = 7,
          correctSinhalaName = "මාගම (තිස්සමහාරාමය)",
          correctEnglishName = "Magama (Tissamaharama)",
          alternativeAliases = listOf("මාගම", "තිස්සමහාරාමය", "Magama", "Tissamaharama", "රුහුණ මාගම", "මහාගාම"),
          category = "රුහුණේ අගනුවර",
          gradeLevel = "09-11",
          normalizedX = 0.64f,
          normalizedY = 0.84f,
          explanationSinhala = "මහානාග කුමරු විසින් ආරම්භ කළ රුහුණු රාජධානියේ ප්‍රධාන අගනුවරයි. දුටුගැමුණු රජු උපත ලැබූ සහ හැදීවැඩුණු ඓතිහාසික භූමියයි. කිරිඳි ඔය නිම්නයේ පිහිටා ඇත.",
          markingCluesSinhala = "දකුණු ලක කිරිඳි ඔය මෝය අසල ගිනිකොණ දිග පහත් බිමේ තිස්සමහාරාම ප්‍රදේශය ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_vijithapura",
          pinNumber = 8,
          correctSinhalaName = "විජිතපුර",
          correctEnglishName = "Vijithapura",
          alternativeAliases = listOf("විජිතපුර", "Vijithapura", "විජිතපුර බලකොටුව"),
          category = "ඓතිහාසික බලකොටුව",
          gradeLevel = "10-11",
          normalizedX = 0.48f,
          normalizedY = 0.42f,
          explanationSinhala = "දුටුගැමුණු - එළාර සටනේදී දින ගණනාවක් මුළුල්ලේ දැඩි සටනකින් පසු ජයගත් එළාර රජුගේ ප්‍රධානතම බලකොටුවයි. කලා වැව ආසන්නයේ පිහිටා ඇත.",
          markingCluesSinhala = "කලා වැවට ආසන්නව, අනුරාධපුරයට දකුණින් තිත තබන්න."
        )
      )
    ),

    // -------------------------------------------------------------
    // EXERCISE 2: SRI LANKA RIVERS, RESERVOIRS & IRRIGATION
    // -------------------------------------------------------------
    HistoryMapExercise(
      id = "sl_rivers_reservoirs",
      titleSinhala = "ගංගා, ජලාශ සහ වාරිමාර්ග පද්ධතිය (ශ්‍රී ලංකා සිතියම)",
      subtitleSinhala = "මහවැලි, මල්වතු, දැදුරු, කැලණි, වලවේ, පරාක්‍රම සමුද්‍රය, කලා වැව, මින්නේරිය",
      mapType = HistoryMapType.SRI_LANKA_RIVERS_TANKS,
      targetGrades = "09, 10, 11",
      descriptionSinhala = "ශ්‍රී ලංකාවේ ශිෂ්ටාචාරය ගොඩනැගීමට දායක වූ ප්‍රධාන ගංගා මෝයවල්, ගලා බසින මාර්ග සහ මහා වැව් සිතියමේ නිවැරදිව හඳුනාගන්න.",
      pins = listOf(
        HistoryMapPinLocation(
          id = "pin_mahaweli",
          pinNumber = 1,
          correctSinhalaName = "මහවැලි ගඟ",
          correctEnglishName = "Mahaweli River",
          alternativeAliases = listOf("මහවැලි ගඟ", "Mahaweli", "මහවැලි", "Mahaweli River", "මහාවාලුකා නදිය"),
          category = "ශ්‍රී ලංකාවේ දිගම ගංගාව",
          gradeLevel = "09-11",
          normalizedX = 0.65f,
          normalizedY = 0.38f,
          explanationSinhala = "ශ්‍රී ලංකාවේ දිගම ගංගාවයි (කි.මී. 335). ශ්‍රී පාද කඳුවැටියෙන් ඇරඹී ත්‍රිකුණාමලයේ කොඩ්ඩියාර් බොක්කෙන් මුහුදට ගලා බසී.",
          markingCluesSinhala = "මධ්‍යම කඳුකරයේ සිට උතුරු නැගෙනහිර දෙසට වක්‍රව ගලාගොස් ත්‍රිකුණාමලයෙන් මුහුදට වැටෙන ප්‍රධාන නිල් රේඛාව බලන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_malwathu_oya",
          pinNumber = 2,
          correctSinhalaName = "මල්වතු ඔය (අරුචි ආරු)",
          correctEnglishName = "Malwathu Oya",
          alternativeAliases = listOf("මල්වතු ඔය", "Malwathu Oya", "මල්වතු", "Aruvi Aru", "කදම්බ නදිය"),
          category = "ඓතිහාසික ගංගාව",
          gradeLevel = "09-11",
          normalizedX = 0.36f,
          normalizedY = 0.28f,
          explanationSinhala = "අනුරාධපුර ශිෂ්ටාචාරයේ ජීවනාලියයි. අනුරාධපුර නගරය හරහා ගලාගොස් මාන්තොටින් මුහුදට වැටේ. පුරාණයේ 'කදම්බ නදිය' ලෙස හැඳින්විණි.",
          markingCluesSinhala = "අනුරාධපුරය හරහා වයඹ දිශාවට ගලාගොස් මන්නාරමට දකුණින් මුහුදට වැටෙන ඔයයි."
        ),
        HistoryMapPinLocation(
          id = "pin_deduru_oya",
          pinNumber = 3,
          correctSinhalaName = "දැදුරු ඔය",
          correctEnglishName = "Deduru Oya",
          alternativeAliases = listOf("දැදුරු ඔය", "Deduru Oya", "දැදුරු", "ජජ්ජර නදිය"),
          category = "වයඹ ප්‍රධාන ගංගාව",
          gradeLevel = "09-11",
          normalizedX = 0.30f,
          normalizedY = 0.50f,
          explanationSinhala = "දඹදෙණිය, යාපහුව, කුරුණෑගල යුගයන්හි කෘෂිකර්මාන්තයට දායක වූ ප්‍රධාන ගංගාවයි. හලාවතට උතුරින් මුහුදට වැටේ.",
          markingCluesSinhala = "කුරුණෑගල හරහා බස්නාහිර වෙරළේ හලාවතට උතුරින් මුහුදට වැටෙන ඔයයි."
        ),
        HistoryMapPinLocation(
          id = "pin_kelani_river",
          pinNumber = 4,
          correctSinhalaName = "කැලණි ගඟ",
          correctEnglishName = "Kelani River",
          alternativeAliases = listOf("කැලණි ගඟ", "Kelani", "Kelani River", "කැලණි"),
          category = "බස්නාහිර ප්‍රධාන ගංගාව",
          gradeLevel = "09-11",
          normalizedX = 0.33f,
          normalizedY = 0.69f,
          explanationSinhala = "කැලණි රාජධානිය, කෝට්ටේ සහ සීතාවක යුගයන්හි ප්‍රධාන වෙළඳ හා ප්‍රවාහන මාර්ගයයි. කොළඹට උතුරින් මුහුදට වැටේ.",
          markingCluesSinhala = "ශ්‍රී පාද අඩවියෙන් පටන්ගෙන බස්නාහිර වෙරළේ කොළඹ වරායට උතුරින් මුහුදට වැටෙන ගංගාවයි."
        ),
        HistoryMapPinLocation(
          id = "pin_walawe_river",
          pinNumber = 5,
          correctSinhalaName = "වලවේ ගඟ",
          correctEnglishName = "Walawe River",
          alternativeAliases = listOf("වලවේ ගඟ", "Walawe", "Walawe River", "වලවේ"),
          category = "දකුණු ප්‍රධාන ගංගාව",
          gradeLevel = "09-11",
          normalizedX = 0.56f,
          normalizedY = 0.85f,
          explanationSinhala = "රුහුණු රාජධානියේ කෘෂිකර්මාන්තයට බෙහෙවින් උපකාරී වූ ගංගාවකි. අම්බලන්තොට ගොඩවාය වරාය අසලින් මුහුදට වැටේ.",
          markingCluesSinhala = "සමනල වැව ප්‍රදේශයෙන් ඇරඹී දකුණු මුහුදේ අම්බලන්තොටින් මුහුදට වැටෙන ප්‍රධාන ගංගාවයි."
        ),
        HistoryMapPinLocation(
          id = "pin_parakrama_samudraya",
          pinNumber = 6,
          correctSinhalaName = "පරාක්‍රම සමුද්‍රය",
          correctEnglishName = "Parakrama Samudraya",
          alternativeAliases = listOf("පරාක්‍රම සමුද්‍රය", "Parakrama Samudra", "Parakrama Samudraya", "පරාක්‍රම සමුදුර"),
          category = "මහා ජලාශය",
          gradeLevel = "10-11",
          normalizedX = 0.62f,
          normalizedY = 0.44f,
          explanationSinhala = "මහා පරාක්‍රමබාහු රජතුමා විසින් තෝපාවැව, එරබදු වැව සහ දුඹුටුලු වැව එක්කොට ඉදිකළ විශාලතම ඓතිහාසික ජලාශයයි.",
          markingCluesSinhala = "පොළොන්නරුව නගරයට බස්නාහිරින් පිහිටි විශාල වැව් සංකීර්ණය ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_kala_wewa",
          pinNumber = 7,
          correctSinhalaName = "කලා වැව",
          correctEnglishName = "Kala Wewa",
          alternativeAliases = listOf("කලා වැව", "Kala Wewa", "Kalawewa", "කලාවැව"),
          category = "මහා ජලාශය",
          gradeLevel = "09-11",
          normalizedX = 0.46f,
          normalizedY = 0.44f,
          explanationSinhala = "ධාතුසේන රජතුමා විසින් කරවන ලද මහා ජලාශයයි. යෝධ ඇළ (ජය ගඟ) මඟින් අනුරාධපුර තිසා වැව දක්වා ජලය ගෙන යන ලදී.",
          markingCluesSinhala = "අනුරාධපුරයට දකුණින්, දඹුල්ලට වයඹ දෙසින් පිහිටි කලා වැව සහ බළලු වැව එකමුතුව ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_minneriya_wewa",
          pinNumber = 8,
          correctSinhalaName = "මින්නේරිය වැව",
          correctEnglishName = "Minneriya Wewa",
          alternativeAliases = listOf("මින්නේරිය වැව", "Minneriya", "Minneriya Wewa", "මින්නේරිය"),
          category = "මහා ජලාශය",
          gradeLevel = "09-11",
          normalizedX = 0.58f,
          normalizedY = 0.39f,
          explanationSinhala = "මහසෙන් රජතුමා විසින් කරවන ලද ප්‍රධානතම මහා වැවකි. මහසෙන් රජු 'මින්නේරි දෙවියන්' ලෙස ජනතාවගේ වන්දනාවට පාත්‍ර වීමට හේතු විය.",
          markingCluesSinhala = "හබරණ සහ පොළොන්නරුව අතර මධ්‍ය ප්‍රදේශයේ පිහිටි ජලාශය ලකුණු කරන්න."
        )
      )
    ),

    // -------------------------------------------------------------
    // EXERCISE 3: MEDIEVAL AND LATER KINGDOMS (පොළොන්නරු හා පසුකාලීන රාජධානි)
    // -------------------------------------------------------------
    HistoryMapExercise(
      id = "sl_medieval_kingdoms",
      titleSinhala = "පොළොන්නරු හා පසුකාලීන රාජධානි (ශ්‍රී ලංකා සිතියම)",
      subtitleSinhala = "පොළොන්නරුව, සීගිරිය, දඹදෙණිය, යාපහුව, කුරුණෑගල, ගම්පොළ, කෝට්ටේ, සීතාවක, මහනුවර",
      mapType = HistoryMapType.SRI_LANKA_MEDIEVAL,
      targetGrades = "10, 11",
      descriptionSinhala = "පොළොන්නරු යුගයේ සිට කන්ද උඩරට රාජධානිය දක්වා ලක්දිව රාජධානි මාරුවීම හා බැඳි ඓතිහාසික කේන්ද්‍රස්ථාන හඳුනාගන්න.",
      pins = listOf(
        HistoryMapPinLocation(
          id = "pin_polonnaruwa",
          pinNumber = 1,
          correctSinhalaName = "පොළොන්නරුව",
          correctEnglishName = "Polonnaruwa",
          alternativeAliases = listOf("පොළොන්නරුව", "Polonnaruwa", "පුලතිසිපුර", "විජයරාජපුර", "ජනනාථපුරම්"),
          category = "මධ්‍යතන අගනුවර",
          gradeLevel = "10-11",
          normalizedX = 0.63f,
          normalizedY = 0.43f,
          explanationSinhala = "විජයබාහු I, මහා පරාක්‍රමබාහු සහ නිශ්ශංකමල්ල රජවරුන්ගේ පාලන සමයන්හි බැබළුණු ලක්දිව දෙවන ප්‍රධාන අගනුවරයි.",
          markingCluesSinhala = "මහවැලි නිම්නයට බස්නාහිරින් පරාක්‍රම සමුද්‍රය අසල පොළොන්නරුව ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_sigiriya",
          pinNumber = 2,
          correctSinhalaName = "සීගිරිය",
          correctEnglishName = "Sigiriya",
          alternativeAliases = listOf("සීගිරිය", "Sigiriya", "සීගිරි පර්වතය", "සිංහගිරිය"),
          category = "පර්වත නගරය",
          gradeLevel = "10-11",
          normalizedX = 0.52f,
          normalizedY = 0.44f,
          explanationSinhala = "ක්‍රි.ව. 5 වන සියවසේ කාශ්‍යප රජතුමා විසින් අලංකාර ලෙස නිර්මාණය කරන ලද ලෝක උරුම පර්වත මාළිගා නගරයයි.",
          markingCluesSinhala = "දඹුල්ලට ඊසාන දෙසින් පිහිටි සීගිරි පර්වතය ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_dambadeniya",
          pinNumber = 3,
          correctSinhalaName = "දඹදෙණිය",
          correctEnglishName = "Dambadeniya",
          alternativeAliases = listOf("දඹදෙණිය", "Dambadeniya", "දඹදෙණි රාජධානිය"),
          category = "පසුකාලීන අගනුවර",
          gradeLevel = "10-11",
          normalizedX = 0.37f,
          normalizedY = 0.59f,
          explanationSinhala = "කාලිංග මාඝගේ ආක්‍රමණයෙන් පසු III වන විජයබාහු රජු විසින් ආරම්භ කළ ප්‍රථම නිරිතදිග අගනුවරයි. II පරාක්‍රමබාහු රජු යටතේ සාහිත්‍ය ස්වර්ණ යුගයක් විය.",
          markingCluesSinhala = "කුරුණෑගල සහ මීගමුව අතර, ගිරිඋල්ල ආසන්න ප්‍රදේශයේ ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_yapahuwa",
          pinNumber = 4,
          correctSinhalaName = "යාපහුව",
          correctEnglishName = "Yapahuwa",
          alternativeAliases = listOf("යාපහුව", "Yapahuwa", "සුන්දරගිරිය"),
          category = "පර්වත අගනුවර",
          gradeLevel = "10-11",
          normalizedX = 0.41f,
          normalizedY = 0.47f,
          explanationSinhala = "I වන බුවනෙකබාහු රජුගේ පාලන සමයේ අගනුවර වූ මනරම් ගල් පඩිපෙළ සහිත බලකොටු පර්වත නගරයයි.",
          markingCluesSinhala = "මහව දුම්රිය මංසන්ධිය ආසන්නයේ, කුරුණෑගලට උතුරින් ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_kurunegala",
          pinNumber = 5,
          correctSinhalaName = "කුරුණෑගල (හත්ථිශෛලපුර)",
          correctEnglishName = "Kurunegala",
          alternativeAliases = listOf("කුරුණෑගල", "Kurunegala", "හත්ථිශෛලපුර", "ඇතුගල්පුර"),
          category = "පසුකාලීන අගනුවර",
          gradeLevel = "10-11",
          normalizedX = 0.42f,
          normalizedY = 0.55f,
          explanationSinhala = "II වන බුවනෙකබාහු සහ IV වන පරාක්‍රමබාහු රජවරුන්ගේ අගනුවරයි. සිංහල ජාතක පොත පරිවර්තනය කෙරුණේ මෙම යුගයේදීය.",
          markingCluesSinhala = "ඇතුගල ඇතුළු පර්වත වටවූ කුරුණෑගල නගරය මැද ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_gampola",
          pinNumber = 6,
          correctSinhalaName = "ගම්පොළ (ගංගාසිරිපුර)",
          correctEnglishName = "Gampola",
          alternativeAliases = listOf("ගම්පොළ", "Gampola", "ගංගාසිරිපුර"),
          category = "කඳුකර අගනුවර",
          gradeLevel = "10-11",
          normalizedX = 0.47f,
          normalizedY = 0.65f,
          explanationSinhala = "IV වන බුවනෙකබාහු රජු විසින් අගනුවර කරගත් මහවැලි ගං නිම්නයේ පිහිටි කඳුකර අගනුවරයි. ලංකාතිලක, ගඩලාදෙණිය, ඇම්බැක්ක විහාර ඉදිවිය.",
          markingCluesSinhala = "මහනුවරට දකුණින් මහවැලි ගඟ අසබඩ ගම්පොළ ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_kotte",
          pinNumber = 7,
          correctSinhalaName = "කෝට්ටේ (ශ්‍රී ජයවර්ධනපුර)",
          correctEnglishName = "Kotte (Sri Jayawardenepura)",
          alternativeAliases = listOf("කෝට්ටේ", "Kotte", "ශ්‍රී ජයවර්ධනපුර කෝට්ටේ", "Jayawardenepura", "ජයවර්ධනපුර"),
          category = "ප්‍රධාන අගනුවර",
          gradeLevel = "10-11",
          normalizedX = 0.32f,
          normalizedY = 0.72f,
          explanationSinhala = "VI වන පරාක්‍රමබාහු රජතුමා විසින් මුළු ලංකාවම එක්සේසත් කළ, සන්දේශ සාහිත්‍යයේ ස්වර්ණමය යුගය බිහිවූ ප්‍රධාන අගනුවරයි. දිය අගල් හා කඩොලාන වලින් ආරක්ෂිත විය.",
          markingCluesSinhala = "කොළඹට ගිණිකොණ දෙසින් දියවන්නා ඔය ආශ්‍රිත ප්‍රදේශයේ ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_kandy",
          pinNumber = 8,
          correctSinhalaName = "මහනුවර (සෙංකඩගල)",
          correctEnglishName = "Kandy (Senkadagala)",
          alternativeAliases = listOf("මහනුවර", "Kandy", "සෙංකඩගල", "සෙංකඩගලපුර", "කන්ද උඩරට"),
          category = "අවසාන ස්වාධීන රාජධානිය",
          gradeLevel = "10-11",
          normalizedX = 0.50f,
          normalizedY = 0.61f,
          explanationSinhala = "1815 දී බ්‍රිතාන්‍යයන්ට යටත්වන තෙක් ශ්‍රී ලංකාවේ අවසාන ස්වාධීන රාජධානිය ලෙස පැවති ඓතිහාසික කන්ද උඩරට අගනුවරයි.",
          markingCluesSinhala = "මධ්‍යම කඳුකරයේ මහවැලි ගඟෙන් වටවූ මහනුවර නිම්නය ලකුණු කරන්න."
        )
      )
    ),

    // -------------------------------------------------------------
    // EXERCISE 4: INDIA & ASIAN CIVILIZATIONS (ඉන්දියාව සහ ආසියානු ශිෂ්ටාචාර)
    // -------------------------------------------------------------
    HistoryMapExercise(
      id = "india_asian_civilizations",
      titleSinhala = "ඉන්දියාව සහ ආසියානු ශිෂ්ටාචාර (ඉන්දීය උපමහද්වීප සිතියම)",
      subtitleSinhala = "හරප්පා, මොහෙන්ජොදාරෝ, පාටලීපුත්‍ර, නාලන්දා, කපිලවස්තු, තක්ෂිලා, මහාබලිපුරම්",
      mapType = HistoryMapType.INDIA_ASIA,
      targetGrades = "09, 10, 11",
      descriptionSinhala = "09, 10 සහ 11 ශ්‍රේණි ඉතිහාසය විභාග ප්‍රශ්න පත්‍රවල අනිවාර්යයෙන් විමසන ඉන්දීය උපමහද්වීපයේ ඓතිහාසික නගර හා ශිෂ්ටාචාර සිතියමේ ලකුණු කරන්න.",
      pins = listOf(
        HistoryMapPinLocation(
          id = "pin_harappa",
          pinNumber = 1,
          correctSinhalaName = "හරප්පා",
          correctEnglishName = "Harappa",
          alternativeAliases = listOf("හරප්පා", "Harappa", "හරප්පා නගරය"),
          category = "ඉන්දු නිම්න ශිෂ්ටාචාරය",
          gradeLevel = "09-11",
          normalizedX = 0.35f,
          normalizedY = 0.25f,
          explanationSinhala = "ඉන්දු නිම්න ශිෂ්ටාචාරයේ උතුරු ප්‍රධාන නගරයයි. පන්ජාබයේ රාවී නදී ඉවුරේ පිහිටා තිබූ අතර මනා නගර සැලසුම්කරණය හා ධාන්‍යාගාර සඳහා ප්‍රකටය.",
          markingCluesSinhala = "වර්තමාන පකිස්ථාන පන්ජාබ් ප්‍රදේශයේ, රාවී නදිය අසල උතුරු ඉන්දු නිම්නයේ ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_mohenjodaro",
          pinNumber = 2,
          correctSinhalaName = "මොහෙන්ජොදාරෝ",
          correctEnglishName = "Mohenjo-daro",
          alternativeAliases = listOf("මොහෙන්ජොදාරෝ", "Mohenjodaro", "Mohenjo-daro", "මොහෙන්ජෝදාරෝ"),
          category = "ඉන්දු නිම්න ශිෂ්ටාචාරය",
          gradeLevel = "09-11",
          normalizedX = 0.28f,
          normalizedY = 0.35f,
          explanationSinhala = "ඉන්දු නිම්නයේ දකුණු ප්‍රධාන නගරයයි. ප්‍රසිද්ධ මහා නාන තටාකය, කාණු පද්ධතිය හා පුළුල් වීදි සැලසුම මෙහි පිහිටා තිබුණි.",
          markingCluesSinhala = "ඉන්දු නදියේ පහළ නිම්නයේ (සින්ද් ප්‍රදේශය) අරාබි මුහුදට තරමක් උතුරින් ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_pataliputra",
          pinNumber = 3,
          correctSinhalaName = "පාටලීපුත්‍ර",
          correctEnglishName = "Pataliputra",
          alternativeAliases = listOf("පාටලීපුත්‍ර", "Pataliputra", "පැට්නා", "Patna", "පාටලීපුත්‍රය"),
          category = "මෞර්ය / ගුප්ත අගනුවර",
          gradeLevel = "09-11",
          normalizedX = 0.68f,
          normalizedY = 0.38f,
          explanationSinhala = "ධර්මාශෝක රජතුමාගේ මෞර්ය අධිරාජ්‍යයේ සහ ගුප්ත අධිරාජ්‍යයේ ප්‍රධාන අගනුවරයි. ගංගා සහ සෝන් නදී එක්වන ස්ථානයේ පිහිටා ඇත (වර්තමාන පැට්නා නගරය).",
          markingCluesSinhala = "ගංගා නදියේ මැද නිම්නයේ බිහාර් ප්‍රදේශයේ ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_nalanda",
          pinNumber = 4,
          correctSinhalaName = "නාලන්දා",
          correctEnglishName = "Nalanda",
          alternativeAliases = listOf("නාලන්දා", "Nalanda", "නාලන්දා විශ්වවිද්‍යාලය"),
          category = "පුරාණ විශ්වවිද්‍යාලය",
          gradeLevel = "09-11",
          normalizedX = 0.70f,
          normalizedY = 0.40f,
          explanationSinhala = "ගුප්ත යුගයේදී ලොව පුරා විද්වතුන් ආකර්ෂණය කරගත් ප්‍රමුඛතම බෞද්ධ මහා විහාරය සහ ජාත්‍යන්තර විශ්වවිද්‍යාලයයි.",
          markingCluesSinhala = "පාටලීපුත්‍රයට මදක් ගිණිකොණ දෙසින් බිහාර් ප්‍රාන්තයේ ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_taxila",
          pinNumber = 5,
          correctSinhalaName = "තක්ෂිලා",
          correctEnglishName = "Taxila",
          alternativeAliases = listOf("තක්ෂිලා", "Taxila", "තක්සලාව", "Takshashila"),
          category = "පුරාණ අධ්‍යාපන කේන්ද්‍රය",
          gradeLevel = "09-11",
          normalizedX = 0.30f,
          normalizedY = 0.16f,
          explanationSinhala = "ගන්ධාර දේශයේ අගනුවර වූ අතර වේද, ශිල්ප ශාස්ත්‍ර හා වෛද්‍ය විද්‍යාව ඉගැන්වූ ලොව පැරණිතම ජාත්‍යන්තර අධ්‍යාපන කේන්ද්‍රයකි.",
          markingCluesSinhala = "ඉන්දියාවේ වයඹදිග දේශසීමාවේ (වර්තමාන ඉස්ලාමාබාද් අසල) ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_mahabalipuram",
          pinNumber = 6,
          correctSinhalaName = "මහාබලිපුරම් (මාමල්ලපුරම්)",
          correctEnglishName = "Mahabalipuram",
          alternativeAliases = listOf("මහාබලිපුරම්", "Mahabalipuram", "මාමල්ලපුරම්", "Mamallapuram"),
          category = "දකුණු ඉන්දීය වරාය හා කලා මධ්‍යස්ථානය",
          gradeLevel = "10-11",
          normalizedX = 0.54f,
          normalizedY = 0.76f,
          explanationSinhala = "පල්ලව රාජධානි සමයේ ප්‍රධාන වෙළඳ වරාය සහ පර්වත විහාර කලා මධ්‍යස්ථානයයි. ලක්දිව මානවම්ම කුමරුට සේනාව සපයා දුන්නේ මෙහිය.",
          markingCluesSinhala = "දකුණු ඉන්දියාවේ චෙන්නායි නගරයට දකුණින් කොරමැන්ඩල් වෙරළ තීරයේ ලකුණු කරන්න."
        )
      )
    ),

    // -------------------------------------------------------------
    // EXERCISE 5: WORLD HISTORY & CIVILIZATIONS (ලෝක ඉතිහාසය)
    // -------------------------------------------------------------
    HistoryMapExercise(
      id = "world_civilizations_routes",
      titleSinhala = "ලෝක ඉතිහාසය, ශිෂ්ටාචාර සහ වෙළඳ මාර්ග",
      subtitleSinhala = "මෙසපොතේමියාව, නයිල් නිම්නය, රෝමය, ග්‍රීසිය (ඇතැන්ස්), කොන්ස්තන්තිනෝපලය, සේද මාවත",
      mapType = HistoryMapType.WORLD_CIVILIZATIONS,
      targetGrades = "09, 10, 11",
      descriptionSinhala = "මානව ශිෂ්ටාචාරයේ තොටිල්ල වූ මෙසපොතේමියාව, ඊජිප්තුව, රෝමය, ග්‍රීසිය සහ කොන්ස්තන්තිනෝපලය ලෝක සිතියමේ නිවැරදිව හඳුනාගන්න.",
      pins = listOf(
        HistoryMapPinLocation(
          id = "pin_mesopotamia",
          pinNumber = 1,
          correctSinhalaName = "මෙසපොතේමියාව (යුප්‍රටීස්-ටයිග්‍රීස්)",
          correctEnglishName = "Mesopotamia",
          alternativeAliases = listOf("මෙසපොතේමියාව", "Mesopotamia", "ඉරාකය", "යුප්‍රටීස් ටයිග්‍රීස්"),
          category = "ලොව පැරණිතම ශිෂ්ටාචාරය",
          gradeLevel = "09-11",
          normalizedX = 0.54f,
          normalizedY = 0.42f,
          explanationSinhala = "යුප්‍රටීස් සහ ටයිග්‍රීස් ගංගා නිම්නයේ (වර්තමාන ඉරාකය) බිහිවූ සුමේරියානු, බැබිලෝනියානු ශිෂ්ටාචාරයන්ගේ මූලස්ථානයයි. කුඤ්ඤ අක්ෂර ක්‍රමය සහ රෝදය ලොවට දායාද කළේය.",
          markingCluesSinhala = "පර්සියානු බොක්කට ඉහළින් යුප්‍රටීස් සහ ටයිග්‍රීස් ගංගා දෙක අතර සාරවත් චන්ද්‍රවංක ප්‍රදේශය ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_egypt_nile",
          pinNumber = 2,
          correctSinhalaName = "නයිල් නිම්නය (ඊජිප්තුව)",
          correctEnglishName = "Nile Valley (Egypt)",
          alternativeAliases = listOf("නයිල් නිම්නය", "ඊජිප්තුව", "Egypt", "Nile Valley", "නයිල්"),
          category = "පුරාණ ශිෂ්ටාචාරය",
          gradeLevel = "09-11",
          normalizedX = 0.46f,
          normalizedY = 0.45f,
          explanationSinhala = "ලොව දිගම ගංගාව වන නයිල් නදිය ආශ්‍රිතව බිහිවූ පිරමීඩ, පැපිරස් සහ හයිරොග්ලිෆික් අක්ෂර කලාව නිර්මාණය කළ ඊජිප්තු ශිෂ්ටාචාරයයි.",
          markingCluesSinhala = "ඊසානදිග අප්‍රිකාවේ, රතු මුහුදට බටහිරින් නයිල් ගංගා නිම්නය සහ ඩෙල්ටාව ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_rome",
          pinNumber = 3,
          correctSinhalaName = "රෝමය (ඉතාලිය)",
          correctEnglishName = "Rome (Italy)",
          alternativeAliases = listOf("රෝමය", "Rome", "ඉතාලිය", "Roma", "රෝම අධිරාජ්‍යය"),
          category = "රෝම අධිරාජ්‍යය",
          gradeLevel = "10-11",
          normalizedX = 0.38f,
          normalizedY = 0.35f,
          explanationSinhala = "මධ්‍යධරණී මුහුද වටා පැතිරුණු දැවැන්ත රෝම අධිරාජ්‍යයේ අගනුවරයි. නීතිය, පාලන ක්‍රම සහ කොලොසියම් වැනි ගෘහ නිර්මාණ ලොවට දායාද කළේය.",
          markingCluesSinhala = "ඉතාලි අර්ධද්වීපයේ (බූට් සපත්තු හැඩය ඇති) මධ්‍ය බටහිර වෙරළ තීරයේ රෝමය ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_athens",
          pinNumber = 4,
          correctSinhalaName = "ඇතැන්ස් (ග්‍රීසිය)",
          correctEnglishName = "Athens (Greece)",
          alternativeAliases = listOf("ඇතැන්ස්", "Athens", "ග්‍රීසිය", "Greece", "ඇතෑන්ස්"),
          category = "ග්‍රීක ශිෂ්ටාචාරය / ප්‍රජාතන්ත්‍රවාදය",
          gradeLevel = "10-11",
          normalizedX = 0.43f,
          normalizedY = 0.38f,
          explanationSinhala = "ලොව ප්‍රථම ප්‍රජාතන්ත්‍රවාදී පාලන ක්‍රමය, දර්ශනය සහ ඔලිම්පික් උළෙල බිහිකළ ප්‍රධාන ග්‍රීක නගර රාජ්‍යයයි.",
          markingCluesSinhala = "ග්‍රීක අර්ධද්වීපයේ දකුණු කෙළවර ආසන්නයේ ඊජියන් මුහුද දෙසට මුහුණලා පිහිටි ඇතැන්ස් ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_constantinople",
          pinNumber = 5,
          correctSinhalaName = "කොන්ස්තන්තිනෝපලය (ඉස්තාන්බුල්)",
          correctEnglishName = "Constantinople (Istanbul)",
          alternativeAliases = listOf("කොන්ස්තන්තිනෝපලය", "Constantinople", "ඉස්තාන්බුල්", "Istanbul", "බයිසැන්ටියම්"),
          category = "නැගෙනහිර රෝම අගනුවර / වෙළඳ මංසන්ධිය",
          gradeLevel = "10-11",
          normalizedX = 0.46f,
          normalizedY = 0.34f,
          explanationSinhala = "යුරෝපය සහ ආසියාව යා කළ බොස්ෆරස් සමුද්‍ර සන්ධියේ පිහිටි ප්‍රධාන වෙළඳ මංසන්ධියයි. 1453 දී ඔටෝමන්වරුන්ට යටත්වීමෙන් නව යුගය ඇරඹිණි.",
          markingCluesSinhala = "කළු මුහුද සහ මධ්‍යධරණී මුහුද යා වන බොස්ෆරස් සමුද්‍ර සන්ධිය හරියටම ලකුණු කරන්න."
        ),
        HistoryMapPinLocation(
          id = "pin_silk_road",
          pinNumber = 6,
          correctSinhalaName = "සේද මාවත (Silk Road)",
          correctEnglishName = "Silk Road",
          alternativeAliases = listOf("සේද මාවත", "Silk Road", "සේද මග", "චීන සේද මාවත"),
          category = "ඓතිහාසික ජාත්‍යන්තර වෙළඳ මාර්ගය",
          gradeLevel = "10-11",
          normalizedX = 0.65f,
          normalizedY = 0.32f,
          explanationSinhala = "චීනයේ ෂියාන් නගරයේ සිට මධ්‍යම ආසියාව හරහා යුරෝපය සහ මැදපෙරදිග දක්වා දිවුණු ලොව ප්‍රමුඛතම ගොඩබිම් වෙළඳ මාර්ගයයි.",
          markingCluesSinhala = "චීනයේ සිට මධ්‍යම ආසියාව හරහා මධ්‍යධරණී කලාපය දක්වා විහිදෙන මාර්ගය ලකුණු කරන්න."
        )
      )
    )
  )

  // Normalizer & 100% Accuracy Verifier for student input
  fun verifyAnswer(userInput: String, pin: HistoryMapPinLocation): MapAnswerResult {
    val cleanedInput = userInput.trim().lowercase()
      .replace(" ", "")
      .replace(".", "")
      .replace("(", "")
      .replace(")", "")
      .replace("-", "")

    if (cleanedInput.isBlank()) {
      return MapAnswerResult(
        isCorrect = false,
        userAnswer = userInput,
        correctName = pin.correctSinhalaName,
        feedbackMessage = "කරුණාකර පිළිතුරක් ඇතුළත් කරන්න.",
        explanation = pin.explanationSinhala,
        markingClue = pin.markingCluesSinhala
      )
    }

    val acceptableList = mutableListOf<String>()
    acceptableList.add(pin.correctSinhalaName)
    acceptableList.add(pin.correctEnglishName)
    acceptableList.addAll(pin.alternativeAliases)

    val isMatch = acceptableList.any { alias ->
      val cleanedAlias = alias.trim().lowercase()
        .replace(" ", "")
        .replace(".", "")
        .replace("(", "")
        .replace(")", "")
        .replace("-", "")

      cleanedInput == cleanedAlias ||
          (cleanedInput.length >= 4 && cleanedAlias.contains(cleanedInput)) ||
          (cleanedAlias.length >= 4 && cleanedInput.contains(cleanedAlias))
    }

    return MapAnswerResult(
      isCorrect = isMatch,
      userAnswer = userInput,
      correctName = pin.correctSinhalaName,
      feedbackMessage = if (isMatch) "✅ විශිෂ්ටයි! 100% ක් නිවැරදියි." else "❌ පිළිතුර වැරදියි. නිවැරදි ස්ථානය: ${pin.correctSinhalaName}",
      explanation = pin.explanationSinhala,
      markingClue = pin.markingCluesSinhala
    )
  }
}

data class MapAnswerResult(
  val isCorrect: Boolean,
  val userAnswer: String,
  val correctName: String,
  val feedbackMessage: String,
  val explanation: String,
  val markingClue: String
)

// ==============================================================================
// MAIN INTERACTIVE HISTORY MAP AUTO-CHECKER SCREEN (COMPOSE UI)
// ==============================================================================

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryMapsAutoCheckerScreen(
  initialExerciseId: String? = null,
  onBack: () -> Unit,
  onOpenPdfDriveViewer: (String, String) -> Unit
) {
  val context = LocalContext.current
  var selectedExerciseIndex by remember {
    val initialIdx = HistoryMapsRepository.allExercises.indexOfFirst { it.id == initialExerciseId }
    mutableStateOf(if (initialIdx >= 0) initialIdx else 0)
  }

  val activeExercise = HistoryMapsRepository.allExercises.getOrElse(selectedExerciseIndex) {
    HistoryMapsRepository.allExercises.first()
  }

  // User Answers State: Map of pinId -> user entered text
  val userAnswers = remember(activeExercise.id) { mutableStateMapOf<String, String>() }
  // Verification Results State: Map of pinId -> MapAnswerResult
  val verificationResults = remember(activeExercise.id) { mutableStateMapOf<String, MapAnswerResult>() }
  // Selected Pin for detailed inspection / focus
  var activeSelectedPinId by remember(activeExercise.id) {
    mutableStateOf(activeExercise.pins.firstOrNull()?.id)
  }

  var isSubmitted by remember(activeExercise.id) { mutableStateOf(false) }
  var showStudyGuideModal by remember { mutableStateOf(false) }
  var showDrivePdfDirectModal by remember { mutableStateOf(false) }

  // Calculate score
  val totalPins = activeExercise.pins.size
  val correctCount = verificationResults.values.count { it.isCorrect }
  val scorePercentage = if (totalPins > 0) ((correctCount.toFloat() / totalPins) * 100).toInt() else 0

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = "🗺️ ඉතිහාසය සිතියම් Auto-Checker",
              fontSize = 17.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Text(
              text = "09, 10, 11 ශ්‍රේණි • 100% ස්වයංක්‍රීය පරීක්ෂාව",
              fontSize = 11.sp,
              color = Color(0xFFBAE6FD)
            )
          }
        },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = "Back",
              tint = Color.White
            )
          }
        },
        actions = {
          // Open PDF direct button
          FilledTonalButton(
            onClick = {
              onOpenPdfDriveViewer(
                HistoryMapsRepository.pdfDriveUrl,
                "09/10/11 ශ්‍රේණි - ඉතිහාසය හිස්තැන් සහිත සිතියම් ගොන්න"
              )
            },
            colors = ButtonDefaults.filledTonalButtonColors(
              containerColor = Color(0xFF0284C7),
              contentColor = Color.White
            ),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
            modifier = Modifier.padding(end = 4.dp)
          ) {
            Icon(Icons.Default.PictureAsPdf, contentDescription = null, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text("මුල් PDF", fontSize = 11.sp, fontWeight = FontWeight.Bold)
          }

          // Study Guide
          IconButton(onClick = { showStudyGuideModal = true }) {
            Icon(
              imageVector = Icons.Default.MenuBook,
              contentDescription = "Rules & Guide",
              tint = Color.White
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
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
    ) {
      // Category / Exercise Tab Selector Bar
      Surface(
        color = Color.White,
        shadowElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
      ) {
        LazyRow(
          contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
          horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          items(HistoryMapsRepository.allExercises.indices.toList()) { idx ->
            val ex = HistoryMapsRepository.allExercises[idx]
            val isSelected = selectedExerciseIndex == idx
            FilterChip(
              selected = isSelected,
              onClick = {
                selectedExerciseIndex = idx
                isSubmitted = false
              },
              label = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text(ex.mapType.iconEmoji, fontSize = 13.sp)
                  Spacer(modifier = Modifier.width(4.dp))
                  Text(
                    text = ex.mapType.displayName,
                    fontSize = 12.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                  )
                }
              },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = Color(0xFF0284C7),
                selectedLabelColor = Color.White,
                containerColor = Color(0xFFF1F5F9),
                labelColor = Color(0xFF334155)
              ),
              border = FilterChipDefaults.filterChipBorder(
                borderColor = if (isSelected) Color(0xFF0284C7) else Color(0xFFCBD5E1),
                enabled = true,
                selected = isSelected
              )
            )
          }
        }
      }

      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
          .weight(1f)
          .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        contentPadding = PaddingValues(top = 12.dp, bottom = 24.dp)
      ) {
        // 1. Header Banner with Drive PDF Link & Instructions
        item {
          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(16.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Surface(
                    color = Color(0xFF0284C7).copy(alpha = 0.2f),
                    shape = RoundedCornerShape(8.dp)
                  ) {
                    Text(
                      text = "GRADE ${activeExercise.targetGrades}",
                      color = Color(0xFF38BDF8),
                      fontSize = 11.sp,
                      fontWeight = FontWeight.Bold,
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }
                  Spacer(modifier = Modifier.width(8.dp))
                  Text(
                    text = "සිතියම් ${activeExercise.pins.size} ක්",
                    color = Color(0xFF94A3B8),
                    fontSize = 12.sp
                  )
                }

                if (isSubmitted) {
                  Surface(
                    color = if (scorePercentage >= 75) Color(0xFF16A34A) else if (scorePercentage >= 50) Color(0xFFF59E0B) else Color(0xFFDC2626),
                    shape = RoundedCornerShape(12.dp)
                  ) {
                    Text(
                      text = "ලකුණු: $scorePercentage% ($correctCount/$totalPins)",
                      color = Color.White,
                      fontSize = 12.sp,
                      fontWeight = FontWeight.Bold,
                      modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                  }
                }
              }

              Spacer(modifier = Modifier.height(10.dp))

              Text(
                text = activeExercise.titleSinhala,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )

              Spacer(modifier = Modifier.height(4.dp))

              Text(
                text = activeExercise.descriptionSinhala,
                fontSize = 12.sp,
                color = Color(0xFFCBD5E1),
                lineHeight = 17.sp
              )

              Spacer(modifier = Modifier.height(12.dp))

              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
              ) {
                Button(
                  onClick = {
                    onOpenPdfDriveViewer(
                      HistoryMapsRepository.pdfDriveUrl,
                      "09/10/11 ශ්‍රේණි - ඉතිහාසය හිස්තැන් සහිත සිතියම් ගොන්න"
                    )
                  },
                  colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
                  shape = RoundedCornerShape(10.dp),
                  modifier = Modifier.weight(1f)
                ) {
                  Icon(Icons.Default.PictureAsPdf, contentDescription = null, modifier = Modifier.size(16.dp))
                  Spacer(modifier = Modifier.width(6.dp))
                  Text("පීඩීඑෆ් සිතියම බලන්න", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }

                OutlinedButton(
                  onClick = { showStudyGuideModal = true },
                  colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF38BDF8)),
                  border = BorderStroke(1.dp, Color(0xFF38BDF8)),
                  shape = RoundedCornerShape(10.dp)
                ) {
                  Icon(Icons.Default.HelpOutline, contentDescription = null, modifier = Modifier.size(16.dp))
                  Spacer(modifier = Modifier.width(4.dp))
                  Text("ලකුණු කිරීමේ රීති", fontSize = 12.sp)
                }
              }
            }
          }
        }

        // 2. Interactive Visual Map Canvas with Numbered Pins
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
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = Color(0xFF0284C7),
                    modifier = Modifier.size(18.dp)
                  )
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = "අන්තර්ක්‍රියාකාරී සිතියම් පුවරුව (Interactive Map)",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A)
                  )
                }

                Text(
                  text = "අංකයක් මත ක්ලික් කරන්න",
                  fontSize = 11.sp,
                  color = Color(0xFF64748B)
                )
              }

              Spacer(modifier = Modifier.height(10.dp))

              // Custom Drawn Sri Lanka / World Vector Silhouette with Pins
              InteractiveMapCanvasView(
                exercise = activeExercise,
                selectedPinId = activeSelectedPinId,
                isSubmitted = isSubmitted,
                verificationResults = verificationResults,
                onPinClick = { pinId ->
                  activeSelectedPinId = pinId
                }
              )
            }
          }
        }

        // 3. Selected Pin Focus & Instant Clue Card
        activeExercise.pins.find { it.id == activeSelectedPinId }?.let { focusedPin ->
          item {
            Card(
              shape = RoundedCornerShape(14.dp),
              colors = CardDefaults.cardColors(
                containerColor = when {
                  !isSubmitted -> Color(0xFFF0F9FF)
                  verificationResults[focusedPin.id]?.isCorrect == true -> Color(0xFFF0FDF4)
                  else -> Color(0xFFFEF2F2)
                }
              ),
              border = BorderStroke(
                1.dp,
                when {
                  !isSubmitted -> Color(0xFFBAE6FD)
                  verificationResults[focusedPin.id]?.isCorrect == true -> Color(0xFF86EFAC)
                  else -> Color(0xFFFECACA)
                }
              ),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(14.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                      color = Color(0xFF0284C7),
                      shape = CircleShape,
                      modifier = Modifier.size(26.dp)
                    ) {
                      Box(contentAlignment = Alignment.Center) {
                        Text(
                          text = "${focusedPin.pinNumber}",
                          color = Color.White,
                          fontSize = 13.sp,
                          fontWeight = FontWeight.Bold
                        )
                      }
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                      text = "සිතියමේ අංක ${focusedPin.pinNumber} ස්ථානය",
                      fontSize = 14.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF0F172A)
                    )
                  }

                  Surface(
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color(0xFFE2E8F0))
                  ) {
                    Text(
                      text = focusedPin.category,
                      fontSize = 11.sp,
                      color = Color(0xFF475569),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                  }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.Top) {
                  Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    tint = Color(0xFF0284C7),
                    modifier = Modifier.size(16.dp).padding(top = 2.dp)
                  )
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = "හඳුනාගැනීමේ ඉඟිය: ${focusedPin.markingCluesSinhala}",
                    fontSize = 12.sp,
                    color = Color(0xFF334155),
                    lineHeight = 16.sp
                  )
                }

                if (isSubmitted) {
                  val result = verificationResults[focusedPin.id]
                  Spacer(modifier = Modifier.height(10.dp))
                  HorizontalDivider(color = Color(0xFFE2E8F0))
                  Spacer(modifier = Modifier.height(10.dp))

                  Text(
                    text = if (result?.isCorrect == true) "✅ නිවැරදියි: ${focusedPin.correctSinhalaName}" else "❌ නිවැරදි නම: ${focusedPin.correctSinhalaName}",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (result?.isCorrect == true) Color(0xFF15803D) else Color(0xFFDC2626)
                  )
                  Spacer(modifier = Modifier.height(4.dp))
                  Text(
                    text = "විභාග විස්තරය: ${focusedPin.explanationSinhala}",
                    fontSize = 12.sp,
                    color = Color(0xFF1E293B),
                    lineHeight = 16.sp
                  )
                }
              }
            }
          }
        }

        // 4. Fill-In-The-Blanks Section for all pins
        item {
          Text(
            text = "✍️ හිස්තැන් පුරවා නම් කරන්න (Fill in the blanks)",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0F172A),
            modifier = Modifier.padding(vertical = 4.dp)
          )
        }

        items(activeExercise.pins) { pin ->
          val currentAnswer = userAnswers[pin.id] ?: ""
          val result = verificationResults[pin.id]
          val isCurrentFocused = pin.id == activeSelectedPinId

          Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
              containerColor = if (isCurrentFocused) Color(0xFFF8FAFC) else Color.White
            ),
            border = BorderStroke(
              width = if (isCurrentFocused) 1.5.dp else 1.dp,
              color = when {
                isCurrentFocused && !isSubmitted -> Color(0xFF0284C7)
                isSubmitted && result?.isCorrect == true -> Color(0xFF86EFAC)
                isSubmitted && result?.isCorrect == false -> Color(0xFFFECACA)
                else -> Color(0xFFE2E8F0)
              }
            ),
            modifier = Modifier
              .fillMaxWidth()
              .clickable { activeSelectedPinId = pin.id }
          ) {
            Column(modifier = Modifier.padding(12.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Surface(
                  color = if (isSubmitted) {
                    if (result?.isCorrect == true) Color(0xFF16A34A) else Color(0xFFDC2626)
                  } else {
                    Color(0xFF0284C7)
                  },
                  shape = CircleShape,
                  modifier = Modifier.size(28.dp)
                ) {
                  Box(contentAlignment = Alignment.Center) {
                    Text(
                      text = "${pin.pinNumber}",
                      color = Color.White,
                      fontSize = 13.sp,
                      fontWeight = FontWeight.Bold
                    )
                  }
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column(modifier = Modifier.weight(1f)) {
                  Text(
                    text = "අංක ${pin.pinNumber} ස්ථානය:",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E293B)
                  )
                  Text(
                    text = pin.category,
                    fontSize = 11.sp,
                    color = Color(0xFF64748B)
                  )
                }

                if (isSubmitted) {
                  Text(
                    text = if (result?.isCorrect == true) "✅ නිවැරදියි" else "❌ වැරදියි",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (result?.isCorrect == true) Color(0xFF15803D) else Color(0xFFDC2626)
                  )
                }
              }

              Spacer(modifier = Modifier.height(8.dp))

              OutlinedTextField(
                value = currentAnswer,
                onValueChange = { newValue ->
                  userAnswers[pin.id] = newValue
                  if (isSubmitted) {
                    // re-check dynamically
                    verificationResults[pin.id] = HistoryMapsRepository.verifyAnswer(newValue, pin)
                  }
                },
                placeholder = {
                  Text("ස්ථානයේ නම ඇතුළත් කරන්න (උදා: ${pin.correctSinhalaName.take(3)}...)", fontSize = 12.sp)
                },
                modifier = Modifier
                  .fillMaxWidth()
                  .testTag("map_input_${pin.pinNumber}"),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                  focusedBorderColor = Color(0xFF0284C7),
                  unfocusedBorderColor = Color(0xFFCBD5E1)
                ),
                shape = RoundedCornerShape(8.dp)
              )

              // Quick Suggestion Chips (Optional helpers)
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(top = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
              ) {
                listOf(pin.correctSinhalaName, pin.alternativeAliases.firstOrNull() ?: pin.correctEnglishName).filterNotNull().forEach { suggestion ->
                  AssistChip(
                    onClick = {
                      userAnswers[pin.id] = suggestion
                      if (isSubmitted) {
                        verificationResults[pin.id] = HistoryMapsRepository.verifyAnswer(suggestion, pin)
                      }
                    },
                    label = { Text(suggestion, fontSize = 11.sp) },
                    colors = AssistChipDefaults.assistChipColors(
                      containerColor = Color(0xFFF1F5F9),
                      labelColor = Color(0xFF334155)
                    )
                  )
                }
              }

              // Post-Submission Detailed Feedback & Educational Explanation
              if (isSubmitted && result != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                  color = if (result.isCorrect) Color(0xFFF0FDF4) else Color(0xFFFEF2F2),
                  shape = RoundedCornerShape(8.dp),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                      text = if (result.isCorrect) {
                        "🎯 නියමයි! නිවැරදි නම: ${pin.correctSinhalaName} (${pin.correctEnglishName})"
                      } else {
                        "⚠️ නිවැරදි විය යුතු නම: ${pin.correctSinhalaName} (${pin.alternativeAliases.joinToString(", ")})"
                      },
                      fontSize = 12.sp,
                      fontWeight = FontWeight.Bold,
                      color = if (result.isCorrect) Color(0xFF15803D) else Color(0xFF991B1B)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                      text = "📍 සිතියමේ පිහිටීම: ${pin.markingCluesSinhala}",
                      fontSize = 11.sp,
                      color = Color(0xFF334155)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                      text = "📚 ඓතිහාසික පසුබිම: ${pin.explanationSinhala}",
                      fontSize = 11.sp,
                      color = Color(0xFF475569)
                    )
                  }
                }
              }
            }
          }
        }

        // 5. Action Buttons: Auto-Check / Reset
        item {
          Spacer(modifier = Modifier.height(8.dp))
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            Button(
              onClick = {
                // Auto-verify all pins
                activeExercise.pins.forEach { pin ->
                  val ans = userAnswers[pin.id] ?: ""
                  verificationResults[pin.id] = HistoryMapsRepository.verifyAnswer(ans, pin)
                }
                isSubmitted = true
              },
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
              shape = RoundedCornerShape(12.dp),
              modifier = Modifier
                .weight(1f)
                .height(48.dp)
                .testTag("auto_check_history_maps_btn")
            ) {
              Icon(Icons.Default.CheckCircle, contentDescription = null, modifier = Modifier.size(18.dp))
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = "100% ක් ස්වයංක්‍රීයව පරික්ෂා කරන්න",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
              )
            }

            if (isSubmitted) {
              OutlinedButton(
                onClick = {
                  userAnswers.clear()
                  verificationResults.clear()
                  isSubmitted = false
                },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF475569)),
                modifier = Modifier.height(48.dp)
              ) {
                Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("නැවත කරන්න", fontSize = 12.sp)
              }
            }
          }
        }
      }
    }
  }

  // Study Guide Modal for Map Marking Rules
  if (showStudyGuideModal) {
    HistoryMapRulesDialog(onDismiss = { showStudyGuideModal = false })
  }
}

// ==============================================================================
// INTERACTIVE MAP CANVAS WITH SRI LANKA / WORLD VECTOR & PINPOINTS
// ==============================================================================

@Composable
fun InteractiveMapCanvasView(
  exercise: HistoryMapExercise,
  selectedPinId: String?,
  isSubmitted: Boolean,
  verificationResults: Map<String, MapAnswerResult>,
  onPinClick: (String) -> Unit
) {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .height(280.dp)
      .clip(RoundedCornerShape(12.dp))
      .background(
        Brush.verticalGradient(
          colors = listOf(Color(0xFFE0F2FE), Color(0xFFF0FDF4))
        )
      )
  ) {
    // Vector Drawing of the Geographic Boundary
    Canvas(
      modifier = Modifier
        .fillMaxSize()
        .pointerInput(exercise.pins) {
          detectTapGestures { offset ->
            val w = size.width
            val h = size.height
            // Find closest pin within 30dp threshold
            val closest = exercise.pins.minByOrNull { pin ->
              val pinX = pin.normalizedX * w
              val pinY = pin.normalizedY * h
              val dx = offset.x - pinX
              val dy = offset.y - pinY
              dx * dx + dy * dy
            }
            if (closest != null) {
              onPinClick(closest.id)
            }
          }
        }
    ) {
      val w = size.width
      val h = size.height

      if (exercise.mapType == HistoryMapType.INDIA_ASIA || exercise.mapType == HistoryMapType.WORLD_CIVILIZATIONS) {
        // Draw Continental Silhouette
        val continentPath = Path().apply {
          moveTo(w * 0.15f, h * 0.20f)
          lineTo(w * 0.40f, h * 0.15f)
          lineTo(w * 0.75f, h * 0.20f)
          lineTo(w * 0.85f, h * 0.45f)
          lineTo(w * 0.65f, h * 0.70f)
          lineTo(w * 0.50f, h * 0.85f)
          lineTo(w * 0.35f, h * 0.70f)
          lineTo(w * 0.20f, h * 0.50f)
          close()
        }
        drawPath(
          path = continentPath,
          color = Color(0xFFFEF3C7)
        )
        drawPath(
          path = continentPath,
          color = Color(0xFFD97706),
          style = Stroke(width = 2f)
        )
      } else {
        // Accurate Sri Lanka Teardrop Island Silhouette
        val islandPath = Path().apply {
          // Point Pedro / North
          moveTo(w * 0.42f, h * 0.08f)
          // Jaffna Peninsula Curves
          cubicTo(w * 0.35f, h * 0.10f, w * 0.26f, h * 0.22f, w * 0.28f, h * 0.32f) // Mannar / Northwest Coast
          cubicTo(w * 0.25f, h * 0.45f, w * 0.28f, h * 0.62f, w * 0.32f, h * 0.75f) // Colombo / Southwest Coast
          cubicTo(w * 0.35f, h * 0.85f, w * 0.48f, h * 0.92f, w * 0.55f, h * 0.90f) // Galle / Dondra Head / South
          cubicTo(w * 0.68f, h * 0.85f, w * 0.78f, h * 0.65f, w * 0.75f, h * 0.48f) // East Coast / Batticaloa
          cubicTo(w * 0.72f, h * 0.30f, w * 0.60f, h * 0.18f, w * 0.42f, h * 0.08f) // Trincomalee & Northeast Coast
          close()
        }

        // Fill Landmass
        drawPath(
          path = islandPath,
          color = Color(0xFFFEF3C7)
        )
        // Draw Coastline Border
        drawPath(
          path = islandPath,
          color = Color(0xFF059669),
          style = Stroke(width = 3f)
        )

        // Draw Central Highlands Relief Shadow
        val centralHighlands = Path().apply {
          moveTo(w * 0.45f, h * 0.55f)
          cubicTo(w * 0.42f, h * 0.62f, w * 0.52f, h * 0.70f, w * 0.55f, h * 0.62f)
          cubicTo(w * 0.58f, h * 0.55f, w * 0.48f, h * 0.52f, w * 0.45f, h * 0.55f)
          close()
        }
        drawPath(
          path = centralHighlands,
          color = Color(0xFFD97706).copy(alpha = 0.35f)
        )

        // Draw Mahaweli River Path
        val mahaweliPath = Path().apply {
          moveTo(w * 0.48f, h * 0.60f) // Near Kandy
          cubicTo(w * 0.58f, h * 0.52f, w * 0.62f, h * 0.42f, w * 0.72f, h * 0.31f) // Out into Trincomalee Bay
        }
        drawPath(
          path = mahaweliPath,
          color = Color(0xFF0284C7),
          style = Stroke(width = 3f)
        )

        // Draw Malwathu Oya Path
        val malwathuPath = Path().apply {
          moveTo(w * 0.46f, h * 0.36f) // Near Anuradhapura
          lineTo(w * 0.28f, h * 0.23f) // Into Mannar Bay
        }
        drawPath(
          path = malwathuPath,
          color = Color(0xFF0284C7),
          style = Stroke(width = 2.5f)
        )

        // Draw Kelani River Path
        val kelaniPath = Path().apply {
          moveTo(w * 0.46f, h * 0.66f)
          lineTo(w * 0.32f, h * 0.70f)
        }
        drawPath(
          path = kelaniPath,
          color = Color(0xFF0284C7),
          style = Stroke(width = 2f)
        )
      }
    }

    // Overlay Interactive Pin Buttons
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
      val canvasWidth = maxWidth
      val canvasHeight = maxHeight

      exercise.pins.forEach { pin ->
        val isPinSelected = pin.id == selectedPinId
        val result = verificationResults[pin.id]

        val pinColor = when {
          isSubmitted && result?.isCorrect == true -> Color(0xFF16A34A)
          isSubmitted && result?.isCorrect == false -> Color(0xFFDC2626)
          isPinSelected -> Color(0xFFEA580C)
          else -> Color(0xFF0284C7)
        }

        Box(
          modifier = Modifier
            .offset(
              x = canvasWidth * pin.normalizedX - 14.dp,
              y = canvasHeight * pin.normalizedY - 14.dp
            )
            .size(28.dp)
            .clip(CircleShape)
            .background(pinColor)
            .clickable { onPinClick(pin.id) }
            .testTag("pin_btn_${pin.pinNumber}"),
          contentAlignment = Alignment.Center
        ) {
          Text(
            text = "${pin.pinNumber}",
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
          )
        }
      }
    }

    // Watermark Legend
    Surface(
      color = Color.White.copy(alpha = 0.85f),
      shape = RoundedCornerShape(6.dp),
      modifier = Modifier
        .align(Alignment.BottomStart)
        .padding(8.dp)
    ) {
      Row(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text("🔵 ස්ථාන අංක", fontSize = 10.sp, color = Color(0xFF0F172A), fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(6.dp))
        Text("🌊 ගංගා සහ මෝය", fontSize = 10.sp, color = Color(0xFF0284C7))
      }
    }
  }
}

// ==============================================================================
// 100% ACCURATE MAP MARKING RULES & STUDY GUIDE DIALOG
// ==============================================================================

@Composable
fun HistoryMapRulesDialog(onDismiss: () -> Unit) {
  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false)
  ) {
    Surface(
      shape = RoundedCornerShape(20.dp),
      color = Color.White,
      modifier = Modifier
        .fillMaxWidth(0.92f)
        .fillMaxHeight(0.85f)
    ) {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(20.dp)
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text("📐", fontSize = 22.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "සිතියම් ලකුණු කිරීමේ 100% රීති",
              fontSize = 16.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF0F172A)
            )
          }

          IconButton(onClick = onDismiss) {
            Icon(Icons.Default.Close, contentDescription = "Close", tint = Color(0xFF64748B))
          }
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 10.dp), color = Color(0xFFE2E8F0))

        Column(
          modifier = Modifier
            .weight(1f)
            .verticalScroll(rememberScrollState()),
          verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
          RuleCardItem(
            number = "01",
            title = "තිත තැබීම සහ නම ලිවීම (Dot & Name Placement)",
            description = "අදාළ භූගෝලීය ස්ථානයේදීම පැහැදිලි තිතක් (•) තබා, ඊතලයක් මඟින් හෝ ඒ අසලින්ම ස්ථානයේ නම පැහැදිලිව සිංහලෙන් හෝ ඉංග්‍රීසියෙන් ලියන්න."
          )

          RuleCardItem(
            number = "02",
            title = "ගංගා සහ මෝය හඳුනාගැනීම (River Mouths)",
            description = "මල්වතු ඔය මෝය අසල මාන්තොට (මහාතිත්ථ), මහවැලි ගඟ මෝය අසල ගෝකණ්ණ (ත්‍රිකුණාමලය), වලවේ ගඟ මෝය අසල ගොඩවාය (ගෝඨපබ්බත) නිවැරදිව හඳුනාගන්න."
          )

          RuleCardItem(
            number = "03",
            title = "ප්‍රධාන අගනුවරවල් සහ රාජධානි (Kingdom Capitals)",
            description = "අනුරාධපුරය (උතුරු මැද තැන්න), පොළොන්නරුව (පරාක්‍රම සමුද්‍රය අසල), සීගිරිය (දඹුල්ලට ඊසාන), දඹදෙණිය (කුරුණෑගල දිස්ත්‍රික්කය), මහනුවර (මධ්‍යම කඳුකරය) ලකුණු කිරීමේදී අක්ෂාංශ/දේශාංශ සමතුලිතතාව පවත්වාගන්න."
          )

          RuleCardItem(
            number = "04",
            title = "ඉන්දියාව සහ ලෝක සිතියම් සලකුණු (India & World Maps)",
            description = "හරප්පා (උතුරු ඉන්දු නිම්නය/පන්ජාබය), මොහෙන්ජොදාරෝ (දකුණු ඉන්දු නිම්නය/සින්ද්), පාටලීපුත්‍ර (ගංගා නිම්නය), මෙසපොතේමියාව (යුප්‍රටීස්-ටයිග්‍රීස් ගංගා අතර) නිවැරදිව පෙන්වන්න."
          )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Button(
          onClick = onDismiss,
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
          shape = RoundedCornerShape(10.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Text("තේරුම් ගත්තා (Got It)", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }
      }
    }
  }
}

@Composable
fun RuleCardItem(
  number: String,
  title: String,
  description: String
) {
  Surface(
    color = Color(0xFFF8FAFC),
    shape = RoundedCornerShape(12.dp),
    border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
    modifier = Modifier.fillMaxWidth()
  ) {
    Row(
      modifier = Modifier.padding(12.dp),
      verticalAlignment = Alignment.Top
    ) {
      Surface(
        color = Color(0xFF0284C7),
        shape = CircleShape,
        modifier = Modifier.size(24.dp)
      ) {
        Box(contentAlignment = Alignment.Center) {
          Text(number, color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
        }
      }
      Spacer(modifier = Modifier.width(10.dp))
      Column {
        Text(title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0F172A))
        Spacer(modifier = Modifier.height(4.dp))
        Text(description, fontSize = 11.sp, color = Color(0xFF475569), lineHeight = 16.sp)
      }
    }
  }
}
