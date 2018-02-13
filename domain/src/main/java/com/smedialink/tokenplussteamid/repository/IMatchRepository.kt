package com.smedialink.tokenplussteamid.repository

import com.smedialink.tokenplussteamid.entity.Match
import io.reactivex.Single

/**
 * Created by six_hundreds on 01.02.18.
 */
interface IMatchRepository {

    fun getRecentMatches(): Single<List<Match>>

    fun getMatchById(matchId: Long): Single<Match>
}