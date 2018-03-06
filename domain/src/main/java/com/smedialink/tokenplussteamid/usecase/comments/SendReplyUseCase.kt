package com.smedialink.tokenplussteamid.usecase.comments

import com.smedialink.tokenplussteamid.repository.ICommentRepository
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by Sergey Opivalov on 05/03/2018.
 */
class SendReplyUseCase @Inject constructor(private val repository: ICommentRepository) {

    fun sendReply(content: String, commentId: Int): Completable {
        return Completable.complete()
    }

}