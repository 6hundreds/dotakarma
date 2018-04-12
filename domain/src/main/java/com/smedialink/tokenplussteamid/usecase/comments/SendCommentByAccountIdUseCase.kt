package com.smedialink.tokenplussteamid.usecase.comments

import io.reactivex.Completable

/**
 * Created by six_hundreds on 11.04.18.
 */
class SendCommentByAccountIdUseCase {

    fun sendComment(accountId: Long, content: String): Completable = Completable.complete()
}