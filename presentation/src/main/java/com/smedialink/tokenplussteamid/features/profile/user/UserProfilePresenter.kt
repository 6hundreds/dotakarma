package com.smedialink.tokenplussteamid.features.profile.user

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.app.AppScreens
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.common.lists.Paginator
import com.smedialink.tokenplussteamid.data.ext.mapList
import com.smedialink.tokenplussteamid.di.qualifier.LocalErrorHandler
import com.smedialink.tokenplussteamid.errorhandling.ErrorHandler
import com.smedialink.tokenplussteamid.mapper.CommentProfileMapper
import com.smedialink.tokenplussteamid.mapper.UserMapper
import com.smedialink.tokenplussteamid.usecase.comments.GetCommentsForUserUseCase
import com.smedialink.tokenplussteamid.usecase.users.GetUserByAccountIdUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by six_hundreds on 09.04.18.
 */
@InjectViewState
class UserProfilePresenter @Inject constructor(
        private val getUserByAccountIdUseCase: GetUserByAccountIdUseCase,
        private val getCommentsForUserUseCase: GetCommentsForUserUseCase,
        private val currentAccountId: Long,
        private val userMapper: UserMapper,
        private val commentsMapper: CommentProfileMapper,
        @LocalErrorHandler override val errorHandler: ErrorHandler,
        private val router: Router)
    : BasePresenter<UserProfileView>(), Paginator<HeterogeneousItem> {

    private var commentOffset = -1

    override fun onSuccess(items: List<HeterogeneousItem>) {
        viewState.appendComments(items)
    }

    override fun onError(error: Throwable) {
        errorHandler.proceed(error)
    }

    override fun onLoadMore(limit: Int): Single<List<HeterogeneousItem>> =
            getCommentsForUserUseCase.getComments(1, limit, commentOffset) //todo 1 is a stub
                    .doOnSuccess { comments -> commentOffset = comments.last().id }
                    .mapList(commentsMapper::mapToUi)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getUserByAccountIdUseCase.getByAccountId(currentAccountId)
                .doOnSuccess { commentOffset = it.comments.last().id }
                .map(userMapper::mapToUi)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showLoading(true) }
                .doFinally { viewState.showLoading(false) }
                .subscribe({ viewState.showProfile(it) }, { errorHandler.proceed(it) })
                .addTo(disposables)
    }

    override fun detachView(view: UserProfileView?) {
        super.detachView(view)
        errorHandler.detachView()
    }

    override fun attachView(view: UserProfileView) {
        super.attachView(view)
        errorHandler.attachView(view)
    }
}