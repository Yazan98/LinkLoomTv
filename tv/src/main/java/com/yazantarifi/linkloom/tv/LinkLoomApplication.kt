package com.yazantarifi.linkloom.tv

import android.app.Application
import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.yazantarifi.linkloom.tv.utils.ApplicationCrashReporter
import timber.log.Timber

class LinkLoomApplication: Application() {

    companion object {
        fun onAppLog(message: String) {
            Timber.d("[LinkLoom Debug][$message]")
        }
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ApplicationCrashReporter())
        }

        FirebaseApp.initializeApp(this)
        FirebaseAnalytics.getInstance(this).setAnalyticsCollectionEnabled(true)
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
        FirebaseCrashlytics.getInstance().checkForUnsentReports().addOnCompleteListener {
            onAppLog("Firebase Unsent Crashes Status: ${it.isSuccessful}")
        }
    }

}
