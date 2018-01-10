package com.smedialink.tokenplussteamid.features.registration

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.interactor.RegistrationInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class RegistrationPresenter @Inject constructor(
        private val interactor: RegistrationInteractor
) : BasePresenter<RegistrationView>() {

    fun performRegistration(login: String, password: String) {

        interactor
                .performRegistration(login, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Timber.d("Registration completed.")
                }, { throwable ->
                    Timber.d("Registration error: ${throwable.message}")
                })
                .also { disposable -> unsubscribeOnDestroy(disposable) }
    }
}
