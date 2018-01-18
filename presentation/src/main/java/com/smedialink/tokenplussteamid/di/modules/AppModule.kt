package com.smedialink.tokenplussteamid.di.modules

import android.app.Application
import android.content.Context
import com.smedialink.tokenplussteamid.MyApp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Module(includes = [(AndroidInjectionModule::class)])
abstract class AppModule {

    @Module
    companion object {

        @Singleton
        @Provides
        @JvmStatic
        fun provideContext(app: MyApp): Context = app
    }

    @Binds
    abstract fun application(app: MyApp): Application
}
