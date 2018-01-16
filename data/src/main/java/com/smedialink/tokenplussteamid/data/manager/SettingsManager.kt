package com.smedialink.tokenplussteamid.data.manager

import android.content.SharedPreferences
import javax.inject.Inject

class SettingsManager @Inject constructor(
        private val preferences: SharedPreferences) {

    companion object {
        private const val PREF_TOKEN_KEY = "pref_token"
    }

    fun saveToken(token: String) {
        preferences.edit().putString(PREF_TOKEN_KEY, token).apply()
    }

    fun getSavedToken(): String = preferences.getString(PREF_TOKEN_KEY, "")

    fun isTokenReceived(): Boolean = getSavedToken().isNotEmpty()

}
