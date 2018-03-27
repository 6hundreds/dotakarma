package com.smedialink.tokenplussteamid.repository

import com.smedialink.tokenplussteamid.CachePolicy
import com.smedialink.tokenplussteamid.entity.Comment
import io.reactivex.Completable
import io.reactivex.Single

interface ICommentRepository {

    fun getAllComments(policy: CachePolicy, limit: Int = 5, after: Int? = null): Single<List<Comment>>

    fun getCommentsForUser(userId: Long, limit: Int = 5, after: Int? = null): Single<List<Comment>>

    fun getCommentById(commentId: Int): Single<Comment>
}