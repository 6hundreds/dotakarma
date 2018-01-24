package com.smedialink.tokenplussteamid.interactor.player

import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.interactor.SingleUseCase
import com.smedialink.tokenplussteamid.repository.CachePolicy
import com.smedialink.tokenplussteamid.repository.player.IUserRepository
import io.reactivex.Single
import javax.inject.Inject

class GetRemotePlayerProfile @Inject constructor(
    private val repository: IUserRepository
) : SingleUseCase<User> {

    override fun execute(): Single<User> =
        repository
            .getUserProfile(CachePolicy.REMOTE)
}
