package com.smedialink.tokenplussteamid.features.homescreen.di

import com.smedialink.tokenplussteamid.di.scopes.ActivityScope
import com.smedialink.tokenplussteamid.features.homescreen.MainActivity
import com.smedialink.tokenplussteamid.features.homescreen.navigation.MainActivityNavigator
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Navigator

@Module
class MainActivityModule {

    @Module
    companion object {

        @ActivityScope
        @Provides
        @JvmStatic
        fun provideNavigator(activity: MainActivity): Navigator = MainActivityNavigator(activity)
    }
}
