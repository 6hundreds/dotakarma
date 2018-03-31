package com.smedialink.tokenplussteamid.features.reply.di

import com.smedialink.tokenplussteamid.di.scopes.ChildFragmentScope
import com.smedialink.tokenplussteamid.features.reply.ReplyToCommentFragment
import dagger.Module
import dagger.Provides

/**
 * Created by Sergey Opivalov on 06/03/2018.
 */
@Module
class ReplyToCommentModule {

    @Provides
    @ChildFragmentScope
    fun provideCurrentCommentId(fragment: ReplyToCommentFragment): Int = fragment.currentCommentId
}