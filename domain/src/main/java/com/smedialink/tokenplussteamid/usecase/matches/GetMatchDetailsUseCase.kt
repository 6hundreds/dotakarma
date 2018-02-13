package com.smedialink.tokenplussteamid.usecase.matches

import com.smedialink.tokenplussteamid.entity.Match
import com.smedialink.tokenplussteamid.repository.IMatchRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 05.02.18.
 */
class GetMatchDetailsUseCase @Inject constructor(private val repository: IMatchRepository) {

    fun getMatchDetails(matchId: Long): Single<Match> =
            repository.getMatchById(matchId)

}