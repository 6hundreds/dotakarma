package com.smedialink.tokenplussteamid.data.manager

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class SessionManager @Inject constructor(private val preferences: SharedPrefsManager) {

    private val subject = PublishSubject.create<Int>()

    companion object {
        private const val ACCESS_TOKEN_KEY = "access_token"
    }

    fun openSession(token: String) {
        preferences
                .putString(ACCESS_TOKEN_KEY, token)
                .also { subject.onNext(State.OPENED) }
    }

    fun getAccessToken(): String = preferences.getString(ACCESS_TOKEN_KEY)

    fun isSessionOpened(): Boolean = getAccessToken().isNotEmpty()

    fun getSessionState(): Observable<Int> = subject

    object State {
        const val OPENED = 0
        const val CLOSED = 1
    }
}
