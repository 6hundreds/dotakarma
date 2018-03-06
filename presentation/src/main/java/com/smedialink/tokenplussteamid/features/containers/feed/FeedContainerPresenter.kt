package com.smedialink.tokenplussteamid.features.containers.feed

import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.di.qualifier.LocalNavigation
import com.smedialink.tokenplussteamid.features.AppScreens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by Sergey Opivalov on 06/03/2018.
 */
class FeedContainerPresenter @Inject constructor(@LocalNavigation private val router: Router)
    : BasePresenter<FeedContainerView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(AppScreens.FEED_SCREEN)
    }
}