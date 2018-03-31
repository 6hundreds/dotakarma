package com.smedialink.tokenplussteamid.features.auth

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class SteamAuthPresenter @Inject constructor() : BasePresenter<SteamAuthView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showSteamPage()
    }
}
