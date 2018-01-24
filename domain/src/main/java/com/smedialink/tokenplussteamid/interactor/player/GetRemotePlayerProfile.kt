package com.smedialink.tokenplussteamid.interactor.player

import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.interactor.SingleUseCase
import com.smedialink.tokenplussteamid.repository.DataStoreStrategy
import com.smedialink.tokenplussteamid.repository.player.PlayerProfileRepository
import io.reactivex.Single
import javax.inject.Inject

class GetRemotePlayerProfile @Inject constructor(
    private val repository: PlayerProfileRepository
) : SingleUseCase<User> {

    override fun execute(): Single<User> =
        repository
            .getUserProfile(DataStoreStrategy.REMOTE)
}
