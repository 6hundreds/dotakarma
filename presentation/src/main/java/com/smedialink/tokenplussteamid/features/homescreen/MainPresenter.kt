package com.smedialink.tokenplussteamid.features.homescreen

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.data.manager.SettingsManager
import com.smedialink.tokenplussteamid.features.AppScreens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
        private val router: Router,
        private val settingsManager: SettingsManager
) : BasePresenter<MainView>() {

    fun onFeedItemClicked() {
        router.replaceScreen(AppScreens.BOTTOM_FEED_SCREEN)
    }

    fun onProfileItemClicked() {
        if (settingsManager.isTokenReceived()) {
            router.replaceScreen(AppScreens.BOTTOM_PROFILE_SCREEN)
        } else {
            router.replaceScreen(AppScreens.STEAM_AUTH_SCREEN)
        }
    }
}
