package com.smedialink.tokenplussteamid.data.mapper

import com.smedialink.tokenplussteamid.data.entity.MatchModel
import com.smedialink.tokenplussteamid.entity.Match
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by six_hundreds on 01.02.18.
 */
class MatchMapper @Inject constructor() : Function<MatchModel, Match> {

    override fun apply(input: MatchModel): Match =
            Match(input.matchId,
                    input.heroId,
                    input.duration,
                    input.startTime,
                    input.isWin,
                    input.radiantWin,
                    input.radiantScore,
                    input.direScore,
                    input.players.map { player ->
                        Match.MatchPlayer(player.accountId,
                                player.heroId,
                                player.playerSlot,
                                player.kda,
                                player.leaverStatus,
                                player.personaName)
                    }
            )

}