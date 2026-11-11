package com.example

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*

data class TermTestPaperItem(
  val id: String,
  val grade: String,
  val subject: String,
  val term: Int, // 1 = 1st Term, 2 = 2nd Term, 3 = 3rd Term
  val year: Int, // 2024, 2023, 2022, 2021, 2020
  val paperNumber: Int = 1,
  val titleSinhala: String,
  val sourceOrProvince: String,
  val timeDuration: String,
  val totalMarks: String,
  val paperStructure: String,
  val questionPaperUrl: String,
  val answerSchemeUrl: String,
  val unitCoverage: String,
  val questionSnippets: List<PaperQuestionSnippet> = emptyList()
)

object TermTestPapersRepository {

  fun getTermTestPapers(grade: String, subjectNameSinhala: String, term: Int): List<TermTestPaperItem> {
    return TermTestPapersDataBank.get30PapersForSubject(grade, subjectNameSinhala, term)
  }
}

@Composable
fun TermTestPapersSection(
  grade: String,
  subject: SubjectItem,
  userPapers: List<QuestionPaperItem> = emptyList(),
  isAdmin: Boolean = false,
  onOpenPdf: (title: String, url: String) -> Unit,
  onOpenGrade10Portal: ((Grade10WebSource) -> Unit)? = null,
  onOpenGrade11Portal: ((Grade11WebSource, String?, Int?) -> Unit)? = null,
  onDeletePaper: ((QuestionPaperItem) -> Unit)? = null,
  onAddContent: ((String) -> Unit)? = null
) {
  Card(
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    border = BorderStroke(1.2.dp, Color(0xFFE2E8F0)),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    modifier = Modifier
      .fillMaxWidth()
      .testTag("term_test_papers_hub")
  ) {
    Column(modifier = Modifier.padding(14.dp)) {
      // 1. Header with Badge
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Box(
            modifier = Modifier
              .size(34.dp)
              .clip(CircleShape)
              .background(Color(0xFF047857)),
            contentAlignment = Alignment.Center
          ) {
            Text("📑", fontSize = 16.sp)
          }
          Spacer(modifier = Modifier.width(10.dp))
          Column {
            Text(
              text = "වාර විභාග ප්‍රශ්න පත්‍ර (Term Test Papers)",
              style = MaterialTheme.typography.titleSmall,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF0F172A)
            )
            Text(
              text = "${subject.nameSinhala} • $grade ශ්‍රේණිය • ප්‍රශ්න හා පිළිතුරු",
              fontSize = 10.sp,
              color = Color(0xFF047857),
              fontWeight = FontWeight.SemiBold
            )
          }
        }

        Surface(
          shape = RoundedCornerShape(6.dp),
          color = Color(0xFFECFDF5),
          border = BorderStroke(1.dp, Color(0xFFA7F3D0))
        ) {
          Text(
            text = "ප්‍රශ්න පත්‍ර ${userPapers.size}",
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF047857),
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(12.dp))

      // 🌟 10 ශ්‍රේණිය නිල වාර විභාග ප්‍රශ්න පත්‍ර ආරක්ෂිත ද්වාරය (GovDoc.lk & e-Thaksalawa)
      if (grade.contains("10")) {
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
          border = BorderStroke(1.2.dp, Color(0xFF10B981)),
          modifier = Modifier
            .fillMaxWidth()
            .testTag("grade10_secure_portal_banner")
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
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
                    .background(Color(0xFF10B981).copy(alpha = 0.2f)),
                  contentAlignment = Alignment.Center
                ) {
                  Text("🛡️", fontSize = 14.sp)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                  Text(
                    text = "10 වසර වාර විභාග ප්‍රශ්න පත්‍ර ද්වාරය",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                  )
                  Text(
                    text = "GovDoc.lk & e-Thaksalawa (නිල වෙබ් අඩවි)",
                    fontSize = 9.5.sp,
                    color = Color(0xFFA7F3D0)
                  )
                }
              }

              Surface(
                shape = RoundedCornerShape(4.dp),
                color = Color(0xFFDC2626)
              ) {
                Text(
                  text = "DRM PROTECTED",
                  fontSize = 8.sp,
                  fontWeight = FontWeight.ExtraBold,
                  color = Color.White,
                  modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
              text = "🚫 ආරක්ෂිත කියවීම් මාදිලිය: Screenshot, Screen Record, Copy කිරීම සහ Download කිරීම සම්පූර්ණයෙන්ම අවහිර කර ඇත.",
              fontSize = 9.5.sp,
              color = Color(0xFFCBD5E1),
              lineHeight = 13.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
              Button(
                onClick = { onOpenGrade10Portal?.invoke(Grade10WebSource.GOVDOC) },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
                contentPadding = PaddingValues(horizontal = 6.dp, vertical = 6.dp),
                modifier = Modifier
                  .weight(1f)
                  .testTag("open_govdoc_grade10_btn")
              ) {
                Text(
                  text = "GovDoc",
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )
              }

              Button(
                onClick = { onOpenGrade10Portal?.invoke(Grade10WebSource.ETHAKSALAWA) },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1D4ED8)),
                contentPadding = PaddingValues(horizontal = 6.dp, vertical = 6.dp),
                modifier = Modifier
                  .weight(1f)
                  .testTag("open_ethaksalawa_grade10_btn")
              ) {
                Text(
                  text = "e-Thaksalawa",
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )
              }

              Button(
                onClick = { onOpenGrade10Portal?.invoke(Grade10WebSource.PASTPAPERS_WIKI) },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF047857)),
                contentPadding = PaddingValues(horizontal = 6.dp, vertical = 6.dp),
                modifier = Modifier
                  .weight(1f)
                  .testTag("open_pastpapers_wiki_grade10_btn")
              ) {
                Text(
                  text = "PastPapers.wiki",
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )
              }
            }
          }
        }

        Spacer(modifier = Modifier.height(10.dp))
      }

      // 🌟 11 ශ්‍රේණිය නිල වාර විභාග ප්‍රශ්න පත්‍ර ආරක්ෂිත ද්වාරය (GovDoc.lk & e-Thaksalawa)
      if (grade.contains("11")) {
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
          border = BorderStroke(1.2.dp, Color(0xFF10B981)),
          modifier = Modifier
            .fillMaxWidth()
            .testTag("grade11_secure_portal_banner")
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
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
                    .background(Color(0xFF10B981).copy(alpha = 0.2f)),
                  contentAlignment = Alignment.Center
                ) {
                  Text("🛡️", fontSize = 14.sp)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                  Text(
                    text = "11 වසර වාර විභාග ප්‍රශ්න පත්‍ර ද්වාරය",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                  )
                  Text(
                    text = "${subject.nameSinhala} (GovDoc & e-Thaksalawa)",
                    fontSize = 9.5.sp,
                    color = Color(0xFFA7F3D0)
                  )
                }
              }

              Surface(
                shape = RoundedCornerShape(4.dp),
                color = Color(0xFFDC2626)
              ) {
                Text(
                  text = "DRM PROTECTED",
                  fontSize = 8.sp,
                  fontWeight = FontWeight.ExtraBold,
                  color = Color.White,
                  modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
              text = "🚫 ආරක්ෂිත කියවීම් මාදිලිය: Screenshot, Screen Record, Copy කිරීම සහ Download කිරීම සම්පූර්ණයෙන්ම අවහිර කර ඇත. මෙම විෂයට අදාළ නිල ප්‍රශ්න පත්‍ර පෙන්වයි.",
              fontSize = 9.5.sp,
              color = Color(0xFFCBD5E1),
              lineHeight = 13.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
              Button(
                onClick = { onOpenGrade11Portal?.invoke(Grade11WebSource.GOVDOC, subject.nameSinhala, null) },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF047857)),
                contentPadding = PaddingValues(horizontal = 6.dp, vertical = 6.dp),
                modifier = Modifier
                  .weight(1f)
                  .testTag("open_govdoc_grade11_btn")
              ) {
                Text(
                  text = "GovDoc",
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }

              Button(
                onClick = { onOpenGrade11Portal?.invoke(Grade11WebSource.ETHAKSALAWA, subject.nameSinhala, null) },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1D4ED8)),
                contentPadding = PaddingValues(horizontal = 6.dp, vertical = 6.dp),
                modifier = Modifier
                  .weight(1f)
                  .testTag("open_ethaksalawa_grade11_btn")
              ) {
                Text(
                  text = "e-Thaksalawa",
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }

              Button(
                onClick = { onOpenGrade11Portal?.invoke(Grade11WebSource.PASTPAPERS_WIKI, subject.nameSinhala, null) },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD97706)),
                contentPadding = PaddingValues(horizontal = 6.dp, vertical = 6.dp),
                modifier = Modifier
                  .weight(1f)
                  .testTag("open_pastpapers_wiki_grade11_btn")
              ) {
                Text(
                  text = "PastPapers.wiki",
                  fontSize = 10.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
                )
              }
            }
          }
        }

        Spacer(modifier = Modifier.height(10.dp))
      }

      val context = LocalContext.current

      Spacer(modifier = Modifier.height(10.dp))

      // 🌐 External Past Paper Websites Links Card
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.2.dp, Color(0xFF38BDF8)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Text(
            text = "🌐 පසුගිය ප්‍රශ්න පත්‍ර ලබාගත හැකි නිල වෙබ් අඩවි",
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
          Spacer(modifier = Modifier.height(2.dp))
          Text(
            text = "විභාග දෙපාර්තමේන්තුව හා අධ්‍යාපන අමාත්‍යාංශය මඟින් නිකුත් කරන නිල වෙබ් අඩවි:",
            fontSize = 9.5.sp,
            color = Color(0xFF94A3B8)
          )
          Spacer(modifier = Modifier.height(8.dp))

          val webSites = listOf(
            Triple("ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව", "https://www.doenets.lk", "doenets.lk"),
            Triple("e-Thaksalawa (අධ්‍යාපන අමාත්‍යාංශය)", "https://www.e-thaksalawa.moe.gov.lk", "e-thaksalawa.moe.gov.lk"),
            Triple("GovDoc.lk (ප්‍රශ්න පත්‍ර ද්වාරය)", "https://www.govdoc.lk", "govdoc.lk"),
            Triple("PastPapers.wiki (O/L Papers)", "https://pastpapers.wiki", "pastpapers.wiki")
          )

          webSites.forEach { (siteName, siteUrl, siteDisplay) ->
            Surface(
              onClick = {
                try {
                  val intent = Intent(Intent.ACTION_VIEW, Uri.parse(siteUrl))
                  context.startActivity(intent)
                } catch (e: Exception) {
                  Toast.makeText(context, "වෙබ් අඩවිය විවෘත කළ නොහැකි විය", Toast.LENGTH_SHORT).show()
                }
              },
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFF0F172A),
              border = BorderStroke(0.8.dp, Color(0xFF334155)),
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp)
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 8.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Column(modifier = Modifier.weight(1f)) {
                  Text(text = siteName, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color.White)
                  Text(text = siteDisplay, fontSize = 8.5.sp, color = Color(0xFF38BDF8))
                }
                Icon(
                  imageVector = Icons.Default.OpenInNew,
                  contentDescription = "Open",
                  tint = Color(0xFF38BDF8),
                  modifier = Modifier.size(14.dp)
                )
              }
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      // 2. User-Added Question Papers for this Subject
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column {
          Text(
            text = "එක් කළ ප්‍රශ්න පත්‍ර (${userPapers.size})",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0F172A)
          )
          Text(
            text = "${subject.nameSinhala} විෂයයට අදාළ PDF ප්‍රශ්න පත්‍ර",
            fontSize = 10.sp,
            color = Color(0xFF64748B)
          )
        }

        if (isAdmin && onAddContent != null) {
          Button(
            onClick = { onAddContent("PAPER") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF137333)),
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
          ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add", modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text("PDF එක් කරන්න", fontSize = 11.sp)
          }
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      if (userPapers.isNotEmpty()) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
          userPapers.forEach { paper ->
            QuestionPaperCardRow(
              paper = paper,
              isAdmin = isAdmin,
              onClick = {
                onOpenPdf(paper.titleSinhala, paper.pdfUri ?: "")
              },
              onDelete = if (isAdmin && onDeletePaper != null) {
                { onDeletePaper(paper) }
              } else null,
              onOpenPdf = {
                onOpenPdf(paper.titleSinhala, paper.pdfUri ?: "")
              }
            )
          }
        }
      } else {
        Surface(
          shape = RoundedCornerShape(12.dp),
          color = Color(0xFFF8FAFC),
          border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Icon(
              imageVector = Icons.Default.Description,
              contentDescription = null,
              tint = Color(0xFF94A3B8),
              modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = "මෙම විෂයට අදාළ වාර විභාග ප්‍රශ්න පත්‍ර පීඩීඑෆ් දැනට එක් කර නොමැත",
              fontSize = 11.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF475569),
              textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "ඉහත නිල ද්වාරය (GovDoc / e-Thaksalawa / PastPapers.wiki) ඔස්සේ ප්‍රශ්න පත්‍ර ලබාගත හැක.",
              fontSize = 10.sp,
              color = Color(0xFF64748B),
              textAlign = TextAlign.Center
            )
          }
        }
      }
    }
  }
}

@Composable
fun TermTestPaperCard(
  item: TermTestPaperItem,
  onOpenQuestionPaper: () -> Unit,
  onOpenAnswerScheme: () -> Unit
) {
  var isExpandedQuestions by remember { mutableStateOf(false) }

  Surface(
    shape = RoundedCornerShape(12.dp),
    color = Color(0xFFFAFAFA),
    border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
    modifier = Modifier.fillMaxWidth()
  ) {
    Column(modifier = Modifier.padding(12.dp)) {
      // Top row: Paper Number Badge + Year & Term Badge + Total Marks
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          // Paper Index (01 to 30)
          Surface(
            shape = RoundedCornerShape(6.dp),
            color = Color(0xFF0F172A)
          ) {
            Text(
              text = "ප්‍රශ්න පත්‍රය ${item.paperNumber.toString().padStart(2, '0')} / 30",
              fontSize = 10.sp,
              fontWeight = FontWeight.ExtraBold,
              color = Color.White,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }

          Spacer(modifier = Modifier.width(6.dp))

          Surface(
            shape = RoundedCornerShape(6.dp),
            color = Color(0xFF047857)
          ) {
            Text(
              text = "${item.year} • ${item.term} වන වාරය",
              fontSize = 9.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }

          Spacer(modifier = Modifier.width(6.dp))

          Surface(
            shape = RoundedCornerShape(6.dp),
            color = Color(0xFFE0F2FE)
          ) {
            Text(
              text = item.timeDuration,
              fontSize = 9.sp,
              fontWeight = FontWeight.SemiBold,
              color = Color(0xFF0369A1),
              modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
            )
          }
        }

        Surface(
          shape = RoundedCornerShape(4.dp),
          color = Color(0xFFFEF3C7)
        ) {
          Text(
            text = item.totalMarks,
            fontSize = 9.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF92400E),
            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(6.dp))

      // Title & Province Source
      Text(
        text = item.titleSinhala,
        style = MaterialTheme.typography.titleSmall,
        fontWeight = FontWeight.Bold,
        fontSize = 12.5.sp,
        color = Color(0xFF0F172A)
      )

      Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 2.dp)
      ) {
        Icon(
          imageVector = Icons.Default.School,
          contentDescription = "Source",
          tint = Color(0xFF64748B),
          modifier = Modifier.size(12.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = item.sourceOrProvince,
          fontSize = 10.sp,
          color = Color(0xFF64748B)
        )
      }

      Text(
        text = "📌 ${item.unitCoverage}",
        fontSize = 9.5.sp,
        color = Color(0xFF475569),
        modifier = Modifier.padding(top = 3.dp)
      )

      // Questions accordion preview toggle
      if (item.questionSnippets.isNotEmpty()) {
        Spacer(modifier = Modifier.height(6.dp))
        Surface(
          onClick = { isExpandedQuestions = !isExpandedQuestions },
          shape = RoundedCornerShape(6.dp),
          color = if (isExpandedQuestions) Color(0xFFECFDF5) else Color(0xFFF1F5F9),
          border = BorderStroke(1.dp, if (isExpandedQuestions) Color(0xFF10B981) else Color(0xFFE2E8F0)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(
                imageVector = Icons.Default.MenuBook,
                contentDescription = null,
                tint = if (isExpandedQuestions) Color(0xFF047857) else Color(0xFF64748B),
                modifier = Modifier.size(13.dp)
              )
              Spacer(modifier = Modifier.width(5.dp))
              Text(
                text = if (isExpandedQuestions) "ඇතුළත් ප්‍රශ්න පෙරදසුන සඟවන්න" else "📋 මෙම පත්‍රයේ ඇතුළත් ප්‍රශ්න පෙරදසුන (${item.questionSnippets.size})",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = if (isExpandedQuestions) Color(0xFF047857) else Color(0xFF334155)
              )
            }
            Icon(
              imageVector = if (isExpandedQuestions) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
              contentDescription = null,
              tint = if (isExpandedQuestions) Color(0xFF047857) else Color(0xFF64748B),
              modifier = Modifier.size(16.dp)
            )
          }
        }

        if (isExpandedQuestions) {
          Spacer(modifier = Modifier.height(6.dp))
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .background(Color(0xFFF8FAFC), RoundedCornerShape(8.dp))
              .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            item.questionSnippets.forEach { q ->
              Surface(
                shape = RoundedCornerShape(6.dp),
                color = Color.White,
                border = BorderStroke(0.8.dp, Color(0xFFE2E8F0)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(7.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(
                      text = q.questionNumber,
                      fontSize = 9.5.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF047857)
                    )
                    Text(
                      text = q.marksOrGuideline,
                      fontSize = 8.5.sp,
                      color = Color(0xFF0284C7),
                      fontWeight = FontWeight.SemiBold
                    )
                  }
                  Spacer(modifier = Modifier.height(2.dp))
                  Text(
                    text = q.questionText,
                    fontSize = 10.sp,
                    color = Color(0xFF1E293B),
                    lineHeight = 14.sp
                  )
                }
              }
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      // Dual Action Buttons: [📄 ප්‍රශ්න පත්‍රය (Paper)] and [📝 පිළිතුරු පත්‍රය (Marking Scheme)]
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        // Question Paper Button
        Button(
          onClick = onOpenQuestionPaper,
          shape = RoundedCornerShape(8.dp),
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E293B)),
          contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
          modifier = Modifier
            .weight(1f)
            .testTag("open_question_paper_${item.year}_${item.term}_${item.paperNumber}")
        ) {
          Icon(
            imageVector = Icons.Default.PictureAsPdf,
            contentDescription = "Question Paper",
            tint = Color(0xFFF87171),
            modifier = Modifier.size(15.dp)
          )
          Spacer(modifier = Modifier.width(5.dp))
          Text(
            text = "ප්‍රශ්න පත්‍රය",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
        }

        // Marking Scheme Button
        Button(
          onClick = onOpenAnswerScheme,
          shape = RoundedCornerShape(8.dp),
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF047857)),
          contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
          modifier = Modifier
            .weight(1f)
            .testTag("open_marking_scheme_${item.year}_${item.term}_${item.paperNumber}")
        ) {
          Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = "Marking Scheme",
            tint = Color(0xFF86EFAC),
            modifier = Modifier.size(15.dp)
          )
          Spacer(modifier = Modifier.width(5.dp))
          Text(
            text = "පිළිතුරු පත්‍රය",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
        }
      }
    }
  }
}

data class GceOlPastPaperItem(
  val id: String,
  val subject: String,
  val year: Int,
  val isLatest: Boolean = false,
  val titleSinhala: String,
  val source: String = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations)",
  val timeDuration: String = "පැය 03 යි",
  val totalMarks: String = "ලකුණු 100",
  val paperStructure: String = "I කොටස (බහුවරණ 40) + II කොටස (ව්‍යුහගත හා රචනා)",
  val questionPaperUrl: String,
  val answerSchemeUrl: String,
  val description: String = "අ.පො.ස. (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය සහ ප්‍රමිත ලකුණු දීමේ පටිපාටිය"
)

object GceOlPastPapersRepository {

  fun getOlPastPapers(subjectNameSinhala: String): List<GceOlPastPaperItem> {
    val cleanSub = subjectNameSinhala.trim()
    val fallbackList = listOf(
      GceOlPastPaperItem(
        id = "ol_${cleanSub.hashCode()}_2024_official",
        subject = cleanSub,
        year = 2024,
        isLatest = true,
        titleSinhala = "11 ශ්‍රේණිය - $cleanSub සාමාන්‍ය පෙළ (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය 2024 - Paper I & II",
        source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations, Sri Lanka)",
        timeDuration = "පැය 03 යි (අමතර කියවීම් කාලය: මිනිත්තු 10)",
        totalMarks = "ලකුණු 100",
        paperStructure = "I කොටස (බහුවරණ ප්‍රශ්න 1-40) + II කොටස (ව්‍යුහගත හා රචනා ප්‍රශ්න 05)",
        questionPaperUrl = "https://drive.google.com/file/d/1TuWE6z1n8Qhb_Rd5FsiHFTBhI2AUukGo/preview",
        answerSchemeUrl = "https://drive.google.com/file/d/1TuWE6z1n8Qhb_Rd5FsiHFTBhI2AUukGo/preview",
        description = "අ.පො.ස. (සා.පෙළ) $cleanSub 2024 නිල විභාග ප්‍රශ්න පත්‍රය සහ ප්‍රමිත ලකුණු දීමේ පටිපාටිය"
      ),
      GceOlPastPaperItem(
        id = "ol_${cleanSub.hashCode()}_2023_official",
        subject = cleanSub,
        year = 2023,
        isLatest = false,
        titleSinhala = "11 ශ්‍රේණිය - $cleanSub සාමාන්‍ය පෙළ පසුගිය ප්‍රශ්න පත්‍රය 2023 - Paper I & II",
        source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations)",
        timeDuration = "පැය 03 යි",
        totalMarks = "ලකුණු 100",
        paperStructure = "I කොටස (බහුවරණ) + II කොටස (රචනා හා ව්‍යුහගත ප්‍රශ්න)",
        questionPaperUrl = "https://drive.google.com/file/d/1zKtgd_badE2crpYDfX8xPnxjb-lT6VvD/preview",
        answerSchemeUrl = "https://drive.google.com/file/d/1zKtgd_badE2crpYDfX8xPnxjb-lT6VvD/preview",
        description = "අ.පො.ස. (සා.පෙළ) $cleanSub 2023 විභාග ප්‍රශ්න පත්‍රය හා පිළිතුරු පත්‍රය"
      ),
      GceOlPastPaperItem(
        id = "ol_${cleanSub.hashCode()}_2022_official",
        subject = cleanSub,
        year = 2022,
        isLatest = false,
        titleSinhala = "11 ශ්‍රේණිය - $cleanSub සාමාන්‍ය පෙළ පසුගිය ප්‍රශ්න පත්‍රය 2022 - Paper I & II",
        source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations)",
        timeDuration = "පැය 03 යි",
        totalMarks = "ලකුණු 100",
        paperStructure = "I කොටස (බහුවරණ) + II කොටස (රචනා)",
        questionPaperUrl = "https://drive.google.com/file/d/1NDclAIyinjTEYML9IjrRv4QMORbZBggc/preview",
        answerSchemeUrl = "https://drive.google.com/file/d/1NDclAIyinjTEYML9IjrRv4QMORbZBggc/preview",
        description = "අ.පො.ස. (සා.පෙළ) $cleanSub 2022 විභාග ප්‍රශ්න පත්‍රය"
      ),
      GceOlPastPaperItem(
        id = "ol_${cleanSub.hashCode()}_2021_official",
        subject = cleanSub,
        year = 2021,
        isLatest = false,
        titleSinhala = "11 ශ්‍රේණිය - $cleanSub සාමාන්‍ය පෙළ පසුගිය ප්‍රශ්න පත්‍රය 2021 - Paper I & II",
        source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations)",
        timeDuration = "පැය 03 යි",
        totalMarks = "ලකුණු 100",
        paperStructure = "I සහ II කොටස් සම්පූර්ණ ප්‍රශ්න පත්‍රය",
        questionPaperUrl = "https://drive.google.com/file/d/1s9juSH9Kyv6rjI6BKE5v8vaHC_4t8hiY/preview",
        answerSchemeUrl = "https://drive.google.com/file/d/1s9juSH9Kyv6rjI6BKE5v8vaHC_4t8hiY/preview",
        description = "අ.පො.ස. (සා.පෙළ) $cleanSub 2021 විභාග ප්‍රශ්න පත්‍රය"
      ),
      GceOlPastPaperItem(
        id = "ol_${cleanSub.hashCode()}_2020_official",
        subject = cleanSub,
        year = 2020,
        isLatest = false,
        titleSinhala = "11 ශ්‍රේණිය - $cleanSub සාමාන්‍ය පෙළ පසුගිය ප්‍රශ්න පත්‍රය 2020 - Paper I & II",
        source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations)",
        timeDuration = "පැය 03 යි",
        totalMarks = "ලකුණු 100",
        paperStructure = "I සහ II කොටස් සම්පූර්ණ ප්‍රශ්න පත්‍රය",
        questionPaperUrl = "https://drive.google.com/file/d/1EGONbKc1CkpJQCJ5Ve24ik6T6s6xlMa6/preview",
        answerSchemeUrl = "https://drive.google.com/file/d/1EGONbKc1CkpJQCJ5Ve24ik6T6s6xlMa6/preview",
        description = "අ.පො.ස. (සා.පෙළ) $cleanSub 2020 විභාග ප්‍රශ්න පත්‍රය"
      )
    )

    if (cleanSub.contains("ඉතිහාසය") || cleanSub.contains("History")) {
      return listOf(
        GceOlPastPaperItem(
          id = "ol_history_past_paper_2024_2025_official",
          subject = "ඉතිහාසය",
          year = 2025,
          isLatest = true,
          titleSinhala = "11 ශ්‍රේණිය - ඉතිහාසය සාමාන්‍ය පෙළ (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය 2024(2025) - Paper I & II",
          source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations, Sri Lanka)",
          timeDuration = "පැය 01 (I පත්‍රය) + පැය 03 (II පත්‍රය)",
          totalMarks = "ලකුණු 100",
          paperStructure = "I කොටස (බහුවරණ ප්‍රශ්න 1-40) + II කොටස (ලංකා හා ලෝක සිතියම්, ඓතිහාසික මූලාශ්‍ර රූප සටහන්, රචනා ප්‍රශ්න)",
          questionPaperUrl = "https://drive.google.com/file/d/1history_ol_2024_2025_official_paper/preview",
          answerSchemeUrl = "https://drive.google.com/file/d/1history_ol_2024_2025_official_paper/preview",
          description = "අ.පො.ස. (සා.පෙළ) ඉතිහාසය 2024(2025) නිල විභාග ප්‍රශ්න පත්‍රය (33 S I සහ 33 S II)"
        ),
        GceOlPastPaperItem(
          id = "ol_history_past_paper_2024",
          subject = "ඉතිහාසය",
          year = 2024,
          isLatest = false,
          titleSinhala = "11 ශ්‍රේණිය - ඉතිහාසය සාමාන්‍ය පෙළ ප්‍රශ්න පත්‍රය 2024 - Paper I & II",
          source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations)",
          timeDuration = "පැය 03 යි",
          totalMarks = "ලකුණු 100",
          paperStructure = "I කොටස (බහුවරණ 40) + II කොටස (ව්‍යුහගත හා රචනා)",
          questionPaperUrl = "https://drive.google.com/file/d/1wrTWGsV7mwS3muCKjZVubP1RMvcXg0e5/preview",
          answerSchemeUrl = "https://drive.google.com/file/d/1wrTWGsV7mwS3muCKjZVubP1RMvcXg0e5/preview",
          description = "අ.පො.ස. (සා.පෙළ) ඉතිහාසය නිල විභාග ප්‍රශ්න පත්‍රය සහ ප්‍රමිත ලකුණු දීමේ පටිපාටිය"
        )
      ) + fallbackList.filter { it.year < 2024 }
    }
    if (cleanSub.contains("බුද්ධ") || cleanSub.contains("Buddhism")) {
      return listOf(
        GceOlPastPaperItem(
          id = "ol_buddhism_past_paper_2024_2025_official",
          subject = "බුද්ධ ධර්මය",
          year = 2025,
          isLatest = true,
          titleSinhala = "11 ශ්‍රේණිය - බුද්ධ ධර්මය සාමාන්‍ය පෙළ (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය 2024(2025) - Paper I & II",
          source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations, Sri Lanka)",
          timeDuration = "පැය 03 යි",
          totalMarks = "ලකුණු 100",
          paperStructure = "I කොටස (බහුවරණ ප්‍රශ්න 1-40) + II කොටස (රචනා හා සාරධර්ම ප්‍රශ්න 05)",
          questionPaperUrl = "https://drive.google.com/file/d/1buddhi_ol_2024_2025_official_paper/preview",
          answerSchemeUrl = "https://drive.google.com/file/d/1buddhi_ol_2024_2025_official_paper/preview",
          description = "අ.පො.ස. (සා.පෙළ) බුද්ධ ධර්මය නිල විභාග ප්‍රශ්න පත්‍රය (Paper I සහ Paper II)"
        )
      ) + fallbackList
    }
    if (cleanSub.contains("සිංහල") || cleanSub.contains("Sinhala")) {
      return listOf(
        GceOlPastPaperItem(
          id = "ol_sinhala_past_paper_2024_2025_official",
          subject = "සිංහල භාෂාව හා සාහිත්‍යය",
          year = 2025,
          isLatest = true,
          titleSinhala = "11 ශ්‍රේණිය - සිංහල භාෂාව හා සාහිත්‍යය සාමාන්‍ය පෙළ (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය - Paper I & II",
          source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations, Sri Lanka)",
          timeDuration = "පැය 03 යි",
          totalMarks = "ලකුණු 100",
          paperStructure = "I කොටස (ව්‍යාකරණ, වචන මාලාව හා කෙටි ප්‍රශ්න) + II කොටස (පද්‍ය, ගද්‍ය, නාට්‍ය, ව්‍යාස හා රචනා)",
          questionPaperUrl = "https://drive.google.com/file/d/1sinhala_ol_2024_2025_official_paper/preview",
          answerSchemeUrl = "https://drive.google.com/file/d/1sinhala_ol_2024_2025_official_paper/preview",
          description = "අ.පො.ස. (සා.පෙළ) සිංහල භාෂාව හා සාහිත්‍යය නිල විභාග ප්‍රශ්න පත්‍රය (10 S I, II)"
        )
      ) + fallbackList
    }
    if (cleanSub.contains("තොරතුරු") || cleanSub.contains("ICT") || cleanSub.contains("Information")) {
      return listOf(
        GceOlPastPaperItem(
          id = "ol_ict_past_paper_2024_2025_official",
          subject = "තොරතුරු තාක්ෂණය",
          year = 2025,
          isLatest = true,
          titleSinhala = "11 ශ්‍රේණිය - තොරතුරු සහ සන්නිවේදන තාක්ෂණය (ICT) සා.පෙළ නිල ප්‍රශ්න පත්‍රය - Paper I & II",
          source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations, Sri Lanka)",
          timeDuration = "පැය 03 යි",
          totalMarks = "ලකුණු 100",
          paperStructure = "I කොටස (බහුවරණ 40) + II කොටස (ව්‍යුහගත රචනා හා ඇල්ගොරිතම/ප්‍රවේශ ප්‍රශ්න)",
          questionPaperUrl = "https://drive.google.com/file/d/1ict_ol_2024_2025_official_paper/preview",
          answerSchemeUrl = "https://drive.google.com/file/d/1ict_ol_2024_2025_official_paper/preview",
          description = "අ.පො.ස. (සා.පෙළ) තොරතුරු තාක්ෂණය (ICT) නිල විභාග ප්‍රශ්න පත්‍රය"
        )
      ) + fallbackList
    }
    if (cleanSub.contains("ගණිතය") || cleanSub.contains("Math")) {
      return listOf(
        GceOlPastPaperItem(
          id = "ol_math_past_paper_2024_2025_official",
          subject = "ගණිතය",
          year = 2025,
          isLatest = true,
          titleSinhala = "11 ශ්‍රේණිය - ගණිතය සාමාන්‍ය පෙළ (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය 2024(2025) - Paper I & II",
          source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations, Sri Lanka)",
          timeDuration = "පැය 02 (I පත්‍රය) + පැය 03 (II පත්‍රය)",
          totalMarks = "ලකුණු 100",
          paperStructure = "I කොටස (A කොටස 1-25 ප්‍රශ්න + B කොටස 1-5 ප්‍රශ්න) + II කොටස (A කොටස 1-6 සහ B කොටස 7-12 ප්‍රශ්න)",
          questionPaperUrl = "https://drive.google.com/file/d/1math_ol_2024_2025_official_paper/preview",
          answerSchemeUrl = "https://drive.google.com/file/d/1math_ol_2024_2025_official_paper/preview",
          description = "අ.පො.ස. (සා.පෙළ) ගණිතය 2024(2025) නිල විභාග ප්‍රශ්න පත්‍රය (32 S I සහ 32 S II)"
        )
      ) + fallbackList.filter { it.year < 2024 }
    }
    if (cleanSub.contains("කෘෂි") || cleanSub.contains("Agriculture")) {
      return listOf(
        GceOlPastPaperItem(
          id = "ol_agri_past_paper_gr11_2024",
          subject = "කෘෂි හා ආහාර තාක්ෂණය",
          year = 2024,
          isLatest = true,
          titleSinhala = "11 ශ්‍රේණිය - කෘෂි හා ආහාර තාක්ෂණය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍ර - Paper I & II",
          source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations)",
          timeDuration = "පැය 03 යි",
          totalMarks = "ලකුණු 100",
          paperStructure = "I කොටස (බහුවරණ 40) + II කොටස (ව්‍යුහගත හා රචනා)",
          questionPaperUrl = "https://drive.google.com/file/d/1ZQVbVXMM92max_jQbPwuEkbWSyuJJqY4/preview",
          answerSchemeUrl = "https://drive.google.com/file/d/1ZQVbVXMM92max_jQbPwuEkbWSyuJJqY4/preview",
          description = "අ.පො.ස. (සා.පෙළ) කෘෂි හා ආහාර තාක්ෂණය නිල විභාග ප්‍රශ්න පත්‍රය සහ ප්‍රමිත ලකුණු දීමේ පටිපාටිය"
        )
      ) + fallbackList.filter { it.year < 2024 }
    }
    if (cleanSub.contains("චිත්‍ර") || cleanSub.contains("Art", ignoreCase = true)) {
      return listOf(
        GceOlPastPaperItem(
          id = "ol_art_past_paper_gr11_2024",
          subject = "චිත්‍ර",
          year = 2024,
          isLatest = true,
          titleSinhala = "11 ශ්‍රේණිය - චිත්‍ර සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍ර - Paper I & II",
          source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations)",
          timeDuration = "පැය 03 යි",
          totalMarks = "ලකුණු 100",
          paperStructure = "I කොටස (බහුවරණ 40) + II කොටස (ප්‍රායෝගික හා න්‍යායාත්මක ප්‍රශ්න පත්‍රය)",
          questionPaperUrl = "https://drive.google.com/file/d/1sgIxFoMazNG1VeFlG0EcZH28oq-mrk9Y/preview",
          answerSchemeUrl = "https://drive.google.com/file/d/1sgIxFoMazNG1VeFlG0EcZH28oq-mrk9Y/preview",
          description = "අ.පො.ස. (සා.පෙළ) චිත්‍ර කලා නිල විභාග ප්‍රශ්න පත්‍රය සහ ප්‍රමිත ලකුණු දීමේ පටිපාටිය"
        )
      ) + fallbackList.filter { it.year < 2024 }
    }
    if (cleanSub.contains("සෞඛ්‍ය") || cleanSub.contains("Health", ignoreCase = true)) {
      return listOf(
        GceOlPastPaperItem(
          id = "ol_health_past_paper_gr11_2020",
          subject = "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය",
          year = 2020,
          isLatest = false,
          titleSinhala = "11 ශ්‍රේණිය - සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍රය - Paper I & II",
          source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations, Sri Lanka)",
          timeDuration = "පැය 03 යි (අමතර කියවීම් කාලය: මිනිත්තු 10)",
          totalMarks = "ලකුණු 100",
          paperStructure = "I කොටස (බහුවරණ ප්‍රශ්න 40) + II කොටස (ව්‍යුහගත හා රචනා ප්‍රශ්න 05)",
          questionPaperUrl = "https://drive.google.com/file/d/1r_ZX6LYNYqLlhucK-wA84gbDgzh5wrCC/preview",
          answerSchemeUrl = "https://drive.google.com/file/d/1r_ZX6LYNYqLlhucK-wA84gbDgzh5wrCC/preview",
          description = "අ.පො.ස. (සා.පෙළ) සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය නිල විභාග ප්‍රශ්න පත්‍රය (Paper I සහ Paper II)"
        )
      ) + fallbackList
    }
    if (cleanSub.contains("නර්තන") || cleanSub.contains("Dance", ignoreCase = true)) {
      return listOf(
        GceOlPastPaperItem(
          id = "ol_dancing_past_paper_2024_2025_official",
          subject = "නර්තනය",
          year = 2025,
          isLatest = true,
          titleSinhala = "11 ශ්‍රේණිය - නැටුම් (දේශීය) සාමාන්‍ය පෙළ (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය - Paper I & II",
          source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations, Sri Lanka)",
          timeDuration = "පැය 03 යි",
          totalMarks = "ලකුණු 100",
          paperStructure = "I කොටස (පොදු ප්‍රශ්න 1-30 + උඩරට/පහතරට/සබරගමු තේරීම් ප්‍රශ්න 31-40) + II කොටස (අනිවාර්ය ප්‍රශ්න 1 ඇතුළු ප්‍රශ්න 5ක්)",
          questionPaperUrl = "https://drive.google.com/file/d/1dancing_ol_2024_2025_official_paper/preview",
          answerSchemeUrl = "https://drive.google.com/file/d/1dancing_ol_2024_2025_official_paper/preview",
          description = "අ.පො.ස. (සා.පෙළ) නැටුම් (දේශීය) නිල විභාග ප්‍රශ්න පත්‍රය (44 S I, II)"
        )
      ) + fallbackList
    }
    if (cleanSub.contains("පුරවැසි") || cleanSub.contains("Civic", ignoreCase = true)) {
      return listOf(
        GceOlPastPaperItem(
          id = "ol_civic_past_paper_2024_2025_official",
          subject = "පුරවැසි අධ්‍යාපනය",
          year = 2025,
          isLatest = true,
          titleSinhala = "11 ශ්‍රේණිය - පුරවැසි අධ්‍යාපනය සාමාන්‍ය පෙළ (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය - Paper I & II",
          source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations, Sri Lanka)",
          timeDuration = "පැය 03 යි",
          totalMarks = "ලකුණු 100",
          paperStructure = "I කොටස (බහුවරණ ප්‍රශ්න 40) + II කොටස (අනිවාර්ය ප්‍රශ්න 1 ඇතුළු ප්‍රශ්න 5ක්)",
          questionPaperUrl = "https://drive.google.com/file/d/1civic_ol_2024_2025_official_paper/preview",
          answerSchemeUrl = "https://drive.google.com/file/d/1civic_ol_2024_2025_official_paper/preview",
          description = "අ.පො.ස. (සා.පෙළ) පුරවැසි අධ්‍යාපනය නිල විභාග ප්‍රශ්න පත්‍රය (62 S I, II)"
        )
      ) + fallbackList
    }
    if (cleanSub.contains("භූගෝල") || cleanSub.contains("Geography", ignoreCase = true)) {
      return listOf(
        GceOlPastPaperItem(
          id = "ol_geography_past_paper_2024_2025_official",
          subject = "භූගෝල විද්‍යාව",
          year = 2025,
          isLatest = true,
          titleSinhala = "11 ශ්‍රේණිය - භූගෝල විද්‍යාව සාමාන්‍ය පෙළ (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය - Paper I & II",
          source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations, Sri Lanka)",
          timeDuration = "පැය 03 යි",
          totalMarks = "ලකුණු 100",
          paperStructure = "I කොටස (සිතියම් අභ්‍යාසය) + II කොටස (රචනා ප්‍රශ්න)",
          questionPaperUrl = "https://drive.google.com/file/d/1geography_ol_2024_2025_official_paper/preview",
          answerSchemeUrl = "https://drive.google.com/file/d/1geography_ol_2024_2025_official_paper/preview",
          description = "අ.පො.ස. (සා.පෙළ) භූගෝල විද්‍යාව නිල විභාග ප්‍රශ්න පත්‍රය (61 S I, II)"
        )
      ) + fallbackList
    }
    if (cleanSub.contains("ඉංග්‍රීසි") || cleanSub.contains("English", ignoreCase = true)) {
      return listOf(
        GceOlPastPaperItem(
          id = "ol_english_past_paper_2024_2025_official",
          subject = "ඉංග්‍රීසි භාෂාව",
          year = 2025,
          isLatest = true,
          titleSinhala = "11 ශ්‍රේණිය - ඉංග්‍රීසි භාෂාව සාමාන්‍ය පෙළ (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය - Paper I & II",
          source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations, Sri Lanka)",
          timeDuration = "පැය 01 (Paper I) + පැය 02 (Paper II)",
          totalMarks = "ලකුණු 100",
          paperStructure = "Paper I (Test 1 - Test 8) + Paper II (Test 9 - Test 16)",
          questionPaperUrl = "https://drive.google.com/file/d/1english_ol_2024_2025_official_paper/preview",
          answerSchemeUrl = "https://drive.google.com/file/d/1english_ol_2024_2025_official_paper/preview",
          description = "අ.පො.ස. (සා.පෙළ) ඉංග්‍රීසි භාෂාව (English Language) නිල විභාග ප්‍රශ්න පත්‍රය"
        )
      ) + fallbackList.filter { it.year < 2024 }
    }
    if ((cleanSub.contains("විද්‍යාව") && !cleanSub.contains("භූගෝල")) || cleanSub.contains("Science", ignoreCase = true)) {
      return listOf(
        GceOlPastPaperItem(
          id = "ol_science_past_paper_2024_2025_official",
          subject = "විද්‍යාව",
          year = 2025,
          isLatest = true,
          titleSinhala = "11 ශ්‍රේණිය - විද්‍යාව සාමාන්‍ය පෙළ (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය - Paper I & II",
          source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations, Sri Lanka)",
          timeDuration = "පැය 01 (I පත්‍රය) + පැය 03 (II පත්‍රය)",
          totalMarks = "ලකුණු 100",
          paperStructure = "I කොටස (බහුවරණ 40) + II කොටස (A කොටස ව්‍යුහගත + B කොටස රචනා)",
          questionPaperUrl = "https://drive.google.com/file/d/1science_ol_2024_2025_official_paper/preview",
          answerSchemeUrl = "https://drive.google.com/file/d/1science_ol_2024_2025_official_paper/preview",
          description = "අ.පො.ස. (සා.පෙළ) විද්‍යාව නිල විභාග ප්‍රශ්න පත්‍රය (34 S I සහ 34 S II)"
        )
      ) + fallbackList.filter { it.year < 2024 }
    }
    if (cleanSub.contains("ව්‍යාපාර") || cleanSub.contains("ගිණුම්") || cleanSub.contains("Commerce", ignoreCase = true) || cleanSub.contains("කොමස්")) {
      return listOf(
        GceOlPastPaperItem(
          id = "ol_commerce_past_paper_2025_2026_official",
          subject = "ව්‍යාපාර අධ්‍යයනය හා ගිණුම්කරණය",
          year = 2026,
          isLatest = true,
          titleSinhala = "11 ශ්‍රේණිය - ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය සාමාන්‍ය පෙළ (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය - Paper I & II",
          source = "ශ්‍රී ලංකා විභාග දෙපාර්තමේන්තුව (Department of Examinations, Sri Lanka)",
          timeDuration = "පැය 03 යි",
          totalMarks = "ලකුණු 100",
          paperStructure = "I කොටස (බහුවරණ 40) + II කොටස (රචනා ප්‍රශ්න)",
          questionPaperUrl = "https://drive.google.com/file/d/1commerce_ol_2025_2026_official_paper/preview",
          answerSchemeUrl = "https://drive.google.com/file/d/1commerce_ol_2025_2026_official_paper/preview",
          description = "අ.පො.ස. (සා.පෙළ) ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය නිල විභාග ප්‍රශ්න පත්‍රය (60 S I, II)"
        )
      ) + fallbackList.filter { it.year < 2024 }
    }
    return fallbackList
  }
}

@Composable
fun GceOlPastPapersSection(
  subject: SubjectItem,
  onOpenPdf: (title: String, url: String) -> Unit
) {
  var selectedYearFilter by remember { mutableStateOf<Int?>(null) } // null: All 6 years

  val allOlPapers = remember(subject.nameSinhala) {
    GceOlPastPapersRepository.getOlPastPapers(subject.nameSinhala)
  }

  val filteredPapers = remember(allOlPapers, selectedYearFilter) {
    if (selectedYearFilter == null) allOlPapers
    else allOlPapers.filter { it.year == selectedYearFilter }
  }

  Card(
    shape = RoundedCornerShape(18.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFFFCFDFE)),
    border = BorderStroke(1.5.dp, Color(0xFFBFDBFE)),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    modifier = Modifier
      .fillMaxWidth()
      .testTag("gce_ol_past_papers_section")
  ) {
    Column(modifier = Modifier.padding(14.dp)) {
      // 1. Header with Golden/Blue Badge
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Box(
            modifier = Modifier
              .size(38.dp)
              .clip(CircleShape)
              .background(Color(0xFF1D4ED8)),
            contentAlignment = Alignment.Center
          ) {
            Text("🏆", fontSize = 18.sp)
          }
          Spacer(modifier = Modifier.width(10.dp))
          Column {
            Text(
              text = "අ.පො.ස. (සා.පෙළ) විභාග ප්‍රශ්න පත්‍ර",
              style = MaterialTheme.typography.titleSmall,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF0F172A),
              fontSize = 13.5.sp
            )
            Text(
              text = "${subject.nameSinhala} • පසුගිය විභාග ප්‍රශ්න හා පිළිතුරු පත්‍ර",
              fontSize = 10.5.sp,
              color = Color(0xFF1D4ED8),
              fontWeight = FontWeight.SemiBold
            )
          }
        }

        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFFEFF6FF),
          border = BorderStroke(1.dp, Color(0xFF93C5FD))
        ) {
          Text(
            text = "O/L PAPERS",
            fontSize = 9.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E40AF),
            modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      // 2. List or Empty State
      if (filteredPapers.isEmpty()) {
        Surface(
          shape = RoundedCornerShape(12.dp),
          color = Color(0xFFF8FAFC),
          border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Icon(
              imageVector = Icons.Default.MenuBook,
              contentDescription = null,
              tint = Color(0xFF94A3B8),
              modifier = Modifier.size(36.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "සාමාන්‍ය පෙළ ප්‍රශ්න පත්‍ර නොමැත",
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF475569)
            )
            Text(
              text = "මෙම විෂයට අදාළ O/L ප්‍රශ්න පත්‍ර හා පිළිතුරු පත්‍ර දැනට ඇතුළත් කර නොමැත.",
              fontSize = 10.5.sp,
              color = Color(0xFF94A3B8),
              textAlign = TextAlign.Center
            )
          }
        }
      } else {
        // Year Filter Chips
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(5.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            text = "වර්ෂය:",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF475569)
          )

          val yearOptions = listOf<Int?>(null, 2024, 2023, 2022, 2021, 2020, 2019)
          yearOptions.forEach { yr ->
            val isSelected = selectedYearFilter == yr
            Surface(
              onClick = { selectedYearFilter = yr },
              shape = RoundedCornerShape(6.dp),
              color = if (isSelected) Color(0xFF1D4ED8) else Color(0xFFF1F5F9),
              border = BorderStroke(
                1.dp,
                if (isSelected) Color(0xFF1D4ED8) else Color(0xFFCBD5E1)
              ),
              modifier = Modifier.testTag("ol_year_filter_${yr ?: "all"}")
            ) {
              Text(
                text = when (yr) {
                  null -> "සියල්ල"
                  2024 -> "2024 මෙවර"
                  else -> "$yr"
                },
                fontSize = 9.5.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = if (isSelected) Color.White else Color(0xFF334155),
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp)
              )
            }
          }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // List of O/L Exam Papers
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
          filteredPapers.forEach { olPaper ->
            GceOlPastPaperCard(
              item = olPaper,
              onOpenQuestionPaper = {
                onOpenPdf(
                  "${olPaper.year} අ.පො.ස. (සා.පෙළ) ${olPaper.subject} ප්‍රශ්න පත්‍රය (Paper I & II)",
                  olPaper.questionPaperUrl
                )
              },
              onOpenAnswerScheme = {
                onOpenPdf(
                  "${olPaper.year} අ.පො.ස. (සා.පෙළ) ${olPaper.subject} නිල පිළිතුරු පත්‍රය (Marking Scheme)",
                  olPaper.answerSchemeUrl
                )
              }
            )
          }
        }
      }
    }
  }
}

@Composable
fun GceOlPastPaperCard(
  item: GceOlPastPaperItem,
  onOpenQuestionPaper: () -> Unit,
  onOpenAnswerScheme: () -> Unit
) {
  Surface(
    shape = RoundedCornerShape(14.dp),
    color = Color.White,
    border = BorderStroke(
      1.2.dp,
      if (item.isLatest) Color(0xFF93C5FD) else Color(0xFFE2E8F0)
    ),
    shadowElevation = if (item.isLatest) 2.dp else 1.dp,
    modifier = Modifier.fillMaxWidth()
  ) {
    Column(modifier = Modifier.padding(12.dp)) {
      // Top row: Year Badge + Duration & Marks
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Surface(
            shape = RoundedCornerShape(6.dp),
            color = if (item.isLatest) Color(0xFF1D4ED8) else Color(0xFF0F172A)
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              if (item.isLatest) {
                Text("🔥", fontSize = 10.sp)
                Spacer(modifier = Modifier.width(3.dp))
              }
              Text(
                text = if (item.isLatest) "${item.year} මෙවර විභාගය" else "${item.year} සාමාන්‍ය පෙළ",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
            }
          }

          Spacer(modifier = Modifier.width(6.dp))

          Surface(
            shape = RoundedCornerShape(6.dp),
            color = Color(0xFFF0FDF4)
          ) {
            Text(
              text = item.timeDuration,
              fontSize = 9.5.sp,
              fontWeight = FontWeight.SemiBold,
              color = Color(0xFF15803D),
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
            )
          }
        }

        Surface(
          shape = RoundedCornerShape(6.dp),
          color = Color(0xFFFEF3C7),
          border = BorderStroke(0.5.dp, Color(0xFFFDE68A))
        ) {
          Text(
            text = item.totalMarks,
            fontSize = 9.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF92400E),
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(6.dp))

      // Title & Source
      Text(
        text = item.titleSinhala,
        style = MaterialTheme.typography.titleSmall,
        fontWeight = FontWeight.Bold,
        fontSize = 12.5.sp,
        color = Color(0xFF0F172A)
      )

      Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 2.dp)
      ) {
        Icon(
          imageVector = Icons.Default.AccountBalance,
          contentDescription = "Source",
          tint = Color(0xFF64748B),
          modifier = Modifier.size(13.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = item.source,
          fontSize = 10.sp,
          color = Color(0xFF64748B)
        )
      }

      Text(
        text = "📌 ${item.description}",
        fontSize = 9.5.sp,
        color = Color(0xFF475569),
        lineHeight = 14.sp,
        modifier = Modifier.padding(top = 4.dp)
      )

      Spacer(modifier = Modifier.height(10.dp))

      // Action Buttons: [📄 O/L ප්‍රශ්න පත්‍රය] and [📝 පිළිතුරු පත්‍රය (Marking Scheme)]
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        // Question Paper Button
        Button(
          onClick = onOpenQuestionPaper,
          shape = RoundedCornerShape(8.dp),
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E293B)),
          contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
          modifier = Modifier
            .weight(1f)
            .testTag("open_ol_paper_${item.year}")
        ) {
          Icon(
            imageVector = Icons.Default.PictureAsPdf,
            contentDescription = "Question Paper",
            tint = Color(0xFFF87171),
            modifier = Modifier.size(15.dp)
          )
          Spacer(modifier = Modifier.width(5.dp))
          Text(
            text = "O/L ප්‍රශ්න පත්‍රය",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
        }

        // Marking Scheme Button
        Button(
          onClick = onOpenAnswerScheme,
          shape = RoundedCornerShape(8.dp),
          colors = ButtonDefaults.buttonColors(
            containerColor = if (item.isLatest) Color(0xFF1D4ED8) else Color(0xFF047857)
          ),
          contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
          modifier = Modifier
            .weight(1f)
            .testTag("open_ol_marking_scheme_${item.year}")
        ) {
          Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = "Marking Scheme",
            tint = Color(0xFF93C5FD),
            modifier = Modifier.size(15.dp)
          )
          Spacer(modifier = Modifier.width(5.dp))
          Text(
            text = "පිළිතුරු පත්‍රය",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
        }
      }
    }
  }
}

