package com.github.hepb.simpleapp

import android.app.Application
import com.github.ajalt.timberkt.Timber

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}