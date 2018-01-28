package com.smedialink.tokenplussteamid.features.authsuccess

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.data.manager.SessionManager
import com.smedialink.tokenplussteamid.usecase.user.GetRemotePlayerProfile
import com.smedialink.tokenplussteamid.usecase.user.StoreUserUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class AuthSuccessPresenter @Inject constructor(
    private val sessionManager: SessionManager,
    private val getRemoteProfileUseCase: GetRemotePlayerProfile,
    private val saveAsLocalProfileUseCase: StoreUserUseCase
) : BasePresenter<AuthSuccessView>() {

    fun saveToken(token: String) {
        sessionManager.openSession(token)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        fetchPlayerProfile()

    }

    private fun fetchPlayerProfile() {
        getRemoteProfileUseCase
            .execute()
            .flatMapCompletable { player -> saveAsLocalProfileUseCase.execute(player) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Timber.d("User profile obtained successfully.")
            }, { error ->
                Timber.e("Error: ${error.message}")
            })
            .addTo(disposables)
    }
}
