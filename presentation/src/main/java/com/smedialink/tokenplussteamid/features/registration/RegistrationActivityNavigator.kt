package com.smedialink.tokenplussteamid.features.registration

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

class RegistrationActivityNavigator @Inject constructor(
        private val activity: RegistrationActivity
) : SupportAppNavigator(activity, activity.supportFragmentManager, 0) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? {
        return null
    }

    override fun createFragment(screenKey: String?, data: Any?): Fragment? {
        return null
    }
}
