package com.smedialink.tokenplussteamid.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class UserModel(
        @PrimaryKey
        var id: Long = 0,
        @ColumnInfo(name = "steam_id")
        @SerializedName("steamid")
        var steamId: Long = 0,
        @SerializedName("karma")
        var karma: Int = 0,
        @ColumnInfo(name = "persona_name")
        @SerializedName("personaname")
        var personaName: String = "",
        @SerializedName("avatar")
        var avatar: String = "",
        @ColumnInfo(name = "persona_medium")
        @SerializedName("avatarmedium")
        var avatarMedium: String = "",
        @ColumnInfo(name = "persona_full")
        @SerializedName("avatarfull")
        var avatarFull: String = "",
        @ColumnInfo(name = "persona_state")
        @SerializedName("personastate")
        var personaState: Int = 0,
        @ColumnInfo(name = "real_name")
        @SerializedName("realname")
        var realName: String? = ""
)
