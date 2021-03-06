package com.smedialink.tokenplussteamid.features.profile.entity

import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem

/**
 * Created by six_hundreds on 08.02.18.
 */
data class CommentProfileUiModel(val id: Int,
                                 val content: String,
                                 val rating: Int,
                                 val createdAt: Long,
                                 val authorName: String,
                                 val authorAvatar: String) : HeterogeneousItem {
    override fun getItemId(): Long = id.toLong()
}
