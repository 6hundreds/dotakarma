package com.smedialink.tokenplussteamid.app.modules

import android.app.Application
import android.content.Context
import com.smedialink.tokenplussteamid.app.DotaKarma
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
        fun provideContext(app: DotaKarma): Context = app
    }

    @Binds
    abstract fun application(app: DotaKarma): Application
}
