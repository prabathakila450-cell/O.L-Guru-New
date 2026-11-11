package com.example

import androidx.compose.animation.*
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.ui.theme.*
import kotlinx.coroutines.delay
import kotlin.random.Random

// --------------------------------------------------
// 1. DATA MODELS & JSON SCHEMA
// --------------------------------------------------

data class QuizQuestion(
  val question_id: Int,
  val question_text: String,
  val options: List<String>,
  val correct_option_index: Int,
  val explanation: String
)

data class QuizSet(
  val set_id: Int,
  val set_title: String,
  val time_limit_seconds: Int = 180,
  val questions: List<QuizQuestion>
)

data class SubjectQuizData(
  val grade: String,
  val subject: String,
  val short_notes_pdf_url: String = "",
  val quiz_sets: List<QuizSet>
)

data class FlashcardItem(
  val id: Int,
  val termOrQuestion: String,
  val definitionOrAnswer: String,
  val keyTakeaway: String
)

// Internal shuffled wrapper for anti-memorization
data class ShuffledQuestion(
  val originalId: Int,
  val questionText: String,
  val shuffledOptions: List<String>,
  val correctOptionIndex: Int,
  val explanation: String
)

// --------------------------------------------------
// 2. QUIZ REPOSITORY & AI GENERATOR
// --------------------------------------------------

object QuizRepository {

  fun getQuizDataForSubject(grade: String, subjectName: String, shortNoteUrl: String = ""): SubjectQuizData {
    val norm = normalizeSubjectKey(subjectName)
    val baseSets = generate10SetsForSubject(grade, subjectName, norm)
    return SubjectQuizData(
      grade = grade,
      subject = subjectName,
      short_notes_pdf_url = shortNoteUrl,
      quiz_sets = baseSets
    )
  }

  fun getFlashcardsForSubject(grade: String, subjectName: String): List<FlashcardItem> {
    val deckItems = ComprehensiveFlashcardRepository.getFlashcards(grade, subjectName, null)
    if (deckItems.isNotEmpty()) {
      return deckItems.map { deck ->
        FlashcardItem(
          id = deck.globalIndex,
          termOrQuestion = deck.questionFront,
          definitionOrAnswer = deck.answerBack,
          keyTakeaway = deck.unitCategory
        )
      }
    }
    val norm = normalizeSubjectKey(subjectName)
    return when (norm) {
      "geography" -> listOf(
        FlashcardItem(1, "ශ්‍රී ලංකාවේ භූ විෂමතා තලා 3", "වෙරළබඩ තැනිතලාව (0-30m), අභ්‍යන්තර සානුව (30-300m), මධ්‍යම කඳුකරය (>300m).", "පිදුරුතලාගල (2524m) උසම ස්ථානය වන අතර මහවැලි ගඟ මධ්‍යම කඳුකරයෙන් ඇරඹේ."),
        FlashcardItem(2, "මෝසම් සුළං සහ වැසි සමයන්", "නිරිතදිග මෝසම (මැයි-සැප්තැම්බර්), ඊසානදිග මෝසම (දෙසැම්බර්-පෙබරවාරි).", "අන්තර් මෝසම් සමයන්හි (අප්‍රේල් හා ඔක්තෝබර්) සංවහන වැසි ලැබේ.")
      )
      else -> listOf(
        FlashcardItem(1, "ක්‍රියාශීලී මතක් කිරීම (Active Recall)", "සටහන නැවත නැවත කියවනවාට වඩා ප්‍රශ්නවලට පිළිතුරු සෙවීමෙන් මතක ශක්තිය 300% කින් වැඩිවේ.", "Short Notes කියවීමෙන් පසු වහාම MCQ Quizzes වලට සහභාගී වන්න.")
      )
    }
  }

  private fun generate10SetsForSubject(grade: String, subjectName: String, norm: String): List<QuizSet> {
    val setsList = mutableListOf<QuizSet>()

    for (setIdx in 1..10) {
      val questions = mutableListOf<QuizQuestion>()
      val setTopic = getSubtopicForSet(norm, setIdx)

      for (qIdx in 1..10) {
        val qId = (setIdx - 1) * 10 + qIdx
        val generatedQ = buildQuestionForSubject(norm, grade, subjectName, setIdx, qIdx, setTopic)
        questions.add(generatedQ)
      }

      setsList.add(
        QuizSet(
          set_id = setIdx,
          set_title = "Set 0$setIdx - $setTopic",
          time_limit_seconds = 180,
          questions = questions.shuffled()
        )
      )
    }
    return setsList
  }

  private fun getSubtopicForSet(norm: String, setIndex: Int): String {
    return when (norm) {
      "science" -> when (setIndex) {
        1 -> "ජීවීන්ගේ ලක්ෂණ හා සෛල ව්‍යුහය"
        2 -> "පදාර්ථයේ ව්‍යුහය හා ආවර්තිතා වගුව"
        3 -> "ප්‍රභාසංස්ලේෂණය හා ශාක ක්‍රියාකාරීත්වය"
        4 -> "චලිතය, නිව්ටන් නියම හා බලය"
        5 -> "රසායනික බන්ධන හා ප්‍රතික්‍රියා"
        6 -> "ධාරා විද්‍යුතය හා පරිපථ"
        7 -> "ජාන විද්‍යාව හා ප්‍රවේණිය"
        8 -> "පරිසර පද්ධති හා ජෛව විවිධත්වය"
        9 -> "තරංග, ආලෝකය හා දෘෂ්ටිය"
        else -> "තාපය, පීඩනය හා ශක්තිය පරිවර්තන"
      }
      "geography" -> when (setIndex) {
        1 -> "ශ්‍රී ලංකාවේ භූ විෂමතා හා උස්බිම්"
        2 -> "වායුගෝලය, මෝසම් සුළං හා වර්ෂාපතනය"
        3 -> "පෘථිවි අභ්‍යන්තර ව්‍යුහය හා භූ තැටි විද්‍යාව"
        4 -> "ජල සම්පත, ගංගා ද්‍රෝಣಿ හා ජලවිදුලිය"
        5 -> "දේශගුණික කලාප හා ස්වාභාවික වෘක්ෂලතා"
        6 -> "ජනගහන ව්‍යාප්තිය හා ජන විකාශනය"
        7 -> "කෘෂිකර්මාන්තය, ධීවර කර්මාන්තය හා සම්පත්"
        8 -> "ප්‍රවාහනය, සන්නිවේදනය හා වෙළඳාම"
        9 -> "සමෝච්ච රේඛා සිතියම් විග්‍රහය"
        else -> "පරිසර ගැටලු, ආපදා කළමනාකරණය හා GIS"
      }
      "math" -> when (setIndex) {
        1 -> "සංඛ්‍යා රටා හා ප්‍රථමක සංඛ්‍යා"
        2 -> "භාග, දශම හා ප්‍රතිශත"
        3 -> "වීජීය ප්‍රකාශන හා සාධක"
        4 -> "සරල හා යුගලත් සමීකරණ"
        5 -> "පයිතගරස් ප්‍රමේයය හා ත්‍රිකෝණ"
        6 -> "වෘත්ත ප්‍රමේය හා ජ්‍යාමිතිය"
        7 -> "ක්ෂේත්‍රඵලය හා පරිමාව ගණනය"
        8 -> "සමාන්තර හා ගුණෝත්තර ශ්‍රේඪි"
        9 -> "සම්භාවිතාව හා නියැදි අවකාශ"
        else -> "සංඛ්‍යානය හා ප්‍රස්තාර විග්‍රහය"
      }
      "history" -> when (setIndex) {
        1 -> "ප්‍රාග් ඓතිහාසික යුගය හා ජනාවාස"
        2 -> "අනුරාධපුර යුගයේ ආරම්භය හා වාරි ශිෂ්ටාචාරය"
        3 -> "මහසෙන් හා ධාතුසේන රජවරුන්ගේ සේවය"
        4 -> "පොළොන්නරු රාජධානිය හා මහා පරාක්‍රමබාහු රජු"
        5 -> "දඹදෙණිය හා යාපහුව යුගයන්"
        6 -> "කෝට්ටේ රාජධානිය හා සාහිත්‍ය පුනරුදය"
        7 -> "පෘතුගීසි හා ලන්දේසි යටත් විජිත පාලනය"
        8 -> "උඩරට රාජධානිය හා 1815 ගිවිසුම"
        9 -> "1818 හා 1848 නිදහස් අරගල"
        else -> "1948 නිදහස හා නූතන ශ්‍රී ලංකාව"
      }
      "sinhala" -> when (setIndex) {
        1 -> "සිංහල අක්ෂර මාලාව හා අක්ෂර වින්‍යාසය"
        2 -> "නාම පද හා ක්‍රියා පද වර්ගීකරණය"
        3 -> "සන්ධි හා සමාස පද භාවිතය"
        4 -> "විභක්ති හා ප්‍රත්‍ය නීති"
        5 -> "ප්‍රස්ථාව පිරුළු හා තේරුම්"
        6 -> "යුගල පද හා ප්‍රතිවිරුද්ධ පද"
        7 -> "සම්භාව්‍ය සාහිත්‍ය කෘති හා කතුවරු"
        8 -> "කාව්‍ය රසවින්දනය හා ඡන්දස්"
        9 -> "ගද්‍ය පද්‍ය විචාර හා රචනා රටා"
        else -> "සංස්කරණ ලකුණු හා ව්‍යාකරණ රීති"
      }
      "buddhism" -> when (setIndex) {
        1 -> "සිද්ධාර්ථ කුමාරෝත්පත්තිය හා බෝසත් චරිතය"
        2 -> "බුද්ධත්වය හා ප්‍රථම ධර්ම දේශනාව"
        3 -> "චතුරාර්ය සත්‍ය හා පටිච්චසමුප්පාදය"
        4 -> "ආර්ය අෂ්ටාංගික මාර්ගය හා සීලය"
        5 -> "ත්‍රිපිටකය (සූත්‍ර, විනය, අභිධර්ම)"
        6 -> "සැරියුත් මුගලන් අග්‍රශ්‍රාවක චරිත"
        7 -> "ශ්‍රී ලංකාවට බුදුදහම ලැබීම (මිහිඳු හිමි)"
        8 -> "ථූපාරාමය හා රුවන්වැලි මහා සෑය"
        9 -> "ධර්ම සංගායනා ඉතිහාසය"
        else -> "බෞද්ධ සමාජ දර්ශනය හා සදාචාරය"
      }
      "ict" -> when (setIndex) {
        1 -> "පරිගණක දෘඩාංග හා උපාංග"
        2 -> "දත්ත හා තොරතුරු නියෝජනය (Binary/Hex)"
        3 -> "Logic Gates හා බූලීය වීජ ගණිතය"
        4 -> "මෙහෙයුම් පද්ධති (Operating Systems)"
        5 -> "වදන් සැකසුම් හා පැතුරුම්පත් (Spreadsheets)"
        6 -> "Database Management Systems (DBMS)"
        7 -> "පරිගණක ජාල හා අන්තර්ජාලය (Networking)"
        8 -> "HTML & CSS වෙබ් නිර්මාණය"
        9 -> "ක්‍රමලේඛන මූලධර්ම (Python/Pascal)"
        else -> "තොරතුරු ආරක්ෂාව හා සයිබර් ආචාරධර්ම"
      }
      "commerce" -> when (setIndex) {
        1 -> "ව්‍යාපාර පසුබිම හා මානව අවශ්‍යතා"
        2 -> "ව්‍යාපාර හිමිකාරිත්ව වර්ග"
        3 -> "ද්විත්ව සටහන් මූලධර්මය"
        4 -> "මූලික සටහන් පොත් හා ජර්නල"
        5 -> "ශේෂ පත්‍රය හා මූල්‍ය ප්‍රකාශන"
        6 -> "ලාභ අලාභ ගිණුම් සැකසීම"
        7 -> "වාණිජ බැංකු හා මූල්‍ය සේවා"
        8 -> "අලෙවිකරණය හා වෙළඳ දැන්වීම්"
        9 -> "රක්ෂණය හා අවදානම් කළමනාකරණය"
        else -> "මුදල් හා ජාත්‍යන්තර වෙළඳාම"
      }
      "health" -> when (setIndex) {
        1 -> "සමබල ආහාර වේලක් හා පෝෂණය"
        2 -> "ශරීර ස්කන්ධ දර්ශකය (BMI) හා සෞඛ්‍යය"
        3 -> "සංක්‍රාමික හා අසංක්‍රාමික රෝග"
        4 -> "මානසික සෞඛ්‍යය හා හැඟීම් පාලනය"
        5 -> "ප්‍රජනක සෞඛ්‍යය හා නවයොවුන් විය"
        6 -> "මත්ද්‍රව්‍ය නිවාරණය හා සෞඛ්‍ය සම්පන්න පුරුදු"
        7 -> "ප්‍රථමාධාර හා හදිසි අනතුරු ප්‍රතිකාර"
        8 -> "ශාරීරික යෝග්‍යතාවය හා ව්‍යායාම"
        9 -> "පරිසර සෞඛ්‍යය හා සනීපාරක්ෂාව"
        else -> "ප්‍රජා සෞඛ්‍ය සේවා හා ආරක්ෂාව"
      }
      "agri" -> when (setIndex) {
        1 -> "පාංශු විද්‍යාව හා පස් සංරචක"
        2 -> "ශාක පෝෂක (NPK) හා පොහොර භාවිතය"
        3 -> "බීජ නිෂ්පාදනය හා පැළ නඩත්තුව"
        4 -> "එළවළු හා ඵලභෝග වගා ක්‍රම"
        5 -> "ශාක රෝග හා පළිබෝධ පාලනය"
        6 -> "ගෘහස්ථ සත්ව පාලනය (කුකුළන් හා කිරි ගවයන්)"
        7 -> "ජල කළමනාකරණය හා බිංදු ජල වාරිමාර්ග"
        8 -> "අස්වනු නෙළීමෙන් පසු තාක්ෂණය"
        9 -> "කෘෂි ව්‍යාපාර හා ආර්ථිකය"
        else -> "තිරසර කෘෂිකර්මය හා කාබනික ගොවිතැන්"
      }
      "english" -> when (setIndex) {
        1 -> "Parts of Speech & Nouns"
        2 -> "Verb Tenses (Present, Past, Future)"
        3 -> "Active and Passive Voice"
        4 -> "Direct and Indirect Speech"
        5 -> "Prepositions and Conjunctions"
        6 -> "Reading Comprehension & Vocabulary"
        7 -> "Formal and Informal Letters"
        8 -> "Notices, Messages and Circulars"
        9 -> "Bar Charts & Pie Chart Interpretation"
        else -> "Essay Writing & Paragraph Structure"
      }
      else -> when (setIndex) {
        1 -> "මූලික සිද්ධාන්ත හා හැඳින්වීම"
        2 -> "ප්‍රධාන සංකල්ප හා විවරණ"
        3 -> "විභාග අනුමාන ප්‍රශ්නෝත්තර"
        4 -> "ප්‍රායෝගික යෙදීම් හා උදාහරණ"
        5 -> "විෂය නිර්දේශයේ ප්‍රධාන පාඩම්"
        6 -> "කෙටි සටහන් ඇසුරෙන් ප්‍රශ්න"
        7 -> "පසුගිය ප්‍රශ්න පත්‍ර ආශ්‍රිත ප්‍රශ්න"
        8 -> "අභියෝගාත්මක බහුවරණ ප්‍රශ්න"
        9 -> "ඉක්මන් පුනරීක්ෂණ ගැටළු"
        else -> "සම්පූර්ණ ආදර්ශ ප්‍රශ්නාවලිය"
      }
    }
  }

  private fun buildQuestionForSubject(
    norm: String,
    grade: String,
    subjectName: String,
    setIdx: Int,
    qIdx: Int,
    topic: String
  ): QuizQuestion {
    val qNumber = (setIdx - 1) * 10 + qIdx

    // Highly realistic, pedagogical Sinhala syllabus questions
    return when (norm) {
      "science" -> QuizBankScience.getQuestion(grade, setIdx, qIdx, qNumber, topic)
      "math" -> QuizBankMath.getQuestion(grade, setIdx, qIdx, qNumber, topic)
      "history" -> QuizBankHistory.getQuestion(grade, setIdx, qIdx, qNumber, topic)
      "geography" -> QuizBankGeography.getQuestion(grade, setIdx, qIdx, qNumber, topic)
      "buddhism" -> QuizBankBuddhism.getQuestion(grade, setIdx, qIdx, qNumber, topic)
      "sinhala" -> QuizBankSinhala.getQuestion(grade, setIdx, qIdx, qNumber, topic)
      "ict" -> QuizBankApplied.getIctQuestion(grade, setIdx, qIdx, qNumber, topic)
      "commerce" -> QuizBankApplied.getCommerceQuestion(grade, setIdx, qIdx, qNumber, topic)
      "health" -> QuizBankApplied.getHealthQuestion(grade, setIdx, qIdx, qNumber, topic)
      "agri" -> QuizBankApplied.getAgriQuestion(grade, setIdx, qIdx, qNumber, topic)
      "english" -> QuizBankApplied.getEnglishQuestion(grade, setIdx, qIdx, qNumber, topic)
      else -> QuizBankApplied.getElectiveQuestion(norm, grade, subjectName, setIdx, qIdx, qNumber, topic)
    }
  }

  fun shuffleQuizSet(quizSet: QuizSet): List<ShuffledQuestion> {
    return quizSet.questions.map { q ->
      val originalCorrectAnswer = q.options[q.correct_option_index]
      val shuffledOpts = q.options.shuffled(Random(System.currentTimeMillis() + q.question_id))
      val newCorrectIdx = shuffledOpts.indexOf(originalCorrectAnswer)

      ShuffledQuestion(
        originalId = q.question_id,
        questionText = q.question_text,
        shuffledOptions = shuffledOpts,
        correctOptionIndex = if (newCorrectIdx >= 0) newCorrectIdx else 0,
        explanation = q.explanation
      )
    }
  }
}

// --------------------------------------------------
// 3. UI COMPONENTS (DUAL PLACEMENT STRATEGY)
// --------------------------------------------------

/**
 * LOCATION 1: Inside Subject View Screen
 * Placed directly below the Short Notes PDF button.
 */
@Composable
fun PracticeQuizzesSection(
  grade: String,
  subject: SubjectItem,
  onStartQuizSet: (QuizSet) -> Unit,
  onOpenFlashcards: () -> Unit
) {
  val quizData = remember(grade, subject.nameSinhala) {
    QuizRepository.getQuizDataForSubject(grade, subject.nameSinhala)
  }

  Surface(
    shape = RoundedCornerShape(20.dp),
    color = Color(0xFFF8FAFC),
    border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
    modifier = Modifier
      .fillMaxWidth()
      .testTag("practice_quizzes_section")
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
      // Header with Title & Flashcard Action
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Box(
            modifier = Modifier
              .size(40.dp)
              .clip(CircleShape)
              .background(
                Brush.linearGradient(listOf(Color(0xFF6366F1), Color(0xFF4F46E5)))
              ),
            contentAlignment = Alignment.Center
          ) {
            Text("🧠", fontSize = 20.sp)
          }
          Spacer(modifier = Modifier.width(10.dp))
          Column {
            Text(
              text = "Practice Quizzes (ස්වයං පුහුණුව)",
              style = MaterialTheme.typography.titleMedium,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF1E293B)
            )
            Text(
              text = "කෙටි සටහන් ඇසුරෙන් ප්‍රශ්නාවලි 10ක් (100 MCQs)",
              style = MaterialTheme.typography.bodySmall,
              color = Color(0xFF64748B),
              fontSize = 11.sp
            )
          }
        }

        Surface(
          onClick = onOpenFlashcards,
          shape = RoundedCornerShape(10.dp),
          color = Color(0xFFEEF2FF),
          border = BorderStroke(1.dp, Color(0xFFC7D2FE)),
          modifier = Modifier.testTag("open_flashcards_btn")
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text("💡", fontSize = 12.sp)
            Spacer(modifier = Modifier.width(4.dp))
            Text(
              text = "Flashcards",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF4338CA)
            )
          }
        }
      }

      // Feature Info Badges
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFFECFDF5),
          border = BorderStroke(1.dp, Color(0xFFA7F3D0)),
          modifier = Modifier.weight(1f)
        ) {
          Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Icon(Icons.Default.Timer, contentDescription = "Timer", tint = Color(0xFF059669), modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text("විනාඩි 3ක ටයිමරය", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF065F46))
          }
        }

        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFFFEF3C7),
          border = BorderStroke(1.dp, Color(0xFFFDE68A)),
          modifier = Modifier.weight(1f)
        ) {
          Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Icon(Icons.Default.Autorenew, contentDescription = "Shuffle", tint = Color(0xFFD97706), modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text("අසීමිතව පුහුණු වන්න", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF92400E))
          }
        }
      }

      // 10 Quiz Sets List
      Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        quizData.quiz_sets.forEach { set ->
          QuizSetCardItem(
            quizSet = set,
            onStart = { onStartQuizSet(set) }
          )
        }
      }
    }
  }
}

@Composable
fun QuizSetCardItem(
  quizSet: QuizSet,
  onStart: () -> Unit
) {
  Card(
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
    modifier = Modifier
      .fillMaxWidth()
      .testTag("quiz_set_card_${quizSet.set_id}")
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.weight(1f)
      ) {
        Box(
          modifier = Modifier
            .size(38.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFF1F5F9)),
          contentAlignment = Alignment.Center
        ) {
          Text(
            text = "0${quizSet.set_id}",
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            color = Color(0xFF475569)
          )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column(modifier = Modifier.weight(1f)) {
          Text(
            text = quizSet.set_title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E293B),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
          Spacer(modifier = Modifier.height(2.dp))
          Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(
              shape = RoundedCornerShape(4.dp),
              color = Color(0xFFEEF2FF)
            ) {
              Text(
                text = "10 Questions",
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF4F46E5),
                modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
              )
            }
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "⏱️ 3 Mins",
              fontSize = 10.sp,
              color = Color(0xFF64748B),
              fontWeight = FontWeight.Medium
            )
          }
        }
      }

      Spacer(modifier = Modifier.width(8.dp))

      Button(
        onClick = onStart,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
        modifier = Modifier.testTag("start_quiz_btn_${quizSet.set_id}")
      ) {
        Text("Start Quiz", fontSize = 11.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(4.dp))
        Icon(Icons.Default.PlayArrow, contentDescription = "Start", modifier = Modifier.size(14.dp))
      }
    }
  }
}

/**
 * LOCATION 2: Inside PDF Viewer Screen
 * Modal Bottom Sheet presenting the Set 1-10 Quiz list without exiting the PDF viewer.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizSetsBottomSheet(
  grade: String,
  subjectName: String,
  onDismiss: () -> Unit,
  onStartQuizSet: (QuizSet) -> Unit,
  onOpenFlashcards: (() -> Unit)? = null
) {
  val quizData = remember(grade, subjectName) {
    QuizRepository.getQuizDataForSubject(grade, subjectName)
  }

  ModalBottomSheet(
    onDismissRequest = onDismiss,
    containerColor = Color.White,
    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)
        .padding(bottom = 32.dp),
      verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text("🧠", fontSize = 22.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "Test Your Knowledge (දැනුම පරීක්ෂාව)",
              style = MaterialTheme.typography.titleMedium,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF1E293B)
            )
          }
          Text(
            text = "PDF සටහන ආශ්‍රිත ප්‍රශ්නාවලි 10 (100 MCQs) සහ Flashcards",
            style = MaterialTheme.typography.bodySmall,
            color = Color(0xFF64748B),
            fontSize = 11.sp
          )
        }

        IconButton(onClick = onDismiss) {
          Icon(Icons.Default.Close, contentDescription = "Close", tint = Color(0xFF64748B))
        }
      }

      if (onOpenFlashcards != null) {
        Surface(
          onClick = {
            onDismiss()
            onOpenFlashcards()
          },
          shape = RoundedCornerShape(12.dp),
          color = Color(0xFFEEF2FF),
          border = BorderStroke(1.dp, Color(0xFFC7D2FE)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text("💡", fontSize = 18.sp)
              Spacer(modifier = Modifier.width(10.dp))
              Column {
                Text(
                  text = "Active Recall Flashcards (මතකය තහවුරු කරගන්න)",
                  fontWeight = FontWeight.Bold,
                  fontSize = 13.sp,
                  color = Color(0xFF3730A3)
                )
                Text(
                  text = "Flip Cards මගින් ප්‍රධාන සූත්‍ර හා කරුණු ක්ෂණිකව මතක් කරගන්න",
                  fontSize = 10.sp,
                  color = Color(0xFF6366F1)
                )
              }
            }
            Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Open", tint = Color(0xFF4F46E5), modifier = Modifier.size(16.dp))
          }
        }
      }

      HorizontalDivider(color = Color(0xFFE2E8F0))

      LazyColumn(
        modifier = Modifier
          .fillMaxWidth()
          .heightIn(max = 380.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        items(quizData.quiz_sets) { set ->
          QuizSetCardItem(
            quizSet = set,
            onStart = {
              onDismiss()
              onStartQuizSet(set)
            }
          )
        }
      }
    }
  }
}

// --------------------------------------------------
// 4. INTERACTIVE QUIZ ENGINE DIALOG (180s TIMER, SHUFFLING, INSTANT GRADING)
// --------------------------------------------------

@Composable
fun QuizEngineDialog(
  quizSet: QuizSet,
  onDismiss: () -> Unit,
  onRetake: (QuizSet) -> Unit = {}
) {
  // Anti-memorization shuffled questions
  var shuffledQuestions by remember(quizSet) {
    mutableStateOf(QuizRepository.shuffleQuizSet(quizSet))
  }

  var currentQuestionIndex by remember { mutableStateOf(0) }
  val userAnswers = remember { mutableStateMapOf<Int, Int>() } // questionIndex -> selectedOptionIndex

  var remainingSeconds by remember { mutableStateOf(quizSet.time_limit_seconds) }
  var isSubmitted by remember { mutableStateOf(false) }
  var isTimerRunning by remember { mutableStateOf(true) }

  // 180s Countdown Timer Engine
  LaunchedEffect(isTimerRunning, remainingSeconds, isSubmitted) {
    if (isTimerRunning && !isSubmitted && remainingSeconds > 0) {
      delay(1000L)
      remainingSeconds -= 1
      if (remainingSeconds <= 0) {
        isSubmitted = true
        isTimerRunning = false
      }
    }
  }

  Dialog(
    onDismissRequest = {
      if (isSubmitted) onDismiss()
    },
    properties = DialogProperties(usePlatformDefaultWidth = false)
  ) {
    Surface(
      shape = RoundedCornerShape(16.dp),
      color = Color.White,
      shadowElevation = 8.dp,
      modifier = Modifier
        .fillMaxWidth(0.98f)
        .fillMaxHeight(0.95f)
        .padding(4.dp)
        .testTag("quiz_engine_dialog")
    ) {
      if (!isSubmitted) {
        // ACTIVE QUIZ INTERFACE
        Column(
          modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp, vertical = 12.dp)
        ) {
          // Top Bar: Set Title & Live Timer
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
              IconButton(
                onClick = onDismiss,
                modifier = Modifier.size(32.dp)
              ) {
                Icon(Icons.Default.Close, contentDescription = "Close", tint = Color(0xFF64748B), modifier = Modifier.size(18.dp))
              }
              Spacer(modifier = Modifier.width(4.dp))
              Column {
                Text(
                  text = quizSet.set_title,
                  fontWeight = FontWeight.Bold,
                  fontSize = 12.sp,
                  color = Color(0xFF1E293B),
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
                Text(
                  text = "ප්‍රශ්න ${currentQuestionIndex + 1} / ${shuffledQuestions.size}",
                  fontSize = 10.sp,
                  color = Color(0xFF64748B)
                )
              }
            }

            // Live Countdown Timer Badge
            val minutes = remainingSeconds / 60
            val seconds = remainingSeconds % 60
            val timerColor = when {
              remainingSeconds <= 30 -> Color(0xFFDC2626)
              remainingSeconds <= 60 -> Color(0xFFD97706)
              else -> Color(0xFF059669)
            }

            Surface(
              shape = RoundedCornerShape(14.dp),
              color = timerColor.copy(alpha = 0.1f),
              border = BorderStroke(1.dp, timerColor.copy(alpha = 0.3f))
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Icon(
                  imageVector = Icons.Default.Timer,
                  contentDescription = "Timer",
                  tint = timerColor,
                  modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                  text = String.format("%02d:%02d", minutes, seconds),
                  fontWeight = FontWeight.Bold,
                  fontSize = 11.sp,
                  color = timerColor
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(6.dp))

          // Progress Track Dots (1 to 10)
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(3.dp)
          ) {
            shuffledQuestions.indices.forEach { idx ->
              val isAnswered = userAnswers.containsKey(idx)
              val isCurrent = currentQuestionIndex == idx
              val dotColor = when {
                isCurrent -> Color(0xFF4F46E5)
                isAnswered -> Color(0xFF10B981)
                else -> Color(0xFFE2E8F0)
              }

              Box(
                modifier = Modifier
                  .weight(1f)
                  .height(3.dp)
                  .clip(RoundedCornerShape(2.dp))
                  .background(dotColor)
              )
            }
          }

          Spacer(modifier = Modifier.height(8.dp))

          // Current Question Body
          val currentQuestion = shuffledQuestions[currentQuestionIndex]

          Column(
            modifier = Modifier
              .weight(1f)
              .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            Surface(
              shape = RoundedCornerShape(12.dp),
              color = Color(0xFFF8FAFC),
              border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(10.dp)) {
                Text(
                  text = "ප්‍රශ්න අංක 0${currentQuestionIndex + 1}",
                  fontWeight = FontWeight.Bold,
                  fontSize = 10.sp,
                  color = Color(0xFF4F46E5)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                  text = currentQuestion.questionText,
                  style = MaterialTheme.typography.bodyMedium,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF1E293B),
                  lineHeight = 19.sp
                )
              }
            }

            // 4 Options
            currentQuestion.shuffledOptions.forEachIndexed { optIdx, optText ->
              val isSelected = userAnswers[currentQuestionIndex] == optIdx
              val optionLetter = ('A' + optIdx).toString()

              Surface(
                onClick = { userAnswers[currentQuestionIndex] = optIdx },
                shape = RoundedCornerShape(10.dp),
                color = if (isSelected) Color(0xFFEEF2FF) else Color.White,
                border = BorderStroke(
                  width = if (isSelected) 2.dp else 1.dp,
                  color = if (isSelected) Color(0xFF4F46E5) else Color(0xFFE2E8F0)
                ),
                modifier = Modifier
                  .fillMaxWidth()
                  .testTag("option_${currentQuestionIndex}_$optIdx")
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 10.dp, vertical = 9.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Box(
                    modifier = Modifier
                      .size(26.dp)
                      .clip(CircleShape)
                      .background(if (isSelected) Color(0xFF4F46E5) else Color(0xFFF1F5F9)),
                    contentAlignment = Alignment.Center
                  ) {
                    Text(
                      text = optionLetter,
                      fontWeight = FontWeight.Bold,
                      fontSize = 11.sp,
                      color = if (isSelected) Color.White else Color(0xFF64748B)
                    )
                  }

                  Spacer(modifier = Modifier.width(8.dp))

                  Text(
                    text = optText,
                    fontSize = 12.sp,
                    color = if (isSelected) Color(0xFF1E293B) else Color(0xFF334155),
                    fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                    lineHeight = 17.sp,
                    modifier = Modifier.weight(1f)
                  )

                  if (isSelected) {
                    Icon(
                      imageVector = Icons.Default.CheckCircle,
                      contentDescription = "Selected",
                      tint = Color(0xFF4F46E5),
                      modifier = Modifier.size(16.dp)
                    )
                  }
                }
              }
            }
          }

          // Bottom Navigation Buttons
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            if (currentQuestionIndex > 0) {
              OutlinedButton(
                onClick = { currentQuestionIndex -= 1 },
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
              ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Prev", modifier = Modifier.size(14.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("කලින්", fontSize = 11.sp)
              }
            } else {
              Spacer(modifier = Modifier.width(10.dp))
            }

            if (currentQuestionIndex < shuffledQuestions.size - 1) {
              Button(
                onClick = { currentQuestionIndex += 1 },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
              ) {
                Text("ඊළඟ ප්‍රශ්නය", fontSize = 11.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Icon(Icons.Default.ArrowForward, contentDescription = "Next", modifier = Modifier.size(14.dp))
              }
            } else {
              Button(
                onClick = {
                  isSubmitted = true
                  isTimerRunning = false
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                modifier = Modifier.testTag("submit_quiz_btn")
              ) {
                Icon(Icons.Default.Check, contentDescription = "Submit", modifier = Modifier.size(14.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("පිළිතුරු භාර දෙන්න (Submit)", fontSize = 11.sp, fontWeight = FontWeight.Bold)
              }
            }
          }
        }
      } else {
        // --------------------------------------------------
        // RESULT & REVIEW SCREEN
        // --------------------------------------------------
        val correctCount = shuffledQuestions.indices.count { idx ->
          userAnswers[idx] == shuffledQuestions[idx].correctOptionIndex
        }
        val totalQuestions = shuffledQuestions.size
        val scorePercent = (correctCount * 100) / totalQuestions

        QuizResultReviewContent(
          quizTitle = quizSet.set_title,
          correctCount = correctCount,
          totalQuestions = totalQuestions,
          scorePercent = scorePercent,
          shuffledQuestions = shuffledQuestions,
          userAnswers = userAnswers,
          onTryAgain = {
            // Re-shuffle options for anti-memorization & reset timer
            shuffledQuestions = QuizRepository.shuffleQuizSet(quizSet)
            userAnswers.clear()
            currentQuestionIndex = 0
            remainingSeconds = quizSet.time_limit_seconds
            isSubmitted = false
            isTimerRunning = true
          },
          onClose = onDismiss
        )
      }
    }
  }
}

// --------------------------------------------------
// 5. RESULT & REVIEW CONTENT
// --------------------------------------------------

@Composable
fun QuizResultReviewContent(
  quizTitle: String,
  correctCount: Int,
  totalQuestions: Int,
  scorePercent: Int,
  shuffledQuestions: List<ShuffledQuestion>,
  userAnswers: Map<Int, Int>,
  onTryAgain: () -> Unit,
  onClose: () -> Unit
) {
  val (feedbackMsg, feedbackColor, feedbackBadge) = when {
    scorePercent >= 80 -> Triple("ඉතා හොඳයි! විශිෂ්ට සාමාර්ථයක්! 🎉", Color(0xFF059669), "EXCELLENT")
    scorePercent >= 50 -> Triple("හොඳයි! තවදුරටත් පුහුණු වන්න! 👍", Color(0xFFD97706), "GOOD")
    else -> Triple("නැවත සටහන කියවා උත්සාහ කරන්න! 📖", Color(0xFFDC2626), "NEEDS REVIEW")
  }

  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp)
  ) {
    // Header & Close
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "ප්‍රතිඵල හා විවරණය (Results & Review)",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF1E293B)
      )
      IconButton(onClick = onClose) {
        Icon(Icons.Default.Close, contentDescription = "Close", tint = Color(0xFF64748B))
      }
    }

    Spacer(modifier = Modifier.height(8.dp))

    // Score Summary Card
    Surface(
      shape = RoundedCornerShape(16.dp),
      color = feedbackColor.copy(alpha = 0.08f),
      border = BorderStroke(1.dp, feedbackColor.copy(alpha = 0.3f)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Box(
          modifier = Modifier
            .size(68.dp)
            .clip(CircleShape)
            .background(feedbackColor),
          contentAlignment = Alignment.Center
        ) {
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
              text = "$scorePercent%",
              fontWeight = FontWeight.Bold,
              fontSize = 16.sp,
              color = Color.White
            )
            Text(
              text = "$correctCount/$totalQuestions",
              fontSize = 10.sp,
              color = Color.White.copy(alpha = 0.9f)
            )
          }
        }

        Spacer(modifier = Modifier.width(14.dp))

        Column(modifier = Modifier.weight(1f)) {
          Surface(
            shape = RoundedCornerShape(4.dp),
            color = feedbackColor
          ) {
            Text(
              text = feedbackBadge,
              fontSize = 9.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = feedbackMsg,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            color = feedbackColor
          )
          Text(
            text = "$quizTitle • ක්ෂණික ස්වයං ඇගයීම",
            fontSize = 11.sp,
            color = Color(0xFF64748B)
          )
        }
      }
    }

    Spacer(modifier = Modifier.height(12.dp))

    Text(
      text = "සවිස්තරාත්මක විවරණය (Detailed Question Review):",
      fontWeight = FontWeight.Bold,
      fontSize = 12.sp,
      color = Color(0xFF1E293B)
    )

    Spacer(modifier = Modifier.height(6.dp))

    // Scrollable Review List
    LazyColumn(
      modifier = Modifier
        .weight(1f)
        .fillMaxWidth(),
      verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
      itemsIndexed(shuffledQuestions) { idx, q ->
        val userChosen = userAnswers[idx]
        val isCorrect = userChosen == q.correctOptionIndex

        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color.White),
          border = BorderStroke(1.dp, if (isCorrect) Color(0xFFA7F3D0) else Color(0xFFFECACA)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = "ප්‍රශ්න 0${idx + 1}",
                fontWeight = FontWeight.Bold,
                fontSize = 11.sp,
                color = if (isCorrect) Color(0xFF059669) else Color(0xFFDC2626)
              )

              Surface(
                shape = RoundedCornerShape(6.dp),
                color = if (isCorrect) Color(0xFFECFDF5) else Color(0xFFFEF2F2)
              ) {
                Text(
                  text = if (isCorrect) "✅ නිවැරදියි (+1)" else "❌ වැරදියි (0)",
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = if (isCorrect) Color(0xFF059669) else Color(0xFFDC2626),
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = q.questionText,
              fontWeight = FontWeight.SemiBold,
              fontSize = 12.sp,
              color = Color(0xFF1E293B)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Highlighted Options
            q.shuffledOptions.forEachIndexed { optIdx, optText ->
              val isUserPicked = userChosen == optIdx
              val isTargetCorrect = optIdx == q.correctOptionIndex

              val (bgCol, borderCol, textCol) = when {
                isTargetCorrect -> Triple(Color(0xFFECFDF5), Color(0xFF059669), Color(0xFF065F46))
                isUserPicked -> Triple(Color(0xFFFEF2F2), Color(0xFFDC2626), Color(0xFF991B1B))
                else -> Triple(Color(0xFFF8FAFC), Color(0xFFE2E8F0), Color(0xFF64748B))
              }

              Surface(
                shape = RoundedCornerShape(8.dp),
                color = bgCol,
                border = BorderStroke(1.dp, borderCol),
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(vertical = 2.dp)
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(
                    text = ('A' + optIdx).toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    color = textCol
                  )
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = optText,
                    fontSize = 11.sp,
                    color = textCol,
                    fontWeight = if (isTargetCorrect || isUserPicked) FontWeight.Bold else FontWeight.Normal,
                    modifier = Modifier.weight(1f)
                  )
                  if (isTargetCorrect) {
                    Text(" (නිවැරදි පිළිතුර)", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF059669))
                  }
                }
              }
            }

            // Step-by-Step Explanation Box
            Spacer(modifier = Modifier.height(8.dp))
            Surface(
              shape = RoundedCornerShape(8.dp),
              color = Color(0xFFF0FDF4),
              border = BorderStroke(1.dp, Color(0xFFDCFCE7)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.Top
              ) {
                Text("💡", fontSize = 12.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Column {
                  Text(
                    text = "විවරණය (Explanation):",
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    color = Color(0xFF166534)
                  )
                  Text(
                    text = q.explanation,
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

    Spacer(modifier = Modifier.height(10.dp))

    // Action Buttons: Try Again & Close
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
      Button(
        onClick = onTryAgain,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
          .weight(1f)
          .testTag("try_again_quiz_btn")
      ) {
        Icon(Icons.Default.Autorenew, contentDescription = "Retry", modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.width(6.dp))
        Text("නැවත උත්සාහ කරන්න (Try Again)", fontSize = 11.sp, fontWeight = FontWeight.Bold)
      }

      OutlinedButton(
        onClick = onClose,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.weight(0.7f)
      ) {
        Text("ආපසු විෂයට", fontSize = 11.sp, color = Color(0xFF334155))
      }
    }
  }
}

// --------------------------------------------------
// 6. FLASHCARDS VIEWER DIALOG (ACTIVE RECALL)
// --------------------------------------------------

@Composable
fun FlashcardsViewerDialog(
  grade: String,
  subjectName: String,
  onDismiss: () -> Unit
) {
  val flashcards = remember(grade, subjectName) {
    QuizRepository.getFlashcardsForSubject(grade, subjectName)
  }
  var currentIndex by remember { mutableStateOf(0) }
  var isFlipped by remember { mutableStateOf(false) }
  var isDarkMode by remember { mutableStateOf(true) }

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false)
  ) {
    Card(
      shape = RoundedCornerShape(20.dp),
      colors = CardDefaults.cardColors(
        containerColor = if (isDarkMode) Color(0xFF0F172A) else Color.White
      ),
      border = BorderStroke(1.dp, if (isDarkMode) Color(0xFF334155) else Color(0xFFE2E8F0)),
      elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
      modifier = Modifier
        .fillMaxWidth(0.92f)
        .wrapContentHeight()
        .padding(12.dp)
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
      ) {
        // Header
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text("💡", fontSize = 20.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Column {
              Text(
                text = "Flashcards පුනරීක්ෂණය",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = if (isDarkMode) Color.White else Color(0xFF1E293B)
              )
              Text(
                text = "$subjectName • කාඩ්පත් ${currentIndex + 1} / ${flashcards.size}",
                fontSize = 11.sp,
                color = if (isDarkMode) Color(0xFF38BDF8) else Color(0xFF64748B)
              )
            }
          }

          Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { isDarkMode = !isDarkMode }) {
              Text(if (isDarkMode) "☀️" else "🌙", fontSize = 16.sp)
            }
            IconButton(onClick = onDismiss) {
              Icon(
                Icons.Default.Close, 
                contentDescription = "Close", 
                tint = if (isDarkMode) Color(0xFFCBD5E1) else Color(0xFF64748B)
              )
            }
          }
        }

        if (flashcards.isNotEmpty()) {
          val card = flashcards[currentIndex]

          // Interactive Flip Card Surface
          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
              containerColor = if (isDarkMode) {
                if (isFlipped) Color(0xFF064E3B) else Color(0xFF1E293B)
              } else {
                if (isFlipped) Color(0xFFF0FDF4) else Color(0xFFEEF2FF)
              }
            ),
            border = BorderStroke(
              width = 1.5.dp,
              color = if (isDarkMode) {
                if (isFlipped) Color(0xFF10B981) else Color(0xFF6366F1)
              } else {
                if (isFlipped) Color(0xFF86EFAC) else Color(0xFFC7D2FE)
              }
            ),
            modifier = Modifier
              .fillMaxWidth()
              .height(200.dp)
              .clickable { isFlipped = !isFlipped }
              .testTag("flashcard_item")
          ) {
            Column(
              modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
              horizontalAlignment = Alignment.CenterHorizontally,
              verticalArrangement = Arrangement.Center
            ) {
              Surface(
                shape = RoundedCornerShape(6.dp),
                color = if (isFlipped) Color(0xFF16A34A) else Color(0xFF4F46E5)
              ) {
                Text(
                  text = if (isFlipped) "✅ පිළිතුර / විවරණය (Tap to Flip)" else "❓ සංකල්පය / ප්‍රශ්නය (Tap to Reveal)",
                  color = Color.White,
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                )
              }

              Spacer(modifier = Modifier.height(12.dp))

              Text(
                text = if (isFlipped) card.definitionOrAnswer else card.termOrQuestion,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = if (isDarkMode) Color.White else (if (isFlipped) Color(0xFF14532D) else Color(0xFF1E293B)),
                textAlign = TextAlign.Center,
                lineHeight = 22.sp
              )

              if (isFlipped && card.keyTakeaway.isNotBlank()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                  text = "📌 ${card.keyTakeaway}",
                  fontSize = 11.sp,
                  color = if (isDarkMode) Color(0xFFFEF08A) else Color(0xFF15803D),
                  textAlign = TextAlign.Center
                )
              }
            }
          }

          // Navigation Controls
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            OutlinedButton(
              onClick = {
                if (currentIndex > 0) {
                  currentIndex -= 1
                  isFlipped = false
                }
              },
              enabled = currentIndex > 0,
              colors = ButtonDefaults.outlinedButtonColors(
                containerColor = if (isDarkMode) Color(0xFF1E293B) else Color.Transparent,
                contentColor = if (isDarkMode) Color.White else Color(0xFF1E293B)
              ),
              border = BorderStroke(1.dp, if (isDarkMode) Color(0xFF475569) else Color(0xFFCBD5E1)),
              shape = RoundedCornerShape(8.dp)
            ) {
              Icon(
                Icons.AutoMirrored.Filled.ArrowBack, 
                contentDescription = "Prev", 
                modifier = Modifier.size(16.dp),
                tint = if (isDarkMode) Color.White else Color(0xFF1E293B)
              )
              Spacer(modifier = Modifier.width(4.dp))
              Text("කලින් කාඩ්පත", fontSize = 11.sp, color = if (isDarkMode) Color.White else Color(0xFF1E293B))
            }

            Button(
              onClick = {
                if (currentIndex < flashcards.size - 1) {
                  currentIndex += 1
                  isFlipped = false
                } else {
                  onDismiss()
                }
              },
              colors = ButtonDefaults.buttonColors(
                containerColor = if (isDarkMode) Color(0xFF0284C7) else Color(0xFF4F46E5)
              ),
              shape = RoundedCornerShape(8.dp)
            ) {
              Text(
                if (currentIndex < flashcards.size - 1) "ඊළඟ කාඩ්පත" else "අවසන් කරන්න", 
                fontSize = 11.sp,
                color = Color.White
              )
              Spacer(modifier = Modifier.width(4.dp))
              Icon(Icons.Default.ArrowForward, contentDescription = "Next", modifier = Modifier.size(16.dp), tint = Color.White)
            }
          }
        }
      }
    }
  }
}
