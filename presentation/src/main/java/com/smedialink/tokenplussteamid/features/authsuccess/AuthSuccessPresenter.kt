package com.smedialink.tokenplussteamid.features.authsuccess

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.data.manager.SettingsManager
import com.smedialink.tokenplussteamid.data.repository.DataStoreStrategy
import com.smedialink.tokenplussteamid.entity.RegisteredPlayer
import com.smedialink.tokenplussteamid.repository.RegisteredPlayerRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class AuthSuccessPresenter @Inject constructor(
        private val settingsManager: SettingsManager,
        private val repository: RegisteredPlayerRepository
) : BasePresenter<AuthSuccessView>() {

    fun saveToken(token: String) {
        settingsManager.saveToken(token)
    }

    fun loadProfile() {
        repository
                .loadUserProfile(DataStoreStrategy.REMOTE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ player: RegisteredPlayer? ->
                    player?.let { it -> Timber.d("Loaded profile: $it") }
                }, { error ->
                    Timber.d("Loading error: ${error.message}")
                })
    }
}
