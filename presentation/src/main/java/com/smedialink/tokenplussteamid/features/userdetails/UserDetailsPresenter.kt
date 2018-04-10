package com.smedialink.tokenplussteamid.features.userdetails

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.app.AppScreens
import com.smedialink.tokenplussteamid.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by six_hundreds on 13.02.18.
 */
@InjectViewState
class UserDetailsPresenter @Inject constructor(private val router: Router)
    : BasePresenter<UserDetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(AppScreens.USER_PROFILE_SCREEN)
    }
}