package com.smedialink.tokenplussteamid.features.unregistered

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.app.AppScreens
import com.smedialink.tokenplussteamid.base.ErrorHandlerPresenter
import com.smedialink.tokenplussteamid.errorhandling.ErrorHandler
import com.smedialink.tokenplussteamid.usecase.comments.SendCommentByAccountIdUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by six_hundreds on 11.04.18.
 */
@InjectViewState
class UnregisteredUserPresenter @Inject constructor(
        private val useCase: SendCommentByAccountIdUseCase,
        private val router: Router,
        private val currentAccountId: Long,
        override val errorHandler: ErrorHandler)
    : ErrorHandlerPresenter<UnregisteredUserView>() {

    fun sendComment(content: String) {
        useCase.sendComment(currentAccountId, content)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showLoading(true) }
                .doFinally { viewState.showLoading(false) }
                .subscribe({ router.backTo(AppScreens.MAIN_SCREEN) }, //todo check. Will not work
                        { errorHandler.proceed(it) })
    }
}