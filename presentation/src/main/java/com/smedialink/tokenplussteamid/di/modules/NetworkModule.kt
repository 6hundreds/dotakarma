package com.smedialink.tokenplussteamid.di.modules

import com.smedialink.tokenplussteamid.network.ServerApi
import com.smedialink.tokenplussteamid.network.MockServerApiImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideServerApi(): ServerApi = MockServerApiImpl()
}
