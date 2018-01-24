package com.smedialink.tokenplussteamid.features.authsuccess.di

import com.smedialink.tokenplussteamid.data.repository.UserRepository
import com.smedialink.tokenplussteamid.di.scopes.ActivityScope
import com.smedialink.tokenplussteamid.repository.IUserRepository
import dagger.Binds
import dagger.Module

@Module
interface AuthSuccessActivityModule {

    @Binds
    @ActivityScope
    fun providePlayerRepository(repo: UserRepository): IUserRepository
}
