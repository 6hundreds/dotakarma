package com.smedialink.tokenplussteamid.features.main.di

import com.smedialink.tokenplussteamid.app.scopes.ActivityScope
import com.smedialink.tokenplussteamid.app.scopes.FragmentScope
import com.smedialink.tokenplussteamid.common.delegates.ErrorMessageDelegate
import com.smedialink.tokenplussteamid.common.ext.weak
import com.smedialink.tokenplussteamid.features.containers.di.FeedTabModule
import com.smedialink.tokenplussteamid.features.feed.FeedFragment
import com.smedialink.tokenplussteamid.features.feed.di.FeedModule
import com.smedialink.tokenplussteamid.features.main.MainActivity
import com.smedialink.tokenplussteamid.features.containers.di.MatchesTabModule
import com.smedialink.tokenplussteamid.features.containers.di.ProfileTabModule
import com.smedialink.tokenplussteamid.features.containers.feed.FeedContainerFragment
import com.smedialink.tokenplussteamid.features.containers.matches.MatchesContainerFragment
import com.smedialink.tokenplussteamid.features.containers.profile.ProfileContainerFragment
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
