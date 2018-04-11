package com.smedialink.tokenplussteamid.repository

import com.smedialink.tokenplussteamid.entity.User
import io.reactivex.Single

interface IUserRepository {

    fun getUserById(id: Int): Single<User>

    fun getUserByAccountId(accountId: Long): Single<User>

}
