package com.yazantarifi.linkloom.tv

import android.content.Context
import com.google.android.gms.cast.LaunchOptions
import com.google.android.gms.cast.tv.CastReceiverOptions
import com.google.android.gms.cast.tv.ReceiverOptionsProvider

class MyReceiverOptionsProvider : ReceiverOptionsProvider {
    override fun getOptions(context: Context): CastReceiverOptions {
        return CastReceiverOptions.Builder(context)
            .setStatusText("LinkLoom Cast Connect")
//            .setCastAppId("07EB8A95")
            .build()
    }
}