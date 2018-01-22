package com.smedialink.tokenplussteamid.features.feed

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.smedialink.tokenplussteamid.entity.FeedComment

@StateStrategyType(SkipStrategy::class)
interface FeedView : MvpView {

    @StateStrategyType(AddToEndStrategy::class)
    fun appendFeedContent(comments: List<FeedComment>)

    @StateStrategyType(SingleStateStrategy::class)
    fun clearFeedComments()
}
