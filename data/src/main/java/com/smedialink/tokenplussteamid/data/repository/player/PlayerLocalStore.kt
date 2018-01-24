package com.smedialink.tokenplussteamid.data.repository.player

import com.smedialink.tokenplussteamid.data.entities.UserModel
import com.smedialink.tokenplussteamid.data.repository.datasource.DataStore
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class PlayerLocalStore @Inject constructor(
) : DataStore<UserModel> {

    override fun get(): Single<UserModel> = Single.create { emitter -> emitter.onError(NotImplementedError()) }

    override fun put(t: UserModel): Completable = Completable.complete()
}
