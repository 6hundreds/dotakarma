package com.smedialink.tokenplussteamid.interactor.player

import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.interactor.CompletableUseCaseWithParameter
import com.smedialink.tokenplussteamid.repository.CachePolicy
import com.smedialink.tokenplussteamid.repository.player.IUserRepository
import io.reactivex.Completable
import javax.inject.Inject

class SaveAsLocalPlayerProfile @Inject constructor(
    private val repository: IUserRepository
) : CompletableUseCaseWithParameter<User> {

    override fun execute(parameter: User): Completable =
        repository
            .storeUser(parameter, CachePolicy.LOCAL)
}
