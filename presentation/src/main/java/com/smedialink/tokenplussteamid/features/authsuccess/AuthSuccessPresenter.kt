package com.smedialink.tokenplussteamid.features.authsuccess

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.data.manager.SessionManager
import com.smedialink.tokenplussteamid.di.qualifier.LocalNavigation
import com.smedialink.tokenplussteamid.features.AppScreens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class AuthSuccessPresenter @Inject constructor(private val sessionManager: SessionManager)
    : BasePresenter<AuthSuccessView>() {

    fun saveToken(token: String) {
        sessionManager.openSession(token)
    }
}
