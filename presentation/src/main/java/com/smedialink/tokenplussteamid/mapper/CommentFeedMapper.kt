package com.smedialink.tokenplussteamid.mapper

import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.features.feed.entity.CommentFeedUiModel
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by six_hundreds on 29.01.18.
 */
class CommentFeedMapper @Inject constructor() : Function<List<Comment>, List<CommentFeedUiModel>> {

    override fun apply(input: List<Comment>): List<CommentFeedUiModel> =
            input.map { comment ->
                CommentFeedUiModel(
                        comment.id,
                        comment.content,
                        comment.rating,
                        comment.createdAt,
                        comment.authorId,
                        comment.userId)
            }
}