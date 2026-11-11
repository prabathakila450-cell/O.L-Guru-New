package com.example

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import com.example.referral.ReferralBanner
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*

data class SubjectSpecialInfo(
  val section: SpecialFeatureSection,
  val title: String,
  val subtitle: String,
  val emoji: String,
  val color: Color
)

data class GradeCardInfo(
  val grade: String,
  val gradeSinhala: String,
  val subtitle: String,
  val description: String,
  val imageRes: Int,
  val color: Color,
  val tag: String
)

val availableGradesList = listOf(
  GradeCardInfo(
    grade = "10",
    gradeSinhala = "10 ශ්‍රේණිය (Grade 10)",
    subtitle = "සාමාන්‍ය පෙළ මූලික අධ්‍යයන",
    description = "විද්‍යාව, ගණිතය, සිංහල, ඉංග්‍රීසි, කෘෂි, වාණිජ්‍ය, ICT හා කෙටි සටහන්",
    imageRes = R.drawable.img_subjects_bg_1786107319789,
    color = Color(0xFF0D47A1),
    tag = "O/L ආරම්භය"
  ),
  GradeCardInfo(
    grade = "11",
    gradeSinhala = "11 ශ්‍රේණිය (Grade 11)",
    subtitle = "අ.පො.ස. සාමාන්‍ය පෙළ (O/L)",
    description = "විද්‍යාව, ගණිතය, ඉතිහාසය, සිංහල, ඉංග්‍රීසි, ICT හා පසුගිය ප්‍රශ්න පත්‍ර",
    imageRes = R.drawable.img_portal_header_bg_1786107362621,
    color = Color(0xFF1B5E20),
    tag = "O/L විභාගය"
  )
)

fun getSubjectBgImage(subjectNameSinhala: String): Int {
  return when {
    subjectNameSinhala.contains("භූගෝල") || subjectNameSinhala.contains("ඉතිහාසය") || subjectNameSinhala.contains("බුද්ධ") || subjectNameSinhala.contains("සිංහල") || subjectNameSinhala.contains("පුරවැසි") -> R.drawable.img_notes_bg_1786107335103
    (subjectNameSinhala.contains("විද්‍යාව") && !subjectNameSinhala.contains("භූගෝල")) || subjectNameSinhala.contains("Science") -> R.drawable.img_subjects_bg_1786107319789
    subjectNameSinhala.contains("ගණිතය") || subjectNameSinhala.contains("Math") -> R.drawable.img_papers_bg_1786107349533
    subjectNameSinhala.contains("තාක්ෂණ") || subjectNameSinhala.contains("ICT") || subjectNameSinhala.contains("වීඩියෝ") -> R.drawable.img_videos_bg_1786110404209
    subjectNameSinhala.contains("සංගීත") || subjectNameSinhala.contains("නර්තන") || subjectNameSinhala.contains("Music") -> R.drawable.img_subjects_bg_1786107319789
    else -> R.drawable.img_portal_header_bg_1786107362621
  }
}

/**
 * STEP 1: Grade Selection Screen (Home Screen)
 * Displays Grades 11 down to 06 in descending order with rich educational background photos
 */
@Composable
fun GradesHomeScreen(
  onGradeSelected: (String) -> Unit,
  onOpenAddModal: () -> Unit,
  onOpenAnalytics: () -> Unit = {},
  onOpenStructuredEssay: () -> Unit = {},
  onOpenFormulaHandbook: () -> Unit = {},
  onOpenVoiceQuiz: () -> Unit = {},
  onOpenEnglishBuilder: () -> Unit = {},
  onOpenSyllabusHub: () -> Unit = {},
  onOpenCountdownPlanner: () -> Unit = {},
  onOpenFlashcards: () -> Unit = {},
  onOpenStudyStreak: () -> Unit = {},
  onOpenSpokenEnglishVoice: () -> Unit = {},
  onOpenBookmarks: () -> Unit = {},
  onOpenMockExam: () -> Unit = {},
  onOpenLiveDailyQuiz: () -> Unit = {},
  onOpenEyeCare: () -> Unit = {},
  onOpenHistoryMapsAutoCheck: () -> Unit = {},
  onOpenScience500AutoCheck: () -> Unit = {},
  onOpenEnglishShortNotesAutoCheck: () -> Unit = {},
  onOpenGeographyAutoCheck: () -> Unit = {},
  onOpenSpecialMasterFeatures: (SpecialFeatureSection?) -> Unit = {},
  onOpenGrade10TermTestPortal: (Grade10WebSource) -> Unit = {},
  onOpenGrade11TermTestPortal: (Grade11WebSource, String?, Int?) -> Unit = { _, _, _ -> },
  onOpenFormulaSolver: () -> Unit = {},
  onOpenTriLingualGlossary: () -> Unit = {},
  onOpenTimedPastPaperSimulator: () -> Unit = {},
  onOpenOfflineNotesVault: () -> Unit = {},
  onOpenInteractiveQaHub: (QaHubTab) -> Unit = {},
  onOpenVoiceDoubtSolver: () -> Unit = {},
  onOpenMistakeNotebook: () -> Unit = {},
  onOpenMathQuizMaster: () -> Unit = {},
  isFeatureTrialActive: Boolean = true,
  isApproved: Boolean = false,
  remainingTrialHours: Int = 24
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 10.dp),
    verticalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    // 🎓 10 ශ්‍රේණිය සහ 11 ශ්‍රේණිය අනු කොටස් (ඇප් එකේ ඉහළටම ස්ථානගත කර ඇත)
    val grade10Info = availableGradesList.firstOrNull { it.grade == "10" }
    val grade11Info = availableGradesList.firstOrNull { it.grade == "11" }

    grade10Info?.let {
      GradeBannerCard(
        gradeInfo = it,
        onClick = { onGradeSelected(it.grade) }
      )
    }

    grade11Info?.let {
      GradeBannerCard(
        gradeInfo = it,
        onClick = { onGradeSelected(it.grade) }
      )
    }

    // 🏆 FEATURE: DAILY AUTOMATED LIVE 7:00 PM QUIZ CONTEST BANNER (Compact)
    Card(
      shape = RoundedCornerShape(10.dp),
      colors = CardDefaults.cardColors(containerColor = Color.Transparent),
      modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(10.dp))
        .background(
          Brush.horizontalGradient(
            colors = listOf(Color(0xFF1E1B4B), Color(0xFF312E81), Color(0xFF4338CA))
          )
        )
        .clickable(onClick = onOpenLiveDailyQuiz)
        .testTag("live_daily_quiz_entry_card")
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 10.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Box(
          modifier = Modifier
            .size(28.dp)
            .clip(CircleShape)
            .background(Color(0xFFF59E0B)),
          contentAlignment = Alignment.Center
        ) {
          Text("🏆", fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.width(8.dp))

        Column(modifier = Modifier.weight(1f)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
              text = "⚡ සජීවී දෛනික Quiz",
              fontWeight = FontWeight.Bold,
              fontSize = 12.sp,
              color = Color.White,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.width(6.dp))
            Surface(
              shape = RoundedCornerShape(4.dp),
              color = Color(0xFFEF4444)
            ) {
              Text(
                text = "LIVE",
                fontSize = 7.5.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp),
                maxLines = 1
              )
            }
          }

          Text(
            text = "Grades 9-11 • ප්‍රශ්න 20 • Leaderboard",
            fontSize = 9.sp,
            color = Color(0xFFC7D2FE),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
        }

        Icon(
          Icons.AutoMirrored.Filled.ArrowForward,
          contentDescription = "Open",
          tint = Color.White,
          modifier = Modifier.size(14.dp)
        )
      }
    }
    // Top Smart Study Tools Quick Strip (විශේෂාංග කලාපය)
    Card(
      shape = RoundedCornerShape(14.dp),
      colors = CardDefaults.cardColors(containerColor = Color.White),
      border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
      elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        // Section Header
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text("⚡", fontSize = 15.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Column {
              Text(
                text = "විශේෂාංග කලාපය (Features Hub)",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0F172A),
                fontSize = 13.5.sp
              )
              Text(
                text = "සියලුම ස්මාර්ට් අධ්‍යයන මෙවලම් සහ කෙටි ක්‍රම",
                fontSize = 9.5.sp,
                color = Color(0xFF64748B)
              )
            }
          }
        }

        // NEW FEATURE: 🎙️ AI Voice Doubt Solver Hero Banner (Ultra-Compact)
        Card(
          shape = RoundedCornerShape(10.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF091E3A)),
          border = BorderStroke(1.dp, Color(0xFF38BDF8)),
          elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
          modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .clickable { onOpenVoiceDoubtSolver() }
            .testTag("home_voice_doubt_solver_card")
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .background(
                Brush.horizontalGradient(
                  colors = listOf(
                    Color(0xFF0F172A),
                    Color(0xFF1E3A8A),
                    Color(0xFF0284C7)
                  )
                )
              )
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
                  .size(28.dp)
                  .clip(CircleShape)
                  .background(Color(0xFFEF4444)),
                contentAlignment = Alignment.Center
              ) {
                Text("🎙️", fontSize = 14.sp)
              }
              Spacer(modifier = Modifier.width(8.dp))
              Column(modifier = Modifier.weight(1f)) {
                Row(
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                  Text(
                    text = "AI ශිෂ්‍ය ගැටලු හඬ සහායකයා",
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                  Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = Color(0xFF10B981)
                  ) {
                    Text(
                      text = "VOICE",
                      fontSize = 7.5.sp,
                      fontWeight = FontWeight.Black,
                      color = Color.White,
                      modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                    )
                  }
                }
                Text(
                  text = "ඕනෑම ගැටලුවක් විමසූ සැනින් සම්පූර්ණ හඬ පැහැදිලි කිරීම්",
                  fontSize = 9.sp,
                  color = Color(0xFFBAE6FD),
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }
            }
            Spacer(modifier = Modifier.width(6.dp))
            Icon(
              Icons.AutoMirrored.Filled.ArrowForward,
              contentDescription = "Open",
              tint = Color(0xFF38BDF8),
              modifier = Modifier.size(15.dp)
            )
          }
        }

        // NEW FEATURE: 🔢 Math Quiz Master 4000 Hero Banner (Ultra-Compact)
        Card(
          shape = RoundedCornerShape(10.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1B4B)),
          border = BorderStroke(1.dp, Color(0xFF818CF8)),
          elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
          modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .clickable { onOpenMathQuizMaster() }
            .testTag("home_math_quiz_master_card")
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .background(
                Brush.horizontalGradient(
                  colors = listOf(
                    Color(0xFF0F172A),
                    Color(0xFF1E1B4B),
                    Color(0xFF312E81)
                  )
                )
              )
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
                  .size(28.dp)
                  .clip(CircleShape)
                  .background(Color(0xFF4F46E5)),
                contentAlignment = Alignment.Center
              ) {
                Text("🔢", fontSize = 14.sp)
              }
              Spacer(modifier = Modifier.width(8.dp))
              Column(modifier = Modifier.weight(1f)) {
                Row(
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                  Text(
                    text = "ගණිතය ක්විස් මාස්ටර් (4,000Q)",
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                  Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = Color(0xFF6366F1)
                  ) {
                    Text(
                      text = "MATH",
                      fontSize = 7.5.sp,
                      fontWeight = FontWeight.Black,
                      color = Color.White,
                      modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                    )
                  }
                }
                Text(
                  text = "10 සහ 11 ශ්‍රේණි • කාණ්ඩ 80 ක ප්‍රශ්න 4,000 ක්",
                  fontSize = 9.sp,
                  color = Color(0xFFC7D2FE),
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }
            }
            Spacer(modifier = Modifier.width(6.dp))
            Icon(
              Icons.AutoMirrored.Filled.ArrowForward,
              contentDescription = "Open",
              tint = Color(0xFF818CF8),
              modifier = Modifier.size(15.dp)
            )
          }
        }

        // Feature 1: Standout English Master Class Hero Banner
        EnglishHeroFeatureCard(
          onClick = onOpenEnglishBuilder
        )

        // Feature 2: Ultra-Compact Mistake Notebook Indicator (වරදවාගත් ප්‍රශ්න - Minimized width, completely non-obtrusive)
        val homeContext = androidx.compose.ui.platform.LocalContext.current
        val mistakePendingCount = remember {
          mutableIntStateOf(MistakeNotebookRepository.getSummary(homeContext).pending)
        }
        LaunchedEffect(Unit) {
          mistakePendingCount.intValue = MistakeNotebookRepository.getSummary(homeContext).pending
        }

        Surface(
          shape = RoundedCornerShape(20.dp),
          color = Color(0xFF0F172A).copy(alpha = 0.95f),
          border = BorderStroke(1.dp, Color(0xFFEF4444).copy(alpha = 0.35f)),
          shadowElevation = 0.5.dp,
          modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .widthIn(max = 195.dp)
            .clickable { onOpenMistakeNotebook() }
        ) {
          Row(
            modifier = Modifier
              .padding(horizontal = 8.dp, vertical = 3.5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
          ) {
            Text("⚠️", fontSize = 10.sp)
            Spacer(modifier = Modifier.width(4.dp))
            Text(
              text = "වරදවාගත් ප්‍රශ්න",
              fontWeight = FontWeight.Bold,
              fontSize = 10.sp,
              color = Color.White
            )
            Spacer(modifier = Modifier.width(4.dp))
            Surface(
              shape = RoundedCornerShape(8.dp),
              color = Color(0xFFDC2626)
            ) {
              Text(
                text = "${mistakePendingCount.intValue}",
                fontSize = 8.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
              )
            }
            Spacer(modifier = Modifier.width(3.dp))
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowForward,
              contentDescription = "Open",
              tint = Color(0xFF94A3B8),
              modifier = Modifier.size(11.dp)
            )
          }
        }

        // Row 1: Flashcards & Bookmarks Hub
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          FeatureSubCardWithBg(
            title = "1. Flashcards",
            subtitle = "මතක කාඩ්පත් (300)",
            emoji = "💡",
            badgeText = "CARDS",
            badgeColor = Color(0xFF16A34A),
            modifier = Modifier.weight(1f),
            onClick = onOpenFlashcards
          )

          FeatureSubCardWithBg(
            title = "2. Bookmarks Hub",
            subtitle = "සුරැකි සටහන්",
            emoji = "🔖",
            badgeText = "SAVED",
            badgeColor = Color(0xFF4F46E5),
            modifier = Modifier.weight(1f),
            onClick = onOpenBookmarks
          )
        }

        // Row 2: AI Voice Quiz & Analytics
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          FeatureSubCardWithBg(
            title = "3. AI Voice Quiz",
            subtitle = "කටහඬින් ප්‍රශ්න & Viva",
            emoji = "🎙️",
            badgeText = "VOICE AI",
            badgeColor = Color(0xFFDC2626),
            modifier = Modifier.weight(1f),
            onClick = onOpenVoiceQuiz
          )

          FeatureSubCardWithBg(
            title = "4. ප්‍රගති වාර්තා",
            subtitle = "Analytics & Stats",
            emoji = "📊",
            badgeText = "STATS",
            badgeColor = Color(0xFF2563EB),
            modifier = Modifier.weight(1f),
            onClick = onOpenAnalytics
          )
        }

        // Row 3: Structured Essays & Formulas/Timelines
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          FeatureSubCardWithBg(
            title = "5. ව්‍යුහගත/රචනා",
            subtitle = "Marking Schemes",
            emoji = "📝",
            badgeText = "ESSAY",
            badgeColor = Color(0xFF9333EA),
            modifier = Modifier.weight(1f),
            onClick = onOpenStructuredEssay
          )

          FeatureSubCardWithBg(
            title = "6. සූත්‍ර & Timeline",
            subtitle = "Handbook & Rules",
            emoji = "🧮",
            badgeText = "FORMULA",
            badgeColor = Color(0xFF059669),
            modifier = Modifier.weight(1f),
            onClick = onOpenFormulaHandbook
          )
        }

        // Row 4: Live Mock Exam Hall & Formula Solver
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          FeatureSubCardWithBg(
            title = "7. සජීවී Exam Hall",
            subtitle = "OMR Simulator",
            emoji = "🏛️",
            badgeText = "EXAM",
            badgeColor = Color(0xFFDC2626),
            modifier = Modifier.weight(1f),
            onClick = onOpenMockExam
          )

          FeatureSubCardWithBg(
            title = "8. සූත්‍ර විසඳුම්කරු",
            subtitle = "පියවරෙන් පියවර Solver",
            emoji = "🧮",
            badgeText = "SOLVER",
            badgeColor = Color(0xFF0284C7),
            modifier = Modifier.weight(1f),
            onClick = onOpenFormulaSolver
          )
        }

        // Row 5: Trilingual Glossary & Past Paper Simulator
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          FeatureSubCardWithBg(
            title = "9. ත්‍රිභාෂා ශබ්දකෝෂය",
            subtitle = "විද්‍යාව/ගණිතය/ICT",
            emoji = "📖",
            badgeText = "GLOSSARY",
            badgeColor = Color(0xFF0D9488),
            modifier = Modifier.weight(1f),
            onClick = onOpenTriLingualGlossary
          )

          FeatureSubCardWithBg(
            title = "10. Past Paper Simulator",
            subtitle = "වසර අනුව Timed Exam",
            emoji = "⏱️",
            badgeText = "EXAM",
            badgeColor = Color(0xFFE11D48),
            modifier = Modifier.weight(1f),
            onClick = onOpenTimedPastPaperSimulator
          )
        }

        // Row 6: Short Answer Evaluation & Daily 10 Challenge
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          FeatureSubCardWithBg(
            title = "11. කෙටි පිළිතුරු ඇගයීම",
            subtitle = "Marking Scheme පරීක්ෂාව",
            emoji = "✍️",
            badgeText = "Q&A SUITE",
            badgeColor = Color(0xFF38BDF8),
            modifier = Modifier.weight(1f),
            onClick = { onOpenInteractiveQaHub(QaHubTab.SHORT_ANSWER) }
          )

          FeatureSubCardWithBg(
            title = "12. දිනපතා මිශ්‍ර ප්‍රශ්න 10",
            subtitle = "Streak & Score පරීක්ෂණය",
            emoji = "🎯",
            badgeText = "DAILY 10",
            badgeColor = Color(0xFF10B981),
            modifier = Modifier.weight(1f),
            onClick = { onOpenInteractiveQaHub(QaHubTab.DAILY_CHALLENGE) }
          )
        }

        // Row 7: Matching / Timeline & True/False 500
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          FeatureSubCardWithBg(
            title = "13. ගැලපීම් & කාලරේඛා",
            subtitle = "Matching & Timeline",
            emoji = "🧩",
            badgeText = "MATCHING",
            badgeColor = Color(0xFF8B5CF6),
            modifier = Modifier.weight(1f),
            onClick = { onOpenInteractiveQaHub(QaHubTab.MATCHING) }
          )

          FeatureSubCardWithBg(
            title = "14. 09/10/11 සත්‍ය/අසත්‍ය & Quiz",
            subtitle = "විෂයකට ප්‍රශ්න 500 • කාණ්ඩ 30",
            emoji = "⚖️",
            badgeText = "500 Qs",
            badgeColor = Color(0xFFEC4899),
            modifier = Modifier.weight(1f),
            onClick = { onOpenInteractiveQaHub(QaHubTab.TRUE_FALSE) }
          )
        }

        Spacer(modifier = Modifier.height(10.dp))
        ReferralBanner()
      }
    }

    // SECTION REMOVED AS REQUESTED: සාමාන්‍ය පෙළ ශ්‍රේණි අනුව විෂයන් (10 සහ 11 ශ්‍රේණි)
    Spacer(modifier = Modifier.height(10.dp))
  }
}

@Composable
fun EnglishHeroFeatureCard(
  onClick: () -> Unit
) {
  Card(
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
    border = BorderStroke(1.2.dp, Color(0xFFF59E0B)),
    elevation = CardDefaults.cardElevation(defaultElevation = 1.5.dp),
    modifier = Modifier
      .fillMaxWidth()
      .clickable { onClick() }
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .background(
          Brush.horizontalGradient(
            colors = listOf(
              Color(0xFF0F172A),
              Color(0xFF1E1B4B),
              Color(0xFF312E81)
            )
          )
        )
        .padding(horizontal = 10.dp, vertical = 8.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
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
              .background(Color(0xFFF59E0B).copy(alpha = 0.25f)),
            contentAlignment = Alignment.Center
          ) {
            Text("🇬🇧", fontSize = 15.sp)
          }
          Spacer(modifier = Modifier.width(8.dp))
          Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text(
                text = "ඉංග්‍රීසි පන්තිය (English Hub)",
                fontSize = 12.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFFFDE047)
              )
              Spacer(modifier = Modifier.width(4.dp))
              Surface(
                shape = RoundedCornerShape(3.dp),
                color = Color(0xFFF59E0B)
              ) {
                Text(
                  text = "09-11 ALL",
                  fontSize = 7.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF78350F),
                  modifier = Modifier.padding(horizontal = 3.dp, vertical = 1.dp)
                )
              }
            }
            Text(
              text = "කෙටි සටහන්, ව්‍යාකරණ, ස්පෝකන් ඉංග්‍රීසි & සම්පූර්ණ ඩික්ෂනරිය",
              fontSize = 9.sp,
              color = Color(0xFFE2E8F0),
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
          }
        }
        Icon(
          imageVector = Icons.Default.ArrowForwardIos,
          contentDescription = "Open",
          tint = Color(0xFFFDE047),
          modifier = Modifier.size(13.dp)
        )
      }
    }
  }
}

@Composable
fun FeatureSubCardWithBg(
  title: String,
  subtitle: String,
  emoji: String,
  badgeText: String? = null,
  badgeColor: Color = Color(0xFFF59E0B),
  backgroundImageRes: Int = 0,
  modifier: Modifier = Modifier,
  onClick: () -> Unit
) {
  val (cardStartColor, cardEndColor) = when (badgeText) {
    "PLANNER" -> Color(0xFF1E1B4B) to Color(0xFF312E81)
    "CARDS" -> Color(0xFF064E3B) to Color(0xFF047857)
    "REWARDS" -> Color(0xFF78350F) to Color(0xFFB45309)
    "SAVED" -> Color(0xFF1E1B4B) to Color(0xFF4338CA)
    "VOICE AI" -> Color(0xFF7F1D1D) to Color(0xFFB91C1C)
    "STATS" -> Color(0xFF1E3A8A) to Color(0xFF2563EB)
    "ESSAY" -> Color(0xFF581C87) to Color(0xFF7E22CE)
    "FORMULA" -> Color(0xFF064E3B) to Color(0xFF059669)
    "EXAM" -> Color(0xFF881337) to Color(0xFFBE123C)
    "TOPICS" -> Color(0xFF0C4A6E) to Color(0xFF0284C7)
    "NIGHT" -> Color(0xFF0F172A) to Color(0xFF334155)
    "MAPS" -> Color(0xFF0B192C) to Color(0xFF1E3E62)
    "SCIENCE" -> Color(0xFF064E3B) to Color(0xFF047857)
    "ENGLISH" -> Color(0xFF0F172A) to Color(0xFF0284C7)
    "GEO" -> Color(0xFF064E3B) to Color(0xFF047857)
    "TOOLS" -> Color(0xFF312E81) to Color(0xFF4C1D95)
    "PAPERS" -> Color(0xFF022C22) to Color(0xFF064E3B)
    "SYLLABUS" -> Color(0xFF1E1B4B) to Color(0xFF4338CA)
    else -> Color(0xFF0F172A) to Color(0xFF1E293B)
  }

  val dims = rememberScreenDimensions()
  val isCompact = dims.isSmallWidth

  Card(
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
    border = BorderStroke(1.dp, badgeColor.copy(alpha = 0.35f)),
    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
    modifier = modifier
      .fillMaxWidth()
      .clickable { onClick() }
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .defaultMinSize(minHeight = if (isCompact) 58.dp else 56.dp)
        .wrapContentHeight()
        .background(
          Brush.verticalGradient(
            colors = listOf(
              cardStartColor,
              cardEndColor
            )
          )
        )
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(
            horizontal = if (isCompact) 6.dp else 8.dp,
            vertical = if (isCompact) 4.5.dp else 5.5.dp
          )
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(emoji, fontSize = if (isCompact) 11.5.sp else 13.sp)
          if (badgeText != null) {
            Surface(
              shape = RoundedCornerShape(3.dp),
              color = badgeColor
            ) {
              Text(
                text = badgeText,
                fontSize = if (isCompact) 6.5.sp else 7.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = if (isCompact) 3.dp else 4.dp, vertical = 1.dp),
                maxLines = 1
              )
            }
          }
        }
        Spacer(modifier = Modifier.height(if (isCompact) 2.5.dp else 3.5.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
          Text(
            text = title,
            fontSize = if (isCompact) 9.sp else 10.sp,
            lineHeight = if (isCompact) 12.sp else 13.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
          Text(
            text = subtitle,
            fontSize = if (isCompact) 7.5.sp else 8.sp,
            lineHeight = if (isCompact) 10.sp else 11.sp,
            color = Color(0xFFCBD5E1),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
        }
      }
    }
  }
}

@Composable
fun GradeBannerCard(
  gradeInfo: GradeCardInfo,
  onClick: () -> Unit
) {
  Card(
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
    border = BorderStroke(1.dp, gradeInfo.color.copy(alpha = 0.4f)),
    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
    modifier = Modifier
      .fillMaxWidth()
      .testTag("grade_card_${gradeInfo.grade}")
      .clickable { onClick() }
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .background(
          Brush.horizontalGradient(
            colors = listOf(
              Color(0xFF0F172A),
              gradeInfo.color.copy(alpha = 0.85f),
              gradeInfo.color
            )
          )
        )
        .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column(modifier = Modifier.weight(1f)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = gradeInfo.color
            ) {
              Text(
                text = gradeInfo.tag,
                color = Color.White,
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = gradeInfo.gradeSinhala,
              fontSize = 13.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
          }
          Spacer(modifier = Modifier.height(2.dp))
          Text(
            text = "${gradeInfo.subtitle} • ${gradeInfo.description}",
            fontSize = 9.5.sp,
            color = Color.White.copy(alpha = 0.9f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
        }

        Surface(
          shape = CircleShape,
          color = Color.White.copy(alpha = 0.25f)
        ) {
          Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "Open Grade",
            tint = Color.White,
            modifier = Modifier
              .padding(5.dp)
              .size(14.dp)
          )
        }
      }
    }
  }
}

/**
 * STEP 2: Subject Selection Screen for a Chosen Grade
 * Displays list of subjects for that grade with individual background photos
 */
@Composable
fun GradeSubjectsScreen(
  grade: String,
  subjectsList: SnapshotStateList<SubjectItem>,
  isAdmin: Boolean = false,
  onSubjectSelected: (SubjectItem) -> Unit,
  onBackToGrades: () -> Unit,
  onAddSubject: () -> Unit,
  onDeleteSubject: (SubjectItem) -> Unit,
  onOpenGrade10TermTestPortal: (Grade10WebSource) -> Unit = {},
  onOpenGrade11TermTestPortal: (Grade11WebSource, String?, Int?) -> Unit = { _, _, _ -> }
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp),
    verticalArrangement = Arrangement.spacedBy(14.dp)
  ) {
    // Navigation bar back button + Grade title
    Surface(
      shape = RoundedCornerShape(16.dp),
      color = BluePrimaryContainer,
      border = BorderStroke(1.dp, BluePrimary.copy(alpha = 0.2f)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          IconButton(
            onClick = onBackToGrades,
            modifier = Modifier.testTag("back_to_grades_btn")
          ) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = "Back to Grades",
              tint = BlueOnPrimaryContainer
            )
          }

          Spacer(modifier = Modifier.width(6.dp))

          Column {
            Text(
              text = "$grade ශ්‍රේණිය • විෂයන් (Subjects)",
              style = MaterialTheme.typography.titleMedium,
              fontWeight = FontWeight.Bold,
              color = BlueOnPrimaryContainer
            )
            Text(
              text = "විෂයයක් තෝරා කෙටි සටහන්, ප්‍රශ්න පත්‍ර හා වීඩියෝ බලන්න",
              style = MaterialTheme.typography.bodySmall,
              color = BlueOnPrimaryContainer.copy(alpha = 0.8f),
              fontSize = 11.sp
            )
          }
        }

        if (isAdmin) {
          Surface(
            shape = RoundedCornerShape(10.dp),
            color = BluePrimary,
            onClick = onAddSubject
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Subject",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
              )
              Spacer(modifier = Modifier.width(4.dp))
              Text("නව විෂයක්", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
          }
        }
      }
    }

    // 🛡️ 10 ශ්‍රේණිය වාර විභාග ප්‍රශ්න පත්‍ර (Grade 10 Papers Sub-Component at the very top of Grade 10)
    if (grade == "10") {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        border = BorderStroke(1.2.dp, Color(0xFFDC2626)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
          .fillMaxWidth()
          .testTag("grade_10_papers_portal_card")
          .clickable { onOpenGrade10TermTestPortal(Grade10WebSource.GOVDOC) }
      ) {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .background(
              Brush.horizontalGradient(
                colors = listOf(
                  Color(0xFF0F172A),
                  Color(0xFF450A0A),
                  Color(0xFF7F1D1D)
                )
              )
            )
            .padding(horizontal = 12.dp, vertical = 9.dp)
        ) {
          Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
              ) {
                Box(
                  modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFDC2626).copy(alpha = 0.25f)),
                  contentAlignment = Alignment.Center
                ) {
                  Text("📑", fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                      text = "10 වසර වාර විභාග ප්‍රශ්න පත්‍ර",
                      fontSize = 12.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFFFECACA)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Surface(
                      shape = RoundedCornerShape(4.dp),
                      color = Color(0xFFDC2626)
                    ) {
                      Text(
                        text = "PAPERS PORTAL",
                        fontSize = 7.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                      )
                    }
                  }
                  Spacer(modifier = Modifier.height(2.dp))
                  Text(
                    text = "GovDoc.lk, e-Thaksalawa & PastPapers.wiki නිල වාර විභාග",
                    fontSize = 9.sp,
                    color = Color(0xFFE2E8F0),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                }
              }
              Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = "Open Grade 10 Papers",
                tint = Color(0xFFFECACA),
                modifier = Modifier.size(13.dp)
              )
            }

            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
              Button(
                onClick = { onOpenGrade10TermTestPortal(Grade10WebSource.GOVDOC) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
                shape = RoundedCornerShape(6.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 3.dp)
              ) {
                Text("GovDoc Papers", fontSize = 9.5.sp, color = Color.White, fontWeight = FontWeight.Bold)
              }
              OutlinedButton(
                onClick = { onOpenGrade10TermTestPortal(Grade10WebSource.ETHAKSALAWA) },
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFFECACA)),
                border = BorderStroke(1.dp, Color(0xFFFECACA).copy(alpha = 0.5f)),
                shape = RoundedCornerShape(6.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 3.dp)
              ) {
                Text("e-Thaksalawa", fontSize = 9.5.sp, color = Color(0xFFFECACA))
              }
              OutlinedButton(
                onClick = { onOpenGrade10TermTestPortal(Grade10WebSource.PASTPAPERS_WIKI) },
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFFECACA)),
                border = BorderStroke(1.dp, Color(0xFFFECACA).copy(alpha = 0.5f)),
                shape = RoundedCornerShape(6.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 3.dp)
              ) {
                Text("PastPapers.wiki", fontSize = 9.5.sp, color = Color(0xFFFECACA))
              }
            }
          }
        }
      }
    }

    // 🛡️ 11 ශ්‍රේණිය වාර විභාග ප්‍රශ්න පත්‍ර (Grade 11 Papers Sub-Component at the very top of Grade 11)
    if (grade == "11") {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        border = BorderStroke(1.2.dp, Color(0xFF059669)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
          .fillMaxWidth()
          .testTag("grade_11_papers_portal_card")
          .clickable { onOpenGrade11TermTestPortal(Grade11WebSource.GOVDOC, null, null) }
      ) {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .background(
              Brush.horizontalGradient(
                colors = listOf(
                  Color(0xFF0F172A),
                  Color(0xFF064E3B),
                  Color(0xFF047857)
                )
              )
            )
            .padding(horizontal = 12.dp, vertical = 9.dp)
        ) {
          Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
              ) {
                Box(
                  modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF10B981).copy(alpha = 0.25f)),
                  contentAlignment = Alignment.Center
                ) {
                  Text("📑", fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                      text = "11 වසර වාර විභාග ප්‍රශ්න පත්‍ර",
                      fontSize = 12.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFFA7F3D0)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Surface(
                      shape = RoundedCornerShape(4.dp),
                      color = Color(0xFF059669)
                    ) {
                      Text(
                        text = "PAPERS PORTAL",
                        fontSize = 7.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                      )
                    }
                  }
                  Spacer(modifier = Modifier.height(2.dp))
                  Text(
                    text = "GovDoc.lk, e-Thaksalawa & PastPapers.wiki නිල වාර විභාග",
                    fontSize = 9.sp,
                    color = Color(0xFFE2E8F0),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                }
              }
              Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = "Open Grade 11 Papers",
                tint = Color(0xFFA7F3D0),
                modifier = Modifier.size(13.dp)
              )
            }

            // Quick Portal Access Buttons (3 Websites)
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
              Button(
                onClick = { onOpenGrade11TermTestPortal(Grade11WebSource.GOVDOC, null, null) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669)),
                shape = RoundedCornerShape(6.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 3.dp)
              ) {
                Text("GovDoc Papers", fontSize = 9.5.sp, color = Color.White, fontWeight = FontWeight.Bold)
              }
              OutlinedButton(
                onClick = { onOpenGrade11TermTestPortal(Grade11WebSource.ETHAKSALAWA, null, null) },
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFA7F3D0)),
                border = BorderStroke(1.dp, Color(0xFFA7F3D0).copy(alpha = 0.5f)),
                shape = RoundedCornerShape(6.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 3.dp)
              ) {
                Text("e-Thaksalawa", fontSize = 9.5.sp, color = Color(0xFFA7F3D0))
              }
              OutlinedButton(
                onClick = { onOpenGrade11TermTestPortal(Grade11WebSource.PASTPAPERS_WIKI, null, null) },
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFA7F3D0)),
                border = BorderStroke(1.dp, Color(0xFFA7F3D0).copy(alpha = 0.5f)),
                shape = RoundedCornerShape(6.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 3.dp)
              ) {
                Text("PastPapers.wiki", fontSize = 9.5.sp, color = Color(0xFFA7F3D0))
              }
            }

            // Quick Term Filter Row
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
              listOf(1 to "1 වන වාරය", 2 to "2 වන වාරය", 3 to "3 වන වාරය").forEach { (termNum, termText) ->
                Surface(
                  onClick = { onOpenGrade11TermTestPortal(Grade11WebSource.GOVDOC, null, termNum) },
                  shape = RoundedCornerShape(6.dp),
                  color = Color(0xFF064E3B),
                  border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.4f)),
                  modifier = Modifier.weight(1f)
                ) {
                  Text(
                    text = termText,
                    fontSize = 9.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 3.dp)
                  )
                }
              }
            }
          }
        }
      }
    }

    if (subjectsList.isEmpty()) {
      Surface(
        shape = RoundedCornerShape(16.dp),
        color = SurfaceVariantLight,
        border = BorderStroke(1.dp, NeutralBorderLight),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(
          modifier = Modifier.padding(24.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Icon(
            imageVector = Icons.Default.MenuBook,
            contentDescription = "Empty Subjects",
            tint = BluePrimary,
            modifier = Modifier.size(48.dp)
          )
          Spacer(modifier = Modifier.height(10.dp))
          Text(
            text = "මෙම ශ්‍රේණිය සඳහා විෂයන් නොමැත",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = NeutralDark
          )
          Text(
            text = "නව විෂයක් එක් කිරීමට ඉහත 'නව විෂයක්' බොත්තම ඔබන්න.",
            fontSize = 12.sp,
            color = NeutralMedium,
            modifier = Modifier.padding(top = 4.dp, bottom = 12.dp)
          )
        }
      }
    } else {
      subjectsList.forEach { subject ->
        SubjectPhotoCard(
          subject = subject,
          grade = grade,
          onClick = { onSubjectSelected(subject) }
        )
      }
    }

    Spacer(modifier = Modifier.height(10.dp))
  }
}

@Composable
fun SubjectPhotoCard(
  subject: SubjectItem,
  grade: String,
  onClick: () -> Unit
) {
  Card(
    shape = RoundedCornerShape(12.dp),
    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
    border = BorderStroke(1.dp, subject.color.copy(alpha = 0.35f)),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    modifier = Modifier
      .fillMaxWidth()
      .testTag("subject_card_${subject.id}")
      .clickable { onClick() }
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .background(
          Brush.horizontalGradient(
            colors = listOf(
              Color(0xFF0F172A),
              Color(0xFF1E293B),
              subject.color.copy(alpha = 0.55f)
            )
          )
        )
        .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Box(
          modifier = Modifier
            .size(38.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(subject.color),
          contentAlignment = Alignment.Center
        ) {
          Icon(
            imageVector = subject.icon,
            contentDescription = subject.name,
            tint = Color.White,
            modifier = Modifier.size(20.dp)
          )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(
          modifier = Modifier.weight(1f),
          verticalArrangement = Arrangement.Center
        ) {
          Text(
            text = subject.nameSinhala,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
          Spacer(modifier = Modifier.height(2.dp))
          Text(
            text = "${subject.name} • $grade ශ්‍රේණිය",
            fontSize = 11.sp,
            color = Color(0xFFCBD5E1)
          )
        }

        Icon(
          imageVector = Icons.AutoMirrored.Filled.ArrowForward,
          contentDescription = "Open",
          tint = Color(0xFF94A3B8),
          modifier = Modifier.size(16.dp)
        )
      }
    }
  }
}

fun normalizeSubjectKey(name: String): String {
  val lower = name.lowercase().trim()
  return when {
    lower.contains("භූගෝල") || lower.contains("geography") -> "geography"
    lower.contains("පුරවැසි") || lower.contains("civic") -> "civic"
    lower.contains("නර්තන") || lower.contains("dance") || lower.contains("dancing") -> "dance"
    lower.contains("සංගීත") || lower.contains("music") -> "music"
    lower.contains("චිත්‍ර") || lower.contains("art") -> "art"
    lower.contains("නාට්‍ය") || lower.contains("drama") -> "drama"
    lower.contains("කෘෂි") || lower.contains("ආහාර") || lower.contains("agri") -> "agri"
    lower.contains("සෞඛ්‍ය") || lower.contains("ශාරීරික") || lower.contains("health") -> "health"
    lower.contains("තොරතුරු") || lower.contains("තාක්ෂණ") || lower.contains("ict") -> "ict"
    lower.contains("ව්‍යාපාර") || lower.contains("ගිණුම්") || lower.contains("commerce") || lower.contains("accounting") -> "commerce"
    (lower.contains("විද්‍යා") && !lower.contains("භූගෝල")) || lower.contains("science") -> "science"
    lower.contains("ගණිත") || lower.contains("math") -> "math"
    lower.contains("ඉතිහාස") || lower.contains("history") -> "history"
    lower.contains("බුද්ධ") || lower.contains("buddhism") -> "buddhism"
    lower.contains("සිංහල") || lower.contains("sinhala") -> "sinhala"
    lower.contains("ඉංග්‍රීසි") || lower.contains("english") -> "english"
    else -> lower
  }
}

fun isMatchSubject(itemSubject: String, itemTitle: String, targetSubject: SubjectItem): Boolean {
  val targetKey = normalizeSubjectKey(targetSubject.nameSinhala + " " + targetSubject.name)
  val subjectKey = normalizeSubjectKey(itemSubject)
  val itemKey = if (subjectKey != itemSubject.lowercase().trim() && subjectKey.isNotBlank()) {
    subjectKey
  } else {
    normalizeSubjectKey(itemSubject + " " + itemTitle)
  }
  
  if (targetKey == "geography" && (itemKey != "geography" || (!itemSubject.contains("භූගෝල") && !itemTitle.contains("භූගෝල")))) {
    return false
  }
  if (targetKey == "science" && (itemKey == "geography" || itemSubject.contains("භූගෝල") || itemTitle.contains("භූගෝල"))) {
    return false
  }

  val standardSubjects = listOf(
    "geography", "science", "math", "history", "buddhism", "sinhala",
    "english", "civic", "commerce", "ict", "agri", "health", "music", "dance", "art", "drama"
  )
  if (targetKey in standardSubjects) {
    return itemKey == targetKey
  }

  if (targetKey == itemKey) return true

  return itemSubject.equals(targetSubject.nameSinhala, ignoreCase = true) ||
      (itemSubject.contains(targetSubject.nameSinhala, ignoreCase = true) && !targetSubject.nameSinhala.contains("විද්‍යාව") && !itemSubject.contains("භූගෝල"))
}

data class SubjectQuickAction(
  val icon: String,
  val label: String,
  val bgColor: Color,
  val borderColor: Color,
  val textColor: Color,
  val onClick: () -> Unit
)

/**
 * STEP 3: Content Tabs Screen for a Selected Subject
 * Shows 3 Tabs:
 * Tab 0: කෙටි සටහන් (Short Notes - PDFs)
 * Tab 1: ප්‍රශ්න පත්‍ර (Question Papers - PDFs)
 * Tab 2: කෙටි සටහන් වීඩියෝස් (Video Lessons)
 */
@Composable
fun SubjectContentScreen(
  grade: String,
  subject: SubjectItem,
  selectedTab: Int,
  isAdmin: Boolean = false,
  onTabSelected: (Int) -> Unit,
  notesList: List<ShortNoteItem>,
  papersList: List<QuestionPaperItem>,
  videosList: List<VideoLessonItem>,
  onPdfClick: (title: String, pdfUri: String?, isPasswordProtected: Boolean, password: String?) -> Unit,
  onDeleteNote: (ShortNoteItem) -> Unit,
  onDeletePaper: (QuestionPaperItem) -> Unit,
  onDeleteVideo: (VideoLessonItem) -> Unit,
  onVideoClick: (VideoLessonItem) -> Unit,
  onBackToSubjects: () -> Unit,
  onAddContent: (String) -> Unit,
  onStartQuizSet: (QuizSet) -> Unit = {},
  onOpenFlashcards: () -> Unit = {},
  onOpenPdfAtPage: (pdfUrl: String, title: String, page: Int) -> Unit = { _, _, _ -> },
  onOpenAnalytics: () -> Unit = {},
  onOpenStructuredEssay: () -> Unit = {},
  onOpenFormulaHandbook: () -> Unit = {},
  onOpenVoiceQuiz: () -> Unit = {},
  onOpenEnglishBuilder: () -> Unit = {},
  onOpenSyllabusHub: () -> Unit = {},
  onOpenHistoryMapsAutoCheck: () -> Unit = {},
  onOpenScience500AutoCheck: () -> Unit = {},
  onOpenScienceShortNotes: () -> Unit = {},
  onOpenEnglishShortNotesAutoCheck: () -> Unit = {},
  onOpenGeographyAutoCheck: () -> Unit = {},
  onOpenMathShortNotesAutoCheck: () -> Unit = {},
  onOpenCommerceShortNotes: () -> Unit = {},
  onOpenSpecialMasterFeatures: (SpecialFeatureSection?) -> Unit = {},
  onOpenGrade10TermTestPortal: (Grade10WebSource) -> Unit = {},
  onOpenGrade11TermTestPortal: (Grade11WebSource, String?, Int?) -> Unit = { _, _, _ -> },
  onOpenInteractiveQaHub: (QaHubTab) -> Unit = {},
  onOpenVoiceDoubtSolver: () -> Unit = {},
  initialSearchQuery: String = ""
) {
  var showDeleteConfirmDialog by remember { mutableStateOf(false) }
  var itemToDeleteTitle by remember { mutableStateOf("") }
  var pendingDeleteAction by remember { mutableStateOf<(() -> Unit)?>(null) }
  var noteSearchFilter by remember(initialSearchQuery) { mutableStateOf(initialSearchQuery) }
  var showSanduFullBookReader by remember { mutableStateOf(false) }
  var sanduBookInitialPage by remember { mutableIntStateOf(1) }
  var showCommerceFullBookReader by remember { mutableStateOf(false) }
  var commerceBookInitialPage by remember { mutableIntStateOf(1) }
  var showCommerceMasterHubDialog by remember { mutableStateOf(false) }
  var commerceMasterHubInitialCategory by remember { mutableStateOf<CommerceSectionCategory?>(null) }
  var showCivicsMasterHubDialog by remember { mutableStateOf(false) }
  var civicsMasterHubInitialCategory by remember { mutableStateOf<CivicsSectionCategory?>(null) }
  var showHealthMasterHubDialog by remember { mutableStateOf(false) }
  var healthMasterHubInitialCategory by remember { mutableStateOf<HealthSectionCategory?>(null) }
  var showEnglishMasterHubDialog by remember { mutableStateOf(false) }
  var englishMasterHubInitialCategory by remember { mutableStateOf<EnglishSectionCategory?>(null) }
  var showSinhalaVicharaFullBookReader by remember { mutableStateOf(false) }
  var sinhalaVicharaBookInitialPage by remember { mutableIntStateOf(1) }
  var showScienceDiagramsReader by remember { mutableStateOf(false) }
  var scienceDiagramsInitialPage by remember { mutableIntStateOf(1) }
  var showDancingMasterHubDialog by remember { mutableStateOf(false) }
  var dancingMasterHubInitialCategory by remember { mutableStateOf<DancingSectionCategory?>(null) }
  var showArtMasterHubDialog by remember { mutableStateOf(false) }
  var artMasterHubInitialCategory by remember { mutableStateOf<ArtSectionCategory?>(null) }
  var showMusicMasterHubDialog by remember { mutableStateOf(false) }
  var musicMasterHubInitialCategory by remember { mutableStateOf<MusicSectionCategory?>(null) }
  var showAgriMasterHubDialog by remember { mutableStateOf(false) }
  var agriMasterHubInitialCategory by remember { mutableStateOf<AgriSectionCategory?>(null) }
  var showGeoMasterHubDialog by remember { mutableStateOf(false) }
  var geoMasterHubInitialCategory by remember { mutableStateOf<GeoSectionCategory?>(null) }

  val subjectNotes = remember(notesList, subject.id, noteSearchFilter, grade) {
    notesList.filter { isMatchSubject(it.subject, it.topicSinhala, subject) }
      .filter { note ->
        // Strict exclusion: Remove "විද්‍යාව ප්‍රශ්න 500" from Geography section
        if (subject.nameSinhala.contains("භූගෝල") || subject.name.contains("Geography", ignoreCase = true) || subject.id.contains("geo")) {
          if (note.title.contains("විද්‍යාව ප්‍රශ්න 500") || note.topicSinhala.contains("විද්‍යාව ප්‍රශ්න 500") || note.id.contains("science_500")) {
            return@filter false
          }
        }
        // Strict exclusion: 10 ශ්‍රේණිය චිත්‍ර කලාව කෙටි සටහන් ගොන්නේ ''10 හා 11 ශ්‍රේණි චිත්‍ර කලාව'' යනුවෙන් සදහන් පීඩීඑෆ් එක සම්පූර්ණයෙන්ම ඉවත් කිරීම
        if (grade == "10" && (subject.nameSinhala.contains("චිත්‍ර") || subject.name.contains("Art", ignoreCase = true))) {
          if (note.id == "art_note_gr10_11" || note.title.contains("10 සහ 11 ශ්‍රේණි - චිත්‍ර") || note.topicSinhala.contains("10 සහ 11 ශ්‍රේණි චිත්‍ර") || note.title.contains("10 හා 11 ශ්‍රේණි චිත්‍ර") || note.topicSinhala.contains("10 හා 11 ශ්‍රේණි චිත්‍ර")) {
            return@filter false
          }
        }
        // Strict exclusion: 10 හා 11 ශ්‍රේණි දෙකේම ව්‍යාපාර අධ්‍යයනය හා ගිණුම්කරණය විෂයේ ඇතුලත් "10 සහ 11 ශ්‍රේණිය ව්‍යාපාර අධ්‍යයනය හා ගිණුම්කරණය" පීඩීඑෆ් එක සම්පූර්ණයෙන්ම ඉවත් කිරීම
        if (subject.nameSinhala.contains("ව්‍යාපාර") || subject.nameSinhala.contains("ගිණුම්") || subject.nameSinhala.contains("කොමස්") || subject.name.contains("Commerce", ignoreCase = true) || subject.id.contains("comm")) {
          if (note.id == "commerce_note_gr10_11" ||
              note.title.contains("10 සහ 11 ශ්‍රේණිය - ව්‍යාපාර අධ්‍යයනය හා ගිණුම්කරණය") ||
              note.topicSinhala.contains("10 සහ 11 ශ්‍රේණිය ව්‍යාපාර අධ්‍යයනය හා ගිණුම්කරණය") ||
              note.title.contains("10 හා 11 ශ්‍රේණිය ව්‍යාපාර අධ්‍යයනය හා ගිණුම්කරණය") ||
              note.topicSinhala.contains("10 හා 11 ශ්‍රේණිය ව්‍යාපාර අධ්‍යයනය හා ගිණුම්කරණය")) {
            return@filter false
          }
        }
        // Strict exclusion: 9, 10 හා 11 ශ්‍රේණි ඉතිහාසය විෂයේ "09/10/11 ශ්‍රේණි ඉතිහාසය හිස්තැන් සහිත සිතියම් ගොන්න සහ ස්වයංක්‍රීය සිතියම් ලකුණු කිරීමේ පරීක්ෂාව" PDF එක ඉවත් කිරීම
        if (subject.nameSinhala.contains("ඉතිහාසය") || subject.name.contains("History", ignoreCase = true) || subject.id.contains("history")) {
          if (note.id == "history_maps_fill_blanks_gr09_11" ||
              note.title.contains("හිස්තැන් සහිත සිතියම්") ||
              note.topicSinhala.contains("හිස්තැන් සහිත සිතියම්") ||
              (note.title.contains("09/10/11") && note.title.contains("සිතියම්")) ||
              (note.topicSinhala.contains("09/10/11") && note.topicSinhala.contains("සිතියම්")) ||
              (note.title.contains("09, 10 සහ 11") && note.title.contains("සිතියම්"))) {
            return@filter false
          }
        }
        if (noteSearchFilter.isBlank()) true
        else note.title.contains(noteSearchFilter, ignoreCase = true) ||
             note.topicSinhala.contains(noteSearchFilter, ignoreCase = true) ||
             note.fileName?.contains(noteSearchFilter, ignoreCase = true) == true ||
             note.subject.contains(noteSearchFilter, ignoreCase = true)
      }
  }
  val subjectPapers = remember(papersList, subject.id) {
    papersList.filter { isMatchSubject(it.subject, it.titleSinhala, subject) }
  }
  val activePdfUrl = remember(subjectNotes) {
    subjectNotes.firstOrNull()?.pdfUri ?: "https://drive.google.com/file/d/1V3y65z_15X6zjruQ_I11WhG4EOfDHGm-/preview"
  }

  // Confirmation Dialog for Admin PDF/Note/Paper Deletion
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
          text = "PDF ගොනුව ඉවත් කිරීම (Delete)",
          fontWeight = FontWeight.Bold,
          fontSize = 16.sp,
          color = Color(0xFFDC2626)
        )
      },
      text = {
        Column {
          Text(
            text = "මෙම PDF ගොනුව / සටහන ස්ථිරවම ඉවත් කිරීමට ඔබට අවශ්‍යද?",
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            color = NeutralDark
          )
          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = "ගොනුව: $itemToDeleteTitle",
            fontSize = 12.sp,
            color = NeutralMedium
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "මෙය සිදුකළ පසු ඇප් එක භාවිතා කරන සියලුම පරිශීලකයින්ටද මෙම PDF ගොනුව නොපෙනී යනු ඇත.",
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
          Text("නැත (No)", color = NeutralDark, fontSize = 12.sp)
        }
      }
    )
  }

  // Sandu Theory 100-Pages Full PDF Book Reader Dialog
  if (showSanduFullBookReader) {
    SanduTheory100PagesReaderDialog(
      initialPage = sanduBookInitialPage,
      onDismiss = { showSanduFullBookReader = false }
    )
  }

  // Sandu Commerce Theory 76-Pages Full PDF Book Reader Dialog
  if (showCommerceFullBookReader) {
    SanduCommerceTheoryReaderDialog(
      initialPage = commerceBookInitialPage,
      onDismiss = { showCommerceFullBookReader = false }
    )
  }

  // 🌟 Commerce Grade 10 & 11 Syllabus Master Hub Full Screen Dialog
  if (showCommerceMasterHubDialog) {
    CommerceGrade10And11MasterHubDialog(
      initialGradeTab = when (grade) {
        "10" -> CommerceGradeTab.GRADE_10
        "11" -> CommerceGradeTab.GRADE_11
        else -> CommerceGradeTab.ALL
      },
      initialSectionCategory = commerceMasterHubInitialCategory,
      onDismiss = { showCommerceMasterHubDialog = false },
      onOpenPdfBooklet = {
        showCommerceMasterHubDialog = false
        commerceBookInitialPage = 1
        showCommerceFullBookReader = true
      }
    )
  }

  // Civic Education Grade 10 & 11 Master Hub Fullscreen Dialog
  if (showCivicsMasterHubDialog) {
    CivicsGrade10And11MasterHubDialog(
      initialGradeTab = when (grade) {
        "10" -> CivicsGradeTab.GRADE_10
        "11" -> CivicsGradeTab.GRADE_11
        else -> CivicsGradeTab.ALL
      },
      initialSectionCategory = civicsMasterHubInitialCategory,
      onDismiss = { showCivicsMasterHubDialog = false }
    )
  }

  // Health & Physical Education Grade 10 & 11 Master Hub Fullscreen Dialog
  if (showHealthMasterHubDialog) {
    HealthGrade10And11MasterHubDialog(
      initialGradeTab = when (grade) {
        "10" -> HealthGradeTab.GRADE_10
        "11" -> HealthGradeTab.GRADE_11
        else -> HealthGradeTab.ALL
      },
      initialSectionCategory = healthMasterHubInitialCategory,
      onDismiss = { showHealthMasterHubDialog = false }
    )
  }

  // English Grade 10 & 11 Master Hub Fullscreen Dialog
  if (showEnglishMasterHubDialog) {
    EnglishGrade10And11MasterHubDialog(
      initialGrade = grade,
      initialCategory = englishMasterHubInitialCategory,
      onDismiss = { showEnglishMasterHubDialog = false }
    )
  }

  // Sinhala Literature Vichara Dhara 30-Pages (23 Essays) Full PDF Book Reader Dialog
  if (showSinhalaVicharaFullBookReader) {
    SinhalaShortNotesPdfReaderDialog(
      initialPage = sinhalaVicharaBookInitialPage,
      onDismiss = { showSinhalaVicharaFullBookReader = false }
    )
  }

  // Science Diagrams 11-Pages Full PDF Book Reader Dialog
  if (showScienceDiagramsReader) {
    ScienceDiagramsPdfReaderDialog(
      initialPage = scienceDiagramsInitialPage,
      onDismiss = { showScienceDiagramsReader = false }
    )
  }

  // 💃 Dancing Grade 10 & 11 Master Hub Fullscreen Dialog (Strictly exclusive to Dancing subject only)
  if (showDancingMasterHubDialog) {
    DancingGrade10And11MasterHubDialog(
      initialGradeTab = when (grade) {
        "10" -> DancingGradeTab.GRADE_10
        "11" -> DancingGradeTab.GRADE_11
        else -> DancingGradeTab.ALL
      },
      initialSectionCategory = dancingMasterHubInitialCategory,
      onDismiss = { showDancingMasterHubDialog = false }
    )
  }

  // 🎨 Art Grade 10 & 11 Master Hub Fullscreen Dialog (Strictly exclusive to Art subject only)
  if (showArtMasterHubDialog) {
    ArtGrade10And11MasterHubDialog(
      initialGradeTab = when (grade) {
        "10" -> ArtGradeTab.GRADE_10
        "11" -> ArtGradeTab.GRADE_11
        else -> ArtGradeTab.ALL
      },
      initialSectionCategory = artMasterHubInitialCategory,
      onDismiss = { showArtMasterHubDialog = false }
    )
  }

  // 🎵 Music Grade 10 & 11 Master Hub Fullscreen Dialog (Strictly exclusive to Music subject only)
  if (showMusicMasterHubDialog) {
    MusicGrade10And11MasterHubDialog(
      initialGradeTab = when (grade) {
        "10" -> MusicGradeTab.GRADE_10
        "11" -> MusicGradeTab.GRADE_11
        else -> MusicGradeTab.ALL
      },
      initialSectionCategory = musicMasterHubInitialCategory,
      onDismiss = { showMusicMasterHubDialog = false }
    )
  }

  // 🌱 Agriculture Grade 10 & 11 Master Hub Fullscreen Dialog (Strictly exclusive to Agriculture subject only)
  if (showAgriMasterHubDialog) {
    AgricultureGrade10And11MasterHubDialog(
      initialGradeTab = when (grade) {
        "10" -> AgriGradeTab.GRADE_10
        "11" -> AgriGradeTab.GRADE_11
        else -> AgriGradeTab.ALL
      },
      initialSectionCategory = agriMasterHubInitialCategory,
      onDismiss = { showAgriMasterHubDialog = false }
    )
  }
  if (showGeoMasterHubDialog) {
    GeographyGrade10And11MasterHubDialog(
      initialGradeTab = when (grade) {
        "10" -> GeoGradeTab.GRADE_10
        "11" -> GeoGradeTab.GRADE_11
        else -> GeoGradeTab.ALL
      },
      initialSectionCategory = geoMasterHubInitialCategory,
      onDismiss = { showGeoMasterHubDialog = false }
    )
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp),
    verticalArrangement = Arrangement.spacedBy(14.dp)
  ) {
    // Subject Banner Header with Back Button
    Card(
      shape = RoundedCornerShape(20.dp),
      colors = CardDefaults.cardColors(containerColor = Color.White),
      border = BorderStroke(1.dp, NeutralBorderLight),
      elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
      modifier = Modifier.fillMaxWidth()
    ) {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .height(115.dp)
      ) {
        Image(
          painter = painterResource(id = getSubjectBgImage(subject.nameSinhala)),
          contentDescription = subject.nameSinhala,
          modifier = Modifier.fillMaxSize(),
          contentScale = ContentScale.Crop
        )

        Box(
          modifier = Modifier
            .fillMaxSize()
            .background(
              Brush.horizontalGradient(
                colors = listOf(
                  Color.Black.copy(alpha = 0.85f),
                  Color.Black.copy(alpha = 0.35f)
                )
              )
            )
        )

        Row(
          modifier = Modifier
            .fillMaxSize()
            .padding(14.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
          ) {
            Surface(
              shape = CircleShape,
              color = Color.White.copy(alpha = 0.25f),
              onClick = onBackToSubjects,
              modifier = Modifier.testTag("back_to_subjects_btn")
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
              Surface(
                shape = RoundedCornerShape(6.dp),
                color = subject.color
              ) {
                Text(
                  text = "$grade ශ්‍රේණිය",
                  color = Color.White,
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }
              Spacer(modifier = Modifier.height(2.dp))
              Text(
                text = subject.nameSinhala,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Text(
                text = "${subject.name} • 5-Section Hub",
                style = MaterialTheme.typography.bodySmall,
                color = Color.White.copy(alpha = 0.85f),
                fontSize = 11.sp
              )
            }
          }
        }
      }
    }

    // Quick Tool Strip inside Subject - Dynamically tailored ONLY to the selected subject
    val subjectQuickTools = remember(subject.id, subject.nameSinhala, subject.name) {
      val tools = mutableListOf<SubjectQuickAction>()
      val sId = subject.id.lowercase()
      val sName = subject.name.lowercase()
      val sNameSin = subject.nameSinhala

      val isGeo = sId.contains("geo") || sNameSin.contains("භූගෝල") || sName.contains("geography")
      val isAgri = sId.contains("agri") || sNameSin.contains("කෘෂි")
      val isScience = (sId.contains("sci") || sNameSin.equals("විද්‍යාව") || (sNameSin.contains("විද්‍යා") && !isGeo && !isAgri)) && !isGeo && !isAgri
      val isMath = sId.contains("math") || sNameSin.contains("ගණිත") || sName.contains("math")
      val isSinhala = sId.contains("sinhala") || sNameSin.contains("සිංහල") || sName.contains("sinhala")
      val isHistory = sId.contains("history") || sNameSin.contains("ඉතිහාස") || sName.contains("history")
      val isEnglish = sId.contains("english") || sNameSin.contains("ඉංග්‍රීසි") || sName.equals("english")
      val isCommerce = sId.contains("commerce") || sId.contains("acc") || sNameSin.contains("ව්‍යාපාර") || sNameSin.contains("ගිණුම්") || sName.contains("commerce")
      val isIct = sId.contains("ict") || sId.contains("tech") || sNameSin.contains("තොරතුරු") || sNameSin.contains("තාක්ෂණ") || sName.contains("ict")
      val isDancing = sId.contains("dance") || sNameSin.contains("නර්තන") || sName.contains("dance", ignoreCase = true)
      val isArt = sId.contains("art") || sNameSin.contains("චිත්‍ර") || sName.contains("art", ignoreCase = true)
      val isMusic = (sId.contains("music") || sNameSin.contains("සංගීත") || sName.contains("music", ignoreCase = true)) && !isDancing
      val isAesthetic = (sId.contains("drama") || sNameSin.contains("නාට්‍ය")) && !isDancing && !isArt && !isMusic
      val isBuddhism = sId.contains("buddh") || sNameSin.contains("බුද්ධ") || sNameSin.contains("ධර්ම") ||
        sNameSin.contains("ආගම") || sNameSin.contains("ක්‍රිස්තියානි") || sNameSin.contains("කතෝලික") ||
        sNameSin.contains("ඉස්ලාම්") || sNameSin.contains("හින්දු")
      val isCivic = sId.contains("civic") || sNameSin.contains("පුරවැසි")
      val isHealthOrHomeSci = sId.contains("health") || sNameSin.contains("සෞඛ්‍ය") || sNameSin.contains("ගෘහ")
      val isForeignLanguage = sId.contains("tamil") || sId.contains("french") || sId.contains("japan") ||
        sId.contains("german") || sId.contains("chinese") || sId.contains("korean") ||
        sNameSin.contains("දෙමළ") || sNameSin.contains("ප්‍රංශ") || sNameSin.contains("ජපන්")

      // 1. All subjects have Progress / Analytics
      tools.add(
        SubjectQuickAction(
          icon = "📊",
          label = if (isEnglish) "Progress" else "ප්‍රගතිය",
          bgColor = Color(0xFFEFF6FF),
          borderColor = Color(0xFFBFDBFE),
          textColor = Color(0xFF1D4ED8),
          onClick = onOpenAnalytics
        )
      )

      when {
        isScience -> {
          // විද්‍යාව: රූ සටහන් (Science Diagrams), සූත්‍ර (Science Formulas), ප්‍රශ්න 500 (500 Questions), නිර්දේශය (Syllabus)
          tools.add(
            SubjectQuickAction(
              icon = "🔬",
              label = "රූ සටහන්",
              bgColor = Color(0xFFECFDF5),
              borderColor = Color(0xFFA7F3D0),
              textColor = Color(0xFF047857),
              onClick = {
                scienceDiagramsInitialPage = 1
                showScienceDiagramsReader = true
              }
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "🧮",
              label = "සූත්‍ර",
              bgColor = Color(0xFFF0FDF4),
              borderColor = Color(0xFFBBF7D0),
              textColor = Color(0xFF15803D),
              onClick = onOpenFormulaHandbook
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "⚡",
              label = "ප්‍රශ්න 500",
              bgColor = Color(0xFFFAF5FF),
              borderColor = Color(0xFFE9D5FF),
              textColor = Color(0xFF7E22CE),
              onClick = onOpenScience500AutoCheck
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📑",
              label = "නිර්දේශය",
              bgColor = Color(0xFFFFFBEB),
              borderColor = Color(0xFFFDE68A),
              textColor = Color(0xFFB45309),
              onClick = onOpenSyllabusHub
            )
          )
        }

        isMath -> {
          // ගණිතය: සූත්‍ර (Math Formulas), ඒකක 42 (Sandu Theory), පුහුණුව (Practice Flashcards), නිර්දේශය (Syllabus)
          tools.add(
            SubjectQuickAction(
              icon = "🧮",
              label = "සූත්‍ර",
              bgColor = Color(0xFFF0FDF4),
              borderColor = Color(0xFFBBF7D0),
              textColor = Color(0xFF15803D),
              onClick = onOpenFormulaHandbook
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📐",
              label = "ඒකක 42",
              bgColor = Color(0xFFF0F9FF),
              borderColor = Color(0xFFBAE6FD),
              textColor = Color(0xFF0369A1),
              onClick = onOpenMathShortNotesAutoCheck
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "⚡",
              label = "පුහුණුව",
              bgColor = Color(0xFFFAF5FF),
              borderColor = Color(0xFFE9D5FF),
              textColor = Color(0xFF7E22CE),
              onClick = onOpenFlashcards
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📑",
              label = "නිර්දේශය",
              bgColor = Color(0xFFFFFBEB),
              borderColor = Color(0xFFFDE68A),
              textColor = Color(0xFFB45309),
              onClick = onOpenSyllabusHub
            )
          )
        }

        isSinhala -> {
          // සිංහල: රචනා (Structured Essays), විචාර ධාරා (Literature Reader), වියරණ (Grammar & Flashcards), නිර්දේශය (Syllabus)
          tools.add(
            SubjectQuickAction(
              icon = "📝",
              label = "රචනා",
              bgColor = Color(0xFFFAF5FF),
              borderColor = Color(0xFFE9D5FF),
              textColor = Color(0xFF7E22CE),
              onClick = onOpenStructuredEssay
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📖",
              label = "විචාර ධාරා",
              bgColor = Color(0xFFFEF2F2),
              borderColor = Color(0xFFFECACA),
              textColor = Color(0xFFB91C1C),
              onClick = {
                sinhalaVicharaBookInitialPage = 1
                showSinhalaVicharaFullBookReader = true
              }
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "✍️",
              label = "වියරණ",
              bgColor = Color(0xFFF0FDF4),
              borderColor = Color(0xFFBBF7D0),
              textColor = Color(0xFF15803D),
              onClick = onOpenFlashcards
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📑",
              label = "නිර්දේශය",
              bgColor = Color(0xFFFFFBEB),
              borderColor = Color(0xFFFDE68A),
              textColor = Color(0xFFB45309),
              onClick = onOpenSyllabusHub
            )
          )
        }

        isHistory -> {
          // ඉතිහාසය: රචනා (Structured Essays), කාලරේඛා (Timelines), නිර්දේශය (Syllabus)
          tools.add(
            SubjectQuickAction(
              icon = "📝",
              label = "රචනා",
              bgColor = Color(0xFFFAF5FF),
              borderColor = Color(0xFFE9D5FF),
              textColor = Color(0xFF7E22CE),
              onClick = onOpenStructuredEssay
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "⏳",
              label = "කාලරේඛා",
              bgColor = Color(0xFFFFF7ED),
              borderColor = Color(0xFFFED7AA),
              textColor = Color(0xFFC2410C),
              onClick = onOpenFlashcards
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📑",
              label = "නිර්දේශය",
              bgColor = Color(0xFFFFFBEB),
              borderColor = Color(0xFFFDE68A),
              textColor = Color(0xFFB45309),
              onClick = onOpenSyllabusHub
            )
          )
        }

        isEnglish -> {
          // English: Words (Vocabulary Builder), Writing (Structured Essays), Grammar (Short Notes), Syllabus
          tools.add(
            SubjectQuickAction(
              icon = "🔤",
              label = "Words",
              bgColor = Color(0xFFFFFBEB),
              borderColor = Color(0xFFFDE68A),
              textColor = Color(0xFFB45309),
              onClick = onOpenEnglishBuilder
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📝",
              label = "Writing",
              bgColor = Color(0xFFFAF5FF),
              borderColor = Color(0xFFE9D5FF),
              textColor = Color(0xFF7E22CE),
              onClick = onOpenStructuredEssay
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "⚡",
              label = "Grammar",
              bgColor = Color(0xFFF0FDF4),
              borderColor = Color(0xFFBBF7D0),
              textColor = Color(0xFF15803D),
              onClick = onOpenEnglishShortNotesAutoCheck
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📑",
              label = "Syllabus",
              bgColor = Color(0xFFF0F9FF),
              borderColor = Color(0xFFBAE6FD),
              textColor = Color(0xFF0369A1),
              onClick = onOpenSyllabusHub
            )
          )
        }

        isGeo -> {
          // භූගෝල විද්‍යාව: සිතියම් (Topo Maps Auto-Check), රචනා (Geography Essays), කරුණු (Key Concepts), නිර්දේශය (Syllabus)
          tools.add(
            SubjectQuickAction(
              icon = "🗺️",
              label = "සිතියම්",
              bgColor = Color(0xFFECFDF5),
              borderColor = Color(0xFFA7F3D0),
              textColor = Color(0xFF047857),
              onClick = onOpenGeographyAutoCheck
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📝",
              label = "රචනා",
              bgColor = Color(0xFFFAF5FF),
              borderColor = Color(0xFFE9D5FF),
              textColor = Color(0xFF7E22CE),
              onClick = onOpenStructuredEssay
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "💡",
              label = "කරුණු",
              bgColor = Color(0xFFFFF7ED),
              borderColor = Color(0xFFFED7AA),
              textColor = Color(0xFFC2410C),
              onClick = onOpenFlashcards
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📑",
              label = "නිර්දේශය",
              bgColor = Color(0xFFFFFBEB),
              borderColor = Color(0xFFFDE68A),
              textColor = Color(0xFFB45309),
              onClick = onOpenSyllabusHub
            )
          )
        }

        isCommerce -> {
          // ව්‍යාපාර හා ගිණුම්කරණය: සමීකරණ (Accounting Equations), සටහන් (Sandu Theory 76 Pages), රචනා (Business Essays), නිර්දේශය (Syllabus)
          tools.add(
            SubjectQuickAction(
              icon = "🧮",
              label = "සමීකරණ",
              bgColor = Color(0xFFF0FDF4),
              borderColor = Color(0xFFBBF7D0),
              textColor = Color(0xFF15803D),
              onClick = onOpenFormulaHandbook
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📑",
              label = "සටහන්",
              bgColor = Color(0xFFF0F9FF),
              borderColor = Color(0xFFBAE6FD),
              textColor = Color(0xFF0369A1),
              onClick = {
                commerceBookInitialPage = 1
                showCommerceFullBookReader = true
              }
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📝",
              label = "රචනා",
              bgColor = Color(0xFFFAF5FF),
              borderColor = Color(0xFFE9D5FF),
              textColor = Color(0xFF7E22CE),
              onClick = onOpenStructuredEssay
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📑",
              label = "නිර්දේශය",
              bgColor = Color(0xFFFFFBEB),
              borderColor = Color(0xFFFDE68A),
              textColor = Color(0xFFB45309),
              onClick = onOpenSyllabusHub
            )
          )
        }

        isIct -> {
          // ICT: සංකල්ප (Logic & Formulas), විවරණ (Structured Theory), පුහුණුව (Flashcards), නිර්දේශය (Syllabus)
          tools.add(
            SubjectQuickAction(
              icon = "💻",
              label = "සංකල්ප",
              bgColor = Color(0xFFF0FDF4),
              borderColor = Color(0xFFBBF7D0),
              textColor = Color(0xFF15803D),
              onClick = onOpenFormulaHandbook
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📝",
              label = "විවරණ",
              bgColor = Color(0xFFFAF5FF),
              borderColor = Color(0xFFE9D5FF),
              textColor = Color(0xFF7E22CE),
              onClick = onOpenStructuredEssay
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "⚡",
              label = "පුහුණුව",
              bgColor = Color(0xFFECFDF5),
              borderColor = Color(0xFFA7F3D0),
              textColor = Color(0xFF047857),
              onClick = onOpenFlashcards
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📑",
              label = "නිර්දේශය",
              bgColor = Color(0xFFFFFBEB),
              borderColor = Color(0xFFFDE68A),
              textColor = Color(0xFFB45309),
              onClick = onOpenSyllabusHub
            )
          )
        }

        isDancing -> {
          // 💃 10 & 11 නර්තනය පමණක්: ත්‍රිවිධ සම්ප්‍රදාය, වන්නම් 18, අභිනය & මුද්‍රා, ප්‍රායෝගික & Viva, O/L MCQs
          tools.add(
            SubjectQuickAction(
              icon = "💃",
              label = "සම්ප්‍රදාය",
              bgColor = Color(0xFFFFF1F2),
              borderColor = Color(0xFFFECDD3),
              textColor = Color(0xFFBE123C),
              onClick = {
                dancingMasterHubInitialCategory = DancingSectionCategory.TRADITIONS_AND_DRUMS
                showDancingMasterHubDialog = true
              }
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "🦚",
              label = "වන්නම් 18",
              bgColor = Color(0xFFF0F9FF),
              borderColor = Color(0xFFBAE6FD),
              textColor = Color(0xFF0369A1),
              onClick = {
                dancingMasterHubInitialCategory = DancingSectionCategory.VANNAM_18
                showDancingMasterHubDialog = true
              }
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "🖐️",
              label = "මුද්‍රා",
              bgColor = Color(0xFFFAF5FF),
              borderColor = Color(0xFFE9D5FF),
              textColor = Color(0xFF7E22CE),
              onClick = {
                dancingMasterHubInitialCategory = DancingSectionCategory.ABHINAYA_AND_MUDRAS
                showDancingMasterHubDialog = true
              }
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "🎙️",
              label = "ප්‍රායෝගික",
              bgColor = Color(0xFFECFDF5),
              borderColor = Color(0xFFA7F3D0),
              textColor = Color(0xFF047857),
              onClick = {
                dancingMasterHubInitialCategory = DancingSectionCategory.PRACTICAL_AND_VIVA
                showDancingMasterHubDialog = true
              }
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "🎯",
              label = "O/L MCQs",
              bgColor = Color(0xFFFEF2F2),
              borderColor = Color(0xFFFECACA),
              textColor = Color(0xFFDC2626),
              onClick = {
                dancingMasterHubInitialCategory = DancingSectionCategory.EXAM_MCQ_AND_ESSAYS
                showDancingMasterHubDialog = true
              }
            )
          )
        }

        isArt -> {
          // 🎨 10 & 11 චිත්‍ර කලාව පමණක්: දේශීය උරුමය, ලෝක කලාව, වර්ණ න්‍යාය, ප්‍රායෝගික, O/L MCQs
          tools.add(
            SubjectQuickAction(
              icon = "🏛️",
              label = "දේශීය කලාව",
              bgColor = Color(0xFFFFFBEB),
              borderColor = Color(0xFFFDE68A),
              textColor = Color(0xFFB45309),
              onClick = {
                artMasterHubInitialCategory = ArtSectionCategory.SRI_LANKAN_ART
                showArtMasterHubDialog = true
              }
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "🌍",
              label = "ලෝක කලාව",
              bgColor = Color(0xFFF0F9FF),
              borderColor = Color(0xFFBAE6FD),
              textColor = Color(0xFF0369A1),
              onClick = {
                artMasterHubInitialCategory = ArtSectionCategory.WORLD_ART
                showArtMasterHubDialog = true
              }
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "🎨",
              label = "වර්ණ න්‍යාය",
              bgColor = Color(0xFFFAF5FF),
              borderColor = Color(0xFFE9D5FF),
              textColor = Color(0xFF7E22CE),
              onClick = {
                artMasterHubInitialCategory = ArtSectionCategory.ELEMENTS_AND_COLOR
                showArtMasterHubDialog = true
              }
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "🖌️",
              label = "ප්‍රායෝගික",
              bgColor = Color(0xFFECFDF5),
              borderColor = Color(0xFFA7F3D0),
              textColor = Color(0xFF047857),
              onClick = {
                artMasterHubInitialCategory = ArtSectionCategory.PRACTICAL_TECHNIQUES
                showArtMasterHubDialog = true
              }
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "🎯",
              label = "O/L MCQs",
              bgColor = Color(0xFFFEF2F2),
              borderColor = Color(0xFFFECACA),
              textColor = Color(0xFFDC2626),
              onClick = {
                artMasterHubInitialCategory = ArtSectionCategory.EXAM_MCQ_AND_ESSAYS
                showArtMasterHubDialog = true
              }
            )
          )
        }

        isMusic -> {
          // 🎵 10 & 11 පෙරදිග සංගීතය පමණක්: රාග 8, තාල පද්ධතිය, ජන ගී, වාද්‍ය භාණ්ඩ, Viva, O/L MCQs
          tools.add(
            SubjectQuickAction(
              icon = "🎵",
              label = "රාග 8",
              bgColor = Color(0xFFFDF4FF),
              borderColor = Color(0xFFF0ABFC),
              textColor = Color(0xFFA21CAF),
              onClick = {
                musicMasterHubInitialCategory = MusicSectionCategory.RAGAS_AND_SWARAS
                showMusicMasterHubDialog = true
              }
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "🥁",
              label = "තාල පද්ධතිය",
              bgColor = Color(0xFFF0F9FF),
              borderColor = Color(0xFFBAE6FD),
              textColor = Color(0xFF0369A1),
              onClick = {
                musicMasterHubInitialCategory = MusicSectionCategory.THALAS_AND_LAYA
                showMusicMasterHubDialog = true
              }
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "🌾",
              label = "ජන ගී",
              bgColor = Color(0xFFECFDF5),
              borderColor = Color(0xFFA7F3D0),
              textColor = Color(0xFF047857),
              onClick = {
                musicMasterHubInitialCategory = MusicSectionCategory.FOLK_AND_THEATRE
                showMusicMasterHubDialog = true
              }
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "🪕",
              label = "වාද්‍ය භාණ්ඩ",
              bgColor = Color(0xFFFFFBEB),
              borderColor = Color(0xFFFDE68A),
              textColor = Color(0xFFB45309),
              onClick = {
                musicMasterHubInitialCategory = MusicSectionCategory.INSTRUMENTS_AND_VOICE
                showMusicMasterHubDialog = true
              }
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "🎙️",
              label = "ප්‍රායෝගික/Viva",
              bgColor = Color(0xFFFFF1F2),
              borderColor = Color(0xFFFECDD3),
              textColor = Color(0xFFBE123C),
              onClick = {
                musicMasterHubInitialCategory = MusicSectionCategory.PRACTICAL_AND_VIVA
                showMusicMasterHubDialog = true
              }
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "🎯",
              label = "O/L MCQs",
              bgColor = Color(0xFFFEF2F2),
              borderColor = Color(0xFFFECACA),
              textColor = Color(0xFFDC2626),
              onClick = {
                musicMasterHubInitialCategory = MusicSectionCategory.EXAM_MCQ_AND_ESSAYS
                showMusicMasterHubDialog = true
              }
            )
          )
        }

        isAesthetic -> {
          // සෞන්දර්ය විෂයන් (සංගීතය, නර්තනය, නාට්‍ය, චිත්‍ර): Viva (Voice Practical & Viva), රචනා (Theory Essays), ප්‍රායෝගික (Practicals), නිර්දේශය (Syllabus)
          tools.add(
            SubjectQuickAction(
              icon = "🎙️",
              label = "Viva",
              bgColor = Color(0xFFFEF2F2),
              borderColor = Color(0xFFFECACA),
              textColor = Color(0xFFB91C1C),
              onClick = onOpenVoiceQuiz
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📝",
              label = "රචනා",
              bgColor = Color(0xFFFAF5FF),
              borderColor = Color(0xFFE9D5FF),
              textColor = Color(0xFF7E22CE),
              onClick = onOpenStructuredEssay
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "🎨",
              label = "ප්‍රායෝගික",
              bgColor = Color(0xFFECFDF5),
              borderColor = Color(0xFFA7F3D0),
              textColor = Color(0xFF047857),
              onClick = onOpenFlashcards
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📑",
              label = "නිර්දේශය",
              bgColor = Color(0xFFFFFBEB),
              borderColor = Color(0xFFFDE68A),
              textColor = Color(0xFFB45309),
              onClick = onOpenSyllabusHub
            )
          )
        }

        isBuddhism -> {
          // බුද්ධ ධර්මය & ආගමික විෂයන්: රචනා (Dhamma Essays), කරුණු (Teachings / Gathas), නිර්දේශය (Syllabus)
          tools.add(
            SubjectQuickAction(
              icon = "📝",
              label = "රචනා",
              bgColor = Color(0xFFFAF5FF),
              borderColor = Color(0xFFE9D5FF),
              textColor = Color(0xFF7E22CE),
              onClick = onOpenStructuredEssay
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "🪷",
              label = "කරුණු",
              bgColor = Color(0xFFECFDF5),
              borderColor = Color(0xFFA7F3D0),
              textColor = Color(0xFF047857),
              onClick = onOpenFlashcards
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📑",
              label = "නිර්දේශය",
              bgColor = Color(0xFFFFFBEB),
              borderColor = Color(0xFFFDE68A),
              textColor = Color(0xFFB45309),
              onClick = onOpenSyllabusHub
            )
          )
        }

        isCivic -> {
          // පුරවැසි අධ්‍යාපනය: රචනා (Civics Essays), ව්‍යවස්ථාව (Constitution / Flashcards), නිර්දේශය (Syllabus)
          tools.add(
            SubjectQuickAction(
              icon = "📝",
              label = "රචනා",
              bgColor = Color(0xFFFAF5FF),
              borderColor = Color(0xFFE9D5FF),
              textColor = Color(0xFF7E22CE),
              onClick = onOpenStructuredEssay
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "🏛️",
              label = "ව්‍යවස්ථාව",
              bgColor = Color(0xFFECFDF5),
              borderColor = Color(0xFFA7F3D0),
              textColor = Color(0xFF047857),
              onClick = onOpenFlashcards
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📑",
              label = "නිර්දේශය",
              bgColor = Color(0xFFFFFBEB),
              borderColor = Color(0xFFFDE68A),
              textColor = Color(0xFFB45309),
              onClick = onOpenSyllabusHub
            )
          )
        }

        isAgri || isHealthOrHomeSci -> {
          // කෘෂිකර්මය / සෞඛ්‍යය / ගෘහ විද්‍යාව: රචනා (Structured Essays), ප්‍රායෝගික (Practicals), නිර්දේශය (Syllabus)
          tools.add(
            SubjectQuickAction(
              icon = "📝",
              label = "රචනා",
              bgColor = Color(0xFFFAF5FF),
              borderColor = Color(0xFFE9D5FF),
              textColor = Color(0xFF7E22CE),
              onClick = onOpenStructuredEssay
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "💡",
              label = "ප්‍රායෝගික",
              bgColor = Color(0xFFECFDF5),
              borderColor = Color(0xFFA7F3D0),
              textColor = Color(0xFF047857),
              onClick = onOpenFlashcards
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📑",
              label = "නිර්දේශය",
              bgColor = Color(0xFFFFFBEB),
              borderColor = Color(0xFFFDE68A),
              textColor = Color(0xFFB45309),
              onClick = onOpenSyllabusHub
            )
          )
        }

        isForeignLanguage -> {
          // භාෂා: Words (Vocab Builder), Writing (Essays), Oral (Speaking / Viva), Syllabus
          tools.add(
            SubjectQuickAction(
              icon = "🔤",
              label = "Words",
              bgColor = Color(0xFFFFFBEB),
              borderColor = Color(0xFFFDE68A),
              textColor = Color(0xFFB45309),
              onClick = onOpenEnglishBuilder
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📝",
              label = "Writing",
              bgColor = Color(0xFFFAF5FF),
              borderColor = Color(0xFFE9D5FF),
              textColor = Color(0xFF7E22CE),
              onClick = onOpenStructuredEssay
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "🎙️",
              label = "Oral",
              bgColor = Color(0xFFFEF2F2),
              borderColor = Color(0xFFFECACA),
              textColor = Color(0xFFB91C1C),
              onClick = onOpenVoiceQuiz
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📑",
              label = "Syllabus",
              bgColor = Color(0xFFF0F9FF),
              borderColor = Color(0xFFBAE6FD),
              textColor = Color(0xFF0369A1),
              onClick = onOpenSyllabusHub
            )
          )
        }

        else -> {
          // General default:
          tools.add(
            SubjectQuickAction(
              icon = "📝",
              label = "රචනා",
              bgColor = Color(0xFFFAF5FF),
              borderColor = Color(0xFFE9D5FF),
              textColor = Color(0xFF7E22CE),
              onClick = onOpenStructuredEssay
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "⚡",
              label = "පුහුණුව",
              bgColor = Color(0xFFECFDF5),
              borderColor = Color(0xFFA7F3D0),
              textColor = Color(0xFF047857),
              onClick = onOpenFlashcards
            )
          )
          tools.add(
            SubjectQuickAction(
              icon = "📑",
              label = "නිර්දේශය",
              bgColor = Color(0xFFFFFBEB),
              borderColor = Color(0xFFFDE68A),
              textColor = Color(0xFFB45309),
              onClick = onOpenSyllabusHub
            )
          )
        }
      }

      tools
    }

    // Quick Tool Strip inside Subject - Dynamically tailored ONLY to the selected subject
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
      subjectQuickTools.forEach { tool ->
        Surface(
          onClick = tool.onClick,
          shape = RoundedCornerShape(10.dp),
          color = tool.bgColor,
          border = BorderStroke(1.dp, tool.borderColor),
          modifier = Modifier.weight(1f)
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 2.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
          ) {
            Text(tool.icon, fontSize = 11.sp)
            Spacer(modifier = Modifier.width(2.dp))
            Text(
              text = tool.label,
              fontSize = 9.sp,
              fontWeight = FontWeight.Bold,
              color = tool.textColor,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
          }
        }
      }
    }

    // 4-Section Subject Hub: 1. කෙටි සටහන් | 2. ප්‍රශ්න පත්‍ර | 3. ස්වයං පුහුණු | 4. ⚡ AI Assistant
    Surface(
      shape = RoundedCornerShape(16.dp),
      color = SurfaceVariantLight,
      border = BorderStroke(1.dp, NeutralBorderLight),
      modifier = Modifier.fillMaxWidth()
    ) {
      ScrollableTabRow(
        selectedTabIndex = selectedTab,
        containerColor = Color.Transparent,
        contentColor = BluePrimary,
        edgePadding = 8.dp,
        indicator = { tabPositions ->
          if (selectedTab < tabPositions.size) {
            TabRowDefaults.SecondaryIndicator(
              Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
              color = if (selectedTab >= 3) Color(0xFF7C3AED) else BluePrimary,
              height = 3.dp
            )
          }
        }
      ) {
        val tabTitles = listOf(
          "කෙටි සටහන්",
          "ප්‍රශ්න පත්‍ර",
          "ස්වයං පුහුණු",
          "⚡ AI Assistant"
        )
        val tabIcons = listOf(
          Icons.Default.Description,
          Icons.Default.Quiz,
          Icons.Default.MenuBook,
          Icons.Default.AutoAwesome
        )

        tabTitles.forEachIndexed { index, title ->
          val isSelected = selectedTab == index
          val isAiHighlighted = index >= 3

          Tab(
            selected = isSelected,
            onClick = { onTabSelected(index) },
            text = {
              Text(
                text = title,
                fontSize = 11.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = when {
                  isSelected && isAiHighlighted -> Color(0xFF7C3AED)
                  isSelected -> BluePrimary
                  isAiHighlighted -> Color(0xFF6D28D9)
                  else -> NeutralMedium
                },
                maxLines = 1
              )
            },
            icon = {
              Icon(
                imageVector = tabIcons[index],
                contentDescription = title,
                tint = when {
                  isSelected && isAiHighlighted -> Color(0xFF7C3AED)
                  isSelected -> BluePrimary
                  isAiHighlighted -> Color(0xFF6D28D9)
                  else -> NeutralMedium
                },
                modifier = Modifier.size(17.dp)
              )
            },
            modifier = Modifier.testTag("content_tab_$index")
          )
        }
      }
    }

    // 🌟 DEDICATED SUBJECT SPECIAL MASTER INFO (Diagrams, 20x20 Bank, Timeline, Maps, Ledger, Writing Vault)
    val specInfo = remember(subject.nameSinhala) {
      when {
        subject.nameSinhala.contains("විද්‍යාව") && !subject.nameSinhala.contains("භූගෝල") ->
          SubjectSpecialInfo(SpecialFeatureSection.SCIENCE_DIAGRAMS, "විද්‍යාව රූප සටහන් & නිල කරුණු බැංකුව (කාණ්ඩ 20 • කරුණු 400)", "සාමාන්‍ය පෙළ විද්‍යාව විෂය නිර්දේශයේ සියලු රූප සටහන් & ඒකක 36 කරුණු 400", "🔬", Color(0xFF0D9488))
        subject.nameSinhala.contains("ඉංග්‍රීසි") || subject.name.contains("English") ->
          SubjectSpecialInfo(SpecialFeatureSection.ENGLISH_WRITING_VAULT, "English Writing Vault, Verbs & 400 Master Points", "Notices, Letters, Essays, Bar Charts, Grammar & Irregular Verbs", "✍️", Color(0xFF0284C7))
        subject.nameSinhala.contains("ඉතිහාසය") ->
          SubjectSpecialInfo(SpecialFeatureSection.HISTORY_TIMELINE_MAPS, "ඉතිහාසය කාල රේඛාව, සිතියම් & කරුණු බැංකුව (කාණ්ඩ 20 • කරුණු 400)", "ප්‍රාග් ඓතිහාසික සිට නිදහස දක්වා යුග සහ සිතියම් ලකුණු 400", "🏛️", Color(0xFFD97706))
        subject.nameSinhala.contains("ගණිත") || subject.name.contains("Math", ignoreCase = true) ->
          SubjectSpecialInfo(SpecialFeatureSection.GEOMETRY_STRUCTURED, "ජ්‍යාමිතිය ව්‍යුහගත ප්‍රශ්න & අනුබද්ධ (කාණ්ඩ 20 • ප්‍රශ්න 400)", "O/L ජ්‍යාමිතිය ව්‍යුහගත ගැටලු විසඳන ආකාරය, පියවරෙන් පියවර සාධනය සහ අනුබද්ධ කොටස්", "📐", Color(0xFF2563EB))
        subject.nameSinhala.contains("භූගෝල") ->
          SubjectSpecialInfo(SpecialFeatureSection.GEOGRAPHY_TOPOMAPS, "1:50,000 භූ ලක්ෂණ සිතියම් & නිල කරුණු බැංකුව (කාණ්ඩ 20 • කරුණු 400)", "සමෝච්ච රේඛා, ජලාපවහනය, ලංකා හා ලෝක සිතියම් කරුණු 400", "🗺️", Color(0xFF059669))
        subject.nameSinhala.contains("ව්‍යාපාර") || subject.nameSinhala.contains("ගිණුම්") || subject.nameSinhala.contains("වාණිජ") ->
          SubjectSpecialInfo(SpecialFeatureSection.COMMERCE_DOUBLE_ENTRY, "ද්විත්ව සටහන්, මූල්‍ය ප්‍රකාශන & කරුණු බැංකුව (කාණ්ඩ 20 • කරුණු 400)", "ගිණුම්කරණ සමීකරණය, ශේෂ පත්‍රය, ලාභ අලාභ සහ ව්‍යාපාර කරුණු 400", "📊", Color(0xFF7C3AED))
        subject.nameSinhala.contains("නර්තන") ->
          SubjectSpecialInfo(SpecialFeatureSection.DANCING_TRADITIONS, "දේශීය නර්තන සම්ප්‍රදාය, වන්නම් & කරුණු බැංකුව (කාණ්ඩ 20 • කරුණු 400)", "උඩරට, පහතරට, සබරගමු සම්ප්‍රදාය, බෙර වාදනය & වන්නම් 18 කරුණු 400", "💃", Color(0xFFE11D48))
        subject.nameSinhala.contains("චිත්‍ර") || subject.name.contains("Art", ignoreCase = true) || subject.id.contains("art") ->
          SubjectSpecialInfo(SpecialFeatureSection.OFFICIAL_MARKING_SCHEME, "චිත්‍ර කලාව දේශීය & ලෝක කලා Master Hub", "සීගිරිය, පුනරුදය, වර්ණ න්‍යාය, දෘෂ්ටිකෝණය & MCQs", "🎨", Color(0xFFEA580C))
        subject.nameSinhala.contains("සංගීත") || subject.name.contains("Music", ignoreCase = true) || subject.id.contains("music") ->
          SubjectSpecialInfo(SpecialFeatureSection.OFFICIAL_MARKING_SCHEME, "පෙරදිග සංගීතය රාග, තාල & ප්‍රායෝගික Master Hub", "රාග 8, තාල පද්ධතිය, ජන ගී, වාද්‍ය භාණ්ඩ, Viva & MCQs", "🎵", Color(0xFFC026D3))
        subject.nameSinhala.contains("සිංහල") ->
          SubjectSpecialInfo(SpecialFeatureSection.SINHALA_LITERATURE, "සිංහල සාහිත්‍යය, ව්‍යාකරණ & කරුණු බැංකුව (කාණ්ඩ 20 • කරුණු 400)", "පද්‍ය විවරණ, ගද්‍ය, නාට්‍ය, අලංකාර සහ ව්‍යාකරණ රීති කරුණු 400", "📜", Color(0xFFE11D48))
        subject.nameSinhala.contains("බුද්ධ") || subject.nameSinhala.contains("ආගම") ->
          SubjectSpecialInfo(SpecialFeatureSection.BUDDHISM_DHAMMA, "බුද්ධ ධර්මය සූත්‍ර, ශාසනය & කරුණු බැංකුව (කාණ්ඩ 20 • කරුණු 400)", "ප්‍රධාන සූත්‍ර, චතුරාර්ය සත්‍යය, ආර්ය අෂ්ටාංගික මාර්ගය & ශාසන කරුණු 400", "☸️", Color(0xFFF59E0B))
        subject.nameSinhala.contains("පුරවැසි") || subject.name.contains("Civic", ignoreCase = true) ->
          SubjectSpecialInfo(SpecialFeatureSection.OFFICIAL_MARKING_SCHEME, "පුරවැසි අධ්‍යාපනය නිල කරුණු බැංකුව (කාණ්ඩ 20 • කරුණු 400)", "ප්‍රජාතන්ත්‍රවාදය, ආණ්ඩුක්‍රම, මානව හිමිකම්, නීතිය සහ යහපාලනය කරුණු 400", "⚖️", Color(0xFF0D9488))
        subject.nameSinhala.contains("තොරතුරු") || subject.name.contains("ICT", ignoreCase = true) ->
          SubjectSpecialInfo(SpecialFeatureSection.OFFICIAL_MARKING_SCHEME, "ICT නිල කරුණු බැංකුව (කාණ්ඩ 20 • කරුණු 400)", "දත්ත නිරූපණය, Pascal/Python, Boolean Logic & වෙබ් නිර්මාණ කරුණු 400", "💻", Color(0xFF0EA5E9))
        else ->
          SubjectSpecialInfo(SpecialFeatureSection.OFFICIAL_MARKING_SCHEME, "${subject.nameSinhala} නිල කරුණු බැංකුව (කාණ්ඩ 20 • කරුණු 400)", "O/L නිල විෂය නිර්දේශයේ කරුණු 400 සහ Marking Schemes", "📋", Color(0xFF2563EB))
      }
    }

    // SECTION 1 (Tab 0): කෙටි සටහන් (Short Notes - PDFs)
    if (selectedTab == 0) {
      if (noteSearchFilter.isNotBlank()) {
        Card(
          shape = RoundedCornerShape(10.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFFEFF6FF)),
          border = BorderStroke(1.dp, Color(0xFF93C5FD)),
          modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
              Icon(Icons.Default.FilterList, contentDescription = null, tint = BluePrimary, modifier = Modifier.size(16.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = "🎯 ඉලක්කගත සටහන් පෙරහන: \"$noteSearchFilter\"",
                fontSize = 11.5.sp,
                color = Color(0xFF1E3A8A),
                fontWeight = FontWeight.Bold
              )
            }
            TextButton(
              onClick = { noteSearchFilter = "" },
              contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp)
            ) {
              Text("සියල්ල (Clear)", fontSize = 10.5.sp, color = BluePrimary, fontWeight = FontWeight.Bold)
            }
          }
        }
      }

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = "කෙටි සටහන් හා PDF ලේඛන (${subjectNotes.size})",
          style = MaterialTheme.typography.titleSmall,
          fontWeight = FontWeight.Bold,
          color = NeutralDark
        )

        if (isAdmin) {
          Button(
            onClick = { onAddContent("NOTE") },
            colors = ButtonDefaults.buttonColors(containerColor = BluePrimary),
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
          ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add", modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text("PDF එකක් එක් කරන්න", fontSize = 11.sp)
          }
        }
      }

      // History Master Hub for History Subject (Strictly History only, never Geography)
      val isHistorySubject = (subject.nameSinhala.contains("ඉතිහාසය") || subject.id.contains("history") || subject.name.contains("History", ignoreCase = true)) &&
          !subject.nameSinhala.contains("භූගෝල") && !subject.id.contains("geo")
      if (isHistorySubject) {
        // 🌟 100% ACCURATE GRADE 10 & 11 HISTORY SYLLABUS MASTER HUB (KINGDOMS, HYDRAULIC, SOURCES, REFORMS, ESSAYS, MCQS)
        HistoryGrade10And11MasterHub(
          currentGrade = grade
        )
      }

      // Science 500 Questions Interactive Auto-Checker Banner for Science Subject (Strictly excluded from Geography)
      val isGeographySubject = subject.nameSinhala.contains("භූගෝල") || subject.nameSinhala.contains("භූගෝලය") || subject.id.contains("geo") || subject.name.contains("Geography", ignoreCase = true)
      if (!isGeographySubject && (subject.nameSinhala.contains("විද්‍යාව") || subject.id.contains("science") || subject.name.equals("Science", ignoreCase = true))) {
        // 🌟 100% ACCURATE GRADE 10 & 11 SCIENCE SYLLABUS MASTER HUB (EQUATIONS, PHYSICS SOLVERS, PRACTICALS, BIOLOGY DIAGRAMS, MCQS)
        ScienceGrade10And11MasterHub(
          currentGrade = grade,
          onOpenFullReader = { pdfUrl ->
            onPdfClick("10 හා 11 ශ්‍රේණි විද්‍යාව විෂය නිර්දේශ Hub", pdfUrl, false, null)
          }
        )

        // 1. Grade 10 & 11 Science Short Notes PDF Hub Banner
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF064E3B)),
          modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable { onOpenScienceShortNotes() }
            .testTag("science_short_notes_subject_banner")
        ) {
          Column(modifier = Modifier.padding(10.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f, fill = false)
              ) {
                Text("🔬", fontSize = 16.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = "10 හා 11 විද්‍යාව කෙටි සටහන් PDF (ඒකක 36)",
                  color = Color.White,
                  fontSize = 13.sp,
                  fontWeight = FontWeight.Bold,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }
              Spacer(modifier = Modifier.width(6.dp))
              Surface(
                color = Color(0xFF10B981),
                shape = RoundedCornerShape(4.dp)
              ) {
                Text(
                  text = "PDF & සූත්‍ර",
                  color = Color.White,
                  fontSize = 8.5.sp,
                  fontWeight = FontWeight.ExtraBold,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                  maxLines = 1
                )
              }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "ජීව, රසායන, භෞතික & පෘථිවි ඒකක 36ම ආවරණය වන සම්පූර්ණ කෙටි සටහන් සහ සූත්‍ර සංග්‍රහය.",
              color = Color(0xFFA7F3D0),
              fontSize = 11.sp,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
              Button(
                onClick = onOpenScienceShortNotes,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
              ) {
                Text("කෙටි සටහන් බලන්න", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }
              OutlinedButton(
                onClick = {
                  onPdfClick(
                    "10 හා 11 ශ්‍රේණි - විද්‍යාව පූර්ණ කෙටි සටහන් සංග්‍රහය (PDF)",
                    Grade10And11ScienceShortNotesRepository.SCIENCE_GR11_FULL_PDF,
                    false,
                    null
                  )
                },
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF6EE7B7)),
                border = BorderStroke(1.dp, Color(0xFF6EE7B7)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
              ) {
                Text("පූර්ණ PDF", fontSize = 11.sp)
              }
            }
          }
        }

        // 2. Science 500 Questions Auto-Checker Banner
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF0F2E22)),
          modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable { onOpenScience500AutoCheck() }
            .testTag("science_500_subject_banner")
        ) {
          Column(modifier = Modifier.padding(10.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f, fill = false)
              ) {
                Text("🧬", fontSize = 16.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = "11 විද්‍යාව ප්‍රශ්න 500 Auto-Checker",
                  color = Color.White,
                  fontSize = 13.sp,
                  fontWeight = FontWeight.Bold,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }
              Spacer(modifier = Modifier.width(6.dp))
              Surface(
                color = Color(0xFF10B981),
                shape = RoundedCornerShape(4.dp)
              ) {
                Text(
                  text = "100% නිවැරදි",
                  color = Color.White,
                  fontSize = 8.5.sp,
                  fontWeight = FontWeight.ExtraBold,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                  maxLines = 1
                )
              }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "ප්‍රශ්න 500 සඳහා එවෙලෙම පිළිතුරු සපයන්න • ස්වයංක්‍රීයව ලකුණු • සවිස්තරාත්මක විවරණ.",
              color = Color(0xFFA7F3D0),
              fontSize = 11.sp,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
              Button(
                onClick = onOpenScience500AutoCheck,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
              ) {
                Text("ප්‍රශ්න 500 පරීක්ෂාව", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }
              OutlinedButton(
                onClick = {
                  onPdfClick(
                    "11 ශ්‍රේණිය - විද්‍යාව ප්‍රශ්න 500 විශේෂ කෙටි සටහන් සහ ප්‍රශ්නෝත්තර සංග්‍රහය (PDF)",
                    Science500Repository.pdfDriveUrl,
                    false,
                    null
                  )
                },
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF6EE7B7)),
                border = BorderStroke(1.dp, Color(0xFF6EE7B7)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
              ) {
                Text("PDF බලන්න", fontSize = 11.sp)
              }
            }
          }
        }
      }

      // English Grade 10 & 11 Master Hub & Auto-Checker for English Subject
      if (subject.nameSinhala.contains("ඉංග්‍රීසි") || subject.name.contains("English", ignoreCase = true) || subject.id.contains("english")) {
        EnglishGrade10And11MasterHubBanner(
          currentGrade = grade,
          onOpenHub = { category ->
            englishMasterHubInitialCategory = category
            showEnglishMasterHubDialog = true
          }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
          modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable { onOpenEnglishShortNotesAutoCheck() }
            .testTag("english_short_notes_subject_banner")
        ) {
          Column(modifier = Modifier.padding(10.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f, fill = false)
              ) {
                Text("🔤", fontSize = 16.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = "09/10/11 ඉංග්‍රීසි කෙටි සටහන් Auto-Checker",
                  color = Color.White,
                  fontSize = 13.sp,
                  fontWeight = FontWeight.Bold,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }
              Spacer(modifier = Modifier.width(6.dp))
              Surface(
                color = Color(0xFF38BDF8),
                shape = RoundedCornerShape(4.dp)
              ) {
                Text(
                  text = "100% ACCURATE",
                  color = Color(0xFF0F172A),
                  fontSize = 8.5.sp,
                  fontWeight = FontWeight.ExtraBold,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                  maxLines = 1
                )
              }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "ප්‍රශ්නවලට එවෙලෙම පිළිතුරු • ස්වයංක්‍රීයව ලකුණු • සිංහල විවරණ සහ Grammar Rules.",
              color = Color(0xFFBAE6FD),
              fontSize = 11.sp,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
              Button(
                onClick = onOpenEnglishShortNotesAutoCheck,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
              ) {
                Text("ප්‍රශ්න පරීක්ෂාව (Auto-Check)", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }
            }
          }
        }
      }

      // Geography Short Notes Interactive Auto-Checker Banner for Geography Subject (Strictly Geography only, never History)
      val isGeoSubject = (subject.nameSinhala.contains("භූගෝල") || subject.name.contains("Geography", ignoreCase = true) || subject.id.contains("geo")) &&
          !subject.nameSinhala.contains("ඉතිහාසය") && !subject.id.contains("history")
      if (isGeoSubject) {
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF064E3B)),
          modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable { onOpenGeographyAutoCheck() }
            .testTag("geography_short_notes_subject_banner")
        ) {
          Column(modifier = Modifier.padding(10.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f, fill = false)
              ) {
                Text("🌍", fontSize = 16.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = "10/11 භූගෝලය කෙටි සටහන් Auto-Checker",
                  color = Color.White,
                  fontSize = 13.sp,
                  fontWeight = FontWeight.Bold,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }
              Spacer(modifier = Modifier.width(6.dp))
              Surface(
                color = Color(0xFF10B981),
                shape = RoundedCornerShape(4.dp)
              ) {
                Text(
                  text = "100% නිවැරදි",
                  color = Color.White,
                  fontSize = 8.5.sp,
                  fontWeight = FontWeight.ExtraBold,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                  maxLines = 1
                )
              }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "ප්‍රශ්නවලට එවෙලෙම පිළිතුරු • ස්වයංක්‍රීයව ලකුණු • සවිස්තර විවරණ සහ විභාග ඉඟි.",
              color = Color(0xFFA7F3D0),
              fontSize = 11.sp,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
              Button(
                onClick = onOpenGeographyAutoCheck,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
              ) {
                Text("ප්‍රශ්න පරීක්ෂාව (Auto-Check)", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }
              OutlinedButton(
                onClick = {
                  onPdfClick(
                    "10 සහ 11 ශ්‍රේණි - භූගෝල විද්‍යාව කෙටි සටහන් සහ ප්‍රශ්නෝත්තර සංග්‍රහය (PDF)",
                    GeographyAutoCheckerRepository.pdfDriveUrl,
                    false,
                    null
                  )
                },
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF6EE7B7)),
                border = BorderStroke(1.dp, Color(0xFF6EE7B7)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
              ) {
                Text("මුල් PDF බලන්න", fontSize = 11.sp)
              }
            }
          }
        }
      }

      // Grade 10 & 11 Mathematics Short Notes (Sandu Theory 42 Units) Banner for Maths Subject
      if (subject.nameSinhala.contains("ගණිත") || subject.name.contains("Math", ignoreCase = true) || subject.id.contains("math")) {
        // 🌟 100% ACCURATE GRADE 10 & 11 MATHEMATICS SYLLABUS MASTER HUB (THEOREMS, GRAPHS, SOLVERS, FORMULAS, MCQS)
        MathGrade10And11MasterHub(
          currentGrade = grade
        )

        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
          modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable { onOpenMathShortNotesAutoCheck() }
            .testTag("math_short_notes_subject_banner")
        ) {
          Column(modifier = Modifier.padding(10.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f, fill = false)
              ) {
                Text("📐", fontSize = 16.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = "10 & 11 ගණිතය කෙටි සටහන් (ඒකක 42)",
                  color = Color.White,
                  fontSize = 13.sp,
                  fontWeight = FontWeight.Bold,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }
              Spacer(modifier = Modifier.width(6.dp))
              Surface(
                color = Color(0xFF38BDF8),
                shape = RoundedCornerShape(4.dp)
              ) {
                Text(
                  text = "SANDU THEORY",
                  color = Color(0xFF0F172A),
                  fontSize = 8.5.sp,
                  fontWeight = FontWeight.ExtraBold,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                  maxLines = 1
                )
              }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "සියලු සූත්‍ර • පියවරෙන් පියවර විසඳූ ගැටලු • 1-42 සියලු ඒකක වල නිල පිළිතුරු & සූත්‍ර ගණක.",
              color = Color(0xFFBAE6FD),
              fontSize = 11.sp,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
              Button(
                onClick = onOpenMathShortNotesAutoCheck,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
              ) {
                Text("ඒකක 42 විවරණ", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }
              Button(
                onClick = {
                  sanduBookInitialPage = 1
                  showSanduFullBookReader = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
              ) {
                Icon(Icons.Default.PictureAsPdf, contentDescription = "PDF", modifier = Modifier.size(13.dp))
                Spacer(modifier = Modifier.width(3.dp))
                Text("පිටු 100ම (Full PDF)", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }
              OutlinedButton(
                onClick = {
                  sanduBookInitialPage = 78
                  showSanduFullBookReader = true
                },
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFFDE047)),
                border = BorderStroke(1.dp, Color(0xFFFDE047)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
              ) {
                Text("පිළිතුරු (78-100)", fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
              }
            }
          }
        }
      }

      // Grade 10 & 11 Commerce & Accounting Short Notes & Master Hub
      if (subject.nameSinhala.contains("ව්‍යාපාර") || subject.nameSinhala.contains("ගිණුම්") || subject.nameSinhala.contains("කොමස්") || subject.name.contains("Commerce", ignoreCase = true) || subject.id.contains("comm")) {
        // 🌟 100% ACCURATE GRADE 10 & 11 COMMERCE & ACCOUNTING SYLLABUS MASTER HUB
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF022C22)),
          border = BorderStroke(1.2.dp, Color(0xFF10B981)),
          modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable {
              commerceMasterHubInitialCategory = null
              showCommerceMasterHubDialog = true
            }
            .testTag("commerce_master_hub_subject_card")
        ) {
          Column(modifier = Modifier.padding(11.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text("📊", fontSize = 17.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Column {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                      text = "10 & 11 කොමස් Master Hub (පූර්ණ තිරයෙන්)",
                      color = Color.White,
                      fontSize = 13.sp,
                      fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Surface(
                      color = Color(0xFF10B981),
                      shape = RoundedCornerShape(4.dp)
                    ) {
                      Text(
                        text = "100% SYLLABUS",
                        color = Color.White,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.5.dp)
                      )
                    }
                  }
                  Text(
                    text = "සමීකරණ 30+ • ද්විත්ව සටහන් • මූල්‍ය ප්‍රකාශන • අනුපාත • O/L MCQs",
                    color = Color(0xFFA7F3D0),
                    fontSize = 10.sp
                  )
                }
              }
              Surface(
                color = Color(0xFF065F46),
                shape = CircleShape,
                border = BorderStroke(1.dp, Color(0xFF34D399))
              ) {
                Icon(
                  Icons.Default.OpenInFull,
                  contentDescription = "Full Screen",
                  tint = Color(0xFFFDE047),
                  modifier = Modifier.padding(6.dp).size(15.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Quick Category Shortcuts (Compact height)
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
              horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
              Button(
                onClick = {
                  commerceMasterHubInitialCategory = CommerceSectionCategory.EQUATION
                  showCommerceMasterHubDialog = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
                modifier = Modifier.height(28.dp)
              ) {
                Text("📊 සමීකරණ 30+", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }

              Button(
                onClick = {
                  commerceMasterHubInitialCategory = CommerceSectionCategory.FINANCIAL_STATEMENTS
                  showCommerceMasterHubDialog = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C3AED)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
                modifier = Modifier.height(28.dp)
              ) {
                Text("📑 ගැලපීම් 6", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }

              Button(
                onClick = {
                  commerceMasterHubInitialCategory = CommerceSectionCategory.RATIOS
                  showCommerceMasterHubDialog = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD97706)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
                modifier = Modifier.height(28.dp)
              ) {
                Text("🧮 අනුපාත ගණකය", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }

              Button(
                onClick = {
                  commerceMasterHubInitialCategory = CommerceSectionCategory.EXAM_MCQS_SECRETS
                  showCommerceMasterHubDialog = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEA580C)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
                modifier = Modifier.height(28.dp)
              ) {
                Text("🎯 O/L MCQs", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }
            }
          }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF064E3B)),
          modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable { onOpenCommerceShortNotes() }
            .testTag("commerce_short_notes_subject_banner")
        ) {
          Column(modifier = Modifier.padding(10.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f, fill = false)
              ) {
                Text("📊", fontSize = 16.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = "10 & 11 කොමස් කෙටි සටහන් (පාඩම් 27)",
                  color = Color.White,
                  fontSize = 13.sp,
                  fontWeight = FontWeight.Bold,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }
              Spacer(modifier = Modifier.width(6.dp))
              Surface(
                color = Color(0xFFFDE047),
                shape = RoundedCornerShape(4.dp)
              ) {
                Text(
                  text = "SANDU THEORY",
                  color = Color(0xFF78350F),
                  fontSize = 8.5.sp,
                  fontWeight = FontWeight.ExtraBold,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                  maxLines = 1
                )
              }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "පිටු 76 ක සම්පූර්ණ PDF ග්‍රන්ථය • Mindmaps • ද්විත්ව සටහන් කාණ්ඩ 200 • මූල්‍ය ප්‍රකාශන.",
              color = Color(0xFFD1FAE5),
              fontSize = 11.sp,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
              Button(
                onClick = onOpenCommerceShortNotes,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
              ) {
                Text("පාඩම් 27 Hub", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }
              Button(
                onClick = {
                  commerceBookInitialPage = 1
                  showCommerceFullBookReader = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF047857)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
              ) {
                Icon(Icons.Default.PictureAsPdf, contentDescription = "PDF", modifier = Modifier.size(13.dp))
                Spacer(modifier = Modifier.width(3.dp))
                Text("පිටු 76ම (Full PDF)", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }
              OutlinedButton(
                onClick = {
                  commerceBookInitialPage = 35
                  showCommerceFullBookReader = true
                },
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFFDE047)),
                border = BorderStroke(1.dp, Color(0xFFFDE047)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
              ) {
                Text("ද්විත්ව සටහන් (35-47)", fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
              }
            }
          }
        }
      }

      // Grade 10 & 11 Civic Education Master Hub
      if (subject.nameSinhala.contains("පුරවැසි") || subject.name.contains("Civic", ignoreCase = true) || subject.id.contains("civic")) {
        // 🌟 100% ACCURATE GRADE 10 & 11 CIVICS MASTER HUB
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF042F2C)),
          border = BorderStroke(1.2.dp, Color(0xFF14B8A6)),
          modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable {
              civicsMasterHubInitialCategory = null
              showCivicsMasterHubDialog = true
            }
            .testTag("civics_master_hub_subject_card")
        ) {
          Column(modifier = Modifier.padding(11.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text("⚖️", fontSize = 17.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Column {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                      text = "10 & 11 පුරවැසි Master Hub (පූර්ණ තිරයෙන්)",
                      color = Color.White,
                      fontSize = 13.sp,
                      fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Surface(
                      color = Color(0xFF0D9488),
                      shape = RoundedCornerShape(4.dp)
                    ) {
                      Text(
                        text = "100% SYLLABUS",
                        color = Color.White,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.5.dp)
                      )
                    }
                  }
                  Text(
                    text = "පාඩම් 12 • විවරණ සහිත MCQs • රචනා ලකුණු පටිපාටි • ව්‍යවස්ථා කාලරේඛාව • සිද්ධි අධ්‍යයන",
                    color = Color(0xFF99F6E4),
                    fontSize = 10.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                }
              }
              Surface(
                color = Color(0xFF115E59),
                shape = CircleShape,
                border = BorderStroke(1.dp, Color(0xFF2DD4BF))
              ) {
                Icon(
                  imageVector = Icons.Default.OpenInFull,
                  contentDescription = "Open Fullscreen",
                  tint = Color.White,
                  modifier = Modifier
                    .size(24.dp)
                    .padding(5.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Action Quick Buttons Row
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
              horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
              Button(
                onClick = {
                  civicsMasterHubInitialCategory = CivicsSectionCategory.LESSONS
                  showCivicsMasterHubDialog = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D9488)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
                modifier = Modifier.height(28.dp)
              ) {
                Text("📚 පාඩම් 12", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }

              Button(
                onClick = {
                  civicsMasterHubInitialCategory = CivicsSectionCategory.MCQ_BANK
                  showCivicsMasterHubDialog = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE11D48)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
                modifier = Modifier.height(28.dp)
              ) {
                Text("🎯 O/L MCQs", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }

              Button(
                onClick = {
                  civicsMasterHubInitialCategory = CivicsSectionCategory.STRUCTURED_ESSAY
                  showCivicsMasterHubDialog = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
                modifier = Modifier.height(28.dp)
              ) {
                Text("📝 රචනා & Marking", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }

              Button(
                onClick = {
                  civicsMasterHubInitialCategory = CivicsSectionCategory.TIMELINE
                  showCivicsMasterHubDialog = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD97706)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
                modifier = Modifier.height(28.dp)
              ) {
                Text("⏳ ව්‍යවස්ථා (1833-1978)", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }

              Button(
                onClick = {
                  civicsMasterHubInitialCategory = CivicsSectionCategory.CASE_STUDIES
                  showCivicsMasterHubDialog = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C3AED)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
                modifier = Modifier.height(28.dp)
              ) {
                Text("⚖️ සිද්ධි අධ්‍යයන", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }

              Button(
                onClick = {
                  civicsMasterHubInitialCategory = CivicsSectionCategory.FLOWCHARTS
                  showCivicsMasterHubDialog = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
                modifier = Modifier.height(28.dp)
              ) {
                Text("🏛️ රාජ්‍ය ව්‍යුහ සටහන්", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }
            }
          }
        }
      }

      // Grade 10 & 11 Health & Physical Education Master Hub
      if (subject.nameSinhala.contains("සෞඛ්‍ය") || subject.name.contains("Health", ignoreCase = true) || subject.id.contains("health")) {
        // 🌟 100% ACCURATE GRADE 10 & 11 HEALTH MASTER HUB
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF2C0A16)),
          border = BorderStroke(1.2.dp, Color(0xFFE11D48)),
          modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable {
              healthMasterHubInitialCategory = null
              showHealthMasterHubDialog = true
            }
            .testTag("health_master_hub_subject_card")
        ) {
          Column(modifier = Modifier.padding(11.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text("🏃‍♂️", fontSize = 17.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Column {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                      text = "10 & 11 සෞඛ්‍ය Master Hub (පූර්ණ තිරයෙන්)",
                      color = Color.White,
                      fontSize = 13.sp,
                      fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Surface(
                      color = Color(0xFFE11D48),
                      shape = RoundedCornerShape(4.dp)
                    ) {
                      Text(
                        text = "100% SYLLABUS",
                        color = Color.White,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.5.dp)
                      )
                    }
                  }
                  Text(
                    text = "පාඩම් 12 • විවරණ සහිත MCQs • රචනා ලකුණු පටිපාටි • BMI & තරග ගණකය • RICE ප්‍රථමාධාර",
                    color = Color(0xFFFDA4AF),
                    fontSize = 10.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                }
              }
              Surface(
                color = Color(0xFF881337),
                shape = CircleShape,
                border = BorderStroke(1.dp, Color(0xFFFB7185))
              ) {
                Icon(
                  imageVector = Icons.Default.OpenInFull,
                  contentDescription = "Open Fullscreen",
                  tint = Color.White,
                  modifier = Modifier
                    .size(24.dp)
                    .padding(5.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Action Quick Buttons Row
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
              horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
              Button(
                onClick = {
                  healthMasterHubInitialCategory = HealthSectionCategory.LESSONS
                  showHealthMasterHubDialog = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE11D48)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
                modifier = Modifier.height(28.dp)
              ) {
                Text("📚 පාඩම් 12", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }

              Button(
                onClick = {
                  healthMasterHubInitialCategory = HealthSectionCategory.MCQ_BANK
                  showHealthMasterHubDialog = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
                modifier = Modifier.height(28.dp)
              ) {
                Text("🎯 O/L MCQs", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }

              Button(
                onClick = {
                  healthMasterHubInitialCategory = HealthSectionCategory.STRUCTURED_ESSAY
                  showHealthMasterHubDialog = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D9488)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
                modifier = Modifier.height(28.dp)
              ) {
                Text("📝 රචනා & Marking", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }

              Button(
                onClick = {
                  healthMasterHubInitialCategory = HealthSectionCategory.CALCULATORS
                  showHealthMasterHubDialog = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD97706)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
                modifier = Modifier.height(28.dp)
              ) {
                Text("🧮 BMI & තරග ගණකය", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }

              Button(
                onClick = {
                  healthMasterHubInitialCategory = HealthSectionCategory.FIRST_AID
                  showHealthMasterHubDialog = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
                modifier = Modifier.height(28.dp)
              ) {
                Text("🩹 RICE ප්‍රථමාධාර", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }

              Button(
                onClick = {
                  healthMasterHubInitialCategory = HealthSectionCategory.LIFE_SKILLS
                  showHealthMasterHubDialog = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C3AED)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
                modifier = Modifier.height(28.dp)
              ) {
                Text("🧠 ජීවන කුසලතා", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }
            }
          }
        }
      }

      // 💃 Grade 10 & 11 Dancing Master Hub (Strictly exclusive to 10 & 11 Dancing subject only)
      val isDancingSubject = (subject.nameSinhala.contains("නර්තන") || subject.name.contains("Dance", ignoreCase = true) || subject.id.contains("dance")) &&
          !subject.nameSinhala.contains("සංගීත")
      if (isDancingSubject) {
        // 🌟 100% ACCURATE GRADE 10 & 11 DANCING SYLLABUS MASTER HUB
        DancingGrade10And11MasterHub(
          currentGrade = grade,
          onOpenFullHub = { cat ->
            dancingMasterHubInitialCategory = cat
            showDancingMasterHubDialog = true
          }
        )
      }

      // 🎨 Grade 10 & 11 Art Master Hub (Strictly exclusive to 10 & 11 Art subject only)
      val isArtSubject = (subject.nameSinhala.contains("චිත්‍ර") || subject.name.contains("Art", ignoreCase = true) || subject.id.contains("art"))
      if (isArtSubject) {
        // 🌟 100% ACCURATE GRADE 10 & 11 ART SYLLABUS MASTER HUB
        ArtGrade10And11MasterHub(
          currentGrade = grade,
          onOpenFullHub = { cat ->
            artMasterHubInitialCategory = cat
            showArtMasterHubDialog = true
          }
        )
      }

      // 🎵 Grade 10 & 11 Music Master Hub (Strictly exclusive to 10 & 11 Music subject only)
      val isMusicSubject = (subject.nameSinhala.contains("සංගීත") || subject.name.contains("Music", ignoreCase = true) || subject.id.contains("music")) &&
          !subject.nameSinhala.contains("නර්තන")
      if (isMusicSubject) {
        // 🌟 100% ACCURATE GRADE 10 & 11 MUSIC SYLLABUS MASTER HUB
        MusicGrade10And11MasterHub(
          currentGrade = grade,
          onOpenFullHub = { cat ->
            musicMasterHubInitialCategory = cat
            showMusicMasterHubDialog = true
          }
        )
      }

      // 🌱 Grade 10 & 11 Agriculture Master Hub (Strictly exclusive to 10 & 11 Agriculture subject only)
      val isAgriSubject = (subject.nameSinhala.contains("කෘෂි") || subject.name.contains("Agri", ignoreCase = true) || subject.id.contains("agri")) &&
          !subject.nameSinhala.contains("විද්‍යාව")
      if (isAgriSubject) {
        // 🌟 100% ACCURATE GRADE 10 & 11 AGRICULTURE SYLLABUS MASTER HUB
        AgricultureGrade10And11MasterHubCard(
          onOpenFullHub = { cat ->
            agriMasterHubInitialCategory = cat
            showAgriMasterHubDialog = true
          }
        )
      }

      // 🌍 Grade 10 & 11 Geography Master Hub (Strictly exclusive to Geography subject only)
      val isGeographySubjectCard = (subject.nameSinhala.contains("භූගෝල") || subject.name.contains("Geography", ignoreCase = true) || subject.id.contains("geo")) &&
          !subject.nameSinhala.contains("ඉතිහාසය") && !subject.id.contains("history")
      if (isGeographySubjectCard) {
        // 🌟 100% ACCURATE GRADE 10 & 11 GEOGRAPHY SYLLABUS MASTER HUB
        GeographyGrade10And11MasterHubCard(
          onOpenFullHub = { cat ->
            geoMasterHubInitialCategory = cat
            showGeoMasterHubDialog = true
          }
        )
      }

      if (subject.nameSinhala.contains("සිංහල")) {
        // 🌟 100% ACCURATE GRADE 10 & 11 SINHALA SYLLABUS MASTER HUB
        SinhalaGrade10And11MasterHub(
          currentGrade = grade
        )

        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF450A0A)),
          border = BorderStroke(1.2.dp, Color(0xFFEF4444)),
          modifier = Modifier.fillMaxWidth().testTag("sinhala_vichara_dhara_banner")
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f, fill = false)) {
                Text("📚", fontSize = 16.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = "10/11 සිංහල සාහිත්‍යය • විචාර ධාරා (විචාර 23)",
                  fontSize = 13.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }
              Surface(
                color = Color(0xFFDC2626),
                shape = RoundedCornerShape(4.dp)
              ) {
                Text(
                  text = "පිටු 30 PDF",
                  color = Color.White,
                  fontSize = 9.sp,
                  fontWeight = FontWeight.ExtraBold,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "ඒකක 7 ට අදාළ ආදර්ශ විචාර 23 • උපුටා දැක්වීම් • ලකුණු දීමේ නිර්ණායක",
              fontSize = 11.sp,
              color = Color(0xFFFECACA),
              maxLines = 2,
              overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
              Button(
                onClick = {
                  sinhalaVicharaBookInitialPage = 1
                  showSinhalaVicharaFullBookReader = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
              ) {
                Icon(Icons.Default.PictureAsPdf, contentDescription = "PDF", modifier = Modifier.size(13.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("පිටු 30ම PDF කියවන්න 📖", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
              }
              OutlinedButton(
                onClick = { onOpenSpecialMasterFeatures(SpecialFeatureSection.SINHALA_LITERATURE) },
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFFECACA)),
                border = BorderStroke(1.dp, Color(0xFFF87171)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
              ) {
                Text("සාහිත්‍යය Hub 🚀", fontSize = 11.sp, fontWeight = FontWeight.Bold)
              }
            }
          }
        }
      }

      if (subject.nameSinhala.contains("බුද්ධ") || subject.nameSinhala.contains("ආගම")) {
        // 🌟 100% ACCURATE GRADE 10 & 11 BUDDHISM SYLLABUS MASTER HUB
        BuddhismGrade10And11MasterHub(
          currentGrade = grade
        )

        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.2.dp, Color(0xFFF59E0B).copy(alpha = 0.6f)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text("☸️", fontSize = 16.sp)
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = "10/11 බුද්ධ ධර්මය සූත්‍ර & ශාසන ඉතිහාස Hub",
                fontSize = 12.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFDE68A)
              )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "මංගල, පරාභව, ධම්මචක්කප්පවත්තන සූත්‍ර විවරණ, ධර්ම සංගායනා 3, මහින්දාගමනය සහ සිව්සස් ප්‍රශ්නෝත්තර.",
              fontSize = 11.sp,
              color = Color(0xFFCBD5E1)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
              onClick = { onOpenSpecialMasterFeatures(SpecialFeatureSection.BUDDHISM_DHAMMA) },
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF59E0B)),
              shape = RoundedCornerShape(8.dp),
              contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
            ) {
              Text("බුද්ධ ධර්මය Hub විවෘත කරන්න 🚀", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            }
          }
        }
      }

      // 🎯 Interactive Q&A Suite Bar for the subject (Ultra-Slim & Compact)
      Surface(
        onClick = { onOpenInteractiveQaHub(QaHubTab.SHORT_ANSWER) },
        shape = RoundedCornerShape(10.dp),
        color = Color(0xFF0F172A),
        border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.6f)),
        modifier = Modifier
          .fillMaxWidth()
          .testTag("interactive_qa_subject_bar")
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
                .size(26.dp)
                .clip(CircleShape)
                .background(Color(0xFF0284C7).copy(alpha = 0.25f)),
              contentAlignment = Alignment.Center
            ) {
              Text("🎯", fontSize = 13.sp)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                  text = "${subject.nameSinhala} • Q&A Hub",
                  fontSize = 11.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFFBAE6FD),
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.width(5.dp))
                Surface(
                  shape = RoundedCornerShape(4.dp),
                  color = Color(0xFF0284C7)
                ) {
                  Text(
                    text = "6 MODES",
                    color = Color.White,
                    fontSize = 7.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                  )
                }
              }
              Text(
                text = "කෙටි පිළිතුරු • Flashcards • Daily 10 • ගැලපීම්",
                fontSize = 8.5.sp,
                color = Color(0xFF94A3B8),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
              )
            }
          }

          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
          ) {
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFF0284C7),
              onClick = { onOpenInteractiveQaHub(QaHubTab.SHORT_ANSWER) }
            ) {
              Text(
                text = "කෙටි පිළිතුරු ✍️",
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
              )
            }
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFFD97706),
              onClick = { onOpenInteractiveQaHub(QaHubTab.FLASHCARDS) }
            ) {
              Text(
                text = "⚡",
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
              )
            }
          }
        }
      }

      if (subjectNotes.isEmpty()) {
        Surface(
          shape = RoundedCornerShape(16.dp),
          color = SurfaceVariantLight,
          border = BorderStroke(1.dp, NeutralBorderLight),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Icon(
              imageVector = Icons.Default.PictureAsPdf,
              contentDescription = "PDF Empty",
              tint = Color(0xFFC62828),
              modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "${subject.nameSinhala} සඳහා කෙටි සටහන් නොමැත",
              fontWeight = FontWeight.Bold,
              fontSize = 13.sp,
              color = NeutralDark
            )
            if (isAdmin) {
              Text(
                text = "ඔබ සතු PDF එකතු කිරීමට 'PDF එකක් එක් කරන්න' බොත්තම ඔබන්න.",
                fontSize = 11.sp,
                color = NeutralMedium,
                modifier = Modifier.padding(top = 4.dp)
              )
            }
          }
        }
      } else {
        subjectNotes.forEach { note ->
          val isSanduTheory100PagesNote = note.id.contains("math_sandu_theory") ||
            (note.title.contains("Sandu") && (note.title.contains("ගණිත") || note.title.contains("100"))) ||
            note.title.contains("පිටු 100") ||
            (note.topicSinhala.contains("Sandu") && note.topicSinhala.contains("ගණිත")) ||
            note.pdfUri == "sandu_theory_100_pages_reader"

          val isSanduCommerce76PagesNote = note.id.contains("commerce_sandu") ||
            (note.title.contains("Sandu") && (note.title.contains("කොමස්") || note.title.contains("ව්‍යාපාර") || note.title.contains("76"))) ||
            note.title.contains("පිටු 76") ||
            (note.topicSinhala.contains("Sandu") && note.topicSinhala.contains("ව්‍යාපාර")) ||
            note.pdfUri == "sandu_commerce_theory_reader"

          val isSinhalaVicharaDharaNote = note.id.contains("sinhala_vichara") ||
            note.pdfUri == "sinhala_vichara_dhara_30_pages_reader" ||
            note.title.contains("විචාර ධාරා") ||
            (note.title.contains("සිංහල") && note.title.contains("විචාර 23"))

          val isScienceDiagramsNote = note.id.contains("science_diagrams") ||
            note.pdfUri == "science_diagrams_11_pages_reader" ||
            (note.title.contains("විද්‍යාව") && (note.title.contains("රූ සටහන්") || note.title.contains("සෛලීය")))

          ShortNoteCardRow(
            note = note,
            isAdmin = isAdmin,
            onClick = {
              if (isSanduTheory100PagesNote) {
                sanduBookInitialPage = 1
                showSanduFullBookReader = true
              } else if (isSanduCommerce76PagesNote) {
                commerceBookInitialPage = 1
                showCommerceFullBookReader = true
              } else if (isSinhalaVicharaDharaNote) {
                sinhalaVicharaBookInitialPage = 1
                showSinhalaVicharaFullBookReader = true
              } else if (isScienceDiagramsNote) {
                scienceDiagramsInitialPage = 1
                showScienceDiagramsReader = true
              } else {
                onPdfClick(note.topicSinhala, note.pdfUri, note.isPasswordProtected, note.password)
              }
            },
            onDelete = if (isAdmin) {
              {
                itemToDeleteTitle = note.topicSinhala
                pendingDeleteAction = { onDeleteNote(note) }
                showDeleteConfirmDialog = true
              }
            } else null,
            onOpenPdf = {
              if (isSanduTheory100PagesNote) {
                sanduBookInitialPage = 1
                showSanduFullBookReader = true
              } else if (isSanduCommerce76PagesNote) {
                commerceBookInitialPage = 1
                showCommerceFullBookReader = true
              } else if (isSinhalaVicharaDharaNote) {
                sinhalaVicharaBookInitialPage = 1
                showSinhalaVicharaFullBookReader = true
              } else if (isScienceDiagramsNote) {
                scienceDiagramsInitialPage = 1
                showScienceDiagramsReader = true
              } else {
                onPdfClick(note.topicSinhala, note.pdfUri, note.isPasswordProtected, note.password)
              }
            },
            onOpenQuiz = {
              val quizData = QuizRepository.getQuizDataForSubject(grade, subject.nameSinhala, note.pdfUri ?: note.id)
              onStartQuizSet(quizData.quiz_sets.first())
            },
            onOpenFlashcards = {
              onOpenFlashcards()
            }
          )
        }
      }

      // 🌟 DEDICATED SUBJECT SPECIAL MASTER TOOL BAR (Placed strictly at the bottom of the short notes group)
      Surface(
        onClick = {
          if (subject.nameSinhala.contains("නර්තන") || subject.name.contains("Dance", ignoreCase = true) || subject.id.contains("dance")) {
            dancingMasterHubInitialCategory = null
            showDancingMasterHubDialog = true
          } else if (subject.nameSinhala.contains("චිත්‍ර") || subject.name.contains("Art", ignoreCase = true) || subject.id.contains("art")) {
            artMasterHubInitialCategory = null
            showArtMasterHubDialog = true
          } else if (subject.nameSinhala.contains("සංගීත") || subject.name.contains("Music", ignoreCase = true) || subject.id.contains("music")) {
            musicMasterHubInitialCategory = null
            showMusicMasterHubDialog = true
          } else {
            onOpenSpecialMasterFeatures(specInfo.section)
          }
        },
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFF0F172A),
        border = BorderStroke(1.2.dp, specInfo.color),
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 8.dp)
          .testTag("subject_special_master_tool_bar")
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 9.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
          ) {
            Box(
              modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(specInfo.color.copy(alpha = 0.25f)),
              contentAlignment = Alignment.Center
            ) {
              Text(specInfo.emoji, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                  text = specInfo.title,
                  fontSize = 12.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )
                Spacer(modifier = Modifier.width(6.dp))
                Surface(
                  shape = RoundedCornerShape(4.dp),
                  color = specInfo.color
                ) {
                  Text(
                    text = "20x20 MASTER",
                    fontSize = 7.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                  )
                }
              }
              Text(
                text = specInfo.subtitle,
                fontSize = 9.5.sp,
                color = Color(0xFF94A3B8)
              )
            }
          }

          Surface(
            shape = CircleShape,
            color = specInfo.color
          ) {
            Icon(
              imageVector = Icons.Default.ArrowForward,
              contentDescription = "Open Tool",
              tint = Color.White,
              modifier = Modifier
                .padding(4.dp)
                .size(14.dp)
            )
          }
        }
      }
    }
    // SECTION 2 (Tab 1): ප්‍රශ්න පත්‍ර (Term Test Papers & Custom Papers)
    if (selectedTab == 1) {
      // 2. SUB-SECTION: වාර විභාග ප්‍රශ්න පත්‍ර (Term Test Papers Portal & User-Added Subject Papers)
      TermTestPapersSection(
        grade = grade,
        subject = subject,
        userPapers = subjectPapers,
        isAdmin = isAdmin,
        onOpenPdf = { title, url ->
          onPdfClick(title, url, false, null)
        },
        onOpenGrade10Portal = onOpenGrade10TermTestPortal,
        onOpenGrade11Portal = onOpenGrade11TermTestPortal,
        onDeletePaper = if (isAdmin) {
          { paper ->
            itemToDeleteTitle = paper.titleSinhala
            pendingDeleteAction = { onDeletePaper(paper) }
            showDeleteConfirmDialog = true
          }
        } else null,
        onAddContent = if (isAdmin) {
          { onAddContent("PAPER") }
        } else null
      )
    }

    // SECTION 3 (Tab 2): ස්වයං පුහුණු (Practice Quizzes & Flashcards)
    if (selectedTab == 2) {
      PracticeQuizzesSection(
        grade = grade,
        subject = subject,
        onStartQuizSet = onStartQuizSet,
        onOpenFlashcards = onOpenFlashcards
      )
    }


    // SECTION 5 (Tab 3): ⚡ AI Smart Assistant & Voice Helper
    if (selectedTab == 3) {
      // 🎙️ VOICE DOUBT SOLVER CALLOUT BANNER
      Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        border = BorderStroke(1.2.dp, Color(0xFFEF4444)),
        modifier = Modifier
          .fillMaxWidth()
          .clickable { onOpenVoiceDoubtSolver() }
          .testTag("subject_voice_doubt_banner")
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
                .size(36.dp)
                .clip(CircleShape)
                .background(Color(0xFFEF4444)),
              contentAlignment = Alignment.Center
            ) {
              Text("🎙️", fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column {
              Text(
                text = "🎙️ ගැටලු විමසූ විට සම්පූර්ණ හඬ පැහැදිලි කිරීම",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Text(
                text = "ශිෂ්‍ය ගැටලු සඳහා Sinhala Voice Explainer වෙත පිවිසෙන්න",
                fontSize = 9.5.sp,
                color = Color(0xFFFCA5A5)
              )
            }
          }
          Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Open", tint = Color(0xFFF87171), modifier = Modifier.size(18.dp))
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      AiSmartAssistantSection(
        grade = grade,
        subject = subject,
        pdfUrl = activePdfUrl,
        onOpenPdfAtPage = onOpenPdfAtPage
      )
    }

    Spacer(modifier = Modifier.height(10.dp))
  }
}
