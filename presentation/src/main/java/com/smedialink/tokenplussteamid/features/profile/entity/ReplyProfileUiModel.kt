package com.smedialink.tokenplussteamid.features.profile.entity

import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem

/**
 * Created by six_hundreds on 30.03.18.
 */
data class ReplyProfileUiModel(val id: Int,
                               val content: String,
                               val rating: Int,
                               val createdAt: Long,
                               val authorId: Int,
                               val parentContent: String,
                               val parentId: Int) : HeterogeneousItem {
    override fun getItemId(): Long = id.toLong()

}