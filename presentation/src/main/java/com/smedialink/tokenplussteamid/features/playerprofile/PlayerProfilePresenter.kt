package com.smedialink.tokenplussteamid.features.playerprofile

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.CachePolicy
import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.usecase.user.GetUserUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class PlayerProfilePresenter @Inject constructor(private val getLocalPlayerProfileUseCase: GetUserUseCase)
    : BasePresenter<PlayerProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        getLocalPlayerProfileUseCase
                .execute(CachePolicy.LOCAL)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ player ->
                    viewState.displayProfile(player)
                }, { error ->
                    Timber.d("Error: ${error.message}")
                })
    }
}
