package com.smedialink.tokenplussteamid.usecase.comments

import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.repository.ICommentRepository
import com.smedialink.tokenplussteamid.usecase.SingleUseCaseWithParameter
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 09.02.18.
 */
class GetCommentsForUserUseCase @Inject constructor(
        private val repository: ICommentRepository)
    : SingleUseCaseWithParameter<GetCommentsForUserUseCase.Params, List<Comment>> {

    override fun execute(parameter: Params): Single<List<Comment>> =
            repository.getCommentsForUser(parameter.userId, parameter.limit, parameter.after)


    class Params(val userId: Long, val limit: Int = 10, val after: Int? = null)
}