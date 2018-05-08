package com.smedialink.tokenplussteamid.features.main.di

import com.smedialink.tokenplussteamid.app.scopes.ActivityScope
import com.smedialink.tokenplussteamid.app.scopes.FragmentScope
import com.smedialink.tokenplussteamid.errorhandling.ErrorMessageDelegate
import com.smedialink.tokenplussteamid.common.ext.weak
import com.smedialink.tokenplussteamid.features.main.containers.di.FeedTabModule
import com.smedialink.tokenplussteamid.features.main.containers.di.MatchesTabModule
import com.smedialink.tokenplussteamid.features.main.containers.di.ProfileTabModule
import com.smedialink.tokenplussteamid.features.main.containers.feed.FeedContainerFragment
import com.smedialink.tokenplussteamid.features.main.containers.matches.MatchesContainerFragment
import com.smedialink.tokenplussteamid.features.main.containers.profile.ProfileContainerFragment
import com.smedialink.tokenplussteamid.features.main.MainActivity
import com.smedialink.tokenplussteamid.subnavigation.BottomBarController
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @Module
    companion object {
        @ActivityScope
        @Provides
        @JvmStatic
        fun provideErrorDelegate(activity: MainActivity): ErrorMessageDelegate =
                ErrorMessageDelegate(activity.weak())


    }

    @ActivityScope
    @Binds
    abstract fun provideBottomBarController(activity: MainActivity): BottomBarController

    @FragmentScope
    @ContributesAndroidInjector(modules = [ProfileTabModule::class])
    abstract fun profileTabInjector(): ProfileContainerFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [MatchesTabModule::class])
    abstract fun matchesTabInjector(): MatchesContainerFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [FeedTabModule::class])
    abstract fun feedTabInjector(): FeedContainerFragment

}
