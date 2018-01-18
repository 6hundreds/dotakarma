package com.smedialink.tokenplussteamid.data.repository.player

import com.smedialink.tokenplussteamid.data.entity.PlayerDataModel
import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import com.smedialink.tokenplussteamid.data.repository.datasource.DataStore
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class PlayerRemoteStore @Inject constructor(
    private val api: DotaKarmaApi
) : DataStore<PlayerDataModel> {

    override fun get(): Single<PlayerDataModel> = api.fetchPlayerProfile()

    override fun put(t: PlayerDataModel): Completable {
        return Completable.error(UnsupportedOperationException())
    }
}