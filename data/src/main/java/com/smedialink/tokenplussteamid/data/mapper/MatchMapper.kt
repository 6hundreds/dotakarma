package com.smedialink.tokenplussteamid.data.mapper

import com.smedialink.tokenplussteamid.data.entity.MatchModel
import com.smedialink.tokenplussteamid.entity.Match
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by six_hundreds on 01.02.18.
 */
class MatchMapper @Inject constructor() : Function<List<MatchModel>, List<Match>> {

    override fun apply(input: List<MatchModel>): List<Match> =
            input.map {
                Match(it.matchId,
                        it.heroId,
                        it.duration,
                        it.startTime,
                        it.isWin,
                        it.radiantScore,
                        it.direScore,
                        it.players.map { player ->
                            Match.MatchPlayer(player.accountId,
                                    player.heroId,
                                    player.playerSlot,
                                    player.kda,
                                    player.leaverStatus,
                                    player.personaName)
                        }
                )
            }

}