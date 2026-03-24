package com.thecodingshef.jobreadybootcamp.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Route(val path: String) {
    data object Splash : Route("splash")
    data object Main : Route("main")
    data object Home : Route("home")
    data object Explore : Route("explore")
    data object Saved : Route("saved")
}

enum class Destination(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val contentDescription: String
) {
    HOME("home", "Home", Icons.Default.Home, "Home"),
    EXPLORE("explore", "Explore", Icons.Default.Search, "Explore"),
    SAVED("saved", "Saved", Icons.Default.Favorite, "Saved")
}