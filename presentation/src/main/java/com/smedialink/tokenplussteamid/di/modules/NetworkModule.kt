package com.smedialink.tokenplussteamid.di.modules

import com.smedialink.tokenplussteamid.data.network.MockServerApiImpl
import com.smedialink.tokenplussteamid.data.network.ServerApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideServerApi(): ServerApi = MockServerApiImpl()
}
