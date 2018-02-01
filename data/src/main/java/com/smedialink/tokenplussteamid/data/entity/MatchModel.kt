package com.smedialink.tokenplussteamid.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by six_hundreds on 01.02.18.
 */
data class MatchModel(
        @SerializedName("match_id")
        val matchId: Long,
        @SerializedName("duration")
        val duration: Int,
        @SerializedName("radiant_score")
        val radiantScore: Int,
        @SerializedName("dire_score")
        val direScore: Int,
        @SerializedName("radiant_win")
        val radiantWin: Boolean,
        @SerializedName("players")
        val players: List<MatchPlayerModel>

) {
    data class MatchPlayerModel(
            @SerializedName("account_id")
            val accountId: Long,
            @SerializedName("hero_id")
            val heroId: Int,
            @SerializedName("player_slot")
            val playerSlot: Int,
            @SerializedName("kda")
            val kda: String,
            @SerializedName("personaname")
            val personaname: String
    )
}