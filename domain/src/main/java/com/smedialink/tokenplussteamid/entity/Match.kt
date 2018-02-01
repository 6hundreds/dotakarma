package com.smedialink.tokenplussteamid.entity

/**
 * Created by six_hundreds on 01.02.18.
 */
data class Match(
        val matchId: Long,
        val duration: Int,
        val radiantScore: Int,
        val direScore: Int,
        val radiantWin: Boolean,
        val players: List<MatchPlayer>

) {
    data class MatchPlayer(
            val accountId: Long,
            val heroId: Int,
            val playerSlot: Int,
            val kda: String,
            val personaname: String
    )
}