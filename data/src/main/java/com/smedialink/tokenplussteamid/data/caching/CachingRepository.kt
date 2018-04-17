package com.smedialink.tokenplussteamid.data.caching

/**
 * Created by six_hundreds on 13.04.18.
 */
interface CachingRepository {

    val cacheManager: CacheManager

    fun getExpirationTime(): Long
}