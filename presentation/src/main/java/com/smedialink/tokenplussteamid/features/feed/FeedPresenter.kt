package com.smedialink.tokenplussteamid.features.feed

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.usecase.comments.GetCommentsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class FeedPresenter @Inject constructor(
    private val getCommentsUseCaseUseCase: GetCommentsUseCase
) : BasePresenter<FeedView>() {

    private var latestCommentId = -1

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        getCommentsUseCaseUseCase
            .execute(GetCommentsUseCase.Params(limit = 5))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ comments ->
                Timber.d("Loaded comments: $comments")
                latestCommentId = comments.first().id
                Timber.d("Newest comment id: $latestCommentId")
                viewState.appendFeedContent(comments)
            }, { error ->
                Timber.e("Loading error: ${error.message}")
            })
    }
}
