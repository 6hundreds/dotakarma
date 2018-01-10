package com.smedialink.tokenplussteamid.features.registration.di

import com.smedialink.tokenplussteamid.di.scopes.FragmentScope
import com.smedialink.tokenplussteamid.service.RegistrationService
import com.smedialink.tokenplussteamid.service.RegistrationServiceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RegistrationFragmentModule {

    @Binds
    @FragmentScope
    abstract fun providesRegistrationService(service: RegistrationServiceImpl): RegistrationService
}
