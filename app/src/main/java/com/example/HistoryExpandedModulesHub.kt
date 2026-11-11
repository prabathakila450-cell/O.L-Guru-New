package com.example

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * COMPOSABLE SUB-SECTIONS FOR EXPANDED HISTORY MODULES (GRADES 10 & 11)
 * Designed with compact, low-height layouts, Material 3 colors,
 * interactive reveals and exam-tested syllabus accuracy.
 */

// 1. ANCIENT ART & SCULPTURE SECTION
@Composable
fun HistoryArtSculptureSection(items: List<HistoryArtSculptureItem>) {
  Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
    items.forEach { item ->
      var expanded by remember { mutableStateOf(false) }

      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFFE11D48).copy(alpha = 0.4f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Column(modifier = Modifier.weight(1f)) {
              Text(
                text = item.title,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFDA4AF)
              )
              Text(
                text = "${item.category} • ${item.period}",
                fontSize = 10.sp,
                color = Color(0xFF94A3B8)
              )
            }
            IconButton(
              onClick = { expanded = !expanded },
              modifier = Modifier.size(32.dp)
            ) {
              Icon(
                imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                contentDescription = null,
                tint = Color(0xFFFDA4AF)
              )
            }
          }

          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = "ප්‍රධාන ලක්ෂණ: ${item.keyFeatures.take(2).joinToString("; ")}...",
            fontSize = 11.sp,
            color = Color(0xFFE2E8F0),
            lineHeight = 15.sp
          )

          AnimatedVisibility(visible = expanded) {
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
            ) {
              Text("🎨 සම්පූර්ණ ලක්ෂණ:", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFB7185))
              item.keyFeatures.forEach { f ->
                Text(" • $f", fontSize = 10.5.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)
              }

              Spacer(modifier = Modifier.height(6.dp))
              Surface(
                color = Color(0xFF4C0519),
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(8.dp)) {
                  Text("විකාශනය / සංසන්දනය:", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFECDD3))
                  Text(item.evolutionOrComparison, fontSize = 10.sp, color = Color.White, lineHeight = 14.sp)
                  Spacer(modifier = Modifier.height(4.dp))
                  Text("විභාග විශේෂ සටහන:", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE68A))
                  Text(item.examSignificance, fontSize = 10.sp, color = Color(0xFFFEF3C7), lineHeight = 14.sp)
                }
              }
            }
          }
        }
      }
    }
  }
}

// 2. HISTORICAL TREATIES SECTION
@Composable
fun HistoryTreatiesSection(items: List<HistoryTreatyItem>) {
  Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
    items.forEach { treaty ->
      var showClauses by remember { mutableStateOf(false) }

      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFFB45309).copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Column(modifier = Modifier.weight(1f)) {
              Text(
                text = treaty.treatyName,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFDE68A)
              )
              Text(
                text = "${treaty.yearAndPlace} • ${treaty.signatoryParties}",
                fontSize = 10.sp,
                color = Color(0xFF94A3B8)
              )
            }
            Surface(
              color = Color(0xFF78350F),
              shape = RoundedCornerShape(6.dp),
              modifier = Modifier.clickable { showClauses = !showClauses }
            ) {
              Text(
                text = if (showClauses) "හකුලන්න" else "වගන්ති & රහස්",
                color = Color(0xFFFDE68A),
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
              )
            }
          }

          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = "ප්‍රධාන බලපෑම: ${treaty.impactOnSovereignty}",
            fontSize = 11.sp,
            color = Color(0xFFE2E8F0),
            lineHeight = 15.sp
          )

          AnimatedVisibility(visible = showClauses) {
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
            ) {
              Text("📜 ප්‍රධාන වගන්ති:", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFCD34D))
              treaty.majorClauses.forEach { cl ->
                Text(" • $cl", fontSize = 10.5.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)
              }

              Spacer(modifier = Modifier.height(6.dp))
              Surface(
                color = Color(0xFF451A03),
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(8.dp)) {
                  Text("⚠️ කූට උපක්‍රමය / රහස් වගන්තිය:", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFCA5A5))
                  Text(treaty.deceptionOrSecretClauses, fontSize = 10.sp, color = Color(0xFFFEF2F2), lineHeight = 14.sp)
                }
              }
            }
          }
        }
      }
    }
  }
}

// 3. CASCADE TANK SYSTEM SECTION
@Composable
fun HistoryCascadeTanksSection(items: List<HistoryCascadeTankComponent>) {
  Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
    Surface(
      color = Color(0xFF064E3B),
      shape = RoundedCornerShape(10.dp),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(10.dp)) {
        Text(
          text = "🌿 එල්ලංගා වැව් පද්ධතිය (Cascade Tank System) - FAO / UNESCO ලෝක උරුමය",
          fontSize = 11.5.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFFA7F3D0)
        )
        Text(
          text = "ස්වාභාවික කඳුකර ජල ද්‍රෝණි ආශ්‍රිතව එකිනෙකට සම්බන්ධ වූ කුඩා හා විශාල වැව් මාලාවක් හරහා ජලය සහ පරිසරය ආරක්ෂා කරගැනීමේ අසිරිමත් හෙළ තාක්ෂණය.",
          fontSize = 10.sp,
          color = Color(0xFFE6FFFA),
          lineHeight = 14.sp
        )
      }
    }

    items.forEach { component ->
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFF059669).copy(alpha = 0.4f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = component.componentName,
              fontSize = 13.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFA7F3D0)
            )
            Surface(
              color = Color(0xFF065F46),
              shape = RoundedCornerShape(4.dp)
            ) {
              Text(
                text = "පාරිසරික අංගය",
                color = Color(0xFFD1FAE5),
                fontSize = 8.5.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
              )
            }
          }

          Spacer(modifier = Modifier.height(4.dp))
          Text("පිහිටීම: ${component.locationInCascade}", fontSize = 10.sp, color = Color(0xFF94A3B8))
          Spacer(modifier = Modifier.height(4.dp))
          Text("කාර්යභාරය: ${component.mainFunction}", fontSize = 10.5.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)
          Spacer(modifier = Modifier.height(4.dp))
          Text("පාරිසරික අගය: ${component.ecologicalSignificance}", fontSize = 10.5.sp, color = Color(0xFF86EFAC), lineHeight = 15.sp)
        }
      }
    }
  }
}

// 4. NATIONAL REVIVAL SECTION
@Composable
fun HistoryRevivalSection(items: List<HistoryRevivalLeaderItem>) {
  Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
    items.forEach { item ->
      var expanded by remember { mutableStateOf(false) }

      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFFEA580C).copy(alpha = 0.4f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Column(modifier = Modifier.weight(1f)) {
              Text(
                text = item.leaderOrMovement,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFDBA74)
              )
              Text("කාලය: ${item.period}", fontSize = 10.sp, color = Color(0xFF94A3B8))
            }
            IconButton(
              onClick = { expanded = !expanded },
              modifier = Modifier.size(32.dp)
            ) {
              Icon(
                imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                contentDescription = null,
                tint = Color(0xFFFDBA74)
              )
            }
          }

          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = "ප්‍රධාන සේවාවන්: ${item.coreContributions.take(2).joinToString("; ")}...",
            fontSize = 11.sp,
            color = Color(0xFFE2E8F0),
            lineHeight = 15.sp
          )

          AnimatedVisibility(visible = expanded) {
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
            ) {
              item.coreContributions.forEach { c ->
                Text(" • $c", fontSize = 10.5.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)
              }
              if (item.publicationsOrSchools.isNotEmpty()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = "බිහිකළ පාසල් / පුවත්පත්: ${item.publicationsOrSchools.joinToString(", ")}",
                  fontSize = 10.5.sp,
                  color = Color(0xFFFDE68A),
                  fontWeight = FontWeight.Medium
                )
              }
              Spacer(modifier = Modifier.height(6.dp))
              Surface(
                color = Color(0xFF431407),
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Text(
                  text = "විභාග විශේෂ කරුණ: ${item.keyExamPoints}",
                  fontSize = 10.sp,
                  color = Color(0xFFFFEDD5),
                  modifier = Modifier.padding(6.dp)
                )
              }
            }
          }
        }
      }
    }
  }
}

// 5. WORLD HISTORY MAJOR ERAS SECTION
@Composable
fun HistoryWorldErasSection(items: List<HistoryWorldEraItem>) {
  Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
    items.forEach { era ->
      var expanded by remember { mutableStateOf(false) }

      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFF0891B2).copy(alpha = 0.4f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Column(modifier = Modifier.weight(1f)) {
              Text(
                text = era.eraTitle,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF67E8F9)
              )
              Text("කාලසීමාව: ${era.timePeriod}", fontSize = 10.sp, color = Color(0xFF94A3B8))
            }
            IconButton(
              onClick = { expanded = !expanded },
              modifier = Modifier.size(32.dp)
            ) {
              Icon(
                imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                contentDescription = null,
                tint = Color(0xFF67E8F9)
              )
            }
          }

          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = "ලංකාවට බලපෑම: ${era.sriLankanImpact}",
            fontSize = 10.5.sp,
            color = Color(0xFFE2E8F0),
            lineHeight = 15.sp
          )

          AnimatedVisibility(visible = expanded) {
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
            ) {
              Text("⚡ හේතු:", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF22D3EE))
              era.causes.forEach { c -> Text(" • $c", fontSize = 10.5.sp, color = Color(0xFFE2E8F0)) }

              Spacer(modifier = Modifier.height(4.dp))
              Text("💥 ප්‍රධාන වර්ධනයන්:", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE68A))
              era.majorDevelopments.forEach { d -> Text(" • $d", fontSize = 10.5.sp, color = Color(0xFFE2E8F0)) }

              Spacer(modifier = Modifier.height(4.dp))
              Text("🌍 ගෝලීය ප්‍රතිඵල:", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF86EFAC))
              era.globalConsequences.forEach { gc -> Text(" • $gc", fontSize = 10.5.sp, color = Color(0xFFE2E8F0)) }
            }
          }
        }
      }
    }
  }
}

// 6. TIMELINE CHALLENGE SECTION (Interactive Ordering)
@Composable
fun HistoryTimelineChallengeSection(items: List<HistoryTimelineChallengeItem>) {
  Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
    items.forEach { challenge ->
      var showSolution by remember { mutableStateOf(false) }

      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFF7C3AED).copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
              Text("⏳", fontSize = 16.sp)
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = challenge.challengeTitle,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFDDD6FE)
              )
            }
            Surface(
              color = if (showSolution) Color(0xFF5B21B6) else Color(0xFF6D28D9),
              shape = RoundedCornerShape(6.dp),
              modifier = Modifier.clickable { showSolution = !showSolution }
            ) {
              Text(
                text = if (showSolution) "සඟවන්න" else "නිවැරදි පිළිවෙල බලන්න",
                color = Color.White,
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
              )
            }
          }

          Spacer(modifier = Modifier.height(8.dp))
          Text("ප්‍රශ්නය: පහත සිදුවීම් සිදුවූ කාලානුක්‍රමයට අනුව පෙළගස්වන්න:", fontSize = 10.5.sp, color = Color(0xFF94A3B8))
          Spacer(modifier = Modifier.height(4.dp))
          challenge.scrambledEvents.forEach { ev ->
            Surface(
              color = Color(0xFF0F172A),
              shape = RoundedCornerShape(6.dp),
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp)
            ) {
              Text(
                text = ev,
                fontSize = 10.5.sp,
                color = Color(0xFFE2E8F0),
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
              )
            }
          }

          AnimatedVisibility(visible = showSolution) {
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
            ) {
              Surface(
                color = Color(0xFF2E1065),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(8.dp)) {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Color(0xFF4ADE80), modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("නිවැරදි කාලානුක්‍රමික පිළිවෙල:", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
                  }
                  Spacer(modifier = Modifier.height(4.dp))
                  challenge.correctChronologicalOrder.forEach { ord ->
                    Text(ord, fontSize = 10.5.sp, color = Color.White, fontWeight = FontWeight.Medium)
                  }
                  Spacer(modifier = Modifier.height(4.dp))
                  Text(challenge.explanation, fontSize = 10.sp, color = Color(0xFFE9D5FF), lineHeight = 14.sp)
                }
              }
            }
          }
        }
      }
    }
  }
}

// 7. ARTIFACT & IMAGE IDENTIFIER SECTION
@Composable
fun HistoryArtifactSection(items: List<HistoryArtifactItem>) {
  Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
    items.forEach { artf ->
      var showQa by remember { mutableStateOf(false) }

      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFFD97706).copy(alpha = 0.4f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text(artf.iconOrSymbol, fontSize = 18.sp)
              Spacer(modifier = Modifier.width(6.dp))
              Column {
                Text(
                  text = artf.artifactName,
                  fontSize = 13.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFFFDE68A)
                )
                Text(
                  text = "${artf.location} • ${artf.kingdomOrCentury}",
                  fontSize = 9.5.sp,
                  color = Color(0xFF94A3B8)
                )
              }
            }
            IconButton(
              onClick = { showQa = !showQa },
              modifier = Modifier.size(32.dp)
            ) {
              Icon(
                imageVector = Icons.Default.HelpOutline,
                contentDescription = null,
                tint = Color(0xFFFDE68A)
              )
            }
          }

          Spacer(modifier = Modifier.height(6.dp))
          Text("කලාත්මක ලක්ෂණ:", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFBBF24))
          artf.artisticFeatures.forEach { feat ->
            Text(" • $feat", fontSize = 10.5.sp, color = Color(0xFFE2E8F0), lineHeight = 15.sp)
          }

          AnimatedVisibility(visible = showQa) {
            Surface(
              color = Color(0xFF451A03),
              shape = RoundedCornerShape(6.dp),
              modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
            ) {
              Column(modifier = Modifier.padding(8.dp)) {
                Text("📝 විභාග ප්‍රශ්න & ආදර්ශ පිළිතුරු:", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE68A))
                Text(artf.examQuestionsAndAnswers, fontSize = 10.5.sp, color = Color.White, lineHeight = 15.sp)
              }
            }
          }
        }
      }
    }
  }
}
