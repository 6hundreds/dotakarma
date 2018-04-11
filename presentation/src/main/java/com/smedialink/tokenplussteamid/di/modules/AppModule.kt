package com.smedialink.tokenplussteamid.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.smedialink.tokenplussteamid.app.DotaKarma
import com.smedialink.tokenplussteamid.data.manager.SessionManager
import com.smedialink.tokenplussteamid.data.manager.SharedPrefsManager
import com.smedialink.tokenplussteamid.errorhandling.ErrorHandler
import com.smedialink.tokenplussteamid.errorhandling.PresentationErrorHandler
import com.smedialink.tokenplussteamid.manager.IPrefsManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
abstract class AppModule {

    @Module
    companion object {

        @Singleton
        @Provides
        @JvmStatic
        fun provideContext(app: DotaKarma): Context = app

        @Provides
        @Singleton
        @JvmStatic
        fun provideSharedPrefs(context: Context): SharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(context)

        @Provides
        @Singleton
        @JvmStatic
        fun provideSessionManager(sp: SharedPreferences): SessionManager =
                SessionManager(SharedPrefsManager(sp))

    }

    @Binds
    @Singleton
    abstract fun providePrefsManager(manager: SharedPrefsManager): IPrefsManager

    @Binds
    @Singleton
    abstract fun providePresentationErrorHandler(handler: PresentationErrorHandler): ErrorHandler

    @Binds
    abstract fun application(app: DotaKarma): Application
}
