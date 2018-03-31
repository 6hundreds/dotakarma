package com.smedialink.tokenplussteamid.mapper

import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.features.myprofile.entity.CommentProfileUiModel
import com.smedialink.tokenplussteamid.features.myprofile.entity.ReplyProfileUiModel
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by six_hundreds on 13.02.18.
 */
class CommentProfileMapper @Inject constructor() : Function<List<Comment>, List<HeterogeneousItem>> {

    override fun apply(input: List<Comment>): List<HeterogeneousItem> =
            input.map { comment ->
                comment.replyTo?.let {
                    ReplyProfileUiModel(
                            comment.id,
                            comment.content,
                            comment.rating,
                            comment.createdAt,
                            comment.authorId,
                            it.content,
                            it.id
                    )
                } ?: CommentProfileUiModel(
                        comment.id,
                        comment.content,
                        comment.rating,
                        comment.createdAt,
                        comment.authorId)

            }
}