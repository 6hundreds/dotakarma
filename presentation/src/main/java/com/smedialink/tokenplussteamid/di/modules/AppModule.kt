package com.smedialink.tokenplussteamid.di.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideSharedPrefs(context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)
}
