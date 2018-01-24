package com.smedialink.tokenplussteamid.repository.player

import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.repository.CachePolicy
import io.reactivex.Completable
import io.reactivex.Single

interface IUserRepository {

    fun getUser(policy: CachePolicy): Single<User>

    fun storeUser(user: User): Completable
}
