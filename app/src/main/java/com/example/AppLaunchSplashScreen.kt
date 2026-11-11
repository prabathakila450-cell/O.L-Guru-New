package com.example

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.delay

/**
 * App Launch Screen (මුහුණත) displayed immediately upon opening the app.
 * Displays the exact high-resolution official image clearly with both the logo and Sinhala text.
 * Appears for about 1 second immediately when clicked/opened.
 */
@Composable
fun AppLaunchSplashScreen(
  visible: Boolean,
  onDismiss: () -> Unit
) {
  LaunchedEffect(visible) {
    if (visible) {
      delay(1000)
      onDismiss()
    }
  }

  AnimatedVisibility(
    visible = visible,
    enter = fadeIn(),
    exit = fadeOut()
  ) {
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF071832))
        .testTag("app_launch_splash_screen")
        .clickable(
          interactionSource = remember { MutableInteractionSource() },
          indication = null,
          onClick = onDismiss
        ),
      contentAlignment = Alignment.Center
    ) {
      // High-resolution exact official image with logo and Sinhala text (100% visible, no parts cropped)
      Image(
        painter = painterResource(id = R.drawable.ol_guru_logo),
        contentDescription = "සාමාන්‍ය පෙළ ඉලක්කය O/L Guru",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Fit
      )
    }
  }
}

