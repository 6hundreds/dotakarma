package com.smedialink.tokenplussteamid.features.main.containers.matches

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.di.qualifier.LocalNavigation
import com.smedialink.tokenplussteamid.features.AppScreens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by six_hundreds on 21.02.18.
 */
@InjectViewState
class MatchesContainerPresenter @Inject constructor(@LocalNavigation private val router: Router)
    : BasePresenter<MatchesContainerView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(AppScreens.RECENT_MATCHES_SCREEN)
    }
}
