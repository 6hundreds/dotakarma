package com.smedialink.tokenplussteamid.features.steamid

import android.content.Context
import android.content.Intent
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseActivity
import javax.inject.Inject

class GetSteamIdActivity : BaseActivity(), GetSteamIdView {

    companion object {
        fun getIntent(ctx: Context) = Intent(ctx, GetSteamIdActivity::class.java)
    }

    override val layoutId: Int
        get() = R.layout.activity_steam_interaction

    @Inject
    @InjectPresenter
    lateinit var presenter: GetSteamIdPresenter

    @ProvidePresenter
    fun providePresenter() = presenter
}
