package com.smedialink.tokenplussteamid.data.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class UserModel(
        @PrimaryKey
        var id: Long = 0,
        @SerializedName("steamid")
        var steamId: Long = 0,
        @SerializedName("karma")
        var karma: Int = 0,
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
