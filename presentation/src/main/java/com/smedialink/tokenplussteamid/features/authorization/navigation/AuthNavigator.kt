package com.smedialink.tokenplussteamid.features.authorization.navigation

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.features.AppScreens
import com.smedialink.tokenplussteamid.features.authorization.AuthActivity
import com.smedialink.tokenplussteamid.features.emptystep.EmptyFragment
import com.smedialink.tokenplussteamid.features.registration.RegistrationFragment
import com.smedialink.tokenplussteamid.features.registrationcomplete.RegistrationCompletedFragment
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

class AuthNavigator @Inject constructor(
        activity: AuthActivity
) : SupportAppNavigator(activity, activity.supportFragmentManager, R.id.auth_container) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? = null

    override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
        AppScreens.REGISTRATION_SCREEN -> RegistrationFragment.getNewInstance()
        AppScreens.EMPTY_STEP_SCREEN -> EmptyFragment.getNewInstance()
        AppScreens.REGISTRATION_SUCCESS_SCREEN -> RegistrationCompletedFragment.getNewInstance()
        else -> null
    }
}
