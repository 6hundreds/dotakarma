package com.smedialink.tokenplussteamid.features.main.containers.matches

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.AppScreens
import com.smedialink.tokenplussteamid.features.matches.matchdetails.MatchDetailsFragment
import com.smedialink.tokenplussteamid.features.matches.recentmatches.RecentMatchesFragment
import com.smedialink.tokenplussteamid.features.userdetails.UserDetailsActivity
import ru.terrakok.cicerone.android.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward
import javax.inject.Inject

/**
 * Created by Sergey Opivalov on 14/02/2018.
 */
class MatchesContainerNavigator @Inject constructor(fragment: MatchesContainerFragment)
    : SupportAppNavigator(fragment.activity, fragment.childFragmentManager, R.id.tab_container) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? =
            when (screenKey) {
                AppScreens.USER_DETAILS_SCREEN -> {
                    Intent(context, UserDetailsActivity::class.java).apply {
                        putExtra(UserDetailsActivity.USER_ID_KEY, data as Long)
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
        if (command is Forward &&
                nextFragment is MatchDetailsFragment &&
                currentFragment is RecentMatchesFragment) {
            fragmentTransaction?.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_from_right,
                    R.anim.enter_to_right,
                    R.anim.exit_to_right
            )
        }
    }
}