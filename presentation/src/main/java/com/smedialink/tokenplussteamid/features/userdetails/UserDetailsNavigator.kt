package com.smedialink.tokenplussteamid.features.userdetails

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.AppScreens
import com.smedialink.tokenplussteamid.features.anonymous.comment.AnonymousCommentFragment
import com.smedialink.tokenplussteamid.features.anonymous.walkthrough.AnonymousWalkthroughFragment
import com.smedialink.tokenplussteamid.features.profile.user.UserProfileFragment
import com.smedialink.tokenplussteamid.features.unregistered.UnregisteredUserFragment
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

/**
 * Created by six_hundreds on 09.04.18.
 */
class UserDetailsNavigator @Inject constructor(activity: UserDetailsActivity)
    : SupportAppNavigator(activity, R.id.container) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? = null


    override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
        AppScreens.USER_PROFILE_SCREEN -> UserProfileFragment.newInstance()
        AppScreens.USER_UNREGISTERED_SCREEN -> UnregisteredUserFragment.newInstance()
        AppScreens.ANONYMOUS_WALKTHROUGHT_SCREEN -> AnonymousWalkthroughFragment.newInstance()
        AppScreens.ANONYMOUS_COMMENT_SCREEN -> AnonymousCommentFragment.newInstance()
        else -> null
    }
}