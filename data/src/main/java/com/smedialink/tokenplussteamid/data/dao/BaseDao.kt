package com.smedialink.tokenplussteamid.data.dao

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Update

/**
 * Created by six_hundreds on 24.01.18.
 */
interface BaseDao<in T> {

    @Insert
    fun insert(entity: T)

    @Insert
    fun insert(entities: List<T>)

    @Delete
    fun deleteById(id: Number)

    @Update
    fun update(entity: T)
}