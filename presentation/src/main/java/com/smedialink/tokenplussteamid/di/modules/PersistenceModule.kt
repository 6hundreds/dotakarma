package com.smedialink.tokenplussteamid.app.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.smedialink.tokenplussteamid.data.dao.CommentDao
import com.smedialink.tokenplussteamid.data.dao.UserDao
import com.smedialink.tokenplussteamid.persistence.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by six_hundreds on 29.01.18.
 */

@Module
class PersistenceModule {

    @Provides
    @Singleton
    fun provideStorage(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "karma-database").build()

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()

    @Provides
    fun provideCommentDao(db: AppDatabase): CommentDao = db.commentDao()

}