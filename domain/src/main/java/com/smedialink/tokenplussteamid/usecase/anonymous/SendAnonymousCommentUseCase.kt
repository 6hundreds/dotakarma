package com.smedialink.tokenplussteamid.usecase.anonymous

import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by six_hundreds on 16.04.18.
 */
class SendAnonymousCommentUseCase @Inject constructor() {

    fun sendComment(accountId: Long, content: String): Completable =
            Completable.complete()
}