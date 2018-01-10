package com.smedialink.tokenplussteamid.features.authorization.di

import com.smedialink.tokenplussteamid.di.scopes.ActivityScope
import com.smedialink.tokenplussteamid.features.authorization.AuthActivity
import com.smedialink.tokenplussteamid.features.authorization.navigation.AuthNavigator
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Navigator

@Module
class AuthActivityModule {

    @Module
    companion object {

        @ActivityScope
        @Provides
        @JvmStatic
        fun provideNavigator(activity: AuthActivity): Navigator = AuthNavigator(activity)
    }
}
