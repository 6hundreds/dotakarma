package com.smedialink.tokenplussteamid.data.network

import com.smedialink.tokenplussteamid.data.entities.CommentModel
import com.smedialink.tokenplussteamid.data.entities.UserModel
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface DotaKarmaApi {

    @GET("users/me")
    fun fetchUserProfile(): Single<UserModel>

    @GET("comments")
    fun fetchComments(
            @Query("limit") limit: Int? = null,
            @Query("afterId") afterId: Int? = null
    ): Single<List<CommentModel>>
}
