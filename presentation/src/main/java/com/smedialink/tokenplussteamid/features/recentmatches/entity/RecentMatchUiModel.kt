package com.smedialink.tokenplussteamid.features.recentmatches.entity

import com.smedialink.tokenplussteamid.features.recentmatches.adapter.MatchesItem

/**
 * Created by six_hundreds on 01.02.18.
 */
data class RecentMatchUiModel(
        val duration: Int,
        val radiantScore: Int,
        val direScore: Int,
        val radiantWin: Boolean,
        val heroes: Map<Int, Int>
) : MatchesItem