package com.smedialink.tokenplussteamid.features.playerprofile

import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseFragment

class PlayerProfileFragment : BaseFragment(), PlayerProfileView {

    companion object {
        fun getNewInstance() = PlayerProfileFragment()
    }

    override val layoutId: Int
        get() = R.layout.fragment_profile
}
