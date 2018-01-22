package com.smedialink.tokenplussteamid.repository.feed

import com.smedialink.tokenplussteamid.entity.FeedComment
import io.reactivex.Observable

interface FeedRepository {

    fun getCommentsFeed(limit: Int, after: Int?): Observable<List<FeedComment>>
}