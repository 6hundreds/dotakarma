package com.smedialink.tokenplussteamid.features.main.containers.matches

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.features.AppScreens
import com.smedialink.tokenplussteamid.features.matches.matchdetails.MatchDetailsFragment
import com.smedialink.tokenplussteamid.features.matches.recentmatches.RecentMatchesFragment
import com.smedialink.tokenplussteamid.features.userprofile.UserProfileActivity
import ru.terrakok.cicerone.android.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject

/**
 * Created by Sergey Opivalov on 14/02/2018.
 */
class MatchesContainerNavigator @Inject constructor(fragment: MatchesContainerFragment)
    : SupportAppNavigator(fragment.activity, fragment.childFragmentManager, R.id.tab_container) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? =
            when (screenKey) {
                AppScreens.USER_PROFILE_SCREEN -> {
                    Intent(context, UserProfileActivity::class.java).apply {
                        putExtra(UserProfileActivity.USER_ID_KEY, data as Long)
                    }
                }
                else -> null
            }


    override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
        AppScreens.MATCH_DETAILS_SCREEN -> MatchDetailsFragment.newInstance(data as Long)
        AppScreens.RECENT_MATCHES_SCREEN -> RecentMatchesFragment.newInstance()
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
        }
    }
}