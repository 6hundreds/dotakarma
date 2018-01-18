package com.smedialink.tokenplussteamid.data.mapper

import com.smedialink.tokenplussteamid.data.entity.FeedCommentModel
import com.smedialink.tokenplussteamid.entity.FeedComment
import javax.inject.Inject

class FeedCommentMapper @Inject constructor() {

    fun transform(list: List<FeedCommentModel>): List<FeedComment> =
        list.map { comment ->
            FeedComment(
                id = comment.id,
                content = comment.content,
                rating = comment.rating,
                createdAt = comment.createdAt,
                updatedAt = comment.updatedAt,
                authorId = comment.author_id,
                userId = comment.user_id
            )
        }
            .toList()
}
