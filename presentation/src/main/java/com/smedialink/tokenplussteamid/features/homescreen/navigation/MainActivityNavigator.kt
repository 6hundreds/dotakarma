package com.smedialink.tokenplussteamid.features.homescreen.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.features.AppScreens
import com.smedialink.tokenplussteamid.features.feed.FeedFragment
import com.smedialink.tokenplussteamid.features.homescreen.MainActivity
import com.smedialink.tokenplussteamid.features.matches.recentmatches.RecentMatchesFragment
import com.smedialink.tokenplussteamid.features.myprofile.MyProfileFragment
import com.smedialink.tokenplussteamid.features.auth.SteamAuthFragment
import com.smedialink.tokenplussteamid.features.matches.matchdetails.MatchDetailsFragment
import com.smedialink.tokenplussteamid.features.userprofile.UserProfileActivity
import com.smedialink.tokenplussteamid.features.userprofile.UserProfileActivity.Companion.USER_ID_KEY
import ru.terrakok.cicerone.android.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject

class MainActivityNavigator @Inject constructor(activity: MainActivity)
    : SupportAppNavigator(activity, activity.supportFragmentManager, R.id.home_tabs_container) {

    override fun createActivityIntent(context: Context, screenKey: String?, data: Any?): Intent? =
            when (screenKey) {
                AppScreens.USER_PROFILE_SCREEN -> {
                    Intent(context, UserProfileActivity::class.java).apply {
                        putExtra(USER_ID_KEY, data as Long)
                    }
                }
                else -> null
            }

    override fun setupFragmentTransactionAnimation(command: Command?,
                                                   currentFragment: Fragment?,
                                                   nextFragment: Fragment?,
                                                   fragmentTransaction: FragmentTransaction?) {
        if (nextFragment is MatchDetailsFragment) {
            fragmentTransaction?.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_from_right,
                    R.anim.enter_to_right,
                    R.anim.exit_to_right
            )
        } else {
            fragmentTransaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        }
    }

    override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
        AppScreens.BOTTOM_FEED_SCREEN -> FeedFragment.newInstance()
        AppScreens.BOTTOM_PROFILE_SCREEN -> MyProfileFragment.newInstance()
        AppScreens.BOTTOM_MATCHES_SCREEN -> RecentMatchesFragment.newInstance()
        AppScreens.STEAM_AUTH_SCREEN -> SteamAuthFragment.newInstance()
        AppScreens.MATCH_DETAILS_SCREEN -> MatchDetailsFragment.newInstance(data as Long)
        else -> null
    }
}