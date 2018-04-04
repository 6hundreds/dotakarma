package com.smedialink.tokenplussteamid.data.repository

import com.smedialink.tokenplussteamid.data.entity.MatchModel
import com.smedialink.tokenplussteamid.data.entity.MatchPlayerModel
import com.smedialink.tokenplussteamid.data.ext.mapList
import com.smedialink.tokenplussteamid.data.mapper.MatchMapper
import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import com.smedialink.tokenplussteamid.data.persistance.RealmManager
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
        private val mapper: MatchMapper)
    : IMatchRepository {

    override fun getRecentMatches(): Single<List<Match>> =
            api.fetchMatches()
                    .doOnSuccess { realm.clearTable<MatchPlayerModel>() }
                    .doOnSuccess { realm.clearTable<MatchModel>() }
                    .doOnSuccess { realm.saveOrUpdate(it) }
                    .mapList(mapper::mapToDomain)

    override fun getMatchById(matchId: Long): Single<Match> =
            realm.findOneAsync<MatchModel>("matchId", matchId)
                    .map(mapper::mapToDomain)
}