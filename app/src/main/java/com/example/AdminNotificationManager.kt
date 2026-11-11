package com.example

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
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
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ClearAll
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Priority levels for Admin Broadcasts
 */
enum class BroadcastPriority(val titleSinhala: String, val badgeColor: Color, val accentColor: Color) {
  URGENT("🚨 හදිසි / අත්‍යවශ්‍ය", Color(0xFFDC2626), Color(0xFFFEF2F2)),
  ANNOUNCEMENT("📢 සාමාන්‍ය නිවේදනය", Color(0xFF2563EB), Color(0xFFEFF6FF)),
  NEW_CONTENT("📚 නව පාඩම් / ප්‍රශ්න පත්‍ර", Color(0xFF059669), Color(0xFFECFDF5)),
  QUIZ_ALERT("🏆 සජීවී Quiz තරගය", Color(0xFF7C3AED), Color(0xFFF5F3FF))
}

/**
 * Data Model for Admin Broadcast Messages
 */
data class AdminBroadcastMessage(
  val id: String,
  val title: String,
  val message: String,
  val timestamp: Long = System.currentTimeMillis(),
  val formattedDate: String = "2026-09-15",
  val priority: BroadcastPriority = BroadcastPriority.ANNOUNCEMENT,
  val senderName: String = "අකිල ප්‍රභාත් දිසානායක (Admin)",
  val senderPhone: String = "0772843861",
  val targetGrade: String = "ALL", // "ALL" or "06", "07", "08", "09", "10", "11"
  var isRead: Boolean = false
) {
  fun toJson(): JSONObject {
    val json = JSONObject()
    json.put("id", id)
    json.put("title", title)
    json.put("message", message)
    json.put("timestamp", timestamp)
    json.put("formattedDate", formattedDate)
    json.put("priority", priority.name)
    json.put("senderName", senderName)
    json.put("senderPhone", senderPhone)
    json.put("targetGrade", targetGrade)
    json.put("isRead", isRead)
    return json
  }

  companion object {
    fun fromJson(json: JSONObject): AdminBroadcastMessage? {
      return try {
        val priorityEnum = try {
          BroadcastPriority.valueOf(json.optString("priority", "ANNOUNCEMENT"))
        } catch (e: Exception) {
          BroadcastPriority.ANNOUNCEMENT
        }
        AdminBroadcastMessage(
          id = json.optString("id", System.currentTimeMillis().toString()),
          title = json.optString("title", "ඇඩ්මින් නිවේදනය"),
          message = json.optString("message", ""),
          timestamp = json.optLong("timestamp", System.currentTimeMillis()),
          formattedDate = json.optString("formattedDate", "2026-09-15"),
          priority = priorityEnum,
          senderName = json.optString("senderName", "අකිල ප්‍රභාත් දිසානායක (Admin)"),
          senderPhone = json.optString("senderPhone", "0772843861"),
          targetGrade = json.optString("targetGrade", "ALL"),
          isRead = json.optBoolean("isRead", false)
        )
      } catch (e: Exception) {
        null
      }
    }
  }
}

/**
 * Persistence & Repository for Admin Broadcast Messages
 */
object AdminBroadcastManager {
  private const val PREFS_NAME = "admin_broadcast_store"
  private const val KEY_MESSAGES = "broadcast_messages_json"

  fun loadMessages(context: Context): List<AdminBroadcastMessage> {
    try {
      val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
      val jsonStr = prefs.getString(KEY_MESSAGES, null)
      if (!jsonStr.isNullOrBlank()) {
        val array = JSONArray(jsonStr)
        val list = mutableListOf<AdminBroadcastMessage>()
        for (i in 0 until array.length()) {
          val item = AdminBroadcastMessage.fromJson(array.getJSONObject(i))
          if (item != null) list.add(item)
        }
        if (list.isNotEmpty()) {
          return list.sortedByDescending { it.timestamp }
        }
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
    // Default initial seed messages if store is empty
    return getDefaultSeedMessages()
  }

  fun saveMessages(context: Context, messages: List<AdminBroadcastMessage>) {
    try {
      val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
      val array = JSONArray()
      for (msg in messages) {
        array.put(msg.toJson())
      }
      prefs.edit().putString(KEY_MESSAGES, array.toString()).apply()
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }

  fun addMessage(
    context: Context,
    newMessage: AdminBroadcastMessage,
    list: SnapshotStateList<AdminBroadcastMessage>
  ) {
    list.add(0, newMessage)
    saveMessages(context, list.toList())
  }

  fun markAsRead(
    context: Context,
    messageId: String,
    list: SnapshotStateList<AdminBroadcastMessage>
  ) {
    val idx = list.indexOfFirst { it.id == messageId }
    if (idx != -1) {
      list[idx] = list[idx].copy(isRead = true)
      saveMessages(context, list.toList())
    }
  }

  fun markAllAsRead(
    context: Context,
    list: SnapshotStateList<AdminBroadcastMessage>
  ) {
    for (i in 0 until list.size) {
      if (!list[i].isRead) {
        list[i] = list[i].copy(isRead = true)
      }
    }
    saveMessages(context, list.toList())
  }

  fun deleteMessage(
    context: Context,
    messageId: String,
    list: SnapshotStateList<AdminBroadcastMessage>
  ) {
    list.removeAll { it.id == messageId }
    saveMessages(context, list.toList())
  }

  private fun getDefaultSeedMessages(): List<AdminBroadcastMessage> {
    return listOf(
      AdminBroadcastMessage(
        id = "seed_msg_1",
        title = "🔥 2026 නව වාර විභාග ප්‍රශ්න පත්‍ර සහ කෙටි සටහන් එක් කරන ලදී!",
        message = "සියලුම ශ්‍රේණි (06 සිට 11 දක්වා) විෂය නිර්දේශයේ නව ඒකක සහ පසුගිය විභාග ප්‍රශ්න පත්‍ර ඇප් එකට එක්කර ඇත. සටහන් සහ විභාග අංශයෙන් ඒවා අධ්‍යයනය කළ හැක.",
        timestamp = System.currentTimeMillis() - 1000 * 60 * 30, // 30 mins ago
        formattedDate = "අද දින (Live)",
        priority = BroadcastPriority.NEW_CONTENT,
        senderName = "අකිල ප්‍රභාත් දිසානායක (Admin)",
        targetGrade = "ALL",
        isRead = false
      ),
      AdminBroadcastMessage(
        id = "seed_msg_2",
        title = "📢 අද රාත්‍රී 7:00ට සජීවී දෛනික Quiz විභාග තරගය ආරම්භ වේ!",
        message = "දෛනික සජීවී ප්‍රශ්නාවලිය සඳහා අද දිනයේත් සිසුන් විශාල පිරිසක් සහභාගී වීමට නියමිතයි. ඔබගේ දැනුම මැන බලා Leaderboard ශ්‍රේණිගත කිරීම්වල ඉහළටම පැමිණෙන්න.",
        timestamp = System.currentTimeMillis() - 1000 * 60 * 120, // 2 hours ago
        formattedDate = "අද දින (Live)",
        priority = BroadcastPriority.QUIZ_ALERT,
        senderName = "අකිල ප්‍රභාත් දිසානායක (Admin)",
        targetGrade = "ALL",
        isRead = false
      )
    )
  }
}

/**
 * Top Right Notification Bell Circle Button with Continuous Attention Grabber
 * Pulsates, glowing ring, wiggles bell icon, and displays glowing red badge until viewed!
 */
@Composable
fun AdminNotificationBellCircle(
  unreadCount: Int,
  onClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  val hasUnread = unreadCount > 0

  val infiniteTransition = rememberInfiniteTransition(label = "notif_attention_loop")

  // Pulsing scale for attention
  val pulseScale by infiniteTransition.animateFloat(
    initialValue = 1.0f,
    targetValue = if (hasUnread) 1.15f else 1.0f,
    animationSpec = infiniteRepeatable(
      animation = tween(650, easing = FastOutSlowInEasing),
      repeatMode = RepeatMode.Reverse
    ),
    label = "pulse_scale"
  )

  // Gentle bell rotation wiggle to catch eye
  val bellRotation by infiniteTransition.animateFloat(
    initialValue = if (hasUnread) -14f else 0f,
    targetValue = if (hasUnread) 14f else 0f,
    animationSpec = infiniteRepeatable(
      animation = tween(280, easing = LinearEasing),
      repeatMode = RepeatMode.Reverse
    ),
    label = "bell_wiggle"
  )

  // Glowing ring border
  val ringBorderColor by infiniteTransition.animateColor(
    initialValue = if (hasUnread) Color(0xFFFCA5A5) else Color(0xFFE2E8F0),
    targetValue = if (hasUnread) Color(0xFFEF4444) else Color(0xFFCBD5E1),
    animationSpec = infiniteRepeatable(
      animation = tween(650, easing = FastOutSlowInEasing),
      repeatMode = RepeatMode.Reverse
    ),
    label = "ring_color"
  )

  Box(
    modifier = modifier
      .size(38.dp)
      .testTag("notification_button"),
    contentAlignment = Alignment.Center
  ) {
    // Outer animated glow ring when unread messages exist
    if (hasUnread) {
      Box(
        modifier = Modifier
          .fillMaxSize()
          .scale(pulseScale)
          .clip(CircleShape)
          .background(Color(0xFFFFE4E6).copy(alpha = 0.65f))
      )
    }

    // Main Circle Button
    Surface(
      onClick = onClick,
      shape = CircleShape,
      color = if (hasUnread) Color(0xFFFFF1F2) else Color.White,
      border = BorderStroke(if (hasUnread) 1.5.dp else 1.dp, ringBorderColor),
      modifier = Modifier
        .size(32.dp)
        .testTag("notification_bell_circle")
    ) {
      Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
      ) {
        Icon(
          imageVector = if (hasUnread) Icons.Default.NotificationsActive else Icons.Default.Notifications,
          contentDescription = "Admin Notifications",
          tint = if (hasUnread) Color(0xFFDC2626) else Color(0xFF475569),
          modifier = Modifier
            .size(17.dp)
            .graphicsLayer(
              rotationZ = if (hasUnread) bellRotation else 0f,
              scaleX = if (hasUnread) pulseScale else 1f,
              scaleY = if (hasUnread) pulseScale else 1f
            )
        )
      }
    }

    // Glowing Red Badge Circle with count
    if (hasUnread) {
      Surface(
        shape = CircleShape,
        color = Color(0xFFDC2626),
        border = BorderStroke(1.dp, Color.White),
        modifier = Modifier
          .align(Alignment.TopEnd)
          .size(16.dp)
          .testTag("notification_badge")
      ) {
        Box(contentAlignment = Alignment.Center) {
          Text(
            text = if (unreadCount > 9) "9+" else unreadCount.toString(),
            color = Color.White,
            fontSize = 9.sp,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Center
          )
        }
      }
    }
  }
}

/**
 * Attention-Grabbing Notification Bar (Banner) displayed until student views the message!
 */
@Composable
fun AdminAnnouncementNotificationBar(
  latestMessage: AdminBroadcastMessage,
  unreadCount: Int,
  onClick: () -> Unit,
  onDismiss: () -> Unit,
  modifier: Modifier = Modifier
) {
  val infiniteTransition = rememberInfiniteTransition(label = "banner_pulse")
  val pulseAlpha by infiniteTransition.animateFloat(
    initialValue = 0.85f,
    targetValue = 1.0f,
    animationSpec = infiniteRepeatable(
      animation = tween(500, easing = FastOutSlowInEasing),
      repeatMode = RepeatMode.Reverse
    ),
    label = "alpha"
  )

  AnimatedVisibility(
    visible = true,
    enter = slideInVertically() + fadeIn(),
    exit = slideOutVertically() + fadeOut()
  ) {
    Surface(
      onClick = onClick,
      shape = RoundedCornerShape(12.dp),
      color = latestMessage.priority.accentColor,
      border = BorderStroke(1.5.dp, latestMessage.priority.badgeColor.copy(alpha = pulseAlpha)),
      shadowElevation = 3.dp,
      modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp, vertical = 4.dp)
        .testTag("admin_announcement_bar")
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 10.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Row(
          modifier = Modifier.weight(1f),
          verticalAlignment = Alignment.CenterVertically
        ) {
          // Pulsing Bell Icon Circle
          Surface(
            shape = CircleShape,
            color = latestMessage.priority.badgeColor,
            modifier = Modifier.size(28.dp)
          ) {
            Box(contentAlignment = Alignment.Center) {
              Icon(
                imageVector = Icons.Default.Campaign,
                contentDescription = "Announcement",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
              )
            }
          }

          Spacer(modifier = Modifier.width(8.dp))

          Column(modifier = Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text(
                text = "👑 ඇඩ්මින් පණිවිඩය ($unreadCount කියවා නැත)",
                fontSize = 11.sp,
                fontWeight = FontWeight.ExtraBold,
                color = latestMessage.priority.badgeColor
              )
              Spacer(modifier = Modifier.width(6.dp))
              Surface(
                shape = RoundedCornerShape(4.dp),
                color = latestMessage.priority.badgeColor
              ) {
                Text(
                  text = "NEW",
                  color = Color.White,
                  fontSize = 8.sp,
                  fontWeight = FontWeight.Bold,
                  modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                )
              }
            }

            Text(
              text = latestMessage.title,
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF1E293B),
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )

            Text(
              text = "බලන්න මෙතන තට්ටු කරන්න (Tap to read)",
              fontSize = 10.sp,
              color = Color(0xFF64748B)
            )
          }
        }

        Spacer(modifier = Modifier.width(6.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = latestMessage.priority.badgeColor
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = "බලන්න",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Spacer(modifier = Modifier.width(2.dp))
              Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Open",
                tint = Color.White,
                modifier = Modifier.size(11.dp)
              )
            }
          }
        }
      }
    }
  }
}

/**
 * The Admin Broadcast Message Composer Box
 * Where the Admin can type and broadcast messages to all users
 */
@Composable
fun AdminBroadcastComposerBox(
  onSendMessage: (title: String, message: String, priority: BroadcastPriority, targetGrade: String) -> Unit,
  modifier: Modifier = Modifier
) {
  var titleText by remember { mutableStateOf("") }
  var messageText by remember { mutableStateOf("") }
  var selectedPriority by remember { mutableStateOf(BroadcastPriority.URGENT) }
  var selectedTargetGrade by remember { mutableStateOf("ALL") }

  val context = LocalContext.current

  Card(
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC)),
    border = BorderStroke(1.5.dp, Color(0xFFCBD5E1)),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    modifier = modifier.fillMaxWidth()
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(14.dp)
    ) {
      // Header
      Row(verticalAlignment = Alignment.CenterVertically) {
        Surface(
          shape = CircleShape,
          color = Color(0xFF1E3A8A),
          modifier = Modifier.size(28.dp)
        ) {
          Box(contentAlignment = Alignment.Center) {
            Icon(
              imageVector = Icons.Default.Campaign,
              contentDescription = "Broadcast",
              tint = Color.White,
              modifier = Modifier.size(16.dp)
            )
          }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
          Text(
            text = "📢 ඇඩ්මින් පණිවිඩ යැවීමේ බොක්ස් එක (Admin Broadcast Box)",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 13.sp,
            color = Color(0xFF0F172A)
          )
          Text(
            text = "මෙහි යවන පණිවිඩය ඇප් එක භාවිත කරන සියලු සිසුන්ගේ ඉහළින් Notification එකක් ලෙස දර්ශනය වේ.",
            fontSize = 10.sp,
            color = Color(0xFF64748B)
          )
        }
      }

      Spacer(modifier = Modifier.height(12.dp))

      // Priority Selector
      Text(
        text = "පණිවිඩයේ වර්ගය / ප්‍රමුඛතාව (Priority):",
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF334155)
      )
      Spacer(modifier = Modifier.height(4.dp))
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        BroadcastPriority.values().forEach { priority ->
          val isSelected = selectedPriority == priority
          FilterChip(
            selected = isSelected,
            onClick = { selectedPriority = priority },
            label = {
              Text(
                text = priority.titleSinhala,
                fontSize = 10.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
              )
            },
            colors = FilterChipDefaults.filterChipColors(
              selectedContainerColor = priority.badgeColor,
              selectedLabelColor = Color.White
            )
          )
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      // Target Grade Selector
      Text(
        text = "ඉලක්කගත ශ්‍රේණිය (Target Audience):",
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF334155)
      )
      Spacer(modifier = Modifier.height(4.dp))
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        listOf("ALL" to "සියලු සිසුන්ට (O/L)", "10" to "10 වසර", "11" to "11 වසර (O/L)").forEach { (gradeVal, label) ->
          val isSelected = selectedTargetGrade == gradeVal
          FilterChip(
            selected = isSelected,
            onClick = { selectedTargetGrade = gradeVal },
            label = {
              Text(
                text = label,
                fontSize = 10.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
              )
            }
          )
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      // Message Title Input
      OutlinedTextField(
        value = titleText,
        onValueChange = { titleText = it },
        label = { Text("පණිවිඩයේ මාතෘකාව (Title in Sinhala)") },
        placeholder = { Text("උදා: 📢 විශේෂ නිවේදනයයි / නව ප්‍රශ්න පත්‍ර එක්විය") },
        singleLine = true,
        modifier = Modifier
          .fillMaxWidth()
          .testTag("admin_msg_title_input")
      )

      Spacer(modifier = Modifier.height(8.dp))

      // Message Body Input
      OutlinedTextField(
        value = messageText,
        onValueChange = { messageText = it },
        label = { Text("සම්පූර්ණ පණිවිඩය (Full Announcement Message)") },
        placeholder = { Text("සිසුන් වෙත යැවිය යුතු විස්තරය මෙහි පැහැදිලිව සටහන් කරන්න...") },
        minLines = 3,
        maxLines = 6,
        modifier = Modifier
          .fillMaxWidth()
          .testTag("admin_msg_body_input")
      )

      Spacer(modifier = Modifier.height(12.dp))

      // Send Button
      Button(
        onClick = {
          val cleanTitle = titleText.trim()
          val cleanBody = messageText.trim()
          if (cleanTitle.isBlank() || cleanBody.isBlank()) {
            Toast.makeText(context, "කරුණාකර මාතෘකාව සහ පණිවිඩය ඇතුළත් කරන්න!", Toast.LENGTH_SHORT).show()
          } else {
            onSendMessage(cleanTitle, cleanBody, selectedPriority, selectedTargetGrade)
            titleText = ""
            messageText = ""
            Toast.makeText(context, "🚀 පණිවිඩය සාර්ථකව පරිශීලකයින් වෙත යවන ලදී!", Toast.LENGTH_LONG).show()
          }
        },
        colors = ButtonDefaults.buttonColors(
          containerColor = selectedPriority.badgeColor
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
          .fillMaxWidth()
          .height(46.dp)
          .testTag("send_broadcast_button")
      ) {
        Icon(Icons.Default.Send, contentDescription = "Send")
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "🚀 පරිශීලකයින්ට පණිවිඩය යවන්න (Broadcast Now)",
          fontWeight = FontWeight.Bold,
          fontSize = 12.sp
        )
      }
    }
  }
}

/**
 * Full Notification Center Dialog
 * Shows all announcements, marks as read, allows admin to compose and delete
 */
@Composable
fun AdminNotificationCenterDialog(
  messages: SnapshotStateList<AdminBroadcastMessage>,
  isAdmin: Boolean,
  onDismiss: () -> Unit,
  onNewBroadcastCreated: (title: String, message: String, priority: BroadcastPriority, targetGrade: String) -> Unit,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  var showComposeSheet by remember { mutableStateOf(false) }

  val unreadCount = messages.count { !it.isRead }

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false)
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth(0.95f)
        .padding(vertical = 24.dp),
      contentAlignment = Alignment.Center
    ) {
      Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
        modifier = Modifier
          .fillMaxWidth()
          .testTag("notification_center_dialog")
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
          // Dialog Header
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Surface(
                shape = CircleShape,
                color = Color(0xFFDC2626),
                modifier = Modifier.size(34.dp)
              ) {
                Box(contentAlignment = Alignment.Center) {
                  Icon(
                    imageVector = Icons.Default.NotificationsActive,
                    contentDescription = "Bell",
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                  )
                }
              }
              Spacer(modifier = Modifier.width(8.dp))
              Column {
                Text(
                  text = "දැනුම්දීම් පුවරුව (Notification Center)",
                  fontSize = 14.sp,
                  fontWeight = FontWeight.ExtraBold,
                  color = Color(0xFF0F172A)
                )
                Text(
                  text = if (unreadCount > 0) "කියවා නැති පණිවිඩ ${unreadCount}ක් ඇත" else "සියලු පණිවිඩ කියවා අවසන්",
                  fontSize = 10.sp,
                  color = if (unreadCount > 0) Color(0xFFDC2626) else Color(0xFF16A34A),
                  fontWeight = FontWeight.SemiBold
                )
              }
            }

            IconButton(onClick = onDismiss) {
              Icon(Icons.Default.Close, contentDescription = "Close", tint = Color(0xFF64748B))
            }
          }

          Spacer(modifier = Modifier.height(10.dp))

          // Action Toolbar: Mark All Read & Admin Compose Button
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            if (unreadCount > 0) {
              TextButton(
                onClick = {
                  AdminBroadcastManager.markAllAsRead(context, messages)
                  Toast.makeText(context, "සියලු පණිවිඩ කියවූ බව සලකුණු විය", Toast.LENGTH_SHORT).show()
                },
                contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp)
              ) {
                Icon(Icons.Default.ClearAll, contentDescription = "Mark All Read", tint = Color(0xFF2563EB), modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("සියල්ල කියවූ බව සලකුණු කරන්න", fontSize = 11.sp, color = Color(0xFF2563EB), fontWeight = FontWeight.Bold)
              }
            } else {
              Spacer(modifier = Modifier.width(4.dp))
            }

            if (isAdmin) {
              Button(
                onClick = { showComposeSheet = !showComposeSheet },
                colors = ButtonDefaults.buttonColors(
                  containerColor = if (showComposeSheet) Color(0xFF64748B) else Color(0xFF1E3A8A)
                ),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 3.dp)
              ) {
                Icon(
                  imageVector = if (showComposeSheet) Icons.Default.Close else Icons.Default.Campaign,
                  contentDescription = "Compose",
                  modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                  text = if (showComposeSheet) "වසා දමන්න" else "✏️ පණිවිඩයක් යවන්න",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold
                )
              }
            }
          }

          // Admin Compose Box expandable inside dialog
          if (isAdmin && showComposeSheet) {
            Spacer(modifier = Modifier.height(8.dp))
            AdminBroadcastComposerBox(
              onSendMessage = { title, msg, priority, grade ->
                val newMsg = AdminBroadcastMessage(
                  id = System.currentTimeMillis().toString(),
                  title = title,
                  message = msg,
                  priority = priority,
                  targetGrade = grade,
                  formattedDate = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(Date()),
                  isRead = false
                )
                AdminBroadcastManager.addMessage(context, newMsg, messages)
                showComposeSheet = false
              }
            )
            Spacer(modifier = Modifier.height(10.dp))
          }

          HorizontalDivider(color = Color(0xFFE2E8F0))
          Spacer(modifier = Modifier.height(10.dp))

          // List of Announcements
          if (messages.isEmpty()) {
            Box(
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp),
              contentAlignment = Alignment.Center
            ) {
              Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                  imageVector = Icons.Default.Notifications,
                  contentDescription = "Empty",
                  tint = Color(0xFFCBD5E1),
                  modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                  text = "දැනට නව දැනුම්දීම් කිසිවක් නොමැත",
                  fontSize = 12.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF64748B)
                )
                Text(
                  text = "ඇඩ්මින් විසින් පණිවිඩයක් එවූ වහාම මෙහි දිස්වනු ඇත.",
                  fontSize = 10.sp,
                  color = Color(0xFF94A3B8)
                )
              }
            }
          } else {
            LazyColumn(
              modifier = Modifier
                .fillMaxWidth()
                .weight(1f, fill = false),
              verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
              items(messages, key = { it.id }) { msg ->
                BroadcastMessageCard(
                  message = msg,
                  isAdmin = isAdmin,
                  onMarkRead = {
                    AdminBroadcastManager.markAsRead(context, msg.id, messages)
                  },
                  onDelete = {
                    AdminBroadcastManager.deleteMessage(context, msg.id, messages)
                    Toast.makeText(context, "පණිවිඩය ඉවත් කරන ලදී", Toast.LENGTH_SHORT).show()
                  }
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(12.dp))

          // Footer
          Button(
            onClick = {
              // Automatically mark all as read on closing so the attention badge calms down
              AdminBroadcastManager.markAllAsRead(context, messages)
              onDismiss()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E3A8A)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth().height(44.dp)
          ) {
            Text("හරි, තහවුරුයි (Close & Mark as Read)", fontWeight = FontWeight.Bold, fontSize = 12.sp)
          }
        }
      }
    }
  }
}

/**
 * Individual Broadcast Message Card in the Notification Center
 */
@Composable
fun BroadcastMessageCard(
  message: AdminBroadcastMessage,
  isAdmin: Boolean,
  onMarkRead: () -> Unit,
  onDelete: () -> Unit,
  modifier: Modifier = Modifier
) {
  val isUnread = !message.isRead

  Surface(
    shape = RoundedCornerShape(14.dp),
    color = if (isUnread) message.priority.accentColor else Color(0xFFF8FAFC),
    border = BorderStroke(
      if (isUnread) 1.5.dp else 1.dp,
      if (isUnread) message.priority.badgeColor else Color(0xFFE2E8F0)
    ),
    modifier = modifier.fillMaxWidth()
  ) {
    Column(modifier = Modifier.padding(12.dp)) {
      // Top row: Priority Chip, Date & Read/Unread badge
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Surface(
            shape = RoundedCornerShape(6.dp),
            color = message.priority.badgeColor
          ) {
            Text(
              text = message.priority.titleSinhala,
              fontSize = 9.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }

          if (message.targetGrade != "ALL") {
            Spacer(modifier = Modifier.width(4.dp))
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFFE2E8F0)
            ) {
              Text(
                text = "${message.targetGrade} ශ්‍රේණිය",
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF475569),
                modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
              )
            }
          }
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
          Text(
            text = message.formattedDate,
            fontSize = 9.sp,
            color = Color(0xFF64748B)
          )

          if (isAdmin) {
            IconButton(
              onClick = onDelete,
              modifier = Modifier.size(24.dp)
            ) {
              Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color.Red, modifier = Modifier.size(14.dp))
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(6.dp))

      // Message Title
      Text(
        text = message.title,
        fontSize = 13.sp,
        fontWeight = FontWeight.ExtraBold,
        color = Color(0xFF0F172A)
      )

      Spacer(modifier = Modifier.height(4.dp))

      // Message Content
      Text(
        text = message.message,
        fontSize = 11.sp,
        color = Color(0xFF334155),
        lineHeight = 16.sp
      )

      Spacer(modifier = Modifier.height(8.dp))

      // Sender tag & Read button
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Icon(Icons.Default.AdminPanelSettings, contentDescription = "Admin", tint = Color(0xFF1E3A8A), modifier = Modifier.size(14.dp))
          Spacer(modifier = Modifier.width(4.dp))
          Text(
            text = "${message.senderName} • ${message.senderPhone}",
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF1E3A8A)
          )
        }

        if (isUnread) {
          TextButton(
            onClick = onMarkRead,
            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp),
            modifier = Modifier.height(26.dp)
          ) {
            Icon(Icons.Default.CheckCircle, contentDescription = "Mark Read", tint = Color(0xFF16A34A), modifier = Modifier.size(13.dp))
            Spacer(modifier = Modifier.width(3.dp))
            Text("කියවන ලදී", fontSize = 10.sp, color = Color(0xFF16A34A), fontWeight = FontWeight.Bold)
          }
        } else {
          Text(
            text = "✓ කියවා අවසන්",
            fontSize = 9.sp,
            color = Color(0xFF94A3B8),
            fontWeight = FontWeight.Medium
          )
        }
      }
    }
  }
}
