package com.example

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Bitmap
import android.view.MotionEvent
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import java.net.URLEncoder
import kotlin.math.roundToInt

// Three Official Online Question Paper Portals for Grade 11
const val GOVDOC_GRADE_11_URL = "https://govdoc.lk/category/term-test-papers/grade-11"
const val ETHAKSALAWA_GRADE_11_URL = "https://e-thaksalawa.moe.gov.lk/lcms/course/index.php?categoryid=22"
const val PASTPAPERS_WIKI_GRADE_11_URL = "https://pastpapers.wiki/category/term-test-papers/grade-11/"

enum class Grade11WebSource(
  val title: String,
  val subtitle: String,
  val url: String,
  val badge: String,
  val badgeColor: Color
) {
  GOVDOC(
    title = "GovDoc.lk",
    subtitle = "11 වාර Papers",
    url = GOVDOC_GRADE_11_URL,
    badge = "GOVDOC (11)",
    badgeColor = Color(0xFF047857)
  ),
  ETHAKSALAWA(
    title = "e-Thaksalawa",
    subtitle = "නිල MOE",
    url = ETHAKSALAWA_GRADE_11_URL,
    badge = "OFFICIAL MOE",
    badgeColor = Color(0xFF1D4ED8)
  ),
  PASTPAPERS_WIKI(
    title = "PastPapers.wiki",
    subtitle = "පළාත් Papers",
    url = PASTPAPERS_WIKI_GRADE_11_URL,
    badge = "PAST PAPERS",
    badgeColor = Color(0xFFD97706)
  )
}

data class Grade11SubjectFilter(
  val nameSinhala: String,
  val keyword: String,
  val icon: String
)

val grade11SubjectFilterList = listOf(
  Grade11SubjectFilter("සියලුම විෂයන්", "", "📚"),
  Grade11SubjectFilter("විද්‍යාව", "science", "🧬"),
  Grade11SubjectFilter("ගණිතය", "mathematics", "📐"),
  Grade11SubjectFilter("සිංහල", "sinhala", "📖"),
  Grade11SubjectFilter("ඉංග්‍රීසි", "english", "🔤"),
  Grade11SubjectFilter("ඉතිහාසය", "history", "🏛️"),
  Grade11SubjectFilter("බුද්ධ ධර්මය", "buddhism", "☸️"),
  Grade11SubjectFilter("භූගෝල විද්‍යාව", "geography", "🌍"),
  Grade11SubjectFilter("පුරවැසි අධ්‍යාපනය", "civics", "⚖️"),
  Grade11SubjectFilter("තොරතුරු තාක්ෂණය (ICT)", "ict", "💻"),
  Grade11SubjectFilter("වාණිජ්‍ය", "commerce", "📊"),
  Grade11SubjectFilter("කෘෂිකර්මය", "agriculture", "🌱"),
  Grade11SubjectFilter("සෞඛ්‍යය", "health", "🏃"),
  Grade11SubjectFilter("චිත්‍ර කලාව", "art", "🎨"),
  Grade11SubjectFilter("සංගීතය", "music", "🎵"),
  Grade11SubjectFilter("නර්තනය", "dancing", "💃")
)

fun buildGrade11PortalUrl(source: Grade11WebSource, subjectKeyword: String?, term: Int?): String {
  val cleanKey = subjectKeyword?.trim().orEmpty()
  val termStr = when (term) {
    1 -> "1st term"
    2 -> "2nd term"
    3 -> "3rd term"
    else -> ""
  }

  val queryParts = listOf(cleanKey, termStr).filter { it.isNotBlank() }
  val query = queryParts.joinToString(" ")

  return when (source) {
    Grade11WebSource.GOVDOC -> {
      if (query.isNotBlank()) {
        try {
          "https://govdoc.lk/category/term-test-papers/grade-11?s=${URLEncoder.encode(query, "UTF-8")}"
        } catch (_: Exception) {
          GOVDOC_GRADE_11_URL
        }
      } else {
        GOVDOC_GRADE_11_URL
      }
    }
    Grade11WebSource.ETHAKSALAWA -> {
      ETHAKSALAWA_GRADE_11_URL
    }
    Grade11WebSource.PASTPAPERS_WIKI -> {
      if (query.isNotBlank()) {
        try {
          "https://pastpapers.wiki/?s=${URLEncoder.encode("grade 11 $query", "UTF-8")}"
        } catch (_: Exception) {
          PASTPAPERS_WIKI_GRADE_11_URL
        }
      } else {
        PASTPAPERS_WIKI_GRADE_11_URL
      }
    }
  }
}

/**
 * 11 ශ්‍රේණිය වාර විභාග ප්‍රශ්න පත්‍ර වෙබ් අඩවි ත්‍රිත්ව ද්වාරය (Grade 11 Three Portals Viewer)
 * 1. GovDoc.lk (11 වසර වාර විභාග)
 * 2. e-Thaksalawa (අධ්‍යාපන අමාත්‍යාංශ නිල ද්වාරය)
 * 3. PastPapers.wiki (11 ශ්‍රේණිය පළාත් ප්‍රශ්න පත්‍ර)
 * 
 * - ඉහළ හිස් සුදු පසුබිම සම්පූර්ණයෙන් ඉවත් කරන ලදී (Zero empty white space at top)
 * - පූර්ණ තිරයේදී (Full Screen) 100% කිසිදු බාධාවකින් තොරව ප්‍රශ්න පත්‍රය පමණක් දිස්වේ
 * - සාමාන්‍ය මාදිලියේදී මුළු තිරයම ඉහළ පහළ scroll වන අතිශය සිහින් පෙරහන් තීරුව (58dp)
 */
@SuppressLint("SetJavaScriptEnabled", "ClickableViewAccessibility")
@Composable
fun Grade11SecureTermTestPortalScreen(
  initialSource: Grade11WebSource = Grade11WebSource.GOVDOC,
  initialSubject: String? = null,
  initialTerm: Int? = null,
  studentName: String = "ශිෂ්‍ය ගිණුම",
  studentPhone: String = "",
  onOpenPdfModal: ((url: String, title: String) -> Unit)? = null,
  onBack: () -> Unit
) {
  val context = LocalContext.current
  val activity = context as? Activity

  DisposableEffect(activity) {
    activity?.let { act ->
      AppSecurityManager.applyScreenProtection(act, !AppSecurityManager.isAdminSession)
    }
    onDispose {}
  }

  var currentSource by remember { mutableStateOf(initialSource) }
  var selectedSubjectName by remember {
    mutableStateOf(
      if (!initialSubject.isNullOrBlank() && grade11SubjectFilterList.any { it.nameSinhala == initialSubject }) {
        initialSubject
      } else {
        "සියලුම විෂයන්"
      }
    )
  }
  var selectedTerm by remember { mutableStateOf(initialTerm ?: 0) } // 0: All, 1: 1st, 2: 2nd, 3: 3rd

  val selectedSubjectKeyword = remember(selectedSubjectName) {
    grade11SubjectFilterList.firstOrNull { it.nameSinhala == selectedSubjectName }?.keyword.orEmpty()
  }

  var activeUrl by remember {
    mutableStateOf(buildGrade11PortalUrl(initialSource, selectedSubjectKeyword, selectedTerm))
  }

  var webViewInstance by remember { mutableStateOf<WebView?>(null) }
  var isLoading by remember { mutableStateOf(true) }
  var pageProgress by remember { mutableIntStateOf(0) }
  var canGoBack by remember { mutableStateOf(false) }
  var canGoForward by remember { mutableStateOf(false) }
  var showWatermark by remember { mutableStateOf(true) }
  var isFullScreen by remember { mutableStateOf(false) }

  fun navigateTo(source: Grade11WebSource, subjectKey: String, term: Int) {
    currentSource = source
    val targetUrl = buildGrade11PortalUrl(source, subjectKey, if (term > 0) term else null)
    activeUrl = targetUrl
    webViewInstance?.loadUrl(targetUrl)
  }

  // Hardware back button navigates web history first, then exits full screen, then exits portal
  BackHandler {
    if (webViewInstance?.canGoBack() == true) {
      webViewInstance?.goBack()
    } else if (isFullScreen) {
      isFullScreen = false
    } else {
      onBack()
    }
  }

  // Compact header height (strictly 58dp for both lines)
  val density = LocalDensity.current
  val headerTotalHeightDp = 58.dp
  val headerTotalHeightPx = with(density) { headerTotalHeightDp.roundToPx().toFloat() }
  var headerOffsetPx by remember { mutableFloatStateOf(0f) }

  val currentOffsetDp = with(density) { headerOffsetPx.toDp() }
  // When in full screen, visibleHeaderHeightDp is strictly 0.dp (completely removed white background!)
  val visibleHeaderHeightDp = if (isFullScreen) 0.dp else (headerTotalHeightDp + currentOffsetDp).coerceIn(0.dp, headerTotalHeightDp)

  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.White)
  ) {
    // =========================================================================
    // 1. WEB VIEW CONTAINER (Fills 100% of screen in fullscreen, or padded by visible slim header)
    // =========================================================================
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(top = visibleHeaderHeightDp)
        .background(Color.White)
    ) {
      AndroidView(
        factory = { ctx ->
          WebView(ctx).apply {
            webViewInstance = this
            isVerticalScrollBarEnabled = true
            isHorizontalScrollBarEnabled = true
            isNestedScrollingEnabled = true
            overScrollMode = View.OVER_SCROLL_ALWAYS
            scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY

            // Anti-Copy & Secure configuration
            isLongClickable = false
            isHapticFeedbackEnabled = false
            setOnLongClickListener { true }

            settings.apply {
              javaScriptEnabled = true
              domStorageEnabled = true
              databaseEnabled = true
              setSupportZoom(true)
              builtInZoomControls = true
              displayZoomControls = false
              useWideViewPort = true
              loadWithOverviewMode = true
              mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
              userAgentString = "Mozilla/5.0 (Linux; Android 14; Mobile) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Mobile Safari/537.36"
            }

            // Scroll listener: dynamically hides the slim header when scrolling down into papers
            setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
              val dy = scrollY - oldScrollY
              if (scrollY <= 2) {
                headerOffsetPx = 0f
              } else if (dy > 4) {
                headerOffsetPx = (headerOffsetPx - dy).coerceIn(-headerTotalHeightPx, 0f)
              } else if (dy < -4) {
                headerOffsetPx = (headerOffsetPx - dy).coerceIn(-headerTotalHeightPx, 0f)
              }
            }

            // Touch gesture tracking for smooth interactive scrolling
            var lastTouchY = 0f
            setOnTouchListener { _, event ->
              when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                  lastTouchY = event.rawY
                }
                MotionEvent.ACTION_MOVE -> {
                  val dy = lastTouchY - event.rawY
                  lastTouchY = event.rawY
                  if (dy > 5) {
                    headerOffsetPx = (headerOffsetPx - dy).coerceIn(-headerTotalHeightPx, 0f)
                  } else if (dy < -5) {
                    headerOffsetPx = (headerOffsetPx - dy).coerceIn(-headerTotalHeightPx, 0f)
                  }
                }
              }
              false
            }

            webChromeClient = object : WebChromeClient() {
              override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                pageProgress = newProgress
              }
            }

            webViewClient = object : WebViewClient() {
              override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                isLoading = true
              }

              override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                isLoading = false
                canGoBack = view?.canGoBack() ?: false
                canGoForward = view?.canGoForward() ?: false

                val drmScript = """
                  (function() {
                    var css = '* { -webkit-user-select: none !important; user-select: none !important; } ' +
                              'html, body { overflow-y: scroll !important; -webkit-overflow-scrolling: touch !important; height: auto !important; min-height: 100% !important; touch-action: pan-y pan-x !important; }';
                    var head = document.head || document.getElementsByTagName('head')[0];
                    if (head) {
                      var style = document.createElement('style');
                      style.type = 'text/css';
                      style.appendChild(document.createTextNode(css));
                      head.appendChild(style);
                    }
                    ['contextmenu', 'copy', 'cut', 'selectstart'].forEach(function(evt) {
                      document.addEventListener(evt, function(e) { e.preventDefault(); return false; }, true);
                    });
                  })();
                """.trimIndent()
                view?.evaluateJavascript(drmScript, null)
              }

              override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                val target = request?.url?.toString() ?: return false
                if (target.endsWith(".pdf", ignoreCase = true) || target.contains(".pdf?", ignoreCase = true)) {
                  view?.loadUrl("https://docs.google.com/viewer?embedded=true&url=${URLEncoder.encode(target, "UTF-8")}")
                  return true
                }
                if (target.contains("drive.google.com") && !target.contains("/preview")) {
                  val previewUrl = if (target.contains("/view")) target.replace("/view", "/preview") else target
                  view?.loadUrl(previewUrl)
                  return true
                }
                return false
              }
            }

            setDownloadListener { downloadUrl, _, _, _, _ ->
              if (downloadUrl.endsWith(".pdf", ignoreCase = true) || downloadUrl.contains(".pdf")) {
                loadUrl("https://docs.google.com/viewer?embedded=true&url=${URLEncoder.encode(downloadUrl, "UTF-8")}")
              } else {
                Toast.makeText(ctx, "ප්‍රශ්න පත්‍රය යෙදුම තුළම කියවීමට සූදානම් කෙරේ...", Toast.LENGTH_SHORT).show()
                loadUrl(downloadUrl)
              }
            }

            loadUrl(activeUrl)
          }
        },
        update = { webView ->
          webViewInstance = webView
        },
        onRelease = { webView ->
          webView.stopLoading()
          webView.destroy()
        },
        modifier = Modifier.fillMaxSize()
      )

      // Anti-Theft Watermark
      if (showWatermark) {
        Box(
          modifier = Modifier
            .fillMaxSize()
            .alpha(0.04f)
            .padding(16.dp)
        ) {
          Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            repeat(4) { idx ->
              Text(
                text = "GRADE 11 OFFICIAL • ${studentName.take(15)}",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.rotate(if (idx % 2 == 0) -15f else 15f)
              )
            }
          }
        }
      }

      // Subtle Floating Button to Exit Fullscreen
      if (isFullScreen) {
        Surface(
          onClick = { isFullScreen = false },
          shape = RoundedCornerShape(20.dp),
          color = Color(0xF00F172A),
          border = BorderStroke(1.dp, Color(0xFF38BDF8)),
          shadowElevation = 6.dp,
          modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(bottom = 16.dp, end = 12.dp)
            .testTag("grade11_floating_exit_fullscreen_btn")
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Icon(
              imageVector = Icons.Default.FullscreenExit,
              contentDescription = "Exit Fullscreen",
              tint = Color(0xFF38BDF8),
              modifier = Modifier.size(14.dp)
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(
              text = "සාමාන්‍ය තිරය",
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
          }
        }
      }

      // Floating button to summon header if scrolled off
      if (!isFullScreen && headerOffsetPx < -20f) {
        Surface(
          onClick = { headerOffsetPx = 0f },
          shape = RoundedCornerShape(16.dp),
          color = Color(0xEEFFFFFF),
          border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
          shadowElevation = 4.dp,
          modifier = Modifier
            .align(Alignment.TopEnd)
            .padding(top = 6.dp, end = 8.dp)
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text("▼ විෂය/වාර", fontSize = 8.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF047857))
          }
        }
      }
    }

    // =========================================================================
    // 2. ULTRA-COMPACT SLIM HEADER (Totally hidden in full-screen mode - NO WHITE BAR AT TOP!)
    // =========================================================================
    if (!isFullScreen) {
      Surface(
        color = Color.White,
        shadowElevation = 2.dp,
        border = BorderStroke(0.6.dp, Color(0xFFE2E8F0)),
        modifier = Modifier
          .fillMaxWidth()
          .offset { IntOffset(x = 0, y = headerOffsetPx.roundToInt()) }
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 2.dp),
          verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
          // Line 1: Ultra-slim title bar + 3 website options + action buttons (Height: 28dp)
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .height(28.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              modifier = Modifier.weight(1f, fill = false)
            ) {
              IconButton(
                onClick = onBack,
                modifier = Modifier
                  .size(26.dp)
                  .testTag("grade11_portal_back_btn")
              ) {
                Icon(
                  imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                  contentDescription = "Back",
                  tint = Color(0xFF0F172A),
                  modifier = Modifier.size(16.dp)
                )
              }

              Text(
                text = "11 වසර",
                fontSize = 11.5.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF0F172A)
              )

              Spacer(modifier = Modifier.width(4.dp))

              // 3 Quick Website Source Pills
              Grade11WebSource.values().forEach { src ->
                val isSelected = currentSource == src
                Surface(
                  onClick = {
                    if (currentSource != src) {
                      navigateTo(src, selectedSubjectKeyword, selectedTerm)
                    }
                  },
                  shape = RoundedCornerShape(4.dp),
                  color = if (isSelected) src.badgeColor else Color(0xFFF1F5F9),
                  modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .height(22.dp)
                ) {
                  Box(
                    modifier = Modifier.padding(horizontal = 5.dp),
                    contentAlignment = Alignment.Center
                  ) {
                    Text(
                      text = src.title,
                      fontSize = 8.5.sp,
                      fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                      color = if (isSelected) Color.White else Color(0xFF334155)
                    )
                  }
                }
              }
            }

            // Web Navigation and Fullscreen Controls
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
              IconButton(
                onClick = { if (webViewInstance?.canGoBack() == true) webViewInstance?.goBack() },
                enabled = canGoBack,
                modifier = Modifier.size(22.dp)
              ) {
                Icon(
                  imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                  contentDescription = "Back",
                  tint = if (canGoBack) Color(0xFF0F172A) else Color(0xFFCBD5E1),
                  modifier = Modifier.size(13.dp)
                )
              }

              IconButton(
                onClick = { if (webViewInstance?.canGoForward() == true) webViewInstance?.goForward() },
                enabled = canGoForward,
                modifier = Modifier.size(22.dp)
              ) {
                Icon(
                  imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                  contentDescription = "Forward",
                  tint = if (canGoForward) Color(0xFF0F172A) else Color(0xFFCBD5E1),
                  modifier = Modifier.size(13.dp)
                )
              }

              Surface(
                onClick = { webViewInstance?.zoomOut() },
                shape = RoundedCornerShape(3.dp),
                color = Color(0xFFF1F5F9),
                modifier = Modifier.height(20.dp)
              ) {
                Box(modifier = Modifier.padding(horizontal = 3.5.dp), contentAlignment = Alignment.Center) {
                  Text("A-", fontSize = 8.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0F172A))
                }
              }

              Surface(
                onClick = { webViewInstance?.zoomIn() },
                shape = RoundedCornerShape(3.dp),
                color = Color(0xFFF1F5F9),
                modifier = Modifier.height(20.dp)
              ) {
                Box(modifier = Modifier.padding(horizontal = 3.5.dp), contentAlignment = Alignment.Center) {
                  Text("A+", fontSize = 8.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0F172A))
                }
              }

              IconButton(
                onClick = { webViewInstance?.reload() },
                modifier = Modifier.size(22.dp)
              ) {
                Icon(
                  imageVector = Icons.Default.Refresh,
                  contentDescription = "Reload",
                  tint = Color(0xFF0F172A),
                  modifier = Modifier.size(13.dp)
                )
              }

              Surface(
                onClick = { isFullScreen = true },
                shape = RoundedCornerShape(3.dp),
                color = Color(0xFF047857),
                modifier = Modifier
                  .height(20.dp)
                  .testTag("grade11_enter_fullscreen_btn")
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 4.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text("⛶", fontSize = 8.5.sp, color = Color.White)
                  Spacer(modifier = Modifier.width(1.dp))
                  Text("ෆුල්", fontSize = 8.sp, fontWeight = FontWeight.Bold, color = Color.White)
                }
              }
            }
          }

          // Line 2: Terms and Subject Chips in a single clean horizontal scrolling line (Height: 24dp)
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(3.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            // Terms
            listOf(
              0 to "සියලුම වාර",
              1 to "1 වන වාරය",
              2 to "2 වන වාරය",
              3 to "3 වන වාරය"
            ).forEach { (termNum, label) ->
              val isSelected = selectedTerm == termNum
              Surface(
                onClick = {
                  selectedTerm = termNum
                  navigateTo(currentSource, selectedSubjectKeyword, termNum)
                },
                shape = RoundedCornerShape(4.dp),
                color = if (isSelected) Color(0xFFDC2626) else Color(0xFFF1F5F9),
                modifier = Modifier.height(22.dp)
              ) {
                Box(modifier = Modifier.padding(horizontal = 5.dp), contentAlignment = Alignment.Center) {
                  Text(
                    text = label,
                    fontSize = 8.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    color = if (isSelected) Color.White else Color(0xFF334155)
                  )
                }
              }
            }

            Text("•", color = Color(0xFF94A3B8), fontSize = 9.sp)

            // Subjects
            grade11SubjectFilterList.forEach { filterItem ->
              val isSelected = selectedSubjectName == filterItem.nameSinhala
              Surface(
                onClick = {
                  selectedSubjectName = filterItem.nameSinhala
                  navigateTo(currentSource, filterItem.keyword, selectedTerm)
                },
                shape = RoundedCornerShape(4.dp),
                color = if (isSelected) Color(0xFF2563EB) else Color(0xFFF1F5F9),
                modifier = Modifier.height(22.dp)
              ) {
                Row(
                  modifier = Modifier.padding(horizontal = 5.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(filterItem.icon, fontSize = 8.5.sp)
                  Spacer(modifier = Modifier.width(2.dp))
                  Text(
                    text = filterItem.nameSinhala,
                    fontSize = 8.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    color = if (isSelected) Color.White else Color(0xFF334155)
                  )
                }
              }
            }
          }

          // Progress Bar
          if (isLoading) {
            LinearProgressIndicator(
              progress = { pageProgress / 100f },
              modifier = Modifier
                .fillMaxWidth()
                .height(1.5.dp),
              color = Color(0xFF10B981),
              trackColor = Color(0xFFE2E8F0)
            )
          }
        }
      }
    }
  }
}
