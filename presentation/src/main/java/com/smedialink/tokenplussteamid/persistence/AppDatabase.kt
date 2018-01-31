package com.smedialink.tokenplussteamid.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.smedialink.tokenplussteamid.data.dao.CommentDao
import com.smedialink.tokenplussteamid.data.dao.UserDao
import com.smedialink.tokenplussteamid.data.entity.CommentModel
import com.smedialink.tokenplussteamid.data.entity.UserModel

/**
 * Created by six_hundreds on 29.01.18.
 */
@Database(entities = [UserModel::class, CommentModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun commentDao(): CommentDao
}