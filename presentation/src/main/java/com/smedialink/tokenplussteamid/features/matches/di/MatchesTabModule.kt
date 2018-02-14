package com.smedialink.tokenplussteamid.features.matches.di

import com.smedialink.tokenplussteamid.app.scopes.FragmentScope
import com.smedialink.tokenplussteamid.data.repository.HeroRepository
import com.smedialink.tokenplussteamid.data.repository.MatchRepository
import com.smedialink.tokenplussteamid.features.matches.MatchesContainerFragment
import com.smedialink.tokenplussteamid.features.matches.navigation.MatchesContainerNavigator
import com.smedialink.tokenplussteamid.repository.IHeroRepository
import com.smedialink.tokenplussteamid.repository.IMatchRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Navigator

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
    }

    @Binds
    @FragmentScope
    abstract fun provideMatchesRepository(repo: MatchRepository): IMatchRepository

    @Binds
    @FragmentScope
    abstract fun provideHeroRepository(repo: HeroRepository): IHeroRepository
}