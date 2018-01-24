package com.smedialink.tokenplussteamid.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.smedialink.tokenplussteamid.data.entities.UserModel
import io.reactivex.Single

/**
 * Created by six_hundreds on 24.01.18.
 */
@Dao
interface UserDao : BaseDao<UserModel> {

    @Query("SELECT * FROM users LIMIT 1")
    fun getUser(): Single<UserModel>
}