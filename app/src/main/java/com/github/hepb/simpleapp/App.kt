package com.github.hepb.simpleapp

import android.app.Application
import com.github.ajalt.timberkt.Timber
import com.github.hepb.simpleapp.di.AppComponent
import com.github.hepb.simpleapp.di.AppModule
import com.github.hepb.simpleapp.di.DaggerAppComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        component = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        lateinit var component: AppComponent
    }
}