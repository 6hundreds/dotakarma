package com.smedialink.tokenplussteamid.data.entity

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by six_hundreds on 02.04.18.
 */
open class MatchPlayerModel(
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
) : RealmObject()