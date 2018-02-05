package com.smedialink.tokenplussteamid.features.homescreen.navigation

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.features.AppScreens
import com.smedialink.tokenplussteamid.features.feed.FeedFragment
import com.smedialink.tokenplussteamid.features.homescreen.MainActivity
import com.smedialink.tokenplussteamid.features.matches.recentmatches.RecentMatchesFragment
import com.smedialink.tokenplussteamid.features.profile.ProfileFragment
import com.smedialink.tokenplussteamid.features.auth.SteamAuthFragment
import com.smedialink.tokenplussteamid.features.matches.matchdetails.MatchDetailsFragment
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

class MainActivityNavigator @Inject constructor(activity: MainActivity)
    : SupportAppNavigator(activity, activity.supportFragmentManager, R.id.home_tabs_container) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? =
            null

    override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
        AppScreens.BOTTOM_FEED_SCREEN -> FeedFragment.newInstance()
        AppScreens.BOTTOM_PROFILE_SCREEN -> ProfileFragment.newInstance()
        AppScreens.BOTTOM_MATCHES_SCREEN -> RecentMatchesFragment.newInstance()
        AppScreens.STEAM_AUTH_SCREEN -> SteamAuthFragment.newInstance()
        AppScreens.MATCH_DETAILS_SCREEN -> MatchDetailsFragment.newInstance(data as Long)
        else -> null
    }
}