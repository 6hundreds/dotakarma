package com.smedialink.tokenplussteamid.data.entity

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class CommentModel(
        @PrimaryKey
        var id: Int = 0,
        @SerializedName("content")
        var content: String = "",
        @SerializedName("rating")
        var rating: Int = 0,
        @SerializedName("createdAt")
        var createdAt: Long = 0,
        @SerializedName("author")
        var author: CommentAuthorModel? = null,
        @SerializedName("user_id")
        var userId: Int = 0,
        @SerializedName("replyTo")
        var replyTo: CommentModel? = null
) : RealmObject()
