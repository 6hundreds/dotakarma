package com.smedialink.tokenplussteamid.interactor

import com.smedialink.tokenplussteamid.entity.RegisteredPlayer
import com.smedialink.tokenplussteamid.repository.PlayerProfileRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

//todo try to user atomic useCases
class PlayerProfileInteractor @Inject constructor(
        private val repository: PlayerProfileRepository) {

    fun savePlayerProfileToDb(player: RegisteredPlayer): Completable {

    }

    fun loadPlayerProfileFromDb(): Single<RegisteredPlayer> {

    }

    fun loadPlayerProfileFromServer(): Single<RegisteredPlayer> {

    }
}
