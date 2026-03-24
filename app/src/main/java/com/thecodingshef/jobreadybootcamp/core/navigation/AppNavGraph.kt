package com.thecodingshef.jobreadybootcamp.core.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavHostController // extends NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thecodingshef.jobreadybootcamp.core.ui.components.splash.SplashScreen
import com.thecodingshef.jobreadybootcamp.core.ui.components.splash.SplashViewModel
import com.thecodingshef.jobreadybootcamp.MainAppScreen
import com.thecodingshef.jobreadybootcamp.HomeViewModel
import com.thecodingshef.jobreadybootcamp.feature.explore.presentation.ExploreScreen
import com.thecodingshef.jobreadybootcamp.feature.home.presentation.HomeScreen
import com.thecodingshef.jobreadybootcamp.feature.saved.presentation.SavedScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Route.Splash.path
    ) {

        composable(Route.Splash.path) {
            SplashScreen(
                onNavigateToMain = {
                    navController.navigate(Route.Main.path) {
                        popUpTo(Route.Splash.path) {
                            inclusive = true
                        }
                    }
                },
                // Singleton instance of our SplashViewModel into our SplashScreen
                viewModel = viewModel(
                    factory = viewModelFactory {
                        initializer { SplashViewModel() }
                    }
                )
            )
        }

        composable(Route.Main.path) {
            MainAppScreen(
                viewModel = viewModel(
                    factory = viewModelFactory {
                        initializer { HomeViewModel() }
                    }
                )
            )
        }

        composable(Route.Home.path) {
            HomeScreen(innerPadding = PaddingValues())
        }
        composable(Route.Explore.path) {
            ExploreScreen(innerPadding = PaddingValues())
        }
        composable(Route.Saved.path) {
            SavedScreen(innerPadding = PaddingValues())
        }
    }
}