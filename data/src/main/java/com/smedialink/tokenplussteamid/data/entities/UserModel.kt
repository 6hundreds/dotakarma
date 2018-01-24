package com.smedialink.tokenplussteamid.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class UserModel(
        @PrimaryKey
        var id: Long,
        @SerializedName("steamid")
        var steamId: Long = 0,
        @SerializedName("karma")
        val karma: Int = 0,
        @SerializedName("personaname")
        var personaName: String = "",
        @SerializedName("avatar")
        var avatar: String = "",
        @SerializedName("avatarmedium")
        var avatarMedium: String = "",
        @SerializedName("avatarfull")
        var avatarFull: String = "",
        @SerializedName("personastate")
        var personaState: Int = 0,
        @SerializedName("realname")
        var realName: String? = ""
)
