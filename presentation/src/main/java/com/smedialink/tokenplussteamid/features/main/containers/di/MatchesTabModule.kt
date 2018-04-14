package com.smedialink.tokenplussteamid.features.main.containers.di

import com.smedialink.tokenplussteamid.app.scopes.FragmentScope
import com.smedialink.tokenplussteamid.data.repository.HeroRepository
import com.smedialink.tokenplussteamid.data.repository.MatchRepository
import com.smedialink.tokenplussteamid.di.qualifier.LocalNavigation
import com.smedialink.tokenplussteamid.di.scopes.ChildFragmentScope
import com.smedialink.tokenplussteamid.features.main.containers.matches.MatchesContainerFragment
import com.smedialink.tokenplussteamid.features.main.containers.matches.MatchesContainerNavigator
import com.smedialink.tokenplussteamid.features.matches.matchdetails.MatchDetailsFragment
import com.smedialink.tokenplussteamid.features.matches.recentmatches.RecentMatchesFragment
import com.smedialink.tokenplussteamid.repository.IHeroRepository
import com.smedialink.tokenplussteamid.repository.IMatchRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router

/**
 * Created by Sergey Opivalov on 14/02/2018.
 */
@Module
abstract class MatchesTabModule {

    @Module
    companion object {
        @FragmentScope
        @Provides
        @JvmStatic
        fun provideNavigator(fragment: MatchesContainerFragment): Navigator = MatchesContainerNavigator(fragment)

        @FragmentScope
        @Provides
        @JvmStatic
        @LocalNavigation
        fun provideRouter(fragment: MatchesContainerFragment): Router = fragment.router
    }

    @Binds
    @FragmentScope
    abstract fun provideMatchesRepository(repo: MatchRepository): IMatchRepository

    @Binds
    @FragmentScope
    abstract fun provideHeroRepository(repo: HeroRepository): IHeroRepository

    @ChildFragmentScope
    @ContributesAndroidInjector()
    abstract fun recentMatchesInjector(): RecentMatchesFragment

    @ChildFragmentScope
    @ContributesAndroidInjector()
    abstract fun matchDetailsInjector(): MatchDetailsFragment
}