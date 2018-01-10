package com.smedialink.tokenplussteamid.features.mainactivity.di

import com.smedialink.tokenplussteamid.di.scopes.ActivityScope
import com.smedialink.tokenplussteamid.features.mainactivity.MainActivity
import com.smedialink.tokenplussteamid.features.mainactivity.MainActivityNavigator
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
