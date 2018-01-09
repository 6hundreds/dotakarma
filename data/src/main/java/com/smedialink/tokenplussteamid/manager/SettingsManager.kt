package com.smedialink.tokenplussteamid.manager

import android.content.SharedPreferences
import javax.inject.Inject

class SettingsManager @Inject constructor(
        private val preferences: SharedPreferences) {

    companion object {
        private const val PREF_TOKEN_KEY = "pref_token"
        private const val PREF_STEAM_ID_KEY = "pref_steam_id"
    }

    fun saveToken(token: String) {
        preferences.edit().putString(PREF_TOKEN_KEY, token).apply()
    }

    fun getSavedToken(): String = preferences.getString(PREF_TOKEN_KEY, "")

    fun saveSteamId(steamId: String) {
        preferences.edit().putString(PREF_STEAM_ID_KEY, steamId).apply()
    }

    fun getSavedSteamId(): String = preferences.getString(PREF_STEAM_ID_KEY, "")

    fun isTokenReceived(): Boolean = getSavedToken().isNotEmpty()

    fun isSteamUdReceived(): Boolean = getSavedSteamId().isNotEmpty()
}
