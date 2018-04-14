package com.smedialink.tokenplussteamid.usecase.users

import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.repository.IUserRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 09.04.18.
 */
class GetUserByAccountIdUseCase @Inject constructor(private val userRepository: IUserRepository) {

    fun getByAccountId(accountId: Long): Single<User> =
            userRepository.getUserByAccountId(accountId)
}