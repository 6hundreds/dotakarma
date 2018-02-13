package com.smedialink.tokenplussteamid.usecase.feed

import com.smedialink.tokenplussteamid.CachePolicy
import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.repository.ICommentRepository
import io.reactivex.Single
import javax.inject.Inject

class GetFeedUseCase @Inject constructor(private val repository: ICommentRepository) {

    fun getFeed(limit: Int = 10, after: Int? = null): Single<List<Comment>> =
            repository.getAllComments(CachePolicy.REMOTE, limit, after)
}
