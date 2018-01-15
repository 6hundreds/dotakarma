package com.smedialink.tokenplussteamid.features.homescreen.pages.feed

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseFragment
import javax.inject.Inject

class FeedFragment : BaseFragment(), FeedView {

    companion object {
        fun getNewInstance() = FeedFragment()

        const val TAG = "FeedFragment"
    }

    override val layoutId: Int
        get() = R.layout.fragment_feed

    @Inject
    @InjectPresenter
    lateinit var presenter: FeedPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun displayFeed(content: String) {

    }
}
