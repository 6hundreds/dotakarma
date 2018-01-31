package com.smedialink.tokenplussteamid.data.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "comments")
data class CommentModel(
        @PrimaryKey
        var id: Int = 0,
        @SerializedName("content")
        var content: String = "",
        @SerializedName("rating")
        var rating: Int = 0,
        @SerializedName("createdAt")
        var createdAt: String = "",
        @SerializedName("updatedAt")
        var updatedAt: String = "",
        @SerializedName("author_id")
        var authorId: Int = 0,
        @SerializedName("user_id")
        var userId: Int = 0
)
