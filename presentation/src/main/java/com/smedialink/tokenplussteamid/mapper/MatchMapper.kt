package com.smedialink.tokenplussteamid.mapper

import com.smedialink.tokenplussteamid.entity.Match
import com.smedialink.tokenplussteamid.features.matches.matchdetails.entity.MatchUiModel
import javax.inject.Inject

/**
 * Created by six_hundreds on 01.02.18.
 */
class MatchMapper @Inject constructor() : UiMapper<MatchUiModel, Match> {

    private val radiantSlots = listOf(0, 1, 2, 3, 4)

    override fun mapToUi(input: Match): MatchUiModel =
            MatchUiModel(
                    input.matchId,
                    input.startTime,
                    input.radiantWin,
                    input.duration,
                    input.radiantScore,
                    input.direScore,
                    input.players.map { player ->
                        MatchUiModel.MatchPlayerUiModel(
                                player.accountId,
                                player.heroId,
                                player.playerSlot in radiantSlots,
                                player.kda,
                                player.leaverStatus,
                                player.personaName
                        )
                    })

}