package com.smedialink.tokenplussteamid.data.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by six_hundreds on 01.02.18.
 */
@Entity(tableName = "matches")
data class MatchModel(
        @PrimaryKey
        @SerializedName("match_id")
        val matchId: Long,
        @SerializedName("hero_id")
        val heroId: Int,
        @SerializedName("duration")
        val duration: Int,
        @SerializedName("start_time")
        val startTime: Long,
        @SerializedName("is_win")
        val isWin: Boolean,
        @SerializedName("radiant_score")
        val radiantScore: Int,
        @SerializedName("dire_score")
        val direScore: Int,
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
            @SerializedName("leaver_status")
            val leaverStatus: Boolean,
            @SerializedName("personaname")
            val personaName: String
    )
}