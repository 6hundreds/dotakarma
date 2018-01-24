package com.smedialink.tokenplussteamid.features.feed

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseFragment
import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.features.feed.adapter.FeedAdapter
import kotlinx.android.synthetic.main.fragment_feed.*
import javax.inject.Inject

class FeedFragment : BaseFragment(), FeedView {

    companion object {
        fun newInstance() = FeedFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: FeedPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override val layoutId: Int = R.layout.fragment_feed

    lateinit var feedAdapter: FeedAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        feedAdapter = FeedAdapter()
        feedAdapter.setHasStableIds(true)

        with(feed_comments) {
            adapter = feedAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    override fun appendFeedContent(comments: List<Comment>) {
        feedAdapter.addFeedComments(comments)
    }

    override fun clearFeedComments() {
        feedAdapter.clearFeed()
    }
}
