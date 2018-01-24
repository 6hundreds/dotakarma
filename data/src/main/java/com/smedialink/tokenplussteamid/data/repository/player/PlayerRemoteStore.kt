package com.smedialink.tokenplussteamid.data.repository.player

import com.smedialink.tokenplussteamid.data.entities.UserModel
import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import com.smedialink.tokenplussteamid.data.repository.datasource.DataStore
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class PlayerRemoteStore @Inject constructor(
    private val api: DotaKarmaApi
) : DataStore<UserModel> {

    override fun get(): Single<UserModel> = api.fetchUserProfile()

    override fun put(t: UserModel): Completable {
        return Completable.error(UnsupportedOperationException())
    }
}