package com.smedialink.tokenplussteamid.di.modules

import com.smedialink.tokenplussteamid.app.scopes.ActivityScope
import com.smedialink.tokenplussteamid.features.authsuccess.AuthSuccessActivity
import com.smedialink.tokenplussteamid.features.main.MainActivity
import com.smedialink.tokenplussteamid.features.main.di.MainActivityModule
import com.smedialink.tokenplussteamid.features.splash.SplashActivity
import com.smedialink.tokenplussteamid.features.splash.di.SplashActivityModule
import com.smedialink.tokenplussteamid.features.userdetails.UserDetailsActivity
import com.smedialink.tokenplussteamid.features.userdetails.di.UserDetailsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBinderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun mainActivityInjector(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    fun splashActivityInjector(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [UserDetailsModule::class])
    fun userDetailsActivityInjector(): UserDetailsActivity

    @ActivityScope
    @ContributesAndroidInjector
    fun successAuthActivityInjector(): AuthSuccessActivity
}
