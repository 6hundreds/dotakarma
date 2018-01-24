package com.smedialink.tokenplussteamid.data.repository.player

import com.smedialink.tokenplussteamid.data.entities.UserModel
import com.smedialink.tokenplussteamid.data.repository.datasource.DataStoreFactory
import javax.inject.Inject

class PlayerDataStoreFactory @Inject constructor(
    localStore: PlayerLocalStore,
    remoteStore: PlayerRemoteStore
) : DataStoreFactory<UserModel>(localStore, remoteStore)
