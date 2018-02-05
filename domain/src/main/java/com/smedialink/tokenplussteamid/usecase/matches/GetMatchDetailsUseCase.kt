package com.smedialink.tokenplussteamid.usecase.matches

import com.smedialink.tokenplussteamid.entity.Match
import com.smedialink.tokenplussteamid.repository.IMatchRepository
import com.smedialink.tokenplussteamid.usecase.SingleUseCaseWithParameter
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 05.02.18.
 */
class GetMatchDetailsUseCase @Inject constructor(private val repository: IMatchRepository)
    : SingleUseCaseWithParameter<Long, Match> {

    override fun execute(parameter: Long): Single<Match> =
            repository.getMatchById(parameter)

}