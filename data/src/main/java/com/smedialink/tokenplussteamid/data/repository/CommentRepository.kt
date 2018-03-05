package com.smedialink.tokenplussteamid.data.repository

import com.smedialink.tokenplussteamid.CachePolicy
import com.smedialink.tokenplussteamid.data.dao.CommentDao
import com.smedialink.tokenplussteamid.data.entity.CommentModel
import com.smedialink.tokenplussteamid.data.mapper.CommentListMapper
import com.smedialink.tokenplussteamid.data.mapper.CommentMapper
import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.repository.ICommentRepository
import io.reactivex.Single
import javax.inject.Inject

class CommentRepository @Inject constructor(
        private val api: DotaKarmaApi,
        private val dao: CommentDao,
        private val listMapper: CommentListMapper,
        private val mapper: CommentMapper
) : ICommentRepository {

    val mock = arrayListOf(
            CommentModel(1, "Comment1", 1, "12.03.2018", "", 0, 0),
            CommentModel(2, "Comment2", 1, "12.03.2018", "", 0, 0),
            CommentModel(3, "Comment3", 1, "12.03.2018", "", 0, 0),
            CommentModel(4, "Comment4", 1, "12.03.2018", "", 0, 0),
            CommentModel(5, "Comment5", 1, "12.03.2018", "", 0, 0),
            CommentModel(6, "Comment6", 1, "12.03.2018", "", 0, 0),
            CommentModel(7, "Comment7", 1, "12.03.2018", "", 0, 0),
            CommentModel(8, "Comment8", 1, "12.03.2018", "", 0, 0),
            CommentModel(9, "Comment9", 1, "12.03.2018", "", 0, 0),
            CommentModel(10, "Comment10", 1, "12.03.2018", "", 0, 0),
            CommentModel(11, "Comment11", 1, "12.03.2018", "", 0, 0)
    )

    override fun getCommentById(commentId: Int): Single<Comment> =
            dao.getById(commentId)
                    .map(mapper)


    override fun getCommentsForUser(userId: Long, limit: Int, after: Int?): Single<List<Comment>> {
        return Single.error(Throwable())
    }

    override fun getAllComments(policy: CachePolicy, limit: Int, after: Int?): Single<List<Comment>> =
            Single.just(listMapper.mapToDomain(mock))
//            api.fetchComments(limit, after, null)
//                    .map { listMapper.mapToDomain(it) }

}
