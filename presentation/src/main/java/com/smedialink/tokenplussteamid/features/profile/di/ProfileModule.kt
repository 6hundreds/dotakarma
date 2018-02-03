package com.smedialink.tokenplussteamid.features.profile.di

import com.smedialink.tokenplussteamid.app.scopes.FragmentScope
import com.smedialink.tokenplussteamid.data.repository.UserRepository
import com.smedialink.tokenplussteamid.repository.IUserRepository
import dagger.Binds
import dagger.Module

@Module
interface ProfileModule {


    @Binds
    @FragmentScope
    fun provideUserRepository(repo: UserRepository): IUserRepository


}
