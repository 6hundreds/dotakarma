package com.smedialink.tokenplussteamid.features.main.containers.profile

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.transition.ChangeBounds
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.features.AppScreens
import com.smedialink.tokenplussteamid.features.auth.SteamAuthFragment
import com.smedialink.tokenplussteamid.features.myprofile.MyProfileFragment
import com.smedialink.tokenplussteamid.features.reply.ReplyToCommentFragment
import ru.terrakok.cicerone.android.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward
import javax.inject.Inject

/**
 * Created by Sergey Opivalov on 20/02/2018.
 */
class ProfileContainerNavigator @Inject constructor(fragment: ProfileContainerFragment)
    : SupportAppNavigator(fragment.activity, fragment.childFragmentManager, R.id.tab_container) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? =
            null

    override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
        AppScreens.MY_PROFILE_SCREEN -> MyProfileFragment.newInstance()
        AppScreens.STEAM_AUTH_SCREEN -> SteamAuthFragment.newInstance()
        AppScreens.REPLY_TO_COMMENT_SCREEN -> ReplyToCommentFragment.newInstance(data as Int)
        else -> null
    }

    override fun setupFragmentTransactionAnimation(command: Command,
                                                   currentFragment: Fragment,
                                                   nextFragment: Fragment,
                                                   fragmentTransaction: FragmentTransaction) {

        if (command is Forward &&
                currentFragment is MyProfileFragment &&
                nextFragment is ReplyToCommentFragment) {
            setupSharedElementForReply(currentFragment, nextFragment, fragmentTransaction)
        }
    }

    private fun setupSharedElementForReply(profileFragment: MyProfileFragment,
                                           replyToCommentFragment: ReplyToCommentFragment,
                                           fragmentTransaction: FragmentTransaction) {

        val changeBounds = ChangeBounds()

        replyToCommentFragment.apply {
            sharedElementEnterTransition = changeBounds
            sharedElementReturnTransition = changeBounds
        }

        profileFragment.apply {
            sharedElementEnterTransition = changeBounds
            sharedElementReturnTransition = changeBounds
        }

        fragmentTransaction.addSharedElement(, "")
        replyToCommentFragment.

    }
}