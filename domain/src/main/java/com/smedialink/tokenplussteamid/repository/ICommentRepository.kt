package com.smedialink.tokenplussteamid.repository

import com.smedialink.tokenplussteamid.entity.Comment
import io.reactivex.Completable
import io.reactivex.Single

interface ICommentRepository {

    fun getAllComments(limit: Int, after: Int?): Single<List<Comment>>

    fun getCommentsForUser(userId: Int, limit: Int, after: Int?): Single<List<Comment>>

    fun getCommentById(commentId: Int): Single<Comment>

    fun replyToComment(commentId: Int, content: String): Completable
}