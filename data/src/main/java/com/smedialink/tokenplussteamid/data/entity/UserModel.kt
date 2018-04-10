package com.smedialink.tokenplussteamid.data.entity

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class UserModel(
        @PrimaryKey
        var id: Int = 0,
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
        var realName: String? = "",
        @SerializedName("comments")
        var comments: RealmList<CommentModel> = RealmList()
) : RealmObject()
