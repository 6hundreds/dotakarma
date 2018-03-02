package com.smedialink.tokenplussteamid.features.reply

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.di.qualifier.LocalNavigation
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by six_hundreds on 24.02.18.
 */
@InjectViewState
class ReplyToCommentPresenter @Inject constructor(
        @LocalNavigation
        private val router: Router)
    : BasePresenter<ReplyToCommentView>() {

    fun getCommentConversation(commentId: Int) {}

    fun sendComment(comment: String) {

    }

    fun onBackPressed() {
        router.exit()
    }
}