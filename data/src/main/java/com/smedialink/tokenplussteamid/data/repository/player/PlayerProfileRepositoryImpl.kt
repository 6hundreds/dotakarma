package com.smedialink.tokenplussteamid.data.repository.player

import com.smedialink.tokenplussteamid.data.entity.mapper.PlayerProfileMapper
import com.smedialink.tokenplussteamid.entity.RegisteredPlayer
import com.smedialink.tokenplussteamid.repository.PlayerProfileRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class PlayerProfileRepositoryImpl @Inject constructor(
        private val dataStoreFactory: PlayerDataStoreFactory,
        private val dataMaper: PlayerProfileMapper
) : PlayerProfileRepository {

    override fun loadUserProfile(strategy: Long): Single<RegisteredPlayer> {

        return dataStoreFactory
                .create(strategy)
                .get()
                .map { player -> dataMaper.transformFromEntity(player) }
    }

    override fun saveUserProfile(player: RegisteredPlayer, strategy: Long): Completable =
            Completable.create { emitter ->
                val entity = dataMaper.transformToEntity(player)
                val dataStore = dataStoreFactory.create(strategy)
                dataStore.put(entity)
                emitter.onComplete()
            }
}
