package com.smedialink.tokenplussteamid.data.network

import com.smedialink.tokenplussteamid.data.entity.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface DotaKarmaApi {

    @GET("users/me")
    fun fetchMyProfile(): Single<UserModel>

    @GET("users/me/comments")
    fun fetchMyComments(@Query("limit") limit: Int?,
                        @Query("after") after: Int?): Single<List<CommentModel>>

    @GET("comments")
    fun fetchComments(@Query("limit") limit: Int?,
                      @Query("after") after: Int?,
                      @Query("user_id") id: Int?): Single<List<CommentModel>>

    @GET("dota/matches")
    fun fetchMatches(): Single<List<MatchModel>>

    @GET("dota/heroes")
    fun fetchHeroes(): Single<List<HeroDto>>
}
