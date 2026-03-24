package com.thecodingshef.jobreadybootcamp.core.ui

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class AppDimensions(
    val isTablet: Boolean,
    val noPadding: Dp,
    val cardPadding: Dp,
    val cardElevation: Dp,
    val bodyFontSize: TextUnit,
    val headerFontSize: TextUnit,
    val buttonHeight: Dp,
    val iconSizeSmall: Dp,
    val iconSizeMedium: Dp,
    val iconSizeLarge: Dp,
    val inputPadding: Dp,
    val listItemHeight: Dp,
    val fixedListHeight: Dp,
    val screenPadding: Dp
)

val MobileDimensions = AppDimensions(
    isTablet = false,
    noPadding = 0.dp,
    cardPadding = 16.dp,
    cardElevation = 2.dp,
    bodyFontSize = 14.sp,
    headerFontSize = 18.sp,
    buttonHeight = 48.dp,
    iconSizeSmall = 20.dp,
    iconSizeMedium = 28.dp,
    iconSizeLarge = 40.dp,
    inputPadding = 12.dp,
    listItemHeight = 64.dp,
    fixedListHeight = 200.dp,
    screenPadding = 16.dp
)

val TabletDimensions = AppDimensions(
    isTablet = true,
    noPadding = 0.dp,
    cardPadding = 20.dp,
    cardElevation = 3.dp,
    bodyFontSize = 16.sp,
    headerFontSize = 20.sp,
    buttonHeight = 56.dp,
    iconSizeSmall = 24.dp,
    iconSizeMedium = 32.dp,
    iconSizeLarge = 48.dp,
    inputPadding = 16.dp,
    listItemHeight = 72.dp,
    fixedListHeight = 300.dp,
    screenPadding = 24.dp
)

val LocalAppDimensions = staticCompositionLocalOf { MobileDimensions }

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun rememberAppDimensions(): AppDimensions {
    val configuration = LocalConfiguration.current
    return if (configuration.screenWidthDp >= 768) TabletDimensions else MobileDimensions
}