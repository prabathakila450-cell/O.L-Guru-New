package com.example

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

// ==============================================================================
// SYLLABUS DETECTION & OFFICIAL LESSON SEQUENCE DATA MODEL
// ශ්‍රී ලංකා විෂය නිර්දේශයේ පාඩම් ස්වයංක්‍රීයව හඳුනා ගැනීමේ දත්ත ආකෘතිය
// ==============================================================================

data class TableRowData(
  val column1: String,
  val column2: String,
  val column3: String = ""
)

data class ComparisonTable(
  val title: String,
  val header1: String,
  val header2: String,
  val header3: String = "",
  val rows: List<TableRowData>
)

data class MemoryTrick(
  val title: String,
  val mnemonicSentence: String, // උදා: "කාලා නාන මගෙ අලුත් සින්දුව..."
  val explanation: String,
  val appliesTo: String
)

data class UnitQuestion(
  val questionNumber: Int,
  val questionText: String,
  val type: String, // "MCQ", "SHORT", "STRUCTURED"
  val options: List<String> = emptyList(),
  val correctAnswer: String,
  val markingScheme: String,
  val marksAllocated: Int
)

data class AttachedGoogleDrivePdf(
  val id: String,
  val title: String,
  val driveUrl: String,
  val uploadDate: String = "2026-08-16",
  val fileSize: String = "1.8 MB",
  val type: String = "NOTE" // "NOTE" or "PAPER"
)

data class SyllabusUnitItem(
  val id: String,
  val grade: String, // "06", "07", "08", "09", "10", "11"
  val subject: String, // "විද්‍යාව", "ගණිතය", "ඉතිහාසය", etc.
  val unitNumber: String, // "01 වන පාඩම", "02 වන පාඩම", etc.
  val unitTitleSinhala: String,
  val unitTitleEnglish: String,
  val term: String, // "1 වන වාරය", "2 වන වාරය", "3 වන වාරය"
  val summaryNotes: List<String>,
  val comparisonTables: List<ComparisonTable>,
  val memoryTricks: List<MemoryTrick>,
  val practiceQuestions: List<UnitQuestion>,
  val defaultDrivePdfUrl: String = "https://drive.google.com/file/d/1zAddaGRd4loU0yxwWaMDi14G3rcFOvP4/preview",
  val attachedDrivePdfs: MutableList<AttachedGoogleDrivePdf> = mutableListOf()
) {
  /**
   * Returns attached PDFs with all duplicates strictly removed:
   * 1. Eliminates any attached PDF identical to the primary [defaultDrivePdfUrl].
   * 2. Eliminates any duplicate occurrences within [attachedDrivePdfs], keeping only 1 copy.
   * 3. Retains all distinct, non-duplicate notes and papers.
   */
  fun getDeduplicatedAttachedPdfs(): List<AttachedGoogleDrivePdf> {
    val defaultId = extractGoogleDriveFileId(defaultDrivePdfUrl)
    val seenFileIds = mutableSetOf<String>()
    if (defaultId.isNotBlank()) {
      seenFileIds.add(defaultId)
    }
    return attachedDrivePdfs.filter { pdf ->
      val fileId = extractGoogleDriveFileId(pdf.driveUrl)
      if (fileId.isNotBlank() && seenFileIds.contains(fileId)) {
        false // Duplicate short note PDF! Completely removed!
      } else {
        if (fileId.isNotBlank()) seenFileIds.add(fileId)
        true // Keep unique PDF
      }
    }
  }
}

// Helper to extract clean Google Drive File ID for precise deduplication
fun extractGoogleDriveFileId(url: String): String {
  val cleanUrl = url.trim()
  if (cleanUrl.isBlank()) return ""
  val filePattern = Regex("""drive\.google\.com/file/d/([a-zA-Z0-9_-]+)""")
  filePattern.find(cleanUrl)?.let { return it.groupValues[1] }
  val idPattern = Regex("""[?&]id=([a-zA-Z0-9_-]+)""")
  idPattern.find(cleanUrl)?.let { return it.groupValues[1] }
  return cleanUrl.substringBefore("/preview").substringAfterLast("/")
}

// Helper to convert any Google Drive URL into high-performance embeddable preview format
fun formatToGoogleDriveEmbedUrl(url: String): String {
  val cleanUrl = url.trim()
  if (cleanUrl.isBlank() || cleanUrl.contains("1sample_100page_notes")) return "https://drive.google.com/file/d/1V3y65z_15X6zjruQ_I11WhG4EOfDHGm-/preview"
  
  // Format 1: drive.google.com/file/d/{ID}/view...
  val filePattern = Regex("""drive\.google\.com/file/d/([a-zA-Z0-9_-]+)""")
  val match1 = filePattern.find(cleanUrl)
  if (match1 != null) {
    val fileId = match1.groupValues[1]
    if (fileId.contains("1sample_100page_notes") || fileId.contains("sample")) {
      return "https://drive.google.com/file/d/1V3y65z_15X6zjruQ_I11WhG4EOfDHGm-/preview"
    }
    return "https://drive.google.com/file/d/$fileId/preview"
  }

  // Format 2: drive.google.com/open?id={ID} or uc?id={ID}
  val idPattern = Regex("""[?&]id=([a-zA-Z0-9_-]+)""")
  val match2 = idPattern.find(cleanUrl)
  if (match2 != null) {
    val fileId = match2.groupValues[1]
    return "https://drive.google.com/file/d/$fileId/preview"
  }

  // If already preview or other URL, return as is
  return if (cleanUrl.startsWith("http")) cleanUrl else "https://$cleanUrl"
}

// ==============================================================================
// CURRICULUM SYLLABUS REPOSITORY (Grades 06 - 11 Official NIE Sequence)
// ==============================================================================

object SyllabusRepository {

  val allSyllabusUnits: MutableList<SyllabusUnitItem> = mutableListOf(
    // --------------------------------------------------------------------------
    // GRADE 10 & 11 - ORIENTAL MUSIC (සංගීතය කෙටි සටහන් 1)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g10_11_music_u1",
      grade = "11",
      subject = "සංගීතය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "10 ශ්‍රේණිය හා 11 ශ්‍රේණිය පෙරදිග සංගීතය කෙටි සටහන් 1",
      unitTitleEnglish = "Grade 10 & 11 Oriental Music Short Notes 1",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "රාග සංගීතය: බිලාවල්, කල්‍යාණ, ඛමාජ්, කාෆි, ආසාවරී, භෛරව, භෛරවි, භූපාලි, යමන් රාග පිළිබඳ මූලික හැඳින්වීම.",
        "තාල විස්තරය: ත්‍රිතාලය, ඛෙමට්ටා තාලය, දීප්චන්දී තාලය, දාද්රා තාලය සහ රූපාක් තාලය (මාත්‍ර, මාත්‍රා විභාග, තාළි, ඛාලි).",
        "ස්වර හා ශ්‍රැති: ශුද්ධ ස්වර 7, කෝමල ස්වර 4 (රෙ, ග, ධ, නි) සහ තීව්‍ර ස්වර 1 (ම). ශ්‍රැති 22 විභාජනය.",
        "ශ්‍රී ලංකාවේ දේශීය සංගීතය, ජන ගී (නෙලුම් කවි, පැල් කවි, කරත්ත කවි) සහ නූර්ති/නාදගම් ගී.",
        "වාද්‍ය භාණ්ඩ වර්ගීකරණය: තත, සුසිර, ඝන, අවනද්ධ භාණ්ඩ."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ප්‍රධාන රාග ලක්ෂණ සංසන්දනය",
          header1 = "රාගය (Raga)",
          header2 = "ථාටය / වාදී-සංවාදී",
          header3 = "විශේෂ ස්වර / ගායන වේලාව",
          rows = listOf(
            TableRowData("භූපාලි (Bhupali)", "කල්‍යාණ / ග - ධ", "ඖඩව-ඖඩව (ම, නි වර්ජිත) • රාත්‍රී 1 වන ප්‍රහරය"),
            TableRowData("යමන් (Yaman)", "කල්‍යාණ / ග - නි", "සම්පූර්ණ (තීව්‍ර මධ්‍යම) • රාත්‍රී 1 වන ප්‍රහරය"),
            TableRowData("ඛමාජ් (Khamaj)", "ඛමාජ් / ග - නි", "ශාඩව-සම්පූර්ණ (ආරෝහණයේ රෙ වර්ජිත, කෝමල නි) • රාත්‍රී 2 වන ප්‍රහරය")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "භූපාලි රාගයේ ස්වර මතක තබා ගැනීම",
          mnemonicSentence = "ස රෙ ග ප ධ ස' (ම, නි නෑ!)",
          explanation = "භූපාලි රාගයේ ම සහ නි ස්වර නොයෙදෙන බැවින් එය ඖඩව-ඖඩව ජාතියට අයත් වේ.",
          appliesTo = "පෙරදිග සංගීතය - රාග අධ්‍යයනය"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "භූපාලි රාගයේ වර්ජිත (නොයෙදෙන) ස්වර යුගලය කුමක්ද?",
          type = "MCQ",
          options = listOf("1. රෙ, ධ", "2. ග, නි", "3. ම, නි", "4. රෙ, ප"),
          correctAnswer = "3. ම, නි",
          markingScheme = "භූපාලි රාගයේ ආරෝහණයේ සහ අවරෝහණයේ ම සහ නි ස්වර වර්ජිත වේ. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1BYhGyyvqcVfQP7YYgWynzV_oZ0coLjbL/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "music_g10_11_pdf_1",
          title = "10 හා 11 ශ්‍රේණිය පෙරදිග සංගීතය කෙටි සටහන් 1 (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/16z-qVWM6nwPErhsYoT5L0WOL3-jsEoDv/preview",
          uploadDate = "2026-08-17",
          fileSize = "2.4 MB",
          type = "NOTE"
        ),
        AttachedGoogleDrivePdf(
          id = "music_g10_11_pdf_2",
          title = "10 හා 11 ශ්‍රේණිය පෙරදිග සංගීතය කෙටි සටහන් සංග්‍රහය (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1BYhGyyvqcVfQP7YYgWynzV_oZ0coLjbL/preview",
          uploadDate = "2026-08-17",
          fileSize = "2.8 MB",
          type = "NOTE"
        )
      )
    ),
    // --------------------------------------------------------------------------
    // GRADE 06-11 - ENGLISH LANGUAGE & GRAMMAR (06-11 ශ්‍රේණි ඉංග්‍රීසි කෙටි සටහන්)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g06_11_english_u1",
      grade = "11",
      subject = "ඉංග්‍රීසි",
      unitNumber = "Grammar & Writing",
      unitTitleSinhala = "06-11 ශ්‍රේණි ඉංග්‍රීසි ව්‍යාකරණ, Tenses හා Writing කෙටි සටහන්",
      unitTitleEnglish = "Grades 06-11 English Grammar, Tenses, Prepositions & Essay Writing",
      term = "සියලු වාර",
      summaryNotes = listOf(
        "Parts of Speech: Nouns, Pronouns, Verbs, Adjectives, Adverbs, Prepositions, Conjunctions, Interjections.",
        "Tenses (කාල 12): Simple Present, Present Continuous, Present Perfect, Simple Past, Past Continuous, Past Perfect, Simple Future ආශ්‍රිත Active/Passive Voice නීති.",
        "Direct and Indirect Speech: ප්‍රකාශන වාක්‍ය, ප්‍රශ්නාර්ථ වාක්‍ය සහ ආඥා/ඉල්ලීම් වාක්‍ය අනියම් ප්‍රකාශනයට පරිවර්තනය කිරීමේ නීති.",
        "Prepositions & Conjunctions: in, on, at, by, with, although, despite, because of, in order to නිවැරදි භාවිතය.",
        "Writing & Composition: Formal/Informal Letters, Graphs/Pie-charts Description, Notices, Notes, and Articles ලියන ආකාරය සහ ලකුණු ලැබෙන ආකෘති (Format)."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "Active Voice vs Passive Voice සාරාංශය",
          header1 = "Tense",
          header2 = "Active Voice Form",
          header3 = "Passive Voice Form (be + V3)",
          rows = listOf(
            TableRowData("Simple Present", "V1 (writes / write)", "am/is/are + written"),
            TableRowData("Present Continuous", "is/are + writing", "is/are + being + written"),
            TableRowData("Simple Past", "V2 (wrote)", "was/were + written"),
            TableRowData("Present Perfect", "has/have + written", "has/have + been + written"),
            TableRowData("Simple Future", "will + write", "will + be + written")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "Prepositions of Time (AT, ON, IN) මතක තබා ගැනීම",
          mnemonicSentence = "AT for Time (වේලාව) • ON for Days (දින) • IN for Months/Years (මාස/වර්ෂ)!",
          explanation = "at 5.00 PM | on Monday, on 15th August | in July, in 2026.",
          appliesTo = "Prepositions of Time"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "Fill in the blank with the correct preposition: 'The national examination will commence _____ 8.30 a.m. _____ Monday.'",
          type = "MCQ",
          options = listOf("1. in / at", "2. at / on", "3. on / in", "4. by / at"),
          correctAnswer = "2. at / on",
          markingScheme = "Time of clock takes 'at' (at 8.30 a.m.) and days of the week take 'on' (on Monday). (2 Marks)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/155eu00n0_0IdrKc0wiWDqcwkqLa08ndI/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "eng_g06_11_pdf_1",
          title = "06-11 ශ්‍රේණි ඉංග්‍රීසි පූර්ණ කෙටි සටහන් (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/155eu00n0_0IdrKc0wiWDqcwkqLa08ndI/preview",
          uploadDate = "2026-08-18",
          fileSize = "4.2 MB",
          type = "NOTE"
        )
      )
    ),
    // --------------------------------------------------------------------------
    // GRADE 10 & 11 - HISTORY TABLES (10 හා 11 ශ්‍රේණි ඉතිහාසය වගු කෙටි සටහන්)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g10_11_hist_tables_u1",
      grade = "11",
      subject = "ඉතිහාසය",
      unitNumber = "වගු සටහන්",
      unitTitleSinhala = "10 හා 11 ශ්‍රේණි ඉතිහාසය පූර්ණ වගු කෙටි සටහන්",
      unitTitleEnglish = "Grades 10 & 11 History Comprehensive Table Notes",
      term = "සියලු වාර",
      summaryNotes = listOf(
        "ඓතිහාසික මූලාශ්‍ර: සාහිත්‍ය මූලාශ්‍ර (දීපවංශය, මහාවංශය, පූජාවලිය) සහ පුරාවිද්‍යාත්මක මූලාශ්‍ර (සෙල්ලිපි, කාසි, නටබුන්).",
        "ලංකා රාජධානි අනුපිළිවෙල හා පාලකයින්: අනුරාධපුර, පොළොන්නරුව, දඹදෙණිය, යාපහුව, කුරුණෑගල, ගම්පොළ, කෝට්ටේ, සීතාවක, මහනුවර යුගයන්හි ප්‍රධාන රජවරුන් සහ ඔවුන්ගේ සේවාවන්.",
        "යුරෝපීය ආක්‍රමණ සහ ප්‍රතිසංස්කරණ: පෘතුගීසි, ලන්දේසි සහ ඉංග්‍රීසි පාලන සමයන් (කෝල්බෲක්, ක්‍රෲ-මැකලම්, ඩොනමෝර්, සෝල්බරි ආණ්ඩුක්‍රම).",
        "ලෝක ඉතිහාස සංධිස්ථාන: කාර්මික විප්ලවය, පුනරුදය, ප්‍රංශ විප්ලවය සහ පළමු හා දෙවන ලෝක යුද්ධ පිළිබඳ සාරාංශ වගු."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ශ්‍රී ලංකාවේ බ්‍රිතාන්‍ය ආණ්ඩුක්‍රම ප්‍රතිසංස්කරණ සංසන්දනය",
          header1 = "ප්‍රතිසංස්කරණය (Reform)",
          header2 = "වර්ෂය (Year)",
          header3 = "ප්‍රධාන ලක්ෂණ / වැදගත්කම",
          rows = listOf(
            TableRowData("කෝල්බෲක්-කැමරන්", "1833", "රාජකාරි ක්‍රමය අහෝසි කිරීම, පළාත් 5 කට බෙදීම, විධායක හා ව්‍යවස්ථාදායක සභා පිහිටුවීම"),
            TableRowData("ක්‍රෲ-මැකලම්", "1910", "උගත් ලාංකිකයන්ට ඡන්ද බලය ලබාදීම (සීමිත නියෝජනය)"),
            TableRowData("ඩොනමෝර්", "1931", "සර්වජන ඡන්ද බලය ලබාදීම, විධායක කාරක සභා ක්‍රමය, රාජ්‍ය මන්ත්‍රණ සභාව"),
            TableRowData("සෝල්බරි", "1947", "පාර්ලිමේන්තු ආණ්ඩුක්‍රමය (නියෝජිත මන්ත්‍රී මණ්ඩලය හා සෙනෙට් සභාව)")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "ආණ්ඩුක්‍රම ප්‍රතිසංස්කරණ අනුපිළිවෙල මතක තබා ගැනීම",
          mnemonicSentence = "කෝල් කළ ක්‍රෲ ඩොනමෝර් සෝල්බරිට!",
          explanation = "කෝල්බෲක් (1833) → ක්‍රෲ-මැකලම් (1910) → ඩොනමෝර් (1931) → සෝල්බරි (1947).",
          appliesTo = "බ්‍රිතාන්‍ය ආණ්ඩුක්‍රම ප්‍රතිසංස්කරණ"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "ශ්‍රී ලංකාවේ වයස අවුරුදු 21 ට වැඩි සියලුම පුරවැසියන්ට සර්වජන ඡන්ද බලය හිමි වූයේ කුමන ආණ්ඩුක්‍රම ප්‍රතිසංස්කරණය යටතේද?",
          type = "MCQ",
          options = listOf("1. කෝල්බෲක් ප්‍රතිසංස්කරණය", "2. ක්‍රෲ-මැකලම් ප්‍රතිසංස්කරණය", "3. ඩොනමෝර් ප්‍රතිසංස්කරණය", "4. සෝල්බරි ප්‍රතිසංස්කරණය"),
          correctAnswer = "3. ඩොනමෝර් ප්‍රතිසංස්කරණය",
          markingScheme = "1931 ඩොනමෝර් ආණ්ඩුක්‍රම ප්‍රතිසංස්කරණය මඟින් ආසියාවේ ප්‍රථම වරට ශ්‍රී ලංකාවට සර්වජන ඡන්ද බලය හිමි විය. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/13ctYgSQ0jefoMGg3cpJg2t74h0jIZyx7/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "hist_tables_pdf_1",
          title = "10 හා 11 ශ්‍රේණිය ඉතිහාසය වගු කෙටි සටහන් (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/13ctYgSQ0jefoMGg3cpJg2t74h0jIZyx7/preview",
          uploadDate = "2026-08-18",
          fileSize = "3.8 MB",
          type = "NOTE"
        )
      )
    ),
    // --------------------------------------------------------------------------
    // GRADE 10 - HISTORY (10 ශ්‍රේණිය ඉතිහාසය කෙටි සටහන්)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g10_hist_u1",
      grade = "10",
      subject = "ඉතිහාසය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "10 ශ්‍රේණිය ඉතිහාසය පූර්ණ කෙටි සටහන් හා මූලාශ්‍ර",
      unitTitleEnglish = "Grade 10 History Comprehensive Short Notes & Sources",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "ඉතිහාසය හැදෑරීමේ මූලාශ්‍ර: සාහිත්‍ය මූලාශ්‍ර (දීපවංශය, මහාවංශය, රාජාවලිය) සහ පුරාවිද්‍යා මූලාශ්‍ර (සෙල්ලිපි, කාසි, නටබුන්).",
        "ශ්‍රී ලංකාවේ ප්‍රාග් ඓතිහාසික හා පූර්ව ඓතිහාසික යුගය: පාහියංගල, බටදොඹලෙන, ඉබ්බන්කටුව සුසාන භූමිය සහ බලංගොඩ මානවයා.",
        "අනුරාධපුර රාජධානියේ ආරම්භය හා විකාශනය: පණ්ඩුකාභය, දේවානම්පියතිස්ස, දුටුගැමුණු, වළගම්බා සහ ධාතුසේන රජවරුන්ගේ දේශපාලන හා ආගමික මෙහෙවර.",
        "පුරාණ වාරි ශිෂ්ටාචාරය සහ කෘෂිකර්මාන්තය: ඇළ මාර්ග, වැව්, බිසෝකොටුව සහ රළපනාව තාක්ෂණය.",
        "ලෝක ඉතිහාසය: මුල්කාලීන නදී නිම්න ශිෂ්ටාචාර (මෙයසපොතේමියාව, මිසරය, ඉන්දු නිම්නය, හොවැංහෝ)."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ඉතිහාස මූලාශ්‍ර වර්ගීකරණය සංසන්දනය",
          header1 = "මූලාශ්‍ර වර්ගය",
          header2 = "උදාහරණ (Examples)",
          header3 = "විශ්වසනීයත්වය / විශේෂත්වය",
          rows = listOf(
            TableRowData("සාහිත්‍ය මූලාශ්‍ර (දේශීය)", "දීපවංශය, මහාවංශය, ථූපවංශය, පූජාවලිය", "කතුවරයාගේ දෘෂ්ටිකෝණය බලපෑ හැක"),
            TableRowData("සාහිත්‍ය මූලාශ්‍ර (විදේශීය)", "පාහියන්, ඉබන් බතුතා, ටොලමිගේ සටහන්", "විදේශීය නිරීක්ෂකයන්ගේ වාර්තා"),
            TableRowData("පුරාවිද්‍යාත්මක මූලාශ්‍ර", "සෙල්ලිපි (බ්‍රාහ්මී), කාසි, කැටයම්, නටබුන්", "කාල නිර්ණය නිවැරදිව කළ හැකි ප්‍රාථමික මූලාශ්‍ර")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "ඓතිහාසික වැවේ ප්‍රධාන කොටස් 4 මතක තබා ගැනීම",
          mnemonicSentence = "වැව් බැම්මෙන් වතුර රඳවා - බිසෝකොටුවෙන් පීඩනය පාලනය කර - සොරොව්වෙන් බෙදා - පිටවානෙන් පිටකරයි!",
          explanation = "වැව් බැම්ම, බිසෝකොටුව (පීඩන පාලනය), සොරොව්ව (ජලය නිකුත් කිරීම), පිටවාන (අතිරික්ත ජලය පිටකිරීම).",
          appliesTo = "පුරාණ වාරි තාක්ෂණය"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "පුරාණ වාරි ඉංජිනේරු විද්‍යාවේදී ගැඹුරු වැව්වල අධික ජල පීඩනය පාලනය කිරීම සඳහා යොදාගත් විශිෂ්ටතම සිංහල නිර්මාණය කුමක්ද?",
          type = "MCQ",
          options = listOf("1. පිටවාන", "2. බිසෝකොටුව", "3. රළපනාව", "4. ඇළහැර ඇළ"),
          correctAnswer = "2. බිසෝකොටුව",
          markingScheme = "බිසෝකොටුව යනු ගැඹුරු වැව්වල ජල පීඩනය පාලනය කර සොරොව්ව ආරක්ෂා කරමින් ජලය පිටකිරීමට නිර්මාණය කළ විශිෂ්ට උපාංගයකි. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1Ry6utaFim_tZl8OkTG5hoD6oB4RB8Uxl/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "hist_g10_pdf_1",
          title = "10 ශ්‍රේණිය ඉතිහාසය කෙටි සටහන් (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1Ry6utaFim_tZl8OkTG5hoD6oB4RB8Uxl/preview",
          uploadDate = "2026-08-18",
          fileSize = "3.6 MB",
          type = "NOTE"
        )
      )
    ),
    // --------------------------------------------------------------------------
    // GRADE 06-11 - HISTORY MAPS (06/07/08/09/10/11 ශ්‍රේණි ඉතිහාසය සිතියම් ලකුණු කිරීම)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g11_hist_maps_u1",
      grade = "11",
      subject = "ඉතිහාසය",
      unitNumber = "සිතියම්",
      unitTitleSinhala = "06-11 ශ්‍රේණි ඉතිහාසය ලංකා හා ලෝක සිතියම් ලකුණු කිරීම",
      unitTitleEnglish = "Grades 06-11 History Sri Lanka & World Map Marking Guide",
      term = "සියලු වාර",
      summaryNotes = listOf(
        "ශ්‍රී ලංකා සිතියම: ප්‍රධාන ඓතිහාසික රාජධානි (අනුරාධපුරය, පොළොන්නරුව, දඹදෙණිය, යාපහුව, කුරුණෑගල, ගම්පොළ, කෝට්ටේ, සීතාවක, මහනුවර).",
        "ප්‍රධාන වාරිමාර්ග හා ජලාශ: පරාක්‍රම සමුද්‍රය, මින්නේරිය, කලා වැව, කාන්තලේ, නුවර වැව, තිසා වැව, යෝධ ඇළ සහ ඇළහැර ඇළ.",
        "ඓතිහාසික වරායන් හා වෙළඳ මධ්‍යස්ථාන: මාතොට (මහාතිත්ථ), ගෝකණ්ණ (ත්‍රිකුණාමලය), ජම්බුකෝලපට්ටන (දඹකොළපටුන), ගාලු වරාය, මන්නාරම.",
        "පුරාවිද්‍යාත්මක හා ආගමික ස්ථාන: සීගිරිය, මිහින්තලය, රංගිරි දඹුල්ල, දිඹුලාගල, තන්තිරිමලේ, මුතියංගනය, කතරගම, නගදීපය.",
        "ලෝක සිතියම (Grade 10/11 O/L): පැරණි ශිෂ්ටාචාර මධ්‍යස්ථාන (මෙයසපොතේමියාව, මිසරය, ඉන්දු නිම්නය, චීන ශිෂ්ටාචාරය), සේද මාවත සහ ප්‍රධාන සමුද්‍ර සන්ධි."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ප්‍රධාන ඓතිහාසික වාරි කර්මාන්ත හා නිර්මාතෘ රජවරු",
          header1 = "වාරි කර්මාන්තය (Reservoir/Canal)",
          header2 = "නිර්මාණය කළ රජතුමා (King)",
          header3 = "පිහිටි ප්‍රදේශය / වැදගත්කම",
          rows = listOf(
            TableRowData("මින්නේරිය වැව / ඇළහැර ඇළ", "මහසෙන් රජතුමා", "පොළොන්නරුව / රජරට ගොවිතැන"),
            TableRowData("කලා වැව / ජය ගඟ (යෝධ ඇළ)", "ධාතුසේන රජතුමා", "අනුරාධපුරයට ජලය සැපයීම (සැතපුමකට අඟල් 6 ක බැස්ම)"),
            TableRowData("පරාක්‍රම සමුද්‍රය", "මහා පරාක්‍රමබාහු රජතුමා", "පොළොන්නරුව (තෝපා, දුඹුටුලු, එරබදු වැව් එක්කර)")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "ප්‍රධාන වරායන් 3 සිතියමේ පිහිටීම මතක තබා ගැනීම",
          mnemonicSentence = "උතුරට දඹකොළ - වයඹට මාතොට - නැගෙනහිරට ගෝකණ්ණ!",
          explanation = "දඹකොළපටුන = උතුරු අර්ධද්වීපය, මාතොට = මන්නාරම/වයඹ වෙරළ, ගෝකණ්ණ = ත්‍රිකුණාමලය/නැගෙනහිර.",
          appliesTo = "ඉතිහාස සිතියම් ලකුණු කිරීම"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "අනුරාධපුර යුගයේ ප්‍රධානතම ජාත්‍යන්තර වෙළඳ වරාය වූයේ කුමක්ද?",
          type = "MCQ",
          options = listOf("1. ගෝකණ්ණ වරාය", "2. මහාතිත්ථ (මාතොට) වරාය", "3. ජම්බුකෝලපට්ටන", "4. ගාලු වරාය"),
          correctAnswer = "2. මහාතිත්ථ (මාතොට) වරාය",
          markingScheme = "මහාතිත්ථ (වර්තමාන මන්නාරම මාතොට) අනුරාධපුර යුගයේ ප්‍රධාන ජාත්‍යන්තර වෙළඳ වරාය විය. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1BVguuBjT1_iQVO296Zn4Dek2AOahBFsp/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "hist_maps_pdf_1",
          title = "06/07/08/09/10/11 ශ්‍රේණි ඉතිහාසය සිතියම් (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1BVguuBjT1_iQVO296Zn4Dek2AOahBFsp/preview",
          uploadDate = "2026-08-18",
          fileSize = "4.5 MB",
          type = "NOTE"
        )
      )
    ),
    // --------------------------------------------------------------------------
    // GRADE 10/11 - SINHALA LITERATURE (10/11 ශ්‍රේණි සිංහල සාහිත්‍යය කෙටි සටහන්)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g11_sin_lit_u1",
      grade = "11",
      subject = "සිංහල",
      unitNumber = "සාහිත්‍යය",
      unitTitleSinhala = "10/11 ශ්‍රේණි සිංහල සාහිත්‍යය පූර්ණ කෙටි සටහන්",
      unitTitleEnglish = "Grades 10 & 11 Sinhala Literature Comprehensive Notes",
      term = "සියලු වාර",
      summaryNotes = listOf(
        "පද්‍ය සාහිත්‍යය: සම්භාව්‍ය කාව්‍ය (කව්සිළුමිණ, ගුත්තිලය, කාව්‍යශේඛරය, සැලලිහිණි සන්දේශය), ජනකවි සහ නූතන නිසඳැස් කාව්‍ය විචාර.",
        "ගද්‍ය සාහිත්‍යය: අමාවතුර, බුත්සරණ, පූජාවලිය, සද්ධර්මරත්නාවලිය ආශ්‍රිත භාෂා රටා, ආඛ්‍යාන ශෛලිය සහ චරිත නිරූපණය.",
        "නාට්‍ය කලාව සහ කෙටිකතා: සාහිත්‍ය නිර්මාණවල ව්‍යංගාර්ථ, උපමා, රූපක, ධ්වනි රසය සහ සමාජ විවරණය.",
        "සාහිත්‍ය විචාර ක්‍රමවේදය: ප්‍රශ්නවලට පිළිතුරු ලිවීමේදී කාව්‍ය/ගද්‍ය පාඨ උපුටා දැක්වීම සහ තාර්කිකව කරුණු ගොඩනැගීම."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ගුරුළුගෝමී (අමාවතුර) vs ධර්මසේන හිමි (සද්ධර්මරත්නාවලිය) ශෛලිය",
          header1 = "ලක්ෂණය",
          header2 = "අමාවතුර (ගුරුළුගෝමී)",
          header3 = "සද්ධර්මරත්නාවලිය (ධර්මසේන හිමි)",
          rows = listOf(
            TableRowData("භාෂා විලාශය", "පෙරදිග ශුද්ධ සිංහල, ගාම්භීර හා සංක්ෂිප්ත", "ගැමි ව්‍යවහාරය, උපමා උපමේය බහුල රසවත් බස"),
            TableRowData("අරමුණ", "බුදුරජාණන් වහන්සේගේ පුරිසදම්මසාරථී ගුණය විදහා දැක්වීම", "ගිහි සමාජයට ධර්මය අවබෝධ කරවීම සහ උපදෙස් දීම")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "ගද්‍ය ග්‍රන්ථ හා කතුවරුන් මතක තබා ගැනීම",
          mnemonicSentence = "ගුරුගේ අමාවතුරෙන් - විදුහලේ බුත්සරණින් - මයූරපාද පූජාවෙන් - ධර්මසේන රත්නාවලියෙන්!",
          explanation = "ගුරුළුගෝමී = අමාවතුර, විද්‍යාචක්‍රවර්තී = බුත්සරණ, මයුරපාද පරිවේණාධිපති = පූජාවලිය, ධර්මසේන හිමි = සද්ධර්මරත්නාවලිය.",
          appliesTo = "සිංහල සාහිත්‍යය"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "අමාවතුර ග්‍රන්ථය රචනා කර ඇත්තේ බුදුරදුන්ගේ කුමන බුදු ගුණය විස්තර කිරීම සඳහාද?",
          type = "MCQ",
          options = listOf("1. අරහං ගුණය", "2. පුරිසදම්මසාරථී ගුණය", "3. විජ්ජාචරණසම්පන්න ගුණය", "4. සුගත ගුණය"),
          correctAnswer = "2. පුරිසදම්මසාරථී ගුණය",
          markingScheme = "ගුරුළුගෝමී පඬිවරයා විසින් අමාවතුර රචනා කරන ලද්දේ බුදුරජාණන් වහන්සේගේ 'පුරිසදම්මසාරථී' ගුණය විස්තර කිරීමටයි. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/17jFpMgfgojJgdAT0K4Ja9dfDocoBAnsl/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "sin_lit_pdf_1",
          title = "10/11 ශ්‍රේණි සිංහල සාහිත්‍යය කෙටි සටහන් (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/17jFpMgfgojJgdAT0K4Ja9dfDocoBAnsl/preview",
          uploadDate = "2026-08-18",
          fileSize = "3.9 MB",
          type = "NOTE"
        )
      )
    ),
    // --------------------------------------------------------------------------
    // GRADE 10 - SINHALA LITERATURE (10 ශ්‍රේණිය සිංහල සාහිත්‍යය කෙටි සටහන්)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g10_sin_lit_u1",
      grade = "10",
      subject = "සිංහල",
      unitNumber = "සාහිත්‍යය",
      unitTitleSinhala = "10 ශ්‍රේණිය සිංහල සාහිත්‍යය පූර්ණ කෙටි සටහන් හා විචාර සංග්‍රහය",
      unitTitleEnglish = "Grade 10 Sinhala Literature Short Notes & Appreciation",
      term = "සියලු වාර",
      summaryNotes = listOf(
        "01. සතර කන් මන්ත්‍රණය (කුරුණෑගල අවධිය - පන්සිය පනස් ජාතක පොත / උම්මග්ග ජාතකය): 14 වන සියවසේ IV වන පණ්ඩිත පරාක්‍රමබාහු රජ දවස වීරසිංහ ප්‍රතිරාජ ඇමති අනුග්‍රහයෙන් පාලි ජාතකට්ඨ කතාවෙන් සිංහලට නැගීම (ජාතක කතා 547 කි). මහෞෂධ පණ්ඩිතයන්ගේ ප්‍රඥා මහිමය, කේවට්ට බමුණාගේ කූට උපාය සහ නාට්‍යානුරූපී දෙබස්.",
        "02. ගුත්තිල වෙණ නද (කෝට්ටේ අවධිය - වෑත්තෑවේ හිමි): පද්‍ය 511 කින් යුත් ගුත්තිල කාව්‍යය. සිරි පැරකුම්බා රජුගේ සළාවත ජයපාල ඇමතිගේ ආරාධනයෙන් රචිතය. ගුත්තිල-මූසිල වීණා වාදන තරගය, ශබ්ද ධ්වනිය, උපමා සහ සුරඟන නැටුම් විස්තරය.",
        "03. හානා හීය පානා අඬහැරෙන් දැනේ (අනුරාධපුර යුගය ආශ්‍රිත ජනකවි / උපදේශ කවි): කතුවරයෙකු නැති මුඛ පරම්පරාගත නිර්මාණ. කෘෂිකාර්මික, පතල්, ගැල්, නෙළුම්, පැල් කවි සහ ජීවිතයට මඟපෙන්වන ප්‍රායෝගික උපදේශ.",
        "04. බැද්දේගම (නූතන යුගය - ලෙනාඩ් වුල්ෆ් / පරිවර්තනය ඒ. පී. ගුණරත්න): 1913 දී 'The Village in the Jungle' නමින් රචිත නවකතාව. හම්බන්තොට දුප්පත් ගැමි ජනතාවගේ දුක්ඛිත ජීවිතය, සිලිඳු සහ පුංචිමැණිකාගේ චරිත.",
        "05. මුනි සිරිපා සිඹිමින්නේ (නූතන යුගය / කොළඹ යුගය - එස්. මහින්ද හිමි): ටිබෙට් ජාතික එස්. මහින්ද හිමියන්ගේ 'ජාතික තොටිල්ල' කාව්‍ය පන්තිය. දේශානුරාගය, ජාතිකාභිමානය සහ නිදහස් අරගලයට ජනතාව අවදි කිරීම.",
        "06. ගංගාවේ සංගීතය (කොළඹ යුගය - එච්. එම්. කුඩලිගම): සොබාදහමේ අසිරිය, කඳු මුදුනින් ආරම්භ වී සාගරය බලා ගලායන ගංගාවක නාද මාධුර්යය හා ජීවිතයේ අනිත්‍ය ධර්මතාවය.",
        "07. ලෙන අතහැර යෑම (නූතන යුගය - මහාචාර්ය එදිරිවීර සරච්චන්ද්‍ර - සිංහබාහු නාට්‍යයේ දෙවන අංකය): 1961 පේරාදෙණියේදී ප්‍රථම රංගගත වීම. සිංහබාහු සහ සුප්පාදේවිය ලෙන අතහැර මිනිස් ලොවට පැමිණීම, පීතෘ සෙනෙහස සහ නිදහස අතර ගැටුම."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "10 ශ්‍රේණිය නිර්දේශිත කෘති, කතුවරුන් සහ යුග සංසන්දනය",
          header1 = "කෘතිය / නිර්මාණය",
          header2 = "කතුවරයා",
          header3 = "ලියවුණු කාලය / යුගය",
          rows = listOf(
            TableRowData("01. පන්සිය පනස් ජාතක පොත (උම්මග්ග ජාතකය)", "අඥාතයි", "කුරුණෑගල අවධිය"),
            TableRowData("02. ගුත්තිල කාව්‍යය", "වෑත්තෑවේ හිමි", "කෝට්ටේ අවධිය"),
            TableRowData("03. ජනකවි (හානා හීය පානා අඬහැරෙන් දැනේ)", "අඥාතයි (මුඛ පරම්පරාගත)", "අනුරාධපුර යුගය දක්වා දිවයයි"),
            TableRowData("04. බැද්දේගම (09 පරිච්ඡේදය)", "ලෙනාඩ් වුල්ෆ් (පරිවර්තනය: ඒ. පී. ගුණරත්න)", "නූතන අවධිය"),
            TableRowData("05. ජාතික තොටිල්ල (මුනි සිරිපා සිඹිමින්නේ)", "ටිබෙට් ජාතික එස්. මහින්ද හිමි", "කොළඹ / නූතන අවධිය"),
            TableRowData("06. ගංගාවේ සංගීතය", "එච්. එම්. කුඩලිගම", "කොළඹ / නූතන අවධිය"),
            TableRowData("07. සිංහබාහු (දෙවන අංකය)", "මහාචාර්ය එදිරිවීර සරච්චන්ද්‍ර", "නූතන අවධිය")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "10 ශ්‍රේණිය සාහිත්‍ය නිර්මාණ කතුවරුන් මතක තබා ගැනීම",
          mnemonicSentence = "උම්මග්ගේ කුරුණෑගලින් • වෑත්තෑවේ ගුත්තිලයෙන් • වුල්ෆ්ගේ බැද්දේගමින් • මහින්ද හිමි තොටිල්ලෙන් • කුඩලිගම ගංගාවෙන් • සරච්චන්ද්‍ර සිංහබාහුවෙන්!",
          explanation = "උම්මග්ග (කුරුණෑගල), ගුත්තිලය (වෑත්තෑවේ හිමි), බැද්දේගම (ලෙනාඩ් වුල්ෆ්), ජාතික තොටිල්ල (එස්. මහින්ද හිමි), ගංගාවේ සංගීතය (එච්. එම්. කුඩලිගම), සිංහබාහු (එදිරිවීර සරච්චන්ද්‍ර).",
          appliesTo = "10 ශ්‍රේණිය සිංහල සාහිත්‍ය නිර්මාණ"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "පන්සිය පනස් ජාතක පොත සිංහලට පරිවර්තනය කරන ලද්දේ කුමන යුගයේ කාගේ අනුග්‍රහයෙන්ද?",
          type = "MCQ",
          options = listOf("1. කෝට්ටේ යුගයේ - වීදාගම හිමි", "2. කුරුණෑගල යුගයේ - වීරසිංහ ප්‍රතිරාජ ඇමති", "3. පොළොන්නරු යුගයේ - පරාක්‍රමබාහු රජ", "4. දඹදෙණි යුගයේ - දේවපතිරාජ ඇමති"),
          correctAnswer = "2. කුරුණෑගල යුගයේ - වීරසිංහ ප්‍රතිරාජ ඇමති",
          markingScheme = "14 වන සියවසේ කුරුණෑගල IV වන පරාක්‍රමබාහු රජ දවස වීරසිංහ ප්‍රතිරාජ ඇමතිගේ අනුග්‍රහයෙන් සිංහලට නැගිණි. (ලකුණු 2)",
          marksAllocated = 2
        ),
        UnitQuestion(
          questionNumber = 2,
          questionText = "ගුත්තිල කාව්‍යය රචනා කරන ලද්දේ කුමන හිමිනම විසින්ද? එහි අඩංගු මුළු පද්‍ය සංඛ්‍යාව කොපමණද?",
          type = "SHORT",
          correctAnswer = "වෑත්තෑවේ හිමි, පද්‍ය 511 කි",
          markingScheme = "කතුවරයා: වෑත්තෑවේ හිමි, මුළු පද්‍ය සංඛ්‍යාව: 511 කි. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/17jFpMgfgojJgdAT0K4Ja9dfDocoBAnsl/preview",
      attachedDrivePdfs = mutableListOf()
    ),
    // --------------------------------------------------------------------------
    // GRADE 06-11 - SINHALA GRAMMAR (06-11 ශ්‍රේණි සිංහල ව්‍යාකරණ කෙටි සටහන්)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g11_sin_grammar_u1",
      grade = "11",
      subject = "සිංහල",
      unitNumber = "ව්‍යාකරණ",
      unitTitleSinhala = "06-11 ශ්‍රේණි සිංහල ව්‍යාකරණ පූර්ණ කෙටි සටහන්",
      unitTitleEnglish = "Grades 06-11 Sinhala Grammar Comprehensive Notes",
      term = "සියලු වාර",
      summaryNotes = listOf(
        "සිංහල හෝඩිය: ස්වර, ව්‍යංජන, ශුද්ධ සිංහල හෝඩිය (අක්ෂර 32) සහ මිශ්‍ර සිංහල හෝඩිය (අක්ෂර 54 / 60).",
        "නාම පද හා ක්‍රියා පද: නාම පද ප්‍රභේද (ද්‍රව්‍ය, ගුණ, ක්‍රියා, සමූහ, ආවෘති), ආඛ්‍යාතය සහ උක්ත-ආඛ්‍යාත පද සම්බන්ධය.",
        "විභක්ති: ප්‍රථමා, කර්ම, කර්තෘ, කරණ, සම්ප්‍රදාන, අවධි, සම්බන්ධ, ආධාර සහ ආලපන විභක්ති.",
        "සන්ධි හා සමාස: ස්වර සන්ධි, ව්‍යංජන සන්ධි, පූර්ව-පර රූප සන්ධි සහ තත්පුරුෂ, කර්මධාරය, ද්වන්ද, ද්විගු සමාස.",
        "ණ-න, ළ-ල, ශ-ෂ-ස අක්ෂර වින්‍යාස නීති සහ විරාම ලක්ෂණ නිවැරදිව භාවිතය."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ශුද්ධ සිංහල හෝඩිය vs මිශ්‍ර සිංහල හෝඩිය",
          header1 = "ලක්ෂණය",
          header2 = "ශුද්ධ සිංහල හෝඩිය",
          header3 = "මිශ්‍ර සිංහල හෝඩිය",
          rows = listOf(
            TableRowData("අක්ෂර ගණන", "අක්ෂර 32 කි (ස්වර 12, ව්‍යංජන 20)", "අක්ෂර 54 හෝ 60 (මහප්‍රාණ, මූර්ධජ ආදිය සහිතයි)"),
            TableRowData("භාවිතය", "හෙළ බසට පමණක් ගැළපෙන පද ලිවීමට", "පාලි, සංස්කෘත සහ විදේශීය තත්සම පද ලිවීමට")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "උක්ත ආඛ්‍යාත පද සම්බන්ධය මතක තබා ගැනීම",
          mnemonicSentence = "උක්තය ඒකවචන නම් ක්‍රියාවත් ඒකවචන • උක්තය බහුවචන නම් ක්‍රියාවත් බහුවචන!",
          explanation = "පුරුෂය (ප්‍රථම, මධ්‍යම, උත්තම) සහ වචනය (ඒක, බහු) අනුව ආඛ්‍යාතය වෙනස් වේ.",
          appliesTo = "සිංහල ව්‍යාකරණ"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "මිශ්‍ර සිංහල හෝඩියේ සම්මත අක්ෂර ගණන කොපමණද?",
          type = "MCQ",
          options = listOf("1. 32 කි", "2. 54 කි", "3. 20 කි", "4. 12 කි"),
          correctAnswer = "2. 54 කි",
          markingScheme = "සම්මත මිශ්‍ර සිංහල හෝඩියේ අක්ෂර 54 ක් අඩංගු වේ. (නූතන හෝඩියේ ඇ, ඈ, ඓ, ඖ ඇතුළත්ව 60 කි). (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1XB8up4GLB9mvcavvtVsbOaAZAO1027tc/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "sin_grammar_pdf_1",
          title = "06/07/08/09/10/11 ශ්‍රේණි සිංහල ව්‍යාකරණ කෙටි සටහන් (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1XB8up4GLB9mvcavvtVsbOaAZAO1027tc/preview",
          uploadDate = "2026-08-18",
          fileSize = "4.1 MB",
          type = "NOTE"
        )
      )
    ),
    // --------------------------------------------------------------------------
    // GRADE 11 - GEOGRAPHY (11 වසර භූගෝල විද්‍යාව කෙටි සටහන්)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g11_geo_u1",
      grade = "11",
      subject = "භූගෝල විද්‍යාව",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "11 ශ්‍රේණිය භූගෝල විද්‍යාව පූර්ණ කෙටි සටහන්",
      unitTitleEnglish = "Grade 11 Geography Comprehensive Short Notes",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "ලෝකයේ භෞතික ලක්ෂණ හා භූ තැටි චලන: භූ තැටි මායිම් (අපසාරී, අභිසාරී, පරිවර්තන), භූමිකම්පා සහ ගිනි කඳු ව්‍යාප්තිය.",
        "ලෝක දේශගුණ කලාප: සමක, නිවර්තන, සෞම්‍ය සහ ධ්‍රැවාසන්න කලාපවල ලක්ෂණ හා වෘක්ෂලතා.",
        "සිතියම් කියවීම සහ පරිමාණ: 1:50,000 භූලක්ෂණ සිතියම්, සමෝච්ච රේඛා ආශ්‍රයෙන් භූරූප හඳුනාගැනීම (කඳු වැටි, බෑවුම්, සානු, නිම්න).",
        "මානව ක්‍රියාකාරකම් හා පරිසර අර්බුද: ගෝලීය උණුසුම ඉහළ යාම, කාන්තාරීකරණය, වන විනාශය සහ තිරසාර සංවර්ධන සංකල්පය.",
        "ලෝක ජනාවාස සහ සංවර්ධන ප්‍රවණතා: නාගරීකරණය, සංක්‍රමණ සහ ජනගහන වර්ධනය."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ප්‍රධාන භූ තැටි මායිම් 3 සංසන්දනය",
          header1 = "මායිම් වර්ගය (Boundary)",
          header2 = "චලන ස්වභාවය (Movement)",
          header3 = "නිර්මාණය වන භූරූප / උදාහරණ",
          rows = listOf(
            TableRowData("අපසාරී (Divergent)", "තැටි දෙකක් එකිනෙකින් ඈත්වීම", "මැද අත්ලාන්තික් සාගර වැටිය, පැලුම් නිම්න"),
            TableRowData("අභිසාරී (Convergent)", "තැටි දෙකක් එකිනෙක ගැටීම", "හිමාලය වැනි නැමි කඳුවැටි, අගාධ"),
            TableRowData("පරිවර්තන (Transform)", "තැටි දෙකක් එකිනෙක පිරිමදිමින් ලිස්සා යාම", "සැන් ඇන්ඩ්‍රියාස් විභේදය (භූමිකම්පා බහුලයි)")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "භූ තැටි මායිම් 3 මතක තබා ගැනීම",
          mnemonicSentence = "ඈත් වුණොත් අපසාරී • හැප්පුණොත් අභිසාරී • ලිස්සුවොත් පරිවර්තන!",
          explanation = "අපසාරී (ඈත්වීම) | අභිසාරී (හැප්පීම/එකතු වීම) | පරිවර්තන (ලිස්සා යාම).",
          appliesTo = "භූ තැටි චලන"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "හිමාලය කඳුවැටිය නිර්මාණය වී ඇත්තේ කුමන ආකාරයේ භූ තැටි මායිමක් ආශ්‍රිතවද?",
          type = "MCQ",
          options = listOf("1. අපසාරී මායිමක", "2. අභිසාරී මායිමක", "3. පරිවර්තන මායිමක", "4. නිෂ්ක්‍රීය මායිමක"),
          correctAnswer = "2. අභිසාරී මායිමක",
          markingScheme = "ඉන්දු-ඕස්ට්‍රේලියානු තැටිය සහ යුරේසියානු තැටිය එකිනෙක ගැටෙන (අභිසාරී) මායිම ආශ්‍රිතව හිමාලය කඳුවැටිය නිර්මාණය වී ඇත. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1dfKR5Cb8ZAE07E_3ddeYc1EDfXWOALHO/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "geo_g11_pdf_1",
          title = "11 ශ්‍රේණිය භූගෝල විද්‍යාව කෙටි සටහන් (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1dfKR5Cb8ZAE07E_3ddeYc1EDfXWOALHO/preview",
          uploadDate = "2026-08-17",
          fileSize = "3.2 MB",
          type = "NOTE"
        )
      )
    ),
    // --------------------------------------------------------------------------
    // GRADE 11 - GEOGRAPHY (11 වසර භූගෝල විද්‍යාව කෙටි සටහන්)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g11_geo_u1",
      grade = "11",
      subject = "භූගෝල විද්‍යාව",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "11 ශ්‍රේණිය භූගෝල විද්‍යාව පූර්ණ කෙටි සටහන්",
      unitTitleEnglish = "Grade 11 Geography Comprehensive Short Notes",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "ලෝකයේ සහ ශ්‍රී ලංකාවේ භෞතික ලක්ෂණ, දේශගුණික කලාප හා ස්වභාවික වෘක්ෂලතාදිය.",
        "සිතියම් කියවීම සහ අර්ථකථනය: සමෝච්ච රේඛා ලක්ෂණ, පරිමාණය, දිශානතිය සහ සංකේත භාවිතය.",
        "මානව සම්පත් සහ සංවර්ධනය: ජනගහන වර්ධනය, ව්‍යාප්තිය, ඝනත්වය සහ සංක්‍රමණ රටා.",
        "ප්‍රධාන ආර්ථික කටයුතු: කෘෂිකර්මාන්තය (වී, තේ, රබර්, පොල්), ධීවර කර්මාන්තය, ඛනිජ සම්පත් සහ සංචාරක කර්මාන්තය.",
        "පාරිසරික ගැටලු සහ ආපදා කළමනාකරණය: ගංවතුර, නායයෑම්, නියඟය සහ තිරසාර සංවර්ධන සංකල්පය."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ශ්‍රී ලංකාවේ ප්‍රධාන දේශගුණික කලාප 3 සංසන්දනය",
          header1 = "කලාපය (Zone)",
          header2 = "වාර්ෂික වර්ෂාපතනය",
          header3 = "ප්‍රධාන වෘක්ෂලතා / ආවේණික ලක්ෂණ",
          rows = listOf(
            TableRowData("තෙත් කලාපය (Wet Zone)", "මි.මී. 2500 ට වැඩි", "නිවර්තන වැසි වනාන්තර (සිංහරාජය)"),
            TableRowData("අන්තර් කලාපය (Intermediate Zone)", "මි.මී. 1750 - 2500", "තෙත් සහ වියළි ලක්ෂණ මුසු වනාන්තර"),
            TableRowData("වියළි කලාපය (Dry Zone)", "මි.මී. 1750 ට අඩු", "වියළි මිශ්‍ර සදාහරිත වනාන්තර, කටු පඳුරු")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "ශ්‍රී ලංකාවේ දේශගුණික කලාප වර්ෂාපතනය මතක තබා ගැනීම",
          mnemonicSentence = "තෙතට 2500+ • මැදට 1750-2500 • වියළිව 1750-!",
          explanation = "තෙත් කලාපය (>2500mm), අන්තර් කලාපය (1750-2500mm), වියළි කලාපය (<1750mm).",
          appliesTo = "දේශගුණික කලාප"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "ශ්‍රී ලංකාවේ තෙත් කලාපය ලෙස නිර්ණය කෙරෙන වාර්ෂික අවම වර්ෂාපතන සීමාව කුමක්ද?",
          type = "MCQ",
          options = listOf("1. මි.මී. 1500", "2. මි.මී. 1750", "3. මි.මී. 2500", "4. මි.මී. 3000"),
          correctAnswer = "3. මි.මී. 2500",
          markingScheme = "වාර්ෂික වර්ෂාපතනය මි.මී. 2500 ට වඩා වැඩි ප්‍රදේශ තෙත් කලාපය ලෙස ගැනේ. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1FDQuZVWHUTxdVFaO6Xoi0CjhCYiTr4ih/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "geo_g11_pdf_custom",
          title = "11 ශ්‍රේණිය භූගෝල විද්‍යාව කෙටි සටහන් සංග්‍රහය (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1FDQuZVWHUTxdVFaO6Xoi0CjhCYiTr4ih/preview",
          uploadDate = "2026-08-25",
          fileSize = "3.5 MB",
          type = "NOTE"
        )
      )
    ),
    // --------------------------------------------------------------------------
    // GRADE 10 - GEOGRAPHY (10 වසර භූගෝල විද්‍යාව කෙටි සටහන්)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g10_geo_u1",
      grade = "10",
      subject = "භූගෝල විද්‍යාව",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "10 ශ්‍රේණිය භූගෝල විද්‍යාව පූර්ණ කෙටි සටහන්",
      unitTitleEnglish = "Grade 10 Geography Comprehensive Short Notes",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "ශ්‍රී ලංකාවේ භෞතික පිහිටීම: අක්ෂාංශ හා දේශාංශ පිහිටීම, දූපත් ස්වභාවය සහ උපායමාර්ගික වැදගත්කම.",
        "ශ්‍රී ලංකාවේ භූරූප හා උන්නතාංශ කලාප: වෙරළබඩ තැන්න, අභ්‍යන්තර තැනිබිම, මධ්‍යම කඳුකරය (ප්‍රධාන කඳු මුදුන් සහ සානුවල ලක්ෂණ).",
        "දේශගුණය සහ කාලගුණය: නිරිතදිග මෝසම, ඊසානදිග මෝසම, අන්තර් මෝසම් සුළං සහ සංවහන වැසි.",
        "ශ්‍රී ලංකාවේ ප්‍රධාන ගංගා පද්ධතිය සහ ජලාපවහන රටාව: මධ්‍යම කඳුකරයෙන් ආරම්භ වී අරීය රටාවකට ගලා යාම (මහවැලි, කැලණි, කළු, වලවේ).",
        "ස්වභාවික සම්පත් සහ ජනගහන ව්‍යාප්තිය: ඛනිජ, පාංශු වර්ග, වනාන්තර සහ කෘෂිකාර්මික භාවිතය."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ප්‍රධාන මෝසම් සුළං 2 සංසන්දනය",
          header1 = "මෝසම් සුළඟ (Monsoon)",
          header2 = "කාලසීමාව (Period)",
          header3 = "වැසි ලැබෙන ප්‍රදේශ",
          rows = listOf(
            TableRowData("නිරිතදිග මෝසම (SW)", "මැයි සිට සැප්තැම්බර් දක්වා", "තෙත් කලාපය, බස්නාහිර සහ නිරිතදිග බෑවුම්"),
            TableRowData("ඊසානදිග මෝසම (NE)", "දෙසැම්බර් සිට පෙබරවාරි දක්වා", "වියළි කලාපය, උතුරු සහ නැගෙනහිර ප්‍රදේශ")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "මෝසම් සුළං කාල සීමා මතක තබා ගැනීම",
          mnemonicSentence = "නිරිතට මැයි-සැප් • ඊසානට දෙසැ-පෙබ!",
          explanation = "නිරිතදිග මෝසම (මැයි - සැප්තැම්බර්) | ඊසානදිග මෝසම (දෙසැම්බර් - පෙබරවාරි).",
          appliesTo = "ශ්‍රී ලංකාවේ දේශගුණය"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "ශ්‍රී ලංකාවේ දිගම ගංගාව කුමක්ද? එය ආරම්භ වන ස්ථානය කුමක්ද?",
          type = "MCQ",
          options = listOf("1. කළු ගඟ (ශ්‍රී පාද අඩවිය)", "2. මහවැලි ගඟ (ශ්‍රී පාද කඳුවැටිය / හෝර්ටන් තැන්න)", "3. කැලණි ගඟ (කැළණිය)", "4. වලවේ ගඟ (ඇඩම්ස් පීක්)"),
          correctAnswer = "2. මහවැලි ගඟ (ශ්‍රී පාද කඳුවැටිය / හෝර්ටන් තැන්න)",
          markingScheme = "මහවැලි ගඟ ශ්‍රී ලංකාවේ දිගම ගංගාව වන අතර එහි දිග කි.මී. 335 කි. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1uKVJN3GsKephOV9In73EBW7R1bSSe47Z/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "geo_g10_pdf_1",
          title = "10 ශ්‍රේණිය භූගෝල විද්‍යාව කෙටි සටහන් (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1uKVJN3GsKephOV9In73EBW7R1bSSe47Z/preview",
          uploadDate = "2026-08-17",
          fileSize = "2.9 MB",
          type = "NOTE"
        )
      )
    ),
    // --------------------------------------------------------------------------
    // GRADE 11 - BUDDHISM (11 වසර බුද්ධ ධර්මය කෙටි සටහන්)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g11_bud_u1",
      grade = "11",
      subject = "බුද්ධ ධර්මය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "11 ශ්‍රේණිය බුද්ධ ධර්මය පූර්ණ කෙටි සටහන්",
      unitTitleEnglish = "Grade 11 Buddhism Comprehensive Short Notes",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "බුදුරදුන්ගේ ශ්‍රේෂ්ඨ ශ්‍රාවක චරිත: සැරියුත්, මුගලන්, ආනන්ද, කාශ්‍යප, අනුරුද්ධ මහ රහතන් වහන්සේලාගේ චරිතාදර්ශ.",
        "බෞද්ධ දර්ශනය සහ මූලික ධර්ම කරුණු: ත්‍රිලක්ෂණය (අනිච්ච, දුක්ඛ, අනත්ත), පටිච්ච සමුප්පාදය, කර්මය සහ පුනර්භවය.",
        "බෞද්ධ සංස්කෘතිය හා සාරධර්ම: දස පුණ්‍ය ක්‍රියා, දස පාරමිතා, සතර බ්‍රහ්ම විහරණ (මෙත්තා, කරුණා, මුදිතා, උපෙක්ඛා).",
        "ලක්දිව ශාසන පුනරුදය සහ ප්‍රධාන ඓතිහාසික සිදුවීම්: ත්‍රිපිටකය ග්‍රන්ථාරූඪ කිරීම (මාතලේ අලුවිහාරය), වැලිවිට අසරණ සරණ සරණංකර සංඝරාජ මාහිමිගේ ශාසන සේවය.",
        "නූතන සමාජ ගැටලු හා බෞද්ධ විසඳුම්: ආර්ථික සංවර්ධනය, පාරිසරික සුරක්ෂිතතාව සහ මානසික ආතතිය දුරුකර ගැනීම."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "සතර බ්‍රහ්ම විහරණ සංසන්දනය",
          header1 = "බ්‍රහ්ම විහරණය",
          header2 = "අර්ථය",
          header3 = "ප්‍රතිවිරුද්ධ සතුරා / අවදානම",
          rows = listOf(
            TableRowData("මෙත්තා (Loving-kindness)", "සියලු සත්ත්වයන්ට හිතසුව පැතීම", "ව්‍යාපාදය / ද්වේෂය"),
            TableRowData("කරුණා (Compassion)", "දුකට පත් සතුන්ගේ දුක නිවීමට වෙහෙසීම", "හිංසාව / කෲරත්වය"),
            TableRowData("මුදිතා (Sympathetic Joy)", "අනුන්ගේ දියුණුවේදී සතුටු වීම", "ඊර්ෂ්‍යාව / අමනාපය"),
            TableRowData("උපෙක්ඛා (Equanimity)", "මැදහත් සිතින් උපේක්ෂාවෙන් බැලීම", "රාගය / ඇලීම හා ගැටීම")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "සතර බ්‍රහ්ම විහරණ මතක තබා ගැනීම",
          mnemonicSentence = "හිතසුව පතා (මෙත්) • දුක නිවා (කරුණා) • සතුටු වී (මුදිතා) • මැදහත්ව බලමු (උපෙක්ඛා)!",
          explanation = "මෙත්තා, කරුණා, මුදිතා, උපෙක්ඛා යනු සතර බ්‍රහ්ම විහරණයි.",
          appliesTo = "සතර බ්‍රහ්ම විහරණ"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "අනුන්ගේ සැපතේදී සහ දියුණුවේදී සතුටු වීම බුදුදහමේ හඳුන්වන්නේ කුමන නමකින්ද?",
          type = "MCQ",
          options = listOf("1. මෙත්තා", "2. කරුණා", "3. මුදිතා", "4. උපෙක්ඛා"),
          correctAnswer = "3. මුදිතා",
          markingScheme = "අනුන්ගේ සැපතේදී ඊර්ෂ්‍යා නොකර සතුටුවීම මුදිතාව නම් වේ. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1-nnUx_HXnFQYOnMajoMAeDjf7lgW5MLP/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "bud_g11_pdf_custom",
          title = "11 ශ්‍රේණිය බුද්ධ ධර්මය කෙටි සටහන් සංග්‍රහය (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1-nnUx_HXnFQYOnMajoMAeDjf7lgW5MLP/preview",
          uploadDate = "2026-08-25",
          fileSize = "3.2 MB",
          type = "NOTE"
        )
      )
    ),
    // --------------------------------------------------------------------------
    // GRADE 10 - BUDDHISM (10 වසර බුද්ධ ධර්මය කෙටි සටහන්)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g10_bud_u1",
      grade = "10",
      subject = "බුද්ධ ධර්මය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "10 ශ්‍රේණිය බුද්ධ ධර්මය පූර්ණ කෙටි සටහන්",
      unitTitleEnglish = "Grade 10 Buddhism Comprehensive Short Notes",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "සම්බුද්ධ චරිතය හා බුද්ධ ඥාන: සර්වඥතා ඥානය, ආසවානක්ඛය ඥානය, දසබලධාරී ඥාන.",
        "චතුරාර්ය සත්‍යය: දුක්ඛ, සමුදය, නිරෝධ, මාර්ග (ආර්ය අෂ්ටාංගික මාර්ගය).",
        "බෞද්ධ සදාචාරය සහ ගිහි සමාජ ජීවිතය: සිඟාලෝවාද සූත්‍රය, මංගල සූත්‍රය, පරාභව සූත්‍රය සහ ව්‍යග්ඝපජ්ජ සූත්‍රය.",
        "ශාසන ඉතිහාසය: තෙවන ධර්ම සංගායනාව, මිහිඳු මහ රහතන් වහන්සේගේ ලංකාගමනය, ශ්‍රී මහා බෝධීන් වහන්සේ වැඩමවීම.",
        "ප්‍රධාන බෞද්ධ සිද්ධස්ථාන, සෑගිරි හා අනුරාධපුර පූජනීය නටබුන් සහ සංස්කෘතික උරුමය."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ආර්ය අෂ්ටාංගික මාර්ගයේ ත්‍රිශික්ෂා විභාජනය",
          header1 = "ශික්ෂාව (Training)",
          header2 = "අන්තර්ගත අංග (Path Factor)",
          header3 = "ප්‍රධාන අරමුණ",
          rows = listOf(
            TableRowData("ප්‍රඥා ශික්ෂාව (Wisdom)", "සම්මා දිට්ඨි, සම්මා සංකප්ප", "යථාර්ථාවබෝධය හා නිවැරදි දැක්ම"),
            TableRowData("ශීල ශික්ෂාව (Morality)", "සම්මා වාචා, සම්මා කම්මන්ත, සම්මා ආජීව", "කය හා වචනයේ සංවරභාවය"),
            TableRowData("සමාධි ශික්ෂාව (Concentration)", "සම්මා වායාම, සම්මා සති, සම්මා සමාධි", "සිතේ එකඟතාව හා මානසික ශාන්තිය")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "ත්‍රිශික්ෂාවට අෂ්ටාංගික මාර්ගය බෙදීම",
          mnemonicSentence = "ප්‍රඥාවෙන් දැක සිතුවා (දිට්ඨි, සංකප්ප) • ශීලයෙන් කීවා කළා ජීවත්වුණා (වාචා, කම්මන්ත, ආජීව) • සමාධියෙන් වෙහෙසුණා සිහි කළා තැන්පත් වුණා (වායාම, සති, සමාධි)!",
          explanation = "ප්‍රඥා (2) + ශීල (3) + සමාධි (3) = අංග 8.",
          appliesTo = "ආර්ය අෂ්ටාංගික මාර්ගය"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "ආර්ය අෂ්ටාංගික මාර්ගයේ ප්‍රඥා ශික්ෂාවට අයත් අංග 2 මොනවාද?",
          type = "MCQ",
          options = listOf("1. සම්මා වාචා, සම්මා කම්මන්ත", "2. සම්මා දිට්ඨි, සම්මා සංකප්ප", "3. සම්මා වායාම, සම්මා සති", "4. සම්මා ආජීව, සම්මා සමාධි"),
          correctAnswer = "2. සම්මා දිට්ඨි, සම්මා සංකප්ප",
          markingScheme = "ප්‍රඥා ශික්ෂාවට අයත් වන්නේ සම්මා දිට්ඨි (නිවැරදි දැක්ම) සහ සම්මා සංකප්ප (නිවැරදි කල්පනාව) වේ. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1G0IYc4uhn6vv1CccyHVwIyJptDrmIhl7/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "bud_g10_pdf_custom",
          title = "10 ශ්‍රේණිය බුද්ධ ධර්මය කෙටි සටහන් සංග්‍රහය (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1G0IYc4uhn6vv1CccyHVwIyJptDrmIhl7/preview",
          uploadDate = "2026-08-25",
          fileSize = "3.4 MB",
          type = "NOTE"
        ),
        AttachedGoogleDrivePdf(
          id = "bud_g10_pdf_1",
          title = "10 ශ්‍රේණිය බුද්ධ ධර්මය කෙටි සටහන් (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/17O97RA-IbgZnpKt9cVynjoNZ7y5SCE-Q/preview",
          uploadDate = "2026-08-17",
          fileSize = "2.6 MB",
          type = "NOTE"
        )
      )
    ),
    // --------------------------------------------------------------------------
    // GRADE 10 - HEALTH & PHYSICAL EDUCATION (10 වසර සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g10_health_u1",
      grade = "10",
      subject = "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "10 ශ්‍රේණිය සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය පූර්ණ කෙටි සටහන්",
      unitTitleEnglish = "Grade 10 Health & Physical Education Comprehensive Short Notes",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "සෞඛ්‍යය හා යහපැවැත්ම: ශාරීරික, මානසික, සමාජයීය හා ආධ්‍යාත්මික යහපැවැත්මේ සමබරතාව.",
        "පෝෂණය හා සමබල ආහාර වේල: ප්‍රධාන පෝෂක 6, ක්ෂුද්‍ර හා සාර්ව පෝෂක, පෝෂණ ඌනතා රෝග සහ ශරීර ස්කන්ධ දර්ශකය (BMI).",
        "ශාරීරික යෝග්‍යතාව සහ අභ්‍යාස: හෘද්-ශ්වසන දරාගැනීම, පේශි ශක්තිය, නම්‍යශීලීතාව සහ ශරීර සංයුතිය.",
        "ක්‍රීඩා සහ මලල ක්‍රීඩා කුසලතා: ධාවන, පැනීම්, විසිකිරීම් ඉසව්වල නිවැරදි ඉරියව් සහ නීති රීති.",
        "ප්‍රථමාධාර සහ අනතුරු වළක්වා ගැනීම: තුවාල, බිඳීම්, විෂවීම් සහ හදිසි අවස්ථාවලදී ක්‍රියා කළ යුතු ආකාරය (RICE ප්‍රතිකාරය)."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "සෞඛ්‍ය සම්පන්න ශාරීරික යෝග්‍යතා සංරචක",
          header1 = "යෝග්‍යතා සංරචකය",
          header2 = "අර්ථ දැක්වීම",
          header3 = "මනිනු ලබන පරීක්ෂණය / උදාහරණ",
          rows = listOf(
            TableRowData("හෘද්-ශ්වසන දරාගැනීම", "දිගු වේලාවක් වෙහෙස නොවී ක්‍රියාකාරකම් කිරීමේ හැකියාව", "මීටර් 1500 දිවීම / බීප් පරීක්ෂණය"),
            TableRowData("නම්‍යශීලීතාව", "සන්ධිවල පූර්ණ චලන පරාසයක් සහිතව නැමීමේ හැකියාව", "ඉඳගෙන ඉදිරියට නැමීමේ පරීක්ෂණය (Sit and Reach)"),
            TableRowData("පේශි ශක්තිය හා දරාගැනීම", "බාහිර ප්‍රතිරෝධයකට එරෙහිව බලය යෙදීමේ හැකියාව", "Push-ups / Sit-ups පරීක්ෂණය")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "මෘදු පටක තුවාල සඳහා RICE ප්‍රතිකාර ක්‍රමය",
          mnemonicSentence = "R (Rest - විවේකය) → I (Ice - අයිස් තැබීම) → C (Compression - තදකර වෙළීම) → E (Elevation - ඔසවා තැබීම)!",
          explanation = "උළුක්කු වීම් සහ පේශි ඉරීම් සඳහා ක්ෂණික ප්‍රථමාධාරය RICE වේ.",
          appliesTo = "ප්‍රථමාධාර ක්‍රමවේදය"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "ක්‍රීඩා අනතුරකදී සිදුවන උළුක්කු වීමකදී මුලින්ම ලබාදිය යුතු සම්මත ප්‍රථමාධාර ක්‍රමය කුමක්ද?",
          type = "MCQ",
          options = listOf("1. සම්බාහනය කිරීම", "2. RICE ක්‍රමය", "3. උණුසුම් වතුරෙන් තැවීම", "4. වහාම ඇවිද්දවීම"),
          correctAnswer = "2. RICE ක්‍රමය",
          markingScheme = "මෘදු පටක තුවාල සඳහා මුල් පැය 48 තුළ RICE (Rest, Ice, Compression, Elevation) ප්‍රතිකාරය ලබාදිය යුතුය. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1qEPI5g8KYCmX__5fzHSodtFoLUvj0BWi/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "health_g10_pdf_1",
          title = "10 ශ්‍රේණිය සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය කෙටි සටහන් (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1qEPI5g8KYCmX__5fzHSodtFoLUvj0BWi/preview",
          uploadDate = "2026-08-18",
          fileSize = "3.4 MB",
          type = "NOTE"
        )
      )
    ),
    // --------------------------------------------------------------------------
    // GRADE 11 - CIVIC EDUCATION (පුරවැසි අධ්‍යාපනය කෙටි සටහන්)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g11_civic_u1",
      grade = "11",
      subject = "පුරවැසි අධ්‍යාපනය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "11 ශ්‍රේණිය පුරවැසි අධ්‍යාපනය කෙටි සටහන්",
      unitTitleEnglish = "Grade 11 Civic Education Short Notes",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "ප්‍රජාතන්ත්‍රවාදී පාලන ක්‍රමය සහ පුරවැසි කාර්යභාරය.",
        "ශ්‍රී ලංකා ආණ්ඩුක්‍රම ව්‍යවස්ථාව, මූලික මිනිස් අයිතිවාසිකම් සහ යුතුකම්.",
        "රාජ්‍ය පාලනය: ව්‍යවස්ථාදායකය (පාර්ලිමේන්තුව), විධායකය (ජනාධිපති හා අමාත්‍ය මණ්ඩලය), අධිකරණය.",
        "යහපාලනය (Good Governance), විනිවිදභාවය සහ නීතියේ ආධිපත්‍යය.",
        "ජාත්‍යන්තර සබඳතා සහ එක්සත් ජාතීන්ගේ සංවිධානය (UN)."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "රාජ්‍යයේ ප්‍රධාන ආයතන 3 සංසන්දනය",
          header1 = "ආයතනය (Organ)",
          header2 = "ප්‍රධාන කාර්යය (Function)",
          header3 = "නියෝජිතයන් / ප්‍රධානියා",
          rows = listOf(
            TableRowData("ව්‍යවස්ථාදායකය", "නීති පැනවීම හා සම්මත කිරීම", "කථානායක / පාර්ලිමේන්තු මන්ත්‍රීවරු"),
            TableRowData("විධායකය", "නීති ක්‍රියාත්මක කිරීම හා පාලනය", "ජනාධිපති, අගමැති, අමාත්‍ය මණ්ඩලය"),
            TableRowData("අධිකරණය", "නීතිය අර්ථ නිරූපණය හා යුක්තිය පසිඳලීම", "අගවිනිසුරු සහ විනිසුරුවරු")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "රාජ්‍යයේ ආයතන 3 පහසුවෙන් මතක තබා ගැනීම",
          mnemonicSentence = "ව්‍යවස්ථා හැදුවා - විධායක පැදෙව්වා - අධිකරණ බෙදුවා!",
          explanation = "ව්‍යවස්ථාදායකය (නීති හදයි) → විධායකය (පාලනය ගෙනියයි) → අධිකරණය (යුක්තිය තීන්දු කරයි).",
          appliesTo = "ප්‍රජාතන්ත්‍රවාදී රාජ්‍ය ආයතන 3"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "ප්‍රජාතන්ත්‍රවාදී රාජ්‍යයක නීති පැනවීමේ බලය පැවරී ඇත්තේ කුමන ආයතනයටද?",
          type = "MCQ",
          options = listOf("1. විධායකයට", "2. ව්‍යවස්ථාදායකයට", "3. අධිකරණයට", "4. රාජ්‍ය සේවයට"),
          correctAnswer = "2. ව්‍යවස්ථාදායකයට",
          markingScheme = "නීති පැනවීම හා සම්මත කිරීම ව්‍යවස්ථාදායකයේ (පාර්ලිමේන්තුවේ) ප්‍රධාන වගකීම වේ. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1kuL7jmciw_ZKLK4JYz8WV1lbSeeWOf08/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "civic_g11_pdf_1",
          title = "11 ශ්‍රේණිය පුරවැසි අධ්‍යාපනය කෙටි සටහන් (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1kuL7jmciw_ZKLK4JYz8WV1lbSeeWOf08/preview",
          uploadDate = "2026-08-17",
          fileSize = "2.1 MB",
          type = "NOTE"
        )
      )
    ),
    // --------------------------------------------------------------------------
    // GRADE 11 - ORIENTAL MUSIC (11 වසර පෙරදිග සංගීතය කෙටි සටහන්)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g11_music_u1",
      grade = "11",
      subject = "සංගීතය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "11 ශ්‍රේණිය සංගීතය පූර්ණ කෙටි සටහන් හා රාග",
      unitTitleEnglish = "Grade 11 Oriental Music Comprehensive Short Notes",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "රාග හැඳින්වීම හා ලක්ෂණ: බිලාවල්, කල්‍යාණ, ඛමාජ්, කාෆි, භෛරව, භෛරවී, අසාවරී, තෝඩී, පූර්වී, මාරවා යන ථාට් දහය.",
        "රාගයක ප්‍රධාන අංග: ආරෝහණ, අවරෝහණ, වාදී ස්වරය, සංවාදී ස්වරය, අනුවාදී ස්වර, විවාදී ස්වර, පකඩ්, ගායන වේලාව.",
        "තාල හා මාත්‍රා ක්‍රම: ත්‍රීතාල (මාත්‍රා 16), ඒකතාල (මාත්‍රා 12), ජප්තාල (මාත්‍රා 10), රූපක් තාල (මාත්‍රා 7), කහර්වා තාල (මාත්‍රා 8), දාද්රා තාල (මාත්‍රා 6).",
        "දේශීය සංගීතය හා නූර්ති ගී, නාදගම් ගී, වන්නම් සහ ජන ගී (නෙළුම් කවි, පැල් කවි, පතල් කවි, කරත්ත කවි).",
        "ප්‍රවීණ සංගීතඥයන්: ආනන්ද සමරකෝන්, සුනිල් ශාන්ත, ඩබ්ලිව්. ඩී. අමරදේව, පණ්ඩිත් භාත්ඛණ්ඩේ සහ පණ්ඩිත් පලුස්කාර්."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "උතුරු ඉන්දීය රාග සංගීතයේ ප්‍රධාන අංග සංසන්දනය",
          header1 = "අංගය (Element)",
          header2 = "අර්ථ දැක්වීම",
          header3 = "උදාහරණ / වැදගත්කම",
          rows = listOf(
            TableRowData("වාදී ස්වරය (Vadi Swara)", "රාගයේ ප්‍රධානතම / රජු බඳු ස්වරය", "රාගයේ වැඩිපුරම භාවිත වන ස්වරය"),
            TableRowData("සංවාදී ස්වරය (Samvadi Swara)", "දෙවන ප්‍රධානතම / ඇමති බඳු ස්වරය", "වාදී ස්වරයට පසු වැදගත්ම ස්වරය"),
            TableRowData("පකඩ් (Pakad)", "රාගය හඳුනාගත හැකි සුවිශේෂී ස්වර රටාව", "රාගයේ අනන්‍යතාව කියාපායි"),
            TableRowData("ථාටය (Thaat)", "රාග ජනනය වන මූලික ස්වර සප්තකය", "භාත්ඛණ්ඩේ ක්‍රමයට ථාට් 10 කි")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "වාදී සහ සංවාදී ස්වර මතක තබා ගැනීම",
          mnemonicSentence = "වාදී රජිඳා - සංවාදී ඇමතින්දා!",
          explanation = "වාදී = රජු (ප්‍රධාන ස්වරය), සංවාදී = ඇමැති (දෙවන ප්‍රධාන ස්වරය).",
          appliesTo = "රාගයක ස්වර වැදගත්කම"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "රාගයක වඩාත්ම ප්‍රමුඛ වන, රජු ලෙස සලකන ස්වරය හඳුන්වන්නේ කෙසේද?",
          type = "MCQ",
          options = listOf("1. සංවාදී ස්වරය", "2. වාදී ස්වරය", "3. අනුවාදී ස්වරය", "4. විවාදී ස්වරය"),
          correctAnswer = "2. වාදී ස්වරය",
          markingScheme = "රාගයක ප්‍රධානතම ස්වරය වාදී ස්වරය වේ. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1CArgra4Xpgogue-KcwuVHFo_Bbk7sc9I/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "music_g11_pdf_custom",
          title = "11 ශ්‍රේණිය සංගීතය කෙටි සටහන් සංග්‍රහය (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1CArgra4Xpgogue-KcwuVHFo_Bbk7sc9I/preview",
          uploadDate = "2026-08-25",
          fileSize = "2.9 MB",
          type = "NOTE"
        )
      )
    ),
    // --------------------------------------------------------------------------
    // GRADE 11 & 10 - DANCING (නර්තනය කෙටි සටහන්)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g11_dance_u1",
      grade = "11",
      subject = "නර්තනය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "11 ශ්‍රේණිය නර්තනය පූර්ණ කෙටි සටහන් හා මූලධර්ම",
      unitTitleEnglish = "Grade 11 Traditional & Aesthetic Dancing",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "ශ්‍රී ලංකාවේ ප්‍රධාන සම්ප්‍රදායික නර්තන සම්ප්‍රදායන් 3: උඩරට නර්තනය, පහතරට නර්තනය, සබරගමු නර්තනය.",
        "උඩරට නර්තන සම්ප්‍රදායේ ප්‍රධාන බෙරය: ගැටබෙරය (ගෝෂකය). මූලික තාණ්ඩව ලක්ෂණ සහිතයි. ප්‍රධාන ශාන්තිකර්මය: කොහොඹා කංකාරිය.",
        "පහතරට නර්තන සම්ප්‍රදායේ ප්‍රධාන බෙරය: යක් බෙරය (දෙවොල් බෙරය). ලාස්‍ය සහ විකාර රූපී ලක්ෂණ සහිතයි. ප්‍රධාන ශාන්තිකර්ම: ගම්මඩුව, දෙවොල් මඩුව, සන්නි යකුම.",
        "සබරගමු නර්තන සම්ප්‍රදායේ ප්‍රධාන බෙරය: දවුල. ප්‍රධාන ශාන්තිකර්මය: මහසමන් දේවාල පෙරහැර සහ මඩු ශාන්තිකර්ම.",
        "නර්තනයේ මූලික අංග: නෘත්ත (තාලානුකූල චලන), නෘත්‍ය (භාව ප්‍රකාශන සහිත), නාට්‍ය (කතා පුවතක් නිරූපණය කරන)."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ශ්‍රී ලංකාවේ දේශීය නර්තන සම්ප්‍රදායන් 3 සංසන්දනය",
          header1 = "සම්ප්‍රදාය (Tradition)",
          header2 = "ප්‍රධාන බෙරය (Drum)",
          header3 = "ප්‍රධාන ශාන්තිකර්මය / ලක්ෂණ",
          rows = listOf(
            TableRowData("උඩරට (Upcountry)", "ගැටබෙරය", "කොහොඹා කංකාරිය / තාණ්ඩව ලක්ෂණ"),
            TableRowData("පහතරට (Lowcountry)", "යක් බෙරය / රුහුණු බෙරය", "දෙවොල් මඩුව, දහඅට සන්නිය"),
            TableRowData("සබරගමු (Sabaragamuwa)", "දවුල", "සමන් දේවාල පුද සිරිත් / ගම්මඩු")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "දේශීය නර්තන බෙර 3 මතක තබා ගැනීම",
          mnemonicSentence = "උඩට ගැටේ - පහළට යකා - සබරෙට දවුල!",
          explanation = "උඩරට = ගැටබෙරය, පහතරට = යක් බෙරය, සබරගමුව = දවුල.",
          appliesTo = "දේශීය නර්තන වාද්‍ය භාණ්ඩ"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "උඩරට නර්තන සම්ප්‍රදායේ මූලික ශාන්තිකර්මය කුමක්ද?",
          type = "MCQ",
          options = listOf("1. දෙවොල් මඩුව", "2. කොහොඹා කංකාරිය", "3. දහඅට සන්නිය", "4. ගම්මඩුව"),
          correctAnswer = "2. කොහොඹා කංකාරිය",
          markingScheme = "උඩරට සම්ප්‍රදායේ ප්‍රධාන හා මූලික ශාන්තිකර්මය කොහොඹා කංකාරිය වේ. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/10FQY_uRc1QVJm2mhUz6FBrZFHM_Vhqmy/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "dance_g11_pdf_custom",
          title = "11 ශ්‍රේණිය නර්තනය කෙටි සටහන් සංග්‍රහය (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/10FQY_uRc1QVJm2mhUz6FBrZFHM_Vhqmy/preview",
          uploadDate = "2026-08-25",
          fileSize = "3.1 MB",
          type = "NOTE"
        ),
        AttachedGoogleDrivePdf(
          id = "dance_g11_pdf_1",
          title = "10 සහ 11 ශ්‍රේණි නර්තනය පූර්ණ කෙටි සටහන් සංග්‍රහය (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/12GBk7Eg8H558fgpOPGwFSqGskwUXyMfK/preview",
          uploadDate = "2026-08-17",
          fileSize = "2.4 MB",
          type = "NOTE"
        )
      )
    ),
    SyllabusUnitItem(
      id = "g10_dance_u1",
      grade = "10",
      subject = "නර්තනය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "10 ශ්‍රේණිය නර්තනය මූලික සටහන් හා තාක්ෂණික අංග",
      unitTitleEnglish = "Grade 10 Aesthetics & Dancing Basics",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "නර්තන ඉරියව් සහ මණ්ඩිය: පූර්ණ මණ්ඩිය සහ අඩ මණ්ඩිය.",
        "පාද බෙදීම් සහ සරඹ අභ්‍යාස: උඩරට, පහතරට සහ සබරගමු සම්ප්‍රදායන්හි මූලික පා සරඹ.",
        "නර්තන ඇඳුම් කට්ටලය: වෙස් ඇඳුම (ශීර්ෂාභරණ, අවුල්හැරය, බන්දි වළලු, කරපටිය, දේවකරය).",
        "තාල සහ මාත්‍රා: ඒකතාල, දෙතිස් මාත්‍රා සහ විවිධ ලය (විලම්භ, මධ්‍ය, දෘත)."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "නර්තන ලය ප්‍රභේද සංසන්දනය",
          header1 = "ලය වර්ගය (Laya)",
          header2 = "වේගය (Speed)",
          header3 = "භාවිතය",
          rows = listOf(
            TableRowData("විලම්භ ලය (Vilambitha)", "මන්දගාමී / සෙමින්", "ආරම්භක පද හා ශාන්ත කොටස්"),
            TableRowData("මධ්‍ය ලය (Madhya)", "සාමාන්‍ය වේගය", "නර්තනයේ මධ්‍යම කොටස්"),
            TableRowData("දෘත ලය (Drutha)", "ඉතා වේගවත්", "නර්තනයේ අවසාන කස්තිරම් හා තීර්මාන")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "ලය වර්ග 3 මතක තබා ගැනීම",
          mnemonicSentence = "විලෙන් මධ්‍යයට දුවමු!",
          explanation = "විලෙන් (විලම්භ - සෙමින්) → මධ්‍යයට (මධ්‍ය - සාමාන්‍ය) → දුවමු (දෘත - වේගවත්).",
          appliesTo = "නර්තන ලය 3"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "නර්තනයේ වේගවත්ම ලය කුමක්ද?",
          type = "MCQ",
          options = listOf("1. විලම්භ ලය", "2. මධ්‍ය ලය", "3. දෘත ලය", "4. ඒක ලය"),
          correctAnswer = "3. දෘත ලය",
          markingScheme = "දෘත ලය යනු නර්තනයේ වේගවත්ම ලය වේ. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/12GBk7Eg8H558fgpOPGwFSqGskwUXyMfK/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "dance_g10_pdf_1",
          title = "10 සහ 11 ශ්‍රේණි නර්තනය පූර්ණ කෙටි සටහන් සංග්‍රහය (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/12GBk7Eg8H558fgpOPGwFSqGskwUXyMfK/preview",
          uploadDate = "2026-08-17",
          fileSize = "2.4 MB",
          type = "NOTE"
        )
      )
    ),
    // --------------------------------------------------------------------------
    // GRADE 11 - CIVIC EDUCATION (11 වසර පුරවැසි අධ්‍යාපනය කෙටි සටහන්)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g11_civic_u1",
      grade = "11",
      subject = "පුරවැසි අධ්‍යාපනය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "11 ශ්‍රේණිය පුරවැසි අධ්‍යාපනය පූර්ණ කෙටි සටහන්",
      unitTitleEnglish = "Grade 11 Civic Education Comprehensive Short Notes",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "ශ්‍රී ලංකාවේ ආණ්ඩුක්‍රම ව්‍යවස්ථා පරිණාමය: 1972 පළමු ජනරජ ව්‍යවස්ථාව සහ 1978 දෙවන ජනරජ ව්‍යවස්ථාවේ මූලික ලක්ෂණ.",
        "ආණ්ඩුවේ ව්‍යුහය සහ ප්‍රධාන ආයතන: විධායක ජනාධිපති ක්‍රමය, පාර්ලිමේන්තුව, අග්‍රාමාත්‍ය හා අමාත්‍ය මණ්ඩලය, ස්වාධීන කොමිෂන් සභා.",
        "පළාත් පාලනය සහ බලය විමධ්‍යගත කිරීම: පළාත් සභා (13 වන සංශෝධනය), මහ නගර සභා, නගර සභා සහ ප්‍රාදේශීය සභා.",
        "ජාත්‍යන්තර සබඳතා සහ සංවිධාන: එක්සත් ජාතීන්ගේ සංවිධානය (UN), සාර්ක් (SAARC), නොබැඳි ජාතීන්ගේ ව්‍යාපාරය (NAM) සහ ජාත්‍යන්තර මානව හිමිකම් ප්‍රඥප්තිය.",
        "සමාජ ඒකාග්‍රතාවය, ජාතික සහජීවනය සහ නීතියේ ආධිපත්‍යය සුරැකීමේ පුරවැසි වගකීම."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ශ්‍රී ලංකාවේ පළාත් පාලන ආයතන 3 සංසන්දනය",
          header1 = "ආයතනය (Local Authority)",
          header2 = "ප්‍රධානියා (Head)",
          header3 = "බල ප්‍රදේශයේ ස්වභාවය",
          rows = listOf(
            TableRowData("මහ නගර සභාව (Municipal Council)", "නගරාධිපති (Mayor)", "ප්‍රධාන නාගරික හා වාණිජ කලාප"),
            TableRowData("නගර සභාව (Urban Council)", "සභාපති (Chairman)", "මධ්‍යම ප්‍රමාණයේ නාගරික ප්‍රදේශ"),
            TableRowData("ප්‍රාදේශීය සභාව (Pradeshiya Sabha)", "සභාපති (Chairman)", "ග්‍රාමීය හා අර්ධ නාගරික ප්‍රදේශ")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "පළාත් පාලන ආයතන වර්ග 3 මතක තබා ගැනීම",
          mnemonicSentence = "මහ නගරේ - පොඩි නගරේ - ගමේ ප්‍රාදේශීය සභාවේ!",
          explanation = "මහ නගර සභා → නගර සභා → ප්‍රාදේශීය සභා.",
          appliesTo = "පළාත් පාලන ආයතන"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "ශ්‍රී ලංකාවේ පළාත් සභා ක්‍රමය හඳුන්වා දෙනු ලැබුවේ කුමන ආණ්ඩුක්‍රම ව්‍යවස්ථා සංශෝධනය මඟින්ද?",
          type = "MCQ",
          options = listOf("1. 13 වන ආණ්ඩුක්‍රම ව්‍යවස්ථා සංශෝධනය", "2. 17 වන ආණ්ඩුක්‍රම ව්‍යවස්ථා සංශෝධනය", "3. 19 වන ආණ්ඩුක්‍රම ව්‍යවස්ථා සංශෝධනය", "4. 20 වන ආණ්ඩුක්‍රම ව්‍යවස්ථා සංශෝධනය"),
          correctAnswer = "1. 13 වන ආණ්ඩුක්‍රම ව්‍යවස්ථා සංශෝධනය",
          markingScheme = "1987 දී 13 වන ආණ්ඩුක්‍රම ව්‍යවස්ථා සංශෝධනය මඟින් පළාත් සභා ක්‍රමය පිහිටුවන ලදී. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1KOscWHk1iYyGomECrVn6GApwAKp6kLsY/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "civic_g11_pdf_custom",
          title = "11 ශ්‍රේණිය පුරවැසි අධ්‍යාපනය කෙටි සටහන් සංග්‍රහය (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1KOscWHk1iYyGomECrVn6GApwAKp6kLsY/preview",
          uploadDate = "2026-08-25",
          fileSize = "3.2 MB",
          type = "NOTE"
        )
      )
    ),
    // --------------------------------------------------------------------------
    // GRADE 10 - CIVIC EDUCATION (10 වසර පුරවැසි අධ්‍යාපනය කෙටි සටහන්)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g10_civic_u1",
      grade = "10",
      subject = "පුරවැසි අධ්‍යාපනය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "10 ශ්‍රේණිය පුරවැසි අධ්‍යාපනය පූර්ණ කෙටි සටහන්",
      unitTitleEnglish = "Grade 10 Civic Education Short Notes",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "ප්‍රජාතන්ත්‍රවාදය: ජනතාව විසින්, ජනතාව උදෙසා, ජනතාවගේ පාලනයයි. ප්‍රධාන ලක්ෂණ: නීතියේ ආධිපත්‍යය, මූලික මිනිස් අයිතිවාසිකම්, නිදහස් හා සාධාරණ මැතිවරණ.",
        "ආණ්ඩුවේ ප්‍රධාන අංග 3: ව්‍යවස්ථාදායකය (පාර්ලිමේන්තුව - නීති පැනවීම), විධායකය (ජනාධිපති/අමාත්‍ය මණ්ඩලය - නීති ක්‍රියාත්මක කිරීම), අධිකරණය (නීතිය අර්ථ නිරූපණය හා සාධාරණය ඉටු කිරීම).",
        "යහපාලනයේ මූලධර්ම: විනිවිදභාවය, වගවීම, නීතියේ ආධිපත්‍යය, සහභාගීත්වය, කාර්යක්ෂමතාව සහ සාධාරණත්වය.",
        "පුරවැසි අයිතිවාසිකම් සහ යුතුකම්: රටේ ව්‍යවස්ථාවෙන් තහවුරු කර ඇති මූලික අයිතිවාසිකම් භුක්ති විඳින අතරම රටට හා සමාජයට ඉටු කළ යුතු වගකීම් සහ යුතුකම්."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ආණ්ඩුවේ ප්‍රධාන අංග 3 සංසන්දනය",
          header1 = "අංගය (Branch)",
          header2 = "ප්‍රධාන කාර්යභාරය (Function)",
          header3 = "ශ්‍රී ලංකාවේ ආයතනය / නියෝජනය",
          rows = listOf(
            TableRowData("ව්‍යවස්ථාදායකය (Legislature)", "නීති සම්පාදනය කිරීම", "පාර්ලිමේන්තුව (මන්ත්‍රීවරු 225)"),
            TableRowData("විධායකය (Executive)", "නීති හා ප්‍රතිපත්ති ක්‍රියාත්මක කිරීම", "විධායක ජනාධිපති සහ අමාත්‍ය මණ්ඩලය"),
            TableRowData("අධිකරණය (Judiciary)", "නීතිය අර්ථ නිරූපණය හා විනිශ්චය", "ශ්‍රේෂ්ඨාධිකරණය, අභියාචනාධිකරණය ඇතුළු උසාවි")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "ආණ්ඩුවේ අංග 3 පහසුවෙන් මතක තබා ගැනීම",
          mnemonicSentence = "ව්‍යවස්ථාවෙන් පනවා - විධායකයෙන් ක්‍රියාකර - අධිකරණයෙන් රකී!",
          explanation = "ව්‍යවස්ථාදායකය (නීති සම්පාදනය) → විධායකය (ක්‍රියාත්මක කිරීම) → අධිකරණය (සාධාරණය හා රැකවරණය).",
          appliesTo = "ආණ්ඩුවේ අංග 3"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "ශ්‍රී ලංකාවේ නීති සම්පාදනය කිරීමේ බලය හිමි වන්නේ කාටද?",
          type = "MCQ",
          options = listOf("1. අමාත්‍ය මණ්ඩලයට", "2. පාර්ලිමේන්තුවට", "3. ශ්‍රේෂ්ඨාධිකරණයට", "4. පළාත් සභාවලට පමණි"),
          correctAnswer = "2. පාර්ලිමේන්තුවට",
          markingScheme = "ශ්‍රී ලංකාවේ පරමාධිපත්‍යය යටතේ නීති සම්පාදනය කිරීමේ බලය ව්‍යවස්ථාදායකය හෙවත් පාර්ලිමේන්තුව සතු වේ. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1-H0WHiCYob1T4kQ9Sol4n6SQSJZc9LEX/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "civic_g10_pdf_1",
          title = "10 ශ්‍රේණිය පුරවැසි අධ්‍යාපනය පූර්ණ කෙටි සටහන් (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1-H0WHiCYob1T4kQ9Sol4n6SQSJZc9LEX/preview",
          uploadDate = "2026-08-17",
          fileSize = "3.1 MB",
          type = "NOTE"
        )
      )
    ),
    SyllabusUnitItem(
      id = "g10_civic_u2",
      grade = "10",
      subject = "පුරවැසි අධ්‍යාපනය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "10 ශ්‍රේණිය පුරවැසි දෙවන වාර විභාග ප්‍රශ්න පත්‍ර",
      unitTitleEnglish = "Grade 10 Civic Education 2nd Term Examination Papers",
      term = "2 වන වාරය",
      summaryNotes = listOf(
        "10 ශ්‍රේණිය පුරවැසි අධ්‍යාපනය දෙවන වාර විභාග ප්‍රශ්න පත්‍ර සංග්‍රහය සහ ලකුණු දීමේ පටිපාටිය.",
        "ප්‍රජාතන්ත්‍රවාදී පාලන ක්‍රමය, නීතියේ ආධිපත්‍යය සහ පුරවැසි වගකීම්.",
        "ශ්‍රී ලංකාවේ ප්‍රාදේශීය පාලනය: පළාත් සභා සහ පළාත් පාලන ආයතන (මහ නගර සභා, නගර සභා, ප්‍රාදේශීය සභා).",
        "මානව අයිතිවාසිකම් සහ යුතුකම් පිළිබඳ අවබෝධය.",
        "සමාජ සහජීවනය සහ බහුසංස්කෘතික සමාජයක අගය."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "පළාත් පාලන ආයතන සංසන්දනය",
          header1 = "ආයතනය",
          header2 = "ප්‍රදේශය / බල ප්‍රදේශය",
          header3 = "ප්‍රධානියා",
          rows = listOf(
            TableRowData("මහ නගර සභාව", "විශාල නාගරික ප්‍රදේශ", "නගරාධිපති (Mayor)"),
            TableRowData("නගර සභාව", "කුඩා / අර්ධ නාගරික ප්‍රදේශ", "සභාපති (Chairman)"),
            TableRowData("ප්‍රාදේශීය සභාව", "ග්‍රාමීය ප්‍රදේශ", "සභාපති (Chairman)")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "පළාත් පාලන ආයතන 3 මතක තබා ගැනීම",
          mnemonicSentence = "මහ නගරේ - පොඩි නගරේ - ගමේ ප්‍රාදේශීය සභාව!",
          explanation = "මහ නගර සභා, නගර සභා, ප්‍රාදේශීය සභා.",
          appliesTo = "පළාත් පාලන ආයතන 3"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "ශ්‍රී ලංකාවේ ග්‍රාමීය ප්‍රදේශවල පළාත් පාලන කටයුතු භාර ආයතනය කුමක්ද?",
          type = "MCQ",
          options = listOf("1. ප්‍රාදේශීය සභාව", "2. නගර සභාව", "3. මහ නගර සභාව", "4. පළාත් සභාව"),
          correctAnswer = "1. ප්‍රාදේශීය සභාව",
          markingScheme = "ග්‍රාමීය ප්‍රදේශ සඳහා පළාත් පාලන ආයතනය ප්‍රාදේශීය සභාව වේ. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1pdYxCcT8h2aVnp2XToS7kBgqg2aglFC9/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "civic_g10_term2_papers_custom",
          title = "10 ශ්‍රේණිය පුරවැසි දෙවන වාර විභාග ප්‍රශ්න පත්‍ර (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1pdYxCcT8h2aVnp2XToS7kBgqg2aglFC9/preview",
          uploadDate = "2026-08-30",
          fileSize = "4.6 MB",
          type = "PAPER"
        )
      )
    ),
    SyllabusUnitItem(
      id = "g10_buddhism_u2",
      grade = "10",
      subject = "බුද්ධ ධර්මය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "10 ශ්‍රේණිය බුද්ධ ධර්මය දෙවන වාර විභාග ප්‍රශ්න පත්‍ර",
      unitTitleEnglish = "Grade 10 Buddhism 2nd Term Examination Papers",
      term = "2 වන වාරය",
      summaryNotes = listOf(
        "10 ශ්‍රේණිය බුද්ධ ධර්මය දෙවන වාර විභාග ප්‍රශ්න පත්‍ර සංග්‍රහය සහ ලකුණු දීමේ පටිපාටිය.",
        "සම්බුද්ධ චරිතය සහ ශාසන ඉතිහාසය ආශ්‍රිත ප්‍රශ්න හා පිළිතුරු.",
        "සූත්‍ර ධර්ම සහ ධර්ම කරුණු විවරණය.",
        "බෞද්ධ සදාචාරය, සමාජ දර්ශනය සහ ප්‍රායෝගික ජීවිතයට බුදුදහම යොදාගැනීම."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "බෞද්ධ සූත්‍ර දේශනා සංසන්දනය",
          header1 = "සූත්‍රය",
          header2 = "දේශනා කළ ස්ථානය",
          header3 = "ප්‍රධාන අරමුණ / තේමාව",
          rows = listOf(
            TableRowData("මංගල සූත්‍රය", "දෙව්රම් වෙහෙර", "දෙව් මිනිසුන්ට උතුම් මංගල කරුණු 38 දේශනා කිරීම"),
            TableRowData("රතන සූත්‍රය", "විසාලා මහනුවර", "තුන්බිය දුරු කිරීම සහ ත්‍රිවිධ රත්නයේ ගුණ ප්‍රකාශ කිරීම"),
            TableRowData("කරණීයමෙත්ත සූත්‍රය", "සැවැත්නුවර", "මෙත් වැඩීම සහ භාවනානුයෝගී භික්ෂූන්ගේ ආරක්ෂාව")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "තුන්බිය මතක තබා ගැනීම",
          mnemonicSentence = "රෝග බිය - දුර්භික්ෂ බිය - අමනුෂ්‍ය බිය (රෝ-දුර්-අම)!",
          explanation = "විසාලා මහනුවර පැවති ත්‍රිවිධ බිය.",
          appliesTo = "රතන සූත්‍රය"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "විසාලා මහනුවර තුන්බිය දුරු කිරීම සඳහා බුදුරජාණන් වහන්සේ දේශනා කොට වදාළ සූත්‍රය කුමක්ද?",
          type = "MCQ",
          options = listOf("1. රතන සූත්‍රය", "2. මංගල සූත්‍රය", "3. කරණීයමෙත්ත සූත්‍රය", "4. වසල සූත්‍රය"),
          correctAnswer = "1. රතන සූත්‍රය",
          markingScheme = "විසාලා මහනුවර තුන්බිය දුරු කිරීමට රතන සූත්‍රය දේශනා කරන ලදී. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1gJ03_AT7XEPQEEAp2HLYHywIEaDO2ed1/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "buddhism_g10_term2_papers_custom",
          title = "10 ශ්‍රේණිය බුද්ධ ධර්මය දෙවන වාර විභාග ප්‍රශ්න පත්‍ර 01 (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1gJ03_AT7XEPQEEAp2HLYHywIEaDO2ed1/preview",
          uploadDate = "2026-08-30",
          fileSize = "4.7 MB",
          type = "PAPER"
        ),
        AttachedGoogleDrivePdf(
          id = "buddhism_g10_term2_papers_custom_2",
          title = "10 ශ්‍රේණිය බුද්ධ ධර්මය දෙවන වාර විභාග ප්‍රශ්න පත්‍ර 02 (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1L42lStEbPjLRYN8geeieFnWKH8_HgFA9/preview",
          uploadDate = "2026-08-30",
          fileSize = "4.9 MB",
          type = "PAPER"
        ),
        AttachedGoogleDrivePdf(
          id = "buddhism_g10_term2_papers_custom_3",
          title = "10 ශ්‍රේණිය බුද්ධ ධර්මය දෙවන වාර විභාග ප්‍රශ්න පත්‍ර 03 (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1-MGv6Q8nI_t6Oiy74fxZhWj9T0GOWQx7/preview",
          uploadDate = "2026-08-30",
          fileSize = "4.5 MB",
          type = "PAPER"
        )
      )
    ),
    SyllabusUnitItem(
      id = "g11_buddhism_u1",
      grade = "11",
      subject = "බුද්ධ ධර්මය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "11 ශ්‍රේණිය බුද්ධ ධර්මය පළමු වාර විභාග ප්‍රශ්න පත්‍ර",
      unitTitleEnglish = "Grade 11 Buddhism 1st Term Examination Papers",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "11 ශ්‍රේණිය බුද්ධ ධර්මය පළමු වාර විභාග ප්‍රශ්න පත්‍ර සංග්‍රහය සහ ලකුණු දීමේ පටිපාටිය.",
        "සම්බුද්ධ චරිතය, බෞද්ධ සංස්කෘතිය සහ ශාසන ඉතිහාසය පිළිබඳ ප්‍රශ්න හා පිළිතුරු.",
        "සූත්‍ර ධර්ම, අභිධර්ම මූලික කරුණු සහ බෞද්ධ දර්ශනය.",
        "බෞද්ධ සදාචාරය, නූතන සමාජ ගැටලු හා බෞද්ධ විසඳුම්."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "බෞද්ධ මූලධර්ම සහ ප්‍රතිපදා සංසන්දනය",
          header1 = "ධර්ම කරුණ",
          header2 = "අර්ථය / විවරණය",
          header3 = "ප්‍රායෝගික ප්‍රයෝජනය",
          rows = listOf(
            TableRowData("සීලය", "කය සහ වචනය සංවර කර ගැනීම", "සමාජ සාමය හා චිත්ත සමාධියට පදනම"),
            TableRowData("සමාධිය", "සිත එකඟ කර ගැනීම", "චිත්ත ඒකාග්‍රතාවය හා ප්‍රඥාව ලැබීම"),
            TableRowData("ප්‍රඥාව", "යථාර්ථය අවබෝධ කර ගැනීම", "කෙලෙස් දුරුකර නිර්වාණාවබෝධය")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "ත්‍රිශික්ෂාව මතක තබා ගැනීම",
          mnemonicSentence = "සීලයෙන් පටන් අරන් - සමාධියෙන් සිත දමනය කර - ප්‍රඥාවෙන් නිවන් දකින්න!",
          explanation = "සීල, සමාධි, ප්‍රඥා යන ත්‍රිශික්ෂාව නිර්වාණ මාර්ගයයි.",
          appliesTo = "ත්‍රිශික්ෂාව"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "නිර්වාණාවබෝධය සඳහා පුද්ගලයා විසින් වැඩිය යුතු ත්‍රිශික්ෂාවට අයත් අංග 3 මොනවාද?",
          type = "SHORT",
          correctAnswer = "සීල, සමාධි, ප්‍රඥා",
          markingScheme = "සීල ශික්ෂාව, සමාධි/චිත්ත ශික්ෂාව, ප්‍රඥා ශික්ෂාව. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1TcxvDaBmSPTRLS-FVVkeNUyCEcgjA5C0/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "buddhism_g11_term1_papers_custom",
          title = "11 ශ්‍රේණිය බුද්ධ ධර්මය පළමු වාර විභාග ප්‍රශ්න පත්‍ර 01 (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1TcxvDaBmSPTRLS-FVVkeNUyCEcgjA5C0/preview",
          uploadDate = "2026-08-30",
          fileSize = "4.8 MB",
          type = "PAPER"
        ),
        AttachedGoogleDrivePdf(
          id = "buddhism_g11_term1_papers_custom_2",
          title = "11 ශ්‍රේණිය බුද්ධ ධර්මය පළමු වාර විභාග ප්‍රශ්න පත්‍ර 02 (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/14E2Ty53fNwuAgBmGA1FJ7UwD76QsLhHg/preview",
          uploadDate = "2026-08-30",
          fileSize = "4.7 MB",
          type = "PAPER"
        )
      )
    ),
    SyllabusUnitItem(
      id = "g11_buddhism_u2",
      grade = "11",
      subject = "බුද්ධ ධර්මය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "11 ශ්‍රේණිය බුද්ධ ධර්මය දෙවන වාර විභාග ප්‍රශ්න පත්‍ර",
      unitTitleEnglish = "Grade 11 Buddhism 2nd Term Examination Papers",
      term = "2 වන වාරය",
      summaryNotes = listOf(
        "11 ශ්‍රේණිය බුද්ධ ධර්මය දෙවන වාර විභාග ප්‍රශ්න පත්‍ර සංග්‍රහය සහ ලකුණු දීමේ පටිපාටිය.",
        "සම්බුද්ධ චරිතය සහ ශාසන ඉතිහාසය පිළිබඳ විභාග ප්‍රශ්න විවරණ.",
        "සූත්‍ර ධර්ම සහ ධර්ම කරුණු ගැඹුරින් අධ්‍යයනය.",
        "බෞද්ධ සදාචාරය, ප්‍රතිපත්ති පූජා සහ සමාජ සංවර්ධනය."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "බෞද්ධ පුණ්‍ය ක්‍රියා සංසන්දනය",
          header1 = "පුණ්‍ය ක්‍රියාව",
          header2 = "අර්ථය",
          header3 = "ආනිසංස",
          rows = listOf(
            TableRowData("දානය", "අත්හැරීම හා පරිත්‍යාගය", "භවභෝග සම්පත් හා ලෝභය දුරු වීම"),
            TableRowData("සීලය", "කය, වචන සංවරය", "සුගතිගාමී වීම හා චිත්ත සමාධිය"),
            TableRowData("භාවනාව", "සිත දියුණු කිරීම", "ප්‍රඥාව ලැබීම හා නිවන් දැකීම")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "ත්‍රිවිධ පුණ්‍ය ක්‍රියා මතක තබා ගැනීම",
          mnemonicSentence = "දානයෙන් අතහරින්න - සීලයෙන් සංවර වන්න - භාවනාවෙන් සිත දියුණු කරන්න (දා-සී-භා)!",
          explanation = "දාන, සීල, භාවනා යන ත්‍රිවිධ පුණ්‍ය ක්‍රියා.",
          appliesTo = "ත්‍රිවිධ පුණ්‍ය ක්‍රියා"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "පුද්ගල චිත්ත සන්තානය පිරිසිදු කරමින් ප්‍රඥාව දියුණු කිරීමට උපකාරී වන ප්‍රධානතම පුණ්‍ය ක්‍රියාව කුමක්ද?",
          type = "MCQ",
          options = listOf("1. භාවනාව", "2. දානය", "3. පින් දීම", "4. බණ ඇසීම"),
          correctAnswer = "1. භාවනාව",
          markingScheme = "භාවනාව මඟින් සිත දියුණු කර ප්‍රඥාව අවදි කරයි. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1lR-tAq0eW5UWfIBLrcNKXluTscyzPIDa/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "buddhism_g11_term2_papers_custom",
          title = "11 ශ්‍රේණිය බුද්ධ ධර්මය දෙවන වාර විභාග ප්‍රශ්න පත්‍ර 01 (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1lR-tAq0eW5UWfIBLrcNKXluTscyzPIDa/preview",
          uploadDate = "2026-08-30",
          fileSize = "4.9 MB",
          type = "PAPER"
        ),
        AttachedGoogleDrivePdf(
          id = "buddhism_g11_term2_papers_custom_2",
          title = "11 ශ්‍රේණිය බුද්ධ ධර්මය දෙවන වාර විභාග ප්‍රශ්න පත්‍ර 02 (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1AW-2VdUYt2OXUBFmKiB0mlDmha58RnJK/preview",
          uploadDate = "2026-08-30",
          fileSize = "4.6 MB",
          type = "PAPER"
        )
      )
    ),
    // --------------------------------------------------------------------------
    // GRADE 11 - SCIENCE (11 වසර විද්‍යාව)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g11_sci_u1",
      grade = "11",
      subject = "විද්‍යාව",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "ජීවයේ රසායනික පදනම (Chemical Basis of Life)",
      unitTitleEnglish = "Chemical Basis of Life",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "ජීවීන්ගේ දේහ සෑදී ඇති ප්‍රධාන මූලද්‍රව්‍ය 4: කාබන් (C), හයිඩ්‍රජන් (H), ඔක්සිජන් (O), නයිට්‍රජන් (N) වේ.",
        "ජෛව අණු ප්‍රධාන කාණ්ඩ 4කි: කාබෝහයිඩ්‍රේට, ප්‍රෝටීන, ලිපිඩ, සහ නියුක්ලික් අම්ල.",
        "කාබෝහයිඩ්‍රේට: C, H, O අඩංගු අතර H:O අනුපාතය 2:1 වේ. ප්‍රධාන කාණ්ඩ: මොනොසැකරයිඩ (ග්ලූකෝස්, ෆෲක්ටෝස්, ගැලැක්ටෝස්), ඩයිසැකරයිඩ (සුක්‍රෝස්, මෝල්ටෝස්, ලැක්ටෝස්), පොලිසැකරයිඩ (පිෂ්ඨය, සෙලියුලෝස්, ග්ලයිකොජන්).",
        "ප්‍රෝටීන: C, H, O, N අඩංගු අතර ගොඩනැගුම් ඒකකය ඇමයිනෝ අම්ලයි. පෙප්ටයිඩ බන්ධන මඟින් බැඳී ඇත. පරීක්ෂාව: බයියුරෙට් පරීක්ෂාව (දම් පැහැය).",
        "ලිපිඩ: C, H, O අඩංගුය. ජලයේ අද්‍රාව්‍ය කාබනික ද්‍රාවකවල ද්‍රාව්‍ය වේ. පරීක්ෂාව: සුඩාන් III හෝ පාරභාසක පරීක්ෂාව.",
        "ජලයේ සුවිශේෂී ගුණ: විශිෂ්ට ද්‍රාවක ගුණය, ඉහළ විශිෂ්ට තාප ධාරිතාව, ඉහළ වාෂ්පීකරණයේ ගුප්ත තාපය, ජලජ ජීවීන්ට හිතකර ඝනත්ව විචලනය (4°C දී උපරිම ඝනත්වය)."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "කාබෝහයිඩ්‍රේට වර්ග සංසන්දනය (Types of Carbohydrates)",
          header1 = "කාණ්ඩය (Type)",
          header2 = "උදාහරණ (Examples)",
          header3 = "පරීක්ෂාව & ප්‍රතිඵලය (Test & Result)",
          rows = listOf(
            TableRowData("මොනොසැකරයිඩ", "ග්ලූකෝස්, ෆෲක්ටෝස්, ගැලැක්ටෝස්", "බෙනඩික්ට් පරීක්ෂාව → ගඩොල් රතු අවක්ෂේපය"),
            TableRowData("ඩයිසැකරයිඩ", "මෝල්ටෝස්, සුක්‍රෝස්, ලැක්ටෝස්", "මෝල්ටෝස්/ලැක්ටෝස් බෙනඩික්ට් ධන, සුක්‍රෝස් සෘණ"),
            TableRowData("පොලිසැකරයිඩ", "පිෂ්ඨය, සෙලියුලෝස්, ග්ලයිකොජන්", "අයඩින් පරීක්ෂාව → නිල්-කළු පැහැය (පිෂ්ඨය සඳහා)")
          )
        ),
        ComparisonTable(
          title = "ප්‍රෝටීන vs ලිපිඩ සංසන්දනය",
          header1 = "ලක්ෂණය",
          header2 = "ප්‍රෝටීන (Proteins)",
          header3 = "ලිපිඩ (Lipids)",
          rows = listOf(
            TableRowData("මූලද්‍රව්‍ය සංයුතිය", "C, H, O, N (සමහර විට S)", "C, H, O (අඩු O ප්‍රමාණයක්)"),
            TableRowData("ගොඩනැගුම් ඒකකය", "ඇමයිනෝ අම්ල (Amino acids)", "මේද අම්ල + ග්ලිසරෝල්"),
            TableRowData("ප්‍රධාන කාර්යය", "දේහ වර්ධනය, එන්සයිම, ප්‍රතිදේහ", "ශක්ති ගබඩාව, පරිවරණය, හෝමෝන")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "මොනොසැකරයිඩ මතක තබා ගැනීමේ කෙටි ක්‍රමය",
          mnemonicSentence = "ග්ලු ගාලා ෆෲට් බිව්වම ගැලැක්සිය පෙනෙයි!",
          explanation = "ග්ලු = ග්ලූකෝස් (Glucose), ෆෲට් = ෆෲක්ටෝස් (Fructose), ගැලැක්සි = ගැලැක්ටෝස් (Galactose).",
          appliesTo = "මොනොසැකරයිඩ 3"
        ),
        MemoryTrick(
          title = "ඩයිසැකරයිඩ සංයුතිය මතක තබා ගැනීම",
          mnemonicSentence = "මෝල්ට් (ග්ලු+ග්ලු), සුදු සීනි (ග්ලු+ෆෲට්), කිරි (ග්ලු+ගැලැක්සි)",
          explanation = "මෝල්ටෝස් = ග්ලූකෝස් + ග්ලූකෝස්, සුක්‍රෝස් = ග්ලූකෝස් + ෆෲක්ටෝස්, ලැක්ටෝස් = ග්ලූකෝස් + ගැලැක්ටෝස්.",
          appliesTo = "ඩයිසැකරයිඩ බිඳවැටීම"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "ග්ලූකෝස් ද්‍රාවණයකට බෙනඩික්ට් ප්‍රතිකාරකය එක්කර රත් කළ විට ලැබෙන අවසාන වර්ණ විපර්යාසය කුමක්ද?",
          type = "MCQ",
          options = listOf("1. නිල්-කළු පැහැය", "2. ගඩොල් රතු අවක්ෂේපය", "3. දම් පැහැය", "4. කහ පැහැති අවක්ෂේපය"),
          correctAnswer = "2. ගඩොල් රතු අවක්ෂේපය",
          markingScheme = "බෙනඩික්ට් ද්‍රාවණය ඔක්සිහාරක සීනි හමුවේ නිල් පැහැයේ සිට කොළ → කහ → තැඹිලි → ගඩොල් රතු බවට පත්වේ. (ලකුණු 2)",
          marksAllocated = 2
        ),
        UnitQuestion(
          questionNumber = 2,
          questionText = "ජලජ ජීවීන්ට අයිස් තට්ටු යට ශීත ඍතුවේදී ජීවත් වීමට උපකාරී වන ජලයේ භෞතික ගුණය පැහැදිලි කරන්න.",
          type = "SHORT",
          correctAnswer = "4°C දී ජලයේ උපරිම ඝනත්වය පැවතීම සහ අයිස් බවට පත්වීමේදී ඝනත්වය අඩුවී මතුපිට පාවීම.",
          markingScheme = "• 4°C දී උපරිම ඝනත්වය ලැබීම (ලකුණු 2) • මතුපිට මිදුණු අයිස් තට්ටුව තාප පරිවාරකයක් ලෙස ක්‍රියා කිරීම (ලකුණු 2). මුළු ලකුණු 4.",
          marksAllocated = 4
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/17TcFs1wECaHB4C3LMdC8mO2YDKrtrEOI/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "sci_g11_pdf_custom",
          title = "11 ශ්‍රේණිය විද්‍යාව කෙටි සටහන් සංග්‍රහය (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1b650hE61XIP8RxNWq3TpIxg8pHtTOY8m/preview",
          uploadDate = "2026-08-25",
          fileSize = "4.2 MB",
          type = "NOTE"
        ),
        AttachedGoogleDrivePdf(
          id = "sci_g11_500_questions_pdf",
          title = "11 ශ්‍රේණිය විද්‍යාව ප්‍රශ්න 500 විශේෂ ප්‍රශ්නෝත්තර සංග්‍රහය & Auto-Checker (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1MarNrbMHz2UCxJq-bJJHjp9VxM8N2Ka-/preview",
          uploadDate = "2026-08-31",
          fileSize = "5.6 MB",
          type = "NOTE"
        )
      )
    ),

    SyllabusUnitItem(
      id = "g11_sci_u2",
      grade = "11",
      subject = "විද්‍යාව",
      unitNumber = "02 වන පාඩම",
      unitTitleSinhala = "ප්‍රභාසංශ්ලේෂණය (Photosynthesis)",
      unitTitleEnglish = "Photosynthesis",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "ප්‍රභාසංශ්ලේෂණය යනු හරිත ශාක සූර්යාලෝක ශක්තිය රසායනික ශක්තිය බවට පරිවර්තනය කර කාබනික ආහාර නිපදවීමේ ක්‍රියාවලියයි.",
        "සමස්ත සමීකරණය: 6CO₂ + 6H₂O + ආලෝක ශක්තිය (හරිතප්‍රද හමුවේ) → C₆H₁₂O₆ + 6O₂",
        "ප්‍රධාන අදියර දෙකකි: 1. ආලෝක ප්‍රතික්‍රියාව (තයිලකොයිඩ පටලවලදී සිදුවේ - ජලය විච්ඡේදනය වී O₂ පිටවේ, ATP හා NADPH නිපදවේ). 2. අඳුරු ප්‍රතික්‍රියාව/කැල්වින් චක්‍රය (ස්ට්‍රෝමාවේදී සිදුවේ - CO₂ තිර වී ග්ලූකෝස් නිපදවේ).",
        "ප්‍රභාසංශ්ලේෂණ අනුපාතයට බලපාන සාධක: ආලෝක තීව්‍රතාව, CO₂ සාන්ද්‍රණය, උෂ්ණත්වය (ප්‍රශස්ත උෂ්ණත්වය 25°C - 35°C)."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ආලෝක ප්‍රතික්‍රියාව vs අඳුරු ප්‍රතික්‍රියාව (Light vs Dark Reactions)",
          header1 = "ලක්ෂණය",
          header2 = "ආලෝක ප්‍රතික්‍රියාව (Light Phase)",
          header3 = "අඳුරු ප්‍රතික්‍රියාව (Calvin Cycle)",
          rows = listOf(
            TableRowData("සිදුවන ස්ථානය", "හරිතලවේ තයිලකොයිඩ පටලය", "හරිතලවේ ස්ට්‍රෝමාව (Stroma)"),
            TableRowData("ආලෝක අවශ්‍යතාව", "ආලෝකය අත්‍යවශ්‍යයි", "ආලෝකය සෘජුව අවශ්‍ය නොවේ"),
            TableRowData("ප්‍රධාන ඵල", "O₂ වායුව, ATP, NADPH", "ග්ලූකෝස් (C₆H₁₂O₆), ADP, NADP⁺"),
            TableRowData("අමුද්‍රව්‍යය", "ජලය (H₂O) සහ ආලෝකය", "කාබන් ඩයොක්සයිඩ් (CO₂)")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "ප්‍රභාසංශ්ලේෂණ ප්‍රතික්‍රියා ස්ථාන මතක තබා ගැනීම",
          mnemonicSentence = "තයිලයේ ආලෝකය - ස්ට්‍රෝමාවේ අඳුර!",
          explanation = "තයිලකොයිඩ = ආලෝක ප්‍රතික්‍රියාව (Light), ස්ට්‍රෝමාව = අඳුරු ප්‍රතික්‍රියාව (Dark / Calvin).",
          appliesTo = "හරිතලව අභ්‍යන්තර ව්‍යුහය"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "ප්‍රභාසංශ්ලේෂණයේ ආලෝක ප්‍රතික්‍රියාවේදී පිටවන ඔක්සිජන් (O₂) වායුවේ මූලාශ්‍රය වන්නේ කුමක්ද?",
          type = "MCQ",
          options = listOf("1. කාබන් ඩයොක්සයිඩ් (CO₂)", "2. ජලය (H₂O)", "3. ග්ලූකෝස්", "4. හරිතප්‍රද"),
          correctAnswer = "2. ජලය (H₂O)",
          markingScheme = "ආලෝක ශක්තියෙන් ජල අණු ප්‍රකාශ විච්ඡේදනය වීමෙන් O₂ මුදාහැරේ. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1zAddaGRd4loU0yxwWaMDi14G3rcFOvP4/preview"
    ),

    // --------------------------------------------------------------------------
    // GRADE 11 - MATHEMATICS (11 වසර ගණිතය)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g11_math_u1",
      grade = "11",
      subject = "ගණිතය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "වර්ගජ සමීකරණ (Quadratic Equations)",
      unitTitleEnglish = "Quadratic Equations",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "වර්ගජ සමීකරණයක සම්මත ආකාරය: ax² + bx + c = 0 (a ≠ 0).",
        "විසඳන ප්‍රධාන ක්‍රම 3කි: 1. සාධක සෙවීමේ ක්‍රමය, 2. වර්ගපූර්ණ ක්‍රමය, 3. වර්ගජ සූත්‍රය භාවිතය.",
        "වර්ගජ සූත්‍රය: x = (-b ± √(b² - 4ac)) / (2a)",
        "විවේචකය (Discriminant) Δ = b² - 4ac:",
        "• Δ > 0 නම් තාත්වික සහ එකිනෙකට වෙනස් මූල 2කි.",
        "• Δ = 0 නම් තාත්වික සහ සමාන මූල 2කි (සමපාත මූල).",
        "• Δ < 0 නම් තාත්වික මූල නොපවතී."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "වර්ගජ සමීකරණ විසඳීමේ ක්‍රම සංසන්දනය",
          header1 = "ක්‍රමය",
          header2 = "භාවිත කළ හැකි අවස්ථා",
          header3 = "ප්‍රධාන පියවර",
          rows = listOf(
            TableRowData("සාධක ක්‍රමය", "පහසුවෙන් පද වෙන්කළ හැකි විට", "(x - p)(x - q) = 0 ආකාරයට ලියා x = p හෝ x = q ලබාගැනීම"),
            TableRowData("වර්ගපූර්ණ ක්‍රමය", "වර්ගජ සූත්‍රය ගොඩනැගීමට සහ ප්‍රමේයවලට", "x² + (b/a)x + (b/2a)² එකතු කර පූර්ණ වර්ගයක් සෑදීම"),
            TableRowData("වර්ගජ සූත්‍රය", "ඕනෑම ax² + bx + c = 0 සමීකරණයකට (දශම සහිත විට)", "a, b, c හඳුනාගෙන x = [-b ± √(b² - 4ac)] / 2a ආදේශය")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "වර්ගජ සූත්‍රය පහසුවෙන් මතක තබා ගැනීම",
          mnemonicSentence = "ඍණ b ගෙදරින් එළියට ආවා, ප්ලස් මයිනස් රූට් ඇතුලේ b වර්ග වෙලා 4ac අඩු කරලා 2a ගෙන් බෙදුවා!",
          explanation = "x = [-b ± √(b² - 4ac)] / (2a)",
          appliesTo = "Quadratic Formula"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "2x² - 5x + 2 = 0 සමීකරණයේ මූල සොයන්න.",
          type = "STRUCTURED",
          correctAnswer = "x = 2 හෝ x = 1/2",
          markingScheme = "• සාධක වෙන්කිරීම: (2x - 1)(x - 2) = 0 (ලකුණු 2) • 2x - 1 = 0 => x = 1/2 (ලකුණු 1) • x - 2 = 0 => x = 2 (ලකුණු 1). මුළු ලකුණු 4.",
          marksAllocated = 4
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/129U-ITun4kdQJAW0euss4h5S5ZH2IVfl/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "math_g11_term2_papers_custom_4",
          title = "11 ශ්‍රේණිය ගණිතය දෙවන වාර විභාග ප්‍රශ්න පත්‍ර (කට්ටලය 04)",
          driveUrl = "https://drive.google.com/file/d/1CFuLN_QGZYjXFIxRm2rKHuMRshui1lDy/preview",
          uploadDate = "2026-08-30",
          fileSize = "6.0 MB",
          type = "PAPER"
        ),
        AttachedGoogleDrivePdf(
          id = "math_g11_ol_papers_custom_1",
          title = "11 ශ්‍රේණිය ගණිතය සාමාන්‍ය පෙළ ප්‍රශ්න පත්‍ර (ප්‍රශ්න පත්‍ර 01)",
          driveUrl = "https://drive.google.com/file/d/1JsrHtdUOpd9MtZgm6_cZFX9sbhhs4kCS/preview",
          uploadDate = "2026-08-26",
          fileSize = "4.8 MB",
          type = "PAPER"
        ),
        AttachedGoogleDrivePdf(
          id = "math_g11_ol_papers_custom_9",
          title = "11 ශ්‍රේණිය ගණිතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍ර (ප්‍රශ්න පත්‍රය 07)",
          driveUrl = "https://drive.google.com/file/d/1xDkAhMMJX2f6SKQbsMLCNR31VECQqRzN/preview",
          uploadDate = "2026-08-30",
          fileSize = "6.1 MB",
          type = "PAPER"
        ),
        AttachedGoogleDrivePdf(
          id = "math_g11_ol_papers_custom_8",
          title = "11 ශ්‍රේණිය ගණිතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍ර (ප්‍රශ්න පත්‍රය 06)",
          driveUrl = "https://drive.google.com/file/d/1AD4oy9etzQGpIINmusucjyW3gYq66lwL/preview",
          uploadDate = "2026-08-30",
          fileSize = "5.9 MB",
          type = "PAPER"
        ),
        AttachedGoogleDrivePdf(
          id = "math_g11_ol_papers_custom_7",
          title = "11 ශ්‍රේණිය ගණිතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍ර (ප්‍රශ්න පත්‍රය 05)",
          driveUrl = "https://drive.google.com/file/d/1VhY-Of4Ub-ZuRRJHrq1RX4o3cOTsyXtM/preview",
          uploadDate = "2026-08-30",
          fileSize = "5.8 MB",
          type = "PAPER"
        ),
        AttachedGoogleDrivePdf(
          id = "math_g11_ol_papers_custom_6",
          title = "11 ශ්‍රේණිය ගණිතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍ර (අතිරේක ප්‍රශ්න පත්‍රය)",
          driveUrl = "https://drive.google.com/file/d/1agtzpsIvSsF3IJyuV43RdWITGt_ruflb/preview",
          uploadDate = "2026-08-30",
          fileSize = "5.6 MB",
          type = "PAPER"
        ),
        AttachedGoogleDrivePdf(
          id = "math_g11_ol_papers_custom_5",
          title = "11 ශ්‍රේණිය ගණිතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍ර (විශේෂ කට්ටලය)",
          driveUrl = "https://drive.google.com/file/d/1adURMthHZSMi8KLCxgpY1AReZuy0kbd8/preview",
          uploadDate = "2026-08-29",
          fileSize = "5.5 MB",
          type = "PAPER"
        ),
        AttachedGoogleDrivePdf(
          id = "math_g11_ol_papers_custom_4",
          title = "11 ශ්‍රේණිය ගණිතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍ර (නව කට්ටලය)",
          driveUrl = "https://drive.google.com/file/d/1tQ4TvRxbeIiLMVr7uEth0G9nHpOtT8tp/preview",
          uploadDate = "2026-08-29",
          fileSize = "5.3 MB",
          type = "PAPER"
        ),
        AttachedGoogleDrivePdf(
          id = "math_g11_ol_papers_custom_3",
          title = "11 ශ්‍රේණිය ගණිතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍ර",
          driveUrl = "https://drive.google.com/file/d/1pEE7prAIU-JTjsQFrGhF4kMPPQEAZJsA/preview",
          uploadDate = "2026-08-29",
          fileSize = "5.1 MB",
          type = "PAPER"
        ),
        AttachedGoogleDrivePdf(
          id = "math_g11_ol_papers_custom_2",
          title = "11 ශ්‍රේණිය ගණිතය සාමාන්‍ය පෙළ පසුගිය ප්‍රශ්න පත්‍ර (ප්‍රශ්න පත්‍ර 02)",
          driveUrl = "https://drive.google.com/file/d/16guEVXq3IzLmSPRoMktnZUyI0y3XALYm/preview",
          uploadDate = "2026-08-26",
          fileSize = "4.5 MB",
          type = "PAPER"
        )
      )
    ),

    // --------------------------------------------------------------------------
    // GRADE 11 - ICT (11 වසර තොරතුරු හා සන්නිවේදන තාක්ෂණය)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g11_ict_u1",
      grade = "11",
      subject = "තොරතුරු තාක්ෂණය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "11 ශ්‍රේණිය තොරතුරු හා සන්නිවේදන තාක්ෂණය දෙවන වාර විභාග ප්‍රශ්න පත්‍ර",
      unitTitleEnglish = "Grade 11 ICT 2nd Term Examination Papers",
      term = "2 වන වාරය",
      summaryNotes = listOf(
        "තොරතුරු සහ සන්නිවේදන තාක්ෂණය දෙවන වාර විභාග ප්‍රශ්න පත්‍ර සංග්‍රහය සහ ලකුණු දීමේ පටිපාටිය.",
        "පද්ධති සංවර්ධන ජීවන චක්‍රය (SDLC): අවශ්‍යතා හඳුනාගැනීම, පද්ධති නිර්මාණය, ක්‍රමලේඛනය, පරීක්ෂාව සහ නඩත්තුව.",
        "දත්ත සමුදාය කළමනාකරණය (DBMS): සබඳතා දත්ත සමුදාය (RDBMS), ප්‍රාථමික යතුරු (Primary Key), විදේශ යතුරු (Foreign Key) සහ SQL විමසුම්.",
        "වෙබ් අඩවි නිර්මාණය (HTML, CSS): මූලික ටැග (Tags), වගු, ආකෘති පත්‍ර (Forms) සහ CSS මෝස්තර නිර්මාණය.",
        "ක්‍රමලේඛනය (Pascal / Python): විචල්‍ය, පාලන ව්‍යුහ (තේරීම් හා පුනරාවර්තන) සහ ඇල්ගොරිතම ගැලීම් සටහන් (Flowcharts)."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ප්‍රධාන පද්ධති සංවර්ධන ආකෘති සංසන්දනය",
          header1 = "ආකෘතිය (Model)",
          header2 = "ක්‍රියාකාරීත්වය",
          header3 = "වාසි සහ සීමා",
          rows = listOf(
            TableRowData("දියඇලි ආකෘතිය (Waterfall)", "පියවරෙන් පියවර රේඛීයව ඉදිරියට ගමන් කරයි", "සරලයි, නමුත් වෙනස්කම් සිදුකිරීම අපහසුයි"),
            TableRowData("සර්පිල ආකෘතිය (Spiral)", "අවදානම් කළමනාකරණය සමඟ චක්‍රීයව සිදුකෙරේ", "විශාල ව්‍යාපෘති සඳහා සුදුසුයි, මිල අධිකයි"),
            TableRowData("පුනරාවර්තන ආකෘතිය (Iterative)", "කුඩා කොටස් වශයෙන් වර්ධනය කෙරේ", "පරිශීලක ප්‍රතිචාර අනුව නම්‍යශීලීව වෙනස් කළ හැක")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "SDLC හි ප්‍රධාන පියවර 5 මතක තබා ගැනීම",
          mnemonicSentence = "හඳුනාගත්තා - සැලසුම් කළා - ලිව්වා - පරික්ෂා කළා - නඩත්තු කළා!",
          explanation = "1. Identification 2. Design 3. Coding 4. Testing 5. Maintenance",
          appliesTo = "System Development Life Cycle"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "දත්ත සමුදායක එක් එක් වාර්තාව (Record) අනන්‍යව හඳුනාගැනීමට යොදාගන්නා යතුර කුමක්ද?",
          type = "MCQ",
          options = listOf("1. ප්‍රාථමික යතුර (Primary Key)", "2. විදේශ යතුර (Foreign Key)", "3. ද්විතීයික යතුර", "4. සංයුක්ත යතුර"),
          correctAnswer = "1. ප්‍රාථමික යතුර (Primary Key)",
          markingScheme = "වාර්තාවක් අනන්‍යව හඳුනාගන්නේ ප්‍රාථමික යතුර (Primary Key) මඟිනි. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1tWdUdL3DJTVUNWkmXfACdcIJKMjIZhLc/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "ict_g11_term2_papers_custom",
          title = "11 ශ්‍රේණිය තොරතුරු හා සන්නිවේදන තාක්ෂණය දෙවන වාර විභාග ප්‍රශ්න පත්‍ර 01 (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1tWdUdL3DJTVUNWkmXfACdcIJKMjIZhLc/preview",
          uploadDate = "2026-08-30",
          fileSize = "4.9 MB",
          type = "PAPER"
        ),
        AttachedGoogleDrivePdf(
          id = "ict_g11_term2_papers_custom_2",
          title = "11 ශ්‍රේණිය තොරතුරු හා සන්නිවේදන තාක්ෂණය දෙවන වාර විභාග ප්‍රශ්න පත්‍ර 02 (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1hNaVPfSS76_2Svm_f8H_J4DuBJaKvSYY/preview",
          uploadDate = "2026-08-30",
          fileSize = "5.1 MB",
          type = "PAPER"
        )
      )
    ),

    // --------------------------------------------------------------------------
    // GRADE 11 - CIVIC EDUCATION (11 වසර පුරවැසි අධ්‍යාපනය)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g11_civic_u1",
      grade = "11",
      subject = "පුරවැසි අධ්‍යාපනය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "11 ශ්‍රේණිය පුරවැසි දෙවන වාර විභාග ප්‍රශ්න පත්‍ර",
      unitTitleEnglish = "Grade 11 Civic Education 2nd Term Examination Papers",
      term = "2 වන වාරය",
      summaryNotes = listOf(
        "11 ශ්‍රේණිය පුරවැසි අධ්‍යාපනය දෙවන වාර විභාග ප්‍රශ්න පත්‍ර සංග්‍රහය සහ ලකුණු දීමේ පටිපාටිය.",
        "ප්‍රජාතන්ත්‍රවාදී ආණ්ඩුකරණය සහ ශ්‍රී ලංකා ආණ්ඩුක්‍රම ව්‍යවස්ථා විකාශනය (1972 සහ 1978 ව්‍යවස්ථා).",
        "මානව හිමිකම් සහ ශ්‍රී ලංකාවේ මූලික අයිතිවාසිකම් ආරක්ෂා කිරීමේ ක්‍රමවේද සහ අධිකරණමය ක්‍රියාවලිය.",
        "ජාත්‍යන්තර සබඳතා සහ සංවිධාන: එක්සත් ජාතීන්ගේ සංවිධානය (UN), සාර්ක් සංවිධානය (SAARC) සහ පොදුරාජ්‍ය මණ්ඩලය.",
        "සමකාලීන සමාජ හා ආර්ථික අභියෝග: තිරසාර සංවර්ධනය, පරිසර සංරක්ෂණය සහ යහපාලනය."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "1972 සහ 1978 ආණ්ඩුක්‍රම ව්‍යවස්ථා සංසන්දනය",
          header1 = "ලක්ෂණය",
          header2 = "1972 පළමු ජනරජ ව්‍යවස්ථාව",
          header3 = "1978 දෙවන ජනරජ ව්‍යවස්ථාව",
          rows = listOf(
            TableRowData("රාජ්‍ය නායකත්වය", "නාමමාත්‍රික ජනාධිපති", "විධායක ජනාධිපති ක්‍රමය"),
            TableRowData("ව්‍යවස්ථාදායකය", "ජාතික රාජ්‍ය සභාව (ඒකමණ්ඩල)", "ශ්‍රී ලංකා පාර්ලිමේන්තුව (මන්ත්‍රීවරු 225)"),
            TableRowData("මැතිවරණ ක්‍රමය", "කේවල ඡන්ද ක්‍රමය (First-past-the-post)", "සමානුපාතික නියෝජන ක්‍රමය (Proportional)")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "එක්සත් ජාතීන්ගේ ප්‍රධාන ආයතන 6 මතක තබා ගැනීම",
          mnemonicSentence = "මහා සභාව - ආරක්ෂක - ආර්ථික - භාරකාර - ජාත්‍යන්තර අධිකරණය - මහලේකම් කාර්යාලය!",
          explanation = "UN General Assembly, Security Council, ECOSOC, Trusteeship, ICJ, Secretariat.",
          appliesTo = "එක්සත් ජාතීන්ගේ සංවිධානය"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "ශ්‍රී ලංකාවේ මූලික අයිතිවාසිකම් කඩවීමකදී පෙත්සම් ඉදිරිපත් කළ හැකි ඉහළම අධිකරණය කුමක්ද?",
          type = "MCQ",
          options = listOf("1. ශ්‍රේෂ්ඨාධිකරණය", "2. අභියාචනාධිකරණය", "3. මහාධිකරණය", "4. දිසා අධිකරණය"),
          correctAnswer = "1. ශ්‍රේෂ්ඨාධිකරණය",
          markingScheme = "ආණ්ඩුක්‍රම ව්‍යවස්ථාවේ 126 වගන්තිය ප්‍රකාරව මූලික අයිතිවාසිකම් අධිකරණ බලය ඇත්තේ ශ්‍රේෂ්ඨාධිකරණයට ය. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1x6ZULsQQXVR0Xgjl9X_CuVg2pSdHAxTY/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "civic_g11_term2_papers_custom",
          title = "11 ශ්‍රේණිය පුරවැසි දෙවන වාර විභාග ප්‍රශ්න පත්‍ර (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1x6ZULsQQXVR0Xgjl9X_CuVg2pSdHAxTY/preview",
          uploadDate = "2026-08-30",
          fileSize = "4.8 MB",
          type = "PAPER"
        )
      )
    ),

    // --------------------------------------------------------------------------
    // GRADE 11 - ART (11 වසර චිත්‍ර කලාව)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g11_art_u1",
      grade = "11",
      subject = "චිත්‍ර",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "11 ශ්‍රේණිය චිත්‍ර සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍ර",
      unitTitleEnglish = "Grade 11 Art G.C.E. O/L Exam Papers",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "ශ්‍රී ලංකාවේ සාම්ප්‍රදායික චිත්‍ර හා මූර්ති කලාව: අනුරාධපුර, පොළොන්නරු, දඹදෙණිය, මහනුවර යුගවල කලා ලක්ෂණ සහ විහාර බිතුසිතුවම්.",
        "ලෝක කලා ඉතිහාසය: පුනරුද යුගය (ලියනාඩෝ ඩා වින්චි, මයිකල් ආන්ජලෝ, රෆායෙල්), අභිප්‍රේරකවාදය (Impressionism), ඝනකවාදය (Cubism - පැබ්ලෝ පිකාසෝ).",
        "චිත්‍ර නිර්මාණ මූලධර්ම සහ සංයුතිය: රේඛාව, හැඩතල, වර්ණ න්‍යාය (ප්‍රාථමික, ද්විතීයික, තෘතීයික, අනුපූරක වර්ණ), ආලෝකය හා අඳුර, පරිදර්ශනය (Perspective).",
        "අ.පො.ස. සාමාන්‍ය පෙළ චිත්‍ර කලා ප්‍රශ්න පත්‍ර ව්‍යුහය: I කොටස බහුවරණ ප්‍රශ්න 40 සහ II කොටස ප්‍රායෝගික චිත්‍ර නිර්මාණය හා කලා ඉතිහාසය."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ලෝක ප්‍රකට කලාකරුවන් සහ ප්‍රධාන කලා කෘති සංසන්දනය",
          header1 = "කලාකරුවා (Artist)",
          header2 = "කලා සම්ප්‍රදාය / යුගය",
          header3 = "ප්‍රකට නිර්මාණ (Masterpieces)",
          rows = listOf(
            TableRowData("ලියනාඩෝ ඩා වින්චි (Leonardo da Vinci)", "උසස් පුනරුද යුගය (High Renaissance)", "මොනාලිසා (Mona Lisa), අවසන් භෝජන සංග්‍රහය (The Last Supper)"),
            TableRowData("මයිකල් ආන්ජලෝ (Michelangelo)", "ඉතාලි පුනරුද යුගය", "සිස්ටින් දේවස්ථාන සිවිලිමේ සිතුවම්, ඩේවිඩ් ප්‍රතිමාව, පියෙටා"),
            TableRowData("වින්සන්ට් වැන්ගෝ (Vincent van Gogh)", "පශ්චාත් අභිප්‍රේරකවාදය (Post-Impressionism)", "තරු පිරි රැය (The Starry Night), සූරියකාන්ත මල් (Sunflowers)"),
            TableRowData("පැබ්ලෝ පිකාසෝ (Pablo Picasso)", "ඝනකවාදය (Cubism)", "ගුවර්නිකා (Guernica), ඇවිග්නන්හි යුවතියෝ")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "ප්‍රාථමික වර්ණ (Primary Colors) මතක තබා ගැනීම",
          mnemonicSentence = "රතු, කහ, නිල් - මූලික වර්ණ තුනයි!",
          explanation = "වෙනත් වර්ණ මිශ්‍ර කිරීමෙන් ලබාගත නොහැකි මූලික වර්ණ 3 වන්නේ රතු, කහ සහ නිල් ය.",
          appliesTo = "වර්ණ න්‍යාය"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "ලොව ප්‍රකට 'මොනාලිසා' සිතුවම නිර්මාණය කළ ශ්‍රේෂ්ඨ පුනරුද කලාකරුවා කවුද?",
          type = "MCQ",
          options = listOf("1. ලියනාඩෝ ඩා වින්චි", "2. මයිකල් ආන්ජලෝ", "3. රෆායෙල්", "4. පැබ්ලෝ පිකාසෝ"),
          correctAnswer = "1. ලියනාඩෝ ඩා වින්චි",
          markingScheme = "මොනාලිසා (Mona Lisa) සිතුවම ලියනාඩෝ ඩා වින්චි විසින් අඳින ලදී. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1sgIxFoMazNG1VeFlG0EcZH28oq-mrk9Y/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "art_g11_ol_papers_custom_1",
          title = "11 ශ්‍රේණිය චිත්‍ර සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍ර",
          driveUrl = "https://drive.google.com/file/d/1sgIxFoMazNG1VeFlG0EcZH28oq-mrk9Y/preview",
          uploadDate = "2026-08-30",
          fileSize = "5.4 MB",
          type = "PAPER"
        )
      )
    ),

    // --------------------------------------------------------------------------
    // GRADE 10 - SINHALA LANGUAGE & LITERATURE (10 වසර සිංහල)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g10_sinhala_u1",
      grade = "10",
      subject = "සිංහල",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "10 ශ්‍රේණිය සිංහල පළමු වාර පරීක්ෂණ ප්‍රශ්න පත්‍ර හා කෙටි සටහන්",
      unitTitleEnglish = "Grade 10 Sinhala 1st Term Test Papers & Notes",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "සිංහල ව්‍යාකරණ මූලධර්ම: අක්ෂර වින්‍යාසය, ණ, ණ, ල, ළ භේදය, ප්‍රකෘති හා ප්‍රත්‍ය, සන්ධි සහ සමාස නීති.",
        "වාක්‍ය රීති හා විරාම ලක්ෂණ: උක්ත ආඛ්‍යාත සම්බන්ධය, කර්මකාරක වාක්‍ය හා නිවැරදි විරාම ලක්ෂණ භාවිතය.",
        "10 ශ්‍රේණිය සාහිත්‍ය නිර්මාණ රසවින්දනය: සම්භාව්‍ය පද්‍ය හා ගද්‍ය පාඩම්, කාව්‍යාලංකාර (උපමා, රූපක, උත්ප්‍රේක්ෂා).",
        "පළමු වාර පරීක්ෂණ ආදර්ශ ප්‍රශ්න පත්‍ර: බහුවරණ ප්‍රශ්න (I පත්‍රය) සහ රචනා, ලඝු ලේඛන හා ගද්‍ය/පද්‍ය ප්‍රශ්න (II පත්‍රය)."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "සිංහල ව්‍යාකරණයේ ප්‍රධාන සන්ධි වර්ග සංසන්දනය",
          header1 = "සන්ධි වර්ගය",
          header2 = "නීතිය / ලක්ෂණය",
          header3 = "උදාහරණ",
          rows = listOf(
            TableRowData("ස්වර සන්ධිය", "පූර්ව ස්වරය ලොප් වී පර ස්වරය හා එක්වීම", "ගුරු + උතුමා = ගුරුතුමා"),
            TableRowData("ව්‍යඤ්ජන සන්ධිය", "පෙර වචනයේ අග ව්‍යඤ්ජනය හා එක්වීම", "වත් + කම = වත්කම"),
            TableRowData("ගාත්‍රාදේශ සන්ධිය", "පර වචනයේ මුල් අකුර වෙනත් අකුරක් වීම", "පිය + පස = පියවස")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "උක්ත ආඛ්‍යාත සම්බන්ධය මතක තබා ගැනීම",
          mnemonicSentence = "කර්තෘ උක්ත නම් ආඛ්‍යාතය කර්තෘකාරකයි, කර්මය උක්ත නම් ආඛ්‍යාතය කර්මකාරකයි!",
          explanation = "උක්තය ඒකවචන නම් ක්‍රියාව ඒකවචන ද, උක්තය බහුවචන නම් ක්‍රියාව බහුවචන ද විය යුතුය.",
          appliesTo = "සිංහල වාක්‍ය රීති"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "පහත දැක්වෙන වාක්‍යයේ උක්ත පදය නිවැරදිව තෝරන්න: 'ගුරුවරු සිසුන්ට කරුණාවෙන් උගන්වති.'",
          type = "MCQ",
          options = listOf("1. ගුරුවරු", "2. සිසුන්ට", "3. කරුණාවෙන්", "4. උගන්වති"),
          correctAnswer = "1. ගුරුවරු",
          markingScheme = "වාක්‍යයේ ක්‍රියාව සිදු කරන ප්‍රධාන උක්ත පදය 'ගුරුවරු' (බහුවචන ප්‍රථමා විභක්තිය) වේ. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1s9juSH9Kyv6rjI6BKE5v8vaHC_4t8hiY/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "sinhala_g10_term1_papers_custom",
          title = "10 ශ්‍රේණිය සිංහල පළමු වාර පරීක්ෂණ ප්‍රශ්න පත්‍ර (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1s9juSH9Kyv6rjI6BKE5v8vaHC_4t8hiY/preview",
          uploadDate = "2026-08-26",
          fileSize = "4.2 MB",
          type = "PAPER"
        )
      )
    ),

    // --------------------------------------------------------------------------
    // GRADE 10 - MATHEMATICS (10 වසර ගණිතය කෙටි සටහන්)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g10_math_u1",
      grade = "10",
      subject = "ගණිතය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "10 ශ්‍රේණිය ගණිතය පූර්ණ කෙටි සටහන් හා සූත්‍ර සංග්‍රහය",
      unitTitleEnglish = "Grade 10 Mathematics Comprehensive Short Notes & Formulae",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "වීජීය ප්‍රකාශන හා සාධක: ත්‍රිපද වර්ගජ ප්‍රකාශන සාධක වෙන්කිරීම, වර්ග දෙකක අන්තරය සහ පොදු සාධක ගැනීම.",
        "භාග සහ ප්‍රතිශත: වීජීය භාග එකතු කිරීම/අඩු කිරීම, සුළු පොලිය සහ වට්ටම් ගණනය.",
        "සංඛ්‍යාතය සහ කේන්ද්‍රික ප්‍රවණතා මිනුම්: මාතය, මධ්‍යස්ථය, මධ්‍යන්‍යය ගණනය සහ සමුච්චිත සංඛ්‍යාත වක්‍රය (ඕජීවය).",
        "ජ්‍යාමිතිය සහ ප්‍රමේය: ත්‍රිකෝණ අංගසාම්‍යය, සමාන්තරාස්‍ර ප්‍රමේය, වෘත්තයක කෝණ සහ පයිතගරස් ප්‍රමේයය.",
        "ඝන වස්තුවල වර්ගඵලය හා පරිමාව: සිලින්ඩරය, ප්‍රිස්මය, කේතුව සහ ගෝලය ආශ්‍රිත සූත්‍ර හා ගණනය කිරීම්."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ප්‍රධාන ඝන වස්තුවල පරිමා සූත්‍ර සංසන්දනය",
          header1 = "ඝන වස්තුව (Solid)",
          header2 = "වක්‍ර මතුපිට වර්ගඵලය",
          header3 = "පරිමාව (Volume Formula)",
          rows = listOf(
            TableRowData("සිලින්ඩරය (Cylinder)", "2πrh", "V = πr²h"),
            TableRowData("කේතුව (Cone)", "πrl (l = ඇල උස)", "V = 1/3 πr²h"),
            TableRowData("ගෝලය (Sphere)", "4πr²", "V = 4/3 πr³"),
            TableRowData("අර්ධ ගෝලය (Hemisphere)", "2πr² (මුළු = 3πr²)", "V = 2/3 πr³")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "සිලින්ඩරය සහ කේතුවේ පරිමා සම්බන්ධය",
          mnemonicSentence = "එකම උස හා අරය ඇති සිලින්ඩරයකට කේතු 3ක වතුර දමන්න පුළුවන්!",
          explanation = "කේතුවේ පරිමාව = 1/3 × සිලින්ඩරයේ පරිමාව (V = 1/3 πr²h).",
          appliesTo = "පරිමා සූත්‍ර"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "අරය 7 cm සහ උස 10 cm වූ ඝන සිලින්ඩරයක පරිමාව කොපමණද? (π = 22/7 ලෙස ගන්න)",
          type = "STRUCTURED",
          correctAnswer = "1540 cm³",
          markingScheme = "• V = πr²h = (22/7) × 7 × 7 × 10 (ලකුණු 2) • V = 22 × 7 × 10 = 1540 cm³ (ලකුණු 2). මුළු ලකුණු 4.",
          marksAllocated = 4
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1eZoyYZlqf8cu94iUaqp50wYgHEUDSuLk/preview",
      attachedDrivePdfs = mutableListOf()
    ),

    // --------------------------------------------------------------------------
    // GRADE 11 - HISTORY (11 වසර ඉතිහාසය)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g11_hist_u1",
      grade = "11",
      subject = "ඉතිහාසය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "ශ්‍රී ලංකාවේ බ්‍රිතාන්‍ය බලය තහවුරු වීම (1796-1833)",
      unitTitleEnglish = "Establishment of British Power in Sri Lanka",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "1796 දී ලන්දේසීන්ගෙන් මුහුදුබඩ ප්‍රදේශ බ්‍රිතාන්‍යයන් අතට පත්විය.",
        "1802 ඒමියන්ස් ගිවිසුම මඟින් ශ්‍රී ලංකාවේ මුහුදුබඩ ප්‍රදේශ බ්‍රිතාන්‍ය කිරීටයේ යටත් විජිතයක් බවට පත්විය.",
        "1815 මාර්තු 02 දින උඩරට ගිවිසුම අත්සන් කිරීමෙන් මුළු දිවයිනම බ්‍රිතාන්‍ය කිරීටයට යටත් විය. ශ්‍රී වික්‍රම රාජසිංහ රජු සිරභාරයට ගැනිණි.",
        "1817-1818 ඌව වෙල්ලස්ස නිදහස් අරගලය: නායකත්වය - කැප්පෙටිපොළ නිලමේ, මඩුගල්ලේ නිලමේ, කිවුලේගෙදර මොහොට්ටාල.",
        "1833 කෝල්බෲක්-කැමරන් ප්‍රතිසංස්කරණ: පළාත් 5ක් පිහිටුවීම, රාජකාරි ක්‍රමය අහෝසි කිරීම, ව්‍යවස්ථාදායක හා විධායක සභා පිහිටුවීම."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "1818 සහ 1848 නිදහස් අරගල සංසන්දනය",
          header1 = "ලක්ෂණය",
          header2 = "1818 ඌව වෙල්ලස්ස අරගලය",
          header3 = "1848 මාතලේ නිදහස් අරගලය",
          rows = listOf(
            TableRowData("නායකත්වය", "කැප්පෙටිපොළ, මඩුගල්ලේ නිලමේවරු", "වීර පුරන් අප්පු, ගොන්ගාලේගොඩ බණ්ඩා"),
            TableRowData("ප්‍රධාන හේතුව", "උඩරට සම්මුතිය කඩවීම, සංස්කෘතික හා ආගමික නොසලකා හැරීම්", "අසාධාරණ බදු පැනවීම (බලු බද්ද, තුවක්කු බද්ද, කරත්ත බද්ද)"),
            TableRowData("ස්වභාවය", "රාජ්‍යත්වය යළි ලබාගැනීමේ රදළ/වැසියන්ගේ සටනක්", "නව ධනපති/පීඩිත පොදු ජනතා අරගලයක්")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "කෝල්බෲක් ප්‍රතිසංස්කරණ 4ක් මතක තබා ගැනීම",
          mnemonicSentence = "පළාත් 5යි - රාජකාරි බායි - සභා 2යි - ඉංග්‍රීසි හයි!",
          explanation = "1. පළාත් 5කට බෙදීම, 2. රාජකාරි අහෝසිය, 3. විධායක/ව්‍යවස්ථාදායක සභා 2, 4. ඉංග්‍රීසි අධ්‍යාපනය ඇරඹීම.",
          appliesTo = "Colebrooke Reforms (1833)"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "1815 උඩරට ගිවිසුම අත්සන් කළ දිනය සහ ඉංග්‍රීසි ආණ්ඩුකාරවරයා කවුද?",
          type = "SHORT",
          correctAnswer = "1815 මාර්තු 02 වන දින, ශ්‍රීමත් රොබට් බ්‍රවුන්රිග් ආණ්ඩුකාරවරයා.",
          markingScheme = "• 1815 මාර්තු 02 (ලකුණු 2) • රොබට් බ්‍රවුන්රිග් (ලකුණු 2). මුළු ලකුණු 4.",
          marksAllocated = 4
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1f0MXkYCXZVwJWUzZc49bDx6tRSW8HFJa/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "hist_g11_ol_papers_custom",
          title = "11 ශ්‍රේණිය ඉතිහාසය සාමාන්‍ය පෙළ ප්‍රශ්න පත්‍ර (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1wrTWGsV7mwS3muCKjZVubP1RMvcXg0e5/preview",
          uploadDate = "2026-08-26",
          fileSize = "4.6 MB",
          type = "PAPER"
        ),
        AttachedGoogleDrivePdf(
          id = "hist_g11_term2_papers_custom_1",
          title = "11 ශ්‍රේණිය ඉතිහාසය දෙවන වාර විභාග ප්‍රශ්න පත්‍ර (ප්‍රශ්න පත්‍ර 01)",
          driveUrl = "https://drive.google.com/file/d/1-5nRVDmp5Yw5usg5mPuz4GGBHv36gZm5/preview",
          uploadDate = "2026-08-26",
          fileSize = "4.4 MB",
          type = "PAPER"
        ),
        AttachedGoogleDrivePdf(
          id = "hist_g11_term2_papers_custom_2",
          title = "11 ශ්‍රේණිය ඉතිහාසය දෙවන වාර විභාග ප්‍රශ්න පත්‍ර (ප්‍රශ්න පත්‍ර 02)",
          driveUrl = "https://drive.google.com/file/d/1xDVjFIjfK8cTl1wmnin8BHZGN471d7Uq/preview",
          uploadDate = "2026-08-26",
          fileSize = "4.5 MB",
          type = "PAPER"
        ),
        AttachedGoogleDrivePdf(
          id = "hist_g11_term3_papers_custom",
          title = "11 ශ්‍රේණිය ඉතිහාසය තෙවන වාර විභාග ප්‍රශ්න පත්‍ර (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1vI4GmSXIgL50dtVJwPNgR1Wjifj3C82W/preview",
          uploadDate = "2026-08-26",
          fileSize = "4.7 MB",
          type = "PAPER"
        ),
        AttachedGoogleDrivePdf(
          id = "hist_g11_images_activity",
          title = "9, 10, 11 ශ්‍රේණි - ඉතිහාසය රූපසටහන් හඳුනාගැනීම හා හිස්තැන් පිරවීම (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1_E6UIPUBNjYVrM7lQ6XVLjl50JfVUGak/preview",
          uploadDate = "2026-08-28",
          fileSize = "4.8 MB",
          type = "NOTE"
        )
      )
    ),

    // --------------------------------------------------------------------------
    // GRADE 11 - ART (11 වසර චිත්‍ර කලාව)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g11_art_u1",
      grade = "11",
      subject = "චිත්‍ර කලාව",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "11 ශ්‍රේණිය චිත්‍ර කලාව සහ මූර්ති සම්ප්‍රදායන්",
      unitTitleEnglish = "Grade 11 Art & Sculpture Traditions",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "ශ්‍රී ලාංකේය චිත්‍ර සම්ප්‍රදායන්: සීගිරි බිතුසිතුවම්, අනුරාධපුර, පොළොන්නරු හා මහනුවර යුගයේ චිත්‍ර කලාවේ විකාශනය හා ශෛලීන්.",
        "සීගිරි බිතුසිතුවම්: කැටපත් පවුර, අප්සරා රූප, වර්ණ භාවිතය (කහ, රතු, කොළ, දුඹුරු) සහ තාක්ෂණය (තෙත බදාම ක්‍රමය - Buon Fresco).",
        "මහනුවර යුගයේ විහාර බිතුසිතුවම්: දෙගල්දොරුව, රිදී විහාරය, දඹුල්ල සහ සූරියගොඩ විහාර සිතුවම්. රේඛීය බව, තලීය ස්වභාවය සහ කහ/රතු ප්‍රමුඛ වර්ණ.",
        "ලෝක කලා සම්ප්‍රදායන්: පුනරුද යුගය (ලියනාඩෝ ඩා වින්චි, මයිකල් ආන්ජලෝ, රෆායෙල්) සහ නූතන කලා ප්‍රවණතා (ඉම්ප්‍රෙෂනිසම්, කියුබිසම්).",
        "වර්ණ න්‍යාය සහ නිර්මාණ ආකෘති: ප්‍රාථමික, ද්විතීයික හා තෘතීයික වර්ණ, සංයුතිය, රිද්මය, සමබරතාවය හා අවකාශ භාවිතය."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "සීගිරි සිතුවම් vs මහනුවර යුගයේ සිතුවම් සංසන්දනය",
          header1 = "ලක්ෂණය",
          header2 = "සීගිරි බිතුසිතුවම්",
          header3 = "මහනුවර යුගයේ බිතුසිතුවම්",
          rows = listOf(
            TableRowData("මාතෘකාව", "අප්සරාවන් (දේවතා ස්ත්‍රීන්) සහ වලාකුළු කුමරියන්", "ජාතක කතා, සූවිසි විවරණ සහ බුද්ධ චරිතය"),
            TableRowData("තාක්ෂණය", "තෙත බදාම (Fresco/Tempera සංකලනය)", "වියළි බදාම (Fresco Secco) ක්‍රමය"),
            TableRowData("වර්ණ හා රේඛා", "ත්‍රිමාණත්වය, ස්වභාවික වර්ණ සංක්‍රාන්ති", "ද්විමාණ තලීය බව, තද කළු/රතු පිටත රේඛා")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "පුනරුද යුගයේ ප්‍රධාන චිත්‍ර ශිල්පීන් තිදෙනා",
          mnemonicSentence = "ලියනාඩෝ - මයිකල් - රෆායෙල් (කලා ලෝකයේ මහා ත්‍රිත්වය)!",
          explanation = "Leonardo da Vinci, Michelangelo, Raphael පුනරුද සමයේ මහා කලාකරුවන් තිදෙනාය.",
          appliesTo = "Renaissance Art"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "සීගිරි බිතුසිතුවම්වල දක්නට නොලැබෙන ප්‍රධාන වර්ණය කුමක්ද?",
          type = "MCQ",
          options = listOf("1. නිල් වර්ණය", "2. කහ වර්ණය", "3. රතු වර්ණය", "4. කොළ වර්ණය"),
          correctAnswer = "1. නිල් වර්ණය",
          markingScheme = "සීගිරි බිතුසිතුවම් සඳහා නිල් වර්ණය (Blue pigment) භාවිත කර නොමැත. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1yDDZxJOdSIZt--KyTdJzKNx0hHmYQOYe/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "art_g11_ol_papers_custom_1",
          title = "11 ශ්‍රේණිය චිත්‍ර කලාව සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍ර",
          driveUrl = "https://drive.google.com/file/d/1sgIxFoMazNG1VeFlG0EcZH28oq-mrk9Y/preview",
          uploadDate = "2026-08-30",
          fileSize = "5.5 MB",
          type = "PAPER"
        )
      )
    ),

    // --------------------------------------------------------------------------
    // GRADE 10 - HISTORY (10 වසර ඉතිහාසය)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g10_hist_u1",
      grade = "10",
      subject = "ඉතිහාසය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "10 ශ්‍රේණිය ඉතිහාසය පූර්ණ කෙටි සටහන් සංග්‍රහය",
      unitTitleEnglish = "Grade 10 History Comprehensive Short Notes",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "ඉතිහාසය හැදෑරීමේ මූලාශ්‍ර: සාහිත්‍ය මූලාශ්‍ර (දීපවංසය, මහාවංසය, ථූපවංසය ආදී) සහ පුරාවිද්‍යාත්මක මූලාශ්‍ර (සෙල්ලිපි, කාසි, නටබුන්, චිත්‍ර හා මූර්ති).",
        "ශ්‍රී ලංකාවේ ප්‍රාග් ඓතිහාසික යුගය: පාහියංගල, බටදොඹලෙන, බෙල්ලන්බැඳිපැලැස්ස සහ බලංගොඩ මානවයා (Homo sapiens balangodensis).",
        "මුල් ඓතිහාසික යුගය හා ජනාවාස ව්‍යාප්තිය: විජයාවතරණය, පණ්ඩුකාභය රජුගේ අනුරාධපුර නගර නිර්මාණය සහ පරිපාලන ව්‍යුහය.",
        "දේවානම්පියතිස්ස රජ සමය සහ මහින්දාගමනය: බුදුදහම මෙරට ස්ථාපිත වීම, සංස්කෘතික හා දේශපාලනික පුනරුදය.",
        "පුරාණ වාරි ශිෂ්ටාචාරය සහ ගොවිතැන: වැව් හා ඇළ මාර්ග පද්ධතිය (ඇළහැර, මින්නේරිය, කලා වැව, ජය ගඟ)."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ඉතිහාස මූලාශ්‍ර වර්ගීකරණය සංසන්දනය",
          header1 = "මූලාශ්‍ර වර්ගය",
          header2 = "උදාහරණ",
          header3 = "විශේෂ වැදගත්කම",
          rows = listOf(
            TableRowData("සාහිත්‍ය මූලාශ්‍ර (දේශීය)", "දීපවංසය, මහාවංසය, පූජාවලිය", "ඓතිහාසික සිදුවීම් කාලානුක්‍රමිකව දැක්වීම"),
            TableRowData("සාහිත්‍ය මූලාශ්‍ර (විදේශීය)", "ටොලමිගේ වාර්තා, ෆාහියන් හිමිගේ වාර්තා", "විදේශීය ඇසින් අපේ රටේ තොරතුරු තහවුරු කිරීම"),
            TableRowData("පුරාවිද්‍යා මූලාශ්‍ර", "සෙල්ලිපි, කාසි, ස්මාරක, මැටි බඳුන්", "වඩාත් විශ්වාසදායක හා අපක්ෂපාතී සාක්ෂි සපයයි")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "අනුරාධපුර නගර නිර්මාතෘ සහ පළමු සංවිධානාත්මක රජු",
          mnemonicSentence = "පණ්ඩුකාභය රජතුමා = අනුරාධපුර සැලසුම් නගර ශිල්පියා!",
          explanation = "ග්‍රාම සීමා නියම කළේ, පළමු නගර පාලක (නගරගුත්තික) පත් කළේ පණ්ඩුකාභය රජතුමාය.",
          appliesTo = "Early Kings"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "ශ්‍රී ලංකාවේ දැනට හමුවී ඇති පැරණිතම සෙල්ලිපි අයත් වන අක්ෂර මාලාව කුමක්ද?",
          type = "MCQ",
          options = listOf("1. බ්‍රාහ්මී අක්ෂර", "2. නාගරී අක්ෂර", "3. පල්ලව අක්ෂර", "4. ග්‍රන්ථ අක්ෂර"),
          correctAnswer = "1. බ්‍රාහ්මී අක්ෂර",
          markingScheme = "ක්‍රි.පූ. 3 වන සියවසට අයත් මුල්ම සෙල්ලිපි ලියා ඇත්තේ මුල් බ්‍රාහ්මී අක්ෂර වලිනි. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1me8zGLCFdLyrRMUWnVtICcT8oGQZUqMv/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "hist_g10_term3_papers_custom",
          title = "10 ශ්‍රේණිය ඉතිහාසය තෙවන වාර විභාග ප්‍රශ්න පත්‍ර (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1WDen4EKvIu6TfH1QR1KOOzEzAt8IRGby/preview",
          uploadDate = "2026-08-26",
          fileSize = "4.6 MB",
          type = "PAPER"
        ),
        AttachedGoogleDrivePdf(
          id = "hist_g10_images_activity",
          title = "9, 10, 11 ශ්‍රේණි - ඉතිහාසය රූපසටහන් හඳුනාගැනීම හා හිස්තැන් පිරවීම (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1_E6UIPUBNjYVrM7lQ6XVLjl50JfVUGak/preview",
          uploadDate = "2026-08-28",
          fileSize = "4.8 MB",
          type = "NOTE"
        )
      )
    ),

    // --------------------------------------------------------------------------
    // GRADE 10 - ART (10 වසර චිත්‍ර කලාව)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g10_art_u1",
      grade = "10",
      subject = "චිත්‍ර කලාව",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "10 ශ්‍රේණිය චිත්‍ර කලාව පූර්ණ කෙටි සටහන් සංග්‍රහය",
      unitTitleEnglish = "Grade 10 Art & Design Comprehensive Short Notes",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "දෘශ්‍ය කලාවේ මූලිකාංග: රේඛාව, හැඩතල, රූපාකාර, වයනය, අවකාශය, අගය (Value) සහ වර්ණය පිළිබඳ ගැඹුරු හැදෑරීම.",
        "වර්ණ න්‍යාය සහ වර්ණ රෝදය: ප්‍රාථමික වර්ණ (රතු, කහ, නිල්), ද්විතීයික වර්ණ (තැඹිලි, කොළ, දම්), තෘතීයික වර්ණ, උණුසුම් හා සිසිල් වර්ණ, අනුපූරක වර්ණ.",
        "ශ්‍රී ලාංකේය සම්ප්‍රදායික මෝස්තර කලාව: ලියවැල්, පලාපෙති, වෘක්ෂලතා, සත්ත්ව රූ (හංස, ඇත්, සිංහ, මකර) සහ ජ්‍යාමිතික මෝස්තර.",
        "ශ්‍රී ලංකාවේ ප්‍රාග් ඓතිහාසික ගුහා සිතුවම්: තන්තිරිමලේ, බිල්ලෑව, දොරවකලෙන ආශ්‍රිත සිතුවම් ලක්ෂණ හා වර්ණ භාවිතය.",
        "සංයුති මූලධර්ම: සමබරතාවය (සමමිතික හා අසමමිතික), රිද්මය, එකමුතුකම, අවධාරණය සහ සමානුපාතිකත්වය."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "වර්ණ කාණ්ඩ සහ ඒවායේ මිශ්‍රණ සංසන්දනය",
          header1 = "වර්ණ කාණ්ඩය",
          header2 = "සංයුතිය / සෑදෙන ආකාරය",
          header3 = "උදාහරණ",
          rows = listOf(
            TableRowData("ප්‍රාථමික වර්ණ (Primary)", "වෙනත් වර්ණ මිශ්‍ර කිරීමෙන් සෑදිය නොහැක", "රතු, කහ, නිල්"),
            TableRowData("ද්විතීයික වර්ණ (Secondary)", "ප්‍රාථමික වර්ණ දෙකක් සමානව මිශ්‍ර කිරීමෙන්", "තැඹිලි (රතු+කහ), කොළ (කහ+නිල්), දම් (රතු+නිල්)"),
            TableRowData("අනුපූරක වර්ණ (Complementary)", "වර්ණ රෝදයේ එකිනෙකට මුහුණලා පිහිටි වර්ණ", "රතු-කොළ, කහ-දම්, නිල්-තැඹිලි")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "ද්විතීයික වර්ණ සාදන ආකාරය",
          mnemonicSentence = "රතු+කහ = තැඹිලි / කහ+නිල් = කොළ / රතු+නිල් = දම්!",
          explanation = "මූලික වර්ණ මිශ්‍ර කිරීමෙන් ද්විතීයික වර්ණ ලැබෙන ක්‍රමය.",
          appliesTo = "වර්ණ මිශ්‍රණ"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "වර්ණ රෝදයේ රතු වර්ණයට අනුපූරක (මුහුණලා පිහිටි) වර්ණය කුමක්ද?",
          type = "MCQ",
          options = listOf("1. කොළ වර්ණය", "2. කහ වර්ණය", "3. නිල් වර්ණය", "4. තැඹිලි වර්ණය"),
          correctAnswer = "1. කොළ වර්ණය",
          markingScheme = "රතු වර්ණයේ අනුපූරක (Complementary) වර්ණය කොළ වර්ණයයි. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1z4Q0vRbaB20E7-EFqFU-hlU_Uoy2LwcW/preview",
      attachedDrivePdfs = mutableListOf()
    ),

    // --------------------------------------------------------------------------
    // GRADE 10 - SCIENCE (10 වසර විද්‍යාව)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g10_sci_u1",
      grade = "10",
      subject = "විද්‍යාව",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "ජීවයේ ඒකකය - සෛලය (The Cell)",
      unitTitleEnglish = "The Cell as Basic Unit of Life",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "සියලුම ජීවීන්ගේ ව්‍යුහාත්මක හා කෘත්‍යමය මූලික ඒකකය සෛලයයි.",
        "සෛල වාදය ඉදිරිපත් කළ විද්‍යාඥයින්: මැතියස් ශ්ලයිඩන්, තියඩෝර් ශ්වාන් සහ රුඩොල්ෆ් වර්චව්.",
        "ප්‍රධාන ඉන්ද්‍රයිකා: න්‍යෂ්ටිය (ජානමය පාලනය), මයිටොකොන්ඩ්‍රියා (සෛලීය ශ්වසනය සහ ATP බලශක්ති බලාගාරය), හරිතලව (ප්‍රභාසංශ්ලේෂණය), රයිබොසෝම (ප්‍රෝටීන සංස්ලේෂණය), සෛල බිත්තිය (ශාකවල පමණක් ඇත - සෙලියුලෝස් වලින් සෑදී ඇත)."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ශාක සෛල vs සත්ත්ව සෛල සංසන්දනය (Plant vs Animal Cell)",
          header1 = "ලක්ෂණය",
          header2 = "ශාක සෛලය (Plant Cell)",
          header3 = "සත්ත්ව සෛලය (Animal Cell)",
          rows = listOf(
            TableRowData("සෛල බිත්තිය", "පවතී (සෙලියුලෝස් සහිතයි)", "නොපවතී"),
            TableRowData("හරිතලව (Chloroplasts)", "පවතී", "නොපවතී"),
            TableRowData("රික්තකය", "මධ්‍යයේ විශාල ස්ථිර රික්තකයක් ඇත", "කුඩා තාවකාලික රික්තක ඇත"),
            TableRowData("කේන්ද්‍රදේහ (Centrosomes)", "නොපවතී (උසස් ශාකවල)", "පවතී (සෛල බෙදීමට උපකාරී වේ)")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "සෛල වාදයේ විද්‍යාඥයින් තිදෙනා මතක තබා ගැනීම",
          mnemonicSentence = "ශ්ලයිඩන් ශාක බැලුවා - ශ්වාන් සතුන් බැලුවා - වර්චව් සෛල බෙදුවා!",
          explanation = "ශ්ලයිඩන් = ශාක සෛල, ශ්වාන් = සත්ත්ව සෛල, රුඩොල්ෆ් වර්චව් = පෙර පැවති සෛල බෙදීමෙන් නව සෛල සෑදේ.",
          appliesTo = "Cell Theory Scientists"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "සෛලයේ බලශක්ති බලාගාරය (Powerhouse of the cell) ලෙස හඳුන්වන්නේ කුමන ඉන්ද්‍රයිකාවද?",
          type = "MCQ",
          options = listOf("1. න්‍යෂ්ටිය", "2. මයිටොකොන්ඩ්‍රියාව", "3. හරිතලවය", "4. ගොල්ගි දේහය"),
          correctAnswer = "2. මයිටොකොන්ඩ්‍රියාව",
          markingScheme = "සෛලීය ශ්වසනය මඟින් ATP ශක්තිය ජනනය කරන බැවින් මයිටොකොන්ඩ්‍රියාව බලශක්ති බලාගාරයයි. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1N5TV_W4kL891IKIZETGHnMCE_rnRIPKm/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "sci_g10_pdf_1",
          title = "10 ශ්‍රේණිය විද්‍යාව කෙටි සටහන් (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1vx9uXTL_pKexaA5g0IHPa47h6eKdINZl/preview",
          uploadDate = "2026-08-18",
          fileSize = "3.5 MB",
          type = "NOTE"
        )
      )
    ),

    // --------------------------------------------------------------------------
    // GRADE 10 - MUSIC (10 වසර සංගීතය)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g10_music_u1",
      grade = "10",
      subject = "සංගීතය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "10 ශ්‍රේණිය සංගීතය පූර්ණ කෙටි සටහන් සංග්‍රහය",
      unitTitleEnglish = "Grade 10 Music Comprehensive Short Notes",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "රාග න්‍යාය හා ලක්ෂණ: භූපාලී, බිලාවල්, ඛමාජ් සහ කාෆී රාගවල ආරෝහණ, අවරෝහණ, වාදී, සංවාදී ස්වර හා ථාට වර්ගීකරණය.",
        "තාල ඥානය සහ මාත්‍රා: ත්‍රිතාලය (මාත්‍රා 16), කහර්වා තාලය (මාත්‍රා 8), දාද්‍රා තාලය (මාත්‍රා 6) සහ ඒකතාලයෙහි අංග හා ලක්ෂණ.",
        "දේශීය සංගීත සම්ප්‍රදාය: ජන ගී (නෙළුම් කවි, පැල් කවි, පාරු කවි, කරත්ත කවි) සහ නූර්ති, නාඩගම් ගීත වල ආකෘතිය.",
        "සංගීත භාණ්ඩ වර්ගීකරණය: තත (තත් භාණ්ඩ), සුසිර (සුළං භාණ්ඩ), ඝන (ඝන ලෝහ/ලී) සහ අවනද්ධ (සම් ආවරිත) වාද්‍ය භාණ්ඩ."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ප්‍රධාන උත්තර භාරතීය රාග සංසන්දනය",
          header1 = "රාගය (Raga)",
          header2 = "ථාටය (Thaat)",
          header3 = "වාදී / සංවාදී ස්වර",
          rows = listOf(
            TableRowData("භූපාලී (Bhoopali)", "කල්‍යාණ්", "ග / ධ"),
            TableRowData("කාෆී (Kafi)", "කාෆී", "ප / ස"),
            TableRowData("බිලාවල් (Bilawal)", "බිලාවල්", "ධ / ග"),
            TableRowData("ඛමාජ් (Khamaj)", "ඛමාජ්", "ග / නි")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "භූපාලී රාගයේ වර්ජිත ස්වර මතක තබා ගැනීම",
          mnemonicSentence = "භූපාලීට ම-නි නෑ (ම සහ නි ස්වර වර්ජිත ඖඩව රාගයකි)!",
          explanation = "භූපාලී රාගයේ මධ්‍යම (ම) සහ නිෂාද (නි) ස්වර නොයෙදෙන බැවින් එය ඖඩව-ඖඩව ජාතියට අයත් වේ.",
          appliesTo = "භූපාලී රාගය"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "භූපාලී රාගයේ වාදී ස්වරය සහ සංවාදී ස්වරය පිළිවෙළින් කුමක්ද?",
          type = "MCQ",
          options = listOf("1. ග සහ ධ", "2. ස සහ ප", "3. රේ සහ ප", "4. ම සහ ස"),
          correctAnswer = "1. ග සහ ධ",
          markingScheme = "භූපාලී රාගයේ වාදී ස්වරය ගාන්ධාර (ග) ද, සංවාදී ස්වරය ධෛවත (ධ) ද වේ. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1-1h9386kmqwW8lDUx5uAkzynL2MKMXVJ/preview",
      attachedDrivePdfs = mutableListOf()
    ),

    // --------------------------------------------------------------------------
    // GRADE 10 - DANCING (10 වසර නර්තනය)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g10_dance_u1",
      grade = "10",
      subject = "නර්තනය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "10 ශ්‍රේණිය දේශීය නර්තනය පූර්ණ කෙටි සටහන් සංග්‍රහය",
      unitTitleEnglish = "Grade 10 Traditional Dancing Comprehensive Short Notes",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "දේශීය නර්තන සම්ප්‍රදායන්: උඩරට, පහතරට සහ සබරගමු නර්තන සම්ප්‍රදායන්හි මූලික ලක්ෂණ, ශාන්තිකර්ම හා ඇඳුම් ආයිත්තම්.",
        "උඩරට නර්තන ශිල්පය: මණ්ඩිය, සරඹ 12, ගොඩසරඹ, වට්ටම් සහ වන්නම් 18 (ගජගා, තුරඟා, උකුසා, නෛඅඩි ආදී).",
        "පහතරට සහ සබරගමු නර්තන: පහතරට දෙවොල් මඩු ශාන්තිකර්මය, පහතරට බෙරය (යක් බෙරය) සහ සබරගමු දවුල හා පහන් මඩුව.",
        "තාල හා වාදන භාණ්ඩ: ගැටබෙරය, යක්බෙරය, දවුල, තම්මැට්ටම සහ උඩැක්කියේ කොටස් හා නාද රටා (තෙයි තෙයි තා, ජිං ජිකිත)."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ප්‍රධාන දේශීය නර්තන සම්ප්‍රදාය 3 සංසන්දනය",
          header1 = "සම්ප්‍රදාය (Tradition)",
          header2 = "ප්‍රධාන වාද්‍ය භාණ්ඩය (Drum)",
          header3 = "ප්‍රධාන ශාන්තිකර්මය (Ritual)",
          rows = listOf(
            TableRowData("උඩරට සම්ප්‍රදාය", "ගැටබෙරය", "කොහොඹා කංකාරිය"),
            TableRowData("පහතරට සම්ප්‍රදාය", "යක්බෙරය (දෙවොල් බෙරය)", "ගම්මඩුව / දෙවොල් මඩුව / පහතරට තොවිල්"),
            TableRowData("සබරගමු සම්ප්‍රදාය", "දවුල", "සබරගමු පහන් මඩුව")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "දේශීය බෙර වර්ග සහ සම්ප්‍රදායන් පහසුවෙන් මතක තබා ගැනීම",
          mnemonicSentence = "උඩරට - ගැට / පහතරට - යක් / සබරගමු - දවුල්!",
          explanation = "උඩරට නර්තනයට ගැටබෙරය ද, පහතරටට යක්බෙරය ද, සබරගමුවට දවුල ද ප්‍රධාන වාද්‍ය භාණ්ඩ වේ.",
          appliesTo = "දේශීය නර්තන සම්ප්‍රදායන්"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "උඩරට නර්තන සම්ප්‍රදායේ ප්‍රධානතම ශාන්තිකර්මය කුමක්ද?",
          type = "MCQ",
          options = listOf("1. කොහොඹා කංකාරිය", "2. ගම්මඩුව", "3. පහන් මඩුව", "4. දෙවොල් මඩුව"),
          correctAnswer = "1. කොහොඹා කංකාරිය",
          markingScheme = "උඩරට නර්තනයේ මූලාරම්භය හා ප්‍රධාන ශාන්තිකර්මය කොහොඹා කංකාරිය වේ. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/13_lUv-lnGHs_1QDCZj_rlZNT0TWh8ppU/preview",
      attachedDrivePdfs = mutableListOf()
    ),

    // --------------------------------------------------------------------------
    // GRADE 10 - GEOGRAPHY (10 වසර භූගෝල විද්‍යාව)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g10_geo_u1",
      grade = "10",
      subject = "භූගෝල විද්‍යාව",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "10 ශ්‍රේණිය භූගෝල විද්‍යාව පූර්ණ කෙටි සටහන් සංග්‍රහය",
      unitTitleEnglish = "Grade 10 Geography Comprehensive Short Notes",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "ශ්‍රී ලංකාවේ භූ විෂමතාව සහ පිහිටීම: උතුරු අක්ෂාංශ 5° 55' සිට 9° 50' දක්වා සහ නැගෙනහිර දේශාංශ 79° 42' සිට 81° 53' දක්වා පිහිටීම.",
        "ප්‍රධාන භූ විෂමතා කලාප 3: මුහුදුබඩ තැනිතලාව (0-30m), අභ්‍යන්තර තැනිතලාව (30-300m), මධ්‍යම කඳුකරය (>300m).",
        "දේශගුණික ලක්ෂණ සහ වර්ෂාපතන ක්‍රම: නිරිතදිග මෝසම්, ඊසානදිග මෝසම්, අන්තර් මෝසම් සහ සංවහන වැසි.",
        "ගංගා පද්ධතිය සහ ජල පෝෂක ප්‍රදේශ: මහවැලි, මල්වතු, කැලණි, කළු, වලවේ සහ ගිං ගංගා වල ගමන් මඟ හා වැදගත්කම.",
        "ස්වභාවික සම්පත් සහ පාංශු වර්ග: රතු කහ පොඩ්සොලික්, රතු දුඹුරු පස, ඇලුවියල් පස සහ ඛනිජ සම්පත් (මිනිරන්, මැණික්, ඉල්මනයිට්)."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ශ්‍රී ලංකාවේ ප්‍රධාන මෝසම් සුළං සංසන්දනය",
          header1 = "මෝසම් සුළං වර්ගය",
          header2 = "කාලසීමාව (Period)",
          header3 = "වර්ෂාව ලැබෙන ප්‍රදේශ",
          rows = listOf(
            TableRowData("නිරිතදිග මෝසම (SW Monsoon)", "මැයි සිට සැප්තැම්බර්", "නිරිතදිග තෙත් කලාපය හා මධ්‍යම කඳුකරයේ බටහිර බෑවුම්"),
            TableRowData("ඊසානදිග මෝසම (NE Monsoon)", "දෙසැම්බර් සිට පෙබරවාරි", "උතුර, නැගෙනහිර, උතුරු-මැද හා වියළි කලාපය"),
            TableRowData("පළමු අන්තර් මෝසම", "මාර්තු සිට අප්‍රේල්", "දිවයින පුරා පස්වරුවේ ගිගුරුම් සහිත සංවහන වැසි"),
            TableRowData("දෙවන අන්තර් මෝසම", "ඔක්තෝබර් සිට නොවැම්බර්", "දිවයින පුරා පීඩන අවපාත හා සුළි සුළං ආශ්‍රිත වැසි")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "ශ්‍රී ලංකාවේ භූ විෂමතා කලාප උස මට්ටම් මතක තබා ගැනීම",
          mnemonicSentence = "0-30 මුහුද / 30-300 රට මැද / 300+ කන්ද!",
          explanation = "මුහුදුබඩ තැනිතලාව (0-30m), අභ්‍යන්තර තැනිතලාව (30-300m), මධ්‍යම කඳුකරය (300m ට වැඩි).",
          appliesTo = "භූ විෂමතා කලාප"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "ශ්‍රී ලංකාවේ දිගම ගංගාව සහ එහි මුළු දිග කොපමණද?",
          type = "MCQ",
          options = listOf("1. මහවැලි ගඟ (335 km)", "2. මල්වතු ඔය (164 km)", "3. කළු ගඟ (129 km)", "4. කැලණි ගඟ (145 km)"),
          correctAnswer = "1. මහවැලි ගඟ (335 km)",
          markingScheme = "ශ්‍රී ලංකාවේ දිගම ගංගාව මහවැලි ගඟ වන අතර එහි මුළු දිග කිලෝමීටර් 335 කි. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1Fc1DqvZWVv7aiIC35KgWfl5Spjj-5WV_/preview",
      attachedDrivePdfs = mutableListOf()
    ),

    // --------------------------------------------------------------------------
    // GRADE 10 - CIVIC EDUCATION (10 වසර පුරවැසි අධ්‍යාපනය)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g10_civic_u1",
      grade = "10",
      subject = "පුරවැසි අධ්‍යාපනය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "10 ශ්‍රේණිය පුරවැසි අධ්‍යාපනය පූර්ණ කෙටි සටහන් සංග්‍රහය",
      unitTitleEnglish = "Grade 10 Civic Education Comprehensive Short Notes",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "ප්‍රජාතන්ත්‍රවාදය සහ පුරවැසිභාවය: ප්‍රජාතන්ත්‍රවාදී පාලන ක්‍රමයේ මූලික ලක්ෂණ, ඍජු හා වක්‍ර (නියෝජිත) ප්‍රජාතන්ත්‍රවාදය.",
        "යහපාලනය සහ නීතියේ ආධිපත්‍යය: විනිවිදභාවය, වගවීම, සහභාගීත්වය, කාර්යක්ෂමතාව සහ නීතිය ඉදිරියේ සැමට සමාන සැලකිල්ල.",
        "ශ්‍රී ලංකාවේ ආණ්ඩුක්‍රම ව්‍යවස්ථාව සහ රජයේ ප්‍රධාන අංග: ව්‍යවස්ථාදායකය (පාර්ලිමේන්තුව), විධායකය (ජනාධිපති හා අමාත්‍ය මණ්ඩලය), සහ අධිකරණය.",
        "මානව හිමිකම් සහ මූලික අයිතිවාසිකම්: එක්සත් ජාතීන්ගේ විශ්ව මානව හිමිකම් ප්‍රකාශනය සහ 1978 ආණ්ඩුක්‍රම ව්‍යවස්ථාවේ 3 වන පරිච්ඡේදය.",
        "බහු සංස්කෘතික සමාජයක සහජීවනය: ජාතික සමගිය, සමානාත්මතාවය, සාමය ගොඩනැගීම සහ ක්‍රියාශීලී යහපත් පුරවැසියෙකුගේ යුතුකම් හා වගකීම්."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "රජයේ ප්‍රධාන අංග 3 සහ ඒවායේ කාර්යභාරය",
          header1 = "ආයතනය (Organ)",
          header2 = "ප්‍රධාන බලතල / කාර්යය",
          header3 = "නියෝජිතයන් / සංයුතිය",
          rows = listOf(
            TableRowData("ව්‍යවස්ථාදායකය (Legislature)", "නීති සම්පාදනය කිරීම සහ මහජන මුදල් පාලනය", "පාර්ලිමේන්තුව (මන්ත්‍රීවරු 225)"),
            TableRowData("විධායකය (Executive)", "නීති ක්‍රියාත්මක කිරීම සහ රට පාලනය", "විධායක ජනාධිපති සහ අමාත්‍ය මණ්ඩලය"),
            TableRowData("අධිකරණය (Judiciary)", "නීති අර්ථ නිරූපණය සහ යුක්තිය පසිඳලීම", "ශ්‍රේෂ්ඨාධිකරණය, අභියාචනාධිකරණය ඇතුළු අධිකරණ පද්ධතිය")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "රජයේ ප්‍රධාන අංග 3 මතක තබා ගැනීමේ කෙටි ක්‍රමය",
          mnemonicSentence = "නීති හදන්නේ - ව්‍යවස්ථාදායකය / ක්‍රියාත්මක කරන්නේ - විධායකය / විනිශ්චය දෙන්නේ - අධිකරණය!",
          explanation = "ව්‍යවස්ථාදායකය (නීති සෑදීම), විධායකය (ක්‍රියාත්මක කිරීම), අධිකරණය (යුක්තිය පසිඳලීම).",
          appliesTo = "රජයේ ආයතනික ව්‍යුහය"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "ශ්‍රී ලංකාවේ ව්‍යවස්ථාදායක බලය හිමි වන්නේ කා හටද?",
          type = "MCQ",
          options = listOf("1. පාර්ලිමේන්තුවට", "2. අධිකරණයට", "3. පොලිස් දෙපාර්තමේන්තුවට", "4. පළාත් සභාවට පමණි"),
          correctAnswer = "1. පාර්ලිමේන්තුවට",
          markingScheme = "ශ්‍රී ලංකාවේ ව්‍යවස්ථාදායක (නීති සම්පාදන) බලය පාර්ලිමේන්තුවට හිමි වේ. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1RB8-GQoOrQbcl-eNnnh779n-jLtWQQFm/preview",
      attachedDrivePdfs = mutableListOf()
    ),

    // --------------------------------------------------------------------------
    // GRADE 09 COMPREHENSIVE SYLLABUS UNITS (09 ශ්‍රේණිය පූර්ණ විෂය නිර්දේශ ඒකක)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g09_sci_u1",
      grade = "09",
      subject = "විද්‍යාව",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "පදාර්ථයේ ව්‍යුහය සහ රසායනික බන්ධන",
      unitTitleEnglish = "Structure of Matter and Chemical Bonding",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "පරමාණුවක ප්‍රධාන උප පරමාණුක අංශු 3: ප්‍රෝටෝන (+1), නියුට්‍රෝන (0), සහ ඉලෙක්ට්‍රෝන (-1).",
        "පරමාණුක ක්‍රමාංකය (Z) = න්‍යෂ්ටියේ ප්‍රෝටෝන ගණන. ස්කන්ධ ක්‍රමාංකය (A) = ප්‍රෝටෝන + නියුට්‍රෝන ගණන.",
        "ඉලෙක්ට්‍රොනික වින්‍යාසය: 1 වන කවචය (K = උපරිම 2), 2 වන කවචය (L = උපරිම 8), 3 වන කවචය (M = උපරිම 8).",
        "අයනික බන්ධන: ලෝහ පරමාණු ඉලෙක්ට්‍රෝන පිටකර කැටායන සාදන අතර, අලෝහ පරමාණු ඉලෙක්ට්‍රෝන ලබාගෙන ඇනායන සාදයි.",
        "සහසංයුජ බන්ධන: අලෝහ පරමාණු අතර ඉලෙක්ට්‍රෝන යුගල හවුලේ තබා ගැනීමෙන් සෑදේ."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "උප පරමාණුක අංශු සංසන්දනය",
          header1 = "අංශුව",
          header2 = "ආරෝපණය",
          header3 = "පිහිටීම හා ස්කන්ධය",
          rows = listOf(
            TableRowData("ප්‍රෝටෝනය (p)", "+1 (ධන)", "න්‍යෂ්ටිය තුළ • සාපේක්ෂ ස්කන්ධය 1"),
            TableRowData("නියුට්‍රෝනය (n)", "0 (උදාසීන)", "න්‍යෂ්ටිය තුළ • සාපේක්ෂ ස්කන්ධය 1"),
            TableRowData("ඉලෙක්ට්‍රෝනය (e)", "-1 (ඍණ)", "න්‍යෂ්ටිය වටා කවචවල • ස්කන්ධය 1/1840")
          )
        ),
        ComparisonTable(
          title = "අයනික බන්ධන vs සහසංයුජ බන්ධන",
          header1 = "ලක්ෂණය",
          header2 = "අයනික සංයෝග (Ionic)",
          header3 = "සහසංයුජ සංයෝග (Covalent)",
          rows = listOf(
            TableRowData("සෑදෙන ආකාරය", "ඉලෙක්ට්‍රෝන හුවමාරුවෙන් (ලෝහ + අලෝහ)", "ඉලෙක්ට්‍රෝන හවුලේ තබාගැනීමෙන් (අලෝහ + අලෝහ)"),
            TableRowData("ද්‍රවාංක / තාපාංක", "ඉතා ඉහළයි (ශක්තිමත් දැලිස්)", "සාපේක්ෂව පහළයි"),
            TableRowData("විද්‍යුත් සන්නායකතාව", "විලයනයේදී හෝ ජලීය ද්‍රාවණයේදී සන්නයනය කරයි", "සාමාන්‍යයෙන් විද්‍යුතය සන්නයනය නොකරයි"),
            TableRowData("උදාහරණ", "NaCl, MgO, CaCl2", "H2O, CO2, CH4, O2")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "පරමාණුක අංශු ආරෝපණ මතක කෙටි ක්‍රමය",
          mnemonicSentence = "P for Positive, N for Neutral, E for Electronic minus!",
          explanation = "P = Positive (+1), N = Neutral (0), E = Negative (-1).",
          appliesTo = "Subatomic Particles"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "සෝඩියම් (Na, Z=11) පරමාණුවේ නිවැරදි ඉලෙක්ට්‍රොනික වින්‍යාසය කුමක්ද?",
          type = "MCQ",
          options = listOf("1. 2, 8, 1", "2. 2, 9", "3. 8, 2, 1", "4. 2, 8, 8, 1"),
          correctAnswer = "1. 2, 8, 1",
          markingScheme = "පළමු කවචයට 2, දෙවන කවචයට 8, තුන්වන කවචයට 1 ලෙස ඉලෙක්ට්‍රෝන 11 පිරේ. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1IQntv3Yh1Oaxh42-btqYaFNNA9uijfx_/preview"
    ),

    SyllabusUnitItem(
      id = "g09_math_u1",
      grade = "09",
      subject = "ගණිතය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "සමගාමී සමීකරණ, වීජීය ප්‍රකාශන හා පයිතගරස් ප්‍රමේයය",
      unitTitleEnglish = "Simultaneous Equations & Pythagoras Theorem",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "සමගාමී සමීකරණ විසඳීම: විචල්‍යයක් ඉවත් කිරීමේ ක්‍රමය (Elimination) හෝ ආදේශ කිරීමේ ක්‍රමය (Substitution).",
        "වීජීය ප්‍රකාශනවල ගුණිත: (a + b)(c + d) = ac + ad + bc + bd.",
        "වර්ග දෙකක අන්තරය: a² - b² = (a - b)(a + b).",
        "පූර්ණ වර්ග ත්‍රිපද: (a + b)² = a² + 2ab + b² සහ (a - b)² = a² - 2ab + b².",
        "පයිතගරස් ප්‍රමේයය: ඍජුකෝණී ත්‍රිකෝණයක කර්ණයේ වර්ගය, අනෙක් පාද දෙකේ වර්ගවල එකතුවට සමාන වේ (c² = a² + b²)."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "සුලබ පයිතගරස් ත්‍රිත්ව (Pythagorean Triples)",
          header1 = "කට්ටලය",
          header2 = "පාද a, b (ලම්බක පාද)",
          header3 = "කර්ණය c (දිගම පාදය)",
          rows = listOf(
            TableRowData("1 වන ත්‍රිත්වය", "3, 4", "5 (3² + 4² = 9 + 16 = 25 = 5²)"),
            TableRowData("2 වන ත්‍රිත්වය", "6, 8", "10 (6² + 8² = 36 + 64 = 100 = 10²)"),
            TableRowData("3 වන ත්‍රිත්වය", "5, 12", "13 (5² + 12² = 25 + 144 = 169 = 13²)"),
            TableRowData("4 වන ත්‍රිත්වය", "8, 15", "17 (8² + 15² = 64 + 225 = 289 = 17²)")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "පයිතගරස් ප්‍රමේයයේ කර්ණය සෙවීමේ සූත්‍රය",
          mnemonicSentence = "කර්ණය² = පාදය1² + පාදය2² (දිගම පැත්ත තනිවම පැත්තක!)",
          explanation = "ඍජුකෝණයට ඉදිරියෙන් ඇති කර්ණය හැමවිටම අනෙක් පාදවල වර්ග එකතුවට සමාන වේ.",
          appliesTo = "Pythagoras Theorem"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "ඍජුකෝණී ත්‍රිකෝණයක ලම්බක පාද 6 cm සහ 8 cm නම්, කර්ණයේ දිග කොපමණද?",
          type = "MCQ",
          options = listOf("1. 10 cm", "2. 12 cm", "3. 14 cm", "4. 100 cm"),
          correctAnswer = "1. 10 cm",
          markingScheme = "c² = 6² + 8² = 36 + 64 = 100 => c = √100 = 10 cm. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1V3y65z_15X6zjruQ_I11WhG4EOfDHGm-/preview"
    ),

    SyllabusUnitItem(
      id = "g09_hist_u1",
      grade = "09",
      subject = "ඉතිහාසය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "දඹදෙණිය, යාපහුව, කුරුණෑගල, ගම්පොළ සහ කෝට්ටේ යුගය",
      unitTitleEnglish = "Medieval Sri Lankan Kingdoms (Dambadeniya to Kotte)",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "පොළොන්නරු රාජධානියේ බිඳවැටීමෙන් පසු නිරිතදිග රාජධානි බිහිවීම: දඹදෙණිය (3 වන විජයබාහු, 2 වන පරාක්‍රමබාහු - පණ්ඩිත පරාක්‍රමබාහු).",
        "යාපහුව රාජධානිය: 1 වන බුවනෙකබාහු රජු (විශේෂිත සිංහ කැටයම් සහිත පියගැට පෙළ).",
        "කුරුණෑගල රාජධානිය: 2 වන බුවනෙකබාහු, 4 වන පරාක්‍රමබාහු (දළදා සිරිත, ජාතක පොත සිංහලට පරිවර්තනය).",
        "ගම්පොළ රාජධානිය: 4 වන බුවනෙකබාහු, 3 වන වික්‍රමබාහු (ලංකාතිලක, ගඩලාදෙණිය, ඇම්බැක්ක දේවාල).",
        "කෝට්ටේ යුගය: 6 වන පරාක්‍රමබාහු රජු (මුළු ලංකාවම එක්සේසත් කළ අවසන් සිංහල රජු, සන්දේශ කාව්‍ය සාහිත්‍යයේ ස්වර්ණමය යුගය)."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "නිරිතදිග රාජධානි හා ශ්‍රේෂ්ඨ රජවරු සංසන්දනය",
          header1 = "රාජධානිය",
          header2 = "ප්‍රධාන රජු",
          header3 = "වැදගත් සේවාව / ස්මාරකය",
          rows = listOf(
            TableRowData("දඹදෙණිය", "2 වන පරාක්‍රමබාහු", "කලිඟු මාඝ පලවා හැරීම, කව්සිළුමිණ, පූජාවලිය"),
            TableRowData("යාපහුව", "1 වන බුවනෙකබාහු", "යාපහුව පර්වත බලකොටුව සහ අලංකාර දොරටුව"),
            TableRowData("කුරුණෑගල", "4 වන පරාක්‍රමබාහු", "පන්සිය පණස් ජාතක පොත සිංහලට නැඟීම"),
            TableRowData("ගම්පොළ", "4 වන බුවනෙකබාහු", "ගඩලාදෙණිය හා ලංකාතිලක විහාර නිර්මාණය"),
            TableRowData("කෝට්ටේ", "6 වන පරාක්‍රමබාහු", "ලංකාව එක්සේසත් කිරීම, සන්දේශ කාව්‍ය යුගය")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "නිරිතදිග රාජධානි අනුපිළිවෙල මතක තබා ගැනීම",
          mnemonicSentence = "දඹේ ඉඳන් යාපහුවට ගිහින් - කුරුණෑගල හරහා ගම්පොළින් කෝට්ටේට ආවා!",
          explanation = "දඹදෙණිය → යාපහුව → කුරුණෑගල → ගම්පොළ → කෝට්ටේ.",
          appliesTo = "Medieval Sri Lanka Capitals"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "මුළු ලංකාවම එක්සේසත් කළ කෝට්ටේ යුගයේ ශ්‍රේෂ්ඨතම රජතුමා කවුද?",
          type = "MCQ",
          options = listOf("1. 6 වන පරාක්‍රමබාහු රජු", "2. 2 වන පරාක්‍රමබාහු රජු", "3. 1 වන බුවනෙකබාහු රජු", "4. ධර්මපාල රජු"),
          correctAnswer = "1. 6 වන පරාක්‍රමබාහු රජු",
          markingScheme = "6 වන පරාක්‍රමබාහු රජු මුළු ලංකාවම එක්සේසත් කර වසර 55ක් රජකම් කළේය. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1cQvoqODfVR6aBWLTO4JGEWVOBnf3C_4J/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "hist_g09_pdf_custom",
          title = "09 ශ්‍රේණිය ඉතිහාසය කෙටි සටහන් සංග්‍රහය (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1cQvoqODfVR6aBWLTO4JGEWVOBnf3C_4J/preview",
          uploadDate = "2026-08-25",
          fileSize = "3.7 MB",
          type = "NOTE"
        ),
        AttachedGoogleDrivePdf(
          id = "hist_g09_images_activity",
          title = "9, 10, 11 ශ්‍රේණි - ඉතිහාසය රූපසටහන් හඳුනාගැනීම හා හිස්තැන් පිරවීම (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1_E6UIPUBNjYVrM7lQ6XVLjl50JfVUGak/preview",
          uploadDate = "2026-08-28",
          fileSize = "4.8 MB",
          type = "NOTE"
        )
      )
    ),

    // --------------------------------------------------------------------------
    // GRADE 09 - GEOGRAPHY (09 වසර භූගෝල විද්‍යාව)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g09_geo_u1",
      grade = "09",
      subject = "භූගෝල විද්‍යාව",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "09 ශ්‍රේණිය භූගෝල විද්‍යාව - ලෝකයේ ස්වභාවික කලාප හා ආසියාව",
      unitTitleEnglish = "Grade 09 Geography - Natural Regions & Asia",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "ලෝකයේ ප්‍රධාන ස්වභාවික කලාප: සමක වැසි වනාන්තර, සැවානා තෘණභූමි, උණුසුම් කාන්තාර සහ මධ්‍යධරණී කලාප.",
        "ආසියා මහාද්වීපයේ පිහිටීම, ප්‍රධාන භූරූප කලාප, දේශගුණය හා ගංගා නිම්න ශිෂ්ටාචාර.",
        "ශ්‍රී ලංකාවේ වාරි කර්මාන්තය, වැව් පද්ධති සහ කෘෂිකාර්මික ජනාවාස ව්‍යාප්තිය.",
        "සිතියම් කියවීම: සංකේත, දිශා, පරිමාණ සහ භූලක්ෂණ හඳුනාගැනීම."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ලෝකයේ ප්‍රධාන ස්වභාවික කලාප 2 සංසන්දනය",
          header1 = "කලාපය (Region)",
          header2 = "දේශගුණ ලක්ෂණ",
          header3 = "වෘක්ෂලතා හා සත්ත්ව ප්‍රජාව",
          rows = listOf(
            TableRowData("සමක වැසි වනාන්තර", "වසර පුරා අධික උෂ්ණත්වය සහ අධික වර්ෂාව (සංවහන වැසි)", "ස්ථරීභූත ඝන වනාන්තර, දැවමය ශාක, වානරයින්"),
            TableRowData("උණුසුම් කාන්තාර", "දිවා කල දැඩි රස්නය, රාත්‍රී අධික ශීතල, ඉතා අඩු වර්ෂාව", "පතොක්, කටු පඳුරු, ඔටුවන්, උරගයින්")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "සමක කලාපීය වැසි වර්ගය",
          mnemonicSentence = "සමකයට දවල් රස්නෙයි - හවසට සංවහන වැස්සෙයි!",
          explanation = "සමක කලාපයට දිනපතා අපරභාගයේදී ගිගුරුම් සහිත සංවහන වැසි ලැබේ.",
          appliesTo = "දේශගුණ රටා"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "ලෝකයේ විශාලතම මහාද්වීපය කුමක්ද?",
          type = "MCQ",
          options = listOf("1. අප්‍රිකාව", "2. ආසියාව", "3. යුරෝපය", "4. උතුරු ඇමරිකාව"),
          correctAnswer = "2. ආසියාව",
          markingScheme = "භූමි ප්‍රමාණයෙන් හා ජනගහනයෙන් ලොව විශාලතම මහාද්වීපය ආසියාව වේ. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1dfKR5Cb8ZAE07E_3ddeYc1EDfXWOALHO/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "geo_g09_pdf_1",
          title = "09 ශ්‍රේණිය භූගෝල විද්‍යාව කෙටි සටහන් (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1dfKR5Cb8ZAE07E_3ddeYc1EDfXWOALHO/preview",
          uploadDate = "2026-08-19",
          fileSize = "2.9 MB",
          type = "NOTE"
        )
      )
    ),

    // --------------------------------------------------------------------------
    // GRADE 09 - CIVICS (09 වසර පුරවැසි අධ්‍යාපනය)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g09_civic_u1",
      grade = "09",
      subject = "පුරවැසි අධ්‍යාපනය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "09 ශ්‍රේණිය පුරවැසි අධ්‍යාපනය - ප්‍රජාතන්ත්‍රවාදය හා නීතියේ ආධිපත්‍යය",
      unitTitleEnglish = "Grade 09 Civics - Democracy & Rule of Law",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "ප්‍රජාතන්ත්‍රවාදයේ මූලධර්ම: මහජන පරමාධිපත්‍යය, මැතිවරණ, සමානාත්මතාව හා මූලික මිනිස් අයිතිවාසිකම්.",
        "නීතියේ ආධිපත්‍යය සහ අධිකරණයේ ස්වාධීනත්වය.",
        "ආණ්ඩුක්‍රමයක ප්‍රධාන අංග 3: ව්‍යවස්ථාදායකය (පාර්ලිමේන්තුව), විධායකය (ජනාධිපති/අමාත්‍ය මණ්ඩලය), අධිකරණය.",
        "යහපත් පුරවැසි යුතුකම් සහ සමාජ වගකීම්."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "රජයේ ප්‍රධාන ආයතන 3 සංසන්දනය",
          header1 = "අංශය (Branch)",
          header2 = "ප්‍රධාන කාර්යභාරය",
          header3 = "උදාහරණ ආයතනය",
          rows = listOf(
            TableRowData("ව්‍යවස්ථාදායකය", "නීති සම්පාදනය කිරීම සහ සම්මත කිරීම", "ශ්‍රී ලංකා පාර්ලිමේන්තුව"),
            TableRowData("විධායකය", "නීති ක්‍රියාත්මක කිරීම සහ රට පාලනය", "ජනාධිපති සහ අමාත්‍ය මණ්ඩලය"),
            TableRowData("අධිකරණය", "නීතිය අර්ථ නිරූපණය සහ යුක්තිය පසිඳලීම", "ශ්‍රේෂ්ඨාධිකරණය / දිසා අධිකරණ")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "රජයේ ප්‍රධාන අංග 3 මතක තබා ගැනීම",
          mnemonicSentence = "ව්‍යවස්ථාවෙන් හදයි • විධායකයෙන් කරයි • අධිකරණයෙන් රකී!",
          explanation = "ව්‍යවස්ථාදායකය (නීති හැදීම) | විධායකය (ක්‍රියාත්මක කිරීම) | අධිකරණය (යුක්තිය රැකීම).",
          appliesTo = "ආණ්ඩුක්‍රම ව්‍යුහය"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "ප්‍රජාතන්ත්‍රවාදී රටක නීති සම්පාදනය කිරීමේ බලතල හිමිවන්නේ කාටද?",
          type = "MCQ",
          options = listOf("1. විධායකයට", "2. ව්‍යවස්ථාදායකයට (පාර්ලිමේන්තුව)", "3. පොලිසියට", "4. පළාත් සභාවලට පමණි"),
          correctAnswer = "2. ව්‍යවස්ථාදායකයට (පාර්ලිමේන්තුව)",
          markingScheme = "ප්‍රජාතන්ත්‍රවාදී රටක නීති සම්පාදනය කිරීමේ උත්තරීතර බලය ව්‍යවස්ථාදායකයට හිමිවේ. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1kuL7jmciw_ZKLK4JYz8WV1lbSeeWOf08/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "civic_g09_pdf_1",
          title = "09 ශ්‍රේණිය පුරවැසි අධ්‍යාපනය කෙටි සටහන් (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1kuL7jmciw_ZKLK4JYz8WV1lbSeeWOf08/preview",
          uploadDate = "2026-08-19",
          fileSize = "2.7 MB",
          type = "NOTE"
        )
      )
    ),

    // --------------------------------------------------------------------------
    // GRADE 09 - DANCING (09 වසර නර්තනය)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g09_dance_u1",
      grade = "09",
      subject = "නර්තනය",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "09 ශ්‍රේණිය නර්තනය - උඩරට, පහතරට හා සබරගමු සම්ප්‍රදායන්",
      unitTitleEnglish = "Grade 09 Dancing - Traditional Dance Forms & Vannam",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "ශ්‍රී ලංකාවේ ප්‍රධාන නර්තන සම්ප්‍රදායන් 3: උඩරට (උඩරට බෙරය/ගැටබෙරය), පහතරට (රුහුණු බෙරය/යක් බෙරය), සබරගමු (දවුල).",
        "උඩරට දහඅට වන්නම්: ගජගා, තුරඟා, මයුරා, හංස, නෛඅඩි වන්නම්වල ලක්ෂණ හා තානම.",
        "මූලික පාද බෙදීම් සහ සරඹ අභ්‍යාස.",
        "දේශීය රංග වස්ත්‍රාභරණ සහ නර්තන ශිල්පීන්ගේ සදාචාරය."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "ප්‍රධාන නර්තන සම්ප්‍රදාය 3 සහ ප්‍රධාන බෙර සංසන්දනය",
          header1 = "නර්තන සම්ප්‍රදාය",
          header2 = "ප්‍රධාන වාද්‍ය භාණ්ඩය",
          header3 = "විශේෂ ලක්ෂණ",
          rows = listOf(
            TableRowData("උඩරට සම්ප්‍රදාය", "ගැටබෙරය", "ගෞරවනීය හා විරාජමාන චලන, වන්නම් හා කෝහොඹා කංකාරිය"),
            TableRowData("පහතරට සම්ප්‍රදාය", "යක් බෙරය (දෙවොල් බෙරය)", "වේගවත් පාද චලන, ශාන්තිකර්ම හා කෝලම් නැටුම්"),
            TableRowData("සබරගමු සම්ප්‍රදාය", "දවුල (සහ තම්මැට්ටම)", "සමන් දෙවි උපහාර නැටුම්, මඩු ශාන්තිකර්ම")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "නැටුම් සම්ප්‍රදායන් සහ බෙර වර්ග මතක තබා ගැනීම",
          mnemonicSentence = "උඩරට ගැටේ • පහතරට යකා • සබරගමුවට දවුල!",
          explanation = "උඩරට = ගැටබෙරය | පහතරට = යක්බෙරය | සබරගමුව = දවුල.",
          appliesTo = "දේශීය වාද්‍ය භාණ්ඩ"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "උඩරට නර්තන සම්ප්‍රදායේ භාවිතා වන ප්‍රධාන වාද්‍ය භාණ්ඩය කුමක්ද?",
          type = "MCQ",
          options = listOf("1. යක් බෙරය", "2. ගැටබෙරය", "3. දවුල", "4. තබ්ලාව"),
          correctAnswer = "2. ගැටබෙරය",
          markingScheme = "උඩරට නර්තනය සඳහා ප්‍රධාන වශයෙන් ගැටබෙරය භාවිතා කරනු ලැබේ. (ලකුණු 2)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1gP1Z1xI9Z9zG8aV3_Dance_Gr9/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "dance_g09_pdf_1",
          title = "09 ශ්‍රේණිය නර්තනය කෙටි සටහන් (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/1gP1Z1xI9Z9zG8aV3_Dance_Gr9/preview",
          uploadDate = "2026-08-19",
          fileSize = "2.5 MB",
          type = "NOTE"
        )
      )
    ),

    // --------------------------------------------------------------------------
    // GRADE 11 - ENGLISH (11 වසර ඉංග්‍රීසි)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g11_eng_u1",
      grade = "11",
      subject = "ඉංග්‍රීසි",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "11 ශ්‍රේණිය ඉංග්‍රීසි - Grammar, Vocabulary, Reading & Writing",
      unitTitleEnglish = "Grade 11 English - Comprehensive Grammar & Writing Guide",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "Mastering English Tenses (Present, Past, Future, Continuous & Perfect).",
        "Passive Voice transformations and Reported Speech rules.",
        "Formal & Informal Letter Writing, Essay structuring, and Notice preparation.",
        "Comprehension reading skills, inference techniques, and vocabulary expansion."
      ),
      comparisonTables = listOf(
        ComparisonTable(
          title = "Active Voice vs Passive Voice Tense Rules",
          header1 = "Tense",
          header2 = "Active Voice",
          header3 = "Passive Voice",
          rows = listOf(
            TableRowData("Simple Present", "He writes a letter.", "A letter is written by him."),
            TableRowData("Simple Past", "He wrote a letter.", "A letter was written by him."),
            TableRowData("Present Continuous", "He is writing a letter.", "A letter is being written by him."),
            TableRowData("Present Perfect", "He has written a letter.", "A letter has been written by him.")
          )
        )
      ),
      memoryTricks = listOf(
        MemoryTrick(
          title = "Letter Writing Structure Memory Trick",
          mnemonicSentence = "Sender Address → Date → Receiver Address → Salutation → Body → Sign-off",
          explanation = "Standard formal letter layout order for G.C.E. O/L examinations.",
          appliesTo = "English Formal Letter Writing"
        )
      ),
      practiceQuestions = listOf(
        UnitQuestion(
          questionNumber = 1,
          questionText = "Change the sentence into Passive Voice: 'The principal welcomed the chief guest.'",
          type = "SHORT",
          correctAnswer = "The chief guest was welcomed by the principal.",
          markingScheme = "Correct object identification and 'was welcomed' verb formation. (2 marks)",
          marksAllocated = 2
        )
      ),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1rDvpGxRMBuXPldDRpsZdKjfA0JMr1GVy/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "eng_g11_grammar_all",
          title = "06-11 ශ්‍රේණි ඉංග්‍රීසි ව්‍යාකරණ කෙටි සටහන් (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/155eu00n0_0IdrKc0wiWDqcwkqLa08ndI/preview",
          uploadDate = "2026-08-20",
          fileSize = "3.2 MB",
          type = "NOTE"
        )
      )
    ),

    // --------------------------------------------------------------------------
    // GRADE 10 - ENGLISH (10 වසර ඉංග්‍රීසි)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g10_eng_u1",
      grade = "10",
      subject = "ඉංග්‍රීසි",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "10 ශ්‍රේණිය ඉංග්‍රීසි - Grammar Rules & Writing Skills",
      unitTitleEnglish = "Grade 10 English - Grammar, Notices & Essays",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "Parts of Speech, Prepositions, Conjunctions and Relative Clauses.",
        "Conditional Sentences (Type 0, Type 1, Type 2).",
        "Writing Notices, Invitations, Descriptions, and Paragraph compositions.",
        "Grammar accuracy in G.C.E. O/L Paper 1 and Paper 2 questions."
      ),
      comparisonTables = emptyList(),
      memoryTricks = emptyList(),
      practiceQuestions = emptyList(),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1rDvpGxRMBuXPldDRpsZdKjfA0JMr1GVy/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "eng_g10_grammar_all",
          title = "06-11 ශ්‍රේණි ඉංග්‍රීසි ව්‍යාකරණ කෙටි සටහන් (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/155eu00n0_0IdrKc0wiWDqcwkqLa08ndI/preview",
          uploadDate = "2026-08-20",
          fileSize = "3.2 MB",
          type = "NOTE"
        )
      )
    ),

    // --------------------------------------------------------------------------
    // GRADE 09 - ENGLISH (09 වසර ඉංග්‍රීසි)
    // --------------------------------------------------------------------------
    SyllabusUnitItem(
      id = "g09_eng_u1",
      grade = "09",
      subject = "ඉංග්‍රීසි",
      unitNumber = "01 වන පාඩම",
      unitTitleSinhala = "09 ශ්‍රේණිය ඉංග්‍රීසි - Essential Grammar & Writing Foundations",
      unitTitleEnglish = "Grade 09 English - Core Language & Grammar Foundations",
      term = "1 වන වාරය",
      summaryNotes = listOf(
        "Nouns, Pronouns, Adjectives, Adverbs, and Tense patterns.",
        "Sentence building, punctuation rules, and vocabulary building.",
        "Short paragraph writing, dialogues, and reading comprehension.",
        "Confidence building in spoken and written English communication."
      ),
      comparisonTables = emptyList(),
      memoryTricks = emptyList(),
      practiceQuestions = emptyList(),
      defaultDrivePdfUrl = "https://drive.google.com/file/d/1rDvpGxRMBuXPldDRpsZdKjfA0JMr1GVy/preview",
      attachedDrivePdfs = mutableListOf(
        AttachedGoogleDrivePdf(
          id = "eng_g09_grammar_all",
          title = "06-11 ශ්‍රේණි ඉංග්‍රීසි ව්‍යාකරණ කෙටි සටහන් (Google Drive)",
          driveUrl = "https://drive.google.com/file/d/155eu00n0_0IdrKc0wiWDqcwkqLa08ndI/preview",
          uploadDate = "2026-08-20",
          fileSize = "3.2 MB",
          type = "NOTE"
        )
      )
    )
  )

  fun getUnitsForGradeAndSubject(grade: String, subject: String): List<SyllabusUnitItem> {
    val gradeUnits = allSyllabusUnits.filter { it.grade == grade }
    val matchSubject = gradeUnits.filter { 
      val isGeo = subject.contains("භූගෝල") || subject.contains("Geography", ignoreCase = true)
      val isSci = (subject.contains("විද්‍යාව") && !subject.contains("භූගෝල")) || subject.contains("Science", ignoreCase = true)
      val isCivic = subject.contains("පුරවැසි") || subject.contains("Civic", ignoreCase = true)
      val isDance = subject.contains("නර්තන") || subject.contains("Dance", ignoreCase = true)
      val isMusic = subject.contains("සංගීත") || subject.contains("Music", ignoreCase = true)
      val isArt = subject.contains("චිත්‍ර") || subject.contains("Art", ignoreCase = true)
      val isMath = subject.contains("ගණිත") || subject.contains("Math", ignoreCase = true)
      val isHist = subject.contains("ඉතිහාස") || subject.contains("History", ignoreCase = true)
      val isSin = subject.contains("සිංහල") || subject.contains("Sinhala", ignoreCase = true)
      val isEng = subject.contains("English", ignoreCase = true) || subject.contains("ඉංග්‍රීසි")
      val isBud = subject.contains("බුද්ධ") || subject.contains("Buddhism", ignoreCase = true)
      val isHealth = subject.contains("සෞඛ්‍ය") || subject.contains("Health", ignoreCase = true)
      val isIct = subject.contains("ICT", ignoreCase = true) || subject.contains("තොරතුරු")
      val isCom = subject.contains("ව්‍යාපාර") || subject.contains("ගිණුම්") || subject.contains("Commerce", ignoreCase = true)

      when {
        isGeo -> it.subject.contains("භූගෝල")
        isSci -> it.subject.contains("විද්‍යාව") && !it.subject.contains("භූගෝල")
        isCivic -> it.subject.contains("පුරවැසි")
        isDance -> it.subject.contains("නර්තන")
        isMusic -> it.subject.contains("සංගීත")
        isArt -> it.subject.contains("චිත්‍ර") || it.subject.contains("Art", ignoreCase = true)
        isMath -> it.subject.contains("ගණිත")
        isHist -> it.subject.contains("ඉතිහාස")
        isSin -> it.subject.contains("සිංහල")
        isEng -> it.subject.contains("ඉංග්‍රීසි") || it.subject.contains("English")
        isBud -> it.subject.contains("බුද්ධ")
        isHealth -> it.subject.contains("සෞඛ්‍ය")
        isIct -> it.subject.contains("ICT") || it.subject.contains("තොරතුරු")
        isCom -> it.subject.contains("ව්‍යාපාර") || it.subject.contains("ගිණුම්")
        else -> it.subject.equals(subject, ignoreCase = true)
      }
    }
    
    if (matchSubject.isNotEmpty()) {
      return matchSubject.map { unit ->
        if (unit.grade == "10" || unit.grade == "11") {
          unit.copy(attachedDrivePdfs = unit.getDeduplicatedAttachedPdfs().toMutableList())
        } else {
          unit
        }
      }
    }

    // Never fall back to unrelated subjects like Science for Geography!
    val fallbackDriveUrl = when {
      subject.contains("භූගෝල") -> "https://drive.google.com/file/d/1dfKR5Cb8ZAE07E_3ddeYc1EDfXWOALHO/preview"
      subject.contains("පුරවැසි") -> "https://drive.google.com/file/d/1kuL7jmciw_ZKLK4JYz8WV1lbSeeWOf08/preview"
      subject.contains("බුද්ධ") -> "https://drive.google.com/file/d/17O97RA-IbgZnpKt9cVynjoNZ7y5SCE-Q/preview"
      subject.contains("සිංහල") -> "https://drive.google.com/file/d/1XB8up4GLB9mvcavvtVsbOaAZAO1027tc/preview"
      subject.contains("English") || subject.contains("ඉංග්‍රීසි") -> "https://drive.google.com/file/d/155eu00n0_0IdrKc0wiWDqcwkqLa08ndI/preview"
      subject.contains("ගණිත") -> "https://drive.google.com/file/d/1V3y65z_15X6zjruQ_I11WhG4EOfDHGm-/preview"
      subject.contains("ඉතිහාස") -> "https://drive.google.com/file/d/17fVj3VpM3h9yX9Z2_History_ShortNotes/preview"
      subject.contains("චිත්‍ර") || subject.contains("Art", ignoreCase = true) -> if (grade == "11") "https://drive.google.com/file/d/1yDDZxJOdSIZt--KyTdJzKNx0hHmYQOYe/preview" else "https://drive.google.com/file/d/1z4Q0vRbaB20E7-EFqFU-hlU_Uoy2LwcW/preview"
      else -> "https://drive.google.com/file/d/1cQvoqODfVR6aBWLTO4JGEWVOBnf3C_4J/preview"
    }

    return listOf(
      SyllabusUnitItem(
        id = "unit_${grade}_${subject.hashCode()}",
        grade = grade,
        subject = subject,
        unitNumber = "01 වන පාඩම",
        unitTitleSinhala = "$grade ශ්‍රේණිය $subject පූර්ණ කෙටි සටහන් හා විෂය නිර්දේශය",
        unitTitleEnglish = "Grade $grade $subject Syllabus & Notes",
        term = "1 වන වාරය",
        summaryNotes = listOf(
          "$grade ශ්‍රේණිය $subject විෂය නිර්දේශයට අදාළ මූලික සිද්ධාන්ත හා ප්‍රධාන පාඩම් සටහන්.",
          "විභාග සඳහා නියමිත නිපුණතා, වගු සහ මතක උපක්‍රම.",
          "වාර විභාග සහ පසුගිය විභාග ගැටලු විවරණය."
        ),
        comparisonTables = emptyList(),
        memoryTricks = emptyList(),
        practiceQuestions = emptyList(),
        defaultDrivePdfUrl = fallbackDriveUrl,
        attachedDrivePdfs = mutableListOf()
      )
    )
  }

  fun attachDrivePdfToUnit(unitId: String, title: String, driveUrl: String, type: String = "NOTE"): Boolean {
    val target = allSyllabusUnits.find { it.id == unitId }
    if (target != null) {
      val embedUrl = formatToGoogleDriveEmbedUrl(driveUrl)
      target.attachedDrivePdfs.add(
        0,
        AttachedGoogleDrivePdf(
          id = System.currentTimeMillis().toString(),
          title = title,
          driveUrl = embedUrl,
          type = type
        )
      )
      return true
    }
    return false
  }
}

// ==============================================================================
// SYLLABUS DETECTION & CONTENT HUB SCREEN
// ==============================================================================

@Composable
fun SyllabusDetectionAndContentScreen(
  initialGrade: String = "11",
  initialSubject: String = "විද්‍යාව",
  isApproved: Boolean = false,
  isAdmin: Boolean = false,
  onRequireApproval: () -> Unit = {},
  onBack: () -> Unit,
  onOpenGoogleDrivePdfModal: (url: String, title: String) -> Unit
) {
  val context = LocalContext.current
  var selectedGrade by remember { mutableStateOf(initialGrade) }
  var selectedSubject by remember { mutableStateOf(initialSubject) }
  var searchQuery by remember { mutableStateOf("") }
  var selectedTabContent by remember { mutableStateOf(0) } // 0: Notes & Summary, 1: Markdown Tables, 2: Memory Tricks, 3: Papers & Marking Schemes, 4: Google Drive PDFs

  // Add Google Drive PDF Modal state
  var showAttachDrivePdfDialog by remember { mutableStateOf(false) }
  var inputPdfTitle by remember { mutableStateOf("") }
  var inputDriveUrl by remember { mutableStateOf("") }
  var targetUnitForUpload by remember { mutableStateOf<SyllabusUnitItem?>(null) }

  // Admin Delete Confirmation Modal state
  var showDeleteConfirmDialog by remember { mutableStateOf(false) }
  var deletePdfTitle by remember { mutableStateOf("") }
  var pendingDeleteAction by remember { mutableStateOf<(() -> Unit)?>(null) }

  if (showDeleteConfirmDialog) {
    AlertDialog(
      onDismissRequest = {
        showDeleteConfirmDialog = false
        pendingDeleteAction = null
      },
      icon = {
        Box(
          modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(Color(0xFFFEE2E2)),
          contentAlignment = Alignment.Center
        ) {
          Icon(
            imageVector = Icons.Default.DeleteForever,
            contentDescription = "Delete",
            tint = Color(0xFFDC2626),
            modifier = Modifier.size(28.dp)
          )
        }
      },
      title = {
        Text(
          text = "Drive PDF ගොනුව ඉවත් කිරීම (Delete)",
          fontWeight = FontWeight.Bold,
          fontSize = 16.sp,
          color = Color(0xFFDC2626)
        )
      },
      text = {
        Column {
          Text(
            text = "මෙම Drive PDF ගොනුව ස්ථිරවම ඉවත් කිරීමට ඔබට අවශ්‍යද?",
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            color = Color(0xFF0F172A)
          )
          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = "ලේඛනය: $deletePdfTitle",
            fontSize = 12.sp,
            color = Color(0xFF64748B)
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "මෙය සිදුකළ පසු සියලුම පරිශීලකයින්ටද මෙම PDF ගොනුව නොපෙනී යනු ඇත.",
            fontSize = 11.sp,
            color = Color(0xFFB91C1C)
          )
        }
      },
      confirmButton = {
        Button(
          onClick = {
            pendingDeleteAction?.invoke()
            showDeleteConfirmDialog = false
            pendingDeleteAction = null
          },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
          shape = RoundedCornerShape(8.dp)
        ) {
          Text("ඔව්, ඉවත් කරන්න (Yes)", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
        }
      },
      dismissButton = {
        OutlinedButton(
          onClick = {
            showDeleteConfirmDialog = false
            pendingDeleteAction = null
          },
          shape = RoundedCornerShape(8.dp)
        ) {
          Text("නැත (No)", color = Color(0xFF0F172A), fontSize = 12.sp)
        }
      }
    )
  }

  val gradeList = listOf("11", "10")
  val subjectsForGrade = listOf("විද්‍යාව", "ගණිතය", "ඉතිහාසය", "English", "සිංහල", "ICT", "බුද්ධ ධර්මය", "භූගෝල විද්‍යාව", "පුරවැසි අධ්‍යාපනය", "නර්තනය", "සංගීතය", "චිත්‍ර කලාව", "ව්‍යාපාර හා ගිණුම්කරණය")

  // Ensure valid subject when grade changes
  LaunchedEffect(selectedGrade) {
    if (!subjectsForGrade.contains(selectedSubject)) {
      selectedSubject = subjectsForGrade.first()
    }
  }

  val units = remember(selectedGrade, selectedSubject, searchQuery) {
    val list = SyllabusRepository.getUnitsForGradeAndSubject(selectedGrade, selectedSubject)
    if (searchQuery.isBlank()) list else {
      list.filter {
        it.unitTitleSinhala.contains(searchQuery, ignoreCase = true) ||
        it.unitTitleEnglish.contains(searchQuery, ignoreCase = true) ||
        it.unitNumber.contains(searchQuery, ignoreCase = true)
      }
    }
  }

  var selectedUnit by remember(units) { mutableStateOf(units.firstOrNull()) }

  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(Color(0xFFF8FAFC))
  ) {
    // Header Bar
    Surface(
      color = Color(0xFF1E1B4B),
      shadowElevation = 4.dp,
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(16.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(
              onClick = onBack,
              shape = CircleShape,
              color = Color(0xFF312E81)
            ) {
              Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier
                  .padding(8.dp)
                  .size(20.dp)
              )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
              Text(
                text = "📚 Syllabus Detection & Content",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Text(
                text = "ශ්‍රී ලංකා විෂය නිර්දේශයේ පාඩම්, වගු, කෙටි ක්‍රම & Google Drive PDFs",
                fontSize = 10.sp,
                color = Color(0xFFC7D2FE)
              )
            }
          }

          // Upload / Attach Google Drive Button (Admin Only)
          if (isAdmin) {
            FilledTonalButton(
              onClick = {
                if (!isApproved) {
                  Toast.makeText(context, "🔒 Drive PDF ගොනු එක් කිරීමට ඇඩ්මින් අනුමැතිය අවශ්‍ය වේ.", Toast.LENGTH_SHORT).show()
                  onRequireApproval()
                } else {
                  targetUnitForUpload = selectedUnit
                  inputPdfTitle = ""
                  inputDriveUrl = ""
                  showAttachDrivePdfDialog = true
                }
              },
              shape = RoundedCornerShape(10.dp),
              colors = ButtonDefaults.filledTonalButtonColors(
                containerColor = Color(0xFF4338CA),
                contentColor = Color.White
              ),
              contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
            ) {
              Icon(Icons.Default.AddLink, contentDescription = "Add Drive PDF", modifier = Modifier.size(16.dp))
              Spacer(modifier = Modifier.width(4.dp))
              Text("Drive PDF එකතු කරන්න", fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
          }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Security & Approval Status Strip
        Surface(
          shape = RoundedCornerShape(8.dp),
          color = if (isApproved) Color(0xFF064E3B).copy(alpha = 0.6f) else Color(0xFF7F1D1D).copy(alpha = 0.6f),
          border = BorderStroke(1.dp, if (isApproved) Color(0xFF059669) else Color(0xFFDC2626)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text(if (isApproved) "🛡️" else "🔒", fontSize = 12.sp)
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = if (isApproved) "ආරක්ෂිත අධ්‍යාපන කලාපය • Screen Record, Screenshots & Downloads අවහිරයි" else "නොමිලේ පූර්වදර්ශනය • PDF & Marking Scheme සඳහා ඇඩ්මින් අනුමැතිය අවශ්‍යයි",
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
              )
            }
            if (!isApproved) {
              TextButton(
                onClick = onRequireApproval,
                contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp)
              ) {
                Text("අනුමැතිය ගන්න", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE047))
              }
            }
          }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Grade Selector Tabs
        LazyRow(
          horizontalArrangement = Arrangement.spacedBy(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          items(gradeList) { g ->
            val isSelected = selectedGrade == g
            Surface(
              onClick = {
                selectedGrade = g
                selectedUnit = null
              },
              shape = RoundedCornerShape(8.dp),
              color = if (isSelected) Color(0xFF6366F1) else Color(0xFF312E81),
              border = BorderStroke(1.dp, if (isSelected) Color(0xFFA5B4FC) else Color(0xFF3730A3))
            ) {
              Text(
                text = "$g ශ්‍රේණිය",
                fontSize = 11.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
              )
            }
          }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Subject Selector Chips
        LazyRow(
          horizontalArrangement = Arrangement.spacedBy(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          items(subjectsForGrade) { sub ->
            val isSelected = selectedSubject == sub
            Surface(
              onClick = {
                selectedSubject = sub
                selectedUnit = null
              },
              shape = RoundedCornerShape(8.dp),
              color = if (isSelected) Color.White else Color(0xFF312E81).copy(alpha = 0.6f)
            ) {
              Text(
                text = sub,
                fontSize = 11.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                color = if (isSelected) Color(0xFF1E1B4B) else Color(0xFFE0E7FF),
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
              )
            }
          }
        }
      }
    }

    // Search and Unit Sequence Bar
    Surface(
      color = Color.White,
      shadowElevation = 1.dp,
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)) {
        OutlinedTextField(
          value = searchQuery,
          onValueChange = { searchQuery = it },
          placeholder = { Text("පාඩම හෝ මාතෘකාව සෙවීම (Search Lessons)...", fontSize = 12.sp) },
          leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF64748B)) },
          trailingIcon = {
            if (searchQuery.isNotEmpty()) {
              IconButton(onClick = { searchQuery = "" }) {
                Icon(Icons.Default.Close, contentDescription = "Clear", modifier = Modifier.size(16.dp))
              }
            }
          },
          singleLine = true,
          shape = RoundedCornerShape(12.dp),
          colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF4F46E5),
            unfocusedBorderColor = Color(0xFFE2E8F0)
          ),
          modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Detected Unit Sequence Chips
        Text(
          text = "📌 $selectedGrade ශ්‍රේණිය $selectedSubject අධ්‍යාපන දෙපාර්තමේන්තු පාඩම් මාලාව (Unit Sequence):",
          fontSize = 11.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFF4338CA)
        )

        Spacer(modifier = Modifier.height(6.dp))

        LazyRow(
          horizontalArrangement = Arrangement.spacedBy(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          items(units) { u ->
            val isCurrent = (selectedUnit?.id == u.id) || (selectedUnit == null && units.firstOrNull()?.id == u.id)
            Surface(
              onClick = { selectedUnit = u },
              shape = RoundedCornerShape(8.dp),
              color = if (isCurrent) Color(0xFFEEF2FF) else Color(0xFFF8FAFC),
              border = BorderStroke(1.dp, if (isCurrent) Color(0xFF6366F1) else Color(0xFFCBD5E1))
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = u.unitNumber,
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = if (isCurrent) Color(0xFF4338CA) else Color(0xFF64748B)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                  text = u.unitTitleSinhala,
                  fontSize = 11.sp,
                  fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Normal,
                  color = if (isCurrent) Color(0xFF1E1B4B) else Color(0xFF334155),
                  maxLines = 1
                )
              }
            }
          }
        }
      }
    }

    // Active Unit Content & Tabs Section
    val currentActiveUnit = selectedUnit ?: units.firstOrNull()

    if (currentActiveUnit == null) {
      Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
      ) {
        Text(
          text = "මෙම ශ්‍රේණිය හා විෂය සඳහා පාඩම් සටහන් සූදානම් වෙමින් පවතී...",
          color = Color(0xFF64748B),
          fontSize = 13.sp
        )
      }
    } else {
      // Content Category Tabs
      TabRow(
        selectedTabIndex = selectedTabContent,
        containerColor = Color.White,
        contentColor = Color(0xFF4F46E5),
        modifier = Modifier.fillMaxWidth()
      ) {
        listOf(
          "📖 සටහන්",
          "📊 වගු",
          "💡 කෙටි ක්‍රම",
          "📝 ප්‍රශ්න & Marking",
          "📄 Drive PDFs"
        ).forEachIndexed { index, title ->
          Tab(
            selected = selectedTabContent == index,
            onClick = { selectedTabContent = index },
            text = {
              Text(
                text = title,
                fontSize = 10.sp,
                fontWeight = if (selectedTabContent == index) FontWeight.Bold else FontWeight.Normal,
                maxLines = 1
              )
            }
          )
        }
      }

      // Tab Content Body
      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
          .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        contentPadding = PaddingValues(top = 14.dp, bottom = 40.dp)
      ) {
        // Active Unit Hero Banner
        item {
          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1B4B)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(16.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = Color(0xFF6366F1)
                ) {
                  Text(
                    text = "${currentActiveUnit.grade} ශ්‍රේණිය • ${currentActiveUnit.unitNumber} • ${currentActiveUnit.term}",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                  )
                }

                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = Color(0xFF10B981).copy(alpha = 0.2f),
                  border = BorderStroke(1.dp, Color(0xFF10B981))
                ) {
                  Text(
                    text = "Official Syllabus Unit",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF34D399),
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                  )
                }
              }

              Spacer(modifier = Modifier.height(10.dp))

              Text(
                text = currentActiveUnit.unitTitleSinhala,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )

              Text(
                text = currentActiveUnit.unitTitleEnglish,
                fontSize = 12.sp,
                color = Color(0xFFA5B4FC)
              )
            }
          }
        }

        when (selectedTabContent) {
          0 -> {
            // COMPREHENSIVE SHORT NOTES (මුළු පාඩමම ආවරණය වන සවිස්තර කෙටි සටහන්)
            item {
              Text(
                text = "📖 මුළු පාඩමම ආවරණය වන ප්‍රධාන කරුණු (Complete Lesson Summary):",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E293B)
              )
            }

            items(currentActiveUnit.summaryNotes) { note ->
              Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(
                  modifier = Modifier.padding(14.dp),
                  verticalAlignment = Alignment.Top
                ) {
                  Box(
                    modifier = Modifier
                      .size(20.dp)
                      .clip(CircleShape)
                      .background(Color(0xFF4F46E5)),
                    contentAlignment = Alignment.Center
                  ) {
                    Icon(
                      Icons.Default.Check,
                      contentDescription = null,
                      tint = Color.White,
                      modifier = Modifier.size(12.dp)
                    )
                  }
                  Spacer(modifier = Modifier.width(10.dp))
                  Text(
                    text = note,
                    fontSize = 13.sp,
                    color = Color(0xFF334155),
                    lineHeight = 19.sp
                  )
                }
              }
            }
          }

          1 -> {
            // MARKDOWN COMPARISON TABLES (සංසන්දනාත්මක වගු)
            item {
              Text(
                text = "📊 සංසන්දනාත්මක වගු (Comparison Tables):",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E293B)
              )
            }

            if (currentActiveUnit.comparisonTables.isEmpty()) {
              item {
                Text(
                  text = "මෙම පාඩම සඳහා සංසන්දනාත්මක වගු සූදානම් වෙමින් පවතී...",
                  fontSize = 12.sp,
                  color = Color(0xFF64748B)
                )
              }
            } else {
              items(currentActiveUnit.comparisonTables) { table ->
                Card(
                  shape = RoundedCornerShape(16.dp),
                  colors = CardDefaults.cardColors(containerColor = Color.White),
                  border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
                  elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                      text = table.title,
                      fontSize = 13.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF4338CA)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // Table Header
                    Surface(
                      color = Color(0xFFEEF2FF),
                      shape = RoundedCornerShape(8.dp),
                      modifier = Modifier.fillMaxWidth()
                    ) {
                      Row(
                        modifier = Modifier.padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                      ) {
                        Text(
                          text = table.header1,
                          fontSize = 11.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFF312E81),
                          modifier = Modifier.weight(1f)
                        )
                        Text(
                          text = table.header2,
                          fontSize = 11.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFF312E81),
                          modifier = Modifier.weight(1.2f)
                        )
                        if (table.header3.isNotEmpty()) {
                          Text(
                            text = table.header3,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF312E81),
                            modifier = Modifier.weight(1.2f)
                          )
                        }
                      }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    // Table Rows
                    table.rows.forEachIndexed { idx, row ->
                      Row(
                        modifier = Modifier
                          .fillMaxWidth()
                          .background(if (idx % 2 == 0) Color.White else Color(0xFFF8FAFC))
                          .padding(vertical = 8.dp, horizontal = 6.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                      ) {
                        Text(
                          text = row.column1,
                          fontSize = 11.sp,
                          fontWeight = FontWeight.SemiBold,
                          color = Color(0xFF1E293B),
                          modifier = Modifier.weight(1f)
                        )
                        Text(
                          text = row.column2,
                          fontSize = 11.sp,
                          color = Color(0xFF334155),
                          modifier = Modifier.weight(1.2f)
                        )
                        if (table.header3.isNotEmpty()) {
                          Text(
                            text = row.column3,
                            fontSize = 11.sp,
                            color = Color(0xFF334155),
                            modifier = Modifier.weight(1.2f)
                          )
                        }
                      }
                      HorizontalDivider(color = Color(0xFFF1F5F9))
                    }
                  }
                }
              }
            }
          }

          2 -> {
            // MEMORY TRICKS & MNEMONICS (මතක තබා ගැනීමේ කෙටි ක්‍රම)
            item {
              Text(
                text = "💡 මතක තබා ගැනීමේ කෙටි ක්‍රම (Memory Tricks & Mnemonics):",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E293B)
              )
            }

            items(currentActiveUnit.memoryTricks) { trick ->
              Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFBEB)),
                border = BorderStroke(1.dp, Color(0xFFFDE68A)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(16.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(
                      text = trick.title,
                      fontSize = 13.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF92400E)
                    )

                    Surface(
                      shape = RoundedCornerShape(6.dp),
                      color = Color(0xFFFEF3C7)
                    ) {
                      Text(
                        text = trick.appliesTo,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFB45309),
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                      )
                    }
                  }

                  Spacer(modifier = Modifier.height(10.dp))

                  Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = Color.White,
                    border = BorderStroke(1.dp, Color(0xFFFCD34D)),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                      Text(
                        text = "🎯 කෙටි වාක්‍යය (Mnemonic):",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFD97706)
                      )
                      Spacer(modifier = Modifier.height(4.dp))
                      Text(
                        text = "\"${trick.mnemonicSentence}\"",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFF78350F)
                      )
                    }
                  }

                  Spacer(modifier = Modifier.height(8.dp))
                  Text(
                    text = "විස්තරය: ${trick.explanation}",
                    fontSize = 12.sp,
                    color = Color(0xFF78350F),
                    lineHeight = 17.sp
                  )
                }
              }
            }
          }

          3 -> {
            // UNIT PRACTICE PAPERS & MARKING SCHEMES (ප්‍රශ්න පත්‍ර & Marking Schemes)
            item {
              Text(
                text = "📝 ප්‍රශ්න පත්‍රය සහ විස්තරාත්මක Marking Scheme:",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E293B)
              )
            }

            items(currentActiveUnit.practiceQuestions) { q ->
              var showMarkingScheme by remember { mutableStateOf(false) }

              Card(
                shape = RoundedCornerShape(16.dp),
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
                    Surface(
                      shape = RoundedCornerShape(6.dp),
                      color = Color(0xFFEEF2FF)
                    ) {
                      Text(
                        text = "ප්‍රශ්න අංක 0${q.questionNumber} • ${q.type}",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4338CA),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                      )
                    }

                    Text(
                      text = "ලකුණු [ ${q.marksAllocated} ]",
                      fontSize = 11.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF15803D)
                    )
                  }

                  Spacer(modifier = Modifier.height(10.dp))

                  Text(
                    text = q.questionText,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E293B),
                    lineHeight = 20.sp
                  )

                  if (q.options.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    q.options.forEach { opt ->
                      Text(
                        text = opt,
                        fontSize = 12.sp,
                        color = Color(0xFF475569),
                        modifier = Modifier.padding(vertical = 2.dp)
                      )
                    }
                  }

                  Spacer(modifier = Modifier.height(12.dp))

                  // Marking Scheme Toggle Button
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(
                      text = if (showMarkingScheme) "✅ පිළිතුරු හා ලකුණු ක්‍රමය:" else "නිවැරදි පිළිතුර සහ Marking Scheme බලන්න",
                      fontSize = 11.sp,
                      fontWeight = FontWeight.SemiBold,
                      color = if (showMarkingScheme) Color(0xFF15803D) else Color(0xFF64748B)
                    )

                    Button(
                      onClick = {
                        if (!isApproved) {
                          Toast.makeText(context, "🔒 විස්තරාත්මක ලකුණු ක්‍රමවේදය (Marking Scheme) නැරඹීමට ඇඩ්මින් අනුමැතිය අවශ්‍ය වේ.", Toast.LENGTH_LONG).show()
                          onRequireApproval()
                        } else {
                          showMarkingScheme = !showMarkingScheme
                        }
                      },
                      shape = RoundedCornerShape(8.dp),
                      colors = ButtonDefaults.buttonColors(
                        containerColor = if (showMarkingScheme) Color(0xFFF1F5F9) else Color(0xFF4F46E5),
                        contentColor = if (showMarkingScheme) Color(0xFF334155) else Color.White
                      ),
                      contentPadding = PaddingValues(horizontal = 10.dp, vertical = 5.dp)
                    ) {
                      Text(
                        text = if (showMarkingScheme) "සඟවන්න" else "Marking Scheme",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                      )
                    }
                  }

                  if (showMarkingScheme) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Surface(
                      shape = RoundedCornerShape(10.dp),
                      color = Color(0xFFF0FDF4),
                      border = BorderStroke(1.dp, Color(0xFFBBF7D0)),
                      modifier = Modifier.fillMaxWidth()
                    ) {
                      Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                          text = "🎯 නිවැරදි පිළිතුර: ${q.correctAnswer}",
                          fontSize = 12.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFF166534)
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                          text = "📋 ලකුණු ලබාදීමේ පටිපාටිය (Marking Breakdown):",
                          fontSize = 11.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFF15803D)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                          text = q.markingScheme,
                          fontSize = 11.sp,
                          color = Color(0xFF14532D),
                          lineHeight = 16.sp
                        )
                      }
                    }
                  }
                }
              }
            }
          }

          4 -> {
            // GOOGLE DRIVE PDFS (ගූගල් ඩ්‍රයිව් පීඩීඑෆ් සෘජුව විවෘත කිරීම)
            item {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = "📄 අදාළ Google Drive PDFs (කෙටි සටහන් & පත්‍ර):",
                  fontSize = 13.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF1E293B)
                )

                if (isAdmin) {
                  TextButton(
                    onClick = {
                      targetUnitForUpload = currentActiveUnit
                      inputPdfTitle = ""
                      inputDriveUrl = ""
                      showAttachDrivePdfDialog = true
                    }
                  ) {
                    Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("නව Drive PDF එකතු කරන්න", fontSize = 11.sp)
                  }
                }
              }
            }

            // Default Official Unit PDF
            item {
              Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(1.2.dp, Color(0xFFE2E8F0)),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier
                  .fillMaxWidth()
                  .clickable {
                    if (!isApproved) {
                      Toast.makeText(context, "🔒 මෙම පීඩීඑෆ් (PDF) සටහන් නැරඹීමට ඇඩ්මින් අනුමැතිය අවශ්‍ය වේ.", Toast.LENGTH_LONG).show()
                      onRequireApproval()
                    } else {
                      onOpenGoogleDrivePdfModal(
                        currentActiveUnit.defaultDrivePdfUrl,
                        "${currentActiveUnit.unitTitleSinhala} (Google Drive PDF)"
                      )
                    }
                  }
              ) {
                Row(
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.SpaceBetween
                ) {
                  Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                  ) {
                    Box(
                      modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFFFEBEE)),
                      contentAlignment = Alignment.Center
                    ) {
                      Icon(
                        imageVector = Icons.Default.PictureAsPdf,
                        contentDescription = "PDF",
                        tint = Color(0xFFDC2626),
                        modifier = Modifier.size(24.dp)
                      )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                      Text(
                        text = "${currentActiveUnit.unitNumber} සම්පූර්ණ කෙටි සටහන් PDF",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A)
                      )
                      Text(
                        text = "Google Drive Cloud • 2.4 MB • නිල විෂය නිර්දේශය",
                        fontSize = 10.sp,
                        color = Color(0xFF64748B)
                      )
                    }
                  }

                  Button(
                    onClick = {
                      if (!isApproved) {
                        Toast.makeText(context, "🔒 මෙම පීඩීඑෆ් (PDF) සටහන් නැරඹීමට ඇඩ්මින් අනුමැතිය අවශ්‍ය වේ.", Toast.LENGTH_LONG).show()
                        onRequireApproval()
                      } else {
                        onOpenGoogleDrivePdfModal(
                          currentActiveUnit.defaultDrivePdfUrl,
                          "${currentActiveUnit.unitTitleSinhala} (Google Drive PDF)"
                        )
                      }
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                  ) {
                    Icon(
                      imageVector = Icons.Default.PictureAsPdf,
                      contentDescription = null,
                      modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("PDF කියවන්න", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                  }
                }
              }
            }

            // Attached Custom Uploaded Google Drive PDFs (Deduplicated: removes any identical duplicate short note PDFs)
            val deduplicatedDrivePdfs = currentActiveUnit.getDeduplicatedAttachedPdfs()
            if (deduplicatedDrivePdfs.isNotEmpty()) {
              items(deduplicatedDrivePdfs) { attachedPdf ->
                Card(
                  shape = RoundedCornerShape(16.dp),
                  colors = CardDefaults.cardColors(containerColor = Color.White),
                  border = BorderStroke(1.2.dp, Color(0xFFCBD5E1)),
                  elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                  modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                      if (!isApproved) {
                        Toast.makeText(context, "🔒 මෙම පීඩීඑෆ් (PDF) සටහන් නැරඹීමට ඇඩ්මින් අනුමැතිය අවශ්‍ය වේ.", Toast.LENGTH_LONG).show()
                        onRequireApproval()
                      } else {
                        onOpenGoogleDrivePdfModal(
                          attachedPdf.driveUrl,
                          "${attachedPdf.title} (Google Drive)"
                        )
                      }
                    }
                ) {
                  Row(
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                  ) {
                    Row(
                      verticalAlignment = Alignment.CenterVertically,
                      modifier = Modifier.weight(1f)
                    ) {
                      Box(
                        modifier = Modifier
                          .size(44.dp)
                          .clip(CircleShape)
                          .background(Color(0xFFEFF6FF)),
                        contentAlignment = Alignment.Center
                      ) {
                        Icon(
                          imageVector = Icons.Default.CloudDownload,
                          contentDescription = "Drive Upload",
                          tint = Color(0xFF2563EB),
                          modifier = Modifier.size(24.dp)
                        )
                      }
                      Spacer(modifier = Modifier.width(12.dp))
                      Column {
                        Text(
                          text = attachedPdf.title,
                          fontSize = 13.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFF0F172A)
                        )
                        Text(
                          text = "පරිශීලක Drive PDF • ${attachedPdf.fileSize} • ${attachedPdf.uploadDate}",
                          fontSize = 10.sp,
                          color = Color(0xFF2563EB)
                        )
                      }
                    }

                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                      if (isAdmin) {
                        IconButton(
                          onClick = {
                            deletePdfTitle = attachedPdf.title
                            pendingDeleteAction = {
                              currentActiveUnit.attachedDrivePdfs.remove(attachedPdf)
                            }
                            showDeleteConfirmDialog = true
                          },
                          modifier = Modifier.size(36.dp)
                        ) {
                          Icon(
                            imageVector = Icons.Default.DeleteForever,
                            contentDescription = "Delete PDF",
                            tint = Color(0xFFDC2626),
                            modifier = Modifier.size(20.dp)
                          )
                        }
                      }

                      Button(
                        onClick = {
                          if (!isApproved) {
                            Toast.makeText(context, "🔒 මෙම පීඩීඑෆ් (PDF) සටහන් නැරඹීමට ඇඩ්මින් අනුමැතිය අවශ්‍ය වේ.", Toast.LENGTH_LONG).show()
                            onRequireApproval()
                          } else {
                            onOpenGoogleDrivePdfModal(
                              attachedPdf.driveUrl,
                              "${attachedPdf.title} (Google Drive)"
                            )
                          }
                        },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB)),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                      ) {
                        Icon(
                          imageVector = Icons.Default.RemoveRedEye,
                          contentDescription = null,
                          modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Drive එකෙන් කියවන්න", fontSize = 11.sp, fontWeight = FontWeight.Bold)
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

  // Dialog to attach / upload a new Google Drive PDF to this exact lesson
  if (showAttachDrivePdfDialog) {
    AlertDialog(
      onDismissRequest = { showAttachDrivePdfDialog = false },
      title = {
        Text(
          text = "📄 ඔබගේ Google Drive PDF එකතු කරන්න",
          style = MaterialTheme.typography.titleMedium,
          fontWeight = FontWeight.Bold,
          color = Color(0xFF1E1B4B)
        )
      },
      text = {
        Column {
          Text(
            text = "අදාළ පාඩම: ${targetUnitForUpload?.unitNumber} - ${targetUnitForUpload?.unitTitleSinhala}",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4338CA)
          )
          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = "ඔබගේ Google Drive එකේ ඇති PDF එකේ Shareable Link එක මෙතැනට ඇතුළත් කරන්න. එය ඇප් එක තුළින්ම සෘජුවම විවෘත වේ.",
            fontSize = 11.sp,
            color = Color(0xFF64748B)
          )
          Spacer(modifier = Modifier.height(12.dp))

          OutlinedTextField(
            value = inputPdfTitle,
            onValueChange = { inputPdfTitle = it },
            label = { Text("PDF ලේඛනයේ නම (Title)") },
            placeholder = { Text("උදා: 1 වන පාඩම කෙටි සටහන් සම්පූර්ණ PDF") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
          )

          Spacer(modifier = Modifier.height(10.dp))

          OutlinedTextField(
            value = inputDriveUrl,
            onValueChange = { inputDriveUrl = it },
            label = { Text("Google Drive Link (URL)") },
            placeholder = { Text("https://drive.google.com/file/d/...") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
          )
        }
      },
      confirmButton = {
        Button(
          onClick = {
            if (inputPdfTitle.isNotBlank() && inputDriveUrl.isNotBlank() && targetUnitForUpload != null) {
              val success = SyllabusRepository.attachDrivePdfToUnit(
                unitId = targetUnitForUpload!!.id,
                title = inputPdfTitle,
                driveUrl = inputDriveUrl
              )
              if (success) {
                Toast.makeText(context, "Google Drive PDF සාර්ථකව එක් කරන ලදී!", Toast.LENGTH_LONG).show()
                showAttachDrivePdfDialog = false
              }
            } else {
              Toast.makeText(context, "කරුණාකර නම සහ Drive Link එක ඇතුළත් කරන්න", Toast.LENGTH_SHORT).show()
            }
          },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4338CA))
        ) {
          Icon(Icons.Default.CloudUpload, contentDescription = null)
          Spacer(modifier = Modifier.width(6.dp))
          Text("PDF අමුණන්න (Attach)")
        }
      },
      dismissButton = {
        TextButton(onClick = { showAttachDrivePdfDialog = false }) {
          Text("අවලංගුයි")
        }
      }
    )
  }
}
