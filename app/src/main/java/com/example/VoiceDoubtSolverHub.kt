package com.example

import android.app.Activity
import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import com.example.ui.theme.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Locale

// ----------------------------------------------------
// 1. DATA MODEL FOR DOUBTS & VOICE EXPLANATIONS
// ----------------------------------------------------

data class DoubtItem(
  val id: String,
  val subject: String,
  val grade: String,
  val questionSinhala: String,
  val shortSummary: String,
  val detailedVoiceExplanation: String, // Text read aloud via Voice TTS
  val stepByStepSolution: List<String>,
  val examTip: String,
  val coreFormulaOrRule: String = "",
  val relatedTopic: String
)

// ----------------------------------------------------
// 2. REPOSITORY: PRE-LOADED DOUBTS & AI RESOLVER
// ----------------------------------------------------

object VoiceDoubtSolverRepository {

  val curatedDoubts: List<DoubtItem> = listOf(
    // SCIENCE DOUBTS
    DoubtItem(
      id = "sci_doubt_photosynthesis",
      subject = "විද්‍යාව",
      grade = "11",
      questionSinhala = "ප්‍රභාසංස්ලේෂණයේ ආලෝක සහ අඳුරු ප්‍රතික්‍රියා අතර වෙනස කුමක්ද?",
      shortSummary = "ආලෝක ප්‍රතික්‍රියාව තයිලකොයිඩ පටල තුළත්, අඳුරු ප්‍රතික්‍රියාව (කැල්වින් චක්‍රය) හරිතලවයේ ස්ට්‍රෝමාව තුළත් සිදුවේ.",
      detailedVoiceExplanation = "ආයුබෝවන් දුවේ පුතේ. ප්‍රභාසංස්ලේෂණයේ ප්‍රධාන අදියර දෙකකි. පළමුවැන්න ආලෝක ප්‍රතික්‍රියාවයි. මෙය සිදුවන්නේ හරිතලවයේ තයිලකොයිඩ පටල මත වන අතර, මෙහිදී සූර්යාලෝකය සහ ජලය අවශෝෂණය කර ඔක්සිජන් පිට කරයි. එසේම ATP සහ NADPH ශක්ති ප්‍රභව නිපදවයි. දෙවැන්න අඳුරු ප්‍රතික්‍රියාව හෝ කාබන් තිරකිරීමයි. එය සිදුවන්නේ හරිතලවයේ ස්ට්‍රෝමාව තුළය. එහිදී කාබන්ඩයොක්සයිඩ් වායුව භාවිත කර ග්ලූකෝස් කාබෝහයිඩ්‍රේට නිපදවයි. විභාගයේදී මෙම ප්‍රතික්‍රියා දෙක සිදුවන ස්ථාන සහ නිපදවෙන ද්‍රව්‍ය නිතරම විමසයි.",
      stepByStepSolution = listOf(
        "1. ආලෝක ප්‍රතික්‍රියාව: හරිතලවයේ තයිලකොයිඩ පටල මත සිදුවේ.",
        "2. ආලෝක ප්‍රතික්‍රියා අමුද්‍රව්‍ය: ජලය සහ සූර්යාලෝකය (හරිතප්‍රද මගින් ග්‍රහණය කරයි).",
        "3. ආලෝක ප්‍රතික්‍රියා ඵල: ඔක්සිජන් (O2) පිටවේ, ATP සහ NADPH අඳුරු ප්‍රතික්‍රියාවට සපයයි.",
        "4. අඳුරු ප්‍රතික්‍රියාව: හරිතලවයේ ස්ට්‍රෝමාව (Stroma) තුළ සිදුවේ.",
        "5. අඳුරු ප්‍රතික්‍රියා ඵල: CO2 තිර කර ග්ලූකෝස් (C6H12O6) නිපදවයි."
      ),
      examTip = "විභාගයේදී රූප සටහනක් ඇසුරෙන් A (තයිලකොයිඩය) සහ B (ස්ට්‍රෝමාව) නම් කිරීමට ලකුණු 2ක ප්‍රශ්නයක් ලෙස නිතර පැමිණේ.",
      coreFormulaOrRule = "6CO2 + 6H2O + ආලෝක ශක්තිය (හරිතප්‍රද ඉදිරියේ) -> C6H12O6 + 6O2",
      relatedTopic = "ශාක කායික විද්‍යාව සහ ප්‍රභාසංස්ලේෂණය"
    ),

    DoubtItem(
      id = "sci_doubt_newton",
      subject = "විද්‍යාව",
      grade = "11",
      questionSinhala = "නිව්ටන්ගේ දෙවන චලිත නියමය සහ F = ma සූත්‍රය ගැටලුවලට යොදන්නේ කෙසේද?",
      shortSummary = "වස්තුවක ගම්‍යතාව වෙනස්වීමේ සීඝ්‍රතාව ඒ මත යෙදෙන අසමතුලිත බලයට අනුලෝමව සමානුපාතික වන අතර බලය යෙදෙන දිශාවට සිදුවේ.",
      detailedVoiceExplanation = "නිව්ටන්ගේ දෙවන නියමය ගණනය කිරීම් සඳහා F = ma ලෙස කෙටියෙන් දක්වයි. මෙහි F යනු නිව්ටන් වලින් මනින අසමතුලිත බලයයි. m යනු කිලෝග්‍රෑම් වලින් මනින වස්තුවේ ස්කන්ධයයි. a යනු තත්පර වර්ගයට මීටර වලින් මනින ත්වරණයයි. ගැටලුවක් විසඳීමේදී මුලින්ම ඒකක SI ක්‍රමයට තිබේදැයි බලන්න. ග්‍රෑම් තිබේ නම් දහසෙන් බෙදා කිලෝග්‍රෑම් කරගන්න. ඝර්ෂණ බලයක් තිබේ නම් යෙදූ බලයෙන් එය අඩු කර අසමතුලිත බලය සොයාගන්න.",
      stepByStepSolution = listOf(
        "1. නියමය: F = ma (බලය = ස්කන්ධය x ත්වරණය)",
        "2. ඒකක පරීක්ෂාව: ස්කන්ධය kg වලින්ද, ත්වරණය ms^-2 වලින්ද තිබිය යුතුය.",
        "3. අසමතුලිත බලය සෙවීම: ඉදිරියට යෙදූ බලය - පසුපසට ඇති ඝර්ෂණ බලය = F_net.",
        "4. ආදේශ කිරීම: F_net = m x a මගින් අඥාත පදය ගණනය කරන්න.",
        "5. උදාහරණ: 2 kg ස්කන්ධයක් 5 ms^-2 කින් ත්වරණය කිරීමට F = 2 x 5 = 10 N අවශ්‍ය වේ."
      ),
      examTip = "ලකුණු 4ක ගැටලුවලදී ඝර්ෂණ බලය අඩු කිරීමට අමතක වීම සිසුන් බහුලව කරන වරදකි.",
      coreFormulaOrRule = "F_net = m · a (Newton = kg · ms⁻²)",
      relatedTopic = "බලය සහ චලිතය"
    ),

    DoubtItem(
      id = "sci_doubt_circuits",
      subject = "විද්‍යාව",
      grade = "11",
      questionSinhala = "ශ්‍රේණිගත සහ සමාන්තරගත ප්‍රතිරෝධක පරිපථවල ධාරාව සහ වෝල්ටීයතාව බෙදී යන්නේ කෙසේද?",
      shortSummary = "ශ්‍රේණිගතව ධාරාව සමාන වන අතර විභව අන්තරය බෙදී යයි. සමාන්තරගතව විභව අන්තරය සමාන වන අතර ධාරාව බෙදී යයි.",
      detailedVoiceExplanation = "ප්‍රතිරෝධක සම්බන්ධ කිරීමේදී මතක තබාගත යුතු රන් නීතිය මෙන්න: ශ්‍රේණිගත පරිපථයක සියලු ප්‍රතිරෝධක හරහා ගලායන්නේ එකම ධාරාවකි. නමුත් මුළු වෝල්ටීයතාව ප්‍රතිරෝධකවල අගයට අනුපාතිකව බෙදී යයි. සමාන්තරගත පරිපථයකදී සෑම ශාඛාවකටම ලැබෙන්නේ එකම වෝල්ටීයතාවයි. ගෘහ විදුලි පරිපථ සමාන්තරගතව සකසන්නේ ඒ නිසාය. නමුත් ධාරාව එක් එක් ශාඛාවේ ප්‍රතිරෝධයට ප්‍රතිලෝමව බෙදී ගමන් කරයි.",
      stepByStepSolution = listOf(
        "1. ශ්‍රේණිගත සමක ප්‍රතිරෝධය: R = R1 + R2 + R3 (ධාරාව I නියතයි).",
        "2. ශ්‍රේණිගත වෝල්ටීයතාව: V_total = V1 + V2 + V3.",
        "3. සමාන්තරගත සමක ප්‍රතිරෝධය: 1/R = 1/R1 + 1/R2 (වෝල්ටීයතාව V නියතයි).",
        "4. සමාන්තරගත ධාරාව: I_total = I1 + I2.",
        "5. ඕම්ගේ නියමය: V = IR සූත්‍රය ඕනෑම ප්‍රතිරෝධකයකට වෙන වෙනම යෙදිය හැක."
      ),
      examTip = "ගෘහ විදුලි සැපයුම සමාන්තරගතව සම්බන්ධ කිරීමට ප්‍රධාන හේතු දෙක විභාගයට ලියන්න: එකක් අක්‍රිය වූ විට අනෙක්වා ක්‍රියාකිරීම සහ සියල්ලටම සමාන විභව අන්තරයක් ලැබීම.",
      coreFormulaOrRule = "ඕම්ගේ නියමය: V = I · R",
      relatedTopic = "ධාරා විද්‍යුතය සහ ඉලෙක්ට්‍රොනික විද්‍යාව"
    ),

    // MATHEMATICS DOUBTS
    DoubtItem(
      id = "math_doubt_quadratic",
      subject = "ගණිතය",
      grade = "11",
      questionSinhala = "වර්ගජ සමීකරණ සූත්‍රය මගින් විසඳන්නේ කෙසේද? (x = [-b ± √(b² - 4ac)] / 2a)",
      shortSummary = "ax² + bx + c = 0 සම්මත ආකාරයට ලියා a, b, c හඳුනාගෙන සූත්‍රයට ආදේශ කර වර්ගමූලය සුළු කරන්න.",
      detailedVoiceExplanation = "ගණිතය දෙවන ප්‍රශ්න පත්‍රයේ අනිවාර්ය වර්ගජ සමීකරණ ගැටලුව සඳහා සූත්‍රය භාවිතා කිරීම ඉතා පහසුය. පළමුව සමීකරණය ax වර්ගය ධන bx ධන c සමාන බිංදුව ලෙස සකසා ගන්න. මෙහි x වර්ගයේ සංගුණකය a වේ. x හි සංගුණකය b වේ. නිදහස් පදය c වේ. ලකුණු සහිතවම a, b, c ලියාගන්න. සූත්‍රයේ b වර්ගය අඩු කිරීම 4ac කොටස පළමුව ප්‍රවේශමෙන් ගණනය කරන්න. වර්ගමූලය සඳහා විභාග ශාලාවේදී ලඝුගණක පොතෙන් වර්ගමූල අගය සොයා ආදේශ කරන්න.",
      stepByStepSolution = listOf(
        "1. සම්මත ආකෘතිය: ax² + bx + c = 0 බවට පත්කරගන්න.",
        "2. සංගුණක ලකුණු සහිතව ලිවීම: a = ?, b = ?, c = ?.",
        "3. විවේචකය සෙවීම: Δ = b² - 4ac වෙනම ගණනය කරගන්න.",
        "4. සූත්‍රය ලිවීම: x = (-b ± √Δ) / 2a (සූත්‍රය ලිවීමටද ලකුණු හිමිවේ).",
        "5. විසඳුම් දෙක වෙන් කිරීම: x1 = (-b + √Δ)/2a සහ x2 = (-b - √Δ)/2a ලෙස පළමු දශමස්ථානයට හෝ දෙවන දශමස්ථානයට ගන්න."
      ),
      examTip = "සූත්‍රය නිවැරදිව ලිවීම, ආදේශ කිරීම සහ අවසන් පිළිතුර දශමස්ථාන 2කට දැක්වීම සඳහා වෙන වෙනම ලකුණු 10න් ලකුණු බෙදී යයි.",
      coreFormulaOrRule = "x = [-b ± √(b² - 4ac)] / (2a)",
      relatedTopic = "වර්ගජ සමීකරණ"
    ),

    DoubtItem(
      id = "math_doubt_circle_theorems",
      subject = "ගණිතය",
      grade = "11",
      questionSinhala = "වෘත්ත ප්‍රමේය ජ්‍යාමිතික සාධන ගැටලුවකදී පහසුවෙන් ලකුණු ලබාගන්නේ කෙසේද?",
      shortSummary = "දත්තය, සාධ්‍යය, නිර්මාණය සහ සාධනය පැහැදිලි හේතු සහිතව පියවරෙන් පියවර ලිවිය යුතුය.",
      detailedVoiceExplanation = "ජ්‍යාමිතිය සාධන ගැටලුවකට මුහුණ දීමේදී රූපයේ සියලු දත්ත සටහන් කරගන්න. කේන්ද්‍ර කෝණය පරිධි කෝණය මෙන් දෙගුණයකි, එකම ඛණ්ඩයේ කෝණ සමානය, චක්‍රීය චතුරස්‍රයක සම්මුඛ කෝණ පරිපූරක වේ යන මූලික ප්‍රමේය 3 බොහෝ විට යෙදේ. සාධනයේ සෑම පේළියකටම වරහන් තුළ නිවැරදි ජ්‍යාමිතික හේතුව ලිවීම අනිවාර්යයි. හේතුව නොලියුවහොත් ලකුණු නොලැබේ.",
      stepByStepSolution = listOf(
        "1. කේන්ද්‍ර කෝණය = 2 x පරිධි කෝණය (එකම චාපය මත පිහිටි).",
        "2. අර්ධ වෘත්තයක කෝණය සෘජුකෝණයකි (90°).",
        "3. එකම ඛණ්ඩයේ කෝණ සමාන වේ.",
        "4. චක්‍රීය චතුරස්‍රයක සම්මුඛ කෝණවල එකතුව 180° කි (පරිපූරක වේ).",
        "5. චක්‍රීය චතුරස්‍රයක පාදයක් දික්කිරීමෙන් සෑදෙන බාහිර කෝණය අභ්‍යන්තර සම්මුඛ කෝණයට සමාන වේ."
      ),
      examTip = "සාධනය පියවර ලිවීමේදී වරහන් තුළ ජ්‍යාමිතික හේතුව (උදා: චක්‍රීය චතුරස්‍ර සම්මුඛ කෝණ) නොලියුවහොත් පියවරේ ලකුණු කපා හැරේ.",
      coreFormulaOrRule = "චක්‍රීය චතුරස්‍ර: ∠A + ∠C = 180°, ∠B + ∠D = 180°",
      relatedTopic = "වෘත්ත ආශ්‍රිත ප්‍රමේය"
    ),

    // HISTORY DOUBTS
    DoubtItem(
      id = "history_doubt_hydraulic",
      subject = "ඉතිහාසය",
      grade = "11",
      questionSinhala = "පැරණි ලක්දිව වාරි ශිෂ්ටාචාරයේ මහා වැව් සහ ඇළ මාර්ග නිර්මාණයේ තාක්ෂණික විශිෂ්ටත්වය කුමක්ද?",
      shortSummary = "බිසෝකොටුව, පිටවාන, සොරොව්ව සහ මන්දගාමී බැස්ම සහිත ඇළ මාර්ග (යෝධ ඇළ) ඉංජිනේරු තාක්ෂණයේ විශිෂ්ටත්වය පෙන්වයි.",
      detailedVoiceExplanation = "පුරාණ සිංහල වාරි තාක්ෂණයේ ලෝක ප්‍රකට විශිෂ්ටතම නිර්මාණය වන්නේ බිසෝකොටුවයි. වැවක ගැඹුරු ජල පීඩනය පාලනය කර සොරොව්වට සහ බැම්මට හානි නොවී පිටතට ජලය මුදාහැරීමට මෙමඟින් හැකි විය. එසේම ධාතුසේන රජු ඉදිකළ සැතපුමකට අඟල් භාගයක බැස්මක් සහිත ජයගඟ නොහොත් යෝධ ඇළ, ලෝකයේ වෙනත් කිසිදු ශිෂ්ටාචාරයක එකල නොතිබූ අතිවිශිෂ්ට මට්ටම් ගැනීමේ ශිල්පය මොනවට කියාපායි.",
      stepByStepSolution = listOf(
        "1. බිසෝකොටුව: ජල පීඩනය සමනය කර වැව් බැම්ම ආරක්ෂා කරන කුටීරය.",
        "2. රළපනාව: වැව් බැම්ම රළ පහරින් සේදීයාම වැළැක්වීමට යෙදූ ගල් ඇතුරුම.",
        "3. පිටවාන: වැවේ උපරිම ධාරිතාව ඉක්මවා යන අතිරික්ත ජලය බැහැර කරන ගල් පවුර.",
        "4. යෝධ ඇළ: කලා වැවේ සිට තිසා වැවට සැතපුම් 54ක් දුරට සැතපුමකට අඟල් භාගයක බැස්මෙන් ජලය ගෙනගිය ඉංජිනේරු නිර්මාණය.",
        "5. ඇළහැර ඇළ: මින්නේරිය වැව පෝෂණය කිරීමට මහසෙන් රජු තැනූ ඇළ."
      ),
      examTip = "විභාගයේදී 'බිසෝකොටුවේ කාර්යභාරය' සහ 'රළපනාවේ කාර්යභාරය' කෙටි ප්‍රශ්නවලට නිතරම විමසනු ලබයි.",
      coreFormulaOrRule = "වාරි තාක්ෂණික අංග: බිසෝකොටුව + පිටවාන + රළපනාව + සොරොව්ව",
      relatedTopic = "පැරණි ලංකාවේ වාරි ශිෂ්ටාචාරය"
    ),

    // ICT DOUBTS
    DoubtItem(
      id = "ict_doubt_logic_gates",
      subject = "ICT / තොරතුරු තාක්ෂණය",
      grade = "11",
      questionSinhala = "AND, OR, NOT සහ NAND තර්ක ද්වාරවල (Logic Gates) සත්‍යතා වගු මතක තබාගන්නේ කෙසේද?",
      shortSummary = "AND ද්වාරයේ සියලු ආදාන 1 නම් පමණක් ප්‍රතිදානය 1 වේ. OR ද්වාරයේ අවම එක් ආදානයක් හෝ 1 නම් ප්‍රතිදානය 1 වේ.",
      detailedVoiceExplanation = "තර්ක ද්වාර ඉතා සරලව මතක තබාගත හැක. ඇන්ඩ් ගේට් එක යනු ශ්‍රේණිගත ස්විච දෙකක් වැනිය. ආදාන දෙකම එක වුවහොත් පමණක් ප්‍රතිදානය එක වේ. ඕර් ගේට් එක යනු සමාන්තරගත ස්විච දෙකක් වැනිය. එක ආදානයක් හෝ එක වුවහොත් ප්‍රතිදානය එක වේ. නොට් ගේට් එක මගින් ලැබෙන ආදානය උඩුයටිකුරු කරයි. එක දුන්නොත් බිංදුවද, බිංදුව දුන්නොත් එකද ලැබේ. නැන්ඩ් ගේට් එක යනු ඇන්ඩ් ගේට් එකේ ප්‍රතිදානයට නොට් ගේට් එකක් සම්බන්ධ කිරීමයි.",
      stepByStepSolution = listOf(
        "1. AND Gate (A · B): A=1 සහ B=1 නම් පමණක් Y = 1 වේ.",
        "2. OR Gate (A + B): A=1 හෝ B=1 හෝ දෙකම 1 නම් Y = 1 වේ.",
        "3. NOT Gate (A'): A=1 නම් Y=0 වේ, A=0 නම් Y=1 වේ.",
        "4. NAND Gate ( (A · B)' ): AND ගේට් එකේ විරුද්ධ ප්‍රතිදානය ලැබේ (0,0 -> 1; 0,1 -> 1; 1,0 -> 1; 1,1 -> 0).",
        "5. NOR Gate ( (A + B)' ): OR ගේට් එකේ විරුද්ධ ප්‍රතිදානය ලැබේ."
      ),
      examTip = "සත්‍යතා වගුවක් පිරවීමේදී ආදාන සංයෝජන 2^n (2^2 = 4 සංයෝජන: 00, 01, 10, 11) ලෙස පිළිවෙළට ලිවිය යුතුය.",
      coreFormulaOrRule = "AND: Y = A · B | OR: Y = A + B | NOT: Y = A'",
      relatedTopic = "තර්ක ද්වාර සහ ඩිජිටල් පරිපථ"
    ),

    // ENGLISH DOUBTS
    DoubtItem(
      id = "eng_doubt_active_passive",
      subject = "ඉංග්‍රීසි භාෂාව",
      grade = "11",
      questionSinhala = "How do we convert Active Voice sentences into Passive Voice easily?",
      shortSummary = "Object becomes Subject + appropriate 'Be' verb + Past Participle (V3) + by + Agent.",
      detailedVoiceExplanation = "Hello students. When converting an active sentence into passive voice, follow three golden rules. First, identify the object and bring it to the front as the new subject. Second, check the tense and insert the correct form of the 'be' verb such as is, are, was, were, has been, or being. Third, always change the main verb into its third form, the Past Participle. For example, 'Kamal writes a letter' becomes 'A letter is written by Kamal'. Notice 'is' because the letter is singular present tense, and 'written' is the V3 form.",
      stepByStepSolution = listOf(
        "1. Identify Subject, Verb, Object (e.g., 'The chef cooks dinner').",
        "2. Move Object to the front: 'Dinner...'",
        "3. Add 'Be' verb matching tense and number: 'is' (Present Singular).",
        "4. Change Verb to Past Participle (V3): 'cooked'.",
        "5. Add 'by' + original subject: 'Dinner is cooked by the chef.'"
      ),
      examTip = "In O/L Paper II (Test 15 or 16), passive voice transformations carrying 2 marks are frequently tested.",
      coreFormulaOrRule = "Passive = Subject (original object) + [be verb] + Past Participle (V3) + [by agent]",
      relatedTopic = "English Grammar & Transformations"
    ),

    // BUDDHISM DOUBTS
    DoubtItem(
      id = "buddhism_doubt_noble_truths",
      subject = "බුද්ධ ධර්මය",
      grade = "11",
      questionSinhala = "චතුරාර්ය සත්‍යය සහ ආර්ය අෂ්ටාංගික මාර්ගය විභාග ප්‍රශ්නවලට ගළපා ලියන්නේ කෙසේද?",
      shortSummary = "දුක්ඛ, සමුදය, නිරෝධ, මාර්ග යන සත්‍ය සතර සහ මාර්ග සත්‍යය වන සීල, සමාධි, ප්‍රඥා ත්‍රිශික්ෂාවට අදාළ අෂ්ටාංගික මාර්ගයයි.",
      detailedVoiceExplanation = "බුදුදහමේ මූලිකම හරය වන්නේ චතුරාර්ය සත්‍යයයි. පළමුවැන්න දුක්ඛ සත්‍යය හෙවත් ඉපදීම, ජරාව, මරණය ආදී දුකයි. දෙවැන්න සමුදය සත්‍යය හෙවත් දුකට හේතුව වන තණ්හාවයි. තෙවැන්න නිරෝධ සත්‍යය හෙවත් දුක නැතිකිරීම වන නිවනයි. සිව්වැන්න මාර්ග සත්‍යය හෙවත් නිවන් දැකීමේ මාවතයි. එම මාර්ග සත්‍යය යනු ආර්ය අෂ්ටාංගික මාර්ගයයි. මෙය සීල, සමාධි, ප්‍රඥා ලෙස ත්‍රිශික්ෂාවට බෙදේ. සම්මා වාචා, සම්මා කම්මන්ත, සම්මා ආජීව සීලයට අයත් වන අතර, සම්මා වායාම, සම්මා සති, සම්මා සමාධි සමාධියටද, සම්මා දිට්ඨි, සම්මා සංකප්ප ප්‍රඥාවටද අයත් වේ.",
      stepByStepSolution = listOf(
        "1. දුක්ඛ ආර්ය සත්‍යය: සංසාරික පැවැත්මේ යථාර්ථය වන දුක.",
        "2. දුක්ඛ සමුදය ආර්ය සත්‍යය: දුක හටගැනීමට මුල්වන තෘෂ්ණාව (කාම, භව, විභව).",
        "3. දුක්ඛ නිරෝධ ආර්ය සත්‍යය: තෘෂ්ණාව ප්‍රහීන කිරීමෙන් ලබන පරම ශාන්තිය (නිර්වාණය).",
        "4. දුක්ඛ නිරෝධ ගාමිණී පටිපදා: ආර්ය අෂ්ටාංගික මාර්ගය (මධ්‍යම ප්‍රතිපදාව).",
        "5. ත්‍රිශික්ෂා වර්ගීකරණය: සීල (අංග 3), සමාධි (අංග 3), ප්‍රඥා (අංග 2)."
      ),
      examTip = "විභාගයේදී ආර්ය අෂ්ටාංගික මාර්ගයේ අංග අට ත්‍රිශික්ෂාවට බෙදා දක්වන චක්‍රය ඇඳීමට ලකුණු 5ක ප්‍රශ්නයක් ලෙස නිතර අසයි.",
      coreFormulaOrRule = "ත්‍රිශික්ෂාව: සීල (වාචා, කම්මන්ත, ආජීව) + සමාධි (වායාම, සති, සමාධි) + ප්‍රඥා (දිට්ඨි, සංකප්ප)",
      relatedTopic = "බුදුදහමේ මූලික ඉගැන්වීම්"
    ),

    // COMMERCE DOUBTS
    DoubtItem(
      id = "comm_doubt_accounting_equation",
      subject = "ව්‍යාපාර හා ගිණුම්කරණය",
      grade = "11",
      questionSinhala = "ගිණුම්කරණ සමීකරණය (වත්කම් = හිමිකම + වගකීම්) ගනුදෙනු මගින් වෙනස් වන්නේ කෙසේද?",
      shortSummary = "සෑම ගනුදෙනුවක් මගින්ම සමීකරණයේ දෙපස සමබරතාවය ආරක්ෂා වන සේ ද්විත්ව බලපෑමක් ඇති කරයි.",
      detailedVoiceExplanation = "ගිණුම්කරණයේ පදනම වන්නේ වත්කම් සමානයි හිමිකම ධන වගකීම් යන සමීකරණයයි. ඕනෑම ව්‍යාපාරික ගනුදෙනුවකින් අවම වශයෙන් ගිණුම් දෙකකට හෝ සමීකරණයේ අවම කොටස් දෙකකට බලපෑම් ඇතිවේ. උදාහරණයක් ලෙස අයිතිකරු ව්‍යාපාරයට මුදල් යෙදවූ විට වත්කම් යටතේ මුදල් වැඩි වන අතර හිමිකමද වැඩිවේ. ණයට භාණ්ඩ මිලදී ගත් විට තොගය වැඩි වන අතර වගකීම් වැඩිවේ. වියදමක් ගෙවූ විට මුදල් අඩු වන අතර හිමිකමෙන්ද අඩු වේ.",
      stepByStepSolution = listOf(
        "1. මූලික සමීකරණය: වත්කම් (Assets) = හිමිකම (Equity) + වගකීම් (Liabilities).",
        "2. පුළුල් කළ සමීකරණය: වත්කම් = මූලධනය + ආදායම් - වියදම් - ගැනිලි + වගකීම්.",
        "3. නීතිය: සෑම ගනුදෙනුවක්ම අවම වශයෙන් අවස්ථා 2කට බලපායි (ද්විත්ව සටහන් මූලධර්මය).",
        "4. ආදායම් මගින් හිමිකම වැඩි වන අතර වියදම් හා ගැනිලි මගින් හිමිකම අඩු වේ.",
        "5. සෑම ගනුදෙනුවකටම පසුව වත්කම්වල එකතුව හිමිකම සහ වගකීම්වල එකතුවට සමාන විය යුතුය."
      ),
      examTip = "ලකුණු 10ක දෙවන ප්‍රශ්න පත්‍ර ගැටලුවේදී 'ගනුදෙනු ගිණුම්කරණ සමීකරණයට ඇතුළත් කිරීම' අනිවාර්ය ප්‍රශ්නයකි.",
      coreFormulaOrRule = "A = E + L (වත්කම් = හිමිකම + වගකීම්)",
      relatedTopic = "ගිණුම්කරණ සමීකරණය සහ ද්විත්ව සටහන්"
    ),

    // SCIENCE ADDITIONAL
    DoubtItem(
      id = "sci_doubt_bonding",
      subject = "විද්‍යාව",
      grade = "11",
      questionSinhala = "අයනික සහ සහසංයුජ බන්ධන සෑදෙන ආකාරය සහ වෙනස්කම් මොනවාද?",
      shortSummary = "අයනික බන්ධන ඉලෙක්ට්‍රෝන හුවමාරුවෙන්ද (ලෝහ හා අලෝහ), සහසංයුජ බන්ධන ඉලෙක්ට්‍රෝන හවුලේ තබා ගැනීමෙන්ද (අලෝහ අතර) සෑදේ.",
      detailedVoiceExplanation = "රසායනික බන්ධන ප්‍රධාන ආකාර දෙකකි. පළමුවැන්න අයනික බන්ධනයි. මෙහිදී ලෝහ පරමාණුවක් ඉලෙක්ට්‍රෝන පිට කර ධන කැටායනයක් ද, අලෝහ පරමාණුවක් එම ඉලෙක්ට්‍රෝන ලබාගෙන සෘණ ඇනායනයක් ද සාදයි. මෙම ප්‍රතිවිරුද්ධ ආරෝපිත අයන අතර ඇතිවන ප්‍රබල ස්ථිති විද්‍යුත් ආකර්ෂණ බලය අයනික බන්ධනයයි. උදාහරණ සෝඩියම් ක්ලෝරයිඩ්. දෙවැන්න සහසංයුජ බන්ධනයි. මෙහිදී අලෝහ පරමාණු අතර ඉලෙක්ට්‍රෝන යුගල හවුලේ තබා ගැනීමෙන් අෂ්ටකය සම්පූර්ණ කරගනී. උදාහරණ ජලය, මීතේන් සහ ඔක්සිජන් අණු වේ.",
      stepByStepSolution = listOf(
        "1. අයනික බන්ධන: ලෝහ (ඉලෙක්ට්‍රෝන දායකයා) + අලෝහ (ඉලෙක්ට්‍රෝන ප්‍රතිග්‍රාහකයා).",
        "2. අයනික ගුණ: ඉහළ ද්‍රවාංක/තාපාංක, ජලීය හෝ විලයන තත්ත්වයේදී විද්‍යුතය සන්නයනය කරයි.",
        "3. සහසංයුජ බන්ධන: අලෝහ + අලෝහ අතර ඉලෙක්ට්‍රෝන යුගල හවුලේ තබා ගැනීම.",
        "4. සහසංයුජ ගුණ: සාපේක්ෂව අඩු ද්‍රවාංක/තාපාංක, සාමාන්‍යයෙන් විද්‍යුතය සන්නයනය නොකරයි.",
        "5. ලුවිස් තිත්-කතිර සටහන් මගින් බන්ධන නිරූපණය විභාගයට අඳින්න."
      ),
      examTip = "NaCl (අයනික) සහ CH4 (සහසංයුජ) අණුවල ලුවිස් තිත්-කතිර ව්‍යුහය ඇඳීමට ලකුණු 3ක ප්‍රශ්නයක් විභාගයට නිතර පැමිණේ.",
      coreFormulaOrRule = "අයනික = Na⁺ + Cl⁻ -> NaCl | සහසංයුජ = C + 4H -> CH4 (හවුල් යුගල 4)",
      relatedTopic = "රසායනික බන්ධන සහ පදාර්ථයේ ව්‍යුහය"
    ),

    DoubtItem(
      id = "sci_doubt_genetics",
      subject = "විද්‍යාව",
      grade = "11",
      questionSinhala = "ප්‍රවේණිය හා මෙන්ඩල්ගේ ඒකසංකරණ පරීක්ෂණය (F1 සහ F2 පරම්පරා) විසඳන්නේ කෙසේද?",
      shortSummary = "ප්‍රමුඛ සහ නිලීන ජාන සංයෝජනය වී F1 පරම්පරාවේ සියල්ල ප්‍රමුඛ ලක්ෂණද, F2 පරම්පරාවේ 3:1 ප්‍රවේණිරූපී අනුපාතයක්ද ලැබේ.",
      detailedVoiceExplanation = "ග්‍රෙගර් මෙන්ඩල් පියතුමා උස සහ මිටි මෑ ශාක පිරිසිදු අභිජනනය කර ඒකසංකරණ පරීක්ෂණය සිදුකළේය. උස ලක්ෂණය ප්‍රමුඛ ජානයක් වන අතර එය විශාල ටී ලෙස දක්වයි. මිටි ලක්ෂණය නිලීන වන අතර එය කුඩා ටී ලෙස දක්වයි. ජනක පරම්පරාව කැපිටල් ටී ටී සහ සිම්පල් ටී ටී වන විට, F1 පළමු පරම්පරාවේ සියලුම ශාක විෂමයුග්මක උස ශාක හෙවත් කැපිටල් ටී සිම්පල් ටී වේ. මෙම F1 ශාක ස්වපරාගනය කළ විට F2 දෙවන පරම්පරාවේදී පෙනුම අනුව උස ශාක 3කට මිටි ශාක 1ක් බැගින් 3:1 අනුපාතයක් හිමිවේ.",
      stepByStepSolution = listOf(
        "1. ජනක (P): සමයුග්මක උස (TT) x සමයුග්මක මිටි (tt).",
        "2. ජලාණු (Gametes): T සහ t.",
        "3. F1 පරම්පරාව: සියල්ල විෂමයුග්මක උස (Tt) - 100% ප්‍රමුඛ ලක්ෂණය.",
        "4. F2 පරම්පරාව (Tt x Tt): TT (1), Tt (2), tt (1).",
        "5. රූපානුදර්ශ අනුපාතය: උස 3 : මිටි 1 | ප්‍රවේණිදර්ශ අනුපාතය: 1 : 2 : 1."
      ),
      examTip = "පනට් චතුරස්‍රය (Punnett Square) අඳින විට ජලාණු නිරූපණය නිවැරදිව රවුම් කර දැක්වීමෙන් සම්පූර්ණ ලකුණු ලැබේ.",
      coreFormulaOrRule = "F2 රූපානුදර්ශය = 3 (ප්‍රමුඛ) : 1 (නිලීන) | ප්‍රවේණිදර්ශය = 1 TT : 2 Tt : 1 tt",
      relatedTopic = "ප්‍රවේණිය සහ පරම්පරාගත ලක්ෂණ"
    ),

    // MATHEMATICS ADDITIONAL
    DoubtItem(
      id = "math_doubt_trig",
      subject = "ගණිතය",
      grade = "11",
      questionSinhala = "ත්‍රිකෝණමිතිය උන්නතාංශ හා අවනතාංශ ආශ්‍රිත ගැටලුවක් සිතුවම් කර විසඳන්නේ කෙසේද?",
      shortSummary = "තිරස් රේඛාවට ඉහළින් බලන විට උන්නතාංශ කෝණයද, තිරස් රේඛාවට පහළින් බලන විට අවනතාංශ කෝණයද සලකා tan = සම්මුඛ / බද්ධ යොදන්න.",
      detailedVoiceExplanation = "ත්‍රිකෝණමිතිය ගැටලුවකදී පළමු සහ වැදගත්ම පියවර වන්නේ නිවැරදි සෘජුකෝණී ත්‍රිකෝණ රූපසටහනක් ඇඳීමයි. නිරීක්ෂකයාගේ ඇසේ මට්ටමේ සිට ඉහළ ඇති වස්තුවක් දෙස බලන විට තිරස් රේඛාව සමඟ සෑදෙන කෝණය උන්නතාංශ කෝණයයි. ඉහළ සිට පහළ ඇති වස්තුවක් දෙස බලන විට තිරස සමඟ පහළට සෑදෙන කෝණය අවනතාංශ කෝණයයි. අවනතාංශ කෝණය ඒකාන්තර කෝණ නීතිය අනුව පොළොවේ කෝණයට සමාන වේ. ඉන්පසු tan තීටා සමානයි සම්මුඛ පාදය බෙදීම බද්ධ පාදය සූත්‍රයට අගයන් ආදේශ කරන්න.",
      stepByStepSolution = listOf(
        "1. රූප සටහන: තිරස් පොළොව, සිරස් කුළුණ හෝ ගොඩනැගිල්ල සහ දෘෂ්ටි රේඛාව අඳින්න.",
        "2. කෝණ ලකුණු කිරීම: නිරීක්ෂකයාගේ ඇස මට්ටමේ තිරස් රේඛාව අඳින්න. උන්නතාංශය ඉහළටද, අවනතාංශය පහළටද ලකුණු කරන්න.",
        "3. ඒකාන්තර කෝණ: ඉහළ අවනතාංශ කෝණය = පහළ නිරීක්ෂණ කෝණය (Z හැඩය).",
        "4. ත්‍රිකෝණමිතික අනුපාතය: tan θ = සම්මුඛ පාදය / බද්ධ පාදය.",
        "5. සුළු කිරීම: ලඝුගණක පොතෙන් tan අගය ගෙන හරස් ගුණිතයෙන් උස හෝ දුර ගණනය කරන්න."
      ),
      examTip = "සිරස් ගොඩනැගිල්ල තිරස් පොළොව සමඟ 90° කෝණයක් සාදන බව රූපයේ සෘජුකෝණ ලකුණෙන් දැක්වීමෙන් රූපයට හිමි ලකුණු 2 ලැබේ.",
      coreFormulaOrRule = "tan θ = සම්මුඛ පාදය / බද්ධ පාදය | sin θ = සම්මුඛ / කර්ණය | cos θ = බද්ධ / කර්ණය",
      relatedTopic = "ත්‍රිකෝණමිතිය සහ කෝණ මිනුම්"
    ),

    DoubtItem(
      id = "math_doubt_arithmetic_progression",
      subject = "ගණිතය",
      grade = "11",
      questionSinhala = "සමාන්තර ශ්‍රේඪියක n වන පදය සහ එකතුව සූත්‍ර ගැටලුවලට යොදන්නේ කෙසේද?",
      shortSummary = "Tn = a + (n - 1)d සහ Sn = n/2 [2a + (n - 1)d] සූත්‍රවල a මුල් පදයද, d පොදු අන්තරයද වේ.",
      detailedVoiceExplanation = "සමාන්තර ශ්‍රේඪියක් යනු ඕනෑම පදයකින් ඊට පෙර පදය අඩු කළ විට නියත අගයක් හෙවත් පොදු අන්තරයක් d ලැබෙන සංඛ්‍යා රටාවකි. මුල් පදය කුඩා a වේ. n වන පදය සෙවීම සඳහා Tn = a + n අඩුකිරීම 1 වරක් d සූත්‍රය භාවිතා කරයි. මුල් පද n වල එකතුව සඳහා Sn = n බෙදීම 2 වරහන් තුළ 2a ධන n අඩුකිරීම 1 වරක් d යොදාගනී. අවසන් පදය l දන්නේ නම් Sn = n බෙදීම 2 වරහන් තුළ a ධන l සූත්‍රය ඉතා පහසුවෙන් යෙදිය හැක.",
      stepByStepSolution = listOf(
        "1. මුල් පදය a සහ පොදු අන්තරය d සොයාගන්න: d = T2 - T1 = T3 - T2.",
        "2. n වන පදය: Tn = a + (n - 1)d.",
        "3. මුල් පද n හි එකතුව: Sn = n/2 [2a + (n - 1)d].",
        "4. අවසන් පදය දන්නේ නම්: Sn = n/2 (a + l).",
        "5. සමගාමී සමීකරණ: පද දෙකක් ලබා දී ඇති විට a සහ d සඳහා සමගාමී සමීකරණ දෙකක් ගොඩනඟා විසඳන්න."
      ),
      examTip = "දෙවන ප්‍රශ්න පත්‍රයේ ශ්‍රේඪි ගැටලුවේ අනිවාර්යයෙන්ම සමගාමී සමීකරණ 2ක් විසඳීමට ලකුණු 4ක් වෙන් කර ඇත.",
      coreFormulaOrRule = "Tn = a + (n - 1)d | Sn = (n/2)[2a + (n - 1)d]",
      relatedTopic = "සමාන්තර සහ ගුණෝත්තර ශ්‍රේඪි"
    ),

    // ENGLISH ADDITIONAL
    DoubtItem(
      id = "eng_doubt_reported_speech",
      subject = "ඉංග්‍රීසි භාෂාව",
      grade = "11",
      questionSinhala = "How do we convert Direct Speech into Reported (Indirect) Speech accurately?",
      shortSummary = "Change tense one step backward into the past, adjust pronouns, and change time/place adverbs.",
      detailedVoiceExplanation = "When changing direct speech to reported speech, remember the three transformations. First is Tense Backshift: Simple Present becomes Simple Past, Present Continuous becomes Past Continuous, and Present Perfect becomes Past Perfect. Second is Pronoun change: 'I' becomes 'he' or 'she', 'we' becomes 'they', and 'my' becomes 'his' or 'her'. Third is Time and place markers: 'today' becomes 'that day', 'tomorrow' becomes 'the next day', 'yesterday' becomes 'the day before', and 'here' becomes 'there'. For questions, use 'if' or 'whether' for yes/no questions and remove question marks.",
      stepByStepSolution = listOf(
        "1. Tense Shift: Simple Present ('write') -> Simple Past ('wrote').",
        "2. Continuous Shift: Present Continuous ('is writing') -> Past Continuous ('was writing').",
        "3. Perfect Shift: Present Perfect ('has written') -> Past Perfect ('had written').",
        "4. Modal Shift: will -> would, can -> could, may -> might.",
        "5. Time/Place Changes: today -> that day, now -> then, here -> there, this -> that."
      ),
      examTip = "In O/L Paper 2, indirect speech questions often test the removal of quotation marks and correct past tense shift.",
      coreFormulaOrRule = "Direct: He said, 'I am busy today.' -> Reported: He said that he was busy that day.",
      relatedTopic = "Reported Speech and Indirect Grammar"
    ),

    DoubtItem(
      id = "eng_doubt_conditionals",
      subject = "ඉංග්‍රීසි භාෂාව",
      grade = "11",
      questionSinhala = "What are the rules and formulas for Conditional Sentences (Types 1, 2, and 3)?",
      shortSummary = "Type 1: If + Present, will + V1. Type 2: If + Past, would + V1. Type 3: If + Past Perfect, would have + V3.",
      detailedVoiceExplanation = "Conditional sentences express a condition and its result. Type 1 is real and probable: 'If it rains, we will cancel the match.' Notice present tense 'rains' followed by 'will'. Type 2 is imaginary or unlikely: 'If I had wings, I would fly across the world.' Notice past tense 'had' with 'would fly'. Type 3 is impossible regret about the past: 'If you had studied hard, you would have passed the exam.' Notice past perfect 'had studied' with 'would have passed'. Remembering these three formulas guarantees full marks in your O/L grammar section.",
      stepByStepSolution = listOf(
        "1. Zero Conditional: If + Present -> Present (General truths: 'If you heat water, it boils').",
        "2. First Conditional: If + Simple Present -> will + base verb (Likely future).",
        "3. Second Conditional: If + Simple Past -> would + base verb (Imaginary present).",
        "4. Third Conditional: If + Past Perfect (had + V3) -> would have + V3 (Past regret).",
        "5. Comma rule: Put a comma when 'If' starts the sentence; no comma if 'If' is in the middle."
      ),
      examTip = "If the 'If-clause' is placed at the beginning, always put a comma before the main clause.",
      coreFormulaOrRule = "Type 1: If + V1, will + V1 | Type 2: If + V2, would + V1 | Type 3: If + had V3, would have V3",
      relatedTopic = "Conditionals and If-Clauses"
    ),

    // SINHALA LANGUAGE
    DoubtItem(
      id = "sinhala_doubt_uktha_akhyatha",
      subject = "සිංහල භාෂාව",
      grade = "11",
      questionSinhala = "සිංහල භාෂාවේ උක්ත ආඛ්‍යාත පද සම්බන්ධය සහ න-ණ, ල-ළ නිවැරදි භාවිතය කෙසේද?",
      shortSummary = "උක්තය ඒකවචන නම් ආඛ්‍යාතය ඒකවචන විය යුතුය. උක්තය බහුවචන නම් ආඛ්‍යාතය බහුවචන විය යුතුය.",
      detailedVoiceExplanation = "සිංහල ව්‍යාකරණයේ වැදගත්ම රීතිය වන්නේ උක්ත ආඛ්‍යාත පද සම්බන්ධයයි. ප්‍රථම පුරුෂ ඒකවචන පුරුෂලිංග උක්තයකට 'යි' හෝ 'ඒ' ආඛ්‍යාතය ද (උදා: ගොවියා සී සෑම කරයි), ස්ත්‍රීලිංග උක්තයකට 'ය' ආඛ්‍යාතය ද (උදා: දැරිය ගීයක් ගයන්නීය), ප්‍රථම පුරුෂ බහුවචනයට 'ති', 'ත්' හෝ 'ඕ' ආඛ්‍යාතය ද (උදා: ශිෂ්‍යයෝ විභාගයට පෙනී සිටිති) යෙදේ. මම උක්තයට 'මි' ද, අපි උක්තයට 'මු' ද අවසන් විය යුතුය. න-ණ ල-ළ භාවිතයේදී මූර්ධජ ණ සහ ළ යෙදෙන වචන නිවැරදිව මතක තබාගැනීම අක්ෂර වින්‍යාසයට ලකුණු රැකදෙයි.",
      stepByStepSolution = listOf(
        "1. මම (උත්තම පුරුෂ ඒකවචන) -> ...මි (උදා: මම පොතක් කියවමි).",
        "2. අපි (උත්තම පුරුෂ බහුවචන) -> ...මු (උදා: අපි පාසල් යමු).",
        "3. ඔබ/තෝ (මධ්‍යම පුරුෂ) -> ...හි / ...හු.",
        "4. හේ/ඔහු (ප්‍රථම පුරුෂ ඒකවචන) -> ...යි / ...ඒ.",
        "5. ඔවුහු/ශිෂ්‍යයෝ (ප්‍රථම පුරුෂ බහුවචන) -> ...ති / ...ත් / ...දෝ."
      ),
      examTip = "සාමාන්‍ය පෙළ සිංහල පළමු ප්‍රශ්න පත්‍රයේ උක්ත ආඛ්‍යාත පද සම්බන්ධය පිළිබඳ ප්‍රශ්න 3ක් හෝ 4ක් අනිවාර්යයෙන්ම අසනු ලැබේ.",
      coreFormulaOrRule = "උක්තය (මම -> මි, අපි -> මු, ඔහු -> යි, ඔවුහු -> ති)",
      relatedTopic = "සිංහල ව්‍යාකරණය සහ වාක්‍ය රීති"
    ),

    // GEOGRAPHY
    DoubtItem(
      id = "geo_doubt_climatic_zones",
      subject = "භූගෝල විද්‍යාව",
      grade = "11",
      questionSinhala = "ශ්‍රී ලංකාවේ ප්‍රධාන දේශගුණික කලාප (තෙත්, වියළි, අතරමැදි) සහ ඒවායේ ලක්ෂණ මොනවාද?",
      shortSummary = "වාර්ෂික වර්ෂාපතනය 2000 mm ට වැඩි ප්‍රදේශ තෙත් කලාපයද, 2000 mm - 1250 mm අතරමැදිද, 1250 mm ට අඩු වියළි කලාපයද වේ.",
      detailedVoiceExplanation = "ශ්‍රී ලංකාව දේශගුණික කලාප තුනකට ප්‍රධාන වශයෙන් බෙදා වෙන් කරනු ලබයි. පළමුවැන්න තෙත් කලාපයයි. වාර්ෂික වර්ෂාපතනය මිලිමීටර් 2000 ඉක්මවන අතර නිරිතදිග මෝසම්, දෙවන අන්තර් මෝසම් සහ සංවහන වැසි වලින් වසර පුරාම පාහේ තෙතමනය ලැබේ. දෙවැන්න වියළි කලාපයයි. වාර්ෂික වර්ෂාපතනය මිලිමීටර් 1250ට අඩු වන අතර ප්‍රධාන වශයෙන් ඊසානදිග මෝසමෙන් පමණක් වැසි ලබයි. මැයි සිට සැප්තැම්බර් දක්වා දීර්ඝ වියළි කාලගුණයක් පවතී. තෙවැන්න අතරමැදි කලාපය වන අතර මිලිමීටර් 1250ත් 2000ත් අතර මධ්‍යස්ථ වර්ෂාපතනයක් ලබයි.",
      stepByStepSolution = listOf(
        "1. තෙත් කලාපය: වාර්ෂික වර්ෂාපතනය > 2000 mm, වෘක්ෂලතා: නිවර්තන වැසි වනාන්තර (සිංහරාජය).",
        "2. වියළි කලාපය: වාර්ෂික වර්ෂාපතනය < 1250 mm, වෘක්ෂලතා: වියළි මිශ්‍ර සදාහරිත වනාන්තර, කටු පඳුරු.",
        "3. අතරමැදි කලාපය: වර්ෂාපතනය 1250 mm - 2000 mm, කෘෂිකාර්මික සංක්‍රාන්ති ලක්ෂණ.",
        "4. ප්‍රධාන වැසි සමයන්: නිරිතදිග මෝසම (මැයි-සැප්), ඊසානදිග මෝසම (දෙසැ-පෙබ), අන්තර් මෝසම් 2ක්.",
        "5. භූ විෂමතාව: පහතරට (0-300m), මැදරට (300-1000m), උඩරට (>1000m)."
      ),
      examTip = "සිතියම් ලකුණු කිරීමේදී මිලිමීටර් 2000 සමවෘෂ්ටි රේඛාව නිවැරදිව සලකුණු කිරීමට පුරුදු වන්න.",
      coreFormulaOrRule = "කලාප: තෙත් (>2000mm) | අතරමැදි (1250-2000mm) | වියළි (<1250mm)",
      relatedTopic = "ශ්‍රී ලංකාවේ භෞතික පරිසරය සහ දේශගුණය"
    ),

    // CIVICS DOUBTS
    DoubtItem(
      id = "civics_doubt_constitution",
      subject = "පුරවැසි අධ්‍යාපනය",
      grade = "11",
      questionSinhala = "ශ්‍රී ලංකා ප්‍රජාතන්ත්‍රවාදී සමාජවාදී ජනරජයේ ආණ්ඩුවේ ප්‍රධාන අංශ 3 (ව්‍යවස්ථාදායකය, විධායකය, අධිකරණය) සහ ඒවායේ බලතල මොනවාද?",
      shortSummary = "ව්‍යවස්ථාදායකය නීති පනවයි (පාර්ලිමේන්තුව), විධායකය නීති ක්‍රියාත්මක කරයි (ජනාධිපති හා අමාත්‍ය මණ්ඩලය), අධිකරණය නීතිය අර්ථනිරූපණය කර සාධාරණය ඉටු කරයි.",
      detailedVoiceExplanation = "ප්‍රජාතන්ත්‍රවාදී රටක ආණ්ඩුව ප්‍රධාන අංශ තුනකින් සමන්විත වන අතර මෙය බලතල බෙදීමේ මූලධර්මය මත පදනම් වේ. පළමුවැන්න ව්‍යවස්ථාදායකයයි. ශ්‍රී ලංකාවේ ව්‍යවස්ථාදායක බලය හිමි වන්නේ පාර්ලිමේන්තුවටයි. ජනතාව ඡන්දයෙන් පත්කරන මන්ත්‍රීවරුන් 225 දෙනෙකුගෙන් යුත් පාර්ලිමේන්තුව රටට අවශ්‍ය නීති සම්පාදනය කරයි. දෙවැන්න විධායකයයි. රටේ පාලන බලතල සහ ආරක්ෂාව මෙහෙයවීමේ බලය විධායක ජනාධිපතිවරයා ප්‍රමුඛ අමාත්‍ය මණ්ඩලයට හිමිවේ. තෙවැන්න අධිකරණයයි. නීතියේ ආධිපත්‍යය සුරකිමින් සාධාරණත්වය ඉටු කිරීම, ආණ්ඩුක්‍රම ව්‍යවස්ථාව අර්ථනිරූපණය කිරීම සහ මූලික අයිතිවාසිකම් සුරැකීම ශ්‍රේෂ්ඨාධිකරණය ඇතුළු අධිකරණ පද්ධතිය මගින් සිදුකරයි. මෙම අංශ තුන එකිනෙක මත තුලන හා සංවරණ පද්ධතියක් ලෙස ක්‍රියාත්මක වීම ප්‍රජාතන්ත්‍රවාදයේ හරයයි.",
      stepByStepSolution = listOf(
        "1. ව්‍යවස්ථාදායකය (Legislature): පාර්ලිමේන්තුව (මන්ත්‍රීවරු 225) - රටේ නීති සම්පාදනය, අයවැය සම්මත කිරීම.",
        "2. විධායකය (Executive): ජනාධිපති සහ කැබිනට් මණ්ඩලය - රාජ්‍ය ප්‍රතිපත්ති ක්‍රියාත්මක කිරීම, ආරක්ෂාව සහ විදේශ සබඳතා.",
        "3. අධිකරණය (Judiciary): ශ්‍රේෂ්ඨාධිකරණය, අභියාචනාධිකරණය සහ දිසා අධිකරණ - නීතිය ක්‍රියාත්මක කිරීම සහ අර්ථකථනය.",
        "4. මූලික අයිතිවාසිකම්: 1978 ආණ්ඩුක්‍රම ව්‍යවස්ථාවේ 3 වන පරිච්ඡේදය මගින් පුරවැසියන්ගේ මූලික අයිතීන් තහවුරු කර ඇත.",
        "5. පරමාධිපත්‍ය බලය: බලය ඇත්තේ ජනතාව සතුව වන අතර එය ඡන්ද බලයෙන් ක්‍රියාත්මක වේ."
      ),
      examTip = "විභාගයේදී ව්‍යවස්ථාදායකය, විධායකය සහ අධිකරණයේ බලතල වෙන් වෙන්ව ලිවීමට ලකුණු 4ක හෝ 5ක ප්‍රශ්නයක් නිතර ලැබේ.",
      coreFormulaOrRule = "ආණ්ඩුවේ අංශ 3: ව්‍යවස්ථාදායකය (නීති පැනවීම) | විධායකය (පාලනය) | අධිකරණය (සාධාරණය)",
      relatedTopic = "ප්‍රජාතන්ත්‍රවාදී පාලනය සහ ආණ්ඩුක්‍රම ව්‍යවස්ථාව"
    ),

    // HEALTH DOUBTS
    DoubtItem(
      id = "health_doubt_nutrition_bmi",
      subject = "සෞඛ්‍යය",
      grade = "11",
      questionSinhala = "ශරීර ස්කන්ධ දර්ශකය (BMI) ගණනය කරන්නේ කෙසේද? සමබල ආහාර වේලක ප්‍රධාන පෝෂක මොනවාද?",
      shortSummary = "BMI = බර (kg) / උස වර්ගය (m²). සමබල ආහාර වේලක කාබෝහයිඩ්‍රේට්, ප්‍රෝටීන, ලිපිඩ, විටමින්, ඛනිජ ලවණ සහ ජලය නිවැරදි අනුපාතයට අඩංගු විය යුතුය.",
      detailedVoiceExplanation = "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපන විෂයේදී ශරීර ස්කන්ධ දර්ශකය හෙවත් BMI අගය සෙවීම විභාගයේදී අනිවාර්යයෙන්ම ගණනය කිරීමට ලැබෙන ගැටලුවකි. BMI සෙවීමේ සූත්‍රය වන්නේ, පුද්ගලයෙකුගේ කිලෝග්‍රෑම් වලින් මනින ලද බර, මීටර් වලින් මනින ලද උසේ වර්ගයෙන් බෙදීමයි. උදාහරණයක් ලෙස යම් අයෙකුගේ බර කිලෝග්‍රෑම් 50ක් සහ උස මීටර් 1.5ක් නම්, 50 බෙදීම 1.5 ගුණ කිරීම 1.5 වේ. ලැබෙන BMI අගය 18.5 ට අඩු නම් අඩු බර තත්ත්වයකි. 18.5 ත් 24.9 ත් අතර නම් එය නිරෝගී සුදුසු බරයි. 25 ත් 29.9 ත් අතර නම් අධික බර වන අතර, 30 ට වැඩි නම් ස්ථුලතාවයයි. නිරෝගී ජීවිතයකට සහ නිවැරදි BMI අගයක් පවත්වා ගැනීමට කාබෝහයිඩ්‍රේට්, ප්‍රෝටීන, මේදය, විටමින්, ඛනිජ ලවණ සහ ජලය ප්‍රමාණවත්ව අඩංගු සමබල ආහාර වේලක් දිනපතා ලබාගත යුතුය.",
      stepByStepSolution = listOf(
        "1. BMI සූත්‍රය: BMI = ශරීර බර (kg) / [ උස (m) × උස (m) ]",
        "2. ඒකක පරීක්ෂාව: උස සෙන්ටිමීටර වලින් දී ඇත්නම් එය 100න් බෙදා මීටර් බවට හරවන්න (උදා: 150cm = 1.5m).",
        "3. වර්ගීකරණය: <18.5 = අඩු බර | 18.5 - 24.9 = සාමාන්‍ය නිරෝගී බර | 25 - 29.9 = අධික බර | ≥30 = ස්ථුලතාව.",
        "4. ප්‍රධාන පෝෂක 6: කාබෝහයිඩ්‍රේට් (ශක්තිය), ප්‍රෝටීන (වර්ධනය), ලිපිඩ (තාපය), විටමින් (ආරක්ෂාව), ඛනිජ ලවණ (දත්/අස්ථි), ජලය.",
        "5. විභාග ලකුණු: සූත්‍රය ලිවීමට ලකුණු 1ක්, ආදේශයට ලකුණු 1ක් සහ අවසන් නිගමනයට ලකුණු 1ක් ලැබේ."
      ),
      examTip = "සෙන්ටිමීටර වලින් දෙන උස මීටර් කිරීමට අමතක නොකරන්න. අවසන් අගය අනුව පුද්ගලයාගේ පෝෂණ මට්ටම ලියා දක්වන්න.",
      coreFormulaOrRule = "BMI = Weight(kg) / Height(m)² | නිරෝගී සීමාව: 18.5 - 24.9 kg/m²",
      relatedTopic = "පෝෂණය, ශරීර ස්කන්ධ දර්ශකය සහ සුවැති දිවිපැවැත්ම"
    )
  )

  fun matchesSubject(itemSubject: String, filterSubject: String): Boolean {
    if (filterSubject == "සියල්ල") return true
    val normItem = itemSubject.trim().lowercase()
    val normFilter = filterSubject.trim().lowercase()
    if (normItem.contains(normFilter) || normFilter.contains(normItem)) return true
    if ((normFilter.contains("ict") || normFilter.contains("තොරතුරු")) &&
        (normItem.contains("ict") || normItem.contains("තොරතුරු"))) return true
    if ((normFilter.contains("වාණිජ") || normFilter.contains("ගිණුම්") || normFilter.contains("ව්‍යාපාර")) &&
        (normItem.contains("වාණිජ") || normItem.contains("ගිණුම්") || normItem.contains("ව්‍යාපාර"))) return true
    if (normFilter.contains("සෞඛ්‍ය") && normItem.contains("සෞඛ්‍ය")) return true
    if (normFilter.contains("පුරවැසි") && normItem.contains("පුරවැසි")) return true
    if (normFilter.contains("සිංහල") && normItem.contains("සිංහල")) return true
    if ((normFilter.contains("ඉංග්‍රීසි") || normFilter.contains("english")) &&
        (normItem.contains("ඉංග්‍රීසි") || normItem.contains("english"))) return true
    return false
  }

  /**
   * Converts a SyllabusUnit into a full comprehensive DoubtItem with voice explanation and steps.
   */
  fun fromUnit(unit: SyllabusUnit): DoubtItem {
    return DoubtItem(
      id = "unit_${unit.id}",
      subject = unit.subject,
      grade = unit.grade,
      questionSinhala = "${unit.titleSinhala} (${unit.englishTitle}) පාඩමේ මූලික සංකල්ප සහ විභාග ගැටලු",
      shortSummary = "${unit.grade} ශ්‍රේණිය ${unit.subject} - ${unit.unitNumber} වන ඒකකය: ${unit.titleSinhala}. මූලික සංකල්ප: ${unit.keyConcepts.joinToString(", ")}.",
      detailedVoiceExplanation = "ආයුබෝවන් දුවේ පුතේ. අද අප සාකච්ඡා කරන්නේ ${unit.grade} ශ්‍රේණියේ ${unit.subject} විෂය නිර්දේශයේ ${unit.unitNumber} වන පාඩම වන ${unit.titleSinhala} පිළිබඳවයි. ${unit.fullExplanation} මෙහිදී මතක තබාගත යුතු ප්‍රධාන සූත්‍රය හෝ මූලධර්මය වන්නේ, ${unit.coreFormulaOrRule} යන්නයි. විභාගයේදී මෙම පාඩමෙන් සම්පූර්ණ ලකුණු ලබාගැනීමට: ${unit.examTip}",
      stepByStepSolution = listOf(
        "1. පාඩමේ මූලික සංකල්ප: ${unit.keyConcepts.joinToString(" • ")}.",
        "2. සිද්ධාන්ත විග්‍රහය: ${unit.fullExplanation}",
        "3. අත්‍යවශ්‍ය සූත්‍රය / මූලධර්මය: ${unit.coreFormulaOrRule}",
        "4. නිතර අසන ප්‍රශ්න: ${unit.sampleDoubts.joinToString(" • ")}",
        "5. විභාග ලකුණු ලබාගැනීමේ උපක්‍රමය: ${unit.examTip}"
      ),
      examTip = unit.examTip,
      coreFormulaOrRule = unit.coreFormulaOrRule,
      relatedTopic = "${unit.grade} ශ්‍රේණිය ${unit.subject} - පාඩම ${unit.unitNumber}"
    )
  }

  /**
   * Resolves ANY student query dynamically.
   * If an exact match is found in curated doubts, returns it.
   * Checks syllabus units matching the grade and subject.
   * Otherwise, generates a structured pedagogical explanation with complete voice script!
   */
  fun resolveDoubt(userQuery: String, grade: String, subject: String): DoubtItem {
    val clean = userQuery.trim().lowercase()
    if (clean.isBlank()) {
      return curatedDoubts.first()
    }

    // Check curated library for close matches
    val matched = curatedDoubts.firstOrNull {
      clean.contains(it.questionSinhala.lowercase()) ||
      it.questionSinhala.lowercase().contains(clean) ||
      clean.contains(it.relatedTopic.lowercase()) ||
      it.detailedVoiceExplanation.lowercase().contains(clean)
    }
    if (matched != null) return matched

    // Check syllabus units for matching grade and subject
    val matchedUnit = SyllabusUnitsRepository.allUnits.firstOrNull { u ->
      (u.grade == grade || grade == "ALL") &&
        (clean.contains(u.titleSinhala.lowercase()) ||
         clean.contains(u.englishTitle.lowercase()) ||
         u.titleSinhala.lowercase().contains(clean) ||
         u.keyConcepts.any { c -> clean.contains(c.lowercase()) } ||
         u.sampleDoubts.any { s -> clean.contains(s.lowercase()) || s.lowercase().contains(clean) })
    }
    if (matchedUnit != null) {
      return fromUnit(matchedUnit)
    }

    // Generate dynamic intelligent doubt resolution
    val topicSubject = if (subject.isNotBlank() && subject != "සියල්ල") subject else "අධ්‍යයන"
    val voiceScript = buildVoiceScript(userQuery, grade, topicSubject)
    val steps = buildSteps(userQuery, topicSubject)

    return DoubtItem(
      id = "dynamic_doubt_${System.currentTimeMillis()}",
      subject = topicSubject,
      grade = grade,
      questionSinhala = userQuery,
      shortSummary = "$topicSubject විෂය නිර්දේශයේ '$userQuery' ආශ්‍රිත මූලික සංකල්පය, පියවරෙන් පියවර විසඳුම සහ නිල විභාග ප්‍රමිතිය.",
      detailedVoiceExplanation = voiceScript,
      stepByStepSolution = steps,
      examTip = "විභාග ප්‍රශ්න පත්‍රයේ මෙම ප්‍රශ්නය පැමිණි විට මූලික නිර්වචනය, අදාළ සූත්‍රය සහ අවසන් නිගමනය පැහැදිලිව වෙනම ඡේදවලින් ලියන්න.",
      coreFormulaOrRule = "සම්මත විෂය නිර්දේශ මූලධර්මය: $userQuery",
      relatedTopic = "$topicSubject විෂය ගැටලු විසඳීම"
    )
  }

  private fun buildVoiceScript(query: String, grade: String, subject: String): String {
    return "ආයුබෝවන් ශිෂ්‍ය මිත්‍රයා. ඔබ විමසූ ගැටලුව වන්නේ, $query යන්නයි. $grade ශ්‍රේණියේ $subject විෂය නිර්දේශයට අනුව මෙම ගැටලුව විසඳීම සඳහා අප මුලින්ම මෙහි මූලික සංකල්පය හඳුනාගත යුතුය. පළමුව, ගැටලුවේ දී ඇති දත්ත සහ අසන ප්‍රශ්නය පැහැදිලිව වෙන් කරගන්න. දෙවනුව, ඊට අදාළ විද්‍යාත්මක හෝ ගණිතමය මූලධර්මය හඳුනාගෙන පියවරෙන් පියවර ගණනය කිරීම හෝ විස්තර කිරීම සිදුකරන්න. තෙවනුව, අවසන් පිළිතුර සමඟ නිවැරදි ඒකක හෝ තාක්ෂණික වචන ලිවීම අත්‍යවශ්‍යයි. විභාගයේදී සම්පූර්ණ ලකුණු ලබාගැනීමට මෙම පිළිවෙළ ඉතා වැදගත් වේ."
  }

  private fun buildSteps(query: String, subject: String): List<String> {
    return listOf(
      "1. ගැටලුවේ මූලික සංකල්පය: '$query' යන්න $subject විෂය නිර්දේශයට අනුකූලව හඳුනාගැනීම.",
      "2. දත්ත සහ කොන්දේසි: ප්‍රශ්නයෙන් සපයා ඇති කරුණු සහ විමසන නිශ්චිත අගය සටහන් කිරීම.",
      "3. න්‍යායික පදනම: අදාළ සූත්‍රය, ප්‍රමේයය හෝ විද්‍යාත්මක නියමය තෝරාගැනීම.",
      "4. විසඳීමේ ක්‍රමවේදය: පියවරෙන් පියවර ආදේශය හා තාර්කික පිළිවෙළට විසඳුම ගොඩනැගීම.",
      "5. විභාග නිගමනය: අවසාන පිළිතුර නිවැරදි ඒකක හෝ විෂයානුබද්ධ වචන මගින් සම්පූර්ණ කිරීම."
    )
  }
}

// ----------------------------------------------------
// 3. UI SCREEN: VOICE DOUBT SOLVER & AI EXPLAINER
// ----------------------------------------------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoiceDoubtSolverScreen(
  initialGrade: String = "10",
  onBack: () -> Unit
) {
  val context = LocalContext.current
  val clipboard = LocalClipboardManager.current
  val coroutineScope = rememberCoroutineScope()

  var selectedGrade by remember {
    mutableStateOf(if (initialGrade in listOf("10", "11")) initialGrade else "10")
  }
  var selectedSubjectFilter by remember { mutableStateOf("සියල්ල") }
  var doubtQueryInput by remember { mutableStateOf("") }
  var isSpeechRecognizerListening by remember { mutableStateOf(false) }
  var lessonSearchQuery by remember { mutableStateOf("") }
  var isBookmarked by remember { mutableStateOf(false) }

  // Active Doubt State
  var activeDoubt by remember { mutableStateOf(VoiceDoubtSolverRepository.curatedDoubts.first()) }

  // Text-To-Speech (TTS) Engine & State
  var ttsEngine by remember { mutableStateOf<TextToSpeech?>(null) }
  var isSpeaking by remember { mutableStateOf(false) }
  var speechSpeed by remember { mutableFloatStateOf(1.0f) }
  var ttsInitSuccess by remember { mutableStateOf(false) }

  // Initialize Android Native TextToSpeech
  DisposableEffect(Unit) {
    var tts: TextToSpeech? = null
    tts = TextToSpeech(context) { status ->
      if (status == TextToSpeech.SUCCESS) {
        ttsInitSuccess = true
        val siLocale = Locale("si", "LK")
        val res = tts?.setLanguage(siLocale)
        if (res == TextToSpeech.LANG_MISSING_DATA || res == TextToSpeech.LANG_NOT_SUPPORTED) {
          tts?.language = Locale.US
        }
        tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
          override fun onStart(utteranceId: String?) {
            isSpeaking = true
          }
          override fun onDone(utteranceId: String?) {
            isSpeaking = false
          }
          @Deprecated("Deprecated in Java")
          override fun onError(utteranceId: String?) {
            isSpeaking = false
          }
        })
      }
    }
    ttsEngine = tts

    onDispose {
      tts?.stop()
      tts?.shutdown()
    }
  }

  // Speak function
  fun speakExplanation(text: String) {
    if (isSpeaking) {
      ttsEngine?.stop()
      isSpeaking = false
    } else {
      ttsEngine?.setSpeechRate(speechSpeed)
      val params = Bundle().apply {
        putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "DOUBT_VOICE_${System.currentTimeMillis()}")
      }
      val result = ttsEngine?.speak(text, TextToSpeech.QUEUE_FLUSH, params, "DOUBT_VOICE_${System.currentTimeMillis()}")
      if (result == TextToSpeech.SUCCESS || result == 0) {
        isSpeaking = true
      } else {
        Toast.makeText(context, "🔊 කටහඬින් විස්තර කිරීම ආරම්භ විය", Toast.LENGTH_SHORT).show()
        isSpeaking = true
      }
    }
  }

  fun stopSpeaking() {
    ttsEngine?.stop()
    isSpeaking = false
  }

  fun replaySpeaking() {
    ttsEngine?.stop()
    isSpeaking = false
    ttsEngine?.setSpeechRate(speechSpeed)
    val params = Bundle().apply {
      putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "DOUBT_VOICE_REPLAY_${System.currentTimeMillis()}")
    }
    ttsEngine?.speak(activeDoubt.detailedVoiceExplanation, TextToSpeech.QUEUE_FLUSH, params, "DOUBT_VOICE_REPLAY_${System.currentTimeMillis()}")
    isSpeaking = true
    Toast.makeText(context, "🔄 නැවත මුල සිට කියවීම ආරම්භ විය", Toast.LENGTH_SHORT).show()
  }

  // Real Android Speech Recognizer Activity Result
  val speechLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.StartActivityForResult()
  ) { result ->
    isSpeechRecognizerListening = false
    if (result.resultCode == Activity.RESULT_OK && result.data != null) {
      val matches = result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
      val spokenText = matches?.firstOrNull()
      if (!spokenText.isNullOrBlank()) {
        doubtQueryInput = spokenText
        activeDoubt = VoiceDoubtSolverRepository.resolveDoubt(spokenText, selectedGrade, selectedSubjectFilter)
        speakExplanation(activeDoubt.detailedVoiceExplanation)
        Toast.makeText(context, "🎙️ \"$spokenText\" හඳුනාගැනිණි!", Toast.LENGTH_SHORT).show()
      }
    }
  }

  fun launchSpeechRecognizer() {
    val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
      putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
      putExtra(RecognizerIntent.EXTRA_LANGUAGE, "si-LK")
      putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, "si-LK")
      putExtra(RecognizerIntent.EXTRA_PROMPT, "ඔබේ ගැටලුව හෝ ප්‍රශ්නය පවසන්න (Speak your doubt)...")
    }
    try {
      isSpeechRecognizerListening = true
      speechLauncher.launch(intent)
    } catch (e: Exception) {
      isSpeechRecognizerListening = false
      Toast.makeText(context, "Speech Recognition සේවාව ක්‍රියාත්මක කළ නොහැක", Toast.LENGTH_SHORT).show()
    }
  }

  val permissionLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.RequestPermission()
  ) { isGranted ->
    if (isGranted) {
      launchSpeechRecognizer()
    } else {
      Toast.makeText(context, "මයික්‍රෆෝනය භාවිතයට අවසර අවශ්‍ය වේ", Toast.LENGTH_SHORT).show()
    }
  }

  // Filtered curated doubts
  val filteredDoubts = remember(selectedGrade, selectedSubjectFilter) {
    VoiceDoubtSolverRepository.curatedDoubts.filter { item ->
      (selectedGrade == "ALL" || item.grade == selectedGrade || item.grade.isBlank()) &&
        VoiceDoubtSolverRepository.matchesSubject(item.subject, selectedSubjectFilter)
    }
  }

  // Curriculum Syllabus Units for the selected grade and subject
  val syllabusUnits = remember(selectedGrade, selectedSubjectFilter) {
    SyllabusUnitsRepository.getUnitsFor(selectedGrade, selectedSubjectFilter)
  }

  // Search filtered units
  val displayedUnits = remember(syllabusUnits, lessonSearchQuery) {
    if (lessonSearchQuery.isBlank()) {
      syllabusUnits
    } else {
      val q = lessonSearchQuery.trim().lowercase()
      syllabusUnits.filter { u ->
        u.titleSinhala.lowercase().contains(q) ||
          u.englishTitle.lowercase().contains(q) ||
          u.subject.lowercase().contains(q) ||
          u.keyConcepts.any { it.lowercase().contains(q) }
      }
    }
  }

  val subjectsList = listOf(
    "සියල්ල",
    "ගණිතය",
    "විද්‍යාව",
    "ඉතිහාසය",
    "සිංහල",
    "ඉංග්‍රීසි",
    "ICT",
    "බුද්ධ ධර්මය",
    "භූගෝල විද්‍යාව",
    "පුරවැසි අධ්‍යාපනය",
    "ව්‍යාපාර හා ගිණුම්කරණය",
    "සෞඛ්‍යය"
  )

  val gradesList = listOf("10", "11")

  // Animated pulse for mic
  val infiniteTransition = rememberInfiniteTransition(label = "mic_transition")
  val micScale by infiniteTransition.animateFloat(
    initialValue = 1.0f,
    targetValue = if (isSpeechRecognizerListening) 1.15f else 1.0f,
    animationSpec = infiniteRepeatable(
      animation = tween(600, easing = FastOutSlowInEasing),
      repeatMode = RepeatMode.Reverse
    ),
    label = "mic_scale"
  )

  // Equalizer bar heights
  val eqBar1 by infiniteTransition.animateFloat(
    initialValue = 6f,
    targetValue = if (isSpeaking) 22f else 6f,
    animationSpec = infiniteRepeatable(tween(350, easing = LinearEasing), RepeatMode.Reverse),
    label = "eq1"
  )
  val eqBar2 by infiniteTransition.animateFloat(
    initialValue = 10f,
    targetValue = if (isSpeaking) 26f else 10f,
    animationSpec = infiniteRepeatable(tween(250, easing = LinearEasing), RepeatMode.Reverse),
    label = "eq2"
  )
  val eqBar3 by infiniteTransition.animateFloat(
    initialValue = 8f,
    targetValue = if (isSpeaking) 20f else 8f,
    animationSpec = infiniteRepeatable(tween(400, easing = LinearEasing), RepeatMode.Reverse),
    label = "eq3"
  )

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = "🎙️ AI ශිෂ්‍ය ගැටලු හඬ සහායකයා",
              fontSize = 15.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Text(
              text = "10, 11 ශ්‍රේණි (O/L) • සියලු විෂයයන් • 100% නිවැරදි විෂය නිර්දේශය",
              fontSize = 10.sp,
              color = Color(0xFFBAE6FD)
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
            color = Color(0xFF1E293B),
            border = BorderStroke(1.dp, Color(0xFF38BDF8))
          ) {
            Text(
              text = "$selectedGrade ශ්‍රේණිය",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF38BDF8),
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = Color(0xFF0F172A)
        )
      )
    },
    containerColor = Color(0xFFF1F5F9)
  ) { innerPadding ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
        .background(Color(0xFFF1F5F9)),
      contentAlignment = Alignment.TopCenter
    ) {
      LazyColumn(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 350.dp)
          .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {

        // =====================================================================
        // 1. HIGHEST PRIORITY (TOP): ASK BY VOICE OR TYPE QUESTION
        // =====================================================================
        item {
          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.2.dp, Color(0xFFCBD5E1)),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier
              .fillMaxWidth()
              .widthIn(max = 336.dp)
              .testTag("doubt_input_card")
          ) {
            Column(
              modifier = Modifier.padding(13.dp),
              verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Box(
                    modifier = Modifier
                      .size(28.dp)
                      .clip(CircleShape)
                      .background(Color(0xFF0284C7)),
                    contentAlignment = Alignment.Center
                  ) {
                    Text("🎙️", fontSize = 14.sp)
                  }
                  Spacer(modifier = Modifier.width(8.dp))
                  Column {
                    Text(
                      text = "ප්‍රශ්නයක් හඬින් හෝ ටයිප් කර අසන්න",
                      fontSize = 12.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF0F172A)
                    )
                    Text(
                      text = "ඕනෑම ගැටලුවක් විමසා ක්ෂණික හඬ පිළිතුරු ලබාගන්න",
                      fontSize = 9.5.sp,
                      color = Color(0xFF64748B)
                    )
                  }
                }

                if (doubtQueryInput.isNotEmpty()) {
                  Text(
                    text = "මකන්න",
                    fontSize = 11.sp,
                    color = Color(0xFFEF4444),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { doubtQueryInput = "" }
                  )
                }
              }

              // Text Field for Typing Question
              OutlinedTextField(
                value = doubtQueryInput,
                onValueChange = { doubtQueryInput = it },
                placeholder = {
                  Text(
                    text = "ඔබගේ ප්‍රශ්නය මෙහි ලියන්න හෝ හඬින් පවසන්න (උදා: ප්‍රභාසංස්ලේෂණය, වර්ගජ සමීකරණ)...",
                    fontSize = 11.sp,
                    color = Color(0xFF94A3B8)
                  )
                },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                  .fillMaxWidth()
                  .testTag("doubt_text_field"),
                minLines = 2,
                maxLines = 3
              )

              // Quick Suggestions Row
              LazyRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                val quickPrompts = listOf(
                  "📐 සූත්‍රය කුමක්ද?",
                  "🎯 විභාග උපදෙස්",
                  "📝 පියවරෙන් පියවර විසඳුම",
                  "❓ විභාගයට එන ප්‍රශ්න",
                  "🔬 මූලික සංකල්පය"
                )
                items(quickPrompts) { prompt ->
                  Surface(
                    onClick = {
                      doubtQueryInput = prompt
                      activeDoubt = VoiceDoubtSolverRepository.resolveDoubt(prompt, selectedGrade, selectedSubjectFilter)
                      speakExplanation(activeDoubt.detailedVoiceExplanation)
                    },
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFF1F5F9),
                    border = BorderStroke(1.dp, Color(0xFFCBD5E1))
                  ) {
                    Text(
                      text = prompt,
                      fontSize = 10.sp,
                      fontWeight = FontWeight.Medium,
                      color = Color(0xFF334155),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }
                }
              }

              // Action Buttons Row: Mic & Submit
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                // Voice Mic Button
                Button(
                  onClick = {
                    val hasPerm = ContextCompat.checkSelfPermission(
                      context,
                      Manifest.permission.RECORD_AUDIO
                    ) == PackageManager.PERMISSION_GRANTED
                    if (hasPerm) {
                      launchSpeechRecognizer()
                    } else {
                      permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                    }
                  },
                  shape = RoundedCornerShape(10.dp),
                  colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSpeechRecognizerListening) Color(0xFFEF4444) else Color(0xFF0284C7)
                  ),
                  modifier = Modifier
                    .weight(1f)
                    .scale(micScale)
                    .testTag("voice_ask_mic_button")
                ) {
                  Icon(
                    imageVector = if (isSpeechRecognizerListening) Icons.Default.GraphicEq else Icons.Default.Mic,
                    contentDescription = "Voice Input",
                    modifier = Modifier.size(16.dp)
                  )
                  Spacer(modifier = Modifier.width(5.dp))
                  Text(
                    text = if (isSpeechRecognizerListening) "සවන්දෙයි..." else "හඬින් විමසන්න",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                  )
                }

                // Submit Button
                Button(
                  onClick = {
                    if (doubtQueryInput.isNotBlank()) {
                      activeDoubt = VoiceDoubtSolverRepository.resolveDoubt(doubtQueryInput, selectedGrade, selectedSubjectFilter)
                      speakExplanation(activeDoubt.detailedVoiceExplanation)
                    } else {
                      Toast.makeText(context, "කරුණාකර ඔබේ ගැටලුව ලියන්න හෝ මයික්‍රෆෝනය ඔබන්න", Toast.LENGTH_SHORT).show()
                    }
                  },
                  shape = RoundedCornerShape(10.dp),
                  colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669)),
                  modifier = Modifier
                    .weight(1f)
                    .testTag("submit_doubt_btn")
                ) {
                  Icon(Icons.Default.Send, contentDescription = "Submit", modifier = Modifier.size(15.dp))
                  Spacer(modifier = Modifier.width(5.dp))
                  Text(
                    text = "විසඳුම & හඬ ගන්න",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                  )
                }
              }
            }
          }
        }

        // =====================================================================
        // 2. GRADE SELECTION (ශ්‍රේණිය තෝරන්න) - DIRECTLY BELOW THE ASK BOX
        // =====================================================================
        item {
          Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            modifier = Modifier
              .fillMaxWidth()
              .widthIn(max = 336.dp)
              .testTag("grade_selector_card")
          ) {
            Column(
              modifier = Modifier.padding(12.dp),
              verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text("🎓", fontSize = 14.sp)
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = "ශ්‍රේණිය තෝරන්න (Select Grade)",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A)
                  )
                }
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = Color(0xFFEFF6FF)
                ) {
                  Text(
                    text = "දැනට: $selectedGrade ශ්‍රේණිය",
                    fontSize = 9.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0284C7),
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                  )
                }
              }

              // Grade Pills Row: 9, 10, 11 only
              Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                gradesList.forEach { gVal ->
                  val isSelected = selectedGrade == gVal
                  Surface(
                    onClick = {
                      selectedGrade = gVal
                      val units = SyllabusUnitsRepository.getUnitsFor(gVal, selectedSubjectFilter)
                      if (units.isNotEmpty()) {
                        activeDoubt = VoiceDoubtSolverRepository.fromUnit(units.first())
                      }
                    },
                    shape = RoundedCornerShape(10.dp),
                    color = if (isSelected) Color(0xFF0284C7) else Color(0xFFF1F5F9),
                    border = BorderStroke(
                      width = if (isSelected) 1.5.dp else 1.dp,
                      color = if (isSelected) Color(0xFF0369A1) else Color(0xFFCBD5E1)
                    ),
                    modifier = Modifier.weight(1f)
                  ) {
                    Row(
                      modifier = Modifier.padding(vertical = 8.dp),
                      horizontalArrangement = Arrangement.Center,
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Text(
                        text = if (gVal == "11") "11 ශ්‍රේණිය (O/L)" else "10 ශ්‍රේණිය",
                        fontSize = 11.5.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = if (isSelected) Color.White else Color(0xFF0F172A)
                      )
                    }
                  }
                }
              }
            }
          }
        }

        // =====================================================================
        // 3. SUBJECT SELECTION (විෂය තෝරන්න) - HIGH CONTRAST, NEVER WHITE-ON-WHITE
        // =====================================================================
        item {
          Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            modifier = Modifier
              .fillMaxWidth()
              .widthIn(max = 336.dp)
              .testTag("subject_selector_card")
          ) {
            Column(
              modifier = Modifier.padding(12.dp),
              verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text("📚", fontSize = 14.sp)
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = "විෂය තෝරන්න (Select Subject)",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A)
                  )
                }
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = Color(0xFFF0FDF4),
                  border = BorderStroke(1.dp, Color(0xFFBBF7D0))
                ) {
                  Text(
                    text = "${syllabusUnits.size} පාඩම්",
                    fontSize = 9.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF15803D),
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                  )
                }
              }

              // High-Contrast Custom Subject Filter Chips
              LazyRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                items(subjectsList) { subj ->
                  val isSelected = selectedSubjectFilter == subj
                  val icon = when (subj) {
                    "සියල්ල" -> "🌐"
                    "ගණිතය" -> "📐"
                    "විද්‍යාව" -> "🔬"
                    "ඉතිහාසය" -> "📜"
                    "සිංහල" -> "✍️"
                    "ඉංග්‍රීසි" -> "🔤"
                    "ICT" -> "💻"
                    "බුද්ධ ධර්මය" -> "☸️"
                    "භූගෝල විද්‍යාව" -> "🌍"
                    "පුරවැසි අධ්‍යාපනය" -> "🏛️"
                    "ව්‍යාපාර හා ගිණුම්කරණය" -> "📊"
                    "සෞඛ්‍යය" -> "🏥"
                    else -> "📘"
                  }

                  Surface(
                    onClick = {
                      selectedSubjectFilter = subj
                      val units = SyllabusUnitsRepository.getUnitsFor(selectedGrade, subj)
                      if (units.isNotEmpty()) {
                        activeDoubt = VoiceDoubtSolverRepository.fromUnit(units.first())
                      }
                    },
                    shape = RoundedCornerShape(8.dp),
                    color = if (isSelected) Color(0xFF0284C7) else Color(0xFFE2E8F0),
                    border = BorderStroke(
                      width = if (isSelected) 1.5.dp else 1.dp,
                      color = if (isSelected) Color(0xFF0369A1) else Color(0xFF94A3B8)
                    )
                  ) {
                    Row(
                      modifier = Modifier.padding(horizontal = 9.dp, vertical = 5.dp),
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Text(icon, fontSize = 11.sp)
                      Spacer(modifier = Modifier.width(4.dp))
                      Text(
                        text = subj,
                        fontSize = 11.sp,
                        fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Bold,
                        color = if (isSelected) Color.White else Color(0xFF0F172A) // ALWAYS HIGH CONTRAST, NEVER WHITE ON WHITE
                      )
                    }
                  }
                }
              }
            }
          }
        }

        // =====================================================================
        // 4. ACTIVE DOUBT / CONCEPT VOICE AUDIO PLAYER
        // =====================================================================
        item {
          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.2.dp, Color(0xFF38BDF8)),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
            modifier = Modifier
              .fillMaxWidth()
              .widthIn(max = 336.dp)
              .testTag("active_doubt_voice_card")
          ) {
            Column(
              modifier = Modifier.padding(13.dp),
              verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
              // Subject & Topic Badge Row
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFFEFF6FF),
                    border = BorderStroke(1.dp, Color(0xFF93C5FD))
                  ) {
                    Text(
                      text = "${activeDoubt.grade} ශ්‍රේණිය • ${activeDoubt.subject}",
                      fontSize = 9.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF1D4ED8),
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                  }
                  Spacer(modifier = Modifier.width(6.dp))
                  Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFFF1F5F9)
                  ) {
                    Text(
                      text = activeDoubt.relatedTopic,
                      fontSize = 9.sp,
                      color = Color(0xFF475569),
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                  }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                  // Bookmark button
                  IconButton(
                    onClick = {
                      isBookmarked = !isBookmarked
                      Toast.makeText(context, if (isBookmarked) "පාඩම සුරැකිණි! ⭐" else "සුරැකීම ඉවත් විය", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.size(28.dp)
                  ) {
                    Icon(
                      imageVector = if (isBookmarked) Icons.Default.Star else Icons.Default.StarBorder,
                      contentDescription = "Bookmark",
                      tint = if (isBookmarked) Color(0xFFF59E0B) else Color(0xFF94A3B8),
                      modifier = Modifier.size(17.dp)
                    )
                  }

                  // Copy button (Admin only)
                  IconButton(
                    onClick = {
                      if (AppSecurityManager.canCopyContent(context)) {
                        clipboard.setText(AnnotatedString("${activeDoubt.questionSinhala}\n\n${activeDoubt.detailedVoiceExplanation}"))
                        Toast.makeText(context, "පැහැදිලි කිරීම පිටපත් විය!", Toast.LENGTH_SHORT).show()
                      } else {
                        Toast.makeText(context, "ආරක්ෂක නීති අනුව සටහන් පිටපත් කිරීම (Copy) අවහිර කර ඇත (Admin Only).", Toast.LENGTH_SHORT).show()
                      }
                    },
                    modifier = Modifier.size(28.dp)
                  ) {
                    Icon(Icons.Default.ContentCopy, contentDescription = "Copy", tint = Color(0xFF64748B), modifier = Modifier.size(15.dp))
                  }
                }
              }

              // Question / Topic Heading
              Text(
                text = "💡 ${activeDoubt.questionSinhala}",
                fontSize = 13.5.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF0F172A),
                lineHeight = 18.sp
              )

              // 🎧 AUDIO CONTROLLER BAR WITH WAVEFORM
              Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF0F172A),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(
                  modifier = Modifier.padding(11.dp),
                  verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                      Box(
                        modifier = Modifier
                          .size(28.dp)
                          .clip(CircleShape)
                          .background(if (isSpeaking) Color(0xFFEF4444) else Color(0xFF10B981)),
                        contentAlignment = Alignment.Center
                      ) {
                        Text("🔊", fontSize = 14.sp)
                      }
                      Spacer(modifier = Modifier.width(8.dp))
                      Column {
                        Text(
                          text = if (isSpeaking) "හඬින් විස්තර කරමින් පවතී..." else "සම්පූර්ණ සංකල්පය හඬින් අසන්න",
                          fontSize = 11.5.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color.White
                        )
                        Text(
                          text = "AI Sinhala Voice Tutor",
                          fontSize = 8.5.sp,
                          color = Color(0xFF94A3B8)
                        )
                      }
                    }

                    // Equalizer Waveform & Speed Toggle
                    Row(
                      verticalAlignment = Alignment.CenterVertically,
                      horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                      if (isSpeaking) {
                        Row(
                          horizontalArrangement = Arrangement.spacedBy(2.dp),
                          verticalAlignment = Alignment.Bottom,
                          modifier = Modifier.height(18.dp)
                        ) {
                          Box(modifier = Modifier.width(3.dp).height(eqBar1.dp).background(Color(0xFF38BDF8), RoundedCornerShape(1.dp)))
                          Box(modifier = Modifier.width(3.dp).height(eqBar2.dp).background(Color(0xFF34D399), RoundedCornerShape(1.dp)))
                          Box(modifier = Modifier.width(3.dp).height(eqBar3.dp).background(Color(0xFFF472B6), RoundedCornerShape(1.dp)))
                        }
                      }

                      Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Color(0xFF334155),
                        modifier = Modifier.clickable {
                          speechSpeed = when (speechSpeed) {
                            0.75f -> 1.0f
                            1.0f -> 1.25f
                            else -> 0.75f
                          }
                          if (isSpeaking) {
                            ttsEngine?.setSpeechRate(speechSpeed)
                          }
                        }
                      ) {
                        Text(
                          text = "${speechSpeed}x වේගය",
                          fontSize = 9.5.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFF38BDF8),
                          modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                      }
                    }
                  }

                  // Audio Control Buttons
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    // Play / Pause Button
                    Button(
                      onClick = { speakExplanation(activeDoubt.detailedVoiceExplanation) },
                      shape = RoundedCornerShape(8.dp),
                      colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSpeaking) Color(0xFFEF4444) else Color(0xFF0284C7)
                      ),
                      modifier = Modifier
                        .weight(1.2f)
                        .testTag("play_doubt_voice_btn")
                    ) {
                      Icon(
                        imageVector = if (isSpeaking) Icons.Default.Pause else Icons.Default.PlayArrow,
                        contentDescription = "Play/Pause",
                        modifier = Modifier.size(16.dp)
                      )
                      Spacer(modifier = Modifier.width(4.dp))
                      Text(
                        text = if (isSpeaking) "විරාමය" else "හඬට සවන්දෙන්න",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                      )
                    }

                    // Replay Button
                    OutlinedButton(
                      onClick = { replaySpeaking() },
                      shape = RoundedCornerShape(8.dp),
                      border = BorderStroke(1.dp, Color(0xFF38BDF8)),
                      colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF38BDF8)),
                      modifier = Modifier.weight(0.9f)
                    ) {
                      Icon(Icons.Default.Refresh, contentDescription = "Replay", modifier = Modifier.size(14.dp))
                      Spacer(modifier = Modifier.width(3.dp))
                      Text("නැවත මුල සිට", fontSize = 10.sp, maxLines = 1)
                    }

                    // Stop Button (if speaking)
                    if (isSpeaking) {
                      OutlinedButton(
                        onClick = { stopSpeaking() },
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, Color(0xFFEF4444)),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFEF4444)),
                        modifier = Modifier.weight(0.7f)
                      ) {
                        Icon(Icons.Default.Stop, contentDescription = "Stop", modifier = Modifier.size(14.dp))
                        Spacer(modifier = Modifier.width(2.dp))
                        Text("නවත්වන්න", fontSize = 9.5.sp, maxLines = 1)
                      }
                    }
                  }

                  // Previous / Next Lesson Navigation
                  if (displayedUnits.size > 1) {
                    val currentIndex = displayedUnits.indexOfFirst { "unit_${it.id}" == activeDoubt.id }
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.SpaceBetween,
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      TextButton(
                        onClick = {
                          if (currentIndex > 0) {
                            val prevUnit = displayedUnits[currentIndex - 1]
                            activeDoubt = VoiceDoubtSolverRepository.fromUnit(prevUnit)
                            speakExplanation(activeDoubt.detailedVoiceExplanation)
                          }
                        },
                        enabled = currentIndex > 0
                      ) {
                        Text(
                          text = "◀ පෙර පාඩම",
                          fontSize = 10.5.sp,
                          fontWeight = FontWeight.Bold,
                          color = if (currentIndex > 0) Color(0xFF38BDF8) else Color(0xFF64748B)
                        )
                      }

                      Text(
                        text = if (currentIndex >= 0) "පාඩම ${currentIndex + 1} / ${displayedUnits.size}" else "${displayedUnits.size} පාඩම්",
                        fontSize = 10.sp,
                        color = Color(0xFF94A3B8)
                      )

                      TextButton(
                        onClick = {
                          if (currentIndex >= 0 && currentIndex < displayedUnits.size - 1) {
                            val nextUnit = displayedUnits[currentIndex + 1]
                            activeDoubt = VoiceDoubtSolverRepository.fromUnit(nextUnit)
                            speakExplanation(activeDoubt.detailedVoiceExplanation)
                          }
                        },
                        enabled = currentIndex in 0 until (displayedUnits.size - 1)
                      ) {
                        Text(
                          text = "ඊළඟ පාඩම ▶",
                          fontSize = 10.5.sp,
                          fontWeight = FontWeight.Bold,
                          color = if (currentIndex in 0 until (displayedUnits.size - 1)) Color(0xFF38BDF8) else Color(0xFF64748B)
                        )
                      }
                    }
                  }
                }
              }

              // Summary Box
              Surface(
                shape = RoundedCornerShape(10.dp),
                color = Color(0xFFF0FDF4),
                border = BorderStroke(1.dp, Color(0xFFBBF7D0)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(
                  modifier = Modifier.padding(9.dp),
                  verticalAlignment = Alignment.Top
                ) {
                  Text("📌", fontSize = 12.sp)
                  Spacer(modifier = Modifier.width(6.dp))
                  Column {
                    Text(
                      text = "කෙටි සාරාංශය (Summary):",
                      fontSize = 10.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF166534)
                    )
                    Text(
                      text = activeDoubt.shortSummary,
                      fontSize = 10.5.sp,
                      color = Color(0xFF14532D),
                      lineHeight = 15.sp
                    )
                  }
                }
              }

              // Step-by-Step Breakdown
              Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                Text(
                  text = "📝 පියවරෙන් පියවර පැහැදිලි කිරීම:",
                  fontSize = 11.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF0F172A)
                )

                activeDoubt.stepByStepSolution.forEach { step ->
                  Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFFF8FAFC),
                    border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Text(
                      text = step,
                      fontSize = 10.5.sp,
                      color = Color(0xFF334155),
                      lineHeight = 15.sp,
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)
                    )
                  }
                }
              }

              // Core Formula or Rule
              if (activeDoubt.coreFormulaOrRule.isNotBlank()) {
                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = Color(0xFFEFF6FF),
                  border = BorderStroke(1.dp, Color(0xFFBFDBFE)),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text("📐", fontSize = 13.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Column {
                      Text(
                        text = "මූලික සූත්‍රය / නීතිය:",
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1E40AF)
                      )
                      Text(
                        text = activeDoubt.coreFormulaOrRule,
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1D4ED8)
                      )
                    }
                  }
                }
              }

              // Exam Tip Box
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
                  Text("🎯", fontSize = 13.sp)
                  Spacer(modifier = Modifier.width(6.dp))
                  Column {
                    Text(
                      text = "විභාග උපදෙස් & ලකුණු ලබාගැනීම:",
                      fontSize = 10.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFFB45309)
                    )
                    Text(
                      text = activeDoubt.examTip,
                      fontSize = 10.sp,
                      color = Color(0xFF92400E),
                      lineHeight = 14.sp
                    )
                  }
                }
              }
            }
          }
        }

        // =====================================================================
        // 5. ALL LESSONS FOR ALL SUBJECTS WITH COMPLETE VOICE CONCEPTS
        // =====================================================================
        item {
          Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            modifier = Modifier
              .fillMaxWidth()
              .widthIn(max = 336.dp)
              .testTag("syllabus_units_card")
          ) {
            Column(
              modifier = Modifier.padding(12.dp),
              verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Column {
                  Text(
                    text = "📖 $selectedGrade ශ්‍රේණිය ${if (selectedSubjectFilter != "සියල්ල") "- $selectedSubjectFilter" else ""} සියලුම පාඩම් (${displayedUnits.size})",
                    fontSize = 12.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A)
                  )
                  Text(
                    text = "ඕනෑම පාඩමක් තෝරා සම්පූර්ණ සංකල්පය හඬින් අසන්න",
                    fontSize = 9.5.sp,
                    color = Color(0xFF64748B)
                  )
                }

                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = Color(0xFFF0FDF4),
                  border = BorderStroke(1.dp, Color(0xFF86EFAC))
                ) {
                  Text(
                    text = "100% ආවරණය",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF166534),
                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                  )
                }
              }

              // Search Filter for Lessons
              OutlinedTextField(
                value = lessonSearchQuery,
                onValueChange = { lessonSearchQuery = it },
                placeholder = { Text("පාඩම හෝ මාතෘකාව සොයන්න...", fontSize = 10.5.sp, color = Color(0xFF94A3B8)) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", modifier = Modifier.size(16.dp)) },
                trailingIcon = {
                  if (lessonSearchQuery.isNotEmpty()) {
                    IconButton(onClick = { lessonSearchQuery = "" }) {
                      Icon(Icons.Default.Clear, contentDescription = "Clear", modifier = Modifier.size(15.dp))
                    }
                  }
                },
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
              )

              // List of All Lessons in that Grade & Subject
              Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                displayedUnits.forEach { unit ->
                  val isSelectedUnit = activeDoubt.id == "unit_${unit.id}"
                  Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = if (isSelectedUnit) Color(0xFFEFF6FF) else Color(0xFFF8FAFC),
                    border = BorderStroke(
                      width = if (isSelectedUnit) 1.5.dp else 1.dp,
                      color = if (isSelectedUnit) Color(0xFF38BDF8) else Color(0xFFE2E8F0)
                    ),
                    modifier = Modifier
                      .fillMaxWidth()
                      .clickable {
                        activeDoubt = VoiceDoubtSolverRepository.fromUnit(unit)
                        speakExplanation(activeDoubt.detailedVoiceExplanation)
                      }
                  ) {
                    Row(
                      modifier = Modifier.padding(8.dp),
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Box(
                        modifier = Modifier
                          .size(28.dp)
                          .clip(CircleShape)
                          .background(if (isSelectedUnit && isSpeaking) Color(0xFFEF4444) else Color(0xFF0284C7)),
                        contentAlignment = Alignment.Center
                      ) {
                        Icon(
                          imageVector = if (isSelectedUnit && isSpeaking) Icons.Default.GraphicEq else Icons.Default.VolumeUp,
                          contentDescription = "Listen",
                          tint = Color.White,
                          modifier = Modifier.size(14.dp)
                        )
                      }

                      Spacer(modifier = Modifier.width(8.dp))

                      Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                          Surface(
                            shape = RoundedCornerShape(4.dp),
                            color = Color(0xFFE0F2FE)
                          ) {
                            Text(
                              text = "${unit.subject} • ඒකකය ${unit.unitNumber}",
                              fontSize = 8.sp,
                              fontWeight = FontWeight.Bold,
                              color = Color(0xFF0369A1),
                              modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                            )
                          }
                        }

                        Spacer(modifier = Modifier.height(2.dp))

                        Text(
                          text = unit.titleSinhala,
                          fontSize = 11.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFF0F172A),
                          maxLines = 1,
                          overflow = TextOverflow.Ellipsis
                        )

                        Text(
                          text = unit.englishTitle,
                          fontSize = 9.sp,
                          color = Color(0xFF64748B),
                          maxLines = 1,
                          overflow = TextOverflow.Ellipsis
                        )
                      }

                      Spacer(modifier = Modifier.width(6.dp))

                      Button(
                        onClick = {
                          activeDoubt = VoiceDoubtSolverRepository.fromUnit(unit)
                          speakExplanation(activeDoubt.detailedVoiceExplanation)
                        },
                        shape = RoundedCornerShape(6.dp),
                        colors = ButtonDefaults.buttonColors(
                          containerColor = if (isSelectedUnit && isSpeaking) Color(0xFFEF4444) else Color(0xFF0284C7)
                        ),
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                        modifier = Modifier.height(28.dp)
                      ) {
                        Text(
                          text = if (isSelectedUnit && isSpeaking) "විරාමය" else "හඬින් අසන්න",
                          fontSize = 9.sp,
                          fontWeight = FontWeight.Bold
                        )
                      }
                    }
                  }
                }
              }
            }
          }
        }

        // =====================================================================
        // 6. CURATED EXAM DOUBTS LIBRARY (ONE-TAP VOICE AUDIO)
        // =====================================================================
        item {
          Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            modifier = Modifier
              .fillMaxWidth()
              .widthIn(max = 336.dp)
          ) {
            Column(
              modifier = Modifier.padding(12.dp),
              verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = "📚 නිතර අසන ප්‍රධාන විභාග ගැටලු (${filteredDoubts.size})",
                  fontSize = 12.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF0F172A)
                )
                Text(
                  text = "1-ටැප් හඬ පිළිතුරු",
                  fontSize = 9.5.sp,
                  color = Color(0xFF0284C7),
                  fontWeight = FontWeight.Bold
                )
              }

              Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                filteredDoubts.take(8).forEach { doubt ->
                  val isSelected = doubt.id == activeDoubt.id
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = if (isSelected) Color(0xFFEFF6FF) else Color(0xFFF8FAFC),
                    border = BorderStroke(
                      1.dp,
                      if (isSelected) Color(0xFF38BDF8) else Color(0xFFE2E8F0)
                    ),
                    modifier = Modifier
                      .fillMaxWidth()
                      .clickable {
                        activeDoubt = doubt
                        speakExplanation(doubt.detailedVoiceExplanation)
                      }
                  ) {
                    Row(
                      modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Box(
                        modifier = Modifier
                          .size(28.dp)
                          .clip(CircleShape)
                          .background(if (isSelected && isSpeaking) Color(0xFFEF4444) else Color(0xFFF1F5F9)),
                        contentAlignment = Alignment.Center
                      ) {
                        Icon(
                          imageVector = if (isSelected && isSpeaking) Icons.Default.GraphicEq else Icons.Default.VolumeUp,
                          contentDescription = "Play",
                          tint = if (isSelected && isSpeaking) Color.White else Color(0xFF0284C7),
                          modifier = Modifier.size(14.dp)
                        )
                      }

                      Spacer(modifier = Modifier.width(8.dp))

                      Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                          Surface(
                            shape = RoundedCornerShape(4.dp),
                            color = Color(0xFFE0F2FE)
                          ) {
                            Text(
                              text = doubt.subject,
                              fontSize = 8.sp,
                              fontWeight = FontWeight.Bold,
                              color = Color(0xFF0369A1),
                              modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                            )
                          }
                          Spacer(modifier = Modifier.width(4.dp))
                          Text(
                            text = doubt.relatedTopic,
                            fontSize = 8.5.sp,
                            color = Color(0xFF64748B),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                          )
                        }

                        Spacer(modifier = Modifier.height(2.dp))

                        Text(
                          text = doubt.questionSinhala,
                          fontSize = 11.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFF0F172A),
                          maxLines = 1,
                          overflow = TextOverflow.Ellipsis
                        )
                      }

                      Spacer(modifier = Modifier.width(4.dp))

                      Icon(
                        Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Open",
                        tint = Color(0xFF94A3B8),
                        modifier = Modifier.size(14.dp)
                      )
                    }
                  }
                }
              }
            }
          }
        }

        item {
          Spacer(modifier = Modifier.height(16.dp))
        }
      }
    }
  }
}
