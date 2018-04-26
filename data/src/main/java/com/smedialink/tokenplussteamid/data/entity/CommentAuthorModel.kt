package com.smedialink.tokenplussteamid.data.entity

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

/**
 * Created by six_hundreds on 26.04.18.
 */
open class CommentAuthorModel(
        @SerializedName("avatarmedium")
        var avatar: String = "",
        @SerializedName("personaname")
        var name: String = "")
    : RealmObject()