package com.smedialink.tokenplussteamid.data.repository.datasource

import com.smedialink.tokenplussteamid.data.entity.RegisteredPlayerEntity
import io.objectbox.BoxStore
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class LocalDataStore @Inject constructor(
        private val boxStore: BoxStore
) : DataStore {

    override fun getPlayerProfile(): Single<RegisteredPlayerEntity> {
        val playerBox = boxStore.boxFor(RegisteredPlayerEntity::class.java)
        val players = playerBox.query().build().find().first()
        return Single.just(players)
    }

    override fun savePlayerProfile(player: RegisteredPlayerEntity): Completable =
            Completable.create { emitter ->
                val playerBox = boxStore.boxFor(RegisteredPlayerEntity::class.java)
                playerBox.put(player)
                emitter.onComplete()
            }
}
