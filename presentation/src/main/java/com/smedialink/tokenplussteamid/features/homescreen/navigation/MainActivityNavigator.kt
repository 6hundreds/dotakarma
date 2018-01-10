package com.smedialink.tokenplussteamid.features.homescreen.navigation

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.smedialink.tokenplussteamid.features.AppScreens
import com.smedialink.tokenplussteamid.features.authorization.AuthActivity
import com.smedialink.tokenplussteamid.features.homescreen.MainActivity
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

class MainActivityNavigator @Inject constructor(
        private val activity: MainActivity
) : SupportAppNavigator(activity, activity.supportFragmentManager, 0) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? =
            when (screenKey) {
                AppScreens.AUTH_SCREEN -> AuthActivity.getIntent(activity)
                else -> null
            }

    override fun createFragment(screenKey: String?, data: Any?): Fragment? {
        return null
    }
}
