package com.smedialink.tokenplussteamid.features.userdetails.di

import com.smedialink.tokenplussteamid.app.scopes.ActivityScope
import com.smedialink.tokenplussteamid.app.scopes.FragmentScope
import com.smedialink.tokenplussteamid.errorhandling.ErrorMessageDelegate
import com.smedialink.tokenplussteamid.common.ext.weak
import com.smedialink.tokenplussteamid.features.anonymous.comment.AnonymousCommentFragment
import com.smedialink.tokenplussteamid.features.anonymous.comment.di.AnonymousCommentModule
import com.smedialink.tokenplussteamid.features.anonymous.walkthrough.AnonymousWalkthroughFragment
import com.smedialink.tokenplussteamid.features.profile.user.UserProfileFragment
import com.smedialink.tokenplussteamid.features.profile.user.di.UserProfileModule
import com.smedialink.tokenplussteamid.features.unregistered.UnregisteredUserFragment
import com.smedialink.tokenplussteamid.features.userdetails.UserDetailsActivity
import com.smedialink.tokenplussteamid.features.userdetails.UserDetailsNavigator
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import ru.terrakok.cicerone.Navigator

/**
 * Created by six_hundreds on 09.04.18.
 */
@Module
abstract class UserDetailsModule {

    @Module
    companion object {

        @ActivityScope
        @Provides
        @JvmStatic
        fun provideErrorDelegate(activity: UserDetailsActivity): ErrorMessageDelegate =
                ErrorMessageDelegate(activity.weak())

        @Provides
        @ActivityScope
        @JvmStatic
        fun provideCurrentUserId(activity: UserDetailsActivity): Long = activity.currentAccountId

        @ActivityScope
        @Provides
        @JvmStatic
        fun provideNavigator(activity: UserDetailsActivity): Navigator = UserDetailsNavigator(activity)
    }

    @FragmentScope
    @ContributesAndroidInjector(modules = [UserProfileModule::class])
    abstract fun userProfileInjector(): UserProfileFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [])
    abstract fun userUnregisteredUserInjector(): UnregisteredUserFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [])
    abstract fun anonymousWalkthroughInjector(): AnonymousWalkthroughFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [AnonymousCommentModule::class])
    abstract fun anonymousCommentInjector(): AnonymousCommentFragment
}