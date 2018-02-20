package com.smedialink.tokenplussteamid.features.main.di

import com.smedialink.tokenplussteamid.app.scopes.FragmentScope
import com.smedialink.tokenplussteamid.features.feed.FeedFragment
import com.smedialink.tokenplussteamid.features.feed.di.FeedModule
import com.smedialink.tokenplussteamid.features.main.containers.di.MatchesTabModule
import com.smedialink.tokenplussteamid.features.main.containers.di.ProfileTabModule
import com.smedialink.tokenplussteamid.features.main.containers.matches.MatchesContainerFragment
import com.smedialink.tokenplussteamid.features.main.containers.profile.ProfileContainerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ProfileTabModule::class])
    abstract fun profileTabInjector(): ProfileContainerFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [MatchesTabModule::class])
    abstract fun matchesTabInjector(): MatchesContainerFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [FeedModule::class])
    abstract fun feedFragmentInjector(): FeedFragment

}
