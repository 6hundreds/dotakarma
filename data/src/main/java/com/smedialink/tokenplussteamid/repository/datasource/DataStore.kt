package com.smedialink.tokenplussteamid.repository.datasource

import com.smedialink.tokenplussteamid.entity.RegisteredPlayerEntity
import io.reactivex.Completable
import io.reactivex.Single

interface DataStore {

    fun getPlayerProfile(): Single<RegisteredPlayerEntity>

    fun savePlayerProfile(player: RegisteredPlayerEntity): Completable
}
