package com.smedialink.tokenplussteamid.di.modules.contribution

import com.smedialink.tokenplussteamid.di.scopes.ActivityScope
import com.smedialink.tokenplussteamid.features.registration.RegistrationActivity
import com.smedialink.tokenplussteamid.features.registration.di.RegistrationActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [(AndroidSupportInjectionModule::class)])
interface ActivityContributionModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [(RegistrationActivityModule::class)])
    fun mainActivityInjector(): RegistrationActivity
}
