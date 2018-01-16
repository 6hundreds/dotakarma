package com.smedialink.tokenplussteamid.features.authsuccess

import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseActivity

class AuthSuccessActivity : BaseActivity(), AuthSuccessView {

    override val layoutId: Int
        get() = R.layout.activity_auth_success
}