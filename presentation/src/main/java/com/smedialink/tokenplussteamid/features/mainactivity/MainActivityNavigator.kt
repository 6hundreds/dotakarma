package com.smedialink.tokenplussteamid.features.mainactivity

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.smedialink.tokenplussteamid.features.MyAppScreens
import com.smedialink.tokenplussteamid.features.homescreen.HomeActivity
import com.smedialink.tokenplussteamid.features.registration.RegistrationActivity
import com.smedialink.tokenplussteamid.features.steamid.GetSteamIdActivity
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

class MainActivityNavigator @Inject constructor(
        private val activity: MainActivity
) : SupportAppNavigator(activity, activity.supportFragmentManager, 0) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? =
            when (screenKey) {
                MyAppScreens.REGISTRATION_SCREEN -> RegistrationActivity.getIntent(activity)
                MyAppScreens.STEAM_AUTH_SCREEN -> GetSteamIdActivity.getIntent(activity)
                MyAppScreens.HOME_SCREEN -> HomeActivity.getIntent(activity)
                else -> null
            }

    override fun createFragment(screenKey: String?, data: Any?): Fragment? {
        return null
    }
}
