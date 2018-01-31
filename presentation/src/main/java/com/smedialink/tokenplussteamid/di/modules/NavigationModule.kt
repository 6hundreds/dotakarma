package com.smedialink.tokenplussteamid.app.modules

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
}
