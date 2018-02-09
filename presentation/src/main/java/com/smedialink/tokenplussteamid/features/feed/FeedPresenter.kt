package com.smedialink.tokenplussteamid.features.feed

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.common.HeterogeneousItem
import com.smedialink.tokenplussteamid.common.Paginator
import com.smedialink.tokenplussteamid.mapper.CommentMapper
import com.smedialink.tokenplussteamid.usecase.comments.GetCommentsUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class FeedPresenter @Inject constructor(private val useCase: GetCommentsUseCase,
                                        private val commentMapper: CommentMapper)
    : BasePresenter<FeedView>(), Paginator<HeterogeneousItem> {

    private var latestCommentId = -1

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        useCase.execute(GetCommentsUseCase.Params(5))
                .doOnSuccess { comments -> latestCommentId = comments.last().id }
                .map(commentMapper)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showLoading(true) }
                .doFinally { viewState.showLoading(false) }
                .subscribe({ comments -> viewState.refreshFeed(comments) },
                        { error -> viewState.showError(error.localizedMessage) })
                .addTo(disposables)
    }

    override fun onLoadMore(limit: Int): Single<List<HeterogeneousItem>> =
            useCase.execute(GetCommentsUseCase.Params(limit, latestCommentId))
                    .doOnSuccess { comments -> latestCommentId = comments.last().id }
                    .map(commentMapper)


    override fun onSuccess(items: List<HeterogeneousItem>) {
        viewState.appendFeed(items)
    }

    override fun onError(error: Throwable) {
        viewState.showError(error.localizedMessage)
    }

    fun refreshFeed() {
        useCase.execute(GetCommentsUseCase.Params(5))
                .doOnSuccess { comments -> latestCommentId = comments.last().id }
                .map(commentMapper)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { viewState.hideRefresh() }
                .subscribe({ comments -> viewState.refreshFeed(comments) },
                        { error -> viewState.showError(error.localizedMessage) })
                .addTo(disposables)
    }
}
