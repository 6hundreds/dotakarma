package com.smedialink.tokenplussteamid.features.homescreen.pages.profile

import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseFragment
import javax.inject.Inject

class PlayerProfileFragment @Inject constructor() : BaseFragment(), PlayerProfileView {

    companion object {
        fun getNewInstance() = PlayerProfileFragment()

        const val TAG = "PlayerProfileFragment"
    }

    override val layoutId: Int
        get() = R.layout.fragment_profile
}
