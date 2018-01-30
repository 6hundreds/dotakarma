package com.smedialink.tokenplussteamid.features.feed

import com.smedialink.tokenplussteamid.features.feed.entity.CommentUiModel
import io.reactivex.Single

/**
 * Created by six_hundreds on 30.01.18.
 */
interface FeedPaginator {

    fun onLoadMore(limit : Int): Single<List<CommentUiModel>>

    fun onSuccess(items : List<CommentUiModel>)

    fun onError(throwable: Throwable)

}