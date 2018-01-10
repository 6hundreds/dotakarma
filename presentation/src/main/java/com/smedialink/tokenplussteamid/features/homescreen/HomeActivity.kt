package com.smedialink.tokenplussteamid.features.homescreen

import android.content.Context
import android.content.Intent
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseActivity

class HomeActivity : BaseActivity(), HomeView {

    companion object {
        fun getIntent(ctx: Context) = Intent(ctx, HomeActivity::class.java)
    }

    override val layoutId: Int
        get() = R.layout.activity_home_screen
}
