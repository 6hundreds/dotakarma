package com.smedialink.tokenplussteamid.data.repository

import com.smedialink.tokenplussteamid.data.entity.mapper.RegisteredPlayerMapper
import com.smedialink.tokenplussteamid.data.repository.datasource.DataStoreFactory
import com.smedialink.tokenplussteamid.entity.RegisteredPlayer
import com.smedialink.tokenplussteamid.repository.RegisteredPlayerRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class RegisteredPlayerRepositoryImpl @Inject constructor(
        private val dataStoreFactory: DataStoreFactory,
        private val dataMaper: RegisteredPlayerMapper
) : RegisteredPlayerRepository {

    override fun loadUserProfile(strategy: Long): Single<RegisteredPlayer> {

        val dataStore = dataStoreFactory.create(strategy)

        return dataStore
                .getPlayerProfile()
                .map { player -> dataMaper.transformFromEntity(player) }
    }

    override fun saveUserProfile(player: RegisteredPlayer, strategy: Long): Completable =
            Completable.create { emitter ->
                val entity = dataMaper.transformToEntity(player)
                val dataStore = dataStoreFactory.create(strategy)
                dataStore.savePlayerProfile(entity)
                emitter.onComplete()
            }
}
