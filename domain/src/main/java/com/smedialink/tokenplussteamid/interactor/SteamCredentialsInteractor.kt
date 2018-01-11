package com.smedialink.tokenplussteamid.interactor

import com.smedialink.tokenplussteamid.service.UserIdStoreService
import io.reactivex.Completable
import javax.inject.Inject

class SteamCredentialsInteractor @Inject constructor(
        private val storeService: UserIdStoreService) {

    fun saveSteamUserId(userId: String): Completable =
            storeService
                    .saveSteamUserId(userId)
}
