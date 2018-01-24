package com.smedialink.tokenplussteamid.interactor.feed

import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.interactor.UseCaseWithParameter
import com.smedialink.tokenplussteamid.repository.feed.ICommentRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetCommentsFeed @Inject constructor(
    private val repository: ICommentRepository
) : UseCaseWithParameter<GetCommentsFeed.Params, List<Comment>> {

    override fun execute(parameter: Params): Observable<List<Comment>> =
        repository
            .getCommentsFeed(parameter.limit, parameter.after)

    class Params(val limit: Int = 10, val after: Int? = null)
}
