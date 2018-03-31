package com.smedialink.tokenplussteamid.data.repository

import com.smedialink.tokenplussteamid.CachePolicy
import com.smedialink.tokenplussteamid.data.dao.CommentDao
import com.smedialink.tokenplussteamid.data.entity.CommentModel
import com.smedialink.tokenplussteamid.data.mapper.CommentListMapper
import com.smedialink.tokenplussteamid.data.mapper.CommentMapper
import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.repository.ICommentRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class CommentRepository @Inject constructor(
        private val api: DotaKarmaApi,
        private val dao: CommentDao,
        private val listMapper: CommentListMapper,
        private val mapper: CommentMapper
) : ICommentRepository {

    override fun replyToComment(commentId: Int, content: String): Completable =
            api.replyToComment(commentId, content)

    override fun getCommentById(commentId: Int): Single<Comment> =
            dao.getById(commentId)
                    .map(mapper)

    override fun getCommentsForUser(userId: Long, limit: Int, after: Int?): Single<List<Comment>> {
        return Single.error(Throwable())
    }

    override fun getAllComments(policy: CachePolicy, limit: Int, after: Int?): Single<List<Comment>> =
            api.fetchComments(limit, after, null)
                    .map { listMapper.mapToDomain(it) }
}
