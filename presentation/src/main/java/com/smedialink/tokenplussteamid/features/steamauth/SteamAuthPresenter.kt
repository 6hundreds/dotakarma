package com.smedialink.tokenplussteamid.features.steamauth

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.features.AppScreens
import com.smedialink.tokenplussteamid.interactor.SteamCredentialsInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class SteamAuthPresenter @Inject constructor(
        private val router: Router,
        private val interactor: SteamCredentialsInteractor
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

    fun navigateToRegistrationCompletedPage() {
        router.newRootScreen(AppScreens.REGISTRATION_SUCCESS_SCREEN)
    }

    fun saveDetectedSteamUserId(userId: String) {
        interactor
                .saveSteamUserId(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
                .also { disposable -> unsubscribeOnDestroy(disposable) }
    }
}
