package com.smedialink.tokenplussteamid.features.feed.entity

import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem

/**
 * Created by six_hundreds on 28.01.18.
 */
data class CommentFeedUiModel(val id: Int,
                              val content: String,
                              val rating: Int,
                              val createdAt: Long,
                              val authorName: String,
                              val authorAvatar: String,
                              val userId: Int) : HeterogeneousItem {
    override fun getItemId(): Long = id.toLong()
}
