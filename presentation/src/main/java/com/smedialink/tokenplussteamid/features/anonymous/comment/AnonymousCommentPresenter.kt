package com.smedialink.tokenplussteamid.features.anonymous.comment

import com.smedialink.tokenplussteamid.base.ErrorHandlerPresenter
import com.smedialink.tokenplussteamid.errorhandling.ErrorHandler
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by six_hundreds on 12.04.18.
 */
class AnonymousCommentPresenter @Inject constructor(
        private val router: Router,
        override val errorHandler: ErrorHandler)
    : ErrorHandlerPresenter<AnonymousCommentView>() {

    fun validateAccountId(accountId : Long) {

    }

}