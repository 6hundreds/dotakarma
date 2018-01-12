package com.smedialink.tokenplussteamid.repository.datasource

import com.smedialink.tokenplussteamid.entity.RegisteredPlayerEntity
import io.objectbox.BoxStore
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class LocalDataStore @Inject constructor(
        private val boxStore: BoxStore
) : DataStore {

    override fun getPlayerProfile(): Single<RegisteredPlayerEntity> {
        val playerBox = boxStore.boxFor(RegisteredPlayerEntity::class.java)
        val player = playerBox.all.first()
        return Single.just(player)
    }

    override fun savePlayerProfile(player: RegisteredPlayerEntity): Completable =
            Completable.create { emitter ->
                val playerBox = boxStore.boxFor(RegisteredPlayerEntity::class.java)
                playerBox.put(player)
                emitter.onComplete()
            }
}
