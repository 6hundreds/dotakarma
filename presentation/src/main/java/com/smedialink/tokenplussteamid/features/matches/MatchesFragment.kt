package com.smedialink.tokenplussteamid.features.matches

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.basic.BaseFragment
import javax.inject.Inject

@Layout(R.layout.fragment_matches)
class MatchesFragment : BaseFragment(), MatchesView {

    companion object {
        fun getNewInstance() = MatchesFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: MatchesPresenter


    @ProvidePresenter
    fun providePresenter() = presenter

    override fun initUi() {
    }
}
