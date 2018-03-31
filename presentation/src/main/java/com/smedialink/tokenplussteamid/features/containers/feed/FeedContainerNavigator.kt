package com.smedialink.tokenplussteamid.features.containers.feed

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.AppScreens
import com.smedialink.tokenplussteamid.features.feed.FeedFragment
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

/**
 * Created by Sergey Opivalov on 06/03/2018.
 */
class FeedContainerNavigator @Inject constructor(fragment: FeedContainerFragment)
    : SupportAppNavigator(fragment.activity, fragment.childFragmentManager, R.id.tab_container) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? =
            null


    override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
        AppScreens.FEED_SCREEN -> FeedFragment.newInstance()
        else -> null
    }
}