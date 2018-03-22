package com.smedialink.tokenplussteamid.features.feed

import com.arellomobile.mvp.MvpView
import com.smedialink.tokenplussteamid.base.CanHideRefreshing
import com.smedialink.tokenplussteamid.base.CanShowError
import com.smedialink.tokenplussteamid.base.CanShowLoading
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem

interface FeedView : MvpView, CanShowError, CanShowLoading, CanHideRefreshing {

    fun showFeed(items: List<HeterogeneousItem>)

    fun appendFeed(items: List<HeterogeneousItem>)
}
