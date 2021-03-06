package com.smedialink.tokenplussteamid.features.feed

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.base.BaseFragment
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.common.ext.setVisible
import com.smedialink.tokenplussteamid.features.feed.adapter.FeedAdapter
import com.smedialink.tokenplussteamid.subnavigation.TabNestedFragment
import kotlinx.android.synthetic.main.fragment_feed.*
import javax.inject.Inject

@Layout(R.layout.fragment_feed)
class FeedFragment
    : TabNestedFragment(), FeedView, SwipeRefreshLayout.OnRefreshListener {

    companion object {
        fun newInstance() = FeedFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: FeedPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    private lateinit var feedAdapter: FeedAdapter

    override fun initUi() {
        feedAdapter = FeedAdapter(presenter)
        with(list_feed) {
            adapter = feedAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
        layout_refresh.setOnRefreshListener(this)
    }

    override fun appendFeed(items: List<HeterogeneousItem>) {
        feedAdapter.appendItems(items)
    }

    override fun showFeed(items: List<HeterogeneousItem>) {
        feedAdapter.refreshItems(items)
    }

    override fun showError(error: String) {
        errorDelegate.showError(error)
    }

    override fun showLoading(show: Boolean) {
        loader.setVisible(show)
    }

    override fun onRefresh() {
        presenter.refreshFeed()
    }

    override fun hideRefreshing() {
        layout_refresh.isRefreshing = false
    }
}
