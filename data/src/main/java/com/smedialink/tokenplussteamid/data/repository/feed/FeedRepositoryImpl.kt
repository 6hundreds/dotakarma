package com.smedialink.tokenplussteamid.data.repository.feed

import com.smedialink.tokenplussteamid.data.mapper.FeedCommentMapper
import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import com.smedialink.tokenplussteamid.entity.FeedComment
import com.smedialink.tokenplussteamid.repository.feed.FeedRepository
import io.reactivex.Observable
import javax.inject.Inject

class FeedRepositoryImpl @Inject constructor(
    private val api: DotaKarmaApi,
    private val mapper: FeedCommentMapper
) : FeedRepository {

    override fun getCommentsFeed(limit: Int, after: Int): Observable<List<FeedComment>> =
        api
            .fetchCommentsFeed()
            .map { comment -> mapper.transform(comment) }
}