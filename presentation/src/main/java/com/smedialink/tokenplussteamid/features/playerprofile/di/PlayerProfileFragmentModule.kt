package com.smedialink.tokenplussteamid.features.playerprofile.di

import com.smedialink.tokenplussteamid.data.repository.UserRepository
import com.smedialink.tokenplussteamid.di.scopes.FragmentScope
import com.smedialink.tokenplussteamid.repository.IUserRepository
import dagger.Binds
import dagger.Module

@Module
interface PlayerProfileFragmentModule {

    @Binds
    @FragmentScope
    fun providePlayerRepository(repo: UserRepository): IUserRepository
}
