package com.smedialink.tokenplussteamid.repository

import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.CachePolicy
import io.reactivex.Single

interface ICommentRepository {

    fun getAllComments(policy: CachePolicy, limit: Int, after: Int?): Single<List<Comment>>

    fun getCommentsForUser(userId: Long, limit: Int, after: Int?): Single<List<Comment>>
}