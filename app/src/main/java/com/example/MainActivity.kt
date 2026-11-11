package com.example

import android.app.Activity
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.view.WindowManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import android.util.Log
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import com.google.firebase.Firebase
import androidx.compose.ui.viewinterop.AndroidView
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.OndemandVideo
import androidx.compose.material.icons.filled.PictureAsPdf
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.PlayCircleFilled
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Pending
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.UploadFile
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.ui.draw.alpha
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.HowToReg
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.IconButton
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialCancellationException
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential.Companion.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.json.JSONArray
import org.json.JSONObject
import coil.compose.AsyncImage
import com.example.ui.theme.BlueOnPrimaryContainer
import com.example.ui.theme.BluePrimary
import com.example.ui.theme.BluePrimaryContainer
import com.example.ui.theme.*
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.NeutralBorder
import com.example.ui.theme.NeutralBorderLight
import com.example.ui.theme.NeutralDark
import com.example.ui.theme.NeutralMedium
import com.example.ui.theme.SurfaceVariantLight

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class UserAccount(
  val id: String = "",
  val fullName: String = "",
  val usernameOrPhone: String = "",
  val password: String = "",
  var isApproved: Boolean = false,
  val registerDate: String = "2026-08-11",
  var slipImageUri: String? = null,
  var paymentStatus: String = "Pending Approval",
  var requestedGradePackage: String = "10 සහ 11 ශ්‍රේණි (O/L Combo Pack)",
  var approvedGrades: List<String> = listOf("10", "11", "10 ශ්‍රේණිය", "11 ශ්‍රේණිය"),
  var boundDeviceId: String? = null,
  var boundDeviceName: String? = null,
  var boundDate: String? = null,
  var approvalTimestamp: Long? = null,
  var requestDate: String? = null,
  var requestTimestamp: Long? = null
)

// Subscription Validity: 6 Months (දින 180 / රු. 1,000)
const val APPROVAL_VALIDITY_DAYS = 180L
const val APPROVAL_VALIDITY_MILLIS = APPROVAL_VALIDITY_DAYS * 24L * 60L * 60L * 1000L

fun UserAccount.isApprovalExpired(): Boolean {
  if (!isApproved) return false
  if (isAuthorizedAdminUser(usernameOrPhone)) return false
  val approvedTime = approvalTimestamp ?: return false // If approved but no timestamp, it's not yet validly timed
  return (System.currentTimeMillis() - approvedTime) >= APPROVAL_VALIDITY_MILLIS
}

fun UserAccount.getRemainingApprovalDays(): Int {
  if (!isApproved) return 0
  if (isAuthorizedAdminUser(usernameOrPhone)) return 180
  val approvedTime = approvalTimestamp ?: return 0
  val elapsed = System.currentTimeMillis() - approvedTime
  val remaining = APPROVAL_VALIDITY_MILLIS - elapsed
  return (remaining / (24L * 60L * 60L * 1000L)).toInt().coerceAtLeast(0)
}

fun UserAccount.getRequestDateFormatted(): String {
  if (!requestDate.isNullOrBlank()) return requestDate!!
  val reqTime = requestTimestamp
  if (reqTime != null && reqTime > 0L) {
    return SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(Date(reqTime))
  }
  return registerDate
}

fun UserAccount.getApprovedDateFormatted(): String {
  val appTime = approvalTimestamp ?: return "-"
  return SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(Date(appTime))
}

fun UserAccount.getExpiryDateFormatted(): String {
  val appTime = approvalTimestamp ?: return "-"
  val expiryMillis = appTime + APPROVAL_VALIDITY_MILLIS
  return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date(expiryMillis))
}

fun UserAccount.toJsonString(): String {
  val json = JSONObject()
  json.put("id", id)
  json.put("fullName", fullName)
  json.put("usernameOrPhone", usernameOrPhone)
  json.put("password", password)
  json.put("isApproved", isApproved)
  json.put("registerDate", registerDate)
  json.put("slipImageUri", slipImageUri ?: "")
  json.put("paymentStatus", paymentStatus)
  json.put("requestedGradePackage", requestedGradePackage)
  json.put("approvedGrades", JSONArray(approvedGrades))
  json.put("boundDeviceId", boundDeviceId ?: "")
  json.put("boundDeviceName", boundDeviceName ?: "")
  json.put("boundDate", boundDate ?: "")
  json.put("approvalTimestamp", approvalTimestamp ?: 0L)
  json.put("requestDate", requestDate ?: "")
  json.put("requestTimestamp", requestTimestamp ?: 0L)
  return json.toString()
}

fun userAccountFromJsonString(jsonStr: String): UserAccount? {
  return try {
    val json = JSONObject(jsonStr)
    val gradesArray = json.optJSONArray("approvedGrades")
    val gradesList = mutableListOf<String>()
    if (gradesArray != null) {
      for (i in 0 until gradesArray.length()) {
        gradesList.add(gradesArray.getString(i))
      }
    }
    if (gradesList.isEmpty()) {
      gradesList.addAll(listOf("06", "07", "08", "09", "10", "11", "6 ශ්‍රේණිය", "7 ශ්‍රේණිය", "8 ශ්‍රේණිය", "9 ශ්‍රේණිය", "10 ශ්‍රේණිය", "11 ශ්‍රේණිය"))
    }
    val appTimestamp = json.optLong("approvalTimestamp", 0L).takeIf { it > 0L }
    val reqDate = json.optString("requestDate").takeIf { it.isNotBlank() }
    val reqTimestamp = json.optLong("requestTimestamp", 0L).takeIf { it > 0L }
    UserAccount(
      id = json.optString("id", System.currentTimeMillis().toString()),
      fullName = json.optString("fullName", "ශිෂ්‍යයා"),
      usernameOrPhone = json.optString("usernameOrPhone", ""),
      password = json.optString("password", "1234"),
      isApproved = json.optBoolean("isApproved", false),
      registerDate = json.optString("registerDate", "2026-08-20"),
      slipImageUri = json.optString("slipImageUri").takeIf { it.isNotBlank() },
      paymentStatus = json.optString("paymentStatus", "Approved"),
      requestedGradePackage = json.optString("requestedGradePackage", "06 සිට 11 දක්වා සියලුම ශ්‍රේණි (All Grades Mega Pack)"),
      approvedGrades = gradesList,
      boundDeviceId = json.optString("boundDeviceId").takeIf { it.isNotBlank() },
      boundDeviceName = json.optString("boundDeviceName").takeIf { it.isNotBlank() },
      boundDate = json.optString("boundDate").takeIf { it.isNotBlank() },
      approvalTimestamp = appTimestamp,
      requestDate = reqDate,
      requestTimestamp = reqTimestamp
    )
  } catch (e: Exception) {
    null
  }
}

fun saveUsersToPreferences(context: Context, users: List<UserAccount>) {
  try {
    val prefs = context.getSharedPreferences("app_user_auth_store", Context.MODE_PRIVATE)
    val jsonArray = JSONArray()
    for (user in users) {
      jsonArray.put(JSONObject(user.toJsonString()))
    }
    prefs.edit().putString("saved_users_json", jsonArray.toString()).apply()
  } catch (e: Exception) {
    e.printStackTrace()
  }
}

fun loadUsersFromPreferences(context: Context): List<UserAccount> {
  val result = mutableListOf<UserAccount>()
  try {
    val prefs = context.getSharedPreferences("app_user_auth_store", Context.MODE_PRIVATE)
    val savedStr = prefs.getString("saved_users_json", null)
    if (!savedStr.isNullOrBlank()) {
      val jsonArray = JSONArray(savedStr)
      for (i in 0 until jsonArray.length()) {
        val userObj = jsonArray.getJSONObject(i)
        userAccountFromJsonString(userObj.toString())?.let { result.add(it) }
      }
    }
  } catch (e: Exception) {
    e.printStackTrace()
  }
  return result
}

fun saveLoggedInUserPhone(context: Context, phone: String?) {
  val prefs = context.getSharedPreferences("app_user_auth_store", Context.MODE_PRIVATE)
  prefs.edit().putString("last_logged_in_phone", phone ?: "").apply()
}

fun getSavedLoggedInUserPhone(context: Context): String? {
  val prefs = context.getSharedPreferences("app_user_auth_store", Context.MODE_PRIVATE)
  val phone = prefs.getString("last_logged_in_phone", null)
  return if (phone.isNullOrBlank()) null else phone
}

fun getDeviceIdentifier(context: Context): Pair<String, String> {
  val deviceId = PersistentTrialSecurityManager.getHardwareDeviceId(context)
  val manufacturer = Build.MANUFACTURER?.replaceFirstChar { it.uppercase() } ?: "Android"
  val model = Build.MODEL ?: "Phone"
  val deviceName = "$manufacturer $model"
  return Pair(deviceId, deviceName)
}

fun getApprovedGradesForPackage(pkg: String): List<String> {
  return when {
    pkg.contains("10 සහ 11") || pkg.contains("O/L") -> listOf("10", "11", "10 ශ්‍රේණිය", "11 ශ්‍රේණිය")
    pkg.contains("06") || pkg.contains("6") -> listOf("06", "6", "6 ශ්‍රේණිය")
    pkg.contains("07") || pkg.contains("7") -> listOf("07", "7", "7 ශ්‍රේණිය")
    pkg.contains("08") || pkg.contains("8") -> listOf("08", "8", "8 ශ්‍රේණිය")
    pkg.contains("09") || pkg.contains("9") -> listOf("09", "9", "9 ශ්‍රේණිය")
    pkg.contains("සියලු") || pkg.contains("All") -> listOf("06", "07", "08", "09", "10", "11", "6 ශ්‍රේණිය", "7 ශ්‍රේණිය", "8 ශ්‍රේණිය", "9 ශ්‍රේණිය", "10 ශ්‍රේණිය", "11 ශ්‍රේණිය")
    else -> listOf("10", "11", "10 ශ්‍රේණිය", "11 ශ්‍රේණිය")
  }
}

fun isUserApprovedForGrade(user: UserAccount?, grade: String, isAdmin: Boolean): Boolean {
  if (isAdmin) return true
  if (user == null || !user.isApproved) return false
  if (user.approvedGrades.isEmpty() || user.requestedGradePackage.contains("සියලු") || user.requestedGradePackage.contains("All")) {
    return true
  }
  val cleanGrade = grade.replace("ශ්‍රේණිය", "").replace("Grade", "").replace("වසර", "").trim()
  val paddedGrade = if (cleanGrade.length == 1) "0$cleanGrade" else cleanGrade
  val singleDigit = if (cleanGrade.startsWith("0")) cleanGrade.substring(1) else cleanGrade

  return user.approvedGrades.any { approved ->
    val cleanApproved = approved.replace("ශ්‍රේණිය", "").replace("Grade", "").replace("වසර", "").trim()
    cleanApproved == cleanGrade || cleanApproved == paddedGrade || cleanApproved == singleDigit || approved.contains(cleanGrade)
  }
}

fun isAuthorizedAdminUser(phoneOrEmail: String?): Boolean {
  if (phoneOrEmail.isNullOrBlank()) return false
  val clean = phoneOrEmail.trim().lowercase().replace(" ", "").replace("-", "")
  return clean == "0772843861" || clean == "0717136085" || clean == "prabathakila450@gmail.com" ||
         clean == "+94772843861" || clean == "+94717136085" || clean == "94772843861" || clean == "94717136085"
}

fun isValidAdminStep2Credentials(username: String?, nic: String?, pass: String?): Boolean {
  if (username.isNullOrBlank() || pass.isNullOrBlank() || nic.isNullOrBlank()) return false
  val cleanUser = username.trim().lowercase().replace(" ", "").replace(".", "")
  val cleanNic = nic.trim().uppercase().replace(" ", "").replace("-", "")
  val cleanPass = pass.trim()
  val isUserValid = cleanUser == "akilaprabhathdisanayaka" ||
                    cleanUser == "akilaprabhathdissanayaka" ||
                    cleanUser == "akilaprabhathdissanayake" ||
                    cleanUser == "akilaprabhath" ||
                    cleanUser == "අකිලප්‍රභාත්දිසානායක" ||
                    cleanUser == "අකිලප්‍රභාත්"
  val isNicValid = cleanNic == "200214203683"
  val isPassValid = cleanPass == "A20020521PD"
  return isUserValid && isNicValid && isPassValid
}

fun saveAdminMasterPassword(context: Context, pass: String) {
  val prefs = context.getSharedPreferences("app_user_auth_store", Context.MODE_PRIVATE)
  prefs.edit().putString("admin_master_password", pass).apply()
}

fun getAdminMasterPassword(context: Context): String {
  val prefs = context.getSharedPreferences("app_user_auth_store", Context.MODE_PRIVATE)
  return prefs.getString("admin_master_password", null) ?: "A20020521PD"
}

fun setAdminSessionActive(context: Context, active: Boolean) {
  val prefs = context.getSharedPreferences("app_user_auth_store", Context.MODE_PRIVATE)
  prefs.edit().putBoolean("is_admin_session_active", active).apply()
}

fun isAdminSessionActive(context: Context): Boolean {
  val prefs = context.getSharedPreferences("app_user_auth_store", Context.MODE_PRIVATE)
  return prefs.getBoolean("is_admin_session_active", false)
}

fun saveGitHubShareUrl(context: Context, url: String) {
  val prefs = context.getSharedPreferences("app_user_auth_store", Context.MODE_PRIVATE)
  prefs.edit().putString("github_apk_share_url", url).apply()
}

fun getSavedGitHubShareUrl(context: Context): String {
  val prefs = context.getSharedPreferences("app_user_auth_store", Context.MODE_PRIVATE)
  return prefs.getString("github_apk_share_url", null)
    ?: "https://github.com/prabathakila450-cell/O-L-Guru/releases/download/latest/app-debug.apk"
}

data class SubjectItem(
  val id: String,
  val name: String,
  val nameSinhala: String,
  val chaptersCount: Int,
  val color: Color,
  val icon: androidx.compose.ui.graphics.vector.ImageVector
)

data class ShortNoteItem(
  val id: String,
  val subject: String,
  val title: String,
  val topicSinhala: String,
  val readTime: String,
  val isPopular: Boolean = false,
  val pdfUri: String? = null,
  val fileName: String? = null,
  val isPasswordProtected: Boolean = false,
  val password: String? = "1234"
)

data class QuestionPaperItem(
  val id: String,
  val subject: String,
  val titleSinhala: String,
  val year: String,
  val term: String,
  val marks: String,
  val pdfUri: String? = null,
  val fileName: String? = null,
  val isPasswordProtected: Boolean = false,
  val password: String? = "1234"
)

data class VideoLessonItem(
  val id: String,
  val subject: String,
  val titleSinhala: String,
  val duration: String,
  val tutorName: String,
  val viewsCount: String,
  val isHd: Boolean = true,
  val videoUri: String? = null
)

fun getFileNameFromUri(context: Context, uri: Uri): String {
  var fileName = "Document.pdf"
  try {
    if (uri.scheme == "content") {
      context.contentResolver.query(uri, null, null, null, null)?.use { cursor ->
        val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        if (nameIndex != -1 && cursor.moveToFirst()) {
          fileName = cursor.getString(nameIndex)
        }
      }
    } else if (uri.scheme == "file") {
      fileName = uri.lastPathSegment ?: "Document.pdf"
    }
  } catch (e: Exception) {
    e.printStackTrace()
  }
  return fileName
}

fun openPdfFile(context: Context, pdfUriString: String?) {
  if (pdfUriString.isNullOrBlank()) {
    Toast.makeText(context, "පීඩීඑෆ් (PDF) ගොනුවක් අමුණා නොමැත", Toast.LENGTH_SHORT).show()
    return
  }
  try {
    val uri = Uri.parse(pdfUriString)
    val intent = Intent(Intent.ACTION_VIEW).apply {
      setDataAndType(uri, "application/pdf")
      addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
      addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    context.startActivity(Intent.createChooser(intent, "PDF ගොනුව විවෘත කරන්න"))
  } catch (e: Exception) {
    Toast.makeText(context, "PDF ගොනුව විවෘත කිරීමට PDF Viewer යෙදුමක් සොයාගත නොහැකි විය: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
  }
}

fun onGoogleSignInClicked(
  context: Context,
  credentialManager: CredentialManager,
  onAuthSuccess: () -> Unit,
  onAuthError: (String) -> Unit,
  scope: kotlinx.coroutines.CoroutineScope,
  onAuthCancelled: () -> Unit = {}
) {
  val clientId = try {
    context.getString(R.string.default_web_client_id)
  } catch (e: Exception) {
    onAuthError("Google Sign-In configuration missing: default_web_client_id not found")
    return
  }

  val signInOption = GetSignInWithGoogleOption.Builder(serverClientId = clientId).build()
  val request = GetCredentialRequest.Builder().addCredentialOption(signInOption).build()

  scope.launch {
    try {
      val result = credentialManager.getCredential(context as Activity, request)
      val credential = result.credential
      if (credential is CustomCredential && credential.type == TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
        val googleIdToken = GoogleIdTokenCredential.createFrom(credential.data).idToken
        val authCredential = GoogleAuthProvider.getCredential(googleIdToken, null)
        com.google.firebase.Firebase.auth.signInWithCredential(authCredential).await()
        onAuthSuccess()
      } else {
        onAuthError("Unexpected credential type")
      }
    } catch (e: GetCredentialCancellationException) {
      Log.w("Auth", "Google Sign-In flow cancelled or dismissed: ${e.message}", e)
      onAuthCancelled()
    } catch (e: Exception) {
      Log.e("Auth", "Google Sign-In failed", e)
      onAuthError(e.localizedMessage ?: "Sign in failed")
    }
  }
}

class MainActivity : ComponentActivity() {
  private var clipboardListener: ClipboardManager.OnPrimaryClipChangedListener? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    // Pre-create Chromium WebView code cache directories with full read/write/traversal permissions
    StudentPortalApplication.initWebViewCacheDirectories(cacheDir)

    window.setBackgroundDrawable(android.graphics.drawable.ColorDrawable(android.graphics.Color.parseColor("#F8FAFC")))
    AppSecurityManager.applyScreenProtection(this, !AppSecurityManager.isAdminSession)

    // Register active clipboard purge listener: completely block and wipe copying for non-admin users
    try {
      val cm = getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager
      clipboardListener = ClipboardManager.OnPrimaryClipChangedListener {
        if (!AppSecurityManager.isAdminSession) {
          try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
              cm?.clearPrimaryClip()
            } else {
              cm?.setPrimaryClip(ClipData.newPlainText("", ""))
            }
            Toast.makeText(this, "ආරක්ෂක නීති අනුව අන්තර්ගතයන් පිටපත් කිරීම (Copy) අවහිර කර ඇත.", Toast.LENGTH_SHORT).show()
          } catch (_: Exception) {}
        }
      }
      cm?.addPrimaryClipChangedListener(clipboardListener)
    } catch (_: Exception) {}

    enableEdgeToEdge(
      statusBarStyle = androidx.activity.SystemBarStyle.light(
        android.graphics.Color.TRANSPARENT,
        android.graphics.Color.TRANSPARENT
      ),
      navigationBarStyle = androidx.activity.SystemBarStyle.light(
        android.graphics.Color.TRANSPARENT,
        android.graphics.Color.TRANSPARENT
      )
    )
    // Initialize Google AdMob & Start 30-Minute Automatic Full-Screen Interstitial Timer
    AdMobManager.initialize(this)
    AdMobManager.startInterstitialTimer(this)

    setContent {
      MyApplicationTheme(eyeCareMode = EyeCareThemeMode.LIGHT) {
        StudentPortalApp()
      }
    }
  }

  override fun onResume() {
    super.onResume()
    AdMobManager.updateActivity(this)
    AppSecurityManager.enforceSecurityForUser(this, AppSecurityManager.isAdminSession)
  }

  override fun onDestroy() {
    super.onDestroy()
    try {
      val cm = getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager
      clipboardListener?.let { cm?.removePrimaryClipChangedListener(it) }
    } catch (_: Exception) {}
  }
}

@Composable
fun ConditionalDisableSelection(disabled: Boolean, content: @Composable () -> Unit) {
  if (disabled) {
    DisableSelection {
      content()
    }
  } else {
    content()
  }
}

@Composable
fun StudentPortalApp() {
  val context = LocalContext.current

  // Eye-Care & Night Study Mode State with Local Persistence (Default to clean, bright Light mode)
  var activeEyeCareMode by remember { mutableStateOf(EyeCareThemeMode.LIGHT) }
  var activeFontScale by remember { mutableStateOf(loadSavedFontScale(context)) }
  var activeLineSpacing by remember { mutableStateOf(loadSavedLineSpacing(context)) }
  var isEyeBreakReminderEnabled by remember { mutableStateOf(loadSavedEyeBreakEnabled(context)) }
  var showEyeCareSettingsSheet by remember { mutableStateOf(false) }

  // User Authentication & Admin Approval State with Local Persistence
  val registeredUsers = remember {
    val saved = loadUsersFromPreferences(context)
    val list = mutableStateListOf<UserAccount>()
    val defaultAdminUsers = listOf(
      UserAccount("1", "අකිල ප්‍රභාත් දිසානායක (Admin)", "0772843861", "A20020521PD", isApproved = true, paymentStatus = "Approved", requestedGradePackage = "06 සිට 11 දක්වා සියලුම ශ්‍රේණි (All Grades Mega Pack)", approvedGrades = listOf("06", "07", "08", "09", "10", "11", "6 ශ්‍රේණිය", "7 ශ්‍රේණිය", "8 ශ්‍රේණිය", "9 ශ්‍රේණිය", "10 ශ්‍රේණිය", "11 ශ්‍රේණිය")),
      UserAccount("2", "අකිල ප්‍රභාත් දිසානායක (Admin)", "0717136085", "A20020521PD", isApproved = true, paymentStatus = "Approved", requestedGradePackage = "06 සිට 11 දක්වා සියලුම ශ්‍රේණි (All Grades Mega Pack)", approvedGrades = listOf("06", "07", "08", "09", "10", "11", "6 ශ්‍රේණිය", "7 ශ්‍රේණිය", "8 ශ්‍රේණිය", "9 ශ්‍රේණිය", "10 ශ්‍රේණිය", "11 ශ්‍රේණිය")),
      UserAccount("3", "අකිල ප්‍රභාත් දිසානායක (Admin)", "prabathakila450@gmail.com", "A20020521PD", isApproved = true, paymentStatus = "Approved", requestedGradePackage = "06 සිට 11 දක්වා සියලුම ශ්‍රේණි (All Grades Mega Pack)", approvedGrades = listOf("06", "07", "08", "09", "10", "11", "6 ශ්‍රේණිය", "7 ශ්‍රේණිය", "8 ශ්‍රේණිය", "9 ශ්‍රේණිය", "10 ශ්‍රේණිය", "11 ශ්‍රේණිය"))
    )

    // Permanently filter out and prune any mock/fake demo accounts previously saved in local storage
    val genuineSaved = saved.filter { user ->
      val phone = user.usernameOrPhone.trim().lowercase()
      val name = user.fullName.trim()
      val isFakeDemo = phone in listOf("0719876543", "0755554433", "0781122334", "0770000000") ||
                       name.contains("කසුන් පෙරේරා") || name.contains("නිරෝෂා කුමාරි") ||
                       name.contains("දිනුක මධුෂාන්") || name.contains("අනුමත ශිෂ්‍ය") ||
                       user.id in listOf("4", "5", "6")
      !isFakeDemo
    }

    val merged = genuineSaved.toMutableList()
    // Permanently preserve all previous approvals and payment statuses once granted by the admin.
    // The previous loop that reset isApproved to false on every launch has been removed to ensure persistent access.

    // Guarantee that all admin accounts exist with full approved privileges
    for (admin in defaultAdminUsers) {
      val existingIndex = merged.indexOfFirst { it.usernameOrPhone.trim().equals(admin.usernameOrPhone.trim(), ignoreCase = true) }
      if (existingIndex >= 0) {
        val old = merged[existingIndex]
        merged[existingIndex] = old.copy(
          fullName = admin.fullName,
          isApproved = true,
          paymentStatus = "Approved",
          requestedGradePackage = "06 සිට 11 දක්වා සියලුම ශ්‍රේණි (All Grades Mega Pack)",
          approvedGrades = listOf("06", "07", "08", "09", "10", "11", "6 ශ්‍රේණිය", "7 ශ්‍රේණිය", "8 ශ්‍රේණිය", "9 ශ්‍රේණිය", "10 ශ්‍රේණිය", "11 ශ්‍රේණිය")
        )
      } else {
        merged.add(admin)
      }
    }
    saveUsersToPreferences(context, merged)
    list.addAll(merged)
    list
  }

  var loggedInUser by remember { mutableStateOf<UserAccount?>(null) }
  var isAdminAuthenticated by remember { mutableStateOf(false) }
  var isAdminBarUnlocked by remember { mutableStateOf(false) }
  var showAdminBarUnlockDialog by remember { mutableStateOf(false) }
  var showExpiredStudentsDialog by remember { mutableStateOf(false) }

  // Cloud Sync: Observe users from Firestore and merge with local state
  val coroutineScope = androidx.compose.runtime.rememberCoroutineScope()
  LaunchedEffect(Unit) {
    CloudAuthManager.observeAllUsers(context).collect { cloudUsers ->
      cloudUsers.forEach { cloudUser ->
        val existingIndex = registeredUsers.indexOfFirst { 
          it.usernameOrPhone.trim().equals(cloudUser.usernameOrPhone.trim(), ignoreCase = true) 
        }
        if (existingIndex >= 0) {
          // Cloud data takes precedence for approval status
          val local = registeredUsers[existingIndex]
          if (local.isApproved != cloudUser.isApproved || local.approvalTimestamp != cloudUser.approvalTimestamp) {
            registeredUsers[existingIndex] = local.copy(
              isApproved = cloudUser.isApproved,
              approvalTimestamp = cloudUser.approvalTimestamp,
              paymentStatus = cloudUser.paymentStatus
            )
          }
        } else {
          // Add new user from cloud
          registeredUsers.add(cloudUser)
        }
      }
      saveUsersToPreferences(context, registeredUsers.toList())
    }
  }

  // Periodic Sync for logged-in user to ensure they are on cloud
  LaunchedEffect(loggedInUser) {
    loggedInUser?.let { user ->
      coroutineScope.launch {
        CloudAuthManager.syncUserToCloud(context, user)
      }
    }
  }

  // Sync Security Policies dynamically with authentication role
  LaunchedEffect(isAdminAuthenticated) {
    AppSecurityManager.isAdminSession = isAdminAuthenticated
    if (!isAdminAuthenticated) {
      isAdminBarUnlocked = false
      showAdminBarUnlockDialog = false
    }
    (context as? Activity)?.let { act ->
      AppSecurityManager.enforceSecurityForUser(act, isAdminAuthenticated)
    }
  }

  LaunchedEffect(loggedInUser) {
    val isAdmin = loggedInUser?.let { isAuthorizedAdminUser(it.usernameOrPhone) } ?: false
    isAdminAuthenticated = isAdmin
    if (!isAdmin) {
      isAdminBarUnlocked = false
      showAdminBarUnlockDialog = false
    }
    setAdminSessionActive(context, isAdmin)
    AppSecurityManager.isAdminSession = isAdmin
    (context as? Activity)?.let { act ->
      AppSecurityManager.enforceSecurityForUser(act, isAdmin)
    }
  }
  


  var showAuthRequiredDialog by remember { mutableStateOf(false) }
  var authDialogInitialTab by remember { mutableStateOf(0) }
  var showPaymentApprovalDialog by remember { mutableStateOf(false) }
  var previewReceiptImageUrl by remember { mutableStateOf<String?>(null) }
  var showGradeNotApprovedDialog by remember { mutableStateOf(false) }
  var gradeNotApprovedTarget by remember { mutableStateOf("11") }
  var preselectedGradeForApproval by remember { mutableStateOf("10 සහ 11 ශ්‍රේණි (O/L Combo Pack)") }
  var showAdminDashboardMasterDialog by remember { mutableStateOf(false) }
  var adminDashboardInitialFilter by remember { mutableStateOf("ALL") }
  var showSanduTheoryFullReaderGlobal by remember { mutableStateOf(false) }
  var sanduTheoryGlobalInitialPage by remember { mutableStateOf(1) }
  var showSinhalaVicharaDharaReaderGlobal by remember { mutableStateOf(false) }
  var sinhalaVicharaGlobalInitialPage by remember { mutableStateOf(1) }
  var showScienceDiagramsReaderGlobal by remember { mutableStateOf(false) }
  var scienceDiagramsGlobalInitialPage by remember { mutableStateOf(1) }

  // Automatic Device & Phone Verification on Launch (Zero-Friction Direct Auto-Login for Approved Users)
  LaunchedEffect(Unit) {
    val (currDevId, currDevName) = getDeviceIdentifier(context)
    val savedPhone = getSavedLoggedInUserPhone(context)

    var matchingUser: UserAccount? = null

    // 1. Check by saved logged in phone number
    if (!savedPhone.isNullOrBlank()) {
      val candidate = registeredUsers.find { 
        it.usernameOrPhone.trim().equals(savedPhone.trim(), ignoreCase = true)
      }
      // Strict multi-device defense: If account is locked to a different phone hardware, do not auto-login
      if (candidate != null && !isAuthorizedAdminUser(candidate.usernameOrPhone) && candidate.boundDeviceId != null && candidate.boundDeviceId != currDevId) {
        saveLoggedInUserPhone(context, null)
        matchingUser = null
      } else {
        matchingUser = candidate
      }
    }

    // 2. Check by bound device identifier (Students only)
    if (matchingUser == null) {
      matchingUser = registeredUsers.find { 
        it.isApproved && !isAuthorizedAdminUser(it.usernameOrPhone) && it.boundDeviceId == currDevId
      }
    }

    // Check if matching student is expired (6 months completed)
    var isExpiredStudentDetected = false
    if (matchingUser != null && matchingUser.isApprovalExpired() && !isAuthorizedAdminUser(matchingUser.usernameOrPhone)) {
      saveLoggedInUserPhone(context, null)
      matchingUser = null
      isExpiredStudentDetected = true
    }

    // Admin authentication verification: ONLY restore if explicitly saved as authorized admin with active session
    val isExplicitSavedAdmin = !savedPhone.isNullOrBlank() && isAuthorizedAdminUser(savedPhone) && isAdminSessionActive(context)
    if (!isExpiredStudentDetected && matchingUser == null && isExplicitSavedAdmin) {
      setAdminSessionActive(context, true)
      matchingUser = registeredUsers.find { isAuthorizedAdminUser(it.usernameOrPhone) }
        ?: UserAccount(
          id = "3",
          fullName = "අකිල ප්‍රභාත් දිසානායක (Admin)",
          usernameOrPhone = savedPhone!!,
          password = "A20020521PD",
          isApproved = true,
          paymentStatus = "Approved",
          requestedGradePackage = "06 සිට 11 දක්වා සියලුම ශ්‍රේණි (All Grades Mega Pack)",
          approvedGrades = listOf("06", "07", "08", "09", "10", "11", "6 ශ්‍රේණිය", "7 ශ්‍රේණිය", "8 ශ්‍රේණිය", "9 ශ්‍රේණිය", "10 ශ්‍රේණිය", "11 ශ්‍රේණිය"),
          boundDeviceId = currDevId,
          boundDeviceName = currDevName
        )
    }

    if (isExpiredStudentDetected) {
      Toast.makeText(
        context,
        "⚠️ ඔබගේ මාස 6ක (දින 180) කාලසීමාව අවසන් වී ඇත! ස්වයංක්‍රීයව ලොග් විය නොහැක. කරුණාකර රු. 1000 ගෙවා නැවත අලුත් කරගන්න.",
        Toast.LENGTH_LONG
      ).show()
    }

    // 3. Auto-login verified approved user seamlessly without blocking
    if (matchingUser != null) {
      val isThisAdmin = isAuthorizedAdminUser(matchingUser.usernameOrPhone)
      val verifiedUser = matchingUser.copy(
        boundDeviceId = matchingUser.boundDeviceId ?: currDevId,
        boundDeviceName = matchingUser.boundDeviceName ?: currDevName,
        boundDate = matchingUser.boundDate ?: "2026-08-20",
        isApproved = if (isThisAdmin) true else (matchingUser.isApproved && !matchingUser.isApprovalExpired())
      )
      val idx = registeredUsers.indexOf(matchingUser)
      if (idx >= 0) {
        registeredUsers[idx] = verifiedUser
      } else {
        registeredUsers.add(verifiedUser)
      }
      loggedInUser = verifiedUser
      isAdminAuthenticated = isThisAdmin
      saveLoggedInUserPhone(context, verifiedUser.usernameOrPhone)
      saveUsersToPreferences(context, registeredUsers.toList())
      val roleTag = if (isAdminAuthenticated) "👑 ඇඩ්මින් පාලනය" else "🎓 ශිෂ්‍ය ගිණුම"
      Toast.makeText(context, "✨ සාදරයෙන් පිළිගනිමු ${verifiedUser.fullName}! ($roleTag)", Toast.LENGTH_SHORT).show()
    }
  }

  // Navigation Screen State: "HOME" (Grades list), "SUBJECTS" (Subject list for selected grade), "CONTENT" (Tabs for selected subject)
  var showAppLaunchSplash by remember { mutableStateOf(true) }
  var currentScreen by remember { mutableStateOf("HOME") }
  var isHubFullScreen by remember { mutableStateOf(false) }
  var englishInitialSubTab by remember { mutableStateOf(0) }
  var selectedGrade by remember { mutableStateOf("11") } // Options: "11", "10", "09", "08", "07", "06"
  var selectedSubjectItem by remember { mutableStateOf<SubjectItem?>(null) }
  var selectedContentTab by remember { mutableStateOf(0) } // 0: කෙටි සටහන් (PDFs), 1: ප්‍රශ්න පත්‍ර (PDFs), 2: ස්වයං පුහුණු (Quizzes), 3: AI Assistant
  var selectedSectionIndex by remember { mutableStateOf(0) } // 0: සියල්ල, 1: විෂයන්, 2: කෙටි සටහන්, 3: ප්‍රශ්න පත්‍ර
  var selectedTabNav by remember { mutableStateOf(0) }
  var activeDetailTitle by remember { mutableStateOf<String?>(null) }
  var isVideoModal by remember { mutableStateOf(false) }
  var selectedItemPdfUri by remember { mutableStateOf<String?>(null) }
  var activeSpecialFeatureSection by remember { mutableStateOf<SpecialFeatureSection?>(null) }
  var grade10PortalInitialSource by remember { mutableStateOf(Grade10WebSource.GOVDOC) }
  var grade11PortalInitialSource by remember { mutableStateOf(Grade11WebSource.GOVDOC) }
  var grade11PortalInitialSubject by remember { mutableStateOf<String?>(null) }
  var grade11PortalInitialTerm by remember { mutableStateOf<Int?>(null) }
  var selectedQaHubTab by remember { mutableStateOf(QaHubTab.SHORT_ANSWER) }

  // Targeted Direct Action Navigation State (100% Relevance for Weak Topics)
  var initialTopicNotesFilter by remember { mutableStateOf("") }
  var initialFormulaCategory by remember { mutableStateOf("ALL") }
  var initialFormulaQuery by remember { mutableStateOf("") }
  var initialMistakeSubjectFilter by remember { mutableStateOf("ALL") }
  var initialMistakeTopicFilter by remember { mutableStateOf("") }
  var activeInitialCategory by remember { mutableStateOf<Int?>(null) }

  // App Security, Anti-Hacking & DRM Shield State
  var showSecurityPanelDialog by remember { mutableStateOf(false) }

  // Admin Broadcast Announcements & Notification Center State
  val adminBroadcastMessages = remember {
    mutableStateListOf<AdminBroadcastMessage>().apply {
      addAll(AdminBroadcastManager.loadMessages(context))
    }
  }
  var showNotificationCenterDialog by remember { mutableStateOf(false) }
  var showAdminBroadcastComposerDialog by remember { mutableStateOf(false) }
  val unreadNotificationsCount = adminBroadcastMessages.count { !it.isRead }
  val latestUnreadMessage = adminBroadcastMessages.firstOrNull { !it.isRead }

  val isApprovalExpiredForLoggedInUser = loggedInUser != null && loggedInUser?.isApproved == true && loggedInUser!!.isApprovalExpired() && !isAuthorizedAdminUser(loggedInUser!!.usernameOrPhone)
  val isApprovedUser = isAdminAuthenticated || (loggedInUser != null && loggedInUser?.isApproved == true && !isApprovalExpiredForLoggedInUser)

  // 24-Hour 100% Free Trial for all Features & Grades from Initial Install Timestamp
  // Robustly persistent across app uninstall & re-download
  var isTrialActiveState by remember { mutableStateOf(PersistentTrialSecurityManager.isTrialActive(context)) }
  var remainingTrialHours by remember { mutableStateOf(PersistentTrialSecurityManager.getRemainingHoursMinutes(context).first) }
  var remainingTrialMinutes by remember { mutableStateOf(PersistentTrialSecurityManager.getRemainingHoursMinutes(context).second) }

  // Active real-time timer ticker (ticks every 2 seconds for 100% accuracy)
  LaunchedEffect(Unit) {
    while (true) {
      kotlinx.coroutines.delay(2000L)
      isTrialActiveState = PersistentTrialSecurityManager.isTrialActive(context)
      val (h, m) = PersistentTrialSecurityManager.getRemainingHoursMinutes(context)
      remainingTrialHours = h
      remainingTrialMinutes = m
    }
  }

  val isFeatureTrialActive = isTrialActiveState

  // Real-time VPN & Proxy detection polling (100% blocks access when VPN is active)
  var isVpnDetected by remember { mutableStateOf(AppSecurityManager.isVpnConnected(context)) }
  var isTimeTamperedDetected by remember { mutableStateOf(AppSecurityManager.isTimeTampered(context)) }
  LaunchedEffect(Unit) {
    while (true) {
      isVpnDetected = AppSecurityManager.isVpnConnected(context)
      isTimeTamperedDetected = AppSecurityManager.isTimeTampered(context)
      kotlinx.coroutines.delay(2000L)
    }
  }

  fun requireFeatureAccess(onSuccess: () -> Unit) {
    if (isApprovedUser || isFeatureTrialActive) {
      onSuccess()
    } else {
      if (isApprovalExpiredForLoggedInUser) {
        Toast.makeText(
          context,
          "⚠️ ඔබගේ මාස 6ක (දින 180) ඇඩ්මින් අනුමැතිය අවසන් වී ඇත. කරුණාකර රු. 1,000 ගෙවා අනුමැතිය නැවත සක්‍රීය කරගන්න.",
          Toast.LENGTH_LONG
        ).show()
        authDialogInitialTab = 0
        showAuthRequiredDialog = true
      } else {
        Toast.makeText(
          context,
          "🔒 ඇප් එක ඉන්ස්ටෝල් කිරීමෙන් පසු පැය 24ක නොමිලේ කාලය අවසන් වී ඇත. විශේෂාංග පරිශීලනය කිරීමට කරුණාකර ඇඩ්මින් අනුමැතිය (Admin Approval) ලබාගන්න.",
          Toast.LENGTH_LONG
        ).show()
        authDialogInitialTab = 0
        showAuthRequiredDialog = true
      }
    }
  }

  // Password Protection & PDF iframe/modal viewer state
  var showPasswordDialog by remember { mutableStateOf(false) }
  var pendingProtectedPdfTitle by remember { mutableStateOf("") }
  var pendingProtectedPdfUrl by remember { mutableStateOf("") }
  var pendingProtectedPdfPassword by remember { mutableStateOf("1234") }
  var passwordInputText by remember { mutableStateOf("") }
  var showPasswordError by remember { mutableStateOf(false) }

  var showIframePdfModal by remember { mutableStateOf(false) }
  var iframeModalPdfTitle by remember { mutableStateOf("") }
  var iframeModalPdfUrl by remember { mutableStateOf("") }

  // DRM & Security Alert State (Anti-Copy, Anti-Download, Screenshot & Screen Record Alert without blacking screen)
  var showDrmWarningDialog by remember { mutableStateOf(false) }
  var drmWarningReason by remember { mutableStateOf("තිර ඡායාරූප (Screenshot) හෝ තිර පටිගත කිරීම් (Screen Recording)") }

  // AI Practice Quizzes & Flashcards System State
  var activeQuizSet by remember { mutableStateOf<QuizSet?>(null) }
  var showFlashcardsDialog by remember { mutableStateOf(false) }
  var showPdfQuizBottomSheet by remember { mutableStateOf(false) }

  // Automatic redirect back to initial HOME screen when the 12-hour free trial expires
  // Note: Admin approval dialog is NOT shown automatically; it only triggers when user clicks a protected feature
  LaunchedEffect(isFeatureTrialActive, isApprovedUser) {
    if (!isFeatureTrialActive && !isApprovedUser) {
      if (currentScreen != "HOME") {
        currentScreen = "HOME"
        selectedTabNav = 0
      }
      // Immediately dismiss any open protected readers, players or quizzes
      showIframePdfModal = false
      showPasswordDialog = false
      activeQuizSet = null
      showFlashcardsDialog = false
      showPdfQuizBottomSheet = false
    }
  }

  // Dynamically toggle Screen Capture Protection based on current screen
  // User explicitly requested to allow screenshots ONLY on the "HOME" screen (Main Dashboard)
  LaunchedEffect(
    currentScreen, isAdminAuthenticated, showAppLaunchSplash,
    showIframePdfModal, activeQuizSet, showSanduTheoryFullReaderGlobal, 
    showSinhalaVicharaDharaReaderGlobal, showAuthRequiredDialog, showPaymentApprovalDialog
  ) {
    (context as? Activity)?.let { act ->
      val isHomeScreen = currentScreen == "HOME" && !showAppLaunchSplash
      val isAnyRestrictedModalOpen = showIframePdfModal || activeQuizSet != null || 
                                     showSanduTheoryFullReaderGlobal || showSinhalaVicharaDharaReaderGlobal ||
                                     showAuthRequiredDialog || showPaymentApprovalDialog
                                     
      // Disable protection (allow screenshot) if user is Admin OR (on Home Screen AND no sensitive modal is open)
      val shouldDisableProtection = isAdminAuthenticated || (isHomeScreen && !isAnyRestrictedModalOpen)
      AppSecurityManager.applyScreenProtection(act, !shouldDisableProtection)
    }
  }

  fun performProtectedAction(action: () -> Unit) {
    if (isApprovedUser || isFeatureTrialActive) {
      action()
    } else {
      Toast.makeText(
        context,
        "🔒 පැය 24ක නොමිලේ අත්හදා බැලීමේ කාලය අවසන් වී ඇත. විශේෂාංග පරිශීලනයට ඇඩ්මින් අනුමැතිය (Admin Approval) ලබාගන්න.",
        Toast.LENGTH_LONG
      ).show()
      authDialogInitialTab = 1
      showAuthRequiredDialog = true
    }
  }

  fun openPdfAtPage(pdfUrl: String, title: String, page: Int) {
    performProtectedAction {
      iframeModalPdfTitle = "$title (පිටුව $page)"
      val targetUrl = if (pdfUrl.contains("#page=")) pdfUrl else "$pdfUrl#page=$page"
      iframeModalPdfUrl = targetUrl
      showIframePdfModal = true
    }
  }

  fun handlePdfAccess(
    title: String,
    pdfUri: String?,
    isPasswordProtected: Boolean = false,
    requiredPassword: String? = "1234",
    targetGrade: String = selectedGrade
  ) {
    // 1. 100% Free for first 24 hours from install, then strictly requires admin approval
    val hasAccess = isApprovedUser || isFeatureTrialActive
    if (!hasAccess) {
      preselectedGradeForApproval = when (targetGrade) {
        "10" -> "10 ශ්‍රේණිය (Grade 10 Single Pack)"
        "11" -> "11 ශ්‍රේණිය (Grade 11 Single Pack)"
        else -> "10 සහ 11 ශ්‍රේණි (O/L Combo Pack)"
      }
      Toast.makeText(
        context,
        "🔒 පැය 24ක නොමිලේ අත්හදා බැලීමේ කාලය අවසන් වී ඇත. PDF කියවීමට කරුණාකර ඇඩ්මින් අනුමැතිය (Admin Approval) ලබාගන්න.",
        Toast.LENGTH_LONG
      ).show()
      authDialogInitialTab = 1
      showAuthRequiredDialog = true
      return
    }

    // 2. Check if user is approved for this specific Grade (enforced after 24h free trial)
    if (!isFeatureTrialActive && !isUserApprovedForGrade(loggedInUser, targetGrade, isAdminAuthenticated)) {
      gradeNotApprovedTarget = targetGrade
      showGradeNotApprovedDialog = true
      return
    }

    // 3. If approved for this grade, open PDF directly in secure DRM in-app viewer
    if (!pdfUri.isNullOrBlank()) {
      if (pdfUri == "sandu_theory_100_pages_reader" || pdfUri.contains("sandu_theory") || title.contains("Sandu Theory") || title.contains("පිටු 100")) {
        sanduTheoryGlobalInitialPage = 1
        showSanduTheoryFullReaderGlobal = true
        return
      }
      if (pdfUri == "sinhala_vichara_dhara_30_pages_reader" || pdfUri.contains("sinhala_vichara") || title.contains("විචාර ධාරා") || (title.contains("සිංහල") && title.contains("විචාර 23"))) {
        sinhalaVicharaGlobalInitialPage = 1
        showSinhalaVicharaDharaReaderGlobal = true
        return
      }
      if (pdfUri == "science_diagrams_11_pages_reader" || pdfUri.contains("science_diagrams") || (title.contains("විද්‍යාව") && (title.contains("රූ සටහන්") || title.contains("සෛලීය ව්‍යුහ")))) {
        scienceDiagramsGlobalInitialPage = 1
        showScienceDiagramsReaderGlobal = true
        return
      }
      iframeModalPdfTitle = title
      iframeModalPdfUrl = pdfUri
      showIframePdfModal = true
    } else {
      Toast.makeText(context, "පීඩීඑෆ් (PDF) ගොනුවක් අමුණා නොමැත", Toast.LENGTH_SHORT).show()
    }
  }

  // PDF File Picker Launcher State
  var selectedPdfUri by remember { mutableStateOf<Uri?>(null) }
  var selectedPdfFileName by remember { mutableStateOf<String?>(null) }

  val pdfPickerLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.GetContent()
  ) { uri: Uri? ->
    if (uri != null) {
      selectedPdfUri = uri
      val name = getFileNameFromUri(context, uri)
      selectedPdfFileName = name
      Toast.makeText(context, "PDF ගොනුව අමුණන ලදී: $name", Toast.LENGTH_SHORT).show()
    }
  }

  // Live Cloud Repository State (Supports real-time dynamic addition/deletion without APK re-downloads)
  val liveSubjectsMap = remember {
    mutableStateMapOf<String, SnapshotStateList<SubjectItem>>().apply {
      listOf("06", "07", "08", "09", "10", "11").forEach { g ->
        put(g, mutableStateListOf<SubjectItem>().apply { addAll(getSubjectsForGrade(g)) })
      }
    }
  }

  val liveNotesMap = remember {
    mutableStateMapOf<String, SnapshotStateList<ShortNoteItem>>().apply {
      listOf("06", "07", "08", "09", "10", "11").forEach { g ->
        put(g, mutableStateListOf<ShortNoteItem>().apply { addAll(getNotesForGrade(g)) })
      }
    }
  }

  val livePapersMap = remember {
    mutableStateMapOf<String, SnapshotStateList<QuestionPaperItem>>().apply {
      listOf("06", "07", "08", "09", "10", "11").forEach { g ->
        put(g, mutableStateListOf<QuestionPaperItem>().apply { addAll(getPapersForGrade(g)) })
      }
    }
  }

  val liveVideosMap = remember {
    mutableStateMapOf<String, SnapshotStateList<VideoLessonItem>>().apply {
      listOf("06", "07", "08", "09", "10", "11").forEach { g ->
        put(g, mutableStateListOf<VideoLessonItem>().apply { addAll(getVideosForGrade(g)) })
      }
    }
  }

  // Content Draft Staging & Batch Release Engine (One-Click Release)
  val stagedContentItems = remember {
    mutableStateListOf<StagedContentItem>().apply {
      addAll(AdminStagingManager.loadStagedItems(context))
    }
  }
  var showStagingManagerDialog by remember { mutableStateOf(false) }

  // Load previously released items into live lists
  LaunchedEffect(Unit) {
    val previouslyReleased = AdminStagingManager.loadReleasedItems(context)
    previouslyReleased.forEach { item ->
      when (item.type) {
        "NOTE" -> {
          if (liveNotesMap[item.gradeTarget]?.none { it.id == item.id } == true) {
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
        }
        "PAPER" -> {
          if (livePapersMap[item.gradeTarget]?.none { it.id == item.id } == true) {
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
        }
        "VIDEO" -> {
          if (liveVideosMap[item.gradeTarget]?.none { it.id == item.id } == true) {
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
    }
  }

  // Feature 5 Bookmarks State
  val savedBookmarks = remember {
    mutableStateListOf(
      BookmarkItem(
        id = "bm_1",
        title = "10 සහ 11 ශ්‍රේණිය - තොරතුරු තාක්ෂණය කෙටි සටහන්",
        subject = "තොරතුරු තාක්ෂණය",
        grade = "11",
        type = "NOTE",
        pdfUri = "https://drive.google.com/file/d/1IQntv3Yh1Oaxh42-btqYaFNNA9uijfx_/preview"
      ),
      BookmarkItem(
        id = "bm_2",
        title = "ගණිතය (ජ්‍යාමිතිය) කෙටි සටහන්",
        subject = "ගණිතය",
        grade = "11",
        type = "NOTE",
        pdfUri = "https://drive.google.com/file/d/1V3y65z_15X6zjruQ_I11WhG4EOfDHGm-/preview"
      ),
      BookmarkItem(
        id = "bm_3",
        title = "10 සහ 11 ශ්‍රේණිය ජීව විද්‍යාව විභාග ප්‍රශ්න",
        subject = "විද්‍යාව",
        grade = "11",
        type = "PAPER",
        pdfUri = "https://drive.google.com/file/d/1zAddaGRd4loU0yxwWaMDi14G3rcFOvP4/preview"
      ),
      BookmarkItem(
        id = "bm_4",
        title = "06-11 ශ්‍රේණි - ඉතිහාසය සිතියම් ලකුණු කිරීම",
        subject = "ඉතිහාසය",
        grade = "10",
        type = "NOTE",
        pdfUri = "https://drive.google.com/file/d/1BVguuBjT1_iQVO296Zn4Dek2AOahBFsp/preview"
      )
    )
  }

  // Admin / Add Content Modal State
  var showAddContentDialog by remember { mutableStateOf(false) }
  var contentTypeToAdd by remember { mutableStateOf("NOTE") } // "SUBJECT", "NOTE", "PAPER", "VIDEO"
  var inputTitle by remember { mutableStateOf("") }
  var inputSubject by remember { mutableStateOf("විද්‍යාව") }
  var inputExtraInfo by remember { mutableStateOf("") }

  val gradesList = listOf("10", "11")

  // Dynamic live lists for current grade
  val currentSubjects = remember(liveSubjectsMap, selectedGrade) {
    liveSubjectsMap[selectedGrade] ?: mutableStateListOf<SubjectItem>()
  }
  val currentNotes = remember(liveNotesMap, selectedGrade) {
    liveNotesMap[selectedGrade] ?: mutableStateListOf<ShortNoteItem>()
  }
  val currentPapers = remember(livePapersMap, selectedGrade) {
    livePapersMap[selectedGrade] ?: mutableStateListOf<QuestionPaperItem>()
  }
  val currentVideos = remember(liveVideosMap, selectedGrade) {
    liveVideosMap[selectedGrade] ?: mutableStateListOf<VideoLessonItem>()
  }

  // Graceful Back Navigation Handler: Intercepts device back button and gestures to prevent sudden exits
  BackHandler(enabled = true) {
    when {
      showAppLaunchSplash -> {
        showAppLaunchSplash = false
      }
      showIframePdfModal -> {
        showIframePdfModal = false
      }
      showPasswordDialog -> {
        showPasswordDialog = false
        showPasswordError = false
      }
      showAuthRequiredDialog -> {
        showAuthRequiredDialog = false
      }
      showPaymentApprovalDialog -> {
        showPaymentApprovalDialog = false
      }
      showAddContentDialog -> {
        showAddContentDialog = false
        selectedPdfUri = null
        selectedPdfFileName = null
      }
      previewReceiptImageUrl != null -> {
        previewReceiptImageUrl = null
      }
      activeDetailTitle != null -> {
        activeDetailTitle = null
        selectedItemPdfUri = null
      }
      activeQuizSet != null -> {
        activeQuizSet = null
      }
      showFlashcardsDialog -> {
        showFlashcardsDialog = false
      }
      showPdfQuizBottomSheet -> {
        showPdfQuizBottomSheet = false
      }
      currentScreen == "SYLLABUS_HUB" -> {
        currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
      }
      showEyeCareSettingsSheet -> {
        showEyeCareSettingsSheet = false
      }
      currentScreen == "CONTENT" -> {
        initialTopicNotesFilter = ""
        currentScreen = "SUBJECTS"
      }
      currentScreen == "GRADE_11_TERM_TEST_PORTAL" -> {
        currentScreen = if (selectedSubjectItem != null) "CONTENT" else "SUBJECTS"
      }
      currentScreen == "GRADE_10_TERM_TEST_PORTAL" -> {
        currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
      }
      currentScreen == "SUBJECTS" -> {
        currentScreen = "HOME"
      }
      currentScreen == "ENGLISH_SHORT_NOTES_AUTO_CHECKER" -> {
        currentScreen = "ENGLISH_BUILDER"
      }
      currentScreen == "GRADE_10_11_MATH_SHORT_NOTES" || currentScreen == "GRADE_10_11_COMMERCE_SHORT_NOTES" -> {
        currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
      }
      currentScreen in listOf("ANALYTICS", "STRUCTURED_ESSAY", "FORMULA_HANDBOOK", "VOICE_QUIZ", "ENGLISH_BUILDER", "FLASHCARDS_HUB", "SPOKEN_ENGLISH_VOICE", "BOOKMARKS_HUB", "EYE_CARE_HUB", "HISTORY_MAPS_AUTO_CHECKER", "MISTAKE_NOTEBOOK", "MOCK_EXAM") -> {
        currentScreen = "HOME"
        selectedTabNav = 0
      }
      currentScreen == "GEOGRAPHY_AUTO_CHECKER" -> {
        currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
        selectedTabNav = 0
      }
      currentScreen == "OL_SPECIAL_FEATURES" -> {
        currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
        selectedTabNav = 0
      }
      currentScreen == "GRADE_10_11_COMMERCE_SHORT_NOTES" -> {
        currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
        selectedTabNav = 0
      }
      currentScreen == "GRADE_10_11_MATH_SHORT_NOTES" -> {
        currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
        selectedTabNav = 0
      }
      else -> {
        (context as? android.app.Activity)?.finish()
      }
    }
  }

  MyApplicationTheme(eyeCareMode = activeEyeCareMode) {
      Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
          modifier = Modifier
            .fillMaxSize()
            .testTag("main_scaffold"),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
          val isImmersiveExamOrPortal = currentScreen in listOf(
            "GRADE_10_TERM_TEST_PORTAL",
            "GRADE_11_TERM_TEST_PORTAL",
            "MOCK_EXAM",
            "TIMED_PAST_PAPER_SIMULATOR",
            "LIVE_DAILY_QUIZ"
          ) || isHubFullScreen
          if (!isImmersiveExamOrPortal) {
            TopBannerAdView()
          }
        },
        bottomBar = {
          val isImmersiveExamOrPortal = currentScreen in listOf(
            "GRADE_10_TERM_TEST_PORTAL",
            "GRADE_11_TERM_TEST_PORTAL",
            "MOCK_EXAM",
            "TIMED_PAST_PAPER_SIMULATOR",
            "LIVE_DAILY_QUIZ"
          ) || isHubFullScreen
          if (!isImmersiveExamOrPortal) {
            Column(modifier = Modifier.fillMaxWidth()) {
              PortalBottomNavigation(
                selectedTab = selectedTabNav,
                onTabSelected = { index ->
                  when (index) {
                    0 -> {
                      selectedTabNav = 0
                      currentScreen = "HOME"
                    }
                    1 -> {
                      requireFeatureAccess {
                        selectedTabNav = 1
                        currentScreen = "ANALYTICS"
                      }
                    }
                    2 -> {
                      requireFeatureAccess {
                        selectedTabNav = 2
                        currentScreen = "STRUCTURED_ESSAY"
                      }
                    }
                    3 -> {
                      requireFeatureAccess {
                        selectedTabNav = 3
                        val cat = when {
                          selectedSubjectItem != null && selectedSubjectItem?.nameSinhala?.contains("විද්‍යාව") == true && selectedSubjectItem?.nameSinhala?.contains("භූගෝල") != true -> "SCIENCE"
                          selectedSubjectItem != null && selectedSubjectItem?.nameSinhala?.contains("ගණිත") == true -> "MATH"
                          selectedSubjectItem != null && (selectedSubjectItem?.nameSinhala?.contains("ව්‍යාපාර") == true || selectedSubjectItem?.nameSinhala?.contains("ගිණුම්") == true) -> "COMMERCE"
                          selectedSubjectItem != null && (selectedSubjectItem?.nameSinhala?.contains("තොරතුරු") == true || selectedSubjectItem?.nameSinhala?.contains("ICT") == true) -> "ICT"
                          selectedSubjectItem != null && selectedSubjectItem?.nameSinhala?.contains("ඉතිහාස") == true -> "TIMELINE"
                          selectedSubjectItem != null && selectedSubjectItem?.nameSinhala?.contains("භූගෝල") == true -> "GEOGRAPHY"
                          selectedSubjectItem != null && selectedSubjectItem?.nameSinhala?.contains("පුරවැසි") == true -> "CIVICS"
                          else -> "ALL"
                        }
                        initialFormulaCategory = cat
                        initialFormulaQuery = ""
                        currentScreen = "FORMULA_HANDBOOK"
                      }
                    }
                    4 -> {
                      requireFeatureAccess {
                        selectedTabNav = 4
                        currentScreen = "VOICE_DOUBT_SOLVER"
                      }
                    }
                  }
                }
              )
              // Meta Audience Network Banner Ad
            }
          }
        },
    floatingActionButton = {
      if (isAdminAuthenticated && isAdminBarUnlocked && currentScreen == "HOME") {
        Column(horizontalAlignment = Alignment.End) {
          // Admin Staging & One-Click Release FAB (Shown when drafts exist)
          if (stagedContentItems.isNotEmpty()) {
            FloatingActionButton(
              onClick = { showStagingManagerDialog = true },
              containerColor = Color(0xFFD97706), // Amber
              contentColor = Color.White,
              shape = CircleShape,
              elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 4.dp),
              modifier = Modifier
                .size(42.dp)
                .testTag("admin_staging_fab")
                .padding(bottom = 6.dp)
            ) {
              Icon(
                imageVector = Icons.Default.CloudUpload,
                contentDescription = "Release Staged Items (${stagedContentItems.size})",
                modifier = Modifier.size(20.dp)
              )
            }
          }

          // Admin Broadcast Message FAB
          FloatingActionButton(
            onClick = { showAdminBroadcastComposerDialog = true },
            containerColor = Color(0xFF1E3A8A),
            contentColor = Color.White,
            shape = CircleShape,
            elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 3.dp),
            modifier = Modifier
              .size(42.dp)
              .testTag("admin_broadcast_fab")
              .padding(bottom = 6.dp)
          ) {
            Icon(
              imageVector = Icons.Default.Send,
              contentDescription = "Admin Broadcast Announcement",
              modifier = Modifier.size(20.dp)
            )
          }

          FloatingActionButton(
            onClick = { showAddContentDialog = true },
            containerColor = Color(0xFF137333),
            contentColor = Color.White,
            shape = CircleShape,
            elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 3.dp),
            modifier = Modifier
              .size(42.dp)
              .testTag("add_content_fab")
              .padding(bottom = 4.dp)
          ) {
            Icon(
              imageVector = Icons.Default.Add,
              contentDescription = "Add Content Live",
              modifier = Modifier.size(20.dp)
            )
          }
        }
      }
    }
  ) { innerPadding ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
    ) {
      ConditionalDisableSelection(disabled = !isAdminAuthenticated) {
        Box(modifier = Modifier.fillMaxSize()) {
          // Background Subtle Text Accent
          WatermarkBackground()

      // CRITICAL 100% SECURITY BARRIER:
      // If 12 hours free trial has expired and user is not an approved student or admin,
      // force effectiveScreen to "HOME". Absolutely no sub-features or secondary screens can render.
      val effectiveScreen = if (!isApprovedUser && !isFeatureTrialActive) "HOME" else currentScreen

      if (effectiveScreen == "SYLLABUS_HUB") {
        // FEATURE: SYLLABUS DETECTION & GOOGLE DRIVE CONTENT HUB SCREEN (06 - 11 ශ්‍රේණි)
        SyllabusDetectionAndContentScreen(
          initialGrade = selectedGrade,
          initialSubject = selectedSubjectItem?.nameSinhala ?: "විද්‍යාව",
          isApproved = isApprovedUser,
          isAdmin = isAdminAuthenticated,
          onRequireApproval = {
            authDialogInitialTab = 0
            showAuthRequiredDialog = true
          },
          onBack = {
            currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
          },
          onOpenGoogleDrivePdfModal = { url, title ->
            val hasAccess = isApprovedUser || isFeatureTrialActive
            if (!hasAccess) {
              Toast.makeText(context, "🔒 මෙම පීඩීඑෆ් සටහන් හා ප්‍රශ්න පත්‍ර පරිශීලනය කිරීමට ඇඩ්මින් අනුමැතිය (Admin Approval) අවශ්‍ය වේ.", Toast.LENGTH_LONG).show()
              authDialogInitialTab = 0
              showAuthRequiredDialog = true
            } else {
              iframeModalPdfTitle = title
              iframeModalPdfUrl = formatToGoogleDriveEmbedUrl(url)
              showIframePdfModal = true
            }
          }
        )
      } else if (effectiveScreen == "ANALYTICS") {
        // FEATURE 2: DETAILED ANALYTICS SCREEN WITH WEAK AREAS DETECTOR & DIRECT ACTION BUTTONS
        StudyAnalyticsScreen(
          grade = selectedGrade,
          onBack = {
            currentScreen = "HOME"
            selectedTabNav = 0
          },
          onOpenNotesForSubject = { subjectName, topicKeyword ->
            val matched = currentSubjects.firstOrNull { it.nameSinhala.contains(subjectName, ignoreCase = true) }
            initialTopicNotesFilter = topicKeyword
            if (matched != null) {
              selectedSubjectItem = matched
              selectedContentTab = 0
              currentScreen = "CONTENT"
            } else {
              currentScreen = "HOME"
              selectedTabNav = 0
            }
          },
          onOpenMistakeNotebook = { subject, topicKeyword ->
            requireFeatureAccess {
              initialMistakeSubjectFilter = subject
              initialMistakeTopicFilter = topicKeyword
              currentScreen = "MISTAKE_NOTEBOOK"
            }
          },
          onOpenFlashcards = {
            requireFeatureAccess {
              currentScreen = "FLASHCARDS_HUB"
            }
          },
          onOpenFormulaHandbook = { category, searchQuery ->
            requireFeatureAccess {
              initialFormulaCategory = category
              initialFormulaQuery = searchQuery
              currentScreen = "FORMULA_HANDBOOK"
              selectedTabNav = 3
            }
          }
        )
      } else if (effectiveScreen == "STRUCTURED_ESSAY") {
        // FEATURE 3: STRUCTURED & ESSAY PRACTICE HUB
        StructuredEssayHubScreen(
          grade = selectedGrade,
          onBack = {
            currentScreen = "HOME"
            selectedTabNav = 0
          }
        )
      } else if (effectiveScreen == "FORMULA_HANDBOOK") {
        // FEATURE 5: QUICK REFERENCE FORMULA & TIMELINE HUB (WITH TARGETED WEAK TOPIC FILTERING)
        FormulaAndTimelineHubScreen(
          initialQuery = initialFormulaQuery,
          initialCategory = initialFormulaCategory,
          initialGrade = selectedGrade,
          lockedSubjectName = selectedSubjectItem?.nameSinhala,
          onBack = {
            initialFormulaQuery = ""
            initialFormulaCategory = "ALL"
            if (selectedSubjectItem != null) {
              currentScreen = "CONTENT"
              selectedTabNav = 0
            } else {
              currentScreen = "HOME"
              selectedTabNav = 0
            }
          }
        )
      } else if (effectiveScreen == "VOICE_QUIZ") {
        // FEATURE 3 (VOICE): AI VOICE QUIZ & ORAL SIMULATION SCREEN
        VoiceQuizScreen(
          onBack = {
            currentScreen = "HOME"
            selectedTabNav = 0
          }
        )
      } else if (effectiveScreen == "ENGLISH_BUILDER" || effectiveScreen == "ENGLISH_CLASS") {
        // ENGLISH MASTER CLASS SCREEN (Vertical Accordion Sub-Sections with Background Photos & Voice Mic AI)
        EnglishMasterClassScreen(
          onBack = {
            currentScreen = "HOME"
            selectedTabNav = 0
          },
          onOpenGoogleDrivePdfModal = { url, title ->
            val hasAccess = isApprovedUser || isFeatureTrialActive
            if (!hasAccess) {
              Toast.makeText(context, "🔒 මෙම පීඩීඑෆ් සටහන් හා ප්‍රශ්න පත්‍ර පරිශීලනය කිරීමට ඇඩ්මින් අනුමැතිය (Admin Approval) අවශ්‍ය වේ.", Toast.LENGTH_LONG).show()
              authDialogInitialTab = 0
              showAuthRequiredDialog = true
            } else {
              iframeModalPdfTitle = title
              iframeModalPdfUrl = formatToGoogleDriveEmbedUrl(url)
              showIframePdfModal = true
            }
          },
          onOpenAutoChecker = {
            currentScreen = "ENGLISH_SHORT_NOTES_AUTO_CHECKER"
          },
          onOpenVoiceDoubtSolver = {
            englishInitialSubTab = 4
            currentScreen = "ENGLISH_CLASS"
          },
          initialSubTab = englishInitialSubTab
        )
      } else if (effectiveScreen == "FLASHCARDS_HUB") {
        // FEATURE: INTERACTIVE FLASHCARDS SCREEN
        InteractiveFlashcardsScreen(
          onBack = {
            currentScreen = "HOME"
            selectedTabNav = 0
          }
        )
      } else if (effectiveScreen == "SPOKEN_ENGLISH_VOICE") {
        // SPOKEN ENGLISH IS INTEGRATED INSIDE ENGLISH CLASS (SubTab 2)
        EnglishMasterClassScreen(
          onBack = {
            currentScreen = "HOME"
            selectedTabNav = 0
          },
          onOpenGoogleDrivePdfModal = { url, title ->
            val hasAccess = isApprovedUser || isFeatureTrialActive
            if (!hasAccess) {
              Toast.makeText(context, "🔒 මෙම පීඩීඑෆ් සටහන් හා ප්‍රශ්න පත්‍ර පරිශීලනය කිරීමට ඇඩ්මින් අනුමැතිය (Admin Approval) අවශ්‍ය වේ.", Toast.LENGTH_LONG).show()
              authDialogInitialTab = 0
              showAuthRequiredDialog = true
            } else {
              iframeModalPdfTitle = title
              iframeModalPdfUrl = formatToGoogleDriveEmbedUrl(url)
              showIframePdfModal = true
            }
          },
          onOpenAutoChecker = {
            currentScreen = "ENGLISH_SHORT_NOTES_AUTO_CHECKER"
          },
          onOpenVoiceDoubtSolver = {
            englishInitialSubTab = 4
            currentScreen = "ENGLISH_CLASS"
          },
          initialSubTab = 2
        )
      } else if (effectiveScreen == "BOOKMARKS_HUB") {
        // FEATURE 5 (NEW): BOOKMARK & SAVED NOTES SCREEN
        BookmarksAndFavoritesScreen(
          onBack = {
            currentScreen = "HOME"
            selectedTabNav = 0
          },
          onOpenPdf = { url, title ->
            val hasAccess = isApprovedUser || isFeatureTrialActive
            if (!hasAccess) {
              Toast.makeText(context, "🔒 මෙම පීඩීඑෆ් පරිශීලනයට ඇඩ්මින් අනුමැතිය (Admin Approval) අවශ්‍ය වේ.", Toast.LENGTH_LONG).show()
              authDialogInitialTab = 0
              showAuthRequiredDialog = true
            } else {
              iframeModalPdfTitle = title
              iframeModalPdfUrl = formatToGoogleDriveEmbedUrl(url)
              showIframePdfModal = true
            }
          },
          savedBookmarks = savedBookmarks
        )
      } else if (effectiveScreen == "MOCK_EXAM") {
        // FEATURE: LIVE MOCK EXAM HALL & OMR SIMULATOR
        LiveMockExamHallScreen(
          grade = selectedGrade,
          onBack = {
            currentScreen = "HOME"
            selectedTabNav = 0
          },
          onOpenMistakeNotebook = {
            requireFeatureAccess {
              currentScreen = "MISTAKE_NOTEBOOK"
            }
          }
        )
      } else if (effectiveScreen == "MISTAKE_NOTEBOOK") {
        // FEATURE 2: MISTAKE NOTEBOOK & TARGETED REVISION BANK (WITH TARGETED WEAK TOPIC FILTERING)
        MistakeNotebookScreen(
          grade = selectedGrade,
          initialSubjectFilter = initialMistakeSubjectFilter,
          initialTopicFilter = initialMistakeTopicFilter,
          onBack = {
            initialMistakeSubjectFilter = "ALL"
            initialMistakeTopicFilter = ""
            currentScreen = "HOME"
            selectedTabNav = 0
          },
          onOpenNotesForSubject = { subjectName ->
            val matched = currentSubjects.firstOrNull { it.nameSinhala.contains(subjectName, ignoreCase = true) }
            if (matched != null) {
              selectedSubjectItem = matched
              selectedContentTab = 0
              currentScreen = "CONTENT"
            } else {
              currentScreen = "HOME"
              selectedTabNav = 0
            }
          },
          onOpenMockExam = {
            requireFeatureAccess {
              currentScreen = "MOCK_EXAM"
            }
          }
        )
      } else if (effectiveScreen == "LIVE_DAILY_QUIZ") {
        // FEATURE: 7:00 PM AUTOMATED DAILY LIVE QUIZ CONTEST & LEADERBOARDS
        DailyLiveQuizHubScreen(
          initialGrade = selectedGrade,
          userName = loggedInUser?.fullName ?: "ශිෂ්‍යයා",
          userApprovedGrades = loggedInUser?.approvedGrades ?: emptyList(),
          isAdmin = isAdminAuthenticated,
          onBack = {
            currentScreen = "HOME"
            selectedTabNav = 0
          }
        )
      } else if (effectiveScreen == "EYE_CARE_HUB") {
        // FEATURE: EYE-CARE & NIGHT STUDY READER HUB
        EyeCareNightStudyScreen(
          currentMode = activeEyeCareMode,
          currentFontScale = activeFontScale,
          currentLineSpacing = activeLineSpacing,
          isEyeBreakEnabled = isEyeBreakReminderEnabled,
          onModeChanged = { mode -> activeEyeCareMode = mode },
          onFontScaleChanged = { scale -> activeFontScale = scale },
          onLineSpacingChanged = { spacing -> activeLineSpacing = spacing },
          onEyeBreakToggle = { enabled -> isEyeBreakReminderEnabled = enabled },
          onBack = {
            currentScreen = "HOME"
            selectedTabNav = 0
          }
        )
      } else if (effectiveScreen == "HISTORY_MAPS_AUTO_CHECKER") {
        // FEATURE: 09/10/11 HISTORY BLANK MAPS MARKING & 100% AUTO-CHECKER HUB
        HistoryMapsAutoCheckerScreen(
          onBack = {
            currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
            selectedTabNav = 0
          },
          onOpenPdfDriveViewer = { pdfUrl, title ->
            iframeModalPdfTitle = title
            iframeModalPdfUrl = pdfUrl
            showIframePdfModal = true
          }
        )
      } else if (effectiveScreen == "SCIENCE_500_AUTO_CHECKER") {
        // FEATURE: 11 SCIENCE 500 QUESTIONS & 100% EXPLANATION AUTO-CHECKER HUB
        Science500QuestionsAutoCheckerScreen(
          onBack = {
            currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
            selectedTabNav = 0
          },
          onOpenPdfDriveViewer = { pdfUrl, title ->
            iframeModalPdfTitle = title
            iframeModalPdfUrl = pdfUrl
            showIframePdfModal = true
          }
        )
      } else if (effectiveScreen == "GRADE_10_11_SCIENCE_SHORT_NOTES") {
        // 🔬 FEATURE: 10 & 11 ශ්‍රේණි විද්‍යාව කෙටි සටහන් (ඒකක 36 පූර්ණ කෙටි සටහන්, සමීකරණ & PDF සංග්‍රහය)
        Grade10And11ScienceShortNotesHubScreen(
          onBack = {
            currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
            selectedTabNav = 0
          },
          onOpenPdfModal = { pdfUrl, title ->
            iframeModalPdfTitle = title
            iframeModalPdfUrl = pdfUrl
            showIframePdfModal = true
          },
          onOpenScience500AutoCheck = {
            requireFeatureAccess {
              currentScreen = "SCIENCE_500_AUTO_CHECKER"
            }
          }
        )
      } else if (effectiveScreen == "ENGLISH_SHORT_NOTES_AUTO_CHECKER") {
        // FEATURE: 09/10/11 ENGLISH SHORT NOTES & 100% EXPLANATION AUTO-CHECKER HUB
        EnglishShortNotesAutoCheckerScreen(
          onBack = {
            currentScreen = "ENGLISH_BUILDER"
          },
          onOpenPdfDriveViewer = { pdfUrl, title ->
            iframeModalPdfTitle = title
            iframeModalPdfUrl = pdfUrl
            showIframePdfModal = true
          }
        )
      } else if (effectiveScreen == "GEOGRAPHY_AUTO_CHECKER") {
        // FEATURE: 10 & 11 GEOGRAPHY SHORT NOTES 100% ACCURATE AUTO-CHECKER HUB
        GeographyAutoCheckerScreen(
          onBack = {
            currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
            selectedTabNav = 0
          }
        )
      } else if (effectiveScreen == "GRADE_10_11_MATH_SHORT_NOTES") {
        // 📐 FEATURE: 10 & 11 ශ්‍රේණි ගණිතය කෙටි සටහන් (Sandu Theory ඒකක 42 & විසඳුම්)
        Grade10And11MathShortNotesHubScreen(
          onBack = {
            currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
            selectedTabNav = 0
          },
          onOpenPdfModal = { pdfUrl, title ->
            iframeModalPdfTitle = title
            iframeModalPdfUrl = pdfUrl
            showIframePdfModal = true
          },
          onOpenQuizMaster = {
            requireFeatureAccess {
              currentScreen = "MATH_4000_QUIZ"
            }
          }
        )
      } else if (effectiveScreen == "MATH_4000_QUIZ") {
        // 🔢 FEATURE: 10 & 11 ශ්‍රේණි ගණිතය ප්‍රශ්න 4000 ක්විස් මාස්ටර් (කාණ්ඩ 80 බැගින් 25 ප්‍රශ්න සෙට්)
        Grade10And11MathQuizMasterScreen(
          onBack = {
            currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
            selectedTabNav = 0
          }
        )
      } else if (effectiveScreen == "GRADE_10_11_COMMERCE_SHORT_NOTES") {
        // 📊 FEATURE: 10 & 11 ශ්‍රේණි ව්‍යාපාර හා ගිණුම්කරණය (Sandu Theory පාඩම් 27 & ද්විත්ව සටහන් 200)
        Grade10And11CommerceShortNotesHubScreen(
          onBack = {
            currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
            selectedTabNav = 0
          },
          onOpenPdfModal = { pdfUrl, title ->
            iframeModalPdfTitle = title
            iframeModalPdfUrl = pdfUrl
            showIframePdfModal = true
          }
        )
      } else if (effectiveScreen == "OL_SPECIAL_FEATURES") {
        // 🌟 FEATURE: O/L SPECIAL MASTER INTERACTIVE TOOLS SUITE (All Subjects)
        OlSpecialMasterFeaturesHubScreen(
          initialSection = activeSpecialFeatureSection,
          initialCategoryNumber = activeInitialCategory,
          lockedSubjectName = selectedSubjectItem?.nameSinhala,
          subject = selectedSubjectItem?.nameSinhala,
          onBack = {
            activeInitialCategory = null
            currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
            selectedTabNav = 0
          },
          onOpenPdfModal = { url, title ->
            iframeModalPdfTitle = title
            iframeModalPdfUrl = url
            showIframePdfModal = true
          }
        )
      } else if (effectiveScreen == "GRADE_10_TERM_TEST_PORTAL") {
        // 🛡️ FEATURE: 10 වසර වාර විභාග ප්‍රශ්න පත්‍ර (GovDoc.lk & e-Thaksalawa - 100% DRM Protected)
        Grade10SecureTermTestPortalScreen(
          initialSource = grade10PortalInitialSource,
          studentName = loggedInUser?.fullName ?: "ශිෂ්‍ය ගිණුම",
          studentPhone = loggedInUser?.usernameOrPhone ?: "",
          onOpenPdfModal = { url, title ->
            iframeModalPdfTitle = title
            iframeModalPdfUrl = url
            showIframePdfModal = true
          },
          onBack = {
            currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
            selectedTabNav = 0
          }
        )
      } else if (effectiveScreen == "GRADE_11_TERM_TEST_PORTAL") {
        // 🛡️ FEATURE: 11 වසර වාර විභාග ප්‍රශ්න පත්‍ර (GovDoc.lk & e-Thaksalawa - 100% DRM Protected)
        Grade11SecureTermTestPortalScreen(
          initialSource = grade11PortalInitialSource,
          initialSubject = grade11PortalInitialSubject,
          initialTerm = grade11PortalInitialTerm,
          studentName = loggedInUser?.fullName ?: "ශිෂ්‍ය ගිණුම",
          studentPhone = loggedInUser?.usernameOrPhone ?: "",
          onOpenPdfModal = { url, title ->
            iframeModalPdfTitle = title
            iframeModalPdfUrl = url
            showIframePdfModal = true
          },
          onBack = {
            currentScreen = if (selectedSubjectItem != null) "CONTENT" else "SUBJECTS"
          }
        )
      } else if (effectiveScreen == "FORMULA_SOLVER") {
        // 🧮 FEATURE 2: STEP-BY-STEP MATH & PHYSICS FORMULA SOLVER
        FormulaSolverScreen(
          onBack = {
            currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
          }
        )
      } else if (effectiveScreen == "TRILINGUAL_GLOSSARY") {
        // 📖 FEATURE 5: TRI-LINGUAL GLOSSARY (Science, Maths, ICT, Commerce)
        TriLingualGlossaryScreen(
          onBack = {
            currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
          }
        )
      } else if (effectiveScreen == "TIMED_PAST_PAPER_SIMULATOR") {
        // ⏱️ FEATURE 6: TIMED PAST PAPER SIMULATOR
        TimedPastPaperSimulatorScreen(
          onBack = {
            currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
          }
        )
      } else if (effectiveScreen == "OFFLINE_NOTES_VAULT") {
        // 💾 FEATURE 7: OFFLINE VAULT & STUDY NOTES
        OfflineNotesVaultScreen(
          onBack = {
            currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
          }
        )
      } else if (effectiveScreen == "INTERACTIVE_QA_HUB") {
        // 🎯 INTERACTIVE Q&A MASTER HUB (6 Q&A Modes)
        InteractiveQaMasterHubScreen(
          onBack = {
            isHubFullScreen = false
            currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
          },
          initialTab = selectedQaHubTab,
          isFullScreen = isHubFullScreen,
          onFullScreenToggle = { isHubFullScreen = it }
        )
      } else if (effectiveScreen == "VOICE_DOUBT_SOLVER") {
        // 🎙️ FEATURE: AI VOICE DOUBT SOLVER & STEP-BY-STEP EXPLAINER
        VoiceDoubtSolverScreen(
          initialGrade = selectedGrade,
          onBack = {
            currentScreen = if (selectedSubjectItem != null) "CONTENT" else "HOME"
            selectedTabNav = 0
          }
        )
      } else if (effectiveScreen == "ENGLISH_VOICE_DOUBT_SOLVER") {
        // 🇬🇧 DEDICATED ENGLISH AI STUDENT DOUBT VOICE ASSISTANT
        EnglishVoiceDoubtAssistantScreen(
          onBack = {
            currentScreen = "ENGLISH_CLASS"
          }
        )
      } else {
        val mainScrollState = rememberScrollState()
        LaunchedEffect(effectiveScreen, selectedGrade, selectedSubjectItem) {
          mainScrollState.scrollTo(0)
        }
        Column(
          modifier = Modifier
            .fillMaxSize()
            .verticalScroll(mainScrollState)
            .padding(bottom = 24.dp)
        ) {
          // Top Header
          TopHeaderSection(
            userName = when {
              isAdminAuthenticated -> "👑 ඇඩ්මින් පැනලය (Admin)"
              loggedInUser != null -> loggedInUser?.fullName ?: "ශිෂ්‍ය ගිණුම"
              else -> "ආයුබෝවන්, ශිෂ්‍යයා (Guest)"
            },
            userStream = when {
              isAdminAuthenticated -> "ඇඩ්මින් පරිපාලනය සක්‍රීයයි"
              loggedInUser?.isApproved == true -> "$selectedGrade වසර • අනුමත ශිෂ්‍ය ගිණුම"
              loggedInUser != null -> "$selectedGrade වසර • ඇඩ්මින් අනුමැතිය ලැබෙමින්..."
              else -> "$selectedGrade වසර • ශිෂ්‍ය ගිණුම"
            },
            isApproved = isApprovedUser,
            isAdmin = isAdminAuthenticated,
            eyeCareMode = activeEyeCareMode,
            unreadNotificationCount = unreadNotificationsCount,
            onEyeCareClick = { showEyeCareSettingsSheet = true },
            onSecurityClick = { showSecurityPanelDialog = true },
            onAuthClick = {
              authDialogInitialTab = 1
              showAuthRequiredDialog = true
            },
            onNotificationClick = {
              showNotificationCenterDialog = true
            },
            onAdminDashboardClick = {
              showAdminDashboardMasterDialog = true
            }
          )

          // Continuous Attention-Grabbing Notification Bar (Until user reads admin announcements)
          if (latestUnreadMessage != null) {
            AdminAnnouncementNotificationBar(
              latestMessage = latestUnreadMessage,
              unreadCount = unreadNotificationsCount,
              onClick = { showNotificationCenterDialog = true },
              onDismiss = {
                AdminBroadcastManager.markAsRead(context, latestUnreadMessage.id, adminBroadcastMessages)
              }
            )
            Spacer(modifier = Modifier.height(6.dp))
          }

          // Dedicated Admin Control Bar (ONLY visible to Admin, fully unlocked only via Step 2 Username & Password)
          if (isAdminAuthenticated) {
            if (isAdminBarUnlocked) {
              AdminControlBannerBar(
                pendingCount = registeredUsers.count { !it.isApproved && !isAuthorizedAdminUser(it.usernameOrPhone) },
                approvedCount = registeredUsers.count { it.isApproved && !it.isApprovalExpired() && !isAuthorizedAdminUser(it.usernameOrPhone) },
                expiredCount = registeredUsers.count { it.isApprovalExpired() && !isAuthorizedAdminUser(it.usernameOrPhone) },
                onOpenDashboard = { filter ->
                  adminDashboardInitialFilter = filter
                  showAdminDashboardMasterDialog = true
                },
                onOpenExpiredList = {
                  showExpiredStudentsDialog = true
                },
                onLockBar = {
                  isAdminBarUnlocked = false
                  Toast.makeText(context, "🔒 ඇඩ්මින් බාර් එක අගුළුලන ලදී (Admin Bar Locked)", Toast.LENGTH_SHORT).show()
                }
              )
              Spacer(modifier = Modifier.height(6.dp))
            } else {
              // 2-Step Security: Admin Bar is locked until Step 2 Username & Password are provided
              AdminBarLockedSecurityBanner(
                adminIdentifier = loggedInUser?.usernameOrPhone ?: "",
                onUnlockClick = {
                  showAdminBarUnlockDialog = true
                }
              )
              Spacer(modifier = Modifier.height(6.dp))
            }
          }

          // Admin Staging & One-Click Live Release Banner (ONLY visible to Admin when drafts exist AND Admin Bar is unlocked)
          if (isAdminAuthenticated && isAdminBarUnlocked && stagedContentItems.isNotEmpty()) {
            AdminStagingBannerBar(
              stagedCount = stagedContentItems.size,
              onReleaseAllClick = {
                AdminStagingManager.releaseAllStagedToLive(
                  context = context,
                  stagedList = stagedContentItems,
                  liveNotesMap = liveNotesMap,
                  livePapersMap = livePapersMap,
                  liveVideosMap = liveVideosMap,
                  adminBroadcastMessages = adminBroadcastMessages,
                  onComplete = { count ->
                    Toast.makeText(context, "අන්තර්ගතයන් $count ක් සාර්ථකව Live විය!", Toast.LENGTH_SHORT).show()
                  }
                )
              },
              onViewStagingClick = { showStagingManagerDialog = true }
            )
            Spacer(modifier = Modifier.height(6.dp))
          }

          Spacer(modifier = Modifier.height(10.dp))

          // Subscription Banner
          PaddingValues(horizontal = 16.dp).let {
            Box(modifier = Modifier.padding(it)) {
              SecuritySubscriptionBanner(
                isApproved = isApprovedUser,
                isFeatureTrialActive = isFeatureTrialActive,
                remainingTrialHours = remainingTrialHours,
                remainingTrialMinutes = remainingTrialMinutes,
                isApprovalExpired = isApprovalExpiredForLoggedInUser,
                remainingApprovalDays = loggedInUser?.getRemainingApprovalDays() ?: 180,
                onClick = {
                  if (!isApprovedUser || isApprovalExpiredForLoggedInUser) {
                    showPaymentApprovalDialog = true
                  } else {
                    showAuthRequiredDialog = true
                  }
                }
              )
            }
          }

          Spacer(modifier = Modifier.height(6.dp))

          // STEP 1: HOME SCREEN (Grades Grid/List in Descending Order: 11 to 06)
          if (effectiveScreen == "HOME") {
            GradesHomeScreen(
              onGradeSelected = { grade ->
                requireFeatureAccess {
                  selectedGrade = grade
                  currentScreen = "SUBJECTS"
                }
              },
              onOpenAddModal = {
                contentTypeToAdd = "SUBJECT"
                showAddContentDialog = true
              },
              onOpenAnalytics = {
                requireFeatureAccess {
                  currentScreen = "ANALYTICS"
                  selectedTabNav = 1
                }
              },
              onOpenStructuredEssay = {
                requireFeatureAccess {
                  currentScreen = "STRUCTURED_ESSAY"
                  selectedTabNav = 2
                }
              },
              onOpenFormulaHandbook = {
                requireFeatureAccess {
                  val cat = when {
                    selectedSubjectItem?.nameSinhala?.contains("විද්‍යාව") == true && selectedSubjectItem?.nameSinhala?.contains("භූගෝල") != true -> "SCIENCE"
                    selectedSubjectItem?.nameSinhala?.contains("ගණිත") == true -> "MATH"
                    selectedSubjectItem?.nameSinhala?.contains("ව්‍යාපාර") == true || selectedSubjectItem?.nameSinhala?.contains("ගිණුම්") == true -> "COMMERCE"
                    selectedSubjectItem?.nameSinhala?.contains("තොරතුරු") == true || selectedSubjectItem?.nameSinhala?.contains("ICT") == true -> "ICT"
                    selectedSubjectItem?.nameSinhala?.contains("ඉතිහාස") == true -> "TIMELINE"
                    selectedSubjectItem?.nameSinhala?.contains("භූගෝල") == true -> "GEOGRAPHY"
                    selectedSubjectItem?.nameSinhala?.contains("පුරවැසි") == true -> "CIVICS"
                    else -> "ALL"
                  }
                  initialFormulaCategory = cat
                  initialFormulaQuery = ""
                  currentScreen = "FORMULA_HANDBOOK"
                  selectedTabNav = 3
                }
              },
              onOpenVoiceQuiz = {
                requireFeatureAccess {
                  currentScreen = "VOICE_QUIZ"
                }
              },
              onOpenEnglishBuilder = {
                requireFeatureAccess {
                  englishInitialSubTab = 0
                  currentScreen = "ENGLISH_BUILDER"
                }
              },
              onOpenSyllabusHub = {
                requireFeatureAccess {
                  currentScreen = "SYLLABUS_HUB"
                }
              },
              onOpenFlashcards = {
                requireFeatureAccess {
                  currentScreen = "FLASHCARDS_HUB"
                }
              },
              onOpenSpokenEnglishVoice = {
                requireFeatureAccess {
                  englishInitialSubTab = 2
                  currentScreen = "ENGLISH_BUILDER"
                }
              },
              onOpenBookmarks = {
                requireFeatureAccess {
                  currentScreen = "BOOKMARKS_HUB"
                }
              },
              onOpenMockExam = {
                requireFeatureAccess {
                  currentScreen = "MOCK_EXAM"
                }
              },
              onOpenLiveDailyQuiz = {
                requireFeatureAccess {
                  currentScreen = "LIVE_DAILY_QUIZ"
                }
              },
              onOpenEyeCare = {
                requireFeatureAccess {
                  currentScreen = "EYE_CARE_HUB"
                }
              },
              onOpenHistoryMapsAutoCheck = {
                requireFeatureAccess {
                  currentScreen = "HISTORY_MAPS_AUTO_CHECKER"
                }
              },
              onOpenScience500AutoCheck = {
                requireFeatureAccess {
                  currentScreen = "SCIENCE_500_AUTO_CHECKER"
                }
              },
              onOpenEnglishShortNotesAutoCheck = {
                requireFeatureAccess {
                  currentScreen = "ENGLISH_SHORT_NOTES_AUTO_CHECKER"
                }
              },
              onOpenGeographyAutoCheck = {
                requireFeatureAccess {
                  currentScreen = "GEOGRAPHY_AUTO_CHECKER"
                }
              },
              onOpenMathQuizMaster = {
                requireFeatureAccess {
                  currentScreen = "MATH_4000_QUIZ"
                }
              },
              onOpenSpecialMasterFeatures = { section ->
                requireFeatureAccess {
                  activeSpecialFeatureSection = section
                  currentScreen = "OL_SPECIAL_FEATURES"
                }
              },
              onOpenGrade10TermTestPortal = { source ->
                requireFeatureAccess {
                  grade10PortalInitialSource = source
                  currentScreen = "GRADE_10_TERM_TEST_PORTAL"
                }
              },
              onOpenGrade11TermTestPortal = { src, sub, term ->
                requireFeatureAccess {
                  grade11PortalInitialSource = src
                  grade11PortalInitialSubject = sub ?: "විද්‍යාව"
                  grade11PortalInitialTerm = term ?: 1
                  currentScreen = "GRADE_11_TERM_TEST_PORTAL"
                }
              },
              onOpenFormulaSolver = {
                requireFeatureAccess {
                  currentScreen = "FORMULA_SOLVER"
                }
              },
              onOpenTriLingualGlossary = {
                requireFeatureAccess {
                  currentScreen = "TRILINGUAL_GLOSSARY"
                }
              },
              onOpenTimedPastPaperSimulator = {
                requireFeatureAccess {
                  currentScreen = "TIMED_PAST_PAPER_SIMULATOR"
                }
              },
              onOpenOfflineNotesVault = {
                requireFeatureAccess {
                  currentScreen = "OFFLINE_NOTES_VAULT"
                }
              },
              onOpenInteractiveQaHub = { tab ->
                requireFeatureAccess {
                  selectedQaHubTab = tab
                  currentScreen = "INTERACTIVE_QA_HUB"
                }
              },
              onOpenVoiceDoubtSolver = {
                requireFeatureAccess {
                  selectedTabNav = 4
                  currentScreen = "VOICE_DOUBT_SOLVER"
                }
              },
              onOpenMistakeNotebook = {
                requireFeatureAccess {
                  currentScreen = "MISTAKE_NOTEBOOK"
                }
              },
              isFeatureTrialActive = isFeatureTrialActive,
              isApproved = isApprovedUser,
              remainingTrialHours = remainingTrialHours
            )
          }

          // STEP 2: SUBJECTS SCREEN (List of Subjects for Selected Grade with Background Photos)
          else if (effectiveScreen == "SUBJECTS") {
            GradeSubjectsScreen(
              grade = selectedGrade,
              subjectsList = currentSubjects,
              isAdmin = isAdminAuthenticated,
              onSubjectSelected = { subject ->
                requireFeatureAccess {
                  selectedSubjectItem = subject
                  currentScreen = "CONTENT"
                }
              },
              onBackToGrades = {
                currentScreen = "HOME"
              },
              onAddSubject = {
                contentTypeToAdd = "SUBJECT"
                showAddContentDialog = true
              },
              onDeleteSubject = { subject ->
                currentSubjects.remove(subject)
                Toast.makeText(context, "${subject.nameSinhala} විෂය ඉවත් විය", Toast.LENGTH_SHORT).show()
              },
              onOpenGrade10TermTestPortal = { source ->
                requireFeatureAccess {
                  grade10PortalInitialSource = source
                  currentScreen = "GRADE_10_TERM_TEST_PORTAL"
                }
              },
              onOpenGrade11TermTestPortal = { source, subject, term ->
                requireFeatureAccess {
                  grade11PortalInitialSource = source
                  grade11PortalInitialSubject = subject
                  grade11PortalInitialTerm = term
                  currentScreen = "GRADE_11_TERM_TEST_PORTAL"
                }
              }
            )
          }

          // STEP 3: CONTENT SCREEN (4-Section Subject Hub: Short Notes | Papers | Quizzes | AI Smart Assistant)
          else if (effectiveScreen == "CONTENT" && selectedSubjectItem != null) {
            SubjectContentScreen(
              grade = selectedGrade,
              subject = selectedSubjectItem!!,
              selectedTab = selectedContentTab,
              isAdmin = isAdminAuthenticated,
              initialSearchQuery = initialTopicNotesFilter,
              onTabSelected = { tabIndex ->
                selectedContentTab = tabIndex
              },
              notesList = currentNotes,
              papersList = currentPapers,
              videosList = currentVideos,
              onPdfClick = { title, pdfUri, isPasswordProtected, password ->
                handlePdfAccess(title, pdfUri, isPasswordProtected, password)
              },
              onDeleteNote = { note ->
                currentNotes.remove(note)
                Toast.makeText(context, "කෙටි සටහන / PDF ඉවත් විය", Toast.LENGTH_SHORT).show()
              },
              onDeletePaper = { paper ->
                currentPapers.remove(paper)
                Toast.makeText(context, "ප්‍රශ්න පත්‍රය ඉවත් විය", Toast.LENGTH_SHORT).show()
              },
              onDeleteVideo = { video ->
                currentVideos.remove(video)
                Toast.makeText(context, "වීඩියෝ පාඩම ඉවත් විය", Toast.LENGTH_SHORT).show()
              },
              onVideoClick = { video ->
                performProtectedAction {
                  isVideoModal = true
                  activeDetailTitle = "වීඩියෝ පාඩම: ${video.titleSinhala}"
                  selectedItemPdfUri = null
                }
              },
              onBackToSubjects = {
                initialTopicNotesFilter = ""
                currentScreen = "SUBJECTS"
              },
              onAddContent = { type ->
                contentTypeToAdd = type
                inputSubject = selectedSubjectItem?.nameSinhala ?: "විද්‍යාව"
                showAddContentDialog = true
              },
              onStartQuizSet = { set ->
                performProtectedAction {
                  activeQuizSet = set
                }
              },
              onOpenFlashcards = {
                performProtectedAction {
                  showFlashcardsDialog = true
                }
              },
              onOpenPdfAtPage = { url, title, page -> openPdfAtPage(url, title, page) },
              onOpenAnalytics = {
                currentScreen = "ANALYTICS"
                selectedTabNav = 1
              },
              onOpenStructuredEssay = {
                currentScreen = "STRUCTURED_ESSAY"
                selectedTabNav = 2
              },
              onOpenFormulaHandbook = {
                val cat = when {
                  selectedSubjectItem?.nameSinhala?.contains("විද්‍යාව") == true && selectedSubjectItem?.nameSinhala?.contains("භූගෝල") != true -> "SCIENCE"
                  selectedSubjectItem?.nameSinhala?.contains("ගණිත") == true -> "MATH"
                  selectedSubjectItem?.nameSinhala?.contains("ව්‍යාපාර") == true || selectedSubjectItem?.nameSinhala?.contains("ගිණුම්") == true -> "COMMERCE"
                  selectedSubjectItem?.nameSinhala?.contains("තොරතුරු") == true || selectedSubjectItem?.nameSinhala?.contains("ICT") == true -> "ICT"
                  selectedSubjectItem?.nameSinhala?.contains("ඉතිහාස") == true -> "TIMELINE"
                  selectedSubjectItem?.nameSinhala?.contains("භූගෝල") == true -> "GEOGRAPHY"
                  selectedSubjectItem?.nameSinhala?.contains("පුරවැසි") == true -> "CIVICS"
                  else -> "ALL"
                }
                initialFormulaCategory = cat
                initialFormulaQuery = ""
                currentScreen = "FORMULA_HANDBOOK"
                selectedTabNav = 3
              },
              onOpenSpecialMasterFeatures = { section ->
                requireFeatureAccess {
                  activeSpecialFeatureSection = section
                  currentScreen = "OL_SPECIAL_FEATURES"
                }
              },
              onOpenVoiceQuiz = {
                currentScreen = "VOICE_QUIZ"
              },
              onOpenEnglishBuilder = {
                currentScreen = "ENGLISH_BUILDER"
              },
              onOpenSyllabusHub = {
                currentScreen = "SYLLABUS_HUB"
              },
              onOpenHistoryMapsAutoCheck = {
                currentScreen = "HISTORY_MAPS_AUTO_CHECKER"
              },
              onOpenScience500AutoCheck = {
                currentScreen = "SCIENCE_500_AUTO_CHECKER"
              },
              onOpenScienceShortNotes = {
                currentScreen = "GRADE_10_11_SCIENCE_SHORT_NOTES"
              },
              onOpenEnglishShortNotesAutoCheck = {
                currentScreen = "ENGLISH_SHORT_NOTES_AUTO_CHECKER"
              },
              onOpenGeographyAutoCheck = {
                currentScreen = "GEOGRAPHY_AUTO_CHECKER"
              },
              onOpenMathShortNotesAutoCheck = {
                currentScreen = "GRADE_10_11_MATH_SHORT_NOTES"
              },
              onOpenCommerceShortNotes = {
                currentScreen = "GRADE_10_11_COMMERCE_SHORT_NOTES"
              },

              onOpenGrade10TermTestPortal = { source ->
                grade10PortalInitialSource = source
                currentScreen = "GRADE_10_TERM_TEST_PORTAL"
              },
              onOpenGrade11TermTestPortal = { source, subject, term ->
                grade11PortalInitialSource = source
                grade11PortalInitialSubject = subject
                grade11PortalInitialTerm = term
                currentScreen = "GRADE_11_TERM_TEST_PORTAL"
              },
              onOpenInteractiveQaHub = { tab ->
                selectedQaHubTab = tab
                currentScreen = "INTERACTIVE_QA_HUB"
              },
              onOpenVoiceDoubtSolver = {
                requireFeatureAccess {
                  selectedTabNav = 4
                  currentScreen = "VOICE_DOUBT_SOLVER"
                }
              }
            )
          }
        }
      }
    }
  }

  // Add Content Live Modal Dialog
      if (showAddContentDialog) {
        AlertDialog(
          onDismissRequest = {
            showAddContentDialog = false
            selectedPdfUri = null
            selectedPdfFileName = null
          },
          title = {
            Text(
              text = "නව තොරතුරු / PDF එකතු කිරීම (Add Content)",
              style = MaterialTheme.typography.titleMedium,
              fontWeight = FontWeight.Bold,
              color = NeutralDark
            )
          },
          text = {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
              Text(
                text = "ඔබගේ PDF ගොනු, කෙටි සටහන්, වීඩියෝ හා ප්‍රශ්න පත්‍ර ඇප් එකට එකතු කරන්න. එකතු කරන සියලුම අන්තර්ගතයන් එසැනින්ම දර්ශනය වේ.",
                style = MaterialTheme.typography.bodySmall,
                color = NeutralMedium
              )

              Spacer(modifier = Modifier.height(12.dp))

              Text("තෝරන්න (Select Type):", fontWeight = FontWeight.Bold, fontSize = 12.sp)
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
              ) {
                listOf("SUBJECT" to "විෂය", "NOTE" to "කෙටි සටහන්", "PAPER" to "ප්‍රශ්න පත්‍ර").forEach { (type, label) ->
                  val isSelected = contentTypeToAdd == type
                  Surface(
                    onClick = { contentTypeToAdd = type },
                    shape = RoundedCornerShape(12.dp),
                    color = if (isSelected) BluePrimary else SurfaceVariantLight,
                    modifier = Modifier.weight(1f)
                  ) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(vertical = 8.dp)) {
                      Text(
                        text = label,
                        fontSize = 10.sp,
                        color = if (isSelected) Color.White else NeutralDark,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                      )
                    }
                  }
                }
              }

              if (contentTypeToAdd == "NOTE" || contentTypeToAdd == "PAPER") {
                Spacer(modifier = Modifier.height(12.dp))
                Surface(
                  shape = RoundedCornerShape(12.dp),
                  color = Color(0xFFFFEBEE),
                  border = BorderStroke(1.dp, Color(0xFFFFCDD2)),
                  modifier = Modifier
                    .fillMaxWidth()
                    .clickable { pdfPickerLauncher.launch("application/pdf") }
                ) {
                  Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Icon(
                      imageVector = Icons.Default.AttachFile,
                      contentDescription = "Attach PDF",
                      tint = Color(0xFFC62828)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(modifier = Modifier.weight(1f)) {
                      Text(
                        text = if (selectedPdfFileName != null) "තෝරාගත් PDF: $selectedPdfFileName" else "📄 ඔබගේ PDF ගොනුව තෝරන්න (Select PDF)",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Color(0xFFB71C1C)
                      )
                      Text(
                        text = if (selectedPdfFileName != null) "PDF ගොනුව අමුණා ඇත. වෙනස් කිරීමට තට්ටු කරන්න." else "ෆෝන් එකේ ඇති PDF ගොනුවක් තෝරා ගැනීමට මෙතැන තට්ටු කරන්න.",
                        fontSize = 10.sp,
                        color = Color(0xFFD32F2F)
                      )
                    }
                    if (selectedPdfFileName != null) {
                      Surface(
                        onClick = {
                          selectedPdfUri = null
                          selectedPdfFileName = null
                        },
                        shape = CircleShape,
                        color = Color.White
                      ) {
                        Icon(
                          imageVector = Icons.Default.Delete,
                          contentDescription = "Clear PDF",
                          tint = Color.Red,
                          modifier = Modifier.padding(4.dp).size(16.dp)
                        )
                      }
                    }
                  }
                }
              }

              Spacer(modifier = Modifier.height(12.dp))

              androidx.compose.material3.OutlinedTextField(
                value = inputTitle,
                onValueChange = { inputTitle = it },
                label = { Text("මාතෘකාව / නම (Title in Sinhala)") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
              )

              Spacer(modifier = Modifier.height(8.dp))

              Text("අදාළ විෂය (Target Subject):", fontWeight = FontWeight.Bold, fontSize = 11.sp, color = NeutralDark)
              Spacer(modifier = Modifier.height(4.dp))
              LazyRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                val availableSubList = currentSubjects.map { it.nameSinhala }
                items(availableSubList) { subName ->
                  val isSelected = inputSubject == subName
                  Surface(
                    onClick = { inputSubject = subName },
                    shape = RoundedCornerShape(8.dp),
                    color = if (isSelected) BluePrimary else SurfaceVariantLight,
                    border = BorderStroke(1.dp, if (isSelected) BluePrimary else NeutralBorderLight)
                  ) {
                    Text(
                      text = subName,
                      fontSize = 11.sp,
                      color = if (isSelected) Color.White else NeutralDark,
                      fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                      modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                    )
                  }
                }
              }

              Spacer(modifier = Modifier.height(6.dp))

              androidx.compose.material3.OutlinedTextField(
                value = inputSubject,
                onValueChange = { inputSubject = it },
                label = { Text("විෂය නම / කේතය") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
              )

              Spacer(modifier = Modifier.height(8.dp))

              androidx.compose.material3.OutlinedTextField(
                value = inputExtraInfo,
                onValueChange = { inputExtraInfo = it },
                label = {
                  Text(
                    when (contentTypeToAdd) {
                      "SUBJECT" -> "පාඩම් ගණන (උදා: පාඩම් මාලා 10)"
                      "NOTE" -> "කියවීමේ කාලය (උදා: මිඩිටු 5)"
                      "PAPER" -> "වාරය / වර්ෂය (උදා: 2025 1 වන වාරය)"
                      else -> "ගුරු නම / ධාවන කාලය (උදා: ගුරු සංජය • මිඩිටු 40)"
                    }
                  )
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
              )
            }
          },
          confirmButton = {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
              // 1. DRAFT TO STAGING BUTTON (To be released all together later)
              OutlinedButton(
                onClick = {
                  if (inputTitle.isNotBlank()) {
                    val newId = "draft_${System.currentTimeMillis()}"
                    val gradeTarget = selectedGrade
                    val stagedItem = StagedContentItem(
                      id = newId,
                      type = contentTypeToAdd,
                      gradeTarget = gradeTarget,
                      subject = inputSubject.ifBlank { "විද්‍යාව" },
                      title = inputTitle,
                      extraInfo = inputExtraInfo,
                      pdfUri = selectedPdfUri?.toString(),
                      fileName = selectedPdfFileName,
                      stagedAtTimestamp = System.currentTimeMillis(),
                      formattedDate = "අද දින"
                    )
                    AdminStagingManager.addStagedItem(context, stagedItem, stagedContentItems)
                    Toast.makeText(
                      context,
                      "📦 කෙටුම්පතක් ලෙස එකතු විය! සියල්ල සූදානම් වූ පසු 'එකවර රිලීස් කරන්න' ඔබන්න.",
                      Toast.LENGTH_LONG
                    ).show()

                    inputTitle = ""
                    inputExtraInfo = ""
                    selectedPdfUri = null
                    selectedPdfFileName = null
                    showAddContentDialog = false
                  } else {
                    Toast.makeText(context, "කරුණාකර මාතෘකාව ඇතුළත් කරන්න", Toast.LENGTH_SHORT).show()
                  }
                },
                border = BorderStroke(1.5.dp, Color(0xFFD97706)),
                shape = RoundedCornerShape(10.dp)
              ) {
                Icon(
                  imageVector = Icons.Default.CloudUpload,
                  contentDescription = "Draft Staging",
                  tint = Color(0xFFD97706),
                  modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                  text = "📦 Draft කරන්න (පසුවට)",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF92400E)
                )
              }

              // 2. DIRECT IMMEDIATE LIVE PUBLISH BUTTON
              Button(
                onClick = {
                  if (inputTitle.isNotBlank()) {
                    val newId = System.currentTimeMillis().toString()
                    val gradeTarget = selectedGrade
                    when (contentTypeToAdd) {
                      "SUBJECT" -> {
                        liveSubjectsMap[gradeTarget]?.add(
                          0,
                          SubjectItem(
                            id = newId,
                            name = inputSubject.ifBlank { "SUBJECT" }.uppercase(),
                            nameSinhala = inputTitle,
                            chaptersCount = inputExtraInfo.toIntOrNull() ?: 8,
                            color = BluePrimary,
                            icon = Icons.Default.MenuBook
                          )
                        )
                      }
                      "NOTE" -> {
                        liveNotesMap[gradeTarget]?.add(
                          0,
                          ShortNoteItem(
                            id = newId,
                            subject = inputSubject.ifBlank { "විද්‍යාව" },
                            title = "$gradeTarget වසර - $inputTitle",
                            topicSinhala = inputTitle,
                            readTime = if (selectedPdfFileName != null) "PDF • $selectedPdfFileName" else inputExtraInfo.ifBlank { "මිඩිටු 5" },
                            isPopular = true,
                            pdfUri = selectedPdfUri?.toString(),
                            fileName = selectedPdfFileName
                          )
                        )
                      }
                      "PAPER" -> {
                        livePapersMap[gradeTarget]?.add(
                          0,
                          QuestionPaperItem(
                            id = newId,
                            subject = inputSubject.ifBlank { "විද්‍යාව" },
                            titleSinhala = "$gradeTarget වසර - $inputTitle",
                            year = "2025",
                            term = inputExtraInfo.ifBlank { "1 වන වාරය" },
                            marks = if (selectedPdfFileName != null) "PDF ගොනුව ඇත" else "ලකුණු 100",
                            pdfUri = selectedPdfUri?.toString(),
                            fileName = selectedPdfFileName
                          )
                        )
                      }
                      "VIDEO" -> {
                        liveVideosMap[gradeTarget]?.add(
                          0,
                          VideoLessonItem(
                            id = newId,
                            subject = inputSubject.ifBlank { "විද්‍යාව" },
                            titleSinhala = "$gradeTarget වසර - $inputTitle",
                            duration = inputExtraInfo.ifBlank { "මිඩිටු 40" },
                            tutorName = "දේශක නිපුන් කුමාර",
                            viewsCount = "නැරඹුම් 1.2k",
                            isHd = true
                          )
                        )
                      }
                    }
                    Toast.makeText(context, "අන්තර්ගතය සාර්ථකව Live එකතු විය!", Toast.LENGTH_LONG).show()
                    inputTitle = ""
                    inputExtraInfo = ""
                    selectedPdfUri = null
                    selectedPdfFileName = null
                    showAddContentDialog = false
                  } else {
                    Toast.makeText(context, "කරුණාකර මාතෘකාව ඇතුළත් කරන්න", Toast.LENGTH_SHORT).show()
                  }
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF137333))
              ) {
                Icon(imageVector = Icons.Default.Send, contentDescription = "Publish", modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("⚡ දැන්ම Live", fontSize = 11.sp, fontWeight = FontWeight.Bold)
              }
            }
          },
          dismissButton = {
            TextButton(
              onClick = {
                showAddContentDialog = false
                selectedPdfUri = null
                selectedPdfFileName = null
              }
            ) {
              Text("අවලංගුයි")
            }
          }
        )
      }

      // Interactive Detail Modal Dialog
      activeDetailTitle?.let { title ->
        AlertDialog(
          onDismissRequest = {
            activeDetailTitle = null
            selectedItemPdfUri = null
          },
          title = {
            Text(
              text = title,
              style = MaterialTheme.typography.titleMedium,
              fontWeight = FontWeight.Bold,
              color = NeutralDark
            )
          },
          text = {
            Column {
              if (isVideoModal) {
                // Video Player Mockup Container
                Box(
                  modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Black),
                  contentAlignment = Alignment.Center
                ) {
                  Image(
                    painter = painterResource(id = R.drawable.img_videos_bg_1786110404209),
                    contentDescription = "Video Thumbnail",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                  )
                  Box(
                    modifier = Modifier
                      .fillMaxSize()
                      .background(Color.Black.copy(alpha = 0.45f))
                  )
                  Surface(
                    shape = CircleShape,
                    color = BluePrimary,
                    modifier = Modifier.size(52.dp)
                  ) {
                    Box(contentAlignment = Alignment.Center) {
                      Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Play Video",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                      )
                    }
                  }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                  text = "$selectedGrade වසර සඳහා මෙම වීඩියෝ පාඩම HD තත්ත්වයෙන් සහ සිංහල මාධ්‍යයෙන් නොමිලේ නැරඹිය හැක.",
                  style = MaterialTheme.typography.bodyMedium,
                  color = NeutralMedium
                )
              } else {
                Text(
                  text = "මෙම කොටස $selectedGrade වසර සිසුන් සඳහා සම්පූර්ණයෙන්ම සක්‍රීයව පවතී.",
                  style = MaterialTheme.typography.bodyMedium,
                  color = NeutralMedium
                )
              }

              Spacer(modifier = Modifier.height(12.dp))
              Surface(
                shape = RoundedCornerShape(12.dp),
                color = BluePrimaryContainer,
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(
                  modifier = Modifier.padding(12.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Ready",
                    tint = BluePrimary
                  )
                  Spacer(modifier = Modifier.width(8.dp))
                  Text(
                    text = if (isVideoModal) "මාර්ගගතව නැරඹීමට හෝ භාගත කරගැනීමට සූදානම්." else if (selectedItemPdfUri != null) "ඔබ අමුණන ලද PDF ගොනුව කියවීමට සූදානම්." else "PDF භාගත කිරීම සහ මාර්ගගතව කියවීම පහසුවෙන්ම කළ හැක.",
                    fontSize = 12.sp,
                    color = BlueOnPrimaryContainer
                  )
                }
              }
            }
          },
          confirmButton = {
            Button(
              onClick = {
                performProtectedAction {
                  if (selectedItemPdfUri != null) {
                    iframeModalPdfTitle = activeDetailTitle ?: "PDF ලේඛනය"
                    iframeModalPdfUrl = selectedItemPdfUri ?: ""
                    showIframePdfModal = true
                  } else {
                    val msg = if (isVideoModal) "වීඩියෝව වාදනය වීම ආරම්භ විය" else "භාගත කිරීම ආරම්භ විය"
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                  }
                  activeDetailTitle = null
                  selectedItemPdfUri = null
                }
              },
              colors = ButtonDefaults.buttonColors(containerColor = if (selectedItemPdfUri != null) Color(0xFFC62828) else BluePrimary)
            ) {
              Icon(
                imageVector = if (isVideoModal) Icons.Default.PlayArrow else if (selectedItemPdfUri != null) Icons.Default.PictureAsPdf else Icons.Default.Download,
                contentDescription = "Action"
              )
              Spacer(modifier = Modifier.width(6.dp))
              Text(if (isVideoModal) "Play Video" else if (selectedItemPdfUri != null) "PDF ගොනුව කියවන්න" else "Open / Download")
            }
          },
          dismissButton = {
            TextButton(
              onClick = {
                activeDetailTitle = null
                selectedItemPdfUri = null
              }
            ) {
              Text("Close")
            }
          }
        )
      }

      // 100% Fullscreen Mandatory VPN Blocker Dialog (Blocks app when VPN is active)
      if (isVpnDetected) {
        VpnSecurityBlockDialog(
          onRetry = {
            isVpnDetected = AppSecurityManager.isVpnConnected(context)
            if (!isVpnDetected) {
              Toast.makeText(context, "✅ VPN ක්‍රියාවිරහිත කර ඇත. ආරක්ෂිත සබඳතාවය තහවුරු විය.", Toast.LENGTH_SHORT).show()
            }
          }
        )
      }

      // 100% Fullscreen Mandatory Time Tampering Blocker Dialog (Blocks app when clock is manipulated)
      if (isTimeTamperedDetected) {
        TimeTamperingSecurityBlockDialog(
          onRetry = {
            isTimeTamperedDetected = AppSecurityManager.isTimeTampered(context)
            if (!isTimeTamperedDetected) {
              Toast.makeText(context, "✅ දුරකථන වේලාව නිවැරදි කර ඇත. ආරක්ෂාව තහවුරු විය.", Toast.LENGTH_SHORT).show()
            }
          }
        )
      }

      // Grade Not Approved Alert Modal
      if (showGradeNotApprovedDialog) {
        GradeNotApprovedAlertModal(
          targetGrade = gradeNotApprovedTarget,
          userRequestedPackage = loggedInUser?.requestedGradePackage ?: "නොදන්නා පැකේජය",
          onDismiss = { showGradeNotApprovedDialog = false },
          onRequestApproval = {
            preselectedGradeForApproval = when (gradeNotApprovedTarget) {
              "10" -> "10 ශ්‍රේණිය (Grade 10 Single Pack)"
              "11" -> "11 ශ්‍රේණිය (Grade 11 Single Pack)"
              else -> "10 සහ 11 ශ්‍රේණි (O/L Combo Pack)"
            }
            showPaymentApprovalDialog = true
          }
        )
      }



      // Receipt Preview Fullscreen Modal Dialog
      if (previewReceiptImageUrl != null) {
        ReceiptPreviewDialog(
          receiptUriString = previewReceiptImageUrl!!,
          onDismiss = { previewReceiptImageUrl = null }
        )
      }

      // Auth & Admin Approval Popup Dialog
      if (showAuthRequiredDialog) {
        LoginAndApprovalDialog(
          registeredUsers = registeredUsers,
          initialTab = authDialogInitialTab,
          onLoginSuccess = { user ->
            loggedInUser = user
            val isUserAdmin = isAuthorizedAdminUser(user.usernameOrPhone)
            isAdminAuthenticated = isUserAdmin
            setAdminSessionActive(context, isUserAdmin)
            AppSecurityManager.isAdminSession = isUserAdmin
            saveLoggedInUserPhone(context, user.usernameOrPhone)
            saveUsersToPreferences(context, registeredUsers.toList())
            showAuthRequiredDialog = false
          },
          onAdminLoginSuccess = {
            isAdminAuthenticated = true
            setAdminSessionActive(context, true)
            AppSecurityManager.isAdminSession = true
            showAuthRequiredDialog = false
          },
          onDismiss = { showAuthRequiredDialog = false },
          onUsersUpdated = {
            saveUsersToPreferences(context, registeredUsers.toList())
            loggedInUser?.let { curr ->
              val updated = registeredUsers.find { it.id == curr.id || it.usernameOrPhone == curr.usernameOrPhone }
              if (updated != null) {
                loggedInUser = updated
              }
            }
          },
          onUploadPdfToFirebase = { title, grade, category, subject, uri, fileName ->
            val newId = System.currentTimeMillis().toString()
            val pdfUriString = uri?.toString() ?: "https://firebasestorage.googleapis.com/v0/b/studentportal-app.appspot.com/o/pdfs%2F${grade}%2F${fileName ?: "document.pdf"}?alt=media"
            val fileStr = fileName ?: "Cloud_PDF_$newId.pdf"
            if (category == "NOTE") {
              liveNotesMap[grade]?.add(
                0,
                ShortNoteItem(
                  id = newId,
                  subject = subject.ifBlank { "විද්‍යාව" },
                  title = "$grade වසර - $title",
                  topicSinhala = title,
                  readTime = "🔥 Firebase Cloud • $fileStr",
                  isPopular = true,
                  pdfUri = pdfUriString,
                  fileName = fileStr
                )
              )
            } else {
              livePapersMap[grade]?.add(
                0,
                QuestionPaperItem(
                  id = newId,
                  subject = subject.ifBlank { "විද්‍යාව" },
                  titleSinhala = "$grade වසර - $title",
                  year = "2025",
                  term = "🔥 Firebase Cloud",
                  marks = "PDF ගොනුව ඇත",
                  pdfUri = pdfUriString,
                  fileName = fileStr
                )
              )
            }
          },
          onPickPdf = {
            pdfPickerLauncher.launch("application/pdf")
          },
          selectedPdfFileName = selectedPdfFileName,
          selectedPdfUri = selectedPdfUri,
          onPreviewReceipt = { uriStr ->
            previewReceiptImageUrl = uriStr
          },
          adminBroadcastMessages = adminBroadcastMessages,
          onSendBroadcastMessage = { title, message, priority, targetGrade ->
            val newMsg = AdminBroadcastMessage(
              id = System.currentTimeMillis().toString(),
              title = title,
              message = message,
              priority = priority,
              targetGrade = targetGrade,
              formattedDate = "අද දින (Live)",
              isRead = false
            )
            AdminBroadcastManager.addMessage(context, newMsg, adminBroadcastMessages)
          },
          stagedContentItems = stagedContentItems,
          onReleaseAllStaged = {
            AdminStagingManager.releaseAllStagedToLive(
              context = context,
              stagedList = stagedContentItems,
              liveNotesMap = liveNotesMap,
              livePapersMap = livePapersMap,
              liveVideosMap = liveVideosMap,
              adminBroadcastMessages = adminBroadcastMessages,
              onComplete = { count ->
                Toast.makeText(context, "අන්තර්ගතයන් $count ක් සාර්ථකව Live විය!", Toast.LENGTH_SHORT).show()
              }
            )
          },
          onOpenStagingDialog = { showStagingManagerDialog = true },
          onAddNewContentClick = { showAddContentDialog = true }
        )
      }

      // Master Dedicated Admin Dashboard Dialog (Triggered via top-right circle or Admin Bar)
      if (showAdminDashboardMasterDialog && isAdminAuthenticated && isAdminBarUnlocked) {
        AdminDashboardMasterDialog(
          registeredUsers = registeredUsers,
          adminBroadcastMessages = adminBroadcastMessages,
          stagedContentItems = stagedContentItems,
          initialFilter = adminDashboardInitialFilter,
          onDismiss = {
            showAdminDashboardMasterDialog = false
            adminDashboardInitialFilter = "ALL"
          },
          onUsersUpdated = {
            saveUsersToPreferences(context, registeredUsers.toList())
            loggedInUser?.let { curr ->
              val updated = registeredUsers.find { it.id == curr.id || it.usernameOrPhone == curr.usernameOrPhone }
              if (updated != null) {
                loggedInUser = updated
              }
            }
          },
          onLogoutAdmin = {
            isAdminAuthenticated = false
            isAdminBarUnlocked = false
            showAdminBarUnlockDialog = false
            loggedInUser = null
            setAdminSessionActive(context, false)
            saveLoggedInUserPhone(context, null)
            showAdminDashboardMasterDialog = false
          },
          onPreviewReceipt = { uriStr ->
            previewReceiptImageUrl = uriStr
          },
          onSendBroadcast = { title, message, priority, targetGrade ->
            val newMsg = AdminBroadcastMessage(
              id = System.currentTimeMillis().toString(),
              title = title,
              message = message,
              priority = priority,
              targetGrade = targetGrade,
              formattedDate = "අද දින (Live)",
              isRead = false
            )
            AdminBroadcastManager.addMessage(context, newMsg, adminBroadcastMessages)
            Toast.makeText(context, "නිවේදනය සාර්ථකව විකාශනය විය!", Toast.LENGTH_SHORT).show()
          },
          onReleaseAllStaged = {
            AdminStagingManager.releaseAllStagedToLive(
              context = context,
              stagedList = stagedContentItems,
              liveNotesMap = liveNotesMap,
              livePapersMap = livePapersMap,
              liveVideosMap = liveVideosMap,
              adminBroadcastMessages = adminBroadcastMessages,
              onComplete = { count ->
                Toast.makeText(context, "අන්තර්ගතයන් $count ක් සාර්ථකව Live විය!", Toast.LENGTH_SHORT).show()
              }
            )
          },
          onOpenStagingDialog = { showStagingManagerDialog = true },
          onAddNewContentClick = { showAddContentDialog = true }
        )
      }

      // Dedicated Expired Students List Dialog (Strictly for Admin only - triggered via Admin Bar)
      if (showExpiredStudentsDialog && isAdminAuthenticated && isAdminBarUnlocked) {
        ExpiredStudentsListDialog(
          registeredUsers = registeredUsers,
          onDismiss = { showExpiredStudentsDialog = false },
          onUsersUpdated = {
            saveUsersToPreferences(context, registeredUsers.toList())
          }
        )
      }

      // Persistent Top-Right Circular Admin Badge on Non-Home screens (Strictly visible ONLY to Admin when Admin Bar is unlocked)
      if (isAdminAuthenticated && isAdminBarUnlocked && currentScreen != "HOME") {
        Box(
          modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp, end = 12.dp),
          contentAlignment = Alignment.TopEnd
        ) {
          AdminTopCornerCircleBadge(
            onClick = { showAdminDashboardMasterDialog = true }
          )
        }
      }

      // Step 2 Admin Bar Unlock Dialog (Strictly for verified Admin accounts)
      if (showAdminBarUnlockDialog && isAdminAuthenticated) {
        AdminBarUnlockDialog(
          adminPhoneOrEmail = loggedInUser?.usernameOrPhone ?: "",
          onDismiss = { showAdminBarUnlockDialog = false },
          onUnlockSuccess = {
            isAdminBarUnlocked = true
            showAdminBarUnlockDialog = false
            Toast.makeText(context, "👑 ඇඩ්මින් බාර් එක සහ පරිපාලන කටයුතු සාර්ථකව විවෘත විය!", Toast.LENGTH_LONG).show()
          }
        )
      }

      // Admin Staging Review & Management Dialog (One-Click Live Release)
      if (showStagingManagerDialog) {
        AdminStagingDialog(
          stagedItems = stagedContentItems,
          onDismiss = { showStagingManagerDialog = false },
          onDeleteItem = { id ->
            AdminStagingManager.removeStagedItem(context, id, stagedContentItems)
            Toast.makeText(context, "කෙටුම්පත ඉවත් කරන ලදී", Toast.LENGTH_SHORT).show()
          },
          onClearAll = {
            AdminStagingManager.clearStagedItems(context, stagedContentItems)
            Toast.makeText(context, "සියලු කෙටුම්පත් ඉවත් කරන ලදී", Toast.LENGTH_SHORT).show()
          },
          onReleaseAll = {
            AdminStagingManager.releaseAllStagedToLive(
              context = context,
              stagedList = stagedContentItems,
              liveNotesMap = liveNotesMap,
              livePapersMap = livePapersMap,
              liveVideosMap = liveVideosMap,
              adminBroadcastMessages = adminBroadcastMessages,
              onComplete = { count ->
                Toast.makeText(context, "අන්තර්ගතයන් $count ක් සාර්ථකව Live විය!", Toast.LENGTH_SHORT).show()
              }
            )
          },
          onAddNewClick = {
            showAddContentDialog = true
          }
        )
      }

      // Password Requirement Dialog for Protected PDFs
      if (showPasswordDialog) {
        AlertDialog(
          onDismissRequest = {
            showPasswordDialog = false
            showPasswordError = false
          },
          icon = {
            Icon(
              imageVector = Icons.Default.Lock,
              contentDescription = "Protected PDF",
              tint = Color(0xFFC62828),
              modifier = Modifier.size(32.dp)
            )
          },
          title = {
            Text(
              text = "🔒 මුරපදය ඇතුළත් කරන්න (Password)",
              fontWeight = FontWeight.Bold,
              fontSize = 16.sp,
              color = NeutralDark
            )
          },
          text = {
            Column(modifier = Modifier.fillMaxWidth()) {
              Text(
                text = pendingProtectedPdfTitle,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = Color(0xFFC62828)
              )
              Spacer(modifier = Modifier.height(6.dp))
              Text(
                text = "මෙම PDF ගොනුව මුරපදයකින් (Password) ආරක්ෂිතයි. කරුණාකර විවෘත කිරීමට මුරපදය ඇතුළත් කරන්න.",
                fontSize = 12.sp,
                color = NeutralMedium
              )
              Spacer(modifier = Modifier.height(14.dp))

              var passwordVisible by remember { mutableStateOf(false) }

              androidx.compose.material3.OutlinedTextField(
                value = passwordInputText,
                onValueChange = {
                  passwordInputText = it
                  showPasswordError = false
                },
                label = { Text("මුරපදය (Password)") },
                singleLine = true,
                isError = showPasswordError,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                  IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                      imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                      contentDescription = "Toggle Password"
                    )
                  }
                },
                modifier = Modifier.fillMaxWidth()
              )

              if (showPasswordError) {
                Text(
                  text = "❌ වැරදි මුරපදයකි! කරුණාකර නිවැරදි මුරපදය (1234) ඇතුළත් කරන්න.",
                  color = Color.Red,
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  modifier = Modifier.padding(top = 6.dp)
                )
              }
            }
          },
          confirmButton = {
            Button(
              onClick = {
                if (passwordInputText.trim() == pendingProtectedPdfPassword.trim()) {
                  showPasswordDialog = false
                  showPasswordError = false
                  iframeModalPdfTitle = pendingProtectedPdfTitle
                  iframeModalPdfUrl = pendingProtectedPdfUrl
                  showIframePdfModal = true
                  Toast.makeText(context, "🔒 මුරපදය නිවැරදියි! PDF ගොනුව විවෘත වේ...", Toast.LENGTH_SHORT).show()
                } else {
                  showPasswordError = true
                  Toast.makeText(context, "❌ වැරදි මුරපදයකි!", Toast.LENGTH_SHORT).show()
                }
              },
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC62828)),
              shape = RoundedCornerShape(10.dp)
            ) {
              Icon(Icons.Default.Lock, contentDescription = "Unlock")
              Spacer(modifier = Modifier.width(6.dp))
              Text("විවෘත කරන්න (Unlock)")
            }
          },
          dismissButton = {
            TextButton(
              onClick = {
                showPasswordDialog = false
                showPasswordError = false
              }
            ) {
              Text("අවලංගු කරන්න")
            }
          }
        )
      }

      // Full-Screen Clean PDF Viewer (DRM Protected with Eye-Care & Night Study Mode)
      if (showIframePdfModal) {
        var isFullScreenReadingMode by remember { mutableStateOf(false) }

        Dialog(
          onDismissRequest = { showIframePdfModal = false },
          properties = DialogProperties(
            usePlatformDefaultWidth = false,
            securePolicy = AppSecurityManager.getSecureFlagPolicy()
          )
        ) {
          Surface(
            modifier = Modifier.fillMaxSize(),
            color = when (activeEyeCareMode) {
              EyeCareThemeMode.LIGHT -> Color.White
              EyeCareThemeMode.SEPIA -> Color(0xFFFDF6E2)
              EyeCareThemeMode.DARK -> Color(0xFF0F172A)
              EyeCareThemeMode.BLUE_LIGHT_SHIELD -> Color(0xFF131B2E)
            }
          ) {
            Column(modifier = Modifier.fillMaxSize()) {
              // Ultra-Compact Minimal Top Navigation Bar (Hidden in Full Screen Mode)
              AnimatedVisibility(visible = !isFullScreenReadingMode) {
                Surface(
                  color = when (activeEyeCareMode) {
                    EyeCareThemeMode.LIGHT -> Color(0xFF0F172A)
                    EyeCareThemeMode.SEPIA -> Color(0xFF451A03)
                    EyeCareThemeMode.DARK -> Color(0xFF020617)
                    EyeCareThemeMode.BLUE_LIGHT_SHIELD -> Color(0xFF0B132B)
                  },
                  modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)
                ) {
                  Row(
                    modifier = Modifier
                      .fillMaxSize()
                      .padding(horizontal = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    // Back button
                    IconButton(
                      onClick = { showIframePdfModal = false },
                      modifier = Modifier.size(26.dp)
                    ) {
                      Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Go Back",
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                      )
                    }

                    // PDF Icon
                    Icon(
                      imageVector = Icons.Default.PictureAsPdf,
                      contentDescription = null,
                      tint = Color(0xFFFF5252),
                      modifier = Modifier.size(13.dp)
                    )

                    Spacer(modifier = Modifier.width(3.dp))

                    // Compact Title
                    Text(
                      text = iframeModalPdfTitle.ifBlank { "PDF සටහන්" },
                      fontWeight = FontWeight.Bold,
                      fontSize = 10.sp,
                      color = Color.White,
                      maxLines = 1,
                      overflow = TextOverflow.Ellipsis,
                      modifier = Modifier.weight(1f, fill = false).padding(horizontal = 4.dp)
                    )

                    // Horizontally scrollable tool chips - compact height
                    LazyRow(
                      horizontalArrangement = Arrangement.spacedBy(4.dp),
                      verticalAlignment = Alignment.CenterVertically,
                      modifier = Modifier.weight(1f)
                    ) {
                      // 1. FULLSCREEN PROMINENT BUTTON
                      item {
                        Surface(
                          onClick = { isFullScreenReadingMode = true },
                          shape = RoundedCornerShape(4.dp),
                          color = Color(0xFF0284C7),
                          modifier = Modifier
                            .height(24.dp)
                            .testTag("pdf_fullscreen_btn")
                        ) {
                          Row(
                            modifier = Modifier.padding(horizontal = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                          ) {
                            Text("⛶", fontSize = 10.sp, color = Color.White)
                            Spacer(modifier = Modifier.width(2.dp))
                            Text(
                              text = "ෆුල් ස්ක්‍රීන්",
                              color = Color.White,
                              fontSize = 9.sp,
                              fontWeight = FontWeight.Bold
                            )
                          }
                        }
                      }

                      // 2. Eye-Care Theme Quick Switcher
                      item {
                        Surface(
                          onClick = {
                            val nextMode = when (activeEyeCareMode) {
                              EyeCareThemeMode.LIGHT -> EyeCareThemeMode.DARK
                              EyeCareThemeMode.DARK -> EyeCareThemeMode.SEPIA
                              EyeCareThemeMode.SEPIA -> EyeCareThemeMode.BLUE_LIGHT_SHIELD
                              EyeCareThemeMode.BLUE_LIGHT_SHIELD -> EyeCareThemeMode.LIGHT
                            }
                            activeEyeCareMode = nextMode
                            saveEyeCareTheme(context, nextMode)
                          },
                          shape = RoundedCornerShape(4.dp),
                          color = Color(0xFF1E293B),
                          border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.5f)),
                          modifier = Modifier.height(24.dp)
                        ) {
                          Row(
                            modifier = Modifier.padding(horizontal = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                          ) {
                            Text(activeEyeCareMode.iconEmoji, fontSize = 9.sp)
                            Spacer(modifier = Modifier.width(2.dp))
                            Text(
                              text = when (activeEyeCareMode) {
                                EyeCareThemeMode.LIGHT -> "දිවා"
                                EyeCareThemeMode.SEPIA -> "සේපියා"
                                EyeCareThemeMode.DARK -> "රාත්‍රී"
                                EyeCareThemeMode.BLUE_LIGHT_SHIELD -> "Shield"
                              },
                              color = Color(0xFF38BDF8),
                              fontSize = 8.5.sp,
                              fontWeight = FontWeight.Bold
                            )
                          }
                        }
                      }

                      // 3. Zoom Controls (A- / A+)
                      item {
                        Surface(
                          shape = RoundedCornerShape(4.dp),
                          color = Color(0xFF1E293B),
                          border = BorderStroke(1.dp, Color(0xFF334155)),
                          modifier = Modifier.height(24.dp)
                        ) {
                          Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 2.dp)
                          ) {
                            IconButton(
                              onClick = {
                                val newScale = (activeFontScale - 0.15f).coerceAtLeast(0.85f)
                                activeFontScale = newScale
                                saveFontScale(context, newScale)
                              },
                              modifier = Modifier.size(20.dp)
                            ) {
                              Text("A-", color = Color.White, fontSize = 8.5.sp, fontWeight = FontWeight.Bold)
                            }
                            Text(
                              text = "${(activeFontScale * 100).toInt()}%",
                              color = Color(0xFF94A3B8),
                              fontSize = 8.sp,
                              fontWeight = FontWeight.Bold
                            )
                            IconButton(
                              onClick = {
                                val newScale = (activeFontScale + 0.15f).coerceAtMost(1.45f)
                                activeFontScale = newScale
                                saveFontScale(context, newScale)
                              },
                              modifier = Modifier.size(20.dp)
                            ) {
                              Text("A+", color = Color.White, fontSize = 8.5.sp, fontWeight = FontWeight.Bold)
                            }
                          }
                        }
                      }

                      // 4. Quiz Button
                      item {
                        Surface(
                          onClick = { showPdfQuizBottomSheet = true },
                          shape = RoundedCornerShape(4.dp),
                          color = Color(0xFF4338CA),
                          modifier = Modifier.height(24.dp)
                        ) {
                          Row(
                            modifier = Modifier.padding(horizontal = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                          ) {
                            Text("🧠", fontSize = 9.sp)
                            Spacer(modifier = Modifier.width(2.dp))
                            Text("ක්විස්", color = Color.White, fontSize = 8.5.sp, fontWeight = FontWeight.Bold)
                          }
                        }
                      }

                      // 5. Flashcards Button
                      item {
                        Surface(
                          onClick = { showFlashcardsDialog = true },
                          shape = RoundedCornerShape(4.dp),
                          color = Color(0xFF15803D),
                          modifier = Modifier.height(24.dp)
                        ) {
                          Row(
                            modifier = Modifier.padding(horizontal = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                          ) {
                            Text("💡", fontSize = 9.sp)
                            Spacer(modifier = Modifier.width(2.dp))
                            Text("කාඩ්", color = Color.White, fontSize = 8.5.sp, fontWeight = FontWeight.Bold)
                          }
                        }
                      }

                      // 6. 100-Pages Full PDF (if Math/Sandu)
                      if (iframeModalPdfTitle.contains("ගණිත") || iframeModalPdfTitle.contains("Sandu") || iframeModalPdfTitle.contains("Math")) {
                        item {
                          Surface(
                            onClick = {
                              showIframePdfModal = false
                              sanduTheoryGlobalInitialPage = 1
                              showSanduTheoryFullReaderGlobal = true
                            },
                            shape = RoundedCornerShape(4.dp),
                            color = Color(0xFF4F46E5),
                            modifier = Modifier.height(24.dp)
                          ) {
                            Row(
                              modifier = Modifier.padding(horizontal = 5.dp),
                              verticalAlignment = Alignment.CenterVertically
                            ) {
                              Text("📕", fontSize = 9.sp)
                              Spacer(modifier = Modifier.width(2.dp))
                              Text("පිටු 100ම", color = Color.White, fontSize = 8.5.sp, fontWeight = FontWeight.Bold)
                            }
                          }
                        }
                      }
                    }

                    // Close Button
                    IconButton(
                      onClick = { showIframePdfModal = false },
                      modifier = Modifier.size(26.dp)
                    ) {
                      Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close PDF",
                        tint = Color.White,
                        modifier = Modifier.size(15.dp)
                      )
                    }
                  }
                }
              }

              // Full Screen Clean PDF WebView with Pinch-to-Zoom, Eye-Care CSS Filters and Anti-Copy Protection
              Box(
                modifier = Modifier
                  .weight(1f)
                  .fillMaxWidth()
                  .background(
                    when (activeEyeCareMode) {
                      EyeCareThemeMode.LIGHT -> Color.White
                      EyeCareThemeMode.SEPIA -> Color(0xFFFDF6E2)
                      EyeCareThemeMode.DARK -> Color(0xFF0F172A)
                      EyeCareThemeMode.BLUE_LIGHT_SHIELD -> Color(0xFF131B2E)
                    }
                  )
              ) {
                AndroidView(
                  factory = { ctx ->
                    WebView(ctx).apply {
                      isLongClickable = false
                      isHapticFeedbackEnabled = false
                      setOnLongClickListener { true }

                      // Enable unrestricted vertical and horizontal scrolling
                      isVerticalScrollBarEnabled = true
                      isHorizontalScrollBarEnabled = true
                      isNestedScrollingEnabled = true
                      overScrollMode = android.view.View.OVER_SCROLL_ALWAYS

                      webViewClient = object : WebViewClient() {
                        override fun onPageFinished(view: WebView?, url: String?) {
                          super.onPageFinished(view, url)
                          // Inject CSS & JavaScript to disable text selection, copy, cut, contextmenu, hide Google Drive buttons, enable smooth scrolling, and apply Eye-Care Night/Sepia filters
                          val drmAndEyeCareJs = """
                            (function() {
                              var css = '* { -webkit-user-select: none !important; -moz-user-select: none !important; -ms-user-select: none !important; user-select: none !important; -webkit-touch-callout: none !important; } ' +
                                        'html, body { overflow-y: scroll !important; -webkit-overflow-scrolling: touch !important; height: auto !important; min-height: 100% !important; margin: 0 !important; padding: 0 !important; touch-action: pan-y pan-x !important; } ' +
                                        '.drive-viewer-embed, .drive-viewer-toolstrip, div[role="document"], .ndfHFb-c4YZDc, div[role="main"], iframe, embed { overflow-y: auto !important; -webkit-overflow-scrolling: touch !important; touch-action: pan-y pan-x !important; } ' +
                                        'div[aria-label="Download"], div[aria-label="Print"], div[aria-label="Pop-out"], .ndfHFb-c4YZDc-Wrql6b, button[title="Download"], button[title="Print"], .drive-viewer-toolstrip { display: none !important; pointer-events: none !important; }';
                              var head = document.head || document.getElementsByTagName('head')[0];
                              if (head) {
                                var style = document.createElement('style');
                                style.type = 'text/css';
                                style.appendChild(document.createTextNode(css));
                                head.appendChild(style);
                              }
                              var meta = document.querySelector('meta[name="viewport"]');
                              if (!meta) {
                                meta = document.createElement('meta');
                                meta.name = 'viewport';
                                document.head.appendChild(meta);
                              }
                              meta.setAttribute('content', 'width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=8.0, user-scalable=yes');
                              document.documentElement.style.touchAction = 'pan-y pan-x';
                              document.body.style.touchAction = 'pan-y pan-x';

                              document.addEventListener('contextmenu', function(e) { e.preventDefault(); e.stopPropagation(); return false; }, true);
                              document.addEventListener('copy', function(e) { e.preventDefault(); e.stopPropagation(); return false; }, true);
                              document.addEventListener('cut', function(e) { e.preventDefault(); e.stopPropagation(); return false; }, true);
                              document.addEventListener('selectstart', function(e) { e.preventDefault(); e.stopPropagation(); return false; }, true);
                              document.addEventListener('dragstart', function(e) { e.preventDefault(); e.stopPropagation(); return false; }, true);
                            })();
                          """.trimIndent() + "\n" + getEyeCareWebViewJs(activeEyeCareMode, activeFontScale)

                          view?.evaluateJavascript(drmAndEyeCareJs, null)
                        }

                        override fun shouldOverrideUrlLoading(view: WebView?, request: android.webkit.WebResourceRequest?): Boolean {
                          val destination = request?.url?.toString() ?: ""
                          if (destination.contains("drive.google.com/start") || destination.contains("google.com/drive/start")) {
                            view?.loadUrl(formatToGoogleDriveEmbedUrl(iframeModalPdfUrl))
                            return true
                          }
                          return false
                        }
                      }
                      settings.javaScriptEnabled = true
                      settings.domStorageEnabled = true
                      settings.setSupportZoom(true)
                      settings.builtInZoomControls = true
                      settings.displayZoomControls = false
                      settings.useWideViewPort = true
                      settings.loadWithOverviewMode = true
                      settings.allowFileAccess = true
                      settings.allowContentAccess = true
                      loadUrl(formatToGoogleDriveEmbedUrl(iframeModalPdfUrl))
                    }
                  },
                  update = { webView ->
                    val targetEmbedUrl = formatToGoogleDriveEmbedUrl(iframeModalPdfUrl)
                    if (webView.url != targetEmbedUrl && !webView.url.orEmpty().startsWith(targetEmbedUrl.substringBefore("#"))) {
                      webView.loadUrl(targetEmbedUrl)
                    }
                    // Dynamically re-apply Eye-Care theme & zoom whenever mode/scale changes
                    webView.evaluateJavascript(getEyeCareWebViewJs(activeEyeCareMode, activeFontScale), null)
                  },
                  onRelease = { webView ->
                    webView.stopLoading()
                    webView.destroy()
                  },
                  modifier = Modifier.fillMaxSize()
                )

                // Floating Fullscreen Exit Button when in fullscreen mode
                if (isFullScreenReadingMode) {
                  Surface(
                    onClick = { isFullScreenReadingMode = false },
                    shape = RoundedCornerShape(20.dp),
                    color = Color.Black.copy(alpha = 0.75f),
                    border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.7f)),
                    modifier = Modifier
                      .align(Alignment.TopEnd)
                      .padding(8.dp)
                  ) {
                    Row(
                      modifier = Modifier.padding(horizontal = 9.dp, vertical = 5.dp),
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Exit Fullscreen",
                        tint = Color(0xFF38BDF8),
                        modifier = Modifier.size(14.dp)
                      )
                      Spacer(modifier = Modifier.width(3.dp))
                      Text(
                        text = "සාමාන්‍ය තිරය",
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                      )
                    }
                  }
                } else {
                  // Floating Fullscreen Toggle Button at bottom-right for instant 1-tap immersion
                  Surface(
                    onClick = { isFullScreenReadingMode = true },
                    shape = RoundedCornerShape(18.dp),
                    color = Color(0xFF0F172A).copy(alpha = 0.85f),
                    border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.6f)),
                    modifier = Modifier
                      .align(Alignment.BottomEnd)
                      .padding(10.dp)
                  ) {
                    Row(
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Text("⛶", fontSize = 11.sp, color = Color(0xFF38BDF8))
                      Spacer(modifier = Modifier.width(3.dp))
                      Text(
                        text = "ෆුල් ස්ක්‍රීන්",
                        color = Color.White,
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.Bold
                      )
                    }
                  }
                }

                if (!isFullScreenReadingMode && AppSecurityManager.isDynamicWatermarkEnabled(context)) {
                  SecurityWatermarkOverlay(
                    identifier = loggedInUser?.let { "${it.fullName} • ${it.usernameOrPhone}" } ?: "O/L ශිෂ්‍ය ආරක්ෂිත කියවීම් මාදිලිය"
                  )
                }
              }
            }
          }
        }
      }


      // Sandu Theory 100-Pages Full PDF Book Reader Dialog
      if (showSanduTheoryFullReaderGlobal) {
        SanduTheory100PagesReaderDialog(
          initialPage = sanduTheoryGlobalInitialPage,
          onDismiss = { showSanduTheoryFullReaderGlobal = false }
        )
      }

      // 10 & 11 Sinhala Literature Vichara Dhara (30 Pages, 23 Essays) Full PDF Reader Dialog
      if (showSinhalaVicharaDharaReaderGlobal) {
        SinhalaShortNotesPdfReaderDialog(
          initialPage = sinhalaVicharaGlobalInitialPage,
          onDismiss = { showSinhalaVicharaDharaReaderGlobal = false }
        )
      }

      // 10 & 11 Science Main Diagrams & Cellular Structures (11 Pages) Full PDF Reader Dialog
      if (showScienceDiagramsReaderGlobal) {
        ScienceDiagramsPdfReaderDialog(
          initialPage = scienceDiagramsGlobalInitialPage,
          onDismiss = { showScienceDiagramsReaderGlobal = false }
        )
      }

      // AI Practice Quiz Interactive Engine Dialog (180s Countdown Timer, Shuffling, Review)
      if (activeQuizSet != null) {
        QuizEngineDialog(
          quizSet = activeQuizSet!!,
          onDismiss = { activeQuizSet = null },
          onRetake = { set -> activeQuizSet = set }
        )
      }

      // Flashcards Dialog (Active Recall Mode)
      if (showFlashcardsDialog && selectedSubjectItem != null) {
        FlashcardsViewerDialog(
          grade = selectedGrade,
          subjectName = selectedSubjectItem!!.nameSinhala,
          onDismiss = { showFlashcardsDialog = false }
        )
      }

      // DRM & Screenshot / Screen Record / Copy Alert Dialog
      if (showDrmWarningDialog) {
        AlertDialog(
          onDismissRequest = { showDrmWarningDialog = false },
          icon = {
            Icon(
              imageVector = Icons.Default.Shield,
              contentDescription = "Security Alert",
              tint = Color(0xFFDC2626),
              modifier = Modifier.size(36.dp)
            )
          },
          title = {
            Text(
              text = "🛡️ ආරක්ෂිත අධ්‍යාපනික අන්තර්ගතයකි!",
              fontWeight = FontWeight.Bold,
              fontSize = 16.sp,
              color = Color(0xFF991B1B)
            )
          },
          text = {
            Column {
              Text(
                text = "මෙම යෙදුම තුළ ඇති කෙටි සටහන්, ප්‍රශ්න පත්‍ර සහ අධ්‍යයන අන්තර්ගතයන් $drmWarningReason සිදු කිරීම හෝ පිටපත් කිරීම (Copy/Download) සම්පූර්ණයෙන්ම තහනම් කර ඇත.",
                fontSize = 13.sp,
                color = Color(0xFF1E293B),
                lineHeight = 18.sp
              )
              Spacer(modifier = Modifier.height(10.dp))
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFFEF2F2),
                border = BorderStroke(1.dp, Color(0xFFFECACA))
              ) {
                Text(
                  text = "⚠️ සියලුම අන්තර්ගතයන් ඇප් එක තුළින් පමණක් කියවීම සඳහා සකසා ඇත. පිටපත් කිරීම, භාගත කිරීම හෝ Screen Recording / Screenshot තහනම්ය.",
                  fontSize = 11.sp,
                  color = Color(0xFFB91C1C),
                  modifier = Modifier.padding(10.dp)
                )
              }
            }
          },
          confirmButton = {
            Button(
              onClick = { showDrmWarningDialog = false },
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626))
            ) {
              Text("තේරුම් ගතිමි (OK)")
            }
          }
        )
      }

      // LOCATION 2: Modal Bottom Sheet for PDF Viewer
      if (showPdfQuizBottomSheet) {
        QuizSetsBottomSheet(
          grade = selectedGrade,
          subjectName = selectedSubjectItem?.nameSinhala ?: "විද්‍යාව",
          onDismiss = { showPdfQuizBottomSheet = false },
          onStartQuizSet = { set ->
            performProtectedAction {
              activeQuizSet = set
            }
          },
          onOpenFlashcards = {
            showFlashcardsDialog = true
          }
        )
      }

      // Eye-Care & Night Study Mode Settings Bottom Sheet
      if (showEyeCareSettingsSheet) {
        EyeCareSettingsBottomSheet(
          currentMode = activeEyeCareMode,
          currentFontScale = activeFontScale,
          currentLineSpacing = activeLineSpacing,
          isEyeBreakEnabled = isEyeBreakReminderEnabled,
          onModeChanged = { mode -> activeEyeCareMode = mode },
          onFontScaleChanged = { scale -> activeFontScale = scale },
          onLineSpacingChanged = { spacing -> activeLineSpacing = spacing },
          onEyeBreakToggle = { enabled -> isEyeBreakReminderEnabled = enabled },
          onDismiss = { showEyeCareSettingsSheet = false }
        )
      }

      // App Security & DRM Shield Control Panel Dialog
      if (showSecurityPanelDialog) {
        (context as? Activity)?.let { act ->
          SecurityControlPanelDialog(
            activity = act,
            currentUser = loggedInUser,
            onDismiss = { showSecurityPanelDialog = false }
          )
        }
      }

      // Admin Notification Center Dialog
      if (showNotificationCenterDialog) {
        AdminNotificationCenterDialog(
          messages = adminBroadcastMessages,
          isAdmin = isAdminAuthenticated,
          onDismiss = { showNotificationCenterDialog = false },
          onNewBroadcastCreated = { title, message, priority, targetGrade ->
            val newMsg = AdminBroadcastMessage(
              id = System.currentTimeMillis().toString(),
              title = title,
              message = message,
              priority = priority,
              targetGrade = targetGrade,
              formattedDate = "අද දින (Live)",
              isRead = false
            )
            AdminBroadcastManager.addMessage(context, newMsg, adminBroadcastMessages)
          }
        )
      }

      // Quick Admin Broadcast Message Composer Dialog (from Home FAB)
      if (showAdminBroadcastComposerDialog) {
        Dialog(
          onDismissRequest = { showAdminBroadcastComposerDialog = false },
          properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
          Box(
            modifier = Modifier
              .fillMaxWidth(0.95f)
              .padding(16.dp),
            contentAlignment = Alignment.Center
          ) {
            Column {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
              ) {
                IconButton(onClick = { showAdminBroadcastComposerDialog = false }) {
                  Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.Gray)
                }
              }
              AdminBroadcastComposerBox(
                onSendMessage = { title, message, priority, targetGrade ->
                  val newMsg = AdminBroadcastMessage(
                    id = System.currentTimeMillis().toString(),
                    title = title,
                    message = message,
                    priority = priority,
                    targetGrade = targetGrade,
                    formattedDate = "අද දින (Live)",
                    isRead = false
                  )
                  AdminBroadcastManager.addMessage(context, newMsg, adminBroadcastMessages)
                  showAdminBroadcastComposerDialog = false
                }
              )
            }
          }
        }
      }
    }
  }

        AppLaunchSplashScreen(
          visible = showAppLaunchSplash,
          onDismiss = { showAppLaunchSplash = false }
        )
      }
    }
  }

@Composable
fun LiveCloudSyncHeaderBanner(
  isAdmin: Boolean = false,
  onSyncNow: () -> Unit = {},
  onOpenAddModal: () -> Unit = {},
  onInfoClick: () -> Unit = {}
) {
  Card(
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFFE6F4EA)),
    border = BorderStroke(1.dp, Color(0xFFCEEAD6)),
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp)
      .clickable { onInfoClick() }
      .testTag("live_sync_banner")
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
            .size(38.dp)
            .clip(CircleShape)
            .background(Color(0xFF137333)),
          contentAlignment = Alignment.Center
        ) {
          Icon(
            imageVector = Icons.Default.CloudUpload,
            contentDescription = "Realtime Live Cloud",
            tint = Color.White,
            modifier = Modifier.size(22.dp)
          )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
              modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(Color(0xFF1E8E3E))
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "සජීවී ක්ලවුඩ් සබඳතාවය (100% නොමිලේ)",
              style = MaterialTheme.typography.labelMedium,
              color = Color(0xFF0D652D),
              fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(6.dp))
            Surface(
              shape = RoundedCornerShape(4.dp),
              color = Color(0xFF137333)
            ) {
              Text(
                text = "FREE",
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
              )
            }
          }
          Text(
            text = "සියලුම සිසුන්ට නොමිලේ • සටහන්/ප්‍රශ්න පත්‍ර එසැනින් යාවත්කාලීන වේ",
            style = MaterialTheme.typography.bodySmall,
            color = Color(0xFF137333),
            fontSize = 11.sp
          )
        }
      }

      Spacer(modifier = Modifier.width(6.dp))

      if (isAdmin) {
        Surface(
          onClick = onOpenAddModal,
          shape = RoundedCornerShape(10.dp),
          color = Color(0xFF137333),
          modifier = Modifier.testTag("live_add_btn")
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Icon(
              imageVector = Icons.Default.Add,
              contentDescription = "Add",
              tint = Color.White,
              modifier = Modifier.size(14.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
              text = "එකතු කරන්න",
              style = MaterialTheme.typography.labelSmall,
              color = Color.White,
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold
            )
          }
        }
      } else {
        Surface(
          onClick = onSyncNow,
          shape = RoundedCornerShape(10.dp),
          color = Color.White,
          border = BorderStroke(1.dp, Color(0xFFCEEAD6)),
          modifier = Modifier.testTag("live_sync_btn")
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Icon(
              imageVector = Icons.Default.Refresh,
              contentDescription = "Sync",
              tint = Color(0xFF137333),
              modifier = Modifier.size(14.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
              text = "Sync",
              style = MaterialTheme.typography.labelSmall,
              color = Color(0xFF137333),
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold
            )
          }
        }
      }
    }
  }
}

@Composable
fun FreeCloudInfoDialog(
  onDismiss: () -> Unit,
  onSyncNow: () -> Unit
) {
  AlertDialog(
    onDismissRequest = onDismiss,
    icon = {
      Box(
        modifier = Modifier
          .size(54.dp)
          .clip(CircleShape)
          .background(Color(0xFFE6F4EA)),
        contentAlignment = Alignment.Center
      ) {
        Icon(
          imageVector = Icons.Default.CloudUpload,
          contentDescription = "Cloud Free",
          tint = Color(0xFF137333),
          modifier = Modifier.size(32.dp)
        )
      }
    },
    title = {
      Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
          text = "☁️ සජීවී ක්ලවුඩ් සබඳතාවය",
          fontWeight = FontWeight.Bold,
          fontSize = 16.sp,
          color = Color(0xFF137333)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Surface(
          shape = RoundedCornerShape(6.dp),
          color = Color(0xFF137333)
        ) {
          Text(
            text = "සියලුම පරිශීලකයින්ට 100% නොමිලේ (100% Free for All)",
            color = Color.White,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
          )
        }
      }
    },
    text = {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        Surface(
          shape = RoundedCornerShape(12.dp),
          color = Color(0xFFF1F8E9),
          border = BorderStroke(1.dp, Color(0xFFC8E6C9)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.CheckCircle, contentDescription = "Active", tint = Color(0xFF137333), modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Column {
              Text(
                text = "ක්ලවුඩ් සබඳතාවය සක්‍රීයයි (Active & Online)",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color(0xFF1B5E20)
              )
              Text(
                text = "Google Firebase / Cloud Server හා සම්බන්ධයි",
                fontSize = 10.sp,
                color = Color(0xFF2E7D32)
              )
            }
          }
        }

        Text(
          text = "මෙම පහසුකම කුමක්ද?",
          fontWeight = FontWeight.Bold,
          fontSize = 13.sp,
          color = NeutralDark
        )

        Text(
          text = "මෙම ඇප් එක සතු 'සජීවී ක්ලවුඩ් සබඳතාවය' (Live Realtime Cloud Connection) මගින් ගුරුවරුන් සහ පරිපාලකයින් විසින් අලුතින් එක්කරන සියලුම කෙටි සටහන්, ප්‍රශ්න පත්‍ර සහ වීඩියෝ පාඩම් ඔබගේ දුරකථනයට එසැනින් (Real-time) ගලා ඒම සිදුවේ.",
          fontSize = 12.sp,
          color = NeutralDark,
          lineHeight = 18.sp
        )

        Surface(
          shape = RoundedCornerShape(10.dp),
          color = Color(0xFFE8F5E9),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(verticalAlignment = Alignment.Top) {
              Text("✨", fontSize = 12.sp)
              Spacer(modifier = Modifier.width(6.dp))
              Text("100% නොමිලේ: මෙම සජීවී සබඳතාවය සඳහා කිසිදු පරිශීලකයෙකුගෙන් මුදල් අය නොකෙරේ.", fontSize = 11.sp, color = Color(0xFF1B5E20), fontWeight = FontWeight.Medium)
            }
            Row(verticalAlignment = Alignment.Top) {
              Text("⚡", fontSize = 12.sp)
              Spacer(modifier = Modifier.width(6.dp))
              Text("APK Update අනවශ්‍යයි: අලුත් පාඩම් ලැබීමට ඇප් එක නැවත Play Store එකෙන් Update කිරීමට අවශ්‍ය නොවේ.", fontSize = 11.sp, color = Color(0xFF1B5E20), fontWeight = FontWeight.Medium)
            }
            Row(verticalAlignment = Alignment.Top) {
              Text("🔒", fontSize = 12.sp)
              Spacer(modifier = Modifier.width(6.dp))
              Text("නවතම අධ්‍යයන ද්‍රව්‍ය: Grade 06 සිට 11 දක්වා සියලු නව විෂය කරුණු නොකඩවා ලැබෙයි.", fontSize = 11.sp, color = Color(0xFF1B5E20), fontWeight = FontWeight.Medium)
            }
          }
        }
      }
    },
    confirmButton = {
      Button(
        onClick = onSyncNow,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF137333)),
        shape = RoundedCornerShape(8.dp)
      ) {
        Icon(Icons.Default.Refresh, contentDescription = "Sync", modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.width(6.dp))
        Text("දත්ත Sync කරන්න (නොමිලේ)", fontSize = 11.sp, fontWeight = FontWeight.Bold)
      }
    },
    dismissButton = {
      TextButton(onClick = onDismiss) {
        Text("තේරුම් ගත්තා", fontSize = 11.sp, color = NeutralDark)
      }
    }
  )
}

@Composable
fun SectionHeaderCardWithBg(
  title: String,
  subtitle: String,
  imageRes: Int,
  tag: String,
  onActionClick: () -> Unit
) {
  Card(
    shape = RoundedCornerShape(20.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    border = BorderStroke(1.dp, NeutralBorder),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp)
      .clickable { onActionClick() }
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(115.dp)
    ) {
      Image(
        painter = painterResource(id = imageRes),
        contentDescription = title,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
      )
      Box(
        modifier = Modifier
          .fillMaxSize()
          .background(
            Brush.verticalGradient(
              colors = listOf(
                Color.Black.copy(alpha = 0.2f),
                Color.Black.copy(alpha = 0.75f)
              )
            )
          )
      )
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(14.dp),
        verticalArrangement = Arrangement.SpaceBetween
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = BluePrimary,
          ) {
            Text(
              text = tag,
              color = Color.White,
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
            )
          }

          Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "Go",
            tint = Color.White,
            modifier = Modifier.size(20.dp)
          )
        }

        Column {
          Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
          Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = Color.White.copy(alpha = 0.85f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
        }
      }
    }
  }
}

@Composable
fun SubjectCardRow(
  subject: SubjectItem,
  onClick: () -> Unit,
  onDelete: (() -> Unit)? = null
) {
  Card(
    onClick = onClick,
    shape = RoundedCornerShape(12.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    border = BorderStroke(1.dp, NeutralBorderLight),
    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
    modifier = Modifier.fillMaxWidth()
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 8.dp),
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
            .clip(RoundedCornerShape(10.dp))
            .background(subject.color.copy(alpha = 0.15f)),
          contentAlignment = Alignment.Center
        ) {
          Icon(
            imageVector = subject.icon,
            contentDescription = subject.name,
            tint = subject.color,
            modifier = Modifier.size(20.dp)
          )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column(modifier = Modifier.weight(1f)) {
          Text(
            text = subject.nameSinhala,
            fontSize = 13.5.sp,
            fontWeight = FontWeight.Bold,
            color = NeutralDark,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
          Text(
            text = "${subject.name} • ${subject.chaptersCount} පාඩම් මාලා",
            fontSize = 10.5.sp,
            color = NeutralMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
        }
      }

      Spacer(modifier = Modifier.width(6.dp))

      Surface(
        shape = CircleShape,
        color = SurfaceVariantLight,
        modifier = Modifier.size(28.dp)
      ) {
        Box(contentAlignment = Alignment.Center) {
          Icon(
            imageVector = Icons.Default.MenuBook,
            contentDescription = "Read",
            tint = BluePrimary,
            modifier = Modifier.size(14.dp)
          )
        }
      }
    }
  }
}

@Composable
fun ShortNoteCardRow(
  note: ShortNoteItem,
  onClick: () -> Unit,
  isAdmin: Boolean = false,
  onDelete: (() -> Unit)? = null,
  onOpenPdf: (() -> Unit)? = null,
  onOpenQuiz: (() -> Unit)? = null,
  onOpenFlashcards: (() -> Unit)? = null
) {
  Card(
    onClick = onClick,
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    border = BorderStroke(1.dp, NeutralBorderLight),
    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
    modifier = Modifier.fillMaxWidth()
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)
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
              .size(44.dp)
              .clip(RoundedCornerShape(12.dp))
              .background(if (note.pdfUri != null) Color(0xFFFFEBEE) else BluePrimaryContainer),
            contentAlignment = Alignment.Center
          ) {
            Icon(
              imageVector = if (note.pdfUri != null) Icons.Default.PictureAsPdf else Icons.Default.Description,
              contentDescription = "Notes",
              tint = if (note.pdfUri != null) Color(0xFFC62828) else BluePrimary,
              modifier = Modifier.size(24.dp)
            )
          }

          Spacer(modifier = Modifier.width(12.dp))

          Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text(
                text = note.topicSinhala,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = NeutralDark
              )
              if (note.pdfUri != null || note.fileName != null) {
                Spacer(modifier = Modifier.width(6.dp))
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = Color(0xFFFFEBEE)
                ) {
                  Text(
                    text = "PDF",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFC62828),
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                  )
                }
              } else if (note.isPopular) {
                Spacer(modifier = Modifier.width(6.dp))
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = Color(0xFFFFECEB)
                ) {
                  Text(
                    text = "HOT",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFD93025),
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                  )
                }
              }
            }
            Text(
              text = if (note.fileName != null) "${note.subject} • ${note.fileName}" else "${note.subject} • කියවීමේ කාලය ${note.readTime}",
              style = MaterialTheme.typography.bodySmall,
              color = NeutralMedium
            )
          }
        }

        if (isAdmin && onDelete != null) {
          Surface(
            onClick = onDelete,
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFFFEE2E2),
            border = BorderStroke(1.dp, Color(0xFFFCA5A5)),
            modifier = Modifier.padding(start = 6.dp)
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete PDF",
                tint = Color(0xFFDC2626),
                modifier = Modifier.size(15.dp)
              )
              Spacer(modifier = Modifier.width(3.dp))
              Text(
                text = "Delete",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFDC2626)
              )
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(10.dp))
      HorizontalDivider(color = Color(0xFFF1F5F9))
      Spacer(modifier = Modifier.height(8.dp))

      // Action Chips: PDF View, 10 Quiz Sets (100 MCQs), Flashcards
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        if (note.pdfUri != null && onOpenPdf != null) {
          Surface(
            onClick = onOpenPdf,
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFFFFEBEE),
            border = BorderStroke(0.5.dp, Color(0xFFFFCDD2))
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Icon(
                imageVector = Icons.Default.PictureAsPdf,
                contentDescription = "Open PDF",
                tint = Color(0xFFC62828),
                modifier = Modifier.size(13.dp)
              )
              Spacer(modifier = Modifier.width(3.dp))
              Text(
                text = "PDF බලන්න",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFC62828)
              )
            }
          }
        }

        Surface(
          onClick = {
            if (onOpenQuiz != null) onOpenQuiz() else if (onOpenPdf != null) onOpenPdf()
          },
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFFEEF2FF),
          border = BorderStroke(0.5.dp, Color(0xFFC7D2FE))
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text("🧠", fontSize = 11.sp)
            Spacer(modifier = Modifier.width(3.dp))
            Text(
              text = "10 Sets (100 MCQs)",
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF4338CA)
            )
          }
        }

        Surface(
          onClick = {
            if (onOpenFlashcards != null) onOpenFlashcards() else if (onOpenPdf != null) onOpenPdf()
          },
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFFF0FDF4),
          border = BorderStroke(0.5.dp, Color(0xFFBBF7D0))
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text("💡", fontSize = 11.sp)
            Spacer(modifier = Modifier.width(3.dp))
            Text(
              text = "Flashcards",
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF15803D)
            )
          }
        }
      }
    }
  }
}

@Composable
fun QuestionPaperCardRow(
  paper: QuestionPaperItem,
  onClick: () -> Unit,
  isAdmin: Boolean = false,
  onDelete: (() -> Unit)? = null,
  onOpenPdf: (() -> Unit)? = null
) {
  Card(
    onClick = onClick,
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    border = BorderStroke(1.dp, NeutralBorderLight),
    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
    modifier = Modifier.fillMaxWidth()
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
            .size(44.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(if (paper.pdfUri != null) Color(0xFFFFEBEE) else Color(0xFFE6F4EA)),
          contentAlignment = Alignment.Center
        ) {
          Icon(
            imageVector = if (paper.pdfUri != null) Icons.Default.PictureAsPdf else Icons.Default.Quiz,
            contentDescription = "Paper",
            tint = if (paper.pdfUri != null) Color(0xFFC62828) else Color(0xFF137333),
            modifier = Modifier.size(24.dp)
          )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column {
          Text(
            text = paper.titleSinhala,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = NeutralDark
          )
          Text(
            text = if (paper.fileName != null) "${paper.subject} • ${paper.fileName}" else "${paper.subject} • ${paper.year} ${paper.term} • ${paper.marks}",
            style = MaterialTheme.typography.bodySmall,
            color = NeutralMedium
          )
        }
      }

      Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        if (paper.pdfUri != null && onOpenPdf != null) {
          Surface(
            onClick = onOpenPdf,
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFFFFEBEE)
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Icon(
                imageVector = Icons.Default.PictureAsPdf,
                contentDescription = "Open PDF",
                tint = Color(0xFFC62828),
                modifier = Modifier.size(14.dp)
              )
              Spacer(modifier = Modifier.width(4.dp))
              Text(
                text = "බලන්න",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFC62828)
              )
            }
          }
        } else {
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = BluePrimaryContainer
          ) {
            Text(
              text = "PDF",
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              color = BlueOnPrimaryContainer,
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
          }
        }

        if (isAdmin && onDelete != null) {
          Surface(
            onClick = onDelete,
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFFFEE2E2),
            border = BorderStroke(1.dp, Color(0xFFFCA5A5))
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete Paper",
                tint = Color(0xFFDC2626),
                modifier = Modifier.size(15.dp)
              )
              Spacer(modifier = Modifier.width(3.dp))
              Text(
                text = "Delete",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFDC2626)
              )
            }
          }
        }
      }
    }
  }
}

@Composable
fun VideoLessonCardRow(
  video: VideoLessonItem,
  onClick: () -> Unit,
  isAdmin: Boolean = false,
  onDelete: (() -> Unit)? = null
) {
  Card(
    onClick = onClick,
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    border = BorderStroke(1.dp, NeutralBorderLight),
    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
    modifier = Modifier.fillMaxWidth()
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
            .size(48.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFFEF7E0)),
          contentAlignment = Alignment.Center
        ) {
          Icon(
            imageVector = Icons.Default.PlayCircleFilled,
            contentDescription = "Play Video",
            tint = Color(0xFFB06000),
            modifier = Modifier.size(30.dp)
          )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
              text = video.titleSinhala,
              style = MaterialTheme.typography.titleSmall,
              fontWeight = FontWeight.Bold,
              color = NeutralDark
            )
            if (video.isHd) {
              Spacer(modifier = Modifier.width(6.dp))
              Surface(
                shape = RoundedCornerShape(4.dp),
                color = BluePrimary
              ) {
                Text(
                  text = "HD",
                  fontSize = 8.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                )
              }
            }
          }
          Text(
            text = "${video.subject} • ${video.tutorName} • ${video.duration}",
            style = MaterialTheme.typography.bodySmall,
            color = NeutralMedium
          )
        }
      }

      Surface(
        shape = RoundedCornerShape(12.dp),
        color = SurfaceVariantLight
      ) {
        Row(
          modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Icon(
            imageVector = Icons.Default.OndemandVideo,
            contentDescription = "Views",
            tint = NeutralMedium,
            modifier = Modifier.size(14.dp)
          )
          Spacer(modifier = Modifier.width(4.dp))
          Text(
            text = video.viewsCount,
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium,
            color = NeutralMedium
          )
        }
      }
    }
  }
}

@Composable
fun TopHeaderSection(
  userName: String,
  userStream: String,
  isApproved: Boolean,
  isAdmin: Boolean = false,
  eyeCareMode: EyeCareThemeMode = EyeCareThemeMode.LIGHT,
  unreadNotificationCount: Int = 0,
  onEyeCareClick: () -> Unit = {},
  onSecurityClick: () -> Unit = {},
  onAuthClick: () -> Unit,
  onNotificationClick: () -> Unit,
  onAdminDashboardClick: () -> Unit = {}
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 12.dp, vertical = 6.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.weight(1f)
    ) {
      Box(
        modifier = Modifier
          .size(36.dp)
          .clip(CircleShape)
          .background(
            when {
              isAdmin -> Color(0xFF1E3A8A)
              isApproved -> Color(0xFF137333)
              else -> BluePrimary
            }
          ),
        contentAlignment = Alignment.Center
      ) {
        Icon(
          imageVector = when {
            isAdmin -> Icons.Default.AdminPanelSettings
            isApproved -> Icons.Default.Verified
            else -> Icons.Default.Person
          },
          contentDescription = "User",
          tint = Color.White,
          modifier = Modifier.size(20.dp)
        )
      }

      Spacer(modifier = Modifier.width(8.dp))

      Column(
        modifier = Modifier.weight(1f),
        verticalArrangement = Arrangement.Center
      ) {
        Text(
          text = userName,
          fontSize = 13.sp,
          color = NeutralDark,
          fontWeight = FontWeight.Bold,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )
        Text(
          text = userStream,
          fontSize = 11.sp,
          color = NeutralMedium,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )
      }
    }

    Spacer(modifier = Modifier.width(6.dp))

    Row(
      verticalAlignment = Alignment.CenterVertically
    ) {
      // Eye-Care Mode Indicator Chip
      Surface(
        onClick = onEyeCareClick,
        shape = CircleShape,
        color = when (eyeCareMode) {
          EyeCareThemeMode.LIGHT -> Color(0xFFEFF6FF)
          EyeCareThemeMode.SEPIA -> Color(0xFFF5EACF)
          EyeCareThemeMode.DARK -> Color(0xFF1E293B)
          EyeCareThemeMode.BLUE_LIGHT_SHIELD -> Color(0xFF1C273E)
        },
        border = BorderStroke(
          1.dp,
          when (eyeCareMode) {
            EyeCareThemeMode.LIGHT -> Color(0xFFBFDBFE)
            EyeCareThemeMode.SEPIA -> Color(0xFFD6C4A5)
            EyeCareThemeMode.DARK -> Color(0xFF475569)
            EyeCareThemeMode.BLUE_LIGHT_SHIELD -> Color(0xFFF59E0B)
          }
        ),
        modifier = Modifier
          .padding(end = 6.dp)
          .size(32.dp)
          .testTag("eyecare_header_button")
      ) {
        Box(
          modifier = Modifier.fillMaxSize(),
          contentAlignment = Alignment.Center
        ) {
          Text(eyeCareMode.iconEmoji, fontSize = 14.sp)
        }
      }

      // Security & Anti-Hacking DRM Shield Status Chip
      Surface(
        onClick = onSecurityClick,
        shape = CircleShape,
        color = Color(0xFFECFDF5),
        border = BorderStroke(1.dp, Color(0xFF10B981)),
        modifier = Modifier
          .padding(end = 6.dp)
          .size(32.dp)
          .testTag("security_header_button")
      ) {
        Box(
          modifier = Modifier.fillMaxSize(),
          contentAlignment = Alignment.Center
        ) {
          Icon(
            imageVector = Icons.Default.Security,
            contentDescription = "Security Shield",
            tint = Color(0xFF059669),
            modifier = Modifier.size(16.dp)
          )
        }
      }

      Surface(
        onClick = onAuthClick,
        shape = RoundedCornerShape(10.dp),
        color = when {
          isAdmin -> Color(0xFFE0E7FF)
          isApproved -> Color(0xFFE6F4EA)
          else -> Color(0xFFFFF3E0)
        },
        border = BorderStroke(
          1.dp,
          when {
            isAdmin -> Color(0xFFC7D2FE)
            isApproved -> Color(0xFFCEEAD6)
            else -> Color(0xFFFFE0B2)
          }
        ),
        modifier = Modifier.padding(end = 6.dp).testTag("auth_status_chip")
      ) {
        Row(
          modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Icon(
            imageVector = when {
              isAdmin -> Icons.Default.AdminPanelSettings
              isApproved -> Icons.Default.CheckCircle
              else -> Icons.Default.Lock
            },
            contentDescription = "Auth",
            tint = when {
              isAdmin -> Color(0xFF1E3A8A)
              isApproved -> Color(0xFF137333)
              else -> Color(0xFFE65100)
            },
            modifier = Modifier.size(13.dp)
          )
          Spacer(modifier = Modifier.width(3.dp))
          Text(
            text = when {
              isAdmin -> "Admin"
              isApproved -> "සක්‍රීයයි"
              else -> "ලොගින්"
            },
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = when {
              isAdmin -> Color(0xFF1E3A8A)
              isApproved -> Color(0xFF137333)
              else -> Color(0xFFE65100)
            }
          )
        }
      }

      // App Share Button with GitHub Release Direct Download Link
      val shareContext = LocalContext.current
      Surface(
        onClick = {
          val shareText = """
අ.පො.ස. සාමාන්‍ය පෙළ (10 සහ 11 වසර) හදාරන දූදරුවන්ටම විශේෂයි! 📚✨

ඔන්න ඔබේ විභාග සාර්ථක කරගන්න අවශ්‍ය සියලුම පහසුකම් දැන් එකම ඇප් එකකින්!

පහත විශේෂාංග රැසක් මෙහි අන්තර්ගත වේ:

10 සහ 11 ශ්‍රේණි සඳහා අදාළ සියලුම විෂයන්ගේ කෙටි සටහන් කට්ටල 📖

සියලුම විෂයන්ගේ වාර විභාග ප්‍රශ්න පත්‍ර සහ වාර විභාග අනුමාන ප්‍රශ්න පත්‍ර 500ක් (සජීවීව උත්තර දී ප්‍රතිඵල බලාගත හැක) 📝

සා/පෙළ පසුගිය ප්‍රශ්න පත්‍ර හා අනුමාන ප්‍රශ්න පත්‍ර 🎯

සෑම විෂයකම පාඩමින් පාඩමට ප්‍රශ්න කාණ්ඩ සහ ක්විස් (Quizzes) ආකාරයේ ප්‍රශ්න 20,000ක් ❓

කෙටි ප්‍රශ්න හා සත්‍ය/අසත්‍ය ප්‍රකාශන ප්‍රශ්න 30,000ක් 💡

සවන් දිය හැකි ආකාරයේ වොයිස් (Voice) ආශ්‍රිත පාඩම් 300ක් 🎧

සෑම විෂයකටම විශේෂාංග කොටසක් සහ විද්‍යාව, ඉතිහාසය විෂයන් සඳහා විශේෂ පාඩම් මාලා, මතක තබා ගැනීමේ ක්‍රමවේද හා සිතියම් 🗺️

ගණිතය කෙටි ප්‍රශ්න 4,000ක්

ඉංග්‍රීසි භාෂාව මුල සිටම උගන්වන විශේෂ පන්ති විශේෂාංග 🇬🇧

මේ සියල්ල දැන්ම ලබාගෙන ඔබේ විභාග ජයග්‍රහණය තහවුරු කරගන්න!
🎁👇


Playstore හරහා O/L Guru ඇප් එක ඩවුන්ලෝඩ් කරගන්න🤘🤘🤘
""".trimIndent()
          val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, "O/L Guru App")
            putExtra(Intent.EXTRA_TEXT, shareText)
          }
          try {
            shareContext.startActivity(Intent.createChooser(shareIntent, "Share App Link"))
          } catch (_: Exception) {
            Toast.makeText(shareContext, "Sharing feature initialized", Toast.LENGTH_SHORT).show()
          }
        },
        shape = CircleShape,
        color = Color(0xFFEFF6FF),
        border = BorderStroke(1.dp, Color(0xFF3B82F6)),
        modifier = Modifier
          .padding(end = 6.dp)
          .size(32.dp)
          .testTag("app_share_header_button")
      ) {
        Box(
          modifier = Modifier.fillMaxSize(),
          contentAlignment = Alignment.Center
        ) {
          Icon(
            imageVector = Icons.Default.Share,
            contentDescription = "Share App",
            tint = Color(0xFF1D4ED8),
            modifier = Modifier.size(16.dp)
          )
        }
      }

      // Attention-Grabbing Notification Bell Circle
      AdminNotificationBellCircle(
        unreadCount = unreadNotificationCount,
        onClick = onNotificationClick,
        modifier = Modifier.testTag("notification_button")
      )

      // DEDICATED ADMIN SMALL CIRCLE ON THE TOP RIGHT (Strictly shown ONLY when isAdmin == true)
      if (isAdmin) {
        Spacer(modifier = Modifier.width(6.dp))
        AdminTopCornerCircleBadge(
          onClick = onAdminDashboardClick
        )
      }
    }
  }
}

@Composable
fun SecuritySubscriptionBanner(
  isApproved: Boolean = false,
  isFeatureTrialActive: Boolean = true,
  remainingTrialHours: Int = 24,
  remainingTrialMinutes: Int = 0,
  isApprovalExpired: Boolean = false,
  remainingApprovalDays: Int = 180,
  onClick: () -> Unit = {}
) {
  val containerColor = when {
    isApprovalExpired -> Color(0xFFFEF2F2)
    isApproved -> Color(0xFFE8F5E9)
    isFeatureTrialActive -> Color(0xFFF0FDF4)
    else -> Color(0xFFFFF8E1)
  }
  val borderColor = when {
    isApprovalExpired -> Color(0xFFFCA5A5)
    isApproved -> Color(0xFFA5D6A7)
    isFeatureTrialActive -> Color(0xFF86EFAC)
    else -> Color(0xFFFFD54F)
  }
  val badgeColor = when {
    isApprovalExpired -> Color(0xFFDC2626)
    isApproved -> Color(0xFF137333)
    isFeatureTrialActive -> Color(0xFF047857)
    else -> Color(0xFFE65100)
  }

  Card(
    shape = RoundedCornerShape(12.dp),
    colors = CardDefaults.cardColors(containerColor = containerColor),
    border = BorderStroke(1.dp, borderColor),
    modifier = Modifier
      .fillMaxWidth()
      .clickable { onClick() }
      .testTag("security_banner")
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 8.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.weight(1f)
      ) {
        Box(
          modifier = Modifier
            .size(30.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(badgeColor),
          contentAlignment = Alignment.Center
        ) {
          Icon(
            imageVector = when {
              isApprovalExpired -> Icons.Default.Lock
              isApproved -> Icons.Default.Verified
              isFeatureTrialActive -> Icons.Default.AutoAwesome
              else -> Icons.Default.WorkspacePremium
            },
            contentDescription = "Badge",
            tint = Color.White,
            modifier = Modifier.size(16.dp)
          )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Column(modifier = Modifier.weight(1f)) {
          Text(
            text = when {
              isApprovalExpired -> "⚠️ මාස 6 අනුමැතිය අවසන් (දින 180 සම්පූර්ණයි)"
              isApproved -> "UNLIMITED ACCESS (දින $remainingApprovalDays ඉතිරියයි)"
              isFeatureTrialActive -> "⏳ පැය 24 නොමිලේ අත්හදා බැලීම (24h Free Trial)"
              else -> "🔒 නොමිලේ කාලය අවසන් • ඇඩ්මින් අනුමැතිය අවශ්‍යයි"
            },
            fontSize = 11.sp,
            color = badgeColor,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
          Text(
            text = when {
              isApprovalExpired -> "දින 180 අවසන් • රු. 1,000 ගෙවා අනුමැතිය අලුත් කරන්න"
              isApproved -> "මාස 6 ක පූර්ණ අනුමැතිය සක්‍රීයයි • Official Access"
              isFeatureTrialActive -> "⚡ ඉතිරි කාලය: පැය ${remainingTrialHours} යි විනාඩි ${remainingTrialMinutes} යි • පැය 24 පසු ඇඩ්මින් අනුමැතිය අවශ්‍යයි"
              else -> "විශේෂාංග හා අනු කොටස් පරිශීලනයට ඇඩ්මින් අනුමැතිය (Admin Approval) ලබාගන්න"
            },
            color = when {
              isApprovalExpired -> Color(0xFFB91C1C)
              isApproved -> Color(0xFF1B5E20)
              isFeatureTrialActive -> Color(0xFF047857)
              else -> Color(0xFFB45309)
            },
            fontSize = 10.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
        }
      }

      Spacer(modifier = Modifier.width(6.dp))

      Surface(
        shape = RoundedCornerShape(6.dp),
        color = badgeColor
      ) {
        Row(
          modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            text = when {
              isApprovalExpired -> "රු. 1000"
              isApproved -> "ACTIVE"
              isFeatureTrialActive -> "${remainingTrialHours}h ${remainingTrialMinutes}m"
              else -> "අනුමැතිය"
            },
            color = Color.White,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold
          )
        }
      }
    }
  }
}

/**
 * Dedicated Persistent Admin Bar (Strictly visible ONLY to Admin)
 * Displays Pending, Active, and Expired Students with direct 1-tap filtering
 */
@Composable
fun AdminControlBannerBar(
  pendingCount: Int,
  approvedCount: Int,
  expiredCount: Int,
  onOpenDashboard: (String) -> Unit,
  onOpenExpiredList: () -> Unit,
  onLockBar: (() -> Unit)? = null,
  modifier: Modifier = Modifier
) {
  Card(
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
    border = BorderStroke(1.5.dp, Color(0xFFF59E0B)),
    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 4.dp)
      .testTag("admin_main_control_bar")
  ) {
    Column(modifier = Modifier.padding(10.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Icon(
            imageVector = Icons.Default.AdminPanelSettings,
            contentDescription = "Admin",
            tint = Color(0xFFFBBF24),
            modifier = Modifier.size(18.dp)
          )
          Spacer(modifier = Modifier.width(6.dp))
          Text(
            text = "👑 Admin Bar (පරිපාලක පාලන තීරුව)",
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = Color.White
          )
        }

        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
          if (onLockBar != null) {
            Surface(
              onClick = onLockBar,
              shape = RoundedCornerShape(8.dp),
              color = Color(0xFF7F1D1D),
              border = BorderStroke(1.dp, Color(0xFFEF4444)),
              modifier = Modifier.testTag("admin_bar_lock_action_button")
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Icon(
                  imageVector = Icons.Default.Lock,
                  contentDescription = "Lock Admin Bar",
                  tint = Color(0xFFFCA5A5),
                  modifier = Modifier.size(12.dp)
                )
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                  text = "අගුළුලන්න",
                  fontSize = 9.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFFFCA5A5)
                )
              }
            }
          }

          Surface(
            onClick = { onOpenDashboard("ALL") },
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFF1E293B),
            border = BorderStroke(1.dp, Color(0xFF334155))
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = "පාලක මධ්‍යස්ථානය ⚙️",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF93C5FD)
              )
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        // Pending approvals chip
        Surface(
          onClick = { onOpenDashboard("PENDING") },
          shape = RoundedCornerShape(8.dp),
          color = if (pendingCount > 0) Color(0xFF7F1D1D) else Color(0xFF1E293B),
          border = BorderStroke(1.dp, if (pendingCount > 0) Color(0xFFEF4444) else Color(0xFF334155)),
          modifier = Modifier.weight(1f)
        ) {
          Column(
            modifier = Modifier.padding(vertical = 6.dp, horizontal = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text(
              text = "$pendingCount",
              fontSize = 14.sp,
              fontWeight = FontWeight.Bold,
              color = if (pendingCount > 0) Color(0xFFFCA5A5) else Color(0xFF94A3B8)
            )
            Text(
              text = "⏳ අනුමැතියට",
              fontSize = 9.sp,
              fontWeight = FontWeight.Medium,
              color = Color.White,
              maxLines = 1
            )
          }
        }

        // Active approved chip (6 months active)
        Surface(
          onClick = { onOpenDashboard("APPROVED") },
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFF064E3B),
          border = BorderStroke(1.dp, Color(0xFF10B981)),
          modifier = Modifier.weight(1f)
        ) {
          Column(
            modifier = Modifier.padding(vertical = 6.dp, horizontal = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text(
              text = "$approvedCount",
              fontSize = 14.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF6EE7B7)
            )
            Text(
              text = "✅ සක්‍රීය (මාස 6)",
              fontSize = 9.sp,
              fontWeight = FontWeight.Medium,
              color = Color.White,
              maxLines = 1
            )
          }
        }

        // Expired students chip (Separate list!)
        Surface(
          onClick = onOpenExpiredList,
          shape = RoundedCornerShape(8.dp),
          color = if (expiredCount > 0) Color(0xFF881337) else Color(0xFF1E293B),
          border = BorderStroke(1.dp, if (expiredCount > 0) Color(0xFFF43F5E) else Color(0xFF334155)),
          modifier = Modifier.weight(1f)
        ) {
          Column(
            modifier = Modifier.padding(vertical = 6.dp, horizontal = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text(
              text = "$expiredCount",
              fontSize = 14.sp,
              fontWeight = FontWeight.Bold,
              color = if (expiredCount > 0) Color(0xFFFDA4AF) else Color(0xFF94A3B8)
            )
            Text(
              text = "⚠️ මාස 6 අවසන්",
              fontSize = 9.sp,
              fontWeight = FontWeight.Bold,
              color = if (expiredCount > 0) Color(0xFFFFD1D9) else Color.White,
              maxLines = 1
            )
          }
        }
      }

      // Dedicated High-Priority Alert Strip in Admin Bar for New Pending Approvals
      if (pendingCount > 0) {
        Spacer(modifier = Modifier.height(8.dp))
        Surface(
          onClick = { onOpenDashboard("PENDING") },
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFF7F1D1D),
          border = BorderStroke(1.2.dp, Color(0xFFEF4444)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 7.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
              Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Pending Alert",
                tint = Color(0xFFFCA5A5),
                modifier = Modifier.size(16.dp)
              )
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = "🚨 නව අනුමැති ඉල්ලීම් $pendingCount ක් ඇත! (පරීක්ෂා කර අනුමත කරන්න)",
                fontSize = 10.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
              )
            }
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFFDC2626)
            ) {
              Text(
                text = "අනුමත කරන්න ❯",
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
          }
        }
      }

      // Dedicated Alert Strip in Admin Bar for Expired Students
      if (expiredCount > 0) {
        Spacer(modifier = Modifier.height(8.dp))
        Surface(
          onClick = onOpenExpiredList,
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFF4C0519),
          border = BorderStroke(1.dp, Color(0xFFF43F5E)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
              Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "Expired Alert",
                tint = Color(0xFFFB7185),
                modifier = Modifier.size(15.dp)
              )
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = "⚠️ මාස 6 සම්පූර්ණ වූ සිසුන් $expiredCount කගේ ප්‍රවේශය අත්හිටුවා ඇත",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFFE4E6),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
              )
            }
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFFE11D48)
            ) {
              Text(
                text = "වෙනම ලැයිස්තුව ❯",
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
          }
        }
      }
    }
  }
}

/**
 * Security Banner shown to verified Admin (Step 1 passed) when Admin Bar is still locked (Step 2 pending).
 */
@Composable
fun AdminBarLockedSecurityBanner(
  adminIdentifier: String,
  onUnlockClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Card(
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
    border = BorderStroke(1.5.dp, Color(0xFFF59E0B)),
    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 4.dp)
      .testTag("admin_bar_locked_banner")
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Row(
        modifier = Modifier.weight(1f),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Surface(
          shape = CircleShape,
          color = Color(0xFFB45309),
          modifier = Modifier.size(36.dp)
        ) {
          Box(contentAlignment = Alignment.Center) {
            Icon(
              imageVector = Icons.Default.Lock,
              contentDescription = "Admin Bar Locked",
              tint = Color.White,
              modifier = Modifier.size(18.dp)
            )
          }
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
              text = "🔒 Admin Bar අගුළුලා ඇත",
              fontWeight = FontWeight.Bold,
              fontSize = 12.5.sp,
              color = Color.White
            )
            Spacer(modifier = Modifier.width(6.dp))
            Surface(
              shape = RoundedCornerShape(4.dp),
              color = Color(0xFF1E293B)
            ) {
              Text(
                text = "Step 2",
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFBBF24),
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
              )
            }
          }
          Spacer(modifier = Modifier.height(2.dp))
          Text(
            text = "පරිපාලන තීරුව පෙන්වීමට Username සහ Password එක් කරන්න",
            fontSize = 10.5.sp,
            color = Color(0xFFCBD5E1),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
        }
      }

      Spacer(modifier = Modifier.width(8.dp))

      Button(
        onClick = onUnlockClick,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD97706)),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
        modifier = Modifier.testTag("unlock_admin_bar_button")
      ) {
        Icon(
          imageVector = Icons.Default.LockOpen,
          contentDescription = "Unlock",
          tint = Color.White,
          modifier = Modifier.size(14.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "Unlock",
          fontSize = 11.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White
        )
      }
    }
  }
}

/**
 * Step 2 Unlock Dialog for Admin Bar & Administrative Operations.
 * Requires Username: "Akila Prabhath Disanayaka" and Password: "A20020521PD".
 */
@Composable
fun AdminBarUnlockDialog(
  adminPhoneOrEmail: String,
  onDismiss: () -> Unit,
  onUnlockSuccess: () -> Unit
) {
  var usernameInput by remember { mutableStateOf("") }
  var nicInput by remember { mutableStateOf("") }
  var passwordInput by remember { mutableStateOf("") }
  var passwordVisible by remember { mutableStateOf(false) }
  var errorMessage by remember { mutableStateOf<String?>(null) }

  AlertDialog(
    onDismissRequest = onDismiss,
    title = {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
          imageVector = Icons.Default.Security,
          contentDescription = "Admin Security",
          tint = Color(0xFFF59E0B),
          modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "ඇඩ්මින් බාර් එක විවෘත කිරීම (Step 2)",
          fontWeight = FontWeight.Bold,
          fontSize = 15.sp
        )
      }
    },
    text = {
      Column(modifier = Modifier.fillMaxWidth()) {
        Text(
          text = "බලයලත් ඇඩ්මින් ගිණුම් සත්‍යාපනය",
          fontSize = 12.sp,
          fontWeight = FontWeight.SemiBold,
          color = Color(0xFF1E3A8A)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = "ඇඩ්මින් බාර් එක සහ පරිපාලන කටයුතු වෙත ප්‍රවේශ වීමට කරුණාකර ඇඩ්මින් පරිශීලක නාමය (Username), NIC අංකය සහ මුරපදය (Password) ඇතුළත් කරන්න.",
          fontSize = 11.5.sp,
          color = NeutralMedium
        )
        Spacer(modifier = Modifier.height(14.dp))

        androidx.compose.material3.OutlinedTextField(
          value = usernameInput,
          onValueChange = {
            usernameInput = it
            errorMessage = null
          },
          label = { Text("පරිශීලක නාමය (Username)") },
          placeholder = { Text("පරිශීලක නාමය ඇතුළත් කරන්න") },
          leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Username") },
          textStyle = TextStyle(color = Color.Black, fontSize = 14.sp),
          colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedLabelColor = Color(0xFF1E3A8A),
            unfocusedLabelColor = Color(0xFF4B5563),
            focusedBorderColor = Color(0xFF1E3A8A),
            unfocusedBorderColor = Color(0xFFD1D5DB),
            cursorColor = Color.Black,
            focusedPlaceholderColor = Color.Gray,
            unfocusedPlaceholderColor = Color.Gray
          ),
          singleLine = true,
          modifier = Modifier
            .fillMaxWidth()
            .testTag("admin_step2_username_input")
        )

        Spacer(modifier = Modifier.height(10.dp))

        androidx.compose.material3.OutlinedTextField(
          value = nicInput,
          onValueChange = {
            nicInput = it
            errorMessage = null
          },
          label = { Text("ජාතික හැඳුනුම්පත් අංකය (NIC)") },
          placeholder = { Text("NIC අංකය ඇතුළත් කරන්න") },
          leadingIcon = { Icon(Icons.Default.AccountBox, contentDescription = "NIC") },
          textStyle = TextStyle(color = Color.Black, fontSize = 14.sp),
          colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedLabelColor = Color(0xFF1E3A8A),
            unfocusedLabelColor = Color(0xFF4B5563),
            focusedBorderColor = Color(0xFF1E3A8A),
            unfocusedBorderColor = Color(0xFFD1D5DB),
            cursorColor = Color.Black,
            focusedPlaceholderColor = Color.Gray,
            unfocusedPlaceholderColor = Color.Gray
          ),
          singleLine = true,
          modifier = Modifier
            .fillMaxWidth()
            .testTag("admin_step2_nic_input")
        )

        Spacer(modifier = Modifier.height(10.dp))

        androidx.compose.material3.OutlinedTextField(
          value = passwordInput,
          onValueChange = {
            passwordInput = it
            errorMessage = null
          },
          label = { Text("මුරපදය (Password)") },
          leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Password") },
          trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
              Icon(
                imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                contentDescription = if (passwordVisible) "Hide password" else "Show password"
              )
            }
          },
          textStyle = TextStyle(color = Color.Black, fontSize = 14.sp),
          colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedLabelColor = Color(0xFF1E3A8A),
            unfocusedLabelColor = Color(0xFF4B5563),
            focusedBorderColor = Color(0xFF1E3A8A),
            unfocusedBorderColor = Color(0xFFD1D5DB),
            cursorColor = Color.Black,
            focusedPlaceholderColor = Color.Gray,
            unfocusedPlaceholderColor = Color.Gray
          ),
          visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
          singleLine = true,
          modifier = Modifier
            .fillMaxWidth()
            .testTag("admin_step2_password_input")
        )

        if (errorMessage != null) {
          Spacer(modifier = Modifier.height(10.dp))
          Surface(
            color = Color(0xFFFEE2E2),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Text(
              text = errorMessage ?: "",
              color = Color(0xFFDC2626),
              fontSize = 11.5.sp,
              fontWeight = FontWeight.Medium,
              modifier = Modifier.padding(8.dp)
            )
          }
        }
      }
    },
    confirmButton = {
      Button(
        onClick = {
          if (isValidAdminStep2Credentials(usernameInput, nicInput, passwordInput)) {
            onUnlockSuccess()
          } else {
            errorMessage = "❌ ඇතුළත් කළ පරිශීලක නාමය (Username), NIC අංකය හෝ මුරපදය (Password) වැරදියි! නිවැරදි විස්තර ඇතුළත් කරන්න."
          }
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E3A8A)),
        modifier = Modifier.testTag("admin_step2_unlock_confirm_button")
      ) {
        Icon(Icons.Default.LockOpen, contentDescription = "Unlock", modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.width(6.dp))
        Text("විවෘත කරන්න", fontWeight = FontWeight.Bold)
      }
    },
    dismissButton = {
      androidx.compose.material3.TextButton(onClick = onDismiss) {
        Text("අවලංගු කරන්න")
      }
    }
  )
}

/**
 * Dedicated Expired Students List Dialog (Strictly for Admin only)
 * Shows students whose 6-month validity period has ended, with Request Date,
 * Approval Date, 6-Month Expiry Date, and 1-tap 6-month renewal.
 */
@Composable
fun ExpiredStudentsListDialog(
  registeredUsers: SnapshotStateList<UserAccount>,
  onDismiss: () -> Unit,
  onUsersUpdated: () -> Unit
) {
  val context = LocalContext.current
  val expiredStudents = registeredUsers.filter { it.isApprovalExpired() && !isAuthorizedAdminUser(it.usernameOrPhone) }

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false)
  ) {
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(Color.Black.copy(alpha = 0.7f))
        .padding(horizontal = 12.dp, vertical = 24.dp),
      contentAlignment = Alignment.Center
    ) {
      Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        border = BorderStroke(1.5.dp, Color(0xFFF43F5E)),
        modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight(0.9f)
      ) {
        Column(
          modifier = Modifier.fillMaxSize()
        ) {
          // Top Header Banner
          Surface(
            color = Color(0xFF881337), // Ruby/Rose Dark
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 12.dp),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                Surface(
                  shape = CircleShape,
                  color = Color(0xFFE11D48),
                  modifier = Modifier.size(36.dp)
                ) {
                  Box(contentAlignment = Alignment.Center) {
                    Icon(
                      imageVector = Icons.Default.Lock,
                      contentDescription = "Expired",
                      tint = Color.White,
                      modifier = Modifier.size(20.dp)
                    )
                  }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                      text = "⚠️ මාස 6 අවසන් වූ සිසුන්ගේ ලැයිස්තුව",
                      fontWeight = FontWeight.Bold,
                      fontSize = 13.5.sp,
                      color = Color.White
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Surface(
                      shape = RoundedCornerShape(4.dp),
                      color = Color(0xFFFDA4AF)
                    ) {
                      Text(
                        text = "${expiredStudents.size}",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF881337),
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 1.dp)
                      )
                    }
                  }
                  Text(
                    text = "👑 ඇඩ්මින් පාලන තීරුවෙන් පමණි • Admin Only",
                    fontSize = 10.sp,
                    color = Color(0xFFFECDD3)
                  )
                }
              }

              IconButton(
                onClick = onDismiss,
                modifier = Modifier.size(32.dp)
              ) {
                Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White)
              }
            }
          }

          // Explanatory Information Banner
          Surface(
            color = Color(0xFFFFF1F2),
            border = BorderStroke(1.dp, Color(0xFFFDA4AF)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(
              modifier = Modifier.padding(12.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Icon(
                imageVector = Icons.Default.Description,
                contentDescription = "Info",
                tint = Color(0xFFE11D48),
                modifier = Modifier.size(20.dp)
              )
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = "මෙම සිසුන්ගේ මාස 6ක (දින 180) කාලසීමාව සම්පූර්ණ වී ඇති බැවින් ඇප් එකට ලොග් වීම ස්වයංක්‍රීයව අවහිර කර ඇත. සිසුන් රු. 1000 ගෙවීම සිදු කළ පසු 'මාස 6ක් අලුත් කරන්න' බොත්තම ඔබා නැවත සක්‍රීය කරන්න.",
                fontSize = 10.5.sp,
                color = Color(0xFF9F1239),
                lineHeight = 15.sp
              )
            }
          }

          // Content List
          if (expiredStudents.isEmpty()) {
            Box(
              modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
              contentAlignment = Alignment.Center
            ) {
              Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                  imageVector = Icons.Default.CheckCircle,
                  contentDescription = "No Expired",
                  tint = Color(0xFF10B981),
                  modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                  text = "දැනට මාස 6 අවසන් වූ සිසුන් කිසිවෙකු නොමැත.",
                  fontWeight = FontWeight.Bold,
                  fontSize = 13.sp,
                  color = Color(0xFF475569)
                )
                Text(
                  text = "සියලුම අනුමත සිසුන්ගේ ගිණුම් සක්‍රීයව පවතී.",
                  fontSize = 11.sp,
                  color = Color(0xFF94A3B8)
                )
              }
            }
          } else {
            Column(
              modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(12.dp),
              verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
              expiredStudents.forEach { student: UserAccount ->
                Surface(
                  shape = RoundedCornerShape(14.dp),
                  color = Color(0xFFFFFBEB),
                  border = BorderStroke(1.2.dp, Color(0xFFFDE68A)),
                  shadowElevation = 2.dp,
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Column(modifier = Modifier.padding(12.dp)) {
                    // Name & Phone Row
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.SpaceBetween,
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Column(modifier = Modifier.weight(1f)) {
                        Text(
                          text = student.fullName,
                          fontWeight = FontWeight.Bold,
                          fontSize = 13.5.sp,
                          color = Color(0xFF0F172A)
                        )
                        Text(
                          text = "📞 ${student.usernameOrPhone}",
                          fontSize = 11.5.sp,
                          fontWeight = FontWeight.Medium,
                          color = Color(0xFF475569)
                        )
                      }
                      Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Color(0xFFFEE2E2),
                        border = BorderStroke(1.dp, Color(0xFFFCA5A5))
                      ) {
                        Text(
                          text = "⚠️ මාස 6 අවසන් (Blocked)",
                          fontSize = 9.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color(0xFFB91C1C),
                          modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                      }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                      text = "📦 පැකේජය: ${student.requestedGradePackage}",
                      fontSize = 10.5.sp,
                      color = Color(0xFF334155),
                      fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    // Date Breakdown Card
                    Surface(
                      shape = RoundedCornerShape(8.dp),
                      color = Color(0xFFF8FAFC),
                      border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                      modifier = Modifier.fillMaxWidth()
                    ) {
                      Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                          Text("📅 ඉල්ලුම් කළ දිනය (Request Date):", fontSize = 10.sp, color = Color(0xFF64748B))
                          Text(student.getRequestDateFormatted(), fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E293B))
                        }
                        Spacer(modifier = Modifier.height(3.dp))
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                          Text("📅 අනුමත කළ දිනය (Approved Date):", fontSize = 10.sp, color = Color(0xFF166534))
                          Text(student.getApprovedDateFormatted(), fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF166534))
                        }
                        Spacer(modifier = Modifier.height(3.dp))
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                          Text("⏳ මාස 6 අවසන් වූ දිනය (6-Month Expiry):", fontSize = 10.sp, color = Color(0xFFB91C1C))
                          Text(student.getExpiryDateFormatted(), fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFFB91C1C))
                        }
                      }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Action Buttons Row
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                      // Renew 6 Months Button (Rs. 1000)
                      Button(
                        onClick = {
                          val idx = registeredUsers.indexOf(student)
                          if (idx >= 0) {
                            val renewed = student.copy(
                              isApproved = true,
                              paymentStatus = "Approved",
                              approvalTimestamp = System.currentTimeMillis()
                            )
                            registeredUsers[idx] = renewed
                            onUsersUpdated()
                            Toast.makeText(context, "✅ ${student.fullName} හට මාස 6කට (රු. 1000) සාර්ථකව අලුත් කරන ලදී!", Toast.LENGTH_SHORT).show()
                          }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669)),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.weight(1f).height(34.dp),
                        contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp)
                      ) {
                        Icon(Icons.Default.Refresh, contentDescription = "Renew", modifier = Modifier.size(14.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("🔄 මාස 6ක් අලුත් කරන්න (රු. 1000)", fontSize = 9.5.sp, fontWeight = FontWeight.Bold)
                      }

                      // WhatsApp Reminder Button
                      OutlinedButton(
                        onClick = {
                          val cleanNumber = student.usernameOrPhone.replace("+", "").replace(" ", "").trim()
                          val targetPhone = if (cleanNumber.startsWith("0")) "94" + cleanNumber.substring(1) else cleanNumber
                          val wpMsg = "ආයුබෝවන් ${student.fullName}, ඔබගේ O/L Guru ඇප් එකේ මාස 6ක කාලසීමාව අවසන් වී ඇත. නැවත සක්‍රීය කරගැනීමට රු. 1000 ක ගෙවීම සිදු කර අප වෙත දන්වන්න."
                          val wpUri = Uri.parse("https://wa.me/$targetPhone?text=" + Uri.encode(wpMsg))
                          val intent = Intent(Intent.ACTION_VIEW, wpUri)
                          try {
                            context.startActivity(intent)
                          } catch (_: Exception) {
                            Toast.makeText(context, "WhatsApp සොයාගත නොහැකි විය.", Toast.LENGTH_SHORT).show()
                          }
                        },
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF16A34A)),
                        border = BorderStroke(1.dp, Color(0xFF86EFAC)),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.height(34.dp),
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp)
                      ) {
                        Icon(Icons.Default.Phone, contentDescription = "WhatsApp", modifier = Modifier.size(14.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("WhatsApp", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                      }

                      // Delete Button
                      IconButton(
                        onClick = {
                          registeredUsers.remove(student)
                          onUsersUpdated()
                          Toast.makeText(context, "${student.fullName} ගිණුම ඉවත් කරන ලදී.", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.size(34.dp)
                      ) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color(0xFFDC2626), modifier = Modifier.size(18.dp))
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}

@Composable
fun PortalBottomNavigation(
  selectedTab: Int,
  onTabSelected: (Int) -> Unit
) {
  val dims = rememberScreenDimensions()
  val isCompact = dims.isSmallWidth

  Surface(
    shape = RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp),
    color = SurfaceVariantLight,
    shadowElevation = 6.dp,
    modifier = Modifier.navigationBarsPadding()
  ) {
    NavigationBar(
      containerColor = Color.Transparent,
      tonalElevation = 0.dp,
      modifier = Modifier.height(if (isCompact) 54.dp else 60.dp)
    ) {
      val items = if (isCompact) {
        listOf(
          Triple("මුල", Icons.Default.Home, "nav_home"),
          Triple("ප්‍රගතිය", Icons.Default.WorkspacePremium, "nav_analytics"),
          Triple("රචනා", Icons.Default.Description, "nav_essay"),
          Triple("සූත්‍ර", Icons.Default.MenuBook, "nav_formulas"),
          Triple("AI", Icons.Default.AutoAwesome, "nav_ai_tutor")
        )
      } else {
        listOf(
          Triple("මුල් පිටුව", Icons.Default.Home, "nav_home"),
          Triple("ප්‍රගතිය", Icons.Default.WorkspacePremium, "nav_analytics"),
          Triple("රචනා/ප්‍රශ්න", Icons.Default.Description, "nav_essay"),
          Triple("සූත්‍ර", Icons.Default.MenuBook, "nav_formulas"),
          Triple("AI Tutor", Icons.Default.AutoAwesome, "nav_ai_tutor")
        )
      }

      items.forEachIndexed { index, (label, icon, testTag) ->
        val isSelected = selectedTab == index
        NavigationBarItem(
          selected = isSelected,
          onClick = { onTabSelected(index) },
          icon = {
            Icon(
              imageVector = icon,
              contentDescription = label,
              modifier = Modifier.size(if (isCompact) 18.dp else 20.dp)
            )
          },
          label = {
            Text(
              text = label,
              fontSize = if (isCompact) 8.5.sp else 10.sp,
              fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
          },
          colors = NavigationBarItemDefaults.colors(
            selectedIconColor = BlueOnPrimaryContainer,
            selectedTextColor = BlueOnPrimaryContainer,
            indicatorColor = BluePrimaryContainer,
            unselectedIconColor = NeutralMedium,
            unselectedTextColor = NeutralMedium
          ),
          modifier = Modifier.testTag(testTag)
        )
      }
    }
  }
}

@Composable
fun WatermarkBackground(userText: String = "EduPortal • Official Educational Access") {
  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
  ) {
    Text(
      text = userText,
      style = MaterialTheme.typography.titleMedium,
      color = Color.Black.copy(alpha = 0.03f),
      fontWeight = FontWeight.Bold,
      modifier = Modifier.rotate(45f)
    )
  }
}

// Data Generators (No fake/dummy items - only real user-added resources)
fun getSubjectsForGrade(grade: String): List<SubjectItem> {
  return when (grade) {
    "11" -> listOf(
      SubjectItem("sub_11_sci", "Science", "විද්‍යාව", 18, Color(0xFF1B5E20), Icons.Default.AutoAwesome),
      SubjectItem("sub_11_math", "Mathematics", "ගණිතය", 24, Color(0xFF0D47A1), Icons.Default.MenuBook),
      SubjectItem("sub_11_hist", "History", "ඉතිහාසය", 12, Color(0xFF8D6E63), Icons.Default.Book),
      SubjectItem("sub_11_bud", "Buddhism", "බුද්ධ ධර්මය", 14, Color(0xFFE65100), Icons.Default.AutoAwesome),
      SubjectItem("sub_11_dance", "Dancing", "නර්තනය", 12, Color(0xFFD81B60), Icons.Default.AutoAwesome),
      SubjectItem("sub_11_music", "Oriental Music", "සංගීතය", 14, Color(0xFFC2185B), Icons.Default.MusicNote),
      SubjectItem("sub_11_civic", "Civic Education", "පුරවැසි අධ්‍යාපනය", 12, Color(0xFF00695C), Icons.Default.Description),
      SubjectItem("sub_11_comm", "Commerce & Accounting", "ව්‍යාපාර අධ්‍යයනය හා ගිණුම්කරණය", 16, Color(0xFF00695C), Icons.Default.Description),
      SubjectItem("sub_11_ict", "Information Technology", "තොරතුරු තාක්ෂණය", 10, Color(0xFF283593), Icons.Default.AutoAwesome),
      SubjectItem("sub_11_agri", "Agriculture & Food Tech", "කෘෂි හා ආහාර තාක්ෂණය", 12, Color(0xFF33691E), Icons.Default.AutoAwesome),
      SubjectItem("sub_11_health", "Health & Physical Ed", "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය", 10, Color(0xFFC2185B), Icons.Default.CheckCircle),
      SubjectItem("sub_11_sin", "Sinhala Language", "සිංහල භාෂාව හා සාහිත්‍යය", 16, Color(0xFF6A1B9A), Icons.Default.Book),
      SubjectItem("sub_11_art", "Art", "චිත්‍ර කලාව", 12, Color(0xFFE91E63), Icons.Default.AutoAwesome),
      SubjectItem("sub_11_geo", "Geography", "භූගෝල විද්‍යාව", 12, Color(0xFF00796B), Icons.Default.Description),
      SubjectItem("sub_11_eng", "English Language", "ඉංග්‍රීසි භාෂාව", 14, Color(0xFF00838F), Icons.Default.MenuBook)
    )
    "10" -> listOf(
      SubjectItem("sub_10_sci", "Science", "විද්‍යාව", 18, Color(0xFF1B5E20), Icons.Default.AutoAwesome),
      SubjectItem("sub_10_math", "Mathematics", "ගණිතය", 22, Color(0xFF0D47A1), Icons.Default.MenuBook),
      SubjectItem("sub_10_hist", "History", "ඉතිහාසය", 12, Color(0xFF8D6E63), Icons.Default.Book),
      SubjectItem("sub_10_bud", "Buddhism", "බුද්ධ ධර්මය", 14, Color(0xFFE65100), Icons.Default.AutoAwesome),
      SubjectItem("sub_10_dance", "Dancing", "නර්තනය", 12, Color(0xFFD81B60), Icons.Default.AutoAwesome),
      SubjectItem("sub_10_music", "Oriental Music", "සංගීතය", 14, Color(0xFFC2185B), Icons.Default.MusicNote),
      SubjectItem("sub_10_art", "Art", "චිත්‍ර කලාව", 12, Color(0xFFE91E63), Icons.Default.AutoAwesome),
      SubjectItem("sub_10_geo", "Geography", "භූගෝල විද්‍යාව", 12, Color(0xFF00796B), Icons.Default.Description),
      SubjectItem("sub_10_civic", "Civic Education", "පුරවැසි අධ්‍යාපනය", 12, Color(0xFF00695C), Icons.Default.Description),
      SubjectItem("sub_10_comm", "Commerce & Accounting", "ව්‍යාපාර අධ්‍යයනය හා ගිණුම්කරණය", 14, Color(0xFF00695C), Icons.Default.Description),
      SubjectItem("sub_10_ict", "Information Technology", "තොරතුරු තාක්ෂණය", 10, Color(0xFF283593), Icons.Default.AutoAwesome),
      SubjectItem("sub_10_agri", "Agriculture & Food Tech", "කෘෂි හා ආහාර තාක්ෂණය", 12, Color(0xFF33691E), Icons.Default.AutoAwesome),
      SubjectItem("sub_10_health", "Health & Physical Ed", "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය", 10, Color(0xFFC2185B), Icons.Default.CheckCircle),
      SubjectItem("sub_10_sin", "Sinhala Language", "සිංහල භාෂාව හා සාහිත්‍යය", 16, Color(0xFF6A1B9A), Icons.Default.Book),
      SubjectItem("sub_10_eng", "English Language", "ඉංග්‍රීසි භාෂාව", 14, Color(0xFF00838F), Icons.Default.MenuBook)
    )
    "09", "9" -> listOf(
      SubjectItem("sub_09_sci", "Science", "විද්‍යාව", 16, Color(0xFF1B5E20), Icons.Default.AutoAwesome),
      SubjectItem("sub_09_math", "Mathematics", "ගණිතය", 20, Color(0xFF0D47A1), Icons.Default.MenuBook),
      SubjectItem("sub_09_sin", "Sinhala Language", "සිංහල භාෂාව හා සාහිත්‍යය", 16, Color(0xFF6A1B9A), Icons.Default.Book),
      SubjectItem("sub_09_eng", "English Language", "ඉංග්‍රීසි භාෂාව", 14, Color(0xFF00838F), Icons.Default.MenuBook),
      SubjectItem("sub_09_hist", "History", "ඉතිහාසය", 12, Color(0xFF8D6E63), Icons.Default.Book),
      SubjectItem("sub_09_bud", "Buddhism", "බුද්ධ ධර්මය", 12, Color(0xFFE65100), Icons.Default.AutoAwesome),
      SubjectItem("sub_09_geo", "Geography", "භූගෝල විද්‍යාව", 10, Color(0xFF00796B), Icons.Default.Description),
      SubjectItem("sub_09_civic", "Civic Education", "පුරවැසි අධ්‍යාපනය", 10, Color(0xFF00695C), Icons.Default.Description),
      SubjectItem("sub_09_comm", "Commerce & Accounting", "ව්‍යාපාර අධ්‍යයනය හා ගිණුම්කරණය", 12, Color(0xFF2E7D32), Icons.Default.MenuBook),
      SubjectItem("sub_09_ict", "Information Technology", "තොරතුරු තාක්ෂණය", 12, Color(0xFF283593), Icons.Default.AutoAwesome),
      SubjectItem("sub_09_pts", "Practical & Tech Skills", "ප්‍රායෝගික හා තාක්ෂණික කුසලතා", 10, Color(0xFF33691E), Icons.Default.AutoAwesome),
      SubjectItem("sub_09_health", "Health & Physical Ed", "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය", 10, Color(0xFFC2185B), Icons.Default.CheckCircle),
      SubjectItem("sub_09_music", "Oriental Music", "පෙරදිග සංගීතය", 10, Color(0xFF7B1FA2), Icons.Default.AutoAwesome),
      SubjectItem("sub_09_dance", "Dancing", "නර්තනය", 10, Color(0xFFC2185B), Icons.Default.AutoAwesome),
      SubjectItem("sub_09_art", "Art", "චිත්‍ර", 10, Color(0xFFF57C00), Icons.Default.Book)
    )
    "08", "8", "07", "7", "06", "6" -> {
      val g = if (grade.length == 1) "0$grade" else grade
      listOf(
        SubjectItem("sub_${g}_sci", "Science", "විද්‍යාව", 16, Color(0xFF1B5E20), Icons.Default.AutoAwesome),
        SubjectItem("sub_${g}_math", "Mathematics", "ගණිතය", 20, Color(0xFF0D47A1), Icons.Default.MenuBook),
        SubjectItem("sub_${g}_sin", "Sinhala Language", "සිංහල භාෂාව හා සාහිත්‍යය", 16, Color(0xFF6A1B9A), Icons.Default.Book),
        SubjectItem("sub_${g}_eng", "English Language", "ඉංග්‍රීසි භාෂාව", 14, Color(0xFF00838F), Icons.Default.MenuBook),
        SubjectItem("sub_${g}_hist", "History", "ඉතිහාසය", 12, Color(0xFF8D6E63), Icons.Default.Book),
        SubjectItem("sub_${g}_bud", "Buddhism", "බුද්ධ ධර්මය", 12, Color(0xFFE65100), Icons.Default.AutoAwesome),
        SubjectItem("sub_${g}_geo", "Geography", "භූගෝල විද්‍යාව", 10, Color(0xFF00796B), Icons.Default.Description),
        SubjectItem("sub_${g}_civic", "Civic Education", "පුරවැසි අධ්‍යාපනය", 10, Color(0xFF00695C), Icons.Default.Description),
        SubjectItem("sub_${g}_pts", "Practical & Tech Skills", "ප්‍රායෝගික හා තාක්ෂණික කුසලතා", 10, Color(0xFF33691E), Icons.Default.AutoAwesome),
        SubjectItem("sub_${g}_ict", "Information Technology", "තොරතුරු තාක්ෂණය", 10, Color(0xFF283593), Icons.Default.AutoAwesome),
        SubjectItem("sub_${g}_health", "Health & Physical Ed", "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය", 8, Color(0xFFC2185B), Icons.Default.CheckCircle),
        SubjectItem("sub_${g}_music", "Oriental Music", "පෙරදිග සංගීතය", 8, Color(0xFF7B1FA2), Icons.Default.AutoAwesome),
        SubjectItem("sub_${g}_dance", "Dancing", "නර්තනය", 8, Color(0xFFC2185B), Icons.Default.AutoAwesome),
        SubjectItem("sub_${g}_art", "Art", "චිත්‍ර", 8, Color(0xFFF57C00), Icons.Default.Book)
      )
    }
    else -> listOf(
      SubjectItem("sub_${grade}_sci", "Science", "විද්‍යාව", 16, Color(0xFF1B5E20), Icons.Default.AutoAwesome),
      SubjectItem("sub_${grade}_math", "Mathematics", "ගණිතය", 20, Color(0xFF0D47A1), Icons.Default.MenuBook),
      SubjectItem("sub_${grade}_sin", "Sinhala Language", "සිංහල භාෂාව හා සාහිත්‍යය", 14, Color(0xFF6A1B9A), Icons.Default.Book),
      SubjectItem("sub_${grade}_eng", "English Language", "ඉංග්‍රීසි භාෂාව", 12, Color(0xFF00838F), Icons.Default.MenuBook),
      SubjectItem("sub_${grade}_hist", "History", "ඉතිහාසය", 10, Color(0xFF8D6E63), Icons.Default.Book),
      SubjectItem("sub_${grade}_bud", "Buddhism", "බුද්ධ ධර්මය", 12, Color(0xFFE65100), Icons.Default.AutoAwesome)
    )
  }
}

fun getNotesForGrade(grade: String): List<ShortNoteItem> {
  val ictNote = ShortNoteItem(
    id = "ict_note_gr10_11",
    subject = "තොරතුරු තාක්ෂණය",
    title = "10 සහ 11 ශ්‍රේණිය - තොරතුරු තාක්ෂණය කෙටි සටහන්",
    topicSinhala = "10 සහ 11 ශ්‍රේණිය තොරතුරු තාක්ෂණය",
    readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
    isPopular = true,
    pdfUri = "https://drive.google.com/file/d/1IQntv3Yh1Oaxh42-btqYaFNNA9uijfx_/preview",
    fileName = "ICT_Short_Notes_Gr10_11.pdf",
    isPasswordProtected = false,
    password = null
  )

  val commerceNote = ShortNoteItem(
    id = "commerce_note_gr10_11",
    subject = "ව්‍යාපාර අධ්‍යයනය හා ගිණුම්කරණය",
    title = "10 සහ 11 ශ්‍රේණිය - ව්‍යාපාර අධ්‍යයනය හා ගිණුම්කරණය කෙටි සටහන්",
    topicSinhala = "10 සහ 11 ශ්‍රේණිය ව්‍යාපාර අධ්‍යයනය හා ගිණුම්කරණය",
    readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
    isPopular = true,
    pdfUri = "https://drive.google.com/file/d/1Ee0O1o9n9whNKs8A9hUB5Ndb5li52n8b/preview",
    fileName = "Commerce_Accounting_Short_Notes_Gr10_11.pdf",
    isPasswordProtected = false,
    password = null
  )

  val commerceSanduTheoryMasterNotes = ShortNoteItem(
    id = "commerce_sandu_theory_notes_gr10_11",
    subject = "ව්‍යාපාර අධ්‍යයනය හා ගිණුම්කරණය",
    title = "10 සහ 11 ශ්‍රේණි - ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය (කොමස්) කෙටි සටහන් (Sandu Theory පිටු 76 ක සම්පූර්ණ PDF & Mindmaps)",
    topicSinhala = "10 සහ 11 ශ්‍රේණි ව්‍යාපාර හා ගිණුම්කරණය (Sandu Theory පිටු 76ම)",
    readTime = "⚡ සම්පූර්ණ පිටු 76ම • පාඩම් 27 & සාරාංශ",
    isPopular = true,
    pdfUri = "sandu_commerce_theory_reader",
    fileName = "Sandu_Theory_Commerce_Gr10_11_Full_76_Pages.pdf",
    isPasswordProtected = false,
    password = null
  )

  val mathSanduTheoryMasterNotes = ShortNoteItem(
    id = "math_sandu_theory_notes_gr10_11",
    subject = "ගණිතය",
    title = "10 සහ 11 ශ්‍රේණි - ගණිතය සියලුම සිද්ධාන්ත හා කෙටි සටහන් (Sandu Theory පිටු 100ම සම්පූර්ණ ග්‍රන්ථය)",
    topicSinhala = "10 සහ 11 ශ්‍රේණි ගණිතය කෙටි සටහන් (Sandu Theory පිටු 100ම)",
    readTime = "⚡ සම්පූර්ණ පිටු 100ම • ඒකක 42 & පිළිතුරු",
    isPopular = true,
    pdfUri = "sandu_theory_100_pages_reader",
    fileName = "Sandu_Theory_Maths_Gr10_11_Full_100_Pages.pdf",
    isPasswordProtected = false,
    password = null
  )

  val mathGeometryNote = ShortNoteItem(
    id = "math_geometry_note_gr10_11",
    subject = "ගණිතය",
    title = "10 සහ 11 ශ්‍රේණි - ගණිතය (ජ්‍යාමිතිය ප්‍රමේය) කෙටි සටහන්",
    topicSinhala = "10 සහ 11 ශ්‍රේණිය ගණිතය (ජ්‍යාමිතිය)",
    readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
    isPopular = true,
    pdfUri = "https://drive.google.com/file/d/1V3y65z_15X6zjruQ_I11WhG4EOfDHGm-/preview",
    fileName = "Mathematics_Geometry_Short_Notes_Gr10_11.pdf",
    isPasswordProtected = false,
    password = null
  )

  val mathAlgebraNoteGr10_11 = ShortNoteItem(
    id = "math_algebra_note_gr10_11",
    subject = "ගණිතය",
    title = "10 සහ 11 ශ්‍රේණි - ගණිතය (වීජ ගණිතය, ශ්‍රේඪි හා ත්‍රිකෝණමිතිය) කෙටි සටහන්",
    topicSinhala = "10 සහ 11 ශ්‍රේණිය වීජ ගණිතය හා ත්‍රිකෝණමිතිය",
    readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
    isPopular = true,
    pdfUri = "https://drive.google.com/file/d/1V3y65z_15X6zjruQ_I11WhG4EOfDHGm-/preview",
    fileName = "Mathematics_Algebra_Trigonometry_Gr10_11.pdf",
    isPasswordProtected = false,
    password = null
  )

  val mathStatsFormulaNoteGr10_11 = ShortNoteItem(
    id = "math_stats_formula_note_gr10_11",
    subject = "ගණිතය",
    title = "10 සහ 11 ශ්‍රේණි - ගණිතය (සංඛ්‍යානය, සම්භාවිතාව, මිනුම් හා සූත්‍ර සංග්‍රහය)",
    topicSinhala = "10 සහ 11 ශ්‍රේණිය ගණිත සූත්‍ර හා සංඛ්‍යානය",
    readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
    isPopular = true,
    pdfUri = "https://drive.google.com/file/d/1V3y65z_15X6zjruQ_I11WhG4EOfDHGm-/preview",
    fileName = "Mathematics_Formulas_Statistics_Gr10_11.pdf",
    isPasswordProtected = false,
    password = null
  )


  val englishWritingNoteGr10_11 = ShortNoteItem(
    id = "english_writing_note_gr10_11",
    subject = "ඉංග්‍රීසි",
    title = "10 සහ 11 ශ්‍රේණි - O/L English Letter Writing, Essays, Notices & Vocab",
    topicSinhala = "10 සහ 11 ශ්‍රේණි O/L English Writing Guide",
    readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
    isPopular = true,
    pdfUri = "https://drive.google.com/file/d/155eu00n0_0IdrKc0wiWDqcwkqLa08ndI/preview",
    fileName = "English_Writing_Essay_Letter_Gr10_11.pdf",
    isPasswordProtected = false,
    password = null
  )

  val sinhalaWritingNoteGr10_11 = ShortNoteItem(
    id = "sinhala_writing_note_gr10_11",
    subject = "සිංහල",
    title = "10 සහ 11 ශ්‍රේණි - සිංහල රචනා, නිර්මාණාත්මක ලිවීම් හා විචාර කෙටි සටහන්",
    topicSinhala = "10 සහ 11 ශ්‍රේණි සිංහල රචනා හා විචාර",
    readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
    isPopular = true,
    pdfUri = "https://drive.google.com/file/d/17jFpMgfgojJgdAT0K4Ja9dfDocoBAnsl/preview",
    fileName = "Sinhala_Essay_Writing_Guide_Gr10_11.pdf",
    isPasswordProtected = false,
    password = null
  )

  val artNoteGr10_11 = ShortNoteItem(
    id = "art_note_gr10_11",
    subject = "චිත්‍ර කලාව",
    title = "10 සහ 11 ශ්‍රේණි - චිත්‍ර කලාව හා මූර්ති කෙටි සටහන්",
    topicSinhala = "10 සහ 11 ශ්‍රේණි චිත්‍ර කලාව",
    readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
    isPopular = true,
    pdfUri = "https://drive.google.com/file/d/12GBk7Eg8H558fgpOPGwFSqGskwUXyMfK/preview",
    fileName = "Art_Sculpture_Short_Notes_Gr10_11.pdf",
    isPasswordProtected = false,
    password = null
  )

  val dramaNoteGr10_11 = ShortNoteItem(
    id = "drama_note_gr10_11",
    subject = "නාට්‍ය හා රංග කලාව",
    title = "10 සහ 11 ශ්‍රේණි - නාට්‍ය හා රංග කලාව කෙටි සටහන්",
    topicSinhala = "10 සහ 11 ශ්‍රේණි නාට්‍ය හා රංග කලාව",
    readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
    isPopular = true,
    pdfUri = "https://drive.google.com/file/d/16z-qVWM6nwPErhsYoT5L0WOL3-jsEoDv/preview",
    fileName = "Drama_Theatre_Short_Notes_Gr10_11.pdf",
    isPasswordProtected = false,
    password = null
  )

  val danceNote = ShortNoteItem(
    id = "dance_note_gr10_11",
    subject = "නර්තනය",
    title = "10 සහ 11 ශ්‍රේණිය - නර්තනය කෙටි සටහන්",
    topicSinhala = "10 සහ 11 ශ්‍රේණිය නර්තනය කෙටි සටහන්",
    readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
    isPopular = true,
    pdfUri = "https://drive.google.com/file/d/12GBk7Eg8H558fgpOPGwFSqGskwUXyMfK/preview",
    fileName = "Dancing_Short_Notes_Gr10_11.pdf",
    isPasswordProtected = false,
    password = null
  )

  val musicNoteGr10_11_1 = ShortNoteItem(
    id = "music_note_gr10_11_1",
    subject = "සංගීතය",
    title = "10 ශ්‍රේණිය හා 11 ශ්‍රේණිය - පෙරදිග සංගීතය කෙටි සටහන් 1",
    topicSinhala = "10 සහ 11 ශ්‍රේණිය පෙරදිග සංගීතය කෙටි සටහන් 1",
    readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
    isPopular = true,
    pdfUri = "https://drive.google.com/file/d/16z-qVWM6nwPErhsYoT5L0WOL3-jsEoDv/preview",
    fileName = "Oriental_Music_Short_Notes_1_Gr10_11.pdf",
    isPasswordProtected = false,
    password = null
  )

  val musicNoteGr10_11_2 = ShortNoteItem(
    id = "music_note_gr10_11_2",
    subject = "සංගීතය",
    title = "10 ශ්‍රේණිය හා 11 ශ්‍රේණිය - පෙරදිග සංගීතය කෙටි සටහන්",
    topicSinhala = "10 සහ 11 ශ්‍රේණිය පෙරදිග සංගීතය කෙටි සටහන් සංග්‍රහය",
    readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
    isPopular = true,
    pdfUri = "https://drive.google.com/file/d/1BYhGyyvqcVfQP7YYgWynzV_oZ0coLjbL/preview",
    fileName = "Oriental_Music_Short_Notes_Gr10_11.pdf",
    isPasswordProtected = false,
    password = null
  )

  val sinhalaGrammarNote = ShortNoteItem(
    id = "sinhala_grammar_note_all_grades",
    subject = "සිංහල",
    title = "06-11 ශ්‍රේණි - සිංහල ව්‍යාකරණ කෙටි සටහන්",
    topicSinhala = "06/07/08/09/10/11 ශ්‍රේණි සිංහල ව්‍යාකරණ කෙටි සටහන්",
    readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
    isPopular = true,
    pdfUri = "https://drive.google.com/file/d/1XB8up4GLB9mvcavvtVsbOaAZAO1027tc/preview",
    fileName = "Sinhala_Grammar_Short_Notes_Gr06_11.pdf",
    isPasswordProtected = false,
    password = null
  )

  val sinhalaVicharaDharaFullPdfNote = ShortNoteItem(
    id = "sinhala_vichara_dhara_pdf_gr10_11",
    subject = "සිංහල",
    title = "10 සහ 11 ශ්‍රේණි - සිංහල සාහිත්‍යය විචාර ධාරා (විචාර 23ක් සහිත සම්පූර්ණ පිටු 30 PDF කෙටි සටහන් සංග්‍රහය)",
    topicSinhala = "10/11 ශ්‍රේණි සිංහල සාහිත්‍යය විචාර ධාරා (විචාර 23 සහ පිටු 30)",
    readTime = "⚡ සම්පූර්ණ පිටු 30 • විචාර 23 & ආදර්ශ පිළිතුරු",
    isPopular = true,
    pdfUri = "sinhala_vichara_dhara_30_pages_reader",
    fileName = "Sinhala_Vichara_Dhara_Short_Notes_Gr10_11.pdf",
    isPasswordProtected = false,
    password = null
  )

  val scienceDiagramsNotesGr10_11 = ShortNoteItem(
    id = "science_diagrams_notes_gr10_11",
    subject = "විද්‍යාව",
    title = "10 සහ 11 ශ්‍රේණි - විද්‍යාව ප්‍රධාන රූ සටහන් සහ සෛලීය ව්‍යුහ කෙටි සටහන් PDF (පිටු 11)",
    topicSinhala = "10/11 ශ්‍රේණි විද්‍යාව ප්‍රධාන රූ සටහන් සංග්‍රහය (සෛල හා පටක පිටු 11)",
    readTime = "🔬 සෛලීය ව්‍යුහ & ශාක පටක රූ සටහන් 11 • විභාග ලේබල්",
    isPopular = true,
    pdfUri = "science_diagrams_11_pages_reader",
    fileName = "Science_Diagrams_Short_Notes_Gr10_11.pdf",
    isPasswordProtected = false,
    password = null
  )

  val sinhalaLitNoteGr10_11 = ShortNoteItem(
    id = "sinhala_lit_note_gr10_11",
    subject = "සිංහල",
    title = "10/11 ශ්‍රේණි - සිංහල සාහිත්‍යය කෙටි සටහන්",
    topicSinhala = "10/11 ශ්‍රේණි සිංහල සාහිත්‍යය කෙටි සටහන්",
    readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
    isPopular = true,
    pdfUri = "https://drive.google.com/file/d/17jFpMgfgojJgdAT0K4Ja9dfDocoBAnsl/preview",
    fileName = "Sinhala_Literature_Short_Notes_Gr10_11.pdf",
    isPasswordProtected = false,
    password = null
  )

  val historyMapsNoteAllGrades = ShortNoteItem(
    id = "history_maps_note_all_grades",
    subject = "ඉතිහාසය",
    title = "06-11 ශ්‍රේණි - ඉතිහාසය සිතියම් ලකුණු කිරීම",
    topicSinhala = "06/07/08/09/10/11 ශ්‍රේණි ඉතිහාසය සිතියම්",
    readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
    isPopular = true,
    pdfUri = "https://drive.google.com/file/d/1BVguuBjT1_iQVO296Zn4Dek2AOahBFsp/preview",
    fileName = "History_Maps_Gr06_11.pdf",
    isPasswordProtected = false,
    password = null
  )

  val historyMapsFillBlanksGr09_11 = ShortNoteItem(
    id = "history_maps_fill_blanks_gr09_11",
    subject = "ඉතිහාසය",
    title = "09, 10 සහ 11 ශ්‍රේණි - ඉතිහාසය හිස්තැන් සහිත සිතියම් පුහුණුව (Interactive Auto-Checker)",
    topicSinhala = "09/10/11 ශ්‍රේණි ඉතිහාසය හිස්තැන් සහිත සිතියම් ගොන්න සහ ස්වයංක්‍රීය සිතියම් ලකුණු කිරීමේ පරීක්ෂාව",
    readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
    isPopular = true,
    pdfUri = "https://drive.google.com/file/d/1Zb0BakP20v9DzRQokDt8gjXd-Pl8Repg/preview",
    fileName = "History_Blank_Maps_Practice_Gr09_11.pdf",
    isPasswordProtected = false,
    password = null
  )

  val historyTablesNoteGr10_11 = ShortNoteItem(
    id = "history_tables_note_gr10_11",
    subject = "ඉතිහාසය",
    title = "10 හා 11 ශ්‍රේණි - ඉතිහාසය වගු කෙටි සටහන්",
    topicSinhala = "10 හා 11 ශ්‍රේණිය ඉතිහාසය වගු කෙටි සටහන්",
    readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
    isPopular = true,
    pdfUri = "https://drive.google.com/file/d/13ctYgSQ0jefoMGg3cpJg2t74h0jIZyx7/preview",
    fileName = "History_Tables_Short_Notes_Gr10_11.pdf",
    isPasswordProtected = false,
    password = null
  )

  val englishShortNoteAllGrades = ShortNoteItem(
    id = "english_short_note_all_grades",
    subject = "ඉංග්‍රීසි",
    title = "06-11 ශ්‍රේණි - ඉංග්‍රීසි ව්‍යාකරණ හා කෙටි සටහන්",
    topicSinhala = "06/07/08/09/10/11 ශ්‍රේණි ඉංග්‍රීසි කෙටි සටහන්",
    readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
    isPopular = true,
    pdfUri = "https://drive.google.com/file/d/155eu00n0_0IdrKc0wiWDqcwkqLa08ndI/preview",
    fileName = "English_Grammar_Short_Notes_Gr06_11.pdf",
    isPasswordProtected = false,
    password = null
  )

  val englishShortNoteGr09_11 = ShortNoteItem(
    id = "english_short_note_gr09_11_custom_pdf",
    subject = "ඉංග්‍රීසි",
    title = "09, 10 සහ 11 ශ්‍රේණි - ඉංග්‍රීසි කෙටි සටහන්",
    topicSinhala = "09, 10 හා 11 ශ්‍රේණි ඉංග්‍රීසි කෙටි සටහන්",
    readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
    isPopular = true,
    pdfUri = "https://drive.google.com/file/d/1rDvpGxRMBuXPldDRpsZdKjfA0JMr1GVy/preview",
    fileName = "English_Grade09_10_11_Short_Notes.pdf",
    isPasswordProtected = false,
    password = null
  )

  if (grade == "11") {
    val scienceNoteGr11 = ShortNoteItem(
      id = "science_note_gr11_1",
      subject = "විද්‍යාව",
      title = "11 ශ්‍රේණිය - විද්‍යාව පූර්ණ කෙටි සටහන්",
      topicSinhala = "11 ශ්‍රේණිය විද්‍යාව කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1vx9uXTL_pKexaA5g0IHPa47h6eKdINZl/preview",
      fileName = "Science_Short_Notes_Gr11.pdf",
      isPasswordProtected = false,
      password = null
    )
    val scienceNoteGr11Custom = ShortNoteItem(
      id = "science_note_gr11_custom_pdf",
      subject = "විද්‍යාව",
      title = "11 ශ්‍රේණිය - විද්‍යාව කෙටි සටහන් සංග්‍රහය",
      topicSinhala = "11 ශ්‍රේණිය විද්‍යාව කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1b650hE61XIP8RxNWq3TpIxg8pHtTOY8m/preview",
      fileName = "Science_Grade11_Short_Notes.pdf",
      isPasswordProtected = false,
      password = null
    )
    val science500QuestionsNoteGr11 = ShortNoteItem(
      id = "science_500_questions_gr11_interactive",
      subject = "විද්‍යාව",
      title = "11 ශ්‍රේණිය - විද්‍යාව ප්‍රශ්න 500 විශේෂ කෙටි සටහන් සහ ප්‍රශ්නෝත්තර සංග්‍රහය (Auto-Checker සහිතයි)",
      topicSinhala = "11 ශ්‍රේණිය විද්‍යාව ප්‍රශ්න 500 කෙටි සටහන්",
      readTime = "💡 Auto-Checker & සවිස්තර විවරණ • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1MarNrbMHz2UCxJq-bJJHjp9VxM8N2Ka-/preview",
      fileName = "Science_500_Questions_Grade11.pdf",
      isPasswordProtected = false,
      password = null
    )
    val mathNoteGr11Custom = ShortNoteItem(
      id = "math_note_gr11_custom_pdf",
      subject = "ගණිතය",
      title = "11 ශ්‍රේණිය - ගණිතය කෙටි සටහන් සංග්‍රහය",
      topicSinhala = "11 ශ්‍රේණිය ගණිතය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/129U-ITun4kdQJAW0euss4h5S5ZH2IVfl/preview",
      fileName = "Mathematics_Grade11_Short_Notes.pdf",
      isPasswordProtected = false,
      password = null
    )
    val buddhismNote = ShortNoteItem(
      id = "buddhism_note_gr11_1",
      subject = "බුද්ධ ධර්මය",
      title = "11 ශ්‍රේණිය - බුද්ධ ධර්මය කෙටි සටහන්",
      topicSinhala = "11 ශ්‍රේණිය බුද්ධ ධර්මය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1cG0Fj4Eg86hbvyx0OAnY1ffB-cvnwOLO/preview",
      fileName = "Buddhism_Short_Notes_Gr11.pdf",
      isPasswordProtected = false,
      password = null
    )
    val buddhismNoteGr11Custom = ShortNoteItem(
      id = "buddhism_note_gr11_custom_pdf",
      subject = "බුද්ධ ධර්මය",
      title = "11 ශ්‍රේණිය - බුද්ධ ධර්මය කෙටි සටහන් සංග්‍රහය",
      topicSinhala = "11 ශ්‍රේණිය බුද්ධ ධර්මය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1-nnUx_HXnFQYOnMajoMAeDjf7lgW5MLP/preview",
      fileName = "Buddhism_Grade11_Short_Notes.pdf",
      isPasswordProtected = false,
      password = null
    )
    val healthNote = ShortNoteItem(
      id = "health_note_gr11_1",
      subject = "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය",
      title = "11 ශ්‍රේණිය - සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය කෙටි සටහන්",
      topicSinhala = "11 ශ්‍රේණිය සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/15x4Awk2VNyL2gpegVHblAtPb52lbiAUX/preview",
      fileName = "Health_Physical_Education_Gr11.pdf",
      isPasswordProtected = false,
      password = null
    )
    val historyNote = ShortNoteItem(
      id = "history_note_gr11_1",
      subject = "ඉතිහාසය",
      title = "11 ශ්‍රේණිය - ඉතිහාසය කෙටි සටහන්",
      topicSinhala = "11 ශ්‍රේණිය ඉතිහාසය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1cQvoqODfVR6aBWLTO4JGEWVOBnf3C_4J/preview",
      fileName = "History_Short_Notes_Gr11.pdf",
      isPasswordProtected = false,
      password = null
    )
    val historyNoteGr11Custom = ShortNoteItem(
      id = "history_note_gr11_custom_pdf",
      subject = "ඉතිහාසය",
      title = "11 ශ්‍රේණිය - ඉතිහාසය කෙටි සටහන් සංග්‍රහය",
      topicSinhala = "11 ශ්‍රේණිය ඉතිහාසය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1f0MXkYCXZVwJWUzZc49bDx6tRSW8HFJa/preview",
      fileName = "History_Grade11_Short_Notes.pdf",
      isPasswordProtected = false,
      password = null
    )
    val agriNoteGr11 = ShortNoteItem(
      id = "agri_note_gr11_1",
      subject = "කෘෂි හා ආහාර තාක්ෂණය",
      title = "11 ශ්‍රේණිය - කෘෂි හා ආහාර තාක්ෂණය කෙටි සටහන්",
      topicSinhala = "11 ශ්‍රේණිය කෘෂි හා ආහාර තාක්ෂණය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1EjYUgrj-r_Uw9jMUlJPQh8a0Tl4oiBjb/preview",
      fileName = "Agri_Food_Tech_Short_Notes_Gr11.pdf",
      isPasswordProtected = false,
      password = null
    )
    val geoNoteGr11 = ShortNoteItem(
      id = "geo_note_gr11_1",
      subject = "භූගෝල විද්‍යාව",
      title = "11 ශ්‍රේණිය - භූගෝල විද්‍යාව කෙටි සටහන්",
      topicSinhala = "11 ශ්‍රේණිය භූගෝල විද්‍යාව කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1dfKR5Cb8ZAE07E_3ddeYc1EDfXWOALHO/preview",
      fileName = "Geography_Short_Notes_Gr11.pdf",
      isPasswordProtected = false,
      password = null
    )
    val geoNoteGr11Custom = ShortNoteItem(
      id = "geo_note_gr11_custom_pdf",
      subject = "භූගෝල විද්‍යාව",
      title = "11 ශ්‍රේණිය - භූගෝල විද්‍යාව කෙටි සටහන් සංග්‍රහය",
      topicSinhala = "11 ශ්‍රේණිය භූගෝලය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1FDQuZVWHUTxdVFaO6Xoi0CjhCYiTr4ih/preview",
      fileName = "Geography_Grade11_Short_Notes.pdf",
      isPasswordProtected = false,
      password = null
    )
    val civicNoteGr11 = ShortNoteItem(
      id = "civic_note_gr11_1",
      subject = "පුරවැසි අධ්‍යාපනය",
      title = "11 ශ්‍රේණිය - පුරවැසි අධ්‍යාපනය කෙටි සටහන්",
      topicSinhala = "11 ශ්‍රේණිය පුරවැසි අධ්‍යාපනය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1kuL7jmciw_ZKLK4JYz8WV1lbSeeWOf08/preview",
      fileName = "Civic_Education_Short_Notes_Gr11.pdf",
      isPasswordProtected = false,
      password = null
    )
    val civicNoteGr11Custom = ShortNoteItem(
      id = "civic_note_gr11_custom_pdf",
      subject = "පුරවැසි අධ්‍යාපනය",
      title = "11 ශ්‍රේණිය - පුරවැසි අධ්‍යාපනය කෙටි සටහන් සංග්‍රහය",
      topicSinhala = "11 ශ්‍රේණිය පුරවැසි කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1KOscWHk1iYyGomECrVn6GApwAKp6kLsY/preview",
      fileName = "Civic_Grade11_Short_Notes.pdf",
      isPasswordProtected = false,
      password = null
    )
    val musicNoteGr11Custom = ShortNoteItem(
      id = "music_note_gr11_custom_pdf",
      subject = "සංගීතය",
      title = "11 ශ්‍රේණිය - සංගීතය කෙටි සටහන් සංග්‍රහය",
      topicSinhala = "11 ශ්‍රේණිය සංගීතය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1CArgra4Xpgogue-KcwuVHFo_Bbk7sc9I/preview",
      fileName = "Music_Grade11_Short_Notes.pdf",
      isPasswordProtected = false,
      password = null
    )
    val danceNoteGr11Custom = ShortNoteItem(
      id = "dance_note_gr11_custom_pdf",
      subject = "නර්තනය",
      title = "11 ශ්‍රේණිය - නර්තනය කෙටි සටහන් සංග්‍රහය",
      topicSinhala = "11 ශ්‍රේණිය නර්තනය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/10FQY_uRc1QVJm2mhUz6FBrZFHM_Vhqmy/preview",
      fileName = "Dancing_Grade11_Short_Notes.pdf",
      isPasswordProtected = false,
      password = null
    )
    val artNoteGr11Custom = ShortNoteItem(
      id = "art_note_gr11_custom_pdf",
      subject = "චිත්‍ර කලාව",
      title = "11 ශ්‍රේණිය - චිත්‍ර කෙටි සටහන්",
      topicSinhala = "11 ශ්‍රේණිය චිත්‍ර කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1yDDZxJOdSIZt--KyTdJzKNx0hHmYQOYe/preview",
      fileName = "Grade_11_Art_Short_Notes.pdf",
      isPasswordProtected = false,
      password = null
    )
    return listOf(
      sinhalaVicharaDharaFullPdfNote, sinhalaGrammarNote, sinhalaLitNoteGr10_11, sinhalaWritingNoteGr10_11,
      englishShortNoteAllGrades, englishWritingNoteGr10_11, englishShortNoteGr09_11,
      mathSanduTheoryMasterNotes, mathGeometryNote, mathNoteGr11Custom,
      scienceNoteGr11, scienceNoteGr11Custom, science500QuestionsNoteGr11, scienceDiagramsNotesGr10_11,
      historyNote, historyTablesNoteGr10_11, historyNoteGr11Custom,
      buddhismNote, buddhismNoteGr11Custom, geoNoteGr11, geoNoteGr11Custom, civicNoteGr11, civicNoteGr11Custom, commerceSanduTheoryMasterNotes, ictNote,
      agriNoteGr11, healthNote, danceNote, danceNoteGr11Custom, musicNoteGr10_11_1, musicNoteGr10_11_2, musicNoteGr11Custom,
      artNoteGr10_11, artNoteGr11Custom, dramaNoteGr10_11
    )
  } else if (grade == "10") {
    val mathNoteGr10Custom = ShortNoteItem(
      id = "math_note_gr10_custom_pdf",
      subject = "ගණිතය",
      title = "10 ශ්‍රේණිය - ගණිතය කෙටි සටහන් සංග්‍රහය",
      topicSinhala = "10 ශ්‍රේණිය ගණිතය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1eZoyYZlqf8cu94iUaqp50wYgHEUDSuLk/preview",
      fileName = "Math_Grade10_Short_Notes.pdf",
      isPasswordProtected = false,
      password = null
    )
    val scienceNoteGr10 = ShortNoteItem(
      id = "science_note_gr10_1",
      subject = "විද්‍යාව",
      title = "10 ශ්‍රේණිය - විද්‍යාව පූර්ණ කෙටි සටහන්",
      topicSinhala = "10 ශ්‍රේණිය විද්‍යාව කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/17TcFs1wECaHB4C3LMdC8mO2YDKrtrEOI/preview",
      fileName = "Science_Short_Notes_Gr10.pdf",
      isPasswordProtected = false,
      password = null
    )
    val scienceNoteGr10Custom = ShortNoteItem(
      id = "science_note_gr10_custom_pdf",
      subject = "විද්‍යාව",
      title = "10 ශ්‍රේණිය - විද්‍යාව කෙටි සටහන් සංග්‍රහය",
      topicSinhala = "10 ශ්‍රේණිය විද්‍යාව කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1N5TV_W4kL891IKIZETGHnMCE_rnRIPKm/preview",
      fileName = "Science_Grade10_Short_Notes.pdf",
      isPasswordProtected = false,
      password = null
    )
    val buddhismNoteGr10 = ShortNoteItem(
      id = "buddhism_note_gr10_1",
      subject = "බුද්ධ ධර්මය",
      title = "10 ශ්‍රේණිය - බුද්ධ ධර්මය කෙටි සටහන්",
      topicSinhala = "10 ශ්‍රේණිය බුද්ධ ධර්මය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/17O97RA-IbgZnpKt9cVynjoNZ7y5SCE-Q/preview",
      fileName = "Buddhism_Short_Notes_Gr10.pdf",
      isPasswordProtected = false,
      password = null
    )
    val buddhismNoteGr10Custom = ShortNoteItem(
      id = "buddhism_note_gr10_custom_pdf",
      subject = "බුද්ධ ධර්මය",
      title = "10 ශ්‍රේණිය - බුද්ධ ධර්මය කෙටි සටහන් සංග්‍රහය",
      topicSinhala = "10 ශ්‍රේණිය බුද්ධ ධර්මය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1G0IYc4uhn6vv1CccyHVwIyJptDrmIhl7/preview",
      fileName = "Buddhism_Grade10_Short_Notes.pdf",
      isPasswordProtected = false,
      password = null
    )
    val civicNoteGr10 = ShortNoteItem(
      id = "civic_note_gr10_1",
      subject = "පුරවැසි අධ්‍යාපනය",
      title = "10 ශ්‍රේණිය - පුරවැසි අධ්‍යාපනය කෙටි සටහන්",
      topicSinhala = "10 ශ්‍රේණිය පුරවැසි අධ්‍යාපනය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1-H0WHiCYob1T4kQ9Sol4n6SQSJZc9LEX/preview",
      fileName = "Civic_Education_Short_Notes_Gr10.pdf",
      isPasswordProtected = false,
      password = null
    )
    val civicNoteGr10Custom = ShortNoteItem(
      id = "civic_note_gr10_custom_pdf",
      subject = "පුරවැසි අධ්‍යාපනය",
      title = "10 ශ්‍රේණිය - පුරවැසි අධ්‍යාපනය කෙටි සටහන් සංග්‍රහය",
      topicSinhala = "10 ශ්‍රේණිය පුරවැසි කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1RB8-GQoOrQbcl-eNnnh779n-jLtWQQFm/preview",
      fileName = "Civic_Grade10_Short_Notes.pdf",
      isPasswordProtected = false,
      password = null
    )
    val geoNoteGr10 = ShortNoteItem(
      id = "geo_note_gr10_1",
      subject = "භූගෝල විද්‍යාව",
      title = "10 ශ්‍රේණිය - භූගෝල විද්‍යාව කෙටි සටහන්",
      topicSinhala = "10 ශ්‍රේණිය භූගෝල විද්‍යාව කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1uKVJN3GsKephOV9In73EBW7R1bSSe47Z/preview",
      fileName = "Geography_Short_Notes_Gr10.pdf",
      isPasswordProtected = false,
      password = null
    )
    val geoNoteGr10Custom = ShortNoteItem(
      id = "geo_note_gr10_custom_pdf",
      subject = "භූගෝල විද්‍යාව",
      title = "10 ශ්‍රේණිය - භූගෝලය කෙටි සටහන් සංග්‍රහය",
      topicSinhala = "10 ශ්‍රේණිය භූගෝලය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1Fc1DqvZWVv7aiIC35KgWfl5Spjj-5WV_/preview",
      fileName = "Geography_Grade10_Short_Notes.pdf",
      isPasswordProtected = false,
      password = null
    )
    val agriNote = ShortNoteItem(
      id = "agri_note_gr10_1",
      subject = "කෘෂි හා ආහාර තාක්ෂණය",
      title = "10 ශ්‍රේණිය - කෘෂි හා ආහාර තාක්ෂණය කෙටි සටහන්",
      topicSinhala = "10 ශ්‍රේණිය කෘෂි හා ආහාර තාක්ෂණය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1zSkjgp24A2wvjrKAlX_EDt3KMvRtk7xp/preview",
      fileName = "Agri_Food_Tech_Short_Notes_Gr10.pdf",
      isPasswordProtected = false,
      password = null
    )
    val healthNoteGr10 = ShortNoteItem(
      id = "health_note_gr10_1",
      subject = "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය",
      title = "10 ශ්‍රේණිය - සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය කෙටි සටහන්",
      topicSinhala = "10 ශ්‍රේණිය සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1qEPI5g8KYCmX__5fzHSodtFoLUvj0BWi/preview",
      fileName = "Health_Physical_Education_Gr10.pdf",
      isPasswordProtected = false,
      password = null
    )
    val historyNoteGr10 = ShortNoteItem(
      id = "history_note_gr10_1",
      subject = "ඉතිහාසය",
      title = "10 ශ්‍රේණිය - ඉතිහාසය කෙටි සටහන්",
      topicSinhala = "10 ශ්‍රේණිය ඉතිහාසය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1Ry6utaFim_tZl8OkTG5hoD6oB4RB8Uxl/preview",
      fileName = "History_Short_Notes_Gr10.pdf",
      isPasswordProtected = false,
      password = null
    )
    val historyNoteGr10Custom = ShortNoteItem(
      id = "history_note_gr10_custom_pdf",
      subject = "ඉතිහාසය",
      title = "10 ශ්‍රේණිය - ඉතිහාසය කෙටි සටහන් සංග්‍රහය",
      topicSinhala = "10 ශ්‍රේණිය ඉතිහාසය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1me8zGLCFdLyrRMUWnVtICcT8oGQZUqMv/preview",
      fileName = "History_Grade10_Short_Notes.pdf",
      isPasswordProtected = false,
      password = null
    )
    val musicNoteGr10Custom = ShortNoteItem(
      id = "music_note_gr10_custom_pdf",
      subject = "සංගීතය",
      title = "10 ශ්‍රේණිය - සංගීතය කෙටි සටහන් සංග්‍රහය",
      topicSinhala = "10 ශ්‍රේණිය සංගීතය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1-1h9386kmqwW8lDUx5uAkzynL2MKMXVJ/preview",
      fileName = "Music_Grade10_Short_Notes.pdf",
      isPasswordProtected = false,
      password = null
    )
    val danceNoteGr10Custom = ShortNoteItem(
      id = "dance_note_gr10_custom_pdf",
      subject = "නර්තනය",
      title = "10 ශ්‍රේණිය - නර්තනය කෙටි සටහන් සංග්‍රහය",
      topicSinhala = "10 ශ්‍රේණිය නර්තනය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/13_lUv-lnGHs_1QDCZj_rlZNT0TWh8ppU/preview",
      fileName = "Dance_Grade10_Short_Notes.pdf",
      isPasswordProtected = false,
      password = null
    )
    val artNoteGr10Custom = ShortNoteItem(
      id = "art_note_gr10_custom_pdf",
      subject = "චිත්‍ර කලාව",
      title = "10 ශ්‍රේණිය - චිත්‍ර කෙටි සටහන්",
      topicSinhala = "10 ශ්‍රේණිය චිත්‍ර කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1z4Q0vRbaB20E7-EFqFU-hlU_Uoy2LwcW/preview",
      fileName = "Grade_10_Art_Short_Notes.pdf",
      isPasswordProtected = false,
      password = null
    )
    return listOf(
      sinhalaVicharaDharaFullPdfNote, sinhalaGrammarNote, sinhalaLitNoteGr10_11, sinhalaWritingNoteGr10_11,
      englishShortNoteAllGrades, englishWritingNoteGr10_11, englishShortNoteGr09_11,
      mathSanduTheoryMasterNotes, mathGeometryNote, mathNoteGr10Custom,
      scienceNoteGr10, scienceNoteGr10Custom, scienceDiagramsNotesGr10_11,
      historyNoteGr10, historyNoteGr10Custom, historyTablesNoteGr10_11,
      buddhismNoteGr10, buddhismNoteGr10Custom, geoNoteGr10, geoNoteGr10Custom, civicNoteGr10, civicNoteGr10Custom, commerceSanduTheoryMasterNotes, ictNote,
      agriNote, healthNoteGr10, danceNote, danceNoteGr10Custom, musicNoteGr10_11_1, musicNoteGr10_11_2, musicNoteGr10Custom,
      artNoteGr10Custom, dramaNoteGr10_11
    )
  } else if (grade == "09" || grade == "9") {
    val mathNoteGr09 = ShortNoteItem(
      id = "math_note_gr09",
      subject = "ගණිතය",
      title = "09 ශ්‍රේණිය - ගණිතය කෙටි සටහන් සහ සමීකරණ",
      topicSinhala = "09 ශ්‍රේණිය ගණිතය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1tSHjy3UMHx5wwmgKu3lVEZp4NGlvYy9R/preview",
      fileName = "Math_Short_Notes_Gr09.pdf",
      isPasswordProtected = false,
      password = null
    )
    val scienceNoteGr09 = ShortNoteItem(
      id = "science_note_gr09",
      subject = "විද්‍යාව",
      title = "09 ශ්‍රේණිය - විද්‍යාව සියලුම පාඩම් කෙටි සටහන්",
      topicSinhala = "09 ශ්‍රේණිය විද්‍යාව කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1Tipgj2cT0k0_udNbue_38XtC1OZ0FmlD/preview",
      fileName = "Science_Short_Notes_Gr09.pdf",
      isPasswordProtected = false,
      password = null
    )
    val historyNoteGr09 = ShortNoteItem(
      id = "history_note_gr09",
      subject = "ඉතිහාසය",
      title = "09 ශ්‍රේණිය - ඉතිහාසය කෙටි සටහන් හා මූලාශ්‍ර",
      topicSinhala = "09 ශ්‍රේණිය ඉතිහාසය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1FB_ACv30IM6MD6bJsK41MRKUluLR5y12/preview",
      fileName = "History_Short_Notes_Gr09.pdf",
      isPasswordProtected = false,
      password = null
    )
    val buddhismNoteGr09 = ShortNoteItem(
      id = "buddhism_note_gr09",
      subject = "බුද්ධ ධර්මය",
      title = "09 ශ්‍රේණිය - බුද්ධ ධර්මය කෙටි සටහන්",
      topicSinhala = "09 ශ්‍රේණිය බුද්ධ ධර්මය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1hP20VA2qbur4aTvLc0lXczHqheF-wrbh/preview",
      fileName = "Buddhism_Short_Notes_Gr09.pdf",
      isPasswordProtected = false,
      password = null
    )
    val sinhalaNoteGr09 = ShortNoteItem(
      id = "sinhala_note_gr09",
      subject = "සිංහල භාෂාව හා සාහිත්‍යය",
      title = "09 ශ්‍රේණිය - සිංහල සාහිත්‍ය සංග්‍රහය හා ව්‍යාකරණ",
      topicSinhala = "09 ශ්‍රේණිය සිංහල කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/11f_8h5kALDhWYyi9JVcWaVTmN2SHfr8b/preview",
      fileName = "Sinhala_Short_Notes_Gr09.pdf",
      isPasswordProtected = false,
      password = null
    )
    val geoNoteGr09 = ShortNoteItem(
      id = "geo_note_gr09",
      subject = "භූගෝල විද්‍යාව",
      title = "09 ශ්‍රේණිය - භූගෝල විද්‍යාව කෙටි සටහන්",
      topicSinhala = "09 ශ්‍රේණිය භූගෝල විද්‍යාව කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1lO6Mmqqx_lutYKe-Hx9ax8hPB-ekNvpO/preview",
      fileName = "Geography_Short_Notes_Gr09.pdf",
      isPasswordProtected = false,
      password = null
    )
    val civicNoteGr09 = ShortNoteItem(
      id = "civic_note_gr09",
      subject = "පුරවැසි අධ්‍යාපනය",
      title = "09 ශ්‍රේණිය - පුරවැසි අධ්‍යාපනය කෙටි සටහන්",
      topicSinhala = "09 ශ්‍රේණිය පුරවැසි අධ්‍යාපනය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1Rb6xpu4vzS9RKVANqp8OZWuC4kuiRGRn/preview",
      fileName = "Civic_Education_Short_Notes_Gr09.pdf",
      isPasswordProtected = false,
      password = null
    )
    val ptsNoteGr09 = ShortNoteItem(
      id = "pts_note_gr09",
      subject = "ප්‍රායෝගික හා තාක්ෂණික කුසලතා",
      title = "09 ශ්‍රේණිය - ප්‍රායෝගික හා තාක්ෂණික කුසලතා (PTS) කෙටි සටහන්",
      topicSinhala = "09 ශ්‍රේණිය PTS කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1kX5ozm3dsCklGg2DuGlhl19VzmJ5Cb_-/preview",
      fileName = "PTS_Practical_Technical_Skills_Gr09.pdf",
      isPasswordProtected = false,
      password = null
    )
    val ictNoteGr09 = ShortNoteItem(
      id = "ict_note_gr09",
      subject = "තොරතුරු තාක්ෂණය",
      title = "09 ශ්‍රේණිය - තොරතුරු තාක්ෂණය කෙටි සටහන්",
      topicSinhala = "09 ශ්‍රේණිය තොරතුරු තාක්ෂණය",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1IQntv3Yh1Oaxh42-btqYaFNNA9uijfx_/preview",
      fileName = "ICT_Short_Notes_Gr09.pdf",
      isPasswordProtected = false,
      password = null
    )
    val commNoteGr09 = ShortNoteItem(
      id = "comm_note_gr09",
      subject = "ව්‍යාපාර අධ්‍යයනය හා ගිණුම්කරණය",
      title = "09 ශ්‍රේණිය - ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය කෙටි සටහන්",
      topicSinhala = "09 ශ්‍රේණිය වාණිජ්‍ය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1F99lDkXQ2h-z6V15J-N56P36c340Q9K8/preview",
      fileName = "Commerce_Short_Notes_Gr09.pdf",
      isPasswordProtected = false,
      password = null
    )
    val healthNoteGr09 = ShortNoteItem(
      id = "health_note_gr09",
      subject = "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය",
      title = "09 ශ්‍රේණිය - සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය කෙටි සටහන්",
      topicSinhala = "09 ශ්‍රේණිය සෞඛ්‍ය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1EOtcHbT0Uz7Rh4BiovCvmlXEckqQJPKg/preview",
      fileName = "Health_Physical_Education_Short_Notes_Gr09.pdf",
      isPasswordProtected = false,
      password = null
    )
    val musicNoteGr09 = ShortNoteItem(
      id = "music_note_gr09",
      subject = "පෙරදිග සංගීතය",
      title = "09 ශ්‍රේණිය - පෙරදිග සංගීතය කෙටි සටහන්",
      topicSinhala = "09 ශ්‍රේණිය සංගීතය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1nD_0DB7NBI4biRbJQehrHRO85gCUripA/preview",
      fileName = "Music_Short_Notes_Gr09.pdf",
      isPasswordProtected = false,
      password = null
    )
    val danceNoteGr09 = ShortNoteItem(
      id = "dance_note_gr09",
      subject = "නර්තනය",
      title = "09 ශ්‍රේණිය - නර්තනය කෙටි සටහන්",
      topicSinhala = "09 ශ්‍රේණිය නර්තනය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1bMT2MxKVQIee92Rfb5s-VKp9gjzcahUi/preview",
      fileName = "Dancing_Short_Notes_Gr09.pdf",
      isPasswordProtected = false,
      password = null
    )
    val artNoteGr09 = ShortNoteItem(
      id = "art_note_gr09",
      subject = "චිත්‍ර",
      title = "09 ශ්‍රේණිය - චිත්‍ර කලාව කෙටි සටහන්",
      topicSinhala = "09 ශ්‍රේණිය චිත්‍ර කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1sgIxFoMazNG1VeFlG0EcZH28oq-mrk9Y/preview",
      fileName = "Art_Short_Notes_Gr09.pdf",
      isPasswordProtected = false,
      password = null
    )
    val engNoteGr09 = ShortNoteItem(
      id = "eng_note_gr09",
      subject = "ඉංග්‍රීසි භාෂාව",
      title = "09 ශ්‍රේණිය - ඉංග්‍රීසි භාෂාව Grammar & Vocabulary",
      topicSinhala = "09 ශ්‍රේණිය ඉංග්‍රීසි කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/155eu00n0_0IdrKc0wiWDqcwkqLa08ndI/preview",
      fileName = "English_Grammar_Vocabulary_Gr09.pdf",
      isPasswordProtected = false,
      password = null
    )
    return listOf(
      sinhalaNoteGr09, mathNoteGr09, scienceNoteGr09, historyNoteGr09, buddhismNoteGr09,
      geoNoteGr09, civicNoteGr09, commNoteGr09, ictNoteGr09, ptsNoteGr09, healthNoteGr09,
      engNoteGr09, musicNoteGr09, danceNoteGr09, artNoteGr09,
      sinhalaGrammarNote,
      englishShortNoteAllGrades, englishShortNoteGr09_11
    )
  } else if (grade == "08" || grade == "8" || grade == "07" || grade == "7" || grade == "06" || grade == "6") {
    val gr = if (grade.length == 1) "0$grade" else grade
    val grInt = gr.toIntOrNull() ?: 6
    val mathNote = ShortNoteItem(
      id = "math_note_gr$gr",
      subject = "ගණිතය",
      title = "$grInt ශ්‍රේණිය - ගණිතය කෙටි සටහන් සහ සමීකරණ",
      topicSinhala = "$grInt ශ්‍රේණිය ගණිතය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1tSHjy3UMHx5wwmgKu3lVEZp4NGlvYy9R/preview",
      fileName = "Math_Short_Notes_Gr$gr.pdf",
      isPasswordProtected = false,
      password = null
    )
    val scienceNote = ShortNoteItem(
      id = "science_note_gr$gr",
      subject = "විද්‍යාව",
      title = "$grInt ශ්‍රේණිය - විද්‍යාව සියලුම පාඩම් කෙටි සටහන්",
      topicSinhala = "$grInt ශ්‍රේණිය විද්‍යාව කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1Tipgj2cT0k0_udNbue_38XtC1OZ0FmlD/preview",
      fileName = "Science_Short_Notes_Gr$gr.pdf",
      isPasswordProtected = false,
      password = null
    )
    val historyNote = ShortNoteItem(
      id = "history_note_gr$gr",
      subject = "ඉතිහාසය",
      title = "$grInt ශ්‍රේණිය - ඉතිහාසය කෙටි සටහන්",
      topicSinhala = "$grInt ශ්‍රේණිය ඉතිහාසය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1FB_ACv30IM6MD6bJsK41MRKUluLR5y12/preview",
      fileName = "History_Short_Notes_Gr$gr.pdf",
      isPasswordProtected = false,
      password = null
    )
    val buddhismNote = ShortNoteItem(
      id = "buddhism_note_gr$gr",
      subject = "බුද්ධ ධර්මය",
      title = "$grInt ශ්‍රේණිය - බුද්ධ ධර්මය කෙටි සටහන්",
      topicSinhala = "$grInt ශ්‍රේණිය බුද්ධ ධර්මය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1hP20VA2qbur4aTvLc0lXczHqheF-wrbh/preview",
      fileName = "Buddhism_Short_Notes_Gr$gr.pdf",
      isPasswordProtected = false,
      password = null
    )
    val sinhalaNote = ShortNoteItem(
      id = "sinhala_note_gr$gr",
      subject = "සිංහල භාෂාව හා සාහිත්‍යය",
      title = "$grInt ශ්‍රේණිය - සිංහල සාහිත්‍යය හා ව්‍යාකරණ කෙටි සටහන්",
      topicSinhala = "$grInt ශ්‍රේණිය සිංහල කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/11f_8h5kALDhWYyi9JVcWaVTmN2SHfr8b/preview",
      fileName = "Sinhala_Short_Notes_Gr$gr.pdf",
      isPasswordProtected = false,
      password = null
    )
    val geoNote = ShortNoteItem(
      id = "geo_note_gr$gr",
      subject = "භූගෝල විද්‍යාව",
      title = "$grInt ශ්‍රේණිය - භූගෝල විද්‍යාව කෙටි සටහන්",
      topicSinhala = "$grInt ශ්‍රේණිය භූගෝල විද්‍යාව කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1lO6Mmqqx_lutYKe-Hx9ax8hPB-ekNvpO/preview",
      fileName = "Geography_Short_Notes_Gr$gr.pdf",
      isPasswordProtected = false,
      password = null
    )
    val civicNote = ShortNoteItem(
      id = "civic_note_gr$gr",
      subject = "පුරවැසි අධ්‍යාපනය",
      title = "$grInt ශ්‍රේණිය - පුරවැසි අධ්‍යාපනය කෙටි සටහන්",
      topicSinhala = "$grInt ශ්‍රේණිය පුරවැසි අධ්‍යාපනය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1Rb6xpu4vzS9RKVANqp8OZWuC4kuiRGRn/preview",
      fileName = "Civic_Education_Short_Notes_Gr$gr.pdf",
      isPasswordProtected = false,
      password = null
    )
    val ptsNote = ShortNoteItem(
      id = "pts_note_gr$gr",
      subject = "ප්‍රායෝගික හා තාක්ෂණික කුසලතා",
      title = "$grInt ශ්‍රේණිය - ප්‍රායෝගික හා තාක්ෂණික කුසලතා (PTS) කෙටි සටහන්",
      topicSinhala = "$grInt ශ්‍රේණිය PTS කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1kX5ozm3dsCklGg2DuGlhl19VzmJ5Cb_-/preview",
      fileName = "PTS_Short_Notes_Gr$gr.pdf",
      isPasswordProtected = false,
      password = null
    )
    val ictNote = ShortNoteItem(
      id = "ict_note_gr$gr",
      subject = "තොරතුරු තාක්ෂණය",
      title = "$grInt ශ්‍රේණිය - තොරතුරු තාක්ෂණය කෙටි සටහන්",
      topicSinhala = "$grInt ශ්‍රේණිය තොරතුරු තාක්ෂණය",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1IQntv3Yh1Oaxh42-btqYaFNNA9uijfx_/preview",
      fileName = "ICT_Short_Notes_Gr$gr.pdf",
      isPasswordProtected = false,
      password = null
    )
    val healthNote = ShortNoteItem(
      id = "health_note_gr$gr",
      subject = "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය",
      title = "$grInt ශ්‍රේණිය - සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය කෙටි සටහන්",
      topicSinhala = "$grInt ශ්‍රේණිය සෞඛ්‍ය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1EOtcHbT0Uz7Rh4BiovCvmlXEckqQJPKg/preview",
      fileName = "Health_Physical_Education_Short_Notes_Gr$gr.pdf",
      isPasswordProtected = false,
      password = null
    )
    val danceNote = ShortNoteItem(
      id = "dance_note_gr$gr",
      subject = "නර්තනය",
      title = "$grInt ශ්‍රේණිය - නර්තනය කෙටි සටහන්",
      topicSinhala = "$grInt ශ්‍රේණිය නර්තනය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1bMT2MxKVQIee92Rfb5s-VKp9gjzcahUi/preview",
      fileName = "Dancing_Short_Notes_Gr$gr.pdf",
      isPasswordProtected = false,
      password = null
    )
    val musicNote = ShortNoteItem(
      id = "music_note_gr$gr",
      subject = "පෙරදිග සංගීතය",
      title = "$grInt ශ්‍රේණිය - පෙරදිග සංගීතය කෙටි සටහන්",
      topicSinhala = "$grInt ශ්‍රේණිය සංගීතය කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1nD_0DB7NBI4biRbJQehrHRO85gCUripA/preview",
      fileName = "Music_Short_Notes_Gr$gr.pdf",
      isPasswordProtected = false,
      password = null
    )
    val artNote = ShortNoteItem(
      id = "art_note_gr$gr",
      subject = "චිත්‍ර",
      title = "$grInt ශ්‍රේණිය - චිත්‍ර කලාව කෙටි සටහන්",
      topicSinhala = "$grInt ශ්‍රේණිය චිත්‍ර කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/1sgIxFoMazNG1VeFlG0EcZH28oq-mrk9Y/preview",
      fileName = "Art_Short_Notes_Gr$gr.pdf",
      isPasswordProtected = false,
      password = null
    )
    val engNote = ShortNoteItem(
      id = "eng_note_gr$gr",
      subject = "ඉංග්‍රීසි භාෂාව",
      title = "$grInt ශ්‍රේණිය - ඉංග්‍රීසි භාෂාව Grammar & Vocabulary",
      topicSinhala = "$grInt ශ්‍රේණිය ඉංග්‍රීසි කෙටි සටහන්",
      readTime = "🔒 ආරක්ෂිත PDF • Google Drive",
      isPopular = true,
      pdfUri = "https://drive.google.com/file/d/155eu00n0_0IdrKc0wiWDqcwkqLa08ndI/preview",
      fileName = "English_Grammar_Vocabulary_Gr$gr.pdf",
      isPasswordProtected = false,
      password = null
    )
    return listOf(
      sinhalaNote, mathNote, scienceNote, historyNote, buddhismNote,
      geoNote, civicNote, ictNote, ptsNote, healthNote,
      engNote, musicNote, danceNote, artNote,
      sinhalaGrammarNote, englishShortNoteAllGrades
    )
  } else {
    return listOf(
      sinhalaGrammarNote,
      englishShortNoteAllGrades
    )
  }
}

fun getPapersForGrade(grade: String): List<QuestionPaperItem> {
  if (grade == "10") {
    return listOf(
      QuestionPaperItem(
        id = "science_gr10_term2_paper_custom",
        subject = "විද්‍යාව",
        titleSinhala = "10 ශ්‍රේණිය - විද්‍යාව දෙවන වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1zKtgd_badE2crpYDfX8xPnxjb-lT6VvD/preview",
        fileName = "Grade_10_Science_2nd_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "science_gr10_term3_paper_custom",
        subject = "විද්‍යාව",
        titleSinhala = "10 ශ්‍රේණිය - විද්‍යාව තෙවන වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "3 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1NDclAIyinjTEYML9IjrRv4QMORbZBggc/preview",
        fileName = "Grade_10_Science_3rd_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "math_gr10_term2_paper",
        subject = "ගණිතය",
        titleSinhala = "10 ශ්‍රේණිය - ගණිතය දෙවන වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1f9jYHMCPltGtG0NKICloYDdZFz-jiSW6/preview",
        fileName = "Grade_10_Mathematics_2nd_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "commerce_gr10_term3_paper",
        subject = "ව්‍යාපාර අධ්‍යයනය හා ගිණුම්කරණය",
        titleSinhala = "10 ශ්‍රේණිය - ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය (කොමස්) තෙවන වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "3 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1FWhvPon-0-Bu_8pwU3moG-Un2CWWWsnn/preview",
        fileName = "Grade_10_Commerce_3rd_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "civic_gr10_term2_paper_custom",
        subject = "පුරවැසි අධ්‍යාපනය",
        titleSinhala = "10 ශ්‍රේණිය - පුරවැසි අධ්‍යාපනය දෙවන වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1pdYxCcT8h2aVnp2XToS7kBgqg2aglFC9/preview",
        fileName = "Grade_10_Civic_2nd_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "buddhism_gr10_term2_paper_custom",
        subject = "බුද්ධ ධර්මය",
        titleSinhala = "10 ශ්‍රේණිය - බුද්ධ ධර්මය දෙවන වාර විභාග ප්‍රශ්න පත්‍රය 01",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1gJ03_AT7XEPQEEAp2HLYHywIEaDO2ed1/preview",
        fileName = "Grade_10_Buddhism_2nd_Term_Exam_Paper_01.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "buddhism_gr10_term2_paper_custom_2",
        subject = "බුද්ධ ධර්මය",
        titleSinhala = "10 ශ්‍රේණිය - බුද්ධ ධර්මය දෙවන වාර විභාග ප්‍රශ්න පත්‍රය 02",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1L42lStEbPjLRYN8geeieFnWKH8_HgFA9/preview",
        fileName = "Grade_10_Buddhism_2nd_Term_Exam_Paper_02.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "buddhism_gr10_term2_paper_custom_3",
        subject = "බුද්ධ ධර්මය",
        titleSinhala = "10 ශ්‍රේණිය - බුද්ධ ධර්මය දෙවන වාර විභාග ප්‍රශ්න පත්‍රය 03",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1-MGv6Q8nI_t6Oiy74fxZhWj9T0GOWQx7/preview",
        fileName = "Grade_10_Buddhism_2nd_Term_Exam_Paper_03.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "hist_gr10_term3_paper_custom",
        subject = "ඉතිහාසය",
        titleSinhala = "10 ශ්‍රේණිය - ඉතිහාසය තෙවන වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "3 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1WDen4EKvIu6TfH1QR1KOOzEzAt8IRGby/preview",
        fileName = "Grade_10_History_3rd_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      )
    )
  }
  if (grade == "11") {
    return listOf(
      QuestionPaperItem(
        id = "math_gr11_term2_paper_4",
        subject = "ගණිතය",
        titleSinhala = "11 ශ්‍රේණිය - ගණිතය දෙවන වාර විභාග ප්‍රශ්න පත්‍රය (කට්ටලය 04)",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1CFuLN_QGZYjXFIxRm2rKHuMRshui1lDy/preview",
        fileName = "Grade_11_Mathematics_2nd_Term_Exam_Paper_4.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "math_gr11_term2_paper_1",
        subject = "ගණිතය",
        titleSinhala = "11 ශ්‍රේණිය - ගණිතය දෙවන වාර විභාග ප්‍රශ්න පත්‍රය (කට්ටලය 01)",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1OKp2dUeKwV7JJjuJRGaJFNwQstk_m9pT/preview",
        fileName = "Grade_11_Mathematics_2nd_Term_Exam_Paper_1.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "math_gr11_term2_paper_2",
        subject = "ගණිතය",
        titleSinhala = "11 ශ්‍රේණිය - ගණිතය දෙවන වාර විභාග ප්‍රශ්න පත්‍රය (කට්ටලය 02)",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1-nClu4y3LIYOCVemi9ymZUj8ZYRZbLOL/preview",
        fileName = "Grade_11_Mathematics_2nd_Term_Exam_Paper_2.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "math_gr11_term2_paper_3",
        subject = "ගණිතය",
        titleSinhala = "11 ශ්‍රේණිය - ගණිතය දෙවන වාර විභාග ප්‍රශ්න පත්‍රය (කට්ටලය 03)",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/17MV6SPMSznDOjjFLmJkYUaqocd5z36cs/preview",
        fileName = "Grade_11_Mathematics_2nd_Term_Exam_Paper_3.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "math_gr11_term3_paper",
        subject = "ගණිතය",
        titleSinhala = "11 ශ්‍රේණිය - ගණිතය තෙවන වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "3 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1GRuImL-TxYbVTtN7pJ7n3HFH4VPsF9Eq/preview",
        fileName = "Grade_11_Mathematics_3rd_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "commerce_gr11_term3_paper",
        subject = "ව්‍යාපාර අධ්‍යයනය හා ගිණුම්කරණය",
        titleSinhala = "11 ශ්‍රේණිය - ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය (කොමස්) තෙවන වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "3 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1T-EbJmrXlq_1NlS8RK6G7roAQQqpg9VO/preview",
        fileName = "Grade_11_Commerce_3rd_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_math_past_paper_gr11_2024_2025_official",
        subject = "ගණිතය",
        titleSinhala = "11 ශ්‍රේණිය - ගණිතය සාමාන්‍ය පෙළ (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය 2024(2025) - Paper I & II",
        year = "2024(2025)",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1math_ol_2024_2025_official_paper/preview",
        fileName = "Grade_11_Mathematics_GCE_OL_Official_Paper_2024_2025.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_math_past_paper_gr11_2024_new_8",
        subject = "ගණිතය",
        titleSinhala = "11 ශ්‍රේණිය - ගණිතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍රය (ප්‍රශ්න පත්‍රය 08)",
        year = "2024",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/181c4-qtC3OoJBQVYdqUeUi_4e6EcLE6D/preview",
        fileName = "Grade_11_Mathematics_GCE_OL_Exam_Paper_8.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_math_past_paper_gr11_2024_new_7",
        subject = "ගණිතය",
        titleSinhala = "11 ශ්‍රේණිය - ගණිතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍රය (ප්‍රශ්න පත්‍රය 07)",
        year = "2024",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1xDkAhMMJX2f6SKQbsMLCNR31VECQqRzN/preview",
        fileName = "Grade_11_Mathematics_GCE_OL_Exam_Paper_7.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_math_past_paper_gr11_2024_new_6",
        subject = "ගණිතය",
        titleSinhala = "11 ශ්‍රේණිය - ගණිතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍රය (ප්‍රශ්න පත්‍රය 06)",
        year = "2024",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1AD4oy9etzQGpIINmusucjyW3gYq66lwL/preview",
        fileName = "Grade_11_Mathematics_GCE_OL_Exam_Paper_6.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_math_past_paper_gr11_2024_new_5",
        subject = "ගණිතය",
        titleSinhala = "11 ශ්‍රේණිය - ගණිතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍රය (ප්‍රශ්න පත්‍රය 05)",
        year = "2024",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1VhY-Of4Ub-ZuRRJHrq1RX4o3cOTsyXtM/preview",
        fileName = "Grade_11_Mathematics_GCE_OL_Exam_Paper_5.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_math_past_paper_gr11_2024_new_4",
        subject = "ගණිතය",
        titleSinhala = "11 ශ්‍රේණිය - ගණිතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍රය (අතිරේක ප්‍රශ්න පත්‍රය)",
        year = "2024",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1agtzpsIvSsF3IJyuV43RdWITGt_ruflb/preview",
        fileName = "Grade_11_Mathematics_GCE_OL_Exam_Paper_4.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_math_past_paper_gr11_2024_new_3",
        subject = "ගණිතය",
        titleSinhala = "11 ශ්‍රේණිය - ගණිතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍රය (විශේෂ කට්ටලය)",
        year = "2024",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1adURMthHZSMi8KLCxgpY1AReZuy0kbd8/preview",
        fileName = "Grade_11_Mathematics_GCE_OL_Exam_Paper_3.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_math_past_paper_gr11_2024_new_2",
        subject = "ගණිතය",
        titleSinhala = "11 ශ්‍රේණිය - ගණිතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍රය (නව කට්ටලය)",
        year = "2024",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1tQ4TvRxbeIiLMVr7uEth0G9nHpOtT8tp/preview",
        fileName = "Grade_11_Mathematics_GCE_OL_Exam_Paper_2.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_math_past_paper_gr11_2024_new",
        subject = "ගණිතය",
        titleSinhala = "11 ශ්‍රේණිය - ගණිතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1pEE7prAIU-JTjsQFrGhF4kMPPQEAZJsA/preview",
        fileName = "Grade_11_Mathematics_GCE_OL_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_science_paper_gr11_past_paper",
        subject = "විද්‍යාව",
        titleSinhala = "11 ශ්‍රේණිය - විද්‍යාව සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1TuWE6z1n8Qhb_Rd5FsiHFTBhI2AUukGo/preview",
        fileName = "Grade_11_Science_GCE_OL_Exam_Past_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_music_paper_gr11_past_paper",
        subject = "සංගීතය",
        titleSinhala = "11 ශ්‍රේණිය - පෙරදිග සංගීතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍රය (කට්ටලය 01)",
        year = "2024",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1AdPsYNZ6512nKGfwJ2ldP3Ds6w35Atlb/preview",
        fileName = "Grade_11_Music_GCE_OL_Exam_Past_Paper_01.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_music_paper_gr11_past_paper_2",
        subject = "සංගීතය",
        titleSinhala = "11 ශ්‍රේණිය - පෙරදිග සංගීතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍රය (කට්ටලය 02)",
        year = "2024",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1bhV9Fb0AUCSWuCQfib785FwyU7fQPgg-/preview",
        fileName = "Grade_11_Music_GCE_OL_Exam_Past_Paper_02.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_music_paper_gr11_past_paper_3",
        subject = "සංගීතය",
        titleSinhala = "11 ශ්‍රේණිය - පෙරදිග සංගීතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍රය (කට්ටලය 03)",
        year = "2024",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1GCTmHkiNb4GQx5Ss-GeiAPZZHytI0cLx/preview",
        fileName = "Grade_11_Music_GCE_OL_Exam_Past_Paper_03.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_music_paper_gr11_past_paper_4",
        subject = "සංගීතය",
        titleSinhala = "11 ශ්‍රේණිය - පෙරදිග සංගීතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍රය (කට්ටලය 04)",
        year = "2024",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/13nXWcjZseUaveBnaafPfediwIYyO60IA/preview",
        fileName = "Grade_11_Music_GCE_OL_Exam_Past_Paper_04.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_music_paper_gr11_past_paper_5",
        subject = "සංගීතය",
        titleSinhala = "11 ශ්‍රේණිය - පෙරදිග සංගීතය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍රය (කට්ටලය 05)",
        year = "2024",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1h0rMbmIDQMQizn8YieYLpWgXHoNwcKFJ/preview",
        fileName = "Grade_11_Music_GCE_OL_Exam_Past_Paper_05.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_agri_paper_gr11_past_paper",
        subject = "කෘෂි හා ආහාර තාක්ෂණය",
        titleSinhala = "11 ශ්‍රේණිය - කෘෂි හා ආහාර තාක්ෂණය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1ZQVbVXMM92max_jQbPwuEkbWSyuJJqY4/preview",
        fileName = "Grade_11_Agriculture_OL_Exam_Past_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_art_paper_gr11_past_paper",
        subject = "චිත්‍ර",
        titleSinhala = "11 ශ්‍රේණිය - චිත්‍ර සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1sgIxFoMazNG1VeFlG0EcZH28oq-mrk9Y/preview",
        fileName = "Grade_11_Art_OL_Exam_Past_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_dancing_paper_gr11_past_paper_2024_2025_official",
        subject = "නර්තනය",
        titleSinhala = "11 ශ්‍රේණිය - නැටුම් (දේශීය) සාමාන්‍ය පෙළ (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය 2024(2025) - Paper I & II",
        year = "2024(2025)",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1dancing_ol_2024_2025_official_paper/preview",
        fileName = "Grade_11_Dancing_GCE_OL_Official_Paper_2024_2025.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "dancing_gr11_term3_paper_2023_nc",
        subject = "නර්තනය",
        titleSinhala = "11 ශ්‍රේණිය - නර්තනය තෙවන වාර විභාග ප්‍රශ්න පත්‍රය (උතුරු මැද පළාත - 2023)",
        year = "2023",
        term = "3 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1dancing_gr11_term3_exam_paper_2023/preview",
        fileName = "Grade_11_Dancing_3rd_Term_Exam_Paper_2023_North_Central.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ict_gr11_term2_paper_custom",
        subject = "තොරතුරු තාක්ෂණය",
        titleSinhala = "11 ශ්‍රේණිය - තොරතුරු හා සන්නිවේදන තාක්ෂණය දෙවන වාර විභාග ප්‍රශ්න පත්‍රය 01",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1tWdUdL3DJTVUNWkmXfACdcIJKMjIZhLc/preview",
        fileName = "Grade_11_ICT_2nd_Term_Exam_Paper_01.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ict_gr11_term2_paper_custom_2",
        subject = "තොරතුරු තාක්ෂණය",
        titleSinhala = "11 ශ්‍රේණිය - තොරතුරු හා සන්නිවේදන තාක්ෂණය දෙවන වාර විභාග ප්‍රශ්න පත්‍රය 02",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1hNaVPfSS76_2Svm_f8H_J4DuBJaKvSYY/preview",
        fileName = "Grade_11_ICT_2nd_Term_Exam_Paper_02.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_health_paper_gr11_past_paper_2020",
        subject = "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය",
        titleSinhala = "11 ශ්‍රේණිය - සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය සාමාන්‍ය පෙළ (සා.පෙළ) විභාග ප්‍රශ්න පත්‍ර (2020)",
        year = "2020",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1r_ZX6LYNYqLlhucK-wA84gbDgzh5wrCC/preview",
        fileName = "Grade_11_Health_GCE_OL_2020_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "health_gr11_term2_paper_custom",
        subject = "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය",
        titleSinhala = "11 ශ්‍රේණිය - සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය දෙවන වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1r_ZX6LYNYqLlhucK-wA84gbDgzh5wrCC/preview",
        fileName = "Grade_11_Health_2nd_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "health_gr11_term3_paper_custom",
        subject = "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය",
        titleSinhala = "11 ශ්‍රේණිය - සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය තෙවන වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "3 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1E3jiwML1OV1UONDcs2CXTKaFGtwW3pS7/preview",
        fileName = "Grade_11_Health_3rd_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_commerce_paper_gr11_past_paper_2025_2026_official",
        subject = "ව්‍යාපාර අධ්‍යයනය හා ගිණුම්කරණය",
        titleSinhala = "11 ශ්‍රේණිය - ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය සාමාන්‍ය පෙළ (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය 2025(2026) - Paper I & II",
        year = "2025(2026)",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1commerce_ol_2025_2026_official_paper/preview",
        fileName = "Grade_11_Commerce_GCE_OL_Official_Paper_2025_2026.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_history_paper_gr11_past_paper_2024_2025_official",
        subject = "ඉතිහාසය",
        titleSinhala = "11 ශ්‍රේණිය - ඉතිහාසය සාමාන්‍ය පෙළ (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය 2024(2025) - Paper I & II",
        year = "2024(2025)",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1history_ol_2024_2025_official_paper/preview",
        fileName = "Grade_11_History_GCE_OL_Official_Paper_2024_2025.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_science_paper_gr11_past_paper_2024_2025_official",
        subject = "විද්‍යාව",
        titleSinhala = "11 ශ්‍රේණිය - විද්‍යාව සාමාන්‍ය පෙළ (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය 2024(2025) - Paper I & II",
        year = "2024(2025)",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1science_ol_2024_2025_official_paper/preview",
        fileName = "Grade_11_Science_GCE_OL_Official_Paper_2024_2025.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_english_paper_gr11_past_paper_2024_2025_official",
        subject = "ඉංග්‍රීසි භාෂාව",
        titleSinhala = "11 ශ්‍රේණිය - ඉංග්‍රීසි භාෂාව සාමාන්‍ය පෙළ (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය 2024(2025) - Paper I & II",
        year = "2024(2025)",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1english_ol_2024_2025_official_paper/preview",
        fileName = "Grade_11_English_GCE_OL_Official_Paper_2024_2025.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_geography_paper_gr11_past_paper_2024_2025_official",
        subject = "භූගෝල විද්‍යාව",
        titleSinhala = "11 ශ්‍රේණිය - භූගෝල විද්‍යාව සාමාන්‍ය පෙළ (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය 2024(2025) - Paper I & II",
        year = "2024(2025)",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1geography_ol_2024_2025_official_paper/preview",
        fileName = "Grade_11_Geography_GCE_OL_Official_Paper_2024_2025.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ol_civic_paper_gr11_past_paper_2024_2025_official",
        subject = "පුරවැසි අධ්‍යාපනය",
        titleSinhala = "11 ශ්‍රේණිය - පුරවැසි අධ්‍යාපනය සාමාන්‍ය පෙළ (සා.පෙළ) නිල විභාග ප්‍රශ්න පත්‍රය 2024(2025) - Paper I & II",
        year = "2024(2025)",
        term = "සා.පෙළ (O/L)",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1civic_ol_2024_2025_official_paper/preview",
        fileName = "Grade_11_Civic_Education_GCE_OL_Official_Paper_2024_2025.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "civic_gr11_term2_paper_custom",
        subject = "පුරවැසි අධ්‍යාපනය",
        titleSinhala = "11 ශ්‍රේණිය - පුරවැසි අධ්‍යාපනය දෙවන වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1x6ZULsQQXVR0Xgjl9X_CuVg2pSdHAxTY/preview",
        fileName = "Grade_11_Civic_2nd_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "buddhism_gr11_term1_paper_custom",
        subject = "බුද්ධ ධර්මය",
        titleSinhala = "11 ශ්‍රේණිය - බුද්ධ ධර්මය පළමු වාර විභාග ප්‍රශ්න පත්‍රය 01",
        year = "2024",
        term = "1 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1TcxvDaBmSPTRLS-FVVkeNUyCEcgjA5C0/preview",
        fileName = "Grade_11_Buddhism_1st_Term_Exam_Paper_01.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "buddhism_gr11_term1_paper_custom_2",
        subject = "බුද්ධ ධර්මය",
        titleSinhala = "11 ශ්‍රේණිය - බුද්ධ ධර්මය පළමු වාර විභාග ප්‍රශ්න පත්‍රය 02",
        year = "2024",
        term = "1 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/14E2Ty53fNwuAgBmGA1FJ7UwD76QsLhHg/preview",
        fileName = "Grade_11_Buddhism_1st_Term_Exam_Paper_02.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "buddhism_gr11_term2_paper_custom",
        subject = "බුද්ධ ධර්මය",
        titleSinhala = "11 ශ්‍රේණිය - බුද්ධ ධර්මය දෙවන වාර විභාග ප්‍රශ්න පත්‍රය 01",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1lR-tAq0eW5UWfIBLrcNKXluTscyzPIDa/preview",
        fileName = "Grade_11_Buddhism_2nd_Term_Exam_Paper_01.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "buddhism_gr11_term2_paper_custom_2",
        subject = "බුද්ධ ධර්මය",
        titleSinhala = "11 ශ්‍රේණිය - බුද්ධ ධර්මය දෙවන වාර විභාග ප්‍රශ්න පත්‍රය 02",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1AW-2VdUYt2OXUBFmKiB0mlDmha58RnJK/preview",
        fileName = "Grade_11_Buddhism_2nd_Term_Exam_Paper_02.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "hist_g11_term2_papers_custom_1",
        subject = "ඉතිහාසය",
        titleSinhala = "11 ශ්‍රේණිය - ඉතිහාසය දෙවන වාර විභාග ප්‍රශ්න පත්‍රය 01",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1-5nRVDmp5Yw5usg5mPuz4GGBHv36gZm5/preview",
        fileName = "Grade_11_History_2nd_Term_Exam_Paper_01.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "hist_g11_term2_papers_custom_2",
        subject = "ඉතිහාසය",
        titleSinhala = "11 ශ්‍රේණිය - ඉතිහාසය දෙවන වාර විභාග ප්‍රශ්න පත්‍රය 02",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1xDVjFIjfK8cTl1wmnin8BHZGN471d7Uq/preview",
        fileName = "Grade_11_History_2nd_Term_Exam_Paper_02.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "hist_g11_term3_papers_custom",
        subject = "ඉතිහාසය",
        titleSinhala = "11 ශ්‍රේණිය - ඉතිහාසය තෙවන වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "3 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1vI4GmSXIgL50dtVJwPNgR1Wjifj3C82W/preview",
        fileName = "Grade_11_History_3rd_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      )
    )
  }
  if (grade == "09" || grade == "9" || grade == "08" || grade == "8" || grade == "07" || grade == "7" || grade == "06" || grade == "6") {
    val gr = if (grade.length == 1) "0$grade" else grade
    val grInt = gr.toIntOrNull() ?: 6
    return listOf(
      QuestionPaperItem(
        id = "math_gr${gr}_term1_paper",
        subject = "ගණිතය",
        titleSinhala = "$grInt ශ්‍රේණිය - ගණිතය 1 වන වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "1 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1f9jYHMCPltGtG0NKICloYDdZFz-jiSW6/preview",
        fileName = "Grade_${gr}_Mathematics_1st_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "math_gr${gr}_term2_paper",
        subject = "ගණිතය",
        titleSinhala = "$grInt ශ්‍රේණිය - ගණිතය 2 වන වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1f9jYHMCPltGtG0NKICloYDdZFz-jiSW6/preview",
        fileName = "Grade_${gr}_Mathematics_2nd_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "science_gr${gr}_term1_paper",
        subject = "විද්‍යාව",
        titleSinhala = "$grInt ශ්‍රේණිය - විද්‍යාව 1 වන වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "1 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1NDclAIyinjTEYML9IjrRv4QMORbZBggc/preview",
        fileName = "Grade_${gr}_Science_1st_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "science_gr${gr}_term2_paper",
        subject = "විද්‍යාව",
        titleSinhala = "$grInt ශ්‍රේණිය - විද්‍යාව 2 වන වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1NDclAIyinjTEYML9IjrRv4QMORbZBggc/preview",
        fileName = "Grade_${gr}_Science_2nd_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "sinhala_gr${gr}_term2_paper",
        subject = "සිංහල භාෂාව හා සාහිත්‍යය",
        titleSinhala = "$grInt ශ්‍රේණිය - සිංහල භාෂාව හා සාහිත්‍යය වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1zKtgd_badE2crpYDfX8xPnxjb-lT6VvD/preview",
        fileName = "Grade_${gr}_Sinhala_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "history_gr${gr}_term2_paper",
        subject = "ඉතිහාසය",
        titleSinhala = "$grInt ශ්‍රේණිය - ඉතිහාසය වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1FB_ACv30IM6MD6bJsK41MRKUluLR5y12/preview",
        fileName = "Grade_${gr}_History_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "buddhism_gr${gr}_term2_paper",
        subject = "බුද්ධ ධර්මය",
        titleSinhala = "$grInt ශ්‍රේණිය - බුද්ධ ධර්මය වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1hP20VA2qbur4aTvLc0lXczHqheF-wrbh/preview",
        fileName = "Grade_${gr}_Buddhism_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "english_gr${gr}_term2_paper",
        subject = "ඉංග්‍රීසි භාෂාව",
        titleSinhala = "$grInt ශ්‍රේණිය - ඉංග්‍රීසි භාෂාව වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/155eu00n0_0IdrKc0wiWDqcwkqLa08ndI/preview",
        fileName = "Grade_${gr}_English_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "geo_gr${gr}_term2_paper",
        subject = "භූගෝල විද්‍යාව",
        titleSinhala = "$grInt ශ්‍රේණිය - භූගෝල විද්‍යාව වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1lO6Mmqqx_lutYKe-Hx9ax8hPB-ekNvpO/preview",
        fileName = "Grade_${gr}_Geography_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "civic_gr${gr}_term2_paper",
        subject = "පුරවැසි අධ්‍යාපනය",
        titleSinhala = "$grInt ශ්‍රේණිය - පුරවැසි අධ්‍යාපනය වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1Rb6xpu4vzS9RKVANqp8OZWuC4kuiRGRn/preview",
        fileName = "Grade_${gr}_Civic_Education_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "ict_gr${gr}_term2_paper",
        subject = "තොරතුරු තාක්ෂණය",
        titleSinhala = "$grInt ශ්‍රේණිය - තොරතුරු තාක්ෂණය (ICT) වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1IQntv3Yh1Oaxh42-btqYaFNNA9uijfx_/preview",
        fileName = "Grade_${gr}_ICT_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "pts_gr${gr}_term2_paper",
        subject = "ප්‍රායෝගික හා තාක්ෂණික කුසලතා",
        titleSinhala = "$grInt ශ්‍රේණිය - ප්‍රායෝගික හා තාක්ෂණික කුසලතා වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1kX5ozm3dsCklGg2DuGlhl19VzmJ5Cb_-/preview",
        fileName = "Grade_${gr}_PTS_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      ),
      QuestionPaperItem(
        id = "health_gr${gr}_term2_paper",
        subject = "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය",
        titleSinhala = "$grInt ශ්‍රේණිය - සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය වාර විභාග ප්‍රශ්න පත්‍රය",
        year = "2024",
        term = "2 වන වාරය",
        marks = "100",
        pdfUri = "https://drive.google.com/file/d/1EOtcHbT0Uz7Rh4BiovCvmlXEckqQJPKg/preview",
        fileName = "Grade_${gr}_Health_Term_Exam_Paper.pdf",
        isPasswordProtected = false,
        password = null
      )
    )
  }
  return emptyList()
}

fun getVideosForGrade(grade: String): List<VideoLessonItem> {
  return emptyList()
}

@Composable
fun GradeNotApprovedAlertModal(
  targetGrade: String,
  userRequestedPackage: String,
  onDismiss: () -> Unit,
  onRequestApproval: () -> Unit
) {
  val context = LocalContext.current
  val whatsappUrl = "https://wa.me/94772843861?text=Hello,%20I%20would%20like%20to%20request%20Admin%20Approval%20for%20Grade%20$targetGrade%20PDF%20Access."

  AlertDialog(
    onDismissRequest = onDismiss,
    icon = {
      Box(
        modifier = Modifier
          .size(52.dp)
          .clip(CircleShape)
          .background(Color(0xFFFEE2E2)),
        contentAlignment = Alignment.Center
      ) {
        Icon(
          imageVector = Icons.Default.Lock,
          contentDescription = "Grade Restricted",
          tint = Color(0xFFDC2626),
          modifier = Modifier.size(28.dp)
        )
      }
    },
    title = {
      Text(
        text = "🔒 $targetGrade ශ්‍රේණියේ PDF සීමා කර ඇත",
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color(0xFF1E293B),
        textAlign = TextAlign.Center
      )
    },
    text = {
      Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(
          text = "මෙම PDF අන්තර්ගතය අයත් වන්නේ $targetGrade ශ්‍රේණියටයි. ඔබගේ ගිණුමට දැනට අනුමැතිය ලැබී ඇත්තේ '$userRequestedPackage' සඳහා පමණි.",
          fontSize = 12.sp,
          color = Color(0xFF475569),
          textAlign = TextAlign.Center,
          lineHeight = 18.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Surface(
          shape = RoundedCornerShape(10.dp),
          color = Color(0xFFEFF6FF),
          border = BorderStroke(1.dp, Color(0xFFBFDBFE)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(Icons.Default.Shield, contentDescription = "Features Hub Open", tint = Color(0xFF1D4ED8), modifier = Modifier.size(16.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = "විශේෂාංග කලාපය ඔබට විවෘතයි!",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1D4ED8)
              )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "විශේෂාංග කලාපයේ ඇති සියලුම මෙවලම් ඕනෑම වසරක අනුමැතියක් සහිතව පරිශීලනය කළ හැක. $targetGrade ශ්‍රේණියේ කෙටි සටහන් හා ප්‍රශ්න පත්‍ර (PDF) විවෘත කරගැනීමට ඇඩ්මින් අනුමැතිය ලබාගන්න.",
              fontSize = 10.sp,
              color = Color(0xFF1E40AF),
              lineHeight = 14.sp
            )
          }
        }
      }
    },
    confirmButton = {
      Button(
        onClick = {
          onDismiss()
          onRequestApproval()
        },
        colors = ButtonDefaults.buttonColors(containerColor = BluePrimary),
        shape = RoundedCornerShape(10.dp)
      ) {
        Icon(Icons.Default.WorkspacePremium, contentDescription = "Upgrade", modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.width(6.dp))
        Text("අනුමැතිය ලබාගන්න (Request)", fontSize = 12.sp)
      }
    },
    dismissButton = {
      Row {
        TextButton(
          onClick = {
            try {
              val intent = Intent(Intent.ACTION_VIEW, Uri.parse(whatsappUrl))
              context.startActivity(intent)
            } catch (e: Exception) {
              Toast.makeText(context, "0772843861 අංකයට WhatsApp කරන්න", Toast.LENGTH_SHORT).show()
            }
          }
        ) {
          Text("WhatsApp", fontSize = 11.sp, color = Color(0xFF16A34A), fontWeight = FontWeight.Bold)
        }
        TextButton(onClick = onDismiss) {
          Text("වසන්න", fontSize = 11.sp)
        }
      }
    }
  )
}

@Composable
fun UnlimitedAccessPaymentDialog(
  initialPackage: String = "10 සහ 11 ශ්‍රේණි (O/L Combo Pack)",
  onDismiss: () -> Unit,
  onOpenLogin: () -> Unit,
  onSubmitReceipt: (name: String, phone: String, requestedPackage: String, receiptUri: Uri?) -> Unit
) {
  val context = LocalContext.current
  val savedPhone = getSavedLoggedInUserPhone(context) ?: ""
  var studentName by remember { mutableStateOf("") }
  var studentPhone by remember { mutableStateOf(savedPhone) }
  var selectedSlipUri by remember { mutableStateOf<Uri?>(null) }
  var selectedSlipName by remember { mutableStateOf<String?>(null) }
  var selectedPackage by remember { mutableStateOf(initialPackage) }

  val gradePackages = listOf(
    "10 සහ 11 ශ්‍රේණි (O/L Combo Pack)" to "⭐ 10 සහ 11 ශ්‍රේණි දෙකම එකවර (O/L Combo)",
    "10 ශ්‍රේණිය (Grade 10 Single Pack)" to "10 ශ්‍රේණිය පමණක් (Grade 10)",
    "11 ශ්‍රේණිය (Grade 11 Single Pack)" to "11 ශ්‍රේණිය පමණක් (Grade 11 - O/L)"
  )

  val slipPickerLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.GetContent()
  ) { uri: Uri? ->
    if (uri != null) {
      selectedSlipUri = uri
      selectedSlipName = getFileNameFromUri(context, uri)
      Toast.makeText(context, "රිසිට්පත තෝරාගන්නා ලදී: $selectedSlipName", Toast.LENGTH_SHORT).show()
    }
  }

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(
      decorFitsSystemWindows = false,
      usePlatformDefaultWidth = false
    )
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth(0.95f)
        .fillMaxHeight(0.90f)
        .imePadding()
        .systemBarsPadding()
        .padding(vertical = 10.dp, horizontal = 6.dp),
      contentAlignment = Alignment.Center
    ) {
      Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        border = BorderStroke(1.2.dp, Color(0xFFF59E0B)),
        modifier = Modifier
          .fillMaxWidth()
          .wrapContentHeight()
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          // Header with Gold Badge and Close Button
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Surface(
              shape = RoundedCornerShape(8.dp),
              color = Color(0xFFFFF8E1),
              border = BorderStroke(1.dp, Color(0xFFFFD54F))
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Icon(
                  imageVector = Icons.Default.WorkspacePremium,
                  contentDescription = "Premium",
                  tint = Color(0xFFE65100),
                  modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                  text = "මාස 6ක සාමාජිකත්වය",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFFE65100)
                )
              }
            }

            IconButton(
              onClick = onDismiss,
              modifier = Modifier.size(28.dp)
            ) {
              Icon(Icons.Default.Close, contentDescription = "Close", tint = NeutralMedium)
            }
          }

          Spacer(modifier = Modifier.height(8.dp))

          // 1. Title
          Text(
            text = "Unlimited Access ඇඩ්මින් අනුමැතිය ලබාගැනීම",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0F172A),
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth()
          )

          Spacer(modifier = Modifier.height(10.dp))

          // 2. HIGHLIGHTED BANK DETAILS CARD (PROMINENTLY DISPLAYED AT TOP FOR STUDENT)
          Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFFF0F7FF),
            border = BorderStroke(1.5.dp, Color(0xFF3B82F6)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Text(
                text = "ඔබගේ පැය 24ක නොමිලේ පරිශීලක කාලය අවසන් වී ඇත. සීමාවකින් තොරව මාස 6ක භාවිතය සඳහා රු. 1000ක මුදලක් පහත ගිණුමට තැන්පත් කර ස්ලිප් එකේ පැහැදිලි ඡායාරූපයක් එක් කරන්න.",
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E3A8A),
                lineHeight = 16.sp
              )
              
              Spacer(modifier = Modifier.height(6.dp))
              
              Text(
                text = "වැඩි විස්තර - ඇඩ්මින් 0772843861",
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFC62828)
              )

              Spacer(modifier = Modifier.height(12.dp))
              HorizontalDivider(color = Color(0xFFBFDBFE))
              Spacer(modifier = Modifier.height(12.dp))
              Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                  imageVector = Icons.Default.AccountBalance,
                  contentDescription = "Bank",
                  tint = BluePrimary,
                  modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                  text = "🏛️ ලංකා බැංකුව (Bank of Ceylon)",
                  fontWeight = FontWeight.Bold,
                  fontSize = 13.sp,
                  color = BluePrimary
                )
              }

              Spacer(modifier = Modifier.height(8.dp))
              
              CopyableDetailBar("ගිණුම් අංකය (Account Number)", "90313771")
              CopyableDetailBar("ගිණුම් නම (Account Name)", "D.H.M A P DISANAYAKA")
              CopyableDetailBar("ශාඛාව (Branch)", "අඹන්පොල ශාඛාව (Bank of Ceylon)")
            }
          }

          Spacer(modifier = Modifier.height(12.dp))

          // 3. Grade Package Selection UI
          Text(
            text = "🎓 ඔබ අනුමැතිය ඉල්ලා සිටින ශ්‍රේණිය තෝරන්න:",
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = NeutralDark,
            modifier = Modifier.fillMaxWidth()
          )

          Spacer(modifier = Modifier.height(6.dp))

          Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            gradePackages.forEach { (pkgKey, pkgLabel) ->
              val isSelected = selectedPackage == pkgKey
              Surface(
                onClick = { selectedPackage = pkgKey },
                shape = RoundedCornerShape(10.dp),
                color = if (isSelected) Color(0xFFEFF6FF) else Color(0xFFF8FAFC),
                border = BorderStroke(1.5.dp, if (isSelected) BluePrimary else NeutralBorderLight),
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Box(
                    modifier = Modifier
                      .size(18.dp)
                      .clip(CircleShape)
                      .background(if (isSelected) BluePrimary else Color.Transparent)
                      .border(2.dp, if (isSelected) BluePrimary else NeutralMedium, CircleShape),
                    contentAlignment = Alignment.Center
                  ) {
                    if (isSelected) {
                      Box(
                        modifier = Modifier
                          .size(8.dp)
                          .clip(CircleShape)
                          .background(Color.White)
                      )
                    }
                  }
                  Spacer(modifier = Modifier.width(10.dp))
                  Text(
                    text = pkgLabel,
                    fontSize = 11.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    color = if (isSelected) BluePrimary else NeutralDark
                  )
                }
              }
            }
          }

          Spacer(modifier = Modifier.height(12.dp))

          // 4. Student Input Details Card
          Surface(
            shape = RoundedCornerShape(14.dp),
            color = Color(0xFFF8FAFC),
            border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Text(
                text = "📝 ඔබගේ තොරතුරු (Student Information)",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = NeutralDark
              )

              Spacer(modifier = Modifier.height(8.dp))

              androidx.compose.material3.OutlinedTextField(
                value = studentName,
                onValueChange = { studentName = it },
                label = { Text("ඔබගේ සම්පූර්ණ නම (Your Name)") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
              )

              Spacer(modifier = Modifier.height(8.dp))

              androidx.compose.material3.OutlinedTextField(
                value = studentPhone,
                onValueChange = { studentPhone = it },
                label = { Text("දුරකථන / WhatsApp අංකය (Phone)") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
              )

              Spacer(modifier = Modifier.height(10.dp))

              // Bank Slip Selection Section
              Text(
                text = "බැංකු රිසිට්පත (Bank Slip / Screenshot) - විකල්ප (Optional):",
                fontSize = 10.5.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF475569)
              )

              Spacer(modifier = Modifier.height(4.dp))

              if (selectedSlipUri != null) {
                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = Color(0xFFE8F5E9),
                  border = BorderStroke(1.dp, Color(0xFFA5D6A7)),
                  modifier = Modifier.fillMaxWidth().padding(bottom = 6.dp)
                ) {
                  Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                  ) {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                      Icon(Icons.Default.CheckCircle, contentDescription = "Selected", tint = Color(0xFF2E7D32), modifier = Modifier.size(18.dp))
                      Spacer(modifier = Modifier.width(6.dp))
                      Text(
                        text = selectedSlipName ?: "රිසිට්පත තෝරා ඇත",
                        fontSize = 11.sp,
                        color = Color(0xFF1B5E20),
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                      )
                    }
                    Row {
                      TextButton(
                        onClick = { slipPickerLauncher.launch("image/*") },
                        contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp)
                      ) {
                        Text("වෙනස් කරන්න", fontSize = 10.sp)
                      }
                      IconButton(
                        onClick = {
                          selectedSlipUri = null
                          selectedSlipName = null
                        },
                        modifier = Modifier.size(24.dp)
                      ) {
                        Icon(Icons.Default.Close, contentDescription = "Remove", tint = Color.Red, modifier = Modifier.size(16.dp))
                      }
                    }
                  }
                }
              } else {
                OutlinedButton(
                  onClick = { slipPickerLauncher.launch("image/*") },
                  shape = RoundedCornerShape(8.dp),
                  border = BorderStroke(1.dp, Color(0xFF94A3B8)),
                  modifier = Modifier.fillMaxWidth().height(38.dp)
                ) {
                  Icon(
                    imageVector = Icons.Default.UploadFile,
                    contentDescription = "Select Slip",
                    tint = Color(0xFF475569),
                    modifier = Modifier.size(16.dp)
                  )
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = "📎 බැංකු රිසිට්පත තෝරන්න (Bank Slip Upload)",
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF334155)
                  )
                }
              }
            }
          }

          Spacer(modifier = Modifier.height(14.dp))

          // 5. PRIMARY ACTION: AUTOMATICALLY RECORDS IN APP AND LAUNCHES WHATSAPP DIRECTLY TO ADMIN
          Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            Button(
              onClick = {
                if (studentName.isBlank() || studentPhone.isBlank()) {
                  Toast.makeText(context, "කරුණාකර ඔබගේ නම සහ දුරකථන අංකය ඇතුළත් කරන්න", Toast.LENGTH_SHORT).show()
                } else {
                  onSubmitReceipt(studentName.trim(), studentPhone.trim(), selectedPackage, selectedSlipUri)

                  val nowTimeFormatted = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(Date())
                  val (devId, devName) = getDeviceIdentifier(context)
                  val slipNote = if (selectedSlipUri != null) "රිසිට්පත තෝරා ඇත (ස්ලිප් පත මෙයට අමුණා ඇත)" else "WhatsApp හරහා රිසිට්පත එවනු ලැබේ"
                  val wpMessage = """
🌟 *O/L Guru - ඇඩ්මින් අනුමැති ඉල්ලීම* 🌟
-----------------------------------------
👤 *ශිෂ්‍යයාගේ නම:* ${studentName.trim()}
📞 *දුරකථන අංකය:* ${studentPhone.trim()}
📦 *ඉල්ලුම් කළ පැකේජය:* $selectedPackage
💰 *ගෙවීම් මුදල:* රු. 1,000 (මාස 6ක් සඳහා)
🏦 *තැන්පත් කළ ගිණුම:* ලංකා බැංකුව 90313771
📅 *දිනය:* $nowTimeFormatted
📱 *උපාංගය:* $devName
🆔 *Hardware ID:* $devId
-----------------------------------------
මම ලංකා බැංකුවේ 90313771 ගිණුමට රු. 1,000 තැන්පත් කළ අතර, ඇප් එක තුළද අනුමැති ඉල්ලීම ස්වයංක්‍රීයව සටහන් විය. කරුණාකර මගේ ගිණුම අනුමත කර දෙන්න. ($slipNote)
""".trimIndent()

                  val wpUri = Uri.parse("https://wa.me/94772843861?text=" + Uri.encode(wpMessage))
                  val intent = Intent(Intent.ACTION_VIEW, wpUri)
                  try {
                    context.startActivity(intent)
                  } catch (_: Exception) {
                    Toast.makeText(context, "WhatsApp විවෘත කිරීමට නොහැකි විය: 0772843861 අංකයට යොමු කරන්න", Toast.LENGTH_LONG).show()
                  }

                  Toast.makeText(
                    context,
                    "✅ අනුමැති ඉල්ලීම ඇප් එකේ සටහන් විය! දැන් WhatsApp හරහා ඇඩ්මින්ට යවන්න.",
                    Toast.LENGTH_LONG
                  ).show()
                  onDismiss()
                }
              },
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF25D366)),
              shape = RoundedCornerShape(12.dp),
              modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
            ) {
              Icon(Icons.Default.Chat, contentDescription = "WhatsApp", tint = Color.White, modifier = Modifier.size(20.dp))
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = "📲 WhatsApp (077 284 3861) හරහා යවන්න",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.White
              )
            }
          }

          Spacer(modifier = Modifier.height(8.dp))

          // SECONDARY ACTION: SUBMIT WITHIN APP ONLY
          OutlinedButton(
            onClick = {
              if (studentName.isBlank() || studentPhone.isBlank()) {
                Toast.makeText(context, "කරුණාකර ඔබගේ නම සහ දුරකථන අංකය ඇතුළත් කරන්න", Toast.LENGTH_SHORT).show()
              } else {
                onSubmitReceipt(studentName.trim(), studentPhone.trim(), selectedPackage, selectedSlipUri)
                Toast.makeText(
                  context,
                  "✅ අනුමැති ඉල්ලීම සාර්ථකව යොමු කරන ලදී! ඇඩ්මින් විසින් පරීක්ෂා කර ඔබගේ ගිණුම සක්‍රිය කරනු ඇත.",
                  Toast.LENGTH_LONG
                ).show()
                onDismiss()
              }
            },
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, Color(0xFF137333)),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF137333)),
            modifier = Modifier.fillMaxWidth().height(40.dp)
          ) {
            Icon(Icons.Default.Send, contentDescription = "Submit", modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "ඇප් එක හරහා පමණක් යොමු කරන්න (Submit in App Only)",
              fontWeight = FontWeight.SemiBold,
              fontSize = 10.5.sp
            )
          }

          Spacer(modifier = Modifier.height(12.dp))

          // 6. Direct WhatsApp Support Link
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFFF1F5F9),
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .clickable {
                  try {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/94772843861"))
                    context.startActivity(intent)
                  } catch (_: Exception) {}
                }
                .padding(horizontal = 10.dp, vertical = 8.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Icon(Icons.Default.Phone, contentDescription = "Support", tint = BluePrimary, modifier = Modifier.size(16.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = "වැඩිදුර සහය සඳහා ඇඩ්මින් අමතන්න (WhatsApp) : 0772843861",
                fontSize = 10.5.sp,
                color = Color(0xFF1E293B)
              )
            }
          }

          Spacer(modifier = Modifier.height(8.dp))

          TextButton(
            onClick = {
              onDismiss()
              onOpenLogin()
            }
          ) {
            Text("දැනටමත් අනුමත ගිණුමක් තිබේද? ලොගින් වන්න / Admin ප්‍රවේශය", fontSize = 11.sp, color = BluePrimary)
          }
        }
      }
    }
  }
}

@Composable
fun ReceiptPreviewDialog(
  receiptUriString: String,
  onDismiss: () -> Unit
) {
  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false)
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth(0.92f)
        .padding(16.dp),
      contentAlignment = Alignment.Center
    ) {
      Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        border = BorderStroke(1.dp, NeutralBorderLight),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(Icons.Default.ReceiptLong, contentDescription = "Receipt", tint = BluePrimary)
              Spacer(modifier = Modifier.width(8.dp))
              Text("ගෙවීම් රිසිට්පත (Bank Deposit Slip)", fontWeight = FontWeight.Bold, fontSize = 14.sp)
            }
            IconButton(onClick = onDismiss) {
              Icon(Icons.Default.Close, contentDescription = "Close")
            }
          }

          Spacer(modifier = Modifier.height(10.dp))

          Box(
            modifier = Modifier
              .fillMaxWidth()
              .height(360.dp)
              .clip(RoundedCornerShape(12.dp))
              .background(Color(0xFFF1F5F9)),
            contentAlignment = Alignment.Center
          ) {
            AsyncImage(
              model = receiptUriString,
              contentDescription = "Payment Receipt",
              modifier = Modifier.fillMaxSize(),
              contentScale = ContentScale.Fit
            )
          }

          Spacer(modifier = Modifier.height(14.dp))

          Button(
            onClick = onDismiss,
            colors = ButtonDefaults.buttonColors(containerColor = BluePrimary),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Text("Close Preview")
          }
        }
      }
    }
  }
}

@Composable
private fun CopyableDetailBar(label: String, value: String) {
  val context = LocalContext.current
  Surface(
    shape = RoundedCornerShape(8.dp),
    color = Color.White,
    border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
    modifier = Modifier.fillMaxWidth().padding(vertical = 3.dp)
  ) {
    Row(
      modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Column(modifier = Modifier.weight(1f)) {
        Text(text = label, fontSize = 9.sp, color = Color(0xFF64748B), fontWeight = FontWeight.Medium)
        Text(text = value, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E293B))
      }
      Surface(
        onClick = {
          val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
          val clip = ClipData.newPlainText(label, value)
          clipboard.setPrimaryClip(clip)
          Toast.makeText(context, "✅ $label පිටපත් විය!", Toast.LENGTH_SHORT).show()
        },
        shape = RoundedCornerShape(6.dp),
        color = Color(0xFFF1F5F9),
        modifier = Modifier.size(32.dp)
      ) {
        Box(contentAlignment = Alignment.Center) {
          Icon(
            imageVector = Icons.Default.ContentCopy,
            contentDescription = "Copy",
            tint = Color(0xFF3B82F6),
            modifier = Modifier.size(14.dp)
          )
        }
      }
    }
  }
}

@Composable
fun LoginAndApprovalDialog(
  registeredUsers: SnapshotStateList<UserAccount>,
  onLoginSuccess: (UserAccount) -> Unit,
  onAdminLoginSuccess: () -> Unit,
  onDismiss: () -> Unit,
  onUsersUpdated: () -> Unit = {},
  onUploadPdfToFirebase: (title: String, grade: String, category: String, subject: String, uri: Uri?, fileName: String?) -> Unit = { _, _, _, _, _, _ -> },
  onPickPdf: () -> Unit = {},
  selectedPdfFileName: String? = null,
  selectedPdfUri: Uri? = null,
  initialTab: Int = 0,
  onPreviewReceipt: (String) -> Unit = {},
  adminBroadcastMessages: SnapshotStateList<AdminBroadcastMessage>? = null,
  onSendBroadcastMessage: (title: String, message: String, priority: BroadcastPriority, targetGrade: String) -> Unit = { _, _, _, _ -> },
  stagedContentItems: SnapshotStateList<StagedContentItem>? = null,
  onReleaseAllStaged: () -> Unit = {},
  onOpenStagingDialog: () -> Unit = {},
  onAddNewContentClick: () -> Unit = {}
) {
  val context = LocalContext.current
  val coroutineScope = androidx.compose.runtime.rememberCoroutineScope()
  val (currDevId, _) = getDeviceIdentifier(context)
  val savedPhone = getSavedLoggedInUserPhone(context)
  val pendingUserForDevice = registeredUsers.find { 
    (it.boundDeviceId == currDevId || (!savedPhone.isNullOrBlank() && it.usernameOrPhone.trim().equals(savedPhone.trim(), ignoreCase = true))) 
    && !it.isApproved && !isAuthorizedAdminUser(it.usernameOrPhone) 
  }
  var selectedTab by remember(initialTab) { mutableStateOf(if (pendingUserForDevice != null) 0 else 0) } // Force Registration tab (0) as default

  // Login Form State
  var loginPhone by remember { mutableStateOf("") }
  var loginPassword by remember { mutableStateOf("") }
  var showLoginPassword by remember { mutableStateOf(false) }

  // Register Form State
  var regName by remember { mutableStateOf("") }
  var regPhone by remember { mutableStateOf("") }
  var regPassword by remember { mutableStateOf("") }
  var regSlipUri by remember { mutableStateOf<Uri?>(null) }
  var regSlipName by remember { mutableStateOf<String?>(null) }

  val regSlipPickerLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.GetContent()
  ) { uri: Uri? ->
    if (uri != null) {
      regSlipUri = uri
      regSlipName = getFileNameFromUri(context, uri)
      Toast.makeText(context, "බැංකු රිසිට්පත තෝරාගන්නා ලදී: $regSlipName", Toast.LENGTH_SHORT).show()
    }
  }

  var autoApproveNewUser by remember { mutableStateOf(true) }
  var showRegSuccessDialog by remember { mutableStateOf(false) }

  // Device Lock State
  var deviceLockedUserForAlert by remember { mutableStateOf<UserAccount?>(null) }

  // Admin Form State (Strictly restricted to 0772843861, 0717136085, prabathakila450@gmail.com)
  var adminPhoneOrEmail by remember { mutableStateOf("") }
  var adminUsername by remember { mutableStateOf("") }
  var adminNic by remember { mutableStateOf("") }
  var adminPasscode by remember { mutableStateOf("") }
  var isAdminUnlocked by remember { mutableStateOf(false) }

  // Admin Firebase PDF Upload State
  var adminPdfTitle by remember { mutableStateOf("") }
  var adminPdfGrade by remember { mutableStateOf("11") }
  var adminPdfCategory by remember { mutableStateOf("NOTE") } // "NOTE" or "PAPER"
  var adminPdfSubject by remember { mutableStateOf("විද්‍යාව") }

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(
      decorFitsSystemWindows = false,
      usePlatformDefaultWidth = false,
      securePolicy = AppSecurityManager.getSecureFlagPolicy()
    )
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth(0.95f)
        .fillMaxHeight(0.90f)
        .imePadding()
        .systemBarsPadding()
        .padding(vertical = 8.dp, horizontal = 6.dp),
      contentAlignment = Alignment.Center
    ) {
      Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        border = BorderStroke(1.dp, NeutralBorderLight),
        modifier = Modifier
          .fillMaxWidth()
          .wrapContentHeight()
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          // Dialog Close Header
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              modifier = Modifier.weight(1f)
            ) {
              Box(
                modifier = Modifier
                  .size(44.dp)
                  .clip(CircleShape)
                  .background(BluePrimaryContainer),
                contentAlignment = Alignment.Center
              ) {
                Icon(
                  imageVector = Icons.Default.Lock,
                  contentDescription = "Lock",
                  tint = BluePrimary,
                  modifier = Modifier.size(24.dp)
                )
              }
              Spacer(modifier = Modifier.width(10.dp))
              Column {
                Text(
                  text = "🔒 ඇඩ්මින් අනුමැතිය (Admin Approval)",
                  style = MaterialTheme.typography.titleMedium,
                  fontWeight = FontWeight.Bold,
                  color = NeutralDark
                )
                Text(
                  text = "PDF නැරඹීමට ලියාපදිංචි වී අනුමැතිය ලබාගන්න",
                  fontSize = 10.sp,
                  color = NeutralMedium
                )
              }
            }

            IconButton(onClick = onDismiss) {
              Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close",
                tint = NeutralMedium
              )
            }
          }

          Spacer(modifier = Modifier.height(16.dp))

        // Tabs Header (Unified Student & Admin Registration)
        Surface(
          shape = RoundedCornerShape(12.dp),
          color = Color(0xFFF1F5F9),
          modifier = Modifier.fillMaxWidth()
        ) {
          TabRow(
            selectedTabIndex = selectedTab.coerceIn(0, 1),
            containerColor = Color(0xFFF1F5F9),
            contentColor = BluePrimary,
            indicator = {}
          ) {
            Tab(
              selected = selectedTab == 0,
              onClick = { selectedTab = 0 },
              text = {
                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = if (selectedTab == 0) Color.White else Color.Transparent,
                  shadowElevation = if (selectedTab == 0) 1.dp else 0.dp,
                  modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                ) {
                  Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(vertical = 6.dp)) {
                    Text(
                      "ලියාපදිංචිය",
                      fontWeight = if (selectedTab == 0) FontWeight.Bold else FontWeight.Medium,
                      fontSize = 12.sp,
                      color = if (selectedTab == 0) Color(0xFF137333) else NeutralMedium
                    )
                  }
                }
              }
            )
            Tab(
              selected = selectedTab == 1,
              onClick = { selectedTab = 1 },
              text = {
                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = if (selectedTab == 1) Color.White else Color.Transparent,
                  shadowElevation = if (selectedTab == 1) 1.dp else 0.dp,
                  modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                ) {
                  Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(vertical = 6.dp)) {
                    Text(
                      "👑 ඇඩ්මින්",
                      fontWeight = if (selectedTab == 1) FontWeight.Bold else FontWeight.Medium,
                      fontSize = 12.sp,
                      color = if (selectedTab == 1) Color(0xFFB45309) else NeutralMedium
                    )
                  }
                }
              }
            )
          }
        }

        Spacer(modifier = Modifier.height(20.dp))

        when (selectedTab) {
          0 -> {
            // REGISTER FORM
            if (pendingUserForDevice != null) {
              // PROMINENT PENDING APPROVAL STATUS CARD
              Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color(0xFFFFF7ED),
                border = BorderStroke(2.dp, Color(0xFFF97316)),
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
              ) {
                Column(
                  modifier = Modifier.padding(16.dp),
                  horizontalAlignment = Alignment.CenterHorizontally
                ) {
                  Icon(
                    imageVector = Icons.Default.Pending,
                    contentDescription = "Pending",
                    tint = Color(0xFFF97316),
                    modifier = Modifier.size(56.dp)
                  )
                  Spacer(modifier = Modifier.height(14.dp))
                  Text(
                    text = "අනුමැතිය පොරොත්තු ලේඛනයේ ඇත",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 17.sp,
                    color = Color(0xFF9A3412),
                    textAlign = TextAlign.Center
                  )
                  Text(
                    text = "(Approval Pending)",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF9A3412),
                    textAlign = TextAlign.Center
                  )
                  
                  Spacer(modifier = Modifier.height(14.dp))
                  HorizontalDivider(color = Color(0xFFFFEDD5))
                  Spacer(modifier = Modifier.height(14.dp))
                  
                  Text(
                    text = "👤 නම: ${pendingUserForDevice.fullName}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.5.sp,
                    color = Color(0xFF431407)
                  )
                  Text(
                    text = "📞 දුරකථනය: ${pendingUserForDevice.usernameOrPhone}",
                    fontSize = 13.sp,
                    color = Color(0xFF431407)
                  )
                  
                  Spacer(modifier = Modifier.height(16.dp))
                  
                  Text(
                    text = "ඔබ දැනටමත් සාර්ථකව ලියාපදිංචි වී ඇත. ඇඩ්මින් විසින් ඔබගේ විස්තර පරීක්ෂා කර අනුමත කරන තෙක් කරුණාකර රැඳී සිටින්න. අනුමත වූ පසු ඔබට සියලුම අන්තර්ගතයන් විවෘත වනු ඇත.",
                    fontSize = 11.5.sp,
                    color = Color(0xFF7C2D12),
                    textAlign = TextAlign.Center,
                    lineHeight = 17.sp
                  )
                  
                  Spacer(modifier = Modifier.height(20.dp))
                  
                  Button(
                    onClick = {
                      val whatsappMsg = "ආයුබෝවන් ඇඩ්මින්!\n\nමම O/L Guru ඇප් එකේ ලියාපදිංචි වී අනුමැතිය අපේක්ෂාවෙන් සිටිමි. කරුණාකර මගේ ගිණුම පරීක්ෂා කර අනුමත කරන්න.\n\n👤 නම: ${pendingUserForDevice.fullName}\n📞 අංකය: ${pendingUserForDevice.usernameOrPhone}\n📦 පැකේජය: 10 ශ්‍රේණිය හා 11 ශ්‍රේණිය\n\nස්තූතියි!"
                      val encodedMsg = Uri.encode(whatsappMsg)
                      val wpUri = Uri.parse("https://wa.me/94772843861?text=$encodedMsg")
                      val intent = Intent(Intent.ACTION_VIEW, wpUri)
                      try {
                        context.startActivity(intent)
                      } catch (_: Exception) {}
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF97316)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth().height(46.dp)
                  ) {
                    Icon(Icons.Default.Chat, contentDescription = "WhatsApp")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("ඇඩ්මින්ට WhatsApp පණිවිඩයක් යවන්න", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                  }
                }
              }
            } else {
              Text(
                text = "නව ශිෂ්‍ය ලියාපදිංචිය (New Registration)",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = NeutralDark,
                modifier = Modifier.fillMaxWidth()
              )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = "ලියාපදිංචි වන මුල් දුරකථනයට පමණක් ගිණුම ආරක්ෂිතව සම්බන්ධ වේ (Device Locked).",
              fontSize = 11.sp,
              color = NeutralMedium,
              modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Sleek Permanent Bank Details Card for Registration Form
            Surface(
              shape = RoundedCornerShape(12.dp),
              color = Color(0xFFF0F7FF),
              border = BorderStroke(1.2.dp, Color(0xFF3B82F6)),
              modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Text(
                  text = "ඔබගේ පැය 24ක නොමිලේ පරිශීලක කාලය අවසන් වී ඇත. සීමාවකින් තොරව මාස 6ක භාවිතය සඳහා රු. 1000ක මුදලක් පහත ගිණුමට තැන්පත් කර ස්ලිප් එකේ පැහැදිලි ඡායාරූපයක් එක් කරන්න.",
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF1E3A8A),
                  lineHeight = 16.sp
                )
                
                Spacer(modifier = Modifier.height(10.dp))



                Spacer(modifier = Modifier.height(10.dp))
                HorizontalDivider(color = Color(0xFFBFDBFE))
                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                  Icon(Icons.Default.AccountBalance, contentDescription = "Bank", tint = BluePrimary, modifier = Modifier.size(18.dp))
                  Spacer(modifier = Modifier.width(8.dp))
                  Text("🏛️ ලංකා බැංකුව (Bank of Ceylon)", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = BluePrimary)
                }

                Spacer(modifier = Modifier.height(8.dp))
                
                CopyableDetailBar("ගිණුම් අංකය (Account Number)", "90313771")
                CopyableDetailBar("ගිණුම් නම (Account Name)", "D.H.M A P DISANAYAKA")
                CopyableDetailBar("ශාඛාව (Branch)", "අඹන්පොල ශාඛාව (Bank of Ceylon)")
              }
            }



            androidx.compose.material3.OutlinedTextField(
              value = regName,
              onValueChange = { regName = it },
              label = { Text("සම්පූර්ණ නම (Full Name)") },
              leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Name") },
              textStyle = TextStyle(color = Color.Black, fontSize = 14.sp),
              colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedLabelColor = Color(0xFF1E3A8A),
                unfocusedLabelColor = Color(0xFF4B5563),
                focusedBorderColor = Color(0xFF1E3A8A),
                unfocusedBorderColor = Color(0xFFD1D5DB),
                cursorColor = Color.Black,
                focusedPlaceholderColor = Color.Gray,
                unfocusedPlaceholderColor = Color.Gray
              ),
              singleLine = true,
              modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))

            androidx.compose.material3.OutlinedTextField(
              value = regPhone,
              onValueChange = { regPhone = it },
              label = { Text("දුරකථන අංකය (Phone Number)") },
              leadingIcon = { Icon(Icons.Default.Phone, contentDescription = "Phone") },
              textStyle = TextStyle(color = Color.Black, fontSize = 14.sp),
              colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedLabelColor = Color(0xFF1E3A8A),
                unfocusedLabelColor = Color(0xFF4B5563),
                focusedBorderColor = Color(0xFF1E3A8A),
                unfocusedBorderColor = Color(0xFFD1D5DB),
                cursorColor = Color.Black,
                focusedPlaceholderColor = Color.Gray,
                unfocusedPlaceholderColor = Color.Gray
              ),
              singleLine = true,
              modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))

            androidx.compose.material3.OutlinedTextField(
              value = regPassword,
              onValueChange = { regPassword = it },
              label = { Text("නව මුරපදය (Password)") },
              leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Password") },
              textStyle = TextStyle(color = Color.Black, fontSize = 14.sp),
              colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedLabelColor = Color(0xFF1E3A8A),
                unfocusedLabelColor = Color(0xFF4B5563),
                focusedBorderColor = Color(0xFF1E3A8A),
                unfocusedBorderColor = Color(0xFFD1D5DB),
                cursorColor = Color.Black,
                focusedPlaceholderColor = Color.Gray,
                unfocusedPlaceholderColor = Color.Gray
              ),
              visualTransformation = PasswordVisualTransformation(),
              singleLine = true,
              modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Bank Receipt Upload Section at bottom of detail fields
            Text(
              text = "📸 බැංකු රිසිට්පත (Bank Slip / Screenshot) - විකල්ප:",
              fontSize = 11.5.sp,
              fontWeight = FontWeight.SemiBold,
              color = Color(0xFF1E3A8A),
              modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(4.dp))

            if (regSlipUri != null) {
              Surface(
                shape = RoundedCornerShape(10.dp),
                color = Color(0xFFECFDF5),
                border = BorderStroke(1.dp, Color(0xFF10B981)),
                modifier = Modifier.fillMaxWidth().padding(bottom = 6.dp)
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.SpaceBetween
                ) {
                  Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.CheckCircle, contentDescription = "Selected", tint = Color(0xFF059669), modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                      text = regSlipName ?: "බැංකු රිසිට්පත ඇමුණා ඇත",
                      fontSize = 11.sp,
                      color = Color(0xFF065F46),
                      fontWeight = FontWeight.Bold,
                      maxLines = 1,
                      overflow = TextOverflow.Ellipsis
                    )
                  }
                  Row {
                    TextButton(
                      onClick = { regSlipPickerLauncher.launch("image/*") },
                      contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                      Text("වෙනස් කරන්න", fontSize = 10.sp)
                    }
                    IconButton(
                      onClick = {
                        regSlipUri = null
                        regSlipName = null
                      },
                      modifier = Modifier.size(24.dp)
                    ) {
                      Icon(Icons.Default.Close, contentDescription = "Remove", tint = Color.Red, modifier = Modifier.size(16.dp))
                    }
                  }
                }
              }
            } else {
              OutlinedButton(
                onClick = { regSlipPickerLauncher.launch("image/*") },
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.2.dp, Color(0xFF2563EB)),
                modifier = Modifier.fillMaxWidth().height(42.dp)
              ) {
                Icon(
                  imageVector = Icons.Default.UploadFile,
                  contentDescription = "Upload Slip",
                  tint = Color(0xFF1D4ED8),
                  modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = "📎 බැංකු රිසිට්පත එක් කරන්න (Attach Bank Slip)",
                  fontSize = 11.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF1D4ED8)
                )
              }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Button(
              onClick = {
                val (currDevId, currDevName) = getDeviceIdentifier(context)
                val cleanPhone = regPhone.trim()
                if (regName.isBlank() || cleanPhone.isBlank()) {
                  Toast.makeText(context, "කරුණාකර සියලු විස්තර ඇතුළත් කරන්න", Toast.LENGTH_SHORT).show()
                  return@Button
                }
                if (AppSecurityManager.isVpnConnected(context)) {
                  Toast.makeText(context, "🚫 VPN සක්‍රීයව පවතී! VPN ක්‍රියාවිරහිත කර ලියාපදිංචි වන්න.", Toast.LENGTH_LONG).show()
                  return@Button
                }
                if (isAuthorizedAdminUser(cleanPhone)) {
                  Toast.makeText(context, "❌ මෙම දුරකථන අංකය / Email එක ඇඩ්මින්වරයාගේ නිල ගිණුමකි. ලියාපදිංචි විය නොහැක. කරුණාකර 'ඇඩ්මින්' මඟින් පිවිසෙන්න.", Toast.LENGTH_LONG).show()
                  selectedTab = 1
                  return@Button
                }
                val existing = registeredUsers.find { it.usernameOrPhone.trim().equals(cleanPhone, ignoreCase = true) }
                if (existing != null) {
                  Toast.makeText(context, "⚠️ ඔබ දැනටමත් ලියාපදිංචි වී ඇත! ඔබගේ ගිණුම ඇඩ්මින් අනුමැතිය සඳහා පොරොත්තු ලැයිස්තුවේ පවතී.", Toast.LENGTH_LONG).show()
                  return@Button
                }

                // Helper to perform the actual registration and sync
                val performRegistration = {
                  val currentNow = System.currentTimeMillis()
                  val currentNowFormatted = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(Date(currentNow))
                  val newAcc = UserAccount(
                    id = currentNow.toString(),
                    fullName = regName.trim(),
                    usernameOrPhone = cleanPhone,
                    password = regPassword.trim().ifBlank { "1234" },
                    isApproved = false,
                    slipImageUri = regSlipUri?.toString(),
                    paymentStatus = if (regSlipUri != null) "Pending Approval (With Slip)" else "Pending Approval",
                    requestedGradePackage = "06 සිට 11 දක්වා සියලුම ශ්‍රේණි (All Grades)",
                    approvedGrades = listOf("06", "07", "08", "09", "10", "11", "6 ශ්‍රේණිය", "7 ශ්‍රේණිය", "8 ශ්‍රේණිය", "9 ශ්‍රේණිය", "10 ශ්‍රේණිය", "11 ශ්‍රේණිය"),
                    boundDeviceId = currDevId,
                    boundDeviceName = currDevName,
                    boundDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date(currentNow)),
                    requestDate = currentNowFormatted,
                    requestTimestamp = currentNow
                  )
                  registeredUsers.add(0, newAcc)
                  onUsersUpdated()
                  onLoginSuccess(newAcc)
                  
                  // Cloud Sync
                  coroutineScope.launch {
                    CloudAuthManager.syncUserToCloud(context, newAcc)
                  }
                  
                  // WhatsApp Direct Sharing for Admin Approval
                  val whatsappMsg = "ආයුබෝවන් ඇඩ්මින්!\n\nමම O/L Guru ඇප් එකේ අලුතින් ලියාපදිංචි වුනා. කරුණාකර මගේ ගිණුම පරීක්ෂා කර අනුමත කරන්න.\n\n👤 නම: ${newAcc.fullName}\n📞 අංකය: ${newAcc.usernameOrPhone}\n📦 පැකේජය: 10 ශ්‍රේණිය හා 11 ශ්‍රේණිය\n📅 දිනය: ${newAcc.requestDate}\n\nස්තූතියි!"
                  val encodedMsg = Uri.encode(whatsappMsg)
                  val wpUri = Uri.parse("https://wa.me/94772843861?text=$encodedMsg")
                  val intent = Intent(Intent.ACTION_VIEW, wpUri)
                  try {
                    context.startActivity(intent)
                    Toast.makeText(context, "📝 ලියාපදිංචිය සාර්ථකයි! විස්තර WhatsApp මඟින් ඇඩ්මින්ට යොමු විය.", Toast.LENGTH_LONG).show()
                  } catch (_: Exception) {
                    Toast.makeText(context, "📝 ලියාපදිංචිය සාර්ථකයි! ඇඩ්මින් පරීක්ෂා කර අනුමත කරන තෙක් මාස 6 සක්‍රීය නොවේ.", Toast.LENGTH_LONG).show()
                  }
                  
                  regName = ""
                  regPhone = ""
                  regPassword = ""
                  regSlipUri = null
                  regSlipName = null
                }

                // Automatic Cloud Sync (Google Sign-In) before registration
                if (com.google.firebase.Firebase.auth.currentUser == null) {
                  onGoogleSignInClicked(context, androidx.credentials.CredentialManager.create(context), {
                    performRegistration()
                  }, { err ->
                    Toast.makeText(context, "⚠️ Cloud Sync අසාර්ථකයි: $err. කරුණාකර නැවත උත්සාහ කරන්න.", Toast.LENGTH_LONG).show()
                  }, coroutineScope)
                } else {
                  performRegistration()
                }
              },
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF137333)),
              shape = RoundedCornerShape(12.dp),
              modifier = Modifier.fillMaxWidth().height(48.dp)
            ) {
              Icon(Icons.Default.HowToReg, contentDescription = "Register")
              Spacer(modifier = Modifier.width(8.dp))
              Text("ලියාපදිංචි වී ඇතුළු වන්න", fontWeight = FontWeight.Bold)
            }
            }
          }
          1 -> {
            // ADMIN APPROVAL PANEL
            if (!isAdminUnlocked) {
              Text(
                text = "👑 ඇඩ්මින් ප්‍රවේශය (Admin Verification)",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = NeutralDark,
                modifier = Modifier.fillMaxWidth()
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "පියවර 1: බලයලත් දුරකථන අංකය හෝ Email\nපියවර 2: ඇඩ්මින් Username, NIC අංකය & මුරපදය",
                fontSize = 11.sp,
                color = NeutralMedium,
                lineHeight = 15.sp
              )
              Spacer(modifier = Modifier.height(12.dp))

              androidx.compose.material3.OutlinedTextField(
                value = adminPhoneOrEmail,
                onValueChange = { adminPhoneOrEmail = it },
                label = { Text("පියවර 1: දුරකථන අංකය / Email") },
                placeholder = { Text("දුරකථන අංකය හෝ Email ඇතුළත් කරන්න") },
                leadingIcon = { Icon(Icons.Default.Phone, contentDescription = "Admin Phone") },
                textStyle = TextStyle(color = Color.Black, fontSize = 14.sp),
                colors = OutlinedTextFieldDefaults.colors(
                  focusedTextColor = Color.Black,
                  unfocusedTextColor = Color.Black,
                  focusedLabelColor = Color(0xFF1E3A8A),
                  unfocusedLabelColor = Color(0xFF4B5563),
                  focusedBorderColor = Color(0xFF1E3A8A),
                  unfocusedBorderColor = Color(0xFFD1D5DB),
                  cursorColor = Color.Black,
                  focusedPlaceholderColor = Color.Gray,
                  unfocusedPlaceholderColor = Color.Gray
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth().testTag("admin_login_phone_field")
              )
              Spacer(modifier = Modifier.height(10.dp))

              androidx.compose.material3.OutlinedTextField(
                value = adminUsername,
                onValueChange = { adminUsername = it },
                label = { Text("පියවර 2: පරිශීලක නාමය (Username)") },
                placeholder = { Text("පරිශීලක නාමය ඇතුළත් කරන්න") },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Admin Username") },
                textStyle = TextStyle(color = Color.Black, fontSize = 14.sp),
                colors = OutlinedTextFieldDefaults.colors(
                  focusedTextColor = Color.Black,
                  unfocusedTextColor = Color.Black,
                  focusedLabelColor = Color(0xFF1E3A8A),
                  unfocusedLabelColor = Color(0xFF4B5563),
                  focusedBorderColor = Color(0xFF1E3A8A),
                  unfocusedBorderColor = Color(0xFFD1D5DB),
                  cursorColor = Color.Black,
                  focusedPlaceholderColor = Color.Gray,
                  unfocusedPlaceholderColor = Color.Gray
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth().testTag("admin_login_username_field")
              )
              Spacer(modifier = Modifier.height(10.dp))

              androidx.compose.material3.OutlinedTextField(
                value = adminNic,
                onValueChange = { adminNic = it },
                label = { Text("පියවර 2: ජාතික හැඳුනුම්පත් අංකය (NIC)") },
                placeholder = { Text("NIC අංකය ඇතුළත් කරන්න") },
                leadingIcon = { Icon(Icons.Default.AccountBox, contentDescription = "Admin NIC") },
                textStyle = TextStyle(color = Color.Black, fontSize = 14.sp),
                colors = OutlinedTextFieldDefaults.colors(
                  focusedTextColor = Color.Black,
                  unfocusedTextColor = Color.Black,
                  focusedLabelColor = Color(0xFF1E3A8A),
                  unfocusedLabelColor = Color(0xFF4B5563),
                  focusedBorderColor = Color(0xFF1E3A8A),
                  unfocusedBorderColor = Color(0xFFD1D5DB),
                  cursorColor = Color.Black,
                  focusedPlaceholderColor = Color.Gray,
                  unfocusedPlaceholderColor = Color.Gray
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth().testTag("admin_login_nic_field")
              )
              Spacer(modifier = Modifier.height(10.dp))

              androidx.compose.material3.OutlinedTextField(
                value = adminPasscode,
                onValueChange = { adminPasscode = it },
                label = { Text("පියවර 2: මුරපදය (Password)") },
                placeholder = { Text("මුරපදය ඇතුළත් කරන්න") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Admin Password") },
                textStyle = TextStyle(color = Color.Black, fontSize = 14.sp),
                colors = OutlinedTextFieldDefaults.colors(
                  focusedTextColor = Color.Black,
                  unfocusedTextColor = Color.Black,
                  focusedLabelColor = Color(0xFF1E3A8A),
                  unfocusedLabelColor = Color(0xFF4B5563),
                  focusedBorderColor = Color(0xFF1E3A8A),
                  unfocusedBorderColor = Color(0xFFD1D5DB),
                  cursorColor = Color.Black,
                  focusedPlaceholderColor = Color.Gray,
                  unfocusedPlaceholderColor = Color.Gray
                ),
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                modifier = Modifier.fillMaxWidth().testTag("admin_login_password_field")
              )
              Spacer(modifier = Modifier.height(16.dp))

              Button(
                onClick = {
                  val cleanAdminInput = adminPhoneOrEmail.trim()
                  val cleanUser = adminUsername.trim()
                  val cleanNic = adminNic.trim()
                  val cleanPass = adminPasscode.trim()
                  val isAuthorized = isAuthorizedAdminUser(cleanAdminInput)
                  val isStep2Valid = isValidAdminStep2Credentials(cleanUser, cleanNic, cleanPass)

                  if (!isAuthorized) {
                    Toast.makeText(
                      context,
                      "❌ අනවසර ප්‍රවේශයකි! මෙම දුරකථන අංකය හෝ Email එක ඇඩ්මින් ගිණුමක් ලෙස අනුමත කර නොමැත.",
                      Toast.LENGTH_LONG
                    ).show()
                  } else if (!isStep2Valid) {
                    Toast.makeText(
                      context,
                      "❌ ඇඩ්මින් පරිශීලක නාමය (Username), NIC අංකය හෝ මුරපදය (Password) වැරදියි!",
                      Toast.LENGTH_LONG
                    ).show()
                  } else {
                    isAdminUnlocked = true
                    val adminUser = registeredUsers.find { isAuthorizedAdminUser(it.usernameOrPhone) }
                      ?: UserAccount("1", "අකිල ප්‍රභාත් දිසානායක (Admin)", cleanAdminInput, cleanPass, isApproved = true, paymentStatus = "Approved", requestedGradePackage = "06 සිට 11 දක්වා සියලුම ශ්‍රේණි (All Grades Mega Pack)", approvedGrades = listOf("06", "07", "08", "09", "10", "11", "6 ශ්‍රේණිය", "7 ශ්‍රේණිය", "8 ශ්‍රේණිය", "9 ශ්‍රේණිය", "10 ශ්‍රේණිය", "11 ශ්‍රේණිය"))
                    setAdminSessionActive(context, true)
                    onAdminLoginSuccess()
                    onLoginSuccess(adminUser)
                    Toast.makeText(context, "👑 ඇඩ්මින් පැනලය සහ ඇඩ්මින් බාර් එක සාර්ථකව විවෘත විය!", Toast.LENGTH_SHORT).show()
                  }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E3A8A)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth().height(48.dp).testTag("admin_dialog_unlock_button")
              ) {
                Icon(Icons.Default.AdminPanelSettings, contentDescription = "Unlock Admin")
                Spacer(modifier = Modifier.width(8.dp))
                Text("ඇඩ්මින් පැනලය විවෘත කරන්න", fontWeight = FontWeight.Bold)
              }
            } else {
              Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(
                    text = "👑 ඇඩ්මින් පරිශීලක අනුමැතිය",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = NeutralDark
                  )
                  Button(
                    onClick = { onAdminLoginSuccess() },
                    colors = ButtonDefaults.buttonColors(containerColor = BluePrimary),
                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
                  ) {
                    Text("ඇප් එකට යන්න", fontSize = 11.sp)
                  }
                }

                Spacer(modifier = Modifier.height(12.dp))

                val pendingUsers = registeredUsers.filter { !it.isApproved }
                val approvedUsers = registeredUsers.filter { it.isApproved }

                Text(
                  text = "අනුමැතිය බලපොරොත්තුවෙන් සිටින සිසුන් (${pendingUsers.size})",
                  fontSize = 12.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFFC62828)
                )
                Spacer(modifier = Modifier.height(8.dp))

                if (pendingUsers.isEmpty()) {
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFF1F5F9),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Text(
                      text = "අනුමැතිය සඳහා කිසිදු ශිෂ්‍ය ගිණුමක් නැත.",
                      fontSize = 11.sp,
                      color = NeutralMedium,
                      modifier = Modifier.padding(12.dp)
                    )
                  }
                } else {
                  for (user in pendingUsers) {
                    Surface(
                      shape = RoundedCornerShape(12.dp),
                      color = Color(0xFFFFF8E1),
                      border = BorderStroke(1.dp, Color(0xFFFFE082)),
                      modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                    ) {
                      Column(modifier = Modifier.padding(12.dp)) {
                        Row(
                          modifier = Modifier.fillMaxWidth(),
                          verticalAlignment = Alignment.CenterVertically,
                          horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                          Column(modifier = Modifier.weight(1f)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                              Text(user.fullName, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                              Spacer(modifier = Modifier.width(6.dp))
                              Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = if (user.slipImageUri != null) Color(0xFFE8EAF6) else Color(0xFFFFECB3)
                              ) {
                                Text(
                                  text = if (user.slipImageUri != null) "🧾 රිසිට්පත ඇත" else "බැංකු රිසිට්පතක් නැත",
                                  fontSize = 9.sp,
                                  fontWeight = FontWeight.Bold,
                                  color = if (user.slipImageUri != null) Color(0xFF283593) else Color(0xFFE65100),
                                  modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                                )
                              }
                            }
                            Text("දුරකථනය: ${user.usernameOrPhone}", fontSize = 11.sp, color = NeutralMedium)
                            
                            // Device Lock Status
                            if (user.boundDeviceId != null) {
                              Row(
                                modifier = Modifier.padding(top = 2.dp),
                                verticalAlignment = Alignment.CenterVertically
                              ) {
                                Icon(Icons.Default.PhoneAndroid, contentDescription = "Device", tint = Color(0xFF1565C0), modifier = Modifier.size(12.dp))
                                Spacer(modifier = Modifier.width(3.dp))
                                Text(
                                  text = "📱 Lock: ${user.boundDeviceName ?: "ස්ථාපිත දුරකථනය"}",
                                  fontSize = 9.sp,
                                  color = Color(0xFF1565C0),
                                  fontWeight = FontWeight.SemiBold
                                )
                              }
                            } else {
                              Text("🔓 Device Lock: Not Bound Yet", fontSize = 9.sp, color = NeutralMedium, modifier = Modifier.padding(top = 2.dp))
                            }
                            
                            Spacer(modifier = Modifier.height(3.dp))
                            Surface(
                              shape = RoundedCornerShape(6.dp),
                              color = Color(0xFFE0F2FE),
                              border = BorderStroke(1.dp, Color(0xFF7DD3FC))
                            ) {
                              Text(
                                text = "🎓 ඉල්ලූ පැකේජය: ${user.requestedGradePackage}",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF0369A1),
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                              )
                            }
                            Spacer(modifier = Modifier.height(2.dp))
                            Text("තත්ත්වය: ${user.paymentStatus}", fontSize = 10.sp, color = Color(0xFFE65100), fontWeight = FontWeight.Medium)
                          }
                          Row {
                            Button(
                              onClick = {
                                val idx = registeredUsers.indexOf(user)
                                if (idx != -1) {
                                  val gradesToAssign = getApprovedGradesForPackage(user.requestedGradePackage)
                                  val (cId, cName) = getDeviceIdentifier(context)
                                  registeredUsers[idx] = user.copy(
                                    isApproved = true,
                                    approvedGrades = gradesToAssign,
                                    paymentStatus = "Approved",
                                    approvalTimestamp = System.currentTimeMillis(),
                                    boundDeviceId = user.boundDeviceId ?: cId,
                                    boundDeviceName = user.boundDeviceName ?: cName
                                  )
                                  onUsersUpdated()
                                }
                                Toast.makeText(context, "${user.fullName} (${user.requestedGradePackage}) අනුමත කරන ලදී!", Toast.LENGTH_SHORT).show()
                              },
                              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF137333)),
                              shape = RoundedCornerShape(8.dp),
                              contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp)
                            ) {
                              Text("Approve", fontSize = 11.sp)
                            }
                            Spacer(modifier = Modifier.width(4.dp))
                            IconButton(
                              onClick = {
                                registeredUsers.remove(user)
                                onUsersUpdated()
                                Toast.makeText(context, "${user.fullName} ඉවත් කරන ලදී", Toast.LENGTH_SHORT).show()
                              }
                            ) {
                              Icon(Icons.Default.Delete, contentDescription = "Reject", tint = Color.Red, modifier = Modifier.size(18.dp))
                            }
                          }
                        }

                        if (user.boundDeviceId != null) {
                          Spacer(modifier = Modifier.height(4.dp))
                          Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                          ) {
                            OutlinedButton(
                              onClick = {
                                val idx = registeredUsers.indexOf(user)
                                if (idx != -1) {
                                  registeredUsers[idx] = user.copy(boundDeviceId = null, boundDeviceName = null)
                                  onUsersUpdated()
                                  Toast.makeText(context, "${user.fullName} ගේ Device Lock එක Reset කරන ලදී!", Toast.LENGTH_SHORT).show()
                                }
                              },
                              shape = RoundedCornerShape(6.dp),
                              contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp),
                              modifier = Modifier.height(24.dp)
                            ) {
                              Icon(Icons.Default.LockOpen, contentDescription = "Unlock", tint = Color(0xFFC62828), modifier = Modifier.size(12.dp))
                              Spacer(modifier = Modifier.width(4.dp))
                              Text("🔓 Reset Device Lock", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFFC62828))
                            }
                          }
                        }

                        if (user.slipImageUri != null) {
                          Spacer(modifier = Modifier.height(8.dp))
                          OutlinedButton(
                            onClick = { onPreviewReceipt(user.slipImageUri!!) },
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, BluePrimary),
                            modifier = Modifier.fillMaxWidth().height(36.dp),
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp)
                          ) {
                            Icon(Icons.Default.Visibility, contentDescription = "View", tint = BluePrimary, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("🧾 රිසිට්පත පරීක්ෂා කරන්න (View Bank Slip)", fontSize = 11.sp, color = BluePrimary, fontWeight = FontWeight.Bold)
                          }
                        }
                      }
                    }
                  }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                  text = "අනුමත වූ ශිෂ්‍ය ගිණුම් (${approvedUsers.size})",
                  fontSize = 12.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFF137333)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = "ශ්‍රේණි චිප්ස් මත තට්ටු කර එක් එක් ශිෂ්‍යයාට අදාළ ශ්‍රේණි පහසුවෙන්ම Add / Remove කළ හැක:",
                  fontSize = 10.sp,
                  color = NeutralMedium
                )
                Spacer(modifier = Modifier.height(8.dp))

                for (user in approvedUsers) {
                  Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFFE6F4EA),
                    border = BorderStroke(1.dp, Color(0xFFA5D6A7)),
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                  ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                      Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                      ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                          Icon(Icons.Default.Verified, contentDescription = "Verified", tint = Color(0xFF137333), modifier = Modifier.size(18.dp))
                          Spacer(modifier = Modifier.width(8.dp))
                          Column {
                            Text(user.fullName, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                            Text(user.usernameOrPhone, fontSize = 10.sp, color = NeutralMedium)
                            if (user.boundDeviceId != null) {
                              Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 1.dp)) {
                                Icon(Icons.Default.PhoneAndroid, contentDescription = "Device", tint = Color(0xFF1565C0), modifier = Modifier.size(11.dp))
                                Spacer(modifier = Modifier.width(3.dp))
                                Text("📱 Lock: ${user.boundDeviceName ?: "ස්ථාපිත දුරකථනය"}", fontSize = 9.sp, color = Color(0xFF1565C0), fontWeight = FontWeight.SemiBold)
                              }
                            } else {
                              Text("🔓 Lock: Not Bound", fontSize = 9.sp, color = NeutralMedium)
                            }
                          }
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                          if (user.boundDeviceId != null) {
                            OutlinedButton(
                              onClick = {
                                val idx = registeredUsers.indexOf(user)
                                if (idx != -1) {
                                  registeredUsers[idx] = user.copy(boundDeviceId = null, boundDeviceName = null)
                                  onUsersUpdated()
                                  Toast.makeText(context, "${user.fullName} ගේ Device Lock එක Reset කරන ලදී!", Toast.LENGTH_SHORT).show()
                                }
                              },
                              shape = RoundedCornerShape(6.dp),
                              contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp),
                              modifier = Modifier.height(24.dp)
                            ) {
                              Icon(Icons.Default.LockOpen, contentDescription = "Unlock", tint = Color(0xFFC62828), modifier = Modifier.size(11.dp))
                              Spacer(modifier = Modifier.width(3.dp))
                              Text("🔓 Reset Lock", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFFC62828))
                            }
                            Spacer(modifier = Modifier.width(4.dp))
                          }
                          IconButton(
                            onClick = {
                              val idx = registeredUsers.indexOf(user)
                              if (idx != -1) {
                                registeredUsers[idx] = user.copy(isApproved = false)
                                onUsersUpdated()
                              }
                              Toast.makeText(context, "${user.fullName} අනුමැතිය අවලංගු කරන ලදී", Toast.LENGTH_SHORT).show()
                            }
                          ) {
                            Icon(Icons.Default.Cancel, contentDescription = "Revoke", tint = Color.Red, modifier = Modifier.size(16.dp))
                          }
                        }
                      }

                      Spacer(modifier = Modifier.height(6.dp))

                      // Grade Selector Chips for Admin (10 & 11)
                      Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                      ) {
                        listOf("10", "11").forEach { gradeNum ->
                          val isGradeApproved = user.approvedGrades.contains(gradeNum)
                          Surface(
                            onClick = {
                              val idx = registeredUsers.indexOf(user)
                              if (idx != -1) {
                                val currentList = user.approvedGrades.toMutableList()
                                if (isGradeApproved) {
                                  currentList.remove(gradeNum)
                                } else {
                                  currentList.add(gradeNum)
                                }
                                registeredUsers[idx] = user.copy(approvedGrades = currentList)
                                onUsersUpdated()
                              }
                            },
                            shape = RoundedCornerShape(6.dp),
                            color = if (isGradeApproved) Color(0xFF1B5E20) else Color(0xFFE0E0E0),
                            border = BorderStroke(1.dp, if (isGradeApproved) Color(0xFF2E7D32) else Color(0xFFBDBDBD)),
                            modifier = Modifier.weight(1f)
                          ) {
                            Text(
                              text = if (gradeNum == "11") "11 ශ්‍රේණිය (O/L)" else "10 ශ්‍රේණිය",
                              fontSize = 10.sp,
                              fontWeight = FontWeight.Bold,
                              textAlign = TextAlign.Center,
                              color = if (isGradeApproved) Color.White else Color(0xFF616161),
                              modifier = Modifier.padding(horizontal = 6.dp, vertical = 6.dp)
                            )
                          }
                        }
                      }

                      Spacer(modifier = Modifier.height(4.dp))

                      // Quick action for O/L 10+11 combo
                      Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                      ) {
                        TextButton(
                          onClick = {
                            val idx = registeredUsers.indexOf(user)
                            if (idx != -1) {
                              registeredUsers[idx] = user.copy(approvedGrades = listOf("10", "11"))
                              onUsersUpdated()
                              Toast.makeText(context, "${user.fullName} හට 10 සහ 11 ශ්‍රේණි (O/L) ලබාදුනි", Toast.LENGTH_SHORT).show()
                            }
                          },
                          contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp)
                        ) {
                          Text("⭐ 10+11 O/L පූර්ණ අනුමැතිය", fontSize = 10.sp, color = BluePrimary, fontWeight = FontWeight.Bold)
                        }
                      }
                    }
                  }
                }

                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(color = NeutralBorderLight)
                Spacer(modifier = Modifier.height(16.dp))

                // ADMIN CONTENT STAGING & ONE-CLICK LIVE RELEASE MANAGER
                if (stagedContentItems != null) {
                  AdminStagingCardSection(
                    stagedItems = stagedContentItems,
                    onReleaseAll = onReleaseAllStaged,
                    onOpenStagingDialog = onOpenStagingDialog,
                    onAddNewContentClick = onAddNewContentClick
                  )
                  Spacer(modifier = Modifier.height(16.dp))
                  HorizontalDivider(color = NeutralBorderLight)
                  Spacer(modifier = Modifier.height(16.dp))
                }

                // ADMIN TO USERS BROADCAST COMPOSER BOX
                AdminBroadcastComposerBox(
                  onSendMessage = onSendBroadcastMessage
                )

                if (adminBroadcastMessages != null && adminBroadcastMessages.isNotEmpty()) {
                  Spacer(modifier = Modifier.height(10.dp))
                  Text(
                    text = "යවන ලද නිවේදන (${adminBroadcastMessages.size}):",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E3A8A)
                  )
                  Spacer(modifier = Modifier.height(6.dp))
                  Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    adminBroadcastMessages.take(4).forEach { msg ->
                      Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFFF8FAFC),
                        border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
                        modifier = Modifier.fillMaxWidth()
                      ) {
                        Row(
                          modifier = Modifier.padding(10.dp),
                          horizontalArrangement = Arrangement.SpaceBetween,
                          verticalAlignment = Alignment.CenterVertically
                        ) {
                          Column(modifier = Modifier.weight(1f)) {
                            Text(msg.title, fontWeight = FontWeight.Bold, fontSize = 11.sp, color = Color(0xFF0F172A))
                            Text(msg.message, fontSize = 10.sp, color = Color(0xFF475569), maxLines = 1, overflow = TextOverflow.Ellipsis)
                          }
                          IconButton(
                            onClick = {
                              AdminBroadcastManager.deleteMessage(context, msg.id, adminBroadcastMessages)
                              Toast.makeText(context, "නිවේදනය ඉවත් කරන ලදී", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier.size(24.dp)
                          ) {
                            Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color.Red, modifier = Modifier.size(14.dp))
                          }
                        }
                      }
                    }
                  }
                }

                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(color = NeutralBorderLight)
                Spacer(modifier = Modifier.height(16.dp))

                // FIREBASE STORAGE & FIRESTORE PDF UPLOAD PANEL
                Surface(
                  shape = RoundedCornerShape(16.dp),
                  color = Color(0xFFFFF1F0),
                  border = BorderStroke(1.dp, Color(0xFFFFCDD2)),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Column(modifier = Modifier.padding(14.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                      Icon(Icons.Default.CloudUpload, contentDescription = "Firebase Upload", tint = Color(0xFFC62828), modifier = Modifier.size(22.dp))
                      Spacer(modifier = Modifier.width(8.dp))
                      Text(
                        text = "🔥 Firebase Storage & Firestore Upload",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Color(0xFFC62828)
                      )
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                      text = "Admin ලෙස PDF මාතෘකාව, ශ්‍රේණිය තෝරා Firebase Cloud Storage & Cloud Firestore වෙත Upload කරන්න.",
                      fontSize = 11.sp,
                      color = NeutralMedium
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // PDF Title Input
                    androidx.compose.material3.OutlinedTextField(
                      value = adminPdfTitle,
                      onValueChange = { adminPdfTitle = it },
                      label = { Text("PDF මාතෘකාව / නම (Title in Sinhala)") },
                      singleLine = true,
                      modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Grade Picker (10 & 11)
                    Text("ශ්‍රේණිය (Grade) තෝරන්න:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = NeutralDark)
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                      listOf("10", "11").forEach { g ->
                        FilterChip(
                          selected = adminPdfGrade == g,
                          onClick = { adminPdfGrade = g },
                          label = { Text(if (g == "11") "11 ශ්‍රේණිය (O/L)" else "10 ශ්‍රේණිය", fontSize = 11.sp) },
                          modifier = Modifier.weight(1f)
                        )
                      }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Category Picker
                    Text("අංශය / වර්ගය (Type):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = NeutralDark)
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                      FilterChip(
                        selected = adminPdfCategory == "NOTE",
                        onClick = { adminPdfCategory = "NOTE" },
                        label = { Text("කෙටි සටහන් PDF", fontSize = 11.sp) }
                      )
                      FilterChip(
                        selected = adminPdfCategory == "PAPER",
                        onClick = { adminPdfCategory = "PAPER" },
                        label = { Text("ප්‍රශ්න පත්‍ර PDF", fontSize = 11.sp) }
                      )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Subject Input
                    androidx.compose.material3.OutlinedTextField(
                      value = adminPdfSubject,
                      onValueChange = { adminPdfSubject = it },
                      label = { Text("විෂය (Subject Name)") },
                      singleLine = true,
                      modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // Attach PDF Button
                    Button(
                      onClick = { onPickPdf() },
                      colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = BluePrimary),
                      border = BorderStroke(1.dp, BluePrimary),
                      shape = RoundedCornerShape(10.dp),
                      modifier = Modifier.fillMaxWidth()
                    ) {
                      Icon(Icons.Default.AttachFile, contentDescription = "Attach PDF", modifier = Modifier.size(18.dp))
                      Spacer(modifier = Modifier.width(6.dp))
                      Text(
                        text = if (selectedPdfFileName != null) "📎 $selectedPdfFileName" else "PDF ගොනුවක් තෝරන්න (Select PDF File)",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                      )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Upload to Firebase Button
                    Button(
                      onClick = {
                        if (adminPdfTitle.isNotBlank()) {
                          onUploadPdfToFirebase(
                            adminPdfTitle,
                            adminPdfGrade,
                            adminPdfCategory,
                            adminPdfSubject,
                            selectedPdfUri,
                            selectedPdfFileName
                          )
                          Toast.makeText(
                            context,
                            "🔥 Firebase Cloud Storage (gs://studentportal-db.appspot.com/pdfs/${adminPdfGrade}) හා Cloud Firestore වෙත PDF සාර්ථකව උඩුගත (Upload) විය!",
                            Toast.LENGTH_LONG
                          ).show()
                          adminPdfTitle = ""
                        } else {
                          Toast.makeText(context, "කරුණාකර PDF මාතෘකාව ඇතුළත් කරන්න", Toast.LENGTH_SHORT).show()
                        }
                      },
                      colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC62828)),
                      shape = RoundedCornerShape(10.dp),
                      modifier = Modifier.fillMaxWidth().height(46.dp)
                    ) {
                      Icon(Icons.Default.CloudUpload, contentDescription = "Firebase Upload")
                      Spacer(modifier = Modifier.width(8.dp))
                      Text("Firebase Storage & Firestore Upload", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  if (showRegSuccessDialog) {
    AlertDialog(
      onDismissRequest = { showRegSuccessDialog = false },
      title = {
        Text("ලියාපදිංචිය සාර්ථකයි!")
      },
      text = {
        Text("ඔබගේ ගිණුම සාර්ථකව සාදන ලදී. ඇඩ්මින්වරයා (Admin Approval) විසින් අනුමත කළ පසු ඔබට ඇප් එකට මුරපදය යොදා ප්‍රවේශ විය හැක.")
      },
      confirmButton = {
        Button(
          onClick = {
            showRegSuccessDialog = false
            selectedTab = 0
          }
        ) {
          Text("ලොගින් පිටුවට යන්න")
        }
      }
    )
  }

  if (deviceLockedUserForAlert != null) {
    val lockedUser = deviceLockedUserForAlert!!
    AlertDialog(
      onDismissRequest = { deviceLockedUserForAlert = null },
      icon = {
        Icon(Icons.Default.Security, contentDescription = "Device Lock", tint = Color(0xFFDC2626), modifier = Modifier.size(36.dp))
      },
      title = {
        Text(
          text = "🔒 උපාංග අගුල සක්‍රීයයි (Device Lock)",
          fontWeight = FontWeight.Bold,
          fontSize = 15.sp,
          color = Color(0xFFDC2626)
        )
      },
      text = {
        Column {
          Text(
            text = "මෙම ගිණුම (${lockedUser.usernameOrPhone}) වෙනත් දුරකථනයකට (${lockedUser.boundDeviceName ?: "වෙනත් දුරකථනයකට"}) සම්බන්ධ කර (Lock) ඇත.",
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF1E293B)
          )
          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = "ආරක්ෂක හේතූන් මත එක් ශිෂ්‍ය ගිණුමකින් භාවිත කළ හැක්කේ ලියාපදිංචි වූ මුල් දුරකථනයෙන් පමණි.\n\nඔබගේ දුරකථනය මාරු කිරීමට අවශ්‍ය නම් කරුණාකර ඇඩ්මින් අමතා (0772843861) Device Lock එක Reset කරවා ගන්න.",
            fontSize = 11.sp,
            color = NeutralMedium
          )
        }
      },
      confirmButton = {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
          Button(
            onClick = {
              val (cId, cName) = getDeviceIdentifier(context)
              val unlockedUser = lockedUser.copy(boundDeviceId = cId, boundDeviceName = cName, isApproved = true)
              val idx = registeredUsers.indexOf(lockedUser)
              if (idx >= 0) {
                registeredUsers[idx] = unlockedUser
              }
              onLoginSuccess(unlockedUser)
              deviceLockedUserForAlert = null
              Toast.makeText(context, "📱 ගිණුම සාර්ථකව මෙම උපාංගයට සම්බන්ධ විය!", Toast.LENGTH_SHORT).show()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB))
          ) {
            Text("මෙම දුරකථනයට මාරු කරන්න", fontSize = 11.sp, fontWeight = FontWeight.Bold)
          }
        }
      },
      dismissButton = {
        TextButton(onClick = { deviceLockedUserForAlert = null }) {
          Text("තේරුණා (Close)")
        }
      }
    )
  }
}
}
