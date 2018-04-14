package com.smedialink.tokenplussteamid.mapper

import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.features.feed.entity.CommentFeedUiModel
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by six_hundreds on 29.01.18.
 */
class CommentFeedMapper @Inject constructor() : UiMapper<CommentFeedUiModel, Comment> {

    override fun mapToUi(input: Comment): CommentFeedUiModel =
            CommentFeedUiModel(
                    input.id,
                    input.content,
                    input.rating,
                    input.createdAt,
                    input.authorId,
                    input.userId)

}