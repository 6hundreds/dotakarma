package com.smedialink.tokenplussteamid.di.modules

import com.smedialink.tokenplussteamid.entity.RegisteredUser
import com.smedialink.tokenplussteamid.network.ServerApi
import dagger.Module
import dagger.Provides
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideServerApi(): ServerApi {

        return object : ServerApi {
            override fun sendRegistrationRequest(login: String, password: String): Single<RegisteredUser> =
                    Single
                            .just(RegisteredUser(token = "123456789abcdefghjklmnop"))
                            .delay(2L, TimeUnit.SECONDS)
        }
    }
}
