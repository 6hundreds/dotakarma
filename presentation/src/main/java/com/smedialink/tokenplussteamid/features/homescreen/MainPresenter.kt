package com.smedialink.tokenplussteamid.features.homescreen

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.features.AppScreens
import com.smedialink.tokenplussteamid.manager.SettingsManager
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
        private val router: Router,
        private val settingsManager: SettingsManager
) : BasePresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        navigateToFeedScreen()
    }

    fun navigateToAuthScreen() {
        router.navigateTo(AppScreens.AUTH_SCREEN)
    }

    fun navigateToFeedScreen() {
        router.replaceScreen(AppScreens.BOTTOM_FEED_SCREEN)
    }

    fun navigateToProfileScreen() {
        if (settingsManager.isSteamIdReceived()) {
            router.replaceScreen(AppScreens.BOTTOM_PROFILE_SCREEN)
        } else {
            router.navigateTo(AppScreens.AUTH_SCREEN)
        }
    }
}
