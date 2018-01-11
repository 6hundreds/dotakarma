package com.smedialink.tokenplussteamid.features.steam

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseFragment
import javax.inject.Inject

class SteamAuthFragment : BaseFragment(), SteamAuthView {

    companion object {
        fun getNewInstance() = SteamAuthFragment()
    }

    override val layoutId: Int
        get() = R.layout.fragment_empty_step

    @Inject
    @InjectPresenter
    lateinit var presenter: SteamAuthPresenter

    @ProvidePresenter
    fun providePresenter() = presenter
}
