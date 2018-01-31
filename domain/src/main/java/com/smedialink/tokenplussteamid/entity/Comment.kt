package com.smedialink.tokenplussteamid.entity

data class Comment(
    val id: Int,
    val content: String,
    val rating: Int,
    val createdAt: String,
    val updatedAt: String,
    val authorId: Int,
    val userId: Int
)
