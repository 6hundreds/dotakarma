package com.smedialink.tokenplussteamid.usecase.comments

import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.repository.ICommentRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 09.04.18.
 */
class GetCommentsForUserUseCase @Inject constructor(
        private val commentRepository: ICommentRepository) {

    fun getComments(userId: Int, limit: Int = 5, after: Int? = null): Single<List<Comment>> =
            commentRepository.getCommentsForUser(userId, limit, after)
}