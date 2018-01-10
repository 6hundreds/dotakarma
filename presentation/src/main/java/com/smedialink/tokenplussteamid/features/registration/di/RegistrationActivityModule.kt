package com.smedialink.tokenplussteamid.features.registration.di

import com.smedialink.tokenplussteamid.di.scopes.ActivityScope
import com.smedialink.tokenplussteamid.features.registration.RegistrationActivity
import com.smedialink.tokenplussteamid.features.registration.RegistrationActivityNavigator
import com.smedialink.tokenplussteamid.service.RegistrationService
import com.smedialink.tokenplussteamid.service.RegistrationServiceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Navigator

@Module
abstract class RegistrationActivityModule {

    @Module
    companion object {
        @ActivityScope
        @Provides
        @JvmStatic
        fun provideNavigator(activity: RegistrationActivity): Navigator =
                RegistrationActivityNavigator(activity)
    }

    @Binds
    @ActivityScope
    abstract fun providesRegistrationService(service: RegistrationServiceImpl): RegistrationService
}
