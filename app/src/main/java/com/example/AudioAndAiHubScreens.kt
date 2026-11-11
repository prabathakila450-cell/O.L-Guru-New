package com.example

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.animation.core.*
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
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.ui.theme.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Locale


// --------------------------------------------------
// SECTION 6: ⚡ AI SMART ASSISTANT & VOICE HELPER
// --------------------------------------------------

@Composable
fun AiSmartAssistantSection(
  grade: String,
  subject: SubjectItem,
  pdfUrl: String,
  onOpenPdfAtPage: (pdfUrl: String, title: String, page: Int) -> Unit
) {
  val context = LocalContext.current
  val clipboardManager = LocalClipboardManager.current
  val coroutineScope = rememberCoroutineScope()

  val chapters = remember(grade, subject.nameSinhala) {
    ChapterRepository.getChaptersForSubject(grade, subject.nameSinhala, normalizeSubjectKey(subject.nameSinhala))
  }

  var selectedChapterIndex by remember { mutableIntStateOf(0) }
  val activeChapter = chapters.getOrElse(selectedChapterIndex) { chapters.first() }

  // Search State
  var searchQuery by remember { mutableStateOf("") }
  var isVoiceListening by remember { mutableStateOf(false) }
  var searchResults by remember { mutableStateOf<List<SearchResultItem>>(emptyList()) }


  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 4.dp),
    verticalArrangement = Arrangement.spacedBy(14.dp)
  ) {
    // AI Hero Gradient Card
    Card(
      shape = RoundedCornerShape(20.dp),
      colors = CardDefaults.cardColors(containerColor = Color.Transparent),
      elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
      modifier = Modifier.fillMaxWidth()
    ) {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .background(
            Brush.linearGradient(
              colors = listOf(
                Color(0xFF0F172A), // Slate Dark
                Color(0xFF1E1B4B), // Cyber Dark Indigo
                Color(0xFF0284C7)  // Electric Cyan
              )
            )
          )
          .padding(18.dp)
      ) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Surface(
              shape = RoundedCornerShape(20.dp),
              color = Color(0xFF38BDF8).copy(alpha = 0.25f),
              border = BorderStroke(1.dp, Color(0xFF38BDF8))
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text("⚡", fontSize = 12.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                  text = "AI Smart Assistant & Voice Helper",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFFBAE6FD)
                )
              }
            }

            Surface(
              shape = RoundedCornerShape(12.dp),
              color = Color.White.copy(alpha = 0.15f)
            ) {
              Text(
                text = "100+ Page Index",
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
              )
            }
          }

          Text(
            text = "🤖 ${subject.nameSinhala} - බුද්ධිමත් සහායක සහ හඬ සෙවුම",
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White
          )

          Text(
            text = "ඕනෑම විෂය කරුණක් සිංහලෙන් කියන්න හෝ සොයන්න. පිටු 100+ ක සටහන ගැඹුරින් පිරික්සා අදාළ පිටුවටම විවෘත කරයි. AI පරිච්ඡේද සාරාංශ ලබාගන්න.",
            fontSize = 12.sp,
            color = Color(0xFFE2E8F0),
            lineHeight = 18.sp
          )
        }
      }
    }

    // 1. 🎙️ VOICE & DEEP-INDEX SEARCH BAR
    Card(
      shape = RoundedCornerShape(16.dp),
      colors = CardDefaults.cardColors(containerColor = Color.White),
      border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
      elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Text(
            text = "🎙️ සිංහල හඬ සෙවුම සහ සටහන් ගැඹුරු සෙවීම (Deep Index)",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0F172A)
          )
        }

        Row(
          modifier = Modifier.fillMaxWidth(),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          OutlinedTextField(
            value = searchQuery,
            onValueChange = {
              searchQuery = it
              searchResults = ChapterRepository.searchPdfIndex(it, chapters)
            },
            placeholder = {
              Text(
                text = "උදා: ප්‍රභාසංස්ලේෂණය, නිව්ටන් නියම...",
                fontSize = 12.sp,
                color = NeutralMedium
              )
            },
            leadingIcon = {
              Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF0284C7))
            },
            trailingIcon = {
              if (searchQuery.isNotEmpty()) {
                IconButton(onClick = {
                  searchQuery = ""
                  searchResults = emptyList()
                }) {
                  Icon(Icons.Default.Close, contentDescription = "Clear", modifier = Modifier.size(18.dp))
                }
              }
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
              .weight(1f)
              .testTag("ai_voice_search_input"),
            singleLine = true
          )

          // Glowing Mic Button
          val infiniteTransition = rememberInfiniteTransition(label = "mic_glow")
          val micScale by infiniteTransition.animateFloat(
            initialValue = 1.0f,
            targetValue = if (isVoiceListening) 1.25f else 1.0f,
            animationSpec = infiniteRepeatable(
              animation = tween(600, easing = FastOutSlowInEasing),
              repeatMode = RepeatMode.Reverse
            ),
            label = "mic_scale"
          )

          Surface(
            shape = CircleShape,
            color = if (isVoiceListening) Color(0xFFEF4444) else Color(0xFF0284C7),
            shadowElevation = if (isVoiceListening) 6.dp else 2.dp,
            modifier = Modifier
              .size(50.dp)
              .scale(micScale)
              .testTag("ai_voice_mic_btn"),
            onClick = {
              isVoiceListening = !isVoiceListening
              if (isVoiceListening) {
                Toast.makeText(context, "🎙️ සිංහලෙන් කියන්න (Voice Listening Active...)", Toast.LENGTH_SHORT).show()
                // Simulated voice query selector
                coroutineScope.launch {
                  delay(1500)
                  val defaultVoiceQueries = when (normalizeSubjectKey(subject.nameSinhala)) {
                    "science" -> listOf("ප්‍රභාසංස්ලේෂණය", "නිව්ටන් නියම", "ධාරා විද්‍යුතය", "සෛල ව්‍යුහය")
                    "math" -> listOf("පයිතගරස් ප්‍රමේයය", "වර්ගජ සමීකරණ", "වෘත්ත ප්‍රමේය")
                    "history" -> listOf("වාරි ශිෂ්ටාචාරය", "මහසෙන් රජු", "උඩරට ගිවිසුම")
                    else -> listOf("මූලික සංකල්ප", "විභාග ගැටළු")
                  }
                  val picked = defaultVoiceQueries.random()
                  searchQuery = picked
                  searchResults = ChapterRepository.searchPdfIndex(picked, chapters)
                  isVoiceListening = false
                  Toast.makeText(context, "🎙️ හඬ හඳුනාගැනීම: '$picked'", Toast.LENGTH_SHORT).show()
                }
              }
            }
          ) {
            Box(contentAlignment = Alignment.Center) {
              Icon(
                imageVector = if (isVoiceListening) Icons.Default.GraphicEq else Icons.Default.Mic,
                contentDescription = "Voice Search",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
              )
            }
          }
        }

        // Suggested Voice Search Keywords
        LazyRow(
          horizontalArrangement = Arrangement.spacedBy(6.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          val samples = when (normalizeSubjectKey(subject.nameSinhala)) {
            "science" -> listOf("ප්‍රභාසංස්ලේෂණය", "නිව්ටන් නියම", "සෛල වාදය", "ඕම්ගේ නියමය", "DNA")
            "math" -> listOf("පයිතගරස්", "වර්ගජ සමීකරණ", "ත්‍රිකෝණමිතිය", "ශ්‍රේඪි")
            "history" -> listOf("වාරි ශිෂ්ටාචාරය", "මහසෙන් රජු", "පරාක්‍රමබාහු", "උඩරට ගිවිසුම")
            else -> listOf("මූලික සංකල්ප", "විභාග ගැටළු", "කෙටි ක්‍රම")
          }
          items(samples) { sampleText ->
            Surface(
              shape = RoundedCornerShape(8.dp),
              color = Color(0xFFF1F5F9),
              border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
              onClick = {
                searchQuery = sampleText
                searchResults = ChapterRepository.searchPdfIndex(sampleText, chapters)
              }
            ) {
              Text(
                text = "🔍 $sampleText",
                fontSize = 11.sp,
                color = Color(0xFF334155),
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
              )
            }
          }
        }

        // Search Results Dropdown / List
        if (searchResults.isNotEmpty()) {
          Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF0FDF4)),
            border = BorderStroke(1.dp, Color(0xFFBBF7D0)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(
              modifier = Modifier.padding(12.dp),
              verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              Text(
                text = "🎯 සෙවුම් ප්‍රතිඵල (${searchResults.size} Matches Found):",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF166534)
              )

              searchResults.forEach { result ->
                Row(
                  modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(8.dp))
                    .padding(10.dp),
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.SpaceBetween
                ) {
                  Column(modifier = Modifier.weight(1f)) {
                    Text(
                      text = result.chapter.title,
                      fontSize = 12.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF1E293B)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                      text = "• ${result.matchSnippet}",
                      fontSize = 11.sp,
                      color = Color(0xFF475569),
                      maxLines = 2,
                      overflow = TextOverflow.Ellipsis
                    )
                  }

                  Spacer(modifier = Modifier.width(8.dp))

                  Button(
                    onClick = {
                      onOpenPdfAtPage(
                        pdfUrl,
                        "${subject.nameSinhala} - පිටුව ${result.targetPage}",
                        result.targetPage
                      )
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF16A34A)),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.height(34.dp)
                  ) {
                    Text("📄 පිටුව ${result.targetPage}", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                  }
                }
              }
            }
          }
        }
      }
    }

    // 2. 📝 INSTANT AI CHAPTER SUMMARY (5-10 KEY BULLETS)
    Card(
      shape = RoundedCornerShape(16.dp),
      colors = CardDefaults.cardColors(containerColor = Color.White),
      border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
      elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text("📝", fontSize = 16.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "ක්ෂණික AI පරිච්ඡේද සාරාංශය (Chapter Summary)",
              fontSize = 13.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF0F172A)
            )
          }

          IconButton(
            onClick = {
              if (AppSecurityManager.canCopyContent(context)) {
                val textToCopy = buildString {
                  appendLine(activeChapter.title)
                  appendLine("පිටු: ${activeChapter.page_start} - ${activeChapter.page_end}")
                  activeChapter.summary_bullets.forEach { appendLine("• $it") }
                }
                clipboardManager.setText(AnnotatedString(textToCopy))
                Toast.makeText(context, "📋 සාරාංශය පිටපත් කරන ලදී!", Toast.LENGTH_SHORT).show()
              } else {
                Toast.makeText(context, "ආරක්ෂක නීති අනුව සටහන් පිටපත් කිරීම (Copy) අවහිර කර ඇත (Admin Only).", Toast.LENGTH_SHORT).show()
              }
            },
            modifier = Modifier.size(32.dp)
          ) {
            Icon(
              imageVector = Icons.Default.ContentCopy,
              contentDescription = "Copy Summary",
              tint = Color(0xFF475569),
              modifier = Modifier.size(18.dp)
            )
          }
        }

        // Chapter Selection Chips
        LazyRow(
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          itemsIndexed(chapters) { idx, ch ->
            val isSelected = idx == selectedChapterIndex
            FilterChip(
              selected = isSelected,
              onClick = { selectedChapterIndex = idx },
              label = {
                Text(
                  text = "පරිච්ඡේදය 0${ch.chapter_id}",
                  fontSize = 11.sp,
                  fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                )
              },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = Color(0xFF4F46E5),
                selectedLabelColor = Color.White
              ),
              shape = RoundedCornerShape(8.dp)
            )
          }
        }

        // Active Chapter Header
        Surface(
          shape = RoundedCornerShape(10.dp),
          color = Color(0xFFEEF2FF),
          border = BorderStroke(1.dp, Color(0xFFC7D2FE)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Column(modifier = Modifier.weight(1f)) {
              Text(
                text = activeChapter.title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3730A3)
              )
              Text(
                text = "පිටු පරාසය: ${activeChapter.page_start} සිට ${activeChapter.page_end} දක්වා",
                fontSize = 10.sp,
                color = Color(0xFF4F46E5)
              )
            }

            Button(
              onClick = {
                onOpenPdfAtPage(
                  pdfUrl,
                  activeChapter.title,
                  activeChapter.page_start
                )
              },
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
              shape = RoundedCornerShape(8.dp),
              modifier = Modifier.height(32.dp)
            ) {
              Text("📄 PDF විවෘත කරන්න", fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
          }
        }

        // Bullets List (High Yield Summary)
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF8FAFC), RoundedCornerShape(10.dp))
            .padding(12.dp),
          verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          activeChapter.summary_bullets.forEachIndexed { bIdx, bullet ->
            Row(
              modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.Top
            ) {
              Text(
                text = "📌",
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 1.dp)
              )
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = bullet,
                fontSize = 12.sp,
                color = Color(0xFF334155),
                lineHeight = 18.sp
              )
            }
          }
        }
      }
    }

  }
}

