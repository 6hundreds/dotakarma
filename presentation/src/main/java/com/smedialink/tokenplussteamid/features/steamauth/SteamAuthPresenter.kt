package com.smedialink.tokenplussteamid.features.steamauth

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class SteamAuthPresenter @Inject constructor(
        private val router: Router
) : BasePresenter<SteamAuthView>() {

    override fun attachView(view: SteamAuthView?) {
        super.attachView(view)
        viewState.initWebView()
    }

    override fun detachView(view: SteamAuthView?) {
        super.detachView(view)
        viewState.clearWebView()
    }

    fun loadSteamAuthPage() {
        viewState.displaySteamAuthWebsite()
    }
}

