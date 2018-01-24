package com.smedialink.tokenplussteamid.data.repository.feed

import com.smedialink.tokenplussteamid.data.mapper.CommentMapper
import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.repository.feed.ICommentRepository
import io.reactivex.Observable
import javax.inject.Inject

class CommentRepository @Inject constructor(
        private val api: DotaKarmaApi,
        private val mapper: CommentMapper
) : ICommentRepository {

    override fun getCommentsFeed(limit: Int, after: Int?): Observable<List<Comment>> =
            api.fetchComments(limit, after)
                    .map { t -> mapper.mapToDomain(t) }
                    .map { comment -> mapper.transform(comment) }
}
