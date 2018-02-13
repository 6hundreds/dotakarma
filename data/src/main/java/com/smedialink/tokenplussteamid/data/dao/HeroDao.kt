package com.smedialink.tokenplussteamid.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.smedialink.tokenplussteamid.data.entity.HeroModel
import io.reactivex.Single

/**
 * Created by six_hundreds on 31.01.18.
 */
@Dao
interface HeroDao : BaseDao<HeroModel> {

    @Query("SELECT * FROM heroes_images WHERE id = :arg0")
    fun getById(heroId: Int): Single<HeroModel>

}