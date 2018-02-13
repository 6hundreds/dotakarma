package com.smedialink.tokenplussteamid.usecase.matches

import com.smedialink.tokenplussteamid.entity.Match
import com.smedialink.tokenplussteamid.repository.IMatchRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 01.02.18.
 */
class GetRecentMatchesUseCase @Inject constructor(private val repository: IMatchRepository) {

    fun getRecentMatches(): Single<List<Match>> =
            repository.getRecentMatches()
}