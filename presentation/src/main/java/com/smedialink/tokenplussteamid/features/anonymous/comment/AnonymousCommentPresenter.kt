package com.smedialink.tokenplussteamid.features.anonymous.comment

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.ErrorHandlerPresenter
import com.smedialink.tokenplussteamid.errorhandling.ErrorHandler
import com.smedialink.tokenplussteamid.usecase.anonymous.SendAnonymousCommentUseCase
import com.smedialink.tokenplussteamid.usecase.anonymous.FindAnonymousUserUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by six_hundreds on 12.04.18.
 */
@InjectViewState
class AnonymousCommentPresenter @Inject constructor(
        private val router: Router,
        override val errorHandler: ErrorHandler,
        private val findAnonymousUserUseCase: FindAnonymousUserUseCase,
        private val sendAnonymousCommentUseCase: SendAnonymousCommentUseCase)
    : ErrorHandlerPresenter<AnonymousCommentView>() {

    fun validateAccountId(accountId: Long) {
        findAnonymousUserUseCase.findUser(accountId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showValidationProgress(true) }
                .doFinally { viewState.showValidationProgress(false) }
                .subscribe({ viewState.onValidationSuccess(it) }, { errorHandler.proceed(it) })
    }

    fun sendCommentForAnonymous(accountId: Long, content: String) {
        sendAnonymousCommentUseCase.sendComment(accountId, content)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showLoading(true) }
                .doFinally { viewState.showLoading(false) }
                .subscribe({ viewState.onCommentSuccess() }, { errorHandler.proceed(it) })
    }
}