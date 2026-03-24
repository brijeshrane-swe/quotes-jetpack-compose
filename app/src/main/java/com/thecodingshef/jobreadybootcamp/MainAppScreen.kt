package com.thecodingshef.jobreadybootcamp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.thecodingshef.jobreadybootcamp.core.navigation.Destination
import com.thecodingshef.jobreadybootcamp.core.ui.theme.PrimaryDark
import com.thecodingshef.jobreadybootcamp.feature.explore.presentation.ExploreScreen
import com.thecodingshef.jobreadybootcamp.feature.home.presentation.HomeScreen
import com.thecodingshef.jobreadybootcamp.feature.saved.presentation.SavedScreen

@Composable
fun MainAppScreen(viewModel: HomeViewModel) {
    var selectedDestination by rememberSaveable { mutableIntStateOf(Destination.entries.first().ordinal) }

    return Scaffold(
        bottomBar = {
            NavigationBar(
                windowInsets = NavigationBarDefaults.windowInsets,
                contentColor = PrimaryDark,
                content = {

                    Destination.entries.forEachIndexed { index, destination ->
                        NavigationBarItem(
                            selected = selectedDestination == index,
                            onClick = {
                                // navController.navigate(route = destination.route)
                                selectedDestination = index
                            },
                            label = { Text(text = destination.label) },
                            icon = {
                                Icon(
                                    imageVector = destination.icon,
                                    contentDescription = destination.contentDescription
                                )
                            }
                        )
                    }
                }
            )
        }
    ) { innerPadding: PaddingValues ->
        when (selectedDestination) {
            Destination.HOME.ordinal -> {
                HomeScreen(innerPadding)
            }
            Destination.EXPLORE.ordinal -> {
                ExploreScreen(innerPadding)
            }
            Destination.SAVED.ordinal -> {
                SavedScreen(innerPadding)
            }
            else -> {
                Box(
                    modifier = Modifier.fillMaxSize().padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "No Screen Found!")
                }
            }
        }
    }
}