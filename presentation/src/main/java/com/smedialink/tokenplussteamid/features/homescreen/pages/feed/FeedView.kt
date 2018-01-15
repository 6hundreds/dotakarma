package com.smedialink.tokenplussteamid.features.homescreen.pages.feed

import com.arellomobile.mvp.MvpView

interface FeedView : MvpView {

    fun displayFeed(content: String)
}
