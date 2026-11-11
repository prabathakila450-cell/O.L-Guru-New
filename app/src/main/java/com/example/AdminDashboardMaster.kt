package com.example

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.horizontalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

/**
 * Top-Right Dedicated Small Circular Admin Badge
 * Strictly visible ONLY when the Admin is logged in.
 */
@Composable
fun AdminTopCornerCircleBadge(
  onClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Box(
    modifier = modifier
      .testTag("admin_top_right_circle_button")
      .clickable(onClick = onClick)
  ) {
    Surface(
      shape = CircleShape,
      color = Color(0xFF0F172A), // Deep Navy Core
      border = BorderStroke(2.dp, Color(0xFFF59E0B)), // Golden Amber Ring
      shadowElevation = 6.dp,
      modifier = Modifier.size(40.dp)
    ) {
      Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
      ) {
        Icon(
          imageVector = Icons.Default.AdminPanelSettings,
          contentDescription = "👑 Admin Dashboard",
          tint = Color(0xFFFBBF24), // Gold
          modifier = Modifier.size(22.dp)
        )
      }
    }

    // Glowing Active Online Dot Indicator
    Box(
      modifier = Modifier
        .align(Alignment.TopEnd)
        .size(11.dp)
        .clip(CircleShape)
        .background(Color.White)
        .padding(1.5.dp)
        .clip(CircleShape)
        .background(Color(0xFF10B981)) // Vivid Emerald
    )
  }
}

/**
 * Comprehensive 100% Functional Admin Master Dashboard Dialog
 */
@Composable
fun AdminDashboardMasterDialog(
  registeredUsers: SnapshotStateList<UserAccount>,
  adminBroadcastMessages: SnapshotStateList<AdminBroadcastMessage>,
  stagedContentItems: SnapshotStateList<StagedContentItem>? = null,
  initialFilter: String = "ALL",
  onDismiss: () -> Unit,
  onUsersUpdated: () -> Unit,
  onLogoutAdmin: () -> Unit,
  onPreviewReceipt: (String) -> Unit,
  onSendBroadcast: (title: String, message: String, priority: BroadcastPriority, targetGrade: String) -> Unit = { _, _, _, _ -> },
  onReleaseAllStaged: () -> Unit = {},
  onOpenStagingDialog: () -> Unit = {},
  onAddNewContentClick: () -> Unit = {}
) {
  val context = LocalContext.current
  val coroutineScope = androidx.compose.runtime.rememberCoroutineScope()
  var selectedTab by remember { mutableStateOf(0) } // 0: Users, 1: Broadcast, 2: Content/Drive, 3: Settings

  // User Filter & Search State
  var searchQuery by remember { mutableStateOf("") }
  var userFilterStatus by remember(initialFilter) { mutableStateOf(initialFilter) } // ALL, PENDING, APPROVED, EXPIRED

  // Admin Password Edit State
  var currentAdminPass by remember { mutableStateOf(getAdminMasterPassword(context)) }
  var newAdminPass by remember { mutableStateOf("") }
  var showAdminPassEdit by remember { mutableStateOf(false) }

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false)
  ) {
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(Color.Black.copy(alpha = 0.65f))
        .padding(horizontal = 10.dp, vertical = 20.dp),
      contentAlignment = Alignment.Center
    ) {
      Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        border = BorderStroke(1.5.dp, Color(0xFFF59E0B)), // Gold Border
        modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight(0.95f)
      ) {
        Column(
          modifier = Modifier.fillMaxSize()
        ) {
          // ------------------------------------------------------------------
          // 1. TOP HEADER BANNER (Admin Identity & Quick Controls)
          // ------------------------------------------------------------------
          Surface(
            color = Color(0xFF0F172A), // Midnight Navy
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
              ) {
                Surface(
                  shape = CircleShape,
                  color = Color(0xFF1E3A8A),
                  border = BorderStroke(1.5.dp, Color(0xFFFBBF24)),
                  modifier = Modifier.size(44.dp)
                ) {
                  Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                  ) {
                    Icon(
                      imageVector = Icons.Default.AdminPanelSettings,
                      contentDescription = "Admin",
                      tint = Color(0xFFFBBF24),
                      modifier = Modifier.size(26.dp)
                    )
                  }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                      text = "👑 ඇඩ්මින් පාලක මධ්‍යස්ථානය",
                      fontWeight = FontWeight.Bold,
                      fontSize = 15.sp,
                      color = Color.White
                    )
                  }
                  Text(
                    text = "අකිල ප්‍රභාත් දිසානායක • 0772843861 / prabathakila450@gmail.com",
                    fontSize = 11.sp,
                    color = Color(0xFF94A3B8),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                  )
                }
              }

              Row(verticalAlignment = Alignment.CenterVertically) {
                // Logout Admin Button
                OutlinedButton(
                  onClick = {
                    onLogoutAdmin()
                    onDismiss()
                    Toast.makeText(context, "ඇඩ්මින් ගිණුමෙන් සාර්ථකව ඉවත් විය.", Toast.LENGTH_SHORT).show()
                  },
                  colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFEF4444)),
                  border = BorderStroke(1.dp, Color(0xFFEF4444)),
                  shape = RoundedCornerShape(8.dp),
                  contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                  modifier = Modifier.height(32.dp)
                ) {
                  Icon(Icons.Default.ExitToApp, contentDescription = "Logout", modifier = Modifier.size(14.dp))
                  Spacer(modifier = Modifier.width(4.dp))
                  Text("ඉවත්වන්න", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.width(6.dp))

                IconButton(
                  onClick = onDismiss,
                  modifier = Modifier.size(32.dp)
                ) {
                  Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = Color.White
                  )
                }
              }
            }
          }

          // ------------------------------------------------------------------
          // 2. SUMMARY KPI STATS ROW
          // ------------------------------------------------------------------
          val totalUsers = registeredUsers.size
          val pendingUsers = registeredUsers.count { !it.isApproved && !isAuthorizedAdminUser(it.usernameOrPhone) }
          val approvedUsers = registeredUsers.count { it.isApproved && !it.isApprovalExpired() && !isAuthorizedAdminUser(it.usernameOrPhone) }
          val expiredUsers = registeredUsers.count { it.isApprovalExpired() && !isAuthorizedAdminUser(it.usernameOrPhone) }

          Row(
            modifier = Modifier
              .fillMaxWidth()
              .background(Color(0xFFF8FAFC))
              .padding(horizontal = 12.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            AdminKpiCard(
              title = "මුළු සිසුන්",
              count = "$totalUsers",
              bgColor = Color(0xFFEFF6FF),
              textColor = Color(0xFF1D4ED8),
              onClick = {
                selectedTab = 0
                userFilterStatus = "ALL"
              },
              modifier = Modifier.weight(1f)
            )
            AdminKpiCard(
              title = "අනුමැතියට",
              count = "$pendingUsers",
              bgColor = Color(0xFFFEF2F2),
              textColor = Color(0xFFDC2626),
              onClick = {
                selectedTab = 0
                userFilterStatus = "PENDING"
              },
              modifier = Modifier.weight(1f)
            )
            AdminKpiCard(
              title = "සක්‍රීය (මාස 6)",
              count = "$approvedUsers",
              bgColor = Color(0xFFECFDF5),
              textColor = Color(0xFF059669),
              onClick = {
                selectedTab = 0
                userFilterStatus = "APPROVED"
              },
              modifier = Modifier.weight(1f)
            )
            AdminKpiCard(
              title = "මාස 6 අවසන්",
              count = "$expiredUsers",
              bgColor = Color(0xFFFFF1F2),
              textColor = Color(0xFFBE123C),
              onClick = {
                selectedTab = 0
                userFilterStatus = "EXPIRED"
              },
              modifier = Modifier.weight(1f)
            )
          }

          // ------------------------------------------------------------------
          // 3. TABS NAVIGATION BAR
          // ------------------------------------------------------------------
          TabRow(
            selectedTabIndex = selectedTab,
            containerColor = Color(0xFFF1F5F9),
            contentColor = Color(0xFF1E3A8A)
          ) {
            Tab(
              selected = selectedTab == 0,
              onClick = { selectedTab = 0 },
              text = { Text("👥 පරිශීලකයින්", fontWeight = FontWeight.Bold, fontSize = 11.sp) }
            )
            Tab(
              selected = selectedTab == 1,
              onClick = { selectedTab = 1 },
              text = { Text("📢 නිවේදන", fontWeight = FontWeight.Bold, fontSize = 11.sp) }
            )
            Tab(
              selected = selectedTab == 2,
              onClick = { selectedTab = 2 },
              text = { Text("📁 අන්තර්ගත", fontWeight = FontWeight.Bold, fontSize = 11.sp) }
            )
            Tab(
              selected = selectedTab == 3,
              onClick = { selectedTab = 3 },
              text = { Text("⚙️ සැකසුම්", fontWeight = FontWeight.Bold, fontSize = 11.sp) }
            )
          }

          // ------------------------------------------------------------------
          // 4. TAB CONTENTS
          // ------------------------------------------------------------------
          Box(
            modifier = Modifier
              .fillMaxSize()
              .padding(12.dp)
          ) {
            when (selectedTab) {
              0 -> {
                // USER MANAGEMENT & APPROVALS TAB
                UserManagementSection(
                  registeredUsers = registeredUsers,
                  searchQuery = searchQuery,
                  onSearchQueryChange = { searchQuery = it },
                  filterStatus = userFilterStatus,
                  onFilterStatusChange = { userFilterStatus = it },
                  onUsersUpdated = onUsersUpdated,
                  onPreviewReceipt = onPreviewReceipt,
                  coroutineScope = coroutineScope
                )
              }
              1 -> {
                // BROADCAST ANNOUNCEMENTS TAB
                AdminBroadcastSection(
                  adminBroadcastMessages = adminBroadcastMessages,
                  onSendBroadcast = onSendBroadcast
                )
              }
              2 -> {
                // CONTENT & GOOGLE DRIVE PDF HUB TAB
                AdminContentHubSection(
                  stagedContentItems = stagedContentItems,
                  onReleaseAllStaged = onReleaseAllStaged,
                  onOpenStagingDialog = onOpenStagingDialog,
                  onAddNewContentClick = onAddNewContentClick
                )
              }
              3 -> {
                // ADMIN SECURITY & SETTINGS TAB
                AdminSettingsSection(
                  currentPassword = currentAdminPass,
                  onPasswordChanged = { newPass ->
                    saveAdminMasterPassword(context, newPass)
                    currentAdminPass = newPass
                    // Update admin users in registeredUsers list
                    for (i in 0 until registeredUsers.size) {
                      val u = registeredUsers[i]
                      if (isAuthorizedAdminUser(u.usernameOrPhone)) {
                        registeredUsers[i] = u.copy(password = newPass)
                      }
                    }
                    onUsersUpdated()
                    Toast.makeText(context, "✅ ඇඩ්මින් මුරපදය සාර්ථකව වෙනස් විය!", Toast.LENGTH_SHORT).show()
                  }
                )
              }
            }
          }
        }
      }
    }
  }
}

/**
 * KPI Metric Card
 */
@Composable
private fun AdminKpiCard(
  title: String,
  count: String,
  bgColor: Color,
  textColor: Color,
  onClick: (() -> Unit)? = null,
  modifier: Modifier = Modifier
) {
  Surface(
    shape = RoundedCornerShape(10.dp),
    color = bgColor,
    onClick = { onClick?.invoke() },
    enabled = onClick != null,
    modifier = modifier
  ) {
    Column(
      modifier = Modifier.padding(vertical = 7.dp, horizontal = 4.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        text = count,
        fontSize = 15.sp,
        fontWeight = FontWeight.ExtraBold,
        color = textColor
      )
      Text(
        text = title,
        fontSize = 8.5.sp,
        fontWeight = FontWeight.Medium,
        color = textColor.copy(alpha = 0.85f),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
      )
    }
  }
}

/**
 * USER MANAGEMENT & APPROVALS SECTION
 */
@Composable
private fun UserManagementSection(
  registeredUsers: SnapshotStateList<UserAccount>,
  searchQuery: String,
  onSearchQueryChange: (String) -> Unit,
  filterStatus: String,
  onFilterStatusChange: (String) -> Unit,
  onUsersUpdated: () -> Unit,
  onPreviewReceipt: (String) -> Unit,
  coroutineScope: kotlinx.coroutines.CoroutineScope
) {
  val context = LocalContext.current

  val pCount = remember(registeredUsers.size, registeredUsers.map { it.isApproved }) {
    registeredUsers.count { !it.isApproved && !isAuthorizedAdminUser(it.usernameOrPhone) }
  }

  // Filtered and Priority-Sorted list (Pending Requests ALWAYS at the very top!)
  val filteredList = remember(registeredUsers.size, registeredUsers.map { it.isApproved to it.paymentStatus }, searchQuery, filterStatus) {
    registeredUsers.filter { user ->
      val matchesSearch = searchQuery.isBlank() ||
        user.fullName.contains(searchQuery, ignoreCase = true) ||
        user.usernameOrPhone.contains(searchQuery, ignoreCase = true) ||
        user.requestedGradePackage.contains(searchQuery, ignoreCase = true)

      val matchesFilter = when (filterStatus) {
        "PENDING" -> !user.isApproved && !isAuthorizedAdminUser(user.usernameOrPhone)
        "APPROVED" -> user.isApproved && !user.isApprovalExpired() && !isAuthorizedAdminUser(user.usernameOrPhone)
        "EXPIRED" -> user.isApprovalExpired() && !isAuthorizedAdminUser(user.usernameOrPhone)
        else -> true
      }

      matchesSearch && matchesFilter
    }.sortedWith(
      compareBy(
        // Priority 0: Pending approval normal students (ALWAYS at the TOP of screen!)
        { user ->
          if (!user.isApproved && !isAuthorizedAdminUser(user.usernameOrPhone)) 0
          else if (user.isApprovalExpired() && !isAuthorizedAdminUser(user.usernameOrPhone)) 1
          else if (user.isApproved && !isAuthorizedAdminUser(user.usernameOrPhone)) 2
          else 3 // Admins placed at bottom of student list
        },
        // Priority 1: Within each group, newest request timestamp first
        { user -> -(user.requestTimestamp ?: 0L) }
      )
    )
  }

  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(8.dp),
    contentPadding = PaddingValues(bottom = 24.dp)
  ) {
    // 1. Search Bar item (Fully scrollable)
    item(key = "admin_search_bar") {
      OutlinedTextField(
        value = searchQuery,
        onValueChange = onSearchQueryChange,
        label = { Text("නම, දුරකථන අංකය හෝ Email සොයන්න...") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF64748B)) },
        trailingIcon = {
          if (searchQuery.isNotEmpty()) {
            IconButton(onClick = { onSearchQueryChange("") }) {
              Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color(0xFF64748B))
            }
          }
        },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
          .fillMaxWidth()
          .height(54.dp)
          .testTag("admin_user_search_field")
      )
    }

    // 2. Filter Chips item (Horizontally Scrollable inside vertical scroll)
    item(key = "admin_filter_chips") {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        FilterChip(
          selected = filterStatus == "ALL",
          onClick = { onFilterStatusChange("ALL") },
          label = { Text("සියල්ල (${registeredUsers.size})", fontSize = 10.sp, fontWeight = FontWeight.Bold) },
          colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = Color(0xFF1E3A8A),
            selectedLabelColor = Color.White
          )
        )
        FilterChip(
          selected = filterStatus == "PENDING",
          onClick = { onFilterStatusChange("PENDING") },
          label = {
            Text("⏳ අනුමැතියට ($pCount)", fontSize = 10.sp, fontWeight = FontWeight.Bold)
          },
          colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = Color(0xFFDC2626),
            selectedLabelColor = Color.White
          )
        )
        FilterChip(
          selected = filterStatus == "APPROVED",
          onClick = { onFilterStatusChange("APPROVED") },
          label = {
            val aCount = registeredUsers.count { it.isApproved && !it.isApprovalExpired() && !isAuthorizedAdminUser(it.usernameOrPhone) }
            Text("✅ සක්‍රීය (මාස 6) ($aCount)", fontSize = 10.sp, fontWeight = FontWeight.Bold)
          },
          colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = Color(0xFF059669),
            selectedLabelColor = Color.White
          )
        )
        FilterChip(
          selected = filterStatus == "EXPIRED",
          onClick = { onFilterStatusChange("EXPIRED") },
          label = {
            val expCount = registeredUsers.count { it.isApprovalExpired() && !isAuthorizedAdminUser(it.usernameOrPhone) }
            Text("⚠️ මාස 6 අවසන් ($expCount)", fontSize = 10.sp, fontWeight = FontWeight.Bold)
          },
          colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = Color(0xFFB91C1C),
            selectedLabelColor = Color.White
          )
        )
      }
    }

    // 3. Prominent Alert Banner when Pending Requests Exist and not on PENDING tab
    if (pCount > 0 && filterStatus != "PENDING") {
      item(key = "admin_pending_alert") {
        Surface(
          onClick = { onFilterStatusChange("PENDING") },
          shape = RoundedCornerShape(10.dp),
          color = Color(0xFFFEF2F2),
          border = BorderStroke(1.5.dp, Color(0xFFEF4444)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(Icons.Default.Warning, contentDescription = "Pending Alert", tint = Color(0xFFDC2626), modifier = Modifier.size(18.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = "🚨 නව අනුමැති ඉල්ලීම් $pCount ක් ඇත! (Click to View)",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF991B1B)
              )
            }
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFFDC2626)
            ) {
              Text(
                text = "පරීක්ෂා කරන්න ❯",
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
              )
            }
          }
        }
      }
    }

    // 4. Dedicated Banner when EXPIRED filter is selected
    if (filterStatus == "EXPIRED") {
      item(key = "admin_expired_alert") {
        Surface(
          shape = RoundedCornerShape(12.dp),
          color = Color(0xFFFFF1F2),
          border = BorderStroke(1.5.dp, Color(0xFFFDA4AF)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Icon(Icons.Default.Warning, contentDescription = "Expired", tint = Color(0xFFE11D48), modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Column {
              Text(
                text = "⚠️ මාස 6 සම්පූර්ණ වූ සිසුන්ගේ වෙනම ලැයිස්තුව (Expired Students)",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF9F1239)
              )
              Text(
                text = "මෙම සිසුන්ගේ මාස 6ක (දින 180) කාලය සම්පූර්ණ වී ඇති බැවින් ඇප් එකට ලොග් වීම ස්වයංක්‍රීයව අත්හිටුවා ඇත. රු. 1000 ගෙවීමෙන් පසු 'මාස 6ක් අලුත් කරන්න' බොත්තම ඔබා නැවත සක්‍රීය කරන්න.",
                fontSize = 9.5.sp,
                color = Color(0xFFBE123C)
              )
            }
          }
        }
      }
    }

    // 5. User List Cards or Empty View
    if (filteredList.isEmpty()) {
      item(key = "admin_empty_state") {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 40.dp),
          contentAlignment = Alignment.Center
        ) {
          Text(
            text = "පරිශීලකයින් කිසිවෙකු හමු නොවීය.",
            fontSize = 13.sp,
            color = Color(0xFF64748B)
          )
        }
      }
    } else {
      items(filteredList, key = { it.id + it.usernameOrPhone }) { user ->
        AdminUserItemCard(
          user = user,
          onApprove = {
            val idx = registeredUsers.indexOf(user)
            if (idx != -1) {
              val gradesToAssign = getApprovedGradesForPackage(user.requestedGradePackage)
              val updatedUser = user.copy(
                isApproved = true,
                paymentStatus = "Approved",
                approvedGrades = gradesToAssign,
                approvalTimestamp = System.currentTimeMillis()
              )
              registeredUsers[idx] = updatedUser
              onUsersUpdated()
              
              // Cloud Sync
              coroutineScope.launch {
                CloudAuthManager.syncUserToCloud(context, updatedUser)
              }
              
              Toast.makeText(context, "${user.fullName} හට මාස 6කට (දින 180) සාර්ථකව අනුමත කරන ලදී!", Toast.LENGTH_SHORT).show()
            }
          },
          onRevoke = {
            val idx = registeredUsers.indexOf(user)
            if (idx != -1) {
              val updatedUser = user.copy(isApproved = false, paymentStatus = "Revoked")
              registeredUsers[idx] = updatedUser
              onUsersUpdated()
              
              // Cloud Sync
              coroutineScope.launch {
                CloudAuthManager.syncUserToCloud(context, updatedUser)
              }
              
              Toast.makeText(context, "${user.fullName} අනුමැතිය අවලංගු කරන ලදී.", Toast.LENGTH_SHORT).show()
            }
          },
          onResetDeviceLock = {
            val idx = registeredUsers.indexOf(user)
            if (idx != -1) {
              registeredUsers[idx] = user.copy(boundDeviceId = null, boundDeviceName = null, boundDate = null)
              onUsersUpdated()
              Toast.makeText(context, "📱 ${user.fullName} ගේ Device Lock එක ඉවත් කරන ලදී!", Toast.LENGTH_SHORT).show()
            }
          },
          onToggleGrade = { gradeNum ->
            val idx = registeredUsers.indexOf(user)
            if (idx != -1) {
              val current = user.approvedGrades.toMutableList()
              if (current.contains(gradeNum)) {
                current.remove(gradeNum)
              } else {
                current.add(gradeNum)
              }
              registeredUsers[idx] = user.copy(approvedGrades = current)
              onUsersUpdated()
            }
          },
          onGrantOlCombo = {
            val idx = registeredUsers.indexOf(user)
            if (idx != -1) {
              registeredUsers[idx] = user.copy(
                approvedGrades = listOf("10", "11", "10 ශ්‍රේණිය", "11 ශ්‍රේණිය"),
                isApproved = true,
                paymentStatus = "Approved",
                approvalTimestamp = System.currentTimeMillis()
              )
              onUsersUpdated()
              Toast.makeText(context, "${user.fullName} හට 10+11 O/L ප්‍රවේශය (මාස 6 / දින 180) ලබාදුනි!", Toast.LENGTH_SHORT).show()
            }
          },
          onGrantAllGrades = {
            val idx = registeredUsers.indexOf(user)
            if (idx != -1) {
              registeredUsers[idx] = user.copy(
                approvedGrades = listOf("06", "07", "08", "09", "10", "11", "6 ශ්‍රේණිය", "7 ශ්‍රේණිය", "8 ශ්‍රේණිය", "9 ශ්‍රේණිය", "10 ශ්‍රේණිය", "11 ශ්‍රේණිය"),
                isApproved = true,
                paymentStatus = "Approved",
                approvalTimestamp = System.currentTimeMillis()
              )
              onUsersUpdated()
              Toast.makeText(context, "${user.fullName} හට සියලු ශ්‍රේණි (06-11) ප්‍රවේශය (මාස 6 / දින 180) ලබාදුනි!", Toast.LENGTH_SHORT).show()
            }
          },
          onDelete = {
            registeredUsers.remove(user)
            onUsersUpdated()
            Toast.makeText(context, "${user.fullName} ගිණුම මකා දමන ලදී.", Toast.LENGTH_SHORT).show()
          },
          onPreviewReceipt = { uri ->
            onPreviewReceipt(uri)
          }
        )
      }
    }
  }
}

/**
 * Individual User Card in Admin List
 */
@Composable
private fun AdminUserItemCard(
  user: UserAccount,
  onApprove: () -> Unit,
  onRevoke: () -> Unit,
  onResetDeviceLock: () -> Unit,
  onToggleGrade: (String) -> Unit,
  onGrantOlCombo: () -> Unit,
  onGrantAllGrades: () -> Unit,
  onDelete: () -> Unit,
  onPreviewReceipt: (String) -> Unit
) {
  val context = LocalContext.current
  val isAdminAccount = isAuthorizedAdminUser(user.usernameOrPhone)
  var showPassword by remember { mutableStateOf(false) }
  var showRevokeConfirmDialog by remember { mutableStateOf(false) }
  var showDeleteConfirmDialog by remember { mutableStateOf(false) }

  Surface(
    shape = RoundedCornerShape(16.dp),
    color = if (isAdminAccount) Color(0xFFEFF6FF) else if (user.isApproved) Color(0xFFF0FDF4) else Color(0xFFFFFBEB),
    border = BorderStroke(
      1.dp,
      if (isAdminAccount) Color(0xFFBFDBFE) else if (user.isApproved) Color(0xFF86EFAC) else Color(0xFFFDE68A)
    ),
    shadowElevation = 2.dp,
    modifier = Modifier.fillMaxWidth()
  ) {
    Column(modifier = Modifier.padding(12.dp)) {
      // User Info Header
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier.weight(1f)
        ) {
          Surface(
            shape = CircleShape,
            color = if (isAdminAccount) Color(0xFF1E3A8A) else if (user.isApproved) Color(0xFF059669) else Color(0xFFD97706),
            modifier = Modifier.size(34.dp)
          ) {
            Box(contentAlignment = Alignment.Center) {
              Icon(
                imageVector = if (isAdminAccount) Icons.Default.AdminPanelSettings else if (user.isApproved) Icons.Default.Verified else Icons.Default.Person,
                contentDescription = "User",
                tint = Color.White,
                modifier = Modifier.size(18.dp)
              )
            }
          }

          Spacer(modifier = Modifier.width(8.dp))

          Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text(
                text = user.fullName,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = Color(0xFF0F172A)
              )
              Spacer(modifier = Modifier.width(6.dp))
              val isExpired = user.isApprovalExpired()
              val remainingDays = user.getRemainingApprovalDays()
              Surface(
                shape = RoundedCornerShape(4.dp),
                color = when {
                  isAdminAccount -> Color(0xFFDBEAFE)
                  isExpired -> Color(0xFFFEE2E2)
                  user.isApproved -> Color(0xFFDCFCE7)
                  else -> Color(0xFFFEF3C7)
                }
              ) {
                Text(
                  text = when {
                    isAdminAccount -> "👑 ඇඩ්මින්"
                    isExpired -> "⚠️ මාස 6 අවසන් (රු. 1000)"
                    user.isApproved -> "✅ අනුමතයි (${remainingDays}d)"
                    else -> "⏳ අනුමැතියට"
                  },
                  fontSize = 9.sp,
                  fontWeight = FontWeight.Bold,
                  color = when {
                    isAdminAccount -> Color(0xFF1D4ED8)
                    isExpired -> Color(0xFFB91C1C)
                    user.isApproved -> Color(0xFF15803D)
                    else -> Color(0xFFB45309)
                  },
                  modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                )
              }
            }

            Text(
              text = "📞 ${user.usernameOrPhone}",
              fontSize = 11.sp,
              color = Color(0xFF475569)
            )
          }
        }

        // WhatsApp Direct Link Button for Student Contact
        if (!isAdminAccount && user.usernameOrPhone.isNotBlank()) {
          Surface(
            onClick = {
              val cleanNumber = user.usernameOrPhone.replace("+", "").replace(" ", "").trim()
              val targetPhone = if (cleanNumber.startsWith("0")) "94" + cleanNumber.substring(1) else cleanNumber
              val whatsappMsg = "ආයුබෝවන් ${user.fullName}, O/L Study Portal ඇප් එකේ ඔබගේ අනුමැති ඉල්ලීම සම්බන්ධවයි!"
              val encodedMsg = Uri.encode(whatsappMsg)
              val wpUri = Uri.parse("https://api.whatsapp.com/send?phone=$targetPhone&text=$encodedMsg")
              val intent = Intent(Intent.ACTION_VIEW, wpUri).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
              }
              try {
                context.startActivity(intent)
              } catch (_: Exception) {
                Toast.makeText(context, "WhatsApp සොයාගත නොහැකි විය.", Toast.LENGTH_SHORT).show()
              }
            },
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFFDCFCE7),
            border = BorderStroke(1.dp, Color(0xFF86EFAC))
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Icon(Icons.Default.Phone, contentDescription = "WhatsApp Student", tint = Color(0xFF16A34A), modifier = Modifier.size(13.dp))
              Spacer(modifier = Modifier.width(4.dp))
              Text("WhatsApp", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF15803D))
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      // Password & Package Info
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Icon(Icons.Default.Key, contentDescription = "Password", tint = Color(0xFF64748B), modifier = Modifier.size(13.dp))
          Spacer(modifier = Modifier.width(4.dp))
          Text(
            text = "මුරපදය: " + if (showPassword) user.password else "••••••••",
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF334155)
          )
          Spacer(modifier = Modifier.width(4.dp))
          IconButton(
            onClick = { showPassword = !showPassword },
            modifier = Modifier.size(20.dp)
          ) {
            Icon(
              imageVector = if (showPassword) Icons.Default.VisibilityOff else Icons.Default.Visibility,
              contentDescription = "Toggle Pass",
              tint = Color(0xFF64748B),
              modifier = Modifier.size(13.dp)
            )
          }
        }

        Text(
          text = "📦 ${user.requestedGradePackage.take(24)}...",
          fontSize = 10.sp,
          color = Color(0xFF64748B),
          maxLines = 1
        )
      }

      // Dates Information (Request Date, Approved Date, 6-Month Expiry Date)
      Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFFF8FAFC),
        border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
      ) {
        Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)) {
          // 1. Request Date
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Text(
              text = "📅 ඉල්ලුම් කළ දිනය (Request):",
              fontSize = 9.5.sp,
              fontWeight = FontWeight.Medium,
              color = Color(0xFF475569)
            )
            Text(
              text = user.getRequestDateFormatted(),
              fontSize = 9.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF0F172A)
            )
          }

          // 2. Approved Date & 6-Month Expiry Date (if approved)
          if (user.isApproved || user.approvalTimestamp != null) {
            Spacer(modifier = Modifier.height(2.dp))
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Text(
                text = "📅 අනුමත කළ දිනය (Approved):",
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF166534)
              )
              Text(
                text = user.getApprovedDateFormatted(),
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF166534)
              )
            }

            Spacer(modifier = Modifier.height(2.dp))
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Text(
                text = "⏳ මාස 6 අවසන් දිනය (Expiry):",
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Medium,
                color = if (user.isApprovalExpired()) Color(0xFFB91C1C) else Color(0xFFD97706)
              )
              Text(
                text = user.getExpiryDateFormatted(),
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Bold,
                color = if (user.isApprovalExpired()) Color(0xFFB91C1C) else Color(0xFFD97706)
              )
            }
          }
        }
      }

      // Device Lock Status Row
      Spacer(modifier = Modifier.height(4.dp))
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        if (user.boundDeviceId != null) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.PhoneAndroid, contentDescription = "Device", tint = Color(0xFF2563EB), modifier = Modifier.size(12.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text(
              text = "Lock: ${user.boundDeviceName ?: "Android Device"}",
              fontSize = 10.sp,
              fontWeight = FontWeight.SemiBold,
              color = Color(0xFF2563EB)
            )
          }

          OutlinedButton(
            onClick = onResetDeviceLock,
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFDC2626)),
            border = BorderStroke(1.dp, Color(0xFFFCA5A5)),
            shape = RoundedCornerShape(6.dp),
            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp),
            modifier = Modifier.height(24.dp)
          ) {
            Icon(Icons.Default.LockOpen, contentDescription = "Unlock", modifier = Modifier.size(11.dp))
            Spacer(modifier = Modifier.width(3.dp))
            Text("🔓 Reset Device Lock", fontSize = 9.sp, fontWeight = FontWeight.Bold)
          }
        } else {
          Text(
            text = "🔓 Device Lock: Not Bound Yet (ඕනෑම දුරකථනයකින් ප්‍රවේශ විය හැක)",
            fontSize = 9.sp,
            color = Color(0xFF64748B)
          )
        }
      }

      // Bank Slip Preview Button (if uploaded)
      if (user.slipImageUri != null) {
        Spacer(modifier = Modifier.height(6.dp))
        Button(
          onClick = { onPreviewReceipt(user.slipImageUri!!) },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEFF6FF), contentColor = Color(0xFF1D4ED8)),
          border = BorderStroke(1.dp, Color(0xFF93C5FD)),
          shape = RoundedCornerShape(8.dp),
          modifier = Modifier.fillMaxWidth().height(30.dp),
          contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp)
        ) {
          Icon(Icons.Default.Visibility, contentDescription = "View Receipt", modifier = Modifier.size(14.dp))
          Spacer(modifier = Modifier.width(6.dp))
          Text("🧾 බැංකු රිසිට්පත පරීක්ෂා කරන්න (View Slip)", fontSize = 10.sp, fontWeight = FontWeight.Bold)
        }
      }

      // Grade Permissions Interactive Matrix (06 - 11)
      Spacer(modifier = Modifier.height(8.dp))
      Text(
        text = "අනුමත ශ්‍රේණි (Grade Access):",
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF334155)
      )
      Spacer(modifier = Modifier.height(4.dp))

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
      ) {
        listOf("06", "07", "08", "09", "10", "11").forEach { gradeNum ->
          val isGranted = user.approvedGrades.any { it.contains(gradeNum) }
          Surface(
            onClick = { onToggleGrade(gradeNum) },
            shape = RoundedCornerShape(6.dp),
            color = if (isGranted) Color(0xFF15803D) else Color(0xFFE2E8F0),
            border = BorderStroke(1.dp, if (isGranted) Color(0xFF16A34A) else Color(0xFFCBD5E1)),
            modifier = Modifier.weight(1f)
          ) {
            Text(
              text = "$gradeNum",
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              textAlign = TextAlign.Center,
              color = if (isGranted) Color.White else Color(0xFF475569),
              modifier = Modifier.padding(vertical = 4.dp)
            )
          }
        }
      }

      // Quick Combo Buttons
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 4.dp),
        horizontalArrangement = Arrangement.End
      ) {
        TextButton(
          onClick = onGrantOlCombo,
          contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp),
          modifier = Modifier.height(24.dp)
        ) {
          Text("⭐ 10+11 O/L", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1D4ED8))
        }
        TextButton(
          onClick = onGrantAllGrades,
          contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp),
          modifier = Modifier.height(24.dp)
        ) {
          Text("🌟 සියලු ශ්‍රේණි (06-11)", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF059669))
        }
      }

      // Action Buttons Row (Approve, Revoke, Delete)
      if (!isAdminAccount) {
        HorizontalDivider(modifier = Modifier.padding(vertical = 6.dp), color = Color(0xFFE2E8F0))
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          if (!user.isApproved || user.isApprovalExpired()) {
            Button(
              onClick = onApprove,
              colors = ButtonDefaults.buttonColors(containerColor = if (user.isApprovalExpired()) Color(0xFFDC2626) else Color(0xFF059669)),
              shape = RoundedCornerShape(8.dp),
              modifier = Modifier.height(30.dp),
              contentPadding = PaddingValues(horizontal = 10.dp, vertical = 2.dp)
            ) {
              Icon(Icons.Default.Check, contentDescription = "Approve", modifier = Modifier.size(14.dp))
              Spacer(modifier = Modifier.width(4.dp))
              Text(
                text = if (user.isApprovalExpired()) "🔄 මාස 6ක් අලුත් කරන්න (රු. 1000)" else "අනුමත කරන්න (මාස 6 / රු. 1000)",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
              )
            }
          } else {
            OutlinedButton(
              onClick = { showRevokeConfirmDialog = true },
              colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFD97706)),
              border = BorderStroke(1.dp, Color(0xFFFBBF24)),
              shape = RoundedCornerShape(8.dp),
              modifier = Modifier.height(30.dp),
              contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp)
            ) {
              Text("අනුමැතිය අවලංගු කරන්න", fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
          }

          IconButton(
            onClick = { showDeleteConfirmDialog = true },
            modifier = Modifier.size(28.dp)
          ) {
            Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color(0xFFEF4444), modifier = Modifier.size(16.dp))
          }
        }
      }
    }
  }

  // Revoke Approval Confirmation Dialog
  if (showRevokeConfirmDialog) {
    AlertDialog(
      onDismissRequest = { showRevokeConfirmDialog = false },
      icon = {
        Icon(
          imageVector = Icons.Default.Warning,
          contentDescription = "Warning",
          tint = Color(0xFFD97706),
          modifier = Modifier.size(28.dp)
        )
      },
      title = {
        Text(
          text = "⚠️ අනුමැතිය අවලංගු කිරීමට ස්ථීරද?",
          fontWeight = FontWeight.Bold,
          fontSize = 15.sp,
          color = Color(0xFF0F172A)
        )
      },
      text = {
        Text(
          text = "${user.fullName} (${user.usernameOrPhone}) පරිශීලකයාගේ ඇඩ්මින් අනුමැතිය අවලංගු කිරීමට ස්ථීරද?",
          fontSize = 13.sp,
          color = Color(0xFF334155)
        )
      },
      confirmButton = {
        Button(
          onClick = {
            showRevokeConfirmDialog = false
            onRevoke()
          },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
          shape = RoundedCornerShape(8.dp)
        ) {
          Text("ස්ථීරයි", fontWeight = FontWeight.Bold, fontSize = 12.sp)
        }
      },
      dismissButton = {
        OutlinedButton(
          onClick = { showRevokeConfirmDialog = false },
          shape = RoundedCornerShape(8.dp)
        ) {
          Text("අවලංගු කරන්න", fontSize = 12.sp)
        }
      }
    )
  }

  // Delete User Account Confirmation Dialog
  if (showDeleteConfirmDialog) {
    AlertDialog(
      onDismissRequest = { showDeleteConfirmDialog = false },
      icon = {
        Icon(
          imageVector = Icons.Default.Delete,
          contentDescription = "Delete",
          tint = Color(0xFFEF4444),
          modifier = Modifier.size(28.dp)
        )
      },
      title = {
        Text(
          text = "🗑️ ගිණුම මකා දැමීමට ස්ථීරද?",
          fontWeight = FontWeight.Bold,
          fontSize = 15.sp,
          color = Color(0xFF0F172A)
        )
      },
      text = {
        Text(
          text = "${user.fullName} (${user.usernameOrPhone}) ගිණුම පද්ධතියෙන් සම්පූර්ණයෙන්ම මකා දැමීමට ස්ථීරද?",
          fontSize = 13.sp,
          color = Color(0xFF334155)
        )
      },
      confirmButton = {
        Button(
          onClick = {
            showDeleteConfirmDialog = false
            onDelete()
          },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
          shape = RoundedCornerShape(8.dp)
        ) {
          Text("ස්ථීරයි", fontWeight = FontWeight.Bold, fontSize = 12.sp)
        }
      },
      dismissButton = {
        OutlinedButton(
          onClick = { showDeleteConfirmDialog = false },
          shape = RoundedCornerShape(8.dp)
        ) {
          Text("අවලංගු කරන්න", fontSize = 12.sp)
        }
      }
    )
  }
}

/**
 * ADMIN BROADCAST SECTION
 */
@Composable
private fun AdminBroadcastSection(
  adminBroadcastMessages: SnapshotStateList<AdminBroadcastMessage>,
  onSendBroadcast: (title: String, message: String, priority: BroadcastPriority, targetGrade: String) -> Unit
) {
  val context = LocalContext.current
  Column(
    modifier = Modifier
      .fillMaxSize()
      .verticalScroll(rememberScrollState())
  ) {
    // Broadcast Composer Box
    AdminBroadcastComposerBox(
      onSendMessage = onSendBroadcast
    )

    Spacer(modifier = Modifier.height(16.dp))

    Text(
      text = "📢 සක්‍රීය නිවේදන (${adminBroadcastMessages.size}):",
      fontWeight = FontWeight.Bold,
      fontSize = 13.sp,
      color = Color(0xFF0F172A)
    )
    Spacer(modifier = Modifier.height(8.dp))

    if (adminBroadcastMessages.isEmpty()) {
      Text(
        text = "දැනට කිසිදු නිවේදනයක් නිකුත් කර නොමැත.",
        fontSize = 11.sp,
        color = Color(0xFF64748B)
      )
    } else {
      Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        adminBroadcastMessages.forEach { msg ->
          Surface(
            shape = RoundedCornerShape(10.dp),
            color = Color(0xFFF8FAFC),
            border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(
              modifier = Modifier.padding(12.dp),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Column(modifier = Modifier.weight(1f)) {
                Text(msg.title, fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color(0xFF0F172A))
                Spacer(modifier = Modifier.height(2.dp))
                Text(msg.message, fontSize = 11.sp, color = Color(0xFF475569))
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = "🎯 ඉලක්ක ශ්‍රේණිය: ${msg.targetGrade} • ${msg.timestamp}",
                  fontSize = 9.sp,
                  color = Color(0xFF94A3B8)
                )
              }
              IconButton(
                onClick = {
                  AdminBroadcastManager.deleteMessage(context, msg.id, adminBroadcastMessages)
                  Toast.makeText(context, "නිවේදනය ඉවත් කරන ලදී", Toast.LENGTH_SHORT).show()
                }
              ) {
                Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color(0xFFEF4444), modifier = Modifier.size(18.dp))
              }
            }
          }
        }
      }
    }
  }
}

/**
 * ADMIN CONTENT & GOOGLE DRIVE PDF HUB SECTION
 */
@Composable
private fun AdminContentHubSection(
  stagedContentItems: SnapshotStateList<StagedContentItem>?,
  onReleaseAllStaged: () -> Unit,
  onOpenStagingDialog: () -> Unit,
  onAddNewContentClick: () -> Unit
) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .verticalScroll(rememberScrollState())
  ) {
    if (stagedContentItems != null) {
      AdminStagingCardSection(
        stagedItems = stagedContentItems,
        onReleaseAll = onReleaseAllStaged,
        onOpenStagingDialog = onOpenStagingDialog,
        onAddNewContentClick = onAddNewContentClick
      )
      Spacer(modifier = Modifier.height(16.dp))
    }

    Surface(
      shape = RoundedCornerShape(16.dp),
      color = Color(0xFFF8FAFC),
      border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(14.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Icon(Icons.Default.CloudUpload, contentDescription = "Content", tint = Color(0xFF2563EB))
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "📁 නව අන්තර්ගත එක්කිරීම (Add New Content)",
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            color = Color(0xFF0F172A)
          )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
          text = "ඕනෑම විෂයකට අදාළ කෙටි සටහන්, පසුගිය විභාග ප්‍රශ්න පත්‍ර හෝ Google Drive PDF සබැඳි සෘජුවම ඇප් එකට එක් කරන්න.",
          fontSize = 11.sp,
          color = Color(0xFF475569)
        )
        Spacer(modifier = Modifier.height(12.dp))

        Button(
          onClick = onAddNewContentClick,
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB)),
          shape = RoundedCornerShape(10.dp),
          modifier = Modifier.fillMaxWidth().height(42.dp)
        ) {
          Icon(Icons.Default.CloudUpload, contentDescription = "Add Content")
          Spacer(modifier = Modifier.width(8.dp))
          Text("නව අන්තර්ගතයක් එක් කරන්න", fontWeight = FontWeight.Bold)
        }
      }
    }
  }
}

/**
 * ADMIN SECURITY & SETTINGS SECTION
 */
@Composable
private fun AdminSettingsSection(
  currentPassword: String,
  onPasswordChanged: (String) -> Unit
) {
  val context = LocalContext.current
  var newPasswordInput by remember { mutableStateOf("") }
  var confirmPasswordInput by remember { mutableStateOf("") }
  var showNewPass by remember { mutableStateOf(false) }

  Column(
    modifier = Modifier
      .fillMaxSize()
      .verticalScroll(rememberScrollState())
  ) {
    Surface(
      shape = RoundedCornerShape(16.dp),
      color = Color(0xFFF8FAFC),
      border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(14.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Icon(Icons.Default.AdminPanelSettings, contentDescription = "Security", tint = Color(0xFF1E3A8A))
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "👑 ඇඩ්මින් තොරතුරු (Admin Credentials)",
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            color = Color(0xFF0F172A)
          )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text("• ප්‍රධාන ඇඩ්මින්: අකිල ප්‍රභාත් දිසානායක", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0F172A))
        Text("• බලයලත් දුරකථන අංකය: 0772843861", fontSize = 11.sp, color = Color(0xFF334155))
        Text("• බලයලත් Email: prabathakila450@gmail.com", fontSize = 11.sp, color = Color(0xFF334155))
        Text("• වත්මන් ඇඩ්මින් මුරපදය: $currentPassword", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1D4ED8))

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(color = Color(0xFFE2E8F0))
        Spacer(modifier = Modifier.height(16.dp))

        Text(
          text = "🔑 ඇඩ්මින් මුරපදය වෙනස් කරන්න (Change Admin Password)",
          fontWeight = FontWeight.Bold,
          fontSize = 12.sp,
          color = Color(0xFF0F172A)
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
          value = newPasswordInput,
          onValueChange = { newPasswordInput = it },
          label = { Text("නව මුරපදය (New Password)") },
          singleLine = true,
          visualTransformation = if (showNewPass) VisualTransformation.None else PasswordVisualTransformation(),
          trailingIcon = {
            IconButton(onClick = { showNewPass = !showNewPass }) {
              Icon(if (showNewPass) Icons.Default.VisibilityOff else Icons.Default.Visibility, contentDescription = "Toggle")
            }
          },
          modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
          value = confirmPasswordInput,
          onValueChange = { confirmPasswordInput = it },
          label = { Text("නව මුරපදය නැවත ඇතුළත් කරන්න") },
          singleLine = true,
          visualTransformation = if (showNewPass) VisualTransformation.None else PasswordVisualTransformation(),
          modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
          onClick = {
            if (newPasswordInput.isBlank()) {
              Toast.makeText(context, "කරුණාකර නව මුරපදයක් ඇතුළත් කරන්න.", Toast.LENGTH_SHORT).show()
            } else if (newPasswordInput != confirmPasswordInput) {
              Toast.makeText(context, "මුරපද එකිනෙකට නොගැලපේ!", Toast.LENGTH_SHORT).show()
            } else {
              onPasswordChanged(newPasswordInput.trim())
              newPasswordInput = ""
              confirmPasswordInput = ""
            }
          },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E3A8A)),
          shape = RoundedCornerShape(10.dp),
          modifier = Modifier.fillMaxWidth().height(44.dp)
        ) {
          Icon(Icons.Default.Key, contentDescription = "Save")
          Spacer(modifier = Modifier.width(6.dp))
          Text("නව මුරපදය සුරකින්න", fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(color = Color(0xFFE2E8F0))
        Spacer(modifier = Modifier.height(16.dp))

        // GitHub Release Link Manager
        var githubUrlInput by remember { mutableStateOf(getSavedGitHubShareUrl(context)) }
        Text(
          text = "📦 GitHub Release / Direct APK Share Link",
          fontWeight = FontWeight.Bold,
          fontSize = 12.sp,
          color = Color(0xFF0F172A)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = "අලුතින් Push කරන GitHub Release APK ලින්ක් එක පහතින් යාවත්කාලීන කරන්න. Share කිරීමේදී පරිශීලකයින්ට මෙම ලින්ක් එක යොමු වේ.",
          fontSize = 10.5.sp,
          color = Color(0xFF64748B)
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
          value = githubUrlInput,
          onValueChange = { githubUrlInput = it },
          label = { Text("GitHub Release Direct APK Link") },
          singleLine = true,
          modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
          onClick = {
            if (githubUrlInput.isNotBlank()) {
              saveGitHubShareUrl(context, githubUrlInput.trim())
              Toast.makeText(context, "✅ GitHub Share ලින්ක් එක සාර්ථකව යාවත්කාලීන විය!", Toast.LENGTH_SHORT).show()
            } else {
              Toast.makeText(context, "කරුණාකර වලංගු ලින්ක් එකක් ඇතුළත් කරන්න.", Toast.LENGTH_SHORT).show()
            }
          },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
          shape = RoundedCornerShape(10.dp),
          modifier = Modifier.fillMaxWidth().height(44.dp)
        ) {
          Icon(Icons.Default.CloudUpload, contentDescription = "Update Link", modifier = Modifier.size(16.dp))
          Spacer(modifier = Modifier.width(6.dp))
          Text("GitHub ලින්ක් එක යාවත්කාලීන කරන්න (Update Share Link)", fontWeight = FontWeight.Bold, fontSize = 11.5.sp)
        }
      }
    }
  }
}
