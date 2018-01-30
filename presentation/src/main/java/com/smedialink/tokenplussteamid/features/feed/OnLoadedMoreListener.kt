package com.smedialink.tokenplussteamid.features.feed

import com.smedialink.tokenplussteamid.features.feed.adapter.FeedItem

/**
 * Created by six_hundreds on 30.01.18.
 */
interface OnLoadedMoreListener {

    fun onSuccess(items : List<FeedItem>)
    fun onError()
}