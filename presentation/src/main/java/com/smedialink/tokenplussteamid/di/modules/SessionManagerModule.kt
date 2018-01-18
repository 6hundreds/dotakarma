package com.smedialink.tokenplussteamid.di.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.smedialink.tokenplussteamid.data.manager.SessionManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SessionManagerModule {

    @Provides
    @Singleton
    fun provideSharedPrefs(context: Context): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    @Singleton
    fun provideSessionManager(prefs: SharedPreferences): SessionManager = SessionManager(prefs)
}
