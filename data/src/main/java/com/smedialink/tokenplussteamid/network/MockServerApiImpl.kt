package com.smedialink.tokenplussteamid.network

import com.smedialink.tokenplussteamid.entity.RegisteredPlayerEntity
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class MockServerApiImpl : ServerApi {

    override fun sendRegistrationCompleRequest(login: String, password: String): Single<RegisteredPlayerEntity> {

        return Single
                .just(RegisteredPlayerEntity())
                .delay(2, TimeUnit.SECONDS)
    }
}
