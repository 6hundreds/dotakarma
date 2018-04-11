package com.smedialink.tokenplussteamid.features.reply

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.common.OnResultCode
import com.smedialink.tokenplussteamid.di.qualifier.LocalNavigation
import com.smedialink.tokenplussteamid.errorhandling.ErrorHandler
import com.smedialink.tokenplussteamid.usecase.comments.GetCommentByIdUseCase
import com.smedialink.tokenplussteamid.usecase.comments.ReplyToCommentUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by six_hundreds on 24.02.18.
 */
@InjectViewState
class ReplyToCommentPresenter @Inject constructor(
        private val replyToCommentUseCase: ReplyToCommentUseCase,
        private val getCommentByIdUseCase: GetCommentByIdUseCase,
        private val currentCommentId: Int,
        private val errorHandler: ErrorHandler,
        @LocalNavigation private val router: Router)
    : BasePresenter<ReplyToCommentView>() {

    fun getCommentById(commentId: Int) {
        getCommentByIdUseCase.getCommentById(commentId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess { viewState.showLoading(true) }
                .doFinally { viewState.showLoading(false) }
                .subscribe({ viewState.showComment(it) },
                        { errorHandler.proceed(it, viewState::showError) })
    }

    fun replyToComment(content: String) {
        replyToCommentUseCase.sendReply(content, currentCommentId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showLoading(true) }
                .doFinally { viewState.showLoading(false) }
                .subscribe({ router.exitWithResult(OnResultCode.REPLY_SUCCESS, null) },
                        { errorHandler.proceed(it, viewState::showError) })
    }

    fun onBackPressed() {
        router.exit()
    }
}