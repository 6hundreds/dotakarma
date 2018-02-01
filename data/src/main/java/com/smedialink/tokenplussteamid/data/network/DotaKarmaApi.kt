package com.smedialink.tokenplussteamid.data.network

import com.smedialink.tokenplussteamid.data.entity.CommentModel
import com.smedialink.tokenplussteamid.data.entity.HeroImageDto
import com.smedialink.tokenplussteamid.data.entity.UserModel
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

    @GET("matches")
    fun fetchMatches(): Single<List<CommentModel>>

    @GET("heroes")
    fun fetchHeroes(): Single<List<HeroImageDto>>
}
