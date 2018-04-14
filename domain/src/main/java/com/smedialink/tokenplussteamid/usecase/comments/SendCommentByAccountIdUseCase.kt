package com.smedialink.tokenplussteamid.usecase.comments

import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by six_hundreds on 11.04.18.
 */
class SendCommentByAccountIdUseCase @Inject constructor() {

    fun sendComment(accountId: Long, content: String): Completable = Completable.complete()
}