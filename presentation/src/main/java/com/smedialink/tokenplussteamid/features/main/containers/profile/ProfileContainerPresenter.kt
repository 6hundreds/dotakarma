package com.smedialink.tokenplussteamid.features.main.containers.profile

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.data.manager.SessionManager
import com.smedialink.tokenplussteamid.di.qualifier.LocalNavigation
import com.smedialink.tokenplussteamid.features.AppScreens
import io.reactivex.rxkotlin.addTo
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by Sergey Opivalov on 20/02/2018.
 */
@InjectViewState
class ProfileContainerPresenter @Inject constructor(
        @LocalNavigation
        private val router: Router,
        private val sessionManager: SessionManager
) : BasePresenter<ProfileContainerView>() {

    init {
        sessionManager.getSessionState()
                .subscribe({ state ->
                    when (state) {
                        SessionManager.State.OPENED -> router.newRootScreen(AppScreens.MY_PROFILE_SCREEN)
                        SessionManager.State.CLOSED -> router.newRootScreen(AppScreens.STEAM_AUTH_SCREEN)
                    }
                })
    }


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        if (sessionManager.isSessionOpened()) {
            router.newRootScreen(AppScreens.MY_PROFILE_SCREEN)
        } else {
            router.newRootScreen(AppScreens.STEAM_AUTH_SCREEN)
        }
    }
}