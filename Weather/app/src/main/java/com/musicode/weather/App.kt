package com.musicode.weather

import android.app.Application
import android.util.Log
import com.musicode.weather.extension.DelegatesExit

class App : Application() {

    companion object {
        var instance: App by DelegatesExit.NotNullSingleValue<App>()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Log.d("Kotlink", "app create")
    }
}