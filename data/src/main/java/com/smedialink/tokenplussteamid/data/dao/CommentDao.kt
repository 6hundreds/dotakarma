package com.smedialink.tokenplussteamid.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.smedialink.tokenplussteamid.data.entity.CommentModel
import io.reactivex.Single

/**
 * Created by six_hundreds on 24.01.18.
 */
@Dao
interface CommentDao : BaseDao<CommentModel> {

    @Query("SELECT * FROM comments WHERE id > :fromId LIMIT = :limit")
    fun getComments(fromId: Int, limit: Int): Single<List<CommentModel>>

}