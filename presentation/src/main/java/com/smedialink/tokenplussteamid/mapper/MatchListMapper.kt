package com.smedialink.tokenplussteamid.mapper

import com.smedialink.tokenplussteamid.entity.Match
import com.smedialink.tokenplussteamid.features.matches.recentmatches.entity.MatchItemUiModel
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by six_hundreds on 05.02.18.
 */
class MatchListMapper @Inject constructor() : Function<List<Match>, List<MatchItemUiModel>> {

    override fun apply(input: List<Match>): List<MatchItemUiModel> =
            input.map {
                MatchItemUiModel(
                        it.matchId,
                        it.heroId,
                        it.isWin,
                        it.startTime * 1000
                )
            }
}
