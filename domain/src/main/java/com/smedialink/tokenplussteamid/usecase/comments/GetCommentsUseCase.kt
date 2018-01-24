package com.smedialink.tokenplussteamid.usecase.comments

import com.smedialink.tokenplussteamid.CachePolicy
import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.usecase.SingleUseCaseWithParameter
import com.smedialink.tokenplussteamid.repository.ICommentRepository
import io.reactivex.Single
import javax.inject.Inject

class GetCommentsUseCase @Inject constructor(
        private val repository: ICommentRepository
) : SingleUseCaseWithParameter<GetCommentsUseCase.Params, List<Comment>> {

    override fun execute(parameter: Params): Single<List<Comment>> =
            repository.getComments(CachePolicy.REMOTE, parameter.limit, parameter.after)

    class Params(val limit: Int = 10, val after: Int? = null)
}
