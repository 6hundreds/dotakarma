package com.smedialink.tokenplussteamid.data.repository.datasource

import com.smedialink.tokenplussteamid.data.entity.RegisteredPlayerEntity
import io.reactivex.Completable
import io.reactivex.Single

interface DataStore {

    fun getPlayerProfile(): Single<RegisteredPlayerEntity>

    fun savePlayerProfile(player: RegisteredPlayerEntity): Completable
}
