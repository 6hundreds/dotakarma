package com.smedialink.tokenplussteamid.di.modules

import com.smedialink.tokenplussteamid.data.persistance.RealmManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by six_hundreds on 03.04.18.
 */
@Module
class PersistanceModule {

    @Provides
    @Singleton
    fun provideDbManager(): RealmManager = RealmManager()

}