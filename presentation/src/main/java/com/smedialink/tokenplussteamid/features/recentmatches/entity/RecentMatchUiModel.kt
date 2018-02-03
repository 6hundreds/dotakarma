package com.smedialink.tokenplussteamid.features.recentmatches.entity

import com.smedialink.tokenplussteamid.features.recentmatches.adapter.MatchesItem

/**
 * Created by six_hundreds on 01.02.18.
 */
data class RecentMatchUiModel(
        val startTime: Long,
        val heroId: Int,
        val isWin: Boolean,
        val duration: Int,
        val radiantScore: Int,
        val direScore: Int,
        val players: List<MatchPlayerUiModel>
) : MatchesItem {

    data class MatchPlayerUiModel(
            val accountId: Long,
            val heroId: Int,
            val kda: String,
            val leaverStatus: Boolean,
            val personaName: String
    )
}