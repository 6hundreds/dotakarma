package com.smedialink.tokenplussteamid.data.manager

import android.content.SharedPreferences
import javax.inject.Inject

class SessionManager @Inject constructor(private val preferences: SharedPreferences) {

    companion object {
        private const val ACCESS_TOKEN_KEY = "pref_token"
    }

    fun openSession(token: String) = preferences.edit().putString(ACCESS_TOKEN_KEY, token).apply()

    fun getAccessToken(): String = preferences.getString(ACCESS_TOKEN_KEY, "")

    fun isSessionOpened(): Boolean = getAccessToken().isNotEmpty()
}
