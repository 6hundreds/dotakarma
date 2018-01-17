package com.smedialink.tokenplussteamid.di.modules.contribution

import com.smedialink.tokenplussteamid.di.scopes.ActivityScope
import com.smedialink.tokenplussteamid.features.authsuccess.AuthSuccessActivity
import com.smedialink.tokenplussteamid.features.homescreen.MainActivity
import com.smedialink.tokenplussteamid.features.homescreen.di.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [(AndroidSupportInjectionModule::class)])
interface ActivityContributionModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    fun mainActivityInjector(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector()
    fun successAuthActivityInjector(): AuthSuccessActivity
}
