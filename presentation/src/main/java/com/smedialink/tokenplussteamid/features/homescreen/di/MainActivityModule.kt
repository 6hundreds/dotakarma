package com.smedialink.tokenplussteamid.features.homescreen.di

import com.smedialink.tokenplussteamid.di.scopes.FragmentScope
import com.smedialink.tokenplussteamid.features.feed.FeedFragment
import com.smedialink.tokenplussteamid.features.feed.di.FeedFragmentModule
import com.smedialink.tokenplussteamid.features.playerprofile.PlayerProfileFragment
import com.smedialink.tokenplussteamid.features.playerprofile.di.PlayerProfileFragmentModule
import com.smedialink.tokenplussteamid.features.steamauth.SteamAuthFragment
import com.smedialink.tokenplussteamid.features.steamauth.di.SteamAuthFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [(FeedFragmentModule::class)])
    fun feedFragmentInjector(): FeedFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [(PlayerProfileFragmentModule::class)])
    fun profileFragmentInjector(): PlayerProfileFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [(SteamAuthFragmentModule::class)])
    fun steamAuthFragmentInjector(): SteamAuthFragment
}
