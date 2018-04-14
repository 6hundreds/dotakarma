package com.smedialink.tokenplussteamid.data.entity

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by six_hundreds on 01.02.18.
 */
open class MatchModel(
        @PrimaryKey
        @SerializedName("match_id")
        var matchId: Long = 0,
        @SerializedName("hero_id")
        var heroId: Int = 0,
        @SerializedName("duration")
        var duration: Int = 0,
        @SerializedName("start_time")
        var startTime: Long = 0,
        @SerializedName("is_win")
        var isWin: Boolean = false,
        @SerializedName("radiant_win")
        var radiantWin: Boolean = false,
        @SerializedName("radiant_score")
        var radiantScore: Int = 0,
        @SerializedName("dire_score")
        var direScore: Int = 0,
        @SerializedName("players")
        var players: RealmList<MatchPlayerModel> = RealmList()

) : RealmObject()
