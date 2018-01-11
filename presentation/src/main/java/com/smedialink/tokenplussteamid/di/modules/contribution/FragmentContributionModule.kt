package com.smedialink.tokenplussteamid.di.modules.contribution

import com.smedialink.tokenplussteamid.di.scopes.FragmentScope
import com.smedialink.tokenplussteamid.features.steam.SteamAuthFragment
import com.smedialink.tokenplussteamid.features.steam.di.SteamAuthFragmentModule
import com.smedialink.tokenplussteamid.features.registration.RegistrationFragment
import com.smedialink.tokenplussteamid.features.registration.di.RegistrationFragmentModule
import com.smedialink.tokenplussteamid.features.registrationcomplete.RegistrationCompletedFragment
import com.smedialink.tokenplussteamid.features.registrationcomplete.di.RegistrationCompletedFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [(AndroidSupportInjectionModule::class)])
interface FragmentContributionModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [(RegistrationFragmentModule::class)])
    fun registrationFragmentInjector(): RegistrationFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [(SteamAuthFragmentModule::class)])
    fun steamFragmentInjector(): SteamAuthFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [(RegistrationCompletedFragmentModule::class)])
    fun registrationCompletedFragmentInjector(): RegistrationCompletedFragment
}
