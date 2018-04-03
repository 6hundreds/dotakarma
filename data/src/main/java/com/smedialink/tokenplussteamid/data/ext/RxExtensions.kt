package com.smedialink.tokenplussteamid.data.ext

import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by six_hundreds on 31.03.18.
 */
fun <I, O> Single<List<I>>.mapList(mapFunction: (I) -> O): Single<List<O>> =
        this.map { it.map(mapFunction) }

fun <I, O> Observable<List<I>>.mapList(mapFunction: (I) -> O): Observable<List<O>> =
        this.map { it.map(mapFunction) }
