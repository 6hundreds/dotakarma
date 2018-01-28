package com.smedialink.tokenplussteamid.features.matches

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.basic.BaseFragment
import javax.inject.Inject

class MatchesFragment : BaseFragment(), MatchesView {

    companion object {
        fun getNewInstance() = MatchesFragment()
    }

    override val layoutId: Int
        get() = R.layout.fragment_matches

    @Inject
    @InjectPresenter
    lateinit var presenter: MatchesPresenter

    @ProvidePresenter
    fun providePresenter() = presenter
}
