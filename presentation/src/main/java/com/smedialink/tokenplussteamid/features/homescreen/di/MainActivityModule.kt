package com.smedialink.tokenplussteamid.features.homescreen.di

import com.smedialink.tokenplussteamid.app.scopes.FragmentScope
import com.smedialink.tokenplussteamid.features.auth.SteamAuthFragment
import com.smedialink.tokenplussteamid.features.feed.FeedFragment
import com.smedialink.tokenplussteamid.features.feed.di.FeedModule
import com.smedialink.tokenplussteamid.features.matches.MatchesContainerFragment
import com.smedialink.tokenplussteamid.features.matches.di.MatchesTabModule
import com.smedialink.tokenplussteamid.features.myprofile.MyProfileFragment
import com.smedialink.tokenplussteamid.features.myprofile.di.ProfileModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ProfileModule::class])
    abstract fun profileFragmentInjector(): MyProfileFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [FeedModule::class])
    abstract fun feedFragmentInjector(): FeedFragment

    @FragmentScope
    @ContributesAndroidInjector()
    abstract fun steamAuthFragmentInjector(): SteamAuthFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [MatchesTabModule::class])
    abstract fun matchesTabInjector(): MatchesContainerFragment
}
