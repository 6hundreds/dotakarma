package com.smedialink.tokenplussteamid.features.registration.di

import com.smedialink.tokenplussteamid.di.scopes.ActivityScope
import com.smedialink.tokenplussteamid.service.RegistrationService
import com.smedialink.tokenplussteamid.service.RegistrationServiceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RegistrationActivityModule {

    @Binds
    @ActivityScope
    abstract fun providesRegistrationService(service: RegistrationServiceImpl): RegistrationService
}
