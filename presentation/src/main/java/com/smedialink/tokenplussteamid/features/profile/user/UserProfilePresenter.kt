package com.smedialink.tokenplussteamid.features.profile.user

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.common.lists.Paginator
import com.smedialink.tokenplussteamid.data.ext.mapList
import com.smedialink.tokenplussteamid.mapper.CommentProfileMapper
import com.smedialink.tokenplussteamid.mapper.UserMapper
import com.smedialink.tokenplussteamid.usecase.comments.GetCommentsForUserUseCase
import com.smedialink.tokenplussteamid.usecase.users.GetUserByIdUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by six_hundreds on 09.04.18.
 */
@InjectViewState
class UserProfilePresenter @Inject constructor(
        private val getUserByIdUseCase: GetUserByIdUseCase,
        private val getCommentsForUserUseCase: GetCommentsForUserUseCase,
        private val currentUserId: Int,
        private val userMapper: UserMapper,
        private val commentsMapper: CommentProfileMapper)
    : BasePresenter<UserProfileView>(), Paginator<HeterogeneousItem> {

    private var commentOffset = -1

    override fun onSuccess(items: List<HeterogeneousItem>) {
        viewState.appendComments(items)
    }

    override fun onError(error: Throwable) {
        viewState.showError(error.localizedMessage)
    }

    override fun onLoadMore(limit: Int): Single<List<HeterogeneousItem>> =
            getCommentsForUserUseCase.getComments(currentUserId, limit, commentOffset)
                    .doOnSuccess { comments -> commentOffset = comments.last().id }
                    .mapList(commentsMapper::mapToUi)

    fun getUser() {
        getUserByIdUseCase.getById(currentUserId)
                .doOnSuccess { commentOffset = it.comments.last().id }
                .map(userMapper::mapToUi)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showLoading(true) }
                .doFinally { viewState.showLoading(false) }
                .subscribe({ viewState.showProfile(it) },
                        { viewState.showError(it.localizedMessage) })
                .addTo(disposables)
    }

}