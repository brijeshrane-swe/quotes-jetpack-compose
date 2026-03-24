package com.thecodingshef.jobreadybootcamp

import android.app.Application
import com.thecodingshef.jobreadybootcamp.core.di.container.AppContainer

class MyApplication : Application() {
    // The single instance of our container
    val container = AppContainer()
}