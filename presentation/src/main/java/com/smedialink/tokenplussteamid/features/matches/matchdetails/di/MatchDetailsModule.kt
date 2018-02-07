package com.smedialink.tokenplussteamid.features.matches.matchdetails.di

import com.smedialink.tokenplussteamid.data.repository.HeroRepository
import com.smedialink.tokenplussteamid.data.repository.MatchRepository
import com.smedialink.tokenplussteamid.repository.IHeroRepository
import com.smedialink.tokenplussteamid.repository.IMatchRepository
import dagger.Binds
import dagger.Module

/**
 * Created by six_hundreds on 06.02.18.
 */
@Module
abstract class MatchDetailsModule {

    @Binds
    abstract fun provideMatchesRepository(repo: MatchRepository): IMatchRepository

    @Binds
    abstract fun provideHeroRepository(repo: HeroRepository): IHeroRepository
}