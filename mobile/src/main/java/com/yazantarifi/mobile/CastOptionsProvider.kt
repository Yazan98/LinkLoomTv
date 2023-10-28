package com.yazantarifi.mobile

import android.content.Context
import com.google.android.gms.cast.LaunchOptions
import com.google.android.gms.cast.framework.CastOptions
import com.google.android.gms.cast.framework.OptionsProvider
import com.google.android.gms.cast.framework.SessionProvider

class CastOptionsProvider : OptionsProvider {
    override fun getCastOptions(context: Context): CastOptions {
        val options = LaunchOptions.Builder()
            .setAndroidReceiverCompatible(true)
            .build()

        return CastOptions.Builder()
            .setReceiverApplicationId("07EB8A95")
            .setLaunchOptions(options)
            .build()
    }

    override fun getAdditionalSessionProviders(context: Context): List<SessionProvider>? {
        return null
    }
}