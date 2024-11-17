package com.picpay

import android.app.Application
import com.picpay.desafio.android.core.di.coreModule
import com.picpay.desafio.android.di.dashboardModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ApplicationApp)
            modules(listOf(coreModule, dashboardModule))
        }
    }
}