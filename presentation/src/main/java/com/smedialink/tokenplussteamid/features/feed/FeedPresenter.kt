package com.smedialink.tokenplussteamid.features.feed

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.mapper.CommentMapper
import com.smedialink.tokenplussteamid.usecase.comments.GetCommentsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class FeedPresenter @Inject constructor(private val useCase: GetCommentsUseCase,
                                        private val commentMapper: CommentMapper)
    : BasePresenter<FeedView>() {

    private var latestCommentId = -1

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        useCase.execute(GetCommentsUseCase.Params())
                .map(commentMapper)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ comments -> viewState.updateFeed(comments) },
                        { error -> Timber.e("Loading error: ${error.message}") })
    }
}
