package com.example

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class OfflineNoteItem(
  val id: Int,
  val grade: String,
  val subject: String,
  val titleSinhala: String,
  val summary: String,
  val keyPoints: List<String>,
  val examTips: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfflineNotesVaultScreen(
  onBack: () -> Unit
) {
  val subjects = listOf("සියලු විෂයන්", "විද්‍යාව", "ගණිතය", "ඉතිහාසය", "බුද්ධ ධර්මය", "සිංහල", "English", "ICT", "ව්‍යාපාර")
  var selectedSubject by remember { mutableStateOf("සියලු විෂයන්") }
  var selectedGrade by remember { mutableStateOf("11") }
  var searchQuery by remember { mutableStateOf("") }

  val notesList = remember {
    listOf(
      OfflineNoteItem(
        1, "11", "විද්‍යාව", "ප්‍රවේණිය සහ DNA අණුවේ ව්‍යුහය",
        "වොට්සන් සහ ක්‍රික් ආකෘතියට අනුව DNA අණුව ද්විත්ව හෙලික්සීය ව්‍යුහයකි. නියුක්ලියෝටයිඩ ඒකක වලින් සමන්විත වේ. නයිට්‍රජනීය භස්ම A=T හා G≡C ලෙස බන්ධනය වේ.",
        listOf("ද්විත්ව හෙලික්සය", "නියුක්ලියෝටයිඩ", "නයිට්‍රජනීය භස්ම (A, T, G, C)", "හයිඩ්‍රජන් බන්ධන"),
        "O/L විභාගයේදී DNA අණුවක කොටස් නම් කිරීම හා භස්ම යුගලනය පිළිබඳව නිතර ප්‍රශ්න අසයි."
      ),
      OfflineNoteItem(
        2, "11", "විද්‍යාව", "ලෝහ සක්‍රීයතා ශ්‍රේණිය සහ විස්ථාපනය",
        "K > Na > Ca > Mg > Al > Zn > Fe > Pb > (H) > Cu > Hg > Ag > Au. වඩා සක්‍රීය ලෝහයකට අඩු සක්‍රීය ලෝහයක ලවණ ද්‍රාවණයකින් එය විස්ථාපනය කළ හැක.",
        listOf("ලෝහ සක්‍රීයතාව", "විස්ථාපන ප්‍රතික්‍රියාව", "හයිඩ්‍රජන් නිදහස් කිරීම", "ලෝහ නිස්සාරණය"),
        "ලෝහ සක්‍රීයතා ශ්‍රේණිය මතක තබා ගැනීමට කෙටි යෙදුම් භාවිත කරන්න."
      ),
      OfflineNoteItem(
        3, "11", "ගණිතය", "වර්ගජ සමීකරණ විසඳීමේ සූත්‍ර ක්‍රමය",
        "ax² + bx + c = 0 සමීකරණයේ මූල x = (-b ± √(b² - 4ac)) / 2a මඟින් ලැබේ. මෙහි b² - 4ac විවේචකය ලෙස හැඳින්වේ.",
        listOf("වර්ගජ සූත්‍රය", "විවේචකය (b² - 4ac)", "මූලවල ස්වභාවය", "සම්පූර්ණ වර්ගය"),
        "ලකුණු සලකා බැලීමේදී -b හි ලකුණ හා -4ac ගුණිතයේ ලකුණ ගැන විශේෂයෙන් සැලකිලිමත් වන්න."
      ),
      OfflineNoteItem(
        4, "11", "ඉතිහාසය", "1931 ඩොනමෝර් ආණ්ඩුක්‍රමයේ විශේෂතා",
        "ලංකාවේ සියලුම වයස 21 ට වැඩි පුරවැසියන්ට සර්වජන ඡන්ද බලය හිමිවීම, රාජ්‍ය මන්ත්‍රණ සභාව පිහිටුවීම සහ විධායක කාරක සභා ක්‍රමය හඳුන්වා දීම.",
        listOf("සර්වජන ඡන්ද බලය (1931)", "රාජ්‍ය මන්ත්‍රණ සභාව", "විධායක කාරක සභා 7", "නිලලත් සාමාජිකයන් 3"),
        "සර්වජන ඡන්ද බලය ආසියාවේ ප්‍රථම වරට ක්‍රියාත්මක වූ රටක් ලෙස ලංකාවේ වැදගත්කම විමසයි."
      ),
      OfflineNoteItem(
        5, "11", "බුද්ධ ධර්මය", "පටිච්චසමුප්පාද ධර්මය සහ භව චක්‍රය",
        "හේතුඵල ධර්මතාවයයි. 'අවිද්‍යා පච්චයා සංඛාරා...' යනුවෙන් අංග 12 කින් යුත් සංසාර චක්‍රය විග්‍රහ කෙරේ.",
        listOf("ද්වාදශාංගය (අංග 12)", "හේතුඵල දහම", "අවිද්‍යාව මූලික හේතුව", "භව නිරෝධය (නිවන)"),
        "පටිච්චසමුප්පාද අංග අනුලෝම හා පටිලෝම වශයෙන් පෙළගැස්වීම විභාගයට වැදගත්ය."
      ),
      OfflineNoteItem(
        6, "11", "ICT", "IP ලිපින සහ උපජාලකරණය (Subnetting)",
        "IPv4 ලිපිනයක් බිටු 32 කින් සමන්විත වන අතර දශම තිත් 4 කින් ලියනු ලැබේ (උදා: 192.168.1.1). IPv6 ලිපිනයක් බිටු 128 කි.",
        listOf("IPv4 (32-bit)", "IPv6 (128-bit)", "ජාල හැඳුනුම් අංකය", "ධාරක හැඳුනුම් අංකය"),
        "IPv4 සහ IPv6 අතර වෙනස්කම් O/L කෙටි ප්‍රශ්න පත්‍රයේ බහුලව විමසන මාතෘකාවකි."
      )
    )
  }

  val filteredNotes = notesList.filter { note ->
    (selectedSubject == "සියලු විෂයන්" || note.subject == selectedSubject) &&
    (searchQuery.isBlank() || note.titleSinhala.contains(searchQuery, ignoreCase = true) || note.summary.contains(searchQuery, ignoreCase = true))
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = "💾 Offline Notes & Study Vault",
              fontSize = 15.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Text(
              text = "අන්තර්ජාලය රහිතව පරිශීලනය කළ හැකි සාරාංශ සටහන්",
              fontSize = 10.sp,
              color = Color(0xFFBAE6FD)
            )
          }
        },
        navigationIcon = {
          IconButton(
            onClick = onBack,
            modifier = Modifier.testTag("notes_vault_back_btn")
          ) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = "Back",
              tint = Color.White
            )
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0F172A))
      )
    }
  ) { padding ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF0B132B))
        .padding(padding)
        .padding(14.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
      contentPadding = PaddingValues(bottom = 64.dp)
    ) {
      // Header Banner
      item {
        Card(
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.5f))
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = "📚 නොබැඳි කෙටි සටහන් ගබඩාව",
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF16A34A).copy(alpha = 0.2f),
                border = BorderStroke(1.dp, Color(0xFF22C55E))
              ) {
                Row(
                  verticalAlignment = Alignment.CenterVertically,
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                  Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Color(0xFF86EFAC), modifier = Modifier.size(12.dp))
                  Spacer(modifier = Modifier.width(4.dp))
                  Text("100% Offline Ready", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF86EFAC))
                }
              }
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = "විභාගයට නිතර පැමිණෙන වැදගත් සිද්ධාන්ත, සූත්‍ර හා විභාග රහස් සටහන් දත්ත භාවිතයකින් තොරව ඕනෑම තැනකදී පරිශීලනය කරන්න.",
              fontSize = 11.sp,
              color = Color(0xFFCBD5E1),
              lineHeight = 16.sp
            )
          }
        }
      }

      // Subject Filter
      item {
        LazyRow(
          horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          items(subjects) { subj ->
            val isSelected = subj == selectedSubject
            Surface(
              onClick = { selectedSubject = subj },
              shape = RoundedCornerShape(8.dp),
              color = if (isSelected) Color(0xFF0284C7) else Color(0xFF1E293B),
              border = BorderStroke(1.dp, if (isSelected) Color(0xFF38BDF8) else Color(0xFF334155))
            ) {
              Text(
                text = subj,
                fontSize = 11.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                color = if (isSelected) Color.White else Color(0xFFCBD5E1),
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
              )
            }
          }
        }
      }

      // Notes Items
      items(filteredNotes) { note ->
        Card(
          shape = RoundedCornerShape(14.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
          border = BorderStroke(1.dp, Color(0xFF1E293B))
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Surface(
                shape = RoundedCornerShape(6.dp),
                color = Color(0xFF0284C7).copy(alpha = 0.2f)
              ) {
                Text(
                  text = note.subject,
                  fontSize = 10.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF38BDF8),
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }
              Icon(Icons.Default.Bookmark, contentDescription = null, tint = Color(0xFFFBBF24), modifier = Modifier.size(16.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = note.titleSinhala,
              fontSize = 13.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = note.summary,
              fontSize = 11.5.sp,
              color = Color(0xFFCBD5E1),
              lineHeight = 17.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
              text = "🔑 ප්‍රධාන විභාග මූලපද:",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF38BDF8)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
              horizontalArrangement = Arrangement.spacedBy(6.dp),
              modifier = Modifier.fillMaxWidth()
            ) {
              note.keyPoints.take(3).forEach { kp ->
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = Color(0xFF1E293B),
                  border = BorderStroke(1.dp, Color(0xFF334155))
                ) {
                  Text(
                    text = kp,
                    fontSize = 10.sp,
                    color = Color(0xFFBAE6FD),
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                  )
                }
              }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Surface(
              shape = RoundedCornerShape(8.dp),
              color = Color(0xFFD97706).copy(alpha = 0.15f),
              border = BorderStroke(1.dp, Color(0xFFD97706).copy(alpha = 0.4f))
            ) {
              Text(
                text = "💡 " + note.examTips,
                fontSize = 10.5.sp,
                color = Color(0xFFFDE68A),
                modifier = Modifier.padding(8.dp)
              )
            }
          }
        }
      }
    }
  }
}
