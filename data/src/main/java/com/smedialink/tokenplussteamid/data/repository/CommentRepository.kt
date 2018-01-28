package com.smedialink.tokenplussteamid.data.repository

import com.smedialink.tokenplussteamid.data.dao.CommentDao
import com.smedialink.tokenplussteamid.data.mapper.CommentMapper
import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.CachePolicy
import com.smedialink.tokenplussteamid.repository.ICommentRepository
import io.reactivex.Single
import javax.inject.Inject

class CommentRepository @Inject constructor(
        private val api: DotaKarmaApi,
        private val dao: CommentDao,
        private val mapper: CommentMapper
) : ICommentRepository {

    override fun getComments(policy: CachePolicy, limit: Int, after: Int?): Single<List<Comment>> =
            api.fetchComments(limit, after)
                    .map { mapper.mapToDomain(it) }

}
