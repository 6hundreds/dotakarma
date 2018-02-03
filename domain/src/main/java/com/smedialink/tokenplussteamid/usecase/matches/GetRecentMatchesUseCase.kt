package com.smedialink.tokenplussteamid.usecase.matches

import com.smedialink.tokenplussteamid.entity.Match
import com.smedialink.tokenplussteamid.repository.IMatchRepository
import com.smedialink.tokenplussteamid.usecase.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 01.02.18.
 */
class GetRecentMatchesUseCase @Inject constructor(private val repository: IMatchRepository)
    : SingleUseCase<List<Match>> {

    override fun execute(): Single<List<Match>> =
            repository.getRecentMatches()
}