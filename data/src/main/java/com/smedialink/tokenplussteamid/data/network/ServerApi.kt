package com.smedialink.tokenplussteamid.data.network

import com.smedialink.tokenplussteamid.data.entity.RegisteredPlayerEntity
import io.reactivex.Completable
import io.reactivex.Single

interface ServerApi {

    fun sendRegistrationCompleRequest(login: String, password: String): Completable

    fun loadPlayerProfile(): Single<RegisteredPlayerEntity>
}
