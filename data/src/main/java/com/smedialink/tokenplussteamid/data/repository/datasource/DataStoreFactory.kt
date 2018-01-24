package com.smedialink.tokenplussteamid.data.repository.datasource

import com.smedialink.tokenplussteamid.repository.DataStoreStrategy
import javax.inject.Inject

open class DataStoreFactory<T> @Inject constructor(
        private val localDataStore: DataStore<T>,
        private val remoteDataStore: DataStore<T>
) {

    fun create(strategy: DataStoreStrategy): DataStore<T> =
            when (strategy) {
                DataStoreStrategy.LOCAL -> localDataStore
                DataStoreStrategy.REMOTE -> remoteDataStore
            }
}
