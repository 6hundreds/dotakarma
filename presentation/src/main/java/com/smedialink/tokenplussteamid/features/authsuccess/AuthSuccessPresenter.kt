package com.smedialink.tokenplussteamid.features.authsuccess

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.data.manager.SessionManager
import javax.inject.Inject

@InjectViewState
class AuthSuccessPresenter @Inject constructor(private val sessionManager: SessionManager)
    : BasePresenter<AuthSuccessView>() {

    fun saveToken(token: String) {
        sessionManager.openSession(token)
    }
}
