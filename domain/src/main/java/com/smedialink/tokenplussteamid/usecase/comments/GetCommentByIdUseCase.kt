package com.smedialink.tokenplussteamid.usecase.comments

import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.repository.ICommentRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 05.03.18.
 */
class GetCommentByIdUseCase @Inject constructor(private val repository: ICommentRepository) {

    fun getCommentById(commentId: Int): Single<Comment> =
            repository.getCommentById(commentId)
}