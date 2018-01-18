package com.smedialink.tokenplussteamid.repository.player

import com.smedialink.tokenplussteamid.entity.Player
import io.reactivex.Completable
import io.reactivex.Single

interface PlayerProfileRepository {

    fun getUserProfile(strategy: Long): Single<Player>

    fun saveUserProfile(player: Player, strategy: Long): Completable
}
