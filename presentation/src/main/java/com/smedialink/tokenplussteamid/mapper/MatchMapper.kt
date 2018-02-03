package com.smedialink.tokenplussteamid.mapper

import com.smedialink.tokenplussteamid.entity.Match
import com.smedialink.tokenplussteamid.features.recentmatches.entity.RecentMatchUiModel
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by six_hundreds on 01.02.18.
 */
class MatchMapper @Inject constructor() : Function<List<Match>, List<RecentMatchUiModel>> {

    override fun apply(input: List<Match>): List<RecentMatchUiModel> =
            input.map {
                RecentMatchUiModel(
                        it.startTime * 1000,
                        it.heroId,
                        it.isWin,
                        it.duration,
                        it.radiantScore,
                        it.direScore,
                        it.players.map { player ->
                            RecentMatchUiModel.MatchPlayerUiModel(
                                    player.accountId,
                                    player.heroId,
                                    player.kda,
                                    player.leaverStatus,
                                    player.personaName
                            )
                        })
            }

}