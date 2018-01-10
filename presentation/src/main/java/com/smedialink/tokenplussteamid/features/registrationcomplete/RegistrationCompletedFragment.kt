package com.smedialink.tokenplussteamid.features.registrationcomplete

import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseFragment

class RegistrationCompletedFragment : BaseFragment(), RegistrationCompletedView {

    companion object {
        fun getNewInstance() = RegistrationCompletedFragment()
    }

    override val layoutId: Int
        get() = R.layout.fragment_registration_completed
}
