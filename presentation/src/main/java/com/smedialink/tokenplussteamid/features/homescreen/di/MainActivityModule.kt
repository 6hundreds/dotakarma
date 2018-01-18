package com.smedialink.tokenplussteamid.features.homescreen.di

import com.smedialink.tokenplussteamid.di.scopes.ActivityScope
import com.smedialink.tokenplussteamid.di.scopes.FragmentScope
import com.smedialink.tokenplussteamid.features.feed.FeedFragment
import com.smedialink.tokenplussteamid.features.feed.di.FeedFragmentModule
import com.smedialink.tokenplussteamid.features.homescreen.MainActivity
import com.smedialink.tokenplussteamid.features.homescreen.navigation.MainActivityNavigator
import com.smedialink.tokenplussteamid.features.matches.MatchesFragment
import com.smedialink.tokenplussteamid.features.playerprofile.PlayerProfileFragment
import com.smedialink.tokenplussteamid.features.playerprofile.di.PlayerProfileFragmentModule
import com.smedialink.tokenplussteamid.features.steamauth.SteamAuthFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import ru.terrakok.cicerone.Navigator

@Module
abstract class MainActivityModule {

    @Module
    companion object {

        @ActivityScope
        @Provides
        @JvmStatic
        fun provideNavigator(activity: MainActivity): Navigator = MainActivityNavigator(activity)
    }

    @FragmentScope
    @ContributesAndroidInjector(modules = [(PlayerProfileFragmentModule::class)])
    abstract fun profileFragmentInjector(): PlayerProfileFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [(FeedFragmentModule::class)])
    abstract fun feedFragmentInjector(): FeedFragment

    @FragmentScope
    @ContributesAndroidInjector()
    abstract fun steamAuthFragmentInjector(): SteamAuthFragment

    @FragmentScope
    @ContributesAndroidInjector()
    abstract fun matchesFragmentInjector(): MatchesFragment
}
