package com.smedialink.tokenplussteamid.common.lists

import io.reactivex.Single

/**
 * Created by six_hundreds on 08.02.18.
 */
interface Paginator<T> {

    fun onLoadMore(limit: Int): Single<List<T>>

    fun onSuccess(items: List<T>)

    fun onError(error: Throwable)
}