package com.smedialink.tokenplussteamid.features.matches.recentmatches.entity

/**
 * Created by six_hundreds on 05.02.18.
 */
data class MatchItemUiModel(
        val matchId: Long,
        val heroId: Int,
        val isWin: Boolean,
        val startTime: Long)