package com.smedialink.tokenplussteamid.data.entity

data class FeedCommentModel(
    val id: Int,
    val content: String,
    val rating: Int,
    val createdAt: String,
    val updatedAt: String,
    val author_id: Int,
    val user_id: Int
)
