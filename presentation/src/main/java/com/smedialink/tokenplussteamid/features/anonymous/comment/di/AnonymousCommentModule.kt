package com.smedialink.tokenplussteamid.features.anonymous.comment.di

import com.smedialink.tokenplussteamid.app.scopes.FragmentScope
import com.smedialink.tokenplussteamid.data.repository.UserRepository
import com.smedialink.tokenplussteamid.repository.IUserRepository
import dagger.Binds
import dagger.Module

/**
 * Created by six_hundreds on 16.04.18.
 */
@Module
abstract class AnonymousCommentModule {

    @Binds
    @FragmentScope
    abstract fun provideUserRepository(repository: UserRepository): IUserRepository
}