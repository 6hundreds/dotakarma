package com.smedialink.tokenplussteamid.features.containers.di

import com.smedialink.tokenplussteamid.app.scopes.FragmentScope
import com.smedialink.tokenplussteamid.data.manager.ProfileManager
import com.smedialink.tokenplussteamid.data.repository.CommentRepository
import com.smedialink.tokenplussteamid.di.qualifier.LocalNavigation
import com.smedialink.tokenplussteamid.di.scopes.ChildFragmentScope
import com.smedialink.tokenplussteamid.features.auth.SteamAuthFragment
import com.smedialink.tokenplussteamid.features.containers.profile.ProfileContainerFragment
import com.smedialink.tokenplussteamid.features.containers.profile.ProfileContainerNavigator
import com.smedialink.tokenplussteamid.features.myprofile.MyProfileFragment
import com.smedialink.tokenplussteamid.features.reply.ReplyToCommentFragment
import com.smedialink.tokenplussteamid.features.reply.di.ReplyToCommentModule
import com.smedialink.tokenplussteamid.manager.IProfileManager
import com.smedialink.tokenplussteamid.repository.ICommentRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router

/**
 * Created by Sergey Opivalov on 20/02/2018.
 */
@Module
abstract class ProfileTabModule {

    @Module
    companion object {
        @FragmentScope
        @Provides
        @JvmStatic
        fun provideNavigator(fragment: ProfileContainerFragment): Navigator = ProfileContainerNavigator(fragment)

        @FragmentScope
        @Provides
        @JvmStatic
        @LocalNavigation
        fun provideRouter(fragment: ProfileContainerFragment): Router = fragment.router
    }

    @Binds
    @FragmentScope
    abstract fun provideProfileManager(manager: ProfileManager): IProfileManager

    @Binds
    @FragmentScope
    abstract fun provideCommentRepository(repo: CommentRepository): ICommentRepository

    @ChildFragmentScope
    @ContributesAndroidInjector()
    abstract fun myProfileInjector(): MyProfileFragment

    @ChildFragmentScope
    @ContributesAndroidInjector()
    abstract fun steamAuthInjector(): SteamAuthFragment

    @ChildFragmentScope
    @ContributesAndroidInjector(modules = [ReplyToCommentModule::class])
    abstract fun replyToCommentInjector(): ReplyToCommentFragment
}
