package com.smedialink.tokenplussteamid.usecase.user

import com.smedialink.tokenplussteamid.CachePolicy
import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.usecase.SingleUseCaseWithParameter
import com.smedialink.tokenplussteamid.repository.IUserRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 24.01.18.
 */
class GetUserUseCase @Inject constructor(private val repository: IUserRepository)
    : SingleUseCaseWithParameter<CachePolicy, User> {

    override fun execute(parameter: CachePolicy): Single<User> =
            repository.getUser(parameter)
}