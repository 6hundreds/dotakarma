package com.smedialink.tokenplussteamid.repository.player

import com.smedialink.tokenplussteamid.entity.User
import io.reactivex.Completable
import io.reactivex.Single

interface PlayerProfileRepository {

    fun getUserProfile(strategy: Long): Single<User>

    fun saveUserProfile(user: User, strategy: Long): Completable
}
