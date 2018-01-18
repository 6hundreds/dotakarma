package com.smedialink.tokenplussteamid.data.network

import com.smedialink.tokenplussteamid.data.entity.FeedCommentModel
import com.smedialink.tokenplussteamid.data.entity.PlayerDataModel
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface DotaKarmaApi {

    @GET("users/me")
    fun fetchPlayerProfile(): Single<PlayerDataModel>

    @GET("comments")
    fun fetchCommentsFeed(
        @Query("limit") limit: Int? = null,
        @Query("after") after: Int? = null
    ): Observable<List<FeedCommentModel>>
}
