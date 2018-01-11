package com.smedialink.tokenplussteamid.features.authorization

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.features.AppScreens
import com.smedialink.tokenplussteamid.manager.SettingsManager
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class AuthPresenter @Inject constructor(
        private val router: Router,
        private val settingsManager: SettingsManager
) : BasePresenter<AuthView>() {

    override fun attachView(view: AuthView?) {
        super.attachView(view)

        if (settingsManager.isTokenReceived()) {
            if (settingsManager.isSteamIdReceived()) {
                // TODO() No authorization needed, return to main screen
            } else {
                router.newRootScreen(AppScreens.STEAM_AUTH_SCREEN)
            }
        } else {
            router.newRootScreen(AppScreens.REGISTRATION_SCREEN)
        }
    }
}
