package com.smedialink.tokenplussteamid.features.containers.di

import com.smedialink.tokenplussteamid.app.scopes.FragmentScope
import com.smedialink.tokenplussteamid.di.qualifier.LocalNavigation
import com.smedialink.tokenplussteamid.di.scopes.ChildFragmentScope
import com.smedialink.tokenplussteamid.features.containers.feed.FeedContainerFragment
import com.smedialink.tokenplussteamid.features.containers.feed.FeedContainerNavigator
import com.smedialink.tokenplussteamid.features.feed.FeedFragment
import com.smedialink.tokenplussteamid.features.feed.di.FeedModule
import com.smedialink.tokenplussteamid.features.matches.recentmatches.RecentMatchesFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router

/**
 * Created by Sergey Opivalov on 06/03/2018.
 */
@Module
abstract class FeedTabModule {

    @Module
    companion object {
        @FragmentScope
        @Provides
        @JvmStatic
        fun provideNavigator(fragment: FeedContainerFragment): Navigator = FeedContainerNavigator(fragment)

        @FragmentScope
        @Provides
        @JvmStatic
        @LocalNavigation
        fun provideRouter(fragment: FeedContainerFragment): Router = fragment.router
    }

    @ChildFragmentScope
    @ContributesAndroidInjector(modules = [FeedModule::class])
    abstract fun feedFragmentInjector(): FeedFragment

}