package com.smedialink.tokenplussteamid.features.homescreen.di

import com.smedialink.tokenplussteamid.app.scopes.ActivityScope
import com.smedialink.tokenplussteamid.app.scopes.FragmentScope
import com.smedialink.tokenplussteamid.features.feed.FeedFragment
import com.smedialink.tokenplussteamid.features.feed.di.FeedModule
import com.smedialink.tokenplussteamid.features.homescreen.MainActivity
import com.smedialink.tokenplussteamid.features.homescreen.navigation.MainActivityNavigator
import com.smedialink.tokenplussteamid.features.recentmatches.RecentMatchesFragment
import com.smedialink.tokenplussteamid.features.playerprofile.PlayerProfileFragment
import com.smedialink.tokenplussteamid.features.playerprofile.di.ProfileModule
import com.smedialink.tokenplussteamid.features.recentmatches.di.MatchesModule
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
    @ContributesAndroidInjector(modules = [ProfileModule::class])
    abstract fun profileFragmentInjector(): PlayerProfileFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [FeedModule::class])
    abstract fun feedFragmentInjector(): FeedFragment

    @FragmentScope
    @ContributesAndroidInjector()
    abstract fun steamAuthFragmentInjector(): SteamAuthFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [MatchesModule::class])
    abstract fun matchesFragmentInjector(): RecentMatchesFragment
}
