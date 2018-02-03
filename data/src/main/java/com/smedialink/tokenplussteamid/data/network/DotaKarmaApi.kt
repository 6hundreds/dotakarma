package com.smedialink.tokenplussteamid.data.network

import com.smedialink.tokenplussteamid.data.entity.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface DotaKarmaApi {

    @GET("users/me")
    fun fetchUserProfile(): Single<UserModel>

    @GET("comments")
    fun fetchComments(
            @Query("limit") limit: Int? = null,
            @Query("after") after: Int? = null
    ): Single<List<CommentModel>>

    @GET("dota/matches")
    fun fetchMatches(): Single<List<MatchModel>>

    @GET("dota/heroes")
    fun fetchHeroes(): Single<List<HeroImageDto>>
}
