package com.example

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.icons.filled.WifiOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun CloudInternetWaitDialog(
  visible: Boolean,
  isWaitingForInternet: Boolean,
  title: String,
  statusMessage: String,
  onCancel: (() -> Unit)? = null
) {
  if (!visible) return

  val accentColor = if (isWaitingForInternet) Color(0xFFD97706) else Color(0xFF059669)
  val bgColor = if (isWaitingForInternet) Color(0xFFFFFBEB) else Color(0xFFECFDF5)
  val borderColor = if (isWaitingForInternet) Color(0xFFF59E0B) else Color(0xFF10B981)
  val textColor = if (isWaitingForInternet) Color(0xFF92400E) else Color(0xFF065F46)

  Dialog(
    onDismissRequest = {},
    properties = DialogProperties(
      dismissOnBackPress = false,
      dismissOnClickOutside = false,
      usePlatformDefaultWidth = false,
      securePolicy = AppSecurityManager.getSecureFlagPolicy()
    )
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth(0.90f)
        .padding(12.dp),
      contentAlignment = Alignment.Center
    ) {
      Card(
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        border = BorderStroke(1.8.dp, borderColor),
        modifier = Modifier
          .fillMaxWidth()
          .testTag("cloud_internet_wait_dialog")
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Box(
            modifier = Modifier
              .size(72.dp)
              .clip(CircleShape)
              .background(bgColor),
            contentAlignment = Alignment.Center
          ) {
            CircularProgressIndicator(
              color = accentColor,
              strokeWidth = 4.5.dp,
              modifier = Modifier
                .size(64.dp)
                .testTag("cloud_wait_spinner")
            )
            Icon(
              imageVector = if (isWaitingForInternet) Icons.Default.WifiOff else Icons.Default.CloudUpload,
              contentDescription = if (isWaitingForInternet) "Waiting for Internet" else "Syncing to Cloud",
              tint = accentColor,
              modifier = Modifier.size(28.dp)
            )
          }

          Spacer(modifier = Modifier.height(14.dp))

          Text(
            text = if (isWaitingForInternet) "📡 අන්තර්ජාල සබඳතාව අවශ්‍යයි" else title,
            fontSize = 15.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF0F172A),
            textAlign = TextAlign.Center
          )

          Spacer(modifier = Modifier.height(8.dp))

          Surface(
            shape = RoundedCornerShape(12.dp),
            color = bgColor,
            border = BorderStroke(1.dp, borderColor.copy(alpha = 0.6f)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.Center
            ) {
              Text(
                text = statusMessage,
                fontSize = 11.5.sp,
                fontWeight = FontWeight.SemiBold,
                color = textColor,
                textAlign = TextAlign.Center,
                lineHeight = 17.sp
              )
            }
          }

          if (isWaitingForInternet) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "Data / Wi-Fi සක්‍රීය කර නියමිත මට්ටමේ සිග්නල් ලැබෙන තෙක් ඇප් එක වසා නොදමා රැඳී සිටින්න.",
              fontSize = 10.5.sp,
              color = Color(0xFF64748B),
              textAlign = TextAlign.Center,
              lineHeight = 15.sp
            )
          }

          if (onCancel != null) {
            Spacer(modifier = Modifier.height(14.dp))
            OutlinedButton(
              onClick = onCancel,
              shape = RoundedCornerShape(10.dp),
              border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
              modifier = Modifier
                .fillMaxWidth()
                .height(42.dp)
                .testTag("cloud_wait_cancel_button")
            ) {
              Spacer(modifier = Modifier.width(4.dp))
              Text(
                text = "නවත්වන්න (Cancel)",
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF475569)
              )
            }
          }
        }
      }
    }
  }
}
