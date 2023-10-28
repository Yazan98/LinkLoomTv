package com.yazantarifi.mobile

import android.app.Application
import com.google.android.gms.cast.framework.CastContext
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import java.util.concurrent.Executors

class LinkLoomApplication: Application() {

    var castInstance: CastContext? = null

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
        FirebaseAnalytics.getInstance(this).setAnalyticsCollectionEnabled(true)

        FirebaseAnalytics.getInstance(this).logEvent(FirebaseAnalytics.Event.APP_OPEN, null)
        try {
            CastContext
                .getSharedInstance(this, Executors.newSingleThreadExecutor())
                .addOnSuccessListener { castContext: CastContext? ->
                    println("Chromecast Successful")
                    castInstance = castContext
                }
                .addOnFailureListener { exception: java.lang.Exception? ->
                    println("Chromecast Exception : ${exception?.message}")
                    exception?.let { FirebaseCrashlytics.getInstance().recordException(it) }
                }
        } catch (ex: Exception) {
            FirebaseCrashlytics.getInstance().recordException(ex)
        }
    }
}
