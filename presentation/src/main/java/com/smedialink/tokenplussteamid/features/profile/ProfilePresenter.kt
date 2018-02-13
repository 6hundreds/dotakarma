package com.smedialink.tokenplussteamid.features.profile

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.common.lists.Paginator
import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.features.profile.entity.CommentProfileUiModel
import com.smedialink.tokenplussteamid.mapper.CommentProfileMapper
import com.smedialink.tokenplussteamid.usecase.me.GetMyProfileUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class ProfilePresenter @Inject constructor(
        private val getMyProfileUseCase: GetMyProfileUseCase,
        private val mapper: CommentProfileMapper
) : BasePresenter<ProfileView>(), Paginator<HeterogeneousItem> {

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
