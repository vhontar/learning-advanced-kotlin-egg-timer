package com.example.android.eggtimernotifications

import android.app.Application
import timber.log.Timber

/**
 * Created by Vladyslav Hontar (vhontar) on 08.04.20.
 */
class EggTimerApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}