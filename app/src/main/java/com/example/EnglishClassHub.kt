package com.example

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.content.ContextCompat
import java.util.Locale

// ==============================================================================
// EXPANDED DATA MODELS FOR COMPREHENSIVE ENGLISH SUITE
// ==============================================================================

data class InteractiveGrammarQuiz(
  val id: String,
  val category: String, // "TENSES", "ACTIVE_PASSIVE", "DIRECT_INDIRECT", "PREPOSITIONS", "CONJUNCTIONS"
  val question: String,
  val sinhalaPrompt: String,
  val options: List<String>,
  val correctIndex: Int,
  val explanation: String
)

data class SentencePuzzleItem(
  val id: String,
  val scrambledWords: List<String>,
  val correctSentence: String,
  val sinhalaMeaning: String,
  val hint: String
)

data class DialogueConversation(
  val id: String,
  val title: String,
  val situation: String,
  val dialogueLines: List<DialogueLine>
)

data class DialogueLine(
  val speaker: String,
  val englishText: String,
  val sinhalaText: String
)

data class MiniDictWord(
  val word: String,
  val pos: String,
  val sinhala: String,
  val englishDef: String,
  val example: String,
  val synonyms: List<String>
)

data class ListeningQuizAudio(
  val id: String,
  val title: String,
  val audioScript: String,
  val sinhalaSummary: String,
  val questions: List<ListeningQuestion>
)

data class ListeningQuestion(
  val questionText: String,
  val options: List<String>,
  val correctIndex: Int,
  val explanation: String
)

// ==============================================================================
// REPOSITORY FOR ADVANCED ENGLISH CONTENT
// ==============================================================================

object AdvancedEnglishRepository {

  fun getGrammarQuizzes(): List<InteractiveGrammarQuiz> {
    return listOf(
      InteractiveGrammarQuiz(
        id = "gq_1",
        category = "Tenses",
        question = "Yesterday, while Nuwan _____ his homework, the electricity went out.",
        sinhalaPrompt = "ඊයේ නුවන් ගෙදර වැඩ කරමින් සිටියදී විදුලිය විසන්ධි විය.",
        options = listOf("1. was doing", "2. is doing", "3. did", "4. does"),
        correctIndex = 0,
        explanation = "අතීතයේ එක් ක්‍රියාවක් සිදුවෙමින් පවතිද්දී (Past Continuous - was doing) තවත් සිදුවීමක් විය (went out)."
      ),
      InteractiveGrammarQuiz(
        id = "gq_2",
        category = "Active / Passive",
        question = "Convert to Passive: 'The chef cooked a delicious meal.'",
        sinhalaPrompt = "කර්මකාරක වාක්‍යයට හරවන්න: 'The chef cooked a delicious meal.'",
        options = listOf(
          "1. A delicious meal is cooked by the chef.",
          "2. A delicious meal was cooked by the chef.",
          "3. A delicious meal cooked the chef.",
          "4. The chef was cooking a delicious meal."
        ),
        correctIndex = 1,
        explanation = "Past Simple (cooked) කර්මකාරක කිරීමේදී was/were + V3 (was cooked) යෙදේ."
      ),
      InteractiveGrammarQuiz(
        id = "gq_3",
        category = "Reported Speech",
        question = "Direct: Anula said, 'I will visit Kandy tomorrow.'\nReported: Anula said that she _____ visit Kandy the following day.",
        sinhalaPrompt = "අනුලා පැවසුවේ ඇය පසුදා මහනුවරට යන බවයි.",
        options = listOf("1. will", "2. would", "3. shall", "4. was"),
        correctIndex = 1,
        explanation = "Reported Speech වලදී 'will' පදය 'would' බවට පරිවර්තනය වේ."
      ),
      InteractiveGrammarQuiz(
        id = "gq_4",
        category = "Prepositions",
        question = "The train arrived _____ the platform _____ exactly 8:15 AM.",
        sinhalaPrompt = "දුම්රිය නියමිත වේලාවට පැමිණියේය.",
        options = listOf("1. in / on", "2. at / at", "3. on / in", "4. to / for"),
        correctIndex = 1,
        explanation = "ස්ථානයකට (platform) 'at' ද නිශ්චිත වේලාවකට (8:15 AM) 'at' ද යෙදේ."
      ),
      InteractiveGrammarQuiz(
        id = "gq_5",
        category = "Conditional Clauses",
        question = "If it _____ tomorrow, we will cancel the school sports match.",
        sinhalaPrompt = "හෙට වැස්සොත් ක්‍රීඩා තරගය අවලංගු කෙරේ (Type 1 Conditional).",
        options = listOf("1. rains", "2. will rain", "3. rained", "4. is raining"),
        correctIndex = 0,
        explanation = "First Conditional (If + Present Simple, will + Verb 1). එබැවින් 'rains' නිවැරදිය. If clause තුළ 'will' නොයෙදේ."
      ),
      InteractiveGrammarQuiz(
        id = "gq_6",
        category = "Relative Clauses",
        question = "The girl _____ won the gold medal in the 100m sprint is my cousin.",
        sinhalaPrompt = "මීටර් 100 ධාවන තරගයෙන් රන් පදක්කම දිනූ දැරිය මගේ ඥාති සොහොයුරියයි.",
        options = listOf("1. which", "2. who", "3. whose", "4. whom"),
        correctIndex = 1,
        explanation = "පුද්ගලයෙකු (The girl) විස්තර කිරීමට Relative Pronoun එක ලෙස 'who' භාවිත කළ යුතුය."
      ),
      InteractiveGrammarQuiz(
        id = "gq_7",
        category = "Subject-Verb Agreement",
        question = "Neither Kasun nor his friends _____ present at the meeting yesterday.",
        sinhalaPrompt = "ඊයේ රැස්වීමට කසුන්වත් ඔහුගේ මිතුරන්වත් පැමිණ සිටියේ නැත.",
        options = listOf("1. was", "2. were", "3. is", "4. are"),
        correctIndex = 1,
        explanation = "'Neither... nor' සම්බන්ධකයේදී ක්‍රියා පදයට ආසන්නතම Subject එක (his friends - බහුවචන) අනුව ක්‍රියා පදය තෝරාගත යුතුය. අතීත කාල බැවින් 'were' නිවැරදිය."
      ),
      InteractiveGrammarQuiz(
        id = "gq_8",
        category = "Conjunctions",
        question = "_____ he was extremely tired, he completed his science project on time.",
        sinhalaPrompt = "ඔහු දැඩි තෙහෙට්ටුවකින් පසුවුවද, නියමිත වේලාවට විද්‍යා ව්‍යාපෘතිය අවසන් කළේය.",
        options = listOf("1. Because", "2. Although", "3. Therefore", "4. So"),
        correctIndex = 1,
        explanation = "පරස්පර අදහස් දෙකක් (වෙහෙස වී සිටියද වැඩ අවසන් කිරීම) සම්බන්ධ කිරීමට 'Although' (කෙසේ වෙතත් / එසේ වුවද) යෙදේ."
      ),
      InteractiveGrammarQuiz(
        id = "gq_9",
        category = "Articles & Quantifiers",
        question = "Sunil bought _____ honest boy's bicycle and gave him _____ unique gift in return.",
        sinhalaPrompt = "සුනිල් අවංක පිරිමි ළමයාගේ පාපැදිය මිලදී ගෙන ඒ වෙනුවට සුවිශේෂී තෑග්ගක් ලබා දුන්නේය.",
        options = listOf("1. a / an", "2. an / a", "3. a / a", "4. an / an"),
        correctIndex = 1,
        explanation = "'honest' යන්නෙහි මුල් ශබ්දය ස්වර ශබ්දයකි (/ɒ/), එබැවින් 'an honest'. නමුත් 'unique' හි මුල් ශබ්දය ව්‍යංජන /j/ ශබ්දයකි, එබැවින් 'a unique' වේ."
      ),
      InteractiveGrammarQuiz(
        id = "gq_10",
        category = "Conditionals Type 2",
        question = "If I _____ enough money, I would travel around the whole world.",
        sinhalaPrompt = "මා සතුව ප්‍රමාණවත් මුදලක් තිබුණේ නම්, මම මුළු ලෝකය වටා සංචාරය කරන්නෙමි.",
        options = listOf("1. have", "2. had", "3. will have", "4. would have"),
        correctIndex = 1,
        explanation = "Second Conditional (අතාත්වික/මනඃකල්පිත අවස්ථා): If + Simple Past (had), would + Verb 1 (would travel)."
      ),
      InteractiveGrammarQuiz(
        id = "gq_11",
        category = "Passive Voice",
        question = "The historic temple in our village _____ by King Parakramabahu in the 12th century.",
        sinhalaPrompt = "අප ගමේ ඓතිහාසික විහාරය 12 වන සියවසේදී මහා පරාක්‍රමබාහු රජු විසින් ගොඩනගන ලදී.",
        options = listOf("1. built", "2. was built", "3. is built", "4. has built"),
        correctIndex = 1,
        explanation = "අතීතයේ කෙනෙකු විසින් කරන ලද ක්‍රියාවක් විස්තර කරන විට Past Passive (was + V3 = was built) යොදනු ලැබේ."
      ),
      InteractiveGrammarQuiz(
        id = "gq_12",
        category = "Modals",
        question = "You _____ wear a helmet when riding a bicycle or motorbike on main roads.",
        sinhalaPrompt = "ප්‍රධාන මාර්ගවල පාපැදි හෝ යතුරුපැදි පදින විට ඔබ අනිවාර්යයෙන්ම හිස්වැස්මක් පැළඳිය යුතුය.",
        options = listOf("1. might", "2. must", "3. would", "4. could"),
        correctIndex = 1,
        explanation = "නීතියක් හෝ දැඩි අනිවාර්ය යුතුකමක් දැක්වීමට 'must' යන Modal verb එක භාවිත කෙරේ."
      )
    )
  }

  fun getSentencePuzzles(): List<SentencePuzzleItem> {
    return SentencePuzzleRepository.getAllPuzzlesFlat()
  }

  fun getSentencePuzzleCategories(): List<SentencePuzzleCategory> {
    return SentencePuzzleRepository.getAllCategories()
  }

  fun getDialogues(): List<DialogueConversation> {
    return EnglishExpandedContentData.getExpandedDialogues()
  }

  fun getOldDialogues(): List<DialogueConversation> {
    return listOf(
      DialogueConversation(
        id = "dia_1",
        title = "🏦 At the Bank (බැංකුවේදී ගිණුමක් විවෘත කිරීම)",
        situation = "A student visits the bank to open a new savings account.",
        dialogueLines = listOf(
          DialogueLine("Student", "Good morning, sir. I would like to open a student savings account.", "සුබ උදෑසනක් මහත්මයා, මට ශිෂ්‍ය ඉතිරිකිරීමේ ගිණුමක් විවෘත කිරීමට අවශ්‍යයි."),
          DialogueLine("Bank Officer", "Good morning! Please bring your National Identity Card and a copy of your birth certificate.", "සුබ උදෑසනක්! කරුණාකර ඔබගේ ජාතික හැඳුනුම්පත සහ උප්පැන්න සහතිකයේ පිටපතක් රැගෙන එන්න."),
          DialogueLine("Student", "Here are the original documents and photocopies, sir.", "මෙන්න මුල් ලේඛන සහ ඡායාපිටපත් මහත්මයා."),
          DialogueLine("Bank Officer", "Great! Kindly fill out this application form and place your signature here.", "ඉතා හොඳයි! කරුණාකර මෙම අයදුම්පත පුරවා මෙතැනින් අත්සන යොදන්න."),
          DialogueLine("Student", "Thank you very much for your kind assistance, sir.", "ඔබගේ කාරුණික සහයෝගයට ඉතාමත් ස්තූතියි මහත්මයා.")
        )
      ),
      DialogueConversation(
        id = "dia_2",
        title = "🩺 Consulting a Doctor (වෛද්‍යවරයෙකු හමුවීම)",
        situation = "Describing symptoms and receiving medical advice.",
        dialogueLines = listOf(
          DialogueLine("Doctor", "Hello Amal, how can I help you today? What seems to be the problem?", "ආයුබෝවන් අමල්, මට අද ඔබට උදවු කළ හැක්කේ කෙසේද? ඔබට ඇති අපහසුතාවය කුමක්ද?"),
          DialogueLine("Patient", "Doctor, I have had a severe sore throat, fever, and headache since yesterday.", "ඩොක්ටර්, ඊයේ සිට මට දැඩි උගුරේ අමාරුවක්, උණ සහ හිසරදය පවතී."),
          DialogueLine("Doctor", "Let me check your temperature and chest. Open your mouth and say 'Ah'.", "මම ඔබගේ ශරීර උෂ්ණත්වය හා පපුව පරීක්ෂා කරන්නම්. කට ඇර 'ආ' කියන්න."),
          DialogueLine("Doctor", "You have a mild viral flu. Take these medicines three times a day after meals and drink plenty of warm water.", "ඔබට ඇත්තේ සුළු වෛරස් උණ තත්ත්වයක්. කෑමට පසු දිනකට තුන් වරක් මේ බෙහෙත් බී උණුසුම් ජලය වැඩිපුර පානය කරන්න."),
          DialogueLine("Patient", "Understood, doctor. Thank you for the advice.", "තේරුණා ඩොක්ටර්. උපදෙස් වලට ස්තූතියි.")
        )
      ),
      DialogueConversation(
        id = "dia_3",
        title = "🗺️ Asking for Directions (මඟතොට විමසීම)",
        situation = "Finding the way to the public library in the city.",
        dialogueLines = listOf(
          DialogueLine("Tourist/Student", "Excuse me, could you please tell me the way to the Public Library?", "සමාවෙන්න, කරුණාකර මහජන පුස්තකාලයට යන මාර්ගය මට පැහැදිලි කළ හැකිද?"),
          DialogueLine("Local Citizen", "Sure! Walk straight along this street for 200 meters, then turn left at the clock tower.", "අනිවාර්යයෙන්ම! මේ පාරේ මීටර් 200ක් කෙළින්ම ගොස් ඔරලෝසු කණුව ළඟින් වමට හැරෙන්න."),
          DialogueLine("Local Citizen", "It is right next to the town hall. You cannot miss it.", "එය පිහිටා තිබෙන්නේ නගර ශාලාවට යාබදවයි."),
          DialogueLine("Tourist/Student", "Is it within walking distance or should I take a bus?", "එය පයින් යා හැකි දුරකද නැතහොත් බස් රථයක යා යුතුද?"),
          DialogueLine("Local Citizen", "It's only a five-minute walk from here.", "මෙතැන් සිට විනාඩි 5ක පමණ පයින් යන දුරක් පමණයි."),
          DialogueLine("Tourist/Student", "Thank you very much for your help!", "ඔබේ උදව්වට බොහොම ස්තූතියි!")
        )
      ),
      DialogueConversation(
        id = "dia_4",
        title = "📚 At the School Library (පාසල් පුස්තකාලයේදී)",
        situation = "Borrowing reference books and inquiring about return dates.",
        dialogueLines = listOf(
          DialogueLine("Student", "Excuse me madam, I am looking for Grade 11 Science Past Paper books.", "සමාවෙන්න ගුරුතුමිය, මම 11 ශ්‍රේණියේ විද්‍යාව පසුගිය ප්‍රශ්න පත්‍ර පොත් සොයනවා."),
          DialogueLine("Librarian", "They are located in Section B, on the third shelf under O/L References.", "ඒවා O/L විමර්ශන අංශයේ B කොටසේ තුන්වන රාක්කයේ ඇත."),
          DialogueLine("Student", "Can I borrow this book for two weeks?", "මට මෙම පොත සති දෙකකට නිවසට රැගෙන යා හැකිද?"),
          DialogueLine("Librarian", "Reference books can only be borrowed for three days, but you can renew them if no one else has reserved them.", "විමර්ශන පොත් රැගෙන යා හැක්කේ දින 3කට පමණි, නමුත් වෙනත් කිසිවෙකු වෙන්කර නොමැති නම් ඔබට එය දීර්ඝ කළ හැක."),
          DialogueLine("Student", "Understood madam, please issue it under my library membership card.", "තේරුණා ගුරුතුමිය, කරුණාකර මගේ පුස්තකාල සාමාජික පත යටතේ එය නිකුත් කරන්න.")
        )
      ),
      DialogueConversation(
        id = "dia_5",
        title = "🚆 At the Railway Station (දුම්රිය ස්ථානයේදී)",
        situation = "Buying a train ticket and checking platform schedules.",
        dialogueLines = listOf(
          DialogueLine("Passenger", "Hello, I need one second-class ticket to Kandy for the intercity express.", "ආයුබෝවන්, මට නුවර බලා යන නගරාන්තර සීඝ්‍රගාමී දුම්රිය සඳහා දෙවන පන්තියේ ප්‍රවේශ පත්‍රයක් අවශ්‍යයි."),
          DialogueLine("Booking Clerk", "That will be 800 rupees. The train departs at 10:30 AM from Platform Number 3.", "ගාස්තුව රුපියල් 800යි. දුම්රිය පෙරවරු 10:30ට අංක 3 වේදිකාවෙන් පිටත් වේ."),
          DialogueLine("Passenger", "Is the train on schedule today?", "දුම්රිය අද නියමිත වේලාවට ධාවනය වේද?"),
          DialogueLine("Booking Clerk", "Yes, it is running on time. Please ensure you board five minutes prior to departure.", "ඔව්, එය නියමිත වේලාවට ධාවනය වේ. පිටත්වීමට මිනිත්තු පහකට පෙර නගින්නට වගබලා ගන්න."),
          DialogueLine("Passenger", "Thank you very much. Have a great day!", "බොහොම ස්තූතියි. සුබ දවසක්!")
        )
      )
    )
  }

  fun getListeningAudios(): List<ListeningQuizAudio> {
    return EnglishExpandedContentData.getExpandedListeningAudios()
  }

  fun getOldListeningAudios(): List<ListeningQuizAudio> {
    return listOf(
      ListeningQuizAudio(
        id = "ls_1",
        title = "🎧 Listening Test 1: School Science Exhibition",
        audioScript = "Attention all students! The Annual School Science and Innovation Exhibition will be held on Friday, the 28th of November, in the main auditorium. It will start promptly at 8:30 AM. Renowned scientist Dr. Senaka Perera will be the chief guest. All participating students must set up their exhibits by 7:45 AM. Entry is free for all school students and parents.",
        sinhalaSummary = "පාසල් වාර්ෂික විද්‍යා ප්‍රදර්ශනය නොවැම්බර් 28 වන සිකුරාදා ප්‍රධාන ශ්‍රවණාගාරයේදී පෙරවරු 8:30ට පැවැත්වේ. ප්‍රධාන ආරාධිතයා වන්නේ ආචාර්ය සේනක පෙරේරා මහතායි.",
        questions = listOf(
          ListeningQuestion(
            questionText = "When will the Science Exhibition be held?",
            options = listOf("Friday, 28th November", "Saturday, 29th November", "Monday, 1st December", "Sunday morning"),
            correctIndex = 0,
            explanation = "ශ්‍රව්‍ය පටයේ පැහැදිලිව 'Friday, the 28th of November' ලෙස සඳහන් වේ."
          ),
          ListeningQuestion(
            questionText = "By what time should participating students set up their project exhibits?",
            options = listOf("8:30 AM", "9:00 AM", "7:45 AM", "12:00 PM"),
            correctIndex = 2,
            explanation = "'All participating students must set up their exhibits by 7:45 AM' ලෙස සඳහන් වේ."
          )
        )
      ),
      ListeningQuizAudio(
        id = "ls_2",
        title = "🎧 Listening Test 2: Tree Planting Campaign",
        audioScript = "Good morning everyone. The Environmental Society has organized a massive Tree Planting Campaign this coming Saturday at 8:00 AM in the school playground. We have received over 500 fruit and medicinal plant saplings from the Forest Conservation Department. Volunteers are requested to bring garden gloves and water bottles. Light refreshments will be provided at 11:00 AM.",
        sinhalaSummary = "පරිසර සංගමය විසින් මේ සෙනසුරාදා පෙරවරු 8:00ට පාසල් ක්‍රීඩාංගණයේදී පැල සිටුවීමේ වැඩසටහනක් සංවිධානය කර ඇත. පැල 500ක් ලැබී ඇති අතර උදෑසන 11:00ට තේ පැන් සංග්‍රහයක් පැවැත්වේ.",
        questions = listOf(
          ListeningQuestion(
            questionText = "How many saplings were received from the Forest Conservation Department?",
            options = listOf("Over 300", "Over 500", "Around 100", "Exactly 50"),
            correctIndex = 1,
            explanation = "'We have received over 500 fruit and medicinal plant saplings' ලෙස සඳහන් වේ."
          ),
          ListeningQuestion(
            questionText = "What items are volunteers requested to bring?",
            options = listOf("Saplings and shovels", "Garden gloves and water bottles", "Hats and umbrellas", "Notebooks and pens"),
            correctIndex = 1,
            explanation = "'Volunteers are requested to bring garden gloves and water bottles' ලෙස පැහැදිලිව සඳහන් වේ."
          )
        )
      ),
      ListeningQuizAudio(
        id = "ls_3",
        title = "🎧 Listening Test 3: National Weather Bulletin",
        audioScript = "This is the special meteorological advisory. Showers or thundershowers will occur at several places in Western, Sabaragamuwa, and Southern provinces during the afternoon or night. Fairly heavy showers above 75 millimeters are likely at some places. The general public is kindly requested to take adequate precautions to minimize damages caused by temporary localized strong winds and lightning.",
        sinhalaSummary = "කාලගුණ විද්‍යා දෙපාර්තමේන්තුවේ නිවේදනය: බස්නාහිර, සබරගමුව සහ දකුණු පළාත්වල තද වැසි (75mm ට වැඩි) හා අකුණු අනතුරු ඇතිවිය හැක.",
        questions = listOf(
          ListeningQuestion(
            questionText = "What is the expected rainfall amount in heavy shower areas?",
            options = listOf("Above 50 mm", "Above 75 millimeters", "Below 20 mm", "Over 150 mm"),
            correctIndex = 1,
            explanation = "'Fairly heavy showers above 75 millimeters are likely' ලෙස නිවේදනයේ සඳහන් වේ."
          ),
          ListeningQuestion(
            questionText = "What hazards are people advised to protect themselves from?",
            options = listOf("Floods and landslides", "Strong winds and lightning", "Cold temperatures", "Hailstorms"),
            correctIndex = 1,
            explanation = "'damages caused by temporary localized strong winds and lightning' සඳහන් වේ."
          )
        )
      )
    )
  }

  fun getDictionaryWords(): List<MiniDictWord> {
    return EnglishCompleteDictionaryData.getFullCompleteDictionary()
  }

  fun getOldDictionaryWords(): List<MiniDictWord> {
    return listOf(
      MiniDictWord(
        word = "Accomplish",
        pos = "Verb",
        sinhala = "සාර්ථකව ඉටු කරගන්නවා / මුදුන්පත් කරගන්නවා",
        englishDef = "To achieve or complete successfully.",
        example = "She worked hard to accomplish her goal of getting 9 A passes.",
        synonyms = listOf("Achieve", "Attain", "Fulfill", "Complete")
      ),
      MiniDictWord(
        word = "Biodiversity",
        pos = "Noun",
        sinhala = "ජෛව විවිධත්වය",
        englishDef = "The variety of plant and animal life in a particular habitat.",
        example = "Sinharaja forest has exceptional biodiversity with rare endemic species.",
        synonyms = listOf("Ecosystem variety", "Biological diversity", "Wildlife")
      ),
      MiniDictWord(
        word = "Comprehensive",
        pos = "Adjective",
        sinhala = "සම්පූර්ණ / සියලු කරුණු අඩංගු",
        englishDef = "Including or dealing with all or nearly all elements or aspects.",
        example = "The teacher provided a comprehensive revision guide before the exam.",
        synonyms = listOf("Complete", "Exhaustive", "Thorough", "Extensive")
      ),
      MiniDictWord(
        word = "Deforestation",
        pos = "Noun",
        sinhala = "වන විනාශය / ගස් කැපීම",
        englishDef = "The action of clearing a wide area of trees.",
        example = "Deforestation causes soil erosion and rapid climate change.",
        synonyms = listOf("Logging", "Clearance", "Tree cutting")
      ),
      MiniDictWord(
        word = "Efficient",
        pos = "Adjective",
        sinhala = "කාර්යක්ෂම / අඩු කාලයකින් වැඩි ඵල දරන",
        englishDef = "Achieving maximum productivity with minimum wasted effort or expense.",
        example = "An efficient daily study timetable helps manage stress.",
        synonyms = listOf("Productive", "Effective", "Competent", "Organized")
      ),
      MiniDictWord(
        word = "Fluency",
        pos = "Noun",
        sinhala = "චතුරතාව / චතුර ලෙස කතා කිරීමේ හැකියාව",
        englishDef = "The ability to speak or write a foreign language easily and accurately.",
        example = "Daily voice practice builds fluency in English speaking.",
        synonyms = listOf("Eloquence", "Articulacy", "Command of language")
      ),
      MiniDictWord(
        word = "Fundamental",
        pos = "Adjective",
        sinhala = "මූලික / අත්‍යාවශ්‍ය",
        englishDef = "Forming a necessary base or core; of central importance.",
        example = "Grammar rules are fundamental for writing error-free essays.",
        synonyms = listOf("Basic", "Core", "Essential", "Primary")
      ),
      MiniDictWord(
        word = "Global",
        pos = "Adjective",
        sinhala = "ගෝලීය / ලෝක ව්‍යාප්ත",
        englishDef = "Relating to the whole world; worldwide.",
        example = "English has become the foremost global language for business and technology.",
        synonyms = listOf("Worldwide", "International", "Universal")
      ),
      MiniDictWord(
        word = "Horizon",
        pos = "Noun",
        sinhala = "ක්ෂිතිජය / හැකියාවන්ගේ සීමාව",
        englishDef = "The limit of a person's knowledge, experience, or interest.",
        example = "Reading international literature broadens students' mental horizons.",
        synonyms = listOf("Perspective", "Scope", "Range", "Outlook")
      ),
      MiniDictWord(
        word = "Innovate",
        pos = "Verb",
        sinhala = "නව්‍යකරණය කරනවා / නව නිපැයුම් කරනවා",
        englishDef = "Make changes in something established, especially by introducing new methods or ideas.",
        example = "Young inventors innovate sustainable devices to purify clean drinking water.",
        synonyms = listOf("Create", "Pioneer", "Transform", "Invent")
      ),
      MiniDictWord(
        word = "Persevere",
        pos = "Verb",
        sinhala = "නොසැලී උත්සාහ කරනවා",
        englishDef = "Continue in a course of action even in the face of difficulty.",
        example = "Students who persevere through difficult math problems achieve top marks.",
        synonyms = listOf("Persist", "Keep going", "Endure", "Strive")
      ),
      MiniDictWord(
        word = "Sustainable",
        pos = "Adjective",
        sinhala = "තිරසාර / පරිසර හිතකාමී දිගුකාලීන",
        englishDef = "Able to be maintained at a certain rate or level without exhausting resources.",
        example = "Solar energy and rainwater harvesting are sustainable green solutions.",
        synonyms = listOf("Eco-friendly", "Renewable", "Viable", "Durable")
      ),
      MiniDictWord(
        word = "Advocate",
        pos = "Verb / Noun",
        sinhala = "පෙනී සිටිනවා / යෝජනා කර සහය දක්වනවා",
        englishDef = "Publicly recommend or support a particular cause or policy.",
        example = "Environmentalists advocate for renewable solar power across school buildings.",
        synonyms = listOf("Support", "Champion", "Recommend", "Promote")
      ),
      MiniDictWord(
        word = "Collaborate",
        pos = "Verb",
        sinhala = "එක්ව සහයෝගයෙන් වැඩ කරනවා",
        englishDef = "Work jointly on an activity or project.",
        example = "Students collaborate in group discussions to solve challenging math problems.",
        synonyms = listOf("Cooperate", "Team up", "Work together", "Join forces")
      ),
      MiniDictWord(
        word = "Diligence",
        pos = "Noun",
        sinhala = "නොපසුබස්නා උත්සාහය / කැපවීම",
        englishDef = "Careful and persistent work or effort.",
        example = "Her diligence in practicing English grammar daily led to an A pass.",
        synonyms = listOf("Dedication", "Persistence", "Assiduity", "Carefulness")
      ),
      MiniDictWord(
        word = "Empathy",
        pos = "Noun",
        sinhala = "අන් අයගේ හැඟීම් තමාගේ මෙන් තේරුම් ගැනීම (සහකම්පනය)",
        englishDef = "The ability to understand and share the feelings of another.",
        example = "Good leaders show deep empathy towards their team members.",
        synonyms = listOf("Compassion", "Understanding", "Sensitivity", "Sympathy")
      ),
      MiniDictWord(
        word = "Integrity",
        pos = "Noun",
        sinhala = "අවංකභාවය සහ ප්‍රතිපත්තිගරුකභාවය",
        englishDef = "The quality of being honest and having strong moral principles.",
        example = "Academic integrity means never cheating during exams or copying essays.",
        synonyms = listOf("Honesty", "Uprightness", "Morality", "Sincerity")
      ),
      MiniDictWord(
        word = "Resilient",
        pos = "Adjective",
        sinhala = "දුෂ්කරතා හමුවේ නැවත නැගී සිටිය හැකි",
        englishDef = "Able to withstand or recover quickly from difficult conditions.",
        example = "Resilient students learn from their test mistakes instead of feeling discouraged.",
        synonyms = listOf("Tough", "Strong", "Adaptable", "Tenacious")
      ),
      MiniDictWord(
        word = "Significant",
        pos = "Adjective",
        sinhala = "ඉතා වැදගත් / සැලකිය යුතු",
        englishDef = "Sufficiently great or important to be worthy of attention; noteworthy.",
        example = "Daily reading creates a significant improvement in English vocabulary.",
        synonyms = listOf("Important", "Remarkable", "Meaningful", "Major")
      ),
      MiniDictWord(
        word = "Optimistic",
        pos = "Adjective",
        sinhala = "යහපත් බලාපොරොත්තු සහිත (සුබවාදී)",
        englishDef = "Hopeful and confident about the future.",
        example = "An optimistic mindset helps students tackle exam stress calmly.",
        synonyms = listOf("Hopeful", "Positive", "Confident", "Buoyant")
      )
    )
  }
}

// ==============================================================================
// MAIN COMPOSABLE: ALL-IN-ONE COMPREHENSIVE ENGLISH MASTER CLASS SCREEN
// ==============================================================================

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnglishMasterClassScreen(
  onBack: () -> Unit,
  onOpenGoogleDrivePdfModal: ((url: String, title: String) -> Unit)? = null,
  onOpenAutoChecker: (() -> Unit)? = null,
  onOpenVoiceDoubtSolver: (() -> Unit)? = null,
  initialSubTab: Int = 0
) {
  val context = LocalContext.current
  val clipboardManager = LocalClipboardManager.current

  // Active expanded accordion section: null or 1..10
  var expandedSection by remember { mutableStateOf<Int?>(null) }

  val defaultEnglishDriveUrl = "https://drive.google.com/file/d/155eu00n0_0IdrKc0wiWDqcwkqLa08ndI/preview"
  val defaultEnglishNoteTitle = "09-11 ශ්‍රේණි ඉංග්‍රීසි පූර්ණ කෙටි සටහන් (Google Drive PDF)"

  var internalShowPdfModal by remember { mutableStateOf(false) }
  var internalPdfUrl by remember { mutableStateOf("") }
  var internalPdfTitle by remember { mutableStateOf("") }

  fun openDrivePdf(url: String = defaultEnglishDriveUrl, title: String = defaultEnglishNoteTitle) {
    if (onOpenGoogleDrivePdfModal != null) {
      onOpenGoogleDrivePdfModal(url, title)
    } else {
      internalPdfUrl = url
      internalPdfTitle = title
      internalShowPdfModal = true
    }
  }

  // Sub-section within English Class:
  // 0 = "🇬🇧 ඉංග්‍රීසි පන්තිය (Master Suite)"
  // 1 = "📝 ඉංග්‍රීසි සටහන් & Auto-Checker"
  // 2 = "🎙️ ස්පෝකන් ඉංග්‍රීසි (Spoken English Studio)"
  // 3 = "📖 සම්පූර්ණ ඉංග්‍රීසි-සිංහල ශබ්දකෝෂය (Complete Dictionary Screen)"
  var activeSubSectionTab by remember(initialSubTab) { mutableIntStateOf(initialSubTab) }

  if (activeSubSectionTab == 1) {
    BackHandler(enabled = true) {
      activeSubSectionTab = 0
    }
    EnglishShortNotesAutoCheckerScreen(
      onBack = { activeSubSectionTab = 0 },
      onOpenPdfDriveViewer = { url, title ->
        openDrivePdf(url, title)
      }
    )
    return
  }

  if (activeSubSectionTab == 2) {
    BackHandler(enabled = true) {
      activeSubSectionTab = 0
    }
    SpokenEnglishVoiceRecognitionScreen(
      onBack = { activeSubSectionTab = 0 }
    )
    return
  }

  if (activeSubSectionTab == 3) {
    BackHandler(enabled = true) {
      activeSubSectionTab = 0
    }
    CompleteEnglishDictionaryScreen(
      onBack = { activeSubSectionTab = 0 }
    )
    return
  }

  if (activeSubSectionTab == 4) {
    BackHandler(enabled = true) {
      activeSubSectionTab = 0
    }
    EnglishVoiceDoubtAssistantScreen(
      onBack = { activeSubSectionTab = 0 }
    )
    return
  }

  if (activeSubSectionTab == 5) {
    BackHandler(enabled = true) {
      activeSubSectionTab = 0
    }
    TenseComparisonScreen(
      onBack = { activeSubSectionTab = 0 }
    )
    return
  }

  if (activeSubSectionTab == 6) {
    BackHandler(enabled = true) {
      activeSubSectionTab = 0
    }
    PassiveVoiceMasterScreen(
      onBack = { activeSubSectionTab = 0 }
    )
    return
  }

  if (activeSubSectionTab == 7) {
    BackHandler(enabled = true) {
      activeSubSectionTab = 0
    }
    PassiveVoiceQuizScreen(
      onBack = { activeSubSectionTab = 0 }
    )
    return
  }

  if (activeSubSectionTab == 8) {
    BackHandler(enabled = true) {
      activeSubSectionTab = 0
    }
    ReadingComprehensionScreen(
      onBack = { activeSubSectionTab = 0 }
    )
    return
  }

  if (activeSubSectionTab == 9) {
    BackHandler(enabled = true) {
      activeSubSectionTab = 0
    }
    ActivePassive500Screen(
      onBack = { activeSubSectionTab = 0 }
    )
    return
  }

  if (activeSubSectionTab == 10) {
    BackHandler(enabled = true) {
      activeSubSectionTab = 0
    }
    SentencePuzzleScreen(
      onBack = { activeSubSectionTab = 0 }
    )
    return
  }

  // Data sources
  val vocabList = remember { EnglishBuilderRepository.getDailyVocab() }
  val templates = remember { EnglishBuilderRepository.getWritingTemplates() }
  val grammarLessons = remember { EnglishBuilderRepository.getGrammarLessons() }
  val clozeTests = remember { EnglishBuilderRepository.getClozeTests() }
  val grammarQuizzes = remember { AdvancedEnglishRepository.getGrammarQuizzes() }
  val sentencePuzzles = remember { AdvancedEnglishRepository.getSentencePuzzles() }
  val sentencePuzzleCategories = remember { AdvancedEnglishRepository.getSentencePuzzleCategories() }
  var selectedPuzzleCategoryId by remember { mutableStateOf(1) }
  val revealedPuzzleAnswers = remember { mutableStateMapOf<String, Boolean>() }
  var showAllAnswersInPuzzleCat by remember { mutableStateOf(false) }
  val dialogues = remember { AdvancedEnglishRepository.getDialogues() }
  val listeningAudios = remember { AdvancedEnglishRepository.getListeningAudios() }
  val dictWords = remember { AdvancedEnglishRepository.getDictionaryWords() }
  val autoCheckQuestions = remember { EnglishShortNotesRepository.allQuestions }
  val autoCheckRules = remember { EnglishShortNotesRepository.grammarRulesList }

  var autoCheckGradeFilter by remember { mutableStateOf(EnglishGradeLevel.ALL) }
  var autoCheckCategoryFilter by remember { mutableStateOf(EnglishSkillCategory.ALL) }
  val userAutoCheckAnswers = remember { mutableStateMapOf<String, Int>() }

  // Text-To-Speech engine
  var tts by remember { mutableStateOf<TextToSpeech?>(null) }
  var isTtsReady by remember { mutableStateOf(false) }

  DisposableEffect(Unit) {
    var engine: TextToSpeech? = null
    engine = TextToSpeech(context) { status ->
      if (status == TextToSpeech.SUCCESS) {
        engine?.language = Locale.ENGLISH
        isTtsReady = true
      }
    }
    tts = engine
    onDispose {
      engine?.stop()
      engine?.shutdown()
    }
  }

  fun speakEnglish(text: String, speechRate: Float = 1.0f) {
    tts?.setSpeechRate(speechRate)
    tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "english_class_tts")
  }

  // Voice Mic Practice Sentences
  val practiceSentences = remember {
    listOf(
      SpokenSentencePractice(
        "sp_1",
        "Good morning, my name is Kasun and I study in Grade 11.",
        "/ɡʊd ˈmɔːnɪŋ maɪ neɪm ɪz kəˈsuːn/",
        "සුබ උදෑසනක්, මගේ නම කසුන් සහ මම 11 ශ්‍රේණියේ ඉගෙනුම ලබමි.",
        "Beginner"
      ),
      SpokenSentencePractice(
        "sp_2",
        "Science and mathematics are my favorite subjects for the O/L examination.",
        "/ˈsaɪəns ænd ˌmæθəˈmætɪks ɑː maɪ ˈfeɪvərɪt ˈsʌbdʒɪkts/",
        "විද්‍යාව හා ගණිතය සාමාන්‍ය පෙළ විභාගය සඳහා මගේ ප්‍රියතම විෂයන් වේ.",
        "Intermediate"
      ),
      SpokenSentencePractice(
        "sp_3",
        "Protecting the natural environment is the responsibility of every citizen.",
        "/prəˈtɛktɪŋ ðə ˈnætʃrəl ɪnˈvaɪrənmənt/",
        "ස්වභාවික පරිසරය ආරක්ෂා කිරීම සෑම පුරවැසියෙකුගේම වගකීමකි.",
        "Advanced"
      ),
      SpokenSentencePractice(
        "sp_4",
        "Consistent practice and hard work lead to great success in life.",
        "/kənˈsɪstənt ˈpræktɪs ænd hɑːd wɜːk/",
        "නිරන්තර පුහුණුව සහ වෙහෙස මහන්සි වී වැඩ කිරීම ජීවිතයේ උසස් ජයග්‍රහණවලට මඟ පාදයි.",
        "Intermediate"
      ),
      SpokenSentencePractice(
        "sp_5",
        "Could you please explain this grammar lesson one more time?",
        "/kʊd juː pliːz ɪkˈspleɪn ðɪs ˈɡræmər ˈlɛsn/",
        "කරුණාකර මෙම ව්‍යාකරණ පාඩම තවත් එක් වරක් පැහැදිලි කළ හැකිද?",
        "Beginner"
      )
    )
  }

  var selectedPracticeIndex by remember { mutableStateOf(0) }
  val currentPracticeItem = practiceSentences[selectedPracticeIndex]
  var recognizedSpokenText by remember { mutableStateOf("") }
  var matchAccuracyPercentage by remember { mutableStateOf<Int?>(null) }
  var isListening by remember { mutableStateOf(false) }
  var speechStatusMessage by remember { mutableStateOf("මයික්‍රෆෝන් බොත්තම ඔබා ඉංග්‍රීසි වාක්‍යය ශබ්ද නඟා කියවන්න.") }

  fun calculateAccuracy(spoken: String, expected: String): Int {
    val cleanSpoken = spoken.lowercase().replace(Regex("[^a-z0-9 ]"), "").trim().split("\\s+".toRegex())
    val cleanExpected = expected.lowercase().replace(Regex("[^a-z0-9 ]"), "").trim().split("\\s+".toRegex())
    if (cleanExpected.isEmpty() || cleanSpoken.isEmpty()) return 0
    var matches = 0
    cleanExpected.forEach { word ->
      if (cleanSpoken.contains(word)) matches++
    }
    return ((matches.toFloat() / cleanExpected.size) * 100).toInt().coerceIn(0, 100)
  }

  val speechLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.StartActivityForResult()
  ) { result ->
    isListening = false
    if (result.resultCode == Activity.RESULT_OK && result.data != null) {
      val matches = result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
      if (!matches.isNullOrEmpty()) {
        val spoken = matches[0]
        recognizedSpokenText = spoken
        val accuracy = calculateAccuracy(spoken, currentPracticeItem.englishText)
        matchAccuracyPercentage = accuracy
        speechStatusMessage = when {
          accuracy >= 85 -> "🌟 විශිෂ්ටයි! ඉතාමත් පැහැදිලි නිවැරදි උච්චාරණයක්! (+50 XP)"
          accuracy >= 50 -> "👍 හොඳයි! නැවත උත්සාහ කර 100% ට ළඟා වන්න."
          else -> "💡 නැවත සවන්දී පැහැදිලිව නැවත කියවන්න."
        }
      }
    } else {
      speechStatusMessage = "කටහඬ හඳුනාගැනීම අවලංගු විය. නැවත උත්සාහ කරන්න."
    }
  }

  val micPermissionLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.RequestPermission()
  ) { isGranted ->
    if (isGranted) {
      val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
        putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US")
        putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak the English sentence now...")
      }
      try {
        isListening = true
        speechStatusMessage = "🎙️ සවන්දෙමින් පවතී... වාක්‍යය ශබ්ද නඟා කියවන්න."
        speechLauncher.launch(intent)
      } catch (e: Exception) {
        isListening = false
        Toast.makeText(context, "Speech recognition is not available on this device", Toast.LENGTH_SHORT).show()
      }
    } else {
      Toast.makeText(context, "Microphone permission is required for voice practice", Toast.LENGTH_SHORT).show()
    }
  }

  // Complete Dictionary Search & Filter State
  var dictSearchQuery by remember { mutableStateOf("") }
  var dictLetterFilter by remember { mutableStateOf("A") }
  var dictPosFilter by remember { mutableStateOf("ALL") }
  val filteredDictWords = remember(dictSearchQuery, dictLetterFilter, dictPosFilter) {
    val pool = if (dictSearchQuery.isNotBlank()) {
      EnglishCompleteDictionaryData.getFullCompleteDictionary()
    } else if (dictLetterFilter != "ALL") {
      EnglishCompleteDictionaryData.getWordsForLetter(dictLetterFilter[0])
    } else {
      EnglishCompleteDictionaryData.getWordsForLetter('A')
    }
    pool.filter { item ->
      val matchesLetter = if (dictLetterFilter == "ALL" || dictSearchQuery.isNotBlank()) true else item.word.startsWith(dictLetterFilter, ignoreCase = true)
      val matchesPos = if (dictPosFilter == "ALL") true else item.pos.contains(dictPosFilter, ignoreCase = true)
      val matchesQuery = if (dictSearchQuery.isBlank()) true else {
        val q = dictSearchQuery.trim().lowercase()
        item.word.lowercase().contains(q) ||
          item.sinhala.lowercase().contains(q) ||
          item.englishDef.lowercase().contains(q) ||
          item.synonyms.any { s -> s.lowercase().contains(q) }
      }
      matchesLetter && matchesPos && matchesQuery
    }
  }

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .background(Color(0xFF0F172A)),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(10.dp),
    contentPadding = PaddingValues(bottom = 60.dp)
  ) {
    // 1. Ultra-Compact Blue Header (Height reduced to minimal ~65dp, fully scrollable up and down with screen)
    item(key = "compact_english_hero_header") {
      Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(0xFF0F172A),
        shadowElevation = 4.dp
      ) {
        Box(modifier = Modifier.fillMaxWidth()) {
          Box(
            modifier = Modifier
              .matchParentSize()
              .background(
                Brush.horizontalGradient(
                  colors = listOf(
                    Color(0xFF0F172A),
                    Color(0xFF1E1B4B),
                    Color(0xFF0F172A)
                  )
                )
              )
          )

          Column(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 8.dp, vertical = 4.dp)
          ) {
            // Top Row: Back button + Compact Title + 09-11 Badge + Subtitle
            Row(
              modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Surface(
                onClick = {
                  tts?.stop()
                  onBack()
                },
                shape = CircleShape,
                color = Color.White.copy(alpha = 0.15f),
                border = BorderStroke(1.dp, Color.White.copy(alpha = 0.25f)),
                modifier = Modifier.size(28.dp)
              ) {
                Box(contentAlignment = Alignment.Center) {
                  Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(15.dp)
                  )
                }
              }

              Spacer(modifier = Modifier.width(6.dp))

              Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text(
                    text = "🇬🇧 ඉංග්‍රීසි පන්තිය (Master Suite)",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 13.sp
                  )
                  Spacer(modifier = Modifier.width(5.dp))
                  Surface(
                    shape = RoundedCornerShape(3.dp),
                    color = Color(0xFFF59E0B)
                  ) {
                    Text(
                      text = "09-11",
                      fontSize = 8.sp,
                      fontWeight = FontWeight.ExtraBold,
                      color = Color(0xFF78350F),
                      modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                    )
                  }
                }
                Text(
                  text = "ව්‍යාකරණ, රචනා, උච්චාරණ, Auto-Checker & ශබ්දකෝෂ මෙවලම්",
                  fontSize = 9.5.sp,
                  color = Color(0xFF94A3B8),
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Compact Navigation Pills Row
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
              horizontalArrangement = Arrangement.spacedBy(4.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Surface(
                onClick = { activeSubSectionTab = 0 },
                shape = RoundedCornerShape(12.dp),
                color = if (activeSubSectionTab == 0) Color(0xFFF59E0B) else Color(0xFF1E293B),
                border = BorderStroke(1.dp, if (activeSubSectionTab == 0) Color(0xFFF59E0B) else Color(0xFF334155))
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text("🇬🇧", fontSize = 10.sp)
                  Spacer(modifier = Modifier.width(3.dp))
                  Text(
                    text = "ඉංග්‍රීසි පන්තිය",
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (activeSubSectionTab == 0) Color(0xFF78350F) else Color(0xFFCBD5E1)
                  )
                }
              }

              Surface(
                onClick = { activeSubSectionTab = 1 },
                shape = RoundedCornerShape(12.dp),
                color = if (activeSubSectionTab == 1) Color(0xFF38BDF8) else Color(0xFF1E293B),
                border = BorderStroke(1.dp, if (activeSubSectionTab == 1) Color(0xFF38BDF8) else Color(0xFF334155))
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text("📝", fontSize = 10.sp)
                  Spacer(modifier = Modifier.width(3.dp))
                  Text(
                    text = "ඉංග්‍රීසි සටහන්",
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (activeSubSectionTab == 1) Color(0xFF0F172A) else Color(0xFFCBD5E1)
                  )
                }
              }

              Surface(
                onClick = { activeSubSectionTab = 2 },
                shape = RoundedCornerShape(12.dp),
                color = if (activeSubSectionTab == 2) Color(0xFF06B6D4) else Color(0xFF1E293B),
                border = BorderStroke(1.dp, if (activeSubSectionTab == 2) Color(0xFF06B6D4) else Color(0xFF334155))
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text("🎙️", fontSize = 10.sp)
                  Spacer(modifier = Modifier.width(3.dp))
                  Text(
                    text = "ස්පෝකන් ඉංග්‍රීසි",
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (activeSubSectionTab == 2) Color(0xFF083344) else Color(0xFFCBD5E1)
                  )
                }
              }

              Surface(
                onClick = { activeSubSectionTab = 3 },
                shape = RoundedCornerShape(12.dp),
                color = if (activeSubSectionTab == 3) Color(0xFF818CF8) else Color(0xFF1E293B),
                border = BorderStroke(1.dp, if (activeSubSectionTab == 3) Color(0xFF818CF8) else Color(0xFF334155))
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text("📖", fontSize = 10.sp)
                  Spacer(modifier = Modifier.width(3.dp))
                  Text(
                    text = "සම්පූර්ණ ඩික්ෂනරිය",
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (activeSubSectionTab == 3) Color(0xFF1E1B4B) else Color(0xFFCBD5E1)
                  )
                }
              }

              Surface(
                onClick = { activeSubSectionTab = 4 },
                shape = RoundedCornerShape(12.dp),
                color = if (activeSubSectionTab == 4) Color(0xFF10B981) else Color(0xFF1E293B),
                border = BorderStroke(1.dp, if (activeSubSectionTab == 4) Color(0xFF10B981) else Color(0xFF334155))
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text("🎙️", fontSize = 10.sp)
                  Spacer(modifier = Modifier.width(3.dp))
                  Text(
                    text = "AI හඬ සහායක",
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (activeSubSectionTab == 4) Color.White else Color(0xFFCBD5E1)
                  )
                }
              }

              Surface(
                onClick = { activeSubSectionTab = 5 },
                shape = RoundedCornerShape(12.dp),
                color = if (activeSubSectionTab == 5) Color(0xFFF97316) else Color(0xFF1E293B),
                border = BorderStroke(1.dp, if (activeSubSectionTab == 5) Color(0xFFF97316) else Color(0xFF334155))
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text("⏳", fontSize = 10.sp)
                  Spacer(modifier = Modifier.width(3.dp))
                  Text(
                    text = "කාල 3 සංසන්දනය",
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (activeSubSectionTab == 5) Color.White else Color(0xFFCBD5E1)
                  )
                }
              }

              Surface(
                onClick = { activeSubSectionTab = 6 },
                shape = RoundedCornerShape(12.dp),
                color = if (activeSubSectionTab == 6) Color(0xFF8B5CF6) else Color(0xFF1E293B),
                border = BorderStroke(1.dp, if (activeSubSectionTab == 6) Color(0xFF8B5CF6) else Color(0xFF334155))
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text("🔄", fontSize = 10.sp)
                  Spacer(modifier = Modifier.width(3.dp))
                  Text(
                    text = "පැසිව් වොයිස් (500)",
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (activeSubSectionTab == 6) Color.White else Color(0xFFCBD5E1)
                  )
                }
              }

              Surface(
                onClick = { activeSubSectionTab = 7 },
                shape = RoundedCornerShape(12.dp),
                color = if (activeSubSectionTab == 7) Color(0xFFEC4899) else Color(0xFF1E293B),
                border = BorderStroke(1.dp, if (activeSubSectionTab == 7) Color(0xFFEC4899) else Color(0xFF334155))
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text("✍️", fontSize = 10.sp)
                  Spacer(modifier = Modifier.width(3.dp))
                  Text(
                    text = "පුහුණු ප්‍රශ්න 500",
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (activeSubSectionTab == 7) Color.White else Color(0xFFCBD5E1)
                  )
                }
              }

              Surface(
                onClick = { activeSubSectionTab = 8 },
                shape = RoundedCornerShape(12.dp),
                color = if (activeSubSectionTab == 8) Color(0xFF14B8A6) else Color(0xFF1E293B),
                border = BorderStroke(1.dp, if (activeSubSectionTab == 8) Color(0xFF14B8A6) else Color(0xFF334155))
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text("📖", fontSize = 10.sp)
                  Spacer(modifier = Modifier.width(3.dp))
                  Text(
                    text = "කියවීමේ ඡේද 100",
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (activeSubSectionTab == 8) Color.White else Color(0xFFCBD5E1)
                  )
                }
              }
            }
          }
        }
      }
    }

      // =========================================================================
      // TOP FEATURE BANNER: 09/10/11 ENGLISH SHORT NOTES (COMPACT & REDUCED WIDTH)
      // =========================================================================
      item {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
          contentAlignment = Alignment.Center
        ) {
          Card(
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.65f)),
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(10.dp))
              .background(
                Brush.horizontalGradient(
                  colors = listOf(Color(0xFF0F172A), Color(0xFF1E293B))
                )
              )
              .clickable {
                activeSubSectionTab = 1
              }
          ) {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 7.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
              ) {
                Box(
                  modifier = Modifier
                    .size(26.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFF38BDF8).copy(alpha = 0.2f)),
                  contentAlignment = Alignment.Center
                ) {
                  Text("📝", fontSize = 14.sp)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                      text = "ඉංග්‍රීසි සටහන් & Auto-Check",
                      color = Color.White,
                      fontSize = 11.5.sp,
                      fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Surface(
                      color = Color(0xFF38BDF8),
                      shape = RoundedCornerShape(3.dp)
                    ) {
                      Text(
                        text = "NOTES",
                        color = Color(0xFF0F172A),
                        fontSize = 7.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(horizontal = 3.dp, vertical = 1.dp)
                      )
                    }
                  }
                  Text(
                    text = "09/10/11 කෙටි සටහන් & Grammar Rules",
                    color = Color(0xFFBAE6FD),
                    fontSize = 8.5.sp,
                    maxLines = 1
                  )
                }
              }
              Spacer(modifier = Modifier.width(6.dp))
              Surface(
                shape = RoundedCornerShape(6.dp),
                color = Color(0xFF38BDF8),
                modifier = Modifier.clickable { activeSubSectionTab = 1 }
              ) {
                Text(
                  text = "විවෘත 🚀",
                  fontSize = 9.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF0F172A),
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
              }
            }
          }
        }
      }

      // =========================================================================
      // TOP FEATURE BANNER: 📖 COMPLETE SINHALA-ENGLISH DICTIONARY (REDUCED WIDTH)
      // =========================================================================
      item {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
          contentAlignment = Alignment.Center
        ) {
          Card(
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            border = BorderStroke(1.dp, Color(0xFF818CF8).copy(alpha = 0.65f)),
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(10.dp))
              .background(
                Brush.horizontalGradient(
                  colors = listOf(Color(0xFF312E81), Color(0xFF1E1B4B))
                )
              )
              .clickable {
                activeSubSectionTab = 3
              }
          ) {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 6.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
              ) {
                Box(
                  modifier = Modifier
                    .size(24.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFF818CF8).copy(alpha = 0.2f)),
                  contentAlignment = Alignment.Center
                ) {
                  Text("📖", fontSize = 13.sp)
                }
                Spacer(modifier = Modifier.width(7.dp))
                Column {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                      text = "සම්පූර්ණ ශබ්දකෝෂය",
                      color = Color.White,
                      fontSize = 11.sp,
                      fontWeight = FontWeight.Bold,
                      maxLines = 1
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Surface(
                      color = Color(0xFF818CF8),
                      shape = RoundedCornerShape(3.dp)
                    ) {
                      Text(
                        text = "A-Z",
                        color = Color(0xFF1E1B4B),
                        fontSize = 7.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(horizontal = 3.dp, vertical = 1.dp)
                      )
                    }
                  }
                  Text(
                    text = "A-Z වචන 300+, සිංහල අර්ථ & Audio",
                    color = Color(0xFFE0E7FF),
                    fontSize = 8.sp,
                    maxLines = 1
                  )
                }
              }
              Spacer(modifier = Modifier.width(6.dp))
              Surface(
                shape = RoundedCornerShape(6.dp),
                color = Color(0xFF818CF8),
                modifier = Modifier.clickable { activeSubSectionTab = 3 }
              ) {
                Text(
                  text = "සොයන්න 🔍",
                  fontSize = 8.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF1E1B4B),
                  modifier = Modifier.padding(horizontal = 7.dp, vertical = 4.dp)
                )
              }
            }
          }
        }
      }

      // =========================================================================
      // VOICE DOUBT SOLVER HERO BANNER (VOICE EXPLANATIONS FOR STUDENTS)
      // =========================================================================
      if (onOpenVoiceDoubtSolver != null) {
        item {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 10.dp),
            contentAlignment = Alignment.Center
          ) {
            Card(
              shape = RoundedCornerShape(10.dp),
              colors = CardDefaults.cardColors(containerColor = Color.Transparent),
              border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.65f)),
              modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(
                  Brush.horizontalGradient(
                    colors = listOf(Color(0xFF064E3B), Color(0xFF0F172A))
                  )
                )
                .clickable {
                  activeSubSectionTab = 4
                }
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 10.dp, vertical = 7.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Row(
                  verticalAlignment = Alignment.CenterVertically,
                  modifier = Modifier.weight(1f)
                ) {
                  Box(
                    modifier = Modifier
                      .size(28.dp)
                      .clip(CircleShape)
                      .background(Color(0xFF10B981).copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center
                  ) {
                    Text("🎙️", fontSize = 14.sp)
                  }
                  Spacer(modifier = Modifier.width(8.dp))
                  Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                      Text(
                        text = "AI ඉංග්‍රීසි ශිෂ්‍ය ගැටලු හඬ සහායකයා",
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
                          text = "ENGLISH ONLY",
                          color = Color.White,
                          fontSize = 6.5.sp,
                          fontWeight = FontWeight.ExtraBold,
                          modifier = Modifier.padding(horizontal = 3.dp, vertical = 1.dp)
                        )
                      }
                    }
                    Text(
                      text = "ඉංග්‍රීසි ව්‍යාකරණ, Tenses, Passive Voice සහ විභාග ගැටලු හඬින් විසඳාගන්න",
                      color = Color(0xFFA7F3D0),
                      fontSize = 8.5.sp,
                      maxLines = 1
                    )
                  }
                }
                Spacer(modifier = Modifier.width(6.dp))
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = Color(0xFF10B981),
                  modifier = Modifier.clickable { activeSubSectionTab = 4 }
                ) {
                  Text(
                    text = "අසන්න 🎙️",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                  )
                }
              }
            }
          }
        }
      }

      // =========================================================================
      // 3-TENSE COMPARISON HERO BANNER (PAST, PRESENT & FUTURE - 30 CATEGORIES X 30 SENTENCES)
      // =========================================================================
      item {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
          contentAlignment = Alignment.Center
        ) {
          Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            border = BorderStroke(1.5.dp, Color(0xFFF97316).copy(alpha = 0.85f)),
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(12.dp))
              .background(
                Brush.horizontalGradient(
                  colors = listOf(Color(0xFF7C2D12), Color(0xFF1E1B4B))
                )
              )
              .clickable {
                activeSubSectionTab = 5
              }
          ) {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
              ) {
                Box(
                  modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFF97316).copy(alpha = 0.25f)),
                  contentAlignment = Alignment.Center
                ) {
                  Text("⏳", fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                      text = "කාල 3 වාක්‍ය සංසන්දනය",
                      color = Color.White,
                      fontSize = 13.sp,
                      fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Surface(
                      color = Color(0xFFF97316),
                      shape = RoundedCornerShape(4.dp)
                    ) {
                      Text(
                        text = "30 x 30 = 900",
                        color = Color.White,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                      )
                    }
                  }
                  Text(
                    text = "එකම වාක්‍යය අතීත, වර්තමාන, අනාගත ලෙස එකම තැනින් (සිංහල අර්ථ & හඬ)",
                    color = Color(0xFFFED7AA),
                    fontSize = 10.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                }
              }
              Spacer(modifier = Modifier.width(8.dp))
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFF97316),
                modifier = Modifier.clickable { activeSubSectionTab = 5 }
              ) {
                Text(
                  text = "පිවිසෙන්න 🚀",
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                )
              }
            }
          }
        }
      }

      // =========================================================================
      // 1. 📑 09-11 ඉංග්‍රීසි පූර්ණ කෙටි සටහන් (PDF HUB)
      // =========================================================================
      item {
        val isExp = expandedSection == 1
        EnglishSectionCard(
          sectionNumber = "1",
          badgeText = "09 - 11 ALL SYLLABUS",
          badgeColor = Color(0xFFF59E0B),
          title = "📑 1. ඉංග්‍රීසි සටහන් (09-11 ශ්‍රේණි පූර්ණ කෙටි සටහන් PDF)",
          description = "Tenses, Grammar Formulas, Active/Passive Voice, Prepositions, Letter Formats, Graphs & Essay Frameworks සාරාංශගත කෙටි සටහන් පොත.",
          backgroundImageRes = R.drawable.img_papers_bg_1786107349533,
          isExpanded = isExp,
          onToggle = { expandedSection = if (isExp) null else 1 },
          onQuickOpen = { openDrivePdf(defaultEnglishDriveUrl, defaultEnglishNoteTitle) },
          quickOpenText = "PDF කියවන්න 📄"
        ) {
          Column(modifier = Modifier.padding(top = 12.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
              Button(
                onClick = { openDrivePdf(defaultEnglishDriveUrl, defaultEnglishNoteTitle) },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF59E0B)),
                modifier = Modifier.weight(1.3f),
                contentPadding = PaddingValues(vertical = 10.dp)
              ) {
                Icon(Icons.Default.PictureAsPdf, contentDescription = "PDF", tint = Color(0xFF78350F), modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text("PDF කියවන්න 🚀", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF78350F))
              }

              OutlinedButton(
                onClick = {
                  try {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(defaultEnglishDriveUrl))
                    context.startActivity(browserIntent)
                  } catch (e: Exception) {
                    Toast.makeText(context, "Browser විවෘත කළ නොහැක", Toast.LENGTH_SHORT).show()
                  }
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF1E293B)),
                border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
                modifier = Modifier.weight(0.9f),
                contentPadding = PaddingValues(vertical = 10.dp)
              ) {
                Icon(Icons.Default.OpenInBrowser, contentDescription = "Browser", tint = Color(0xFF1E293B), modifier = Modifier.size(15.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("Browser", fontSize = 11.sp, color = Color(0xFF1E293B))
              }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Surface(
              shape = RoundedCornerShape(12.dp),
              color = Color(0xFFF8FAFC),
              border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Text("🎯 10 & 11 ශ්‍රේණි (O/L Focus & A Pass Strategies):", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E293B))
                Spacer(modifier = Modifier.height(4.dp))
                Text("• All 12 English Tenses & Active vs Passive Voice (be + V3)\n• Direct and Indirect Speech Rules\n• Conditional Clauses (If Types 0, 1, 2, 3)\n• Formal/Informal Letters, Notices, Articles & Graph Descriptions", fontSize = 11.sp, color = Color(0xFF475569), lineHeight = 16.sp)

                Spacer(modifier = Modifier.height(8.dp))
                Text("📘 Foundations & Grammar Essentials:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E293B))
                Spacer(modifier = Modifier.height(4.dp))
                Text("• 8 Parts of Speech & Subject-Verb Agreement Rules\n• Prepositions of Time (at, on, in) & Place\n• Relative Pronouns (who, which, that)\n• Dialogues and Short Note Writing", fontSize = 11.sp, color = Color(0xFF475569), lineHeight = 16.sp)
              }
            }
          }
        }
      }

      // =========================================================================
      // 2. ✍️ O/L WRITING MASTER (රචනා, ලිපි, දැන්වීම් හා ප්‍රස්ථාර)
      // =========================================================================
      item {
        val isExp = expandedSection == 2
        EnglishSectionCard(
          sectionNumber = "2",
          badgeText = "WRITING MASTER",
          badgeColor = Color(0xFF0284C7),
          title = "✍️ 2. O/L Writing Master (රචනා, ලිපි, දැන්වීම් හා ප්‍රස්ථාර)",
          description = "Formal/Informal Letters, Notices, Articles, Bar/Pie Charts, Speeches සහ Essay Frameworks නියැදි පිළිතුරු සමඟ.",
          backgroundImageRes = R.drawable.img_writing_card_bg_1787064772136,
          isExpanded = isExp,
          onToggle = { expandedSection = if (isExp) null else 2 }
        ) {
          Column(
            modifier = Modifier.padding(top = 12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            templates.forEach { tpl ->
              var isTplExp by remember { mutableStateOf(false) }

              Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F9FF)),
                border = BorderStroke(1.dp, Color(0xFFBAE6FD)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Column(modifier = Modifier.weight(1f)) {
                      Text(tpl.title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0369A1))
                      Text(tpl.description, fontSize = 11.sp, color = Color(0xFF0284C7))
                    }
                    IconButton(onClick = { isTplExp = !isTplExp }) {
                      Icon(if (isTplExp) Icons.Default.ExpandLess else Icons.Default.ExpandMore, contentDescription = "Expand", tint = Color(0xFF0284C7))
                    }
                  }

                  Spacer(modifier = Modifier.height(6.dp))
                  Text("📌 Structure & Marks Tips:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0F172A))
                  tpl.structureSteps.forEach { step ->
                    Text("• $step", fontSize = 10.sp, color = Color(0xFF334155))
                  }

                  if (isTplExp) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Surface(
                      shape = RoundedCornerShape(8.dp),
                      color = Color.White,
                      border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                      modifier = Modifier.fillMaxWidth()
                    ) {
                      Column(modifier = Modifier.padding(10.dp)) {
                        Row(
                          modifier = Modifier.fillMaxWidth(),
                          horizontalArrangement = Arrangement.SpaceBetween,
                          verticalAlignment = Alignment.CenterVertically
                        ) {
                          Text("📄 Model Answer (ආදර්ශ පිළිතුර):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E293B))
                          IconButton(
                            onClick = {
                              if (AppSecurityManager.canCopyContent(context)) {
                                clipboardManager.setText(AnnotatedString(tpl.modelFormat))
                                Toast.makeText(context, "පිටපත් කරගන්නා ලදී (Copied)", Toast.LENGTH_SHORT).show()
                              } else {
                                Toast.makeText(context, "ආරක්ෂක නීති අනුව සටහන් පිටපත් කිරීම (Copy) අවහිර කර ඇත (Admin Only).", Toast.LENGTH_SHORT).show()
                              }
                            },
                            modifier = Modifier.size(24.dp)
                          ) {
                            Icon(Icons.Default.ContentCopy, contentDescription = "Copy", tint = Color(0xFF0284C7), modifier = Modifier.size(15.dp))
                          }
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(tpl.modelFormat, fontSize = 11.sp, color = Color(0xFF334155), lineHeight = 16.sp)
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }

      // =========================================================================
      // 3. 🎙️ AI SPEAKING & PRONUNCIATION COACH (කථන හා උච්චාරණ පුහුණුව)
      // =========================================================================
      item {
        val isExp = expandedSection == 3
        EnglishSectionCard(
          sectionNumber = "3",
          badgeText = "AI VOICE COACH",
          badgeColor = Color(0xFF0EA5E9),
          title = "🎙️ 3. AI Speaking & Pronunciation Coach (කථන පුහුණුව)",
          description = "මයික්‍රෆෝනය මඟින් කතා කර උච්චාරණ නිරවද්‍යතාවය (Accuracy Score %) පරීක්ෂා කර ලකුණු ලබාගන්න.",
          backgroundImageRes = R.drawable.img_videos_bg_1786110404209,
          isExpanded = isExp,
          onToggle = { expandedSection = if (isExp) null else 3 }
        ) {
          Column(
            modifier = Modifier.padding(top = 12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            Text("පුහුණු වන වාක්‍යය තෝරන්න:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0F172A))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
              items(practiceSentences.size) { idx ->
                FilterChip(
                  selected = selectedPracticeIndex == idx,
                  onClick = {
                    selectedPracticeIndex = idx
                    recognizedSpokenText = ""
                    matchAccuracyPercentage = null
                    speechStatusMessage = "මයික්‍රෆෝන් බොත්තම ඔබා ඉංග්‍රීසි වාක්‍යය ශබ්ද නඟා කියවන්න."
                  },
                  label = { Text("වාක්‍යය ${idx + 1} (${practiceSentences[idx].difficulty})", fontSize = 10.sp) },
                  colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFF0284C7),
                    selectedLabelColor = Color.White
                  )
                )
              }
            }

            Surface(
              shape = RoundedCornerShape(12.dp),
              color = Color.White,
              border = BorderStroke(1.dp, Color(0xFFBAE6FD)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFFE0F2FE)) {
                    Text(
                      text = currentPracticeItem.difficulty,
                      fontSize = 9.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF0284C7),
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                  }
                  Row {
                    IconButton(onClick = { speakEnglish(currentPracticeItem.englishText, 1.0f) }, modifier = Modifier.size(28.dp)) {
                      Icon(Icons.Default.VolumeUp, contentDescription = "Normal", tint = Color(0xFF0284C7), modifier = Modifier.size(16.dp))
                    }
                    IconButton(onClick = { speakEnglish(currentPracticeItem.englishText, 0.7f) }, modifier = Modifier.size(28.dp)) {
                      Icon(Icons.Default.SlowMotionVideo, contentDescription = "Slow", tint = Color(0xFFD97706), modifier = Modifier.size(16.dp))
                    }
                  }
                }

                Spacer(modifier = Modifier.height(4.dp))
                Text(currentPracticeItem.englishText, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0F172A))
                Text(currentPracticeItem.phoneticGuide, fontSize = 10.sp, fontFamily = FontFamily.Monospace, color = Color(0xFF64748B))
                Spacer(modifier = Modifier.height(4.dp))
                Text("තේරුම: ${currentPracticeItem.sinhalaMeaning}", fontSize = 11.sp, color = Color(0xFF334155))
              }
            }

            Surface(
              shape = RoundedCornerShape(12.dp),
              color = if (matchAccuracyPercentage != null && matchAccuracyPercentage!! >= 80) Color(0xFFF0FDF4) else Color(0xFFF8FAFC),
              border = BorderStroke(1.dp, if (matchAccuracyPercentage != null && matchAccuracyPercentage!! >= 80) Color(0xFF86EFAC) else Color(0xFFCBD5E1)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(
                modifier = Modifier.padding(14.dp),
                horizontalAlignment = Alignment.CenterHorizontally
              ) {
                Text(speechStatusMessage, fontSize = 11.sp, color = Color(0xFF475569), textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(10.dp))

                Button(
                  onClick = {
                    if (ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
                      val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                        putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                        putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US")
                        putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak the sentence in English now...")
                      }
                      try {
                        isListening = true
                        speechStatusMessage = "🎙️ සවන්දෙමින් පවතී... දැන් කියවන්න."
                        speechLauncher.launch(intent)
                      } catch (e: Exception) {
                        isListening = false
                        Toast.makeText(context, "Speech recognition unavailable", Toast.LENGTH_SHORT).show()
                      }
                    } else {
                      micPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                    }
                  },
                  shape = CircleShape,
                  colors = ButtonDefaults.buttonColors(
                    containerColor = if (isListening) Color(0xFFDC2626) else Color(0xFF0284C7)
                  ),
                  modifier = Modifier.size(56.dp)
                ) {
                  Icon(
                    if (isListening) Icons.Default.Hearing else Icons.Default.Mic,
                    contentDescription = "Mic",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                  )
                }

                if (recognizedSpokenText.isNotBlank()) {
                  Spacer(modifier = Modifier.height(10.dp))
                  Surface(shape = RoundedCornerShape(8.dp), color = Color.White, modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(8.dp)) {
                      Text("ඔබ පැවසූ දෙය: \"$recognizedSpokenText\"", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0F172A))
                      if (matchAccuracyPercentage != null) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                          text = "🎯 නිරවද්‍යතාවය: $matchAccuracyPercentage%",
                          fontSize = 12.sp,
                          fontWeight = FontWeight.ExtraBold,
                          color = if (matchAccuracyPercentage!! >= 80) Color(0xFF16A34A) else Color(0xFFD97706)
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

      // =========================================================================
      // 4. 🎯 INTERACTIVE GRAMMAR & QUIZ BUILDER (ව්‍යාකරණ අභ්‍යාස)
      // =========================================================================
      item {
        val isExp = expandedSection == 4
        EnglishSectionCard(
          sectionNumber = "4",
          badgeText = "GRAMMAR & QUIZZES",
          badgeColor = Color(0xFF8B5CF6),
          title = "🎯 4. Interactive Grammar Builder (ව්‍යාකරණ අභ්‍යාස)",
          description = "Tenses, Passive Voice, Reported Speech සූත්‍ර, උදාහරණ සහ අන්තර්ක්‍රියාකාරී බහුවරණ ප්‍රශ්නාවලි.",
          backgroundImageRes = R.drawable.img_grammar_card_bg_1787064790400,
          isExpanded = isExp,
          onToggle = { expandedSection = if (isExp) null else 4 }
        ) {
          Column(
            modifier = Modifier.padding(top = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
          ) {
            // Grammar Formulas Section
            Text("📘 ප්‍රධාන ව්‍යාකරණ සූත්‍ර හා පාඩම්:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF581C87))
            grammarLessons.forEach { lesson ->
              var isLessonExp by remember { mutableStateOf(false) }
              Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFAF5FF)),
                border = BorderStroke(1.dp, Color(0xFFE9D5FF)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Column(modifier = Modifier.weight(1f)) {
                      Text(lesson.title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF581C87))
                      Text(lesson.sinhalaSummary, fontSize = 11.sp, color = Color(0xFF7E22CE))
                    }
                    IconButton(onClick = { isLessonExp = !isLessonExp }) {
                      Icon(if (isLessonExp) Icons.Default.ExpandLess else Icons.Default.ExpandMore, contentDescription = "Expand", tint = Color(0xFF7E22CE))
                    }
                  }

                  Spacer(modifier = Modifier.height(4.dp))
                  Surface(shape = RoundedCornerShape(6.dp), color = Color.White, border = BorderStroke(1.dp, Color(0xFFE9D5FF)), modifier = Modifier.fillMaxWidth()) {
                    Text("📐 ${lesson.formula}", fontSize = 11.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace, color = Color(0xFF6B21A8), modifier = Modifier.padding(6.dp))
                  }

                  if (isLessonExp) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("නිදසුන් වාක්‍ය (Examples):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF334155))
                    lesson.examples.forEach { (eng, sin) ->
                      Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                      ) {
                        Column(modifier = Modifier.weight(1f)) {
                          Text("• $eng", fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF1E293B))
                          Text("  ($sin)", fontSize = 10.sp, color = Color(0xFF64748B))
                        }
                        IconButton(onClick = { speakEnglish(eng) }, modifier = Modifier.size(24.dp)) {
                          Icon(Icons.Default.VolumeUp, contentDescription = "Speak", tint = Color(0xFF7E22CE), modifier = Modifier.size(15.dp))
                        }
                      }
                    }
                  }
                }
              }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Interactive Quizzes
            Text("📝 ව්‍යාකරණ ස්වයං ඇගයීම් ප්‍රශ්නාවලිය (MCQs):", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF581C87))
            grammarQuizzes.forEachIndexed { qIdx, quiz ->
              var selectedOption by remember { mutableStateOf<Int?>(null) }
              Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color(0xFFDDD6FE)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                  ) {
                    Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFFEDE9FE)) {
                      Text("ප්‍රශ්නය ${qIdx + 1} • ${quiz.category}", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF6D28D9), modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                    }
                  }
                  Spacer(modifier = Modifier.height(6.dp))
                  Text(quiz.question, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E293B))
                  Text("(${quiz.sinhalaPrompt})", fontSize = 10.sp, color = Color(0xFF64748B))

                  Spacer(modifier = Modifier.height(8.dp))
                  quiz.options.forEachIndexed { optIdx, optText ->
                    val isChosen = selectedOption == optIdx
                    val isCorrect = optIdx == quiz.correctIndex
                    Surface(
                      onClick = { selectedOption = optIdx },
                      shape = RoundedCornerShape(8.dp),
                      color = when {
                        selectedOption == null -> Color(0xFFF8FAFC)
                        isChosen && isCorrect -> Color(0xFFDCFCE7)
                        isChosen && !isCorrect -> Color(0xFFFEE2E2)
                        !isChosen && isCorrect && selectedOption != null -> Color(0xFFDCFCE7)
                        else -> Color(0xFFF8FAFC)
                      },
                      border = BorderStroke(
                        1.dp,
                        if (isChosen) (if (isCorrect) Color(0xFF22C55E) else Color(0xFFEF4444)) else Color(0xFFE2E8F0)
                      ),
                      modifier = Modifier.fillMaxWidth().padding(vertical = 3.dp)
                    ) {
                      Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                      ) {
                        Text(
                          text = optText,
                          fontSize = 11.sp,
                          color = if (isChosen && isCorrect) Color(0xFF15803D) else Color(0xFF1E293B),
                          fontWeight = if (isChosen) FontWeight.Bold else FontWeight.Normal
                        )
                      }
                    }
                  }

                  if (selectedOption != null) {
                    Spacer(modifier = Modifier.height(6.dp))
                    Surface(shape = RoundedCornerShape(6.dp), color = Color(0xFFF5F3FF), modifier = Modifier.fillMaxWidth()) {
                      Text("💡 පැහැදිලි කිරීම: ${quiz.explanation}", fontSize = 10.sp, color = Color(0xFF6D28D9), modifier = Modifier.padding(6.dp))
                    }
                  }
                }
              }
            }
          }
        }
      }

      // =========================================================================
      // 5. 📇 DAILY VOCABULARY, IDIOMS & FLASHCARDS (වචන මාලාව)
      // =========================================================================
      item {
        val isExp = expandedSection == 5
        EnglishSectionCard(
          sectionNumber = "5",
          badgeText = "VOCABULARY & IDIOMS",
          badgeColor = Color(0xFF10B981),
          title = "📇 5. දිනපතා වචන මාලාව හා Flashcards (Daily Vocabulary)",
          description = "නව ඉංග්‍රීසි වචන, Phonetics, සිංහල තේරුම්, උදාහරණ වාක්‍ය සහ Idioms & Phrases.",
          backgroundImageRes = R.drawable.img_vocab_card_bg_1787064760289,
          isExpanded = isExp,
          onToggle = { expandedSection = if (isExp) null else 5 }
        ) {
          Column(
            modifier = Modifier.padding(top = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            vocabList.forEach { item ->
              Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF0FDF4)),
                border = BorderStroke(1.dp, Color(0xFFBBF7D0)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                      Text(item.word, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color(0xFF166534))
                      Spacer(modifier = Modifier.width(6.dp))
                      Text(item.pronunciation, fontSize = 11.sp, fontFamily = FontFamily.Monospace, color = Color(0xFF15803D))
                    }
                    IconButton(
                      onClick = { speakEnglish("${item.word}. ${item.exampleSentence}") },
                      modifier = Modifier.size(28.dp)
                    ) {
                      Icon(Icons.Default.VolumeUp, contentDescription = "Speak", tint = Color(0xFF16A34A), modifier = Modifier.size(18.dp))
                    }
                  }
                  Text("තේරුම: ${item.sinhalaMeaning}", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF14532D))
                  Spacer(modifier = Modifier.height(4.dp))
                  Text("📝 Ex: \"${item.exampleSentence}\"", fontSize = 11.sp, color = Color(0xFF334155))
                  Text("(${item.sinhalaSentenceMeaning})", fontSize = 10.sp, color = Color(0xFF64748B))
                }
              }
            }
          }
        }
      }

      // =========================================================================
      // 6. 🎧 LISTENING COMPREHENSION & AUDIO LAB (ශ්‍රවණ අභ්‍යාස)
      // =========================================================================
      item {
        val isExp = expandedSection == 6
        EnglishSectionCard(
          sectionNumber = "6",
          badgeText = "LISTENING LAB",
          badgeColor = Color(0xFFE11D48),
          title = "🎧 6. Listening Comprehension (ශ්‍රවණ අවබෝධතා අභ්‍යාස)",
          description = "කෙටි ශබ්ද පටයකට (Audio Clip) සවන් දී ප්‍රශ්නවලට පිළිතුරු සපයන විභාග ආකෘතියේ අභ්‍යාස.",
          backgroundImageRes = R.drawable.img_listening_card_bg_1787064805369,
          isExpanded = isExp,
          onToggle = { expandedSection = if (isExp) null else 6 }
        ) {
          Column(
            modifier = Modifier.padding(top = 12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            listeningAudios.forEach { audio ->
              Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF1F2)),
                border = BorderStroke(1.dp, Color(0xFFFECDD3)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Text(audio.title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF9F1239))
                  Text("සවන්දීමට පහත බොත්තම ඔබන්න (Listen to the Audio)", fontSize = 10.sp, color = Color(0xFF881337))

                  Spacer(modifier = Modifier.height(8.dp))
                  Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(
                      onClick = { speakEnglish(audio.audioScript, 1.0f) },
                      shape = RoundedCornerShape(8.dp),
                      colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE11D48)),
                      modifier = Modifier.weight(1f),
                      contentPadding = PaddingValues(vertical = 6.dp)
                    ) {
                      Icon(Icons.Default.VolumeUp, contentDescription = "Play", modifier = Modifier.size(16.dp))
                      Spacer(modifier = Modifier.width(4.dp))
                      Text("🔊 1.0x Play Audio", fontSize = 11.sp)
                    }

                    OutlinedButton(
                      onClick = { speakEnglish(audio.audioScript, 0.75f) },
                      shape = RoundedCornerShape(8.dp),
                      colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF9F1239)),
                      modifier = Modifier.weight(1f),
                      contentPadding = PaddingValues(vertical = 6.dp)
                    ) {
                      Icon(Icons.Default.SlowMotionVideo, contentDescription = "Slow", modifier = Modifier.size(16.dp))
                      Spacer(modifier = Modifier.width(4.dp))
                      Text("🐢 0.75x Slow", fontSize = 11.sp)
                    }
                  }

                  Spacer(modifier = Modifier.height(10.dp))
                  Text("📝 ප්‍රශ්නවලට පිළිතුරු තෝරන්න (Answer the Questions):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E293B))

                  audio.questions.forEachIndexed { qIdx, q ->
                    var selectedOpt by remember { mutableStateOf<Int?>(null) }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("${qIdx + 1}. ${q.questionText}", fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF0F172A))

                    q.options.forEachIndexed { optIdx, opt ->
                      val isChosen = selectedOpt == optIdx
                      val isCorrect = optIdx == q.correctIndex
                      Surface(
                        onClick = { selectedOpt = optIdx },
                        shape = RoundedCornerShape(6.dp),
                        color = when {
                          selectedOpt == null -> Color.White
                          isChosen && isCorrect -> Color(0xFFDCFCE7)
                          isChosen && !isCorrect -> Color(0xFFFEE2E2)
                          !isChosen && isCorrect && selectedOpt != null -> Color(0xFFDCFCE7)
                          else -> Color.White
                        },
                        border = BorderStroke(1.dp, if (isChosen) (if (isCorrect) Color(0xFF22C55E) else Color(0xFFEF4444)) else Color(0xFFCBD5E1)),
                        modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
                      ) {
                        Text(opt, fontSize = 10.sp, color = Color(0xFF1E293B), modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp))
                      }
                    }

                    if (selectedOpt != null) {
                      Text("💡 ${q.explanation}", fontSize = 9.sp, color = Color(0xFF059669), modifier = Modifier.padding(top = 2.dp))
                    }
                  }
                }
              }
            }
          }
        }
      }

      // =========================================================================
      // 7. 💬 REAL-LIFE DIALOGUES & ROLE-PLAY (දෛනික සංවාද පුහුණුව)
      // =========================================================================
      item {
        val isExp = expandedSection == 7
        EnglishSectionCard(
          sectionNumber = "7",
          badgeText = "SPOKEN DIALOGUES",
          badgeColor = Color(0xFF059669),
          title = "💬 7. Real-life Dialogues & Role-Play (දෛනික සංවාද)",
          description = "At the Bank, Visiting Doctor, Asking Directions වැනි එදිනෙදා ජීවිතයේ වැදගත් සංවාද ශබ්ද නඟා පුහුණුවන්න.",
          backgroundImageRes = R.drawable.img_subjects_bg_1786107319789,
          isExpanded = isExp,
          onToggle = { expandedSection = if (isExp) null else 7 }
        ) {
          Column(
            modifier = Modifier.padding(top = 12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            dialogues.forEach { dia ->
              var isDiaExp by remember { mutableStateOf(false) }
              Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF0FDF4)),
                border = BorderStroke(1.dp, Color(0xFF86EFAC)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Column(modifier = Modifier.weight(1f)) {
                      Text(dia.title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF166534))
                      Text(dia.situation, fontSize = 10.sp, color = Color(0xFF15803D))
                    }
                    IconButton(onClick = { isDiaExp = !isDiaExp }) {
                      Icon(if (isDiaExp) Icons.Default.ExpandLess else Icons.Default.ExpandMore, contentDescription = "Toggle", tint = Color(0xFF166534))
                    }
                  }

                  if (isDiaExp) {
                    Spacer(modifier = Modifier.height(8.dp))
                    dia.dialogueLines.forEach { line ->
                      Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color.White,
                        border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                        modifier = Modifier.fillMaxWidth().padding(vertical = 3.dp)
                      ) {
                        Row(
                          modifier = Modifier.padding(8.dp),
                          verticalAlignment = Alignment.CenterVertically,
                          horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                          Column(modifier = Modifier.weight(1f)) {
                            Text("${line.speaker}: \"${line.englishText}\"", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0F172A))
                            Text("(${line.sinhalaText})", fontSize = 10.sp, color = Color(0xFF64748B))
                          }
                          IconButton(onClick = { speakEnglish(line.englishText) }, modifier = Modifier.size(26.dp)) {
                            Icon(Icons.Default.VolumeUp, contentDescription = "Speak", tint = Color(0xFF16A34A), modifier = Modifier.size(16.dp))
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

      // =========================================================================
      // 8. 📖 COMPLETE SINHALA-ENGLISH DICTIONARY (සම්පූර්ණ ශබ්දකෝෂය)
      // =========================================================================
      item {
        val isExp = expandedSection == 8
        EnglishSectionCard(
          sectionNumber = "8",
          badgeText = "A-Z 7,800+ WORDS (300/Letter)",
          badgeColor = Color(0xFF6366F1),
          title = "📖 8. සම්පූර්ණ ඉංග්‍රීසි-සිංහල ශබ්දකෝෂය (Complete Dictionary)",
          description = "ඉංග්‍රීසි-සිංහල සම්පූර්ණ ශබ්දකෝෂය. A-Z සෑම අකුරකින්ම වචන 300 බැගින් වචන 7,800+, නිවැරදි Audio උච්චාරණය, Noun/Verb/Adj වර්ගීකරණය සහ සමාන පද (Synonyms).",
          backgroundImageRes = R.drawable.img_grammar_card_bg_1787064790400,
          isExpanded = isExp,
          onToggle = { expandedSection = if (isExp) null else 8 },
          onQuickOpen = { activeSubSectionTab = 3 },
          quickOpenText = "විවෘත කරන්න 🚀"
        ) {
          Column(
            modifier = Modifier.padding(top = 12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            // Full Screen Mode Launcher Card
            Surface(
              onClick = { activeSubSectionTab = 3 },
              shape = RoundedCornerShape(10.dp),
              color = Color(0xFF4F46E5),
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text("📖", fontSize = 16.sp)
                  Spacer(modifier = Modifier.width(8.dp))
                  Column {
                    Text(
                      text = "සම්පූර්ණ ශබ්දකෝෂය (Full Screen Mode)",
                      fontSize = 11.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color.White
                    )
                    Text(
                      text = "A-Z හෝඩිය, Noun/Verb වර්ග සහ Audio සහිත පූර්ණ තිරය",
                      fontSize = 9.sp,
                      color = Color(0xFFE0E7FF)
                    )
                  }
                }
                Icon(
                  imageVector = Icons.Default.ArrowForward,
                  contentDescription = "Open",
                  tint = Color.White,
                  modifier = Modifier.size(16.dp)
                )
              }
            }

            // Search Input Box
            OutlinedTextField(
              value = dictSearchQuery,
              onValueChange = { dictSearchQuery = it },
              modifier = Modifier.fillMaxWidth(),
              placeholder = { Text("වචනයක් සොයන්න (e.g. Persevere, තිරසාර...)", fontSize = 11.sp) },
              leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF6366F1)) },
              trailingIcon = {
                if (dictSearchQuery.isNotBlank()) {
                  IconButton(onClick = { dictSearchQuery = "" }) {
                    Icon(Icons.Default.Clear, contentDescription = "Clear", tint = Color(0xFF64748B))
                  }
                }
              },
              shape = RoundedCornerShape(10.dp),
              colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF6366F1),
                unfocusedBorderColor = Color(0xFFCBD5E1),
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
              ),
              singleLine = true
            )

            // A-Z Alphabet Filter Row
            LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
              items(listOf("ALL") + ('A'..'Z').map { it.toString() }) { letter ->
                FilterChip(
                  selected = dictLetterFilter == letter,
                  onClick = { dictLetterFilter = letter },
                  label = { Text(letter, fontSize = 9.5.sp) },
                  colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFF6366F1),
                    selectedLabelColor = Color.White
                  )
                )
              }
            }

            // Part of Speech Filter Row
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
              listOf("ALL", "Noun", "Verb", "Adjective", "Adverb").forEach { pos ->
                FilterChip(
                  selected = dictPosFilter == pos,
                  onClick = { dictPosFilter = pos },
                  label = { Text(pos, fontSize = 9.sp) },
                  colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFF4F46E5),
                    selectedLabelColor = Color.White
                  )
                )
              }
            }

            // Status Row
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = if (dictLetterFilter != "ALL") "අකුර '$dictLetterFilter': වචන ${filteredDictWords.size} / 300ක් අන්තර්ගතයි" else "වචන ${filteredDictWords.size}ක් අන්තර්ගතයි",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4F46E5)
              )
              if (dictSearchQuery.isNotBlank() || dictLetterFilter != "ALL" || dictPosFilter != "ALL") {
                TextButton(
                  onClick = {
                    dictSearchQuery = ""
                    dictLetterFilter = "ALL"
                    dictPosFilter = "ALL"
                  },
                  contentPadding = PaddingValues(0.dp)
                ) {
                  Text("Reset Filters", fontSize = 9.5.sp, color = Color(0xFFEF4444))
                }
              }
            }

            // Results List
            filteredDictWords.take(40).forEach { wordItem ->
              Card(
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color(0xFFE0E7FF)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(10.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                      Text(wordItem.word, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3730A3))
                      Spacer(modifier = Modifier.width(6.dp))
                      Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFFEEF2FF)) {
                        Text(wordItem.pos, fontSize = 9.sp, color = Color(0xFF4F46E5), modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp))
                      }
                    }
                    IconButton(onClick = { speakEnglish(wordItem.word) }, modifier = Modifier.size(24.dp)) {
                      Icon(Icons.Default.VolumeUp, contentDescription = "Speak", tint = Color(0xFF6366F1), modifier = Modifier.size(16.dp))
                    }
                  }

                  Text("සිංහල තේරුම: ${wordItem.sinhala}", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E293B))
                  Spacer(modifier = Modifier.height(2.dp))
                  Text("English: ${wordItem.englishDef}", fontSize = 10.sp, color = Color(0xFF475569))
                  Spacer(modifier = Modifier.height(2.dp))
                  Text("Ex: \"${wordItem.example}\"", fontSize = 10.sp, color = Color(0xFF64748B))

                  if (wordItem.synonyms.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("සමාන පද (Synonyms): ${wordItem.synonyms.joinToString(", ")}", fontSize = 9.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF4F46E5))
                  }
                }
              }
            }

            if (filteredDictWords.size > 40) {
              Surface(
                onClick = { activeSubSectionTab = 3 },
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFEEF2FF),
                border = BorderStroke(1.dp, Color(0xFFC7D2FE)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Text(
                  text = "තවත් වචන ${filteredDictWords.size - 40}ක් බැලීමට සම්පූර්ණ ශබ්දකෝෂය විවෘත කරන්න ➔",
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF4F46E5),
                  textAlign = TextAlign.Center,
                  modifier = Modifier.padding(vertical = 8.dp)
                )
              }
            }
          }
        }
      }

      // =========================================================================
      // 9. 🔄 ACTIVE & PASSIVE 500 PRACTICE (කාණ්ඩ 20ක් යටතේ වාක්‍ය 500ක්)
      // =========================================================================
      item {
        val isExp = expandedSection == 9
        EnglishSectionCard(
          sectionNumber = "9",
          badgeText = "500 PRACTICE SENTENCES",
          badgeColor = Color(0xFF0369A1),
          title = "🔄 9. Active & Passive 500 Practice (කාණ්ඩ 20ක් යටතේ වාක්‍ය 500ක්)",
          description = "ඇක්ටිව් සහ පැසිව් වාක්‍ය 500ක් කාණ්ඩ 20ක් යටතේ, වාක්‍ය දෙවර්ගයේම සිංහල තේරුම් හා රීති සමඟ පුහුණු වන්න.",
          backgroundImageRes = R.drawable.img_grammar_card_bg_1787064790400,
          isExpanded = isExp,
          onToggle = { expandedSection = if (isExp) null else 9 },
          onQuickOpen = { activeSubSectionTab = 9 },
          quickOpenText = "විවෘත කරන්න 🚀"
        ) {
          Column(
            modifier = Modifier.padding(top = 12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            Button(
              onClick = { activeSubSectionTab = 9 },
              shape = RoundedCornerShape(10.dp),
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0369A1)),
              modifier = Modifier.fillMaxWidth(),
              contentPadding = PaddingValues(vertical = 12.dp)
            ) {
              Icon(Icons.Default.OpenInNew, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
              Spacer(modifier = Modifier.width(8.dp))
              Text("Active & Passive 500 පූර්ණ ප්‍රශ්නාවලිය විවෘත කරන්න 🚀", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }

            Surface(
              onClick = { activeSubSectionTab = 9 },
              shape = RoundedCornerShape(10.dp),
              color = Color(0xFFF0F9FF),
              border = BorderStroke(1.dp, Color(0xFFBAE6FD)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text("🔄", fontSize = 18.sp)
                  Spacer(modifier = Modifier.width(8.dp))
                  Column {
                    Text(
                      text = "කාණ්ඩ 20 කින් යුත් වාක්‍ය 500 මාලාව",
                      fontSize = 12.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF0369A1)
                    )
                    Text(
                      text = "කර්තෘකාරක හා කර්මකාරක වාක්‍ය, සිංහල තේරුම්, සෙවුම් පහසුකම්",
                      fontSize = 10.sp,
                      color = Color(0xFF0284C7)
                    )
                  }
                }
                Icon(
                  imageVector = Icons.Default.ArrowForward,
                  contentDescription = "Open",
                  tint = Color(0xFF0369A1),
                  modifier = Modifier.size(16.dp)
                )
              }
            }
          }
        }
      }

      // =========================================================================
      // 10. 🧩 SENTENCE PUZZLE BUILDER & CLOZE TESTS (වාක්‍ය ගොඩනැගීමේ ක්‍රීඩාව)
      // =========================================================================
      item {
        val isExp = expandedSection == 10
        EnglishSectionCard(
          sectionNumber = "10",
          badgeText = "SENTENCE PUZZLES",
          badgeColor = Color(0xFFD97706),
          title = "🧩 10. Sentence Puzzle & Cloze Tests (වාක්‍ය ගොඩනැගීම)",
          description = "අවුල් සහගතව ඇති වචන නිවැරදි පිළිවෙළට සකස් කර අර්ථවත් වාක්‍ය හැදීමේ අභ්‍යාස සහ Cloze Tests.",
          backgroundImageRes = R.drawable.img_subjects_bg_1786107319789,
          isExpanded = isExp,
          onToggle = { expandedSection = if (isExp) null else 10 },
          onQuickOpen = { activeSubSectionTab = 10 },
          quickOpenText = "විවෘත කරන්න 🚀"
        ) {
          Column(
            modifier = Modifier.padding(top = 12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            Button(
              onClick = { activeSubSectionTab = 10 },
              shape = RoundedCornerShape(10.dp),
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD97706)),
              modifier = Modifier.fillMaxWidth(),
              contentPadding = PaddingValues(vertical = 12.dp)
            ) {
              Icon(Icons.Default.SportsEsports, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
              Spacer(modifier = Modifier.width(8.dp))
              Text("🧩 පූර්ණ තිර Sentence Puzzles & Cloze Tests විවෘත කරන්න 🚀", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
            // Total summary badge
            Card(
              shape = RoundedCornerShape(12.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFBEB)),
              border = BorderStroke(1.dp, Color(0xFFFDE68A)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(
                modifier = Modifier.padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
              ) {
                Surface(
                  shape = CircleShape,
                  color = Color(0xFFD97706),
                  modifier = Modifier.size(42.dp)
                ) {
                  Box(contentAlignment = Alignment.Center) {
                    Text("30", fontSize = 16.sp, fontWeight = FontWeight.Black, color = Color.White)
                  }
                }
                Column(modifier = Modifier.weight(1f)) {
                  Text(
                    "සම්පූර්ණ අභ්‍යාස මාලාව: කාණ්ඩ 30 ක් • ප්‍රශ්න 600 ක්!",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF92400E)
                  )
                  Text(
                    "සෑම කාණ්ඩයකම වාක්‍ය 20 බැගින් ඇත. වචන නිවැරදිව පෙළගස්වා වාක්‍ය ගොඩනැගීම පුහුණු වන්න.",
                    fontSize = 11.sp,
                    color = Color(0xFF78350F)
                  )
                }
              }
            }

            // Category Selector Chips (1 to 30)
            Text(
              "📂 පුහුණු කාණ්ඩය තෝරන්න (කාණ්ඩ 30 න් එකක්):",
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF92400E)
            )

            LazyRow(
              horizontalArrangement = Arrangement.spacedBy(6.dp),
              modifier = Modifier.fillMaxWidth()
            ) {
              items(sentencePuzzleCategories) { cat ->
                val isSelected = cat.id == selectedPuzzleCategoryId
                FilterChip(
                  selected = isSelected,
                  onClick = {
                    selectedPuzzleCategoryId = cat.id
                    showAllAnswersInPuzzleCat = false
                  },
                  label = {
                    Text(
                      "${cat.icon} කාණ්ඩය ${cat.id}",
                      fontSize = 11.sp,
                      fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                  },
                  colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFFD97706),
                    selectedLabelColor = Color.White,
                    containerColor = Color(0xFFFFFBEB),
                    labelColor = Color(0xFF92400E)
                  ),
                  border = FilterChipDefaults.filterChipBorder(
                    enabled = true,
                    selected = isSelected,
                    borderColor = Color(0xFFFCD34D),
                    selectedBorderColor = Color(0xFFB45309)
                  )
                )
              }
            }

            // Current Category Header & Action Banner
            val currentCategory = sentencePuzzleCategories.find { it.id == selectedPuzzleCategoryId }
              ?: sentencePuzzleCategories.firstOrNull()

            if (currentCategory != null) {
              Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFEF3C7)),
                border = BorderStroke(1.5.dp, Color(0xFFF59E0B)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                  ) {
                    Text(currentCategory.icon, fontSize = 24.sp)
                    Column(modifier = Modifier.weight(1f)) {
                      Text(
                        currentCategory.titleSinhala,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF92400E)
                      )
                      Text(
                        currentCategory.titleEnglish,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFB45309)
                      )
                    }
                  }

                  Spacer(modifier = Modifier.height(4.dp))
                  Text(
                    currentCategory.description,
                    fontSize = 11.sp,
                    color = Color(0xFF78350F)
                  )

                  Spacer(modifier = Modifier.height(8.dp))
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Surface(
                      shape = RoundedCornerShape(6.dp),
                      color = Color(0xFFFDE68A)
                    ) {
                      Text(
                        "📝 වාක්‍ය 20 න් 20 ම මෙහි ඇත",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF78350F),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                      )
                    }

                    Button(
                      onClick = {
                        showAllAnswersInPuzzleCat = !showAllAnswersInPuzzleCat
                        currentCategory.puzzles.forEach { p ->
                          revealedPuzzleAnswers[p.id] = showAllAnswersInPuzzleCat
                        }
                      },
                      shape = RoundedCornerShape(6.dp),
                      colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD97706)),
                      contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
                    ) {
                      Text(
                        if (showAllAnswersInPuzzleCat) "සියලු පිළිතුරු සඟවන්න" else "සියලු පිළිතුරු පෙන්වන්න",
                        fontSize = 10.sp
                      )
                    }
                  }
                }
              }

              // The 20 Puzzles for this Category
              currentCategory.puzzles.forEachIndexed { pIdx, puzzle ->
                val isRevealed = showAllAnswersInPuzzleCat || (revealedPuzzleAnswers[puzzle.id] == true)
                Card(
                  shape = RoundedCornerShape(12.dp),
                  colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFBEB)),
                  border = BorderStroke(1.dp, Color(0xFFFDE68A)),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Column(modifier = Modifier.padding(12.dp)) {
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.SpaceBetween,
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Text(
                        "වාක්‍ය ගැටලුව ${pIdx + 1} / 20:",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF92400E)
                      )
                      Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = Color(0xFFFEF3C7)
                      ) {
                        Text(
                          "කාණ්ඩය ${currentCategory.id}",
                          fontSize = 9.sp,
                          color = Color(0xFFB45309),
                          modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                      }
                    }

                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                      "සිංහල අර්ථය: ${puzzle.sinhalaMeaning}",
                      fontSize = 11.sp,
                      color = Color(0xFF78350F)
                    )

                    Spacer(modifier = Modifier.height(6.dp))
                    Text("අවුල් වූ වචන (Scrambled Words):", fontSize = 10.sp, color = Color(0xFF64748B))

                    LazyRow(
                      horizontalArrangement = Arrangement.spacedBy(4.dp),
                      modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                      items(puzzle.scrambledWords) { w ->
                        Surface(
                          shape = RoundedCornerShape(6.dp),
                          color = Color.White,
                          border = BorderStroke(1.dp, Color(0xFFFCD34D))
                        ) {
                          Text(
                            w,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFB45309),
                            modifier = Modifier.padding(horizontal = 7.dp, vertical = 4.dp)
                          )
                        }
                      }
                    }

                    if (isRevealed) {
                      Spacer(modifier = Modifier.height(6.dp))
                      Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFFECFDF5),
                        border = BorderStroke(1.dp, Color(0xFFA7F3D0)),
                        modifier = Modifier.fillMaxWidth()
                      ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                          Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                          ) {
                            Text(
                              "✅ නිවැරදි පිළිතුර:",
                              fontSize = 11.sp,
                              fontWeight = FontWeight.Bold,
                              color = Color(0xFF065F46)
                            )
                            if (isTtsReady) {
                              IconButton(
                                onClick = {
                                  tts?.speak(puzzle.correctSentence, TextToSpeech.QUEUE_FLUSH, null, null)
                                },
                                modifier = Modifier.size(28.dp)
                              ) {
                                Icon(
                                  Icons.Default.VolumeUp,
                                  contentDescription = "Listen",
                                  tint = Color(0xFF059669),
                                  modifier = Modifier.size(18.dp)
                                )
                              }
                            }
                          }
                          Text(
                            "\"${puzzle.correctSentence}\"",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF065F46)
                          )
                          Spacer(modifier = Modifier.height(3.dp))
                          Text(
                            "💡 Hint: ${puzzle.hint}",
                            fontSize = 10.sp,
                            color = Color(0xFF047857)
                          )
                        }
                      }
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Button(
                      onClick = {
                        val current = revealedPuzzleAnswers[puzzle.id] ?: false
                        revealedPuzzleAnswers[puzzle.id] = !current
                      },
                      shape = RoundedCornerShape(6.dp),
                      colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD97706)),
                      contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                      modifier = Modifier.align(Alignment.End)
                    ) {
                      Text(if (isRevealed) "සඟවන්න" else "නිවැරදි පිළිතුර බලන්න", fontSize = 10.sp)
                    }
                  }
                }
              }

              // Category Navigation (Previous / Next)
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                if (selectedPuzzleCategoryId > 1) {
                  OutlinedButton(
                    onClick = {
                      selectedPuzzleCategoryId -= 1
                      showAllAnswersInPuzzleCat = false
                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF92400E)),
                    border = BorderStroke(1.dp, Color(0xFFF59E0B))
                  ) {
                    Text("⬅️ පෙර කාණ්ඩය (${selectedPuzzleCategoryId - 1})", fontSize = 11.sp)
                  }
                } else {
                  Spacer(modifier = Modifier.width(10.dp))
                }

                if (selectedPuzzleCategoryId < sentencePuzzleCategories.size) {
                  Button(
                    onClick = {
                      selectedPuzzleCategoryId += 1
                      showAllAnswersInPuzzleCat = false
                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD97706))
                  ) {
                    Text("ඊළඟ කාණ්ඩය ➡️ (${selectedPuzzleCategoryId + 1})", fontSize = 11.sp)
                  }
                }
              }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Cloze Tests
            Text("📝 විභාග ආකෘතියේ Cloze Tests:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF92400E))
            clozeTests.forEach { cloze ->
              var showAnswers by remember { mutableStateOf(false) }
              Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color(0xFFBFDBFE)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Text(cloze.title, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E3A8A))
                  Text(cloze.instructions, fontSize = 10.sp, color = Color(0xFF64748B))
                  Spacer(modifier = Modifier.height(4.dp))

                  Surface(shape = RoundedCornerShape(6.dp), color = Color(0xFFEFF6FF), modifier = Modifier.fillMaxWidth()) {
                    Text("වචන පෙට්ටිය: ${cloze.wordBank.joinToString(" | ")}", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1D4ED8), modifier = Modifier.padding(6.dp))
                  }

                  Spacer(modifier = Modifier.height(4.dp))
                  Text(cloze.passageWithBlanks, fontSize = 11.sp, color = Color(0xFF1E293B), lineHeight = 16.sp)

                  if (showAnswers) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Surface(shape = RoundedCornerShape(6.dp), color = Color(0xFFECFDF5), modifier = Modifier.fillMaxWidth()) {
                      Column(modifier = Modifier.padding(6.dp)) {
                        Text("✅ නිවැරදි පිළිතුරු: ${cloze.correctAnswers.joinToString(", ")}", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF065F46))
                        Text("පැහැදිලි කිරීම: ${cloze.explanation}", fontSize = 10.sp, color = Color(0xFF047857))
                      }
                    }
                  }

                  Spacer(modifier = Modifier.height(4.dp))
                  Button(
                    onClick = { showAnswers = !showAnswers },
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3B82F6)),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 3.dp),
                    modifier = Modifier.align(Alignment.End)
                  ) {
                    Text(if (showAnswers) "සඟවන්න" else "පිළිතුරු පරීක්ෂා කරන්න", fontSize = 10.sp)
                  }
                }
              }
            }
          }
        }
      }

      // =========================================================================
      // 11. 🔤 09/10/11 ඉංග්‍රීසි කෙටි සටහන් සහ Grammar Auto-Checker (100% Comprehensive Hub)
      // =========================================================================
      item {
        val isExp = expandedSection == 11
        val filteredAutoCheckQuestions = remember(autoCheckGradeFilter, autoCheckCategoryFilter) {
          autoCheckQuestions.filter { q ->
            (autoCheckGradeFilter == EnglishGradeLevel.ALL || q.gradeLevel == autoCheckGradeFilter) &&
              (autoCheckCategoryFilter == EnglishSkillCategory.ALL || q.category == autoCheckCategoryFilter)
          }
        }

        EnglishSectionCard(
          sectionNumber = "11",
          badgeText = "100% ACCURATE AUTO-CHECK",
          badgeColor = Color(0xFF0284C7),
          title = "🔤 11. 09/10/11 ඉංග්‍රීසි කෙටි සටහන් & Grammar Auto-Checker",
          description = "ප්‍රශ්නවලට ක්ෂණිකව පිළිතුරු සපයා ස්වයංක්‍රීයව ලකුණු බලාගන්න. සවිස්තරාත්මක සිංහල විවරණ, Grammar Formulas සහ Exam Tips.",
          backgroundImageRes = R.drawable.img_notes_bg_1786107335103,
          isExpanded = isExp,
          onToggle = { expandedSection = if (isExp) null else 11 },
          onQuickOpen = { activeSubSectionTab = 1 },
          quickOpenText = "විවෘත කරන්න 🚀"
        ) {
          Column(
            modifier = Modifier.padding(top = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
          ) {
            // PDF and Full-Screen Launcher Cards Row
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              Button(
                onClick = { activeSubSectionTab = 1 },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
                modifier = Modifier.weight(1.2f),
                contentPadding = PaddingValues(vertical = 10.dp)
              ) {
                Icon(Icons.Default.Speed, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text("Auto-Checker විවෘත කරන්න 🚀", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }

              Button(
                onClick = { openDrivePdf() },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF59E0B)),
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(vertical = 10.dp)
              ) {
                Icon(Icons.Default.PictureAsPdf, contentDescription = null, tint = Color(0xFF78350F), modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text("PDF සටහන් 📄", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF78350F))
              }
            }

            // Grade Filter Chips
            Column {
              Text("ශ්‍රේණිය තෝරන්න:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E293B))
              Spacer(modifier = Modifier.height(4.dp))
              LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                items(EnglishGradeLevel.values()) { grade ->
                  FilterChip(
                    selected = autoCheckGradeFilter == grade,
                    onClick = { autoCheckGradeFilter = grade },
                    label = { Text(grade.label, fontSize = 10.sp) },
                    colors = FilterChipDefaults.filterChipColors(
                      selectedContainerColor = Color(0xFF0284C7),
                      selectedLabelColor = Color.White
                    )
                  )
                }
              }
            }

            // Category Filter Chips
            Column {
              Text("මාතෘකාව තෝරන්න:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E293B))
              Spacer(modifier = Modifier.height(4.dp))
              LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                items(EnglishSkillCategory.values()) { cat ->
                  FilterChip(
                    selected = autoCheckCategoryFilter == cat,
                    onClick = { autoCheckCategoryFilter = cat },
                    label = { Text("${cat.iconEmoji} ${cat.displayName}", fontSize = 10.sp) },
                    colors = FilterChipDefaults.filterChipColors(
                      selectedContainerColor = Color(0xFF0284C7),
                      selectedLabelColor = Color.White
                    )
                  )
                }
              }
            }

            // Auto-Check Questions List
            Text(
              text = "📝 අන්තර්ක්‍රියාකාරී ප්‍රශ්නාවලිය (ප්‍රශ්න ${filteredAutoCheckQuestions.size}):",
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF0369A1)
            )

            filteredAutoCheckQuestions.forEachIndexed { index, questionItem ->
              val userSelectedIdx = userAutoCheckAnswers[questionItem.id]
              val isAnswered = userSelectedIdx != null
              val isCorrect = userSelectedIdx == questionItem.correctOptionIndex

              Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(
                  1.2.dp,
                  when {
                    !isAnswered -> Color(0xFFE2E8F0)
                    isCorrect -> Color(0xFF22C55E)
                    else -> Color(0xFFEF4444)
                  }
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                      Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Color(0xFF0284C7).copy(alpha = 0.12f)
                      ) {
                        Text(
                          text = "Q${index + 1} • ${questionItem.gradeLevel.label.split(" ")[0]}",
                          fontSize = 9.5.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFF0284C7),
                          modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                      }
                      Spacer(modifier = Modifier.width(6.dp))
                      Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = questionItem.category.bgLightColor
                      ) {
                        Text(
                          text = "${questionItem.category.iconEmoji} ${questionItem.category.displayName}",
                          fontSize = 9.sp,
                          color = questionItem.category.primaryColor,
                          fontWeight = FontWeight.Bold,
                          modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                      }
                    }

                    IconButton(
                      onClick = { speakEnglish(questionItem.questionPrompt) },
                      modifier = Modifier.size(26.dp)
                    ) {
                      Icon(
                        imageVector = Icons.Default.VolumeUp,
                        contentDescription = "Pronounce",
                        tint = Color(0xFF0284C7),
                        modifier = Modifier.size(16.dp)
                      )
                    }
                  }

                  Spacer(modifier = Modifier.height(8.dp))

                  Text(
                    text = questionItem.questionPrompt,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A),
                    lineHeight = 18.sp
                  )

                  if (questionItem.questionSinhalaGuidance.isNotBlank()) {
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                      text = questionItem.questionSinhalaGuidance,
                      fontSize = 10.5.sp,
                      color = Color(0xFF64748B)
                    )
                  }

                  Spacer(modifier = Modifier.height(10.dp))

                  // Options
                  questionItem.options.forEachIndexed { optIdx, optText ->
                    val isOptionSelected = userSelectedIdx == optIdx
                    val isOptionCorrect = optIdx == questionItem.correctOptionIndex

                    Surface(
                      onClick = {
                        userAutoCheckAnswers[questionItem.id] = optIdx
                      },
                      shape = RoundedCornerShape(8.dp),
                      color = when {
                        !isAnswered -> Color(0xFFF8FAFC)
                        isOptionSelected && isOptionCorrect -> Color(0xFFDCFCE7)
                        isOptionSelected && !isOptionCorrect -> Color(0xFFFEE2E2)
                        !isOptionSelected && isOptionCorrect && isAnswered -> Color(0xFFDCFCE7)
                        else -> Color(0xFFF8FAFC)
                      },
                      border = BorderStroke(
                        1.dp,
                        when {
                          !isAnswered -> Color(0xFFE2E8F0)
                          isOptionSelected && isOptionCorrect -> Color(0xFF22C55E)
                          isOptionSelected && !isOptionCorrect -> Color(0xFFEF4444)
                          !isOptionSelected && isOptionCorrect && isAnswered -> Color(0xFF22C55E)
                          else -> Color(0xFFE2E8F0)
                        }
                      ),
                      modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp)
                    ) {
                      Row(
                        modifier = Modifier
                          .fillMaxWidth()
                          .padding(horizontal = 10.dp, vertical = 7.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                      ) {
                        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                          Surface(
                            shape = CircleShape,
                            color = when {
                              !isAnswered -> Color(0xFFCBD5E1)
                              isOptionCorrect -> Color(0xFF16A34A)
                              isOptionSelected -> Color(0xFFDC2626)
                              else -> Color(0xFFCBD5E1)
                            },
                            modifier = Modifier.size(18.dp)
                          ) {
                            Box(contentAlignment = Alignment.Center) {
                              Text(
                                text = "${('A' + optIdx)}",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                              )
                            }
                          }
                          Spacer(modifier = Modifier.width(8.dp))
                          Text(
                            text = optText,
                            fontSize = 11.5.sp,
                            fontWeight = if (isOptionSelected || (isAnswered && isOptionCorrect)) FontWeight.Bold else FontWeight.Normal,
                            color = when {
                              !isAnswered -> Color(0xFF1E293B)
                              isOptionCorrect -> Color(0xFF15803D)
                              isOptionSelected -> Color(0xFFB91C1C)
                              else -> Color(0xFF64748B)
                            }
                          )
                        }

                        if (isAnswered) {
                          if (isOptionCorrect) {
                            Text("✅ නිවැරදියි", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF16A34A))
                          } else if (isOptionSelected) {
                            Text("❌ වැරදියි", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFDC2626))
                          }
                        }
                      }
                    }
                  }

                  // Comprehensive Explanation & Rules
                  if (isAnswered) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Surface(
                      shape = RoundedCornerShape(10.dp),
                      color = if (isCorrect) Color(0xFFF0FDF4) else Color(0xFFFEF2F2),
                      border = BorderStroke(1.dp, if (isCorrect) Color(0xFFBBF7D0) else Color(0xFFFECACA)),
                      modifier = Modifier.fillMaxWidth()
                    ) {
                      Column(modifier = Modifier.padding(10.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                          Text(
                            text = if (isCorrect) "🌟 100% නිවැරදියි!" else "💡 නිවැරදි පිළිතුර හා විවරණය:",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isCorrect) Color(0xFF166534) else Color(0xFF991B1B)
                          )
                        }

                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                          text = questionItem.explanationSinhala,
                          fontSize = 10.5.sp,
                          color = Color(0xFF1E293B),
                          lineHeight = 15.sp
                        )

                        Spacer(modifier = Modifier.height(6.dp))
                        Surface(
                          shape = RoundedCornerShape(6.dp),
                          color = Color.White,
                          border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                          modifier = Modifier.fillMaxWidth()
                        ) {
                          Column(modifier = Modifier.padding(6.dp)) {
                            Text(
                              text = "📐 Grammar Rule: ${questionItem.grammarRuleOrFormula}",
                              fontSize = 10.sp,
                              fontWeight = FontWeight.Bold,
                              color = Color(0xFF0369A1)
                            )
                            if (questionItem.examTip.isNotBlank()) {
                              Spacer(modifier = Modifier.height(2.dp))
                              Text(
                                text = "🎯 විභාග ඉඟිය: ${questionItem.examTip}",
                                fontSize = 9.5.sp,
                                color = Color(0xFFB45309)
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

            // Summary rules cards
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = "📚 මූලික ඉංග්‍රීසි ව්‍යාකරණ කෙටි සටහන් සාරාංශය (Grammar Rules):",
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF0F172A)
            )

            autoCheckRules.take(4).forEach { rule ->
              Card(
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC)),
                border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(10.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(
                      text = "${rule.category.iconEmoji} ${rule.title}",
                      fontSize = 11.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF0F172A)
                    )
                    Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFFE0F2FE)) {
                      Text(
                        text = rule.category.displayName,
                        fontSize = 8.5.sp,
                        color = Color(0xFF0369A1),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                      )
                    }
                  }
                  Spacer(modifier = Modifier.height(4.dp))
                  Surface(shape = RoundedCornerShape(6.dp), color = Color.White, modifier = Modifier.fillMaxWidth()) {
                    Text(
                      text = rule.formula,
                      fontSize = 10.sp,
                      fontWeight = FontWeight.Bold,
                      fontFamily = FontFamily.Monospace,
                      color = Color(0xFF0284C7),
                      modifier = Modifier.padding(6.dp)
                    )
                  }
                  Spacer(modifier = Modifier.height(4.dp))
                  Text(rule.explanationSinhala, fontSize = 10.sp, color = Color(0xFF475569))
                  if (rule.commonMistake.isNotBlank()) {
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(rule.commonMistake, fontSize = 9.5.sp, color = Color(0xFFB91C1C))
                  }
                }
              }
            }
          }
        }
      }
    }

  // Google Drive In-App PDF Dialog
  if (internalShowPdfModal && internalPdfUrl.isNotBlank()) {
    Dialog(
      onDismissRequest = { internalShowPdfModal = false },
      properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
      Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF0F172A)
      ) {
        Column(modifier = Modifier.fillMaxSize()) {
          Surface(color = Color(0xFF1E293B), modifier = Modifier.fillMaxWidth()) {
            Row(
              modifier = Modifier.fillMaxWidth().padding(12.dp),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(internalPdfTitle, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White, maxLines = 1, modifier = Modifier.weight(1f))
              IconButton(onClick = { internalShowPdfModal = false }) {
                Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White)
              }
            }
          }
          AndroidView(
            factory = { ctx ->
              WebView(ctx).apply {
                settings.javaScriptEnabled = true
                settings.domStorageEnabled = true
                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                webViewClient = WebViewClient()
                loadUrl(internalPdfUrl)
              }
            },
            modifier = Modifier.fillMaxSize()
          )
        }
      }
    }
  }
}

// Reusable Sub-Section Banner Card with Unique Background Photo & Expandable Accordion
@Composable
fun EnglishSectionCard(
  sectionNumber: String,
  badgeText: String,
  badgeColor: Color,
  title: String,
  description: String,
  backgroundImageRes: Int,
  isExpanded: Boolean,
  onToggle: () -> Unit,
  onQuickOpen: (() -> Unit)? = null,
  quickOpenText: String = "විවෘත කරන්න 🚀",
  expandedContent: @Composable () -> Unit
) {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 10.dp),
    contentAlignment = Alignment.Center
  ) {
    Card(
      shape = RoundedCornerShape(16.dp),
      colors = CardDefaults.cardColors(containerColor = Color.White),
      border = BorderStroke(1.2.dp, badgeColor.copy(alpha = 0.5f)),
      elevation = CardDefaults.cardElevation(defaultElevation = 2.5.dp),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.fillMaxWidth()) {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .clickable { onToggle() }
      ) {
        Image(
          painter = painterResource(id = backgroundImageRes),
          contentDescription = title,
          contentScale = ContentScale.Crop,
          modifier = Modifier.matchParentSize()
        )

        Box(
          modifier = Modifier
            .matchParentSize()
            .background(
              Brush.verticalGradient(
                colors = listOf(
                  Color(0xFF0F172A).copy(alpha = 0.88f),
                  Color(0xFF1E1B4B).copy(alpha = 0.93f),
                  Color(0xFF0F172A).copy(alpha = 0.97f)
                )
              )
            )
        )

        Column(modifier = Modifier.padding(16.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Surface(
              onClick = onToggle,
              shape = RoundedCornerShape(6.dp),
              color = badgeColor
            ) {
              Text(
                text = badgeText,
                fontSize = 9.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
              )
            }

            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
              if (onQuickOpen != null) {
                Surface(
                  onClick = onQuickOpen,
                  shape = RoundedCornerShape(8.dp),
                  color = badgeColor,
                  border = BorderStroke(1.dp, Color.White.copy(alpha = 0.4f))
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(
                      text = quickOpenText,
                      fontSize = 10.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color.White
                    )
                  }
                }
              }

              Surface(
                onClick = onToggle,
                shape = RoundedCornerShape(8.dp),
                color = Color.White.copy(alpha = 0.25f),
                border = BorderStroke(1.dp, Color.White.copy(alpha = 0.4f))
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(
                    text = if (isExpanded) "හකුළන්න" else "සටහන් බලන්න",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                  )
                  Spacer(modifier = Modifier.width(4.dp))
                  Icon(
                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = "Toggle",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                  )
                }
              }
            }
          }

          Spacer(modifier = Modifier.height(10.dp))

          Text(
            text = title,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            lineHeight = 21.sp
          )

          Spacer(modifier = Modifier.height(4.dp))

          Text(
            text = description,
            fontSize = 11.sp,
            color = Color(0xFFCBD5E1),
            lineHeight = 15.sp
          )
        }
      }

      AnimatedVisibility(
        visible = isExpanded,
        enter = expandVertically() + fadeIn(),
        exit = shrinkVertically() + fadeOut()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          expandedContent()
        }
      }
    }
  }
}
}
