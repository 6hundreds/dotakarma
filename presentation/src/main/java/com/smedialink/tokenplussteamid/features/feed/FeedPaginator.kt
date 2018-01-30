package com.smedialink.tokenplussteamid.features.feed

import com.smedialink.tokenplussteamid.features.feed.adapter.FeedItem
import io.reactivex.Single

/**
 * Created by six_hundreds on 30.01.18.
 */
interface FeedPaginator {

    fun onLoadMore(limit : Int): Single<List<FeedItem>>

    fun onSuccess(items : List<FeedItem>)

    fun onError(throwable: Throwable)

}