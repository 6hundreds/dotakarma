package com.smedialink.tokenplussteamid.data.manager

import javax.inject.Inject

class SessionManager @Inject constructor(private val preferences: SharedPrefsManager) {

    companion object {
        private const val ACCESS_TOKEN_KEY = "access_token"
    }

    fun openSession(token: String) = preferences.putString(ACCESS_TOKEN_KEY, token)

    fun getAccessToken(): String = preferences.getString(ACCESS_TOKEN_KEY)

    fun isSessionOpened(): Boolean = getAccessToken().isNotEmpty()
}
