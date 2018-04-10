package com.smedialink.tokenplussteamid.usecase.users

import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.repository.IUserRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 09.04.18.
 */
class GetUserByIdUseCase @Inject constructor(private val userRepository: IUserRepository) {

    fun getById(userId: Int): Single<User> =
            userRepository.getUserById(userId)
}