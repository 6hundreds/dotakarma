package com.smedialink.tokenplussteamid.features.containers.profile

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.app.AppScreens
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.data.manager.ProfileManager
import com.smedialink.tokenplussteamid.data.manager.SessionManager
import com.smedialink.tokenplussteamid.di.qualifier.LocalNavigation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by Sergey Opivalov on 20/02/2018.
 */
@InjectViewState
class ProfileContainerPresenter @Inject constructor(
        private val sessionManager: SessionManager,
        private val profileManager: ProfileManager, //todo move to usecase both
        @LocalNavigation private val router: Router
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
            profileManager.initialFetch()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ router.newRootScreen(AppScreens.MY_PROFILE_SCREEN) },
                            { router.newRootScreen(AppScreens.NO_USER_INFO_SCREEN) })
        } else {
            router.newRootScreen(AppScreens.STEAM_AUTH_SCREEN)
        }
    }
}