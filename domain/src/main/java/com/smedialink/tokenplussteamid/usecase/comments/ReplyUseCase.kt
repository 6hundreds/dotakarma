package com.smedialink.tokenplussteamid.usecase.comments

import com.smedialink.tokenplussteamid.manager.IProfileManager
import com.smedialink.tokenplussteamid.repository.ICommentRepository
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by Sergey Opivalov on 05/03/2018.
 */
class ReplyUseCase @Inject constructor(private val repository: ICommentRepository,
                                       private val manager: IProfileManager) {

    fun sendReply(content: String, commentId: Int): Completable =
            repository.replyToComment(commentId, content)

}