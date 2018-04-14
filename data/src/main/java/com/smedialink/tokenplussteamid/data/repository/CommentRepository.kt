package com.smedialink.tokenplussteamid.data.repository

import com.smedialink.tokenplussteamid.data.entity.CommentModel
import com.smedialink.tokenplussteamid.data.ext.mapList
import com.smedialink.tokenplussteamid.data.mapper.CommentMapper
import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import com.smedialink.tokenplussteamid.data.persistence.RealmManager
import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.repository.ICommentRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class CommentRepository @Inject constructor(
        private val api: DotaKarmaApi,
        private val realm: RealmManager,
        private val mapper: CommentMapper
) : ICommentRepository {

    override fun replyToComment(commentId: Int, content: String): Completable =
            api.replyToComment(commentId, content)

    override fun getCommentById(commentId: Int): Single<Comment> =
            realm.findOneAsync<CommentModel>("id", commentId)
                    .map { mapper.mapToDomain(it) }

    override fun getCommentsForUser(userId: Int, limit: Int, after: Int?): Single<List<Comment>> {
        return Single.error(Throwable())
    }

    override fun getAllComments(limit: Int, after: Int?): Single<List<Comment>> =
            api.fetchComments(limit, after, null)
                    .mapList(mapper::mapToDomain)
}
