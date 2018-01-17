package com.smedialink.tokenplussteamid.data.repository.player

import com.smedialink.tokenplussteamid.data.entity.PlayerDataModel
import com.smedialink.tokenplussteamid.data.repository.datasource.DataStore
import io.objectbox.BoxStore
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class PlayerLocalStore @Inject constructor(private val boxStore: BoxStore) :
    DataStore<PlayerDataModel> {

    override fun get(): Single<PlayerDataModel> {
        val playerBox = boxStore.boxFor(PlayerDataModel::class.java)
        val players = playerBox.query().build().find().first()
        return Single.just(players)
    }

    override fun put(t: PlayerDataModel): Completable =
        Completable.fromAction({
            val playerBox = boxStore.boxFor(PlayerDataModel::class.java)
            playerBox.put(t)
        })
}