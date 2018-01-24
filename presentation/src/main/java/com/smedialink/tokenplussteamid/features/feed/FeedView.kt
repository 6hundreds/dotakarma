package com.smedialink.tokenplussteamid.features.feed

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.smedialink.tokenplussteamid.entity.Comment

@StateStrategyType(SkipStrategy::class)
interface FeedView : MvpView {

    @StateStrategyType(AddToEndStrategy::class)
    fun appendFeedContent(comments: List<Comment>)

    @StateStrategyType(SingleStateStrategy::class)
    fun clearFeedComments()
}
