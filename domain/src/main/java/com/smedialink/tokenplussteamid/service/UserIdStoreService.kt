package com.smedialink.tokenplussteamid.service

import io.reactivex.Completable

interface UserIdStoreService {

    fun saveSteamUserId(userId: String): Completable
}
