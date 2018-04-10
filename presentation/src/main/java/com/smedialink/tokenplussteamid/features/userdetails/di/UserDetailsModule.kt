package com.smedialink.tokenplussteamid.features.userdetails.di

import com.smedialink.tokenplussteamid.app.scopes.ActivityScope
import com.smedialink.tokenplussteamid.app.scopes.FragmentScope
import com.smedialink.tokenplussteamid.common.delegates.ErrorMessageDelegate
import com.smedialink.tokenplussteamid.common.ext.weak
import com.smedialink.tokenplussteamid.features.profile.user.UserProfileFragment
import com.smedialink.tokenplussteamid.features.profile.user.di.UserProfileModule
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
        fun provideCurrentUserId(activity: UserDetailsActivity): Int = activity.currentUserId

        @ActivityScope
        @Provides
        @JvmStatic
        fun provideNavigator(activity: UserDetailsActivity): Navigator = UserDetailsNavigator(activity)
    }

    @FragmentScope
    @ContributesAndroidInjector(modules = [UserProfileModule::class])
    abstract fun userProfileInjector(): UserProfileFragment
}