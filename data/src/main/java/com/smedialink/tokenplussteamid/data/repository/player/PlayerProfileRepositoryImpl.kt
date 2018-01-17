package com.smedialink.tokenplussteamid.data.repository.player

import com.smedialink.tokenplussteamid.data.mapper.PlayerProfileMapper
import com.smedialink.tokenplussteamid.entity.Player
import com.smedialink.tokenplussteamid.repository.player.PlayerProfileRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class PlayerProfileRepositoryImpl @Inject constructor(
    private val dataStoreFactory: PlayerDataStoreFactory,
    private val dataMaper: PlayerProfileMapper
) : PlayerProfileRepository {

    override fun getUserProfile(strategy: Long): Single<Player> {

        return dataStoreFactory
            .create(strategy)
            .get()
            .map { player -> dataMaper.transformFromDataModel(player) }
    }

    override fun saveUserProfile(player: Player, strategy: Long): Completable =
        Completable.create { emitter ->
            val entity = dataMaper.transformToDataModel(player)
            val dataStore = dataStoreFactory.create(strategy)
            dataStore.put(entity)
            emitter.onComplete()
        }
}
