package com.yazantarifi.linkloom.tv

import android.app.Application
import android.content.Context
import android.os.Bundle
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.yazantarifi.linkloom.tv.models.database.ApplicationAccountEntity
import com.yazantarifi.linkloom.tv.models.database.LinkHistoryEntity
import com.yazantarifi.linkloom.tv.utils.ApplicationCrashReporter
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.annotations.RealmModule
import timber.log.Timber

class LinkLoomApplication: Application() {

    var currentProfile: String = ""

    companion object {
        fun onAppLog(message: String) {
            Timber.d("[LinkLoom Debug][$message]")
        }

        fun onSendScreenViewEvent(screenName: String, context: Context) {
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, Bundle().apply {
                putString("Screen", screenName)
            })
        }

        fun onSendEvent(event: String, context: Context) {
            FirebaseAnalytics.getInstance(context).logEvent(event, Bundle().apply {
                putString("Event", event)
            })
        }
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ApplicationCrashReporter())
        }

        Realm.init(this)
        Realm.setDefaultConfiguration(
            RealmConfiguration.Builder()
                .allowWritesOnUiThread(false)
                .allowQueriesOnUiThread(false)
                .deleteRealmIfMigrationNeeded()
                .name("link_loom.realm")
                .schemaVersion(1)
                .modules(ApplicationDatabaseModules())
                .build()
        )

        FirebaseApp.initializeApp(this)
        FirebaseAnalytics.getInstance(this).setAnalyticsCollectionEnabled(true)
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
        FirebaseCrashlytics.getInstance().checkForUnsentReports().addOnCompleteListener {
            onAppLog("Firebase Unsent Crashes Status: ${it.isSuccessful}")
        }

        FirebaseAnalytics.getInstance(this).logEvent(FirebaseAnalytics.Event.APP_OPEN, null)
    }

    @RealmModule(library = true, classes = [LinkHistoryEntity::class, ApplicationAccountEntity::class])
    class ApplicationDatabaseModules

}
