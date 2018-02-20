package com.smedialink.tokenplussteamid.features.main.containers.profile

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.features.AppScreens
import com.smedialink.tokenplussteamid.features.auth.SteamAuthFragment
import com.smedialink.tokenplussteamid.features.myprofile.MyProfileFragment
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

/**
 * Created by Sergey Opivalov on 20/02/2018.
 */
class ProfileContainerNavigator @Inject constructor(fragment: ProfileContainerFragment)
    : SupportAppNavigator(fragment.activity, fragment.childFragmentManager, R.id.tab_container) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? =
            null

    override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
        AppScreens.STEAM_AUTH_SCREEN -> SteamAuthFragment.newInstance()
        AppScreens.MY_PROFILE_SCREEN -> MyProfileFragment.newInstance()
        else -> null
    }
}