package com.smedialink.tokenplussteamid.mapper

import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.features.feed.entity.CommentUiModel
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by six_hundreds on 29.01.18.
 */
class CommentMapper @Inject constructor() : Function<List<Comment>, List<CommentUiModel>> {

    override fun apply(input: List<Comment>): List<CommentUiModel> =
            input.map { comment ->
                CommentUiModel(
                        comment.content,
                        comment.rating,
                        comment.createdAt,
                        comment.authorId,
                        comment.userId)
            }
}