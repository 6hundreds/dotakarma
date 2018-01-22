package com.smedialink.tokenplussteamid.interactor.feed

import com.smedialink.tokenplussteamid.entity.FeedComment
import com.smedialink.tokenplussteamid.interactor.UseCaseWithParameter
import com.smedialink.tokenplussteamid.repository.feed.FeedRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetCommentsFeed @Inject constructor(
    private val repository: FeedRepository
) : UseCaseWithParameter<GetCommentsFeed.Params, List<FeedComment>> {

    override fun execute(parameter: Params): Observable<List<FeedComment>> =
        repository
            .getCommentsFeed(parameter.limit, parameter.after)

    class Params(val limit: Int = 10, val after: Int? = null)
}
