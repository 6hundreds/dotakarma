package com.smedialink.tokenplussteamid.data.network

import com.smedialink.tokenplussteamid.data.entity.PlayerDataModel
import io.reactivex.Single
import retrofit2.http.GET

interface DotaKarmaApi {

    @GET("users/me")
    fun fetchPlayerProfile(): Single<PlayerDataModel>
}
