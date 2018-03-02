package com.smedialink.tokenplussteamid.features.myprofile

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.common.lists.Paginator
import com.smedialink.tokenplussteamid.di.qualifier.LocalNavigation
import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.features.AppScreens
import com.smedialink.tokenplussteamid.features.myprofile.entity.CommentProfileUiModel
import com.smedialink.tokenplussteamid.mapper.CommentProfileMapper
import com.smedialink.tokenplussteamid.usecase.me.GetMyProfileUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MyProfilePresenter @Inject constructor(
        private val getMyProfileUseCase: GetMyProfileUseCase,
        private val mapper: CommentProfileMapper,
        @LocalNavigation
        private val router: Router
) : BasePresenter<MyProfileView>(), Paginator<HeterogeneousItem> {

    private var latestCommentId = -1

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        Single.zip(getMyProfileUseCase.getProfile(),
                getMyProfileUseCase.getComments()
                        .doOnSuccess { latestCommentId = it.last().id }
                        .map(mapper),
                BiFunction { user: User, comments: List<CommentProfileUiModel> -> Pair(user, comments) })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showLoading(true) }
                .doFinally { viewState.showLoading(false) }
                .subscribe({
                    viewState.showProfile(it.first)
                    viewState.showComments(it.second)
                },
                        { viewState.showError(it.localizedMessage) })
                .addTo(disposables)

    }

    fun onCommentClicked(id: Int) {
        router.navigateTo(AppScreens.REPLY_TO_COMMENT_SCREEN, id)
    }

    override fun onLoadMore(limit: Int): Single<List<HeterogeneousItem>> =
            getMyProfileUseCase.getComments(limit, latestCommentId)
                    .doOnSuccess { comments -> latestCommentId = comments.last().id }
                    .map(mapper)

    override fun onSuccess(items: List<HeterogeneousItem>) {
        viewState.appendComments(items)
    }

    override fun onError(error: Throwable) {
        viewState.showError(error.localizedMessage)
    }

    fun refreshProfile() {
        Single.zip(getMyProfileUseCase.getProfile(),
                getMyProfileUseCase.getComments()
                        .doOnSuccess { latestCommentId = it.last().id }
                        .map(mapper),
                BiFunction { user: User, comments: List<CommentProfileUiModel> -> Pair(user, comments) })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { viewState.hideRefreshing() }
                .subscribe({
                    viewState.showProfile(it.first)
                    viewState.showComments(it.second)
                },
                        { viewState.showError(it.localizedMessage) })
                .addTo(disposables)
    }
}
