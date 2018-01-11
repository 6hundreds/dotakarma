package com.smedialink.tokenplussteamid.service

import com.smedialink.tokenplussteamid.manager.SettingsManager
import io.reactivex.Completable
import javax.inject.Inject

class UserIdStoreServiceImpl @Inject constructor(
        private val settingsManager: SettingsManager
) : UserIdStoreService {

    override fun saveSteamUserId(userId: String): Completable {
        return Completable.create { emitter ->
            settingsManager.saveSteamId(userId)
            emitter.onComplete()
        }
    }
}
