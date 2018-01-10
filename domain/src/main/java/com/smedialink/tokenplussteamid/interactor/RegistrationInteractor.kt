package com.smedialink.tokenplussteamid.interactor

import com.smedialink.tokenplussteamid.service.RegistrationService
import io.reactivex.Completable
import javax.inject.Inject

class RegistrationInteractor @Inject constructor(
        private val registrationService: RegistrationService) {

    fun performRegistration(login: String, password: String): Completable =
            registrationService
                    .performRegistration(login, password)
}
