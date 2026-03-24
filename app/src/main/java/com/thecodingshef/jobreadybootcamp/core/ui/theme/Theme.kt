package com.thecodingshef.jobreadybootcamp.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.thecodingshef.jobreadybootcamp.core.ui.AppDimensions
import com.thecodingshef.jobreadybootcamp.core.ui.LocalAppDimensions
import com.thecodingshef.jobreadybootcamp.core.ui.rememberAppDimensions

private val LightColorScheme = lightColorScheme(
    primary = PrimaryBlue,
    onPrimary = SurfaceWhite,
    secondary = AccentGreen,
    error = ErrorRed,
    background = BackgroundLight,
    surface = SurfaceWhite,
    onSurface = TextPrimary,
    onBackground = TextPrimary,
)

@Composable
fun JobReadyBootcampTheme(content: @Composable () -> Unit) {
    val dimensions: AppDimensions = rememberAppDimensions()
    CompositionLocalProvider(LocalAppDimensions provides dimensions) {
        MaterialTheme(
            colorScheme = LightColorScheme,
            typography = Typography,
            content = content
        )
    }
}