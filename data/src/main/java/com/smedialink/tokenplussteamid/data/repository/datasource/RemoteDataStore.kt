package com.smedialink.tokenplussteamid.data.repository.datasource

import com.smedialink.tokenplussteamid.data.entity.RegisteredPlayerEntity
import com.smedialink.tokenplussteamid.data.manager.SettingsManager
import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class RemoteDataStore @Inject constructor(
        private val serverApi: DotaKarmaApi,
        private val settingsManager: SettingsManager
) : DataStore {

    companion object {
        private const val TOKEN_HEADER_PARAM = "x-access-token"
    }

    override fun getPlayerProfile(): Single<RegisteredPlayerEntity> =
            serverApi
                    .loadPlayerProfile(
                            headers = mapOf(TOKEN_HEADER_PARAM to settingsManager.getSavedToken())
                    )

    override fun savePlayerProfile(player: RegisteredPlayerEntity): Completable =
            Completable.complete()
}
