package com.example

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.withContext

/**
 * EYE-CARE & NIGHT STUDY READER HUB
 * Includes:
 * 1. Theme modes (☀️ Light, 📜 Sepia Warm Paper, 🌙 Midnight Dark, 🛡️ Blue Light Shield)
 * 2. Real-time Font Scaling (0.85x to 1.45x) & Line Spacing
 * 3. WebView CSS & JavaScript injector for Google Drive PDFs & Study Notes
 * 4. 20-20-20 Eye Strain Prevention Timer & Relaxation Guide
 * 5. Synthesized Night Study Ambient Focus Audio Generator (Soft Rain & White Noise)
 * 6. Local Storage Persistence via SharedPreferences
 */

private const val PREFS_NAME = "app_eyecare_night_study_prefs"
private const val KEY_THEME_MODE = "pref_eyecare_theme_mode"
private const val KEY_FONT_SCALE = "pref_eyecare_font_scale"
private const val KEY_LINE_SPACING = "pref_eyecare_line_spacing"
private const val KEY_EYE_BREAK = "pref_eyecare_eye_break_enabled"

fun loadSavedEyeCareTheme(context: Context): EyeCareThemeMode {
  val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
  val raw = prefs.getString(KEY_THEME_MODE, EyeCareThemeMode.LIGHT.name) ?: EyeCareThemeMode.LIGHT.name
  return try {
    val mode = EyeCareThemeMode.valueOf(raw)
    // Always prioritize bright, clear Light mode as standard default
    if (mode == EyeCareThemeMode.DARK) EyeCareThemeMode.LIGHT else mode
  } catch (e: Exception) {
    EyeCareThemeMode.LIGHT
  }
}

fun saveEyeCareTheme(context: Context, mode: EyeCareThemeMode) {
  val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
  prefs.edit().putString(KEY_THEME_MODE, mode.name).apply()
}

fun loadSavedFontScale(context: Context): Float {
  val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
  return prefs.getFloat(KEY_FONT_SCALE, 1.0f)
}

fun saveFontScale(context: Context, scale: Float) {
  val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
  prefs.edit().putFloat(KEY_FONT_SCALE, scale).apply()
}

fun loadSavedLineSpacing(context: Context): Float {
  val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
  return prefs.getFloat(KEY_LINE_SPACING, 1.2f)
}

fun saveLineSpacing(context: Context, spacing: Float) {
  val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
  prefs.edit().putFloat(KEY_LINE_SPACING, spacing).apply()
}

fun loadSavedEyeBreakEnabled(context: Context): Boolean {
  val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
  return prefs.getBoolean(KEY_EYE_BREAK, false)
}

fun saveEyeBreakEnabled(context: Context, enabled: Boolean) {
  val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
  prefs.edit().putBoolean(KEY_EYE_BREAK, enabled).apply()
}

/**
 * Returns JavaScript CSS injection code to dynamically adjust WebView PDF viewer appearance.
 */
fun getEyeCareWebViewJs(mode: EyeCareThemeMode, fontScale: Float = 1.0f): String {
  val filterStyle = when (mode) {
    EyeCareThemeMode.SEPIA -> "filter: sepia(0.68) brightness(0.92) contrast(0.96) !important; background: #FDF6E2 !important;"
    EyeCareThemeMode.DARK -> "filter: invert(0.92) hue-rotate(180deg) brightness(0.88) contrast(1.18) !important; background: #0F172A !important;"
    EyeCareThemeMode.BLUE_LIGHT_SHIELD -> "filter: sepia(0.35) brightness(0.85) contrast(0.98) !important; background: #131B2E !important;"
    EyeCareThemeMode.LIGHT -> "filter: none !important; background: #FFFFFF !important;"
  }

  val zoomPercent = (fontScale * 100).toInt()

  return """
    (function() {
      var styleId = 'eyecare_custom_study_theme';
      var existingStyle = document.getElementById(styleId);
      if (!existingStyle) {
        existingStyle = document.createElement('style');
        existingStyle.id = styleId;
        existingStyle.type = 'text/css';
        (document.head || document.getElementsByTagName('head')[0]).appendChild(existingStyle);
      }
      existingStyle.innerHTML = 'body, html, iframe, embed, .ndfHFb-c4YZDc-bN97Pc { $filterStyle zoom: $zoomPercent% !important; }';
    })();
  """.trimIndent()
}

/**
 * Audio Synthesizer for Relaxing Night Study Background Sound (Rain & Soft White Noise)
 */
class AmbientStudyAudioPlayer {
  private var audioTrack: AudioTrack? = null
  private var isPlaying = false

  fun playSound(type: String) {
    stopSound()
    isPlaying = true
    Thread {
      try {
        val sampleRate = 22050
        val bufferSize = AudioTrack.getMinBufferSize(
          sampleRate,
          AudioFormat.CHANNEL_OUT_MONO,
          AudioFormat.ENCODING_PCM_16BIT
        )
        val track = AudioTrack.Builder()
          .setAudioAttributes(
            AudioAttributes.Builder()
              .setUsage(AudioAttributes.USAGE_MEDIA)
              .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
              .build()
          )
          .setAudioFormat(
            AudioFormat.Builder()
              .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
              .setSampleRate(sampleRate)
              .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
              .build()
          )
          .setBufferSizeInBytes(bufferSize)
          .setTransferMode(AudioTrack.MODE_STREAM)
          .build()

        audioTrack = track
        track.play()

        val buffer = ShortArray(bufferSize)
        var lastRandom = 0.0

        while (isPlaying) {
          for (i in buffer.indices) {
            val white = (Math.random() * 2.0 - 1.0)
            // Brown / Pink noise filter simulation for soothing rainfall effect
            val brown = (lastRandom + (0.02 * white)) / 1.02
            lastRandom = brown

            val sample = when (type) {
              "RAIN" -> (brown * 8000.0).toInt().coerceIn(-32767, 32767).toShort()
              "WHITE" -> (white * 3500.0).toInt().coerceIn(-32767, 32767).toShort()
              else -> (brown * 5500.0).toInt().coerceIn(-32767, 32767).toShort()
            }
            buffer[i] = sample
          }
          track.write(buffer, 0, buffer.size)
        }
      } catch (e: Exception) {
        e.printStackTrace()
      }
    }.start()
  }

  fun stopSound() {
    isPlaying = false
    try {
      audioTrack?.stop()
      audioTrack?.release()
    } catch (e: Exception) {
      // ignore
    }
    audioTrack = null
  }
}

/**
 * EYE-CARE QUICK SETTINGS BOTTOM SHEET
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EyeCareSettingsBottomSheet(
  currentMode: EyeCareThemeMode,
  currentFontScale: Float,
  currentLineSpacing: Float,
  isEyeBreakEnabled: Boolean,
  onModeChanged: (EyeCareThemeMode) -> Unit,
  onFontScaleChanged: (Float) -> Unit,
  onLineSpacingChanged: (Float) -> Unit,
  onEyeBreakToggle: (Boolean) -> Unit,
  onDismiss: () -> Unit
) {
  val context = LocalContext.current
  val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

  ModalBottomSheet(
    onDismissRequest = onDismiss,
    sheetState = sheetState,
    containerColor = MaterialTheme.colorScheme.surface,
    tonalElevation = 6.dp,
    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)
        .padding(bottom = 32.dp)
        .verticalScroll(rememberScrollState()),
      verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
      // Header
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
              .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
          ) {
            Text("🌙", fontSize = 18.sp)
          }
          Spacer(modifier = Modifier.width(10.dp))
          Column {
            Text(
              text = "Eye-Care & Night Study Mode",
              fontWeight = FontWeight.Bold,
              fontSize = 16.sp,
              color = MaterialTheme.colorScheme.onSurface
            )
            Text(
              text = "රාත්‍රී කියවීමේ හා ඇස් ආරක්ෂණ සැකසුම්",
              fontSize = 11.sp,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
          }
        }

        IconButton(onClick = onDismiss) {
          Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close",
            tint = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }
      }

      HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

      // 1. Reading Theme Selection
      Text(
        text = "1. තිරයේ වර්ණ මාදිලිය (Reading Canvas Theme)",
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
        color = MaterialTheme.colorScheme.primary
      )

      Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        EyeCareThemeMode.values().forEach { mode ->
          val isSelected = currentMode == mode
          val bg = when (mode) {
            EyeCareThemeMode.LIGHT -> Color(0xFFF8FAFC)
            EyeCareThemeMode.SEPIA -> Color(0xFFFDF6E2)
            EyeCareThemeMode.DARK -> Color(0xFF0F172A)
            EyeCareThemeMode.BLUE_LIGHT_SHIELD -> Color(0xFF131B2E)
          }
          val textColor = when (mode) {
            EyeCareThemeMode.LIGHT -> Color(0xFF0F172A)
            EyeCareThemeMode.SEPIA -> Color(0xFF2C2214)
            EyeCareThemeMode.DARK -> Color(0xFFF1F5F9)
            EyeCareThemeMode.BLUE_LIGHT_SHIELD -> Color(0xFFFDF0D5)
          }

          Surface(
            onClick = {
              onModeChanged(mode)
              saveEyeCareTheme(context, mode)
              Toast.makeText(context, "${mode.titleSinhala} සක්‍රිය විය", Toast.LENGTH_SHORT).show()
            },
            shape = RoundedCornerShape(14.dp),
            color = bg,
            border = BorderStroke(
              width = if (isSelected) 2.dp else 1.dp,
              color = if (isSelected) MaterialTheme.colorScheme.primary else Color(0xFFCBD5E1)
            ),
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 12.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                Text(mode.iconEmoji, fontSize = 20.sp)
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                  Text(
                    text = mode.titleSinhala,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = textColor
                  )
                  Text(
                    text = mode.subtitle,
                    fontSize = 10.sp,
                    color = textColor.copy(alpha = 0.75f)
                  )
                }
              }

              if (isSelected) {
                Icon(
                  imageVector = Icons.Default.CheckCircle,
                  contentDescription = "Selected",
                  tint = if (mode == EyeCareThemeMode.DARK) Color(0xFF38BDF8) else MaterialTheme.colorScheme.primary,
                  modifier = Modifier.size(22.dp)
                )
              }
            }
          }
        }
      }

      HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

      // 2. Font Scaling
      Text(
        text = "2. අකුරු ප්‍රමාණය (Text & Zoom Scale): ${(currentFontScale * 100).toInt()}%",
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
        color = MaterialTheme.colorScheme.primary
      )

      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        IconButton(
          onClick = {
            val newScale = (currentFontScale - 0.15f).coerceAtLeast(0.85f)
            onFontScaleChanged(newScale)
            saveFontScale(context, newScale)
          },
          modifier = Modifier
            .size(38.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
          Text("A-", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }

        Slider(
          value = currentFontScale,
          onValueChange = { scale ->
            onFontScaleChanged(scale)
            saveFontScale(context, scale)
          },
          valueRange = 0.85f..1.45f,
          steps = 3,
          modifier = Modifier.weight(1f)
        )

        IconButton(
          onClick = {
            val newScale = (currentFontScale + 0.15f).coerceAtMost(1.45f)
            onFontScaleChanged(newScale)
            saveFontScale(context, newScale)
          },
          modifier = Modifier
            .size(38.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
          Text("A+", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
      }

      // Live Text Preview Card
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
          containerColor = when (currentMode) {
            EyeCareThemeMode.LIGHT -> Color(0xFFF1F5F9)
            EyeCareThemeMode.SEPIA -> Color(0xFFF5EACF)
            EyeCareThemeMode.DARK -> Color(0xFF1E293B)
            EyeCareThemeMode.BLUE_LIGHT_SHIELD -> Color(0xFF1C273E)
          }
        ),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Text(
            text = "👀 සජීවී පූර්වදර්ශනය (Live Preview):",
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "අධ්‍යයන කරුණු පහසුවෙන් මතක තබාගැනීමට සහ දෑස් වෙහෙසට පත් නොවී දීර්ඝ වේලාවක් පාඩම් කිරීමට මෙම සැකසුම් උපකාරී වේ.",
            fontSize = (12.sp.value * currentFontScale).sp,
            lineHeight = (18.sp.value * currentFontScale * currentLineSpacing).sp,
            color = when (currentMode) {
              EyeCareThemeMode.LIGHT -> Color(0xFF0F172A)
              EyeCareThemeMode.SEPIA -> Color(0xFF2C2214)
              EyeCareThemeMode.DARK -> Color(0xFFF1F5F9)
              EyeCareThemeMode.BLUE_LIGHT_SHIELD -> Color(0xFFFDF0D5)
            }
          )
        }
      }

      HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

      // 3. 20-20-20 Eye Break Reminder
      Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
        ),
        modifier = Modifier.fillMaxWidth()
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
            Text("👁️", fontSize = 22.sp)
            Spacer(modifier = Modifier.width(10.dp))
            Column {
              Text(
                text = "20-20-20 ඇස් විවේක මතක් කිරීම",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = MaterialTheme.colorScheme.onSurface
              )
              Text(
                text = "මිනිත්තු 20 කට වරක් තත්පර 20ක් අඩි 20ක් ඈත බැලීමට උපදෙස් දෙයි.",
                fontSize = 10.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
              )
            }
          }

          Switch(
            checked = isEyeBreakEnabled,
            onCheckedChange = { checked ->
              onEyeBreakToggle(checked)
              saveEyeBreakEnabled(context, checked)
              Toast.makeText(
                context,
                if (checked) "20-20-20 ඇස් විවේක මතක් කිරීම සක්‍රිය විය!" else "මතක් කිරීම අක්‍රිය විය",
                Toast.LENGTH_SHORT
              ).show()
            }
          )
        }
      }

      // Done Button
      Button(
        onClick = onDismiss,
        modifier = Modifier
          .fillMaxWidth()
          .height(48.dp),
        shape = RoundedCornerShape(12.dp)
      ) {
        Icon(imageVector = Icons.Default.Check, contentDescription = null)
        Spacer(modifier = Modifier.width(8.dp))
        Text("සැකසුම් සුරකින්න (Apply Settings)", fontWeight = FontWeight.Bold)
      }
    }
  }
}

/**
 * EYE-CARE QUICK TOGGLE COMPONENT FOR HEADER / TOOLBARS
 */
@Composable
fun EyeCareQuickTogglePill(
  currentMode: EyeCareThemeMode,
  onClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Surface(
    onClick = onClick,
    shape = RoundedCornerShape(20.dp),
    color = when (currentMode) {
      EyeCareThemeMode.LIGHT -> Color(0xFFEFF6FF)
      EyeCareThemeMode.SEPIA -> Color(0xFFF5EACF)
      EyeCareThemeMode.DARK -> Color(0xFF1E293B)
      EyeCareThemeMode.BLUE_LIGHT_SHIELD -> Color(0xFF1C273E)
    },
    border = BorderStroke(
      1.dp,
      when (currentMode) {
        EyeCareThemeMode.LIGHT -> Color(0xFFBFDBFE)
        EyeCareThemeMode.SEPIA -> Color(0xFFD6C4A5)
        EyeCareThemeMode.DARK -> Color(0xFF475569)
        EyeCareThemeMode.BLUE_LIGHT_SHIELD -> Color(0xFFF59E0B)
      }
    ),
    modifier = modifier.testTag("eyecare_quick_toggle_pill")
  ) {
    Row(
      modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(currentMode.iconEmoji, fontSize = 14.sp)
      Spacer(modifier = Modifier.width(4.dp))
      Text(
        text = when (currentMode) {
          EyeCareThemeMode.LIGHT -> "දිවා"
          EyeCareThemeMode.SEPIA -> "සේපියා"
          EyeCareThemeMode.DARK -> "රාත්‍රී"
          EyeCareThemeMode.BLUE_LIGHT_SHIELD -> "Eye-Care"
        },
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        color = when (currentMode) {
          EyeCareThemeMode.LIGHT -> Color(0xFF1D4ED8)
          EyeCareThemeMode.SEPIA -> Color(0xFF8D5B00)
          EyeCareThemeMode.DARK -> Color(0xFF38BDF8)
          EyeCareThemeMode.BLUE_LIGHT_SHIELD -> Color(0xFFF59E0B)
        }
      )
    }
  }
}

/**
 * FULL SCREEN DEDICATED EYE-CARE & NIGHT STUDY HUB
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EyeCareNightStudyScreen(
  currentMode: EyeCareThemeMode,
  currentFontScale: Float,
  currentLineSpacing: Float,
  isEyeBreakEnabled: Boolean,
  onModeChanged: (EyeCareThemeMode) -> Unit,
  onFontScaleChanged: (Float) -> Unit,
  onLineSpacingChanged: (Float) -> Unit,
  onEyeBreakToggle: (Boolean) -> Unit,
  onBack: () -> Unit
) {
  val context = LocalContext.current
  val audioPlayer = remember { AmbientStudyAudioPlayer() }
  var activeSoundType by remember { mutableStateOf<String?>(null) }

  DisposableEffect(Unit) {
    onDispose {
      audioPlayer.stopSound()
    }
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = "🌙 Eye-Care & Night Study Hub",
              fontWeight = FontWeight.Bold,
              fontSize = 16.sp
            )
            Text(
              text = "සුවපහසු රාත්‍රී අධ්‍යයන හා ඇස් ආරක්ෂණ මාදිලිය",
              fontSize = 11.sp,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
          }
        },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = "Back"
            )
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = MaterialTheme.colorScheme.surface
        )
      )
    }
  ) { innerPadding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
        .padding(horizontal = 16.dp)
        .verticalScroll(rememberScrollState()),
      verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      Spacer(modifier = Modifier.height(4.dp))

      // Hero Banner
      Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = Modifier
          .fillMaxWidth()
          .clip(RoundedCornerShape(18.dp))
          .background(
            Brush.linearGradient(
              colors = when (currentMode) {
                EyeCareThemeMode.LIGHT -> listOf(Color(0xFF1E3A8A), Color(0xFF2563EB), Color(0xFF38BDF8))
                EyeCareThemeMode.SEPIA -> listOf(Color(0xFF451A03), Color(0xFF78350F), Color(0xFFB45309))
                EyeCareThemeMode.DARK -> listOf(Color(0xFF020617), Color(0xFF0F172A), Color(0xFF1E293B))
                EyeCareThemeMode.BLUE_LIGHT_SHIELD -> listOf(Color(0xFF0A1128), Color(0xFF1C2541), Color(0xFF3A506B))
              }
            )
          )
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text("🌙", fontSize = 28.sp)
            Spacer(modifier = Modifier.width(10.dp))
            Column {
              Text(
                text = "රාත්‍රී අධ්‍යයන දෑස් සුරැකුම",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 17.sp,
                color = Color.White
              )
              Text(
                text = "Night Reading • Warm Sepia • Anti-Glare",
                fontSize = 11.sp,
                color = Color(0xFFE2E8F0)
              )
            }
          }
          Spacer(modifier = Modifier.height(10.dp))
          Text(
            text = "රාත්‍රී කාලයේදී ජංගම දුරකථන තිරයෙන් නිකුත්වන අධික නිල් ආලෝකය (Blue Light) පාලනය කර, දෑස් වියළීම හා හිසරදය වළක්වාගෙන වඩාත් සුවපහසුවෙන් පාඩම් කරන්න.",
            fontSize = 12.sp,
            color = Color(0xFFCBD5E1),
            lineHeight = 17.sp
          )
        }
      }

      // Theme Selection Section
      Text(
        text = "🎨 තිරයේ වර්ණ මාදිලිය තෝරන්න (Canvas Theme)",
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = MaterialTheme.colorScheme.primary
      )

      Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        EyeCareThemeMode.values().forEach { mode ->
          val isSelected = currentMode == mode
          val bg = when (mode) {
            EyeCareThemeMode.LIGHT -> Color(0xFFFFFFFF)
            EyeCareThemeMode.SEPIA -> Color(0xFFFDF6E2)
            EyeCareThemeMode.DARK -> Color(0xFF0F172A)
            EyeCareThemeMode.BLUE_LIGHT_SHIELD -> Color(0xFF131B2E)
          }
          val textColor = when (mode) {
            EyeCareThemeMode.LIGHT -> Color(0xFF0F172A)
            EyeCareThemeMode.SEPIA -> Color(0xFF2C2214)
            EyeCareThemeMode.DARK -> Color(0xFFF1F5F9)
            EyeCareThemeMode.BLUE_LIGHT_SHIELD -> Color(0xFFFDF0D5)
          }

          Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = bg),
            border = BorderStroke(
              width = if (isSelected) 2.5.dp else 1.dp,
              color = if (isSelected) MaterialTheme.colorScheme.primary else Color(0xFFCBD5E1)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = if (isSelected) 4.dp else 1.dp),
            modifier = Modifier
              .fillMaxWidth()
              .clickable {
                onModeChanged(mode)
                saveEyeCareTheme(context, mode)
                Toast.makeText(context, "${mode.titleSinhala} ක්‍රියාත්මකයි!", Toast.LENGTH_SHORT).show()
              }
          ) {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                Text(mode.iconEmoji, fontSize = 26.sp)
                Spacer(modifier = Modifier.width(14.dp))
                Column {
                  Text(
                    text = mode.titleSinhala,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = textColor
                  )
                  Text(
                    text = mode.subtitle,
                    fontSize = 11.sp,
                    color = textColor.copy(alpha = 0.75f)
                  )
                }
              }

              if (isSelected) {
                Surface(
                  shape = CircleShape,
                  color = MaterialTheme.colorScheme.primary,
                  modifier = Modifier.size(26.dp)
                ) {
                  Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Active",
                    tint = Color.White,
                    modifier = Modifier.padding(4.dp)
                  )
                }
              }
            }
          }
        }
      }

      // Font & Spacing Adjuster
      Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
          Text(
            text = "🔍 කියවීමේ අකුරු ප්‍රමාණය (Font Zoom): ${(currentFontScale * 100).toInt()}%",
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            color = MaterialTheme.colorScheme.primary
          )

          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            IconButton(
              onClick = {
                val newScale = (currentFontScale - 0.15f).coerceAtLeast(0.85f)
                onFontScaleChanged(newScale)
                saveFontScale(context, newScale)
              },
              modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface)
            ) {
              Text("A-", fontWeight = FontWeight.Bold, fontSize = 14.sp)
            }

            Slider(
              value = currentFontScale,
              onValueChange = { scale ->
                onFontScaleChanged(scale)
                saveFontScale(context, scale)
              },
              valueRange = 0.85f..1.45f,
              steps = 3,
              modifier = Modifier.weight(1f)
            )

            IconButton(
              onClick = {
                val newScale = (currentFontScale + 0.15f).coerceAtMost(1.45f)
                onFontScaleChanged(newScale)
                saveFontScale(context, newScale)
              },
              modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface)
            ) {
              Text("A+", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
          }

          // Sample Box
          Card(
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
              containerColor = when (currentMode) {
                EyeCareThemeMode.LIGHT -> Color.White
                EyeCareThemeMode.SEPIA -> Color(0xFFFDF6E2)
                EyeCareThemeMode.DARK -> Color(0xFF0F172A)
                EyeCareThemeMode.BLUE_LIGHT_SHIELD -> Color(0xFF131B2E)
              }
            ),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(12.dp)) {
              Text(
                text = "නියැදි පෙළ (Sample Study Paragraph):",
                fontWeight = FontWeight.Bold,
                fontSize = 11.sp,
                color = MaterialTheme.colorScheme.primary
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "ඉතිහාසය, විද්‍යාව සහ ගණිතය කෙටි සටහන් කියවීමේදී අකුරු ප්‍රමාණය හා තිරයේ වර්ණය දෑසට පහසු ලෙස මෙසේ වෙනස් කරගත හැක.",
                fontSize = (13.sp.value * currentFontScale).sp,
                lineHeight = (19.sp.value * currentFontScale * currentLineSpacing).sp,
                color = when (currentMode) {
                  EyeCareThemeMode.LIGHT -> Color(0xFF0F172A)
                  EyeCareThemeMode.SEPIA -> Color(0xFF2C2214)
                  EyeCareThemeMode.DARK -> Color(0xFFF1F5F9)
                  EyeCareThemeMode.BLUE_LIGHT_SHIELD -> Color(0xFFFDF0D5)
                }
              )
            }
          }
        }
      }

      // Ambient Study Audio Player for Night Focus
      Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text("🎧", fontSize = 20.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Column {
              Text(
                text = "රාත්‍රී ඒකාග්‍රතා ශබ්ද (Night Study Ambient Sounds)",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = MaterialTheme.colorScheme.onSurface
              )
              Text(
                text = "බාහිර බාධා අවම කර මනස ඒකාග්‍ර කරන මෘදු ශබ්ද",
                fontSize = 10.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
              )
            }
          }

          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            // Rain
            val isRain = activeSoundType == "RAIN"
            Button(
              onClick = {
                if (isRain) {
                  activeSoundType = null
                  audioPlayer.stopSound()
                } else {
                  activeSoundType = "RAIN"
                  audioPlayer.playSound("RAIN")
                  Toast.makeText(context, "🌧️ මෘදු වැසි ශබ්දය ආරම්භ විය", Toast.LENGTH_SHORT).show()
                }
              },
              colors = ButtonDefaults.buttonColors(
                containerColor = if (isRain) Color(0xFF2563EB) else MaterialTheme.colorScheme.surface
              ),
              modifier = Modifier.weight(1f)
            ) {
              Text(
                text = if (isRain) "🌧️ වැස්ස (Play)" else "🌧️ මෘදු වැසි",
                fontSize = 11.sp,
                color = if (isRain) Color.White else MaterialTheme.colorScheme.onSurface
              )
            }

            // White Noise
            val isWhite = activeSoundType == "WHITE"
            Button(
              onClick = {
                if (isWhite) {
                  activeSoundType = null
                  audioPlayer.stopSound()
                } else {
                  activeSoundType = "WHITE"
                  audioPlayer.playSound("WHITE")
                  Toast.makeText(context, "🎧 White Noise ආරම්භ විය", Toast.LENGTH_SHORT).show()
                }
              },
              colors = ButtonDefaults.buttonColors(
                containerColor = if (isWhite) Color(0xFF7C3AED) else MaterialTheme.colorScheme.surface
              ),
              modifier = Modifier.weight(1f)
            ) {
              Text(
                text = if (isWhite) "🎧 Noise (Play)" else "🎧 White Noise",
                fontSize = 11.sp,
                color = if (isWhite) Color.White else MaterialTheme.colorScheme.onSurface
              )
            }
          }
        }
      }

      // Eye Care Scientific Tips
      Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
          Text(
            text = "💡 දෑස් සුරැකීමට වෛද්‍ය උපදෙස් (Optometry Tips)",
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            color = MaterialTheme.colorScheme.primary
          )
          Text(
            text = "1. 20-20-20 නීතිය: මිනිත්තු 20කට වරක් තත්පර 20ක් ඈත බලා දෑස් විවේකීව තබන්න.\n2. රාත්‍රියේදී Warm Sepia හෝ Dark Mode භාවිතා කරන්න.\n3. කාමරයේ විදුලි බුබුල නිවා සම්පූර්ණ අඳුරේ දුරකථනය පමණක් බැලීමෙන් වළකින්න.\n4. පාඩම් කරන අතරතුර නිතර ඇසිපිය හෙළීමට (Blink) මතක තබාගන්න.",
            fontSize = 11.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            lineHeight = 18.sp
          )
        }
      }

      Spacer(modifier = Modifier.height(24.dp))
    }
  }
}
