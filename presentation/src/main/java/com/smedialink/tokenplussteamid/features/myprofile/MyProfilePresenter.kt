package com.smedialink.tokenplussteamid.features.myprofile

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.app.AppScreens
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.common.OnResultCode
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.common.lists.Paginator
import com.smedialink.tokenplussteamid.data.ext.mapList
import com.smedialink.tokenplussteamid.di.qualifier.LocalNavigation
import com.smedialink.tokenplussteamid.mapper.CommentProfileMapper
import com.smedialink.tokenplussteamid.mapper.ProfileMapper
import com.smedialink.tokenplussteamid.usecase.me.GetMyProfileUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MyProfilePresenter @Inject constructor(
        private val getMyProfileUseCase: GetMyProfileUseCase,
        private val commentsMapper: CommentProfileMapper,
        private val profileMapper: ProfileMapper,
        @LocalNavigation private val router: Router
) : BasePresenter<MyProfileView>(), Paginator<HeterogeneousItem> {

    private var latestCommentId = -1

    init {
        getMyProfileUseCase.getLiveComments()
                .mapList(commentsMapper::mapToUi)
                .subscribe({ viewState.showComments(it) })
//        router.setResultListener(OnResultCode.REPLY_SUCCESS) {
//            getMyProfileUseCase.getMyComments()
//                    .doOnSuccess { latestCommentId = it.last().id }
//                    .mapList(commentsMapper::mapToUi)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .doOnSubscribe { viewState.showLoading(true) }
//                    .doFinally { viewState.showLoading(false) }
//                    .subscribe({ viewState.showComments(it) },
//                            { viewState.showError(it.localizedMessage) })
//                    .addTo(disposables)
//        }
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getMyProfileUseCase.getMyProfile()
                .doOnSuccess { latestCommentId = it.second.last().id }
                .map(profileMapper::mapToUi)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showLoading(true) }
                .doFinally { viewState.showLoading(false) }
                .subscribe({
                    viewState.showProfile(it.user)
                    viewState.showComments(it.comments)
                },
                        { viewState.showError(it.localizedMessage) })
                .addTo(disposables)

    }

    override fun onLoadMore(limit: Int): Single<List<HeterogeneousItem>> =
            getMyProfileUseCase.getMyComments(limit, latestCommentId)
                    .doOnSuccess { comments -> latestCommentId = comments.last().id }
                    .mapList(commentsMapper::mapToUi)

    override fun onSuccess(items: List<HeterogeneousItem>) {
        viewState.appendComments(items)
    }

    override fun onError(error: Throwable) {
        viewState.showError(error.localizedMessage)
    }

    override fun onDestroy() {
        super.onDestroy()
        router.removeResultListener(OnResultCode.REPLY_SUCCESS)
    }

    fun refreshProfile() {
        getMyProfileUseCase.getMyProfile()
                .doOnSuccess { latestCommentId = it.second.last().id }
                .map(profileMapper::mapToUi)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { viewState.hideRefreshing() }
                .subscribe({
                    viewState.showProfile(it.user)
                    viewState.showComments(it.comments)
                },
                        { viewState.showError(it.localizedMessage) })
                .addTo(disposables)
    }

    fun onCommentClicked(id: Int) {
        router.navigateTo(AppScreens.REPLY_TO_COMMENT_SCREEN, id)
    }
}
