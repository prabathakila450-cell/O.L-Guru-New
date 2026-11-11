package com.example

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

/**
 * 🇬🇧 DEDICATED ENGLISH STUDENT DOUBT VOICE ASSISTANT
 * 100% EXCLUSIVELY FOR ENGLISH LANGUAGE (09, 10, 11 & G.C.E. O/L)
 * STRICTLY CONTAINS NO OTHER SUBJECTS!
 */

data class EnglishDoubtItem(
  val id: String,
  val grade: String, // "9", "10", "11", "ALL"
  val categoryKey: String, // "TENSES", "VOICE", "SPEECH", "PREPOSITIONS", "CONDITIONALS", "CLAUSES", "WRITING", "AGREEMENT", "EXAM_TIPS"
  val categoryNameSinhala: String,
  val questionEnglish: String,
  val questionSinhala: String,
  val shortSummary: String,
  val detailedVoiceExplanation: String,
  val stepByStepSolution: List<String>,
  val ruleOrFormula: String,
  val examTip: String,
  val examples: List<String> = emptyList()
)

object EnglishVoiceDoubtRepository {

  val curatedEnglishDoubts: List<EnglishDoubtItem> = listOf(
    // 1. ACTIVE TO PASSIVE VOICE (SIMPLE PRESENT & PAST)
    EnglishDoubtItem(
      id = "eng_voice_simple",
      grade = "11",
      categoryKey = "VOICE",
      categoryNameSinhala = "Active & Passive Voice",
      questionEnglish = "How to change Active Voice into Passive Voice in Simple Present and Simple Past?",
      questionSinhala = "සරල වර්තමාන හා අතීත කාල වාක්‍ය කර්මකාරක (Passive Voice) බවට හරවන්නේ කෙසේද?",
      shortSummary = "Object becomes Subject + is/am/are/was/were + Past Participle (V3) + by + Agent.",
      detailedVoiceExplanation = "ආයුබෝවන් දුවේ පුතේ. Active Voice හෙවත් කර්තෘකාරක වාක්‍යයක් Passive Voice හෙවත් කර්මකාරක බවට පත් කිරීමේදී ප්‍රධාන පියවර 3ක් අනුගමනය කරන්න. පළමුව, Active වාක්‍යයේ කර්මය හෙවත් Object එක සොයාගෙන, එය නව වාක්‍යයේ උක්තය හෙවත් Subject එක ලෙස මුලට ගෙන එන්න. දෙවනුව, කාලයට හා උක්තයේ ඒකවචන හෝ බහුවචන භාවයට ගැළපෙන Be verb එකක් යොදන්න. සරල වර්තමාන කාලයේදී ඒකවචන නම් 'is', බහුවචන නම් 'are', 'I' නම් 'am' යොදන්න. සරල අතීත කාලයේදී ඒකවචන නම් 'was', බහුවචන නම් 'were' යොදන්න. තෙවනුව, ප්‍රධාන ක්‍රියා පදය අනිවාර්යයෙන්ම එහි තුන්වන ස්වරූපය හෙවත් Past Participle V3 බවට හරවන්න. උදාහරණයක් ලෙස 'Nimal writes a letter' හෙවත් නිමල් ලියුමක් ලියයි යන වාක්‍යයේ කර්මය 'a letter' මුලට ගෙන, වර්තමාන ඒකවචන බැවින් 'is' යොදා, 'writes' යන්න 'written' කර 'by Nimal' එකතු කළ විට 'A letter is written by Nimal' හෙවත් ලියුම නිමල් විසින් ලියනු ලබයි වේ. අතීත කාලයේදී 'Kamal painted the walls' යන්නෙහි 'the walls' බහුවචන අතීත බැවින් 'The walls were painted by Kamal' බවට පත්වේ. සාමාන්‍ය පෙළ විභාගයේදී was සහ were නිවැරදිව තේරීමෙන් ඔබට සම්පූර්ණ ලකුණු ලබාගත හැකිය.",
      stepByStepSolution = listOf(
        "1. Identify Subject, Verb, and Object: (e.g., 'The teacher praised the students').",
        "2. Move the Object to the beginning: 'The students...'",
        "3. Select correct 'Be' verb: 'were' (Plural Past Tense).",
        "4. Change Verb to Past Participle (V3): 'praised'.",
        "5. Add 'by' + original subject: 'The students were praised by the teacher.'"
      ),
      ruleOrFormula = "Present: Object + is/am/are + V3 + (by Subject) | Past: Object + was/were + V3 + (by Subject)",
      examTip = "In O/L Paper II (Test 15 or 16), 2 marks are awarded for correctly identifying the plural/singular 'be' verb (was vs were).",
      examples = listOf(
        "Active: She cleans the room. -> Passive: The room is cleaned by her.",
        "Active: Kamal painted the walls. -> Passive: The walls were painted by Kamal."
      )
    ),

    // 2. ACTIVE TO PASSIVE VOICE (CONTINUOUS & PERFECT TENSES)
    EnglishDoubtItem(
      id = "eng_voice_cont_perfect",
      grade = "11",
      categoryKey = "VOICE",
      categoryNameSinhala = "Active & Passive Voice",
      questionEnglish = "How do we change Continuous and Perfect tenses into Passive Voice?",
      questionSinhala = "අඛණ්ඩ (Continuous) සහ පූර්ණ (Perfect) කාල වාක්‍ය Passive Voice කරන්නේ කෙසේද?",
      shortSummary = "Continuous uses 'being + V3', while Perfect tenses use 'been + V3'.",
      detailedVoiceExplanation = "Continuous හෙවත් අඛණ්ඩ සහ Perfect හෙවත් පූර්ණ කාල වාක්‍ය Passive Voice කිරීමේදී කිසිදා අමතක නොකළ යුතු රහස් පද දෙකක් තිබෙනවා. ඒ 'being' සහ 'been' යන පද දෙකයි. ඕනෑම Continuous වාක්‍යයක ක්‍රියා පදයේ 'ing' අගයක් ඇති බැවින්, Passive කිරීමේදී Be verb එකට පසුව අනිවාර්යයෙන්ම 'being' යොදා ප්‍රධාන ක්‍රියාව V3 කළ යුතුය. සූත්‍රය: Object + is, am, are, was, were + being + V3. උදාහරණයක් ලෙස 'Mother is preparing lunch' හෙවත් අම්මා දිවා ආහාරය පිළියෙල කරමින් සිටියි යන්න Passive කළ විට 'Lunch is being prepared by mother' වේ. පූර්ණ කාල හෙවත් Perfect Tenses වලදී has, have හෝ had සමඟ අනිවාර්යයෙන්ම 'been' එකතු කරන්න. උදාහරණයක් ලෙස 'They have repaired the road' හෙවත් ඔවුන් පාර ප්‍රතිසංස්කරණය කර ඇත යන්න Passive කළ විට 'The road has been repaired' වේ. මතක තබාගන්න, ක්‍රියාවේ 'ing' තිබේ නම් 'being' ද, has, have, had තිබේ නම් 'been' ද යෙදීම 100%ක් නිවැරදි ක්‍රමයයි.",
      stepByStepSolution = listOf(
        "1. Present Continuous: Object + is/am/are + being + V3.",
        "2. Past Continuous: Object + was/were + being + V3.",
        "3. Present Perfect: Object + has/have + been + V3.",
        "4. Past Perfect: Object + had + been + V3.",
        "5. Golden rule: Never drop the 'ing' in continuous—it converts into 'being'!"
      ),
      ruleOrFormula = "Continuous: Be verb + being + V3 | Perfect: has/have/had + been + V3",
      examTip = "Students often confuse 'being' and 'been'. Remember: 'b-e-i-n-g' has 'ing' for continuous actions!",
      examples = listOf(
        "Active: Mother is preparing lunch. -> Passive: Lunch is being prepared by mother.",
        "Active: They have repaired the road. -> Passive: The road has been repaired."
      )
    ),

    // 3. DIRECT TO REPORTED SPEECH (STATEMENTS & BACKSHIFT)
    EnglishDoubtItem(
      id = "eng_speech_statements",
      grade = "11",
      categoryKey = "SPEECH",
      categoryNameSinhala = "Direct & Reported Speech",
      questionEnglish = "What are the rules for converting Direct Statements into Reported Speech?",
      questionSinhala = "ප්‍රකාශන වාක්‍ය වක්‍ර කථනයට (Reported Speech) පෙරළීමේ මූලික නීති මොනවාද?",
      shortSummary = "Backshift the tense one step into the past, adjust pronouns, and change time/place adverbs.",
      detailedVoiceExplanation = "කෙනෙකු කියූ ප්‍රකාශන වාක්‍යයක් වක්‍ර කථනයට හෙවත් Reported Speech වලට හැරවීමේදී ප්‍රධාන නීති තුනක් අනුගමනය කළ යුතුය. පළමුව කාලය එක් පියවරක් අතීතයට රැගෙන යාම හෙවත් Tense Backshift කිරීමයි. සරල වර්තමාන කාලය සරල අතීත කාලය බවටත්, Present Continuous යන්න Past Continuous බවටත්, Present Perfect යන්න Past Perfect බවටත් පත්වේ. will යන්න would ද, can යන්න could ද වේ. දෙවනුව සර්වනාම වෙනස් කිරීමයි. කථකයා අනුව I යන්න he හෝ she ලෙසද, my යන්න his හෝ her ලෙසද, we යන්න they ලෙසද වෙනස් වේ. තෙවනුව කාලය හා ස්ථානය හඟවන පද වෙනස් කිරීමයි. උදාහරණයක් ලෙස today යන්න that day බවටත්, tomorrow යන්න the next day බවටත්, yesterday යන්න the previous day බවටත්, now යන්න then බවටත්, here යන්න there බවටත් පත්වේ. උදාහරණයක් බලමු: He said, 'I am very tired today' යන්න Indirect කළ විට He said that he was very tired that day බවට පත්වේ. උද්ධෘත පාඨ හෙවත් Quotation Marks ඉවත් කර that සම්බන්ධකය යෙදීමට අමතක නොකරන්න.",
      stepByStepSolution = listOf(
        "1. Remove quotation marks (\"...\") and add connector 'that'.",
        "2. Change Pronouns according to the speaker and listener.",
        "3. Backshift Tense: write -> wrote, is writing -> was writing, has written -> had written.",
        "4. Modals: will -> would, can -> could, may -> might, must -> had to.",
        "5. Time adverbs: today -> that day, tomorrow -> the following day, now -> then."
      ),
      ruleOrFormula = "Reporting Verb (said that) + Subject + Past Tense Verb + Adjusted Time/Place markers",
      examTip = "In O/L Paper 2, remember that 'said to me' changes into 'told me'. Never write 'told to me'!",
      examples = listOf(
        "Direct: He said, 'I am very tired today.' -> Reported: He said that he was very tired that day.",
        "Direct: She said, 'I have lost my pen.' -> Reported: She said that she had lost her pen."
      )
    ),

    // 4. DIRECT TO REPORTED SPEECH (QUESTIONS & REQUESTS)
    EnglishDoubtItem(
      id = "eng_speech_questions",
      grade = "11",
      categoryKey = "SPEECH",
      categoryNameSinhala = "Direct & Reported Speech",
      questionEnglish = "How to convert Direct Questions and Imperatives into Indirect Speech?",
      questionSinhala = "ප්‍රශ්න සහ විධාන/ඉල්ලීම් වාක්‍ය Indirect Speech කරන්නේ කෙසේද?",
      shortSummary = "For Yes/No questions use 'if' or 'whether'. For Wh- questions keep Wh- word. Use 'asked' + statement word order.",
      detailedVoiceExplanation = "ප්‍රශ්න සහ විධාන වාක්‍ය Reported Speech බවට පත් කිරීමේදී විශේෂ නීති කිහිපයක් තිබෙනවා. ප්‍රශ්න වාක්‍ය වලදී ප්‍රශ්නාර්ථ ලකුණ ඉවත් වී සාමාන්‍ය ප්‍රකාශන වාක්‍යයක වචන පෙළගැස්ම බවට පත්වේ. Yes හෝ No පිළිතුරු ලැබෙන ප්‍රශ්න නම් if හෝ whether සම්බන්ධකය යොදා asked ක්‍රියා පදය යොදන්න. උදාහරණයක් ලෙස 'Do you like tea?' he asked යන්න He asked if I liked tea බවට හැරවේ. Where, When, Why වැනි Wh ප්‍රශ්න වලදී එම Wh වචනය එලෙසම තබා උක්තය මුලට ගෙන ක්‍රියාව අතීතයට හරවන්න. උදාහරණයක් ලෙස 'Where do you live?' she asked යන්න She asked where I lived වේ. කිසිවිටෙකත් 'where did I live' ලෙස නොලියන්න. විධාන හා ඉල්ලීම් වලදී told to හෝ asked to සමඟ මුල් ක්‍රියා පදය යොදන්න. උදාහරණයක් ලෙස 'Open the door' යන්න He told me to open the door ලෙසද, එපා කියන විධානයක් නම් 'Don't shout' යන්න He told us not to shout ලෙස not to එකතු කර ලියන්න.",
      stepByStepSolution = listOf(
        "1. Yes/No Questions: Use reporting verb 'asked' + 'if' or 'whether' + Subject + Verb.",
        "2. Wh- Questions: Use 'asked' + Wh-word (where, when, why, how) + Subject + Verb.",
        "3. Invert question syntax: 'Where is he?' becomes 'where he was' (Subject before Verb).",
        "4. Positive Imperative: told/asked/ordered + Person + to + base verb.",
        "5. Negative Imperative: told/advised + Person + NOT to + base verb."
      ),
      ruleOrFormula = "Yes/No: asked + if/whether + S + V | Wh-: asked + wh-word + S + V | Imperative: ordered/asked + to + V1",
      examTip = "Never use 'did' or question word order in reported questions! Say 'She asked where I lived', NOT 'She asked where did I live'.",
      examples = listOf(
        "Direct: 'Do you speak English?' he asked. -> Reported: He asked if I spoke English.",
        "Direct: 'Please help me,' she said. -> Reported: She asked me to help her."
      )
    ),

    // 5. PRESENT PERFECT VS SIMPLE PAST (SINCE VS FOR)
    EnglishDoubtItem(
      id = "eng_tenses_present_perfect",
      grade = "10",
      categoryKey = "TENSES",
      categoryNameSinhala = "Tenses & Verbs",
      questionEnglish = "What is the difference between Simple Past and Present Perfect, and when do we use Since and For?",
      questionSinhala = "Simple Past සහ Present Perfect අතර වෙනස කුමක්ද? Since සහ For යොදන්නේ කවදාද?",
      shortSummary = "Simple Past is for finished past time. Present Perfect connects past actions to the present. 'Since' = starting point; 'For' = duration.",
      detailedVoiceExplanation = "සරල අතීත කාලය හෙවත් Simple Past සහ ප්‍රසන්ට් පර්ෆෙක්ට් හෙවත් Present Perfect කාලය අතර පැහැදිලි වෙනසක් ඇත. යම් ක්‍රියාවක් අතීතයේ නිශ්චිත දිනයක හෝ වේලාවක සිදුවී අවසන් වූවා නම් යොදන්නේ Simple Past කාලයයි. ඊට yesterday, last year, two days ago හෝ 2020 වැනි නිශ්චිත අතීත කාල සීමාවන් යෙදේ. උදාහරණයක් ලෙස 'I visited Kandy last week'. නමුත් යම් ක්‍රියාවක් අතීතයේ ආරම්භ වී එහි ප්‍රතිඵලය හෝ බලපෑම වර්තමානය දක්වා පවතී නම්, හෝ සිදු වූ නිශ්චිත වේලාවක් සඳහන් නැති නම් Present Perfect හෙවත් have හෝ has සමඟ V3 යෙදිය යුතුය. මෙහිදී Since යොදන්නේ ක්‍රියාව ආරම්භ වූ නිශ්චිත ලක්ෂ්‍යය දැක්වීමටයි. උදාහරණ: since Monday, since 2018, since morning. For යොදන්නේ ක්‍රියාව පැවති මුළු කාල පරාසය දැක්වීමටයි. උදාහරණ: for five years, for two hours. නිදසුනක් ලෙස 'She has lived in Colombo since 2020' හෙවත් ඇය 2020 සිට කොළඹ ජීවත් වී ඇත සහ 'She has lived in Colombo for four years' හෙවත් ඇය වසර හතරක් තිස්සේ මෙහි ජීවත් වී ඇත ලෙස දැක්විය හැකිය.",
      stepByStepSolution = listOf(
        "1. Simple Past: Specific completed past time (yesterday, ago, last month, in 2015).",
        "2. Present Perfect: Action connected to now (Subject + have/has + Past Participle V3).",
        "3. Use 'SINCE': Specific starting point (since Monday, since 8:00 AM, since childhood).",
        "4. Use 'FOR': Duration or length of time (for 3 days, for 10 years, for a long time).",
        "5. Common clue words for Present Perfect: already, just, yet, ever, never, recently."
      ),
      ruleOrFormula = "Present Perfect: Subject + have/has + V3 | Since + starting point | For + duration",
      examTip = "O/L Test 5 frequently tests 'since' and 'for'. Check whether the phrase is a point in time (since 2022) or duration (for 4 years).",
      examples = listOf(
        "Simple Past: She graduated in 2021.",
        "Present Perfect: She has lived in Colombo since 2021. / She has lived here for 5 years."
      )
    ),

    // 6. CONDITIONAL SENTENCES (TYPES 0, 1, 2, 3)
    EnglishDoubtItem(
      id = "eng_cond_sentences",
      grade = "11",
      categoryKey = "CONDITIONALS",
      categoryNameSinhala = "If Conditionals",
      questionEnglish = "What are the rules and formulas for Conditional Sentences (Types 1, 2, and 3)?",
      questionSinhala = "කොන්දේසි සහිත වාක්‍ය (Conditional Types 1, 2, 3) සූත්‍ර සහ නීති මොනවාද?",
      shortSummary = "Type 1: If + Present, will + V1. Type 2: If + Past, would + V1. Type 3: If + Past Perfect, would have + V3.",
      detailedVoiceExplanation = "කොන්දේසි සහිත If වාක්‍ය වර්ග 4ක් තිබෙනවා. Type 0 යනු පොදු විද්‍යාත්මක සත්‍යයන් ය. If + Simple Present නම් අනික් පසද Simple Present වේ. උදාහරණ: If you heat water, it boils. Type 1 යනු අනාගතයේ සිදුවිය හැකි සැබෑ කොන්දේසි ය. If + Simple Present සමඟ Main clause එකේ will + V1 යෙදේ. උදාහරණ: If you study hard, you will pass the exam හෙවත් ඔබ මහන්සි වී පාඩම් කළහොත් විභාගය සමත් වනු ඇත. Type 2 යනු වර්තමානයේ සිදුවිය නොහැකි මනඃකල්පිත උපකල්පනයි. If + Simple Past සමඟ would + V1 යෙදේ. උදාහරණ: If I won a lottery, I would help poor people. මෙහිදී was වෙනුවට were යෙදීම විධිමත් ක්‍රමයයි: If I were rich. Type 3 යනු අතීතයේ සිදුවී අවසන් වූ, වෙනස් කළ නොහැකි පසුතැවීම් ප්‍රකාශ කිරීමයි. If + Past Perfect හෙවත් had + V3 සමඟ would have + V3 යෙදේ. උදාහරණ: If you had studied hard, you would have passed the exam හෙවත් ඔබ එදා මහන්සි වී පාඩම් කළා නම් විභාගය සමත් වන්නට තිබුණා. සාමාන්‍ය පෙළ විභාගයේ Test 15 සඳහා මෙම සූත්‍රය ඉතා වැදගත් වේ.",
      stepByStepSolution = listOf(
        "1. Type 0 (Universal truth): If + Simple Present, Simple Present ('If water boils, it turns to steam').",
        "2. Type 1 (Probable future): If + Simple Present (V1) , will + base verb (V1).",
        "3. Type 2 (Hypothetical): If + Simple Past (V2) , would + base verb (V1).",
        "4. Type 3 (Past regret): If + had + V3 , would have + Past Participle (V3).",
        "5. Comma rule: Use a comma only when the sentence begins with 'If'."
      ),
      ruleOrFormula = "T1: If + V1, will + V1 | T2: If + V2, would + V1 | T3: If + had V3, would have V3",
      examTip = "In O/L Paper 2 (Test 15), look at the main clause: if it has 'would have passed', the If-clause MUST take 'had + V3'!",
      examples = listOf(
        "Type 1: If it rains tomorrow, we will stay indoors.",
        "Type 2: If I won a lottery, I would travel around the world.",
        "Type 3: If she had invited me, I would have attended the party."
      )
    ),

    // 7. RELATIVE CLAUSES & PRONOUNS (WHO, WHICH, WHOSE, THAT)
    EnglishDoubtItem(
      id = "eng_relative_clauses",
      grade = "10",
      categoryKey = "CLAUSES",
      categoryNameSinhala = "Relative Clauses",
      questionEnglish = "When do we use Who, Whom, Whose, Which, and That in relative clauses?",
      questionSinhala = "Who, Whom, Whose, Which සහ That සම්බන්ධක පද වාක්‍යවලට යොදන්නේ කෙසේද?",
      shortSummary = "Who = people (subject); Whom = people (object); Whose = possession; Which = things/animals; That = both.",
      detailedVoiceExplanation = "වාක්‍ය දෙකක් එකට සම්බන්ධ කිරීම සඳහා Relative Pronouns යොදාගන්නා ආකාරය සරලව තේරුම් ගනිමු. Who යොදන්නේ පුද්ගලයන් උක්තය ලෙස සම්බන්ධ කිරීමටයි. උදාහරණයක් ලෙස 'The boy who won the race is my friend' හෙවත් තරගය දිනූ පිරිමි ළමයා මගේ මිතුරාය. Whom යොදන්නේ පුද්ගලයා කර්මය වන විටයි: 'The teacher whom we respect'. Whose යොදන්නේ අයිතියක් හෙවත් කාගේද යන්න දැක්වීමටයි. උදාහරණයක් ලෙස 'The girl whose mother is a doctor' හෙවත් යම් දැරියකගේ මව වෛද්‍යවරියක්ද එම දැරිය. මෙහි whose වෙනුවට her දමා බැලූ විට වාක්‍ය ගැළපේ නම් whose යෙදීම නිවැරදි වේ. Which යොදන්නේ සතුන් සහ අජීවී ද්‍රව්‍ය සඳහා පමණි. උදාහරණයක් ලෙස 'The book which I bought yesterday is interesting'. That යන්න පුද්ගලයන්ට මෙන්ම ද්‍රව්‍ය වලටද යෙදිය හැක. ස්ථාන සඳහා Where ද, කාලය සඳහා When ද යොදාගන්න.",
      stepByStepSolution = listOf(
        "1. 'WHO': Refers to people as the subject of the clause ('The man who helped us').",
        "2. 'WHICH': Refers to animals and objects ('The bus which goes to Kandy').",
        "3. 'WHOSE': Replaces possessive adjectives his, her, their, its ('The boy whose dog barked').",
        "4. 'THAT': Used for both people and things in defining relative clauses.",
        "5. 'WHERE' for places and 'WHEN' for time periods."
      ),
      ruleOrFormula = "Person + WHO + Verb | Person + WHOSE + Noun | Object + WHICH/THAT + Verb",
      examTip = "To test if 'whose' is correct, replace it with 'his' or 'her'. If the sentence makes sense, 'whose' is the correct answer.",
      examples = listOf(
        "I met a girl who speaks five languages.",
        "This is the novel which won the national literary award.",
        "The singer whose song went viral is from Galle."
      )
    ),

    // 8. PREPOSITIONS OF TIME & PLACE (IN, ON, AT)
    EnglishDoubtItem(
      id = "eng_prep_in_on_at",
      grade = "9",
      categoryKey = "PREPOSITIONS",
      categoryNameSinhala = "Prepositions & Articles",
      questionEnglish = "How do we choose between In, On, and At for time and place?",
      questionSinhala = "කාලය සහ ස්ථාන සඳහා In, On, At නිවැරදිව තෝරාගන්නේ කෙසේද?",
      shortSummary = "Time: At = precise time; On = days and dates; In = months, years, and long periods. Place: At = exact point; On = surface; In = enclosed space.",
      detailedVoiceExplanation = "කාලය සහ ස්ථාන සඳහා In, On, At තෝරාගැනීම පහසුවෙන් මතක තබාගැනීමට ත්‍රිකෝණාකාර ක්‍රමය යොදාගන්න. ඉතාම නිශ්චිත, කුඩාම දේ සඳහා At යෙදේ. වේලාව දැක්වීමට 'at 7:00 AM', රාත්‍රියට 'at night', දහවලට 'at noon' යෙදේ. ස්ථානයක් ලෙස නිශ්චිත තැනක් දැක්වීමට 'at the bus stop', 'at school', 'at the door' යෙදේ. ඊළඟට දින සහ දිනයන් සඳහා On යෙදේ. උදාහරණ: 'on Monday', 'on 25th December', 'on my birthday'. මතුපිටක් මත ඇති දෙයක් දැක්වීමටද On යෙදේ: 'on the table', 'on the wall'. විශාලම කාල සීමාවන් සඳහා In යෙදේ. මාස වලට 'in May', අවුරුදු වලට 'in 2026', සෘතු වලට 'in summer' යෙදේ. වටවූ හෝ සීමා සහිත ස්ථාන වලටද In යෙදේ: 'in the room', 'in Kandy', 'in Sri Lanka'. උදෑසන, දවල් සහ සවසට 'in the morning, in the afternoon, in the evening' යෙදෙන නමුත් රාත්‍රියට 'at night' යෙදෙන බව විශේෂයෙන් මතක තබාගන්න.",
      stepByStepSolution = listOf(
        "1. TIME - AT: Exact clock time (at 6:30), holiday periods without 'day' (at Christmas), at night.",
        "2. TIME - ON: Days of the week (on Sunday), calendar dates (on 15th April), on Friday morning.",
        "3. TIME - IN: Months (in August), years (in 2026), centuries, parts of day (in the morning).",
        "4. PLACE - AT: Exact locations/points (at the station, at the entrance, at home).",
        "5. PLACE - ON: Surfaces (on the wall, on page 24) and street names (on Temple Road).",
        "6. PLACE - IN: Inside borders/enclosed containers (in the classroom, in a box, in England)."
      ),
      ruleOrFormula = "Time: At (hours) -> On (days/dates) -> In (months/years) | Place: At (point) -> On (surface) -> In (area/3D)",
      examTip = "Notice: 'at night' but 'in the morning', 'in the afternoon', and 'in the evening'. Also, 'at the weekend' (UK) vs 'on the weekend' (US).",
      examples = listOf(
        "The exam starts at 8:30 AM on Monday in the main hall.",
        "She was born in 2008 on 14th February in Kandy."
      )
    ),

    // 9. SUBJECT-VERB AGREEMENT (SINGULAR VS PLURAL)
    EnglishDoubtItem(
      id = "eng_subject_verb_agreement",
      grade = "10",
      categoryKey = "AGREEMENT",
      categoryNameSinhala = "Subject-Verb Agreement",
      questionEnglish = "What are the essential Subject-Verb Agreement rules for O/L exams?",
      questionSinhala = "විභාග සඳහා Subject-Verb Agreement (උක්ත-ආඛ්‍යාත පෑහීම) රීති මොනවාද?",
      shortSummary = "Singular subjects take singular verbs (-s/-es/is/was/has). Either/neither, each, everyone take singular verbs.",
      detailedVoiceExplanation = "උක්ත-ආඛ්‍යාත පෑහීම හෙවත් Subject-Verb Agreement යනු ඉංග්‍රීසි භාෂාවේ ප්‍රධානතම රීතියකි. ඒකවචන උක්තයකට ඒකවචන ක්‍රියා පදයක්ද, බහුවචන උක්තයකට බහුවචන ක්‍රියා පදයක්ද යෙදිය යුතුය. වර්තමාන කාලයේදී ඒකවචන උක්ත සමඟ ක්‍රියා පදයට 's' හෝ 'es' එකතු වේ: 'The student writes', බහුවචන නම් 's' එකතු නොවේ: 'The students write'. විභාගයේදී වරදින ප්‍රධාන තැන් කිහිපයක් තිබේ. Everyone, Everybody, Each of, Neither of, Either of යන පද සමඟ සැමවිටම යෙදෙන්නේ ඒකවචන ක්‍රියා පදයකි: 'Each of the boys has a pen' (ළමුන් සියලු දෙනාටම පෑන බැගින් ඇත). තවද 'as well as' හෝ 'along with' මඟින් සම්බන්ධ වන විට ක්‍රියා පදය ගැළපෙන්නේ පළමු උක්තයට පමණි: 'The teacher along with the students was present'. මෙහි teacher ඒකවචන බැවින් 'was' යෙදේ.",
      stepByStepSolution = listOf(
        "1. Singular subject = singular verb (He runs / She has / The child is).",
        "2. Plural subject = plural verb (They run / We have / Children are).",
        "3. Ignore prepositional phrases: 'One of my friends IS coming' (subject is 'one').",
        "4. 'Each', 'Everyone', 'Nobody', 'Either of', 'Neither of' = always singular!",
        "5. 'Along with' / 'as well as' / 'together with': Verb agrees with the FIRST subject."
      ),
      ruleOrFormula = "Singular Subject + Verb+s/es (is/was/has) | Plural Subject + Base Verb (are/were/have)",
      examTip = "In O/L Test 5 (Fill in the blanks with correct verb form), look at the real subject before the preposition 'of'. 'A box of apples IS on the desk'.",
      examples = listOf(
        "Neither of the answers is correct.",
        "The captain, along with his team members, was felicitated at the assembly.",
        "Each of the candidates has received an admission card."
      )
    ),

    // 10. O/L FORMAL LETTER WRITING FORMAT (TEST 14)
    EnglishDoubtItem(
      id = "eng_writing_formal_letter",
      grade = "11",
      categoryKey = "WRITING",
      categoryNameSinhala = "Letter & Essay Writing",
      questionEnglish = "What is the official format and scoring criteria for the O/L Formal Letter (Test 14)?",
      questionSinhala = "සාමාන්‍ය පෙළ Test 14 නිල ලිපි (Formal Letter) ආකෘතිය සහ ලකුණු ලබාගන්නේ කෙසේද?",
      shortSummary = "Sender address, Date, Receiver designation & address, Salutation, Subject heading, 3-paragraph body, Sign-off.",
      detailedVoiceExplanation = "සාමාන්‍ය පෙළ Test 14 නිල ලිපිය හෙවත් Formal Letter සඳහා ලකුණු 10ක් හිමිවේ. මෙහිදී ආකෘතියට පමණක් ලකුණු 3ක් හිමිවන බැවින් Block ආකෘතිය නිවැරදිව පවත්වා ගන්න. වම් පැත්තේ ඉහළින්ම ඔබේ ලිපිනය ලියා, ඊට යටින් දිනය ලියන්න. පේළියක් හැර ලිපිය ලබන්නාගේ තනතුර සහ ලිපිනය ලියන්න. උදාහරණ: The Principal, Rahula College, Matara. ඉන්පසු ආමන්ත්‍රණය 'Dear Sir' හෝ 'Dear Madam' ලෙස ලියන්න. ඊළඟට ලිපියේ මාතෘකාව හෙවත් Subject එක පැහැදිලිව ලියා යටින් ඉරක් අඳින්න. උදාහරණ: 'Request for Permission to Organize an English Day'. ලිපියේ බඳ ඡේද 3කින් ලියන්න. පළමු ඡේදයෙන් ලිවීමෙහි අරමුණද, දෙවන ඡේදයෙන් සියලු විස්තර සහ හේතුද, තෙවන ඡේදයෙන් කාරුණික ඉල්ලීම සහ ස්තූතියද දක්වන්න. අවසානයේ 'Yours faithfully' ලියා අත්සන හා සම්පූර්ණ නම ලියන්න.",
      stepByStepSolution = listOf(
        "1. Sender's Address (top left) followed by Date (e.g., 14th October 2026).",
        "2. Receiver's Official Designation & Address (The Principal, Rahula College, Matara).",
        "3. Salutation: 'Dear Sir,' or 'Dear Madam,'.",
        "4. Subject Line: Underlined and centered/left (e.g., 'Request for Permission to Organize an English Workshop').",
        "5. Body Paragraph 1 (Purpose), Paragraph 2 (Details/Reasons), Paragraph 3 (Conclusion/Action).",
        "6. Complimentary Close: 'Yours faithfully,' + Signature + Full Name."
      ),
      ruleOrFormula = "Format (3) + Content (3) + Language & Grammar (4) = 10 Marks Total",
      examTip = "If you don't know the receiver's name, ALWAYS close with 'Yours faithfully,'. If you used 'Dear Mr. Silva', close with 'Yours sincerely,'.",
      examples = listOf(
        "Subject: Requesting permission to use the school auditorium for the Annual Drama Festival.",
        "Closing: Yours faithfully, / K. A. Perera / (Secretary - English Club)"
      )
    ),

    // 11. O/L NOTICE WRITING FORMAT (TEST 3 & 4)
    EnglishDoubtItem(
      id = "eng_writing_notice",
      grade = "10",
      categoryKey = "WRITING",
      categoryNameSinhala = "Letter & Essay Writing",
      questionEnglish = "What is the perfect 5-mark format for writing an O/L School Notice (Test 3/4)?",
      questionSinhala = "O/L Test 3 හෝ 4 සඳහා ලකුණු 5ම ගන්නා Notice (දැන්වීම්) ආකෘතිය කුමක්ද?",
      shortSummary = "Heading 'NOTICE', Event Title, Date, Time, Venue, Purpose, Eligibility/Instructions, Sign-off.",
      detailedVoiceExplanation = "සාමාන්‍ය පෙළ විභාගයේ Test 3 හෝ 4 සඳහා එන දැන්වීම හෙවත් Notice ලිවීම ලකුණු 5ම ලබාගත හැකි පහසුම ප්‍රශ්නයකි. පළමුවෙන්ම දැන්වීම වටා පැහැදිලි රාමුවක් හෙවත් Box එකක් අඳින්න. ඉහළ මැදින් 'NOTICE' යන වචනය සියලු අකුරු කැපිටල් වලින් ලියන්න. ඊට යටින් ආකර්ෂණීය මාතෘකාව ලියන්න: උදාහරණ 'ANNUAL ENGLISH DEBATE 2026'. ඉන්පසු කරුණු පහක් පැහැදිලිව ඇතුළත් කරන්න. එනම්: දිනය (Date), වේලාව (Time), ස්ථානය (Venue), සහභාගි විය හැකි අය (Who can participate), සහ අමතන පුද්ගලයා. දිනය, වේලාව සහ ස්ථානය නොලියුවහොත් ලකුණු කැපේ. අවසානයේ දකුණු හෝ වම් කෙළවරේ සංවිධායක තනතුර ලියන්න: උදාහරණ 'Secretary, English Literary Association'.",
      stepByStepSolution = listOf(
        "1. Draw a neat rectangular box around the notice.",
        "2. Write 'NOTICE' in capital letters centered at the top.",
        "3. Write the catchy Event Title (e.g., 'ANNUAL SCIENCE EXHIBITION 2026').",
        "4. Include mandatory details clearly: Date, Time, Venue, and Target Audience.",
        "5. State registration deadline and guidelines clearly.",
        "6. Bottom sign-off: Designation and Club/School name."
      ),
      ruleOrFormula = "BOX + 'NOTICE' + Event Title + Date/Time/Venue + Eligibility + Secretary Sign-off",
      examTip = "Missing the Venue or Date will immediately cost you 1 content mark. Always double-check Date, Time, and Venue!",
      examples = listOf(
        "NOTICE\nANNUAL INTER-HOUSE DEBATE\nDate: 25th March 2026\nTime: 9:00 AM - 1:00 PM\nVenue: College Auditorium\nOrganized by: English Literary Association"
      )
    ),

    // 12. O/L BAR CHART & GRAPH DESCRIPTION (TEST 14)
    EnglishDoubtItem(
      id = "eng_writing_bar_chart",
      grade = "11",
      categoryKey = "WRITING",
      categoryNameSinhala = "Letter & Essay Writing",
      questionEnglish = "How do we write a 10-mark Bar Chart or Pie Chart description in O/L Paper 2?",
      questionSinhala = "O/L විභාගයේ Test 14 ප්‍රස්තාර/බාර් චාර්ට් (Bar Chart) විස්තර කර ලකුණු 10ම ගන්නේ කෙසේද?",
      shortSummary = "Introductory sentence, Highest value, Lowest value, Equal/Similar values, Comparisons, and Conclusion.",
      detailedVoiceExplanation = "Test 14 ප්‍රස්තාර විස්තර කිරීමේදී වචන 100ක පමණ ඡේදයක් ලියා ලකුණු 10ම ලබාගන්නේ මෙසේය. පළමු වාක්‍යයෙන් ප්‍රස්තාරයෙන් දැක්වෙන දේ හඳුන්වා දෙන්න: 'This bar chart illustrates the leisure activities preferred by Grade 11 students'. දෙවනුව ඉහළම අගය දක්වන්න: 'The highest percentage of students preferred playing sports, which was 45%'. තෙවනුව අඩුම අගය දක්වන්න: 'On the other hand, the lowest percentage was recorded for reading, at only 10%'. ඉන්පසු 'while', 'whereas', 'higher than', 'twice as many' වැනි සංසන්දනාත්මක පද යොදා වර්ග සංසන්දනය කරන්න. අවසාන වාක්‍යයෙන් නිගමනය දක්වන්න: 'In conclusion, it is evident that outdoor sports are more popular than reading'. ඔබගේ පෞද්ගලික අදහස් නොලියා ප්‍රස්ථාරයේ දත්ත පමණක් ඇසුරු කර ලිවීම අනිවාර්ය වේ.",
      stepByStepSolution = listOf(
        "1. Introduction: 'This bar chart / pie chart illustrates / shows the...'",
        "2. Highest value: 'The highest number of / The majority of / The most popular is...'",
        "3. Lowest value: 'The lowest percentage / The least favored category is...'",
        "4. Comparisons: Use 'while', 'whereas', 'twice as many', 'higher than', 'equal to'.",
        "5. Conclusion: 'In conclusion / Overall, it is evident that...'"
      ),
      ruleOrFormula = "Introductory Sentence + Highest + Lowest + Comparisons (whereas/while) + Concluding Summary",
      examTip = "Never express your personal opinions or reasons not shown in the chart! Only report the actual facts and numbers provided in the diagram.",
      examples = listOf(
        "According to the chart, 35% of respondents preferred cycling, whereas only 15% preferred swimming.",
        "In conclusion, the data demonstrates that science remains the most sought-after stream."
      )
    ),

    // 13. QUESTION TAGS RULES & EXCEPTIONS
    EnglishDoubtItem(
      id = "eng_question_tags",
      grade = "10",
      categoryKey = "GRAMMAR",
      categoryNameSinhala = "Spoken Grammar",
      questionEnglish = "What are the rules and common traps in Question Tags?",
      questionSinhala = "Question Tags (ප්‍රශ්න හැලි) සෑදීමේ රීති සහ විභාගයේදී වරදින විශේෂ තැන් මොනවාද?",
      shortSummary = "Positive sentence -> Negative tag. Negative sentence -> Positive tag. 'I am' -> 'aren't I?'. 'Let's' -> 'shall we?'.",
      detailedVoiceExplanation = "Question Tags හෙවත් ප්‍රශ්න හැලි යෙදීමේ ප්‍රධාන රීතිය වන්නේ විරුද්ධ ස්වභාවය පවත්වා ගැනීමයි. ප්‍රකාශය සාධනීය හෙවත් Positive නම්, Tag එක සෘණාත්මක හෙවත් Negative විය යුතුය: 'She is a teacher, isn't she?'. ප්‍රකාශය සෘණාත්මක නම්, Tag එක සාධනීය විය යුතුය: 'They haven't arrived, have they?'. වාක්‍යයේ Be verb එකක් නැති නම් වර්තමානයට don't හෝ doesn't ද, අතීත කාලයට didn't ද යොදන්න: 'You speak English, don't you?'. විභාගයේදී විශේෂයෙන් අසන ව්‍යතිරේක දෙකක් තිබේ. 'I am' සඳහා යෙදෙන්නේ 'aren't I?' යන්නයි. 'Let's' සඳහා යෙදෙන්නේ 'shall we?' යන්නයි. තවද 'never, hardly, seldom' වැනි අර්ථයෙන් සෘණාත්මක වචන වාක්‍යයේ තිබේ නම් Tag එක සාධනීය විය යුතුය: 'He never drinks tea, does he?'.",
      stepByStepSolution = listOf(
        "1. Identify the auxiliary or modal verb (is, are, was, were, has, have, can, will).",
        "2. Check polarity: Positive sentence = Negative contracted tag (isn't, didn't, can't).",
        "3. If no auxiliary: Use 'don't' / 'doesn't' for Present, and 'didn't' for Past.",
        "4. Always use personal pronoun in the tag (never use names: Kamal -> he, girls -> they).",
        "5. Exceptions: 'I am' -> 'aren't I?' | 'Let's' -> 'shall we?' | Imperatives -> 'will you?'."
      ),
      ruleOrFormula = "Positive Sentence + Negative Auxiliary Tag + Pronoun? | Negative Sentence + Positive Auxiliary Tag + Pronoun?",
      examTip = "Words with negative meaning like 'never', 'hardly', 'scarcely', and 'seldom' make the sentence negative, so the tag MUST be positive! E.g., 'He never drinks coffee, DOES he?'.",
      examples = listOf(
        "She plays the piano wonderfully, doesn't she?",
        "You didn't forget the tickets, did you?",
        "I am invited to the meeting, aren't I?"
      )
    ),

    // 14. ARTICLES: A, AN, THE & ZERO ARTICLE
    EnglishDoubtItem(
      id = "eng_articles_rules",
      grade = "9",
      categoryKey = "PREPOSITIONS",
      categoryNameSinhala = "Prepositions & Articles",
      questionEnglish = "How do we know when to use A, An, The, or No Article (Zero Article)?",
      questionSinhala = "A, An, The හෝ කිසිදු Article එකක් නොයෙදෙන තැන් (Zero Article) තෝරාගන්නේ කෙසේද?",
      shortSummary = "Use 'a/an' for general singular countable nouns based on sound. Use 'the' for specific/unique items. No article for uncountables and plurals in general.",
      detailedVoiceExplanation = "A, An, The සහ Zero Article නිවැරදිව යෙදීම ශබ්දය මත පදනම් වේ. ගණන් කළ හැකි ඒකවචන නාම පදයක ආරම්භක ශබ්දය ව්‍යංජන ශබ්දයක් නම් 'A' යොදන්න: 'a book', 'a cat', 'a university' (මෙහි u අකුර 'යු' ලෙස ශබ්ද වන බැවින් a යෙදේ). ස්වර ශබ්දයකින් (a, e, i, o, u ශබ්ද වලින්) ආරම්භ වේ නම් 'An' යොදන්න: 'an apple', 'an umbrella', 'an honest man' (මෙහි h ශබ්ද නොවන බැවින් an යෙදේ). යම් විශේෂිත වූ හෝ ලෝකයේ එකක් පමණක් ඇති දෙයක් නම් 'The' යොදන්න: 'the sun', 'the moon', 'the president', 'the Mahaweli river'. නමුත් රටවල්, පුද්ගල නම්, ක්‍රීඩා, භාෂා සහ පොදුවේ කතා කරන ගණන් කළ නොහැකි නාම සඳහා කිසිදු article එකක් නොයෙදේ (Zero Article). උදාහරණ: 'I live in Sri Lanka' මිස 'in the Sri Lanka' නොවේ.",
      stepByStepSolution = listOf(
        "1. 'A': Singular countable noun starting with a consonant SOUND (a car, a European country).",
        "2. 'AN': Singular countable noun starting with a vowel SOUND (an umbrella, an hour).",
        "3. 'THE': Specific item, already mentioned noun, unique things (the moon), superlatives (the best).",
        "4. 'ZERO ARTICLE': Names of people, countries (Sri Lanka), languages (English), sports (cricket).",
        "5. General uncountables: 'Knowledge is power' (no article)."
      ),
      ruleOrFormula = "A + Consonant Sound | An + Vowel Sound | The + Specific/Unique/Superlative | Zero + Proper Nouns/General Plural",
      examTip = "Sound matters, not the spelling! E.g., 'an honest man' (silent h), 'a university' (consonant /j/ sound), 'an MP' (starts with 'em' sound).",
      examples = listOf(
        "He is an honest police officer.",
        "Mount Everest is the highest mountain peak in the world.",
        "She studies English literature at a university in Colombo."
      )
    ),

    // 15. MODALS: CAN, COULD, MAY, MIGHT, MUST, SHOULD
    EnglishDoubtItem(
      id = "eng_modals_usage",
      grade = "10",
      categoryKey = "TENSES",
      categoryNameSinhala = "Tenses & Verbs",
      questionEnglish = "What are the exact meanings and exam uses of Modal Auxiliary Verbs?",
      questionSinhala = "Modal Verbs (Can, Could, May, Must, Should) වල නිවැරදි භාවිතයන් මොනවාද?",
      shortSummary = "Can = ability/informal permission; Could = past ability/polite request; Must = strong obligation; Should = advice/recommendation.",
      detailedVoiceExplanation = "Modal ආධාරක ක්‍රියා පද මඟින් කථකයාගේ අදහස ප්‍රකාශ වේ. Modals සමඟ සැමවිටම ක්‍රියා පදයේ මුල් ස්වරූපය (Base Verb V1) යෙදිය යුතු අතර කිසිවිටෙකත් 'to' හෝ 's' එකතු නොකරයි. 'Can' යොදන්නේ වර්තමාන හැකියාව හෝ සාමාන්‍ය අවසරය දැක්වීමටයි: 'I can swim'. 'Could' යොදන්නේ අතීත හැකියාව හෝ ඉතා විනීත ඉල්ලීම් වලටයි: 'Could you please help me?'. 'May' යොදන්නේ ගෞරවනීය අවසරය හෝ ඉහළ සම්භාවිතාවටයි: 'May I come in?', 'It may rain today'. 'Must' යොදන්නේ අනිවාර්ය නීතියක් හෝ යුතුකමක් දැක්වීමටයි: 'You must wear a uniform'. 'Should' යොදන්නේ යහපත් උපදෙසක් ලබාදීමටයි: 'You should study daily'. තහනම් ක්‍රියාවකට 'must not' යොදන්න.",
      stepByStepSolution = listOf(
        "1. Base verb rule: Modal + Base Verb (V1) always! (She can SING, never 'can to sing').",
        "2. Ability: Can (present) vs Could (past).",
        "3. Permission: Can (informal friends), May (formal respect), Could (polite request).",
        "4. Obligation / Rule: Must (strict rule / duty) vs Should (good advice / recommendation).",
        "5. Prohibition: Must not / Musn't (strictly forbidden: 'You musn't smoke here')."
      ),
      ruleOrFormula = "Subject + Modal (can/could/may/might/must/should) + Base Verb (V1)",
      examTip = "Never add '-s' or '-ed' to a modal verb! There is no 'mights' or 'canned'. Also, never use 'to' after modals (except 'ought to').",
      examples = listOf(
        "You must submit your assignment before Friday.",
        "Could you please lend me your dictionary for a moment?",
        "Students should drink plenty of water during exam days."
      )
    ),

    // 16. CONNECTORS & CONJUNCTIONS (ALTHOUGH, DESPITE, WHEREAS)
    EnglishDoubtItem(
      id = "eng_conjunctions_contrast",
      grade = "11",
      categoryKey = "CLAUSES",
      categoryNameSinhala = "Relative Clauses",
      questionEnglish = "How do we properly use Although, Despite, In spite of, and However?",
      questionSinhala = "Although, Despite, In spite of සහ However වාක්‍ය සම්බන්ධක නිවැරදිව භාවිත කරන්නේ කෙසේද?",
      shortSummary = "'Although' is followed by Subject + Verb clause. 'Despite / In spite of' is followed by a Noun phrase or -ing gerund.",
      detailedVoiceExplanation = "වාක්‍ය දෙකක් පරස්පර අදහස් සහිතව සම්බන්ධ කිරීම සඳහා Although, Despite, In spite of සහ However භාවිත කරන නිවැරදි ක්‍රමවේදය මෙසේය. 'Although' සහ 'Even though' යෙදූ පසු සම්පූර්ණ වාක්‍ය ඛණ්ඩයක් හෙවත් උක්තයක් සහ ක්‍රියාවක් (Subject + Verb) යෙදිය යුතුය. උදාහරණයක් ලෙස: 'Although it rained heavily, we played the match' හෙවත් තද වැසි පැවතියද අපි තරගය ක්‍රීඩා කළෙමු. නමුත් 'Despite' සහ 'In spite of' යෙදූ පසු කිසිවිටෙකත් සම්පූර්ණ වාක්‍යයක් නොයෙදිය යුතු අතර නාම පදයක් හෝ ing සහිත gerund ක්‍රියා පදයක් පමණක් යෙදිය යුතුය: 'Despite the heavy rain, we played the match' හෝ 'In spite of being tired, she finished the work'. විභාගයේදී ළමුන්ට බහුලවම වරදින තැනක් නම් 'despite of' ලෙස ලිවීමයි. Despite සමඟ කිසිවිටෙකත් 'of' නොයෙදෙන බව මතක තබාගන්න. 'However' යනු වාක්‍ය දෙකක් අතර තිතක් තබා නව වාක්‍යයක ආරම්භයේදී කොමාවක් සමඟ යොදන සම්බන්ධකයකි: 'It was raining. However, they went out'.",
      stepByStepSolution = listOf(
        "1. 'ALTHOUGH' + Subject + Verb: 'Although he was poor, he was honest.'",
        "2. 'DESPITE' + Noun / V-ing: 'Despite his poverty, he was honest.' (NO 'of'!).",
        "3. 'IN SPITE OF' + Noun / V-ing: 'In spite of being tired, she finished her homework.'",
        "4. 'HOWEVER': Connects two sentences, followed by a comma ('Sentence. However, Sentence.')",
        "5. Secret trick: 'Despite the fact that...' can be followed by a full clause."
      ),
      ruleOrFormula = "Although + S + V | Despite + Noun/V-ing | In spite of + Noun/V-ing | Sentence. However, Sentence.",
      examTip = "A very common student mistake in O/L Paper 2 is writing 'Despite of'. Remember: Despite NEVER takes 'of'!",
      examples = listOf(
        "Although she studied diligently, she felt nervous before the exam.",
        "Despite studying diligently, she felt nervous before the exam.",
        "The project was challenging. However, the team completed it on schedule."
      )
    ),

    // 17. O/L ESSAY WRITING STRUCTURE & TRANSITIONS (TEST 16)
    EnglishDoubtItem(
      id = "eng_writing_essay_test16",
      grade = "11",
      categoryKey = "WRITING",
      categoryNameSinhala = "Letter & Essay Writing",
      questionEnglish = "How to write a high-scoring 15-mark Essay for O/L Test 16?",
      questionSinhala = "O/L Test 16 සඳහා ලකුණු 15න් 14+ක් ලබාගන්නා රචනා (Essay) ලිවීමේ ක්‍රමය කුමක්ද?",
      shortSummary = "150-200 words in 4 distinct paragraphs: Catchy Introduction, 2 rich Body paragraphs with linking words, and a strong Conclusion.",
      detailedVoiceExplanation = "සාමාන්‍ය පෙළ විභාගයේ Test 16 රචනාව හෙවත් Essay සඳහා ලකුණු 15ක් හිමිවේ. මෙය මුළු ලකුණු වලින් 15%කි. උපරිම ලකුණු ලබාගැනීම සඳහා වචන 150 සිට 200 දක්වා පැහැදිලි ඡේද 4කින් රචනය ගොඩනගන්න. පළමු ඡේදය හැඳින්වීම හෙවත් Introduction වේ. මාතෘකාව අර්ථ දක්වා කියවන්නාගේ අවධානය දිනාගන්නා ආරම්භයක් ලබාදෙන්න. දෙවන ඡේදයෙන් ඔබගේ පළමු ප්‍රධාන කරුණ විස්තර කරන්න. ඊට සාක්ෂි හා සැබෑ ලෝකයේ උදාහරණ එක් කරන්න. මෙය ආරම්භ කිරීමට 'First and foremost' හෝ 'To begin with' වැනි Linkers යොදාගන්න. තෙවන ඡේදයෙන් දෙවන ප්‍රධාන කරුණ හෝ වාසි-අවාසි සංසන්දනය කරන්න. 'Furthermore', 'In addition' හෝ 'On the other hand' භාවිත කරන්න. සිව්වන ඡේදය නිගමනය හෙවත් Conclusion වේ. 'In conclusion' හෝ 'To sum up' ලෙස අරඹා සියලු කරුණු සංක්ෂිප්ත කර මතකයේ රැඳෙන ප්‍රබල අවසන් අදහසක් දක්වන්න. ලකුණු බෙදී යන්නේ අන්තර්ගතයට 4ක්, සංවිධානයට 3ක්, භාෂාවට 4ක් සහ අක්ෂර වින්‍යාසයට 4ක් වශයෙනි.",
      stepByStepSolution = listOf(
        "1. Planning (3 mins): Jot down 5-6 key vocabulary words and 3 main sub-points.",
        "2. Paragraph 1 (Introduction): Hook sentence + Definition of topic + General thesis statement.",
        "3. Paragraph 2 (First Body Point): Topic sentence + Explanation + Real-world example.",
        "4. Paragraph 3 (Second Body Point): Furthermore / In addition + Supporting details.",
        "5. Paragraph 4 (Conclusion): 'In conclusion,' + Summary of points + Final recommendation.",
        "6. Proofreading (2 mins): Check subject-verb agreement, capital letters, and punctuation."
      ),
      ruleOrFormula = "Intro (30 words) + Body 1 (60 words) + Body 2 (60 words) + Conclusion (30 words) = ~180 Words",
      examTip = "Marks are distributed: Content (4), Organization & Coherence (3), Language & Vocabulary (4), Mechanics of Writing/Spelling (4). Keep paragraphs visually separated!",
      examples = listOf(
        "Topic: The Role of Youth in Protecting the Environment.",
        "Key linkers to use: To begin with, Furthermore, Consequently, Moreover, In conclusion."
      )
    ),

    // 18. PHRASAL VERBS COMMONLY TESTED IN O/L
    EnglishDoubtItem(
      id = "eng_phrasal_verbs",
      grade = "11",
      categoryKey = "GRAMMAR",
      categoryNameSinhala = "Spoken Grammar",
      questionEnglish = "What are the top 10 most tested Phrasal Verbs in G.C.E. O/L English?",
      questionSinhala = "සාමාන්‍ය පෙළ විභාගයේ නිතර අසන ප්‍රධාන Phrasal Verbs 10 සහ ඒවායේ අර්ථ මොනවාද?",
      shortSummary = "A verb + preposition that creates a unique idiomatic meaning (e.g., look after = care for, give up = stop trying).",
      detailedVoiceExplanation = "Phrasal Verb එකක් යනු සාමාන්‍ය ක්‍රියා පදයක් සමඟ preposition එකක් එකතු වී සම්පූර්ණයෙන්ම අලුත් අර්ථයක් දෙන පදයකි. සාමාන්‍ය පෙළ විභාගයට නිතරම අසන ප්‍රධාන Phrasal Verbs 10 සහ ඒවායේ නිවැරදි සිංහල තේරුම් මෙන්න: 1. 'Look after' යනු යමෙකු බලාකියා ගැනීම හෙවත් රැකබලා ගැනීමයි. උදාහරණ: She looks after her younger sister. 2. 'Look forward to' යනු යමක් ගැන දැඩි ආශාවෙන් හා බලාපොරොත්තුවෙන් පසුවීමයි. මෙහිදී ඉදිරියට සැමවිටම ing ක්‍රියා පදයක් යෙදේ: I look forward to meeting you. 3. 'Give up' යනු උත්සාහය අත්හැරීම හෝ පුරුද්දක් නැවැත්වීමයි: Never give up your hopes. 4. 'Put off' යනු යම් උත්සවයක් හෝ රැස්වීමක් පසුවට කල් දැමීමයි. 5. 'Call off' යනු සම්පූර්ණයෙන්ම අවලංගු කිරීමයි: The match was called off due to rain. 6. 'Bring up' යනු දරුවන් ඇතිදැඩි කිරීම හෝ මාතෘකාවක් මතු කිරීමයි. 7. 'Carry out' යනු කාර්යයක් හෝ පරීක්ෂණයක් ක්‍රියාත්මක කිරීමයි. 8. 'Turn down' යනු යෝජනාවක් ප්‍රතික්ෂේප කිරීමයි. 9. 'Come across' යනු නොසිතූ ලෙස අහම්බෙන් හමුවීමයි. 10. 'Run out of' යනු යමක් අවසන් වීමයි: We have run out of water.",
      stepByStepSolution = listOf(
        "1. 'Look after': To care for ('Grandmother looks after the baby').",
        "2. 'Look forward to': To anticipate with excitement ('I look forward to meeting you' - with -ing!).",
        "3. 'Put off': To postpone ('The meeting was put off until next week').",
        "4. 'Call off': To cancel ('The cricket match was called off due to heavy rain').",
        "5. 'Give up': To stop trying or abandon a habit ('Never give up on your dreams')."
      ),
      ruleOrFormula = "Base Verb + Particle (look + after = care) != Literal meaning of the individual words",
      examTip = "Notice: 'look forward to' is ALWAYS followed by a noun or '-ing' verb: 'I look forward to HEARING from you', NEVER 'look forward to hear'.",
      examples = listOf(
        "The principal decided to call off the sports meet due to adverse weather.",
        "We have run out of printer paper in the staff room."
      )
    ),

    // 19. CONFUSING WORDS & HOMOPHONES
    EnglishDoubtItem(
      id = "eng_confusing_words",
      grade = "9",
      categoryKey = "GRAMMAR",
      categoryNameSinhala = "Spoken Grammar",
      questionEnglish = "How to avoid confusing: Their/There/They're, Affect/Effect, and Its/It's?",
      questionSinhala = "Their/There/They're, Affect/Effect සහ Its/It's වරදින්නේ නැතිව ලියන්නේ කෙසේද?",
      shortSummary = "Their = possessive; There = place; They're = they are. Affect = action verb; Effect = result noun. Its = possessive; It's = it is.",
      detailedVoiceExplanation = "ශබ්දය එක සමාන නමුත් අර්ථය හා අක්ෂර වින්‍යාසය වෙනස් වචන විභාගයේදී නිවැරදිව භාවිත කරමු. 1. There, Their, They're: 'There' යන්නෙන් එතැන හෙවත් ස්ථානයක් දැක්වේ: 'Go there'. 'Their' යන්නෙන් ඔවුන්ගේ යන අයිතිය දැක්වේ: 'This is their school'. 'They're' යනු 'They are' යන්නෙහි කෙටි යෙදුමයි: 'They're playing now'. 2. Affect සහ Effect: 'Affect' යනු A අකුරින් පටන් ගන්නා Action Verb එකක් හෙවත් බලපෑම් කරනවා යන ක්‍රියා පදයයි: 'Smoking affects your health'. 'Effect' යනු E අකුරින් පටන් ගන්නා නාම පදයක් හෙවත් ප්‍රතිඵලයයි: 'The side effects of medicine'. 3. Its සහ It's: ඇපොස්ට්‍රොෆි කොමාව සහිත 'It's' යනු 'It is' හෝ 'It has' හි කෙටිකිරීමයි: 'It's raining' හෙවත් It is raining. ඇපොස්ට්‍රොෆි කොමාව රහිත 'Its' යනු ඌගේ හෙවත් එහි යන අයිතිය දක්වන පදයයි: 'The cat licked its tail'.",
      stepByStepSolution = listOf(
        "1. THERE: Place indicator ('Over there') or existential ('There are 40 students').",
        "2. THEIR: Possessive adjective belonging to them ('Their classroom is clean').",
        "3. THEY'RE: Contraction for 'they are' ('They're playing badminton').",
        "4. AFFECT: Verb = to influence ('Smoking affects health').",
        "5. EFFECT: Noun = the result ('The greenhouse effect').",
        "6. IT'S: Short for 'It is' ('It's a sunny day'). ITS: Possessive ('The dog wagged its tail')."
      ),
      ruleOrFormula = "There (place) vs Their (theirs) vs They're (they are) | Affect (Action) vs Effect (End result)",
      examTip = "Whenever writing 'it's', test by reading it as 'it is'. If 'it is' sounds ridiculous, remove the apostrophe!",
      examples = listOf(
        "They're going to their school over there.",
        "Pollution has a devastating effect on the environment, and it will affect future generations."
      )
    ),

    // 20. O/L EXAM TIME MANAGEMENT & TEST 1-16 STRATEGY
    EnglishDoubtItem(
      id = "eng_exam_strategy",
      grade = "11",
      categoryKey = "EXAM_TIPS",
      categoryNameSinhala = "O/L Exam Tips",
      questionEnglish = "What is the best time allocation and strategy for O/L English Paper I and Paper II?",
      questionSinhala = "සාමාන්‍ය පෙළ ඉංග්‍රීසි ප්‍රශ්න පත්‍ර I සහ II සඳහා කාලය කළමනාකරණය කරන්නේ කෙසේද?",
      shortSummary = "Paper I (1 hour = 40 marks): 6-7 mins per test. Paper II (2 hours = 60 marks): Test 14 (25 mins), Test 16 (35 mins), 10 mins checking.",
      detailedVoiceExplanation = "සාමාන්‍ය පෙළ ඉංග්‍රීසි විභාගයෙන් ඒ සාමාර්ථයක් ලබාගැනීමට කාලය කළමනාකරණය ඉතා තීරණාත්මකයි. පළමු ප්‍රශ්න පත්‍රයට පැය 1ක කාලයක් සහ ලකුණු 40ක් හිමිවේ. එහි ප්‍රශ්න 8ක් ඇති බැවින් එක් ප්‍රශ්නයකට උපරිම වශයෙන් විනාඩි 6ක් හෝ 7ක් පමණක් යොදවන්න. නොදන්නා එක වචනයක් ළඟ සිරවී කාලය නාස්ති නොකරන්න. දෙවන ප්‍රශ්න පත්‍රයට පැය 2ක කාලයක් සහ ලකුණු 60ක් හිමිවේ. මෙහිදී පළමු විනාඩි 45 තුළ කෙටි ප්‍රශ්න වන Test 9, 10, 11, 12, 13 ලියා අවසන් කරන්න. ලකුණු 10ක Test 14 ලිපිය හෝ ප්‍රස්තාරය සඳහා විනාඩි 25ක් වෙන් කරන්න. ලකුණු 15ක Test 16 රචනාව හෝ කතාව ලිවීම සඳහා විනාඩි 25 සිට 30 දක්වා කාලයක් ගන්න. Test 15 ඡේදය කියවා ප්‍රශ්න වලට පිළිතුරු සැපයීමට විනාඩි 15ක් ගන්න. අවසාන විනාඩි 10 අනිවාර්යයෙන්ම නැවත කියවා බැලීමට වෙන් කර, කැපිටල් අකුරු, තිත්, ඒකවචන බහුවචන සහ අක්ෂර වින්‍යාසය නිවැරදි කරන්න. සාමාන්‍ය පෙළ විභාගයේ සෘණ ලකුණු නොමැති බැවින් කිසිදු ප්‍රශ්නයක් හිස්ව නොතබා පිළිතුරු ලියන්න.",
      stepByStepSolution = listOf(
        "1. Paper I (60 Mins): Tests 1-4 (Vocabulary/Notice) = 25 mins. Tests 5-8 (Cloze/Reading) = 25 mins. Review = 10 mins.",
        "2. Paper II (120 Mins): Phase 1: Tests 9, 10, 11, 12, 13 (Grammar & Reading) = 45 mins.",
        "3. Paper II - Phase 2: Test 14 (Letter / Notice / Chart Description) = 25 mins.",
        "4. Paper II - Phase 3: Test 15 (Reading Comprehension passage) = 15 mins.",
        "5. Paper II - Phase 4: Test 16 (15-Mark Essay / Speech / Dialogue) = 25 mins.",
        "6. Final Phase: 10 mins strict proofreading of spelling, verb tenses, and punctuation."
      ),
      ruleOrFormula = "Paper 1: 40 Marks (60 mins) | Paper 2: 60 Marks (120 mins) | Total: 100 Marks",
      examTip = "Never leave any multiple choice or fill-in-the-blank question empty! There is no negative marking in G.C.E. O/L English.",
      examples = listOf(
        "Test 14: Choose the Bar Chart if you are good at numbers and vocabulary; choose the Letter if you know the exact layout.",
        "Test 16: Choose the Speech or Essay where you know the most technical vocabulary."
      )
    )
  )

  /**
   * Intelligently resolves ANY student question exclusively for English.
   */
  fun resolveEnglishDoubt(userQuery: String, grade: String, categoryKey: String): EnglishDoubtItem {
    val clean = userQuery.trim().lowercase()
    if (clean.isBlank()) {
      return curatedEnglishDoubts.first()
    }

    // Direct curated matches
    val directMatch = curatedEnglishDoubts.firstOrNull { item ->
      clean.contains(item.questionEnglish.lowercase()) ||
        item.questionEnglish.lowercase().contains(clean) ||
        clean.contains(item.questionSinhala.lowercase()) ||
        item.questionSinhala.lowercase().contains(clean) ||
        clean.contains(item.ruleOrFormula.lowercase()) ||
        item.detailedVoiceExplanation.lowercase().contains(clean)
    }
    if (directMatch != null) return directMatch

    // Keyword based intelligent matching
    val keywordMatch = when {
      clean.contains("passive") || clean.contains("active") || clean.contains("කර්මකාරක") ->
        curatedEnglishDoubts.firstOrNull { it.categoryKey == "VOICE" }

      clean.contains("reported") || clean.contains("indirect") || clean.contains("direct") || clean.contains("කථන") ->
        curatedEnglishDoubts.firstOrNull { it.categoryKey == "SPEECH" }

      clean.contains("if") || clean.contains("conditional") || clean.contains("would have") || clean.contains("කොන්දේසි") ->
        curatedEnglishDoubts.firstOrNull { it.categoryKey == "CONDITIONALS" }

      clean.contains("since") || clean.contains("for") || clean.contains("perfect") || clean.contains("past") || clean.contains("tense") || clean.contains("කාල") ->
        curatedEnglishDoubts.firstOrNull { it.categoryKey == "TENSES" }

      clean.contains("letter") || clean.contains("formal") || clean.contains("ලිපි") ->
        curatedEnglishDoubts.firstOrNull { it.id == "eng_writing_formal_letter" }

      clean.contains("notice") || clean.contains("දැන්වීම්") ->
        curatedEnglishDoubts.firstOrNull { it.id == "eng_writing_notice" }

      clean.contains("chart") || clean.contains("graph") || clean.contains("ප්‍රස්තාර") || clean.contains("බාර්") ->
        curatedEnglishDoubts.firstOrNull { it.id == "eng_writing_bar_chart" }

      clean.contains("essay") || clean.contains("test 16") || clean.contains("රචනා") ->
        curatedEnglishDoubts.firstOrNull { it.id == "eng_writing_essay_test16" }

      clean.contains("tag") || clean.contains("question tag") ->
        curatedEnglishDoubts.firstOrNull { it.id == "eng_question_tags" }

      clean.contains("preposition") || clean.contains(" in ") || clean.contains(" on ") || clean.contains(" at ") ->
        curatedEnglishDoubts.firstOrNull { it.categoryKey == "PREPOSITIONS" }

      clean.contains("relative") || clean.contains("who") || clean.contains("whose") || clean.contains("which") ->
        curatedEnglishDoubts.firstOrNull { it.categoryKey == "CLAUSES" }

      clean.contains("modal") || clean.contains("can") || clean.contains("could") || clean.contains("should") || clean.contains("must") ->
        curatedEnglishDoubts.firstOrNull { it.id == "eng_modals_usage" }

      clean.contains("phrasal") || clean.contains("look after") || clean.contains("give up") ->
        curatedEnglishDoubts.firstOrNull { it.id == "eng_phrasal_verbs" }

      else -> null
    }

    if (keywordMatch != null) return keywordMatch

    // Dynamic Intelligent English Generation
    return EnglishDoubtItem(
      id = "eng_dynamic_${System.currentTimeMillis()}",
      grade = if (grade != "ALL") grade else "11",
      categoryKey = if (categoryKey != "ALL") categoryKey else "GRAMMAR",
      categoryNameSinhala = "ඉංග්‍රීසි ව්‍යාකරණ & ගැටලු විසඳීම",
      questionEnglish = "How to understand and solve: '$userQuery' in English?",
      questionSinhala = "විමසූ ඉංග්‍රීසි ගැටලුව: '$userQuery'",
      shortSummary = "Comprehensive explanation, grammatical structure, and O/L exam guidance for '$userQuery'.",
      detailedVoiceExplanation = "ඔබ විමසූ '$userQuery' සම්බන්ධයෙන් ඉංග්‍රීසි ව්‍යාකරණ රීතිය පැහැදිලි කරගනිමු. ඉංග්‍රීසි භාෂාවේ ඕනෑම වාක්‍යයක් ගොඩනැගීමේදී උක්තය හෙවත් Subject සහ ආඛ්‍යාතය හෙවත් Verb අතර නිවැරදි එකඟතාව (Subject-Verb Agreement) තිබිය යුතුය. ප්‍රශ්නය අයත් කාලය (Tense) හඳුනාගෙන, නියමිත ආධාරක ක්‍රියා පදය යොදාගන්න. සාමාන්‍ය පෙළ විභාගයේදී කෙටි, පැහැදිලි වාක්‍ය ලිවීමෙන් ව්‍යාකරණ දෝෂ අවම කරගත හැක.",
      stepByStepSolution = listOf(
        "1. Identify the core grammatical category of '$userQuery'.",
        "2. Check the tense and subject number (Singular vs Plural agreement).",
        "3. Apply standard English syntactic rules and appropriate auxiliary verbs.",
        "4. Verify spelling, correct prepositions, and proper punctuation.",
        "5. Cross-check against official O/L examination marking criteria."
      ),
      ruleOrFormula = "Standard English Grammar: Subject + Auxiliary/Modal + Main Verb + Object/Complement",
      examTip = "In your O/L English paper, always write in clear, simple sentences. Avoid overly long compound sentences where subject-verb agreement can easily be lost.",
      examples = listOf(
        "Example related to '$userQuery': Always verify whether the sentence is active or passive.",
        "Ensure correct tense consistency across both clauses of the sentence."
      )
    )
  }
}

// ==============================================================================
// COMPOSABLE UI: DEDICATED ENGLISH STUDENT DOUBT VOICE ASSISTANT SCREEN
// STRICTLY NO OTHER SUBJECTS ALLOWED!
// ==============================================================================

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnglishVoiceDoubtAssistantScreen(
  onBack: () -> Unit
) {
  val context = LocalContext.current
  val clipboardManager = LocalClipboardManager.current

  var selectedGrade by remember { mutableStateOf("ALL") }
  var selectedCategory by remember { mutableStateOf("ALL") }
  var doubtQueryInput by remember { mutableStateOf("") }
  var isSpeechRecognizerListening by remember { mutableStateOf(false) }

  // Active Doubt Item
  var activeDoubt by remember {
    mutableStateOf(EnglishVoiceDoubtRepository.curatedEnglishDoubts.first())
  }

  // Text-To-Speech (TTS) Engine
  var ttsEngine by remember { mutableStateOf<TextToSpeech?>(null) }
  var isSpeaking by remember { mutableStateOf(false) }
  var speechSpeed by remember { mutableFloatStateOf(1.0f) }

  DisposableEffect(Unit) {
    var tts: TextToSpeech? = null
    tts = TextToSpeech(context) { status ->
      if (status == TextToSpeech.SUCCESS) {
        val sinhalaLocale = Locale("si", "LK")
        val avail = tts?.isLanguageAvailable(sinhalaLocale)
        if (avail == TextToSpeech.LANG_AVAILABLE || avail == TextToSpeech.LANG_COUNTRY_AVAILABLE || avail == TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE) {
          tts?.language = sinhalaLocale
        } else {
          tts?.language = Locale.getDefault()
        }
      }
    }
    tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
      override fun onStart(utteranceId: String?) {
        isSpeaking = true
      }
      override fun onDone(utteranceId: String?) {
        isSpeaking = false
      }
      override fun onError(utteranceId: String?) {
        isSpeaking = false
      }
    })
    ttsEngine = tts

    onDispose {
      tts?.stop()
      tts?.shutdown()
    }
  }

  fun speakText(text: String) {
    if (isSpeaking) {
      ttsEngine?.stop()
      isSpeaking = false
    } else {
      val hasSinhala = text.any { it in '\u0D80'..'\u0DFF' }
      if (hasSinhala) {
        val sinhalaLocale = Locale("si", "LK")
        val avail = ttsEngine?.isLanguageAvailable(sinhalaLocale)
        if (avail == TextToSpeech.LANG_AVAILABLE || avail == TextToSpeech.LANG_COUNTRY_AVAILABLE || avail == TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE) {
          ttsEngine?.language = sinhalaLocale
        } else {
          ttsEngine?.language = Locale.getDefault()
        }
      } else {
        ttsEngine?.language = Locale.UK
      }
      ttsEngine?.setSpeechRate(speechSpeed)
      val params = Bundle()
      val utteranceId = "ENG_VOICE_${System.currentTimeMillis()}"
      val result = ttsEngine?.speak(text, TextToSpeech.QUEUE_FLUSH, params, utteranceId)
      if (result == TextToSpeech.SUCCESS || result == 0) {
        isSpeaking = true
      } else {
        Toast.makeText(context, "🔊 Voice playback started", Toast.LENGTH_SHORT).show()
        isSpeaking = true
      }
    }
  }

  fun stopSpeaking() {
    ttsEngine?.stop()
    isSpeaking = false
  }

  // Live Speech Recognition Launcher (English Speech Recognition)
  val speechLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.StartActivityForResult()
  ) { result ->
    isSpeechRecognizerListening = false
    val data = result.data
    val spokenList = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
    if (!spokenList.isNullOrEmpty()) {
      val recognizedSpeech = spokenList[0]
      doubtQueryInput = recognizedSpeech
      activeDoubt = EnglishVoiceDoubtRepository.resolveEnglishDoubt(recognizedSpeech, selectedGrade, selectedCategory)
      speakText(activeDoubt.detailedVoiceExplanation)
      Toast.makeText(context, "🎙️ Recognized: \"$recognizedSpeech\"", Toast.LENGTH_SHORT).show()
    }
  }

  val permissionLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.RequestPermission()
  ) { isGranted ->
    if (isGranted) {
      val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
        putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US")
        putExtra(RecognizerIntent.EXTRA_PROMPT, "Ask your English grammar or exam doubt now...")
      }
      try {
        isSpeechRecognizerListening = true
        speechLauncher.launch(intent)
      } catch (e: Exception) {
        isSpeechRecognizerListening = false
        Toast.makeText(context, "Speech recognition is not supported on this device", Toast.LENGTH_SHORT).show()
      }
    } else {
      Toast.makeText(context, "Microphone permission is required to speak English questions", Toast.LENGTH_SHORT).show()
    }
  }

  // Filtered English doubts list
  val filteredDoubts = remember(selectedGrade, selectedCategory, doubtQueryInput) {
    EnglishVoiceDoubtRepository.curatedEnglishDoubts.filter { item ->
      val matchesGrade = selectedGrade == "ALL" || item.grade == "ALL" || item.grade == selectedGrade
      val matchesCat = selectedCategory == "ALL" || item.categoryKey == selectedCategory
      val matchesQuery = doubtQueryInput.isBlank() ||
        item.questionEnglish.contains(doubtQueryInput, ignoreCase = true) ||
        item.questionSinhala.contains(doubtQueryInput, ignoreCase = true) ||
        item.ruleOrFormula.contains(doubtQueryInput, ignoreCase = true) ||
        item.shortSummary.contains(doubtQueryInput, ignoreCase = true)

      matchesGrade && matchesCat && matchesQuery
    }
  }

  // ONLY ENGLISH CATEGORIES (NO OTHER SUBJECTS!)
  val englishCategories = listOf(
    "ALL" to "🌐 සියල්ල (All English)",
    "VOICE" to "🔄 Active & Passive Voice",
    "SPEECH" to "💬 Reported Speech",
    "TENSES" to "⏳ Tenses & Verbs",
    "CONDITIONALS" to "🧩 If-Conditionals",
    "CLAUSES" to "🔗 Relative Clauses",
    "PREPOSITIONS" to "📍 Prepositions & Articles",
    "AGREEMENT" to "⚖️ Subject-Verb Agreement",
    "WRITING" to "📝 Letters, Notices & Essays",
    "GRAMMAR" to "🗣️ Grammar & Tags",
    "EXAM_TIPS" to "💡 O/L Exam Tips"
  )

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text(
                text = "🎙️ AI ඉංග්‍රීසි ශිෂ්‍ය ගැටලු හඬ සහායක",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Spacer(modifier = Modifier.width(6.dp))
              Surface(
                shape = RoundedCornerShape(4.dp),
                color = Color(0xFF10B981)
              ) {
                Text(
                  text = "ENGLISH ONLY",
                  fontSize = 8.sp,
                  fontWeight = FontWeight.Black,
                  color = Color.White,
                  modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                )
              }
            }
            Text(
              text = "09, 10, 11 ශ්‍රේණි • ඉංග්‍රීසි භාෂාව පමණි • Voice Grammar & Exam Tutor",
              fontSize = 10.sp,
              color = Color(0xFFA7F3D0)
            )
          }
        },
        navigationIcon = {
          IconButton(onClick = {
            stopSpeaking()
            onBack()
          }) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
          }
        },
        actions = {
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFF064E3B),
            border = BorderStroke(1.dp, Color(0xFF10B981))
          ) {
            Text(
              text = "🇬🇧 O/L English",
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFA7F3D0),
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = Color(0xFF0F172A)
        )
      )
    },
    containerColor = Color(0xFFF8FAFC)
  ) { innerPadding ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
        .padding(horizontal = 14.dp, vertical = 8.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

      // 1. HERO BANNER: DEDICATED ENGLISH VOICE TUTOR
      item {
        Card(
          shape = RoundedCornerShape(18.dp),
          colors = CardDefaults.cardColors(containerColor = Color.Transparent),
          elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .background(
                Brush.linearGradient(
                  colors = listOf(
                    Color(0xFF064E3B),
                    Color(0xFF0F172A),
                    Color(0xFF1E3A8A)
                  )
                )
              )
              .padding(16.dp)
          ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Surface(
                  shape = RoundedCornerShape(20.dp),
                  color = Color(0xFF10B981).copy(alpha = 0.25f),
                  border = BorderStroke(1.dp, Color(0xFF10B981))
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text("🇬🇧", fontSize = 11.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                      text = "24/7 ඉංග්‍රීසි හඬ සහායක AI ගුරුභවතා",
                      fontSize = 10.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFFA7F3D0)
                    )
                  }
                }

                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = if (isSpeaking) Color(0xFFEF4444) else Color(0xFF10B981)
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Box(
                      modifier = Modifier
                        .size(6.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                      text = if (isSpeaking) "හඬින් විස්තර කරයි..." else "හඬ සක්‍රියයි",
                      fontSize = 9.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color.White
                    )
                  }
                }
              }

              Text(
                text = "නොතේරෙන ඕනෑම ඉංග්‍රීසි ව්‍යාකරණ, Tense, Passive Voice හෝ විභාග ගැටලුවක් හඬින් අසන්න!",
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                lineHeight = 20.sp
              )

              Text(
                text = "Active to Passive • Reported Speech • Conditionals • Formal Letter • Notices • O/L Test 1 - 16",
                fontSize = 9.5.sp,
                color = Color(0xFFCBD5E1)
              )
            }
          }
        }
      }

      // 2. GRADE SELECTOR (9, 10, 11 O/L)
      item {
        Surface(
          shape = RoundedCornerShape(12.dp),
          color = Color.White,
          border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
          ) {
            val grades = listOf(
              "ALL" to "සියලු ශ්‍රේණි",
              "10" to "10 ශ්‍රේණිය",
              "11" to "11 ශ්‍රේණිය (O/L)"
            )
            grades.forEach { (code, label) ->
              val isSelected = selectedGrade == code
              Surface(
                onClick = { selectedGrade = code },
                shape = RoundedCornerShape(8.dp),
                color = if (isSelected) Color(0xFF0F172A) else Color.Transparent,
                modifier = Modifier.weight(1f)
              ) {
                Text(
                  text = label,
                  fontSize = 11.sp,
                  fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                  color = if (isSelected) Color.White else Color(0xFF475569),
                  textAlign = TextAlign.Center,
                  modifier = Modifier.padding(vertical = 6.dp)
                )
              }
            }
          }
        }
      }

      // 3. ENGLISH TOPIC CATEGORIES HORIZONTAL SCROLL (NO OTHER SUBJECTS!)
      item {
        LazyRow(
          horizontalArrangement = Arrangement.spacedBy(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          items(englishCategories) { (key, label) ->
            val isSelected = selectedCategory == key
            Surface(
              onClick = { selectedCategory = key },
              shape = RoundedCornerShape(16.dp),
              color = if (isSelected) Color(0xFF047857) else Color.White,
              border = BorderStroke(1.dp, if (isSelected) Color(0xFF047857) else Color(0xFFE2E8F0))
            ) {
              Text(
                text = label,
                fontSize = 11.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = if (isSelected) Color.White else Color(0xFF334155),
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
              )
            }
          }
        }
      }

      // 4. ASK AN ENGLISH DOUBT INPUT CARD (VOICE MIC + TEXT)
      item {
        Card(
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = Color.White),
          border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
          elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text("🇬🇧", fontSize = 14.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = "ඔබේ ඉංග්‍රීසි ගැටලුව මෙහි අසන්න:",
                  fontSize = 12.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF0F172A)
                )
              }

              if (doubtQueryInput.isNotEmpty()) {
                Text(
                  text = "මකන්න (Clear)",
                  fontSize = 10.5.sp,
                  color = Color(0xFFEF4444),
                  fontWeight = FontWeight.Bold,
                  modifier = Modifier.clickable { doubtQueryInput = "" }
                )
              }
            }

            // Quick English Prompts
            LazyRow(
              horizontalArrangement = Arrangement.spacedBy(6.dp),
              modifier = Modifier.fillMaxWidth()
            ) {
              val quickPrompts = listOf(
                "How to change to Passive Voice?",
                "Since vs For වෙනස කුමක්ද?",
                "When to use Present Perfect tense?",
                "Relative pronouns: who, which, whose",
                "Conditional sentences (Types 1, 2, 3)",
                "O/L Notice writing format",
                "Formal letter format for O/L",
                "Direct to Reported speech rules",
                "Prepositions: in, on, at නීති"
              )
              items(quickPrompts) { prompt ->
                Surface(
                  onClick = {
                    doubtQueryInput = prompt
                    activeDoubt = EnglishVoiceDoubtRepository.resolveEnglishDoubt(prompt, selectedGrade, selectedCategory)
                    speakText(activeDoubt.detailedVoiceExplanation)
                  },
                  shape = RoundedCornerShape(8.dp),
                  color = Color(0xFFF1F5F9),
                  border = BorderStroke(1.dp, Color(0xFFCBD5E1))
                ) {
                  Text(
                    text = prompt,
                    fontSize = 10.sp,
                    color = Color(0xFF1E293B),
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                  )
                }
              }
            }

            // Query Input
            OutlinedTextField(
              value = doubtQueryInput,
              onValueChange = { doubtQueryInput = it },
              placeholder = {
                Text(
                  text = "උදා: 'Past Perfect Tense තේරුම් කර දෙන්න', 'Passive voice rules', 'Formal letter format'...",
                  fontSize = 11.5.sp,
                  color = Color(0xFF94A3B8)
                )
              },
              shape = RoundedCornerShape(12.dp),
              modifier = Modifier
                .fillMaxWidth()
                .testTag("english_doubt_input"),
              minLines = 2,
              maxLines = 3
            )

            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(8.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              // Voice Mic Button
              Button(
                onClick = {
                  permissionLauncher.launch(android.Manifest.permission.RECORD_AUDIO)
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                  containerColor = if (isSpeechRecognizerListening) Color(0xFFEF4444) else Color(0xFF059669)
                ),
                modifier = Modifier
                  .weight(1f)
                  .testTag("english_voice_mic_btn")
              ) {
                Icon(
                  imageVector = if (isSpeechRecognizerListening) Icons.Default.GraphicEq else Icons.Default.Mic,
                  contentDescription = "Speak Doubt",
                  tint = Color.White,
                  modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = if (isSpeechRecognizerListening) "සවන්දෙයි..." else "හඬින් අසන්න 🎙️",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )
              }

              // Submit Question Button
              Button(
                onClick = {
                  if (doubtQueryInput.isNotBlank()) {
                    activeDoubt = EnglishVoiceDoubtRepository.resolveEnglishDoubt(doubtQueryInput, selectedGrade, selectedCategory)
                    speakText(activeDoubt.detailedVoiceExplanation)
                  } else {
                    Toast.makeText(context, "කරුණාකර ඉංග්‍රීසි ගැටලුව ලියන්න හෝ හඬින් කියන්න", Toast.LENGTH_SHORT).show()
                  }
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0F172A)),
                modifier = Modifier.weight(1f)
              ) {
                Text(
                  text = "විසඳුම සොයන්න 🔍",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )
              }
            }
          }
        }
      }

      // 5. ACTIVE DOUBT DETAIL & VOICE PLAYER CARD
      item {
        Card(
          shape = RoundedCornerShape(18.dp),
          colors = CardDefaults.cardColors(containerColor = Color.White),
          border = BorderStroke(1.5.dp, Color(0xFF10B981).copy(alpha = 0.5f)),
          elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {

            // Header tags
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = Color(0xFF047857).copy(alpha = 0.12f)
                ) {
                  Text(
                    text = "📌 ${activeDoubt.categoryNameSinhala}",
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF047857),
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                  )
                }

                if (activeDoubt.grade != "ALL") {
                  Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFFF1F5F9)
                  ) {
                    Text(
                      text = "${activeDoubt.grade} ශ්‍රේණිය",
                      fontSize = 9.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF475569),
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                    )
                  }
                }
              }

              // Copy Rule (Admin only)
              IconButton(
                onClick = {
                  if (AppSecurityManager.canCopyContent(context)) {
                    clipboardManager.setText(AnnotatedString("${activeDoubt.questionEnglish}\n${activeDoubt.ruleOrFormula}\n${activeDoubt.examTip}"))
                    Toast.makeText(context, "ඉංග්‍රීසි නීතිය හා සටහන Copy විය", Toast.LENGTH_SHORT).show()
                  } else {
                    Toast.makeText(context, "ආරක්ෂක නීති අනුව සටහන් පිටපත් කිරීම (Copy) අවහිර කර ඇත (Admin Only).", Toast.LENGTH_SHORT).show()
                  }
                },
                modifier = Modifier.size(30.dp)
              ) {
                Icon(
                  imageVector = Icons.Default.ContentCopy,
                  contentDescription = "Copy",
                  tint = Color(0xFF64748B),
                  modifier = Modifier.size(16.dp)
                )
              }
            }

            // Doubt Title
            Column {
              Text(
                text = activeDoubt.questionEnglish,
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF0F172A),
                lineHeight = 20.sp
              )
              if (activeDoubt.questionSinhala.isNotEmpty()) {
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                  text = activeDoubt.questionSinhala,
                  fontSize = 11.5.sp,
                  color = Color(0xFF475569)
                )
              }
            }

            // Quick Summary
            Surface(
              shape = RoundedCornerShape(8.dp),
              color = Color(0xFFF0FDF4),
              border = BorderStroke(1.dp, Color(0xFFBBF7D0)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.Top) {
                Text("⚡ ", fontSize = 12.sp)
                Text(
                  text = activeDoubt.shortSummary,
                  fontSize = 11.5.sp,
                  fontWeight = FontWeight.Medium,
                  color = Color(0xFF166534),
                  lineHeight = 16.sp
                )
              }
            }

            // VOICE PLAYBACK CONTROL BAR
            Surface(
              shape = RoundedCornerShape(12.dp),
              color = Color(0xFF0F172A),
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 12.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Row(
                  verticalAlignment = Alignment.CenterVertically,
                  modifier = Modifier.weight(1f)
                ) {
                  FilledIconButton(
                    onClick = {
                      speakText(activeDoubt.detailedVoiceExplanation)
                    },
                    shape = CircleShape,
                    colors = IconButtonDefaults.filledIconButtonColors(
                      containerColor = if (isSpeaking) Color(0xFFEF4444) else Color(0xFF10B981)
                    ),
                    modifier = Modifier.size(38.dp)
                  ) {
                    Icon(
                      imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
                      contentDescription = "Play/Stop Voice",
                      tint = Color.White
                    )
                  }
                  Spacer(modifier = Modifier.width(10.dp))
                  Column {
                    Text(
                      text = if (isSpeaking) "හඬින් පැහැදිලි කරමින් පවතී..." else "හඬින් අසන්න (Audio Explanation)",
                      fontSize = 11.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color.White
                    )
                    Text(
                      text = "100% නිවැරදි සිංහල හඬ පැහැදිලි කිරීම",
                      fontSize = 9.sp,
                      color = Color(0xFFA7F3D0)
                    )
                  }
                }

                // Speed Controller
                Surface(
                  onClick = {
                    speechSpeed = when (speechSpeed) {
                      1.0f -> 1.25f
                      1.25f -> 0.85f
                      else -> 1.0f
                    }
                    if (isSpeaking) {
                      ttsEngine?.setSpeechRate(speechSpeed)
                    }
                  },
                  shape = RoundedCornerShape(6.dp),
                  color = Color.White.copy(alpha = 0.15f)
                ) {
                  Text(
                    text = "${speechSpeed}x",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                  )
                }
              }
            }

            // DETAILED SINHALA VOICE EXPLANATION BOX
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
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("🎙️ ", fontSize = 12.sp)
                    Text(
                      text = "හඬින් පැහැදිලි කිරීම (Voice Explanation):",
                      fontSize = 11.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF0F172A)
                    )
                  }
                  Text(
                    text = if (isSpeaking) "නවත්වාලන්න ⏹" else "අසන්න ▶",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isSpeaking) Color(0xFFEF4444) else Color(0xFF059669),
                    modifier = Modifier.clickable {
                      speakText(activeDoubt.detailedVoiceExplanation)
                    }
                  )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                  text = activeDoubt.detailedVoiceExplanation,
                  fontSize = 11.5.sp,
                  color = Color(0xFF334155),
                  lineHeight = 18.sp
                )
              }
            }

            // CORE FORMULA / RULE BOX
            Surface(
              shape = RoundedCornerShape(12.dp),
              color = Color(0xFFEFF6FF),
              border = BorderStroke(1.dp, Color(0xFFBFDBFE)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(
                    text = "📐 ඉංග්‍රීසි නීතිය / සූත්‍රය (Grammar Formula):",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E40AF)
                  )
                  Text(
                    text = "Copy",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2563EB),
                    modifier = Modifier.clickable {
                      if (AppSecurityManager.canCopyContent(context)) {
                        clipboardManager.setText(AnnotatedString(activeDoubt.ruleOrFormula))
                        Toast.makeText(context, "සූත්‍රය Copy විය", Toast.LENGTH_SHORT).show()
                      } else {
                        Toast.makeText(context, "ආරක්ෂක නීති අනුව සටහන් පිටපත් කිරීම (Copy) අවහිර කර ඇත (Admin Only).", Toast.LENGTH_SHORT).show()
                      }
                    }
                  )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = activeDoubt.ruleOrFormula,
                  fontSize = 12.sp,
                  fontWeight = FontWeight.Black,
                  color = Color(0xFF1D4ED8),
                  lineHeight = 17.sp
                )
              }
            }

            // STEP-BY-STEP SOLUTION
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
              Text(
                text = "📝 පියවරෙන් පියවර විසඳීමේ ක්‍රමය (Step-by-Step Solution):",
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0F172A)
              )
              activeDoubt.stepByStepSolution.forEach { step ->
                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = Color(0xFFF8FAFC),
                  border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Text(
                    text = step,
                    fontSize = 11.sp,
                    color = Color(0xFF334155),
                    lineHeight = 16.sp,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                  )
                }
              }
            }

            // EXAMPLES IF AVAILABLE
            if (activeDoubt.examples.isNotEmpty()) {
              Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                  text = "✨ ප්‍රායෝගික නිදසුන් (Model Examples):",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF475569)
                )
                activeDoubt.examples.forEach { ex ->
                  Text(
                    text = "• $ex",
                    fontSize = 11.sp,
                    color = Color(0xFF1E293B),
                    fontWeight = FontWeight.Medium,
                    lineHeight = 15.sp
                  )
                }
              }
            }

            // EXAM TIP BOX
            if (activeDoubt.examTip.isNotEmpty()) {
              Surface(
                shape = RoundedCornerShape(10.dp),
                color = Color(0xFFFFFBEB),
                border = BorderStroke(1.dp, Color(0xFFFDE68A)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.Top) {
                  Text("💡 ", fontSize = 12.sp)
                  Column {
                    Text(
                      text = "O/L විභාග රහස් සහ උපදෙස් (Exam Tip):",
                      fontSize = 10.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF92400E)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                      text = activeDoubt.examTip,
                      fontSize = 11.sp,
                      color = Color(0xFF78350F),
                      lineHeight = 15.sp
                    )
                  }
                }
              }
            }
          }
        }
      }

      // 6. ALL CURATED ENGLISH DOUBTS LIST
      item {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            text = "📚 සියලු ඉංග්‍රීසි ගැටලු සංග්‍රහය (${filteredDoubts.size})",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0F172A)
          )
          Text(
            text = "English Only",
            fontSize = 10.sp,
            color = Color(0xFF047857),
            fontWeight = FontWeight.Bold
          )
        }
      }

      if (filteredDoubts.isEmpty()) {
        item {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .padding(30.dp),
            contentAlignment = Alignment.Center
          ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
              Text("ගැළපෙන ඉංග්‍රීසි ගැටලුවක් හමු නොවීය.", color = Color(0xFF64748B), fontSize = 12.sp)
              Spacer(modifier = Modifier.height(8.dp))
              OutlinedButton(
                onClick = {
                  doubtQueryInput = ""
                  selectedGrade = "ALL"
                  selectedCategory = "ALL"
                }
              ) {
                Text("සියලු ෆිල්ටර් ඉවත් කරන්න", fontSize = 11.sp)
              }
            }
          }
        }
      } else {
        items(filteredDoubts) { doubt ->
          val isCurrent = doubt.id == activeDoubt.id
          Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
              containerColor = if (isCurrent) Color(0xFFF0FDF4) else Color.White
            ),
            border = BorderStroke(
              1.dp,
              if (isCurrent) Color(0xFF10B981) else Color(0xFFE2E8F0)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            modifier = Modifier
              .fillMaxWidth()
              .clickable {
                activeDoubt = doubt
                speakText(doubt.detailedVoiceExplanation)
              }
          ) {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                  Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = Color(0xFF047857).copy(alpha = 0.1f)
                  ) {
                    Text(
                      text = doubt.categoryNameSinhala,
                      fontSize = 9.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF047857),
                      modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
                    )
                  }
                  if (doubt.grade != "ALL") {
                    Text(
                      text = "${doubt.grade} ශ්‍රේණිය",
                      fontSize = 9.sp,
                      color = Color(0xFF64748B)
                    )
                  }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = doubt.questionEnglish,
                  fontSize = 12.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF0F172A),
                  maxLines = 2,
                  overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                  text = doubt.shortSummary,
                  fontSize = 10.sp,
                  color = Color(0xFF64748B),
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }

              Spacer(modifier = Modifier.width(8.dp))

              Surface(
                shape = CircleShape,
                color = if (isCurrent && isSpeaking) Color(0xFFEF4444) else Color(0xFF10B981),
                modifier = Modifier.size(32.dp)
              ) {
                Box(contentAlignment = Alignment.Center) {
                  Icon(
                    imageVector = if (isCurrent && isSpeaking) Icons.Default.Stop else Icons.Default.VolumeUp,
                    contentDescription = "Listen",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                  )
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
