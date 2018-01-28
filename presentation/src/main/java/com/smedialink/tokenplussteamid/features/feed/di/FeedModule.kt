package com.smedialink.tokenplussteamid.features.feed.di

import com.smedialink.tokenplussteamid.data.repository.CommentRepository
import com.smedialink.tokenplussteamid.app.scopes.FragmentScope
import com.smedialink.tokenplussteamid.repository.ICommentRepository
import dagger.Binds
import dagger.Module


@Module
interface FeedModule {

    @Binds
    @FragmentScope
    fun provideCommentRepository(repo: CommentRepository): ICommentRepository
}
