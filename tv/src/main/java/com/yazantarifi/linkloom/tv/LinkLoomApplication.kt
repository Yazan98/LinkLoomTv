package com.yazantarifi.linkloom.tv

import android.app.Application
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
    }

    @RealmModule(library = true, classes = [LinkHistoryEntity::class, ApplicationAccountEntity::class])
    class ApplicationDatabaseModules

}
