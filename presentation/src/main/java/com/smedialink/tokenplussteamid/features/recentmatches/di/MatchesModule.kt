package com.smedialink.tokenplussteamid.features.recentmatches.di

import com.smedialink.tokenplussteamid.data.repository.HeroRepository
import com.smedialink.tokenplussteamid.data.repository.MatchRepository
import com.smedialink.tokenplussteamid.repository.IHeroRepository
import com.smedialink.tokenplussteamid.repository.IMatchRepository
import dagger.Binds
import dagger.Module

/**
 * Created by six_hundreds on 01.02.18.
 */
@Module
interface MatchesModule {

    @Binds
    fun provideMatchesRepository(repo: MatchRepository): IMatchRepository

    @Binds
    fun provideHeroImageRepository(repo: HeroRepository): IHeroRepository
}