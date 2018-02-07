package com.smedialink.tokenplussteamid.features.feed

import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.basic.BaseFragment
import com.smedialink.tokenplussteamid.common.setVisible
import com.smedialink.tokenplussteamid.features.feed.adapter.FeedAdapter
import com.smedialink.tokenplussteamid.features.feed.adapter.FeedItem
import kotlinx.android.synthetic.main.fragment_feed.*
import javax.inject.Inject

@Layout(R.layout.fragment_feed)
class FeedFragment
    : BaseFragment(), FeedView {

    companion object {
        fun newInstance() = FeedFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: FeedPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    private lateinit var feedAdapter: FeedAdapter

    override fun updateFeed(items: List<FeedItem>) {
        feedAdapter.insertItems(items)
    }

    override fun initUi() {
        feedAdapter = FeedAdapter(presenter)
        with(list_feed) {
            adapter = feedAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading(show: Boolean) {
        loader.setVisible(show)
    }
}
