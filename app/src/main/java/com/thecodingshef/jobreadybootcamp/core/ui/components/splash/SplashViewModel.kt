package com.thecodingshef.jobreadybootcamp.core.ui.components.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface SplashDestination {
    data object Loading : SplashDestination
    data object Main : SplashDestination
}

class SplashViewModel : ViewModel() {
    private val _destination = MutableStateFlow<SplashDestination>(SplashDestination.Loading)
    val destination: StateFlow<SplashDestination> = _destination.asStateFlow() // read-only stateflow

    init {
        simulateSplashLoading()
    }

    private fun simulateSplashLoading() {
        viewModelScope.launch {
            // Minimum splash duration
            delay(2000)

            _destination.value = SplashDestination.Main
        }
    }

}