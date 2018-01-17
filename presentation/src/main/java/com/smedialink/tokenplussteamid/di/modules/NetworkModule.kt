package com.smedialink.tokenplussteamid.di.modules

import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val ENDPOINT = "https://0a0b9101.ngrok.io"
    }

    @Provides
    @Singleton
    fun provideDotaKarmaApi(): DotaKarmaApi =
            Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(DotaKarmaApi::class.java)
}
