package com.smedialink.tokenplussteamid.features.splash.navigation

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.smedialink.tokenplussteamid.features.AppScreens.MAIN_SCREEN
import com.smedialink.tokenplussteamid.features.homescreen.MainActivity
import com.smedialink.tokenplussteamid.features.splash.SplashActivity
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

/**
 * Created by six_hundreds on 31.01.18.
 */
class SplashActivityNavigator @Inject constructor(activity: SplashActivity)
    : SupportAppNavigator(activity, -1) {

    override fun createFragment(screenKey: String?, data: Any?): Fragment =
            throw UnsupportedOperationException("Fragment navigation not supported in this activity")


    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent =
            when (screenKey) {
                MAIN_SCREEN -> Intent(context, MainActivity::class.java)
                else -> throw UnsupportedOperationException("Unknown screen key")
            }
}