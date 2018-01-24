package com.smedialink.tokenplussteamid.data.repository.player

import com.smedialink.tokenplussteamid.data.mapper.UserMapper
import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.repository.player.PlayerProfileRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class PlayerProfileRepositoryImpl @Inject constructor(
    private val dataStoreFactory: PlayerDataStoreFactory,
    private val dataMapper: UserMapper
) : PlayerProfileRepository {

    override fun getUserProfile(strategy: Long): Single<User> {
        return dataStoreFactory
            .create(strategy)
            .get()
            .map { player -> dataMapper.transformFromDataModel(player) }
    }

    override fun saveUserProfile(user: User, strategy: Long): Completable {
        val entity = dataMapper.transformToDataModel(user)
        return dataStoreFactory.create(strategy).put(entity)
    }

}
