package com.smedialink.tokenplussteamid.features.anonymous.walkthrough

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.app.AppScreens
import com.smedialink.tokenplussteamid.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by six_hundreds on 12.04.18.
 */
@InjectViewState
class AnonymousWalkthroughPresenter @Inject constructor(private val router: Router)
    : BasePresenter<AnonymousWalkthroughView>() {

    fun finish() {
        router.replaceScreen(AppScreens.ANONYMOUS_COMMENT_SCREEN)
    }
}