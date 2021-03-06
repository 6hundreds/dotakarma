package com.smedialink.tokenplussteamid.network.interceptors

import com.smedialink.tokenplussteamid.data.manager.SessionManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val settingsManager: SessionManager)

    : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        var builder = original.newBuilder()
            .header("Accept", "application/json")
            .header("Content-type", "application/json")

        if (settingsManager.isSessionOpened()) {
            builder = builder.header(
                "x-access-token",
                settingsManager.getAccessToken()
            )
        }
        return chain.proceed(builder.build())
    }
}