package com.smedialink.tokenplussteamid.data.repository

import com.smedialink.tokenplussteamid.data.dao.UserDao
import com.smedialink.tokenplussteamid.data.mapper.UserMapper
import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.CachePolicy
import com.smedialink.tokenplussteamid.repository.IUserRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class UserRepository @Inject constructor(
        private val api: DotaKarmaApi,
        private val dao: UserDao,
        private val mapper: UserMapper
) : IUserRepository {

    override fun getUser(policy: CachePolicy): Single<User> =
            when (policy) {
                CachePolicy.LOCAL -> api.fetchUserProfile()
                CachePolicy.REMOTE -> dao.getUser()
            }.map { mapper.mapToDomain(it) }

    override fun storeUser(user: User): Completable =
            Completable.fromAction {
                mapper.mapToData(user)
                        .let { dao.insert(it) }
            }
}
