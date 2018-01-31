package com.smedialink.tokenplussteamid.features.feed.entity

import com.smedialink.tokenplussteamid.features.feed.adapter.FeedItem

/**
 * Created by six_hundreds on 28.01.18.
 */
data class CommentUiModel(
        val id: Int,
        val content: String,
        val rating: Int,
        val createdAt: String,
        val authorId: Int,
        val userId: Int
) : FeedItem()
