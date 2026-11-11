package com.example

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ClearAll
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.OndemandVideo
import androidx.compose.material.icons.filled.PictureAsPdf
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import org.json.JSONArray
import org.json.JSONObject

/**
 * Model representing an item held in the staging buffer before being released live to students.
 */
data class StagedContentItem(
  val id: String,
  val type: String, // "NOTE", "PAPER", "VIDEO"
  val gradeTarget: String, // "06", "07", "08", "09", "10", "11"
  val subject: String,
  val title: String,
  val extraInfo: String = "",
  val pdfUri: String? = null,
  val fileName: String? = null,
  val stagedAtTimestamp: Long = System.currentTimeMillis(),
  val formattedDate: String = "අද දින"
)

/**
 * Manager handling draft staging persistence and One-Click Live Release to students.
 */
object AdminStagingManager {
  private const val PREFS_NAME = "admin_staging_content_prefs"
  private const val KEY_STAGED_ITEMS = "staged_items_json"
  private const val KEY_RELEASED_ITEMS = "released_items_json"

  fun loadStagedItems(context: Context): List<StagedContentItem> {
    val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    val jsonString = prefs.getString(KEY_STAGED_ITEMS, null) ?: return emptyList()
    val list = mutableListOf<StagedContentItem>()
    try {
      val jsonArray = JSONArray(jsonString)
      for (i in 0 until jsonArray.length()) {
        val obj = jsonArray.getJSONObject(i)
        list.add(
          StagedContentItem(
            id = obj.getString("id"),
            type = obj.getString("type"),
            gradeTarget = obj.getString("gradeTarget"),
            subject = obj.getString("subject"),
            title = obj.getString("title"),
            extraInfo = obj.optString("extraInfo", ""),
            pdfUri = obj.optString("pdfUri").takeIf { it.isNotEmpty() },
            fileName = obj.optString("fileName").takeIf { it.isNotEmpty() },
            stagedAtTimestamp = obj.optLong("timestamp", System.currentTimeMillis()),
            formattedDate = obj.optString("formattedDate", "අද දින")
          )
        )
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
    return list
  }

  fun saveStagedItems(context: Context, items: List<StagedContentItem>) {
    val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    val jsonArray = JSONArray()
    for (item in items) {
      val obj = JSONObject().apply {
        put("id", item.id)
        put("type", item.type)
        put("gradeTarget", item.gradeTarget)
        put("subject", item.subject)
        put("title", item.title)
        put("extraInfo", item.extraInfo)
        put("pdfUri", item.pdfUri ?: "")
        put("fileName", item.fileName ?: "")
        put("timestamp", item.stagedAtTimestamp)
        put("formattedDate", item.formattedDate)
      }
      jsonArray.put(obj)
    }
    prefs.edit().putString(KEY_STAGED_ITEMS, jsonArray.toString()).apply()
  }

  fun addStagedItem(
    context: Context,
    item: StagedContentItem,
    stagedList: SnapshotStateList<StagedContentItem>
  ) {
    stagedList.add(0, item)
    saveStagedItems(context, stagedList)
  }

  fun removeStagedItem(
    context: Context,
    itemId: String,
    stagedList: SnapshotStateList<StagedContentItem>
  ) {
    stagedList.removeAll { it.id == itemId }
    saveStagedItems(context, stagedList)
  }

  fun clearStagedItems(
    context: Context,
    stagedList: SnapshotStateList<StagedContentItem>
  ) {
    stagedList.clear()
    saveStagedItems(context, stagedList)
  }

  fun loadReleasedItems(context: Context): List<StagedContentItem> {
    val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    val jsonString = prefs.getString(KEY_RELEASED_ITEMS, null) ?: return emptyList()
    val list = mutableListOf<StagedContentItem>()
    try {
      val jsonArray = JSONArray(jsonString)
      for (i in 0 until jsonArray.length()) {
        val obj = jsonArray.getJSONObject(i)
        list.add(
          StagedContentItem(
            id = obj.getString("id"),
            type = obj.getString("type"),
            gradeTarget = obj.getString("gradeTarget"),
            subject = obj.getString("subject"),
            title = obj.getString("title"),
            extraInfo = obj.optString("extraInfo", ""),
            pdfUri = obj.optString("pdfUri").takeIf { it.isNotEmpty() },
            fileName = obj.optString("fileName").takeIf { it.isNotEmpty() },
            stagedAtTimestamp = obj.optLong("timestamp", System.currentTimeMillis()),
            formattedDate = obj.optString("formattedDate", "අද දින")
          )
        )
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
    return list
  }

  fun saveReleasedItems(context: Context, items: List<StagedContentItem>) {
    val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    val jsonArray = JSONArray()
    for (item in items) {
      val obj = JSONObject().apply {
        put("id", item.id)
        put("type", item.type)
        put("gradeTarget", item.gradeTarget)
        put("subject", item.subject)
        put("title", item.title)
        put("extraInfo", item.extraInfo)
        put("pdfUri", item.pdfUri ?: "")
        put("fileName", item.fileName ?: "")
        put("timestamp", item.stagedAtTimestamp)
        put("formattedDate", item.formattedDate)
      }
      jsonArray.put(obj)
    }
    prefs.edit().putString(KEY_RELEASED_ITEMS, jsonArray.toString()).apply()
  }

  /**
   * One-Click Instant Release: Pushes all staged items into live student feeds,
   * generates an urgent broadcast notification to students, and clears the draft staging buffer.
   */
  fun releaseAllStagedToLive(
    context: Context,
    stagedList: SnapshotStateList<StagedContentItem>,
    liveNotesMap: MutableMap<String, SnapshotStateList<ShortNoteItem>>,
    livePapersMap: MutableMap<String, SnapshotStateList<QuestionPaperItem>>,
    liveVideosMap: MutableMap<String, SnapshotStateList<VideoLessonItem>>,
    adminBroadcastMessages: SnapshotStateList<AdminBroadcastMessage>,
    onComplete: (releasedCount: Int) -> Unit
  ) {
    if (stagedList.isEmpty()) {
      Toast.makeText(context, "නිකුත් කිරීමට කිසිදු අන්තර්ගතයක් නොමැත", Toast.LENGTH_SHORT).show()
      return
    }

    val count = stagedList.size
    val currentReleased = loadReleasedItems(context).toMutableList()

    stagedList.forEach { item ->
      currentReleased.add(0, item)
      when (item.type) {
        "NOTE" -> {
          liveNotesMap[item.gradeTarget]?.add(
            0,
            ShortNoteItem(
              id = item.id,
              subject = item.subject,
              title = "${item.gradeTarget} ශ්‍රේණිය - ${item.title}",
              topicSinhala = "${item.gradeTarget} ශ්‍රේණිය ${item.subject}",
              readTime = if (item.fileName != null) "🔒 PDF ගොනුව ඇත" else "මිනිත්තු 10 කියවීම",
              isPopular = true,
              pdfUri = item.pdfUri,
              fileName = item.fileName
            )
          )
        }
        "PAPER" -> {
          livePapersMap[item.gradeTarget]?.add(
            0,
            QuestionPaperItem(
              id = item.id,
              subject = item.subject,
              titleSinhala = "${item.gradeTarget} ශ්‍රේණිය - ${item.title}",
              year = "2025",
              term = item.extraInfo.ifBlank { "1 වන වාරය" },
              marks = if (item.fileName != null) "PDF ගොනුව ඇත" else "ලකුණු 100",
              pdfUri = item.pdfUri,
              fileName = item.fileName
            )
          )
        }
        "VIDEO" -> {
          liveVideosMap[item.gradeTarget]?.add(
            0,
            VideoLessonItem(
              id = item.id,
              subject = item.subject,
              titleSinhala = "${item.gradeTarget} ශ්‍රේණිය - ${item.title}",
              duration = item.extraInfo.ifBlank { "මිනිත්තු 40" },
              tutorName = "දේශක නිපුන් කුමාර",
              viewsCount = "නැරඹුම් 1.5k",
              isHd = true,
              videoUri = item.pdfUri
            )
          )
        }
      }
    }

    saveReleasedItems(context, currentReleased)

    // Send Broadcast Announcement so students are notified instantly
    val broadcastMsg = AdminBroadcastMessage(
      id = "rel_${System.currentTimeMillis()}",
      title = "🚀 නව අන්තර්ගතයන් ($count ක්) Live නිකුත් කරන ලදී!",
      message = "නව ප්‍රශ්න පත්‍ර සහ කෙටි සටහන් $count ක් ඇප් එකට දැන්ම සාර්ථකව නිකුත් කරන ලදී. ඔබගේ ශ්‍රේණියට ගොස් නවතම දැනුම ලබාගන්න.",
      priority = BroadcastPriority.NEW_CONTENT,
      targetGrade = "සියලුම ශ්‍රේණි (Grade 6-11)",
      formattedDate = "අද දින (Live)",
      isRead = false
    )
    AdminBroadcastManager.addMessage(context, broadcastMsg, adminBroadcastMessages)

    clearStagedItems(context, stagedList)

    Toast.makeText(
      context,
      "🚀 අන්තර්ගතයන් $count ක් සාර්ථකව Live නිකුත් විය! සියලු සිසුන්ට නිවේදනයක්ද යවන ලදී.",
      Toast.LENGTH_LONG
    ).show()

    onComplete(count)
  }
}

/**
 * Top floating notification bar shown ONLY to Admin on the home screen
 * whenever there are pending staged items awaiting release.
 */
@Composable
fun AdminStagingBannerBar(
  stagedCount: Int,
  onReleaseAllClick: () -> Unit,
  onViewStagingClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  val infiniteTransition = rememberInfiniteTransition(label = "pulse")
  val pulseScale by infiniteTransition.animateFloat(
    initialValue = 1f,
    targetValue = 1.03f,
    animationSpec = infiniteRepeatable(
      animation = tween(900, easing = FastOutSlowInEasing),
      repeatMode = RepeatMode.Reverse
    ),
    label = "bannerPulse"
  )

  Surface(
    shape = RoundedCornerShape(14.dp),
    color = Color(0xFFFFFBEB), // Warm amber-50
    border = BorderStroke(1.5.dp, Color(0xFFF59E0B)),
    shadowElevation = 4.dp,
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 4.dp)
      .testTag("admin_staging_banner")
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
        Surface(
          shape = CircleShape,
          color = Color(0xFFF59E0B),
          modifier = Modifier.size(36.dp)
        ) {
          Box(contentAlignment = Alignment.Center) {
            Icon(
              imageVector = Icons.Default.CloudUpload,
              contentDescription = "Draft Staging",
              tint = Color.White,
              modifier = Modifier.size(20.dp)
            )
          }
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
              text = "නිකුත් කිරීමට පොරොත්තු අන්තර්ගත ($stagedCount):",
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF92400E)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFFEF4444),
              modifier = Modifier.padding(horizontal = 2.dp)
            ) {
              Text(
                text = "Drafts",
                fontSize = 9.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
              )
            }
          }
          Text(
            text = "සිසුන්ට පෙනීමට පෙර සියල්ල එකවර රිලීස් කරන්න.",
            fontSize = 10.sp,
            color = Color(0xFFB45309),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
        }
      }

      Spacer(modifier = Modifier.width(8.dp))

      Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
        OutlinedButton(
          onClick = onViewStagingClick,
          contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
          shape = RoundedCornerShape(8.dp),
          border = BorderStroke(1.dp, Color(0xFFD97706)),
          modifier = Modifier.height(32.dp)
        ) {
          Text("බලන්න", fontSize = 11.sp, color = Color(0xFFB45309), fontWeight = FontWeight.Bold)
        }

        Button(
          onClick = onReleaseAllClick,
          contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
          shape = RoundedCornerShape(8.dp),
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF16A34A)),
          modifier = Modifier
            .height(32.dp)
            .testTag("one_click_release_btn")
        ) {
          Icon(
            imageVector = Icons.Default.Send,
            contentDescription = "Release",
            modifier = Modifier.size(14.dp),
            tint = Color.White
          )
          Spacer(modifier = Modifier.width(4.dp))
          Text(
            text = "රිලීස් කරන්න 🚀",
            fontSize = 11.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White
          )
        }
      }
    }
  }
}

/**
 * Section placed directly inside Admin Panel for managing drafts and 1-Click Release.
 */
@Composable
fun AdminStagingCardSection(
  stagedItems: SnapshotStateList<StagedContentItem>,
  onReleaseAll: () -> Unit,
  onOpenStagingDialog: () -> Unit,
  onAddNewContentClick: () -> Unit
) {
  Surface(
    shape = RoundedCornerShape(16.dp),
    color = Color(0xFFFFFBEB),
    border = BorderStroke(1.5.dp, Color(0xFFFBBF24)),
    modifier = Modifier
      .fillMaxWidth()
      .testTag("admin_staging_card_section")
  ) {
    Column(modifier = Modifier.padding(16.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Surface(
            shape = CircleShape,
            color = Color(0xFFF59E0B),
            modifier = Modifier.size(34.dp)
          ) {
            Box(contentAlignment = Alignment.Center) {
              Icon(
                imageVector = Icons.Default.CloudUpload,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(18.dp)
              )
            }
          }
          Spacer(modifier = Modifier.width(10.dp))
          Column {
            Text(
              text = "කෙටුම්පත් එකතු කර එකවර රිලීස් කිරීම",
              fontSize = 13.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF78350F)
            )
            Text(
              text = "Staging Queue & One-Click Live Release",
              fontSize = 10.sp,
              color = Color(0xFF92400E)
            )
          }
        }

        Surface(
          shape = RoundedCornerShape(12.dp),
          color = if (stagedItems.isNotEmpty()) Color(0xFFDC2626) else Color(0xFF16A34A),
          modifier = Modifier.padding(2.dp)
        ) {
          Text(
            text = if (stagedItems.isNotEmpty()) "${stagedItems.size}ක් සූදානම්" else "හිස්ව ඇත",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      Text(
        text = "ඔබට අවශ්‍ය ප්‍රශ්න පත්‍ර, සටහන් සහ වීඩියෝ කලින්ම එකතු කර (Draft) තබාගෙන, සියල්ල නිවැරදිදැයි බලා එකම බොත්තමකින් සියලුම සිසුන්ට එකවර Live රිලීස් කළ හැක.",
        fontSize = 11.sp,
        color = Color(0xFF451A03),
        lineHeight = 16.sp
      )

      Spacer(modifier = Modifier.height(14.dp))

      if (stagedItems.isNotEmpty()) {
        Text(
          text = "නිකුත් කිරීමට ඇති අන්තර්ගතයන් (${stagedItems.size}):",
          fontSize = 11.sp,
          fontWeight = FontWeight.Bold,
          color = Color(0xFF92400E)
        )
        Spacer(modifier = Modifier.height(6.dp))

        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
          stagedItems.take(3).forEach { item ->
            Surface(
              shape = RoundedCornerShape(8.dp),
              color = Color.White,
              border = BorderStroke(1.dp, Color(0xFFFDE68A)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Row(
                  verticalAlignment = Alignment.CenterVertically,
                  modifier = Modifier.weight(1f)
                ) {
                  Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = when (item.type) {
                      "PAPER" -> Color(0xFFDC2626)
                      "VIDEO" -> Color(0xFF7C3AED)
                      else -> Color(0xFF2563EB)
                    }
                  ) {
                    Text(
                      text = "${item.gradeTarget} වසර • ${when (item.type) { "PAPER" -> "ප්‍රශ්න පත්‍ර" ; "VIDEO" -> "වීඩියෝ" ; else -> "සටහන්" }}",
                      fontSize = 9.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color.White,
                      modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                    )
                  }
                  Spacer(modifier = Modifier.width(8.dp))
                  Text(
                    text = item.title,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF1E293B),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                }
              }
            }
          }

          if (stagedItems.size > 3) {
            Text(
              text = "+ තවත් අන්තර්ගත ${stagedItems.size - 3}ක් පෝලිමේ ඇත...",
              fontSize = 10.sp,
              color = Color(0xFFB45309),
              modifier = Modifier.padding(start = 4.dp)
            )
          }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // THE MASSIVE ONE-CLICK RELEASE BUTTON
        Button(
          onClick = onReleaseAll,
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF16A34A)),
          shape = RoundedCornerShape(12.dp),
          modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .testTag("admin_panel_one_click_release_btn")
        ) {
          Icon(Icons.Default.Send, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "🚀 සියල්ල එකවර ඇප් එකට රිලීස් කරන්න (${stagedItems.size})",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 13.sp,
            color = Color.White
          )
        }

        Spacer(modifier = Modifier.height(8.dp))
      }

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        OutlinedButton(
          onClick = onAddNewContentClick,
          shape = RoundedCornerShape(10.dp),
          border = BorderStroke(1.dp, Color(0xFFD97706)),
          modifier = Modifier.weight(1f)
        ) {
          Icon(Icons.Default.Add, contentDescription = null, tint = Color(0xFFD97706), modifier = Modifier.size(16.dp))
          Spacer(modifier = Modifier.width(4.dp))
          Text("අලුත් දෙයක් එක් කරන්න", fontSize = 11.sp, color = Color(0xFF92400E), fontWeight = FontWeight.Bold)
        }

        if (stagedItems.isNotEmpty()) {
          OutlinedButton(
            onClick = onOpenStagingDialog,
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, Color(0xFF475569)),
            modifier = Modifier.weight(1f)
          ) {
            Text("පෝලිම කළමනාකරණය", fontSize = 11.sp, color = Color(0xFF334155), fontWeight = FontWeight.Bold)
          }
        }
      }
    }
  }
}

/**
 * Full Dialog to review and manage the staging queue, delete mistakes, or trigger One-Click Release.
 */
@Composable
fun AdminStagingDialog(
  stagedItems: SnapshotStateList<StagedContentItem>,
  onDismiss: () -> Unit,
  onDeleteItem: (String) -> Unit,
  onClearAll: () -> Unit,
  onReleaseAll: () -> Unit,
  onAddNewClick: () -> Unit
) {
  var showConfirmReleaseDialog by remember { mutableStateOf(false) }

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false)
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth(0.95f)
        .padding(16.dp),
      contentAlignment = Alignment.Center
    ) {
      Surface(
        shape = RoundedCornerShape(20.dp),
        color = Color.White,
        shadowElevation = 12.dp,
        border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(20.dp)) {
          // Header
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Surface(
                shape = CircleShape,
                color = Color(0xFF1E3A8A),
                modifier = Modifier.size(36.dp)
              ) {
                Box(contentAlignment = Alignment.Center) {
                  Icon(
                    imageVector = Icons.Default.CloudUpload,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                  )
                }
              }
              Spacer(modifier = Modifier.width(10.dp))
              Column {
                Text(
                  text = "අන්තර්ගත කෙටුම්පත් පෝලිම",
                  fontWeight = FontWeight.ExtraBold,
                  fontSize = 15.sp,
                  color = Color(0xFF0F172A)
                )
                Text(
                  text = "Staging Queue (${stagedItems.size} items pending)",
                  fontSize = 11.sp,
                  color = Color(0xFF64748B)
                )
              }
            }

            IconButton(onClick = onDismiss) {
              Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.Gray)
            }
          }

          Spacer(modifier = Modifier.height(12.dp))

          if (stagedItems.isEmpty()) {
            Box(
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp),
              contentAlignment = Alignment.Center
            ) {
              Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                  imageVector = Icons.Default.CheckCircle,
                  contentDescription = null,
                  tint = Color(0xFF16A34A),
                  modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                  text = "පොරොත්තු කෙටුම්පත් නොමැත",
                  fontSize = 14.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF0F172A)
                )
                Text(
                  text = "නව අන්තර්ගත එකතු කර Draft කර තබාගන්න.",
                  fontSize = 12.sp,
                  color = Color(0xFF64748B)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                  onClick = {
                    onDismiss()
                    onAddNewClick()
                  },
                  colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E3A8A)),
                  shape = RoundedCornerShape(10.dp)
                ) {
                  Icon(Icons.Default.Add, contentDescription = null)
                  Spacer(modifier = Modifier.width(6.dp))
                  Text("නව අන්තර්ගතයක් එක් කරන්න")
                }
              }
            }
          } else {
            // Action bar inside dialog
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = "පරිශීලකයින්ට නිකුත් කිරීමට සූදානම්:",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF334155)
              )
              TextButton(
                onClick = onClearAll,
                contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp)
              ) {
                Icon(Icons.Default.Delete, contentDescription = null, tint = Color.Red, modifier = Modifier.size(14.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("සියල්ල මකන්න", fontSize = 11.sp, color = Color.Red)
              }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Scrollable list of staged items
            LazyColumn(
              modifier = Modifier
                .fillMaxWidth()
                .height(260.dp),
              verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              items(stagedItems, key = { it.id }) { item ->
                Surface(
                  shape = RoundedCornerShape(10.dp),
                  color = Color(0xFFF8FAFC),
                  border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Row(
                    modifier = Modifier.padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                  ) {
                    Column(modifier = Modifier.weight(1f)) {
                      Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                          shape = RoundedCornerShape(4.dp),
                          color = when (item.type) {
                            "PAPER" -> Color(0xFFDC2626)
                            "VIDEO" -> Color(0xFF7C3AED)
                            else -> Color(0xFF2563EB)
                          }
                        ) {
                          Text(
                            text = "${item.gradeTarget} ශ්‍රේණිය • ${when (item.type) { "PAPER" -> "ප්‍රශ්න පත්‍ර" ; "VIDEO" -> "වීඩියෝ" ; else -> "සටහන්" }}",
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                          )
                        }

                        Spacer(modifier = Modifier.width(6.dp))

                        if (item.fileName != null) {
                          Surface(
                            shape = RoundedCornerShape(4.dp),
                            color = Color(0xFFE0F2FE)
                          ) {
                            Text(
                              text = "PDF ඇත",
                              fontSize = 9.sp,
                              color = Color(0xFF0369A1),
                              modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                            )
                          }
                        }
                      }

                      Spacer(modifier = Modifier.height(4.dp))
                      Text(
                        text = item.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Color(0xFF0F172A),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                      )
                      Text(
                        text = "විෂය: ${item.subject} • ${item.extraInfo.ifBlank { "සාමාන්‍ය" }}",
                        fontSize = 10.sp,
                        color = Color(0xFF64748B)
                      )
                    }

                    IconButton(
                      onClick = { onDeleteItem(item.id) },
                      modifier = Modifier.size(28.dp)
                    ) {
                      Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Remove",
                        tint = Color(0xFFEF4444),
                        modifier = Modifier.size(16.dp)
                      )
                    }
                  }
                }
              }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // THE MASSIVE ONE-CLICK LIVE RELEASE BUTTON
            Button(
              onClick = { showConfirmReleaseDialog = true },
              shape = RoundedCornerShape(12.dp),
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF16A34A)),
              modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .testTag("dialog_release_all_btn")
            ) {
              Icon(Icons.Default.Send, contentDescription = null, tint = Color.White)
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = "🚀 සියල්ල එකවර ඇප් එකට රිලීස් කරන්න (${stagedItems.size})",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 13.sp,
                color = Color.White
              )
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(
              onClick = {
                onDismiss()
                onAddNewClick()
              },
              shape = RoundedCornerShape(10.dp),
              border = BorderStroke(1.dp, Color(0xFF1E3A8A)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Icon(Icons.Default.Add, contentDescription = null, tint = Color(0xFF1E3A8A), modifier = Modifier.size(16.dp))
              Spacer(modifier = Modifier.width(4.dp))
              Text("තවත් අන්තර්ගතයක් එකතු කරන්න (Add More)", fontSize = 11.sp, color = Color(0xFF1E3A8A), fontWeight = FontWeight.Bold)
            }
          }
        }
      }
    }
  }

  // Confirmation Alert Dialog before releasing
  if (showConfirmReleaseDialog) {
    AlertDialog(
      onDismissRequest = { showConfirmReleaseDialog = false },
      title = {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Icon(Icons.Default.Send, contentDescription = null, tint = Color(0xFF16A34A))
          Spacer(modifier = Modifier.width(8.dp))
          Text(text = "ඇප් එකට Live නිකුත් කිරීම", fontWeight = FontWeight.Bold)
        }
      },
      text = {
        Text(
          text = "ඔබ විසින් සූදානම් කරන ලද අන්තර්ගතයන් ${stagedItems.size}ක් එකවර සියලුම සිසුන්ට පෙනෙන සේ නිකුත් කර, ඒ පිළිබඳව ස්වයංක්‍රීයව Notification එකක්ද යැවීමට අවශ්‍යද?",
          fontSize = 12.sp,
          color = Color(0xFF334155),
          lineHeight = 18.sp
        )
      },
      confirmButton = {
        Button(
          onClick = {
            showConfirmReleaseDialog = false
            onReleaseAll()
            onDismiss()
          },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF16A34A))
        ) {
          Text("ඔව්, දැන්ම Live කරන්න 🚀", fontWeight = FontWeight.Bold)
        }
      },
      dismissButton = {
        TextButton(onClick = { showConfirmReleaseDialog = false }) {
          Text("පසුවට තබන්න")
        }
      }
    )
  }
}
