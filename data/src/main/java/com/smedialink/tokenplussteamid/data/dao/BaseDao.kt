package com.smedialink.tokenplussteamid.data.dao

import android.arch.persistence.room.Insert

/**
 * Created by six_hundreds on 24.01.18.
 */
interface BaseDao<T> {

    @Insert
    fun insert(entity: T)

    @Insert
    fun insert(entities: ArrayList<T>)

//    @Delete
//    fun deleteById(id: Number)

//    @Update
//    fun update(entity: T)
}