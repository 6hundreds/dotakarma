package com.smedialink.tokenplussteamid.data.repository

import com.smedialink.tokenplussteamid.data.dao.MatchDao
import com.smedialink.tokenplussteamid.data.mapper.MatchMapper
import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import com.smedialink.tokenplussteamid.entity.Match
import com.smedialink.tokenplussteamid.repository.IMatchRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 01.02.18.
 */
class MatchRepository @Inject constructor(
        private val api: DotaKarmaApi,
        private val dao: MatchDao,
        private val mapper: MatchMapper)
    : IMatchRepository {

    override fun getRecentMatches(): Single<List<Match>> =
            api.fetchMatches()
                    .doOnSuccess { dao.insert(it) }
                    .flatMapObservable { Observable.fromIterable(it) }
                    .map(mapper)
                    .toList()

    override fun getMatchById(matchId: Long): Single<Match> =
            dao.getById(matchId)
                    .map(mapper)

}