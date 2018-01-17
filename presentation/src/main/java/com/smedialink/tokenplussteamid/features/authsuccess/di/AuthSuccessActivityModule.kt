package com.smedialink.tokenplussteamid.features.authsuccess.di

import com.smedialink.tokenplussteamid.data.repository.PlayerProfileRepositoryImpl
import com.smedialink.tokenplussteamid.di.scopes.ActivityScope
import com.smedialink.tokenplussteamid.repository.PlayerProfileRepository
import dagger.Binds
import dagger.Module

@Module
interface AuthSuccessActivityModule {

    @Binds
    @ActivityScope
    fun providePlayerRepository(repo: PlayerProfileRepositoryImpl): PlayerProfileRepository
}
