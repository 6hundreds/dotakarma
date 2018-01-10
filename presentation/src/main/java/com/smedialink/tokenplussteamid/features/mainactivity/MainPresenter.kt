package com.smedialink.tokenplussteamid.features.mainactivity

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.features.MyAppScreens
import com.smedialink.tokenplussteamid.manager.SettingsManager
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
        private val router: Router,
        private val settingsManager: SettingsManager
) : BasePresenter<MainView>() {

    override fun attachView(view: MainView?) {
        super.attachView(view)

        if (settingsManager.isTokenReceived()) {
            if (settingsManager.isSteamIdReceived()) {
                router.navigateTo(MyAppScreens.HOME_SCREEN)
                Timber.d("go to home")
            } else {
                router.navigateTo(MyAppScreens.STEAM_AUTH_SCREEN)
                Timber.d("go to auth")
            }
        } else {
            router.navigateTo(MyAppScreens.REGISTRATION_SCREEN)
            Timber.d("go to registration")
        }
    }
}
