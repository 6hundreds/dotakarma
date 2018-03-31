package com.smedialink.tokenplussteamid.features.myprofile.entity

import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem

/**
 * Created by six_hundreds on 30.03.18.
 */
data class ReplyProfileUiModel(val id: Int,
                               val content: String,
                               val rating: Int,
                               val createdAt: String,
                               val authorId: Int,
                               val parentContent: String,
                               val parentId: Int) : HeterogeneousItem