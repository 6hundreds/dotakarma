package com.smedialink.tokenplussteamid.features.reply

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.di.qualifier.LocalNavigation
import com.smedialink.tokenplussteamid.usecase.comments.GetCommentByIdUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by six_hundreds on 24.02.18.
 */
@InjectViewState
class ReplyToCommentPresenter @Inject constructor(
        private val getCommentByIdUseCase: GetCommentByIdUseCase,
        @LocalNavigation private val router: Router)
    : BasePresenter<ReplyToCommentView>() {

    fun getCommentById(commentId: Int) {
        getCommentByIdUseCase.getCommentById(commentId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess { viewState.showLoading(true) }
                .doFinally { viewState.showLoading(false) }
                .subscribe({ viewState.showComment(it) }, { viewState.showError(it.localizedMessage) })
    }


    fun sendComment(comment: String) {

    }

    fun onBackPressed() {
        router.exit()
    }
}