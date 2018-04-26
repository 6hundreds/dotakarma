package com.smedialink.tokenplussteamid.mapper

import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.features.profile.entity.CommentProfileUiModel
import com.smedialink.tokenplussteamid.features.profile.entity.ReplyProfileUiModel
import javax.inject.Inject

/**
 * Created by six_hundreds on 13.02.18.
 */
class CommentProfileMapper @Inject constructor() : UiMapper<HeterogeneousItem, Comment> {
    override fun mapToUi(input: Comment): HeterogeneousItem =
            input.replyTo?.let { parent ->
                ReplyProfileUiModel(
                        input.id,
                        input.content,
                        input.rating,
                        input.createdAt,
                        input.authorName,
                        input.authorAvatar,
                        parent.content,
                        parent.id
                )
            } ?: CommentProfileUiModel(
                    input.id,
                    input.content,
                    input.rating,
                    input.createdAt,
                    input.authorName,
                    input.authorAvatar)
}