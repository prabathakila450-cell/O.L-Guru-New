package com.example

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ==============================================================================
// 🌟 1. SINHALA LITERATURE & GRAMMAR MASTER VAULT
// ==============================================================================

data class SinhalaLiteratureAppreciation(
  val id: String,
  val title: String,
  val author: String,
  val eraOrSource: String,
  val sampleVerse: String,
  val appreciationGuide: String,
  val examKeyPoints: List<String>
)

val samplePoetryList = listOf(
  SinhalaLiteratureAppreciation(
    id = "selalihini",
    title = "සැළලිහිණි සන්දේශය (විභීෂණ වර්ණනාව)",
    author = "තොටගමුවේ ශ්‍රී රාහුල හිමි",
    eraOrSource = "කෝට්ටේ යුගය (15 වන සියවස)",
    sampleVerse = "සුර රද විමන් සහසැස් බැම නුබ දුහුල\nපෙර මඳ පවන් රැලි ගිලිහෙන රළ අසල\nසිරිබඳ නිති කෙළින උයන්වතු වට කළ\nසුර විඳි විභීෂණ දෙව් රජු බල ලකල",
    appreciationGuide = "තොටගමුවේ ශ්‍රී රාහුල හිමියන් විභීෂණ දේව ප්‍රතිමාව විස්තර කිරීමේදී අලංකාරික භාෂාව, අනුප්‍රාසය සහ ධ්වනිතාර්ථ මනාව උපයෝගී කරගෙන ඇත. දෙවියන්ගේ තේජාන්විත බව සහ කැලණියේ සශ්‍රීකත්වය මැනවින් චිත්‍රණය කෙරේ.",
    examKeyPoints = listOf(
      "රූපක සහ උපමා අලංකාර (උයන්වතු, සයුර, සුර විමන් සම කිරීම)",
      "ශබ්ද මාධුර්යය හා විරිත් සුසංයෝගය (සමුද්‍රඝෝෂ විරිත)",
      "කෝට්ටේ යුගයේ සන්දේශ කාව්‍ය ලක්ෂණ සහ දේව වර්ණනා සම්ප්‍රදාය"
    )
  ),
  SinhalaLiteratureAppreciation(
    id = "guttila",
    title = "ගුත්තිල කාව්‍යය (ගුත්තිල - මූසිල වාදය)",
    author = "වෑත්තෑවේ හිමි",
    eraOrSource = "කෝට්ටේ යුගය",
    sampleVerse = "සිඳු සේ සසල වන - ලොව බලමින් සතුටු වන\nමූසිල ගුරුන් දැක - ගුත්තිල ඇදුරු පැරදුම පතන ලෙද",
    appreciationGuide = "ගුත්තිල ඇදුරුතුමාගේ ප්‍රවීණත්වය සහ මූසිලගේ අකෘතඥභාවය අතර ගැටුම ප්‍රකට කෙරෙන අවස්ථාවකි. ශක්‍ර දේවේන්ද්‍රයාගේ උපකාරයෙන් තත් සිඳී ගියද වීණා නාදය පැතිරවූ අයුරු චමත්කාරජනක ලෙස ඉදිරිපත් කර ඇත.",
    examKeyPoints = listOf(
      "ගුරු ගෞරවය සහ කෘතවේදීත්වය පිළිබඳ උපදේශාත්මක අගය",
      "නාට්‍යමය අවස්ථා නිරූපණය සහ චරිත නිරූපණ කුසලතාව",
      "සරල, ගලායන බස් වහර සහ උපමා භාවිතය"
    )
  ),
  SinhalaLiteratureAppreciation(
    id = "yashodhara",
    title = "යශෝධරාවත (යසෝදරාවන්ගේ ශෝකය)",
    author = "ජන කවියා",
    eraOrSource = "මහනුවර යුගය (ජන කාව්‍ය)",
    sampleVerse = "ලෙන්ගතු කමට සිත තුළ පෙම් පිරී ගියා\nරන්වන් කඳක් හැර වන මැද ඇයි ගියා\nකන්දක් තරම් සිත තුළ බර දරා ගියා\nසන්තක පුතුන් හැර මහණට ඇයි ගියා",
    appreciationGuide = "සිද්ධාර්ථ කුමරුන් අභිනිෂ්ක්‍රමණය කිරීමෙන් පසු යශෝධරා දේවියගේ හදවතේ උපන් සෝකය සහ ස්ත්‍රීත්වයේ වේදනාව ජන කවියා අතිශය සංවේදී ලෙස සහ අව්‍යාජ ජන වහරින් ඉදිරිපත් කර ඇත.",
    examKeyPoints = listOf(
      "ජන කාව්‍ය සම්ප්‍රදායේ අව්‍යාජ හැඟීම් ප්‍රකාශනය",
      "ස්ත්‍රී හදවතක පතිව්‍රතාව සහ අත්හැරීමේ වේදනාව",
      "සරල සිව්පද ආකෘතිය සහ හදවතට කතා කරන ලය"
    )
  )
)

@Composable
fun SinhalaLiteratureFeatureView() {
  var selectedTab by remember { mutableStateOf(0) }
  var showSinhalaPdfReader by remember { mutableStateOf(false) }
  var sinhalaPdfInitialPage by remember { mutableIntStateOf(1) }
  val tabs = listOf("📜 පද්‍ය රසාස්වාද සැලසුම්", "🎭 නාට්‍ය & ගද්‍ය", "✍️ වියරණ නීති", "⚡ සාහිත්‍යය Auto-Checker")

  if (showSinhalaPdfReader) {
    SinhalaShortNotesPdfReaderDialog(
      initialPage = sinhalaPdfInitialPage,
      onDismiss = { showSinhalaPdfReader = false }
    )
  }

  Column(modifier = Modifier.fillMaxSize()) {
    // 🌟 Special Featured Banner: 10 & 11 Sinhala Vichara Dhara (30 Pages & 23 Essays PDF)
    Card(
      shape = RoundedCornerShape(12.dp),
      colors = CardDefaults.cardColors(containerColor = Color(0xFF450A0A)),
      border = BorderStroke(1.2.dp, Color(0xFFEF4444)),
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
      Column(modifier = Modifier.padding(12.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text("📚", fontSize = 18.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "10 & 11 සාහිත්‍යය • විචාර ධාරා (විචාර 23)",
              fontSize = 13.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
          }
          Surface(
            color = Color(0xFFDC2626),
            shape = RoundedCornerShape(4.dp)
          ) {
            Text(
              text = "පිටු 30 PDF සංග්‍රහය",
              color = Color.White,
              fontSize = 9.sp,
              fontWeight = FontWeight.ExtraBold,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = "සාහිත්‍ය සංග්‍රහයේ ඒකක 7 ට අදාළ ආදර්ශ විචාර 23 • උපුටා දැක්වීම් • ලකුණු ලබාදීමේ නිර්ණායක",
          fontSize = 11.sp,
          color = Color(0xFFFECACA),
          lineHeight = 15.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
          Button(
            onClick = {
              sinhalaPdfInitialPage = 1
              showSinhalaPdfReader = true
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 5.dp)
          ) {
            Icon(Icons.Default.PictureAsPdf, contentDescription = "PDF", modifier = Modifier.size(14.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text("පිටු 30ම PDF කියවන්න 📖", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
          }
          OutlinedButton(
            onClick = {
              sinhalaPdfInitialPage = 2
              showSinhalaPdfReader = true
            },
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFFECACA)),
            border = BorderStroke(1.dp, Color(0xFFF87171)),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 5.dp)
          ) {
            Text("විචාර 23 නාමාවලිය 📝", fontSize = 11.sp, fontWeight = FontWeight.Bold)
          }
        }
      }
    }

    LazyRow(
      modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFF1E293B))
        .padding(horizontal = 12.dp, vertical = 8.dp),
      horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      items(tabs.indices.toList()) { idx ->
        val isSelected = selectedTab == idx
        Surface(
          onClick = { selectedTab = idx },
          shape = RoundedCornerShape(12.dp),
          color = if (isSelected) Color(0xFFE11D48) else Color.White.copy(alpha = 0.08f),
          border = BorderStroke(1.dp, if (isSelected) Color(0xFFE11D48) else Color.White.copy(alpha = 0.2f))
        ) {
          Text(
            text = tabs[idx],
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Bold,
            color = if (isSelected) Color.White else Color(0xFFCBD5E1),
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
          )
        }
      }
    }

    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(14.dp)
    ) {
      when (selectedTab) {
        0 -> PoetryAppreciationTab()
        1 -> DramaAndProseTab()
        2 -> GrammarRulesTab()
        3 -> SinhalaLiteratureQuizTab()
      }
    }
  }
}

@Composable
fun PoetryAppreciationTab() {
  LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFFE11D48).copy(alpha = 0.4f))
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text(
            text = "📝 O/L රසාස්වාද ප්‍රශ්නයකට උපරිම ලකුණු ගන්නා ආකෘතිය:",
            color = Color(0xFFFDA4AF),
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp
          )
          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = "1. හැඳින්වීම: කෘතිය, කතුවරයා, යුගය සහ අවස්ථාව කෙටියෙන්.\n2. අන්තර්ගතය: කවියා මතු කරන මූලික අදහස හෝ හැඟීම.\n3. ආකෘතිය හා බස: උපමා, රූපක, ධ්වනිය, අනුප්‍රාසය සහ ඡන්දස්.\n4. නිගමනය: පාඨකයා තුළ ජනනය වන රසය සහ සාධනීය බලපෑම.",
            color = Color(0xFFE2E8F0),
            fontSize = 11.5.sp,
            lineHeight = 17.sp
          )
        }
      }
    }

    items(samplePoetryList) { item ->
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        border = BorderStroke(1.dp, Color(0xFFE11D48).copy(alpha = 0.3f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text(item.title, color = Color.White, fontWeight = FontWeight.ExtraBold, fontSize = 14.sp)
          Text("${item.author} • ${item.eraOrSource}", color = Color(0xFFFDA4AF), fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
          Spacer(modifier = Modifier.height(8.dp))

          Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFF1E293B),
            modifier = Modifier.fillMaxWidth()
          ) {
            Text(
              text = item.sampleVerse,
              color = Color(0xFFFDE68A),
              fontSize = 11.5.sp,
              lineHeight = 16.sp,
              modifier = Modifier.padding(10.dp)
            )
          }

          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = item.appreciationGuide,
            color = Color(0xFFCBD5E1),
            fontSize = 11.sp,
            lineHeight = 16.sp
          )

          Spacer(modifier = Modifier.height(8.dp))
          Text("විභාග විශේෂ කරුණු:", color = Color(0xFF86EFAC), fontSize = 11.sp, fontWeight = FontWeight.Bold)
          item.examKeyPoints.forEach { pt ->
            Text("• $pt", color = Color(0xFFBAE6FD), fontSize = 10.5.sp, lineHeight = 14.sp)
          }
        }
      }
    }
  }
}

@Composable
fun DramaAndProseTab() {
  val proseList = listOf(
    Pair("මනමේ නාට්‍යය (මහාචාර්ය එදිරිවීර සරච්චන්ද්‍ර)", "මනමේ කුමරු සහ වැදි රජු අතර සටනේදී මනමේ කුමරිය අසිපත වැදි රජුට දීම පිටුපස ඇති සංකීර්ණ මනෝභාවයන්, ස්ත්‍රී චිත්ත ස්වභාවය සහ නාට්‍යමය ගීත සාහිත්‍යය."),
    Pair("සිංහබාහු නාට්‍යය", "පිය සෙනෙහස සහ දරුවන්ගේ නිදහස් ලෝකය අතර ඇති වන පරම්පරා ගැටුම (සිංහයා සහ සිංහබාහු). 'ගලන ගඟකි ජීවිතේ' වැනි අර්ථපූර්ණ ගීත මගින් ජීවිත යථාර්ථය ප්‍රකට කිරීම."),
    Pair("මළවුන්ගේ අවුරුදු දා (මහාචාර්ය එදිරිවීර සරච්චන්ද්‍ර)", "දෙවන ලෝක යුද්ධ සමයේ ජපානයේ හිරෝෂිමා නගරය සහ නොරිකෝ සං සංවේදී චරිතය ඇසුරින් මරණය, ආදරය සහ වියෝව මනෝවිද්‍යාත්මකව විග්‍රහ කිරීම.")
  )

  LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
    items(proseList) { item ->
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFFE11D48).copy(alpha = 0.4f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text(item.first, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 13.5.sp)
          Spacer(modifier = Modifier.height(6.dp))
          Text(item.second, color = Color(0xFFCBD5E1), fontSize = 11.5.sp, lineHeight = 16.sp)
        }
      }
    }
  }
}

@Composable
fun GrammarRulesTab() {
  val grammarRules = listOf(
    "1. උක්ත ආඛ්‍යාත පද සම්බන්ධය" to "උක්තය ඒකවචන නම් ආඛ්‍යාතය ඒකවචන විය යුතුය. උක්තය බහුවචන නම් ආඛ්‍යාතය බහුවචන විය යුතුය.\nඋදා: ළමයා පාඩම් කරයි (ඒක). ළමයි පාඩම් කරති (බහු).",
    "2. න/ණ සහ ල/ළ භාවිතය" to "මූර්ධජ 'ණ' සහ 'ළ' යෙදෙන්නේ නිශ්චිත නීති රීතිවලට අනුවය. (උදා: කාරණ, ලකුණ, කිණිහිර, කීළ, ළමයා). 'ර' හෝ 'ෂ' කාරයට පසුව සාමාන්‍යයෙන් මූර්ධජ 'ණ' යෙදේ (වර්ණ, තෘෂ්ණා).",
    "3. විභක්ති 09 සහ ප්‍රත්‍ය" to "ප්‍රථමා (උක්ත), කර්ම (අනුක්ත), කර්තෘ, කරණ, සම්ප්‍රදාන, අපාදාන, සම්බන්‍ධ, ආධාර, ආලෝපන විභක්ති.",
    "4. කර්මකාරක වාක්‍ය රීතිය" to "කර්මය උක්ත වේ (ප්‍රථමා විභක්තියෙන්). කර්තෘ අනුක්ත වේ (තෘතීයා විභක්තියෙන්). ආඛ්‍යාතය 'ලබයි / ලබති / ලැබුණි' ලෙස යෙදේ.\nඋදා: ගොවියා විසින් කෙත අස්වද්දනු ලැබේ."
  )

  LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
    items(grammarRules) { rule ->
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.3f))
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Text(rule.first, color = Color(0xFF38BDF8), fontWeight = FontWeight.Bold, fontSize = 13.sp)
          Spacer(modifier = Modifier.height(4.dp))
          Text(rule.second, color = Color.White, fontSize = 11.sp, lineHeight = 16.sp)
        }
      }
    }
  }
}

@Composable
fun SinhalaLiteratureQuizTab() {
  val questions = listOf(
    Triple(
      "සැළලිහිණි සන්දේශයේ කතුවරයා කවුරුන්ද?",
      listOf("වීදාගම මෛත්‍රිය හිමි", "තොටගමුවේ ශ්‍රී රාහුල හිමි", "වෑත්තෑවේ හිමි", "අලගියවන්න මුකවෙටි"),
      1
    ),
    Triple(
      "මනමේ නාට්‍යයේ මනමේ කුමරිය කාගේ චරිතය නිරූපණය කරයිද?",
      listOf("ස්ත්‍රී චිත්ත ස්වභාවය හා ගැටුම", "රාජකීය උඩඟුකම", "ද්‍රෝහී බව පමණක්", "යුදකාමීත්වය"),
      0
    ),
    Triple(
      "පහත සඳහන් වාක්‍යවලින් නිවැරදි උක්ත ආඛ්‍යාත සබඳතාව සහිත වාක්‍යය තෝරන්න:",
      listOf("ශිෂ්‍යයෝ විභාගයට ලියයි", "ගුරුවරයා පාඩම කියා දෙති", "ගොවියෝ කෙත නෙළති", "අම්මා බත් පිසූහ"),
      2
    )
  )

  val userAnswers = remember { mutableStateMapOf<Int, Int>() }

  LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
    items(questions.indices.toList()) { idx ->
      val q = questions[idx]
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFFE11D48).copy(alpha = 0.4f))
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text("ප්‍රශ්නය ${idx + 1}: ${q.first}", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 13.sp)
          Spacer(modifier = Modifier.height(8.dp))
          q.second.forEachIndexed { optIdx, optText ->
            val isSelected = userAnswers[idx] == optIdx
            val isCorrect = optIdx == q.third
            Surface(
              onClick = { userAnswers[idx] = optIdx },
              shape = RoundedCornerShape(8.dp),
              color = if (isSelected) (if (isCorrect) Color(0xFF10B981) else Color(0xFFEF4444)).copy(alpha = 0.3f) else Color.White.copy(alpha = 0.05f),
              border = BorderStroke(1.dp, if (isSelected) (if (isCorrect) Color(0xFF10B981) else Color(0xFFEF4444)) else Color.White.copy(alpha = 0.1f)),
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 3.dp)
            ) {
              Text(
                text = "(${optIdx + 1}) $optText",
                color = Color.White,
                fontSize = 11.5.sp,
                modifier = Modifier.padding(8.dp)
              )
            }
          }
        }
      }
    }
  }
}

// ==============================================================================
// 🌟 2. BUDDHISM & DHAMMA ANALYSIS MASTER VAULT
// ==============================================================================

data class BuddhistSuttaAnalysis(
  val title: String,
  val location: String,
  val mainAudience: String,
  val coreTeachings: List<String>,
  val examSummary: String
)

val sampleSuttas = listOf(
  BuddhistSuttaAnalysis(
    title = "මංගල සූත්‍රය (Khuddaka Nikaya)",
    location = "සැවැත්නුවර ජේතවනාරාමය",
    mainAudience = "දේවතාවෙකුගේ ආරාධනයෙන් මිනිසුන් හා දෙවියන් උදෙසා",
    coreTeachings = listOf(
      "අසේවනා ච බාලානං පණ්ඩිතානං ච සේවනා (අසතුන් ඇසුරු නොකිරීම, පඬිවරුන් ඇසුර)",
      "මාතාපිතූ උපට්ඨානං පුත්තදාරස්ස සංගහෝ (මව්පිය උපස්ථානය, අඹුදරු සංග්‍රහය)",
      "ගාරවෝ ච නිවාතෝ ච සන්තුට්ඨි ච කතඤ්ඤුතා (ගෞරවය, නිහතමානී බව, සතුට, කළගුණ සැලකීම)",
      "ඵුට්ඨස්ස ලෝකධම්මේහි චිත්තං යස්ස න කම්පති (අටලෝ දහමින් නොසැලෙන සිත)"
    ),
    examSummary = "මනුෂ්‍ය ජීවිතයේ උසස්ම දියුණුව සඳහා වූ 38 වැදෑරුම් උතුම් මංගල කරුණු විස්තර කෙරේ."
  ),
  BuddhistSuttaAnalysis(
    title = "පරාභව සූත්‍රය",
    location = "සැවැත්නුවර ජේතවනාරාමය",
    mainAudience = "මිනිසාගේ පිරිහීමට බලපාන කරුණු විමසූ දෙවියෙකු උදෙසා",
    coreTeachings = listOf(
      "ධර්මයට ද්වේෂ කිරීම සහ අධර්මයට ප්‍රිය කිරීම",
      "අලසකම, ක්‍රෝධය සහ නිදි බරිත බව",
      "මහලු වූ මව්පියන් නොසලකා හැරීම",
      "ස්ත්‍රී ධූර්ත, සුරා ධූර්ත, අක්ෂ ධූර්ත (දූදරු) වීම",
      "ධනය තිබියදී තමා පමණක් රසවත් ආහාර ගැනීම"
    ),
    examSummary = "පුද්ගලයාගේ ලෞකික සහ ආධ්‍යාත්මික පරිහානියට හේතු වන සාධක 12 ක් මෙහි අන්තර්ගතය."
  ),
  BuddhistSuttaAnalysis(
    title = "ධම්මචක්කප්පවත්තන සූත්‍රය",
    location = "බරණැස ඉසිපතන මිගදාය",
    mainAudience = "පස්වග තවුසන් (කොණ්ඩඤ්ඤ හිමි ඇතුළු)",
    coreTeachings = listOf(
      "අන්ත දෙක: කාමසුඛල්ලිකානුයෝගය (කාමයන්හි ගැලීම) සහ අත්තකිලමථානුයෝගය (ශරීරයට දැඩි දුක් දීම)",
      "මධ්‍යම ප්‍රතිපදාව: ආර්ය අෂ්ටාංගික මාර්ගය",
      "චතුරාර්ය සත්‍යය: දුක්ඛ, සමුදය, නිරෝධ, මාර්ග"
    ),
    examSummary = "බුදුරජාණන් වහන්සේගේ ප්‍රථම ධර්ම දේශනාව වන අතර බුද්ධ ශාසනයේ පදනම පිහිටුවන ලද්දේ මෙම සූත්‍රයෙනි."
  )
)

@Composable
fun BuddhismDhammaFeatureView() {
  var selectedTab by remember { mutableStateOf(0) }
  val tabs = listOf("☸️ සූත්‍ර විශ්ලේෂණය", "🏛️ ශාසන ඉතිහාසය", "💡 අභිධර්ම & සිව්සස්", "⚡ ධර්ම Auto-Checker")

  Column(modifier = Modifier.fillMaxSize()) {
    LazyRow(
      modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFF1E293B))
        .padding(horizontal = 12.dp, vertical = 8.dp),
      horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      items(tabs.indices.toList()) { idx ->
        val isSelected = selectedTab == idx
        Surface(
          onClick = { selectedTab = idx },
          shape = RoundedCornerShape(12.dp),
          color = if (isSelected) Color(0xFFF59E0B) else Color.White.copy(alpha = 0.08f),
          border = BorderStroke(1.dp, if (isSelected) Color(0xFFF59E0B) else Color.White.copy(alpha = 0.2f))
        ) {
          Text(
            text = tabs[idx],
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Bold,
            color = if (isSelected) Color.White else Color(0xFFCBD5E1),
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
          )
        }
      }
    }

    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(14.dp)
    ) {
      when (selectedTab) {
        0 -> SuttaAnalysisTab()
        1 -> SasanaHistoryTab()
        2 -> AbhidhammaTab()
        3 -> BuddhismQuizTab()
      }
    }
  }
}

@Composable
fun SuttaAnalysisTab() {
  LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
    items(sampleSuttas) { s ->
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFFF59E0B).copy(alpha = 0.4f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text(s.title, color = Color(0xFFFDE68A), fontWeight = FontWeight.ExtraBold, fontSize = 14.sp)
          Text("ස්ථානය: ${s.location} • ශ්‍රාවකයින්: ${s.mainAudience}", color = Color(0xFF94A3B8), fontSize = 10.5.sp)
          Spacer(modifier = Modifier.height(8.dp))
          Text("ප්‍රධාන ධර්ම කරුණු:", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 11.5.sp)
          s.coreTeachings.forEach { pt ->
            Text("• $pt", color = Color(0xFFCBD5E1), fontSize = 11.sp, lineHeight = 15.sp)
          }
          Spacer(modifier = Modifier.height(8.dp))
          Surface(
            shape = RoundedCornerShape(6.dp),
            color = Color(0xFF0F172A),
            modifier = Modifier.fillMaxWidth()
          ) {
            Text(
              text = "විභාග සාරාංශය: ${s.examSummary}",
              color = Color(0xFF86EFAC),
              fontSize = 10.5.sp,
              modifier = Modifier.padding(8.dp)
            )
          }
        }
      }
    }
  }
}

@Composable
fun SasanaHistoryTab() {
  val councils = listOf(
    Triple("පළමු ධර්ම සංගායනාව", "රජගහනුවර සප්තපර්ණී ගුහාව (අජාසත් රජු දවස)", "බුද්ධ පරිනිර්වාණයෙන් මාස 3කට පසු. සුභද්ද භික්ෂුවගේ අවැඩදායක වචනය හේතුවෙන්. මහා කාශ්‍යප මහ රහතන් වහන්සේ ප්‍රධානත්වය දැරූහ."),
    Triple("දෙවන ධර්ම සංගායනාව", "විසාලා මහනුවර වාලුකාරාමය (කාලාශෝක රජු දවස)", "බුද්ධ පරිනිර්වාණයෙන් වසර 100කට පසු. වජ්ජිපුත්තක භික්ෂූන්ගේ දස අකැප වස්තුව හේතුවෙන්. සබ්බකාමී හා රේවත මහරහතන් වහන්සේලා මූලික වූහ."),
    Triple("තෙවන ධර්ම සංගායනාව", "පැළලුප් නුවර අශෝකාරාමය (ධර්මාශෝක අධිරාජ්‍යයා දවස)", "ශාසනයට රිංගාගත් තීර්ථකයන්ගේ මිථ්‍යා දෘෂ්ටි බැහැර කිරීමට. මොග්ගලීපුත්ත තිස්ස මහරහතන් වහන්සේගේ මූලිකත්වයෙන්."),
    Triple("ත්‍රිපිටකය ග්‍රන්ථාරූඪ කිරීම", "මාතලේ අලුවිහාරය (වළගම්බා රජු දවස)", "බැමිණිතියා සාය සහ විදේශීය ආක්‍රමණ නිසා මුඛපරම්පරාවෙන් ධර්මය රැකගැනීමට නොහැකි වූයෙන් තල්පත්වල ලියා තැබීම.")
  )

  LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
    items(councils) { c ->
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFFF59E0B).copy(alpha = 0.3f))
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Text(c.first, color = Color(0xFFFDE68A), fontWeight = FontWeight.Bold, fontSize = 13.5.sp)
          Text(c.second, color = Color(0xFF38BDF8), fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
          Spacer(modifier = Modifier.height(4.dp))
          Text(c.third, color = Color(0xFFE2E8F0), fontSize = 11.sp, lineHeight = 15.sp)
        }
      }
    }
  }
}

@Composable
fun AbhidhammaTab() {
  val concepts = listOf(
    Pair("චතුරාර්ය සත්‍යය", "1. දුක්ඛ සත්‍යය (ජීවිතයේ යථාර්ථය වන දුක)\n2. සමුදය සත්‍යය (දුකට හේතුව වන තණ්හාව)\n3. නිරෝධ සත්‍යය (තණ්හාව නැතිකිරීමෙන් ලබන නිවන)\n4. මාර්ග සත්‍යය (නිවන් දකින ආර්ය අෂ්ටාංගික මාර්ගය)"),
    Pair("ආර්ය අෂ්ටාංගික මාර්ගය", "• ප්‍රඥා: සම්මා දිට්ඨි, සම්මා සංකප්ප\n• ශීල: සම්මා වාචා, සම්මා කම්මන්ත, සම්මා ආජීව\n• සමාධි: සම්මා වායාම, සම්මා සති, සම්මා සමාධි"),
    Pair("ත්‍රිලක්ෂණය", "1. අනිච්ච: සියලු සංස්කාර ධර්මයන්ගේ වෙනස් වන සුළු ස්වභාවය.\n2. දුක්ඛ: අනිත්‍ය දේ දැඩිව අල්ලා ගැනීම නිසා උපදින අසහනය.\n3. අනත්ත: තමාගේ කැමැත්ත පරිදි පාලනය කළ හැකි ස්ථිර ආත්මයක් නොමැති බව.")
  )

  LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
    items(concepts) { c ->
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.3f))
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Text(c.first, color = Color(0xFF86EFAC), fontWeight = FontWeight.Bold, fontSize = 13.sp)
          Spacer(modifier = Modifier.height(4.dp))
          Text(c.second, color = Color.White, fontSize = 11.sp, lineHeight = 16.sp)
        }
      }
    }
  }
}

@Composable
fun BuddhismQuizTab() {
  val questions = listOf(
    Triple(
      "පළමු ධර්ම සංගායනාවේ මූලිකත්වය ගත් මහරහතන් වහන්සේ කවුරුන්ද?",
      listOf("ආනන්ද හිමි", "මහා කාශ්‍යප හිමි", "උපාලි හිමි", "මොග්ගලීපුත්ත තිස්ස හිමි"),
      1
    ),
    Triple(
      "මාතලේ අලුවිහාරයේදී ත්‍රිපිටකය ග්‍රන්ථාරූඪ කරන ලද්දේ කුමන රජුගේ පාලන කාලයේදීද?",
      listOf("දේවානම්පියතිස්ස රජු", "දුටුගැමුණු රජු", "වළගම්බා රජු", "ධාතුසේන රජු"),
      2
    ),
    Triple(
      "ආර්ය අෂ්ටාංගික මාර්ගයේ 'ශීල' ස්කන්ධයට අයත් වන අංගය කුමක්ද?",
      listOf("සම්මා දිට්ඨි", "සම්මා සමාධි", "සම්මා කම්මන්ත", "සම්මා වායාම"),
      2
    )
  )

  val userAnswers = remember { mutableStateMapOf<Int, Int>() }

  LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
    items(questions.indices.toList()) { idx ->
      val q = questions[idx]
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFFF59E0B).copy(alpha = 0.4f))
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text("ප්‍රශ්නය ${idx + 1}: ${q.first}", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 13.sp)
          Spacer(modifier = Modifier.height(8.dp))
          q.second.forEachIndexed { optIdx, optText ->
            val isSelected = userAnswers[idx] == optIdx
            val isCorrect = optIdx == q.third
            Surface(
              onClick = { userAnswers[idx] = optIdx },
              shape = RoundedCornerShape(8.dp),
              color = if (isSelected) (if (isCorrect) Color(0xFF10B981) else Color(0xFFEF4444)).copy(alpha = 0.3f) else Color.White.copy(alpha = 0.05f),
              border = BorderStroke(1.dp, if (isSelected) (if (isCorrect) Color(0xFF10B981) else Color(0xFFEF4444)) else Color.White.copy(alpha = 0.1f)),
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 3.dp)
            ) {
              Text(
                text = "(${optIdx + 1}) $optText",
                color = Color.White,
                fontSize = 11.5.sp,
                modifier = Modifier.padding(8.dp)
              )
            }
          }
        }
      }
    }
  }
}
