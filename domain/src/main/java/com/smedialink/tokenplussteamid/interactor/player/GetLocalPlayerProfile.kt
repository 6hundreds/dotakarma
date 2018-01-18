package com.smedialink.tokenplussteamid.interactor.player

import com.smedialink.tokenplussteamid.entity.Player
import com.smedialink.tokenplussteamid.interactor.SingleUseCase
import com.smedialink.tokenplussteamid.repository.DataStoreStrategy
import com.smedialink.tokenplussteamid.repository.player.PlayerProfileRepository
import io.reactivex.Single
import javax.inject.Inject

class GetLocalPlayerProfile @Inject constructor(
    private val repository: PlayerProfileRepository
) : SingleUseCase<Player> {

    override fun execute(): Single<Player> =
        repository
            .getUserProfile(DataStoreStrategy.LOCAL)
}
