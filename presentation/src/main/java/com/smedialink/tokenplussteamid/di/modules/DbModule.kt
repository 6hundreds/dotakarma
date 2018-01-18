package com.smedialink.tokenplussteamid.di.modules

import android.content.Context
import com.smedialink.tokenplussteamid.data.entity.MyObjectBox
import dagger.Module
import dagger.Provides
import io.objectbox.BoxStore
import javax.inject.Singleton

@Module
class DbModule {

    @Provides
    @Singleton
    fun provideBoxStore(context: Context): BoxStore =
        MyObjectBox.builder().androidContext(context).build()
}
