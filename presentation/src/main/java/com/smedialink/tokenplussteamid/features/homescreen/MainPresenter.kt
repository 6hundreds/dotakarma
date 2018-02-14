package com.smedialink.tokenplussteamid.features.homescreen

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.data.manager.SessionManager
import com.smedialink.tokenplussteamid.features.AppScreens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
    private val router: Router,
    private val settingsManager: SessionManager
) : BasePresenter<MainView>() {

    fun onFeedTabClicked() {
        router.replaceScreen(AppScreens.BOTTOM_FEED_SCREEN)
    }

    fun onMatchesTabClicked() {
        router.replaceScreen(AppScreens.BOTTOM_MATCHES_SCREEN)
    }

    fun onProfileTabClicked() {
        if (settingsManager.isSessionOpened()) {
            router.replaceScreen(AppScreens.BOTTOM_PROFILE_SCREEN)
        } else {
            router.replaceScreen(AppScreens.STEAM_AUTH_SCREEN)
        }
    }
}
