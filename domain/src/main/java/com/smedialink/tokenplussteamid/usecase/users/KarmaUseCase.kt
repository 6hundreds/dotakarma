package com.smedialink.tokenplussteamid.usecase.users

import com.smedialink.tokenplussteamid.repository.IUserRepository
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by six_hundreds on 19.04.18.
 */
class KarmaUseCase @Inject constructor(private val userRepository: IUserRepository) {

    fun karmaUp(accountId: Long): Completable = userRepository.incrementKarma(accountId)

    fun karmaDown(accountId: Long): Completable = userRepository.decrementKarma(accountId)
}