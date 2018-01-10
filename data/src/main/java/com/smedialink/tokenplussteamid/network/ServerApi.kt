package com.smedialink.tokenplussteamid.network

import com.smedialink.tokenplussteamid.entity.RegisteredUser
import io.reactivex.Single

interface ServerApi {

    fun sendRegistrationRequest(login: String, password: String): Single<RegisteredUser>
}
