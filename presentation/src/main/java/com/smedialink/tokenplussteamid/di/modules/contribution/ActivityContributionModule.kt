package com.smedialink.tokenplussteamid.di.modules.contribution

import com.smedialink.tokenplussteamid.di.scopes.ActivityScope
import com.smedialink.tokenplussteamid.features.homescreen.HomeActivity
import com.smedialink.tokenplussteamid.features.homescreen.di.HomeActivityModule
import com.smedialink.tokenplussteamid.features.mainactivity.MainActivity
import com.smedialink.tokenplussteamid.features.mainactivity.di.MainActivityModule
import com.smedialink.tokenplussteamid.features.registration.RegistrationActivity
import com.smedialink.tokenplussteamid.features.registration.di.RegistrationActivityModule
import com.smedialink.tokenplussteamid.features.steamid.GetSteamIdActivity
import com.smedialink.tokenplussteamid.features.steamid.di.GetSteamIdActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [(AndroidSupportInjectionModule::class)])
interface ActivityContributionModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    fun mainActivityInjector(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(RegistrationActivityModule::class)])
    fun registrationActivityInjector(): RegistrationActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(GetSteamIdActivityModule::class)])
    fun steamActivityInjector(): GetSteamIdActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(HomeActivityModule::class)])
    fun homeActivityInjector(): HomeActivity
}
