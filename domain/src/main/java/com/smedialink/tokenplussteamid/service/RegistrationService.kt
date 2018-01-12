package com.smedialink.tokenplussteamid.service

import io.reactivex.Completable

interface RegistrationService {

    fun performRegistration(login: String, password: String): Completable?
}
