package com.thecodingshef.jobreadybootcamp.core.ui.theme

import androidx.compose.ui.graphics.Color

object AppColors {
    // Base Colors
    val Transparent = Color(0x00000000)
    val White = Color(0xFFFFFFFF)
    val Black = Color(0xFF000000)

    // Background Colors
    val LayerOneBg = Color(0x80FFFFFF)
    val LayerTwoBg = Color(0xFFE9FFF6)

    // Primary Brand Colors
    val Primary = Color(0xFF820753)

    val PrimaryLight = Color(0xFF4A6B5D)
    val PrimaryDark = Color(0xFF001A14)

    // Semantic Colors
    val Success = Color(0xFF4CAF50)
    val Error = Color(0xFFF44336)
    val Warning = Color(0xFFFF9800)
    val Info = Color(0xFF2196F3)

    // Text Colors
    val TextPrimary = Color(0xFF212121)
    val TextSecondary = Color(0xFF757575)
    val TextDisabled = Color(0xFFBDBDBD)
}

// Aliases for backward compatibility or existing usage
val PrimaryBlue = AppColors.Primary
val PrimaryDark = AppColors.PrimaryDark
val AccentGreen = AppColors.Success
val ErrorRed = AppColors.Error
val BackgroundLight = AppColors.White
val SurfaceWhite = AppColors.White
val TextPrimary = AppColors.TextPrimary
val TextSecondary = AppColors.TextSecondary