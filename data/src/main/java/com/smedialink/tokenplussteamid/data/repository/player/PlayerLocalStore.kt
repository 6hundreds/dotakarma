package com.smedialink.tokenplussteamid.data.repository.player

import com.smedialink.tokenplussteamid.data.entity.RegisteredPlayerEntity
import com.smedialink.tokenplussteamid.data.repository.datasource.DataStore
import io.objectbox.BoxStore
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class PlayerLocalStore @Inject constructor(private val boxStore: BoxStore)
    : DataStore<RegisteredPlayerEntity> {

    override fun get(): Single<RegisteredPlayerEntity> {
        val playerBox = boxStore.boxFor(RegisteredPlayerEntity::class.java)
        val players = playerBox.query().build().find().first()
        return Single.just(players)
    }

    override fun put(t: RegisteredPlayerEntity): Completable =
            Completable.fromAction({
                val playerBox = boxStore.boxFor(RegisteredPlayerEntity::class.java)
                playerBox.put(t)
            })
}