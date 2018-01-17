package com.smedialink.tokenplussteamid.data.repository.datasource

import io.reactivex.Completable
import io.reactivex.Single

interface DataStore<T> {

    fun get() : Single<T>

    fun put(t : T) : Completable
}
