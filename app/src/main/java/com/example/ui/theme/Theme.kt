package com.example.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF2563EB),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFDBEAFE),
    onPrimaryContainer = Color(0xFF1E3A8A),
    secondary = Color(0xFF10B981),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFD1FAE5),
    onSecondaryContainer = Color(0xFF064E3B),
    tertiary = Color(0xFFF59E0B),
    background = Color(0xFFF8FAFC),
    onBackground = Color(0xFF0F172A),
    surface = Color.White,
    onSurface = Color(0xFF0F172A),
    surfaceVariant = Color(0xFFF1F5F9),
    onSurfaceVariant = Color(0xFF475569)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF60A5FA),
    onPrimary = Color(0xFF0F172A),
    primaryContainer = Color(0xFF1E3A8A),
    onPrimaryContainer = Color(0xFFDBEAFE),
    secondary = Color(0xFF34D399),
    onSecondary = Color(0xFF064E3B),
    background = Color(0xFF0F172A),
    onBackground = Color(0xFFF8FAFC),
    surface = Color(0xFF1E293B),
    onSurface = Color(0xFFF8FAFC),
    surfaceVariant = Color(0xFF334155),
    onSurfaceVariant = Color(0xFF94A3B8)
)

@Composable
fun EduGuraTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}

enum class EyeCareThemeMode {
    LIGHT, SEPIA, DARK, BLUE_LIGHT_SHIELD
}

@Composable
fun MyApplicationTheme(
    eyeCareMode: EyeCareThemeMode = EyeCareThemeMode.LIGHT,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    EduGuraTheme(darkTheme = darkTheme, content = content)
}

val EyeCareThemeMode.titleSinhala: String
    get() = when (this) {
        EyeCareThemeMode.LIGHT -> "දිවා ප්‍රකාරය (Light)"
        EyeCareThemeMode.SEPIA -> "සේපියා (Sepia)"
        EyeCareThemeMode.DARK -> "රාත්‍රී ප්‍රකාරය (Dark)"
        EyeCareThemeMode.BLUE_LIGHT_SHIELD -> "අක්ෂි ආරක්ෂක (Blue Light Shield)"
    }

val EyeCareThemeMode.iconEmoji: String
    get() = when (this) {
        EyeCareThemeMode.LIGHT -> "☀️"
        EyeCareThemeMode.SEPIA -> "📜"
        EyeCareThemeMode.DARK -> "🌙"
        EyeCareThemeMode.BLUE_LIGHT_SHIELD -> "🛡️"
    }

val EyeCareThemeMode.subtitle: String
    get() = when (this) {
        EyeCareThemeMode.LIGHT -> "සාමාන්‍ය දිවා කියවීම"
        EyeCareThemeMode.SEPIA -> "ඇස් වලට සුවපහසු කහ පැහැති පසුබිම"
        EyeCareThemeMode.DARK -> "අඳුරු පසුබිම, බැටරි ඉතිරි කරයි"
        EyeCareThemeMode.BLUE_LIGHT_SHIELD -> "නිල් එළිය අවම කර නින්ද ආරක්ෂා කරයි"
    }
