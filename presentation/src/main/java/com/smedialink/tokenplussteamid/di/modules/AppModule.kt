package com.smedialink.tokenplussteamid.di.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.smedialink.tokenplussteamid.data.entity.MyObjectBox
import com.smedialink.tokenplussteamid.data.manager.SettingsManager
import dagger.Module
import dagger.Provides
import io.objectbox.BoxStore
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideSharedPrefs(context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    @Singleton
    fun provideSettingsManager(prefs: SharedPreferences): SettingsManager = SettingsManager(prefs)

    @Provides
    @Singleton
    fun provideBoxStore(context: Context): BoxStore =
            MyObjectBox.builder().androidContext(context).build()
}
