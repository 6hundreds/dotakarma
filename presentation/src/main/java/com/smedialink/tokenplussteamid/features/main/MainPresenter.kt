package com.smedialink.tokenplussteamid.features.main

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.app.AppScreens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(private val router: Router)
    : BasePresenter<MainView>() {

    fun onFeedTabClicked() {
        router.replaceScreen(AppScreens.FEED_TAB_SCREEN)
    }

    fun onMatchesTabClicked() {
        router.replaceScreen(AppScreens.MATCHES_TAB_SCREEN)
    }

    fun onProfileTabClicked() {
        router.replaceScreen(AppScreens.PROFILE_TAB_SCREEN)
    }
}
