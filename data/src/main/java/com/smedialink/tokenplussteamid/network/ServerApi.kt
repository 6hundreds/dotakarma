package com.smedialink.tokenplussteamid.network

import com.smedialink.tokenplussteamid.entity.RegisteredPlayerEntity
import io.reactivex.Completable
import io.reactivex.Single

interface ServerApi {

    fun sendRegistrationCompleRequest(login: String, password: String): Completable

    fun loadPlayerProfile(): Single<RegisteredPlayerEntity>
}
