package com.example

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Screen dimension and form factor detector to dynamically adapt UI,
 * typography, padding, and layout for small, normal, and large devices.
 */
data class ScreenDimensions(
  val widthDp: Int,
  val heightDp: Int,
  val isSmallWidth: Boolean,    // < 360dp (Small phones like older Galaxy J, compact models)
  val isMediumWidth: Boolean,   // 360dp - 599dp (Standard modern smartphones)
  val isExpandedWidth: Boolean, // >= 600dp (Foldables unfolded, Tablets)
  val isShortHeight: Boolean    // < 680dp (Small/short screen height)
) {
  // Adaptive font sizing helper
  fun adaptiveSp(normalSp: Float, compactFactor: Float = 0.88f): TextUnit {
    return if (isSmallWidth || isShortHeight) (normalSp * compactFactor).sp else normalSp.sp
  }

  // Adaptive dp sizing helper
  fun adaptiveDp(normalDp: Float, compactFactor: Float = 0.85f): Dp {
    return if (isSmallWidth || isShortHeight) (normalDp * compactFactor).dp else normalDp.dp
  }
}

@Composable
fun rememberScreenDimensions(): ScreenDimensions {
  val config = LocalConfiguration.current
  val w = config.screenWidthDp
  val h = config.screenHeightDp
  return ScreenDimensions(
    widthDp = w,
    heightDp = h,
    isSmallWidth = w < 360,
    isMediumWidth = w in 360..599,
    isExpandedWidth = w >= 600,
    isShortHeight = h < 680
  )
}
