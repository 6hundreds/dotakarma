package com.smedialink.tokenplussteamid.interactor.player

import com.smedialink.tokenplussteamid.entity.Player
import com.smedialink.tokenplussteamid.interactor.CompletableUseCaseWithParameter
import com.smedialink.tokenplussteamid.repository.DataStoreStrategy
import com.smedialink.tokenplussteamid.repository.player.PlayerProfileRepository
import io.reactivex.Completable
import javax.inject.Inject

class SaveAsLocalPlayerProfile @Inject constructor(
    private val repository: PlayerProfileRepository
) : CompletableUseCaseWithParameter<Player> {

    override fun execute(parameter: Player): Completable =
        repository
            .saveUserProfile(parameter, DataStoreStrategy.LOCAL)
}
