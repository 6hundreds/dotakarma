package com.smedialink.tokenplussteamid.data.repository

import com.smedialink.tokenplussteamid.data.mapper.CommentMapper
import com.smedialink.tokenplussteamid.data.mapper.UserMapper
import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.repository.IUserRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 09.04.18.
 */
class UserRepository @Inject constructor(
        private val api: DotaKarmaApi,
        private val commentMapper: CommentMapper,
        private val userMapper: UserMapper)
    : IUserRepository {


    override fun getUserById(id: Int): Single<User> {
        return Single.error(Throwable("ass"))
    }

}