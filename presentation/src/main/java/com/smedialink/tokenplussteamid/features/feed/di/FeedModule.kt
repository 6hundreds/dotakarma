package com.smedialink.tokenplussteamid.features.feed.di

import com.smedialink.tokenplussteamid.data.repository.CommentRepository
import com.smedialink.tokenplussteamid.di.scopes.ChildFragmentScope
import com.smedialink.tokenplussteamid.repository.ICommentRepository
import dagger.Binds
import dagger.Module


@Module
interface FeedModule {

    @Binds
    @ChildFragmentScope
    fun provideCommentRepository(repo: CommentRepository): ICommentRepository
}
