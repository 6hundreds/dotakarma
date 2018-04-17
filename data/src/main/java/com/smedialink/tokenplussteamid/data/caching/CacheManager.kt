package com.smedialink.tokenplussteamid.data.caching

import javax.inject.Inject
import kotlin.reflect.KClass

/**
 * Created by six_hundreds on 13.04.18.
 */
class CacheManager @Inject constructor() {

    private val lastUpdates: MutableMap<KClass<out CachingRepository>, Long> = mutableMapOf()

    private val crcs: MutableMap<KClass<out CachingRepository>, Long> = mutableMapOf()

    fun isExpired(repo: CachingRepository): Boolean =
            lastUpdates[repo::class]?.let { lastUpdate ->
                (System.currentTimeMillis() - lastUpdate) > repo.getExpirationTime()
            } ?: true

    fun update(repo: CachingRepository) {
        lastUpdates.remove(repo::class)
        lastUpdates[repo::class] = System.currentTimeMillis()
    }
}