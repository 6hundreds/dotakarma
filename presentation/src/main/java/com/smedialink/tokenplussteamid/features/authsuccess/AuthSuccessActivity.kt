package com.smedialink.tokenplussteamid.features.authsuccess

import android.os.Bundle
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseActivity
import kotlinx.android.synthetic.main.activity_auth_success.*

class AuthSuccessActivity : BaseActivity(), AuthSuccessView {

    override val layoutId: Int
        get() = R.layout.activity_auth_success

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent.dataString?.let { text -> text_view_intent_data.text = text }
    }
}
