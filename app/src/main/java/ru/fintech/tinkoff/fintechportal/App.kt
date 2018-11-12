package ru.fintech.tinkoff.fintechportal

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.init(this)
    }
}