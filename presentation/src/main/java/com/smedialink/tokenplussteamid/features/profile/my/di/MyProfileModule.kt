package com.smedialink.tokenplussteamid.features.profile.my.di

import com.smedialink.tokenplussteamid.app.scopes.FragmentScope
import com.smedialink.tokenplussteamid.data.manager.ProfileManager
import com.smedialink.tokenplussteamid.manager.IProfileManager
import dagger.Binds
import dagger.Module

@Module
interface MyProfileModule {

    @Binds
    @FragmentScope
    fun provideUserRepository(manager: ProfileManager): IProfileManager


}
