package com.smedialink.tokenplussteamid.features.feed

import com.arellomobile.mvp.MvpView
import com.smedialink.tokenplussteamid.basic.CanShowError
import com.smedialink.tokenplussteamid.basic.CanShowLoading
import com.smedialink.tokenplussteamid.common.HeterogeneousItem

interface FeedView : MvpView, CanShowError, CanShowLoading {

    fun refreshFeed(items: List<HeterogeneousItem>)

    fun appendFeed(items: List<HeterogeneousItem>)

    fun hideRefresh()

}
