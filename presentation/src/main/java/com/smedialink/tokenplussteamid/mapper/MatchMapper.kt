package com.smedialink.tokenplussteamid.mapper

import com.smedialink.tokenplussteamid.entity.Match
import com.smedialink.tokenplussteamid.features.matches.matchdetails.entity.MatchUiModel
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by six_hundreds on 01.02.18.
 */
class MatchMapper @Inject constructor() : Function<List<Match>, List<MatchUiModel>> {

    private val radiantSlots = listOf(0, 1, 2, 3, 4)

    override fun apply(input: List<Match>): List<MatchUiModel> =
            input.map {
                MatchUiModel(
                        it.matchId,
                        it.startTime * 1000,
                        it.heroId,
                        it.isWin,
                        true, //todo stub!
                        it.duration,
                        it.radiantScore,
                        it.direScore,
                        it.players.map { player ->
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

}