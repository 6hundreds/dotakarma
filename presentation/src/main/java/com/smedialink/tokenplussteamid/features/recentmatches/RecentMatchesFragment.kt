package com.smedialink.tokenplussteamid.features.recentmatches

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.basic.BaseFragment
import javax.inject.Inject

@Layout(R.layout.fragment_matches)
class RecentMatchesFragment : BaseFragment(), RecentMatchesView {

    companion object {
        fun getNewInstance() = RecentMatchesFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenterRecent: RecentMatchesPresenter

    @ProvidePresenter
    fun providePresenter() = presenterRecent

    override fun initUi() {
    }
}
