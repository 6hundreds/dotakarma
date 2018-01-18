package com.smedialink.tokenplussteamid.features.feed

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.interactor.feed.GetCommentsFeed
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class FeedPresenter @Inject constructor(
    private val getCommentsFeedUseCase: GetCommentsFeed
) : BasePresenter<FeedView>() {

    private var latestCommentId = -1

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        getCommentsFeedUseCase
            .execute(GetCommentsFeed.Params(limit = 10, after = 1))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ comments ->
                Timber.d("Loaded comments: $comments")
                latestCommentId = comments.first().id
                Timber.d("Newest comment id: $latestCommentId")
            }, { error ->
                Timber.e("Loading error: ${error.message}")
            })
    }
}