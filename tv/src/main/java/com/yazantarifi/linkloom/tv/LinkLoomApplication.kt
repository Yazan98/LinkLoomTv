package com.yazantarifi.linkloom.tv

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import com.google.android.gms.cast.tv.CastReceiverContext
import com.google.android.gms.cast.tv.SenderDisconnectedEventInfo
import com.google.android.gms.cast.tv.SenderInfo
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
        CastReceiverContext.initInstance(this)
        ProcessLifecycleOwner.get().lifecycle.addObserver(AppLifecycleObserver())
        CastReceiverContext.getInstance().registerEventCallback(EventCallback())

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

    class AppLifecycleObserver : DefaultLifecycleObserver {
        override fun onResume(owner: LifecycleOwner) {
            CastReceiverContext.getInstance().start()
        }

        override fun onPause(owner: LifecycleOwner) {
            CastReceiverContext.getInstance().stop()
        }
    }

    private inner class EventCallback : CastReceiverContext.EventCallback() {
        override fun onSenderConnected(senderInfo: SenderInfo) {
            Toast.makeText(
                this@LinkLoomApplication,
                "Sender connected " + senderInfo.senderId,
                Toast.LENGTH_LONG)
                .show()
        }

        override fun onSenderDisconnected(eventInfo: SenderDisconnectedEventInfo) {
            Toast.makeText(
                this@LinkLoomApplication,
                "Sender disconnected " + eventInfo.senderInfo.senderId,
                Toast.LENGTH_LONG)
                .show()
        }
    }

    @RealmModule(library = true, classes = [LinkHistoryEntity::class, ApplicationAccountEntity::class])
    class ApplicationDatabaseModules

}
