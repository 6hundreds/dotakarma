package com.smedialink.tokenplussteamid.features.feed

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseFragment
import javax.inject.Inject

class FeedFragment : BaseFragment(), FeedView {

    companion object {
        fun getNewInstance() = FeedFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: FeedPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override val layoutId: Int
        get() = R.layout.fragment_feed
}
