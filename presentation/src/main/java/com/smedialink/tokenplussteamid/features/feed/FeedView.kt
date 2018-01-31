package com.smedialink.tokenplussteamid.features.feed

import com.arellomobile.mvp.MvpView
import com.smedialink.tokenplussteamid.features.feed.adapter.FeedItem

interface FeedView : MvpView {

    fun updateFeed(comments: List<FeedItem>)

    fun showError(error: String)

    fun showLoading(show : Boolean)
}
