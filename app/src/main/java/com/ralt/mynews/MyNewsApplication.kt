package com.ralt.mynews

import android.app.Application
import com.ralt.mynews.di.AppModule

class MyNewsApplication : Application() {
    lateinit var appModule: AppModule

    override fun onCreate() {
        super.onCreate()
        appModule = AppModule(this)
    }
}
