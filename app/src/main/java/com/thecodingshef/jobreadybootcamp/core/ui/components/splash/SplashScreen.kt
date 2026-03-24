package com.thecodingshef.jobreadybootcamp.core.ui.components.splash

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SplashScreen(
    onNavigateToMain: () -> Unit,
    viewModel: SplashViewModel
) {

    val destination: SplashDestination by viewModel.destination.collectAsStateWithLifecycle()

    var startAnimation: Boolean by remember { mutableStateOf(false) }

    // Animates the logo from center towards its final position (moving it up)
    val animatedOffset: Dp by animateDpAsState(
        targetValue = if (startAnimation) 0.dp else 70.dp,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
        label = "Logo Offset Animation"
    )

    val textToAnimate: String = "Quote App"

    // Animates the character index from 0 to the full length of the string
    val animatedIndex: Int by animateIntAsState(
        targetValue = if (startAnimation) textToAnimate.length else 0,
        animationSpec = tween(
            durationMillis = textToAnimate.length * 100,
            delayMillis = 300,
            easing = LinearEasing
        ),
        label = "Character Index Animation"
    )

    // Trigger animation on launch
    LaunchedEffect(Unit) {
        startAnimation = true
    }

    LaunchedEffect(destination) {
        when (destination) {
            is SplashDestination.Main -> onNavigateToMain()
            is SplashDestination.Loading -> { /* Still Loading */ }
        }
    }
}