package com.smedialink.tokenplussteamid.features.feed

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.smedialink.tokenplussteamid.features.feed.adapter.FeedItem
import com.smedialink.tokenplussteamid.features.feed.entity.CommentUiModel

interface FeedView : MvpView {

    @StateStrategyType(AddToEndStrategy::class)
    fun updateFeed(comments: List<FeedItem>)

    fun showError(error: String)
}
