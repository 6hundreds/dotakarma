package com.smedialink.tokenplussteamid.features.feed.di

import com.smedialink.tokenplussteamid.data.repository.feed.FeedRepositoryImpl
import com.smedialink.tokenplussteamid.di.scopes.FragmentScope
import com.smedialink.tokenplussteamid.repository.feed.FeedRepository
import dagger.Binds
import dagger.Module


@Module
interface FeedFragmentModule {

    @Binds
    @FragmentScope
    fun providePlayerRepository(repo: FeedRepositoryImpl): FeedRepository
}
