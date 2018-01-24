package com.smedialink.tokenplussteamid.repository.feed

import com.smedialink.tokenplussteamid.entity.Comment
import io.reactivex.Observable

interface ICommentRepository {

    fun getCommentsFeed(limit: Int, after: Int?): Observable<List<Comment>>
}