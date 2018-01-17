package com.smedialink.tokenplussteamid.data.network

import com.smedialink.tokenplussteamid.data.entity.RegisteredPlayerEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.HeaderMap

interface DotaKarmaApi {

    @GET("users/me")
    fun loadPlayerProfile(
            @HeaderMap headers: Map<String, String>
    ): Single<RegisteredPlayerEntity>
}
