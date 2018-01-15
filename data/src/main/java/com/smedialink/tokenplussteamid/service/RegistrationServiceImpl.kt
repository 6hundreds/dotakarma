package com.smedialink.tokenplussteamid.service

import com.smedialink.tokenplussteamid.manager.SettingsManager
import com.smedialink.tokenplussteamid.network.ServerApi
import io.reactivex.Completable
import javax.inject.Inject

class RegistrationServiceImpl @Inject constructor(
        private val serverApi: ServerApi,
        private val settingsManager: SettingsManager
) : RegistrationService {

    override fun performRegistration(login: String, password: String): Completable =
            serverApi
                    .sendRegistrationCompleRequest(login, password)
                    .doOnComplete { settingsManager.saveToken("TOKEN") }
}
