package com.smedialink.tokenplussteamid.mapper

import com.smedialink.tokenplussteamid.entity.Match
import com.smedialink.tokenplussteamid.features.matches.matchdetails.entity.MatchUiModel
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by six_hundreds on 01.02.18.
 */
class MatchMapper @Inject constructor() : Function<Match, MatchUiModel> {

    private val radiantSlots = listOf(0, 1, 2, 3, 4)

    override fun apply(input: Match): MatchUiModel =
            MatchUiModel(
                    input.matchId,
                    input.startTime * 1000,
                    true, //todo stub!
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