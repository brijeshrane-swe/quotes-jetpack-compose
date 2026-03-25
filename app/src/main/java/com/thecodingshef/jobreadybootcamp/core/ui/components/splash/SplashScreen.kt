package com.thecodingshef.jobreadybootcamp.core.ui.components.splash

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fitInside
import androidx.compose.foundation.layout.fitOutside
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.RectRulers
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.thecodingshef.jobreadybootcamp.R
import com.thecodingshef.jobreadybootcamp.core.ui.theme.PrimaryBlue
import com.thecodingshef.jobreadybootcamp.core.ui.theme.PrimaryDark
import com.thecodingshef.jobreadybootcamp.core.ui.theme.Transparent

@Composable
fun SplashScreen(
    onNavigateToMain: () -> Unit,
    viewModel: SplashViewModel
) {

    val destination: SplashDestination by viewModel.destination.collectAsStateWithLifecycle()

    var startAnimation: Boolean by remember { mutableStateOf(false) }

    // Animates the logo from center towards its final position (moving it up)
    val animatedOffset: Dp by animateDpAsState(
        targetValue = if (startAnimation) (-70).dp else 0.dp,
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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryDark),
        contentAlignment = Alignment.Center
    ) {
        Column() {
            Box(
                modifier = Modifier
                    .offset(y = animatedOffset)
                    .size(180.dp)
                    .background(color = PrimaryBlue, shape = RoundedCornerShape(50.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(50.dp)),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.play_store_512),
                    contentDescription = "Splash Logo"
                )
            }
        }
    }
}