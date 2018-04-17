package com.smedialink.tokenplussteamid.data.repository

import com.smedialink.tokenplussteamid.data.caching.CacheManager
import com.smedialink.tokenplussteamid.data.caching.CachingRepository
import com.smedialink.tokenplussteamid.data.entity.MatchModel
import com.smedialink.tokenplussteamid.data.entity.MatchPlayerModel
import com.smedialink.tokenplussteamid.data.ext.mapList
import com.smedialink.tokenplussteamid.data.mapper.MatchMapper
import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import com.smedialink.tokenplussteamid.data.persistence.RealmManager
import com.smedialink.tokenplussteamid.entity.Match
import com.smedialink.tokenplussteamid.repository.IMatchRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 01.02.18.
 */
class MatchRepository @Inject constructor(
        private val api: DotaKarmaApi,
        private val realm: RealmManager,
        private val mapper: MatchMapper,
        override val cacheManager: CacheManager)
    : IMatchRepository, CachingRepository {

    override fun getExpirationTime(): Long = 10 * 1000

    override fun getRecentMatches(): Single<List<Match>> =
            Single.fromCallable { cacheManager.isExpired(this) }
                    .flatMap { expired ->
                        if (expired)
                            api.fetchMatches()
                                    .doOnSuccess {
                                        realm.clearTable<MatchPlayerModel>()
                                        realm.clearTable<MatchModel>()
                                        realm.saveOrUpdate(it)
                                        cacheManager.update(this)
                                    }
                        else realm.findAllAsync()
                    }
                    .mapList(mapper::mapToDomain)

    override fun getMatchById(matchId: Long): Single<Match> =
            realm.findOneAsync<MatchModel>("matchId", matchId)
                    .map(mapper::mapToDomain)
}