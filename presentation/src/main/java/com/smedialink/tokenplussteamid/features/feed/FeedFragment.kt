package com.smedialink.tokenplussteamid.features.feed

import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.basic.BaseFragment
import com.smedialink.tokenplussteamid.features.feed.adapter.FeedAdapter
import com.smedialink.tokenplussteamid.features.feed.adapter.FeedItem
import com.smedialink.tokenplussteamid.features.feed.entity.CommentUiModel
import kotlinx.android.synthetic.main.fragment_feed.*
import javax.inject.Inject

@Layout(R.layout.fragment_feed)
class FeedFragment
    : BaseFragment(), FeedView, OnLoadedMoreListener {

    companion object {
        fun newInstance() = FeedFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: FeedPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    private val feedAdapter = FeedAdapter()

    override fun updateFeed(comments: List<CommentUiModel>) {
        feedAdapter.insertItems(comments)
    }

    override fun initUi() {
        with(list_feed) {
            adapter = feedAdapter.apply { setHasStableIds(true) }
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    override fun onSuccess(items: List<FeedItem>) {
        feedAdapter.insertItems(items)
    }

    override fun onError() {
        Toast.makeText(context, "Error on loading more items...", Toast.LENGTH_SHORT).show()
    }
}
