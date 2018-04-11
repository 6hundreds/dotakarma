package com.smedialink.tokenplussteamid.features.feed

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.common.lists.Paginator
import com.smedialink.tokenplussteamid.data.ext.mapList
import com.smedialink.tokenplussteamid.errorhandling.ErrorHandler
import com.smedialink.tokenplussteamid.mapper.CommentFeedMapper
import com.smedialink.tokenplussteamid.usecase.feed.GetFeedUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class FeedPresenter @Inject constructor(
        private val useCase: GetFeedUseCase,
        private val errorHandler: ErrorHandler,
        private val commentFeedMapper: CommentFeedMapper)
    : BasePresenter<FeedView>(), Paginator<HeterogeneousItem> {

    private var commentsOffset = -1

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        useCase.getFeed(5)
                .doOnSuccess { comments -> commentsOffset = comments.last().id }
                .mapList(commentFeedMapper::mapToUi)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showLoading(true) }
                .doFinally { viewState.showLoading(false) }
                .subscribe({ comments -> viewState.showFeed(comments) },
                        { errorHandler.proceed(it, viewState::showError) })
                .addTo(disposables)
    }

    override fun onLoadMore(limit: Int): Single<List<HeterogeneousItem>> =
            useCase.getFeed(limit, commentsOffset)
                    .doOnSuccess { comments -> commentsOffset = comments.last().id }
                    .mapList(commentFeedMapper::mapToUi)


    override fun onSuccess(items: List<HeterogeneousItem>) {
        viewState.appendFeed(items)
    }

    override fun onError(error: Throwable) {
        errorHandler.proceed(error, viewState::showError)
    }

    fun refreshFeed() {
        useCase.getFeed(5)
                .doOnSuccess { comments -> commentsOffset = comments.last().id }
                .mapList(commentFeedMapper::mapToUi)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { viewState.hideRefreshing() }
                .subscribe({ comments -> viewState.showFeed(comments) },
                        { errorHandler.proceed(it, viewState::showError) })
                .addTo(disposables)
    }
}
