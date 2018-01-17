package com.smedialink.tokenplussteamid.repository

import com.smedialink.tokenplussteamid.entity.RegisteredPlayer
import io.reactivex.Completable
import io.reactivex.Single

interface PlayerProfileRepository {

    fun loadUserProfile(strategy: Long): Single<RegisteredPlayer>

    fun saveUserProfile(player: RegisteredPlayer, strategy: Long): Completable
}
