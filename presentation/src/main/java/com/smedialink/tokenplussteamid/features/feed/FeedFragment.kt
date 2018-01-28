package com.smedialink.tokenplussteamid.features.feed

import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.basic.BaseFragment
import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.features.feed.adapter.FeedAdapter
import kotlinx.android.synthetic.main.fragment_feed.*
import javax.inject.Inject

@Layout(R.layout.fragment_feed)
class FeedFragment : BaseFragment(), FeedView {

    companion object {
        fun newInstance() = FeedFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: FeedPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    lateinit var feedAdapter: FeedAdapter

    override fun appendFeedContent(comments: List<Comment>) {
        feedAdapter.addFeedComments(comments)
    }

    override fun initUi() {
        with(feed_comments) {
            adapter = FeedAdapter().apply { setHasStableIds(true) }
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    override fun clearFeedComments() {
        feedAdapter.clearFeed()
    }
}
