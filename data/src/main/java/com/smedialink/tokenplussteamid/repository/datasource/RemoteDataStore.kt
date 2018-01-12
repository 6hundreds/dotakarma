package com.smedialink.tokenplussteamid.repository.datasource

import com.smedialink.tokenplussteamid.entity.RegisteredPlayerEntity
import com.smedialink.tokenplussteamid.network.ServerApi
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class RemoteDataStore @Inject constructor(
        private val serverApi: ServerApi
) : DataStore {

    override fun getPlayerProfile(): Single<RegisteredPlayerEntity> =
            serverApi
                    .loadPlayerProfile()

    override fun savePlayerProfile(player: RegisteredPlayerEntity): Completable =
            Completable.complete()
}
