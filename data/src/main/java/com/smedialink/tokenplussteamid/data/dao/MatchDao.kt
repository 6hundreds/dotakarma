package com.smedialink.tokenplussteamid.data.dao

import android.arch.persistence.room.Query
import com.smedialink.tokenplussteamid.data.entity.MatchModel
import io.reactivex.Single

/**
 * Created by six_hundreds on 05.02.18.
 */
interface MatchDao : BaseDao<MatchModel> {

    @Query("SELECT * FROM matches")
    fun getAll(): Single<List<MatchModel>>

    @Query("SELECT * FROM matches WHERE match_id = :arg0")
    fun getById(matchId: Long): Single<MatchModel>

}