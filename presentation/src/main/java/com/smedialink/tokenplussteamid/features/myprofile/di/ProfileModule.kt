package com.smedialink.tokenplussteamid.features.myprofile.di

import com.smedialink.tokenplussteamid.app.scopes.FragmentScope
import com.smedialink.tokenplussteamid.data.manager.ProfileManager
import com.smedialink.tokenplussteamid.manager.IProfileManager
import dagger.Binds
import dagger.Module

@Module
interface ProfileModule {

    @Binds
    @FragmentScope
    fun provideUserRepository(manager: ProfileManager): IProfileManager


}
