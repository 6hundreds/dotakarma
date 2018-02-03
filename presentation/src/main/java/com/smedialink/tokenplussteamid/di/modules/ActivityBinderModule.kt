package com.smedialink.tokenplussteamid.app.modules

import com.smedialink.tokenplussteamid.app.scopes.ActivityScope
import com.smedialink.tokenplussteamid.features.authsuccess.AuthSuccessActivity
import com.smedialink.tokenplussteamid.features.authsuccess.di.AuthSuccessActivityModule
import com.smedialink.tokenplussteamid.features.homescreen.MainActivity
import com.smedialink.tokenplussteamid.features.homescreen.di.MainActivityModule
import com.smedialink.tokenplussteamid.features.splash.SplashActivity
import com.smedialink.tokenplussteamid.features.splash.di.SplashActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBinderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun mainActivityInjector(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [AuthSuccessActivityModule::class])
    fun successAuthActivityInjector(): AuthSuccessActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    fun splashActivityInjector(): SplashActivity
}
