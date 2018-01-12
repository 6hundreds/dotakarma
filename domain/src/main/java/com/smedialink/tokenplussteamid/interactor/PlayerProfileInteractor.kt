package com.smedialink.tokenplussteamid.interactor

import com.smedialink.tokenplussteamid.entity.RegisteredPlayer
import com.smedialink.tokenplussteamid.repository.RegisteredPlayerRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class PlayerProfileInteractor @Inject constructor(
        private val userRepository: RegisteredPlayerRepository) {

    fun performProfileLoading(strategy: Long): Single<RegisteredPlayer> =
            userRepository
                    .loadUserProfile(strategy)

    fun performProfileSaving(player: RegisteredPlayer, strategy: Long): Completable =
            userRepository
                    .saveUserProfile(player, strategy)
}
