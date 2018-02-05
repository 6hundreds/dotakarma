package com.smedialink.tokenplussteamid.features.auth

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.basic.BasePresenter
import javax.inject.Inject

@InjectViewState
class SteamAuthPresenter @Inject constructor() : BasePresenter<SteamAuthView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        performSteamAuth()
    }

    override fun attachView(view: SteamAuthView?) {
        super.attachView(view)
        viewState.initWebView()
    }

    override fun detachView(view: SteamAuthView?) {
        super.detachView(view)
        viewState.clearWebView()
    }

    private fun performSteamAuth() {
        viewState.displaySteamAuthWebsite()
    }
}
