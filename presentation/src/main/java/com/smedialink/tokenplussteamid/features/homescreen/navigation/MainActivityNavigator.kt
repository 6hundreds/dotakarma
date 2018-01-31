package com.smedialink.tokenplussteamid.features.homescreen.navigation

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.features.AppScreens
import com.smedialink.tokenplussteamid.features.feed.FeedFragment
import com.smedialink.tokenplussteamid.features.homescreen.MainActivity
import com.smedialink.tokenplussteamid.features.matches.MatchesFragment
import com.smedialink.tokenplussteamid.features.playerprofile.PlayerProfileFragment
import com.smedialink.tokenplussteamid.features.steamauth.SteamAuthFragment
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

class MainActivityNavigator @Inject constructor(
    private val activity: MainActivity
) : SupportAppNavigator(activity, activity.supportFragmentManager, R.id.home_tabs_container) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? =
        null

    override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
        AppScreens.BOTTOM_FEED_SCREEN -> FeedFragment.newInstance()
        AppScreens.BOTTOM_PROFILE_SCREEN -> PlayerProfileFragment.getNewInstance()
        AppScreens.BOTTOM_MATCHES_SCREEN -> MatchesFragment.getNewInstance()
        AppScreens.STEAM_AUTH_SCREEN -> SteamAuthFragment.getNewInstance()
        else -> null
    }
}