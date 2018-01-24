package com.smedialink.tokenplussteamid.features.feed.di

import com.smedialink.tokenplussteamid.data.repository.feed.CommentRepository
import com.smedialink.tokenplussteamid.di.scopes.FragmentScope
import com.smedialink.tokenplussteamid.repository.feed.ICommentRepository
import dagger.Binds
import dagger.Module


@Module
interface FeedFragmentModule {

    @Binds
    @FragmentScope
    fun providePlayerRepository(repo: CommentRepository): ICommentRepository
}
