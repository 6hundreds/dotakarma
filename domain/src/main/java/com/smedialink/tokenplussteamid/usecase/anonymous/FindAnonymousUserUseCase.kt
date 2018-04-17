package com.smedialink.tokenplussteamid.usecase.anonymous

import com.smedialink.tokenplussteamid.entity.AnonymousUser
import com.smedialink.tokenplussteamid.repository.IUserRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 16.04.18.
 */
class FindAnonymousUserUseCase @Inject constructor(private val userRepository: IUserRepository) {

    fun findUser(accountId: Long): Single<AnonymousUser> = userRepository.findAnonymousUser(accountId)
}