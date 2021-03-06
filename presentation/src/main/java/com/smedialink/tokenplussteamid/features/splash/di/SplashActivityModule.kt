package com.smedialink.tokenplussteamid.features.splash.di

import com.smedialink.tokenplussteamid.app.scopes.ActivityScope
import com.smedialink.tokenplussteamid.data.repository.HeroRepository
import com.smedialink.tokenplussteamid.features.splash.SplashActivity
import com.smedialink.tokenplussteamid.features.splash.navigation.SplashActivityNavigator
import com.smedialink.tokenplussteamid.repository.IHeroRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Navigator

/**
 * Created by six_hundreds on 31.01.18.
 */
@Module
abstract class SplashActivityModule {

    @Module
    companion object {

        @ActivityScope
        @Provides
        @JvmStatic
        fun provideNavigator(activity: SplashActivity): Navigator = SplashActivityNavigator(activity)
    }

    @Binds
    @ActivityScope
    abstract fun provideHeroRepository(repo: HeroRepository): IHeroRepository

}