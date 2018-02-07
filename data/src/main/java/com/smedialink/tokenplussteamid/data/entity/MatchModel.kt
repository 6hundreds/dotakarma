package com.smedialink.tokenplussteamid.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.smedialink.tokenplussteamid.data.converter.MatchPlayerConverter

/**
 * Created by six_hundreds on 01.02.18.
 */
@Entity(tableName = "matches")
@TypeConverters(MatchPlayerConverter::class)
data class MatchModel(
        @PrimaryKey
        @SerializedName("match_id")
        @ColumnInfo(name = "match_id")
        var matchId: Long = 0,
        @SerializedName("hero_id")
        var heroId: Int = 0,
        @SerializedName("duration")
        var duration: Int = 0,
        @SerializedName("start_time")
        var startTime: Long = 0,
        @SerializedName("is_win")
        var isWin: Boolean = false,
        @SerializedName("radiant_score")
        var radiantScore: Int = 0,
        @SerializedName("dire_score")
        var direScore: Int = 0,
        @SerializedName("players")
        var players: List<MatchPlayerModel> = ArrayList()

) {

        data class MatchPlayerModel(
                @SerializedName("account_id")
                var accountId: Long = 0,
                @SerializedName("hero_id")
                var heroId: Int = 0,
                @SerializedName("player_slot")
                var playerSlot: Int = 0,
                @SerializedName("kda")
                var kda: String = "",
                @SerializedName("leaver_status")
                var leaverStatus: Boolean = false,
                @SerializedName("personaname")
                var personaName: String = ""
        )
}