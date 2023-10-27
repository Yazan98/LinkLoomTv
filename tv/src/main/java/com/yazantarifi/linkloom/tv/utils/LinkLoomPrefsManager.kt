package com.yazantarifi.linkloom.tv.utils

import android.content.Context
import android.content.SharedPreferences

object LinkLoomPrefsManager {

    private const val APP_STORAGE = "link_loom_prefs"

    const val IS_FIRST_RUN_APP = "isFirstRunApp"

    fun onSaveBooleanPrefs(context: Context, key: String, value: Boolean) {
        val prefs = getAppPrefsInstance(context)
        prefs.edit().putBoolean(key, value).apply()
    }

    fun onSaveStringPrefs(context: Context, key: String, value: String) {
        val prefs = getAppPrefsInstance(context)
        prefs.edit().putString(key, value).apply()
    }

    fun getBooleanValue(context: Context, key: String): Boolean {
        val prefs = getAppPrefsInstance(context)
        return prefs.getBoolean(key, false)
    }

    fun getStringValue(context: Context, key: String): String {
        val prefs = getAppPrefsInstance(context)
        return prefs.getString(key, "") ?: ""
    }

    private fun getAppPrefsInstance(context: Context): SharedPreferences {
        return context.getSharedPreferences(APP_STORAGE, Context.MODE_PRIVATE)
    }
}