package com.smedialink.tokenplussteamid.features.authsuccess

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.data.manager.SettingsManager
import javax.inject.Inject

@InjectViewState
class AuthSuccessPresenter @Inject constructor(
        private val settingsManager: SettingsManager
) : BasePresenter<AuthSuccessView>() {

    fun saveToken(token: String) {
        settingsManager.saveToken(token)
    }
}
