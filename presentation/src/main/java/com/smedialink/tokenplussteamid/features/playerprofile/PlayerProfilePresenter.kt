package com.smedialink.tokenplussteamid.features.playerprofile

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.interactor.player.GetLocalPlayerProfile
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class PlayerProfilePresenter @Inject constructor(
    private val getLocalPlayerProfileUseCase: GetLocalPlayerProfile
) : BasePresenter<PlayerProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        getLocalPlayerProfileUseCase
            .execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ player ->
                viewState.displayProfile(player)
            }, { error ->
                Timber.d("Error: ${error.message}")
            })
    }
}
