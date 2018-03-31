package com.smedialink.tokenplussteamid.di.modules

import com.smedialink.tokenplussteamid.subnavigation.LocalNavigatorHolder
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class NavigationModule {

    private val cicerone = Cicerone.create()

    @Provides
    @Singleton
    fun router(): Router = cicerone.router

    @Provides
    @Singleton
    fun navHolder(): NavigatorHolder = cicerone.navigatorHolder

    @Provides
    @Singleton
    fun localNavHolder(): LocalNavigatorHolder = LocalNavigatorHolder()
}
