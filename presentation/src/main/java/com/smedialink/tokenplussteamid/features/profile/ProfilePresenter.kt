package com.smedialink.tokenplussteamid.features.profile

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.CachePolicy
import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.usecase.user.GetUserUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class ProfilePresenter @Inject constructor(private val getUserUseCase: GetUserUseCase)
    : BasePresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        getUserUseCase.execute(CachePolicy.LOCAL)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ player ->
                    viewState.displayProfile(player)
                }, { error ->
                    Timber.d("Error: ${error.message}")
                })

    }
}
