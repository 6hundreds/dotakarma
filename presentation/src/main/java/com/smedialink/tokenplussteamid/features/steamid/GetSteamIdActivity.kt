package com.smedialink.tokenplussteamid.features.steamid

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseActivity
import javax.inject.Inject

class GetSteamIdActivity : BaseActivity(), GetSteamIdView {

    override val layoutId: Int
        get() = R.layout.activity_steam_interaction

    @Inject
    @InjectPresenter
    lateinit var presenter: GetSteamIdPresenter

    @ProvidePresenter
    fun providePresenter() = presenter
}
