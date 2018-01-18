package com.smedialink.tokenplussteamid.entity

data class FeedComment(
    val id: Int,
    val content: String,
    val rating: Int,
    val createdAt: String,
    val updatedAt: String,
    val authorId: Int,
    val userId: Int
)
