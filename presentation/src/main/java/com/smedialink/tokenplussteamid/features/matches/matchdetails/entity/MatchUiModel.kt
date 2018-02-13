package com.smedialink.tokenplussteamid.features.matches.matchdetails.entity

import com.smedialink.tokenplussteamid.features.matches.matchdetails.adapter.MatchDetailsItem

/**
 * Created by six_hundreds on 01.02.18.
 */
data class MatchUiModel(
        val matchId: Long,
        val startTime: Long,
        val radiantWin: Boolean,
        val duration: Int,
        val radiantScore: Int,
        val direScore: Int,
        val players: List<MatchPlayerUiModel>
){
    data class MatchPlayerUiModel(
            val accountId: Long,
            val heroId: Int,
            val isRadiant: Boolean,
            val kda: String,
            val leaverStatus: Boolean,
            val personaName: String
    ) : MatchDetailsItem
}