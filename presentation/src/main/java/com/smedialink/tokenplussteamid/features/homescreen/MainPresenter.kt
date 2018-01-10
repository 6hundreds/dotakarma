package com.smedialink.tokenplussteamid.features.homescreen

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.features.AppScreens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
        private val router: Router
) : BasePresenter<MainView>() {

    fun performAuthorization() {
        router.navigateTo(AppScreens.AUTH_SCREEN)
    }
}
