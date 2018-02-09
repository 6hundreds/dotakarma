package com.smedialink.tokenplussteamid.features.profile.entity

import com.smedialink.tokenplussteamid.common.HeterogeneousItem

/**
 * Created by six_hundreds on 08.02.18.
 */
data class CommentProfileUiModel(
        val id: Int,
        val content: String,
        val rating: Int,
        val createdAt: String,
        val authorId: Int) : HeterogeneousItem
