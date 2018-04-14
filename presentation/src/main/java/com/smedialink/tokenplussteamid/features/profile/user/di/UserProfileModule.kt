package com.smedialink.tokenplussteamid.features.profile.user.di

import com.smedialink.tokenplussteamid.app.scopes.FragmentScope
import com.smedialink.tokenplussteamid.data.repository.CommentRepository
import com.smedialink.tokenplussteamid.data.repository.UserRepository
import com.smedialink.tokenplussteamid.di.qualifier.LocalErrorHandler
import com.smedialink.tokenplussteamid.errorhandling.ErrorHandler
import com.smedialink.tokenplussteamid.features.profile.user.UserProfileErrorHandler
import com.smedialink.tokenplussteamid.repository.ICommentRepository
import com.smedialink.tokenplussteamid.repository.IUserRepository
import dagger.Binds
import dagger.Module

/**
 * Created by six_hundreds on 10.04.18.
 */
@Module
abstract class UserProfileModule {

    @Binds
    @FragmentScope
    abstract fun provideUserRepository(repository: UserRepository): IUserRepository

    @Binds
    @FragmentScope
    abstract fun provideCommentRepository(repository: CommentRepository): ICommentRepository

    @Binds
    @FragmentScope
    @LocalErrorHandler
    abstract fun provideErrorHandler(handler: UserProfileErrorHandler): ErrorHandler
}