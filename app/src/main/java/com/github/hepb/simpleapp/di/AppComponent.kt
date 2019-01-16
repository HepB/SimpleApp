package com.github.hepb.simpleapp.di

import android.content.Context
import com.github.hepb.simpleapp.contract.model.ItemRepo
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun appContext(): Context
    fun repo(): ItemRepo
}