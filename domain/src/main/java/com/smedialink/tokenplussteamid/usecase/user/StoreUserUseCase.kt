package com.smedialink.tokenplussteamid.usecase.user

import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.usecase.CompletableUseCaseWithParameter
import com.smedialink.tokenplussteamid.repository.IUserRepository
import io.reactivex.Completable
import javax.inject.Inject

class StoreUserUseCase @Inject constructor(
        private val repository: IUserRepository
) : CompletableUseCaseWithParameter<User> {

    override fun execute(parameter: User): Completable =
            repository.storeUser(parameter)
}
