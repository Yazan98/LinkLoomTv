package com.yazantarifi.linkloom.tv.utils

import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

class ApplicationCrashReporter: Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        t?.let {
            FirebaseCrashlytics.getInstance().recordException(it)
        }
    }

}
