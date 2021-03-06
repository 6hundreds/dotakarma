package com.smedialink.tokenplussteamid.entity

data class Comment(
        val id: Int,
        val content: String,
        val rating: Int,
        val createdAt: Long,
        val authorName: String,
        val authorAvatar: String,
        val userId: Int,
        val replyTo: Comment? = null
)
