package com.smedialink.tokenplussteamid.features.steamauth.di

import com.smedialink.tokenplussteamid.di.scopes.FragmentScope
import com.smedialink.tokenplussteamid.service.UserIdStoreService
import com.smedialink.tokenplussteamid.service.UserIdStoreServiceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class SteamAuthFragmentModule {

    @Binds
    @FragmentScope
    abstract fun provideUserIdStoreService(service: UserIdStoreServiceImpl): UserIdStoreService
}
