package com.smedialink.tokenplussteamid.mapper

import com.smedialink.tokenplussteamid.entity.Match
import com.smedialink.tokenplussteamid.features.matches.recentmatches.entity.MatchItemUiModel
import javax.inject.Inject

/**
 * Created by six_hundreds on 02.04.18.
 */
class MatchItemMapper @Inject constructor(): UiMapper<MatchItemUiModel, Match> {

    override fun mapToUi(input: Match): MatchItemUiModel =
            MatchItemUiModel(
                    input.matchId,
                    input.heroId,
                    input.isWin,
                    input.startTime)
}