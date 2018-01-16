package com.smedialink.tokenplussteamid.data.repository.datasource

import com.smedialink.tokenplussteamid.data.repository.DataStoreStrategy
import javax.inject.Inject

class DataStoreFactory @Inject constructor(
        private val localDataStore: LocalDataStore,
        private val remoteDataStore: RemoteDataStore) {

    fun create(strategy: Long): DataStore =
            when (strategy) {
                DataStoreStrategy.LOCAL -> localDataStore
                else -> remoteDataStore
            }
}
