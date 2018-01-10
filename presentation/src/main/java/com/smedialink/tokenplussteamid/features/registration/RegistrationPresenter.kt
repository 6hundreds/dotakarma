package com.smedialink.tokenplussteamid.features.registration

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.features.AppScreens
import com.smedialink.tokenplussteamid.interactor.RegistrationInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class RegistrationPresenter @Inject constructor(
        private val router: Router,
        private val interactor: RegistrationInteractor
) : BasePresenter<RegistrationView>() {

    fun performRegistration(login: String, password: String) {

        interactor
                .performRegistration(login, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Timber.i("Registration completed.")
                    router.newRootScreen(AppScreens.EMPTY_STEP_SCREEN)
                }, { throwable ->
                    Timber.e("Registration error: ${throwable.message}")
                })
                .also { disposable -> unsubscribeOnDestroy(disposable) }
    }
}
