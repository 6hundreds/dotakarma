package com.smedialink.tokenplussteamid.features.profile

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.CachePolicy
import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.common.HeterogeneousItem
import com.smedialink.tokenplussteamid.common.Paginator
import com.smedialink.tokenplussteamid.usecase.user.GetUserUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class ProfilePresenter @Inject constructor(
        private val getUserUseCase: GetUserUseCase
) : BasePresenter<ProfileView>(), Paginator<HeterogeneousItem> {

    private var mySteamId: Long = -1L

    private var latestCommentId = -1L

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getUserUseCase.execute(CachePolicy.LOCAL)
                .doOnSuccess { mySteamId = it.steamId }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showLoading(true) }
                .doFinally { viewState.showLoading(false) }
                .subscribe({ viewState.showProfile(it) },
                        { viewState.showError(it.localizedMessage) })

    }

    override fun onLoadMore(limit: Int): Single<List<HeterogeneousItem>> {
        return Single.error(Throwable())
    }


    override fun onSuccess(items: List<HeterogeneousItem>) {
        viewState.updateComments(items, true)

    }

    override fun onError(error: Throwable) {
        viewState.showError(error.localizedMessage)
    }

}
