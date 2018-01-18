package com.smedialink.tokenplussteamid.data.repository.player

import com.smedialink.tokenplussteamid.data.mapper.PlayerProfileMapper
import com.smedialink.tokenplussteamid.entity.Player
import com.smedialink.tokenplussteamid.repository.player.PlayerProfileRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class PlayerProfileRepositoryImpl @Inject constructor(
    private val dataStoreFactory: PlayerDataStoreFactory,
    private val dataMapper: PlayerProfileMapper
) : PlayerProfileRepository {

    override fun getUserProfile(strategy: Long): Single<Player> {
        return dataStoreFactory
            .create(strategy)
            .get()
            .map { player -> dataMapper.transformFromDataModel(player) }
    }

    override fun saveUserProfile(player: Player, strategy: Long): Completable {
        val entity = dataMapper.transformToDataModel(player)
        return dataStoreFactory.create(strategy).put(entity)
    }

}
